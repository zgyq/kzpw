<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="skin/blue/css/pay.css" rel="stylesheet" type="text/css" />
<style>
.borderstyle{border:1px solid #008aff;}
</style>
<!-- 支付接口操作开始
paytype==1:支付宝
paytype==2:快钱
paytype==3：财付通
 --> 
 <script>
 //立即支付
 function submitform(paymethod,paytype){
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
       var htmstr="<table width='100%'><tr><td align='center'><table><tr><td><img src='images/icon64_info.png' /></td><td><b> 请到打开的新窗口进行银行卡支付。</b><p>付款未完成前请不要关闭本页面。</p></td>";
       htmstr+="<tr><td colspan='6' height='80px'><input onclick='closedialog()' class='button_jo' type=button value='重新选择银行'/> ";
       htmstr+="<input onclick='goNext()' class='button_jo' type=button value='下一步'/></td></tr></table></td></tr></table>";
        $("#divpay").html(htmstr);           
		           
}
//支付成功跳转
function goNext(){
window.location.href='<ww:property value="#request.payresulturl"/>';
}

function closedialog(){  
   $("#divpay").dialog("close");
 } 
  
  function submitform2(paymethod){
      document.form1.action="../lthk_interface/Alipay";
      document.form1.submit();
  }
  //选项卡切换
  function changepaytable(id){
  	$(".two").removeClass("payon_left");
  	$(".two").addClass("payout_left");
  	$(".payright").removeClass("payon_right");
  	$(".payright").addClass("payout_right");
  	$(".boxnei").hide();
  	$("#paytable"+id).show();
  	$("#payli"+id).removeClass("payout_left");
  	$("#payli"+id).addClass("payon_left");
  	$("#payliright"+id).removeClass("payout_right");
  	$("#payliright"+id).addClass("payon_right");
  }

 function setPaymethod(paymethod){
  	document.getElementById("paymethod").value=paymethod;
  }
function setBillpaymethod(paymethod) {
  	document.getElementById("Billpaymethod").value=paymethod;
  }
  function showborder(divid,obj)
  {
     $("#"+divid).find("li").each(function(i){
        $(this).css("float","left");
        $(this).css("border","1px solid #fff");
        
     });
     $(obj).parent().css("border","1px solid #008aff");
     $(obj).parent().css("float","left");
     
  }
</script>
</head>

<body>
  <!--在线支付公用样式-->
  <div class="nohave"></div>
  <form action="" target="_blank" id="form1" name="form1" method="post">
  <input type='hidden' name='paymethod' id='paymethod' value="directPay" />
     <div id="pay">
         <div class="font-000 mornybj"><span class="ico_morny">&nbsp;</span>请选择订单支付方式进行订单支付！</div>
         <div class="pay">
            <ul>
            <li id="payli0" onclick="changepaytable('0');" style="cursor:hand" class="f payon_left two"><span  class="ico_zhifubao f">&nbsp;</span>支付宝支付</li><li id="payliright0" class="f payon_right payright">&nbsp;</li>
            <li id="payli1" onclick="changepaytable('1');" style="cursor:hand" class="f payout_left two"><span class="ico_kuaiqian f">&nbsp;</span>快钱支付</li><li id="payliright1" class="f payout_right payright">&nbsp;</li>
            <!-- 支付宝 -->
            <li id="payli2" onclick="changepaytable('2');" style="cursor:hand" class="f payout_left two"><span class="ico_wangyin f">&nbsp;</span>网上银行支付(支付宝)</li><li id="payliright2" class="f payout_right payright">&nbsp;</li>
            <!-- 支付宝 -->
            <!-- 快钱 -->
            <li id="payli3" onclick="changepaytable('3');" style="cursor:hand" class="f payout_left two"><span  class="ico_wangyin f">&nbsp;</span>网上银行支付(快钱)</li><li id="payliright3" class="f payout_right payright">&nbsp;</li>
            <!-- 快钱 -->
             <ww:if test="#application.vmoneyservice!=null">
			     <ww:if test="#request.vmoneyrecharge==null">
            <li id="paylivmoney" class="f payout_left two"><span  class="ico_caifutong f">&nbsp;</span>虚拟账户支付</li><li id="payliright4" class="f payout_right payright">&nbsp;</li>
            </ww:if>
				</ww:if>
            </ul>
         </div>
         <div class="box c">
         <!--支付宝-->
              <div id="paytable0" class="boxnei">
                   <ul>
                  
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="formatMoneyToInt(orderinfo.orderprice)" /></font>元</li>
                   <li>支付宝注册：如果您好没有支付宝账号，<a target="_blank" href="https://lab.alipay.com/user/reg/index.htm" class="font-33baea">马上注册支付宝账号</a>。</li>
                   <li><span class="ico_zhifubao f">&nbsp;</span>您正在使用支付宝担保交易：付款后资金暂由支付宝保管。</li>
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您已经注册并拥有支付宝账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input type="button" onclick='submitform("directPay",1)' class="bnt_pay" value="" /> </div>
             </div>
           <!--支付宝--> 
           <!--快钱-->
              <div id="paytable1" class="boxnei" style="display:none">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="formatMoneyToInt(orderinfo.orderprice)" /></font>元</li>
                   <li>快钱注册：如果您好没有快钱账号，<a target="_blank" href="https://www.99bill.com/website/signup/websignup.htm" class="font-33baea">马上注册快钱账号</a>。</li>
                   <li><span class="ico_kuaiqian f">&nbsp;</span>您正在使用快钱担保交易：付款后资金暂由支付宝保管。</li>
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您已经注册并拥有快钱账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input type="button" onclick="submitform('12',2);" class="bnt_pay" value="" /> </div>
             </div>
           <!--快钱--> 
         <!--支付宝网上银行-->
             <div id="paytable2" class="boxnei" style="display:none;">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="formatMoneyToInt(orderinfo.orderprice)" /></font>元</li>
                   <li>选择网上银行：<a href="#" class="font-33baea mr15" >如何开通网上银行？</a><a href="#" class="font-33baea" >超过银行支付限额了怎么办？</a></li>
                   </ul>  
                <div class="allyinhang" >
                   <ul id="divalipaybank">
                   <li class="f" style="border: 1px solid #008aff;"><input onclick="showborder(this);" type="radio" checked="checked" id="pay_bank" name="pay_bank" value="ICBCB2C"/><img src="images/payimages/ICBC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CMB"/><img src="images/payimages/CMB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CCB"/><img src="images/payimages/CCB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="BOCB2C"><img src="images/payimages/BOC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="ABC"/><img src="images/payimages/ABC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="COMM"/><img src="images/payimages/COMM_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="SPDB"/><img src="images/payimages/SPDB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="GDB"><img src="images/payimages/GDB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CITIC"/><img src="images/payimages/CITIC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CEBBANK"/><img src="images/payimages/CEB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CIB"/><img src="images/payimages/CIB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="SDB"><img src="images/payimages/SDB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CMBC"/><img src="images/payimages/CMBC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="HZCBB2C"/><img src="images/payimages/HZCB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="SHBANK"/><img src="images/payimages/SHBANK_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="NBBANK "><img src="images/payimages/NBBANK_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="SPABANK"/><img src="images/payimages/SPABANK_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="BJRCB"/><img src="images/payimages/BJRCB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="ICBCBTB"/><img src="images/payimages/ENV_ICBC_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="CCBBTB"/><img src="images/payimages/ENV_CCB_OUT.gif" border="0"/></li>
                   <li class="f"><input onclick="showborder('divalipaybank',this);" type="radio" name="pay_bank" value="SPDBB2B"/><img src="images/payimages/ENV_SPDB_OUT.gif" border="0"/></li>
                   <div class="c"></div>
                   </ul>
                </div>
                <div class="nohave">&nbsp;</div>
                <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您选择的银行卡已开通了网上支付功能，否则将无法支付成功。</div>
                <div class="nohave">&nbsp;</div>
                <div class="paybnt"><input type="button"   onclick="submitform('bankPay',1)" class="bnt_pay" value="" /> </div>
             </div>
           <!--支付宝网上银行-->
           <!--快钱网上银行-->
             <div id="paytable3" class="boxnei" style="display:none;">
                   <ul >
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="formatMoneyToInt(orderinfo.orderprice)" /></font>元</li>
                   <li>选择网上银行：<a href="#" class="font-33baea mr15" >如何开通网上银行？</a><a href="#" class="font-33baea" >超过银行支付限额了怎么办？</a></li>
                   </ul>  
                <div class="allyinhang" >
                   <ul id="divbillpaybank">
                   <li class="f" style="border: 1px solid #008aff;"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="ICBC" checked="checked" /><img
					src="images/payimages/billpay/bank_icbc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CMB" /><img
					src="images/payimages/billpay/bank_cmb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CCB" /><img
					src="images/payimages/billpay/bank_ccb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="ABC" /><img
					src="images/payimages/billpay/bank_abc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="BOC" /><img
					src="images/payimages/billpay/bank_boc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="SPDB" /><img
					src="images/payimages/billpay/bank_spdb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="BCOM" /><img
					src="images/payimages/billpay/bank_bcom.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CMBC" /><img
					src="images/payimages/billpay/bank_cmbc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="SDB" /><img
					src="images/payimages/billpay/bank_sdb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="GDB" /><img
					src="images/payimages/billpay/bank_gdb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CITIC" /><img
					src="images/payimages/billpay/bank_citic.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="HXB" /><img
					src="images/payimages/billpay/bank_hxb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CIB" /><img
					src="images/payimages/billpay/bank_cib.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="GZRCC" /><img
					src="images/payimages/billpay/bank_gzrcc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="SHRCC" /><img
					src="images/payimages/billpay/bank_shrcc.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CPSRB" /><img
					src="images/payimages/billpay/bank_post.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CEB" /><img
					src="images/payimages/billpay/bank_ceb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="BOB" /><img
					src="images/payimages/billpay/bank_bob.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="CBHB" /><img
					src="images/payimages/billpay/bank_cbhb.gif"></li>
                   <li class="f"><input onclick="showborder('divbillpaybank',this);" name="billbank" type="radio" value="BJRCB" /><img
					src="images/payimages/billpay/bank_bjrcb.gif"></li>
                   <div class="c"></div>
                   </ul>
                </div>
                <div class="nohave">&nbsp;</div>
                <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您选择的银行卡已开通了网上支付功能，否则将无法支付成功。</div>
                <div class="nohave">&nbsp;</div>
                <div class="paybnt"><input type="button" onclick="submitform('10',2);" class="bnt_pay" value="" /> </div>
             </div>
           <!--快钱网上银行-->
           
           
   
     </div>
     </div>
     </form>
     <!--在线支付公用样式-->
     <div id="divpay"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
</div>
</body>
</html>
