<%@ page contentType="text/html; charset=utf-8"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2009
	 *
	 *
	 *  HISTORY
	 *  
	 *  2009/08/14 创建
	 *
	 */
%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<%@page import="com.yf.system.back.server.Server"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
<script type="text/javascript"
	src="../js/autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../js/validator.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<link rel="stylesheet" type="text/css"
	href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../js/ext-all.js"></script>
<link href="../css/base.css" rel="stylesheet" />
<link href="../css/style.css" rel="stylesheet" />
<script language="javascript">
	    	function check111(id,s_startdate,s_enddate) {
	    		window.location.href="hotelbook.action?roomid= "
	    			+ id + "&startDate= " + s_startdate + "&endDate= " + s_enddate + " ";
	    	}
	    	$().ready(function() {
	    		var starVar = '<ww:property value="arrayToString(s_star)" />' ;
	    		var newArr = starVar.split(",");
	    		$('input[name=s_star]').each(function(i){
		    		for(var i=0; i<newArr.length; i++) {
		    			if($(this).val() == newArr[i]) {
							$(this).attr("checked",true);
						}
		    		}
	    		});	
	    		
	    		var repairVar = '<ww:property value="arrayToString(s_repair)" />' ;
	    		var repairArr = repairVar.split(",");
	    		$('input[name=s_repair]').each(function(i){
		    		for(var i=0; i<repairArr.length; i++) {
		    			if($(this).val() == repairArr[i]) {
							$(this).attr("checked",true);
						}
		    		}
	    		});	
	    	});
	    	
	    	function checkcity(a){
	    	if(a==1){
	document.getElementById("guoji").style.display="none";
   document.getElementById("guonei").style.display="block";
	    	}
		if(a==2){
		
	document.getElementById("guonei").style.display="none";
   document.getElementById("guoji").style.display="block";
	    	}
	    	
	    	}
	    </script>
</head>
<ww:if test="checkrad==1">
	<body style="width: 100%" onload="checkcity(1);">
</ww:if>
<ww:if test="checkrad==2">
	<body style="width: 100%" onload="checkcity(2);">
</ww:if>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店查询</span></td>
	</tr>
	<tr>
		<td><jsp:include page="../orderuserinfo.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td valign="top">
		<div class="cx_2" style="width: 644px; border: none; margin: 0 auto">
		<form action="hotelsubscribe.action" method="post" name="form1"
			id="form1">

		<div class="hang"><input type="radio" name="checkrad" value="1"
			checked="checked" <ww:if test="checkrad==1">checked</ww:if>
			onclick="checkcity(1)" />国内 <input type="radio" name="checkrad"
			value="2" <ww:if test="checkrad==2">checked</ww:if>
			onclick="checkcity(2)" />国际</div>


		<div class="hang" style="display: none;" id="guoji">国际城市： <span
			style="HEIGHT: 71px"> <select id="h_hotelCityId"
			name="incityId" style="WIDTH: 187px">
			<option value="">所有的城市</option>
			<ww:iterator value="incityList">
				<ww:if test="incityId == id">
					<option value="<ww:property value="id"/>" selected="selected"><ww:property
						value="name" /></option>
				</ww:if>
				<ww:if test="incityId != id">
					<option value="<ww:property value="id"/>"><ww:property
						value="name" /></option>
				</ww:if>
			</ww:iterator>
		</select> </span> <span class="bixu hong12" id="ts_recAcc1Err">*</span></div>

		<div class="hang" id="guonei">国内城市： <span style="HEIGHT: 71px">
		<select id="h_hotelCityId" name="cityId" style="WIDTH: 187px">
			<option value="">所有的城市</option>
			<ww:iterator value="cityList">
				<ww:if test="cityId == id">
					<option value="<ww:property value="id"/>" selected="selected"><ww:property
						value="name" /></option>
				</ww:if>
				<ww:if test="cityId != id">
					<option value="<ww:property value="id"/>"><ww:property
						value="name" /></option>
				</ww:if>
			</ww:iterator>
		</select> </span> <span class="bixu hong12" id="ts_recAcc1Err">*</span></div>
		<div class="hang">入住日期： <input name="startDate" id="s_startdate"
			type="text" size="18" class="Wdate" readonly="readonly"
			value="<ww:property value="startDate"/>"
			onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',
						minDate:'%y-%M-%d',
						maxDate:'%y-#{%M+1}-%d', 
						onpicked:function(){s_enddate.focus();}})" />
		&nbsp;&nbsp;离店日期： <input name="endDate" id="s_enddate" type="text"
			size="18" class="Wdate" readonly="readonly"
			value="<ww:property value="endDate"/>"
			onfocus="this.value=getDateDiff($('#s_startdate').val(),1);
						WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',
						minDate:'#F{$dp.$D(\'s_startdate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',
						maxDate:'%y-#{%M+2}-%d'})" />
		</div>
		<div class="hang">酒店名称：<input name="hotelName" type="text"
			size="18" maxlength="50" value="<ww:property value="hotelName" />" />
		&nbsp;&nbsp; 价格范围：<select name="priceType">
			<option value="0" <ww:if test="priceType==0">selectec="true"</ww:if>>不限</option>
			<option value="1" <ww:if test="priceType==1">selectec="true"</ww:if>>200元以下</option>
			<option value="2" <ww:if test="priceType==2"> selected="true"</ww:if>>200-400元</option>
			<option value="3" <ww:if test="priceType==3"> selected="true"</ww:if>>400-600元</option>
			<option value="4" <ww:if test="priceType==4"> selected="true"</ww:if>>600元以上</option>
		</select></div>
		<!--<div class="hang">
				酒店位置：
				<input name="regiontype" type="radio" value="0" onclick="getcitiesInfo();"/> 商业区 
				<input name="regiontype" type="radio" value="1" onclick="getcitiesInfo();"/> 行政区
				<input name="regiontype" type="radio" value="2" onclick="getcitiesInfo();"/> 景区
				<select id="regionvalue" style="WIDTH: 150px" name="regionvalue">
					<option>--请选择--</option>
				</select>
			</div>												
			-->
		<div class="hang">酒店星级： <input name="s_star" type="checkbox"
			value="1" /> 经济型 <input name="s_star" type="checkbox" value="3" />
		二星级 <input name="s_star" type="checkbox" value="4" /> 准三星 <input
			name="s_star" type="checkbox" value="5" /> 三星级 <input name="s_star"
			type="checkbox" value="6" /> 准四星 <input name="s_star"
			type="checkbox" value="7" /> 四星级 <input name="s_star"
			type="checkbox" value="8" /> 准五星 <input name="s_star"
			type="checkbox" value="9" /> 五星级</div>
		<div class="hang">装修级别： <input name="s_repair" type="checkbox"
			value="1" /> 豪华 <input name="s_repair" type="checkbox" value="2" />
		高档 <input name="s_repair" type="checkbox" value="3" /> 舒服 <input
			name="s_repair" type="checkbox" value="4" /> 经济</div>
		<div class="anniu_cx">
		<div align="center"><input type="submit"
			class="button_d font-white" value="查询" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset"
			class="button_d font-white" value="重置" /></div>
		</div>
		</form>
		</div>
		</td>
	</tr>
	<tr>
		<td><ww:if test="hotelList != null && hotelList.size()>0">
			<ww:iterator value="hotelList" status="t">
				<div>
				<div class=" liebiao_2"
					style="border-top: 1px solid #99CBED; width: 100%;">
				<div style="background: url(../images/jb.gif)"><a
					href="hotelsubscribe!toDetail.action?hotel.id=<ww:property value="id"/>
				&cityid=<ww:property value="cityid"/>
				&startDate=<ww:property value="startDate"/>
				&endDate=<ww:property value="endDate"/>
				&hotelName=<ww:property value="name"/>">
				<span class="huang12_c" style="margin-left: 15px;"><ww:property
					value="name" /></span> </a></div>
				<div class="liebiao_2_1">
				<div><ww:if test="getImage(id)!= ''">
					<a
						href="hotelsubscribe!toDetail.action?hotel.id=<ww:property value="id"/>&cityid=<ww:property value="cityid"/>&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>&hotelName=<ww:property value="name"/>"><img
						width="72" height="72"
						src="<%= ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue()%><ww:property value="getImage(id)"/>" /></a>
				</ww:if><ww:else>
					<a
						href="hotelsubscribe!toDetail.action?hotel.id=<ww:property value="id"/>&cityid=<ww:property value="cityid"/>&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>&hotelName=<ww:property value="name"/>"><img
						height="72" width="72" src="../images/NoImage.gif" /></a>
				</ww:else> <br />
				<ww:property value="getStarico(star)" /></div>
				</div>
				<div class="liebiao_2_2">
				<div class="liebiao_2_2_1"><ww:property
					value="subString(description,140)" />……</div>
				<div class="huang12"><img src="../images/biao_1.gif" /> 地址：<ww:property
					value="address" /></div>
				<div class="liebiao_2_2_2 hei12_c">
				<ul>
					<li style="float: left; width: 15%">房型</li>
					<li style="float: left; width: 17%">门市价</li>
					<li style="float: left; width: 17%">会员价</li>
					<li style="float: left; width: 10%">早餐</li>
					<li style="float: left; width: 15%">床型</li>
					<li style="float: left; width: 10%">宽带</li>
					<li style="float: left; width: 15%">前台现付</li>
				</ul>
				</div>
				<div class="liebiao_2_2_3"><ww:iterator
					value="mapRoom.get(id)" status="index" id="roomType">
					<ul
						<ww:if test="#index.index >= 2"> style="display: none;" </ww:if>
						<ww:else>style="display: block;" </ww:else>>
						<li style="float: left; width: 15%"><ww:property value="name" /></li>
						<li style="float: left; width: 17%">￥<ww:property
							value="getDeptPrice(hotelList[#t.index].id,id)" /></li>
						<li style="float: left; width: 17%">￥<ww:property
							value="getDatePrice(hotelList[#t.index].id,id)" /></li>
						<li style="float: left; width: 10%"><ww:property
							value="getBreakfast(breakfast)" /></li>
						<li style="float: left; width: 15%"><ww:property
							value="getBed(bed)" /></li>
						<li style="float: left; width: 10%"><ww:property
							value="getWideband(wideband)" /></li>
						<li style="float: left; width: 15%"><img
							src="../images/anniu_yu.gif" width="75" height="24" border="0"
							onclick="check111( '${roomType.id}',
										'<ww:property value="startDate"/>','<ww:property value="endDate"/>');" />
						</li>
					</ul>
				</ww:iterator></div>
				<div style="float: right; margin-left: 10px; padding-top: 5px;">
				</div>
				</div>
				</div>
				</div>
			</ww:iterator>
			<div style="width: 600px;"><ww:property value="pagination" />
			</div>
		</ww:if> <ww:else>
				共0家酒店符合筛选条件
			</ww:else></td>
	</tr>
</table>
</body>
</html>
