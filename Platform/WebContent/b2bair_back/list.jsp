<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html>
<html xmlns="">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图游商旅网</title>
<link href="b2bair/css/right.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.4.2.min.js" type=text/javascript></script>
<script type=text/javascript src="b2bair/js/ticket/list.js"></script>
<script type="text/javascript">
    //页面加载
    $(document).ready(function()
	   {
	   getLowZrate();


	
	 });
	  //单程往返类型
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#txtbackdate").attr("disabled","disabled");
	       $("#txtbackdate").val("返");
	    }
	    else if(index==2)
	    {
	       $("#txtbackdate").removeAttr("disabled");
	    }
	 }
	 function clearText(text)
	 {
	     if($("#"+text).val()=="往" || $("#"+text).val()=="返")
	     {
	         $("#"+text).val("");
	     }
	 }
	 
 function getDateyyyyMMdd(num) {
    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
}
	 
	 //查询航班信息
	 function search()
	 {  
	 	 alert("?");	
	
	   //loading("航班信息");
	     document.form1.action="ticticket!toTicketList.jspx";
	     document.form1.method = "POST"; 
         document.form1.submit();
	 }
	 function loading(context)
	 {
	   //遮罩 
        $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在为你查询'+context+',请稍候...</h1>' });
	 }
	
//查询最低价	
function chagecity(citycode){
var flag=document.getElementById("ul1");
 flag.style.display ="none";
 if(citycode=="SHA"){
 $("#ul2").val("上海");
 }
  if(citycode=="PEK"){
 $("#ul2").val("北京");
 }
 if(citycode=="CEN"){
 $("#ul2").val("广州");
 }
 if(citycode=="SIA"){
 $("#ul2").val("西安");
 }
 if(citycode=="HGH"){
 $("#ul2").val("杭州");
 }
 if(citycode=="DLC"){
 $("#ul2").val("大连");
 }
 if(citycode=="WNZ"){
 $("#ul2").val("温州");
 }
$.ajax({
//meiyouwenti
    url:"ticticket!ajaxgetLowersegment.jspx",
    type:"POST",
    data:{fromcity:citycode},
     beforeSend:function(){$("#segmenttr").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载特价机票信息...");},             
    success:function(data){
       $("#segmenttr").html(data);
    }

});

}
//显示下拉列表
 function showul()
	 {  
	    var show=document.getElementById("ul2");
	    var flag=document.getElementById("ul1"); 
	    if(flag.style.display=='none'){
	    flag.style.display ="";    
	    }else{
	    flag.style.display ="none";
	    }
	   
	 }
	 
	 
	  function getLowZrate(){
	  // alert("?");
   		var strid="span[id*='low_zrateprice_']";
		   	$(strid).each(function(i){
		   	$("#book_"+i).hide()
		        $.ajax({
			         type:"POST",
			         url:"b2bair!findcabinlowBY.action",
			         data:{s_istieshu:0,s_depcitycode:$("#hid_lowstartairport_"+i).val(),s_arrcitycode:$("#hid_lowendairport_"+i).val(),s_startdate:$("#hid_lowdeparttime_"+i).val(),s_aircompanycode:$("#hid_lowaircompany_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+i).val(),z_price:$("#hid_lowprice_"+i).val()},
			         beforeSend:function(){$("#low_fandian_"+i).html("<img src='images/loadding.gif' />")},               
			         success:function(data){
			        //alert(data);
			        if(data!=null&&data!=''&&data.split('@').length>0){
				        var datas=data.split('@');
				        //alert(data);
				        $("#low_youhui_"+i).html("￥"+datas[1])
				       	$("#low_zrateprice_"+i).html("￥"+datas[2])
			       	   	$("#book_"+i).show()
			       	   	$("#hid_zrateid_"+i).val(datas[4])
			       	    $("#hid_zratevalue_"+i).val(datas[3])
			       	    
			       	    if(datas[6]=='1'){//普通
			       	     $("#low_fandian_"+i).html(datas[3]+"%")
			       	    }else{//特殊
			       	     $("#low_fandian_"+i).html(datas[3]+"%特")
			       	    }
			       	    
			       	   
			       	    
			       	   	//$("#low_youhui_"+i).html(datas[1]+"元")
			       	   	//$("#hid_qiangzhibaoxian_"+i).val(datas[5])
			       	   	
			       	 }
			         
			         }})
 	  })
 	  }
 	//查询航班序号=ind， flag=是否查询特价政策 1=查，0不查
 function getOtherZrate(ind){
 //alert(ind);
 		var index=ind;
	 
   		var strid="span[id*='ALLCabin_"+index+"_']";
		   	$(strid).each(function(i){
		   			$("#book_"+index+"_"+i).hide()
		   			if($("#hid_lowprice_"+index+"_"+i).val()!="0.0")
		       		{
			        $.ajax({
				         type:"POST",
				         url:"b2bair!findcabinlowBY.action",
				         data:{s_istieshu:0,s_depcitycode:$("#hid_lowstartairport_"+index).val(),s_arrcitycode:$("#hid_lowendairport_"+index).val(),s_startdate:$("#hid_lowdeparttime_"+index).val(),s_aircompanycode:$("#hid_lowaircompany_"+index).val(),s_flightnumber:$("#hid_lowflightnumber_"+index).val(),s_cabincode:$("#hid_lowcabincode_"+index+"_"+i).val(),z_price:$("#hid_lowprice_"+index+"_"+i).val()},
				          beforeSend:function(){$("#ALLCabinfandian_"+index+"_"+i).html("<img src='images/loadding.gif' />")},               
				         success:function(data){
				        //alert(data);
				        if(data!=null&&data!=''&&data.split('@').length>0){
				        var datas=data.split('@');
				        
				         	$("#ALLCabinyouhui_"+index+"_"+i).html("￥"+datas[1])
				         	var airportfuee=$("#hid_lowairportfee_"+index+"_"+i).val();
				            var airfuee=$("#hid_lowfuelfee_"+index+"_"+i).val();
				       		$("#ALLCabinPrice_"+index+"_"+i).html(parseFloat(datas[2])+parseFloat(airportfuee)+parseFloat(airfuee))//结算价
				       		$("#book_"+index+"_"+i).show()
				       		$("#hid_zrateid_"+index+"_"+i).val(datas[4])
				       	   	$("#hid_zratevalue_"+index+"_"+i).val(datas[3])
				       	   	if(datas[6]=='1'){//普通
				       	     $("#ALLCabinfandian_"+index+"_"+i).html(datas[3]+"%")
				       	    }else{//特殊
				       	     $("#ALLCabinfandian_"+index+"_"+i).html(datas[3]+"%特")
				       	    }
				       	   	$("#hid_qiangzhibaoxian_"+index+"_"+i).val(datas[5])
				       	 }
				         
				         }})
			         
			         }
 	  })
 	  }  
 	  
  function lodprice(hb,cw,ct,tm,index){
  
  	//alert(hb+","+cw+","+ct+","+tm+","+index);
  	var citys=ct.split(",");
  	//return;
			 var flightindex=index.split("_")[0];
			    //getOtherZrate(flightindex,1);
	 			$.ajax({
		            type:"POST",
		            url:"ticticket!getTJprice.jspx",
		            data:{flightnub:hb,cabincode:cw,citycode:ct,stime:tm},
		            beforeSend:function(){$("#tiejia_div_"+index).html("<img src='images/loadding.gif' />")},          
		            success:function(datas){
		       		//alert(data);
		       		var sub=datas.split('@');
		       		var data=sub[0];
		       			//alert(sub[0]+"-"+sub[1]+"-"+sub[2]);
			          if(data=='-1'){
			             alert("您选择舱位暂无价格信息,请选择其他舱位!!!");
			           // $("#t"+index).html("<b>无运价</b>");
			            $("#tiejia_div_"+index).html("<span class='tax'>无运价</span>");
		               // $("#rebate_"+index).html("");
		               // $("#price_"+index).html("<b>无运价</b>");
		               // $("#totalprice_"+index).html("<b>无运价</b>");
			          	}else{
				            //var citys=ct.split(',');
				           // var aircode=hb.substring(0,2);
				           // var flight=hb.substring(2,hb.length);
				           // var pr=data.split('|');
				           // $("#zhe_"+index).html(pr[1]);
				            //$("#t"+index).html(pr[0]);
				             //更新Session中航程的特价舱位价格
		                    //changeSessionForSpPrice(index,pr[0],pr[1]);
		                    
		                    $("#hid_lowprice_"+index).val(data);//赋值票面价
		                    $("#zhekou_"+index).html(sub[1]/10+"折");//赋值折扣显示
		                    $("#hid_lowdiscount_"+index).val(sub[1]);//赋值折扣隐藏域
		                    $("#cabinname_"+index).html(sub[2]);//赋值显示仓位等级
		                    
				            lodZrateByNfd(citys[0],citys[1],tm,hb.substring(0,2),hb,cw,data,index);
			            }
		            }             
		            });
	
	}
	
	function lodZrateByNfd(scode,ecode,stime,aircode,flight,cabincode,price,index){
			//alert(scode+","+ecode+","+stime+","+aircode+","+flight+","+cabincode+","+price+","+index);
				 $.ajax({
				         type:"POST",
				         url:"ticticket!findcabinlowBY.jspx",
				         data:{s_istieshu:0,s_depcitycode:scode,s_arrcitycode:ecode,s_startdate:stime,s_aircompanycode:aircode,s_flightnumber:flight,s_cabincode:cabincode,z_price:price},
				       // beforeSend:function(){$("#ALLCabinyouhui_"+index).html("<img src='images/loadding.gif' />")},               
				         success:function(data){
				        //alert(data);
				        if(data!=null&&data!=''&&data.split('@').length>0){
				        	var datas=data.split('@');
				        	var pricespan="<span class='tax'>&nbsp;</span><span class='price'>¥<strong><span id='ALLCabinPrice_"+index+"'></span></strong></span>";
				       	    $("#tiejia_div_"+index).html(pricespan)
				       	    //<span class="tax"></span>
				       	    //<span class="price">¥<strong><span id="ALLCabinPrice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
				       	    //</span></strong></span>
				       	    
				       	    $("#ALLCabinPrice_"+index).html(datas[2])
				       		$("#book_"+index).show()
				       		$("#hid_zrateid_"+index).val(datas[4])
				       	   	$("#hid_zratevalue_"+index).val(datas[3])
				       	  // 	$("#ALLCabinyouhui_"+index).html(datas[1]+"元")
				       	   	$("#hid_qiangzhibaoxian_"+index).val(datas[5])
				       	 }else{
				       	 	alert("该舱位无优惠!!!");
				       	 
				       	 }
				         
				         }})
		 	 }
</script>
</head>
<body>
<div id="wrap">
<div class="right">
     <div class="box">
     
                 <!--订票流程 begin-->

                            <div class="flow">
                                 <div class="flow-tit">选择航班</div>
                                 <div class="flow-con">
                                      <ul>
                                          <li>① 查询航班</li>
                                        <li class="li-now">② 选择航班</li>
                                          <li>③ 填写订单</li>
                                          <li>④ 生成订单</li>
                                          <li>⑤ 支付订单</li>
                                          <li>⑥ 完成订单</li>
                                      
                                      </ul>
                                 
                                 </div>
                                
                                </div>
       
                             
                 <!--订票流程 begin end-->
                 <div class="clearit"></div> 
                 
                 <!--日期 begin-->
                  <div class="date">
                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                         <tr>
                            <td class="td-now"><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                            <td><a href="#"><span>05-12</span>星期一</a></td>
                         </tr>
                     </table>
                  </div>
                 <!--日期 end-->
                 
                 <div class="ticket-type">
                 <ww:if test="s_traveltype==1">单程</ww:if>
                 <ww:elseif test="s_traveltype==2">往返</ww:elseif>
                 <ww:elseif test="s_traveltype==3">联程</ww:elseif>
                 <ww:else>单程</ww:else>：<ww:if test="s_depcityname==null">
					<ww:property value="getAirCityNamebySZM(s_depcitycode)" />
					</ww:if><ww:else>
						<ww:property value="s_depcityname" />
					</ww:else> --<ww:if
						test="s_arrcityname==null">
						<ww:property value="getAirCityNamebySZM(s_arrcitycode)" />
					</ww:if> <ww:else>
						<ww:property value="s_arrcityname" />
					</ww:else>  &nbsp; <ww:property value="s_startdate" />
				</div>

                 <!--搜索结果展示 begin-->
                    <div class="result-show">
                           <div class="show-tit">
                               <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                   <tr>
                                       <td class="airlines">航空公司</td>
                                       <td class="airlines">航班号</td>
                                       <td class="d-time">起/降时间</td>
                                       <td class="d-city">起飞抵达</td>
                                       <td class="model">机型</td>
                                       <td class="stop">经停</td>
                                       <td class="oil">机场费/燃油</td>
                                       <td class="fare">票面价</td>
                                       <td class="almost"> 返点</td>
                                       <!--
                                       <td class="special">特殊高</td>
                                       -->
                                       <td class="comm">佣金</td>
                                       <td class="price">价格</td>
                                       <td class="operation">操作选项</td>
                                   </tr>
                               </table> 
                           </div>


<form name="form2" id="form2">
<ww:if test="listFlightInfoAll.size()>0">
	<ww:iterator value="listFlightInfoAll" status="state"> 
	
	
	
	<!-- 隐藏域 -->
		<input type="hidden"
			id='hid_lowprice_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.price" />' />
		<input type="hidden"
			id='hid_lowdiscount_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Discount" />' />
		<input type="hidden"
			id='hid_lowyprice_<ww:property value="#state.index" />'
			value='<ww:property value="YPrice" />' />
		<input type="hidden"
			id='hid_lowseatnum_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.SeatNum" />' />
		<input type="hidden"
			id='hid_lowcabincode_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Cabin" />' />
		<input type="hidden"
			id='hid_lowdeparttime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(DepartTime)" />' />
		<input type="hidden"
			id='hid_lowstartairportname_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportName" />' />
		<input type="hidden"
			id='hid_lowstartairport_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirport" />' />
		<input type="hidden"
			id='hid_lowarrivetime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(ArriveTime)" />' />
		<input type="hidden"
			id='hid_lowendairportname_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportName" />' />
		<input type="hidden"
			id='hid_lowendairport_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirport" />' />
		<input type="hidden"
			id='hid_lowflightnumber_<ww:property value="#state.index" />'
			value='<ww:property value="Airline" />' />
		<input type="hidden"
			id='hid_lowaircompany_<ww:property value="#state.index" />'
			value='<ww:property value="AirCompany" />' />
		<input type="hidden"
			id='hid_lowaircompanyname_<ww:property value="#state.index" />'
			value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
		<input type="hidden"
			id='hid_lowflighttype_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneType" />' />
		<input type="hidden"
			id='hid_lowflightdesc_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneTypeDesc" />' />
		<input type="hidden"
			id='hid_lowairportfee_<ww:property value="#state.index" />'
			value='<ww:property value="AirportFee" />' />
		<input type="hidden"
			id='hid_lowfuelfee_<ww:property value="#state.index" />'
			value='<ww:property value="FuelFee" />' />
		<input type="hidden"
			id='hid_lowrules_<ww:property value="#state.index" />'
			value='<ww:property value="rules" />' />

		<!-- 新增加航站楼 -->
		<input type="hidden"
			id='hid_borderpointat_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportHZL"/>' />
		<input type="hidden"
			id='hid_offpointat_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportHZL"/>' />
		<!-- 新增加政策信息 -->
		<input type="hidden"
			id='hid_zrateid_<ww:property value="#state.index" />' value='0' />
		<input type="hidden"
			id='hid_zratevalue_<ww:property value="#state.index" />' value='0' />

		<!-- 新增加强制保险信息 -->
		<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />'
				value='0' />
	
	                                                     
                           <div class="show-con">
                                <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                    <tr>
                                       <td class="airlines"><span><img src="images/airComlogo/<ww:property value="AirCompany" />.gif"/></span><ww:property value="getAirCompanyNameByCode(AirCompany)" /></td>
                                       <td class="airlines"><ww:property value="Airline" /></td>
                                      
                                       <td class="d-time">
                                           <span><ww:property value="formatTimestampHHmm(DepartTime)" /></span>
                                           <span><ww:property value="formatTimestampHHmm(ArriveTime)" /></span>
                                       </td>
                                       <td class="d-city">
                                           <span><ww:property value="StartAirportName" /><ww:property value="StartAirportHZL" /></span>
                                           <span><ww:property value="EndAirportName" /><ww:property value="EndAirportHZL" /></span>
                                       </td>
                                       <td class="model"><ww:property value="AirplaneType" /></td>
                                       <td class="stop">
                                       <ww:if test="isStopInfo.equals(\"1\")">有经停</ww:if><ww:else>
                                        <ww:property value="isStopInfo" />
                                       </ww:else>
                                       </td>
                                       
                                       <td class="oil">
                                           <span><ww:property value="AirportFee" />/<ww:property value="FuelFee" /></span>
                                           <span><b><a id="linkshowcabin_<ww:property value="#state.index" />" href="javascript:void(0);" onclick="showallcabin(<ww:property value="#state.index" />);return false;">所有舱位↓</a></b></span><!-- <img src="b2bair/img/down-arrow.png"/><img src="b2bair/img/up-arrow.png"/> -->
                                       </td>
                                       <td class="fare">￥<ww:property value="formatMoneyToInt(LowCarbin.price)" /></td>
                                       <td class="almost" id="low_fandian_<ww:property value="#state.index" />">8.0%</td>
                                       <!--
                                       <td class="special">特殊高</td>
                                       -->
                                       <td class="comm" id="low_youhui_<ww:property value="#state.index" />">￥0</td>
                                       <td class="price">
                                           <span id="low_zrateprice_<ww:property value="#state.index" />">￥<ww:property value="LowCarbin.price+AirportFee+FuelFee" /></span>
                                           <span class="orange"><ww:property value="LowCarbin.Discount/10" />折<ww:property value="GetCabinType(LowCarbin.Discount,LowCarbin.Special,LowCarbin.cabin)" /></span>
                                      </td>
                                       <td class="operation">
                                           <span>余票<ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9</ww:if><ww:else>
											<ww:property value="LowCarbin.SeatNum" />
										</ww:else></span>
                                           <span id="book_<ww:property value="#state.index" />"><a href="#" onclick='tocreatorder(<ww:property value="#state.index" />,<ww:property value="s_traveltype" />);return false;'><img src="b2bair/img/yuding.gif"/></a></span>
                                       </td> 
                                  </tr>
                                </table>
                                
                                
                               <!-- 所有舱位展示 begin-->
                                     <table id='divallcabin_<ww:property value="#state.index" />'  cellspacing="0" cellpadding="1" align="center" class="all-space" style="display: none;">
                                         <tr class="tr-title">
                                            <td>舱位</td>
                                            <td>票面价</td>
                                            <td>机建/燃油</td>
                                            <td>总价</td>
                                            <td>返点</td>
                                            <td>佣金</td>
                                            <td>余票</td>
                                            <td>总结算价</td>
                                            <td>操作</td>
                                         </tr>
                                         <ww:iterator value="Carbins" status="cabState">
                                         <span id="ALLCabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"></span>
                                         
                                         <tr class="tr-con">
                                            <td class="long-td"><ww:property value="Discount/10" />折<ww:property value="GetCabinType(Discount,Special,cabin)" />(<ww:property value="cabin" />)<b><a href="#">退改签</a></b></td>
                                            <td><ww:property value="formatMoneyToInt(price)" /></td>
                                            <td><ww:property value="AirportFee" />/<ww:property value="FuelFee" /></td>
                                            <td><ww:property value="formatMoneyToInt(price+AirportFee+FuelFee)" /></td>
                                            <td id="ALLCabinfandian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">0%</td>
                                            <td id="ALLCabinyouhui_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">0</td>
                                            <td><ww:property value="SeatNum" /></td>
                                            <td id="ALLCabinPrice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property value="formatMoneyToInt(price)" /></td>
                                            <td><a href="#" onclick="tocreatorder('<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>',<ww:property value="s_traveltype" />);return false;" id="book_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><img src="b2bair/img/yuding.gif"/></a></td>
                                         </tr>
                                         <!-- 隐藏域 -->
					<input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="price" />' /> <input type="hidden"
					id='hid_lowdiscount_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Discount" />' /> <input type="hidden"
					id='hid_lowyprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="YPrice" />' /> <input type="hidden"
					id='hid_lowseatnum_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="SeatNum" />' /> <input type="hidden"
					id='hid_lowcabincode_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Cabin" />' /> <input type="hidden"
					id='hid_lowdeparttime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(DepartTime)" />' /> <input
					type="hidden"
					id='hid_lowstartairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirportName" />' /> <input
					type="hidden"
					id='hid_lowstartairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirport" />' /> <input
					type="hidden"
					id='hid_lowarrivetime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(ArriveTime)" />' /> <input
					type="hidden"
					id='hid_lowendairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirportName" />' /> <input
					type="hidden"
					id='hid_lowendairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirport" />' /> <input type="hidden"
					id='hid_lowflightnumber_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Airline" />' /> <input type="hidden"
					id='hid_lowaircompany_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirCompany" />' /> <input type="hidden"
					id='hid_lowaircompanyname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
				<input type="hidden"
					id='hid_lowflighttype_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneType" />' /> <input
					type="hidden"
					id='hid_lowflightdesc_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneTypeDesc" />' /> <input
					type="hidden"
					id='hid_lowairportfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirportFee" />' /> <input type="hidden"
					id='hid_lowfuelfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="FuelFee" />' /> <input type="hidden"
					id='hid_lowrules_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="rules" />' />
					<!-- 新增加航站楼 -->
				<input type="hidden"
				id='hid_borderpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="StartAirportHZL"/>' />
				<input type="hidden"
				id='hid_offpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="EndAirportHZL"/>' />
					<!-- 新增加政策信息 -->
				<input type="hidden"
				id='hid_zrateid_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				<input type="hidden"
				id='hid_zratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
					<!-- 新增加强制保险信息 -->
				<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
                                         </ww:iterator>
                                         
                                     
                                     </table> 
                                
                                </div>
</ww:iterator>

</ww:if><ww:else>
暂无数据

</ww:else>
                             
                           
                      
 <!-- 隐藏域 --> 
 <input type="text" name="s_traveltype" value="<ww:property value="s_traveltype" />" />
 <input type="text" name="s_depcityname" value="<ww:property value="s_depcityname" />" />
 <input type="text" name="s_depcitycode" value="<ww:property value="s_depcitycode" />" />
 <input type="text" name="s_arrcityname" value="<ww:property value="s_arrcityname" />" />
 <input type="text" name="s_arrcitycode" value="<ww:property value="s_arrcitycode" />" />
 <input type="text" name="s_startdate" value="<ww:property value="s_startdate" />" /> 
 <input type="text" name="s_backdate" value="<ww:property value="s_backdate" />" /> 
 <input type="text" name="s_aircompanycode" value="<ww:property value="s_aircompanycode" />" /> 
 <input type="text" id="hidtravelflag" name="s_travelflag" value="<ww:property value="s_travelflag"/>" /> 
 <input type="text" id="hidtraveltype" value='<ww:property value="s_traveltype" />' /> 
 <input type="text" id="hidsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />' name="s_jasonsegmentinfo" />
  <!-- 隐藏域 -->


                                 
                          
</form>                           
                          
                          
                          

                      </div>

                 <!--搜索结果展示 end-->
                 
                 
     
                 
                 

       </div>
</div>

</div>





</body>
</html>
<script>

</script>