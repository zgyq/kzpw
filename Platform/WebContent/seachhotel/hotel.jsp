<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>


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
//		$(document).ready(function() {
			
//			$("#form1").validationEngine();
		
//		});
</script>

<script type="text/javascript">
$(document).ready(function(){
     
      loadCityData();
});

function seach(){
 				//	$("#t_aftersub").show();
			    //    $("#form1").hide();
	  dispose('系统正在为您查询实时信息');		        
    document.form1.submit();

}

</script>
</head>

<body>

<div id="container" style="margin-top: 10px; width: 94%" >
<div id="content" style="width: 100%">
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
                   <input type="text" class="input198" id="txthotelcity" name="hotelcity" value="北京"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " /> 
                   <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="607"  />
		       </td>
		       <td align="right" width="100"><strong>关键字</strong></td>
		       
				<td><input type="text"  maxlength="10" class="input198" name="hotelName" value="" /></td>
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
			
				<input type="hidden" name="usertype" value="<ww:property value="usertype"/>"  />
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
                    <select id="s_hotelstar" name="s_hotelstar" style="width:126px">
                   
                   
                      <option value="0">不限</option>
                      <option value="1">一星级</option>
                      <option value="2">二星级</option>
                      <option value="3">三星级</option>
                      <option value="4">四星级</option>
                      <option value="5">五星级</option>
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

<!-- 推荐酒店结束 -->


<!-- 最新活动 -->

<!--最新活动结束--></div>
<!------------left 结束------------->

</div>
</div>

</div>

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
				<p class="font_green_14 STYLE1"><strong>正在为您实时查询酒店信息,请稍等！</strong></p>
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
