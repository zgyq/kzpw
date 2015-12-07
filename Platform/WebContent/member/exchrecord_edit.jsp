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
<title><ww:if test="exchrecord.id>0">编辑</ww:if><ww:else>新增</ww:else>积分兑换纪录</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="exchrecord.id>0">编辑</ww:if><ww:else>新增</ww:else>积分兑换纪录</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="exchrecord!<ww:if test="exchrecord.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>奖品ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="奖品ID不能为空" name="prizeid" value='<ww:property value="exchrecord.prizeid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>会员ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="会员ID不能为空" name="customerid" value='<ww:property value="exchrecord.customerid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>联系人：</span></td><td><input type="text" require="true" dataType="Require"   msg="联系人不能为空" name="contactname" value='<ww:property value="exchrecord.contactname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>联系手机：</span></td><td><input type="text" require="true" dataType="Require"   msg="联系手机不能为空" name="contactmobile" value='<ww:property value="exchrecord.contactmobile"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>联系地址：</span></td><td><input type="text" require="true" dataType="Require"   msg="联系地址不能为空" name="contactadd" value='<ww:property value="exchrecord.contactadd"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>备注信息：</span></td><td><input type="text" require="true" dataType="Require"   msg="备注信息不能为空" name="desc" value='<ww:property value="exchrecord.desc"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='exchrecord.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


