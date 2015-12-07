<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="css/cont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>

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
		   parent.member.location.href="<%=request.getContextPath()%>/b2bair!toTicket.action";
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
<body>
<div id="wrap">

<!--头部信息 begin -->
<div class="header">
    <div class="top2">
          <div class="logo"><img src="img/logo2.png" width="232" height="49" /></div>
          <div class="welcome">图乐之旅欢迎您！<span><img src="img/admin.png" width="17" height="15" /></span><a href="#"><ww:property value="#session.loginuser.loginname" /></a><a href="#" onClick="logout();">[退出]</a>
          </div>
    </div>

    <div class="nav2">
        <div class="guanbi">折叠左侧列表</div>
        <!--
        <ul>
            <li class="train-ticket"><a href="#">火车票</a></li>
            <li class="plane-ticket"><a href="#">飞机票</a></li>
            <li class="hotel"><a href="#">酒店</a></li>
            <li class="insu"><a href="#">保险</a></li>
        </ul>
        -->
        <ul>
        <ww:iterator value="#request.topmenulist" status="kk">
            <li class="<ww:property  value="code"/>"><a href="#" onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main_tulue/left.jsp',<ww:property  value="id"/>,0)><ww:property value="name" /></a></li>
        </ww:iterator>
         
        </ul>
        
        <div class="QQ"><a href="login!tokefu.action" target="member"><img src="img/QQ.png" width="107" height="28" /></a></div>

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
}</script>