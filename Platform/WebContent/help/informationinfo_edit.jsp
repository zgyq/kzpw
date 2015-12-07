
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
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
<title><ww:if test="informationinfo
		.id>0">编辑</ww:if><ww:else>新增</ww:else>资讯中心详细信息
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

	
		comboxWithTree.setValue("<ww:property value="getInformationName(informationinfo.typeid)"/>");

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
	function check(){
		var name=$("#m_name").val();
		var type=$("#parentid").val();
		var names=$("#h_name").val();
		var hinfo=$("#infos").val();
		if(name==""&&document.getElementById("isanswern").checked==true){
			alert(" 名称不能为空");
			return false;
		}else if(names==""&&document.getElementById("isanswery").checked==true){
			alert(" 问题不能为空");
			return false;
		}else if(hinfo==""&&document.getElementById("isanswery").checked==true){
			alert("答案不能为空");
			return false;
		}
		if(type==""){
			alert("请选择类型");
			return false;
		}
		return true;
	}
	function check2(){
	if(document.getElementById("isanswery").checked==true){
		$("#mingcheng").hide();
		$("#biaoti").show();
		$("#mingchenginfo").hide();
		$("#biaotiinfo").show();
		$("#infoy").hide();
		$("#infon").show();
	}	
	}
	function check1(){
	if(document.getElementById("isanswern").checked==true){
		$("#mingcheng").show();
		$("#biaoti").hide();
		$("#mingchenginfo").show();
		$("#biaotiinfo").hide();
		$("#infoy").show();
		$("#infon").hide();
	}	
	}
</script>
<body>
<div id="member">
<form
	action="informationinfo
		!<ww:if test="informationinfo
		.id>0">edit.action?id=<ww:property value="informationinfo
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onsubmit="return check()">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="informationinfo
		.id>0">编辑</ww:if><ww:else>新增</ww:else>资讯中心详细信息
		</span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">是否是问答 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="radio" name="isanswers" id="isanswery" value="1"
						onclick="check2()" />是 <input type="radio" name="isanswers"
						id="isanswern" value="2" checked="checked" onclick="check1()" />否</td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">
					<div id="mingcheng">名称:<span style="color: red;">*</span></div>
					<div style="display: none;" id="biaoti">问题:<span
						style="color: red;">*</span></div>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<div id="mingchenginfo"><input type="text" name="m_name"
						id="m_name" value='<ww:property value="informationinfo.name"/>'
						" style="width: 300px" /></div>
					<div style="display: none;" id="biaotiinfo"><input
						type="text" name="h_name" id="h_name"
						value='<ww:property value="informationinfo.name"/>'
						" style="width: 300px" /></div>
					</td>
				</tr>

				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<ww:if test="informationinfo.id>0">
						<input type="radio" name="state" value="1"
							<ww:if test="informationinfo.state==1">checked</ww:if> />启用
				<input type="radio" name="state" value="0"
							<ww:if test="informationinfo.state==0">checked</ww:if> />禁用
				</ww:if><ww:else>
						<input type="radio" name="state" value="1" checked="checked" />启用
				<input type="radio" name="state" value="0" />禁用
				</ww:else></td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<!--<input type="text"  name="typeid
						" value='<ww:property value="informationinfo.typeid"/>'" style="width: 300px" />  -->
					<div id='comboxWithTree'></div>
					<input type="hidden" id="parentid" name="typeid"
						value='<ww:property value="informationinfo.typeid"/>' /></td>

					<!--  <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					创建人id
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="memberid
						" value='<ww:property value="informationinfo.memberid"/>'" style="width: 300px" />
				</td>
		
	
						 
				
		</tr>-->



					<!--   <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="image
						" value='<ww:property value="informationinfo.image"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				</td>-->
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">是否主推 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" style="text-align: left;"
						class="table_color_l"><input type="radio" id="isweby"
						name="iswebs" value="1">是 <input type="radio" id="iswebn"
						name="iswebs" value="2" checked="checked">否</td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin"><span style="color: red;"></span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					</td>
				</tr>
				<tr>



					<td colspan="4" >
					<DIV id="infoy"><FCK:editor id="info" basePath="fck/"
						width="880" height="400">
						<ww:property value="informationinfo.info" />
					</FCK:editor></DIV>
					<DIV style="display: none;" id="infon"><font size="5">答案:</font><span
						style="color: red;"></span><textarea id="infos" name="h_info"
						rows="8" cols="120"><ww:property
						value="informationinfo.info" /></textarea></DIV>
					</td>
				</tr>

				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='informationinfo.action?<ww:property value="url"/>';,return checkType()"
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


