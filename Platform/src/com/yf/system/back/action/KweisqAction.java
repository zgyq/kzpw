/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.kweifabu.Kweifabu;
import com.yf.system.base.kweisq.Kweisq;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;


public class KweisqAction extends B2b2cbackAction {
	private List <  Kweisq  >  listKweisq;
	private Kweisq kweisq = new Kweisq();
	private Kweifabu kweifabu = new Kweifabu();
	private List <  Aircompany  >  listAircompany;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private int kid;//K位信息id
	private long ksid;//K位申请id
	private long sid;
	//search
	//private String s_name;
	
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
	private String baoxian;
	/**
	 * 列表查询K位特价申请表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Kweisq.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listKweisq = list;
		  if(pageinfo.getTotalrow()>0 &&   listKweisq.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listKweisq = list;
		}
		
		return SUCCESS;
	}
	public String tomy()throws Exception{
		String where = " where 1=1 and "+Kweisq.COL_distributorid+" ="+getLoginUser().getAgentid();
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Kweisq.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listKweisq = list;
		  if(pageinfo.getTotalrow()>0 &&   listKweisq.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listKweisq = list;
		}
		
		return SUCCESS;
	}
	public String toshenq()throws Exception{//供应商看见自己的K位申请单
		String where = " where 1=1 and "+Kweisq.COL_angenid+" ="+getLoginUser().getAgentid();
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Kweisq.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listKweisq = list;
		  if(pageinfo.getTotalrow()>0 &&   listKweisq.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllKweisqForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listKweisq = list;
		}
		
		return "toshenq";
	}
	public String togoumai()throws Exception{//供应商看见自己的K位申请单
		kweisq = Server.getInstance().getAirService().findKweisq(ksid);
		kweifabu = Server.getInstance().getAirService().findKweifabu(kid);
		
		return "togoumai";
	}
	public String toinfo()throws Exception{
		kweisq = Server.getInstance().getAirService().findKweisq(ksid);
		kweifabu = Server.getInstance().getAirService().findKweifabu(kid);
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		
		return "toinfo";
	}
public String addorder()throws Exception{
		
		String[] h_names = h_name.trim().split(",");
		String[] h_ptypes = h_ptype.trim().split(",");
		String[] h_idtypes = h_idtype.trim().split(",");
		String[] h_idnumbers = h_idnumber.trim().split(",");
		String[] h_baoxian = baoxian.trim().split(",");
		
		kweisq = Server.getInstance().getAirService().findKweisq(ksid);
		kweifabu = Server.getInstance().getAirService().findKweifabu(kid);
		
		orderinfo.setBuyagentid(getLoginUser().getAgentid());
		orderinfo.setCustomeruserid(getLoginUser().getId());
		
		//orderinfo.setInsurance(baoxian);
		
		Double p=	kweifabu.getNominalprice();
		Float b = Float.parseFloat(p.toString()); 
		orderinfo.setTotalticketprice(b);
		orderinfo.setTotalairportfee(0f);
		orderinfo.setTotalfuelfee(0f);
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinfo.setSaleagentid(kweifabu.getAngenid());
		orderinfo.setPaystatus(0);
		orderinfo.setLanguage(0);
		orderinfo.setOrderstatus(1);
		orderinfo.setTotalairportfee(0f);
		orderinfo.setTotalfuelfee(0f);
		orderinfo.setOrdertype(5l);
		Float zhe = Float.parseFloat(kweifabu.getDiscount().trim()); 
		orderinfo.setRatevalue(zhe);
		
		orderinfo.setContactemail(youxiang);
		orderinfo.setContactmobile(shouji);
		orderinfo.setContactname(lianxiren);
		orderinfo = Server.getInstance().getAirService().createOrderinfo(orderinfo);
		orderinfo.setOrdernumber(Server.getInstance().getServiceCenter().getOrderinfoCode(orderinfo));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		segmentinfo.setOrderid(orderinfo.getId());
		segmentinfo.setLanguage(0);
		segmentinfo.setStartairport(kweifabu.getStartcity());
		segmentinfo.setEndairport(kweifabu.getEndcity());
		segmentinfo.setAircomapnycode(kweifabu.getCa());
		segmentinfo.setFlightnumber(kweifabu.getFlightnumber());
		segmentinfo.setTraveltype((Integer)kweifabu.getFlighttype().intValue());
		segmentinfo.setPrice(b);
		segmentinfo.setStartairport(kweifabu.getStartcity());
		segmentinfo.setEndairport(kweifabu.getEndcity());
		segmentinfo.setDeparttime(kweifabu.getStarttime());
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
		
		return "addorder";
	}
	/**
	 * 转向到K位特价申请表添加页面
	 */	
	public String toadd()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		
		return EDIT;
	}
	/**
	 * 转向到K位特价申请表修改页面
	 */	
	public String toedit()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		kweisq = Server.getInstance().getAirService().findKweisq(kweisq.getId());
		return EDIT;
	}
	/**
	 * 
	 */	
	public String tochakan()throws Exception{
		listAircompany = Server.getInstance().getAirService().findAllAircompany("where 1=1 ", "", -1, 0);
		kweisq = Server.getInstance().getAirService().findKweisq(kweisq.getId());
		kweifabu = Server.getInstance().getAirService().findKweifabu(kweisq.getKweiid());
		return "chakan";
	}
	/**
	 * 转向到K位特价申请表审核页面
	 */	
	public String tocheck()throws Exception{
	kweisq = Server.getInstance().getAirService().findKweisq(kweisq.getId());
	
	

		
		kweisq.setStatus(sid);
		
		Server.getInstance().getAirService().updateKweisqIgnoreNull(kweisq);
		// 获取前一页面路径
		//forward = ServletActionContext.getRequest().getHeader("Referer");
	
	
		return CHECK;
	}
	
	
	/**
	 * 添加K位特价申请表
	 */		
	public String add()throws Exception{
		kweifabu = Server.getInstance().getAirService().findKweifabu(kid);
		kweisq.setCreatetime(new Timestamp(System.currentTimeMillis()));
		kweisq.setCreateuser(getLoginUser().getLoginname());
		kweisq.setDistributorid(getLoginUser().getAgentid());
		kweisq.setStatus(1l);//1。待审核2。审核通过3。审核不通过
		if(kweifabu.getAngenid()!=null){
		kweisq.setAngenid(kweifabu.getAngenid());
		}
		kweisq.setKweiid(kweifabu.getId());
		Server.getInstance().getAirService().createKweisq(kweisq);
		return LIST;
	}

	/**
	 * 审核K位特价申请表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateKweisqIgnoreNull(kweisq);
		return LIST;
	}
	


	/**
	 * 编辑K位特价申请表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateKweisqIgnoreNull(kweisq);
		return LIST;
	}

	/**
	 * 删除K位特价申请表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteKweisq(kweisq.getId());
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
					Server.getInstance().getAirService().deleteKweisq(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回K位特价申请表对象
	 */		
	
	public Object getModel() {
		return kweisq;
	}
	public List < Kweisq >   getListKweisq() {
		return listKweisq;
	}
	public void setListKweisq(List <  Kweisq  >  listKweisq) {
		this.listKweisq = listKweisq;
	}
	public Kweisq getKweisq() {
		return kweisq;
	}
	public void setKweisq(Kweisq kweisq) {
		this.kweisq = kweisq;
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
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public Kweifabu getKweifabu() {
		return kweifabu;
	}
	public void setKweifabu(Kweifabu kweifabu) {
		this.kweifabu = kweifabu;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public long getKsid() {
		return ksid;
	}
	public void setKsid(long ksid) {
		this.ksid = ksid;
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
	public String getBaoxian() {
		return baoxian;
	}
	public void setBaoxian(String baoxian) {
		this.baoxian = baoxian;
	}
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}
	
	
}