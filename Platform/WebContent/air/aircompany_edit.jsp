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
<title><ww:if test="aircompany.id>0">编辑</ww:if><ww:else>新增</ww:else>航空公司基础信息表</title>

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
		
		aircomenname = document.getElementById('aircomenname');
		if(aircomenname.value == '') {
			document.getElementById("aircomennameSp").innerHTML="*航司英文名称不许为空";
			aircomenname.focus();
			validate = false ;
		} else {
			document.getElementById("aircomennameSp").innerHTML="*";
		}
		
		aircomjname = document.getElementById('aircomjname');
		if(aircomjname.value == '') {
			document.getElementById("aircomjnameSp").innerHTML="*航司简称不许为空";
			aircomjname.focus();
			validate = false ;
		}else {
			document.getElementById("aircomjnameSp").innerHTML="*";
		}
		
		aircomcnname = document.getElementById('aircomcnname');
		if(aircomcnname.value == '') {
			document.getElementById("aircomcnnameSp").innerHTML="*航司中文名称不许为空";
			aircomcnname.focus();
			validate = false ;
		}else {
			document.getElementById("aircomcnnameSp").innerHTML="*";
		}
		
		aircomcode = document.getElementById('aircomcode');
		if(aircomcode.value == '') {
			document.getElementById("aircomcodeSp").innerHTML="*航司代码不许为空";
			aircomcode.focus();
			validate = false ;
		}else {
			document.getElementById("aircomcodeSp").innerHTML="*";
		}
		return validate;
	}
	
</script>	
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="aircompany!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
</head>

<body style="height:100%; margin: 0; padding: 0;"> 
<div id="member" class="box" style="height:99%;position:absolute;float:left; width: 99%;">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" >
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="aircompany.id>0">编辑</ww:if><ww:else>新增</ww:else>航空公司基础信息表</span>
		</td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="aircompany!<ww:if test="aircompany.id>0">edit.action?id=<ww:property value="aircompany.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post"
			onsubmit="return form_validate()"
			enctype="multipart/form-data">

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
						<td height="28" align="right" width="10%" class="table_color_r colortrin"><span>航司代码：</span></td>
						<td class="table_color_l" width="40%">
							<input type="text" name="aircomcode"
							value='<ww:property value="aircompany.aircomcode"/>'
							style="width: 150px;" id="aircomcode"/>
							<span id="aircomcodeSp" class="font-red">*</span>
						</td>
						<td height="28" align="right" width="10%"  class="table_color_r colortrin"><span>航司中文名称：</span></td>
						<td class="table_color_l"><input type="text"
							name="aircomcnname" id="aircomcnname"
							value='<ww:property value="aircompany.aircomcnname"/>'
							style="width: 150px; "/>
							<span id="aircomcnnameSp" class="font-red">*</span>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>航司简称：</span></td>
						<td class="table_color_l"><input type="text"
							name="aircomjname" id="aircomjname"
							value='<ww:property value="aircompany.aircomjname"/>'
							style="width: 150px;"/>
							<span id="aircomjnameSp" class="font-red">*</span>
						</td>
						<td height="28" align="right" class="table_color_r colortrin"><span>航司英文名称：</span></td>
						<td class="table_color_l"><input type="text"
							name="aircomenname" id="aircomenname"
							value='<ww:property value="aircompany.aircomenname"/>'
							style="width: 150px;"/>
							<span id="aircomennameSp" class="font-red">*</span>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>航司logo：</span></td>
						<td class="table_color_l">
							<input type="file" name="logo" id="logo" style="width: 227px"  style="margin-right: 10px;"/>
						</td>
						<td height="28" align="right" class="table_color_r colortrin"><span>状态：</span></td>
						<td class="table_color_l"><ww:if
							test="aircompany.isenable==0">
							<input type="radio" name="isenable" value="1" />启用
								<input type="radio" name="isenable" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="isenable" value="1" checked="checked" />启用
								<input type="radio" name="isenable" value="0" />禁用
							</ww:else></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="aircompany.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="aircompany.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="aircompany.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='aircompany.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
							
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


