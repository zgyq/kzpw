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
<title><ww:if test="cabin.id>0">编辑</ww:if><ww:else>新增</ww:else>舱位基础信息表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript">
	function form_validate() {
		var validate = true ;
		
		discount = document.getElementById('discount');
		if(discount.value == '') {
			document.getElementById("discountSp").innerHTML="*舱位折扣不许为空";
			discount.focus();
			validate = false ;
		}else {
			document.getElementById("discountSp").innerHTML="*";
		}
		
		enddate = document.getElementById('enddate');
		if(enddate.value == '') {
			document.getElementById("enddateSp").innerHTML="*结束时间不许为空";
			validate = false ;
		}else {
			document.getElementById("enddateSp").innerHTML="*";
		}
		
		stratedate = document.getElementById('stratedate');
		if(stratedate.value == '') {
			document.getElementById("stratedateSp").innerHTML="*开始时间不许为空";
			validate = false ;
		}else {
			document.getElementById("stratedateSp").innerHTML="*";
		}
		
		cabincode = document.getElementById('cabincode');
		if(cabincode.value == '') {
			document.getElementById("cabincodeSp").innerHTML="*舱位码不许为空";
			cabincode.focus();
			validate = false ;
		} else if(cabincode.value.length != 1) {
			document.getElementById("cabincodeSp").innerHTML = "*长度为1个英文字符";
			cabincode.focus();
			validate = false ;
		} else {
			document.getElementById("cabincodeSp").innerHTML="*";
		}
		
		aircompanycode = document.getElementById('aircompanycode');
		if(aircompanycode.value == '') {
			document.getElementById("aircompanycodeSp").innerHTML="*航司代码不许为空";
			aircompanycode.focus();
			validate = false ;
		} else if(aircompanycode.value.length != 2) {
			document.getElementById("aircompanycodeSp").innerHTML="*长度必须为2个英文字符";
			aircompanycode.focus();
			validate = false ;
		} else {
			document.getElementById("aircompanycodeSp").innerHTML="*";
		}
		return validate;
	}
	
</script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="cibin!toeditlanguage.action";
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
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="city.id>0">编辑</ww:if><ww:else>新增</ww:else>燃油费机建费表</span>
		<!--<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="cabin.id>0||cabin.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="cabin.ucode"/>,0)" <ww:if test="cabin.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="cabin.ucode"/>,1)" <ww:if test="cabin.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="cabin.ucode"/>,2)" <ww:if test="airfee.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="cabin.ucode"/>,3)" <ww:if test="cabin.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">EINGLISH</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		
		</span>--></td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="cabin!<ww:if test="cabin.id>0">edit.action?id=<ww:property value="cabin.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" onSubmit="return form_validate()">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>航司代码：</span></td>
						<td class="table_color_l" width="40%"><input type="text"
							id="aircompanycode" name="aircompanycode"
							value='<ww:property value="cabin.aircompanycode"/>'
							style="width: 150px; margin-right: 5px;" /><span
							id="aircompanycodeSp" class="font-red">*</span></td>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>舱位码：</span></td>
						<td class="table_color_l"><input type="text" id="cabincode"
							name="cabincode" value='<ww:property value="cabin.cabincode"/>'
							style="width: 150px; margin-right: 5px;" /><span
							id="cabincodeSp" class="font-red">*</span></td>
					</tr>
					<tr>

						<td height="28" align="right" class="table_color_r colortrin"><span>开始时间：</span></td>
						<td class="table_color_l"><input type="text"
							name="c_startdate" id="stratedate"
							value='<ww:property value="formatTimestamp(cabin.stratedate)"/>'
							style="width: 150px; margin-right: 5px;"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							class="Wdate" /><span id="stratedateSp" class="font-red">*</span>
						</td>
						<td height="28" align="right" class="table_color_r colortrin"><span>结束时间：</span></td>
						<td class="table_color_l"><input type="text" name="c_enddate"
							id="enddate"
							value='<ww:property value="formatTimestamp(cabin.enddate)"/>'
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							class="Wdate" style="width: 150px; margin-right: 5px;" /><span
							id="enddateSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>舱位折扣：</span></td>
						<td class="table_color_l"><input type="text" id="discount"
							name="discount" value='<ww:property value="cabin.discount"/>'
							style="width: 150px; margin-right: 5px;" /><span id="discountSp"
							class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>状态：</span></td>
						<td class="table_color_l"><ww:if test="cabin.isenable==0">
							<input type="radio" name="isenable" value="1" />启用&nbsp;
								<input type="radio" name="isenable" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="isenable" value="1" checked="checked" />启用&nbsp;
								<input type="radio" name="isenable" value="0" />禁用
							</ww:else></td>
					</tr>
					<tr>
					<td height="74" align="right" class="table_color_r colortrin"><span>舱位退改票规则：</span></td>
					<td class="table_color_l" colspan="3"><input type="textarea" id="cabinrule" 
							name="cabinrule" value='<ww:property value="cabin.cabinrule"/>'
							style="width: 700px; margin-right: 5px;height:85px;" /></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="cabin.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="cabin.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="cabin.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai"
							onclick="window.location.href='cabin.action?<ww:property value="url"/>';"
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


