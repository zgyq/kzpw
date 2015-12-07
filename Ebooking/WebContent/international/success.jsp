<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票订单成功</title>
<ww:head name="air" jsURL="citycontrol" />
<script>
$(document).ready(function(){
	$(".goDown").anchorGoWhere({target:1});
});
	
</script>
</head>
<body>
<ww:i18n name="'language'">
	<div id="container"><ww:include page="../top.jsp?index=1&subindex=2" />
	<!--includ top 直接替换掉整个DIV--></div>
	<!--top over-->
	<div id="main" style="margin-top: 51px;">
  <div id="left" class="f">
      <div class="ad"><img src="images/ad_ticket_ok_01.jpg" width="260" height="100" /></div>
      <div class="titlenew mt7"><font class="black">相关信息</font></div>
      <div class="box content">
         <ul>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         <li><a href="#">华夏中转有约吉祥航空</a></li>
         <li><a href="#">开通上海虹桥至海口航班海南航空新</a></li>
         <li><a href="#">开通上海-乌鲁木齐-库尔勒定期航班</a></li>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         <li><a href="#">华夏中转有约吉祥航空</a></li>
         <li><a href="#">开通上海虹桥至海口航班海南航空新</a></li>
         <li><a href="#">开通上海-乌鲁木齐-库尔勒定期航班</a></li>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         </ul>      
      </div>
  </div>
  <!--left over-->
  <div id="order" class="r">
       <div class="guild">
           <ul>
           <li class="current f"></li>
           <li class="f font20">订单预订完成</li>
           <li class="r statusorder">&nbsp;</li>
           <li class="c"></li>
           </ul>
       </div>
       
        <div class="mt7 box">
            <div class="title">
                   <font class="black low f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">恭喜您成功提交订单，您的订单号是：</font><a href="login!toTicktOrderInfo.jspx?OrderinfoId=<ww:property value="orderinfo.id" />"><font class="font1805a"><ww:property value="orderinfo.ordernumber" /></font></a></li>
                <li>我们将会尽快处理您的订单，座位预订成功后，我们会尽快与您联系。</li> 
                 <li></li>
               </ul>
            </div>
        </div>

        <div class="allmorny f00">订单总价：<font class="font18f60">&yen;<ww:property value="formatMoneyToInt(orderinfo.totalticketprice)" /></font></div>
       <div class="msg mt7">
        
          <ul class="msgul">
          <li class="over box_over">
          <b>航班信息</b>&nbsp;&nbsp;&nbsp;<ww:property value="getInterAirCityNamebySZM(fcity)"/>→ <ww:property value="getInterAirCityNamebySZM(acity)"/>&nbsp;&nbsp;&nbsp;出发日期：<ww:property value="fdate" />
          <span class="mlr15">
          <li>
            <ww:iterator value="listSegmentinfo" status="index">
              <ul class="range">
                <li class="f airport">
                <dt> <ww:property
					value="getAirPortNamebyCode(startairport)" /></dt>
                <dt> <ww:property
					value="getAirPortNamebyCode(endairport)" /></dt>
                
                </li>
                 <li class="f airport">
                 <dt><ww:property value="formatTimestampHHmm2(departtime)" /></dt>
                 <dt><ww:property value="formatTimestampHHmm2(arrivaltime)" /></dt>
                 </li>
                  <li class="f model">
                  <dt><ww:property value="AirCompanyNamebyCode(aircomapnycode)" /></dt>
                  <dt><ww:property value="flightnumber" /></dt>
				
                </li>
                
                <li class="f fuel"></li>

              </ul>
               </ww:iterator>
          </li>
          </ul>
         
          <!--乘机人信息-->
         <ww:iterator value="listpassenger" status="index">
          <ul class="msgul lh34">
           <li class="f mlr15">姓  名：<ww:property value="name" /></li>
           <li class="f mlr15">旅客类型：<ww:property value="getPassengerTypeToString(ptype)" /></li>
           <li class="f mlr15">证件类型：<span class="mlr15"><ww:property value="getIDTypeToString(idtype)" /></span><ww:property value="idnumber" /></li>
           
           <li class="c"></li>
          </ul>
          </ww:iterator>
          <ul class="msgul lh34">
           <li class="f mlr15">联系人：<ww:property value="orderinfo.contactname" /></li>
           <li class="f mlr15">手机号：<ww:property value="orderinfo.contactmobile" /></li>
           <li class="f mlr15">备&nbsp;注：<ww:property value="orderinfo.memo" /></li>
           <li class="c"></li>
          </ul>
       </div>
     
     
      
      <!----------联系人信息------------>  
   </div>
  <!--right over-->
</div> 
	<!--container over-->

	<ww:include page="../footer.jsp" />

</ww:i18n>
</body>

</html>
