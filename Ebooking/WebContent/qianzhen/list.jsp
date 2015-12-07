<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>${compname}-签证国家</title>

<meta http-equiv="Content-Language" content="zh-CN" />

<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<meta name="Keywords" content="加拿大签证，加拿大签证中心，代办加拿大签证" />



<meta name="description" content="Global">

<meta name="Robots" content="index, follow">

<link rel="stylesheet" type="text/css" href="qianzhen/css/cube_min.css" />


<link rel="stylesheet" type="text/css" href="qianzhen/css/visa_list.css" />

<link rel="stylesheet" type="text/css" href="qianzhen/css/ask_index.css" />

<link rel="stylesheet" type="text/css" href="qianzhen/css/index.css" />



</head>

<body>
<ww:include page="../top.jsp?index=8&subindex=2" />
<a id="toTop" href="#top"></a>
<!--
<div class="crumb">


  <div class="breadCrumb">

    <ul>

      <li><a target="_self"  href="http://www.ailvxing.com/">首页</a>&nbsp;>&nbsp;<a href ="http://www.ailvxing.com/qianzheng">全球签证</a>&nbsp;>&nbsp;<a href ="http://www.ailvxing.com/list-31-0.html">加拿大</a></li>

    </ul>

  </div>
</div>
-->

<div class="list_main fix">

<div class="main_left">

<div class="left_top fix">

<ul class="top_left">

	<li><img alt="加拿大国旗" width="85px" height="85px"
		src="qianzhen/image/Canada.png" /></li>

</ul>

<ul class="top_right">

	<li>

	<h1><ww:property value="ListQzchanpininfo.get(0).country"/>签证办理中心</h1>

	</li>

	<li>

	<p><ww:property value="ListQzchanpininfo.get(0).smalltext.replace('爱旅行网', '${compname}')"/></p>



	</li>

</ul>

</div>





<div id="list_tab" class="list_tab">

<ul class="fix">

	<li class="selected"><a href="#tab0">所有领区</a></li>

	<li><a href="#tab1">上海</a></li>
	<li><a href="#tab2">北京</a></li>
</ul>

</div>



<div class="tab_content">


<ww:iterator value="ListQzchanpininfo" status="ind">
<div id="tab0">
<div class="list_box">
<div class="list_box_one">
<ul>
	<li><a href="#" title="<ww:property value="title"/>"><ww:property value="title"/></a></li>
</ul>
</div>
<div class="list_box_two fix">
<ul>
	<li id="odd"><span>最多停留:</span></li>
	<li><em><ww:property value="settleday"/></em></li>
</ul>
<ul>
	<li id="odd"><span>有&nbsp;效&nbsp;期:</span></li>
	<li><em><ww:property value="validitydate"/></em></li>
</ul>
<ul>
	<li id="odd"><span>工&nbsp;作&nbsp;日:</span></li>
	<li><em><ww:property value="intendingday"/></em></li>
</ul>
<ul>
	<li id="odd"><span>入境次数:</span></li>
	<li><em><ww:property value="numberofentries"/></em></li>
</ul>
<ul id="even">
	<li id="odd"><span>办理地点:</span></li>
	<li><em><ww:property value="dealcity"/></em></li>
</ul>
</div>
<div class="list_box_three fix">
<ul id="one">
	<li>
	<h3>办理<ww:property value="country"/>旅游签证需要花多少钱？</h3>
	</li>
	<li>
	<ww:property value="feeinfo.replace('爱旅行网', '${compname}')"/>
	</li>
</ul>
<ul id="two">
	<li><em><ww:property value="price.split('[.]')[0]"/></em>
	<span>￥</span>
	</li>
</ul>
<ul id="three">
	<li><a href="index!toqzinfo.jspx?c_qzinfoid=<ww:property value="id"/>"></a></li>
</ul>
</div>
</div>
</div>
</ww:iterator>

</div>

<div class="left_ask" style="display: none;">left_ask</div>

<div class="left_tips">

<ul>

	<li><span>相关特别提示</span></li>

</ul>

<dl>

	<dt><strong>免责声明</strong></dt>

	<dd>

	<p>1.您的签证申请是否成功，完全由该国的签证官根据您递交的申请材料独立判断，本公司不得以任何方式的干预或交涉；本公司重申，在任何情况下，本公司都不承担由签证申请结果而导致被追溯任何赔偿的责任和义务。

	
	<p>2.
	"工作日"为使馆签发签证时，正常情况下的处理时间；若遇特殊原因如政治干涉、假期、使馆内部人员调整、签证打印机故障等，则可能会产生延迟出签的情况；本网相关的处理时间信息仅供参考，非法定承诺，且上述天数计算未包含可能给申请人邮递签证的路途时间，敬请留意；对申请人根据签证预计日期提示，而进行的后续旅程安排所造成的可能经济损失，本公司不承担任何责任。</p>

	<p>3.有关签证资料上公布的签证有效期和停留天数，仅做参考而非任何法定承诺，一切均以签证官签发的签证内容，为唯一依据。</p>

	<p>4.使馆保留要求申请人补资料或要求申请人前往使馆面试的权利。</p>

	<p>5.请您待拿到签证及护照后再出机票或与酒店确认付款，避免不必要的损失，${compname}不承担签证外其它费用。</p>

	</dd>

</dl>

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

<div class="right_service">

<ul>

	<li><em>工作日早9:00-晚18:00</em></li>

	<li><span>${tel}</span></li>

</ul>

<ul class="qq_group">

	<li><a target="_blank" onfocus="this.blur()"
		href="#"
		title="点击加入${compname}QQ客服群">${compname}QQ客服群</a></li>
<!-- http://shang.qq.com/wpa/qunwpa?idkey=62df33ac70aff80924c051d887e288aa7c149d3908e8ff26faeb9f4bfbeb68b2s -->
</ul>

</div>

</div>

</div>
<div><ww:include page="../footer.jsp" /></div>
<!--<div class="footer">

  <div class="bottom">

    <div class="bottom_links">  <a target="_blank" rel="nofollow" href="/intro/about.html">关于我们</a> &#12288;|&#12288;<a target="_blank" rel="nofollow" href="/intro/contact.html">联系我们</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="/intro/job.html">工作机会</a> &#12288;|&#12288;<a target="_blank" rel="nofollow" href="/intro/privacy.html">隐私权政策</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="/intro/Trust-ailvxing.html#5">合作伙伴</a> &#12288;|&#12288; <a target="_blank" rel="nofollow" href="/intro/duty.html">服务声明</a> </div>

    <div class="bottom_info fix">

      <div class="copyright">

        <p> <span>Copyright &copy; 2008-2013 AiLvXing.com, Inc. All Rights Reserved</span> <br />

          <a href="#" target="_blank" rel="nofollow"> 京ICP备11009434号-1 </a> 客服电话：400-610-6678 未开通400地区&nbsp;(010)&nbsp;5351&nbsp;0852 </p>

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
	src="vjs/artDialog/4.1.7/jquery.artDialog.js?skin=pure"></script>

<script charset="utf-8" type="text/javascript" src="qianzhen/js/ailvxing.min.js"></script>

<script charset="utf-8" type="text/javascript" src="qianzhen/js/visa.js"></script>

<!--[if IE 6]>

<script src="/skin/ailvxing/js/DD_belatedPNG_0.0.8a-min.js"></script>

<script>

  DD_belatedPNG.fix('.visa_top img');

</script>

<![endif]-->

</body>

</html>