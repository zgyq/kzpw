<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	/**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="systemright.id>0">编辑</ww:if><ww:else>新增</ww:else>系统权限</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>

</head>

<link href="style/base.css" rel="stylesheet" />
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
       width:370,
	   tpl: "<tpl for='.'><div style='height:240px ; width:300px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'})  ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
           rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(systemright.parentid)"/>");

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
<script>
function form_validate() {

		var validate = true ;
		
		vname = document.getElementById('name1');
	
		if(vname.value=="") {
			document.getElementById("name2").innerHTML="*权限名称不能为空";
			vname.focus();
			validate = false ;
		} else {
			document.getElementById("name2").innerHTML="*";
		}
		
		
	
		code = document.getElementById('code');
		if(code.value=="") {
			document.getElementById("code2").innerHTML="*操作代码不能为空";
			code.focus();
			validate = false ;
		} else {
			document.getElementById("code2").innerHTML="*";
		}	
		
		
		resource = document.getElementById('resource');
		
		if(resource.value!="") {
		
				 var pattern=/[0-9]/; 
				if(!pattern.exec(resource.value))
				 {
					document.getElementById("resource2").innerHTML="*排序只能填写数字";
					resource.focus();
					validate = false ;
				 }else{
				 	document.getElementById("resource2").innerHTML="*";
				 }
				
		} 
			
		
		
		
	//	parentstr = document.getElementById('parentstr1');
	//	if(parentstr.value=="") {
	//		document.getElementById("parentstr2").innerHTML="*父ID串不能为空";
	//		parentstr.focus();
	//		validate = false ;
	//	} else {
	//		document.getElementById("parentstr2").innerHTML="*";
	//	}	
		return validate;
}
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="systemright.id>0">编辑</ww:if><ww:else>新增</ww:else>系统权限</span></b></td>
	</tr>
	<tr>
		<td valign="top" style="text-align: center;">&nbsp;
		<form
			action="systemright!<ww:if test="systemright.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return form_validate()">



		<table width="95%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; border-top: 10px " align="center">
			<tr>
				<td height="100%" >
				<table width="100%" cellpadding="0" cellspacing="0">


					<tr>
						
					
						<td height="28"  style=" text-align: right;" class="table_color colortrin">权限名称：</td>
						<td class="table_color_l" width="380"><input type="text" require="true" dataType="Require"
							msg="操作名称不能为空" name="name" id="name1"
							value='<ww:property value="systemright.name"/>'
							 style="width: 300px" /><span id="name2" class="font-red">*</span></td>
							<td height="28" style=" text-align: right;" class="table_color colortrin">排序：</td>
						<td class="table_color_l"><input type="text" require="true" dataType="Require"
							msg="资源不能为空" name="orderid" id="resource"
							value='<ww:property value="systemright.orderid"/>'
							 style="width: 100px" /><span id="resource2" class="font-red"></span></td>
					</tr>



					<tr>
						<td height="28" style=" text-align: right;" class="table_color colortrin">操作代码：</td>
						<td class="table_color_l"><input type="text" require="true" dataType="Require"
							msg="操作代码不能为空" name="code" id="code"
							value='<ww:property value="systemright.code"/>'
							" style="width: 300px" /><span id="code2" class="font-red">*</span></td>
					
						<td height="28" style=" text-align: right;" class="table_color colortrin">状态：</td>
						<td class="table_color_l"><select name="state" style="width: 110px">


							<option value="1"
								<ww:if test="systemright.state==1">selected</ww:if>>正常</option>
							<option value="0"
								<ww:if test="systemright.state==0">selected</ww:if>>禁用</option>

						</select> <!--<input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="systemright.state"/>'" style="width:350px" />
	 --></td>
					</tr>




					<tr>
						<td height="28" style=" text-align: right;" class="table_color colortrin">父权限：</td>
						<td class="table_color_l">
						<div id='comboxWithTree'></div>
						</td>

					
					<input type="hidden" id="parentid" name="parentid"
						value='<ww:property value="systemright.parentid"/>'
						 style="width: 300px" />
						
						<td height="28" style=" text-align: right;" class="table_color colortrin">权限类别：</td>
						<td class="table_color_l"><select name="type" style="width: 110px">


							<option value="0"
								<ww:if test="systemright.type==0">selected</ww:if>>无链接的</option>
							<option value="1"
								<ww:if test="systemright.type==1">selected</ww:if>>有链接的</option>
							<option value="2"
								<ww:if test="systemright.type==2">selected</ww:if>>按钮</option>
						</select>
						</td>
						<!--
						<td height="28" style=" text-align: right;" class="table_color colortrin">父ID串：</td>
						<td class="table_color_l"><input type="text" require="true" dataType="Require"
							msg="父ID串不能为空" name="parentstr" id="parentstr1"
							value='<ww:property value="systemright.parentstr"/>'
							" style="width: 350px" /><span id="parentstr2" class="font-red">*</span></td>
					--></tr>


<!--  
					<tr>
					<td height="28" style=" text-align: right;" class="table_color colortrin">业务类型：</td>
					<td class="table_color_l" colspan="3">
					<select name="bussinessid" style="width: 110px">
					<option value=''>系统类型</option>
						<ww:iterator value="getLoginsessionagent().bussinesslist">
						<option value='<ww:property value="id"/>'>
						<ww:property value="name"/>
						</option>
						</ww:iterator>
						</select>
						</td>
						
					</tr>


-->


					<tr class="font-blue-xi">
						
						<td height="46" scrolling="no" colspan="4" align="center"><input type="submit"
							class="button_d font-bai" value="提交"
							style="margin-right: 55px;"> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='systemright.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
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


