<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
			String abspath = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录--${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全-V2.0</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine.js"
	type="text/javascript"></script>
<style>
td {
	padding-left: 3px;
}

.red {
	color: red
}

body {
	font-size: 12px;
	margin: 0 auto;
	color: #666;
	height: 100%;
	width: 100%;
	background-color: #226DC8
}

img input {
	vertical-align: middle
}
</style>
</head>
<script language="javascript">
$(document).ready(function() {
			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});

    var openerIsIndex=false;
	try{
		openerIsIndex=opener.isIndex();
	}catch(e){}
	if(opener!=null && !openerIsIndex){
		opener.top.location= "<%=abspath+"index.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"index.jsp"%>";
	}
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validator.js"></script>

<body style="background: #fff">



<form action="<%=request.getContextPath()%>/customeragent!addrequestCustomeragent.action"
	id="form1" name="form1" method="post">
<div
	style="height: 83px; background: url(images/bj_login.gif); width: 100%">
<div style="width: 950px; margin: 0 auto;"><img
	src="images/logo_login.gif" width="335" height="83" /></div>
</div>
<div style="width: 950px; margin: 0 auto; margin-top: 25px;">
<div>
<table width="800" border="1" align="center" cellpadding="0"
	bordercolor="#b3b3b3" cellspacing="0"
	style="font-size: 12px; border-collapse: collapse; margin-top: 20px;">
	<tr>
		<td colspan="3" style="border: none; padding: 0"><img
			src="images/gonpiao.gif"></td>
	</tr>
	<tr>
		<td colspan="3"
			style="background: url('images/di3.jpg'); height: 30px; padding-left: 20px; font-weight: bold">帐号信息</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="190" height="28" align="right" style="padding: 0">
		<input type="hidden" name="agentcheckstatus" value="-1" />
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
		<label for="arrcity"> 加盟商类型：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;">
		<input type="hidden" name="requestcustomeragent" value=""/>
		<select
			name="agenttype" style="width: 180px">
			<option value="2">供应商</option>
			<option value="3">分销商</option>
		</select>&nbsp;<span style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">请选择您所要申请的加盟商类型！</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="190" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
		<label for="arrcity"> 公司名称：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;"><input
			type="text" id="companyname" name="agentcompanyname" desc="公司名称"
			class="validate[required]"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">
		必须为汉字、英文字母、数字，不能包含非法字符！</td>
	</tr>
	<!-- 
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" > 用 户 名：</label></div></td>
								<td  align="left" style="border-right:none;">
								<input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px;width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">6-16位英文字母与阿拉伯数字，不区分大小写</td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" > 密    码：</label></div></td>
								<td  align="left" style="border-right:none;">
                                   <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;"  />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;"> 密码长度6～20位，由英文字母a～z ，数字0～9，特殊字符组成。 </td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" > 确认密码：</label></div></td>
								<td  align="left" style="border-right:none;">
								 <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">请您再输入一遍您上面输入的密码 </td>
							</tr>  -->
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 公司位置：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" desc="公司位置" id="agentaddress" name="agentaddress"class="validate[required]"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">选择公司所在位置的城市！</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 公司电话：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agenttel"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">格式：区号加"-"加电话号码，如
		021-62774989</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">公司网址：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="website"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">&nbsp;</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 邮 编：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agentpostcode"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span
			style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">填写邮政编码</td>
	</tr>
	<!--  <tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >OFFICE号：</label></div></td>
								<td  align="left" style="border-right:none;">
								 <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;"> &nbsp; </td>
							</tr>-->
	<tr>
		<td colspan="3"
			style="background: url('images/di3.jpg'); height: 30px; padding-left: 20px; font-weight: bold">联系人信息</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">业务联系人：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;"><input name="agentcontactname"
			type="text" class="validate[required]" id="agentcontactname" desc="业务联系人"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">填写负责人真实姓名</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">工作电话：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" desc="工作电话" id="agentphone" name="agentphone"  class="validate[required]"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">填写用于联系的电话号码</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">个人移动电话：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agentmobile"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- ><span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">填写用于联系的电话号码</td>
	</tr>
	<!-- <tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">地 址：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">填写用于联系的地址</td>
	</tr>-->
	
	
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 传真：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agenrfax"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">格式：区号加"-"加电话号码，如
		021-62988962</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 电子邮件：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agentemail"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">填写您常用的电子邮箱地址！</td>
	</tr>
	<!-- <tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" > 上班时间：</label></div></td>
								<td  align="left" style="border-right:none;">
								 <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;"> 选择下班时间！  </td>
							</tr>-->
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">其他MSN或QQ：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text" name="agentother"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;
			<!-- <span style="color: red">*</span>--></td>
		<td style="color: #999999; border-left: none;">&nbsp;</td>
	</tr>
	<!-- 
	<tr>
		<td colspan="3"
			style="background: url('images/di3.jpg'); height: 30px; padding-left: 20px; font-weight: bold">账号信息</td>
	</tr>

							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >出票人电话：</label></div></td>
								<td width="180"   align="left" style="border-right:none;">
								<input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp;</td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >出票人QQ：</label></div></td>
								<td  align="left" style="border-right:none;">
								<input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px;width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp;</td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >出票人MSN：</label></div></td>
								<td  align="left" style="border-right:none;">
                                   <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;"  />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp;</td>
							</tr>
							<tr>
                              <td colspan="3" style="background: url('images/di3.jpg');height:30px;padding-left:20px; font-weight:bold">退票人信息</td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >退票人电话：</label></div></td>
								<td width="180"   align="left" style="border-right:none;">
								<input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp; </td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >退票人QQ：</label></div></td>
								<td  align="left" style="border-right:none;">
								<input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px;width:180px;" />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp; </td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >退票人MSN：</label></div></td>
								<td  align="left" style="border-right:none;">
                                   <input type="text"  style="border: 1px solid #999999; height: 20px; line-height: 20px; width:180px;"  />&nbsp;<span	style="color: red">*</span>
								</td>
								<td style="color:#999999; border-left:none;">&nbsp; </td>
							</tr>
							<tr>
                              <td colspan="3" style="background: url('images/di3.jpg');height:30px;padding-left:20px; font-weight:bold">账号信息</td>
							</tr>-->
	<!-- <tr class="font-blue-xi">
		<td width="190" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
		<label for="arrcity"> 分润类型：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;">
		<select name="runtype" id="se" onchange="check();">
			<option value="3">不分润</option>
			<option value="1">按千分比</option>
			<option value="2">按票数</option>

		</select>&nbsp;<span style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">请选择您所要申请的加盟商类型！</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="190" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
		<label for="arrcity"> 分润值：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;">
		<input name="runvalue" style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;"/>
		</td>
		<td style="color: #999999; border-left: none;">请选择您所要申请的加盟商类型！</td>
	</tr>-->
	<!-- <tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">支付宝账号：</label></div>
		</td>
		<td width="180" align="left" style="border-right: none;"><input
			type="text"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">&nbsp;</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">财付通账号：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">&nbsp;</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">快钱账号：</label></div>
		</td>
		<td align="left" style="border-right: none;"><input type="text"
			style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 180px;" />&nbsp;<span
			style="color: red">*</span></td>
		<td style="color: #999999; border-left: none;">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3"
			style="background: url('images/di3.jpg'); height: 30px; padding-left: 20px; font-weight: bold">&nbsp;</td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="118" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 128px; line-height: 50px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">公司介绍：</label></div>
		</td>
		<td align="left" style="border-right: none;" colspan="2"><input
			type="text"
			style="border: 1px solid #999999; height: 100px; line-height: 20px; width: 500px;" />
		</td>
	</tr>
	<!-- 	<tr class="font-blue-xi">
								<td width="120"  align="right" style="padding: 0" ><div style="background: #f0f0f0; height:200px;line-height:50px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" >了解本平台的途径：</label></div></td>
								<td  align="left" style=" color:#999999; padding-left:30px;" colspan="2"> 
                                     <input type="checkbox" align="absmiddle" />&nbsp;&nbsp;通过搜索引擎搜索 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;通过朋友介绍 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;业务交流中得知 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;在第三方媒体上得知 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;宣传资料 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;偶然间发现的 <br/>
								     <input type="checkbox" />&nbsp;&nbsp;其它 <br/>
                                       请您输入正确的途径信息后再提交,谢谢合作！ 

								</td>
								
							</tr>-->
	<tr class="font-blue-xi">
		<td width="120" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 74px; line-height: 50px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity">注册条款提醒：</label></div>
		</td>
		<td align="left" style="color: #999999; padding-left: 30px;"
			colspan="2">1.请妥善保管好账号，如发生纠纷后果自负。 2.特殊政策以备注为准，请仔细阅读提示。 <br />
		3.退废票以航空公司为准。 4.以上信息必须真实，以避免给您造成不必要的麻烦。 <br />
		<input type="radio" name="t" checked="checked" onclick="agreen()" /> 同意 <input type="radio" name="t" onclick="subdis()" /> 不同意<font
			class="red"> *</font></td>

	</tr>
	<tr class="font-blue-xi">
		<td colspan="3" align="center" height="50"><input type="submit"
			class="button_d" id="subbut"
			style="color: #fff; font-weight: bold; margin-right: 40px;"
			value="提交"><input type="button"  onclick="history.go(-1)" class="button_d"
			style="color: #fff; font-weight: bold" value="返回"></td>
	</tr>




</table>
<div style="height: 22px;">&nbsp;</div>
</div>
<div
	style="background: url('images/bottom1.gif'); width: 950px; height: 47px; line-height: 47px; text-align: center;">
&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: #999999;">版权所有：允风文化航空票务有限公司</font>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<font
	style="color: #999999;">技术支持：允风文化科技有限公司</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>
</form>
</body>
</html>
<script type="text/javascript">
function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}

function subdis(){
$("#subbut").attr("disabled","disabled");
}

function agreen(){
$("#subbut").attr("disabled",false);
}
</script>
