<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>查询页面</title>
<script type="text/javascript">
function showDetailspnr(liid,id)
{

document.getElementById("jpcx").style.display="none";
document.getElementById("pndr").style.display="none";
document.getElementById("pndrwz").style.display="none";
document.getElementById("kfzx").style.display="none";
document.getElementById(id).style.display="";
document.getElementById("lib3").style.backgroundImage="url('b2bticket/images/xlw2.gif')";
document.getElementById("lib32").style.backgroundImage="url('b2bticket/images/xlw2.gif')";
document.getElementById("lib33").style.backgroundImage="url('b2bticket/images/xlw2.gif')";
document.getElementById("lib34").style.backgroundImage="url('b2bticket/images/xlw2.gif')";
document.getElementById(liid).style.backgroundImage="url('b2bticket/images/xlw1.gif')";
}
</script>
<link href="b2bticket/css/css.css" rel="stylesheet" type="text/css" />
<!-- 城市控件用 -->
<link rel="stylesheet" type="text/css" href="js/aircity/css/jquery.suggest.css">
 <script type="text/javascript" src="js/aircity/js/jquery-1.4.2.min.js"></script>
 <script type="text/javascript" src="js/aircity/js/j.dimensions.js"></script>
 <script type="text/javascript" src="js/aircity/js/aircity.js"></script>
 <script type="text/javascript" src="js/aircity/js/j.suggest.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css" href="js2/resources/css/ext-all.css" />
<script type="text/javascript" src="js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js2/ext-all.js"></script>

<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>

<script type="text/javascript" language="javascript">
        $(document).ready(function()
	     {
	     
	        $("#arrcity").val($("#txtsairportname").val());
	        $("#city_from_hide").val($("#txtsairport").val());
	       // $("#city_from_hide_lc").val($("#txtsairport").val());
	       // $("#arrcity-lc").val($("#txtsairportname").val());
	        $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
			//加载联程城市信息
			//$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
			//$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
	    	$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
	    	$("#txtStartDate").val(getDateyyyyMMdd(3));
	    	
	    
	     });
	    
	     
	var ordernum=1;     
	   	
	var gwin;
	function grefresh(){
	
	  if(gwin){
	 	
	  
			gwin.close();
			 window.location.reload();
		}
	}
	function grefreshClose(){
	
	  if(gwin){
	 	
	  
			gwin.close();
			 
		}
	}
	    
	    function searchcity(){
				var	title="选择城市";
				var url="b2bticketorder!tocity.action";
				if(gwin){gwin.close();}
				gwin= Ext.create('Ext.Window', {
				   title: title,
			        maximizable: true,
			        width: 650,
			        height: 450,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src='+url+' width="100%" height="100%" s frameborder="0"  ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();	
			  		
			}
	    
	    
	     

	     
	     
		function bindroundfromcity()
		{
	        //绑定联程出发城市
	        $("#arrcity-lc").val($("#tocity").val());
	        $("#city_from_hide_lc").val($("#city_to_hide").val());
		}
		
	
		function showBackTypeDate(type)
        {
         
        if(type==1){
         $("#td_zcd").html("返程日期");
        document.getElementById("txtBackDate").disabled="disabled";
         document.getElementById("arrcity-lc").disabled="disabled";
        }
        if(type==2){
        $("#td_zcd").html("返程日期");
         document.getElementById("txtBackDate").disabled=false;
         document.getElementById("arrcity-lc").disabled="disabled";
        }
        if(type=='3'){
         document.getElementById("arrcity-lc").disabled=false;
         document.getElementById("txtBackDate").disabled=false;
          $("#td_zcd").html("中转日期");
        }   
        }
        
        function CheckData(s_ty)
        {
      // alert(s_ty);
        
        	$("#s_type").val(s_ty);
        
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            
             
            
            if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
            {
                alert("返程时间不能为空！");
                $("#txtBackDate").focus();
                return ;
            }
            if(rdoLiancheng.checked==true && $("#txtBackDate").val()=="")
            {
                alert("中转时间不能为空！");
                $("#txtBackDate").focus();
                return ;
            }
            else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
	        {
	                alert("返程日期不能早于出发日期,请检查后重新填写！");
	                return ; 
	        }
            if(rdoOnlone.checked==true)
            {
	            //if($("#arrcity").val()=="" || $("#tocity").val()=="" || $("#txtStartDate").val()==""||$("#arrcity").val()=="中文/拼音"||$("#tocity").val()=="中文/拼音")//中文/拼音
	            //{
	                //alert("其中 * 号信息为必填信息,请检查后重新填写！");
	                //return false;
	            //}
	            if($("#arrcity").val()=="" || $("#city_from_hide").val=="" ||$("#arrcity").val()=="中文/拼音")
	            {
	                alert("出发城市不能为空，请重新选择！");
	                $("#arrcity").focus();
	                return ;
	            }
	            if($("#tocity").val()=="" || $("#city_to_hide").val=="" || $("#tocity").val()=="中文/拼音")
	            {
	                alert("到达城市不能为空，请重新选择！");
	                $("#tocity").focus();
	                return ;
	            }
	            if($("#txtStartDate").val()=="")
	            {
	               alert("出发日期不能为空，请重新选择！");
	                $("#txtStartDate").focus();
	                return ;
	            }
	            
            }
            
            if(rdoLiancheng.checked==true){
            
            	 if($("#city_from_hide_lc").val()=="")
	            {
	               alert("中转城市不能为空，请重新选择！");
	                $("#arrcity-lc").focus();
	                return ;
	            }
            }
            
            
            
            //联程信息验证
           // if(rdoLiancheng.checked==true)
           // {
          //      if($("#arrcity-lc").val()=="" || $("#tocity-lc").val()=="" || $("#txtStartDate-lc").val()==""||$("#arrcity-lc").val()=="中文/拼音"||$("#tocity-lc").val()=="中文/拼音")//中文/拼音
	      //      {
	      //          alert("第二程信息，其中 * 号信息为必填信息,请检查后重新填写！");
	      //          return false;
	      //      }
	      //      else if(Computation($("#txtStartDate").val(),$("#txtStartDate-lc").val())>0)
	       //     {
	      //           alert("第二程出发日期不能早于第一程出发日期,请检查后重新填写！");
	      //          return false; 
	      //      }
           // }
           
          
          
valadatepay();
//alert(ordernum);
if(ordernum>=2){

alert('你今天有'+ordernum+'未支付的订单.请进行支付或者取消!!!');
return;

}

            loading('正在为您查询航班信息');
           // return;
           
           
           
           
           
           
           
            document.form1.submit();
            
	        return true;
            
        }
        function valadatepay(){
		 
		$.ajax({
	         type:"POST",
	         async:false,
	         url:"cabin!valadateispay.action?rndmath="+Math.floor(Math.random()*100),
	         data:{},
	         success:function(data){
	         	//alert(data);
	         	ordernum=data;
	         	
	         }            
	         });
 
  
		
	}
        
        function hideddl()
        {
        	//alert("hideddl");
        	
        	//$("#hid_ecity").hide();
            $("#ddlAirCom").hide();
        }
        function showddl()
        {
        	//$("#citytype").val('hid_ecity')
        	//alert("showddl");
        	//$("#hid_scity").hide();
            $("#ddlAirCom").show();
        }
        
          function hid()
        {
        	$("#hid_ecity").hide();
        	$("#hid_scity").hide();
           
        }
        
         function alertInfo(inf)
        {
        	alert(inf);
        }
        
   function checkorderdata(type) {
	if(type=='strPNR'){
		var strpnr=document.getElementById("strPNR").value;
	
		if(strpnr==''){
		alert("PNR为空!");
		return;
		}
		document.form2.submit();
	}
	if(type=='PnrTxtPat'){
		var PnrTxtPat=document.getElementById("PnrTxtPat").value;
	
		if(PnrTxtPat==''){
		alert("PNR文本为空!");
		return;
		}
		document.form3.submit();
	}
	
}
     
   function  ShowMes(id){
   
   window.open('login!toShowMesInfo.action?sysid='+id,    '_blank',    'scrollbars=0,resizable=0,height=360,width=760,top=150,left=200');
   
   }
   
 function  GuiTai(){
 //s_type
   $("#s_type").val('1');
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
        
	</script>
</head>

<body>

<center>
<div class="topdiv">
<!--机票查询-->
<div class="b2bmainxlwul">
<ul>
<li class="lib3"  id="lib3" onclick="javascript:showDetailspnr('lib3','jpcx');" style="cursor:pointer">机票查询</li>
<li class="lib32" id="lib32" onclick="javascript:showDetailspnr('lib32','pndr');" style="cursor:pointer">PNR导入</li>
<li class="lib32" id="lib33" onclick="javascript:showDetailspnr('lib33','pndrwz');" style="cursor:pointer">PNR文本导入</li>
<li class="lib32" id="lib34" onclick="javascript:showDetailspnr('lib34','kfzx');" style="cursor:pointer">客服中心</li>

</ul>
</div>

<div class="b2bmainxlwtable11">
<table width="773" height="222" border="0" cellpadding="0" cellspacing="0">
<tbody>
<tr>
<td width="584" valign="top" >
<!--机票查询-->
<form action="b2bairsearch!tSearch.action" name="form1" id="form1" method="POST" >
<div id="jpcx">
<table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><span style="font-size: 12px; color: #666666;">国内领先低价机票预订网站，提供四千多条国内国际航线特价机票，打折机票的价格查询！</span></td>
  </tr>
</table>
<table width="500" align="center" cellpadding="0" cellspacing="0">
<tr style="height: 45px;">
<td align="left" colspan="4" style="width: 480px">
<span style="font-size: 14px">航程类型</span>
<input checked="checked" name="TravelType" id='rdoSingle' type="radio" value="1" onclick="showBackTypeDate(1);" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_dc" >单程</label>

<input id='rdoBack' type="radio" value="2" name="TravelType" onclick="showBackTypeDate(2);" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_wf" >往返</label>

<input id='rdoLiancheng' type="radio" value="3" name="TravelType" onclick="showBackTypeDate('3');" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_lc"  >中转、联程</label>
</td>
</tr>
<input type="hidden" name="s_type" id="s_type" value="0" />
<tr>
<td style="font-size: 12px;height: 20px;">出发城市</td>
<td style="font-size: 12px;">到达城市</td>
<td style="font-size: 12px; text-align: left;">出发日期</td>
</tr>
<tr>
<td style="height: 30px;">
<input name="StartAirPortName" type="text"  style="width: 134px" id="arrcity" value="<ww:property value='s_sAirPortName' />"  onclick="if(this.value='<ww:property value='s_sAirPortName' />'){this.value='';}" onblur="if(this.value=='') {this.value='<ww:property value='s_sAirPortName' />';};" />
<div id='suggest' class="ac_results"></div>
<input type="hidden" id="city_from_hide" value="<ww:property value='s_sAirPort' />" name="StartAirportCode" />
</td>
<td>
<input name="arrcity_1" type="text" id="tocity" style="width: 134px" value="上海虹桥" onclick="if(this.value='上海虹桥'){this.value='';}" onblur="if(this.value=='') {this.value='上海虹桥';};" />
<div id='suggest2' class="ac_results"></div>
<input type="hidden" id="city_to_hide" name="EndAirportCode" value="SHA" />
</td>
<td>
<input  type="text"  id="txtStartDate" name="FromDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})" style="width:134px;" class="Wdate" />
</td>
</tr>
<tr>
<td id="td_zc" style="font-size: 12px;height: 20px;">
<span  id="flight_input">中转城市</span></td>
<td style="font-size: 12px; text-align: left;">
<span id="query_AirCo" style="">航空公司</span>
</td>
<td style="font-size: 12px; text-align: left;"><span class="flight_input_box" style="margin-top: 17px;"  id="td_zcd">返程日期</span></td>
</tr>
<tr>
<td id="td_zct" style="height: 30px;">
<input type="text" id="arrcity_2" style="width: 134px; display:none;"/>
<input type="text"  disabled="disabled" class="text" name="StartAirPortName-lc" id="arrcity-lc"  style="width: 134px; " />
<div id='suggest-lc' class="ac_results"></div>
<input type="hidden" id="city_from_hide_lc" value="" name="StartAirportCode_lc" />
</div>

</td>

<td>
<input name="txt_airco" type="text" value="所有航空公司" id="txt_airco"  DateControl="" style="width:134px;display: none" />
<select id="ddlAirCom" name="AirCompanyCode" style="width:140px;">
<option value="ALL">----所有航空公司----</option>
<ww:iterator value="listAircompany">
<option value="<ww:property value='aircomcode' />"><ww:property
value="aircomcode" /> <ww:property value="aircomcnname" /></option>
</ww:iterator>
</select></td>
<td id="td_zcdt">
<input  type="text" disabled="disabled" id="txtBackDate" name="BackDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})" class="Wdate" style="color:#D4D0C8;width:134px;" />
</td>
</tr>
<tr>
<td valign="bottom" align="center" colspan="4" style="height: 40px; width: 480px;">
<img id="imgbtn_select" onclick="CheckData('0');" src="b2bticket/images/serchbtn.gif"  style="border-width:0px;cursor:pointer"/>
<img id="imgbtn_select" onclick="CheckData('1');" src="b2bticket/images/gtdx.gif"  style="border-width:0px;cursor:pointer"/>
</td>
</tr>
</table>
</div>
</form>
<!--机票查询结束-->
<!--png导入开始-->
<form name="form2" id="form2" method="post" action="orderinfo!toCreateOrderByPnr.action">
<input type="hidden" name="importtype" value="1" />
<div id="pndr" style="display:none;">
<div style="text-align: left; margin: 20px 0px 5px 70px;">
<table id="rdo_is_tm2" border="0" style="width:446px;">
<tr>
<td><input id="rdo_is_tm2_0" type="radio" name="rdo_is_tm2" value="0" checked="checked" style="cursor:pointer"/><label for="rdo_is_tm2_0" style="cursor:pointer">常规PNR导入</label></td><td><input id="rdo_is_tm2_1" type="radio" name="rdo_is_tm2" value="1" style="cursor:pointer" /><label for="rdo_is_tm2_1" style="cursor:pointer">团队PNR导入(<font color="red">必须是已经K位成功的编码</font>)</label></td>
</tr>
</table>
</div>

<div style="text-align: left; height: 30px; margin-left: 95px; ">PNR：<input name="strPNR" type="text" maxlength="6" id="strPNR" style="width: 90px;" />
&nbsp;&nbsp;
<img  onclick="checkorderdata('strPNR');" name="imgbtn_import2" id="imgbtn_import2" align="absbottom" src="b2bticket/images/daoru.gif" style="border-width:0px;cursor:pointer" />
</div>

<div style="text-align: left; line-height: 18px; margin-left:70px;">
<div class="pnrdiv">
注意事项：<br />
1、该PNR姓名组正确<br />
2、航段组正确、舱位状况正确<br />
3、每个乘客均有真实的SSR FOID 项输入<br />
4、该PNR不能包含票价组项，如FC/FN/FP<br />
<span style="color: Red;"><span style="color: red">5、当儿童编码和成人编码一起导入时，格式为：“成人PNR|儿童PNR”</span></span>
</div>

<div style="clear: both;margin-top:10px;">
<a href="#" style="margin-left: 25px;text-decoration: none;">
<img src="b2bticket/images/rt.png" align="middle" style="border: 0px;"/>
通过RT内容创建订单 -> </a>
</div>
</div>


</div>
</form>
<!--pnr导入结束-->
<!--pnr文本导入开始-->
<form name="form3" id="form3" method="post" action="orderinfo!toCreateOrderByPnr.action">
<input type="hidden" name="importtype" value="2" />
<div id="pndrwz" style="display:none;">
 <table width="500" border="0" align="center">
    <tr>
      <td><label>
        <textarea name="PnrTxtPat" id="PnrTxtPat"  cols="150" class="bginput" style=" background-color: Black; color: #00ff00;  margin: 0 auto; overflow: auto;height: 350px;"></textarea>
      </label></td>
    </tr>
    <tr>
      <td><img onclick="checkorderdata('PnrTxtPat');"  name="imgbtn_import2" id="imgbtn_import2" align="absbottom" src="b2bticket/images/daoru.gif" style="border-width:0px;cursor:pointer" />
      &nbsp;<span style="color: red"><b>特别提示:请及时授权RMK TJ AUTH URC220</b></span>
      </td>
    </tr>
  </table>
<!--<div style="text-align: left; line-height: 18px; margin-left:70px;">
<div class="pnrdiv">
注意事项：<br />
1、该PNR姓名组正确<br />
2、航段组正确、舱位状况正确<br />
3、每个乘客均有真实的SSR FOID 项输入<br />
4、该PNR不能包含票价组项，如FC/FN/FP<br />
<span style="color: Red;"><span style="color: red">5、请对我公司OFFICE:URC220授权</span></span>
</div>
  </div>
--></div>
</form>
<!--pnr导入结束-->
<div id="kfzx" style="display:none;">
<table width="85%" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#09c">
<tbody>

<tr>
<td align="right" bgcolor="#E6EFF8" >24小时免费服务热线:</td>
<td bgcolor="#E6EFF8" style="font-size: 22px;color: red" ><ww:property value='#session.dns.serviceline' /></td>
</tr>

<tr>
<td align="right" bgcolor="#E6EFF8" >催单服务:</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（1）</td>
</tr>

<tr>
<td align="right" bgcolor="#E6EFF8" >国际票:</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（2）</td>
</tr>
<tr>
<td align="right" bgcolor="#E6EFF8" >退改签:</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（3）</td>
</tr>
<tr>
<td align="right" bgcolor="#E6EFF8" >行程单:</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（5）</td>
</tr>
<tr>
<td align="right" bgcolor="#E6EFF8" >保险单</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（6）</td>
</tr>
<tr>
<td align="right" bgcolor="#E6EFF8" >技术支持</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（8）</td>
</tr>
<tr>
<td align="right" bgcolor="#E6EFF8" >投诉建议</td>
<td bgcolor="#E6EFF8" ><ww:property value='#session.dns.serviceline' />请按（9）</td>
</tr>

</tbody>
</table>
<br />
<table width="85%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#09c" class="tblist mt10">
<tbody>
<ww:iterator value="listQqtypenew">
<tr>
<td bgcolor="#E6EFF8"><b><ww:property value="name"/><ww:property value="param1"/></b></td>
</tr>
<tr>
<td height="30" valign="middle" bgcolor="#E6EFF8"><table width="100" border="0">
  <tr >
  <ww:iterator value="GetQQinfoNEWListbyQQtypeID(id)">
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=<ww:property value="qqno"/>&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
 	</ww:iterator>
  </tr>
</table></td>
</tr>
</ww:iterator>

<!--
<tr>
<td bgcolor="#E6EFF8"><b>催单服务(周一至周日工作时间: 00:00-23:59 热线电话：400-648-6998请按1)</b></td>
</tr>
<tr>
<td height="30" valign="middle" bgcolor="#E6EFF8"><table width="100" border="0">
  <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862560&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
	<td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=235586253&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><b>国际票(周一至周日工作时间: 09:00-18:00 热线电话：400-648-6998请按2)</b></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862567&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><b>退改签(周一至周日工作时间: 09:00-18:00 热线电话：400-648-6998请按3)</b></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862566&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><b>行程单 (工作时间:周一至周六 09:00-18:00 热线电话：400-648-6998请按5)</b></td>
</tr>
<tr onmouseout="this.className=&#39;listresult&#39;;" onmouseover="this.className=&#39;listresultMouseOver&#39;" class="listresult">
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862569&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>

<tr>
<td bgcolor="#E6EFF8"><b>保险服务 (工作时间:周一至周日 09:00-18:00 热线电话：400-648-6998请按6)</b></td>
</tr>
<tr onmouseout="this.className=&#39;listresult&#39;;" onmouseover="this.className=&#39;listresultMouseOver&#39;" class="listresult">
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>

<tr>
<td bgcolor="#E6EFF8"><b>技术支持 (工作时间:周一至周五 09:00-18:00 热线电话：400-648-6998请按8)</b></td>
</tr>
<tr onmouseout="this.className=&#39;listresult&#39;;" onmouseover="this.className=&#39;listresultMouseOver&#39;" class="listresult">
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>
<tr>
<td bgcolor="#E6EFF8"><b> (投诉建议 工作时间:周一至周六 09:00- 18:00电话：400-648-6998请按9)</b></td>
</tr>
<tr onmouseout="this.className=&#39;listresult&#39;;" onmouseover="this.className=&#39;listresultMouseOver&#39;" class="listresult">
<td bgcolor="#E6EFF8"><table width="100" border="0">
   <tr >
    <td ><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes' ><img src="b2bticket/images/qq.gif" width="77" height="22" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a></td>
  </tr>
</table></td>
</tr>
-->
</tbody>
</table>
</div>
</td>
<td width="189" valign="top">

<div id="show" style="width:172px;" align="left">
<span style="font-size:14px; ">&nbsp;我的帐户资金情况<br /></span>
<span id="sp_offer"><img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;上级充值K币余额：<br />&nbsp;&nbsp;&nbsp;
<span id="lbl_VMoney" style="color:Red;">0</span>元</span><br />
<span id="sp_show"><img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;发行K币余额：<br />&nbsp;&nbsp;&nbsp;
<span id="lbl_Authority" style="color:Red;">0</span>元
</span><br />
<span id="sp_qian">
<img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;<span id="lbl_qkyc">欠款：</span><br />&nbsp;&nbsp;&nbsp;
<span id="lbl_Qian" style="color:Red;">0.00</span>元
</span>
</div>


</td>
</tr>
</tbody>
</table>
<br />
</div>

</div>
</center>

<div class="div_pt"></div>
<div id="div_notice" class="div_notice">
<ul id="ul1">
<ww:iterator value="sysmessageList" status="ind">
<li style='width:100%;line-height:23px;height:23px;margin:0px;padding:0px'>
<span class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</span>
<a href="#"  onclick="ShowMes(<ww:property value="id" />)"     class="float_left" style="text-decoration:none;cursor:pointer">[平台公告]<ww:property value="title" /></a>
<ww:if test="#ind.index<=1">
<img src='b2bticket/images/new.gif' style='float:left' />
</ww:if>

<span class="float_rigth"><ww:property value="formatTimestampyyyyMMdd(modifytime)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
</ww:iterator>

</ul>
</div>
<div class="div_ptd"></div>
</body>
</html>

<script>
<ww:if test="isSPPolicy==1">
showDetailspnr('lib34','kfzx')
</ww:if>

//MyWin.Create("","<span style='color: red;font-size: 14px;'>紧急重要通知！！！</span>","<span style='color: red;font-size: 16px;'>尊敬的各位代理商： </br>&nbsp;&nbsp;您好！</br>&nbsp;&nbsp;受机房网络影响,导致部分地区无法正常访问系统!我司深表歉意!!!谢谢大家的理解和配合!!!我司会及时和机房沟通协调,第一时间保证大家的正常访问!!!</span>","600","400");
ShowMes(10081);
</script>