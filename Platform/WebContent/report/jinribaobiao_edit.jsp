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
<title><ww:if test="jinribaobiao.id>0">编辑</ww:if><ww:else>新增</ww:else>今日报表</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="jinribaobiao.id>0">编辑</ww:if><ww:else>新增</ww:else>今日报表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="jinribaobiao!<ww:if test="jinribaobiao.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>订单时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单时间不能为空" name="ordertime" value='<ww:property value="jinribaobiao.ordertime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>PNR：</span></td><td><input type="text" require="true" dataType="Require"   msg="PNR不能为空" name="pnr" value='<ww:property value="jinribaobiao.pnr"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票号：</span></td><td><input type="text" require="true" dataType="Require"   msg="票号不能为空" name="ticketcode" value='<ww:property value="jinribaobiao.ticketcode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>订单编号：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单编号不能为空" name="ordercode" value='<ww:property value="jinribaobiao.ordercode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>客户姓名：</span></td><td><input type="text" require="true" dataType="Require"   msg="客户姓名不能为空" name="username" value='<ww:property value="jinribaobiao.username"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>始发地：</span></td><td><input type="text" require="true" dataType="Require"   msg="始发地不能为空" name="startcity" value='<ww:property value="jinribaobiao.startcity"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>目的地：</span></td><td><input type="text" require="true" dataType="Require"   msg="目的地不能为空" name="endcity" value='<ww:property value="jinribaobiao.endcity"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>始发地三字码：</span></td><td><input type="text" require="true" dataType="Require"   msg="始发地三字码不能为空" name="startcityszm" value='<ww:property value="jinribaobiao.startcityszm"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>目的地三字码：</span></td><td><input type="text" require="true" dataType="Require"   msg="目的地三字码不能为空" name="endcityszm" value='<ww:property value="jinribaobiao.endcityszm"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航班号：</span></td><td><input type="text" require="true" dataType="Require"   msg="航班号不能为空" name="flightnumber" value='<ww:property value="jinribaobiao.flightnumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>仓位码：</span></td><td><input type="text" require="true" dataType="Require"   msg="仓位码不能为空" name="cabincode" value='<ww:property value="jinribaobiao.cabincode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>起飞时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="起飞时间不能为空" name="flightdate" value='<ww:property value="jinribaobiao.flightdate"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票面价：</span></td><td><input type="text" require="true" dataType="Require"   msg="票面价不能为空" name="price" value='<ww:property value="jinribaobiao.price"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>同行返点：</span></td><td><input type="text" require="true" dataType="Require"   msg="同行返点不能为空" name="fandian" value='<ww:property value="jinribaobiao.fandian"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>机建燃油：</span></td><td><input type="text" require="true" dataType="Require"   msg="机建燃油不能为空" name="jijianranyou" value='<ww:property value="jinribaobiao.jijianranyou"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>人数：</span></td><td><input type="text" require="true" dataType="Require"   msg="人数不能为空" name="number" value='<ww:property value="jinribaobiao.number"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>收款金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="收款金额不能为空" name="submoney" value='<ww:property value="jinribaobiao.submoney"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>手续费：</span></td><td><input type="text" require="true" dataType="Require"   msg="手续费不能为空" name="shouxufei" value='<ww:property value="jinribaobiao.shouxufei"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退款金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="退款金额不能为空" name="tuikuan" value='<ww:property value="jinribaobiao.tuikuan"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>应收：</span></td><td><input type="text" require="true" dataType="Require"   msg="应收不能为空" name="yingshou" value='<ww:property value="jinribaobiao.yingshou"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>利润：</span></td><td><input type="text" require="true" dataType="Require"   msg="利润不能为空" name="lirun" value='<ww:property value="jinribaobiao.lirun"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>支付方式：</span></td><td><input type="text" require="true" dataType="Require"   msg="支付方式不能为空" name="paymethod" value='<ww:property value="jinribaobiao.paymethod"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>支付时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="支付时间不能为空" name="paytime" value='<ww:property value="jinribaobiao.paytime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>废票时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="废票时间不能为空" name="feitime" value='<ww:property value="jinribaobiao.feitime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>出票时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="出票时间不能为空" name="rttime" value='<ww:property value="jinribaobiao.rttime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="jinribaobiao.state"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='jinribaobiao.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


