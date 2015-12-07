<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-机票订单详细信息</title>

<ww:head name="login"/>
<ww:head name="airlines"/>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
    <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
    <form action="ticticket!payorder.jspx?orderid=<ww:property value="orderinfo.id"/>" target="_blank" method="post" name="form2" id="form2">
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单详情</li>
            <li class="mation_info"><font class="mation_left f"><b>订单号：<font class="fontxing"><ww:property value="orderinfo.ordernumber" /></font></b></font><span class="f mr25">预订时间：（<font class="fontxing"><ww:property
					value="formatTimestamp(orderinfo.createtime)" /> </font>）</span> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div>  
       <div class="mt7 box">
        <div class="tit">
               <font class="black low2 f mr15">订单详细信息</font>
              <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div class="nohave">&nbsp;</div>
         <div class="msg mt7">
         <ww:iterator value="ListSegmentinfo" status="ind">
         
        
          <ul class="msgul">
          <li class="over box_over"><b>
          <ww:if test="ListSegmentinfo.size==1">已选择的去程航班</ww:if>
          <ww:if test="ListSegmentinfo.size==2">
           <ww:if test="orderinfo.internal==1l">已选择的去程航班</ww:if>
           <ww:else>
             <ww:if test="#ind.index==0">已选择的去程航班</ww:if><ww:if test="#ind.index==1">已选择的回程航班</ww:if>
           </ww:else>  
          </ww:if>
           <ww:if test="ListSegmentinfo.size==3">
           <ww:if test="#ind.index==0">第一程航班</ww:if><ww:if test="#ind.index==1">第二程航班</ww:if><ww:if test="#ind.index==2">第三程航班</ww:if>
          </ww:if>
          </b><span class="mlr15">
          
          <ww:if test="orderinfo.internal==0">
         
          <ww:property value="getAirCityNamebySZM(startairport)" /> → <ww:property value="getAirCityNamebySZM(endairport)" />
          </ww:if><ww:else>
          <!--
          <ww:property value="startairport" /> → <ww:property value="endairport" />
          -->
          <ww:property value="getInterAirCityNamebySZM(startairport)" /> → <ww:property value="getInterAirCityNamebySZM(endairport)" />
          </ww:else>
          </span>出发日期：<ww:property value="formatDate(segmentinfo.departtime)" /></li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">&yen;<ww:property value="price" /></font><span class="mlr"><ww:property value="cabincode" />/<ww:property value="discount" /></span></li>
                <li class="f airport">
                  <dt><ww:property value="formatTimestampHHmm(departtime)" /> 
                  <ww:if test="orderinfo.internal==0">
                  <ww:property value="getAirPortNamebyCode(startairport)" />
                  </ww:if><ww:else>
                  <ww:property value="getAirPortNamebyCode(startairport)" /> 
                  </ww:else>
                  
                  </dt>
                  <dt><ww:property value="formatTimestampHHmm(arrivaltime)" />
                   <ww:if test="orderinfo.internal==0">
                   <ww:property value="getAirPortNamebyCode(endairport)" />
                   </ww:if><ww:else>
                    <ww:property value="getAirPortNamebyCode(endairport)" /> 
                   </ww:else>
                   </dt>
                </li>
                <li class="f airlines airlines_mu"></li>
                <li class="f model">
                  <dt> <ww:property value="gethangkongname(aircomapnycode)" /><ww:property value="flightnumber" /></dt>
                  <dt>空客<a href="#" class="fontun06c">A333</a>(大)<ww:property value="FlightModel" /></dt>
                </li>
                <li class="f fuel">
              <ww:property value="airportfee" />
                / <ww:property value="fuelfee" /></li>
                <li class="f meal"><a href="" onmouseover="showDiag('diag_<ww:property value="#ind.index"/>','block')"
						onmouseout="showDiag('diag_<ww:property value="#ind.index"/>','none')" class="fontun06c">退改签规则</a>
                <div class="float msg_l" style="display:none" id="diag_<ww:property value="#ind.index" />">
                   <ul class="msgul_l">
                   <li class="over box_over_l">退改签规则</li>
                   <li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
                   <li class="pf5"><b>退票条件：</b></li>
                   <li class="pf5"><b>签转条件：</b></li>
                   </ul>
                </div>
                </li>
                <li class="f btn">&nbsp;</li>
              </ul>
          </li>
          </ul>
        </ww:iterator>
       <!--往返订单第一程信息-->
          <ul class="msgul" style="display:none">
          <li class="over box_over"><b>已选择的返程航班</b><span class="mlr15">上海 → 北京</span>出发日期：2011-11-27</li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">&yen;1000</font><span class="mlr">特价经济舱</span></li>
                <li class="f airport">
                  <dt>09：00 北京首都机场</dt>
                  <dt>12：00 上海白云机场</dt>
                </li>
                <li class="f airlines airlines_mu"></li>
                <li class="f model">
                  <dt>东航MU5138</dt>
                  <dt>空客<a href="#" class="fontun06c">A333</a>(大)</dt>
                </li>
                <li class="f fuel">70/90</li>
                <li class="f meal"><a href="#" class="fontun06c">退改签规则</a>
                <div class="float msg_l" style="display:none">
                   <ul class="msgul_l">
                   <li class="over box_over_l">退改签规则</li>
                   <li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
                   <li class="pf5"><b>退票条件：</b></li>
                   <li class="pf5"><b>签转条件：</b></li>
                   </ul>
                </div>
                </li>
                <li class="f btn">&nbsp;</li>
              </ul>
          </li>
          </ul>
          </div>
          <div class="msg mt7">
          <ul class="msgul mt10">
           <li class="over box_over"><b>乘机人信息</b><span class="mlr15"><ww:property value="ListPassenger.size" />位乘机人</span></li>
           <li>&nbsp;</li>
           <ww:iterator value="ListPassenger">
           <li class="f mlr15 lh34">姓  名：<ww:property value="name" /></li>
           <li class="f mlr15 lh34">旅客类型：<ww:if test="ptype==1">成人</ww:if><ww:if test="ptype==2">儿童</ww:if><ww:if test="ptype==3">婴儿</ww:if></li>
            <ww:if test="orderinfo.internal==1l">
            
            </ww:if>
           <li class="f airporter">
           <dt>证件类型：<span class="mlr15">
           <ww:if test="idtype==1">身份证</ww:if>
           <ww:if test="idtype==2">护照</ww:if>
           <ww:if test="idtype==3">港澳通行证</ww:if>
           <ww:if test="idtype==4">台湾通行证</ww:if>
           <ww:if test="idtype==5">台胞证</ww:if>
           <ww:if test="idtype==6">回乡证</ww:if>
           </span>
           </dt>
           <dt>证件号码：<ww:property value="idnumber" /></dt>
           </li>
           <ww:if test="orderinfo.internal==0l">
            <li class="f mlr15 lh34">保险：<span class="mlr15"><ww:property value="formatMoneyToInt(insurprice/20)" />份</span>￥20/份</li>
           </ww:if>
            <ww:if test="orderinfo.internal==1l">
          
            <li class="f airport">
             <dt>证件有效期：<ww:property value="cardvaliddate" /></dt>
             <dt>出生日期：<ww:property value="birthday" />  </dt> 
            </li>
            <li class="f mlr15 lh34">
             <dt>国籍：<ww:property value="getCountyNameByCode(country)" /></dt>
            </li>
            </ww:if>
           <li class="c"></li>
           </ww:iterator>
          </ul>
          </div>
          <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>联系人信息</b></li>
           <li class="f mlr15 lh34">联系人：<ww:property value="orderinfo.contactname"/></li>
           <li class="f mlr15 lh34">手机号：<ww:property value="orderinfo.contactmobile"/></li>
           <li class="f mlr15 lh34">邮箱：<ww:property value="orderinfo.contactemail"/></li>
           <ww:if test="orderinfo.internal==1l">
            <li class="f mlr15 lh34">备注：<ww:property value="orderinfo.memo"/></li>
           </ww:if>
           <ww:else>
           <li class="f mlr15 lh34">确认方式：短信确认</li>
           </ww:else>
           <li class="f mlr15 lh34">支付方式：<font class="f90"><ww:if test="orderinfo.paymethod==1">网上支付</ww:if><ww:else>票到付款</ww:else></font></li>
           <li class="c"></li>
          </ul>
       </div>
          <div class="msg mt7">
           <ul class="msgul">
              <li class="allmornydetail l06c"><span class="allmorny"></span>订单总价：
              <!--
              <ww:property value="orderinfo.totalticketprice"/>,<ww:property value="orderinfo.totalairportfee"/>,<ww:property value="orderinfo.totalfuelfee"/>,<ww:property value="getIssurByOrderid_B2b(orderinfo.id)"/>
              -->
              <font class="font18f60">&yen;<ww:property value="formatMoney(orderinfo.totalticketprice+orderinfo.totalairportfee+orderinfo.totalfuelfee+getIssurByOrderid_B2b(orderinfo.id))" /></font>
              <!--
              （1成人&times;1000+1儿童&times;1000+2保险&times;20）
              -->
              </li>
           </ul>
           </div>
            <div class="bntt">
            <ww:if test="orderinfo.orderstatus==1 || orderinfo.orderstatus==2 ">
            <input type="button" class="button_cancel fff mlr" value="取消订单"  onclick="checkairorder();" />
            </ww:if>
             <ww:if test="orderinfo.orderstatus==1||orderinfo.orderstatus==27">
            <input type="submit" class="button_cancel fff mlr" value="立即支付"  />
            </ww:if>
            <input type="button" class="button_cancel fff mlr" value="打印订单"  /> </div>
        </div>
       </div> 
       
   </div>
</div>



</form>

<ww:include page="../footer.jsp"/> 
</body>
</html>
<script type="text/javascript">
     function showDiag(diag,flag)
		{
		//alert(diag+","+flag);
			document.getElementById(diag).style.display=flag;
		}
		function checkairorder(){
if(confirm('您确定要取消订单吗？'))
{
document.form1.action="login!checkairorder.jspx?OrderinfoId="+<ww:property value="orderinfo.id" />+"&orderinfo.orderstatus=6";
document.form1.submit();
}
}
</script>
