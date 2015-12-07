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
<title><ww:if test="infocontent.id>0">编辑</ww:if><ww:else>新增</ww:else>帮助中心内容</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="infocontent.id>0">编辑</ww:if><ww:else>新增</ww:else>帮助中心内容</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="infocontent!<ww:if test="infocontent.id>0">edithelpinfo.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>addhelpinfo.action?<ww:property value="url"/></ww:else>" name="form1" method="POST">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>帮助标题：</span></td><td><input type="text" require="true" dataType="Require"   msg="标题不能为空" name="title" value='<ww:property value="infocontent.title"/>'" style="width:350px" /></td>  </tr>
	
				 
 <tr><td height="28" align="right"><span>帮助类型：</span></td><td>
	 <!--<input type="text" require="true" dataType="Require"   msg="信息类型不能为空" name="typeid" value='<ww:property value="infocontent.typeid"/>'" style="width:350px" />
	 -->
	 <select name="infocontent.typeid">
	 <ww:iterator value="infotypelist">
	 <option value="<ww:property value="id"/>" ><ww:property value="typename"/></option>
     </ww:iterator>
	 </select>
	 </td>  </tr>
	 <tr><td height="28" align="right"><span>帮助内容：</span></td><td>
	 <!-- <textarea rows="8" require="true" dataType="Require"   msg="内容不能为空" name="content"  style="width:350px" ><ww:property value="infocontent.content"/></textarea> -->
	<FCK:editor id="content" basePath="fck/" width="680" height="400" >
	<ww:property value="infocontent.content"/>
	</FCK:editor>
	<FCK:editor id="content" basePath="fck/" width="400" height="400"></FCK:editor>
	</td>  </tr>
 
	 
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='infocontent.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


