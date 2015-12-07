<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link href="main_xc2/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="main_xc2/js/jquery.js"></script>
<script type="text/javascript" src="main_xc2/js/common.js"></script>
<script type="text/javascript" src="main_xc2/js/easySlider1.5.js"></script>
<script type="text/javascript" src="main_xc2/js/accordian.pack.js"></script>

<link rel="stylesheet" type="text/css" href="js/aircity/css/jquery.suggest_xc.css">
<!-- 城市用 -->
		

 <script type="text/javascript" src="js/aircity/js/j.dimensions.js"></script>
 <script type="text/javascript" src="js/aircity/js/aircity.js"></script>
 <script type="text/javascript" src="js/aircity/js/j.suggest.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css" href="js2/resources/css/ext-all.css" />
<script type="text/javascript" src="js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js2/ext-all.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript"> 
$(document).ready( function(){
 			$("#arrcity").val($("#txtsairportname").val());
	        $("#city_from_hide").val($("#txtsairport").val());
	       // $("#city_from_hide_lc").val($("#txtsairport").val());
	       // $("#arrcity-lc").val($("#txtsairportname").val());
	        $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){},attachObject:"#suggest2"});
			//加载联程城市信息
			$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
			//$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
	    	$("#txtStartDate").val(getDateyyyyMMdd(3));
	    	
	    	
	    	
				$('.tel_in').mouseover(function(){
					$('.tel_more').css('display','block');
				});
								
				$('.tel_more').mouseover(function(){
					$('.tel_more').css('display','block');
					
				});
				
				$('.tel_more').mouseout(function(){
					$('.tel_more').css('display','none');
				});
				
				$(".nav_list_in").jCarouselLite({
					btnPrev: "#prev",
					btnNext: "#next",
					easing: "easeInOutExpo",
					speed: 1000,
					visible: 4.8,
					scroll: 2,
					circular: false
				});
				
				$('.side_list>li').find('a:first').toggle(function(){
					$(this).next('ul').slideDown();
				}, function(){
					$(this).next('ul').slideUp();
				});
				
				$('.side_btn').click(function(){
					$('.sidebar').toggle();
				});
				
				
				
				
				
				
			});
			
	function bindroundfromcity()
		{
	        //绑定联程出发城市
	        $("#arrcity-lc").val($("#tocity").val());
	        $("#city_from_hide_lc").val($("#city_to_hide").val());
		}
		
	
		function showBackTypeDate(type)
        {
         
        if(type==1){
         $("#fancheng").html("返程日期");
        document.getElementById("txtBackDate").disabled="disabled";
        document.getElementById("arrcity-lc").disabled="disabled";
        }
        if(type==2){
         $("#fancheng").html("返程日期");
         document.getElementById("txtBackDate").disabled=false;
         document.getElementById("arrcity-lc").disabled="disabled";
        }
        if(type==3){
         document.getElementById("arrcity-lc").disabled=false;
         document.getElementById("txtBackDate").disabled=false;
          $("#fancheng").html("中转日期");
       
        }   
        }
        
        function CheckData(s_ty)
        {
        
        	$("#s_type").val(s_ty);
        
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
            loading('正在为您查询航班信息');
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

  
<div class="container_body clear">


  

<div class="main_right" id="RightBox">
<div id="right">

<div class="zuolan" id="Mobile" onclick="show_menuC()"></div>

<div class="main_right_con">
<div class="query">
<div class="query_header">
<ul id="a0">
	<li class="queryA" style="cursor:pointer;" onclick="query(this,0)">机票查询</li>
	<li class="queryB" style="cursor:pointer;" onclick="query(this,1)">PNR导入</li>
	<li class="queryB" style="cursor:pointer;" onclick="query(this,2)">PNR文本导入</li>
	<li class="queryB" id="kefu" style="cursor:pointer;" onclick="query(this,3)">客服中心</li>
</ul>
</div>
<div class="clear"></div>
<form action="b2bairsearch!tSearch.action" name="form1" id="form1" method="POST" class="tab_form" >
<input type="hidden" name="s_type" id="s_type" value="0" />
<div class="query_con" id="a00">
<div class="ticket_title">国内领先低价机票预订网站，提供四千多条国内国际航线特价机票，打折机票的价格查询！</div>
<div class="ticket_top">
<div class="ticket_name">航程类型：</div>
<input type="radio" class="radio" checked="checked" name="TravelType" id='rdoSingle'  value="1" onclick="showBackTypeDate(1);" style="cursor:pointer" /><span>单程</span>
<input type="radio" class="radio" id='rdoBack'  value="2" name="TravelType" onclick="showBackTypeDate(2);" style="cursor:pointer" /><span>往返</span>
<input type="radio" class="radio" id='rdoBack'  value="3" name="TravelType" onclick="showBackTypeDate(3);" style="cursor:pointer" /><span>联程</span>
</div>
<div class="ticket_con">
<div class="ticket_hang">
<div class="ticket_zi">出发城市</div>
<input type="text" class="text"  name="StartAirPortName" id="arrcity" onclick="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';};" value="北京" />
<div id='suggest' class="ac_results"></div>
<input type="hidden" id="city_from_hide" value="PEK" name="StartAirportCode" />
</div>
<div class="ticket_hang">
<div class="ticket_zi">到达城市</div>
<input type="text" class="text" name="arrcity_1" id="tocity" onclick="if(this.value='上海虹桥'){this.value='';}" onblur="if(this.value=='') {this.value='上海虹桥';};" value="上海虹桥" />
<div id='suggest2' class="ac_results"></div>
<input type="hidden" id="city_to_hide" name="EndAirportCode" value="SHA" />
</div>
<div class="ticket_hang">
<div class="ticket_zi">出发日期</div>
<input type="text" class="text1" id="txtStartDate" name="FromDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})" /></div>
<div class="ticket_hang">
<div class="ticket_zi">中转城市</div>
<input type="text" disabled="disabled" class="text" name="StartAirPortName-lc" id="arrcity-lc"  />
<div id='suggest-lc' class="ac_results"></div>
<input type="hidden" id="city_from_hide_lc" value="" name="StartAirportCode_lc" />
</div>
<div class="ticket_hang">
<div class="ticket_zi">航空公司</div>
							<select id="ddlAirCom" name="AirCompanyCode" style="width:140px;height: 20px;">
								<option value="ALL">----所有航空公司----</option>
								<ww:iterator value="listAircompany">
								<option value="<ww:property value='aircomcode' />"><ww:property
								value="aircomcode" /> <ww:property value="aircomcnname" /></option>
								</ww:iterator>
								</select>
								</div>
<div class="ticket_hang">
<div class="ticket_zi" id="fancheng">返程日期</div>
<input type="text" class="text1" disabled="disabled" id="txtBackDate" name="BackDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})" /></div>
</div>
<div class="clear"></div>
<div class="ticket_bot"><input type="button" class="button" onclick="CheckData('0');"
	value="查询" /><input type="button" class="button" onclick="CheckData('1');" value="柜台查询" /><span></span></div>
</div>
</form>


<div class="query_con" id="a01" style="display: none;">
<div class="pnr_top"><input type="radio" class="radio"
	name="radio" /><span>常规PNR导入</span><input type="radio" class="radio"
	name="radio" /><span>团队PNR导入 <font color="#da7500">(必须是已经K位成功的编码)</font></span></div>
<div class="pnr_hang"><span>PNR</span><input type="text"
	class="text2" value="" /><input type="button" class="button"
	value="导入" /></div>
<div class="pnr_nei">注意事项：<br />
1、该PNR姓名组正确<br />
2、航段组正确、舱位状况正确<br />
3、每个乘客均有真实的SSR FOID 项输入<br />
4、该PNR不能包含票价组项，如FC/FN/FP<br />
<font color="#da7500">5、当儿童编码和成人编码一起导入时，格式为：“成人PNR|儿童PNR”</font><br />
<br />
<a href="#">通过RT内容创建订单 -></a></div>
</div>
<div class="query_con" id="a02" style="display: none;">
<div class="pnrwen_top"><textarea name="" class="textarea"></textarea></div>
<div class="clear"></div>
<div class="pnrwen_con">
<div class="pnrwen_left"><input type="button" class="button1"
	value="导入" /><span>特别提示:请及时授权RMK TJ AUTH URC220</span></div>
<div class="pnrwen_right">注意事项：<br />
1、该PNR姓名组正确 4、该PNR不能包含票价组项，如FC/FN/FP<br />
2、航段组正确、舱位状况正确 <font color="#da7500">5、请对我公司OFFICE:URC220授权</font><br />
3、每个乘客均有真实的SSR FOID 项输入</div>
<div class="clear"></div>
</div>
</div>
<div class="query_con" id="a03" style="display: none;">
<div class="service_top"><span class="service_name">免费服务热线：</span><span
	class="service_nei"><ww:property value="#session.dns.serviceline" /></span><br />
<ww:if test="#session.dns.agentid==46">
<span class="service_name">催单服务：</span><span class="service_nei">400-649-8898请按（1）</span><span
	class="service_name">保险单：</span><span class="service_nei">400-649-8898请按（6）</span><br />
<span class="service_name">国际票：</span><span class="service_nei">400-649-8898请按（2）</span><span
	class="service_name">技术支持：</span><span class="service_nei">400-649-8898请按（8）</span><br />
<span class="service_name">退改签：</span><span class="service_nei">400-649-8898请按（3）</span><span
	class="service_name">投诉建议：</span><span class="service_nei">400-649-8898请按（9）</span><br />
<span class="service_name">行程单：</span><span class="service_nei">400-649-8898请按（5）</span>
</ww:if>
</div>
<div class="clear"></div>
<ww:iterator value="listQqtypenew">
<div class="service_hang"><font color="#0097cd"><ww:property value="name"/></span></font>
<ww:property value="param1"/></div>
<div class="service_qq">
 <ww:iterator value="GetQQinfoNEWListbyQQtypeID(id)">
<a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=<ww:property value="qqno"/>&site=qq&menu=yes'><img src="b2bticket/images/qq.gif" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
</ww:iterator>
	</div>
</ww:iterator>
<div class="clear"></div>

</div>
</div>
<div class="clear" style=""></div>

<div class="main_bot">

<div class="news">
<div class="news_header"><a href="#">更多></a><b>行业动态</b></div>
<div class="news_con">
<ul>
	<li><a href="#">心程旅行网改版成功啦！</a></li>
	<li><a href="#">心程旅行网十大品牌排名最新排行榜</a></li>
	<li><a href="#">心程旅行网改版成功啦！</a></li>
</ul>
</div>
</div>

<div class="annuo">
<div class="news_header"><a href="#">更多></a><b>平台公告</b></div>
<div class="news_con">
<ul>
<ww:iterator value="sysmessageList">
	<!--<li><a href="login!toShowMesInfo_xc.action?sysid=<ww:property value="id" />"><ww:property value="title" /></a></li>
-->
<li><a href="#" onclick="showann('announcement_<ww:property value="id" />');return false;"><ww:property value="title" /></a></li>
</ww:iterator>
</ul>
</div>
</div>





</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<ww:iterator value="sysmessageList">
<div class="announcement" id="announcement_<ww:property value="id" />" style="display: none;">
    <div class="announcement_header" id="ann_biaoti"><ww:property value="title" /></div>
    
    <div class="announcement_day">行业动态  发布日期：<ww:property value="formatTimestampyyyyMMdd(createtime)"/>   最后修改：<ww:property value="formatTimestampyyyyMMdd(modifytime)"/></div>
    
    <div class="announcement_nei" >
    <b>尊敬的客户：</b><br />
	&nbsp;&nbsp;&nbsp;<ww:property value="content" />
　		<br /><br /><br />
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　心程旅行网业务部&nbsp;<ww:property value="formatTimestampyyyyMMdd(createtime)"/>
    </div>
    <div class="announcement_close"><a href="#" onclick="hideann('announcement_<ww:property value="id" />');">关闭</a></div>
  </div>
</ww:iterator> 

</body>
</html>
<script>
<ww:if test="isSPPolicy==4">

 document.getElementById("kefu").click();
</ww:if>

 function hideann(id)
        {
        	$("#"+id).hide();
        }
   function showann(id)
        {
        	$("#"+id).show();
        }
        
              
 //announcement

</script>