<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}酒店预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel">
     
 <div id="list" style="width:80%; margin:0 auto;">

    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">订单提交完成</font>
       <span class="r status_five">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="c"></div>
    <div class="mt7 box" style=" display:inline-block; width:100%;">
     <div class="tit"><span class="low2 black f">订单信息：</span></div>
     <div class="tsico"></div>
     <div class="order">
           <ul>
                <li><font class="black">您的订单号是：</font><font class="font1805a"><a href="login!toHotelOrderInfo.jspx?HotelOrderID=<ww:property value="hotelorder.id" />"><ww:property value="hotelorder.orderid" /></a></font><font class="black">订单已提交，正在为您处理...</font></li>
                <li class="c999" style="display: none"><ww:property value="hotelorder.linkname" /> 先生/女士，请您在离店后60天内登录${compname}商旅网点评入住酒店后（超过60天视为放弃），我们将返还<font class="f00">90 元</font>至您的${compname}商旅网账户。</li>
                <li class="c999">我们将在20分钟内尽快确认您的预定，如有其他疑问，请咨询客服热线：${tel}。</li>
                
           </ul>
     </div>
    </div>
    <div class="msg mt7" style=" clear:both;">
          <ul class="msgul">
          <li class="over box_over">订单号：<font class="f00"><ww:property value="hotelorder.orderid" /></font>　　订单状态：<font class="f00"> 新订单</font></li>
          <li class="over information" style="margin-top:10px;">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="over">
                  <tr>
                    <td width="90" class="hadow" align="right">酒店名称：</td>
                    <td width="260"><ww:property value="hotelorder.name" /></td>
                    <td width="90" class="hadow" align="right">入住日期：</td>
                    <td><ww:property value="formatDate(hotelorder.comedate)" /></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">客房类型：</td>
                    <td><ww:property value="hotelorder.roomtypename" /></td>
                    <td class="hadow" align="right">离店日期：</td>
                    <td><ww:property value="formatDate(hotelorder.leavedate)" /></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">房间数量：</td>
                    <td><ww:property value="hotelorder.prerooms"/></td>
                    <td class="hadow" align="right">到店时间：</td>
                    <td><ww:property value="hotelorder.reservstart"/>-<ww:property value="hotelorder.reservend"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">费用总计：</td>
                    <td><font class="font-f60-16">&yen;<ww:property value="hotelorder.price" /></font></td>
                    <td class="hadow" align="right">&nbsp;</td>
                    <td class="pr0" ><font class="f90">&nbsp;</font>　</td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">酒店地址：</td>
                    <td colspan="3"><ww:property value="hotel.address" /><span class="ico_phone">&nbsp;</span><a href="#" class="l06c">发送到手机</a></td>
                  </tr>
                   <tr>
                    <td class="hadow" align="right">入住人：</td>
                    <td colspan="3">
                    <ww:iterator value="ListGuest">
                     <ww:property value="name" />,
                    </ww:iterator>
                   </td>
                  </tr>
                </table>
             <div class="nohave"></div>
          </li>
          </ul>
      </div>   
      <div class="order_bnt">
        <input type="button" class="mr25 booking_bntton fff" value="再订一间" onclick="GoWhy('hotel!toindex.jspx');" />
        <input type="button" class="mr25 booking_bntton fff" value="返回首页" onclick="GoWhy('ticticket!toTicket.jspx');" />
        <input type="button" class="mr25 booking_bntton fff" value="预定机票" onclick="GoWhy('ticticket!toTicket.jspx');" />
       </div> 
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
 </body>
</html>
<script type="text/javascript">
function GoWhy(url){
window.location.href=url;

}

</script>
