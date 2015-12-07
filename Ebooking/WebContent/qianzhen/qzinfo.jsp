<%@ page contentType="text/html; charset=utf-8"%> <%@ taglib
uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>签证国家详情页</title>

<meta http-equiv="Content-Language" content="zh-CN" />

<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<meta name="Keywords" content="加拿大签证" />

<meta name="description" content="加拿大旅游签证 多次往返 (北京领区)" />

<meta name="description" content="Global">
<meta name="Robots" content="index, follow">
<link rel="stylesheet" type="text/css" href="qianzhen/css/cube_min.css" />


<link rel="stylesheet" type="text/css"
	href="qianzhen/css/visa_content.css" />

<link rel="stylesheet" type="text/css" href="qianzhen/css/fancybox.css"
	media="screen" />

</head>

<body>

<a id="toTop" href="#top"></a>
<ww:include page="../top.jsp?index=8&subindex=2" />


<!--<div class="crumb">

  <div class="breadCrumb">

    <ul>

      <li><a target="_self"  href="#/">首页</a>&nbsp;>&nbsp;<a href ="#">全球签证</a>&nbsp;>&nbsp;<a href ="#">加拿大</a>&nbsp;>&nbsp;<span>加拿大旅游签证 多次往返 (北京领区)</span></li>

    </ul>

  </div>

</div>

-->
<div class="visa_main">

<div class="visa_info fix">

<div class="visa_info_left">

<div class="visa_top">

<ul class="one">

	<li><img alt="加拿大国旗" width="85px" height="85px"
		src="qianzhen/image/Canada.png" /></li>

</ul>

<dl class="two">

	<dt id="visa_title">

	<h1><ww:property value="qzchanpininfo.title"/></h1>

	</dt>

	<dd><ww:property value="qzchanpininfo.smalltext.replace('爱旅行网', '${compname}')"/></dd>

</dl>

<div style="font: 0px/ 0px sans-serif; clear: both; display: block">
</div>

</div>

<div class="left_top">

<div class="left_top_set fix">

<ul>

	<li id="odd"><span>有&nbsp;效&nbsp;期:</span></li>

	<li><em><ww:property value="qzchanpininfo.validitydate"/></em></li>

</ul>

<ul>

	<li id="odd"><span>最多停留:</span></li>

	<li><em><ww:property value="qzchanpininfo.settleday"/></em></li>

</ul>

<ul>

	<li id="odd"><span>工&nbsp;作&nbsp;日:</span></li>

	<li><em><ww:property value="qzchanpininfo.intendingday"/></em></li>

</ul>

<ul>

	<li id="odd"><span>入境次数:</span></li>

	<li><em><ww:property value="qzchanpininfo.numberofentries"/></em></li>

</ul>

<ul id="even">

	<li id="odd"><span>办理地点:</span></li>

	<li><em><ww:property value="qzchanpininfo.dealcity"/></em></li>

</ul>

</div>

<div class="left_top_info">

<ul id="one">

	<li>

	<h3>办理<ww:property value="qzchanpininfo.country"/>旅游签证需要花多少钱？</h3>

	</li>

	<li><ww:property value="qzchanpininfo.feeinfo.replace('爱旅行网', '${compname}')"/></li>

</ul>

<ul id="two">

	<li class="fix"><em> <ww:property value="qzchanpininfo.price.split('[.]')[0]"/> </em><span>￥</span></li>

</ul>

<ul id="three">

	<li><a href="#" onclick="alert('请致电客服!!!');" title="立即预定"></a></li>

</ul>

<div style="font: 0px/ 0px sans-serif; clear: both; display: block">
</div>

</div>

</div>

<div class="left_content">

<div id="content_tab" class="content_tab">

<ul class="fix">

	<li class="selected"><a href="#tab1">在职人员</a></li>
	<li><a href="#tab2">自由职业者</a></li>
	<li><a href="#tab3">退休老人</a></li>
	<li><a href="#tab4">学生儿童</a></li>
</ul>

</div>

<div class="content_info">

<div id="tab1">

<dl>
	<dt class="sub_title"><span class="dib">身份证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub1"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">护照原件</span><span class="info_note"></span></dt>
		<dd>有效期超过6个月的因私护照，如有旧护照请提供，如旧护照丢失需公安机关开具丢失证明。<br />

		PS：护照号码为G开头的旧版护照，签名页（尾页）要由申请人亲笔签名。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub20"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">2寸证件照片2张原件</span><span
			class="info_note"></span></dt>
		<dd>近半年内拍摄的白色背景2寸彩色证件照片2张，规格：33*48mm或35*45mm.</dd>
	</dl>
	</div>
	<div class="info fix" id="sub3"><img src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">身份证复印件</span><span class="info_note"></span></dt>
		<dd>申请人有效身份证正反面复印件一份，尽可能的复印清晰些。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub5"><img src="qianzhen/image/hukouben.jpg">
	<dl>
		<dt><span class="info_title">户口本复印件</span><span class="info_note"></span><span>&nbsp;&nbsp;<a
			href="javascript:showSample(262,5);">[查看样本]</a></span></dt>
		<dd>申请人所在户口本所有信息页的复印件一套，需包含户口本首页、户主页、本人页及配偶页（包括迁出、注销页）。<br />

		</dd>
	</dl>
	</div>
	<div class="info fix" id="sub7"><img src="qianzhen/image/jiehunzheng.jpg">
	<dl>
		<dt><span class="info_title">结婚证或离婚证复印件</span><span
			class="info_note"></span></dt>
		<dd>已婚者请提供结婚证或离婚证复印件，证件丢失者需在派出所/民政局开具相关证明（未婚者忽略此条）。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub166"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">个人资料表原件</span><span
			class="info_note"></span></dt>
		<dd>请在${compname}下载个人资料表并完整填写，此表格不会递交给使馆，将用于填写递交使馆的英文签证申请表，请申请人认真填写。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/个人资料表-加拿大签证专用.doc"
			title="个人资料表-加拿大签证专用">个人资料表-加拿大签证专用</a></dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">资产证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub28"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">近6个月活期明细对账单原件</span><span
			class="info_note"> (必选)&nbsp;<a class="iconfont" href=""
			title="近6个月活期明细对账单是必须提供">&#x3574;</a></span></dt>
		<dd>申请人本人名下银行活期存折或银行卡最近6个月的对账单，最好使用工资卡对账单，用以证明收入情况，余额建议超过3万以上用以证明可以支付本次出行的费用，也可使用多张卡对账单证明收入和余额的情况。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub42"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">3个月信用卡对账单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="3个月信用卡对账单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下的信用卡3个月对账单，银行邮寄的原件或银行发送的E-mail电子对账单打印件，用以证明申请人的消费能力。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub40"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title"> 定期存款单复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title=" 定期存款单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下定期存单复印件，提供配偶名下的定期存单需同时提供结婚证复印件。用以证明申请人的资金情况。建议定期存单的开户日期超过3个月且金额超过5万元人民币。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub41"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">5万元存款证明单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="5万元存款证明单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>银行开具的存款证明书原件，建议金额不低于5万元，冻结至少3个月而且需要结冻到回国之后的日期。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub37"><img
		src="qianzhen/image/xingshizheng.jpg">
	<dl>
		<dt><span class="info_title">车辆行驶证复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="车辆行驶证是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下或配偶名下的行驶证复印件，用以证明申请人固定资产。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub33"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">房产证或购房合同复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="房产证或购房合同是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下的房产证原件或购房合同复印件，用以证明申请人的固定资产。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">工作证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub140"><img src="qianzhen/image/wenjian.jpg">
	<dl>
		<dt><span class="info_title">在职证明原件</span><span class="info_note"></span></dt>
		<dd>请在${compname}下载在职证明模板按照个人情况修改，需用公司正规的抬头纸打印，信中需要写明申请人的姓名、护照号码、任职时间、职位、每月收入总额、放假日期及逗留时间、公司地址、联系电话、传真号码。单位负责人证明信上签名并加盖公司公章。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/在职证明表-各国通用-旅游签证.doc"
			title="在职证明表-各国通用-旅游签证">在职证明表-各国通用-旅游签证</a></dd>
	</dl>
	</div>
	<div class="info fix" id="sub61"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">营业执照或机构代码证复印件</span><span
			class="info_note"></span><span>&nbsp;&nbsp;<a
			href="javascript:showSample(262,61);">[查看样本]</a></span></dt>
		<dd>申请人提供所在企业《营业执照副本》或非企业《机构代码证副本》用A4纸规格清晰复印件一份，需要清晰的年检章且需加盖公司红色公章。如申请人就职于央企、银行、500强、特殊机构等单位不能提供的，建议您在《在职证明》中标注因公司规定无法为个人提供营业执照/机构代码证复印件的字样，取得使馆的理解。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">其他补充资料</span></dt>
	<dd>
	<div class="info fix" id="sub125"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">计划行程安排复印件</span><span
			class="info_note"></span></dt>
		<dd>请附中英文对照的计划行程安排，用以向签证官证明申请人的行程计划。${compname}可提供递交签证材料用的计划行程单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub57"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">机票预定单复印件复印件</span><span
			class="info_note"></span></dt>
		<dd>由机票代理或航空公司出具的往返机票预订单。${compname}可提供递交签证材料用的机票预订单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub53"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">国外知名景点照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="国外知名景点照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人曾经在国外知名景点拍摄的照片，最好是与人合影的照片，辅助证明有过真实的出境记录。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub48"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">全家福照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="全家福照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人全家福照片，体现家庭关系和睦，用于证明在国内有约束力。</dd>
	</dl>
	</div>
	</dd>
</dl>
</div>

<div id="tab2" style="display: none;">

<ul class="tab_info">
	<li>
	<p>自由职业的申请人请尽量提供一些关于收入能力的文件，对于您的签证申请是有帮助的。</p>
	</li>
</ul>
<dl>
	<dt class="sub_title"><span class="dib">身份证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub1"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">护照原件</span><span class="info_note"></span></dt>
		<dd>有效期超过6个月的因私护照，如有旧护照请提供，如旧护照丢失需公安机关开具丢失证明。<br />

		PS：护照号码为G开头的旧版护照，签名页（尾页）要由申请人亲笔签名。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub20"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">2寸证件照片2张原件</span><span
			class="info_note"></span></dt>
		<dd>近半年内拍摄的白色背景2寸彩色证件照片2张，规格：33*48mm或35*45mm.</dd>
	</dl>
	</div>
	<div class="info fix" id="sub3"><img src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">身份证复印件</span><span class="info_note"></span></dt>
		<dd>申请人有效身份证正反面复印件一份，尽可能的复印清晰些。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub5"><img src="qianzhen/image/hukouben.jpg">
	<dl>
		<dt><span class="info_title">户口本复印件</span><span class="info_note"></span><span>&nbsp;&nbsp;<a
			href="javascript:showSample(262,5);">[查看样本]</a></span></dt>
		<dd>申请人所在户口本所有信息页的复印件一套，需包含户口本首页、户主页、本人页及配偶页（包括迁出、注销页）。<br />

		</dd>
	</dl>
	</div>
	<div class="info fix" id="sub7"><img src="qianzhen/image/jiehunzheng.jpg">
	<dl>
		<dt><span class="info_title">结婚证或离婚证复印件</span><span
			class="info_note"></span></dt>
		<dd>已婚者请提供结婚证或离婚证复印件，证件丢失者需在派出所/民政局开具相关证明（未婚者忽略此条）。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub166"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">个人资料表原件</span><span
			class="info_note"></span></dt>
		<dd>请在${compname}下载个人资料表并完整填写，此表格不会递交给使馆，将用于填写递交使馆的英文签证申请表，请申请人认真填写。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/个人资料表-加拿大签证专用.doc"
			title="个人资料表-加拿大签证专用">个人资料表-加拿大签证专用</a></dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">资产证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub28"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">近6个月活期明细对账单原件</span><span
			class="info_note"> (必选)&nbsp;<a class="iconfont" href=""
			title="近6个月活期明细对账单是必须提供">&#x3574;</a></span></dt>
		<dd>申请人本人名下银行活期存折或银行卡最近6个月的对账单，最好使用工资卡对账单，用以证明收入情况，余额建议超过3万以上用以证明可以支付本次出行的费用，也可使用多张卡对账单证明收入和余额的情况。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub42"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">3个月信用卡对账单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="3个月信用卡对账单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下的信用卡3个月对账单，银行邮寄的原件或银行发送的E-mail电子对账单打印件，用以证明申请人的消费能力。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub40"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title"> 定期存款单复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title=" 定期存款单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下定期存单复印件，提供配偶名下的定期存单需同时提供结婚证复印件。用以证明申请人的资金情况。建议定期存单的开户日期超过3个月且金额超过5万元人民币。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub41"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">5万元存款证明单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="5万元存款证明单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>银行开具的存款证明书原件，建议金额不低于5万元，冻结至少3个月而且需要结冻到回国之后的日期。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub37"><img
		src="qianzhen/image/xingshizheng.jpg">
	<dl>
		<dt><span class="info_title">车辆行驶证复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="车辆行驶证是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下或配偶名下的行驶证复印件，用以证明申请人固定资产。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub33"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">房产证或购房合同复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="房产证或购房合同是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下的房产证原件或购房合同复印件，用以证明申请人的固定资产。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">工作证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub130"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">离职证明原件</span><span class="info_note">
		(可选)&nbsp;<a class="iconfont" href="" title="离职证明是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>此个人说明适用于自由职业者或无业者，用以向签证官说明上一份工作的入职和离职时间、月薪和职位情况，需原就职公司抬头纸打印和盖章原件。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub131"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">自由职业者或无业个人说明原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="自由职业者或无业个人说明是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>此个人说明的目的最好配合《离职证明》一起使用，情况因人而异没有标准格式，用以向签证官表述上一份工作的情况与目前的状态的说明，如果有下一份工作计划的时间也可一并写上，用以取得签证官的理解和信任，提高签证通过率，电脑打印，申请人签名即可。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub132"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">自由职业者收入证明文件复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="自由职业者收入证明文件是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>可提供项目合同，艺术家提供作品，淘宝店可打印开店的注册信息，用以向签证官证明自由职业者的工作和收入情况。无业已婚者（如家庭主妇）需提供配偶的在职证明和收入证明，加经过外交部认证的婚姻关系公证书的原件。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">其他补充资料</span></dt>
	<dd>
	<div class="info fix" id="sub125"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">计划行程安排复印件</span><span
			class="info_note"></span></dt>
		<dd>请附中英文对照的计划行程安排，用以向签证官证明申请人的行程计划。${compname}可提供递交签证材料用的计划行程单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub57"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">机票预定单复印件复印件</span><span
			class="info_note"></span></dt>
		<dd>由机票代理或航空公司出具的往返机票预订单。${compname}可提供递交签证材料用的机票预订单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub53"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">国外知名景点照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="国外知名景点照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人曾经在国外知名景点拍摄的照片，最好是与人合影的照片，辅助证明有过真实的出境记录。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub48"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">全家福照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="全家福照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人全家福照片，体现家庭关系和睦，用于证明在国内有约束力。</dd>
	</dl>
	</div>
	</dd>
</dl>
</div>

<div id="tab3" style="display: none;">

<ul class="tab_info">
	<li>
	<p>退休人员无需出示单位的证明文件，提供退休证即可替代在职人员的工作信息。</p>
	</li>
</ul>
<dl>
	<dt class="sub_title"><span class="dib">身份证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub1"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">护照原件</span><span class="info_note"></span></dt>
		<dd>有效期超过6个月的因私护照，如有旧护照请提供，如旧护照丢失需公安机关开具丢失证明。<br />

		PS：护照号码为G开头的旧版护照，签名页（尾页）要由申请人亲笔签名。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub20"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">2寸证件照片2张原件</span><span
			class="info_note"></span></dt>
		<dd>近半年内拍摄的白色背景2寸彩色证件照片2张，规格：33*48mm或35*45mm.</dd>
	</dl>
	</div>
	<div class="info fix" id="sub3"><img src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">身份证复印件</span><span class="info_note"></span></dt>
		<dd>申请人有效身份证正反面复印件一份，尽可能的复印清晰些。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub5"><img src="qianzhen/image/hukouben.jpg">
	<dl>
		<dt><span class="info_title">户口本复印件</span><span class="info_note"></span><span>&nbsp;&nbsp;<a
			href="javascript:showSample(262,5);">[查看样本]</a></span></dt>
		<dd>申请人所在户口本所有信息页的复印件一套，需包含户口本首页、户主页、本人页及配偶页（包括迁出、注销页）。<br />

		</dd>
	</dl>
	</div>
	<div class="info fix" id="sub7"><img src="qianzhen/image/jiehunzheng.jpg">
	<dl>
		<dt><span class="info_title">结婚证或离婚证复印件</span><span
			class="info_note"></span></dt>
		<dd>已婚者请提供结婚证或离婚证复印件，证件丢失者需在派出所/民政局开具相关证明（未婚者忽略此条）。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub166"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">个人资料表原件</span><span
			class="info_note"></span></dt>
		<dd>请在${compname}下载个人资料表并完整填写，此表格不会递交给使馆，将用于填写递交使馆的英文签证申请表，请申请人认真填写。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/个人资料表-加拿大签证专用.doc"
			title="个人资料表-加拿大签证专用">个人资料表-加拿大签证专用</a></dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">资产证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub35"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">6个月养老金对账单原件</span><span
			class="info_note"></span></dt>
		<dd>申请人名下近6个月养老金明细对账单并加盖银行公章。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub42"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">3个月信用卡对账单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="3个月信用卡对账单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下的信用卡3个月对账单，银行邮寄的原件或银行发送的E-mail电子对账单打印件，用以证明申请人的消费能力。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub40"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title"> 定期存款单复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title=" 定期存款单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下定期存单复印件，提供配偶名下的定期存单需同时提供结婚证复印件。用以证明申请人的资金情况。建议定期存单的开户日期超过3个月且金额超过5万元人民币。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub41"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">5万元存款证明单原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="5万元存款证明单是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>银行开具的存款证明书原件，建议金额不低于5万元，冻结至少3个月而且需要结冻到回国之后的日期。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub37"><img
		src="qianzhen/image/xingshizheng.jpg">
	<dl>
		<dt><span class="info_title">车辆行驶证复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="车辆行驶证是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人名下或配偶名下的行驶证复印件，用以证明申请人固定资产。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub33"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">房产证或购房合同复印件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="房产证或购房合同是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人本人或配偶名下的房产证原件或购房合同复印件，用以证明申请人的固定资产。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">工作证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub63"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">退休证复印件</span><span class="info_note"></span></dt>
		<dd>退休者需提供退休证复印件，若是内退请用单位信签纸开具内退证明，需负责人签证并盖单位公章。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">其他补充资料</span></dt>
	<dd>
	<div class="info fix" id="sub125"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">计划行程安排复印件</span><span
			class="info_note"></span></dt>
		<dd>请附中英文对照的计划行程安排，用以向签证官证明申请人的行程计划。${compname}可提供递交签证材料用的计划行程单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub57"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">机票预定单复印件复印件</span><span
			class="info_note"></span></dt>
		<dd>由机票代理或航空公司出具的往返机票预订单。${compname}可提供递交签证材料用的机票预订单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub53"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">国外知名景点照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="国外知名景点照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人曾经在国外知名景点拍摄的照片，最好是与人合影的照片，辅助证明有过真实的出境记录。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub48"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">全家福照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="全家福照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人全家福照片，体现家庭关系和睦，用于证明在国内有约束力。</dd>
	</dl>
	</div>
	</dd>
</dl>
</div>

<div id="tab4" style="display: none;">

<ul class="tab_info">
	<li>
	<p>申请人为学生需要提供学校开具的《在校证明》即使是法定节假日或者寒、暑假使馆要求也需要提供《在校证明》。</p>
	</li>
</ul>
<dl>
	<dt class="sub_title"><span class="dib">身份证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub1"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">护照原件</span><span class="info_note"></span></dt>
		<dd>有效期超过6个月的因私护照，如有旧护照请提供，如旧护照丢失需公安机关开具丢失证明。<br />

		PS：护照号码为G开头的旧版护照，签名页（尾页）要由申请人亲笔签名。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub20"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">2寸证件照片2张原件</span><span
			class="info_note"></span></dt>
		<dd>近半年内拍摄的白色背景2寸彩色证件照片2张，规格：33*48mm或35*45mm.</dd>
	</dl>
	</div>
	<div class="info fix" id="sub3"><img src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">身份证复印件</span><span class="info_note"></span></dt>
		<dd>申请人有效身份证正反面复印件一份，尽可能的复印清晰些。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub5"><img src="qianzhen/image/hukouben.jpg">
	<dl>
		<dt><span class="info_title">户口本复印件</span><span class="info_note"></span><span>&nbsp;&nbsp;<a
			href="javascript:showSample(262,5);">[查看样本]</a></span></dt>
		<dd>申请人所在户口本所有信息页的复印件一套，需包含户口本首页、户主页、本人页及配偶页（包括迁出、注销页）。<br />

		</dd>
	</dl>
	</div>
	<div class="info fix" id="sub79"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">出生医学证明复印件</span><span
			class="info_note"></span></dt>
		<dd>申请人未满12岁需提供出生医学证明复印件。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub166"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">个人资料表原件</span><span
			class="info_note"></span></dt>
		<dd>请在${compname}下载个人资料表并完整填写，此表格不会递交给使馆，将用于填写递交使馆的英文签证申请表，请申请人认真填写。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/个人资料表-加拿大签证专用.doc"
			title="个人资料表-加拿大签证专用">个人资料表-加拿大签证专用</a></dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">资产证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub215"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">学生或儿童资产证明原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="学生或儿童资产证明是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>学生与儿童没有固定的收入来源，资产证明材料需父母的在职与收入证明一起提供。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">工作证明资料</span></dt>
	<dd>
	<div class="info fix" id="sub65"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">学生在校证明原件</span><span
			class="info_note"></span></dt>
		<dd>在${compname}下载在校证明模板修改，需注明班级、专业、假期，用学校抬头纸打印，请学校负责人亲笔签名并盖学校公章或教务章，此证明中文即可。</dd>
		<dd class="downfile"><span>下载：</span>&nbsp;&nbsp;<a
			target="_blank" href="/d/file/example/在校证明表-各国通用.doc"
			title="在校证明表-各国通用">在校证明表-各国通用</a></dd>
	</dl>
	</div>
	<div class="info fix" id="sub64"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">学生证复印件</span><span class="info_note"></span></dt>
		<dd>学生证复印件一份。</dd>
	</dl>
	</div>
	</dd>
</dl>
<dl>
	<dt class="sub_title"><span class="dib">其他补充资料</span></dt>
	<dd>
	<div class="info fix" id="sub237"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">亲属关系公证书原件</span><span
			class="info_note"></span></dt>
		<dd>申请人未满18周岁的学生/儿童需提供亲属关系公证书原件。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub238"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">授权公证书原件</span><span
			class="info_note"></span></dt>
		<dd>当未满18周岁的学生/儿童单独旅行时，或跟随单方家长旅行时，需要提供双方家长或另一方家长出具出行同意书的公证书。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub125"><img
		src="qianzhen/image/shenfenzheng.jpg">
	<dl>
		<dt><span class="info_title">计划行程安排复印件</span><span
			class="info_note"></span></dt>
		<dd>请附中英文对照的计划行程安排，用以向签证官证明申请人的行程计划。${compname}可提供递交签证材料用的计划行程单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub57"><img src="qianzhen/image/huzhao.jpg">
	<dl>
		<dt><span class="info_title">机票预定单复印件复印件</span><span
			class="info_note"></span></dt>
		<dd>由机票代理或航空公司出具的往返机票预订单。${compname}可提供递交签证材料用的机票预订单。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub53"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">国外知名景点照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="国外知名景点照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人曾经在国外知名景点拍摄的照片，最好是与人合影的照片，辅助证明有过真实的出境记录。</dd>
	</dl>
	</div>
	<div class="info fix" id="sub48"><img src="qianzhen/image/zhaopian.jpg">
	<dl>
		<dt><span class="info_title">全家福照片原件</span><span
			class="info_note"> (可选)&nbsp;<a class="iconfont" href=""
			title="全家福照片是多项之一 可选择提供">&#x3574;</a></span></dt>
		<dd>申请人全家福照片，体现家庭关系和睦，用于证明在国内有约束力。</dd>
	</dl>
	</div>
	</dd>
</dl>
</div>

</div>

<div class="left_service">

<ul>

	<li><span>费用相关提示</span></li>

</ul>

<div class="service_box">

<dl>

	<dt><span>费用包含</span></dt>

	<dd>1.申请资料辅助填表服务。<br />

	2.申请资料辅助翻译服务。<br />

	3.申请资料整理服务。<br />

	4.使馆签证费</dd>

</dl>

<dl>

	<dt><span>费用不含</span></dt>

	<dd>1.快递费及未提及费用。</dd>

</dl>

<div style="font: 0px/ 0px sans-serif; clear: both; display: block">
</div>

</div>

</div>

</div>

<div class="left_content_down">

<div class="left_ask">

<div id="show_ask" class="show_ask">
<ul>
	<li class="show_ask_rper"><span>Happy旅游&nbsp;-&nbsp;2013年
	07月09日 21:55</span></li>
	<li class="show_ask_title"><a ellipsis" title="加拿大旅游签证"
		target="_blank" href="#">问：加拿大旅游签证</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：加拿大签证的价格分不同领区和单次多次，所以价格不一样，详细价格可以参考下面的链接

	<!-- http://www.ailvxing.com/visa/America/Canada/  -->
	通常短期签证的停留期在90天...</p>
	</li>
</ul>

<ul>
	<li class="show_ask_rper"><span>匿名用户&nbsp;-&nbsp;2012年
	10月31日 10:33</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="加拿大有亲属，不是直系，申请加拿大旅游签证的话是否需要显示出来？" target="_blank"
		href="#">问：加拿大有亲属，不是直系，申请加拿大旅游签证的话是否需要显示出来？</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：如果你申请旅游签就不要填写你姑姑的信息了，会让签证官觉得你的申请目的不明确，而且不是直系亲属不表明也没关系。</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>匿名用户&nbsp;-&nbsp;2012年
	10月30日 09:38</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="第一次申请加拿大签证的话可以直接申请多次吗" target="_blank" href="#">问：第一次申请加拿大签证的话可以直接申请多次吗</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：你好，总体来说呢，加拿大签证不太容易获得，那么加拿大多次入境签证就更难了，如果你之前没有过加拿大出入境记录的话建议还是先申请单次吧，有了单次出入境记录后再申请多次就更容易获得了，虽然你资料情况确实不错，如果签证官认...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>匿名用户&nbsp;-&nbsp;2012年
	10月29日 11:01</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="请问如果未婚,没有房子等固定资产,之前也没有欧美旅游记录,加拿大旅游签证好签么"
		target="_blank" href="#">问：请问如果未婚,没有房子等固定资产,之前也没有欧美旅游记录,加拿大旅游签证好签么</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：你好，你的情况不太好，比较难获得加拿大签证。加拿大签证通常比较关心申请人的出入境历史，资金状况，出境目的，申请人国内的稳定状况等因素，可是看你的描述来看，貌似你的情况不符合加拿大使馆的签证要求，比较难通过，如果仅仅是旅...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>太过浪漫主义&nbsp;-&nbsp;2011年
	10月09日 11:21</span></li>
	<li class="show_ask_title"><a ellipsis" title="请教加拿大旅游签证在职证明的问题"
		target="_blank" href="#">问：请教加拿大旅游签证在职证明的问题</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：1.在职证明一定不可以本人签名，如果本人是法人的话，副手签字就可以。
	2.资金、出境记录没有问题的话通常比较容易获得加拿大签证，根据你的情况看出签的几率很大。...</p>
	</li>
</ul>
<ul>
	<li class="show_ask_rper"><span>太过浪漫主义&nbsp;-&nbsp;2010年
	10月15日 17:59</span></li>
	<li class="show_ask_title"><a
		ellipsis" title="办理加拿大旅游签证成功的游人们，讲讲你的经历好吗？" target="_blank" href="#">问：办理加拿大旅游签证成功的游人们，讲讲你的经历好吗？</a></li>
	<li class="show_ask_rp">
	<p class="ellipsis">答：一、心理准备：不签证不知道咱们还是第三世界国家的人民，想去发达国家花钱都得看别人的脸色。首先我们必须认识到这一点，放低姿态，积极准备、同时也做好签不过的准备。即便签不过也不要在签证处和人家吵闹呀。我签之前用了...</p>
	</li>
</ul>
</div>

<div class="addask_more"><a href="#">查看更多<span
	id="visa_keyword">加拿大旅游签证</span>问题…</a></div>

<span class="addask_btn"><a href="javascript:visa_addAsk();">
</a></span>

<div id="addask_form" class="addask_form" style="display: none;">



<form>

<div class="ask_post_title">

<h2>写下你的问题(不能为空)</h2>

<textarea id="ask_title" name="title"></textarea></div>

<div class="ask_post_buchong">

<h2>问题补充(可选)</h2>

<textarea id="ask_buchong" name="buchong"></textarea></div>

<div class="ask_post_tags">

<h2>至少要添加一个标签</h2>

<input id="ask_tags" value="" name="infotags" /></div>

</form>

</div>

</div>

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

</div>

<div class="visa_info_right">

<div class="right_range">

<dl>

	<dt><span><ww:property value="qzchanpininfo.title"/>服务范围</span></dt>

	<dd>

	<p><ww:property value="qzchanpininfo.confine"/></p>

	</dd>

</dl>

</div>

<div class="right_downfile" style="display: none;"><span
	class="downfile_title">旅游签证模板下载</span>

<ul id="downfile_list" class="downfile_list"></ul>

<p>加拿大旅游签证模板下载，建议点击右键选择(目标另存为)</p>

</div>

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

<div class="visa_seo">
<p>${compname}为您提供 ,加拿大旅游签证 ,加拿大探亲访友 ,加拿大商务签证 的签证办理服务！</p>

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

<div style="font: 0px/ 0px sans-serif; clear: both; display: block">
</div>

</div>

</div>
<div><ww:include page="../footer.jsp" /></div>

<!--<div class="footer">

<div class="bottom">

<div class="bottom_links"><a target="_blank" rel="nofollow"
	href="#">关于我们</a> &#12288;|&#12288;<a target="_blank" rel="nofollow"
	href="#">联系我们</a> &#12288;|&#12288; <a target="_blank" rel="nofollow"
	href="#">工作机会</a> &#12288;|&#12288;<a target="_blank" rel="nofollow"
	href="#">隐私权政策</a> &#12288;|&#12288; <a target="_blank" rel="nofollow"
	href="#">合作伙伴</a> &#12288;|&#12288; <a target="_blank" rel="nofollow"
	href="#">服务声明</a></div>

<div class="bottom_info fix">

<div class="copyright">

<p><span>Copyright &copy; 2008-2013 AiLvXing.com, Inc. All
Rights Reserved</span> <br />

<a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow">
京ICP备11009434号-1 </a> 客服电话：400-610-6678
未开通400地区&nbsp;(010)&nbsp;5351&nbsp;0852</p>

</div>

<div class="authentication"><a
	href="http://union.rising.com.cn/InfoManage/attestation.aspx?p0=-ujc0DLaZoQyRO8TjrFDbGdNzFG09DKUDENxVluALuc="
	class="a4" target="_blank" rel="nofollow">瑞星网络安全</a><a
	href="http://www.cyberpolice.cn/" class="a3" target="_blank"
	rel="nofollow">网络110</a><a href="http://webscan.360.cn" class="a2"
	target="_blank" rel="nofollow">360安全中心</a><a
	href="http://www.hd315.gov.cn" class="a1" target="_blank"
	rel="nofollow">经营性网站备案中心</a></div>

</div>

</div>

</div>-->

<script src="http://www.ailvxing.com/e/extend/stats/"></script>

<script type="text/javascript">

var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");

document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F02c232ea57353c9d7d674ca2a18e4e51' type='text/javascript'%3E%3C/script%3E"));

</script>



<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery/jquery-1.7.1.min.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/artDialog/4.1.7/jquery.artDialog.js?skin=pure"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery.tagsinput.min.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/jquery.textareaCounter.plugin.js"></script>

<script charset="utf-8" type="text/javascript"
	src="qianzhen/js/fancybox/jquery.fancybox.min.js"></script>

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