<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}门票订单列表</title>

<link href="skin/blue/css/login.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/airlines.css" rel="stylesheet" type="text/css" />

<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>

</head>
<script type="text/javascript">

$(document).ready(function(){
  loadCityData();
 
});
function loadCityData()
{

 $.ajax({
       type:"POST",
       url:"spotticket!GetSpotCity.jspx",
       async:false,     
       success:function(data)
       {    
         varAddress=data;
       }            
  });
 // alert(varAddress);
}
//一下2个位日期控件用
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
</script>

<body>
<div>
	<div class="cen" style=" position:relative;">
	<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
    <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
    
    
    <form action="login!toSpotTicketOrder.jspx" name="form1" id="form1" method="post">
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单列表</li>
            <li class="mation_info" style="display: none"><font class="mation_left f" ><b>共有<font class="fontxing">5</font>条订单</b></font><span class="f mr25">取消订单（<font class="fontxing">3</font>）</span><font class=" f mr25">完成订单（<font class="fontxing">3</font>）</font> <font class="f90 f ">待支付订单（<font class="fontxing">3</font>）</font> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div>
       <div class="mt7 box">
        <div class="title">
               <font class="black low f mr15">订单列表</font>
              <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td  class="hadow hl24" align="right" width="20%">门票名称：</td>
                <td><input type="textg"  class="text_number" name="HotelName" value="<ww:property value="HotelName"/>"  /> </td>
                <td class="hadow" align="right" width="20%">所在城市：</td>
                <td><input type="textg"  class="text_number" id="txthotelcity" value="<ww:property value="getCityNameByStr(CityID)"/>" onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
                	 <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="CityID" value="<ww:property value="CityID"/>"  />
                </td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">游玩时间：</td>
                <td><input type="textg"  class="text_number" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',maxDate:'%y-#{%M+0}-#{%d+0}'})"  /></td>
                <td class="hadow" align="right" width="20%">联系人：</td>
                <td><input type="textg"  class="text_number" name="GuestName" value="<ww:property value="GuestName" />"  /></td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">订单编号：</td>
                <td><input type="textg"  class="text_number" name="OrderNO" value="<ww:property value="OrderNO" />"  /></td>
                <td class="hadow" align="right" width="20%">联系电话：</td>
                <td><input type="textg"  class="text_number" name="LinkMobeil" value="<ww:property value="LinkMobeil" />" /></td>
              </tr>
            </table>
            <div class="search"> <input type="submit" value="立即查询" class="button_searchmeb"  /></div>
            <!--listsearch over-->
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td class="hadow hl24">订单号</td>
                <td class="hadow">城市</td>
                <td class="hadow">景点名称</td>
                <td class="hadow">门票名称</td>
                <td class="hadow">游玩时间</td>
                <td class="hadow">购买数量</td>
                <td class="hadow">价格</td>
                <td class="hadow">状态</td>
              </tr> 
              <ww:iterator value="ListSpotTicketOrder" status="ind">
              <tr>
                <td><a href="login!toSpotOrderInfo.jspx?SoptOrderID=<ww:property value="id"/>" class="l06c"><ww:property value="param1"/></a></td>
                 <td> <ww:property value="getSpotCityNameByStr(cityid)"/></td>
                <td><ww:property value="getSpotmesNameBySpotticketIDStr(spotticketid)"/></td>
                <td> <ww:property value="name"/></td>
                <td><ww:property value="stime"/></td>
                <td><ww:property value="sunm"/>张</td>
                <td><font class="font18f60">¥<ww:property value="price"/></font></td> 
                <td><font class="l06c" ><ww:if test="state==0">新订单</ww:if>
		   		<ww:elseif test="state==1">已支付</ww:elseif>
				<ww:elseif test="state==2">已完成</ww:elseif>
		      <ww:elseif test="state==3">已取消</ww:elseif>
		      <ww:else>待确认</ww:else></font></td>   
              </tr>
              </ww:iterator>
              
            </table>
            <div align="right">
           <ww:property value="getPagination('\"login!toSpotTicketOrder.jspx?pageinfo.pagenum=\"+pageno')"/>
   			</div>
        </div>
       </div> 
       
   </div>
   </form>
</div>
 <ww:include page="../footer.jsp"/> 
</body>
</html>
