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
<title><ww:if test="importmureport.id>0">编辑</ww:if><ww:else>新增</ww:else>东航销售明细导入</title>

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
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="importmureport.id>0">编辑</ww:if><ww:else>新增</ww:else>东航销售明细导入</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form action="importmureport!<ww:if test="importmureport.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>票号：</span></td><td><input type="text" require="true" dataType="Require"   msg="票号不能为空" name="ticketnumber" value='<ww:property value="importmureport.ticketnumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>批量支付：</span></td><td><input type="text" require="true" dataType="Require"   msg="批量支付不能为空" name="payall" value='<ww:property value="importmureport.payall"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>PNR：</span></td><td><input type="text" require="true" dataType="Require"   msg="PNR不能为空" name="pnr" value='<ww:property value="importmureport.pnr"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>人数：</span></td><td><input type="text" require="true" dataType="Require"   msg="人数不能为空" name="number" value='<ww:property value="importmureport.number"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>成人：</span></td><td><input type="text" require="true" dataType="Require"   msg="成人不能为空" name="chengren" value='<ww:property value="importmureport.chengren"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>儿童：</span></td><td><input type="text" require="true" dataType="Require"   msg="儿童不能为空" name="ertong" value='<ww:property value="importmureport.ertong"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>航程：</span></td><td><input type="text" require="true" dataType="Require"   msg="航程不能为空" name="voyage" value='<ww:property value="importmureport.voyage"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>舱位：</span></td><td><input type="text" require="true" dataType="Require"   msg="舱位不能为空" name="cabin" value='<ww:property value="importmureport.cabin"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>票面金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="票面金额不能为空" name="ticketprice" value='<ww:property value="importmureport.ticketprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>税：</span></td><td><input type="text" require="true" dataType="Require"   msg="税不能为空" name="fee" value='<ww:property value="importmureport.fee"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>实际支付金额：</span></td><td><input type="text" require="true" dataType="Require"   msg="实际支付金额不能为空" name="payprice" value='<ww:property value="importmureport.payprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>代理费：</span></td><td><input type="text" require="true" dataType="Require"   msg="代理费不能为空" name="daiprice" value='<ww:property value="importmureport.daiprice"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>支付银行：</span></td><td><input type="text" require="true" dataType="Require"   msg="支付银行不能为空" name="paybank" value='<ww:property value="importmureport.paybank"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>银行票号：</span></td><td><input type="text" require="true" dataType="Require"   msg="银行票号不能为空" name="banknumber" value='<ww:property value="importmureport.banknumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>出票时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="出票时间不能为空" name="time" value='<ww:property value="importmureport.time"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>入库人ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="入库人ID不能为空" name="storageid" value='<ww:property value="importmureport.storageid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>出票人ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="出票人ID不能为空" name="chupiaoid" value='<ww:property value="importmureport.chupiaoid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr><td height="28" align="right"><span>比对状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="比对状态不能为空" name="compstate" value='<ww:property value="importmureport.compstate"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='importmureport.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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


