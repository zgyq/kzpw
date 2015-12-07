<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_tulue/css/order-deta-info.css" rel="stylesheet" type="text/css" />
<link href="main_tulue/css/right.css" rel="stylesheet" type="text/css" />
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="wrap">

<!-- 车票基本信息修改页面 begin-->

   <div class="order-deta-info">
       <h1>火车票订单修改</h1>
       <div class="order-basic-info">
             <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>订单基本信息</h2>
      
              <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                       
                        <tr>
                            <td class="title">订单号</td>
                            <td class="cont"><ww:property value="train.ordernumber"/></td>
                            <td class="title">关联订单号</td>
                            <td class="cont">&nbsp;</td>
                            <td class="title">支付方式</td>
                            <td class="cont">支付宝</td>
                            <td class="title">支付状态</td>
                            <td class="cont"><select name="paystatus">
                            					<option value="1" <ww:if test="train.paystatus==1">selected</ww:if>>未支付</option>
                            					<option value="2" <ww:if test="train.paystatus==2">selected</ww:if>>已支付</option>
                            				</select>
                            </td>
                        </tr>
                        <tr>
                             <td class="title">创建日期</td>
                             <td class="cont"><ww:property value="formatTimestamp(train.createtime)" /></td>
                             <td class="title">出票时间</td>
                             <td class="cont"><ww:property value="formatTimestamp(train.createtime)" /></td>
                             <td class="title">订单状态</td>
                             <td class="cont orange"><select name="orderstatus">
                            							<option value="-1" <ww:if test="train.orderstatus==-1">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( -1)" /></option>
                            							<option value="0" <ww:if test="train.orderstatus==0">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 0)" /></option>
                            							<option value="1" <ww:if test="train.orderstatus==1">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 1)" /></option>
                            							<option value="2" <ww:if test="train.orderstatus==2">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 2)" /></option>
                            							<option value="3" <ww:if test="train.orderstatus==3">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 3)" /></option>
                            							<option value="4" <ww:if test="train.orderstatus==4">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 4)" /></option>
                            							<option value="5" <ww:if test="train.orderstatus==5">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 5)" /></option>
                            							<option value="6" <ww:if test="train.orderstatus==6">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 6)" /></option>
                            							<option value="7" <ww:if test="train.orderstatus==7">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 7)" /></option>
                            							<option value="8" <ww:if test="train.orderstatus==8">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 8)" /></option>
                            							<option value="9" <ww:if test="train.orderstatus==9">selected</ww:if>><ww:property value="GetTrainOrderStausByCode( 9)" /></option>
                            						</select>
                             
                             
                             
                             
                             </td>
                             <td class="title">采购商电话</td>
                             <td class="cont"><ww:property value="GetAgentTel(train.agentid)" /></td>
                        </tr>
                        
                        <tr>
                       		<td class="title">联系人</td>
                            <td class="cont"><ww:property value="train.contactname" /></td>
                            <td class="title">联系电话</td>
                            <td class="cont"><ww:property value="train.contactmobile" /></td>
                            <td class="title">采购商名称</td>
                            <td class="cont"><ww:property value="getangname(train.agentid)" /></td>
                            <td class="title">预订人</td>
                            <td class="cont"><ww:property value="getusername(train.createuid)" /></td>
                            
                        </tr>
                        
                        <tr>
                            <td class="title">订单备注</td>
                            <td colspan="7"><textarea style="width:60%;"></textarea></td>
                        </tr>
                     
                     
                     </table>
                    
       </div>

<!-- 车票基本信息 end-->

<!-- 列车信息 begin-->
        <div class="train-info">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>列车信息</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>
                   <td class="title">车次</td>
                   <td class="title">出发站</td>
                   <td class="title">到达站</td>
                   <td class="title">出发日期</td>
                   <td class="title">开车时间</td>
                   <td class="title">席别</td>
                   <td class="title">票面价</td>
                </tr>
                
                 <tr>
                   <td class="cont"><input type="text" name="traincode" value="<ww:property value="train.traincode" />" /></td>
                   <td class="cont"><input type="text" name="startcity" value="<ww:property value="train.startcity" />" /></td>
                   <td class="cont"><input type="text" name=" endcity" value="<ww:property value="train.endcity" />" /></td>
                   <td class="cont"><input type="text" name="startdate" value="<ww:property value="train.startdate"/>"  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"    class="Wdate" /></td>
                   <td class="cont"><input type="text" name=" starttime" value="<ww:property value="train.starttime" />" /></td>
                   <td class="cont"><select name="seattype">
                            			<option value="0" <ww:if test="train.seattype==0">selected</ww:if>><ww:property value="GetXiBieTypeByCode(0)"/></option>
                            			<option value="1" <ww:if test="train.seattype==1">selected</ww:if>><ww:property value="GetXiBieTypeByCode(1)"/></option>
                            			<option value="2" <ww:if test="train.seattype==2">selected</ww:if>><ww:property value="GetXiBieTypeByCode(2)"/></option>
                            			<option value="3" <ww:if test="train.seattype==3">selected</ww:if>><ww:property value="GetXiBieTypeByCode(3)"/></option>
                            			<option value="4" <ww:if test="train.seattype==4">selected</ww:if>><ww:property value="GetXiBieTypeByCode(4)"/></option>
                            			<option value="5" <ww:if test="train.seattype==5">selected</ww:if>><ww:property value="GetXiBieTypeByCode(5)"/></option>
                            			<option value="6" <ww:if test="train.seattype==6">selected</ww:if>><ww:property value="GetXiBieTypeByCode(6)"/></option>
                            			<option value="7" <ww:if test="train.seattype==7">selected</ww:if>><ww:property value="GetXiBieTypeByCode(7)"/></option>
                            			<option value="8" <ww:if test="train.seattype==8">selected</ww:if>><ww:property value="GetXiBieTypeByCode(8)"/></option>
                            			<option value="9" <ww:if test="train.seattype==9">selected</ww:if>><ww:property value="GetXiBieTypeByCode(9)"/></option>
                            		</select>
                   </td>
                   <td class="cont"><input type="text" name="allbxprice" value="￥<ww:property value="allbxprice/trainpassengerlist.size()" />" /></td>
                </tr>
             </table>
       </div>
       
<!-- 列车信息 end--> 

<!-- 乘机人信息 begin-->  
        <div class="passenger-info">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>乘车人信息</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>
                   <td class="title">乘客类型</td>
                   <td class="title">乘客姓名</td>
                   <td class="title">状态</td>
                   <td class="title">证件类型</td>
                   <td class="title">证件号码</td>
                   <td class="title">票面价</td>
                   <td class="title">保险</td>
                </tr>
    
                <ww:iterator value="trainpassengerlist">
                 <tr>
                   <td class="cont">成人</td>
                   <td class="cont"><input type="text" name="name" value="<ww:property value="name"/>" /></td>
                   <td class="cont"><input type="text" name="state" value="<ww:property value="state"/>" /></td>
                   <td class="cont"><input type="text" name="" value="身份证" /></td>
                   <td class="cont"><input type="text" name="idnumber" value="<ww:property value="idnumber" />" /></td>
                   <td class="cont"><input type="text" name="price" value="￥<ww:property value="price" />" /></td>
                   <td class="cont"><input type="text" name="bxprice" value="￥<ww:property value="bxprice" />" /></td>
                </tr>
                </ww:iterator>
             </table>
       </div>      
<!-- 乘机人信息 begin-->   

<!-- 票款信息 begin-->  
        <div class="fare-info">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>票款信息</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>   
                   <td class="title">总票面价</td>
                   <td class="title">邮寄费</td>
                   <td class="title">手续费</td>
                   <td class="title">总保险费</td>
                   <td class="title">最终应付</td>
                </tr>
                
                 <tr>
                   <td class="cont"><input type="text" name="totalprice" value="￥<ww:property value="train.totalprice"/>" /></td>
                   <ww:if test="train.qptype==2">
                      <td class="cont"><input type="text" name="psprice"  value="￥<ww:property value="train.psprice-5"/>" /></td>
                   <td class="cont"><input type="text" name=""  value="￥5" /></td>
                   </ww:if><ww:else>
                   <td class="cont"><input type="text" name=""  value="￥0" /></td>
                   <td class="cont"><input type="text" name=""  value="￥0" /></td>
                   </ww:else>
                
                   <td class="cont"><input type="text" name="allbxprice"  value="￥<ww:property value="allbxprice"/>" /></td>
                   <td class="cont"><input type="text" name="trainPrice"  value="￥<ww:property value="GetTrainPrice(id)"/>" /></td>
             </table>
       </div>      
<!-- 票款信息 begin-->  
<ww:if test="train.qptype==2">
		<div class="order-record">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>配送信息</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>
               	 	<td class="title" width="20%">收件人</td>
                	<td class="title" width="20%">电话</td>   
                   <td class="title" width="20%">邮编</td>
                   <td class="title" width="80%">配送地址</td>
                  
                </tr>
                
                 <tr>
                 <td class="cont"><input type="text" name="contactname" value="<ww:property value="train.contactname" />" /></td>
                 <td class="cont"><input type="text" name="contactmobile" value="<ww:property value="train.contactmobile" />" /></td>
                 <td class="cont"><input type="text" name="post" value="<ww:property value="train.post" />" /></td>
                 <td class="cont"><input type="text" name="deliveryaddl" value="<ww:property value="train.deliveryadd" />" /></td>
                  
             </table>
       </div>      
</ww:if>
<!-- 订单处理记录 begin-->  
        <div class="order-record" style="display: none;">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>订单处理记录</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>   
                   <td class="title">订单号</td>
                   <td class="title">操作人员</td>
                   <td class="title">操作时间</td>
                   <td class="title">状态</td>
                   <td class="title">备注</td>
                </tr>
                
                 <tr>
                   <td class="cont">A123455</td>
                   <td class="cont">陈海燕</td>
                   <td class="cont">2014-06-12 12:20:33</td>
                   <<td class="cont">已出票</td>
                   <td class="cont">陈海燕创建了订单</td>
             </table>
       </div>      
<!-- 订单处理记录 begin--> 

<!-- 短信记录 begin-->  
        <div class="message-record" style="display: none;">
           <h2><span><img src="main_tulue/img/h2-icon.gif"/></span>电话记录</h2> 
             <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                <tr>   
                   <td class="title">手机号码</td>
                   <td class="title">短信类型</td>
                   <td class="title">发送时间</td>
                   <td class="title">发送状态</td>
                   <td class="title">短信内容</td>
                   <td class="title">操作</td>
                </tr>
                
                 <tr>
                   <td class="cont">13556555666</td>
                   <td class="cont">出票短信</td>
                   <td class="cont">2014-06-12 12:20:33</td>
                   <td class="cont">已发送</td>
                   <td class="cont"><textarea style="font-size:12px; width:85%">马云先生，您预订的：深圳-北京，12:20开车的火车票,已出票,请核对!</textarea>
                   </td>
                   <td class="cont">再次发送</td>
             </table>
       </div>      
<!-- 短信记录 begin--> 
   
   
   
    
    
   </div>
   
       <div style='margin-top:40px;'>
    
    <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save-btn">
                                         <tr>
                                           <td style="text-align:right"><a href="#" class="save-btn">保存并出票</a></td>
                                           <td style="text-align:left"><a href="#" class="can-btn" onclick="guanbi(id='<ww:property value='#t.count'/>');">取消</a></td>
                                         </tr>
     </table>
    
    </div>       

</div>

</body>
</html>
