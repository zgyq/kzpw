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
<title><ww:if test="eterminfo.id>0">编辑</ww:if><ww:else>新增</ww:else>配置表</title>

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
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
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
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="eterminfo.id>0">编辑</ww:if><ww:else>新增</ww:else>配置表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="eterminfo!<ww:if test="eterminfo.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" id="form1"
			>



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>账号类别：</span></td>
						<td>
						<!--<input type="text" require="true" dataType="Require"
							msg="账号类别不能为空" name="etermtype"
							value='<ww:property value="eterminfo.etermtype"/>'
							" style="width: 350px" />
							 -->
							 <select name="etermtype">
							<option value="1" <ww:if test="eterminfo.etermtype==1">selected</ww:if>>Eterm350</option>
							<option value="2" <ww:if test="eterminfo.etermtype==2">selected</ww:if>>Eterm443</option>
							<option value="3" <ww:if test="eterminfo.etermtype==3">selected</ww:if>>信天游</option>
							<option value="4" <ww:if test="eterminfo.etermtype==4">selected</ww:if>>放大帐号</option>
						</select></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>配置帐号：</span></td>
						<td><input type="text" require="true" dataType="Require" id="etermaccount"
							msg="配置帐号不能为空" name="etermaccount" desc="配置账号" class="validate[required]"
							value='<ww:property value="eterminfo.etermaccount"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>账号密码：</span></td>
						<td><input type="text" require="true" dataType="Require" id="password"
							msg="账号密码不能为空" name="password" desc="账号密码" class="validate[required]"
							value='<ww:property value="eterminfo.password"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>服务器地址：</span></td>
						<td><input type="text" require="true" dataType="Require" id="serverip"
							msg="服务器地址不能为空" name="serverip" desc="服务器地址" class="validate[required]"
							value='<ww:property value="eterminfo.serverip"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>服务器端口号：</span></td>
						<td><input type="text" require="true" dataType="Require" id="portnum"
							msg="服务器端口号不能为空" name="portnum" desc="服务器端口号" class="validate[required]"
							value='<ww:property value="eterminfo.portnum"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>SI：</span></td>
						<td><input type="text" require="true" dataType="Require" id="sinum"
							msg="SI不能为空" name="sinum" desc="SI" class="validate[required]"
							value='<ww:property value="eterminfo.sinum"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>打印机序号：</span></td>
						<td><input type="text" require="true" dataType="Require" id="printnum"
							msg="打印机序号不能为空" name="printnum" desc="打印机序号" class="validate[required]"
							value='<ww:property value="eterminfo.printnum"/>'
							" style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>OFFICE：</span></td>
						<td><input type="text" require="true" dataType="Require" id="modifyuser"
							msg="OFFICE不能为空" name="modifyuser" desc="OFFICE" class="validate[required]"
							value='<ww:property value="eterminfo.modifyuser"/>'
							" style="width: 350px" /></td>
					</tr>


					<tr>
						<td height="28" align="right"><span>所属代理商：</span></td>
						<td>
						<ww:if test="type==1"><ww:property value="getagentname_b2bback(eterminfo.agentid)"/></ww:if><ww:else>
						<select width="150px" name="agentid"  >
						<ww:iterator value="listCustomeragent">
                             <option value="<ww:property value="id"/>" <ww:if test="eterminfo.agentid==id">selected</ww:if>><ww:property value="agentcompanyname"/></option>
                         </ww:iterator>
                             
                        </select>
						</ww:else>
						
						<!--<select width="150px" name="agentid" <ww:if test="type==1">disabled</ww:if> >
						<ww:iterator value="listCustomeragent">
                             <option value="<ww:property value="id"/>" <ww:if test="eterminfo.agentid==id">selected</ww:if>><ww:property value="agentcompanyname"/></option>
                         </ww:iterator>
                             
                        </select>
							
							--></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>账号状态：</span></td>
						<td>
						<!--<input type="text" require="true" dataType="Require"
							msg="账号账号不能为空" name="status"
							value='<ww:property value="eterminfo.status"/>'
							" style="width: 350px" />
							-->
							<select width="150px" name="status">
                          	  <option value="1" <ww:if test="eterminfo.status==1">selected</ww:if> >启用</option>
                       			<option value="0" <ww:if test="eterminfo.status==0">selected</ww:if>  >禁用</option>
                            </select>
							</td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='eterminfo.action?<ww:property value="url"/>';"
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


