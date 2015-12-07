<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/flightcity_hotel.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/j.dimensions.js"></script>

<script language="javascript">
 	$(function(){
			$("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide', attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
		    $("#imgloading").html("<img src='<%=request.getContextPath()%>/images/13221819.gif' width='208' height='13' style='padding-top:10px'/> ");
		    $("#arrcity").val('<ww:property value="getAirportCityName(flightSearch.StartAirportCode)"/>');
		    $("#tocity").val('<ww:property value="getAirportCityName(flightSearch.EndAirportCode)"/>');
		    $("#city_from_hide").val('<ww:property value="flightSearch.StartAirportCode"/>');
		    $("#city_to_hide").val('<ww:property value="flightSearch.EndAirportCode"/>');
	});
	
function qiehuan(p){
//alert("p=="+p);
if(p==2){
	document.getElementById("suggest").innerHTML="";
	document.getElementById("guojia").value=2;
	commoncitys.length=0;
	citys.length=0;
	LoadCityData(2);
	
 	}
if(p==1){
	document.getElementById("suggest").innerHTML="";
	document.getElementById("guojia").value=1;
	commoncitys.length=0;
	citys.length=0;
	LoadCityData(1);
 	
}
} 		
	
</script>
</head>
<body onload="LoadCityData(1);">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;酒店报表</b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" method="post"
			action="hotel!bordereaux.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center"margin-bottom:4px;">

			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">


						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>






								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">

									<tr>
									
									
										<td width="129" height="40" align="right">城市：</td>
										<td><span style="HEIGHT: 71px"><input id="arrcity"
											style="WIDTH: 160px" name="s_shenfz"
											value="<ww:property value="cityId"/>" /></span>
										<div id="suggest" class="ac_results"></div>
										</td>
										<td height="28" align="right"><span class="STYLE2">推荐级别：</span></td>
										<td><select name="hoteltype" style="WIDTH: 166px">
											<option value="" >--未选择--</option>
											<option value="1" <ww:if test="hoteltype==\"1\"">selected</ww:if>>特级主推</option>
											<option value="2" <ww:if test="hoteltype==\"2\"">selected</ww:if>>金牌主推</option>
											<option value="3" <ww:if test="hoteltype==\"3\"">selected</ww:if>>暂时主推</option>
											<option value="4" <ww:if test="hoteltype==\"4\"">selected</ww:if>>一级主推</option>
											<option value="5" <ww:if test="hoteltype==\"5\"">selected</ww:if>>零级主推</option>
											<option value="6" <ww:if test="hoteltype==\"6\"">selected</ww:if>>问题酒店</option>
										</select></td>

									</tr>
									<input type="hidden" id="city_from_hide" name="cityId" />

									<input type="hidden" id="guojia" name="guojia" />
									<tr>
											<td width="184" height="30" align="right">酒店名称：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="hotelname"
											value="<ww:property value="hotelname"/>" /></span></td>
										
										<td width="129" height="40" align="right">日期：</td>
										<td><span style="HEIGHT: 71px"><input
											id="startnum2" style="WIDTH: 80px" name="statetime"
											value="<ww:property value="statetime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" />-- <input
											id="startnum2" style="WIDTH: 80px" name="endtime"
											value="<ww:property value="endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" /></span></td>

									</tr>

									<tr class="font-blue-xi">
										
										<!--<td height="28" align="right"><span class="STYLE2">订单状态：</span></td>
										<td width="181"><select name="hotelorderstate"
											style="WIDTH: 166px">
											<option value="" >请选择！</option>
											<option value="1" <ww:if test="hotelorderstate==\"1\"">selected</ww:if>>待确认</option>
											<option value="2" <ww:if test="hotelorderstate==\"2\"">selected</ww:if>>已确认</option>
											<option value="7" <ww:if test="hotelorderstate==\"7\"">selected</ww:if>>满房</option>
											<option value="9" <ww:if test="hotelorderstate==\"9\"">selected</ww:if>>入住</option>
											<option value="10" <ww:if test="hotelorderstate==\"10\"">selected</ww:if>>No Show</option>
											<option value="6" <ww:if test="hotelorderstate==\"6\"">selected</ww:if>>取消</option>
										
										</select></td>
									--></tr>
									<tr class="font-blue-xi">
										<td height="10" colspan="5" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" colspan="5" align="center"><input
											type="submit" class="button_d font-white"
											value="查&nbsp;&nbsp;询" />
											
								&nbsp;&nbsp;&nbsp;<input type="button"
									class="button_d font-bai" onclick="document.form1.action='hotel!bordereauxexcel.action';document.form1.submit();"
									value="导出Excel" />			
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
		</form>


		</td>
	</tr>
<tr>
<td>

<form name="form2" method="post" action="hotelordersearch.action">
  
      <table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody >
                <tr bgcolor="#d7e9fc"  height="25"  >
                  <th style="text-align: center;">订单号</th>
                  <th style="text-align: center;">酒店名称</th>
                  <th style="text-align: center;">房型名称</th>
                  <th style="text-align: center;">预订间数</th>
                  <th style="text-align: center;">入住日期</th>
                  <th style="text-align: center;">离店日期</th>
                  <th style="width: 100px;text-align: center;" >联系人姓名</th>
                  <th style="width: 150px;text-align: center;" >入住人</th>
                  <th style="text-align: center;">间夜</th>
                  <th style="text-align: center;">订单状态</th>
                  <th style="text-align: center;">订单总价</th>
			  </tr>

		<ww:iterator value="listHotelorder">
	      <tr align="center"  height="20"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
           <td><ww:property value="orderid"/>	</td>
           <td><ww:property value="name"/></td>
           <td><ww:property value="roomtypename"/></td>
           <td><ww:property value="prerooms"/></td>
           <td><ww:property value="formatDate(comedate)"/></td>
           <td><ww:property value="formatDate(leavedate)"/></td>
           <td><ww:property value="linkname"/></td>
           <td><ww:property value="getruzhu(id)"/></td>
           <td><ww:property value="manyday"/></td>
           <td>已入住
           <!--
           <ww:property value="getHotelorderState(state)"/>
           --></td>
           <td><ww:property value="price"/></td>	
	</tr>
	</ww:iterator>
		<ww:iterator value="list">
		   <td>总订单数:<ww:property value="r_sum" /></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td>总间夜:<ww:property value="r_jianye"/></td>
           <td></td>
           <td>总价格	:
            <ww:property value="r_hotelprice" />
           <!--
           <ww:property value="zongjia"/>
           --></td>	
           </ww:iterator>
           </tbody>
            </table></td>
          </tr>
          <tr>
          
          </tr>
        </table></td>
      </tr>
    </table>
 </td></tr></table></div>

</form>
</body>
</html>

