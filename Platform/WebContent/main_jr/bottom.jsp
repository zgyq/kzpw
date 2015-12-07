<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link rel=stylesheet type=text/css href="css/index.css">



</head>
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

<body onload="ShowTime1()">
<div align="center">
当前时间：<span class="STYLE7" id="stime"></span> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
Copyright(c) 2013 All Rights Reserved |  中国航空票务管理平台</div>
</body>
</html>

