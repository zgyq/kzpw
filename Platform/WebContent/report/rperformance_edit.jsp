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
<title><ww:if test="rperformance.id>0">编辑</ww:if><ww:else>新增</ww:else>绩效合约统计</title>

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
<script language="JavaScript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<script>
Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',
       maxHeight: 240, 
       width:350,
	   tpl: "<tpl for='.'><div style='height:240px ; width:350px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn   
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(rperformance.department)"/>");

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
	


});</script>
<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine();
		
		});
	</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="rperformance.id>0">编辑</ww:if><ww:else>新增</ww:else>绩效合约统计</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form id="form1"
			action="rperformance!<ww:if test="rperformance.id>0">edit.action?id=<ww:property value="rperformance.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" >



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>T1(万元)：</span></td>
						<td><input type="text" desc="T1(万元)"  id="t1" class="validate[required],custom[onlyDouble]" name="low"
							value='<ww:property value="rperformance.low"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>T2(万元)：</span></td>
						<td><input type="text" desc="T2(万元)"  id="t2" class="validate[required],custom[onlyDouble]" name="normal"
							value='<ww:property value="rperformance.normal"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>T3(万元)：</span></td>
						<td><input type="text" desc="T3(万元)"  id="t3" class="validate[required],custom[onlyDouble]" name="high"
							value='<ww:property value="rperformance.high"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>部门：</span></td>
						<td>
						<div id='comboxWithTree'></div>
										<input type="hidden" id="parentid" name="department" value='<ww:property value="rperformance.department"/>'/>
						</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>类型：</span></td>
						<td><select name="type">
							<option value="1" <ww:if test="rperformance.type==1"> selected="selected"</ww:if>>销售收入万元</option>
							<option value="2" <ww:if test="rperformance.type==2"> selected="selected"</ww:if>>毛利指标万元</option>
							<option value="3" <ww:if test="rperformance.type==3"> selected="selected"</ww:if>>东航直销万元</option>
							</select></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>时间：</span></td>
						<td><input type="text" desc="时间"  id="datetime" class="validate[required]" name="i_date" onfocus="WdatePicker({dateFmt:'yyyy-MM'})"
							value='<ww:property value="i_date"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='rperformance.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /><span style="color: red;"><ww:property value="fieldErrors.error"/></span></td>
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


