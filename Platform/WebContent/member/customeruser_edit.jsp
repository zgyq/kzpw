<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="java.util.*" %>
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" type="text/css" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="customeruser.id>0">编辑</ww:if><ww:else>新增</ww:else>会员</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<ww:if test="getLoginUserAgent().agenttype==1">
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
	<ww:property value="#request.agentroot"/>
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text);  
            Ext.get('vpid').set({value:" "});
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
</ww:if>
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="customeruser.id>0">编辑</ww:if><ww:else>新增</ww:else>会员</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeruser!<ww:if test="customeruser.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" id="form1" method="POST" 
			>


<table width="99%" border="0" cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>

					</tr><tr>


						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>登录名：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="loginname" id="loginname"  mId="<ww:property value="customeruser.loginname"/>" desc="登录名" class="validate[length[6,15],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="loginname" id="loginname" desc="登录名" class="validate[length[6,50],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:else>
						
							
							<span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>登陆密码：</span></td>
						<td class="table_color_l">
					
						<input type="password" name="logpassword" id="logpassword"
							value=""
							style="width: 150px" />
						
						
							
							<span id="logpassword2" class="font-red">*</span></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>姓名：</span></td>
						<td class="table_color_l"><input type="text" name="membername" id="membername" desc="姓名" class="validate[required]"
							value='<ww:property value="customeruser.membername"/>'
							style="width: 150px" /></td>
						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>性别：</span></td>
						<td class="table_color_l">
						<select name="membersex">
							<option value="男" <ww:if test="customeruser.membersex.indexOf('男')>-1">selected=selected</ww:if>>男</option>
							<option value="女" <ww:if test="customeruser.membersex.indexOf('女')>-1">selected=selected</ww:if><ww:else>fsfsfs</ww:else>>女</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="性别不能为空" name="membersex" value='<ww:property value="customeruser.membersex"/>'" style="width:150px" />
	 --></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>电子邮箱：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="memberemail" id="memberemail"   mId="<ww:property value="customeruser.memberemail"/>"
							value='<ww:property value="customeruser.memberemail"/>'  desc="电子邮箱" class="validate[required,custom[email],ajax[ajaxEmail]]"
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="memberemail" id="memberemail" 
							value='<ww:property value="customeruser.memberemail"/>' desc="电子邮箱" class="validate[required,custom[email],ajax[ajaxEmail]]"
							style="width: 150px" />
						</ww:else>
						<span id="memberemail2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>移动电话：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>'  mId="<ww:property value="customeruser.mobile"/>" desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxMobile]]"
							style="width: 150px"  />
						</ww:if>
						<ww:else>
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>' desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxMobile]]"
							style="width: 150px"  />
						</ww:else>
						
							
							
							
							<span id="membermobile2" class="font-red">*</span></td>
					</tr>
					
					
					<tr style="display:none">
					
					<td class="table_color colortrin" style=" text-align: right"><span>证件类型：</span></td>
					<td class="table_color_l">
					<input type="hidden"  name="ISWEB" value="<ww:property value="ISWEB"/>"/>
					<input type="hidden" name="strCusID" value="<ww:property value="customeruser.id"/>"/>
					<select id="cardtype" name="cardType" <ww:if test="customeruser.id>0">onchange="cardChange()"</ww:if> >
							<option  value="1"
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
						</select>

                     </td>
                    <td height="28" align="right" class="table_color colortrin"><span>证件号码：</span></td>
						<td class="table_color_l">							
							<input type="text" name="s_cardnunber" id="membercardnunber"
							value='<ww:property value="customercredit.creditnumber"/>' 
							style="width: 150px"  /><span id="creditnumber2" class="font-red">*</span>
							
							</td>
					</tr>


					<tr>
						<!--<td height="28" align="right" class="table_color colortrin"><span>座机号：</span></td>
						<td class="table_color_l"><input type="text" name="membermobile" id="mobile"
							value='<ww:property value="customeruser.membermobile"/>'
							style="width: 150px"  /><span id="mobile2" class="font-red"></span></td>
						-->
						<span <%if(session.getAttribute("ISWEB")!=null){%> style=" display: none"<%} %>>
						<td height="28" align="right" class="table_color colortrin" style=" text-align: right" ><span>是否启用：</span></td>
						<td class="table_color_l"><select name="isenable">
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>启用</option>
							<option value="2"
								<ww:if test="customeruser.isenable==2">selected</ww:if>>禁用</option>
						</select>
						</td>
						</span>
						
						<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>所属代理：</span></td>
						<td>
						<ww:if test="getLoginUserAgent().agenttype==1">
						<div id='comboxWithTree'></div><input id='vpid' class="validate[required]" style="border: 0px;width:0px;height;0px;float:left"/>
		                <input type="hidden" id="parentid"  name="agentid" value='<ww:property value="customeruser.agentid"/>'
						 style="width: 350px" />
						
						</ww:if>
						<ww:else>
					
						<input type="hidden" name="agentid" value='<ww:property value="getLoginUserAgent().id"/>'/>
						<ww:property value="getagentname_b2bback(getLoginUserAgent().id)"/>
						</ww:else>
						</td>
						
							
							</tr>	
							<tr>
							<td height="28" align="right" class="table_color colortrin" style=" text-align: right"><span>备注：</span></td>
					
						<td class="table_color_l" colspan="3"><input type="text" name="description" id="description"
							value='<ww:property value="customeruser.description"/>' 
							style="width: 150px"  />
						</td>
							</tr>				

					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" align="center"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.history.go(-1)" 
							name="Submit2" value=" 返回 " /></td>
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
			<li style="list-style: none; padding-left: 30px;">禁用 该帐户不可以登录系统</li>
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


