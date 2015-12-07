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

<script src="js/jquery1.3.2.js" type=text/javascript></script>  

<!--
<link href="style/tip-yellowsimple.css" rel="stylesheet" type="text/css" title="no title" charset="utf-8" />
<script src="js/jquery/jquery.poshytip.js" type="text/javascript"></script>
-->
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>

<script src="js/jason/json2.js" type="text/javascript"></script>
<script src="js/jason/jquery.tmpl.js" type="text/javascript"></script>
<script src="js/citycontrol/PublicJs.js" type="text/javascript"></script>
</head>
<script type="text/javascript">

 
$(document).ready(function(){
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
function ChangNum(countPrice){
var num=$("#SpotNum").val();
if(num=='0'){
alert("购买数量必须大于0");
return;
}

   	
  var zpice = num*parseFloat(countPrice);
            
  tempnum = Math.round(zpice*100)/100;  
            
 document.getElementById("zongjia").innerHTML=tempnum;
 
 $("#price").val(tempnum);

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

function  confirminfo(){
var isfalse="1";

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
		   
		    }
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
			    
}

 

if(isfalse=='0'){
return;
}

var Sname="";
 for(var i=0;i<name.length;i++){
 Sname+="<font class='font-f60-16 mr25'>"+name[i].value+"</font>";
 }
$("#hidname").html(Sname);

$("#hidmobile").html($("#linkmobile").val());

$("#hidemail").html($("#linkmail").val());
$("#hidname").html($("#linkName").val());

var redCheckd=1;
if(document.getElementById("red1").checked){
redCheckd=1;
}
if(document.getElementById("red2").checked){
redCheckd=2;
}
document.getElementById("status").className="r status_four"; 
//document.getElementById("cred"+redCheckd).checked=true;

$("#confirminfovalue").show(); 
$("#infovalue").hide(); 
}
function  editinfo(){
$("#infovalue").show(); 
$("#confirminfovalue").hide(); 
document.getElementById("status").className="r status_three"; 
}
function formSub(){

if($("#SpotNum").val()==""||$("#SpotNum").val()=='0'){
 alert("门票数量不能为空!!!");
 $("#SpotNum").focus();
 return;
 }
 
 
 if($("#startDate").val()==""){
 alert("游玩时间不能为空!!!");
 $("#startDate").focus();
 return;
 }
 if($("#LinkSFZ").val()==""){
 alert("身份证不能为空!!!");
 $("#LinkSFZ").focus();
 return;
 }


document.form2.submit();
}
</script>
<body>
<div style="width: 1200px">
	
<!--top over-->
<div id="hotel" style="margin-top: 51px;width: 1200px">
      
      
 <form action="spotticket!createOrder.action" method="post" name="form2" id="form2">
 <div id="list" class="r" style="width: 1100px">

    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">预定门票</font>
       <span class="r spot_status_three" id="status">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="c"></div>
    <div class="mt7 ">     
  
       <div class="">
           <div class="f list_top_left">&nbsp;</div> 
           <div class="f list_top list_bg">
               <div class="f"><a href="#" class="c09f"><ww:property value="spotmes.name" /></a></div>
               <div class="r" style="display: none">
              预订提示:
           		</div>
               <div class="c"></div>
           </div>
           <div class="f list_top_right">&nbsp;</div> 
           <div class="c"></div>
       </div>
      
       <div class="mt7 information list_table ">
       <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box">
          <tr>
            <th class="hadow" width="20%" scope="col">门票名称</th>
            <th class="hadow" width="15%" scope="col">市场价</th>
            <th class="hadow" width="15%" scope="col">现付价</th>
            <th class="hadow" width="10%" scope="col">优惠</th>
            <th class="hadow" width="15%" scope="col">余票</th>
          </tr> 
          
          <tr>
            <td class="floatall">
                <span class="ico_room">&nbsp;</span><a href="#" class="l06c"><ww:property value="spotticket.name" /></a>
            </td>
           
            <td class="font-f60-del">&yen;<ww:property value="spotticket.marketprice" /></td>
            <td char="font-f60-16">
            &yen;<ww:property value="spotticket.shopprice" />
            </td>
            <td><ww:property value="GetYouFei(spotticket.marketprice,spotticket.shopprice)" /></td>
            <td><ww:property value="spotticket.limitsfznumber" /></td>
          </tr>         
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
         <div class="total_main">数量：
        <select id="SpotNum" name="SpotNum" onchange="ChangNum('<ww:property value="spotticket.shopprice" />');">
        <option value="1">1</option>
         <option value="2">2</option>
          <option value="3">3</option>
           <option value="4">4</option>
            <option value="5">5</option>
             <option value="6">6</option>
              <option value="7">7</option>
               <option value="8">8</option>
                <option value="9">9</option>
                 <option value="10">10</option>
                  <option value="11">11</option>
                   <option value="12">12</option>
                    <option value="13">13</option>
                     <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="20">20</option>
                      <option value="25">25</option>
                      <option value="30">30</option>
        </select>
        
         <font class="mf31">合计：</font><font  class="font-f60-16">&yen;<span id="zongjia"><ww:property value="formatMoney_string(spotticket.shopprice)" /></span></font><font  class="c999">&nbsp;(在线支付)</font>
       
         </div>
       </div>
    </div>
    
    
   
      <input type="hidden"   name="price" id="price" value="<ww:property value="formatMoney_string(spotticket.shopprice)" />" />
      <input type="hidden"   name="SpotTicketID" id="SpotTicketID" value="<ww:property value="SpotTicketID" />" />
      
    <div class="mt7 box" id="infovalue">
       <div class="tit"><span class="low2 black f">预订信息：</span><font class="f90"></font>欢迎来到${compname}商旅网预定景区门票。</div>
       <div class="mt20 check_one">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       
         <table>
           <tr>
            <td align="right">游玩时间：</td>
            <td><input type="text" class="sel_searchor" name="startDate" id="startDate" value="" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"  /><font class="c999 mf15"></font></td>
          </tr>
          
          <tr>
            <td align="right">姓名：</td>
            <td><input type="text" class="sel_searchor" name="LinkName" id="LinkName" value="<ww:property value="#session.loginuser.membername" />" /><font class="c999 mf15"></font></td>
          </tr>
          <tr>
            <td align="right">联系手机：</td>
            <td><input type="text" class="sel_searchor" name="LinkMobile" id="LinkMobile" value="<ww:property value="#session.loginuser.mobile" />" /><font class="c999 mf15">(用于接收订单确认短信。)</font></td>
          </tr>
           <tr>
            <td align="right">身份证：</td>
            <td><input type="text" class="sel_searchor" name="LinkSFZ" id="LinkSFZ" value="" /><font class="c999 mf15">(用于到景区刷证进入。)</font></td>
          </tr>
          <tr>
            <td align="right">Email：</td>
            <td><input type="text" class="sel_searchor" id="linkmail" name="LinkMail" value="<ww:property value="#session.loginuser.memberemail" />" /><font class="c999 mf15">建议填写</font></td>
          </tr>
          
          <tr>
            <td colspan="2">
            <div class="check_tips">
              <ul>
              <li>· 票量紧张的时候请立即支付,半小时内未支付的订单系统会自动取消。</li>
              </ul>
            </div></td>
          </tr>
        </table>
        </table> 
         <!-- 隐藏域值 -->
        <!-- 订单类型(1,国内 2,国际) -->
   
    
     
	
        
       </div>
       <div class="box_botm booking_line">&nbsp;</div>
       <div>&nbsp;</div>
       <div class="booking_bnt">
        <input type="button" class="booking_bntton fff" value="提交订单" onclick="formSub();"  />
       <input type="button" class="booking_bntton fff" value="点击刷新" onclick="location.reload();"  />
        
       </div>
    </div>
    </form>
    
 
   
 </div>
 <!--list over-->
 
 <div class="c"></div>
</div>

</body>
</html>
