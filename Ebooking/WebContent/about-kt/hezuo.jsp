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
		<div style=" position:absolute; top:73px; left:150px;">当前位置 ： 首页 > 合作洽谈</div>
	</div>
	<!--top over-->
	
<div id="mainer">
       <div class="f left">
       <img src="tttimages/hezuoliucheng.png" height="434" width="363">
      </div>
       <div class="right f">
        <h1>合作洽谈栏目内容</h1>
        <div class="main">
        
        <table class="tb" cellpadding="0" cellspacing="1">
			<tbody><tr>
				<td class="col1">酒店查询专线：</td>
				<td>${tel}</td>
			</tr>
			<tr>
				<td class="col1">会员查询专线：</td>
				<td>${tel}</td>
			</tr>
			<tr>
				<td class="col1">机票查询专线：</td>
				<td>${tel}</td>
			</tr>
			<tr>
				<td class="col1">团购服务电话：</td>
				<td>${tel}</td>
			</tr>
			<tr>
				<td class="col1">结算服务专线：</td>
				<td>${tel}</td>
			</tr>
                        <tr>
				<td class="col1">技术服务专线：</td>
				<td>${tel}</td>
			</tr>
                        <tr>
				<td class="col1">航空公司合作专线：</td>
				<td>${tel}</td>
			</tr>
		</tbody></table>
        <p class="mt26">24小时呼叫热线${tel}随时听候您的吩咐。</p>
        <p>&nbsp;</p>
        </div>
       </div>
       <div class="c"></div>
    </div>
</div>
﻿

<div class="c"></div>
<div><ww:include page="../footer.jsp"/></div>
</div>
</body>
</html>