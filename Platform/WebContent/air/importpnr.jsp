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
var uname=document.getElementById("strLOGINNAME").value;
	if(strpnr==''){
	alert("PNR为空!");
	return false;
	}
	if(uname==''){
	alert("帐号为空!");
	return false;
	}
	
	document.form1.submit();
}

</script>
</head>
<body>
<form name="form1" id="form1" method="post"
	action="orderinfo!toCreateOrderByPnr.action">
<div id="member"><input type="hidden" name="s_paystatus"
	id="corderstatus">
	
	<input type="hidden" id='linkcardnumber' name="linkcardnumber" value='<ww:property value="linkcardnumber!=null?linkcardnumber:getcardnumberstr(linkid)"/>'>
	<input type="hidden" name="linkid" value="<ww:property value="linkid"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;<ww:if
			test="isinter==1">国际PNR创建订单</ww:if><ww:else>PNR创建订单</ww:else></b></td>
	</tr>
	<tr>
		<td align="right"><img src="images/pnr_no1.gif" style="margin-top: 5px; margin-right: 30px;" /></td>
	</tr>


	
	
	<tr>
		<td>
		<input type="hidden" id="istf" value="<ww:if test='importtype.equals("2") || importtype.equals("4")'>true</ww:if>">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr id=adultstable>
				<td><input type="hidden" name="isinter"
					value="<ww:property value="isinter"/>" /> <input type="hidden"
					name="importtype" value="<ww:property value="importtype"/>" /> 
					<table border=1 cellspacing=0 bordercolorlight=#a0cfee
						bordercolordark=white cellpadding=0 width=450 align=center
						height=110>
						<tbody>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入PNR编号：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
									id="strPNR" name="strPNR" maxlength=10 type=text
									value="<ww:property value="strPNR"/>" ><span
									style="color: red">*</span> <span style="display: none;"
									id=requiredfieldvalidator1></span> 
									</td>
							</tr>
							
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入登录帐号：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
									id="strLOGINNAME" name="strLOGINNAME" maxlength=16 type=text
									value="<ww:property value="strLOGINNAME" />" ><span
									style="color: red">*</span> <span style="display: none;"
									></span> 
									</td>
							</tr>
						</tbody>
					</table>
				</td>
				
				<td valign=top>
					<table border=1 cellspacing=0 bordercolorlight="#a0cfee"
						bordercolordark=white cellpadding=0 width=400 align=center
						height=110>
						<tbody>
							<tr>
								<td
									style="text-align: left; background-color: #d7e9fc; height: 25px"
									class=maintitle02>&nbsp;<strong><span style="">注意事项：
								 </span></strong></td>
							</tr>
							<tr>
								<td style="text-align: left; line-height: 15px; height: 100px">
								<span>&nbsp;1、支持一年以内票号导入.</span><br>
								&nbsp;2、请确定该票号格式是否正确,如：781-2344532168.<br>
								&nbsp;3、请确定导入机票信息是否正确.<br>
								&nbsp;4、请确定机票的状态是否正确.<br>
								&nbsp;5、请确定机票的出票或退废票的时间是否正确.</td>
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
						class="button_d font-bai" id="btnOrder" value="创建订单" type="button"
						name="btnOrder" onclick="checkorderdata();"></td>
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
<ww:if test="#request.message!=null">
$(document).ready(function(){
 alert('<ww:property value="#request.message"/>');
});
</ww:if>
</script>

