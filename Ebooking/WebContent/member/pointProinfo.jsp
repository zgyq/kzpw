<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-积分商城</title>

<ww:head name="point" jsURL="memberpoint" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
   <jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
   <div class="right mt10 r">
       <div class="box">
        <div class="tit">
               <font class="black low2 f mr15">积分商城</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
               <td align="right" width="20%"><img src="<ww:property value="gift.picsrc"/>" width="140" height="140" class="m10 ad_box" /></td>              
               <td class="hl24">
               <form action="#" >
               <div class="mf31">
                 <ul>
                 <li><ww:property value="gift.name"/></li>
                 <li>物品编号：<ww:property value="gift.giftcode"/></li>
                 <li>所需积分：<font class="f90c"><ww:property value="gift.useintegral"/>分</font></li>
                 <li>剩余数量：21个</li>
                 <li><input type="button" class="button_first fff mr25" value="立即兑换" onclick="toPointOrder(<ww:property value="gift.id"/>);" />已有<font class="f90c">4 位</font>${compname}用户兑换该物品</li>
                 <input type="hidden" id="hidinput" value="" />
                 
                 
                 </ul>
               </div>  
               </form>
              </td>
              </tr>
            </table>
            <!--listsearch over-->
            <div>&nbsp;</div>
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
              <td class="guilder"><font class="pf20">商品描述</font></td>
              </tr>
              <td class="ptd5">
              
              <div class="description"><ww:property value="gift.giftdesc"/></div>
              <!--
              <div class="description">2.兑换本奖励后我们的客服会在三个工作日内为您的手机充值。（遇法定节假日和双休日顺延）</div>
              -->
              </td>
            </table>
            <div>&nbsp;</div>
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
              <td class="guilder"><font class="pf20">兑换流程指南</font></td>
              </tr>
              <td class="ptd5">
              <div class="description">
              <div><b>物品寄送方式：</b>Q币/手机话费充值在审核通过后会直接充入您的QQ账号/手机号（QQ账号/手机号为通过后自主填写），其余虚拟物品采用在线发送卡密的方式；实物物品全部采用快递方式。<br/>

<p><b>物品兑换流程：</b></p>
<p>1、物品价格已经包含邮寄费用在内，您无须另行支付。兑换前请确认您的帐户中有足够积分！</p>
<p>2、在您要兑换的物品页面点击"立即兑换"按钮，提交您的兑换申请！</p>
<p>3、确认您的物品邮寄地址，联系电话正确无误后提交兑换申请 ！</p>
<p>4、实物物品将在您的兑换确认后的15工作日内发出(您可与客服联系了解物品发放状态)！</p>
<p>5、兑换中心所有实物物品颜色均为随机发送, 敬请谅解！</p>
<p>兑换过程中如有问题请与我们客服联系，联系方式如下：010-68176575</p>
<p>以上物品图片仅供参考,请您以收取的实物为准</p></div>
  

             </td>
            </table>
            <div>&nbsp;</div>
        </div>
       </div> 
       
   </div>
</div>
<form name="form1" id="form1" action="point!toPointOrder.jspx" method="post">
<input type="hidden" id="" name="Giftid" value="<ww:property value="gift.id"/>" />
</form>
<ww:include page="../footer.jsp" />     
</body>
</html>
<script>
function toPointOrder(id){
var giftUseintegral=<ww:property value="gift.useintegral"/>;
SeacUserUseintegral();
var UserUseintegral=$("#hidinput").val();
//alert(UserUseintegral);
if(parseFloat(UserUseintegral)>=parseFloat(giftUseintegral)){
//window.location.href="point!toPointOrder.jspx?Giftid="+id;
document.form1.submit();
}else{
alert("你的积分不够兑换");
return;
}
}
function SeacUserUseintegral(){
 $.ajax({
       type:"POST",
      url:"point!SeacUserUseintegral.jspx",
       async:false,     
       success:function(data)
       {    
        if(data){
		$("#hidinput").val(data);	    
        }else{//查询失败
        }
       }   
  });
}


</script>