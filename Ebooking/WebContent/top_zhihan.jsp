<%@ taglib uri="webwork" prefix="ww"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="top_zh/style/public.css"/>
<link rel="stylesheet" type="text/css" href="top_zh/style/home.css"/>
<script charset="utf-8" src="top_zh/js/jquery-min.js"></script>
<script charset="utf-8" src="top_zh/js/public.js"></script>
<script charset="utf-8" src="top_zh/js/focus.js"></script>

<div class="headerlinkbg">
<div id="headerlink">
<div class="topcity"><b class="nowcity">西宁</b></div>
<div class="toplink">
<ww:if test="#session.loginuser==null">
<a  href="login!toMyCenter.jspx">登录</a> | <a  href="login!toRegsit.jspx">注册</a> | </ww:if><ww:else><a  href="login!toMyCenter.jspx">
 <ww:property value="#session.loginuser.loginname"/>
 </a></ww:else>
  <a  href="login!toMyCenter.jspx">订单</a> | 联系客服 | 帮助 | 商家入驻 | 关注我们</div>
</div>
</div>
<div id="header"><span class="logo" style="margin-top: -5px;"><a
	href="http://www.kuaisuyou.com/"><img src="top_zh/images/logo.jpg" /></a></span> <span
	class="vtop"><img src="top_zh/images/ad001.gif" /></span></div>
<div class="navbg">
<div id="navbox">
<ul class="ulnav">
	<li class="linav"><a href="http://www.kuaisuyou.com" rel="nofollow" class="anav">首页</a></li>
	<li class="linav"><a href="http://www.kuaisuyou.cn" class="anav">旅游出行</a></li>
	<li class="linav"><a href="http://www.kuaisuyou.com/tutechan.html" class="anav">土特产品</a></li>
	<li class="linav"><a href="http://www.kuaisuyou.com/shengwufuwu.html" class="anav">商务服务</a></li>
	<li class="linav"><a href="http://www.kuaisuyou.com/shenghuofuwu.html" class="anav">生活服务</a></li>
	<li class="linav"><a href="http://www.kuaisuyou.com/jiajujiancai.html" class="anav">家居建材</a></li>
</ul>
<div id="menunav">
<div class="tit"><b class="bt">热门行业快速导航</b></div>

<div class="newSubCon" style="display: none;">
<div class="MenuCon" id="jsMenuCon">
<div class="newMenuBlock">
<h3><s class="s1"></s><a href="/lvyou.html">旅游出行</a></h3>
<div class="SubCon"><a href="/lvxingshe_1/index.html" class="atag">旅行社</a><a
	href="/jipiao_2/index.html" class="atag">机票</a><a
	href="/qianzheng_3/index.html" class="atag">签证护照</a><a
	href="/jiudian_4/index.html" class="atag">酒店</a></div>
</div>
<div class="newMenuBlock">
<h3><s class="s2"></s><a href="/tutechan.html">土特产品</a></h3>
<div class="SubCon"><a href="/gouqi_5/index.html" class="atag">枸杞</a><a
	href="/dongchongxiacao_6/index.html" class="atag">冬虫夏草</a><a
	href="/zanghonghua_7/index.html" class="atag">藏红花</a><a
	href="/maoniurou_8/index.html" class="atag">牦牛肉</a></div>
</div>
<div class="newMenuBlock">
<h3><s class="s3"></s><a href="/shengwufuwu.html">商务服务</a></h3>
<div class="SubCon"><a href="/gongshang_9/index.html" class="atag">工商注册</a><a
	href="/caiwukuaiji_10/index.html" class="atag">财务会计</a><a
	href="/shangbiao_11/index.html" class="atag">商标专利</a><a
	href="/falv_12/index.html" class="atag">法律咨询</a><a
	href="/wuliu_13/index.html" class="atag">货运物流</a></div>
</div>
<div class="newMenuBlock">
<h3><s class="s4"></s><a href="/shenghuofuwu.html">生活服务</a></h3>
<div class="SubCon"><a href="/banjia_21/index.html" class="atag">搬家</a><a
	href="/baojie_22/index.html" class="atag">保洁</a><a
	href="/baomu_23/index.html" class="atag">保姆</a><a
	href="/jiadianweixiu_24/index.html" class="atag">家电维修</a><a
	href="/diannaoweixiu_25/index.html" class="atag">电脑维修</a></div>
</div>
<div class="newMenuBlock">
<h3><s class="s5"></s><a href="/jiajujiancai.html">家居建材</a></h3>
<div class="SubCon"></div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="clear"></div>
