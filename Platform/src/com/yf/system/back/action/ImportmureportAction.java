/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yf.system.back.server.Server;
import com.yf.system.base.importmureport.Importmureport;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;


public class ImportmureportAction extends B2b2cbackAction {
	private List <  Importmureport  >  listImportmureport;
	private Importmureport importmureport = new Importmureport();
	
	private List<Passenger> listpasss=new ArrayList<Passenger>();
	private List<Passenger> listpasse=new ArrayList<Passenger>();
	
	private List<Importmureport> listmus=new ArrayList<Importmureport>();
	private List<Importmureport> listmue=new ArrayList<Importmureport>();
	
	
	private String s_status;
	private String s_userid;
	private String s_tickettype;
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	
	private String s_begindate;
	private String s_enddate;
	
	private String s_ticketnumber1;
	private String s_ticketnumber2;
	
	//search
	//private String s_name;
	
	
	public String getS_ticketnumber2() {
		return s_ticketnumber2;
	}

	public void setS_ticketnumber2(String s_ticketnumber2) {
		this.s_ticketnumber2 = s_ticketnumber2;
	}

	public String getS_ticketnumber1() {
		return s_ticketnumber1;
	}

	public void setS_ticketnumber1(String s_ticketnumber1) {
		this.s_ticketnumber1 = s_ticketnumber1;
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

	/**
	 * 列表查询东航销售明细导入
	 */	
	public String execute()throws Exception{
		//航信数据查询
		String where = " where 1=1 ";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begindate==null||s_begindate.trim().length()==0)
		{
			s_begindate=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_enddate==null||s_enddate.trim().length()==0)
		{
			s_enddate=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		if(s_tickettype!=null&&s_tickettype.length()>0&&!s_tickettype.equals("-1"))
		{
			where+=" and "+Importmureport.COL_ticketstate+" = "+s_tickettype;
		}
		//时间查询
		if (s_begindate!=null && s_begindate.trim().length()!=0 && s_enddate!=null && s_enddate.trim().length()!=0) {
			where += " and " + Importmureport.COL_time+" between '" + s_begindate.trim()+" 00:00:00' and '"+s_enddate+" 23:59:59'";	
		}
		if(s_ticketnumber1!=null && s_ticketnumber1.trim().length()!=0 && s_ticketnumber2!=null && s_ticketnumber2.trim().length()!=0)
		{
			where += " and convert(numeric(30, 0),Substring("+Importmureport.COL_ticketnumber+",4,10)) >="+s_ticketnumber1+" and convert(numeric(30, 0),Substring("+Importmureport.COL_ticketnumber+",4,10)) <="+s_ticketnumber2;
		}

		if(s_userid!=null && s_userid.trim().length()!=0)
		{
			where+=" and "+Importmureport.COL_chupiaoid+" = '"+s_userid+"'";
		}
	    listmus = Server.getInstance().getMemberService().findAllImportmureport(where," ORDER BY "+Importmureport.COL_ticketnumber,-1,0);
		
		//业务系统数据查询
		String strWhere=" where 1=1  ";
		
		//时间查询
		if (s_begindate!=null && s_begindate.trim().length()!=0 && s_enddate!=null && s_enddate.trim().length()!=0) {
			strWhere += " and " + Passenger.COL_rttime +" between '" + s_begindate.trim()+" 00:00:00' and '"+s_enddate+" 23:59:59'";	
		}
		if(s_ticketnumber1!=null && s_ticketnumber1.trim().length()!=0 && s_ticketnumber2!=null && s_ticketnumber2.trim().length()!=0)
		{
			strWhere += " and convert(numeric(30, 0),Substring("+Passenger.COL_ticketnum+",5,10)) >="+s_ticketnumber1+" and convert(numeric(30, 0),Substring("+Passenger.COL_ticketnum+",5,10)) <="+s_ticketnumber2;
		}
		if(s_tickettype!=null&&s_tickettype.length()>0&&!s_tickettype.equals("-1"))
		{
			strWhere+=" and "+Passenger.COL_state+" = "+s_tickettype;
		}
		listpasss = Server.getInstance().getAirService().findAllPassenger(strWhere, " ORDER BY "+Passenger.COL_ticketnum, -1, 0);
		
		return SUCCESS;
	}
	public String getcitypairbyID(Long id)
	{
		String strReturn="";
		List<Segmentinfo> list=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE "+Segmentinfo.COL_orderid+"="+id.toString()," ORDER BY ID",-1,0);
		if(list.size()>0)
		{
			strReturn=list.get(0).getStartairport()+list.get(0).getEndairport();
		}
		return strReturn;
	}
	public String getpnrbyID(Long id)
	{
		String strReturn="";
		List<Orderinfo> list=Server.getInstance().getAirService().findAllOrderinfo(" WHERE "+Orderinfo.COL_id+"="+id.toString()," ORDER BY ID",-1,0);
		if(list.size()>0)
		{
			strReturn=list.get(0).getPnr();
		}
		return strReturn;
	}
	/**
	 * 进行数据对比
	 * @return
	 */
	public String compdate()
	{
		String sql=" where 1=1 and "+Passenger.COL_rttime+" between '"+s_begindate+" 00:00:00' and '"+s_enddate+" 23:59:59'";
		List<Passenger> listpassenger=Server.getInstance().getAirService().findAllPassenger(sql, "", -1, 0);
		String sql2=" where 1=1 and "+Importmureport.COL_time+" between '"+s_begindate+" 00:00:00' and '"+s_enddate+" 23:59:59'";
		List<Importmureport> listimportmu=Server.getInstance().getMemberService().findAllImportmureport(sql2, "", -1, 0);
		Map<String,Passenger> map=new HashMap<String, Passenger>();
		for(Passenger passenger:listpassenger)
		{
			if(passenger.getTicketnum()!=null&&passenger.getTicketnum().length()>0)
			{
			map.put(passenger.getTicketnum().replace("-", ""), passenger);
			}else
			{
				listpasse.add(passenger);
			}
		}
		for(Importmureport importmureport:listimportmu)
		{
			String ticketnum=importmureport.getTicketnumber();
			Passenger passenger=map.get(ticketnum);
			if(passenger!=null&&passenger.getId()>0)
			{
				importmureport.setCompstate(1l);
				listmus.add(importmureport);
				listpasss.add(passenger);
				map.remove(ticketnum);
			}else
			{
				importmureport.setCompstate(2l);
				listmue.add(importmureport);
			}
		}
		for(Passenger passenger:map.values())
		{
			listpasse.add(passenger);
		}
		return "compresult";
	}
	/**
	 * 转向到东航销售明细导入添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到东航销售明细导入修改页面
	 */	
	public String toedit()throws Exception{
	importmureport = Server.getInstance().getMemberService().findImportmureport(importmureport.getId());
		return EDIT;
	}
	
	/**
	 * 转向到东航销售明细导入审核页面
	 */	
	public String tocheck()throws Exception{
	importmureport = Server.getInstance().getMemberService().findImportmureport(importmureport.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加东航销售明细导入
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createImportmureport(importmureport);
		return LIST;
	}

	/**
	 * 审核东航销售明细导入
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateImportmureportIgnoreNull(importmureport);
		return LIST;
	}
	


	/**
	 * 编辑东航销售明细导入
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateImportmureportIgnoreNull(importmureport);
		return LIST;
	}

	/**
	 * 删除东航销售明细导入
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteImportmureport(importmureport.getId());
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
					Server.getInstance().getMemberService().deleteImportmureport(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回东航销售明细导入对象
	 */		
	
	public Object getModel() {
		return importmureport;
	}
	public List < Importmureport >   getListImportmureport() {
		return listImportmureport;
	}
	public void setListImportmureport(List <  Importmureport  >  listImportmureport) {
		this.listImportmureport = listImportmureport;
	}
	public Importmureport getImportmureport() {
		return importmureport;
	}
	public void setImportmureport(Importmureport importmureport) {
		this.importmureport = importmureport;
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

	public List<Passenger> getListpasss() {
		return listpasss;
	}

	public void setListpasss(List<Passenger> listpasss) {
		this.listpasss = listpasss;
	}

	public List<Passenger> getListpasse() {
		return listpasse;
	}

	public void setListpasse(List<Passenger> listpasse) {
		this.listpasse = listpasse;
	}

	public List<Importmureport> getListmus() {
		return listmus;
	}

	public void setListmus(List<Importmureport> listmus) {
		this.listmus = listmus;
	}

	public List<Importmureport> getListmue() {
		return listmue;
	}

	public void setListmue(List<Importmureport> listmue) {
		this.listmue = listmue;
	}

	public String getS_status() {
		return s_status;
	}

	public void setS_status(String s_status) {
		this.s_status = s_status;
	}

	public String getS_userid() {
		return s_userid;
	}

	public void setS_userid(String s_userid) {
		this.s_userid = s_userid;
	}

	public String getS_tickettype() {
		return s_tickettype;
	}

	public void setS_tickettype(String s_tickettype) {
		this.s_tickettype = s_tickettype;
	}
	
	
}