<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>后台头部</title>
<link rel="stylesheet" type="text/css" href="js/aircity/css/jquery.suggest.css">
<link rel="stylesheet" type="text/css" href="main_xc/css/screen.css" />

		<script type="text/javascript" src="main_xc/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="main_xc/js/jquery.cycle.all.min.js"></script>
		<script type="text/javascript" src="main_xc/js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="main_xc/js/jcarousellite_1.0.1.min.js"></script>
		<script type="text/javascript" src="main_xc/js/jquery.tools.min.js"></script>
		
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
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest2"});
			//加载联程城市信息
			//$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
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
				
				
				
				
				<ww:if test="isSPPolicy==4">
				$(".tab_title").tabs(".tab_cont");
				$('.tab_title>li>a:last').addClass('current');
				$('.tab_cont4').css('display','block');
				$('.tab_title>li>a:first').removeClass('current');
				$('.tab_cont1').css('display','none');
				</ww:if><ww:else>
				$(".tab_title").tabs(".tab_cont");
				</ww:else>
				
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
        document.getElementById("txtBackDate").disabled="disabled";
        }
        if(type==2){
         document.getElementById("txtBackDate").disabled=false;
        }
        if(type=='3'){
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
	
</script> 
</head>
<body >
	<!--
	<div class="side_btn"></div>
		-->
		
		<div class="cont_main">
			<div class="tab_box">
				<ul class="tab_title">
					<li><a href="#">机票查询</a></li>
					<li><a href="#">PNR导入</a></li>
					<li><a href="#">PNR文本导入</a></li>
					<li><a href="#">客服中心</a></li>
				</ul>
				
				<div class="tab_cont_box">
				<div class="tab_cont tab_cont1">
					<p>国内领先低价机票预订网站，提供四千多条国内国际航线特价机票，打折机票的价格查询！</p>
					<form action="b2bairsearch!tSearch.action" name="form1" id="form1" method="POST" class="tab_form" >
					<input type="hidden" name="s_type" id="s_type" value="0" />
					<fieldset>
						<div class="form_radio">
							<span>航程类型：</span>
							<input checked="checked" name="TravelType" id='rdoSingle' type="radio" value="1" onclick="showBackTypeDate(1);" style="cursor:pointer"><label>单程</label>
							<input id='rdoBack' type="radio" value="2" name="TravelType" onclick="showBackTypeDate(2);" style="cursor:pointer"><label>往返</label>
						</div>
						<div class="form_search">
							<div class="search_pane">
								<label>出发城市</label>
								<input type="text" name="StartAirPortName" id="arrcity" onclick="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';};" value="北京">
								<div id='suggest' class="ac_results" style="margin-top: -65px;margin-left: -15px;"></div>
								<input type="hidden" id="city_from_hide" value="PEK" name="StartAirportCode" />
							</div>
							<div class="search_pane">
								<label>到达城市</label>
								<input type="text" name="arrcity_1" id="tocity" onclick="if(this.value='上海虹桥'){this.value='';}" onblur="if(this.value=='') {this.value='上海虹桥';};" value="上海虹桥">
								<div id='suggest2' class="ac_results" style="margin-top: -65px;margin-left: -15px;"></div>
								<input type="hidden" id="city_to_hide" name="EndAirportCode" value="SHA" />
							</div>
							<div class="search_pane">
								<label>出发日期</label>
								<input type="text" id="txtStartDate" name="FromDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"  class="input_date Wdate">
							</div>
							<div class="search_pane">
								<label>中转城市</label>
								<input type="text" value="">
							</div>
							<div class="search_pane">
								<label>航空公司</label>
								<select id="ddlAirCom" name="AirCompanyCode" style="width:140px;">
								<option value="ALL">----所有航空公司----</option>
								<ww:iterator value="listAircompany">
								<option value="<ww:property value='aircomcode' />"><ww:property
								value="aircomcode" /> <ww:property value="aircomcnname" /></option>
								</ww:iterator>
								</select>
							</div>
							<div class="search_pane">
								<label>返程日期</label>
								<input type="text" disabled="disabled" id="txtBackDate" name="BackDate" onclick="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})" class="input_date Wdate">
							</div>
						</div>
						<input type="button" style="float:left; width:120px; height:38px; line-height:38px; line-height:38px; text-align:center; background:#3dc1f1; font-size:16px; color:#fff; font-weight:bold; cursor:pointer; border:none; margin-right:20px;" onclick="CheckData('0');" value="查询" class="btn1">
						<input type="button" style="float:left; width:120px; height:38px; line-height:38px; line-height:38px; text-align:center; background:#3dc1f1; font-size:16px; color:#fff; font-weight:bold; cursor:pointer; border:none; margin-right:20px;" onclick="CheckData('1');" value="柜台查询" class="btn2">
					</fieldset>
					</form>
				</div>
				
				<div class="tab_cont tab_cont2">
					<div class="form_radio2">
						<input type="radio" name="radio2"><label>常规PNR导入</label>
						<input type="radio" name="radio2"><label>团队PNR导入</label>
						<span>（必须是已经K位成功的编码）</span>
					</div>
					<div class="import_row">
						<label>PNR</label>
						<input type="text" value="" class="input_import">
						<input type="submit" value="导入" class="btn2">
					</div>
					
					<div class="care_item">
						<dl>
							<dt>注意事项：</dt>
							<dd>1、该PNR姓名组正确</dd>
							<dd>2、航段组正确、舱位状况正确</dd>
							<dd>3、每个乘客均有真实的SSR FOID 项输入</dd>
							<dd>4、该PNR不能包含票价组项，如FC/FN/FP</dd>
							<dd class="d_on">5、当儿童编码和成人编码一起导入时，格式为：“成人PNR|儿童PNR”</dd>
						</dl>
					</div>
					
					<a href="a_more">通过RT内容创建订单 -></a>
				</div>
				
				<div class="tab_cont tab_cont3">
					<div class="pnr_box"></div>
					<div class="pnr_info">
						<div class="pnr_info1">
							<input type="submit" value="导入" class="pnr_btn">
							<p>特别提示:请及时授权RMK TJ AUTH URC220</p>
						</div>
						<div class="pnr_info2">
							<dl>
								<dt>注意事项：</dt>
								<dd>1、该PNR姓名组正确</dd>
								<dd>2、航段组正确、舱位状况正确 </dd>
								<dd>3、每个乘客均有真实的SSR FOID 项输入</dd>
								<dd>4、该PNR不能包含票价组项，如FC/FN/FP</dd>
								<dd class="d_on">5、请对我公司OFFICE:URC220授权</dd>
							</dl>
						</div>
					</div>
				</div>
					
				<div class="tab_cont tab_cont4">
					<div class="service_info1">
						<ul>
							<li class="li_first"><span>24小时免费服务热线：</span><em><ww:property value='#session.dns.serviceline' /></em></li>
							<li><span>催单服务：</span><em><ww:property value='#session.dns.serviceline' />请按（1）</em></li>
							<li><span>保险单：</span><em><ww:property value='#session.dns.serviceline' />请按（6）</em></li>
							<li><span>国际票：</span><em><ww:property value='#session.dns.serviceline' />请按（2）</em></li>
							<li><span>技术支持：</span><em><ww:property value='#session.dns.serviceline' />请按（8）</em></li>
							<li><span>退改签：</span><em><ww:property value='#session.dns.serviceline' />请按（3）</em></li>
							<li><span>投诉建议：</span><em><ww:property value='#session.dns.serviceline' />请按（9）</em></li>
							<li><span>行程单：</span><em><ww:property value='#session.dns.serviceline' />请按（5）</em></li>
						</ul>
					</div>
					<ww:iterator value="listQqtypenew">
					<div class="service_info2">
						<p><span><ww:property value="name"/></span><ww:property value="param1"/></p>
						 <ww:iterator value="GetQQinfoNEWListbyQQtypeID(id)">
						<a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin=<ww:property value="qqno"/>&site=qq&menu=yes'  class="a_qq1"><img src="b2bticket/images/qq.gif" border="0" alt="点击这里给我发消息" title="点击这里给我发消息" ></a>
						</ww:iterator>
					</div>
					</ww:iterator>
				</div>
				</div>
				
				
			</div>
			
			<div class="cont_news">
				<div class="cont_news_title"><span>行业动态</span><a href="#">更多></a></div>
				<ul class="news_list">
					<li><a href="#">心程旅行网改版成功啦！</a><em>2013-03-13</em></li>
					<li><a href="#">心程旅行网十大品牌排名最新排行榜</a><em>2013-03-13</em></li>
				</ul>
			</div>
		</div><!--end of cont_main-->
		
		<div class="side_right">
			<h2>平台公告</h2>
			<ul class="side_right_list">
			<ww:iterator value="sysmessageList">
				<li><a href="#"><ww:property value="title" /></a><em><ww:property value="formatTimestampyyyyMMdd(modifytime)" /></em></li>
			</ww:iterator>
			</ul>
		</div>
	
</body>
</html>
 