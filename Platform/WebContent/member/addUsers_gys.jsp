<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="customeruser.id>0">编辑</ww:if><ww:else>新增</ww:else>员工</title>
<link type="text/css" rel="Stylesheet" href="Common.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>

<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-all.js"></script>


</head>
<script>

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
function checang(){
 var angid = $("#agentid").val();
 //alert(angid);
var url="customeruser!getangdep.action?angid="+angid;
var params = {s_status:2};
jQuery.post(url,params, function(data) {
		
			if (data != '') {
		if(data!='no'){
			//	alert(data);
				var listid=new Array();
				var listname=new Array();				
				var idname = data.split("/");				
				var liid = idname[0];
				var liname = idname[1];				
				listid=liid.split(",");
				listname=liname.split(",");
					var dhtml ="<select name='deptid'>";
					
							for(var a=0;a<listid.length;a++){
								if(listid[a]!=''){
								//alert(listid[a]);
								//alert(listname[a]);
								//alert(dhtml)
								dhtml+= "<option value='"+listid[a]+"'>"+listname[a]+"</option>";
								//alert(dhtml)
								}
							}
					dhtml+= "</select>";
					//alert(dhtml)
					document.getElementById("ajaxdep").innerHTML=dhtml;
				}else{
				
				document.getElementById("ajaxdep").innerHTML="暂无部门信息";
				}
				
			}
			
		});

}
function trim(str)
{
     return str.replace(/(^\s*)|(\s*$)/g,'');
}

function form_validate() {

		var validate = true ;
		
//		cardnumber = document.getElementById('cardnumber');
//		if(cardnumber.value=="") {
//			document.getElementById("cardnumber2").innerHTML="*用户卡号不能为空";
//			cardnumber.focus();
//			validate = false ;
//		} else {
//			document.getElementById("cardnumber2").innerHTML="*";
//		}
//		cardpassword = document.getElementById('cardpassword');
//		if(cardpassword.value=="") {
//			document.getElementById("cardpassword2").innerHTML="*用户卡密码不能为空";
//			cardpassword.focus();
//			validate = false ;
//		} else {
//			document.getElementById("cardpassword2").innerHTML="*";
//		}
		
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
			if(membername.value.length >10){
				document.getElementById("membername2").innerHTML="*姓名长度不能超过50个字符";
				membername.focus();
			validate = false ;
			}else{
			document.getElementById("membername2").innerHTML="*";
			}
		}		
	memberemail = document.getElementById('memberemail');
	
		if(memberemail.value=="") {
			document.getElementById("memberemail2").innerHTML="*电子邮箱不能为空";
			memberemail.focus();
			validate = false ;
		} else {
		 var patemail=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //email验证
				if(!patemail.exec(memberemail))
							 		{
					            	document.getElementById("memberemail2").innerHTML="*电子邮箱格式错误";
										memberemail.focus();
									validate = false ;			
										 }else{
			document.getElementById("memberemail2").innerHTML="*";
			}
		}		
		membermobile = document.getElementById('membermobile');
		 var patmembermobile=/^\d{8,12}$/ ; //固定电话
		if(membermobile.value=="") {
			document.getElementById("membermobile2").innerHTML="*座机电话不能为空";
			membermobile.focus();
			validate = false ;
		} else {
					if(!patmembermobile.exec(membermobile) )
							 		{
					            	document.getElementById("membermobile2").innerHTML="*请输入正确的座机号码";
									membermobile.focus();
									validate = false ;	
										 }else{
					document.getElementById("membermobile2").innerHTML="*";
				}
		}	
		
		
		mobile = document.getElementById('mobile');
		var pattern=/^(((1[0-9]{1}[0-9]{1}))+\d{8})$/; //输入正确的手机号码
		if(mobile.value=="") {
			document.getElementById("mobile2").innerHTML="*手机不能为空";
			mobile.focus();
			validate = false ;
		} else {
		
							if(!pattern.exec(mobile))
							 		{
							 	
					            	 document.getElementById("mobile2").innerHTML="*手机格式错误";
									//	mobile.focus();
									validate = false ;				
										 }else{
									
			document.getElementById("mobile2").innerHTML="*";
			}
		}	
//		creditnumber = document.getElementById('creditnumber');
//		if(creditnumber.value=="") {
//			document.getElementById("creditnumber2").innerHTML="*证件号码不能为空";
//			creditnumber.focus();
//			validate = false ;
//		} else {
//			document.getElementById("creditnumber2").innerHTML="*";
//		}	
//		birthday = document.getElementById('birthday');
//		if(birthday.value=="") {
//			document.getElementById("birthday2").innerHTML="*生日不能为空";
//			birthday.focus();
	//		validate = false ;
//		} else {
//			document.getElementById("birthday2").innerHTML="*";
//		}		
		
		
//			localcity = document.getElementById('localcity');
//		if(localcity.value=="") {
//			document.getElementById("localcity2").innerHTML="*城市不能为空";
//			localcity.focus();
//			validate = false ;
//		} else {
//			document.getElementById("localcity2").innerHTML="*";
//		}	
		
		
	//		memberfax = document.getElementById('memberfax');
	//	if(memberfax.value=="") {
	//		document.getElementById("memberfax2").innerHTML="*传真不能为空";
	//		memberfax.focus();
	//		validate = false ;
	//	} else {
	//		document.getElementById("memberfax2").innerHTML="*";			
		return validate;
}


</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;<ww:if test="compnayid!=null"><ww:if test="customeruser.id>0">编辑</ww:if><ww:else>添加</ww:else>供应商员工(<span style="color:red;font-weight:bold;"><ww:property value="getagentname_b2bback(compnayid)"/></span>)</ww:if><ww:else><ww:if test="customeruser.id>0">编辑</ww:if><ww:else>添加</ww:else>供应商员工</ww:else></td>
  </tr>
  <tr>
    <td  valign="top">
  <form name="form1" id="form1" method="post" action="customeruser!<ww:if test="customeruser.id>0">editgongys.action?id=<ww:property value="id"/>&<ww:property value="url"/>&compnayid=<ww:property value="compnayid"/></ww:if><ww:else>addgongys.action?<ww:property value="url"/>&compnayid=<ww:property value="compnayid"/></ww:else>">
  	<input type="hidden" value="<ww:property value="forward" />" name="forward"/>
      <table width="99%" border="0" cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
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
						<td height="28" align="right" class="table_color colortrin"><span>所属供应商：</span></td>
						<td class="table_color_l" colspan="3"><ww:if test="compnayid!=null">
							<input type="hidden" value="<ww:property value="compnayid" />"
								name="strcompanyid" />
							<span style="color: red; font-weight: bold;"><ww:property
								value="getagentname_b2bback(compnayid)" /></span>
						</ww:if> <ww:else>
							<input type="hidden"
								value="<ww:property value="#session.loginuser.agentid" />"
								name="strcompanyid" />
							<span style="color: red; font-weight: bold"><ww:property
								value="getagentname_b2bback(#session.loginuser.agentid)" /></span>
						</ww:else></td>
					</tr>

					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>登录名：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="loginname" id="loginname"  mId="<ww:property value="customeruser.loginname"/>" desc="登录名" class="validate[length[6,50],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="loginname" id="loginname" desc="登录名" class="validate[length[6,50],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:else>
							
							<span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>登陆密码：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="password" require="true" dataType="Require"
							msg="登陆密码不能为空" name="logpassword" id="logpassword" desc="密码" 
							value="" style="width: 150px" />
						</ww:if><ww:else>
						<input type="password" require="true" dataType="Require"
							msg="登陆密码不能为空" name="logpassword" id="logpassword" desc="密码" class="validate[length[6,50]"
							value='<ww:property value="customeruser.logpassword"/>'
							" style="width: 150px" />
						</ww:else>
						
							
							<span id="logpassword2" class="font-red">*</span></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin"><span>姓名：</span></td>
						<td class="table_color_l"><input type="text" require="true" dataType="Require"
							msg="姓名不能为空" name="membername" id="membername"
							value='<ww:property value="customeruser.membername"/>'
							" style="width: 150px" /><span id="membername2" class="font-red"></span></td>
						<td height="28" align="right" class="table_color colortrin"><span>性别：</span></td>
						<td class="table_color_l"><select name="membersex">
							<option>男</option>
							<option>女</option>
						</select>
						</td>
					</tr>



					<tr>
						<td height="28" align="right" class="table_color colortrin">
							<span>手机号：</span>
						</td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>'  mId="<ww:property value="customeruser.mobile"/>" desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
							style="width: 150px"  />
						</ww:if>
						<ww:else>
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>' desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
							style="width: 150px"  />
						</ww:else>
							<span id="mobile2" class="font-red">*</span>
						</td>
						<td height="28" align="right" class="table_color colortrin"><span>电子邮箱：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="memberemail" id="memberemail"   mId="<ww:property value="customeruser.memberemail"/>"
							value='<ww:property value="customeruser.memberemail"/>' 
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="memberemail" id="memberemail" 
							value='<ww:property value="customeruser.memberemail"/>'
							style="width: 150px" />
						</ww:else>
							
						</td>
					</tr>



					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>是否启用：</span></td>
						<td class="table_color_l">
						<select name="isenable" >
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>启用</option>
							<option value="2"
								<ww:if test="customeruser.isenable==0">selected</ww:if>>禁用</option>
						</select>
						</td>
					
				<td height="28" align="right" class="table_color colortrin"><span <ww:if test='s_isview.equals("true")'>style="display:none"</ww:if>>是否是管理员：</span></td>
						<td class="table_color_l">
						
						<select name="isadmin" <ww:if test='s_isview.equals("true")'>style="display:none"</ww:if>>
							<option value="2"
								<ww:if test="customeruser.isadmin==2">selected</ww:if>>否</option>
							<option value="1"
								<ww:if test="customeruser.isadmin==1">selected</ww:if>>是</option>
						</select>
						</td>
				
					</tr>
				
			











					<!--
	
				 
 
	 <tr><td height="28" align="right"><span>所属加盟商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="所属加盟商ID不能为空" name="agentid" value='<ww:property value="customeruser.agentid"/>'" style="width:150px" /></td>  </tr>
	
				 
      
   	    
      
      -->
					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" align="center"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="history.back()"
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
    </form>
    </td>
   </tr>
   </table>
</div>
    
</body>
</html>
