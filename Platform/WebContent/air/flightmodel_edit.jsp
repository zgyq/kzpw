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
<title><ww:if test="flightmodel.id>0">编辑</ww:if><ww:else>新增</ww:else>机型信息表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript">
	function form_validate() {
		var validate = true ;
		
		modeldesc = document.getElementById('modeldesc');
		if(modeldesc.value == '') {
			document.getElementById("modeldescSp").innerHTML="*机场名称不能为空";
			validate = false ;
			modeldesc.focus();
		} else {
			document.getElementById("modeldescSp").innerHTML="*";
		}
		
		ridenum = document.getElementById('ridenum');
		if(ridenum.value == '') {
			document.getElementById("ridenumSp").innerHTML="*乘坐人数说明不能为空";
			validate = false ;
			ridenum.focus();
		} else {
			document.getElementById("ridenumSp").innerHTML="*";
		}
		
		modelname = document.getElementById('modelname');
		if(modelname.value == '') {
			document.getElementById("modelnameSp").innerHTML="*机型名称不能为空";
			validate = false ;
			modelname.focus();
		} else {
			document.getElementById("modelnameSp").innerHTML="*";
		}
		
		modelnum = document.getElementById('modelnum');
		if(modelnum.value == '') {
			document.getElementById("modelnumSp").innerHTML="*机型号不能为空";
			validate = false ;
			modelnum.focus();
		} else {
			document.getElementById("modelnumSp").innerHTML="*";
		}
		return validate;
	}
	
</script>
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="flightmodel!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="flightmodel.id>0">编辑</ww:if><ww:else>新增</ww:else>航空公司基础信息表</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="flightmodel.id>0||flightmodel.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightmodel.ucode"/>,0)" <ww:if test="flightmodel.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightmodel.ucode"/>,1)" <ww:if test="flightmodel.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightmodel.ucode"/>,2)" <ww:if test="flightmodel.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="flightmodel.ucode"/>,3)" <ww:if test="flightmodel.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">EINGLISH</a>&nbsp;&nbsp;</td>
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
			action="flightmodel!<ww:if test="flightmodel.id>0">edit.action?id=<ww:property value="flightmodel.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post"
			onsubmit="return form_validate()" enctype="multipart/form-data">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%" class="table_color_r colortrin"><span>机型号：</span></td>
						<td class="table_color_l" width="40%"><input type="text" name="modelnum" id="modelnum"
							value='<ww:property value="flightmodel.modelnum"/>'
							style="width: 150px;margin-right: 5px;" /><span id="modelnumSp" class="font-red">*</span></td>
						<td height="28" align="right" width="10%" class="table_color_r colortrin"><span>机型名称：</span></td>
						<td class="table_color_l"><input type="text" name="modelname" id="modelname"
							value='<ww:property value="flightmodel.modelname"/>'
							style="width: 150px;margin-right: 5px;" /><span id="modelnameSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>乘坐人数说明：</span></td>
						<td class="table_color_l"><input type="text" name="ridenum" id="ridenum"
							value='<ww:property value="flightmodel.ridenum"/>'
							style="width: 150px;margin-right: 5px;" /><span id="ridenumSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>图片路径：</span></td>
						<td class="table_color_l">
							<input type="file" name="plaImg" style="width: 225px" />
						</td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>是否是大飞机：</span></td>
						<td class="table_color_l" colspan="3"><ww:if test="flightmodel.isbig==0">
							<input type="radio" name="isbig" value="1" />是&nbsp;
								<input type="radio" name="isbig" value="0" checked="checked" />否
							</ww:if> <ww:else>
							<input type="radio" name="isbig" value="1" checked="checked" />是&nbsp;
								<input type="radio" name="isbig" value="0" />否
							</ww:else>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin" valign="top"><span>机型描述：</span></td>
						<td class="table_color_l" colspan="3">
							<textarea name="modeldesc" id="modeldesc" rows="8" cols="60"><ww:property value="flightmodel.modeldesc"/></textarea><span id="modeldescSp" class="font-red">*</span>
						</td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="flightmodel.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="flightmodel.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="flightmodel.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='flightmodel.action?<ww:property value="url"/>';"
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
					</div></td>
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


