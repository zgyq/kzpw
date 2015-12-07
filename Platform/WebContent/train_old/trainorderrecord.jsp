<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname} 火车票预定</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
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
	<ww:property value="agentroot"/>
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text); 
             Ext.get('companyname').set({value:node.text});
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

</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;火车订单列表</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="train!trainorder.action"><input type="hidden"
			name="is_first" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center" >

			<tr>
				<td valign="top">

				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table2">
					<tr>
					    <td align="right" width="85">加盟商：</td>
					    <td>
					    <div id='comboxWithTree'></div>
					    <input type='hidden' id="companyname" name="companyname" value='<ww:property value="companyname"/>' />
		                <input type="hidden" id="parentid" name="agentid" value='<ww:property value="agentid"/>'
						 style="width: 350px" />
					    </td>
						<td  align="right" width="85">订单号：</td>
						<td><label> <input type="text"
							class="input_dd" style="width: 120px;" name="ordernumber"
							value="<ww:property value="train.ordernumber"/>" /> </label></td>
						<td class="tex" align="right" width="85">预定时间：</td>
						<td class="texb texr"><input id="cptime" style="WIDTH: 85px"
							name="startcreatetime" value="<ww:property value="startcreatetime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" />- <input id="cpendtime" style="WIDTH: 85px"
							name="endcreatetime" value="<ww:property value="endcreatetime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" /></td>
					<!--  <td class="tex" align="right" width="85">状态：</td>
						<td class="texb texr" colspan="3"><select name="rechstate"
							style="width: 125px">
							<option value='-1'></option>
							<ww:iterator value="mobilerecharge.mobileStateMap">
								<option <ww:if test="rechstate==key">selected="selected"</ww:if>
									value='<ww:property value="key"/>'><ww:property
									value="value" /></option>
							</ww:iterator>
						</select></td>-->
					</tr>
					<tr class="font-blue-xi">
					<td height="58" colspan="10" align="center">
					<input name="" type="submit"
					class="button_d font-white" value="查询订单" align="absmiddle" />
					</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_color">
					<tr  class="tbody_color">
						<th class="table_color">订单号</th>
						<th class="table_color">采购商</th>
						<th class="table_color">车次</th>
						<th class="table_color">出发站</th>
						<th class="table_color">到达站</th>
						<th class="table_color">出发日期</th>						
						<th class="table_color">出发时间</th>
						<th class="table_color">订单金额</th>
						<th class="table_color">预定日期</th>
						<th class="table_color">配送类型</th>
						<th class="table_color">支付状态</th>
						<th class="table_color">订单状态</th>
						<th class="table_color" style="width: 100px">操作</th>
					</tr>
					<ww:iterator value="trainlist" status="t">
						<tr>
							<td class="table_color">
						   <a href='train!orderdetail.action?id=<ww:property value="id"/>'>
							<ww:property value="ordernumber" />
							</a>
							</td>
							<td class="table_color"><ww:property value="agentname" /></td>
							<td class="table_color"><ww:property value="traincode" /></td>
							<td class="table_color"><ww:property value="startcity" /></td>
							<td class="table_color"><ww:property value="endcity" /></td>
							<td class="table_color"><ww:property value="startdate" /></td>
							<td class="table_color"><ww:property value="starttime" /></td>
							<td class="table_color"><ww:property value="totalprice" /></td>
							<td class="table_color"><ww:property value="formatTimestamp(createtime)" /></td>
							<td class="table_color"><ww:property value="deliverytypeval" /></td>
							<td class="table_color"><ww:property value="paystatusval" /></td>
							<td class="table_color"><ww:property value="orderstatusval" /></td>
							<td class="table_color">
							<ww:if test="paystatus==1&&orderstatus<3">
							<input type="button" class="button108" onclick=processOrder(<ww:property value="id"/>,3) value="取消" /><br/>
							<ww:if test="agentid!=46">
							<a target="_blank" href='train!toPay.action?id=<ww:property value="id"/>'><img src="images/nowpay.jpg"/></a><br/>
							</ww:if>
							</ww:if>
							<ww:if test="orderstatus==2||(agentid==46&&memberid!=1&&orderstatus<3)">
							<input type="button" class="button108" onclick='processOrder(<ww:property value="id"/>,4)' value="确认订单" /><br/>
							</ww:if>
							<ww:if test="orderstatus==4">
							<input type="button" class="button108" onclick='processOrder(<ww:property value="id"/>,5)' value="立即出票" /><br?
							</ww:if>
							</td>
							
							
						</tr>
					</ww:iterator>
				</table>
				</td>
			</tr>

		</table>
		<div style="text-align: center; width: 100%; padding-top: 10px;">
		<ww:property
			value='getPagetwo(pageinfo,"pageinfo","ofcard!toRechargeOrder.action","form1")' />
		</div>
		</form>


		</td>
	</tr>
</table>
</body>
</html>


<script language="JavaScript">
function processOrder(id,status){
var message="确定执行当前操作了";
Ext.MessageBox.confirm("提示",message,function(obj){
if(obj=='yes'){
window.location.href="train!processOrder.action?id="+id+"&orderstatus="+status;
}
});



}
</script>






