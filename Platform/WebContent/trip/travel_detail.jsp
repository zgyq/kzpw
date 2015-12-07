<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	/**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/Travel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<script language="javascript">
  function triptab(a)
   {
	 for(var i=1;i<=3;i++)
	 {
	 	document.getElementById("trip_tui"+i).style.background="url(images/webimages/nav_city_b.gif)";
	 	document.getElementById("trip_tuia"+i).style.color="";
	 	document.getElementById("divtab_"+i).style.display="none";
	 	
	 }
	 document.getElementById("trip_tui"+a).style.background="url(images/webimages/nav_city_l.gif)";
	 document.getElementById("trip_tuia"+a).style.color="#FFFFFF";
	 document.getElementById("divtab_"+a).style.display="block";
    }
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;旅游线路详细信息</span></td>
	</tr>
	<tr>
		<td>
			<ww:if test="usertype!=2">
			<jsp:include page="../orderuserinfo.jsp"></jsp:include>
			</ww:if>
		</td>
	</tr>
<tr>
<td>
<div id="container">
<div class="f left">
<form name="form1" action="triplinebook!toBook.action" method="post">
<div style="height:10px"></div>
<input type="hidden" value="<ww:property value="tripline.id"/>" name="hidtripid">
<div class="f" style="border: 1px solid #999999;"><img
	src="<ww:property value="getimgPath()+tripline.image"/>"
	width="240" height="180" style="margin: 1px; cursor: hand" /></div>
<div class="r" style="width: 490px;">
<ul>
    <li><span class="hui14">线路名称</span>:<font class="lan14_cu1"><ww:property value="tripline.name" /></font></li>
	<li><span class="hui14">参考价</span>：<font class="red14_cu"><ww:property
		value="tripline.price" /> <input type="hidden"
		value="<ww:property value="tripline.price"/>" name="hidprice">元起</font>
<ww:if test="usertype==2">
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<font class="red14_cu">	返<ww:property value="gettravefan(tripline.startprice)" />元</font>
<input type="hidden" name="usertype" value="<ww:property value="usertype" />" />
</ww:if>
	<li><span class="hui14">提前报名</span>：请提前<span class="red14_cu">5</span>天报名</li>
	<li><span class="hui14">出发城市</span>：<ww:property
		value="getCityName(tripline.cityid)" /></li>
	<li><span class="hui14">出发日期</span>：<ww:property
		value="tripline.startdate" /></li>
		<li><span class="hui14">线路来源</span>：<font color="red"><ww:property value="getAgentTName(tripline.customeragentid)"/></font></li>
</ul>

<div class="box2"
	style="margin-top: 10px; background: #DDECF3; padding-left: 20px; padding-top: 10px;">
<ul>
	<li><strong>在线预订</strong>:<ww:property value="tripline.price" />元/人&nbsp;人数： <select name="s_personnum" style="width: 40px">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
	</select></li>
	<li class="hui_xi">* 旅游线路价格以旅行社价格为准。<input type="submit"
		value="预订" class="button61" /></li>
	<li></li>
	
</ul>
</div>
</div>
<div class="c"></div>
<div class="nav_city">
<ul>
	<li id="trip_tui1"><a href="#" onclick="triptab(1);return false;"
		id="trip_tuia1">目的地</a></li>
	<li
		style="background: url(images/webimages/nav_city_l.gif );"
		id="trip_tui3"><a onclick="triptab(3);return false;"
		id="trip_tuia3" href="#" style="color: #FFFFFF">行程</a></li>
	<li id="trip_tui2"><a id="trip_tuia2" href="#"
		onclick="triptab(2);return false;">重要提示</a></li>
</ul>
</div>
<div class="box" style="margin-top: -1px;">
<div id="divtab_1"
	style="padding-left: 20px; padding-top: 10px; padding-right: 20px; display: none">
<ww:iterator value="tripnodeArrival">
	<span><ww:property value="content" /></span>
</ww:iterator></div>
<div id="divtab_2"
	style="padding-left: 20px; padding-top: 10px; padding-right: 20px; display: none">
<ww:iterator value="tripnodeNotice">
	<span><ww:property value="content" /></span>
</ww:iterator></div>
<div id="divtab_3"><ww:iterator value="listTriprange"
	status="state">
	<div style="padding-left: 20px; padding-top: 10px; padding-right: 20px">
	<ul>
		<li><span class="red14_cu">第<ww:property
			value="#state.index+1" />天</span>&nbsp;&nbsp;<span class="red"><ww:property
			value="name" /></span><span class="red"></span></li>
		<li><ww:iterator value="listScenic">
			<div style="width: 90px; float: left"><a
				href="triplinebook!toScenicDetail.action?sid=<ww:property value="id" />"><img
				src="<ww:property value="getimgPath()+image" />"
				width="79" height="79" /></a>
			<div style="text-align: center;"><a
				href="triplinebook!toScenicDetail.action?sid=<ww:property value="id" />"
				style="color: #999999; text-decoration: underline"><ww:property
				value="name" /></a></div>
			</div>
		</ww:iterator>
		<div class="c"></div>
		</li>
		<li style="line-height: 40px;"><ww:property value="description" /></li>

		<li
			style="height: 10px; line-height: 10px; border-bottom: 1px dashed #999999;">&nbsp;</li>
	</ul>
	</div>
</ww:iterator></div>
</form>

</div>
<div class="c" style="height: 10px"></div>
<!---------------------main_2 over-------------------->
</div>

</div>
</td>
</tr>
</table>
</body>
</html>
