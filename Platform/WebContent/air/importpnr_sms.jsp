<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!doctype html public "-//w3c//dtd html 4.01 transitional//en"
"http://www.w3.org/tr/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@page import="com.yf.system.base.customeruser.Customeruser"%>
<%@page import="com.yf.system.atom.server.Server"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>pnr创建订单</title>
<style type="text/css">
.hide {
	display: none;
}
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript"> 
function checkorderdata() {
//alert("??");
var strpnr=document.getElementById("strPNR").value;

	if(strpnr==''){
	alert("PNR或者票号为空!");
	return false;
	}
	
	
	document.form1.submit();
}
function sedsms() {
var beizhu=document.getElementById("beizhu").value;
	if(beizhu==''){
	alert("短信内容不能为空!");
	return ;
	}
	
var strTEL=document.getElementById("strTEL").value;
	if(strTEL==''){
	alert("电话号码不能为空!");
	return ;
	}
	
	
	
document.form1.submit();

}
</script>
</head>
<body>
<form name="form1" id="form1" method="post"
	action="orderinfo!imppnrtosms.action">
<div id="member">
	
	
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;<ww:if
			test="isinter==1">国际PNR创建订单</ww:if><ww:else>PNR创建订单</ww:else></b></td>
	</tr>
	
	
	<tr>
		<td>
		
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr id=adultstable>
				<td>
					<table border=1 cellspacing=0 bordercolorlight=#a0cfee
						bordercolordark=white cellpadding=0 width=450 align=center
						height=110>
						<tbody>
						<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">类型:</td>
								<td style="text-align: left; width: 70%">
								PNR导入<input type="radio" id='pnr' name="importtype" value="1" <ww:if test="importtype.equals(\"1\")">checked</ww:if> />  &nbsp;&nbsp;&nbsp;&nbsp;
								票号导入<input type="radio" id='ticketnum' name="importtype" value="2"  <ww:if test="importtype==null||importtype.equals(\"2\")">checked</ww:if> />  
									</td>
							</tr>
							
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入PNR或者票号：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
									id="strPNR" name="strPNR" maxlength=20 type=text
									value="<ww:property value="strPNR"/>" ><span
									style="color: red">*</span> <span style="display: none;"
									id=requiredfieldvalidator1></span> 
									</td>
							</tr>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">短信内容：</td>
								<td style="text-align: left; width: 70%">
								<textarea rows="8" cols="40" id="beizhu" name="beizhu"><ww:property value="beizhu"/></textarea>
								
									</td>
							</tr>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入电话号码：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
									id="strTEL" name="strTEL" maxlength=20 type=text
									value="<ww:property value="strTEL"/>" ><span
									style="color: red">*</span>  
									</td>
							</tr>
							
						</tbody>
					</table>
				</td>
				
				
			</tr>

		</table>
		</td>
	</tr>

		<tr>
			<td>
			<table border=0 cellspacing=0 cellpadding=0 width="90%" align=center>
				<tr>
					<td align="center" height="40"><input
						class="button_d font-bai" id="btnOrder" value="创建短信" type="button"
						name="btnOrder" onclick="checkorderdata();">
						
						<input
						class="button_d font-bai" id="btnOrder" value="发送短信" type="button"
						name="btnOrder" onclick="sedsms();">
						
						</td>
						
				</tr>
			</table>

			</td>
		</tr>

</table>
</div>
</form>
</body>
</html>
<script>
<ww:if test="isinter==1">
 alert("发送成功!!!");
</ww:if>
<ww:if test="isinter==-1">
 alert("发送失败!!!");
</ww:if>
</script>

