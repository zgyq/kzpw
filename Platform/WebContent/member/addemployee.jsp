<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加修改分销商</title>
<link type="text/css" rel="Stylesheet" href="Common.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine.js"
	type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
</head>
<script>

$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
</script>
<!-- 部门树 -->
<script>


Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:370,
	   tpl: "<tpl for='.'><div style='height:240px ; width:370px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(customeruser.deptid)"/>");

       tree.on('click',function(node){  
           
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();  
            
       });  
    
	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().expandChildNodes();
			
		});

	
    comboxWithTree.render('comboxWithTree');  
	


});

</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;
			<span
				style="color: red; font-weight: bold;">
				<ww:property value="customeragent.agentcompanyname"/></span> 员工
			<ww:if test="customeruser.id>0">编辑</ww:if><ww:else>添加</ww:else>
			
				</b>
				</td>
	</tr>
	<tr>
		<td valign="top">

		<form name="form1" id="form1" method="post"
			action='customeruser!<ww:if test="customeruser.id>0">editemployee.action</ww:if><ww:else>addemployee.action</ww:else>'>
			<input type="hidden" value='<ww:property value="customeruser.agentid" />'name="agentid" />
			<input type="hidden" value='<ww:property value="customeragent.agenttype" />'name="customeragent.agenttype" />
			<input type="hidden" value='<ww:property value="customeragent.agentjibie" />'name="customeragent.agentjibie" />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>

					</tr>

					<tr>
						<td height="28" align="right" class="table_color colortrin">
						<input type="hidden" name="id"
							value="<ww:property value="customeruser.id"/>" /> <span>登录名：</span></td>
						<td class="table_color_l">
							<input type="text" name="loginname" id='loginname<ww:property value="customeruser.id"/>'
								 desc="登录名"
								class="validate[onlyLetter,length[6,50],ajax[ajaxUsername]]"
								value='<ww:property value="customeruser.loginname"/>'
								style="width: 150px" />
						<span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>登陆密码：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="password" require="true" dataType="Require"
								msg="登陆密码不能为空" name="logpassword" id="logpassword" desc="密码"
								value="" style="width: 150px" />
						</ww:if><ww:else>
							<input type="password" name="logpassword" id="logpassword"
								desc="密码"
								<ww:if test="#request.edit==null"> class="validate[length[6,50]"</ww:if>
								value='<ww:property value="customeruser.logpassword"/>'
								style="width: 150px" />
						</ww:else> <span id="logpassword2" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>姓名：</span></td>
						<td class="table_color_l"><input type="text"
							name="membername" id="membername"
							value='<ww:property value="customeruser.membername"/>'
							style="width: 150px" /><span id="membername2" class="font-red"></span></td>
						<td height="28" align="right" class="table_color colortrin"><span>性别：</span></td>
						<td class="table_color_l"><select name="membersex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>手机号：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="text" name="mobile" id="membermobile"
								value='<ww:property value="customeruser.mobile"/>' desc="手机号码"
								class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
								style="width: 150px" />
						</ww:if> <ww:else>
							<input type="text" name="mobile" id="membermobile"
								value='<ww:property value="customeruser.mobile"/>' desc="手机号码"
								class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
								style="width: 150px" />
						</ww:else> <span id="mobile2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>电子邮箱：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="text" name="memberemail" id="memberemail"
								mId="<ww:property value="customeruser.memberemail"/>"
								value='<ww:property value="customeruser.memberemail"/>'
								 style="width: 150px" />
						</ww:if><ww:else>
							<input type="text" name="memberemail" id="memberemail"
								value='<ww:property value="customeruser.memberemail"/>'
								 style="width: 150px" />
						</ww:else></td>

					</tr>
					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>是否启用：</span></td>
						<td class="table_color_l" >
						<select name="isenable">
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>启用</option>
							<option value="2"
								<ww:if test="customeruser.isenable==0">selected</ww:if>>禁用</option>
						</select>
						</td>
						<td height="28" align="right" class="table_color colortrin"><span>所属部门：</span></td>
						<td class="table_color_l">
						<div id='comboxWithTree'></div>
						<input type="hidden" id="parentid" name="deptid"
							value='<ww:property value="customeruser.deptid"/>'
							" style="width: 150px" /></td>
							
						<!-- 
						<td height="28" align="right" class="table_color colortrin"><span <ww:if test='s_isview.equals("true")'>style="display:none"</ww:if>>是否是管理员：</span></td>
						<td class="table_color_l">
						<select name="isadmin" <ww:if test='s_isview.equals("true")'>style="display:none"</ww:if>>
							<option value="2"
								<ww:if test="customeruser.isadmin==2">selected</ww:if>>否</option>
							<option value="1"
								<ww:if test="customeruser.isadmin==1">selected</ww:if>>是</option>
						</select>
						
						</td>
						 -->
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input
							type="submit" id="submitreg" class="button_d font-bai" value="提交" />
						<input type="button" class="button_d font-bai"
							onclick="history.back()" name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<table>
			<tr>
				<td><strong><span class="font-red">注意事项:</span></strong></td>
			</tr>
			<tr>
				<td>
				<ul style="padding-left: 30px;">
					<li><span id="mobile2" class="font-red">*</span>代表必填项</li>
					<li>启用/禁用选择:</li>
					<li style="list-style: none; padding-left: 30px;">启用 该帐户可以登录系统</li>
					<li style="list-style: none; padding-left: 30px;">禁用
					该帐户不可以登录系统</li>
					
				</ul>
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
