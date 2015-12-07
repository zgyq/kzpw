<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link rel="stylesheet" type="text/css" href="css/screen.css" />
		<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="js/jcarousellite_1.0.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.tools.min.js"></script>
		
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

alert(ticket);

var dingling=false;
//var img="<img src='imagess/gif-0242.gif'>";
var img="&nbsp;";
//<ww:if test="getLoginsessionagent().agenttype==1">
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
//</ww:if>
}


window.setInterval(onlod,'60000');



</script>
	
</script> 
</head>
<body onload="onlod();">
<div id="header">
		<div class="logo"><a href="#"><img src="images/logo.gif" alt=""></a></div>
		<div class="header_title"><img src="images/header_title.gif" alt=""></div>
		<div class="header_tel">
			<span class="tel_in">客服电话：<i>400 649 8898</i></span>
			<div class="tel_more">
				<span>出票：<i>56258257</i></span>
				<span>退改签：<i>56258257</i></span>
				<span>行程单：<i>56258257</i></span>
				<span>国际客服：<i>56258257</i></span>
				<span>投诉建议：<i>56258257</i></span>			
			</div>
			
			<span class="hello">您好，欢迎你登陆</span>
			<strong><ww:property value="#session.loginuser.loginname" /></strong>
			<a href="#" onClick="logout();">安全退出</a>
		</div>
	</div>
	<div class="nav">
		<div class="nav_left">
			<a href="#" class="a_return">返回首页</a>
			<div class="nav_list">
				<div class="nav_list_in">
					<ul id="nav_items">
						<ww:iterator value="#request.topmenulist" status="kk">
						<li><a class="ddt" id='alink_<ww:property value="#kk.index"/>' href="javascript:void(0)" onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main_xc/left.jsp',<ww:property  value="id"/>,0)  style="text-decoration:none;text-align: center;"><b><ww:property value="name" /></b></a></li>
						</ww:iterator>
						
					</ul>
				</div>
				<a href="#" id="prev">prev</a>
				<a href="#" id="next">next</a>
			</div>
			<a href="#" onclick="parent.showMessage();" class="nav_order">待处理订单<span>(<span class="dnum" id="contall">0</span>)</span></a>
		</div>
		
		<div class="nav_blank"></div>
		<div class="nav_more">
			<a href="#" onclick="tokefu();" class="a2">在线客服</a>
			<a href="http://kegui.jptonghang.com/dm/Prescribe/guiding.html?Airways" target="member" class="a1">退改签规定</a>	
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