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

<style type="text/css">
 #mask{         
 position:absolute;         
 z-index:888;         
 background-color:#b5b4b4;         
 display:none;         
 top:0;         
 left:0;         
 filter:Alpha(opacity=50);/*此處用於IE不透明度為半透明百分比*/         
 -moz-opacity:0.5; /*此處用於舊版火狐不透明數*/         
 opacity:0.5;/*此處用於新版火狐不透明數值*/     
 }  
</style>


<script language="javascript"> 
	
	
 	function dianji(id){
 			var mask = document.getElementById("mask"); 
			var view = document.getElementById("message"+id);
			/*計算出當前頁面的大小*/         
 			var h_c =document.documentElement.scrollHeight;         
 			var w_c = document.documentElement.scrollWidth;
 			var h_b = document.body.scrollHeight;         
 			var w_b = document.body.scrollWidth ;                 
 			var height = h_c > h_b ? h_c : h_b;         
 			var width = w_c > w_b ? w_c : w_b; 
 			var divW= width*0.5;
 			                          
 			/*顯示遮蓋層*/         
 			mask.style.width = width+"px";        
			mask.style.height = height+"px";             
 			mask.style.display = "block";                 
 			/*顯示視圖層*/                  
 			   
 			view.style.display="block"; 
 	} 
 	function guanbi(id){
		document.getElementById("message"+id).style.display = "none";
		document.getElementById("mask").style.display = "none";             
 	}  

 	
 	
 	
	

  
</script> 


</head>
<body>
<form name="form1" id='form1' method="post" action="train!trainorder.action">
<input type="hidden" name="s_orderstatus" value="<ww:property value="s_orderstatus"/>"  />
			
<div id="wrap">
<div class="right">


<!--全屏覆蓋層-->   
 <div id="mask"></div> 

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
                                 <td>出发-到达</td>
                                 <td>支付金额</td>
                                 <td>下单日期</td>
                                 <td>支付方式</td>
                                 <td>订单状态</td>
                                 <td>支付状态</td>
                                 <td>操作</td>
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
                                    
                              <td>
                                <a href="#" class="btns" onclick="dianji(id='<ww:property value='#t.count'/>');" >立即出票</a>
                                <a href='train!toedit.action?id=<ww:property value="id"/>' class="btns" >修改订单</a>
                                 <!--浮动框开始-->
                                <div class="message" id="message<ww:property value='#t.count'/>" style="display: none;">
                                    <h2>信息核对</h2>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                         <tr>
                                            <td colspan="5">车票信息</td>
                                         </tr>
                                         <tr>
                                            <td><b><ww:property value="startdate" /></b></td>
                                            <td><b><ww:property value="traincode" />次</b></td>
                                            <td colspan="3"><b><ww:property value="startcity" />&nbsp;<ww:property value="starttime" />—<ww:property value="endcity" /></b></td>
                                         </tr>
                                     </table>
                                     
                                     <table cellspacing="0" cellpadding="1" align="center" style="width:100%" class="me-info">
                                              <tr>
                                            <td colspan="6">乘客信息</td>
                                         </tr>
                                         <tr>
                                              <td>席别</td>
                                              <td>票种</td>
                                              <td>姓名</td>
                                              <td>证件类型</td>
                                              <td>证件号码</td>
                                              <td>手机号</td>
                                         </tr>
                                           <tr>
                                              <td><ww:property value="GetXiBieTypeByCode(train.seattype)"/></td>
                                              <td>成人</td>
                                              <td><ww:property value="name"/></td>
                                              <td>二代身份证</td>
                                              <td><ww:property value="idnumber" /></td>
                                              <td>18311103104</td>
                                         </tr>
                                     </table>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                         <tr>
                                            <td class="save-tit">订单编号:</td>
                                            <td class="save-con"><input type="text" /></td>
                                            <td class="save-tit">坐席号:</td>
                                            <td class="save-con"><input type="text" /></td>
                                         </tr>
                                         <tr>
                                             <td class="save-tit">订单备注:</td>
                                             <td class="save-con"><textarea></textarea></td>
                                         </tr>
                                     </table>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save-btn">
                                         <tr>
                                           <td style="text-align:right"><a href="#" class="save-btn">保存并出票</a></td>
                                           <td style="text-align:left"><a href="#" class="can-btn" onclick="guanbi(id='<ww:property value='#t.count'/>');">取消</a></td>
                                         </tr>
                                     </table>
                                </div>
                                
                                <!--浮动框结束-->
                             </td> 
                             
                             
                            
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
