<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}线路订单详细信息</title>

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
            <li class="mation_info"><font class="mation_left f"><b>订单号：<font class="fontxing"><ww:property value="spotlineorder.orderno"/></font></b></font><span class="f mr25">预订时间：（<font class="fontxing"><ww:property
			value="formatDate(spotlineorder.createtime)" /> </font>）</span> <span class="r mation_right">&nbsp;</span>    </li>
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
          <li class="over box_over">订单号： <ww:property value="spotlineorder.orderno"/> 订单状态：<font class="f00"> <ww:if test="spotlineorder.state==0">待确认</ww:if>
				<ww:elseif test="spotlineorder.state==1">已确认</ww:elseif>
				<ww:elseif test="spotlineorder.state==2">已完成</ww:elseif>
		     	 <ww:elseif test="spotlineorder.state==3">已取消</ww:elseif>
		     	 <ww:else>待确认</ww:else></font></li>
          <li class="over information" style="margin-top:10px;">
             <table width="100%" border="0" cellspacing="0" cellpadding="0" class="over">
                  <tr>
                    <td width="90" class="hadow" align="right">线路名称：</td>
                    <td width="260"><ww:property value="spotlineorder.name"/></td>
                    <td width="90" class="hadow" align="right">出发日期：</td>
                    <td><ww:property value="formatDate(spotlineorder.stime)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">出发地：</td>
                    <td><ww:property value="getSpotCityNameByStr(spotlineorder.provineid)"/></td>
                    <td class="hadow" align="right">目的地：</td>
                    <td><ww:property value="getSpotCityNameByStr(spotlineorder.cityid)"/></td>
                  </tr>
                  <tr>
                    <td class="hadow" align="right">总人数：</td>
                    <td><ww:property value="spotlineorder.snum" />人</td>
                    <td class="hadow" align="right">费用总计：</td>
                     <td><font class="font-f60-16">&yen;<ww:property value="spotlineorder.price" /></font></td>
                  </tr>
                  
                  <tr>
                    <td class="hadow" align="right">备注：</td>
                    <td colspan="3"><ww:property value="spotlineorder.beizhu" /></td>
                  </tr>
                   
                </table>
             <div class="nohave"></div>
          </li>
          </ul>
      </div>  
          <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>联系人信息</b></li>
           <li class="f mlr15 lh34">联系人：<ww:property value="spotlineorder.linkname" /></li>
           <li class="f mlr15 lh34">手机号：<ww:property value="spotlineorder.linktel" /></li>
           <li class="f mlr15 lh34">邮箱：<ww:property value="spotlineorder.linkemail" /></li>
           <li class="c"></li>
          </ul>
       </div>
       
       <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>游客信息</b></li>
           <ww:iterator value="ListSpotLineUser">
           <li class="f mlr15 lh34">姓名：<ww:property value="name" /></li>
           <li class="f mlr15 lh34">成人类型：<ww:if test="ptype.equals(\"1\")">成人</ww:if><ww:if test="ptype.equals(\"2\")">儿童</ww:if></li>
           <li class="f mlr15 lh34">性别：<ww:if test="psex.equals(\"1\")">男</ww:if><ww:if test="psex.equals(\"2\")">女</ww:if><ww:if test="psex.equals(\"3\")">保密</ww:if></li>
           <li class="f mlr15 lh34">手机号：<ww:property value="tel" /></li>
           <li class="f mlr15 lh34">证件类型：<ww:if test="idtype==1">身份证</ww:if><ww:if test="idtype==2">护照</ww:if><ww:if test="idtype==3">其他</ww:if></li>
           <li class="f mlr15 lh34">证件号码：<ww:property value="idno" /></li>
           <li class="c"></li>
           </ww:iterator>
          </ul>
       </div>
       
          <div class="msg mt7">
           <ul class="msgul">
              <li class="allmornydetail l06c"><span class="allmorny"></span>订单总价：<font class="font18f60">&yen;<ww:property value="spotlineorder.price" /></font></li>
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
