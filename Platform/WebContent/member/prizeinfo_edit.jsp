<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
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
<title><ww:if test="prizeinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>积分礼品信息</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="prizeinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>积分礼品信息</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="prizeinfo!<ww:if test="prizeinfo.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>所属类别：</span></td><td><input type="text" require="true" dataType="Require"   msg="所属类别不能为空" name="typeid" value='<ww:property value="prizeinfo.typeid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>礼品名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="礼品名称不能为空" name="name" value='<ww:property value="prizeinfo.name"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>图片路径：</span></td><td><input type="text" require="true" dataType="Require"   msg="图片路径不能为空" name="imgurl" value='<ww:property value="prizeinfo.imgurl"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>描述：</span></td><td><input type="text" require="true" dataType="Require"   msg="描述不能为空" name="desc" value='<ww:property value="prizeinfo.desc"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>所需积分：</span></td><td><input type="text" require="true" dataType="Require"   msg="所需积分不能为空" name="scores" value='<ww:property value="prizeinfo.scores"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>排序：</span></td><td><input type="text" require="true" dataType="Require"   msg="排序不能为空" name="index" value='<ww:property value="prizeinfo.index"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>是否允许兑换：</span></td><td><input type="text" require="true" dataType="Require"   msg="是否允许兑换不能为空" name="isenable" value='<ww:property value="prizeinfo.isenable"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='prizeinfo.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


