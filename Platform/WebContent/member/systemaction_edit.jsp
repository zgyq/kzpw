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
<title><ww:if test="systemaction.id>0">编辑</ww:if><ww:else>新增</ww:else>系统用户行为</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="systemaction.id>0">编辑</ww:if><ww:else>新增</ww:else>系统用户行为</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="systemaction!<ww:if test="systemaction.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>用户名：</span></td><td><input type="text" require="true" dataType="Require"   msg="用户名不能为空" name="username" value='<ww:property value="systemaction.username"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>操作名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="操作名称不能为空" name="actionname" value='<ww:property value="systemaction.actionname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>操作代码：</span></td><td><input type="text" require="true" dataType="Require"   msg="操作代码不能为空" name="code" value='<ww:property value="systemaction.code"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>操作参数：</span></td><td><input type="text" require="true" dataType="Require"   msg="操作参数不能为空" name="para" value='<ww:property value="systemaction.para"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>用户IP：</span></td><td><input type="text" require="true" dataType="Require"   msg="用户IP不能为空" name="ip" value='<ww:property value="systemaction.ip"/>'" style="width:350px" /></td>  </tr>
	
				 

			
   
	 <tr><td height="28" align="right"><span>行为描述：</span></td><td><textarea name="description" cols="50" rows="5"><ww:property value="systemaction.description"/></textarea> </td>  </tr>
	
			
			
			 
 
	 <tr><td height="28" align="right"><span>级别：</span></td><td><input type="text" require="true" dataType="Require"   msg="级别不能为空" name="lever" value='<ww:property value="systemaction.lever"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>类别：</span></td><td><input type="text" require="true" dataType="Require"   msg="类别不能为空" name="type" value='<ww:property value="systemaction.type"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交" style="margin-right: 55px;"/> <input type="button" class="button_d font-bai" onclick="window.location.href='systemaction.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


