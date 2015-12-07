<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="java.util.*"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册会员转为大客户会员</title>


<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
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
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();              
       });     	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();//是否展开子菜单			
		});
	
    comboxWithTree.render('comboxWithTree'); 
});
</script>

</head>
<script type="text/javascript">
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
$("#membercardnunber").val("");
}else{
$("#membercardnunber").val(cardnono);
}
}
</script>
<script>
$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});


function form_validate() {
	var validate = true ;
	
	
	var shou = document.getElementById("hidshouji").value;
	if(shou==1){
	validate = false ;
	}

		
		
		
	membername = document.getElementById('membername');
		if(membername.value=="") {
			document.getElementById("membername2").innerHTML="*姓名不能为空";
			membername.focus();
			validate = false ;
		} else {
			document.getElementById("membername2").innerHTML="*";
		}
		
		
		
	
		
		
		membermobile = document.getElementById('membermobile');
		if(membermobile.value=="") {
			document.getElementById("membermobile2").innerHTML="*移动电话不能为空";
			membermobile.focus();
			validate = false ;
		} else {
			document.getElementById("membermobile2").innerHTML="*";
		}	
		
		
		
		return validate;
}
function jiance()
{
      // alert(555);
		var username = $("#loginname").val();
			if (username=="")
			{
	   			document.getElementById("loginname2").innerHTML="*用户名不能为空";
	   		
   			 document.getElementById("hidname").value=1;
   				
			}else{
				 var pattern=/(([0-9]+[a-zA-Z]+)|([a-zA-Z]+[0-9]+))|([a-zA-Z])/; 
				if(!pattern.exec(username))
				 {
				 document.getElementById("loginname2").innerHTML="*用户名格式错误,应该为数字和字母组合";
				
				 document.getElementById("hidname").value=1;
				
				  
				 }
				 else 
				 {
				   $.post(
					"login!validateusername.action",{username:username},
					function(str1name)
					{
						if(str1name=="faname")
						{
						
								 document.getElementById("loginname2").innerHTML="*用户名可以注册";
				
									 document.getElementById("hidname").value=2;
				
						}else if (str1name=="trname")
						{
							 document.getElementById("loginname2").innerHTML="*用户名已经被注册了";
				
							 document.getElementById("hidname").value=1;
				
							
							$("#loginname").focus();
							
						}
					}
					);
				 }
		}
			        
		
	}
	
function checkshouji(){

var mobile = $("#membermobile").val();

 var pattern=/^(((1[0-9]{1}[0-9]{1}))+\d{8})$/; //输入正确的手机号码
 if(mobile==""){
     
 		document.getElementById("membermobile2").innerHTML="*手机号码不能为空";
 		document.getElementById("hidshouji").value=1;
				 		$("#membermobile").focus();
						//$("#membermobile").select();
 }else{
	 if(!pattern.exec(mobile) )
	 {
	  		document.getElementById("membermobile2").innerHTML="*手机号码格式错误";
 		document.getElementById("hidshouji").value=1;
				 		$("#membermobile").focus();
						//$("#membermobile").select();
	 }else{
	
	  
	   $.post(
				"login!validatemobile.action",{'usermobile':mobile},
				function(str1mobile)
				{
					if(str1mobile=="famobile")
					{
					document.getElementById("hidshouji").value=2;
						//document.form1.submit();
						document.getElementById("membermobile2").innerHTML="*手机号码可以注册";
						 
					}else if (str1mobile=="trmobile")
					{
						document.getElementById("membermobile2").innerHTML="*手机号码已经注册";
					
						//document.f1.username.value="";
						document.getElementById("hidshouji").value=1;
						$("#membermobile").focus();
						//$("#membermobile").select();
						 
					}
				}
				);
	 }
 }
 
 	
				
 	
 
 
}
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;注册会员转为大客户会员</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="customeruser!b2cUsertoBiguser.action" name="form1" id="form1" method="POST">
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td height="28" width="10%" align="right">
						<input type="hidden" name="id" value="<ww:property value="id"/>"/>
						</td>
						<td height="28" align="right"></td>
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>
					</tr>
					<tr>
						<td height="28" class="table_color colortrin"
							style="text-align: right"><span>所属大客户：</span></td>
						<td class="table_color_l"><span style="HEIGHT: 71px">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<div id='comboxWithTree' style=""></div>
								</td>
								<td><input type="text" style="width: 0px; border: 0px"
									id="parentid" desc="所属大客户" class="validate[required]"
									name="cusagentname" value='<ww:property value="cusagentname"/>' />
								</td>
								<td><span class="font-red">*</span></td>
							</tr>
						</table>
						</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>是否是管理员：</span></td>
						<td class="table_color_l"><select name="isadmin">
							<option value="2">否</option>
							<option value="1">是</option>
						</select></td>
					<tr>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>登录名：</span></td>
						<td class="table_color_l"><input type="text" name="loginname"
							id="loginname"
							mId="<ww:property value="customeruser.loginname"/>" desc="登录名"
							class="validate[length[6,15],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>'
							style="width: 150px" /> <span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>登陆密码：</span></td>
						<td class="table_color_l"><input type="password"
							name="logpassword" id="logpassword" value="" style="width: 150px" />



						<span id="logpassword2" class="font-red">*</span></td>
					</tr>


					<tr>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>姓名：</span></td>
						<td class="table_color_l"><input type="text"
							name="membername" id="membername" desc="姓名"
							class="validate[required]"
							value='<ww:property value="customeruser.membername"/>'
							style="width: 150px" /></td>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>性别：</span></td>
						<td class="table_color_l"><select name="membersex">
							<option value="男"
								<ww:if test="customeruser.membersex.indexOf('男')>-1">selected=selected</ww:if>>男</option>
							<option value="女"
								<ww:if test="customeruser.membersex.indexOf('女')>-1">selected=selected</ww:if>
								<ww:else>fsfsfs</ww:else>>女</option>
						</select></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>电子邮箱：</span></td>
						<td class="table_color_l">
							<input type="text" name="memberemail" id="memberemail"
								mId="<ww:property value="customeruser.memberemail"/>"
								value='<ww:property value="customeruser.memberemail"/>'
								desc="电子邮箱"
								class="validate[required,custom[email],ajax[ajaxEmail]]"
								style="width: 150px" />
						<span id="memberemail2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>移动电话：</span></td>
						<td class="table_color_l">
							<input type="text" name="mobile" id="membermobile"
								value='<ww:property value="customeruser.mobile"/>'
								mId="<ww:property value="customeruser.mobile"/>" desc="手机号码"
								class="validate[required,custom[mobile],ajax[ajaxMobile]]"
								style="width: 150px" />
						 <span id="membermobile2" class="font-red">*</span></td>
					</tr>


					<tr>

						<td class="table_color colortrin" style="text-align: right"><span>证件类型：</span></td>
						<td class="table_color_l"> <select id="cardtype" name="credittype">
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
						<td class="table_color_l"><input type="text"
							name="creditnumber" id="membercardnunber"
							value='<ww:property value="customercredit.creditnumber"/>'
							desc="证件号码" class="validate[required]" style="width: 150px" /><span
							id="creditnumber2" class="font-red">*</span></td>
					</tr>


					<tr>
						<td height="28" align="right" class="table_color colortrin"
							style="text-align: right"><span>备注：</span></td>
						<td class="table_color_l"><input type="text"
							name="description" id="description"
							value='<ww:property value="customeruser.description"/>'
							style="width: 150px" /></td>
							<td></td><td></td>
					</tr>

					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" align="center">
						<input type="submit" id="submitreg" class="button_d font-bai" value="提交" />
						<input type="button" class="button_d font-bai"
							onclick="window.history.go(-1)" name="Submit2" value=" 返回 " /></td>
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
		</td>
	</tr>
</table>
</div>
</body>
</html>


