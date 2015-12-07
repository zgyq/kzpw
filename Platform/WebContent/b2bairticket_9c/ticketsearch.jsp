<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国翔商旅-查询航班</title>
<link href="main_cx/css/global.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/validate.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/jquery-1.4.1.min.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link href="main_cx/css/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="main_cx/js/lhgdialog.js"></script>
<script type="text/javascript" src="main_cx/js/layout.js"></script>
<script type="text/javascript" src="main_cx/js/city.js"></script>
<script type="text/javascript" src="main_cx/js/popdg_div.js"></script>
<script type="text/javascript" language="javascript" src="main_cx/js/jquery.blockUI.js"></script>
<script type="text/javascript" language="javascript" src="main_cx/js/publicjs.js"></script>
<!--[if IE 6]>
 <style type="text/css">
 iframe{
position:absolute;
top:0px;
z-index:-1;
width:100%;
 } 
 </style>
 <![endif]-->

<script type="text/javascript">

//页面加载
    $(document).ready(function()
	   {
	    //默认加载当日日期
	  $("#txtFromDate").val(getDateyyyyMMdd(4));
	
	 });
 function getDateyyyyMMdd(num) {
    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
} 


        function bindtravelType(id) {
            if (id == "1") {
                $("#divbackdate").hide();
            }
            else if (id == "2") {
                $("#divbackdate").show();
            }
        }
        //更换出发到达地

        function exchangecity() {
            var startcityname = $("#txtStartCity").val();
            var startcitycode = $("#hidStarCityCode").val();
            $("#txtStartCity").val($("#txtEndCity").val());
            $("#hidStarCityCode").val($("#hidEndCityCode").val());
            $("#txtEndCity").val(startcityname);
            $("#hidEndCityCode").val(startcitycode);
        }
        //高级查询
        function showadvsearch() {
            $("#divadvsearch").toggle("fast");
        }
        //数据验证
        function checkdata() {
            var rdoonway = document.getElementById("rdoOneWay");
            var rdoroundway = document.getElementById("rdoRoundWay");

            if ($("#txtStartCity").val() == "" || $("#hidStarCityCode").val() == "") {
                jsalert("请选择出发城市！","Error");
                $("#txtStartCity").focus();
                return false;
            }
            else if ($("#txtEndCity").val() == "" || $("#hidEndCityCode").val() == "") {
                jsalert("请选择到达城市！", "Error");
                $("#txtEndCity").focus();
                return false;
            }
            else if ($("#txtStartCity").val() == $("#txtEndCity").val()) {
                jsalert("出发城市和目的城市不能相同，请重新选择！", "Error");
                $("#txtStartCity").focus();
                return false;
            }
            else if ($("#txtFromDate").val() == "") {
                jsalert("请选择出发日期！", "Error");
                $("#txtFromDate").focus();
                return false;
            }
            else if (rdoroundway.checked == true && $("#txtBackDate").val() == "") {
                jsalert("返程时间不能为空！", "Error");
                $("#txtBackDate").focus();
                return false;
            }
            else {
            //<br/><span style=''>正在为您查询航班信息，请等待...</span>
                loadingoverlay("<img src='main_cx/img/loading2.gif' />");
                return true;
            }
            return false;
        }
    </script>
</head>
<body id="mainbody">
<form name="form1" method="post" action="b2b9cairticket!toTicketList.action" id="form1">
<div><input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
	value="">
</div>

<div><input type="hidden" name="__EVENTVALIDATION"
	id="__EVENTVALIDATION"
	value="">
</div>
<div class="g-mn" style="float: none">
<h1 class="title">春秋机票查询</h1>

<div class="m-sch">
<div id="check-city"></div>
<div class="info">
<div class="f-cb">
<div><input id="rdoOneWay" type="radio" name="s_traveltype"
	value="1" checked="checked" onclick="bindtravelType(1);">
单程&nbsp;&nbsp;&nbsp;出发城市: <input name="s_depcityname" type="text"
	value="上海虹桥" id="txtStartCity" class="text citycontroltext"
	onfocus="popUp('txtStartCity','hidStarCityCode')"
	onclick="popUp('txtStartCity','hidStarCityCode')"
	onblur="showSearch('txtStartCity',1)" autocomplete="off"
	onkeyup="popup_hide();suggest.display('txtStartCity','hidStarCityCode',event);"
	style="border: 1px solid #ccc;"> <input type="hidden"
	name="s_depcitycode" id="hidStarCityCode" value="SHA">
<div class="s_exchange"><a href="javascript:void(0);"
	onclick="exchangecity();">换</a></div>
</div>

<div>出发日期: <input name="s_startdate" type="text"
	value="" id="txtFromDate" class="text Wdate"
	onclick="WdatePicker({minDate:'%y-%M-{%d}'})"
	style="border: 1px solid #ccc;"></div>
</div>
<div class="f-cb">
<div><input id="rdoRoundWay" type="radio" name="s_traveltype" disabled="disabled"
	value="2" onclick="bindtravelType(2);">
返程&nbsp;&nbsp;&nbsp;到达城市: <input name="s_arrcityname" type="text"
	id="txtEndCity" class="text citycontroltext"
	onfocus="popUp('txtEndCity','hidEndCityCode')"
	onclick="popUp('txtEndCity','hidEndCityCode')"
	onblur="showSearch('txtEndCity',1)" autocomplete="off" value="广州"
	onkeyup="popup_hide();suggest.display('txtEndCity','hidEndCityCode',event);"
	style="border: 1px solid #ccc;"> <input type="hidden" value="CAN"
	name="s_arrcitycode" id="hidEndCityCode"></div>
<div style="display: none" id="divbackdate">返回日期: <input
	name="s_backdate" type="text" id="txtBackDate" class="text Wdate"
	onclick="WdatePicker({minDate:'%y-%M-{%d+1}'})"
	style="border: 1px solid #ccc;"></div>
<div>航空公司: <select name="ddlAirCompany" id="ddlAirCompany"
	style="border: 1px solid #ccc; width: 140px; height: 33px">
	<option value="9C">--春秋航空--</option>
	

</select></div>
</div>



<div class="btn-sch">



<input type="submit" name="btnSearch"
	value="" onclick="return checkdata();" id="btnSearch"> <span
	class="show" onclick="showadvsearch();">高级搜索</span></div>
</div>
<div class="info search" id="divadvsearch">
<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 出行人数:<select
	name="ddlPersonNum" id="ddlPersonNum" style="border: 1px solid #ccc;">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>

</select> 舱位等级:<select name="ddlCabinType" id="ddlCabinType"
	style="border: 1px solid #ccc;">
	<option value="-1">不限</option>
	<option value="1">经济舱</option>
	<option value="2">公务/头等舱</option>

</select></div>
</div>
</div>
<!-- end sch -->
<div style="height: 40px;margin-top: 8px;"><ul>

<li style="font-size: 18px;color: red;border: 1px;">
提示：由于航空公司折扣及价格经常变动，最终票价以审核结果为准！注意:春秋航班所有客票均不能作废!</br>
【春秋航空】可免费携带7公斤且体积不超过20X30X40厘米的非托运行李进入客舱。婴儿无免费行李额。托运需收费，若需托运行李,请至机场柜台购买或联系平台客服进行购买！
</li>
</ul>



</div>
<div class="m-ticket">
<div class="head">
<h3>预订须知</h3>

</div>
<div class="msg">
<table>
	<tbody style="font-size: 15px;">
		<tr>
			<td>&nbsp; &nbsp; 1. 名字错误不能更改，保证填写客人有效证件名字准确有效，身份证号码紧急修改请拨:<a href="#" style="color: red">${dns.serviceline}</a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp; &nbsp; 2. 用护照预定外宾机票，<a href="#" style="color: red">先姓后名</a>，中间"/"隔开</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp; &nbsp; 3.
			预定特殊政策的，请细读特殊政策的备注，<a href="#" style="color: red">研读特殊政策的经验总结</a>, 为满足大多数采购需求我们默认到普通政策选择页面,请广大客户谅解。
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp; &nbsp; 4. 生成订单之后，为了避免不必要的损失<a href="#" style="color: red">（出现编码被取消或者NO位）</a>，请广大采购及时支付。</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp; &nbsp; 5.
			<a href="#" style="color: red">由于航空公司折扣及价格经常变动，最终票价以PAT结果为准！如有价格不符，平台将操作退款</a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp; &nbsp; 6. 其他事宜：本采购须知中未涉及的交易规则等未尽事宜按国内运输客规规定执行。</td>
		</tr>

	</tbody>
</table>
</div>
</div>
</div>
</form>


</body>
</html>