<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${dns.address}</title>

<link href="css/global.css"
	rel="stylesheet" type="text/css">
<link href="css/main.css"
	rel="stylesheet" type="text/css">
<link href="css/font-awesome.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/jquery-1.4.1.min.js"></script>
<script
	src="<%=request.getContextPath()%>/main_cx/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/sideleft.js"></script>
<script src="<%=request.getContextPath()%>/main_cx/js/menu.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/lhgdialog.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/layout.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/popup_layer.js"></script>


</head>
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
		   parent.member.location.href="<%=request.getContextPath()%>/b2bairticket!toTicket.action";
		  }
		  if(id==10650){//火车票
		   parent.member.location.href="<%=request.getContextPath()%>/main_tulue/login!towelcome.action";
		  }
		   if(id==10813){//签证
		   parent.member.location.href="<%=request.getContextPath()%>/qzseach.action";
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
		    if(id==10720){//租
		   parent.member.location.href="<%=request.getContextPath()%>/bookcar!toindex.action";
		  }
		   if(id==10719){//旅游
		   parent.member.location.href="<%=request.getContextPath()%>/spotticket!toindex.action";
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

//alert("?");
 // document.getElementById("embed").innerHTML = "<embed name=\"player\" TYPE=\"application/x-mplayer2\" src=\"../video/ding.wav\" loop=\"false\" autostart=\"true\" hidden=\"true\"></embed>";     

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
var videosrc='newmessage.mp3';
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' type='audio/x-wav' src='../video/"+videosrc+"'></bgsound>");
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


//window.setInterval(onlod,'60000');

function ChangPwd(){
parent.member.location.href="<%=request.getContextPath()%>/login!toeditpassword.action";

}

</script>
<body id="embed">


<div id="wrap">

<!--头部信息 begin -->
<div class="g-top">
<div class="">
<div class="m-top f-w"></div>
</div>
<div class="g-mid f-w f-cb">
<div class="logo f-fl"><a
	href="#"
	target="mainframe"><img width="236px;" height="61px;"
	src="img/${dns.logosrc}"></a>
</div>
<div class="conpanyinfo f-fr">
<p style="margin-top: 10px">欢迎使用本平台，<b>${dns.address}</b>!&nbsp;&nbsp;登录帐号：<ww:property value="#session.loginuser.loginname" />&nbsp;<a
	href="#" onclick="ChangPwd();"
	style="color: #1c7dc7; font-weight: normal; text-decoration: underline"
	>修改密码</a></p>
</div>
<div class="contact f-fr">
<p class="f-fwb">
<ww:if test="getLoginsessionagent().id==123||getLoginsessionagent().parentstr.indexOf('123')!=-1">
催单出票:<span>${dns.serviceline}</span>退改签：<span>${dns.serviceline}</span>紧急：<span>${dns.serviceline}</span>
</ww:if><ww:elseif test="getLoginsessionagent().id==283||getLoginsessionagent().parentstr.indexOf('283')!=-1">
催单出票:<span>4006-002-102</span>退改签：<span>010-81511095</span>紧急：<span>010-52465543</span>
</ww:elseif><ww:elseif test="getLoginsessionagent().id==434||getLoginsessionagent().parentstr.indexOf('434')!=-1">
催单出票:<span>010-56056661</span>退改签：<span>010-56056661</span>紧急：<span>13366704984</span>
</ww:elseif><ww:else>
催单出票:<span>021-56351230</span>退改签：<span>021-55158581</span>紧急：<span>13585538232</span>
</ww:else>

<ww:if test="#session.dns.agentid==46">
催单出票:<span>021-56351230</span>退改签：<span>021-55158581</span>紧急：<span>13585538232</span>
</ww:if>


<!-- <span onclick="_ShowQQ();" id="ele1" class="kf f-fwn tigger">客服中心</span> -->
 &nbsp;<a id="lbtnlogout"
	href="javascript:logout();"
	style="font-size: 14; color: #1c7dc7; font-weight: normal; text-decoration: underline">退出</a></p>

</div>
</div>

<!-- end mid -->
<div class="g-nav" id="topmenu" >
<div class="m-nav f-w" style="width: 1980px;">
<ul class="f-cb f-nav" id="f-nav" >
 <li><a id='alink_00' href="../login!towelcome_cx.action" target="member"  >首页</a></li>
<ww:iterator value="#request.topmenulist" status="kk">
	<li><a id='alink_<ww:property value="#kk.index"/>' href="javascript:void(0)" onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main_cx/left.jsp',<ww:property  value="id"/>,0)
		target="member" class=""><ww:property value="name" /></a></li>
</ww:iterator>

 <li><a id='alink_80' href="AirTuiGaiQian.jsp" target="member"  style="color: red;font-size: 18px;">退改签</a></li>
 
 <li><a id='alink_80' href="../login!tokefu.action" target="member"  style="color: red;font-size: 18px;">客服中心</a></li>
		
 <li><a id='alink_81' href="javascript:void(0)" style="color: red;font-size: 18px;" >400热线:${dns.serviceline}</a></li>		
		
<ww:if test="getLoginsessionagent().agenttype==1">
<li><a id='alink_81' href="javascript:void(0)" onclick="parent.showMessage2();" style="color: red;font-size: 18px;" >待处理订单（<span class="dnum" id="contall">0</span>）</a></li>		

</ww:if>		
		
	<!--
	<li><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,24)" alt="24" class="">国内机票</a></li>
	<li><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,25)" alt="25" class="">酒店预订</a></li>
	<li><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,26)" alt="26" class="">景点门票</a></li>
	<li><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,30)" alt="30" class="">航空保险</a></li>
	<li><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,13)" alt="13" class="">客户管理</a></li>
	<li class="" style=""><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,23)" alt="23" class="">系统设置</a></li>
	<li class="" style=""><i class="f-a"></i><a
		href="http://cx.soku5.net:8085/index.aspx#"
		onclick="loadMenuTree(true,27)" alt="27" class="">管理中心</a></li>
	-->
</ul>
</div>



</div>
</div>
<!--头部信息 begin -->
</div >

</body>
</html>
<script>
function logout(){
window.location.href="login!logout.action";
window.close();
}
function _ShowQQ(){
//window.parent.functionName="ShowQQinfo";
 window.parent.ShowQQinfo();
//eval('window.parent.' + ShowQQinfo + '()');
}

</script>