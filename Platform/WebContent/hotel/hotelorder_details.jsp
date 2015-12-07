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
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店订单详细页面</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}

.STYLE3 {
	color: #000000
}
-->
</style>


 <style type="text/css">
.container {
        width: 400px;
        padding-top: 5px;
        margin: 3px 0 0px 0;
        border: 1px solid #ccc;
        background: #fff;
}

/* square */

#navSquare {
        margin: 0;
        padding: 0 0 20px 10px;
        border-bottom: 1px solid #9FB1BC;
}

#navSquare li {
        margin: 0;
        padding: 0;
        display: inline;
        list-style-type: none;
}

#navSquare a:link, #navSquare a:visited {
        float: left;
        font-size: 10px;
        line-height: 14px;
        font-weight: bold;
        padding: 0 12px 6px 12px;
        text-decoration: none;
        color: #708491;
}
#navSquare a:link.active, #navSquare a:visited.active, #navSquare a:hover {
        background: url(../images/Square.gif) no-repeat bottom center;
        color: #000;
        
}
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<link href="../style/CommonX.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/validator.js"></script>
<script type="text/javascript" src="../js/jquery1.3.2.js"></script>

<script>
  function showsms()
  {
      document.getElementById("framemsg").style.display="block";
      document.getElementById("framefax").style.display="none";
      document.getElementById("container").style.display="none";
       $("#litab2").addClass("active");
     $("#litab1").removeClass("active");
     $("#litab3").removeClass("active");
  }
  function showfax()
  {
      document.getElementById("framefax").style.display="block";
      document.getElementById("container").style.display="none";
      document.getElementById("framemsg").style.display="none";
       $("#litab3").addClass("active");
     $("#litab2").removeClass("active");
     $("#litab1").removeClass("active");
  }
  function showinfo(index)
  {
     var url='hotelwholeorder!todetails.action?ordid='+index;
     window.location.href=url;
     $("#litab1").addClass("active");
     $("#litab2").removeClass("active");
     $("#litab3").removeClass("active");
  }
</script>
<body>
<div >
<ww:if test="typ==2">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px; ">
	<tr>
		<td width="100%" height="29" class="box-bottom bg" align="center"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;芒果接口订单详细信息</span></td>
	</tr>
	
	<tr height="20px"><td></td></tr>
	
	<tr id="container">
		<td height="100%" align="center">
		<table width="90%" cellpadding="0" cellspacing="0" border="1"
			bordercolor="#a0cfee" style="border-collapse: collapse;background: #666">
			
			<tr class="font-blue-xi">
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单号</strong>：</span></td>
				<td width="35%" align="left" style="font-weight: bold"><ww:property
					value="hotelorder.waicode" /></td>

				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单状态</strong>：</span></td>
				<td width="35%" align="left" style="color: red; font-weight: bold">
				<ww:property value="getMangGoHotelorderState(MangGohotelorder.orderStates)" />
					</td>
			</tr>
			<tr>
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>修改时间</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="MangGohotelorder.modifiedtime" /></td>
					
					
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>首日价</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="MangGohotelorder.firstDayPrice" /></td>
			</tr>
		
			<tr>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>电话确认酒店</strong>：</span></td>
				<td align="left">
				
					<ww:if test="MangGohotelorder.hotelConfirmTel.equals(\"1\")">已经确认</ww:if>
					<ww:if test="MangGohotelorder.hotelConfirmTel.equals(\"0\")">没确认</ww:if>
					</td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>传真确认酒店</strong>：</span></td>
				<td align="left">
				<ww:if test="MangGohotelorder.hotelConfirmFax.equals(\"1\")">已经确认</ww:if>
					<ww:if test="MangGohotelorder.hotelConfirmFax.equals(\"0\")">没确认</ww:if>
				</td>
			</tr>
				<tr>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>日审状态</strong>：</span></td>
				<td align="left"><ww:property
					value="MangGohotelorder.auditStates" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店回传真</strong>：</span></td>
				<td align="left">
				<ww:if test="MangGohotelorder.hotelConfirmFaxReturn.equals(\"1\")">已经收到回传</ww:if>
				<ww:if test="MangGohotelorder.hotelConfirmFaxReturn.equals(\"0\")">没收到回传</ww:if>
				</td>
			</tr>

</table>

</td></tr></table>
</ww:if>

<form
	action="hotelwholeorder!<ww:if test="hotelorder.id>0">check.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<input type="hidden" name="h_hotelCityId"
	value="<ww:property value="h_hotelCityId"/>" /> <input type="hidden"
	name="h_orderId" value="<ww:property value="h_orderId"/>" /> <input
	type="hidden" name="h_linkname"
	value="<ww:property value="h_linkname"/>" /> <input type="hidden"
	name="h_linkmobile" value="<ww:property value="h_linkmobile"/>" /> <input
	type="hidden" name="h_prestarttime"
	value="<ww:property value="h_prestarttime"/>" /> <input type="hidden"
	name="h_preendtime" value="<ww:property value="h_preendtime"/>" /> <input
	type="hidden" name="h_hotelName"
	value="<ww:property value="h_hotelName"/>" /> <input type="hidden"
	name="h_isEnglishName" value="<ww:property value="h_isEnglishName"/>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店现付订单详细信息</span></td>
	</tr>
	
	<tr height="20px"><td></td></tr>
	
	<tr id="container">
		<td height="100%" align="center">
		<table width="90%" cellpadding="0" cellspacing="0" border="1"
			bordercolor="#a0cfee" style="border-collapse: collapse">
			
			<tr class="font-blue-xi">
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单号</strong>：</span></td>
				<td width="35%" align="left" style="font-weight: bold"><ww:property
					value="hotelorder.orderid" /></td>

				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单状态</strong>：</span></td>
				<td width="35%" align="left" style="color: red; font-weight: bold">
				<ww:if test="hotelorder.state==1">待确认</ww:if> <ww:if
					test="hotelorder.state==2">已处理</ww:if> <ww:if
					test="hotelorder.state==3">已发传真</ww:if> <ww:if
					test="hotelorder.state==4">已回传确认</ww:if> <ww:if
					test="hotelorder.state==5">预订完成</ww:if> <ww:if
					test="hotelorder.state==6">已取消订单</ww:if> <ww:if
					test="hotelorder.state==7">满房</ww:if> <ww:if
					test="hotelorder.state==8">变更</ww:if> <ww:if
					test="hotelorder.state==9">入住</ww:if> <ww:if
					test="hotelorder.state==10">NS</ww:if> <ww:if
					test="hotelorder.state==11"></ww:if> <ww:if
					test="hotelorder.state==12">已付款</ww:if> <ww:if
					test="hotelorder.state==13">已支付给酒店</ww:if> <ww:if
					test="hotelorder.state==14">交易完成</ww:if> <ww:if
					test="hotelorder.state==18">预订完成,等待付款</ww:if>
					<ww:if test="hotelorder.state==88">问题订单</ww:if>
					</td>
			</tr>
			<tr>
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>创建时间</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="formatTimestamp(hotelorder.pretime)" /></td>
					
					
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>保留时间</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="hotelorder.reservstart" />至<ww:property
					value="hotelorder.reservend" /></td>
			</tr>
			<tr>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人姓名</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.linkname" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人手机</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.linkmobile" /></td>
			</tr>

			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>外部订单号</strong>：</span></td>
				<td align="left">
					<ww:property value="hotelorder.waicode" />
				</td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>总利润</strong>：</span></td>
				<td align="left" style="color: red;">
				<ww:property value="hotelorder.profits" />
					<!--<ww:property value="gethotelfantoorder(hotelorder.profits,hotelorder.hotelid,hotelorder.memberid)" />
				--></td>
			</tr>
			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>特殊要求</strong>：</span></td>
				<td  align="left"><ww:if test="hotelorder.specreq!=null">
					<ww:property value="hotelorder.specreq" />
				</ww:if><ww:else>无特殊要求</ww:else></td>
				
				
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>加盟商</strong>：</span></td>
				<td align="left"><ww:property value="getAngetNameByUserId(hotelorder.memberid)" /></td>
				
				
			</tr>

			<tr class="font-blue-xi">
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店名称</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="hotelorder.name" /></td>

				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店地址</strong>：</span></td>
				<td align="left"><ww:property value="hotel.address" /></td>

			</tr>
			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店电话</strong>：</span></td>
				<td align="left"><ww:if test="hotel.tortell!=null">
					<ww:property value="hotel.tortell" />
				</ww:if><ww:else>暂无信息</ww:else></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店传真</strong>：</span></td>
				<td align="left"><ww:if test="hotel.faxdesc!=null">
					<ww:property value="hotel.faxdesc" />
				</ww:if><ww:else>暂无信息</ww:else></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>预订间数</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.prerooms" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>入住人</strong>：</span></td>
				<td align="left"><ww:iterator
					value="getGuestByOrderId(hotelorder.id)" status="guessStatus">
					<ww:property value="name" />
					<ww:if test="!#guessStatus.last">，</ww:if>
				</ww:iterator></td>
			</tr>

			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>入住日期</strong>：</span></td>
				<td align="left"><ww:property
					value="formatDate(hotelorder.comedate)" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>离店日期</strong>：</span></td>
				<td align="left"><ww:property
					value="formatDate(hotelorder.leavedate)" /></td>
			</tr>
			<!--<tr>
				

				<td align="right" height="28" class="level3_textright"><strong>确认方式</strong>：</td>
				<td align="left"><ww:if test="hotelorder.confirmmethod == 1">电话确认</ww:if>
				<ww:if test="hotelorder.confirmmethod == 2">电子邮件确认</ww:if> <ww:if
					test="hotelorder.confirmmethod == 3">电话和电子邮件确认</ww:if> <ww:if
					test="hotelorder.confirmmethod == 4">短信确认</ww:if></td>
			</tr>

			--><tr>
				<td colspan="4">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					bordercolor="#a0cfee" style="border-collapse: collapse">
					<tr>
						<th width="20%" align="center">房型</th>
						<th width="60%" align="center">每日价</th>
						<th width="20%" align="center">床型</th>
					</tr>
					<tr>
						<td align="center"><ww:property
							value="hotelorder.roomtypename" /></td>
						<td align="center">
						<table width="100%">
							<tr>
								<ww:property value="hotelorder.dayprice" />
							</tr>
						</table>
						</td>
						<td align="center"><ww:if
							test="getRoomtypeById(hotelorder.roomid).bed == 1">单人床</ww:if> <ww:elseif
							test="getRoomtypeById(hotelorder.roomid).bed == 2">大床</ww:elseif>
						<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 3">双床</ww:elseif>
						<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 4">大或双</ww:elseif>
						<ww:else>其他</ww:else></td>
					</tr>
				</table>
				</td>
			</tr>


			<tr class="font-blue-xi">
				<td align="right" height="28" class="level3_textright"><strong>总计金额</strong>：</td>
				<td align="left"><span style="color: red; font-weight: bold"><ww:property
					value="hotelorder.price" /></span></td>
				<td align="right" class="level3_textright"><strong>付款方式</strong>：</td>
				<td align="left"><ww:if test="hotelorder.paytype==1">前台现付</ww:if><ww:else>预付</ww:else></td>
			</tr>
			
			<tr class="font-blue-xi">
				<td height="46" colspan="4" scrolling="no">
				
				<!--
				<ww:if test="hotelorder.state==1">
				<input type="button" class="button_d font-white"
					onclick="ajax_hotelorder('<ww:property value="hotelorder.id"/>');" name="Submit2" value="确认订单" /> 
				</ww:if>
				-->
				<ww:if test="hotelorder.state==1 || hotelorder.state==2">
				<input type="button" class="button_d font-white"
					onclick="ajax_Canhotelorder('<ww:property value="hotelorder.id"/>');" name="Submit2" value="取消订单" /> 
				</ww:if>
				
				<ww:if test="hotelorder.state==2">
						<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(5)" name="Submit2" value="预订完成" />

					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(7)" name="Submit2" value="满房" />
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" />
				</ww:if>
					
					
				
				
				<ww:if test="hotelorder.state==5">
						
						<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(9)" name="Submit2" value="入住" />
						
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(10)" name="Submit2" value="NS" />
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" />

				</ww:if> 
				<ww:if test="hotelorder.state==7"><input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" /></ww:if>
				<input type="button" class="button_d font-white"
					onclick="window.history.back()" name="Submit2" value=" 返回上一级 " />
				</td>
			</tr>
			
		<!--<tr class="font-blue-xi">
				<td height="46" colspan="4" scrolling="no">
				
				<ww:if test="hotelorder.state==1">
				<input type="button" class="button_d font-white"
					onclick="ajax_hotelorder('<ww:property value="hotelorder.id"/>');" name="Submit2" value="确认订单" /> 
					</ww:if>
				<ww:if test="hotelorder.state==1 || hotelorder.state==2">
				<input type="button" class="button_d font-white"
					onclick="hotel_cannel_info(6)" name="Submit2" value="取消订单" /> 
						
				</ww:if>
				
			
					
					 <ww:if test="hotelorder.state==2">
					
						<input type="button" class="button_d font-white"
							onclick="chuanzhen(3,<ww:property value="hotelorder.hotelid"/>)"
							name="Submit2" value="发传真确认" />
				</ww:if>
				 <ww:if test="hotelorder.state==3">
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(4)" name="Submit2" value="已回传确认 " />
				</ww:if> 
				
				<ww:if test="hotelorder.state==4">
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(5)" name="Submit2" value="预订完成" />

					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(7)" name="Submit2" value="满房" />
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" />
				</ww:if> <ww:if test="hotelorder.state==5">
						
						<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(9)" name="Submit2" value="入住" />
						
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(10)" name="Submit2" value="NS" />
					<input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" />

				</ww:if> 
				<ww:if test="hotelorder.state==7"><input type="button" class="button_d font-white"
						onclick="hotel_cannel_info(8)" name="Submit2" value="变更" /></ww:if>
				<input type="button" class="button_d font-white"
					onclick="window.history.back()" name="Submit2" value=" 返回上一级 " />
				</td>
			</tr>
			
		--></table>
		</td>
	</tr>
	
</table>
</form>
<iframe id="framemsg" name="framemsg" style="display: none"
	frameborder="0" width="100%" height="800px" scrolling="auto"
	src="../ymsend.action?s_name=<ww:property
					value="hotelorder.orderid" />"></iframe>
					
<iframe id="framefax" name="framefax" style="display: none" frameborder="0" width="100%"
	height="800px" scrolling="auto" src="hotelfax/hotelfax<ww:property
					value="hotelorder.orderid" />.html"></iframe>
</div>

</body>

<script type="text/javascript">
	function hotel_show_noauditingreason() {
		document.getElementById('cancelreasonTr').style.display='';
	}
	function hotel_hide_noauditingreason() {
		document.getElementById('cancelreasonTr').style.display='none';
	}
	function chuanzhen(sta,hid) {
		//alert("sta=="+sta+"....hid="+hid);
		document.forms.form1.action="hotelwholeorder!tochuanzhen.action?sta="+sta+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	function hotel_cannel_info(st) {
	
				if(st==6){
	
						var temp = confirm('确认取消吗？');
						if(temp==true){
						
							document.forms.form1.action="hotelwholeorder!check.action?sta="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
							document.forms.form1.submit() ;
							
						}
						
				}else{
	
		document.forms.form1.action="hotelwholeorder!check.action?sta="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
		}
	}
	function checkyufu(st) {
		document.forms.form1.action="hotelwholeorder!checkyufu.action?typ="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	
	function hotel_hui(st) {
		document.forms.form1.action="hotelwholeorder!checkhui.action?hui="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	
function  ajax_hotelorder(id){


  $.ajax({
      type:"GET",
      url:"hotelwholeorder!ajax_hotelorder.action",
      data:{ordid:id,para:Math.floor(Math.random()*100)},
                
      success:function(data){
      
	     
	     	
	     	if(data=='OK'){
	     	alert("订单已确认成功!!!");
	     	
	     	}else{
	     	alert("订单确认失败,调用接口失败!!!如需处理,到问题订单列表处理!");
	     	}
	     	
	     	window.location.href="hotelwholeorder.action?h_state=1";
      }            
      }); 
}

function  ajax_Canhotelorder(id){


  $.ajax({
      type:"GET",
      url:"hotelwholeorder!ajax_canhotelorder.action",
      data:{ordid:id,para:Math.floor(Math.random()*100)},
                
      success:function(data){
      
	     
	     	
	     	if(data=='1'){
	     	alert("订单已 取消成功!!!");
	     	
	     	}else{
	     	alert("订单取消失败!原因:"+data);
	     	}
	     	
	     	//window.location.href="hotelwholeorder.action?h_state=1";
      }            
      }); 
}

</script>
</html>


