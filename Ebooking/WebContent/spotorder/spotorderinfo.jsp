<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}门票订单详细信息</title>

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
            <li class="mation_info"><font class="mation_left f"><b>订单号：<font class="fontxing"><ww:property value="spotorder.param1"/></font></b></font><span class="f mr25">预订时间：（<font class="fontxing"><ww:property
			value="formatDate(spotorder.createtime)" /> </font>）</span> <span class="r mation_right">&nbsp;</span>    </li>
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
          <li class="over box_over">订单号： <ww:property value="spotorder.param1"/> 订单状态：<font class="f00"> <ww:if test="spotorder.state==0">待确认</ww:if>
				<ww:elseif test="spotorder.state==1">已支付</ww:elseif>
				<ww:elseif test="spotorder.state==2">已完成</ww:elseif>
		     	 <ww:elseif test="spotorder.state==3">已取消</ww:elseif>
		     	 <ww:else>待确认</ww:else></font></li>
          <li class="over information" style="margin-top:10px;">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="over">
                  <tr>
                    <td width="90" class="hadow" align="right">门票名称：</td>
                    <td width="260"><ww:property value="spotorder.name"/></td>
                    <td width="90" class="hadow" align="right">游玩日期：</td>
                    <td><ww:property value="formatDate(spotorder.stime)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">所在城市：</td>
                    <td><ww:property value="getSpotCityNameByStr(spotorder.cityid)"/></td>
                    <td class="hadow" align="right">景区名称：</td>
                    <td><ww:property value="getSpotmesNameBySpotticketIDStr(spotorder.spotticketid)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">门票数量：</td>
                    <td><ww:property value="spotorder.sunm" />张</td>
                   <td class="hadow" align="right">费用总计：</td>
                    <td><font class="font-f60-16">&yen;<ww:property value="spotorder.price" /></font></td>
                  </tr>
                  
                  <tr>
                    <td class="hadow" align="right">景区地址：</td>
                    <td colspan="3"><ww:property value="spotmes.address" /></td>
                  </tr>
                   
                </table>
             <div class="nohave"></div>
          </li>
          </ul>
      </div>  
          <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>联系人信息</b></li>
           <li class="f mlr15 lh34">联系人：<ww:property value="spotorder.param2" /></li>
           <li class="f mlr15 lh34">手机号：<ww:property value="spotorder.tel" /></li>
           <li class="f mlr15 lh34">身份证：<ww:property value="spotorder.sfz" /></li>
           <li class="c"></li>
          </ul>
       </div>
          <div class="msg mt7">
           <ul class="msgul">
              <li class="allmornydetail l06c"><span class="allmorny"></span>订单总价：<font class="font18f60">&yen;<ww:property value="spotorder.price" /></font></li>
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
