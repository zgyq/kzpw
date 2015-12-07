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
<title><ww:if test="tousu.id>0">编辑</ww:if><ww:else>新增</ww:else>投诉建议表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="tousu.id>0">编辑</ww:if><ww:else>新增</ww:else>投诉建议表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="tousu!<ww:if test="tousu.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>航班时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="航班时间不能为空" name="s_starttime"
							value='<ww:property value="tousu.starttime"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>小时：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="小时不能为空" name="hour"
							value='<ww:property value="tousu.hour"/>' " style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>分钟：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="分钟不能为空" name="minute"
							value='<ww:property value="tousu.minute"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出发城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出发城市不能为空" name="startcity"
							value='<ww:property value="tousu.startcity"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>到达城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="到达城市不能为空" name="endcity"
							value='<ww:property value="tousu.endcity"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>航班号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="航班号不能为空" name="flightnumber"
							value='<ww:property value="tousu.flightnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>事发日期：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="事发日期不能为空" name="s_happentime"
							value='<ww:property value="tousu.happentime"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>当事人姓名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="当事人姓名不能为空" name="username"
							value='<ww:property value="tousu.username"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>当事人性别：</span></td>
						<td><input type="radio" name="sex" value="1"/>&nbsp;男&nbsp;&nbsp; <input
				type="radio" name="sex" value="2" />&nbsp;女</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>代办人姓名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="代办人姓名不能为空" name="dainame"
							value='<ww:property value="tousu.dainame"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>代办人手机：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="代办人手机不能为空" name="daimobile"
							value='<ww:property value="tousu.daimobile"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>当事人证件类型：</span></td>
						<td><select name="type" style="width: 135px;">
		<option value="1">身份证</option>
		<option value="2">护照</option>
		<option value="3">其他证件</option>
		<!--<script language="JavaScript" src="../js/country.js"></script>
		-->
		</select></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>当事人证件号码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="当事人证件号码不能为空" name="number"
							value='<ww:property value="tousu.number"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>会员卡号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="会员卡号不能为空" name="kahao"
							value='<ww:property value="tousu.kahao"/>' " style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>联系电话：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="联系电话不能为空" name="mobile"
							value='<ww:property value="tousu.mobile"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>其他电话：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="其他电话不能为空" name="qitamobile"
							value='<ww:property value="tousu.qitamobile"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮政编码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮政编码不能为空" name="youbian"
							value='<ww:property value="tousu.youbian"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>联系地址：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="联系地址不能为空" name="address"
							value='<ww:property value="tousu.address"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>传真：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="传真不能为空" name="fax" value='<ww:property value="tousu.fax"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮箱：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮箱不能为空" name="postbox"
							value='<ww:property value="tousu.postbox"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>工作单位：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="工作单位不能为空" name="units"
							value='<ww:property value="tousu.units"/>' " style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>是否通过其他途径已投诉：</span></td>
						<td><input type="radio" name="iftype" value="1" />&nbsp;是&nbsp;&nbsp; <input
			type="radio" name="iftype" value="2" />&nbsp;否</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>投诉建议内容：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="投诉建议内容不能为空" name="comment"
							value='<ww:property value="tousu.comment"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>你的要求：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="你的要求不能为空" name="yaoqiu"
							value='<ww:property value="tousu.yaoqiu"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='tousu.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>





		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


