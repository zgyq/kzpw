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
import com.yf.system.base.xcdno.Xcdno;
import com.yf.system.base.xcdnoinfo.Xcdnoinfo;


public class XcdnoinfoAction extends B2b2cbackAction {
	private List <  Xcdnoinfo  >  listXcdnoinfo;
	private Xcdnoinfo xcdnoinfo = new Xcdnoinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	private long s_xcdid;
	
	//以下查询用
	private String s_agentcode;//
	private String s_office;//
	private String s_tiankai;//
	private String s_lingdan;//
	private int s_state=-1;
	
	
	/**
	 * 列表查询行程单号码
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(s_xcdid>0){
			where +=" AND "+Xcdnoinfo.COL_xcdid+" ="+s_xcdid;
		}
		if(getLoginUser().getAgentid()!=46){
			where +=" AND "+Xcdnoinfo.COL_agentid+" ="+getLoginUser().getAgentid();
		}
		
		if (s_state>0) {
			
			where += " and " + Xcdnoinfo.COL_state +" ="+s_state;	
		}
		
		if (s_agentcode!=null && s_agentcode.trim().length()!=0) {
			
			where += " and " + Xcdnoinfo.COL_xcdinfo +" like '%" + s_agentcode.trim()+"%'";	
		}
		
		if (s_tiankai!=null && s_tiankai.trim().length()!=0) {
			
			where += " and " + Xcdnoinfo.COL_companyname+" like '%" + s_tiankai.trim()+"%'";	
		}
		if (s_lingdan!=null && s_lingdan.trim().length()!=0) {
			where += " and " + Xcdnoinfo.COL_agentid +" in( SELECT "+Customeragent.COL_id+" FROM "+Customeragent.TABLE+" WHERE 1=1 and ( "+Customeragent.COL_agentcompanyname+" LIKE '%"+s_lingdan.trim()+"%' OR "+Customeragent.COL_agentshortname+" LIKE '%"+s_lingdan.trim()+"%' ))";	
		}
	    List list = Server.getInstance().getAirService().findAllXcdnoinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listXcdnoinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listXcdnoinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllXcdnoinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listXcdnoinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程单号码添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到行程单号码修改页面
	 */	
	public String toedit()throws Exception{
	xcdnoinfo = Server.getInstance().getAirService().findXcdnoinfo(xcdnoinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程单号码审核页面
	 */	
	public String tocheck()throws Exception{
	xcdnoinfo = Server.getInstance().getAirService().findXcdnoinfo(xcdnoinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程单号码
	 */		
	public String add()throws Exception{
	xcdnoinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createXcdnoinfo(xcdnoinfo);
		return LIST;
	}

	/**
	 * 审核行程单号码
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateXcdnoinfoIgnoreNull(xcdnoinfo);
		return LIST;
	}
	


	/**
	 * 编辑行程单号码
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateXcdnoinfoIgnoreNull(xcdnoinfo);
		return LIST;
	}

	/**
	 * 删除行程单号码
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteXcdnoinfo(xcdnoinfo.getId());
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
					Server.getInstance().getAirService().deleteXcdnoinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程单号码对象
	 */		
	
	public Object getModel() {
		return xcdnoinfo;
	}
	public List < Xcdnoinfo >   getListXcdnoinfo() {
		return listXcdnoinfo;
	}
	public void setListXcdnoinfo(List <  Xcdnoinfo  >  listXcdnoinfo) {
		this.listXcdnoinfo = listXcdnoinfo;
	}
	public Xcdnoinfo getXcdnoinfo() {
		return xcdnoinfo;
	}
	public void setXcdnoinfo(Xcdnoinfo xcdnoinfo) {
		this.xcdnoinfo = xcdnoinfo;
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
	public long getS_xcdid() {
		return s_xcdid;
	}
	public void setS_xcdid(long s_xcdid) {
		this.s_xcdid = s_xcdid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_agentcode() {
		return s_agentcode;
	}
	public void setS_agentcode(String s_agentcode) {
		this.s_agentcode = s_agentcode;
	}
	public String getS_office() {
		return s_office;
	}
	public void setS_office(String s_office) {
		this.s_office = s_office;
	}
	public String getS_tiankai() {
		return s_tiankai;
	}
	public void setS_tiankai(String s_tiankai) {
		this.s_tiankai = s_tiankai;
	}
	public String getS_lingdan() {
		return s_lingdan;
	}
	public void setS_lingdan(String s_lingdan) {
		this.s_lingdan = s_lingdan;
	}
	public int getS_state() {
		return s_state;
	}
	public void setS_state(int s_state) {
		this.s_state = s_state;
	}
	
	
}