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
<title><ww:if test="miscellaneous.id>0">编辑</ww:if><ww:else>新增</ww:else>客户经理杂项列表</title>

<style type="text/css">
.passtable{
border-collapse:collapse;
background-color:#d7e9fc;
border:none;
}
.passth{
border:solid #99CCFF 1px;
text-align: center;
}
.passtd{
border:solid #99CCFF 1px;
}
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>


<link href="<%=request.getContextPath() %>/style/base.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/text.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/Layout.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/style/mapcss.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="<%=request.getContextPath() %>/js/dialog.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/style/dialog.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery.tablePagination.0.2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript">
function customer(){
  $("#customer").dialog(
        {title:'添加联系人',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 550,
                height:400     
       });
       
       var agentid=$("#parentid").val();
       $("#customer").dialog("open");
       jQuery.post("miscellaneous!getUserlistByAgent.action",{agent:agentid},function(data){
       $("#customer").html(data);
       $('#divtable').tablePagination({});
		var ctable=Ext.fly("divtable");
		ctable.select("th").addClass("passth");
		ctable.select("td").addClass("passtd");


       });
 }
 function searchuser(){
   var username=$("#cuname").val();
   var agentid=$("#parentid").val();
  jQuery.post("miscellaneous!getUserlistByAgent.action",{agent:agentid,username:username},function(data){
       $("#customer").html(data);
       $('#divtable').tablePagination({});
		var ctable=Ext.fly("divtable");
		ctable.select("th").addClass("passth");
		ctable.select("td").addClass("passtd");


       });
 }
 
 function getCuname(id,name){
 $("#linkman").val(name);
 $("#cuid").val(id);
 $("#customer").dialog("close");
 }
</script>
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
	
	   comboxWithTree.setValue("<ww:property value="departname"/>");

       tree.on('click',function(node){           
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();  
            
       });    
	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();
			
		});
	
    comboxWithTree.render('comboxWithTree'); 

});
</script>
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
			test="miscellaneous.id>0">编辑</ww:if><ww:else>新增</ww:else>客户杂项费用</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form id="form1"
			action="miscellaneous!<ww:if test="miscellaneous.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>集团客户部门：</span></td>
						<td>
						<div id='comboxWithTree'></div>
					    <input type="hidden" id="parentid" name="s_department" value='<ww:property value="s_department"/>'"/>
					    </td>
					</tr>
					<tr>
						<td height="28" align="right"><span>联系人：</span></td>
						<td><input type="text" desc="联系人" onfocus="customer()"  id="linkman" class="validate[required]" 
							value='<ww:property value="getusername(miscellaneous.customerid)"/>'
							" style="width: 150px" />
							<input type="hidden" id="cuid" name="customerid" value="<ww:property value="miscellaneous.customerid"/>">
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>旅客姓名：</span></td>
						<td><input type="text"  id="name"  name="name"
							value='<ww:property value="miscellaneous.name"/>'
							" style="width: 150px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>费用：</span></td>
						<td><input type="text"   desc="费用"  id="price" class="validate[required],custom[onlyDouble]" name="price"
							value='<ww:property value="formatMoney_string(miscellaneous.price)"/>'
							" style="width: 150px" />元</td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>费用发生日期：</span></td>
						<td><input type="text" onfocus="WdatePicker()"  desc="费用发生日期"  id="spenddate" class="validate[required]" name="spenddate"
							value='<ww:property value="miscellaneous.spenddate"/>'
							" style="width: 150px" /></td>
					</tr>

					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><textarea name="description" cols="50" rows="5"><ww:property
							value="miscellaneous.description" /></textarea></td>
					</tr>







					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='miscellaneous.action?<ww:property value="url"/>';"
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
<div id="customer"  style="text-align:center;display:none; background-color:#fff;left:0px;"></div>

</body>
</html>


