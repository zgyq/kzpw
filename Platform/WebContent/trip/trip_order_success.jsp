<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天河联盟商旅网</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<style type="text/css">
<!--
.STYLE1 {font-weight: bold}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;旅游订单生成成功</span></td>
</tr>
<tr>
<td>
<div style="height:10px"></div>
<div id="container">
 <div class="c"></div>
	   <div class="box" style="text-align:center; line-height:22px;">
	     <ul>
		   <li><img src="images/webimages/dui.gif" width="51" height="43" /><b>订单提交成功！</b></li>
		 </ul>
	   </div>
      <div class="huang"><b class="bai_c">订单信息-订单号：<ww:property value="ordertrip.code"/></b></div>
	  
	  <div class="box">
<table width="90%" border="1" cellpadding="0 "ccellspacing="0" bordercolor="#86B2D1" style="margin:0 auto; line-height:26px;border-collapse :collapse; margin-top:10px;  text-align:center;">
<tbody bgcolor="#DDECF3" class="huang12_c">
  <tr>
    <td>线路名称</td>
    <td>出发日期</td>
  </tr>
 </tbody>
  <tr>
    <td><ww:property value="getTriplineName(ordertrip.triplineid)"/></td>
    <td><ww:property value="formatTimestampyyyyMMdd(ordertrip.statetime)"/></td>
  </tr>
</table>
<table width="90%" border="1" cellpadding="0 "ccellspacing="0" bordercolor="#86B2D1" style="margin:0 auto; line-height:26px;border-collapse :collapse; margin-top:10px; margin-bottom:10px; text-align:center;">
<tbody bgcolor="#DDECF3" class="huang12_c">
  <tr>
    <td>联系人</td>
    <td>联系电话</td>
    <td>人数</td>
    <td>总金额</td>
  </tr>
 </tbody>
  <tr>
    <td><ww:property value="ordertrip.linkname"/></td>
    <td><ww:property value="ordertrip.linkmobile"/></td>
    <td><ww:property value="ordertrip.pnum"/></td>
    <td>￥<ww:property value="ordertrip.sump"/></td>

  </tr>
</table>
 <div style="margin: 0 auto; margin-top: 15px; text-align: center;">
    <input	name="" type="button" class="button108" value="预订机票" style="margin-right: 40px;" onclick="golink('login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=1');" />
    <input	name="" type="button" class="button108" value="预订酒店" style="margin-right: 40px;" onclick="golink('login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=2');" />
<!--<a href="login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=2">预订酒店</a>
<a href="login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=2">旅游预订</a>
--></div>
	<div style="height: 10px;line-height: 10px;"></div>
	  </div>
    </div>
</div>
<div class="c"></div>
<div >
</div>

</div>
<div style="height:10px"></div>
</td>
</tr>
</table>
</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>
