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
				id:"add",
				text:"新增",
				icon:"images/menu/new.gif",
				handler : function(item){
						document.form1.action="customeragent!toaddbiguser.action?id="+selectId;
						document.form1.submit();
				}
            },
            {  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="customeragent!toeditbig.action?id="+selectId;
						document.form1.submit();
				}
            },
            {  
				id:"she",
				text:"设置信用额",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="customeragent!toshezhi.action?id="+selectId;
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
function doCustCheck(cid,status) {
	window.location.href="customeragent!checkbig.action?id=" + cid + "&agentcheckstatus=" + status;
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;加盟商列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="customeragent!tobiguser.action">

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
         <table width="760" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size:12px;">

  <tr>
    <td width="184" height="30" align="right">加盟商名称：</td>
    <td width="198"><span style="HEIGHT: 71px"> <input id="startnum2"   style="WIDTH: 160px" name="s_name" value="<ww:property value="s_name"/>"/></span></td>
    <td width="129" height="40" align="right">加盟商简称：</td>
    <td width="181"><span style="HEIGHT: 71px"><input id="startnum2"   style="WIDTH: 160px"  name="s_name2" value="<ww:property value="s_name2"/>"/></span></td><!--
    <td width="134" rowspan="2" align="center"><input type="button" style="background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
  --></tr>
  
  <tr class="font-blue-xi">
    <td height="10" colspan="5" align="right"></td>
    </tr>
  <tr class="font-blue-xi">
    <td height="28" colspan="5" align="center"><input type="submit" class="button_d font-white"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
    </tr>
</table>
      </td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right">
										 <a href="#" onclick="toadd()">
											<input type="button" value="新增" class="button_h font-red" />
										</a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="shezhi()"><input
											type="button" value="设置信用额" class="button_h font-red" /></a>
									
										
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
											
											<th class="table_color">代码</th>
											<!-- <th class="table_color">加盟商类型</th>-->
											<th class="table_color">加盟商名称</th>										
											<th class="table_color">类型</th>										
											<th class="table_color">加盟商电话</th>
											
											<!--<th class="table_color">邮政编码</th>
											--><th class="table_color">联系人姓名</th>
											<th class="table_color">联系人电话</th>
											<!--<th class="table_color">有效期开始时间</th>
											<th class="table_color">有效期结束时间</th>
											--><!--<th class="table_color">父级序号</th>
											-->
										<th class="table_color">信用额度</th>
										<th class="table_color">已用额度</th>
										<th class="table_color">经纪人</th>
											<th class="table_color">是否启用</th>
											<th class="table_color">审核状态</th>
											<th class="table_color">操作</th>
											<!--
											<th class="table_color">修改时间</th>
											<th class="table_color">修改者</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">创建者</th>
											-->
										</tr>

										<ww:iterator value="listCustomeragent">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color">
													<input type="checkbox" name="selectid" value="<ww:property value="id"/>" />
												</td>
												
												<td class="table_color"><ww:property value="code" /></td>
												<!--<td class="table_color">大客户</td>-->
												<td class="table_color"><ww:property
													value="agentcompanyname" /></td>
												<td class="table_color"><ww:property
													value='agentcityid==0?"":agentcityid==1?"A类":agentcityid==2?"B类":"C类"' /></td>
										
												<td class="table_color"><ww:property value="agenttel" /></td>
												
												<!--<td class="table_color"><ww:property
													value="agentpostcode" /></td>
												--><td class="table_color"><ww:property
													value="agentcontactname" /></td>
												<td class="table_color"><ww:property value="agentphone" /></td>
												
												<td class="table_color"><ww:property value="getxinyongprice(id)" /></td>
												<td class="table_color"><ww:property value="getyiyongprice(id)" /></td>
												<td class="table_color"><ww:property value="getusername(userid)" /></td>
												
												<!--<td class="table_color"><ww:property
													value="formatTimestamp(agentvsdate)" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(agentvedate)" /></td>
												--><!--<td class="table_color"><ww:property value="parentid" /></td>
												-->
												<td class="table_color"><ww:if test="agentisenable==0">禁用</ww:if>
												<ww:elseif test="agentisenable==1">启用</ww:elseif></td>
												<td class="table_color">
													<ww:if test="agentcheckstatus==0">未审核</ww:if>
													<ww:elseif test="agentcheckstatus==1">审核通过</ww:elseif>
													<ww:elseif test="agentcheckstatus==2">拒绝审核</ww:elseif>
												</td>
												<td class="table_color">
												<a href="javascript:doCustCheck(<ww:property value="id" />,1)">通过审核</a>
												<br /><a href="javascript:doCustCheck(<ww:property value="id" />,2)">拒绝审核</a>
												</td>
												
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
								<td height="43" align="center">
	<ww:property value="getPagination('\"customeragent!tobiguser.action?pageinfo.pagenum=\"+pageno')"/>	
				
									</td>
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
		window.location="customeragent!toaddbiguser.action?<ww:property value="url"/>";
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
				document.form1.action="customeragent!toeditbig.action?id="+document.form1.selectid.value;
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
		     	document.form1.action="customeragent!toeditbig.action?id="+uvalue;
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
  	function adduser(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{
				document.form1.action="customeragent!toaddbiuser.action?id="+document.form1.selectid.value;
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
		     	document.form1.action="customeragent!toaddbiuser.action?id="+uvalue;
				document.form1.submit();
				return;
		      }else if (len>1){
		      	var temp = confirm('只能选择一项进行添加操作？');
				return;
				      
			  }
				      
		}	
		alert("无效操作,你未选择任何内容!");
		return;
  	}
	function shezhi(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{
				document.form1.action="customeragent!toshezhi.action?id="+document.form1.selectid.value;
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
		     	document.form1.action="customeragent!toshezhi.action?id="+uvalue;
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