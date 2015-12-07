<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档1</title>
<link type="text/css" rel="Stylesheet" href="Common.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
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

<script type="text/javascript">

$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			});
			
});

var array1=new Array();
<%
Map<Integer,String> ccmp=(Map<Integer,String>)request.getAttribute("ccmap");
if(ccmp!=null&&ccmp.size()>0){
	Iterator iterator=ccmp.keySet().iterator();
	while(iterator.hasNext()){
		int key=(Integer)iterator.next();
		String value=ccmp.get(key);
		%>		
		array1[<%=key%>]='<%=value%>';
		<%		
	}	
}

%>
function cardChange(){
var cardtype=$("#cardtype").val();
var cardnono=array1[cardtype];
if(typeof(cardnono)=='undefined'){
$("#cardno").val("");
}else{
$("#cardno").val(cardnono);
}
}
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
       width:200,
	   tpl: "<tpl for='.'><div style='height:240px ; width:370px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });   
	<ww:property value="deptstr"/>
	
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


<script>
function form_validate() {

		var validate = true ;

	loginname = document.getElementById('loginname');
		if(loginname.value=="") {
			document.getElementById("loginname2").innerHTML="*登录名不能为空";
			loginname.focus();
			validate = false ;
		} else {
			document.getElementById("loginname2").innerHTML="*";
		}
	logpassword = document.getElementById('logpassword');
		if(logpassword.value=="") {
			document.getElementById("logpassword2").innerHTML="*登录密码不能为空";
			logpassword.focus();
		
			validate = false ;
		} else {
			document.getElementById("logpassword2").innerHTML="*";
		}
	membername = document.getElementById('membername');
		if(membername.value=="") {
			document.getElementById("membername2").innerHTML="*姓名不能为空";
			membername.focus();
			validate = false ;
		} else {
			document.getElementById("membername2").innerHTML="*";
		}
		
		mobile = document.getElementById('mobile');
		if(mobile.value=="") {
			document.getElementById("mobile2").innerHTML="*手机不能为空";
			mobile.focus();
			validate = false ;
		} else {
			document.getElementById("mobile2").innerHTML="*";
		}	
		
		memberdesc = document.getElementById('memberdesc');
		if(memberdesc.value=="") {
			document.getElementById("memberdesc2").innerHTML="*备注不能为空";
			memberdesc.focus();
			validate = false ;
		} else {
			document.getElementById("memberdesc2").innerHTML="*";
		}		
		return validate;
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;添加运营商员工</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post"
			action="customeruser!<ww:if test="#request.edit==null">addyunys.action</ww:if><ww:else>edityy.action?id=<ww:property value='customeruser.id'/></ww:else>">
		<input type="hidden" value="<ww:property value="forward" />"
			name="forward" />
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


						<td height="28" align="right" class="table_color colortrin"><span>登录名：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="text" name="loginname" id="loginname"
								mId="<ww:property value="customeruser.loginname"/>" desc="登录名"
								class="validate[length[6,50],ajax[ajaxUsername]]"
								value='<ww:property value="customeruser.loginname"/>'
								style="width: 150px" />
						</ww:if><ww:else>
							<input type="text" name="loginname" id="loginname" desc="登录名"
								class="validate[length[6,50],ajax[ajaxUsername]]"
								value='<ww:property value="customeruser.loginname"/>'
								style="width: 150px" />
						</ww:else> <span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>登陆密码：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="password" require="true" dataType="Require"
								msg="登陆密码不能为空" name="logpassword" value="" style="width: 150px" />
						</ww:if><ww:else>
							<input type="password" require="true" dataType="Require"
								msg="登陆密码不能为空" name="logpassword" id="logpassword" desc="密码"
								class="validate[length[6,50]"
								value='<ww:property value="customeruser.logpassword"/>'
								" style="width: 150px" />
						</ww:else> <span id="logpassword2" class="font-red">*</span></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin">
						<span>姓名：</span></td>
						<td class="table_color_l"><input type="text" require="true"
							dataType="Require" msg="姓名不能为空" name="membername" id="membername"
							value='<ww:property value="customeruser.membername"/>'
							" style="width: 150px" /><span id="membername2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>性别：</span></td>
						<td class="table_color_l"><select name="membersex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="性别不能为空" name="membersex" value='<ww:property value="customeruser.membersex"/>'" style="width:150px" />
	 --></td>
					</tr>



					<tr>


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
						<td height="28" align="right" class="table_color colortrin"><span>手机号：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.id>0">
							<input type="text" name="mobile" id="membermobile"
								value='<ww:property value="customeruser.mobile"/>'
								mId="<ww:property value="customeruser.mobile"/>" desc="手机号码"
								class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
								style="width: 150px" />
						</ww:if> <ww:else>
							<input type="text" name="mobile" id="membermobile"
								value='<ww:property value="customeruser.mobile"/>' desc="手机号码"
								class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
								style="width: 150px" />
						</ww:else> <span id="mobile2" class="font-red">*</span></td>
					</tr>




					<tr style="display: none">
						<td height="28" align="right" class="table_color colortrin"><span>证件类型：</span></td>
						<td class="table_color_l"><input type="hidden"
							name="strCusID" value="<ww:property value="customeruser.id"/>" />
						<select id="cardtype" name="cardType"
							<ww:if test="#request.edit!=null">onchange="cardChange()"</ww:if>>
							<option value="1"
								<ww:if test="customercredit.credittypeid==1">selected</ww:if>>身份证</option>
							<option value="2"
								<ww:if test="customercredit.credittypeid==2">selected</ww:if>>驾驶证</option>
							<option value="3"
								<ww:if test="customercredit.credittypeid==3">selected</ww:if>>护照</option>
							<option value="4"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>港澳通行证</option>
							<option value="5"
								<ww:if test="customercredit.credittypeid==5">selected</ww:if>>台湾通行证</option>
							<option value="6"
								<ww:if test="customercredit.credittypeid==6">selected</ww:if>>台胞证</option>
							<option value="7"
								<ww:if test="customercredit.credittypeid==7">selected</ww:if>>回乡证</option>
							<option value="8"
								<ww:if test="customercredit.credittypeid==8">selected</ww:if>>其他</option>
						</select></td>

						<td height="28" align="right" class="table_color colortrin"><span>证件号码：</span></td>
						<td class="table_color_l"><input id="cardno" type="text"
							name="s_cardnunber" id="creditnumber"
							value='<ww:property value="customercredit.creditnumber"/>'
							" style="width: 150px" /><span id="creditnumber2"
							class="font-red">*</span></td>
					</tr>

					<tr>

						<td height="28" align="right" class="table_color colortrin"><span>是否启用：</span></td>
						<td class="table_color_l"><select name="isenable">
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>启用</option>
							<option value="2"
								<ww:if test="customeruser.isenable==0">selected</ww:if>>禁用</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="是否启用不能为空" name="isenable" value='<ww:property value="customeruser.isenable"/>'" style="width:150px" />
	 --></td>


						<td height="28" align="right" class="table_color colortrin"><span>所属部门：</span></td>
						<td class="table_color_l">
						<div id='comboxWithTree'></div>
						<input type="hidden" id="parentid" name="agendept"
							value='<ww:property value="customeruser.deptid"/>'
							" style="width: 150px" /></td>



					</tr>



					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>备忘说明：</span></td>
						<td class="table_color_l" colspan="3"><input type="text" require="true" style="width:420px;height:80px"
							dataType="Require" msg="备忘录不能为空" name="memberdesc"
							id="memberdesc"
							value='<ww:property value="customeruser.memberdesc"/>'
							" style="width: 150px" />
							<!-- 暂时不用，隐藏起来 -->
						    <select name="isadmin" style="display:none">
							<option value="2"
								<ww:if test="customeruser.isadmin==2">selected</ww:if>>否</option>
							<option value="1"
								<ww:if test="customeruser.isadmin==1">selected</ww:if>>是</option>
						</select>
						<!-- 暂时不用，隐藏起来 -->
						</td>
					</tr>



					<!--
	
				 
 
	 <tr><td height="28" align="right"><span>所属加盟商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="所属加盟商ID不能为空" name="agentid" value='<ww:property value="customeruser.agentid"/>'" style="width:150px" /></td>  </tr>
	
				 
      
   	    
      
      -->
					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" align="center"><input
							type="submit" class="button_d font-bai" value="提交" id="submitreg" />
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
					<li>联系电话可为办公电话 也可为移动电话</li>
					<li>启用/禁用选择:</li>
					<li style="list-style: none; padding-left: 30px;">启用 该帐户可以登录系统</li>
					<li style="list-style: none; padding-left: 30px;">禁用
					该帐户不可以登录系统</li>
					<li><span class="font-red-xi">授权选择:可进入权限选择页面</span></li>
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
