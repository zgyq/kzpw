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

</head>
<body>
<form name="form1" id="form1" method="post"
	action="orderinfo!toGetZrateBYPnr.action">
<div id="member"><input type="hidden" name="s_paystatus"
	id="corderstatus">
	
	<input type="hidden" id='linkcardnumber' name="linkcardnumber" value='<ww:property value="linkcardnumber!=null?linkcardnumber:getcardnumberstr(linkid)"/>'>
	<input type="hidden" name="linkid" value="<ww:property value="linkid"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;PNR创建订单</b></td>
	</tr>
	<tr>
		<td align="right"><img src="images/pnr_no1.gif" style="margin-top: 5px; margin-right: 30px;" /></td>
	</tr>

	<tr height="10px">
		<td></td>
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
								<td style="height: 36px; font-weight: bold" class=maintitle02
									colspan=2 align=middle>PNR记录编号创建订单<span style="">(成人/儿童/婴儿)</span></td>
							</tr>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入PNR编号：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
									id="strPNR" name="strPNR" maxlength=10 type=text
									value="<ww:property value="strPNR"/>" name="txtpnrcode"><span
									style="color: red">*</span> <span style="display: none;"
									id=requiredfieldvalidator1></span> 
									</td>
							</tr>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入PNR文本：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;
								<textarea rows="10" name="strPNRTXT" id="strPNRTXT" cols="50"></textarea>
									
									
									<span
									style="color: red">*</span> <span style="display: none;"
									id=requiredfieldvalidator1></span> 
									</td>
							</tr>
							<tr>
								<td style="background-color: #d7e9fc; width: 30%; height: 38px"
									align="right" class=" tbody_color">请输入PNRPAT文本：</td>
								<td style="text-align: left; width: 70%">&nbsp;&nbsp;
								<textarea rows="10" name="strPATTXT" id="strPATTXT" cols="50"></textarea>
								<span
									style="color: red">*</span> <span style="display: none;"
									id=requiredfieldvalidator1></span> 
									</td>
							</tr>
							
							
							
							<tr>
								<td style="text-align: center; height: 44px" colspan=2>
								<input class="button_d font-bai" id="btnOrder"
									value="导入PNR信息" type="submit" name="btnOrder" id="btnOrder1"
									onclick="setflag(1)"> <br />
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
								<input id="txtticketnumber" style="display: none"
									name="strticketnumber" maxlength=14 type=text
									value="<ww:property value="strticketnumber"/>"> </span></strong></td>
							</tr>
							<tr>
								<td style="text-align: left; line-height: 15px; height: 100px">
								<span>&nbsp;1、支持成人单程、往返程及团队pnr编码导入.</span><br>
								&nbsp;2、请确定该pnr姓名组正确.<br>
								&nbsp;3、请确定航段组正确、舱位状况正确.<br>
								&nbsp;4、请确定每个乘客均有真实的ssr foid 项输入.<br>
								&nbsp;5、请确定票价是否正确.</td>
							</tr>
						</tbody>
					</table>
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


