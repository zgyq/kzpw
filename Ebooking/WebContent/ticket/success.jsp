<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票列表页面</title>
<ww:head name="air" jsURL="citycontrol" />
<script>
$(document).ready(function(){
	$(".goDown").anchorGoWhere({target:1});
});
 //显示机型信息说明
	  function showflightdesc(index)
	  {
	     var context=$("#hid_lowflightdesc_"+index).val();
		 if(context=="")
		 {
		    context="暂无机型信息说明！";
		 }
		 else if(context.indexOf('#')>0)
		 {
		    context=context.replace(",","，").replace("'","，").replace(":","：");
		    var arrflightdesc=context.split('#');
		    
		    if(arrflightdesc[1]=="")
		    {
			    var desc=context;
			    context='<table border="0"><tr>';
			    context+='<td><img src="images/NoImage.gif" width="65px" height="65px"  /></td>';
			    context+='<td>'+desc.replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		    else
		    {
		        context='<table border="0"><tr>';
			    context+='<td><img src="images/flighttype/'+arrflightdesc[1]+'" width="65px" height="65px"  /></td>';
			    context+='<td>'+arrflightdesc[0].replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		   
		 }
		 
		 //显示机型信息
		 $('#a_flightdesc_'+index).poshytip({
			content: context,
			showOn: 'none',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 $('#a_flightdesc_'+index).poshytip('show');
	  }
	  //显示退改签信息说明
	  function showrules(index,context)
	  {
		 if(context=="")
		 {
		    context="更改规则：暂无信息<br />退票规则：暂无信息<br />签转规则：暂无信息<br />";
		 }
		 $('#a_rules_'+index).poshytip({
			content: context,
			showOn: 'hover',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 
		 $('#a_rules_'+index).poshytip('show');
	  }
	  //隐藏退改签信息说明
	  function hiderules(index)
	  {
	      $('#a_rules_'+index).poshytip('hide');
	  }
	  //隐藏机型信息说明
	  function hideflightdesc(index)
	  {
	      $('#a_flightdesc_'+index).poshytip('hide');
	  }
</script>
</head>
<body>
<ww:i18n name="'language'">
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=1&subindex=1" />
	</div>  
	<!--top over-->
	<div id="main">
  <div id="left" class="f">
      <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
      	<font class="black" style=" padding-left:10px;">相关信息</font>
      </div>
      <div class="box content" style=" border-top:none;">
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
      <div class="ad mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div>
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
            <div class="tit">
                   <font class="black low2 f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">恭喜您成功提交订单，您的订单号是：</font><a href="login!toTicktOrderInfo.jspx?OrderinfoId=<ww:property value="orderinfo.id" />"><font class="font1805a"><ww:property value="orderinfo.ordernumber" /></font></a><a class="goDown" href="#maopointpay"><input type="button" class="bnt_paid fff mlr15" value="立即支付"  /></a> </li>
                <li>您选择的是<font class="f00"><ww:if test="orderinfo.fkmethod==1">立即出票</ww:if><ww:else>暂缓出票</ww:else></font>，航空公司有权取消未出票的预订，因此建议您决定出票后立刻上网支付或<br/> 电话联系客服，以免价格发生变化。 </li>
                <li></li>
               </ul>
            </div>
        </div>

        <div class="allmorny2 f00">订单总价：<font class="font18f60">&yen;<ww:property value="formatMoneyToInt(orderinfo.orderprice)" /></font>（<ww:property value="orderpricedtail" />）</div>
       <div class="msg mt7">
          <ww:iterator value="listsegmentinfo" status="index">
          <ul class="msgul">
          <li class="over box_over"><b><ww:if test="listsegmentinfo.size()>1 && #index.index==0">已选择的去程航班信息</ww:if><ww:elseif test="listsegmentinfo.size()>1 && #index.index==1">已选择的返程航班信息</ww:elseif><ww:else>已选择的航班信息</ww:else></b><span class="mlr15"><ww:property
					value="getAirCityNamebySZM(startairport)" /> → <ww:property
					value="getAirCityNamebySZM(endairport)" /></span>出发日期：<ww:property
				value="formatTimestampyyyyMMdd(departtime)" /></li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">&yen;<ww:property
					value="formatMoneyToInt(listpassenger.get(0).price)" /></font><span class="mlr">
                <ww:if
					test="discount>=150.0">头等舱</ww:if> <ww:elseif
					test="discount>=130.0">商务舱</ww:elseif> <ww:elseif test="isspecial">特价经济舱</ww:elseif>
				<ww:else>经济舱</ww:else>
                </span></li>
                <li class="f airport">
                  <dt><ww:property value="formatTimestampHHmm(departtime)" /> <ww:property
					value="getAirCityNamebySZM(startairport)" /></dt>
				<dt><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property
					value="getAirCityNamebySZM(endairport)" /></dt>
                </li>
                <li class="f airlines airlines_mu"></li>
                <li class="f model">
                  <dt><ww:property value="airname" /><ww:property
					value="flightnumber" /></dt>
				<dt>空客<a id="a_flightdesc_<ww:property value="#index.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hideflightdesc('<ww:property value="#index.index" />');"
					; onmouseover="showflightdesc('<ww:property value="#index.index" />','<ww:property value="flightdesc" />');"
					class="fontun06c"><ww:property value="flightmodel" /></a><ww:property
					value="getFlightModel(flightmodel)" /> <input type="hidden"
					id="hid_lowflightdesc_<ww:property value="#index.index" />"
					value="<ww:property value="flightdesc" />" /></dt>
                </li>
                <li class="f fuel"><ww:property
					value="formatMoneyToInt(airportfee)" />/<ww:property
					value="formatMoneyToInt(fuelfee)" /></li>
                <li class="f meal"><a
					id="a_rules_<ww:property value="#index.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('<ww:property value="#index.index" />');"
					; onmouseover="showrules('<ww:property value="#index.index" />','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a>
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
          </ww:iterator>
          <!--乘机人信息-->
          <ww:iterator value="listpassenger" status="index">
          <ul class="msgul lh34">
           <li class="f mlr15">姓  名：<ww:property value="name" /></li>
           <li class="f mlr15">旅客类型：<ww:property value="getPassengerTypeToString(ptype)" /></li>
           <li class="f mlr15">证件类型：<span class="mlr15"><ww:property value="getIDTypeToString(idtype)" /></span><ww:property value="idnumber" /></li>
           <li class="f mlr15">保险：<span class="mlr15"><ww:property value="formatMoneyToInt(insurprice/20)" />份</span>￥20/份</li>
           <li class="c"></li>
          </ul>
          </ww:iterator>
          <ul class="msgul lh34">
           <li class="f mlr15">联系人：<ww:property value="orderinfo.contactname" /></li>
           <li class="f mlr15">手机号：<ww:property value="orderinfo.contactmobile" /></li>
           <li class="f mlr15">确认方式：<ww:property value="getNoteTypeToString(orderinfo.notetype)" /></li>
           <li class="c"></li>
          </ul>
       </div>
       <!--往返订单第二程信息-->
       <a name="maopointpay" id="maopointpay"></a>
      <ww:include page='../pay_50.jsp' />
      
      <!----------联系人信息------------>  
   </div>
  <!--right over-->
</div> 
	<!--container over-->

	<ww:include page="../footer.jsp" />

</ww:i18n>
</body>

</html>
