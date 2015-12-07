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

<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<ww:head name="" jsURL="" />
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
  ChangNum(1);
});

var chengrenprice='0';
<ww:if test="ListSpotlineprice.get(0).price!=null">
chengrenprice=<ww:property value="formatMoney_string(ListSpotlineprice.get(0).price)" />;
</ww:if>

var rtprice="0";
<ww:if test="ListSpotlineprice.get(1).price!=null&&ListSpotlineprice.get(1).price!=''">
rtprice=<ww:property value="formatMoney_string(ListSpotlineprice.get(1).price)" />;
</ww:if>


//alert(chengrenprice+","+rtprice);

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
function ChangNum(num){

var strhtml="";
	for(s=0;s<num;s++){
	strhtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
    strhtml+="<table>";
    strhtml+="<tr>";
    strhtml+="<td align='right'>姓名：</td>";
    strhtml+="<td><input type='text' class='sel_searchor' name='pName' id='pName' value='' /><font class='c999 mf15'></font></td>";
    strhtml+="<td align='right'>类型：</td>";
    strhtml+="<td><select id='pType_"+s+"' name='pType' onchange='ChangPtype(this.value);'>";
    strhtml+="<option value='1'>成人</option>";
    if(rtprice>0){
    strhtml+="<option value='2'>儿童</option>";
    }
    strhtml+="</select></td>";
    strhtml+="<td align='right'>性别：</td>";
    strhtml+="<td><select name='pSex'>";
    strhtml+="<option value='1'>男</option>";
    strhtml+="<option value='2'>女</option>";
    strhtml+="<option value='3'>保密</option>";
    strhtml+="</select></td>";
    strhtml+="</tr>";
    strhtml+="<tr>";
    strhtml+="<td align='right'>证件类型：</td>";
    strhtml+="<td><select name='pIdtype'>";
    strhtml+="<option value='1'>身份证</option>";
    strhtml+="<option value='2'>护照</option>";
    strhtml+="<option value='3'>其他</option>";
    strhtml+="</select></td>";
    strhtml+="<td align='right'>证件号码：</td>";
    strhtml+="<td><input type='text' class='sel_searchor' name='pIdNo' id='pIdNo' value='' /><font class='c999 mf15'></font></td>";
    strhtml+="<td align='right'>联系手机：</td>";
    strhtml+="<td><input type='text' class='sel_searchor' name='pMobile' id='pMobile' value='' /><font class='c999 mf15'>(用于紧急联系。)</font></td>";
    strhtml+="</tr>";
    strhtml+="</table>";
    strhtml+="<div class='box_botm booking_line'>&nbsp;</div>";
    strhtml+="</table>";
    }
 $("#tbrecord").html(strhtml);


	NetAllPrice();
 }


function ChangPtype(ptype){
if(chengrenprice==0&&ptype=='1'){
alert("暂不支持成人预订!!!");
return;
}
if(rtprice=='0'&&ptype=='2'){
alert("暂不支持儿童预订!!!");
return;
}

NetAllPrice();
}

function NetAllPrice(){
var zongnum=$("#SpotLineNum").val();

var chengrennum=0;//成人总数
var ertongnum=0;//儿童总数

for(p=0;p<zongnum;p++){
if($("#pType_"+p).val()=='1'){
chengrennum++;
}
if($("#pType_"+p).val()=='2'){
ertongnum++;
}
}

//alert(chengrennum+","+ertongnum+","+zongnum);
//pType

var zongjia=chengrennum*chengrenprice+ertongnum*rtprice;

//alert(zongjia);
$("#zongjia").html(zongjia);
$("#price").val(zongjia);


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
document.form2.submit();
}
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=3&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel">
      
 <form action="spotline!createOrder.jspx" method="post" name="form2" id="form2">
 <div id="list" class="r" style="width: 100%">

    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">预定线路</font>
       <span class="r spot_line_status_three" id="status">&nbsp;</span>
       
       <div class="c"></div>
    </div>
    
    <div class="mt7 ">     
       <div class="mt7 information list_table ">
       <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box">
          <tr>
            <th class="hadow" width="20%" scope="col">线路名称</th>
            <th class="hadow" width="15%" scope="col">出发时间/地点</th>
            <th class="hadow" width="15%" scope="col">行程天数</th>
            <th class="hadow" width="15%" scope="col">计划人数</th>
            
          </tr> 
          <tr>
            <td class="floatall">
                <a href="#" class="l06c"><ww:property value="spotline.name" /></a>
            </td>
            <td><ww:property value="spotline.stime" />/<ww:property value="getSpotCityNameByStr(spotline.cityid)" /></td>
            <td class="f90"><ww:property value="spotline.days" />天</td>
            <td char="font-f60-16">
            <ww:property value="spotline.snums" />人
            </td>
          </tr>         
        </table>
       </div>
       
       <div class="mt7 information list_table ">
       <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box">
          <tr>
            <th class="hadow" width="20%" scope="col">游客类型</th>
            <th class="hadow" width="15%" scope="col">零售价格</th>
            <th class="hadow" width="15%" scope="col">结算价格</th>
            <th class="hadow" width="15%" scope="col">优惠价格</th>
            
          </tr> 
          <ww:iterator value="ListSpotlineprice" status="index">
          <tr>
            <td class="floatall">
                <a href="#" class="l06c"><ww:property value="ptype" /></a>
            </td>
            <td align="center" class="font-f60-del">&yen;<ww:property value="formatMoney_string(lsprice)" /></td>
            <td align="center" class="font-f60-16">&yen;<ww:property value="price" /></td>
            <td char="font-f60-16"  class="font-f60-16">&yen;<ww:property value="GetYouFei(lsprice,price)" />
            </td>
          </tr>  
          </ww:iterator>       
        </table>
       </div>
       
       
        
       
       <div class="box mt10 total">
         <div class="total_main">数量：
         <select name="SpotLineNum" id="SpotLineNum" onchange="ChangNum(this.value);">
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
         <option value="31">13</option>
         <option value="14">14</option>
         <option value="15">15</option>
         <option value="16">16</option>
         <option value="17">17</option>
         <option value="18">18</option>
         <option value="19">19</option>
         <option value="20">20</option>
         </select>
        
         <font class="mf31">合计：</font><font  class="font-f60-16">&yen;<span id="zongjia"><ww:property value="formatMoney_string(ListSpotlineprice.get(0).price)" /></span></font><font  class="c999">&nbsp;(在线支付)</font>
       	<input type="hidden"  name="price" id="price" value="<ww:property value="formatMoney_string(ListSpotlineprice.get(0).price)" />" />
       	<input type="hidden"  name="SpotLineID" id="SpotLineID" value="<ww:property value="SpotLineID" />" />
         </div>
       </div>
    </div>
    <!-- 游客信息开始 -->
    
   <div class="mt7 box" id="infovalue">
       <div class="tit"><span class="low2 black f">游客信息：</span><font class="f90"></font></div>
       <div class="mt20 check_one" id="tbrecord">
       <!--
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <table>
          <tr>
            <td align="right">姓名：</td>
            <td><input type="text" class="sel_searchor" name="pName" id="pName" value="" /><font class="c999 mf15"></font></td>
            <td align="right">类型：</td>
            <td><select name="pType">
            <option value="成人">成人</option>
            <option value="儿童">儿童</option>
            </select></td>
            
            <td align="right">性别：</td>
            <td><select name="pSex">
            <option value="1">男</option>
            <option value="2">女</option>
            <option value="3">保密</option>
            </select></td>
          
          </tr>
          <tr>
          <td align="right">证件类型：</td>
            <td><select name="pIdtype">
            <option value="1">身份证</option>
            <option value="2">护照</option>
            <option value="3">其他</option>
            </select></td>
            <td align="right">证件号码：</td>
            <td><input type="text" class="sel_searchor" name="pIdNo" id="pIdNo" value="" /><font class="c999 mf15"></font></td>
            
             <td align="right">联系手机：</td>
            <td><input type="text" class="sel_searchor" name="pMobile" id="pMobile" value="" /><font class="c999 mf15">(用于紧急联系。)</font></td>
         
          </tr>
        </table>
        <div class="box_botm booking_line">&nbsp;</div>
        </table> 
       -->
       </div>
       
    </div>
     
    <!-- 游客信息结束 -->
    <div class="mt7 box" id="infovalue">
       <div class="tit"><span class="low2 black f">联系人信息：</span><font class="f90"></font>欢迎来到${compname}商旅网预定线路。</div>
       <div class="mt20 check_one">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       
         <table>
          <tr>
            <td align="right">姓名：</td>
            <td><input type="text" class="sel_searchor" name="LinkName" id="LinkName" value="<ww:property value="#session.loginuser.membername" />" /><font class="c999 mf15"></font></td>
          </tr>
          <tr>
            <td align="right">联系手机：</td>
            <td><input type="text" class="sel_searchor" name="LinkMobile" id="LinkMobile" value="<ww:property value="#session.loginuser.mobile" />" /><font class="c999 mf15">(用于接收订单确认短信。)</font></td>
          </tr>
           
          <tr>
            <td align="right">Email：</td>
            <td><input type="text" class="sel_searchor" id="LinkMail" name="LinkMail" value="<ww:property value="#session.loginuser.memberemail" />" /><font class="c999 mf15">建议填写</font></td>
          </tr>
          <tr>
            <td align="right">备注：</td>
            <td>
            <textarea rows="5" cols="100" id="LinkDesc" name="LinkDesc"></textarea>
            <font class="c999 mf15">建议填写</font></td>
          </tr>
          <tr>
            <td colspan="2">
            <div class="check_tips">
              <ul>
              <li>· 线路紧张的时候请立即支付,半小时内未支付的订单系统会自动取消。</li>
              </ul>
            </div></td>
          </tr>
        </table>
        </table> 
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
 <ww:include page="../footer.jsp"/> 
</body>
</html>
