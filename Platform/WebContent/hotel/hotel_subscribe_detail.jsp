<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
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
			.STYLE2 {font-size: 12}
			-->
		</style>
		<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
		<script type="text/javascript" src="../js/autocomplete/jquery.autocomplete.js"></script>
		<script type="text/javascript" src="../js/validator.js"></script>
		<script type="text/javascript" src="../js/util.js"></script>
		<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
	    <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	    <link href="../css/base.css" rel="stylesheet" />
	    <link href="../css/style.css" rel="stylesheet" />
	</head>
	<body>
	 <div class="right" style="margin-left: 0px; margin-top:7px;">
	 	<!-- 酒店详细信息 -->
	 	<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  			<tr>
    			<td width="100%" height="29" class="box-bottom bg">
					<span><ww:property value="hotel.name" /></span>  
    			</td>
  			</tr>
  			<tr>
  			<td>
  			<jsp:include page="../orderuserinfo.jsp"></jsp:include>
  			</td>
  			</tr>
  			<tr>
  				<td>
  					<div class="guoji">
					        <div class="guoji_2_1">
					        <ww:if test="getImage(id)!= ''">
					        	<img src="<%=((Sysconfig)Server.getInstance().getMemberService().
					        			findAllSysconfig("where C_NAME='weppath'","",-1,0).
					        			get(0)).getValue() %><ww:property value="getImage(id)"/>" 
					        		width="143" height="210" /></ww:if>
					        			<ww:else>
			 	  <img height="72" width="72" src="../images/NoImage.gif" />
			 	 </ww:else>
					        </div>
							<div>
						    	<div class="guoji_2_1_1">
									<ul>
									    <li>等级：
									    	<ww:property value="outputStar(hotel.star)"/>
										<li>地址： <ww:property value="hotel.address" /></li>
										<li>房间数：<ww:property value="hotel.rooms" /> Rooms </li>
										<li>总机：<ww:property value="hotel.tortell" /></li>
									</ul>
				            	</div>
								<div class="f guoji_2_1_4">
									<ww:property value="hotel.description" />
								</div>
						   </div>
					  </div>
  				</td>
  			</tr>
  		</table>
	 	<!-- 结束酒店详细信息 -->
	 	<!-- 酒店详细信息 -->
	 	<form method="post" action="hotelsubscribe!toDetail.action" name="hotelbook">
		 	<input type="hidden" name="hotel.id" value="<ww:property value="hotel.id" />" />
		 	<input type="hidden" name="roomid" />
		 	<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
	  			<tr>
	    			<td width="100%" height="29" background="../images/jb.gif">
			    	<ww:property value="hotel.name" />房型与房价 
			    	<span style="padding-left:10px;">入住日期：</span>
			   		<input name="startDate" type="text" id="h_comedate"
			   			 class="Wdate" style="WIDTH: 100px" value="<ww:property value="startDate" />"  readonly="readonly" 
			   			 onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',
			   			 			minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){h_leavedate.focus();}})" />退房日期：
			   		<input name="endDate" type="text" id="h_leavedate" 
			   			class="Wdate" style="WIDTH: 100px" value="<ww:property value="endDate" />" readonly="readonly" 
			   			onfocus="this.value=getDateDiff($('#h_comedate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',
			   					minDate:'#F{$dp.$D(\'h_comedate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',
			   					maxDate:'%y-#{%M+2}-%d'})"  />  
			  		 &nbsp;&nbsp;
			  		 <input name="button2" type="button" onclick="hotel_come_leavetime_update()" 
			  		 	class="button_1" value="查&nbsp;询" />
	    			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<div class="fangx">
			    
				<div class="fangx_2 hei12_c">
				   <ul>
					   <li>房型</li>
					   <li>价格说明</li>
					   <li>门市价</li>
					   <li>会员价</li>
					   <!--
					   <li>均价</li>
					   -->
					   <li style="width:50px;">早餐</li>
					   <li style="width:50px;">床型</li>
					   <li>上网</li>         
				   </ul>
				</div>
				<div class="fangx_2">
					<ww:iterator value="mapRoom.get(hotel.id)" status="index" id="roomType">
					    <ul <ww:if test="#index.index >= 2"> style="display: none;" </ww:if> <ww:else>style="display: block;" </ww:else>>
							 <li><ww:property value="name" /></li>
							 <li>&nbsp;</li>
							 <li>￥<ww:property value="getDeptPrice(hotel.id,id)"/></li>
							 <li>
								￥<ww:property value="getDatePrice(hotel.id,id)"/>
							 </li>
							 <li style="width:50px;"><ww:property value="getBreakfast(breakfast)"/></li>
							 <li style="width:50px;"><ww:property value="getBed(bed)"/></li>
							 <li><ww:property value="getWideband(wideband)"/></li>
							 <li><ww:if test="getDeptPrice(hotel.id,id)!=null">
							 <img src="../images/anniu_yu.gif" width="75"height="24" border="0"  onclick="hotel_book(${roomType.id})"/>
							 </ww:if><ww:else>
							 <img src="../images/anniu_yu.gif" width="75"height="24" border="0"  />
							 </ww:else>
							 </li>
					  	</ul><br/>
				  	</ww:iterator>
				</div>
	 	   </div>
	  				</td>
	  			</tr>
	  		</table>
	 </div>
	</body>
	<script language="javascript">
		var h_comedate = '<ww:property value="startDate" />' ;
		var h_leavedate = '<ww:property value="endDate" />' ;
		function hotel_come_leavetime_update(id) {
			document.forms.hotelbook.action = "hotelsubscribe!toDetail.action";//?id=<ww:property value="hotel.id" />
			document.forms.hotelbook.submit() ;
		}

		function hotel_book(id) {
			if($('#h_comedate').val() == h_comedate && $('#h_leavedate').val() == h_leavedate) {
				document.forms.hotelbook.roomid.value= id ;
				document.forms.hotelbook.action = "hotelbook.action" ;
				document.forms.hotelbook.submit() ;
			} else {
				if(window.confirm("改变入住日期和离店日期必须重新查询,确定要查询吗？")) {
					hotel_come_leavetime_update(id) ;
				}
			}
		}
		function checkhotel_p() {
		}	
	</script>
</html>
