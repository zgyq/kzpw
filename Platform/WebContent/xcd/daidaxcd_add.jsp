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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;打印行程单</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="#" name="form1" method="POST" id="form1">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>行程单号：</span></td>
						<td><input type="text" require="true" dataType="Require" id="s_numinfo" onchange="valadateaXCD(this.value);"
							msg="票号不能为空" name="password" desc="票号" class="validate[required]"
							value='<ww:property value="eterminfo.password"/>'
							" style="width: 350px" /></td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>PNR：</span></td>
						<td><input type="text" require="true" dataType="Require" id="s_pnr"
							msg="PNR不能为空" name="etermaccount" desc="PNR" class="validate[required]"
							value='<ww:property value="eterminfo.etermaccount"/>'
							" style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>票号：</span></td>
						<td><input type="text" require="true" dataType="Require" id="s_ticketnum" 
							msg="票号不能为空" name="password" desc="票号" class="validate[required]"
							value='<ww:property value="eterminfo.password"/>'
							" style="width: 350px" /></td>
					</tr>

					
					<!--<tr>
						<td height="28" align="right"><span>公司名称：</span></td>
						<td><input type="text" require="true" dataType="Require" id="serverip"
							msg="服务器地址不能为空" name="serverip" desc="服务器地址" class="validate[required]"
							value='<ww:property value="eterminfo.serverip"/>'
							" style="width: 350px" /></td>
					</tr>



					


					--><tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="button" id="sub" onclick="createXCD();"
							class="button_d font-bai" disabled="disabled" value="提交" /> </td>
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

<SCRIPT LANGUAGE="javascript"> 

function valadateaXCD(xcdno){


				$.ajax({
			      type:"POST",
			      async:false,
			      url:"xcdno!valadateaNumInfo.action",
			      data:{s_numinfo:xcdno},
			      success:function(data){
			    // alert(data);
			      	if(data=='-1'){
			      		alert("无可用行程单号");
			      		document.getElementById("sub").disabled='disabled';
			      			return;
			      		//
			      	}
			      	if(data=='1'){
			      		alert("可用的行程单号");
			      		document.getElementById("sub").disabled=false;
			      			return;
			      		
			      	}
			      	if(data=='2'){
			      		alert("行程单号已经使用过");
			      		document.getElementById("sub").disabled='disabled';
			      			return;
			      		
			      	}
			      }            
			      });
			      

}



function createXCD(url)
{
	if(document.getElementById("s_pnr").value==''){
	alert("请输入PNR");
	return;
	}
	if(document.getElementById("s_ticketnum").value==''){
	alert("请输入票号");
	return;
	}
	
	if(document.getElementById("s_numinfo").value==''){
	alert("请输入行程单号");
	return;
	}
	//alert(document.getElementById("hid").value);
	//去乐途创建
	//return;
		$.ajax({
			      type:"POST",
			      async:false,
			      url:"xcdno!toyuetucreateXCD2.action",
			      data:{s_numinfo:document.getElementById("s_numinfo").value,s_pnr:document.getElementById("s_pnr").value,s_ticketnum:document.getElementById("s_ticketnum").value},
			      success:function(data){
			      	if(data=='1'){
			      	alert("创建成功!!");
			      	window.location.href="xcdno!todaidaxcd.action";
			        }else{
			        alert("创建失败,请核对输入信息,或者联系客服协助处理!!");
			        } 
			      }           
			      });
	
	
	//去乐途创建
	
	
	
}

</SCRIPT> 
