<%@ page contentType="text/html; charset=GBK"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<title><ww:if test="airfee.id>0">编辑</ww:if><ww:else>新增</ww:else>燃油费机建费表</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script language="javascript">
	function form_validate() {
		var validate = true ;
		
		$('span',$('#adultairportfee').parent()).remove() ;
		if($.trim($('#adultairportfee').val()) == '') {
			$('#adultairportfee').parent().append('<span  class="font-red">成人基建费不许为空</span>') ;
			$('#adultairportfee').focus();
			validate = false ;
		}
		
		$('span',$('#chdairportfee').parent()).remove() ;
		if($.trim($('#chdairportfee').val()) == '') {
			$('#chdairportfee').parent().append('<span  class="font-red">儿童基建费不许为空</span>') ;
			$('#chdairportfee').focus();
			validate = false ;
		}
		
		$('span',$('#babyairportfee').parent()).remove() ;
		if($.trim($('#babyairportfee').val()) == '') {
			$('#babyairportfee').parent().append('<span class="font-red">婴儿基建费不许为空</span>') ;
			$('#babyairportfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearadultairpotyfee').parent()).remove() ;
		if($.trim($('#nearadultairpotyfee').val()) == '') {
			$('#nearadultairpotyfee').parent().append('<span style="color:red">成人机建费(支线)不许为空</span>') ;
			$('#nearadultairpotyfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearchdairpotyfee').parent()).remove() ;
		if($.trim($('#nearchdairpotyfee').val()) == '') {
			$('#nearchdairpotyfee').parent().append('<span style="color:red">儿童机建费(支线)不许为空</span>') ;
			$('#nearchdairpotyfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearbabyairportfee').parent()).remove() ;
		if($.trim($('#nearbabyairportfee').val()) == '') {
			$('#nearbabyairportfee').parent().append('<span style="color:red">婴儿机建费(支线)不许为空</span>') ;
			$('#nearbabyairportfee').focus();
			validate = false ;
		}
		
		$('span',$('#adultfuelfee').parent()).remove() ;
		if($.trim($('#adultfuelfee').val()) == '') {
			$('#adultfuelfee').parent().append('<span style="color:red">成人燃油费不许为空</span>') ;
			$('#adultfuelfee').focus();
			validate = false ;
		}
		
		$('span',$('#chdfuelfee').parent()).remove() ;
		if($.trim($('#chdfuelfee').val()) == '') {
			$('#chdfuelfee').parent().append('<span style="color:red">儿童燃油费不许为空</span>') ;
			$('#chdfuelfee').focus();
			validate = false ;
		}
		
		$('span',$('#babyfuelfee').parent()).remove() ;
		if($.trim($('#babyfuelfee').val()) == '') {
			$('#babyfuelfee').parent().append('<span style="color:red">婴儿燃油费不许为空</span>') ;
			$('#babyfuelfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearadultfuelfee').parent()).remove() ;
		if($.trim($('#nearadultfuelfee').val()) == '') {
			$('#nearadultfuelfee').parent().append('<span style="color:red">成人燃油费(近)不许为空</span>') ;
			$('#nearadultfuelfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearchdfuelfee').parent()).remove() ;
		if($.trim($('#nearchdfuelfee').val()) == '') {
			$('#nearchdfuelfee').parent().append('<span style="color:red">儿童燃油费(近)不许为空</span>') ;
			$('#nearchdfuelfee').focus();
			validate = false ;
		}
		
		$('span',$('#nearbabyfuelfee').parent()).remove() ;
		if($.trim($('#nearbabyfuelfee').val()) == '') {
			$('#nearbabyfuelfee').parent().append('<span style="color:red">婴儿燃油费(近)不许为空</span>') ;
			$('#nearbabyfuelfee').focus();
			validate = false ;
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="airfee.id>0">编辑</ww:if><ww:else>新增</ww:else>燃油费机建费表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="airfee!<ww:if test="airfee.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return form_validate()">

		<table width="99%" border="0" cellpadding="0" cellspacing="0" style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%" style="border-collapse:collapse; ">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" width="15%" class="table_color_r colortrin"><span>成人机建费：</span></td>
						<td class="table_color_l" width="35%"><input type="text" id="adultairportfee"
							name="adultairportfee"
							value='<ww:property value="airfee.adultairportfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" width="15%" class="table_color_r colortrin"><span>儿童机建费：</span></td>
						<td class="table_color_l"><input type="text" id="chdairportfee"
							name="chdairportfee"
							value='<ww:property value="airfee.chdairportfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>婴儿机建费：</span></td>
						<td class="table_color_l"><input type="text" id="babyairportfee"
							name="babyairportfee"
							value='<ww:property value="airfee.babyairportfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>成人机建费(支线)：</span></td>
						<td class="table_color_l"><input type="text" id="nearadultairpotyfee"
							name="nearadultairpotyfee"
							value='<ww:property value="airfee.nearadultairpotyfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>儿童机建费(支线)：</span></td>
						<td class="table_color_l"><input type="text" id="nearchdairpotyfee"
							name="nearchdairpotyfee"
							value='<ww:property value="airfee.nearchdairpotyfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>婴儿机建费(支线)：</span></td>
						<td class="table_color_l"><input type="text" id="nearbabyairportfee"
							name="nearbabyairportfee"
							value='<ww:property value="airfee.nearbabyairportfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>成人燃油费(>800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="adultfuelfee" name="adultfuelfee"
							value='<ww:property value="airfee.adultfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>儿童燃油费(>800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="chdfuelfee" name="chdfuelfee"
							value='<ww:property value="airfee.chdfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>婴儿燃油费(>800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="babyfuelfee" name="babyfuelfee"
							value='<ww:property value="airfee.babyfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>成人燃油费(&lt800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="nearadultfuelfee"
							name="nearadultfuelfee"
							value='<ww:property value="airfee.nearadultfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>儿童燃油费(&lt800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="nearchdfuelfee"
							name="nearchdfuelfee"
							value='<ww:property value="airfee.nearchdfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>婴儿燃油费(&lt800公里)：</span></td>
						<td class="table_color_l"><input type="text" id="nearbabyfuelfee"
							name="nearbabyfuelfee"
							value='<ww:property value="airfee.nearbabyfuelfee"/>'
							 class="table_color" style="margin-right: 10px;"/><span></span></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='airfee.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


