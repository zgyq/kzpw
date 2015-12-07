<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotelorder.id>0">变更</ww:if><ww:else>新增</ww:else>酒店订单</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="../js/autocomplete/jquery.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<body>
<form action="hotelordermodify!<ww:if test="hotelorder.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return hotel_submit_prices();">

<input type="hidden" name="forwardall" value="<ww:property value="forwardall"/>"/>
<input type="hidden" name="hotelid" value="<ww:property value="hotelorder.hotelid"/>"> 
<input type="hidden" name="h_hotelCityId" value="<ww:property value="h_hotelCityId"/>"/>
<input type="hidden" name="h_orderId" value="<ww:property value="h_orderId"/>"/>
<input type="hidden" name="h_linkname" value="<ww:property value="h_linkname"/>"/>
<input type="hidden" name="h_linkmobile" value="<ww:property value="h_linkmobile"/>"/>
<input type="hidden" name="h_prestarttime" value="<ww:property value="h_prestarttime"/>"/>
<input type="hidden" name="h_preendtime" value="<ww:property value="h_preendtime"/>"/>
<input type="hidden" name="h_hotelName" value="<ww:property value="h_hotelName"/>"/>
<input type="hidden" name="h_isEnglishName" value="<ww:property value="h_isEnglishName"/>"/>

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29" background="../images/jb.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="hotelorder.id>0">变更</ww:if><ww:else>新增</ww:else>酒店订单</span></td>
  </tr>
  <tr>
    <td height="80%" align="center">
    <br/>
    <table width="90%" border="1" cellpadding="0" cellspacing="0"  bordercolor="#a0cfee" style="border-collapse:collapse">
      <tr>
        <td height="28" colspan="6">
        	<table>
        		<tr>
        			<td><h2><ww:property value="hotelorder.name"/></h2></td>
        		</tr>
        	</table>
        </td>
        <td></td>
      </tr>
      <ww:if test="ActionErrors.size() > 0">
	      <tr valign="middle">
	      	<td height="28" colspan="6"><h3><span style="color:red"><ww:iterator value="ActionErrors"><ww:property/></ww:iterator></span></h3></td>
	      </tr>
      </ww:if>
      <tr  height="25">
			<td align="right">房型：</td>
			<td>&nbsp;<select id="roomid" name="roomid" require="true" dataType="Require"   msg="房型不能为空" >
				<ww:iterator value="listRoomtype">
					<ww:if test="id == hotelorder.roomid">
						<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
					</ww:if>
					<ww:else>
						<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
					</ww:else>
				</ww:iterator>
			</select></td>
			<td align="right">入住日期：</td>
			<td>&nbsp;<input type="text" id="h_comedate_edit" require="true" dataType="Require"   msg="入住日期不能为空"  name="h_comedate_edit" value="<ww:property value="formatDate(hotelorder.comedate)"/>" readonly="readonly" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){h_leavedate_edit.focus();}})"/></td>
			<td align="right">离店日期：</td>
			<td>&nbsp;<input type="text" id="h_leavedate_edit" require="true" dataType="Compare" operator="LessThanEqualDate" to="h_comedate_edit"    msg="请输入正确的离店日期"  name="h_leavedate_edit" value="<ww:property value="formatDate(hotelorder.leavedate)"/>"  readonly="readonly" onfocus="this.value=getDateDiff($('#h_comedate_edit').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'h_comedate_edit\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+2}-%d'})" /></td>
      </tr>
      <tr  height="25">
			<td colspan="6" align="center"><input type="button" class="button" onclick="hotel_find_prices(<ww:property value="hotelorder.id"/>)"  value=" 查看价格 " /></td>
      </tr>
      <tr>
 	 	<td colspan="6">
 	 		<table width="100%" border="1" bordercolor="#a0cfee" style="border-collapse:collapse">
 	 			<tr>
 	 				<th width="20%" align="center">房型</th>
 	 				<th width="60%" align="center">协议价</th>
 	 				<th width="20%" align="center">床型</th>
 	 			</tr>
 	 			<tr>
 	 				<td align="center"><ww:property value="hotelorder.roomtypename"/></td>
 	 				<td align="center"><table width="100%" id="priceTable">
 	 						<tr>
 	 								<th>星期日</th>
 	 								<th>星期一</th>
 	 								<th>星期二</th>
 	 								<th>星期三</th>
 	 								<th>星期四</th>
 	 								<th>星期五</th>
 	 								<th>星期六</th>
 	 						</tr>
 	 						<tr class="priceClass">
 	 						<ww:iterator value="getPrices(hotelorder.price,hotelorder.comedate)" status="priceStatus">
 	 						
 	 							
 	 							<ww:if test="#priceStatus.index % 7 == 0">
 	 								</tr>
 	 								<tr  class="priceClass">
 	 							</ww:if>
 	 								<td><ww:property /><ww:property value="priceStatus"/></td>
 	 						</ww:iterator>
 	 						</tr>
 	 					</table>
 	 				</td>
 	 				<td align="center">
 	 							<ww:if test="getRoomtypeById(hotelorder.roomid).bed == 1">单人床</ww:if>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 2">大床</ww:elseif>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 3">双床</ww:elseif>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 4">大或双</ww:elseif>
 	 							<ww:else>其他</ww:else>
 	 				</td>
 	 			</tr>
 	 		</table>
 	 	</td>
 	 </tr>
 	 <tr height="20" valign="middle">
 	 	<td colspan="6" align="left"><b>&nbsp;&nbsp;预订联系人信息</b></td>
 	 </tr>
 	 <tr height="25">
 	 	<td align="right"><span style="color:red">*</span>联系人姓名：</td>
 	 	<td align="left">&nbsp;<input type="text" require="true" dataType="Require"   msg="联系人姓名不能为空"  name="linkname" value="<ww:property value="hotelorder.linkname"/>"/></td>
 	 	<td align="right"><span style="color:red">*</span>联系人手机：</td>
 	 	<td align="left">&nbsp;<input type="text" require="true" dataType="Mobile"   msg="请输入正确的手机号码"  name="linkmobile" value="<ww:property value="hotelorder.linkmobile"/>"/></td>
 	 	<td align="right"><span style="color:red">*</span>联系人邮箱：</td>
 	 	<td align="left">&nbsp;<input type="text" name="linkmail" dataType="Email"   msg="Email格式不正确"  value="<ww:property value="hotelorder.linkmail"/>"/></td>
 	 </tr>
 	  <tr height="25">
 	 	<td align="right">联系人固定电话：</td>
 	 	<td align="left">&nbsp;<input type="text" name="linktell" value="<ww:property value="hotelorder.linktell"/>"/></td>
 	 	<td align="right"><span style="color:red">*</span>确认方式：</td>
 	 	<td align="left">&nbsp;<select  name="confirmmethod">
 	 			<ww:if test="hotelorder.confirmmethod == 1">
 	 				<option value="1"  selected="selected">短信确认</option>
 	 			</ww:if>
 	 			<ww:else>
 	 				<option value="1">短信确认</option>
 	 			</ww:else>
 	 			<ww:if test="hotelorder.confirmmethod == 2">
 	 				<option value="2"  selected="selected">Email确认</option>
 	 			</ww:if>
 	 			<ww:else>
 	 				<option value="2">Email确认</option>
 	 			</ww:else>
 	 			<ww:if test="hotelorder.confirmmethod == 3">
 	 				<option value="3" selected="selected">短信和Email确认</option>
 	 			</ww:if>
 	 			<ww:else>
	 	 			<option value="3">短信和Email确认</option>
 	 			</ww:else>
 	 		</select>
 	 	</td>
 	 	<td>&nbsp;</td>
 	 	<td>&nbsp;</td>
 	 </tr>
 	  <tr height="25">
 	 	<td align="right">预订备注：</td>
 	 	<td colspan="5" align="left">&nbsp;<textarea cols="50" name="predesc"><ww:property value="hotelorder.predesc"/></textarea></td>
 	 </tr>
 	 <tr height="20" valign="middle">
 	 	<td colspan="6" align="left"><b>&nbsp;&nbsp;入住人联系信息</b></td>
 	 </tr>
 	 <tr>
 	 	<td align="right"><span style="color:red">*</span>预订间数：</td>
 	 	<td align="left" colspan="5">&nbsp;<input type="text" id="prerooms" name="prerooms" value="<ww:property value="hotelorder.prerooms"/>"/></td>
 	 </tr>
 	 <tr class="liverNameCalss">
 	 <ww:iterator value="listGuest" status="listGuestStatus">
 	 	 <ww:if test="#listGuestStatus.index % 3 == 0">
 	 	 	</tr>
 	 	 	<tr  class="liverNameCalss">
 	 	 </ww:if>
 	 	 <td align="right"><span>入住人姓名：</span></td>
 	 	 <td align="left">&nbsp;<input type="text" name="h_guest_edit" value="<ww:property value="name"/>"/></td>
 	 </ww:iterator>
 	 <ww:if test="listGuest.size() % 3 == 1">
 	 	<td>&nbsp;</td>
 	 	<td>&nbsp;</td>
 	 	<td>&nbsp;</td>
 	 	<td>&nbsp;</td>
 	 </ww:if>
 	 <ww:if test="listGuest.size() % 3 == 2">
 	 	<td>&nbsp;</td>
 	 	<td>&nbsp;</td>
 	 </ww:if>
 	 </tr>
 	 <tr id="liverNameTr" height="20" valign="middle">
 	 	<td colspan="6" align="left"><b>&nbsp;&nbsp;抵店时间和保留时间</b></td>
 	 </tr>
 	 <tr  height="25">
 	 	<td align="right"><span style="color:red">*</span>保留时间：</td>
 	 	<td align="left" colspan="5">&nbsp;<select id="h_savestarttime_edit" name="h_savestarttime_edit">
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'00:00')">
 	 			<option value="00:00" selected="selected">00:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="00:00">00:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'00:30')">
 	 			<option value="00:30" selected="selected">00:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="00:30">00:30</option>
 	 		</ww:else>
			<ww:if test="getBalliuTime(hotelorder.reservstart,'01:00')">
 	 			<option value="01:00" selected="selected">01:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="01:00">01:00</option>
 	 		</ww:else>
			<ww:if test="getBalliuTime(hotelorder.reservstart,'01:30')">
 	 			<option value="01:30" selected="selected">01:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="01:30">01:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'02:00')">
 	 			<option value="02:00" selected="selected">02:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="02:00">02:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'02:30')">
 	 			<option value="02:30" selected="selected">02:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="02:30">02:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'03:00')">
 	 			<option value="03:00" selected="selected">03:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="03:00">03:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'03:30')">
 	 			<option value="03:30" selected="selected">03:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="03:30">03:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'04:00')">
 	 			<option value="04:00" selected="selected">04:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="04:00">04:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'04:30')">
 	 			<option value="04:30" selected="selected">04:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="04:30">04:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'05:00')">
 	 			<option value="05:00" selected="selected">05:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="05:00">05:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'05:30')">
 	 			<option value="05:30" selected="selected">05:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="05:30">05:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'06:00')">
 	 			<option value="06:00" selected="selected">06:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="06:00">06:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'06:30')">
 	 			<option value="06:30" selected="selected">06:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="06:30">06:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'07:00')">
 	 			<option value="07:00" selected="selected">07:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="07:00">07:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'07:30')">
 	 			<option value="07:30" selected="selected">07:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="07:30">07:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'08:00')">
 	 			<option value="08:00" selected="selected">08:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="08:00">08:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'08:30')">
 	 			<option value="08:30" selected="selected">08:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="08:30">08:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'09:00')">
 	 			<option value="09:00" selected="selected">09:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="09:00">09:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'09:30')">
 	 			<option value="09:30" selected="selected">09:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="09:30">09:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'10:00')">
 	 			<option value="10:00" selected="selected">10:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="10:00">10:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'10:30')">
 	 			<option value="10:30" selected="selected">10:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="10:30">10:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'11:00')">
 	 			<option value="11:00" selected="selected">11:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="11:00">11:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'11:30')">
 	 			<option value="11:30" selected="selected">11:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="11:30">11:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'12:00')">
 	 			<option value="12:00" selected="selected">12:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="12:00">12:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'12:30')">
 	 			<option value="12:30" selected="selected">12:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="12:30">12:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'13:00')">
 	 			<option value="13:00" selected="selected">13:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="13:00">13:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'13:30')">
 	 			<option value="13:30" selected="selected">13:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="13:30">13:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'14:00')">
 	 			<option value="14:00" selected="selected">14:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="14:00">14:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'14:30')">
 	 			<option value="14:30" selected="selected">14:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="14:30">14:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'15:00')">
 	 			<option value="15:00" selected="selected">15:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="15:00">15:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'15:30')">
 	 			<option value="15:30" selected="selected">15:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="15:30">15:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'16:00')">
 	 			<option value="16:00" selected="selected">16:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="16:00">16:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'16:30')">
 	 			<option value="16:30" selected="selected">16:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="16:30">16:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'17:00')">
 	 			<option value="17:00" selected="selected">17:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="17:00">17:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'17:30')">
 	 			<option value="17:30" selected="selected">17:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="17:30">17:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'18:00')">
 	 			<option value="18:00" selected="selected">18:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="18:00">18:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'18:30')">
 	 			<option value="18:30" selected="selected">18:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="18:30">18:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'19:00')">
 	 			<option value="19:00" selected="selected">19:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="19:00">19:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'19:30')">
 	 			<option value="19:30" selected="selected">19:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="19:30">19:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'20:00')">
 	 			<option value="20:00" selected="selected">20:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="20:00">20:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'20:30')">
 	 			<option value="20:30" selected="selected">20:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="20:30">20:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'21:00')">
 	 			<option value="21:00" selected="selected">21:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="21:00">21:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'21:30')">
 	 			<option value="21:30" selected="selected">21:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="21:30">21:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'22:00')">
 	 			<option value="22:00" selected="selected">22:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="22:00">22:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'22:30')">
 	 			<option value="22:30" selected="selected">22:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="22:30">22:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'23:00')">
 	 			<option value="23:00" selected="selected">23:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="23:00">23:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservstart,'23:30')">
 	 			<option value="23:30" selected="selected">23:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="23:30">23:30</option>
 	 		</ww:else>
 	 	</select>&nbsp;至&nbsp;<select id="h_saveendtime_edit" name="h_saveendtime_edit" dataType="Compare" operator="HoldTime" to="h_savestarttime_edit"  msg="请输入正确的保留时间">
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'00:00')">
 	 			<option value="00:00" selected="selected">00:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="00:00">00:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'00:30')">
 	 			<option value="00:30" selected="selected">00:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="00:30">00:30</option>
 	 		</ww:else>
			<ww:if test="getBalliuTime(hotelorder.reservend,'01:00')">
 	 			<option value="01:00" selected="selected">01:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="01:00">01:00</option>
 	 		</ww:else>
			<ww:if test="getBalliuTime(hotelorder.reservend,'01:30')">
 	 			<option value="01:30" selected="selected">01:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="01:30">01:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'02:00')">
 	 			<option value="02:00" selected="selected">02:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="02:00">02:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'02:30')">
 	 			<option value="02:30" selected="selected">02:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="02:30">02:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'03:00')">
 	 			<option value="03:00" selected="selected">03:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="03:00">03:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'03:30')">
 	 			<option value="03:30" selected="selected">03:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="03:30">03:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'04:00')">
 	 			<option value="04:00" selected="selected">04:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="04:00">04:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'04:30')">
 	 			<option value="04:30" selected="selected">04:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="04:30">04:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'05:00')">
 	 			<option value="05:00" selected="selected">05:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="05:00">05:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'05:30')">
 	 			<option value="05:30" selected="selected">05:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="05:30">05:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'06:00')">
 	 			<option value="06:00" selected="selected">06:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="06:00">06:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'06:30')">
 	 			<option value="06:30" selected="selected">06:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="06:30">06:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'07:00')">
 	 			<option value="07:00" selected="selected">07:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="07:00">07:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservend,'07:30')">
 	 			<option value="07:30" selected="selected">07:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="07:30">07:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'08:00')">
 	 			<option value="08:00" selected="selected">08:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="08:00">08:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'08:30')">
 	 			<option value="08:30" selected="selected">08:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="08:30">08:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'09:00')">
 	 			<option value="09:00" selected="selected">09:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="09:00">09:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'09:30')">
 	 			<option value="09:30" selected="selected">09:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="09:30">09:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'10:00')">
 	 			<option value="10:00" selected="selected">10:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="10:00">10:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservend,'10:30')">
 	 			<option value="10:30" selected="selected">10:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="10:30">10:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'11:00')">
 	 			<option value="11:00" selected="selected">11:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="11:00">11:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'11:30')">
 	 			<option value="11:30" selected="selected">11:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="11:30">11:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'12:00')">
 	 			<option value="12:00" selected="selected">12:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="12:00">12:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'12:30')">
 	 			<option value="12:30" selected="selected">12:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="12:30">12:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'13:00')">
 	 			<option value="13:00" selected="selected">13:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="13:00">13:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'13:30')">
 	 			<option value="13:30" selected="selected">13:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="13:30">13:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'14:00')">
 	 			<option value="14:00" selected="selected">14:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="14:00">14:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'14:30')">
 	 			<option value="14:30" selected="selected">14:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="14:30">14:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'15:00')">
 	 			<option value="15:00" selected="selected">15:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="15:00">15:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'15:30')">
 	 			<option value="15:30" selected="selected">15:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="15:30">15:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'16:00')">
 	 			<option value="16:00" selected="selected">16:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="16:00">16:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'16:30')">
 	 			<option value="16:30" selected="selected">16:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="16:30">16:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'17:00')">
 	 			<option value="17:00" selected="selected">17:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="17:00">17:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'17:30')">
 	 			<option value="17:30" selected="selected">17:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="17:30">17:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'18:00')">
 	 			<option value="18:00" selected="selected">18:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="18:00">18:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'18:30')">
 	 			<option value="18:30" selected="selected">18:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="18:30">18:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'19:00')">
 	 			<option value="19:00" selected="selected">19:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="19:00">19:00</option>
 	 		</ww:else>
	 		<ww:if test="getBalliuTime(hotelorder.reservend,'19:30')">
 	 			<option value="19:30" selected="selected">19:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="19:30">19:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'20:00')">
 	 			<option value="20:00" selected="selected">20:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="20:00">20:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'20:30')">
 	 			<option value="20:30" selected="selected">20:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="20:30">20:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'21:00')">
 	 			<option value="21:00" selected="selected">21:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="21:00">21:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'21:30')">
 	 			<option value="21:30" selected="selected">21:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="21:30">21:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'22:00')">
 	 			<option value="22:00" selected="selected">22:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="22:00">22:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'22:30')">
 	 			<option value="22:30" selected="selected">22:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="22:30">22:30</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'23:00')">
 	 			<option value="23:00" selected="selected">23:00</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="23:00">23:00</option>
 	 		</ww:else>
 	 		<ww:if test="getBalliuTime(hotelorder.reservend,'23:30')">
 	 			<option value="23:30" selected="selected">23:30</option>
 	 		</ww:if>
 	 		<ww:else>
 	 			<option value="23:30">23:30</option>
 	 		</ww:else>
 	 	</select>&nbsp;请认真填写以下信息，酒店将根据您填写的信息提前安排时间 
 	 	</td>
 	 </tr>
 	 <tr height="25">
 	 	<td align="right"> 备注（特殊要求）：</td>
 	 	<td colspan="5" align="left">&nbsp;<textarea cols="50" name="specreq"><ww:property value="hotelorder.specreq"/></textarea></td>
 	 </tr>


      <tr class="font-blue-xi">
        <td height="46" scrolling="no" align="center" colspan="6"><input type="submit" class="button_d font-white" value="提交"/> <input type="button" class="button_d font-white" onclick="hotel_cannel_info('<ww:property value="forwardall"/>')"   name="Submit2" value=" 取消返回 " /> </td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</body>

<script type="text/javascript">

	function hotel_find_prices(id) {
		if(!Validator.Validate(document.form1,3)) {
			return ;
		}
		document.form1.action="hotelordermodify!getEditPrices.action?id="+id;
		document.form1.submit();
	}
	
	function hotel_submit_prices() {
		var iserror = true ;
		if(!Validator.Validate(document.form1,3)) {
			iserror = false ;
		}
		$()
		$('span.livertipinfo').remove();
		$("input[name='h_guest_edit']").each(function() {
			if($(this).val() == '') {
				$(this).parent().append("<span class='livertipinfo'>*请输入入住人</span>") ;
				iserror= false ;
			}
		}) ;
		return iserror ;
	}
	
	function hotel_cannel_info(forward) {
		if(forward == 'whole') {
			document.forms.form1.action="hotelwholeorder.action?" +  '<ww:property value="url"/>' ;
		} else {
			document.forms.form1.action="hotelnoconfirmorder.action?" +  '<ww:property value="url"/>' ;
		}
		document.forms.form1.submit() ;
	}
	
	$(document).ready(function() {
		var livernum = parseInt('<ww:property value="listGuest.size()"/>');
		$("#prerooms").keyup(function() {
			var $this = $(this) ;
			$('span', $this.parent()).remove() ;
			if(!/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test($this.val())) {
				$this.parent().append('<span>请输入正确的数</span>');
				$this.val(livernum);
			} else if(parseInt($this.val()) < 1 || parseInt($this.val()) > 30) {
				$this.parent().append('<span>预订的房间数在1到30之间</span>');
				$this.val(livernum);
			} else {
				var livernumbak = $this.val();
				if(livernumbak < livernum) {
					$('.liverNameCalss input:gt(' + (livernumbak -1) + ')').remove() ;
					$('.liverNameCalss span:gt(' + (livernumbak -1) + ')').remove() ;
					$('.liverNameCalss:not(.liverNameCalss:has(input))').remove();
				} else {
					if($this.val()-livernum == 1) {
						if(livernum % 3 == 1) {
							$('td:eq(2)',$('.liverNameCalss:last')).append('<span>入住人姓名：</span>');
							$('td:eq(3)',$('.liverNameCalss:last')).append('<input  name="h_guest_edit"  type="text" />');
							livernum += 1 ;
						} else if(livernum % 3 == 2) {
							$('td:eq(4)',$('.liverNameCalss:last')).append('<span>入住人姓名：</span>');
							$('td:eq(5)',$('.liverNameCalss:last')).append('<input  name="h_guest_edit"  type="text" />');
							livernum += 1 ;
						}
					} else if($this.val()-livernum > 1) {
						if(livernum % 3 == 1) {
							$('td:eq(2)',$('.liverNameCalss:last')).append('<span>入住人姓名：</span>');
							$('td:eq(3)',$('.liverNameCalss:last')).append('<input type="text" />');
							$('td:eq(4)',$('.liverNameCalss:last')).append('<span>入住人姓名：</span>');
							$('td:eq(5)',$('.liverNameCalss:last')).append('<input  name="h_guest_edit"  type="text" />');
							livernum += 2 ;
						} else if(livernum % 3 == 2) {
							$('td:eq(4)',$('.liverNameCalss:last')).append('<span>入住人姓名：</span>');
							$('td:eq(5)',$('.liverNameCalss:last')).append('<input  name="h_guest_edit"  type="text" />');
							livernum += 1 ;
						}
					}
					for(var i=0;i<$this.val()-livernum;) {
						var content = '<tr class="liverNameCalss">' ;
						if(i<($this.val()-livernum)) {
							content += '<td align="right"><span>入住人姓名：</span></td>' ;
							content += '<td align="left">&nbsp;<input  name="h_guest_edit"  type="text" /></td>' ;	
						} else {
							content += '<td align="right">&nbsp;</td>' ;
							content += '<td align="left">&nbsp;</td>' ;
						}
						i ++ ;
						if(i<($this.val()-livernum)) {
							content += '<td align="right"><span>入住人姓名：</span></td>' ;
							content += '<td  align="left">&nbsp;<input  name="h_guest_edit"  type="text" /></td>' ;
						} else {
							content += '<td align="right">&nbsp;</td>' ;
							content += '<td  align="left">&nbsp;</td>' ;
						}
						i ++ ;
						if(i<($this.val()-livernum)) {
							content += '<td align="right"><span>入住人姓名：</span></td>' ;
							content += '<td  align="left">&nbsp;<input  name="h_guest_edit"  type="text" /></td>' ;
						} else {
							content += '<td align="right">&nbsp;</td>' ;
							content += '<td align="left">&nbsp;</td>' ;
						}
						i ++ ;
						content += "</tr>" ;
						$('#liverNameTr').before(content) ; 
					}
				}
				livernum = parseInt($this.val()) ;
			}
		});
	}) ;
	
</script>
</html>


