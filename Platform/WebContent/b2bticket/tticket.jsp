<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/ticket.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
</head>

<body>
<div id="container">
<div id="header"><jsp:include page="../top.jsp?type=air"></jsp:include></div>



<div id="main_2">
<div class="f left">


<div class="bai14_cu er"><span><ww:property value="getCitynameByAirport(spestr)"/>特价机票推荐</span>

</div>
<div class="box" <ww:if test="listspe.size()<10">style="height: 190px;"</ww:if>>
<table width="98%" border="0" cellspacing="0" cellpadding="0"
	style="margin: 0 auto; line-height: 24px; padding: 10px 0 10px;">
	<ww:if test="listspe==null||listspe.size()==0">该城市没有特价机票</ww:if>
	<ww:iterator value="listspe" status="state">
		<ww:if test="#state.last">
			<td>
			<table width="320" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%" align="right"><ww:property
						value="formatTimestampMMdd(starttime)" /></td>
					<td width="40%" align="left"><a
						href="airsearch!tSearch.jspx?StartAirportCode=<ww:property value="startport"/>&EndAirportCode=<ww:property value="arrivalport"/>&FromDate=<ww:property value="formatTimestampyyyyMMdd(starttime)"/>&TravelType=1"
						style="cursor: pointer;"><ww:property
						value="getCitynameByAirport(startport)" />-<ww:property
						value="getCitynameByAirport(arrivalport)" /></a></td>
					<td width="20%" align="right"><ww:property value="discount/10" />折</td>
					<td width="20%" align="right" class="red_cu"><ww:property
						value="formatMoneyShort(price)" />元</td>
				</tr>
			</table>
			</td>
			</tr>
		</ww:if>
		<ww:elseif test="#state.index==listspebj.size()-2">
			<tr>
				<td>
				<table width="320" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="20%" align="right"><ww:property
							value="formatTimestampMMdd(starttime)" /></td>
						<td width="40%" align="left"><a
							href="airsearch!tSearch.jspx?StartAirportCode=<ww:property value="startport"/>&EndAirportCode=<ww:property value="arrivalport"/>&FromDate=<ww:property value="formatTimestampyyyyMMdd(starttime)"/>&TravelType=1"
							style="cursor: pointer;"><ww:property
							value="getCitynameByAirport(startport)" />-<ww:property
							value="getCitynameByAirport(arrivalport)" /></a></td>
						<td width="20%" align="right"><ww:property
							value="discount/10" />折</td>
						<td width="20%" align="right" class="red_cu"><ww:property
							value="formatMoneyShort(price)" />元</td>
					</tr>
				</table>
				</td>
		</ww:elseif>
		<ww:elseif test="#state.odd">
			<tr>
				<td class="box_bottom_xu">
				<table width="320" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="20%" align="right"><ww:property
							value="formatTimestampMMdd(starttime)" /></td>
						<td width="40%" align="left"><a
							href="airsearch!tSearch.jspx?StartAirportCode=<ww:property value="startport"/>&EndAirportCode=<ww:property value="arrivalport"/>&FromDate=<ww:property value="formatTimestampyyyyMMdd(starttime)"/>&TravelType=1"
							style="cursor: pointer;"><ww:property
							value="getCitynameByAirport(startport)" />-<ww:property
							value="getCitynameByAirport(arrivalport)" /></a></td>
						<td width="20%" align="right"><ww:property
							value="discount/10" />折</td>
						<td width="20%" align="right" class="red_cu"><ww:property
							value="formatMoneyShort(price)" />元</td>
					</tr>
				</table>
				</td>
		</ww:elseif>
		<ww:else>
			<td class="box_bottom_xu">
			<table width="320" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%" align="right"><ww:property
						value="formatTimestampMMdd(starttime)" /></td>
					<td width="40%" align="left"><a
						href="airsearch!tSearch.jspx?StartAirportCode=<ww:property value="startport"/>&EndAirportCode=<ww:property value="arrivalport"/>&FromDate=<ww:property value="formatTimestampyyyyMMdd(starttime)"/>&TravelType=1"
						style="cursor: pointer;"><ww:property
						value="getCitynameByAirport(startport)" />-<ww:property
						value="getCitynameByAirport(arrivalport)" /></a></td>
					<td width="20%" align="right"><ww:property value="discount/10" />折</td>
					<td width="20%" align="right" class="red_cu"><ww:property
						value="formatMoneyShort(price)" />元</td>
				</tr>
			</table>
			</td>
			</tr>
		</ww:else>
	</ww:iterator>
</table>
</div>




</div>

<div class="r right">
<div class="box">
<div class="lan14_cu quan">机票攻略</div>
<table width="90%" border="0" cellspacing="0" cellpadding="0"
	class="hui_xi yh_tab">
	<ww:iterator value="listSysmenssage2">
		<tr>
			<td width="215"><a href="login!toxiangxi.jspx?infoid=<ww:property value="id"/>&typeid=<ww:property value="typeid"/>"><ww:property value="title" /></a></td>
			<td><ww:property value="formatMoneyShort(pubtime)" /></td>
		</tr>
	</ww:iterator>
</table>

</div>
</div>
</div>
<div class="c"></div>
<!---------------------main_2 over-------------------->
<div style="margin-top: 10px;"><!--<iframe src="bottom.html" scrolling="no" frameborder="0" vspace="0" hspace="0" width="1002" height="100"></iframe>
--> <jsp:include page="../bottom.jsp"></jsp:include></div>
</body>
</html>
