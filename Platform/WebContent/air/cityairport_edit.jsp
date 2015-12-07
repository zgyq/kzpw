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
<title><ww:if test="cityairport.id>0">编辑</ww:if><ww:else>新增</ww:else>机场城市</title>

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
		
		airportname = document.getElementById('airportname');
		if(airportname.value == '') {
			document.getElementById("airportnameSp").innerHTML="*机场名称不能为空";
			validate = false ;
			airportname.focus();
		} else {
			document.getElementById("airportnameSp").innerHTML="*";
		}
		
		airportcode = document.getElementById('airportcode');
		if(airportcode.value == '') {
			document.getElementById("airportcodeSp").innerHTML="*机场三字码不能为空";
			validate = false ;
			airportcode.focus();
		} else if(airportcode.value.length != 3) {
			document.getElementById("airportcodeSp").innerHTML="*长度必须为3个英文字符";
			validate = false ;
			airportcode.focus();
		} else {
			document.getElementById("airportcodeSp").innerHTML="*";
		}
		
		shortpinyin = document.getElementById('shortpinyin');
		if(shortpinyin.value == '') {
			document.getElementById("shortpinyinSp").innerHTML="*城市简拼不能为空";
			validate = false ;
			shortpinyin.focus();
		} else {
			document.getElementById("shortpinyinSp").innerHTML="*";
		}
		
		pinyin = document.getElementById('pinyin');
		if(pinyin.value == '') {
			document.getElementById("pinyinSp").innerHTML="*城市拼音不能为空";
			validate = false ;
			pinyin.focus();
		} else {
			document.getElementById("pinyinSp").innerHTML="*";
		}
		
		cityname = document.getElementById('cityname');
		if(cityname.value == '') {
			document.getElementById("citynameSp").innerHTML="*城市名称不能为空";
			validate = false ;
			cityname.focus();
		} else {
			document.getElementById("citynameSp").innerHTML="*";
		}
		
		return validate;
	}
	
</script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="cityairport!toeditlanguage.action";
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
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="cityairport.id>0">编辑</ww:if><ww:else>新增</ww:else>航空公司基础信息表</span>
		
		</td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="cityairport!<ww:if test="cityairport.id>0">edit.action?id=<ww:property value="cityairport.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return form_validate()">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table  border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"width="10%" class="table_color_r colortrin"><span>城市名称：</span></td>
						<td class="table_color_l"><input type="text" name="cityname" id="cityname"
							value='<ww:property value="cityairport.cityname"/>'
							style="width: 150px;margin-right: 5px;" /><span id="citynameSp" class="font-red">*</span></td>
						<td height="28" align="right"width="10%" class="table_color_r colortrin"><span>城市拼音：</span></td>
						<td class="table_color_l"><input type="text" name="pinyin" id="pinyin"
							value='<ww:property value="cityairport.pinyin"/>'
							style="width: 150px;margin-right: 5px;" /><span id="pinyinSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>城市简拼：</span></td>
						<td class="table_color_l"><input type="text" name="shortpinyin" id="shortpinyin"
							value='<ww:property value="cityairport.shortpinyin"/>'
							style="width: 150px;margin-right: 5px;" /><span id="shortpinyinSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>机场三字代码：</span></td>
						<td class="table_color_l"><input type="text" name="airportcode" id="airportcode"
							value='<ww:property value="cityairport.airportcode"/>'
							style="width: 150px;margin-right: 5px;" /><span id="airportcodeSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>机场名称：</span></td>
						<td class="table_color_l"><input type="text" name="airportname" id="airportname"
							value='<ww:property value="cityairport.airportname"/>'
							style="width: 150px;margin-right: 5px;" /><span id="airportnameSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>国内/国际：</span></td>
						<td class="table_color_l">
						<select name="countrycode">
							<option <ww:if test="cityairport.countrycode.equals(\"CN\")">selected</ww:if> value="CN" >国内</option>
							<option <ww:if test="!cityairport.countrycode.equals(\"CN\")">selected</ww:if> value="NO" >国际</option>
						</select>
						</td>
					</tr>
					<!--  
					
					<td height="28" align="right" class="table_color_r colortrin"><span>状态：</span></td>
						<td class="table_color_l"><ww:if test="cityairport.isenable==0">
							<input type="radio" name="isenable" value="1" />启用&nbsp;
								<input type="radio" name="isenable" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="isenable" value="1" checked="checked" />启用&nbsp;
								<input type="radio" name="isenable" value="0" />禁用
							</ww:else></td>
							
					
					 -->
					 <tr>
						<td height="28" align="right"><span>排序字段：</span></td>
						<td><input type="text" name="cityindex"
							value='<ww:property value="cityairport.cityindex"/>'
							style="width: 350px" /></td>
					</tr>
					 <!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="cityairport.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="cityairport.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="cityairport.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='cityairport.action?<ww:property value="url"/>';"
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


