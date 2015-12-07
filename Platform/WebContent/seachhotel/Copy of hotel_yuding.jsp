<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店预订:酒店预订,宾馆预订,特价酒店，国内酒店，国际酒店---天河联盟旅行网</title>
<link href="hstyle/base.css" type="text/css" rel="stylesheet" />
<link href="hstyle/hotel.css" type="text/css" rel="stylesheet" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="hstyle/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery1.3.2.js" type=text/javascript></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">


$(document).ready(function(){
        
    	
      var zj = <ww:property value="formatMoney_string(zongjia)" />
      
	  CreatePeople(zj);
	  //alert(zj);
		HidXinYongKaDiv();
	  
	  
});

function checkform(){




document.getElementById("hidsex").value="";
var sex= $("input[name^='Insex']");
			var se='';
	for( i=0; i<sex.length; i++)
	{
		if(sex[i].checked)
		{
		se+=sex[i].value+","
		}
		
	
	}
	
document.getElementById("hidsex").value=se;
				$("#form1").validationEngine(
				{
				
					success : function() {
			
							document.form1.submit();
					}
				}
			)
			
		
		
}

				
function duibi(a, b) {
    var arr = a.split("-");
    var starttime = new Date(arr[0], arr[1],arr[2]);
    var starttimes = starttime.getTime();

    var arrs = b.split("-");
    var lktime = new Date(arrs[0], arrs[1],arrs[2]);
    var lktimes = lktime.getTime();

    if (starttimes > lktimes) {

       // alert('入住大于当前时间');
        return true;
    }
    else{
   // alert('当前等于入住时间');
        return false;
	}
}

			

function checkTime(){
//担保日期
var DBstartDate=$("#DBstartDate").val();
var DBendDate=$("#DBendDate").val();
//担保时间
var DBStartTime=$("#DBStartTime").val();
var DBEndTime=$("#DBEndTime").val();
//入住时间
var startDate=$("#startDate").val();
var endDate=$("#endDate").val();
//限制房间数.超出了必须担保
var DBAmount=$("#DBAmount").val();
//当前日期
var Today = new Date();
var month=(Today.getMonth()+1);
month= month<10?"0"+month:month; 
var day=Today.getDate();
day= day<10?"0"+day:day; 

Today=Today.getFullYear()+"-"+month+"-"+day;
//alert(Today+","+startDate);     //获取当前日期	

var stime= $("#zuizao2").val();//选择的最早到店时间
var etime= $("#zuiwan2").val();//选择的最晚到店时间

if(duibi(startDate,Today)){
//alert("true");
for(sa=12;sa<21;sa++){
document.getElementById("o"+sa).disabled=false;
document.getElementById("op"+sa).disabled=false;
//document.getElementById("o14").selected="selected";
}
var st=stime.split(":")[0];
//alert(st);
for(a=12;a<=parseInt(st);a++){
document.getElementById("op"+a).disabled="disabled";
}
document.getElementById("op"+(parseInt(st)+1)).selected="selected";

//var newtime=""+(parseInt(st)+1)+":00";
//alert(newtime);
if(DBStartTime!=null&&DBStartTime!=''&&DBStartTime==stime){
alert("需要担保了");
}



}else{

alert("当天");
}








}

function seach(){
    document.form1.submit();
}
function sub(){
    document.form2.submit();
}
//根据预订间数增加客人姓名
function CreatePeople(countPrice)
{

//alert(countPrice);
 			document.getElementById("jianshu").innerHTML=$("#ddlSelectRoomCount").val();
 			document.getElementById("jian").innerHTML=$("#ddlSelectRoomCount").val();
            var zpice = $("#ddlSelectRoomCount").val()*parseFloat(countPrice);
            
             tempnum = Math.round(zpice*100)/100;  
            
            document.getElementById("zongjia").innerHTML=tempnum;
             document.getElementById("price").value=tempnum;
              document.getElementById("zj").innerHTML=tempnum;
             
           
              //alert(<ww:property value="rebvaule" />);
              //alert(tempnum*0.12);
              
             // if(<ww:property value="hotel.star" />==8||<ww:property value="hotel.star" />==9){//5星级得
            //  document.getElementById("fanli").innerHTML=Math.round(tempnum*0.09*<ww:property value="rebvaule" />).toFixed(2);//返利得
             // }else{
             //    document.getElementById("fanli").innerHTML=(tempnum*0.12*<ww:property value="rebvaule" />).toFixed(2);//返利得
            //  }
           // alert(<ww:property value="Hotelrebate" />);
             document.getElementById("fanli").innerHTML=($("#ddlSelectRoomCount").val()*<ww:property value="HotelPos" />).toFixed(2);//返利得
              
//B2B酒店预订才有得js
<ww:if test="usertype==2">
var yuprice = parseFloat(tempnum)*0.1;
	yuprice=Math.round(yuprice);
var yufan = parseFloat(tempnum)-parseFloat(yuprice);
    yufan=Math.round(yufan);
var xianprice = parseFloat(tempnum)*0.05;
	xianprice=Math.round(xianprice);
var xianfan = parseFloat(tempnum)-parseFloat(xianprice);
    xianfan=Math.round(xianfan);
document.getElementById("yufu").innerHTML=yufan+"/"+yuprice;
document.getElementById("xianfu").innerHTML=xianfan+"/"+xianprice;
</ww:if>
//
             
   var strhtml="";
   //总多少个客人
   var peopleCount=$("#ddlSelectRoomCount").val();
   strhtml+="<table width='90%' border='0'  cellspacing='0' cellpadding='0'>";
   strhtml+="<tr>";
   for(var i=0;i<parseInt(peopleCount);i++)
   {
       if(i%1==0)
       {
          strhtml+="</tr>";
          strhtml+="<tr>";
       }
       strhtml+="<td width='10px'></td>";
       strhtml+="<td width='60px' align='right'>客人姓名：</td>";
       strhtml+="<td ><input name='InRoomPeople' id='peoplename"+i+"' type='text' desc='客人姓名' class='input80 validate[required]' /></td>";
       
      strhtml+="<td width='60px' align='right'>客人手机：</td>";
      strhtml+="<td ><input name='InRoommobile' id='people"+i+"' type='text' desc='客人手机' class='input80 validate[required,custom[mobile]]' /></td>";
      
      strhtml+="<td width='60px' align='right'>客人性别：</td>";
      strhtml+="<td ><input name='Insex"+i+"' id='sex"+i+"' type='radio' value='1' checked />男<input name='Insex"+i+"' id='sex"+i+"' type='radio' value='2' />女</td>";
      
      strhtml+="<td width='60px' align='right'>客人国籍：</td>";
      strhtml+="<td ><input name='InRoomCountry' id='country"+i+"' type='text' desc='客人国籍' class='input80 validate[required]' /></td>";
      
   }
   strhtml+="</tr>";
   strhtml+="</table>";
   //alert(strhtml);
   $("#divcustomernames").html(strhtml);
   $.validationEngine.closePrompt(".formError",true); 
   
   
   //限制房间数.超出了必须担保
var DBAmount=$("#DBAmount").val();


   if(DBAmount!=null&&DBAmount!=''&&parseInt(peopleCount)>=parseInt(DBAmount)){
   alert("超过了规定预定间数,需要你提供担保卡担保!!!");
   ShowXinYongKaDiv();
   }else{
  // alert("没超过.不担保");
   HidXinYongKaDiv();
   }
}
function yulan(){
    var na=document.getElementsByName("InRoomPeople");
    var nam='';
    for(a=0;a<na.length-1;a++){
    nam+= na[a].value+"&nbsp;|&nbsp;";
    
    }
    nam+= na[na.length-1].value;
    
    document.getElementById("ruzhuname").innerHTML=nam;
    document.getElementById("lianxiren").innerHTML=document.getElementById("yudingren").value;
    document.getElementById("shoujihao").innerHTML=document.getElementById("shouji").value;
    document.getElementById("dianziyoujian").innerHTML=document.getElementById("youjian").value;
}





function HidXinYongKaDiv(){

 $("#xinyongka").hide();
document.getElementById("kahao").className="input100";
document.getElementById("cvv").className="input100";
document.getElementById("nian").className="input100";
document.getElementById("yue").className="input100";

document.getElementById("haoma").className="input100";
document.getElementById("xingming").className="input100";
document.getElementById("kahao").value="";
}
function ShowXinYongKaDiv(){
 $("#xinyongka").show();
document.getElementById("kahao").className="input100 validate[required]";
document.getElementById("cvv").className="input100 validate[required]";
document.getElementById("nian").className="input100 validate[required]";
document.getElementById("yue").className="input100 validate[required]";

document.getElementById("haoma").className="input100 validate[required]";
document.getElementById("xingming").className="input100 validate[required]";

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
<form action="hoteluserbook!yuding.action?regionid=<ww:property value='regionid'/>" method="post" name="form1" id="form1">
<div class="right">
<div><img src="images/buzhou_2.gif" width="674" height="39" /></div>

   <input type="hidden" name="usertype" value="<ww:property value="usertype" />" />
   
<div class="kongfang lan_14c">您所选择的是：</div>
<table width="100%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#E7E7E7"
	style="border-bottom: none; line-height: 24px; border-top: 2px solid #779BCA">
	<tr>
		<td width="90" class="box_yin" align="center">酒店名称</td>
		<td class="box_wu" width="240"><b class="lan_14"><ww:property
			value="hotel.name" /></b></td>
		<td width="90" class="box_yin" align="center">所在地区</td>
		<td class="box_wu"><b class=" lanh"><ww:property
			value="getctname(hotel.cityid)" /></b></td>
	</tr>
	<tr>
		<td class="box_yin" align="center">入住日期</td>
		<td class="box_wu"><b><ww:property value="startDate" /></b></td>
		<td class="box_yin" align="center">入住天数</td>
		<td class="box_wu"><ww:property value="s_num" />天</td>
	</tr>
	<tr>
		<td class="box_yin" align="center">离店日期</td>
		<td class="box_wu"><b><ww:property value="endDate" /></b></td>
		<td class="box_yin" align="center"><b class="huang_12">总&nbsp;&nbsp;价</b></td>
		<td class="box_wu"><b class="huang_14">RMB:<span id="zj"><ww:property value="formatMoney_string(zongjia)"/></span></b></td>
	</tr>
</table>

<div class="kongfang lan_14c" style="margin-top: 10px;">预订规则</div>
<div class="box"
	style="line-height: 35px; background: #FFFCB8; text-align: left;">
	<ww:iterator value="listBookingRules">
	<ww:property value="Description"/>
	</ww:iterator>
</div>
<div class="kongfang lan_14c" style="margin-top: 10px;">担保规则:<ww:property value="listGuaranteeRule.get(0).StartTime"/>-<ww:property value="listGuaranteeRule.get(0).EndTime"/></div>
<div class="box"
	style="line-height: 35px; background: #FFFCB8; text-align: left;">
	<ww:iterator value="listGuaranteeRule">
	<ww:property value="Description"/>
	</ww:iterator>
</div>

<div class="cuowei"><ww:property value="hotel.name" />【<ww:property
	value="getroomnamebyid(roomid)" />】【<ww:property value="startDate" /> — <ww:property
	value="endDate" />】，共 <ww:property value="s_num" /> 晚</div>

<table width="100%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 24px; text-align: center">
	<tr>
		<td width="90" class="box_yin"><ww:property value="getWeekStr(startDate)" /></td>
		<td width="90" class="box_wu"><ww:property value="getWeekStr(Date2)" /></td>
		<td width="90" class="box_yin"><ww:property value="getWeekStr(Date3)" /></td>
		<td width="90" class="box_wu"><ww:property value="getWeekStr(Date4)" /></td>
		<td width="90" class="box_yin"><ww:property value="getWeekStr(Date5)" /></td>
		<td width="90" class="box_wu"><ww:property value="getWeekStr(Date6)" /></td>
		<td width="90" class="box_yin"><ww:property value="getWeekStr(Date7)" /></td>
	</tr>
	
	<tr>
		
		
		
	<ww:iterator value="listNightlyRate" status="index">
	
	<ww:if test="#index.index%7==0&&#index.index!=0">
			</tr>
			<tr>
			</ww:if>
	<td class="box_yin" align="center"><b class="huang_14">RMB:<ww:property value="Member"  /></b></td>
	
	<ww:if test="#index.last">
	<ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="(#index.index+1)%7" />
	<ww:param name="'last'" value="6" />
	</ww:bean>
	<ww:iterator value="#counter" status="state">
	<td class="box_yin" align="center"><b class="huang_14"></b></td>
	</ww:iterator>
	</ww:if>
	</ww:iterator>
	</tr>
	<!--
	<tr>
	
		<td class="box_yin" align="center"><b class="huang_14">RMB:2000</b></td>
		<td class="box_wu"><b class="huang_14">RMB:2000</b></td>
		<td class="box_yin" align="center"><b class="huang_14">RMB:2000</b></td>
		<td class="box_wu"><b class="huang_14">RMB:2000</b></td>
		<td class="box_yin" align="center"><b class="huang_14">RMB:2000</b></td>
		<td class="box_wu"><b class="huang_14">RMB:2000</b></td>
		<td class="box_yin" align="center"><b class="huang_14">RMB:2000</b></td>
	
	</tr>
	
	-->
	<tr>
		<td colspan="7" class="box_yin" align="left"
			style="padding-left: 20px;"><b style="color: #4C5E8E">您选择了 <span id="jianshu">1</span>
		间</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<b class="huang_14">
		 总金额：RMB 
		<span id="zongjia"><ww:property value="formatMoney_string(zongjia)" /></span></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <b class="huang_14" >返利 RMB:<span id="fanli"></span></b> 
		
		
		</td>
	<input name="hidsex" type="hidden" id="hidsex"  />
	<input name="hotelorder.price" type="hidden" id="price" value="<ww:property value="zongjia"/>" />
	<input name="pricecode" type="hidden"  value="<ww:property value="pricecode"/>" />
	<ww:iterator value="listNightlyRate" status="index">
					<input name="hotelorder.dayprice" type="hidden" id="" value="<ww:property value="Member"  />" />
	</ww:iterator>
	<input name="hotelorder.hotelid" type="hidden" id="" value="<ww:property value="hotel.id"/>" />
	<input name="startDate" type="hidden" id="startDate" value="<ww:property value="startDate"/>" />
	<input name="endDate" type="hidden" id="endDate" value="<ww:property value="endDate"/>" />
	<input name="hotelorder.predesc" type="hidden" id="" value="<ww:property value="listBookingRules.get(0).Description" /><ww:property value="listGuaranteeRule.get(0).Description" />" />
	<input name="hotelorder.roomid" type="hidden" id="" value="<ww:property value="roomid"/>" />
	  <!-- 订单类型(1,国内 2,国际) -->
    	 <input name="hotelorder.property" type="hidden"  value="1"  />
    	 
    	 
    <!-- 以下是验证担保的条件 -->
    <input name="DBstartDate" type="text" id="DBstartDate" value="<ww:property value="listGuaranteeRule.get(0).StartDate"/>" />
    <input name="DBendDate" type="text" id="DBendDate" value="<ww:property value="listGuaranteeRule.get(0).EndDate"/>" />
    <input name="DBWeekSet" type="text" id="DBWeekSet" value="<ww:property value="listGuaranteeRule.get(0).WeekSet"/>" />
	<input name="DBStartTime" type="text" id="DBStartTime" value="<ww:property value="listGuaranteeRule.get(0).StartTime"/>" />
	<input name="DBEndTime" type="text" id="DBEndTime" value="<ww:property value="listGuaranteeRule.get(0).EndTime"/>" />
	<input name="DBAmount" type="text" id="DBAmount" value="<ww:property value="listGuaranteeRule.get(0).Amount"/>" />
	</tr>
</table>




<table>
<tr>
		<td>最早到店的时间： <select name="hotelorder.reservstart" 
			style="width: 90px;" id="zuizao2" onchange="checkTime();" >
			
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
		

		</select><font class="hong">*</font></td>
		<td>最晚到店的时间： <select name="hotelorder.reservend"
			style="width: 90px;" id="zuiwan2" >
			
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
			
			

		</select> </td>
		<td>(通常酒店14点办理入住，早到可能需要等待)</td>
		
		
	</tr>
</table>



<ww:if test="NEWroomtype.BookDesc!=null||NEWroomtype.DanBaoDesc!=null">
<div class="kongfang lan_14c" style="margin-top: 10px;">预订须知</div>
<div class="box"
	style="line-height: 35px; background: #FFFCB8; text-align: center;">
	<ww:if test="NEWroomtype.BookDesc!=null">
	<ww:property value="NEWroomtype.BookDesc" />;
	</ww:if>
	<ww:if test="NEWroomtype.DanBaoDesc!=null">
	<ww:property value="NEWroomtype.DanBaoDesc" />
	</ww:if>
	</div>
</ww:if>


<div class="kongfang lan_14c">入住信息：</div>
<div style="position: relative">
<table width="100%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 24px; border-top: 2px solid #779BCA">
	<tr>
		<td width="90" class="box_yin" align="center">订房间数</td>
		<td class="box_wu" width="240"><select name="hotelorder.prerooms" onchange="CreatePeople('<ww:property value="formatMoney_string(zongjia)" />')" id="ddlSelectRoomCount" >
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select>&nbsp;&nbsp;间&nbsp;&nbsp;&nbsp;</td>
		<td style="margin-left: 20px" width="90" class="box_yin" align="center">房型</td>
		<td class="box_wu"><b class=" lanh"><ww:property value="getroomnamebyid(roomid)" /></b></td>
	</tr>
	<tr>
		<td class="box_yin" align="center">入住信息</td>
		<td class="box_wu" colspan="3" align="left">
		<div id="divcustomernames">
		</div>

		<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户名字：&nbsp;<input
			name="" type="text" class="input80" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户名字：&nbsp;<input
			name="" type="text" class="input80" /> -->
	   </td>
	</tr>
</table>
<div class="kongfang lan_14c" style="margin-top: 10px;">温馨提示</div>
<div class="box"
	style="line-height: 35px; background: #FFFCB8; text-align: center;">为避免耽搁您的行程，请您填写真实个人信息,入住只需出示证件，体验快捷预订轻松入住！并享受更多会员优惠！</div>
<div class="kongfang"><b class="lan_14c">联系人信息：</b>*表示必填，如您填写信息有误，我们的客服无法与您取得联系，视为无效订单。</div>
<table width="100%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 24px; border-top: 2px solid #779BCA">
	<tr>
		<td width="90" class="box_yin" align="center">联系人</td>

		
		<td class="box_wu" width="240">
		
		<input name="hotelorder.linkname" desc="预订人" type="text" id="yudingren" class="input100 validate[required]"  value="" />
		
		<span style="color: red;">*</span></td>

		<td width="90" class="box_yin" align="center">手&nbsp;&nbsp;机</td>
		
		<td class="box_wu">
		
		<input name="hotelorder.linkmobile" id="shouji" type="text" value=""  desc="手机号码" class="input100 validate[required,custom[mobile]]"/>
		
	
		
		<span style="color: red;">*</span></td>
	</tr>
	
<tr>
		<td width="90" class="box_yin" align="center">固定电话</td>
		<td class="box_wu" width="240">
		<input name="hotelorder.linktell"  type="text" id="zuoji" class="input100 "  value="" />
		</td>
		<td width="90" class="box_yin" align="center">特殊要求</td>
		<td class="box_wu">
		<textarea rows="2" cols="70" id="beizhu" name="hotelorder.specreq" ></textarea>
		<!-- <input name="hotelorder.specreq" id="beizhu" type="text" value="" style="width: 500px;"   class="input100 "/> -->
		
		</td>
	</tr>
	
</table>

<!-- 信用卡信息开始 -->
<div id="xinyongka">
<div class="kongfang" ><b class="lan_14c">信用卡信息：</b>*表示必填，如您填写信息有误，可能导致下单失败，视为无效订单。</div>
<table width="100%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 24px; border-top: 2px solid #779BCA">
	<tr>
		<td width="90" class="box_yin" align="center">发卡银行</td>
		<td class="box_wu" width="240">
		<select name="cardyhangname">
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
		</select>
		<span style="color: red;">*</span></td>

		<td width="90" class="box_yin" align="center">&nbsp;</td>
		
		<td class="box_wu">
		&nbsp;
		</td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">信用卡卡号</td>

		
		<td class="box_wu" width="240">
		
		<input name="cardno" desc="信用卡卡号" type="text" id="kahao" class="input100 validate[required]"  value="" />
		
		<span style="color: red;">*</span></td>

		<td width="90" class="box_yin" align="center">信用卡CVV</td>
		
		<td class="box_wu">
		
		<input name="cardcvv" id="cvv" type="text" value=""  desc="信用卡CVV" class="input100 validate[required]"/>
		
	
		
		<span style="color: red;">*</span></td>
	</tr>
	
<tr>
		<td width="90" class="box_yin" align="center">有限年月</td>
		<td class="box_wu" width="240">
		<input name="cardyear" style="width: 40px;"  type="text" id="nian" maxlength="4"   class="input100"  value="" />年
		<input name="cardmonth" style="width: 40px;" maxlength="2"  type="text" id="yue" class="input100 "  value="" />月
		<span style="color: red;">*</span>
		</td>
		<td width="90" class="box_yin" align="center">持卡人姓名</td>
		<td class="box_wu">
		<input name="cardname" id="xingming" type="text" value=""   class="input100 validate[required]"/>
		<span style="color: red;">*</span>
		</td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">证件类型</td>
		<td class="box_wu" width="240">
		
		<select name="idtype">
		<option value="0">身份证</option>
		<option value="1">护照</option>
		<option value="2">其他</option>
		</select>
		
		<span style="color: red;">*</span>
		</td>
		<td width="90" class="box_yin" align="center">证件号码</td>
		<td class="box_wu">
		<input name="idno" id="haoma" type="text" value=""   class="input100 validate[required]"/>
		<span style="color: red;">*</span>
		</td>
	</tr>
</table>
</div>

<!-- 信用卡信息结束 -->
<div style="width: 98%; text-align: center; line-height: 80px;">

<!--<input type="checkbox" name="agree" id="agree_Protocol" checked="checked" value="" onclick="javascript:agree_onclick(2)" style="border:none;" value="" />&nbsp;
<b class="lan_14c">网上预订须知条款</b>
-->
</div>
<div style="width: 98%; text-align: center; height: 80px;"><input

	type="button" class="button_up" onclick="javascript:window.history.back()" value="上一步" style="margin-top:3px;" />
	<input name="submitnext" type="submit" value="下一步" onclick="checkform();" id="submitreg" class="button_next">
	
	
	</div>

<div id="confim" style="display: none;">
<div id="queren" style="width: 623px; position: absolute; background: #efefef; z-index: 99; top: 32px; left: 16px;">
<div><img src="images/bj_queren.gif" width="623" height="70" /><iframe
	style="position: absolute; z-index: -1; background-color: Red; width: 160px; top: 0px; left: 0px; scrolling: no;"
	frameborder="0"></iframe></div>
<div
	style="background: url(images/bj_queren1.gif); padding: 5px 15px 0 15px;">
<table width="99%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 22px;">
	<tr>
		<td width="90" class="box_yin" align="center">入住日期</td>
		<td class="box_wu" width="240"><ww:property value="startDate"/></td>
		<td width="90" class="box_yin" align="center">离店日期</td>
		<td class="box_wu"><ww:property value="endDate"/></td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">入住酒店</td>
		<td class="box_wu" width="240"><ww:property value="hotel.name"/></td>
		<td width="90" class="box_yin" align="center">房间数</td>
		<td class="box_wu"><b class="huang_12"><span id="jian"></span></b>&nbsp;间</td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">入住房型</td>
		<td class="box_wu" colspan="3"><ww:property value="roomtype.name" /></td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">入住人姓名</td>
		<td class="box_wu" colspan="3"><span id="ruzhuname"></span></td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">房间信息</td>
		<td class="box_wu" colspan="3"><ww:property
			value="hotel.name" />-<ww:property value="roomtype.name" /></td>
	</tr>
</table>
<div class="he5">&nbsp;</div>
</div>
<div style="background: url(images/bj_quren2.gif)">&nbsp;</div>
<div
	style="background: url(images/bj_queren1.gif); padding: 5px 15px 0 15px;">
<table width="99%" border="0" class="box" cellspacing="0"
	cellpadding="0" bordercolor="#cccccc"
	style="border-bottom: none; line-height: 22px;">
	<tr>
		<td width="90" class="box_yin" align="center">联系人</td>
		<td class="box_wu" width="240"><span id="lianxiren"></span></td>
		<td width="90" class="box_yin" align="center">手机号</td>
		<td class="box_wu"><span id="shoujihao"></span></td>
	</tr>
	<tr>
		<td width="90" class="box_yin" align="center">电子邮件</td>
		<td class="box_wu" colspan="3"><span id="dianziyoujian"></span></td>
	</tr>
</table>

<div class="he5">&nbsp;</div>
</div>
<div
	style="background: url(images/bj_quren2.gif); text-align: center; height: 45px;"><input
	type="button" class="button_queren" value="确认订单"
	onclick="sub();" /></div>
<div><img src="images/dibu.gif" width="623" height="6" /></div>
</div>
</div>
</div>
<!--right结束-->
</div>
</form>

</div>
</body>
</html>
