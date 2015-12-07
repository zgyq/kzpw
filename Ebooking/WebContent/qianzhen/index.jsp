<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>${compname}-全球签证</title>

<meta http-equiv="Content-Language" content="zh-CN" />

<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<meta name="Keywords" content="签证办理,签证代办" />

<meta name="description" content="" />

<meta name="description" content="Global" />

<meta name="Robots" content="index, follow" />

<link rel="stylesheet" type="text/css" href="qianzhen/css/cube_min.css" />

<!--
<link rel="stylesheet" type="text/css" href="css/top_bottom.css" />

-->
<link rel="stylesheet" type="text/css"
	href="qianzhen/css/visa_index.css" />

</head>

<body>
<ww:include page="../top.jsp?index=8&subindex=2" />

<div class="crumb">

<div class="breadCrumb"><!--

    <ul>

      <li><a target="_self"  href="#/">首页</a>&nbsp;>&nbsp;<a href ="#">全球签证</a></li>

    </ul>

  --></div>

</div>

<div class="list_main fix">

<div class="main_left">

<div class="visa_top">

<div id="world_map" class="world_map"><img usemap="#planetmap"
	alt="世界地图" src="qianzhen/image/bottom_bg.png" /> <map name="planetmap"
	id="planetmap">

	<area id="map_one" shape="poly" alt="美洲" onclick="showMap('map_one');"
		coords="154,16,125,21,101,42,91,55,57,50,29,54,32,75,30,98,68,97,91,118,116,146,164,192,184,222,190,262,189,298,193,320,230,320,240,280,265,252,275,222,254,206,224,183,200,150,218,132,245,114,260,88,291,67,310,28,313,12,302,2,229,5,178,3"
		href="javascript:void(0);" />

	<area id="map_two" shape="poly" alt="非洲" onclick="showMap('map_two');"
		coords="348,138,368,146,399,149,411,174,418,184,436,188,433,203,434,245,418,266,378,279,349,263,346,223,342,203,320,206,301,190,299,164,309,143"
		href="javascript:void(0);" />

	<area id="map_three" shape="poly" alt="欧洲" onclick="showMap('map_three');"
		coords="452,53,446,77,442,91,440,102,434,109,429,119,428,129,421,131,397,129,382,138,370,140,349,136,337,136,321,137,310,122,305,97,294,70,356,19,381,15,433,19,454,20,463,16,455,19,449,13,471,31"
		href="javascript:void(0);" />

	<area id="map_four" shape="poly" alt="亚洲" onclick="showMap('map_four');"
		coords="602,133,602,100,619,104,643,98,668,83,683,75,683,55,648,49,612,45,584,39,526,29,484,33,465,50,453,65,450,93,442,115,433,130,415,137,400,139,397,142,413,161,425,179,460,188,492,200,502,182,516,192,520,212,550,218"
		href="javascript:void(0);" />

	<area id="map_five" shape="poly" alt="澳洲" onclick="showMap('map_five');"
		coords="661,320,696,280,690,234,669,187,657,155,617,161,603,179,579,204,565,226,519,253,531,278,529,298"
		href="javascript:void(0);" />

</map></div>

<div id="map_class_box">

<div id="map_three_class" class="world_class" style="display: none;">

<span class="world_title"> <span class="iconfont">&#13538;</span>

<span>欧洲&nbsp;Europe</span> </span>

<ul>

	<li><a target="_self" href="#">葡萄牙</a> <a target="_self" href="#">格陵兰</a>

	<a target="_self" href="#">英国</a> <a target="_self" href="#">乌克兰</a> <a
		target="_self" href="#">瑞士</a> <a target="_self" href="#">瑞典</a> <a
		target="_self" href="#">西班牙</a> <a target="_self" href="#">俄罗斯</a> <a
		target="_self" href="#">挪威</a> <a target="_self" href="#">荷兰</a> <a
		target="_self" href="#">马耳他</a> <a target="_self" href="#">拉脱维亚</a> <a
		target="_self" href="#">意大利</a> <a target="_self" href="#">爱尔兰</a> <a
		target="_self" href="#">冰岛</a> <a target="_self" href="#">匈牙利</a> <a
		target="_self" href="#">希腊</a> <a target="_self" href="#">德国</a> <a
		target="_self" href="#">法国</a> <a target="_self" href="#">芬兰</a> <a
		target="_self" href="#">丹麦</a> <a target="_self" href="#">捷克</a> <a
		target="_self" href="#">比利时</a> <a target="_self" href="#">白俄罗斯</a> <a
		target="_self" href="#">奥地利</a></li>

</ul>

</div>

<div id="map_one_class" class="world_class" style="display: none;">

<span class="world_title"> <span class="iconfont">&#13538;</span>

<span>美洲&nbsp;America</span> </span>

<ul>

	<li><a target="_self" href="#">百慕大(英属)</a> <a target="_self"
		href="#">美国</a> <a target="_self" href="#">加拿大</a></li>

</ul>

</div>

<div id="map_five_class" class="world_class" style="display: none;">

<span class="world_title"> <span class="iconfont">&#13538;</span>

<span>澳洲&nbsp;Oceania</span> </span>

<ul>

	<li><a target="_self" href="#">新西兰</a> <a target="_self" href="#">大溪地</a>

	<a target="_self" href="#">澳大利亚</a></li>

</ul>

</div>

<div id="map_two_class" class="world_class" style="display: none;">

<span class="world_title"> <span class="iconfont">&#13538;</span>

<span>非洲&nbsp;Africa</span> </span>

<ul>

	<li><a target="_self" href="#">摩洛哥</a> <a target="_self" href="#">赞比亚</a>

	<a target="_self" href="#">乌干达</a> <a target="_self" href="#">突尼斯</a> <a
		target="_self" href="#">多哥</a> <a target="_self" href="#">坦桑尼亚</a> <a
		target="_self" href="#">苏丹</a> <a target="_self" href="#">南非</a> <a
		target="_self" href="#">塞拉利昂</a> <a target="_self" href="#"> 刚果(金)</a>

	<a target="_self" href="#">刚果(布)</a> <a target="_self" href="#">尼日利亚</a>

	<a target="_self" href="#">毛里塔尼亚</a> <a target="_self" href="#">马达加斯加</a>

	<a target="_self" href="#">利比里亚</a> <a target="_self" href="#">肯尼亚</a>

	<a target="_self" href="#">几内亚比绍</a> <a target="_self" href="#">几内亚</a>

	<a target="_self" href="#">埃塞俄比亚</a> <a target="_self" href="#">赤道几内亚</a>

	<a target="_self" href="#">埃及</a> <a target="_self" href="#">吉布提</a> <a
		target="_self" href="#">乍得</a> <a target="_self" href="#">中非共和国</a> <a
		target="_self" href="#">喀麦隆</a> <a target="_self" href="#">贝宁</a> <a
		target="_self" href="#">安哥拉</a> <a target="_self" href="#">阿尔及利亚</a></li>

</ul>

</div>

<div id="map_four_class" class="world_class" style="display: none;">

<span class="world_title"> <span class="iconfont">&#13538;</span>

<span>亚洲&nbsp; Asia</span> </span>

<ul>

	<li><a target="_self" href="#">中国台湾</a> <a target="_self" href="#">约旦</a>

	<a target="_self" href="#">印尼</a> <a target="_self" href="#">伊朗</a> <a
		target="_self" href="#">也门</a> <a target="_self" href="#">印度</a> <a
		target="_self" href="#">越南</a> <a target="_self" href="#">新加坡</a> <a
		target="_self" href="#">乌兹别克斯坦</a> <a target="_self" href="#">文莱</a> <a
		target="_self" href="#">土耳其</a> <a target="_self" href="#">土库曼斯坦</a> <a
		target="_self" href="#">塔吉克斯坦</a> <a target="_self" href="#">泰国</a> <a
		target="_self" href="#">斯里兰卡</a> <a target="_self" href="#">沙特阿拉伯</a>

	<a target="_self" href="#">柬埔寨</a> <a target="_self" href="#">日本</a> <a
		target="_self" href="#">尼泊尔</a> <a target="_self" href="#">缅甸</a> <a
		target="_self" href="#">孟加拉</a> <a target="_self" href="#">蒙古</a> <a
		target="_self" href="#">马来西亚</a> <a target="_self" href="#">黎巴嫩</a> <a
		target="_self" href="#">老挝</a> <a target="_self" href="#">科威特</a> <a
		target="_self" href="#">卡塔尔</a> <a target="_self" href="#">吉尔吉斯斯坦</a>

	<a target="_self" href="#">哈萨克斯坦</a> <a target="_self" href="#">韩国</a>

	<a target="_self" href="#">菲律宾</a> <a target="_self" href="#">朝鲜</a> <a
		target="_self" href="#">巴林</a> <a target="_self" href="#">巴基斯坦</a> <a
		target="_self" href="#">阿塞拜疆</a> <a target="_self" href="#">阿联酋</a></li>

</ul>

</div>

</div>

</div>

<div class="hot_country"><span class="country_title"> <span>热门国家</span> </span>&nbsp;&nbsp;<span><a onclick="showall();return false;"
	href="#">[全部]</a></span>

<div class="hot_country_box fix"><span class="country"><a
	href="index!toqzbycont.jspx?c_id=32" title="美国签证"><img src="qianzhen/image/United-States.png"
	alt="美国" />&nbsp;美国</a></span> <span class="country"><a href="index!toqzbycont.jspx?c_id=31"
	title="加拿大签证"><img src="qianzhen/image/Canada.png" alt="加拿大" />&nbsp;加拿大</a></span>

<span class="country"><a href="index!toqzbycont.jspx?c_id=34" title="澳大利亚签证"><img
	src="qianzhen/image/Australia.png" alt="澳大利亚" />&nbsp;澳大利亚</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=36" title="新西兰签证"><img
	src="qianzhen/image/New-Zealand.png" alt="新西兰" />&nbsp;新西兰</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=13" title="法国签证"><img
	src="qianzhen/image/France.png" alt="法国" />&nbsp;法国</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=19" title="意大利签证"><img
	src="qianzhen/image/Italy.png" alt="意大利" />&nbsp;意大利</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=25" title="西班牙签证"><img
	src="qianzhen/image/Spain.png" alt="西班牙" />&nbsp;西班牙</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=27" title="瑞士签证"><img
	src="qianzhen/image/Switzerland.png" alt="瑞士" />&nbsp;瑞士</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=14" title="德国签证"><img
	src="qianzhen/image/Germany.png" alt="德国" />&nbsp;德国</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=15" title="希腊签证"><img
	src="qianzhen/image/Greece.png" alt="希腊" />&nbsp;希腊</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=29" title="英国签证"><img
	src="qianzhen/image/United-Kingdom.png" alt="英国" />&nbsp;英国</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=70" title="韩国签证"><img
	src="qianzhen/image/South-Korea.png" alt="韩国" />&nbsp;韩国</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=82" title="日本签证"><img
	src="qianzhen/image/Japan.png" alt="日本" />&nbsp;日本</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=24" title="俄罗斯签证"><img
	src="qianzhen/image/Russia.png" alt="俄罗斯" />&nbsp;俄罗斯</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=64" title="阿联酋签证"><img
	src="qianzhen/image/United-Arab-Emirates.png" alt="阿联酋" />&nbsp;阿联酋</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=89" title="土耳其签证"><img
	src="qianzhen/image/Turkey.png" alt="土耳其" />&nbsp;土耳其</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=44" title="埃及签证"><img
	src="qianzhen/image/Egypt.png" alt="埃及" />&nbsp;埃及</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=94" title="印度签证"><img
	src="qianzhen/image/India.png" alt="印度" />&nbsp;印度</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=86" title="泰国签证"><img
	src="qianzhen/image/Thailand.png" alt="泰国" />&nbsp;泰国</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=77" title="马来西亚签证"><img
	src="qianzhen/image/Malaysia.png" alt="马来西亚" />&nbsp;马来西亚</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=92" title="新加坡签证"><img
	src="qianzhen/image/Singapore.png" alt="新加坡" />&nbsp;新加坡</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=93" title="越南签证"><img
	src="qianzhen/image/Vietnam.png" alt="越南" />&nbsp;越南</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=83" title="柬埔寨签证"><img
	src="qianzhen/image/Cambodia.png" alt="柬埔寨" />&nbsp;柬埔寨</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=85" title="斯里兰卡签证"><img
	src="qianzhen/image/Sri-Lanka.png" alt="斯里兰卡" />&nbsp;斯里兰卡</a></span> <span
	class="country"><a href="index!toqzbycont.jspx?c_id=81" title="尼泊尔签证"><img
	src="qianzhen/image/Nepal.png" alt="尼泊尔" />&nbsp;尼泊尔</a></span></div>

</div>



<!-- 全部 -->
<div id="allguojia" style="display: none">
<div class="hot_country"><span class="country_title"> <span>亚洲 Asia </span> </span>&nbsp;&nbsp;

<div class="hot_country_box fix">
<ww:iterator value="listQzguojiayz">
<span class="country" ><a 
	href="qzseach!toqzbycont.action?c_id=<ww:property value="classid" />" title="<ww:property value="name" />签证"><img
	src="qianzhen/image/<ww:property value="param1" />.png" alt="<ww:property value="name" />" />&nbsp;<ww:property value="name" /></a></span> 
</ww:iterator>
	</div>

</div>
<div class="hot_country"><span class="country_title"> <span>欧洲 Europe </span> </span>&nbsp;&nbsp;

<div class="hot_country_box fix">
<ww:iterator value="listQzguojiaoz">
<span class="country" ><a 
	href="qzseach!toqzbycont.action?c_id=<ww:property value="classid" />" title="<ww:property value="name" />签证"><img
	src="qianzhen/image/<ww:property value="param1" />.png" alt="<ww:property value="name" />" />&nbsp;<ww:property value="name" /></a></span> 
</ww:iterator>
	</div>

</div>
<div class="hot_country"><span class="country_title"> <span>美洲 America  </span> </span>&nbsp;&nbsp;

<div class="hot_country_box fix">
<ww:iterator value="listQzguojiamz">
<span class="country" ><a 
	href="qzseach!toqzbycont.action?c_id=<ww:property value="classid" />" title="<ww:property value="name" />签证"><img
	src="qianzhen/image/<ww:property value="param1" />.png" alt="<ww:property value="name" />" />&nbsp;<ww:property value="name" /></a></span> 
</ww:iterator>
	</div>

</div>
<div class="hot_country"><span class="country_title"> <span>澳洲 Oceania   </span> </span>&nbsp;&nbsp;

<div class="hot_country_box fix">
<ww:iterator value="listQzguojiaaz">
<span class="country" ><a 
	href="qzseach!toqzbycont.action?c_id=<ww:property value="classid" />" title="<ww:property value="name" />签证"><img
	src="qianzhen/image/<ww:property value="param1" />.png" alt="<ww:property value="name" />" />&nbsp;<ww:property value="name" /></a></span> 
</ww:iterator>
	</div>

</div>
<div class="hot_country"><span class="country_title"> <span>非洲 Africa    </span> </span>&nbsp;&nbsp;

<div class="hot_country_box fix">
<ww:iterator value="listQzguojiafz">
<span class="country" ><a 
	href="qzseach!toqzbycont.action?c_id=<ww:property value="classid" />" title="<ww:property value="name" />签证"><img
	src="qianzhen/image/<ww:property value="param1" />.png" alt="<ww:property value="name" />" />&nbsp;<ww:property value="name" /></a></span> 
</ww:iterator>
	</div>

</div>
</div>



<div class="visa_ask"><span class="ask_title"> <span>签证问答</span> </span>&nbsp;&nbsp;<span><a
	href="#">[全部]</a></span>

<div id="show_ask" class="show_ask">
<ul>
	<li class="show_ask_rper"><span>寡言的腹语师&nbsp;-&nbsp;2014年
	03月07日 16:44</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="在校大学生需要提供存款证明吗？需要的话多少钱为佳？谢谢" target="_blank"
		href="#">问：在校大学生需要提供存款证明吗？需要的话多少钱为佳？谢谢</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：请问您是不是想问除了其他资产证明外，存款证明是不是必选材料？

	加拿大签证资产证明材料主要是半年的活期流水账单，根据您停留的天数不同余额要求也不一样，${compname}建议余额至少5万以上，流水账单是一项必选材料，固定资产（房，车...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>deils&nbsp;-&nbsp;2014年
	03月06日 12:13</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="听说澳大利亚可以办理三年、五年多次的签证了，请问可以办理吗？" target="_blank"
		href="#">问：听说澳大利亚可以办理三年、五年多次的签证了，请问可以办理吗？</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：澳大利亚普通访问签证通常给的都是一年多次往返（根据申请人资料不同签证官也有可能只给三个月、半年多次或者单次签证）。

	2012年11月24日，澳大利亚移民局正式推出父母长期探亲签证（三年或五年有效期），多次入境，一次最多可停...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>ZETTS&nbsp;-&nbsp;2014年
	03月06日 10:43</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="你好，我之前有在澳洲生活六年，不是北京户口，可以申请韩国三年往返的签证吗？"
		target="_blank" href="#">问：你好，我之前有在澳洲生活六年，不是北京户口，可以申请韩国三年往返的签证吗？</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：申请人需有过2次发达国家旅行记录包括韩国、日本、美国、加拿大、澳大利亚、新西兰、申根各国的记录的申请人可申请韩国个人旅游三年多次往返签证。

	请问您的签证是什么签证类型？如果是两次旅游签证，并且是澳洲贴纸签证...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>nicholaslc&nbsp;-&nbsp;2014年
	03月05日 16:12</span></li>
	<li class="show_ask_title"><a ellipsis" title="申根签证的问题？"
		target="_blank" href="#">问：申根签证的问题？</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：拒签后再申请签证，使馆对于中间间隔时间并没有硬性规定，只要您针对上次拒签的原因将资料补充，或者在原资料基础上有所改变就可以马上再次递交申请。您是白本护照，申请意大利需要面试。您如果想改签别的国家，建议可以考虑下...</p>
	</li>
</ul>
</div>

</div>

</div>

<div class="main_right">

<div class="right_info">

<ul class="info_one">

	<li><span>为什么找${compname}？</span></li>

</ul>

<ul class="info_two">

	<li>

	<p>提供超过100个国家、近1000个签证类别签证办理服务，全国北京、上海、广州、沈阳、成都、重庆均设有分公司。</p>

	</li>

</ul>

<ul class="info_three">

	<li>

	<p>为超过50,000个用户提供了签证办理服务，专业、方便、快捷。专业的客服服务，确保每一位申请人得到更加专业化的签证办理服务。</p>

	</li>

</ul>

<ul class="info_four">

	<li>

	<p>${compname}提供全国范围内的上门取件服务，您只需网上下单或拨打客服电话即有客服人员安排上门取件服务。</p>

	</li>

</ul>

</div>

<div class="mulitline"><span class="mulitline_title"> <span
	class="iconfont">&#13394;</span> <span>最新预订</span> </span>

<ul id="mulitline">

	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;王**&nbsp;<font
		color="Purple">4小时前</font>&nbsp;<a class="tip" href="#"
		title="马来西亚旅游签证">马来西亚旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;李**&nbsp;<font
		color="Purple">4小时前</font>&nbsp;<a class="tip" href="#"
		title="马来西亚旅游签证">马来西亚旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;邹**&nbsp;<font
		color="Purple">5小时前</font>&nbsp;<a class="tip" href="#"
		title="新西兰旅游签证<br />签证服务费">签证服务费</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;巫**&nbsp;<font
		color="Purple">16小时前</font>&nbsp;<a class="tip" href="#"
		title="法国旅游签证">法国旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;徐**&nbsp;<font
		color="Purple">18小时前</font>&nbsp;<a class="tip" href="#"
		title="泰国旅游签证">泰国旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;肖**&nbsp;<font
		style="color: darkorange;">昨天</font>&nbsp;<a class="tip" href="#"
		title="西班牙旅游签证">西班牙旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;王**&nbsp;<font
		style="color: darkorange;">昨天</font>&nbsp;<a class="tip" href="#"
		title="泰国旅游签证">泰国旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;李**&nbsp;<font
		style="color: darkorange;">昨天</font>&nbsp;<a class="tip" href="#"
		title="德国旅游签证">德国旅游签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;宾**&nbsp;<font
		style="color: darkorange;">昨天</font>&nbsp;<a class="tip" href="#"
		title="瑞士商务签证">瑞士商务签证</a></li>
	<li class="ellipsis"><span class="iconfont">&#13662;</span>&nbsp;黄**&nbsp;<font
		style="color: darkorange;">昨天</font>&nbsp;<a class="tip" href="#"
		title="新加坡电子签证<br />泰国旅游签证">泰国旅游签证</a></li>
</ul>

</div>

<div class="right_service">

<ul>

	<li><em>工作日早9:00-晚18:00</em></li>

	<li><span>${tel}</span></li>

</ul>

<ul class="qq_group">

	<li><a target="_blank" href="#" title="点击加入${compname}QQ客服群">${compname}QQ客服群</a></li>

</ul>

</div>

</div>

</div>


<div><ww:include page="../footer.jsp" /></div>

<!--
  <div class="footer">
  <div class="bottom">

    <div class="bottom_links">  <a target="_blank" rel="nofollow" href="#">关于我们</a> &#12288;|&#12288;<a target="_blank" rel="nofollow" href="#">联系我们</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="/intro/job.html">工作机会</a> &#12288;|&#12288;<a target="_blank" rel="nofollow" href="#">隐私权政策</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="#">合作伙伴</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="#">服务声明</a> </div>

    <div class="bottom_info fix">

      <div class="copyright">

        <p> <span>Copyright &copy; 2008-2013 AiLvXing.com, Inc. All Rights Reserved</span> <br />

          <a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow"> 京ICP备11009434号-1 </a> 客服电话：400-610-6678 未开通400地区&nbsp;(010)&nbsp;5351&nbsp;0852 </p>

      </div>

      <div class="authentication"><a href="http://union.rising.com.cn/InfoManage/attestation.aspx?p0=-ujc0DLaZoQyRO8TjrFDbGdNzFG09DKUDENxVluALuc=" class="a4" target="_blank" rel="nofollow">瑞星网络安全</a><a href="http://www.cyberpolice.cn/" class="a3" target="_blank" rel="nofollow">网络110</a><a href="http://webscan.360.cn" class="a2" target="_blank" rel="nofollow">360安全中心</a><a href="http://www.hd315.gov.cn" class="a1" target="_blank" rel="nofollow">经营性网站备案中心</a></div>

    </div>

  </div>
</div>
-->

<script src="http://www.ailvxing.com/e/extend/stats/"></script>

<script type="text/javascript">

var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");

document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F02c232ea57353c9d7d674ca2a18e4e51' type='text/javascript'%3E%3C/script%3E"));

</script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery/jquery-1.7.1.min.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery.tagsinput.min.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery.textareaCounter.plugin.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/artDialog/4.1.7/jquery.artDialog.js?skin=pure"></script>

<script charset="utf-8" type="text/javascript" src="qianzhen/js/ailvxing.min.js"></script>

<script charset="utf-8" type="text/javascript" src="qianzhen/js/visa.js"></script>

<script type="text/javascript">

$(document).ready(function() {

    $("#map_one,#map_two,#map_three,#map_four,#map_five").hover(

    function () {

        var thisid = $(this).attr("id");

        t = setTimeout("showMap('"+thisid+"')",200);

    },

    function () {

        clearTimeout(t);

    }

  );

});

function showMap(thisid) {

    var cid=thisid+"_class";

    $("#world_map").removeClass();

    $("#world_map").addClass("world_map "+thisid);

    

    $("#map_class_box").children().each(function(i){

        if(this.id==cid) {

            $(this).show();

        } else {

            $(this).hide();

        }

    });

}
function showall() {

 $("#allguojia").show();

}

</script>

</body>

</html>