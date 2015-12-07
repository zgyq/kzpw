
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0055)http://lieche.huoche.com/zhanzhan.php -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>${dns.companyname} 火车票查询</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<META name=description content="">
<META name=keywords content="">
<style>

#city select{
		width:100px;
		margin-right:20px;
	}
  </style> 


<LINK rel=stylesheet type=text/css href="js/train/style.css">
<LINK rel=stylesheet type=text/css href="css/style.css">  
<LINK rel=stylesheet type=text/css href="css/train.css">  
  
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script src="js/city/jquery-1[1].2.6.js" type="text/javascript"></script>
<script src="js/city/jquery.provincesCity.js" type="text/javascript"></script>
<script src="js/city/provincesdata.js" type="text/javascript"></script>



<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<script type="text/javascript">


function expexcel() {
    var win = new Ext.Window({
        height      : 150,
        width       : 400,
        modal       : true,
        title       : '提醒',
        html        : '<br>请到打开的新窗口进行银行卡支付，付款未完成前请不要关闭本页面。<br/>支付完成后请点击下一步',
        plain       : true,
        border      : true,
        resizable   : false,
        draggable   : false,
        closable    : false,
        buttonAlign : 'center',
        buttons     : [
            {
                text    : '下一步',
                handler : function() {
                   window.location.href="train!ordersuccess.action";
                }
            }
        ]
    })
    win.show();
}


</script>

<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->
<div id="divpay"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
</div>
<div>
<div id="main" style="margin-top: 15px;">
<div style="width: 95%; margin: 0 auto">



<div class="list">
<form target="_blank" action="train!ordertrain.action" method="POST" id='payform' name='payform'>
<input type='hidden' id='seattype' name='seattype' value=''/>
<input type='hidden' id='deliveryadd' name='deliveryadd' value=''/>

   <div class="lbox">
   <Div class="chang"><b class="lan14">
		<ww:property value="train.startcity" />到<ww:property
			value="train.endcity" />订单预定</b>
   </Div>
   <div style="padding: 15px 0 15px 30px;"><b style="font-size:14px;">车票信息</b></div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"	align="center" >
	<tr>
		<td valign="top" style="padding-left: 40px;">
		<input type='hidden' id='tofrom' name=frometo>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="line-height: 26px;">
			<tr>
				<td>您选择的车次为：<ww:property value="train.traincode" /><ww:property
					value="train.startcity" />
					<ww:property value="train.starttime" /> ->
				   <ww:property value="train.endcity" /><ww:property value="train.endtime" /> 
				&nbsp;&nbsp;出发日期：<ww:property value="startdate" />
			<tr>
				<td>
			<tr>
				<td><font style="color:#f00">*</font> 选择席别：
				<select id='zwtype' onchange="getJszw(this.value)">
					<option value="0">请选择</option>
					<ww:property value="#request.zwhtml" />
				</select><font style="color: red" id='vzwtype'></font>&nbsp;&nbsp;
				<font style="color:#f00">*</font>&nbsp;&nbsp;购买数量： 
				<select name="count" id='buycount' onchange="changTictperson(this.value)">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
				</select><font id='vbuycount'></font>
			</td></tr>
			<tr id='jszwid' style="display: none">
				<td><div class="f">如果没有该席别您是否可以接受：</div> <ww:property value="#request.jszw" /></td>
			</tr>
			<ww:if test="train.traincode.indexOf('D')>-1||train.traincode.indexOf('G')>-1">
			<tr><td>您选择的车次从2011年6月1日开始实行实名制购票 ,请您正确填写乘车人身份信息。</td></tr>
					
			<tr>
				<td>
					<div id='divp1' class="pdiv">
					<table>
						<tr>
							<td><font style="color:#f00">*</font>
							姓名：<input size=10 name='pname' id='pname1' /><font style="color: red" id='vpname1'></font> 
							证件类型：<select name='idtype'>
								<option value=2>二代身份证</option>
								<option value=1>一代代身份证</option>
								<option value=3>临时身份证</option>
								<option value=4>护照</option>
							</select>
							 证件号码：<input name='idnumber' id='pid1' /><font style="color: red" id='vpid1'></font> </Td>
						</Tr>
					</table>
					</div>
					<div id='divp2'  class="pdiv" style="display: none">
					<table>
						<tr>
							<td><font style="color:#f00">*</font>
							姓名：<input size=10 name='pname' id='pname2' /><font style="color: red" id='vpname2'></font> 
							证件类型：<select name='idtype'>
								<option value=2>二代身份证</option>
								<option value=1>一代代身份证</option>
								<option value=3>临时身份证</option>
								<option value=4>护照</option>
							</select>
							 证件号码：<input name='idnumber' id='pid2' /><font style="color: red" id='vpid2'></font></Td>
						</Tr>
					</table>
					</div>
					<div id='divp3'  class="pdiv"  style="display: none">
					<table>
						<tr>
							<td><font style="color:#f00">*</font>
							姓名：<input size=10 name='pname' id='pname3' /><font style="color: red" id='vpname3'></font> 
							证件类型：<select name='idtype'>
								<option value=2>二代身份证</option>
								<option value=1>一代代身份证</option>
								<option value=3>临时身份证</option>
								<option value=4>护照</option>
							</select>
							 证件号码：<input name='idnumber' id='pid3' /><font style="color: red" id='vpid3'></font></Td>
						</Tr>
					</table>
					</div>
					<div id='divp4'  class="pdiv"  style="display: none">
					<table>
						<tr>
							<td><font style="color:#f00">*</font>
							姓名：<input size=10 name='pname' id='pname4' /><font style="color: red" id='vpname4'></font> 
							证件类型：<select name='idtype'>
								<option value=2>二代身份证</option>
								<option value=1>一代代身份证</option>
								<option value=3>临时身份证</option>
								<option value=4>护照</option>
							</select>
							 证件号码：<input name='idnumber' id='pid4' /><font style="color: red" id='vpid4'></font></Td>
						</Tr>
					</table>
					</div>
					<div id='divp5'  class="pdiv"  style="display: none">
					<table>
						<tr>
							<td><font style="color:#f00">*</font>
							姓名：<input size=10 name='pname' id='pname5' /><font style="color: red" id='vpname5'></font> 
							证件类型：<select name='idtype'>
								<option value=2>二代身份证</option>
								<option value=1>一代代身份证</option>
								<option value=3>临时身份证</option>
								<option value=4>护照</option>
							</select>
							 证件号码：<input name='idnumber' id='pid5' /><font style="color: red" id='vpid5'></font></Td>
						</Tr>
					</table>
					</div>
				</td>
			</tr>
			</ww:if>
		</table>
		</td>
	</tr>
	
	<tr>
		<td style="padding: 0">
		<div style="padding: 15px 0 5px 30px;"><b style="font-size:14px;">送票地址</b></div>
		<table style="line-height:26px;"> 
		
        <tr><td width="120" align="right"><font style="color:#f00">*</font>&nbsp;
          收票地区：</td><td>
          <div class="f" id="city"></div><font style="color: red;float: left" id='vaddress'></font><div class="c"></div>
          </td>
        <tr><td align="right"><font style="color:#f00">*</font> 街道地址： </td>
        <td><input id='street'/><font style="color: red" id='vstreet'></font></td>
        <tr><td align="right"><font style="color:#f00">*</font> 邮编：</td>
        <td><input name='post'id='post' /><font style="color: red" id='vpost'></font></td>
        <tr><td align="right"><font style="color:#f00">*</font> 联系人姓名：</td>
        <td><input name='contactname' id='contactname'/><font style="color: red" id='vcontactname'></font></td></tr>
        <tr><td align="right"><font style="color:#f00">*</font> 联系人手机：</td>
        <td><input name='contactmobile' id='mobile'/><font style="color: red" id='vmobile'></font> 购票相关的所有通知，将发短信到该手机</td></tr>
        <tr><td align="right">其他要求：</td>
        <td><span style="cursor: pointer;color: #3582c8"  onclick="showYQ(this)">添加</span>
        <textarea rows="2" cols="30" id='yq' name='memo' style="display: none;"></textarea>
        </td></tr>	
		</table>
		</td>
	</tr>
	<tr>
	<td style="padding: 0">
		<div style="padding: 15px 0 5px 30px;"><b style="font-size:14px;">送票时间范围</b>（如快递没有准时送达，本网将承担购票损失。）</div>
		<div style="line-height: 26px; padding-left: 40px;">
		 <ul>
		  <li><input onclick="addDmoney(20)" name='deliverytype' value='1' money=20 type="radio" />出票后当天送到（当天11点前出票，周一至周六，节假日除外） 同城件   配送件：20元/件 </li>
		  <li><input onclick="addDmoney(15)" name='deliverytype' value='2' money=15  type="radio" />出票后1-2个工作日送到（周一到周日，节假日顺延） 次日件   配送件：15元/件 </li>
		  <li><input onclick="addDmoney(30)" name='deliverytype' value='3' money=30 type="radio" />出票后4个工作日内送到（周一到周日，节假日顺延） 隔日件   配送件：30元/件</li>
		 </ul>
		</div>
    </td>     
	</tr>
	<tr><td style="text-align: center;font-size: 14px; padding-top: 15px;"><font id='totalprice' color="red" style="font-size:14px; font-weight:bold; color:#f48000"></font> 元(应付款) =
         <b><font id='ticketprice' color="red" style="font-size:14px; font-weight:bold; color:#f48000" ></font></b> 元(票总价)+ <font color="red" id='dpayid' style="font-size:14px; font-weight:bold; color:#f48000"></font> 元(配送费) + <font color="red" style="font-size:14px; font-weight:bold; color:#f48000">5</font> (代售服务费/张)<!--  + <font id='payservice' style="color: color:#f48000"></font> 元(支付服务费:1%) --> 
		</td></tr>
	<tr><td style="height: 80px; text-align: center;">
	<input type='button' onclick="payorder()" class="button" value="立即支付"/></td></tr>
</table>
</div>
</form>
</div>
</div>
</div>
<script type="text/javascript">
function getJszw(v){
 var str="showJSandCount("+v+");";
 eval(str);
}
var dmoney=0;
function  showJSandCount(train){
var v=train.type;
$("#seattype").val(v);
var price=train.price;
var count=''
if(v==0){
 $("#jszwid").hide();
 }else{ 
 $("#jszwid").show();
 $("div[id*=daccept]").show();
 $("#daccept"+v).hide();
 }
 var pcount=$("#buycount").val();
 var totaltprice=price*pcount;
 var servicemoney=0;//totaltprice/100;
 var dsmoney=5*pcount;
 var totalprice=totaltprice+servicemoney+dmoney+dsmoney;
 $("#totalprice").html(totalprice);
 $("#tofrom").val(totalprice);
 $("#ticketprice").html(price*pcount);
 //$("#payservice").html(servicemoney);
 
}

function changTictperson(v){
$(".pdiv").hide();
for(var i=1;i<=v;i++){
$("#divp"+i).show();
}
 var v=$('#zwtype').val();
 getJszw(v);
}
function addDmoney(money){
dmoney=money;
 $("#dpayid").html(money);
 var v=$('#zwtype').val();
 getJszw(v);
}

function payorder(){
if(formval()){
var sname=$("#ct1").val();
var cname=$("#ct2").val();
var qname=$("#ct3").val();
var stree=$("#street").val();
$("#deliveryadd").val(sname+cname+qname+stree);
document.forms.payform.submit();
expexcel();

}

}

$(function(){
		$("#city").ProvinceCity();
});

function formval(){
  var seat=twoval('zwtype',0,'必须选择');
  var namecard=true;
  for(var i=1;i<=5;i++){
   var thenode=document.getElementById("divp"+i);
    if($("#divp"+i).css("display")!= "none"){
      if(namecard){
      namecard=twoval('pname'+i,'','必须填写');
      namecard=twoval('pid'+i,'','必须填写');
      }else{
       twoval('pname'+i,'','必须填写');
       twoval('pid'+i,'','必须填写');
      }
     
    } 
  }
  
  var city=valcity();
  var treet=twoval('street','','必须填写');
  var post=twoval('post','','必须填写');
  var contname=twoval('contactname','','必须填写');
  var mobile=twoval('mobile','','必须填写');
  if(seat&&namecard&&city&&treet&&post&&contname&&mobile){
    return true;
  }else{  
    return false;
  }

}

function valcity(){

  var sc=true;
  var cc=true;
  var qc=true;
  $("#vaddress").html("请选择");
  var sname=$("#ct1").val();
  var cname=$("#ct2").val();
  var qname=$("#ct3").val();
  if(sname=="请选择"){
    sc=false;
   }
  if(cname=="请选择"){
    cc=false;
   }
  if(qname=="请选择"){
    qc=false;
   }
   if(sc&&cc&&qc){
    $("#vaddress").html("");
     return true;
   }else{
     return false;
   }

}

function twoval(id,val,vhtml){
  var idval=$("#"+id).val();
  if(idval==val){
   $("#v"+id).html(vhtml);
    return false;
  }else{
   $("#v"+id).html("");
   return true;
  }
}
function showYQ(obj){
$(obj).hide();
$("#yq").show();

}
</script>
</BODY>

