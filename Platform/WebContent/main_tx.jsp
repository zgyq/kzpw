<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<%@page import="java.util.List"%>

<%@page import="com.yf.system.back.server.Server"%>
<%@page import="com.yf.system.base.customeruser.Customeruser"%>
<%@page import="com.yf.system.base.agentroleref.Agentroleref"%>
<%@page import="com.yf.system.base.systemright.Systemright"%>
<%@page import="com.yf.system.base.sysroleright.Sysroleright"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
a span {
	color:#ff9955;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.address}</title>
<script src="js/jquery1.3.2.js"></script>
<script src="js/jquery.messager.js"></script>


</head>



<frameset rows="110,*,22" cols="*" frameborder="no" border="0" framespacing="0" onload="onlod();">
  <!-- top  -->
  <frame src="#" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"  />
  <!-- middle -->
  <frameset rows="*" cols="190,6,*" framespacing="0" frameborder="0" border="false" id="mainFrame" scrolling="yes">
  
  <frame name="left"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0" src="main_tx/left.jsp">
    <frame name="middle" scrolling="no" frameborder="0" noresize="noresize"  src="middle.jsp" />
    <frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="#" />
  <!--
  <frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/login!towelcome.action?first=true" />
	-->
</frameset>
<!-- bottom -->
  <frame src="main/bottom.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame"  />
</frameset>
<noframes>
  <body leftmargin="2" topmargin="0" marginwidth="0" marginheight="0" >

  <p>你的浏览器版本过低！！！本系统要求IE5及以上版本才能使用本系统。</p>
  </body>
</noframes>
</html>
