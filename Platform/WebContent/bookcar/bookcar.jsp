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
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script src="js/jquery1.3.2.js" type=text/javascript></script>   

<link rel="stylesheet" href="style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js/ext-all.js"></script>
	
	
</head>
<script type="text/javascript">

$(document).ready(function(){
        $("#form2").validationEngine(
	{
		success : function() {
			//表单提交时把按钮disable
			document.getElementById("submitreg").disabled = true;
			document.form2.submit();
			
		
		}
	}
	)
	
    
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
<body>
<div id="container">

<div id="list">

 
<div class="right">
<div class="no1">
       <div class="f">
       <ul>
       <li class="f"><img src="images/chemo.gif" width="60" height="38" align="absmiddle" /></li>
       <li class="f" style="line-height:38px;"><font class="hui999_14"><ww:property value="getCityNameByStr(Scity)" />
       <font class="hui12">(取)</font>←→<ww:property value="getCityNameByStr(Endcity)" /><font class="hui12">（还）</font></font>
       </li>
       <li class="c"></li>
       </ul>
       </div>
       <div class="r"><img id="image" src="images/noc_2.gif" width="369" height="38" /></div>
       <div class="c"></div>
      </div>
      <div class="h5 c"></div>
      <!--<div class="m5 wu">
          <div class="f">
          <img src="images/wirte.gif" width="26" height="23" align="absmiddle" />
         取车时间<font class="lan06c"> <ww:property value="Stime" /> </font>  
         <a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;还车时间
         <font class="lan06c"> <ww:property value="Etime" /> </font>  <a href="#">修改</a>     
          </div>
          <div class="r">共<font class="font-jia"><ww:property value="s_num" /></font>天</div>
          <div class="c"></div>
      </div>
      -->
      <div class="m5 wu">
          <div class="f">
          <img src="images/wirte.gif" width="26" height="23" align="absmiddle" />
         取车时间<font class="lan06c"> <ww:property value="Stime" /> </font>  
       &nbsp;&nbsp;&nbsp;&nbsp;还车时间
         <font class="lan06c"> <ww:property value="Etime" /> </font>     
          </div>
          <div class="r">共<font class="font-jia"><ww:property value="s_num" /></font>天</div>
          <div class="c"></div>
      </div>
      <div class="list_t">
          <div class="f" >
          <b class="baic">增值服务</b>
          <font class="font-f60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;温馨提示： 如需重新查询汽车列表，请<a href="javascript:history.go(-1)">点击这里</a>！</font> 
          </div>
          <div class="r hui12"> </div>
          <div class="c"></div>
      </div>
      <div class="list box_q">
     
      <table border="1" cellpadding="0" cellspacing="0" bordercolor="#DADADA" width="96%" class="zifei">
     	 
     	   <tr> 
            <td class="tex" align="center" width="200"  style="height:24px;line-height:24p;x">车型</td>
            <td class="tex" style="padding-left:40px;">品牌--型号--保险费--公里数</td>
          
          
        	</tr>
          
     	 <tr>
	            <td style="border:none;" align="center">
	            <img src="<%=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppathtocar'","",-1,0).get(0)).getValue() %><ww:property value="getImage(cars.id)"/>" width="130" style="margin-left:30px;" height="85" />
	            </td>
	            <td style="border:none;">
	            
	            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="nei">
	              <tr>
	                <td colspan="3"><strong class="lan09f14"><img src="images/carlogo/<ww:property value="cars.ppai"/>.jpg"  align="absmiddle" /><ww:property value="cars.name"/> </strong></td>
	              </tr>
	             <tr>
	             <td>准乘：<ww:property value="cars.maxpassenger"/>人</td>
	             <td>保险费：<font class="font-f60"><ww:property value="formatMoney_string(cars.insurancefee)"/>元/天</font></td>
	             <td>公里数：<ww:property value="cars.mile"/>公里/天</td>
	             </tr>
	             
	            </table>
	            </td>
	            
	          
	          
	            
	          </tr>
	          
	   </table>   
	   
     <table width="96%" border="1" cellspacing="0" cellpadding="0" bordercolor="#DADADA" class="zifei">
          <tbody>
          <th colspan="4" class="texbd"><font class="lan14b"><ww:property value="cars.name" /></font> &nbsp;&nbsp;&nbsp;<font class="hui12">资费说明</font></th>
          </tbody>
             <tr>
            <td class="tex" align="right" width="140" >信用卡预授权费用：</td>
            <td class="texb" ><ww:property value="SerachCarPriceOrder.preauthfee" />元</td>
            <td class="tex" align="right" width="140">基本费用：</td>
            <td class="texbd" ><ww:property value="SerachCarPriceOrder.jprice" />元</td>
          </tr>   
          <tr>
            <td class="tex" align="right" width="140" >总价(含保险和手续费)：</td>
            <td class="texb" width="170" > <ww:property value="SerachCarPriceOrder.price" />元  </td>
            <td class="tex" align="right" width="140">限制里程：</td>
            <td class="texbd" ><ww:property value="SerachCarPriceOrder.mile" />公里/<ww:property value="s_num" />天</td>
          </tr>  
          <tr>
            <td class="tex" align="right" width="140" >超里程费：</td>
            <td class="texb" ><ww:property value="formatMoney_string(cars.exmilefee)" />元/公里</td>
            <td class="tex" align="right" width="140">超时费：</td>
            <td class="texbd" ><ww:property value="formatMoney_string(cars.extimefee)" />元/天</td>
          </tr>                                      
 		<tr>
            <td class="tex" align="right" width="140" >手续费：</td>
            <td class="texb" ><ww:property value="SerachCarPriceOrder.servicefee" />元</td>
            <td class="tex" align="right" width="140">总保险费：(每日费*天数)</td>
            <td class="texbd" ><ww:property value="SerachCarPriceOrder.insurancefee*s_num" />元</td>
          </tr>   
             <tr>
            <td class="tex" align="right" width="140" >取车城市：</td>
            <td class="texb" ><ww:property value="getCityNameByStr(Scity)" /></td>
            <td class="tex" align="right" width="140" >取车店铺:</td>
            <td class="texbd" title="<ww:property value="getcarstoreAddresByID(Scarstore_s)" />" ><ww:property value="getcarstorenameByID(Scarstore_s)" /></td>
          </tr>   
       <tr>
            <td class="tex" align="right" width="140" >还车城市：</td>
            <td class="texb" ><ww:property value="getCityNameByStr(Endcity)" /></td>
            <td class="tex" align="right" width="140" >还车店铺:</td>
            <td class="texbd" title="<ww:property value="getcarstoreAddresByID(Scarstore_e)" />" ><ww:property value="getcarstorenameByID(Scarstore_e)" /></td>
          </tr>
          
         <tr>
            <td class="tex" align="right" width="140" >取车时间：</td>
            <td class="texb" ><ww:property value="Stime" /></td>
            <td class="tex" align="right" width="140">还车时间:</td>
            <td class="texbd" ><ww:property value="Etime" /></td>
          </tr>
          
      
          <tr>
            <td class="tex" colspan="4" ><font class="lan06c"><img src="images/xiaolaba.gif" width="28" height="25" align="absmiddle" />此车基本费用为<b class="huang_jia"><ww:property value="SerachCarPriceOrder.price" />元</b>，超出部分我们将按以上说明进行收取。返利<b class="huang_jia"><ww:property value="formatMoney_short(getUserPriceByCar(SerachCarPriceOrder.jprice))" />元</b></font></td>
          </tr>
        </table>
        

      <div class="he14" ></div>
      </div>
            <div class="list_t"><font class="fff">预订人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
          <font class="hui999"> — 请准确填写预订人信息（手机号码，E-mail），以便我们与您联系。</font>         
      </div>
      <form action="bookcar!bookcar.action" method="post" name="form2" id="form2">
      <div class="yuding box_qbd">
      <div class="add" id="showdiv" >
        <table width="96%" border="1" cellspacing="0" cellpadding="0"  bordercolor="#DADADA" class="xianming texrd">
          <tr>
            <td class="tex" align="right" width="100" ><font class="xinghao">*</font>预订人姓名：</td>
            <td class="texb" >
           	 <input type="text" value="<ww:property value="getorderusername()"/>" desc="预订人姓名" name="linkname" id="linkname"  class="input_dd validate[required]" style="width:130px;" />
            	请正确填写您的姓名，以便确认您的预订服务。</td>
          </tr>                                      
          <tr>
            <td class="tex" align="right"><font class="xinghao">*</font>手 机：</td>
            <td class="texb">
            <input type="text" value="<ww:property value="getorderusermobile()"/>" desc="联系人手机" name="linkmobile" id="linkmobile"  class="input_dd validate[required,custom[mobile]]" style="width:130px;" />请正确填写您的手机号，以便确认您的预订服务。</td>
          </tr>
          <tr>
            <td class="tex" align="right"  ><font class="xinghao">*</font>邮 箱：</td>
            <td class="texb" >
            <input type="text" value="<ww:property value="#session.orderuserlogin.memberemail" />" desc="联系人邮箱" name="linkmail" id="linkmail" class="input_dd validate[required,custom[email]]" style="width:130px;" />请正确填写您的邮箱，以便确认您的预订服务。</td>
          </tr> 
          <tr>
            <td class="tex" align="right"  ><font class="xinghao">*</font>身份证：</td>
            <td class="texb" >
            <input type="text" value="<ww:property value="#session.orderuserlogin.cardnunber" />" desc="身份证"  name="nuber" id="nuber"  class="input_dd validate[required,cardnumber]" style="width:130px;" />请正确的填写你得身份证或者驾照号码,以便确认你得预订服务。</td>
          </tr> 
          
          <tr>
            <td class="tex" align="right"  ><font class="xinghao">*</font>性别：</td>
            <td class="texb" >
          
           
             <input type="radio" id="sex1"   name="sex" value="男" checked="checked"  />男
           	<input type="radio" id="sex2"  name="sex" value="女"   />女 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
            请正确选择你的性别,以便确认你得预订服务。</td>
          </tr> 
          
          <tr>
            <td class="tex" align="right"  ><font class="xinghao">*</font>驾照颁发日期：</td>
            <td class="texb" >
            <input type="text" value="<ww:property value="#session.orderuserlogin.livingperiod" />" desc="驾驶证颁发日期"  name="jtime" id="jtime"  class="input_dd validate[required] Wdate" style="width:130px;" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'<ww:property value="Tday" />'})" />请按照"2009-01-01"格式填写你得驾照颁发日期。</td>
          </tr> 
        </table>
     
      </div> 
        <!-- 隐藏域值 开始 -->
          <input type="hidden"  name="Scarstore_s" value="<ww:property value="Scarstore_s" />"   />
          <input type="hidden"  name="Scarstore_e" value="<ww:property value="Scarstore_e" />"   />
          <input type="hidden"  name="Scity" value="<ww:property value="Scity" />"  />
          <input type="hidden"  name="Endcity" value="<ww:property value="Endcity" />"  />
          <input type="hidden"  name="Stime" value="<ww:property value="Stime" />"  />
          <input type="hidden"  name="Etime" value="<ww:property value="Etime" />"  />
          <input type="hidden"  name="carid" value="<ww:property value="carid" />"  />
          <input type="hidden"  name="SerachCarPriceOrder" value="<ww:property value="SerachCarPriceOrder" />"  />
         
      
       <!-- 隐藏域值 结束 -->
       <!-- 确认用DIV  开始 -->
       <div class="add" id="hiddiv" style="display: none;" >
        <table width="96%" border="1" cellspacing="0" cellpadding="0"  bordercolor="#DADADA" class="xianming texrd">
          <tr>
            <td class="tex" align="right" width="140" >联系人姓名：</td>
            <td class="texb" id="xingming" ></td>
            <td class="tex" align="right" width="140">手机：</td>
            <td class="texb" id="shouji" ></td>
          </tr> 
          <tr>
            <td class="tex" align="right" width="140" >身份证：</td>
            <td class="texb" id="shengfz" ></td>
            <td class="tex" align="right" width="140">邮箱：</td>
            <td class="texb" id="youxiang" ></td>
          </tr> 
           <tr>
            <td class="tex" align="right" width="140" >性别：</td>
            <td class="texb" id="xingbie" ></td>
            <td class="tex" align="right" width="140">驾照颁发日期：</td>
            <td class="texb" id="jiatime" ></td>
          </tr> 
        
        </table>
      </div> 
       <!-- 确认用DIV 结束 -->
      
      <div class="he14">&nbsp;</div>  
      </div>
      </form>
      <div class="next" id="sub_check" >
      <input onclick="javascript:history.go(-1)" class="button_up" value="上一步" type="button" />
      <input type="button" id="submitreg" onclick="confirmOrder();" value="下一步" class="button_next"  />
      </div>
      <div class="next" id="subm_sub" style="display: none;" >
      <input onclick="gobak();" class="button_up"  value="上一步" type="button" />
      <input type="button"  onclick="book();" value="提交" class="button_next"  />
      </div>
</div>


</div>

</div>
</body>
</html>
<script type="text/javascript">
function book(){

//alert("系统升级中!!!暂停预订业务");
//return;
document.form2.submit();

}

function gobak(){
		$("#hiddiv").hide();
 		$("#showdiv").show();
 		
 		$("#sub_check").show();
 		$("#subm_sub").hide();
 		
 		document.getElementById("image").src="images/noc_2.gif";
}
function confirmOrder(){

		if(!$('#form2').validationEngine({returnIsValid:true}))
 		{
 			
 		}else{
 		document.getElementById("xingming").innerHTML=document.getElementById("linkname").value;
 		document.getElementById("shouji").innerHTML=document.getElementById("linkmobile").value;
 		document.getElementById("youxiang").innerHTML=document.getElementById("linkmail").value;
 		document.getElementById("shengfz").innerHTML=document.getElementById("nuber").value;
 		document.getElementById("jiatime").innerHTML=document.getElementById("jtime").value;
 		if(document.getElementById("sex1").checked==true){
 		document.getElementById("xingbie").innerHTML="男";
 		}
 		if(document.getElementById("sex2").checked==true){
 		document.getElementById("xingbie").innerHTML="女"
 		}
 		
 		document.getElementById("image").src="images/noc_3.gif";
 		$("#hiddiv").show();
 		$("#showdiv").hide();
 		
 		$("#sub_check").hide();
 		$("#subm_sub").show();
 		//$("#xin").className="texb font-f60";
 	
 		
 		}
 

	
}

</script>
