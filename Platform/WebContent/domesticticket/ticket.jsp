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
<link href="skin/blue/css/b2blist.css" rel="stylesheet" />
<link href="skin/blue/css/public.css" rel="stylesheet" />
<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="skin/blue/css/tip-yellowsimple.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />

<script type="text/javascript" src="js/city-control/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/city-control/aircity.js"></script>
<script type="text/javascript" src="js/city-control/j.dimensions.js"></script>
<script type="text/javascript" src="js/city-control/j.suggest.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/city-control/jquery.poshytip.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" language="javascript">
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
        function showposhytip(controlid)
        {
           $("#"+controlid).poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
        }
        function CheckData()
        {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            if($("#arrcity").val()=="" || $("#city_from_hide").val=="" ||$("#arrcity").val()=="中文/拼音")
            {
                showposhytip("arrcity");
                $("#arrcity").focus();
                return false;
            }
            if($("#tocity").val()=="" || $("#city_to_hide").val=="" || $("#tocity").val()=="中文/拼音")
            {
                showposhytip("tocity");
                $("#tocity").focus();
                return false;
            }
           
           if($("#txtStartDate").val()=="")
	        {
	            showposhytip("txtStartDate");
	            $("#txtStartDate").focus();
	            return false;
	        }
	            
            if(rdoFrom.checked==true)
            {
                if($("#txtStartDate").val()=="")
                {
	                showposhytip("txtStartDate");
		            $("#txtStartDate").focus();
	                return false;
                }
                if($("#txtBackDate").val()=="")
                {
	                showposhytip("txtBackDate");
		            $("#txtBackDate").focus();
	                return false;
                }
                else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
                {
                    $("#txtBackDate").attr("title","返程日期不能早于出发日期,请检查后重新填写！");
	                showposhytip("txtBackDate");
		            $("#txtBackDate").focus();
	                return false;
                }
            }
            
            //联程信息验证
            if(rdoLiancheng.checked==true)
            {
                if($("#arrcity-lc").val()=="" || $("#city_from_hide_lc").val=="" ||$("#arrcity-lc").val()=="中文/拼音")
	            {
	                $("#tocity-lc").attr("title","请输入第二程出发城市！");
	                showposhytip("arrcity-lc");
	                $("#arrcity-lc").focus();
	                return false;
	            }
	            if($("#tocity-lc").val()=="" || $("#city_to_hide_lc").val=="" || $("#tocity-lc").val()=="中文/拼音")
	            {
	                $("#tocity-lc").attr("title","请输入第二程目的城市！");
	                showposhytip("tocity-lc");
	                $("#tocity-lc").focus();
	                return false;
	            }
                if($("#txtStartDate-lc").val()=="")//中文/拼音
	            {
	                $("#txtStartDate-lc").attr("title","请输入第二程出发日期！");
	                showposhytip("txtStartDate-lc");
	                $("#txtStartDate-lc").focus();
	                return false;
	            }
	            else if(Computation($("#txtStartDate").val(),$("#txtStartDate-lc").val())>0)
	            {
	                $("#txtStartDate-lc").attr("title","第二程出发日期不能早于第一程出发日期,请重新选择！");
	                showposhytip("txtStartDate-lc");
	                $("#txtStartDate-lc").focus();
	                return false; 
	            }
            }
            loading('系统正在为您查询');
	        return true;
            
        }
        function hideddl()
        {
            $("#ddlAirCom").hide();
        }
        function showddl()
        {
            $("#ddlAirCom").show();
        }
	</script>
</head>

<body>
<div id="list" class="list_box">

<div class="list_top font-fff"><font class="f">国内机票查询</font> <span
	class="r"></span>

<div class="c"></div>

</div>
<div class="booking">
<div class="other"><span class="f ico_other">&nbsp;</span>请选择您所查询的航班信息:</div>

<div class="information">
<form action="demosticticket!toTicketList.action" name="form1" id="form1" method="POST" onSubmit="return CheckData()">
<table width="100%" width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr class="font-blue-xi" style="display: none" id="tr_diyicheng">
		<td colspan="4"><b>请选择第一程</b></td>
	</tr>
	<tr class="font-blue-xi">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity"> 出发城市：</label></div>
		</td>
		<td width="260" align="left"><input type="text" title="请输入出发城市"
			name="s_depcityname"
			style="border: 1px solid #999999; height: 20px; line-height: 20px;"
			id="arrcity" value="北京"
			onfocus="if(this.value='北京'){this.value='';}hideddl();"
			onblur="if(this.value=='') {this.value='北京';};showddl();" />&nbsp;<span
			style="color: red">*</span>
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="city_from_hide" value="PEK"
			name="s_depcitycode" /></td>
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="city2"> 目的城市：</label></div>
		</td>
		<td align="left"><input title="请输入目的城市"
			style="border: 1px solid #999999; height: 20px; line-height: 20px;"
			type="text" name="s_arrcityname" id="tocity" />&nbsp;<span
			style="color: red">*</span>
		<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="city_to_hide" name="s_arrcitycode" /></td>
	</tr>
	<tr class="font-blue-xi">
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div>
		</td>
		<td align="left"><input id="txtStartDate" style="width: 150px" title="请输入出发日期"
			name="s_startdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="Wdate" />&nbsp;<span style="color: red">*</span></td>
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><span
			style="display: none" id="lblBackDate">返程日期：</div>
		</span></td>
		<td align="left">
		<div id="divBackDate" style="display: none"><input title="请输入返程日期"
			id="txtBackDate" style="width: 150px" name="s_backdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="Wdate" />&nbsp;<span style="color: red">*</span></div>
		</td>

	</tr>
	<tr class="font-blue-xi" style="display: none" id="tr_diercheng">
		<td colspan="4"><b>请选择第二程</b></td>
	</tr>
	<tr class="font-blue-xi" style="display: none" id="tr_dierchenginfo">
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="arrcity-lc"> 出发城市：</label></div>
		</td>
		<td width="260" align="left"><input type="text"
			name="StartAirPortName-lc" title="请输入第二程出发城市"
			style="border: 1px solid #999999; height: 20px; line-height: 20px;"
			id="arrcity-lc" value="北京"
			onfocus="if(this.value='北京'){this.value='';}"
			onblur="if(this.value=='') {this.value='北京';}" />&nbsp;<span
			style="color: red">*</span>
		<div id='suggest-lc' class="ac_results"></div>
		<input type="hidden" id="city_from_hide_lc" value="PEK"
			name="StartAirportCode_lc" /></td>
		<td width="120" height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
			for="city2-lc"> 目的城市：</label></div>
		</td>
		<td align="left"><input title="请输入第二程目的城市"
			style="border: 1px solid #999999; height: 20px; line-height: 20px;"
			type="text" name="EndAirPortName-lc" id="tocity-lc" />&nbsp;<span
			style="color: red">*</span>
		<div id='suggest2-lc' class="ac_results"></div>
		<input type="hidden" id="city_to_hide_lc" name="EndAirportCode_lc" />
		</td>
	</tr>
	<tr class="font-blue-xi" style="display: none"
		id="tr_dierchenginfo_date">
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div>
		</td>
		<td align="left"><input id="txtStartDate-lc" style="width: 150px" title="请输入第二程出发日期"
			name="FromDate_lc"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="Wdate" />&nbsp;<span style="color: red">*</span></td>
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
		</td>
		<td align="left"></td>

	</tr>
	<tr class="font-blue-xi" style="display: none"
		id="tr_diercheng_kongbaihang">
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr class="font-blue-xi"> 
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航空公司：</div>
		</td>
		<td><select id="ddlAirCom" name="s_aircompanycode"
			style="width: 154px; border: 1px solid #999999">
			<option value="">-------所有航空公司----------</option>
			<ww:iterator value="listAirCompany" ><option value="<ww:property value='aircomcode' />"><ww:property
					value="aircomcode" /> <ww:property value="aircomcnname" /></option></ww:iterator>
		</select></td>
		<td height="28" align="right" style="padding: 0">
		<div
			style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航程类型：</div>
		</td>
		<td align="left"><input name="s_traveltype" id="rdoSingle"
			type="radio" checked="checked" value="1" onclick="showBackDate();" />单程&nbsp;<input
			name="s_traveltype" type="radio" value="2" id="rdoBack"
			onclick="showBackDate();" />往返 &nbsp;<input name="s_traveltype"
			type="radio" value="3" id="rdoLiancheng" onclick="showBackDate();" />联程
		</td>
	</tr>
	<tr>
		<td class="bnt_sea" colspan="4"><input type="submit"
			class="button_sea f" value="立即查询" /><span class="tips_sea f">&nbsp;</span><span
			class="font-f00" style="line-height: 20px;">提示：由于航空公司折扣及价格经常变动，最终票价以PAT结果为准！</span></td>
	</tr>

</table>
</form>
</div>
</div>
</body>
</html>


