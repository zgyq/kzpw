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
<title><ww:if test="customeruser.id>0">编辑</ww:if><ww:else>新增</ww:else>会员</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;新增员工</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeruser!addUsers.action?<ww:property value="url"/>"
			name="form1" method="POST"
			onsubmit="return Validator.Validate(this,3)">
			<input type="hidden" value="<ww:property value="forward"/>" name="forward" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>用户卡号：</span></td>
						<td><input type="text" name="cardnumber"
							value='<ww:property value="customeruser.cardnumber"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>用户卡密码：</span></td>
						<td><input type="text" name="cardpassword"
							value='<ww:property value="customeruser.cardpassword"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>登录名：</span></td>
						<td><input type="text" name="loginname"
							value='<ww:property value="customeruser.loginname"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>登陆密码：</span></td>
						<td><input type="text" name="logpassword"
							value='<ww:property value="customeruser.logpassword"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>姓名：</span></td>
						<td><input type="text" name="membername"
							value='<ww:property value="customeruser.membername"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>性别：</span></td>
						<td><select name="membersex">
							<option>男</option>
							<option>女</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="性别不能为空" name="membersex" value='<ww:property value="customeruser.membersex"/>'" style="width:350px" />
	 --></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>电子邮箱：</span></td>
						<td><input type="text" name="memberemail"
							value='<ww:property value="customeruser.memberemail"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>手机号：</span></td>
						<td><input type="text" name="mobile"
							value='<ww:property value="customeruser.mobile"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>证件类型：</span></td>
						<td><select name="credittype">
							<option value="1"
								<ww:if test="customercredit.credittypeid==1">selected</ww:if>>身份证</option>
							<option value="2"
								<ww:if test="customercredit.credittypeid==2">selected</ww:if>>护照</option>
							<option value="3"
								<ww:if test="customercredit.credittypeid==3">selected</ww:if>>军人证</option>
						</select> <!--<input type="text" require="true" dataType="Require"   msg="手机号不能为空" name="mobile" value='<ww:property value="customerpassenger.mobile"/>'" style="width:350px" />
 	--></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>证件号码：</span></td>
						<td><input type="text" name="creditnumber"
							value='<ww:property value="customercredit.creditnumber"/>'
							" style="width: 350px" /></td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="customeruser.state"/>'" style="width:350px" /></td>  </tr>
	 <tr><td height="28" align="right"><span>类型：</span></td><td>
	 <select name="type">
      <option value="1" <ww:if test="customeruser.type==1">selected</ww:if> >运营商</option>
   	 <option value="2" <ww:if test="customeruser.type==2">selected</ww:if> >供应商</option>
     <option value="3" <ww:if test="customeruser.type==3">selected</ww:if> >分销商</option>
     
    </select>(1=运营商,2=供应商,3=分销商)
    <!--
	 <input type="text" require="true" dataType="Require"   msg="类型(1=运营商,2=供应商,3=分销商)不能为空" name="type" value='<ww:property value="customeruser.type"/>'" style="width:350px" />
	 -->
					<tr>
						<td height="28" align="right"><span>是否是管理员：</span></td>
						<td><select name="isadmin">
						<option value="2"
								<ww:if test="customeruser.isadmin==2">selected</ww:if>>否</option>
							<option value="1"
								<ww:if test="customeruser.isadmin==1">selected</ww:if>>是</option>
							


						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="是否是管理员不能为空" name="isadmin" value='<ww:property value="customeruser.isadmin"/>'" style="width:350px" />
	 --></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>生日：</span></td>
						<td>
							<input type="text" name="c_birthday" style="width: 350px" />
						</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>所在城市：</span></td>
						<td><input type="text" name="localcity"
							value='<ww:property value="customeruser.localcity"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>传真：</span></td>
						<td><input type="text" name="memberfax"
							value='<ww:property value="customeruser.memberfax"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>备忘录：</span></td>
						<td><input type="text" name="memberdesc"
							value='<ww:property value="customeruser.memberdesc"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>是否是网站会员：</span></td>
						<td><select name="isweb">
							<option value="1"
								<ww:if test="customeruser.isweb==1">selected</ww:if>>是</option>
							<option value="2"
								<ww:if test="customeruser.isweb==2">selected</ww:if>>不是</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="是否是网站会员不能为空" name="isweb" value='<ww:property value="customeruser.isweb"/>'" style="width:350px" />
	 --></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>移动电话号码：</span></td>
						<td><input type="text" name="membermobile"
							value='<ww:property value="customeruser.membermobile"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>是否启用：</span></td>
						<td><select name="isenable">
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>是</option>
							<option value="2"
								<ww:if test="customeruser.isenable==0">selected</ww:if>>不是</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="是否启用不能为空" name="isenable" value='<ww:property value="customeruser.isenable"/>'" style="width:350px" />
	 --></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>会员类型：</span></td>
						<td><select name="membertype">
							<!--<option value="1"
								<ww:if test="customeruser.membertype==1">selected</ww:if>>B2C会员</option>
							--><option value="2"
								<ww:if test="customeruser.membertype==2">selected</ww:if>>网站注册</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="类型不能为空" name="membertype" value='<ww:property value="customeruser.membertype"/>'" style="width:350px" />
	 --></td>
					</tr>
					<!--
	
				 
 
	 <tr><td height="28" align="right"><span>所属加盟商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="所属加盟商ID不能为空" name="agentid" value='<ww:property value="customeruser.agentid"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      -->
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customeruser.action?<ww:property value="url"/>';"
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
</body>
</html>


