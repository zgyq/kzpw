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
<title><ww:if test="triporderrc.id>0">编辑</ww:if><ww:else>新增</ww:else>旅行订单记录</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="triporderrc!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="triporderrc.id>0">编辑</ww:if><ww:else>新增</ww:else>旅行订单记录</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="triporderrc.id>0||triporderrc.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triporderrc.ucode"/>,0)" <ww:if test="triporderrc.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triporderrc.ucode"/>,1)" <ww:if test="triporderrc.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triporderrc.ucode"/>,2)" <ww:if test="triporderrc.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="triporderrc.ucode"/>,3)" <ww:if test="triporderrc.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="triporderrc!<ww:if test="triporderrc.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>订单ID：</span></td>
						<td><input type="text" name="orderid"
							value='<ww:property value="triporderrc.orderid"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>操作人：</span></td>
						<td><input type="text" name="handleuser"
							value='<ww:property value="triporderrc.handleuser"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>操作内容：</span></td>
						<td><input type="text" name="content"
							value='<ww:property value="triporderrc.content"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>描述：</span></td>
						<td><textarea name="description" cols="50" rows="5"><ww:property
							value="triporderrc.description" /></textarea></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>联系电话：</span></td>
						<td><input type="text" name="linktell"
							value='<ww:property value="triporderrc.linktell"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>相关状态：</span></td>
						<td><input type="text" name="state"
							value='<ww:property value="triporderrc.state"/>'
							style="width: 350px" /></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="triporderrc.language>0">
					<input id="language" type="hidden" name="triporderrc.language" value="<ww:property value="triporderrc.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="triporderrc.language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="triporderrc.ucode" value="<ww:property value="triporderrc.ucode"/>"/>
					<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='triporderrc.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
						<ww:iterator value="actionMessages">
							<div id="tishi" style=" position: absolute; top:-55px; left:0px; "><img src="images/gg.png" width="149" height="60" /></div>
							<script type="text/javascript">
								setTimeout("showclose()",2000); 
								function showclose()
								{
									document.getElementById("tishi").style.display="none";
								}
							</script>
							</ww:iterator>
							</div>
						</td>
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


