/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.supteam.Supteam;
import com.yf.system.base.teamapply.Teamapply;
import com.yf.system.base.util.PageInfo;


public class TeamapplyAction extends B2b2cbackAction {
	private List <  Teamapply  >  listTeamapply;
	private Teamapply teamapply = new Teamapply();
	private List <  Aircompany  >  listAircompany;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private String starttime2;
	
	//search
	//private String s_name;
	private long teamapplyid;
	private long supteamid;
	private long chen;
	private String baoxian;
	//
	private Orderinfo orderinfo = new Orderinfo();
	private Passenger passenger = new Passenger();
	private Segmentinfo segmentinfo = new Segmentinfo();
	private String h_ptype;
	private String h_name;
	private String h_idtype;
	private String h_idnumber;
	//
	private String lianxiren;
	private String shouji;
	private String youxiang;
	
	//
	/**
	 * 列表查询团队申请表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 and "+Teamapply.COL_typeid+" ="+getLoginUser().getAgentid();
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Teamapply.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllTeamapplyForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTeamapply = list;
		  if(pageinfo.getTotalrow()>0 &&   listTeamapply.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllTeamapplyForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTeamapply = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 列表查询团队申请表
	 */	
	public String toall()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Teamapply.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllTeamapplyForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTeamapply = list;
		  if(pageinfo.getTotalrow()>0 &&   listTeamapply.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllTeamapplyForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTeamapply = list;
		}
		
		return "toall";
	}
	
	/**
	 * 转向到团队申请表添加页面
	 */	
	public String toadd()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		return EDIT;
	}

	public String addorder()throws Exception{//如果是往返应该创建2个订单..目前还没实现...注意添加燃油.基建
		
		String[] h_names = h_name.trim().split(",");
		String[] h_ptypes = h_ptype.trim().split(",");
		String[] h_idtypes = h_idtype.trim().split(",");
		String[] h_idnumbers = h_idnumber.trim().split(",");
		String[] h_baoxian = baoxian.trim().split(",");
		
		teamapply = Server.getInstance().getAirService().findTeamapply(teamapplyid);
		supteam = Server.getInstance().getAirService().findSupteam(supteamid);
		
		orderinfo.setBuyagentid(getLoginUser().getAgentid());
		orderinfo.setCustomeruserid(getLoginUser().getId());
		
		//orderinfo.setInsurance(baoxian);
		Float b = Float.parseFloat(supteam.getOffer().toString()); 
		orderinfo.setTotalticketprice(b);
		orderinfo.setTotalairportfee(0f);
		orderinfo.setTotalfuelfee(0f);
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinfo.setSaleagentid(supteam.getSupplierid());
		orderinfo.setTotalairportfee(0f);
		orderinfo.setTotalfuelfee(0f);
		//Float zhe = Float.parseFloat(supteam.get); 
		//orderinfo.setRatevalue(lf);
		orderinfo.setPaystatus(0);
		orderinfo.setLanguage(0);
		orderinfo.setOrderstatus(1);
		orderinfo.setOrdertype(4l);
		orderinfo.setContactemail(youxiang);
		orderinfo.setContactmobile(shouji);
		orderinfo.setContactname(lianxiren);
		orderinfo = Server.getInstance().getAirService().createOrderinfo(orderinfo);
		orderinfo.setOrdernumber(Server.getInstance().getServiceCenter().getOrderinfoCode(orderinfo));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		segmentinfo.setOrderid(orderinfo.getId());
		segmentinfo.setLanguage(0);
		segmentinfo.setStartairport(teamapply.getStartcity());
		segmentinfo.setEndairport(teamapply.getEndcity());
		segmentinfo.setAircomapnycode(teamapply.getCa());
		segmentinfo.setFlightnumber(teamapply.getFlightnumber());
		segmentinfo.setTraveltype((Integer)teamapply.getFlighttype().intValue());
		segmentinfo.setPrice(b);
		segmentinfo.setStartairport(teamapply.getStartcity());
		segmentinfo.setEndairport(teamapply.getEndcity());
		segmentinfo.setDeparttime(teamapply.getStarttime());
		segmentinfo = Server.getInstance().getAirService()
				.createSegmentinfo(segmentinfo);
		
		for (int i = 0; i < h_names.length; i++) {
			if(h_names[i].trim().length()>0)
			{
			passenger = new Passenger();
			passenger.setPtype(Integer.parseInt(h_ptypes[i].trim()));
			passenger.setName(h_names[i]);
			passenger.setIdtype(Integer.parseInt(h_idtypes[i].trim()));
			passenger.setIdnumber(h_idnumbers[i].trim());
			passenger.setOrderid(orderinfo.getId());
			passenger.setFet(segmentinfo.getId() + "");
			//passenger.setFuelprice(segmentinfo.getFuelfee());
			//passenger.setAirportfee(segmentinfo.getAirportfee());
			//passenger.setDiscount(segmentinfo.getDiscount());
			//passenger.setPrice(segmentinfo.getPrice());
			passenger.setState(0);
			passenger.setLanguage(0);
			int ba = Integer.parseInt(h_baoxian[i].trim());
			
			passenger = Server.getInstance().getAirService()
					.createPassenger(passenger);
			
			}
		}
		
		return LIST;
	}
	/**
	 * 转向到团队申请表添加页面
	 */	
	private Supteam supteam = new Supteam();
	public String toorderinfo()throws Exception{
		teamapply = Server.getInstance().getAirService().findTeamapply(teamapplyid);
		supteam = Server.getInstance().getAirService().findSupteam(supteam.getId());
		if(teamapply.getNumberpeople()!=null&&teamapply.getNumberpeople()>0){
		chen = teamapply.getNumberpeople();
		}else{
			chen = 1;
		}
		
		return "toorderinfo";
	}
	/**
	 * 转向到团队申请表修改页面
	 */	
	public String toedit()throws Exception{
	teamapply = Server.getInstance().getAirService().findTeamapply(teamapply.getId());
	listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
	
		return EDIT;
	}
	/**
	 * 转向到团队申请表查看页面
	 */	
	public String tokan()throws Exception{
	teamapply = Server.getInstance().getAirService().findTeamapply(teamapply.getId());
	listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
	
		return "tokan";
	}
	
	/**
	 * 转向到团队申请表审核页面
	 */	
	public String tocheck()throws Exception{
	teamapply = Server.getInstance().getAirService().findTeamapply(teamapply.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加团队申请表
	 */		
	public String add()throws Exception{
		teamapply.setCreateuser(getLoginUser().getLoginname());
		teamapply.setCreatetime(new Timestamp(System.currentTimeMillis()));
		java.text.SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(starttime2);
		teamapply.setStarttime(new Timestamp(date.getTime()));
		teamapply.setTypeid(getLoginUser().getAgentid());
		teamapply.setStatus(0l);//0.分销商新创建 1.分销商发布 2.分销商关闭 3.
		Server.getInstance().getAirService().createTeamapply(teamapply);
		return LIST;
	}

	/**
	 * 审核团队申请表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateTeamapplyIgnoreNull(teamapply);
		return LIST;
	}
	


	/**
	 * 编辑团队申请表
	 */		
	public String edit()throws Exception{
		teamapply.setStartcity(teamapply.getStartcity());
		teamapply.setEndcity(teamapply.getEndcity());
		Server.getInstance().getAirService().updateTeamapplyIgnoreNull(teamapply);
		return LIST;
	}

	/**
	 * 删除团队申请表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteTeamapply(teamapply.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getAirService().deleteTeamapply(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	//0.分销商新创建 1.分销商发布 2.分销商关闭 3.
	public String getteamapplystatus(Integer id) {
		switch (id) {
		case 0:

			return "新创建";

		case 1:

			return "已发布";

		case 2:

			return "已关闭";
		
		default:
			return "未知状态";
		}
	}

	//0,供应商刚刚创建  1.分销商选中
	public String getsupteamstatus(Integer id) {
		switch (id) {
		case 0:

			return "新创建";

		case 1:

			return "已选中";

		case 2:

			return "已关闭";
		
		default:
			return "未知状态";
		}
	}


	/**
	 *  返回团队申请表对象
	 */		
	
	public Object getModel() {
		return teamapply;
	}
	public List < Teamapply >   getListTeamapply() {
		return listTeamapply;
	}
	public void setListTeamapply(List <  Teamapply  >  listTeamapply) {
		this.listTeamapply = listTeamapply;
	}
	public Teamapply getTeamapply() {
		return teamapply;
	}
	public void setTeamapply(Teamapply teamapply) {
		this.teamapply = teamapply;
	}
	
	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}
	public String getStarttime2() {
		return starttime2;
	}
	public void setStarttime2(String starttime2) {
		this.starttime2 = starttime2;
	}
	public long getTeamapplyid() {
		return teamapplyid;
	}
	public void setTeamapplyid(long teamapplyid) {
		this.teamapplyid = teamapplyid;
	}
	public long getSupteamid() {
		return supteamid;
	}
	public void setSupteamid(long supteamid) {
		this.supteamid = supteamid;
	}
	public Supteam getSupteam() {
		return supteam;
	}
	public void setSupteam(Supteam supteam) {
		this.supteam = supteam;
	}
	public long getChen() {
		return chen;
	}
	public void setChen(long chen) {
		this.chen = chen;
	}
	public String getBaoxian() {
		return baoxian;
	}
	public void setBaoxian(String baoxian) {
		this.baoxian = baoxian;
	}
	public Orderinfo getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}
	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
	}
	public String getH_ptype() {
		return h_ptype;
	}
	public void setH_ptype(String h_ptype) {
		this.h_ptype = h_ptype;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_idtype() {
		return h_idtype;
	}
	public void setH_idtype(String h_idtype) {
		this.h_idtype = h_idtype;
	}
	public String getH_idnumber() {
		return h_idnumber;
	}
	public void setH_idnumber(String h_idnumber) {
		this.h_idnumber = h_idnumber;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getShouji() {
		return shouji;
	}
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}


	
	
}