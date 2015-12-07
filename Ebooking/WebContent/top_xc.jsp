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
<jsp:include page="head.jsp"></jsp:include>
<title></title>
</head>

<body>
 <div class="cui_hd_cont">
    	<div class="cui_hd" id="cui_hd">
		<!--logo-->
		<h1 class="">
		<img src="images/${logosrc}" width="175px" height="114px" />
		
		</h1>
		<!--help center & weibo & multi lang-->
		<div class="cui_toolkit">
		
			
			<!--
			<a href="#" rel="nofollow"  class="cui_help">客服中心</a>
			|
			<a href="http://weibo.com/ctrip/" rel="nofollow" class="cui_weibo" target="_blank">关注携程</a>
			   |
			<a class="cui_lang_en" href="http://english.ctrip.com/" rel="nofollow">English</a>
			
         
            |
			<div class="cui_lang"  onmouseover="this.className='cui_lang cui_lang_hover'" onmouseout="this.className='cui_lang'">
				<b></b>
				<div class="cui_lang_list">
					<a class="cui_lang_gb" href="http://www.ctrip.com/">简体版</a>
					<a href="http://big5.ctrip.com/" class="cui_lang_big5" rel="nofollow">繁体版</a>
					<a class="cui_lang_jap" href="http://jp.ctrip.com/" rel="nofollow">日语版</a>
					<a class="cui_lang_korea" href="http://kr.ctrip.com/" rel="nofollow">韩语版</a>
					<a href="http://de.ctrip.com/" class="cui_lang_de" rel="nofollow">Deutsch</a>
					<a href="http://fr.ctrip.com/" class="cui_lang_fr" rel="nofollow">Fran&#231;ais</a>
					<a href="http://es.ctrip.com/" class="cui_lang_es" rel="nofollow">Espa&#241;ol</a>
					<a href="http://ru.ctrip.com/" class="cui_lang_ru" rel="nofollow">Русский</a>
				</div>
              
			</div>
              -->
		</div>
		<!--telphone & mobile-->
		<div class="cui_tel" onmouseover="this.className='cui_tel cui_tel_hover'" onmouseout="this.className='cui_tel'" onclick="this.className='cui_tel cui_tel_hover'">
			<b></b>
			<span class="cui_tel_in" title="免境内长话费">客服：<i style="color: red">${tel}</i></span>
			<div class="cui_tel_more">
				<span class="cui_tel_in" title="座机拨打">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
			</div>
		</div>
		<!--wireless-->
		<div class="cui_wireless">|<a href="#" rel="nofollow">携程无线</a>
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