/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.xcdorder.Xcdorder;


public class XcdorderAction extends B2b2cbackAction {
	private List <  Xcdorder  >  listXcdorder;
	private Xcdorder xcdorder = new Xcdorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_ticketnum;
	private String s_pnr;
	private String s_xcdno;
	private String s_compname;
	
	/**
	 * 列表查询行程单订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_ticketnum!=null && s_ticketnum.trim().length()!=0) {
			
			where += " and " + Xcdorder.COL_ticketno +" like '%" + s_ticketnum.trim()+"%'";	
		}
		if (s_pnr!=null && s_pnr.trim().length()!=0) {
			
			where += " and " + Xcdorder.COL_pnr +" like '%" + s_pnr.trim()+"%'";	
		}
		if (s_xcdno!=null && s_xcdno.trim().length()!=0) {
			
			where += " and " + Xcdorder.COL_xcdinfo +" like '%" + s_xcdno.trim()+"%'";	
		}
		if (s_compname!=null && s_compname.trim().length()!=0) {
			
			where += " and " + Xcdorder.COL_agentid +" in( SELECT "+Customeragent.COL_id+" FROM "+Customeragent.TABLE+" WHERE 1=1 and ( "+Customeragent.COL_agentcompanyname+" LIKE '%"+s_compname.trim()+"%' OR "+Customeragent.COL_agentshortname+" LIKE '%"+s_compname.trim()+"%' ))";	
		}
		System.out.println("where:"+where);
	    List list = Server.getInstance().getAirService().findAllXcdorderForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listXcdorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listXcdorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllXcdorderForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listXcdorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程单订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到行程单订单修改页面
	 */	
	public String toedit()throws Exception{
	xcdorder = Server.getInstance().getAirService().findXcdorder(xcdorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程单订单审核页面
	 */	
	public String tocheck()throws Exception{
	xcdorder = Server.getInstance().getAirService().findXcdorder(xcdorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程单订单
	 */		
	public String add()throws Exception{
	xcdorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createXcdorder(xcdorder);
		return LIST;
	}

	/**
	 * 审核行程单订单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateXcdorderIgnoreNull(xcdorder);
		return LIST;
	}
	


	/**
	 * 编辑行程单订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateXcdorderIgnoreNull(xcdorder);
		return LIST;
	}

	/**
	 * 删除行程单订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteXcdorder(xcdorder.getId());
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
					Server.getInstance().getAirService().deleteXcdorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程单订单对象
	 */		
	
	public Object getModel() {
		return xcdorder;
	}
	public List < Xcdorder >   getListXcdorder() {
		return listXcdorder;
	}
	public void setListXcdorder(List <  Xcdorder  >  listXcdorder) {
		this.listXcdorder = listXcdorder;
	}
	public Xcdorder getXcdorder() {
		return xcdorder;
	}
	public void setXcdorder(Xcdorder xcdorder) {
		this.xcdorder = xcdorder;
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
	public String getS_ticketnum() {
		return s_ticketnum;
	}
	public void setS_ticketnum(String s_ticketnum) {
		this.s_ticketnum = s_ticketnum;
	}
	public String getS_pnr() {
		return s_pnr;
	}
	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}
	public String getS_xcdno() {
		return s_xcdno;
	}
	public void setS_xcdno(String s_xcdno) {
		this.s_xcdno = s_xcdno;
	}
	public String getS_compname() {
		return s_compname;
	}
	public void setS_compname(String s_compname) {
		this.s_compname = s_compname;
	}
	
	
}