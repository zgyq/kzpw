/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.ticketnumber.Ticketnumber;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.util.PageInfo;


public class TicketnumberAction extends B2b2cbackAction {
	private List <  Ticketnumber  >  listTicketnumber;
	private Ticketnumber ticketnumber = new Ticketnumber();
	private List<Tickettype> listTickettype=new ArrayList<Tickettype>();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询机票票号
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Ticketnumber.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllTicketnumberForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTicketnumber = list;
		  if(pageinfo.getTotalrow()>0 &&   listTicketnumber.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTicketnumberForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTicketnumber = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到机票票号添加页面
	 */	
	public String toadd()throws Exception{
		listTickettype=Server.getInstance().getMemberService().findAllTickettype("", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到机票票号修改页面
	 */	
	public String toedit()throws Exception{
		listTickettype=Server.getInstance().getMemberService().findAllTickettype("", "", -1, 0);
		ticketnumber = Server.getInstance().getMemberService().findTicketnumber(ticketnumber.getId());
		return EDIT;
	}
	
	/**
	 * 转向到机票票号审核页面
	 */	
	public String tocheck()throws Exception{
	ticketnumber = Server.getInstance().getMemberService().findTicketnumber(ticketnumber.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加机票票号
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createTicketnumber(ticketnumber);
		return LIST;
	}

	/**
	 * 审核机票票号
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTicketnumberIgnoreNull(ticketnumber);
		return LIST;
	}
	


	/**
	 * 编辑机票票号
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTicketnumberIgnoreNull(ticketnumber);
		return LIST;
	}

	/**
	 * 删除机票票号
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTicketnumber(ticketnumber.getId());
		return LIST;
	}

	public Tickettype getTickettypeById(long id)
	{
		return Server.getInstance().getMemberService().findTickettype(id);
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
					Server.getInstance().getMemberService().deleteTicketnumber(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回机票票号对象
	 */		
	
	public Object getModel() {
		return ticketnumber;
	}
	public List < Ticketnumber >   getListTicketnumber() {
		return listTicketnumber;
	}
	public void setListTicketnumber(List <  Ticketnumber  >  listTicketnumber) {
		this.listTicketnumber = listTicketnumber;
	}
	public Ticketnumber getTicketnumber() {
		return ticketnumber;
	}
	public void setTicketnumber(Ticketnumber ticketnumber) {
		this.ticketnumber = ticketnumber;
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
	public List<Tickettype> getListTickettype() {
		return listTickettype;
	}
	public void setListTickettype(List<Tickettype> listTickettype) {
		this.listTickettype = listTickettype;
	}
	
	
}