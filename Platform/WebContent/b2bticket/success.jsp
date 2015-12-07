<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/hotel.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link rel="stylesheet" href="js/jqueryUI/jquery.ui.all.css" type="text/css">
<link href="style/font.css" type="text/css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>

<script language="javascript"> 
function copyToClipboard(theField,isalert)
{
  if(theField!="")
  {
    var clipBoardContent=theField;
    //obj.select();
    window.clipboardData.setData("Text",clipBoardContent); 
    if(isalert!=false)
      alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
  }
  else
  {
     alert("Error!");
  }
}
 //如果订单生成后与原返点不一致，则弹出提示
 function showmessage(oldzratevalue,newzratevalue,oldprice)
 {    
      var newprice=$("#txttotalprice").val();
      if((newzratevalue!="0" || newprice!="0")  && (oldzratevalue!=newzratevalue ||oldprice!=newprice))
      {
      var tablehtml="";
      tablehtml='<table border="0" width="100%">';
      //价格是否发生变化
      var flag=0;
      if(newprice!="0" && oldprice!=newprice)
      {
         tablehtml+='<tr><td><b>'+'&nbsp;&nbsp;&nbsp;您的订单最终价格为：';
	     tablehtml+='<font color="red">'+newprice+'元</font></b></td></tr>';
	     tablehtml+='<tr><td>&nbsp;&nbsp;&nbsp;';
	     tablehtml+='<font color="red">机票价格以PAT价格为准！</font></td></tr>';
	     flag=1;
      }
      //政策是否发生变化
	  if(oldzratevalue!=newzratevalue && newzratevalue!="0")
	    {  
	       tablehtml+='<tr><td><b>'+'&nbsp;&nbsp;&nbsp;您的订单最终返点为：';
	       tablehtml+='<font color="red">'+newzratevalue+'%</font></b></td></tr>';
	       tablehtml+='<tr><td>&nbsp;&nbsp;&nbsp;';
	       tablehtml+='<font color="red">机票政策实时变化，订单返点以最终生成返点为准！</font></td></tr>';
	       flag=1;
	    }
       tablehtml+='<tr><td>&nbsp;</td></tr>';
       tablehtml+='<tr><td align="center">';
       tablehtml+='<input class="button_d font-bai" type="button" value="确定并返回" onclick="$.unblockUI(); " /></td>';
       tablehtml+='</tr><tr><td>&nbsp;</td></tr></table>';
       if(flag==1)
       {
       $.blockUI({ 
            theme:  true, 
            fadeIn: 1000, 
            showOverlay: false,
            title:    '订单提醒', 
            message:  tablehtml, 
            centerY: false
             
        });
        } 
      } 
 }
</script>
</head>
<body onload="showmessage(<ww:property value="s_oldzratevalue" />,<ww:property value="s_bestzratevalue" />,<ww:property value="s_oldorderprice" />);">
<div>
<div>

<div>

<div class="box" style="text-align: center; line-height: 22px;">
<ww:if test="#request.nextpay==null">
<ul>
	<li>
	
	<ww:if test="orderinfo.orderstatus!=27">
	<img src="images/dui.gif" width="51" height="43" /><b>您的预订已成功!</b><br />请您及时付款，以免耽误您的行程!
	</ww:if>
	<ww:else>
	<br />
	<span style="font-size:15px;color:red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<img src="images/flight_icon.gif" /><b>您已经成功创建订单信息，此订单需要平台进行确认。请等待平台确认订单后，继续支付订单！</b>
	</span>
	<br />
	<br />
	</ww:else> 
	</li>
</ul>
</ww:if>
</div>
<ww:set name="tatalorderprice" value="0"/>
<div class="huang">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:15px;color:#fff">◆</span><b class="bai_c">订单信息-订单号：<ww:property
	value="getorderbyid(idtemp).ordernumber" />&nbsp;&nbsp;<ww:if
	test="orderinfo.id!=idtemp">
	<ww:property value="orderinfo.ordernumber" />
</ww:if></b></div>
<div
	style="font-size: 18px; font-weight: bold; color: #ff0000; text-align: left;"><ww:if
	test="listSegment.get(0).traveltype!=1">
	<img src="images/fancheng.png" align="absmiddle" />&nbsp;
    <ww:if	test="listSegment.get(0).traveltype==2">去程</ww:if>
	<ww:if	test="listSegment.get(0).traveltype==3">第一行程</ww:if>
     订单信息：<ww:property
		value="getCitynameByAirport(listSegment.get(0).startairport)" />→&nbsp;<ww:property
		value="getCitynameByAirport(listSegment.get(0).endairport)" />&nbsp;出发日期：<ww:property
		value="formatTimestampyyyyMMdd(listSegment.get(0).departtime)" />
</ww:if></div>
	<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">航班号</td>
			<td>航空公司</td>
			<td>舱位</td>
			<td>折扣</td>
			<td>起飞机场</td>
			<td>到达机场</td>
			<td>起飞时间</td>
			<td>到达时间</td>
		</tr>
	</tbody>
	<ww:iterator value="listSegment" status="t">
		<tr>
			<td ><ww:property value="flightnumber" /></td>
			<td><ww:property value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
			<td><ww:property value="cabincode" /></td>
			<td><ww:property value="discount" /></td>
			<td><ww:property value="getAirportbySZM(startairport)" /></td>
			<td><ww:property value="getAirportbySZM(endairport)" /></td>
			<td><ww:property value="formatTimestamp(departtime)" /></td>
			<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
		</tr>
	</ww:iterator>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>

			<td width="100">订单号</td>
			<td>PNR</td>
			<td>大PNR</td>
			<td width="90">总票面结算价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
			<td width="60">总保险费</td>
			<td width="100">订单总额</td>
		</tr>
	</tbody>
	<tr>
		<td><ww:property value="orderinfo.ordernumber" /></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo.pnr"/>',true);"><ww:property
			value="orderinfo.pnr" /></a></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo.bigpnr"/>',true);"><ww:property
			value="orderinfo.bigpnr" /></a></td>
		<td><ww:property value="formatMoney(orderinfo.totalticketprice)" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalairportfee)" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalinsurprice)" /></td><!-- formatMoney(converNull(getIssurByOrderid(orderinfo.id))) -->

		<td style="color:red;font-weight:bold">￥<ww:property
			value="formatMoney(orderinfo.orderprice)" />
			<ww:set name="tatalorderprice" value="#tatalorderprice+orderinfo.orderprice"/>
			</td>
	</tr>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
			bordercolor="#86B2D1"
			style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
			<tbody bgcolor="#DDECF3" style="color: #999;">
				<tr>
					<td width="100">姓名</td>
					<td width="90">乘机人类型</td>
					<td>证件号/出生日期</td>
					<td width="90">票面结算价</td>
					<td width="60">燃油费</td>
					<td width="60">机建费</td>

					<td width="60">保险费</td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listPassenger" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /><ww:property value="birthday" /></td>
					<td><ww:property value="formatMoney(converNull(price,0))" /></td>
					<td><ww:property value="formatMoney(converNull(fuelprice,0))" /></td>
					<td><ww:property value="formatMoney(converNull(airportfee,0))" /></td>
					<td><ww:property value="formatMoney(insurprice)" /></td>					

					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>

<div
		style="font-size: 18px; font-weight: bold; color: #0000ff; text-align: left">
		<ww:if
	test="listSegment2.get(0).traveltype!=1">
		<img
		src="images/qucheng.png" align="absmiddle" />&nbsp; 
        <ww:if	test="listSegment2.get(0).traveltype==2">返程</ww:if>
        <ww:if	test="listSegment2.get(0).traveltype==3">第二行程</ww:if>
         订单信息： <ww:property
		value="getCitynameByAirport(listSegment2.get(0).startairport)" /> &nbsp;→&nbsp; <ww:property
		value="getCitynameByAirport(listSegment2.get(0).endairport)" />&nbsp; 出发日期：<ww:property
		value="formatTimestampyyyyMMdd(listSegment2.get(0).departtime)" />
		</ww:if>
		</div>
<div class="box" style="padding-top: 10px;">
<ww:if test="orderinfo2!=null&&orderinfo2.id>0">
<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">航班号</td>
			<td>航空公司</td>
			<td>舱位</td>
			<td>折扣</td>
			<td>起飞机场</td>
			<td>到达机场</td>
			<td>起飞时间</td>
			<td>到达时间</td>
		</tr>
	</tbody>
	<ww:iterator value="listSegment2" status="t">
		<tr>
			<td><ww:property value="flightnumber" /></td>
			<td><ww:property value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
			<td><ww:property value="cabincode" /></td>
			<td><ww:property value="discount" /></td>
			<td><ww:property value="getAirportbySZM(startairport)" /></td>
			<td><ww:property value="getAirportbySZM(endairport)" /></td>
			<td><ww:property value="formatTimestamp(departtime)" /></td>
			<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
		</tr>
	</ww:iterator>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">订单号</td>
			<td>PNR</td>
			<td>大PNR</td>

			<td width="90">总票面结算价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
			<td width="60">总保险费</td>
			<td width="100">订单总额</td>
		</tr>
	</tbody>
	<tr>
		<td><ww:property value="orderinfo2.ordernumber" /></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo2.pnr"/>',true);"><ww:property
			value="orderinfo2.pnr" /></a></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo2.bigpnr"/>',true);"><ww:property
			value="orderinfo2.bigpnr" /></a></td>
		
		<td><ww:property value="formatMoney(orderinfo2.totalticketprice)" /></td>
		<td><ww:property value="orderinfo2.totalfuelfee" /></td>
		<td><ww:property value="orderinfo2.totalairportfee" /></td>
		<td><ww:property value="formatMoney(orderinfo2.totalinsurprice)" /></td>

		<td style="color:red;font-weight:bold">￥<ww:property
			value="formatMoney(orderinfo2.orderprice)" />
			<ww:set name="tatalorderprice" value="#tatalorderprice+orderinfo2.orderprice"/>
			</td>
	</tr>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
			bordercolor="#86B2D1"
			style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
			<tbody bgcolor="#DDECF3" style="color: #999;">
				<tr>
					<td width="100">姓名</td>
					<td width="90">乘机人类型</td>
					<td>证件号/出生日期</td>
					<td width="90">票面结算价</td>
					
					<td width="60">燃油费</td>
					<td width="60">机建费</td>
					
					<td width="60">保险费</td>
					
					
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listPassenger2" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /><ww:property value="birthday" /></td>
					<td><ww:property value="formatMoney(converNull(price,0))" /></td>
					<td><ww:property value="formatMoney(converNull(fuelprice,0))" /></td>
					<td><ww:property value="formatMoney(insurprice)" /></td>
					
					<td><ww:property	value="formatMoney(insuranceinfo.insurancefee)" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>
</ww:if>
<div style="height: 10px;"></div>



<table width="90%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#b3b3b3"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 10px; text-align: center;">
	<tbody bgcolor="#f0f0f0" class="hong_c">
	<tr>
		<td style="font-size: 18px;color:red;  font-weight:bold" align="right">订单返点：<ww:property value="orderinfo.fenxiaoshangfandian"/>%  平台支付费：<ww:property value="orderinfo.currplatfee"/>&nbsp;&nbsp;
		行程单+配送费：<ww:property value="converNull(orderinfo.postmoney,0)"/>&nbsp;&nbsp;
		应付金额：
		<ww:property value="formatMoney(#tatalorderprice+converNull(orderinfo.currplatfee,0)+converNull(orderinfo.postmoney,0))"/>
		元&nbsp;&nbsp;<input type="hidden" id="txttotalprice" value="<ww:property value="#tatalorderprice+converNull(orderinfo.currplatfee,0)+converNull(orderinfo.postmoney,0)"/>" /></td>
	</tr>
	</tbody>
</table>
<ww:include page="../pay_50.jsp"/>

<!-- 分销商支付 -->

</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>