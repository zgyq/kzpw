
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0055)http://lieche.huoche.com/zhanzhan.php -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>${dns.companyname} 火车票查询</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<META name=description content="">
<META name=keywords content="">

<LINK rel=stylesheet type=text/css href="js/train/style.css">
<LINK rel=stylesheet type=text/css href="css/train.css">  
<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->

<div>

<div id="main" style="margin-top:15px;">
<div style="width: 95%; margin: 0 auto;">



<div >
<form action="">
   <div class="lbox">
   <Div class="chang"><b class="lan14">预订成功 </b>
   </Div>
   <div style="line-height:56px; text-align: center;">
      <ul>
       <li style="font-size: 16px; font-weight: bold">恭喜您已经成功预订
       <font style="font-size: 16px; font-weight: bold; color:#f48000"><ww:property value="train.startdate"/></font> 
       <font style="font-size: 16px; font-weight: bold; color:#f48000">
         <ww:property value="train.startcity"/></font> 到 
         <font style="font-size: 16px; font-weight: bold; color:#f48000">
         <ww:property value="train.endcity"/></font>
          的列车<ww:property value="train.traincode"/>车票一张。</li>
       <li>您的订单号为：<ww:property value="train.ordernumber"/>   请保持您联方式的畅通，我们会尽快与您联系。</li>
       <li>如有问题请拨打电话：4000-152-535咨询，我们竭诚为您提供最优质的服务，谢谢！
       </li>
      </ul>
   </div>
   
</div>
</form>
</div>
</div>


</div>

</BODY>
