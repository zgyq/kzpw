<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

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
<title>华展宏图商旅网</title>
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
<%
Customeruser user = (Customeruser)session.getAttribute("loginuser");
String where = " where  " + Systemright.COL_id + " in ( select "
+ Sysroleright.COL_rightid + " from " + Sysroleright.TABLE
+ " where " + Sysroleright.COL_roleid + " in (select "
+ Agentroleref.COL_roleid + " from " + Agentroleref.TABLE
+ " where " + Agentroleref.COL_customeruserid + "="
+ user.getId() + ")) and "+Systemright.COL_type+" =2 and "+Systemright.COL_code+" ='xitongtixing'";
System.out.println("where=="+where);	
List list =Server.getInstance().getMemberService().findAllSystemright(where, "", -1, 0);
if(list.size()>0)
{
	%>
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
			   var message=eval("analytic("+data+")");
			    var messagess=eval("analyticc("+data+")");
			   if(message!=''){
				$.messager.lays(300, 150);
				$.messager.show('系统提示',"<table><tr><td>"+message+"</td><td></td><td>"+messagess+"</td></tr></table>", 10000);
				}
			}
		});
	}
//解析提示数据
function analytic(ticket){
	//restmsg="var ticket={waitoutticket:"+waitoutticket
	//		+",returnticket:"+returnticket+",invalidateticket:"+invalidateticket+",changeticket:"+changeticket+",affirmticket:"+affirmticket+"};";
var message="";		
var outticket=ticket.waitoutticket;
var returnticket=ticket.returnticket;
var invalidateticket=ticket.invalidateticket;
var changeticket=ticket.changeticket;
var affirmticket=ticket.affirmticket;
var overoutticket=ticket.overoutticket
if(affirmticket>0){
message+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=27',28) ><h5>待确认订单<strong><span>"+affirmticket+"</span></strong>张</h5></a>";
}
if(outticket>0){
message+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=2',10254) ><h5>已支付订单<strong><span>"+outticket+"</span></strong>张</h5></a>";
}
if(overoutticket>0){
message+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=2',10254) ><h5>已出票订单<strong><span>"+overoutticket+"</span></strong>张</h5></a>";
}
return message;
}
//解析提示数据
function analyticc(ticket){
	//restmsg="var ticket={waitoutticket:"+waitoutticket
	//		+",returnticket:"+returnticket+",invalidateticket:"+invalidateticket+",changeticket:"+changeticket+",affirmticket:"+affirmticket+"};";
var messagess="";		
var outticket=ticket.waitoutticket;
var returnticket=ticket.returnticket;
var invalidateticket=ticket.invalidateticket;
var changeticket=ticket.changeticket;
var affirmticket=ticket.affirmticket;
if(returnticket>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=4',10254)><h5>申请退票订单<strong><span>"+returnticket+"</span></strong>张</h5></a>";
}
if(invalidateticket>0){
messagess+="<a href='javascript:void(0) onclick=handleticket('b2bticketorder.action?s_orderstatus=5',10254)'><h5>申请废票订单<strong><span>"+invalidateticket+"</span></strong>张</h5></a>";
}
if(changeticket>0){
messagess+="<a href='javascript:void(0)' onclick=handleticket('b2bticketorder.action?s_orderstatus=13',10254) ><h5>申请改签订单<strong><span>"+changeticket+"<span></strong>张</h5></a>";
}
return messagess;
}

function handleticket(url,id){
     topFrame.aaa(""+id+"");//头部导航选择
     //window.parent.frames.location.href="customeruser!foo.action?rightid="+id;//
     left.location.href='customeruser!leftmenu.action?rightid='+id+'&forward=left.jsp';
     member.location.href=url;
     
     
   }
//window.setInterval(onlod,'30000');
	<%
}
%>
</script>

</head>




<frameset rows="92,*,30" cols="*" frameborder="no" border="0" framespacing="0">
  <!-- top  -->
  <frame src="main/login!topmenu.action" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"  />
  <!-- middle -->
  <frameset rows="*" cols="210,6,*" framespacing="0" frameborder="0" border="false" id="mainFrame" scrolling="yes">
  
  <frame name="left"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0" src="main/customeruser!leftmenu.action?rightid=-1&forward=main/left.jsp">
    <frame name="middle" scrolling="no" frameborder="0" noresize="noresize"  src="middle.jsp" />
  <frame name="member" scrolling="yes" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/login!towelcome.action?first=true" />
</frameset>
<!-- bottom -->
  <frame src="main/bottom.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame"  />
</frameset>
<noframes>
  <body leftmargin="2" topmargin="0" marginwidth="0" marginheight="0" >

  <p>你的浏览器版本过低！！！本系统要求IE5及以上版本才能使用本系统。</p>
  </body>
</noframes>
</html>
