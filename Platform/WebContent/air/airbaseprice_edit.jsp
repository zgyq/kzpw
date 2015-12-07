<%@ page contentType="text/html; charset=GBK"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title><ww:if test="airbaseprice.id>0">编辑</ww:if><ww:else>新增</ww:else>机票基础价格表</title>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
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
		
		//enddate = document.getElementById('enddate');
		//if(enddate.value == '') {
		//	document.getElementById("enddateSp").innerHTML="*结束时间不许为空";
		//	validate = false ;
		//}else {
		//	document.getElementById("enddateSp").innerHTML="*";
		//}
		
		//startdate = document.getElementById('startdate');
		//if(startdate.value == '') {
		//	document.getElementById("startdateSp").innerHTML="*开始时间不许为空";
		//	validate = false ;
		//}else {
		//	document.getElementById("startdateSp").innerHTML="*";
		//}
		
		yqflag = document.getElementById('yqflag');
		if(yqflag.value == '') {
			document.getElementById("yqflagSp").innerHTML="*行李重量不许为空";
			validate = false ;
			yqflag.focus();
		}else {
			document.getElementById("yqflagSp").innerHTML="*";
		}
		
		aircompanycode = document.getElementById('aircompanycode');
		if(aircompanycode.value == '') {
			document.getElementById("aircompanycodeSp").innerHTML="*航司两字代码不许为空";
			validate = false ;
			aircompanycode.focus();
		} else if(aircompanycode.value.length != 2) {
			document.getElementById("aircompanycodeSp").innerHTML = "*长度为2个英文字符";
			validate = false ;
			aircompanycode.focus();
		} else {
			document.getElementById("aircompanycodeSp").innerHTML="*";
		}
		
		price = document.getElementById('price');
		if(price.value == '') {
			document.getElementById("priceSp").innerHTML="*Y舱价格不许为空";
			validate = false ;
			price.focus();
		} else {
			document.getElementById("priceSp").innerHTML="*";
		}
		
		miles = document.getElementById('miles');
		if(miles.value == '') {
			document.getElementById("milesSp").innerHTML="*里程数不许为空";
			validate = false ;
			miles.focus();
		} else {
			document.getElementById("milesSp").innerHTML="*";
		}
		
		eairportcode = document.getElementById('eairportcode');
		if(eairportcode.value == '') {
			document.getElementById("eairportcodeSp").innerHTML="*到达机场三字码不许为空";
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
</head>

<body style="height:100%; margin: 0; padding: 0;"> 
<div id="member" class="box" style="height:99%;position:absolute;float:left; width: 99%;">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" >
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="airbaseprice.id>0">编辑</ww:if><ww:else>新增</ww:else>机票基础价格表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="airbaseprice!<ww:if test="airbaseprice.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onsubmit="return form_validate()">

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
						<td height="28" align="right" width="15%"
							class="table_color_r colortrin"><span>出发机场三字码：</span></td>
						<td class="table_color_l" width="35%"><input type="text"
							name="sairportcode" id="sairportcode"
							value='<ww:property value="airbaseprice.sairportcode"/>'
							style="width: 150px; margin-right: 5px;" /><span id="sairportcodeSp" class="font-red">*</span></td>
						<td height="28" align="right" width="15%"
							class="table_color_r colortrin"><span>到达机场三字码：</span></td>
						<td class="table_color_l"><input type="text"
							name="eairportcode" id="eairportcode"
							value='<ww:property value="airbaseprice.eairportcode"/>'
							style="width: 150px;margin-right: 5px;" /><span id="eairportcodeSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>里程数：</span></td>
						<td class="table_color_l"><input type="text" name="miles" id="miles"
							value='<ww:property value="airbaseprice.miles"/>'
							style="width: 150px;margin-right: 5px;" /><span id="milesSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>Y舱价格：</span></td>
						<td class="table_color_l"><input type="text" name="price" id="price"
							value='<ww:property value="airbaseprice.price"/>'
							style="width: 150px;margin-right: 5px;" /><span id="priceSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>航司两字代码：</span></td>
						<td class="table_color_l"><input type="text"
							name="aircompanycode" id="aircompanycode"
							value='<ww:property value="airbaseprice.aircompanycode"/>'
							style="width: 150px;margin-right: 5px;" /><span id="aircompanycodeSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>行李重量：</span></td>
						<td class="table_color_l"><input type="text" name="yqflag" id="yqflag"
							value='<ww:property value="airbaseprice.yqflag"/>'
							style="width: 150px;margin-right: 5px;" /><span id="yqflagSp" class="font-red">*</span></td>
					</tr>
					<tr style="display: none">
						<td height="28" align="right" class="table_color_r colortrin"><span>有效期开始时间：</span></td>
						<td class="table_color_l"><input type="text" name="a_startdate" id="startdate"
							value='<ww:property value="formatTimestamp(airbaseprice.startdate)"/>'
							style="width: 150px;margin-right: 5px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" /><span id="startdateSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>有效期结束时间：</span></td>
						<td class="table_color_l"><input type="text" name="a_enddate" id="enddate"
							value='<ww:property value="formatTimestamp(airbaseprice.enddate)"/>'
							style="width: 150px;margin-right: 5px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" /><span id="enddateSp" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>状态：</span></td>
						<td class="table_color_l" colspan="3"><ww:if
							test="airbaseprice.isenable==0">
							<input type="radio" name="isenable" value="1" />启用&nbsp;
								<input type="radio" name="isenable" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="isenable" value="1" checked="checked" />启用&nbsp;
								<input type="radio" name="isenable" value="0" />禁用
							</ww:else></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai"
							onclick="window.location.href='airbaseprice.action?<ww:property value="url"/>';"
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


