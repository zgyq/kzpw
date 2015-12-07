
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>信息单打印</title>
<style type="text/css">
.btn {
	border-right: #7b9ebd 1px solid;
	padding-right: 2px;
	border-top: #7b9ebd 1px solid;
	padding-left: 2px;
	font-size: 12px;
	filter: progid :   dximagetransform .   microsoft . 
		
		gradient(gradienttype =   0, startcolorstr =   #ffffff, endcolorstr = 
		 #cecfde);
	border-left: #7b9ebd 1px solid;
	cursor: hand;
	color: black;
	padding-top: 2px;
	border-bottom: #7b9ebd 1px solid
}

.back_southidc {
	BACKGROUND-IMAGE: url(images/titlebg.gif);
	COLOR: #000000
}

.table_southidc {
	BACKGROUND-COLOR: #a4b6d7
}

.td_southidc {
	BACKGROUND-COLOR: #f2f8ff
}

.tr_southidc {
	BACKGROUND-COLOR: #ecf5ff
}

.t1 {
	FONT: 12px 宋体;
	COLOR: #000000
}

.t2 {
	FONT: 12px 宋体;
	COLOR: #ffffff
}

.t3 {
	FONT: 12px 宋体;
	COLOR: #ffff00
}

.t4 {
	FONT: 12px 宋体;
	COLOR: #800000
}

.t5 {
	FONT: 12px 宋体;
	COLOR: #191970
}

.weiqun:hover {
	COLOR: #ffffff;
	FONT-FAMILY: "宋体";
	BACKGROUND-COLOR: #cccccc;
	TEXT-DECORATION: underline;
	Font-unline: yes
}

td {
	FONT-SIZE: 12px
}

A:link {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:active {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: #000000;
	TEXT-DECORATION: none
}

.xcd {
	background-image: url(image/xcbg.jpg);
	background-repeat: no-repeat;
	height: 308px;
	width: 770px;
	margin-left: 15px;
}

#tj_bnt {
	margin-left: 450px;
	margin-top: 40px;
}

.STYLE1 {
	color: #FF0000
}

.STYLE2 {
	font-size: 14px;
	font-weight: bold;
}

body {
	padding-top: 0px;
	padding-left: 0px;
	padding-right: 0px;
	padding-bottom: 0px;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

input {
	border: 1px solid #ccc;
	background: none;
}
</style>
<meta content="MSHTML 6.00.3790.1830" name="GENERATOR" />
</head>



<script type="text/javascript"> 
 
</script>

<body style="margin-left: auto; margin-right: auto;">

<div><input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET"
	value="" /> <input type="hidden" name="__EVENTARGUMENT"
	id="__EVENTARGUMENT" value="" /> <input type="hidden"
	name="__LASTFOCUS" id="__LASTFOCUS" value="" /> <input type="hidden"
	name="__VIEWSTATE" id="__VIEWSTATE"
	value="/wEPDwUKLTEzOTAzNDMyMg9kFgICAQ9kFgICBw8QZGQWAGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgIFC2J0bl9wbnJfaW9rBQxJbWFnZUJ1dHRvbjGx1RO4q83NRJqcFStjxOD2wCjLjA==" />
</div>

<script type="text/javascript"> 

</script>

<!--startprint-->
<table width="780" align="center" border="0" cellspacing="0"
	cellpadding="0">
	<!--
            <tr style="height: 29px">
                <td style="height: 24px; width: 781px;">
                    <table style="height: 29px" align="center">
                        <tr>
                            <td align="right" style="height: 50px; width: 22%;">
                                <img src="image/xcddy_03.gif" alt="" />
                            </td>
                            <td align="right" style="height: 50px; width: 13%;">
                                PNR编码/票号：</td>
                            <td class="back_southidc colSpan=6" align="left" style="background-repeat: repeat-x;
                                color: #ff6600; height: 50px;">
                                <input name="txtBox_pnr_into" type="text" id="txtBox_pnr_into" /></td>
                            <td>
                                <div style="width: auto; text-align: left">
                                    <input type="image" name="btn_pnr_iok" id="btn_pnr_iok" src="image/daoru.gif" onclick="return CheckPNR();" style="border-width:0px;" />
                                </div>
                            </td>
                            <td width="34%" style="height: 50px">
                                <span class="STYLE1">*将您要打印的行程的PNR或票号导入即可(PNR必须在本平台存在,票号可在本平台不存在)</span><span id="lab_fly_news"></span></td>
                        </tr>
                    </table>
                </td>
            </tr>
            -->
	<tr>
		<td style="height: 17px; width: 781px;">
		<table width="100%" align="center">
			<tbody>
				<tr>
					<td style="height: 30px">&nbsp;</td>
					<td style="height: 30px">
					<table>
						<tr>
							<td align="center" style="height: 16px"><span class="STYLE2">航空运输电子客票信息单</span>
							&nbsp;</td>
						</tr>
					</table>
					</td>
					<td style="height: 30px">&nbsp;</td>
				</tr>
			</tbody>
		</table>
		</td>
	</tr>
</table>
<table align="center">
	<tr>
		<td align="center" style="width: 851px">
		<div class="xcd"
			style="height: 294px; text-align: center; float: inherit">
		<table cellspacing="0" cellpadding="0" width="680" border="0"
			style="height: 234px" align="center">
			<tbody>
				<tr>
					<td style="height: 51px; width: 680px; padding-left: 40px;"
						align="center">
					<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr>
								<td width="323" align="right" style="height: 58px">旅客姓名 <!--<td align=left width=70 style="height: 58px">-->
								<!-- 如果不是本系统的PNR，启用文本框，手动输入--> <input name="Text43" type="text"
									id="Text43" class="input2" style="width: 55px"
									value="<ww:property value="passenger.name" />" /></td>
								<!--</td>-->
								<td align="right" width="254" style="height: 58px">有效证件</td>
								<td style="height: 58px"><input name="tboxpno" type="text"
									value="<ww:property value="passenger.idnumber" />" id="tboxpno"
									style="width: 200px" /></td>
								<td width="323" style="height: 58px">签注<select
									name="drop_tgq" id="drop_tgq" style="background-color: White;">
									<option value=""></option>
									<option value="不得签转">不得签转</option>
									<option value="不得签转不得退票">不得签转不得退票</option>
									<option value="不得变更不得签转">不得变更不得签转</option>
									<option value="不得签转变更退票">不得签转变更退票</option>
									<option value="不得更改不得签转不得退票">不得更改不得签转不得退票</option>
									<option selected="selected" value="签转手续费原出票地退票">签转手续费原出票地退票</option>

								</select></td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
				<tr>
					<td style="width: 680px">
					<table cellspacing="0" cellpadding="0" align="left" border="0">
						<tbody>
							<tr>
								<td align="right" height="30" style="width: 96px">
								&nbsp;PNR编号：</td>
								<td width="506" colspan="10"><input name="txt_pnr"
									type="text" id="txt_pnr" style="width: 60px"
									value="<ww:property value="orderinfo.pnr" />" /></td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
				<tr>
					<td style="height: 140px; width: 680px; padding-left: 28px;"
						align="center">
					<table cellspacing="0" cellpadding="0" align="left" border="0">
						<tbody>
							<tr>
								<td align="left" style="width: 80px; height: 13px;">航段</td>
								<td align="left" style="width: 60px; height: 13px;">承运人</td>
								<td align="left" style="width: 80px; height: 13px;">航班号</td>
								<td align="center" style="width: 40px; height: 13px">舱位</td>
								<td align="center" style="width: 100px; height: 13px">日期</td>
								<td align="center" style="width: 60px; height: 13px;">时间</td>
								<td align="center" style="width: 65px; height: 13px;">客票级别</td>
								<td align="center" style="width: 65px; height: 13px;">生效日期</td>
								<td align="center" style="width: 65px; height: 13px;">截至日期</td>
								<td align="center" style="width: 65px; height: 13px">免费行李</td>
							</tr>
							<tr>
								<td valign="top"><input name="txt_SCity_ZW" type="text"
									value="<ww:property value="getAirnamebySZM(segmentinfo.startairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.startairport" />"
									id="txt_SCity_ZW" class="input2" style="width: 70px;"
									title="单程的开始城市中文，往返联程的开始城市中文" /> <br />
								<input name="txt_CCity_ZW" type="text" id="txt_CCity_ZW"
									value="<ww:property value="getAirnamebySZM(segmentinfo.endairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.endairport" />"
									class="input2" style="width: 70px;" title="往返联程的中转城市中文" /> <input
									name="txt_ECity_ZW" type="text" id="txt_ECity_ZW"
									class="input2" style="width: 70px;" title="目的城市中文" /></td>


								<td valign="top"><input name="txt_HKGS1" type="text"
									value="<ww:property value="getAircomapnycodeByEZM(segmentinfo.aircomapnycode)" />"
									id="txt_HKGS1" class="input2" style="width: 40px" /> <input
									name="txt_HKGS2" type="text" id="txt_HKGS2" class="input2"
									style="width: 40px" /> <input name="Text36" type="text"
									id="Text36" class="input2"
									style="width: 40px; border-top-style: dotted; border-top-color: aliceblue; border-right-style: none; border-left-style: none; border-bottom-style: none;" />
								</td>
								<td valign="top"><input name="txt_HBH1" type="text" value="<ww:property value="segmentinfo.flightnumber" />"
									id="txt_HBH1" class="input2" style="width: 60px" /> <input
									name="txt_HBH2" type="text" id="txt_HBH2" class="input2"
									style="width: 60px" /> <input name="Text15" type="text"
									id="Text15" class="input2" style="width: 60px" value="VOID" />
								</td>
								<td valign="top" align="center"><input name="txt_CW1" value="<ww:property value="segmentinfo.cabincode" />"
									type="text" id="txt_CW1" class="input2" style="width: 20px" />
								<br />
								<input name="txt_CW2" type="text" id="txt_CW2" class="input2"
									style="width: 20px" /> <br />
								<input name="Text37" type="text" id="Text37" class="input2"
									style="width: 20px; border-top-style: dotted; border-top-color: aliceblue; border-right-style: none; border-left-style: none; border-bottom-style: none;" />
								</td>
								
								<td valign="top" align="center"><input name="txt_Date1" value="<ww:property value="formatDate(segmentinfo.departtime)" />"
									type="text" id="txt_Date1" class="input2" style="width: 85px" />
								<br />
								<input name="txt_Date2" type="text" id="txt_Date2"
									class="input2" style="width: 85px" /> <br />
								<input name="Text38" type="text" id="Text38" class="input2"
									style="width: 85px; border-top-style: dotted; border-top-color: aliceblue; border-right-style: none; border-left-style: none; border-bottom-style: none;" />
								</td>
								<td valign="top" align="center"><input name="txt_Time1" value="<ww:property value="formatTimestamp3(segmentinfo.departtime)" />"
									type="text" id="txt_Time1" class="input2" style="width: 40px" />
								<br />
								<input name="txt_Time2" type="text" id="txt_Time2"
									class="input2" style="width: 40px" /> <br />
								<input name="Text40" type="text" id="Text40" class="input2"
									style="width: 40px; border-top-style: dotted; border-top-color: aliceblue; border-right-style: none; border-left-style: none; border-bottom-style: none;" />
								</td>
								<td valign="top" align="center"><input name="txt_KPJB1"
									type="text" id="txt_KPJB1" class="input2" style="width: 50px" />
								<br />
								<input name="txt_KPJB2" type="text" id="txt_KPJB2"
									class="input2" style="width: 50px" /></td>
								<td valign="top" align="center"><input name="txt_SXRQ1"
									type="text" id="txt_SXRQ1" class="input2" style="width: 50px" />
								<br />
								<input name="txt_SXRQ2" type="text" id="txt_SXRQ2"
									class="input2" style="width: 50px" /></td>
								<td valign="top" align="center"><input name="txt_JZRQ1"
									type="text" id="txt_JZRQ1" class="input2" style="width: 50px" />
								<br />
								<input name="txt_JZRQ2" type="text" id="txt_JZRQ2"
									class="input2" style="width: 50px" /></td>
								<td valign="top" align="center"><input name="txt_MFXL1"
									type="text" id="txt_MFXL1" class="input2" style="width: 20px"
									value="20" /><span id="k">K</span> <br />
								<input name="txt_MFXL2" type="text" id="txt_MFXL2"
									class="input2" style="width: 20px;" value="20" /><span id="k1">K</span><br />
								<input name="Text42" type="text" id="Text42" class="input2"
									style="width: 20px; border-top-style: dotted; border-top-color: aliceblue; border-right-style: none; border-left-style: none; border-bottom-style: none;" /></td>
							</tr>
							<tr>
								<td style="width: 80px; height: 30px;" valign="top"><input
									name="Text16" type="text" id="Text16" class="input2"
									style="width: 70px" value="  VOID" /></td>
								<td colspan="9" style="height: 30px;"></td>
							</tr>
							<tr>
								<td colspan="10">
								<table cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td style="height: 30px; width: 115px; text-align: right;">
										票价</td>
										<td style="height: 30px; width: 90px;">
										<ww:if test="passenger.ptype==1">
										<input
											name="txt_PJ" type="text" id="txt_PJ" class="input2"
											maxlength="7" size="7" style="text-align: right;" value="<ww:property value="segmentinfo.parvalue" />" />
											</ww:if><ww:else>
										<input
											name="txt_PJ" type="text" id="txt_PJ" class="input2"
											maxlength="7" size="7" style="text-align: right;" value="<ww:property value="passenger.price" />" />	
											</ww:else>
											
											</td>
										<td style="height: 30px; width: 55px; text-align: right;">
										机建</td>
										<td style="height: 30px; width: 90px;"><input
											name="txt_JJ" type="text" id="txt_JJ" class="input2"
											maxlength="6" size="6" style="text-align: right;" value="<ww:property value="passenger.airportfee" />" /></td>
										<td style="height: 30px; width: 65px; text-align: right;">
										燃油费</td>
										<td style="height: 30px; width: 90px;"><input
											name="txt_RY" type="text" id="txt_RY" class="input2"
											maxlength="6" size="6" style="text-align: right;" value="<ww:property value="passenger.fuelprice" />" /></td>
										<td style="height: 30px; width: 30px;"></td>
										<td style="height: 30px; width: 55px; text-align: right;">
										合计</td>
										<td style="height: 30px; width: 90px;"><input
											name="txt_HJ" type="text" id="txt_HJ" class="input2"
											maxlength="7" size="7" style="text-align: right;" value="<ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+segmentinfo.parvalue+converNull(passenger.insurprice,0))" />" /></td>
									</tr>
								</table>
								</td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
				<tr>
					<td style="height: 100px; width: 680px; padding-left: 28px;"
						align="center">
					<table cellspacing="0" cellpadding="0" align="left" border="0"
						style="height: 99px">
						<tbody>
							<tr>
								<td width="12%" align="right">电子客票号码&nbsp;</td>
								<td style="width: 146px"><input name="txt_PH" type="text" value="<ww:property value="passenger.ticketnum" />"
									id="txt_PH" class="input2" style="width: 100px" /></td>
								<td colspan="2" align="center">信息单号 <input name="txt_XCD"
									type="text" id="txt_XCD" class="input2" style="width: 78px" />
								</td>
								<td width="10%" align="right">保险 <select name="drop_bxf"
									id="drop_bxf" style="width: 0px;">
									<option selected="selected" value="<ww:property value="passenger.insurprice" />"></option>
									<option value="20.00">20.00</option>

								</select></td>
								<td width="12%"><input name="Text27" type="text"
									id="Text27" class="input2" style="width: 40px" value="<ww:property value="passenger.insurprice" />" /></td>
								<td width="6%" align="left"></td>
							</tr>
							<tr>
								<td width="12%" align="right" style="height: 30px">
								<table border="0" cellpadding="0" cellspacing="0"
									style="height: 30px">
									<tr>
										<td align="right" style="width: 87px; height: 18px">
										销售单位代号&nbsp;</td>
									</tr>
									<tr>
										<td align="right" style="width: 87px; height: 18px;">
										代理号码&nbsp;</td>
									</tr>
								</table>
								</td>
								<td width="18%" style="height: 40px">
								<table border="0" cellpadding="0" cellspacing="0"
									style="height: 48px">
									<tr>
										<td align="right" style="width: 87px; height: 18px"><input
											name="txt_Office" type="text" id="txt_Office"
											style="width: 80px" />&nbsp;</td>
									</tr>
									<tr>
										<td align="right" style="width: 87px; height: 18px"><input
											name="txt_DLBH" type="text" id="txt_DLBH" style="width: 80px" />&nbsp;</td>
									</tr>
								</table>
								</td>
								<td colspan="2" align="center" style="height: 40px"><span
									id="showcheckmessage" style="color: Red; font-size: 12px;"></span><br />
								填开单位 <input name="txt_TKDW" type="text" id="txt_TKDW"
									style="width: 143px" /></td>
								<td width="10%" align="right" style="height: 40px">
								填开日期&nbsp;</td>
								<td colspan="2" style="height: 40px"><input name="txt_TKRQ"
									type="text" id="txt_TKRQ" style="width: 90px" /></td>
							</tr>


						</tbody>
					</table>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		</td>
	</tr>
</table>
<!--endprint-->
<table align="center">
	<tr align="center">
		<td style="height: 45px"></td>
		<td style="width: 146px; height: 45px;"></td>
		<td align="center" colspan="2" style="height: 45px" valign="bottom"><input
			type="button" name="Submit" value="打印"
			onClick="HentPrint('<ww:property value="pid" />','<ww:property value="username" />');"
			style="cursor: pointer" /></td>
		<td align="right" style="height: 41px"></td>
		<td style="height: 41px"></td>
	</tr>

</table>

</body>
</html>
<script src="js/jquery1.3.2.js"></script>
<script language="javascript">

function HentPrint(pid,username)
{ 


bdhtml=window.document.body.innerHTML; 
sprnstr="<!--startprint-->"; 
eprnstr="<!--endprint-->"; 
prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
window.document.body.innerHTML=prnhtml; /* 可以prnhtml前加上 <style><!-- p{font-size:12px;} --></style> */
window.print(); 
}



function isvalue(pid,username){

	$.ajax({
	   url:"passenger!ajaxgetpassenger.action",
	   type:"POST",
	   async:false,
	   data:{passid:pid,username:username},
	   success:function (data){
	      
	  }	
  });

}

</script>
