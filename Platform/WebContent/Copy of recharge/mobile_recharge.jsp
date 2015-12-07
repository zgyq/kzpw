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
var bmobile=false;

function validatePhoneyu(){
 $("#vresult").html("");
 $("#phonetwo").html("");
 $("#vphoneone").html(""); 
 $("#address").html("");
 var phoneone=$("#phoneone").val();
 var mobile=$("#phones").val();
 if(phoneone==""){
   $("#vphoneone").html("请输入您的手机号码");return;
 }else if(isNaN(phoneone)){
   $("#vphoneone").html("请输入正确的手机号码");return;
 }else if(mobile==""){
   $("#phonetwo").html("请再次输入您的手机号码");
   return;
 }else if(isNaN(mobile)){
    $("#phonetwo").html("请输入正确的手机号码");return;
 }else if(phoneone!=mobile){
  $("#phonetwo").html("两次输入不一致");return;
 }else{
if(mobile.length==11){
 $.ajax({
      type:"POST",
      url:"ofcard!ajaxMobileInfo.action",
      data:{phonenumber:mobile},
      success:function(data){
          eval(data);
      }            
      }); 
  }else{
  bmobile=false;
  }
 }
}

function valiphonenumber(){
  var phoneone=$("#phoneone").val();
  var phones=$("#phones").val();
  if(phoneone!=phones&&phones!=""&&phoneone!=""){
    alert("两次手机号码输入不一致，请重新输入！");
    return false;
  }else{
    if(phoneone==""){
       alert("请输入手机号码");
       return false;
    }
    if(phones==""){
       alert("请再次输入手机号码");
       return false;
    }
  }
  return true;
  }
   
 

function querycallback(obj){
alert(obj);
var s="";
var sg="";
var company=obj["Corp"].substring(2,4);
if (obj["QueryResult"] == "True"){
        s =obj["City"]+company;
        sg=obj["Province"];
        $("#sname").val(sg);
        bmobile=true;
        if(company=="电信"){
           $("#mtype").val("3");
          }else if(company=="联通"){
            $("#mtype").val("2");
          } else{
              $("#mtype").val("1");
         }
        getInprice();
    }else{  
        s = "检测失败";  
   } 
  
   $("#address").html(s);
}


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
      if(isNaN(data)){
       $("#subbtn").attr("disabled","disabled");        
        $("#danwei").html("");
        $("#jiage").html("抱歉！"+data+",暂无法充值。");
      }else{
      $("#subbtn").removeAttr("disabled");
       $("#danwei").html("元");
        $("#jiage").html(data);
        }
        
        
        
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


function priceChange(price){
//alert(price);
$("#pervalue").val(price);
$("#jiage").html(price);

//getInprice();//异步请求5173  获取价格
}

</script>
</head>
<body>
<form id="form1" name="form1" action="ofcard!webmobileRecharge.action" type="post">
	<input type='hidden' id="vmoney" value='<ww:property value="#request.vmoney"/>' />
	<input type="hidden" name="sname" id='sname' /> 
	<input type="hidden" id="mtype" name="mobiletype" value='<ww:property value="#request.mobiletype"/>' />
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box" height="100%">
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
								<td class="tableheader" align="left">
								<span style="cursor: pointer" onclick="switchPQ('phone','qb')">手机话费充值</span>
								<span style="color: red">(1~5分钟到帐，支持中国移动，联通，电信充值)</span></td>
								<td class="tableheader"><ww:property
									value="s_gundongmessage" /></td>
							</tr>
							<tr>
								<td align="center" colspan="2">
								<div id="phone">
								<table width="98%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="77%" align="center" valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr style="height: 15px">
												<td colspan="2"><input type="hidden" id="mtype"
													name="mobiletype" /></td>
											</tr>
											<tr style="height: 35px">
												<td style="text-align: right; width: 100px" class="table_color colortrin">手机号码：</td>
												<td align="left" class="table_color_l"><input
													id="phoneone" type="text" name="phonenumber" value="" onblur="validatePhoneyu()"
													style="height: 20px; width: 200px" />
													 <font id='vphoneone' color="red"></font>
													</td>
											</tr>
											<tr style="height: 35px">
												<td style="text-align: right;" class="table_color colortrin">确认手机号码：</td>
												<td align="left" class="table_color_l">
												<input
													id="phones" type="text" value=""
													style="height: 20px; width: 200px" onblur="validatePhoneyu()" />
													 <font id='phonetwo' color="red"></font>
													 <b id="address" class="text" style="border: 0px"></b></td>
											</tr>
											<tr style="height: 35px">
												<td style="text-align: right;" class="table_color colortrin">充值方式：</td>
												<td align="left" class="table_color_l"><span
													style="color: red">快充(1~5分钟到帐)</span></td>
											</tr>
											<tr style="height: 35px">
												<td style="text-align: right;" class="table_color colortrin">面值：</td>
												<td align="left" class="table_color_l">
												
												    <input class="lmoney" type="radio" value="0.2" onclick="priceChange(10)" name="quantity" />10元 
													<input class="lmoney" type="radio" value="0.4" onclick="priceChange(20)" name="quantity" /> 20元 
													<input class="lmoney" type="radio" value="0.6" onclick="priceChange(30)" name="quantity" />30元
													<input id="fivemoney" type="radio" value="1" onclick="priceChange(50)" name="quantity" /> 50元
													<input type="radio" value="2"  checked="checked" onclick="priceChange(100)" name="quantity" /> 100元 
													<input type="radio" value="6" onclick="priceChange(300)" name="quantity" /> 300元</td>
											</tr>
												<tr style="height: 35px">
												
												<td style="text-align: right;" class="table_color colortrin">价格：</td>
												<input type="hidden" id="pervalue" value="100" />
												<td class="table_color_l"><font id='message1'></font>
												<font class="huangf60_16" id='jiage'>100</font>
												<font id="danwei">元</font></td>
											<tr>
											
											<tr style="height: 10px">
												<td colspan="2"></td>
											</tr>
											<tr style="height: 35px">
												<td colspan="2" align="center"><input type="button"
													onclick="submintform()" id="subbtn"
													style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
													value="确认订单" /></td>
											</tr>
										</table>
										</td>
										<td width="23%" align="center" valign="top">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td align="center" style="padding-top: 3px">支持如下运营商手机话费充值</td>
											</tr>
											<tr>
												<td align="center"><img src="images/zhongguoyidong.gif"
													alt="中国移动" /></td>
											</tr>
											<tr>
												<td align="center">
												<div>
												<h3>中国移动手机话费充值</h3>
												</div>
												</td>
											</tr>
											<tr>
												<td align="center"><img
													src="images/zhongguoliantong.gif" alt="中国联通" /></td>
											</tr>
											<tr>
												<td align="center">
												<div>
												<h3>中国联通手机话费充值</h3>
												</div>
												</td>
											</tr>
											<tr>
												<td align="center"><img
													src="images/zhongguodianxin.gif" alt="中国电信" /></td>
											</tr>
											<tr>
												<td align="center">
												<div>
												<h3>中国电信手机话费充值</h3>
												</div>
												</td>
											</tr>
										</table>
										</td>
									</tr>
								</table>
								</div>
								</td>
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
