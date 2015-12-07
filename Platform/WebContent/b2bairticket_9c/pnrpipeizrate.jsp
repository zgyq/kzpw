<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>创建订单-选择政策</title>
<link type="text/css" rel="stylesheet" href="b2bairticket/css/public.css">
<link type="text/css" rel="stylesheet" href="b2bairticket/css/air.css">
<link type="text/css" rel="stylesheet" href="b2bairticket/css/jquery.ui.all.css">
<style type="text/css">
.none_ {
	display: none;
}
</style>
</head>
<body>
<div id="air">
<div class="r right"><!--航班信息开始-->
<div class="main_top">
<div class="lh34">
<div class="f">
<ul>
	<li class="font-f60-b14">北京→上海虹桥(往返)</li>
</ul>
</div>
<div class="r"></div>
<div class="c"></div>
</div>
<div>
<div class="book_top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr>
			<th scope="col">类型</th>
			<th scope="col">航班日期</th>
			<th scope="col">出发/到达</th>
			<th scope="col">航空公司/机型</th>
			<th scope="col">舱位/折扣</th>
			<th scope="col">票面价</th>
			<th scope="col">基建/燃油</th>
			<th scope="col">飞行时间</th>
		</tr>


		<tr>
			<td rowspan="2">去程</td>
			<td>2014-11-13</td>
			<td>06:30&nbsp;首都国际机场 T3</td>
			<td><img width="18" height="18" class="mt5"
				src="b2bairticket/img/HO.gif"> 上海吉祥 HO1252</td>
			<td>经济舱【W/8.5折】</td>
			<td rowspan="2"><font class=" font-f60-b16">960.0</font></td>
			<td rowspan="2">100+140=240</td>
			<td rowspan="2">2小时15分</td>
		</tr>
		<tr>
			<td>(周四)</td>
			<td>08:45 虹桥国际机场 T2</td>
			<td>机型:320&nbsp;<a
				href="http://www.cxslw.cn/demosticticket!createorder.action#"
				class="font-0053aa none_">[经停]</a></td>
			<td><a
				href="http://www.cxslw.cn/demosticticket!createorder.action#"
				class="font-0053aa">退改签</a></td>
		</tr>



		<tr>
			<td colspan="8" class="xuxian">&nbsp;</td>
		</tr>
		<tr>
			<td rowspan="2">返程</td>
			<td>2014-11-15</td>
			<td>21:55&nbsp;虹桥国际机场 T2</td>
			<td><img width="18" height="18" class="mt5"
				src="b2bairticket/img/HO.gif"> 上海吉祥 HO1251</td>
			<td>经济舱【R/8.5折】</td>
			<td rowspan="2"><font class=" font-f60-b16">960.0</font></td>
			<td rowspan="2">100+140=240</td>
			<td rowspan="2">2小时30分</td>
		</tr>
		<tr>
			<td>（周六）</td>
			<td>00:25 首都国际机场 T3</td>
			<td>机型：320</td>
			<td><a
				href="http://www.cxslw.cn/demosticticket!createorder.action#"
				class="font-0053aa">退改签</a></td>
		</tr>

	</tbody>
</table>

</div>
<!--航班详情结束--></div>
</div>
<!--航班信息结束--> <!--填写信息-->
<div class="mt10 tianxiebox">
<div class="tianxie"><font class="f font-fff-14b">填写乘客信息</font> <font
	class="r font-fff">请确认乘机人信息。</font>
<div class="c"></div>
</div>
<div class="tianxiequeren">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr>
			<td>乘客姓名</td>
			<td>乘客类型</td>
			<td>证件类型</td>
			<td>证件号</td>
			<td>保险</td>
			<td class="birthday" id="tr_td_bitthday_text">出生日期</td>
			<td class="birthday">手机号</td>
			<td></td>
		</tr>

		<tr>
			<td>周树</td>
			<td>成人</td>
			<td>护照</td>
			<td>2121212121</td>
			<td>0份</td>
			<td></td>
			<td></td>
			<td><input name="" type="checkbox" value="" checked="checked">保存常旅客</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right" colspan="8" class="xuxian">&nbsp;</td>
		</tr>

	</tbody>
</table>
</div>
</div>
<!--填写信息结束--> <!--政策信息-->
<div class="mt10" style="">

<div id="teshu_div" style="display: none;">
<div class="xuanze_right f"
	style="width: 150px; padding-left: 0px; padding-right: 10px;">
<div class="xuanze_rightnei document_pointer"
	style="width: 150px; padding-left: 0px;">
<div class="teshu font-fff-14b"
	onclick="zreateTypeTab(1)">普通政策</div>
</div>
</div>

<div class="xuanze_top font-f60-b16 f document_pointer">
<div class="xuanze_nei" onclick="zreateTypeTab(2)">特殊政策</div>
</div>
<div class="xuanze_right f" style="width: 646px;">&nbsp;</div>
<div class="c"></div>
</div>

<div id="putong_div" style="display: block;">
<div class="xuanze_top font-f60-b16 f">
<div class="xuanze_nei document_pointer" id="select_1zrate"
	onclick="zreateTypeTab(1)">普通政策</div>
</div>
<div class="xuanze_right f">
<div class="xuanze_rightnei">
<div class="teshu font-fff-14b ml11 document_pointer" id="select_2zrate"
	onclick="zreateTypeTab(2)">特殊政策</div>
</div>
</div>
<div class="c"></div>
</div>
<div class="xuanze_main">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="table_zrate_show" class="center">
	<tbody>
		<tr>
			<th scope="col" width="120" style="border-top: none;">供应选择</th>
			<th scope="col">票面价</th>
			<th scope="col">利润返点</th>
			<th scope="col">结算价</th>
			<th scope="col">总结算价(含税)</th>
			<th scope="col">出票时间</th>
			<th scope="col">废票时间</th>
			<th scope="col">政策类型</th>
			<th scope="col">出票速度</th>
		</tr>
		<tr id="tr_zrate_1_0" style="display: table-row;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio" onclick="showremark('remark_1_0');"
				value="1|0|539|6.6|13%7C341385585%7C%7C0800%7C2159%7C0800-2150%7C6.8|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_0">政策1</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">31</font>元/<font
				class="font-f60-b16">5.6%</font></td>
			<td class="xuanzeontd font-f60-b20">539</td>
			<td class="xuanzeontd font-f60-b16">659</td>
			<td class="xuanzeontd">0800-2159</td>
			<td class="xuanzeontd">0800-2150</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分钟</td>
		</tr>
		<tr id="remark_1_0" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_1" style="display: table-row;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio" onclick="showremark('remark_1_1');"
				value="1|1|540|6.4|13%7C341385587%7C%7C0830%7C2029%7C0830-2020%7C6.6|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_1">政策2</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.4%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">0830-2029</td>
			<td class="xuanzeontd">0830-2020</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_1" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_2" style="display: table-row;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio" onclick="showremark('remark_1_2');"
				value="1|2|540|6.4|13%7C341385589%7C%7C0800%7C2129%7C0800-2120%7C6.6|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_2">政策3</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.4%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">0800-2129</td>
			<td class="xuanzeontd">0800-2120</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5分钟</td>
		</tr>
		<tr id="remark_1_2" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_3" style="display: table-row;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|3|540|6.3|6%7C26698268%7CvaE2wDvHY7A%3D%7C08%3A00%7C22%3A00%7C2200%7C6.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_3">政策4</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.3%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">08:00-22:00</td>
			<td class="xuanzeontd">2200</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_3" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_4" style="display: table-row;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|4|540|6.3|6%7C26681986%7CWSX2OMAbtiA%3D%7C08%3A00%7C21%3A30%7C2130%7C6.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_4">政策5</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.3%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">08:00-21:30</td>
			<td class="xuanzeontd">2130</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">4分种</td>
		</tr>
		<tr id="remark_1_4" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_5" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|5|540|6.3|3%7C15392392%7CSHA331%7C0830%7C2030%7C0830-2030%7C6.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_5">政策6</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.3%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">0830-2030</td>
			<td class="xuanzeontd">0830-2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">0分钟</td>
		</tr>
		<tr id="remark_1_5" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_6" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|6|540|6.3|2%7Cffffffff-fffe-9776-2741-201410161314%7C%7C0830%7C2030%7C2030%7C6.5|%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2030"
				id="radio_1_6">政策7</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.3%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">0830-2030</td>
			<td class="xuanzeontd">2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_6" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:,退票截止时间：2030</td>
		</tr>
		<tr id="tr_zrate_1_7" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|7|540|6.3|13%7C341385593%7C%7C0000%7C2358%7C0800-2120%7C6.5|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_7">政策8</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">30</font>元/<font
				class="font-f60-b16">5.3%</font></td>
			<td class="xuanzeontd font-f60-b20">540</td>
			<td class="xuanzeontd font-f60-b16">660</td>
			<td class="xuanzeontd">0000-2358</td>
			<td class="xuanzeontd">0800-2120</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_7" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_8" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|8|541|6.2|5%7C60061492%7Cnull%7C0000%7C2359%7C2130%7C6.4|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_8">政策9</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.2%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">2130</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_8" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_9" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|9|541|6.2|2%7Cffffffff-fffe-7051-6155-201410161221%7C%7C0910%7C2025%7C2025%7C6.4|+%E4%BE%9B%E5%BA%94%E5%95%86%E5%87%BA%E7%A5%A8%E6%97%B6%E9%97%B4%E4%B8%BA%EF%BC%9A08%3A30-20%3A30%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2025"
				id="radio_1_9">政策10</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.2%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">0910-2025</td>
			<td class="xuanzeontd">2025</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_9" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:
			供应商出票时间为：08:30-20:30,退票截止时间：2025</td>
		</tr>
		<tr id="tr_zrate_1_10" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|10|541|6.2|2%7Cffffffff-fffe-6521-7625-201410171336%7C%7C0910%7C2025%7C2025%7C6.4|+%E4%BE%9B%E5%BA%94%E5%95%86%E5%87%BA%E7%A5%A8%E6%97%B6%E9%97%B4%E4%B8%BA%EF%BC%9A08%3A00-22%3A00%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2025"
				id="radio_1_10">政策11</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.2%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">0910-2025</td>
			<td class="xuanzeontd">2025</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_10" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:
			供应商出票时间为：08:00-22:00,退票截止时间：2025</td>
		</tr>
		<tr id="tr_zrate_1_11" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|11|541|6.1|5%7C60049861%7Cnull%7C0000%7C2359%7C2030%7C6.3|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_11">政策12</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.1%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_11" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_12" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|12|541|6.1|5%7C59997382%7Cnull%7C0800%7C2200%7C2150%7C6.3|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_12">政策13</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.1%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">0800-2200</td>
			<td class="xuanzeontd">2150</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">6分钟</td>
		</tr>
		<tr id="remark_1_12" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_13" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|13|541|6.1|6%7C26522102%7C%2BAeHYGb0Oxg%3D%7C00%3A00%7C23%3A59%7C2359%7C6.3|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_13">政策14</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">29</font>元/<font
				class="font-f60-b16">5.1%</font></td>
			<td class="xuanzeontd font-f60-b20">541</td>
			<td class="xuanzeontd font-f60-b16">661</td>
			<td class="xuanzeontd">00:00-23:59</td>
			<td class="xuanzeontd">2359</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">4分种</td>
		</tr>
		<tr id="remark_1_13" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_14" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|14|542|6.0|3%7C15646802%7Cbjs410%7C0700%7C2200%7C0800-2100%7C6.2|%E8%B7%A8%E6%9C%88%E6%94%B9%E6%9C%9F%E6%88%96%E7%AD%BE%E8%BD%AC%E8%87%B3%E5%85%B6%E4%BB%96%E8%88%AA%E7%A9%BA%E5%85%AC%E5%8F%B8%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9"
				id="radio_1_14">政策15</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">28</font>元/<font
				class="font-f60-b16">5.0%</font></td>
			<td class="xuanzeontd font-f60-b20">542</td>
			<td class="xuanzeontd font-f60-b16">662</td>
			<td class="xuanzeontd">0700-2200</td>
			<td class="xuanzeontd">0800-2100</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">0分钟</td>
		</tr>
		<tr id="remark_1_14" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:跨月改期或签转至其他航空公司，需收回代理费</td>
		</tr>
		<tr id="tr_zrate_1_15" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|15|543|5.9|2%7Cffffffff-fffe-4782-9240-201411021003%7C%7C0910%7C2025%7C2025%7C6.1|+%E4%BE%9B%E5%BA%94%E5%95%86%E5%87%BA%E7%A5%A8%E6%97%B6%E9%97%B4%E4%B8%BA%EF%BC%9A09%3A00-17%3A30%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2025"
				id="radio_1_15">政策16</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.9%</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">0910-2025</td>
			<td class="xuanzeontd">2025</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_15" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:
			供应商出票时间为：09:00-17:30,退票截止时间：2025</td>
		</tr>
		<tr id="tr_zrate_1_16" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|16|543|5.8|5%7C60444984%7Cnull%7C0710%7C2200%7C2130%7C6.0|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_16">政策17</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.8%</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">0710-2200</td>
			<td class="xuanzeontd">2130</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">9分钟</td>
		</tr>
		<tr id="remark_1_16" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_17" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|17|543|5.8|6%7C27266675%7CdimUi2wiZAw%3D%7C07%3A00%7C22%3A00%7C2200%7C6.0|%E7%AD%BE%E8%BD%AC%E3%80%81%E6%8D%A2%E5%BC%80%E3%80%81%E8%B7%A8%E6%9C%88%E6%94%B9%E6%9C%9F%EF%BC%8C%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9"
				id="radio_1_17">政策18</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.8%</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">07:00-22:00</td>
			<td class="xuanzeontd">2200</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_17" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:签转、换开、跨月改期，收回代理费</td>
		</tr>
		<tr id="tr_zrate_1_18" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|18|545|5.4|2%7Cffffffff-fffe-3867-8248-201410212012%7C%7C0910%7C2025%7C2025%7C5.6|+%E4%BE%9B%E5%BA%94%E5%95%86%E5%87%BA%E7%A5%A8%E6%97%B6%E9%97%B4%E4%B8%BA%EF%BC%9A00%3A00-24%3A00%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2025"
				id="radio_1_18">政策19</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">25</font>元/<font
				class="font-f60-b16">4.4%</font></td>
			<td class="xuanzeontd font-f60-b20">545</td>
			<td class="xuanzeontd font-f60-b16">665</td>
			<td class="xuanzeontd">0910-2025</td>
			<td class="xuanzeontd">2025</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_18" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:
			供应商出票时间为：00:00-24:00,退票截止时间：2025</td>
		</tr>
		<tr id="tr_zrate_1_19" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|19|545|5.4|13%7C95110473%7C%7C0800%7C2059%7C0800-2050%7C5.6|%E4%B8%8D%E5%81%9A%E6%94%B9%E7%AD%BE%E6%93%8D%E4%BD%9C"
				id="radio_1_19">政策20</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">25</font>元/<font
				class="font-f60-b16">4.4%</font></td>
			<td class="xuanzeontd font-f60-b20">545</td>
			<td class="xuanzeontd font-f60-b16">665</td>
			<td class="xuanzeontd">0800-2059</td>
			<td class="xuanzeontd">0800-2050</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">13分钟</td>
		</tr>
		<tr id="remark_1_19" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:不做改签操作</td>
		</tr>
		<tr id="tr_zrate_1_20" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|20|545|5.4|13%7C95110474%7C%7C0800%7C2059%7C0800-2050%7C5.6|%E4%B8%8D%E5%81%9A%E6%94%B9%E7%AD%BE%E6%93%8D%E4%BD%9C"
				id="radio_1_20">政策21</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">25</font>元/<font
				class="font-f60-b16">4.4%</font></td>
			<td class="xuanzeontd font-f60-b20">545</td>
			<td class="xuanzeontd font-f60-b16">665</td>
			<td class="xuanzeontd">0800-2059</td>
			<td class="xuanzeontd">0800-2050</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">13分钟</td>
		</tr>
		<tr id="remark_1_20" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:不做改签操作</td>
		</tr>
		<tr id="tr_zrate_1_21" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|21|546|5.3|5%7C60459836%7Cnull%7C0000%7C2359%7C2330%7C5.5|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_21">政策22</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">24</font>元/<font
				class="font-f60-b16">4.3%</font></td>
			<td class="xuanzeontd font-f60-b20">546</td>
			<td class="xuanzeontd font-f60-b16">666</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">4分钟</td>
		</tr>
		<tr id="remark_1_21" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_22" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|22|546|5.3|6%7C27269898%7CK3ecZQBrWLo%3D%7C00%3A00%7C23%3A59%7C2330%7C5.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_22">政策23</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">24</font>元/<font
				class="font-f60-b16">4.3%</font></td>
			<td class="xuanzeontd font-f60-b20">546</td>
			<td class="xuanzeontd font-f60-b16">666</td>
			<td class="xuanzeontd">00:00-23:59</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_22" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_23" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|23|546|5.3|6%7C28575205%7CK3ecZQBrWLo%3D%7C00%3A00%7C23%3A59%7C2330%7C5.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_23">政策24</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">24</font>元/<font
				class="font-f60-b16">4.3%</font></td>
			<td class="xuanzeontd font-f60-b20">546</td>
			<td class="xuanzeontd font-f60-b16">666</td>
			<td class="xuanzeontd">00:00-23:59</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_23" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_24" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|24|548|5.0|2%7Cffffffff-fffe-3894-7351-201410171126%7C%7C0800%7C2130%7C2130%7C5.2|%E6%8D%A2%E5%BC%80%E3%80%81%E5%8D%87%E8%88%B1%E3%80%81%E6%94%B9%E6%9C%9F%EF%BC%8C%E7%AD%BE%E8%BD%AC%EF%BC%8C+%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%9B%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2130"
				id="radio_1_24">政策25</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">22</font>元/<font
				class="font-f60-b16">4.0%</font></td>
			<td class="xuanzeontd font-f60-b20">548</td>
			<td class="xuanzeontd font-f60-b16">668</td>
			<td class="xuanzeontd">0800-2130</td>
			<td class="xuanzeontd">2130</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_24" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:换开、升舱、改期，签转，
			收回代理费；,退票截止时间：2130</td>
		</tr>
		<tr id="tr_zrate_1_25" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|25|547|4.9|2%7Cffffffff-fffe-7840-3567-201410171117%7C%7C0910%7C2025%7C2025%7C5.1|%E6%8D%A2%E5%BC%80%2F%E7%AD%BE%E8%BD%AC%E5%88%AB%E7%9A%84%E8%88%AA%E7%A9%BA%E5%85%AC%E5%8F%B8%E3%80%81%E8%B7%A8%E6%9C%88%E7%AD%BE%E8%BD%AC%E4%BB%A5%E5%8F%8A%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%E6%94%B9%E5%88%B0%E6%97%A0%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%8C%E5%85%B1%E4%BA%AB%E8%88%AA%E7%8F%AD%E4%B8%8D%E4%BA%AB%E5%8F%97%E6%AD%A4%E6%94%BF%E7%AD%96%E3%80%81%E4%BD%8E%E7%A5%A8%E9%9D%A2%E4%B8%8D%E4%BA%AB%E5%8F%97%E6%AD%A4%E6%94%BF%E7%AD%96%E3%80%81%E9%87%87%E8%B4%AD%E7%A7%81%E8%87%AA%E6%B7%BB%E5%8A%A0%E5%8D%8F%E8%AE%AE%E5%8F%B7%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9+%E4%BE%9B%E5%BA%94%E5%95%86%E5%87%BA%E7%A5%A8%E6%97%B6%E9%97%B4%E4%B8%BA%EF%BC%9A08%3A00-24%3A00%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2025"
				id="radio_1_25">政策26</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">23</font>元/<font
				class="font-f60-b16">4.2%</font></td>
			<td class="xuanzeontd font-f60-b20">547</td>
			<td class="xuanzeontd font-f60-b16">667</td>
			<td class="xuanzeontd">0910-2025</td>
			<td class="xuanzeontd">2025</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_25" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:换开/签转别的航空公司、跨月签转以及政策航班改到无政策航班，需收回代理费，共享航班不享受此政策、低票面不享受此政策、采购私自添加协议号，需收回代理费
			供应商出票时间为：08:00-24:00,退票截止时间：2025</td>
		</tr>
		<tr id="tr_zrate_1_26" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|26|547|4.8|3%7C15454026%7Cbjs326%7C0800%7C2359%7C0800-2330%7C5.0|%E6%8D%A2%E5%BC%80%2F%E7%AD%BE%E8%BD%AC%E5%88%AB%E7%9A%84%E8%88%AA%E7%A9%BA%E5%85%AC%E5%8F%B8%E3%80%81%E8%B7%A8%E6%9C%88%E7%AD%BE%E8%BD%AC%E4%BB%A5%E5%8F%8A%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%E6%94%B9%E5%88%B0%E6%97%A0%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%8C%E5%85%B1%E4%BA%AB%E8%88%AA%E7%8F%AD%E4%B8%8D%E4%BA%AB%E5%8F%97%E6%AD%A4%E6%94%BF%E7%AD%96%E3%80%81%E4%BD%8E%E7%A5%A8%E9%9D%A2%E4%B8%8D%E4%BA%AB%E5%8F%97%E6%AD%A4%E6%94%BF%E7%AD%96%E3%80%81%E9%87%87%E8%B4%AD%E7%A7%81%E8%87%AA%E6%B7%BB%E5%8A%A0%E5%8D%8F%E8%AE%AE%E5%8F%B7%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9"
				id="radio_1_26">政策27</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">23</font>元/<font
				class="font-f60-b16">4.1%</font></td>
			<td class="xuanzeontd font-f60-b20">547</td>
			<td class="xuanzeontd font-f60-b16">667</td>
			<td class="xuanzeontd">0800-2359</td>
			<td class="xuanzeontd">0800-2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">9分钟</td>
		</tr>
		<tr id="remark_1_26" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:换开/签转别的航空公司、跨月签转以及政策航班改到无政策航班，需收回代理费，共享航班不享受此政策、低票面不享受此政策、采购私自添加协议号，需收回代理费</td>
		</tr>
		<tr id="tr_zrate_1_27" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|27|548|4.6|2%7Cffffffff-fffe-5295-9377-201410211434%7C%7C0000%7C2300%7C2300%7C4.8|%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2300"
				id="radio_1_27">政策28</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">22</font>元/<font
				class="font-f60-b16">3.9%</font></td>
			<td class="xuanzeontd font-f60-b20">548</td>
			<td class="xuanzeontd font-f60-b16">668</td>
			<td class="xuanzeontd">0000-2300</td>
			<td class="xuanzeontd">2300</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_27" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:,退票截止时间：2300</td>
		</tr>
		<tr id="tr_zrate_1_28" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|28|549|4.4|5%7C60565390%7Cnull%7C0000%7C2300%7C2245%7C4.6|%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_28">政策29</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">21</font>元/<font
				class="font-f60-b16">3.7%</font></td>
			<td class="xuanzeontd font-f60-b20">549</td>
			<td class="xuanzeontd font-f60-b16">669</td>
			<td class="xuanzeontd">0000-2300</td>
			<td class="xuanzeontd">2245</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">15分钟</td>
		</tr>
		<tr id="remark_1_28" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_29" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|29|549|4.4|6%7C27265299%7CtUjG3DrSuFg%3D%7C00%3A00%7C23%3A00%7C2300%7C4.6|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_29">政策30</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">21</font>元/<font
				class="font-f60-b16">3.7%</font></td>
			<td class="xuanzeontd font-f60-b20">549</td>
			<td class="xuanzeontd font-f60-b16">669</td>
			<td class="xuanzeontd">00:00-23:00</td>
			<td class="xuanzeontd">2300</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_29" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_30" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|30|549|4.4|3%7C15643605%7CPEK438%7C0000%7C2345%7C0000-2330%7C4.6|%E6%8D%A2%E5%BC%80%2F%E5%8D%87%E8%88%B1%2F%E6%94%B9%E7%AD%BE%2F%E8%B7%A8%E6%9C%88%E6%94%B9%E6%9C%9F%2F%E6%94%B9%E6%9C%9F%E8%87%B3%E6%97%A0%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%EF%BC%8C%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%9B"
				id="radio_1_30">政策31</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">21</font>元/<font
				class="font-f60-b16">3.7%</font></td>
			<td class="xuanzeontd font-f60-b20">549</td>
			<td class="xuanzeontd font-f60-b16">669</td>
			<td class="xuanzeontd">0000-2345</td>
			<td class="xuanzeontd">0000-2330</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">8分钟</td>
		</tr>
		<tr id="remark_1_30" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:换开/升舱/改签/跨月改期/改期至无政策航班，收回代理费；</td>
		</tr>
		<tr id="tr_zrate_1_31" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|31|550|4.3|3%7C16864901%7CSZX485%7C0000%7C2359%7C0001-2330%7C4.5|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_31">政策32</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">20</font>元/<font
				class="font-f60-b16">3.6%</font></td>
			<td class="xuanzeontd font-f60-b20">550</td>
			<td class="xuanzeontd font-f60-b16">670</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">0001-2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">4分钟</td>
		</tr>
		<tr id="remark_1_31" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_32" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|32|550|4.3|2%7Cffffffff-fffe-1538-5169-201410200931%7C%7C0000%7C2355%7C2355%7C4.5|%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2355"
				id="radio_1_32">政策33</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">20</font>元/<font
				class="font-f60-b16">3.6%</font></td>
			<td class="xuanzeontd font-f60-b20">550</td>
			<td class="xuanzeontd font-f60-b16">670</td>
			<td class="xuanzeontd">0000-2355</td>
			<td class="xuanzeontd">2355</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_32" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:,退票截止时间：2355</td>
		</tr>
		<tr id="tr_zrate_1_33" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|33|551|4.1|5%7C60199422%7Cnull%7C0000%7C2359%7C2330%7C4.3|B2B%E7%94%B5%E5%AD%90%E5%AE%A2%E7%A5%A8%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%81%9ARR%EF%BC%8C%E5%90%A6%E5%88%99%E5%8F%AF%E8%83%BD%E6%97%A0%E6%B3%95%E5%87%BA%E7%A5%A8%E3%80%82++%E6%94%B9%E6%9C%9F%E3%80%81%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%A6%82%E4%BA%A7%E7%94%9F%E4%BB%A3%E7%90%86%E8%B4%B9%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%9C%80%E6%94%B6%E5%9B%9E%EF%BC%81"
				id="radio_1_33">政策34</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">19</font>元/<font
				class="font-f60-b16">3.4%</font></td>
			<td class="xuanzeontd font-f60-b20">551</td>
			<td class="xuanzeontd font-f60-b16">671</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_33" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:B2B电子客票请不要做RR，否则可能无法出票。
			改期、签转，如产生代理费差异，需收回！</td>
		</tr>
		<tr id="tr_zrate_1_34" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|34|551|4.1|6%7C27054306%7CwTADPRLIUDg%3D%7C00%3A00%7C23%3A59%7C2359%7C4.3|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_34">政策35</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">19</font>元/<font
				class="font-f60-b16">3.4%</font></td>
			<td class="xuanzeontd font-f60-b20">551</td>
			<td class="xuanzeontd font-f60-b16">671</td>
			<td class="xuanzeontd">00:00-23:59</td>
			<td class="xuanzeontd">2359</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">2分种</td>
		</tr>
		<tr id="remark_1_34" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_35" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|35|551|4.1|3%7C15549129%7CBJS914%7C0000%7C2359%7C0000-2359%7C4.3|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_35">政策36</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">19</font>元/<font
				class="font-f60-b16">3.4%</font></td>
			<td class="xuanzeontd font-f60-b20">551</td>
			<td class="xuanzeontd font-f60-b16">671</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">1分钟</td>
		</tr>
		<tr id="remark_1_35" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_36" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|36|553|3.8|3%7C14154293%7CSHA202%7C0800%7C2030%7C0800-2030%7C4.0|%E6%9A%82%E6%97%A0%E5%A4%87%E6%B3%A8"
				id="radio_1_36">政策37</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">17</font>元/<font
				class="font-f60-b16">3.1%</font></td>
			<td class="xuanzeontd font-f60-b20">553</td>
			<td class="xuanzeontd font-f60-b16">673</td>
			<td class="xuanzeontd">0800-2030</td>
			<td class="xuanzeontd">0800-2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">4分钟</td>
		</tr>
		<tr id="remark_1_36" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:暂无备注</td>
		</tr>
		<tr id="tr_zrate_1_37" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|37|553|3.8|3%7C13389478%7CSHA365%7C0000%7C2359%7C0000-2330%7C4.0|%E6%AD%A4%E6%94%BF%E7%AD%96%E5%8F%AA%E9%80%82%E7%94%A8%E4%BA%8E%E9%AB%98%E4%BB%B7%EF%BC%8C%E4%BD%8E%E4%BB%B7%E4%B8%8D%E4%BA%AB%E5%8F%97%EF%BC%8C%E5%90%A6%E5%88%99%E6%8B%92%E5%8D%95%EF%BC%8C%E6%94%B9%E6%9C%9F%E3%80%81%E5%8D%87%E8%88%B1%E3%80%81%E6%8D%A2%E5%BC%80%E3%80%81%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA%E4%BB%A5%E5%8F%8A%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%E6%94%B9%E5%88%B0%E6%97%A0%E6%94%BF%E7%AD%96%E8%88%AA%E7%8F%AD%2C%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9"
				id="radio_1_37">政策38</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">17</font>元/<font
				class="font-f60-b16">3.1%</font></td>
			<td class="xuanzeontd font-f60-b20">553</td>
			<td class="xuanzeontd font-f60-b16">673</td>
			<td class="xuanzeontd">0000-2359</td>
			<td class="xuanzeontd">0000-2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5分钟</td>
		</tr>
		<tr id="remark_1_37" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:此政策只适用于高价，低价不享受，否则拒单，改期、升舱、换开、签转外航以及政策航班改到无政策航班,需收回代理费</td>
		</tr>
		<tr id="tr_zrate_1_38" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|38|553|3.8|2%7Cffffffff-fffe-7470-0431-201409101023%7C%7C0000%7C2330%7C2330%7C4.0|%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A2330"
				id="radio_1_38">政策39</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">17</font>元/<font
				class="font-f60-b16">3.1%</font></td>
			<td class="xuanzeontd font-f60-b20">553</td>
			<td class="xuanzeontd font-f60-b16">673</td>
			<td class="xuanzeontd">0000-2330</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">5-10分钟</td>
		</tr>
		<tr id="remark_1_38" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:,退票截止时间：2330</td>
		</tr>
		<tr id="tr_zrate_1_39" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="1|39|564|1.3|5%7C1%7Cnull%7C18%3A00%7C23%3A59%7C00%3A01%7C1.5|%E5%8F%AF%E8%83%BD%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%EF%BC%8C%E5%87%BA%E7%A5%A8%E9%80%9F%E5%BA%A6%E7%A8%8D%E6%85%A2%EF%BC%8C%E8%AF%B7%E8%80%90%E5%BF%83%E7%AD%89%E5%BE%85%E3%80%82"
				id="radio_1_39">政策40</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">6</font>元/<font
				class="font-f60-b16">1.1%</font></td>
			<td class="xuanzeontd font-f60-b20">564</td>
			<td class="xuanzeontd font-f60-b16">684</td>
			<td class="xuanzeontd">18:00-23:59</td>
			<td class="xuanzeontd">00:01</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">10分钟</td>
		</tr>
		<tr id="remark_1_39" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon">政策说明:可能换编码出票，出票速度稍慢，请耐心等待。</td>
		</tr>
		<tr id="tr_zrate_2_0" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|0|530|8.6|6%7C29864362%7CxTmkBOAmEZQ%3D%7C08%3A30%7C23%3A30%7C2330%7C8.8|%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%EF%BC%8C%E5%8F%AF%E8%83%BD%E6%8D%A2%E8%88%B1%E4%BD%8D%E5%87%BA%E7%A5%A8%EF%BC%8C%E4%B8%8D%E6%8F%90%E4%BE%9B%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E6%94%B9%E6%9C%9F%EF%BC%8C%E4%B8%8D%E8%83%BD%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA%EF%BC%8C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%EF%BC%8C%E7%99%BE%E5%88%86%E4%B9%8B%E7%99%BE%E4%BF%9D%E8%AF%81%E8%A1%8C%E7%A8%8B%E3%80%82"
				id="radio_2_0">政策1</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">40</font>元/<font
				class="font-f60-b16">7.1%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">530</td>
			<td class="xuanzeontd font-f60-b16">650</td>
			<td class="xuanzeontd">0830-2330</td>
			<td class="xuanzeontd">2330</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">12分种</td>
		</tr>
		<tr id="remark_2_0" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:换编码出票，可能换舱位出票，不提供行程单，不能废票，不能退票，不能改期，不能签转外航，差价不退还。可能二次更新票号，百分之百保证行程。</td>
		</tr>
		<tr id="tr_zrate_2_1" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|1|532|8.3|6%7C29302201%7CuCNtOdn2XKU%3D%7C08%3A30%7C22%3A30%7C2230%7C8.5|%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%EF%BC%8C%E5%A4%96%E6%94%BE%E9%A1%BB%E6%9C%89%E5%90%8C%E7%AD%89%E4%BB%93%E4%BD%8D%2C%E5%8F%AF%E8%83%BD%E6%8D%A2%E4%BB%93%E4%BD%8D%EF%BC%8C%E7%A5%A8%E9%9D%A2%E4%BD%8E%E5%BC%80%EF%BC%8C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E5%BA%9F%E7%A5%A8%EF%BC%8C%E6%94%B9%E6%9C%9F%E6%94%B6%E5%8F%9650%25%E5%B9%B6%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%8C%E4%B8%8D%E5%87%BA%E5%A9%B4%E5%84%BF%EF%BC%8C%E5%84%BF%E7%AB%A5%E7%A5%A8%EF%BC%8C%E4%B8%8D%E6%8F%90%E4%BE%9B%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%EF%BC%8C%E6%AC%A2%E8%BF%8E%E9%87%87%E8%B4%AD%2C%E7%99%BE%E5%88%86%E4%B9%8B%E7%99%BE%E4%BF%9D%E8%AF%81%E8%A1%8C%E7%A8%8B"
				id="radio_2_1">政策2</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">38</font>元/<font
				class="font-f60-b16">6.8%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">532</td>
			<td class="xuanzeontd font-f60-b16">652</td>
			<td class="xuanzeontd">0830-2230</td>
			<td class="xuanzeontd">2230</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">9分种</td>
		</tr>
		<tr id="remark_2_1" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:换编码出票，外放须有同等仓位,可能换仓位，票面低开，差价不退，不能退废票，改期收取50%并收回代理费，不出婴儿，儿童票，不提供行程单，可能二次更新票号，欢迎采购,百分之百保证行程</td>
		</tr>
		<tr id="tr_zrate_2_2" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|2|532|8.2|6%7C27980032%7CIhWzZZt4Gek%3D%7C08%3A00%7C22%3A00%7C2200%7C8.4|%E9%9C%80%E8%A6%81%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E5%8F%AF%E8%83%BD%E6%8D%A2%E8%88%B1%E5%87%BA%E7%A5%A8%EF%BC%8C%E4%B8%8D%E5%8F%AF%E4%BB%A5%E5%8D%87%E8%88%B1%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E5%BE%97%E9%80%80%E7%A5%A8%EF%BC%8C%E4%B8%8D%E5%BE%97%E6%94%B9%E6%9C%9F%EF%BC%8C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%EF%BC%8C%E4%B8%8D%E8%83%BD%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA.%E3%80%82"
				id="radio_2_2">政策3</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">38</font>元/<font
				class="font-f60-b16">6.7%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">532</td>
			<td class="xuanzeontd font-f60-b16">652</td>
			<td class="xuanzeontd">0800-2200</td>
			<td class="xuanzeontd">2200</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">7分种</td>
		</tr>
		<tr id="remark_2_2" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:需要换编码，可能换舱出票，不可以升舱，不能废票，不得退票，不得改期，差价不退，不能签转外航.。</td>
		</tr>
		<tr id="tr_zrate_2_3" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|3|534|7.4|6%7C25914006%7Cga3L6fX8dnU%3D%7C09%3A00%7C22%3A30%7C2230%7C7.6|%E7%8B%AC%E9%A3%9E%E7%BA%BF%E4%B8%8D%E5%87%BA%EF%BC%8C%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%E3%80%82%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E7%A5%A8+%E4%B8%8D%E8%83%BD%E6%94%B9%E7%AD%BE++%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98+++%E9%9C%80%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%E3%80%82%E6%AC%A2%E8%BF%8E%E9%87%87%E8%B4%AD%EF%BC%81"
				id="radio_2_3">政策4</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">36</font>元/<font
				class="font-f60-b16">6.4%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">534</td>
			<td class="xuanzeontd font-f60-b16">654</td>
			<td class="xuanzeontd">0900-2230</td>
			<td class="xuanzeontd">2230</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">6分种</td>
		</tr>
		<tr id="remark_2_3" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:独飞线不出，换编码出票。不能废票，不能退票
			不能改签 差价不退还 需二次更新票号。欢迎采购！</td>
		</tr>
		<tr id="tr_zrate_2_4" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|4|535|7.3|6%7C26462195%7CYIxsCsSHU9g%3D%7C08%3A30%7C20%3A30%7C2030%7C7.5|%E9%9C%80%E8%A6%81%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E6%8D%A2%E8%88%B1%E4%BD%8D%E5%BC%80%E7%A5%A8%EF%BC%8C%E8%83%BD%E6%89%93%E5%8D%B0%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E5%8F%AF%E4%BB%A5%E5%8D%87%E8%88%B1%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E9%80%80%E7%A5%A8%E5%AE%A2%E8%88%AA%E7%8F%AD%E8%B5%B7%E9%A3%9E%E5%89%8D24%E5%B0%8F%E6%97%B6%E6%94%B6%E5%8F%9660%25%EF%BC%8C%E8%88%AA%E7%8F%AD%E8%B5%B7%E9%A3%9E%E5%90%8E%E6%94%B6%E5%8F%9670%25%EF%BC%8C%E6%94%B9%E6%9C%9F%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%E6%8C%89%E5%AE%A2%E8%A7%84%E5%8A%A0%E6%94%B620%25%EF%BC%8C%E4%B8%8D%E8%83%BD%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA%2C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%E3%80%82"
				id="radio_2_4">政策5</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">35</font>元/<font
				class="font-f60-b16">6.3%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">535</td>
			<td class="xuanzeontd font-f60-b16">655</td>
			<td class="xuanzeontd">0830-2030</td>
			<td class="xuanzeontd">2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">8分种</td>
		</tr>
		<tr id="remark_2_4" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:需要换编码，换舱位开票，能打印行程单，可以升舱，不能废票，退票客航班起飞前24小时收取60%，航班起飞后收取70%，改期收回代理费按客规加收20%，不能签转外航,差价不退还。可能二次更新票号。</td>
		</tr>
		<tr id="tr_zrate_2_5" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|5|536|7.1|6%7C27992477%7CYIxsCsSHU9g%3D%7C08%3A30%7C20%3A30%7C2030%7C7.3|%E9%9C%80%E8%A6%81%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E6%8D%A2%E8%88%B1%E4%BD%8D%E5%BC%80%E7%A5%A8%EF%BC%8C%E8%83%BD%E6%89%93%E5%8D%B0%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E5%8F%AF%E4%BB%A5%E5%8D%87%E8%88%B1%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E9%80%80%E7%A5%A8%E5%AE%A2%E8%88%AA%E7%8F%AD%E8%B5%B7%E9%A3%9E%E5%89%8D24%E5%B0%8F%E6%97%B6%E6%94%B6%E5%8F%9660%25%EF%BC%8C%E8%88%AA%E7%8F%AD%E8%B5%B7%E9%A3%9E%E5%90%8E%E6%94%B6%E5%8F%9670%25%EF%BC%8C%E6%94%B9%E6%9C%9F%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%E6%8C%89%E5%AE%A2%E8%A7%84%E5%8A%A0%E6%94%B620%25%EF%BC%8C%E4%B8%8D%E8%83%BD%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA%2C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%E3%80%82"
				id="radio_2_5">政策6</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">34</font>元/<font
				class="font-f60-b16">6.1%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">536</td>
			<td class="xuanzeontd font-f60-b16">656</td>
			<td class="xuanzeontd">0830-2030</td>
			<td class="xuanzeontd">2030</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">8分种</td>
		</tr>
		<tr id="remark_2_5" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:需要换编码，换舱位开票，能打印行程单，可以升舱，不能废票，退票客航班起飞前24小时收取60%，航班起飞后收取70%，改期收回代理费按客规加收20%，不能签转外航,差价不退还。可能二次更新票号。</td>
		</tr>
		<tr id="tr_zrate_2_6" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|6|543|5.9|6%7C28663726%7Cga3L6fX8dnU%3D%7C09%3A00%7C22%3A30%7C2230%7C6.1|%E7%8B%AC%E9%A3%9E%E7%BA%BF%E4%B8%8D%E5%87%BA%EF%BC%8C%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%E3%80%82%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E7%A5%A8+%E4%B8%8D%E8%83%BD%E6%94%B9%E7%AD%BE++%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98+++%E9%9C%80%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%E3%80%82%E6%AC%A2%E8%BF%8E%E9%87%87%E8%B4%AD%EF%BC%81"
				id="radio_2_6">政策7</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.9%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">0900-2230</td>
			<td class="xuanzeontd">2230</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">6分种</td>
		</tr>
		<tr id="remark_2_6" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:独飞线不出，换编码出票。不能废票，不能退票
			不能改签 差价不退还 需二次更新票号。欢迎采购！</td>
		</tr>
		<tr id="tr_zrate_2_7" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|7|543|5.8|6%7C26335679%7CSKlpe%2BFQnJg%3D%7C09%3A30%7C23%3A59%7C2359%7C6.0|%E9%9C%80%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E9%99%90%E5%88%B6%E6%9C%BA%E5%9E%8B%E6%97%A0%EF%BC%8C%E5%BF%85%E9%A1%BB%E6%8F%90%E5%89%8D7%E5%A4%A9%E7%9A%84%E8%88%AA%E7%8F%AD%E5%84%BF%E7%AB%A5%EF%BC%8C%E5%A9%B4%E5%84%BF%E4%B8%8D%E5%87%BA%E4%B8%8D%E5%87%BA%EF%BC%8C%E8%A1%8C%E7%A8%8B%E5%8D%95%E4%BB%B7%E6%A0%BC%E4%BD%8E%E4%BA%8E%E5%8E%9F%E7%A5%A8%E9%9D%A210%25%EF%BC%8C%E5%8F%AF%E4%BB%A5%E5%8D%87%E8%88%B1%EF%BC%8C%E5%8D%87%E8%88%B1%E9%9C%80%E6%94%B6%E5%9B%9E%E4%BB%A3%E7%90%86%E8%B4%B9%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E9%80%80%E6%94%B9%E6%9C%9F%E4%BB%A5%E8%88%AA%E5%8F%B8%E8%A7%84%E5%AE%9A%E4%B8%BA%E5%87%86%E3%80%82%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82"
				id="radio_2_7">政策8</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.8%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">0930-2359</td>
			<td class="xuanzeontd">2359</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">18分种</td>
		</tr>
		<tr id="remark_2_7" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:需换编码，限制机型无，必须提前7天的航班儿童，婴儿不出不出，行程单价格低于原票面10%，可以升舱，升舱需收回代理费，不能废票，退改期以航司规定为准。差价不退还。</td>
		</tr>
		<tr id="tr_zrate_2_8" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|8|543|5.8|6%7C22855270%7CH6QQxC6w7Do%3D%7C07%3A30%7C22%3A00%7C2200%7C6.0|%E9%9C%80%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E9%9C%80%E8%A6%81%E6%8D%A2%E5%85%B6%E4%BB%96%E8%88%B1%28%E7%A5%A8%E9%9D%A2%E4%B8%8D%E8%83%BD%E8%B6%85%E8%BF%87600%EF%BC%8C%E8%B6%85%E8%BF%87%E5%B0%86%E4%BC%98%E6%83%A0%E4%B8%8D%E8%B6%B3%EF%BC%8C%E4%BC%9A%E6%8B%92%E5%8D%95%29%EF%BC%8C%E4%B8%8D%E8%83%BD%E6%89%93%E5%8D%B0%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E4%B8%8D%E5%8F%AF%E4%BB%A5%E5%8D%87%E8%88%B1%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E6%94%B9%E6%9C%9F%EF%BC%8C%E4%B8%8D%E8%83%BD%E7%AD%BE%E8%BD%AC%E5%A4%96%E8%88%AA%E3%80%82%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%EF%BC%8C%E7%99%BE%E5%88%86%E7%99%BE%E4%BF%9D%E8%AF%81%E8%A1%8C%E7%A8%8B"
				id="radio_2_8">政策9</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">27</font>元/<font
				class="font-f60-b16">4.8%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">543</td>
			<td class="xuanzeontd font-f60-b16">663</td>
			<td class="xuanzeontd">0730-2200</td>
			<td class="xuanzeontd">2200</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">7分种</td>
		</tr>
		<tr id="remark_2_8" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:需换编码，需要换其他舱(票面不能超过600，超过将优惠不足，会拒单)，不能打印行程单，不可以升舱，不能废票，不能退票，不能改期，不能签转外航。差价不退还。可能二次更新票号，百分百保证行程</td>
		</tr>
		<tr id="tr_zrate_2_9" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|9|545|5.4|6%7C23724885%7CqVogbS1l8q0%3D%7C08%3A00%7C22%3A00%7C2200%7C5.6|%E6%8D%A2%E7%BC%96%E7%A0%81%E5%87%BA%E7%A5%A8%EF%BC%8C%E5%8F%AF%E8%83%BD%E6%8D%A2%E8%88%B1%E4%BD%8D%E5%87%BA%E7%A5%A8%EF%BC%8C%E4%B8%8D%E6%8F%90%E4%BE%9B%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E4%B8%8D%E8%83%BD%E5%BA%9F%E7%A5%A8%EF%BC%8C%E4%B8%8D%E8%83%BD%E9%80%80%E7%A5%A8%EF%BC%8C%E4%B8%8D%E5%BE%97%E7%AD%BE%E8%BD%AC%E6%94%B9%E6%9C%9F%E9%80%80%E7%A5%A8%EF%BC%8C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E8%BF%98%E3%80%82%E7%99%BE%E5%88%86%E4%B9%8B%E7%99%BE%E4%BF%9D%E8%AF%81%E8%A1%8C%E7%A8%8B%EF%BC%8C%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%E3%80%82"
				id="radio_2_9">政策10</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">25</font>元/<font
				class="font-f60-b16">4.4%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">545</td>
			<td class="xuanzeontd font-f60-b16">665</td>
			<td class="xuanzeontd">0800-2200</td>
			<td class="xuanzeontd">2200</td>
			<td class="xuanzeontd">BSP</td>
			<td class="xuanzeontd">12分种</td>
		</tr>
		<tr id="remark_2_9" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:换编码出票，可能换舱位出票，不提供行程单，不能废票，不能退票，不得签转改期退票，差价不退还。百分之百保证行程，可能二次更新票号。</td>
		</tr>
		<tr id="tr_zrate_2_10" class="none_" style="display: none;">
			<td class="xuanzeontd"><input name="radio_zrate" type="radio"
				value="2|10|547|4.8|6%7C29551251%7CpWqtzX5h77E%3D%7C07%3A30%7C23%3A00%7C2330%7C5.0|%E6%8D%A2%E7%BC%96%E7%A0%81%EF%BC%8C%E7%A5%A8%E9%9D%A2%E4%BD%8E%EF%BC%8C%E6%97%A0%E6%B3%95%E4%BD%9C%E5%BA%9F%EF%BC%8C%E4%B8%8D%E6%8F%90%E4%BE%9B%E8%A1%8C%E7%A8%8B%E5%8D%95%EF%BC%8C%E5%8F%AF%E8%83%BD%E6%8D%A2%E8%88%B1%E4%BD%8D%E5%87%BA%E7%A5%A8%EF%BC%8C%E4%B8%8D%E9%80%80%E7%A5%A8%E4%B8%8D%E6%94%B9%E6%9C%9F%E4%B8%8D%E7%AD%BE%E8%BD%AC%EF%BC%8C%E5%B7%AE%E4%BB%B7%E4%B8%8D%E9%80%80%E3%80%82%EF%BC%88%E9%83%A8%E5%88%86%E8%88%AA%E7%8F%AD%E5%8F%B7%E5%8F%AF%E8%83%BD%E4%B8%8D%E6%94%AF%E6%8C%81%E6%AD%A4%E6%94%BF%E7%AD%96%EF%BC%8C%E5%8F%AF%E8%83%BD%E4%BA%8C%E6%AC%A1%E6%9B%B4%E6%96%B0%E7%A5%A8%E5%8F%B7%EF%BC%8C%E7%99%BE%E5%88%86%E4%B9%8B%E7%99%BE%E4%BF%9D%E8%AF%81%E8%A1%8C%E7%A8%8B%E3%80%82%EF%BC%89"
				id="radio_2_10">政策11</td>
			<td class="xuanzeontd font-69f-b20">570.0</td>
			<td class="xuanzeontd"><font class="font-f60-b16">23</font>元/<font
				class="font-f60-b16">4.1%(特殊)</font></td>
			<td class="xuanzeontd font-f60-b20">547</td>
			<td class="xuanzeontd font-f60-b16">667</td>
			<td class="xuanzeontd">0730-2300</td>
			<td class="xuanzeontd">2300</td>
			<td class="xuanzeontd">B2B</td>
			<td class="xuanzeontd">12分种</td>
		</tr>
		<tr id="remark_2_10" class="none_" style="display: none;">
			<td align="left" colspan="9" class="pf40 xuanzeon ">政策说明:换编码，票面低，无法作废，不提供行程单，可能换舱位出票，不退票不改期不签转，差价不退。（部分航班号可能不支持此政策，可能二次更新票号，百分之百保证行程。）</td>
		</tr>
		<tr>
			<td id="showzrate" colspan="3"><a href="javascript:void(0);showAllZrate();">显示其他政策</a></td>
		</tr>
	</tbody>
</table>

</div>

</div>
<!--政策信息结束-->
<div class="jiagezong mt10">
<ul>
	<li>交易费：<font class="font-f60-b16 ml5" id="orderPlat_price">0.0元/人</font>
	</li>
	<li>计算方式：<font class="font-f60-b16" id="calc_method">1×1181+1×0.0+0×7.0</font>元&nbsp;&nbsp;(人数×总结算价+人数×交易费=总支付金额)
	</li>
	<li style="padding-left: 380px; line-height: 80px;">共1名乘机人<font
		class="font-000-18 ml30">订单总额：</font><font class=" font-f60-b30"
		id="order_total_price">¥1181</font><input type="button"
		class="bnt_tijiaoda ml30 none_"
		style="margin-top: -15px; display: inline-block;" id="submit_order"></li>
</ul>
</div>
<form
	action="#"
	method="POST" name="createorder_2014" id="createorder_2014"><input
	type="hidden" name="s_traveltype" id="s_traveltype" value="2">
<input type="hidden" name="radio_zrate" id="radio_zrate"
	value="1|3|941|2.2|2%7Cffffffff-fffe-3593-8389-201411050957%7C%7C0800%7C1900%7C1900%7C2.4|%2C%E9%80%80%E7%A5%A8%E6%88%AA%E6%AD%A2%E6%97%B6%E9%97%B4%EF%BC%9A1900">
<input type="hidden" name="s_traveltype" id="s_traveltype" value="2">
<input type="hidden" name="s_startdate" id="s_startdate"
	value="2014-11-13"></form>
<div class="xuzhi mt10">
<ul>
	<li class=" font-f70">订座说明：<input name="" type="checkbox" value=""
		checked="checked" disabled="true">同意说明</li>
	<li class="pf20">1.航班起飞前30分钟未支付的记录,与生成PNR未生成订单的记录,系统有权自动取消;</li>
	<li class="pf20">2.通过我平台订座但未出票的订单，我平台有权取消该座位并且不承担任何责任;</li>
	<li class="pf20">3.对于恶意占座的代理商，我平台将关闭其账户，由此导致的损失与罚款，由该用户自己承担;</li>
	<li class="pf20">4.由于航空公司出现了一舱多价的问题，所以查询价格仅供参考，请用户以实际预订的PAT价格为准。</li>
	<li class="pf20">5.如预订儿童票,请务必正确填写成人pnr,如果填写错误导致的一切后果由订票人承担</li>
</ul>
</div>
</div>
<!--右侧内容结束-->
<div class="c"></div>
</div>
<script type="text/javascript" src="b2bairticket/js/ticket/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="jquery.blockUI.js"></script>
<script type="text/javascript" src="PublicJs.js"></script>
<script type="text/javascript" src="createorder_2014.js"></script>
<script type="text/javascript">
		var page_ = "airtocreateorder_page";
		airtocreateorder.passengerCount = 1;
		var orderPlat = "0.0";
		var orderPlattype = "1";
		//一份保险的价格
		var insuranceprice = "7.0";
		//保险总份数
		var insurCount = "0";
		var s_oldorderprice = "570.0";
		var neworderprice = "960.0";
		var airportfee = 100;
		var fuelfee = 140;
		
var zratetype=1;		
		
 function zreateTypeTab(type) {
	if (type == 1) {
		zratetype = 1;
		//$("tr[id*='tr_zrate_1']").show();
		//$("tr[id*='remark_1']").hide();
		//$("tr[id*='tr_zrate_2']").hide();
		//$("tr[id*='remark_2']").hide();
		
		//airtocreateorder.hideZrate();
		
		$("#putong_div").show();
		$("#teshu_div").hide();
		// $('.xuanze_top').css('background',
		// 'url(css/login/images/bj_zhengce.png)').css('color', '#fff')
		// .css('border', '0px');
	} else {
		zratetype = 2;
		//$("tr[id*='tr_zrate_1']").hide();
		//$("tr[id*='remark_1']").hide();
		//$("tr[id*='tr_zrate_2']").show();
		//$("tr[id*='remark_2']").hide();
		$("#putong_div").hide();
		$("#teshu_div").show();
		// $('.teshu').css('background', 'url()').css('color', '#ff6600').css(
		// 'border', '2px solid #bbdfff');

	}
}

function hideZrate() {
	if($('tr[id*="tr_zrate_1"]').last().css('display')=="none"){
		if(zratetype==1){
			$('tr[id*="tr_zrate_1"]').slice(5,$('tr[id*="tr_zrate_1"]').size()).show();
		}else{
			$('tr[id*="tr_zrate_2"]').slice(5,$('tr[id*="tr_zrate_2"]').size()).show();
		}
	}else{
		if(zratetype==1){
			$('tr[id*="tr_zrate_1"]').slice(5,$('tr[id*="tr_zrate_1"]').size()).hide();
		}else{
			$('tr[id*="tr_zrate_2"]').slice(5,$('tr[id*="tr_zrate_2"]').size()).hide();
		}
	}
}

function hideAllZrate(){
$('tr[id*="tr_zrate_1"]').slice(5,$('tr[id*="tr_zrate_1"]').size()).hide();
$("#showzrate").html('<a href="javascript:void(0);showAllZrate();">显示其他政策</a>');
}		
function showAllZrate(){
//$("#putong_div").hide();
$('tr[id*="tr_zrate_1"]').slice(5,$('tr[id*="tr_zrate_1"]').size()).show();
//
$("#showzrate").html('<a href="javascript:void(0);hideAllZrate();">隐藏其他政策</a>');



}
function showremark(va){
//
$("#"+va).show();
}



	hideZrate();	
	</script>

</body>
</html>