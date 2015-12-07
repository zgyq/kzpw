<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>${compname}-电子地图</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/index.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
    <script src="http://ditu.google.cn/maps?file=api&amp;v=2&amp;key=ABQIAAAAEt02jxP6_YLWIJtE9fs3BRTq0Dvl6kW_WDrWv6t9fMXHzjJhthQNRQMo0Z_yONoaDsVj0k9XsuTvfA&sensor=true" type="text/javascript"></script>

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
        <div id="form">
            输入一个地址: <input id="address" value="<ww:property value="s_remarks" />" /> <button id="btn_go">查询</button>
        </div>
        <div id="info" >
        </div>
        <div id="map"></div>
        <div id="vifix">
           
        </div>
    </div>
<div class="c"></div>
<!---------------------main_2 over-------------------->
<div style="margin-top: 10px;margin:0 auto; width:1002px"><!--<iframe src="bottom.html" scrolling="no" frameborder="0" vspace="0" hspace="0" width="1002" height="100"></iframe>
-->

</div>
</body>

</html>
    <script type="text/javascript">
    window.g = {};
    window.$ = function(id){return document.getElementById(id)};
    window.onload = function() {
        if (GBrowserIsCompatible()) {

            g.map = new GMap2($("map"));
            g.map.addControl(new GLargeMapControl());
            g.map.addControl(new GMapTypeControl());
            g.map.addControl(new GScaleControl());

            g.geocoder = new GClientGeocoder();

            g.getCoordinates = function(address) {
                g.geocoder.getLatLng(
                    address,
                    function(point) {
                        if (point)
                        {
                            g.map.setCenter(point, 13);
                            var marker = new GMarker(point);
                            g.map.addOverlay(marker);
                            var info = "<strong>" + address + "</strong><br /><font style='color:#fff'>经度：" + point.lat() + "&nbsp;维度：" + point.lng()+"</font>";
                            $("info").innerHTML = info;
                            marker.openInfoWindowHtml(info);
                            marker.__address_info = info;
                            GEvent.addListener(marker, "click", function() {
                                g.map.setCenter(this.getLatLng());
                                this.openInfoWindowHtml(this.__address_info);
                                $("info").innerHTML = info;
                            });
                        }
                        else
                        {
                            alert("无法解析: " + address);
                        }
                    }
                )
            }

            $("btn_go").onclick = function(){
                g.getCoordinates($("address").value);
            }
            $("btn_go").onclick();
        }
        else {
            alert('不支持的浏览器');
        }
    }
    window.onunload = function(){
        GUnload();
    }
    </script>