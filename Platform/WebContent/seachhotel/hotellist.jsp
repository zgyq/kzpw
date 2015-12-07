<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<%@page import="com.yf.system.back.server.Server"%>
<%@page import="java.util.*" %>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店列表:酒店预订,宾馆预订,特价酒店，国内酒店，国际酒店---天河联盟旅行网</title>
<link href="hstyle/index.css" type="text/css" rel="stylesheet" />
<link href="hstyle/base.css" type="text/css" rel="stylesheet" />
<link href="hstyle/hotel.css" type="text/css" rel="stylesheet" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />
<script src="js/jquery1.3.2.js" type=text/javascript></script>


<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script language="javascript" type="text/javascript" src="js/citycontrol/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_data_pp.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_date2.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	
	
	
	
<script>
function dispose(message) {
		   Ext.MessageBox.show({
		           msg: message+', 请稍后......',
		           progressText: 'Saving...',
		           width:300,
		           wait:true,
		           waitConfig: {interval:600},
		           icon:'ext-mb-download',
		           animEl: 'mb7'
		       });
		}
		
		function colsedispose(){
		 Ext.MessageBox.hide();
		}
		
		
function yud(roomid,hotelid,cityId) { 
  dispose('系统正在为您查询实时信息');	
  
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';
window.location.href="hoteluserbook!toyuding.action?regionid=<ww:property value='regionid'/>&hotelid="+hotelid+"&roomid="+roomid+"&startDate="+startDate+"&endDate="+endDate;
	  }
function showAllroom(el){
	var nl  = el.parentNode.previousSibling.childNodes;
	for(var i=0; i<nl.length;i++){
		nl[i].style.display = 'block';
	}
	el.parentNode.innerHTML = '<a href="javascript:void(0)" onclick="hideAllroom(this)">隐藏房型▲</a>';
}

function hideAllroom(el){
	var nl  = el.parentNode.previousSibling.childNodes;
	for(var i=2; i<nl.length;i++){
		nl[i].style.display = 'none';
	}
	el.parentNode.innerHTML = '<a href="javascript:void(0)" onclick="showAllroom(this)">全部房型▼</a>';
}


</script>
<script type="text/javascript">
$(document).ready(function(){
      
      loadCityData();
     
});

function seach(){
	  dispose('系统正在为您查询实时信息');		 		        
    document.form1.submit();
}
</script>
</head>
<body>

<div id="container" style="margin-top: 10px; width: 94%">
<div id="content" style="width: 100%;">
<div >
 
<div >

<form action="hoteluserbook!sousuo.action" method="post" name="form1"
	id="form1">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
	height="236">
	<tr>
<td  ><img src="images/sss3.gif" /></td>	
	<td width="100%" style="background: url('images/sss2.gif');">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	height="236" >
	<tr><td colspan="3"><div
	style="background: url(images/ksdf.gif); height: 38px;width: 235px; margin: 0 auto; margin-top: 13px ">
&nbsp;</div></td></tr>
	<tr>
      <td width="23">&nbsp;</td>
		<td>
		<table width="100%" cellpadding="0" cellspacing="0" border="0" class="searchh" style="height: 120px;"  >
			<tr>
				<td align="right"><strong><span style="color: red;">*</span>选择城市</strong></td>
				<td>
                   <input type="text" class="input198" id="txthotelcity" name="hotelcity" value="<ww:property value="getCityNameByStr(cityId)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " /> 
                   <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="<ww:property value="cityId" />"  />
		       </td>
		       <td align="right" width="100"><strong>关键字</strong></td>
				<td><input type="text"  maxlength="10" class="input198" name="hotelName" value="<ww:property value="hotelName"/>" /></td>
			</tr>
			<tr>
				<td align="right" ><strong><span style="color: red;">*</span>入住时间</strong></td>
				<td ><input type="text" class="Wdate input198" id="txtcheckindate"
					name="startDate" value="<ww:property value="startDate"/>"
					onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})" />
				</td>
			
				<td align="right"><strong><span style="color: red;">*</span>离店时间</strong></td>
				<td><input type="text" class="Wdate input198" id="txtcheckoutdate"
					name="endDate" value="<ww:property value="endDate"/>"
					onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
				</td>
			
				
			</tr>

			 <tr>
                       
			
				<td align="right"><strong>价格范围</strong></td>
				 <td>
                    <select id="ddlprice" name="s_price" style="width:126px">
                   
                      <option vlaue="0" <ww:if test="s_price=='不限'">selected</ww:if>>不限</option>
                      <option vlaue="1" <ww:if test="s_price=='RMB 250以下'">selected</ww:if>>RMB 250以下</option>
                      <option vlaue="2" <ww:if test="s_price=='RMB 250-400'">selected</ww:if>>RMB 250-400</option>
                      <option vlaue="3" <ww:if test="s_price=='RMB 400-600'">selected</ww:if>>RMB 400-600</option>
                      <option vlaue="4" <ww:if test="s_price=='RMB 600-800'">selected</ww:if>>RMB 600-800</option>
                      <option vlaue="5" <ww:if test="s_price=='RMB 800以上'">selected</ww:if>>RMB 800以上</option>
                    </select>
                </td>
                 <td align="right"><strong>星级范围</strong></td>
				 <td>
                    <select id="ddlprice" name="s_hotelstar" style="width:126px">
                   
                      <option value="0" <ww:if test="s_hotelstar=='0'">selected</ww:if>>不限</option>
                      <option value="1" <ww:if test="s_hotelstar=='1'">selected</ww:if>>一星级</option>
                      <option value="2" <ww:if test="s_hotelstar=='2'">selected</ww:if>>二星级</option>
                      <option value="3" <ww:if test="s_hotelstar=='3'">selected</ww:if>>三星级</option>
                      <option value="4" <ww:if test="s_hotelstar=='4'">selected</ww:if>>四星级</option>
                      <option value="5" <ww:if test="s_hotelstar=='5'">selected</ww:if>>五星级</option>
                    </select>
                </td>
			</tr>
		</table>
		</td>
        <td width="23">&nbsp;</td>
	</tr>
	<tr>
	<td colspan="3" class="he3">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" background="images/bj_tj.gif" width="100%" height="40" style="padding: 0">
		<div class="tijiao"><input type="button" value="立即搜索" onclick="seach()" class="button_tj" /></div>
		</td>
	</tr>
	<tr><td colspan="3" height="10px;">&nbsp;</td></tr>
</table>
</td>
<td  style="background: url('images/sss2.gif');"><img src="images/sss4.gif" width="23" /></td>
</tr>
</table>
</form>
</div>
 
<div class="c"></div>
 



<!-------------搜索结束------------->


<!-- 推荐酒店 -->

</div>
<!------------left 结束------------->
<div style="width: 100%; margin-top: 10px;">
<div class="seachhh"
	style=" line-height: 24px; width:90%; background: #D8EAF4; padding: 0 10px 0 10px; float: left">
<font class="f" style="color: #0E548A"> 根据（<ww:property value="searchInfo"/>）查询 共 <ww:property
	value="pageinfo.totalrow" /> 间酒店</font> <b class="r"><ww:property
	value="startDate" />～<ww:property value="endDate" /> 共<ww:property
	value="s_num" />晚</b> <span class="c"></span></div>
<div class="c"></div>
<!--隐藏域 -->
<input type="hidden" id="hidstime" value="<ww:property value="startDate"/>" />
<input type="hidden" id="hidendtime" value="<ww:property value="endDate"/>" />
<input type="hidden" id="hidcitycode" value="<ww:property value="s_citycode"/>" />

<ww:iterator value="hotelList" status="state">
<input type="hidden" id="hidhotelcode_<ww:property value="#state.index"/>" value="<ww:property value="hotelcode"/>" />
<input type="hidden" id="hidhotelid_<ww:property value="#state.index"/>" value="<ww:property value="id"/>" />

    <span id="lowHotelSpan_<ww:property value="#state.index"/>"></span>
	<div class="jiudian">
	<div class="chang_list"><b class=" f"> 
	
	<a class="lan_14" 
		href="hoteluserbook!toDetail.action?hotelid=<ww:property value="id"/>&cityId=<ww:property value="cityId"/>&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>&"
		class="lan14_cu"> <ww:property value="name" /></a>
		
		 </b><font class="r" style="color:#999999">地
	址：
	<ww:if test="address.length()>25">
	<ww:property value="SubString(address,20)" />...
	</ww:if><ww:else>
	<ww:property value="address" />
	</ww:else>
	
	</font></div>
	<div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td rowspan="4" height="90" width="124">
			<div class="box" style="padding: 1px; width: 124px; height:76px;">
			
			<!--<img src="http://www.elongstatic.com/imageapp/hotels/hotelimages<ww:property value="getImageWG(id)"/>" width="124" height="76" />	
				-->
				  <img src="<ww:property value="getImageSRc(id)"/>"  width="124" height="76" />
				</div>
			</td>
			<td class="he5">&nbsp;</td>
			<td rowspan="4" width="124" align="center">
			<span>
			
			</span></td>
		</tr>
		<tr>
			<td valign="top" title="<ww:property value="description"/>" ><ww:property
				value="SubString(description,160)" />...</td>
		</tr>
		<tr>
			<td>酒店星级:
			<ww:if test="star==null||star==0">
			<span style="color: red">经济型</span>
			</ww:if>
			<ww:else>
			<ww:property value="getStarico(star)" />
			</ww:else>
		
			</td>
		</tr>
		
		
	</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="HotelRoomPrice_<ww:property value="#state.index"/>"
	style="line-height: 35px; text-align: center; border-collapse: collapse;">
	<!--
	<tr bgcolor="#537cb4" class="hui14">
		<td width="25%" class="box_r">客房类型</td>
		<td width="10%" class="box_r">门市价</td>
		<td width="10%" class="box_r">首日价</td>
		<td width="15%" class="box_r">首日返利</td>
		<td width="15%" class="box_r" >床型</td>
		<td width="10%" class="box_r">早餐</td>
		<td width="10%" class="box_r">宽带</td>
		
		<td class="box_r">操作</td>
	</tr>
	
			
			<span id="HotelRoomPrice_<ww:property value="#state.index"/>" >
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
			</tr>
			<tr>
			<td colspan="5">
			<span style="color: red;">正在努力为你查询酒店房型信息!<img src='images/loadding.gif' /></span>
			</td>
			</tr>
			</span>
			
		
		
	
	
-->
</table>
	</div>
	</div>

</ww:iterator>
	<div class="fenye_p" style="width:100%"><ww:property value="getPagination('\"hoteluserbook!sousuo.action?pageinfo.pagenum=\"+pageno+\"\"')"/></div>
</div>
</div>

</div>



</body>
</html>
<script language="javascript">	
	
	 $("span[id*='lowHotelSpan_']").each(function(i){
     	
        $.ajax({
	         type:"POST",
	         url:"hoteluserbook!findHotelRoomPrice_ELONG.action",
	         data:{s_citycode:$("#hidcitycode").val(),s_hotelcode:$("#hidhotelcode_"+i).val(),s_stime:$("#hidstime").val(),s_endtime:$("#hidendtime").val(),s_hotelid:$("#hidhotelid_"+i).val()},
	         beforeSend:function(){$("#HotelRoomPrice_"+i).html("<img src='images/loadding.gif' />")},
	         async:false,              
	         success:function(data){
	       	// alert(data);
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         $("#HotelRoomPrice_"+i).html(data);
	         
	         }            
	         });
       });
	
	
</script>

<script>	
function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}
function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}
function showrooom(hid,len){
   if(len>2){
	   for(i=2;i<=len;i++){
	   	document.getElementById(hid+"_"+i).style.display = 'block';
	   }
	   document.getElementById(hid+"_td1").style.display = 'none';
	   	document.getElementById(hid+"_td2").style.display = 'block';
   }
}
function hidrooom(hid,len){

   if(len>2){
	   for(i=3;i<=len;i++){
	   	document.getElementById(hid+"_"+i).style.display = 'none';
	   }
	   	document.getElementById(hid+"_td2").style.display = 'none';
	   	document.getElementById(hid+"_td1").style.display = 'block';
   }
}
</script>