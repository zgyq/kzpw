<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/new.css" type="text/css" rel="stylesheet" />
<style type="text/css">
a{color:#fff;}
a:hover{color:#fff; text-decoration: underline;}
</style>

<script>

    function ShowTime1() 
	{ 
		var date=new Date(); 
		var year=date.getFullYear(); 
		var month=date.getMonth()+1; 
		var day=date.getDate(); 
		var hour=date.getHours(); 
		var minutes=date.getMinutes(); 
		var second=date.getSeconds(); 
		var timestr=year+"年"+month+"月"+day+"日 "+check(hour)+":"+check(minutes)+":"+check(second); 
		document.getElementById("stime").innerHTML=""+timestr;
		var timerID=setTimeout("ShowTime1();",1000);//这里要执行的代码就是函数本身，这样这个函数就可以不断重复的执行了！ 
	}
	function check(val){ 
		if (val<10){ 
		return("0"+val);//参数小于10时，在前面补0 
		}else{ 
		return(val); 
		} 
    }
</script> 
</head>

<body onload="ShowTime1()" style="margin:0 auto; margin:0; padding:0;">
<div class="bottom"><img src="images/time.gif"  align="absmiddle" />当前时间：<span class="STYLE7" id="stime"></span>
<font style="color:#fff; margin-left: 30px;"> Copyright(c) 2000-2011 All Rights Reserved | <font class="font-000">&nbsp;</font>${dns.companyname}业务管理平台
</font>
<div style="display:none">
<script language="javascript" type="text/javascript" src="http://js.users.51.la/6036841.js"></script>
<noscript><a href="http://www.51.la/?6036841" target="_blank"><img alt="&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;" src="http://img.users.51.la/6036841.asp" style="border:none" /></a></noscript>
</div>
</div>
</body>
</html>
