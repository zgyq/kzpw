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
<title><ww:if test="wanlixing.id>0">编辑</ww:if><ww:else>新增</ww:else>万里行申请表</title>

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
			test="wanlixing.id>0">编辑</ww:if><ww:else>新增</ww:else>万里行申请表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="wanlixing!<ww:if test="wanlixing.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>性别：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="性别不能为空" name="sex"
							value='<ww:property value="wanlixing.sex"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>称谓：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="称谓不能为空" name="chenghu"
							value='<ww:property value="wanlixing.chenghu"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>中文姓：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="中文姓不能为空" name="zxing"
							value='<ww:property value="wanlixing.zxing"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>中文名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="中文名不能为空" name="zming"
							value='<ww:property value="wanlixing.zming"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>英文姓：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="英文姓不能为空" name="yxing"
							value='<ww:property value="wanlixing.yxing"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>英文名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="英文名不能为空" name="yming"
							value='<ww:property value="wanlixing.yming"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>身份证号码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="身份证号码不能为空" name="number"
							value='<ww:property value="wanlixing.number"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>护照号码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="护照号码不能为空" name="huzhao"
							value='<ww:property value="wanlixing.huzhao"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>军官证：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="军官证不能为空" name="jun"
							value='<ww:property value="wanlixing.jun"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>回乡证：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="回乡证不能为空" name="hui"
							value='<ww:property value="wanlixing.hui"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>其他证件号码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="其他证件号码不能为空" name="qita"
							value='<ww:property value="wanlixing.qita"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>国籍：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="国籍不能为空" name="guoji"
							value='<ww:property value="wanlixing.guoji"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出生日期：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出生日期不能为空" name="chusheng"
							value='<ww:property value="wanlixing.chusheng"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>联络语言：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="联络语言不能为空" name="yuyan"
							value='<ww:property value="wanlixing.yuyan"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>密码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="密码不能为空" name="password"
							value='<ww:property value="wanlixing.password"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>提示问题：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="提示问题不能为空" name="wenti"
							value='<ww:property value="wanlixing.wenti"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>问题答案：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="问题答案不能为空" name="daan"
							value='<ww:property value="wanlixing.daan"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮箱：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮箱不能为空" name="postbox"
							value='<ww:property value="wanlixing.postbox"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮寄类型：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮寄类型不能为空" name="youtype"
							value='<ww:property value="wanlixing.youtype"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮寄到国家：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮寄到国家不能为空" name="youjiguo"
							value='<ww:property value="wanlixing.youjiguo"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮寄到省：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮寄到省不能为空" name="youjisheng"
							value='<ww:property value="wanlixing.youjisheng"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮政编码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮政编码不能为空" name="youbian"
							value='<ww:property value="wanlixing.youbian"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>市/县/自治州：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="市/县/自治州不能为空" name="shi"
							value='<ww:property value="wanlixing.shi"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>邮寄地址：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="邮寄地址不能为空" name="address"
							value='<ww:property value="wanlixing.address"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>联系电话：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="联系电话不能为空" name="dianhua"
							value='<ww:property value="wanlixing.dianhua"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>传真：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="传真不能为空" name="fax"
							value='<ww:property value="wanlixing.fax"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>账单邮寄类型：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="账单邮寄类型不能为空" name="duizhangtype"
							value='<ww:property value="wanlixing.duizhangtype"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>联系手机：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="联系手机不能为空" name="mobile"
							value='<ww:property value="wanlixing.mobile"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>单位名称：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="单位名称不能为空" name="copname"
							value='<ww:property value="wanlixing.copname"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>阁下级别：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="阁下级别不能为空" name="jibie"
							value='<ww:property value="wanlixing.jibie"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>行业性质：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="行业性质不能为空" name="xingzhi"
							value='<ww:property value="wanlixing.xingzhi"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='wanlixing.action?<ww:property value="url"/>';"
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


