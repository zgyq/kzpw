
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
<title><ww:if test="giftcatalog
		.id>0">编辑</ww:if><ww:else>新增</ww:else>礼品目录
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<!--添加礼品分类树 2011-12-27 高亮  -->
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script>
Ext.onReady(function(){
 
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:250,
	   tpl: "<tpl for='.'><div style='height:240px ; width:250px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'})  ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
           rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(giftcatalog.parentid)"/>");

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
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="giftcatalog!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
</head>

<body>
<div id="member">
<form
	action="giftcatalog
		!<ww:if test="giftcatalog
		.id>0">edit.action?id=<ww:property value="giftcatalog
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display: block;">&nbsp;&nbsp;&nbsp;<ww:if
			test="infotype.id>0">编辑</ww:if><ww:else>新增</ww:else>礼品目录</span> <span
			style="display: block; width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="giftcatalog.id>0||giftcatalog.language>0">
					<td width="25%"><a href="#"
						onclick="addlanguage(<ww:property value="giftcatalog.ucode"/>,0)"
						<ww:if test="giftcatalog.language==0">class="add"</ww:if>><img
						src="images/jian.gif" width="27px" height="26px;"
						align="absmiddle" style="margin-right: 15px;">简体</a></td>
					<td width="25%"><a href="#"
						onclick="addlanguage(<ww:property value="giftcatalog.ucode"/>,1)"
						<ww:if test="giftcatalog.language==1">class="add"</ww:if>><img
						src="images/fan.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">繁体</a></td>
					<td width="25%"><a href="#"
						onclick="addlanguage(<ww:property value="giftcatalog.ucode"/>,2)"
						<ww:if test="giftcatalog.language==2">class="add"</ww:if>><img
						src="images/ri.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">日语</a></td>
					<td><a href="#"
						onclick="addlanguage(<ww:property value="giftcatalog.ucode"/>,3)"
						<ww:if test="giftcatalog.language==3">class="add"</ww:if>><img
						src="images/yin.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
					<td width="100%" align="right"><a href="#" class="add"><img
						src="images/jian.gif" width="27px" height="26px;"
						align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>

		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">目录名称 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="name
						"
						value='<ww:property value="giftcatalog.name"/>'
						" style="width: 200px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">目录编码 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input ReadOnly="true" type="text" name="code " value='<ww:property value="str1"/>' " style="width: 100px" /></td>
				</tr>



				<!-- <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					父目录ID
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="parentid
						" value='<ww:property value="giftcatalog.parentid"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					父目录ID串
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="parentidstr
						" value='<ww:property value="giftcatalog.parentidstr
						"/>'" style="width: 300px" />
				</td>
		</tr>
	 	-->


				<tr>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">上级目录 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<div id='comboxWithTree'></div>
					</td>
					<input type="hidden" id="parentid" name="parentid"
						value='<ww:property value="giftcatalog.parentid"/>'
						style="width: 200px" />



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<select name="state" style="width: 100px;">
						<option
							<ww:if test="giftcatalog.state==0">selected="selected"</ww:if>
							value="0">启用</option>
						<option
							<ww:if test="giftcatalog.state==1">selected="selected"</ww:if>
							value="1">禁用</option>
					</select></td>
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">目录描述 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<textarea rows="3" cols="30" name="description"><ww:property
						value="giftcatalog.description" /></textarea></td>

				</tr>


				<!-- 支持多语言开始 替换对应的类名-->
				<ww:if test="giftcatalog.language>0">
					<input id="language" type="hidden" name="language"
						value="<ww:property value="giftcatalog.language"/>" />
				</ww:if>
				<ww:else>
					<input id="language" type="hidden" name="language" value="0" />
				</ww:else>
				<input id="ucode" type="hidden" name="ucode"
					value="<ww:property value="giftcatalog.ucode"/>" />

				<tr class="font-blue-xi">
					<td height="46" colspan="4" align="center">
					<div style="position: relative; width: 220px;"><input
						type="submit" class="button_d font-bai" value="提交" /> <input
						type="button" class="button_d font-bai"
						onclick="window.location.href='giftcatalog.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /> <ww:iterator
						value="actionMessages">
						<div id="tishi" style="position: absolute; top: -55px; left: 0px;"><img
							src="images/gg.png" width="149" height="60" /></div>
						<script type="text/javascript">
						setTimeout("showclose()",2000); 
						function showclose()
						{
							document.getElementById("tishi").style.display="none";
						}
					</script>
					</ww:iterator></div>
					</td>
				</tr>
				<!-- 支持多语言结束 -->
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


