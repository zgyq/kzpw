<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}景区门票预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />

<link href="css/hotelimage.css" rel="stylesheet" type="text/css" />

</head>
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>


<SCRIPT src="js/hotelimage/base.js" type=text/javascript></SCRIPT>

<script type="text/javascript">
var varAddress="";
$(document).ready(function(){
  loadCityData();
  loadpic();
 lodSpot('383','杭州');

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

function bookSpotTicket(spoticketid) { 
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';
window.location.href="spotticket!tobook.jspx?SpotTicketID="+spoticketid+"&startDate="+startDate+"&endDate="+endDate;
	  }

function checkTab(index){

for(a=1;a<=2;a++){
$("#hotelinfo"+a).hide(); 
document.getElementById("tab"+a).className="f details_tille_out"; 
//$("#tab"+a).hide(); 
}
$("#hotelinfo"+index).show(); 
//$("#tab"+a).show(); 
document.getElementById("tab"+a).className="f details_tille_on"; 

}
function showcity(id){
var type=$("#hidcity").val(); 
if(type=='1'){
$("#"+id).show(); 
$("#hidcity").val("2"); 
}else{
$("#"+id).hide(); 
$("#hidcity").val("1"); 
}


}
function  lodSpot(cityid,cityname){

$("#citydiv").hide(); 
$("#hidcity").val("1"); 
$("#cityname").html(cityname); 

  $.ajax({
      type:"GET",
       url:"spotticket!GetSpotmesByCityid.jspx",
      data:{CityID:cityid,para:Math.floor(Math.random()*100)},
      beforeSend:function(){$("#AjaxHotelDiv").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐景区信息...");},             
      success:function(data){
      $("#AjaxSpotDiv").html(data);           
      }            
      }); 
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

function loadpic()
	{	
		$("#spec-list").jdMarquee({
		
			deriction:"left",
			width:220,
			height:46,
			step:2,
			speed:4, 
			delay:10,
			control:true,
			_front:"#spec-right",
			_back:"#spec-left"
		});
		$("#spec-list img").bind("mouseover",function(){
		
			var src=$(this).attr("src");
			$("#spec-n1 img").eq(0).attr({
				src:src.replace("\/n5\/","\/n1\/"),
				jqimg:src.replace("\/n5\/","\/n0\/")
			});
			$(this).css({
				"border":"2px solid #ff6600",
				"padding":"1px"
			});
		}).bind("mouseout",function(){
			$(this).css({
				"border":"1px solid #ccc",
				"padding":"2px"
			});
		});				
	}
	
	var lat = 0;
	var lng = 0;
	var hotelname = '<ww:property value="hotel.name"/>';
 				 
	<ww:if test="hotel.lat!=null">
	lat = <ww:property value="hotel.lat"/>;
	lng = <ww:property value="hotel.lng"/>;
	</ww:if>
		
	google.load("maps", "2.x");     // Call this function when the page has been loaded 
	

	function initialize() {   
		



		var map = new google.maps.Map2(document.getElementById("map"));  
		map.setCenter(new google.maps.LatLng(lat,lng), 13); 

		    function createMarker(point, number) { 
          var marker = new GMarker(point); 
          marker.value = number; 
          GEvent.addListener(marker, "click", function() {
          //需要弹出的消息
            var myHtml =hotelname+'<br/>电话:<ww:property value="hotel.tortell"/><br/>传真:<ww:property value="hotel.fax1"/>'; 
            map.openInfoWindowHtml(point, myHtml); 
          }); 
          return marker; 
        }
        var bounds = map.getBounds(); 
        var southWest = bounds.getSouthWest(); 
        var northEast = bounds.getNorthEast(); 
        var lngSpan = northEast.lng() - southWest.lng(); 
        var latSpan = northEast.lat() - southWest.lat(); 
        var point=new GLatLng(lat,lng);
        map.addOverlay(createMarker(point,1));
       
		//map.addControl(new GLargeMapControl());
      
        //为地图添加控件，如缩放，卫星地图转换
      //  map.addControl(new GLargeMapControl());
       // var mapControl = new GMapTypeControl(); 
       // map.addControl(mapControl); 

	} 
	google.setOnLoadCallback(initialize);
	
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=3&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel" style="margin-top: 51px;">
      <div id="left" class="f">
          <div class="search"><font class="black">国内景区搜索</font></div>
          <form action="spotticket!SeachSpot.jspx" method="post" name="form1" id="form1">
          <div class="box_sea searchlist">
             <ul>
           <li class="searchall mt10">游玩城市：<input type="text" id="txthotelcity" class="text_search" name="hotelcity" value="<ww:property value="GetSpotCityNmaeByID(CityID)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
          		 <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="CityID" value="<ww:property value="CityID" />"  />
           </li>
           
           <!--隐藏域 -->
          	  <li class="searchall">游玩时间：<input type="text" class="text_search" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"  /></li>
              <li class="searchall">关键字&nbsp;&nbsp;：
              <input type="text" class="text_search" id="S_SeachName" name="SeachName" value="<ww:property value="SeachName" />"  /></li>
              <li class="but">
               <span class="r mr25" style="margin-right: 85px;"><input type="submit"  class="bst" value="立即搜索"  /></span>
               <span class="c"></span>
              </li>
             </ul>
          </div>
          
          <input type="hidden" name="orderType" id="horderby" value="" /><!-- 隐藏域  排序 -->
          </form>
          
          <div class="mt7" style="display: none;">
             <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">您最近浏览过的景区</font>
                  <div class="c"></div>  
               </div>
                <ww:if test="#session.listhotelsession==null">
               <div class="box recently"><span class="f ico_recently">&nbsp;</span>您最近没有浏览过任何景区。</div>
               </ww:if><ww:else>
               <div class="box content" style=" border-top:none;">
               <ww:iterator value="#session.listhotelsession" status="ind">
                 <ul class="box_botm_xu">
                     <li>
                         <span class="f number font_fff_09"><ww:property value="#ind.index+1" /></span>
                         <a href="hotel!toHotelInfo.jspx?HotelId=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="f"><ww:property value="name" /></a>
                         <font class="r font_f60_c">&yen;<ww:property value="startprice" /></font>
                         <div class="c"></div>
                     </li>
                     
                     <div class="nohave6 c">&nbsp;</div>
                 </ul>
                 </ww:iterator>
                </div> 
               </ww:else>
			</div>
			<div class="mt7"><img src="images/spotticket/ad_spotticket_02.jpg" width="260" height="100" /></div> 
			<div class="mt7">
              <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">景区预订排行</font>
                  <div class="r pr20 floatall" style="display: none">
                    <div class="city_on" onclick="showcity('citydiv');" ><span id="cityname">北京</span><span class="ico_triangle">&nbsp;</span></div>
                    <input type="hidden" id="hidcity" value="1" /><!-- 1,显示   2隐藏 -->
                    <div class="city_more box" style="display: none" id="citydiv">
                      <ul>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('607','北京');" >北京</a></li>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('321','上海');" >上海</a></li>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('80','广州');" >广州</a></li>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('91','杭州');" >杭州</a></li>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('224','南京');" >南京</a></li>
                      <li class="f mf10"><a href="javascript:void(0)" onclick="lodhotel('192','武汉');" >武汉</a></li>
                      </ul>
                     </div>
              </div>
                  <div class="c"></div>  
               </div>
               <div id="AjaxSpotDiv">
              
              </div>
             </div>       
      </div>
 <div id="list" class="r">

    <div>
       <font class="f biger000"><ww:property value="hotel.name" /></font>
       <span class="r spot_status_two">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="details_tille mt7">
      <ul>
       <li id="tab1" class="f details_tille_on" onclick="checkTab(1);"><a href="#">门票预订</a></li>
       <!--
       <li id="tab3" class="f details_tille_out" onclick="checkTab(3);"><a href="#">酒店照片</a></li>
      
       <li id="tab2" class="f details_tille_out" onclick="checkTab(2);"><a href="#">门票点评</a></li>
        -->
      </ul>
    </div>
    <!-- 酒店基本信息 -->
    <div id="hotelinfo1">
    <div class="box_ccc c" style="width:100%;">
      <div class="introduction_left f">
         <ul>
         <li>
         <p><ww:property value="hotel.description" /></p>
         </li>
         <li class="mt10"><span class="ico_start">&nbsp;</span>景区名称：<b><ww:property value="spotmes.name"/></b></li>
         
         <li><span class="ico_start">&nbsp;</span>景区特点：<ww:property value="spotmes.sid"/></li>
         <li><span class="ico_start">&nbsp;</span>景区地址：<ww:property value="spotmes.address" /><span class="ico_phone">&nbsp;</span><a href="#" class="l06c">发送到手机</a></li>
          <li><span class="ico_start">&nbsp;</span>预订说明：<ww:property value="spotmes.ticketnotic" /></li>
         </ul>
         <div class="nohave"></div>
         <div class=" box"></div>
         
      </div>
      <div class="introduction_right r">
         <div class="box hotel_img">
      <div id=preview >
	<div class=jqzoom id=spec-n1 style="width:220px; height: 202px; ">
	<table style="width: 100%; height: 100%">
		<tr>
			<td valign="middle" style="" align="center"><IMG 
	src="<ww:if test="listimage==null||listimage.size==0">images/NoImage.gif</ww:if>
	<ww:else>http://upload.17u.com/uploadfile/<ww:property value="spotmes.minipics"/></ww:else>" style="margin-top:0px; margin-left: -5px;height:186px;width:206px;">
	</td>
		</tr>
	</table>
	</div>
	<div id=spec-n5>
		<div class="control" id=spec-left >
			
			<img src="images/left2.gif" />
		</div>
		<div id=spec-list style="width:180px; overflow: hidden;" >
			<ul class=list-h style="width:158px;">
	<ww:iterator value="listimage" status="index">
        <li ><img src="http://upload.17u.com/uploadfile/<ww:property />" /></li>
     </ww:iterator>
			
			</ul>
		</div>
		<div class="control" id=spec-right >
			<img src="images/right2.gif" />
		</div>
		
    </div>
</div>


       
         </div>
         
       
      </div>
      <div class="c"></div>
    </div>
    <div class="c"></div>
    <div class="mt7 ">  
    <form action="hotel!toHotelInfo.jspx" method="post" name="form2" id="form2">   
    			 <input type="hidden" id="city_from_" name="HotelId" value="<ww:property value="hotel.id"/>" />
			   <input type="hidden" id="hidcityid" value="<ww:property value="cityId"/>" />
				<input type="hidden" id="hidhotelcode" value="<ww:property value="hotel.hotelcode"/>" />
				<input type="hidden" id="hidhotelid" value="<ww:property value="hotel.id"/>" />
				<input type="hidden" id="hidstime" value="<ww:property value="startDate"/>" />
				<input type="hidden" id="hidendtime" value="<ww:property value="endDate"/>" />
				<input type="hidden" id="hidcitycode" value="<ww:property value="s_citycode"/>" />
				
				
       <div class="">
           <div class="f list_top_left">&nbsp;</div> 
           <div class="f list_top list_bg">
               <div class="f"><a href="#" class="c09f">门票信息</a></div>
               
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
       </form>
       <div class="mt7 information list_table " id="HotelRoomPrice">
       
       <table width="710" border="1" cellspacing="0" cellpadding="0" class="box" >
          <tr>
            <th class="hadow" width="45%" scope="col">名称</th>
            <th class="hadow" width="10%" scope="col">门市价</th>
            <th class="hadow" width="10%" scope="col">现付价</th>
            <th class="hadow" width="10%" scope="col">票量</th>
            <th class="hadow" width="5%" scope="col">起订</th>
            <th class="hadow" width="10%" scope="col">检票类型</th>
            <th class="hadow" scope="col">预定</th>
          </tr>
           <form action="hotel!tobook.jspx" method="post">
           <ww:iterator value="ListSpotticket" status="index">
          <tr>
            <td class="floatall">
               <a href="#" class="l06c"><ww:property value="name" /></a>
            </td>
            <td class="font-f60-del">&yen;<ww:property value="formatMoney_string(marketprice)" /></td>
            <td class="font-f60-16">&yen;<ww:property value="shopprice" /></td>
            <td><ww:property value="limitsfznumber" /></td>
            <td><ww:property value="minnumber" /></td>
            <td>刷身份证</td>
            <td>
            <ww:if test="limitsfznumber!=null">
            <input type="button" class="bnt" value="预定" onclick="bookSpotTicket(<ww:property value="id"/>);" />
            </ww:if><ww:else>
             <input type="button" class="bnt" value="无票"  disabled="disabled"/>
            </ww:else>
            </td>
          </tr>
          </ww:iterator>
          </form>
        
        </table>
       
       </div>
    </div>  
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">详细信息</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotmes.info,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
     <div class="box mt7">
        <div class="tit"><span class="low2 black f">交通信息</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotmes.traffic,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">注意事项</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotmes.notice,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    <!--<div class="box mt7">
        <div class="tit"><span class="low2 black f">周边景点</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotmes.guidelines,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    
    --></div>
    <!-- 基本信息结束 -->  
    
     
      
    
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
<script src="js/hotelimage/lib.js" type=text/javascript></script>
<SCRIPT src="js/hotelimage/163css.js" type=text/javascript></SCRIPT>
</body>
</html>

