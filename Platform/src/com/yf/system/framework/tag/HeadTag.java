package com.yf.system.framework.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.webwork.views.jsp.ui.AbstractUITag;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author 小陈 此类参照自带Tag 譬如：form标签
 * 
 */
public class HeadTag extends AbstractUITag {
	/**
	 * The name of the default template for the Head
	 */
	final public static String TEMPLATE = "head";

	// ~ Instance fields
	// ////////////////////////////////////////////////////////

	protected String nameAttr;
	protected String cssClassAttr;
	public HttpServletRequest request;
	public HttpSession session;
	// ~ Methods
	// ////////////////////////////////////////////////////////////////

	public void setName(String name) {
		this.nameAttr = name;
	}


	public void setCssClass(String cssClass) {
		this.cssClassAttr = cssClass;
	}
	
	public HttpServletRequest getRequest() {
		if(request==null){
			request=ServletActionContext.getRequest();
		}
		return request;
	}
	public HttpSession getSession() {
		if(session==null){
			session=this.getRequest().getSession();
		}
		return session;
	}

	public void evaluateExtraParams(OgnlValueStack stack) {
		System.out.println(this.getRequest().getParameter("sex"));
		super.evaluateExtraParams(stack);
		if (nameAttr != null) {
			addParameter("name", nameAttr);
		}
		if (cssClassAttr != null) {
			addParameter("cssClass", cssClassAttr);
		}
		this.addParameter("request", this.getRequest());
		//setSessionParameter();
	}
	
	public void setSessionParameter(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object themeobj = session.getAttribute("themename");
		String themename = "black";//默认主题
		if (themeobj != null) {
			String theme=themeobj.toString();
			String name = request.getParameter("themename");
			if (name != null && name.trim()!= "") {
				themename = name;
			}else{
				themename=theme;
			}
		}
		addParameter("themename",themename);
		session.setAttribute("themename", themename);
		
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

}
