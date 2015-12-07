<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}酒店预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />

<link href="css/hotelimage.css" rel="stylesheet" type="text/css" />

</head>
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_data_pp.js"></script>


<SCRIPT src="js/hotelimage/base.js" type=text/javascript></SCRIPT>
<script type="text/javascript"
	src="http://www.google.com/jsapi?key=AIzaSyD2-qRfev2N4vz6oTHApmzA6PoXhoub_pg"></script>
<script type="text/javascript">

$(document).ready(function(){
  loadCityData();
  loadpic();
  lodhotel('15495','北京');

});

function bookhotel(roomid,hotelid) { 
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';

window.location.href="hotel!tobook.jspx?HotelId="+hotelid+"&RoomTypeid="+roomid+"&startDate="+startDate+"&endDate="+endDate;
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

var type=document.getElementById("hidcity").value; 
if(type=='1'){
$("#"+id).show(); 
$("#hidcity").val("2"); 
}else{
$("#"+id).hide(); 
$("#hidcity").val("1"); 
}


}
function  lodhotel(hotelid,cityname){

$("#citydiv").hide(); 
$("#hidcity").val("1"); 
$("#cityname").html(cityname); 

  $.ajax({
      type:"GET",
       url:"hotel!GetHotel.jspx",
      data:{strHotelCity:hotelid,para:Math.floor(Math.random()*100)},
      beforeSend:function(){$("#AjaxHotelDiv").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐酒店信息...");},             
      success:function(data){
      $("#AjaxHotelDiv").html(data);           
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
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel">
      <div id="left" class="f">
          <div class="search"><font class="black">国内酒店搜索</font></div>
          <form action="hotel!Seach.jspx" method="post" name="form1" id="form1">
          <div class="box_sea searchlist">
             <ul>
           <li class="searchall mt10">入住城市：<input type="text" id="txthotelcity" class="text_search" name="hotelcity" value="<ww:property value="getCityNameByStr(cityId)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
          		 <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="<ww:property value="cityId" />"  />
           </li>
           <li class="searchall">入住时间：<input type="text" class="text_search" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"  /></li>
           <li class="searchall">离店时间：<input type="text" class="text_search"  id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"/></li>
           <li class="searchall">酒店星级：
           <select name="s_star" class="sel_search">
           <option value="0" >-----所有星级------</option>
           <option value="1" >-------经济型-------</option>
           <option value="2" >-------二星级-------</option>
           <option value="3" >-------三星级-------</option>
           <option value="4" >-------四星级-------</option>
           <option value="5" >-------五星级-------</option>
           </select></li>
           <li class="searchall">价额范围：
           <select name="s_price" class="sel_search">
         				  <option value="0"  >不限</option>  
                          <option value="1"  >RMB 250以下</option>
                          <option value="2"  >RMB 250-400</option>
                          <option value="3"  >RMB 400-600</option>
                          <option value="4"  >RMB 600-800</option>
                          <option value="5"  >RMB 800以上</option>
           </select>
           <!--
           <input type="text" class="text_searchwf"  /><input type="text" class="text_searchwf"  />
           -->
           </li>
              <li class="searchall">关&nbsp;&nbsp;键&nbsp;字：
              <input type="text" class="text_search" id="s_hotelName" name="hotelName" value="<ww:property value="hotelName" />"  /></li>
              <li class="but">
               <span class="f">全国<font class="f90"><ww:property value="citynum" />个</font>城市，<br/><font class="f90"><ww:property value="hotelnum" /></font>余家酒店。</span>
               <span class="r mr25"><input type="submit"  class="bst" value="立即搜索"  /></span>
               <span class="c"></span>
              </li>
             </ul>
          </div>
          <input type="hidden" name="orderType" id="horderby" value="" /><!-- 隐藏域  排序 -->
          </form>
          <!-- <div class="searchbot"></div> -->
          <!-- <div class="mt7"><img src="images/ad_260_60.jpg" width="260" height="60" title="地图上找酒店，精彩尽在于此。" /> </div> -->
          <div class="mt7">
             <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">您最近浏览过的酒店</font>
                  <div class="c"></div>  
               </div>
                <ww:if test="#session.listhotelsession==null">
               <div class="box recently"><span class="f ico_recently">&nbsp;</span>您最近没有浏览过任何酒店。</div>
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
                     <li class="content_lh" style="display: none">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6 c">&nbsp;</div>
                 </ul>
                 </ww:iterator>
                </div> 
               </ww:else>
			</div>
			<div class="mt7"><img src="images/hotel/ad_hotel_01.jpg" width="260" height="100" /></div> 
			<div class="mt7">
              <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">酒店点评排行</font>
                  <div class="r pr20 floatall">
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
               <div id="AjaxHotelDiv">
              
              </div>
              <!--<div class="box content">
                 <ul class="box_botm_xu">
                     <li>
                         <span class="f number font_fff_09">1</span>
                         <a href="#" class="f">北京如家快捷酒店</a>
                         <font class="r font_f60_c">&yen;333</font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6 c">&nbsp;</div>
                 </ul>
                 <ul class="box_botm_xu mt7">
                     <li>
                         <span class="f number font_fff_09">2</span>
                         <a href="#" class="f">北京如家快捷酒店</a>
                         <font class="r font_f60_c">&yen;333</font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6"></div>
                 </ul>
                 <ul class="box_botm_xu mt7">
                     <li>
                         <span class="f number font_fff_09">3</span>
                         <a href="#" class="f">北京如家快捷酒店</a>
                         <font class="r font_f60_c">&yen;333</font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6"></div>
                 </ul>
                 <ul class="box_botm_xu mt7">
                     <li>
                         <span class="f number font_fff_09">4</span>
                         <a href="#" class="f">北京如家快捷酒店</a>
                         <font class="r font_f60_c">&yen;333</font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6"></div>
                 </ul>
                 <ul class=" mt7">
                     <li>
                         <span class="f number font_fff_09">5</span>
                         <a href="#" class="f">北京如家快捷酒店</a>
                         <font class="r font_f60_c">&yen;333</font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                 </ul>
               </div>
            --></div>       
      </div>
 <div id="list" class="r">

    <div>
       <font class="f biger000"><ww:property value="hotel.name" /></font>
       <span class="r status_two">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="details_tille mt7">
      <ul>
       <li id="tab1" class="f details_tille_on" onclick="checkTab(1);"><a href="#">客房预订</a></li>
       <!--
       <li id="tab3" class="f details_tille_out" onclick="checkTab(3);"><a href="#">酒店照片</a></li>
       
       <li id="tab2" class="f details_tille_out" onclick="checkTab(2);"><a href="#">酒店点评</a></li>
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
         <li class="mt10"><span class="ico_start">&nbsp;</span>开业时间：<ww:property value="formatDate(hotel.opendate)" /></li>
         <li><span class="ico_start">&nbsp;</span>酒店星级：
         
         <ww:if test="hotel.star==null||hotel.star==0">
			<span style="color: red">经济型</span>
			</ww:if>
			<ww:else>
			<ww:property value="getStarico(hotel.star)" />
			</ww:else>
         </li>
         <li><span class="ico_start">&nbsp;</span>区&nbsp;&nbsp;&nbsp;域：<ww:property value="getRegionNameByStr(hotel.regionid2)" /></li>
         <li><span class="ico_start">&nbsp;</span>酒店地址：<ww:property value="hotel.address" /><span class="ico_phone">&nbsp;</span><a href="#" class="l06c">发送到手机</a></li>
         <li style="display: none"><span class="ico_start">&nbsp;</span>酒店销量：最近一个月内共有<font class="f90c">11</font>人预定该酒店。</li>
         </ul>
         <div class="nohave"></div>
         <div class=" box"></div>
         <div style="display: none">
           <div class="f box comment_left">
              <ul class="comment">
              <li><font class="font-f60-16 mf31">96%</font>好评</li>
              <li><span class="comment_line">&nbsp;</span></li>
              <li><span class="comment_star">&nbsp;</span></li>
              <li class="mt10"><a href="#" class="l06c mf15">查看点评：</a>（65条）</li>
              <li><a href="#" class="l06c mf15">我要点评</a></li>
              <li>&nbsp;</li>
              </ul>
           </div>
           <div class="r comment_right" >
            <ul>
            <li class=" mt20">住店客人评价到：<font class="f90">"由于出差办事，临时找了一个住处， 但是入住后，条件还是不错的，"</font></li>
            <li class="text_right f00">—&nbsp;—&nbsp;获得10元点评奖金。</li>
            <li >住店客人评价到：<font class="f90">"由于出差办事，临时找了一个住处， 但是入住后，条件还是不错的，"</font></li>
            <li class="text_right f00">—&nbsp;—&nbsp;获得10元点评奖金。</li>
            </ul>
           </div>
           <div class="c"></div>
         </div>
      </div>
      <div class="introduction_right r">
         <div class="mt10" id="map" style="width: 213px; height:181px">
         <!--
         <img src="images/map.png" width="213" height="181" />
         -->
         </div>
         
         <div class="box hotel_img">
         
         
      <div id=preview >
	<div class=jqzoom id=spec-n1 style="width:220px; height: 202px; ">
	<table style="width: 100%; height: 100%">
		<tr>
			<td valign="middle" style="" align="center"><IMG 
	src="<ww:if test="ListHotelimage==null||ListHotelimage.size==0">images/NoImage.gif</ww:if>
	<ww:else>http://www.elongstatic.com/imageapp/hotels/hotelimages<ww:property value="getImgPath2(ListHotelimage.get(0).path)"/></ww:else>" style="margin-top:0px; margin-left: -5px;height:186px;width:206px;">
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
	<ww:iterator value="ListHotelimage" status="index">
        <li ><img src="http://www.elongstatic.com/imageapp/hotels/hotelimages<ww:property value="getImgPath2(path)"/>" /></li>
     </ww:iterator>
			
			</ul>
		</div>
		<div class="control" id=spec-right >
			<img src="images/right2.gif" />
		</div>
		
    </div>
</div>


         <!--
         <img src="images/hotel_img.png" width="208" height="202" />
         -->
         </div>
         
         <a  target="_blank" href="hotel!toallimages.jspx?HotelId=<ww:property value="hotel.id"/>" class="l06c">更多酒店图片</a>
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
               <div class="f"><a href="#" class="c09f">房型与房价</a></div>
               <div class="r">
               入住日期：<input type="text" class="text_nameorder" id="txtcheckindate2" name="startDate" value="<ww:property value="startDate"/>" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate3.focus();}})" /> 
               离店日期：<input type="text" class="text_nameorder" id="txtcheckoutdate3" name="endDate"  value="<ww:property value="endDate"/>" onfocus="this.value=getDateDiff($('#txtcheckindate2').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate3\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
               <!--
             
            <input type="hidden" id="city_from_hide" name="cityId" value="<ww:property value="cityId"/>" />
			-->
			  
			   
               <input type="button"  value="修改" class="bnt_new fff hand"  onclick="seachto();" /></div>
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
       </form>
       <div class="mt7 information list_table " id="HotelRoomPrice">
       <!--
       <table width="710" border="1" cellspacing="0" cellpadding="0" class="box" style="display: none">
          <tr>
            <th class="hadow" width="20%" scope="col">房型</th>
            <th class="hadow" width="15%" scope="col">门市价</th>
            <th class="hadow" width="15%" scope="col">前台现付价</th>
            <th class="hadow" width="15%" scope="col">点评奖金</th>
            <th class="hadow" width="10%" scope="col">早餐</th>
            <th class="hadow" width="10%" scope="col">宽带</th>
            <th class="hadow" scope="col">预定</th>
          </tr>
           <form action="hotel!tobook.jspx" method="post">
           <ww:iterator value="mapRoom.get(hotel.id)" status="index">
          <tr>
            <td class="floatall">
                <span class="ico_room">&nbsp;</span><a href="#" class="l06c"><ww:property value="name" /></a>
                 床型图片 
                <div class="float_room msg" style="display:none;">
                  <ul class="msgul">
                  <li class=" pt5"><img src="images/hotel.jpg" width="90" height="80" /></li>
                  <li>高级双人床</li>
                  </ul>
                </div>    
            </td>
            <td class="font-f60-del">&yen;<ww:property value="formatMoney_string(getdeptprice2(RoomListPrice.get(id).get(0)))" /></td>
            <td class="font-f60-16">&yen;<ww:property value="RoomListPrice.get(id).get(0)" /></td>
            <td><span class="main_give f90 f mf15">&yen;20</span></td>
            <td><ww:property value="breakfast" /></td>
            <td><ww:property value="wideband" /></td>
            <td>
            <ww:if test="state==0">
            <input type="button" class="bnt" value="预定" onclick="bookhotel(<ww:property value="id"/>,<ww:property value="hotel.id"/>);" />
            </ww:if><ww:else>
             <input type="button" class="bnt" value="满房"  disabled="disabled"/>
            </ww:else>
            </td>
          </tr>
          </ww:iterator>
          </form>
        
        </table>
       -->
       </div>
    </div>  
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">服务设施</span></div>
        <div class="service">
                 <div class="nohave"></div>
                 <table width="690" border="0" cellspacing="0" cellpadding="0">
                      <tr >
                        <td class="box_botm_xu" width="120" ><span class="f number font_fff_09 mf5">1</span>
                         <b>附加选择</b></td>
                        <td class="box_botm_xu">自助早餐价格。</td>
                      </tr>
                       <tr>
                        <td class="box_botm_xu"><span class="f number font_fff_09 mf5">2</span>
                         <b>可接收卡类型</b></td>
                        <td class="box_botm_xu"><ww:property value="hotel.carttype" /></td>
                      </tr>
                      <tr>
                        <td class="box_botm_xu"><span class="f number font_fff_09 mf5">3</span>
                         <b>酒店服务项目</b></td>
                        <td class="box_botm_xu"><ww:property value="hotel.serviceitem" /></td>
                      </tr>
                      <tr>
                        <td class="box_botm_xu"><span class="f number font_fff_09 mf5">4</span>
                         <b>酒店餐饮设施</b></td>
                        <td class="box_botm_xu"><ww:property value="hotel.footitem" /></td>
                      </tr>
                      <tr>
                        <td><span class="f number font_fff_09 mf5">5</span>
                         <b>娱乐健身设施</b></td>
                        <td><ww:property value="hotel.playitem" /></td>
                      </tr>
                      
                      <tr>
                        <td><span class="f number font_fff_09 mf5">6</span>
                         <b>周边交通</b></td>
                        <td><ww:property value="hotel.trafficinfo" /></td>
                      </tr>
                    </table>
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7" style="display: none">
        <div class="tit"><span class="low2 black f">酒店点评</span></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave"></div>
    </div>  
    </div>
    <!-- 基本信息结束 -->  
    <!-- 图片开始 -->
    <div id="hotelinfo3" style="display: none">
    
     <div class="box_ccc hotelimage">
     <ww:include page="../index.html"/>
     <!-- 
       <iframe src="../hotelimage.html" height="710" width="710" frameborder="0" hspace="0" scrolling="no"></iframe>
    	-->
    </div>   
    
    </div>
    <!-- 图片结束 -->
    <!-- 酒店点评开始 -->
    <div id="hotelinfo2" style="display: none">
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">酒店点评</span></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave box_botm_xu"></div>
        <div class="evaluate">
              <div class="f bonus">
              <div class="bonus_main font-f60-16">10元</div>
              </div>
              <div class="f ecaluate_right">
                <ul>
                <li class="c999">1370101**** 于 2011-12-6 18:44:00 发表点评:</li>
                <li class="font-06f-24c ecaluate_main">"一般，不是很干净，不过对得起这个价格。"</li>
                <li>有90年代的感觉，我当日入住时竟然还等了20分钟，因为房间没收拾。在小区内，比较安静，床单很脏， 条件一般。但最重要的，对得起这个价格。</li>
                <li>点评房型：标准间C</li>
                <li>适合群体：大众</li>
                </ul>
              </div>
              <div class="c"></div>
        </div>
        <div class="nohave"></div>
    </div>  
    
    </div>
    <!-- 酒店点评结束 -->
    <!-- 酒店地图开始 -->
     <div id="hotelinfo4" style="display: none">
      <div class="box_ccc">
      <img src="images/hotellocation.jpg" width="730" height="417" style="margin:1px 1px 1px 2px;" />
    </div>    
    <div class="box mt7" style="width:100%;">
        <div class="tit"><span class="f low2">&nbsp;</span><font class="black">交通距离</font><div class="c"></div> </div>
         <div class="content ">
               <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">距首都机场   [小提示：了解机场大巴路线]</a>
                         <span class="r">约18.63公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <div class="c"></div>
           </div>       
    </div>
     </div>
     <!-- 地图结束 -->
        <!-- 酒店地标开始 -->
     <div id="hotelinfo5" style="display: none">
     <div class="box_ccc" style="width:100%;">
         <div class="content_landmark">
               <div class="box_botm"><span class="f ico_landmark">&nbsp;</span><span class="black">商务地标</span></div>
               <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <div class="c"></div>
           </div>    
           <div class="content_landmark ">
               <div class="box_botm"><span class="f ico_landmark">&nbsp;</span><span class="black">商务地标</span></div>
               <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <div class="c"></div>
           </div>    
           <div class="content_landmark ">
               <div class="box_botm"><span class="f ico_landmark">&nbsp;</span><span class="black">商务地标</span></div>
               <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li>
                         <font class="f90c f">></font><a href="#" class="f l06c">中健科写字楼</a>
                         <span class="r">约0.23公里</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <div class="c"></div>
           </div>    
              
    </div>
     </div>
     <!-- 地标结束 -->
     
       <!-- 周边开始 -->
     <div id="hotelinfo6" style="display: none">
        <div class="box_ccc">
      <img src="images/periphery.jpg" width="730"  height="387" style="margin:2px 1px 1px 2px;" />
    </div>    
    <div class="box mt7" style="width:100%;">
        <div class="tit"><span class="f low2">&nbsp;</span><font class="black">附近3公里内其他酒店</font><div class="c"></div> </div>
         <div class="content ">
               <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="box_botm_xu r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="f">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>
                 <ul class="r">
                     <li class="lh30">
                         <a href="#" class="f pf5 l06c">北京建国饭店（最低998元）</a>
                         <span class="r">188米</span>
                         <div class="c"></div>
                     </li>
                 </ul>

                 <div class="c"></div>
           </div>       
    </div>
     </div>
     <!-- 周边结束 -->
    
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
<script src="js/hotelimage/lib.js" type=text/javascript></script>
<SCRIPT src="js/hotelimage/163css.js" type=text/javascript></SCRIPT>
</body>
</html>
<script language="javascript">	
	
	//alert("??");
        $.ajax({
	         type:"POST",
	         url:"hotel!findHotelRoomPrice.jspx",
	         data:{s_citycode:$("#hidcitycode").val(),s_hotelcode:$("#hidhotelcode").val(),startDate:$("#hidstime").val(),endDate:$("#hidendtime").val(),HotelId:$("#hidhotelid").val()},
	         beforeSend:function(){$("#HotelRoomPrice").html("<img src='images/loadding.gif' />")},
	         //async:false,              
	         success:function(data){
	       	// alert(data);
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         $("#HotelRoomPrice").html(data);
	         
	         }            
	         });
     
	
	
</script>
