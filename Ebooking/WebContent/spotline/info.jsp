<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}线路预定系统</title>
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
<script type="text/javascript"
	src="http://www.google.com/jsapi?key=AIzaSyD2-qRfev2N4vz6oTHApmzA6PoXhoub_pg"></script>
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

function bookSpotLine(id) { 
	//var startDate = '<ww:property value="startDate"/>';
	//var endDate = '<ww:property value="endDate"/>';
	window.location.href="spotline!tobook.jspx?SpotLineID="+id;
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
      beforeSend:function(){$("#AjaxHotelDiv").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐线路信息...");},             
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
			width:420,
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
	

	
	

	 

	
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=3&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel">
 <div id="list" style="width: 100%">
    <div>
       <font class="f biger000"><ww:property value="hotel.name" /></font>
       <span class="r spot_line_status_two">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="details_tille mt7">
      <ul>
       <li id="tab1" class="f details_tille_on" onclick="checkTab(1);"><a href="#">线路预订</a></li>
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
         <li class="mt10"><span class="ico_start">&nbsp;</span>线路名称：<b><ww:property value="spotline.name"/></b></li>
         
         <li><span class="ico_start">&nbsp;</span>出发日期：<ww:property value="spotline.stime"/></li>
         <li><span class="ico_start">&nbsp;</span>行程天数：<ww:property value="spotline.days" />天</li>
         <li><span class="ico_start">&nbsp;</span>计划人数：<ww:property value="spotline.snums" />人</li>
         <li><span class="ico_start">&nbsp;</span>景点信息：<ww:property value="spotline.info" /></li>
         </ul>
         <div class="nohave"></div>
         <div class=" box">
       	<table width="470" border="1" cellspacing="0" cellpadding="0" class="box" >
       	
          <tr>
            <th class="hadow" width="30%" scope="col">成人类型</th>
            <th class="hadow" width="30%" scope="col">市场价</th>
            <th class="hadow" width="30%" scope="col">现付价</th>
          </tr>
           <ww:iterator value="ListSpotlineprice" status="index">
          <tr>
            <td class="floatall" align="center">
             <ww:property value="ptype" />
            </td>
            <td align="center" class="font-f60-del">&yen;<ww:property value="formatMoney_string(lsprice)" /></td>
            <td align="center" class="font-f60-16">&yen;<ww:property value="price" /></td>
          </tr>
          </ww:iterator>
          <tr>
          <td align="center" colspan="3">
          <input type="button" class="bst" value="立即预定" onclick="bookSpotLine(<ww:property value="spotline.id"/>);" />
          </td>
          </tr>
        </table>
         </div>
         
      </div>
      <div class="introduction_right r">
         <div class="box hotel_img">
      <div id=preview >
	<div class=jqzoom id=spec-n1 style="width:400px; height: 202px; ">
	<table style="width: 100%; height: 100%">
		<tr>
			<td valign="middle" style="" align="center"><IMG 
	src="<ww:if test="ListSpotlineimg==null||ListSpotlineimg.size==0">images/NoImage.gif</ww:if>
	<ww:else><ww:property value="getImgPathByCode('showspotlinepath',GetSpotLineImgPathByID(SpotLineID))" /></ww:else>" style="margin-top:0px; margin-left: -1px;height:200px;width:400px;">
	</td>
		</tr>
	</table>
	</div>
<div id=spec-n5 style="width: 400px;">
		<div class="control" id=spec-left >
			
			<img src="images/left2.gif" />
		</div>
		<div id=spec-list style="width:373px; overflow: hidden;" >
			<ul class=list-h style="width:258px;">
	<ww:iterator value="ListSpotlineimg" status="index">
        <li ><img src="<ww:property value="getImgPathByCode('showspotlinepath',imgurl)" />" /></li>
     </ww:iterator>
			
			</ul>
		</div>
		<div class="control" id=spec-right align="right" >
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
    
       
    </div>
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">行程信息</span></div>
        
        
        <div class="nohave"></div>
        <ww:iterator value="ListSpotlineinfo" status="index">
                <span style="color: red"><h1>第<ww:property value="#index.index+1"/>天:</h1></span>
              
         <div class=" box">
       	<table width="100%" border="1" cellspacing="0" cellpadding="0" class="box" >
       	
          <tr>
            <th class="hadow" width="33%" scope="col">区间</th>
            <th class="hadow" width="33%" scope="col">住宿</th>
            <th class="hadow" width="33%" scope="col">餐饮</th>
            
          </tr>
          
          <tr>
            <td class="font-f60-16" align="center">
             <ww:property value="qujian" />
            </td>
            <td align="center" class="font-f60-16"><ww:property value="zhusu" /></td>
            <td align="center" class="font-f60-16"><ww:property value="canyin" /></td>
            
          </tr>
        </table>
         </div></br>
          <ww:property value="beizhu"/>
  		</ww:iterator>       
    </div>   
    <div class="box mt7" style="display: none">
        <div class="tit"><span class="low2 black f">详细信息</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="spotline.pics"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
     <div class="box mt7">
        <div class="tit"><span class="low2 black f">费用说明</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <span style="color: red"><b>费用包含:</b></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<ww:property value="spotline.baohan"/></br>
                <span style="color: red"><b>费用不包含:</b></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<ww:property value="spotline.bubaohan"/></br> 
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">注意事项</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotline.notice,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">服务标准</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotline.fwbz,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    
    </div>
    <!-- 基本信息结束 -->  
    <!-- 图片开始 -->
    
    <!-- 图片结束 -->
    <!-- 酒店点评开始 -->
    
    <!-- 酒店点评结束 -->
    <!-- 酒店地图开始 -->
     
     <!-- 地图结束 -->
        <!-- 酒店地标开始 -->
     
     <!-- 地标结束 -->
     
       <!-- 周边开始 -->
     
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

