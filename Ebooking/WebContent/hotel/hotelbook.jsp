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
<ww:head name="" jsURL="" />
<!--
<link href="style/tip-yellowsimple.css" rel="stylesheet" type="text/css" title="no title" charset="utf-8" />
<script src="js/jquery/jquery.poshytip.js" type="text/javascript"></script>
-->
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_data_pp.js"></script>
<script src="js/jason/json2.js" type="text/javascript"></script>
<script src="js/jason/jquery.tmpl.js" type="text/javascript"></script>
<script src="js/citycontrol/PublicJs.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
 var passengerJsonString='[{ ID: "1",Name:"",Type:"1"}]';
 var passengers=eval(passengerJsonString); 
 
$(document).ready(function(){
  loadCityData();
  //addpassenger(1);
    $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
  

});

function lodnum(countPrice){
var num=$("#ddlSelectRoomCount").val();

$("#hidroomnum").val(num);
   		var ind=0;
	   $("tr[id*='divinformation_']").each(function(i){
             ind++;
       });
       
      
        for(i=1;i<=parseInt(ind+1);i++){
        $("#divinformation_"+i).remove();
        }
 for(i=1;i<=parseInt(num);i++){
 addpassenger('');
 }
  var zpice = num*parseFloat(countPrice);
            
  tempnum = Math.round(zpice*100)/100;  
            
 document.getElementById("zongjia").innerHTML=tempnum;
 
 }


 //添加乘机人
	function addpassenger(jsonpassenger)
	{
		
	var num=$("#ddlSelectRoomCount").val();
	//alert("num=="+num);
	
	  
	   if(jsonpassenger=="")
	   {
	  		 var currentindex=1;
	   $("tr[id*='divinformation_']").each(function(i){
             currentindex++;
       });
       //alert(currentindex);
	   var currentpassenger=JSON.stringify(passengers);
		   passengerJsonString="[";
		   passengerJsonString+='{ID: '+currentindex+', Name:"",Type:"1"}';
		   passengerJsonString+="]";
		   
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	   }
	   else
	   {
	   	   passengerJsonString="[";
		   passengerJsonString+='{ID: '+currentindex+', Name:"",Type:"1"}';
		   passengerJsonString+="]";
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	   }
	   
	
	   
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
function showORhide(id,type){
if(type=='show'){
$("#"+id).show(); 
}else{
$("#"+id).hide(); 
}

}
var isfalse="1";
function  confirminfo(){
 var name=document.getElementsByName("InRoomPeople");
 //alert(name.length);
  for(var i=0;i<name.length;i++){
   //alert(name[i].value);
  if(name[i].value==''){
  		$("#idnumber_"+(i+1)).poshytip({
					content: "客人姓名不能为空!",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
				    
			 	$("#idnumber_"+(i+1)).focus();
			 	 isfalse="0";
				return false;
		   
		    }else{
		    	isfalse="1";
		    }
}
if($("#LinkName").val()==""){

	       	$("#LinkName").poshytip({
				content: "联系人不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#LinkName").focus();
			     isfalse="0";
			     return false;
			    
}else{
		    	isfalse="1";
		    }
if($("#linkmobile").val()==""){

	       	$("#linkmobile").poshytip({
				content: "手机号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#linkmobile").focus();
			     isfalse="0";
			     return false;
			    
}else{
		    	isfalse="1";
		    }
 if(!IsMobile($("#linkmobile").val())){

	       	$("#linkmobile").poshytip({
				content: "手机号码格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#linkmobile").focus();
			     isfalse="0";
			     return false;
			    
}else{
		    	isfalse="1";
		    }


 if($("#linkmail").val()==""){

	       	$("#linkmail").poshytip({
				content: "电子邮件不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#linkmail").focus();
			     isfalse="0";
			     return false;
			    
}else{
		    	isfalse="1";
		    }
 if(!IsEMail($("#linkmail").val())){
	       	$("#linkmail").poshytip({
				content: "电子邮件格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#linkmail").focus();
			     isfalse="0";
			     return false;
			    
}else{
		    	isfalse="1";
		    }
//判断信用卡
var isdanbao= $("#isdanbao").val();
if(isdanbao=='1'){//需要担保
 if($("#kahao").val()==""){

	       	$("#kahao").poshytip({
				content: "信用卡卡号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#kahao").focus();
			     isfalse="0";
			     return false;
			    
}else{
isfalse="1";
}

//判断要不要CVV
//var cvvtext=document.getElementById("cvvtext"); 
//var cvvtext=$("cvvtext").css("display");
var cvvtext=$("#cvvtext").is(":visible"); 


if(cvvtext=='true'){
	if($("#cvv").val()==""){
		$("#cvv").poshytip({
					content: "信用卡CVV不能为空!",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
				    $("#cvv").focus();
				     isfalse="0";
				     return false;
	}else{
	isfalse="1";
	}
}

if($("#xingming").val()==""){
		$("#xingming").poshytip({
					content: "持卡人姓名不能为空!",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
				    $("#xingming").focus();
				     isfalse="0";
				     return false;
	}else{
	isfalse="1";
	}
if($("#haoma").val()==""){
		$("#haoma").poshytip({
					content: "证件号码不能为空!",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
				    $("#haoma").focus();
				     isfalse="0";
				     return false;
	}else{
	isfalse="1";
	}


}

 

if(isfalse=='0'){
return;
}

//var Sname="";
//for(var i=0;i<name.length;i++){
 //Sname+="<font class='font-f60-16 mr25'>"+name[i].value+"</font>";
 //}
//$("#hidname").html(Sname);

//$("#hidmobile").html($("#linkmobile").val());

//$("#hidemail").html($("#linkmail").val());
//$("#hidname").html($("#linkName").val());

//var redCheckd=1;
//if(document.getElementById("red1").checked){
//redCheckd=1;
//}
//if(document.getElementById("red2").checked){
//redCheckd=2;
//}
//document.getElementById("status").className="r status_four"; 
//document.getElementById("cred"+redCheckd).checked=true;

//$("#confirminfovalue").show(); 
//$("#infovalue").hide(); 
}
function  editinfo(){
$("#infovalue").show(); 
$("#confirminfovalue").hide(); 
document.getElementById("status").className="r status_three"; 
}
function formSub(){
confirminfo();
if(isfalse=='0'){
return;
}



document.form2.submit();
}

function valadateIsBook(){
confirminfo();
if(isfalse=='0'){
return;
}


var stime='<ww:property value="startDate"/>';//入住日期
var endtime='<ww:property value="endDate"/>';//离店日期
var EarliestArrivalTime=$("#reservstart").val();
var LatestArrivalTime=$("#reservend").val();
var hotelid='<ww:property value="hotel.id"/>';
var roomtypeid='<ww:property value="RoomTypeid"/>';
var RatePlanId='<ww:property value="pricecode"/>';
var TotalPrice="";
var NumberOfRooms=$("#ddlSelectRoomCount").val();
var zj='<ww:property value="formatMoney_string(zongjia)" />';
TotalPrice=NumberOfRooms*parseFloat(zj);

//alert(stime+","+endtime+","+EarliestArrivalTime+","+LatestArrivalTime+","+hotelid+","+roomtypeid+","+RatePlanId+","+NumberOfRooms+","+TotalPrice);

var ret="-1@-1@-1@-1";

 	$.ajax({
	         type:"POST",
	         url:"hotel!valadateElongHotelIsBook.jspx",
	         data:{startDate:stime,endDate:endtime,EarliestArrivalTime:EarliestArrivalTime,LatestArrivalTime:LatestArrivalTime,HotelId:hotelid,pricecode:RatePlanId,RoomTypeid:roomtypeid,NumberOfRooms:NumberOfRooms,s_price:TotalPrice},
	         //beforeSend:function(){$("#HotelRoomPrice").html("<img src='images/loadding.gif' />")},
	         async:false,              
	         success:function(data){
	       		// alert(data);
	       		 ret=data;
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         //$("#HotelRoomPrice").html(data);
	         
	         }            
	         });

	var rets=ret.split("@");
	if(rets[0]!='-1'){
		if(rets[0]=='0'&&rets[1]!='0'){
			alert("预订该酒店需要担保:"+rets[1]+"元!");
			 $("#xinyongka").show();
			 $("#submitreg").show();
			 $("#book").show();
			 $("#isdanbao").val("1");
			 
		}else{
			alert("不需要担保");
			 $("#xinyongka").hide();
			  $("#submitreg").show();
			 $("#book").show();
			 $("#isdanbao").val("0");
			  $("#kahao").val("");
			 //
		}
	}else{
	alert("不可预订");
	$("#book").hide();
	}
	
}

function CheckCardNO(cardno){
	if(cardno==''){
	alert("信用卡卡号不能为空!!!");
	return;
	}
	$.ajax({
	         type:"POST",
	         url:"hotel!valadateElongHotelCardNO.jspx",
	         data:{cardno:cardno},
	         //beforeSend:function(){$("#HotelRoomPrice").html("<img src='images/loadding.gif' />")},
	         async:false,              
	         success:function(data){
	       		// alert(data);
	       		 //data="0";
	       		if(data=='-1'){
	       		alert("信用卡号错误");
	       		 $("#book").hide();
	       		}
	       		if(data=='0'){
	       		alert("要CVV");
	       		  //$("#cvvtext").show();
	       		  document.getElementById('cvvtext').display='back';
	       		  $("#cvvtext").show();
	       		   $("#book").show();
	       		   
	       		}
	       		if(data=='1'){
	       		alert("不要CVV");
	       		 //$("#cvvtext").hide();
	       		 document.getElementById('cvvtext').display='none';
	       		 $("#cvvtext").hide();
	       		 $("#cvv").val("");
	       		  $("#book").show();
	       		}
	         //HotelRoomPrice_
	         //$("#DIVHotelRoomPrice_"+i).hide();
	         //$("#HotelRoomPrice").html(data);
	         
	         }            
	         });

}

function changtime(){
$("#book").hide();
}
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel" >
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
           <option value="4">-------四星级-------</option>
           <option value="5">-------五星级-------</option>
           </select></li>
           <li class="searchall">价额范围：
           <select name="s_price" class="sel_search">
         				  <option value="0" >不限</option>  
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
          <div class="mt7"><img src="images/hotel/ad_hotel_01.jpg" width="260" height="100" /></div>   
          <!-- <div class="searchbot"></div> -->
          <!-- <div class="mt7"><img src="images/ad_260_60.jpg" width="260" height="60" title="地图上找酒店，精彩尽在于此。" /> </div> -->
          <div class="mt7">
             <div class="tit" style=" border:1px solid #E3E3E3; border-bottom:none;">
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
                 
          </div>
             
      </div>
 <div id="list" class="r">

    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">预定酒店</font>
       <span class="r status_three" id="status">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="c"></div>
    <div class="mt7 ">     
    <form action="hotel!tobook.jspx" method="post" name="form3" id="form3">
       <div class="">
           <div class="f list_top_left">&nbsp;</div> 
           <div class="f list_top list_bg">
               <div class="f"><a href="#" class="c09f"><ww:property value="hotel.name" /></a></div>
               <div class="r">
            <input type="hidden"  name="RoomTypeid" value="<ww:property value="RoomTypeid"/>" />
			<input type="hidden"  name="HotelId" value="<ww:property value="HotelId"/>" />
			
               入住日期：<input type="text" class="text_nameorder" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})" /> 
               离店日期：<input type="text" class="text_nameorder" id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
              <input type="submit" value="修改" class="bnt_new fff hand"  /></div>
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
       </form>
       <div class="mt7 information list_table ">
       <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box">
          <tr>
            <th class="hadow" width="20%" scope="col">房型</th>
            <th class="hadow" width="15%" scope="col">入住时间</th>
            <th class="hadow" width="15%" scope="col">离店时间</th>
            <th class="hadow" width="15%" scope="col">早餐</th>
            <th class="hadow" width="10%" scope="col">床型</th>
            <th class="hadow" width="10%" scope="col">宽带</th>
            <th class="hadow" scope="col">首日房价</th>
          </tr> 
          <tr>
            <td class="floatall">
                <span class="ico_room">&nbsp;</span><a href="#" class="l06c"><ww:property value="roomtype.name" /></a>
                <div class="float_room msg" style="display:none;">
                  <ul class="msgul">
                  <li class=" pt5"><img src="images/hotel.jpg" width="90" height="80" /></li>
                  <li>高级双人床</li>
                  </ul>
                </div>    
            </td>
            <td class="f90"><ww:property value="startDate" /></td>
            <td class="f90"><ww:property value="endDate" /></td>
            <td>
            <ww:if test="roomtype.breakfast!=null&&roomtype.breakfast!=''"><ww:property value="roomtype.breakfast" /></ww:if>
           <ww:else>不含早</ww:else>
            </td>
            <td><ww:property value="roomtype.bed" /></td>
            <td><ww:property value="roomtype.wideband" /></td>
            <td class="font-f60-16">&yen;<ww:property value="listNightlyRate.get(0).Member"/></td>
          </tr>         
        </table>
       </div>
       <div class="information booking_table">
       <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box mt10">
          <tr>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(startDate)" /></th>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(Date2)" /></th>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(Date3)" /></th>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(Date4)" /></th>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(Date5)" /></th>
            <th class="hadow" width="14.4%" scope="col"><ww:property value="getWeekStr(Date6)" /></th>
            <th class="hadow" scope="col"><ww:property value="getWeekStr(Date7)" /></th>
          </tr> 
          <tr>
             <ww:iterator value="listNightlyRate" status="index">
             <td>
             <ww:property value="Member" /></td>
             <ww:if test="(#index.index+1)%7==0&&#index.index!=0">
             <tr></tr>
            
             </ww:if>
            	 <ww:if test="#index.last">
					<ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
						<ww:param name="'first'" value="(#index.index+1)%7" />
						<ww:param name="'last'" value="6" />
					</ww:bean>
						<ww:if test="listNightlyRate.size%7==0">
						
						</ww:if><ww:else>
									<ww:iterator value="#counter" status="state">
										<td align="center" class="font-f60-16"><span class="time"></span></td>
									</ww:iterator>
						</ww:else>
				</ww:if>
             </ww:iterator>
             </tr>
            <!--
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
            <td align="center" class="font-f60-16">&yen;300<span class="time">11-12</span></td>
          -->
           
        </table>
       </div>
        <ww:if test="listBookingRules!=null&&listBookingRules.size>0">
       <div class="box mt10 total floatall">
	       <span class="low2 black f">预订规则:</span>&nbsp;&nbsp;&nbsp;
		      <font class="f90">
		       <ww:iterator value="listBookingRules">
			   <ww:property value="Description"/>
			   </ww:iterator>
		      </font>
       </div>
       </ww:if>
       <ww:if test="listGuaranteeRule!=null&&listGuaranteeRule.size>0">
       <div class="box mt10">
	       <span class="low2 black f">担保规则:</span>&nbsp;&nbsp;&nbsp;
	        <font class="f90">
		        <ww:iterator value="listGuaranteeRule">
				<ww:property value="Description"/>
			    </ww:iterator>
	       </font>
       </div>
       </ww:if>
       
       <div class="box mt10 total floatall">
         <div class="total_main">间数：
         <select name="" class=" mr25" onchange="lodnum('<ww:property value="formatMoney_string(zongjia)" />');" id="ddlSelectRoomCount">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
         </select>
         <font class="mf31">合计：</font><font  class="font-f60-16">&yen;<span id="zongjia"><ww:property value="formatMoney_string(zongjia)" /></span></font><font  class="c999">&nbsp;(到店付款)</font><font style="display: none;" class="mf45" onmouseover="showORhide('hidtext','show');" onmouseout="showORhide('hidtext','hide');" >优惠：订酒店返现金</font><span class="ico_tipsed">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
         <div class="tips_total box" id="hidtext" style="display: none">您入住酒店并结帐，在离店后60天内登录住哪网点评入住 酒店后，我们将会返还<font class="f90">60元</font>至您的住哪网帐户中。</div>
         
         </div>
       </div>
    </div>
    
    <form action="hotel!book.jspx" method="post" name="form2" id="form2">
    <div class="mt7 box" id="infovalue">
       <div class="tit"><span class="low2 black f">入住信息：</span><font class="f90"></font>欢迎来到${compname}商旅网预定酒店。</div>
       <div class="mt20 check_one">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <table id="divpassengers">
         <script id="passengerTemplate" type="text/x-jquery-tmpl"> 
          <tr id="divinformation_\${ID}">
            <td width="130" align="right">客人姓名：</td>
            <td><input type="text" class="text_regsitlatter" name="InRoomPeople" id="idnumber_\${ID}" /> </td>
          </tr>
          </script>
        </table>	
         <table>
          <tr>
            <td align="right">&nbsp;</td>
            <td><font class="c999">每个房间只填写一个入住人姓名即可.</font><span class="ico_tipsed">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
          </tr>
          
          <tr>
            <td align="right">联系人：</td>
            <td><input type="text" class="sel_searchor" name="LinkName" id="LinkName" value="<ww:property value="#session.loginuser.membername" />" /><font class="c999 mf15">(用于接收订单确认短信。)</font></td>
          </tr>
          <tr>
            <td align="right">联系手机：</td>
            <td><input type="text" class="sel_searchor" name="LinkMobile" id="linkmobile" value="<ww:property value="#session.loginuser.mobile" />" /><font class="c999 mf15">(用于接收订单确认短信。)</font></td>
          </tr>
          <tr>
            <td align="right">Email：</td>
            <td><input type="text" class="sel_searchor" id="linkmail" name="LinkMail" value="<ww:property value="#session.loginuser.memberemail" />" /><font class="c999 mf15">建议填写</font></td>
          </tr>
          <tr>
            <td align="right">房间保留时间：</td>
            <td>
            
         <!--<ww:if test="listGuaranteeRule!=null&&listGuaranteeRule.size>0">
		<input type="hidden" id="reservstart" name="hotelorder.reservstart" value="<ww:property value="getDaoDianTime(listGuaranteeRule.get(0).StartTime)"/>" />
		<input type="hidden" id="reservend" name="hotelorder.reservend" value="<ww:property value="listGuaranteeRule.get(0).StartTime"/>" />
		 <input name="baoliutime" id="red1" type="radio" value="1" checked="checked" /><ww:property value="listGuaranteeRule.get(0).StartTime"/>之前
		 <input name="baoliutime" id="red2" type="radio" value="2"  /><ww:property value="listGuaranteeRule.get(0).StartTime"/> 至 06:00期间(<font class="f00">需要信用卡担保房费</font>)
		</ww:if><ww:else>
		<input type="hidden" id="reservstart" name="hotelorder.reservstart" value="18:00" />
		<input type="hidden" id="reservend" name="hotelorder.reservend" value="22:00" />
		<input name="baoliutime" id="red1" type="radio" value="1" checked="checked" />20:00之前
        <input name="baoliutime" id="red2" type="radio" value="2" disabled="disabled" />20:00之后
		</ww:else>
		-->
		<select name="hotelorder.reservstart" onchange="changtime();" 
			style="width: 90px;" id="reservstart" >
			
			<option value="12:00" id="o12">12:00</option>
			
			<option value="13:00" id="o13">13:00</option>
			
			<option value="14:00" id="o14" selected="selected">14:00</option>
			
			<option value="15:00" id="o15">15:00</option>
			
			<option value="16:00" id="o16">16:00</option>
			
			<option value="17:00" id="o17">17:00</option>
		
			<option value="18:00" id="o18">18:00</option>
			
			<option value="19:00" id="o19">19:00</option>
			
			<option value="20:00" id="o20">20:00</option>
			
			<option value="21:00" id="o21">21:00</option>
			
			
			<!--  
			<option value="22:00" id="o22">22:00</option>
			<option value="23:00" id="o23">23:00</option>
			-->
		

		</select>
		至 <select name="hotelorder.reservend" onchange="changtime();" 
			style="width: 90px;" id="reservend" >
			
			
			<option value="12:00" id="op12">12:00</option>
			
			<option value="13:00" id="op13">13:00</option>
			
			<option value="14:00" id="op14">14:00</option>
			
			<option value="15:00" id="op15">15:00</option>
			
			<option value="16:00" id="op16">16:00</option>
			
			<option value="17:00" id="op17" selected="selected">17:00</option>
			
			<option value="18:00" id="op18" >18:00</option>
		
			<option value="19:00" id="op19">19:00</option>
			
			<option value="20:00" id="op20">20:00</option>
			
			<option value="21:00" id="op21">21:00</option>
			
			<option value="22:00" id="op22"  >22:00</option>
			
			<option value="23:00" id="op23" >23:00</option>
			
			

		</select> <b style="color: red">(请准确选择到店时间,提高成功率)</b>
		
		</td>
           
          </tr>
          <tr>
            <td colspan="2">
            <div class="check_tips">
              <ul>
              <li>· 房间保留至规定时间，如不能在规定时间前到酒店，请及时通知${compname}商旅网或与酒店联系。</li>
              <li>· 通常14点办理入住，早到可能需要等待。</li>
              </ul>
            </div></td>
          </tr>
        </table>
        </table> 
         <!-- 隐藏域值 -->
        <!-- 订单类型(1,国内 2,国际) -->
   
    
     <input name="HotelPrice" type="hidden" id="zprice" value="<ww:property value="zongjia"/>" />

	<ww:iterator value="listNightlyRate" status="index">
		<input name="HotelDayPrice" type="hidden" id="" value="<ww:property value="Member"  />" />
	</ww:iterator>
	<input name="HotelId" type="hidden" id="" value="<ww:property value="hotel.id"/>" />
	<input name="startDate" type="hidden" id="" value="<ww:property value="startDate"/>" />
	<input name="endDate" type="hidden" id="" value="<ww:property value="endDate"/>" />
	<input name="RoomTypeid" type="hidden" id="" value="<ww:property value="RoomTypeid"/>" />
	<input name="RoomTypeNum"  type="hidden" id="hidroomnum" value="1" /><!-- 房间数 -->
	<input  type="hidden" id="hidddlSelectRoomCount" value="1" />
	<input name="pricecode" type="hidden"  value="<ww:property value="pricecode"/>" />
	<input name="priceUsertype" type="hidden"  value="<ww:property value="priceUsertype"/>" />
       <!--  -->
    <input name="isdanbao" id="isdanbao" type="hidden"  value="0" />  
     
       </div>
       <div class="box_botm booking_line">&nbsp;</div>
       <div>&nbsp;</div>
       <!-- 以下为信用卡信息 -->
       <div id="xinyongka" style="display: none">
        <div class="tit"><span class="low2 black f">担保信息：</span><font class="f90"></font>担保订单预订成功后,如未入住,将扣除担保费用!!请谨慎操作!!!。</div>
       <div class="mt20 check_one">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td  align="right">发卡银行：</td>
            <td><select name="cardyhangname">
		<option value="招商银行">招商银行</option>
		<option value="建设银行">建设银行</option>
		<option value="工商银行">工商银行</option>
		<option value="交通银行">交通银行</option>
		<option value="广发银行">广发银行</option>
		<option value="浦发银行">浦发银行</option>
		<option value="农业银行">农业银行</option>
		<option value="中信银行">中信银行</option>
		<option value="兴业银行">兴业银行</option>
		<option value="光大银行">光大银行</option>
		<option value="华夏银行">华夏银行</option>
		<option value="民生银行">民生银行</option>
		<option value="其他银行">其他银行</option>
		</select></td>
          </tr>
          <tr>
            <td align="right">信用卡卡号：</td>
            <td><input type="text" class="sel_searchor" name="cardno" id="kahao" onchange="CheckCardNO(this.value)" value="" /><font class="c999 mf15">(请准确填写,系统会自动验证。)</font></td>
          </tr>
          <tr style="display: none" id="cvvtext">
            <td align="right">CVV：</td>
            <td><input type="text" class="sel_searchor" name="cardcvv" id="cvv" value="" /><font class="c999 mf15"></font></td>
          </tr>
           <tr style="">
            <td align="right">持卡人姓名：</td>
            <td><input type="text" class="sel_searchor" name="cardname" id="xingming" value="" /><font class="c999 mf15">(办卡时候留的姓名。)</font></td>
          </tr>
          <tr style="">
            <td align="right">证件类型：</td>
            <td><select name="idtype">
		<option value="0">身份证</option>
		<option value="1">护照</option>
		<option value="2">其他</option>
		</select></td>
          </tr>
          <tr style="">
            <td align="right">证件号码：</td>
            <td><input type="text" class="sel_searchor" name="idno" id="haoma" value="" /><font class="c999 mf15"></font></td>
          </tr>
          
          <tr>
            <td align="right">有效年：</td>
            <td>
			<select name="cardyear">
		<option value="2013">2013年</option>
		<option value="2014">2014年</option>
		<option value="2015">2015年</option>
		<option value="2016">2016年</option>
		<option value="2017">2017年</option>
		<option value="2018">2018年</option>
		<option value="2019">2019年</option>
		<option value="2020">2020年</option>
		<option value="2021">2021年</option>
		<option value="2022">2022年</option>
		<option value="2023">2023年</option>
		<option value="2024">2024年</option>
		<option value="2025">2025年</option>
		<option value="2026">2026年</option>
		<option value="2027">2027年</option>
		<option value="2028">2028年</option>
		<option value="2029">2029年</option>
		<option value="2030">2030年</option>
		<option value="2031">2031年</option>
		<option value="2032">2032年</option>
		<option value="2033">2033年</option>
		<option value="2034">2034年</option>
		<option value="2035">2035年</option>
		<option value="2036">2036年</option>
		<option value="2037">2037年</option>
		<option value="2038">2038年</option>
		<option value="2039">2039年</option>
		<option value="2040">2040年</option>
		
		</select>&nbsp;&nbsp;
		有效月<select name="cardmonth">
		<option value="1">1月</option>
		<option value="2">2月</option>
		<option value="3">3月</option>
		<option value="4">4月</option>
		<option value="5">5月</option>
		<option value="6">6月</option>
		<option value="7">7月</option>
		<option value="8">8月</option>
		<option value="9">9月</option>
		<option value="10">10月</option>
		<option value="11">11月</option>
		<option value="12">12月</option>
		</select><b style="color: red">(请准确选择有效期,提高成功率)</b>
		
		</td>
           
          </tr>
          <tr>
            <td colspan="2">
            <div class="check_tips">
              <ul>
             <li>· 信用卡担保。客人最早到店1天前可以变更取消，之后无法变更取消，如未入住，将扣除第一晚房费作为违约金</li>
              <li>· 如果不接受担保条件,请选择其他产品进行预订!!!。</li>
              </ul>
            </div></td>
          </tr>
        </table>
        </table> 
        
       </div>
       <div class="box_botm booking_line">&nbsp;</div>
       <div>&nbsp;</div>
       </div>
      
       
       
       
       <div class="booking_bnt">
       <ww:if test="listNightlyRate!=null&&listNightlyRate.size>0">
        <input type="button" id="submitreg" class="booking_bntton fff" value="验证下单" onclick="valadateIsBook();"  />
        <input type="button" id="book" style="display: none" class="booking_bntton fff" value="提交订单" onclick="formSub();"  />
       <!--
       <input type="button" class="booking_bntton fff" value="立即预览" onclick="confirminfo();"  />
       -->
       </ww:if><ww:else>
       <input type="button" class="booking_bntton fff" value="点击刷新" onclick="location.reload();"  />
       </ww:else>
        
       </div>
    </div>
   
   
    </form>
    
    <div class="mt7 box" style="display: none" id="confirminfovalue" >
       <div class="tit"><span class="low2 black f">入住信息：</span><font class="f90">13521463333</font>，欢迎来到${compname}商旅网预定酒店。</div>
       <div class="mt20 check_one">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="130" align="right">客人姓名：</td>
            <td>
            <span id="hidname"> <font class="font-f60-16 mr25">陈星</font><font class="font-f60-16 mr25">陈星</font><font class="font-f60-16 mr25">陈星</font></span>
            <!--
            <font class="font-f60-16 mr25">陈星</font><font class="font-f60-16 mr25">陈星</font><font class="font-f60-16 mr25">陈星</font>
            -->
            </td>
          </tr>
          <tr>
            <td align="right">&nbsp;</td>
            <td><font class="c999">每个房间只填写一个入住人姓名即可.</font><span class="ico_tipsed">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
          </tr>
           <tr>
            <td align="right">联系人：</td>
            <td><font class="font-f60-16" id="hidname">陈星</font><font class="c999 mf15">(用于方便联系。)</font></td>
          </tr>
          <tr>
            <td align="right">联系手机：</td>
            <td><font class="font-f60-16" id="hidmobile">13521463333</font><font class="c999 mf15">(用于接收订单确认短信。)</font></td>
          </tr>
          <tr>
            <td align="right">Email：</td>
            <td><font class="font-f60-16" id="hidemail">app00000@163.com</font></td>
          </tr>
          <!--<tr>
            <td align="right">房价保留时间：</td>
            <td>
            <input name="cred" id="cred1" type="radio" value="1" disabled="disabled"  />18:00之前
            <input name="cred" id="cred2" disabled="disabled" type="radio" value="2"  />18:00 至 06:00期间(<font class="f00">需要信用卡担保首晚房费118元</font>)</td>
          </tr>
          --><tr>
            <td colspan="2">
            <div class="check_tips">
              <ul>
              <li>· 房间保留至规定时间，如不能在规定时间前到酒店，请及时通知${compname}商旅网或与酒店联系。</li>
              <li>· 通常14点办理入住，早到可能需要等待。</li>
              </ul>
            </div></td>
          </tr>
        </table>
       </div>
       <div class="box_botm booking_line">&nbsp;</div>
       <div>&nbsp;</div>
       <div class="booking_bnt">
        <input type="button" class="booking_bntton fff" value="提交订单" onclick="formSub();"  />
        <input type="button" class="booking_bntton fff" value="修改信息" onclick="editinfo();"  />
       </div>
    </div>
   
 </div>
 <!--list over-->
 
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
</body>
</html>
