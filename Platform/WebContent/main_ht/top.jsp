<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-首页</title>
<!-- <style>
#container{ background:url(/gx_website/skin/blue/../images/bj_index.gif) repeat-x;}
</style> -->
</head>
<body>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易订行商旅平台—-商旅平台，机票酒店分销，政策齐全，返点高-V3.1.3</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/new.css" type="text/css" rel="stylesheet" />
<style type="text/css"> 
li.tip span {
	color:#ff9955;
	}
</style>
 
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script src="../js/jquery.messager.js"></script>
<script type="text/javascript" src="../js/js_new/jquery.js"></script>
<script type="text/javascript" src="../js/jQuery.textSlider.js"></script>
 
<script> 
function SlyarErrors() { 
	return true;
} 
window.onerror = SlyarErrors;
	$(document).ready(function (){
		 $("#b6d").click(function(){
			
			var t = ( parseInt( $("#bbb").css('margin-left'))+93)+'px';
			
			if( parseInt( $("#bbb").css('margin-left')) < 0)
			{
				$("#bbb").animate({'margin-left':t},"fast");
			}
		});
 
		 $("#b5d").click(function(){
			
			var t = (parseInt( $("#bbb").css('margin-left'))-93)+'px';
			var maxlenght=(parseInt($("#menucount").val())-7)*100;
			if( parseInt( $("#bbb").css('margin-left')) >= -maxlenght)
			{
				$("#bbb").animate({'margin-left':t},"fast");
			}
		});
		
		$("#scrollDiv2").textSlider({line:1,speed:500,timer:3000});
		//加载订单信息
		
	});
</script>
<script><!--
    //type 0代表直接点击导航菜单进行的跳转，1代表点击快捷入口自动切换导航菜单
    //目的：点击快捷入口时，导航菜单能自动切换
    //edited by sunbin
	function a(el,url,id,type)
	{
	 $("a[id*='alink_']").each(function(i)
              {
                 $(this).css("color","#fff");
              });
		el.style.color="#003399";
		if(type==0)
		{
		  parent.left.location.href=url;
		  parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		 
		}
		else
		{
		  parent.left.location.href="login!getMemberByOrder.action?new&puser&ywtype=2";
		  parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		}
	}
	function initcss()
	{	
	    $("a[id*='alink_']").each(function(i)
              {
                 $(this).css("color","#fff");
              });
	   document.getElementById("alink_0").style.color="#003399";
	}
	function link(url)
	{
	  parent.mainFrame.location.href=url;
	}
    function logout(){
  //  window.parent.location.href='employee!loginout.action';
	 window.parent.parent.location.href="../login!logout.action";
    }
    function ShowTime1() 
	{ 
		var date=new Date(); 
		var year=date.getFullYear(); 
		var month=date.getMonth()+1; 
		var day=date.getDate(); 
		var hour=date.getHours(); 
		var minutes=date.getMinutes(); 
		var second=date.getSeconds(); 
		var timestr=year+"年"+month+"月"+day+"日 "+check(hour)+":"+check(minutes)+":"+check(second); 
		document.getElementById("stime").innerHTML=""+timestr;
		var timerID=setTimeout("ShowTime1();",1000);//这里要执行的代码就是函数本身，这样这个函数就可以不断重复的执行了！ 
	}
	function check(val){ 
		if (val<10){ 
		return("0"+val);//参数小于10时，在前面补0 
		}else{ 
		return(val); 
		} 
    }
    
    //航班变更定时执行 30分钟执行一次
function getFlightChg()
{
    //setInterval("searchflightchg();",1800000);
    ///setInterval("autoRepNumber();",3600000);
    //setInterval("autoCloseOrder();",86400000); //86400000 24小时执行一次
} 
function searchflightchg()
{
   var url="orderinfo!getFlightChange.action";
		var params = {s_status:2};
		var air ;
		jQuery.post(url,params, function(data) 
		{
		  if (data !='') {
			air = data;
            if(air!='0' && air!='Q EMPTY')
            {
               document.getElementById("imgemail").src="../images/email2.gif";
		       $("#emaillink").click();
              
		   }
		   
		  }
		});
}  
 
 
function autoRepNumber()
{
    var url="passenger!autocompRepNum.action";
		var params = {s_status:2};
		var air ;
		jQuery.post(url,params, function(data) 
		{
		  if (data !='') {
		  }
		});
}
//自动关闭订单
function autoCloseOrder(){
    
}
 
function aaa(id){
      $("a[id*='alink_']").each(function(i)
              {
                 $(this).css("color","#fff");
              });
           //  alert($("a[name='pt"+id+"']").name);
			$("a[name='pt"+id+"']").css("color","#003399");
}
 
//获取头部公告信息 
$(document).ready(function(){
		var url="login!ajaxnoticemessage.action";
		$.post(url, function(data) {
         $("#notice").html(data);
          });
 
	
}
);
//加载订单信息
 
function onlod(){
	showMessage();
	//comticketremaind();
}
function showMessage() {
		var url="orderinfo!getOrderCount.action?rndmath="+Math.floor(Math.random()*100);
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
			if (data != '') {
			var message=eval("analytic("+data+")");
			}
		});
	}
var videosrc='ding.wav';
//解析提示数据
function analytic(ticket){
var dingling=false;
var img="<img src='../imagess/gif-0242.gif'>";
 
var requesttf=ticket.returnticket;
var requesttfhtml="<a href='b2bticketorder!refundlist.action?airform.changestatus=1' style='color:#fff' target='member'>申请退废(<strong><span style='color:#f48000'>"+requesttf+"</span></strong>)</a>";
if(requesttf>0){
requesttfhtml+=img;
dingling=true;
}
$("#or5").html(requesttfhtml);
 
var requestc=ticket.changeticket;
var requestchtml="<a href='b2bticketorder!alteationlist.action' style='color:#fff' target='member'>申请变更(<strong><span style='color:#f48000'>"+requestc+"</span></strong>)</a>";
if(requestc>0){
requestchtml+=img;
dingling=true;
}
$("#or6").html(requestchtml);
var needc=ticket.needchangeticket;
var needchtml="<a href='b2bticketorder!alteationlist.action?airform.changestatus=8' style='color:#fff' target='member'>变更待处理(<strong><span style='color:#f48000'>"+needc+"</span></strong>)</a>";
if(needc>0){
requestchtml+=img;
dingling=true;
}else{
needchtml="";
}
$("#or3").html(needchtml);
 
 
var outticket=ticket.waitoutticket;//采购已支付
var overoutticket=ticket.overoutticket//已出票
var affirmticket=ticket.affirmticket;//待确认
 
  //  videosrc='newmessage.mp3';
var affhtml="<a href='b2bticketorder.action?s_orderstatus=27' target='member' style='color:#fff' target='member'>待确认(<strong><span style='color:#f48000'>"+affirmticket+"</span></strong>)</a>";
if(affirmticket>0){
dingling=true;
affhtml+=img;
}
$("#or1").html(affhtml);
var outhtml="<a href='b2bticketorder.action?s_orderstatus=2&ty=1' style='color:#fff' target='member'>采购已支付(<strong><span style='color:#f48000'>"+outticket+"</span></strong>)</a>";
if(outticket>0){
dingling=true;
outhtml+=img;
}
$("#or4").html(outhtml);
 
 
 
 
if(dingling){
$("#tiptitle").show();
$(document.body).prepend("<bgsound id='mainFrmSndShowWaHaha' loop='0' src='video/"+videosrc+"'></bgsound>");
 }
}
 
 
window.setInterval(onlod,'60000');
 
--></script>
</head>
 
<body onload="ShowTime1();initcss();onlod();">
<form action="login!logout.action" method="post">
<div id="header" lang="th" style="margin-top: 0px">
<div class="top">
 
<div class="f"><img src="../images/h.png" width="236" height="61"
	alt="商旅平台" style="margin-left: 20px;" /></div>
<div class="r" style="text-align: right">
<div class="time font-039"> 
    <span><img src="../images/ico_first.gif" width="27" height="30" align="absmiddle" /><a href="demosticticket.action" target="member">航班查询</a></span> 
    <span><img src="../images/ico_second.gif" width="27" height="30" align="absmiddle" /><a href="demosticticket!importpnr.action" target="member">PNR导入</a></span> 
    
    <span><img src="../images/ico_four.gif" width="27" height="30" align="absmiddle" /><a href="login!toservice.action" target="member">客服中心</a></span> 
    <span ><img src="../images/ico_first.gif" width="27" height="30" align="absmiddle" /><a href="http://www.feeyo.com/terminal/ShowFree.asp?FlightNumber=mu5169&submit=%A1%A1%B2%E9%A1%A1%D1%AF%A1%A1" target="member">航站楼查询</a></span> 
    <span id="tiptitle" style="display: none;"></span>
	<span class="tip" id="or1"></span>
	<span class="tip" id="or2"></span>
	<span class="tip" id="or3"></span>
	<span class="tip" id="or4"></span>
	<span class="tip" id="or5"></span>
	<span class="tip" id="or6"></span>
	<span style="display: none;" class="STYLE7" id="stime"></span>
	</div>
<ul class="screen">
	<li><img src="../imagess/bj_topl.gif" width="42" height="32" /></li>
	<li class="dddwai">
	<div id="bbb" style="margin-left:0;width:1558px; border:0;height:32px;float:left;">
    <input type="hidden" id="menucount" value='13' />
	
	<ul id="images">
		
		  <ww:iterator value="#request.topmenulist" status="kk">
			<li id='menulink_<ww:property value="#kk.index"/>'>
			<img src="../imagess/ico_people.gif" alt="picture"
			 width="20" height="32"	align="absmiddle" />
			<a class="ddt" name='pt28'
				id='alink_<ww:property value="#kk.index"/>'  href="javascript:void(0)";
				onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main/left.jsp',<ww:property  value="id"/>,0) />
				<ww:property value="name" />
				</a>
			</li>
			
		</ww:iterator>
		 
			
			
		
		<!-- <li>
			<img src="../imagess/ico_people.gif" alt="picture"
			 width="20" height="32"	align="absmiddle" />
			<a class="ddt" target="_blank" 
			 href="http://ssp.linkosky.com/UI/SPLogin.aspx">酒店预订</a>
		</li>	 -->	
	</ul>
	</div>
	</li>
	<li><img id="b6d" style="cursor: pointer;"
		src="../imagess/arr_l.jpg"  width="17" height="32"
		border="0" /></li>
	<li><img id="b5d" style="cursor: pointer;"
		src="../imagess/arr_r.jpg"  width="17" height="32"
		border="0" /></li>
	<li><img src="../imagess/bj_topr.gif" width="33" height="32" /></li>
	<li class="out r"><input type="button" onclick="logout();"
		class="button_out" name="aa" alt="退出" title="退出" /></li>
</ul>
<div class="c"></div>
</div>
<div class="c"></div>
<div class="noti">
<div class="notice">
<ul>
	<li><img src="../imagess/notice_l.gif" width="10" height="30" /></li>
	<li><a href="login!towelcome.action" target="member"><img
		src="../imagess/ico_index.gif" width="26" height="30" />首页</a></li>
	<li><img src="../imagess/dividing-line.gif" width="17" height="30" /><ww:property value="#session.loginuser.loginname" /> &nbsp;&nbsp;  <ww:property value="getangname(#session.loginuser.agentid)" /></li>
	
	
	<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	<li><img src="../imagess/ico_rebate.gif" width="24" height="30" /></li>
	<li><a href='../rebaterecord.action' target="member">查看预存款</a></li>
	
	<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	<li><a href="../login!toeditpassword.action" target="member" >修改密码</a></li>
	<!--<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	<li><a href="#" onclick="window.parent.parent.ShowDiv();">来电弹屏</a></li>-->
	<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
    <li style="margin-top:1px"><a href="../login!towelcome2.action?first=true" target="member"><img src="../images/bnt_zxkf10828.png" /></a></li>
    <li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	<li style="color:red;font-weight:bold">热线电话：400-888-8888</li>
 
	
	
	
    <!-- 
    <li><img src="../imagess/dividing-line.gif" width="10" height="30" /></li>
    <li>企业订单：
    <a target='member' href="airticket!airtickets.action?airticketform.orderstate=-1&airticketform.outmethod=1">待出票订单(<font id='comoutticket'>0</font>)</a>&nbsp;
    <a target='member' href="airticket!refundcancledticket.action?refundform.refundstate=1">申请退废(<font id='comrefundticket'>0</font>)</a></li>
     -->
    		
<!--<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	--><!--<li class="tip" id="or1"></li>
	<li><img src="../imagess/dividing-line.gif" width="17" height="30" /></li>
	<li class="tip" id="or2"></li>
	-->
 
</ul>
</div>
</div>
</div>
 
</div>
 
</form>
</body>
</html>
 
</body>