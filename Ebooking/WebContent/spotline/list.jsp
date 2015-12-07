<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="com.yf.website.web.server.Server"%>
<%@page import="java.util.*" %>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}线路预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>

<script type="text/javascript">
var varAddress="";
$(document).ready(function(){
 lodSpot('383','杭州');
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

function bookhotel(roomid,hotelid) { 
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';

window.location.href="hotel!tobook.jspx?HotelId="+hotelid+"&RoomTypeid="+roomid+"&startDate="+startDate+"&endDate="+endDate;
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
      beforeSend:function(){$("#AjaxHotelDiv").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐线路信息...");},             
      success:function(data){
      $("#AjaxSpotDiv").html(data);           
      }            
      }); 
}
function showMap(){
$("#hotelList").hide(); 
$("#hotelMap").show(); 
}
function showHotel(){
$("#hotelList").show(); 
$("#hotelMap").hide(); 
}
//以下为检索用js
function orderByStar(val,index){

for(a=1;a<=6;a++){
document.getElementById("starli"+a).className="f sealist_li"; 
document.getElementById("starspan"+a).className=""; 
}
document.getElementById("starli"+index).className="f sealist_all"; 
document.getElementById("starspan"+index).className="sealist_onall"; 

}

function OrderByRegion(regionid){

$("#hidregion").val(regionid); 

document.form1.submit();

}
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=3&subindex=1" />
	</div>
	<!--top over-->
	<form action="spotline!SeachSpotline.jspx" method="post" name="form1" id="form1">
	<div id="hotel">
      <div id="left" class="f">
          <div class="search"><font class="black">国内线路搜索</font></div>
         
           
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
              <li class="but" >
               <span class="r mr25" style="margin-right: 85px;"><input type="submit"  class="bst" value="立即搜索"  /></span>
               
               <span class="c"></span>
              </li>
             </ul>
          </div>
          <input type="hidden" name="orderType" id="horderby" value="" /><!-- 隐藏域  排序 -->
          <input type="hidden" name="RegionID" id="hidregion" value="" /><!-- 隐藏域  排序 -->
         
          
          <!-- <div class="searchbot"></div> -->
          <!-- <div class="mt7"><img src="images/ad_260_60.jpg" width="260" height="60" title="地图上找酒店，精彩尽在于此。" /> </div> -->
          <div class="mt7" style="display: none;">
             <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">您最近浏览过的线路</font>
                  <div class="c"></div>  
               </div>
               <ww:if test="#session.listhotelsession==null">
               <div class="box recently" style=" border-top:none;"><span class="f ico_recently">&nbsp;</span>您最近没有浏览过任何线路。</div>
               </ww:if><ww:else>
               <div class="box content" style="">
               <ww:iterator value="#session.listhotelsession" status="ind">
                 <ul class="box_botm_xu">
                     <li>
                         <span class="f number font_fff_09"><ww:property value="#ind.index+1" /></span>
                         <a href="hotel!toHotelInfo.jspx?HotelId=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="f"><ww:property value="name" /></a>
                         <font class="r font_f60_c">&yen;<ww:property value="startprice" /></font>
                         <div class="c"></div>
                     </li>
                     <li class="content_lh">
                       <span class="f pf25">共<font class="f90">98条</font>评论</span>
                       <span class="r pr20"><font class="f90">99%</font>满意度</span>
                       <div class="c"></div>
                     </li>
                     <div class="nohave6 c">&nbsp;</div>
                 </ul>
                 </ww:iterator>
                
                </div>   
               </ww:else>
           		<div class="mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div> 
               
                 
                 
                 
          </div>
          <div class="mt7">
              <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">推荐线路信息</font>
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
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">选择线路（<ww:property value="GetSpotCityNmaeByID(CityID)" />）</font>
       <span class="r spot_line_status">&nbsp;</span>
       <div class="c"></div>
    </div>
    
   <div id="hotelList"> 
    <div class="mt7" style="height:28px; line-height:26px;">
      <div class="f mr5 list_on " id="hotelTEXT" ><a href="#"  class="fff">线路列表</a></div>
      <div class="f list_out" style="display: none" id="mapTEXT" href="javascript:void(0)" onclick="showMap();" >电子地图</div>
      <div class="r"><ww:property value="getPagination('\"spotline!SeachSpotline.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/></div>
      <div class="c list_line">&nbsp;</div>
    </div>

    
    <ww:iterator value="ListSpotline" status="t">
    
    <input type="hidden" id="hidhotelcode_<ww:property value="#t.index"/>" value="<ww:property value="hotelcode"/>" />
    <input type="hidden" id="hidhotelid_<ww:property value="#t.index"/>" value="<ww:property value="id"/>" />
    <span id="lowHotelSpan_<ww:property value="#t.index"/>"></span>

    <div class="mt7 " id="hotelsTable<ww:property value="id" />">     
       <div>
           <div class="f list_top_left">&nbsp;</div> 
           <div class="f list_top list_bg">
               <div class="f"><a href="spotline!toSpotLineInfo.jspx?SpotLineID=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="c09f"><ww:property value="name" /></a></div>
               <div class="r"><span class="ico_tell">&nbsp;</span><a href="spotticket!toSpotTicketInfo.jspx?SpotMesID=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="c09f">线路详细介绍</a></div>
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
       <div>
          <div class="list_img f"><img src="<ww:property value="getImgPathByCode('showspotlinepath',GetSpotLineImgPathByID(id))" />" width="90" height="80" /></div>
          <div class="list_main f">
            <ul>
            <li>出发日期：
            <ww:if test="stime==null||stime==''">天天发团(请提前1天预约)</ww:if>
			<ww:else><ww:property value="stime" /></ww:else>
            </li>
            <li>行程天数：<ww:property value="days" />天</li>
            <li>计划人数：<ww:property value="snums" />人</li>
            <li>景点信息：<ww:property value="SubString(ShowHTML(info,'list'),100)" />....</li>
            </ul> 
          </div>
          
          <div class="c"></div>
       </div>
       
       
       <div class="nohave"></div>
       <div class="mt7 information list_table " id="HotelRoomPrice_<ww:property value="#t.index" />">
       
       </div>
    </div>
    </ww:iterator>
    
        
        
          
    <div class="box_ccc floatall box_botno mt7">
      <ul class="query">
      <li class="f">&nbsp;</li>
      <li class="r mr25"><ww:property value="getPagination('\"spotline!SeachSpotline.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/></li>
      <div class="c"></div>
      </ul>
    </div> 
    
   </div>
   <!-- list结束 -->
   <!-- map开始 -->
   
   <!-- map结束 -->
   
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
</form>
 <ww:include page="../footer.jsp"/> 
</body>
</html>
<script type="text/javascript">
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
function showAllppai(ppaisize){

	for(i=0;i<ppaisize;i++){
			 $("#ppai_"+i).show();     
		}
		
		 $("#showppai").hide();   
		 $("#hideppai").show();  
		

}

function hideAllppai(ppaisize){

		for(i=5;i<ppaisize;i++){
			 $("#ppai_"+i).hide();     
		}
 		$("#showppai").show();   
		 $("#hideppai").hide();    
}


//选项卡切换
function showAllregion(regionsize){

	for(i=0;i<regionsize;i++){
			 $("#region_"+i).show();     
		}
		
		 $("#showregion").hide();   
		 $("#hideregion").show();  
		

}

function hideAllregion(regionsize){

		for(i=5;i<regionsize;i++){
			 $("#region_"+i).hide();     
		}
 		$("#showregion").show();   
		 $("#hideregion").hide();    
}

function showAllroom(hotelid,roomsize){
	var hidtype=$("#hidtype_"+hotelid).val(); 
	if(hidtype=='1'){//1显示  2隐藏
		for(i=0;i<roomsize;i++){
			 $("#room_"+hotelid+"_"+i).show();     
		}
		
	 	$("#show_"+hotelid).hide();   
	 	$("#hide_"+hotelid).show();  
	 	
	 	$("#hidtype_"+hotelid).val("2"); 
	 	
	}else{
		if(parseFloat(roomsize)>2){
			
			for(i=2;i<roomsize;i++){
			 $("#room_"+hotelid+"_"+i).hide();     
			}
			$("#hidtype_"+hotelid).val("1"); 
			$("#show_"+hotelid).show();   
	 		$("#hide_"+hotelid).hide();
		}
	
	}
	
	   
}

function showOrderBy(){
var hidorder=$("#hidorderby").val(); 
if(hidorder=='1'){
$("#orderby").show(); 
$("#hidorderby").val("2"); 
}else{
$("#orderby").hide(); 
$("#hidorderby").val("1"); 
}
  

}

function CheckOrderBY(orderby){

$("#horderby").val(orderby); 
document.form1.submit();

}

 
function hideAllroom(el,tablen){
	var table = document.getElementById(tablen);
	for(var i=3; i<table.rows.length-1;i++){
		table.rows[i].style.display = 'none';
	}
	el.parentNode.innerHTML = "<a style='cursor:pointer;' href='javascript:void(0)' onclick=\"showAllroom(this,'"+tablen+"')\">全部房型▼</a>";
}
</script>
<script language="javascript">	
	
	
	 $("span[id*='lowHotelSpan_']").each(function(i){
     	//alert(i);
     	return;
        $.ajax({
	         type:"POST",
	         url:"hotel!findHotelRoomPrice.jspx",
	         data:{s_citycode:$("#hidcitycode").val(),s_hotelcode:$("#hidhotelcode_"+i).val(),startDate:$("#hidstime").val(),endDate:$("#hidendtime").val(),HotelId:$("#hidhotelid_"+i).val()},
	         beforeSend:function(){$("#HotelRoomPrice_"+i).html("<img src='images/loadding.gif' />")},
	         //async:false,              
	         success:function(data){
	       	 //alert(data);
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         $("#HotelRoomPrice_"+i).html(data);
	         
	         }            
	         });
       });
	
	
</script>