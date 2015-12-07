<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单详细信息</title>
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>

<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ext-all.css" />


<script>
//页面加载完毕后，读取政策信息
   $(document).ready(function () {
      getthereate(0);
    });
    function getthereate(flag)
    {
       
       if($("#hidsegint_size").val()>0)
       {
           for(var n=0;n<$("#hidsegint_size").val();n++)
           {
		       $.ajax({
		            type:"POST",
		            url:"orderinfo!Findallzrate.action",
		            async:false,
		            data:{z_startcity:$("#hidsairport_"+n).val(),z_endcity:$("#hideairport_"+n).val(),z_fromdate:$("#hidfromdate_"+n).val(),intflag:0,strAirCompany:$("#hidaircompany_"+n).val(),strAirline:$("#hidflightnumber_"+n).val(),strCabin:$("#hidcabin_"+n).val(),strratePrice:$("#ticketprice_0").val()},
		            beforeSend:function(){$("#divpolicyinfo_"+n).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
		            success:function(data){
		            $("#divpolicyinfo_"+n).html(data);   
		            $("#trploicy").show();
		            }            
		       });
	       }
       }
    }
    function gettheratesep(index,flag)
    {
       if($("#hidsegint_size").val()>0)
       {
           for(var n=0;n<$("#hidsegint_size").val();n++)
           {
		       $.ajax({
		            type:"POST",
		            url:"orderinfo!Findallzrate.action?intflag="+flag,
		            data:{z_startcity:$("#hidsairport_"+n).val(),z_endcity:$("#hideairport_"+n).val(),z_fromdate:$("#hidfromdate_"+n).val(),intflag:flag,strAirCompany:$("#hidaircompany_"+n).val(),strAirline:$("#hidflightnumber_"+n).val(),strCabin:$("#hidcabin_"+n).val(),strratePrice:$("#ticketprice_0").val()},
		            beforeSend:function(){$("#divpolicyinfo_"+index).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
		            success:function(data){
		            $("#divpolicyinfo_"+index).html(data); 
		            $("#trploicy").show();  
		            }            
		       });
	       }
       }
    }
   
	
	
   function rTPnr()
    {
       $("#pnrinfo").show();
       $.ajax({
            type:"POST",
            url:"orderinfo!rtPNRinfo.action",
            data:{strPNR:$("#txtpnrcode").val()},
            beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在加载PNR信息.....</b></font>");},             
            success:function(data){
            $("#pnrinfo").html(data);           
            }            
            });
       
    }
    function loadPnr()
    {
       var strPnrinfo="**ELECTRONIC TICKET PNR** <br> 1.YIXUAN/SHICHD XP8VR <br> 2. FM9311 Y FR19MAR SHACAN RR1 0930 1130 E <br> 3.FUO/T FUO/T 0757-82263555/FUO SHUN AN DA AIR SERVICE CO.,LTD/CHEN MING JUN <br> ABCDEFG <br> 4.SHISHAN1 <br> 5.0757-86688155 MEI 13535661430<br> 6.T<br> 7.SSR FOID <br> 8.SSR ADTK 1E BY FUO17MAR10/0930 OR CXL FM9311 Y19MAR <br> 9.SSR TKNE FM HK1 SHACAN 9311 Y19MAR 7743868306688/1/P1<br>10.RMK AUTOMATIC FARE QUOTE <br>11.RMK CA/K7231 <br>12.FN/A/FCNY640.00/SCNY640.00/C3.00/XCNY30.00/TEXEMPTCN/TCNY30.00YQ/ACNY670.00 <br>13.TN/774-3868306688/P1 <br>14.FP/CASH,CNY <br>j<Qp>> 7o <015.FUO112 <br> -";
       
       $("#pnrinfo").html(strPnrinfo);
    }
   function goEdit(ur)
   {
				document.getElementById("hur").value=ur;
				
				var h = ur.split("pr=");
				var h1 =h[1];
			
				
				if(h1==2){
				
				//document.getElementById("d1").style.display="block";
				document.getElementById("xie").style.display = "";
               document.getElementById("content1").style.display = "";
				
			    document.getElementById("xie").style.filter = "Alpha(Opacity=50)";//透明度
			    document.getElementById("content1").innerHTML = "退票手续费:<input type='text' id='da' value='' /> <br /><input onclick='hi()' type='button' value='确定'/> <input onclick='hide()' type='button' value='取消'/>";
				
			
				}else{
				window.location.href=ur;      
				
				}

}
  function hide() {
               document.getElementById("xie").style.display = "none";
               document.getElementById("content1").style.display = "none";
           }
  function hi() {
var da =  document.getElementById("da").value;
//alert("da="+da) 
var u =document.getElementById("hur").value;
//alert(u+'&tui='+da);
	window.location.href=u+'&tui='+da;       
           }

     function goEdit4(url)
     
    {
    	
    	if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit5(url)
    {
    	
       if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit6(url)
    {
    
     if(aaa()==false){
    	return;
    	
    	}else{
       window.location.href=url;
       }
    }
     function goEdit2(url)
    {
   	 	var temp = confirm('请确认已在黑屏出票');
			if(temp==true){
			window.location.href=url;
		}
    }
    
     function bbb(url)
    {
   		aaa();
    
       window.location.href=url;
    }
    
  function aaa()
    {
    
    
  var ticketnum = document.getElementsByName("ticketnum");
  var fet = document.getElementsByName("fet");
  var ei = document.getElementsByName("ei");
  var pid = document.getElementsByName("pid");
  
  
if(document.all("ticketnum").value == "") 
{ 
	alert("票号不能为空！"); 
	document.all("ticketnum").focus(); 
	return false; 
}
  var ticketStr = "";
   var fetStr = "";
    var eiStr = "";
    var ppid = "";


for(var i=0;i<ticketnum.length;i++)
{
   //验证票号格式
    if(ticketnum[i].value!="" && ticketnum[i].value.length!=14)
    {
        alert("您输入的票号格式不正确，请重新填写！票号格式如：784-1771188239");
        ticketnum[i].focus();
        return false;
    }
    else
    {
      ticketStr += ticketnum[i].value + ",";
     }
}
 for(var i=0;i<fet.length;i++)
{
 fetStr += fet[i].value + ",";
}
  for(var i=0;i<ei.length;i++)
{
 eiStr += ei[i].value + ",";
}   
  for(var i=0;i<pid.length;i++)
{
 ppid += pid[i].value + ",";
}   
    
  $.post("passenger!addpassenger.action",{'ticketnum':ticketStr,'fet':fetStr,'ei':eiStr,'pid':ppid},
	function(str1)
		{
			alert("保存成功！");
		}
	);
   return;
   
   
   document.form1.submit();
    
}
    
    function showremark(id)
   {
       $("tr[id*='remark_']").each(function(i)
	      {
	         $(this).hide();
	      });
       $("#remark_"+id).show();
       $("input[id*='btnrecreate_']").each(function(i)
	      {
	         $(this).hide();
	      });
       //显示重下订单按钮
       $("#btnrecreate_"+id).show();
       
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
   //重下外部订单
   function recreateOrder(zid)
   {
      $.ajax({
            type:"POST",
            url:"b2bticketorder!reCreateOrder.action",
            async:false,
            data:{s_orderid:$("#hidorderid").val(),zrate_id:zid},
            beforeSend:function(){dispose("正在创建外部订单");},             
            success:function(data){
              colsedispose();
              if(data=="0")
              {
                 alert("只有未出票订单才能重下外部订单，请确认！");
              }   
              else if(data=="1")
              {
                 alert("外部订单创建成功！");
              }
              else if(data=="2")
              {
                 alert("下单接口出现异常，请检查下单接口！");
                 
              }
               
            }            
       });
   }
   
   //手动提取行程单号
function getrepnum()
{  
    $("input[id*='ticketnum_']").each(function(i)
       {
        $.ajax({
        type:"POST",
        url:"passenger!getReptNumberByTN.action",
        data:{s_ticketnumber:$(this).val()},
        beforeSend:function(){$("#divinfo").html("<img src='images/loadding.gif' /><span style='color:red'>正在提取行程单号...</span>");},             
        success:function(data){
        if(data!="")
        {
	        $("#divinfo").html("<span style='color:red'>行程单号提取完成！</span>");
	        $("#fet_"+i).val(data); 
        }
        else
        {
           $("#divinfo").html("<span style='color:red'>行程单号未能取出，请手动填写！</span>");
        }    
        }            
        });
       }
       );
      
        
}
//手动提取票号
function getticnum()
{
    $("input[id*='ticketnum_']").each(function(i)
       {
            var pnumber=i+1;
	        $.ajax({
	        type:"POST",
	        url:"passenger!getTicNumberByPNR.action",
	        data:{strPNRInfo:$("#txtpnrcode").val(),strPNumber:"P"+pnumber},
	        beforeSend:function(){$("#divinfo").html("<img src='images/loadding.gif' /><span style='color:red'>正在提取票号...</span>");},             
	        success:function(data){
	        if(data!="")
	        {
		        $("#divinfo").html("<span style='color:red'>票号提取完成！</span>");
		        $("#ticketnum_"+i).val(data); 
	        }
	        else
	        {
	           $("#divinfo").html("<span style='color:red'>票号未能取出，请手动填写！</span>");
	        }    
	        }            
	        });
       }
       );
}

</script>
</head>
<body>
<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;订单详细信息</b></td>
	</tr>
</table>

<div class="base_b base_bgcolor02">

<div class="flt_silhouette" cdm="blk_ticketinfo"><span
	class="flt_shadow_t"></span><span class="flt_shadow_m">
<div class="flt_shadow_content">
<div class="flt_info" cdm="blk_flightinfo">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">订单基本信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tr height="5px">
					<td></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.ordernumber" /><input type="hidden"
						id="hidorderid" value="<ww:property value="orderinfo.id" />"></td>
					<td class="table_color_r colortrin" width="10%">关联订单号：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.relationorderid==null">无</ww:if> <ww:else>
						<a
							href="orderinfo!toshowgys.action?id=<ww:property value="orderinfo.relationorderid" />"><ww:property
							value="orderinfo.relationorderid" /></a>
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">PNR编码：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.pnr==null">无</ww:if> <ww:else>
						<ww:property value="orderinfo.pnr" />&nbsp;&nbsp;<input
							id="txtpnrcode" type="hidden"
							value="<ww:property value="orderinfo.pnr" />" />
						<a href="#" style="font-weight: bold; color: #22763f"
							onclick="rTPnr();"><img src="images/i.gif" border="0" />PNR提取</a>
					</ww:else></td>

					<td class="table_color_r colortrin" width="10%">订单状态：</td>
					<td class="table_color_l" width="15%"><span
						style="color: red; font-weight: bold;"><ww:property
						value="getStateToString(orderinfo.orderstatus)" /></span></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">支付方式：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.paymethod==null||orderinfo.paymethod==0">网上支付</ww:if>
					<ww:if test="orderinfo.paymethod==1">现金支付</ww:if> <ww:if
						test="orderinfo.paymethod==2">预支付</ww:if></td>
					<td class="table_color_r colortrin" width="10%">支付状态：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="getPayMethod(orderinfo.paystatus)" /></td>
					<td class="table_color_r colortrin" width="10%">创建日期：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.createtime)" /></td>
					<td class="table_color_r colortrin" width="10%">出票时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">支付时间：</td>
					<td class="table_color_l" width="15%"><!--<ww:if
						test="orderinfo.printtime==null">无</ww:if> 
						<ww:else>
					    <ww:property
						value="formatTimestamp(orderinfo.printtime)" />
						</ww:else>
						
						--> <ww:property value="getzhifutime(orderinfo.ordernumber)" /></td>
					<td class="table_color_r colortrin" width="10%">取消时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">申请退废:</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">退款时间：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.printtime==null">无</ww:if> <ww:else>
						<ww:property value="formatTimestamp(orderinfo.printtime)" />
					</ww:else></td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">大PNR：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.bigpnr==null">无</ww:if> <ww:else>
						<ww:property value="orderinfo.bigpnr" />
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">&nbsp;</td>
					<td class="table_color_l" width="15%">&nbsp;</td>
					<td class="table_color_r colortrin" width="10%">&nbsp;</td>
					<td class="table_color_l" width="15%">&nbsp;</td>
					<td class="table_color_r colortrin" width="10%">&nbsp;</td>
					<td class="table_color_l" width="15%">&nbsp;</td>
				</tr>
				<tr height='1px'>
					<td colspan='9'></td>
				</tr>
				<tr>
					<td align="left" colspan="9">
					<div id="pnrinfo"
						style="display: none; background-color: Black; color: #00ff00; height: 123px; width: 100%; margin: 0 auto; overflow: auto;">
					</div>
					</td>
				</tr>
				<tr height='1px'>
					<td colspan='9'><br />
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ul>




<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">异地平台信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border=1 cellspacing=0
				bordercolorlight=#a0cfee bordercolordark=white cellpadding=0>
				<tbody>
					<tr class='GridViewHeaderStyle'
						style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
						<td>政策提供商</td>
						<td>外部订单</td>
						<td>支付状态</td>
						<td>外部订单ID</td>

					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:if test="orderinfo.policyagentid==3">8000yi</ww:if> <ww:elseif
							test="orderinfo.policyagentid==4">百拓</ww:elseif> <ww:elseif
							test="orderinfo.policyagentid==5">票盟</ww:elseif> <ww:else>天河联盟</ww:else>
						</td>
						<td><ww:if
							test="orderinfo.extorderstatus==-1 || orderinfo.extorderstatus==null">创建失败</ww:if>
						<ww:if test="orderinfo.extorderstatus==0"> 创建成功</ww:if> 
						<ww:if test="orderinfo.extorderstatus==3"> 出票成功</ww:if>
						
						<ww:if test="orderinfo.extorderstatus==10"> 支付完成，等待出票</ww:if>
						<ww:if test="orderinfo.extorderstatus==12"> 无法出票</ww:if>
						<ww:if test="orderinfo.extorderstatus==21"> 退票处理中</ww:if>
						<ww:if test="orderinfo.extorderstatus==22"> 无法退票</ww:if>
						<ww:if test="orderinfo.extorderstatus==31"> 废票处理中</ww:if>
						<ww:if test="orderinfo.extorderstatus==32"> 无法废票</ww:if>
						<ww:if test="orderinfo.extorderstatus==90"> 完成退费票</ww:if>
						<ww:if test="orderinfo.extorderstatus==99"> 交易取消退款</ww:if>
								
						</td>
						
						
						<td>
							<ww:if test="orderinfo.extorderstatus==-2">支付失败</ww:if> 
							<ww:if test="orderinfo.extorderstatus== 1">支付成功</ww:if>
						</td>
						<td><ww:property value="orderinfo.extorderid" /></td>
					</tr>

					<tr style="display: none" id='trploicy'>
						<td colspan="5">
						<table width="100%" id="zrate4_2">
							<tr>
								<td align="left"><input type="button" value="普通政策信息"
									style="cursor: pointer; background: url(images/ddda.gif); width: 151px; height: 31px; line-height: 31px; border: none; color: #fff"
									onclick="gettheratesep(0,0);" />&nbsp;<input type="button"
									value="特殊政策信息"
									style="cursor: pointer; background: url(images/addd.gif); width: 200px; height: 31px; line-height: 31px; border: none;"
									onclick="gettheratesep(0,1);" /></td>
							</tr>
							<tr>
								<td>

								<div
									style="width: 100%; border: 2px solid #FF9900; float: left; margin-top: -1px;">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
										<td style="width: 20%; background: #DDECF3">适用政策条数</td>
										<td style="width: 25%; background: #DDECF3">普通返点</td>
										<td style="width: 15%; background: #DDECF3">单张代理费</td>
										<td style="width: 20%; background: #DDECF3">单张结算价</td>
										<!-- 
										<td style="width: 15%;background:#DDECF3">出票或废票时间</td>
										<td style="width: 15%;background:#DDECF3">出票速度</td>
										 -->
										<td style="background: #DDECF3">选择(是否重新下单)</td>
									</tr>
									<tr>
										<td colspan="7">
										<div id="divpolicyinfo_0">此处显示政策信息</div>
										</td>
									</tr>
								</table>
								</div>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			<br />

			<br />
			</td>
		</tr>

	</table>


</ul>




<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">航程信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>航空公司</td>
						<td>航班号</td>
						<td>起飞城市</td>
						<td>到达城市</td>
						<td>起飞时间</td>
						<td>到达时间</td>
						<td>舱位</td>
						<td>折扣</td>
						<td>票面价</td>
						<td><span style="color: red; font-weight: bold;">返点|分销返点</span></td>
						<td>票面结算价</td>
					</tr>
					<input type="hidden" id="hidsegint_size"
						value="<ww:property value='listSegment.size()' />" />
					<ww:iterator value="listSegment" status="state">
						<tr class='postbg1' align="center" valign="middle">
							<td><img
								src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
								border="0" /><ww:property
								value="getAircomapnycodeByEZM(aircomapnycode)" /><input
								type="hidden"
								id="hidaircompany_<ww:property value="#state.index"/>"
								value="<ww:property value="aircomapnycode" />" /></td>
							<td><input type="hidden"
								id='hidflightnumber_<ww:property value="#state.index"/>'
								value="<ww:property value="flightnumber" />" /><ww:property
								value="flightnumber" /></td>
							<td><input type="hidden"
								id='hidsairport_<ww:property value="#state.index"/>'
								value="<ww:property value="startairport" />" /><ww:property
								value="getCitynameByAirport(startairport)" /></td>
							<td><input type="hidden"
								id='hideairport_<ww:property value="#state.index"/>'
								value="<ww:property value="endairport" />" /><ww:property
								value="getCitynameByAirport(endairport)" /></td>
							<td><input type="hidden"
								id='hidfromdate_<ww:property value="#state.index"/>'
								value="<ww:property value="formatTimestamp(departtime)" />" /><ww:property
								value="formatTimestamp(departtime)" /></td>
							<td><input type="hidden"
								id='hidfromdate_<ww:property value="#state.index"/>'
								value="<ww:property value="formatTimestamp(departtime)" />" /><ww:property
								value="formatTimestamp(arrivaltime)" /></td>
							<td><input type="hidden"
								id='hidcabin_<ww:property value="#state.index"/>'
								value="<ww:property value="cabincode" />" /><ww:property
								value="cabincode" /></td>
							<td><ww:property value="discount" /></td>
							<td style="color: red;"><ww:if test="parvalue==null">
								<ww:property value="price" />
							</ww:if><ww:else>
								<ww:property value="parvalue" />
							</ww:else></td>
							<td style="color: red; font-weight: bold; font-size: 18px">
							<ww:if test="ratevalue==nuil">
							0.0
							</ww:if><ww:else>
								<ww:property value="ratevalue" /> | <ww:property
									value="orderinfo.fenxiaoshangfandian" />
							</ww:else> %(<ww:property value="getZrateAgent(orderinfo.policyid)" />)</td>
							<td style="color: red;"><input type="hidden"
								id='ticketprice_<ww:property value="#state.index"/>'
								value="<ww:property value="price" />" /><ww:property
								value="price" /></td>
						</tr>
					</ww:iterator>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>
</div>
</div>
</span><span class="flt_shadow_f"></span></div>

<ww:if test="orderinfo.orderstatus==3">
	<ul class="base_mainbox02 layoutfix">
		<li>
		<h3 class="base_miantitle">乘机人信息<span class="base_annotate"></span></h3>
		</li>
		<form action="passenger!addpassenger.action" name="form1"
			method="post">
		<table class="book_pgcontent" width="100%">
			<tr>
				<td align="center">
				<table class="book_pgcontent" width="98%" border=1 cellspacing=0
					bordercolorlight=#a0cfee style="border-right: 1px solid #a0cfee"
					bordercolordark=white cellpadding=0
					style="border: 1px solid #a0cfee">
					<tbody>
						<tr class='GridViewHeaderStyle'
							style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
							<td>乘客类型</td>
							<td>乘客姓名</td>
							<td>证件类型</td>
							<td>证件号码</td>
							<td>票价</td>
							<td>燃油</td>
							<td>机建</td>
							<td>票号</td>
							<td>行程单</td>
							<td>EI</td>
						</tr>
						<ww:iterator value="listPassenger" status="state">
							<tr class='postbg1' align="center" valign="middle">

								<td><ww:property value="getPassTypeToString(ptype)" /></td>
								<td><ww:property value="name" /></td>
								<td><ww:property value="getIDTypeToString(idtype)" /></td>
								<td><span id="gdvTic_ctl02_lbtnzj"><ww:property
									value="idnumber" /></span></td>
								<td><ww:property value="formatMoney(price)" /></td>
								<td><ww:property value="formatMoney(fuelprice)" /></td>
								<td><ww:property value="formatMoney(airportfee)" /></td>
								<td><input type="text" name="ticketnum" id="ticketnum_<ww:property value="#state.index" />"
									value="<ww:property value="ticketnum" />" /></td>
								<td><input type="text" name="fet" id="fet_<ww:property value="#state.index" />"
									value="<ww:property value="fet" />" /><input type="hidden"
									name="pid" id="pid" value="<ww:property value="id" />" /></td>
								<td><select name="ei" id="ei">
									<option value="">--请选择--</option>
									<option value="不得签转"
										<ww:if test="ei==\"不得签转\"">selected</ww:if>>不得签转</option>
									<option value="不得签转-变更"
										<ww:if test="ei==\"不得签转-变更\"">selected</ww:if>>不得签转、变更</option>
									<option value="不得退票"
										<ww:if test="ei==\"不得退票\"">selected</ww:if>>不得退票</option>
									<option value="不得签转-变更-退票"
										<ww:if test="ei==\"不得签转-变更-退票\"">selected</ww:if>>不得签转、变更、退票</option>
									<option value="全价票" <ww:if test="ei==\"全价票\"">selected</ww:if>>全价票</option>
									<option value="退票收取5％的费用"
										<ww:if test="ei==\"退票收取5％的费用\"">selected</ww:if>>退票收取5％的费用</option>
									<option value="不得签转-退票收费"
										<ww:if test="ei==\"不得签转-退票收费\"">selected</ww:if>>不得签转、退票收费</option>
									<option value="不得签转-变更-退票收费"
										<ww:if test="ei==\"不得签转-变更-退票收费\"">selected</ww:if>>不得签转、变更、退票收费</option>

								</select></td>
							</tr>
						</ww:iterator>
						<tr>
							<td colspan='10'>
							<table width="100%">
								<tr>
									<td align="center">
									<table border="0">
										<tr>
											<td>
											<input type="button" name="" class="button108"
												value="提取票号" onclick="getticnum();" />
											<input type="button" name="" class="button108"
												value="提取行程单" onclick="getrepnum();" /></td>
											<td><input type="button" name="" class="button108"
												value="保存" style="margin-right: 30px;" onclick="aaa();" /></td>
											<td>
											<div id="divinfo"></div>
											</td>
										</tr>
									</table>
									</td>

								</tr>
							</table>
							</td>
						</tr>
						
					</tbody>
				</table>
				</td>
			</tr>
		</table>
		</form>
	</ul>
</ww:if><ww:else>
	<ul class="base_mainbox02 layoutfix">
		<li>
		<h3 class="base_miantitle">乘机人信息<span class="base_annotate"></span></h3>
		</li>
		<table class="book_pgcontent" width="100%">
			<tr>
				<td align="center">
				<table class="book_pgcontent" width="98%" border=1 cellspacing=0
					bordercolorlight=#a0cfee bordercolordark=white cellpadding=0
					style="border: 1px solid #a0cfee">
					<tbody>
						<tr class='GridViewHeaderStyle'
							style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
							<td>乘客类型</td>
							<td>乘客姓名</td>
							<td>证件类型</td>
							<td>证件号码</td>
							<td>票号</td>
							<td>票价</td>
							<td>燃油</td>
							<td>机建</td>
						</tr>
						<ww:iterator value="listPassenger">
							<tr class='postbg1' align="center" valign="middle">
								<td><ww:property value="getPassTypeToString(ptype)" /></td>
								<td><ww:property value="name" /></td>
								<td><ww:property value="getIDTypeToString(idtype)" /></td>
								<td><span id="gdvTic_ctl02_lbtnzj"><ww:property
									value="idnumber" /></span></td>
								<ww:if test="ticketnum!=null">
									<td><ww:property value="ticketnum" /></td>
								</ww:if>
								<ww:else>
									<td>暂无</td>
								</ww:else>
								<td><ww:property value="formatMoney(price)" /></td>
								<td><ww:property value="formatMoney(fuelprice)" /></td>
								<td><ww:property value="formatMoney(airportfee)" /></td>
							</tr>
						</ww:iterator>
					</tbody>
				</table>
				<br />
				</td>
			</tr>
		</table>
	</ul>
</ww:else>







<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">票款信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border=1 cellspacing=0
				bordercolorlight=#a0cfee bordercolordark=white cellpadding=0>
				<tbody>
					<tr class='GridViewHeaderStyle'
						style="font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc">
						<td>总票价</td>
						<td>总燃油费</td>
						<td>总机建费</td>
						<td>邮寄费</td>
						<td>保险费</td>
						<td>应付款</td>

					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:property
							value="formatMoney(orderinfo.totalticketprice)" /></td>
						<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalairportfee)" /></td>
						<td><ww:property value="formatMoney(orderinfo.postmoney)" /></td>
						<td><ww:property
							value="formatMoney(getsuminsurance(orderinfo.insurance))" /></td>
						<td><span style="color: red; font-weight: bold"><ww:property
							value="formatMoney(orderinfo.postmoney+orderinfo.totalticketprice+orderinfo.totalairportfee+orderinfo.totalfuelfee+getsuminsurance(orderinfo.insurance))" /></span></td>
					</tr>
				</tbody>
			</table>
			<br />
			<!-- <table width="98%" border=0 cellspacing=0 cellpadding=0>
			<tr>
						<td colspan='9'><ww:if test="orderinfo.orderstatus==2">
							<input type="button" class="button108" id="btnCancel"
								value="立即出票"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=3')" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" class="button108" id="btnCancel"
								value="暂不能出票"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=16')" />
						</ww:if> <ww:elseif test="orderinfo.orderstatus==5">
							<input type="button" class="button108" id="btnRRTicket"
								value="废票审核通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=11')" />
							&nbsp;&nbsp;&nbsp;&nbsp;

							<input type="button" class="button108" id="btnRRTicket"
								value="废票审核不通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=7')" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</ww:elseif> <ww:elseif test="orderinfo.orderstatus==4">
							<input type="button" class="button108" id="btnRRTicket"
								value="退票审核通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=12&pr=2')" />
							&nbsp;&nbsp;&nbsp;&nbsp;

							<input type="button" class="button108" id="btnRRTicket"
								value="退票审核不通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=17')" />
							<br />
						</ww:elseif> <ww:elseif test="orderinfo.orderstatus==11">
							<input type="button" class="button108" id="btnRRTicket"
								value="废票退款"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=9')" />
							&nbsp;&nbsp;&nbsp;&nbsp;

						</ww:elseif> <ww:elseif test="orderinfo.orderstatus==12">
							<input type="button" class="button108" id="btnRRTicket"
								value="退票退款"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=18')" />
							&nbsp;&nbsp;&nbsp;&nbsp;

						</ww:elseif> <ww:elseif test="orderinfo.orderstatus==13">
							<input type="button" class="button108" id="btnRRTicket"
								value="改签通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=14')" />
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" class="button108" id="btnRRTicket"
								value="改签不通过"
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=15')" />
							&nbsp;&nbsp;&nbsp;&nbsp;

						</ww:elseif></td>
					</tr>
			</table> --> <br />
			</td>
		</tr>
		<input type="hidden" name="" id="hur" style="width: 150px" />

	</table>

	<ww:if test="orderinfo.orderstatus==1">
		<ww:include page="../pay.jsp"></ww:include>
	</ww:if>
</ul>
</div>
<div
	style="width: 100%; background-color: Gray; display: none; height: 100%; position: absolute; left: 0; top: 0;"
	id="xie">
<div
	style="width: 260px; background-color: Gray; display: none; height: 113px; position: absolute; left: 244px; top: 137px;"
	id="content1"></div>
<div id="changerate" />
</body>
</html>