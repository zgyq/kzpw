<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/ticket.css" rel="stylesheet" type="text/css" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<link href="style/global.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.prompt{ background-color: #cccccc; font-size: 12px;}
.huang14_c{ font-size:12px; color:#f48000; font-weight:100;}

</style>
<script language="JavaScript"> 
<!-- 
javascript:window.history.forward(1); 
//--> 
</script> 
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script src="js/jtip.js" type="text/javascript"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script language="javascript">	
	$(document).ready(function() {
		
		$("#form1").validationEngine();
	
	});
    function showDiag(diag,flag)
	{
		document.getElementById(diag).style.display=flag;
	}
	
	//vmoneyaccount 虚拟账户中余额
	//ticketprice   机票票款
    function showvmoneyDialog(vmoneyaccount,ticketprice)
    {
       $("#divmessage").dialog({
		                title:'机票订单处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
		                height: 480
		            });
		 $("#divmessage").dialog("open");
		 $("#divmessage").html("您的账户余额为："+vmoneyaccount+",点击确认后将扣除您账户金额："+ticketprice);
    }
    
    
function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
function colsedispose(){
 Ext.MessageBox.hide();
}
    
</script>
</head>

<body>

<form action="b2bticketorder!add.action" method="post" name="form1"
	id="form1">
	<div id="divmessage" style="text-align:center;display:none; background-color:#fff;left:0px;">正在加载信息...</div>
<div>
<input type="hidden" id="txthidrebate" value="<ww:property value='s_rebatepoint' />" />
<div class="box" style="text-align: center;">
<div class="quan" style="text-align: left"><span class="lan14_cu f">选择机票政策</span>
<span class="r">
<b style="color: #FFF;"><ww:property
	value="getCitynameByAirport(flightOne.StartAirport)" />&nbsp;<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">←</ww:if>→&nbsp;<ww:property
	value="getCitynameByAirport(flightOne.EndAirport)" />&nbsp;出发日期：<ww:property
	value="formatTimestampyyyyMMdd(segmentOne.departtime)" />&nbsp;<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">返程日期：<ww:property value="formatTimestampyyyyMMdd(segmentTwo.departtime)"/></ww:if></b>&nbsp;&nbsp;&nbsp;
</span></div>
<div  style="margin-top: 10px; padding-top: 0; width: 98%; margin: 0 auto;"> 
<div style="font-size: 18px; font-weight: bold;color:#ff0000; text-align: left;"><ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0"><img src="images/fancheng.png" align="absmiddle" />&nbsp;您选择的去程信息：<ww:property
	value="getCitynameByAirport(flightOne.StartAirport)" />→&nbsp;<ww:property
	value="getCitynameByAirport(flightOne.EndAirport)" />&nbsp;出发日期：<ww:property
	value="formatTimestampyyyyMMdd(segmentOne.departtime)" /></b></ww:if></div>
	<table width="100%" id="zrate1_1" style="display: block;">
		<tr>
			<td  align="left"><input type="button"
				value="政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff; cursor: pointer;" onclick="showtable('zrate1_1')"/>&nbsp;
				<!-- 
				<input type="button" value="特殊政策信息( <ww:property value="listgzrate.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable('zrate2_1')" />
	 -->
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc1_1(id)
		{
			<ww:iterator value="listdzrate" status="state">
			<ww:if test="#state.index<2">
			document.getElementById('zrate1_1_<ww:property value="#state.index"/>').style.display="none";
			</ww:if>
			</ww:iterator>
			document.getElementById("zrate1_1_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #0066FF; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%" >
		<tr> 
			<td style="width: 15%;background:#DDECF3">适用政策条数</td>
			
			<td style="width: 15%;background:#DDECF3;display:none">普通返点</td>
			
			<td style="width: 15%;background:#DDECF3">优惠/返点</td>
			<td style="width: 15%;background:#DDECF3">票面结算价</td>
			
			<td style="width: 15%;background:#DDECF3">出票时间</td>
			<td style="width: 15%;background:#DDECF3">废票时间</td>
			
			<td style="width: 15%;background:#DDECF3">出票速度</td>
			
			<td style="width: 10%;background:#DDECF3">选择</td>
		</tr>
		<ww:iterator value="listdzrate" status="state">
			<ww:if test="#state.index<2">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none" ><span id="zate_1_<ww:property value="#state.index+1" />_value"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><span id="zate_1_<ww:property value="#state.index+1" />_youhui"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></span>(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<span id="zate_1_<ww:property value="#state.index+1" />_price"><ww:property value="formatMoney_short(segmentOne.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></span></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				
				<td style="width: 10%;border-top: 1px dashed #999999"><input <ww:if test="segmentOne.zrateid==id">checked="checked"</ww:if> type="radio" name="zrate_one" onclick="showzratedesc1_1('<ww:property value="#state.index"/>');updatezate('zate_1_<ww:property value="#state.index+1" />_','<ww:property value="id"/>','<ww:property value="flightOne.StartAirport" />','<ww:property value="flightOne.EndAirport" />','<ww:property value="segmentOne.flightnumber" />','<ww:property value="outid" />','<ww:property value="agentid" />','<ww:property value="segmentOne.parvalue" />',1);jisuanjiage();" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate1_1_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;<ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
			</ww:if>
			<ww:if test="#state.index==2">
			<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable('zrate1_2')">+更多</a></td>
			</tr>
			</ww:if>
		</ww:iterator>
		</table>
		</div>
		</td>
	</tr>
</table>
<table width="100%" id="zrate1_2" style="display: none;">
		<tr>
			<td align="left"><input type="button"
				value="政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff ;cursor: pointer;" onclick="showtable('zrate1_1')"/>&nbsp;
				<!--  
				<input type="button" value="特殊政策信息(<ww:property value="listgzrate.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable('zrate2_1')" />
	-->
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc1_2(id)
		{
			<ww:iterator value="listdzrate" status="state">
				document.getElementById('zrate1_2_<ww:property value="#state.index"/>').style.display="none";
			</ww:iterator>
			document.getElementById("zrate1_2_"+id).style.display='block';
		}  
		</script>
		<div style="width: 100%; border: 2px solid #0066FF; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr> 
			<td style="width: 15%;background:#DDECF3">适用政策条数</td>
			<td style="width: 15%;background:#DDECF3;display:none">普通返点</td>
			<td style="width: 15%;background:#DDECF3">优惠/返点</td>
			<td style="width: 15%;background:#DDECF3">票面结算价</td>
			
			<td style="width: 15%;background:#DDECF3">出票时间</td>
			<td style="width: 15%;background:#DDECF3">废票时间</td>
			 <td style="width: 15%;background:#DDECF3">出票速度</td>
			
			<td style="width: 10%;background:#DDECF3">选择</td>
		</tr>
		<ww:iterator value="listdzrate" status="state">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>

				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><span id="ratevalue1_2_<ww:property value="id"/>"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><span id="ratevalue1_2_<ww:property value="id"/>_youhui"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></span>(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<span id="ratevalue1_2_<ww:property value="id"/>_price"><ww:property value="formatMoney_short(segmentOne.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></span></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				 <td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else><ww:else>暂无数据</ww:else></td>
				
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio" name="zrate_one" onclick="showzratedesc1_2('<ww:property value="#state.index"/>');updatezate('ratevalue1_2_<ww:property value="id"/>','<ww:property value="id"/>','<ww:property value="flightOne.StartAirport" />','<ww:property value="flightOne.EndAirport" />','<ww:property value="segmentOne.flightnumber" />','<ww:property value="outid" />','<ww:property value="agentid" />','<ww:property value="segmentOne.parvalue" />',1);jisuanjiage()" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate1_2_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;" id="remark1_2_<ww:property value="id"/>"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
		</ww:iterator>
		<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
                <td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
                <td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
                <td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable('zrate1_1')">-收起</a></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
<!-- 第一程特殊政策 -->
<!--  
<table width="100%" id="zrate2_1" style="display: none">
		<tr>
			<td align="left"><input type="button"
				value="普通政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff ;cursor: pointer;" onclick="showtable('zrate1_1')"/>&nbsp;<input
	type="button" value="特殊政策信息( <ww:property value="listgzrate.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable('zrate2_1')" />
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc2_1(id)
		{
			
			<ww:iterator value="listgzrate" status="state">
			<ww:if test="#state.index<4">
			document.getElementById('zrate2_1_<ww:property value="#state.index"/>').style.display="none";
			</ww:if>
			</ww:iterator>
			document.getElementById("zrate2_1_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%" >
		<tr> 
			<td style="width: 15%;background:#ffffcc">适用政策条数</td>
			<td style="width: 15%;background:#ffffcc;display:none">普通返点</td>
			<td style="width: 15%;background:#ffffcc">优惠/返点</td>
			<td style="width: 15%;background:#ffffcc">票面结算价</td>
			
			<td style="width: 15%;background:#ffffcc">出票时间</td>
			<td style="width: 15%;background:#ffffcc">废票时间</td>
			<td style="width: 15%;background:#ffffcc">出票速度</td>
			
			<td style="width: 10%;background:#ffffcc">选择</td>
		</tr>
		<ww:iterator value="listgzrate" status="state">
			<ww:if test="#state.index<4">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" />(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<ww:property value="formatMoney_short(segmentOne.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				 <td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio" name="zrate_one" onclick="showzratedesc2_1('<ww:property value="#state.index"/>');jisuanjiage()" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate2_1_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
			</ww:if>
			<ww:if test="#state.index==4">
			<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable('zrate2_2')">+更多</a></td>
			</tr>
			</ww:if>
		</ww:iterator>
		</table>
		</div>
		</td>
	</tr>
</table>
<table width="100%" id="zrate2_2" style="display: none; display: none;">
		<tr>
			<td align="left"><input type="button"
				value="普通政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff ;cursor: pointer;" onclick="showtable('zrate1_1')"/>&nbsp;<input
	type="button" value="特殊政策信息( <ww:property value="listgzrate.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable('zrate2_1')" />
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc2_2(id)
		{
			<ww:iterator value="listgzrate" status="state">
			document.getElementById('zrate2_2_<ww:property value="#state.index"/>').style.display="none";
			</ww:iterator>
			document.getElementById("zrate2_2_"+id).style.display='block';
		}
		</script>
		 <div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr> 
			<td style="width: 15%;background:#ffffcc">适用政策条数</td>
			<td style="width: 15%;background:#ffffcc;display:none">普通返点</td>
			<td style="width: 15%;background:#ffffcc">优惠/返点</td>
			<td style="width: 15%;background:#ffffcc">票面结算价</td>
			
				
				<td style="width: 15%;background:#ffffcc">出票时间</td>
				<td style="width: 15%;background:#ffffcc">废票时间</td>
			    <td style="width: 15%;background:#ffffcc">出票速度</td>
			<td style="width: 10%;background:#ffffcc">选择</td>
		</tr>
		<ww:iterator value="listgzrate" status="state">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><span id="ratevalue2_2_<ww:property value="id"/>"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" />(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<ww:property value="formatMoney_short(segmentOne.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentOne.parvalue))" /></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio" <ww:if test="segmentOne.zrateid==id">checked="checked"</ww:if> name="zrate_one" onclick="showzratedesc2_2(<ww:property value="#state.index"/>);jisuanjiage()" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate2_2_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="7" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;" id="remark2_2_<ww:property value="id"/>"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
		</ww:iterator>
		<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable('zrate2_1')">-收起</a></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
 -->
<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<table border="0" cellpadding="0" cellspacing="0" width="100%" class="box" style="  margin-left: 1px;">
<tr class="huang12_c" style="background: #DDECF3;font-weight:bold">
	<td style="width: 8%  height: 30px;">航班信息</td>
	<td style="width: 18%">抵达时间／机场</td>
	<td style="width: 10%">折扣/舱位</td>
	<td style="width: 5%;display:none">返点</td>
	<td style="width: 15%">票面价</td>
	<td style="width: 14%">机建/燃油</td>
	<td style="width: 14%">票面结算价</td>
	<td>单张票面价小计</td>
</tr>
<tr style="  line-height: 25px; text-align: center;">
	<td >
	<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td rowspan="2"><img
				src="images/airComlogo/<ww:property value="segmentOne.aircomapnycode" />.gif" /></td>
			<td><ww:property value="segmentOne.flightnumber" /></td>
		</tr>
		<tr>
			<td><ww:property value="segmentOne.aircompanyname" /></td>
		</tr>
	</table>


	</td>
	<td style=" text-align: left;"><img
		src="images/plane1.gif" width="25" height="25" /><span><font
		style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentOne.departtime)" /></font><ww:property
		value="flightOne.StartAirportName" /></span><br />
	<img src="images/plane2.gif" width="25" height="25" /><span><font
		style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentOne.arrivaltime)" /></font><ww:property
		value="flightOne.EndAirportName" /></span></td>
	<td style=" font-size: 14px; line-height: 40px;"><ww:if test="segmentOne.Discount>=100.0">全价</ww:if>
			<ww:else><ww:property value="segmentOne.Discount/10" />折</ww:else>/<ww:property
		value="segmentOne.cabincode" /></td>
	<td style=" font-size: 14px; line-height: 20px;;display:none">
	<ww:if test="segmentOne.ratevalue==null">
	无返点
	</ww:if>
	<ww:else>
	<ww:property
		value="segmentOne.ratevalue" />%<br/>(<ww:property
		value="segmentOne.agentid" />)
	</ww:else>	
	</td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(segmentOne.parvalue)" /></b>/成人</span><br />
	<!--
	
	<ww:if test="segmentOne.discount>100">
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Parvalue,2))" /></b>/儿童</span><br />
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Parvalue,10))" /></b>/婴儿</span><br />
	</ww:if>
	<ww:else>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,2))" /></b>/儿童</span><br />
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" /></b>/婴儿</span><br />
	
	</ww:else>
	-->
	</td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney_string(segmentOne.airportfee)" />/<ww:property value="formatMoney_string(segmentOne.fuelfee)" /></b>(成人)</span><br/>
	<!-- 
	<span><b class="huang14_c" style="line-height: 16px;">￥0/<ww:property value="formatMoney_string(getRoundPrice(segmentOne.fuelfee,2))" /></b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;">￥0/0</b>(婴儿)</span>
	 -->
	</td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<span id="span_segmentinf_priceone"><ww:property value="formatMoney(segmentOne.price)" /></span></b>(成人)</span><br/>
	<!-- 
	<ww:if test="segmentOne.discount>100">
		<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Parvalue,2))" /></b>(儿童)</span><br/>
		<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Parvalue,10))" /></b>(婴儿)</span>
	</ww:if>
	<ww:else>
		<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,2))" /></b>(儿童)</span><br/>
		<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" /></b>(婴儿)</span>
	</ww:else>
	-->
	</td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<span id="span_segmentinf_totalpriceone"><ww:property value="formatMoney(segmentOne.price+segmentOne.fuelfee+segmentOne.airportfee)" /></span></b>(成人)</span><br/>
	<!-- 
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,2)+getRoundPrice(segmentOne.fuelfee,2))" /></b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" /></b>(婴儿)</span>
	 -->
	</td>
	<span>
	<ww:if test="segmentOne.discount>100">
	<input
		type='hidden' id='hidYPriceSin1'
		value='<ww:property value="segmentOne.Parvalue"/>' /> 
	</ww:if>
	<ww:else>
	   <input
		type='hidden' id='hidYPriceSin1'
		value='<ww:property value="segmentOne.yprice"/>' /> 
	</ww:else>	
		
		<input
		type='hidden' id='hidairportFeeSin1'
		value='<ww:property value="segmentOne.airportfee"/>' /> <input
		type='hidden' id='hidfuelFeeSin1'
		value='<ww:property value="segmentOne.fuelfee"/>' />
		<input
		type='hidden' id='hidFullPrice1'
		value='<ww:property value="segmentOne.parvalue"/>' />
		</span>
</tr>
</table>
<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<script>
function showtable(id)
{
	//document.getElementById("zrate2_1").style.display="none";
	//document.getElementById("zrate2_2").style.display="none";
	document.getElementById("zrate1_1").style.display="none";
	document.getElementById("zrate1_2").style.display="none";
	document.getElementById(id).style.display="block";
}
</script>
</div>
<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
<div  style="margin-top: 10px; width:98%; margin:0 auto;">
<div style="font-size: 18px; font-weight: bold; color:#0000ff; text-align: left"><img src="images/qucheng.png" align="absmiddle" />&nbsp;您选择的返程信息：
<ww:property 	value="getCitynameByAirport(flightOne.EndAirport)" />
&nbsp;→&nbsp;
<ww:property	value="getCitynameByAirport(flightOne.StartAirport)" />&nbsp;
返程日期：<ww:property value="formatTimestampyyyyMMdd(segmentTwo.departtime)"/>
</div>
<!--
第二程开始
-->
<table width="100%" id="zrate3_1" style="display: block;">
		<tr>
			<td align="left"><input type="button"
				value="政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" onclick="showtable2('zrate3_1')"/>&nbsp;
				<!-- 
				<input type="button" value="特殊政策信息( <ww:property value="listgzratetwo.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>%  )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable2('zrate4_1')" />
	 -->
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc3_1(id)
		{
			<ww:iterator value="listdzratetwo" status="state">
			<ww:if test="#state.index<2">
			document.getElementById('zrate3_1_<ww:property value="#state.index"/>').style.display="none";
			</ww:if>
			</ww:iterator>
			document.getElementById("zrate3_1_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #0066FF; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr> 
			<td style="width: 15%;background:#DDECF3">适用政策条数</td>
			<td style="width: 15%;background:#DDECF3;display:none">普通返点</td>
			<td style="width: 15%;background:#DDECF3">优惠/返点</td>
			<td style="width: 15%;background:#DDECF3">票面结算价</td>
			 
			<td style="width: 15%;background:#DDECF3">出票时间</td>
			<td style="width: 15%;background:#DDECF3">废票时间</td>
			<td style="width: 15%;background:#DDECF3">出票速度</td>
			
			<td style="width: 10%;background:#DDECF3">选择</td>
		</tr>
		<ww:iterator value="listdzratetwo" status="state">
			<ww:if test="#state.index<2">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">1政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><span id="zate_2_<ww:property value="#state.index+1" />_value"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><span id="zate_2_<ww:property value="#state.index+1" />_youhui"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></span>(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<span id="zate_2_<ww:property value="#state.index+1" />_price"><ww:property value="formatMoney_short(segmentTwo.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></span></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				 <td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio" <ww:if test="segmentTwo.zrateid==id">checked="checked"</ww:if> onclick="showzratedesc3_1('<ww:property value="#state.index"/>');updatezate('zate_2_<ww:property value="#state.index+1" />_','<ww:property value="id"/>','<ww:property value="flightTwo.StartAirport" />','<ww:property value="flightTwo.EndAirport" />','<ww:property value="segmentTwo.flightnumber" />','<ww:property value="outid" />','<ww:property value="agentid" />','<ww:property value="segmentTwo.parvalue" />',2);jisuanjiage()" name="zrate_two" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate3_1_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%; border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
			</ww:if>
			<ww:if test="#state.index==2">
			<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>				
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				
				<td style=" ;border-top: 1px dashed #999999"><a href="javascript:showtable2('zrate3_2')">+更多</a></td>
			</tr>
			</ww:if>
		</ww:iterator>
		</table>
		
		
		
		</div>
		</td>
	</tr>
</table>
<table width="100%" id="zrate3_2" style="display: none;">
		<tr>
			<td align="left"><input type="button"
				value="普通政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" onclick="showtable2('zrate3_1')"/>&nbsp;
				<!--  
				<input type="button" value="特殊政策信息( <ww:property value="listgzratetwo.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable2('zrate4_1')" />
	-->
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc3_2(id)
		{
			<ww:iterator value="listdzratetwo" status="state">
			document.getElementById('zrate3_2_<ww:property value="#state.index"/>').style.display="none";
			</ww:iterator>
			document.getElementById("zrate3_2_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #0066FF; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr >
			<td style="width: 15%;background:#DDECF3">适用政策条数</td>
			<td style="width: 15%;background:#DDECF3;display:none">普通返点</td>
			<td style="width: 15%;background:#DDECF3">优惠/返点</td>
			<td style="width: 15%;background:#DDECF3">票面结算价</td>
			
			<td style="width: 15%;background:#DDECF3">出票时间</td>
			<td style="width: 15%;background:#DDECF3">废票时间</td>
			<td style="width: 15%;background:#DDECF3">出票速度</td>
			
			<td style="background:#DDECF3">选择</td>
		</tr>
		<ww:iterator value="listdzratetwo" status="state">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">1政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><span id="ratevalue3_2_<ww:property value="id"/>"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><span id="ratevalue3_2_<ww:property value="id"/>_youhui"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></span>(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<span id="ratevalue3_2_<ww:property value="id"/>_price"><ww:property value="formatMoney_short(segmentTwo.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></span></td>
			
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
			<td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				 
				<td style=" border-top: 1px dashed #999999"><input type="radio" name="zrate_two" onclick="showzratedesc3_2('<ww:property value="#state.index"/>');updatezate('ratevalue3_2_<ww:property value="id"/>','<ww:property value="id"/>','<ww:property value="flightTwo.StartAirport" />','<ww:property value="flightTwo.EndAirport" />','<ww:property value="segmentTwo.flightnumber" />','<ww:property value="outid" />','<ww:property value="agentid" />','<ww:property value="segmentTwo.parvalue" />',2);jisuanjiage()" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate3_2_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;" id="remark3_2_<ww:property value="id"/>"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
		</ww:iterator>
		<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable2('zrate3_1')">-收起</a></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
<!--  
<table width="100%" id="zrate4_1" style="display: none">
		<tr>
			<td align="left"><input type="button"
				value="普通政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" onclick="showtable2('zrate3_1')"/>&nbsp;<input
	type="button" value="特殊政策信息( <ww:property value="listgzratetwo.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable2('zrate4_1')" />
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc4_1(id)
		{
			<ww:iterator value="listgzratetwo" status="state">
			<ww:if test="#state.index<4">
			document.getElementById('zrate4_1_<ww:property value="#state.index"/>').style.display="none";
			</ww:if>
			</ww:iterator>
			document.getElementById("zrate4_1_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr >
			<td style="width: 15%;background:#ffffcc">适用政策条数</td>
			<td style="width: 15%;background:#ffffcc;display:none">普通返点</td>
			<td style="width: 15%;background:#ffffcc">优惠/返点</td>
			<td style="width: 15%;background:#ffffcc">票面结算价</td>
			 
			<td style="width: 15%;background:#ffffcc">出票时间</td>
			<td style="width: 15%;background:#ffffcc">废票时间</td>
			<td style="width: 15%;background:#ffffcc">出票速度</td>
			 
			<td style="background:#ffffcc">选择</td>
		</tr>
		<ww:iterator value="listgzratetwo" status="state">
			<ww:if test="#state.index<4">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" />(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<ww:property value="formatMoney_short(segmentTwo.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio"  onclick="showzratedesc4_1('<ww:property value="#state.index"/>');jisuanjiage()" name="zrate_two" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate4_1_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
			</ww:if>
			<ww:if test="#state.index==4">
			<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>

				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
                <td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>				 
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable2('zrate4_2')">更多</a></td>
			</tr>
			</ww:if>
		</ww:iterator>
		</table>
		</div>
		</td>
	</tr>
</table>
<table width="100%" id="zrate4_2" style="display: none;">
		<tr>
			<td align="left"><input type="button"
				value="普通政策信息" style=" background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" onclick="showtable2('zrate3_1')"/>&nbsp;<input
	type="button" value="特殊政策信息(<ww:property value="listgzratetwo.size()"/> 条,最高 <ww:property value="formatZrate(Getliudianvalue(listgzrate.get(0).ratevalue))"/>% )" style=" background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="showtable2('zrate4_1')" />
	</td>
	</tr>
	<tr>
		<td>
		<script>
		function showzratedesc4_2(id)
		{
			<ww:iterator value="listgzratetwo" status="state">
			document.getElementById('zrate4_2_<ww:property value="#state.index"/>').style.display="none";
			</ww:iterator>
			document.getElementById("zrate4_2_"+id).style.display='block';
		}
		</script>
		<div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		  <tr >
			<td style="width: 15%;background:#ffffcc">适用政策条数</td>
			<td style="width: 15%;background:#ffffcc;display:none">普通返点</td>
			<td style="width: 15%;background:#ffffcc">优惠/返点</td>
			<td style="width: 15%;background:#ffffcc">票面结算价</td>
			
			<td style="width: 15%;background:#ffffcc">出票时间</td>
			<td style="width: 15%;background:#ffffcc">废票时间</td>
			<td style="width: 15%;background:#ffffcc">出票速度</td>
			 
			<td style="background:#ffffcc">选择</td>
		</tr>
		<ww:iterator value="listgzratetwo" status="state">
			<tr style="">
				<td style="width: 15%;border-top: 1px dashed #999999">政策<ww:property value="#state.index+1" /><ww:property value="getZrateAgentName(agentid)" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999;display:none"><span id="ratevalue4_2_<ww:property value="id"/>"><ww:property value="formatZrate(Getliudianvalue(ratevalue))" /></span></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="formatMoney_short(gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" />(<font color='red'>返点：<ww:property value="formatZrate(Getliudianvalue(ratevalue))" />%</font>)</td>
				<td style="width: 15%;border-top: 1px dashed #999999" class="huang14_c">￥<ww:property value="formatMoney_short(segmentTwo.parvalue-gethuiyouprice(Getliudianvalue(ratevalue)/100,1,segmentTwo.parvalue))" /></td>
				
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="worktime" />-<ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:property value="afterworktime" /></td>
				<td style="width: 15%;border-top: 1px dashed #999999"><ww:if test="speed!=null&&!speed.equals('')"><ww:property value="speed" />分钟</ww:if><ww:else>暂无数据</ww:else></td>
				 
				<td style="width: 10%;border-top: 1px dashed #999999"><input type="radio"  onclick="showzratedesc4_2('<ww:property value="#state.index"/>');jisuanjiage()" name="zrate_two" value='<ww:property value="id"/>'/>&nbsp;</td>
			</tr>
			<tr id="zrate4_2_<ww:property value="#state.index"/>" style="display: none;">
				<td colspan="8" style="width: 100%;border-top: 1px dashed #999999;color:red;font-weight:bold"><span style="float:left; margin-left: 10px;" id="remark4_2_<ww:property value="id"/>"><ww:if test="remark!=null&&!remark.equals('')"><ww:property value="remark"/></ww:if><ww:else>暂无政策备注信息</ww:else></span>&nbsp;</td>
			</tr>
		</ww:iterator>
		<tr>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 15%;border-top: 1px dashed #999999">&nbsp;</td>
				<td style="width: 10%;border-top: 1px dashed #999999"><a href="javascript:showtable2('zrate4_1')">-收起</a></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
-->
<div style="height:10px; line-height: 10px;">&nbsp;</div>
<table border="0" cellpadding="0" width="100%" cellspacing="0" class="box">
<tr class="huang12_c" style="background: #DDECF3;font-weight:bold">
	<td style="width: 8%  height: 30px;">航班信息</td>
	<td style="width: 18%">抵达时间／机场</td>
	<td style="width: 10%">折扣/舱位</td>
	<td style="width: 5%;display:none">返点</td>
	<td style="width: 15%">票面价</td>
	<td style="width: 14%">机建/燃油</td>
	<td style="width: 14%">票面结算价</td>
	<td>单张票面价小计</td>
</tr>
<tr style=" line-height: 25px; text-align: center;">
	<td >
	<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td rowspan="2"><img
				src="images/airComlogo/<ww:property value="segmentTwo.aircomapnycode" />.gif" /></td>
			<td><ww:property value="segmentTwo.flightnumber" /></td>
		</tr>
		<tr>
			<td><ww:property value="segmentTwo.aircompanyname" /></td>
		</tr>
	</table>


	</td>
	<td style=" text-align: left;"><img
		src="images/plane1.gif" width="25" height="25" /><span><font
		style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentTwo.departtime)" /></font><ww:property
		value="flightTwo.StartAirportName" /></span><br />
	<img src="images/plane2.gif" width="25" height="25" /><span><font
		style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
		value="formatTimestampHHmm(segmentTwo.arrivaltime)" /></font><ww:property
		value="flightTwo.EndAirportName" /></span></td>
	<td style=" font-size: 14px; line-height: 40px;"><ww:if test="segmentTwo.Discount>=100.0">全价</ww:if>
			<ww:else><ww:property value="segmentTwo.Discount/10" />折</ww:else>/<ww:property
		value="segmentTwo.cabincode" /></td>
	<td style="width: 5%; font-size: 14px; line-height: 20px;display:none">
	<ww:if test="segmentTwo.ratevalue==null">
	无返点
	</ww:if>
	<ww:else>
	<ww:property
		value="segmentTwo.ratevalue" />%<br/>(<ww:property
		value="segmentTwo.agentid" />)
	</ww:else>	
	</td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(segmentTwo.parvalue)" /></b>/成人</span><br />
	<!--<ww:if test="segmentOne.discount>100">
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Parvalue,2))" /></b>/儿童</span><br />
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Parvalue,10))" /></b>/婴儿</span><br />
	</ww:if>
	<ww:else>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,2))" /></b>/儿童</span><br />
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,10))" /></b>/婴儿</span><br />
	
	</ww:else>
	--></td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney_string(segmentTwo.airportfee)" />/<ww:property value="formatMoney_string(segmentTwo.fuelfee)" /></b>(成人)</span><br/>
	<!--<span><b class="huang14_c" style="line-height: 16px;">￥0/<ww:property value="formatMoney_string(getRoundPrice(segmentTwo.fuelfee,2))" /></b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;">￥0/0</b>(婴儿)</span>
	--></td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<span id="span_segmentinf_pricetwo"><ww:property value="formatMoney(segmentTwo.Price)" /></span></b>(成人)</span><br/>
	<!--<ww:if test="segmentTwo.discount>100">
<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Parvalue,2))" /></b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;">￥<ww:property value="formatMoney(getRoundPrice(segmentTwo.Parvalue,10))" /></b>(婴儿)</span>
</ww:if>
<ww:else>
	<span><b class="huang14_c" style="line-height: 16px;"><ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,2))" /></b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;"><ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,10))" /></b>(婴儿)</span>

</ww:else>

	--></td>
	<td>
	<span><b class="huang14_c" style="line-height: 16px;">￥<span id="span_segmentinf_totalpricetwo"><ww:property value="formatMoney(segmentTwo.Price+segmentTwo.airportfee+segmentTwo.fuelfee)" /></span></b>(成人)</span><br/>
	<!--<span><b class="huang14_c" style="line-height: 16px;">￥0/9</b>(儿童)</span><br/>
	<span><b class="huang14_c" style="line-height: 16px;">￥0/0</b>(婴儿)</span>
	--></td>
	<span>
	<ww:if test="segmentTwo.discount>100">
	<input
		type='hidden' id='hidYPriceSin2'
		value='<ww:property value="segmentTwo.Parvalue"/>' />
	</ww:if>
	<ww:else>
	<input
		type='hidden' id='hidYPriceSin2'
		value='<ww:property value="segmentTwo.yprice"/>' />
	</ww:else>	
	
	 <input
		type='hidden' id='hidairportFeeSin2'
		value='<ww:property value="segmentTwo.airportfee"/>' /> <input
		type='hidden' id='hidfuelFeeSin2'
		value='<ww:property value="segmentTwo.fuelfee"/>' />
		<input
		type='hidden' id='hidFullPrice2'
		value='<ww:property value="segmentTwo.parvalue"/>' />
		</span>
</tr>
</table>
<div style="height:10px; line-height: 10px;">&nbsp;</div>
<script>
function showtable2(id)
{
	//document.getElementById("zrate4_1").style.display="none";
	//document.getElementById("zrate4_2").style.display="none";
	document.getElementById("zrate3_1").style.display="none";
	document.getElementById("zrate3_2").style.display="none";
	document.getElementById(id).style.display="block";
}
</script>
</div>
</ww:if><ww:else>
	<input type='hidden' id='hidYPriceSin2' value='0' />
	<input type='hidden' id='hidairportFeeSin2' value='0' />
	<input type='hidden' id='hidfuelFeeSin2' value='0' />
	<input type='hidden' id='hidFullPrice2' value='0' />
</ww:else>
</div>

<div class="box" style="margin-top: 10px;" id="dengjiren1">
<div class="quan"><font class="lan14_cu">登机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</div>
<div><span style="padding-left: 1%;"> 常用登机人：<span
	style="padding-right: 2%;"><font class="hui_xi"
	style="margin: 0 20px 0 20px;">(如超过2名乘机人，请点击"增加乘机人"按钮)</font></span>
	
			<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<ww:iterator value="listCustPassenger" status="index">
				<input name="" id="u<ww:property value="#index.index"/>"
					type="checkbox" value=""
					onclick="selectadd('<ww:property value="username"/>',1,<ww:if test="getCardbyPassengeId(id)!=null"><ww:property value="getCardbyPassengeId(id).credittypeid"/></ww:if><ww:else>1</ww:else>,<ww:if test="getCardbyPassengeId(id)!=null">'<ww:property value="getCardbyPassengeId(id).creditnumber"/>'</ww:if><ww:else>'证件号码'</ww:else>,'<ww:property value="#index.index"/>');" />&nbsp;<ww:property
					value="username" />
				<ww:if test="#index.index!=0 && #index.index%5==0"><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ww:if>
			</ww:iterator> </span>
			</div>
			<div class="c"></div>

			<div class="box"
				style="width: 98%; margin: 0 auto; margin-bottom: 10px;"><ww:bean
				name="'com.opensymphony.webwork.util.Counter'" id="counter">
				<ww:param name="'first'" value="1" />
				<ww:param name="'last'" value="10" />
			</ww:bean> <ww:iterator value="#counter" status="state">
				<div id="passger<ww:property value="#state.index"/>"
					style="display: none;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					style="text-align: left; line-height: 36px;">
					<tr>
						<td colspan="6"
							style="width: 98%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; margin: 0 auto;"><font
							class="huang12_c f" style="text-indent: 20px;">登机人</font> <span
							class="r" style="margin-right: 20px;display:none"><input
							id="h_savepasenger<ww:property value="#state.index"/>"
							type="checkbox" align="absmiddle" value="1" />&nbsp;&nbsp;保存到常用联系人</span>
						</td>
					</tr>
					<tr>
						<td style="text-indent: 25px; height: 36px;">姓名： <input
							name="h_name" style="width: 80px" desc="姓名"
							id="a<ww:property value="#state.index"/>" type="text" /><font color="red">*</font></td>
						<td>登机人类型： <select name="h_ptype" style="width: 60px"
							onchange="changezjhm(<ww:property value="#state.index"/>)"
							id="b<ww:property value="#state.index"/>">
							<option value="1">成人</option>
							<option value="2">儿童</option>
							<option value="3">婴儿</option>
						</select></td>
						<td><span id="zjlx<ww:property value="#state.index"/>">
						证件类型： <select name="h_idtype" style="width: 70px"
							onchange="changenull(<ww:property value="#state.index"/>)"
							id="c<ww:property value="#state.index"/>">
							<option value="1">身份证</option>
							<option value="3">护照</option>
							<option value="4">港澳通行证</option>
							<option value="5">台湾通行证</option>
							<option value="6">台胞证</option>
							<option value="7">回乡证</option>
						</select>
						 </span> 
						&nbsp;&nbsp;&nbsp;
						<span id="zjhm<ww:property value="#state.index"/>">证件号码：</span>
						<span id='zhengj<ww:property value="#state.index"/>'>
						<input maxlength="18" style="winth:90px;" name="h_idnumber" style="width: 140px" 
							id="d<ww:property value="#state.index"/>" desc="证件号码/出生年月" 
							type="text" /><span
							id="showtishi<ww:property value="#state.index"/>">
						</span>
							</span>
							<font color="red">*</font>
						</td>
						<td width="40px">保险：</td>
						<td style="text-align: left">
						
				<input type="radio" checked="checked" id='bxc<ww:property value="#state.index"/>' 
						name='bxinsurance<ww:property value="#state.index"/>' value="1" id="rdobaoxian"  onclick='showInsurance(1,<ww:property value="#state.index"/>)' />购买&nbsp;&nbsp;
						<input type="radio" id="rdobaoxian2"   name='bxinsurance<ww:property value="#state.index"/>' value="2" onclick='showInsurance(2,<ww:property value="#state.index"/>)'/>不购买</td>
						<td>
						<input type="button" name="" class="button109" style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none"
							value="删除登机人" onclick="del(<ww:property value="#state.index"/>)" />
						<input type="hidden"
							id="pstemp<ww:property value="#state.index"/>" value="" /></td>
					</tr>
					<tr >
						<td colspan="5">
						<input type="hidden" id="bxzcount" value="1" />
				<table id='bxtable<ww:property value="#state.index"/>'  width="100%" border="0" cellspacing="0" cellpadding="0"
					style="text-align: left; line-height: 36px;" >				
					<tr>
					<td style="text-indent: 25px; height: 36px; width: 305px">保险公司：
					<select name="bxname" id='bxname<ww:property value="#state.index"/>'>
					<option value="阳光财产保险股份有限公司">阳光财产保险股份有限公司</option>
					<!--  <option value="太平洋保险">太平洋保险</option>-->
					</select></td>
					<td style="text-indent: 25px; height: 36px;">保险分数：
					<select id='bxcount<ww:property value="#state.index"/>' name="bxcount" style="width: 50px"
					 onchange='changBXmoney(<ww:property value="#state.index"/>,this.value)'>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					</select><font color="#cccccc">￥20元/份</font>
				   <font id='prompt<ww:property value="#state.index"/>' style="display: none;color: #FF8E00">
				    
				  </font>
					</td>					
					</tr>					
					</table>
						</td>
						<td><input type="button" name="" class="button109"  style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none"
							value="增加登机人" onclick="add()" /></td>
					</tr>
				</table>

				</div>
			</ww:iterator>
			<div
				style="width: 90%; line-height: 30px; text-align: center; float: left;"
				id="passgeradd<ww:property value="#state.index+1"/>"><input
				name="h_idnumber" id="ying" type="hidden" value="0" /></div>
			</div>

			<div class="c"></div>
			</div>




			<div class="box f"
				style="display: none; margin-top: 10px; width: 1001px;"
				id="dengjiren2">
			<div class="quan"><font class="lan14_cu">登机人信息</font></div>
			<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</div>

			<div class="c"></div>

			<div class="hangd f"><ww:bean
				name="'com.opensymphony.webwork.util.Counter'" id="counter">
				<ww:param name="'first'" value="1" />
				<ww:param name="'last'" value="9" />
			</ww:bean> <ww:iterator value="#counter" status="state">
				<div id="pa<ww:property value="#state.index"/>"
					style="display: none;">
				<table border="0" cellpadding="0" cellspacing="0" width="99%"
					style="margin: 0 auto;">
					<tr>
						<td colspan="4"
							style="width: 100%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; padding-left: 20px;">
						<font class="huang12_c" style="text-indent: 20px;">登机人</font></td>
					</tr>
					<tr>
						<td style="width: 20%; height: 36px; padding-left: 20px;">姓名：
						<span id="r<ww:property value="#state.index"/>"></span></td>
						<td style="width: 20%; height: 36px;">登机人类型：<span
							id="t<ww:property value="#state.index"/>"></span></td>
						<td style="width: 20%; height: 36px;">证件类型：<span
							id="y<ww:property value="#state.index"/>"></span></td>
						<td style="width: 20%; height: 36px;"><span
							id="cardnumberspan<ww:property value="#state.index"/>">证件号码：</span><span
							id="p<ww:property value="#state.index"/>"></span></td>

					</tr>
				</table>
				</div>
			</ww:iterator>
			
			<div
				style="width: 90%; padding-top: 5px; height: 30px; line-height: 30px; text-align: center; float: left;"
				id="passgeradd<ww:property value="#state.index+1"/>"></div>
			</div>

			<div class="c"></div>
			</div>
			<div class="box" style="margin-top: 10px;">
				<div class="quan"><font class="lan14_cu">支付方式和支付金额</font></div>
			<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolorlight="#CDCDCD"
				bordercolordark="#FFFFFF">
				<tr>
					<td style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">
						支付方式： </td>
					<td>
					    <ww:if test="getLoginUserAgent().agenttype!=1">
						<input type="radio" id="rdowebpay" name="rdopaymethod" value="1" checked="checked" />网上支付（支付宝）
					    &nbsp;&nbsp;
					    <!-- <input type="radio" id="rdovmoney" name="rdopaymethod" value="4">虚拟账户支付</input> -->
					    &nbsp;&nbsp;
					    <!-- 判断加盟商是否具有月结支付权限 -->
					    <ww:if test="getLoginUserAgent().isallowmonthpay==1">
					    <input type="radio" id="rdomonthpay" name="rdopaymethod" value="5" />月结支付
					    &nbsp;&nbsp;
					    </ww:if>
					    </ww:if>
					    <ww:if test="getLoginUserAgent().agenttype==1">
					    <input type="radio" id="saleroom" name="rdopaymethod" value="2" checked="checked" />门市付款
					    &nbsp;&nbsp;
					    <input type="radio" id="sendticket" name="rdopaymethod" value="3">票到付款</input>
					    &nbsp;&nbsp;<font color="red">温馨提示：如果客人已支付，请选择门市付款</font>
					    </ww:if>
					</td>
				</tr>
				<tr>
					<td style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">
						交&nbsp;易&nbsp;费： </td>
					<td>
						&nbsp;<span id="JRprice"><font color="red">￥1.00</span></span>
					</td>
				</tr>
				<tr>
					<td style="height: 60px; background-color: #EDFFED; text-align: center;">
						计算方式： </td>
					<td style="line-height: 25px;">
						&nbsp;订单票面价小计 * 人数 + 平台交易费+保险份数x20 = 支付总金额<br />
						<!--+ 行程单总费用-->
						&nbsp;<span style="color: #BF2800"><span id="CalLab"></span></span>
					</td>
				</tr>
				<tr>
					<td style="height: 26px; background-color: #EDFFED; text-align: center;">
						支付金额： </td>
					<td>
						&nbsp;订单总金额：
						<span id="allprice" style="color:Red;font-size:20pt;font-weight:bold;"></span>
						元 </td>
				</tr>
				<tr style="display:none">
					<td style="height: 26px; background-color: #EDFFED; text-align: center;">
						总&nbsp;利&nbsp;润： </td>
					<td>
						&nbsp;订单总利润：
						<span id="Tprice" style="color:Red;font-size:20pt;font-weight:bold;"></span>
						 <input type="hidden" id="hid_zonglirun" name="s_zonglirun" value='<ww:property value="s_zonglirun" />'>
						 <input type="hidden" id="hid_zonglirun2" name="s_zonglirun2" value='<ww:property value="s_zonglirun2" />'>
						元 <input type="hidden" id="hid_childrate" value="<ww:property value='getchildrate()' />"></td>
				</tr>
			</table>
			</div>
			</div>
			<div style="height: 10px; line-height: 10px;">&nbsp;</div>
			<div id="buttonyulan"
				style="text-align: center; margin-top: 10px; width: 100%; height: 60px;"> 
		 <input name="" id="submitbutton" type="button" onclick="subform()" style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108" value="提交" /> 
 		 <input name="" id="submitbutton" type="button" onclick="history.go(-1)" style="cursor: pointer; background:url(images/108.gif); width:91px; height:27px; line-height:21px; margin:2px; font-size:12px; color:#FFFFFF; text-align:center; font-weight:bold; border:none" class="button108" value="重新选择" /></div>

			<div class="c"></div>
			<!--第五结束--> 
			<input id="HfPersonCount" value="1" type="hidden" /> <input
				id="HfPassNameArr" value="" type="hidden" name="h_name" /> <input
				id="HfIdType" type="hidden" name="h_idtype" /> <input
				id="HfIdNumber" type="hidden" name="h_idnumber" /> <input
				id="HfPassInfo" type="hidden" /> <input id="HfPassTypeInfo"
				type="hidden" value="1" /> <input id="HfIdTypeInfo" type="hidden"
				value="1" /> <input id="HfIdNumberInfo" type="hidden" /> <input
				id="HfTravelType" type="hidden"
				value="<ww:property value="segmentOne.traveltype"/>" /> <input
				id="HfTotalPrice" type="hidden" /> <input id="HfTotalAirportFee"
				type="hidden" /> <input id="HfTotalFuelFee" type="hidden" /> <input
				id="HfCustomerName" type="hidden" /> <input id="hfCustomerCardId"
				type="hidden" /> <input id="hfCustomerID" type="hidden" /> <input
				id="HfAdultNum" type="hidden" value="0" /> <input id="HfChildNum"
				type="hidden" value="0" /> <input id="HfBabyNum" type="hidden"
				value="0" /> <input id="hfAllPassName" type="hidden" /> <input
				id="hfcusGuid" type="hidden" /> <input id="hdfAddress"
				type="hidden" /> <input id="strTotalPriceOne" type="hidden"
				name="strTotalPriceOne"><input id="strTotalPriceTwo"
				type="hidden" name="strTotalPriceTwo">
			</div>
			<input type="hidden" name="h_savepasenger" id="h_savepasenger"
				value="" />
			
</form>
</body>
</html>
<script language="javascript">
	function subform(){
		if(!$('#form1').validationEngine({returnIsValid:true}))
 		{
 			return false;
 		}	
 		//判断虚拟账户余额是否足够支付票款
 		var vfalg="0";
 		var bvmoneceheked=false;
 		if(document.getElementById("rdovmoney")!=null&&document.getElementById("rdovmoney").checked){
 		bvmoneceheked=true;
 		}
 		if(bvmoneceheked){
	 		$.ajax({
	         type:"POST",
	         url:"b2bticketorder!isEnoughVmoney.action?rndmath="+Math.floor(Math.random()*100),
	         async:false,       
	         data:{s_agentid:<ww:property value="#session.loginuser.agentid" />,s_totalpaymoeny:$("#allprice").html()},
	         beforeSend:function(){},   
	         success:function(data){
	           if(data=="1"){
	              alert("您的虚拟账户余额不足，请充值！");
	              vfalg="1";
	           }
	         }            
	         });
	        if(vfalg=="1")
	        {
	           return false;
	        }
        }
		var zrateoneid=GetRadioValue("zrate_one");
		var remark_oneobj=document.getElementById("remark1_2_"+zrateoneid);
		if(remark_oneobj==null)
		{
			remark_oneobj=document.getElementById("remark2_2_"+zrateoneid);
		}

		if(remark_one!=null)
		{
			var remark_one=remark_oneobj.innerHTML;
		}else
		{
			var remark_one="";
		}
		<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
		var zratetwoid=GetRadioValue("zrate_two");
		var remark_twoobj=document.getElementById("remark3_2_"+zratetwoid);
		if(remark_twoobj==null)
		{
			remark_twoobj=document.getElementById("remark4_2_"+zratetwoid);
		}
		if(remark_two!=null)
		{
			var remark_two=remark_twoobj.innerHTML;
		}else
		{
			var remark_two="";
		}
		</ww:if>
		<ww:else>
		var remark_two="";
		</ww:else>
		var message="";
		var b=$("input:radio[name='rdopaymethod']:checked").val();
		
		var fkmethodstr=b==1?"网上支付(支付宝)":b==2?"门市付款":b==3?"票到付款":b==4?"虚拟账户支付":b==5?"月结支付":"网上支付(支付宝)";
		    message="您选择的支付方式为："+fkmethodstr+"。\r\n\r\n";
		    if(b==4)
		    {
		      message+="点击确认后将从您的虚拟账户中支付票款"+$("#allprice").html()+"元.\r\n\r\n";
		    }
		    message+="是否确定提交?";
		if(confirm(message)){
		   dispose('系统正在为您生成订单');
			document.getElementById("submitbutton").disabled="disabled";
			formsubmit();
			
		} 
		else 
		{ 
			return false;
		}
	}
	function changBXmoney(id,value){
	 
	    var money=value*20;
	    var count=$("#bxmoney"+id).html(money);
	    jisuanjiage();
	
	}
	var yuinput="";
	function changezjhm(isd)
	{
	
	 
		    $.validationEngine.closePrompt(".formError",true); 
		    var zjid=document.getElementById("b"+isd).value;
		    $("#d"+isd).removeClass("Wdate");
		    yuinput=$("#zhengj"+isd).html();
			document.getElementById("zjlx"+isd).style.display="block";
			document.getElementById("zjlx"+isd).className="f";
			document.getElementById("zjhm"+isd).innerHTML="&nbsp;&nbsp;证件号码";
			document.getElementById("d"+isd).className="validate[required,cardnumber]";
			$("#zhengj"+isd).html(yuinput);
			$("#d"+isd).val("");
			document.getElementById("showtishi"+isd).innerHTML="";
	     if(zjid==2){//儿童	
	        $("#d"+isd).removeClass("validate[required,cardnumber]");
	        document.getElementById("d"+isd).className="validate[required]";	    
			document.getElementById("zjlx"+isd).style.display="none";
			document.getElementById("zjhm"+isd).innerHTML="出生日期";			
			$("#d"+isd).addClass("Wdate");
			$("#d"+isd).focus(function(){
			WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'{%y-2}-%M-%d',minDate:'{%y-12}-%M-%d'})
			});			
		  }
		if(zjid==3){//婴儿
		    $("#d"+isd).removeClass("validate[required,cardnumber]");
	        document.getElementById("d"+isd).className="validate[required]";	
			document.getElementById("zjlx"+isd).style.display="none";
			document.getElementById("zjhm"+isd).innerHTML="出生日期";
			$("#d"+isd).addClass("Wdate");
			$("#d"+isd).focus(function(){
			WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'{%y-2}-%M-%d'});
			});
		}
		jisuanjiage();
	}
	//其他证件类型只是为空验证
	function changenull(isd)
	{
		$.validationEngine.closePrompt(".formError",true); 
		var zjid=document.getElementById("c"+isd).value;
		if(zjid==1)
		{
			document.getElementById("d"+isd).className="validate[required,cardnumber]";
		}else
		{
			document.getElementById("d"+isd).className="validate[required]";
		}
	}
	function selectadd(username,type,idtype,idnumber,id){
		var check = document.getElementById("u"+id).checked;
		var i=-1;
		if(check==true){
		for(var j=0;j<9;j++)
		{
			var name=document.getElementById("a"+j).value;
			if(name=="")
			{
				i=j;
				break;
			}
		}
		if(i==-1)
		{
			document.getElementById("u"+id).checked=false;
			alert("你选择的乘机人超过九个！不能选择！");
			return;
			
		}
		if(document.getElementById("passger"+i).style.display=="none")
		{
			document.getElementById("ying").value=parseInt(document.getElementById("ying").value)+1;
		}
		document.getElementById("passger"+i).style.display="block";
		document.getElementById("a"+i).value=username;
		document.getElementById("b"+i).value=type;
		document.getElementById("c"+i).value=idtype;
		document.getElementById("d"+i).value=idnumber;
		document.getElementById("a"+i).className="validate[required,custom[ticketCNName]]";
		if(idtype==1)
		{
			document.getElementById("d"+i).className="validate[required,cardnumber]";
		}else
		{
			document.getElementById("d"+i).className="validate[required]";
		}
		
		document.getElementById("pstemp"+i).value=id;
		}else
		{
			for(var j=0;j<9;j++)
			{
				var name=document.getElementById("pstemp"+j).value;
				if(name==id)
				{
					i=j;
					break;
				}
			}
			var suntotal=0;
			for(var h=0;h<9;h++)
			{
				if(document.getElementById("passger"+h).style.display=="none")
				{
					suntotal=parseInt(suntotal)+1;
				}
			}
			if(suntotal!=8)
			{
			document.getElementById("passger"+i).style.display="none";
			document.getElementById("ying").value=parseInt(document.getElementById("ying").value)-1;
			}
			document.getElementById("a"+i).value="";
			document.getElementById("b"+i).value="";
			document.getElementById("c"+i).value="";
			document.getElementById("d"+i).value="";
			document.getElementById("a"+i).className="";
			document.getElementById("d"+i).className="";
			document.getElementById("pstemp"+i).value="";
			
		}
		jisuanjiage();
		$.validationEngine.closePrompt(".formError",true); 
}
 //添加
   function add(){
    
  var suntotal=0;
  var passgerstr=0;
 	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="none")
		{
			suntotal=parseInt(suntotal)+1;
			passgerstr=h;
		}
	}
	if(suntotal!=0)
	{
	  document.getElementById("passger"+passgerstr).style.display="block";
	  document.getElementById("a"+passgerstr).className="validate[required,custom[ticketCNName]]";
	  document.getElementById("d"+passgerstr).className="validate[required,cardnumber]";
	  document.getElementById("ying").value=parseInt(document.getElementById("ying").value)+1;
	  jisuanjiage();
	  $.validationEngine.closePrompt(".formError",true); 
  	}else
  	{
  		alert("对不起！最多只能添加9个乘机人！");
  	}
 }
 //删除
 function del(state){
  var i=document.getElementById("ying").value;
  if(document.getElementById("pstemp"+state).value!="")
  {
  	document.getElementById("u"+document.getElementById("pstemp"+state).value).checked=false;
  	
  }
  var suntotal=0;
	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="none")
		{
			suntotal=parseInt(suntotal)+1;
		}
	}
  if(suntotal!=8)
  {
  document.getElementById("ying").value=i-1;
  $.validationEngine.closePrompt(".formError",true); 
  document.getElementById("passger"+state).style.display="none";
   document.getElementById("a"+state).value="";
  document.getElementById("b"+state).value="1";
  document.getElementById("c"+state).value="1";
  document.getElementById("d"+state).value="";
  document.getElementById("zjlx"+state).style.display="block";
  document.getElementById("zjlx"+state).className="f";
  document.getElementById("zjhm"+state).innerHTML="&nbsp;&nbsp;证件号码:";
  document.getElementById("d"+state).className="";
  document.getElementById("a"+state).className="";
  }else
  {
  document.getElementById("a"+state).value="";
  document.getElementById("b"+state).value="1";
  document.getElementById("c"+state).value="1";
  document.getElementById("d"+state).value="";
  document.getElementById("zjlx"+state).style.display="block";
  document.getElementById("zjlx"+state).className="f";
  document.getElementById("zjhm"+state).innerHTML="&nbsp;&nbsp;证件号码:";
  document.getElementById("d"+state).className="validate[required,cardnumber]";
  document.getElementById("a"+state).className="validate[required,custom[ticketCNName]]";
  }
  $.validationEngine.closePrompt(".formError",true); 
  jisuanjiage();
 }
 //预览 下一步
 function yulan(){
 		
 		
 		if(!$('#form1').validationEngine({returnIsValid:true}))
 		{
 			return false;
 		}
 		var chengren=0;
		var ertong=0;
		var yinger=0;
		for(var h=0;h<9;h++)
		{
			if(document.getElementById("passger"+h).style.display=="block")
			{
			
				if(document.getElementById("b"+h).value==1)
				{
					chengren=parseInt(chengren)+1;
				}
				if(document.getElementById("b"+h).value==2)
				{
					ertong=parseInt(ertong)+1;
				}
				if(document.getElementById("b"+h).value==3)
				{
					yinger=parseInt(yinger)+1;
				}
			}
		}
		if(chengren==0)
		{
			if(yinger>0)
			{
				alert("不能单独预订婴儿票，乘机人至少一个是成人！");
				document.getElementById("submitbutton").disabled="";
				return false;
			}else if(ertong>0)
			{
				alert("不能单独预订儿童票，乘机人至少一个是成人!\r\n如果您是儿童独自乘机，请到柜台人工办理手续");
				document.getElementById("submitbutton").disabled="";
				return false;
			}
		}
		document.getElementById("buttonyulan").style.display="none";
		document.getElementById("buttonsubmit").style.display="block";
		document.getElementById("dengjiren2").style.display="block";
		document.getElementById("dengjiren1").style.display="none";
		var k = document.getElementById("ying").value;
		var passengeruserstr="";
		for(i=0;i<9;i++){
			
			var tempname = document.getElementById("a"+i).value;
			if(tempname=="")
			{}else
			{
			document.getElementById("pa"+i).style.display="block";
			document.getElementById("r"+i).innerHTML=document.getElementById("a"+i).value;
			var type="";
			if(document.getElementById("b"+i).value==1)
			{
				type="成人";
			}
			if(document.getElementById("b"+i).value==2)
			{
				type="儿童";
			}
			if(document.getElementById("b"+i).value==3)
			{
				type="婴儿";
			}
			document.getElementById("t"+i).innerHTML=type;
			if(document.getElementById("b"+i).value==1)
			{
				var typecard="";
				if(document.getElementById("c"+i).value==1)
				{
					typecard="身份证";
				}
				if(document.getElementById("c"+i).value==2)
				{
					typecard="驾驶证";
				}
				if(document.getElementById("c"+i).value==3)
				{
					typecard="护照";
				}
				if(document.getElementById("c"+i).value==4)
				{
					typecard="港澳通行证";
				}
				if(document.getElementById("c"+i).value==5)
				{
					typecard="台湾通行证";
				}
				if(document.getElementById("c"+i).value==6)
				{
					typecard="台胞证";
				}
				if(document.getElementById("c"+i).value==7)
				{
					typecard="回乡证";
				}
			}else
			{
				typecard="无";
				document.getElementById("cardnumberspan"+i).innerHTML="出生日期:";
			}
			document.getElementById("y"+i).innerHTML=typecard;
			document.getElementById("p"+i).innerHTML=document.getElementById("d"+i).value;
			if(document.getElementById("h_savepasenger"+i).checked)
			{
				passengeruserstr=passengeruserstr+"1,"
			}else
			{
				passengeruserstr=passengeruserstr+"2,"
			}
			
			}
		}
		document.getElementById("h_savepasenger").value=passengeruserstr;
}
 //上一步
 function shangyibu()
{
document.getElementById("buttonyulan").style.display="block";
document.getElementById("buttonsubmit").style.display="none";
document.getElementById("dengjiren2").style.display="none";
document.getElementById("dengjiren1").style.display="block";
document.getElementById("dianzixieyi").style.display="block";

document.getElementById("lianxiren2").style.display="none";
document.getElementById("lianxiren1").style.display="block";
//反回行程单
document.getElementById("xingchengdan1").style.display="block";
document.getElementById("xingchengdan2").style.display="none";
}
//计算价格
function jisuanjiage(){
	var chengren=0;
	var ertong=0;
	var yinger=0;
	var sumbaoxian=0;
	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="block")
		{
			if($("#b"+h).val()==1)
			{
				chengren=parseInt(chengren)+1;
			}
			if($("#b"+h).val()==2)
			{
				ertong=parseInt(ertong)+1;
			}
			if($("#b"+h).val()==3)
			{
				yinger=parseInt(yinger)+1;
			}
			if(document.getElementById("bxc"+h).checked){
			   var bxcount=$("#bxcount"+h).val();
			  sumbaoxian=parseInt(sumbaoxian)+parseInt(bxcount);	
			<ww:if test="segmentTwo!=null&&!isInInsrutime(segmentOne.departtime,segmentTwo.departtime)">
			 $("#prompt"+h).show();
			 if(bxcount>1){
			  var oneinsur=Math.ceil(bxcount/2.0);
			  var twoinsur=Math.floor(bxcount/2.0);
			  $("#prompt"+h).html("行程超过7天，将自动为您第一程投保"+oneinsur+"份，第二程投保"+twoinsur+"份");
			  }
			 if(bxcount==1){
			  $("#prompt"+h).html("行程超过7天，保险仅能保障第一程。建议您购买2份以上保险");
			 }
			</ww:if>
			
			}
		}
		
	}
	var zrateoneid=GetRadioValue("zrate_one");
	//alert("zrateoneid=="+zrateoneid);
	
	var zrate_oneobj=document.getElementById("ratevalue1_2_"+zrateoneid);
	
	//alert("zrate_oneobj=="+zrate_oneobj);
	if(zrate_oneobj==null)
	{
		zrate_oneobj=document.getElementById("ratevalue2_2_"+zrateoneid);
	}
	if(zrate_oneobj!=null)
	{
	var zrate_one=zrate_oneobj.innerHTML;
	}else
	{
	var zrate_one=0;
	}
	//alert("zrate_one=="+zrate_one);
	
	
	<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
		var zratetwoid=GetRadioValue("zrate_two");
		var zrate_twoobj=document.getElementById("ratevalue3_2_"+zratetwoid);
		if(zrate_twoobj!=null&&zrate_twoobj=='undefined')
		{
		  zrate_twoobj=document.getElementById("ratevalue4_2_"+zratetwoid);
		  //alert(zrate_twoobj==null);
		}
		if(zrate_two!='undefined'&&zrate_twoobj!=null)
		{
			var zrate_two=zrate_twoobj.innerHTML;
		}else
		{
			var zrate_two=0;
		}
		//sumbaoxian+=sumbaoxian;
		
	</ww:if>
	<ww:else>
		var zrate_two=0;
	</ww:else>
	
	var hidYPriceSin1=document.getElementById("hidYPriceSin1").value;
	var hidairportFeeSin1=document.getElementById("hidairportFeeSin1").value;
	var hidfuelFeeSin1=document.getElementById("hidfuelFeeSin1").value;
	var hidFullPrice1=$("#hidFullPrice1").val();

	//儿童票面价
    var childpriceSingle1=Math.round(hidYPriceSin1*0.5*0.1)*10;//儿童票面价
    //儿童燃油费
    var childFuelSingle1= Math.round(hidfuelFeeSin1*0.5*0.1)*10; //儿童燃油费
    //婴儿票面价
    var babypriceSingle1=Math.round(hidYPriceSin1*0.01)*100*0.1;//婴儿票面价
    
    var varlirun=Math.floor(((parseFloat(hidFullPrice1)*parseFloat(zrate_one)*0.01)*100)/100);
    var chengrenprice1=parseFloat(hidFullPrice1)-varlirun;
    //四舍五入保留两位小数
    chengrenprice1=Math.round(chengrenprice1*100)/100;
    var ertongprice1=parseFloat(childpriceSingle1); //*parseFloat($("#hid_childrate").val())  儿童政策不需要
    ertongprice1 = Math.round(ertongprice1*100)/100;
    var yingerprice1=parseFloat(babypriceSingle1);
    
	var hidYPriceSin2=document.getElementById("hidYPriceSin2").value;
	var hidairportFeeSin2=document.getElementById("hidairportFeeSin2").value;
	var hidfuelFeeSin2=document.getElementById("hidfuelFeeSin2").value;
	var hidFullPrice2=$("#hidFullPrice2").val();
	if(hidFullPrice2=='undefined')
	{
	  hidFullPrice2=0;
	}
	//儿童票面价
    var childpriceSingle2=Math.round(hidYPriceSin2*0.5*0.1)*10;//儿童票面价
    //儿童燃油费
    var childFuelSingle2=Math.round(hidfuelFeeSin2*0.5*0.1)*10;//儿童燃油费
    //婴儿票面价
    var babypriceSingle2=Math.round(hidYPriceSin2*0.01)*100*0.1;//婴儿票面价
    
    var varlirun2=Math.floor(((parseFloat(hidFullPrice2)*parseFloat(zrate_two)*0.01)*100)/100);
    var chengrenprice2=parseFloat(hidFullPrice2)-varlirun2;
    
    //四舍五入保留两位小数
    chengrenprice2=Math.round(chengrenprice2*100)/100;
    var ertongprice2=parseFloat(childpriceSingle2);//*parseFloat($("#hid_childrate").val())
    ertongprice2 =Math.round(ertongprice2*100)/100;
    var yingerprice2=parseFloat(babypriceSingle2)
	
	//单成人总价
	var danchengren=parseFloat(chengrenprice1)+parseFloat(hidairportFeeSin1)+parseFloat(hidfuelFeeSin1)+parseFloat(chengrenprice2)+parseFloat(hidairportFeeSin2)+parseFloat(hidfuelFeeSin2);
	//danchengren=Math.round(danchengren*100)/100;
	
	//平台交易费
	var ptPrice=1;
	
	//总价
	var zongjia=parseFloat(danchengren)*parseFloat(chengren);
	zongjia=zongjia+parseFloat(ertongprice1+childFuelSingle1+ertongprice2+childFuelSingle2)*parseInt(ertong);
	zongjia=zongjia+parseFloat(yingerprice1+yingerprice2)*parseInt(yinger);
	zongjia=zongjia+parseInt(sumbaoxian)*20;
	zongjia=zongjia+ptPrice;
	var allprice=document.getElementById("allprice");
	allprice.innerHTML=Math.round(zongjia*100)/100;
	var CalLab=document.getElementById("CalLab");
    
	CalLab.innerHTML=Math.round((parseFloat(danchengren)*parseInt(chengren)+parseFloat(ertongprice1+childFuelSingle1+ertongprice2+childFuelSingle2)*parseInt(ertong)+(Math.round(yingerprice1* 100) / 100)*yinger)*100)/100 +"+ 1 + "+sumbaoxian+" x 20元 = "+Math.round(zongjia*100)/100;
	
	//利润
	var zonglirun=parseInt((hidFullPrice1*zrate_one)*parseInt(chengren));
	//var ratelirun=1-parseFloat($("#hid_childrate").val());
	//zonglirun=zonglirun;
	
	var zonglirun2=parseInt((hidFullPrice2*zrate_two)*parseInt(chengren));

	var CalLab=document.getElementById("Tprice");
	
	//Tprice.innerHTML=parseInt(Math.round(zonglirun)/100);
	//$("#hid_zonglirun").val(parseInt(Math.round(zonglirun)/100));
	//$("#hid_zonglirun2").val(parseInt(Math.round(zonglirun2)/100));
	
	Tprice.innerHTML=parseInt(parseInt(Math.round(zonglirun)/100)+parseInt(Math.round(zonglirun2)/100)+ptPrice);
	}	


function showdiag(id,state)
	{
		document.getElementById(id).style.display=state;
	}
//用来获取radio值 RValue=GetRadioValue("myradio");
function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}
	add();

 function ltrim(s){  return s.replace( /^\s*/, "");  }  
 function rtrim(s){  return s.replace( /\s*$/, "");  }  
 function trim(s){  return rtrim(ltrim(s));  }  
 
 function formsubmit()
 {
	var chengren=0;
	var ertong=0;
	var yinger=0;
	for(var h=0;h<9;h++)
	{
		if(document.getElementById("passger"+h).style.display=="block")
		{
		
			if(document.getElementById("b"+h).value==1)
			{
				chengren=parseInt(chengren)+1;
			}
			if(document.getElementById("b"+h).value==2)
			{
				ertong=parseInt(ertong)+1;
			}
			if(document.getElementById("b"+h).value==3)
			{
				yinger=parseInt(yinger)+1;
			}
		}
	}
	if(chengren==0)
	{
		if(yinger>0)
		{
			alert("不能单独预订婴儿票，乘机人至少一个是成人!");
			colsedispose();
			document.getElementById("submitbutton").disabled="";
			return false;
		}else if(ertong>0)
		{
			alert("不能单独预订儿童票，乘机人至少一个是成人!\r\n如果您是儿童独自乘机，请到我公司柜台人工办理手续！");
			colsedispose();
			document.getElementById("submitbutton").disabled="";
			return false;
		}
	}
 var h_name="";
 var h_type="";
 var h_idtype="";
 var h_idnumber="";
 var h_insurance="";
 var bxname="";
 var bxcount="";
 for(var i=0;i<9;i++)
 {
 	if(i!=8)
 	{
 	h_name=h_name+document.getElementById("a"+i).value+",";
 	h_type=h_type+document.getElementById("b"+i).value+",";
 	h_idtype=h_idtype+document.getElementById("c"+i).value+",";
 	h_idnumber=h_idnumber+document.getElementById("d"+i).value+",";
 	bxname=bxname+document.getElementById("bxname"+i).value+",";
 	var bcount=document.getElementById("bxcount"+i).value;
 	var b=$("input:radio[name='bxinsurance"+i+"']:checked").val();
 	 if(b==2){
 	 bcount=0;
 	 }
 	 bxcount=bxcount+bcount+",";
 	
 	}
 	else
 	{
 	h_name=h_name+document.getElementById("a"+i).value;
 	h_type=h_type+document.getElementById("b"+i).value;
 	h_idtype=h_idtype+document.getElementById("c"+i).value;
 	h_idnumber=h_idnumber+document.getElementById("d"+i).value;
 	bxname=bxname+document.getElementById("bxname"+i).value;
 	var bcount=document.getElementById("bxcount"+i).value;
 	var b=$("input:radio[name='bxinsurance"+i+"']:checked").val();
 	 if(b==2){
 	 bcount=0;
 	 }
    bxcount=bxcount+bcount;
 	}
 }
 var zrate_one= GetRadioValue('zrate_one');
 var zrate_two= GetRadioValue('zrate_two');
 var s_paymethod="1";
 var varzonglirun=$("#hid_zonglirun").val();
 var varzonglirun2=$("#hid_zonglirun2").val();
 var b=$("input:radio[name='rdopaymethod']:checked").val();
   s_paymethod=b;

 $.post("b2bticketorder!add.action",{ zrate_one: zrate_one, zrate_two:zrate_two,h_name:h_name,h_ptype:h_type,h_idtype:h_idtype,h_idnumber:h_idnumber,s_paymethod:s_paymethod,s_zonglirun:varzonglirun,s_zonglirun2:varzonglirun2,bxname:bxname,bxcount:bxcount },function(data){
    if(data=="NOPNR")
    {
    	colsedispose();
    	alert("PNR创建失败，请重试！");
    	document.getElementById("submitbutton").disabled="";
    }else
    {
    	window.location=data;
    }
   }
); 
 	
 }
 
 function showInsurance(yn,id){
    if(yn==1){
      $("#bxtable"+id).show();
    }else{
    $("#bxtable"+id).hide();
    }
    
    jisuanjiage();
 }
 
 function updatezate(indexid,zateid,fromcity,tocity,aircompanycode,waiid,zatetype,parvalue,type){//indexid为位置 waiid 外部政策id  zatetype政策加盟商
 dispose('正在加载政策信息');
 // return;
 // alert(type);
  $.post("b2bticketorder!SeachZateAndUpdate.action",{ajax_zid:zateid,ajax_fromcity:fromcity,ajax_tocity:tocity,ajax_code:aircompanycode,ajax_waiid:waiid,ajax_zatetype:zatetype,parvalue:parvalue,ajax_vogtype:type},function(data){
    if(data)
    {
    colsedispose();
   			 if(data!='-1'){
   			    if(type=="1")
   			    {
	   			 	var zvalue_youhui_price = data.split(",");   
	   			 	if(indexid.indexOf("ratevalue1_2_")!=-1){//第一程,更多政策
	   			 	document.getElementById(indexid).innerHTML=zvalue_youhui_price[0];
		    		document.getElementById(indexid+"_youhui").innerHTML=zvalue_youhui_price[1];
		    		document.getElementById(indexid+"_price").innerHTML=zvalue_youhui_price[2];
		    		$("#span_segmentinf_priceone").html(zvalue_youhui_price[2]);
		    		var totalpriceone=parseFloat($("#hidfuelFeeSin1").val())+parseFloat($("#hidairportFeeSin1").val())+parseFloat(zvalue_youhui_price[2]);
		    		$("#span_segmentinf_totalpriceone").html(totalpriceone+".00");
	   			 	}else{//第一程默认显示的5个
		   		    document.getElementById(indexid+"value").innerHTML=zvalue_youhui_price[0];
		    		document.getElementById(indexid+"youhui").innerHTML=zvalue_youhui_price[1];
		    		document.getElementById(indexid+"price").innerHTML=zvalue_youhui_price[2];
		    		$("#span_segmentinf_priceone").html(zvalue_youhui_price[2]);
		    		var totalpriceone=parseFloat($("#hidfuelFeeSin1").val())+parseFloat($("#hidairportFeeSin1").val())+parseFloat(zvalue_youhui_price[2]);
		    		$("#span_segmentinf_totalpriceone").html(totalpriceone+".00");
		    		}
	    		}
	    		else
	    		{
	    		 	var zvalue_youhui_price = data.split(",");   
	   			 	if(indexid.indexOf("ratevalue3_2_")!=-1){//第一程,更多政策
	   			 	document.getElementById(indexid).innerHTML=zvalue_youhui_price[0];
		    		document.getElementById(indexid+"_youhui").innerHTML=zvalue_youhui_price[1];
		    		document.getElementById(indexid+"_price").innerHTML=zvalue_youhui_price[2];
		    		$("#span_segmentinf_pricetwo").html(zvalue_youhui_price[2]);
		    		var totalpricetwo=parseFloat($("#hidfuelFeeSin2").val())+parseFloat($("#hidairportFeeSin2").val())+parseFloat(zvalue_youhui_price[2]);
		    		$("#span_segmentinf_totalpricetwo").html(totalpricetwo+".00");
	   			 	
	   			 	}else{//第一程默认显示的5个
		   		    document.getElementById(indexid+"value").innerHTML=zvalue_youhui_price[0];
		    		document.getElementById(indexid+"youhui").innerHTML=zvalue_youhui_price[1];
		    		document.getElementById(indexid+"price").innerHTML=zvalue_youhui_price[2];
		    		$("#span_segmentinf_pricetwo").html(zvalue_youhui_price[2]);
		    		var totalpricetwo=parseFloat($("#hidfuelFeeSin2").val())+parseFloat($("#hidairportFeeSin2").val())+parseFloat(zvalue_youhui_price[2]);
		    		$("#span_segmentinf_totalpricetwo").html(totalpricetwo+".00");
		    		}
	    		}
    		}else{
    		
    			alert("政策被禁用!!!");
    		}
    }else
    {
    	
    }
   }
);



 
 
 }
</script>
