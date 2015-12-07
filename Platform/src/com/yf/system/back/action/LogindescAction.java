/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.logindesc.Logindesc;



public class LogindescAction extends B2b2cbackAction {
	private List <  Logindesc  >  listLogindesc;
	private Logindesc logindesc = new Logindesc();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	
	/**
	 * 列表查询登录信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Logindesc.COL_loginname +" like '%" + s_name.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getMemberService().findAllLogindescForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listLogindesc = list;
		  if(pageinfo.getTotalrow()>0 &&   listLogindesc.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllLogindescForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listLogindesc = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到登录信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到登录信息修改页面
	 */	
	public String toedit()throws Exception{
	logindesc = Server.getInstance().getMemberService().findLogindesc(logindesc.getId());
		return EDIT;
	}
	
	/**
	 * 转向到登录信息审核页面
	 */	
	public String tocheck()throws Exception{
	logindesc = Server.getInstance().getMemberService().findLogindesc(logindesc.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加登录信息
	 */		
	public String add()throws Exception{
	logindesc.setCreateuser(getLoginUser().getLoginname());
		logindesc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		logindesc.setModifyuser(getLoginUser().getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createLogindesc(logindesc);
		return LIST;
	}

	/**
	 * 审核登录信息
	 */		
	public String check()throws Exception{
	logindesc.setModifyuser(getLoginUser().getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateLogindescIgnoreNull(logindesc);
		return LIST;
	}
	


	/**
	 * 编辑登录信息
	 */		
	public String edit()throws Exception{
	logindesc.setModifyuser(getLoginUser().getLoginname());
		logindesc.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateLogindescIgnoreNull(logindesc);
		return LIST;
	}

	/**
	 * 删除登录信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteLogindesc(logindesc.getId());
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
					Server.getInstance().getMemberService().deleteLogindesc(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回登录信息对象
	 */		
	
	public Object getModel() {
		return logindesc;
	}
	public List < Logindesc >   getListLogindesc() {
		return listLogindesc;
	}
	public void setListLogindesc(List <  Logindesc  >  listLogindesc) {
		this.listLogindesc = listLogindesc;
	}
	public Logindesc getLogindesc() {
		return logindesc;
	}
	public void setLogindesc(Logindesc logindesc) {
		this.logindesc = logindesc;
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
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	
}