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
<title><ww:if test="segmentinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>行程表</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="segmentinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>行程表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="segmentinfo!<ww:if test="segmentinfo.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>订单ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="订单ID不能为空" name="orderid" value='<ww:property value="segmentinfo.orderid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航班号：</span></td><td><input type="text" require="true" dataType="Require"   msg="航班号不能为空" name="flightnumber" value='<ww:property value="segmentinfo.flightnumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航空公司二字代码：</span></td><td><input type="text" require="true" dataType="Require"   msg="航空公司二字代码不能为空" name="aircomapnycode" value='<ww:property value="segmentinfo.aircomapnycode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>机建费：</span></td><td><input type="text" require="true" dataType="Require"   msg="机建费不能为空" name="airportfee" value='<ww:property value="segmentinfo.airportfee"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>燃油费：</span></td><td><input type="text" require="true" dataType="Require"   msg="燃油费不能为空" name="fuelfee" value='<ww:property value="segmentinfo.fuelfee"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>起飞时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="起飞时间不能为空" name="departtime" value='<ww:property value="segmentinfo.departtime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>到达时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="到达时间不能为空" name="arrivaltime" value='<ww:property value="segmentinfo.arrivaltime"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>舱位码：</span></td><td><input type="text" require="true" dataType="Require"   msg="舱位码不能为空" name="cabincode" value='<ww:property value="segmentinfo.cabincode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>价格：</span></td><td><input type="text" require="true" dataType="Require"   msg="价格不能为空" name="price" value='<ww:property value="segmentinfo.price"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>折扣（四舍五入）：</span></td><td><input type="text" require="true" dataType="Require"   msg="折扣（四舍五入）不能为空" name="discount" value='<ww:property value="segmentinfo.discount"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>全价价格：</span></td><td><input type="text" require="true" dataType="Require"   msg="全价价格不能为空" name="yprice" value='<ww:property value="segmentinfo.yprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>行程类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="行程类型不能为空" name="traveltype" value='<ww:property value="segmentinfo.traveltype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>是否特价(0=非特价,1=特价)：</span></td><td><input type="text" require="true" dataType="Require"   msg="是否特价(0=非特价,1=特价)不能为空" name="isspecial" value='<ww:property value="segmentinfo.isspecial"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>起飞机场：</span></td><td><input type="text" require="true" dataType="Require"   msg="起飞机场不能为空" name="startairport" value='<ww:property value="segmentinfo.startairport"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>到达机场：</span></td><td><input type="text" require="true" dataType="Require"   msg="到达机场不能为空" name="endairport" value='<ww:property value="segmentinfo.endairport"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>退改签规则：</span></td><td><input type="text" require="true" dataType="Require"   msg="退改签规则不能为空" name="rules" value='<ww:property value="segmentinfo.rules"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='segmentinfo.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


