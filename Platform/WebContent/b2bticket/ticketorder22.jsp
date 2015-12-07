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
.prompt {
	background-color: #cccccc;
	font-size: 12px;
}

.huang14_c {
	font-size: 12px;
	color: #f48000;
	font-weight: 100;
}
</style>
 <style type="text/css">
        #floatBoxBg{display:none;width:100%;height:50%;background:#fff;position:absolute;top:0;left:0;}
        .floatBox{border:#75a9d1 5px solid;width:400px; height:200px;position:absolute;top:-100px;left:40%; }
        .floatBox .title{height:23px;padding:7px 10px 0;background:#75a9d1;color:#fff;}
        .floatBox .title h4{float:left;padding:0;margin:0;font-size:14px;line-height:16px;}
        .floatBox .title span{float:right;cursor:pointer;}
        .floatBox .content{padding:20px 15px;background:#fff; widht:400px; height:100px}
        .hr1{height:1px;border:none;border-top:1px dashed #cccccc;}
        .wrap{white-space:normal; width:200px; }
         #testTable { 
            width : 600px;
            margin-left: 0; 
            margin-right: auto; 
          }
          
          #tablePagination { 
            background-color:  Transparent; 
            font-size: 0.8em; 
            padding: 0px 5px; 
            height: 20px
          }
          
          #tablePagination_paginater { 
            margin-left: auto; 
            margin-right: auto;
          }
          
          #tablePagination img { 
            padding: 0px 2px; 
          }
          
          #tablePagination_perPage { 
            float: left; 
          }
          
          #tablePagination_paginater { 
            float: right; 
          }
          .bordernoselect{
            width: 100%; border: 2px solid #0066FF; float: left; margin-top: -1px;
          }
          .borderselected{
            width: 100%; border: 2px solid #F48000; float: left; margin-top: -1px;
          }
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
<script src="js/jquery.tablePagination.0.2.min.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script src="js/jtip.js" type="text/javascript"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js2/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js2/ext-all.js"></script>
	

	
<script language="javascript">	



    var policyinfo="";
	$(document).ready(function() {
		$("#divpolicyinfo_1").addClass("bordernoselect");
		

		
	});
	
	function getthereate(flag,segmentindex)
    {
       $("#divpolicyinfo_"+segmentindex).removeClass("borderselected");
       $("#divpolicyinfo_"+segmentindex).addClass("bordernoselect");
       $.ajax({
            type:"POST",
            url:"b2bairsearch!DisplayZrateList.action",
            async:false,
            data:{z_startcity:$("#hidsairport_"+segmentindex).val(),z_endcity:$("#hideairport_"+segmentindex).val(),z_fromdate:$("#hidfromdate_"+segmentindex).val(),intflag:1,strAirCompany:$("#hidaircompany_"+segmentindex).val(),strAirline:$("#hidflightnumber_"+segmentindex).val(),strCabin:$("#hidcabin_"+segmentindex).val(),z_parvalue:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#divpolicyinfo_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
             $("#divpolicyinfo_"+segmentindex).html(data);  
              //模拟点击特殊政策第一条数据，更新政策及价格信息
            
               if(segmentindex=="1")
               {
                 if(document.getElementById("rdo_zrate1_0")!=null)
                 {
                   document.getElementById("rdo_zrate1_0").click(); 
                 }
               }
               else
               {
                 if(document.getElementById("rdo_zrate2_0")!=null)
                 {
                    document.getElementById("rdo_zrate2_0").click();
                 }
               }
            }            
       });
       
    }
    function gettheratesep(index,flag,segmentindex)
    {
       $.ajax({
            type:"POST",
            url:"b2bairsearch!DisplayZrateList.action",
            data:{z_startcity:$("#hidsairport_"+segmentindex).val(),z_endcity:$("#hideairport_"+segmentindex).val(),z_fromdate:$("#hidfromdate_"+segmentindex).val(),intflag:flag,strAirCompany:$("#hidaircompany_"+segmentindex).val(),strAirline:$("#hidflightnumber_"+segmentindex).val(),strCabin:$("#hidcabin_"+segmentindex).val(),z_parvalue:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#divpolicyinfo_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
	         if(data!="暂无政策数据")
              {
               $("#divpolicyinfo_"+segmentindex).html(data); 
               //模拟点击特殊政策第一条数据，更新政策及价格信息
               if(segmentindex=="1")
               {
                 if(document.getElementById("rdo_zrate1_0")!=null)
                 {
                   document.getElementById("rdo_zrate1_0").click(); 
                 }
               }
               else
               {
                 if(document.getElementById("rdo_zrate2_0")!=null)
                 {
                    document.getElementById("rdo_zrate2_0").click();
                 }
               }
               
              }
              else
              {
                 $("#divpolicyinfo_"+segmentindex).html(data); 
              }
            }            
       });
       $("#divpolicyinfo_"+segmentindex).addClass("borderselected");
       
       
           
    }
   
   
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


<script>

	
	var gwin;
	function grefresh(index,username,usertype,idtype,idnum){
	
	  if(gwin){
			gwin.close();
			//alert(username+","+usertype+","+idtype+","+idnum+","+index);
			//selectadd(username,type,idtype,idnumber,id)
			selectadd(username,usertype,idtype,idnum,index);
		}
	}
	

	
	function opendg(index){
   		
		if(gwin){gwin.close();}
		gwin= Ext.create('Ext.Window', {
			        
			        title: '常用旅客',
			        maximizable: true,
			        width: 610,
			        height: 350,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="b2bairsearch!seachpass.action?<ww:property value="url"/>&c_index='+index+'" width="100%" height="100%" s frameborder="0" scrolling="no" ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();
				

}

</script>



</head>

<body>

<form action="b2bticketorder!toaddorder.action" method="post" name="form1"
	id="form1">
<div id="divmessage"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">正在加载信息...</div>
<div><input type="hidden" id="txthidrebate"
	value="<ww:property value='s_rebatepoint' />" />
<div class="box" style="text-align: center;">
<div class="quan" style="text-align: left"><span
	class="lan14_cu f">选择机票政策</span> <span class="r"> <b
	style="color: #FFF;"><ww:property
	value="getCitynameByAirport(flightOne.StartAirport)" />&nbsp;<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">←</ww:if>→&nbsp;<ww:property
	value="getCitynameByAirport(flightOne.EndAirport)" />&nbsp;出发日期：<ww:property
	value="formatTimestampyyyyMMdd(segmentOne.departtime)" />&nbsp;<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">返程日期：<ww:property
		value="formatTimestampyyyyMMdd(segmentTwo.departtime)" />
</ww:if></b>&nbsp;&nbsp;&nbsp; </span></div>
<div
	style="margin-top: 10px; padding-top: 0; width: 98%; margin: 0 auto;">
<div
	style="font-size: 18px; font-weight: bold; color: #ff0000; text-align: left;"><ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
	<img src="images/fancheng.png" align="absmiddle" />&nbsp;
	<ww:if	test="segmentOne.traveltype==2">去程</ww:if>
	<ww:if	test="segmentOne.traveltype==3">第一行程</ww:if>
	信息：<ww:property
		value="getCitynameByAirport(flightOne.StartAirport)" />→&nbsp;<ww:property
		value="getCitynameByAirport(flightOne.EndAirport)" />&nbsp;出发日期：<ww:property
		value="formatTimestampyyyyMMdd(segmentOne.departtime)" />
	</b>
</ww:if></div>
<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<table border="0" cellpadding="0" cellspacing="0" width="100%"
	class="box" style="margin-left: 1px;">
	<tr class="huang12_c" style="background: #DDECF3; font-weight: bold">
		<td style="width: 8% height :   30px;">航班信息</td>
		<td style="width: 18%">抵达时间／机场</td>
		<td style="width: 10%">折扣/舱位</td>
		<td style="width: 5%; display: none">返点</td>
		<td style="width: 15%">票面价</td>
		<td style="width: 14%">机建/燃油</td>
		<td style="width: 14%">票面结算价</td>
		<td>单张票面价小计</td>
	</tr>
	<tr style="line-height: 25px; text-align: center;">
		<td>
		<table border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td rowspan="2"><img
					src="images/airComlogo/<ww:property value="segmentOne.aircomapnycode" />.gif" /></td>
				<td><ww:property value="segmentOne.flightnumber" /></td>
			</tr>
			<tr>
				<td><ww:property value="segmentOne.aircompanyname" />
				<input type="hidden" id="hidaircompanycode1" value="<ww:property value="segmentOne.aircomapnycode" />" /> 
				</td>
			</tr>
		</table>


		</td>
		<td style="text-align: left;"><img src="images/plane1.gif"
			width="25" height="25" /><span><font
			style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
			value="formatTimestampHHmm(segmentOne.departtime)" /></font><ww:property
			value="flightOne.StartAirportName" /></span><br />
		<img src="images/plane2.gif" width="25" height="25" /><span><font
			style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
			value="formatTimestampHHmm(segmentOne.arrivaltime)" /></font><ww:property
			value="flightOne.EndAirportName" /></span></td>
		<td style="font-size: 14px; line-height: 40px;"><ww:if
			test="segmentOne.Discount>=100.0">全价</ww:if> <ww:else>
			<ww:property value="segmentOne.Discount/10" />折</ww:else>/<ww:property
			value="segmentOne.cabincode" />
		<input type="hidden" id="hidcabincode1" value="<ww:property value="segmentOne.cabincode" />" /> 
		</td>
		<td style="font-size: 14px; line-height: 20px;; display: none"><ww:if
			test="segmentOne.ratevalue==null">
	无返点
	</ww:if> <ww:else>
			<ww:property value="segmentOne.ratevalue" />%<br />(<ww:property
				value="segmentOne.agentid" />)
	</ww:else></td>
		<td><span><b class="huang14_c" style="line-height: 16px;">￥<ww:property
			value="formatMoney(segmentOne.parvalue)" /></b>/成人</span><br />

		</td>
		<td><span><b class="huang14_c" style="line-height: 16px;">￥<ww:property
			value="formatMoney_string(segmentOne.airportfee)" />/<ww:property
			value="formatMoney_string(segmentOne.fuelfee)" /></b>(成人)</span><br />

		</td>
		<td><span><b class="huang14_c" style="line-height: 16px;">￥<span
			id="span_segmentinf_priceone">
			<ww:if test="#session.agtype==2">
			<ww:property value="formatMoney(segmentOne.parvalue)" />
			
			</ww:if><ww:else>
			<ww:property value="formatMoney(segmentOne.price)" />
			</ww:else>
			
			
			</span></b>(成人)</span><br />

		</td>
		<td><span><b class="huang14_c" style="line-height: 16px;">￥<span
			id="span_segmentinf_totalpriceone">
			<ww:if test="#session.agtype==2">
			<ww:property value="formatMoney(segmentOne.parvalue+segmentOne.fuelfee+segmentOne.airportfee)" />
			</ww:if><ww:else>
			<ww:property value="formatMoney(segmentOne.price+segmentOne.fuelfee+segmentOne.airportfee)" />
			</ww:else>
			</span></b>(成人)</span><br />
			<ww:if test="segmentOne.discount>100">
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentOne.parvalue,2)+getRoundPrice(segmentOne.fuelfee,2))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentOne.price,2)+getRoundPrice(segmentOne.fuelfee,2))" />
				</ww:else>
				</span></b>(儿童)</span><br />
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentOne.Parvalue,10))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentOne.price,10))" />
				</ww:else>
				</span></b>(婴儿)</span><br />
			</ww:if><ww:else>
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,2)+getRoundPrice(segmentOne.fuelfee,2))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,2)+getRoundPrice(segmentOne.fuelfee,2))" />
				</ww:else>
				</span></b>(儿童)</span><br />
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentOne.Yprice,10))" />
				</ww:else>
				</span></b>(婴儿)</span><br />
			
			</ww:else>
					<a onmouseover="showDiag('diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','block')"
									onmouseout="showDiag('diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','none')"
									style="border-bottom: 1px dashed #06f; color: #06f;" href="#">退改签规定</a>

								<div style="position: relative; z-index: 9999999999999;">
								<div
									id="diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									style="display: none; position: absolute; z-index: 9999999999999999999;right: 0px;top:-5px; width: 225px; background: #fff; text-align: left; line-height: 20px;color:#000"
									class="box">
								<div
									style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签规定</b></div>
								<div style="padding: 5px; text-align: left;"><ww:property
									value="segmentOne.rules" /></div>

								</div>
								</div>	
		</td>
		<span> <ww:if test="segmentOne.discount>100">
			<input type='hidden' id='hidYPriceSin1'
				value='<ww:property value="segmentOne.Parvalue"/>' />
		</ww:if> <ww:else>
			<input type='hidden' id='hidYPriceSin1'
				value='<ww:property value="segmentOne.yprice"/>' />
		</ww:else> <input type='hidden' id='hidairportFeeSin1'
			value='<ww:property value="segmentOne.airportfee"/>' /> <input
			type='hidden' id='hidfuelFeeSin1'
			value='<ww:property value="segmentOne.fuelfee"/>' /> <input
			type="hidden" id='hidFullPrice1'
			value='<ww:property value="segmentOne.parvalue"/>' /> 
			
			<input type="hidden" id="hidsairport_1" value="<ww:property value="segmentOne.startairport" />" />
			<input type="hidden" id="hideairport_1" value="<ww:property value="segmentOne.endairport" />" />
			<input type="hidden" id="hidfromdate_1" value="<ww:property value="formatTimestampyyyyMMdd(segmentOne.departtime)" />" />
			<input type="hidden" id="hidaircompany_1" value="<ww:property value="segmentOne.aircomapnycode" />" />
			<input type="hidden" id="hidflightnumber_1" value="<ww:property value="segmentOne.flightnumber" />" />
			<input type="hidden" id="hidcabin_1" value="<ww:property value="segmentOne.cabincode" />" />
			<input type="hidden" id="hidparvalue_1" value="<ww:property value="segmentOne.parvalue" />" />
			</span>
	</tr>
</table>
<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<table width="100%" id="zrate1_1" style="display: block;">
 
	<tr>
		<td align="left"><input type="button" value="普通政策" onclick="getthereate(0,1);"
			style="background: url(images/ddda.gif); width: 151px; height: 31px; line-height: 31px; border: none; color: #fff; cursor: pointer;"
			 />&nbsp;
			
			
			</td>
	</tr>
	<tr>
		<td><script>
		function showzratedesc1_1(id)
		{
	      $("tr[id*='zrate1_1_']").each(function(i){
		       $("#zrate1_1_"+i).hide();
		   });
		   document.getElementById("zrate1_1_"+id).style.display='block';
		   
			
		}
		</script>
		
		<div 
			 id="divpolicyinfo_1">
		   正在加载政策信息....
		</div>
		</td>
	</tr>
	<tr><td align="left"><font color="red">
			 <b>温馨提示:</b>请注意查看政策中的出票时间和废票时间，不在营业时间内的订单可能无法为您受理！<br />
		
			</font></td></tr>
</table>



<script>
function showtable(size,index)
{
	for(a=1;a<=size;a++){
	document.getElementById(index+a).style.display="block";
	//document.getElementById("onezrate_"+a).style.display="block";
	}
	
	document.getElementById(index+"close").style.display="block";
	
	document.getElementById(index+"show").style.display="none";
	
	
	//$("#"+index+"check").html('<a href="javascript:closetable(2,onezrate_)">-缩起</a>');
	
}
function closetable(size,index)
{
	if(parseInt(size)>4){
	
		for(a=5;a<=size;a++){
		document.getElementById(index+a).style.display="none";	
		}	
		
	}	
	document.getElementById(index+"close").style.display="none";
	document.getElementById(index+"show").style.display="block";	
	//$("#"+index+"check").html('<a href="javascript:showtable(2,onezrate_)">-缩起</a>');
	
}
</script></div>

<ww:if
	test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
	<div style="margin-top: 10px; width: 98%; margin: 0 auto;">
	<div
		style="font-size: 18px; font-weight: bold; color: #0000ff; text-align: left"><img
		src="images/qucheng.png" align="absmiddle" />&nbsp;
        <ww:if	test="segmentOne.traveltype==2">返程</ww:if>
        <ww:if	test="segmentOne.traveltype==3">第二行程</ww:if>
         信息： <ww:property
		value="getCitynameByAirport(flightOne.EndAirport)" /> &nbsp;→&nbsp; <ww:property
		value="getCitynameByAirport(flightOne.StartAirport)" />&nbsp; 
        出发日期：<ww:property
		value="formatTimestampyyyyMMdd(segmentTwo.departtime)" /></div>
	<!--
第二程开始
--><div style="height: 10px; line-height: 10px;">&nbsp;</div>
	<table border="0" cellpadding="0" width="100%" cellspacing="0"
		class="box">
		<tr class="huang12_c" style="background: #DDECF3; font-weight: bold">
			<td style="width: 8% height :   30px;">航班信息</td>
			<td style="width: 18%">抵达时间／机场</td>
			<td style="width: 10%">折扣/舱位</td>
			<td style="width: 5%; display: none">返点</td>
			<td style="width: 15%">票面价</td>
			<td style="width: 14%">机建/燃油</td>
			<td style="width: 14%">票面结算价</td>
			<td>单张票面价小计</td>
		</tr>
		<tr style="line-height: 25px; text-align: center;">
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td rowspan="2"><img
						src="images/airComlogo/<ww:property value="segmentTwo.aircomapnycode" />.gif" /></td>
					<td><ww:property value="segmentTwo.flightnumber" /></td>
				</tr>
				<tr>
					<td><ww:property value="segmentTwo.aircompanyname" />
					<input type="hidden" id="hidaircompanycode2" value="<ww:property value="segmentTwo.aircomapnycode" />" /> 
					</td>
				</tr>
			</table>


			</td>
			<td style="text-align: left;"><img src="images/plane1.gif"
				width="25" height="25" /><span><font
				style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
				value="formatTimestampHHmm(segmentTwo.departtime)" /></font><ww:property
				value="flightTwo.StartAirportName" /></span><br />
			<img src="images/plane2.gif" width="25" height="25" /><span><font
				style="margin: 0 1px 0 2px; line-height: 25px;"><ww:property
				value="formatTimestampHHmm(segmentTwo.arrivaltime)" /></font><ww:property
				value="flightTwo.EndAirportName" /></span></td>
			<td style="font-size: 14px; line-height: 40px;"><ww:if
				test="segmentTwo.Discount>=100.0">全价</ww:if> <ww:else>
				<ww:property value="segmentTwo.Discount/10" />折</ww:else>/<ww:property
				value="segmentTwo.cabincode" />
			<input type="hidden" id="hidcabincode2" value="<ww:property value="segmentTwo.cabincode" />" /> 
			</td>
			<td
				style="width: 5%; font-size: 14px; line-height: 20px; display: none">
			<ww:if test="segmentTwo.ratevalue==null">
	无返点
	</ww:if> <ww:else>
				<ww:property value="segmentTwo.ratevalue" />%<br />(<ww:property
					value="segmentTwo.agentid" />)
	</ww:else></td>
			<td><span><b class="huang14_c" style="line-height: 16px;">￥<ww:property
				value="formatMoney(segmentTwo.parvalue)" /></b>/成人</span><br />
			</td>
			<td><span><b class="huang14_c" style="line-height: 16px;">￥<ww:property
				value="formatMoney_string(segmentTwo.airportfee)" />/<ww:property
				value="formatMoney_string(segmentTwo.fuelfee)" /></b>(成人)</span><br />
			</td>
			<td><span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_pricetwo">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(segmentTwo.parvalue)" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(segmentTwo.Price)" />
				</ww:else>
				
				</span></b>(成人)</span><br />
			</td>
			<td><span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpricetwo">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(segmentTwo.parvalue+segmentTwo.airportfee+segmentTwo.fuelfee)" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(segmentTwo.Price+segmentTwo.airportfee+segmentTwo.fuelfee)" />
				</ww:else>
				</span></b>(成人)</span><br />
				
				
				<ww:if test="segmentTwo.discount>100">
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.parvalue,2)+getRoundPrice(segmentTwo.fuelfee,2))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.price,2)+getRoundPrice(segmentTwo.fuelfee,2))" />
				</ww:else>
				</span></b>(儿童)</span><br />
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.Parvalue,10))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.price,10))" />
				</ww:else>
				</span></b>(婴儿)</span><br />
			</ww:if><ww:else>
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,2)+getRoundPrice(segmentTwo.fuelfee,2))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,2)+getRoundPrice(segmentTwo.fuelfee,2))" />
				</ww:else>
				</span></b>(儿童)</span><br />
				<span><b class="huang14_c" style="line-height: 16px;">￥<span
				id="span_segmentinf_totalpriceone">
				<ww:if test="#session.agtype==2">
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,10))" />
				</ww:if><ww:else>
				<ww:property value="formatMoney(getRoundPrice(segmentTwo.Yprice,10))" />
				</ww:else>
				</span></b>(婴儿)</span><br />
			
			</ww:else>
				
			<a onmouseover="showDiag('diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','block')"
									onmouseout="showDiag('diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','none')"
									style="border-bottom: 1px dashed #06f; color: #06f;" href="#">退改签规定</a>

								<div style="position: relative; z-index: 9999999999999;">
								<div
									id="diag_rule_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									style="display: none; position: absolute; z-index: 9999999999999999999;right:0px;top:-5px; width: 225px; background: #fff; text-align: left; line-height: 20px;color:#000"
									class="box">
								<div
									style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签规定</b></div>
								<div style="padding: 5px; text-align: left;"><ww:property
									value="segmentTwo.rules" /></div>

								</div>
								</div>	
			</td>
			<span> <ww:if test="segmentTwo.discount>100">
				<input type='hidden' id='hidYPriceSin2'
					value='<ww:property value="segmentTwo.Parvalue"/>' />
			</ww:if> <ww:else>
				<input type='hidden' id='hidYPriceSin2'
					value='<ww:property value="segmentTwo.yprice"/>' />
			</ww:else> <input type='hidden' id='hidairportFeeSin2'
				value='<ww:property value="segmentTwo.airportfee"/>' /> <input
				type='hidden' id='hidfuelFeeSin2'
				value='<ww:property value="segmentTwo.fuelfee"/>' /> <input
				type='hidden' id='hidFullPrice2'
				value='<ww:property value="segmentTwo.parvalue"/>' /> 
				<input type="hidden" id="hidsairport_2" value="<ww:property value="segmentTwo.startairport" />" />
			<input type="hidden" id="hideairport_2" value="<ww:property value="segmentTwo.endairport" />" />
			<input type="hidden" id="hidfromdate_2" value="<ww:property value="formatTimestampyyyyMMdd(segmentTwo.departtime)" />" />
			<input type="hidden" id="hidaircompany_2" value="<ww:property value="segmentTwo.aircomapnycode" />" />
			<input type="hidden" id="hidflightnumber_2" value="<ww:property value="segmentTwo.flightnumber" />" />
			<input type="hidden" id="hidcabin_2" value="<ww:property value="segmentTwo.cabincode" />" />
			<input type="hidden" id="hidparvalue_2" value="<ww:property value="segmentTwo.parvalue" />" />
				</span>
		</tr>
	</table>
	<div style="height: 10px; line-height: 10px;">&nbsp;</div>
	<table width="100%" id="zrate3_1" style="display: block;">
	    
		<tr>
			<td align="left"><input type="button" value="普通政策" 
				style="background: url(images/ddda.gif); width: 151px; height: 31px; line-height: 31px; border: none; color: #fff"
				onclick="getthereate(0,2);" />&nbsp;
			
				
				</td>
				
		</tr>
		<tr>
			<td><script>
		function showzratedesc3_2(id)
		{
			$("tr[id*='zrate2_2_']").each(function(i){
		       $("#zrate2_2_"+i).hide();
		     });
			document.getElementById("zrate2_2_"+id).style.display='block';
		}
		</script>
			<div
				style="width: 100%; border: 2px solid #0066FF; float: left; margin-top: -1px;" id="divpolicyinfo_2">
               正在加载政策信息....
			</div>
			</td>
		</tr>
		<tr><td align="left"><font color="red">
			 <b>温馨提示</b>:请注意查看政策中的出票时间和废票时间，不在营业时间内的订单可能无法为您受理！<br />
			
			</font></td></tr>
	</table>

	
	
	<script>
function showtable2(id)
{
	document.getElementById("zrate3_1").style.display="none";
	document.getElementById("zrate3_2").style.display="none";
	document.getElementById(id).style.display="block";
}
</script></div>
</ww:if><ww:else>
	<input type='hidden' id='hidYPriceSin2' value='0' />
	<input type='hidden' id='hidairportFeeSin2' value='0' />
	<input type='hidden' id='hidfuelFeeSin2' value='0' />
	<input type='hidden' id='hidFullPrice2' value='0' />
</ww:else></div>

<div class="box" style="margin-top: 10px;" id="dengjiren1">
<div class="quan"><font class="lan14_cu"> 登机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码）。

</div>
<div><span style="padding-left: 1%;"> 常用登机人：<span
	style="padding-right: 2%;"><font class="hui_xi"
	style="margin: 0 20px 0 20px;">(如超过2名乘机人，请点击"增加乘机人"按钮)</font></span>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="display: none">
	<tr>
		<td width="10%"></td>
		<td>
		<div id="testTable">
		<table width="98%" border="0" cellspacing="0" cellpadding="0" id="tb_passenger_user">
		<tbody>
			<tr>
				<ww:iterator value="listCustPassenger" status="index">
					<ww:if test="#index.index % 5 == 0">
			</tr>
			<tr>
				</ww:if>
				<td><input name="" id="u<ww:property value="#index.index"/>"
					type="checkbox" value=""
					onclick="selectadd('<ww:property value="username"/>',1,<ww:if test="getCardbyPassengeId(id)!=null && getCardbyPassengeId(id).credittypeid!=null"><ww:property value="getCardbyPassengeId(id).credittypeid"/></ww:if><ww:else>1</ww:else>,<ww:if test="getCardbyPassengeId(id)!=null">'<ww:property value="getCardbyPassengeId(id).creditnumber"/>'</ww:if><ww:else>'证件号码'</ww:else>,'<ww:property value="#index.index"/>');" />&nbsp;<ww:property
					value="username" /></td>
				</ww:iterator>
			</tr>
			</tbody>
		</table>
		</div>
		</td>
	</tr>
</table>
</span></div>
<div class="c"></div>

<div class="box"
	style="width: 98%; margin: 0 auto; margin-bottom: 10px;"><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="10" />
</ww:bean> <ww:iterator value="#counter" status="state">
	<div id='passger<ww:property value="#state.index"/>'
		style="display: none;">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="text-align: left; line-height: 36px;">
		<tr>
			<td colspan="4"
				style="width: 98%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; margin: 0 auto;"><font
				class="huang12_c f" style="text-indent: 20px;">登机人</font> <span
				class="r" style="margin-right: 20px;"><input
				id="h_savepasenger<ww:property value="#state.index"/>"
				type="checkbox" align="absmiddle" value="1" name="issavepassenger" checked="checked" onclick="isSavePassenger(<ww:property value="#state.index"/>);" />&nbsp;&nbsp;保存到常用联系人</span>
			</td>
		</tr>
		<tr>
			
			<td align="left" width="160" style=" height: 36px;">&nbsp;姓名：<input
				name="h_name" style="width: 60px" desc="姓名"
				id="a<ww:property value="#state.index"/>" type="text" /><a href="javascript:opendg(0);"><font
				color="red">*常用旅客</font></a></td>
			<td>登机人类型： <select name="h_ptype" style="width:50px"
				onchange="changezjhm(<ww:property value="#state.index"/>)"
				id="b<ww:property value="#state.index"/>">
				<option value="1">成人</option>
				<option value="2">儿童</option>
				
				 <option value="3">婴儿</option> 
				
			</select></td>
			
		
			<td id="hidcxx<ww:property value="#state.index"/>">&nbsp;<span id="zjlx<ww:property value="#state.index"/>">
			证件类型： <select name="h_idtype" style="width: 80px"
				onchange="changenull(<ww:property value="#state.index"/>)"
				id="c<ww:property value="#state.index"/>">
				<option value="1">身份证</option>
				<option value="3">护照</option>
				<option value="4">港澳通行证</option>
				<option value="5">台湾通行证</option>
				<option value="6">台胞证</option>
				<option value="7">回乡证</option>
				<option value="8">军官证</option>
			</select> </span> &nbsp;&nbsp;
			    <span id="zjhm<ww:property value="#state.index"/>">证件号码：</span> 
			    <span id='zhengj<ww:property value="#state.index"/>'> 
				<input style="width:128px;" name="h_idnumber" id="d<ww:property value="#state.index"/>"	desc="证件号码" type="text" />
				<span	id="showtishi<ww:property value="#state.index"/>"> </span>
				 </span> 
				
				</td>
			
			
			<td style="display: none" id="hidcx<ww:property value="#state.index"/>"> <span id="span_birthday<ww:property value="#state.index"/>" >出生日期：</span>
				<span id="span_birthdaytext<ww:property value="#state.index"/>" >
				<input name="h_birthday" class="Wdate" id="birthday<ww:property value="#state.index"/>" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'{%y-2}-%M-%d',minDate:'{%y-12}-%M-%d'})"	desc="出生日期" type="text" /></span></td>
		
		
			<td width="80"><input type="button" name="" class="button109"
				style="cursor: pointer; background: url(images/108.gif); width: 91px; height: 27px; line-height: 21px; margin: 2px; font-size: 12px; color: #FFFFFF; text-align: center; font-weight: bold; border: none"
				value="删除登机人" onclick="del(<ww:property value="#state.index"/>)" />
			<input type="hidden" id="pstemp<ww:property value="#state.index"/>"
				value="" /></td>
		</tr>
		<tr style="display: none">
		    <td align="left" >
		    &nbsp;保险：
		    <input type="radio"
				id='bxc<ww:property value="#state.index"/>'
				name='bxinsurance<ww:property value="#state.index"/>' value="1"
				id="rdobaoxian"
				onclick='showInsurance(1,<ww:property value="#state.index"/>)' />购买&nbsp;&nbsp;
			<input type="radio" id="rdobaoxian2" checked="checked"
				name='bxinsurance<ww:property value="#state.index"/>' value="2"
				onclick='showInsurance(2,<ww:property value="#state.index"/>)' />不购买</td>
			<td><input type="hidden" id="bxzcount" value="1" />
			<table id='bxtable<ww:property value="#state.index"/>' width="100%"
				border="0" cellspacing="0" cellpadding="0"
				style="text-align: left; line-height: 36px; display: none">
				<tr>
					<td style="height: 36px;">保险分数： 
					<select
						id='bxcount<ww:property value="#state.index"/>' name="bxcount"
						style="width: 50px"
						onchange='changBXmoney(<ww:property value="#state.index"/>,this.value)'>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select><font color="#cccccc">￥20元/份</font>
					<font
						id='prompt<ww:property value="#state.index"/>'
						style="display: none; color: #FF8E00"> </font>
					</td>
				</tr>
			</table>
			</td>
			<td> <span id="11span_birthday<ww:property value="#state.index"/>" style="display:none">出生日期：</span>
				<span id="11span_birthdaytext<ww:property value="#state.index"/>" style="display:none">
				<input name="h_birthday" class="Wdate" id="11birthday<ww:property value="#state.index"/>" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'{%y-2}-%M-%d',minDate:'{%y-12}-%M-%d'})"	desc="出生日期" type="text" /></span></td>
			<td><input type="button" name="" class="button109"
				style="cursor: pointer; background: url(images/108.gif); width: 91px; height: 27px; line-height: 21px; margin: 2px; font-size: 12px; color: #FFFFFF; text-align: center; font-weight: bold; border: none"
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
	style="display: none; margin-top: 10px; width: 1001px;" id="dengjiren2">
<div class="quan"><font class="lan14_cu">登机人信息</font></div>
<div style="color: #999999; padding-left: 1%; line-height: 35px;">请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。<br />
<font color="red">提示：生日项为南航儿童订座必填项,非南航儿童可以不填。(儿童年龄范围2岁～未满12周岁),儿童票只匹配基本返点!</font>
</div>

<div class="c"></div>

<div class="hangd f"><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="9" />
</ww:bean> <ww:iterator value="#counter" status="state">
	<div id="pa<ww:property value="#state.index"/>" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="99%"
		style="margin: 0 auto;">
		<tr>
			<td colspan="4"
				style="width: 100%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; padding-left: 20px;">
			<font class="huang12_c" style="text-indent: 20px;">登机人</font></td>
		</tr>
		<tr>
			<td style="width: 20%; height: 36px; padding-left: 20px;">姓名： <span
				id="r<ww:property value="#state.index"/>"></span></td>
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

<div class="c"><input type="text" value="0" id="hidsegint_size" /></div>
</div>
<div class="box" style="margin-top: 10px;">
<div class="quan"><font class="lan14_cu">支付方式和支付金额</font></div>
<table width="100%" border="1" cellpadding="0" cellspacing="0"
	bordercolorlight="#CDCDCD" bordercolordark="#FFFFFF">
	<tr style="display:none" id="tr_adultpnr">
		<td style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">成人PNR编码：</td>
		<td><input type="text" name="s_adultpnr" id="txtadultpnr" /><br />
		&nbsp;&nbsp;<font color="red">温馨提示：航空公司规定儿童乘坐飞机必须有一位成人陪同。输入成人PNR后，系统会自动将成人PNR编码备注进儿童PNR编码。</font>
		</td>
	</tr>
	<tr>
		<td style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">联系人：</td>
		<td><input type="text" name="s_contactname" id="varname" value="<ww:property value="getlianxiren()"/>" /></td>
	</tr>
	<tr>
		<td style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">联系手机号：</td>
		<td><input type="text" name="s_contactmobile" id="txtcontactmobile" value="<ww:property value="getshouji()"/>" /></td>
	</tr>
	
	<tr>
		<td align="center">订单备注：</td>
		<td align="left"><textarea rows="7" cols="45" name="orderinfo.memo"
			id="txtmemo"></textarea></td>
	</tr>
	
		<ww:if test="getLoginsessionagent().agenttype==1">
	<tr>
		<td
			style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">
		支付方式：</td>
		<td>
			<input type="radio" id="saleroom" name="rdopaymethod" value="2"
				checked="checked" />门市付款
					    &nbsp;&nbsp;
					    <input type="radio" id="sendticket" name="rdopaymethod"
				value="3">票到付款</input>
					    &nbsp;&nbsp;<font color="red">温馨提示：如果客人已支付，请选择门市付款</font>
		</td>
	</tr>
		</ww:if>
	<tr>
		<td
			style="height: 26px; width: 145px; background-color: #EDFFED; text-align: center;">
		交&nbsp;易&nbsp;费：</td>
		<td>&nbsp;<span id="JRprice"><font color="red">￥<ww:property
			value='orderPlat' /></span></span></td>
	</tr>
	<tr>
		<td
			style="height: 60px; background-color: #EDFFED; text-align: center;">
		计算方式：</td>
		<td style="line-height: 25px;">&nbsp;订单票面价小计 * 人数 + 平台交易费+保险份数x20
		= 支付总金额<br />
		<!--+ 行程单总费用--> &nbsp;
		
		<ww:if test="#session.agtype!=2">
		<span style="color: #BF2800"><span
			id="CalLab"></span>元</span>
		</ww:if><ww:else>
		<span style="color: #BF2800"><span
			id="CalLab"></span></span>
		
		</ww:else>	
		
			</td>
	</tr>
	<tr>
		<td
			style="height: 26px; background-color: #EDFFED; text-align: center;">
		支付金额：</td>
		<td>&nbsp;订单总金额： <span id="allprice"
			style="color: Red; font-size: 20pt; font-weight: bold;"></span> 元</td>
	</tr>
	<tr style="display: none">
		<td
			style="height: 26px; background-color: #EDFFED; text-align: center;">
		总&nbsp;利&nbsp;润：</td>
		<td>&nbsp;订单总利润： <span id="Tprice"
			style="color: Red; font-size: 20pt; font-weight: bold;"></span> <input
			type="hidden" id="hid_zonglirun" name="s_zonglirun"
			value='<ww:property value="s_zonglirun" />'><input
			type="hidden" id="hid_zonglirun2" name="s_zonglirun2"
			value='<ww:property value="s_zonglirun2" />'> 元 <input
			type="hidden" id="hid_childrate"
			value="0"></td>
	</tr>
</table>
</div>
</div>
<div style="height: 10px; line-height: 10px;">&nbsp;</div>
<div id="buttonyulan"
	style="text-align: center; margin-top: 10px; width: 100%; height: 60px;">
<input name="" id="submitbutton" type="button" onclick="subform()"
	style="cursor: pointer; background: url(images/108.gif); width: 91px; height: 27px; line-height: 21px; margin: 2px; font-size: 12px; color: #FFFFFF; text-align: center; font-weight: bold; border: none"
	class="button108" value="提交" /> <input name="" id="submitbutton"
	type="button" onclick="history.go(-1)"
	style="cursor: pointer; background: url(images/108.gif); width: 91px; height: 27px; line-height: 21px; margin: 2px; font-size: 12px; color: #FFFFFF; text-align: center; font-weight: bold; border: none"
	class="button108" value="重新选择" /></div>

<div class="c"></div>
<!--第五结束--> <input id="HfPersonCount" value="1" type="hidden" /> <input
	id="HfPassNameArr" value="" type="hidden" name="h_name" /> <input
	id="HfIdType" type="hidden" name="h_idtype" /> <input id="HfIdNumber"
	type="hidden" name="h_idnumber" /> <input id="HfPassInfo"
	type="hidden" /> <input id="HfPassTypeInfo" type="hidden" value="1" />
<input id="HfIdTypeInfo" type="hidden" value="1" /> <input
	id="HfIdNumberInfo" type="hidden" /> <input id="HfTravelType"
	type="hidden" value="<ww:property value="segmentOne.traveltype"/>" />
<input id="HfTotalPrice" type="hidden" /> <input id="HfTotalAirportFee"
	type="hidden" /> <input id="HfTotalFuelFee" type="hidden" /> <input
	id="HfCustomerName" type="hidden" /> <input id="hfCustomerCardId"
	type="hidden" /> <input id="hfCustomerID" type="hidden" /> <input
	id="HfAdultNum" type="hidden" value="0" /> <input id="HfChildNum"
	type="hidden" value="0" /> <input id="HfBabyNum" type="hidden"
	value="0" /> <input id="hfAllPassName" type="hidden" /> <input
	id="hfcusGuid" type="hidden" /> <input id="hdfAddress" type="hidden" />
<input id="strTotalPriceOne" type="hidden" name="strTotalPriceOne"><input
	id="strTotalPriceTwo" type="hidden" name="strTotalPriceTwo">
</div>
<input type="hidden" name="h_savepasenger" id="h_savepasenger" value="" />

</form>
</body>
</html>
<script language="javascript">
	function subform(){
		if(!$('#form1').validationEngine({returnIsValid:true}))
 		{
 			return false;
 		}
 		//判断是否即含有成人又含有儿童，如果有成人又有儿童则提示客户分开预订成人和儿童订单。
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
		if(chengren>0 && ertong>0)
		{
		   // alert("抱歉，您的订单不能提交！\r\n预订有成人陪伴儿童订单。请分别预订成人订单和儿童订单！");
		   // return false;
		}
		else if(ertong>0)
		{
		   //如果还有儿童乘机人并且当前舱位不是Y舱,则要求返回重新预订Y舱航班
		   if(1==1)	
	       
	        //if(($("#hidcabincode1").val()=="Y" || $("#hidcabincode1").val()=="F" || $("#hidcabincode1").val()=="C")  || ($("#hidcabincode2").val()=="Y" || $("#hidcabincode2").val()=="F" || $("#hidcabincode2").val()=="C") || (($("#hidaircompanycode2").val()=="CZ" || $("#hidaircompanycode1").val()=="CZ") && $("#hidcabincode1").val()=="W"))	
	        { 
	            //录入陪同成人的PNR编码
	          //  if($("#txtadultpnr").val()=="")
	          //  {
	          //     alert("请录入陪同成人的PNR编码！");
	          //     $("#txtadultpnr").focus();
	          //     return false;
	          //  }
	        }
	        else
	        {
	           // alert("儿童只能订F,C,Y和南航的W舱,按照成人价格的一半结算，燃油减半免机建。请返回重新选择舱位！");
	           // return false;
	        }
		}
		//联系人
		if($.trim($('#varname').val())=="")
		{
		   alert("联系人不能为空，请重新填写！");
		   return false;
		}
 		//联系人手机号
		if($.trim($('#txtcontactmobile').val())=="")
		{
		   alert("联系手机号不能为空，请重新填写！");
		   return false;
		}
		else if(!IsMobile($('#txtcontactmobile').val())) 
		{
			$('#txtcontactmobile').focus();
			alert("联系手机号格式不正确，请重新填写！");
			return false;
		}
 		//判断虚拟账户余额是否足够支付票款
 		var vfalg="0";
 		var bvmoneceheked=false;
 		if(document.getElementById("rdovmoney")!=null&&document.getElementById("rdovmoney").checked){
 		bvmoneceheked=true;
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
		<ww:if test="getLoginsessionagent().agenttype==1">
		var b=$("input:radio[name='rdopaymethod']:checked").val();
		
		var fkmethodstr=b==1?"网上支付(支付宝)":b==2?"门市付款":b==3?"票到付款":b==4?"虚拟账户支付":b==5?"月结支付":"网上支付(支付宝)";
		    message="您选择的支付方式为："+fkmethodstr+"。\r\n\r\n";
		    if(b==4)
		    {
		      message+="点击确认后将从您的虚拟账户中支付票款"+$("#allprice").html()+"元.\r\n\r\n";
		    }
		 </ww:if>
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
		   // yuinput=$("#zhengj"+isd).html();
			//document.getElementById("zjlx"+isd).style.display="block";
			//document.getElementById("zjlx"+isd).className="f";
			//document.getElementById("zjhm"+isd).innerHTML="&nbsp;&nbsp;证件号码：";
			//document.getElementById("zjhm"+isd).style.display="block";
			//document.getElementById("d"+isd).style.display="block";
			
			if(zjid!=2){
			
			document.getElementById("d"+isd).className="validate[required,cardnumber]";
			}
			
			//$("#zhengj"+isd).html(yuinput);
			$("#d"+isd).val("");
			//document.getElementById("showtishi"+isd).innerHTML="";
			$("#span_birthday"+isd).hide();	 
	        $("#span_birthdaytext"+isd).hide();	
	     if(zjid==1)
	     {
	      $("#hidcxx"+isd).show();
		  $("#hidcx"+isd).hide();
	      
	        $("input[id*='rdo_zrate1_']").each(function(i){
		             $(this).attr("disabled",false);
		        });
		    document.getElementById("rdo_zrate1_0").click();
	     }  
	     if(zjid==2||zjid==3){//儿童
	  
		  $("#hidcxx"+isd).hide();
		  $("#hidcx"+isd).show();
		  
	      $("#d"+isd).removeClass("validate[required,cardnumber]");
	     
	        if($("#hidaircompanycode2").val()=="CZ" || $("#hidaircompanycode1").val()=="CZ")
	        {
	            //alert("南航航班儿童生日项为必填项！");
	            document.getElementById("birthday"+isd).className="validate[required]";
	        }
	        //如果还有儿童乘机人并且当前舱位不是Y舱,则要求返回重新预订Y舱航班
	        if(1==1)	
	      
	       // if(($("#hidcabincode1").val()=="Y" || $("#hidcabincode1").val()=="F" || $("#hidcabincode1").val()=="C")  || ($("#hidcabincode2").val()=="Y" || $("#hidcabincode2").val()=="F" || $("#hidcabincode2").val()=="C") || (($("#hidaircompanycode2").val()=="CZ" || $("#hidaircompanycode1").val()=="CZ") && $("#hidcabincode1").val()=="W"))	
	        { 
	          // $("#tr_adultpnr").show();
	          
	          //document.getElementById("zjlx"+isd).style.display="none";
	          //document.getElementById("zjhm"+isd).style.display="none";
	         // document.getElementById("d"+isd).style.display="none";
	         
	            $("#d"+isd).removeClass("validate[required,cardnumber]");
	           var varindex=parseInt($("#zratelength").val())-1;
	          // alert("varindex:"+varindex);
	          // document.getElementById("rdo_zrate1_"+varindex).click();
	           //其他按钮禁用
	            $("input[id*='rdo_zrate1_']").each(function(i){
		             $(this).attr("disabled",true);
		        });
		        showtable($("#zratelength").val(),'onezrate_');
	           
	           
	        }
	        else
	        {
	            alert("儿童只能订F,C,Y和南航的W舱,按照成人价格的一半结算，燃油减半免机建。请返回重新选择舱位！");
	        }
	      //  document.getElementById("d"+isd).className="validate[required]";
	        $("#span_birthday"+isd).show();	 
	        $("#span_birthdaytext"+isd).show();	   
			//document.getElementById("zjlx"+isd).style.display="none";
			//document.getElementById("zjhm"+isd).innerHTML="出生日期";			
			//$("#d"+isd).addClass("Wdate");
			//$("#d"+isd).focus(function(){
			//WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'{%y-2}-%M-%d',minDate:'{%y-12}-%M-%d'})
			//});			
		  }
		//if(zjid==3){//婴儿
		//    $("#d"+isd).removeClass("validate[required,cardnumber]");
	   //     document.getElementById("d"+isd).className="validate[required]";	
		//	document.getElementById("zjlx"+isd).style.display="none";
		//	document.getElementById("zjhm"+isd).innerHTML="出生日期";
		//	$("#d"+isd).addClass("Wdate");
		//	$("#d"+isd).focus(function(){
		//	WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'{%y-2}-%M-%d'});
		//	});
		//}
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
	//选择常用旅客
	function selectadd(username,type,idtype,idnumber,id){
	//alert(username+","+type+","+idtype+","+idnumber+","+id);
		//var check = document.getElementById("u"+id).checked;
		var i=-1;
		
		if(1==1){
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
			//document.getElementById("u"+id).checked=false;
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
		    $("#span_birthday"+i).hide();	 
	        $("#span_birthdaytext"+i).hide();	
			document.getElementById("d"+i).className="validate[required,cardnumber]";
		}else
		{
		 $("#hidcxx"+i).show();
		  $("#hidcx"+i).hide();
		
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
				$("#span_birthday"+h).hide();	 
	            $("#span_birthdaytext"+h).hide();
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
		//选中常旅客时，将默认第一个空白的乘机人隐藏掉
		//del(8);
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
			passgerstr=suntotal;
		}
	}
	if(suntotal!=0){
	   passgerstr=9-passgerstr;
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
	
	var zrate_oneobj=document.getElementById("ratevalue1_1_"+zrateoneid).value;
	
	//alert("zrate_oneobj=="+zrate_oneobj);

	if(zrate_oneobj!=null)
	{
	var zrate_one=zrate_oneobj;
	}else
	{
	var zrate_one=0;
	}
	//alert("zrate_one=="+zrate_one);
	
	
	<ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
		var zratetwoid=GetRadioValue("zrate_two");
		//alert(zratetwoid);
		var zrate_twoobj=document.getElementById("ratevalue2_2_"+zratetwoid).value;
		
		if(parseInt(zrate_twoobj)>0&&zrate_twoobj!=null)
		{
			var zrate_two=zrate_twoobj;
		}else
		{
			var zrate_two=0;
		}
		
		
	</ww:if>
	<ww:else>
		var zrate_two=0;
	</ww:else>
	
	var hidYPriceSin1=document.getElementById("hidYPriceSin1").value;
	var hidairportFeeSin1=document.getElementById("hidairportFeeSin1").value;
	var hidfuelFeeSin1=document.getElementById("hidfuelFeeSin1").value;
	var hidFullPrice1=$("#hidFullPrice1").val();
	
	//cxx
	
	
	//

	//儿童票面价
    var childpriceSingle1=Math.round(hidYPriceSin1*0.5*0.1)*10;//儿童票面价
    //儿童燃油费
    var childFuelSingle1= Math.round(hidfuelFeeSin1*0.5*0.1)*10; //儿童燃油费
    //婴儿票面价
    var babypriceSingle1=Math.round(hidYPriceSin1*0.01)*100*0.1;//婴儿票面价
    
    var varlirun=Math.floor(((parseFloat(hidFullPrice1)*parseFloat(zrate_one)*0.01)*100)/100);
   // alert("varlirun:"+varlirun);
    var chengrenprice1=parseFloat(hidFullPrice1)-varlirun;
    //四舍五入保留两位小数
    chengrenprice1=Math.round(chengrenprice1*100)/100;
    var ertonglirun=Math.floor(((parseFloat(childpriceSingle1)*parseFloat($("#hid_childrate").val())*0.01)*100)/100);
    
    
    //alert("childpriceSingle1:"+childpriceSingle1);
   // alert("ertonglirun:"+ertonglirun);
    var ertongprice1=parseFloat(childpriceSingle1)-ertonglirun;  //儿童政策2.5%
    //alert(ertongprice1);
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
	var ptPrice=<ww:property value='orderPlat'/>;
	
	//总价
	var zongjia=parseFloat(danchengren)*parseFloat(chengren);
	zongjia=zongjia+parseFloat(ertongprice1+childFuelSingle1+ertongprice2+childFuelSingle2)*parseInt(ertong);
	zongjia=zongjia+parseFloat(yingerprice1+yingerprice2)*parseInt(yinger);
	zongjia=zongjia+parseInt(sumbaoxian)*20;
	zongjia=zongjia+ptPrice;
	var allprice=document.getElementById("allprice");
	allprice.innerHTML=Math.round(zongjia*100)/100;
	
	<ww:if test="#session.agtype==2">//积分加盟商
	allprice.innerHTML=Math.round(zongjia*100)/100+(varlirun+varlirun2)*chengren;
	</ww:if>
	
	var CalLab=document.getElementById("CalLab");
    
    
    //修改开始cxx
    //alert("ptPrice:"+ptPrice);
   // alert("yingerprice1:"+yingerprice1);
    //alert("yinger:"+yinger);
    //alert("ertong:"+ertong);
   // alert("danchengren:"+danchengren+",chengren:"+chengren+",ertongprice1:"+ertongprice1+",childFuelSingle1:"+childFuelSingle1+",ertongprice2:"+ertongprice2+",childFuelSingle2:"+childFuelSingle2);
	
	CalLab.innerHTML=Math.round((parseFloat(danchengren)*parseInt(chengren)+parseFloat(ertongprice1+childFuelSingle1+ertongprice2+childFuelSingle2)*parseInt(ertong)+(Math.round(yingerprice1* 100) / 100)*yinger)*100)/100 +"+ "+ptPrice+" + "+sumbaoxian+" x 20元 = "+Math.round(zongjia*100)/100;
	
	
	//cxx
	<ww:if test="#session.agtype==2">//积分加盟商
	CalLab.innerHTML="";
	</ww:if>
	
	
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
	//if(chengren==0)
	//{
		//if(yinger>0)
		//{
			//alert("不能单独预订婴儿票，乘机人至少一个是成人!");
			//colsedispose();
			//document.getElementById("submitbutton").disabled="";
			//return false;
		//}
		//else if(ertong>0)
		//{
			//alert("不能单独预订儿童票，乘机人至少一个是成人!\r\n如果您是儿童独自乘机，请到我公司柜台人工办理手续！");
			//colsedispose();
			//document.getElementById("submitbutton").disabled="";
			//return false;
		//}
	//}
	
	
 var h_name="";
 var h_type="";
 var h_idtype="";
 var h_idnumber="";
 var h_insurance="";
 var bxcount="";
 var h_issave="";
 var h_birthday="";
 for(var i=0;i<9;i++)
 {
 	if(i!=8)
 	{
 	h_name=h_name+document.getElementById("a"+i).value+",";
 	h_type=h_type+document.getElementById("b"+i).value+",";
 	h_idtype=h_idtype+document.getElementById("c"+i).value+",";
 	h_idnumber=h_idnumber+document.getElementById("d"+i).value+",";
 	h_birthday=h_birthday+document.getElementById("birthday"+i).value+",";
 	//是否保存常用旅客
 	h_issave=h_issave+document.getElementById("h_savepasenger"+i).value+",";
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
 	h_birthday=h_birthday+document.getElementById("birthday"+i).value;
 	if($("#h_savepasenger"+i).attr("checked")==true)
 	{
 	   h_issave+="1";
 	}
 	else
 	{
 	   h_issave+="0";
 	}
 	//h_issave=h_issave+document.getElementById("h_savepasenger"+i).value+",";
 	var bcount=document.getElementById("bxcount"+i).value;
 	var b=$("input:radio[name='bxinsurance"+i+"']:checked").val();
 	 if(b==2){
 	 bcount=0;
 	 }
    bxcount=bxcount+bcount;
 	}
 }

//alert("bxcount:"+bxcount);

 var zrate_one= GetRadioValue('zrate_one');
 var zrate_two= GetRadioValue('zrate_two');
 var s_paymethod="1";
 var varzonglirun=$("#hid_zonglirun").val();
 var varzonglirun2=$("#hid_zonglirun2").val();
 var varmobile=$("#txtcontactmobile").val();
 var varadultpnr=$("#txtadultpnr").val();
 var varname=$("#varname").val();
 var txtmemo=$("#txtmemo").val();//訂單備註
 


 var b=$("input:radio[name='rdopaymethod']:checked").val();
 if(typeof(b)=='undefined'){
   b="0";
 }
   s_paymethod=b;
 $.post("b2bticketorder!toaddorder.action",{ zrate_one: zrate_one,bxcount:bxcount, zrate_two:zrate_two,h_name:h_name,h_ptype:h_type,h_idtype:h_idtype,h_idnumber:h_idnumber,s_paymethod:s_paymethod,s_zonglirun:varzonglirun,s_zonglirun2:varzonglirun2,s_contactmobile:varmobile,s_contactname:varname,issavepassenger:h_issave,h_birthday:h_birthday,s_adultpnr:varadultpnr,c_memo:txtmemo},function(data){
   
   window.location=data;
    return;
    
    
    if(data=="NOPNR")
    {
    	colsedispose();
    	alert("PNR创建失败，请重新点击创建订单！");
    	document.getElementById("submitbutton").disabled="";
    } else if(data=="ERROR"){
        colsedispose();
    	alert("订单创建失败，请重新点击创建订单！");
    	document.getElementById("submitbutton").disabled="";
    }else{
    	window.location=data;
    	//return;
    }
   }); 
 	
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

 <ww:if test='#session.agtype!=1'>

  return;
 </ww:if>

     $.post("b2bticketorder!SeachZateAndUpdate.action",{ajax_zid:zateid,ajax_fromcity:fromcity,ajax_tocity:tocity,ajax_code:aircompanycode,ajax_waiid:waiid,ajax_zatetype:zatetype,parvalue:parvalue,ajax_vogtype:type},function(data){
         if(data)
         {
             colsedispose();
   			 if(data!='-1'){
   			    var zvalue_youhui_price = data.split(",");
   			    if(type=="1")
   			    {
   			         //隐藏域给政策赋值
   			         document.getElementById("ratevalue1_1_"+zateid).value=zvalue_youhui_price[0];
	   			 	//var zvalue_youhui_price = data.split(",");   
	   			 	if(indexid.indexOf("ratevalue1_2_")!=-1){//第一程,更多政策
	   			 	document.getElementById(indexid).innerHTML=zvalue_youhui_price[0];
		    		document.getElementById(indexid+"_youhui").innerHTML=zvalue_youhui_price[1];
		    		document.getElementById(indexid+"_price").innerHTML=zvalue_youhui_price[2];
		    		$("#span_segmentinf_priceone").html(zvalue_youhui_price[2]);
		    		var totalpriceone=parseFloat($("#hidfuelFeeSin1").val())+parseFloat($("#hidairportFeeSin1").val())+parseFloat(zvalue_youhui_price[2]);
		    		$("#span_segmentinf_totalpriceone").html(totalpriceone+".00");
	   			 	}
	   			 	else
	   			 	{
		   			 	//第一程默认显示的5个
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
	    		 //隐藏域给政策赋值
   			     document.getElementById("ratevalue2_2_"+zateid).value=zvalue_youhui_price[0];
   			     
	    		 	//var zvalue_youhui_price = data.split(",");   
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
	    		document.getElementById("submitbutton").disabled="";
    		}else
    		{
    			alert("政策被禁用,请选择其他政策预订!");
    			document.getElementById("submitbutton").disabled="disabled";
    		}
    }else
    {
    	
    }
   }
);



 
 
 }
 
 //是否保存常用旅客
 function isSavePassenger(index)
 {
     if($("#h_savepasenger"+index).attr("checked")==true)
     {
        $("#h_savepasenger"+index).val("1");
     }
     else
     {
        $("#h_savepasenger"+index).val("0");
     }
     
 }
 
 		 getthereate(0,1);
		 <ww:if test="segmentTwo!=null&segmentTwo.flightnumber!=null&&segmentTwo.flightnumber.length()>0">
		 getthereate(0,2);
	    </ww:if>
		add();
		$("#form1").validationEngine();
		<ww:if test="listCustPassenger.size()>20">
		//$('#tb_passenger_user').tablePagination({});
		</ww:if>
</script>
