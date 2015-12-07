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
 	
 	window.location.href="train!tochupiao.action?id="+id;
 	
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
<form name="form1" id='form1' method="post" action="train!SaveAndPeiSong.action">
<input type="hidden" name="s_orderstatus" value="<ww:property value="train.s_orderstatus"/>"  />
<input type="hidden" name="strOrderID" id="strOrderID" value="<ww:property value="train.id"/>"  />

			
<div id="wrap">
<div class="right">


                       
                                	
                                 <!--浮动框开始-->
                                <div class="message"  style="width: 80%" >
                                    <h2>信息核对</h2>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                         <tr>
                                            <td colspan="5">车票信息</td>
                                         </tr>
                                         <tr>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="train.startdate" /></b></td>
                                            <td style="font-size: 28px;color: red"><b><ww:property value="train.traincode" />次</b></td>
                                            <td colspan="3" style="font-size: 18px;color: red"><b><ww:property value="train.startcity" />&nbsp;<ww:property value="train.starttime" />—<ww:property value="train.endcity" /></b></td>
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
                                              <td width="40%">证件号码</td>
                                               <td class="title" width="11%">票面价</td>
                                               
                                                <td class="title" width="11%">保险</td>
                                              <td class="title" width="11%">出票席别</td>
                 							  <td class="title" width="11%">出票价</td>
                                              <!--
                                              <td>手机号</td>
                                        	  -->
                                         </tr>
                                         
                                         <ww:iterator value="GetTrainPassList(train.id)">
                                           <tr>
                                              <td width="10%" style="font-size: 28px;color: red"><b><ww:property value="GetXiBieTypeByCode(seattype)"/></b></td>
                                              <td width="10%"><ww:if test="state==1">成人</ww:if><ww:if test="state==2">儿童</ww:if></td>
                                              <td width="20%" style="font-size: 28px;color: red"><b><ww:property value="name"/></b></td>
                                              <td width="20%"><ww:property value="getTypeToString(idtype)"/></td>
                                              <td width="40%" style="font-size: 18px;color: red"><b><ww:property value="idnumber" /></b></td>
                                              <!--
                                              <td>18311103104</td>
                                              -->
                                              <td class="cont">￥<ww:property value="price" /></td>
                                               <td class="cont">￥<ww:property value="bxprice" /></td>
                                                <td class="cont"><ww:property value="chupiaotype" /></td>
                  								 <td class="cont">￥<ww:property value="chupiaoprice" /></td>
                                              <ww:set name="infos_price" value="price"/>
                                         </tr>
                                         </ww:iterator>
                                     </table>
                                     
                                     
                                     
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save">
                                     	<tr>
                                            <td colspan="5">快递信息</td>
                                         </tr>
                                         
                                         <tr>
                                            <td class="save-tit" width="210px;">单位:</td>
                                            <td class="save-con" width="20%">
                                            <select name="s_kdcomname">
                                            <option value="申通快递">申通快递</option>
                                            <option value="圆通快递">圆通快递</option>
                                            <option value="顺丰快递">顺丰快递</option>
                                            <option value="EMS快递">EMS快递</option>
                                            </select>
                                            </td>
                                            <td class="save-tit" width="20%">单号:</td>
                                            <td class="save-con" width="20%"><input type="text" name="s_kdcode" id="s_kdcode" /></td>
                                         </tr>
                                          
                                         <tr>
                                             <td class="save-tit">备注:</td>
                                             <td class="save-con"><textarea name="s_kddesc" id="s_kddesc"></textarea></td>
                                         </tr>
                                     </table>
                                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="save-btn">
                                         <tr>
                                           <td style="text-align:right"><a href="#" onclick="SaveAndPeiSong(<ww:property value='id'/>);return false;" class="save-btn">确定配送</a></td>
                                           <td style="text-align:left"><a href="javascript:history.go(-1);" class="can-btn" >取消</a></td>
                                         </tr>
                                     </table>
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

 
	
	function SaveAndPeiSong(id){
	var scode=document.getElementById("s_kdcode").value;
	if(scode==''){
	alert("单号不能为空!!!");
	return;
	}
	document.form1.action="train!SaveAndPeiSong.action";
	document.form1.submit();
	
	}
	
	
	
</script>
