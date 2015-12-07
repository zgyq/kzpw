<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 
	 * 版权所有, 航天华有
	 * Author: B2B2C 项目开发组
	 * copyright: 2010
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
 <style>
      .button_next{ background:url(images/button_next.gif); width:111px; height:37px; line-height:37px; border:none;  cursor:pointer; font-weight:bold; margin-top:3px; color:#fff;}
      </style>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
       <title>打印行程单</title>
<!-- 自动检测是否安装了打印程序 -->
<script language="javascript" src="CheckActivX.js"></script>
<!-- 自动检测是否安装了打印程序  -->
<!-- 引用打印OBJ -->
<object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"
	width=0 height=0>
<param name="CompanyName" value="北京华展宏图航空服务有限公司" />
<param name="License"    value="121212121111111111" />
</object>
<!-- 引用打印OBJ -->
<style type="text/css">
	.textareacls
{
   color: #000;
   font-family: TEC, "宋体";
   font-size: 16pt;
}     
*{
-moz-box-sizing: border-box;
}
input{color: #000;
      font-family: TEC, "宋体";
	  font-size: 16pt;}


.title { 
   font-family : Arial,Vernada,Tahoma, sans-serif;
   font-size: 30px;
   color : #000;
   background-color : White; text-decoration:underline;letter-spacing: 1px;
}

.normal{
	font-family : Arial,Vernada, Tahoma, Helvetica, sans-serif;
	font-size: 12px;
	color: #000;
	text-decoration: none;
	line-height: 21px;letter-spacing: 1px;}


.hide_for_jatools_print{}
.jc{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jc1{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jc2{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 66px;
	letter-spacing: 1px;
}
.jc3{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 30px;
	letter-spacing: 1px;
}
.jc4{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jnc{position:absolute;height:380px}
.pb{overflow:hidden;position:relative;margin:5;width:857;background-color:white;height:380px;
border-left:1px solid black;border-top:1px solid black;	border-right:4px solid black;border-bottom:4px solid black;}
.c12{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 24px;font-weight: bold;color: #000;letter-spacing: 1px;}
.c9, .c8, .c6, .c5, .c4, .c3, .c0{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c2{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c7{margin-left:2px;margin-bottom:-2px;text-align: right;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c11, .c10, .c1{margin-left:2px;margin-bottom:-2px;text-align: right;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
</style>
<script language="javascript" type="text/javascript">
$(document).ready(function() {
  var LODOP=document.getElementById("LODOP");//这行语句是为了符合DTD规范
  CheckLodop();
  
  if(<ww:property value="passengerXingchengdan"/>==0){
    alert("您还未领取行程单，请领取后再打印！");
  }
  if($("#txthiddnsname").val()=="www.chinajslx.cn"){
       $("#txtagentName").val("北京金航旅航空服务有限公司");
  }

});
function loadyanzhengma()
  {
	  if($("#xingchengdanhao").val()!="" && $("#xingchengdanhao").val()!="请填写行程单号" && $("#xingchengdanhao").val().length>=4)
	  {
	     $("#yanzhengma").html($("#xingchengdanhao").val().substring($("#xingchengdanhao").val().length-4,$("#xingchengdanhao").val().length));
	  }
  }
function accountprice()
{
  var totalprice=0;
  var ticketprice=0;
  ticketprice=parseInt($("#txtpiaomianjia").val());
  var airportfee=0;
  airportfee=parseInt($("#airportfee").val());
  var fuelfee=0;
  fuelfee=parseInt($("#fuelfee").val());
  totalprice=ticketprice+airportfee+fuelfee;
  $("#totalprice").val(totalprice);
}
function clearxingchengdan()
{
    if($("#xingchengdanhao").val()=="请填写行程单号")
    {
       $("#xingchengdanhao").val("");
       $("#xingchengdanhao").focus();
    }
}
//是否为整数

function IsInteger(txtValue){
	var exp, op;
	op = txtValue;
    exp = /^\s*[-\+]?\d+\s*$/;
    if (op.match(exp) == null){ 
        return false;
    }else{
		return true;
    }
}
</script> 

<!-- 打印脚本 -->
<script language="javascript" type="text/javascript">
   function checkdata()
   {
      if($("#xingchengdanhao").val()=="" || $("#xingchengdanhao").length==0 || $("#xingchengdanhao").val()=="请填写行程单号")
      {
         alert("请按照行程单上面的行程单号填写10位行程单号!");
         return false;
      }
      //alert("1");
      //alert($("#txttopblank").val());
      
      
      if(confirm("您确认要打印行程单吗？"))
         {
           prn1_preview();
         }
   }
   
   function printsingletrip(){
    $.ajax({
		   url:"passenger!printTicketSheet.action",
		   type:"POST",
		   async:false,
		   data:{ppid:<ww:property value="ppid"/>,passengerXingchengdan:$("#xingchengdanhao").val()},
		   success:function (data){	   
		  }	
	      });
   }
   function printcomplete(){
     if(confirm("请确认您已在黑屏中打印完成此行程单")){
     // printsingletrip();
     }
   }
   function prn1_preview() {
        CreateFullBill();
		//LODOP.PREVIEW();
		//LODOP.PRINT_DESIGN();
		if (LODOP.PRINTA()) {
		 // printsingletrip();
		}else {
		    alert("您已经放弃对此行程单的打印");
		 }	
		
	};
	function CreateFullBill() {
	var topblank=$("#txttopblank").val();
	var leftblank=$("#txtleftblank").val();
	LODOP.SET_PRINT_PAPER(topblank,leftblank,786,383,"打印行程");
	LODOP.ADD_PRINT_TEXT(81,62,169,19,"<ww:property value="passenger.name" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	LODOP.ADD_PRINT_TEXT(80,228,170,20,"<ww:property value="passenger.idnumber" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(80,481,200,19,$("#page1qaindanlan").val());
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	LODOP.ADD_PRINT_TEXT(144,60,118,20,"<ww:property value="getname(segmentinfo.startairport)" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	LODOP.ADD_PRINT_TEXT(177,59,117,20,"<ww:property value="getname(segmentinfo.endairport)" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	
	var cabincode2="";
	var flightdate2="";
	var flighttime2="";
	var aircompany2="";
	var fromcity2="VOID";
	var flightnumber2="";
	var segdate2="";
	var fromcitycode2="";
	var voidcode="";
	var packgeweight="";
	<ww:if test="listsegmentinfo.size()>1">
	  cabincode2='<ww:property value="segmentinfo2.cabincode" />'
	  flightdate2='<ww:property value="formatTimestamp2(segmentinfo2.departtime)" />'
	  flighttime2='<ww:property value="formatTimestampToHm(segmentinfo2.departtime)" />'
	  aircompany2='<ww:property value="getAircomapnycodeByEZM(segmentinfo2.aircomapnycode)" />'
	  fromcity2='<ww:property value="getname(segmentinfo2.endairport)" />'
	  flightnumber2='<ww:property value="segmentinfo2.flightnumber" />'
	  segdate2='<ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo2.departtime))" />'
	  fromcitycode2='<ww:property value="segmentinfo2.endairport" />'
	  voidcode="VOID";
	  packgeweight="20K";
	</ww:if>
	<ww:else>
	aircompany2="VOID";
	voidcode="";
	</ww:else>
	LODOP.ADD_PRINT_TEXT(176,287,41,20,cabincode2);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
    LODOP.ADD_PRINT_TEXT(176,330,105,20,flightdate2);
    LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    LODOP.ADD_PRINT_TEXT(176,436,52,20,flighttime2);
    LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    
    LODOP.ADD_PRINT_TEXT(176,178,61,20,aircompany2);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	if(fromcity2==""){fromcity2="VOID"}
	LODOP.ADD_PRINT_TEXT(211,58,63,20,fromcity2);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	
	LODOP.ADD_PRINT_TEXT(211,120,43,20,fromcitycode2);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	
	LODOP.ADD_PRINT_TEXT(240,57,66,20,voidcode);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    LODOP.ADD_PRINT_TEXT(211,163,63,20,voidcode);
    LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	
	LODOP.ADD_PRINT_TEXT(177,228,60,20,flightnumber2);
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	
	LODOP.ADD_PRINT_TEXT(176,587,64,20,"");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    LODOP.ADD_PRINT_TEXT(175,651,59,20,"");
    LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
    LODOP.ADD_PRINT_TEXT(175,713,46,20,packgeweight);
    LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);


	

	LODOP.ADD_PRINT_TEXT(143,178,52,20,"<ww:property value="getAircomapnycodeByEZM(segmentinfo.aircomapnycode)" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	LODOP.ADD_PRINT_TEXT(143,231,59,20,"<ww:property value="segmentinfo.flightnumber" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	var hangzhanlou1="";
	<ww:if test="segmentinfo.offpointat!=null && segmentinfo.offpointat!='--'">
	  hangzhanlou1='<ww:property value="segmentinfo.offpointat" />'
	</ww:if>
	LODOP.ADD_PRINT_TEXT(144,124,41,20,'<ww:property value="segmentinfo.startairport"/>');
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	var hangzhanlou2="";
	<ww:if test="segmentinfo.borderpointat!=null && segmentinfo.borderpointat!='--'">
	  hangzhanlou2='<ww:property value="segmentinfo.borderpointat" />'
	</ww:if>
	LODOP.ADD_PRINT_TEXT(176,123,42,20,'<ww:property value="segmentinfo.endairport" />');
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(143,284,46,20,"<ww:property value="segmentinfo.cabincode" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
	LODOP.ADD_PRINT_TEXT(144,330,112,20,"<ww:property value="formatTimestamp2(segmentinfo.departtime)" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(144,436,54,20,"<ww:property value="formatTimestampToHm(segmentinfo.departtime)" />");
	
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(143,491,96,98,$("#txtkepiaojibie").val());
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.ADD_PRINT_TEXT(143,588,63,20,"<ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo.departtime))" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(143,651,60,20,"<ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo.departtime))" />");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(141,714,44,20,"20K");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(108,60,85,20,"<ww:property value="s_pnr" />");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	<ww:if test="passenger.ptype==1">
	LODOP.ADD_PRINT_TEXT(269,184,100,20,"CNY <ww:property value="segmentinfo.parvalue" />");
	</ww:if><ww:else>
	LODOP.ADD_PRINT_TEXT(269,184,100,20,"CNY <ww:property value="passenger.price" />");
	</ww:else>
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(269,287,100,20,"CN <ww:property value="passenger.airportfee" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(268,388,100,20,"YQ <ww:property value="passenger.fuelprice" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(332,88,100,20,$("#txtagentcode").val());  
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	<ww:if test="passenger.ptype==1">
	LODOP.ADD_PRINT_TEXT(268,592,129,20,"CNY <ww:property value="segmentinfo.parvalue+passenger.airportfee+passenger.fuelprice" />");
	</ww:if><ww:else>
	LODOP.ADD_PRINT_TEXT(268,592,129,20,"CNY <ww:property value="passenger.price+passenger.airportfee+passenger.fuelprice" />");
	</ww:else>
	
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(289,90,125,20,"<ww:property value="passenger.ticketnum" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(290,268,69,20,$("#yanzhengma").html());//验证码
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(289,689,58,20,"<ww:property value="converNull(passenger.insurprice,0)" />");
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(312,88,83,21,$("#txtOfficeNo").val());
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(320,276,360,35,$("#txtagentName").val());
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEC");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
	LODOP.ADD_PRINT_TEXT(319,637,97,20,$("#txtPrinttime").val());
	LODOP.SET_PRINT_STYLEA(0,"FontName","TEE");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	
	

	};	
	function retryprint(){
	if(confirm("重新打印将作废当前行程单，确认重新打印？")){
	  //printsingletrip();//先打印
	  window.location.reload();
	}
	
	}
</script>
</head>
<body ondragstart= "return false" onselectstart= "return false" onload="loadyanzhengma();">
    <form id="form1" runat="server"><input type="hidden" id="txthiddnsname" value="${dns.dnsname}"/>
    <div ><input type="hidden" id="txtpid" value="<ww:property value="ppid" />" />
<div id="divrepecit" style="margin:0px auto;background-color:#000;width:810px;height:400px;overflow:scroll;padding:5px;clear:both">
  <div class="pb"  >
    <div id="page1">
      <div class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><img class='hide_for_jatools_print' src="images/piaobig.jpg"/>&nbsp;</span></span></span></span></span></span></div>
      <div class="jc" style="left: 72px;top: 73px;width:150px;">
          <ww:property value="passenger.name" /></div>
      <div class="jc4" style="left: 205px;top: 73px;width:195px;FONT-SIZE:16pt;font:TEE; ">
         <ww:property value="passenger.idnumber" /></div>
      <div class="jc" style="left: 475px;top: 74px;width:100%;">
      		<input type="text" id="page1qaindanlan" value='改期退票收费' style="left:476px;"/>
          <!--<ww:property value="passenger.ei" />-->
          </div>
          <!-- 印刷序列号 -->
       <div class="jc" style="left: 605px;top:34px;width:100%">
       <input  type="text" id="xingchengdanhao" value="<ww:property value="username" />" style="width:130px;font:TEE" onfocus="clearxingchengdan();" onblur="getyanzhengma();"/>
       </div>
      <!-- 印刷序列号 -->
      <div class="jc1" style="left: 72px;	top: 101px;FONT-SIZE:16pt;font:TEE;">
         <ww:property value="s_pnr" /></div>
       <!-- 第一程航站楼信息 -->
      <div class="jc2" style="left: 122px;	top: 138px;">
          <ww:property value="segmentinfo.offpointat" /></div>
      <div class="jc2" style="left: 122px;	top: 170px;">
         <ww:property value="segmentinfo.borderpointat" /></div>
       <!-- 第一程航站楼信息 -->
        <!-- 第二程航段信息 -->
      <div class="jc2" style="left: 122px;	top: 205px;">
          <ww:if test="segmentinfo2!=null">
              <ww:property value="segmentinfo2.borderpointat" />
          </ww:if>
      </div>
       <div class="jc3" style="left: 61px;top: 205px;FONT-SIZE:16pt;width:70px; font:TEE">
          <ww:if test="segmentinfo2!=null"> 
          <ww:property value="getname(segmentinfo2.endairport)" />
          </ww:if>
          <ww:else>
           VOID
          </ww:else> 
       </div>
       <!-- 第二程航段信息 -->
       
       <!-- 第一程航段信息 -->
      <div class="jc3" style="left: 61px;top: 139px;FONT-SIZE:16pt;width:70px; font:TEE"> 
          <ww:property value="getname(segmentinfo.startairport)" /></div>
      <div class="jc3" style="left: 61px;top: 171px;FONT-SIZE:16pt;width:70px;font:TEE">
         <ww:property value="getname(segmentinfo.endairport)" /></div>
      <!-- 第一程航段信息 -->
      <div class="jc3" style="left: 191px;top: 139px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="getAircomapnycodeByEZM(segmentinfo.aircomapnycode)" /></div>
      <!-- 第二程航空公司 -->
	  <div class="jc3" style="left: 191px;top: 171px;FONT-SIZE:16pt;font:TEE">
	      <ww:if test="segmentinfo2!=null"> 
          <ww:property value="getAircomapnycodeByEZM(segmentinfo2.aircomapnycode)" /><!-- 航2 -->
          </ww:if>
          </div>
      <!-- 第二程航空公司 -->
      <div class="jc3" style="left: 230px;top: 139px;width:61px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
          <ww:property value="segmentinfo.flightnumber" /></div>
       <!-- 第二程航班号 -->
      <div class="jc3" style="left: 230px;top: 171px;width:61px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
          <ww:if test="segmentinfo2!=null"> 
          <ww:property value="segmentinfo2.flightnumber" /><!-- 航班号2 -->
          </ww:if>
          </div>
      <!-- 第二程航班号 -->
      <div class="jc3" style="left: 301px;top: 139px;width:20px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="segmentinfo.cabincode" /></div>
      <!-- 第二程舱位码 -->
	  <div class="jc3" style="left: 301px;top: 171px;width:20px;FONT-SIZE:16pt;font:TEE">
	      <ww:if test="segmentinfo2!=null"> 
          <ww:property value="segmentinfo2.cabincode" /><!-- 舱位码2 -->
          </ww:if>
          </div>
     <!-- 第二程舱位码 -->
      <div class="jc4" style="left: 333px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="formatTimestamp2(segmentinfo.departtime)" /></div>
     <!-- 第二程起飞日期 -->
	  <div class="jc4" style="left: 333px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
	      <ww:if test="segmentinfo2!=null"> 
          <ww:property value="formatTimestamp2(segmentinfo2.departtime)" /><!-- 起飞日期2 -->
          </ww:if>
          </div>
     <!-- 第二程起飞日期 -->
      <div class="jc4" style="left: 387px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
      	<ww:property value="formatTimestampToHm(segmentinfo.departtime)" /><!-- 起飞时间点 如 8:00 -->
      </div>
      <!-- 第二程起飞时间 -->
      <div class="jc4" style="left: 387px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
        <ww:if test="segmentinfo2!=null"> 
      	<ww:property value="formatTimestampToHm(segmentinfo2.departtime)" /><!-- 起飞时间点 如 8:00 -->
      	</ww:if>
      </div>
      <!-- 第二程起飞时间 -->
      
      <div class="jc4" style="left:440px;top: 139px;width:142px;FONT-SIZE:16pt;font:TEE">
          <!--<input type="text" id="ticketType" style="width:100%;height:86px;" /> --><!-- 客票类别，客票级别 -->
          <textarea id="ticketType" cols="18" id="txtkepiaojibie"  rows="6" style="width:100%;height:102px;overflow:hidden;" class="textareacls"></textarea></div>
      <div class="jc4" style="left: 593px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo.departtime))" /><!--生效日期1 --></div>
      <div class="jc4" style="left: 593px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="sx1" runat="server"></asp:Label><!--生效日期2 --></div>
      <div class="jc4" style="left: 653px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="jz0" runat="server"></asp:Label><!-- 截止日期1 --></div>
      <div class="jc4" style="left: 653px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="jz1" runat="server"></asp:Label><!-- 截止日期2 --></div>
      <div class="jc4" style="left: 608px;top: 28px;width:174px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="sn" runat="server" Width="108px" Visible="False"></asp:Label>
          <asp:Label ID="sns" runat="server" Width="12px" Visible="False"></asp:Label></div>
      <div class="jc4" style="left: 653px;top: 41px;width:12px;FONT-SIZE:16pt;font:TEE">
          </div>


      <div class="jc3" style="left: 390px;top: 139px;width:40px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="formatTimestamp3(segmentinfo.departtime)" /></div>
	  <div class="jc3" style="left: 390px;top: 171px;width:40px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="flytime1" runat="server" ></asp:Label><!-- 起飞时间2 --></div>
      <div class="jc3" style="left: 721px;top: 139px;width:60px;FONT-SIZE:16pt;font:TEE">
          20k<!-- 行李重1 --></div>
	  
	  <div class="jc3" style="left: 721px;top: 171px;width:60px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="xingli1" runat="server" ></asp:Label><!-- 行李重2 --></div>
	  
	  
      <div class="jc" style="left: 451px;top: 139px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="level0" runat="server"></asp:Label></div>
	  <div class="jc" style="left: 451px;top: 171px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="level1" runat="server" ></asp:Label></div>
	
      <div class="jc1" style="left: 71px;	top: 200px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="shuntair" runat="server"></asp:Label></div>
	 
	  <div class="jc2" style="left: 71px;	top: 200px;"></div>
	  <div class="jc3" style="left: 105px;top: 200px;FONT-SIZE:16pt;width:70px;font:TEE">
          <asp:Label ID="shuntaircode" runat="server"></asp:Label></div>
      <div class="jc3" style="left: 186px;top: 261px;width:135px;FONT-SIZE:16pt;font:TEE;word-spacing:1px; letter-spacing: 1px;"><!-- <ww:property value="passenger.price" /> -->
          CNY <ww:if test="passenger.ptype==1"><ww:property value="segmentinfo.parvalue" />
          </ww:if><ww:else>
          <ww:property value="passenger.price" />
          </ww:else>
          
          <!-- <input type="text" onblur="accountprice();" id="txtpiaomianjia" value='<ww:property value="passangerPrice" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:60px;font:TEE;" /> --><!-- 票面价 -->
          <asp:Label ID="Label18" runat="server" ></asp:Label></div>
      <div class="jc3" style="left: 285px;top: 263px;width:125px;FONT-SIZE:16pt;font:TEE">&nbsp;
     	 <ww:if test="passenger.airportfee==null">
          CN<input type="text"  value='0.00' onblur="accountprice();" id="airportfee" ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /><!-- 机建费 -->&nbsp;
          </ww:if>
          <ww:else>
          CN<ww:property value="passenger.airportfee" /><!-- <input type="text" id="airportfee" onblur="accountprice();"  value='<ww:property value="passangerAirportfee" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /> --><!--基建费YQ-->
          </ww:else>
	</div>
      <div class="jc3" style="left: 395px;top: 263px;width:125px;FONT-SIZE:16pt;font:TEE">
          <ww:if test="passenger.fuelprice==null">
          YQ<input type="text"  id="fuelfee" onblur="accountprice();" value='0.00' ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /><!-- 燃油费 -->&nbsp;
          </ww:if>
          <ww:else>
          YQ<ww:property value="passenger.fuelprice" />
          <!-- <input type="text" id="fuelfee" onblur="accountprice();" value='<ww:property value="passangerFuelprice" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:60px;font:TEE" /> --><!-- 燃油费 -->&nbsp;
          </ww:else>
          </div>
      <div class="jc3" style="left: 609px;top: 259px;width:151px;FONT-SIZE:16pt;font:TEE">
          CNY
           <ww:if test="passenger.ptype==1">
          <ww:property value="segmentinfo.parvalue+passenger.airportfee+passenger.fuelprice+converNull(passenger.insurprice,0)" />
          </ww:if><ww:else>
          <ww:property value="passenger.pricepassenger.airportfee+passenger.fuelprice+converNull(passenger.insurprice,0)" />
          </ww:else>
          <!-- <input type="text" id="totalprice" value='<ww:property value="passangerTotalfuelfee" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:80px;font:TEE" /> --><!-- 总价格 --></div>
      <div class="jc4" style="left: 90px;top: 285px;width:175px;FONT-SIZE:16pt;font:TEE">
          <input type="text"  value='<ww:property value="passenger.ticketnum" />' style="border:0;background-color:transparent;width:150px;font:TEE" /><!-- 电子客票号 --></div>
      <div id="yanzhengma" class="jc3" style="left: 277px;top: 285px;width:40px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
     <ww:property value="username.substring(username.length()-4, username.length())" />
          <!-- 验证码 --></div>
	  <div class="jc3" style="left: 700px;top:285px; <!-- 281px; --> width:40px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
	  <ww:property value="converNull(passenger.insurprice,0)" />
	  </div>
      <div class="jc4" style="left: 89px;top: 315px;width:175px;FONT-SIZE:16pt;font:TEE" id="ComCode" ><input type="text" id="txtOfficeNo" value="PEK888"  style="width:100px;height:14px;font:TEE" /><asp:Label ID="agent_symble" runat="server" ></asp:Label></div>
      <div class="jc4" style="left: 90px;top: 329px;width:175px;FONT-SIZE:16pt;font:TEE" id="AgentCode"><input type="text" value="08622222" id="txtagentcode" style="margin-top:5px;width:100px;height:14px;font:TEE" /><asp:Label ID="agent_code" runat="server" ></asp:Label></div>
      <div class="jc4" style="left: 637px;top: 318px;width:175px;FONT-SIZE:16pt;font:TEE">
	    <%
	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	%>
          <%=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime()) %>
      <input type="hidden" id="txtPrinttime" value="<%=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime()) %>" />
      </div>
      <div class="jc" style="left: 289px;top: 320px;width:235px"><input type="text" id="txtagentName" value="北京华展宏图航空服务有限公司"  style="width:230px;font:TEE" /></div>
    </div>
  </div>
</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td height="35" align="center">
		<table width="40%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<fieldset><legend>打印位置(单位0.1毫米)</legend>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right">页顶空白:</td>
						<td height="40px" align="left"><input type="text" style="width: 30px;font-family:宋体" id="txttopblank" value="0" />*0.1毫米</td>
						<td align="right">左 边 距:</td>
						<td align="left"><input type="text" style="width: 30px;font-family:宋体" id="txtleftblank" value="0" />*0.1毫米</td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
		</table>
		</td>
      </tr>
      <tr>
        <td height="35" align="center"><input name="button" class="button_next" type="button"  id="PrintGo"  onclick="return checkdata();" value="打印并预览" />&nbsp;
        <ww:if test="getLoginsessionagent().agenttype==1">
            &nbsp;<input name="button" type="button"  class="button_next" id="Button1"  onclick="printcomplete();" value="打印完成" />
            &nbsp;<input name="button" type="button"  class="button_next" id="Button1"  onclick="retryprint();" value="重新打印" />
        </ww:if>
            </td>
      </tr>
    </table>
    </div>
      <asp:HiddenField ID="HfRRTime" runat="server" />
</form>

<script>
function getyanzhengma()
{
  if($("#xingchengdanhao").val()!="" && $("#xingchengdanhao").val()!="请填写行程单号" && $("#xingchengdanhao").val().length>=4)
  {
     $("#yanzhengma").html($("#xingchengdanhao").val().substring($("#xingchengdanhao").val().length-4,$("#xingchengdanhao").val().length));
  }
}
</script>
</body>
</html>
