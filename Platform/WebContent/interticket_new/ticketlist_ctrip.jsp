<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="interticket_new/css/inter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/interticketcity.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/j.dimensions.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />

<script type="text/javascript"> 
$(function(){
    LoadCityData();
    $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
	$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
	selectTripType(0);
});
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
		function colsedispose(){
		 Ext.MessageBox.hide();
		}
function selectTripType(val){
	switch(val){
		case 0:
			$('#returnDateWrapper,#dc,#tjxc').hide();
			$('#wf').show();
			break;
		case 1:
			$('#returnDateWrapper,#wf').show();
			$('#dc,#tjxc').hide();
			break;
		case 2:
			$('#returnDateWrapper,#wf').hide();
			$('#dc,#tjxc').show();
			break;
	}
}
function CheckData()
    {
        var rdoFrom=document.getElementById("tripTyperound");
        var rdoOnlone=document.getElementById("tripTypesingle");
        
        if($("#city_from_hide").val()=="" || $("#arrcity").val()=="" || $("#arrcity").val()=="中文/拼音")//中文/拼音
        {
            alert("出发城市为必填项,请检查后重新填写！");
            $("#arrcity").focus();
            return false;
        }
        if($("#tocity").val()=="中文/拼音"||$("#city_to_hide").val()=="" || $("#tocity").val()=="")
        {
            alert("到达城市为必填项,请检查后重新填写！");
            $("#tocity").focus();
            return false; 
        }
        if($("#txtStartDate").val()=="")
        {
           alert("出发日期为必填项,请检查后重新填写！");
           $("#txtStartDate").focus();
           return false;
        }
        if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
        {
            alert("返程时间不能为空！");
            $("#txtBackDate").focus();
            return false;
        }
        else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
        {
             alert("返程日期不能早于出发日期,请检查后重新填写！");
             $("#txtBackDate").focus();
             return false; 
         }
         
         if(!IsNumber($("#adultCount").val()))
         {
             alert("乘客人数只能是数字，请检查后重新填写!");
             $("#adultCount").focus();
             return false; 
         }
         
         dispose("正在查询国际航班");
        
    }

</script>
</head>
<body>
<div id="wrap">
<div class="right">
     <div class="box">

           <!--  搜索框开始-->
          <form action="interticket!search.action" name="form1" id="form1" method="POST" onSubmit="return CheckData()">
                 <div class="search-form">   
                        <div class="sail">
                                 <select name="intTravelType">
                                          <option value="2">往返</option>
                                          <option value="1" selected="selected">单程</option>
                                  </select>
                        </div>  
                        
                        <div class="sail-con">
                                <div class="Ordinary-search">
                                       <div class="start-city">出发城市 <input type="text" id="arrcity"
								name="fromCity" value="<ww:property value="fromCity"/>"
								onfocus="if(this.value='<ww:property value="fromCity"/>'){this.value='';}"
								onblur="if(this.value=='') {this.value='<ww:property value="fromCity"/>';}" />
								<div id='suggest' class="ac_results"></div>
							    <input type="hidden" id="city_from_hide" value="<ww:property value="StartAirportCode"/>" name="StartAirportCode" />
								
								</div>
								
                                       <div class="arrive-city">到达城市 <input type="text" value="<ww:property value="toCity"/>" name="toCity"
								id="tocity" />
                                       <div id='suggest2' class="ac_results"></div>
							<input type="hidden" id="city_to_hide" name="EndAirportCode" value="<ww:property value="EndAirportCode"/>" />
                                       
                                       </div>
                                       <div class="start-date">去程日期 <input type="text" id="txtStartDate"
								name="fromDate" value="<ww:property value="fromDate"/>"
								onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
								class="Wdate" /></div>
                                       <div class="arrive-date" style="display: none;">返程日期 <input type="text" value="" /></div>
                                
                                </div>
                                <div class="clearit"></div>
                                <div class="senior-search" style="display:block">
                                		<div class="spaces">      
                                              中转类型 <select name="TypeFlag">
                                                        <option value="0" <ww:if test="TypeFlag.equals(\"0\")">selected</ww:if>>所有</option>
														<option value="1" <ww:if test="TypeFlag.equals(\"1\")">selected</ww:if>>直飞</option>
														<option value="2" <ww:if test="TypeFlag.equals(\"2\")">selected</ww:if>>中转</option>
                                                      </select> 
                                          </div>
                                          
                                        <div class="spaces">
                                          舱位等级 <select name="seatType">
                                                <option value="Y" <ww:if test="seatType.equals(\"Y\")">selected</ww:if>>经济</option>
                                                <option value="C" <ww:if test="seatType.equals(\"C\")">selected</ww:if>>商务</option>
                                                <option value="F" <ww:if test="seatType.equals(\"F\")">selected</ww:if>>头等</option>
                                              </select>
                                         </div>
                                         
                                         <div class="spaces">   
                                           乘客类型 <select name="passengerType">
                                                <option value="1" selected="selected">成人</option>
                                                <option value="2" >儿童</option>
                                              </select> 
                                          </div>
                                          
                                          <div class="spaces">   
                                            乘客数量 <select name="adultCount">
                                                <option value="1" selected="selected">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                              </select> 
                                           </div>
                                             
                                          
                                      
                                </div>
                        
                        </div>
                        
                        <div class="search-btn"><a href="#"><img src="interticket_new/img2/search3.png" width="50"  height="24" onclick="seachform();" /></a><a href="#" style="display: none;" class="senior"><b>高级搜索</b></a></div>
                 
                 </div>
                 
                 <input name="SortingField" type="hidden" id="SortingField" value="<ww:property value="SortingField"/>" />
                 <input name="Direction" type="hidden" id="Direction" value="<ww:property value="Direction"/>" />
                 </form>
                 
              <!--  搜索框结束-->  
                
                  <div class="ticket-type"><ww:property value="fromCity"/>--<ww:property value="toCity"/><font>(<ww:property value="fromDate"/>  <ww:property value="listInterFlightInfo.size"/>个航班)?????????</font></div>
                  
                  
             <!-- 搜索结果开始-->
             
                  <div class="inter-resu">
                         <div class="inter-tit">
                                <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                   <tr>
                                       <td class="default" style="cursor:pointer;color:#fff;line-height:45px;" onclick="softByMr('Price','ASC');return false;">默认排序</td>
                                       <td class="d-time" style="cursor:pointer;color:#fff;line-height:45px;" onclick="softBy('DepartureTime');return false;">起飞时间</td>
                                       <td class="e-city" style="cursor:pointer;color:#fff;line-height:45px;"  onclick="softBy('ArrivalTime');return false;">到达时间</td>
                                       <td class="flight-time" style="cursor:pointer;color:#fff;line-height:45px;"  onclick="softBy('FlightDuration');return false;">航程时间</td> 
                                      <td class="price" style="cursor:pointer;color:#fff;line-height:45px;" onclick="softBy('Price');return false;">价格</td>
                                   </tr>
                               </table> 
                         </div>
                        <!--第一条结果中转样式开始 --> 
                         	<ww:iterator value="listInterFlightInfo" status="ind">
                             <div class="inter-con">
                         
                                <div class="inter-con-a">
                                    <div class="inter-con-1">
                                        <div class="flight-img">
                                        <ww:if test="FlightInfos.size==1">
                                           <img src="images/airComlogo/<ww:property value="FlightInfos[0].AirCompany"/>.gif" width="40" height="35" />
                                        </ww:if><ww:else>
	                                        <ww:if test="FlightInfos[0].AirCompany==FlightInfos[1].AirCompany">
	                                        <img src="images/airComlogo/<ww:property value="FlightInfos[0].AirCompany"/>.gif" width="40" height="35" />
	                                        </ww:if><ww:else>
	                                        <img src="interticket_new/img2/multi.png" width="40" height="35" />
	                                        </ww:else>
                                        
                                        </ww:else>
                                        </div>
                                        
                                          
                                        <div class="flight">
                                             <div class="flight-name">
                                             <ww:if test="FlightInfos.size==1">
                                             <ww:property value="FlightInfos[0].AirCompanyName"/>
                                             </ww:if>
                                             <ww:else>
		                                        <ww:if test="FlightInfos[0].AirCompany==FlightInfos[1].AirCompany">
		                                        <ww:property value="FlightInfos[0].AirCompanyName"/>
		                                        </ww:if><ww:else>
		                                       	多个航司
		                                        </ww:else>
	                                        </ww:else>
                                             </div>
                                             <div class="flight-num">
                                            
                                             <ww:if test="FlightInfos.size==1">
                                             <ww:property value="FlightInfos[0].Airline"/>
                                             </ww:if>
                                             <ww:else>
		                                        <ww:if test="FlightInfos[0].AirCompany==FlightInfos[1].AirCompany">
		                                         <ww:property value="FlightInfos[0].Airline"/>
		                                        </ww:if><ww:else>
		                                        <ww:property value="FlightInfos.size"/>个航班
		                                        </ww:else>
	                                        </ww:else>
                                             
                                             </div>
                                        </div>   
                                  </div>
                                  
                                  <div class="inter-con-2">
                                        <div class="start">
                                              <b><ww:property value="FlightInfos[0].DepartTime.substring(6,11)"/></b>
                                              <font><ww:property value="FlightInfos[0].StartAirportName"/><ww:property value="FlightInfos[0].StartAirportHZL"/></font>
                                        </div>
                                          
                                        <div class="icon1">
                                        <ww:if test="FlightInfos.size==1">
                                        <img src="interticket_new/img2/icon2.png" width="74" height="16" /> 
                                        </ww:if><ww:else>
                                        <img src="interticket_new/img2/icon1.png" width="74" height="16" /> 
                                        </ww:else>
                                             
                                             
                                        </div>
                                        <ww:if test="FlightInfos.size==1">
                                         <div class="arrival">
                                             <b><ww:property value="FlightInfos[0].ArriveTime.substring(6,11)"/></b>
                                              <font><ww:property value="FlightInfos[0].EndAirportName"/><ww:property value="FlightInfos[0].EndAirportHZL"/></font>
                                        </div> 
                                        </ww:if><ww:else>
                                         <div class="arrival">
                                            <b><ww:property value="FlightInfos[1].ArriveTime.substring(6,11)"/></b>
                                              <font><ww:property value="FlightInfos[1].EndAirportName"/><ww:property value="FlightInfos[1].EndAirportHZL"/></font>
                                        </div> 
                                        </ww:else>
                                         
                                  </div>
                                  
                                  <div class="inter-con-3">
                                  <ww:if test="FlightInfos.size>1">
                                  <font><ww:property value="formatflotMoneyB2B(FlightInfos[0].Duration)+formatflotMoneyB2B(FlightInfos[1].Duration)"/>分钟</font>
                                  </ww:if><ww:else>
                                  <font><ww:property value="formatflotMoneyB2B(FlightInfos[0].Duration)"/>分钟</font>
                                  </ww:else>
                                          
                                          <ww:if test="FlightInfos.size>1">
                                          <font><img src="interticket_new/img2/zhongzhuan.png" width="13" height="13" /><strong><ww:property value="FlightInfos[1].StartCityName"/></strong></font>
                                          </ww:if><ww:else>
                                          	直飞
                                          </ww:else>
                                  </div>
                                  
                                    <div class="inter-con-4">
                                          <a href="#" onclick="ShowAirInfo('airinfo_<ww:property value="#ind.index"/>');return false;">航班详情(展开)</a>
                                   </div>
                                </div>
                                
                                
                               <!-- 航班详情开始-->
                                 <div class="flight-detail" style="display:none;" id="airinfo_<ww:property value="#ind.index"/>">
                                 	<ww:iterator value="FlightInfos" status="index">
                                       <div class="flight-detail-start">
                                           <img src="images/airComlogo/<ww:property value="FlightInfos[#index.index].AirCompany"/>.gif" width="40" height="35" />
                                           <p><span><ww:property value="AirCompanyName"/></span> <span><ww:property value="Airline"/></span><span><ww:property value="AirplaneType"/></span></p>
                                           <p><span><ww:property value="DepartTime.substring(0,5)"/></span><span><ww:property value="DepartTime.substring(6,11)"/></span><span><ww:property value="StartAirport"/></span><span class="start-space"><ww:property value="StartAirportName"/><ww:property value="StartAirportHZL"/></span></p>
                                           <p><span><ww:property value="ArriveTime.substring(0,5)"/></span><span><ww:property value="ArriveTime.substring(6,11)"/></span><span><ww:property value="EndAirport"/></span><span class="start-space"><ww:property value="EndAirportName"/><ww:property value="EndAirportHZL"/></span><span class="fly-time">飞行时长 <ww:property value="Duration"/>分</span></p>
                                       </div>
                                       	<ww:if test="FlightInfos.size>1&&#index.index==0">
                                       	 <div class="flight-detail-midd">
                                             <div class="section-stop"><b><ww:property value="FlightInfos[1].StartCityName"/></b>   中转   </div>
                                        </div>
                                        
                                        
                                       	</ww:if>
                                       	
                                       	
                                       	
                                       	
                                       	<!-- 隐藏域航班信息 -->
                                       	  <input type="hidden" id="airno_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="Airline"/>" />
                                       	  <input type="hidden" id="airname_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="AirCompanyName"/>" />
                                       	  <input type="hidden" id="aircode_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="FlightInfos[#index.index].AirCompany"/>" />
                                       	  <input type="hidden" id="DepartTime_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="DepartTime"/>" />
                                       	  <input type="hidden" id="ArriveTime_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="ArriveTime"/>" />
                                       	  <input type="hidden" id="StartAirport_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="StartAirport"/>" />
                                       	  <input type="hidden" id="StartAirportName_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="StartAirportName"/>" />
                                          <input type="hidden" id="StartAirportHZL_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="StartAirportHZL"/>" />
                                          
                                           <input type="hidden" id="AirplaneType_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="AirplaneType"/>" />
                                       	 
                                          
                                          
                                          
                                           <input type="hidden" id="EndAirport_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="EndAirport"/>" />
                                       	  <input type="hidden" id="EndAirportName_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="EndAirportName"/>" />
                                          <input type="hidden" id="EndAirportHZL_<ww:property value="#ind.index"/>_<ww:property value="#index.index"/>" name=""  value="<ww:property value="EndAirportHZL"/>" />
                                     </ww:iterator>
                                     
                                     	
                                       	
                                 </div>
                               <!-- 航班详情结束--> 
                                
                                <div class="inter-con-b">
                                
                                      <div class="inter-con-5">代理</div>
                                      <div class="inter-con-6">
                                      <ww:if test="seatType.equals(\"Y\")">经济舱</ww:if> <ww:if test="seatType.equals(\"C\")">商务舱</ww:if> <ww:if test="seatType.equals(\"F\")">头等舱</ww:if>
                                                 
                                      </div>
                                      
                                      <div class="inter-con-7">
                                            <a href="#" onclick="showtgq('tuigaiqian_<ww:property value="#ind.index"/>');return false;">退签及改签说明</a>
                                      </div>
                                      <!--  -->
                                      <div class="inst-box" style="display: none;" id="tuigaiqian_<ww:property value="#ind.index"/>">
                                         <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                               <tr>
                                                   <td>退改签说明</td>
                                                   <td><a href="#" onclick="hide_tgq('tuigaiqian_<ww:property value="#ind.index"/>');return false;">关闭</a></td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">更改条件</td>
                                                   <td>以航司审核为准!</td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">未使用退票条件</td>
                                                   <td>以航司审核为准!</td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">签转条件</td>
                                                   <td>以航司审核为准!</td>
                                               </tr>
                                                <tr>
                                                   <td colspan="2">
                                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                                            <tr><td>罚金说明</td></tr>
                                                            <tr><td style="border:0">误机不得退票</td></tr>
                                                            <tr><td style="border:0">托行李金额</td></tr>
                                                       </table>     
                                                   
                                                   </td>
                                                  
                                               </tr>
                                                <tr>
                                                   <td class="bg">第一程</td>
                                                   <td>普通乘客：20公斤</td>
                                               </tr>
                                              
                                               <tr>
                                                   <td colspan="2">
                                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                                            <tr><td>购票限制</td></tr>
                                                            <tr><td style="border:0">1.限立即出票</td></tr>
                                                            <tr><td style="border:0">备注</td></tr>
                                                            <tr><td style="border:0">补充附加:</td></tr>
                                                       </table>     
                                                   
                                                   </td>
                                                  
                                               </tr>
                                        </table> 
                                      
                                      </div>
                                      <!--  -->
                                      <div class="inter-con-8">
                                             <b>￥<ww:property value="interPrice.xcprice"/></b>起
                                      </div>
                                      
                                        <div class="inter-con-9">
                                            <a href="#"><img src="interticket_new/img2/yuding-btn.gif" onclick="ToCreateOrder('<ww:property value="#ind.index"/>');return false;" width="68" height="26" /></a><font>&nbsp;</font><!-- 1张余票 -->
                                       </div>
                                       
                                     
                                      
                                </div>
                                
                               
                                   <div class="inter-con-c">
                                
                                      <div class="inter-con-10">
                                            <font>税费￥<ww:property value="interPrice.AirPrice"/>起</font>
                                      </div>
                                      
                                        <div class="inter-con-11">
                                            <a href="#">更多价格</a>
                                       </div>
                                </div>
                              
                           
                             
                            
                         </div>
                         <!-- 隐藏域开始 -->
                         
                        		 		<ww:if test="FlightInfos.size>1">
                                       	<input type="hidden" id="iszhongzhuan_<ww:property value="#ind.index"/>" name="iszhongzhuan"  value="2" />
                                       	</ww:if>
                                       	<ww:else>
                                       	 <input type="hidden" id="iszhongzhuan_<ww:property value="#ind.index"/>" name="iszhongzhuan"  value="1" />
                                       	</ww:else>
                                       	
                                       	
                         <input type="hidden" id="StartAirportCode_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="StartAirportCode"/>" />
                         <input type="hidden" id="EndAirportCode_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="EndAirportCode"/>" />
                         <input type="hidden" id="fromDate_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="fromDate"/>" />
                         
                         
                         <input type="hidden" id="DepartTime_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].DepartTime"/>" />
                         <input type="hidden" id="StartAirportName_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].StartAirportName"/>" />
                         <input type="hidden" id="StartAirportHZL_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].StartAirportHZL"/>" />
                          
                          <ww:if test="FlightInfos.size==1">
                         <input type="hidden" id="DepartTime_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].DepartTime"/>" />
                         <input type="hidden" id="EndAirportName_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].EndAirportName"/>" />
                         <input type="hidden" id="EndAirportHZL_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[0].EndAirportHZL"/>" />
                         <input type="hidden" id="feixingtime_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="formatflotMoneyB2B(FlightInfos[0].Duration)"/>" />
                         
                          </ww:if><ww:else>
                         <input type="hidden" id="DepartTime_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[1].ArriveTime"/>" />
                         <input type="hidden" id="EndAirportName_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[1].EndAirportName"/>" />
                         <input type="hidden" id="EndAirportHZL_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="FlightInfos[1].EndAirportHZL"/>" />
                         <input type="hidden" id="feixingtime_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="formatflotMoneyB2B(FlightInfos[0].Duration)+formatflotMoneyB2B(FlightInfos[1].Duration)"/>" />
                         </ww:else>
                         
                          <input type="hidden" id="AirPrice_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="interPrice.AirPrice"/>" />
                          <input type="hidden" id="xcprice_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="interPrice.xcprice"/>" /> 
                          <input type="hidden" id="piaomianjia_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="interPrice.hsprice"/>" />   
                          
                          <input type="hidden" id="seatType_<ww:property value="#ind.index"/>" name=""  value="<ww:property value="seatType"/>" /> 
                          
                          
                         
                         <!-- 隐藏域介绍 -->
                  </ww:iterator>
                  </div>
             
             
             
             
             
             <!-- 搜索结果结束-->     
             
                       <!--第一条结果中转样式结束 -->
                       
                       <!--第二条结果直飞样式开始 -->
             
                            <div class="inter-con" style="display: none;">
                         
                                <div class="inter-con-a">
                                    <div class="inter-con-1">
                                        <div class="flight-img">
                                           <img src="interticket_new/img2/MU.png" width="40" height="35" />
                                        </div>
                                          
                                        <div class="flight">
                                             <div class="flight-name">东方航空</div>
                                             <div class="flight-num">CH1212</div>
                                        </div>   
                                  </div>
                                  
                                  <div class="inter-con-2">
                                        <div class="start">
                                              <b>11:00</b>
                                              <font>咸阳国际机场T2</font>
                                        </div>
                                          
                                        <div class="icon1">
                                             <img src="interticket_new/img2/icon2.png" width="74" height="16" /> 
                                        </div>
                                        
                                        <div class="arrival">
                                             <b>12:00</b>
                                              <font>香港际机场T1</font>
                                        </div>   
                                  </div>
                                  
                                  <div class="inter-con-3">
                                          <font>3小时45分钟</font>
                                          <font>直飞</font>
                                  </div>
                                  
                                    <div class="inter-con-4">
                                          <a href="#">航班详情(展开)</a>
                                   </div>
                                </div>
                                
                                
                               <!-- 航班详情开始-->
                                 <div class="flight-detail" style="display:block">
                                       <div class="flight-detail-start">
                                       
                                           <img src="interticket_new/img2/MU-s.png" width="40" height="35" /> 
                                           <p><span>大韩航空</span> <span>CH232</span></p>
                                           <p><span>10月22日</span><span>19:30</span><span>XIY</span><span class="start-space">咸阳国际机场T3</span><span class="fly-time">飞行时长 2小时15分</span></p>
                                           <p><span>10月22日</span><span>19:30</span><span>XIY</span><span class="start-space">咸阳国际机场T3</span><span class="fly-time">飞行时长 2小时15分</span></p>
                                       </div>                                  
                                 </div>
                               <!-- 航班详情结束--> 
                                
                                <div class="inter-con-b">
                                
                                      <div class="inter-con-5">代理</div>
                                      <div class="inter-con-6">
                                              经济舱    
                                      </div>
                                      
                                      <div class="inter-con-7">
                                            <a href="#">退签及改签说明</a>
                                      </div>
                                       <!-- 退改签详细说明开始-->
                                      <div class="inst-box">
                                         <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                               <tr>
                                                   <td>退改签说明</td>
                                                   <td></td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">更改条件</td>
                                                   <td>人民币400元</td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">未使用退票条件</td>
                                                   <td>人民币400元</td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">签转条件</td>
                                                   <td>人民币400元</td>
                                               </tr>
                                                <tr>
                                                   <td colspan="2">
                                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                                            <tr><td>罚金说明</td></tr>
                                                            <tr><td style="border:0">误机不得退票</td></tr>
                                                            <tr><td style="border:0">托行李金额</td></tr>
                                                       </table>     
                                                   
                                                   </td>
                                                  
                                               </tr>
                                                <tr>
                                                   <td class="bg">第一程</td>
                                                   <td>西安——香港:普通乘客：20公斤</td>
                                               </tr>
                                               <tr>
                                                   <td class="bg">第二程</td>
                                                   <td>西安——香港:普通乘客：20公斤</td>
                                               </tr>
                                               <tr>
                                                   <td colspan="2">
                                                       <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                                            <tr><td>购票限制</td></tr>
                                                            <tr><td style="border:0">1.限立即出票</td></tr>
                                                            <tr><td style="border:0">备注</td></tr>
                                                            <tr><td style="border:0">补充附加:</td></tr>
                                                       </table>     
                                                   
                                                   </td>
                                                  
                                               </tr>
                                        </table> 
                                      
                                      </div>
                                      
                                      <!-- 退改签详细说明结束-->
                                      
                                      <div class="inter-con-8">
                                             <b>￥960</b>起
                                      </div>
                                      
                                        <div class="inter-con-9">
                                            <a href="#"><img src="interticket_new/img2/yuding-btn.gif" width="68" height="26" /></a><font>1张余票</font>
                                       </div>
                                       
                                     
                                </div>

                                   <div class="inter-con-c">
                                
                                      <div class="inter-con-10">
                                            <font>税费￥234起</font>
                                      </div>
                                      
                                        <div class="inter-con-11">
                                            <a href="#">更多价格</a>
                                       </div>
                                </div>
                              
                           
                             
                            
                         </div>
                  
                  </div>
             
             
             
             
             
             <!-- 搜索结果结束-->     
             
                       <!--第二条结果直飞样式结束 -->
                
       </div>
</div>

</div>
<form action="interticket!toCreateInterTicketOrder2.action" id="form2" name="form2" method="post">
 <input type="hidden" id="hidsegmentinfo" name="s_jasonsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />'  />
 <input type="hidden" id="hidtraveltype"  name="intTravelType" value='<ww:property value="intTravelType" />' /> 
 
 <input type="hidden"  value="<ww:property value="StartAirportCode"/>" name="StartAirportCode" />
 <input type="hidden"  value="<ww:property value="EndAirportCode"/>" name="EndAirportCode" />
 <input type="hidden"  value="<ww:property value="fromCity"/>" name="fromCity" />
 <input type="hidden"  value="<ww:property value="toCity"/>" name="toCity" />

 <input type="hidden" id="fromDate"  name="fromDate" value="<ww:property value="fromDate"/>" />

</form>
</body>
</html>
<script type="text/javascript">
function ShowAirInfo(id){

var te=$("#"+id).is(":hidden");
if(te==false){
$("#"+id).hide();
}else{
$("#"+id).show();
}
}
function showtgq(id){

var te=$("#"+id).is(":hidden");
if(te==false){
$("#"+id).hide();
}else{
$("#"+id).show();
}
}
function seachform(){
 dispose("正在查询国际航班");
document.form1.submit();

}


function softBy(va){
$("#SortingField").val(va);


var te=$("#Direction").val();
if(te=='ASC'){
$("#Direction").val("DESC");
}else{
$("#Direction").val("ASC");
}

 dispose("正在查询国际航班");
document.form1.submit();

}
function softByMr(va,vw){
$("#Direction").val(vw);
$("#SortingField").val(va);
 dispose("正在查询国际航班");
document.form1.submit();
}


function hide_tgq(va){

$("#"+va).hide();
}

function ToCreateOrder(ind){

var iszhongzhuan=$("#iszhongzhuan_"+ind).val();
if(iszhongzhuan=='1'){
 bindsegmentinfo(ind,'0');
}
if(iszhongzhuan=='2'){
bindsegmentinfo(ind,'0');
bindsegmentinfo(ind,'1');
}

document.form2.submit();

//window.location.href="interticket!toCreateInterTicketOrder2.action";


}

function bindsegmentinfo(ind,index)
	  {
	 // alert(index);
	    var JasonString = {"segmentinfos": [    
            {
           	  "sday": $("#fromDate").val(),
              "flightnumber": $("#airno_"+ind+"_"+index).val(),
              "aircomapnycode": $("#aircode_"+ind+"_"+index).val(),
              "airname": $("#airname_"+ind+"_"+index).val(),
              "airportfee":$("#AirPrice_"+ind).val(),
              "fuelfee":"0",
              "departtime":$("#DepartTime_"+ind+"_"+index).val(),
              "arrivaltime":$("#ArriveTime_"+ind+"_"+index).val(),
              "cabincode":$("#seatType_"+ind).val(),
              "price":$("#xcprice_"+ind).val(),
              "discount":"100",
              "yprice":$("#piaomianjia_"+ind).val(),
              "traveltype":$("#hidtraveltype").val(),
              "isspecial":"",
              "startairport":$("#StartAirport_"+ind+"_"+index).val(),
              "startairportname":$("#StartAirportName_"+ind+"_"+index).val(),
              "endairport":$("#EndAirport_"+ind+"_"+index).val(),
              "endairportname":$("#EndAirportName_"+ind+"_"+index).val(),
              "rules":"",
              "ratevalue":"",
              "borderpointat":$("#StartAirportHZL_"+ind+"_"+index).val(),
              "offpointat":$("#EndAirportHZL_"+ind+"_"+index).val(),
              "parvalue":"0",
              "agentid":"",
              "zrateid":"0",
              "flightdesc":"",
              "flightmodel":$("#AirplaneType_"+ind+"_"+index).val(),
              "qiangzhibaoxian":"0"
              }  
            ]};
            
            
            
            //alert(JasonString);
            if($("#hidsegmentinfo").val()!="" && $("#hidsegmentinfo").val().indexOf('@')<0)
            {
              $("#hidsegmentinfo").val($("#hidsegmentinfo").val()+"@"+JSON.stringify(JasonString));
            }
            else
            {
               $("#hidsegmentinfo").val(JSON.stringify(JasonString));
            }
            

	  }

</script>