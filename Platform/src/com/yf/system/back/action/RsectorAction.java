/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yf.system.back.server.Server;
import com.yf.system.base.rperformance.Rperformance;
import com.yf.system.base.rsector.Rsector;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class RsectorAction extends B2b2cbackAction {
	private List <  Rsector  >  listRsector;
	private Rsector rsector = new Rsector();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	private String i_date;
	
	private String s_time;
	
	
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	/**
	 * 列表查询部门绩效表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
		if(s_time==null||s_time.trim().length()==0)
		{
			s_time=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if (s_time!=null && s_time.trim().length()!=0) {
			where += " and convert(varchar(7),C_DATE,120)='"+s_time+"'";	
		}
	    List list = Server.getInstance().getAirService().findAllRsectorForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRsector = list;
		  if(pageinfo.getTotalrow()>0 &&   listRsector.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllRsectorForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRsector = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 导出xls
	 */	
	public void down()throws Exception{
		String fileName="绩效合约完成情况表.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                   
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		WritableSheet sheet = workbook.createSheet("绩效合约完成情况表", 0); 
		//第一行
		Label labelmerge = new Label(0, 0, "绩效合约完成情况表");
		sheet.addCell(labelmerge);
		sheet.mergeCells(0, 0, 13, 0);
		//第二行
		Label label0 = new Label(0, 1, "");
		sheet.addCell(label0);
		sheet.mergeCells(0, 1, 1, 1);
		Label label1 = new Label(2, 1, "销售收入 万元");
		sheet.addCell(label1);
		sheet.mergeCells(2, 1, 5, 1);
		Label label2 = new Label(6, 1, "毛利指标 万元");
		sheet.addCell(label2);
		sheet.mergeCells(6, 1, 9, 1);
		Label label3 = new Label(10, 1, "东航直销 万元");
		sheet.addCell(label3);
		sheet.mergeCells(10, 1, 13, 1);
		//第三行
		Label label4 = new Label(0, 2, "部门");
		sheet.addCell(label4);
		sheet.mergeCells(0, 2, 1, 2);
		
		Label label5 = new Label(3, 2, "T1");
		sheet.addCell(label5);
		Label label6 = new Label(4, 2, "T2");
		sheet.addCell(label6);
		Label label7 = new Label(5, 2, "T3");
		sheet.addCell(label7);
		
		Label label8 = new Label(7, 2, "T1");
		sheet.addCell(label8);
		Label label9 = new Label(8, 2, "T2");
		sheet.addCell(label9);
		Label label10 = new Label(9, 2, "T3");
		sheet.addCell(label10);
		
		Label label11 = new Label(11, 2, "T1");
		sheet.addCell(label11);
		Label label12 = new Label(12, 2, "T2");
		sheet.addCell(label12);
		Label label13 = new Label(13, 2, "T3");
		sheet.addCell(label13);
		//数据行录入的数据
		List<Rperformance> listrp=Server.getInstance().getAirService().findAllRperformance(" where convert(varchar(7),C_DATETIME,120) = '"+s_time+"'", " order by C_DEPARTMENT,C_TYPE ", -1, 0);
		int romindex=3;
		int index=0;
		String departmentstr="";
		for(Rperformance rperformance :listrp)
		{
			if(rperformance.getDepartment().toString().trim().equals(departmentstr))
			{
			}else
			{
				departmentstr=rperformance.getDepartment().toString();
				if(index!=0)
				{
					romindex+=7;
				}
				Label label=new Label(0,romindex,getdepartmentNamebyId(rperformance.getDepartment()));
				sheet.addCell(label);
				Label labelzhibiao=new Label(1,romindex,s_time+"指标");
				sheet.addCell(labelzhibiao);
				sheet.mergeCells(0, romindex, 0, romindex+6);
			}

			if(rperformance.getType()==1)
			{
				Label label=new Label(3,romindex,rperformance.getHigh().toString());
				sheet.addCell(label);
				Label label14=new Label(4,romindex,rperformance.getNormal().toString());
				sheet.addCell(label14);
				Label label15=new Label(5,romindex,rperformance.getLow().toString());
				sheet.addCell(label15);
				List list=reportlist(rperformance.getId());
				for(int i=0;i<list.size();i++)
				{
					 Map map=(Map) list.get(i);
					 String yearstr="";
					 if(map.get("C_YEAR")!=null&&map.get("C_MONTH")!=null)
					 {
						 yearstr=getdatesortweek(i);
					 }
			         Label lblyearstr = new Label(1, romindex+i+1, yearstr);    
			         sheet.addCell(lblyearstr);
			         
					 String label1_1="";
					 if(map.get("C_MONEY")!=null)
					 {
						 label1_1=map.get("C_MONEY").toString();
					 }
			         Label label16 = new Label(2, romindex+i+1, label1_1);    
			         sheet.addCell(label16);
			         
					 String label1_1String="";
					 if(map.get("C_LOW")!=null)
					 {
						 label1_1String=map.get("C_LOW").toString();
					 }
			         Label label16Label = new Label(3, romindex+i+1, label1_1String);    
			         sheet.addCell(label16Label);
			         
					 String label1_1String2="";
					 if(map.get("C_NORMAL")!=null)
					 {
						 label1_1String2=map.get("C_NORMAL").toString();
					 }
			         Label label16Label2 = new Label(4, romindex+i+1, label1_1String2);    
			         sheet.addCell(label16Label2);
			         
			         String label1_1String3="";
					 if(map.get("C_HIGH")!=null)
					 {
						 label1_1String3=map.get("C_HIGH").toString();
					 }
			         Label label16Label2Label = new Label(5, romindex+i+1, label1_1String3);    
			         sheet.addCell(label16Label2Label);
				}
			}
			if(rperformance.getType()==2)
			{
				Label label=new Label(7,romindex,rperformance.getHigh().toString());
				sheet.addCell(label);
				Label label14=new Label(8,romindex,rperformance.getNormal().toString());
				sheet.addCell(label14);
				Label label15=new Label(9,romindex,rperformance.getLow().toString());
				sheet.addCell(label15);
				List list=reportlist(rperformance.getId());
				for(int i=0;i<list.size();i++)
				{
					 Map map=(Map) list.get(i);
					 String label1_1="";
					 if(map.get("C_MONEY")!=null)
					 {
						 label1_1=map.get("C_MONEY").toString();
					 }
			         Label label16 = new Label(6, romindex+i+1, label1_1);    
			         sheet.addCell(label16);
			         
					 String label1_1String="";
					 if(map.get("C_LOW")!=null)
					 {
						 label1_1String=map.get("C_LOW").toString();
					 }
			         Label label16Label = new Label(7, romindex+i+1, label1_1String);    
			         sheet.addCell(label16Label);
			         
					 String label1_1String2="";
					 if(map.get("C_NORMAL")!=null)
					 {
						 label1_1String2=map.get("C_NORMAL").toString();
					 }
			         Label label16Label2 = new Label(8, romindex+i+1, label1_1String2);    
			         sheet.addCell(label16Label2);
			         
			         String label1_1String3="";
					 if(map.get("C_HIGH")!=null)
					 {
						 label1_1String3=map.get("C_HIGH").toString();
					 }
			         Label label16Label2Label = new Label(9, romindex+i+1, label1_1String3);    
			         sheet.addCell(label16Label2Label);
				}
			}
			if(rperformance.getType()==3)
			{
				Label label=new Label(11,romindex,rperformance.getHigh().toString());
				sheet.addCell(label);
				Label label14=new Label(12,romindex,rperformance.getNormal().toString());
				sheet.addCell(label14);
				Label label15=new Label(13,romindex,rperformance.getLow().toString());
				sheet.addCell(label15);
				List list=reportlist(rperformance.getId());
				for(int i=0;i<list.size();i++)
				{
					 Map map=(Map) list.get(i);
					 String label1_1="";
					 if(map.get("C_MONEY")!=null)
					 {
						 label1_1=map.get("C_MONEY").toString();
					 }
			         Label label16 = new Label(10, romindex+i+1, label1_1);    
			         sheet.addCell(label16);
			         
					 String label1_1String="";
					 if(map.get("C_LOW")!=null)
					 {
						 label1_1String=map.get("C_LOW").toString();
					 }
			         Label label16Label = new Label(11, romindex+i+1, label1_1String);    
			         sheet.addCell(label16Label);
			         
					 String label1_1String2="";
					 if(map.get("C_NORMAL")!=null)
					 {
						 label1_1String2=map.get("C_NORMAL").toString();
					 }
			         Label label16Label2 = new Label(12, romindex+i+1, label1_1String2);    
			         sheet.addCell(label16Label2);
			         
			         String label1_1String3="";
					 if(map.get("C_HIGH")!=null)
					 {
						 label1_1String3=map.get("C_HIGH").toString();
					 }
			         Label label16Label2Label = new Label(13, romindex+i+1, label1_1String3);    
			         sheet.addCell(label16Label2Label);
				}
			}
			index++;
		}
        workbook.write();    
        workbook.close();   
	}
	public String getdatesortweek(int weeknum)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat dateFormat2=new SimpleDateFormat("MM.dd");
		Calendar calendar=Calendar.getInstance();
		Calendar calendar2=Calendar.getInstance();
		try {
			calendar2.setTime(dateFormat.parse(s_time));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		calendar2.set(Calendar.DATE, 1);
		List<String> list=new ArrayList<String>();
		try {
			calendar.setTime(dateFormat.parse(s_time));
			System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			System.out.println(calendar.getTime());
			for(int i=1;i<=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);i++)
			{
				calendar.set(Calendar.DATE, i);
				if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
				{
					list.add(dateFormat2.format(calendar2.getTime())+"-"+dateFormat2.format(calendar.getTime()));
				}
				if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)
				{
					calendar2.setTime(calendar.getTime());
				}
			}
			if(calendar.getTime().after(calendar2.getTime()))
			{
				list.add(dateFormat2.format(calendar2.getTime())+"-"+dateFormat2.format(calendar.getTime()));
			}
			System.out.println(list.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.get(weeknum);
		
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List reportlist(long id)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
		if(s_time==null||s_time.trim().length()==0)
		{
			s_time=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		String sql = "SELECT year(C_DATE) as C_YEAR, DATEPART (week,C_DATE) as C_MONTH, SUM(C_MONEY) as C_MONEY, SUM(C_LOW) as C_LOW, SUM(C_NORMAL) as C_NORMAL,"
				+ "SUM(C_HIGH) as C_HIGH FROM [DFHK_DB].[dbo].[T_RSECTOR] where convert(nvarchar(7),C_DATE,120)='"+s_time+"'"
				+ "and C_PERFORMANCEID="+id+"  group by DATEPART (week,C_DATE),year(C_DATE)";
		System.out.println(sql);
		return Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}
	/**
	 * 转向到部门绩效表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到部门绩效表修改页面
	 */	
	public String toedit()throws Exception{
		rsector = Server.getInstance().getAirService().findRsector(rsector.getId());
		i_date=formatTimestampyyyyMMdd(rsector.getDate());
		return EDIT;
	}
	
	/**
	 * 转向到部门绩效表审核页面
	 */	
	public String tocheck()throws Exception{
	rsector = Server.getInstance().getAirService().findRsector(rsector.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加部门绩效表
	 */		
	public String add()throws Exception{
		rsector.setDate(dateToTimestamp(i_date));
		Server.getInstance().getAirService().createRsector(rsector);
		return LIST;
	}

	/**
	 * 审核部门绩效表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateRsectorIgnoreNull(rsector);
		return LIST;
	}
	


	/**
	 * 编辑部门绩效表
	 */		
	public String edit()throws Exception{
		rsector.setDate(dateToTimestamp(i_date));
		Server.getInstance().getAirService().updateRsectorIgnoreNull(rsector);
		return LIST;
	}

	/**
	 * 删除部门绩效表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteRsector(rsector.getId());
		return LIST;
	}
	
	/**
	 * 获取部门类型和销售类型
	 */		
	public String gettype(long id){	
		Rperformance rperformance=Server.getInstance().getAirService().findRperformance(id);
		if(rperformance!=null)
		{
			StringBuffer buffer=new StringBuffer();
			buffer.append(getdepartmentNamebyId(rperformance.getDepartment()));
			if(rperformance.getType()==1)
			{
				buffer.append("-销售收入");
			}else if(rperformance.getType()==2)
			{
				buffer.append("-毛利指标");
			}else
			{
				buffer.append("-东航直销");
			}
			return buffer.toString();
		}
		return "未知";
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
					Server.getInstance().getAirService().deleteRsector(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回部门绩效表对象
	 */		
	
	public Object getModel() {
		return rsector;
	}
	public List < Rsector >   getListRsector() {
		return listRsector;
	}
	public void setListRsector(List <  Rsector  >  listRsector) {
		this.listRsector = listRsector;
	}
	public Rsector getRsector() {
		return rsector;
	}
	public void setRsector(Rsector rsector) {
		this.rsector = rsector;
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
	
	
}