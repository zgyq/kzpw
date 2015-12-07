<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<%@page import="java.util.*" %>
<%@page import="com.yf.system.back.server.Server"%>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店信息:酒店预订,宾馆预订,特价酒店，国内酒店，国际酒店---天河联盟旅行网</title>
<link href="hstyle/index.css" type="text/css" rel="stylesheet" />
<link href="hstyle/base.css" type="text/css" rel="stylesheet" />
<link href="hstyle/hotel.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/hstyle/mapcss.css" /> 
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />
<link href="hstyle/css.css" type="text/css" rel="stylesheet" />
<script language="javascript" type=text/javascript src="js/jquery1.3.2.js" ></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


<SCRIPT src="js/base.js" type=text/javascript></SCRIPT>
<script language="javascript" type="text/javascript" src="js/citycontrol/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_data_pp.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_date2.js"></script>


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	
<SCRIPT type=text/javascript>
$(document).ready(function(){
      loadpic();
     
});


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
	</SCRIPT>


<script type="text/javascript">


function seach(){
    document.form1.submit();
}
function seachto(){
					//$("#t_aftersub").show();
			       // $("#ff1").hide();
			         dispose('系统正在为您查询实时信息');		 
    document.form2.submit();
}
//选项卡切换

</script>
<SCRIPT src="js/hotelimage/base.js" type=text/javascript></SCRIPT>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false&language=zh"></script>
<script type="text/javascript">  

 	  var map;   
    /*  
        latitude 纬度   
        longitude 精度   
        title 悬浮在标记图标上显示的内容  
        openInfo 提示窗口内容(InfoWindow)  
    */  
    function initialize(latitude,longitude,title,openInfo) {   
  
       //地图定位   
       var myLatlng = new google.maps.LatLng(latitude,longitude);   
       var myOptions = {   
                zoom : 11,          //地图的缩放程度   
               center : myLatlng,  //地图中心位置   
               mapTypeId : google.maps.MapTypeId.ROADMAP   
            };   
  
       //把地图绑定在ID为map_canvas的DIV上   
        map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);   
  
        //显示地址的标记图标   
        var marker = new google.maps.Marker({   
            position: myLatlng,    
            map: map,    
           title:title   
         //  icon: 'http://google-maps-icons.googlecode.com/files/factory.png'   //自定义标记图标   
      });   
  
      //  var infowindow = new google.maps.InfoWindow({           //InfoWindow 内容提示   
      //      content: openInfo,   
       //     position: myLatlng   
      //  });    
           
        infowindow.open(map);   //显示提示主窗口   
  
       //给marker添加点击事件   
        google.maps.event.addListener(marker, 'click', function() {   
           infowindow.open(map); //如果提示窗口关闭了，点击标记图标可再次显示提示主窗口   
       });    
    }   





	function xianshi(s) { 
	//alert("xians");
	document.getElementById("ccc"+s).style.display="block";
	
	  }	
function yingcang(d) { 
	//alert("yingcang");
	document.getElementById("ccc"+d).style.display="none";
	
	  }	
function yud(roomid,hotelid,cityId) { 
dispose('系统正在为您查询实时信息');

	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';
//alert("roomid=="+roomid+".....hotelid=="+hotelid+".....startDate=="+startDate+"...endDate=="+endDate);

window.location.href="hoteluserbook!toyuding.action?regionid=<ww:property value='regionid'/>&hotelid="+hotelid+"&roomid="+roomid+"&startDate="+startDate+"&endDate="+endDate+"&cityId="+cityId;


	
	
	  }	
function yd(roomcode,name,hotelid) { 
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';
	
	name = encodeURI(name); 
	name = encodeURI(name); 
	
//alert("roomcode=="+roomcode+".name===+"+name+"....hotelid=="+hotelid+".....startDate=="+startDate+"...endDate=="+endDate);
window.location.href="hoteluserbook!toyuding.action?regionid=<ww:property value='regionid'/>&hotelid="+hotelid+"&roomcode="+roomcode+"&roomname="+name+"&startDate="+startDate+"&endDate="+endDate;
	  }	
	</script>
</head>

<body>

<div id="container">
<div id="content">



<!-------------搜索结束------------->



<!--推荐酒店结束-->

<!--最新活动结束--></div>
<!------------left 结束------------->
<div class="right" id="ff1">
<div><img src="images/buzhou_1.gif" width="674" height="39" /></div>
<div class="jiudian" style="margin-top: 3px;">
<div class="chang_list"><b class="lan_14 f"><ww:property value="hotel.name" /></b>

</div>
<div style="padding-top: 15px;">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td rowspan="3" height="140" width="230">
			<div  style=" width: 210px;">

<div id=preview style="margin-top: -5px; margin-left: 10px;" >
	<div class=jqzoom id=spec-n1 style="width:210px; height: 120px; overflow: hidden">
	<table style="widows: 100%; height: 100%">
		<tr>
			<td valign="middle" style="" align="center"><IMG 
	src="<ww:if test="ListHotelimage==null||ListHotelimage.size==0">images/NoImage.gif</ww:if>
	<ww:else>http://www.elongstatic.com/imageapp/hotels/hotelimages<ww:property value="ListHotelimage.get(0).path"/></ww:else>" style="margin-top:0px; margin-left: -5px;height:116px;width:206px;">
	</td>
		</tr>
	</table>
	</div>
	<div id=spec-n5>
		<div class="control" id=spec-left >
			
			<img src="images/left2.gif" />
		</div>
		<div id=spec-list STYLE="width:188px; overflow: hidden;" >
			<ul class=list-h style="width:188px;">
	<ww:iterator value="ListHotelimage" status="index">
      <li ><img src="<ww:property value="getImageSRcinfo(path)"/>" /></li>
     </ww:iterator>
			<!-- <img src="<ww:property value="getImgPath(path)"/>" /> -->
			</ul>
		</div>
		<div  id=spec-right>
			<img src="images/right2.gif" />
		</div>
		
    </div>
</div>							
		
			</div>
		</td>
		<td height=""></td>
	</tr>
	
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="line-height: 18px;">
			<tr>
				<td width="70"><strong>英文名称：</strong></td>
				<td><ww:property value="hotel.enname" /></td>
			</tr>
			<tr>
				<td width="70"><strong>开业时间：</strong></td>
				<td><ww:property value="formatDate(hotel.opendate)" /></td>
			</tr>
			<tr>
				<td width="70"><strong>装修时间：</strong></td>
				<td><ww:property value="formatDate(hotel.repaildate)" /></td>
			</tr>
			<tr>
				<td width="70"><strong>酒店电话：</strong></td>
				<td>
				<ww:if test="hotel.tortell==null">
				暂无信息
				</ww:if><ww:else>
				<ww:property value="hotel.tortell" />
				</ww:else>
				</td>
			</tr>
			<tr>
				<td width="70"><strong>酒店星级：</strong></td>
				<td>
				<ww:if test="hotel.star==null||hotel.star==0"></ww:if>
			<span style="color: red">经济型</span>
			
			<ww:else>
			<ww:property value="getStarico(hotel.star)" />
			</ww:else>
				</td>
			</tr>
			<tr>
				<td><strong>地区信息：</strong></td>
				<td><ww:property value="getRegionNameByStr(hotel.regionid1)" /><ww:property value="getRegionNameByStr(hotel.regionid2)" /><ww:property value="getRegionNameByStr(hotel.regionid3)" /></td>
			</tr>
			<tr>
				<td valign="top"><strong>酒店说明：</strong></td>
				<td title="<ww:property value="hotel.description"/>"><ww:property value="SubString(hotel.description,100)" />……
				</td>
			</tr>
		</table>


		</td>
	</tr>
</table>

</div>
<div class="kongfang"><input type="button" class="button_kf"
	value="▲更改入住时间" /></div>
<div style="padding-top: 5px;">
<form action="hoteluserbook!toDetail.action" method="post" name="form2" id="form2">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 30px;">
	<tr>
		<td width="40%"><b style="color: #0093ff">您希望的入住时间？</b></td>
		<td width="20%"><b>入住日期:<b></td>
		<td width="20%"><b>退房日期:<b></td>
		<td>&nbsp;</td>
	<input type="hidden" id="city_from_hide" name="cityId"
			value="<ww:property value="cityId"/>" />
		<input type="hidden" id="city_from_" name="hotelid"
			value="<ww:property value="hotelid"/>" />
	</tr>
	<tr bgcolor="#e6edf6">
		<td class="box_top lanh box_bo_xu">选择您的入住时期以查询空房情况</td>
		<td class="box_top box_bo_xu"><input type="text" class="Wdate input198" style="width:80px;" id="txtcheckindate2" name="startDate"
					value="<ww:property value="startDate"/>" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate2.focus();}})"  /></td>
		<td class="box_top box_bo_xu"><input type="text" class="Wdate input198" style="width:80px;"  id="txtcheckoutdate2" name="endDate" 
					value="<ww:property value="endDate"/>" onfocus="this.value=getDateDiff($('#txtcheckindate2').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate2\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"/></td>
	    <td class="box_top box_bo_xu"><span			><input type="button" class="button_sj"
			value="修改入住时间" onclick="seachto();" /></span></td>
	</tr>
	<tr>
		<td colspan="4"><b ><ww:property value="startDate"/>至<ww:property value="endDate"/>&nbsp;&nbsp;共<ww:property value="s_num" />晚</b></td>
	</tr>
</table>
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 35px; text-align: center; border-collapse: collapse">
	<tr bgcolor="#537cb4" class="hui14">
		<td width="15%" class="box_r">客房类型</td>
		<td width="10%" class="box_r">门市价</td>
		<td width="10%" class="box_r">首日价</td>
		<td width="15%" class="box_r">每日价</td>
		<!--
		<td width="15%" class="box_r">首日返利</td>
		-->
		<td width="10%" class="box_r">床型</td>
		<td width="10%" class="box_r">早餐</td>
		<td width="10%" class="box_r">宽带</td>
		<td class="box_r">操作</td>
	</tr>
	
		<span id="HotelRoomPrice" >
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
			<td colspan="6">
			<!--<span style="color: red;">正在努力为你查询酒店房型信息!<img src='images/loadding.gif' /></span>
			--></td>
			</tr>
		</span>

	
	
</table>
</div>
<div class="kongfang">
<input type="button" class="button_kf" value="详细介绍" /> 
</div>
<div class="box" style="text-indent: 2em; padding: 15px;display: block;" id="tuijian1">

<div class="f" style="width:420px;"><ww:property value="hotel.description" /></div>
<div class="r" style="text-align: right;">
<div class="box" style="padding:2px; line-height: 30px;">
<ul>
	<div  id="map_canvas" style="width: 400px; height:201px"></div>
	
</ul>

</div>


<!--<img src="images/fangda.gif" align="absmiddle" />&nbsp;<a target="_blank" style="width:400;height:300" href="hotel_map.jsp?s_city=<ww:property value="s_name"/>&hotelname=<ww:property value="hotel.name"/>&hoteltell=<ww:property value="hotel.tortell"/>&hotelfax=<ww:property value="hotel.fax1"/>&re=<ww:property value="hotel.lat"/>,<ww:property value="hotel.lng"/>">放大地图</a>


--></div>
<div class="c"></div>
</div>
</div>
<div class="kongfang">

<input type="button" class="button_kf"  value="酒店设施" />


</div>
<div class="box" style="padding: 15px;" >

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<!--
	<tr>
		<td width="170" class="box_bo_xu lan_16c">附加选择</td>
		<td class="box_bo_xu">自助早餐价 RMB 205</td>
	</tr>
	-->
	<tr>
		<td class="box_bo_xu lan_16c" style="width: 20%">可接收卡类型</td>
		<td class="box_bo_xu"><ww:property value="hotel.carttype" /></td>
	</tr>
	<tr>
		<td class="box_bo_xu lan_16c">宾馆服务项目</td>
		<td class="box_bo_xu"><ww:property value="hotel.serviceitem" /></td>
	</tr>
	<tr>
		<td  class="box_bo_xu lan_16c">宾馆餐饮设施</td>
		<td class="box_bo_xu"><ww:property value="hotel.footitem" /></td>
	</tr>
	<tr>
		<td class="box_bo_xu lan_16c">宾馆娱乐与健身设施</td>
		<td class="box_bo_xu"><ww:property value="hotel.playitem" /></td>
	</tr>
</table>
</div>

<div class="kongfang">

<input type="button" class="button_kf"  value="交通信息" />


</div>
<div class="box" style="padding: 15px;" >

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	
	<tr>
		<td class="box_bo_xu lan_16c">&nbsp;</td>
		<td class="box_bo_xu"><ww:property value="hotel.trafficinfo" /></td>
	</tr>
	
</table>
</div>




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

<input type="hidden" id="hidstime" value="<ww:property value="startDate"/>" />
<input type="hidden" id="hidendtime" value="<ww:property value="endDate"/>" />
<input type="hidden" id="hidcitycode" value="<ww:property value="s_citycode"/>" />
<input type="hidden" id="hidcityid" value="<ww:property value="cityId"/>" />
<input type="hidden" id="hidhotelcode" value="<ww:property value="hotel.hotelcode"/>" />
<input type="hidden" id="hidhotelid" value="<ww:property value="hotel.id"/>" />


<SCRIPT src="js/lib.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/163css.js" type=text/javascript></SCRIPT>
</body>
</html>
<script language="javascript">	
	
	
        $.ajax({
	         type:"POST",
	         url:"hoteluserbook!findHotelRoomPriceInfo.action",
	         data:{s_citycode:$("#hidcitycode").val(),s_hotelcode:$("#hidhotelcode").val(),s_stime:$("#hidstime").val(),s_endtime:$("#hidendtime").val(),s_hotelid:$("#hidhotelid").val()},
	         beforeSend:function(){$("#HotelRoomPrice").html("<img src='images/loadding.gif' />")},
	         async:false,              
	         success:function(data){
	        //alert(data);
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         $("#HotelRoomPrice").html(data);
	         
	         }            
	         });
      
	
	
</script>

<script language="javascript">
 function huan(a){
 
 for(var i=1;i<=5;i++)
 {
 	document.getElementById("tuijian"+i).style.display="none";
 	document.getElementById("t"+i).className="button_hui";
 	
 }
	document.getElementById("tuijian"+a).style.display="block";
    document.getElementById("t"+a).className="button_kf";

 }

</script>
<script type="text/javascript">

 function ShowHotelMap(re,hoteltell,hotelfax,spanName,hotelname)
     {
        var divMapInfo=document.getElementById("divIframe");
        divMapInfo.innerHTML="<iframe id='iframemap' marginwidth='0' framespacing='0' marginheight='0' width='100%' height='100%' frameborder='0'  ></iframe>";
        $("#iframemap").attr("src",'hotel_map.jsp?s_city=<ww:property value="s_name"/>&hotelname='+hotelname+'&hoteltell='+hoteltell+'&hotelfax='+hotelfax+'&re='+re);
        $("#"+spanName).click(function(event)
        {
           event.preventDefault();
           event.stopPropagation();
           $("#divIframe").dialog("open");
        });
        $("#divIframe").dialog({
                title:"<bb:out>电子地图|||電子地圖|||電子地図|||Electronic Map</bb:out>",
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 528,//容器宽度
                height: 360//容器高度
            });
     }
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
//		$(document).ready(function() {
			
//			$("#form1").validationEngine();
		
//		});

initialize('<ww:property value="hotel.lat"/>','<ww:property value="hotel.lng"/>','<ww:property value="hotel.name"/>','<ww:property value="hotel.name"/><ww:property value="hotel.tortell"/>');
</script>