<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国际机票列表</title>
<ww:head name="inter" jsURL="interlist" />
<script type="text/javascript">
   $(document).ready(function()
  {
   
   $("#fromCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideFromCityCode',onSelect:function(){$("#arrCity").click();}, attachObject:'#suggest'});
	    $("#arrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideArrCityCode',onSelect:function(){}, attachObject:'#suggest2'});
    
  });
  
function onhide(){
 <ww:iterator value="routs" status="state">
     var i=<ww:property value="#state.index"/>;
     alert(i);
     var flag=document.getElementById("info_"+i); 
     flag.style.display=="none"
    
 </ww:iterator>
 
}
 
 //控制列表信息隐藏显示
  function onOpen(id){
  var flag=document.getElementById("info_"+id); 

     if(flag.style.display=="none"){
      flag.style.display ="";
     }
     else{
      flag.style.display ="none";
     }
  }
  //添加订单
  function CheckOrder(index){
  
  alert("国际机票价格波动过大,为确保你的利益,请致电${tel}预订!");
  return;
  
  var a=0;
  a=parseInt(index)+1;
     var fl=document.getElementById("RoutesId_"+index);
         document.form3.action="international!toOrder.jspx?RoutesId="+a;
	     document.form3.method = "POST"; 
         document.form3.submit();
  }
  
 </script>
</head>

<body>
<ww:i18n name="'language'">
	<div>
	<div class="cen" style="position: relative;"><ww:include page="../top.jsp?index=1&subindex=2" /></div>
	</div>
	<!--includ top 直接替换掉整个DIV--></div>

	<!--top over-->
	<div class="nohave">&nbsp;</div>
	<div id="list">
	<div class="f left">
	<div>
	<div class="f"><span class="f ico_interone">&nbsp;</span><font
		class="big000"><ww:property
		value="getInterAirCityNamebySZM(hideFromCityCode)" />－<ww:property
		value="getInterAirCityNamebySZM(hideArrCityCode)" /> <ww:if
		test="intertype==1">（单程）</ww:if><ww:else>（往返）</ww:else></font></div>
	<div class="r">查询&nbsp;预订&nbsp;核对&nbsp;完成</div>
	<div class="c"></div>
	</div>
	<div class="nohave"></div>
	<div class="inter-tips fff"><ww:property
		value="getInterAirCityNamebySZM(hideFromCityCode)" /> --> <ww:property
		value="getInterAirCityNamebySZM(hideArrCityCode)" /> 出发日期：<ww:property
		value="fromTime" />（共<ww:if test="routs!=null">
		<ww:property value="routs.size()" />
	</ww:if><ww:else>0</ww:else>个航班信息）</div>
	<div class="algin mt7" style="display: none">
	<form action="international!toInterNationalList.jspx" name="form1"
		method="post">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" width="185">航程类型： <input name="intertype"
				id="radioOne" onclick="radioSelect(1);" type="radio" class=""
				value="1" <ww:if test="intertype==1">checked="checked"</ww:if> /><ww:text
				name="'OneWay'" /> <input name="intertype" id="radioTwo"
				type="radio" value="2" onclick="radioSelect(2);"
				<ww:if test="intertype==2">checked="checked"</ww:if> /><ww:text
				name="'Return'" /></td>
			<td width="245"><ww:text name="'DepartureCity'" />：<input
				type="text" class="text_intersea" id="fromCity" name="fromCity"
				value='<ww:property value="getInterAirCityNamebySZM(hideFromCityCode)"/>' />
			<div id='suggest' class="ac_results"></div>
			<input type="hidden" id="hideFromCityCode" name="hideFromCityCode"
				value='<ww:property value="hideFromCityCode"/>' /></td>
			<td><ww:text name="'ArrivalCity'" />：<input type="text"
				class="text_intersea" id="arrCity" name="arrCity"
				value='<ww:property value="getInterAirCityNamebySZM(hideArrCityCode)"/>' />
			<div id='suggest2' class="ac_results"></div>
			<input type="hidden" id="hideArrCityCode" name="hideArrCityCode"
				value='<ww:property value="hideArrCityCode"/>' /></td>
		</tr>
		<tr>
			<td><input type="button" class="bnt-aglin fff mr5" value="重新查询"
				onclick="checkBotton();" /><a href="#" class="f00"></a></td>
			<td><ww:text name="'DepartureTime'" />：<input type="text"
				id="fromTime" name="fromTime" class="text_intersea"
				onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
				value='<ww:property value="fromTime"/>' /></td>
			<td id="lireturnTime"
				<ww:if test="intertype==1">style="display:none"</ww:if>>返回时间：<input type="text" id="returnTime"
				class="text_intersea"
				onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
				name="returnTime" value='<ww:property value="returnTime"/>' /></td>
		</tr>
	</table>
	</form>
	</div>
	<!-- 点击更多条件弹出层 -->
	<div class="algin-more" style="display: none">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" width="185">乘客类型：<select
				class="sel_intersea_algin">
				<option>成人</option>
			</select></td>
			<td width="245">乘客人数：<select class="sel_intersea">
				<option>1人</option>
			</select></td>
			<td>舱位等级：<select class="sel_intersea">
				<option>特价舱</option>
			</select></td>
		</tr>
	</table>
	</div>
	<!-- 点击更多条件弹出层  end-->
	<div class="algin-botm">&nbsp;</div>
	<div class="box mt7">
	<div class="title"><font class="black low f mr15">国际机票信息</font> <span
		class="r mr15"> <!--  排序：<select id="ddlsort" onchange="sortflightlist();">
		<option value="timeasc">出发时间从早到晚</option>
		<option value="timedesc">出发时间从晚到早</option>
		<option value="priceasc">价格从低到高</option>
		<option value="pricedesc">价格从高到低</option>
	</select> -->  </span>
	<div class="c"></div>
	</div>
	<div class="list" id="accordion">
	<form action="" name="form3" id="form3">
	<input type="hidden"
		name="passengerType"
		value="<ww:property value="passengerType"/>" /> 
	<input type="hidden"
		name="hideFromCityCode"
		value="<ww:property value="hideFromCityCode"/>" /> <input
		type="hidden" name="hideArrCityCode"
		value="<ww:property value="hideArrCityCode"/>" /> <input type="hidden"
		name="fromTime" value="<ww:property value="fromTime"/>" /> <input
		type="hidden" name="returnTime"
		value="<ww:property value="returnTime"/>" /> <input type="hidden"
		name="intertype" value="<ww:property value="intertype"/>" />
	
	<ww:if test="routs!=null">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="tableid">
		<thead>
				<tr class="hand">
					<th width="21%" scope="col">航空公司</th>
					<!--<th width="16%" scope="col" >出发</th>
					<th width="16%" scope="col">过夜</th>
					<th width="16%" scope="col">到达</th>
					-->
					<th width="16%" scope="col" >&nbsp;</th>
					<th width="16%" scope="col">&nbsp;</th>
					<th width="16%" scope="col">&nbsp;</th>
					
					<th width="14%" scope="col">转机</th>
					<th scope="col">价格</th>
				</tr>
		</thead>		
			<!--航班信息  列表 -->
		<tbody>
				<ww:iterator value="routs" status="state">
				
					<tr class="liston hand" 
						onclick="onOpen(<ww:property value="#state.index"/>)">
						<td>
						<!--<span
							class="f list_mu "><img src="images/airComlogo/<ww:property value="AirCompany" />.gif" /></span>
						
						--><!--<span
							class="f list_mu airco_<ww:property value="AirCompany" /> airico">&nbsp;</span>
							
							--><span
							class="f"><ww:if
							test="AirCompanyNamebyCode(AirCompany).length()>8">
							<ww:property
								value="AirCompanyNamebyCode(AirCompany).substring(0,8)" />
						</ww:if> <ww:else>
							<ww:property value="AirCompanyNamebyCode(AirCompany)" />
						</ww:else> <input type="hidden" name="RoutesId"
							id='RoutesId_<ww:property value="#state.index"/>'
							value='<ww:property value="ID"/>' /></span></td>
						<td><ww:property value="getTimeByDate(DepdateTime)" /></td>
						<td><ww:if test="getTimeGY(DepdateTime,ArrdateTime)==0">N</ww:if>
						<ww:else>Y</ww:else></td>
						<td><ww:property value="getTimeByDate(ArrdateTime)" /></td>
						<ww:if test="IsChangeFlight>0">
							<td><ww:property value="IsChangeFlight" />次</td>
						</ww:if>
						<ww:else>
							<td>直飞</td>
						</ww:else>
						<td><font class="f90c"><ww:property
							value="formatMoneyToInt(TotalFare)" /></font>元</td>
					</tr>

                  
					<tr style="display: none"
						id="info_<ww:property value="#state.index"/>">
						<td colspan="6">
						<div class="msg_l">
						<ul class="msgul_l">
							<li class="list_more">
							<div class="box">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th scope="col" width="73">航班号</th>
									<th scope="col" width="134">起抵时间</th>
									<th scope="col" width="91" align="left">起抵机场</th>
									<th scope="col" width="79">飞行时长</th>
									<th scope="col" width="101">机型</th>
									<th width="192" scope="col">更多操作</th>
								</tr>
								<tr>
									<td colspan="5" class="box_right" width="478" >
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										style="margin: 1px;">
										<ww:iterator value="RouteDetailInfos" status="s">
											<tr>
												<td width="75"><ww:property value="FlightNumber"  /> <input
													type="hidden" name="RouteDetailInfoId"
													id='RouteDetailInfoId_<ww:property value="#s.index"/>'
													value='<ww:property value="ID"/>' /></td>
												<td width="130"><ww:property
													value="getTimeByDate(FromDate)" /><br />
												<ww:property value="getTimeByDate(ToDate)" /></td>
												<td align="left" width="105"><ww:property
													value="getAirPortNamebyCode(FromAirport)" /><br />
												<ww:property value="getAirPortNamebyCode(ToAirport)" />
												</td>
												<td width="55"><ww:property value="FlyTime" /></td>
												<td><ww:property value="Plane" /><br />
												<!--<a href="#" class="unc09fx">选择其他航班</a>--></td>
											</tr>
										</ww:iterator>
									</table>
									</td>

									<td class="list_more_right" valign="top">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										style="margin: 1px;">
										<tr>
											<td>成人价￥<ww:property value="formatMoneyToInt(TotalFare)" />(不含税)<br />
											儿童价￥<ww:property value="formatMoneyToInt(TotalChlidFare)" />(不含税)<br />
											参考税￥<ww:property value="formatMoneyToInt(TotalTax)" /><br />
											<a href="javascript:void(0);" class="unc09fx mr15">订票规则</a><a
												href="javascript:void(0);" class="unc09fx">税费查询</a><br />
											<input type="button"
												onclick="CheckOrder(<ww:property value="#state.index"/>)"
												class="bnt_book fff" value="预订" /> <font
												class="ff7f05">行李20KG</font></td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							</div>
							</li>
							<li class="nohave">&nbsp;</li>
						</ul>
						</div>

						</td>
					</tr>

				</ww:iterator>
				<!--航班信息  列表end -->
	 </tbody>


		</table>
	</ww:if> 
	
	<ww:else>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<font class="f ff7f05">非常抱歉，没有查询到您所查询的航班信息！</font>
			</tr>
		</table>
	</ww:else>
	</form>
	</div>
	</div>
	</div>
	
	<div id="right" class="r">
	<div class="titlelogin"><font class="black">国际航线咨询</font></div>
	<div class="box_sea">
	<ul class="inter-information">
		<li class="nohave">&nbsp;</li>
		<li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li>
		<li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li>
		<li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li>
		<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
		<li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li>
		<li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li>
		<li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li>
		<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
		<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
		<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
		<li class="nohave">&nbsp;</li>
	</ul>
	</div>
	<div class="loginbot"></div>
	<div class="nohave">&nbsp;</div>
	<div><img src="images/ad_interright.jpg" width="260" height="88" /></div>
	<div class="nohave">&nbsp;</div>
	<div><img src="images/ad_interrightto.jpg" width="260"
		height="88" /></div>
	</div>
	<div class="c"></div>
</div> 

	<!--container over-->
	<ww:include page="../footer.jsp" />
</ww:i18n>
</body>
</html>
