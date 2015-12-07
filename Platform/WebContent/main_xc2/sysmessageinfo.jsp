<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link href="main_xc2/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="main_xc2/js/jquery.js"></script>
<script type="text/javascript" src="main_xc2/js/common.js"></script>
<script type="text/javascript" src="main_xc2/js/easySlider1.5.js"></script>
<script type="text/javascript" src="main_xc2/js/accordian.pack.js"></script>


</head>
<body>
<div class="container_body">

<div class="main_right" id="RightBox">
<div id="right">
<div class="zuolan" id="Mobile" onclick="show_menuC()"></div>
<div class="main_right_con">
<div class="clear"></div>
<div class="main_bot">
<div class="annuo">
<div class="news_header"><a href="#">更多></a><b>平台公告</b></div>
<div class="news_con">
<ul>
<ww:iterator value="sysmessageList">
	<li><a href="login!toShowMesInfo_xc.action?sysid=<ww:property value="id" />"><ww:property value="title" /></a></li>
</ww:iterator>
</ul>
</div>
</div>
<div class="news">
<div class="news_header"><a href="#">更多></a><b>行业动态</b></div>
<div class="news_con">
<ul>
	<li><a href="#">心程旅行网改版成功啦！</a></li>
	<li><a href="#">心程旅行网十大品牌排名最新排行榜</a></li>
	<li><a href="#">心程旅行网改版成功啦！</a></li>
</ul>
</div>
</div>


</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>


<div class="zuolan" id="Mobile" onclick="show_menuC()"></div>
<div class="news" style="width: 747px;height: 500px;">
<div class="news_header" style="width: 717px;text-align: center;" align="center"><b><ww:property value="sysmessage.title" /></b></div>

<div class="news_con" style="width: 747px;height: 500px;">
<ul>
	<li><ww:property value="sysmessage.content" /></li>
	
</ul>
</div>
</div>


</div>

</div>


</body>
</html>
