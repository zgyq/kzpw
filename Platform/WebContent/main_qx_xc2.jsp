<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.List"%>

<%@page import="com.yf.system.back.server.Server"%>
<%@page import="com.yf.system.base.customeruser.Customeruser"%>
<%@page import="com.yf.system.base.agentroleref.Agentroleref"%>
<%@page import="com.yf.system.base.systemright.Systemright"%>
<%@page import="com.yf.system.base.sysroleright.Sysroleright"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
a span {
	color:#ff9955;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<title>${dns.address}</title>
<script src="js/jquery1.3.2.js"></script>
<script src="js/jquery.messager.js"></script>
<script language=”javascript”>
function killErrors() {
    return true;
}
window.onerror = killErrors;
</script>
<script language="javascript">
<!-- //定义一个声音播放控制的function, 需注意Netscape和IE对script的解释各不相同
function MM_controlSound(sndAction,sndObj)
{ 　
  if(eval(sndObj) != null)
  { 　　
    if(navigator.appName=='Netscape')
    {
    　eval( sndObj+ ( (sndAction=='stop') ? '.stop()' : '.play(false)' ) ); 　　
    }
    else if(eval(sndObj+".FileName")) 　
 {
   eval(sndObj+((sndAction=='stop')?'.stop()':'.play()')); 　
    }
  }
}
//-->

function onlod(){


	showMessage();

}
	function showMessage() {
	
		var url="orderinfo!getOrderCount.action?rndmath="+Math.floor(Math.random()*100);
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
			
			if (data != '') {
			   var message=eval("analytic("+data+")");
			   
			   topFrame.eval("analytic("+data+")");
			   
			   // var messagess=eval("analyticc("+data+")");
			    //alert(message);
			  //  alert(messagess);
			   if(message!=''){
				$.messager.lays(300, 300);
				$.messager.anim('fade', 2000);
				
				$.messager.show('<font color="red" style="z-index: 10000;">系统提示</font>','<div color="red">'+message+'</div>', 10000);
				
				}
			}
		});
	}
//解析提示数据
function analytic(ticket){
	//restmsg="var ticket={waitoutticket:"+waitoutticket
	//		+",returnticket:"+returnticket+",invalidateticket:"+invalidateticket+",changeticket:"+changeticket+",affirmticket:"+affirmticket+"};";
var message="";	
	
var tuiticket=ticket.tuiticket;//申请退票
var feiticket=ticket.feiticket//申请废票
var gaiqianticket=ticket.gaiqianticket;//申请改签
var daichupiao=ticket.daichupiaoticket;//待出票
var daiqueren=ticket.daiquerenticket;//待确认
var daizhifu=ticket.daizhifuticket;//待支付
var qbnum=ticket.qbnum;//QB
var telnum=ticket.telnum;//tel

if(tuiticket>0){
message+="<a href='b2bticketorder.action?s_orderstatus=4&ty=12&' style='text-decoration:none;' target='member' ><h5>申请退票订单<strong><span>"+tuiticket+"</span></strong>张</h5></a>";
}
if(feiticket>0){
message+="<a href='b2bticketorder.action?s_orderstatus=5&ty=3&' style='text-decoration:none;' target='member' ><h5>申请废票订单<strong><span>"+feiticket+"</span></strong>张</h5></a>";
}
if(gaiqianticket>0){
message+="<a href='b2bticketorder.action?s_orderstatus=13&ty=9&' style='text-decoration:none;' target='member' ><h5>申请改签订单<strong><span>"+gaiqianticket+"</span></strong>张</h5></a>";
}
if(daizhifu>0){
message+="<a href='b2bticketorder.action?s_orderstatus=1&ty=1' style='text-decoration:none;' target='member' ><h5>待支付订单<strong><span>"+daizhifu+"</span></strong>张</h5></a>";
}
if(daichupiao>0){
message+="<a href='b2bticketorder.action?s_orderstatus=2&ty=1' style='text-decoration:none;' target='member' ><h5>待出票订单<strong><span>"+daichupiao+"</span></strong>张</h5></a>";
}
if(daiqueren>0){
message+="<a href='b2bticketorder.action?s_orderstatus=27&ty=1' style='text-decoration:none;' target='member' ><h5>待确认订单<strong><span>"+daiqueren+"</span></strong>张</h5></a>";
}
if(qbnum>0){
message+="<a href='ofcard!toQmoneyRechargeOrder.action?s_psystatus=1' style='text-decoration:none;' target='member' ><h5>QB待充值订单<strong><span>"+qbnum+"</span></strong>张</h5></a>";
}
if(telnum>0){
message+="<a href='ofcard!toRechargeOrder.action?s_psystatus=1' style='text-decoration:none;' target='member' ><h5>手机待充值订单<strong><span>"+telnum+"</span></strong>张</h5></a>";
}

return message;
}
//解析提示数据
function analyticc(ticket){
	//restmsg="var ticket={waitoutticket:"+waitoutticket
	//		+",returnticket:"+returnticket+",invalidateticket:"+invalidateticket+",changeticket:"+changeticket+",affirmticket:"+affirmticket+"};";
var messagess="";		
var tuiticket=ticket.tuiticket;//申请退票
var feiticket=ticket.feiticket//申请废票
var gaiqianticket=ticket.gaiqianticket;//申请改签
var daichupiao=ticket.daichupiaoticket;//待出票
var daizhifu=ticket.daizhifuticket;//待支付
if(tuiticket>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=27',28) ><h5>申请退票订单<strong><span>"+tuiticket+"</span></strong>张</h5></a>";
}
if(feiticket>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=2',10254) ><h5>申请废票订单<strong><span>"+feiticket+"</span></strong>张</h5></a>";
}
if(gaiqianticket>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=2',10254) ><h5>申请改签订单<strong><span>"+gaiqianticket+"</span></strong>张</h5></a>";
}
if(daichupiao>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=2',10254) ><h5>待出票订单<strong><span>"+daichupiao+"</span></strong>张</h5></a>";
}
return messagess;
}

function handleticket(url,id){
     topFrame.aaa(""+id+"");//头部导航选择
     //window.parent.frames.location.href="customeruser!foo.action?rightid="+id;//
     left.location.href='customeruser!leftmenu.action?rightid='+id+'&forward=left.jsp';
     member.location.href=url;
     
     
   }
window.setInterval(onlod,'30000');

</script>

</head>



<frameset rows="115,*,22" cols="*" frameborder="no" border="0" framespacing="0" onload="onlod();">
  <!-- top  -->
  <frame src="main_xc2/login!topmenu.action" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"  />
  <!-- middle -->
  <frameset rows="*" cols="210,6,*" framespacing="0" frameborder="0" border="false" id="mainFrame" scrolling="yes">
  
  <frame name="left"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0" src="main_xc2/customeruser!leftmenu.action?rightid=-1&forward=main_xc2/left.jsp">
    <frame name="middle" scrolling="no" frameborder="0" noresize="noresize"  src="main_xc/middle.jsp" />
    	<frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="wel_yplm/login!towelcome.action" />
    <!--
   	<frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/login!towelcome_xc.action" />
   	-->
   	<!--  
    <frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1" />
  -->
  <!--
  <frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/login!towelcome.action?first=true" />
	-->
</frameset>
<!-- bottom -->
  <frame src="main_xc2/bottom.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame"  />
</frameset>
<noframes>
  <body leftmargin="2" topmargin="0" marginwidth="0" marginheight="0" >

  <p>你的浏览器版本过低！！！本系统要求IE5及以上版本才能使用本系统。</p>
  </body>
</noframes>
</html>
