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

function bookbuying(id) { 
	//var startDate = '<ww:property value="startDate"/>';
	//var endDate = '<ww:property value="endDate"/>';
	window.location.href="buying!tobook.jspx?buyingid="+id;
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
<div id="hotel" style="margin-top: 51px;">
 <div id="list" style="width: 100%">
    <div>
       <font class="f biger000"><ww:property value="buying.name" /></font>
       <!--
       <span class="r spot_line_status_two">&nbsp;</span>
       -->
       <div class="c"></div>
    </div>
    <div class="details_tille mt7">
      <ul>
       <li id="tab1" class="f details_tille_on" onclick="checkTab(1);"><a href="#">团购预订</a></li>
      
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
         <li class="mt10"><span class="ico_start">&nbsp;</span>名称：<b><ww:property value="buying.name"/></b></li>
         
         <li><span class="ico_start">&nbsp;</span>团购期限：<ww:property value="buying.stime"/>至<ww:property value="buying.endtime"/></li>
         <li><span class="ico_start">&nbsp;</span>起团数：<ww:property value="buying.minnumber" /></li>
         <li><span class="ico_start">&nbsp;</span>是否预约：提前<ww:property value="buying.tiqiandays" />天</li>
         </ul>
         <div class="nohave"></div>
         <div class=" box">
       	<table width="470" border="1" cellspacing="0" cellpadding="0" class="box" >
       	
          <tr>
            <th class="hadow" width="40%" scope="col">门市价</th>
            <th class="hadow" width="40%" scope="col">团购价</th>
          </tr>
          
           
          <tr>
            <td align="center" class="font-f60-del">&yen;<ww:property value="buying.marketprice" /></td>
            <td align="center" class="font-f60-16">&yen;<ww:property value="buying.shopprice" /></td>
          </tr>
         
          <tr>
          <td align="center" colspan="3">
          <input type="button" class="bst" value="立即预定" onclick="bookbuying(<ww:property value="buying.id"/>);" />
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
	src="<ww:if test="ListBuyingimg==null||ListBuyingimg.size==0">images/NoImage.gif</ww:if>
	<ww:else><ww:property value="getImgPathByCode('showbuyingpath',GetbuyingImgPathByID(buyingid))" /></ww:else>" style="margin-top:0px; margin-left: -1px;height:200px;width:400px;">
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
	<ww:iterator value="ListBuyingimg" status="index">
        <li ><img src="<ww:property value="getImgPathByCode('showbuyingpath',imgurl)" />" /></li>
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
    
    <div class="box mt7" style="display: none">
        <div class="tit"><span class="low2 black f">详细信息</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="buying.descinfo"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
      
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">使用规则</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="buying.guize"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">温馨提示</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="buying.text2"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
     <div class="box mt7">
        <div class="tit"><span class="low2 black f">预订说明</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="buying.text3"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    <div class="box mt7">
        <div class="tit"><span class="low2 black f">备注</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="buying.beizhu"/>
                
                <div class="nohave"></div>
        </div>
    </div>
    </div>
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

