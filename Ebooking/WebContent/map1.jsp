<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;}
#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
#r-result{height:100%;width:20%;float:left;}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
 <title>${compname}-电子地图<ww:property value="s_remarks" />?</title>
</head>
<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
var map = new BMap.Map("allmap"); 
           // 创建Map实例
map.centerAndZoom(<ww:property value='s_remarks' />,15);                     // 初始化地图,设置中心点坐标和地图级别。


</script>
