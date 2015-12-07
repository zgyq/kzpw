<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>电子地图</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/index.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
    <style media="screen">
    body{
        margin:0;
        padding:0;
        font-size:9pt;
        line-height:1.5em;
    }
    #frame{
        width:700px;
        margin:20px auto 10px;
    }
    #form{
        margin:0 0 10px;
        text-align:center;
    }
    #form input{
        border:1px solid #ccc;
        font-size:9pt;
        width:200px;
    }
    #form button{
        font-size:9pt;
        border:1px solid #ccc;
    }
    #form button:hover{
        background:#eef;
    }
    #map{
        height:400px;
        margin:0 0 10px;
        border:5px solid #ccc;
    }
    #vifix{
        text-align:center;
    }
    #vifix a{
        color:#f00;
        text-decoration:none;
    }
    #vifix a:hover{
        color:#f96;
    }
    </style>
</head>

<body>
    <div id="frame">
       <div class="weatherNetwork">
<embed type="application/x-shockwave-flash" quality="high" width="650" height="490" wmode="transparent" base="http://flash.weather.com.cn/wmaps/" src="http://flash.weather.com.cn/wmaps/index.swf?url1=http:%2F%2Fwww.weather.com.cn%2Fweather%2F&url2=.shtml&from=cn"></embed>
       
    </div>
<div class="c"></div>
<!---------------------main_2 over-------------------->
<div style="margin-top: 10px;margin:0 auto; width:1002px"><!--<iframe src="bottom.html" scrolling="no" frameborder="0" vspace="0" hspace="0" width="1002" height="100"></iframe>
-->

</div>
</body>

</html>