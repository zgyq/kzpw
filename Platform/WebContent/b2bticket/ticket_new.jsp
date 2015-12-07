<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机票查询</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<style>
td{ padding-left: 3px;}

</style>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/city-control/aircity.js"></script>
<script type="text/javascript" src="js/city-control/j.dimensions.js"></script>
<script type="text/javascript" src="js/city-control/j.suggest.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="js2/resources/css/ext-all.css" />
<script type="text/javascript"
	src="js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js2/ext-all.js"></script>


<!--<script src="js/city-control/popdg_div.js" type=text/javascript></script>
<script src="js/city-control/city.js" type=text/javascript></script>
<link rel=stylesheet type=text/css href="style/city.css" />

--><script type="text/javascript" language="javascript">
        $(document).ready(function()
	     {
	     
	        $("#arrcity").val($("#txtsairportname").val());
	        $("#city_from_hide").val($("#txtsairport").val());
	        $("#city_from_hide_lc").val($("#txtsairport").val());
	        $("#arrcity-lc").val($("#txtsairportname").val());
	        $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest2"});
			//加载联程城市信息
			$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
			$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
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
		
	
		function showBackDate()
        {
            var rdoSingle=document.getElementById("rdoSingle");
            var rdoBack=document.getElementById("rdoBack");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            var lblBackDate=document.getElementById("lblBackDate");
            var divBackDate=document.getElementById("divBackDate");
            if(rdoSingle.checked==true)
            {
                lblBackDate.style.display="none";
                divBackDate.style.display="none";
                $("#tr_diyicheng").hide();
                $("#tr_diercheng").hide();
                $("#tr_dierchenginfo").hide();
                $("#tr_dierchenginfo_date").hide();
                $("#tr_diercheng_kongbaihang").hide();
            }
            if(rdoBack.checked==true)
            {
                lblBackDate.style.display="block";
                divBackDate.style.display="block";
                $("#tr_diyicheng").hide();
                $("#tr_diercheng").hide();
                $("#tr_dierchenginfo").hide();
                $("#tr_dierchenginfo_date").hide();
                $("#tr_diercheng_kongbaihang").hide();
            }
            if(rdoLiancheng.checked==true)
            {
                $("#tr_diyicheng").show();
                $("#tr_diercheng").show();
                $("#tr_dierchenginfo").show();
                $("#tr_dierchenginfo_date").show();
                $("#tr_diercheng_kongbaihang").show();
                lblBackDate.style.display="none";
                divBackDate.style.display="none";
            }
        }
        function CheckData()
        {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
            {
                alert("返程时间不能为空！");
                return false;
            }
            else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
	        {
	                alert("返程日期不能早于出发日期,请检查后重新填写！");
	                return false; 
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
	                return false;
	            }
	            if($("#tocity").val()=="" || $("#city_to_hide").val=="" || $("#tocity").val()=="中文/拼音")
	            {
	                alert("到达城市不能为空，请重新选择！");
	                $("#tocity").focus();
	                return false;
	            }
	            if($("#txtStartDate").val()=="")
	            {
	               alert("出发日期不能为空，请重新选择！");
	                $("#txtStartDate").focus();
	                return false;
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
            loading('正在为您查询航班信息');
            
            
            
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
        
        
        
	</script>
</head>

<body>
<form action="b2bairsearch!tSearch.action" name="form1" id="form1"
	method="POST" onSubmit="return CheckData()">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;查询航班</b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="760" border="1" align="center" cellpadding="0" bordercolor="#b3b3b3"
							cellspacing="0" style="font-size: 12px; border-collapse: collapse; margin-top: 20px;">
                            <tr class="font-blue-xi" style="display:none" id="tr_diyicheng">
							  <td colspan="4"><b>请选择第一程</b></td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity" > 出发城市：</label></div></td>
								<td width="260" align="left"><input type="text"
									name="StartAirPortName" style="border: 1px solid #999999; height: 20px; line-height: 20px;" id="arrcity" value="北京" onclick="showdiv('1');" onclick="if(this.value='北京'){this.value='';}hideddl();" onblur="if(this.value=='') {this.value='北京';};showddl();"/>&nbsp;<span
									style="color: red">*</span>
								<div id='suggest' class="ac_results"></div>
							
								<div id="hid_scity" style="display: none"><ww:include page="../js/city-control/city.jsp"/></div>
								
								<input id="hidcityname" value="arrcity" type="hidden">
								<input id="hidcitycode" value="city_from_hide" type="hidden">
								
				    
								<input type="hidden" id="city_from_hide" value="PEK" name="StartAirportCode" />
								</td>
								<td width="120" height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2"> 目的城市：</label></div></td>
								<td  align="left"><input style="border: 1px solid #999999; height: 20px; line-height: 20px;" type="text" onclick="showdiv('2');"
									name="EndAirPortName" id="tocity" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2' class="ac_results"></div>
								<div id="hid_ecity" style="display: none"><ww:include page="../js/city-control/city2.jsp"/></div>
								<input type="hidden" id="city_to_hide" name="EndAirportCode" />
								</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div></td>
								<td align="left"><input id="txtStartDate"
									style="width: 150px" name="FromDate"
									onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><span style="display: none"
									id="lblBackDate">返程日期：</div></span></td>
								<td align="left">
								<div id="divBackDate" style="display: none"><input
									id="txtBackDate" style="width: 150px" name="BackDate"
									onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></div>
								</td>
								
							</tr>
							<tr class="font-blue-xi" style="display:none" id="tr_diercheng">
							  <td colspan="4"><b>请选择第二程</b></td>
							</tr>
							<tr class="font-blue-xi" style="display:none" id="tr_dierchenginfo">
								<td width="120" height="28" align="right" style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity-lc" > 出发城市：</label></div></td>
								<td width="260" align="left"><input type="text"
									name="StartAirPortName-lc" style="border: 1px solid #999999; height: 20px; line-height: 20px;" id="arrcity-lc" value="北京" onclick="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';}"/>&nbsp;<span
									style="color: red">*</span>
								<div id='suggest-lc' class="ac_results"></div>
								<input type="hidden" id="city_from_hide_lc" value="PEK" name="StartAirportCode_lc" />
								</td>
								<td width="120" height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2-lc"> 目的城市：</label></div></td>
								<td  align="left"><input style="border: 1px solid #999999; height: 20px; line-height: 20px;" type="text"
									name="EndAirPortName-lc" id="tocity-lc" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2-lc' class="ac_results"></div>
								<input type="hidden" id="city_to_hide_lc" name="EndAirportCode_lc" />
								</td>
							</tr>
							<tr class="font-blue-xi" style="display:none" id="tr_dierchenginfo_date">
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div></td>
								<td align="left"><input id="txtStartDate-lc"
									style="width: 150px" name="FromDate_lc"
									onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;"></td>
								<td align="left">
								
								</td>
								
								
							</tr>
							<tr class="font-blue-xi" style="display:none" id="tr_diercheng_kongbaihang">
							  <td colspan="4">&nbsp;</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;">航空公司：</div></td>
								<td><select id="ddlAirCom" name="AirCompanyCode"
									style="width:154px; border: 1px solid #999999">

									<option value="ALL">-------所有航空公司----------</option>

									<ww:iterator value="listAircompany">
										<option value="<ww:property value='aircomcode' />"><ww:property
											value="aircomcode" /> <ww:property value="aircomcnname" /></option>
									</ww:iterator>
								</select></td>
								<td height="28" align="right"  style="padding: 0" ><div style="background: #f0f0f0; height:28px; margin: 1px 0 0 1px; width: 100%;">航程类型：</div></td>
								<td align="left"><input name="TravelType" id="rdoSingle"
									type="radio" checked="checked" value="1"
									onclick="showBackDate();" />单程&nbsp;<input name="TravelType"
									type="radio" value="2" id="rdoBack" onclick="showBackDate();" />往返&nbsp;
									<!--
									
									
									联程<input name="TravelType" type="radio"
									type="radio" value="3" id="rdoLiancheng" onclick="showBackDate();" />
									
									--><!--
									3
								
								
								<span style="color: red">柜台版<input type="checkbox" name="s_type" value="1" /></span>-->
								
								</td>
								
								
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="20px"></td>
					</tr>
					<tr>
						<td align="center"><input type="submit"
							style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" /></td>
					</tr>
					<tr>
						<td>
						<table>
							<tr>
								<td><input type="hidden" value="<ww:property value="s_sAirPortName" />" id="txtsairportname"  /><input type="hidden" value="<ww:property value="s_sAirPort" />" id="txtsairport"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style="color: Red">注意事项:</span></strong></td>
							</tr>
							<tr>
								<td>
								<ul>
									<li id="li1" style="list-style: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="Label1">此处结算价仅供参考，实际价格以订单支付页面为准！</span></li>
								</ul>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td><br />
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;公告信息</b></td>
	</tr>
	<tr>
	<td>
	<ww:iterator value="sysmessageList" status="ind">
			[平台公告]<a href="javascript:void(0)" onclick="alertInfo('<ww:property value="content" />');" title="<ww:property value="content" />"><ww:property value="#ind.index+1" />.&nbsp;&nbsp;<ww:property value="title" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<ww:property value="formatTimestampyyyyMMdd(modifytime)" />
			
				</br>
	  </ww:iterator>
	  <table>
	 
	  </table>
	</td>
	
	</tr>
</table>
</div>
</form>
</body>
</html>
