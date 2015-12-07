<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotelimage.id>0">修改</ww:if>酒店地标</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body>
<form enctype="multipart/form-data" action="hotelstate!edit.action?hotelId=<ww:property value="hotelId"/>&<ww:property value="url"/>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">
<input type="hidden" name="hotelId" value="<ww:property value="hotelId"/>" /> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="hotelimage.id>0">编辑</ww:if>酒店状态</span></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        			 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">状态：</span></td><td><select name="hotelstate">
	     <option  value="3" <ww:if test="hotelstate==3">selected="selected"</ww:if>>上网</option>
	     <option  value="4" <ww:if test="hotelstate==4">selected="selected"</ww:if>>下网</option>
	     </select>    
	     </td>  
	     </tr>
	
	<!-- <input type="text" require="true" dataType="Require"   msg="类型不能为空" name="type" value='<ww:property value="hotelimage.type"/>'" style="width:350px" /> -->			 

			
   
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">备注：</span></td><td><textarea name="des" cols="50" rows="5"><ww:property value="des"/></textarea> </td>  </tr>
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button" value="提交"/> <input type="button" class="button" onclick="window.location.href='hotelstate!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=cancelhotelstate&<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>


