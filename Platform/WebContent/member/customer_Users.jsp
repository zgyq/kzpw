<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
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
					window.location.href="customeruser!tomyuser.action?<ww:property value="url"/>";
					
				}
            }
            ,
		    {
                id:"update",
				text: '修改',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="customeruser!toedituser.action?id="+selectId;
					
				}
            }
			,
			'-',
			{
                id:"check",
				text:"启用/禁用",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customeruser!doCheckUsers.action?id="+selectId;
						document.form1.submit();
				}
            },
			{
                id:"fenpei",
				text:"分配角色",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customeruser!grantRole.action?memberid="+selectId;
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
function updateItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{				
				document.form1.action="customeruser!toedituser.action?id="+document.form1.selectid.value;
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
		    // alert(uvalue);
		     	document.form1.action="customeruser!toedituser.action?id="+uvalue;
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

function fenpei(){

			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tofenpei.action?memberid="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}else{
				 	alert("你未选择任何内容");
					return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      
					      		document.form1.action="customeruser!tofenpei.action?memberid="+uvalue;
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
				document.form1.action="customeruser!doCheckUsers.action?id="+document.form1.selectid.value;
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
	      		document.form1.action="customeruser!doCheckUsers.action?id="+uvalue;
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
			class="anse">&nbsp;&nbsp;&nbsp;员工管理</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="customeruser!touser.action" name="form1" method="post">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<!--<tr>
                <td width="100%" height="29" colspan="8" background="../images/jb.gif" style="border-bottom: 1px solid #99CBED">
                    <span class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;员工管理</span></td>
            </tr>
            -->
			<tr>
				<td>
				<table border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>				    
					  <td>部门：</td>
					  <td>
					  <span style="HEIGHT: 71px" style="WIDTH: 150px"> 
						<div id='comboxWithTree'></div>
					    <input type="hidden" id="parentid" name="cusagentname" value='<ww:property value="cusagentname"/>' /></span>
					   </td>
						<td width="60px;" align="right" style="height: 40px;">员工帐号:</td>
						<td><input name="yunyinguser" type="text" id="txtID"
							style="width: 150px" value="<ww:property value="yunyinguser"/>" /></td>
						<td width="60px;" align="right">姓名:</td>
						<td><input name="yunyingname" type="text" id="txtLinkMan"
							value="<ww:property value="yunyingname"/>" /></td>
						<td width="60px;" align="right">电话:</td>
						<td><input name="yunyingtel" type="text" id="txtPhone"
							value="<ww:property value="yunyingtel"/>" /></td>
					</tr>

					<tr>
						<td colspan="8" align="center"><input type="submit"
							class="button_d font-white" value="查&nbsp;&nbsp;询" /></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="98%"
					height="40">
					<tr>
						<td align="right"><input type="button"
							class="button_z font-red" value="添加新员工"
							onclick="location.href='customeruser!tomyuser.action'" /> <input
							type="button" class="button_z font-red" value="修改"
							onclick="updateItem()" /> <input type="button"
							class="button_z font-red" value="启用/禁用" onclick="checkItem()" />
						<input type="button" value="分配角色" onclick="fenpei();" class="button_h font-red" /> </a></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="bottom">
						<table id="menutable" cellspacing="0" align="center" border="1"
							class="table_color" width="99%">
							<tbody>
								<tr class="tbody_color">
									<td class="table_color" width="54" height="25"><input
										type="checkbox" name="all1" value="1" onclick="selectall1()" />全选
									</td>
									<td class="table_color">帐号</td>
									<td class="table_color">姓名</td>

									<td class="table_color">移动电话</td>
									<td class="table_color">添加人</td>
									<td class="table_color">开户时间</td>
									<td class="table_color">所属角色</td>

									<td class="table_color">启用状态</td>
									<!--<td class="table_color">上次登录时间</td>
								<td class="table_color">总登录次数</td>
								-->
									<!--<td class="table_color">操作</td>
							-->
								</tr>
								<ww:iterator value="listCustomeruser">
									<tr id="<ww:property value="id"/>" align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
										onmouseout="this.className='colortrout',this.style.fontWeight='';">
										<td class="table_color"><input type="checkbox"
											name="selectid" value="<ww:property value="id"/>" /></td>
										<td class="table_color"><ww:property value="loginname" /></td>
										<td class="table_color"><ww:property value="membername" /></td>
										<td class="table_color"><ww:property value="mobile" /></td>

										<td class="table_color"><ww:property value="createuser" /></td>
										<td class="table_color"><ww:property
											value="formatTimestamp(createtime)" /></td>
										<td class="table_color"><ww:property
											value="getRoleStr(id)" /></td>

										<!--<td class="table_color">2009-11-28 <br />
									112:48:34</td>
									<td class="table_color">14</td>-->
										<td class="table_color"><ww:if test="isenable==1">启用</ww:if>
										<ww:else>禁用</ww:else></td>
										<!--<td class="table_color">
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
										<tr>
											<td nowrap="nowrap" style="height: 20px;"><a
												id="sdgSoffInfo_ctl03_Edit"
												href="javascript:__doPostBack('sdgSoffInfo$ctl03$Edit','')">[修改]</a></td>
											<td nowrap="nowrap" style="height: 20px;"><a
												onclick="return confirm('是否确认修改状态？');"
												id="sdgSoffInfo_ctl03_ChangeAuditFlag"
												href="javascript:__doPostBack('sdgSoffInfo$ctl03$ChangeAuditFlag','')">[禁用]</a></td>
											<td nowrap="nowrap" style="height: 20px;"><a
												id="sdgSoffInfo_ctl03_Del"
												href="javascript:__doPostBack('sdgSoffInfo$ctl03$Del','')">[授权]</a></td>
										</tr>
										<tr>
											<td nowrap="nowrap" colspan="3" style="height: 20px;"
												align="center" width="100%"><a
												onclick="ShowDialog('../Accounts/ReSetPWD.aspx?id=60703','初始化密码',350,300,'no');"
												id="sdgSoffInfo_ctl03_lbtnInitialization"
												href="javascript:__doPostBack('sdgSoffInfo$ctl03$lbtnInitialization','')">[初始化密码]</a>
											</td>
										</tr>
									</table>
									</td>
								-->
									</tr>
								</ww:iterator>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"><ww:property value="getPagination('\"customeruser!touser.action?pageinfo.pagenum=\"+pageno')"/></td>
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
<table>
	<tr>
		<td><strong><span class="font-red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul style="padding-left: 30px;">
			<li>联系电话可为办公电话 也可为移动电话</li>
			<li>启用/禁用选择:</li>
			<li style="list-style: none; padding-left: 30px;">启用 该帐户可以登录系统</li>
			<li style="list-style: none; padding-left: 30px;">禁用 该帐户不可以登录系统</li>
			<li><span class="font-red-xi">授权选择:可进入权限选择页面</span></li>
		</ul>
		</td>
	</tr>
</table>
</body>
</html>
