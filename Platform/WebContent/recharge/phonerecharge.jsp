<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

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
	<ww:property value="#request.agentroot"/>
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

<script>

function refreshRechstate(onumber){

   $.ajax({
      url:"ofcard!ajaxGetPhoneRechState.action",
      type:"POST",
      data:{orderid:onumber},
      beforeSend:function(){$("#state"+onumber).html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
      $("#state"+onumber).html(data);
    }    
    });

}


function ajaxnextphoneRecharge(id,onumber){
   
   $.ajax({
      url:"ofcard!ajaxnextphoneRecharge.action",
      type:"POST",
      data:{rechid:id,para:Math.floor(Math.random()*100)},
      beforeSend:function(){
      $("#nextrech"+id).html("&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");
       document.getElementById("nextrechbtn"+id).disabled = true;
      },             
      success:function(data){
        alert(data);
       // $("#nextrech"+id).html("&nbsp;&nbsp;&nbsp;");
      // $("#state"+onumber).html(data);
      // $("#nextrechbtn"+id).disable=false;
      //window.location.href="ofcard!toQmoneyRechargeOrder.action";
      window.location.href="ofcard!toRechargeOrder.action";
      //
    }    
    });



}

</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;手机充值订单列表</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="ofcard!toRechargeOrder.action"><input type="hidden"
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
					   
						
						<td  align="right" width="85">充值号码：</td>
						<td><label> <input type="text"
							class="input_dd" style="width: 120px;" name="rechnumber"
							value="<ww:property value="rechnumber"/>" /> </label></td>
						<td class="tex" align="right" width="85">充值时间：</td>
						<td class="texb texr"><input id="cptime" style="WIDTH: 85px"
							name="rechstime" value="<ww:property value="rechstime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" />- <input id="cpendtime" style="WIDTH: 85px"
							name="rechetime" value="<ww:property value="rechetime"/>"
							onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							class="Wdate" /></td>
					<td class="tex" align="right" width="85">状态：</td>
						<td class="texb texr" colspan="3"><select name="rechstate"
							style="width: 125px">
							<option value='-1'></option>
							<ww:iterator value="mobilerecharge.mobileStateMap">
								<option <ww:if test="rechstate==key">selected="selected"</ww:if>
									value='<ww:property value="key"/>'><ww:property
									value="value" /></option>
							</ww:iterator>
						</select></td>
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
						<th class="table_color">代理商</th>
						<th class="table_color">充值号码</th>
						<th class="table_color">充值金额(元)</th>
						<th class="table_color">支付金额(元)</th>
						<th class="table_color">支付方式</th>
						<th class="table_color">操作人</th>						
						<th class="table_color">充值时间</th>
						<th class="table_color">充值状态</th>
						<th class="table_color">支付状态</th>
						<th class="table_color" style="width: 100px">操作</th>
					</tr>
					<ww:iterator value="#request.rechargelist" status="t">
						<tr>
							<td class="table_color" style="word-break:normal;">
							<div style="position: relative;">
							<ww:property value="ordernumber"  />
							<ww:if test="getLoginsessionagent().agenttype==1">
							</br>
							采:<a href="javascript:void(0);" onclick="shows(<ww:property value='id' />,<ww:property value='rechagentid' />);">
							<ww:property value="getangname(rechagentid)" /></a>
							</br>
							出:<ww:if test="rechtouid!=null&&rechtouid!=0&&rechtouid!=-1">
							<font color='red'><b><ww:property value='getemployeenamebyid(rechtouid)' /></b></font>
							</ww:if><ww:else>暂无处理人</ww:else>
							</ww:if>
							<div style="display: none; position: absolute; width: 200px; left: -10px; background: #fefefe; padding-left: 20px; border: 2px solid #f48000; z-index: 999999"
													id="detail<ww:property value="id"/>"></div>
							
							</div>
							
							</td>
							<td class="table_color"><ww:property value="getangname(rechagentid)" /></td>
							<td class="table_color"><ww:property value="phonenumber" /></td>
							<td class="table_color"><ww:property value="rechmoney" /></td>
							<td class="table_color"><ww:property value="inprice" /></td>
							
							<td class="table_color"><ww:property value="paymethodtype" /></td>
							<td class="table_color"><ww:property value="rechuname" /></td>
							<td class="table_color"><ww:property
								value="formatTimestamp(rechtime)" /></td>
							<td class="table_color"><span
								id='state<ww:property value="id"/>'>
								<!--<ww:property value="statestr" />-->
								<ww:property value="GetRechangOrderStauts(rechstate)"/>
								</span>
								<ww:if test="getLoginsessionagent().agenttype==1">
								<select name="s_state" onchange="UpdateState('mobile','<ww:property value="ordernumber"/>',this.value);">
								<option value="11" <ww:if test="state==11">selected</ww:if> >等待支付</option>
								<option value="0" <ww:if test="state==0">selected</ww:if> >充值中</option>
								<option value="1" <ww:if test="state==1">selected</ww:if> >充值成功</option>
								<option value="9" <ww:if test="state==9">selected</ww:if> >充值失败</option>
								<option value="99" <ww:if test="rechstate==99">selected</ww:if> >交易关闭</option>
								</select>
								</ww:if></br>   <span style="color: red;" id="paynum_<ww:property value="id"/>">
							     <ww:property value="getPayOrderNum(ordernumber)"/>
							     </span>
								</td>
							
							  <td class="table_color">
							    <ww:if test="paystate==-1">未支付</ww:if>
							    <ww:if test="paystate==1">
							    <span style="color: red">已支付</span>
							 
							    </ww:if>
							   </td>
		   
							<td class="table_color" >
				           	<span id='nextrech<ww:property value="id"/>'>&nbsp;&nbsp;&nbsp;&nbsp;</span>
				           	<ww:if test="getLoginsessionagent().agenttype==1">
					           	<ww:if test="paystate==1&&state!=1&&state!=0">
							    <input type="button" onclick="ajaxnextphoneRecharge(<ww:property value="id"/>,'<ww:property value="ordernumber"/>')" class="button108" id='nextrechbtn<ww:property value="id"/>' type="button" value="充值"/>
							    </ww:if>
						    </ww:if>
					    	<ww:if test="paystate==-1">
						    <input class="button108" type="button" onclick="window.location.href='ofcard!nextPhoneRechargePay.action?rechid=<ww:property value="id"/>'"  id='nextpaybtn<ww:property value="id"/>' type="button" value="立即支付"/>
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
			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}
function chongzhi(id){

   $.ajax({
      url:"ofcard!ajaxnextphoneRecharge.action",
      type:"POST",
      data:{rechid:id},
      beforeSend:function(){
      $("#nextrech"+id).html("&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");
       $("#nextrechbtn"+id).disable=true;
      },             
      success:function(data){
        alert(data);
        $("#nextrech"+id).html("&nbsp;&nbsp;&nbsp;");
       $("#state"+onumber).html(data);
       $("#nextrechbtn"+id).disable=false;
    }    
    });
}

function UpdateState(type,id,state){
//alert(id+","+state);
window.location.href="ofcard!UpdateOrderState.action?s_ordernumber="+id+"&ordertype="+type+"&orderstate="+state;
}


 function shows(id,agentid){
		 
		$("#detail"+id).show();
		
		$.ajax({
			type:'post',
			url:'customeragent!ajaxtoCustomeragent.action?customeragent.id='+agentid,
			async:false,
			success:function(data){
				var json = eval("("+data+")");
				data=json;
				//alert(data);
				//alert(data.agentphone);
				//data.agenttype=3;
				if(data == null){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，无详细信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					
				}else{
				if(data.agenttype == 3){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td colspan='2' style='color:#f48000;'>"+data.agentphone+"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq + ":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
				}else{
					if(data.agenttype == 2){  
					$("#detail"+id).html("<table style=' text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.agentphone+
						"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>出票人电话:</td><td>"+data.outticketmantel+
						"</td></tr><tr><td style='color:#000;'>出票人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.outticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.outticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>退票人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.backticketmantel+"</td></tr><tr><td style='color:#000;'>退票人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.backticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.backticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
					}
					if(data.agenttype == 1){
						$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，不能查看运营商的信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					}
				}
				}
			} 
		});
		
	}
function hides(id){
		$("#detail"+id).hide();
	}
	
</script>






