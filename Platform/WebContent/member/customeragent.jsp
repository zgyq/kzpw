<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:property value="#request.typestr"/>信息表列表</title>
<link href="style/base.css" rel="stylesheet" />
<!-- ExtJS library -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/extjs/3.2.1/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/extjs/3.2.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/extjs/3.2.1/ext-all.js"></script>

<!-- EditTreeGrid library -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/edittreegrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/edittreegrid-pkg-debug.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/resources/edittreegrid.css" />


<!-- page specific -->

<script type="text/javascript">
//以下信息获取当前登录信息，用于对列表中某系权限进行控制
var loginagent=new Object();
 loginagent.id=<ww:property value="getLoginsessionagent().id"/>;
 loginagent.agenttype=<ww:property value="getLoginsessionagent().agenttype"/>;
 loginagent.openext=<ww:property value="getLoginsessionagent().allowlevelcount"/>;
 loginagent.agentlevel=<ww:property value="getLoginsessionagent().agentjibie"/>;
 var agentlevel=<ww:property value="getLoginsessionagent().agentjibie"/>;
 
 var agentnextlevel='<ww:property value="getAgentTypeName(getNextlevelByAgent(getLoginsessionagent()))"/>';
 //按钮控制
 //['open','updagent','deltagent','liudianshezhi','recharge','dns'], //recharge=5 充值去掉 'employee'=员工管理
 //['下级开户' ,"修改","删除","留点设置","充值","域名绑定"]


<ww:if test="#application.vmoneyservice==null">
   if(loginagent.openext!=0||loginagent.agenttype==1){
  var menukey=new Array('open','updagent','deltagent','liudianshezhi','dns','employee');
  var menuval=new Array('下级开户' ,'修改','删除','留点设置','域名绑定','员工信息');
  }else{
  var menukey=new Array('updagent','deltagent','liudianshezhi','dns','employee');
  var menuval=new Array('修改','删除','留点设置','域名绑定','员工信息');
  }
 </ww:if>
 <ww:else>

  if(loginagent.openext!=0||loginagent.agenttype==1){
    if(loginagent.agenttype==1){
     <ww:if test="checkright('addmoney')==true">
     var menukey=new Array('open','updagent','deltagent','liudianshezhi','recharge','employee');
     var menuval=new Array('下级开户' ,'修改','删除','留点设置','充值','员工信息');
     </ww:if>
     <ww:else>
     var menukey=new Array('open','updagent','deltagent','liudianshezhi','employee');
     var menuval=new Array('下级开户' ,'修改','删除','留点设置','员工信息');
     </ww:else>
  }else{
     var menukey=new Array('open','updagent');
     var menuval=new Array('下级开户' ,'修改');
  }
 }else{
  var menukey=new Array('updagent');
  var menuval=new Array('修改');
 
 }
 </ww:else>
 
<ww:if test="getLoginsessionagent().agenttype!=1">
  menukey=new Array('updagent','employee','liudianshezhi');
  menuval=new Array('修改','员工信息');
</ww:if>


function subForm(){ 
 var isable=Ext.getDom("c1").value;
 Ext.getDom("enablestate").value=isable;
 var type=Ext.getDom("atype").value;
 Ext.getDom("agenttype").value=type;

 document.agentform.submit();
}
function sub(page){ 

document.getElementById("page").value=page;
 document.agentform.submit();
}
Ext.onReady(function(){
<ww:if test="#request.message!=null">
Ext.MessageBox.alert('提示','<ww:property value="#request.message"/>');
</ww:if>

});
</script>
<style>
.body {
	font-family: helvetica, tahoma, verdana, sans-serif;
	padding-left:10px;
	font-size: 13px;
	background-color: #fff !important;
}
</style>
</head>

<body>

<input type='hidden' id='agentname' value='<ww:property value="customeragent.agentcompanyname" />' />
<input type='hidden' id='enablestate' value='<ww:property value="enablestate" />' />
<input type='hidden' id='agenttype' value='<ww:property value="customeragent.agenttype"/>' />
<div id="member" style="padding-left: 0px">
<form action="customeragent.action" name='agentform' id="agentform" method="post">
<input type="hidden" name="page" id='page' value='<ww:property value="page"/>' />
<input type="hidden" id='maxrow' value='<ww:property value="#request.maxrow"/>' />
<input type="hidden" id='maxpage' value='<ww:property value="#request.maxpage"/>' />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	 class="box" style="text-align: center;padding-left: 0px">
	<tr>
		<td width="100%" height="29" class="box-bottom bg" align="left"><b
			class="anse">
			<span class="font-blue-cu">&nbsp;&nbsp;&nbsp;
			<ww:property value="#request.typestr"/>信息表列表
			</span></b>
			<input type="hidden" id="hidurl" value="customeruser!toDistrUsersList.action?compnayid=" />
			</td>
	</tr>
	<tr>
	<td width="100%" align="center">
	<table style="padding-top: 20px" width="60%">
	<tr>
	<td align="right" width="80px">加盟商名称:</td>
	<td align="left">
	<input type="hidden" id="atype" name="agenttype" value='<ww:property value="customeragent.agenttype" />' />
	<input id='aname' style="width: 120px;" name='agentcompanyname'  value='<ww:property value="customeragent.agentcompanyname" />'/></td>
	
	<td align="right" width="50px">联系人:</td>
	<td align="left">
	<input id='linkname' style="width: 80px;" name='agentlinkname'  value='<ww:property value="agentlinkname" />'/></td>
	
	<td align="right" width="50px">用户名:</td>
	<td align="left">
	<input id='username' style="width: 80px;" name='agentusernamename'  value='<ww:property value="agentusernamename" />'/></td>
	<td align="right"  width="60px">启用状态:</td>
	<td align="left">
	<select style="width: 150px" id='c1' name='enablestate'>
	<option value="-1" <ww:if test="enablestate==-1">selected="selected"</ww:if> ></option>
	<option value='1' <ww:if test="enablestate==1">selected="selected"</ww:if> >启用</option>
	<option value='0' <ww:if test="enablestate==0">selected="selected"</ww:if>>禁用</option>
	</select>
	</td>
	</tr>
	<tr><td colspan="4" align="center">
	<input type="button" onclick="subForm()" class="button_d font-white"  value="查&nbsp;&nbsp;询" />
	</td></tr>
	</table>
	
	</td>
	</tr>
	<tr>
	<td style="text-align: center;padding-left: 10px">
	<div id="treediv" style="text-align: center;"></div>
	<div align="center">
	<!--
	<ww:property value="getPagination('\"customeragent.action?pageinfo.pagenum=\"+page+\"\"')"/>
	 -->
	  <span><a href="javascript:sub(0);">首页</a></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	 <span><a href="javascript:sub(<ww:property value="page-1" />);">上一页</a></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	 <span><a href="javascript:sub(<ww:property value="page+1" />);">下一页</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	  <span><a href="javascript:sub(-9999);">尾页</a></span> 
	
	</div>
	</td>
	
	</tr>
</table>
</form>
</div>

</body>
</html>
