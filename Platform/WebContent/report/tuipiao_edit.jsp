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
<title><ww:if test="tuipiao.id>0">编辑</ww:if><ww:else>新增</ww:else>退票报表</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="tuipiao.id>0">编辑</ww:if><ww:else>新增</ww:else>退票报表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="tuipiao!<ww:if test="tuipiao.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>出票时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="出票时间不能为空" name="rttime" value='<ww:property value="tuipiao.rttime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>订单号：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单号不能为空" name="ordercode" value='<ww:property value="tuipiao.ordercode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>PNR：</span></td><td><input type="text" require="true" dataType="Require"   msg="PNR不能为空" name="pnr" value='<ww:property value="tuipiao.pnr"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>订单人数：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单人数不能为空" name="number" value='<ww:property value="tuipiao.number"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退票人数：</span></td><td><input type="text" require="true" dataType="Require"   msg="退票人数不能为空" name="rnumber" value='<ww:property value="tuipiao.rnumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退费票申请时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="退费票申请时间不能为空" name="applytime" value='<ww:property value="tuipiao.applytime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="tuipiao.state"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>OFFICE：</span></td><td><input type="text" require="true" dataType="Require"   msg="OFFICE不能为空" name="office" value='<ww:property value="tuipiao.office"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退款金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="退款金额不能为空" name="tuiprice" value='<ww:property value="tuipiao.tuiprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退款时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="退款时间不能为空" name="tuitime" value='<ww:property value="tuipiao.tuitime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票号：</span></td><td><input type="text" require="true" dataType="Require"   msg="票号不能为空" name="ticketno" value='<ww:property value="tuipiao.ticketno"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>乘机人：</span></td><td><input type="text" require="true" dataType="Require"   msg="乘机人不能为空" name="passenger" value='<ww:property value="tuipiao.passenger"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>乘机人类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="乘机人类型不能为空" name="ptype" value='<ww:property value="tuipiao.ptype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>出发城市：</span></td><td><input type="text" require="true" dataType="Require"   msg="出发城市不能为空" name="startcity" value='<ww:property value="tuipiao.startcity"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>到达城市：</span></td><td><input type="text" require="true" dataType="Require"   msg="到达城市不能为空" name="endcity" value='<ww:property value="tuipiao.endcity"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航程：</span></td><td><input type="text" require="true" dataType="Require"   msg="航程不能为空" name="sail" value='<ww:property value="tuipiao.sail"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航空公司：</span></td><td><input type="text" require="true" dataType="Require"   msg="航空公司不能为空" name="aircompany" value='<ww:property value="tuipiao.aircompany"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航班：</span></td><td><input type="text" require="true" dataType="Require"   msg="航班不能为空" name="flightnum" value='<ww:property value="tuipiao.flightnum"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航班日期：</span></td><td><input type="text" require="true" dataType="Require"   msg="航班日期不能为空" name="flighttime" value='<ww:property value="tuipiao.flighttime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>舱位：</span></td><td><input type="text" require="true" dataType="Require"   msg="舱位不能为空" name="cabin" value='<ww:property value="tuipiao.cabin"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票面价：</span></td><td><input type="text" require="true" dataType="Require"   msg="票面价不能为空" name="price" value='<ww:property value="tuipiao.price"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>机建：</span></td><td><input type="text" require="true" dataType="Require"   msg="机建不能为空" name="jijian" value='<ww:property value="tuipiao.jijian"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>燃油：</span></td><td><input type="text" require="true" dataType="Require"   msg="燃油不能为空" name="ranyou" value='<ww:property value="tuipiao.ranyou"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>单张计算总计：</span></td><td><input type="text" require="true" dataType="Require"   msg="单张计算总计不能为空" name="talfee" value='<ww:property value="tuipiao.talfee"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>行程：</span></td><td><input type="text" require="true" dataType="Require"   msg="行程不能为空" name="journeytype" value='<ww:property value="tuipiao.journeytype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>服务费：</span></td><td><input type="text" require="true" dataType="Require"   msg="服务费不能为空" name="fuwufei" value='<ww:property value="tuipiao.fuwufei"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='tuipiao.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


