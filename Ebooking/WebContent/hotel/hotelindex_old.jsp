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

<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_data_pp.js"></script>

<script type="text/javascript">

$(document).ready(function(){
  loadCityData();
  selecthotel(1,15495,'','');
  lodhotel('15495','北京');
});
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

function  selecthotel(index,hotelid){


  $.ajax({
      type:"GET",
       url:"hotel!GetIndexHotel.jspx",
      data:{strHotelIndex:index,strHotelCity:hotelid,para:Math.floor(Math.random()*100)},
      beforeSend:function(){$("#divHotelHtml").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐酒店信息...");},             
      success:function(data){
      //alert(data);
      
     //  $("#city"+index).html(data);  
      
      seletecity(index);
      $("#divHotelHtml").html(data);           
      }            
      }); 
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

function seletecity(index){

for(i=1;i<=6;i++){
	 document.getElementById("city"+i).className="f navcity_out"; 
	  $("#style"+i).hide();        
	 
}
  document.getElementById("city"+index).className="f navcity_on"; 
   $("#style"+index).show();        
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
</script>

</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>
	<!--top over-->
	<div id="hotel">
      <div id="left" class="f">
          <div class="search"><font class="black">国内酒店搜索</font></div>
          <form action="hotel!Seach.jspx" method="post">
          <div class="box_sea searchlist">
             <ul>
           <li class="searchall mt10">入住城市：<input type="text" id="txthotelcity" class="text_search" name="hotelcity" value="北京"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
          		 <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="607"  />
           </li>
           <li class="searchall">入住时间：<input type="text" class="text_search" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"  /></li>
           <li class="searchall">离店时间：<input type="text" class="text_search"  id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"/></li>
           <li class="searchall">酒店星级：
           <select name="s_star" class="sel_search">
           <option value="0">-----所有星级------</option>
           <option value="1">-------经济型-------</option>
           <option value="2">-------二星级-------</option>
           <option value="3">-------三星级-------</option>
           <option value="4">-------四星级-------</option>
           <option value="5">-------五星级-------</option>
           </select></li>
           <li class="searchall">价额范围：
           <select name="s_price" class="sel_search">
          <option vlaue="0">不限</option>  
          <option vlaue="1">RMB 250以下</option>
          <option vlaue="2">RMB 250-400</option>
          <option vlaue="3">RMB 400-600</option>
          <option vlaue="4">RMB 600-800</option>
          <option vlaue="5">RMB 800以上</option>
           </select>
           <!--
           <input type="text" class="text_searchwf"  /><input type="text" class="text_searchwf"  />
           -->
           </li>
              <li class="searchall">关&nbsp;&nbsp;键&nbsp;字：
              <input type="text" class="text_search" id="s_hotelName" name="hotelName" value=""  /></li>
              <li class="but">
               <span class="f">全国<font class="f90"><ww:property value="citynum" />个</font>城市，<br/><font class="f90"><ww:property value="hotelnum" /></font>余家酒店。</span>
               <span class="r mr25"><input type="submit"  class="bst" value="立即搜索"  /></span>
               <span class="c"></span>
              </li>
             </ul>
          </div>
          </form>
          <!-- <div class="searchbot"></div> -->
          <!-- <div class="mt7"><img src="images/ad_260_60.jpg" width="260" height="60" title="地图上找酒店，精彩尽在于此。" /> </div> -->
          <div class="tit mt7" style=" border:1px solid #E3E3E3; border-bottom:none;">
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
              <!--
              <div class="box content">
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
           -->
      </div>
 <div id="right" class="r">
       <div>
         <div class="f ad_box">
        
          <ww:include page="5tu.htm"></ww:include>
         
         <!--
         <img src="images/ad_495_216.jpg" width="500" height="217"  />
         -->
         </div>
         <div class="r">
               <div class="titleinfo"><font class="black">最新资讯</font></div>
               <div class="box_tell" style=" border-top:none;">
                  <ul style="width:181px; height:72px; overflow:hidden;">
                  <ww:iterator value="listZX">
                   <li>
	                   	<a href="index!tohelp.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:if test="name.length()>23">
						<ww:property value="SubString(name,20)"/>...
						</ww:if><ww:else>
						<ww:property value="name"/>
						</ww:else>
						</a>
					</li>
                   </ww:iterator>
                  
                  </ul>
               </div>
           	<div class="mt7"><img src="images/hotel/ad_hotel_01.jpg" width="222" height="90" /></div>   
           </div>
         <div class="c"></div>
       </div>
       <div class="mt7 box">
           <div class="tit">
              <font class="black low2 f mr15">热门酒店</font>
              <div class="r navcity">
                <ul>
                 <a href="#"><li class="f navcity_on"  id="city1" onclick="selecthotel(1,607)">北京</li><li id="style1" class="navcity_on_right f">&nbsp;</li></a>
                 <a href="#"><li class="f navcity_out" id="city2" onclick="selecthotel(2,321)">上海</li><li id="style2" style="display: none" class="navcity_on_right f">&nbsp;</li></a>
                 <a href="#"><li class="f navcity_out" id="city3" onclick="selecthotel(3,80)">广州</li><li id="style3" style="display: none" class="navcity_on_right f">&nbsp;</li></a>
                 <a href="#"><li class="f navcity_out" id="city4" onclick="selecthotel(4,91)">杭州</li><li id="style4" style="display: none" class="navcity_on_right f">&nbsp;</li></a>
                 <a href="#"><li class="f navcity_out" id="city5" onclick="selecthotel(5,192)">武汉</li><li id="style5" style="display: none" class="navcity_on_right f">&nbsp;</li></a>
                 <a href="#"><li class="f navcity_out" id="city6" onclick="selecthotel(6,224)">南京</li><li id="style6" style="display: none" class="navcity_on_right f">&nbsp;</li></a>
                </ul>
              </div> 
              <div class="c"></div>
           </div>
           
           <div id="divHotelHtml"></div>
           <!--
           <div>
             <ul>
               <li class="titlehot box_over dd2626">经济型酒店</li>
             </ul>
             <ul class="main">
             <div class="nohave5"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c nohave5"></div>
             </ul>
             <ul class="c">
             <li class="titlehot box_over box_over_top">
               <font class="f dd2626">星级酒店</font>
               <span class="r mr15">
               <a href="#" class="l06c">五星</a><font class="mlr8">|</font>
               <a href="#" >四星</a><font class="mlr8">|</font>
               <a href="#">三星</a><font class="mlr8">|</font>
               <a href="#">经济</a>
               </span>
               <div class="c"></div>
             </li>
             </ul>
             <ul class="main">
             <div class="nohave5"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c nohave5"></div>
             </ul>
             <ul class="c">
             <li class="titlehot box_over box_over_top">
               <font class="f dd2626">热门地标酒店</font>
               <span class="r mr15">
               <a href="#" class="l06c">天安门</a><font class="mlr8">|</font>
               <a href="#" >王府井</a><font class="mlr8">|</font>
               <a href="#">国展中心</a><font class="mlr8">|</font>
               <a href="#">中关村</a><font class="mlr8">|</font>
               <a href="#">西客站</a><font class="mlr8">|</font>
               <a href="#">永定门</a><font class="mlr8">|</font>
               <a href="#">南站</a><font class="mlr8">|</font>
               <a href="#">北京周边度假</a><font class="mlr8">|</font>
               <a href="#">上地</a>
               </span>                  
               <div class="c"></div>
               </li>
             </ul>
             <ul class="main">
             <div class="nohave5"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c"></div>
                 <li class="f main_left">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <li class="r main_right">
                   <ul>
                     <li class="f main_name">北京格林豪泰酒店</li>
                     <li class="f main_morny f90c">&yen;256</li>
                     <li class="f main_give f90">&yen;20</li>
                   </ul>
                 </li>
                 <div class="c nohave5"></div>
             </ul>
           </div>
       -->
       </div>
       <div class="mt7 box">
           <div class="tit">
              <font class="black low2 f mr15">热门品牌</font>
              <font class="c999">—&nbsp;专注品牌·享受精彩生活</font>
              <div class="c"></div>
           </div>
           <div class="brand">
             <ul>
             <ww:iterator value="ListChaininfo">
              <li class="f brandli">
                <dt><img src="<ww:property value="imagepic" />" width="80" height="50" /></dt>
                <dt><ww:property value="name" /></dt>
              </li>
              </ww:iterator>
             
              <div class="c"></div>
             </ul>
             <div class="c"></div>
           </div>
       </div>
 </div>
 <!--right over-->
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
</body>
</html>
