<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票列表页面</title>
<ww:head name="air" jsURL="citycontrol" />
</head>
<body>
<ww:i18n name="'language'">
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?type=ticket" />
		<div style=" position:absolute; top:73px; left:150px;">当前位置 ： 首页 > 国内机票</div>
	</div>  
	<!--top over-->
	<div id="main">
  <div id="left" class="f">
      <div class="ad"><img src="../images/ad_sea.jpg" width="260" height="100" /></div>
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
           <li class="f font20">订单预订失败，请重试！</li>
           <li class="r statusorder">&nbsp;</li>
           <li class="c"></li>
           </ul>
       </div>
       <form action="check.html" method="get"> 
        <div class="mt7 box">
            <div class="title">
                   <font class="black low f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">恭喜您成功提交订单，您的订单号是：</font><font class="font1805a"> A314123413</font><input type="submit" class="bnt_paid fff mlr15" value="立即支付"  /> </li>
                <li>您选择的是<font class="f00">暂不出票</font>，航空公司有权取消未出票的预订，因此建议您决定出票后立刻上网支付或<br/> 电话联系客服，以免价格发生变化。 </li>
                <li></li>
               </ul>
            </div>
        </div>
        <div class="mt7 box">
            <div class="title">
                   <font class="black low f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">恭喜您成功提交订单，您的订单号是：</font><font class="font1805a"> A314123413</font> </li>
                <li>您选择的是<font class="f00">立即出票</font>，您已成功支付了此订单，我们会在10分钟内为您出票并进行出票通知，<br/>如有 疑问请拨打服务热线：010-6817 </li>
                <li></li>
               </ul>
            </div>
        </div>
        <div class="mt7 box">
            <div class="title">
                   <font class="black low f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">恭喜您成功提交订单，您的订单号是：</font><font class="font1805a"> A314123413</font><input type="submit" class="bnt_paid fff mlr15" value="立即支付"  /> </li>
                <li>您选择的是<font class="f00">立即出票</font>，在支付时出行问题，为保证正常出票请您在30分钟内完成支付。 <br/>如有疑问请拨打服务热线：010-68176515</li>
                <li></li>
               </ul>
            </div>
        </div>
        </form>
        <div class="allmorny f00">订单总价：<font class="font18f60">&yen;2040</font>（1成人&times;1000+1儿童&times;1000+2保险&times;20）</div>
       <div class="msg mt7">
          <ul class="msgul">
          <li class="over box_over"><b>已选择的去程航班</b><span class="mlr15">北京 → 上海</span>出发日期：2011-11-27</li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">&yen;1000</font><span class="mlr">特价经济舱</span></li>
                <li class="f airport">
                  <dt>09：00 北京首都机场</dt>
                  <dt>12：00 上海白云机场</dt>
                </li>
                <li class="f airlines airlines_mu"></li>
                <li class="f model">
                  <dt>东航MU5138</dt>
                  <dt>空客<a href="#" class="fontun06c">A333</a>(大)</dt>
                </li>
                <li class="f fuel">70/90</li>
                <li class="f meal"><a href="#" class="fontun06c">退改签规则</a>
                <div class="float msg_l" style="display:none">
                   <ul class="msgul_l">
                   <li class="over box_over_l">退改签规则</li>
                   <li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
                   <li class="pf5"><b>退票条件：</b></li>
                   <li class="pf5"><b>签转条件：</b></li>
                   </ul>
                </div>
                </li>
                <li class="f btn">&nbsp;</li>
              </ul>
          </li>
          </ul>
       <!--往返订单第一程信息-->
          <ul class="msgul">
          <li class="over box_over"><b>已选择的返程航班</b><span class="mlr15">上海 → 北京</span>出发日期：2011-11-27</li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">&yen;1000</font><span class="mlr">特价经济舱</span></li>
                <li class="f airport">
                  <dt>09：00 北京首都机场</dt>
                  <dt>12：00 上海白云机场</dt>
                </li>
                <li class="f airlines airlines_mu"></li>
                <li class="f model">
                  <dt>东航MU5138</dt>
                  <dt>空客<a href="#" class="fontun06c">A333</a>(大)</dt>
                </li>
                <li class="f fuel">70/90</li>
                <li class="f meal"><a href="#" class="fontun06c">退改签规则</a>
                <div class="float msg_l" style="display:none">
                   <ul class="msgul_l">
                   <li class="over box_over_l">退改签规则</li>
                   <li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
                   <li class="pf5"><b>退票条件：</b></li>
                   <li class="pf5"><b>签转条件：</b></li>
                   </ul>
                </div>
                </li>
                <li class="f btn">&nbsp;</li>
              </ul>
          </li>
          </ul>
          <ul class="msgul lh34">
           <li class="f mlr15">姓  名：张三</li>
           <li class="f mlr15">旅客类型：成人</li>
           <li class="f mlr15">证件类型：<span class="mlr15">身份证</span>210381198401124515</li>
           <li class="f mlr15">保险：<span class="mlr15">1份</span>￥20/份</li>
           <li class="c"></li>
          </ul>
          <ul class="msgul lh34">
           <li class="f mlr15">姓  名：张三</li>
           <li class="f mlr15">旅客类型：成人</li>
           <li class="f mlr15">证件类型：<span class="mlr15">身份证</span>210381198401124515</li>
           <li class="f mlr15">保险：<span class="mlr15">1份</span>￥20/份</li>
           <li class="c"></li>
          </ul>
          <ul class="msgul lh34">
           <li class="f mlr15">姓  名：张三</li>
           <li class="f mlr15">旅客类型：成人</li>
           <li class="f mlr15">证件类型：<span class="mlr15">身份证</span>210381198401124515</li>
           <li class="f mlr15">保险：<span class="mlr15">1份</span>￥20/份</li>
           <li class="c"></li>
          </ul>
          <ul class="msgul lh34">
           <li class="f mlr15">联系人：张三</li>
           <li class="f mlr15">手机号：13521463333</li>
           <li class="f mlr15">邮箱：24515@163.com</li>
           <li class="f mlr15">确认方式：短信确认</li>
           <li class="c"></li>
          </ul>
       </div>
       <!--往返订单第二程信息-->
       
      
      <!----------联系人信息------------>   
   </div>
  <!--right over-->
</div> 
	<!--container over-->

	<ww:include page="../footer.jsp" />

</ww:i18n>
</body>

</html>
