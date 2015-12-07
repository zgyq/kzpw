/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.service.ZrateServer;
import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.optrecord.Optrecord;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.zrate.Zrate;


public class ZrateAction extends B2b2cbackAction {
	private List <  Zrate  >  listZrate;
	private Zrate zrate = new Zrate();
	
	
	
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
	
	private String s_ezm;
	// 批量导入政策数组
	private File[] batchfile;
	
	
	private List<Optrecord> listOptrecord;
	
	
	
	//重选政策
	//普通政策列表
	private List<Zrate> listgrate;
	//特殊政策列表
	private List<Zrate> listsrate;
	//订单id
	private long orderid;
	
	
	
	
	
	public String getS_ezm() {
		return s_ezm;
	}
	public File[] getBatchfile() {
		return batchfile;
	}
	public void setBatchfile(File[] batchfile) {
		this.batchfile = batchfile;
	}
	public void setS_ezm(String s_ezm) {
		this.s_ezm = s_ezm;
	}
	public String getS_flightnumber() {
		return s_flightnumber;
	}
	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}
	public Integer getS_keepnum() {
		return s_keepnum;
	}
	public void setS_keepnum(Integer s_keepnum) {
		this.s_keepnum = s_keepnum;
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
	/**
	 * 列表查询普通政策表
	 */	
	public String execute()throws Exception{
		listCityairport=Server.getInstance().getAirService().findAllCityairport("where "+Cityairport.COL_countrycode+"='CN'", "order by "+Cityairport.COL_airportcode+" ", -1, 0);
		listAircompany=Server.getInstance().getAirService().findAllAircompany("where "+Aircompany.COL_countrycode+"='CN'", "order by "+Aircompany.COL_aircomcode+"", -1, 0);
		String where = " ";
		
		if(getLoginUser().getAgentid()!=46){
			
			where +=" and "+Zrate.COL_agentid+" ="+getLoginUser().getAgentid();
		}
		where+=" AND "+Zrate.COL_agentid+" >10";
		
		if(zrate.getIstype()==null ||zrate.getIstype()==0)
		{
			where += " and ( "+Zrate.COL_istype+" = 0 or "+Zrate.COL_istype+" is NULL ) ";
		}else
		{
			where += " and "+Zrate.COL_istype+" = 1 ";
			
		}
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
		
		System.out.println(where);
		List list =Server.getInstance().getAirService().findAllZrateBySP("T_ZRATE", "*", "ID", 1, where, "ID", pageinfo);
		List list2 =Server.getInstance().getAirService().findAllZrateBySP("T_ZRATE", "*", "ID", 1, where, "ID", pageinfo);
	    //List list = Server.getInstance().getAirService().findAllZrateForPageinfo(where," ORDER BY ID DESC",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listZrate = list;
		  if(pageinfo.getTotalrow()>0 &&   listZrate.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllZrateBySP("T_ZRATE", "*", "ID", 1, where, "ID", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listZrate = list;
		}
		
		return SUCCESS;
	}
	
	
	public String tochangerate()throws Exception{
		
		System.out.println("changerate");
		
		return "changerate";
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
		zrate = Server.getInstance().getAirService().findZrateByDB(zrate.getId());
	/*	if(zrate.getType()!=null && zrate.getType()==1)
		{
			s_flightnumber=zrate.getFlightnumber();
		}else if(zrate.getType()!=null && zrate.getType()==2)
		{
			s_flightnumber=zrate.getWeeknum();
		}*/
		
		if(zrate.getZratetype()!=null&&zrate.getZratetype()>0)
		{
			String fromcitystr=zrate.getDepartureport();
			String tocitystr=zrate.getArrivalport();
			zrate.setArrivalport(fromcitystr);
			zrate.setDepartureport(tocitystr);
		}
		s_issuedstartdate=formatDate(zrate.getIssuedstartdate());
		s_issuedendate=formatDate(zrate.getIssuedendate());
		s_begindate=formatDate(zrate.getBegindate());
		s_enddate=formatDate(zrate.getEnddate());
		return EDIT;
	}
	
	/**
	 * 转向到普通政策表审核页面
	 */	
	public String tocheck()throws Exception{
		zrate = Server.getInstance().getAirService().findZrateByDB(zrate.getId());
		if (zrate.getIsenable() == 1) {
			zrate.setIsenable(0);
		} else {
			zrate.setIsenable(1);
		}
		Server.getInstance().getAirService().updateZrateIgnoreNull(zrate);
		return "list1";
	}
	
	
	/**
	 * 添加普通政策表
	 */		
	public String add()throws Exception{
		
		if(zrate.getZratetype()!=null&&zrate.getZratetype()>0)
		{
			String fromcitystr=zrate.getDepartureport();
			String tocitystr=zrate.getArrivalport();
			zrate.setArrivalport(fromcitystr);
			zrate.setDepartureport(tocitystr);
		}
		zrate.setIssuedstartdate(dateToTimestamp(s_issuedstartdate));
		zrate.setIssuedendate(dateToTimestamp(s_issuedendate));
		zrate.setCreateuser(getLoginUser().getLoginname());
		zrate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		zrate.setModifyuser(getLoginUser().getLoginname());
		zrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		zrate.setRelationzrateid(0l);
		zrate.setIstype(0l);
		zrate.setAgentid(getLoginUser().getAgentid());
		//此处添加的是供应商的卡号 供应商没有编号
//		zrate.setAgentcode(getLoginUser().getCardnumber());
	/*	if(zrate.getType()==1)
		{
			zrate.setFlightnumber(s_flightnumber);
		}else if(zrate.getType()==2)
		{
			zrate.setWeeknum(s_flightnumber);
		}*/
		zrate.setBegindate(dateToTimestamp(s_begindate));
		zrate.setEnddate(dateToTimestamp(s_enddate));
		
		zrate.setZtype(zrate.getGeneral().toString());//政策类型  普通  高反
		
		zrate.setOnetofiveaftertime(zrate.getAfterworktime());
		zrate.setOnetofiveworktime(zrate.getWorktime());
		zrate.setWeekendaftertime(zrate.getAfterworktime());
		zrate.setWeekendworktime(zrate.getWorktime());
		
		zrate.setWeekendwastetime(zrate.getWorktime()+"|"+zrate.getAfterworktime());
		zrate.setOnetofivewastetime(zrate.getWorktime()+"|"+zrate.getAfterworktime());
		zrate.setUsertype("1");
		zrate.setLanguage(0);
		zrate.setIsenable(1);
		
		 String outid=new Timestamp(System.currentTimeMillis())+"";
		 outid=outid.replaceAll("-", "");
		 outid=outid.replaceAll(":", "");
		 outid=outid.replaceAll(" ", "");
		 outid=outid.replace(".", "");
		zrate.setOutid(outid);
		zrate=Server.getInstance().getAirService().createZrate(zrate);
		
		//ZrateServer.getInstance().createZrate(zrate);//创建缓存
		
	//	zrate.setOutid(zrate.getId()+"");
	//	Server.getInstance().getAirService().updateZrateIgnoreNull(zrate);
		return LIST;
	}

	/**
	 * 审核普通政策表
	 */		
	
	public String check()throws Exception{
		//zrate=Server.getInstance().getAirService().findZrate(zrate.getId());
		zrate=Server.getInstance().getAirService().findZrateByDB(zrate.getId());
		zrate.setModifyuser(getLoginUser().getLoginname());
		zrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		if(zrate.getIsenable()==0){
			zrate.setIsenable(1);
		}else{
			
			zrate.setIsenable(0);
		}
		
		Server.getInstance().getAirService().updateZrateIgnoreNull(zrate);
		
		Zrate rate = ZrateServer.getInstance().findZrate(zrate.getAgentid(), "*$"+zrate.getOutid());
		if(rate!=null){
		ZrateServer.getInstance().deleteZrate(rate);
		}
		zrate.setId(rate.getId());
		ZrateServer.getInstance().createZrate(zrate);//创建缓存
		return LIST;
	}
	


	/**
	 * 编辑普通政策表
	 */		
	public String edit()throws Exception{
		
		
		if(zrate.getZratetype()!=null&&zrate.getZratetype()>0)
		{
			String fromcitystr=zrate.getDepartureport();
			String tocitystr=zrate.getArrivalport();
			zrate.setArrivalport(fromcitystr);
			zrate.setDepartureport(tocitystr);
		}
		zrate.setIssuedstartdate(dateToTimestamp(s_issuedstartdate));
		zrate.setIssuedendate(dateToTimestamp(s_issuedendate));
		zrate.setBegindate(dateToTimestamp(s_begindate));
		zrate.setEnddate(dateToTimestamp(s_enddate));
	/*	if(zrate.getType()==1)
		{
			zrate.setFlightnumber(s_flightnumber);
		}else if(zrate.getType()==2)
		{
			zrate.setWeeknum(s_flightnumber);
		}*/
		zrate.setModifyuser(getLoginUser().getLoginname());
		zrate.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		
		zrate.setZtype(zrate.getGeneral().toString());//政策类型  普通  高反
		
		/*zrate.setOnetofiveaftertime(zrate.getAfterworktime());
		zrate.setOnetofiveworktime(zrate.getWorktime());
		zrate.setWeekendaftertime(zrate.getAfterworktime());
		zrate.setWeekendworktime(zrate.getWorktime());
		
		zrate.setWeekendwastetime(zrate.getWorktime()+"|"+zrate.getAfterworktime());
		zrate.setOnetofivewastetime(zrate.getWorktime()+"|"+zrate.getAfterworktime());*/
		
		
		Server.getInstance().getAirService().updateZrateIgnoreNull(zrate);
		
		
		zrate=Server.getInstance().getAirService().findZrateByDB(zrate.getId());
		Zrate rate = ZrateServer.getInstance().findZrate(zrate.getAgentid(), "*$"+zrate.getOutid());
		if(rate!=null){
		ZrateServer.getInstance().deleteZrate(rate);
		zrate.setId(rate.getId());
		}
		ZrateServer.getInstance().createZrate(zrate);//创建缓存
		
		return LIST;
	}
	/**
	 * 编辑返点
	 */		
	public String editratevalue()throws Exception{
		Zrate zratetemp=Server.getInstance().getAirService().findZrateByDB(zrate.getId());
		Optrecord optrecord=new Optrecord();
		optrecord.setTablename(Zrate.TABLE);
		optrecord.setColumn(Zrate.COL_ratevalue);
		optrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
		optrecord.setCreateuser(this.getLoginUser().getLoginname());
		optrecord.setDescription("政策返点从"+zratetemp.getRatevalue()+"修改成"+zrate.getRatevalue());
		optrecord.setNewvalue(zrate.getRatevalue().toString());
		optrecord.setOldvalue(zratetemp.getRatevalue().toString());
		optrecord.setOptid(zrate.getId());
		Server.getInstance().getSystemService().createOptrecord(optrecord);
		Server.getInstance().getAirService().updateZrateIgnoreNull(zrate);
		return LIST;
	}
	/**
	 * 查看返点
	 */		
	public String showratevalue()throws Exception{
		String where=" where "+Optrecord.COL_tablename+" = '"+Zrate.TABLE+"' and "+Optrecord.COL_column+" = '"+Zrate.COL_ratevalue+"' and "+ Optrecord.COL_optid+" = "+zrate.getId();
		List list = Server.getInstance().getSystemService().findAllOptrecordForPageinfo(where, " order by "+Optrecord.COL_createtime+" desc", pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listOptrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listOptrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllOptrecordForPageinfo(where, " order by "+Optrecord.COL_createtime+" desc", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listOptrecord = list;
		}
		  return "ratevalue";
	}
	/**
	 * 通过航空公司二字码获取仓位返回类似A|B|C|D字符串
	 * @param ezm
	 * @return
	 */
	public void getCabinstr()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		StringBuffer str=new StringBuffer();
		List<Cabin> listcabin=Server.getInstance().getAirService().findAllCabin(" where "+Cabin.COL_aircompanycode+" = '"+s_ezm+"'", "", -1, 0);
		if(listcabin!=null&&listcabin.size()>0)
		{
			for(int i=0;i<listcabin.size();i++)
			{
				str.append(listcabin.get(i).getCabincode().trim()+"/");
			}
		}
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(str.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除普通政策表
	 */		
	public String delete()throws Exception{	
		Zrate zratetemp=Server.getInstance().getAirService().findZrateByDB(zrate.getId());
		Server.getInstance().getAirService().deleteZrate(zrate.getId());
		Zrate rate = ZrateServer.getInstance().findZrate(zratetemp.getAgentid(), "*$"+zratetemp.getOutid());
		if(rate!=null){
		ZrateServer.getInstance().deleteZrate(rate);
		}
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
					zrate=Server.getInstance().getAirService().findZrateByDB(i);
					Zrate rate = ZrateServer.getInstance().findZrate(zrate.getAgentid(), "*$"+zrate.getOutid());
					if(rate!=null){
					ZrateServer.getInstance().deleteZrate(rate);
					}
					Server.getInstance().getAirService().deleteZrate(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}

	public String toimp(){
		
		
		return "toimp";
	}

	public String importzrate()
	{
		List<Zrate> listzrate=new ArrayList<Zrate>();
		//List<Policyperiod> listpolicyperiod=new ArrayList<Policyperiod>();
		String parentStr = "";
		if (this.batchfile != null) {
			Workbook workbook;
			try {
				workbook = Workbook.getWorkbook(this.batchfile[0]);
				Sheet sheet = workbook.getSheet(0);
				for(int i=1;i<sheet.getRows();i++)
				{
					if(sheet.getCell(0, i).getContents().toString().length()>0)
					{
					Zrate zratetemp=new Zrate();
					//zratetemp.setAddratevalue(Float.parseFloat(sheet.getCell(12, i).getContents().toString().trim()));
					zratetemp.setAgentcode(getLoginUser().getAgentid()+"");
					zratetemp.setAgentid(getLoginUser().getAgentid());
					zratetemp.setCreateuser(getLoginUser().getLoginname());
					
					zratetemp.setTraveltype(1);//行程类型
					zratetemp.setZratetype(1l);
					zratetemp.setLanguage(0);
					zratetemp.setType(1);
					zratetemp.setGeneral(1l);//1普通  2特殊
					zratetemp.setIsenable(1);//状态  0禁用 1启用
					zratetemp.setCreatetime(new Timestamp(System.currentTimeMillis()));
					zratetemp.setZtype("1");
					zratetemp.setVoyagetype("1");
					zratetemp.setUsertype("1");
					
					UUID uuid = UUID.randomUUID();

					zratetemp.setOutid(uuid.toString());
					
					
					if(sheet.getCell(0, i).getContents()!=null&&sheet.getCell(0, i).getContents().length()>0){
						zratetemp.setAircompanycode(sheet.getCell(0, i).getContents().toString());//航空公司代码
					}
					if(sheet.getCell(2, i).getContents()!=null&&sheet.getCell(2, i).getContents().length()>0){
						zratetemp.setDepartureport(sheet.getCell(2, i).getContents().toString());//出发城市	
					}
					if(sheet.getCell(3, i).getContents()!=null&&sheet.getCell(3, i).getContents().length()>0){
						zratetemp.setArrivalport(sheet.getCell(3, i).getContents().toString());//到达城市
					}
					
					if(sheet.getCell(4, i).getContents()!=null){
					zratetemp.setFlightnumber(sheet.getCell(4, i).getContents().toString());//适用航班
					}
					if(sheet.getCell(5, i).getContents()!=null){
					zratetemp.setWeeknum(sheet.getCell(5, i).getContents().toString());//不适用航班
					}
					if(sheet.getCell(6, i).getContents()!=null){
					zratetemp.setCabincode(sheet.getCell(6, i).getContents().toString());//仓位码
					}
					
					if(sheet.getCell(7, i).getContents().toString().trim().equals("B2B"))
					{
						zratetemp.setTickettype(2);
					}else if(sheet.getCell(7, i).getContents().toString().trim().equals("BSP"))
					{
						zratetemp.setTickettype(1);
					}
					else
					{
						zratetemp.setTickettype(3);
					}
					
					
					
					if(sheet.getCell(8, i).getContents()!=null&&sheet.getCell(8, i).getContents().toString().trim().equals("手动"))
					{
						zratetemp.setIsauto(2l);
					}else
					{
						zratetemp.setIsauto(1l);
					}
					if(sheet.getCell(9, i).getContents()!=null&&sheet.getCell(9, i).getContents().toString().trim().equals("不转换"))
					{
						zratetemp.setIschange(2l);
					}else
					{
						zratetemp.setIschange(1l);
					}
					
					if(sheet.getCell(10, i).getContents()!=null){
					zratetemp.setRatevalue(Float.parseFloat(sheet.getCell(10, i).getContents().toString().trim()));//返点值
					}
					
					if(sheet.getCell(11, i).getContents()!=null&&sheet.getCell(12, i).getContents()!=null){
					zratetemp.setBegindate(dateToTimestamp(sheet.getCell(11, i).getContents().toString().trim()));//适用日期开始
					zratetemp.setEnddate(dateToTimestamp(sheet.getCell(12, i).getContents().toString().trim()));//适用日期结束
					zratetemp.setIssuedstartdate(this.dateToTimestamp(sheet.getCell(11, i).getContents().toString().trim()));//出票开始时间
					zratetemp.setIssuedendate(this.dateToTimestamp(sheet.getCell(12, i).getContents().toString().trim()));//出票结束时间
					}
					
					if(sheet.getCell(13, i).getContents()!=null&&sheet.getCell(13, i).getContents().indexOf("-")!=-1){//工作时间
						
						zratetemp.setWorktime(sheet.getCell(13, i).getContents().split("-")[0].trim());
						zratetemp.setAfterworktime(sheet.getCell(13, i).getContents().split("-")[1].trim());
						
					}
					if(sheet.getCell(14, i).getContents()!=null){
						zratetemp.setGeneral(1l);//1普通  2特殊
						if(sheet.getCell(14, i).getContents().toString().trim().equals("1")){
							
							zratetemp.setGeneral(1l);//1普通  2特殊
						}
						if(sheet.getCell(14, i).getContents().toString().trim().equals("2")){
							
							zratetemp.setGeneral(2l);//1普通  2特殊
						}
					}
					if(sheet.getCell(15, i).getContents()!=null){
					zratetemp.setRemark(sheet.getCell(15, i).getContents().toString().trim());//备注
					}
					listzrate.add(zratetemp);
					}
				}
				for(int x=0;x<listzrate.size();x++)
				{
					Zrate zrate=listzrate.get(x);
					System.out.println(zrate);
					//
					ZrateServer.getInstance().createZrate(zrate);
					//
					zrate=Server.getInstance().getAirService().createZrate(zrate);
				}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "你的政策已经导入!请审核!审核后才能使用!!!");
		return "toimp";
	}


	/**
	 *  返回普通政策表对象
	 */		
	
	public Object getModel() {
		return zrate;
	}
	public List < Zrate >   getListZrate() {
		return listZrate;
	}
	public void setListZrate(List <  Zrate  >  listZrate) {
		this.listZrate = listZrate;
	}
	public Zrate getZrate() {
		return zrate;
	}
	public void setZrate(Zrate zrate) {
		this.zrate = zrate;
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
	public List<Optrecord> getListOptrecord() {
		return listOptrecord;
	}
	public void setListOptrecord(List<Optrecord> listOptrecord) {
		this.listOptrecord = listOptrecord;
	}
	public List<Zrate> getListgrate() {
		return listgrate;
	}
	public void setListgrate(List<Zrate> listgrate) {
		this.listgrate = listgrate;
	}
	public List<Zrate> getListsrate() {
		return listsrate;
	}
	public void setListsrate(List<Zrate> listsrate) {
		this.listsrate = listsrate;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	
}