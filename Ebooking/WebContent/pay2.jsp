<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<style type="text/css">
<!--
.STYLE1 {
	font-weight: bold
}

--> /*pageSelect*/
.pageSelect {
	width: 100%;
	background: url("/seashell/gateway/img/button/pages/bg.gif") repeat-x
		bottom;
	font-size: 14px;
	line-height: normal;
}

.pageSelect ul {
	margin: 0;
	padding: 10px 10px 0;
	list-style: none;
}

.pageSelect li {
	float: left;
	margin: 0 1px;
	padding: 0 0 0 9px;
}

.pageSelect ul a {
	margin-left: -4px;
	text-indent: 6px;
	float: left;
	background: url("/seashell/gateway/img/button/pages/right.gif")
		no-repeat right top;
	padding: 8px 15px 2px 6px;
	text-decoration: none;
	color: #765;
}

/* Commented Backslash Hack
   hides rule from IE5-Mac \*/
.pageSelect ul a {
	float: none;
}

/* End IE5-Mac hack */
.pageSelect .current li {
	background-image: url("images/payimages/left_on.gif");
}

.pageSelect .current {
	background: url("images/payimages/left_on.gif") no-repeat 0 4px;;
	float: left;
}

.pageSelect .current a {
	background: url("images/payimages/right_on.gif") no-repeat right 4px;
	line-height: 28px;
	height: 15px;
	float: left;
	color: #2E3092;
	display: block;
	padding-bottom: 8px;
	font-weight: bold;
	overflow: hidden;
}

.pageSelect .usual {
	background: url("images/payimages/left.gif") no-repeat 0 8px;
	float: left;
}

.pageSelect .usual a {
	background-image: url("images/payimages/right.gif");
	height: 15px;
	float: left;
	color: #000;
	padding: 6px 15px 0px 6px;
	display: block;
	margin-top: 8px;
}

div.pageSelectR {
	float: right;
	padding-right: 15px;
	padding-top: 10px;
	font-size: 12px;
}

div.pageSelectR a {
	display: inline;
	background: none;
}

div.pageSelectR img {
	vertical-align: text-bottom;
}

.Menu {
	height: 20px;
	list-style: none;
	display: inline;
	margin-top: 1px;
}

.Menu ul {
	margin-left: 5px;
}

.Menu ul li {
	display: block;
	cursor: pointer;
	float: left;
	background: url('images/payimages/MainCenterSelected.gif') no-repeat;
	margin-right: 2px;
}

.Menu ul li span {
	display: block;
	padding-right: 12px;
	line-height: 25px;
	font-size: 13px;
	font-weight: 600;
	text-align: center;
	background: url('images/payimages/MainCenterSelected.gif') no-repeat right 0;
	margin-left: 10px;
}

#MenuMain {
	padding: 5px;
	font-size: 13px;
	width: 750px;
	border-left: darkgray 1px solid;
	border-right: darkgray 1px solid;
	border-top: darkgray 1px solid;
	border-bottom: darkgray 1px solid;
}

</style>
</head>
<!-- 支付接口操作开始
paytype==1:支付宝
paytype==2:快钱
paytype==3：财付通
 --> <script>
 function submitform(paymethod,paytype){
 alert("???");
 
    if("vmoney"==paymethod){
        <ww:if test="#session.loginuser!=null">
          <ww:if test="#request.ordermap.vmpayenable">
           if(confirm("确定使用虚拟账户支付当前订单？")){
	          $("#form1").removeAttr("target");
	          document.form1.action='<ww:property value="#request.ordermap.actionname" />?orderid=<ww:property value="#request.ordermap.orderid"/>';
	          document.form1.submit();    
	          }
         </ww:if>
         <ww:else>
         alert("您的当前账户余额不足于订单支付!");
         </ww:else>
      </ww:if>
      <ww:else>  
        alert("请您先登录！");  
      </ww:else>
     }else{
      setPaymethod(paymethod);
      //支付宝1,  若为块钱2请随机应变
      
      var url='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Alipay?';
      var info="";
      if(paytype==1){//支付宝支付
        info='helpername=<ww:property value="#request.ordermap.billname"/>&orderid=<ww:property value="#request.ordermap.orderid"/>';
        }
      if(paytype==2){//快钱支付
       url='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Billpay?'
       info='helpername=<ww:property value="#request.ordermap.billname"/>&orderid=<ww:property value="#request.ordermap.orderid"/>';
       }
       document.form1.action=url+info;
       <ww:if test="#request.rechtype==1||#request.rechtype==2">
       showwindow();
       </ww:if>
      document.form1.submit();
      }
  }
  
  
  
function showwindow(){
$("#divpay").dialog({
	                title:'提示',
	                show: null,
	                bgiframe: false,
	                autoOpen: false,
	                draggable: true,                
	                resizable: true,
	                modal: true,
	                width: 500,
	                height: 250
		            });
		         $("#divpay").dialog("open");
		        var htmstr="<table width='100%'><tr><td align='center'><table><tr><td><img src='images/payimages/icon64_info.png' /></td><td><b> 请到打开的新窗口进行银行卡支付。</b><p>付款未完成前请不要关闭本页面。</p></td>";
		        htmstr+="<tr><td colspan='6' height='80px'><input onclick='closedialog()' class='button_jo' type=button value='重新选择银行'/> ";
		        htmstr+="<input onclick='goNext()' class='button_jo' type=button value='下一步'/></td></tr></table></td></tr></table>";
		         $("#divpay").html(htmstr);           
		           
}

function goNext(){
window.location.href='<ww:property value="#request.payresulturl"/>';
}

 function closedialog()
 {
  
   $("#divpay").dialog("close");
 }
  
  
  
  
  
  
  function submitform2(paymethod)
  {
      document.form1.action="../lthk_interface/Alipay";
      document.form1.submit();
  }
  //选项卡切换
  function changepaytable(id){
  	$(".two").removeClass("current");
  	$(".two").addClass("usual");
  	$(".cold").hide();
  	$("#paytable"+id).show();
  	$("#payli"+id).removeClass("usual");
  	$("#payli"+id).addClass("current");
  }

  function setPaymethod(paymethod)
  {
  	document.getElementById("paymethod").value=paymethod;
  }
  function setBillpaymethod(paymethod)
  {
  	document.getElementById("Billpaymethod").value=paymethod;
  }
</script>

<form action="" target="_blank" id="form1" name="form1" method="post">
<input type='hidden' name='paymethod' id='paymethod' value="directPay" />
<div style="border:1px solid #f6f6f6; margin-top:15px;">
<div style="line-height: 28px; padding-left: 20px; background:#f0f0f0; color:#666;  padding-left:20px; width:98%; overflow:hidden;"> <span style="font-size:15px;">◆</span><b>请选择您的在线支付方式，进行订单支付</b></div>
</div>
<table width="90%" border="0" cellpadding="0 " ccellspacing="0"	bordercolor="#b3b3b3"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 10px; text-align: left;">
	<tr>
		<td>
		<div class="pageSelect f">
		<ul>		
		       		
				<li id="payli0" class="current two">
				<a href="javascript:void(0)"
				onclick="changepaytable('0');return false;">支付宝账户支付</a>
				</li>
				
				
				<li id="payli1" class="usual two">
			    <a href="javascript:void(0)"	onclick="changepaytable('1');return false;">快钱账户支付</a>
			    </li>
			    <!-- 支付宝 -->
				<li id="payli2" class="usual two">
		    	<a href="javascript:void(0)"	onclick="changepaytable('2');return false;" title="">银行卡网银支付</a>
		    	</li>
			    <!-- 块钱 -->
				<li id="payli3" class="usual two">
		    	<a href="javascript:void(0)"	onclick="changepaytable('3');return false;" title="">银行卡网银支付</a>
		    	</li>
		    	<!-- 支付宝 
			    <li id="payli4" class="usual two" >
			    <a href="javascript:void(0)"	onclick="changepaytable('4');return false;" title="">信用卡支付</a>
			    </li>-->
			     <!-- 块钱 
			    <li id="payli5" class="usual two">
			    <a href="javascript:void(0)"	onclick="changepaytable('5');return false;">信用卡支付</a>
			    </li>-->
			     <ww:if test="#application.vmoneyservice!=null">
			     <ww:if test="#request.vmoneyrecharge==null">
					<li id="paylivmoney" class="usual two">
						<a href="javascript:void(0)" onclick="changepaytable('vmoney');return false;">
						 虚拟账户支付</a>
					</li>
					</ww:if>
				</ww:if>	
		</ul>
		<div style="border: 1px solid #b3b3b3; float: left; margin：0 auto; width:90%; line-height: 24px; padding: 20px;">
		
		
		<!-- 支付宝账户支付 -->
		<table id="paytable0" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%" >
			<tr>
				<td>
			     <a   href="javascript:void(0)"  onclick='submitform("directPay",1)'>
			     <img src="images/payimages/webpay.gif" /> 
			     </a>
			    </td>
			</tr>  
		</table>
		<!-- 块钱账户支付 -->
		<table id="paytable1" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%"  style="display: none;"	>
			<tr>
				<td><a href="javascript:void(0)" onclick="submitform('12',2);"> <img src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>  
		</table>
		<!-- 支付宝网银支付 -->
		<table id="paytable2" class='cold' border="0" cellpadding="0" cellspacing="0"
			width="100%" style="display: none;">
				<tr>
                   <td height="40">
                   <input type="radio" checked="checked" id="pay_bank" name="pay_bank" value="ICBCB2C"/><img src="images/payimages/ICBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CMB"/><img src="images/payimages/CMB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CCB"/><img src="images/payimages/CCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="BOCB2C"><img src="images/payimages/BOC_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td height="40"><input type="radio" name="pay_bank" value="ABC"/><img src="images/payimages/ABC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="COMM"/><img src="images/payimages/COMM_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SPDB"/><img src="images/payimages/SPDB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="GDB"><img src="images/payimages/GDB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td height="40"><input type="radio" name="pay_bank" value="CITIC"/><img src="images/payimages/CITIC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CEBBANK"/><img src="images/payimages/CEB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CIB"/><img src="images/payimages/CIB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SDB"><img src="images/payimages/SDB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td height="40" ><input type="radio" name="pay_bank" value="CMBC"/><img src="images/payimages/CMBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="HZCBB2C"/><img src="images/payimages/HZCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SHBANK"/><img src="images/payimages/SHBANK_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="NBBANK "><img src="images/payimages/NBBANK_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td height="40"><input type="radio" name="pay_bank" value="SPABANK"/><img src="images/payimages/SPABANK_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="BJRCB"/><img src="images/payimages/BJRCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="ICBCBTB"/><img src="images/payimages/ENV_ICBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CCBBTB"/><img src="images/payimages/ENV_CCB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td height="40"><input type="radio" name="pay_bank" value="SPDBB2B"/><img src="images/payimages/ENV_SPDB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SPDBB2B"/><img src="images/payimages/ENV_SPDB_OUT.gif" border="0"/></td>
				   <td></td>
				   <td></td>
            </tr>
			<tr>
				<td colspan="4" height="70">
				<a href="javascript:void(0)" onclick="submitform('bankPay',1)"> <img
					src="images/payimages/webpay.gif" /> </a></td>
			</tr>
		</table>
		<!-- 块钱网银支付 -->
		<table id="paytable3" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%" style="display: none;">
			<tr>
				<td height="40" width="20%">
				<input name="billbank" type="radio" value="ICBC" checked="checked" /><img
					src="images/payimages/billpay/bank_icbc.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CMB" /><img
					src="images/payimages/billpay/bank_cmb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CCB" /><img
					src="images/payimages/billpay/bank_ccb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="ABC" /><img
					src="images/payimages/billpay/bank_abc.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="BOC" /><img
					src="images/payimages/billpay/bank_boc.gif"></td>
			</tr>
			<tr>
				<td height="40" width="20%"><input name="billbank" type="radio" value="SPDB" /><img
					src="images/payimages/billpay/bank_spdb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="BCOM" /><img
					src="images/payimages/billpay/bank_bcom.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CMBC" /><img
					src="images/payimages/billpay/bank_cmbc.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="SDB" /><img
					src="images/payimages/billpay/bank_sdb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="GDB" /><img
					src="images/payimages/billpay/bank_gdb.gif"></td>
			</tr>
			<tr>
				<td height="40" width="20%"><input name="billbank" type="radio" value="CITIC" /><img
					src="images/payimages/billpay/bank_citic.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="HXB" /><img
					src="images/payimages/billpay/bank_hxb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CIB" /><img
					src="images/payimages/billpay/bank_cib.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="GZRCC" /><img
					src="images/payimages/billpay/bank_gzrcc.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="GZRCC" /><img
					src="images/payimages/billpay/bank_gzrcc.gif"></td>
			</tr>
			<tr>
				<td height="40" width="20%"><input name="billbank" type="radio" value="SHRCC" /><img
					src="images/payimages/billpay/bank_shrcc.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CPSRB" /><img
					src="images/payimages/billpay/bank_post.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CEB" /><img
					src="images/payimages/billpay/bank_ceb.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="BOB" /><img
					src="images/payimages/billpay/bank_bob.gif"></td>
				<td width="20%"><input name="billbank" type="radio" value="CBHB" /><img
					src="images/payimages/billpay/bank_cbhb.gif"></td>
			</tr>
			<tr>
				<td height="40" width="20%"><input name="billbank" type="radio" value="BJRCB" /><img
					src="images/payimages/billpay/bank_bjrcb.gif"></td>
				<td width="20%"></td>
				<td width="20%"></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td colspan="5">
				<a href="javascript:void(0)"
					onclick="submitform('10',2);"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>
		<!-- 支付宝信用卡
		<table id="paytable4" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%" style="display: none;">
			<tr>
				<td>支付宝提供的信用卡在线支付，你可以通过信用卡支付货款到商家。</td>
			</tr>
			<tr>
				<td><a href="javascript:void(0)" onclick="submitform('creditcard')"> <img
					src="images/payimages/webpay.gif" /> </a></td>
			</tr>
		</table> -->
		<!-- 快钱信用卡 
		<table id="paytable5" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%" style="display: none;">
			<tr>
				<td>块钱提供的信用卡在线支付，你可以通过信用卡支付货款到商家。</td>
			</tr>
			<tr>
				<td>支付总额: ￥<ww:property value="getorderpricesum(orderinfo.id)"/><ww:property value="getorderRelation(orderinfo.id)"/> <br /><a href="#" onclick="submitform('2');return false;"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>-->
		<!--
		<table id="paytable4" border="0" cellpadding="0" cellspacing="0"
			width="100%" style="display: none;">
			<tr>
				<td>请确认您的银行卡已开通电话支付业务，您可以使用固定电话、手机、小灵通直接拨打。 </td>
			</tr>
			<tr>
				<td>支付总额: ￥<ww:property value="getorderpricesum(orderinfo.id)"/><ww:property value="getorderRelation(orderinfo.id)"/> <br /><a href="#" onclick="submitform('2');return false;"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>
		<table id="paytable5" border="0" cellpadding="0" cellspacing="0"
			width="100%" style="display: none;">
			<tr>
				<td>支付总额: ￥<ww:property value="getorderpricesum(orderinfo.id)"/><ww:property value="getorderRelation(orderinfo.id)"/> <br /><a href="#" onclick="submitform('2');return false;"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>
		<table id="paytable6" border="0" cellpadding="0" cellspacing="0"
			width="100%" style="display: none;">
			<tr>
				<td>支付总额: ￥<ww:property value="getorderpricesum(orderinfo.id)"/><ww:property value="getorderRelation(orderinfo.id)"/> <br /><a href="#" onclick="submitform('2');return false;"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>
		<table id="paytable7" border="0" cellpadding="0" cellspacing="0"
			width="100%" style="display: none;">
			<tr>
				<td>支付总额: ￥<ww:property value="getorderpricesum(orderinfo.id)"/><ww:property value="getorderRelation(orderinfo.id)"/> <br /><a href="#" onclick="submitform('2');return false;"> <img
					src="images/payimages/rmbbut1.gif" /> </a></td>
			</tr>
		</table>-->
		<ww:if test="#application.vmoneyservice!=null">
		<table id="paytablevmoney" style="display: none;" class='cold' border="0" cellpadding="0" cellspacing="0" width="100%" >
			<tr>
				<td>
			     <a   href="javascript:void(0)"  onclick='submitform("vmoney")'>
			     <img src="images/payimages/webpay.gif" /> 
			     </a>
			    </td>
			</tr>  
		</table>
		</ww:if>
		</div>
		</div>
		</td>
	</tr>
</table>

</form>
<!-- 支付接口结束 -->
<div id="divpay"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
</div>
</html>
