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
<title>酒店订单详细信息</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
.STYLE3 {color: #000000}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<script language="javascript">
	function hotel_cannel_info() {
		window.history.back();
	}
</script>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店订单详细信息</span></td>
  </tr>
  <tr>
    <td height="100%" align="center">
    <br/>
    <table width="90%" cellpadding="0" cellspacing="0" border="1" bordercolor="#a0cfee" style="border-collapse:collapse">
	 <tr class="font-blue-xi">
	     <td width="15%" height="28" align="right"><span class="STYLE2"><strong>酒店名称</strong>：</span></td>
	     <td width="35%"><ww:property value="hotelorder.name"/></td>
	     <td width="15%" height="28" align="right"><span class="STYLE2"><strong>保留时间</strong>：</span></td>
	     <td width="35%"><ww:property value="getBaoliuTime(hotelorder.reservstart,hotelorder.reservend)"/></td>
	 </tr>
	
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>预订间数</strong>：</span></td>
	     <td><ww:property value="hotelorder.prerooms"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>入住人</strong>：</span></td>
	     <td><ww:iterator value="getGuestByOrderId(hotelorder.id)" status="guessStatus"><ww:property value="name"/><ww:if test="!#guessStatus.last">，</ww:if></ww:iterator></td>
	 </tr>	 
	 
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>入住日期</strong>：</span></td>
	     <td><ww:property value="formatDate(hotelorder.comedate)"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>离店日期</strong>：</span></td>
	     <td><ww:property value="formatDate(hotelorder.leavedate)"/></td>
	 </tr>	 
	 
	 <tr >
	     <td height="28" align="right" class="font-blue-xi"><span class="STYLE2"><strong>联系人姓名</strong>：</span></td>
	     <td><ww:property value="hotelorder.linkname"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>联系人手机</strong>：</span></td>
	     <td><ww:property value="hotelorder.linkmobile"/></td>
	 </tr>	 
	 
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>联系人Email</strong>：</span></td>
	     <td><ww:property value="hotelorder.linkmail"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>联系人电话</strong>：</span></td>
	     <td><ww:property value="hotelorder.linktell"/></td>
	 </tr>	 
	 
	 <tr class="font-blue-xi">
	  	 <td height="28" align="right"><span class="STYLE2"><strong>预订时间</strong>：</span></td>
	     <td><ww:property value="formatTimestamp(hotelorder.pretime)"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>酒店电话</strong>：</span></td>
	     <td><ww:property value="hotel.tortell"/></td>
	 </tr>	 
	 
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>酒店地址</strong>：</span></td>
	     <td><ww:property value="hotel.address"/></td>
	     <td height="28" align="right"><span class="STYLE2"><strong>酒店传真</strong>：</span></td>
	     <td><ww:property value="hotel.faxdesc"/></td>
	 </tr>	 
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>预订备注</strong>：</span></td>
	     <td colspan="3"><ww:property value="hotelorder.predesc"/></td>
	 </tr>	 
	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>特殊要求</strong>：</span></td>
	     <td colspan="3"><ww:property value="hotelorder.specreq"/></td>
	 </tr>	 
 	 <tr>
 	 	<td colspan="4">
 	 		<table width="100%" border="1" bordercolor="#a0cfee" style="border-collapse:collapse">
 	 			<tr>
 	 				<th width="20%" align="center">房型</th>
 	 				<th width="60%" align="center">协议价</th>
 	 				<th width="20%" align="center">床型</th>
 	 			</tr>
 	 			<tr>
 	 				<td align="center"><ww:property value="hotelorder.roomtypename"/></td>
 	 				<td align="center"><table width="100%">
 	 						<tr>
 	 								<th>星期日</th>
 	 								<th>星期一</th>
 	 								<th>星期二</th>
 	 								<th>星期三</th>
 	 								<th>星期四</th>
 	 								<th>星期五</th>
 	 								<th>星期六</th>
 	 						</tr>
 	 						<tr>
 	 						<ww:iterator value="getPrices(hotelorder.price,hotelorder.comedate)" status="priceStatus">
 	 							<ww:if test="#priceStatus.index % 7 == 0">
 	 								</tr>
 	 								<tr>
 	 							</ww:if>
 	 								<td><ww:property /><ww:property value="priceStatus"/></td>
 	 						</ww:iterator>
 	 						</tr>
 	 					</table>
 	 				</td>
 	 				<td align="center"><ww:if test="getRoomtypeById(hotelorder.roomid).bed == 1">单人床</ww:if>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 2">大床</ww:elseif>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 3">双床</ww:elseif>
 	 							<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 4">大或双</ww:elseif>
 	 							<ww:else>其他</ww:else></td>
 	 			</tr>
 	 		</table>
 	 	</td>
 	 </tr>
   
   	 <tr  class="font-blue-xi">
   	 	<td align="right" height="28"><strong>总计金额</strong>：</td>
   	 	<td><ww:property value="hotelorder.price"/></td>
   	 	<td align="right"><strong>付款方式</strong>：</td>
   	 	<td>前台现付</td>
   	 </tr>
   	 
   	 <tr  class="font-blue-xi">
   	 	<td align="right"  height="28"><strong>确认方式</strong>：</td>
   	 	<td colspan="3"><ww:if test="hotelorder.confirmmethod == 1">短信确认</ww:if>
   	 	  <ww:elseif test="hotelorder.confirmmethod == 2">电子邮件确认</ww:elseif>
   	 	  <ww:elseif test="hotelorder.confirmmethod == 3">短信和电子邮件确认</ww:elseif>
	 	</td>
   	 </tr>
   	 <tr class="font-blue-xi">
	     <td height="28" align="right"><span class="STYLE2"><strong>操作记录</strong>：</span></td>
	     <td colspan="3" align="left" >
	     	<ww:iterator value="listHotelorderrc" status="listHotelorderrcStatus">
	     			&nbsp;&nbsp;<ww:property value="#listHotelorderrcStatus.index + 1"/>.&nbsp;&nbsp;<ww:property value="handleuser"/>在<ww:property value="formatTimestamp(createtime)"/><ww:property value="content"/><br/>
	     	</ww:iterator>
	     </td>
	 </tr>	
   	   <tr style="display:none" id="cancelreasonTr">
      	<td align="center" colspan="4">
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	 	<input type="radio" name="canclereason" value="1"/>客人取消
   	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	 	<input type="radio" name="canclereason" value="2"/>酒店取消
      	</td>
      </tr>
      <tr class="font-blue-xi">
        <td height="46" colspan="4" scrolling="no">
        	<input type="button" class="button_d font-white" onclick="hotel_cannel_info()"  name="Submit2" value=" 返回 " /> </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

