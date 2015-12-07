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
<style type="text/css">
.passtable{
border-collapse:collapse;
background-color:#d7e9fc;
border:none;
}
.passth{
border:solid #99CCFF 1px;
text-align: center;
}
.passtd{
border:solid #99CCFF 1px;
}
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script charset="UTF-8" src="<%=request.getContextPath() %>/js/dialog.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/style/dialog.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery.tablePagination.0.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<link href="<%=request.getContextPath() %>/style/mapcss.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script>
Ext.onReady(function(){ 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,         
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:170,
	   tpl: "<tpl for='.'><div style='height:240px ; width:170px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  
	<ww:property value="deptstr"/>	
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){            
            comboxWithTree.setValue(node.text);
           if(Ext.getDom('parentid').value!=node.id){
           Ext.get('linkname').set({value:""});
           Ext.get('linkphone').set({value:""});
           Ext.get('linkemile').set({value:""});
            }
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();              
       });     	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();//是否展开子菜单			
		});
	
    comboxWithTree.render('comboxWithTree'); 
});
</script>
<script>
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
    
	</script>
	
	<script type="text/javascript">
function customer(){
  $("#customer").dialog(
        {title:'添加联系人',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 550,
                height:400     
       });
       
      var agentid=$("#parentid").val();
       $("#customer").dialog("open");
       jQuery.post("orderinfo!getUserlistByAgent.action",{agent:agentid},function(data){
       $("#customer").html(data);
       $('#divtable').tablePagination({});
		var ctable=Ext.fly("divtable");


       });
     
 }
function showEditGzrDialog(){
  $("#editgzr").dialog(
        {title:'修改挂账人',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 550,
                height:400     
       });
       $("#editgzr").dialog("open");
       jQuery.post("orderinfo!getUserlistByAgent.action",{agent:46},function(data){
       $("#editgzr").html(data);
       $('#divtable').tablePagination({});
		var ctable=Ext.fly("divtable");

       });
     
 }
 function searchuser(){
   var username=$("#cuname").val();
   var agentid=$("#parentid").val();
   var isgz=false;
   if($("#editgzr").css("display")=="block"){
   agentid=46;
   isgz=true;
   }
  jQuery.post("orderinfo!getUserlistByAgent.action",{agent:agentid,username:username},function(data){
    if(isgz){
           $("#editgzr").html(data);
    }else{
       $("#customer").html(data);
     }
       $('#divtable').tablePagination({});
		var ctable=Ext.fly("divtable");
       });
 }
 
 function getGzr(id,name){
  $("#grgzid").val(id);
  $("#grgzname").val(name);
  $("#editgzr").dialog("close");
 }
 function getCuname(id,name,meobile,mail){
 $("#linkid").val(id);
 $("#linkname").val(name);
 $("#linkphone").val(meobile);
 $("#linkemail").val(mail);
 $("#customer").dialog("close");
 }
</script>
	
	<script type="text/javascript">
function changeraddisable(rd1,typ1,rd2,typ2,rd3,typ3,rdchecked){
      document.getElementById(rd1).disabled=typ1;
      document.getElementById(rd2).disabled=typ2;
      document.getElementById(rd3).disabled=typ3;
      document.getElementById(rdchecked).disabled="";
      document.getElementById(rdchecked).checked="checked";
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','none');
      if(rdchecked=="postmoney3"||rdchecked=="postmoney4"){
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','block');
      }
      if(rdchecked=="postmoney2"){
        showdiag('addtesstable_my','block');
        showdiag('addtesstable','none');
      }
}
 function showdiag(diag,flag)
	{
		document.getElementById(diag).style.display=flag;
	}
	
	function showgrgz(){
	var fkfs=$("#fkid").val();
	if(fkfs==7){
	$(".grgznone").show();
	 }else{
	 $(".grgznone").hide();
	 }
	
	}
</script>
</head>
<body>
<form action="orderinfo!edit.action" name="form1" method="post">
<div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;机票订单信息修改</b></td>
	</tr>
</table>

<div class="base_b base_bgcolor02"><!--航班和乘客信息-->

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
				<tr>
					<td align="left" colspan="9" id="pnrinfo"
						style="display: none; background-color: Black; color: #00ff00; height: 121px">
					<img src='images/loadpnr.gif' /><font color="00ff00"><b>正在加载PNR信息.....</b></font>
					</td>
				</tr>
				<tr height="20px">
					<td></td>
				</tr>
				<tr>
					<td class="table_color_r colortrin" width="10%">订单号：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="orderinfo.ordernumber" /></td>
					<td class="table_color_r colortrin" width="10%">关联订单号：</td>
					<td class="table_color_l" width="15%">
					<ww:if test="orderinfo.relationorderid!=null">
					<a href="orderinfo!toshowb2c.action?id=<ww:property value="orderinfo.relationorderid" />">
					 <ww:property value="orderinfo.relationorderid" />
					</a>
					</ww:if>
					<ww:else>
					无
					</ww:else>
					</td>
					<td class="table_color_r colortrin" width="10%">PNR编号：</td>
					<td class="table_color_l" width="15%">
					<ww:if
						test='orderinfo.pnr!=null && !orderinfo.pnr.equals("")'>
						<input type="text" style="width:50px" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> name="pnr" value="<ww:property value="orderinfo.pnr" />" />
							&nbsp;&nbsp;<input id="txtpnrcode" type="hidden" value="<ww:property value="orderinfo.pnr" />" />
						<a href="#" style="font-weight: bold; color: #22763f"
							onclick="rTPnr();"><img src="images/i.gif" border="0" />PNR提取</a>
					</ww:if> 
					<ww:else>
							<input type="text" name="pnr" style="width:50px" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> value="<ww:property value="orderinfo.pnr" />" />
					</ww:else>
					</td>
					<td class="table_color_r colortrin" width="10%">大PNR：</td>
					<td class="table_color_l" width="15%">
					<input type="text" name="bigpnr" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> style="width:50px" value="<ww:property value="orderinfo.bigpnr" />" />
					</td>
				</tr>
				<tr>
				    <td class="table_color_r colortrin">客户单位：</td>
				    <td align='left'>
				    
				    <span <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="checkright('jibenxinxixiugai') && orderinfo.orderstatus==10">style='display:block'</ww:if><ww:else>style='display:none'</ww:else></ww:if>><ww:property value="companyname"/></span>
				    
				     <span style="HEIGHT: 71px" > 
						 <table border="0" cellspacing="0" cellpadding="0" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="checkright('jibenxinxixiugai') && orderinfo.orderstatus==10">style='display:none'</ww:if><ww:else>style='display:block'</ww:else></ww:if><ww:else>style='display:none'</ww:else>>
						 <tr>
						 <td><div id='comboxWithTree' style="" ></div>
						</td>
						<td> 
						<input type="text"  style="width:0px;border: 0px" id="parentid" name="s_customeragentid" value="<ww:property value="s_customeragentid"/>"  />
						</td>
						<td><span class="font-red">&nbsp;&nbsp;&nbsp;</span></td>						
						</tr></table>	
				    </td>
					<td class="table_color_r colortrin" width="10%">联系人姓名：</td>
					<td class="table_color_l" width="15%">
					<input type="hidden" name="id" value="<ww:property value="orderinfo.id"/>" />
					<input type="hidden" id="linkid" name="customeruserid" value="<ww:property value="orderinfo.customeruserid"/>" />
					<input
						type="text" onfocus="customer()" id="linkname" name="contactname" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>
						value="<ww:property
						value="orderinfo.contactname" />" /></td>
					<td class="table_color_r colortrin" width="10%">联系人手机：</td>
					<td class="table_color_l" width="15%"><input type="text" id="linkphone" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>
						name="contactmobile" readonly="readonly"
						value="<ww:property
						value="orderinfo.contactmobile" />" /></td>
					<td class="table_color_r colortrin" width="10%">联系人邮件：</td>
					<td class="table_color_l" width="15%"><input type="text" id="linkemile" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>
						name="contactemail" readonly="readonly"
						value="<ww:property
						value="orderinfo.contactemail" />" /></td>
					
				</tr>
				
				<tr>
					<td class="table_color_r colortrin" width="10%">创建日期：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.createtime)" /></td>
					<td  class="table_color_r colortrin" width="10%">出票时间：</td>
					<td class="table_color_l" width="15%"><ww:property
						value="formatTimestamp(orderinfo.printtime)" /></td>
				   <td class="table_color_r colortrin">补差订单号：</td><td class="table_color_l" >
					<input type="textbox" id="" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> name="shengcangorderid" value="<ww:property value="orderinfo.shengcangorderid" />">
					
					</td>
					<ww:if test="orderinfo.fkmethod!=7">
					<td class="table_color_r colortrin grgznone"  width="10%">
					</td>
					<td class="table_color_l grgznone" width="15%" >
					</td>
					</ww:if>
					<ww:else>
					
					<td class="table_color_r colortrin grgznone"  width="10%">
					个人挂账：</td>
					<td class="table_color_l grgznone" width="15%" >
					
					<input type="hidden" name="guazhangrenid" id="grgzid" value="<ww:property value="orderinfo.guazhangrenid"/>"/>
					<b><input id="grgzname" size='8' readonly="readonly" value='<ww:property value="getusername(orderinfo.guazhangrenid)" />'/>
					</b><input type="button" onclick="showEditGzrDialog()" value="修改"/>
					</td>
					</ww:else>
				</tr>
				
				<tr>
					<td class="table_color_r colortrin">订单备注：</td><td class="table_color_l" colspan='8'>
					<textarea rows="5" cols="50" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> name="memo"><ww:property value="orderinfo.memo" /></textarea>
					
					</td>
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

<!-- 订单状态修改 -->
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">订单状态修改<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="table_color_r colortrin">订单状态</td>
						<td class="table_color_l">
						<select <ww:if test="checkright('suoyouxinxixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>
						name="orderstatus" style="width: 142px;">
						<option value="1"
							<ww:if test="orderinfo.orderstatus==1">selected="selected"</ww:if>>等待支付</option>
						<option value="2"
							<ww:if test="orderinfo.orderstatus==2">selected="selected"</ww:if>>等待出票</option>
						<option value="3"
							<ww:if test="orderinfo.orderstatus==3">selected="selected"</ww:if>>出票完成</option>
						<option value="4"
							<ww:if test="orderinfo.orderstatus==4">selected="selected"</ww:if>>申请退票</option>
						<option value="5"
							<ww:if test="orderinfo.orderstatus==5">selected="selected"</ww:if>>申请废票</option>
						<option value="6"
							<ww:if test="orderinfo.orderstatus==6">selected="selected"</ww:if>>取消订单</option>
						<option value="7"
							<ww:if test="orderinfo.orderstatus==7">selected="selected"</ww:if>>废票不成功</option>
						<option value="8"
							<ww:if test="orderinfo.orderstatus==8">selected="selected"</ww:if>>审核失败</option>
						<option value="9"
							<ww:if test="orderinfo.orderstatus==9">selected="selected"</ww:if>>废票退款成功</option>
						<option value="10"
							<ww:if test="orderinfo.orderstatus==10">selected="selected"</ww:if>>订单关闭</option>
						<option value="11"
							<ww:if test="orderinfo.orderstatus==11">selected="selected"</ww:if>>已经废票</option>
						<option value="12"
							<ww:if test="orderinfo.orderstatus==12">selected="selected"</ww:if>>已经退票</option>
						<option value="13"
							<ww:if test="orderinfo.orderstatus==13">selected="selected"</ww:if>>申请改签</option>
						<option value="14"
							<ww:if test="orderinfo.orderstatus==14">selected="selected"</ww:if>>已经改签</option>
						<option value="15"
							<ww:if test="orderinfo.orderstatus==15">selected="selected"</ww:if>>改签失败</option>
						<option value="16"
							<ww:if test="orderinfo.orderstatus==16">selected="selected"</ww:if>>暂不能出票</option>
						<option value="17"
							<ww:if test="orderinfo.orderstatus==17">selected="selected"</ww:if>>退票不成功</option>
						<option value="18"
							<ww:if test="orderinfo.orderstatus==18">selected="selected"</ww:if>>退票退款成功</option>
						<option value="28"
							<ww:if test="orderinfo.orderstatus==28">selected="selected"</ww:if>>在途订单</option>
						<option value="29"
							<ww:if test="orderinfo.orderstatus==29">selected="selected"</ww:if>>待收银</option>
						<option value="23"
							<ww:if test="orderinfo.orderstatus==23">selected="selected"</ww:if>>申请升舱换开</option>
						<option value="25"
							<ww:if test="orderinfo.orderstatus==25">selected="selected"</ww:if>>升舱换开成功</option>
						<option value="26"
							<ww:if test="orderinfo.orderstatus==26">selected="selected"</ww:if>>升舱换开失败</option>
					</select>
						</td>
						<td class="table_color_r colortrin">紧急状态</td>
						<td class="table_color_l">
						<select name="busystatus" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai') || checkright('dingdanzhuangtaixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else> style="width: 142px;">
					  <option value="1" <ww:if test="orderinfo.busystatus==1">selected="selected"</ww:if>>紧急</option>
					  <option value="2" <ww:if test="orderinfo.busystatus==2">selected="selected"</ww:if>>一般</option>
					  <option value="3" <ww:if test="orderinfo.busystatus==3">selected="selected"</ww:if>>待定</option>
					   </select>
						</td>
						<td class="table_color_r colortrin">机票类型</td>
						<td class="table_color_l">
						<ww:if test="checkright('suoyouxinxixiugai') || checkright('dingdanzhuangtaixiugai')">
						<ww:if test="checkright('dingdanzhuangtaixiugai') && orderinfo.orderstatus==10">
						 <ww:property value="getTickettypeByOrderId(orderinfo.id).typename" /> <input type="hidden" name="s_tickettypeid" value="<ww:property value="getTickettypeByOrderId(orderinfo.id).id" />" />
						</ww:if>
						<ww:else>
						  <select name="s_tickettypeid" style="width: 142px;">
						<option value="0"></option>
						<ww:iterator value="listtickettype">
							<option
								<ww:if test="id==getTickettypeByOrderId(orderinfo.id).id">selected="selected"</ww:if>
								value="<ww:property value="id"/>"><ww:property
								value="typename" /></option>
						</ww:iterator>
					    </select>
						</ww:else>
						
						</ww:if>
						<ww:else>
						 <ww:property value="getTickettypeByOrderId(orderinfo.id).typename" /> <input type="hidden" name="s_tickettypeid" value="<ww:property value="getTickettypeByOrderId(orderinfo.id).id" />" />
					    </ww:else>
						</td>
					</tr>
					<tr>
						<td class="table_color_r colortrin">支付方式</td>
						<td class="table_color_l">
						<select name="paymethod" style="width: 142px" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai') || checkright('dingdanzhuangtaixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>>
							<ww:iterator value="getPaymethodMap()" >
							<option value="<ww:property value="key"/>" <ww:if test="orderinfo.paymethod==key">selected="selected"</ww:if> ><ww:property value="value"/></option>
							</ww:iterator>
					</select>
						</td>
						<td class="table_color_r colortrin">支付状态</td>
						<td class="table_color_l">
						<select name="paystatus" style="width: 142px;" <ww:if test="checkright('suoyouxinxixiugai') || checkright('jibenxinxixiugai') || checkright('dingdanzhuangtaixiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>
						style="width: 142px;">
						<option
							<ww:if test="orderinfo.paystatus==null||orderinfo.paystatus==0">selected="selected"</ww:if>
							value="0">未支付</option>
						<option
							<ww:if test="orderinfo.paystatus==1">selected="selected"</ww:if>
							value="1">已支付</option>
					</select>
						</td>
						<td class="table_color_r colortrin">付款方式</td>
						<td class="table_color_l">
						 <select id="fkid" name="fkmethod" onchange="showgrgz()" style="width: 142px" <ww:if test="checkright('suoyouxinxixiugai') || checkright('dingdanzhuangtaixiugai') || checkright('dingdanjinexiugai')"><ww:if test="!checkright('suoyouxinxixiugai') && orderinfo.orderstatus==10">disabled="disabled"</ww:if></ww:if><ww:else>disabled="disabled"</ww:else>>
						<option value='1' <ww:if test="orderinfo.fkmethod==1">selected="selected"</ww:if> id='xj'>现金</option>
						<option value='2' <ww:if test="orderinfo.fkmethod==2">selected="selected"</ww:if> id='zp'>支票</option>
						<option value='3' <ww:if test="orderinfo.fkmethod==3">selected="selected"</ww:if> id='jh'>建行POS</option>
						<option value='4' <ww:if test="orderinfo.fkmethod==4">selected="selected"</ww:if> id='ylpos'>银联POS</option>
						<option value='5' <ww:if test="orderinfo.fkmethod==5">selected="selected"</ww:if> id='myp'>免优票</option>
						<option  value='6' <ww:if test="orderinfo.fkmethod==6">selected="selected"</ww:if> id='lcj'>里程券</option>
						<ww:if test="!isBiguserOrder(orderinfo)">
						<option value='7' <ww:if test="orderinfo.fkmethod==7">selected="selected"</ww:if> id='grgz'>个人挂账</option>
						</ww:if>
						<ww:if test="orderinfo.paymethod!=2&&orderinfo.paymethod!=3&&orderinfo.paymethod!=6">
						<option id='yjgz' <ww:if test="orderinfo.fkmethod==8">selected="selected"</ww:if>  value='8'>月结挂账</option>
						<option id='wszf' <ww:if test="orderinfo.fkmethod==9">selected="selected"</ww:if> value='9'>网上支付</option>
						<option id='yhhk'<ww:if test="orderinfo.fkmethod==10">selected="selected"</ww:if> value='10' >银行汇款</option>
						</ww:if>
						</select>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
	</table>
</ul>
</div>
</div>
</span><span class="flt_shadow_f"></span></div>
<!-- 订单状态修改结束 -->

<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">航程信息<span class="base_annotate"></span></h3>
	</li>
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table id="tbTravel" class="book_pgcontent" width="98%" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr class='GridViewHeaderStyle' align="center" valign="middle">
						<td widht="20px"></td>
						<td>航空公司</td>
						<td>航班号</td>
						<td>起飞城市</td>
						<td>到达城市</td>
						<td>起飞时间</td>
						<td>到达时间</td>
						<td>舱位</td>
						<td>折扣</td>
					</tr>
					<ww:iterator value="listSegment">
						<tr class='postbg1' align="center" valign="middle">
							<td widht="20px"></td>
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
						</tr>
					</ww:iterator>

					<tr height='1px'>
						<td colspan='9'><br />
						</td>
					</tr>
				</tbody>
			</table>
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
	<table class="book_pgcontent" width="100%">
		<tr>
			<td align="center">
			<table class="book_pgcontent" width="98%" border="0" cellpadding="0"
				cellspacing="0">
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
						<td>安检</td>
						<td>其它</td>
						<td>保险</td>
						<td>退票手续费</td>
						<td>退/废票/时间</td>
					</tr>
					<ww:if test="checkright('suoyouxinxixiugai') || checkright('dingdanjinexiugai')">
					<ww:if test="checkright('suoyouxinxixiugai')">
					<ww:set name="allinsurprice" value="0"/>
					<ww:iterator value="listPassenger">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="getPassTypeToString(ptype)" /></td>
							<td><input size="6" name="<ww:property value="id"/>name" value="<ww:property value="name" />"/></td>
							<td><ww:property value="getIDTypeToString(idtype)" /></td>
							<td><input type="hidden" name="u_id"
								value="<ww:property value="id"/>" /> <input type="text"
								name="u_idnumber"
								value="<ww:property
								value="idnumber"/>" /></td>
							<ww:if test="ticketnum!=null">
								<td><ww:property value="ticketnum" /></td>
							</ww:if>
							<ww:else>
								<td>暂无</td>
							</ww:else>
							<td><input size="6" name="<ww:property value="id"/>price" value="<ww:property value="price" />"/></td>
							<td><input size="6" name="<ww:property value="id"/>fuelprice" value="<ww:property value="fuelprice" />"/></td>
							<td><input size="6" name="<ww:property value="id"/>airportfee" value="<ww:property value="airportfee" />"/></td>
							<td><input size="6" name="<ww:property value="id"/>anjianfee" value="<ww:property value="anjianfee" />"/></td>
							<td><input size="6" name="<ww:property value="id"/>otherfee" value="<ww:property value="otherfee" />"/></td>
							<ww:set name="insurprice" value="getInsurancPrice(insurance)"/>
								<td><ww:property value="#insurprice" /></td>
								<ww:set name="allinsurprice" value="#allinsurprice+#insurprice"/>
							<td>
								<input size="6" name="<ww:property value="id"/>tuifee" value="<ww:property value="converNull(tuifee,0f)" />"/>
						     </td>
							<td><ww:if test="tuitime!=null">
								<ww:property value="formatTimestamp2(tuitime)" />
							</ww:if> <ww:else>
									暂无
								</ww:else></td>
						</tr>
					</ww:iterator>
					</ww:if>
					<ww:else>
		
					<ww:set name="allinsurprice" value="0"/>
					<ww:iterator value="listPassenger">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="getPassTypeToString(ptype)" /></td>
							<td><ww:property value="name" /></td>
							<td><ww:property value="getIDTypeToString(idtype)" /></td>
							<td><input type="hidden" name="u_id"
								value="<ww:property value="id"/>" /> <ww:property
								value="idnumber"/></td>
							<ww:if test="ticketnum!=null">
								<td><ww:property value="ticketnum" /></td>
							</ww:if>
							<ww:else>
								<td>暂无</td>
							</ww:else>
							<td><ww:property value="price" /></td>
							<td><ww:property value="fuelprice" /></td>
							<td><ww:property value="airportfee" /></td>
							<td><ww:property value="anjianfee" /></td>
							<td><ww:property value="otherfee" /></td>
							<ww:set name="insurprice" value="getInsurancPrice(insurance)"/>
								<td><ww:property value="#insurprice" /></td>
								<ww:set name="allinsurprice" value="#allinsurprice+#insurprice"/>
							<td>
								<ww:property value="converNull(tuifee,0f)" />
						     </td>
							<td><ww:if test="tuitime!=null">
								<ww:property value="formatTimestamp2(tuitime)" />
							</ww:if> <ww:else>
									暂无
								</ww:else></td>
						</tr>
					</ww:iterator>
					</ww:else>
					</ww:if>
					<ww:else>
		
					<ww:set name="allinsurprice" value="0"/>
					<ww:iterator value="listPassenger">
						<tr class='postbg1' align="center" valign="middle">
							<td><ww:property value="getPassTypeToString(ptype)" /></td>
							<td><ww:property value="name" /></td>
							<td><ww:property value="getIDTypeToString(idtype)" /></td>
							<td><input type="hidden" name="u_id"
								value="<ww:property value="id"/>" /> <ww:property
								value="idnumber"/></td>
							<ww:if test="ticketnum!=null">
								<td><ww:property value="ticketnum" /></td>
							</ww:if>
							<ww:else>
								<td>暂无</td>
							</ww:else>
							<td><ww:property value="price" /></td>
							<td><ww:property value="fuelprice" /></td>
							<td><ww:property value="airportfee" /></td>
							<td><ww:property value="anjianfee" /></td>
							<td><ww:property value="otherfee" /></td>
							<ww:set name="insurprice" value="getInsurancPrice(insurance)"/>
								<td><ww:property value="#insurprice" /></td>
								<ww:set name="allinsurprice" value="#allinsurprice+#insurprice"/>
							<td>
								<ww:property value="converNull(contuifee,0f)" />
						     </td>
							<td><ww:if test="tuitime!=null">
								<ww:property value="formatTimestamp2(tuitime)" />
							</ww:if> <ww:else>
									暂无
								</ww:else></td>
						</tr>
					</ww:iterator>
					</ww:else>
					<tr height='1px'>
						<td colspan='9'><br />
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>

	</table>
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
						<td >总票价</td>
						<td>总燃油费</td>
						<td>总机建费</td>
						<td>总安检费</td>
						<td>总其它费</td>
						<td>邮寄费</td>
						<td>总保险费</td>
						<td>应付款</td>

					</tr>
					<tr class='postbg1' align="center" valign="middle">
						<td><ww:property
							value="formatMoney(orderinfo.totalticketprice)" /></td>
						<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalairportfee)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalanjian)" /></td>
						<td><ww:property
							value="formatMoney(orderinfo.totalotherfee)" /></td>
						<td><ww:property value="formatMoney(orderinfo.postmoney)" /></td>
						<td><ww:property
							value="formatMoney(#allinsurprice)" /></td>
						<td><span style="color: red; font-weight: bold"><ww:property
							value="formatMoney(converNull(orderinfo.totalanjian,0)+converNull(orderinfo.totalotherfee,0)+converNull(orderinfo.postmoney,0)+orderinfo.totalticketprice+orderinfo.totalairportfee+orderinfo.totalfuelfee)" /></span></td>
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


<ww:if test="orderinfo.orderstatus!=3&&(orderinfo.receipt==4||orderinfo.receipt==5)">
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
					<td class="table_color_r colortrin" width="200px">联系人：</td>
					<td class="table_color_l" width="10%">
					<ww:if test="orderinfo.customeragentid==46">
					<ww:property value='converNull(orderinfo.postname,"无")'/>
					</ww:if>
					<ww:else>
				
					<ww:property value='converNull(orderinfo.contactname,"无")' />
					
					</ww:else></td>
					<td class="table_color_r colortrin" width="200px">联系电话：</td>
					<td class="table_color_l" width="10%">
					<ww:if test="orderinfo.customeragentid==46">
					 <ww:property value='converNull(orderinfo.postmobile,"无")'/>
					 </ww:if>
					 <ww:else>
					  <ww:property value='converNull(orderinfo.contactmobile,"无")'/>
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
					<tr>
					<td class="table_color_r colortrin" width="10%">配送方式：</td>
					<td colspan="5" align='left' class="table_color_l">
					<input type="radio" id="postmoney1" name="receipt" value="1" <ww:if test="orderinfo.receipt==1">checked='checked'</ww:if> />&nbsp;&nbsp;我不需要配送<br />
					<input type="radio" id="postmoney2" value="2" name="receipt" <ww:if test="orderinfo.receipt==2">checked='checked'</ww:if> />&nbsp;&nbsp;市内自取<br />
					<input id="postmoney3" type="radio" name="receipt" value="3" <ww:if test="orderinfo.receipt==3">checked='checked'</ww:if> />&nbsp;&nbsp;快递行程单发票(费用20元；航班起飞后快递，约3-5个工作日到)<br />
					<input id="postmoney4" type="radio" name="receipt" value="4"  <ww:if test="orderinfo.receipt==4">checked='checked'</ww:if> />&nbsp;&nbsp;市内配送<br />
					<input type="radio" id="postmoney0" name="receipt" value="5"  <ww:if test="orderinfo.receipt==5">checked='checked'</ww:if> />&nbsp;&nbsp;按大客户协议配送
					</td>
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
					<td class="table_color_l" width="140px"><input name="postname" value="<ww:property value="orderinfo.postname" />"/></td>
					<td class="table_color_r colortrin" width="200px">联系电话：</td>
					<td class="table_color_l"><input name="postmobile" value="<ww:property value="orderinfo.postmobile" />"/></td>
					<td class="table_color_r colortrin" width="200px">邮编：</td>
					<td class="table_color_l" width="80px">
					<input name="postcode" value="<ww:property value="orderinfo.postcode" />" />				
					</td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" width="10%">送票地址：</td>
						<td class="table_color_l" colspan="5">
						<textarea rows="3" cols="50" name="addresa"><ww:property value="orderinfo.addresa" /></textarea>
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
<table width="98%" border=0 cellspacing=0 cellpadding=0>
<tr>
						<td colspan='9' align='center'><input type="submit" name="btnEdit"
							id="btnEdit" value="修改订单" class="button_d font-white">&nbsp;&nbsp;&nbsp;<input
							type="button" name="btnCancel" id="btnCancel" value="返回"
							class="button_d font-white" onclick="window.history.back()"></td>
</tr>
</table>


</div>
<div id="customer"  style="text-align:center;display:none; background-color:#fff;left:0px;"></div>
<div id="editgzr"  style="text-align:center;display:none; background-color:#fff;left:0px;"></div>
</form>
</body>
</html>