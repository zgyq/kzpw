<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="com.yf.website.web.server.Server"%>
<%@page import="java.util.*" %>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}酒店预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />
</head>
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_data_pp.js"></script>
<script type="text/javascript">

$(document).ready(function(){

 lodhotel(607,'北京');
loadCityData();
 

});
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
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>
	<!--top over-->
	<form action="hotel!Seach.jspx" method="post" name="form1" id="form1">
	<div id="hotel">
      <div id="left" class="f">
          <div class="search"><font class="black">国内酒店搜索</font></div>
         
           
          <div class="box_sea searchlist">
             <ul>
           <li class="searchall mt10">入住城市：<input type="text" id="txthotelcity" class="text_search" name="hotelcity" value="<ww:property value="getCityNameByStr(cityId)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
          		 <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="<ww:property value="cityId" />"  />
           </li>
           
           <!--隐藏域 -->
<input type="hidden" id="hidstime" value="<ww:property value="startDate"/>" />
<input type="hidden" id="hidendtime" value="<ww:property value="endDate"/>" />
<input type="hidden" id="hidcitycode" value="<ww:property value="s_citycode"/>" />


           <li class="searchall">入住时间：<input type="text" class="text_search" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"  /></li>
           <li class="searchall">离店时间：<input type="text" class="text_search"  id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"/></li>
           <li class="searchall">酒店星级：
           <select name="s_star" class="sel_search">
           <option value="0" <ww:if test="s_star.equals(\"0\")">selected</ww:if>>-----所有星级------</option>
           <option value="1" <ww:if test="s_star.equals(\"1\")">selected</ww:if>>-------经济型-------</option>
           <option value="2" <ww:if test="s_star.equals(\"2\")">selected</ww:if>>-------二星级-------</option>
           <option value="3" <ww:if test="s_star.equals(\"3\")">selected</ww:if>>-------三星级-------</option>
           <option value="4" <ww:if test="s_star.equals(\"4\")">selected</ww:if>>-------四星级-------</option>
           <option value="5" <ww:if test="s_star.equals(\"5\")">selected</ww:if>>-------五星级-------</option>
           </select></li>
           <li class="searchall">价额范围：
           <select name="s_price" class="sel_search">
         
         				  <option value="0" <ww:if test="s_price.equals(\"0\")">selected</ww:if> >不限</option>  
                          <option value="1" <ww:if test="s_price.equals(\"1\")">selected</ww:if> >RMB 250以下</option>
                          <option value="2" <ww:if test="s_price.equals(\"2\")">selected</ww:if> >RMB 250-400</option>
                          <option value="3" <ww:if test="s_price.equals(\"3\")">selected</ww:if> >RMB 400-600</option>
                          <option value="4" <ww:if test="s_price.equals(\"4\")">selected</ww:if> >RMB 600-800</option>
                          <option value="5" <ww:if test="s_price.equals(\"5\")">selected</ww:if> >RMB 800以上</option>
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
          <input type="hidden" name="RegionID" id="hidregion" value="" /><!-- 隐藏域  排序 -->
         
          
          <!-- <div class="searchbot"></div> -->
          <!-- <div class="mt7"><img src="images/ad_260_60.jpg" width="260" height="60" title="地图上找酒店，精彩尽在于此。" /> </div> -->
          <div class="mt7">
             <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
                  <font class="black f" style=" padding-left:10px;">您最近浏览过的酒店</font>
                  <div class="c"></div>  
               </div>
               <ww:if test="#session.listhotelsession==null">
               <div class="box recently" style=" border-top:none;"><span class="f ico_recently">&nbsp;</span>您最近没有浏览过任何酒店。</div>
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
           		<div class="mt7"><img src="images/hotel/ad_hotel_02.jpg" width="260" height="100" /></div> 
               
                 
                 
                 
          </div>
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
              </div>   
      </div>
 <div id="list" class="r">
 
    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">选择酒店（<ww:property value="getCityNameByStr(cityId)" />）</font>
       <span class="r status">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="box mt3" style="display: none">
             <div class="tit" style="display: none">
                  <font class="black low2 f mr5">筛选条件</font>
                  <div class="f pf20 conditionwall floatall">
                       <ul>
                       <li class="f mr5">
                          <span class="condition f a41300">套房</span>
                          <span class="del_condition f">&nbsp;</span>
                          <div class="c"></div>
                       </li>
                       <li class="f mr5">
                          <span class="condition f a41300">五星级/豪华型</span>
                          <span class="del_condition f">&nbsp;</span>
                          <div class="c"></div>
                       </li>
                       <li class="f mr5">
                          <span class="condition f a41300">机场接送</span>
                          <span class="del_condition f">&nbsp;</span>
                          <div class="c"></div>
                       </li>
                       <li class="f mr5">
                          <span class="condition f a41300">五星级/豪华型</span>
                          <span class="del_condition f">&nbsp;</span>
                          <div class="c"></div>
                       </li>
                       <li class="f mr5">
                          <span class="condition f a41300">机场接送</span>
                          <span class="del_condition f">&nbsp;</span>
                          <div class="c"></div>
                       </li>
                       <li class="nohuan"></li>
                       </ul>
                  </div>
                  <div class="r nohuan"><a href="#" class=" l06c" >>>清除筛选条件</a></div>
                  <div class="c"></div>  
            </div>
            <div class="c sealist">
               <ul class="box_botm_xu c">
                <li class="f sealist_first l267dff">酒店价格：</li>
                <li class="f sealist_all" onclick="orderByPrice();"><span class="sealist_onall">全部</span></li>
                <li class="f sealist_li">¥250以下</li>
                <li class="f sealist_li">¥250-¥400</li>
                <li class="f sealist_li">¥400-¥600</li>
                <li class="f sealist_li">¥600-¥800</li>
                <li class="f sealist_li">¥800以上</li>
                <div class="c"></div>
               </ul>
               <div class="c"></div>
               <ul class="box_botm_xu c">
                <li class="f sealist_first l267dff">酒店星级：</li>
                <li id="starli1" class="f sealist_all"  onclick="orderByStar('0','1');"><span id="starspan1" class="sealist_onall">全部</span></li>
                <li id="starli2" class="f sealist_li" onclick="orderByStar('8,9','2');"><span id="starspan2" class="">五星级/豪华</span></li>
                <li id="starli3" class="f sealist_li" onclick="orderByStar('6,7','3');"><span id="starspan3" class="">四星级/高档</span></li>
                <li id="starli4" class="f sealist_li" onclick="orderByStar('4,5','4');"><span id="starspan4" class="">三星级/舒适</span></li>
                <li id="starli5" class="f sealist_li" onclick="orderByStar('3','5');"><span id="starspan5" class="">二星级/经济</span></li>
                <li id="starli6" class="f sealist_li" onclick="orderByStar('1','6');"><span id="starspan6" class="">经济型/经济</span></li>
                <div class="c"></div>
               </ul>
               <ul class="box_botm_xu c" >
                <li class="f sealist_first l267dff">酒店品牌：</li>
                <li class="f sealist_all"><span class="sealist_onall">全部</span></li>
                <ww:iterator value="ListChaininfo" status="ind">
                <li id="ppai_<ww:property value="#ind.index" />" class="f sealist_li" <ww:if test="#ind.index>4">style="display: none"</ww:if>  ><ww:property value="name" /></li>
                </ww:iterator>
                <!--
                <li class="f sealist_li"><span class="sealist_on">格林豪泰<span class="ico_del">&nbsp;</span></span></li>
                <li class="f sealist_li">如家</li>
                <li class="f sealist_li">斯克莱星</li>
                <li class="f sealist_li">斯克莱星</li>
                -->
                <ww:if test="ListChaininfo.size>4">
                <li id="showppai"><a href="javascript:void(0)" onclick="showAllppai(<ww:property value="ListChaininfo.size" />);" class="unc09fx">更多</a></li>
                <li id="hideppai" style="display: none"><a href="javascript:void(0)" onclick="hideAllppai(<ww:property value="ListChaininfo.size" />);" class="unc09fx" >隐藏</a></li>
                </ww:if>
                
                <div class="c"></div>
               </ul>
               <ul class="box_botm_xu c">
                <li class="f sealist_first l267dff">酒店区域：</li>
                <li class="f sealist_all" ><span  <ww:if test="RegionID==0">class="sealist_onall"</ww:if>>全部</span></li>
                <ww:iterator value="ListRegion" status="index">
                <li id="region_<ww:property value="#index.index" />" onclick="OrderByRegion(<ww:property value="id" />);" <ww:if test="RegionID==id">class="f sealist_all"</ww:if><ww:else>class="f sealist_li"</ww:else> <ww:if test="#index.index>4">style="display: none"</ww:if>  ><span  <ww:if test="RegionID==id">class="sealist_onall"</ww:if>><ww:property value="name" /></span></li>
                </ww:iterator>
                <ww:if test="ListRegion.size>4">
                <li id="showregion"><a href="javascript:void(0)" onclick="showAllregion(<ww:property value="ListRegion.size" />);" class="unc09fx" >更多</a></li>
                <li id="hideregion" style="display: none"><a href="javascript:void(0)" onclick="hideAllregion(<ww:property value="ListRegion.size" />);" class="unc09fx" >隐藏</a></li>
                </ww:if>
               	
                <div class="c"></div>
               </ul>
               <ul class="box_botm_xu c" style="display: none">
                <li class="f sealist_first l267dff">酒店设施：</li>
                <li class="f sealist_all"><span class="sealist_onall">全部</span></li>
                <li class="f sealist_li">宽带</li>
                <li class="f sealist_li">上网</li>
                <li class="f sealist_li">机场接送</li>
                <li class="f sealist_li">餐厅服务</li>
                <li class="f sealist_li">游泳池</li>
                <div class="c"></div>
               </ul>
               <ul class="c" style="display: none">
                <li class="f sealist_first l267dff">酒店床型：</li>
                <li class="f sealist_all"><span class="sealist_onall">全部</span></li>
                <li class="f sealist_li">一张床</li>
                <li class="f sealist_li">两张床</li>
                <li class="f sealist_li">三张床</li>
                <li class="f sealist_li">套房</li>
                <div class="c"></div>
               </ul>
               <div class="floatall"><div class="box openall">显示全部筛选条件</div></div>
            </div>
    </div>
   <div id="hotelList"> 
    <div class="mt7" style="height:28px; line-height:26px;">
      <div class="f mr5 list_on " id="hotelTEXT" ><a href="#"  class="fff">酒店列表</a></div>
      <div class="f list_out" style="display: none" id="mapTEXT" href="javascript:void(0)" onclick="showMap();" >电子地图</div>
      <div class="r"><ww:property value="getPagination('\"hotel!Seach.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/></div>
      <div class="c list_line">&nbsp;</div>
    </div>

    <div class="box_ccc floatall box_botno">
      <ul class="query">
      <li class="f sort box_right" onclick="showOrderBy();" ><span class="ico_recommendation f">&nbsp;</span><font class="f l06c">网站推荐排序</font><span class="ico_subscript mf5">&nbsp;</span></li>
       <ww:if test="orderType==1||orderType==2">
      <li class="f sort_pp sort_on box_leftfff box_right" ><span class="ico_morny f">&nbsp;</span>价格↑</li>
       <li class="f sort_pp box_leftfff box_right" ><span class="ico_star f">&nbsp;</span>酒店星级↑</li>
       <li class="f sort_pp  box_leftfff box_right" ><span class="ico_praise f">&nbsp;</span>好评</li>
        <li class="f sort_pp box_leftfff box_right" ><span class="ico_bonus f">&nbsp;</span>奖金</li>
      </ww:if>
      <ww:if test="orderType==3||orderType==4">
        <li class="f sort_pp  box_leftfff box_right" ><span class="ico_morny f">&nbsp;</span>价格↑</li>
       <li class="f sort_pp sort_on box_leftfff box_right" ><span class="ico_star f">&nbsp;</span>酒店星级↑</li>
        <li class="f sort_pp  box_leftfff box_right" ><span class="ico_praise f">&nbsp;</span>好评</li>
        <li class="f sort_pp box_leftfff box_right" ><span class="ico_bonus f">&nbsp;</span>奖金</li>
      </ww:if>
      <ww:if test="orderType==5||orderType==6">
      <li class="f sort_pp  box_leftfff box_right" ><span class="ico_morny f">&nbsp;</span>价格↑</li>
       <li class="f sort_pp  box_leftfff box_right" ><span class="ico_star f">&nbsp;</span>酒店星级↑</li>
        <li class="f sort_pp sort_on  box_leftfff box_right" ><span class="ico_praise f">&nbsp;</span>好评</li>
        <li class="f sort_pp box_leftfff box_right" ><span class="ico_bonus f">&nbsp;</span>奖金</li>
      </ww:if>
    
      
      </ul>
      <div class="sort_float box_ccc" style="display: none" id="orderby">
         <ul>
         <li id="order1" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'"  onclick="CheckOrderBY(1);"><span class="ico_mornyup f ">&nbsp;</span>价格由低到高</li>
         <li id="order2" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'" onclick="CheckOrderBY(2);"><span class="ico_mornydown f">&nbsp;</span>价格由高到低</li>
         <li id="order3" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'" onclick="CheckOrderBY(3);"><span class="ico_starup f">&nbsp;</span>星级由低到高</li>
         <li id="order4" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'" onclick="CheckOrderBY(4);"><span class="ico_stardown f">&nbsp;</span>星级由高到低</li>
         <li id="order5" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'" onclick="CheckOrderBY(5);"><span class="ico_praiseup f">&nbsp;</span>好评由高到低</li>
         <li id="order6" class="box_botm" onmouseover="this.className='l06c'" onmouseout="this.className='box_botm'" onclick="CheckOrderBY(6);"><span class="ico_bonusup f">&nbsp;</span>好评由低到低</li>
         <li class="l06c" onclick="CheckOrderBY(1);" style="display: none" ><span class="ico_recommendation f">&nbsp;</span>网站推荐排序</li>
         <input type="hidden" id="hidorderby" value="1" />
         </ul>
      </div>
    </div>
    <ww:iterator value="hotelList" status="t">
    
    <input type="hidden" id="hidhotelcode_<ww:property value="#t.index"/>" value="<ww:property value="hotelcode"/>" />
    <input type="hidden" id="hidhotelid_<ww:property value="#t.index"/>" value="<ww:property value="id"/>" />
    <span id="lowHotelSpan_<ww:property value="#t.index"/>"></span>

    <div class="mt7 " id="hotelsTable<ww:property value="id" />">     
       <div>
           <div class="f list_top_left">&nbsp;</div> 
           <div class="f list_top list_bg">
               <div class="f"><a href="hotel!toHotelInfo.jspx?HotelId=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="c09f"><ww:property value="name" /></a></div>
               <div class="r"><span class="ico_tell">&nbsp;</span><a href="hotel!toHotelInfo.jspx?HotelId=<ww:property value="id" />&startDate=<ww:property value="startDate"/>&endDate=<ww:property value="endDate"/>" class="c09f">详细信息</a></div>
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
       <div>
          <div class="list_img f"><img src="<ww:property value="getImageSRc(id)"/>" width="90" height="80" /></div>
          <div class="list_main f">
            <ul>
            <li><ww:property value="name" /><font class="l06c mf45"><span class="ico_map">&nbsp;</span> <a onclick="window.open(this.href,'ss','resizable=no,location=no,menubar=no,scrollbars=no,status=no,toolbar=no,fullscreen=no,dependent=no,width=515,height=314,status'); return false" href="hotel_map.jsp?s_city=<ww:property value="s_name"/>&hotelname=<ww:property value="name"/>&hoteltell=<ww:property value="tortell"/>&hotelfax=<ww:property value="fax1"/>&re=<ww:property value="lat"/>,<ww:property value="lng"/>">电子地图</a></font></li>
            <li>酒店星级：
            <ww:if test="star==null||star==0">
			<span style="color: red">经济型</span>
			</ww:if>
			<ww:else>
			<ww:property value="getStarico(star)" />
			</ww:else>
            </li>
            <li>酒店区域：<ww:property value="CityName" />,<ww:property value="getRegionNameByStr(regionid2)" /></li>
            <li>酒店地址：<ww:property value="address" /></li>
            </ul> 
          </div>
          <div class="r list_right" style="display: none">
            <ul>
            <li><font class="font-f60-24">&yen;<ww:property value="startprice" /></font>起</li>
            <li><font class="f90">100%</font>满意</li>
            <li><font class="f90">93条</font>评论</li>
            </ul>
          </div>
          <div class="c"></div>
       </div>
       <div class="nohave"></div>
       <div class="mt7 information list_table " id="HotelRoomPrice_<ww:property value="#t.index" />">
       <table width="710" border="1" cellspacing="0" cellpadding="0" class="box" style="display: none">
          <tr>
            <th class="hadow" width="20%" scope="col">房型</th>
            <th class="hadow" width="10%" scope="col">门市价</th>
            <th class="hadow" width="10%" scope="col">前台价</th>
            <th class="hadow" width="25%" scope="col">床型</th>
            <th class="hadow" width="10%" scope="col">早餐</th>
            <th class="hadow" width="10%" scope="col">宽带</th>
            <th class="hadow" width="15%" scope="col">预定</th>
          </tr>
          <ww:iterator value="mapRoom.get(id)" status="index">
          <tr id="room_<ww:property value="hotelList[#t.index].id"/>_<ww:property value="#index.index" />" <ww:if test="#index.index >= 2"> style="display: none; " </ww:if>  
			<ww:else>style="display: block; " </ww:else>>
            <td class="floatall">
                <span class="ico_room">&nbsp;</span><a href="#" class="l06c"><ww:property value="name" /></a>
                <!-- 床型图片 -->
                <div class="float_room msg" style="display:none;">
                  <ul class="msgul">
                  <li class=" pt5"><img src="images/hotel.jpg" width="90" height="80" /></li>
                  <li>高级双人床</li>
                  </ul>
                </div>    
                <!-- 床型图片 -->
            </td>
            <td class="font-f60-del">&yen;<ww:property value="formatMoney_string(getdeptprice2(RoomListPrice.get(id).get(0)))" /></td>
            <td class="font-f60-16">&yen;<ww:property value="RoomListPrice.get(id).get(0)" /></td>
            <!--
            <td><span class="main_give f90 f mf15">&yen;20</span></td>
            -->
            <td><ww:property value="bed" /></td>
            <td><ww:property value="breakfast" /></td>
            <td><ww:property value="wideband" /></td>
            <td>
            <ww:if test="state==0">
            <input type="button" class="bnt" value="预定" onclick="bookhotel(<ww:property value="id" />,<ww:property value="hotelList[#t.index].id"/>);"/>
            </ww:if><ww:else>
            <input type="button" disabled="disabled" class="bnt" value="满房" />
            </ww:else>
            </td>
          </tr>
          </ww:iterator>
           
          <tr>
            <td colspan="6" align="left"><span class="ico_tips f">&nbsp;</span>
            <!-- 
            11.1至12.15入住，全部房型均含早餐（以房型介绍信息为准）
             -->
             </td>
            <td><a href="javascript:void(0)" onclick="showAllroom('<ww:property value="id"/>','')" >全部房型</a>
            <span id="show_<ww:property value="id"/>" class="allshow">&nbsp;</span>
            <span id="hide_<ww:property value="id"/>" class="allnoshow" style="display: none">&nbsp;</span>
            <input type="hidden" id="hidtype_<ww:property value="id"/>" name="" value="1" />
            </td>
          </tr>
        </table>
       </div>
    </div>
    </ww:iterator>
    
        
        
          
    <div class="box_ccc floatall box_botno mt7">
      <ul class="query">
      <li class="f">&nbsp;</li>
      <li class="r mr25"><ww:property value="getPagination('\"hotel!Seach.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/></li>
      <div class="c"></div>
      </ul>
    </div> 
    
   </div>
   <!-- list结束 -->
   <!-- map开始 -->
   <div id="hotelMap" style="display: none">
       <div class="mt7" style="height:28px; line-height:26px;">
      <div class="f mr5 list_out " href="javascript:void(0)" onclick="showHotel();">酒店列表</a></div>
      <div class="f list_on"><a href="#"  class="fff">电子地图</a></div>
      <div class="r">(共1228家酒店)&nbsp;2/82页&nbsp;上一页<font class="mlr">|</font>下一页</div>
      <div class="c list_line">&nbsp;</div>
    </div>

   
    <div class="box_ccc">
       <div class="f box_right_c" style=" width:546px;"><img src="images/mapp.png" width="546" height="480" /> </div>
       <div class="r"> 
       <div class=" floatall box_botno">
          <ul class="query">
          <li class="f sorter" ><span class="ico_recommendation f">&nbsp;</span><font class="f l06c">网站推荐排序</font><span class="ico_subscript mf5">&nbsp;</span></li>      
          </ul>
              <div class="sort_float box_ccc" style="display:none;">
                 <ul>
                 <li class="box_botm"><span class="ico_mornyup f ">&nbsp;</span>价格由低到高</li>
                 <li class="box_botm"><span class="ico_mornydown f">&nbsp;</span>价格由高到低</li>
                 <li class="box_botm"><span class="ico_starup f">&nbsp;</span>星级由高到低</li>
                 <li class="box_botm"><span class="ico_stardown f">&nbsp;</span>星级由高到低</li>
                 <li class="box_botm"><span class="ico_praiseup f">&nbsp;</span>价格由高到低</li>
                 <li class="box_botm"><span class="ico_bonusup f">&nbsp;</span>价格由高到低</li>
                 <li class="l06c"><span class="ico_recommendation f">&nbsp;</span>网站推荐排序</li>
                 </ul>
              </div>
        </div>
        <div class="list_map">
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">1</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">2</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">3</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">4</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">5</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">6</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">7</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">8</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul class="box_botm">
            <li class=" pf5"><span class="numberone f">9</span>北京迎春农家院</li>
            <li class="pf25 pr10"><span class="f f90">1个好评</span><span class="r">星级：<font class="l06c">二星级</font></span><div class="c"></div></li>
           </ul>
           <ul>
           <li class="text_center c999">(共有1228家酒店)2/82页</li>
           <li class="text_center" >上一页<font class=" mf5">1</font><font class="font_f60_c mf5">2</font><font class=" mf5">3</font><font class=" mf5">4</font><font class=" mf5">5</font><font class=" mlr">...</font>下一页</li>
           </ul>
        </div>
       </div>
       <div class="c"></div>
    </div>
   
   
   </div>
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