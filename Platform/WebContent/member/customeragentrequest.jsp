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
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script>
Ext.onReady(function(){

	 var selectId ="";

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
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;加盟商信息表列表</span></b></td>
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
         <!-- <table width="760" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size:12px;">

  <tr>
    <td width="184" height="30" align="right">单位名称：</td>
    <td width="198"><span style="HEIGHT: 71px"> <input id="startnum2"   style="WIDTH: 160px" name="s_name" value="<ww:property value="s_name"/>"/></span></td>
    <td width="129" height="40" align="right">单位简称：</td>
    <td width="181"><span style="HEIGHT: 71px"><input id="startnum2"   style="WIDTH: 160px"  name="s_name2" value="<ww:property value="s_name2"/>"/></span></td><!--
    <td width="134" rowspan="2" align="center"><input type="button" style="background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
  </tr>
  <tr class="font-blue-xi">
    <td height="28" align="right"><span class="STYLE2">加盟商类型：</span></td>
    <td><select name="caid1" style="WIDTH: 166px" >
    <option value="-1" <ww:if test="caid1==-1">selected</ww:if> >请选择！</option>
    <option value="2" <ww:if test="caid1==2">selected</ww:if> >供应商</option> 
    <option value="3" <ww:if test="caid1==3">selected</ww:if> >分销商</option>
	<option value="1" <ww:if test="caid1==1">selected</ww:if> >运营商</option>
</select></td>
    <td height="28" align="right"><span class="STYLE2">是否启用：</span></td>
    <td width="181"><select name="caid2" style="WIDTH: 166px" >
    <option value="-1" <ww:if test="caid2==-1">selected</ww:if> >请选择！</option>
    <option value="1" <ww:if test="caid2==1">selected</ww:if> >启用</option>
    <option value="0" <ww:if test="caid2==0">selected</ww:if> >禁用</option>
    </select></td>
  </tr>
  <tr class="font-blue-xi">
    <td height="10" colspan="5" align="right"></td>
    </tr>
  <tr class="font-blue-xi">
    <td height="28" colspan="5" align="center"><input type="submit" class="button_d font-white"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
    </tr>
</table>-->
      </td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right">
										<!--  <a href="#" onclick="toadd()">
											<input type="button" value="新增" class="button_h font-red" />
										</a>-->
									<!-- 	&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<!--<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red" /></a>
											-->
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
										<tr class="tbody_color">
											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
										
											<th class="table_color">加盟商类型</th>
											<th class="table_color">单位名称</th>
										
											<th class="table_color">单位电话</th>
											
										    <th class="table_color">联系人姓名</th>
											<th class="table_color">联系人电话</th>			
											
											<th class="table_color">申请时间</th>
											<th class="table_color">操作</th>
											
										</tr>

										<ww:iterator value="listCustomeragent">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color">
													<input type="checkbox" name="selectid" value="<ww:property value="id"/>" />
												</td>
												
												<td class="table_color">
													<ww:if test="agenttype==2">供应商</ww:if> 
													<ww:if test="agenttype==3">分销商</ww:if>
												</td>
												<td class="table_color"><ww:property value="agentcompanyname" /></td>
										
												<td class="table_color"><ww:property value="agenttel" /></td>
												
												<td class="table_color"><ww:property value="agentcontactname" /></td>
										
												<td class="table_color"><ww:property value="agentphone" /></td>
												
												<td class="table_color"><ww:property value="formatTimestamptoMinute(createtime)" /></td>
												<td class="table_color"><a href="customeragent!toeditgent.action?id=<ww:property value="id"/>"/>转入加盟商审核</a></td>
												
											
												<!--
												<td class="table_color"><ww:property
													value="formatTimestamp(modifytime)" /></td>
												<td class="table_color"><ww:property value="modifyuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color"><ww:property value="createuser" /></td>
												-->
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