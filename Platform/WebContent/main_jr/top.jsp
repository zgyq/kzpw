<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>中国指南后台管理中心</title>
<meta content="text/html; charset=utf-8" http-equiv=Content-Type>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link rel=stylesheet type=text/css href="css/index.css">
<script type=text/javascript src="js/jquery.min.js"></script>
<script type=text/javascript src="js/dialog.js"></script>

<link href="css/top.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG-min.js"></script>
<script type="text/javascript">
// <![CDATA[
if((window.navigator.appName.toUpperCase().indexOf("MICROSOFT")>=0)&&(document.execCommand))
try{
       document.execCommand("BackgroundImageCache", false, true);
     }
    catch(e){}
// ]]>
  DD_belatedPNG.fix('.menu .logo,.top,.ul-plist li');
</script>
<![endif]-->
<style type=text/css>
.objbody {
	OVERFLOW: hidden
}
</style>
<script type="text/javascript"> 
$(function(){ 
var page= 1; 
var i = 5;//每版四个图片 
//向右滚动 
$(".next").click(function(){ //点击事件 
var v_wrap = $(this).parents(".scroll"); // 根据当前点击的元素获取到父元素 
var v_show = v_wrap.find(".scroll_list"); //找到视频展示的区域 
var v_cont = v_wrap.find(".box"); //找到视频展示区域的外围区域 
var v_width = v_cont.width(); 
var len = v_show.find("li").length; //我的视频图片个数 
var page_count = Math.ceil(len/i); //只要不是整数，就往大的方向取最小的整数 
if(!v_show.is(":animated")){ 
if(page == page_count){ 
v_show.animate({left:'2px'},"slow"); 
page =1; 
}else{ 
v_show.animate({left:'-='+v_width},"slow"); 
page++; 
} 
} 
}); 
//向左滚动 
$(".prev").click(function(){ //点击事件 
var v_wrap = $(this).parents(".scroll"); // 根据当前点击的元素获取到父元素 
var v_show = v_wrap.find(".scroll_list"); //找到视频展示的区域 
var v_cont = v_wrap.find(".box"); //找到视频展示区域的外围区域 
var v_width = v_cont.width(); 
var len = v_show.find("li").length; //我的视频图片个数 
var page_count = Math.ceil(len/i); //只要不是整数，就往大的方向取最小的整数 
if(!v_show.is(":animated")){ 
if(page == 1){ 
v_show.animate({left:'-='+ v_width*(page_count-1)},"slow"); 
page =page_count; 
}else{ 
v_show.animate({left:'+='+ v_width},"slow"); 
page--; 
} 
} 
}); 
}); 

function a(el,url,id,type)
	{
	
	
	 $("li[id*='LI_']").each(function(i)
              {
                $(this).removeClass("on");
             });
    		$('#LI_'+el).addClass("on");
		if(type==0)
		{
		  parent.left.location.href=url;
		 // parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		  //parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1";
		}
		else
		{
		  parent.left.location.href="login!getMemberByOrder.action?new&puser&ywtype=2";
		  //parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		  // parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1";
		}
	}
	
	function toIndex(){
	parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1";
		
	}
	
	
	function onlod(){

	<ww:if test="getLoginsessionagent().agenttype==1">
		//showMessage();
	</ww:if>
	}
function showMessage() {
		var url="orderinfo!getOrderCount.action?rndmath="+Math.floor(Math.random()*100);
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
			if (data != '') {
			//var message=eval("analytic("+data+")");
			
		
			}
		});
	}
//解析提示数据
function analytic(ticket){



var dingling=false;
//var img="<img src='imagess/gif-0242.gif'>";
var img="&nbsp;";
<ww:if test="getLoginsessionagent().agenttype==1">
var tuiticket=ticket.tuiticket;//申请退票
var feiticket=ticket.feiticket//申请废票
var gaiqianticket=ticket.gaiqianticket;//申请改签
var daichupiao=ticket.daichupiaoticket;//待出票
var daiqueren=ticket.daiquerenticket;//待确认
var qbnum=ticket.qbnum;//QB
var telnum=ticket.telnum;//tel

//alert("tuiticket:"+tuiticket+",feiticket:"+feiticket+",gaiqianticket:"+gaiqianticket);


//$("#tp").html(tuiticket);
//$("#fp").html(feiticket);
//$("#gq").html(gaiqianticket);
//$("#dcp").html(daichupiao);//待出票
$("#contall").html(tuiticket+feiticket+gaiqianticket+daichupiao+daiqueren+qbnum+telnum);
if(tuiticket>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
if(feiticket>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
if(gaiqianticket>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
if(daiqueren>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
if(daichupiao>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
</ww:if>
}


window.setInterval(onlod,'600000');



function logout(){
window.location.href="login!logout.action";
window.close();
}
function tokefu(){
	parent.member.location.href="<%=request.getContextPath()%>/b2bairsearch.action?isSPPolicy=1";
	
}

</script>
<body class=objbody scroll=no>
<div class=header>
  <div class="lf"><img src="img/<ww:property value="#session.dns.logosrc" />" width="260px" height="82px" /></div>
  <div class=rt-col>
    <ul class="ul-top">
    <li><a href="#" style="_color:#fff;">系统首页</a></li>
    <li><a href="#" style="_color:#fff;">平台介绍</a></li>
    <li><a href="#" style="_color:#fff;">帮助中心</a></li>
    <li><a href="javascript:;" onClick="logout();" style="_color:#fff;">退出系统</a></li>
  </ul>
  </div>
</div>
<div class="part2">
  <div class="info">欢迎您:<ww:property value="#session.loginuser.loginname" /></div>
  
  <div class="p2menu">
  	 
    	<ul id=top_menu class="ul-p2menu">
	      <!--
	      <li id=_M0 class="on top_menu"><a hidefocus style="OUTLINE-STYLE: none" href="javascript:_M(0,1,'main.html','采购管理')">采购管理</a></li>
	      <li id=_M1 class="top_menu"><a hidefocus style="OUTLINE-STYLE: none" href="javascript:_M(1,101,'2.html','客户服务')">客户服务</a></li>
	      <li id=_M2 class="top_menu"><a hidefocus style="OUTLINE-STYLE: none" href="javascript:_M(2,201,'3.html','报表系统')">报表系统</a></li>
	     -->
	    <ww:iterator value="#request.topmenulist" status="kk">
	    <li id="LI_<ww:property  value="#kk.index"/>" <ww:if test="#kk.index==0">class='on top_menu'</ww:if><ww:else>class='top_menu'</ww:else> ><a class="ddt" id='alink_<ww:property value="#kk.index"/>' href="javascript:void(0)" onclick=a(<ww:property  value="#kk.index"/>,'../main/customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main/left.jsp',<ww:property  value="id"/>,0)  style="text-decoration:none;"><b><ww:property value="name" /></b></a></li>
	    </ww:iterator>
	    </ul>
    
  </div>
  <div class="zt">订单状态:<a href="#" onclick="parent.showMessage();">待处理订单[<span class="dnum" id="contall">0</span>]</a></a>
  &nbsp; 单位:<ww:property value="getangname(#session.loginuser.agentid)" />
  </div>
</div>


</body>
</html>
