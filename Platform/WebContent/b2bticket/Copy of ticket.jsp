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
document.getElementById("lib3").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib32").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib33").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib34").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById(liid).style.backgroundImage="url('images/xlw1.gif')";
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
	

<script type="text/javascript" language="javascript">
        $(document).ready(function()
	     {
	     
	        $("#arrcity").val($("#txtsairportname").val());
	        $("#city_from_hide").val($("#txtsairport").val());
	       // $("#city_from_hide_lc").val($("#txtsairport").val());
	       // $("#arrcity-lc").val($("#txtsairportname").val());
	        $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest2"});
			//加载联程城市信息
			//$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
			//$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
	     });
	    
	     
	     
	   	
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
        document.getElementById("txtBackDate").disabled="disabled";
        }
        if(type==2){
         document.getElementById("txtBackDate").disabled=false;
        }
        if(type=='3'){
        }   
        }
        function CheckData()
        {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
           // var rdoLiancheng=document.getElementById("rdoLiancheng");
            if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
            {
                alert("返程时间不能为空！");
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
           
          // alert("??");
           // loading('正在为您查询航班信息');
           // return;
            document.form1.submit();
            
	        return true;
            
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
        
   function checkorderdata() {

var strpnr=document.getElementById("strPNR").value;

	if(strpnr==''){
	alert("PNR为空!");
	return;
	}
	
	
	document.form2.submit();
}
        
        
	</script>
</head>

<body>

<center>
<div class="topdiv">
<!--机票查询-->
<table>
<tr>
<td class="ie8table">
<div class="div_Search" id="div_Search" style="background-image: url('b2bticket/images/serchbgxlw.gif');"> 
<div class="b2bmainxlwul">
<ul>
<li class="lib3"  id="lib3" onclick="javascript:showDetailspnr('lib3','b2bmainxlwtable11');" style="cursor:pointer">机票查询</li>
<li class="lib32" id="lib32" onclick="javascript:showDetailspnr('lib32','b2bmainxlwtable12');" style="cursor:pointer">PNR导入</li>
</ul>
</div>
<div class="b2bmainxlwtable" id="b2bmainxlwtable1">
<table border="0" cellpadding="0" cellspacing="0" class="div_Table">
<tbody>
<tr>
<td style="width: 584px">
<form action="b2bairsearch!tSearch.action" name="form1" id="form1" method="POST" >
<div id="b2bmainxlwtable11">
<table cellspacing="0" cellpadding="0" width="553" border="0px" style="margin-left:30px; margin-top:10px;">
<tbody>
<tr>
<td valign="bottom" style="text-align: left; height: 25px;">
<span style="font-size: 12px; color: #666666;">国内领先低价机票预订网站，提供四千多条国内国际航线特价机票，打折机票的价格查询！</span></td>
</tr>
<tr>
<td valign="top">
<table width="480px" align="left" cellpadding="0" cellspacing="0">
<tr style="height: 45px;">
<td align="left" colspan="4" style="width: 480px">
<span style="font-size: 14px">航程类型</span>
<input checked="checked" name="TravelType" id='rdoSingle' type="radio" value="1" onclick="showBackTypeDate(1);" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_dc" >单程</label>
<input id='rdoBack' type="radio" value="2" name="TravelType" onclick="showBackTypeDate(2);" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_wf" >往返</label>
<!--<input id='rdoLiancheng' type="radio" value="3" name="TravelType" onclick="showBackTypeDate('3');" style="cursor:pointer"/>
<label style="font-size: 12px;cursor:pointer;" for="rdo_lc"  >中转、联程</label>
--></td>
</tr>
<tr>
<td style="font-size: 12px;height: 20px;">出发城市</td>
<td style="font-size: 12px;">到达城市</td>
<td style="font-size: 12px; text-align: left;">出发日期</td>
</tr>
<tr>
<td style="height: 30px;">
<input name="StartAirPortName" type="text"  style="width: 134px" id="arrcity" value="北京"  onclick="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';};" />
<div id='suggest' class="ac_results"></div>
<input type="hidden" id="city_from_hide" value="PEK" name="StartAirportCode" />
</td>
<td>
<input name="arrcity_1" type="text" id="tocity" style="width: 134px" value="上海虹桥" />
<div id='suggest2' class="ac_results"></div>
<input type="hidden" id="city_to_hide" name="EndAirportCode" value="SHA" />
</td>
<td>
<input  type="text"  id="txtStartDate" name="FromDate" onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" style="width:134px;" class="Wdate" />
</td>
</tr>
<tr>
<td id="td_zc" style="font-size: 12px;height: 20px;">
<span disabled="false" id="flight_input">中转城市</span></td>
<td style="font-size: 12px; text-align: left;">
<span id="BackDatetab" style="display:none;">返程日期</span><span id="query_AirCo" style="">航空公司</span>
</td>
<td style="font-size: 12px; text-align: left;"><span class="flight_input_box" style="margin-top: 17px;"  id="td_zcd">返程日期</span></td>
</tr>
<tr>
<td id="td_zct" style="height: 30px;">
<input type="text" id="arrcity_2" style="width: 134px; display:none;"/>
<input type="text" id="arrcity_21" style="width: 134px; "/></td>
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
<input  type="text" disabled="disabled" id="txtBackDate" name="BackDate" onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" class="Wdate" style="color:#D4D0C8;width:134px;" />
</td>
</tr>
<tr>
<td valign="bottom" align="center" colspan="4" style="height: 40px; width: 480px;">
<!--<input type="image" name="imgbtn_select" id="imgbtn_select" onclick="CheckData();" src="b2bticket/images/serchbtn.gif"  style="border-width:0px;" />
--><img id="imgbtn_select" onclick="CheckData();" src="b2bticket/images/serchbtn.gif"  style="border-width:0px;cursor:pointer"/>
</td>
</tr>
</table>
</td>
</tr>
</tbody>
</table>
</div>
</form>
<form name="form2" id="form2" method="post" action="orderinfo!toCreateOrderByPnr.action">
<div id="b2bmainxlwtable12" style="display:none;">
<div style="text-align: left; margin: 20px 0px 5px 70px;">
<table id="rdo_is_tm2" border="0" style="width:446px;">
<tr>
<td><input id="rdo_is_tm2_0" type="radio" name="rdo_is_tm2" value="0" checked="checked" style="cursor:pointer"/><label for="rdo_is_tm2_0" style="cursor:pointer">常规PNR导入</label></td><td><input id="rdo_is_tm2_1" type="radio" name="rdo_is_tm2" value="1" style="cursor:pointer" /><label for="rdo_is_tm2_1" style="cursor:pointer">团队PNR导入(<font color="red">必须是已经K位成功的编码</font>)</label></td>
</tr>
</table>
</div>
<div style="text-align: left; height: 30px; margin-left: 95px; ">PNR：<input name="strPNR" type="text" maxlength="6" id="strPNR" style="width: 90px;" />
&nbsp;&nbsp;
<img  onclick="checkorderdata();" name="imgbtn_import2" id="imgbtn_import2" align="absbottom" src="b2bticket/images/daoru.gif" style="border-width:0px;cursor:pointer" />
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
</td>
<td valign="top" style="width:172px;">
  <br />
  <br />
  <div id="show" style="width:172px;" align="left">
<span style="font-size:14px; ">&nbsp;我的帐户资金情况<br /><br /></span>
<span id="sp_offer"><img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;上级充值K币余额：<br />&nbsp;&nbsp;&nbsp;
<span id="lbl_VMoney" style="color:Red;">0</span>元</span><br /><br />
<span id="sp_show"><img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;发行K币余额：<br />&nbsp;&nbsp;&nbsp;
<span id="lbl_Authority" style="color:Red;">0</span>元
</span><br /><br />
<span id="sp_qian">
<img src="b2bticket/images/arrow.gif" alt="" style="vertical-align:bottom;"/>&nbsp;<span id="lbl_qkyc">欠款：</span><br />&nbsp;&nbsp;&nbsp;
<span id="lbl_Qian" style="color:Red;">0.00</span>元
</span>
</div>
</td>
</tr>
</tbody>
</table>
</div>
</div>
</td>
</tr>
</table>
<table style="width: 777px;">
<tr>
<!--站内公告-->
<td>
<div id="div_notice" class="div_notice">
<div style="margin-top: 35px;" id="notice1">
<ul id="ul1">
<li style='width:100%;line-height:23px;height:23px;margin:0px;padding:0px'>
<span class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</span><a href="#" target="_blank"  class="float_left" style="text-decoration:none;">[其他公告]国内\国际\客服工作时间</a><span class="float_rigth">2013-05-05&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></li>

<li style='width:100%;line-height:23px;height:23px;margin:0px;padding:0px'><span class="float_left">&nbsp;&nbsp;&nbsp;&nbsp;</span>
<a href="#" target="_blank"  class="float_left" style="text-decoration:none;">[其他公告]美联航正式开通上海至洛杉矶..</a><span class="float_rigth">2013-05-04&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
</ul>
</div>
</div>
</td>
</tr>
</table>
</div>
</center>

</body>
</html>