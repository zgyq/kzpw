<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-我的积分</title>

<ww:head name="point" jsURL="member" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
   <jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
   
   <form action="point!toIntegral.jspx" name="form1" id="form1" method="post">
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f">可用积分:<font class="f90c"><ww:property value="UserIntegral"/>分</font></font><span class="r mation_right">&nbsp;</span><span class="r mr25">${compname}为您准备了精美的礼品，<a href="point!toPointsmall.jspx" class="unc09fx">马上兑换</a>。</span>           </li>
          </ul>
       </div>
       <div class="mt7 box">
        <div class="tit">
               <font class="black low2 f mr15">积分获得明细</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
              
                <td  class="hadow hl24" align="center" width="20%">收货人：</td>
                <td><input type="textg"  class="text_number" name="c_username" value="<ww:property value="c_username"/>"  /></td>
                <td  class="hadow hl24" align="center" width="20%">礼品名称：</td>
                <td><input type="textg"  class="text_number" name="c_giftname" value="<ww:property value="c_giftname"/>" /></td>
                
              </tr>
              <tr>
                <td  class="hadow hl24" align="center" width="20%">兑换开始时间：</td>
                <td><input type="textg" id="txtcheckindate"  class="text_number" name="c_stime" value="<ww:property value="c_stime"/>" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',maxDate:'%y-#{%M}-%d'})"  /></td>
                <td  class="hadow hl24" align="center" width="20%">兑换结束时间：</td>
                <td><input type="textg"  class="text_number" name="c_endtime" value="<ww:property value="c_endtime"/>" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" /></td>
              </tr>
            </table>
            <div class="search"> <input type="submit" value="立即查询" class="button_searchmeb"  /><font class="f00">根据您所知道的内容进行查询！</font></div>
            <!--listsearch over-->
            <form action="addcommonpeople.html" method="get">
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td class="hadow" width="30">序号</td>
                <td class="hadow" width="12%" align="center">兑换日期</td>
                <td class="hadow" width="20%">兑换内容</td>
                <td class="hadow" width="10%" >兑换积分</td>
                <td class="hadow" width="10%">收货人</td>
                <td class="hadow" >收货地址</td>
                <td class="hadow" width="10%">状态</td>
              </tr> 
              <ww:iterator value="ListRedeem" status="ind">           
              <tr>     
                <td><ww:property value="#ind.index+1"/></td>
                <td><ww:property value="formatTimestampyyyyMMdd(createtime)"/></td>
                <td><a href="#" class="b000" ><ww:property value="giftname"/></a></td> 
                <td class="f90"><ww:property value="integral"/>分</td>
                <td><ww:property value="name"/></td>
                <td><a href="#" ><ww:property value="province"/>,<ww:property value="city"/>,<ww:property value="area"/></a></td>
                <td><ww:if test="state==0">待处理</ww:if><ww:else>处理中</ww:else></td>
              </tr>
              </ww:iterator>
             
            </table>
            </form>
        </div>
        <div>&nbsp;</div>
       </div> 
       
   </div>
   </form>
</div>

<ww:include page="../footer.jsp" />  
</body>
</html>
<script type="text/javascript">
//一下2个位日期控件用
function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}
function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}
</script>