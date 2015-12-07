<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */ 
%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="style/text.css" rel="stylesheet" type="text/css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/CommonX.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
</head>

<body style="font-family: tahoma;">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>

		<td width="100%" height="26" class="box-bottom bg"><span
			class="font-blue-cu" style="display: block; float: left;">&nbsp;&nbsp;&nbsp;添加包机政策</span>

		</td>

	</tr>
	<tr>
		<td valign="top">
		<form
			action="cpzrate!<ww:if test="cpzrate.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post" onsubmit="return form_validate()"
			enctype="multipart/form-data">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">

			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%" valign="top">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									style="line-height: 28px;">
									<tr>
										<td colspan="2" align="left" valign="top">
										<div class="main_04"></div>

										<div class="level3_list">
										<div class="level3_list_list">
										<table width="100%" border="0" cellpadding="0" cellspacing="1"
											bgcolor="#99ccff">
											<tr>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>航空公司</td>
												<td width="40%"><select id="aircompany"
													style="width: 230px;" name="aircompany">
													<ww:iterator value="listAircompany">
														<option value="<ww:property value="aircomcode"/>"
															<ww:if test="cpzrate.aircompany==aircomcode">selected="selected"</ww:if>><ww:property
															value="aircomcnname" />/<ww:property value="aircomcode" /></option>
													</ww:iterator>
												</select></td>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>航班号</td>
												<td width="40%"><input text="text" name="airline" value="<ww:property value="cpzrate.airline"/>" /></td>
											</tr>
											<tr>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>出发城市</td>
												<td width="40%"><select name="startcity">
													<ww:iterator value="listCityairport">
														<option value="<ww:property value="airportcode"/>"
															<ww:if test="cpzrate.startcity==airportcode">selected="selected"</ww:if>><ww:property
															value="cityname" />(<ww:property value="airportcode" />)</option>
													</ww:iterator>
												</select></td>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>到达城市</td>
												<td width="40%"><select name="endcity">
													<ww:iterator value="listCityairport">
														<option value="<ww:property value="airportcode"/>"
															<ww:if test="cpzrate.endcity==airportcode">selected="selected"</ww:if>><ww:property
															value="cityname" />(<ww:property value="airportcode" />)</option>
													</ww:iterator>
												</select></td>
											</tr>
											<tr>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>舱位</td>
												<td width="40%"><input text="text" name="aircode" value="<ww:property value="cpzrate.aircode"/>"  /></td>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>票面价</td>
												<td width="40%"><input text="text" name="price" value="<ww:property value="cpzrate.price"/>"  /></td>
											</tr>
											<tr>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>折扣</td>
												<td width="40%"><input text="text" name="discount" value="<ww:property value="cpzrate.discount"/>" /></td>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>返点</td>
												<td width="40%"><input text="text" name="rebate"  value="<ww:property value="cpzrate.rebate"/>"/></td>
											</tr>
											<tr>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>结算价</td>
												<td width="40%"><input text="text" name="sprice"  value="<ww:property value="cpzrate.sprice"/>" /></td>
												<td width="10%" class="level3_textright"><span
													class="integrant"></span>政策有效期</td>
												<td width="40%"><input text="text"
													name="s_issuedstartdate" value="<ww:property value="s_issuedstartdate"/>" onClick="WdatePicker()" />-<input
													text="text" name="s_issuedendate"  value="<ww:property value="s_issuedendate"/>" onClick="WdatePicker()" />
												</td>
											</tr>
										</table>
										</div>
										</div>
										<div class="level3_list_list" align="center"><br />
										<input type="submit" name="button" class="button_d font-white"
											style="margin-right: 40px;" value="提&nbsp;交" /> <input
											type="button" onclick="javascript:window.history.go(-1)"
											class="button_d font-white" name="button2" value="返&nbsp;回" />
										<br />
										</div>
										</td>
									</tr>

								</table>
								</td>
							</tr>
						</table>
						</td>
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
<script type="text/javascript">
<!--适用类型单选框-->
function flightnumbercheck(flag)
{
	document.getElementById("s_flightnumber").disabled=flag;
} 
function   goSave(){ 
var   length   =   document.form1.fb_list.options.length; 
var   optionObjs   =   document.form1.fb_list.options; 
var   ids= ""; 
for(i=0;i <length-1;i++){ 
ids   +=optionObjs[i].value+ "/"; 
} 
if(length>0)
{
ids+=optionObjs[length-1].value;
}else
{
ids="";
}
document.getElementById("arrivalport").value=ids;
} 
$(function(){
　　$("#btnAdd").click(function(){
　　　　　　　if($("#citylist option:selected").length>0)
　　　　　　　{
　　　　　　　　　　　$("#citylist option:selected").each(function(){
　　　　　　　　　　　　　　$("#fb_list").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
　　　　　　　　　　　　　　$(this).remove();　
　　　　　　　　　　　})
　　　　　　　}
　　　　　　　else
　　　　　　　{
　　　　　　　　　　　alert("请选择要添加的城市！");
　　　　　　　}
			goSave()
　　　})
})
$(function(){
　　　　　　$("#btnDel").click(function(){
　　　　　　　　　　　if($("#fb_list option:selected").length>0)
　　　　　　　　　　　{
　　　　　　　　　　　　　　　$("#fb_list option:selected").each(function(){
　　　　　　　　　　　　　　　　　　　　　$("#citylist").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
　　　　　　　　　　　　　　　　　　　　　$(this).remove();　
　　　　　　　　　　　　　　　})
　　　　　　　　　　　}
　　　　　　　　　　　else
　　　　　　　　　　　{
　　　　　　　　　　　　　　　alert("请选择要删除的城市！");
　　　　　　　　　　　}
			goSave()
　　　　　})
})
</script>
<script>
function form_validate() {
		var validate = true ;
		ratevalue = document.getElementById('ratevalue');
		if(ratevalue.value=="") {
			document.getElementById("ratevaluestr").innerHTML="*航空公司返点不能为空";
			ratevalue.focus();
			validate = false ;
		} else {
			document.getElementById("ratevaluestr").innerHTML="*";
		}
		
		
		s_issuedstartdate = document.getElementById('s_issuedstartdate');
		s_issuedendate = document.getElementById('s_issuedendate');
		if(s_issuedstartdate.value==""||s_issuedendate.value=="") {
			document.getElementById("s_issuedstartdatestr").innerHTML="*出票时间不能为空";
			s_issuedstartdate.focus();
			s_issuedendate.focus();
			validate = false ;
		} else {
			document.getElementById("s_issuedstartdatestr").innerHTML="*";
		}
		
		
		s_begindate = document.getElementById('s_begindate');
		s_enddate = document.getElementById('s_enddate');
		if(s_begindate.value==""||s_enddate.value=="") {
			document.getElementById("s_begindatestr").innerHTML="*有效日期不能为空";
			s_begindate.focus();
			s_enddate.focus();
			validate = false ;
		} else {
			document.getElementById("s_begindatestr").innerHTML="*";
		}
		
		
		cabincode = document.getElementById('cabincode');
		if(cabincode.value=="") {
			document.getElementById("cabincodestr").innerHTML="*仓位码不能为空";
			cabincode.focus();
			validate = false ;
		} else {
			document.getElementById("cabincodestr").innerHTML="*";
		}
		
		
		s_flightnumber = document.getElementById('s_flightnumber');
		if(s_flightnumber.value==""&&!s_flightnumber.disabled) {
			document.getElementById("s_flightnumberstr").innerHTML="*航班号不能为空";
			s_flightnumber.focus();
			validate = false ;
		} else {
			document.getElementById("s_flightnumberstr").innerHTML="*";
		}
		
		arrivalport = document.getElementById('arrivalport');
		if(arrivalport.value=="") {
			document.getElementById("arrivalportstr").innerHTML="*到达城市不能为空";
			arrivalport.focus();
			validate = false ;
		} else {
			document.getElementById("arrivalportstr").innerHTML="*";
		}
		
		
		s_keepnum = document.getElementById('s_keepnum');
		if(s_keepnum.value=="") {
			document.getElementById("s_keepnumstr").innerHTML="*留点/留钱不能为空";
			s_keepnum.focus();
			validate = false ;
		} else {
			document.getElementById("s_keepnumstr").innerHTML="*";
		}
		
		
		return validate;
}
function changezrate(id)
{
	document.getElementById("s_zratetype").value=id;
	if(id=="0")
	{
		document.getElementById("fromCity").innerHTML="出发城市";
		document.getElementById("toCity").innerHTML="到达城市";
		document.getElementById("tab1").className="btn_01";
		document.getElementById("tab2").className="btn_2";
	}else
	{
		document.getElementById("fromCity").innerHTML="<span style='color:red;'>到达城市</span>";
		document.getElementById("toCity").innerHTML="出发城市";
		document.getElementById("tab1").className="btn_2";
		document.getElementById("tab2").className="btn_01";
	}
}
function showcabin()
{
	var cabincode=document.getElementById("aircompanycode").value;
	$.post("zrate!getCabinstr.action", {s_ezm:cabincode}, function (datacabin) {
			if (datacabin) {
				document.getElementById("id_cabincode").value=datacabin;
			}
		});
}
<ww:if test="zrate.id>0">
</ww:if>
<ww:else>
showcabin();
</ww:else>
</script>

