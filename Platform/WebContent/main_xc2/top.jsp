<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/easySlider1.5.js"></script>
<script type="text/javascript" src="js/accordian.pack.js"></script>

<script type="text/javascript"> 

		$(document).ready( function(){
				$('.tel_in').mouseover(function(){
					$('.tel_more').css('display','block');
				});
								
				$('.tel_more').mouseover(function(){
					$('.tel_more').css('display','block');
					
				});
				
				$('.tel_more').mouseout(function(){
					$('.tel_more').css('display','none');
				});
				
				$(".nav_list_in").jCarouselLite({
					btnPrev: "#prev",
					btnNext: "#next",
					easing: "easeInOutExpo",
					speed: 1000,
					visible: 4.8,
					scroll: 2,
					circular: false
				});
				
				$('.side_list>li').find('a:first').toggle(function(){
					$(this).next('ul').slideDown();
				}, function(){
					$(this).next('ul').slideUp();
				});
				
				$('.side_btn').click(function(){
					$('.sidebar').toggle();
				});
				
				$(".tab_title").tabs(".tab_cont");
				
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
		  
		  if(id==28){//机票
		   parent.member.location.href="<%=request.getContextPath()%>/login!towelcome_xc.action";
		  }
		   if(id==10502){//酒店
		   parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?new&puser&ywtype=3";
		  }
		   if(id==10718){//充值
		   parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?new&puser&ywtype=5&rechtype=1";
		  }
		  if(id==81){//合作商
		   parent.member.location.href="<%=request.getContextPath()%>/customeragent!tofenxiao.action?agenttype=3";
		  }
		  
		  
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
	parent.member.location.href="<%=request.getContextPath()%>/login!towelcome_xc.action";
		
	}
	
	
	function onlod(){

	<ww:if test="getLoginsessionagent().agenttype==1">
		showMessage();
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

var tuiticket=ticket.tuiticket;//申请退票
var feiticket=ticket.feiticket//申请废票
var gaiqianticket=ticket.gaiqianticket;//申请改签
var daichupiao=ticket.daichupiaoticket;//待出票
var daiqueren=ticket.daiquerenticket;//待确认
var daizhifu=ticket.daizhifuticket;//待支付
var qbnum=ticket.qbnum;//QB
var telnum=ticket.telnum;//tel

//alert("tuiticket:"+tuiticket+",feiticket:"+feiticket+",gaiqianticket:"+gaiqianticket);


//$("#tp").html(tuiticket);
//$("#fp").html(feiticket);
//$("#gq").html(gaiqianticket);
//$("#dcp").html(daichupiao);//待出票
$("#contall").html(tuiticket+feiticket+gaiqianticket+daichupiao+daiqueren+daizhifu+qbnum+telnum);
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
if(daizhifu>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}
if(daichupiao>0){
var videosrc='ding.wav';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='../video/"+videosrc+"'></bgsound>");
}

}


window.setInterval(onlod,'60000');



</script>

</head>
<body onload="onlod();">
<div class="container_top" style="z-index: 99999999">
<div class="top">
<div class="top_right"><a href="#" class="tuichu"
	onClick="logout();">安全退出</a>
<div class="top_login">您好，欢迎你登录 <font color="#da7500"><ww:property
	value="#session.loginuser.loginname" />！</font></div>
<div class="top_tel" id="teltips"><span>客服电话：<b><ww:property value="#session.dns.serviceline" /></b></span>
<ww:if test="#session.dns.agentid==46">
<ul id="tips">
	出票：
	<font color="#0096cd">010-56258257</font>
	<br />
	退改签：
	<font color="#0096cd">010-56259366</font>
	<br />
	行程单：
	<font color="#0096cd">010-56259766</font>
	<br />
	国际客服：
	<font color="#0096cd">010-56259697</font>
	<br />
	投诉建议：
	<font color="#0096cd">010-82251248</font>
</ul>
</ww:if>
</div>
</div>
<div class="top_left"><a href="#"><img src="images/<ww:property value="#session.dns.logosrc" />" width="220px" height="83px" /></a>
<ww:if test="#session.dns.agentid==101">
<img src="images/logo1_weiye.jpg" />
</ww:if><ww:else>
<img src="images/logo1.jpg" />
</ww:else>

</div>
</div>
<div class="clear"></div>
<div class="menu">
<div class="menu_con">
<div class="menu_right"><a href="#" onclick="tokefu();"
	class="kefu">在线客服</a><a
	href="http://kegui.jptonghang.com/dm/Prescribe/guiding.html?Airways"
	target="member" class="tuigai">退改签规定</a></div>
<div class="menu_left">
<div class="menu_home"><a href="#" onclick="toIndex();">返回首页</a></div>
<div class="menu_lsit">
<div class="picshow" id="easyslider">
<ul id="nav_items">
	<li><ww:iterator value="#request.topmenulist" status="kk">
		<a href="#" onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main_xc2/left.jsp',<ww:property  value="id"/>,0)><b><ww:property value="name" /></b></a>|
          				<ww:if
			test="(#kk.index+1)==4||(#kk.index+1)==8||(#kk.index+1)==12"></li>
	<li></ww:if> </ww:iterator></li>



</ul>
<!--
            <ul>
              <li><a href="#">机票采购</a>|<a href="#">酒店</a>|<a href="#">市场拓展</a>|<a href="#">报表管理</a>|<a href="#">系统管理</a></li>
              <li><a href="#">速度国防</a>|<a href="#">市场</a>|<a href="#">撒的撒的</a>|<a href="#">瑞特人人</a>|<a href="#">华国锋的</a></li>
            </ul>
          --></div>
<div class="aclick"><a href="javascript:void(0)" id="prevpic"
	class="pert"></a><a href="javascript:void(0)" id="nextpic" class="next"></a></div>
</div>
<div class="menu_dai"><a href="#" onclick="parent.showMessage();">待处理订单<font
	color="#ffb085">（<span class="dnum" id="contall">0</span>）</font></a></div>
</div>
</div>
</div>
</div>
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
	parent.member.location.href="<%=request.getContextPath()%>/login!towelcome_xc.action?isSPPolicy=4";
	
	}

</script>