<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@page import="com.opensymphony.xwork.ActionContext"%>
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全-V2.0</title>

<link href="<%=request.getContextPath() %>/style/base.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/text.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/bass.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/Layout.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>

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
       width:370,
	   tpl: "<tpl for='.'><div style='height:240px ; width:370px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"---所有---",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:true
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(s_department)"/>");

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

$(document).ready(function() {

$("#form2").validationEngine(
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
</head>
<body style="height:100%; margin: 0; padding: 0;"> 

<div class="box" style="height:100%;position:absolute;float:left; width: 99%;">
<table width="100%" cellpadding="0" cellspacing="0"
	align="center" >
	<tr>
		<td width="100%" colspan="2" height="29" class="box-bottom " style="background:url(images/top-bg.png) 0px -120px;"><b
			class="anse">&nbsp;&nbsp;会员查询</b></td>
	</tr>
	
	
	<tr><td colspan="2" style="height: 5px; line-height: 5px;">&nbsp;</td></tr>
	<tr>
	<td width="40%">
	<table border="0" class="box" cellpadding="0" cellspacing="0" width="98%" style="line-height: 22px; margin: 0 auto">
	<tr>
	<td bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>注册网站会员</b></div></td></tr>
	<tr>
	 <td >
	 
	 <form name="form2" id="form2" method="post" action="login!createuserbyorder.action">
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  style="border-collapse:collapse; margin: 0 auto; " bordercolor="#a0cfee">
    <tr>
    <td style="padding: 0" width="100" height="35" valign="middle"  align="right">姓名：</td>
    <td style="padding: 0"><input type="text" id="name" desc="姓名" style="width:120px;" class="validate[required]" name="customeruser.membername"/></td>
    </tr>
    <tr>
    <td style="padding: 0" align="right">手机号码：</td>
    <td style="padding: 0" height="35"><input style="width:120px;" type="text" id="mobile" name="customeruser.mobile" desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxMobile]]"/></td>
    <td><input id="submitreg" type="submit" name="button" id="button" class="button108"  value="注册" /></td>
    </tr>
    </table>
    </form>
    
     </td>
     </tr>
     </table>
     </td>
     <td>
     <table border="0" class="box" cellpadding="0" cellspacing="0" width="98%" style="line-height: 22px; margin: 0 auto">
      <tr><td bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>会员预订</b></div></td></tr>
	<tr>
	 <td>
	 
	 <form name="form1" method="post" action="login!getMemberByOrder.action">
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  style="border-collapse:collapse; margin: 0 auto; " bordercolor="#a0cfee">
    <tr>
    <td style="padding: 0" height="35" width="80" valign="middle"  align="right">姓名：</td>
    <td ><input style="width:120px;" type="text" name="customeruser.membername" value="<ww:property value="customeruser.membername"/>"/></td>
    <td style="padding: 0" align="right" width="100" >手机号码：</td>
    <td><input style="width:120px;" type="text" name="customeruser.mobile" value="<ww:property value="customeruser.mobile"/>" /></td>
    <td></td>
    </tr>
    <tr>
    <td style="padding: 0" height="35"  valign="middle"  align="right">公司部门：</td>
    <td colspan="3"><div id='comboxWithTree'></div>
    <input type="hidden" id="parentid" name="s_department" value='<ww:property value="s_department"/>'"/>
    </td>
    <td><input type="submit" name="button" id="button" class="button108" value="查询" /></td>
    </tr>
    </table>
    </form>
    
     </td>
     </tr>
     </table>
     
     </td>
     
     
     
     </tr>
    
     <tr>
     <td colspan="2" style="padding-top: 10px;">
     

 <table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse; line-height:24px;">
<tr bgcolor="#d7e9fc">
	<td  bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b >姓名</b></div></td>
	<td  bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>登录名</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>手机号</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>公司</b></div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>部门</b></div></td>
    <td bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%;  text-align: center;" ><b>操作</b></div></td>
</tr>
<ww:iterator value="listCustomeruser">
<tr >
	<td style="color: #999"><ww:property value="membername"/></td>
    <td style="color: #999"><ww:property value="loginname"/></td>
    <td style="color: #999"><ww:property value="mobile"/></td>
    <td style="color: #999"><ww:if test="agentid==46">网站会员</ww:if><ww:else><ww:property value="getorderusercompanybyid(agentid)"/></ww:else></td>
    <td style="color: #999"><ww:if test="agentid==46">无</ww:if><ww:else><ww:property value="getorderuserdepartmentbyid(deptid)"/></ww:else></td>
    <%
    String orderurl=(String)ActionContext.getContext().getSession().get("orderUrl");
    if(orderurl!=null&&orderurl.trim().length()>0)
    {
    	%>
    	 <td style="text-align: center;"><a style="color:#06F;" href="airsearch!toimportpnr.action?orderuserid=<ww:property value="id"/>&forword=0">PNR导入</a></td>
    	<%
    }else
    {
    	%>
    	 <td style="text-align: center;"><a style="color:#06F;" href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=1" class="lan_xia">机票预订</a>
    	 <!--
    	 <a href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=2" class="lan_xia">酒店预订</a>
    	 <a href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=3" class="lan_xia">旅游预订</a>
    	 -->
    	 </td>
    	<%
    }
    %>
   </tr>
</ww:iterator>
<tr>
	<td colspan="6" height="43" align="center"><ww:property value="getPagination('\"login!getMemberByOrder.action?pageinfo.pagenum=\"+pageno')" /></td>
</tr>
</table>
     
     </td>
     </tr>
     
     </table>


</div>

</body>
</html>

</body>
</html>
