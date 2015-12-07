/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.opensymphony.webwork.ServletActionContext;




public class HotelreportAction extends B2b2cbackAction {
	private List list;
	private List list2;
	private List<Hotelorder> listHotelorder;
	
	//开始时间和结束时间
	private String s_begintime;
	private String s_endtime;
	private int orderno;
	private int orderpirc;
	private Long cityId;
	private String hotelname;
	
	public String execute() throws Exception {
// System.out.println("info ... to add!");
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		
		
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_state+" =1");
		
		

		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(s_begintime != null && s_begintime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + s_begintime + " 00:00:00')") ;
		}
		if(s_endtime != null && s_endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + s_endtime + " 23:59:59')") ;
		}
	/*	if (hoteltype != null && hoteltype.length()!=0) {

			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_hot).append("=").append(hoteltype) ;
			where.append(")") ;
			
		}*/
		/*if(hotelorderstate!=null && hotelorderstate.length()!=0){
			
			where.append(" and "+Hotelorder.COL_state +" = "+hotelorderstate);
			
		}*/
		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		System.out.println("where==="+where);
		String sql="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice," +
				"COUNT(a.ID) as r_sum ," +
				"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
				" FROM T_HOTELORDER a"+
		""+where+"";
		System.out.println("sql==="+sql);
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
/*	if(listHotelorder.size()>0){	
		for (Hotelorder order : listHotelorder) {

			
			if(order.getManyday()!=null){
			int jian = order.getManyday();
			jianye +=jian;
			}
			if(order.getPrice()!=null){
			double	jia=Double.parseDouble(order.getPrice()); 
	
			int level = (int) (jia / 10);
			zongjia +=jia;
			}
		
			
			
			
		}
		
	}*/
		return SUCCESS;
	}
	//酒店返佣报表
	public String toFan() throws Exception {
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		
		
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_state+" =1");
		
		

		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(s_begintime != null && s_begintime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + s_begintime + " 00:00:00')") ;
		}
		if(s_endtime != null && s_endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + s_endtime + " 23:59:59')") ;
		}

		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		
		return "tofan";
	}
	public String toearnings() throws Exception {
		
		return "toearnings";
	}
	public String hotelreportsum() throws Exception
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		//String sql="SELECT ";
		String sql="SELECT CONVERT(varchar(12) , C_PRETIME, 102 ) as r_time, "+
		"a.C_NAME as r_hotelname,"+
		"SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice,"+
		"COUNT(a.ID) as r_sum "+
		"FROM T_HOTELORDER a "+
		" where 1=1 "+
		" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
		" and a.C_PRETIME<='"+s_endtime+" 23:59:59' "+
		"and a.C_PRICE is not null and isnumeric(a.C_PRICE)=1"+
		"group by a.C_NAME,a.C_PRICE,CONVERT(varchar(12),a.C_PRETIME, 102)"+
		" order by CONVERT(varchar(12) , a.C_PRETIME, 102 )";
		System.out.println("sql=="+sql);
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
	
		String sql2="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice2," +
				"COUNT(a.ID) as r_sum2 " +
				//"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
				" FROM T_HOTELORDER a"+
				" where 1=1 "+
				" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
				" and a.C_PRETIME<='"+s_endtime+" 23:59:59' ";
		
		System.out.println("sql2==="+sql2);
		list2=Server.getInstance().getSystemService().findMapResultBySql(sql2, null);
		/*Map map=(Map) list2.get(0);
		String s=map.values().toString();
		String aa[]=s.split(",");
		String dd=aa[0];
		String ff=aa[1];*/
		return "hotelreportsum";
	}
	public String lirun() throws Exception
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		String where =" where 1=1 ";//目前是查询出所有的...以后要改成已经完成订单
		if(getLoginUser().getAgentid()==46){
			
		}else{
			where+=" and "+Hotelorder.COL_memberid+" in ( SELECT "+Customeruser.COL_id+" from "+Customeruser.TABLE+" where "+Customeruser.COL_agentid+" ='"+getLoginUser().getAgentid()+"')";
		}
		if(s_begintime!=null&&s_begintime.length()>0){
			where+=" and "+Hotelorder.COL_pretime+" >='"+s_begintime+" 00:00:00' ";
		}
		if(s_endtime!=null&&s_endtime.length()>0){
			where+=" and "+Hotelorder.COL_pretime+" <='"+s_endtime+" 23:59:59' ";
		}
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where, " ORDER BY ID DESC", -1, 0);
	/*	//String sql="SELECT ";
		String sql="SELECT CONVERT(varchar(12) , C_PRETIME, 102 ) as r_time, "+
		"a.C_NAME as r_hotelname,"+
		"SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice,"+
		"COUNT(a.ID) as r_sum "+
		"FROM T_HOTELORDER a "+
		" where 1=1 "+
		" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
		" and a.C_PRETIME<='"+s_endtime+" 23:59:59' "+
		"and a.C_PRICE is not null and isnumeric(a.C_PRICE)=1"+
		"group by a.C_NAME,a.C_PRICE,CONVERT(varchar(12),a.C_PRETIME, 102)"+
		" order by CONVERT(varchar(12) , a.C_PRETIME, 102 )";
		System.out.println("sql=="+sql);
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
	
		String sql2="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice2," +
				"COUNT(a.ID) as r_sum2 " +
				//"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
				" FROM T_HOTELORDER a"+
				" where 1=1 "+
				" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
				" and a.C_PRETIME<='"+s_endtime+" 23:59:59' ";
		
		System.out.println("sql2==="+sql2);
		list2=Server.getInstance().getSystemService().findMapResultBySql(sql2, null);*/

		return "hotelreportsumprice";
	}
	public void hotelreportsumdown() throws IOException, RowsExceededException, WriteException
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_begintime==null||s_begintime.trim().length()==0)
		{
			s_begintime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		String sql="SELECT CONVERT(varchar(12) , C_PRETIME, 102 ) as r_time, "+
		"a.C_NAME as r_hotelname,"+
		"SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice,"+
		"COUNT(a.ID) as r_sum "+
		"FROM T_HOTELORDER a "+
		" where 1=1 "+
		" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
		" and a.C_PRETIME<='"+s_endtime+" 23:59:59' "+
		"and a.C_PRICE is not null and isnumeric(a.C_PRICE)=1"+
		"group by a.C_NAME,a.C_PRICE,CONVERT(varchar(12),a.C_PRETIME, 102)"+
		" order by CONVERT(varchar(12) , a.C_PRETIME, 102 )";
		list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		
		
		String sql2="SELECT SUM(cast(ltrim(rtrim(a.C_PRICE)) as decimal)) as r_hotelprice2," +
		"COUNT(a.ID) as r_sum2 " +
		//"SUM(cast(ltrim(rtrim(a.C_MANYDAY)) as decimal)) as r_jianye"+
		" FROM T_HOTELORDER a"+
		" where 1=1 "+
		" and a.C_PRETIME >='"+s_begintime+" 00:00:00' "+
		" and a.C_PRETIME<='"+s_endtime+" 23:59:59' ";

		System.out.println("sql2==="+sql2);
		list2=Server.getInstance().getSystemService().findMapResultBySql(sql2, null);


		//list2.getClass().get
		
		String fileName="酒店销售统计.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                      
		//response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));                       
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		 WritableSheet sheet = workbook.createSheet("Sheet_1", 0); 
		 Label label0 = new Label(0, 0, "时间");    
         sheet.addCell(label0); 
         Label label1 = new Label(1, 0, "酒店名称");    
         sheet.addCell(label1);
         Label label2 = new Label(2, 0, "订单数");    
         sheet.addCell(label2);
         Label label3 = new Label(3, 0, "金额");    
         sheet.addCell(label3);
		 for(int i=0;i<list.size();i++)
		 {
			 Map map=(Map) list.get(i);
			 Label label00 = new Label(0, i+1, map.get("r_time").toString());    
	         sheet.addCell(label00); 
	         Label label11 = new Label(1, i+1, map.get("r_hotelname").toString());    
	         sheet.addCell(label11);
	         Label label22 = new Label(2, i+1, map.get("r_sum").toString());    
	         sheet.addCell(label22);
	         Label label33 = new Label(3, i+1, map.get("r_hotelprice").toString());    
	         sheet.addCell(label33);
		 }
		 Map map=(Map) list2.get(0);
		 Label label00 = new Label(0, list.size()+1, "");    
         sheet.addCell(label00); 
         Label label11 = new Label(1, list.size()+1, "");    
         sheet.addCell(label11);
         Label label22 = new Label(2, list.size()+1, "总订单数"+map.get("r_sum2").toString());    
         sheet.addCell(label22);
         Label label33 = new Label(3, list.size()+1, "总金额"+map.get("r_hotelprice2").toString());    
         sheet.addCell(label33);
        workbook.write();    
        workbook.close();   
	}
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
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
	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	public List<Hotelorder> getListHotelorder() {
		return listHotelorder;
	}
	public void setListHotelorder(List<Hotelorder> listHotelorder) {
		this.listHotelorder = listHotelorder;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getOrderpirc() {
		return orderpirc;
	}
	public void setOrderpirc(int orderpirc) {
		this.orderpirc = orderpirc;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

}