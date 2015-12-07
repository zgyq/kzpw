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
<title>订单详细信息</title>
<link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script>
   function rTPnr()
    {
       var pnrinfo=document.getElementById("pnrinfo");
       pnrinfo.style.display="block";
       setTimeout("loadPnr()",1000);
       
    }
    function loadPnr()
    {
       var strPnrinfo="**ELECTRONIC TICKET PNR** <br> 1.YIXUAN/SHICHD XP8VR <br> 2. FM9311 Y FR19MAR SHACAN RR1 0930 1130 E <br> 3.FUO/T FUO/T 0757-82263555/FUO SHUN AN DA AIR SERVICE CO.,LTD/CHEN MING JUN <br> ABCDEFG <br> 4.SHISHAN1 <br> 5.0757-86688155 MEI 13535661430<br> 6.T<br> 7.SSR FOID <br> 8.SSR ADTK 1E BY FUO17MAR10/0930 OR CXL FM9311 Y19MAR <br> 9.SSR TKNE FM HK1 SHACAN 9311 Y19MAR 7743868306688/1/P1<br>10.RMK AUTOMATIC FARE QUOTE <br>11.RMK CA/K7231 <br>12.FN/A/FCNY640.00/SCNY640.00/C3.00/XCNY30.00/TEXEMPTCN/TCNY30.00YQ/ACNY670.00 <br>13.TN/774-3868306688/P1 <br>14.FP/CASH,CNY <br>j<Qp>> 7o <015.FUO112 <br> -";
       
       $("#pnrinfo").html(strPnrinfo);
    }
    function goEdit(url)
    {
       window.location.href=url;
    }
	</script>
</head>
<body>
<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;在线支付</b></td>
	</tr>
</table>

<div class="base_b base_bgcolor02"><!--航班和乘客信息-->

<div class="flt_silhouette" cdm="blk_ticketinfo"><span
	class="flt_shadow_t"></span><span class="flt_shadow_m">
<div class="flt_shadow_content">
<div class="flt_info" cdm="blk_flightinfo">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">订单基本信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="left" colspan="9" id="pnrinfo"
						style="display: none; background-color: Black;color:#00ff00;height:121px">
						
					<!--  <iframe id="pnrFrame" src="#"  width="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto" style="width: 101%; height: 146px;">-->
					<img
						src='images/loadpnr.gif' /><font color="00ff00"><b>正在加载PNR信息.....</b></font>
					<!--</iframe>-->
					</td>
				</tr>
				<tr height="20px"><td></td></tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.ordernumber" /></td>
					<td class="table_color_r colortrin" width="10%">PNR编号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.pnr" />&nbsp;&nbsp;<input type="button"
						name="btnCancel" id="btnRT" value="提取PNR" onclick="rTPnr();"
						class="button_d font-white"></td>
					<td class="table_color_r colortrin" width="10%">创建日期：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.createtime)" /></td>
					<td class="table_color_r colortrin" width="10%">订单状态：</td>
					<td class="table_color_l" width="15%"><span style="color: red"><ww:property
						value="getStateToString(orderinfo.orderstatus)" /></span></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">联系人姓名：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.contactname" /></td>
					<td class="table_color_r colortrin" width="10%">联系人手机：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.contactmobile" /></td>
					<td class="table_color_r colortrin" width="10%">联系人邮件：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.contactemail" /></td>
					<td class="table_color_r colortrin" width="10%">送票地址：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.addresa" /></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">分销商名称：</td>
					<td class="table_color_l" width="15%">东航商旅</td>
					<td class="table_color_r colortrin" width="10%">分销商联系方式：</td>
					<td class="table_color_l" width="15%">13546787888</td>
					<td class="table_color_r colortrin" width="10%">分销商等级：</td>
					<td class="table_color_l" width="15%">高级分销商</td>
					<td class="table_color_r colortrin" width="10%">出票供应商：</td>
					<td class="table_color_l" width="15%">易梦代理点</td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">支付方式：</td>
					<td class="table_color_l" width="15%">网上支付</td>
					<td class="table_color_r colortrin" width="10%">支付状态：</td>
					<td class="table_color_l" width="15%">未支付</td>
					<td class="table_color_r colortrin" width="10%">关联订单号：</td>
					<td class="table_color_l" width="15%"><a
						href="orderinfo!toshow.action?id=<ww:property value="orderinfo.relationorderid" />"><ww:property
						value="orderinfo.relationorderid" /></a></td>
					<td class="table_color_r colortrin" width="10%">出票时间：</td>
					<td class="table_color_l" width="15%">未出票</td>
				</tr>
				<tr height='1px'>
					<td colspan='9'><br />
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ul>

<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">航程信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table id="tbTravel" class="book_pgcontent" width="98%" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td widht="20px"></td>
						<td>航空公司</td>
						<td>航班号</td>
						<td>起飞城市</td>
						<td>到达城市</td>
						<td>起飞时间</td>
						<td>到达时间</td>
						<td>舱位</td>
						<td>折扣</td>
					</tr>
					<ww:iterator value="listSegment">
						<tr class='postbg1' align="center" valign="middle">
							<td widht="20px"></td>
							<td><img
								src="images/airComlogo/<ww:property value="getAircomapnycodeByEZM(aircomapnycode)"/>.gif"
								border="0" /><ww:property value="aircomapnycode" /></td>
							<td><ww:property value="flightnumber" /></td>
							<td><ww:property value="getCitynameByAirport(startairport)" /></td>
							<td><ww:property value="getCitynameByAirport(endairport)" /></td>
							<td><ww:property value="formatTimestamp(departtime)" /></td>
							<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
							<td><ww:property value="cabincode" /></td>
							<td><ww:property value="discount" /></td>
						</tr>
					</ww:iterator>

					<tr height='1px'>
						<td colspan='9'><br />
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</table>
</ul>
</div>
</div>
</span><span class="flt_shadow_f"></span></div>


<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">乘机人信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tbody>
					<tr class='GridViewHeaderStyle'
						style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
						<td>乘客类型</td>
						<td>乘客姓名</td>
						<td>证件类型</td>
						<td>证件号码</td>
						<td>票号</td>
						<td>票价</td>
						<td>燃油</td>
						<td>机建</td>
					</tr>
					<ww:iterator value="listPassenger">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="getPassTypeToString(ptype)" /></td>
							<td><ww:property value="name" /></td>
							<td><ww:property value="getIDTypeToString(idtype)" /></td>
							<td><span id="gdvTic_ctl02_lbtnzj"><ww:property
								value="idnumber" /></span></td>
							<ww:if test="ticketnum!=null">
								<td><ww:property value="ticketnum" /></td>
							</ww:if>
							<ww:else>
								<td>暂无</td>
							</ww:else>
							<td><ww:property value="formatMoney(price)" /></td>
							<td><ww:property value="formatMoney(fuelprice)" /></td>
							<td><ww:property value="formatMoney(airportfee)" /></td>
						</tr>
					</ww:iterator>
					<tr height='1px'>
						<td colspan='9'><br />
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>

	</table>
</ul>

<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">票款信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tbody>
					<tr class='GridViewHeaderStyle'
						style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
						<td>总票价</td>
						<td>总燃油费</td>
						<td>总机建费</td>
						<td>应付款</td>
						
					</tr>
					<ww:iterator value="listPassenger">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="formatMoney(price)" /></td>
							<td><ww:property value="formatMoney(fuelprice)" /></td>
							<td><ww:property value="formatMoney(airportfee)" /></td>
							<td><span style="color:red;font-weight:bold"><ww:property value="formatMoney(price+fuelprice+airportfee)" /></span></td>
						</tr>
					</ww:iterator>
					<tr height='1px'>
						<td colspan='9'><br />
						</td>
					</tr>
					<tr><td colspan='9'>
					
				
					<input type="button" id="btnCancel" value="取消支付" class="button_d font-white" onclick="javascript:window.history.go(-1)" />
					<input type="button" name="btnPay" id="btnPay" value="立即支付" class="button_d font-white" onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="orderinfo.id" />&orderstatus=2')" />
					
					
				
					
					<ww:elseif test=""></ww:elseif>
					
					</td></tr>
				</tbody>
			</table>
			</td>
		</tr>

	</table>
</ul>
</div>
</body>
</html>