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
<title><ww:if test="passenger.id>0">编辑</ww:if><ww:else>新增</ww:else>乘机人表</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="passenger.id>0">编辑</ww:if><ww:else>新增</ww:else>乘机人表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="passenger!<ww:if test="passenger.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>订单ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单ID不能为空" name="orderid" value='<ww:property value="passenger.orderid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>乘机人姓名：</span></td><td><input type="text" require="true" dataType="Require"   msg="乘机人姓名不能为空" name="name" value='<ww:property value="passenger.name"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>乘机人类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="乘机人类型不能为空" name="ptype" value='<ww:property value="passenger.ptype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>证件类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="证件类型不能为空" name="idtype" value='<ww:property value="passenger.idtype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>证件号：</span></td><td><input type="text" require="true" dataType="Require"   msg="证件号不能为空" name="idnumber" value='<ww:property value="passenger.idnumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票价：</span></td><td><input type="text" require="true" dataType="Require"   msg="票价不能为空" name="price" value='<ww:property value="passenger.price"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>燃油费：</span></td><td><input type="text" require="true" dataType="Require"   msg="燃油费不能为空" name="fuelprice" value='<ww:property value="passenger.fuelprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>机建费：</span></td><td><input type="text" require="true" dataType="Require"   msg="机建费不能为空" name="airportfee" value='<ww:property value="passenger.airportfee"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>折扣：</span></td><td><input type="text" require="true" dataType="Require"   msg="折扣不能为空" name="discount" value='<ww:property value="passenger.discount"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票号：</span></td><td><input type="text" require="true" dataType="Require"   msg="票号不能为空" name="ticketnum" value='<ww:property value="passenger.ticketnum"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>行程单号：</span></td><td><input type="text" require="true" dataType="Require"   msg="行程单号不能为空" name="fet" value='<ww:property value="passenger.fet"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>EI项：</span></td><td><input type="text" require="true" dataType="Require"   msg="EI项不能为空" name="ei" value='<ww:property value="passenger.ei"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="票状态不能为空" name="state" value='<ww:property value="passenger.state"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='passenger.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


