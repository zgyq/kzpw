
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
<title><ww:if test="helpcenter
		.id>0">编辑</ww:if><ww:else>新增</ww:else>帮助中心
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>
</head>
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

	
		comboxWithTree.setValue("<ww:property value="getHelpcenterName(helpcenter.parentid)"/>");

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
<script type="text/javascript">
	function checkName(){
		var name=$("#name").val();
		if(name==""){
			alert("请填写名称");
			return false;
		}
		return true;
	}
</script>
<body>
<div id="member">
<form
	action="helpcenter
		!<ww:if test="helpcenter
		.id>0">edit.action?id=<ww:property value="helpcenter
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onsubmit="return checkName()">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="helpcenter
		.id>0">编辑</ww:if><ww:else>新增</ww:else>帮助中心 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">名称 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="name
						" id="name"
						value='<ww:property value="helpcenter.name"/>'
						" style="width: 300px" /></td>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<ww:if test="helpcenter.id>0">
						<input type="radio" name="state" value="1"
							<ww:if test="helpcenter.state==1">checked</ww:if> />启用
				<input type="radio" name="state" value="0"
							<ww:if test="helpcenter.state==0">checked</ww:if> />禁用
				</ww:if><ww:else>
						<input type="radio" name="state" value="1" checked="checked" />启用
				<input type="radio" name="state" value="0" />禁用
				</ww:else></td>


					<!--<ww:if test="helpcenter.id>0">
				<input type="text"  name="parentid" value='<ww:property value="helpcenter.parentid"/>' style="width: 300px" />
				<input type="text"  name="parentstr" value='<ww:property value="helpcenter.parentstr"/>' style="width: 300px" />
				</ww:if><ww:else>
				
				<input type="text"  name="parentid" value='<ww:property value="helpcenter.parentid"/>' style="width: 300px" />
				<input type="text"  name="parentstr" value='<ww:property value="helpcenter.parentstr"/>' style="width: 300px" />
				</ww:else>
				
				
				-->
					<!--		 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					创建人id
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="memberid
						" value='<ww:property value="helpcenter.memberid"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="state
						" value='<ww:property value="helpcenter.state
						"/>'" style="width: 300px" />
				</td>
		</tr>
		-->
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">父栏目 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<!--<input type="text"  name="parentid
						" value='<ww:property value="helpcenter.parentid"/>'" style="width: 300px" />
					-->
					<div id='comboxWithTree'></div>

					<input type="hidden" id="parentid" name="parentid"
						value='<ww:property value="helpcenter.parentid"/>' /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">是否主推：<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					&nbsp;<input type="radio" name="iswebs" value="1"/>是<input type="radio" name="iswebs" value="2" checked="checked"/>否</td>
				</tr>

				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='helpcenter.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>


