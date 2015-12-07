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
<title><ww:if test="flightstop.id>0">编辑</ww:if><ww:else>新增</ww:else>航班经停信息</title>

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
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>

<script language="javascript">
	function getTime() {
		var arrtime = document.getElementById("arrtime").value;
		var levtime = document.getElementById("levtime").value;	
		
		if(arrtime != "" && levtime != "") {
			if (arrtime >= levtime) {
				document.getElementById("arrtimeSp").innerHTML="*开始时间不能大于等于结束时间";
				return;
			}
			
			var arr1 = arrtime.split(":");
			var lev1 = levtime.split(":");
			
			var arrDate = new Date();
			arrDate.setHours(arr1[0]);
			arrDate.setMinutes(arr1[1]);
			
			var levDate = new Date();
			levDate.setHours(lev1[0]);
			levDate.setMinutes(lev1[1]);
			
			var mytime = (levDate.getTime() - arrDate.getTime())/1000/60;	
			document.getElementById("mytime").value = "停留时间" + arrtime + "-" + levtime + "共" + mytime + "分钟";
		}
	}
	
	function formSubmit() {
		getTime();
		if (form_validate()) {
			document.form1.submit();
		}
	}
	
	function form_validate() {
		var validate = true ;
		
		city = document.getElementById('city');
		if(city.value == '') {
			document.getElementById("citySp").innerHTML="*经停城市不能为空";
			validate = false ;
			city.focus();
		} else {
			document.getElementById("citySp").innerHTML="*";
		}
		
		stopnumber = document.getElementById('stopnumber');
		if(stopnumber.value == '') {
			document.getElementById("stopnumberSp").innerHTML="*经停次数不能为空";
			validate = false ;
			stopnumber.focus();
		} else {
			document.getElementById("stopnumberSp").innerHTML="*";
		}
		
		flightnumber = document.getElementById('flightnumber');
		if(flightnumber.value == '') {
			document.getElementById("flightnumberSp").innerHTML="*航班号不能为空";
			validate = false ;
			flightnumber.focus();
		} else {
			document.getElementById("flightnumberSp").innerHTML="*";
		}
		
		eairportcode = document.getElementById('eairportcode');
		if(eairportcode.value == '') {
			document.getElementById("eairportcodeSp").innerHTML="*出发机场三字码不许为空";
			validate = false ;
			eairportcode.focus();
		} else if(eairportcode.value.length != 3) {
			document.getElementById("eairportcodeSp").innerHTML="*长度必须为3个英文字符";
			validate = false ;
			eairportcode.focus();
		} else {
			document.getElementById("eairportcodeSp").innerHTML="*";
		}
		
		sairportcode = document.getElementById('sairportcode');
		if(sairportcode.value == '') {
			document.getElementById("sairportcodeSp").innerHTML="*出发机场三字码不许为空";
			validate = false ;
			sairportcode.focus();
		} else if(sairportcode.value.length != 3) {
			document.getElementById("sairportcodeSp").innerHTML="*长度必须为3个英文字符";
			validate = false ;
			sairportcode.focus();
		} else {
			document.getElementById("sairportcodeSp").innerHTML="*";
		}
		
		return validate;
	}
	
</script>
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="flightstop!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="flightstop!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!--<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="flightstop.id>0">编辑</ww:if><ww:else>新增</ww:else>航班经停信息</span></b></td>
	
	 <td width="100%" height="29"  class="box-bottom bg" >
    <span class="font-blue-cu" style="display: block; float: left;">&nbsp;&nbsp;&nbsp;<ww:if
			test="flightstop.id>0">编辑</ww:if><ww:else>新增</ww:else>航班经停信息</span>
       <span style="display: block; background: url('images/bj_yy.gif'); width:356px; float: right;">
       <table border="0" cellpadding="0" cellspacing="0" style="text-align: center;width:356px;"><tr><td width="30%"><a href="#" class="add"  >简体</a></td><td width="20%"><a href="#">繁体</a></td><td width="25%"><a href="#">日语</a></td><td><a href="#">EINGLISH</a></td></tr></table>
    </span>
    </td>
	</tr>
	-->
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="city.id>0">编辑</ww:if><ww:else>新增</ww:else>航班经停信息</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="flightstop.id>0||flightstop.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightstop.ucode"/>,0)" <ww:if test="flightstop.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightstop.ucode"/>,1)" <ww:if test="flightstop.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="flightstop.ucode"/>,2)" <ww:if test="flightstop.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="flightstop.ucode"/>,3)" <ww:if test="flightstop.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
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
			action="flightstop!<ww:if test="flightstop.id>0">edit.action?id=<ww:property value="flightstop.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">

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
						<td height="28" align="right" width="15%" class="table_color_r colortrin"><span>出发机场三字代码：</span></td>
						<td class="table_color_l" width="30%"><input type="text" name="sairportcode" id="sairportcode"
							value='<ww:property value="flightstop.sairportcode"/>'
							style="width: 150px;margin-right: 5px;" /><span id="sairportcodeSp" class="font-red">*</span></td>
						<td height="28" align="right" width="15%" class="table_color_r colortrin"><span>到达机场三字代码：</span></td>
						<td class="table_color_l"><input type="text" name="eairportcode" id="eairportcode"
							value='<ww:property value="flightstop.eairportcode"/>'
							style="width: 150px;margin-right: 5px;" /><span id="eairportcodeSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>航班号：</span></td>
						<td class="table_color_l"><input type="text" name="flightnumber" id="flightnumber"
							value='<ww:property value="flightstop.flightnumber"/>'
							style="width: 150px;margin-right: 5px;" /><span id="flightnumberSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>经停次数：</span></td>
						<td class="table_color_l"><input type="text" name="stopnumber" id="stopnumber"
							value='<ww:property value="flightstop.stopnumber"/>'
							style="width: 150px;margin-right: 5px;" /><span id="stopnumberSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>经停城市：</span></td>
						<td class="table_color_l"><input type="text" name="city" id="city"
							value='<ww:property value="flightstop.city"/>'
							style="width: 150px;margin-right: 5px;" /><span id="citySp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>停留时间：</span></td>
						<td class="table_color_l">
							<input type="text" id="arrtime"
								onfocus="WdatePicker({dateFmt:'HH:mm'})" class="Wdate" style="width:70px;" />&nbsp;至&nbsp;
							<input type="text" style="width:70px;margin-right: 5px;" id="levtime"
								onfocus="WdatePicker({dateFmt:'HH:mm'})" class="Wdate" />
							<input type="hidden" id="mytime" name="time"
								value='<ww:property value="flightstop.time"/>'
								style="width: 150px" readonly="readonly" onfocus="getTime();" /><span id="arrtimeSp" class="font-red"></span>
						</td>
					</tr>
					<!--<tr>
						<td height="28" align="right"><span>停留时间：</span></td>
						<td><input type="text" id="mytime" name="time"
							value='<ww:property value="flightstop.time"/>'
							style="width: 350px" readonly="readonly" onfocus="getTime();" /></td>
					</tr>
					--><tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>状态：</span></td>
						<td class="table_color_l" colspan="3"><ww:if test="flightstop.isenable==0">
							<input type="radio" name="isenable" value="1" />启用&nbsp;
								<input type="radio" name="isenable" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="isenable" value="1" checked="checked" />启用&nbsp;
								<input type="radio" name="isenable" value="0" />禁用
							</ww:else></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="flightstop.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="flightstop.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="flightstop.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type=button
							class="button_d font-bai" value="提交" onclick="formSubmit();"/> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='flightstop.action?<ww:property value="url"/>';"
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
