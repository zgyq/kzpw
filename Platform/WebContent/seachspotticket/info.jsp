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
<script src="js/jquery1.3.2.js" type=text/javascript></script>   


<SCRIPT src="js/hotelimage/base.js" type=text/javascript></SCRIPT>


<script type="text/javascript">



function bookSpotTicket(spoticketid) { 
	var startDate = '<ww:property value="startDate"/>';
	var endDate = '<ww:property value="endDate"/>';
window.location.href="spotticket!tobook.action?SpotTicketID="+spoticketid+"&startDate="+startDate+"&endDate="+endDate;
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
	
	



</script>
<body>
<div>
	
<!--top over-->
<div id="hotel" style="margin-top: 51px;width: 1024px;">
      
 <div id="list" class="r" style="width: 1124px;">

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
         
         <li><span class="ico_start">&nbsp;</span>区&nbsp;&nbsp;&nbsp;域：<ww:property value="spotmes.cid"/></li>
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
    <form action="hotel!toHotelInfo.action" method="post" name="form2" id="form2">   
    			 <input type="hidden" id="city_from_" name="HotelId" value="<ww:property value="hotel.id"/>" />
			   <input type="hidden" id="hidcityid" value="<ww:property value="cityId"/>" />
				<input type="hidden" id="hidhotelcode" value="<ww:property value="hotel.hotelcode"/>" />
				<input type="hidden" id="hidhotelid" value="<ww:property value="hotel.id"/>" />
				<input type="hidden" id="hidstime" value="<ww:property value="startDate"/>" />
				<input type="hidden" id="hidendtime" value="<ww:property value="endDate"/>" />
				<input type="hidden" id="hidcitycode" value="<ww:property value="s_citycode"/>" />
				
				
       <div class="" style="width: 1100px;">
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
       
       <table width="1100" border="1" cellspacing="0" cellpadding="0" class="box" >
          <tr>
            <th class="hadow" width="40%" scope="col">名称</th>
            <th class="hadow" width="10%" scope="col">门市价</th>
            <th class="hadow" width="10%" scope="col">现付价</th>
            <th class="hadow" width="10%" scope="col">票量</th>
            <th class="hadow" width="5%" scope="col">起订</th>
            <th class="hadow" width="10%" scope="col">检票类型</th>
           
            <th class="hadow" scope="col">预定<ww:property value="ListSpotticket" /></th>
          </tr>
           <form action="#" method="post">
           <ww:iterator value="ListSpotticket2" status="index">
          <tr>
            <td class="floatall">
               <a href="#" class="l06c"><ww:property value="name" /></a>
            </td>
            <td class="font-f60-del">&yen;<ww:property value="(marketprice)" /></td>
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
        <div class="tit"><span class="low2 black f">温馨提示</span></div>
        <div class="service">
                 <div class="nohave"></div>
                <ww:property value="ShowHTML(spotmes.guidelines,'info')"/>
                
                <div class="nohave"></div>
        </div>
    </div> 
    -->
    </div>
    <!-- 基本信息结束 -->  
    
     
      
    
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
<script src="js/hotelimage/lib.js" type=text/javascript></script>


</body>
</html>

