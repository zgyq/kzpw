<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<style type="text/css">
.bor {
	background: #FFE;
	border: #F90 1px dotted;
	margin: 5px;
	padding: 5px;
	overflow: hidden;
}
.huangf60_16{font-weight:bold; color:#f60; font-size:16px;}
</style>
<link href="<%=request.getContextPath() %>/style/Layout.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/base.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" media="all"
	href="css/globalframe.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine.js"
	type="text/javascript"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

function formatCurrency(num) {
num = num.toString().replace(/\|\,/g,'');
if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();
if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+','+
num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + '' + num + '.' + cents);
}



$(document).ready(function(){
var price=$("#pervalue").val();

if(isNaN(price)){
    $("#qmoney").html("抱歉！"+price+"，暂无法充值");
   $("#subbtn").attr("disabled","disabled");
    $("#danwei").html("");
 }
});

function getInprice(){
$("#jiage").html("");
 if(bmobile){
   var area=$("#sname").val();
   var type=$("#mtype").val();
   var price=$("#pervalue").val();
    $.ajax({
       url:"ofcard!ajaxGetInprice.action",
      type:"POST",
      data:{areaname:area,pervalue:price,mobiletype:type},
      beforeSend:function(){$("#message1").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
      $("#message1").html("");
        $("#jiage").html(data);
    }
    
    });
  }
}

  
  
  
function submintform(){
 if(valiphonenumber()){ 
   if(confirm("是否确认支付订单？")){
    document.form1.submit();  
     }
 
 }

}

function changeCheckMoney(obj){
  if(obj){
   $(".lmoney").removeAttr("disabled");;
  }else{
  $(".lmoney").checked=false;
  $(".lmoney").attr("disabled","disabled");
  $("#fivemoney").attr("checked","checked");
  }
}




function checkQQ(id){
  var qqone=$("#qqone").val();
  var qqtwo=$("#qqtwo").val();
  if(qqone!=""&&qqtwo!=""&&qqone!=qqtwo){
     alert('两次QQ输入不一致，请重新输入！');
  }else if(qqone==""){
    alert("请输入您要充值的QQ号码！");
  }else if(qqtwo==""){
    alert("请再次输入您要充值的QQ号码！");
  }else{
    var cardid=$("#buycid").val();
    var buynum=$("#buynum").val();
    var qmoney= $("#qbmoney").html();
    var vmoney= $("#vmoney").val();
    if(confirm("是否确认订单支付？")){
     window.location.href="ofcard!webQmoneyRecharge.action?rechmoney="+qmoney+"&cardid="+cardid+"&buynum="+buynum+"&qqnumber="+qqone;
     }
    
  }
}
function validateQQ(){
  var qqone=$("#qqone").val();
  var qqtwo=$("#qqtwo").val();
   $("#vqqone").html("");
  var bresult=true;
  if(qqone==""){
    $("#vqqone").html("请输入您要充值的QQ号");
    bresult=false;
  }
  if(isNaN(qqone)){
     $("#vqqone").html("QQ号只能是数字。");
       bresult=false;
 }
  
 return  bresult;
}
function validateQQt(){
  var qqone=$("#qqone").val();
  var qqtwo=$("#qqtwo").val(); 
  $("#vqqtwo").html("");
   var bresult=true;
    if(isNaN(qqtwo)){
     $("#vqqtwo").html("QQ号只能是数字");
    bresult=false;
    return bresult;
 }
  if(qqtwo==""){
    $("#vqqtwo").html("请再次输入您要充值的QQ号");
    bresult=false;
    return bresult;
  }
  if(qqtwo!=qqone){
    $("#vqqtwo").html("两次输入的QQ号不同");
    bresult=false;
  }
  return bresult;
}

function qmoneyRecharge(){
  if(validateQQ()&&validateQQt()){
    $("#qmoneyform").submit();  
   }
} 

function priceChange(price){
$("#pervalue").val(price);
getInprice();
}

function countMoney(count){
  var price=$("#pervalue").val();
  if(isNaN(price)){
  $("#qmoney").html(price);
  }else{
  $("#qmoney").html(formatCurrency(count*price));
  }
}

function changQBnum(id,value){
 var pervalue=$("#inprice"+id).val();
 var money=formatCurrency(pervalue*value);
 $("#qbmoney").html(money);
 
}
</script>
</head>
<body>
<form id="qmoneyform" name="qmoneyform" action="ofcard!webQmoneyRecharge.action"
	type="post">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box" height="100%">
	<tr>
		<td width="100%" align="left" height="29" class="box-bottom bg">
		<b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;充值业务</span></b></td>
	</tr>
	<tr>
		<td width="100%" height="10"></td>
	</tr>
	<tr>
		<td valign="top">
		<table border="0" style="width: 100%">
			<tbody>
				<tr>
					<td colspan="3">
					<div>
					<div>
					<table width="80%" class="listing" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td class="tableheader" align="left"><span
									style="cursor: pointer" onclick="switchPQ('qb','phone')">Q币充值</span>
								</td>
								<td class="tableheader"><ww:property
									value="s_gundongmessage" /></td>
							</tr>
							<tr style="height: 10px">
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td align="center" colspan="2">

								<table width="680" border="1" cellspacing="0" cellpadding="0">
									<tr>
										<td height="28" class="table_color colortrin" style="text-align:right" width="130">产品名称：</td>
										<td height="28" class="table_color_l"><input type="hidden"
											name="cardid"
											value='<ww:property value="#request.qmonymap.cardid"/>' /> <input
											type="hidden" id="pervalue"
											value='<ww:property value="#request.qmonymap.inprice"/>' />
										<ww:property value="#request.qmonymap.othername" /></td>
									</tr>
									<tr>
										<td height="28" class="table_color colortrin" style="text-align:right" width="130">QQ帐号：</td>
										<td height="28" class="table_color_l">
										<input type="text" id='qqone'
											name="qqnumber"
											value='<ww:property value="#request.qqnumber"/>'
											onblur="validateQQ()"  /> <font id='vqqone'
											color="red"></font></td>
									</tr>
									<tr>
										<td height="28" class="table_color colortrin" style="text-align:right" width="130">确认QQ帐号：</td>
										<td height="28" class="table_color_l"><input type="text" id='qqtwo'
											 value='<ww:property value="#request.qqnumber"/>'
											onblur="validateQQt()" /><font id='vqqtwo' color="red"></font></td>
									</tr>

									<tr>
										<td height="28" class="table_color colortrin" style="text-align:right">充值数量：</td>

										<td height="28" class="table_color_l"><select name="buynum"
											id='buynum' style="width: 100px"
											onchange="countMoney(this.value)">

											<ww:property
												value="getQBCountHtml(#request.qmonymap.amounts,converNull(#request.buyamount,1))" />
										</select>
									<tr>
										<td height="28" class="table_color colortrin" style="text-align:right">价格：</td>
										<td height="28" class="table_color_l"><font id="qmoney"
											class="huangf60_16"> <ww:property
											value="#request.qmonymap.inprice" /> </font> <font id='danwei'
											class="huangf60_16">元</font></td>
									</tr>
									</td>
									</tr>
									
								</table>

								</td>
							</tr>
							<tr style="height:5px">
								<td colspan="2"></td>
							</tr>
							<tr style="height: 28px">
								<td colspan="2"><input name=""
											id="subbtn" onclick="qmoneyRecharge()" type="button"
											class="button_d font-bai" value="立即支付" /></td>
							</tr>
							<tr style="height:5px">
								<td colspan="2"></td>
							</tr>
						</tbody>
					</table>
					</div>
					</div>
					</td>
				</tr>
				<tr>
					<td colspan="3" height="10px"></td>
				</tr>
				<tr>
					<td align="left" valign="top"></td>
				</tr>
			</tbody>
		</table>
		</div>
		<div id="divpassenger"
			style="text-align: center; display: none; background-color: #fff; left: 0px;">正在加载订单信息...
		</div>
		</form>
</body>
</html>
