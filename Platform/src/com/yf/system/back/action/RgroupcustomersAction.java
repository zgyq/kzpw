/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.rgroupcustomers.Rgroupcustomers;
import com.opensymphony.webwork.ServletActionContext;


public class RgroupcustomersAction extends B2b2cbackAction {
	private List <  Rgroupcustomers  >  listRgroupcustomers;
	private Rgroupcustomers rgroupcustomers = new Rgroupcustomers();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String s_starttime;
	private String s_endtime;
	
	private String i_date;
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	/**
	 * 列表查询集团客户环比统计表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_starttime==null||s_starttime.trim().length()==0)
		{
			s_starttime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		if (s_starttime!=null && s_starttime.trim().length()!=0) {
			where += " and " + Rgroupcustomers.COL_datetime +" >= '" + s_starttime.trim()+" 00:00:00'";	
		}
		if (s_endtime!=null && s_endtime.trim().length()!=0) {
			where += " and " + Rgroupcustomers.COL_datetime +" <= '" + s_endtime.trim()+" 23:59:59'";	
		}
	    List list = Server.getInstance().getAirService().findAllRgroupcustomersForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRgroupcustomers = list;
		  if(pageinfo.getTotalrow()>0 &&   listRgroupcustomers.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllRgroupcustomersForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRgroupcustomers = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 导出xls
	 */	
	public void down()throws Exception{
		String fileName="集团客户近期销售汇总环比表.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                   
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		WritableSheet sheet = workbook.createSheet("集团客户近期销售汇总环比表", 0); 
		Label labelmerge = new Label(0, 0, "集团客户近期销售汇总环比");
		sheet.addCell(labelmerge);
		sheet.mergeCells(0, 0, 12, 0);
		//计算日期开始
		SimpleDateFormat   sdf=new   SimpleDateFormat("yyyy-MM-dd"); 
		Calendar   cal=Calendar.getInstance(); 
		try{ 
		cal.setTime(sdf.parse("2010-09-25")); 
		}catch(Exception   e){}; 
		if   (cal.get(Calendar.DAY_OF_WEEK)==1){ 
		cal.add(cal.WEEK_OF_MONTH,-1); 
		} 
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);//周一到周六 
		cal.add(cal.WEEK_OF_MONTH,-10); 
		System.out.println(sdf.format(cal.getTime())); 
		//计算日期结束
		Label label0 = new Label(0, 1, "集团客户");
		sheet.addCell(label0);
		Label label1 = new Label(1, 1, "第1周"+sdf.format(cal.getTime()));
		sheet.addCell(label1);
		
		cal.add(cal.WEEK_OF_MONTH,1); 
		Label label2 = new Label(2, 1, "第2周"+sdf.format(cal.getTime()));
		sheet.addCell(label2);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label3 = new Label(3, 1, "第3周"+sdf.format(cal.getTime()));
		sheet.addCell(label3);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label4 = new Label(4, 1, "第4周"+sdf.format(cal.getTime()));
		sheet.addCell(label4);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label5 = new Label(5, 1, "第5周"+sdf.format(cal.getTime()));
		sheet.addCell(label5);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label6 = new Label(6, 1, "第6周"+sdf.format(cal.getTime()));
		sheet.addCell(label6);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label7 = new Label(7, 1, "第7周"+sdf.format(cal.getTime()));
		sheet.addCell(label7);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label8 = new Label(8, 1, "第8周"+sdf.format(cal.getTime()));
		sheet.addCell(label8);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label9 = new Label(9, 1, "第9周"+sdf.format(cal.getTime()));
		sheet.addCell(label9);
		
		cal.add(cal.WEEK_OF_MONTH,1);
		Label label10 = new Label(10, 1, "本周"+sdf.format(cal.getTime()));
		sheet.addCell(label10);
		
		Label label11 = new Label(11, 1, "环比变动量(元)");
		sheet.addCell(label11);
		Label label12 = new Label(12, 1, "环比变动率%");
		sheet.addCell(label12);
		List list = reportlist();
		int romindex=0;
		int typeid=1;
		String groupid="";
		for(int i=0;i<list.size();i++)
		{
			 Map map=(Map) list.get(i);
			 if(map.get("C_GROUPCUSID")!=null)
			 {
				 if(groupid.equals(map.get("C_GROUPCUSID").toString()))
				 {
					 typeid++;
					 String label1_11="";
					 if(map.get("C_MONEY")!=null)
					 {
						 label1_11=map.get("C_MONEY").toString();
					 }
			         Label label11Label = new Label(typeid, romindex+2, label1_11);    
			         sheet.addCell(label11Label);
				 }else
				 {
					 if(i!=0)
					 {
						 romindex++;
						 typeid=1;
					 }
					 groupid=map.get("C_GROUPCUSID").toString();
					 String label1_1="";
					 if(map.get("C_GROUPNAME")!=null)
					 {
						 label1_1=map.get("C_GROUPNAME").toString();
					 }
			         Label label = new Label(0, romindex+2, label1_1);    
			         sheet.addCell(label);
			         
			         String label1_11="";
					 if(map.get("C_MONEY")!=null)
					 {
						 label1_11=map.get("C_MONEY").toString();
					 }
			         Label label11Label = new Label(1, romindex+2, label1_11);    
			         sheet.addCell(label11Label);
				 }
			 }
			
		}

		Label label16=new Label(0,romindex+5,"本周集团客户的销售总额");
		sheet.addCell(label16);
		Label label=new Label(0,romindex+6,"备注：1、集团客户列表按本周交易额从大到小排序，本周无发生额的客户不统计入内；");
		sheet.addCell(label);
		Label label14=new Label(0,romindex+7,"      2、日期段按周统计共统计近10周的交易汇总进行金额横向对比；");
		sheet.addCell(label14);
		Label label15=new Label(0,romindex+8,"      3、环比变动量=本周发生额-上周发生额，环比变动率=（本周发生额-上周发生额）/上周发生额");
		sheet.addCell(label15);
        workbook.write();    
        workbook.close();   
	}
	public List reportlist()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_starttime==null||s_starttime.trim().length()==0)
		{
			s_starttime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		String sql = "SELECT DATEPART (week,[C_DATETIME]),[C_GROUPCUSID],[C_GROUPNAME],sum(C_MONEY) as C_MONEY "
				+ "FROM [DFHK_DB].[dbo].[T_RGROUPCUSTOMERS] where C_DATETIME between '"+s_starttime+"' and '"+s_endtime+"' group by [C_GROUPCUSID],[C_GROUPNAME],DATEPART (week,[C_DATETIME]),year([C_DATETIME])";
		System.out.println(sql);
		return Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}
	/**
	 * 转向到集团客户环比统计表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到集团客户环比统计表修改页面
	 */	
	public String toedit()throws Exception{
	rgroupcustomers = Server.getInstance().getAirService().findRgroupcustomers(rgroupcustomers.getId());
	i_date=formatTimestampyyyyMMdd(rgroupcustomers.getDatetime());
	return EDIT;
	}
	
	/**
	 * 转向到集团客户环比统计表审核页面
	 */	
	public String tocheck()throws Exception{
	rgroupcustomers = Server.getInstance().getAirService().findRgroupcustomers(rgroupcustomers.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加集团客户环比统计表
	 */		
	public String add()throws Exception{
		rgroupcustomers.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().createRgroupcustomers(rgroupcustomers);
		return LIST;
	}

	/**
	 * 审核集团客户环比统计表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateRgroupcustomersIgnoreNull(rgroupcustomers);
		return LIST;
	}
	


	/**
	 * 编辑集团客户环比统计表
	 */		
	public String edit()throws Exception{
		rgroupcustomers.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().updateRgroupcustomersIgnoreNull(rgroupcustomers);
		return LIST;
	}

	/**
	 * 删除集团客户环比统计表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteRgroupcustomers(rgroupcustomers.getId());
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
					Server.getInstance().getAirService().deleteRgroupcustomers(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回集团客户环比统计表对象
	 */		
	
	public Object getModel() {
		return rgroupcustomers;
	}
	public List < Rgroupcustomers >   getListRgroupcustomers() {
		return listRgroupcustomers;
	}
	public void setListRgroupcustomers(List <  Rgroupcustomers  >  listRgroupcustomers) {
		this.listRgroupcustomers = listRgroupcustomers;
	}
	public Rgroupcustomers getRgroupcustomers() {
		return rgroupcustomers;
	}
	public void setRgroupcustomers(Rgroupcustomers rgroupcustomers) {
		this.rgroupcustomers = rgroupcustomers;
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
	public String getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	
	
}