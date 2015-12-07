
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
<title>反馈信息</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">反馈意见查看</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="infocontent!<ww:if test="infocontent.id>0">edithelpinfo.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>addhelpinfo.action?<ww:property value="url"/></ww:else>" name="form1" method="POST">


<center>
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      	<tr>
						<td align="right"  width="30%">
						<h3>反馈人：</h3>
						</td>
						<td width="80%"><b><ww:property value="getfkname(tousu.username)" /></b></td>
						<td width="10%"></td>
					</tr>
					<tr>
						<td align="right">
						<h3>反馈内容：</h3>
						</td>
						<td><ww:property value="tousu.comment" /></td>
						<td></td>
					</tr>
						<tr>
						<td align="right">
						<h3>反馈时间：</h3>
						</td>
						<td><ww:property value="tousu.createtime" /></td>
						<td></td>
					    </tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<!-- 
						<td height="46" scrolling="no"><input type="button"
							class="button_d font-bai"
							onclick="window.location.href='tousu!showfklist.action';"
							name="Submit2" value=" 返回 "  /></td>
							 -->
						<td><input type="button" value="返回" onclick="window.location.href='member/newfankui.jsp'"></td>
					</tr>
	
    </table>
    </center>
  </td>
  </tr>
</table>
</form>
</td>
   </tr>
   </table>
</div>
</body>
</html>