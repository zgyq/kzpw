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
<title><ww:if test="sysmessage.id>0">编辑</ww:if><ww:else>新增</ww:else>消息公告</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript">
	function getUser() {
		var str = "";
		$("input[name=muser]").each(function() {
			if (this.checked == true) {
				if (str == "") {
					str += "," +  this.value + ",";
				} else {
				str += this.value + ",";
				}	
			}
		});
		$("#users").val(str);
	}
	
	function sysmsgSubmit() {
		
		getUser();
		if(form_validate())
		{
		document.form1.submit();
		}
	}
</script>
</head>

<body onload="showUsers()">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="sysmessage.id>0">编辑</ww:if><ww:else>新增</ww:else>消息公告</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="sysmessage!<ww:if test="sysmessage.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<!--
					<tr>
						<td height="28" align="right"><span>创建者ID：</span></td>
						<td><input type="text" name="customeruserid"
							value='<ww:property value="sysmessage.customeruserid"/>'
							style="width: 350px" /></td>
					</tr>
					-->

					<tr>
						<td height="28" align="right"><span>公告标题：</span></td>
						<td><input id="title" type="text" name="title"
							value='<ww:property value="sysmessage.title"/>'
							style="width: 350px" /><span id="titlestr" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>公告类型：</span></td>
						<td><select name="type" id="sType" onchange="showUsers()">
							<ww:if test="sysmessage.type==0">
								<option value="0" selected="selected">系统公告</option>
								<option value="1">机票公告</option>
							</ww:if>
							<ww:elseif test="sysmessage.type==1">
								<option value="0">系统公告</option>
								<option value="1" selected="selected">机票公告</option>
							</ww:elseif>
							<ww:else>
								<option value="0">系统公告</option>
								<option value="1">机票公告</option>
							</ww:else>
						</select></td>
					</tr>
					<script language="javascript">
						function showUsers() {
							var type = document.getElementById("sType");
							if (type.value == 0) {
								document.getElementById("usersTr").style.display="none";
							} else if (type.value == 1) {
								document.getElementById("usersTr").style.display = "block";
							}
						}
					</script>
					<tr id="usersTr">
						<td height="28" align="right" valign="top"><span>可见用户：</span></td>
						<td><input type="hidden" name="users" id="users" /> <ww:if
							test="listCustomeruser != null && listCustomeruser.size() > 0">
							<ww:iterator value="listCustomeruser" status="rowstatus">
								<ww:if test="isContained(id)">
									<input type="checkbox" name="muser"
										value="<ww:property value="id" />" checked="checked" />
									<ww:property value="membername" /> &nbsp;
									</ww:if>
								<ww:else>
									<input type="checkbox" name="muser"
										value="<ww:property value="id" />" />
									<ww:property value="membername" /> &nbsp;
									</ww:else>
								<ww:if test="#rowstatus.index > 0 && #rowstatus.index%6==0">
									<br />
								</ww:if>
							</ww:iterator>
						</ww:if> <ww:else>
								全部可见
							</ww:else> <!--<input type="text" name="users"
							value='<ww:property value="sysmessage.users"/>'
							style="width: 350px" />
						--></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>发布截止时间：</span></td>
						<td><input type="text" id="s_pubtime" name="s_pubtime"
							value='<ww:property value="formatTimestamp(sysmessage.pubtime)"/>'
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" /> 至 <input type="text"
							name="s_endtime" id="s_endtime"
							value='<ww:property value="formatTimestamp(sysmessage.endtime)"/>'
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" /><span id="s_pubtimestr" class="font-red">*</span></td>
					</tr>
					<!--<tr>
						<td height="28" align="right"><span>截止时间：</span></td>
						<td><input type="text" name="s_endtime"
							value='<ww:property value="formatDate(sysmessage.endtime)"/>'
							style="width: 350px" onfocus="WdatePicker()" class="Wdate" /></td>
					</tr>
					-->
					<tr>
						<td height="28" align="right"><span>公告状态：</span></td>
						<td><ww:if test="sysmessage.state==0">
							<input type="radio" name="state" value="1" />启用&nbsp;
								<input type="radio" name="state" value="0" checked="checked" />禁用
							</ww:if> <ww:else>
							<input type="radio" name="state" value="1" checked="checked" />启用&nbsp;
								<input type="radio" name="state" value="0" />禁用
							</ww:else></td>
					</tr>
					<tr>
						<td height="28" align="right" valign="top"><span>公告内容：</span></td>
						<td><textarea style="width: 650px; height: 200px;" id="content"
							name="content"><ww:property value="sysmessage.content" /></textarea><span id="contentstr" class="font-red"></span>
						</td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46"><input type="button"
							class="button_d font-bai" value="提交" onclick="sysmsgSubmit()" />
						<input type="button" class="button_d font-bai"
							onclick="window.location.href='sysmessage.action?<ww:property value="url"/>';"
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
<script language="javascript"><!--
	function form_validate() {
		var validate = true ;
		var content = nEditor.tGetUBB();// document.getElementById('content');
		if(parseInt(content.length)<10) {
			document.getElementById("contentstr").innerHTML="*内容长度不能小于10个字符";
			content.focus();
			validate = false ;
		} else {
			document.getElementById("contentstr").innerHTML="";
		}
		
		s_endtime = document.getElementById('s_endtime');
		if(s_endtime.value == '') {
			document.getElementById("s_pubtimestr").innerHTML="*开始时间或结束时间不能为空";
			s_endtime.focus();
			validate = false ;
		}else {
			document.getElementById("s_pubtimestr").innerHTML="*";
		}
		
		s_pubtime = document.getElementById('s_pubtime');
		if(s_pubtime.value == '') {
			document.getElementById("s_pubtimestr").innerHTML="*开始时间或结束时间不能为空";
			s_pubtime.focus();
			validate = false ;
		}else {
			document.getElementById("s_pubtimestr").innerHTML="*";
		}
		
		title = document.getElementById('title');
		if(parseInt(title.value.length)<8) {
			document.getElementById("titlestr").innerHTML="*标题长度8个以上字符";
			title.focus();
			validate = false ;
		}else {
			document.getElementById("titlestr").innerHTML="*";
		}
		return validate;
	}
		
	// 初始化文本编辑器
	var nEditor = new jtbcEditor('content');
	nEditor.tEditUBBMode = 0;
	nEditor.tInit('nEditor', 'js/jtbceditor/');
</script>
