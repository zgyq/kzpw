<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<form action="customeragent!tosetyj.action" name="form1" id="form1"
	method="post">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;分销商佣金设置</b></td>
	</tr>
	<tr>
		<td valign="top">
		<div>
		<div class="mnue">&nbsp;&nbsp;国内机票佣金</div>
		<div class="mnue_nr">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<!--DWLayoutTable-->
			<tr>
				<td width="15%" align="right"><span class="font-red">*</span>本公司分级留点方式：
				</td>
				<td width="35%"><input id="txtBenLiuDian" name="brokenum"
					value="<ww:property value="formatFloat(customeragent.brokenum)"/>" />%<span
					style="color: red">（注：请输入小数如0.50 ）</span></td>
				<td width="15%" align="right"><span class="font-red">*</span>下级分销商留点方式：
				</td>
				<td width="35%"><input id="txtXiaLiuDian" name="childbrokenum"
					value="<ww:property value="formatFloat(customeragent.childbrokenum)"/>" />%
				<span style="color: red">（注：请输入小数如0.50 ）</span></td>
			</tr>
			<tr height="20px">
				<td></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input id="btnSet" value="保存"
					type="submit" class="button_d font-white" /> <input id="btnSet"
					value="返回" type="button" class="button_d font-white"
					onclick="window.history.go(-1);" /></td>
			</tr>

		</table>
		</div>
		<br />
		<div><strong><span class="font-red">注意事项:</span></strong> <br />
		<ul style="padding-left: 30px;">
			<li>* 为必填项</li>
			<li>留点方式请输入小数</li>
		</ul>
		</div>
		</div>
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>
