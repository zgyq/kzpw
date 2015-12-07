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
<title><ww:if test="triporder.id>0">编辑</ww:if><ww:else>新增</ww:else>线路订单</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link types="text/css" rel="stylesheet" href="style/base100108.css">
</head>

<body>
<form
	action="triporder!<ww:if test="triporder.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;旅游订单详细信息</b></td>
	</tr>
</table>
<div class="base_b base_bgcolor02">

<div class="flt_silhouette" cdm="blk_ticketinfo"><span
	class="flt_shadow_t"></span><span class="flt_shadow_m">
<div class="flt_shadow_content">
<div class="flt_info" cdm="blk_flightinfo">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">订单基本信息<span class="base_annotate"></span></h3>
	</li>


	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tr height="5px">
					<td></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="triporder.code" /></td>
					<td class="table_color_r colortrin" width="10%">创建时间：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(triporder.createtime)" /></td>
					<td class="table_color_r colortrin" width="10%">所属加盟商：</td>
					<td class="table_color_l" width="15%">西安一起飞</td>

					<td class="table_color_r colortrin" width="10%">下单人：</td>
					<td class="table_color_l" width="15%">张万鹏</td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单状态：</td>
					<td class="table_color_l" width="15%"
						style="color: red; font-weight: bold"><ww:if
						test="triporder.state==1">待确认</ww:if> <ww:if
						test="triporder.state==2">完成</ww:if> <ww:if
						test="triporder.state==3">取消</ww:if></td>
					<td class="table_color_r colortrin" width="10%">联系人姓名：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="triporder.linkname" /></td>
					<td class="table_color_r colortrin" width="10%">联系人电话：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="triporder.linkmobile" /></td>

					<td class="table_color_r colortrin" width="10%">订单类型：</td>
					<td class="table_color_l" width="15%"
						style="color: red; font-weight: bold"><ww:if
						test="triporder.language==1 || triporder.language==0">后台订单</ww:if><ww:if
						test="triporder.language==2">网站订单</ww:if></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">会员姓名：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="getemployeenamebyid(triporder.memberid)" /></td>
					<td class="table_color_r colortrin" width="10%">订单备注：</td>
					<td class="table_color_l" width="15%" colspan="5"><ww:property
						value="triporder.specreo" /></td>

				</tr>

				<tr height='1px'>
					<td colspan='9'><br />
					</td>
				</tr>

			</table>
			</td>
		</tr>
	</table>
</ul>
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">线路信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>线路名称</td>
						<td>出发城市</td>
						<td>到达城市</td>
						<td>出发日期</td>
						<td>线路类型</td>
						<td>人数</td>
						<td>总价格</td>

					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:property
							value="getTripnamebyid(triporder.triplineid)" /></td>
						<td><ww:property
							value="getTripFcitybyid(triporder.triplineid)" /></td>
						<td><ww:property
							value="getTripEcitybyid(triporder.triplineid)" /></td>
						<td><ww:property value="formatTimestamp(triporder.statetime)" /></td>
						<td><ww:property
							value="getTripTypeName_B2B(triporder.triplineid)" /></td>
						<td><ww:property value="triporder.pnum" /></td>
						<td><ww:property value="triporder.sump" /></td>
					</tr>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>

<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">联系人信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class="postbg1">
						<td align="right" style="height: 19px;"
							class="table_color_r colortrin">联 系 人：</td>
						<td style="height: 19px" align="left"><span
							id="lblContactName"> <input name="triporder.linkname"
							type="text" value="<ww:property value="triporder.linkname"/>"
							desc="联系人" class="validate[required] " id="username" /> </span></td>
						<td align="right" class="table_color_r colortrin">E-mail：</td>
						<td align="left"><span id="lblContactEmail"> <input
							name="triporder.linkmail" type="text"
							value="<ww:property value="triporder.linkmail"/>" desc="电子邮件"
							class="validate[required,custom[email]] " id="email" /> </span></td>

					</tr>
					<tr class="postbg1">
						<td align="right" class="table_color_r colortrin">手机号码：</td>
						<td align="left"><span id="lblContactMobile"> <input
							name="triporder.linkmobile" type="text"
							value="<ww:property value="triporder.linkmobile"/>" desc="手机号码"
							class="validate[required,custom[mobile]] " id="shouji" /> </span></td>
						<td align="right" class="table_color_r colortrin">联系电话：</td>
						<td align="left"><span id="lblContactPhone"> <input
							name="triporder.linktell" type="text"
							value="<ww:property value="triporder.linktell"/>" desc="电话"
							class="validate[required,custom[telephone]] " id="dianhua" /> </span></td>
					</tr>

					<tr class="postbg1">
						<td align="right" style="height: 27px"
							class="table_color_r colortrin">客人要求：</td>
						<td style="height: 27px" colspan="3" align="left"><span
							id="lblAdditionals"> <input name="triporder.specreq"
							type="text" style="width: 400px; height: 70px"
							value="<ww:property value="triporder.specreq"/>" desc=""
							class="validate[required] " id="qiu" /> </span></td>
					</tr>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>

</div>
</div>

<div style="position: relative;margin-left:320px; width: 450px;background-color:#fff">
<ww:if test="triporder.state==1">
<input type="submit" class="button_d font-bai" value="修改联系人" /> &nbsp;

<input type="button" class="button_d font-bai" onclick="javascript:if(confirm('此订单状态将被改为-完成状态\r\n您确定要执行此操作吗？'))window.location.href='triporder!edit.action?id=<ww:property value="id"/>&<ww:property value="url"/>&state=2';" name="Submit2" value=" 订单完成 " />&nbsp;

<input type="button" class="button_d font-bai" onclick="javascript:if(confirm('此订单状态将被改为-取消状态\r\n您确定要执行此操作吗？'))window.location.href='triporder!edit.action?id=<ww:property value="id"/>&<ww:property value="url"/>&state=3';" name="Submit2" value=" 取消订单 " />&nbsp;

</ww:if>
<input type="button" class="button_d font-bai" onclick="window.location.href='triporder.action?<ww:property value="url"/>';" name="Submit2" value=" 返回列表 " />
</form>
</body>
</html>


