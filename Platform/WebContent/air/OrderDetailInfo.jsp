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
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script>




   function rTPnr()
    {
       $("#pnrinfo").show();
       $.ajax({
            type:"POST",
            url:"orderinfo!rtPNRinfo.action",
            data:{strPNR:$("#txtpnrcode").val()},
            beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在加载PNR信息.....</b></font>");},             
            success:function(data){
            $("#pnrinfo").html(data);           
            }            
            });
       
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
     function goEdit4(url)
     
    {
    	
    	if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit5(url)
    {
    	
       if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit6(url)
    {
    
     if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit2(url)
    {
   	 	var temp = confirm('请确认已在黑屏出票');
			if(temp==true){
			window.location.href=url;
		}
    }
    
     function bbb(url)
    {
   		aaa();
    
       window.location.href=url;
    }
    
  function aaa()
    {
    
    
  var ticketnum = document.getElementsByName("ticketnum");
  var fet = document.getElementsByName("fet");
  var ei = document.getElementsByName("ei");
  var pid = document.getElementsByName("pid");
  
  
   if(document.all("ticketnum").value == "") 
{ 
	alert("票号不能为空！"); 
	document.all("ticketnum").focus(); 
	return false; 
	} 


if(document.all("fet").value == "") 
{ 
	alert("行程单不能为空！"); 
	document.all("fet").focus(); 
	return false; 
	} 


if(document.all("ei").value == "") 
{ 
	alert("ei不能为空！"); 
	document.all("ei").focus(); 
	return false; 
	} 

  
  

  var ticketStr = "";
   var fetStr = "";
    var eiStr = "";
    var ppid = "";


for(var i=0;i<ticketnum.length;i++)
{
 ticketStr += ticketnum[i].value + ",";
}
 for(var i=0;i<fet.length;i++)
{
 fetStr += fet[i].value + ",";
}
  for(var i=0;i<ei.length;i++)
{
 eiStr += ei[i].value + ",";
}   
  for(var i=0;i<pid.length;i++)
{
 ppid += pid[i].value + ",";
}   
    
  $.post("passenger!addpassenger.action",{'ticketnum':ticketStr,'fet':fetStr,'ei':eiStr,'pid':ppid},
				function(str1)
					{
						if(str1=="valiError")
						{
							$("#confirm").html("用户名密码错误！！！");
							document.getElementById('checkvalidate1').src = "validate?timetramp=" + new Date().getTime() ;
						}
					}
				);
   return;
   
  
    document.form1.submit();
    }
	</script>
</head>
<body>
<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;订单详细信息</b></td>
	</tr>
</table>

<div class="base_b base_bgcolor02">

<div class="flt_silhouette" cdm="blk_ticketinfo"><span
	class="flt_shadow_t"></span><span class="flt_shadow_m">
<div class="flt_shadow_content">
<ww:if test="orderinfo.orderstatus==1">
<div style="background: #fff;">
<ul class="base_mainbox02 layoutfix" >
<li >
	<h3  class="base_miantitle">立即支付票款<span class="base_annotate"></span></h3>
	</li>
	</ul>

	<ww:include page="../pay.jsp?ordernum=<ww:property value='orderinfo.ordernumber' />" ></ww:include>
	
	<div style="height: 15px; clear: both;"></div>
	</ww:if>
</div>

<div style="height: 20px;"></div>
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
				<tr height="5px">
					<td></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.ordernumber" /></td>
					<td class="table_color_r colortrin" width="10%">关联订单号：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.relationorderid==null">无</ww:if> <ww:else>
						<a
							href="orderinfo!toshow.action?id=<ww:property value="orderinfo.relationorderid" />"><ww:property
							value="orderinfo.relationorderid" /></a>
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">PNR编码：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.pnr==null">无</ww:if> <ww:else>
						<ww:property value="orderinfo.pnr" />&nbsp;&nbsp;<input id="txtpnrcode" type="hidden" value="<ww:property value="orderinfo.pnr" />" /><a href="#"
							style="font-weight: bold; color: #22763f" onclick="rTPnr();"><img
							src="images/i.gif" border="0" />PNR提取</a>
					</ww:else></td>

					<td class="table_color_r colortrin" width="10%">订单状态：</td>
					<td class="table_color_l" width="15%"><span
						style="color: red; font-weight: bold;"><ww:property
						value="getStateToString(orderinfo.orderstatus)" /></span></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">支付方式：</td>
					<td class="table_color_l" width="15%">
					<ww:if test="orderinfo.paymethod==1">网上付款</ww:if>
					<ww:if test="orderinfo.paymethod==2">门市付款</ww:if>
					<ww:if test="orderinfo.paymethod==3">票到付款</ww:if></td>
					<td class="table_color_r colortrin" width="10%">支付状态：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="getPayMethod(orderinfo.paystatus)" /></td>
					<td class="table_color_r colortrin" width="10%">创建日期：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.createtime)" /></td>
					<td class="table_color_r colortrin" width="10%">出票时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">支付时间：</td>
					<td class="table_color_l" width="15%">
					<!--<ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else>
					-->
					 <ww:property value="formatTimestamp(getzhifutime(orderinfo.ordernumber))" />
					</td>
					<td class="table_color_r colortrin" width="10%">取消时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">申请退废:</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">退款时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">大PNR：</td>
					<td class="table_color_l" width="15%">
					<ww:if
						test="orderinfo.bigpnr==null">无</ww:if> 
						<ww:else>
					    <ww:property
						value="orderinfo.bigpnr" />
						</ww:else></td>
					<td class="table_color_r colortrin" width="10%">分销商名称：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="getagentname_b2bback(orderinfo.buyagentid)" /></td>
					<td class="table_color_r colortrin" width="10%"></td>
					<td class="table_color_l" width="15%">&nbsp;</td>
					<td class="table_color_r colortrin" width="10%">&nbsp;</td>
					<td class="table_color_l" width="15%">
						&nbsp;
					</td>
				</tr>
				<tr height='1px'>
					<td colspan='9'></td>
				</tr>
				<tr>
					<td align="left" colspan="9">
					<div id="pnrinfo"
						style="display: none; background-color: Black; color: #00ff00; height: 123px; width: 100%; margin: 0 auto; overflow: auto;">
					</div>
					</td>
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
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>航空公司</td>
						<td>航班号</td>
						<td>起飞城市</td>
						<td>到达城市</td>
						<td>起飞时间</td>
						<td>到达时间</td>
						<td>舱位</td>
						<td>折扣</td>
						<td>票面价</td>
						<td><span style="color: red; font-weight: bold;">返点</span></td>
						<td>票面结算价</td>
					</tr>
					<ww:iterator value="listSegment">
						<tr class='postbg1' align="center" valign="middle">
							<td><img
								src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
								border="0" /><ww:property
								value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
							<td><ww:property value="flightnumber" /></td>
							<td><ww:property value="getCitynameByAirport(startairport)" /></td>
							<td><ww:property value="getCitynameByAirport(endairport)" /></td>
							<td><ww:property value="formatTimestamp(departtime)" /></td>
							<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
							<td><ww:property value="cabincode" /></td>
							<td><ww:property value="discount" /></td>
							<td style="color: red;">
							<ww:if test="parvalue==null">
							<ww:property value="price" />
							</ww:if><ww:else>
							<ww:property value="parvalue" />
							</ww:else>
							
							</td>
							<td style="color: red; font-weight: bold; font-size: 18px">
							<ww:if test="ratevalue==nuil">
							0.0
							</ww:if><ww:else>
							<ww:property value="orderinfo.fenxiaoshangfandian" />
							</ww:else>
								
								%</td>
							<td style="color: red;">
							<ww:property value="price" /></td>
						</tr>
					</ww:iterator>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>
</div>
</div>
</span><span class="flt_shadow_f"></span></div>

<ww:if test="orderinfo.orderstatus==3">
	<ul class="base_mainbox02 layoutfix">
		<li>
		<h3 class="base_miantitle">乘机人信息<span class="base_annotate"></span></h3>
		</li>
		<form action="passenger!addpassenger.action" name="form1"
			method="post">
		<table class="book_pgcontent" width="100%">
			<tr>
				<td align="center">
				<table class="book_pgcontent" width="98%" border=1 cellspacing=0
					bordercolorlight=#a0cfee style="border-right: 1px solid #a0cfee"
					bordercolordark=white cellpadding=0
					style="border: 1px solid #a0cfee">
					<tbody>
						<tr class='GridViewHeaderStyle'
							style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
							<td>乘客类型</td>
							<td>乘客姓名</td>
							<td>证件类型</td>
							<td>证件号码</td>
							<td>票价</td>
							<td>燃油</td>
							<td>机建</td>
							<td>票号</td>
							<td>行程单</td>
							<td>EI</td>
						</tr>
						<ww:iterator value="listPassenger">
							<tr class='postbg1' align="center" valign="middle">

								<td><ww:property value="getPassTypeToString(ptype)" /></td>
								<td><ww:property value="name" /></td>
								<td><ww:property value="getIDTypeToString(idtype)" /></td>
								<td><span id="gdvTic_ctl02_lbtnzj"><ww:property
									value="idnumber" /></span></td>
								<td><ww:property value="formatMoney(price)" /></td>
								<td><ww:property value="formatMoney(fuelprice)" /></td>
								<td><ww:property value="formatMoney(airportfee)" /></td>
								<td><input type="text" name="ticketnum" id="ticketnum"
									value="<ww:property value="ticketnum" />" /></td>
								<td><input type="text" name="fet" id="fet"
									value="<ww:property value="fet" />" /><input type="hidden"
									name="pid" id="pid" value="<ww:property value="id" />" /></td>
								<td><ww:property value="ei" /><select name="ei" id="ei">
									<option value="">--请选择--</option>
									<option value="不得签转"
										<ww:if test="ei==\"不得签转\"">selected</ww:if>>不得签转</option>
									<option value="不得签转-变更"
										<ww:if test="ei==\"不得签转-变更\"">selected</ww:if>>不得签转、变更</option>
									<option value="不得退票"
										<ww:if test="ei==\"不得退票\"">selected</ww:if>>不得退票</option>
									<option value="不得签转-变更-退票"
										<ww:if test="ei==\"不得签转-变更-退票\"">selected</ww:if>>不得签转、变更、退票</option>
									<option value="全价票" <ww:if test="ei==\"全价票\"">selected</ww:if>>全价票</option>
									<option value="退票收取5％的费用"
										<ww:if test="ei==\"退票收取5％的费用\"">selected</ww:if>>退票收取5％的费用</option>
									<option value="不得签转-退票收费"
										<ww:if test="ei==\"不得签转-退票收费\"">selected</ww:if>>不得签转、退票收费</option>
									<option value="不得签转-变更-退票收费"
										<ww:if test="ei==\"不得签转-变更-退票收费\"">selected</ww:if>>不得签转、变更、退票收费</option>

								</select></td>
							</tr>
						</ww:iterator>
						<tr height='1px'>
							<td colspan='9'><br />
							</td>
						</tr>
					</tbody>
				</table>
				<br />
				</td>
			</tr>

		</table>
		</form>

	</ul>
</ww:if><ww:else>
	<ul class="base_mainbox02 layoutfix">
		<li>
		<h3 class="base_miantitle">乘机人信息<span class="base_annotate"></span></h3>
		</li>
		<table class="book_pgcontent" width="100%">
			<tr>
				<td align="center">
				<table class="book_pgcontent" width="98%" border=1 cellspacing=0
					bordercolorlight=#a0cfee bordercolordark=white cellpadding=0
					style="border: 1px solid #a0cfee">
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
					</tbody>
				</table>
				<br />
				</td>
			</tr>
		</table>
	</ul>
</ww:else>


<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">票款信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border=1 cellspacing=0
				bordercolorlight=#a0cfee bordercolordark=white cellpadding=0>
				<tbody>
					<tr class='GridViewHeaderStyle'
						style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
						<td>总票价</td>
						<td>总燃油费</td>
						<td>总机建费</td>
						<td>邮寄费</td>
						<td>保险费</td>
						<td>应付款</td>

					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:property
							value="formatMoney(orderinfo.totalticketprice)" /></td>
						<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalairportfee)" /></td>
						<td><ww:property value="formatMoney(orderinfo.postmoney)" /></td>
						<td><ww:property
							value="formatMoney(getsuminsurance(orderinfo.insurance))" /></td>
						<td><span style="color: red; font-weight: bold"><ww:property
							value="formatMoney(orderinfo.postmoney+orderinfo.totalticketprice+orderinfo.totalairportfee+orderinfo.totalfuelfee+getsuminsurance(orderinfo.insurance))" /></span></td>
					</tr>


				</tbody>
			</table>
			<table width="98%" border=0 cellspacing=0 cellpadding=0>
				<tr height="10px">
					<td></td>
				</tr>
				<tr>
					<td>
					<ww:if test="orderinfo.orderstatus!=6">
							<input type="button" class="button108" id="btnRRTicket"
						value="取消订单"
						onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=6',<ww:property value="id" />)" />
					</ww:if> 
					
					<!--  <ww:if test="orderinfo.orderstatus==1">
						<input type="button" class="button108" id="btnCancel" value="立即支付"
							onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=2',<ww:property value="id" />)" />
							
					</ww:if> --> 
					
					 <ww:elseif test="orderinfo.orderstatus==3">
						<input type="button" class="button108" id="btnRRTicket"
							value="申请废票"
							onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=5',<ww:property value="id" />)" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="button108" id="btnRRTicket"
							value="申请退票"
							onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=4',<ww:property value="id" />)" />
						&nbsp;&nbsp;&nbsp;&nbsp;

						<input type="button" class="button108" id="btnRRTicket"
							value="申请改签"
							onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=13',<ww:property value="id" />)" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="scang!toadd.action?orderinfoid=<ww:property value="id" />">申请升舱</a><br/>
					</ww:elseif> 
					
					<input type="button" class="button108" id="btnRRTicket"
						value="返回"
						onclick="history.go(-1)" />
					
					<br />
					</td>
				</tr>
			</table>
			<br />
			</td>
		</tr>


	</table>

	
</ul>
</div>
</body>
</html>