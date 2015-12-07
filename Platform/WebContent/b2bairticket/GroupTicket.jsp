<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>团队票订单申请</title>
<link href="main_cx/css/global.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/ticketlist.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/validate.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/airlines.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/jquery-ui-1.8.2.custom.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/tip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/jquery-1.4.1.min.js"></script>
<script language="javascript" type="text/javascript" src="main_cx/js/My97DatePicker/WdatePicker.js"></script>
<link href="main_cx/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="main_cx/js/lhgdialog.js?skin=idialog"></script>
<script src="main_cx/js/jquery.tmpl.js" type="text/javascript"></script>
<script src="main_cx/js/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="main_cx/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="main_cx/js/jquery.poshytip.js" type="text/javascript"></script>
<script src="main_cx/js/publicjs.js" type="text/javascript"></script>
<script src="main_cx/js/ticket/groupticket.js" type="text/javascript"></script>
<script type="text/javascript" src="main_cx/js/layout.js"></script>
<script type="text/javascript" src="main_cx/js/city.js"></script>
<script type="text/javascript" src="main_cx/js/popdg_div.js"></script>
<script type="text/javascript">
        //成人含税费总票价
        var adultpricefee = 0;
        var adultpassengerprice = 0;
        var adultpassengerairport = 0;
        var adultpassengerfuel = 0;
        var Aircomapnycode = "";
        var cabincode = "";
        //总乘机人数
        var passengercount = 0;
        //全价价格
        var yprice = 0;
        //一份保险的价格
        var insuranceprice = 20;
        var passengerJsonString = '[{ ID: "1",Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Birthday:"",Insurancenum:"0",Insurancemoney:"' + insuranceprice + '",Ticketprice:"' + adultpassengerprice + '",Airportprice:"' + adultpassengerairport + '",Fuelprice:"' + adultpassengerfuel + '",Totalprice:"' + adultpricefee + '",Issave:"",Customerpassid:"0" }]';
        var passengers = eval(passengerJsonString);
        $(document).ready(function () {
            //加载第一个乘机人 
            $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
        });
		function bindtravelType(id) {
		    if (id == "1") {
		        $("#trsegment2").hide();
		    }
		    else if (id == "2") {
		        $("#trsegment2").show();
		    }
		}
    </script>
</head>
<body id="mainbody">
<form name="form1" method="post" action="#" id="form1">



<div class="g-mn" style="float: none">
<div class="center">
<div class="content" style="margin-top: 10px">
<!--国内机票列表页右侧内容-->
<div class="listcreateorder" id="main_content">
<h1 class="title">团队票订单申请</h1>
<div class="buzou" style="margin-top: 10px"><span class="ddtx">1.填写申请单</span>
<span>2.申请单报价</span> <span>3.订单支付</span></div>
<div class="cB"></div>
<div class="gray_border bottom10px" id="Div1">
<div class="hbinfo">
<div class="fr mr15 orange"></div>
<h2 class="f14b">航程类型</h2>
</div>
<div
	style="padding-left: 10px; padding-top: 10px; height: 25px; border-bottom: 1px dashed #c8c8c8; border-top: 1px dashed #c8c8c8;">
航程类型： <input id="rdoOneWay" type="radio" name="TravelType"
	value="rdoOneWay" checked="checked" onclick="bindtravelType(1);">单程
&nbsp;&nbsp;<input id="rdoRoundWay" type="radio" name="TravelType"
	value="rdoRoundWay" onclick="bindtravelType(2);">往返程</div>
</div>

<!--航班信息-->
<div class="gray_border bottom10px" id="flight_info_body">
<div class="hbinfo">
<div class="fr mr15 orange"></div>
<h2 class="f14b">航班信息</h2>

</div>
<div id="segmentlistinfo">

<table class="comeback_table" width="100%" cellspacing="0"
	cellpadding="0" border="0">
	<thead>
		<tr>
			<th style="text-align: center"><b>出发城市</b></th>
			<th style="text-align: center"><b>到达城市</b></th>
			<th style="text-align: center"><b>出发日期</b></th>
			<th style="text-align: center"><b>抵达日期</b></th>
			<th style="text-align: center"><b>航班号</b></th>
			<th style="text-align: center"><b>舱位</b></th>
			<th style="text-align: center"><b>操作</b></th>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px; width: 135px"
				class="text citycontroltext"
				onfocus="popUp('txtfromcity_1','hidfromcitycode_1')"
				onclick="popUp('txtfromcity_1','hidfromcitycode_1')"
				onblur="showSearch('txtfromcity_1',1)" autocomplete="off"
				onkeyup="popup_hide();suggest.display('txtfromcity_1','hidfromcitycode_1',event);"
				id="txtfromcity_1" value=""> <input type="hidden"
				id="hidfromcitycode_1" value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px; width: 135px"
				class="text citycontroltext"
				onfocus="popUp('txttocity_1','hidtocitycode_1')"
				onclick="popUp('txttocity_1','hidtocitycode_1')"
				onblur="showSearch('txttocity_1',1)" autocomplete="off"
				onkeyup="popup_hide();suggest.display('txttocity_1','hidtocitycode_1',event);"
				id="txttocity_1" value=""> <input type="hidden"
				id="hidtocitycode_1" value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px;" class="text Wdate"
				onclick="WdatePicker({minDate:'%y-%M-{%d}'})" id="txtfromdate_1"
				value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px;" class="text Wdate"
				onclick="WdatePicker({minDate:'%y-%M-{%d}'})" id="txtarrivedate_1"
				value=""></td>
			<td align="center"><input type="text"
				style="width: 80px; height: 25px;" class="text"
				id="txtflightnumber_1" value=""></td>
			<td align="center"><input type="text"
				style="width: 80px; height: 25px;" class="text" id="txtcabincode_1"
				value=""></td>
			<td class="dashed_ahover" align="center"><a href="#" onclick=""
				style="text-decoration: underline; color: #1c7dc7">清空</a></td>

		</tr>
		<tr id="trsegment2" style="display: none">
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px; width: 135px"
				class="text citycontroltext"
				onfocus="popUp('txtfromcity_2','hidfromcitycode_2')"
				onclick="popUp('txtfromcity_2','hidfromcitycode_2')"
				onblur="showSearch('txtfromcity_2',1)" autocomplete="off"
				onkeyup="popup_hide();suggest.display('txtfromcity_2','hidfromcitycode_2',event);"
				id="txtfromcity_2" value=""> <input type="hidden"
				id="hidfromcitycode_2" value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px; width: 135px"
				class="text citycontroltext"
				onfocus="popUp('txtfromcity_2','hidtocitycode_2')"
				onclick="popUp('txttocity_2','hidtocitycode_2')"
				onblur="showSearch('txttocity_2',1)" autocomplete="off"
				onkeyup="popup_hide();suggest.display('txttocity_2','hidtocitycode_2',event);"
				id="txttocity_2" value=""> <input type="hidden"
				id="hidtocitycode_2" value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px;" class="text Wdate"
				onclick="WdatePicker({minDate:'%y-%M-{%d}'})" id="txtfromdate_2"
				value=""></td>
			<td align="center"><input type="text"
				style="border: 1px solid #ccc; height: 25px;" class="text Wdate"
				onclick="WdatePicker({minDate:'%y-%M-{%d}'})" id="txtarrivedate_2"
				value=""></td>
			<td align="center"><input type="text"
				style="width: 80px; height: 25px;" class="text"
				id="txtflightnumber_2" value=""></td>
			<td align="center"><input type="text"
				style="width: 80px; height: 25px;" class="text" id="txtcabincode_2"
				value=""></td>
			<td class="dashed_ahover" align="center"><a href="#" onclick=""
				style="text-decoration: underline; color: #1c7dc7">清空</a></td>

		</tr>
	</tbody>
</table>
</div>

<br>
</div>
</div>
<br>
<!--乘客信息-->
<div class="cL"></div>
<!-- 页面显示 -->
<div class="gray_border bottom10px" id="passengers_div">
<div class="hbinfo dashedB">
<h2 class="f14b">乘客信息</h2>
<span>- 请准确填写登机人信息，以免在购票过程中发生问题。乘客信息填写说明</span></div>
<div class="p10 pl15"><span class="mr10" id="linkadd"> <img
	src="main_cx/img/edit_add.png" border="0"><a
	href="javascript:void(0)" onclick="addpassenger('');">增加乘机人</a>
</span></div>
<!--乘客信息-成人1-->
<div id="divpassengers"><script id="passengerTemplate" type="text/x-jquery-tmpl"> 
            <div class="adult_css passenger_info" id="divinformation_\${ID}">
                <div class="gray_bg dashed">
                    <span class="seave_info" id="seave_info_\${ID}">
                        <img src="main_cx/img/lp-a2.gif" border="0" style="margin-top:10px" />
                        <a id="linkdel_\${ID}" href="javascript:void(0)" onclick="delpassenger(\${ID});">删除乘客</a></span>乘机人信息</div>
                <ul class="name_info mt10">
                    <li>
                    <div><span class="orange">*</span>&nbsp;乘客类型</div>
                        <select class="input_width20 id_type"  style="border: 1px solid #ccc;width:140px;height:33px" id="ddlpassengertype_\${ID}" onchange="changepassengertype(\${ID})">
				         <option value="1">成人</option>
				         <option value="2">儿童</option>
                         <option value="3">婴儿</option>
			            </select>
                       
                    </li>
                    <li>
                        <div>
                            <span class="orange">*</span>&nbsp;乘客姓名</div>
                        <input type="text" style="border: 1px solid #ccc;height:33px" id="txt_name_\${ID}" value="${Name}" title="请填写乘客姓名" class="test_name">
                        <span class="meg_str">持护照登机的外宾，必须按照护照顺序区分姓与名，例如“Smith/Black”</span> </li>
                    
                    <li>
                        <div>
                            <span class="orange">*</span>&nbsp;证件信息</div>
                        <select class="input_width20 id_type"  style="border: 1px solid #ccc;width:140px;height:33px" onchange="changeidcardtype(\${ID},${Customerpassid})" id="ddlidcardtype_\${ID}">
				            <option value="1">身份证</option>
				            <option value="2">护照</option>
                            <option value="3">军官证</option>
                            <option value="4">士兵证</option>
                            <option value="5">台胞证</option>
				            <option value="6">其他</option>
			            </select>
                        <input type="text" class="input_width120 test_id_num" style="border: 1px solid #ccc;height:33px" id="txt_idcardnumber_\${ID}" value="${Idcardnumber}" />
                    </li>
                    <li style="display:none">
                        <div>
                            <span class="orange must_mob">*</span>手机号码</div>
                        <input type="text" class="test_mob_num" id="txtmobile_\${ID}" style="border: 1px solid #ccc;width:140px;height:33px">
                        <span class="meg_str"></span></li>
                    <li style="display:none">
                        <div>
                            购买保险</div>
                        <span class="margin_left5px ptwz" style="display: none">去程</span>
                        <select name="adult_insurance1"  style="border: 1px solid #ccc;height:33px" class="input_width20 for_insurance1" id="ddlinsurance_\${ID}" onchange="changepassengertype(\${ID});changeinsurance(\${ID});">
                            <option value="0" selected="selected">0份</option>
                            <option value="1">1份</option>
                            <option value="2">2份</option>
                        </select>
                        <span class="fontArial">¥20</span>/份 </li>
                    
                    <li style="display:none">
                        <div>
                            常旅客卡</div>
                         <input type="text" value="" class="card_num" id="txtaircard_\${ID}">
                         <input type="hidden" id="hid_ticketprice_\${ID}" value="${Ticketprice}" />
                         <input type="hidden" id="hid_airportprice_\${ID}" value="${Airportprice}" />
                         <input type="hidden" id="hid_fuelprice_\${ID}" value="${Fuelprice}" />
                         <input type="hidden" id="hid_totalprice_\${ID}" value="${Totalprice}" />
                         <input type="hidden" id="hid_insurance_\${ID}" value="${Insurancemoney}" />
                         <input type="hidden" id="hid_insurancenum_\${ID}" value="${Insurancenum}" />
                    </li>
                </ul>
            </div>
            <div id="children_part">
            
            </div>
                        </script>

<div id="children_part"></div>
</div>
</div>
<input type="hidden" name="adult_input" id="adult_input"> <input
	type="hidden" name="children_input" id="children_input"> <input
	type="hidden" name="s_type_input" id="s_type_input"> <input
	type="hidden" name="s_type_meg_input" id="s_type_meg_input"> <input
	type="hidden" name="s_type_save_info" id="s_type_save_info"> <input
	type="hidden" name="offer_info" id="offer_info"> <!--联系信息-->
<div class="gray_border bottom10px" id="c_form_div">
<div class="hbinfo">
<h2 class="f14b">联系信息</h2>
<span>- 请准确填写联系人信息，重要信息我们会通过手机短信方式通知您。</span></div>
<div>
<ul class="name_info">
	<li>
	<div><span class="orange_b">*</span>联系人姓名</div>
	<input name="txtcontactname" type="text" id="txtcontactname"
		class="test_name" style="border: 1px solid #ccc; height: 33px">
	<span class="meg_str">请准确填写联系人信息</span></li>
	<li>
	<div><span class="orange_b">*</span>手机号码</div>
	<input name="txtcontactmobile" type="text" id="txtcontactmobile"
		class="test_name" style="border: 1px solid #ccc; height: 33px">
	<span class="meg_str">出票信息我们会通过手机短信方式通知您</span></li>
</ul>
</div>
</div>

<input name="hidallpassengers" type="text" id="hidallpassengers"
	style="display: none"> <input type="hidden"
	name="hidsegmentinfo" id="hidsegmentinfo"> <input
	name="hidplatprice" type="text" value="0" id="hidplatprice"
	style="display: none"> <input name="hidadultpasscount"
	type="text" value="0" id="hidadultpasscount" style="display: none">
<input name="hidchildpasscount" type="text" value="0"
	id="hidchildpasscount" style="display: none"> <input
	name="hidbabypasscount" type="text" value="0" id="hidbabypasscount"
	style="display: none"> <br>
<div class="confer" id="submit_but"><input name="" type="button"
	id="btntolist" class="btncss" value="返回列表" onclick="history.go(-1);">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="btnsubmit"
	value="提交申请" onclick=" return checkdata();" id="btnsubmit"
	class="btncss"></div>
</div>
<div class="cb"></div>
</div>
</div>

</form>


</body>
</html>