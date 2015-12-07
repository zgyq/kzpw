<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}订单支付</title>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/pay.css" rel="stylesheet" type="text/css" />
<!-- 支付接口操作开始
paytype==1:支付宝
paytype==2:快钱
paytype==3：财付通
 --> 
 <style>
 .bnt_tips{ border: 1px solid #ccc; height: 22px; line-height:22px; width:60px; padding:0 5px 0 5px; text-align: center;}
 </style>
 <script>
 //立即支付
 function submitform(paymethod,paytype){
//alert(paymethod+"-"+paytype);
    if("vmoney"==paymethod){
        <ww:if test="#session.loginuser!=null">
          <ww:if test="#request.ordermap.vmpayenable">
           if(confirm("确定使用虚拟账户支付当前订单？")){
	          $("#form1").removeAttr("target");
	          $("vmoneybtn").attr("disabled","disabled");
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
     }else if("yibipay"==paymethod){
     	 var url='http://vip.zgyce.com/vip/kypwe.asp?sid=1&pid=2&uc=1&order=<ww:property value="#request.ordermap.orderid"/>&gwpay=<ww:property value="formatMoney_B2BBack(#request.ordermap.orderprice)"/>';
     
     		window.open(url);
     }else{
      setPaymethod(paymethod);
      //支付宝1,  若为块钱2请随机应变
       var url='http://127.0.0.1:8080/interface/Alipayfen?';
      //var url='http://www.zyfx888.com.cn:8080/interface/Alipayfen?';
      //var url='http://121.199.35.38/interface/Alipayfen?';
      var info="";
      if(paytype==1){//支付宝支付
      	url='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Alipayfen?'
        info='helpername=<ww:property value="#request.ordermap.billname"/>&orderid=<ww:property value="#request.ordermap.orderid"/>';
        }
      if(paytype==2){//快钱支付
       url='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Billpay?'
       info='helpername=<ww:property value="#request.ordermap.billname"/>&orderid=<ww:property value="#request.ordermap.orderid"/>&ordertype=1';
       }
       if(paytype==3){//财付通支付
       url='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Tenpayfen?'
       info='helpername=<ww:property value="#request.ordermap.billname"/>&orderid=<ww:property value="#request.ordermap.orderid"/>&ordertype=1';
       }
       
      // alert(paymethod);
       //alert(url+info);
       
       var paymethod=document.getElementById("paymethod").value;
       var pay_bank=document.getElementById("pay_bank").value;
       //alert(paymethod+","+pay_bank);
       //return;
       document.form1.action=url+info+"&paymethod="+paymethod+"&pay_bank="+pay_bank;
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
       htmstr+="<tr><td colspan='6' height='80px'><input onclick='closedialog()' class='bnt_tips' type=button value='重新选择'/> ";
       htmstr+="<input onclick='goNext()' class='bnt_tips' type=button value='下一步'/></td></tr></table></td></tr></table>";
        $("#divpay").html(htmstr);           
		           
}
//支付成功跳转
function goNext(){
window.location.href='<ww:property value="#request.payresulturl"/>';
}

function closedialog(){  
   $("#divpay").dialog("close");
 } 
  
  //选项卡切换
function changepaytable(obj,id){
  	$(".two").removeClass("payon_left");
  	$(".cold").removeClass("payon_right");
  	$(".two").addClass("payout_left");
  	$(".cold").addClass("payout_right");
  	$(obj).children(".two").addClass("payon_left");
  	$(obj).children(".cold").addClass("payon_right");
  	$(".c").children(".boxnei").hide();
  	$("#"+id).show();
 }

 function setPaymethod(paymethod){
  	document.getElementById("paymethod").value=paymethod;
  }
  function setPay_bank(pay_bank){
  //alert(pay_bank+","+pay_bank);
  	document.getElementById("pay_bank").value=pay_bank;
  }
function setBillpaymethod(paymethod) {
  	document.getElementById("Billpaymethod").value=paymethod;
}
//银行选择
function checkrdio(obj){

 $(obj).children("input").attr("checked","checked");
 $(".f").removeAttr("style");
 $(obj).attr("style","border: 1px solid #008aff;");
}

function topay(){

 document.form1.action="../ticket_inter/Jinripay?orderid=<ww:property value="#request.ordermap.orderid"/>";
 document.form1.submit();
}
</script>
</head>

<body>
  <!--在线支付公用样式-->
  <form action="" target="_blank" id="form1" name="form1" method="post">
  <input type="hidden" name="paymethod" id="paymethod" value="directPay" />
  <input type="hidden" name="" id="pay_bank" value="ICBCB2C" />
     <div id="pay">
         <div class="font-000 mornybj"><span class="ico_morny">&nbsp;</span>请选择订单支付方式进行订单支付</div>
         <div class="pay">
            <ul>
          <a href="javascript:void(0)" onclick="changepaytable(this,'alipay')">
            <li class="f payout_left two" id="alipay_div">
            支付宝支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
          
           <a href="javascript:void(0)" onclick="changepaytable(this,'alipaywy');setPay_bank('ICBCB2C');">
            <li class="f payout_left two" style="width: 120px;text-align: center" >
            网银支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
           <a href="javascript:void(0)" onclick="changepaytable(this,'tenpay')">
            <li class="f payout_left two">
            财付通支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
           <a href="javascript:void(0)" onclick="changepaytable(this,'tenpaywy');setPay_bank('ICBC');">
            <li class="f payout_left two">
            大额信用卡支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
          
         <a href="javascript:void(0)" onclick="changepaytable(this,'yibipay');">
            <li class="f payout_left two">
            一币支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
          
          
           <a href="javascript:void(0)" onclick="changepaytable(this,'vmoney')">
            <li class="f payout_left two">
            <span class="f">&nbsp;</span>虚拟账户支付</li>
            <li class="f payout_right cold">&nbsp;</li>
           </a>
           
           
          <!--
           <a href="javascript:void(0)" onclick="changepaytable(this,'bill')">
            <li class="f payout_left two">
            快钱支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
          
           <a href="javascript:void(0)" onclick="changepaytable(this,'billwy')">
            <li class="f payout_left two">
            快钱网银支付</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
          
          <a href="javascript:void(0)" onclick="changepaytable(this,'ortherpay')">
            <li class="f payout_left two">
            支付供应商</li>
            <li class="f payout_right cold">&nbsp;</li>
          </a>
            -->
            <ww:if test="#application.vmoneyservice!=null">
			   <ww:if test="#request.vmoneyrecharge==null">
          <a href="javascript:void(0)" onclick="changepaytable(this,'vmoney')">
            <li class="f payout_left two">
            <span class="f">&nbsp;</span>虚拟账户支付</li>
            <li class="f payout_right cold">&nbsp;</li>
           </a>
           </ww:if>
           </ww:if>
            </ul>
         </div>
         <div class="box c">
         
          <!--支付宝-->
              <div class="boxnei" id='alipay'>
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/>
                   </font>元</li>
                   <li>支付宝注册：如果您还没有支付宝账号，<a href="https://lab.alipay.com/user/reg/index.htm" target="_blank" class="font-33baea">马上注册支付宝账号</a>。</li>
                   <!--  <li><span class="ico_zhifubao f">&nbsp;</span>您正在使用支付宝担保交易：付款后资金暂由支付宝保管。</li>-->
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您已经注册并拥有支付宝账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input type="button"  onclick='submitform("directPay",1)' class="bnt_pay" value="" /> </div>
             </div>
           <!--支付宝--> 
           
         <!--zhifubao网上银行-->
             <div class="boxnei" id="alipaywy" style="display: none">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/></font>元</li>
                   <li>选择网上银行：<a href="#" class="font-33baea mr15" >如何开通网上银行？</a><a target="_blank" href="http://help.alipay.com/support/index_sh.htm" class="font-33baea" >超过银行支付限额了怎么办？</a></li>
                   </ul>  
                <div class="allyinhang" >
                   <ul>
                   <li class="f" style="border: 1px solid #008aff;" onclick="checkrdio(this)">
                   <input  name="pay_bank" type="radio" onclick="setPay_bank(this.value);"checked="checked" value="ICBCB2C"  /></li>
                   <li onclick="checkrdio(this)" class="f" ><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CMB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="BOCB2C" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="ABC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="COMM" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="SPDB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="GDB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CITIC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CEBBANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CIB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="SDB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CMBC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="HZCBB2C" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="SHBANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="NBBANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="SPABANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="BJRCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="ICBCBTB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="CCBBTB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="SPDBB2B" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank" type="radio" onclick="setPay_bank(this.value);"value="ABCBTB" /></li>
                   <div class="c"></div>
                   </ul>
                </div>
                <div class="nohave">&nbsp;</div>
                <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您选择的银行卡已开通了网上支付功能，否则将无法支付成功。</div>
                <div class="nohave">&nbsp;</div>
                <div class="paybnt"><input type="button" class="bnt_pay" onclick="submitform('bankPay',1)" value="" /> </div>
             </div>
           <!--网上银行-->
           
             <!--财付通-->
              <div class="boxnei" id='tenpay' style="display: none">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/>
                   </font>元</li>
                   <li>财付通注册：如果您还没有财付通账号，<a href="https://www.tenpay.com" target="_blank" class="font-33baea">马上注册财付通账号</a>。</li>
                   <!--  <li><span class="ico_zhifubao f">&nbsp;</span>您正在使用支付宝担保交易：付款后资金暂由支付宝保管。</li>-->
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您已经注册并拥有财付通账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input type="button"  onclick='submitform("directPay",3)' class="bnt_pay" value="" /> </div>
             </div>
           <!--财付通--> 
           <!--财付通网上银行-->
             <div class="boxnei" id="tenpaywy" style="display: none">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/></font>元</li>
                   </ul>  
                <div class="allyinhang" >
                   <ul>
                   <li class="f" style="border: 1px solid #008aff;" onclick="checkrdio(this)">
                   <input  name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"checked="checked" value="ICBC"  /></li>
                   <li onclick="checkrdio(this)" class="f" ><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CMB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="BOC" /></li>
               
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="ABC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="COMM" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="SPDB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="GDB" /></li>
                   
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CITIC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CEB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CIB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="SDB" /></li>
                   
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CMBC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="HZCBB2C" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="SHBANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="NBBANK" /></li>
                   
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="SPABANK" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="BJRCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="ICBCB2B" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="CCBB2B" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="SPDBB2B" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="pay_bank_ten" type="radio" onclick="setPay_bank(this.value);"value="ABCBTB" /></li>
                   <div class="c"></div>
                   </ul>
                </div>
                <div class="nohave">&nbsp;</div>
                <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您选择的银行卡已开通了网上支付功能，否则将无法支付成功。</div>
                <div class="nohave">&nbsp;</div>
                <div class="paybnt"><input type="button" class="bnt_pay" onclick="submitform('bankPay',3)" value="" /> </div>
             </div>
           <!--财付通网上银行-->
           
              
           <!--第三方支付 -->
              <div class="boxnei" id='ortherpay' style="display: none" >
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000">
                   <ww:property value="#request.ordermap.orderprice"/></font>元</li>
                    
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您拥有网银账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt">
                <input type="button" onclick="topay();" class="bnt_pay" value="" /> 
               </div>
             </div>
           <!--第三方--> 
           <!-- 块钱 -->
            <div class="boxnei" id='bill' style="display:none;" >
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000">
                   <ww:property value="#request.ordermap.orderprice"/></font>元</li>
                   <li>快钱注册：如果您还没有快钱账号，<a target="_blank" href="https://www.99bill.com/website/signup/websignup.htm" class="font-33baea">马上注册快钱账号</a>。</li>
                   <li><span class="ico_kuaiqian f">&nbsp;</span>您正在使用快钱担保交易：付款后资金暂由快钱保管。</li>
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您拥有网银账号，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input type="button" onclick="submitform('directPay',2);" class="bnt_pay" value="" /> </div>
             </div>
           
              <!--快钱网上银行-->
             <div class="boxnei" id="billwy" style="display:none;">
                   <ul>
                   <li class="oneli">应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/></font>元</li>
                   <li>选择网上银行：<a href="#" class="font-33baea mr15" >如何开通网上银行？</a><a target="_blank" href="http://help.alipay.com/support/index_sh.htm" class="font-33baea" >超过银行支付限额了怎么办？</a></li>
                   </ul>  
                <div class="allyinhang_kq" >
                   <ul>
                   <li class="f" style="border: 1px solid #008aff; cursor: pointer;" onclick="checkrdio(this)">
                   <input  name="billbank" type="radio" onclick="setPay_bank(this.value);"checked="checked" value="ICBC" /></li>
                   <li onclick="checkrdio(this)" class="f" ><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CMB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="ABC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CIB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="SDB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="BOC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CBHB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="BCOM" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CITIC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="GZCB" /></li>
                   <!-- nanjing --><li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="NJCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CMBC" /></li>
                 <!-- SRCB -->  <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="SRCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="UPOP" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="HXB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CPSRB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="BOB" /></li>
                 <!--HUISHANG  --> <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="HSB" /></li>
               <!-- PINGAN -->    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="PAB" /></li>
              <!-- youzhengchuxu -->    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="PSBC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="BEA" /></li>
                    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="SHBANK" /></li>
              <!-- GNS -->    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="GZRCC" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="SPDB" /></li>
                    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CEB" /></li>
                   <!-- zheshang --><li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="CZB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="GDB" /></li>
                    <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="HZB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="BJRCB" /></li>
                   <li onclick="checkrdio(this)" class="f"><input name="billbank" type="radio" onclick="setPay_bank(this.value);"value="NBCB" /></li>
                    <div class="c"></div>
                   </ul>
                </div>
                <div class="nohave">&nbsp;</div>
                <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您选择的银行卡已开通了网上支付功能，否则将无法支付成功。</div>
                <div class="nohave">&nbsp;</div>
                <div class="paybnt"><input type="button" class="bnt_pay" onclick="submitform('bankPay',2);" value="" /> </div>
             </div>
           <!--网上银行-->
           
            <!--虚拟账户-->
              <div class="boxnei" id='vmoney' style="display:none">
                   <ul>
                   <li class="oneli">账户余额：<font class="font-db0000"><ww:property value="#request.ordermap.vmoney"/></font>&nbsp;&nbsp;应付总价：<font class="font-db0000"><ww:property value="#request.ordermap.orderprice"/></font>元</li>
                  <li>温馨提示：如果您的余额不足订单支付，请联系客服人员。</li>
                   <li><span class="pay_caifutong f">&nbsp;</span>虚拟账户是由本平台推出的一项安全，快捷的支付通道。</li>
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您的虚拟账户余额大于应付金额，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input id='vmoneybtn' type="button" class="bnt_pay" onclick="submitform('vmoney',4)" value="" /> </div>
             </div>
              <!--一币支付-->
              <div class="boxnei" id='yibipay' style="display:none">
                   <ul>
                   
                   <li class="oneli">&nbsp;&nbsp;应付总价：<font class="font-db0000"><ww:property value="formatMoney_B2BBack(#request.ordermap.orderprice)"/></font>元<img src="images/yibi_logo.gif"/></li>
                  <li>温馨提示：如果您的余额不足订单支付，请联系客服人员。</li>
                   <li><span class="pay_caifutong f">&nbsp;</span>一币支付户是由本平台推出的一项安全，快捷的支付通道。</li>
                   
                   </ul>  
               <div class="nohave">&nbsp;</div>
               <div class="tips c"><span class="ico_paytips f">&nbsp;</span>请确保您的一币账户余额大于应付金额，否则将无法支付成功。</div>
               <div class="nohave">&nbsp;</div>
               <div class="paybnt"><input id='yibipaybtn' type="button" class="bnt_pay" onclick="submitform('yibipay',4)" value="" /> </div>
             </div>
             
           <!--财付通--> 
       
   
     </div>
     </form>
     <!--在线支付公用样式-->
     <div id="divpay"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
</div>
</body>
</html>
<script type="text/javascript">
document.getElementById("alipay_div").click();

</script>