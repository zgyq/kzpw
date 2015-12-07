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


import com.yf.system.back.server.Server;
import com.yf.system.base.ticketapp.Ticketapp;


public class TicketappAction extends B2b2cbackAction {
	private List <  Ticketapp  >  listTicketapp;
	private Ticketapp ticketapp = new Ticketapp();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询特价申请表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Ticketapp.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllTicketappForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTicketapp = list;
		  if(pageinfo.getTotalrow()>0 &&   listTicketapp.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllTicketappForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTicketapp = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到特价申请表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到特价申请表修改页面
	 */	
	public String toedit()throws Exception{
	ticketapp = Server.getInstance().getAirService().findTicketapp(ticketapp.getId());
		return EDIT;
	}
	
	/**
	 * 转向到特价申请表审核页面
	 */	
	public String tocheck()throws Exception{
	ticketapp = Server.getInstance().getAirService().findTicketapp(ticketapp.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加特价申请表
	 */		
	public String add()throws Exception{
	ticketapp.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createTicketapp(ticketapp);
		return LIST;
	}

	/**
	 * 审核特价申请表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateTicketappIgnoreNull(ticketapp);
		return LIST;
	}
	


	/**
	 * 编辑特价申请表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateTicketappIgnoreNull(ticketapp);
		return LIST;
	}

	/**
	 * 删除特价申请表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteTicketapp(ticketapp.getId());
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
					Server.getInstance().getAirService().deleteTicketapp(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回特价申请表对象
	 */		
	
	public Object getModel() {
		return ticketapp;
	}
	public List < Ticketapp >   getListTicketapp() {
		return listTicketapp;
	}
	public void setListTicketapp(List <  Ticketapp  >  listTicketapp) {
		this.listTicketapp = listTicketapp;
	}
	public Ticketapp getTicketapp() {
		return ticketapp;
	}
	public void setTicketapp(Ticketapp ticketapp) {
		this.ticketapp = ticketapp;
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