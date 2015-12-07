<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-团队/包机订单</title>

<link href="skin/blue/css/login.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/airlines.css" rel="stylesheet" type="text/css" />


<ww:head name="index" jsURL="member" />
<script type="text/javascript">
var staus="-1";
    //页面加载
    $(document).ready(function()
	   {
	    //返程日期隐藏
	    /**
	    $("#li_returndate").hide();
	    **/
	    //加载城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	   <ww:if test="c_scityname==null">
	    //$("#txtDepCity").val("北京");
	   // $("#hidDepCity").val("PEK");
	    //默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  //$("#txtstartdate").val(str);
	    </ww:if>
	 });
	
</script>
<script type="text/javascript">
	function checkTime(){
		var c_stime=document.getElementById("txtstartdate").value;
		var c_endtime=document.getElementById("c_endtime").value;
		if(c_stime>c_endtime){
			staus="-1";	
		}else{
		staus="1";	
		}
		if(staus=='-1'){
			alert("起始时间不能大于到达时间！");
	 		return false;
		}else{
			document.form1.submit();
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
  <form action="<%=request.getContextPath()%>/login!tocharterlist.jspx" name="form1" method="post" id="form1">
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单列表</li>
            <li class="mation_info">
                <font class="mation_left f"><b>共有<font class="fontxing"><ww:property value="ListCharterorder.size"/></font>条订单</b></font>
                <span class="f mr25">待审核（<font class="fontxing"><ww:property value="Unaudited"/></font>）</span>
                <font class=" f mr25">等待报价（<font class="fontxing"><ww:property value="WaitPrice"/></font>）</font> 
                <font class="mr25 f ">已报价（<font class="fontxing"><ww:property value="AlreadyPrice"/></font>）</font>
                <font class="mr25 f ">审核不通过（<font class="fontxing"><ww:property value="notpassed"/></font>）</font> 
                <span class="r mation_right">&nbsp;</span>    
            </li>
          </ul>
       </div>
       <div class="mt7 box">
        <div class="title">
               <font class="black low2 f mr15">订单列表</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td  class="hadow hl24" align="right" width="80">订单日期：</td>
                <td colspan="5">
                <input type="text" style="width: 90px;" name="c_stime"  value="<ww:property value="formatDate(c_stime)"/>" id="txtstartdate" class="text_name" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})" /> - 
                <input type="text" style="width: 90px;" name="c_endtime" id="c_endtime" value="<ww:property value="formatDate(c_endtime)"/>"  class="text_name mr25" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})"  /><font class="mlr f00">温馨提示:查看订单信息请在包机申请单中查看</font> </td>
              </tr>
              <tr>
                <td  class="hadow hl24" align="right" width="80">出发城市：</td>
                <td><input type="text"  class="text_number" id="txtDepCity"  value="<ww:property value="getAirCityNamebySZM(c_scityname)"/>" />
                 <div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="c_scityname" value="<ww:property value="c_scityname"/>" />
                 </td>
                <td class="hadow" align="right" width="80">订单编号：</td>
                <td><input type="text"  class="text_number" name="ordercode" value="<ww:property value="ordercode"/>"  /></td>
                <td class="hadow" align="right" width="80">航空公司：</td>
                <td><select class="sel_typed" name="aircode"> 
		           <option <ww:if test="aircode.equals('-1')">selected</ww:if> value="-1">---所有航空公司---</option>
		           <ww:iterator value="listAircompany">
		          <option <ww:if test="aircode.equals(aircomcode)">selected</ww:if>  value="<ww:property value="aircomcode"/>"><ww:property value="aircomjname"/></option>
		          </ww:iterator>
                </select></td>
              </tr>
              <tr>
                <td  class="hadow hl24" align="right" width="80">到达城市：</td>
                <td><input type="text"  class="text_number" id="txtArrCity" value="<ww:property value="getAirCityNamebySZM(c_endcityname)"/>"  />
                
                <div id='suggest2' class="ac_results"></div>
		      <input type="hidden" id="hidArrCity" name="c_endcityname" value="<ww:property value="c_endcityname"/>" />
                 </td>
                <td class="hadow" align="right" width="80">订单状态：</td>
                <td><select class="sel_typed" name="c_stste">
                
                 <option <ww:if test="c_stste.equals(\"-1\")">selected</ww:if> value="-1">全部</option>
                 <option <ww:if test="c_stste.equals(\"1\")">selected</ww:if> value="1">新订单待审核</option>
                 <option <ww:if test="c_stste.equals(\"2\")">selected</ww:if> value="2">已审核,待报价</option>
                 <option <ww:if test="c_stste.equals(\"3\")">selected</ww:if> value="3">审核不通过</option>
                 <option <ww:if test="c_stste.equals(\"4\")">selected</ww:if> value="4">已报价</option>
                 <option <ww:if test="c_stste.equals(\"5\")">selected</ww:if> value="5">报价不接受</option>
                 <option <ww:if test="c_stste.equals(\"6\")">selected</ww:if> value="6">报价接受,待支付</option>
                 <option <ww:if test="c_stste.equals(\"7\")">selected</ww:if> value="7">支付成功</option>
                 <option <ww:if test="c_stste.equals(\"8\")">selected</ww:if> value="8">支付不成功</option>
                 <option <ww:if test="c_stste.equals(\"9\")">selected</ww:if> value="9">支付成功,未乘机</option>
                 <option <ww:if test="c_stste.equals(\"10\")">selected</ww:if> value="10">交易结束</option>
                 <option <ww:if test="c_stste.equals(\"11\")">selected</ww:if> value="11">已取消</option>
                 
                 </select></td>
                <td class="hadow" align="right" width="80">航班号：</td>
                <td><input type="text"  class="text_number" name="s_fnumber" value="<ww:property value="s_fnumber"/>"  /></td>
              </tr>
            </table>
            <div class="search"> <input type="button" value="立即查询" class="button_searchmeb" onclick="checkTime()"/><font class="f00">根据您所知道的内容进行查询，数据量较大可能会查询较慢，请您耐心等待！</font></div>
            <!--listsearch over-->
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td class="hadow hl24">订单号</td>
                <td class="hadow">类型</td>
                <td class="hadow">预订日期</td>
                <td class="hadow">人数</td>
                <td class="hadow">航班号</td>
                <td class="hadow">航程</td>
                <td class="hadow">航空公司</td>
                <td class="hadow">出发日期</td>
                <td class="hadow">订单状态</td>
                <td class="hadow">操作</td>
              </tr>
              <ww:iterator value="ListCharterorder">
              <tr>
                <td><a href="login!toCharterOrderInfo.jspx?CharterOrderID=<ww:property value="id"/>" class="l06c"><ww:property value="ordercode" /></a></td><!-- login!toCharterOrderInfo.jspx?CharterOrderID=<ww:property value="id" /> -->
              <td><ww:if test="servicetype==1">团队</ww:if><ww:else>包机</ww:else></td>
                <td><ww:property value="formatDate(createtime)" /></td>
                <td><ww:property value="num" />人</td>
                <td><span class="airlines airlines_mu f mt3"></span><ww:property value="GetCharterOrderFnumberByid(id)" /></td>
                <td> <ww:if test="type==1">单程</ww:if> <ww:if test="type==2">往返</ww:if> </td>
                <td><ww:property value="GetCharterOderAirCompanyNameByCode(GetCharterOderAirCompanyCodeByid(id))" /></td> 
                <td><ww:property value="formatDate(GetCharterOderStatTimeByid(id))" /></td>
                <td><ww:property value="GetCharterOrderStaus(state)" /></td>
                <td><font class="l06c" >
                <ww:if test="state<7">
                <a href="login!CancelCharterOrder.jspx?CharterOrderID=<ww:property value="id" />">取消</a>
                </ww:if>
                
                </font></td>   
              </tr>
              </ww:iterator>
              
            </table>
             <div align="center">
 
  			<span >&nbsp;
            <div>&nbsp;<ww:property value="getPagination('\"login!tocharterlist.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/></div>
            </span>
        		</div>
       </div> 
       
   </div>
   </form>
</div>

<ww:include page="../footer.jsp"/> 
</body>
</html>
