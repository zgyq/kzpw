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
import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.bussiness.Bussiness;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.templet.Templet;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;


public class TempletAction extends B2b2cbackAction {
	private List <  Templet  >  listTemplet;
	private Templet templet = new Templet();
	private List<Bussiness> listbussiness;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	private String ttype;
	private String yewu;
	
	
	public String getYewu() {
		return yewu;
	}
	public void setYewu(String yewu) {
		this.yewu = yewu;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	/**
	 * 列表查询模板
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Templet.COL_templetname +" like '%" + s_name.trim()+"%'";	
		}
		if(ttype!=null){
			
			where += " and " + Templet.COL_templettype +" like '%" + ttype.trim()+"%'";
		}
		if(yewu!=null){	
			where += " and " + Templet.COL_templetyewu +" like '%" + yewu.trim()+"%'";
		}
		pageinfo.setPagerow(12);
	    List list = Server.getInstance().getMemberService().findAllTempletForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listbussiness=getLoginUserAgent().getBussinesslist();
		listTemplet = list;
		  if(pageinfo.getTotalrow()>0 &&   listTemplet.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTempletForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTemplet = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到模板添加页面
	 */	
	public String toadd()throws Exception{
		listbussiness=getLoginUserAgent().getBussinesslist();
		return EDIT;
	}
	/**
	 * 转向到模板修改页面
	 */	
	public String toedit()throws Exception{
	templet = Server.getInstance().getMemberService().findTemplet(templet.getId());
	listbussiness=getLoginUserAgent().getBussinesslist();
		return EDIT;
	}
	
	/**
	 * 转向到模板审核页面
	 */	
	public String tocheck()throws Exception{
	templet = Server.getInstance().getMemberService().findTemplet(templet.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加模板
	 */		
	public String add()throws Exception{
	templet.setCreatetime(new Timestamp(System.currentTimeMillis()));
		templet.setCreateuserid(getLoginUser().getId());
		Server.getInstance().getMemberService().createTemplet(templet);
		return LIST;
	}

	/**
	 * 审核模板
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTempletIgnoreNull(templet);
		return LIST;
	}
	


	/**
	 * 编辑模板
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTempletIgnoreNull(templet);
		return LIST;
	}

	/**
	 * 删除模板
	 */		
	public String delete()throws Exception{	
//		templet=Server.getInstance().getMemberService().findTemplet(templet.getId());
//		if(templet.getTemplettype().equals("自定义模板")){
			Server.getInstance().getMemberService().deleteTemplet(templet.getId());
//		}else{
//			HttpServletResponse response = ServletActionContext.getResponse();  
//			response.setCharacterEncoding("GBK");
//			PrintWriter writer = response.getWriter();
//			writer.println("<script language='javascript'>alert('标准模板不能删除');</script>"); 
//		}
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
					Server.getInstance().getMemberService().deleteTemplet(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}

	public void validatetempletname() throws Exception {
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
		String where="where 1 = 1  and "+Templet.COL_templetname+" = '"+strs+"'";
		
		List list=Server.getInstance().getMemberService().findAllTemplet(where, "", -1, 0);
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
	 *  返回模板对象
	 */		
	
	public Object getModel() {
		return templet;
	}
	public List < Templet >   getListTemplet() {
		return listTemplet;
	}
	public void setListTemplet(List <  Templet  >  listTemplet) {
		this.listTemplet = listTemplet;
	}
	public Templet getTemplet() {
		return templet;
	}
	public void setTemplet(Templet templet) {
		this.templet = templet;
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
	public List<Bussiness> getListbussiness() {
		return listbussiness;
	}
	public void setListbussiness(List<Bussiness> listbussiness) {
		this.listbussiness = listbussiness;
	}
	
	
}