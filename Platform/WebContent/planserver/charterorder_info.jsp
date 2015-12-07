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
<link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
var vprice=$("#allprice").html();
$("#syprice").html(vprice);

});
function operate(){
   var operate=$("#oper");
   if (operate.html()=="-点击隐藏"){
   operate.html("+点击显示");
   }else{
    operate.html("-点击隐藏");
   }
  $("#operate").toggle();
}

   function rTPnr(num)
    {
       $("#pnrinfo").show();
       $.ajax({
            type:"POST",
            url:"orderinfo!rtPNRinfo.action?etermtype="+num,
            data:{strPNR:$("#txtpnrcode"+num).val()},
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
				if(h1==1){//废票
				
				
				//document.getElementById("xie").style.display = "";
              // document.getElementById("content1").style.display = "";
				
			  //  document.getElementById("xie").style.filter = "Alpha(Opacity=50)";//透明度
			 //   document.getElementById("content1").innerHTML = "退票手续费:<input type='text' id='da' value='' /> <br /><input onclick='hi()' type='button' value='确定'/> <input onclick='hide()' type='button' value='取消'/>";
				 $("#divpassenger").dialog({
		                title:'机票订单废票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 580,
		                height: 380
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         var id = <ww:property value="orderinfo.id" />;
		       //  alert(id)
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
					
			
				}
				
				if(h1==2){
				
				
				//document.getElementById("xie").style.display = "";
              // document.getElementById("content1").style.display = "";
				
			  //  document.getElementById("xie").style.filter = "Alpha(Opacity=50)";//透明度
			 //   document.getElementById("content1").innerHTML = "退票手续费:<input type='text' id='da' value='' /> <br /><input onclick='hi()' type='button' value='确定'/> <input onclick='hide()' type='button' value='取消'/>";
				 $("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 580,
		                height: 380
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         var id = <ww:property value="orderinfo.id" />;
		        // alert(id)
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:2},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
					
			
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
    

    
  //点击退票
function tuiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要退票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行退票操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=12&pr=2&passid='+passengerids+'&tui='+$("#txttuifee").val();
	    }
     }
    
}
//点击废票
function feiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要废票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行废票操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=11&pr=1&passid='+passengerids;
	    }
     }
    
}

function ajaxOutstats(){

   $.ajax({
      type:"POST",
      url:"orderinfo!getPassengerList.action",
      data:{strTuiOrderID:id,typ:2},
      beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
      success:function(data){
      $("#divpassenger").html(data);           
      }            
      });
					
}
  
	</script>
</head>
<body>
<div id="divpassenger" style="text-align:center;display:none; background-color:#fff;left:0px;">正在加载订单信息...
</div>
<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;机票订单详细信息</b></td>
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
						value="orderinfo.ordernumber" />
						</td>
					<td class="table_color_r colortrin" width="10%">关联订单号：</td>
					<td class="table_color_l" width="15%"><ww:if
						test="orderinfo.relationorderid==null">无</ww:if> <ww:else>
						<a
							href="orderinfo!toshowb2c.action?id=<ww:property value="orderinfo.relationorderid" />"><ww:property
							value="orderinfo.relationorderid" /></a>
					</ww:else></td>
					<td class="table_color_r colortrin" width="10%">PNR编码：</td>
					<td class="table_color_l" width="15%">
					<ww:if
						test="orderinfo.pnr==null">无</ww:if> 
						<ww:else>
						<ww:property value="orderinfo.pnr" />&nbsp;&nbsp;
						<input id="txtpnrcode1" type="hidden" value="<ww:property value="orderinfo.pnr" />" />
						<a href="#" style="font-weight:bold;color:#22763f"
							onclick='rTPnr("1");'><img src="images/i.gif" border="0" />PNR提取</a>
					</ww:else></td>

					<td class="table_color_r colortrin" width="10%">大PNR：</td>
					<td class="table_color_l" width="15%">
					<ww:if
						test="orderinfo.bigpnr==null">无</ww:if> 
						<ww:else>
					    <ww:property value="orderinfo.bigpnr" />
					    <input id="txtpnrcode2" type="hidden" value="<ww:property value="orderinfo.bigpnr" />" />
						<a href="#" style="font-weight:bold;color:#22763f"
							onclick='rTPnr("2");'><img src="images/i.gif" border="0" />PNR提取</a>
						</ww:else>
					</td>
				</tr>
				<tr>

					<td class="table_color_r colortrin" width="10%">支付方式：</td>
					<td class="table_color_l" width="15%">
					<ww:property value="getPayMethodStr(orderinfo.paymethod)"/>
						</td>
					<td class="table_color_r colortrin" width="10%">支付状态：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.paystatus==0?'未支付':'已支付'" /></td>
					<td class="table_color_r colortrin" width="10%">创建日期：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.createtime)" /></td>
					<td class="table_color_r colortrin" width="10%">出票时间：</td>
					<td class="table_color_l" width="15%">
					<ww:if
						test="orderinfo.printtime==null">无</ww:if> 
						<ww:else>
					    <ww:property
						value="formatTimestamp(orderinfo.printtime)" />
						</ww:else>
						</td>
				</tr>
				
				<tr>

					<td class="table_color_r colortrin" width="10%">订单状态：</td>
					<td class="table_color_l" width="15%">
					<span style="color: red;font-weight:bold;">
					
					<ww:property
						value="getStateToString(orderinfo.orderstatus)" /></span></td>
					<td class="table_color_r colortrin" width="10%">联系人姓名：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.contactname" /></td>
					<td class="table_color_r colortrin" width="10%">联系人电话：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.contactmobile" /></td>
					<ww:if test="getLoginUserAgent().agenttype==1">	
				   <td class="table_color_r colortrin" <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if>>出票商：</td>
				   <td class="table_color_l"  <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if>><b><ww:property value="getFamousAgentName(orderinfo.policyagentid)"/></b></td>
				   </ww:if>
				   <ww:else>
				   <td class="table_color_r colortrin"></td>
				   <td class="table_color_l" ></td>
				   </ww:else>
				</tr>
				<ww:if test="orderinfo.isshengcang==1">
				<tr>
				<td class="table_color_r colortrin" style="font-weight:bold;color:red" width="10%">升舱订单号：</td>
					<td class="table_color_l" width="15%" style="font-weight:bold;color:red">
					<a href="orderinfo!toshowb2c.action?id=<ww:property value="orderinfo.shengcangorderid" />"><ww:property
						value="orderinfo.shengcangorderid" /></a>
					</td>
					<td class="table_color_r colortrin" width="10%" style="font-weight:bold;color:red">升舱补差订单：</td>
					<td class="table_color_l" width="15%" style="font-weight:bold;color:red">
                        是
                    </td>
					<td class="table_color_r colortrin" width="10%" style="font-weight:bold;color:red">原票号：</td>
					<td class="table_color_l" width="15%" style="font-weight:bold;color:red">
					<ww:property value="orderinfo.shengcangoldtn" />
					</td>
					<td class="table_color_r colortrin" width="10%"></td>
					<td></td>
				</tr>
				</ww:if>
				<tr>
			
				<td class="table_color_r colortrin">采购商名称：</td>
				
					<td class="table_color_l" colspan='2'><ww:property value='getagentname_b2bback(orderinfo.buyagentid)' />
					<!-- 加盟商级别 -->
					(<font color="red"><b><ww:property value="getAgentTypeName(getangtjibie(orderinfo.buyagentid))" /></b></font>)
					<!-- 加盟商级别 -->
					</td>
					<td class="table_color_r colortrin">出票商订单状态：</td>
					<td class="table_color_l" colspan="2">
					<SPAN id="outstr"><ww:property value="orderinfo.extorderstatusstr"/></SPAN>
					&nbsp;<A style="cursor: pointer;" href="javascript:void(0)" onclick="ajaxOutstats();">刷新查看</A>
					</td>
					<td class="table_color_r colortrin" >
					<ww:if test="getLoginsessionagent().agenttype==1">出票商订单号：</ww:if>
					</td>
					<td class="table_color_l">
					<ww:if test="getLoginsessionagent().agenttype==1"><ww:property value="orderinfo.extorderid" /></ww:if>
					</td>
				</tr>
				
				
				<tr>
					<td class="table_color_r colortrin">订单备注：</td>
					<td class="table_color_l" colspan='3'>
					<textarea rows="3" cols="45" readonly="readonly"><ww:property value='converNull(orderinfo.memo,"")' />
					</textarea>
					<td class="table_color_r colortrin">政策备注：</td>
					<td class="table_color_l" colspan='3' >
					<textarea rows="3" cols="45" readonly="readonly"><ww:property value='converNull(listSegment.get(0).rules,"")' />
					</textarea>
					</td>
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
	<!-- ------------------------- -->
	
</ul>

<ww:if test="orderinfo.orderstatus==10">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">收银信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>付款方式</td>
						<td>金额</td>
						<td>收银员</td>
						<td>收银时间</td>
					</tr>
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="getFkmethodstr(orderinfo.fkmethod)" /></td>
							<td id="syprice"></td>
							<td><ww:property value="getusername(getOrderrcByOrderIdAndOrerstate(orderinfo.id,orderinfo.orderstatus).customeruserid)" /></td>
							<td><ww:property value="formatTimestamp(getOrderrcByOrderIdAndOrerstate(orderinfo.id,orderinfo.orderstatus).createtime)" /></td>
						</tr>
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
</ww:if>

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
						<td style="display:none">票面价</td>
						<td><span style="color:red;font-weight:bold;">返点</span></td>
						<td>票面价</td>
					</tr>
					<ww:iterator value="listSegment">
						<tr class='postbg1' align="center" valign="middle">
							<td><img
								src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
								border="0" /><ww:property
								value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
							<td><ww:property value="flightnumber" /></td>
							<td><ww:property value="getCitynameByAirport(startairport)" /></td>
							<td><ww:property value="getCitynameByAirport(endairport)" /></td>
							<td><ww:property value="formatTimestamp(departtime)" /></td>
							<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
							<td><ww:property value="cabincode" /></td>
							<td><ww:property value="discount" /></td>
							<td style="color:red;display:none">
							<ww:if test="parvalue==null">
							<ww:property value="yprice" />
							</ww:if><ww:else>
							<ww:property value="yprice" />
							</ww:else>
							
							
							</td>
							<td style="color:red;font-weight:bold;font-size:18px;">
							<ww:if test="orderinfo.fenxiaoshangfandian==nuil">
							0.0
							</ww:if><ww:else>
							<ww:property value="orderinfo.fenxiaoshangfandian" />
							</ww:else>
							
							
							%</td>
							<td style="color:red;"><ww:property value="parvalue" /></td>
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
							<td>票面结算价</td>
							<td>燃油</td>
							<td>机建</td>
							<ww:if test="orderinfo.internal==1">
							<td>安检</td>
							<td>其它</td>
							</ww:if>
							<td>保险</td>
							<td width="135px">票号</td>
							<td>行程单</td>
						</tr>
						<ww:set name="allinsurprice" value="0"/>
						<ww:iterator value="listPassenger" status="state">
							<tr class='postbg1' align="center" valign="middle">

								<td><ww:property value="getPassTypeToString(ptype)" /></td>
								<td>
								<span   <ww:if test="orderinfo.internal==1">style="cursor: pointer; text-decoration:underline" onclick=showPinfo(<ww:property value="id"/>) </ww:if>  >
								
								<ww:property value="name" />
								</span>
								</td>
								<td><ww:property value="getIDTypeToString(idtype)" /></td>
								<td><span id="gdvTic_ctl02_lbtnzj"><ww:property
									value="idnumber" /></span></td>
								<td><ww:property value="formatMoney(price)" /></td>
								<td><ww:property value="formatMoney(fuelprice)" /></td>
								<td><ww:property value="formatMoney(airportfee)" /></td>
								<ww:if test="orderinfo.internal==1">
								<td><ww:property value="formatMoney(anjianfee)" /></td>
								<td><ww:property value="formatMoney(otherfee)" /></td>
								</ww:if>
								<ww:set name="insurprice" value="getInsurancPrice(insurance)"/>
								<td><ww:property value="#insurprice" /></td>
								<ww:set name="allinsurprice" value="#allinsurprice+#insurprice"/>
								<td><ww:property value="ticketnum" /></td>
								<td><ww:property value="fet" /></td>
							</tr>
							<ww:if test="orderinfo.internal==1">
							<tr style="display: none;" id='detail<ww:property value="id"/>'>
							<td colspan="20">
							<table width="80%" border="1">
							<tr>
							<td align="right">国籍/地区：</td>
							<td><ww:property value="country"/></td>
							<td align="right">性别：</td>
							<td><ww:property value="sex"/></td>
							<td align="right">证件有效期：</td>
							<td><ww:property value="cardvaliddate"/></td>
							</tr>
							<tr>
							<td align="right">是否留学生：</td>
							<td><ww:if test="isstudent==1">是</ww:if><ww:else>不是</ww:else></td>
							<td align="right">出生日期：</td>
							<td><ww:property value="birthday"/></td>
							<td align="right">目的地邮编：</td>
							<td><ww:property value="destzipcode"/></td>
							</tr>
							<tr>
							<td align="right">目的地址：</td>
							<td colspan="2"><ww:property value="destadress"/></td>
							<td align="right">现居住地址：</td>
							<td colspan="2"><ww:property value="liveaddress"/></td>
							</tr>
							</table>
							</td>
							</tr>
							</ww:if>
						</ww:iterator>
						
					</tbody>
				</table>
				</td>
			</tr>
		</table>
		</form>
		<!--<table width="100%">
			<tr>
				<td align="center">
				<table border="0">
					<tr>
						<td><input type="submit" name="" class="button108"
							value="提取行程单" onclick="getrepnum();" /></td>
						<td><input type="submit" name="" class="button108" value="保存"
							style="margin-right: 30px;" onclick="aaa();" /></td>
						<td>
						<div id="divinfo"></div>
						</td>
					</tr>
				</table>
				<input type="submit" name=""
					class="button108" value="打印行程单"
					onclick="bbb('passenger!orderchupiao.action?orderinfoid=<ww:property value="orderinfo.id" />')" />
					
					</td>

			</tr>
		</table>-->
	</ul>




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
						<td>总票面结算价</td>
						<td>总燃油费</td>
						<td>总机建费</td>
						<ww:if test="orderinfo.internal==1">
						<td>总安检费</td>
						<td>总其它费</td>
						</ww:if>
						<td style="display:none">邮寄费</td>
						<td>总保险费</td>
						
						<ww:if test="orderinfo.orderstatus==4||orderinfo.orderstatus==5||orderinfo.orderstatus==11||orderinfo.orderstatus==12||orderinfo.orderstatus==17||orderinfo.orderstatus==18">
						  <td>退款金额</td>
						</ww:if>
						
						<td tip="订单总利润为机票订单在未返佣给代理商之前的纯利润" <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if> >订单总利润</td>
						
						<td <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if>>订单返点</td>
						<td <ww:if test="getLoginsessionagent().id==orderinfo.buyagentid">style="display:none"</ww:if>>本级留点</td>
						<td>本级利润</td>
						<td>应付款</td>
						
					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:property
							value="formatMoney(orderinfo.totalticketprice)" /></td>
						<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalairportfee)" /></td>
							<ww:if test="orderinfo.internal==1">
							<td><ww:property
							value="formatMoney(orderinfo.totalanjian)" /></td>
							<td><ww:property
							value="formatMoney(orderinfo.totalotherfee)" /></td>
							</ww:if>
						<td style="display:none"><ww:property value="formatMoney(orderinfo.postmoney)" /></td>
						<td><ww:property
							value="formatMoney(#allinsurprice)" /></td>
						
							<ww:if test="orderinfo.orderstatus==4||orderinfo.orderstatus==5||orderinfo.orderstatus==11||orderinfo.orderstatus==12||orderinfo.orderstatus==17||orderinfo.orderstatus==18">
						<td><ww:property value="orderinfo.returnprice"/></td>
						</ww:if>
						<td <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if>>
						<ww:property value="formatMoney_string(converNull(orderinfo.rebatemoney*adultnum,0f))" />
						</td>
						<td <ww:if test="getLoginsessionagent().agenttype!=1">style="display:none"</ww:if>>
						<ww:property value="converNull(orderinfo.ratevalue,0f)" />%
						</td>
						<td <ww:if test="getLoginsessionagent().id==orderinfo.buyagentid">style="display:none"</ww:if>>
						<ww:property value="GetBenJiLiudian(orderinfo.backpointinfo,1)" />%
						</td>
						<td style="color:red">
						
						<b><ww:property value="getNationTicketrebat(orderinfo.backpointinfo)*adultnum" /></b>
						</td>
						<td>
						<span style="color: red; font-weight: bold" id="allprice">
						<ww:property
							value="formatMoney(converNull(orderinfo.totalotherfee,0)+converNull(orderinfo.totalanjian,0)+orderinfo.postmoney+orderinfo.totalticketprice+orderinfo.totalairportfee+orderinfo.totalfuelfee+converNull(getIssurByOrderid(id),0))" /></span>
						</td>
					</tr>
				</tbody>
			</table>
			<br />
			<table width="98%" border=0 cellspacing=0 cellpadding=0>
			<tr>
			<ww:if test="#session.ListAgid.indexOf('10042')>0">
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
								onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=11&pr=1')" />
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

						</ww:elseif>
						<ww:elseif test="orderinfo.orderstatus==3">
					<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=5&pr=1')" />
												
					<input type="button" class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=4&pr=2')" />
					<input type="button" class="button108" id="btnRRTicket" value="申请改签"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="orderinfo.id" />&orderstatus=13')" />
												
						</ww:elseif>
						</td>
						</ww:if>
					</tr>
			</table>
			<br />
			</td>
		</tr>
		

	</table>
	<input type="hidden" name="" id="hur"  style="width: 150px" />		
	<div style="width: 100%; background-color:Gray; display:none; height: 100%; position:absolute; left: 0; top: 0;" id="xie">
<div style="width: 260px; background-color:Gray; display:none; height: 113px; position:absolute; left: 244px; top: 137px;" id="content1"></div>
	
</ul>


<ul class="base_mainbox02 layoutfix">
    <li>
	<font class="base_miantitle" ><B>订单处理状态</B><span  class="base_annotate"></span>
	</font>
	<span onclick="operate()" style=" cursor: pointer;color:red" id="oper">-点击隐藏</span>
	</li>
	<table class="book_pgcontent" width="100%" id="operate">
		<tr>
			<td align="center" width="100%">
			<table  class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>订单号</td>
						<td>操作人员</td>
						<td>操作时间</td>
						<td>状态</td>
						<td>备注</td>
						
					</tr>
					<ww:iterator value="listorderinforc">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="orderinfoid"/></td>
							<td><ww:property value="getCustomerNameById(customeruserid)"/></td>
							<td><ww:property value="formatTimestamp(createtime)"/></td>
							<td><ww:property value="getStateToString(state)"/></td>
							<td align="left" style="padding-left:60px"><ww:property value="content"/></td>
						</tr>
					</ww:iterator>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>


<!--  
<ww:if test="orderinfo.receipt==4||orderinfo.orderstatus==3">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">配送信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tr height="5px" colspan="6">
					<td></td>
				</tr>
				<tr>
					
					<td class="table_color_r colortrin" width="200px">联系人：</td>
					<td class="table_color_l" width="10%">
				  <ww:if test="orderinfo.customeragentid==46">
					<ww:property value='converNull(orderinfo.postname,"无")'/>
					</ww:if>
					<ww:else>
				
					<ww:property value='converNull(orderinfo.contactname,"无")' />
					
					</ww:else>
					</td>
					<td class="table_color_r colortrin" width="200px">联系电话：</td>
					<td class="table_color_l" width="10%">
					 <ww:if test="orderinfo.customeragentid==46">
					 <ww:property value='converNull(orderinfo.postmobile,"无")'/>
					 </ww:if>
					 <ww:else>
					  <ww:property value='converNull(orderinfo.contactmobile,"无")'/>
					</ww:else>
					</td>
					<td class="table_color_r colortrin" width="200px">集团客户名称：</td>
					<td class="table_color_l" width="15%">
					<ww:if test="orderinfo.customeragentid==46">
					   散客
					</ww:if>
					<ww:else>
					<ww:property
						value="getcususeragentname(orderinfo.customeruserid)" />
				    </ww:else>
						</td>
					
				</tr>
					<tr>
						<td class="table_color_r colortrin" width="10%">送票地址：</td>
						<td class="table_color_l" width="15%"><ww:property
							value="orderinfo.addresa" /></td>
						<td class="table_color_r colortrin" width="10%">送票状态:</td>
						<td class="table_color_l" width="10%" style="color: red"><ww:if
							test="orderinfo.peisongstatus==0">未配送</ww:if> <ww:elseif
							test="orderinfo.peisongstatus==1">配送中</ww:elseif> <ww:elseif
							test="orderinfo.peisongstatus==2">已配送</ww:elseif></td>
						<td class="table_color_r colortrin" width="10%">送票人姓名:</td>
						<td class="table_color_l"><ww:property
							value="getEmployeeName(orderinfo.peisongrenid)" /></td>


					</tr>

					<tr height='1px'>
					<td colspan='6'><br />
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ul>
</ww:if>
-->
<ww:if test="orderinfo.receipt==3">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">邮寄信息<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
				<tr height="5px" colspan="6">
					<td></td>
				</tr>
				<tr>					
					<td class="table_color_r colortrin" width="200px">收件人：</td>
					<td class="table_color_l" width="140px"><ww:property value="orderinfo.postname" /></td>
					<td class="table_color_r colortrin" width="200px">联系电话：</td>
					<td class="table_color_l"><ww:property value="orderinfo.postmobile" /></td>
					<td class="table_color_r colortrin" width="200px">邮编：</td>
					<td class="table_color_l" width="80px"><ww:property value="orderinfo.postcode" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" width="10%">送票地址：</td>
						<td class="table_color_l" colspan="5"><ww:property
							value="orderinfo.addresa" /></td>
							</tr>
							<tr>
						<td class="table_color_r colortrin" width="10%">订单备注：</td>
						<td class="table_color_l" colspan="5"><ww:property
							value="orderinfo.memo" /></td>
					</tr>

					<tr height='1px'>
					<td colspan='6'><br />
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</ul>
</ww:if>
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">短信发送记录<span class="base_annotate"></span></h3>
	</li>

	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center" width="100%">
			<table id="tbTravel" class="book_pgcontent" width="98%" border=1
				cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
				cellpadding=0 style="border: 1px solid #a0cfee">
				<tbody>
				<ww:if test="listYmsend.size>0">
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td>手机号码</td>
						<td>短信类型</td>
						<td>发送时间</td>
						<td>发送状态</td>
						<td>短信内容</td>
					</tr>
					<ww:iterator value="listYmsend">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="phone" /></td>
							<td><ww:if test="type==1">航班动态短信</ww:if><ww:if test="type==2">出票短信</ww:if></td>
							<td><ww:property value="formatTimestamptoMinute(createtime)"/></td>
							<td><ww:if test="state==0||state==2">发送成功</ww:if><ww:else>发送失败</ww:else></td>
							<td style="text-align: left;"><textarea rows="2" cols="70%"><ww:property value="content"/></textarea></td>
						</tr>
					</ww:iterator>
				</ww:if>
				<ww:else>
				无
				</ww:else>
				</tbody>
			</table>
			<br />
			</td>
		</tr>
	</table>
</ul>

</div>
</body>
<script>
function showPinfo(vid){
var thetr=$("#detail"+vid);
if(thetr.css("display")=="none"){
thetr.show();
}else{
thetr.hide();
}
}
</script>
</html>