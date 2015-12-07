<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关于${compname}</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />
<link href="../tttCssJs/index_002.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?type=ticket" />
		<div style=" position:absolute; top:73px; left:150px;">当前位置 ： 首页 > 客户服务</div>
	</div>
	<!--top over-->
	
<div id="mainer">
	<div class="f left">
		<img src="tttimages/kehu.png" height="434" width="364">
	</div>
	<div class="right f">
		<h1>客户服务</h1>
		<div class="main">
			<p>${compname}客服中心是公司所有业务的主要服务窗口，负责向客户解答相关的业务咨询及受理各种投诉。</p>
			<p>客服中心致力于不断完善服务运维体系，向广大用户提供全方位、及时周到的服务。包括提供24小时热线服务、在线回复、BBS帖子回复，网上业务信息安全审核等，同时也不断努力向合作运营商提供票务系统及服务支持。</p>
			<p>以实现建造一流的客服中心、培养一流的客服专业人才、与${compname}一起进步共同成长的愿景。优秀的客服管理团队以及专业化客服人员将为您提供全面、贴心、及时的优质金牌服务。</p>
			<p>${compname}伴随您，服务零距离。</p>
			<p class="mt26">24小时呼叫热线${tel}随时听候您的吩咐。</p>
			<p>&nbsp;</p>
		</div>
	</div>
	<div class="c"></div>
</div>

<div class="c"></div>
<div><ww:include page="../footer.jsp"/></div>
</div>
</body>
</html>