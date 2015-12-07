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
<script type="text/javascript" src="js/jtbceditor/jtbceditor.js"></script>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"
	src="js/jquery1.3.2.js"></script>
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

<body>
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
			action="sysmessage!sendMsg.action"name="form1" method="POST">
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
						<td height="28" align="right"><span>标题：</span></td>
						<td><input id="title" type="text" name="title"
							value='<ww:property value="sysmessage.title"/>'
							style="width: 350px" /><span id="titlestr" class="font-red">*</span></td>
					</tr>
					<tr id="usersTr">
						<td height="28" align="right" valign="top"><span>收件人：</span></td>
						<td><input type="hidden" name="users" id="users" /> <ww:if
							test="listCustomeruser != null && listCustomeruser.size() > 0">
								<span style="padding-left:1px"><input type="checkbox" onclick="selectall1()" name="all1" />全选</span><br/>
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
								<ww:if test="#rowstatus.index > 0 && #rowstatus.index%5==0">
									<br />
								</ww:if>
							</ww:iterator>
						</ww:if>
						<ww:else>&nbsp;无</ww:else> 
						<!--<input type="text" name="users"
							value='<ww:property value="sysmessage.users"/>'
							style="width: 350px" />
						--><span id="userstr" class="font-red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" valign="top"><span>内容：</span></td>
						<td><textarea style="width: 650px; height: 200px;" id="content"
							name="content"><ww:property value="sysmessage.content" /></textarea><span id="contentstr" class="font-red"></span>
						</td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46"><input type="button"
							class="button_d font-bai" value="提交" onclick="sysmsgSubmit()" />
						<input type="button" class="button_d font-bai"
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
		if (document.getElementById("users").value == "") {
			document.getElementById("userstr").innerHTML="*请选择收件人";
			validate = false;
		} else {
			document.getElementById("userstr").innerHTML="*";
		}
		
		title = document.getElementById('title');
		if(parseInt(title.value.length)<8) {
			document.getElementById("titlestr").innerHTML="*标题长度8个以上字符";
			title.focus();
			validate = false ;
		}else {
			document.getElementById("titlestr").innerHTML="*";
		}
		
		var content = nEditor.tGetUBB();// document.getElementById('content');
		if(parseInt(content.length)<10) {
			document.getElementById("contentstr").innerHTML="*内容长度不能小于10个字符";
			validate = false ;
		} else {
			document.getElementById("contentstr").innerHTML="";
		}
		
		return validate;
	}
	
	function unselectall() {
	    if(document.form1.all.checked){
		document.form1.all.checked = document.form1.all.checked&0;
	    }
	}
	
	function selectall1() {
	    var length=document.form1.muser.length;
	    document.form1.all1.checked = document.form1.all1.checked|0;
	    
	    if ( length ==undefined &&  document.form1.muser!=null ){
	    	  document.form1.muser.checked=document.form1.all1.checked ;
	          return;
	    }
	    if (length>1) {
	      for (var i = 0; i < length; i++)
	       {
	          document.form1.muser[i].checked = document.form1.all1.checked;
		      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
	       }
    	}
	}
		
	// 初始化文本编辑器
	var nEditor = new jtbcEditor('content');
	nEditor.tEditUBBMode = 0;
	nEditor.tInit('nEditor', 'js/jtbceditor/');
-->
</script>
