<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="com.yf.system.back.server.Server"%>
<%@page import="java.util.*" %>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全--租车</title>
<link href="carcss/base.css" rel="stylesheet" type="text/css" />
<link href="carcss/car_rental.css" rel="stylesheet" type="text/css" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />


<script src="js/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js/ext-all.js"></script>
</head>
<script type="text/javascript">
var currentcolor="#e2f4fe";
$(document).ready(function(){
  
  
});

function dispose(message) {
		   Ext.MessageBox.show({
		           msg: message+', 请稍后......',
		           progressText: 'Saving...',
		           width:300,
		           wait:true,
		           waitConfig: {interval:600},
		           icon:'ext-mb-download',
		           animEl: 'mb7'
		       });
		}
		
		function colsedispose(){
		 Ext.MessageBox.hide();
		}

function seach(){
   dispose('系统正在为您查询实时信息');
      document.form1.submit();
    
}
function check(id){
   		dispose('系统正在为您查询实时信息');
     window.location.href="bookcar!tocarinfo.action?carid="+id+"&Stime=<ww:property value="Stime" />&Etime=<ww:property value="Etime" />&Endcity=<ww:property value="Endcity" />&S_Name=<ww:property value="S_Name" />&Scarstore_s=<ww:property value="Scarstore_s" />&Scarstore_e=<ww:property value="Scarstore_e" />";
    
}



function checkcarbrand(brand){
document.getElementById("brand").value=brand;
document.form1.submit();
}
function checkxiang(xiang){
document.getElementById("xiang").value=xiang;
document.form1.submit();
}
function checkdang(dang){
document.getElementById("dang").value=dang;
document.form1.submit();

}
</script>
<body>
<form action="bookcar!seach.action" method="post" name="form1" id="form1">
 <input type="hidden"  name="Scity" value="<ww:property value="Scity" />"  />
 <input type="hidden"  name="Endcity" value="<ww:property value="Endcity" />"  />
 <input type="hidden"  name="Scarstore_s" value="<ww:property value="Scarstore_s" />"  />
 <input type="hidden"  name="Scarstore_e" value="<ww:property value="Scarstore_e" />"  /> 
 
 <input type="hidden"  name="startDate" value="<ww:property value="startDate" />"  /> 
 <input type="hidden"  name="startDate_HH" value="<ww:property value="startDate_HH" />"  /> 
   <input type="hidden"  name="endDate" value="<ww:property value="endDate" />"  /> 
 <input type="hidden"  name="endDate_HH" value="<ww:property value="endDate_HH" />"  /> 
 
 
 
 
<input type="hidden" id="brand" name="Carbrand" value="<ww:property value="Carbrand" />"  />
<input type="hidden" id="xiang" name="Car_Xiang" value="<ww:property value="Car_Xiang" />"  />
<input type="hidden" id="dang" name="Car_Dang" value="<ww:property value="Car_Dang" />"  />
 
   
<div id="container">

<div id="list">

<div class="right">
<div class="no1">
       <div class="f">
       <ul>
       <li class="f"><img src="images/chemo.gif" width="60" height="38" align="absmiddle" /></li>
       <li class="f" style="line-height:38px;"><font class="hui999_14"><ww:property value="getCityNameByStr(Scity)" /><font class="hui12">(取)</font>←→<ww:property value="getCityNameByStr(Endcity)" /><font class="hui12">（还）</font></font>
       </li>
       <li class="c"></li>
       </ul>
       </div>
       <div class="r"><img src="images/noc_1.gif" width="369" height="38" /></div>
       <div class="c"></div>
      </div>
      <div class="h5 c"></div>
      <div class="m5 wu">
          <div class="f">
          <img src="images/wirte.gif" width="26" height="23" align="absmiddle" />
         取车时间<font class="lan06c"> <ww:property value="Stime" /> </font>  &nbsp;&nbsp;&nbsp;&nbsp;还车时间<font class="lan06c"> <ww:property value="Etime" /> </font>    
          </div>
          <div class="r">共<font class="font-jia"><ww:property value="s_num" /></font>天</div>
          <div class="c"></div>
      </div>
      <ww:if test="ty==1">
      <div class="list_t">
          <div class="f" >
          <b class="baic">温馨提示</b>
          <font class="font-f60" style="color: red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;温馨提示： 你选择的车辆已经没有库存！请从新选择其他车型!!</font> 
          </div>
          <div class="r hui12"> </div>
          <div class="c"></div>
      </div>
      </ww:if>
      <div class="list box_q">
      
      <div class="box_quan xunze">
      <div class="box_q" style="background: #fff; padding: 5px;">
        <ul>
        <li><b class="font-f60">品牌</b></li>
        <li><dd  class="all" ><a href="javascript:checkcarbrand('');" style="color:#fff">全部</a></dd></li>
        <ww:iterator value="ListCarbrand" status="ind">
        
       
        <li><a href="javascript:checkcarbrand('<ww:property value="code"/>');"><span <ww:if test="Carbrand.equals(code)">style="color: red"</ww:if>><ww:property value="name"/></span></a></li>
        <ww:if test="#ind.index==10"></br><li style="width:90px;">&nbsp;</li></ww:if>
         </ww:iterator>
       
        </ul>
        <div class="c"></div>
        <ul>
        <li><b class="font-f60">厢数</b></li>
        <li><dd  class="all" ><a href="javascript:checkxiang('');" style="color:#fff">全部</a></dd></li>
        <li><a href="javascript:checkxiang('两厢');"><span <ww:if test="Car_Xiang.equals(\"两厢\")">style="color: red"</ww:if>>两厢</span></a></li>
        <li><a href="javascript:checkxiang('三厢');"><span <ww:if test="Car_Xiang.equals(\"三厢\")">style="color: red"</ww:if>>三厢</span></a></li>
        </ul>
        <div class="c"></div>
        <ul>
        <li><b class="font-f60">档位</b></li>
        <li><dd  class="all" ><a href="javascript:checkdang('');" style="color:#fff">全部</a></dd></li>
        <li><a href="javascript:checkdang('自排');"><span <ww:if test="Car_Dang.equals(\"自排\")">style="color: red"</ww:if> >自动</span></a></li><!--  自排 -->
        <li><a href="javascript:checkdang('手排');"><span <ww:if test="Car_Dang.equals(\"手排\")">style="color: red"</ww:if> >手动</span></a></li><!--  手排 -->
        </ul>
        <div class="c"></div>
      </div>
      </div>
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="chelist">
          <tbody> 
            <th align="center" width="115"  style="border-left:#fff 1px solid; ">车型</th>
            <th width="330" style="border-left:#fff 1px solid; ">品牌--型号--保险费--公里数</th>
            <th width="142" style="border-left:#fff 1px solid; ">价格</th> 
            <th style="border-left:#fff 1px solid; border-right:none;  ">操作</th>
          </tbody>
          <ww:iterator value="carlList">
         
	          <tr>
	            <td>
	            <img src="<%=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppathtocar'","",-1,0).get(0)).getValue() %><ww:property value="getImage(id)"/>" width="130" style="margin-left:30px;" height="85" />
	            </td>
	            <td>
	            
	            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="nei">
	              <tr>
	                <td colspan="3"><strong class="lan09f14"><img src="images/carlogo/<ww:property value="ppai"/>.jpg"  align="absmiddle" /><ww:property value="name"/> </strong></td>
	              </tr>
	             <tr>
	             <td>准乘：<ww:property value="maxpassenger"/>人</td>
	             <td>保险费：<font class="font-f60"><ww:property value="formatMoney_string(insurancefee)"/>元/天</font></td>
	             <td>公里数：<ww:property value="mile"/>公里/天</td>
	             </tr>
	              <!--
	              <tr>
	                <td width="20%"><img src="images/renshu.gif" width="15" height="30" align="absmiddle" /><ww:property value="maxpassenger"/>人</td>
	                <td width="40%"><img src="images/xiangshu.gif" width="50" height="29" align="absmiddle" /><ww:property value="getCarinfoByCarCode(code).carriage"/></td>
	                <td><img src="images/dangwei.gif" width="31" height="26" align="absmiddle" /><ww:property value="getCarinfoByCarCode(code).gear"/></td>
	              </tr> -->
	            </table>
	            </td>
	            <td class="pl30"><font class="font-jia">&yen;<ww:property value="formatMoney_string(weekdayprice)"/>~<ww:property value="formatMoney_string(weekendprice)"/></font>/天</td>
	            <!--<td><input type="button" class="button_huan"  value="调整时间" /><br/><input type="button" class="button_joxh" style="margin-top:4px;" value="排队约车" /></td>
	             -->
	            <td>
	            <!--
	            <input type="button" class="button_lam"  value="约车得积分" /><br/>
	            -->
	            <input type="button"  style="margin-top:4px;" class="button_jox"  onclick="check(<ww:property value="id"/>);" value="立即预约" /></td>
	            
	          </tr>
	          <!--<tr>
	          <td colspan="4">
	          <div style="background: url(images/paiz.gif) repeat-y; width:718px;">
	          <img src="images/pais.gif" style="margin-top: -5px;" />
	          <div style="margin:0px 27px 0 27px;">
	          排队 您选的时间范围内此车型已被全部预订，您可以选择其他时间段，或是更换所选车型。若需维持先前选项，那就会进入我们的排队系统，当有车时我们会将您的订单优先自动排入，并及时通知您.</div>
	          <img src="images/paix.gif" />
	          </div>
	          </td>
	          </tr>
	          
          --></ww:iterator>
              
             </table>
        

      <div style="line-height:30px;" align="center" ><ww:property value="getPagination('\"bookcar!seach.action?pageinfo.pagenum=\"+pageno+\"\"')"/></div>
      </div>
      
</div>

</form>

</div>

</div>
</body>
</html>
