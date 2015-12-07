/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.travelskyreport.Travelskyreport;


public class TravelskyreportAction extends B2b2cbackAction {
	private List <  Travelskyreport  >  listTravelskyreport;
	private Travelskyreport travelskyreport = new Travelskyreport();
	private List <Passenger> listPassenger ;
	//批量操作ID数组
	private int[]selectid;
	private String s_begintime;
	private String s_endtime;
	private String s_ticketnumber1;
	private String s_ticketnumber2;
	private String s_printnumber;
	private String s_status;
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询航空公司报表导入
	 */	
	public String execute()throws Exception{
		//航信数据查询
		String where = " where 1=1 ";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		//时间查询
		if (s_begintime!=null && s_begintime.trim().length()!=0 && s_endtime!=null && s_endtime.trim().length()!=0) {
			where += " and " + Travelskyreport.COL_createtime +" between '" + s_begintime.trim()+" 00:00:00' and '"+s_endtime+" 23:59:59'";	
		}
		//票状态查询
		if(s_status!=null && s_status.trim().length()!=0)
		{
			//所有票
			if(s_status.equals("2"))
			{
				where += " and "+Travelskyreport.COL_origsest+"<>'ET-REFUND' and "+Travelskyreport.COL_origsest+"<>'VOID'";
			}
			else if(s_status.equals("4"))
			{
				where += " and "+Travelskyreport.COL_origsest+"='ET-REFUND' ";
			}
			else if(s_status.equals("3"))
			{
				where += " and "+Travelskyreport.COL_origsest+"='VOID' ";
			}
		}
		if( s_ticketnumber1!=null && s_ticketnumber1.trim().length()!=0 && s_ticketnumber2!=null && s_ticketnumber2.trim().length()!=0)
		{
			where += " and convert(numeric(30, 0),Substring("+Travelskyreport.COL_tktnumber+",5,10)) >="+s_ticketnumber1+" and convert(numeric(30, 0),Substring("+Travelskyreport.COL_tktnumber+",5,10)) <="+s_ticketnumber2;
		}
	
	    List list = Server.getInstance().getMemberService().findAllTravelskyreport(where," ORDER BY "+Travelskyreport.COL_tktnumber,-1,0);
		listTravelskyreport = list;
		
		//业务系统数据查询
		String strWhere=" where 1=1  ";
		//时间查询
		if (s_begintime!=null && s_begintime.trim().length()!=0 && s_endtime!=null && s_endtime.trim().length()!=0) {
			strWhere += " and " + Passenger.COL_rttime +" between '" + s_begintime.trim()+" 00:00:00' and '"+s_endtime+" 23:59:59'";	
		}
		List listpass = Server.getInstance().getAirService().findAllPassenger(strWhere, " ORDER BY "+Passenger.COL_ticketnum, -1, 0);
		
		
		listPassenger=listpass;
		
		//对list重新整理
		
		return SUCCESS;
	}
	
	/**
	 * 
	 */
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
	 * 转向到航空公司报表导入添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到航空公司报表导入修改页面
	 */	
	public String toedit()throws Exception{
	travelskyreport = Server.getInstance().getMemberService().findTravelskyreport(travelskyreport.getId());
		return EDIT;
	}
	
	/**
	 * 转向到航空公司报表导入审核页面
	 */	
	public String tocheck()throws Exception{
	travelskyreport = Server.getInstance().getMemberService().findTravelskyreport(travelskyreport.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加航空公司报表导入
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createTravelskyreport(travelskyreport);
		return LIST;
	}

	/**
	 * 审核航空公司报表导入
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTravelskyreportIgnoreNull(travelskyreport);
		return LIST;
	}
	


	/**
	 * 编辑航空公司报表导入
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTravelskyreportIgnoreNull(travelskyreport);
		return LIST;
	}

	/**
	 * 删除航空公司报表导入
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTravelskyreport(travelskyreport.getId());
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
					Server.getInstance().getMemberService().deleteTravelskyreport(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回航空公司报表导入对象
	 */		
	
	public Object getModel() {
		return travelskyreport;
	}
	public List < Travelskyreport >   getListTravelskyreport() {
		return listTravelskyreport;
	}
	public void setListTravelskyreport(List <  Travelskyreport  >  listTravelskyreport) {
		this.listTravelskyreport = listTravelskyreport;
	}
	public Travelskyreport getTravelskyreport() {
		return travelskyreport;
	}
	public void setTravelskyreport(Travelskyreport travelskyreport) {
		this.travelskyreport = travelskyreport;
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
	public String getS_begintime() {
		return s_begintime;
	}
	public void setS_begintime(String s_begintime) {
		this.s_begintime = s_begintime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	public String getS_ticketnumber1() {
		return s_ticketnumber1;
	}
	public void setS_ticketnumber1(String s_ticketnumber1) {
		this.s_ticketnumber1 = s_ticketnumber1;
	}
	public String getS_ticketnumber2() {
		return s_ticketnumber2;
	}
	public void setS_ticketnumber2(String s_ticketnumber2) {
		this.s_ticketnumber2 = s_ticketnumber2;
	}
	public String getS_printnumber() {
		return s_printnumber;
	}
	public void setS_printnumber(String s_printnumber) {
		this.s_printnumber = s_printnumber;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public List<Passenger> getListPassenger() {
		return listPassenger;
	}
	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}
	
	
}