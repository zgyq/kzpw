<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="sysconfig.id>0">编辑</ww:if><ww:else>新增</ww:else>首页旅游信息</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;首页旅游信息</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="sysconfig!edittravelindex.action?id=<ww:property value="sysconfig.id"/>&<ww:property value="url"/>" name="form1" 
method="POST">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
      	<td width="100">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
	 <tr>
	 <td width="100">&nbsp;</td>
	 <td>
	 <FCK:editor id="value" basePath="fck/" width="680" height="400" >
		<ww:property value="sysconfig.value"/>
		</FCK:editor>
		</td> 
	
	 </tr>
	
      
      <tr class="font-blue-xi">
      <td width="100">&nbsp;</td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='sysconfig.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</td>
   </tr>
   </table>
</div>
</body>
</html>


