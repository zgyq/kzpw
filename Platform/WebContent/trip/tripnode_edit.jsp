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
<title><ww:if test="tripnode.id>0">编辑</ww:if><ww:else>新增</ww:else>注意事项</title>

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
	document.form1.action="tripnode!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="tripnode.id>0">编辑</ww:if><ww:else>新增</ww:else>注意事项</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="tripnode.id>0||tripnode.language>0">
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="tripnode.ucode"/>,0)" <ww:if test="tripnode.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="tripnode.ucode"/>,1)" <ww:if test="tripnode.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="tripnode.ucode"/>,2)" <ww:if test="tripnode.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="tripnode.ucode"/>,3)" <ww:if test="tripnode.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
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
			action="tripnode!<ww:if test="tripnode.id>0">edit.action?tripnode.id=<ww:property value="tripnode.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>线路名称：</span></td>
						<td><select name="triplineid">
								<option>----请选择路线----</option>
							<ww:iterator value="listTripline">
								<option value="<ww:property value="id" />" <ww:if test="triprange.triplineid==id">selected="selected"</ww:if>><ww:property value="name" /></option>
							</ww:iterator>
							</select></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>注意事项名称：</span></td>
						<td><input type="text" name="name"
							value='<ww:property value="tripnode.name"/>'
							style="width: 350px" /></td>
					</tr>
					<!--<tr>
						<td height="28" align="right"><span>排序：</span></td>
						<td><input type="text" name="sort"
							value='<ww:property value="tripnode.sort"/>'
							style="width: 350px" /></td>
					</tr>
					--><tr>
						<td height="28" align="right"><span>注意事项类型：</span></td>
						<td>
						<select name="type">
						  <option value="1" <ww:if test="tripnode.type==1">selected="selected"</ww:if>>目的地</option>
						  <option value="2" <ww:if test="tripnode.type==2">selected="selected"</ww:if>>重要提示</option>
						</select>
						<!-- <input type="text" name="type"
							value='<ww:property value="tripnode.type"/>'
							style="width: 350px" /> -->
						</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>注意事项内容：</span></td>
						<td><textarea type="text" name="content" id="content"
						 cols="80" rows="20"><ww:property value="tripnode.content"/></textarea></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="tripnode.language>0">
					<input id="language" type="hidden" name="tripnode.language" value="<ww:property value="tripnode.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="tripnode.language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="tripnode.ucode" value="<ww:property value="tripnode.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
							<input type="submit"
								class="button_d font-bai" value="提交" /> <input type="button"
								class="button_d font-bai"
								onclick="window.location.href='tripnode.action?<ww:property value="tripnode.url"/>';"
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

<script language="javascript">
		// 初始化文本编辑器
	var nEditor = new jtbcEditor('content');
	nEditor.tEditUBBMode = 0;
	nEditor.tInit('nEditor', 'js/jtbceditor/');
</script>


