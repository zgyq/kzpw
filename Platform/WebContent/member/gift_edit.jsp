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
<title><ww:if test="gift
		.id>0">编辑</ww:if><ww:else>新增</ww:else>礼品
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<!--添加礼品分类树 2011-12-27 高亮  -->
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
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

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(gift.giftcatalogid)"/>");

       tree.on('click',function(node){  
            comboxWithTree.setValue(node.text);  
            Ext.get('giftcatalogid').set({value:node.id});
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
	document.form1.action="gift!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->

</head>

<body>
<div id="member">
<form action="gift
		!<ww:if test="gift
		.id>0">edit.action?id=<ww:property value="gift
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="infotype.id>0">编辑</ww:if><ww:else>新增</ww:else>礼品</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="gift.id>0||gift.language>0">
				<!--<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="gift.ucode"/>,0)" <ww:if test="gift.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="gift.ucode"/>,1)" <ww:if test="gift.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="gift.ucode"/>,2)" <ww:if test="gift.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="gift.ucode"/>,3)" <ww:if test="gift.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				--></ww:if>
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
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品名称
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="name" value="<ww:property value="gift.name"/>" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品编号
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="giftcode" value="<ww:property value="gift.giftcode"/>" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
		 <td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				礼品品牌:<span style="color:red;">*</span>
		</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="brand" value="<ww:property value="gift.brand"/>" style="width: 300px" />
				</td>
				
				
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品图片
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="file" name="files" id="files" style="width: 300px">
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					旧所需积分
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="oldintegral" value="<ww:property value="gift.oldintegral"/>" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					所需积分
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="useintegral" value="<ww:property value="gift.useintegral"/>" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					是否在线
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<select name="online" style="width: 300px;">
					<option <ww:if test="gift.online==0">selected="selected"</ww:if> value="0">在线</option>
					<option <ww:if test="gift.online==1">selected="selected"</ww:if> value="1">下网</option>
					</select>
				</td>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品目录:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<div id='comboxWithTree'></div>
					</td>
				<input type="hidden" id="giftcatalogid" name="giftcatalogid"
						value='<ww:property value="gift.giftcatalogid"/>'
						style="width: 300px" />
				
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品概述
						:<span style="color:red;">*</span>
				</td>
				<td colspan="3" width="10%" height="30" align="left" class="table_color_l">
				<textarea rows="8" name="giftdesc" cols="80"><ww:property value="gift.giftdesc"/></textarea>
					<ww:if test="gift.picsrc != null ">
						<img src="<ww:property value="gift.picsrc"/>" width="100"/>
					</ww:if>
				</td>
		</tr>

		    
			<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="gift.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="gift.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="gift.ucode"/>"/>
			
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='gift.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
							
					</div>
							</td>
					</tr>
					<!-- 支持多语言结束 -->
		</table>
		</td>
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
</table>
</form>
</div>
</body>
</html>


	