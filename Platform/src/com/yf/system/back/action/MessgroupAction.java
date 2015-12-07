/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.messgroup.Messgroup;
import com.yf.system.base.templet.Templet;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;


public class MessgroupAction extends B2b2cbackAction {
	private List <  Messgroup  >  listMessgroup;
	private Messgroup messgroup = new Messgroup();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	private String messnumbers;
	
	
	/**
	 * 列表查询短信用户组
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Messgroup.COL_messname +" like '%" + s_name.trim()+"%'";	
		}
		pageinfo.setPagerow(12);
	    List list = Server.getInstance().getMemberService().findAllMessgroupForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listMessgroup = list;
		  if(pageinfo.getTotalrow()>0 &&   listMessgroup.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllMessgroupForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listMessgroup = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到短信用户组添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到短信用户组修改页面
	 */	
	public String toedit()throws Exception{
	messgroup = Server.getInstance().getMemberService().findMessgroup(messgroup.getId());
		return EDIT;
	}
	
	/**
	 * 转向到短信用户组审核页面
	 */	
	public String tocheck()throws Exception{
	messgroup = Server.getInstance().getMemberService().findMessgroup(messgroup.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加短信用户组
	 */		
	public String add()throws Exception{
	messgroup.setCreatetime(new Timestamp(System.currentTimeMillis()));
		messgroup.setCreateuserid(getLoginUser().getId());
		String numbers=messnumbers.replace("，", ",");
		messgroup.setMessnums(numbers);
		Server.getInstance().getMemberService().createMessgroup(messgroup);
		return LIST;
	}

	/**
	 * 审核短信用户组
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateMessgroupIgnoreNull(messgroup);
		return LIST;
	}
	


	/**
	 * 编辑短信用户组
	 */		
	public String edit()throws Exception{
		String numbers=messnumbers.replace("，", ",");
		messgroup.setMessnums(numbers);
		Server.getInstance().getMemberService().updateMessgroupIgnoreNull(messgroup);
		return LIST;
	}

	/**
	 * 删除短信用户组
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteMessgroup(messgroup.getId());
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
					Server.getInstance().getMemberService().deleteMessgroup(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}



	public void validatemessname() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String uidstr="0";
		try{
			if(validateId.length()>9)
		 uidstr=validateId.substring(9);
		 
		}catch(Exception e){
			
		}
		String validateValue = request.getParameter("validateValue");
		String strs=new String(validateValue.getBytes("iso-8859-1"),"gbk");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		//String where="where 1 = 1 AND ID !="+uidstr+" and "+Customeruser.COL_loginname+" = '"+validateValue+"'";
		String where="where 1 = 1  and "+Messgroup.COL_messname+" = '"+strs+"'";
		List list=Server.getInstance().getMemberService().findAllMessgroup(where, "", -1, 0);
		System.out.println(list.size());
		if(list.size()>0){
			out.print("false");
			//验证失败写false 成功返回true
		}else{
			out.print("true");
		}
		out.flush();
    	out.close();

	}


	/**
	 *  返回短信用户组对象
	 */		
	
	public Object getModel() {
		return messgroup;
	}
	public List < Messgroup >   getListMessgroup() {
		return listMessgroup;
	}
	public void setListMessgroup(List <  Messgroup  >  listMessgroup) {
		this.listMessgroup = listMessgroup;
	}
	public Messgroup getMessgroup() {
		return messgroup;
	}
	public void setMessgroup(Messgroup messgroup) {
		this.messgroup = messgroup;
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
	public String getMessnumbers() {
		return messnumbers;
	}
	public void setMessnumbers(String messnumbers) {
		this.messnumbers = messnumbers;
	}
	
	
}