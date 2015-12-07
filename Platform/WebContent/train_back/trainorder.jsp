
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_tulue/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="main_tulue/js/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	
<script type="text/javascript" src="main_tulue/js/jsAddress.js"></script>	
</head>
<body>
<div id="wrap">
<form target="_blank" action="train!ordertrain.action" method="POST" id='payform' name='payform'>
<input type='hidden' id='seattype' name='seattype' value=''/>
<input type='hidden' id='deliveryadd' name='deliveryadd' value=''/>
<input type="hidden" id='qptype' name='qptype' value='1'/><!-- 1自取  2配送 -->
<input type="hidden" id='booktype' name='booktype' value='0'/><!-- 1自取  2配送 -->
<div class="right">
     <div class="box">
     
       <!-- 车票信息begin-->
         <div class="ticket-info">
              <div class="info-tit">车票信息<font>（数据仅供参考，请以实际出票情况为准)</font></div>
              <div class="info-con">
                      <div class="ticket-num">
                           <strong><ww:property value="train.traincode" /></strong>
                           <font><ww:property value="GetTrainTypeByCode(train.traincode)" /></font>
                      
                      </div>
                      
                      <div class="ticket-con">
                         <ul>
                            <li class="title"><ww:property value="train.startcity" /><b>（<ww:property value="train.starttime" />)</b> — <ww:property value="train.endcity" /><b>（<ww:property value="train.endtime" />）</b></li>
                            <li>日期：<ww:property value="startdate" /></li>
                            <li>
                                <div style='float:left'>坐席:</div> 
                            	<div style='float:left'>
                            	<ul id="seatUls">
                            	<ww:property value="#request.zwhtml" />
									</ul>
                            	</div>
                              <div class="clearit"><div>
                             </li>
                             <input type="hidden" id="trainprice" name="trainprice" value="<ww:property value="#request.oneprice" />" />
                             <input type="hidden" id="startdate" name="startdate" value="<ww:property value="startdate" />" />
                             <li>票面价：<span id="trainprice_li"><ww:property value="#request.oneprice" /></span>元</li>
                         </ul>
                      </div>
                      <div class="new-chose"><a href="javascript:history.go(-1);"><img src="main_tulue/img/new-chose-btn.gif" width="91" height="34" /></a></div>
                 </div>
               </div>  
                 
          <!-- 车票信息end-->
          
          <!--下单人详细信息填写 begin-->
          
              <div class="user-info">
                    <ul class="style">
                        <li class="li-now" id="li_ziti"><a href="#" onclick="changType('ziti','peisong');return false;">自行取票<span>开车前任何车站可自行取票</span></a></li>
                        <li id="li_peisong"><a href="#" onclick="changType('peisong','ziti');return false;">送票上门<span>足不出户，车票送上门</span></a></li>
                    </ul>
                    <div class="clearit"></div>
                    <div class="qupiao">
                          <!--乘客信息填写 begin-->
                          <h2>乘客信息<span>(一个订单最多可代购5张票，请务必填写乘车人真是信息，<a href="#">购票说明</a>)</span></h2>
                          <div class="user-name"> <input type="checkbox" />张三</div>
                          
                          <div class="pas">
                            <ul>
                                <li class="none">&nbsp;</li>
                                <li class="xm">姓名</li>
                                <li class="lx">类型</li>
                                <li class="zj">证件类型</li>
                                <li class="hm">证件号码</li>
                             </ul>
                          </div>
                          <!--
                <ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
				<ww:param name="'first'" value="1" />
				<ww:param name="'last'" value="9" />
				</ww:bean> 
				<ww:iterator value="#counter" status="state">
                          <div class="pas pass" id="pass_<ww:property value="(#state.index+1)"/>" style="display: none;">
                            <ul>
                                    <li class="none"></li> <ww:property value="(#state.index+1)"/> 
                                    <li class="xm"><input type="text" name="passname" id="passname_<ww:property value="(#state.index+1)"/>" value="" style="width:70px"/></li>
                                    <li class="lx">
                                          <select name="passtype">
                                          <option value="1">成人票</option>
                                          <option value="2" selected="selected">儿童票</option>
                                          <option value="3">学生票</option>
                                          </select>
                                    </li>
                                    <li class="zj">
                                           <select name="idtype">
                                          <option value="yd">一代身份证</option>
                                          <option value="ed" selected="selected">二代身份证</option>
                                          </select>
                                    
                                    </li>
                                    <li class="hm"><input type="text" name="idno" value="" style="width:180px"/></li>
                                    <li class="del"><a href="#" onclick="del(<ww:property value="(#state.index+1)"/>);return false;">删除</a></li>
                                    <li class="baocun"><input type="checkbox" />保存为常用乘客</li>
                                    
                                </ul>
                         </div> 
                      </ww:iterator>   
                         -->
                         <div id="pass_div">
                         
                       	</div>
                         
                        
                          <div class="tishi">
                             温馨提示：
                             <p>1.如若2-3人一同出行，请添加同行乘客一起提交，可提高连座几率。</p>
                             <p>2.所填写的乘客姓名和证件号码必须与证件信息保持一致，若有错别字或者号码不准确均会导致出票失败</p>
                      </div>
                      
                           <div class="tx"><img src="main_tulue/img/tx-btn.gif" width="130" height="38"  onclick="add();" /></div>
                           
                           <!--乘客信息填写 end-->
                           
                            <!--交通意外险 begin -->    
                                <div class="insu">
                                    <h2>交通意外险<span>(若购买保险，每人一份)</span></h2>
                                    <div class="insu-type">
                                         <label><input type="radio" name="baoxianprice" checked="checked" value="20" />20元/1份，保额65万</label>
                                         <label><input type="radio" name="baoxianprice" value="10" />10元/1份，保额20万</label>
                                         <label><input type="radio" name="baoxianprice" value="0" />不购买保险</label>
                                    
                                    </div>
                                    <div class="checked">
                                      <ul>
                                          <li>高额赔付：20元/1份，保额65万</li>
                                          <li>出票加速：急速优先处理订单</li>
                                          <li>人工服务：提供人工改签</li>
                                     
                                       </ul>
                                    
                                    </div>
            
                                </div>

                          <!--交通意外险 end -->  
                          
                           <!-- 车站自提 begin-->
                                <div class="tiqu" id="ziti">
                                    <h2>车站提取<span>(取票规则：开车前可在任何火车站或代售点自由取票,<a href="#">取票说明)</a></span></h2>
                                    <div class="tiqu-deti">
                                        <div class="tiqu-img"><img src="main_tulue/img/tiqu-img.jpg" width="83" height="63" /></div>
                                      <div class="tiqu-detail">
                                           姓名：<input type="text" value="" name='contactname' id='contactname' style="width:100px"/>
                                           手机号：<input type="text" value="" name='contactmobile' id='mobile' style="width:100px"/>
                                           <p class="warn">手机号是接收订票成功短信通知的，请务必填写真实有效的手机号</p>
                                        </div>
                                   </div>
                               </div>
                              
                              <!-- 车站自提 end-->
                              <!-- 送票上门 开始 -->
                              <div class="tiqu peisong" id="peisong" style="display: none;">
                                    <h2>配送信息填写<span><a href="#" onmouseover="showdiv('nopeisong');" onmouseout="hidediv('nopeisong');">（不配送区域说明）</a></span></h2>
                                    <div class="shuoming" id="nopeisong" style='display: none;width:50%;padding:10px; position: absolute;z-index:999; background:#c3d5fd; border:1px solid #dfdfdf; top:30px; left:90px; color:#4e81f1'>
                                          <p>1、偏远乡村，偏远省份的大部分城市不派送，同时偏远的旅游风景区，度假地不派送。</p>
										  <p>2、沿海或者内陆地区的岛屿及沙漠区域,不派送。</p>
										  <p>3、党政机关，部队，军事基地不派送。</p>
										  <p>4、港澳台及国外其它各地区暂不派送。</p>
										  <p>5、如收件城市和车票出发城市不同，客户需要提前安排行程。有特殊要求，请致电我平台或在下单时，做订单备注。</p>

                                    </div>
                                  
                                    <div class="peisong-info">
                                       <ul>
                                           <li> 姓名：<input type="text" name='peisong_name' value=""/></li>
                                           <li> 手机号：<input type="text" name='peisong_tel' value=""/></li>
                                           <li> 邮编：<input type="text" name='peisong_post' value=""/></li>
                                           <li> 配送省份：
                                              <select name="cmbProvince" id="cmbProvince">
                                             
                                              </select>
                                          </li>
                                          
                                          <li> 配送城市：
                                              <select name="cmbCity" id="cmbCity">
                                             
                                              </select>
                                          </li>
                                          
                                          <li> 配送区域：
                                              <select name="cmbArea" id="cmbArea">
                                             
                                              </select>
                                          </li>  
                                       <script type="text/javascript">
											addressInit('cmbProvince', 'cmbCity', 'cmbArea', '北京', '市辖区', '朝阳区');
											<!-- addressInit('Select1', 'Select2', 'Select3', '上海', '市辖区', '闸北区'); -->
										</script>
                                          <li> 配送方式：
                                              <select name="peisong-style">
                                              <option value="">平邮</option>
                                              <option value="" selected="selected">申通</option>
                                              <option value="">宅急送</option>
                                              </select>
                                          </li>
                                            
                                           <li class="address"> 收件人详细地址：
                                            <input type="text" name="address" style="width:310px;"/>
                                          </li>  
                                          
                                       </ul>
                                       <div class="clearit"></div>
                                       <p class="warn">不在下拉框内地的城市请勿下单</p>
                                    </div>
                               </div>
                                <!-- 送票上门 结束 -->
                              
                               
                               <!--保险信息 begin-->
                                  
                                  <div class="insu-info">
                                        <h2>保险信息</h2>
                                        <div class="fapiao">
                                            <input type="checkbox" />保险发票(将在火车发车后第二个工作日由承保的保险公司用平信免费邮寄出)
                                        
                                        </div>
                                  
                                  </div>

                           <!--保险信息 end-->

                    </div>
                    
                    <div class="agree">我已阅读并同意<a href="#">《火车票线下代购服务协议》</a>和<a href="#">《保险说明》</a></div>
                        <div class="submit"><a href="#" onclick="payorder();"><img src="main_tulue/img/submitgif.gif" /></a></div>
    
    
                    

       </div>
          
          <!--下单人详细信息填写 begin-->
              
     </div>
                  
  
                    
          

</div>
</form>
</div>

</body>
</html>
<script>
 var passindex=1;
 
function changType(id1,id2){
$("#li_"+id1).addClass("li-now");//class="li-now"
$("#li_"+id2).removeClass("li-now");
$("#"+id1).show();
$("#"+id2).hide();
if(id1=='ziti'){
//
$("#qptype").val(1);
}
if(id1=='peisong'){
$("#qptype").val(2);
}

}
//删除
 function del(state){
 $("#passname_"+state).val("");
 $("#pass_"+state).hide();

 
 }
 
 

 //add
 function add(){


  	  var shtml="";
          shtml+="<div class='pas pass' id=pass_"+passindex+" >";
          shtml+="<ul>";
          shtml+="<li class='none'></li>"; 
          shtml+="<li class='xm'><input type='text' name='pname' id='passname_"+passindex+"' value='' style='width:70px'/></li>";
          shtml+="<li class='lx'>";
          shtml+="<select name='passtype'>";
          shtml+="<option value='1'>成人票</option>";
          shtml+="<option value='2' selected='selected'>儿童票</option>";
          shtml+=" <option value='3'>学生票</option>";
          shtml+="</select>";
          shtml+="</li>";
          shtml+="<li class='zj'>";
          shtml+="<select name='idtype'>";
          shtml+="<option value='1'>一代身份证</option>";
          shtml+="<option value='2' selected='selected'>二代身份证</option>";
          shtml+="</select>";
          shtml+="</li>";
          shtml+="<li class='hm'><input type='text' name='idnumber' value='' style='width:180px'/></li>";
          shtml+="<li class='del'><a href='#' onclick='del("+passindex+");return false;'>删除</a></li>";
          shtml+="<li class='baocun'><input type='checkbox' />保存为常用乘客</li>";
          shtml+="</ul>";
          shtml+="</div>";
          //alert(shtml);
   $("#pass_div").append(shtml);
   
	//$("#pass_"+passindex).show();
	passindex++;
 }
 

 
 add();
 
 
 
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
$("#trainprice_li").html(price);
$("#seattype").val(ty);//赋值席别

//trainprice


}
 function payorder(){

//var sname=$("#ct1").val();
//var cname=$("#ct2").val();
//var qname=$("#ct3").val();
//var stree=$("#street").val();
//$("#deliveryadd").val(sname+cname+qname+stree);
document.forms.payform.submit();
expexcel();



}
function expexcel() {
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
                   window.location.href="train!ordersuccess.action";
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
</script>
