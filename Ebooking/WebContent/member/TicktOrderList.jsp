<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-机票订单列表</title>

<ww:head name="login"/>
<ww:head name="airlines"/>
<ww:head name="index" jsURL="citycontrol" />
<script type="text/javascript">

    //页面加载
    $(document).ready(function()
	   {
	    //返程日期隐藏
	    /**
	    $("#li_returndate").hide();
	    **/
	    <ww:if test="istype==0"> 
       //加载国内城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    </ww:if>
	    <ww:if test="istype==1"> 
      //加载国际城市控件数据
	    $("#txtDepCity").suggest(intercitys,{hot_list:intercommoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(intercitys,{hot_list:intercommoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    </ww:if>
	  
	    <ww:if test="c_scityname==null">
	    //$("#txtDepCity").val("北京");
	   // $("#hidDepCity").val("PEK");
	    //默认加载当日日期
      var d=new Date();
	 // var str = d.format('yyyy-MM-dd');  
	 // $("#txtstartdate").val(str);
	    </ww:if>

	 });
	function checkCity(){
		var txtDepCity=document.getElementById("txtDepCity").value;
		var txtArrCity=document.getElementById("txtArrCity").value;
		if(txtDepCity==""){
			document.getElementById("hidDepCity").value="";
		}
		if(txtArrCity==""){
			document.getElementById("hidArrCity").value="";
		}
	}
</script>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
     <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
     <ww:if test="istype==0">
     <form action="<%=request.getContextPath()%>/login!toTicktOrder.jspx" name="form1" method="post" id="form1">
     </ww:if><ww:else>
     <form action="<%=request.getContextPath()%>/login!toInterTicktOrder.jspx" name="form1" method="post" id="form1">
     </ww:else>
      
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单列表</li>
            <li class="mation_info" style="display: none"><font class="mation_left f"><b>共有<font class="fontxing"><ww:property value="ListOrderinfo.size" /></font>条订单</b></font><span class="f mr25">取消订单（<font class="fontxing"><ww:property value="Cancel" /></font>）</span><font class=" f mr25">完成订单（<font class="fontxing"><ww:property value="complete" /></font>）</font> <font class="f90 f ">待支付订单（<font class="fontxing"><ww:property value="ToBePaid" /></font>）</font> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
          
       </div>
       <div class="mt7 box">
        <div class="tit">
               <font class="black low2 f mr15">订单列表</font>
               <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
        
         <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td  class="hadow hl24" align="right" width="20%">出发城市：</td>
                <td>
                <input type="textg" name="" value="<ww:property value="getAirCityNamebySZM(c_scityname)"/>" id="txtDepCity"   class="text_number"  />
                 <div id='suggest' class="ac_results"></div>
				<input type="hidden" id="hidDepCity" name="c_scityname" value="<ww:property value="c_scityname"/>" />
                 </td>
                <td class="hadow" align="right" width="20%">到达城市：</td>
                <td>
                <input type="textg" name="" value="<ww:property value="getAirCityNamebySZM(c_endcityname)"/>" id="txtArrCity"  class="text_number"  />
                <div id='suggest2' class="ac_results"></div>
		      <input type="hidden" id="hidArrCity" name="c_endcityname" value="<ww:property value="c_endcityname"/>" />
                </td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">起飞时间：</td>
                <td><input type="textg" name="c_stime" value="<ww:property value="c_stime"/>" id="txtstartdate" class="text_number " onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})"  /></td>
                <td class="hadow" align="right" width="20%">到达时间：</td>
                <td><input type="textg" name="c_endtime" value="<ww:property value="c_endtime"/>"  class="text_number" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})"  /></td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">订单编号：</td>
                <td><input type="textg" name="ordercode" value="<ww:property value="ordercode"/>"  class="text_number"  /></td>
                <td class="hadow" align="right" width="20%">航空公司：</td>
                <td>
                <ww:if test="aircode!=null&&aircode!=''">
                 <select class="sel_typed" name="aircode"> 
		           <option value="-1">---所有航空公司---</option>
		           <ww:iterator value="listAircompany">
		          <option <ww:if test="aircode.equals(aircomcode)">selected</ww:if>  value="<ww:property value="aircomcode"/>"><ww:property value="aircomjname"/></option>
		          </ww:iterator>
                </select>
                </ww:if><ww:else>
                 <select class="sel_typed" name="aircode"> 
		           <option value="-1">---所有航空公司---</option>
		           <ww:iterator value="listAircompany">
		          <option  value="<ww:property value="aircomcode"/>"><ww:property value="aircomjname"/></option>
		          </ww:iterator>
                </select>
                </ww:else>
               
                </td>
              </tr>
            </table>
            <div class="search"> <input type="submit" value="订单查询" class="button_searchmeb"  onclick="checkCity()"  /></div>
            <!--listsearch over-->
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td class="hadow hl24">订单号</td>
                <td class="hadow">航班号</td>
                <td class="hadow">出发日期</td>
                <td class="hadow">出发时间,机场</td>
                <td class="hadow">到达时间,机场</td>
                <td class="hadow">价格（含燃油）</td>
                <td class="hadow">支付状态</td>
                <td class="hadow">状态</td>
              </tr>    
              <ww:iterator value="ListOrderinfo">
              <tr>
                <td><a href="login!toTicktOrderInfo.jspx?OrderinfoId=<ww:property value="id" />" class="l06c"><ww:property value="ordernumber" /></a></td>
                <td><span class="airlines airlines_mu f mt3"></span><ww:property value="gethangbanhaobyorderid(id)"/></td>
                <td><ww:property value="formatDate(getsegmentinfobyid(id).departtime)"/></td>
                <td><ww:property value="formatTimestampHHmm(getsegmentinfobyid(id).departtime)"/>
                <ww:if test="internal==0">
                 <ww:property value="getCitynameByAirport(getSeg_startairport(id))"/>
                </ww:if><ww:else>
                 <ww:property value="getInterCitynameByAirport(getSeg_startairport(id))"/>
                </ww:else>
                
                 </td>
                <td><ww:property value="formatTimestampHHmm(getsegmentinfobyid(id).arrivaltime)"/>
                  <ww:if test="internal==0">
                 <ww:property value="getCitynameByAirport(getSeg_endairport(id))"/>
                 </ww:if><ww:else>
                  <ww:property value="getInterCitynameByAirport(getSeg_endairport(id))"/>
                 </ww:else>
                 </td>
                <td><font class="font18f60">¥<ww:property value="formatMoney_string(totalticketprice+totalfuelfee+totalairportfee+getIssurByOrderid_B2b(id))"/></font></td> 
                <td><ww:if test="paystatus==0">未支付</ww:if><ww:else>已支付</ww:else></td>
                <td><font class="l06c" ><ww:property value="getStateToString(orderstatus)"/></font></td>   
              </tr>
              </ww:iterator>   
             
            </table>
            <div>&nbsp;</div>
            
             <div align="center">
 
  <span >&nbsp;
   <ww:if test="istype==0">
  <ww:property value="getPagination('\"login!toTicktOrder.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/>
  </ww:if><ww:else>
   <ww:property value="getPagination('\"login!toInterTicktOrder.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/>
  </ww:else>
  &nbsp;</span>
  
    </div>
        </div>
       </div> 
       
   </div>
   </form>
</div>
<ww:include page="../footer.jsp"/> 
</body>
</html>
