<%@ page contentType="text/html; charset=utf-8"%>

<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏东方航空旅行社</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/ticket.css" rel="stylesheet" type="text/css" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<link href="style/global.css" type="text/css" rel="stylesheet" />

<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000
}

#tablePagination {
	background-color: Transparent;
	font-size: 1em;
	padding: 0px 5px;
	height: 20px
}

#tablePagination_paginater {
	margin-left: auto;
	margin-right: auto;
}

#tablePagination img {
	padding: 0px 2px;
}

#tablePagination_perPage {
	float: left;
}

#tablePagination_paginater {
	float: right;
}
-->
</style>
<link rel="stylesheet" href="style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery.tablePagination.0.2.min.js"
	type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script src="js/jtip.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="<%=request.getContextPath() %>/js/dialog.js" type="text/javascript"></script>





<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ext-all.css" /> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript"> 
var win;
function dispose() {
   Ext.MessageBox.show({
           msg: '系统正在处理您的请求, 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
function colsedispose(){
 Ext.MessageBox.hide();
}

</script>





<script>	
		$(document).ready(function() {
			 $('#tbcuspassenger').tablePagination({});
			$("#form1").validationEngine();
		
		});
	</script>
<script type="text/javascript">
     function showDiag(diag,flag)
		{
			document.getElementById(diag).style.display=flag;
		}
</script>
<script type="text/javascript">
function changeraddisable(rd1,typ1,rd2,typ2,rd3,typ3,rdchecked){
      document.getElementById(rd1).disabled=typ1;
      document.getElementById(rd2).disabled=typ2;
      document.getElementById(rd3).disabled=typ3;
      document.getElementById(rdchecked).disabled="";
      document.getElementById(rdchecked).checked="checked";
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','none');
       if(rdchecked=="postmoney3"||rdchecked=="postmoney4"){
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','block');
      }
      if(rdchecked=="postmoney2"){
        showdiag('addtesstable_my','block');
        showdiag('addtesstable','none');
      }
}
function showpeisong()
{
    document.getElementById("postmoney1").checked="";
    document.getElementById("postmoney0").checked="checked";
}
function searchcusp()
{
   var name=$("#txtcuspaa").val();
   var compassenger=document.getElementById("compassenger");
   var passother=0;
   if(document.getElementById("passother").checked)
   {
   	passother=0;
   }
   if(document.getElementById("passother2").checked)
   {
   	passother=1;
   }
   if(document.getElementById("passother2").checked&&document.getElementById("passother").checked)
   {
   	passother=2;
   }
    var userid=document.getElementById("listcususer").options[document.getElementById("listcususer").selectedIndex].value;
    $.ajax({
      type:"POST",
      url:"airsearch!getHtmlCusPass.action",
      data:{strCusPassName:name,passother:passother,userid:userid},
      beforeSend:function(){$("#tbcuspassenger").html("正在查询...");},             
      success:function(data){
      $("#tbcuspassenger").html(data);     
      $('#tbcuspassenger').tablePagination({});    
      }            
      });
}
function showpassenger(id,opt)
  {
      $("#passengediv").dialog({
              title:'常用登机人',
              show: null,
              bgiframe: false,
              autoOpen: false,
              draggable: true,                
              resizable: true,
              modal: true,
              width: 700,
              height: 250
          });
      $("#passengediv").dialog("open");
  }
</script>
</head>

<body>

<form action="ticketorder!add.action" method="post" name="form1"
	id="form1">
<div>

<div class="box" style="text-align: center;">
<div class="quan" style="text-align: left"><span class="lan14_cu">机票信息</span>
<span class="r"> <b style="color: #FFF;"><ww:property
	value="getCitynameByAirport(flightOne.StartAirport)" />&nbsp;<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">←</ww:if>→&nbsp;<ww:property
	value="getCitynameByAirport(flightOne.EndAirport)" />&nbsp;出发日期：<ww:property
	value="formatTimestampyyyyMMdd(segmentOne.departtime)" />&nbsp;<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">返程日期：<ww:property
		value="formatTimestampyyyyMMdd(segmentTwo.departtime)" />
</ww:if></b>&nbsp;&nbsp;&nbsp; </span></div>
<div class="hangb" style="margin-top: 10px;">
<ul class="huang12_c" style="background: #DDECF3; height: 30px;">
	<li style="width: 15%">航班信息</li>
	<li style="width: 25%">抵达时间／机场</li>
	<li style="width: 8%">机型</li>
	<li style="width: 7%">退改签</li>
	<li style="width: 10%">折扣/舱位</li>
	<li style="width: 15%">机建/燃油</li>
	<li style="width: 20%">价格</li>
</ul>
<ul style="height: 50px; line-height: 25px; text-align: center;">
	<li style="width: 15%">
	<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td rowspan="2"><img
				src="images/airComlogo/<ww:property value="segmentOne.aircomapnycode" />.gif" /></td>
			<td><ww:property value="segmentOne.flightnumber" /></td>
		</tr>
		<tr>
			<td><ww:property value="segmentOne.aircompanyname" /></td>
		</tr>
	</table>


	</li>
	<li style="width: 25%; text-align: left;"><img
		src="images/plane1.gif" width="25" height="25" /><span><font
		style="margin: 0 15px 0 20px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentOne.departtime)" /></font><ww:property
		value="flightOne.StartAirportName" /></span><br />
	<img src="images/plane2.gif" width="25" height="25" /><span><font
		style="margin: 0 15px 0 20px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentOne.arrivaltime)" /></font><ww:property
		value="flightOne.EndAirportName" /></span></li>
	<li style="width: 8%;">
	<div style="cursor: pointer;" onmouseover="showDiag('diag11','block')"
		onmouseout="showDiag('diag11','none')"><font
		style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;"><ww:property
		value="segmentOne.flightmodelnum" /></font>
	<div style="position: relative;">
	<div id="diag11"
		style="display: none; position: absolute; z-index: 99; left: -15px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
		class="box">
	<div
		style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>机型信息</b></div>
	<div style="padding-left: 5px;"><ww:property
		value="subfightimg(getflightmodeldes(segmentOne.flightmodelnum))" /></div>
	</div>
	</div>
	</div>
	</li>
	<li style="width: 7%"><span>
	<div style="cursor: pointer;" onmouseover="showDiag('diag10','block')"
		onmouseout="showDiag('diag10','none')"><font
		style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;">退改签</font>
	<div style="position: relative;">
	<div id="diag10"
		style="display: none; position: absolute; z-index: 99; left: -15px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
		class="box">
	<div
		style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签</b></div>
	<div style="padding-left: 5px;"><ww:property
		value="segmentOne.rules" /></div>
	</div>
	</div>
	</div></li>
	<li style="width: 10%; font-size: 14px; line-height: 40px;"><ww:if
		test="segmentOne.Discount>=100.0">全价</ww:if> <ww:else>
		<ww:property value="segmentOne.Discount/10" />折</ww:else>/<ww:property
		value="segmentOne.cabincode" /></li>
	<li style="width: 15%;"><span class="f">￥<b
		class="huang14_c" style="line-height: 16px;"><ww:property
		value="formatMoney_string(segmentOne.airportfee)" />/<ww:property
		value="formatMoney_string(segmentOne.fuelfee)" /></b>(成人)</span><br />
	<span class="f">￥<b class="huang14_c" style="line-height: 16px;">0/<ww:property
		value="formatMoney_string(getRoundPrice(segmentOne.fuelfee,2))" /></b>(儿童)</span><br />
	<span class="f">￥<b class="huang14_c" style="line-height: 16px;">0/0</b>(婴儿)</span>
	</li>
	<li style="width: 20%"><span>￥<b class="huang14_c"
		style="line-height: 16px;"><ww:property
		value="formatMoney(segmentOne.Price+segmentOne.airportfee+segmentOne.fuelfee)" /></b>/成人(含税费)</span><br />
	<span>￥<b class="huang14_c" style="line-height: 16px;"><ww:property
		value="formatMoney(getRoundPrice(segmentOne.Yprice,2)+getRoundPrice(segmentOne.fuelfee,2))" /></b>/儿童(含税费)</span><br />
	<span>￥<b class="huang14_c" style="line-height: 16px;"><ww:property
		value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" /></b>/婴儿(含税费)</span><br />
	</li>

	<input type='hidden' id='hidPriceSin1'
		value='<ww:property value="segmentOne.Price" />' />
	<input type='hidden' id='hidYPriceSin1'
		value='<ww:property value="segmentOne.yprice"/>' />
	<input type='hidden' id='hidairportFeeSin1'
		value='<ww:property value="segmentOne.airportfee"/>' />
	<input type='hidden' id='hidfuelFeeSin1'
		value='<ww:property value="segmentOne.fuelfee"/>' />
	<input type='hidden' id='hidtotalSin1'
		value='<ww:property
					value="segmentOne.Price+segmentOne.airportfee+segmentOne.fuelfee" />' />
					</span>

</ul>
</div>
<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
	<div class="hangb" style="margin-top: 10px;">
	<ul class="huang12_c" style="background: #DDECF3; height: 30px;">
		<li style="width: 15%">航班信息</li>
		<li style="width: 25%">抵达时间／机场</li>
		<li style="width: 8%">机型</li>
		<li style="width: 7%">退改签</li>
		<li style="width: 10%">折扣/舱位</li>
		<li style="width: 15%">机建/燃油</li>
		<li style="width: 20%">价格</li>
	</ul>
	<ul style="height: 50px; line-height: 25px; text-align: center;">
		<li style="width: 15%">
		<table border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td rowspan="2"><img
					src="images/airComlogo/<ww:property value="segmentTwo.aircomapnycode" />.gif" /></td>
				<td><ww:property value="segmentTwo.flightnumber" /></td>
			</tr>
			<tr>
				<td><ww:property value="segmentTwo.aircompanyname" /></td>
			</tr>
		</table>


		</li>
		<li style="width: 25%; text-align: left;"><img
			src="images/plane1.gif" width="25" height="25" /><span><font
			style="margin: 0 15px 0 20px; line-height: 25px;"><ww:property
			value="formatTimestampHHmm(segmentTwo.departtime)" /></font><ww:property
			value="flightTwo.StartAirportName" /></span><br />
		<img src="images/plane2.gif" width="25" height="25" /><span><font
			style="margin: 0 15px 0 20px; line-height: 25px;"><ww:property
			value="formatTimestampHHmm(segmentTwo.arrivaltime)" /></font><ww:property
			value="flightTwo.EndAirportName" /></span></li>
		<li style="width: 8%;">
		<div style="cursor: pointer;" onmouseover="showDiag('diag11','block')"
			onmouseout="showDiag('diag11','none')"><font
			style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;"><ww:property
			value="segmentTwo.flightmodelnum" /></font>
		<div style="position: relative;">
		<div id="diag11"
			style="display: none; position: absolute; z-index: 99; left: -15px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>机型信息</b></div>
		<div style="padding-left: 5px;"><ww:property
			value="subfightimg(getflightmodeldes(segmentTwo.flightmodelnum))" /></div>
		</div>
		</div>
		</div>
		</li>
		<li style="width: 7%"><span>
		<div style="cursor: pointer;" onmouseover="showDiag('diag10','block')"
			onmouseout="showDiag('diag10','none')"><font
			style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;">退改签</font>
		<div style="position: relative;">
		<div id="diag10"
			style="display: none; position: absolute; z-index: 99; left: -15px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签</b></div>
		<div style="padding-left: 5px;"><ww:property
			value="segmentTwo.rules" /></div>
		</div>
		</div>
		</div></li>
		<li style="width: 10%; font-size: 14px; line-height: 40px;"><ww:if
			test="segmentTwo.Discount>=100.0">全价</ww:if> <ww:else>
			<ww:property value="segmentTwo.Discount/10" />折</ww:else>/<ww:property
			value="segmentTwo.cabincode" /></li>
		<li style="width: 15%;"><span class="f">￥<b
			class="huang14_c" style="line-height: 16px;"><ww:property
			value="formatMoney_string(segmentTwo.airportfee)" />/<ww:property
			value="formatMoney_string(segmentTwo.fuelfee)" /></b>(成人)</span><br />
		<span class="f">￥<b class="huang14_c"
			style="line-height: 16px;">0/<ww:property
			value="formatMoney_string(getRoundPrice(segmentTwo.fuelfee,2))" /></b>(儿童)</span><br />
		<span class="f">￥<b class="huang14_c"
			style="line-height: 16px;">0/0</b>(婴儿)</span></li>
		<li style="width: 20%"><span>￥<b class="huang14_c"
			style="line-height: 16px;"><ww:property
			value="formatMoney(segmentTwo.Price+segmentTwo.airportfee+segmentTwo.fuelfee)" /></b>/成人(含税费)</span><br />
		<span>￥<b class="huang14_c" style="line-height: 16px;"><ww:property
			value="formatMoney(getRoundPrice(segmentTwo.Yprice,2)+getRoundPrice(segmentTwo.fuelfee,2))" /></b>/儿童(含税费)</span><br />
		<span>￥<b class="huang14_c" style="line-height: 16px;"><ww:property
			value="formatMoney(getRoundPrice(segmentTwo.Yprice,10))" /></b>/婴儿(含税费)</span><br />
		</li>
		<input type='hidden' id='hidPriceSin2'
			value='<ww:property value="segmentTwo.Price" />' />
		<input type='hidden' id='hidYPriceSin2'
			value='<ww:property value="segmentTwo.yprice"/>' />
		<input type='hidden' id='hidairportFeeSin2'
			value='<ww:property value="segmentTwo.airportfee"/>' />
		<input type='hidden' id='hidfuelFeeSin2'
			value='<ww:property value="segmentTwo.fuelfee"/>' />
		<input type='hidden' id='hidtotalSin2'
			value='<ww:property
					value="segmentTwo.Price+segmentTwo.airportfee+segmentTwo.fuelfee" />' />
		</span>

	</ul>
	</div>
</ww:if> <ww:else>
	<input type='hidden' id='hidPriceSin2' value='0' />
	<input type='hidden' id='hidYPriceSin2' value='0' />
	<input type='hidden' id='hidairportFeeSin2' value='0' />
	<input type='hidden' id='hidfuelFeeSin2' value='0' />
	<input type='hidden' id='hidtotalSin2' value='0" />' />
</ww:else>
<div class="hangb">
<ul
	style="background: #DDECF3; height: 30px; border-bottom: 1px solid #36A1EA;">
	<li style="width: 99%; text-align: center; color: #999;"><font
		class="huang12_c">总金额：RMB<span id="allprice"></span></font> <b
		class="hei12_c" style="margin-left: 10px; margin-right: 15px;">共<span
		id="pricenum"></span>人</b> （单成人总价：<span id="oneprice"></span>）</li>
</ul>
</div>
</div>


<div class="box" style="margin-top: 10px;" id="dengjiren1">
<div class="quan"><font class="lan14_cu">登机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</div>
<div id="divcuspass"><span style="padding-left: 1%;">
常用登机人：<input type="button" name="常用登机人" class="button108" value="常用登机人"
	onclick="showpassenger()" /> <span style="padding-right: 2%;"> <font
	class="hui_xi" style="margin: 0 20px 0 20px;">(如超过2名乘机人，请点击"增加乘机人"按钮)</font></span>
<br />
<div id="passengediv"
	style="display: none; background-color: #fff; left: 0px;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			<ww:if test="getOrderUserLogin().getAgentid()==46">style="display:none;"</ww:if>>
			<tr>
				<td>本公司员工： <select name="listcususer" id="listcususer">
					<ww:if test="getOrderUserLogin().getAgentid()==46">
						<option value="<ww:property value="getOrderUserLogin().id"/>"><ww:property
							value="getOrderUserLogin().membername" /></option>
					</ww:if>
					<ww:else>
						<ww:iterator value="listcususer">
							<option
								<ww:if test="getOrderUserLogin().id==id">selected="selected"</ww:if>
								value="<ww:property value="id"/>"><ww:property
								value="membername" /></option>
						</ww:iterator>
					</ww:else>
				</select></td>
				<td>查询类型：<input name="passother" id="passother"
					checked="checked" type="checkbox" value="1" />常用乘机人<input
					name="passother" id="passother2" type="checkbox" value="2" />员工</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td colspan="2">常旅客姓名：<input type="text" id="txtcuspaa"
					name="strCusPassName"
					value='<ww:property value="strCusPassName" />'>&nbsp;&nbsp;&nbsp;
				<input type="button" id="btnsearch" class="button108"
					onclick="searchcusp();" value="查询" /></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table id="tbcuspassenger" width="100%" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
			<!-- look here -->
				<ww:if test="listCustPassenger.size>0">
					<ww:iterator value="listCustPassenger" status="regionStatus">
						<ww:if test="#regionStatus.index % 8 == 0&&#regionStatus.index!=0">
			</tr>
			<tr>
				</ww:if>
				<td><input name="upassenger"
					id="u_<ww:property value="getCardbyPassengeId(id).id"/>"
					type="checkbox"
					value="<ww:property value="getCardbyPassengeId(id).id"/>"
					onclick="selectadd('<ww:property value="username"/>',1,<ww:if test="getCardbyPassengeId(id)!=null"><ww:property value="getCardbyPassengeId(id).credittypeid"/></ww:if><ww:else>1</ww:else>,<ww:if test="getCardbyPassengeId(id)!=null">'<ww:property value="getCardbyPassengeId(id).creditnumber"/>'</ww:if><ww:else>'证件号码'</ww:else>,'<ww:property value="getCardbyPassengeId(id).id"/>','<ww:property value="id"/>');" />&nbsp;<ww:property
					value="username" /></td>
				</ww:iterator>
				</ww:if>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</span></div>
<div class="c"></div>

<div class="box"
	style="width: 98%; margin: 0 auto; margin-bottom: 10px;"><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="10" />
	
	
</ww:bean> <ww:iterator value="#counter" status="state">
	<div id="passger<ww:property value="#state.index"/>"
		style="display: none;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="text-align: left; line-height: 36px;">
		<tr>
			<td colspan="4"
				style="width: 98%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; margin: 0 auto;"><font
				class="huang12_c f" style="text-indent: 20px;">登机人</font> <span
				class="r" style="margin-right: 20px;"><input
				id="h_savepasenger<ww:property value="#state.index"/>"
				type="checkbox" align="absmiddle" value="1" />&nbsp;&nbsp;保存到常用联系人</span>
			</td>
		</tr>
		<tr>
			<td style="text-indent: 25px; height: 36px;">姓名：
			<input type="hidden" id="cp_<ww:property value="#state.index"/>" />
			 <input name="h_name" style="width: 60px" desc="姓名"
				id="a<ww:property value="#state.index"/>" type="text" /></td>
			<td>登机人类型： <select name="h_ptype" style="width: 60px"
				onchange="changezjhm(<ww:property value="#state.index"/>)"
				id="b<ww:property value="#state.index"/>">
				<option value="1">成人</option>
				<option value="2">儿童</option>
				<option value="3">婴儿</option>
			</select></td>
			
			<!-- ********************************************* -->
			<td><span id="zjlx<ww:property value="#state.index"/>">
			证件类型：<select  name="h_idtype" style="width: 65px" 
				onchange="creditChange('<ww:property value="#state.index"/>');changenull(<ww:property value="#state.index"/>)"
				id="c<ww:property value="#state.index"/>">
				<option value="1">身份证</option>
				<option value="3">护照</option>
				<option value="4">港澳通行证</option>
				<option value="5">台湾通行证</option>
				<option value="6">台胞证</option>
				<option value="7">回乡证</option>
				<option value="8">军官证</option>
				<option value="9">其他</option>
			</select> </span> <span id="zjhm<ww:property value="#state.index"/>">证件号码：</span>
		 <input value='<ww:property value="customercredit.creditnumber"/>'
				maxlength="18" name="h_idnumber" style="width: 140px"
				id="d<ww:property value="#state.index"/>" desc="证件号码/出生年月"				
				type="text" />
				<span
				id="showtishi<ww:property value="#state.index"/>"></span></td>
			
			<td><input type="button" name="" class="button108" value="删除登机人"
				onclick="del(<ww:property value="#state.index"/>)" /> <input
				type="hidden" id="pstemp<ww:property value="#state.index"/>"
				value="" /></td>
		</tr>
		<tr>
			<td style="text-indent: 25px;" colspan="4">购买保险分数：<select
				id="h_insurance<ww:property value="#state.index"/>"
				name="h_insurance" onchange="jisuanjiage()" style="width: 50px">
				<ww:if
					test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
					<option value="1">2</option>
					<option value="0">0</option>
					<option value="2">4</option>
					<option value="3">6</option>
					<option value="4">8</option>
					<option value="5">10</option>
				</ww:if>
				<ww:else>
					<option value="1">1</option>
					<option value="0">0</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</ww:else>
			</select><font class="hui_xi" style="margin-left: 47px;">如果预订是往返机票，则订制的是两份保险，太平洋意外伤害险保费20元/份，保额20万.</font>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
			<td><input type="button" name="" class="button108" value="增加登机人"
				onclick="add()" /></td>
		</tr>
	</table>

	</div>
</ww:iterator>
<div
	style="width: 90%; line-height: 30px; text-align: center; float: left;"
	id="passgeradd<ww:property value="#state.index+1"/>"><input
	name="h_idnumber" id="ying" type="hidden" value="0" /></div>
</div>

<div class="c"></div>
</div>




<div class="box f"
	style="display: none; margin-top: 10px; width: 1001px;" id="dengjiren2">
<div class="quan"><font class="lan14_cu">登机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</div>

<div class="c"></div>

<div class="hangd f"><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="9" />
</ww:bean> <ww:iterator value="#counter" status="state">
	<div id="pa<ww:property value="#state.index"/>" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="99%"
		style="margin: 0 auto;">
		<tr>
			<td colspan="4"
				style="width: 100%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; padding-left: 20px;">
			<font class="huang12_c" style="text-indent: 20px;">登机人</font></td>
		</tr>
		<tr>
			<td style="width: 20%; height: 36px; padding-left: 20px;">姓名： <span
				id="r<ww:property value="#state.index"/>"></span></td>

			<td style="width: 20%; height: 36px;">登机人类型：<span
				id="t<ww:property value="#state.index"/>"></span></td>
			<td style="width: 20%; height: 36px;">证件类型：<span
				id="y<ww:property value="#state.index"/>"></span></td>
			<td style="width: 20%; height: 36px;"><span
				id="cardnumberspan<ww:property value="#state.index"/>">证件号码：</span><span
				id="p<ww:property value="#state.index"/>"></span></td>

		</tr>
	</table>
	</div>
</ww:iterator>
<div
	style="width: 90%; padding-top: 5px; height: 30px; line-height: 30px; text-align: center; float: left;"
	id="passgeradd<ww:property value="#state.index+1"/>"></div>
</div>

<div class="c"></div>
</div>


<div class="box" style="margin-top: 10px;" id="lianxiren1">
<div class="quan"><span class="lan14_cu">联系人信息</span></div>
<div style="color: #999999; line-height: 30px; padding-left: 30px;">请准确填写联系人信息（手机号码、E-mail），以便我们与您联系。</div>
<table width="90%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 30px; margin-bottom: 10px;">
	<tr>
		<td width="19%" align="right"><font color="#FF0000">*</font>联系人：</td>
		<td width="66%"><label> <input type="text"
			value="<ww:property value="getOrderUserLogin().membername"/>"
			name="contactname" style="width: 130px;" desc="联系人"
			class="validate[required],onlyNumber" id="lianxi1" /> <span
			class="STYLE1">*</span><font class="hui">请正确填写您的姓名，以便确认您的预订服务</font></label></td>
		<td colspan="2" rowspan="6">&nbsp;</td>
	</tr>
	<tr>
		<td align="right"><font color="#FF0000">*</font>手机号码：</td>
		<td><input type="text" name="contactmobile" style="width: 130px;"
			desc="手机号码" value="<ww:property value="getOrderUserLogin().mobile"/>"
			class="validate[required,custom[mobile]] " id="shoujihao1" /> <span
			class="STYLE1">*</span><font class="hui">请正确填写您的手机号，以便确认您的预订服务</font></td>
	</tr>
	<tr>
		<td align="right">接送人姓名：</td>
		<td><input type="text" name="pickonename"
			style="width: 130px; color: #999999" id="pickonename" /><font
			class="hui">&nbsp;&nbsp;多个接送人用,号分隔</font>
	</tr>
	<tr>
		<td align="right">接送人手机：</td>
		<td><input type="text" name="pickonephone"
			style="width: 130px; color: #999999" id="pickonephone" /><font
			class="hui">&nbsp;&nbsp;多个接送人手机用,号分隔</font>
	</tr>
	<tr>
		<td align="right">联系电话：</td>
		<td><input type="text" name="contacttel"
			style="width: 130px; color: #999999" value="" id="dianhua1"
			value="<ww:property value="getLoginUser().mobile"/>" />
	</tr>
	<tr>
		<td align="right">联系传真：</td>
		<td><input type="text" name="contactfax"
			style="width: 130px; color: #999999" value="" id="chuanzheng1" /></td>
	</tr>
	<tr>
		<td align="right">确认方式：</td>
		<td><label> <select name="notetype" style="width: 130px;"
			id="queren1">
			<option value="1">电话确认</option>
			<option value="2">短信确认</option>
		</select> </label></td>
	</tr>
	<tr>
		<td align="right">支付方式</td>
		<td><ww:if test="getbiguser(getOrderUserLogin().id)">
			<input type="radio" name="paymethod" value="5" checked="checked"
				id="rdopaymethod"
				onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1');showpeisong();" />客户挂账（大客户后付款）&nbsp;&nbsp; 
		<input type="radio" name="paymethod" value="4" id="rdopaymethod"
				onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1')" />无卡支付&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="2" id="rdopaymethod2"
				onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />门市付款&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="3" id="rdopaymethod3"
				onclick="changeraddisable('postmoney1','disabled','postmoney2','disabled','postmoney4','','postmoney3')" />票到付款
					&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="6" id="rdopaymethod3"
				onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />柜台现付
		</ww:if><ww:else>
			<input type="radio" name="paymethod" value="4" checked="checked"
				id="rdopaymethod"
				onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1')" />无卡支付&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="2" id="rdopaymethod2"
				onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />门市付款&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="3" id="rdopaymethod3"
				onclick="changeraddisable('postmoney1','disabled','postmoney2','disabled','postmoney4','','postmoney3')" />票到付款
					&nbsp;&nbsp; 
					<input type="radio" name="paymethod" value="6" id="rdopaymethod3"
				onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />柜台现付
		</ww:else></td>
	</tr>
	<tr>
		<td align="right">订单备注：</td>
		<td align="left"><textarea rows="7" cols="45" name="memo"
			id="txtmemo"></textarea></td>
	</tr>


</table>

</div>



<div class="box f"
	style="margin-top: 10px; display: none; width: 1001px;" id="lianxiren2">
<div class="quan"><span class="lan14_cu">联系人信息</span></div>
<div style="color: #999999; line-height: 30px; padding-left: 30px;">请确认填写联系人信息（手机号码、E-mail），以便我们与您联系。</div>

<table width="90%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 30px; margin-bottom: 10px;">
	<tr>
		<td width="19%" align="right"><font color="#FF0000">*</font>联系人：</td>
		<td width="66%"><span id="lianxi2"></span></td>
		<td colspan="2" rowspan="6">&nbsp;</td>
	</tr>
	<tr>
		<td align="right"><font color="#FF0000">*</font>手机号码：</td>
		<td><span id="shoujihao2"></span></td>
	</tr>
	<tr>
		<td align="right">联系电话：</td>
		<td><span id="dianhua2"></span>
	</tr>
	<tr>
		<td align="right">联系传真：</td>
		<td><span id="chuanzheng2"></span></td>
	</tr>

	<tr>
		<td align="right">确认方式：</td>
		<td><span id="queren2"></span></td>
	</tr>
	<tr>
		<td align="right">支付方式：</td>
		<td><span id="paymethed2"></span></td>
		
	</tr>

</table>
</div>



<div class="box f" style="margin-top: 10px; width: 1000px;"
	id="xingchengdan1">
<div class="quan"><span class="lan14_cu">配送方式</span></div>
<div style="color: #999999; line-height: 30px; padding-left: 30px;">行程单只作为报销凭证，乘机只需要身份证件。航班起飞28天后不能打印行程单</div>
<table width="90%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 30px; margin: 0 auto; margin-bottom: 10px;">
	<tr>
		<td colspan="2"><input type="radio" id="postmoney1"
			name="postmoney"
			onclick="showdiag('addtesstable','none');showdiag('addtesstable_my','none');jisuanjiage()"
			value="1" checked="checked" />&nbsp;&nbsp;我不需要配送</td>
	</tr>
	<tr>
		<td colspan="2"><input type="radio" id="postmoney2" value=2
			name="postmoney"
			onclick="showdiag('addtesstable_my','block');showdiag('addtesstable','none');jisuanjiage()" />&nbsp;&nbsp;市内自取
		</td>
	</tr>

	<tr>
		<td colspan="2"><input id="postmoney3" type="radio"
			onclick="showdiag('addtesstable_my','none');showdiag('addtesstable','block');jisuanjiage()"
			name="postmoney" value="3" />&nbsp;&nbsp;快递行程单发票(费用20元；航班起飞后快递，约3-5个工作日到)</td>
	</tr>
	<tr>
		<td colspan="2"><input id="postmoney4" type="radio"
			name="postmoney"
			onclick="showdiag('addtesstable_my','none');showdiag('addtesstable','block');jisuanjiage()"
			value="4" />&nbsp;&nbsp;市内配送</td>
	</tr>
	<tr>
		<td colspan="2"><input id="postmoney0" type="radio"
			name="postmoney" 
			value="5" onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1');showpeisong();"
			<ww:if test="getbiguser(getOrderUserLogin().id)">checked="checked"</ww:if> />
			 &nbsp;&nbsp;按大客户协议配送</td>
	</tr>
	<tr>
		<td colspan="2">
		<table border="0" cellspacing="0" cellpadding="0" id="addtesstable"
			style="display: none;">
			<tr>
				<td align="right" width="140">收件人姓名：</td>
				<td><input maxlength="10" id="postname" name="postname" value="<ww:property value="getOrderUserLogin().membername"/>"
					style="width: 120px;"></input>&nbsp;<font class="red">*</font></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td><input maxlength="15" id="postmobile" name="postmobile" value="<ww:property value="getOrderUserLogin().mobile"/>"
					style="width: 120px;"></input>&nbsp;<font class="red">*</font></td>
			</tr>
			<tr>
				<td align="right">邮编：</td>
				<td><input maxlength="7" id="postcode" name="postcode"
					style="width: 120px;"></input></td>
			</tr>
			<tr>
				<td align="right">地址：</td>
				<td><textarea maxlength="50" id="addresa" name="addresa"
					id="dizhi1" style="width: 400px;" rows="2"></textarea> &nbsp;<font
					class="red">*</font></td>
			</tr>
			<tr>
				<td align="right">备注：</td>
				<td><textarea maxlength="50" id="memo" name="memo" desc="备注"
					style="width: 400px;" rows="2"></textarea> &nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td>备注:请选择您所邮寄的省份、城市、街道地址不祥将影响邮寄. <br />
				地址格式:XXX省XX市XX区XX小区2-12-502,如:北京市顺义区馨港庄园2-5-601</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
		<table border="0" cellspacing="0" cellpadding="0" id="addtesstable_my"
			style="display: none;">
			<tr>
				<td></td>
				<td><ww:property value="ziquaddress()" /></td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>

</div>
<div class="c"></div>
<div class="box f"
	style="margin-top: 10px; width: 1000px; display: none;"
	id="xingchengdan2">
<div class="quan"><span class="lan14_cu">配送方式</span></div>
<div style="color: #999999; line-height: 30px; padding-left: 30px;">行程单只作为报销凭证，乘机只需要身份证件。航班起飞28天后不能打印行程单</div>
<table width="90%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 30px; margin: 0 auto; margin-bottom: 10px;">
	<tr>
		<td colspan="2">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right" width="140">配送方式：</td>
				<td><span id="youjifangshi"></span></td>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="right" width="140">收件人姓名：</td>
				<td><span id="postname1"></span></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td><span id="postmobile1"></span></td>
			</tr>
			<tr>
				<td align="right">邮编：</td>
				<td><span id="postcode1"></span></td>
			</tr>
			<tr>
				<td align="right">邮寄地址：</td>
				<td><span id="addresa1"></span></td>
			</tr>
			<tr>
				<td align="right">备注：</td>
				<td><span id="memo1"></span></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td></td>
	</tr>

</table>
<div class="c"></div>
</div>


<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<div id="buttonyulan"
	style="text-align: center; margin-top: 10px; width: 1000px;"><input
	name="" type="button" class="button108" value="提交" id="submitbutton"
	onclick="return formsubmit()" /><br />
</div>
<div id="dianzixieyi"></div>

<div class="c"></div>
<!--第五结束--> <input id="HfPersonCount" value="1" type="hidden" /> <input
	id="HfPassNameArr" value="" type="hidden" name="h_name" /> <input
	id="HfIdType" type="hidden" name="h_idtype" /> <input id="HfIdNumber"
	type="hidden" name="h_idnumber" /> <input id="HfPassInfo"
	type="hidden" /> <input id="HfPassTypeInfo" type="hidden" value="1" />
<input id="HfIdTypeInfo" type="hidden" value="1" /> <input
	id="HfIdNumberInfo" type="hidden" /> <input id="HfTravelType"
	type="hidden" value="<ww:property value="segmentOne.traveltype"/>" />
<input id="HfTotalPrice" type="hidden" /> <input id="HfTotalAirportFee"
	type="hidden" /> <input id="HfTotalFuelFee" type="hidden" /> <input
	id="HfCustomerName" type="hidden" /> <input id="hfCustomerCardId"
	type="hidden" /> <input id="hfCustomerID" type="hidden" /> <input
	id="HfAdultNum" type="hidden" value="0" /> <input id="HfChildNum"
	type="hidden" value="0" /> <input id="HfBabyNum" type="hidden"
	value="0" /> <input id="hfAllPassName" type="hidden" /> <input
	id="hfcusGuid" type="hidden" /> <input id="hdfAddress" type="hidden" />
<input id="strTotalPriceOne" type="hidden" name="strTotalPriceOne"><input
	id="strTotalPriceTwo" type="hidden" name="strTotalPriceTwo"></div>

<input type="hidden" name="h_savepasenger" id="h_savepasenger" value="" />
</form>
</body>
</html>
<script language="javascript">
	function changezjhm(isd)
	{
		$.validationEngine.closePrompt(".formError",true); 
		var zjid=document.getElementById("b"+isd).value;
		if(zjid==1)
		{
			document.getElementById("zjlx"+isd).style.display="block";
			document.getElementById("zjlx"+isd).className="f";
			document.getElementById("zjhm"+isd).innerHTML="&nbsp;&nbsp;证件号码";
			document.getElementById("d"+isd).className="validate[required,cardnumber]";
			document.getElementById("showtishi"+isd).innerHTML="";
		}else if(zjid==2)
		{
			document.getElementById("zjlx"+isd).style.display="none";
			document.getElementById("zjhm"+isd).innerHTML="出生日期";
			document.getElementById("d"+isd).className="validate[required,custom[date],ticketdate]";
			document.getElementById("showtishi"+isd).innerHTML="&nbsp;儿童(2-12岁),婴儿(0-2岁),格式为:2003-10-01";
		}else
		{
			document.getElementById("zjlx"+isd).style.display="none";
			document.getElementById("zjhm"+isd).innerHTML="出生日期";
			document.getElementById("d"+isd).className="validate[required,custom[date],ticketdate2]";
			document.getElementById("showtishi"+isd).innerHTML="&nbsp;儿童(2-12岁),婴儿(0-2岁),格式为:2003-10-01";
		}
		jisuanjiage();
	}
	//其他证件类型只是为空验证
	function changenull(isd)
	{
	
		$.validationEngine.closePrompt(".formError",true); 
		var zjid=document.getElementById("c"+isd).value;
		if(zjid==1)
		{
			document.getElementById("d"+isd).className="validate[required,cardnumber]";
		}else
		{
			document.getElementById("d"+isd).className="validate[required]";
		}
	}
	
	
	function selectadd(username,type,idtype,idnumber,id,ccid){	
	
		var check = document.getElementById("u_"+id).checked;
		var i=-1;
		if(check==true){
		for(var j=0;j<9;j++)
		{
			var name=document.getElementById("a"+j).value;
			if(name=="")
			{
				i=j;
				break;
			}
		}
		if(i==-1)
		{
			document.getElementById("u_"+id).checked=false;
			alert("你选择的乘机人超过九个！不能选择！");
			return;
			
		}
		if(document.getElementById("passger"+i).style.display=="none")
		{
			document.getElementById("ying").value=parseInt(document.getElementById("ying").value)+1;
		}
		document.getElementById("passger"+i).style.display="block";
		document.getElementById("a"+i).value=trim(username);
		$("#cp_"+i).val(ccid);
		document.getElementById("b"+i).value=type;
		document.getElementById("c"+i).value=idtype;
		document.getElementById("d"+i).value=idnumber;
		document.getElementById("a"+i).className="validate[required,custom[ticketCNName]]";
		if(idtype==1)
		{
			document.getElementById("d"+i).className="validate[required,cardnumber]";
		}else
		{
			document.getElementById("d"+i).className="validate[required]";
		}
		
		document.getElementById("pstemp"+i).value=id;
		}else
		{
			for(var j=0;j<9;j++)
			{
				var name=document.getElementById("pstemp"+j).value;
				if(name==id)
				{
					i=j;
					break;
				}
			}
			var suntotal=0;
			for(var h=0;h<9;h++)
			{
				if(document.getElementById("passger"+h).style.display=="none")
				{
					suntotal=parseInt(suntotal)+1;
				}
			}
			if(suntotal==8)
			{
				document.getElementById("passger"+i).style.display="block";
			
			}else
			{
				document.getElementById("passger"+i).style.display="none";
				document.getElementById("ying").value=parseInt(document.getElementById("ying").value)-1;
			}
			document.getElementById("a"+i).value="";
			document.getElementById("b"+i).value="";
			document.getElementById("c"+i).value="";
			document.getElementById("d"+i).value="";
			document.getElementById("a"+i).className="";
			document.getElementById("d"+i).className="";
			document.getElementById("pstemp"+i).value="";
			
		}
		jisuanjiage();
		$.validationEngine.closePrompt(".formError",true); 
}
 //添加
   function add(){
    
   var suntotal=0;
  var passgerstr=0;
 	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="none")
		{
			suntotal=parseInt(suntotal)+1;
			passgerstr=h;
			break;
		}
	}
	if(suntotal!=0)
	{
	  document.getElementById("passger"+passgerstr).style.display="block";
	  document.getElementById("a"+passgerstr).className="validate[required,custom[ticketCNName]]";
	  document.getElementById("d"+passgerstr).className="validate[required,cardnumber]";
	  document.getElementById("ying").value=parseInt(document.getElementById("ying").value)+1;
	  jisuanjiage();
	  $.validationEngine.closePrompt(".formError",true); 
  	}else
  	{
  		alert("你选择的乘机人超过九个！不能选择！");
  	}
 }
 //删除
 function del(state){
  var i=document.getElementById("ying").value;
  if(document.getElementById("pstemp"+state).value!=""&&document.getElementById("u_"+document.getElementById("pstemp"+state).value)!=null)
  {
  	document.getElementById("u_"+document.getElementById("pstemp"+state).value).checked=false;
  	
  }
  var suntotal=0;
	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="none")
		{
			suntotal=parseInt(suntotal)+1;
		}
	}
  if(suntotal!=8)
  {
  document.getElementById("ying").value=i-1;
  document.getElementById("passger"+state).style.display="none";
  document.getElementById("a"+state).value="";
  document.getElementById("b"+state).value="1";
  document.getElementById("c"+state).value="1";
  document.getElementById("d"+state).value="";
  document.getElementById("zjlx"+state).style.display="block";
  document.getElementById("zjlx"+state).className="f";
  document.getElementById("zjhm"+state).innerHTML="&nbsp;&nbsp;证件号码:";
  document.getElementById("a"+state).className="";
  document.getElementById("d"+state).className="";
  
  }else
  {
  document.getElementById("a"+state).value="";
  document.getElementById("b"+state).value="1";
  document.getElementById("c"+state).value="1";
  document.getElementById("d"+state).value="";
  document.getElementById("zjlx"+state).style.display="block";
  document.getElementById("zjlx"+state).className="f";
  document.getElementById("zjhm"+state).innerHTML="&nbsp;&nbsp;证件号码:";
  document.getElementById("a"+state).className="validate[required,custom[ticketCNName]]";
  document.getElementById("d"+state).className="validate[required,cardnumber]";
  }
  $.validationEngine.closePrompt(".formError",true); 
  jisuanjiage();
 }
 //预览 下一步
 function yulan(){
 		
 		
 		if(!$('#form1').validationEngine({returnIsValid:true}))
 		{
 			return false;
 		}
 		var chengren=0;
		var ertong=0;
		var yinger=0;
		for(var h=0;h<9;h++)
		{
			if(document.getElementById("passger"+h).style.display=="block")
			{
			
				if(document.getElementById("b"+h).value==1)
				{
					chengren=parseInt(chengren)+1;
				}
				if(document.getElementById("b"+h).value==2)
				{
					ertong=parseInt(ertong)+1;
				}
				if(document.getElementById("b"+h).value==3)
				{
					yinger=parseInt(yinger)+1;
				}
			}
		}
		if(chengren==0)
		{
			if(yinger>0)
			{
				alert("不能单独预订婴儿票，乘机人至少一个是成人!");
				return false;
			}else if(ertong>0)
			{
				alert("不能单独预订儿童票，乘机人至少一个是成人!\r\n如果您是儿童独自乘机，请到我公司柜台人工办理手续！");
				return false;
			}
		}
		document.getElementById("buttonyulan").style.display="none";
		document.getElementById("buttonsubmit").style.display="block";

		document.getElementById("dianzixieyi").style.display="none";
		document.getElementById("dengjiren2").style.display="block";
		document.getElementById("dengjiren1").style.display="none";

		document.getElementById("lianxiren2").style.display="block";
		document.getElementById("lianxiren1").style.display="none";

		
		var queren=document.getElementById("queren1").value;
	
		if(queren==1){
		
		document.getElementById("queren2").innerHTML="电话确认";
		}
		else
		{
		document.getElementById("queren2").innerHTML="短信确认";
		}
		
		document.getElementById("lianxi2").innerHTML=document.getElementById("lianxi1").value;
	
		document.getElementById("shoujihao2").innerHTML=document.getElementById("shoujihao1").value;
		
		document.getElementById("dianhua2").innerHTML=document.getElementById("dianhua1").value;
		
		document.getElementById("chuanzheng2").innerHTML=document.getElementById("chuanzheng1").value;
		
		var k = document.getElementById("ying").value;
		var passengeruserstr="";
		for(i=0;i<9;i++){
			
			var tempname = document.getElementById("a"+i).value;
			if(tempname=="")
			{}else
			{
			document.getElementById("pa"+i).style.display="block";
			document.getElementById("r"+i).innerHTML=document.getElementById("a"+i).value;
			var type="";
			if(document.getElementById("b"+i).value==1)
			{
				type="成人";
			}
			if(document.getElementById("b"+i).value==2)
			{
				type="儿童";
			}
			if(document.getElementById("b"+i).value==3)
			{
				type="婴儿";
			}
			document.getElementById("t"+i).innerHTML=type;
			if(document.getElementById("b"+i).value==1)
			{
				var typecard="";
				if(document.getElementById("c"+i).value==1)
				{
					typecard="身份证";
				}
				if(document.getElementById("c"+i).value==2)
				{
					typecard="驾驶证";
				}
				if(document.getElementById("c"+i).value==3)
				{
					typecard="护照";
				}
				if(document.getElementById("c"+i).value==4)
				{
					typecard="港澳通行证";
				}
				if(document.getElementById("c"+i).value==5)
				{
					typecard="台湾通行证";
				}
				if(document.getElementById("c"+i).value==6)
				{
					typecard="台胞证";
				}
				if(document.getElementById("c"+i).value==7)
				{
					typecard="回乡证";
				}
			}else
			{
				typecard="无";
				document.getElementById("cardnumberspan"+i).innerHTML="出生日期:";
			}
			document.getElementById("y"+i).innerHTML=typecard;
			document.getElementById("p"+i).innerHTML=document.getElementById("d"+i).value;
			if(document.getElementById("h_savepasenger"+i).checked)
			{
				passengeruserstr=passengeruserstr+"1,"
			}else
			{
				passengeruserstr=passengeruserstr+"2,"
			}
			
			}
		}
		document.getElementById("h_savepasenger").value=passengeruserstr;
		//预览行程单
		document.getElementById("xingchengdan1").style.display="none";
		document.getElementById("xingchengdan2").style.display="block";
		var postmoneyvalue=GetRadioValue("postmoney");
		document.getElementById("postname1").innerHTML=document.getElementById("postname").value;
		document.getElementById("postmobile1").innerHTML=document.getElementById("postmobile").value;
		document.getElementById("postcode1").innerHTML=document.getElementById("postcode").value;
		document.getElementById("addresa1").innerHTML=document.getElementById("addresa").value;
		document.getElementById("memo1").innerHTML=document.getElementById("memo").value;
		if(postmoneyvalue==1)
		{
			document.getElementById("youjifangshi").innerHTML="我不需要配送";
		}
		if(postmoneyvalue==2)
		{
			document.getElementById("youjifangshi").innerHTML="自取";
		}
		if(postmoneyvalue==3)
		{
			document.getElementById("youjifangshi").innerHTML="快递行程单发票(费用20元；航班起飞后快递，约3-5个工作日到)";
		}
		if(postmoneyvalue==4)
		{
			document.getElementById("youjifangshi").innerHTML="市内配送";
		}
		if(postmoneyvalue==5)
		{
			document.getElementById("youjifangshi").innerHTML="大客户协议配送";
		}
		if(GetRadioValue("paymethod")==4)
		{	
			document.getElementById("paymethed2").innerHTML="无卡支付";
		}
		if(GetRadioValue("paymethod")==5)
		{	
			document.getElementById("paymethed2").innerHTML="客户挂账（大客户后付款）";
		}
		if(GetRadioValue("paymethod")==2)
		{	
			document.getElementById("paymethed2").innerHTML="门市付款";
		}
		if(GetRadioValue("paymethod")==3)
		{	
			document.getElementById("paymethed2").innerHTML="票到付款";
		}
		if(GetRadioValue("paymethod")==6)
		{	
			document.getElementById("paymethed2").innerHTML="柜台现付";
		}
}
 //上一步
 function shangyibu()
{
document.getElementById("buttonyulan").style.display="block";
document.getElementById("buttonsubmit").style.display="none";
document.getElementById("dengjiren2").style.display="none";
document.getElementById("dengjiren1").style.display="block";
document.getElementById("dianzixieyi").style.display="block";

document.getElementById("lianxiren2").style.display="none";
document.getElementById("lianxiren1").style.display="block";
//反回行程单
document.getElementById("xingchengdan1").style.display="block";
document.getElementById("xingchengdan2").style.display="none";
}
//计算价格
function jisuanjiage()
{
	var chengren=0;
	var ertong=0;
	var yinger=0;
	var sumbaoxian=0;
	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="block")
		{
		
			if(document.getElementById("b"+h).value==1)
			{
				chengren=parseInt(chengren)+1;
			}
			if(document.getElementById("b"+h).value==2)
			{
				ertong=parseInt(ertong)+1;
			}
			if(document.getElementById("b"+h).value==3)
			{
				yinger=parseInt(yinger)+1;
			}
			sumbaoxian=sumbaoxian+parseInt(document.getElementById("h_insurance"+h).value);
		}
	}
	
	var hidPriceSin1=document.getElementById("hidPriceSin1").value;
	var hidYPriceSin1=document.getElementById("hidYPriceSin1").value;
	var hidairportFeeSin1=document.getElementById("hidairportFeeSin1").value;
	var hidfuelFeeSin1=document.getElementById("hidfuelFeeSin1").value;
	var hidtotalSin1=document.getElementById("hidtotalSin1").value;
	//儿童票面价
    var childpriceSingle1=Math.round(hidYPriceSin1*0.01)*100*0.5;//儿童票面价
    //儿童燃油费
    var childFuelSingle1= hidfuelFeeSin1/2; //儿童燃油费
    //婴儿票面价
    var babypriceSingle1=Math.round(hidYPriceSin1*0.01)*100*0.1;//婴儿票面价
    
    
	var hidPriceSin2=document.getElementById("hidPriceSin2").value;
	var hidYPriceSin2=document.getElementById("hidYPriceSin2").value;
	var hidairportFeeSin2=document.getElementById("hidairportFeeSin2").value;
	var hidfuelFeeSin2=document.getElementById("hidfuelFeeSin2").value;
	var hidtotalSin2=document.getElementById("hidtotalSin2").value;
	
	
	//儿童票面价
    var childpriceSingle2=Math.round(hidYPriceSin2*0.01)*100*0.5;//儿童票面价
    //儿童燃油费
    var childFuelSingle2=hidairportFeeSin2/2;//儿童燃油费
    //婴儿票面价
    var babypriceSingle2=Math.round(hidYPriceSin2*0.01)*100*0.1;//婴儿票面价
	
	
	var allprice=document.getElementById("allprice");
	var oneprice=document.getElementById("oneprice");
	var pricenum=document.getElementById("pricenum");
	pricenum.innerHTML=(chengren+ertong+yinger);
	oneprice.innerHTML=(parseFloat(hidtotalSin1)+parseFloat(hidtotalSin2));
	var postmenoy=0;
	if(GetRadioValue("postmoney")==3)
	{
		postmenoy=20;
	}
	allprice.innerHTML=(parseFloat(hidtotalSin1)+parseFloat(hidtotalSin2))*parseFloat(chengren)+(childpriceSingle1+childFuelSingle1+childpriceSingle2+childFuelSingle2)*parseInt(ertong)+(babypriceSingle1+babypriceSingle2)*parseInt(yinger)+postmenoy+sumbaoxian*20;
	
	var strTotalPriceOne=document.getElementById("strTotalPriceOne");
	var strTotalPriceTwo=document.getElementById("strTotalPriceTwo");
	strTotalPriceOne.value=(hidPriceSin1*parseFloat(chengren)+childpriceSingle1*parseFloat(ertong)+babypriceSingle1*parseFloat(yinger))+","+(hidfuelFeeSin1*parseFloat(chengren)+childFuelSingle2*parseFloat(ertong))+","+(hidairportFeeSin1*parseFloat(chengren));
	strTotalPriceTwo.value=(hidPriceSin2*parseFloat(chengren)+childpriceSingle2*parseFloat(ertong)+babypriceSingle2*parseFloat(yinger))+","+(hidfuelFeeSin2*parseFloat(chengren)+childFuelSingle2*parseFloat(ertong))+","+(hidairportFeeSin2*parseFloat(chengren));

	
	
	}	


function showdiag(id,state)
	{
		document.getElementById(id).style.display=state;
	}
//用来获取radio值 RValue=GetRadioValue("myradio");
function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}
add();
document.getElementById("a0").value="<ww:property value="getOrderUserLogin().membername"/>";
<ww:if test="getOrderUserLogin().cardtyp!=null&&getOrderUserLogin().cardtype.length>0">
document.getElementById("c0").value=<ww:property value="getOrderUserLogin().cardtype"/>;
</ww:if>
<ww:if test="getOrderUserLogin().cardnunber!=null&&getOrderUserLogin().cardnunber.length>0">
if(<ww:property value="getOrderUserLogin().cardtype"/>!=1)
{
document.getElementById("d0").className="validate[required]";
}
document.getElementById("d0").value="<ww:property value="getOrderUserLogin().cardnunber"/>";
</ww:if>
 function ltrim(s){  return s.replace( /^\s*/, "");  }  
 function rtrim(s){  return s.replace( /\s*$/, "");  }  
 function trim(s){  return rtrim(ltrim(s));  }  
 
 function formsubmit()
 {
 
	if(!$('#form1').validationEngine({returnIsValid:true}))
	{
		return false;
	}
 var h_name="";
 var h_type="";
 var h_idtype="";
 var h_idnumber="";
 var h_insurance="";
 for(var i=0;i<9;i++)
 {
 	if(i!=8)
 	{
 	h_name=h_name+document.getElementById("a"+i).value+",";
 	h_type=h_type+document.getElementById("b"+i).value+",";
 	h_idtype=h_idtype+document.getElementById("c"+i).value+",";
 	h_idnumber=h_idnumber+document.getElementById("d"+i).value+",";
 	h_insurance=h_insurance+document.getElementById("h_insurance"+i).value+",";
 	}
 	else
 	{
 	h_name=h_name+document.getElementById("a"+i).value;
 	h_type=h_type+document.getElementById("b"+i).value;
 	h_idtype=h_idtype+document.getElementById("c"+i).value;
 	h_idnumber=h_idnumber+document.getElementById("d"+i).value;
 	h_insurance=h_insurance+document.getElementById("h_insurance"+i).value;
 	}
 }
 var postmoney=GetRadioValue("postmoney");
 var paymethod=GetRadioValue("paymethod");
 var postname=document.getElementById("postname").value;
 var postmobile=document.getElementById("postmobile").value;
 var postcode=document.getElementById("postcode").value;
 var addresa=document.getElementById("addresa").value;
 var memo=document.getElementById("memo").value;
 
 var contactname=document.getElementById("lianxi1").value;
 var contactmobile=document.getElementById("shoujihao1").value;
 var contacttel=document.getElementById("dianhua1").value;
 var contactfax=document.getElementById("chuanzheng1").value;
 var notetype=document.getElementById("queren1").value;
 var paymethod=GetRadioValue("paymethod");
 document.getElementById("submitbutton").disabled="disabled";
 var pickonename=document.getElementById("pickonename").value;
 var pickonephone=document.getElementById("pickonephone").value;
 var memo=document.getElementById("txtmemo").value;
  dispose()
 $.post("ticketorder!add.action",{paymethod:paymethod,notetype:notetype,contactfax:contactfax,contacttel:contacttel,contactmobile:contactmobile,contactname:contactname,addresa:addresa,postcode:postcode,postmobile:postmobile,postname:postname,h_name:h_name,h_ptype:h_type,h_idtype:h_idtype,h_idnumber:h_idnumber,h_insurance:h_insurance,receipt:postmoney,paymethod:paymethod,pickonename:pickonename,pickonephone:pickonephone,memo:memo},function(data){
   colsedispose();
    if(data=="NOPNR")
    {
    	alert("PNR创建失败，请重试！");
    	document.getElementById("submitbutton").disabled="";
    }else
    {
    	window.location=data;
    }
   }
); 
 	
 }
</script>


<script>
$(document).ready(function(){
$("#cp_0").val("<ww:property value="customercredit.refid"/>");
});
function creditChange(index){
var ccid=$("#cp_"+index).val();
var typeid=$("#c"+index).val();
jQuery.post("airsearch!ajaxGetCredit.action",{cuid:ccid,type:typeid},function(data){
$("#d"+index).val(data);
});
}

</script>

