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
<title>国际机票查询</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<link href="style/airco.css" rel="stylesheet" type="text/css" />
<link href="style/ticket.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/interticket/jquery.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/interticket/createorder.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<style type="text/css">
.csstab {
	BACKGROUND: #fff no-repeat right bottom;
	HEIGHT: 100%;
	COLOR: #373737;
	CLEAR: both;
	FONT-SIZE: 12px;
	OVERFLOW: hidden;
	margin-top: 5px;
	BORDER-TOP: #cccccc 1px solid;
	BORDER-RIGHT: #cccccc 1px solid;
	BORDER-BOTTOM: #cccccc 1px solid;
	BORDER-LEFT: #cccccc 1px solid;
	voice-family: inherit
}

.hr1 {
	height: 1px;
	border: none;
	border-top: 1px dashed #cccccc;
}
</style>
<script type="text/javascript" language="javascript">
  $(document).ready(function() {
     //加载乘机人数量
     var adultcount=$("#HfadultCount").val();
     $("#selPassCount").val(adultcount);
     AddOrDelPeople();
  });
</script>
</head>

<body>
<form action="interticket!CreateOrder.action" name="form1"
	id="form1" method="POST">
<div>
<div class="box" style="text-align: center;">
<div class="quan" style="text-align: left"><span
	class="lan14_cu f">填写订单信息</span> <span class="r"><ww:property value="fromCity" /></span></div>
<div class="hangb" style="margin-top: 10px; padding-top: 0">
<table border="0" cellpadding="0" width="100%" cellspacing="0"
	style="padding-top: 0px;">
	<tr class="huang12_c" style="background: #DDECF3; font-weight: bold;">
		<td width='25%' align='center'>航程</td>
		<td width='25%' align='center'>航空公司</td>
		<td width='10%' align='center'>航班号</td>
		<td width='20%' align='center'>起飞时间</td>
		<td width='20%' align='center'>到达时间</td>
	</tr>
	<ww:iterator value="FlightWebList">
		<tr class='GridViewRowStyle'>
			<td width='25%' align='center'><ww:property
				value="getAirPortNamebyCode(fromairport)" /><br />
			<ww:property value="getAirPortNamebyCode(toairport)" /></td>
			<td width='25%' align='center'><span
				class='airco_<ww:property value="aircom" />'><ww:property
				value="getAirCompanyNamebyCode(aircom)" /></td>
			<td width='10%' align='center'><ww:property value="Flightnumber" /></td>
			<td width='20%' align='center'><ww:property
				value="formatTimestampHHmm2(fromdate)" /></td>
			<td width='20%' align='center'><ww:property
				value="formatTimestampHHmm2(todate)" /></td>
		</tr>
		<tr height='5px'>
			<td colspan='5'>
			<hr class='hr1' />
			</td>
		</tr>
	</ww:iterator>
	<tr>
		<td colspan="5">
		<div id="divtotalprice"
			style="width: 99%; height: 35px; display: none; text-align: center">
		<strong><font color='#F48000' size="5">总价格：<span
			id="lblCountPrice"></span>.00 元</font></strong></div>
			
		</td>
	</tr>
</table>
</div>
</div>
<div class="box" style="margin-top: 10px;">
<div class="quan"><font class="lan14_cu">乘机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写乘机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</div>
<div><span style="padding-left: 1%;"> 常用乘机人：<span
	style="padding-right: 2%;"><font class="hui_xi"
	style="margin: 0 20px 0 20px;">(如超过2名乘机人，请点击乘机人人数)</font></span>
<div id="divWriteGuestInfo">
<table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
	<tr height="15px">
		<td style="width: 99%; height: 15px;"></td>
	</tr>
	<tr>
		<td style="height: 41px">
		<div style="width: 100%; margin-left: 20px"><b><font
			color="red">选择乘机人数</font></b> <select id="selPassCount"
			onchange="AddOrDelPeople();">
			<option value="0"></option>
			<option value="1">1人</option>
			<option value="2">2人</option>
			<option value="3">3人</option>
			<option value="4">4人</option>
			<option value="5">5人</option>
			<option value="6">6人</option>
			<option value="7">7人</option>
			<option value="8">8人</option>
			<option value="9">9人</option>
		</select> <br />
		<div id="divPassengerName"><ww:iterator value="listcustomeruser"
			status="state">
			<table border="0" cellpadding="0" cellspacing="0" style="width: 90%">
				<tr style='background-color: #DDF1AA'>
					<td width='97%' align='center' height='30'>
					<table width='90%' border='0' cellspacing='0' cellpadding='0'>
						<tr>
							<td width='10%' align='right'><input type='checkbox'
								id='chbFPass_<ww:property value="#state.index"/>'
								onclick="BindFPass(<ww:property value="#state.index"/>);"></td>
							<td width='90%' align='left'><ww:property value="membername" /></td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			<div id='divHidPassInfo<ww:property value="#state.index"/>'><input
				id='hidIntelPassenger_ID<ww:property value="#state.index"/>'
				type="hidden" value='<ww:property value="id" />' /> <input
				id='hidCustomer_Giud<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidIntelPassName<ww:property value="#state.index"/>'
				type="hidden" value='<ww:property value="membername" />' /> <input
				id='hidIsStudent<ww:property value="#state.index"/>' type="hidden"
				value='0' /> <input
				id='hidIDCardType<ww:property value="#state.index"/>' type="hidden"
				value='' /> <input
				id='hidIDNumber<ww:property value="#state.index"/>' type="hidden"
				value='' /> <input
				id='hidPassCountryID<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidPassSex<ww:property value="#state.index"/>' type="hidden"
				value='' /> <input
				id='hidPassBirthday<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidZipCode<ww:property value="#state.index"/>' type="hidden"
				value='' /> <input
				id='hidDestinationAddress<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidResidenceAddress<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidIDCardValideDate<ww:property value="#state.index"/>'
				type="hidden" value='' /> <input
				id='hidGuest_Type<ww:property value="#state.index"/>' type="hidden"
				value='' /></div>
		</ww:iterator></div>
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 90%">
		<table border="0" width="100%">
			<tr>
				<td width="20px"></td>
				<td>
				<div id='divPassInfo'></div>
				</td>
			</tr>
		</table>
		</td>
	</tr>

</table>
</div>
<div id="divReadGuestInfo" style="display: none"></div>
</span></div>
<div class="c"></div>

<div class="box"
	style="width: 98%; margin: 0 auto; margin-bottom: 10px;"></div>

<div class="c"></div>
</div>

<div class="box" style="margin-top: 10px;">
<div class="quan"><font class="lan14_cu">联系人信息</font></div>
<div>
<table border="0" width="100%" id="divWriteContactInfo">
	<tr>
		<td>
		<table border="0" width="90%">
			<tr>
				<td style="width: 15%" align="right">联系人：</td>
				<td align="left"><input type="text" maxlength="50"
					id="txtContactName" name="s_contactname" /><span style="color: red">&nbsp;*&nbsp;</span></td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">联系手机：</td>
				<td align="left"><input type="text" maxlength="20"
					id="txtContactMobile" name="s_contactmobile" /><span style="color: red">&nbsp;*&nbsp;</span></td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">联系电话：</td>
				<td align="left"><input type="text" id="txtContactPhone" name="s_contactphone" /></td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">电子邮件：</td>
				<td align="left"><input type="text" id="txtContactEmail" name=s_contactemail"  /></td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">备注留言：</td>
				<td align="left"><textarea rows="5" cols="35" id="txtContactRemrk" name="s_memo"></textarea></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
<table border="0" width="100%" id="divReadContactInfo"
	style="display: none">
	<tr>
		<td>
		<table border="0" width="90%">
			<tr>
				<td style="width: 15%" align="right">联系人：</td>
				<td align="left">
				<div id="lblContactName"></div>
				</td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">联系手机：</td>
				<td align="left">
				<div id="lblConMobile"></div>
				</td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">联系电话：</td>
				<td align="left">
				<div id="lblConPhone"></div>
				</td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">电子邮件：</td>
				<td align="left">
				<div id="lblConEmail"></div>
				</td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">备注留言：</td>
				<td align="left">
				<div id="lblConRemark"></div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

</div>

<div id="divWritePayInfo"></div>
<div id="divPayTypeInfo"></div>
<div id="divReadPayInfo"></div>


<div class="c"></div>


</div>
<table width="100%" border="0">
	<tr>
		<td align="right"><input type="button" id="btnPreStep" style="display: none;cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108"
			value="上一步" onclick="PreStep();" /> <input
			type="button" id="btnList" style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108" value="上一步"
			onclick="window.history.go(-1);" /> 
			</td><td align="left">
			<input type="button" value="下一步"
			id="btnNextStep" style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108" onclick="return NextStep();" /> <input
			type="button" id="btnSubmitOrder" style="display: none;cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108" value="提交订单"
			onclick="CreateOrder();" />
		</td>
	</tr>
</table>

<input id="hidAllFtCountry" type="hidden" value="<ww:property value="s_Country" />" /> 
<input id="hidGuestType"  type="hidden" value="" /> 
<input id="hidName" type="hidden" name="s_hidname" value="" />
<input id="hidStudent" type="hidden" name="s_hidstudent" value="" />
<input id="hidCardType" name="s_hidcardtype" value="" type="hidden" /> 
<input id="hidCardNumber" name="s_hidcardnumber" value="" type="hidden" /> 
<input id="hidCardValDate" name="s_hidcardvaldate" text="" type="hidden" />
<input id="hidCountry" name="s_hidcountry" value="" type="hidden" /> 
<input id="hidCountryName" name="s_hidcountryname" value="" type="hidden" /> 
<input id="hidGender" name="s_hidgender" value="" type="hidden" /> 
<input id="hidBirthday" name="s_hidbirthday" value="" type="hidden" /> 
<input id="hidZipCode" name="s_hidzipcode" value="" type="hidden" /> 
<input id="hidTarget_Address" name="s_hidtargetaddress" value="" type="hidden" /> 
<input id="hidLive_Address" name="s_hidliveaddress" value="" type="hidden" /> 
<input id="hidCityCode" name="s_hidcitycode" value="" type="hidden" /> 
<input id="hidCountryCode"  value="<ww:property value="EndAirportCode" />" type="hidden" /> 
<input id="hidPriceCount" name="s_totalPrice" value='<ww:property value="s_totalPrice" />' type="hidden" /> 
<input id="hidPrice" name="s_price" value="<ww:property value="s_price" />" type="hidden" /> 
<input id="hidChlidPrice" name="s_chlidprice" value="<ww:property value="s_chlidprice" />" type="hidden" />
<input id="hidTax" name="s_tax" value="<ww:property value="s_tax" />" type="hidden" /> 
<input id="hidAllGuestType" name="s_hidguesttype" value="" type="hidden" />
<input id="hidCusAddress" value="" type="hidden" /> 
<input id="hfCustomerID" value="" type="hidden" /> 
<input id="hfAllIntelPass" value="" type="hidden" /> 
<input id="hfCusGuid" value="" type="hidden" />
<input type="hidden" id="HfadultCount" name="adultCount" value="<ww:property value="adultCount" />" />

</div>
</form>
</body>
</html>


