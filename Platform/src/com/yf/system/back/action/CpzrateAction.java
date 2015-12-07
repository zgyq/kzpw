/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;


import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.cpzrate.Cpzrate;


public class CpzrateAction extends B2b2cbackAction {
	private List <  Cpzrate  >  listCpzrate;
	private Cpzrate cpzrate = new Cpzrate();
	
	//批量操作ID数组
	private int[]selectid;
	private List<Cityairport> listCityairport;
	private List<Aircompany> listAircompany;
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
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询包机政策
	 */	
	public String execute()throws Exception{
		listCityairport=Server.getInstance().getAirService().findAllCityairport("", "", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("", "", -1, 0);
		String where = " where 1=1 ";
		if (se_departureport!=null && se_departureport.trim().length()!=0) {
			
			where += " and " + Zrate.COL_departureport +" like '%" + se_departureport.trim()+"%'";	
		}
		if (se_arrivalport!=null && se_arrivalport.trim().length()!=0) {
			
			where += " and " + Zrate.COL_arrivalport +" like '%" + se_arrivalport.trim()+"%'";	
		}
		if (se_issuedstartdate!=null && se_issuedstartdate.trim().length()!=0) {
			
			where += " and " + Zrate.COL_issuedstartdate +" >= '" + se_issuedstartdate.trim()+" 00:00:00'";	
		}
		if (se_issuedendate!=null && se_issuedendate.trim().length()!=0) {
			
			where += " and " + Zrate.COL_issuedendate +" <= '" + se_issuedendate.trim()+" 23:59:59'";	
		}
		if (se_aircompanycode!=null && se_aircompanycode.trim().length()!=0) {
			
			where += " and " + Zrate.COL_aircompanycode +" = '" + se_aircompanycode.trim()+"'";	
		}
		if (se_tickettype!=null && se_tickettype!=-1) {
			
			where += " and " + Zrate.COL_tickettype +" = " + se_tickettype;
		}
		if (se_flightnumber!=null && se_flightnumber.trim().length()!=0) {
			
			where += " and " + Zrate.COL_flightnumber +" like '%" + se_flightnumber.trim()+"%'";	
		}
		if (se_agentid!=null && se_agentid.trim().length()!=0) {
			
			where += " and C_AGENTID in (select ID from [T_CUSTOMERUSER] WHERE C_MEMBERNAME LIKE '%" + se_agentid.trim()+"%')";	
		}
	
	    List list = Server.getInstance().getAirService().findAllCpzrateForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCpzrate = list;
		  if(pageinfo.getTotalrow()>0 &&   listCpzrate.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllCpzrateForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCpzrate = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到包机政策添加页面
	 */	
	public String toadd()throws Exception{
		listCityairport=Server.getInstance().getAirService().findAllCityairport("", "", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到包机政策修改页面
	 */	
	public String toedit()throws Exception{
	cpzrate = Server.getInstance().getAirService().findCpzrate(cpzrate.getId());
	listCityairport=Server.getInstance().getAirService().findAllCityairport("", "", -1, 0);
	listAircompany=Server.getInstance().getAirService().findAllAircompany("", "", -1, 0);
	s_issuedstartdate=formatDate(cpzrate.getBegindate());
	s_issuedendate=formatDate(cpzrate.getEnddate());
		return EDIT;
	}
	
	/**
	 * 转向到包机政策审核页面
	 */	
	public String tocheck()throws Exception{
	cpzrate = Server.getInstance().getAirService().findCpzrate(cpzrate.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加包机政策
	 */		
	public String add()throws Exception{
	cpzrate.setCreateuser(getLoginUser().getLoginname());
		cpzrate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		cpzrate.setModifyuser(getLoginUser().getLoginname());
		cpzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		cpzrate.setBegindate(dateToTimestamp(s_issuedstartdate));
		cpzrate.setEnddate(dateToTimestamp(s_issuedendate));
		Server.getInstance().getAirService().createCpzrate(cpzrate);
		return LIST;
	}

	/**
	 * 审核包机政策
	 */		
	public String check()throws Exception{
	cpzrate.setModifyuser(getLoginUser().getLoginname());
		cpzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateCpzrateIgnoreNull(cpzrate);
		return LIST;
	}
	


	/**
	 * 编辑包机政策
	 */		
	public String edit()throws Exception{
	cpzrate.setModifyuser(getLoginUser().getLoginname());
		cpzrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		cpzrate.setBegindate(dateToTimestamp(s_issuedstartdate));
		cpzrate.setEnddate(dateToTimestamp(s_issuedendate));
		Server.getInstance().getAirService().updateCpzrateIgnoreNull(cpzrate);
		return LIST;
	}

	/**
	 * 删除包机政策
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteCpzrate(cpzrate.getId());
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
					Server.getInstance().getAirService().deleteCpzrate(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回包机政策对象
	 */		
	
	public Object getModel() {
		return cpzrate;
	}
	public List < Cpzrate >   getListCpzrate() {
		return listCpzrate;
	}
	public void setListCpzrate(List <  Cpzrate  >  listCpzrate) {
		this.listCpzrate = listCpzrate;
	}
	public Cpzrate getCpzrate() {
		return cpzrate;
	}
	public void setCpzrate(Cpzrate cpzrate) {
		this.cpzrate = cpzrate;
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
	
	
}