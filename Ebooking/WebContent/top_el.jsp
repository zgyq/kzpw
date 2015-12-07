<%@ page contentType="text/html; charset=UTF-8"%>
<%!int index = 0;%>
<%!int subindex = 0;%>
<%
		try {
		index = Integer.parseInt(request.getParameter("index"));
		subindex = Integer.parseInt(request.getParameter("subindex"));

	} catch (Exception e) {
	}
%>



<%!public String setIndex(int aindex) {
		String ret = "";
		if (index == aindex) {
			ret = " class=\"navg header_nav_on\" ";
		} else {

			ret = " class=\"navg\" ";
		}
		return ret;
	}%>
<%!public String setSubIndex(int aindex, int asubindex) {
		String ret = "";
		if (index == aindex && subindex == asubindex) {
			ret = " class=\"navg header_nav_on\" ";
		} else {

			ret = " class=\"navg\" ";
		}

		return ret;
	}%>
<jsp:include page="head.jsp"></jsp:include>
<link href="skin/black/css/qq.css" rel="stylesheet" type="text/css" />
<style>
.clearfix:after {
	content: ".";
	display: block;
	clear: both;
	visibility: hidden;
	line-height: 0;
	height: 0
}

* html .clearfix {
	zoom: 1
}

* :first-child+html .clearfix {
	zoom: 1
}

.none {
	display: none
}

.hidden {
	visibility: hidden
}

.scdHeaderNav {
	left: 0;
	margin: 0 auto;
	min-width: 1200px;
	position: absolute;
	top: 40px;
	width: 100%;
	_width: 1200px
}

.scdHeaderNav .cmenu_left {
	float: left;
	white-space: nowrap
}

.scdHeaderNav .cmenu_h {
	margin-left: 83px;
	_margin-left: 43px
}

.scdHeaderNav .cmenu_f {
	margin-left: 159px;
	_margin-left: 85px
}

.scdHeaderNav .cmenu_s {
	margin-left: 244px;
	_margin-left: 71px
}

.scdHeaderNav .cmenu_sl {
	margin-left: 221px;
	_margin-left: 105px
}

.scdHeaderNav .cmenu_v {
	margin-left: 524px;
	_margin-left: 212px
}

.scdHeaderNav .cmenu_yl {
	margin-left: 631px;
	_margin-left: 259px
}

.scdHeaderNav a.corder_more {
	float: right;
	background-position: -94px -2px;
	padding: 3px 10px 0 20px;
	color: #666
}

.scdHeaderNav a.corder_more i {
	font-family: simsun
}

.scdHeaderNav a.corder_more:hover {
	color: #f60
}

.scdHeaderNav .cmenu_left a {
	color: #333;
	float: left;
	font-family: "microsoft yahei";
	font-size: 16px;
	margin-right: 50px;
	padding: 1px 0 0;
	text-align: center
}

.scdHeaderNav .cmenu_left a:hover {
	color: #f60;
	text-decoration: none
}

.scdHeaderNav .cmenu_left .sec_nav_hover {
	color: #f60;
	border-bottom: 2px solid #FFA63C
}
</style>
<!--  -->
<div class="qqbox" id="divQQbox" style="z-index: 9999999999999">
  <div class="qqlv" id="meumid" onmouseover="show()"><img src="images/aqq.gif"></div>
  <div class="qqkf" style="z-index: 9999999999999" style="display:none;" id="contentid" onmouseout="hideMsgBox(event)">
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
<!--  -->
<div id="header">
    <div class="header_top">
        <div class="logo" style="position:relative;">
	<a href="http://www.elong.com" title="艺龙旅行网">艺龙旅行网</a>
            </div>
        <div class="left mt10 ml15">
            <a href="http://www.elong.com/promotion/web/mh370/index.html" target="_blank"><img src="http://www.elong.com/promotion/web/mh370/pic/mh370_icon.gif" alt="停售马航说明" /></a>
        </div>
        <div class="tools" method="menuBar">
            <div class="telWrap clx">
                <span class="tel">4009-333333<i></i></span>
                <ul style="display: none">
                    <!--当鼠标移入时显示-->
                    <li>国内：4009-333-333</li>
                    <li>香港：852-8131-8883</li>
                    <li>852-8131-8983</li>
                    <li>海外： 86-10-6432-9999</li>
                </ul>
            </div>
            <div class="version" method="divLang">
                <span class="tt" method="langtag"><a href="#?" lang="" method="langtag" rel="nofollow">
                    简体版</a></span>
                <ul method="ulLang" style="display: none">
                    <!--当鼠标移入时显示-->
                    <li style="display: none" method="licn"><a href="#?" method="chg" title="简体版" rel="nofollow">
                        简体版</a></li>
                    <li method="libig5"><a href="#?" title="繁體版" rel="nofollow">繁體版</a></li>
                    <li method="lien"><a href="#?" method="eng" title="English" class="t11">English</a></li>
                </ul>
            </div>
            <div class="other">
                <a class="mobile" target="_blank" href="http://www.elong.com/promotion/web/elongiphone/index.html">
                    手机版</a>|<a href="#?" method="savesite" rel="nofollow">收藏本站</a>|<a href="#?" method="olservice"
                        rel="nofollow">在线客服</a>|<a href="http://help.elong.com" target="_blank" rel="nofollow">帮助</a>|<a
                            href="http://www.elong.com/square/cn/" rel="nofollow">积分广场</a>|<a href="http://my.elong.com/giftcard.html"
                                rel="nofollow">预付卡</a>|</div>
        </div>
        <div class="clear">
        </div>
    </div>
    <!--导航-->
    <div class="nav_box">
        <div id="nav">
            <ul class="link" id="channelMenu">
                <li sid="28632" class="">
                    <a href="http://www.elong.com" title="艺龙旅行网" id="nav_home">首页</a></li>
                <li class="line light"></li>
                <li sid="28639" class="">
                    <a title="酒店预订" href="http://hotel.elong.com/" id="nav_hotels">酒店预订</a></li>
                <li class="line light"></li>
                <li sid="41493" class="">
                    <a href="http://tuan.elong.com/" id="A1" title="酒店团购">酒店团购<span class="icon_sale"></span></a></li>
                <li class="line"></li>
                <li sid="28642" class="">
                    <a href="http://globalhotel.elong.com/" id="nav_hotelsw" title="国际酒店">国际酒店<span class="icon_coupon"></span></a></li>
                <li class="line"></li>
                <li sid="" class="">
                    <a href="http://jia.elong.com/" id="nav_apartment" title="公寓">公寓</a></li>
                <li class="line"></li>
                <li sid="52756" class="">
                    <a href="http://qiang.elong.com" title="限时抢购">限时抢购</a>
                    <li class="line"></li>
                    
                    <li sid="28640" class="on">
                        <a href="http://flight.elong.com/" title="机票预订">机票预订<span class="rslide"></span><span
                            class="icon_air"></span></a></li>
                    <li class="line"></li>
                    
                    <li><a href="http://trip.elong.com/" title="旅游指南">旅游指南</a></li>
            </ul>
            
            <!--登录前-->
            <div class="account" method="dvAccount">
                <div class="box" method="myaccount">
                    <span class="name " method="myaccount"><a href="#?" method="myaccount" rel="nofollow">
                        我的帐户</a></span>
                    <!--弹出-->
                    <div class="pt links none" style="z-index: 4500">
                        <ul>
                            <li><a method="hbill" href="#?" rel="nofollow">酒店订单</a></li>
                            <li><a method="fbill" href="#?" rel="nofollow">机票订单</a></li>
                            <li><a method="cash" href="#?" rel="nofollow">现金账户</a></li>
                            <li><a method="coupon" href="#?" rel="nofollow">消费券</a></li>
                            <li><a method="tuan" href="#?" rel="nofollow">我的团购</a></li>
                            <li><a method="self" href="#?" rel="nofollow">个人设置</a></li>
                        </ul>
                        </div>
                    <!--弹出 end-->
                </div>
                
                <div class="box" method="reg" style="display:block">
                    <span class="name normal"><a href="http://my.elong.com/register_cn.html" title="快速预订并享受积分回赠"
                        rel="nofollow">免费注册</a></span></div>
                <div class="box" method="mylogin" style="display:block">
                    <span class="log" method="mylogin"><a href="#?" method="mylogin" rel="nofollow">登录</a></span></div>
                <!--弹出-->
                <!--登录前 end-->
            </div>
            
        </div>
    </div>


      <style type="text/css">
  .appWrap {background:url(http://www.elongstatic.com/images/other/app-wrap.png?t=20112012) no-repeat 0 0;}
  .appBox .close {background:url(http://www.elongstatic.com/images/other/app-com.png?t=20112012) no-repeat -328px -182px; _background-image:url(http://www.elongstatic.com/images/other/app-com-ie6.png?t=20112012);}
  .appBox .close:hover {background-position:-358px -182px;}
  .appBox .intro {width:320px; height:152px; background:url(http://www.elongstatic.com/images/other/app-com.png?t=20112012) no-repeat 0 -182px; _background-image:url(http://www.elongstatic.com/images/other/app-com-ie6.png?t=20112012); font-size:0; line-height:0; overflow:hidden; position:absolute; top:27px; left:33px;}
  .appBox .way i {display:inline-block; width:43px; height:43px; margin-right:5px; background:url(http://www.elongstatic.com/images/other/app-com.png?t=20112012) no-repeat 0 -334px; _background-image:url(http://www.elongstatic.com/images/other/app-com-ie6.png?t=20112012); vertical-align:middle;}
  .appBox .way .but {width:170px; height:30px; background:url(http://www.elongstatic.com/images/other/app-com.png?t=20112012) no-repeat -181px -334px; _background-image:url(http://www.elongstatic.com/images/other/app-com-ie6.png?t=20112012); border:0; text-align:center; color:#fff; font:16px "Microsoft Yahei", Simsun, sans-serif; cursor:pointer;}
  .appBox .way .but:hover {background-position:-181px -364px;}
  .appBox .way .success i {width:20px; height:16px; margin-right:5px; background:url(http://www.elongstatic.com/images/other/app-com.png?t=20112012) no-repeat -181px -394px; _background-image:url(http://www.elongstatic.com/images/other/app-com-ie6.png?t=20112012); vertical-align:middle;}
  </style>


    
    <div class="appWrap" style="display: none">
    </div>
    <div class="appBox" id="upAppBox" style="display: none; top: -600px">
        <div class="close">
        </div>
        <div class="intro">
            手机预订 5万家超低折扣酒店</div>
        <dl class="way">
            <dt><i class="one"></i>方法：扫描二维码下载</dt>
            <dd>
                <span class="qrcode">
                    <img src="http://www.elongstatic.com/common/pic/elqr.png" width="95" height="95"
                        alt="扫描二维码，下载艺龙无线"></span></dd>
        </dl>
        <dl class="way">
            <dt><i class="two"></i>方法：输入手机号下载</dt>
            <dd>
                <input class="txt l_black" method="appMobile" type="text" value="手机号码" /><div class="error"
                    style="display: none" id="appErrorUp">
                    请输入正确的手机号</div>
            </dd>
            <dd>
                <input class="but" value="发送下载地址" method="appSubmit" type="button"><div class="success"
                    style="display: none">
                    <i></i>发送成功</div>
            </dd>
        </dl>
    </div>
    
    <div class="clear">
    </div>
    
    <div id="loginDiv" class="logon_popup none" method="dvlogin" style="position: absolute;
        z-index: 4500;">
        <h3>
            <a href="#?" class="right close" method="closeLoginWindow">关闭</a>登录</h3>
        <div class="left main">
            <div id="showError" class="tip" style="display: none">
            </div>
            <ul>
                <li class="t14">邮箱或手机号</li>
                <li>
                    <input type="text" method="user" class="text l_black" value="" /></li>
                <li class="t14">密 码</li>
                <li>
                    <input method="realpass" type="password" class="text" value="" />
                </li>
                <li style="display: none" id="showVCode" class="t14">验证码</li>
                <li method="vcode" style="display: none">
                    <input type="text" class="text code" value="" method="txtvcode" />&nbsp;
                    <img method="imgCode" src="http://www.elongstatic.com/common/pic/404-1.gif" align="absmiddle" alt="看不清可点击图片更换图片。" title="看不清可点击图片更换图片。" />&nbsp;
                    <a href="#" method="imgCode">换一张</a> </li>
                <li>
                    <label class="reme" title="(保存2个月)">
                        <input type="checkbox" name="checkbox" id="inputRememberMe" checked="checked"/>下次自动登录</label></li>
                <li class="clx"><span method="login" class="left">
                    <input type="button" class="btn" value="登录" method="login" /></span> <a method="forgotpass"
                        href="#?" class="right" rel="nofollow">忘记密码?</a> <span style="display: none" method="wait">
                            <input type="button" class="btn logining" value="登录" /></span> </li>
            </ul>
        </div>
        <div class="left ml20 side">
            <p>
                还不是会员？</p>
            <p class="mt5">
                <a href="http://my.elong.com/register_cn.html" class="reg_now" title="注册艺龙帐号可快速预订并享受积分回赠"
                    rel="nofollow">马上注册！</a></p>
            <p class="mt20">
                或用以下帐号登录</p>
            <p class="mt5">
                <a href="http://openapi.elong.com/qq.html" class="coop qq" rel="nofollow"><tt></tt>QQ</a></p>
            <p class="mt5">
                <a href="http://openapi.elong.com/sina.html" class="coop weibo" rel="nofollow"><tt></tt>
                    新浪微博</a></p>
            <p class="mt5">
                <a href="#?" class="coop alipay" method="clickAlipay" rel="nofollow"><tt></tt>支付宝</a></p>
            <p class="mt5 tr t12">
                <a href="http://my.elong.com/login_cn.html" rel="nofollow">更多>></a></p>
        </div>
        <div class="clear">
        </div>
        <!--弹出 end-->
        
    </div>
    

</div>

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

