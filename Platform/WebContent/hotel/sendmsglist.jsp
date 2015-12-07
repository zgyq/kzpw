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
<title>我发送的消息列表</title>
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
                id:"new",
				text: '新建',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="sysmessage!toaddMsg.action?<ww:property value="url"/>";
					
				}
            }
			,{
                id:"detail",
				text:"查看",
				disabled:false,
				icon:"images/menu/view.gif",
				handler :function(item){
						document.form1.action="sysmessage!toMsgDetail.action?id="+selectId;
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
<script language="JavaScript">
	function toadd(){
		window.location="sysmessage!toSendMsg.action?<ww:property value="url"/>";
	}
	function deleteItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{
					var temp = confirm('确认删除吗？');
					if(temp==true){
					
						document.form1.action="sysmessage!delete.action?id="+document.form1.selectid.value;
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
				if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
      			}
			}
			if(len==1) {
				var temp = confirm('确认删除吗？');
				if(temp==true){
					document.form1.action="sysmessage!delete.action?id="+uvalue;
					document.form1.submit();
				}
				return;
			} else if (len>1) {
   				var temp = confirm('确认删除吗？');
   				if(temp==true) {
   					document.form1.action="sysmessage!batch.action?opt=1";
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
			if(document.form1.selectid.checked ==true) {
				document.form1.action="sysmessage!toedit.action?id="+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
	  	if ( length == null || length==0 ) {
  	  		alert("你未选择任何内容");
        	return;
		} else {
			var len=0;
			var uvalue=0;
			for (var i = 0; i < length; i++) {
			    if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
      			}
			}
			if(len==1){
				document.form1.action="sysmessage!toedit.action?id="+uvalue;
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
	
	function detailItem() {
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
				document.form1.action="sysmessage!toRevMsgDetail.action?id="+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
		if ( length == null || length==0 ){
			alert("你未选择任何内容");
			return;
		} else {
			var len=0;
			var uvalue=0;
			for (var i = 0; i < length; i++) {
				if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
				}
    		}
		    if(len==1){
				document.form1.action="sysmessage!toRevMsgDetail.action?id="+uvalue;
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
	
	function checkItem() {
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
				document.form1.action="sysmessage!docheck.action?id="+document.form1.selectid.value;
				document.form1.submit();
				return;
			}
		}
		if ( length == null || length==0 ){
			alert("你未选择任何内容");
			return;
		} else {
			var len=0;
			var uvalue=0;
			for (var i = 0; i < length; i++) {
				if( document.form1.selectid[i].checked ==true){
					uvalue=document.form1.selectid[i].value;
					len++;					         
				}
    		}
		    if(len==1){
				document.form1.action="sysmessage!docheck.action?id="+uvalue;
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
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;我发送的消息列表</span></b></td>
	</tr>
	<tr>
		<td>
		<form name="form1" method="post" action="sysmessage.action">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td style="padding-top: 10px;" align="center">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<table width="350" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
									<tr class="font-blue-xi">
										<td height="28" align="right"><span class="STYLE2">发送时间：</span></td>
										<td align="left">&nbsp; 
											<input type="text" name="sendTime" />
										</td>
										<td align="center"><input type="button"
											class="button_d font-bai" onclick="document.form1.submit();" value="查询" />
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<!--<tr>
								<td align="center"><input type="button"
									class="button_d font-bai" onclick="document.form1.submit();"
									value="查询" />
								</td>
							</tr>
							--><tr>
								<td height="40">
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="发送新消息" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="detailItem()"><input
											type="button" value="查看" class="button_h font-red" /></a>
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
						<td valign="top">
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
											<th class="table_color">序号</th>
											<!-- 
											<th class="table_color">创建者</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">修改者</th>
											<th class="table_color">修改时间</th>
											<th class="table_color">创建者ID</th>
											<th class="table_color">类型</th>
											 -->
											<th class="table_color">标题</th>
											<!--<th class="table_color">内容</th>
											--><!--<th class="table_color">可见</th>
											<th class="table_color">截止时间</th>
											-->
											<th class="table_color">发送时间</th>
										</tr>

										<ww:iterator value="listSysmessage">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color"><ww:property value="id" /></td>
												<!-- 
												<td class="table_color"><ww:property value="createuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color"><ww:property value="modifyuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(modifytime)" /></td>
												<td class="table_color"><ww:property
													value="customeruserid" /></td>
												<td class="table_color"><ww:if test="type==0">
													系统公告
													</ww:if> <ww:elseif test="type==1">
													机票公告
													</ww:elseif></td>
													 -->
												<td class="table_color"><ww:property value="title" /></td>
												<!--<td class="table_color"><ww:property
													value="subString(content)" /></td>
												--><!--<td class="table_color"><ww:property value="users" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(pubtime)" /></td>
												-->
												<td class="table_color"><ww:property
													value="formatTimestamp(modifytime)" /></td>
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
