<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>


<%!
int index =0;
%>
<%!int subindex=0; %>
<%
try{
	 index = Integer.parseInt(request.getParameter("index"));
	 subindex =  Integer.parseInt(request.getParameter("subindex"));
	
}catch(Exception e){
}	
%>



<%!public String setIndex(int aindex){
	String ret = "";
	if(index == aindex){
		ret =" class=\"cui_nav_current\" ";
	}
	return ret;
}
%>
<%!public String setSubIndex(int aindex,int asubindex){
	String ret = "";
	if(index == aindex && subindex==asubindex){
		ret =" style=\"color: blue;\" ";
	}
	
	return ret;
}
%>
<%!public String setSubIndexDiv(int aindex,int asubindex){
	String ret = "<div style='margin-top:51px;'></div>";
	if(1 == aindex && 1==asubindex){
		ret ="";
	}
	
	return ret;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/top.css">
<link href="skin/black/css/qq.css" rel="stylesheet" type="text/css" />
<jsp:include page="head.jsp"></jsp:include>
<title></title>
</head>

<body>

<div class="qqbox" id="divQQbox" style="z-index: 9999999999999">
  <div class="qqlv" id="meumid" style="display:none;" onmouseover="show()"><img src="images/aqq.gif"></div>
  <div class="qqkf" style="z-index: 9999999999999"  id="contentid">
    <div class="qqkfbt" onmouseout="showandhide('qq-','qqkfbt','qqkfbt','K',5,1);" id="qq-1" onfocus="this.blur();">客 服 中 心</div>
    <div id="K1">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1656766607"><img src="images/qq.gif" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2747335527"><img src="images/qq.gif" border="0">在线客服</a></div>
      <div class="bgdh">010-57043667</div>
    </div>
    <div class="qqkfbt" onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,2);" id="qq-2" onfocus="this.blur();">国 内 机 票</div>
    <div id="K2" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1397088531"><img src="images/qq.gif" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2910207919"><img src="images/qq.gif" border="0">在线客服</a></div>
      <div class=" bgdh">010-57043668</div>
    </div>
    <div class="qqkfbt"  onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,3);" id="qq-3" onfocus="this.blur();">国 内 酒 店</div>
    <div id="K3" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2720923906"><img src="images/qq.gif" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2076420405"><img src="images/qq.gif" border="0">在线客服</a></div>
      <div class=" bgdh">010-57043669</div>
    </div>
    <div class="qqkfbt"  onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,4);" id="qq-4" onfocus="this.blur();">渠 道 咨 询</div>
    <div id="K4" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2747335527"><img src="images/qq.gif" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1397088531"><img src="images/qq.gif" border="0">在线客服</a></div>
      <div class=" bgdh">010-57043670</div>
    </div>
    <div class="qqkfbt" onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,5);" id="qq-5" onfocus="this.blur();">投 诉 建 议</div>
    <div id="K5" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2910207919"><img src="images/qq.gif" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=2076420405"><img src="images/qq.gif" border="0">在线客服</a></div>
      <div class=" bgdh">010-57043694</div>
    </div>
  </div>
</div>


<div id="top">
<div class="inside_top clearfix">
<form method="get" action="" id="login_form">
<div class="" id="login_bar"><span class="top_hello ie6Text">您好，欢迎使用<b>www.hqpw88.com</b>访问环球网
！</span> <ww:if test="#session.loginuser==null">
	<a id="" href="login!toMyCenter.jspx">登录</a>
 &nbsp; <a id="" href="login!toRegsit.jspx"> 注册</a>
 </ww:if><ww:else><ww:property value="#session.loginuser.loginname" /></ww:else>
 </div>
</form>


<div  id="logged_bar"><a rel="nofollow"
	class="account_id" href="#" id="user_name"></a> <span
	class="top_hello_u ie6Text">，您好</span>
<div class="memberInfo" id="memberLevelInfo"></div>
客服：<i style="color: red">${tel}</i>
</div>


<div class="express_anchor">
<div class="ea_mytc" id="myTc">
<div style="width: 62px" class="set_float" id="myTcTitle"><span
	class="mytc_span"><a rel="nofollow" href="#">我的环球</a></span> <span
	class="mytcDown mytcSelft" id="myTcArrow"></span></div>
<div class="none" id="ea_mytc_ul_backdrop"
	style="width: 76px; display: none;"></div>
<ul class="none" id="ea_mytc_ul" style="width: 74px; display: none;">
	<li id="hojpOrder"><a rel="nofollow" href="#">我的订单</a></li>
	<li><a rel="nofollow" href="#">我的收藏</a></li>
	<li><a rel="nofollow" href="#">修改密码</a></li>
	<li><a rel="nofollow" href="#">我的等级</a></li>
</ul>
</div>
<a target="_blank" title="帮助中心" href="#" rel="nofollow"
	class="ea_help ie6Text">帮助</a>
<div class="ea_mytc" id="myBookMark">
<div id="bookMark" class="ea_collect"><a id="colectTc"
	href="javascript:void(0)">收藏本站</a> <span class="mytcDown mytcTop"
	id="myBookArrow"></span></div>
<div class="top_book_backdrop" id="bookBackDrop" style="display: none;"></div>
<ul class="ea_mytc_ul ea_colect_ul" id="myBookUl" style="display: none;">
	<li><a id="colectDesktop" target="_blank" href="#">收藏到桌面</a></li>
</ul>
</div>
<div class="weiXinLink" id="tcWeiXin" style="z-index: 99999999999999999999">
<span class="weiXinLinkBg">微信我们</span>

 <span
	style="display: none;z-index: 99999999999999;" class="weiXinMsg" id="tcWeiXinMsg" onmouseout="hidediv('tcWeiXinMsg');">环球网微信号：<em>tc2004</em><br>
或直接扫描右侧二维码

</span>


</div>
<!-- email start-->
<div id="tcEmailAction" class="emailLink none"><a
	href="javaScript:void(0);" class="emailLinkBg" title="完善邮箱">完善邮箱</a> <span
	id="tcEmailText" class="emailLinkMsg">亲，现在完善并验证邮箱将获得<em>100</em>成长值哦<br />
<a title="立即完善"
	href="http://member.17u.cn/SecurityCenter/UpdateEmail.aspx">立即完善>></a></span>
<span class="emailLinkIco"></span></div>
<!-- email end -->
<div class="ea_mytc ea_myTel" id="myTel"><span
	id="littletelephone_outer" title="收当地市内话费" class="top_tele"
	style="display: none;"> <span class="icon_tele"></span><span
	id="littletelephone">4007-777-777</span> <span class="mytcDown mytcTop"
	id="myTelArrow1"></span> </span>
<div class="top_tele_backdrop" id="top_tele_backdrop"
	style="display: none;"></div>
<div class="ea_mytc_ul_backdrop" id="ea_mytel_ul_backdrop"
	style="display: none;"></div>

<ul class="ea_mytc_ul" id="ea_mytel_ul" style="display: none;">
	<li>海外电话：+86-512-8220-9000</li>
</ul>
</div>
</div>
</div>
</div>

 <div class="cui_hd_cont" >


    	<div class="cui_hd" id="cui_hd">
		<h1 class="">
		<img src="images/${logosrc}" width="175px" height="114px" />
		</h1>
		<div class="cui_toolkit" align="center">
			<img src="images/index/index_hqpw.jpg" width="620px" height="78px" />
			
		</div>
		
		<!--telphone & mobile-->
		<!--<div class="cui_tel" onmouseover="this.className='cui_tel cui_tel_hover'" onmouseout="this.className='cui_tel'" onclick="this.className='cui_tel cui_tel_hover'">
			<b></b>
			<span class="cui_tel_in" title="免境内长话费">客服：<i style="color: red">${tel}</i></span>
			<div class="cui_tel_more">
				<span class="cui_tel_in" title="座机拨打">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
			</div>
		</div>
		-->
		<!--wireless-->
	<div class="cui_wireless" style="margin-top: -9px;"><h1 class="">
		<img src="images/index/hq_weixin.jpg" width="128px" height="94px" />
		</h1>
		</div>
		
	</div>
  </div>
	    <!--nav-->
        <!-- 头部开始 -->       
	    <div id="cui_nav" class="cui_nav_single">
		<div class="base_nav" align="left">
			<ul class="cui_nav">
				<li id="cui_nav_home" <%= setIndex(0)%>>
					<a href="" class="cui_nav_non"  title="首页"><span>首页</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_flight" <%= setIndex(1)%>>
					<a href="ticticket!toTicket.jspx" class="cui_nav_flight cui_nav_has" title="机票预定"><span>机票预定</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="ticticket!toTicket.jspx" <%= setSubIndex(1,1)%>  title="国内机票">国内机票</a>|<a href="international!toInterNational.jspx" <%= setSubIndex(1,2)%> title="国际机票">国际机票</a></div></div>
				</li>
				
				<li class="sep"></li>
				<li id="cui_nav_hotel" <%= setIndex(2)%>>
					<a href="hotel!toindex.jspx" class="cui_nav_hotel cui_nav_has" title="酒店预定"><span>酒店预定</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="hotel!toindex.jspx" <%= setSubIndex(2,1)%> title="国内酒店">国内酒店</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_vac" <%= setIndex(3)%>>
					<a href="spotticket.jspx" class="cui_nav_vac cui_nav_has" title="旅游预定"><span>旅游预定</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="spotline.jspx" title="旅游首页">旅游首页</a>|<a href="spotline.jspx" title="国内线路">国内线路</a>|<a href="spotticket.jspx" title="门票">门票</a>|<a href="buying.jspx" title="团购">团购</a>|<a href="#" title="签证">签证</a></div></div>
				</li>
				
				<li class="sep"></li>
				<li id="cui_nav_trains" <%= setIndex(4)%>>
					<a href="huoche.jsp" class="cui_nav_non" title="火车票"><span>火车票</span></a>
				</li>
				
				<li class="sep"></li>
				<li id="cui_nav_trains" <%= setIndex(8)%>>
					<a href="zuche.jsp" class="cui_nav_non" title="在线租车"><span>租车</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_trains" <%= setIndex(7)%>>
					<a href="bm.jsp" class="cui_nav_non" title="便民服务"><span>便民服务</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_trains" <%= setIndex(9)%>>
					<a href="cp.jsp" class="cui_nav_non" title="彩票"><span>彩票</span></a>
				</li>


				<li class="sep"></li>
				<li id="cui_nav_trains" <%= setIndex(10)%>>
					<a href="qcp.jsp" class="cui_nav_non" title="汽车票"><span>汽车票</span></a>
				</li>
<!--
				<li class="sep"></li>
				<li id="cui_nav_destination" <%= setIndex(5)%>>
					<a href="index!toinformation.jspx" class="cui_nav_non" title="资讯中心"><span>资讯中心</span></a>
				</li>
	
				<li class="sep"></li>
				<li id="cui_nav_lpk" <%= setIndex(6)%>>
					<a href="index!tohelp.jspx" title="帮助中心" class="cui_nav_non"><span>帮助中心</span></a>
				</li>-->
				
				<li class="sep"></li>
				<li id="cui_nav_more">
					<a href="#" class="cui_nav_more cui_nav_has" title="更多" rel="nofollow"><span>更多</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="#" title="积分奖励" rel="nofollow">积分奖励</a>|<a href="#" title="特卖汇" rel="nofollow">特卖汇</a>|<a href="#" title="合作卡" rel="nofollow">合作卡</a>|<a href="#" title="订餐" rel="nofollow">订餐</a></div></div>
				</li>
				
				
				
				<ww:if test="#session.loginuser!=null">
				<li class="sep"></li>
				<li id="cui_nav_sl" <%= setIndex(-1)%>>
					<a href="login!toMyCenter.jspx" title="个人中心" class="cui_nav_non"><span>个人中心</span></a>
				</li>
				</ww:if>
				<li class="sep"></li>
				<li id="cui_nav_sl">
					<a  href="http://b2b.hqpw88.com/Platform" title="代理登陆" class="cui_nav_non"><span>代理登录</span></a>

				</li>

				<li class="sep"></li>
				<li id="cui_nav_sl">
<!--
					<a  href="index!toplanserver.jspx" title="团队/包机" class="cui_nav_non"><span>团队/包机</span></a>
-->
				</li>
                
                
                <li id="loginDivLi" class="cui_myctrip">
                <!--
					<a class="cui_myctrip_status" href="http://my.ctrip.com/home/myinfo.aspx" rel="nofollow">我的携程</a>
					<div id="usernameId" class="cui_myctrip_username"></div>
					<b></b>-->
					<div class="cui_myctrip_lr">
					<ww:if test="#session.loginuser==null">
						<a id="loginBtn1" href="login!toMyCenter.jspx" class="cui_links_login" rel="nofollow">登录</a>|<a href="login!toRegsit.jspx" class="cui_links_reg" rel="nofollow">注册</a>
					</ww:if><ww:else>
						<a href="login!loginout.jspx" class="cui_links_login">退出</a>
					</ww:else>	
					</div>
					<!--登录后-->
				</li>
				
			</ul>
		</div>
	</div>
	 <%= setSubIndexDiv(index,subindex)%>
      
       
        <script type="text/javascript">
            ; (function () { var D = document, $ = function (id) { return D.getElementById(id) }, st = null, st2 = null, lazyTime = 0, lis = [$('cui_nav_hotel'), $('cui_nav_vac'), $('cui_nav_flight'), $('cui_nav_more')], E = { 'onmouseenter': function (o, f) { if (D.all) { o.onmouseenter = f } else { o.onmouseover = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'onmouseout': function (o, f) { if (D.all) { o.onmouseleave = f } else { o.onmouseout = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'addEvent': function (el, type, handler) { if (el.addEventListener) { el.addEventListener(type, handler, false) } else if (el.attachEvent) { el.attachEvent("on" + type, handler) } else { el["on" + type] = handler } } }, F = { 'setTime': function () { E.onmouseenter($('cui_nav'), function () { setTimeout(function () { lazyTime = 150 }, 30) }); E.onmouseout($('cui_nav'), function () { lazyTime = 0 }) }, 'initEvent': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; E.onmouseenter(lis[j], function () { F.interFn(lis[j]) }); E.onmouseout(lis[j], function () { F.outerFn(lis[j]) }) })(i) } }, 'reset': function () { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { lis[i].className = '' } } }, 'padReset': function (j) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { if (i !== j) { lis[i].className = '' } } } }, 'interFn': function (obj) { if (st2 != null) { clearTimeout(st2); st2 = null } st = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { } else { obj.className = 'cui_nav_o' } }, lazyTime) }, 'outerFn': function (obj) { if (st != null) { clearTimeout(st); st = null } st2 = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { obj.className = 'cui_nav_current' } else { obj.className = '' } }, 250) }, 'initMobile': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; var oneLevel = lis[j].getElementsByTagName('A')[0]; oneLevel.href = '###'; oneLevel.onmousedown = function () { F.padReset(j); if (lis[j].className.indexOf('cui_nav_current') === -1) { if (lis[j].className.indexOf('cui_nav_o') > -1) { lis[j].className = ''; oneLevel.style.visibility = 'hidden'; setTimeout(function () { oneLevel.style.visibility = 'visible' }, 10) } else { lis[j].className = 'cui_nav_o' } } } })(i) } }, 'contains': function (target) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].compareDocumentPosition(target) - 19 > 0) { return true } } return false } }; if ($('headStyleId')) { $('headStyleId').parentNode.removeChild($('headStyleId')) } if (/ip(hone|od)|ipad/i.test(navigator.userAgent)) { F.initMobile(); E.addEvent(D.body, 'click', function (e) { var target = e.target || e.srcElement; if (!F.contains(target)) { F.reset() } }) } else { F.setTime(); F.initEvent() } })();
        </script>
        <!-- header end-->
        <!-- 头部开结束 -->

</body>
</html>
<script type="text/javascript">
function showdiv(id){

$('#'+id).show();

}
function hidediv(id){

$('#'+id).hide();

}

</script>
<script language="javascript">
function showandhide(h_id,hon_class,hout_class,c_id,totalnumber,activeno) {
    var h_id,hon_id,hout_id,c_id,totalnumber,activeno;
    for (var i=1;i<=totalnumber;i++) {
        document.getElementById(c_id+i).style.display='none';
        document.getElementById(h_id+i).className=hout_class;
    }
    document.getElementById(c_id+activeno).style.display='block';
    document.getElementById(h_id+activeno).className=hon_class;
}
var tips; 
var theTop = 100;
var old = theTop;
function initFloatTips() 
{ 
	tips = document.getElementById('divQQbox');
	moveTips();
}
function moveTips()
{
	 	  var tt=50; 
		  if (window.innerHeight) 
		  {
		pos = window.pageYOffset  
		  }else if (document.documentElement && document.documentElement.scrollTop) {
		pos = document.documentElement.scrollTop  
		  }else if (document.body) {
		    pos = document.body.scrollTop;  
		  }
		  //http:
		  pos=pos-tips.offsetTop+theTop; 
		  pos=tips.offsetTop+pos/10; 
		  if (pos < theTop){
			 pos = theTop;
		  }
		  if (pos != old) { 
			 tips.style.top = pos+"px";
			 tt=10;//alert(tips.style.top);  
		  }
		  old = pos;
		  setTimeout(moveTips,tt);
}
initFloatTips();
//	if(typeof(HTMLElement)!="undefined")//给firefox定义contains()方法，ie下不起作用
//		{  
//		  HTMLElement.prototype.contains=function (obj)  
//		  {  
//			  while(obj!=null&&typeof(obj.tagName)!="undefind"){//
//	   　　 　if(obj==this) return true;  
//	   　　　	　obj=obj.parentNode;
//	   　　	  }  
//			  return false;  
//		  }
//	}
function show()
{
	document.getElementById("meumid").style.display="none"
	document.getElementById("contentid").style.display="block"
}
	function hideMsgBox(theEvent){
	  if (theEvent){
		var browser=navigator.userAgent;
		if (browser.indexOf("Firefox")>0){//Firefox
		    if (document.getElementById("contentid").contains(theEvent.relatedTarget)) {
				return
			}
		}
		if (browser.indexOf("MSIE")>0 || browser.indexOf("Presto")>=0){
	        if (document.getElementById('contentid').contains(event.toElement)) {
			    return;//结束函式
		    }
		}
	  }
	  document.getElementById("meumid").style.display = "block";
	  document.getElementById("contentid").style.display = "none";
 	}
</script>