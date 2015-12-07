<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link href="css/top.css" rel="stylesheet" type="text/css" />
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<script src="Scripts/jquery1.3.2.js" type="text/javascript"></script>
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
	
	
	 //$("a[id*='alink_']").each(function(i)
     //         {
     //            $(this).css("color","#fff");
     //         });
	//	el.style.color="#003399";
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



</script>
	
</script> 
</head>
<body onload="onlod();">

<!--
<div class="w_1200">
<div class="ht_logo"><img src="img/<ww:property value="#session.dns.logosrc" />" width="260" height="82" /></div>
<div class="ht_flash">
<script type="text/javascript">
AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','1004','height','83','src','img/top','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','wmode','transparent','movie','img/top' ); //end AC code
</script><noscript><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1004" height="83">
<param name="movie" value="img/top.swf" />
<param name="quality" value="high" />
<param name="wmode" value="transparent" />
<embed src="img/top.swf" width="1004" height="83" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="transparent"></embed>
</object>
</noscript></div>
</div>
-->
<div style="height:83px; min-width:1024px; width:100%;background-image: url(img/main_02.gif);">
	
	<div style="height:82px; width:260px;float:left;"><img src="img/<ww:property value="#session.dns.logosrc" />" width="260px" height="82px" /></div>
	
	<div style="height:82px; width:74%;float:right;">
		<script type="text/javascript">
		AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0','width','100%','height','82px','src','img/top','quality','high','pluginspage','http://www.macromedia.com/go/getflashplayer','wmode','transparent','movie','img/top' ); //end AC code
		</script>
	
	</div>
</div>
<table width="100%" height="32" border="0" cellpadding="0" cellspacing="0" background="img/topbg.gif">
      <tbody><tr>
         <td width="180" height="26" valign="top" ><img src="img/main_16.gif" onclick="toIndex()" width="180" height="30" style="cursor:pointer" /></td>
        <td width="440"><div class="scroll" style="margin:0 auto;width:440px;"> 
<a class="prev" href="#"></a> 
<div class="box"> 
<div class="scroll_list"> 
<ul> 
<ww:iterator value="#request.topmenulist" status="kk">
<li><a class="ddt" id='alink_<ww:property value="#kk.index"/>' href="javascript:void(0)" onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main/left.jsp',<ww:property  value="id"/>,0)  style="text-decoration:none;"><b><ww:property value="name" /></b></a></li> 
</ww:iterator>

</ul> 
</div> 
</div> 
<a class="next" href="#"></a> 
</div>
</td>



 <td width="432"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <ww:if test="getLoginsessionagent().agenttype==1">
    <td width="5%"><img src="img/search.png" alt="订单状态" width="16" height="16" /></td>
    <td width="45%" align="left">
    <a href="#" onclick="parent.showMessage();">待处理订单（<span class="dnum" id="contall">0</span>）</a>
    
    <!--
    <a href="../b2bticketorder.action?s_orderstatus=4&ty=12&" style="text-decoration:none;" target="member">
    申请退票（<span class="dnum" id="tp">0</span>）
    </a>
    <a href="../b2bticketorder.action?s_orderstatus=5&ty=3&" style="text-decoration:none;" target="member">
    申请废票（<span class="dnum" id="fp">0</span>）
    </a>
    <a href="../b2bticketorder.action?s_orderstatus=13&ty=9&" style="text-decoration:none;" target="member">
    申请改签（<span class="dnum" id="gq">0</span>）
    </a>
    <a href="../b2bticketorder.action?s_orderstatus=2&ty=1" style="text-decoration:none;" target="member">
    待出票（<span class="dnum" id="dcp">0</span>）
    </a>
     <a href="../b2bticketorder.action?s_orderstatus=0&ty=1" style="text-decoration:none;" target="member">
    待确认（<span  class="dnum" id="dqr">0</span>）
    </a>
    -->
    </td>
    </ww:if>
     <td width="25%"><b><a href="http://kegui.jptonghang.com/dm/Prescribe/guiding.html?Airways" target="member">退改签规定</a></b></td>
     <td width="25%" align="l"><img src="img/zaixiankefu.jpg" style="cursor:pointer" onclick="tokefu();" alt="在线客服" /></td>
  </tr>
</table></td>


        <td width="29" height="26" align="center"><img src="img/user.png" width="16" height="16"></td>
        <td width="256"><span class="STYLE1">欢迎您:<ww:property value="#session.loginuser.loginname" />          单位:<ww:property value="getangname(#session.loginuser.agentid)" />        </span>
        <span><a href="#">
        <input type="button" value="退出" onClick="logout();"></a></span></td>
      </tr>
</tbody></table>


</body>
</html>
<script>
function red(){ 
//alert($("#tp").html());
return;
<ww:if test="getLoginsessionagent().agenttype==1 || getLoginsessionagent().agenttype==3">
var   tpobj = document.getElementById("tp"); 

if($("#tp").html()!='0'){
tpobj.style.color=tpobj.style.color== ""?"red":""; 
}
var   fpobj = document.getElementById("fp");
if($("#fp").html()!='0'){ 
fpobj.style.color=fpobj.style.color== ""?"red":"";
}
var   gqobj = document.getElementById("gq"); 
if($("#gq").html()!='0'){
gqobj.style.color=gqobj.style.color== ""?"red":"";  
}
</ww:if>
<ww:if test="getLoginsessionagent().agenttype==1 || getLoginsessionagent().agenttype==2">
var   dcpobj = document.getElementById("dcp"); 
if($("#dcp").html()!='0'){
dcpobj.style.color=dcpobj.style.color== ""?"red":"";  
}
</ww:if>
setTimeout("red()",10000); 
} 
red(); 
function logout(){
window.location.href="login!logout.action";
window.close();
}
function tokefu(){
	parent.member.location.href="<%=request.getContextPath()%>/b2bairsearch.action?isSPPolicy=1";
	
	}

</script>