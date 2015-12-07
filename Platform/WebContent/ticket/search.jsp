<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机票查询</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="js/flightcity.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/j.dimensions.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript">
		 $(function(){
			$("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
		});
		function showBackDate()
        {
            var rdoSingle=document.getElementById("rdoSingle");
            var rdoBack=document.getElementById("rdoBack");
            var lblBackDate=document.getElementById("lblBackDate");
            var divBackDate=document.getElementById("divBackDate");
            if(rdoSingle.checked==true)
            {
                lblBackDate.style.display="none";
                divBackDate.style.display="none";
            }
            if(rdoBack.checked==true)
            {
                lblBackDate.style.display="block";
                divBackDate.style.display="block";
            }
        }
        function CheckData()
        {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
            var myDate = new Date();
				myDate.getFullYear(); //获取完整的年份(4位,1970-????)
				myDate.getMonth(); //获取当前月份(0-11,0代表1月)
				myDate.getDate(); //获取当前日(1-31)
				
			var DateNow=myDate.getFullYear()+"-"+myDate.getMonth()+1+'-'+myDate.getDate();
            if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
            {
                alert("返程时间不能为空！");
                return false;
            }
            if($("#arrcity").val()=="" || $("#city2").val()=="" || $("#txtStartDate").val()==""||$("#arrcity").val()=="中文/拼音"||$("#city2").val()=="中文/拼音")//中文/拼音
            {
                alert("其中 * 号信息为必填信息,请检查后重新填写！");
                return false;
            }
            else if(DateDiff(DateNow,$("#txtStartDate").val())>=365)
            { 
                alert("查询时间不能大于一年，请重新选择！");
			    $("#txtStartDate").focus();
			    return false;
            }
            else
            {
                
		            $("#t_aftersub").show();
			        $("#form1").hide();
                    $("#1").html("<div align='center' class='font_green_14'><br /><img src='images/loading.gif' width='70px' height='10px' /><br /><br /><br /></div>");
		      
                return true;
             }
            
        }
	</script>
</head>

<body onload="LoadCityData();">
<%
   //查询日期时间范围
   //1、现有月份小于等于3月的时候，查询现有月份+3的航班
   //2、现有月份大于等于4月小于等于7月，可查询至10月；
   //3、现有月份大于等于8月小于等于10月，可查询现有月份+3的月份；
   //4、现有月份大于10月，查询至下一年3月的航班。
   String strMaxDate="";
   

   
    
%>
<form action="airsearch!tSearch.action" name="form3" id="form3"
	method="POST" onSubmit="return CheckData()">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="760" border="1" align="center" cellpadding="0"
							cellspacing="0" style="font-size: 12px; border-collapse: collapse; margin-top: 20px;" bordercolor="#a0cfee">

							<tr class="font-blue-xi">
								<td width="184" height="28" align="right" style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity">出发城市：</label></div></td>
								<td width="198" align="left"><input style="border: 1px solid #999999;height:20px; line-height:20px;" type="text"
									name="StartAirPortName" id="arrcity" value="南京" onfocus="if(this.value='南京'){this.value='';}" onblur="if(this.value=='') {this.value='南京';}"/>&nbsp;<span
									style="color: red">*</span>
								<div id='suggest' class="ac_results"></div>
								<input type="hidden" id="city_from_hide" value="NKG" name="StartAirportCode" />
								</td>
								<td width="129" height="28" align="right" style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2"> 目的城市：</label></div></td>
								<td width="181" align="left"><input style="border: 1px solid #999999; height:20px; line-height:20px;" type="text"
									name="EndAirPortName" id="tocity" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2' class="ac_results"></div>
								<input type="hidden" id="city_to_hide" name="EndAirportCode" />
								</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div></td>
								<td align="left"><input id="txtStartDate"
									style="width: 150px" name="FromDate"
									onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d',maxDate:'<%=strMaxDate %>'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>
								<td height="28" align="right" style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;"><span style="display: none"
									id="lblBackDate">返程日期：</span></div></td>
								<td align="left">
								<div id="divBackDate" style="display: none"><input
									id="txtBackDate" style="width: 150px" name="BackDate"
									onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d',maxDate:'<%=strMaxDate %>'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></div>
								</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;">航空公司：</div></td>
								<td><select id="ddlAirCom" name="AirCompanyCode"
									style="width: 152px; border: 1px solid #999999">
									<option value="">---请选择航空公司---</option>
									<ww:iterator value="listAircompany">
										<option value="<ww:property value='aircomcode' />"><ww:property
											value="aircomcode" /> <ww:property value="aircomcnname" /></option>
									</ww:iterator>
								</select></td>
								<td height="28" align="right"  style="padding: 0" ><div style="background: #d7e9fc; height:28px; margin: 1px 0 0 1px; width: 100%;">航程类型：</div></td>
								<td align="left"><input name="TravelType" id="rdoSingle"
									type="radio" checked="checked" value="1"
									onclick="showBackDate();" />单程&nbsp;<input name="TravelType"
									type="radio" value="2" id="rdoBack" onclick="showBackDate();" />往返
								</td>
								
								
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="20px"></td>
					</tr>
					<tr>
						<td align="center"><input type="submit"
							style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" /></td>
					</tr>
					<tr>
						<td>
						<table>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style="color: Red">注意事项:</span></strong></td>
							</tr>
							<tr>
								<td>
								<ul>
									<li id="li1" style="list-style: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="Label1">此处结算价仅供参考，实际价格以订单支付页面为准！</span></li>
								</ul>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td><br />
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</form>
<table id="t_aftersub" style="display: none" width="100%" border="0"
	bgcolor="#f2f9f3" height="800px" align="center" cellpadding="0"
	cellspacing="0">
	<tr valign="top">
		<td>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">

			<tr>
				<td rowspan="4">&nbsp;</td>
				<td height="77" colspan="2" bgcolor="#f2f9f3" align="center">
				<p class="font_green_14 STYLE1">&nbsp;</p>
				<p class="font_green_14 STYLE1"><strong>正在为您实时查询航班信息,请稍等！</strong></p>
				<p></p>
				<div id="1"></div>
				</td>
				<td rowspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#f2f9f3" align="center"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>


