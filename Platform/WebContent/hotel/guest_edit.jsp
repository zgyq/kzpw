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
<title><ww:if test="guest.id>0">编辑</ww:if><ww:else>新增</ww:else>客人信息表</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body>
<form action="guest!<ww:if test="guest.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="100%" height="29" background="../images/jianbianbj.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="guest.id>0">编辑</ww:if><ww:else>新增</ww:else>客人信息表</span></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">客人名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="客人名称不能为空" name="name" value='<ww:property value="guest.name"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">房间号：</span></td><td><input type="text" require="true" dataType="Require"   msg="房间号不能为空" name="roomno" value='<ww:property value="guest.roomno"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">订单ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单ID不能为空" name="orderid" value='<ww:property value="guest.orderid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">确认信息：</span></td><td><input type="text" require="true" dataType="Require"   msg="确认信息不能为空" name="memo" value='<ww:property value="guest.memo"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">版本号：</span></td><td><input type="text" require="true" dataType="Require"   msg="版本号不能为空" name="version" value='<ww:property value="guest.version"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button" value="提交"/> <input type="button" class="button" onclick="window.location.href='guest.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
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


