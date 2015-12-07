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

<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

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
 	
 	window.location.href="train!tochupiao.action?strOrderID="+id;
 	
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
 		function lijichupiao(id){
 		
 		
 		var mask = document.getElementById("mask"); 
			var view = document.getElementById("message");
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
 			
 			
 			
 			//读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		           url:"train!getPassengersqList.action",
		            data:{strOrderID:id},
		           //beforeSend:function(){$("#mask").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#mask").html(data);           
		            }            
		            });
 			
 			            
 			   
 			view.style.display="block"; 
 		
 		}
 	
 	 function peisong(id){
 	 	window.location.href="train!topeisong.action?strOrderID="+id;
 	 	
 	 }
 	function peisong2(id){
 			var mask = document.getElementById("mask"); 
			var view = document.getElementById("peisong"+id);
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
 		document.form1.action="train!trainorder.action";
		document.getElementById(id).style.display = "none";
		document.getElementById("mask").style.display = "none";             
 	}
 	function xiugai(){
		dispose("系统正在为跳转");               			   
		           
 	}  
 	function NoTicket(id){
 	
 	 if(confirm('您确定进行拒单操作吗？')){
	      window.location.href="train!edit_order.action?train.id="+id+"&s_orderstatus=5";
	   }
 	
		              			   
		           
 	} 
 	
 	
function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
 	
 	
 	
	

  
</script> 


</head>
<body>
<form name="form1" id='form1' method="post" action="train!trainorder.action">
<input type="hidden" name="s_orderstatus" value="<ww:property value="s_orderstatus"/>"  />
<input type="hidden" name="strOrderID" id="strOrderID" value=""  />

			
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
                             <td> 取票类型：<select name="s_qupiaotype"><option value="-1" <ww:if test="s_qupiaotype==-1">selected</ww:if> >全部</option><option value="1" <ww:if test="s_qupiaotype==1">selected</ww:if>>自取</option><option value="2" <ww:if test="s_qupiaotype==2">selected</ww:if>>配送</option> </select>  </td>
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
                                 <td width="10%">订单编号</td>
                                 <td width="10%">车次</td>
                                 <td width="10%">乘车人</td>
                                 <td width="10%">出发日期</td>
                                 <td width="10%">出发-到达</td>
                                 <td width="10%">支付金额</td>
                                 <td width="10%">下单日期</td>
                                 <!--
                                 <td>支付方式</td>
                                 -->
                                 <td width="10%">订单状态</td>
                                 <td width="10%">支付状态</td>
                                 <td width="10%">操作</td>
                              </tr>
                        </table>  
                   </div>
                   
                   
                   <div class="order-resu-con">
                   
                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                     
                     
                      <ww:iterator value="trainlist" status="t">
                          <tr onmouseover="this.style.background='#f6f6f6'" onmouseout="this.style.background='#ffffff'">
                          
                              <td><a href='train!orderdetail.action?id=<ww:property value="id"/>'>
							<span style="font-size: 18px;"><ww:property value="ordernumber" /></span>
							</a></br>
							<span style="color: red">
							&nbsp;<ww:if test="qptype==1">自取</ww:if><ww:elseif test="qptype==2">配送</ww:elseif><ww:else>&nbsp;</ww:else>
							</span></br>
							采:<a href="javascript:void(0);" onclick="shows(<ww:property value='id' />,<ww:property value='agentid' />);">
							<ww:property value="getagentname_b2bback(agentid)" />
							</a></br>
							出:
							<ww:if test="userid==null||userid=='-1'">暂无处理人</ww:if><ww:else>
							<ww:property value="getusername(userid)" />
							</ww:else>
							</br>
							<ww:if test="(getLoginsessionagent().agenttype==1||getLoginsessionagent().agenttype==2)&&getLoginUser().isadmin==1">
							改:<select onchange="UpdateUserid(this.value,<ww:property value="id" />)">
							
							<option value="-1" >更改出票员</option>
							<ww:iterator value="listuser">
							<option value="<ww:property value="id" />" ><ww:property value="membername" /></option>
							</ww:iterator>
							</select>
							</ww:if>
							
							<div style="display: none; position: absolute; width: 200px; left: -10px; background: #fefefe; padding-left: 20px; border: 2px solid #f48000; z-index: 999999" id="detail<ww:property value="id"/>"></div>
							</td>
                              <td style="font-size: 28px;color: red"><ww:property value="traincode" /></td>
                              <td style="font-size: 28px;color: red"><ww:property value="GetTrainPassName(id)" /></td>
                              <td style="font-size: 28px;color: red"><ww:property value="startdate" />&nbsp;<ww:property value="starttime" /></td>
                              <td style="font-size: 28px;color: red"><ww:property value="startcity" />—<ww:property value="endcity" /></td>
                              <td style="font-size: 28px;">￥<ww:property value="GetTrainPrice(id)"/></td>
                              <td><ww:property value="formatTimestamp(createtime)" /></td>
                              <!--
                              <td>支付宝</td>
                              -->
                              <td><ww:property value="GetTrainOrderStausByCode(orderstatus)" /></td>
                              <td> <ww:if test="paystatus==1">未支付</ww:if>
                                    <ww:if test="paystatus==2">已支付</ww:if></td>
                                    
                              <td>
                               <a href="#" class="btns" onclick="suodan(<ww:property value='id'/>);return false;" >锁单</a>
                               
                               <ww:if test="paystatus==1">
                               <a href="train!toorder.action?strOrderID=<ww:property value='id'/>" class="btns" >立即支付</a>
                               </ww:if>
                               
                              <a href="#" class="btns" onclick="dianji(<ww:property value='id'/>);return false;" >立即出票</a>
                              
                              	<ww:if test="getLoginsessionagent().agenttype==1||getLoginsessionagent().agenttype==2">
                              	<ww:if test="orderstatus==2">
                                <a href="#" class="btns" onclick="dianji(<ww:property value='id'/>);return false;" >立即出票</a>
                                 <a href="#" class="btns" style="color: red;" onclick="NoTicket('<ww:property value="id" />');return false;" >拒单退款</a>
                                </ww:if>
                                <a href='train!toedit.action?id=<ww:property value="id"/>' class="btns" onclick="xiugai();" >修改订单</a>
                                	<ww:if test="orderstatus==3">
                                <a href="#" class="btns" onclick="peisong(<ww:property value='id'/>);return false;" >立即配送</a>
                                 	</ww:if>
                              
                               
                                </ww:if>
                                	
                                	
                                 <!--浮动框开始-->
                                <div class="message" id="message<ww:property value='id'/>" style="display: none;">
                                    <h2>信息核对</h2>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                         <tr>
                                            <td colspan="5">车票信息</td>
                                         </tr>
                                         <tr>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="startdate" /></b></td>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="traincode" />次</b></td>
                                            <td colspan="3" style="font-size: 18px;color: red"><b><ww:property value="startcity" />&nbsp;<ww:property value="starttime" />—<ww:property value="endcity" /></b></td>
                                         </tr>
                                        
                                     </table>
                                     
                                     <table cellspacing="0" cellpadding="1" align="center" style="width:100%" class="me-info">
                                          <tr>
                                            <td colspan="6" >乘客信息</td>
                                         </tr>
                                         <tr>
                                              <td width="10%">席别</td>
                                              <td width="10%">票种</td>
                                              <td width="20%">姓名</td>
                                              <td width="20%">证件类型</td>
                                              <td width="40%">证件号码</td><!--
                                              <td>手机号</td>
                                         --></tr>
                                         
                                         <ww:iterator value="GetTrainPassList(id)">
                                           <tr>
                                              <td width="10%" style="font-size: 28px;color: red"><b><ww:property value="GetXiBieTypeByCode(seattype)"/></b></td>
                                              <td width="10%"><ww:if test="state==1">成人</ww:if><ww:if test="state==2">儿童</ww:if></td>
                                              <td width="20%" style="font-size: 28px;color: red"><b><ww:property value="name"/></b></td>
                                              <td width="20%"><ww:property value="getTypeToString(idtype)"/></td>
                                              <td width="40%" style="font-size: 18px;color: red"><b><ww:property value="idnumber" /></b></td>
                                              <!--
                                              <td>18311103104</td>
                                              -->
                                              <ww:set name="infos_price" value="price"/>
                                         </tr>
                                         </ww:iterator>
                                     </table>
                                     
                                     
                                     
                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                      <tr>
                                            <td colspan="5">其他信息</td>
                                         </tr>
                                         <tr>
                                            <td style="font-size: 18px;color: red"><b>备选席别:
                                            <ww:property value="(deliverytypeval)" />
                                            
                                            </b></td>
                                            <td style="font-size: 28px;color: red"><b>单人票价:<ww:property value="#infos_price" /></b></td>
                                            <td colspan="3" style="font-size: 28px;color: red"><b>总票价:<ww:property value="totalprice" /></b></td>
                                         </tr>
                                       </table>  
                                     
                                     <table cellspacing="0" cellpadding="1" align="center" style="width:100%" class="me-info">
                                          <tr>
                                            <td colspan="6" >出票信息</td>
                                         </tr>
                                         <tr>
                                             
                                             
                                              <td width="20%">姓名</td>
                                               <td width="10%">票种</td>
                                               <td width="10%">席别</td>
                                               <td width="20%">价格</td>
                                              </tr>
                                         
                                         <ww:iterator value="GetTrainPassList(id)" status="ind">
                                           <tr>
                                             
                                              
                                              <td width="20%" style="font-size: 28px;color: red"><b><ww:property value="name"/></b></td>
                                              <td width="10%"><ww:if test="state==1">成人</ww:if><ww:if test="state==2">儿童</ww:if></td>
                                               <td width="10%" style="font-size: 28px;color: red"><b>
                                               <select name='s_beixuanxibie_<ww:property value="id"/>' id="s_pass_xibie_<ww:property value="id"/>">
                                                <ww:property value="Getchupiaoxibie(deliverytypeval,GetXiBieTypeByCode(seattype))"/>
                                                </select>
                                                
                                               <ww:property value="GetXiBieTypeByCode(seattype)"/></b></td>
                                              <td width="20%"><input id="" name="s_chupiaoprice_<ww:property value="id"/>" value="<ww:property value="#infos_price" />" /></td>
                                             
                                              <ww:set name="infos_price" value="price"/>
                                         </tr>
                                         </ww:iterator>
                                     </table>
                                     
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                     <!--
                                         <tr>
                                            <td class="save-tit">订单编号:</td>
                                            <td class="save-con"><input type="text" /></td>
                                            <td class="save-tit">坐席号:</td>
                                            <td class="save-con"><input type="text" /></td>
                                         </tr>
                                          <tr>
                                            <td class="save-tit">出票席别:</td>
                                            <td class="save-con"><input type="text" /></td>
                                            <td class="save-tit">出票单价:</td>
                                            <td class="save-con"><input type="text" /></td>
                                         </tr>
                                         -->
                                         <tr>
                                             <td class="save-tit">订单备注:</td>
                                             <td class="save-con"><textarea id="beizhu_<ww:property value='id'/>" name="beizhu_<ww:property value='id'/>"></textarea></td>
                                         </tr>
                                     </table>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save-btn">
                                         <tr>
                                           <td style="text-align:right"><a href="#" onclick="SaveAndTicket(<ww:property value='id'/>);return false;" class="save-btn">保存并出票</a></td>
                                           <td style="text-align:left"><a href="#" class="can-btn" onclick="guanbi(id='message<ww:property value='id'/>');">取消</a></td>
                                         </tr>
                                     </table>
                                </div>
                                
                                <!--浮动框结束-->
                                <div class="message" id="peisong<ww:property value='id'/>" style="display: none;">
                                    <h2>信息核对</h2>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                         <tr>
                                            <td colspan="5">车票信息</td>
                                         </tr>
                                         <tr>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="startdate" /></b></td>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="traincode" />次</b></td>
                                            <td colspan="3" style="font-size: 18px;color: red"><b><ww:property value="startcity" />&nbsp;<ww:property value="starttime" />—<ww:property value="endcity" /></b></td>
                                         </tr>
                                        
                                     </table>
                                     
                                     
                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                      <tr>
                                            <td colspan="5">其他信息</td>
                                         </tr>
                                         <tr>
                                            <td style="font-size: 18px;color: red"><b>备选席别:<ww:property value="deliverytypeval" /></b></td>
                                            <td style="font-size: 28px;color: red"><b>单人票价:<ww:property value="#infos_price" /></b></td>
                                            <td colspan="3" style="font-size: 28px;color: red"><b>总票价:<ww:property value="totalprice" /></b></td>
                                         </tr>
                                       </table>  
                                     
                                     
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                         <tr>
                                            <td class="save-tit">快递单位:</td>
                                            <td class="save-con"><input type="text" /></td>
                                            <td class="save-tit">配送单号:</td>
                                            <td class="save-con"><input type="text" /></td>
                                         </tr>
                                          
                                         <tr>
                                             <td class="save-tit">配送备注:</td>
                                             <td class="save-con"><textarea></textarea></td>
                                         </tr>
                                     </table>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save-btn">
                                         <tr>
                                           <td style="text-align:right"><a href="#" class="save-btn">确定配送</a></td>
                                           <td style="text-align:left"><a href="#" class="can-btn" onclick="guanbi(id='peisong<ww:property value='id'/>');">取消</a></td>
                                         </tr>
                                     </table>
                                </div>
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

 function shows(id,agentid){
		 
		$("#detail"+id).show();
		
		$.ajax({
			type:'post',
			url:'customeragent!ajaxtoCustomeragent.action?customeragent.id='+agentid,
			async:false,
			success:function(data){
				var json = eval("("+data+")");
				data=json;
				//alert(data);
				//alert(data.agentphone);
				//data.agenttype=3;
				if(data == null){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，无详细信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					
				}else{
				if(data.agenttype == 3){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td colspan='2' style='color:#f48000;'>"+data.agentphone+"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq + ":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
				}else{
					if(data.agenttype == 2){  
					$("#detail"+id).html("<table style=' text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.agentphone+
						"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>出票人电话:</td><td>"+data.outticketmantel+
						"</td></tr><tr><td style='color:#000;'>出票人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.outticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.outticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>退票人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.backticketmantel+"</td></tr><tr><td style='color:#000;'>退票人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.backticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.backticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
					}
					if(data.agenttype == 1){
						$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，不能查看运营商的信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					}
				}
				}
			} 
		});
		
	}
	function hides(id){
		$("#detail"+id).hide();
	}
	
	function SaveAndTicket(id){
	var beizhu=$("#beizhu_"+id).val();
	//alert(beizhu);
	$("#strOrderID").val(id)
	document.form1.action="train!SaveAndTicket.action";
	document.form1.submit();
	
	}
	
	function suodan(orderid){
		 
		$.ajax({
	         type:"POST",
	         async:false,
	         url:"train!suodan.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid},
	         success:function(data){
	         	alert(data);
	        
	         }            
	         });
 
  
		
	}
	
function UpdateUserid(va,id){

//alert(va+"-"+id);

window.location.href="train!updateuserid.action?strOrderID="+id+"&s_userid="+va;

}
	
</script>
