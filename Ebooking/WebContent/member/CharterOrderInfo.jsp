<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-团队/包机订单详细信息</title>

<ww:head name="login"/>
<ww:head name="airlines"/>
<style type="text/css" media=print>
.noprint{display : none }
</style>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>    
<!----------header over---------->
<div id="member">
    <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
    <form action="login!topay.jspx?id=<ww:property value="charterorder.id"/>" target="_blank" method="post" name="form2" id="form2">
   <!--startprint1-->
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">订单详情</li>
            <li class="mation_info"><font class="mation_left f"><b>订单号：<font class="fontxing"><ww:property value="charterorder.ordercode" /></font></b></font><span class="f mr25">预订时间：（<font class="fontxing"><ww:property
					value="formatTimestamp(charterorder.createtime)" /> </font>）</span> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div>  
       <div class="mt7 box">
        <div class="tit">
               <font class="black low2 f mr15">团队/包机订单详细信息</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
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
           <ww:if test="#ind.index==0">已选择的去程航班</ww:if><ww:if test="#ind.index==1">已选择的回程航班</ww:if>
          </ww:if>
           <ww:if test="ListSegmentinfo.size==3">
           <ww:if test="#ind.index==0">第一程航班</ww:if><ww:if test="#ind.index==1">第二程航班</ww:if><ww:if test="#ind.index==2">第三程航班</ww:if>
          </ww:if>
          </b><span class="mlr15">
          
         
         
          <ww:property value="getAirCityNamebySZM(startairport)" /> → <ww:property value="getAirCityNamebySZM(endairport)" />
        
          </span>出发日期：<ww:property value="departtime" /></li>
          <li>
              <ul class="range">
                <li class="overmorny f"><font class="font18f60">
                <ww:if test="charterorder.price!=null">&yen;<ww:property value="price" /></ww:if><ww:else>暂无报价</ww:else>
                
                </font></li>
                <li class="f airport"> 
                <ww:if test=""></ww:if><ww:else>
                 <ww:property value="getAircomapnycodeByEZM(aircomapnycode)" />  
                </ww:else>
                
               
                </li>
                <li class="f airlines airlines_mu">  <ww:property value="flightnumber" />  </li>
               
               
                
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
           
           <ww:iterator value="ListPassenger">
           <li class="f mlr15 lh34">姓  名：<ww:property value="name" /></li>
           <li class="f mlr15 lh34">旅客类型：<ww:if test="ptype==1">成人</ww:if><ww:if test="ptype==2">儿童</ww:if><ww:if test="ptype==3">婴儿</ww:if></li>
           <li class="f mlr15 lh34">证件类型：<span class="mlr15">
           <ww:if test="idtype==1">身份证</ww:if>
           <ww:if test="idtype==3">护照</ww:if>
           <ww:if test="idtype==4">港澳通行证</ww:if>
           <ww:if test="idtype==5">台湾通行证</ww:if>
           <ww:if test="idtype==6">台胞证</ww:if>
           <ww:if test="idtype==7">回乡证</ww:if>
           </span><ww:property value="idnumber" /></li>
           <li class="f mlr15 lh34">保险：<span class="mlr15"><ww:property value="insurance" />份</span>￥20/份</li>
           <li class="c"></li>
           </ww:iterator>
           
          </ul>
          </div>
          <div class="msg mt7">
          <ul class="msgul ">
           <li class="over box_over"><b>联系人信息</b></li>
           <li class="f mlr15 lh34">联系人：<ww:property value="charterorder.name"/></li>
           <li class="f mlr15 lh34">电话：<ww:property value="charterorder.tel"/></li>
           <li class="f mlr15 lh34">QQ：<ww:property value="charterorder.qq"/></li>
          
           <li class="c"></li>
          </ul>
       </div>
          <div class="msg mt7">
           <ul class="msgul">
              <li class="allmornydetail l06c"><span class="allmorny"></span>订单总价：
             
              <font class="font18f60">
              <ww:if test="charterorder.price!=null"> &yen;<ww:property value="formatMoney(charterorder.price)" /></ww:if><ww:else>暂无报价</ww:else>
             
              </font>
              <!--
              （1成人&times;1000+1儿童&times;1000+2保险&times;20）
              -->
              </li>
           </ul>
           </div>
            <div class="bntt">
            <ww:if test="charterorder.state<7"> 
            <input type="button" class="button_cancel fff mlr" value="取消订单" onclick="checkairorder();"  />
            </ww:if>
            <ww:if test="charterorder.price!=null"> 
            <input type="button" class="button_cancel fff mlr" value="立即支付"  />
            </ww:if>
            <input type="button" class="button_cancel fff mlr" value="打印订单"  onclick="preview(1);"  /> </div>
        </div>
       </div> 
       
   </div>
   </form>
   <!--endprint1-->
</div>




 <form action="#"  method="post" name="form1" id="form1">
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
document.form1.action="login!checkcharterorder.jspx?OrderinfoId="+<ww:property value="charterorder.id" />+"&c_stste=11";
document.form1.submit();
}
}

function preview(oper){
if (oper < 10){
bdhtml=window.document.body.innerHTML;//获取当前页的html代码
sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html

prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml;


} else{
window.print();
}

}
</script>
