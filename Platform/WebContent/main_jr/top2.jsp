<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="../js/jquery1.3.2.js"></script>
<script src="../js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${dns.companyname}旅游频道—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}


	function a(el,url,id,type)
	{
	
	
	// $("a[id*='alink_']").each(function(i)
    //          {
    //             $(this).css("color","#fff");
    //          });
	//	el.style.color="#003399";
		if(type==0)
		{
		  parent.left.location.href=url;
		 // parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		  parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1";
		}
		else
		{
		  parent.left.location.href="login!getMemberByOrder.action?new&puser&ywtype=2";
		  //parent.member.location.href="<%=request.getContextPath()%>/login!towelcome.action";
		   parent.member.location.href="<%=request.getContextPath()%>/login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1";
		}
	}
//-->


//加载订单信息

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
			var message=eval("analytic("+data+")");
			
		
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
//alert("tuiticket:"+tuiticket+",feiticket:"+feiticket+",gaiqianticket:"+gaiqianticket);

$("#tp").html(tuiticket);
$("#fp").html(feiticket);
$("#gq").html(gaiqianticket);
$("#dcp").html(daichupiao);//待出票
</ww:if>
}


window.setInterval(onlod,'60000');



</script>
</head>

<body onload="MM_preloadImages('images/main_07_1.gif','images/main_08_1.gif','images/main_10_1.gif','images/main_11_1.gif','images/main_12_1.gif','images/main_13_1.gif','images/main_14_1.gif');onlod();">

<div style="width:100%;height=83;position: fixed;z-index:9999;">
	
	<img src="../login/crsys_bjhzht/logo6/logo.gif"   height="83" border=0>
	
		<!--<img src="images/qixing_logo.png"   height="83" border=0>
	-->
</div>

<ww:if test="getLoginsessionagent().agenttype==1">
<div style="width:100%;height=57;position: fixed;margin-top: 4px;color: white;" >


	<div style="float: right;">
		<a href="../b2bticketorder.action?s_orderstatus=2&ty=1" style="text-decoration:none;color: white;" target="member">待出票(<span id="dcp">10</span>)</a>
		待支付(<span>10</span>)
		已出票(<span>10</span>)
	</div>
	
	<div style="float: right;" >
	
	<span style="color: white;"><b>订单状态:</b></span>
		<a href="../b2bticketorder.action?s_orderstatus=4&ty=12&" style="text-decoration:none;color: white;" target="member">申请退票(<span id="tp">10</span>)</a>
		<a href="../b2bticketorder.action?s_orderstatus=5&ty=3&" style="text-decoration:none;color: white;" target="member">申请废票(<span id="fp">10</span>)</a>
		<a href="../b2bticketorder.action?s_orderstatus=13&ty=9&" style="text-decoration:none;color: white;" target="member">申请改签(<span id="gq">10</span>)</a>
	</div>
</div>
</ww:if>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tr >
    
	<td height="83" background="images/main_02.gif">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr><td  height="40">&nbsp;</td></tr>
			<tr><td  height="40">&nbsp;</td></tr>
		  </table>
	</td>
	
	
  </tr>
  <!--
  <tr>
    <td height="57" background="images/main_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="110" height="57" background="images/main_01.gif">&nbsp;</td>
        <td><table width="743" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr >
            <td height="28" background="images/main_03.gif" >
             </td>
          </tr>
          <tr>
            <td height="29">
           
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
               
                <td width="74"><a href="../b2bairsearch.action" style="color: white;text-decoration:none;" target="member">航班查询</a></td>
                <td width="74"><a href="../airsearch!toimportpnr.action?importtype=1&s_orderstatuspnr=&isinter=0" style="color: white;text-decoration:none;" target="member">PNR导入</a></td>
                <td width="55"><a href="http://www.feeyo.com/terminal/ShowFree.asp" style="color: white;text-decoration:none;" target="member">航站楼</a></td>
                <td width="">&nbsp;</td>


                <td width="39">&nbsp;</td>
                <td ></td>
                 
                <td width="74"><a href="../login!toeditpassword.action" style="color: white;text-decoration:none;" target="member">修改密码</a></td>
                <td width="74"><a href="../login!towelcome.action" style="color: white;text-decoration:none;" target="member">在线客服</a></td>
                 <td width="74"><a href="../login!towelcome.action" style="color: white;text-decoration:none;" target="member">平台公告</a></td>
               
              </tr>
            </table>
            
            </td>
          </tr>
        </table></td>
        <td width="102" background="images/main_05.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  -->
  <tr>
    <td height="26" background="images/main_18.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" height="26" background="images/main_16.gif">&nbsp;</td>
        <td>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td width="90" height="23" style="color: red;">
           <!--<b>功能菜单:</b>
           --></td>
           <ww:iterator value="#request.topmenulist" status="kk">

			
		<td width="90" height="23" valign="bottom">
            
            <table width="90" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="20" style="background:url(images/topbg.gif); border:solid 1px #a6d0e7; font-size:12px; color:#2b7dbb;"><div align="center"><img src="images/001.gif" width="10" height="10" />
<a class="ddt" name='pt<ww:property  value="id"/>'
				id='alink_<ww:property value="#kk.index"/>'  href="javascript:void(0)"; style="text-decoration:none;"
				onclick=a(this,'customeruser!leftmenu.action?rightid=<ww:property  value="id"/>&forward=main/left.jsp',<ww:property  value="id"/>,0) />
				<b><ww:property value="name" /></b>
				</a>
</div></td>
              </tr>
            </table>
          </td>
			
			
		 </ww:iterator>
           
           
            <td valign="bottom">&nbsp;</td>
          </tr>
          
        </table></td>
        <td width="350"><img src="images/user.gif" width="10" height="10" /> 
        <span class="STYLE1">欢迎您:<ww:property value="#session.loginuser.loginname" />  
        单位:<ww:property value="getangname(#session.loginuser.agentid)" />
        </span>
        
        <span>
        <a href="#"><input type="button" value="退出" onclick="logout();" /></a>
        </span>
        
        </td>
      </tr>
    </table></td>
  </tr>
</table>


</body>
</html>
<script>
function red(){ 
//alert($("#tp").html());
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
setTimeout("red()",1000); 
} 
red(); 
function logout(){
window.location.href="login!logout.action";
window.close();
}
</script>
