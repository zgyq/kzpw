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
	
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
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
        items: [{
                id:"new",
				text: '新建',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="customeruser!toAddEmployee.action?agentid=<ww:property value='customeruser.agentid' />";
					
				}
            }
			,
		    {
                id:"update",
				text: '修改',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="customeruser!toeditEmployee.action?id="+selectId;
					
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
				document.form1.action='customeruser!doCheckUsers.action?id='+selectId;
				document.form1.submit();
				}
            },
            {
                id:"fenpei",
				text:"分配角色",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						window.location.href="customeruser!tograntRole.action?id="+selectId+"&agentid=<ww:property value='customeruser.agentid' />";
					
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

function operateItem(url){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true)
			{
				document.form1.action=url+"?id="+document.form1.selectid.value;
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
		     	document.form1.action=url+"?id="+uvalue;
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
 //****************************************************************
function GetUrlParms()    
{
     var args=new Object();   
     var query=location.search.substring(1);//获取查询串   
     var pairs=query.split("&");//在逗号处断开   
     for(var    i=0;i<pairs.length;i++)   
     {   
         var pos=pairs[i].indexOf('=');//查找name=value   
            if(pos==-1)   continue;//如果没有找到就跳过   
             var argname=pairs[i].substring(0,pos);//提取name   
            var value=pairs[i].substring(pos+1);//提取value   
            args[argname]=unescape(value);//存为属性   
    }
     return args;
}

	function checkItem(){
		var length=document.form1.selectid.length;
		//唯一项
		if(length== undefined){
			if(document.form1.selectid.checked ==true) {
				document.form1.action="customeruser!doCheckUsers.action?id="+document.form1.selectid.value+"&pretBool=false";
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
	      		document.form1.action="customeruser!doCheckUsers.action?id="+uvalue+"&pretBool=false";
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
			class="anse"><span style="color:red"><ww:property value="customeragent.agentcompanyname"/></span> 员工管理</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="customeruser!toEmployeelist.action" name="form1" method="post">
		<input type="hidden" name="agentid" value="<ww:property value="customeruser.agentid"/>" />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td>
				<table border="0" cellpadding="0" cellspacing="0" align="center">
					<tr>
					    
						<td width="60px;" align="right" style="height: 40px;">员工帐号:</td>
						<td><input name="fenxiaouser" type="text" id="txtID" value="<ww:property value="fenxiaouser"/>"/></td>
						<td width="60px;" align="right">姓名:</td>
						<td><input name="fenxiaoname" type="text" id="txtLinkMan" value="<ww:property value="fenxiaoname"/>"/>
						</td>
						<td width="60px;" align="right">电话:</td>
						<td><input name="fenxiaotel" type="text" id="txtPhone" value="<ww:property value="fenxiaotel"/>"/></td>
					</tr>
					<tr><td colspan="6" align="center">
					<input type="submit" class="button_d font-white" value="查&nbsp;&nbsp;询" /> </td></tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0" width="98%"
					height="40">
					<tr>
						<td style="color: red">最大员工数:<ww:property value="#request.maxnum"/>
						</td>
						<td style="color: red">可添加数量:
						<ww:property value="#request.datenum"/>
						</td>
						<td align="right">
							<input type="button" class="button_z font-red" value="添加新员工" onclick="location.href='customeruser!toAddEmployee.action?agentid=<ww:property value="customeruser.agentid"/>'" />
							<input type="button" class="button_z font-red" value="修改" onclick="operateItem('customeruser!toeditEmployee.action')" />
							<input type="button" class="button_z font-red" value="启用/禁用" onclick="checkItem()" /> 
							<input type="button" class="button_z font-red" value="分配角色" 
							onclick='operateItem("customeruser!tograntRole.action")' /> 
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="bottom">
						<table id="menutable" cellspacing="0" align="center" border="1" class="table_color" width="99%">
							<tr class="tbody_color" style="font-weight:bold">
								<td class="table_color" width="3%" >
									<input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选
								</td>
								<td class="table_color" width="8%">帐号</td>
								<td class="table_color" width="8%">姓名</td>
								<td class="table_color" width="8%">移动电话</td>
								<!--<td class="table_color">添加人</td>
								-->
								<td class="table_color" width="8%">部门</td>
								<td class="table_color" width="8%">开户时间</td>
								<td class="table_color" width="20%">所属角色</td>
								<td class="table_color">启用状态</td>
								<!--<td class="table_color">上次登录时间</td>
								<td class="table_color">总登录次数</td>
								-->
								<ww:if test="getLoginsessionagent().agenttype==1||getLoginsessionagent().agenttype==2">
								<td class="table_color"  width="20%">分配地区</td>
								</ww:if>
								<td class="table_color">操作</td>
							</tr>
							<ww:iterator value="listCustomeruser">
								<tr id="<ww:property value="id"/>" align="center"
									onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
									onmouseout="this.className='colortrout',this.style.fontWeight='';">
									<td class="table_color" >
										<input type="checkbox" name="selectid" value="<ww:property value="id"/>" />
									</td>
									<td class="table_color"><ww:property value="loginname"/></td>
									<td class="table_color"><ww:property value="membername"/></td>
							
									<td class="table_color"><ww:property value="mobile"/></td>
									<!--<td class="table_color"><ww:property value="createuser"/></td>
									-->
									<td class="table_color"><ww:property value="getContentitemName(deptid)"/></td>
									<td class="table_color">
										<ww:property value="formatTimestamp(createtime)"/>
									</td>
									<td class="table_color"><ww:property value="getRoleStr(id)" /></td>
									<!--<td class="table_color">2009-11-28 <br />
									112:48:34</td>
									<td class="table_color">14</td>
									-->
									<td class="table_color">
										<ww:if test="isenable==1">启用</ww:if>
										<ww:else>禁用</ww:else>
									</td>
									<ww:if test="getLoginsessionagent().agenttype==1||getLoginsessionagent().agenttype==2">
									<td class="table_color">
										<ww:property value="description" />
									</td>
									</ww:if>
									<td class="table_color">
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<ww:if test="getLoginsessionagent().agenttype==1||getLoginsessionagent().agenttype==2">
										<tr>
											<!--
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
										-->
										<td nowrap="nowrap" colspan="3" style="height: 20px;"
												align="center" width="100%"><a
												id="sdgSoffInfo_ctl03_lbtnInitialization"
												href="train!tofenpei.action?s_userid=<ww:property value="id"/>">[分配地区]</a>
											</td>
										</tr>
										</ww:if>
										<tr>
											<td nowrap="nowrap" colspan="3" style="height: 20px;"
												align="center" width="100%"><a
												onclick="ShowDialog('#','初始化密码',350,300,'no');"
												id="sdgSoffInfo_ctl03_lbtnInitialization"
												href="javascript:__doPostBack('sdgSoffInfo$ctl03$lbtnInitialization','')">[初始化密码]</a>
											</td>
										</tr>
									</table>
									</td>
								</tr>
							</ww:iterator>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				
				<td height="43" align="center"><ww:property value="getPagination('\"customeruser!toEmployeelist.action?pageinfo.pagenum=\"+pageno')"/>	
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
		     <li style="color:red;font-weight:bold">请对员工分配角色，否则无法进行系统登录！</li>
			<li>点击返回上一级按钮，直接返回加盟商列表页面</li>
			<li>启用/禁用选择:启用 该帐户可以登录系统,禁用 该帐户不可以登录系统</li>
			<li>授权选择:可进入权限选择页面</li>
		</ul>
		</td>
	</tr>
</table>
</body>
</html>
<script>
<ww:if test="#request.message!=null">
$(document).ready(function(){
 alert('<ww:property value="#request.message"/>');

 
});
</ww:if>
</script>