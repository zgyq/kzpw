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
<title>加盟商信息表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
	<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script>
Ext.onReady(function(){

	 var selectId ="";
	 //加盟商类型
     var vartype="";
     //是否是分公司，只有分公司才能下级开户
     var isfencom="";
	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		   {  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="customeragent!toeditgent.action?id="+selectId;
						document.form1.submit();
				}
            }
            ,
             {  
				id:"erjikaihu",
				text:"下级开户",
				icon:"images/menu/check.gif",
				handler : function(item){
				        if(isfencom=="0")
			            {
			               alert("此加盟商不是分公司，不能够下级开户!");
			               return;
			            }
						else if(isfencom=="1")
						{
						  document.form1.action="customeragent!toadd.action?compnayid="+selectId+"&ischildcompany=1";
						  document.form1.submit();
						}
						
				}
            }
            ,
             {  
				id:"viewjikaihu",
				text:"查看下级加盟商信息",
				icon:"images/menu/check.gif",
				handler : function(item){
				        if(isfencom=="0")
			            {
			               alert("此加盟商不是分公司，没有下级加盟商信息!");
			               return;
			            }
						else if(isfencom=="1")
						{
						  document.form1.action="customeragent.action?parentagentid="+selectId;
						  document.form1.submit();
						}
						
				}
            }
            ,
             {  
				id:"viewemployee",
				text:"查看员工信息",
				icon:"images/menu/check.gif",
				handler : function(item){
				        if(vartype=="3")
				        {
						   document.form1.action="customeruser!toDistrUsersList.action?compnayid="+selectId;
						   document.form1.submit();
						}
						else if(vartype=="2")
						{
						  document.form1.action="customeruser!toSupplyUsersList.action?compnayid="+selectId;
						  document.form1.submit();
						  
						}
						
				}
            },
            
             {  
				id:"viewliudian",
				text:"查看留点设置",
				icon:"images/menu/check.gif",
				handler : function(item){
					document.form1.action="liudianinfo!toadd.action?lagentid="+selectId;
					document.form1.submit();
				}
            },
		
			'-',
			<ww:if test="parentagentid>0">
			{
                id:"check",
				text:"审核",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customeragent!tocheck.action?id="+selectId+"&type=1";
						document.form1.submit();
					
				}
            }
			</ww:if><ww:else>
			{
                id:"check",
				text:"审核",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customeragent!tocheck.action?id="+selectId;
						document.form1.submit();
					
				}
            }
			</ww:else>
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			var arrids=selectId.split('_');
			selectId=arrids[0];
			vartype=arrids[1];
			isfencom=arrids[2];
			menu.showAt(e.getPoint());
		}
	});

});
//绑定隐藏域中的值，实现点击员工信息时跳转不同的url,因为之前分销商和供应商的页面不同
function bindhidval()
{
   if($("#ddlcompanytype").val()=="3")
   {
      $("#hidurl").val("customeruser!toDistrUsersList.action?compnayid=");
   }
   else
   {
      $("#hidurl").val("customeruser!toSupplyUsersList.action?compnayid=");
   }
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="parentagentid>0"><span style="color:red"><ww:property value="getagentname(parentagentid)"/></span>二级加盟商列表</ww:if><ww:else>加盟商信息表列表</ww:else></span></b>
			<input type="hidden" id="hidurl" value="customeruser!toDistrUsersList.action?compnayid=" />
			</td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="customeragent.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>
								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">

									<tr>
										<td width="184" height="30" align="right">单位名称：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_name"
											value="<ww:property value="s_name"/>" /></span></td>
										<td width="129" height="40" align="right">单位简称：</td>
										<td width="181"><span style="HEIGHT: 71px"><input
											id="startnum2" style="WIDTH: 160px" name="s_name2"
											value="<ww:property value="s_name2"/>" /></span></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" align="right"><span class="STYLE2">加盟商类型：</span></td>
										<td><select name="caid1" id="ddlcompanytype" style="WIDTH: 166px">
										    <option value="-1" <ww:if test="caid1==-1">selected</ww:if>>----所有类型----</option>
											<option value="3" <ww:if test="caid1==3">selected</ww:if>>分销商</option>
											<option value="2" <ww:if test="caid1==2">selected</ww:if>>供应商</option>

										</select></td>
										<td height="28" align="right"><span class="STYLE2">是否启用：</span></td>
										<td width="181"><select name="caid2" style="WIDTH: 166px">
											<option value="-1" <ww:if test="caid2==-1">selected</ww:if>>----请选择----</option>
											<option value="1" <ww:if test="caid2==1">selected</ww:if>>启用</option>
											<option value="0" <ww:if test="caid2==0">selected</ww:if>>禁用</option>
										</select></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="10" colspan="5" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" colspan="5" align="center"><input
											type="submit" class="button_d font-white"
											value="查&nbsp;&nbsp;询"  /></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right"><!--  <a href="#" onclick="toadd()">
											<input type="button" value="新增" class="button_h font-red" />
										</a>--> &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<!--<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;--><a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red" /></a>
											&nbsp;&nbsp;&nbsp;<a href="#" onclick="openchildaccount()"><input
											type="button" value="下级开户" class="button_h font-red" /></a>
											
											&nbsp;&nbsp;&nbsp;<a href="#" onclick="viewchildaccount()"><input
											type="button" value="查看下级" class="button_h font-red" /></a>
											<ww:if test="listCustomeragent.size()>0">
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="viewemployeeItem()"><input
											type="button" value="员工信息" class="button_h font-red" /></a>
											</ww:if>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="viewliudian()"><input
											type="button" value="留点设置" class="button_h font-red" /></a>	
										</div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color" >
											<th class="table_color" width="54" height="25" style="font-weight:bold"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
											<th class="table_color" style="font-weight:bold">序号</th>
											<th class="table_color" style="font-weight:bold">代码</th>
											<th class="table_color" style="font-weight:bold">加盟商类型</th>
											<th class="table_color" style="font-weight:bold">加盟商名称</th>
											<th class="table_color" style="font-weight:bold">加盟商简称</th>
											<ww:if test="parentagentid>0">
											<th class="table_color" style="font-weight:bold">所属上级加盟商</th>
											</ww:if>
											

											<!--<th class="table_color">邮政编码</th>
											-->
											<th class="table_color" style="font-weight:bold">联系人姓名</th>
											<th class="table_color" style="font-weight:bold">联系人电话</th>
											<th class="table_color" style="font-weight:bold">默认机场三字码</th>
											<!--<th class="table_color">有效期开始时间</th>
											<th class="table_color">有效期结束时间</th>
											-->
											<!--<th class="table_color">父级序号</th>
											-->

											<th class="table_color" style="font-weight:bold">是否启用</th>
											<th class="table_color" style="font-weight:bold">是否是分公司</th>
											<th class="table_color" style="font-weight:bold">审核状态</th>
											<!--
											<th class="table_color">修改时间</th>
											<th class="table_color">修改者</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">创建者</th>
											-->
										</tr>

										<ww:iterator value="listCustomeragent">
											<tr id="<ww:property value="id"/>_<ww:property value="agenttype"/>_<ww:property value="ischildcom"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" />
													<input type="hidden" name="txtisfencompany" value="<ww:property value="ischildcom"/>" />
													<input type="hidden" id="hidagetype_<ww:property value="id"/>" value="<ww:property value="agenttype"/>" />
													</td>
												<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color"><ww:property value="code" /></td>
												<td class="table_color"><ww:if test="agenttype==1">运营商</ww:if>
												<ww:if test="agenttype==2"><img src="images/gongying.gif" width="23" height="23px" alt="供应商" />供应商</ww:if> <ww:if
													test="agenttype==3"><img src="images/fenxiao.gif" width="23" height="23px"  alt="分销商" />分销商</ww:if></td>
												<td class="table_color"><ww:property
													value="agentcompanyname" /></td>
												<td class="table_color"><ww:property
													value="agentshortname" /></td>

												<ww:if test="parentagentid>0">
											     <td class="table_color"><span style="color:red"><ww:property value="getagentname(parentagentid)"/></span></td>
											     </ww:if>

												<!--<td class="table_color"><ww:property
													value="agentpostcode" /></td>
												-->
												<td class="table_color"><ww:property
													value="agentcontactname" /></td>
													<td class="table_color"><ww:property value="agentphone" /></td>
												<td class="table_color"><ww:property value="airportcode" /></td>
												<!--<td class="table_color"><ww:property
													value="formatTimestamp(agentvsdate)" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(agentvedate)" /></td>
												-->
												<!--<td class="table_color"><ww:property value="parentid" /></td>
												-->
												<td class="table_color"><ww:if test="agentisenable==0">禁用</ww:if>
												<ww:elseif test="agentisenable==1">启用</ww:elseif></td>
												<td class="table_color">
													<ww:if test="ischildcom==0">否</ww:if>
													<ww:elseif test="ischildcom==1">是</ww:elseif>
												</td>
												<td class="table_color"><ww:if
													test="agentcheckstatus==0"><img src="images/on.gif" />未审核</ww:if> <ww:elseif
													test="agentcheckstatus==1"><img src="images/ok.gif" />审核通过</ww:elseif> <ww:elseif
													test="agentcheckstatus==2"><img src="images/on.gif" />拒绝审核</ww:elseif></td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property
									value="pagination" /></td>
							</tr>
							<tr><td>
								<div><strong><span class="font-red">注意事项:</span></strong>
								<br />
								<ul style="padding-left: 30px;">
									<li>默认加盟商类型为分销商。如果查看供应商，请更改查询条件中的加盟商类型进行查看。</li>
									<li>点击员工信息，即可<span style="color:red;font-weight:bold">查看/添加/修改</span>此分销商或供应商的员工信息</li>
									<li>右击待操作的分销商或者加盟商，即可进行快捷操作。</li>
								</ul>
								</div>
								</td></tr>
						
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			
		</table>
		</form>
		</td>
	</tr>
</table>

</div>
</body>
</html>
<script language="JavaScript">
	function toadd(){
		window.location="customeragent!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined) {
			if(document.form1.selectid.checked ==true)
			{
				var temp = confirm('确认删除吗？');
				if(temp==true){
					document.form1.action="customeragent!delete.action?id="+document.form1.selectid.value;
					document.form1.submit();
				}
				return;
			}
		}
		if ( length == null || length==0 ){
			alert("你未选择任何内容");
			return;
		}else{
			var len=0;
			var uvalue=0;
			for (var i = 0; i < length; i++) {
				if( document.form1.selectid[i].checked ==true) {
				uvalue=document.form1.selectid[i].value;
				len++;					         
			}
		}
		if(len==1){
			var temp = confirm('确认删除吗？');
			if(temp==true){
				document.form1.action="customeragent!delete.action?id="+uvalue;
				document.form1.submit();
			}
			return;
		}else if (len>1){
			var temp = confirm('确认删除吗？');
			if(temp==true){
				document.form1.action="customeragent!batch.action?opt=1";
				document.form1.submit();
			}
			return;
		      
	      }
				      
		}	
		alert("无效操作,你未选择任何内容!");
		return;
  	}
	function updateItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{
				document.form1.action="customeragent!toeditgent.action?id="+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
	  	if ( length == null || length==0 ){
	  	  	 alert("你未选择任何内容");
	         return;
	    }else{
		   	 var len=0;
		   	 var uvalue=0;
		     for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
		         }
	      	 }
		     if(len==1){
		     	document.form1.action="customeragent!toeditgent.action?id="+uvalue;
				document.form1.submit();
				return;
		      }else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
				      
			  }
				      
		}	
		alert("无效操作,你未选择任何内容!");
		return;
  	}
	
	function checkItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
				document.form1.action="customeragent!tocheck.action?id="+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
		if ( length == null || length==0 ){
  	  		alert("你未选择任何内容");
          	return;
		}else{
	   		var len=0;
	   		var uvalue=0;
	    	for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
		         }
			}
			if(len==1){
	      		document.form1.action="customeragent!tocheck.action?id="+uvalue;
				document.form1.submit();
				return;
			}else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
	      
	      	}
		}	
		alert("无效操作,你未选择任何内容!");
		return;
	}
	
	//查看员工信息
	function viewemployeeItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
				document.form1.action=$("#hidurl").val()+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
		if ( length == null || length==0 ){
  	  		alert("你未选择任何内容");
          	return;
		}else{
	   		var len=0;
	   		var uvalue=0;
	    	for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
		         }
			}
			if(len==1){
			    if($("#hidagetype_"+uvalue).val()=="3")
			    {
			       document.form1.action="customeruser!toDistrUsersList.action?compnayid="+uvalue;
			       document.form1.submit();
			    }
			    else if($("#hidagetype_"+uvalue).val()=="2")
			    {
			       document.form1.action="customeruser!toSupplyUsersList.action?compnayid="+uvalue;
			       document.form1.submit();
			    }
			    
				return;
			}else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
	      
	      	}
		}	
		alert("无效操作,你未选择任何内容!");
		return;
	}
	
	//分公司下级开户操作
	function openchildaccount(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
			    if(document.form1.txtisfencompany.value=="0")
			    {
				   alert("此加盟商不能够进行下级开户操作!");
				}
				else if(document.form1.txtisfencompany.value=="1")
				{
				    document.form1.action="customeragent!toadd.action?compnayid="+document.form1.selectid.value+"&ischildcompany=1";
				    document.form1.submit();
				}
				
				return;
			}
		}
		if ( length == null || length==0 ){
  	  		alert("你未选择任何内容");
          	return;
		}else{
	   		var len=0;
	   		var uvalue=0;
	   		var utype=0;
	    	for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					utype=document.form1.txtisfencompany[i].value
					len++;					         
		         }
			}
			if(len==1){
			    if(utype=="0")
			    {
				   alert("此加盟商不能进行下级开户操作！");
				}
				else if(utype=="1")
				{
				     document.form1.action="customeragent!toadd.action?compnayid="+uvalue+"&ischildcompany=1";
				     document.form1.submit();
				}
				
				return;
			}else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
	      
	      	}
		}	
		alert("无效操作,你未选择任何内容!");
		return;
	}
	
	//查看留点设置
	function viewliudian(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
			    document.form1.action="liudianinfo!toadd.action?lagentid="+document.form1.selectid.value;
			    document.form1.submit();
				
				return;
			}
		}
		if ( length == null || length==0 ){
  	  		alert("你未选择任何内容");
          	return;
		}else{
	   		var len=0;
	   		var uvalue=0;
	   		var utype=0;
	    	for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					utype=document.form1.txtisfencompany[i].value
					len++;					         
		         }
			}
			if(len==1){
			     document.form1.action="liudianinfo!toadd.action?lagentid="+uvalue;
			     document.form1.submit();
				return;
			}else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
	      
	      	}
		}	
		alert("无效操作,你未选择任何内容!");
		return;
	}
	//查看下级加盟商信息
	function viewchildaccount(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
			    if(document.form1.txtisfencompany.value=="0")
			    {
				   alert("此加盟商没有下级加盟商信息!");
				}
				else if(document.form1.txtisfencompany.value=="1")
				{
				    document.form1.action="customeragent.action?parentagentid="+document.form1.selectid.value;
				    document.form1.submit();
				}
				
				return;
			}
		}
		if ( length == null || length==0 ){
  	  		alert("你未选择任何内容");
          	return;
		}else{
	   		var len=0;
	   		var uvalue=0;
	   		var utype=0;
	    	for (var i = 0; i < length; i++) {
		         if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					utype=document.form1.txtisfencompany[i].value
					len++;					         
		         }
			}
			if(len==1){
			    if(utype=="0")
			    {
				   alert("此加盟商没有下级加盟商信息！");
				}
				else if(utype=="1")
				{
				     document.form1.action="customeragent.action?parentagentid="+uvalue;
				     document.form1.submit();
				}
				
				return;
			}else if (len>1){
		      	var temp = confirm('只能选择一项进行操作？');
				return;
	      
	      	}
		}	
		alert("无效操作,你未选择任何内容!");
		return;
	}
 
	function unselectall() {
	    if(document.form1.all.checked){
		document.form1.all.checked = document.form1.all.checked&0;
	    }
	}
	function selectall1() {
	   var length=document.form1.selectid.length;
	   document.form1.all1.checked = document.form1.all1.checked|0;
	   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
	    }
	    if (length>1) {
	      for (var i = 0; i < length; i++)
	       {
	          document.form1.selectid[i].checked = document.form1.all1.checked;
		      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
	       }
	    }
	}
</script>