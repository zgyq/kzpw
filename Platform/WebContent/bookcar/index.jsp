<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店列表</title>
<link href="carcss/base.css" rel="stylesheet" type="text/css" />
<link href="carcss/car_rental.css" rel="stylesheet" type="text/css" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script src="js/jquery1.3.2.js" type=text/javascript></script>  
<script language="javascript" type="text/javascript" src="js/citycontrol/city_data_car.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_date2_car.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_date2.js"></script>


<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js/ext-all.js"></script>
	
<script type="text/javascript">
var currentcolor="#e2f4fe";
$(document).ready(function(){
   		
      loadCityDataToCar();
});
function checkTime(time){
//alert(time.split("-")[2]);
var TimeHH=<ww:property value="HH" />;
//alert(TimeHH);
var day=$("#txtcheckindate").val();
//alert("当前选择时间=="+day);
if(parseInt(time.split("-")[2])==parseInt(day.split("-")[2])){
//alert("当天!!!");

	for(a=8;a<parseInt(TimeHH);a++){
	
	document.getElementById("opt"+a).disabled="disabled";
	
	}
	

}else{
//alert("不是当天!!!");

	for(a=8;a<=18;a++){
	
	document.getElementById("opt"+a).disabled=false;
	
	}
	

}


}
</script>

</head>

<body >
<ww:if test="usertype!=2">
<div style="line-height:30px;" ><jsp:include page="../orderuserinfo.jsp"></jsp:include></div>
</ww:if>
<form action="bookcar!seach.action" method="post" name="form1" id="form1">

       <table width="90%"  border="1" bordercolor="#e6e6e6" cellspacing="0" cellpadding="0" style="line-height:30px; text-align:left; margin: 0 auto;">
          <tr>
            <td class="tex" align="right" width="90"  >取车城市：</td>
            <td class="texb" style="padding-left: 5px;"><input name=""  type="text" class="input" id="txthotelcity"  value="上海" onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " />
            <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="Scity" value="321"  />
             	  
            </td>
            <td class="tex" align="right" width="90"  >还车城市：</td>
            <td class="texb" style="padding-left: 5px;">
           		 <input name=""  type="text" class="input" id="txthotelcity2"  value="上海" onclick="this.value='';GetCityList2(this); " onkeyup="GetCityList2(this); " />
           
             	   <input type="hidden" id="city_hotel_hide2" name="Endcity" value="321"  />
              
            
            </td>
          </tr>
          
          <tr>
            <td class="tex" align="right">取车时间：</td>
            <td class="texb" style="padding-left: 5px;">
            <input  type="text" class="input70" id="txtcheckindate" value="<ww:property value="startDate" />" name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d'})" onchange="checkTime('<ww:property value="startDate" />');" />
           <select id="startDate_HH" name="startDate_HH" style="border:1px solid #ccc">
           <option value="8:00" id="opt8" <ww:if test="HH>8">disabled="disabled"</ww:if>  >8:00</option>
           <option value="9:00" id="opt9" <ww:if test="HH>9">disabled="disabled"</ww:if>  >9:00</option>
           <option value="10:00" id="opt10" <ww:if test="HH>10">disabled="disabled"</ww:if>  >10:00</option>
           <option value="11:00" id="opt11" <ww:if test="HH>11">disabled="disabled"</ww:if>  >11:00</option>
           <option value="12:00" id="opt12" <ww:if test="HH>12">disabled="disabled"</ww:if>  >12:00</option>
           <option value="13:00" id="opt13" <ww:if test="HH>13">disabled="disabled"</ww:if>  >13:00</option>
           <option value="14:00" id="opt14" <ww:if test="HH>14">disabled="disabled"</ww:if>  >14:00</option>
           <option value="15:00" id="opt15" <ww:if test="HH>15">disabled="disabled"</ww:if>  >15:00</option>
           <option value="16:00" id="opt16" <ww:if test="HH>16">disabled="disabled"</ww:if>  >16:00</option>
           <option value="17:00" id="opt17" <ww:if test="HH>17">disabled="disabled"</ww:if>  >17:00</option>
           <option value="18:00" id="opt18" <ww:if test="HH>18">disabled="disabled"</ww:if>  >18:00</option>
           <!--  
           <option value="8:00" <ww:if test="HH>8">disabled="disabled"</ww:if>  >8:00</option>
           <option value="9:00" <ww:if test="HH>9">disabled="disabled"</ww:if>  >9:00</option>
           <option value="10:00" <ww:if test="HH>10">disabled="disabled"</ww:if>  >10:00</option>
           <option value="11:00" <ww:if test="HH>11">disabled="disabled"</ww:if>  >11:00</option>
           <option value="12:00" <ww:if test="HH>12">disabled="disabled"</ww:if>  >12:00</option>
           <option value="13:00" <ww:if test="HH>13">disabled="disabled"</ww:if>  >13:00</option>
           <option value="14:00" <ww:if test="HH>14">disabled="disabled"</ww:if>  >14:00</option>
           <option value="15:00" <ww:if test="HH>15">disabled="disabled"</ww:if>  >15:00</option>
           <option value="16:00" <ww:if test="HH>16">disabled="disabled"</ww:if>  >16:00</option>
           <option value="17:00" <ww:if test="HH>17">disabled="disabled"</ww:if>  >17:00</option>
           <option value="18:00" <ww:if test="HH>18">disabled="disabled"</ww:if>  >18:00</option>
           <option value="19:00" <ww:if test="HH>19">disabled="disabled"</ww:if>  >19:00</option>
           <option value="20:00" <ww:if test="HH>20">disabled="disabled"</ww:if>  >20:00</option>
           <option value="21:00" <ww:if test="HH>21">disabled="disabled"</ww:if>  >21:00</option>
           <option value="22:00" <ww:if test="HH>22">disabled="disabled"</ww:if>  >22:00</option>
           -->
           </select>
           </td>

            
            <td class="tex" align="right">还车时间：</td>
            <td class="texb" style="padding-left: 5px;"><input type="text" class="input70" id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"  />
           <select name="endDate_HH" style="border:1px solid #ccc">
           <option value="8:00">8:00</option>
           <option value="9:00">9:00</option>
           <option value="10:00">10:00</option>
           <option value="11:00">11:00</option>
           <option value="12:00">12:00</option>
           <option value="13:00">13:00</option>
           <option value="14:00">14:00</option>
           <option value="15:00">15:00</option>
           <option value="16:00">16:00</option>
           <option value="17:00">17:00</option>
           <option value="18:00">18:00</option>
           <!--<option value="19:00">19:00</option>
           <option value="20:00">20:00</option>
           <option value="21:00">21:00</option>
           <option value="22:00">22:00</option>
           --></select>
            </td>
            
            
          </tr>
          <tr>
          <td class="tex" align="right" width="90">取车店铺：</td>
            <td class="texb" style="padding-left: 5px;">
             	 <div style="position: relative;">
            <input name="" id="txtcarstorename_s"  type="text" class="input"  value="请选择取车店铺" onclick="this.value='';lodregion_s('s','');" onkeyup="lodregion_s('s','');" />
             <div  id="regiondiv_s" class=""></div>
             <input type="hidden" id="hidregion_s" name="Sregion_s" value=""  />
             
              <input type="hidden" id="hidcarstore_s" name="Scarstore_s"   />
             </div>	   
            </td>
            
            
            

            <td class="tex" align="right" width="90">还车店铺：</td>
            <td class="texb" style="padding-left: 5px;">
            <div style="position: relative;"><input name="" id="txtcarstorename_e"  type="text" class="input"  value="请选择还车店铺" onclick="this.value='';lodregion_s('e','');" onkeyup="lodregion_s('e','');" />
             <div   id="regiondiv_e" class=""></div>
             <input type="hidden" id="hidregion_e" name="Sregion_e" value=""  />
             <input type="hidden" id="hidcarstore_e" name="Scarstore_e"   />
            </div>
            </td>
          </tr>
          <tr>
            <td colspan="4" height="40" class="texb" align="center"><input type="button" onclick="seach();"  value="租车预订" class="button" /></td>
          </tr>
       </table>

   </form>



</body>
</html>
	<script type="text/javascript">


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

function seach(){

if($("#startDate_HH").val()==null){
alert("请预订明天的车!!");

return;
}


if(document.getElementById("hidcarstore_s").value==''){

alert("请选择取车店铺!!!");
lodregion_s('s');
return;
}
if(document.getElementById("hidcarstore_e").value==''){
alert("请选择还车店铺!!!");
lodregion_s('e');
return;


}



   dispose('系统正在为您查询实时信息');
      document.form1.submit();
    
}


function  selectcar(id){
  $.ajax({
      type:"GET",
      url:"bookcar!getcarsbycity.action",
      data:{strCityId:id,para:Math.floor(Math.random()*100)},
      beforeSend:function(){$("#divCarHtml").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐信息...");},             
      success:function(data){
      $("#divCarHtml").html(data);           
      }            
      }); 
}
function ceachreg (ty){
var seaname="";

if(ty=='e'){
//seaname=document.getElementById("seachregion_e").value;
}else{
//seaname=document.getElementById("seachregion_s").value;
}

//alert(seaname);
//lodregion_s(ty,seaname);
}
function  lodregion_s(ty,sname){
//alert("ty=="+ty+"===sname=="+sname);

	
	
if(ty=='e'){
 $("#regiondiv_s").hide();
$("#Carstorediv_s").hide();


$("#regiondiv_e").show();
$("#Carstorediv_e").show();

		 
var cityid=document.getElementById("city_hotel_hide2").value;//还车城市
}else{
 $("#regiondiv_e").hide();
$("#Carstorediv_e").hide();

$("#regiondiv_s").show();
$("#Carstorediv_s").show();
var cityid=document.getElementById("city_hotel_hide").value;//取车城市
}

//alert("cityid=="+cityid);
  $.ajax({
      type:"GET",
      
      url:"bookcar!getregionbycity_s.action",
      data:{strCityId:cityid,strType:ty,strName:sname,para:Math.floor(Math.random()*100)},
      success:function(data){
   //  alert(data);
	    if(ty=='e'){//还车
	    	
	    	 $("#regiondiv_e").html(data); 
	    }else{
	      	$("#regiondiv_s").html(data); 
	      }
          
              
      }            
      }); 
}
function  lodcarstore_s(id_ty){
//alert("区域ID=="+id_ty);
var ids=id_ty.split(",");
var id=ids[0];
var ty=ids[1];
  $.ajax({
      type:"GET",
      
      url:"bookcar!getcarstorebyRegion_s.action",
      data:{strRegionId:id,strType:ty,para:Math.floor(Math.random()*100)},
      success:function(data){
     //alert(data);
	     if(ty=='e'){
	    // $("#regiondiv_s").hide();
		// $("#Carstorediv_s").hide();
		 
	     $("#Carstorediv_e").show();
	     
	     $("#Carstorediv_e").html(data);  
	     }else{
	     //$("#regiondiv_e").hide();
		// $("#Carstorediv_e").hide();
		 
	     $("#Carstorediv_s").show();
	      $("#Carstorediv_s").html(data);  
	      }         
      }            
      }); 

}


function checkcarstore(carstore_id_name){
//alert(carstore_id_name);
var carstore = carstore_id_name.split(",");
var ty = carstore[2];
	if(ty=='e'){
	document.getElementById("hidcarstore_e").value=carstore[0];//赋值ID到隐藏域
	document.getElementById("txtcarstorename_e").value=carstore[1];//赋值名字
	
	$("#regiondiv_e").hide();
	$("#Carstorediv_e").hide();
	}else{
	document.getElementById("hidcarstore_s").value=carstore[0];//赋值ID到隐藏域
	document.getElementById("txtcarstorename_s").value=carstore[1];//赋值名字
	
	$("#regiondiv_s").hide();
	$("#Carstorediv_s").hide();
	}
}

function colsediv(ty){
	if(ty=='e'){
	$("#Carstorediv_e").hide();
	$("#regiondiv_e").hide();
	}else{
	$("#Carstorediv_s").hide();
	$("#regiondiv_s").hide();
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
</script>