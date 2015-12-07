/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.website.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.ticketnumber.Ticketnumber;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

/**
 * jquery.validationEngine.js ajax异步验证类，输出效果仿照jquery.validationEngine.js 中返回的json
 * @author Administrator
 *
 */
public class ValidateAction extends B2b2cbackAction {
	/**
	 * 验证会员手机号码是否存在
	 * @throws Exception
	 */
	public void validateliudianname() throws Exception {
			ActionContext ac = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ac
			.get(ServletActionContext.HTTP_REQUEST);
			String validateId = request.getParameter("validateId");
			String validateValue = request.getParameter("validateValue");
			String validateError = request.getParameter("validateError");
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			
			if(!Server.getInstance().getMemberService().findAllSettlementtype("where 1 = 1 and "+Settlementtype.COL_typename+" = '"+validateValue+"' and "+Settlementtype.COL_agentid+" ="+getLoginUser().getAgentid(),"",-1,0).isEmpty()){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
			//验证失败写false 成功返回true
			}else{
				out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
			}
			out.flush();
	    	out.close();

			
		}
/**
 * 验证会员手机号码是否存在
 * @throws Exception
 */
public void validatemobile() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeruser("where 1 = 1 and "+Customeruser.COL_mobile+" = '"+validateValue+"' and "+Customeruser.COL_membertype+" =1","",-1,0).isEmpty()){
		out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
		//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}

public void validatemobileById() throws Exception {
	ActionContext ac = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) ac
	.get(ServletActionContext.HTTP_REQUEST);
	String validateId = request.getParameter("validateId");
	String customeruid=validateId.substring(9);
	String validateValue = request.getParameter("validateValue");
	String validateError = request.getParameter("validateError");
	PrintWriter out = ServletActionContext.getResponse().getWriter();
	String where="where 1 = 1 and "+Customeruser.COL_mobile+" = '"+validateValue+"' and "+Customeruser.COL_id+" !="+customeruid+" and "+Customeruser.COL_membertype+" =1";
	//System.out.println(where);
	if(!Server.getInstance().getMemberService().findAllCustomeruser(where,"",-1,0).isEmpty()){
		out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
		//验证失败写false 成功返回true
	}else{
		out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
	}
	out.flush();
	out.close();
	
	
}

public void validatecode() throws IOException{
	HttpServletRequest request=ServletActionContext.getRequest();
	String validateId = request.getParameter("validateId");
	String validateValue = request.getParameter("validateValue");
	String validateError = request.getParameter("validateError");
	PrintWriter out = ServletActionContext.getResponse().getWriter();
	String where="SELECT ID FROM [T_CUSTOMERAGENT] WHERE C_CODE ='"+validateValue.trim()+"'";
	List<Customeragent> list=Server.getInstance().getMemberService().findAllCustomeragentBySql(where, -1, 0); 
	if(!list.isEmpty()){
		out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
	}else{
		out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
	}
	out.flush();
	out.close();
	
}
/**
 * 验证员工手机号码是否存在
 * @throws Exception
 */
public void validateusermobile() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeruser("where 1 = 1 and "+Customeruser.COL_mobile+" = '"+validateValue+"' and "+Customeruser.COL_membertype+" =2","",-1,0).isEmpty()){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
		//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}
/**
 * 验证员工手机号码是否存在
 * @throws Exception
 */
public void validateloginmobile() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeruser("where 1 = 1 and "+Customeruser.COL_mobile+" = '"+validateValue+"' and "+Customeruser.COL_membertype+" =1","",-1,0).isEmpty()){
			out.print("false");
		//验证失败写false 成功返回true
		}else{
			out.print("true");
		}
		out.flush();
    	out.close();

		
	}
/**
 * 验证邮箱是否存在
 * @throws Exception
 */
public void validateemail() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeruser("where 1 = 1 and "+Customeruser.COL_memberemail+" = '"+validateValue+"'","",-1,0).isEmpty()){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
		//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}

/**
 * 验证邮箱是否存在
 * @throws Exception
 */
public void validateloginemail() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeruser("where 1 = 1 and "+Customeruser.COL_memberemail+" = '"+validateValue+"' and "+Customeruser.COL_membertype+" =1","",-1,0).isEmpty()){
			out.print("false");
		//验证失败写false 成功返回true
		}else{
			out.print("true");
		}
		out.flush();
    	out.close();

		
	}
/**
 * 票号是否存在
 * @throws Exception
 */
public void validateticketnumber() throws Exception {
	
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String sql=" where "+Ticketnumber.COL_beginnumber+" >= '"+validateValue+"' and "+Ticketnumber.COL_endnumber+" <= '"+validateValue+"'";
		List<Ticketnumber> list=Server.getInstance().getMemberService().findAllTicketnumber(sql, "", -1, 0);
		if(list!=null&&list.size()>0){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
		//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();
}
/**
 * 检测用户名是否存在
 * @throws Exception
 */
public void validateusername() throws Exception {
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
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		//String where="where 1 = 1 AND ID !="+uidstr+" and "+Customeruser.COL_loginname+" = '"+validateValue+"'";
		String where="where 1 = 1  and "+Customeruser.COL_loginname+" = '"+validateValue+"'";
		
		List list=Server.getInstance().getMemberService().findAllCustomeruser(where,"",-1,0);
		System.out.println(list.size());
		if(list.size()>0){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
			//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}
/**
 * 检测用户名是否存在
 * @throws Exception
 */
public void validateloginname() throws Exception {
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
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		//String where="where 1 = 1 AND ID !="+uidstr+" and "+Customeruser.COL_loginname+" = '"+validateValue+"'";
		String where="where 1 = 1  and "+Customeruser.COL_loginname+" = '"+validateValue+"'";
		
		List list=Server.getInstance().getMemberService().findAllCustomeruser(where,"",-1,0);
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
 * 检测加盟商代理是否存在
 * @throws Exception
 */
public void validateAgentCode() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String agentid="0";
		try{
		 agentid=validateId.substring(4);
		}catch(Exception e){
			
		}
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeragent("where 1 = 1 AND ID!="+agentid+" and "+Customeragent.COL_code+" = '"+validateValue+"'","",-1,0).isEmpty()){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
			//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}
/**
 * 检测加盟商代理名称是否存在
 * @throws Exception
 */
public void validateAgentName() throws Exception {
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ac
		.get(ServletActionContext.HTTP_REQUEST);
		String validateId = request.getParameter("validateId");
		String agentid="0";
		try{
		 agentid=validateId.substring(7);
		}catch(Exception e){
			
		}
		String validateValue = request.getParameter("validateValue");
		String validateError = request.getParameter("validateError");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!Server.getInstance().getMemberService().findAllCustomeragent("where 1 = 1 AND ID !="+agentid+" and "+Customeragent.COL_agentcompanyname+" = '"+validateValue+"'","",-1,0).isEmpty()){
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','false']}");
			//验证失败写false 成功返回true
		}else{
			out.print("{'jsonValidateReturn':['"+validateId+"','"+validateError+"','true']}");
		}
		out.flush();
    	out.close();

		
	}


	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}