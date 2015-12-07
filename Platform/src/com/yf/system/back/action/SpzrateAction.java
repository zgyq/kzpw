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
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.policyperiod.Policyperiod;
import com.yf.system.base.spzrate.Spzrate;
import com.yf.system.base.util.PageInfo;


public class SpzrateAction extends B2b2cbackAction {
	private List <  Spzrate  >  listspzrate;
	private Spzrate spzrate = new Spzrate();
	
	
	
	private List<Cityairport> listCityairport;
	private List<Aircompany> listAircompany;
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String se_departureport;
	private String se_arrivalport;
	private String se_issuedstartdate;
	private String se_issuedendate;
	private String se_agentid;
	private String se_flightnumber;
	private String se_aircompanycode;
	private Integer se_tickettype;
	
	
	
	private String s_issuedstartdate;
	private String s_issuedendate;
	
	private String s_begindate;
	private String s_enddate;
	private Integer s_keepnum;
	private String s_flightnumber;
	
	
	private String s_spzratetype;
	
	
	public List<Spzrate> getlistspzrate() {
		return listspzrate;
	}
	public void setlistspzrate(List<Spzrate> listspzrate) {
		this.listspzrate = listspzrate;
	}
	public Spzrate getSpzrate() {
		return spzrate;
	}
	public void setSpzrate(Spzrate spzrate) {
		this.spzrate = spzrate;
	}
	public List<Cityairport> getListCityairport() {
		return listCityairport;
	}
	public void setListCityairport(List<Cityairport> listCityairport) {
		this.listCityairport = listCityairport;
	}
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}
	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public int getOpt() {
		return opt;
	}
	public void setOpt(int opt) {
		this.opt = opt;
	}
	public String getSe_departureport() {
		return se_departureport;
	}
	public void setSe_departureport(String se_departureport) {
		this.se_departureport = se_departureport;
	}
	public String getSe_arrivalport() {
		return se_arrivalport;
	}
	public void setSe_arrivalport(String se_arrivalport) {
		this.se_arrivalport = se_arrivalport;
	}
	public String getSe_issuedstartdate() {
		return se_issuedstartdate;
	}
	public void setSe_issuedstartdate(String se_issuedstartdate) {
		this.se_issuedstartdate = se_issuedstartdate;
	}
	public String getSe_issuedendate() {
		return se_issuedendate;
	}
	public void setSe_issuedendate(String se_issuedendate) {
		this.se_issuedendate = se_issuedendate;
	}
	public String getSe_agentid() {
		return se_agentid;
	}
	public void setSe_agentid(String se_agentid) {
		this.se_agentid = se_agentid;
	}
	public String getSe_flightnumber() {
		return se_flightnumber;
	}
	public void setSe_flightnumber(String se_flightnumber) {
		this.se_flightnumber = se_flightnumber;
	}
	public String getSe_aircompanycode() {
		return se_aircompanycode;
	}
	public void setSe_aircompanycode(String se_aircompanycode) {
		this.se_aircompanycode = se_aircompanycode;
	}
	public Integer getSe_tickettype() {
		return se_tickettype;
	}
	public void setSe_tickettype(Integer se_tickettype) {
		this.se_tickettype = se_tickettype;
	}
	public String getS_issuedstartdate() {
		return s_issuedstartdate;
	}
	public void setS_issuedstartdate(String s_issuedstartdate) {
		this.s_issuedstartdate = s_issuedstartdate;
	}
	public String getS_issuedendate() {
		return s_issuedendate;
	}
	public void setS_issuedendate(String s_issuedendate) {
		this.s_issuedendate = s_issuedendate;
	}
	public String getS_begindate() {
		return s_begindate;
	}
	public void setS_begindate(String s_begindate) {
		this.s_begindate = s_begindate;
	}
	public String getS_enddate() {
		return s_enddate;
	}
	public void setS_enddate(String s_enddate) {
		this.s_enddate = s_enddate;
	}
	public Integer getS_keepnum() {
		return s_keepnum;
	}
	public void setS_keepnum(Integer s_keepnum) {
		this.s_keepnum = s_keepnum;
	}
	public String getS_flightnumber() {
		return s_flightnumber;
	}
	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}
	public String getS_spzratetype() {
		return s_spzratetype;
	}
	public void setS_spzratetype(String s_spzratetype) {
		this.s_spzratetype = s_spzratetype;
	}
	/**
	 * 列表查询普通政策表
	 */	
	public String execute()throws Exception{
		listCityairport=Server.getInstance().getAirService().findAllCityairport("where "+Cityairport.COL_countrycode+"='CN'", "order by "+Cityairport.COL_airportcode+" ", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("where "+Aircompany.COL_countrycode+"='CN'", "order by "+Aircompany.COL_aircomcode+"", -1, 0);
		String where = " where 1=1 ";
		if (se_departureport!=null && se_departureport.trim().length()!=0) {
			
			where += " and " + Spzrate.COL_departureport +" like '%" + se_departureport.trim()+"%'";	
		}
		if (se_arrivalport!=null && se_arrivalport.trim().length()!=0) {
			
			where += " and " + Spzrate.COL_arrivalport +" like '%" + se_arrivalport.trim()+"%'";	
		}
		if (se_issuedstartdate!=null && se_issuedstartdate.trim().length()!=0) {
			
			where += " and " + Spzrate.COL_issuedstartdate +" >= '" + se_issuedstartdate.trim()+" 00:00:00'";	
		}
		if (se_issuedendate!=null && se_issuedendate.trim().length()!=0) {
			
			where += " and " + Spzrate.COL_issuedendate +" <= '" + se_issuedendate.trim()+" 23:59:59'";	
		}
		if (se_aircompanycode!=null && se_aircompanycode.trim().length()!=0) {
			
			where += " and " + Spzrate.COL_aircompanycode +" = '" + se_aircompanycode.trim()+"'";	
		}
		if (se_tickettype!=null && se_tickettype!=-1) {
			
			where += " and " + spzrate.COL_tickettype+" = " + se_tickettype;
		}
		if (se_flightnumber!=null && se_flightnumber.trim().length()!=0) {
			
			where += " and " + spzrate.COL_flightnumber +" like '%" + se_flightnumber.trim()+"%'";	
		}
		if (se_agentid!=null && se_agentid.trim().length()!=0) {
			
			where += " and C_AGENTID in (select ID from [T_CUSTOMERUSER] WHERE C_MEMBERNAME LIKE '%" + se_agentid.trim()+"%')";	
		}
	
	    List list = Server.getInstance().getAirService().findAllSpzrateForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listspzrate = list;
		  if(pageinfo.getTotalrow()>0 &&   listspzrate.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllSpzrateForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listspzrate = list;
		}
		 System.out.println(listspzrate.size());
		return SUCCESS;
	}
	/**
	 * 转向到普通政策表添加页面
	 */	
	public String toadd()throws Exception{
		listCityairport=Server.getInstance().getAirService().findAllCityairport("where "+Cityairport.COL_countrycode+"='CN'", "order by "+Cityairport.COL_airportcode+" ", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("where "+Aircompany.COL_countrycode+"='CN'", "order by "+Aircompany.COL_aircomcode+"", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到普通政策表修改页面
	 */	
	public String toedit()throws Exception{

		listCityairport=Server.getInstance().getAirService().findAllCityairport("where "+Cityairport.COL_countrycode+"='CN'", "order by "+Cityairport.COL_airportcode+" ", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("where "+Aircompany.COL_countrycode+"='CN'", "order by "+Aircompany.COL_aircomcode+"", -1, 0);
		spzrate = Server.getInstance().getAirService().findSpzrate(spzrate.getId());
		if(spzrate.getOutpattern().equals("1"))
		{
			s_keepnum=spzrate.getMoneykeep();
		}else
		{
			s_keepnum=spzrate.getPointkeep();
		}
		if(spzrate.getType()==1)
		{
			s_flightnumber=spzrate.getFlightnumber();
		}else if(spzrate.getType()==2)
		{
			s_flightnumber=spzrate.getWeeknum();
		}
		if(spzrate.getZratetype()!=null&&spzrate.getZratetype()>0)
		{
			String fromcitystr=spzrate.getDepartureport();
			String tocitystr=spzrate.getArrivalport();
			spzrate.setArrivalport(fromcitystr);
			spzrate.setDepartureport(tocitystr);
		}
		s_issuedstartdate=formatDate(spzrate.getIssuedstartdate());
		s_issuedendate=formatDate(spzrate.getIssuedendate());
		Policyperiod policyperiod=new Policyperiod();
		String where=" WHERE "+Policyperiod.COL_policyguid+" = "+spzrate.getId();
		List<Policyperiod> list=Server.getInstance().getAirService().findAllPolicyperiod(where, "", -1, 0);
		if(list!=null&&list.size()>0)
		{
			policyperiod=list.get(0);
			s_begindate=formatDate(policyperiod.getBegindate());
			s_enddate=formatDate(policyperiod.getEnddate());
		}
		return EDIT;
	}
	
	/**
	 * 转向到普通政策表审核页面
	 */	
	public String tocheck()throws Exception{
		spzrate = Server.getInstance().getAirService().findSpzrate(spzrate.getId());
		if (spzrate.getIsenable() == 1) {
			spzrate.setIsenable(0);
		} else {
			spzrate.setIsenable(1);
		}
		Server.getInstance().getAirService().updateSpzrateIgnoreNull(spzrate);
		return "list1";
	}
	
	
	/**
	 * 添加普通政策表
	 */		
	public String add()throws Exception{
		
		if(spzrate.getZratetype()!=null&&spzrate.getZratetype()>0)
		{
			String fromcitystr=spzrate.getDepartureport();
			String tocitystr=spzrate.getArrivalport();
			spzrate.setArrivalport(fromcitystr);
			spzrate.setDepartureport(tocitystr);
		}
		spzrate.setIssuedstartdate(dateToTimestamp(s_issuedstartdate));
		spzrate.setIssuedendate(dateToTimestamp(s_issuedendate));
		spzrate.setCreateuser(getLoginUser().getLoginname());
		spzrate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		spzrate.setModifyuser(getLoginUser().getLoginname());
		spzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		spzrate.setRelationspzrateid(0l);
		
		spzrate.setAgentid(getLoginUser().getAgentid());
		//此处添加的是供应商的卡号 供应商没有编号
		//spzrate.setAgentcode(getLoginUser().getCardnumber());
		if(spzrate.getType()==1)
		{
			spzrate.setFlightnumber(s_flightnumber);
		}else if(spzrate.getType()==2)
		{
			spzrate.setWeeknum(s_flightnumber);
		}
		spzrate.setLanguage(0);
		spzrate=Server.getInstance().getAirService().createSpzrate(spzrate);
		
		
		//添加政策有效期表
		Policyperiod policyperiod=new Policyperiod();
		policyperiod.setBegindate(dateToTimestamp(s_begindate));
		policyperiod.setEnddate(dateToTimestamp(s_enddate));
		policyperiod.setCreateuser(getLoginUser().getLoginname());
		policyperiod.setCreatetime(new Timestamp(System.currentTimeMillis()));
		policyperiod.setModifyuser(getLoginUser().getLoginname());
		policyperiod.setModifytime(new Timestamp(System.currentTimeMillis()));
		policyperiod.setIsenable(0);
		policyperiod.setPolicyguid(spzrate.getId());
		policyperiod.setPolicyguid(spzrate.getId());
		policyperiod.setLanguage(0);
		Server.getInstance().getAirService().createPolicyperiod(policyperiod);
		
		return LIST;
	}

	/**
	 * 审核普通政策表
	 */		
	
	public String check()throws Exception{
	spzrate.setModifyuser(getLoginUser().getLoginname());
		spzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateSpzrateIgnoreNull(spzrate);
		return LIST;
	}
	


	/**
	 * 编辑普通政策表
	 */		
	public String edit()throws Exception{
		if(spzrate.getZratetype()!=null&&spzrate.getZratetype()>0)
		{
			String fromcitystr=spzrate.getDepartureport();
			String tocitystr=spzrate.getArrivalport();
			spzrate.setArrivalport(fromcitystr);
			spzrate.setDepartureport(tocitystr);
		}
		spzrate.setIssuedstartdate(dateToTimestamp(s_issuedstartdate));
		spzrate.setIssuedendate(dateToTimestamp(s_issuedendate));
		if(spzrate.getType()==1)
		{
			spzrate.setFlightnumber(s_flightnumber);
		}else if(spzrate.getType()==2)
		{
			spzrate.setWeeknum(s_flightnumber);
		}
		spzrate.setModifyuser(getLoginUser().getLoginname());
		spzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateSpzrateIgnoreNull(spzrate);
		
		//修改有效期时间
		Policyperiod policyperiod=new Policyperiod();
		String where=" WHERE "+Policyperiod.COL_policyguid+" = "+spzrate.getId();
		List<Policyperiod> list=Server.getInstance().getAirService().findAllPolicyperiod(where, "", -1, 0);
		if(list!=null&&list.size()>0)
		{
			policyperiod=list.get(0);
			policyperiod.setBegindate(dateToTimestamp(s_begindate));
			policyperiod.setEnddate(dateToTimestamp(s_enddate));
			Server.getInstance().getAirService().updatePolicyperiod(policyperiod);
		}
		
		return LIST;
	}

	/**
	 * 获取出票日期
	 * @param id
	 * @return
	 */
	public String getpolicyperioddate(long id)
	{
		String where=" WHERE "+Policyperiod.COL_policyguid+" = "+id;
		List<Policyperiod> list=Server.getInstance().getAirService().findAllPolicyperiod(where, "", -1, 0);
		if(list!=null&&list.size()>0)
		{
			Policyperiod policyperiod=list.get(0);
			s_begindate=formatDate(policyperiod.getBegindate());
			s_enddate=formatDate(policyperiod.getEnddate());
		}
		return s_begindate+"至"+s_enddate;
	}
	/**
	 * 删除普通政策表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteSpzrate(spzrate.getId());
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
					Server.getInstance().getAirService().deleteSpzrate(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	public Object getModel() {
		// TODO Auto-generated method stub
		return spzrate;
	}






	/**
	 *  返回普通政策表对象
	 */		
	
	
}