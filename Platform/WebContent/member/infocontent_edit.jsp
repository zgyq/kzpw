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
<title><ww:if test="infocontent.id>0">编辑</ww:if><ww:else>新增</ww:else>信息</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="infocontent.id>0">编辑</ww:if><ww:else>新增</ww:else>信息</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="infocontent!<ww:if test="infocontent.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>标题：</span></td><td><input type="text" require="true" dataType="Require"   msg="标题不能为空" name="title" value='<ww:property value="infocontent.title"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>内容：</span></td><td>
	 <textarea rows="8" require="true" dataType="Require"   msg="内容不能为空" name="content"  style="width:350px" ><ww:property value="infocontent.content"/></textarea></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>信息类型：</span></td><td>
	 <!--<input type="text" require="true" dataType="Require"   msg="信息类型不能为空" name="typeid" value='<ww:property value="infocontent.typeid"/>'" style="width:350px" />
	 -->
	 <select name="infocontent.typeid">
	 <option value="1" <ww:if test="infocontent.typeid==1">selected</ww:if> >酒店优惠信息</option>
	 <option value="2" <ww:if test="infocontent.typeid==2">selected</ww:if> >机票优惠信息</option>
	 <option value="3" <ww:if test="infocontent.typeid==3">selected</ww:if> >酒店攻略</option>
	 <option value="4" <ww:if test="infocontent.typeid==4">selected</ww:if> >机票攻略</option>
	 <option value="5" <ww:if test="infocontent.typeid==5">selected</ww:if> >酒店优惠服务</option>
	 <option value="6" <ww:if test="infocontent.typeid==6">selected</ww:if> >机票优惠服务</option>
	 <option value="7" <ww:if test="infocontent.typeid==7">selected</ww:if> >国际机票优惠服务</option>
	 <option value="8" <ww:if test="infocontent.typeid==8">selected</ww:if> >国际机票攻略</option>
	  <option value="9" <ww:if test="infocontent.typeid==9">selected</ww:if> >导航</option>
	 
	 </select>
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


