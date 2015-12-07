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
<title><ww:if test="paymentrecorder.id>0">编辑</ww:if><ww:else>新增</ww:else>支付记录</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="paymentrecorder.id>0">编辑</ww:if><ww:else>新增</ww:else>支付记录</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="paymentrecorder!<ww:if test="paymentrecorder.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>订单号：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单号不能为空" name="ordercode" value='<ww:property value="paymentrecorder.ordercode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="paymentrecorder.state"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>支付方式：</span></td><td><input type="text" require="true" dataType="Require"   msg="支付方式不能为空" name="paytype" value='<ww:property value="paymentrecorder.paytype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="金额不能为空" name="amount" value='<ww:property value="paymentrecorder.amount"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>服务名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="服务名称不能为空" name="payname" value='<ww:property value="paymentrecorder.payname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>返回码：</span></td><td><input type="text" require="true" dataType="Require"   msg="返回码不能为空" name="retcode" value='<ww:property value="paymentrecorder.retcode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>返回地址：</span></td><td><input type="text" require="true" dataType="Require"   msg="返回地址不能为空" name="returl" value='<ww:property value="paymentrecorder.returl"/>'" style="width:350px" /></td>  </tr>
	
				 

			
   
	 <tr><td height="28" align="right"><span>备注：</span></td><td><textarea name="description" cols="50" rows="5"><ww:property value="paymentrecorder.description"/></textarea> </td>  </tr>
	
			
			
			 
 
	 <tr><td height="28" align="right"><span>交易代码：</span></td><td><input type="text" require="true" dataType="Require"   msg="交易代码不能为空" name="code" value='<ww:property value="paymentrecorder.code"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>商品名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="商品名称不能为空" name="productname" value='<ww:property value="paymentrecorder.productname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>商???描述：</span></td><td><input type="text" require="true" dataType="Require"   msg="商???描述不能为空" name="productesc" value='<ww:property value="paymentrecorder.productesc"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>商品信息地址：</span></td><td><input type="text" require="true" dataType="Require"   msg="商品信息地址不能为空" name="producturl" value='<ww:property value="paymentrecorder.producturl"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='paymentrecorder.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


