
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
<LINK rel=stylesheet type=text/css href="css/style.css">  
<LINK rel=stylesheet type=text/css href="css/train.css">  

  

<SCRIPT type=text/javascript src="js/train/header.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/jquery-1.4.2.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.utilities.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.autocomplete-min.js"></SCRIPT>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT type=text/javascript src="js/train/main.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/input.js"></SCRIPT>
<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->

<div >
<div id="main" style="margin-top:20px;"> 
<div>
<div style="border:2px solid #91c8e5">
   <div class="nav" style="margin-top: 10px;" ><img src="images/icon.gif" align="absmiddle" />&nbsp;&nbsp;<font style="color:#f48000; font-size: 20px;">列车时刻查询</font>最全的列车时刻<font style="color:#f48000; font-size: 20px;">查询系统</font>。 </div>
	<div class="f">
	
<div id=search_zz class="chufa">
<FORM id=form1 method='POST' name=form1 action='train!search.action'>
   <div style="float: left;width: 200px;">
    <P>出发站：</P>
	<div class="minitext_bj">
	   <INPUT id=k1 type=text name='startcity'  style="width: 120px; float: left" value="<ww:property value='train.startcity'/>" autocomplete="off"> 
	   <SPAN id=k1input class=plain_btn title=选择热门城市 onclick="tanchu('k1input','k1','tanchuzz')"></SPAN>
	   <div style="Z-INDEX: 9999; MARGIN-TOP: 2px; WIDTH: 150px; COLOR: #666; MARGIN-LEFT: 5px; FONT-SIZE: 14px" id=container1></div>
	</div>
	</div>
	<div style="float: left; width: 200px;">
   <P>到达站：</P>
	<div class="minitext_bj">
	    <INPUT id=k2 type=text name='endcity' style="width: 120px; float: left" value="<ww:property value='train.endcity'/>" autocomplete="off"> 
	    <SPAN id=k2input class=plain_btn title=选择热门城市 onclick="tanchu('k2input','k2','tanchuzz')"></SPAN>
	    <div style="Z-INDEX: 9999; MARGIN-TOP: 2px; WIDTH: 150px; COLOR: #666; MARGIN-LEFT: 5px; FONT-SIZE: 14px" id=container2></div>
	</div>
	</div>




	
	<div style="width: 200px;  float: left;">
	<P>出发时间：</P>

<input style="WIDTH: 160px;height: 23px" name="startdate" value='<ww:property value="train.starttime"/>'
	onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
	</div>
	<div class="f" style="padding-left: 40PX; padding-top: 10px;" >
	<INPUT onclick="gosearch()" class="button" type=button value="立即查询"></div>
    <Div style="clear:both;line-height:50px; color:#06f">最真实的火车票数据系统。</Div> 
<div>
  
</div>
  
</FORM>
</div>
<div  style="display: none">
<INPUT id=zhan type=text name=zhan autocomplete="off"> 
<SPAN id=zhaninput  title=选择热门车站 ></SPAN>
<div style='display: none' id=container3></div>
</div>
	  

<!--车次搜索-->
	<div style="DISPLAY: none" id=search_checi>
	    <FORM   method=get name=form_search_checi action=>
	    <P >请输入车次：</P>
	         <div class=minitext_bj><INPUT id=checi style="width: 120px; float: left" type=text name=checi autocomplete="off"> 
	             <SPAN id=checiinput class=plain_btn title=选择热门车次 onclick="tanchu('checiinput','checi','tanchucheci')"></SPAN>
	         </div>
	         <Div>&nbsp;</Div>
	         <div><INPUT onclick="gosearch()" class="button" type=button value="立即查询"></div>
	     </FORM>
	</div>
	<!--车站搜索-->
	</div>
	


    <div class="c"></div>
</div>

</div>
<div class="f">
	  <div style="line-height:32px; margin-top:10px; padding-right: 10px; "> 
	  <font style="font-size:24px;color:red;">购票须知:</font>


	  <div style="line-height:32px; margin-top:10px; padding-right: 10px; "> 
	  <font style="font-size:10px;color:red">1、火车票票源紧张，支付后不保证100%出票，若未能给您出票，敬请谅解；</font>
	   <ul style="border-top:1px solid #06f "></ul>
	  <font style="font-size:10px;color:red">2、出票失败后，将电话通知，票款蒋原路退还，支付宝余额支付的将即时到账。
到帐时间为3-21天（15个工作日内，视银行不同有所差异）。</font>
<ul style="border-top:1px solid #06f "></ul>
	  <font style="font-size:10px;color:red">3.订票成功后，可凭购票时所使用的乘车人有效二代居民身份证原件到车站售票窗口、铁路客票代售点或车站自动售票机上办理换票（其他证件请到窗口办理）。</font>
<ul style="border-top:1px solid #06f "></ul>	  
<font style="font-size:10px;color:red">4.在您申请退票后，退款到账时间为3-21天（15个工作日内，视银行不同到账时间有所差异），请耐心等待。</font>
<ul style="border-top:1px solid #06f "></ul>	 
 <font style="font-size:10px;color:red">5.代理商会优先按照您的首选坐席为您出票，但是当首选坐席没有票时，为了保证您的顺利出行，会按照您的备选坐席给您出票。</font>
<ul style="border-top:1px solid #06f "></ul>	 
 <font style="font-size:10px;color:red">6.预定火车票的工作时间：08:00--22:00</font>	 
<ul style="border-top:1px solid #06f "></ul>	 
 <font style="font-size:10px;color:red">7.未经火车站或售票点核验过的证件号会造成预定失败，系统将会自动拒单</font>	 
	  </div>
	 
	</div>
</div>
</BODY>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript">
function gosearch(){
 dispose("系统正在为您查询");
 document.form1.submit();
}

function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
</script>
</HTML>
