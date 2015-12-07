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
<div id="portal-block-899595260489" class="udiyblock" type="HeadSource">
<div class="commonhead" style="display: block;"><span
	id="bulletin"></span>
<div id="top">
<div class="inside_top clearfix">
<form method="get" action="" id="login_form">
<div class="" id="login_bar"><span class="top_hello ie6Text">您好，欢迎使用<b>kongtie.com.cn</b>访问空铁网
！</span> <ww:if test="#session.loginuser==null">
	<a id="" href="login!toMyCenter.jspx">登录</a>
</ww:if> &nbsp; <a id="" href="login!toRegsit.jspx"> 注册</a></div>
</form>
<form method="get" action="" id="logout_form">
<div class="none" id="logged_bar"><a rel="nofollow"
	class="account_id" href="#" id="user_name"></a> <span
	class="top_hello_u ie6Text">，您好</span>
<div class="memberInfo" id="memberLevelInfo"></div>
<a rel="nofollow" href="data/TopLoginHandler.jsp?action=exitnew"
	title="退出帐号" class="btn_sign_out" id="sign_out_btn">退出</a> <a
	rel="nofollow" href="#" class="fire_pay ie6Text">订单快速支付</a></div>
</form>
<div class="express_anchor">
<div class="ea_mytc" id="myTc">
<div style="width: 62px" class="set_float" id="myTcTitle"><span
	class="mytc_span"><a rel="nofollow" href="#">我的空铁</a></span> <span
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
<div class="weiXinLink" id="tcWeiXin"><span class="weiXinLinkBg">微信我们</span><span
	style="display: none" class="weiXinMsg" id="tcWeiXinMsg">空铁网微信号：<em>tc2004</em><br>
或直接扫描右侧二维码</span></div>
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
<div class="headerCont">
<div class="headerContent clearfix">
<div class="logo"><a href="#" title="空铁网" style="float: left;"><img
	alt="空铁网" height="60px;"
	src="<%=request.getContextPath()%>/images/cnLogo.png"></a> <!--左上角 双蛋
                        <div style="float: left;" id="sliderGif">
                        <a style="width:170px;height:48px;overflow:hidden;" href="#" target="_blank">
                        <img src="<%=request.getContextPath()%>/images/cn.gif" alt="双蛋">
                    	</a>
                        </div>
                    	--></div>
<div align="left"><img
	src="<%=request.getContextPath()%>/images/top_index.jpg" alt=""></div>
<!--右上角 手机客户端
                    <div style="display: none; background:none" id="hotline_holder" class="hotline">
                        <a href="#" class="phone_load" target="_blank" id="phoneLoad" style="display: block;">
                            <img src="<%=request.getContextPath()%>/images/shoujidianpingSenic.gif" alt="手机客户端">
                        </a>
                    </div>
                	-->
 <div align="right" style="margin-top: -50px;"><img
	src="<%=request.getContextPath()%>/images/top_400.png" alt=""></div>               	
                	</div>
</div>

<div class="headerMenu">
<div class="headerNav" id="navigator"><span class="mainMenu">
<a <%= setIndex(0)%>
	href="<%=request.getContextPath()%>/index!toindex.jspx">首页</a> <a
	<%= setIndex(2)%>
	href="<%=request.getContextPath()%>/hotel!toindex.jspx">酒店预定 <span
	class="cnav_down"></span> </a> <a <%= setSubIndex(1,1)%>
	href="<%=request.getContextPath()%>/ticticket!toTicket.jspx">国内机票</a> <a
	<%= setSubIndex(1,2)%>
	href="<%=request.getContextPath()%>/international!toInterNational.jspx">国际机票</a>
<a <%= setIndex(3)%>
	href="<%=request.getContextPath()%>/spotticket.jspx">景点门票</a> <a
	<%= setIndex(4)%> href="<%=request.getContextPath()%>/huoche.jsp"
	outtext="火车票" overtext="火车票">火车票</a> <a <%= setIndex(5)%>
	href="<%=request.getContextPath()%>/zuche.jsp">租车服务</a> <a
	<%= setIndex(8)%> href="<%=request.getContextPath()%>/index!toqz.jspx">出国签证</a>
<a <%= setIndex(7)%> href="<%=request.getContextPath()%>/bm.jsp">便民服务</a>
<a class="navg" href="http://pw.kongtie.net">分销商登录</a> </span> <span
	class="helpMenu"><!--
				                     <a href="#" class="xiangdui navg">攻略</a> 
                     --><a href="login!toMyCenter.jspx"
	class="xiangdui navg huiyuan">会员俱乐部</a> </span></div>
</div>
				
</div>

</div>
				
</div>
<!-- 
<div class="scdHeaderNav clearfix" style="margin-top: 150px;">
						<div class="cmenu_left cmenu_h">
							<a href="http://www.17u.cn/hotel/" id="hotel">国内酒店</a>
							<a href="http://tuan.17u.cn/">酒店团购</a>
							<a href="http://globalhotel.17u.cn/" id="global">国际酒店</a>
							<a href="http://www.17u.cn/gangaohotel/" id="gangao">港澳酒店</a>
							<a href="http://www.17u.cn/hotel/juhui/#id_hx_wrap" id="juhui">聚惠酒店</a>
							<a href="http://www.17u.cn/hotel/liansuo/" id="liansuo">品牌汇</a>
						</div>
						
					</div>

 -->
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

