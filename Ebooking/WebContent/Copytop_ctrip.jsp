<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
String type = request.getParameter("type");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="css/top.css">

<title>上海世贸汽车销售服务有限公司</title>
</head>

<body>
 <div class="cui_hd_cont">
    	<div class="cui_hd" id="cui_hd">
		<!--logo-->
		<h1 class="">
		<img src="images/gd_logo.png" width="175px" height="74px" />
		
		</h1>
		<!--help center & weibo & multi lang-->
		<div class="cui_toolkit">
			<a href="#" rel="nofollow" class="cui_help">客服中心</a>
			<!--|
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
			<span class="cui_tel_in" title="免境内长话费">国内：<i>1010-6666</i></span>
			<div class="cui_tel_more">
				<span class="cui_tel_in" title="座机拨打">国内：<i>800-820-6666</i></span>
				<span class="cui_tel_in">香港：<i>852-3610-6666</i></span>
				<span class="cui_tel_in">海外：<i>+86-21-3406-4888</i></span>
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
		<div class="base_nav">
			<ul class="cui_nav">
				<li id="cui_nav_home" class="cui_nav_current">
					<a href="" class="cui_nav_non" title="首页"><span>首页</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_hotel" class="cui_nav_current">
					<a href="http://hotels.ctrip.com" class="cui_nav_hotel cui_nav_has" title="酒店"><span>酒店</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="hotel!toindex.jspx" title="国内酒店">国内酒店</a>|<a href="hotel!toindex.jspx" title="海外酒店">海外酒店</a>|<a href="#" title="惠选酒店">惠选酒店</a>|<a href="# title="机+酒">机+酒</a>|<a href="#" title="团购">团购</a>|<a href="#" title="特价超市">特价超市</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_vac">
					<a href="http://vacations.ctrip.com" class="cui_nav_vac cui_nav_has" title="旅游"><span>旅游</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="#" title="旅游首页">旅游首页</a>|<a href="#" title="国内旅游">国内旅游</a>|<a href="#" title="出境旅游">出境旅游</a>|<a href="#" title="周边/当地游">周边/当地游</a>|<a href="#" title="邮轮">邮轮</a>|<a href="#" title="门票">门票</a>|<a href="#" title="用车">用车</a>|<a href="#" title="签证">签证</a>|<a href="#" title="欧铁">欧铁</a>|<a href="#" title="包团定制">包团定制</a>|<a href="#" title="鸿鹄逸游">鸿鹄逸游</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_flight">
					<a href="http://flights.ctrip.com" class="cui_nav_flight cui_nav_has" title="机票"><span>机票</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="ticticket!toTicket.jspx" title="国内机票">国内机票</a>|<a href="#" title="国际机票">国际机票</a>|<a href="#" title="机+酒">机+酒</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_trains">
					<a href="#" class="cui_nav_non" title="火车票"><span>火车票</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_destination">
					<a href="#" class="cui_nav_non" title="攻略社区"><span>攻略社区</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_lpk">
					<a href="#" title="礼品卡" class="cui_nav_non"><span>礼品卡</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_sl">
					<a href="#" title="商旅" class="cui_nav_non"><span>商旅</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_more">
					<a href="#" class="cui_nav_more cui_nav_has" title="更多" rel="nofollow"><span>更多</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="#" title="积分奖励" rel="nofollow">积分奖励</a>|<a href="#" title="特卖汇" rel="nofollow">特卖汇</a>|<a href="#" title="合作卡" rel="nofollow">合作卡</a>|<a href="#" title="订餐" rel="nofollow">订餐</a></div></div>
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
       
       
       
        <script type="text/javascript">
            ; (function () { var D = document, $ = function (id) { return D.getElementById(id) }, st = null, st2 = null, lazyTime = 0, lis = [$('cui_nav_hotel'), $('cui_nav_vac'), $('cui_nav_flight'), $('cui_nav_more')], E = { 'onmouseenter': function (o, f) { if (D.all) { o.onmouseenter = f } else { o.onmouseover = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'onmouseout': function (o, f) { if (D.all) { o.onmouseleave = f } else { o.onmouseout = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'addEvent': function (el, type, handler) { if (el.addEventListener) { el.addEventListener(type, handler, false) } else if (el.attachEvent) { el.attachEvent("on" + type, handler) } else { el["on" + type] = handler } } }, F = { 'setTime': function () { E.onmouseenter($('cui_nav'), function () { setTimeout(function () { lazyTime = 150 }, 30) }); E.onmouseout($('cui_nav'), function () { lazyTime = 0 }) }, 'initEvent': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; E.onmouseenter(lis[j], function () { F.interFn(lis[j]) }); E.onmouseout(lis[j], function () { F.outerFn(lis[j]) }) })(i) } }, 'reset': function () { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { lis[i].className = '' } } }, 'padReset': function (j) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { if (i !== j) { lis[i].className = '' } } } }, 'interFn': function (obj) { if (st2 != null) { clearTimeout(st2); st2 = null } st = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { } else { obj.className = 'cui_nav_o' } }, lazyTime) }, 'outerFn': function (obj) { if (st != null) { clearTimeout(st); st = null } st2 = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { obj.className = 'cui_nav_current' } else { obj.className = '' } }, 250) }, 'initMobile': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; var oneLevel = lis[j].getElementsByTagName('A')[0]; oneLevel.href = '###'; oneLevel.onmousedown = function () { F.padReset(j); if (lis[j].className.indexOf('cui_nav_current') === -1) { if (lis[j].className.indexOf('cui_nav_o') > -1) { lis[j].className = ''; oneLevel.style.visibility = 'hidden'; setTimeout(function () { oneLevel.style.visibility = 'visible' }, 10) } else { lis[j].className = 'cui_nav_o' } } } })(i) } }, 'contains': function (target) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].compareDocumentPosition(target) - 19 > 0) { return true } } return false } }; if ($('headStyleId')) { $('headStyleId').parentNode.removeChild($('headStyleId')) } if (/ip(hone|od)|ipad/i.test(navigator.userAgent)) { F.initMobile(); E.addEvent(D.body, 'click', function (e) { var target = e.target || e.srcElement; if (!F.contains(target)) { F.reset() } }) } else { F.setTime(); F.initEvent() } })();
        </script>
        <!-- header end-->
        <!-- 头部开结束 -->

</body>
</html>