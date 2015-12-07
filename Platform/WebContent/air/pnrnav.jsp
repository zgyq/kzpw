<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建PNR导航页面</title>
</head>

<body>
<div style="width:450px; height:432px;margin-left:80px;">
<img src="images/xuanze.gif" width="687" height="432" border="0" usemap="#Map" />
<map name="Map" id="Map">
  <area shape="poly" coords="10,180" href="#" />
  <area shape="poly" coords="9,14,11,172,175,10" href="login!getMemberByOrder.action?s_membertype=1&importtype=1&puser&ywtype=11" />
  <!--正常状态PNR创建订单-->
  <area shape="poly" coords="228,14,450,14,344,121" href="login!getMemberByOrder.action?s_membertype=1&importtype=2&s_orderstatuspnr=11&puser&ywtype=11" />
  <!--废票PNR创建订单-->
  <area shape="poly" coords="509,10,677,10,675,182" href="login!getMemberByOrder.action?s_membertype=1&importtype=2&s_orderstatuspnr=12&puser&ywtype=11" />
  <!--退票PNR创建订单-->
  <area shape="poly" coords="9,254,11,418,169,419" href="login!getMemberByOrder.action?s_membertype=1&importtype=3&puser&ywtype=11" />
  <!--正常票号创建订单-->
  <area shape="poly" coords="341,308,228,417,458,417" href="login!getMemberByOrder.action?s_membertype=1&importtype=4&s_orderstatuspnr=11&puser&ywtype=11" />
  <!--废票票号创建订单-->
  <area shape="poly" coords="675,259,511,419,674,418" href="login!getMemberByOrder.action?s_membertype=1&importtype=4&s_orderstatuspnr=12&puser&ywtype=11" />
  <!--退票票号创建订单-->
</map>




<!--  <img src="images/xuanze.jpg" width="451"  height="432" border="0" usemap="#Map"  />
<map name="Map" id="Map">-->
 <!--  <area shape="poly" coords="22,41" href="#" />
 <!--  <area shape="poly" coords="14,11,13,178,178,15" href="login!getMemberByOrder.action?s_membertype=1&importtype=3&puser" />
  <!-- <!--正常票号创建订单-->
  <!-- <area shape="poly" coords="441,255,437,417,270,421" href="login!getMemberByOrder.action?s_membertype=1&importtype=4&puser" />
  <!--退废票号创建订单-->
  <!-- <area shape="poly" coords="273,15,435,20,439,187" href="login!getMemberByOrder.action?s_membertype=1&importtype=2&puser" />
  <!-- <!--退废票PNR创建订单-->
  <!-- <area shape="poly" coords="11,257,18,420,173,421" href="login!getMemberByOrder.action?s_membertype=1&importtype=1&puser" />
  <!--正常状态PNR创建订单-->
<!-- </map>-->
</div>
</body>
</html>
