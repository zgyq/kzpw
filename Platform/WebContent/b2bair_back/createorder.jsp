<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="b2bair/css/right.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.4.2.min.js" type=text/javascript></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    //成人含税费总票价
    var adultpricefee=0;
    
    var adultpassengerprice=0;
    var adultpassengerairport=0;
    var adultpassengerfuel=0;
    var adultpricepmj=0;//票面价
    
    var oneprice=0;//第一程价格
    var twoprice=0;//第二程价格
    
    var oneairport=0;//第一程基建
    var twoairport=0;//第二程基建
     
    var onefuee=0;//第一程燃油
    var twofuee=0;//第二程燃油
    
   
    //总乘机人数
    var passengercount=0;
    //全价价格
    var yprice=0;
    //一份保险的价格
    var insuranceprice=7;
    <ww:iterator value="listsegmentinfo" status="index">
      yprice+=<ww:property value="yprice" />
     <ww:if test="#index.index==0">
	oneprice='<ww:property value="parvalue" />';
	oneairport='<ww:property value="airportfee" />';
	onefuee='<ww:property value="fuelfee" />';
	</ww:if>
	  <ww:if test="#index.index==1">
	twoprice='<ww:property value="parvalue" />';
	twoairport='<ww:property value="airportfee" />';
	twofuee='<ww:property value="fuelfee" />';
	insuranceprice+=7;
    </ww:if>
       
       
    </ww:iterator>
   
  	adultpricefee+=adultpassengerprice+adultpassengerairport+adultpassengerfuel;
   
   
        
        
 </script>       
</head>
<body>
<div id="wrap">
<form id="form2" name="form2">
<div class="right">
     <div class="box">
     
          
          
          <ww:iterator value="listsegmentinfo" status="index">
          
          <!-- 隐藏域 -->
            <input type="text" id="hidsairport_<ww:property value="#index.index" />" value="<ww:property value="startairport" />" />
			<input type="text" id="hideairport_<ww:property value="#index.index" />" value="<ww:property value="endairport" />" />
			<input type="text" id="hidfromdate_<ww:property value="#index.index" />" value="<ww:property value="formatTimestampyyyyMMdd(departtime)" />" />
			<input type="text" id="hidaircompany_<ww:property value="#index.index" />" value="<ww:property value="aircomapnycode" />" />
			<input type="text" id="hidflightnumber_<ww:property value="#index.index" />" value="<ww:property value="flightnumber" />" />
			<input type="text" id="hidcabin_<ww:property value="#index.index" />" value="<ww:property value="cabincode" />" />
			<input type="text" id="hidparvalue_<ww:property value="#index.index" />" value="<ww:property value="parvalue" />" />
          
          
          
          
          <!-- 航程信息 begin-->
             <div class="fill-info">
                  <h2><span><img src="b2bair/img/h2-icon.gif"/></span>航程信息&nbsp;
                  <ww:if test="listsegmentinfo.size()>1">
	                  <ww:if test="#index.index==0">
	                                   第一程
	                  </ww:if>
	                   <ww:if test="#index.index==1">
	                                   第二程
	                  </ww:if>
                  </ww:if>
                  </h2>
                  <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                      <tr class="tit-bg">
                          <td>航程</td>
                          <td>起抵时间</td>
                          <td>折扣</td>
                          <td>票价</td>
                          <td>机型</td>
                          <td>机建/燃油</td>
                          <td>返点</td>
                          <td>佣金</td>
                          <td>结算</td>
                      </tr>
                      <tr class="con-bg">
                          <td>
                             <span><img src="images/airComlogo/<ww:property value="aircomapnycode" />.gif" style="margin-bottom: -5px;" alt="" /><ww:property value="airname" /><ww:property value="flightnumber" /></span>
                             <span><ww:property value="getAirCityNamebySZM(startairport)" />--<ww:property value="getAirCityNamebySZM(endairport)" /></span>
                          </td>
                          <td>
                              <span><ww:property value="formatTimestampyyyyMMdd(departtime)" />&nbsp;<ww:property value="formatTimestampHHmm(departtime)" /></span>
                              <span><ww:property value="formatTimestampyyyyMMdd(departtime)" />&nbsp;<ww:property value="formatTimestampHHmm(arrivaltime)" /></span>
                          </td>
                          <td><ww:property value="discount/10" />折<ww:property value="GetCabinType(discount,true,cabincode)" /></td>
                          <td>￥<ww:property value="formatMoneyToInt(parvalue)" /></td>
                          <td><ww:property value="flightmodel" /></td>
                          <td><ww:property value="formatMoneyToInt(airportfee)" />/<ww:property value="formatMoneyToInt(fuelfee)" /></td>
                          <td><ww:property value="ratevalue" />%</td>
                          <td>￥<ww:property value="formatMoneyToInt(parvalue*ratevalue/100)" /></td>
                          <td><ww:property value="formatMoneyToInt(airportfee+fuelfee+price)" /></td>
                    </tr>
                  </table>
             </div>
          
          <!-- 航程信息 end-->
       <div class="warn">注意：不得改签，改签收票面价20%的改签费，以上信息仅供参考 </div>
       <!--政策返点 begin-->     
              <div class="policy">
                  
                  <ul>
                     <li><a href="#" onclick="gettheratesep('1','1','<ww:property value="#index.index" />');return false;">普通政策信息</a></li>
                     <li class="li-now"><a href="#" onclick="gettheratesep('1','2','<ww:property value="#index.index" />');return false;">特殊政策信息</a></li>
                  </ul>
                  <div class="policy-con">
                  <script>
					 
                  </script>
                  
                  <div id="zrate_div_<ww:property value="#index.index" />">
                  
                  
                  </div>
                 <!-- 普通政策信息  begin-->
                      
                     <!-- 普通政策信息  end--> 
                     
                     <!-- 特殊政策信息  begin-->
                      
                      
                      <!-- 普通政策信息  end-->
                  
                 </div>
                 
                 <div class="prompt2">
                    <p><b>温馨提示:</b>请注意查看政策中的出票时间和废票时间，不在营业时间内的订单可能无法为您受理！</p>
                    <p><b>特殊政策</b>不支持婴儿票，在选择特殊政策时请确认乘客没有携带婴儿！</p>
                    <p><b>特殊政策</b>请您在起飞日期前3～4天预订，否则有可能无法出票！</p>
                 </div>
                 
                   
               </div>
                   
           <!--政策返点 end-->
           
           </ww:iterator>  
           
           
          
           <!-- 乘机人信息 begin-->
             <div class="fill-info" >
                  <h2><span><img src="b2bair/img/h2-icon.gif"/></span>乘机人信息</h2>
                  
                  
            <ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
			<ww:param name="'first'" value="1" />
			<ww:param name="'last'" value="10" />
			</ww:bean>
			<ww:iterator value="#counter" status="state">
                  <table  cellspacing="0" cellpadding="1" align="center" style="width:100%;display: none;" id='passger<ww:property value="#state.index"/>' >
                      <tr class="tit-bg">
                      
                         <td colspan="4">登机人</td>
                         <td><input type="checkbox" />保存为常用联系人</td>
                         
                      </tr>
                      <tr>
                         <td style="border-right:1px solid #dfdfdf">
                             <table cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                   <tr style="height:45px;">
                                      <td style="text-align:left">姓名<b>*</b>:<input type="text" value="<ww:property value="#state.index"/>" id="txtPassengerName_<ww:property value="#state.index"/>" name="txtPassengerName" /></td>
                                      <td>乘机人类型:<select name="type" id="ddlpassengertype_<ww:property value="#state.index"/>">
                                                          <option value="">成人</option>
                                                         
                                                      </select>
                                     </td>
                                    <td colspan="2">
                                         <span>
                                              证件类型:<select  id="dlCerType_<ww:property value="#state.index"/>"  name="dlCerType">
                                                          <option selected="selected" value="1">身份证</option>
															<option value="2">护照</option>
															<option value="2">军人证</option>
															<option value="6">回乡证</option>
															<option value="5">台胞证</option>
															<option value="3">港澳通行证</option>
                                                      </select>     
                                         </span>
                                         <span>证件号码:<input type="text" id="txtCertificateNo_<ww:property value="#state.index"/>" name="txtCertificateNo" /></span>
                                    </td>
                                  </tr>
                                  
                                  
                                  <tr style="height:45px;">
                                     
                                     <td>保险份数:<select style="width:50px" id="bxnum_<ww:property value="#state.index"/>" onchange="accountprice();">
				                                     <option selected="selected" value="0">0</option>
				                                     <option value="1">1</option>
				                                     <option value="2">2</option>
				                                     <option value="3">3</option>
				                                     <option value="4">4</option>
                                                 </select>
                                                 <span>每份7元</span>
                                     </td>
                                     <td colspan="2">出生日期:<input type="text" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" id="txtBirthday"  name="txtBirthday" /></td>
                                     
                                  </tr>
                             </table>  
                         </td>
                         <td colspan="5" >
                            <table cellspacing="0" cellpadding="1" align="center" style="width:100%">
                               <tr><td style="text-align:center"><a href="#" onclick="add('0');return false;"><img src="b2bair/img/add-btn.png"/></a></td></tr>
                               <tr><td style="text-align:center"><a href="#" onclick="del(<ww:property value="#state.index"/>);return false;"><img src="b2bair/img/del-btn.png"/></a></td></tr>                               
                            </table>
                             
                         </td>
                      </tr>
                      
                  </table>
                  </ww:iterator>
             </div>
             
             
             
          <!-- 乘机人信息 end-->
          
          <!--联系人信息 begin-->
          <div class="fill-info">
                <h2><span><img src="b2bair/img/h2-icon.gif"/></span>联系人信息</h2>
                  <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                     <tr height="50px" bgcolor="#f9f8f8">
                         <td><b>*</b> 姓名 <input type="text" id="txtMobilePhone" name="s_contactname" value="陈星" /></td>
                         <td><b>*</b> 旅客手机 <input type="text" id="txtMobilePhone" name="s_contactmobile" value="18618379513" /></td>
                         <td>邮件 <input type="text" name="s_txtcontactemail" id="s_txtcontactemail" value="1193367@qq.com" /></td>
                         <td>代理电话 <input type="text" name="s_txtcaigoumobile" id="s_txtcaigoumobile" value="<ww:property value="getLoginAgent().agentphone"/>" /></td>
                     </tr>
                  
                  
                  </table>
          </div>
          
          <!--联系人信息 end-->
       
         <!-- 支付方式和金额 begin-->
             <div class="fill-info">
                  <h2><span><img src="b2bair/img/h2-icon.gif"/></span>支付方式和金额</h2>
                  <table  cellspacing="0" cellpadding="1" align="center" style="width:100%" class="pay">
                    <tr>
                       <td width="80px;"style="border-right:1px solid #dfdfdf">行程单:</td>
                       <td >
                       <input type="radio" id="xcdmethod1" name="isxcd"  onclick="is_xcd(0);" value="0" checked="checked" />不需要行程单
                       <input type="radio" id="xcdmethod2" name="isxcd" value="1" onclick="is_xcd(1);"  />需要行程单
                          <b>(温馨提示：代打行程单需要一定费用)</b>
                       </td>
                    </tr>
                    
                    <tr id="peisong">
                       <td width="100px;"style="border-right:1px solid #dfdfdf">配送方式:</td>
                       <td >
                          <input type="radio" id="peisongmethod1" name="s_sendtickettype" value="0" onclick="ispeisong(0);" checked="checked" />不需要配送
                          <input type="radio"  id="peisongmethod2" name="s_sendtickettype"  onclick="ispeisong(1);" value="1" />需要配送
                         
                          <b>(温馨提示:快递配送需要一定费用)</b>
                       </td>
                    </tr>
                    <tr id="peisongaddress" style="display: none">
                       <td width="100px;" style="border-right:1px solid #dfdfdf">配送信息:</td>
                       <td class="no-block">
                          <span>收件人:<input type="text"  id="s_postname" desc="收件人" name="s_postname" /></span>
                          <span>联系电话:<input type="text" id="s_postmobile" desc="联系电话" name="s_postmobile" /></span>
                          <span>邮编:<input type="text" id="s_postzipcode" desc="邮政编码" name="s_postzipcode"  /></span>
                          <span>配送地址:<input type="text"  id="s_postaddress" desc="配送地址" name="s_postaddress" style="width: 400px;" /></span>
                       </td>
                    </tr>
                    
                     <tr>
                       <td width="100px;" style="border-right:1px solid #dfdfdf">计算方式:</td>
                       <td>订单票面价小计*人数+保险份数*7=支付总金额</td>
                    </tr>
                    
                     <tr>
                       <td width="100px;" style="border-right:1px solid #dfdfdf">应付金额:</td>
                       <td><span id="allprice" style="color: red;font-size: 25px;">0元</span></td>
                    </tr> 
                    
                  </table>
             </div>
       <!--支付方式和金额 end-->
       
       
       <div class="next-step"><a href="#" onclick="suborder();return false;"><img src="b2bair/img/next-step.gif"/></a></div>
          
          
          <input type="text" id="pstemp_index" value="1" />
<input type="text" id="hidallpassengers" name="s_jsonpassengers" value="" />
<input type="text" id="hidsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />' name="s_jasonsegmentinfo"  style="width: 500px;"/>



	<!-- 隐藏域 -->
			 <input type="hidden" id="hid_ticketprice_<ww:property value="#state.index"/>" value="" />
             <input type="hidden" id="hid_airportprice_<ww:property value="#state.index"/>" value="" />
             <input type="hidden" id="hid_fuelprice_<ww:property value="#state.index"/>" value="" />
             <input type="hidden" id="hid_totalprice_<ww:property value="#state.index"/>" value="" />
             <input type="hidden" id="hid_insurance_<ww:property value="#state.index"/>" value="" />
             <input type="hidden" id="hid_insurancenum_<ww:property value="#state.index"/>" value="" />
		<ww:if test="s_istieshu>0">
		  <input type="hidden" id="hid_zongjia_<ww:property value="#state.index"/>" value="" />
		</ww:if><ww:else>
		  <input type="hidden" id="hid_zongjia_<ww:property value="#state.index"/>" value="" />
		</ww:else>
		
		 <input type="text" id="hid_onezrateid" name="onezrateid" value="0" />
         <input type="text" id="hid_twozrateid" name="twozrateid" value="0" />
         <input type="text" id="hid_onezratevalue" value="0" />
         <input type="text" id="hid_twozratevalue" value="0" />
		
    </div>
</div>
</form>
</div>

</body>
</html>
<script>
function gettheratesep(index,flag,segmentindex)
    {
   
       $.ajax({
            type:"POST",
            async: false,
            url:"b2bair!GetZrateList.action",
            data:{s_traveltype:segmentindex,z_startcity:$("#hidsairport_"+segmentindex).val(),z_endcity:$("#hideairport_"+segmentindex).val(),z_fromdate:$("#hidfromdate_"+segmentindex).val(),intflag:flag,z_aircode:$("#hidaircompany_"+segmentindex).val(),z_airline:$("#hidflightnumber_"+segmentindex).val(),z_cabincode:$("#hidcabin_"+segmentindex).val(),z_price:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#zrate_div_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
	         if(data!="暂无政策数据")
              {
              $("#zrate_div_"+segmentindex).html(data);
              accountprice();
               
            }   
            }         
       });
     
       
        
           
    }
  
  var jdnum=0;
var oneaircompcode="CA";
var twoaircompcode="CA";

  
     <ww:iterator value="listsegmentinfo" status="index">
     gettheratesep("1","1","<ww:property value='#index.index' />");
     
     <ww:if test="#index.index==0">
	oneaircompcode='<ww:property value="aircomapnycode" />';
	</ww:if>
	  <ww:if test="#index.index==1">
	twoaircompcode='<ww:property value="aircomapnycode" />';
	</ww:if>
     
     </ww:iterator>
     
               
function showtable(size,index)
{
	for(a=1;a<=size;a++){
	document.getElementById(index+a).style.display="block";
	}
	
	document.getElementById(index+"close").style.display="block";
	
	document.getElementById(index+"show").style.display="none";
	
	
	//$("#"+index+"check").html('<a href="javascript:closetable(2,onezrate_)">-缩起</a>');
	
}
function closetable(size,index)
{
	if(parseInt(size)>4){
	
		for(a=5;a<=size;a++){
		document.getElementById(index+a).style.display="none";	
		}	
		
	}	
	document.getElementById(index+"close").style.display="none";
	document.getElementById(index+"show").style.display="block";	
	//$("#"+index+"check").html('<a href="javascript:showtable(2,onezrate_)">-缩起</a>');
	
}				 












var passindex=0;


 //添加
 function add(id){
 if(jdnum>0&&(oneaircompcode=='JD'||twoaircompcode=='JD')&&passindex>=1){
	 alert("航空公司最新规定:JD航空公司一次只能一个人订座,如有多人可选择其他同等航空公司,或者单个分开预订!!");
	 return;
	 } 
	 if(passindex>=9){
	  alert("最多预订9人!!");
	 return;
	}
	  $("#passger"+passindex).show();
		passindex++;
		$("#pstemp_index").val(passindex);

 
 accountprice();
 
 }					 
   //删除
 	function del(state){
 	if(state==0){
		alert("当前元素不能删除,请选择其他旅客删除,或者修改旅客信息!!!");
		return;
		}
		
	  $("#txtPassengerName_"+state).val("");
	   $("#passger"+state).hide();
	 	passindex--;
	 	$("#pstemp_index").val(passindex);
	 	
 accountprice();
 
 }
 //用来获取radio值 RValue=GetRadioValue("myradio");
function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}

 
 function is_xcd(ind){
// alert(ind);
 if(ind=='0'){//不要行程单
  document.getElementById("peisongmethod1").click(); 
 $("#peisong").hide();
 }
 if(ind=='1'){//代打行程单
  $("#peisong").show();
 }
 
 accountprice();
 }
 
  function ispeisong(ind){
 if(ind=='0'){//不要配送
   document.getElementById("s_postname").value="";
    document.getElementById("s_postmobile").value="";
 $("#peisongaddress").hide();
 }
 if(ind=='1'){//需要配送
  $("#peisongaddress").show();
    
 }
  accountprice();
 }
 

 //计算总价格
	function accountprice()
	{
	    var adultnum=0;//成人数
	    var bxfenshu=0;//保险份数
	     //总支付金额
        var totalpayprice=0;
        
        var toallbxprice=0;
	    $("table[id*='passger']").each(function(i){
             passengercount++;
             var strid=$(this).attr("id");
             if(document.getElementById(strid).style.display!="none"){
             id=strid.replace("passger","");
             adultnum++;
             bxfenshu+=parseInt($("#bxnum_"+id).val());
             }
       });
       
      // alert(adultnum+"-"+bxfenshu+"-");
       
       
     var zrateoneid=GetRadioValue("zrate_one");
     var zrateotwoid=GetRadioValue("zrate_two");
     //alert("zrateoneid=="+zrateoneid+"--zrateotwoid=="+zrateotwoid);
     
     
     var onezrateid=0;//第一程ID
     var onezratevalue=0;//第一城返点
     var twozrateid=0;//第二城ID
     var twozratevalue=0;//第二程返点
     
     if(zrateoneid!=null){
     onezrateid=zrateoneid.split('-')[0];
     onezratevalue=zrateoneid.split('-')[1];
     $("#hid_onezrateid").val(onezrateid);
     $("#hid_onezratevalue").val(onezratevalue);
     
     }
     if(zrateotwoid!=null){
     twozrateid=zrateotwoid.split('-')[0];
     twozratevalue=zrateotwoid.split('-')[1];
     $("#hid_twozrateid").val(twozrateid);
     $("#hid_twozratevalue").val(twozratevalue);
     }
     //alert(onezrateid+"-"+onezratevalue+"-"+twozrateid+"-"+twozratevalue);
     
     
     var onyoneprice= oneprice-oneprice*onezratevalue/100;
     onyoneprice=parseInt(Math.round(onyoneprice*100)/100)+parseInt(oneairport)+parseInt(onefuee);//格式化
     var onytwoprice= twoprice-twoprice*twozratevalue/100;
     onytwoprice=parseInt(Math.round(onytwoprice*100)/100)+parseInt(twoairport)+parseInt(twofuee);//格式化
     //alert(onyoneprice+"-"+onytwoprice);
       
    
	
	//平台交易费
	var ptPrice=<ww:property value='orderPlat'/>;
	//代打行程单费
	var cxdprice=<ww:property value='xcdPlat'/>;
	//配送费
	var peisprice=<ww:property value='xcdpsPlat'/>; 
       
       
       
       
      // alert(insuranceprice);
      var allprice= (parseInt(onyoneprice)+parseInt(onytwoprice))*adultnum+parseInt(bxfenshu)*parseInt(insuranceprice)+parseInt(ptPrice);
      
      
      var xcdvalue=GetRadioValue("isxcd");
      if(xcdvalue=='1'){
      
      allprice=allprice+parseInt(cxdprice)*parseInt(adultnum)*<ww:property value="listsegmentinfo.size()" />;
      }
      
      var peisvalue=GetRadioValue("s_sendtickettype");
      if(peisvalue=='1'){
        allprice=allprice+parseInt(peisprice);
      }
      
      
      //alert("总价:"+allprice);
       $("#allprice").html(allprice+"元");
       
	}
	
	function  suborder(){
	
	
	
	 
	   var name="";
	   var type="";
	   var idcardtype="";
	   var idcardnumber="";
	   var insurancenum=0;
	   var insurancetotalprice=0;
	   var ticketprice=0;
	   var airportprice=0;
	   var fuelprice=0;
	   var totalprice=0;
	   var issave=1;
	   
	 	var jsonstring="[";
	   $("table[id*='passger']").each(function(i){
	        var strid=$(this).attr("id");
	        if(document.getElementById(strid).style.display!="none"){
            id=strid.replace("passger","");
            name=$("#txtPassengerName_"+id).val();
            type=$("#ddlpassengertype_"+id).val();
            idcardtype=$("#dlCerType_"+id).val();
            idcardnumber=$("#txtCertificateNo_"+id).val();
            insurancenum=$("#bxnum_"+id).val();
            insurancetotalprice=parseInt(insurancenum)*insuranceprice;
            ticketprice="";
            airportprice="";
            fuelprice="";
            totalprice="";
            if($("#chbissave_"+id).attr("checked")==true){
               issave=1;
            }
            else
            {
               issave=0;
            }
            jsonstring+='{ ID: "currentindex",Name:"'+name+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"'+insurancenum+'",Insurancemoney:"'+insurancetotalprice+'",Ticketprice:"'+ticketprice+'",Airportprice:"'+airportprice+'",Fuelprice:"'+fuelprice+'",Totalprice:"'+totalprice+'",Issave:"'+issave+'" },';
            
            $("#hidallpassengers").val("");
            }
       });
       jsonstring+="]";
       jsonstring=jsonstring.replace(",]","]");
       $("#hidallpassengers").val(jsonstring);
       
       
	 	
	 	
	 	//$("#DIVWaiting").show();
	 	//$("#btnSaveOrder2").hide();
	 	//return;
	 	
           document.form2.action="b2bair!createorder.action";
	       document.form2.method = "POST"; 
           document.form2.submit();
	
	
	
	}
	
	
               
   add('-1');
    //accountprice();                          
</script>