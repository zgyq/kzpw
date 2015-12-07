<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_tulue/css/right.css" rel="stylesheet" type="text/css" />
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form name="form1" id='form1' method="post" action="train!trainorder.action">
<input type="hidden" name="s_orderstatus" value="<ww:property value="s_orderstatus"/>"  />
			
<div id="wrap">
<div class="right">
     <div class="box">
     
           <!--所有订单查询 begin-->
           
                <div class="search">
                    <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                        
                        <tr>
                             <td> 按车次查：<input type="text" name="s_code" value="<ww:property value="s_code"/>"  /></td>
                             
                             <td> 按订票日期查：<input type="text" id="cptime" name="startcreatetime" value="<ww:property value="startcreatetime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" />-<input type="text" id="cptime2" name="endcreatetime" value="<ww:property value="endcreatetime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" /></td>
                             <td> 按订单号查：<input type="text" name="s_ordercode" value="<ww:property value="s_ordercode"/>" /></td>
                             <td> 按乘客查：<input type="text" name="s_name" value="<ww:property value="s_name"/>" /></td>
                             <td> <a href="#" onclick="subform();" class="btn3"></a></td>
                        
                        </tr>
                        
                    </table>
                    
                 </div>
             
             <!--所有订单查询 end-->

              
             <!--所有订单查询结果 begin-->
                 <div class="order-resu">
                
                    <div class="order-resu-top">
                        <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                              <tr>
                                 <td>订单编号</td>
                                 <td>车次</td>
                                 <td>乘车人</td>
                                 <td>出发日期</td>
                                 <td>出发—到达</td>
                                 <td>支付金额</td>
                                 <td>下单日期</td>
                                 <td>支付方式</td>
                                 <td>订单状态</td>
                                 <td>支付状态</td>
                              </tr>
                        </table>  
                   </div>
                   
                   
                   <div class="order-resu-con">
                   
                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                     
                     
                      <ww:iterator value="trainlist" status="t">
                          <tr onmouseover="this.style.background='#f6f6f6'" onmouseout="this.style.background='#ffffff'">
                          
                              <td><a href='train!orderdetail.action?id=<ww:property value="id"/>'>
							<ww:property value="ordernumber" />
							</a>
							<span style="color: red">
							&nbsp;<ww:if test="qptype==1">自取</ww:if><ww:elseif test="qptype==2">配送</ww:elseif><ww:else>&nbsp;</ww:else>
							</span>
							</td>
                              <td><ww:property value="traincode" /></td>
                              <td><ww:property value="GetTrainPassName(id)" /></td>
                              <td><ww:property value="startdate" />&nbsp;<ww:property value="starttime" /></td>
                              <td><ww:property value="startcity" />—<ww:property value="endcity" /></td>
                              <td>￥<ww:property value="GetTrainPrice(id)"/></td>
                              <td><ww:property value="formatTimestamp(createtime)" /></td>
                              <td>支付宝</td>
                              <td><ww:property value="GetTrainOrderStausByCode(orderstatus)" /></td>
                              <td> <ww:if test="paystatus==1">未支付</ww:if>
                                    <ww:if test="paystatus==2">已支付</ww:if></td>
                          </tr>
                          
                        </ww:iterator>
                          
                          
                        
                          
                          
                     </table>
                   </div>
                   
                   
                   
                      
              
                  
                  
                    
                  
                 
                  

                </div>
                
                <!-- 翻页begin-->
                  
                <div class="next-page">
                <!--
                    <div class="gongji">共计1页</div>
                    <div class="shouye">首页</div>
                    <div class="p-page">上一页</div>
                    <div class="ones">1</div>
                    <div class="n-page">下一页</div>
                    <div class="l-page">末页</div>
                    <div class="fast">快速跳转<input type="text" value="" style="width:30px"/><a href="#"><img src="main_tulue/img/next-btn.gif" /></a></div>
                -->
                <ww:property
			value='getPagetwo(pageinfo,"pageinfo","train!trainorder.action","form1")' />
                </div>  
             
             <!-- 翻页end-->

              <!--所有订单查询结果 end-->

       </div>
</div>

</div>
</form>
</body>
</html>

<script>
function subform(){

 document.form1.submit();

}

</script>
