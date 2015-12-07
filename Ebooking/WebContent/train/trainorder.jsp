<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${dns.companyname} 火车票预订</title>
<link href="train/css/orders.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="main_tulue/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="main_tulue/js/jsAddress.js"></script>	

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	
</head>
<body>
<jsp:include page="../top.jsp?index=4&subindex=1"></jsp:include>
<form target="_blank" action="train!ordertrain.jspx" method="post" id='payform' name='payform' onsubmit="return form_validate(this)">
<div id="wrap">
<div class="right">
     <div class="box">
     
       <!-- 车票信息begin-->
         <div class="ticket-info">
               <h1>车票信息<span>（数据仅供参考，请以实际出票情况为准)</span></h1>
              
               <div class="basic-info">
                      <div class="basic-info-L">
                        <b style="color:#36322f; line-height:40px">车次:<ww:property value="train.traincode" /></b>
                 </div>
                      <div class="basic-info-R">
                           <P><ww:property value="train.startcity" />（<ww:property value="train.starttime" />）---<ww:property value="train.endcity" />(<ww:property value="train.endtime" />)</P>
                           <div class="site">
                                 <b>坐席:</b>
                                 <ul>
                                 <ww:property value="#request.zwhtml" />
                                     <!--<li><input type="radio" />一等 <span>533元</span>（剩

余29张）</li>
                                     <li><input type="radio" />二等 <span>533元</span>（已

经售完）</li>
                                     <li><input type="radio" />商务 <span>233元</span>（已

经售完）</li>  
                                 -->
                                 
                                 </ul>
                           </div>
                           
                        <div class="alter">
                                <b>备选坐席:</b>
                                 <ul>
                                 	<ww:if test="train.traincode.substring(0,1).equals(\"G\")||train.traincode.substring(0,1).equals(\"D\")">
                                 	 <li><input type="checkbox" name="deliverytypeval" value="一等"  />一等</li>
                                 	 <li><input type="checkbox" name="deliverytypeval" value="二等" />二等</li>
                                 	 <li><input type="checkbox" name="deliverytypeval" value="三等" />三等</li>
                                 	 <li><input type="checkbox" name="deliverytypeval" value="商务" />商务</li>
                                 	 <li><input type="checkbox" name="deliverytypeval" value="特等" />特等</li>
                                 	</ww:if><ww:else>
                                 	 <li><input type="checkbox" name="deliverytypeval" value="硬卧" />硬卧</li>
                                     <li><input type="checkbox" name="deliverytypeval" value="软卧" />软卧</li>
                                     <li><input type="checkbox" name="deliverytypeval" value="硬座" />硬座</li>
                                     <li><input type="checkbox" name="deliverytypeval" value="无座" />无座</li>
                                 	</ww:else>
                                    
                                 </ul>
                           </div>
                           
                           <div class="prompt-1">
                                注：如您选择的车票已售完，可以在备选坐席里选择您想要预订的

座位，我司将尽力为您出票
                           </div>
                           
                      </div>
           </div>
       </div> 
         
          <!-- 车票信息end-->
          
          <!--  乘车人信息 begin -->   
           <div class="ticket-info">
               <h1>乘车人基本信息</h1>
                <ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
				<ww:param name="'first'" value="1" />
				<ww:param name="'last'" value="5" />
				</ww:bean> 
				<ww:iterator value="#counter" status="state">
               <div class="pass-info" id="pass_<ww:property value="#state.index+1" />" style="display: none;">
                     <h2>乘客<ww:property value="#state.index+1" />基本信息<span><a href="#" onclick="delpass('<ww:property value="#state.index+1" />');return false;">删除乘客</a></span><span><input 

type="checkbox" />保存为常用联系人</span></h2>
                     <p>姓名:   <input type="text" id="pname_<ww:property value="#state.index+1" />" name="pname" /><b>不能为空</b></p>
                     
                     <p>类型: 
                        <select name="passtype">
                        <option value="2">儿童票</option>
                        <option value="1" selected="selected">成人票</option>
                        </select> 
                     </p>
                     
                      <p>证件类型: 
                        <select name="idtype">
                        <option value="5" >台湾通行证</option>
                        <option value="1" selected="selected">二代身份证</option>
                        <option value="8" >军官证</option>
                        <option value="3" >护照</option>
                        <option value="6" >台胞证</option>
                        <option value="7" >回乡证</option>
                        <option value="4" >港澳通行证</option>
                        <option value="9" >其他</option>
                        </select> 
                     </p>
                     
                     <p>证件号码:   <input type="text" id="idnumber_<ww:property value="#state.index+1" />" name="idnumber" /><b>不能为空</b></p>
               </div>
               </ww:iterator>
               
               <!--
               <div class="pass-info">
                     <h2>乘客2基本信息<span><a href="#">删除乘客</a></span><span><input 

type="checkbox" />保存为常用联系人</span></h2>
                     <p>姓名:   <input type="text" /><b>不能为空</b></p>
                     
                     <p>类型: 
                        <select name="type">
                        <option value="">儿童票</option>
                        <option value="" selected="selected">成人票</option>
                        </select> 
                     </p>
                     
                      <p>证件类型: 
                        <select name="type">
                        <option value="">临时身份证</option>
                        <option value="" selected="selected">二代身份证</option>
                        <option value="">军官证</option>
                        <option value="">护照</option>
                        <option value="">台胞证</option>
                        <option value="">户口本</option>
                        <option value="">港澳通行证</option>
                        </select> 
                     </p>
                     
                     <p>证件号码:   <input type="text" /><b>不能为空</b></p>
               </div>
               -->
               <div class="add">
                   <div class="prompt-2">
                         <p>温馨提示</p>
                         <p>1.如若2-3人一同出行，请添加同行乘客一起提交，可提高连座几率。

</p>
                         <p>2.所填写的乘客姓名和证件号码必须与证件信息保持一致，若有错别字

或者号码不准确均会导致出票失败</p>
                         <div class="add-btn"><a href="#" onclick="addpass();return false;"><img src="train/img/add-btn.gif" 

width="159" height="45" /></a></div>
                   </div>
                   <div class="price-detail">
                       <p>票面价：...................<b id="piaomianjia">300元</b></p> 
                       <p>人  数：.....................<b id="zongrenshu">5人</b></p>
                       <p>保  险：.....................<b id="baoxianfei">40元</b></p>
                       <p>手续费：...................<b id="shouxufei">5元</b></p>
                       <p>快递费：...................<b id="peisongfei">20元</b></p>
                       <p style="display: none;">总张数：...................<b id="">5张</b></p>
                       <p style=" font-weight:bold; font-size:14px;">总价：...................<b style="font-size:22px" id="zongjia">375元</b></p> 
                   </div>
               </div>
               
           </div>

          <!--  乘车人信息 end --> 
          
          
          <!--  保险信息 begin --> 
            
               <div class="ticket-info">
                   <h1>保险信息</h1>
                   <div class="insu-info">
                          <p><input type="radio" onclick="ChangBX('20');"  name="baoxianprice11" checked="checked" value="20" />20元一份，保额65万</p>
                          <p><input type="radio" onclick="ChangBX('0');" name="baoxianprice11" value="0" />不购买保险</p>
                          
                          
                   </div>
               </div>
           
           <!--  保险信息 end -->  
           
           
           <!--  车票提取 begin --> 
            
               <div class="ticket-info">
                   <h1>车票提取</h1>
                   <div class="ticket-extract">
                         <ul>
                             <li><input type="radio"   name="qptype" id="qptype1" value="1" onclick="changType('ziti','peisong');ChangPS('0','0');alert('当前排队人数过多,如需优先出票,请选择送票上门,我们将有VIP通道为你办理!!!');" />自行取票</li>
                             <li><input type="radio"  name="qptype" id="qptype2" value="2" onclick="changType('peisong','ziti');ChangPS('20','5');"  checked="checked"  />送票上门</li>
                         </ul>
                         <div class="ticket-extract-con">
                         
                        <!-- 自行取票 begin-->
                              <div class="own"  style="display:none" id="ziti">
                                  <div class="own-info">
                                       <p><b>(*)</b>姓名:  <input type="text" name='contactname' id='contactname' /></p>   
                                       <p><b>(*)</b>手机:  <input type="text" name='contactmobile' id='mobile' /></p>  
                                      
                                  </div> 
                                <div class="instruct">
                                         <p><b>自行取票须知:</b></p> 
                                         <p>1.二代身份证可在火车站、代售点、自动售票机取票

</p>
                                         <p>2.护照、回乡证、台胞证可在火车站、代售点取票。

</p>
                                         <p>3.儿童票需换取纸质车票才可进站乘车。</p>
                                  </div>
                              </div>
     
                    <!-- 自行取票 end-->
                    
                    <!-- 送票上门 begin-->
                              <div class="send" id="peisong">
                                     <div class="own-info">
                                       <p><b>(*)</b>收&nbsp;&nbsp;件&nbsp;&nbsp;人:  <input type="text"  name='peisong_name' id="shouName"  /></p>   
                                       <p><b>(*)</b>收件人手机:  <input type="text" name='peisong_tel' value=""   id="shouPhone" /></p>  
                                       <p>所在省:  <select name="cmbProvince" id="cmbProvince"></select>
                                                  
                                           所在市： <select name="cmbCity" id="cmbCity">
                                              </select>
                                                  
                                           所在区(镇):  <select name="cmbArea" id="cmbArea">
                                             
                                              </select>
                                                  
                                       </p>
                                        <script type="text/javascript">
											addressInit('cmbProvince', 'cmbCity', 'cmbArea', '北京', '市辖区', '朝阳区');
											<!-- addressInit('Select1', 'Select2', 'Select3', '上海', '市辖区', '闸北区'); -->
										</script>
                                       <!--
                                       <p><b>(*)</b>配送方式: <select name="type" 

style="width:70%;*width:25%">
                                                  <option value="">申通</option>
                                                  <option value="" selected="selected">顺丰

</option>
                                                  </select>
                                       </p>  
                                       -->
                                       <p><b>(*)</b>详细地址: <input type="text" style="width:70%;*width:25%" name="address"  id="shouAddress"   /></p>  
                                  </div> 
                                <div class="instruct instructs">
                                         <p><b>送票上门须知:</b></p> 
                                         <p>1.偏远乡村，偏远省份的大部分城市不派送，同时偏

远的旅游风景区，度假地不派送。</p>
                                         <p>2.沿海或者内陆地区的岛屿及沙漠区域,不派送。</p>
                                         <p>3.党政机关，部队，军事基地不派送。</p>
                                         <p>4.港澳台及国外其它各地区暂不派送</p>
                                         <p>5.如收件城市和车票出发城市不同，客户需要提前安

排行程。有特殊要求，请致电我平台或在下单时，做订单备注</p>
                                  </div>
                              </div>
                         </div>
                         
                 <!-- 自行取票 begin-->
                         
                   </div>
               </div>
           
           <!--  车票提取end --> 
           
           <!-- 发票信息 begin --> 
           
            <div class="ticket-info">
                   <h1>发票信息</h1>
              <p style=" text-align:center"><input type="checkbox" />保险发票(将在火车发车

后第二个工作日由承保的保险公司用平信免费邮寄出)</p>    
            </div>
          <!-- 发票信息end --> 
           
          <!--我已同意 begin-->
            <div class="agree">
                <p>我已阅读并同意<a href="#">《火车票线下代购服务协议》</a></p>
            </div> 
          <!--我已同意 end-->
          
          
           <!--提交按钮 begin-->
            <div class="submit">
                <p><a href="#" onclick="payorder();"><img src="train/img/submit.gif" width="204" height="52" /></a></p>
            </div> 
          <!--提交按钮 end-->
            
              
     </div>
                  
  
                    
          

</div>

</div>
 <input type="hidden" id="trainprice" name="trainprice" value="<ww:property value="#request.oneprice" />" />
  <input type="hidden" id="startdate" name="startdate" value="<ww:property value="startdate" />" />
                             
                             

<input type='hidden' id='seattype' name='seattype' value=''/>
<input type='hidden' id='deliveryadd' name='deliveryadd' value=''/><!-- 1自取  2配送 -->
<input type="hidden" id='booktype' name='booktype' value='0'/><!-- 1无票预订  2有票预订 -->

<input type="hidden" id="baoxianprice" name="baoxianprice" value="20" />
<input type="hidden" id="peisongprice" name="peisongprice" value="20" />
<input type="hidden" id="shouxuprice" name="shouxuprice" value="5" />
</form>
<ww:include page="../footer.jsp" />
</body>
</html>
<script>

function addpass(){
	for(i=1;i<=5;i++){
		var te=$("#pass_"+i).is(":hidden");
		//alert(i+"-"+te);
		if(te==true){
		$("#pass_"+i).show();
		subprice();
		return;
		}
	}
	
}
function delpass(id){
	    $("#pname_"+id).val("");
	    $("#idnumber_"+id).val("");
		$("#pass_"+id).hide();
		subprice();
}

function changType(id1,id2){
$("#"+id1).show();

$("#"+id2).hide();
}

function bookOrderchangeFirstSeat(va,ty){


var vas=va.value.split(","); 
var price=vas[0];
var yp=vas[1];
if(yp==0||yp=='null'||yp==''||yp=='--'||yp=='NULL'||yp==' '){
alert("无座预订的情况下,我司会尽力帮你预订,但不能保证100%出票!");
$("#booktype").val(0);
}else{
$("#booktype").val(1);
}

$("#trainprice").val(price);
//$("#trainprice_li").html(price);
$("#seattype").val(ty);//赋值席别

//trainprice

subprice();
}

function ChangBX(va){
$("#baoxianprice").val(va);
subprice();
}
function ChangPS(va,sx){
$("#peisongprice").val(va);//
$("#shouxuprice").val(sx);//手续费
subprice();
}

function subprice(){
var pnums=0;
	for(i=1;i<=5;i++){
		var te=$("#pass_"+i).is(":hidden");
		
		if(te==false){
		pnums++;
		}
	}
	
	
var oneprice=$("#trainprice").val();//单价
var psprice=$("#peisongprice").val();//配送费
var bxprice=$("#baoxianprice").val();//保险费
var sxfprice=$("#shouxuprice").val();//手续费
//alert("总人数:"+pnums+",单价:"+oneprice+",配送:"+psprice+",保险:"+bxprice);

$("#piaomianjia").html(oneprice+"元");
$("#zongrenshu").html(pnums+"人");
$("#baoxianfei").html((parseInt(bxprice)*parseInt(pnums))+"元");
$("#peisongfei").html(parseInt(psprice)+"元");
$("#shouxufei").html(parseInt(sxfprice)+"元");

$("#zongjia").html((parseInt(psprice)+(parseInt(bxprice)*parseInt(pnums))+parseInt(sxfprice)+parseInt(oneprice)*parseInt(pnums))+"元");

}

function payorder(){
	
	
	for(i=1;i<=5;i++){
		var te=$("#pass_"+i).is(":hidden");
		if(te==false){
			if($("#pname_"+i).val()==''){
			alert("姓名不能为空");
			$("#pname_"+i).focus();
			return;
			}
		if($("#idnumber_"+i).val()==''){
			alert("证件号码不能为空");
			$("#idnumber_"+i).focus();
			return;
			}
		
		}
	}
	
	
	var psprice=$("#peisongprice").val();//配送费
	
	if(psprice==0){
		//alert("自取");
		
		 if($("#contactname").val()==''){
			alert("姓名不能为空!");
			$("#contactname").focus();
			return;
			}
			if($("#mobile").val()==''){
			alert("手机不能为空!");
			$("#mobile").focus();
			return;
			}
		
		
			
	}else{
	  // alert("配送");	
	  
	  
	       if($("#shouName").val()==''){
			alert("联系人不能为空!");
			$("#shouName").focus();
			return;
			}
			if($("#shouPhone").val()==''){
			alert("手机不能为空!");
			$("#shouPhone").focus();
			return;
			}
	      if($("#shouAddress").val()==''){
			alert("详细地址不能为空!");
			$("#shouAddress").focus();
			return;
			}
	  
	    }
	
		
	
		expexcel();
		document.forms.payform.submit();
		
	
}



function expexcel() {
alert("?");
    var win = new Ext.Window({
        height      : 150,
        width       : 400,
        modal       : true,
        title       : '提醒',
        html        : '<br>请到打开的新窗口进行银行卡支付，付款未完成前请不要关闭本页面。<br/>支付完成后请点击下一步',
        plain       : true,
        border      : true,
        resizable   : false,
        draggable   : false,
        closable    : false,
        buttonAlign : 'center',
        buttons     : [
            {
                text    : '下一步',
                handler : function() {
                   window.location.href="train!ordersuccess.jspx";
                }
            }
        ]
    })
    win.show();
}

function hidediv(id){
$("#"+id).hide();
}
function showdiv(id){
$("#"+id).show();
}

$("#pass_1").show();
subprice();
</script>
