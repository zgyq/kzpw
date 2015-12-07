
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_tulue/css/pay-info.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrap">
         
          <div class="order-tit"><span><img src="main_tulue/img/h2-icon.gif"/></span>订单信息核对 &nbsp;&nbsp;&nbsp;<b><span style="color: red"><ww:property value="train.ordernumber"/></span></b>
          &nbsp;&nbsp;&nbsp;<b><span style="color: red"><ww:if test="train.qptype==1">自取</ww:if><ww:if test="train.qptype==2">配送</ww:if></span></b>
          &nbsp;&nbsp;&nbsp;<b><span style="color: red"><ww:if test="train.booktype==1">有票购买</ww:if><ww:if test="train.booktype==0">无票购买[无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!]</ww:if></span></b>
          </div>
          
         <div class="order-resu">
                  
                    <div class="order-resu-top">
                        <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                              <tr>
                                 <td>车次信息</td>
                                 <td>席位信息</td>
                                 <td>旅客信息</td>
                                 <ww:if test="train.qptype==2">
                                  <td>配送信息</td>
                                 </ww:if>
                                 <td>票款金额</td>
                                 <td>其他金额</td>
                                 <td>支付状态</td>
                              </tr>
                        </table>  
                   </div>  
                   <div class="order-resu-con">
                        <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                              <tr>
                                 <td> 
                                     <span><ww:property value="train.traincode"/></span>
                                     <span> <ww:property value="train.startcity"/>--<ww:property value="train.endcity"/></span>
                                     <span><ww:property value="train.startdate"/></span>
                                     <span><ww:property value="train.starttime"/>开</span>
                                 </td>
                                 <td>
                                     <span>&nbsp;</span>
                                     <span>&nbsp;</span>
                                     <span><ww:property value="GetXiBieTypeByCode(train.seattype)"/></span>
                                 </td>
                                 <td style="text-align: left">
                                 <ww:iterator value="trainpassengerlist">
                                 <span>姓名:<ww:property value="name"/>&nbsp;证件号码:<ww:property value="idnumber"/></span>
                                 </ww:iterator>
                                 </td>
                                  <ww:if test="train.qptype==2">
                                   <td>
                                    <span><ww:property value="train.deliveryadd"/></span>
                                    
                                 </td>
                                  </ww:if>
                                 
                                 <td>
                                    <span>成人票</span>
                                    <span class="orange"><ww:property value="train.totalprice"/>元</span>
                                 </td>
                                 <td>
                                    <span class="orange">保险金额<ww:property value="allbxprice"/>元</span>
                                     <ww:if test="train.qptype==2">
                                    <span class="orange">配送金额<ww:property value="train.psprice-5"/>元</span>
                                    <span class="orange">手续费5元</span>
                                    </ww:if><ww:else>
                                      <span class="orange">配送金额0元</span>
                                    <span class="orange">手续费0元</span>
                                    </ww:else>
                                 </td>
                                 
                                 <td>
                                    <span class="orange">
                                    <ww:if test="train.paystatus==1">未支付</ww:if>
                                    <ww:if test="train.paystatus==2">已支付</ww:if>
                                    </span> 
                                 </td>
                              </tr>
                        </table>  
                   
                   </div>  
  
         </div>
          <div class="tijiao">
          
                 <div class="pay-for">
                       <p>总张数:<span><ww:property value="trainpassengerlist.size()"/></span></p>
                       <p>待支付金额:<span><ww:property value="allprice"/>元</span></p>
                  </div>
      
                  <div class="submit">
                     <div class="cancle"><a href="#"><img src="main_tulue/img/cancle-btn.gif" width="91" height="34" /></a></div>
                     <ww:if test="train.paystatus==1">
                     <div class="refer"><a href="#" onclick="topay();"><img src="main_tulue/img/payfor-btn.gif" width="91" height="34" /></a></div>
                     </ww:if>
                    
                  </div>
          
          </div>

</div>
 <form action="train!toPay.action" target="_blank" id="form1" name="form1" method="get">
 <input type="hidden"  name="id" value="<ww:property value="train.id"/>" />
 </form>
</body>
</html>
<script>
function topay(){
//document.form1.action="train!toPay.action?id="+id;
 document.form1.submit();

}

</script>