/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.util.PageInfo;


public class TickettypeAction extends B2b2cbackAction {
	private List <  Tickettype  >  listTickettype;
	private Tickettype tickettype = new Tickettype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询机票类型
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Tickettype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllTickettypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTickettype = list;
		  if(pageinfo.getTotalrow()>0 &&   listTickettype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTickettypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTickettype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到机票类型添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到机票类型修改页面
	 */	
	public String toedit()throws Exception{
	tickettype = Server.getInstance().getMemberService().findTickettype(tickettype.getId());
		return EDIT;
	}
	
	/**
	 * 转向到机票类型审核页面
	 */	
	public String tocheck()throws Exception{
	tickettype = Server.getInstance().getMemberService().findTickettype(tickettype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加机票类型
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createTickettype(tickettype);
		return LIST;
	}

	/**
	 * 审核机票类型
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTickettypeIgnoreNull(tickettype);
		return LIST;
	}
	


	/**
	 * 编辑机票类型
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTickettypeIgnoreNull(tickettype);
		return LIST;
	}

	/**
	 * 删除机票类型
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTickettype(tickettype.getId());
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
					Server.getInstance().getMemberService().deleteTickettype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回机票类型对象
	 */		
	
	public Object getModel() {
		return tickettype;
	}
	public List < Tickettype >   getListTickettype() {
		return listTickettype;
	}
	public void setListTickettype(List <  Tickettype  >  listTickettype) {
		this.listTickettype = listTickettype;
	}
	public Tickettype getTickettype() {
		return tickettype;
	}
	public void setTickettype(Tickettype tickettype) {
		this.tickettype = tickettype;
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