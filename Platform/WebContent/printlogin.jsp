<%@page import="com.yf.system.atom.server.Server"%>
<%@page import="com.yf.system.base.customeruser.Customeruser"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork.ActionContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<% 

List<Customeruser> listmember=Server.getInstance().getMemberService().findAllCustomeruser("","",-1,0);
System.out.println(listmember.size());
request.getSession().putValue("loginuser",listmember.get(0));
response.sendRedirect("http://localhost:8080/lthk_home/orderinfo!tob2c.action?s_orderstatus=3&s_send=1");
%>

