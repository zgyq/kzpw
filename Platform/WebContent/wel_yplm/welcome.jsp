<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅系统</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="css/b2b_home.css" rel="stylesheet" type="text/css" />
		<!-- 城市控件用 -->
<link rel="stylesheet" type="text/css" href="../js/aircity/css/jquery.suggest_xc.css">
 <script type="text/javascript" src="../js/aircity/js/jquery-1.4.2.min.js"></script>
 <script type="text/javascript" src="../js/aircity/js/j.dimensions.js"></script>
 <script type="text/javascript" src="../js/aircity/js/aircity.js"></script>
 <script type="text/javascript" src="../js/aircity/js/j.suggest.js"></script>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/city-control/jquery.blockUI.js"></script>


<script language="javascript" type="text/javascript" src="../js/citycontrol/functions.js"></script>
<script language="javascript" type="text/javascript" src="../js/citycontrol/city_data_pp.js"></script>
<script language="javascript" type="text/javascript" src="../js/citycontrol/city_date2.js"></script>
	</head>
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
	    
	    	$("#txtStartDate").val(getDateyyyyMMdd(3));
	   		 loadCityData();
	   		 
	   		 $("#txtcheckindate").val(getDateyyyyMMdd(1));
	   		 $("#txtcheckoutdate").val(getDateyyyyMMdd(2));
	   		 
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
function seach(){
    document.form1.submit();

}
 function  showdiv(id,id2){
 $("#"+id2).hide();
   $("#"+id).show();
   }
   
      
	</script>
	<body>
		<div style="width:100%;height:20px;">
		</div>
		<div class="b2b_body">
			<div class="b2b_body_left">
				<div class="b2b_body_left_xinxi" id="agentshow">
					<h2>
						个人中心
					</h2>
					<ul>
						<li>
							账号名称：<ww:property value="#session.loginuser.loginname" />
						</li>
						<li>
							公司名称：<ww:property value="agent.agentcompanyname"/>
						</li>
						<li>
							联系&nbsp;&nbsp;人：<ww:property value="agent.agentcontactname"/>
						</li>
						<li>
							联系电话：<ww:property value="agent.agentphone"/>
						</li>
						<li>
							代理级别：<span>
							<ww:if test="allowlevelcount==2">省代理</ww:if>
							<ww:elseif test="allowlevelcount==1">市代理</ww:elseif>
							<ww:elseif test="allowlevelcount==0">区代理</ww:elseif>
							<ww:else>省代理</ww:else>
							</span>
						</li>
						<a href="#" class="b2b_body_left_xiugaigerenxinxi" onclick="showdiv('agentedit','agentshow');">
							修改个人信息
						</a>
					</ul>
				</div>
				<div class="b2b_body_left_xinxi" style="display: none" id="agentedit">
					<h2>
						个人中心
					</h2>
					<ul>
						<li>
							账号名称：<ww:property value="#session.loginuser.loginname" />
						</li>
						<li>
							公司名称：<ww:property value="agent.agentcompanyname"/>
						</li>
						<li>
							联系&nbsp;&nbsp;人：<input id="linkname" name="linkname" value="<ww:property value="agent.agentcontactname"/>" style="width: 120px;" />
							
							
						</li>
						<li>
							联系电话：<input id="linktel" name="linktel" value="<ww:property value="agent.agentphone"/>" style="width: 120px;" />
						</li>
						<li>
							代理级别：<span>省代理</span>
						</li>
						<a href="#" id="a_edit" class="b2b_body_left_xiugaigerenxinxi" onclick="EditAgent(<ww:property value="agent.id"/>);">
							保存个人信息
						</a>
					</ul>
				</div>
				
				<div style="width:100%;height:10px;">
				</div>
				<div class="b2b_body_left_congzhi">
					<h2>
						话费充值
					</h2>
					<ul>
						<form type="post" action="../ofcard!webmobileRecharge.action" name="form_cz" id="form_cz">
							<input type="hidden" id="vmoney" value='<ww:property value="#request.vmoney"/>' />
							<input type="hidden" name="sname" id='sname' /> 
							<input type="hidden" name="carid" id='carid' />
							<input type="hidden" name="price" id='price' />  
							<div class="b2b_body_left_congzhi_form_user">
							<input type="hidden" name="mobiletype" id="mtype">
								<div>
									手机号码：
									<input type="text" class="b2bformInput" id="phoneone" type="text" name="phonenumber" value="" onblur="validatePhoneyu()">
									<font color="red" id="vphoneone">
									</font>
								</div>
								<div>
									确认号码：
									<input type="text" onblur="validatePhoneyu()" class="b2bformInput" value="" id="phones">
									<font color="red" id="phonetwo">
									</font>
									<b style="border: 0px" class="text" id="address">
									</b>
								</div>
								<div class="b2bformInput_txt">
								支持移动，联通，电信
								</div>
								<div>
									面&nbsp;&nbsp;&nbsp;&nbsp;值：
									<select name="quantity" onchange="priceChange(this.value);">
										
										<option value="0.2">10</option>
										<option value="0.4">20</option>
										<option value="0.6">30</option>
										<option value="1">50</option>
										<option value="2" selected="selected">100</option>
										<option value="6">300</option>
									</select>
									价格：
									<input type="hidden" value="100" id="pervalue">
									<font id="message1"></font>
									<font id="jiage" class="huangf60_16">100</font>
									<font id="danwei">元</font>
									<input type="hidden" id="pervalue" value="100" />
								</div>
								<div class="b2bformInput_button">
									<input type="button" value="确认订单" style="background: url(css/images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;" id="subbtn" onclick="submintform()">
								</div>
							</div>
						</form>
					</ul>	
				</div>
			</div>
			<div class="b2b_body_right">
				<div class="b2b_body_right_top">
					<div class="b2b_body_right_top_kefu">
						<h2>
							客服中心：
						</h2>
						<ul>
							<div class="b2b_body_right_top_kefu_dh">
								崔票电话(国内):010-88786181
								&nbsp;&nbsp;&nbsp;&nbsp;崔票电话(国内):010-88786181 <br />			崔票电话(国际):010-88786181  &nbsp;&nbsp;&nbsp;&nbsp;退改签电话:010-88786181
							</div>
							<li>
								催单（国内）<a href="http://wpa.qq.com/msgrd?v=3&uin=1360596381&site=qq&menu=yes" target="_blank">
								<img style="vertical-align:middle;"  width="77" height="22" border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="css/images/qq.gif">
								</a>
								<a href="http://wpa.qq.com/msgrd?v=3&uin=1360596381&site=qq&menu=yes" target="_blank">
								<img style="vertical-align:middle;"  width="77" height="22" border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="css/images/qq.gif">
								</a>
							</li>
							<li>							
								催单（国际）
								<a href="http://wpa.qq.com/msgrd?v=3&uin=1360596381&site=qq&menu=yes" target="_blank">
								<img style="vertical-align:middle;"  width="77" height="22" border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="css/images/qq.gif">
								</a>
							</li>
							<li>
								退票处理
								&nbsp;&nbsp;&nbsp;<a href="http://wpa.qq.com/msgrd?v=3&uin=1360596381&site=qq&menu=yes" target="_blank">
								<img style="vertical-align:middle;"  width="77" height="22" border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="css/images/qq.gif">
								</a>
							<li>	
								改签处理
								&nbsp;&nbsp;&nbsp;<a href="http://wpa.qq.com/msgrd?v=3&uin=1360596381&site=qq&menu=yes" target="_blank">
								<img style="vertical-align:middle;"  width="77" height="22" border="0" title="点击这里给我发消息" alt="点击这里给我发消息" src="css/images/qq.gif">
								</a>
							</li>
						</ul>
					</div>
					<div class="b2b_body_right_top_kefu_x">
					</div>
					<div class="b2b_body_right_top_gonggao">
						<h2>
							最新公告：
						</h2>
						<ul>
						<ww:iterator value="sysmessageList" status="ind">
							<li>
								<a href="../login!togonggaoinfo.action?sysid=<ww:property value="id" />"><ww:property value="#ind.index+1" />.&nbsp;&nbsp;<ww:property value="title" /></a>
							</li>
							</ww:iterator>
							
						</ul>
					</div>
					<div class="clear">
					</div>
					<div class="b2b_body_right_top_denglu" style="display: none">
						上次登录IP:<span>192.168.1.1</span> 上次登录时间:<span>2014-4-23 18:18:18</span>
					</div>
				</div>
				<div class="clear">
				</div>
				<div style="width:100%;height:40px;">
				</div>
				<div class="b2b_body_right_top_kuaijie">
					<a href="../login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=1" target="member">
						<img src="css/images/guoneijipiao.png" border="0" width="73" height="59"/>
					</a>
					<a href="../login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=2" target="member">
						<img src="css/images/guojijipiao.png" border="0" width="73" height="59"/>
					</a>
					<a href="../login!getMemberByOrder.action?new&puser&ywtype=3" target="member">
						<img src="css/images/jiudian.png" border="0" width="73" height="59"/>
					</a>
					<a href="../customeragent!tohuoche.action" target="member">
						<img src="css/images/huoche.png" border="0" width="73" height="59"/>
					</a>
					<a href="../login!getMemberByOrder.action?new&puser&ywtype=5&rechtype=1" target="member">
						<img src="css/images/chongzhi.png" border="0" width="73" height="59"/>
					</a>
					<a href="#" target="member">
						<img src="css/images/lvyou.png" border="0" width="73" height="59"/>
					</a>
					<a href="../qzseach.action" target="member">
						<img src="css/images/qianzheng.png" border="0" width="73" height="59"/>
					</a>
					<a href="../huoche/zuche.jsp" target="member">
						<img src="css/images/zuche.png" border="0" width="73" height="59"/>
					</a>
				</div>
				<div class="clear">
				</div>
				<div style="width:100%;height:10px;">
				</div>
				<div class="b2b_body_right_top_jipiaochaxun" style="height: 500px;">
					<h2>
						<a href="#" onclick="showdiv('air_div','hotel_div');">机票查询</a>
					</h2>
					<h2>
						<a href="#" onclick="showdiv('hotel_div','air_div');">酒店查询</a>
					</h2>
					
<form action="../b2bairsearch!tSearch.action" name="form2" id="form2"
	method="POST" onSubmit="return CheckData()">
<div id="air_div" >
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg" 
			id="showtd"><b class="anse">&nbsp;&nbsp;&nbsp;查询航班</b></td>
		
	</tr>
	<tr id="hidsearch">
		<td valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="760" border="1" align="center" cellpadding="0"
							bordercolor="#b3b3b3" cellspacing="0"
							style="font-size: 12px; border-collapse: collapse; margin-top: 20px;">
							<tr class="font-blue-xi" style="display: none" id="tr_diyicheng">
								<td colspan="4"><b>请选择第一程</b></td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity"> 出发城市：</label></div>
								</td>
								<td width="260" align="left"><input type="text"
									name="StartAirPortName"
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									id="arrcity"
									value="北京"
									onfocus="if(this.value='北京'){this.value='';}hideddl();"
									onblur="if(this.value=='') {this.value='北京';};showddl();" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest' class="ac_results"></div>
								<input type="hidden" id="city_from_hide"
									value="PEK"
									name="StartAirportCode" /></td>
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2"> 目的城市：</label></div>
								</td>
								<td align="left"><input
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									type="text" name="EndAirPortName" id="tocity"
									value="上海" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2' class="ac_results"></div>
								<input type="hidden" id="city_to_hide" name="EndAirportCode"
									value="SHA" />
								</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div>
								</td>
								<td align="left"><input id="txtStartDate"
									style="width: 150px" name="FromDate"
									value="<ww:property value="flightSearch.FromDate" />"
									onfocus="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>
								
									<td height="28" align="right" style="padding: 0">
									<div
										style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><span
										id="lblBackDate">返程日期：</div>
									</span></td>
									<td align="left">
									<div id="divBackDate"><input id="txtBackDate" disabled="disabled"
										style="width: 150px" name="BackDate"
										value="<ww:property value="flightSearch.BackDate" />"
										onfocus="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"
										class="Wdate" />&nbsp;<span style="color: red">*</span></div>
									</td>
								
							</tr>
						
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航空公司：</div>
								</td>
								<td><select id="ddlAirCom" name="AirCompanyCode"
									style="width: 154px; border: 1px solid #999999">

									<option value="ALL">-------所有航空公司----------</option>

									<ww:iterator value="listAircompany">
										<option value="<ww:property value='aircomcode' />"
											<ww:if test="aircomcode==flightSearch.AirCompanyCode">selected</ww:if>><ww:property
											value="aircomcode" /> <ww:property value="aircomcnname" />
										</option>
									</ww:iterator>
								</select></td>
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航程类型：</div>
								</td>
								<td align="left"><input name="TravelType" id="rdoSingle"
									type="radio" value="1"
									checked
									onclick="showBackTypeDate(1);" />单程&nbsp;<input name="TravelType"
									
									type="radio" value="2" id="rdoBack" onclick="showBackTypeDate(2);" />往返
								&nbsp; <!--
									联程<input name="TravelType" type="radio"
									type="radio" value="3" id="rdoLiancheng" onclick="showBackDate();" />
									
								
								
								<span style="color: red">柜台版</span><input type="checkbox" name="s_type" value="1" <ww:if test="s_type==1">checked</ww:if> />
								--></td>


							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td align="center"><input type="submit"
							style="background: url(../images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" /></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</form>

<div id="hotel_div" style="display: none">
<form action="../hoteluserbook!sousuo.action" method="post" name="form1"
	id="form1">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	height="236">
	<tr>
<td  ><img src="../images/sss3.gif" /></td>	
	<td width="100%" style="background: url('../images/sss2.gif');">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	height="236" >
	<tr><td colspan="3"><div
	style="background: url(../images/ksdf.gif); height: 38px;width: 235px; margin: 0 auto; margin-top: 13px ">
&nbsp;</div></td></tr>
	<tr>
      <td width="23">&nbsp;</td>
		<td>
		<table width="100%" cellpadding="0" cellspacing="0" border="0" class="searchh" style="height: 120px;"  >
			<tr>
				<td align="right"><strong><span style="color: red;">*</span>选择城市</strong></td>
				<td>
                   <input type="text" class="input198" id="txthotelcity" name="hotelcity" value="北京"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " /> 
                   <div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityId" value="15495"  />
		       </td>
		       <td align="right" width="100"><strong>关键字</strong></td>
		       
				<td><input type="text"  maxlength="10" class="input198" name="hotelName" value="" /></td>
			</tr>
			<tr>
				<td align="right" ><strong><span style="color: red;">*</span>入住时间</strong></td>
				<td ><input type="text" class="Wdate input198" id="txtcheckindate"
					name="startDate" value="<ww:property value="startDate"/>"
					onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})" />
				</td>
			
				<td align="right"><strong><span style="color: red;">*</span>离店时间</strong></td>
				<td><input type="text" class="Wdate input198" id="txtcheckoutdate"
					name="endDate" value="<ww:property value="endDate"/>"
					onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
				</td>
			
				<input type="hidden" name="usertype" value="<ww:property value="usertype"/>"  />
			</tr>

			 <tr>
                     
			
				<td align="right"><strong>价格范围</strong></td>
				 <td>
                    <select id="ddlprice" name="s_price" style="width:126px">
                   
                      <option vlaue="0" <ww:if test="s_price=='不限'">selected</ww:if>>不限</option>
                      <option vlaue="1" <ww:if test="s_price=='RMB 250以下'">selected</ww:if>>RMB 250以下</option>
                      <option vlaue="2" <ww:if test="s_price=='RMB 250-400'">selected</ww:if>>RMB 250-400</option>
                      <option vlaue="3" <ww:if test="s_price=='RMB 400-600'">selected</ww:if>>RMB 400-600</option>
                      <option vlaue="4" <ww:if test="s_price=='RMB 600-800'">selected</ww:if>>RMB 600-800</option>
                      <option vlaue="5" <ww:if test="s_price=='RMB 800以上'">selected</ww:if>>RMB 800以上</option>
                    </select>
                </td>
                <td align="right"><strong>星级范围</strong></td>
				 <td>
                    <select id="s_hotelstar" name="s_hotelstar" style="width:126px">
                   
                   
                      <option value="0">不限</option>
                      <option value="1">一星级</option>
                      <option value="2">二星级</option>
                      <option value="3">三星级</option>
                      <option value="4">四星级</option>
                      <option value="5">五星级</option>
                    </select>
                </td>
			</tr>
		</table>
		</td>
        <td width="23">&nbsp;</td>
	</tr>
	<tr>
	<td colspan="3" class="he3">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" background="../images/bj_tj.gif" width="100%" height="40" style="padding: 0">
		<div class="tijiao">
		
		<input type="button" onclick="seach()"
							style="background: url(../images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" />
		</div>
		</td>
	</tr>
	<tr><td colspan="3" height="10px;">&nbsp;</td></tr>
</table>
</td>
<td  style="background: url('../images/sss2.gif');"><img src="../images/sss4.gif" width="23" /></td>
</tr>
</table>
</form>
</div>					

					
					
				</div>
				
			</div>
		</div>
	</body>
</html>

<script type="text/javascript">

function formatCurrency(num) {
num = num.toString().replace(/\|\,/g,'');
if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();
if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+','+
num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + '' + num + '.' + cents);
}
var bmobile=false;

function validatePhoneyu(){
$("#subbtn").attr("disabled","disabled");
 $("#vresult").html("");
 $("#phonetwo").html("");
 $("#vphoneone").html(""); 
 $("#address").html("");
 var phoneone=$("#phoneone").val();
 var mobile=$("#phones").val();
 if(phoneone==""){
   $("#vphoneone").html("请输入您的手机号码");return;
 }else if(isNaN(phoneone)){
   $("#vphoneone").html("请输入正确的手机号码");return;
 }else if(mobile==""){
   $("#phonetwo").html("请再次输入您的手机号码");
   return;
 }else if(isNaN(mobile)){
    $("#phonetwo").html("请输入正确的手机号码");return;
 }else if(phoneone!=mobile){
  $("#phonetwo").html("两次输入不一致");return;
 }else{
if(mobile.length==11){
 $.ajax({
      type:"POST",
      url:"ofcard!ajaxMobileInfo.action",
      data:{phonenumber:mobile},
      success:function(data){
          //eval(data);
          //alert(data);
          if(data!='-1'){
	          if(data=="电信"){
	           $("#mtype").val("3");
	          }else if(data=="联通"){
	            $("#mtype").val("2");
	          } else{
	              $("#mtype").val("1");
	          }
	           bmobile=true;
	           getInprice();
          }else{
          	alert("号码检测失败");
          	//subbtn
          	$("#subbtn").attr("disabled","disabled");
          	 bmobile=false;
          }
           
        
          
      }            
      }); 
  }else{
  bmobile=false;
  }
 }
}

function valiphonenumber(){
  var phoneone=$("#phoneone").val();
  var phones=$("#phones").val();
  if(phoneone!=phones&&phones!=""&&phoneone!=""){
    alert("两次手机号码输入不一致，请重新输入！");
    return false;
  }else{
    if(phoneone==""){
       alert("请输入手机号码");
       return false;
    }
    if(phones==""){
       alert("请再次输入手机号码");
       return false;
    }
  }
  return true;
  }
   
 

function querycallback(ret){
//alert(ret);

//alert("???");
if (ret=='-1'){
       alert("失败");
        //s = "检测失败";  
        
    }else{
       s =obj["City"]+company;
        sg=obj["Province"];
        $("#sname").val(sg);
        bmobile=true;
        if(company=="电信"){
           $("#mtype").val("3");
          }else if(company=="联通"){
            $("#mtype").val("2");
          } else{
              $("#mtype").val("1");
         }
        getInprice();
   
   } 
  
   $("#address").html(s);
}


function getInprice(){
$("#jiage").html("");
 if(bmobile){
   var phones=$("#phones").val();
   var type=$("#mtype").val();
   var price=$("#pervalue").val();
   
   
    $.ajax({
       url:"ofcard!ajaxGetInprice.action",
      type:"POST",
      data:{areaname:phones,pervalue:price,mobiletype:type,para:Math.floor(Math.random()*100)},
      beforeSend:function(){$("#message1").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
        $("#message1").html("");
        
        var carid=data.split("@")[0];
        var pric=data.split("@")[1];
      if(isNaN(pric)){
       $("#subbtn").attr("disabled","disabled");        
        $("#danwei").html("");
        $("#jiage").html("抱歉！"+pric+",暂无法充值。");
      }else{
      
       $("#carid").val(carid);
       $("#price").val(pric);
      $("#subbtn").removeAttr("disabled");
       $("#danwei").html("元");
        $("#jiage").html(pric);
       }
        
        
        
    }
    
    });
  }
}

  
  
  
function submintform(){
 if(valiphonenumber()){ 
   if(confirm("是否确认支付订单？")){
    document.form_cz.submit();  
     }
 
 }

}

function changeCheckMoney(obj){
  if(obj){
   $(".lmoney").removeAttr("disabled");;
  }else{
  $(".lmoney").checked=false;
  $(".lmoney").attr("disabled","disabled");
  $("#fivemoney").attr("checked","checked");
  }
}


function priceChange(price){
//alert(price);
if(price=='0.2'){
price="10";
}
if(price=='0.4'){
price="20";
}
if(price=='0.6'){
price="30";
}
if(price=='1'){
price="50";
}
if(price=='2'){
price="100";
}
if(price=='6'){
price="300";
}


$("#pervalue").val(price);
$("#jiage").html(price);

getInprice();//异步请求5173  获取价格
}


function EditAgent(id){
var linktel=$("#linktel").val();
var linkname=$("#linkname").val();
if(linkname==''){
alert("联系人不能为空!");
$("#linkname").focus();
return;
}
if(linktel==''){
alert("联系人电话不能为空!");
$("#linktel").focus();
return;
}

if(isNaN(linktel)){
 alert("联系人电话格式错误!");
$("#linktel").focus();
return;
}


$.ajax({
       url:"login!ajaxEditAgent.action",
      type:"POST",
      data:{agentid:id,linkname:linkname,linktel:linktel,para:Math.floor(Math.random()*100)},
      //beforeSend:function(){$("#a_edit").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
        if(data=='1'){
        alert("修改成功!");
        window.location.href="../wel_yplm/login!towelcome.action";
        
        }else{
         alert("修改失败!请从新尝试!");
        }
   	 }
    
    });
    
}

</script>
