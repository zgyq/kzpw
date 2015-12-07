/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yf.system.back.server.Server;
import com.yf.system.base.rdepartment.Rdepartment;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class RdepartmentAction extends B2b2cbackAction {
	private List <  Rdepartment  >  listRdepartment;
	private Rdepartment rdepartment = new Rdepartment();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String i_date;
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	/**
	 * 列表查询部门销售汇总表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Rdepartment.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllRdepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRdepartment = list;
		  if(pageinfo.getTotalrow()>0 &&   listRdepartment.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllRdepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRdepartment = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 导出xls
	 */	
	public void down()throws Exception{
		String fileName="部门销售汇总表.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                   
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		WritableSheet sheet = workbook.createSheet("部门销售汇总表", 0); 
		
        workbook.write();    
        workbook.close();   
	}
	/**
	 * 转向到部门销售汇总表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到部门销售汇总表修改页面
	 */	
	public String toedit()throws Exception{
	rdepartment = Server.getInstance().getAirService().findRdepartment(rdepartment.getId());
	i_date=formatTimestampyyyyMMdd(rdepartment.getDatetime());
		return EDIT;
	}
	
	/**
	 * 转向到部门销售汇总表审核页面
	 */	
	public String tocheck()throws Exception{
	rdepartment = Server.getInstance().getAirService().findRdepartment(rdepartment.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加部门销售汇总表
	 */		
	public String add()throws Exception{
		rdepartment.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().createRdepartment(rdepartment);
		return LIST;
	}

	/**
	 * 审核部门销售汇总表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateRdepartmentIgnoreNull(rdepartment);
		return LIST;
	}
	


	/**
	 * 编辑部门销售汇总表
	 */		
	public String edit()throws Exception{
		rdepartment.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().updateRdepartmentIgnoreNull(rdepartment);
		return LIST;
	}

	/**
	 * 删除部门销售汇总表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteRdepartment(rdepartment.getId());
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
					Server.getInstance().getAirService().deleteRdepartment(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回部门销售汇总表对象
	 */		
	
	public Object getModel() {
		return rdepartment;
	}
	public List < Rdepartment >   getListRdepartment() {
		return listRdepartment;
	}
	public void setListRdepartment(List <  Rdepartment  >  listRdepartment) {
		this.listRdepartment = listRdepartment;
	}
	public Rdepartment getRdepartment() {
		return rdepartment;
	}
	public void setRdepartment(Rdepartment rdepartment) {
		this.rdepartment = rdepartment;
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