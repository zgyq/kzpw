/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.yf.system.back.server.Server;
import com.yf.system.base.rzhixiao.Rzhixiao;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class RzhixiaoAction extends B2b2cbackAction {
	private List <  Rzhixiao  >  listRzhixiao;
	private Rzhixiao rzhixiao = new Rzhixiao();
	
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
	 * 列表查询直销汇总表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Rzhixiao.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllRzhixiaoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRzhixiao = list;
		  if(pageinfo.getTotalrow()>0 &&   listRzhixiao.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllRzhixiaoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRzhixiao = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 导出xls
	 * @throws IOException 
	 * @throws WriteException 
	 */
	public void down() throws IOException, WriteException
	{
		String fileName="东航直销汇总表.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                   
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		WritableSheet sheet = workbook.createSheet("东航直销汇总表", 0); 
		
        workbook.write();    
        workbook.close();   
	}
	/**
	 * 转向到直销汇总表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到直销汇总表修改页面
	 */	
	public String toedit()throws Exception{
	rzhixiao = Server.getInstance().getAirService().findRzhixiao(rzhixiao.getId());
	i_date=formatTimestampyyyyMMdd(rzhixiao.getDatetime());
		return EDIT;
	}
	
	/**
	 * 转向到直销汇总表审核页面
	 */	
	public String tocheck()throws Exception{
	rzhixiao = Server.getInstance().getAirService().findRzhixiao(rzhixiao.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加直销汇总表
	 */		
	public String add()throws Exception{
		rzhixiao.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().createRzhixiao(rzhixiao);
		return LIST;
	}

	/**
	 * 审核直销汇总表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateRzhixiaoIgnoreNull(rzhixiao);
		return LIST;
	}
	


	/**
	 * 编辑直销汇总表
	 */		
	public String edit()throws Exception{
		rzhixiao.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().updateRzhixiaoIgnoreNull(rzhixiao);
		return LIST;
	}
	

	/**
	 * 删除直销汇总表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteRzhixiao(rzhixiao.getId());
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
					Server.getInstance().getAirService().deleteRzhixiao(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回直销汇总表对象
	 */		
	
	public Object getModel() {
		return rzhixiao;
	}
	public List < Rzhixiao >   getListRzhixiao() {
		return listRzhixiao;
	}
	public void setListRzhixiao(List <  Rzhixiao  >  listRzhixiao) {
		this.listRzhixiao = listRzhixiao;
	}
	public Rzhixiao getRzhixiao() {
		return rzhixiao;
	}
	public void setRzhixiao(Rzhixiao rzhixiao) {
		this.rzhixiao = rzhixiao;
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