<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}酒店订单详细信息</title>

<link href="skin/blue/css/login.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/airlines.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
		
	</div>  
<!----------header over---------->
<div id="member">
      <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单详情</li>
            <li class="mation_info"><font class="mation_left f"><b>订单号：<font class="fontxing"><ww:property value="hotelorder.orderid"/></font></b></font><span class="f mr25">预订时间：（<font class="fontxing"><ww:property
			value="formatDate(hotelorder.pretime)" /> </font>）</span> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div>  
       <div class="mt7 box">
        <div class="title">
               <font class="black low f mr15">订单详细信息</font>
               <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div class="nohave">&nbsp;</div>
         <div class="msg mt7">
          <ul class="msgul">
          <li class="over box_over">订单号： <ww:property value="hotelorder.orderid"/> 订单状态：<font class="f00"> <ww:if test="hotelorder.state==12">支付完成</ww:if>
				<ww:elseif test="hotelorder.state==9">入住</ww:elseif>
				<ww:elseif test="hotelorder.state==10">NS</ww:elseif>
		     	 <ww:elseif test="hotelorder.state==6">取消</ww:elseif>
		     	 <ww:elseif test="hotelorder.state==18">待支付</ww:elseif>
		     	 <ww:elseif test="hotelorder.state==5">预订完成</ww:elseif>
		     	 <ww:else>待确认</ww:else></font></li>
          <li class="over information" style="margin-top:10px;">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="over">
                  <tr>
                    <td width="90" class="hadow" align="right">酒店名称：</td>
                    <td width="260"><ww:property value="hotelorder.name"/></td>
                    <td width="90" class="hadow" align="right">入住日期：</td>
                    <td><ww:property value="formatDate(hotelorder.comedate)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">客房类型：</td>
                    <td><ww:property value="hotelorder.roomtypename"/></td>
                    <td class="hadow" align="right">离店日期：</td>
                    <td><ww:property value="formatDate(hotelorder.leavedate)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">房间数量：</td>
                    <td><ww:property value="hotelorder.prerooms" /></td>
                    <td class="hadow" align="right">到店时间：</td>
                    <td>18:00之前</td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">费用总计：</td>
                    <td><font class="font-f60-16">&yen;<ww:property value="hotelorder.price" /></font></td>
                    <td class="hadow" align="right">点评奖金：</td>
                    <td class="pr0" ><font class="f00">&yen;160</font>(入住后点评即可获得。)</td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">酒店地址：</td>
                    <td colspan="3">酒店地址：<ww:property value="GetHotelAddreesByHotelID(hotelorder.hotelid)" /><span class="ico_phone">&nbsp;</span><a href="#" class="l06c">发送到手机</a></td>
                  </tr>
                   <tr>
                    <td class="hadow" align="right">入住人：</td>
                    <td colspan="3"><ww:iterator value="ListGuest" status="t">
				 <ww:property value="name"/>
				 <ww:if test="#t.last"></ww:if><ww:else>
				 ,
				 </ww:else>
				 
				 </ww:iterator></td>
                  </tr>
                </table>
             <div class="nohave"></div>
          </li>
          </ul>
      </div>  
          <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>联系人信息</b></li>
           <li class="f mlr15 lh34">联系人：<ww:property value="hotelorder.linkname" /></li>
           <li class="f mlr15 lh34">手机号：<ww:property value="hotelorder.linkmobile" /></li>
           <li class="f mlr15 lh34">邮箱：<ww:property value="hotelorder.linkmail" /></li>
           <li class="f mlr15 lh34">保留时间：18:00 至 06:00期间</li>
           <li class="c"></li>
          </ul>
       </div>
          <div class="msg mt7">
           <ul class="msgul">
              <li class="allmornydetail l06c"><span class="allmorny"></span>订单总价：<font class="font18f60">&yen;<ww:property value="hotelorder.price" /></font>（<ww:property value="hotelorder.manyday" />间夜&times;<ww:property value="hotelorder.orderpeaple" />人&times;<ww:property value="hotelorder.price/hotelorder.orderpeaple/hotelorder.manyday" />元）</li>
           </ul>
           </div>
            <div class="bntt">
            <input type="button" class="button_cancel fff mlr" value="取消订单"  />
            <input type="button" class="button_cancel fff mlr" value="立即支付"  />
            <input type="button" class="button_cancel fff mlr" value="打印订单"  /> </div>
        </div>
       </div> 
       
   </div>
</div>
 <ww:include page="../footer.jsp"/> 
</body>
</html>
