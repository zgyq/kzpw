<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印行程单</title>
<link type="text/css" rel="stylesheet" href="xxd/xcd.css">
</head>

<body>
<div id="bg">
	<div id="name1"><ww:property value="passenger.name" /></div>
    <div id="shenfenz"><ww:property value="passenger.idnumber" /></div>
    <div id="qianzhu"></div>
    <div id="HELTMV"><ww:property value="orderinfo.pnr" /></div>
    <div id="mdd">自From&nbsp;&nbsp;<ww:property value="getAirnamebySZM(segmentinfo.startairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.startairport" /><br>至To&nbsp; &nbsp;&nbsp;<ww:property value="getAirnamebySZM(segmentinfo.endairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.endairport" /><br>至To&nbsp;&nbsp;&nbsp; VOID</div>
    <div id="yunchengren"><ww:property value="segmentinfo.aircomapnycode" /></div>
    <div id="hangbanhao"><ww:property value="segmentinfo.flightnumber" /><br>VOID</div>
    <div id="dengji"><ww:property value="segmentinfo.cabincode" /></div>
    <div id="date1"><ww:property value="formatDate(segmentinfo.departtime)" /></div>
    <div id="time"><ww:property value="formatTimestamp3(segmentinfo.departtime)" /></div>
    <div id="kepiao"></div>
    <div id="jiezhirq"></div>
    <div id="xingli">20K</div>
    <div id="piaohao"><ww:property value="passenger.ticketnum" /></div>
    <div id="piaojia">CNY&nbsp;<ww:if test="passenger.ptype==1"><ww:property value="segmentinfo.parvalue" /></ww:if><ww:else><ww:property value="passenger.price" /></ww:else></div>
    <div id="jianshef">CNY&nbsp;<ww:property value="passenger.airportfee" /></div>
    <div id="ranyf">CNY&nbsp;<ww:property value="passenger.fuelprice" /></div>
    <div id="heji">CNY&nbsp;<ww:if test="passenger.ptype==1"><ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+segmentinfo.parvalue+converNull(passenger.insurprice,0))" /></ww:if><ww:else><ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+passenger.price+converNull(passenger.insurprice,0))" /></ww:else></div>
    <div id="danwei">世纪巨人网络科技（北京）有限公司</div>
    <div id="date22"><ww:property value=" startDate" /></div>
    <div id="mingcheng">世纪巨人网络科技（北京）有限公司</div>
</div>
<div style="width:100px;margin:20px auto 0;height:30px;"><input type="button" class="button6" value="打印行程单" onclick="window.print()"></div>


</body></html>