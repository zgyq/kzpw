<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2009
	 *
	 *
	 *  HISTORY
	 *  
	 *  2009/08/14 创建
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

<script type="text/javascript" src="js/validator.js"></script>
<script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>
<link href="js/autocomplete/jquery.autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="js/autocomplete/jquery.js"></script>
<script type="text/javascript"
	src="js/autocomplete/jquery.autocomplete.js"></script>


</head>

<body>
<div id="cx">
<form name="form1" method="post" action="hotel!readerExcel.action" >


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"
			style="border-bottom: 1px solid #99CBED"><span
			 class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店导入</span></td>
	</tr>
	<tr>
		<td height="455" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>


						<table width="100%" height="120" border="0" align="center">
							<tr>

							</tr>
							<tr>
								<td align="center"><input type="file" id="kaka" /> <input
									type="hidden" name="path" id="pa" /></td>
							</tr>
							<tr>
								<td align="center"><input type="button" class="button_d font-white"
									value="上&nbsp;&nbsp;传" onclick="searchOne()" /></td>
							</tr>
							<tr>
								<td align="center"><span id="spendemail"
									style="COLOR: #ff0000"><font class="hui12"><ww:if
									test="f_state==1">上传成功</ww:if><ww:elseif test="f_state==-1">酒店单子上传失败,该酒店已存在或模板填写不规范</ww:elseif><ww:elseif
									test="f_state==-2">酒店房型上传失败,请检查模板是否书写规范</ww:elseif><ww:elseif
									test="f_state==-3">酒店联系人上传失败,请检查模板是否书写规范</ww:elseif><ww:elseif
									test="f_state==-4">注意事项上传失败,请检查模板是否书写规范</ww:elseif><ww:elseif
									test="f_state==-5">酒店地标上传失败,请检查模板是否书写规范</ww:elseif><ww:elseif
									test="f_state==-6">酒店价格上传失败,无该类房型或模板填写不规范</ww:elseif><ww:elseif
									test="f_state==-7">酒店房态上传失败,请检查模板是否书写规范</ww:elseif><ww:else></ww:else></font></span></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td></td>
								<td>&nbsp;</td>

								<td>&nbsp;</td>
							</tr>
						</table>

						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>

<script type="text/javascript">


	// 验证附件合法性
	function validateAccessorie() {
		var validate = true;
		
		$('#accDiv :file').each(function() {
			$('span',$(this).parent()).remove() ;
			if($.trim($(this).val()) == '') {
				$(this).parent().append('<span style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;附件内容不能为空</span>');
				$(this).focus();
				validate = false;
				return false;
			} else {
				var fujian = $.trim($(this).val());
				fujian = fujian.substring(fujian.lastIndexOf('.')+1,fujian.length);
				if(fujian != "xls") {
					$(this).parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;只能上传xls格式的文档</span>') ;
					$(this).focus();
					validate = false ;
					return false;
				}
			}
		});

		$('#accDiv :text').each(function() {
			$('span',$(this).parent()).remove() ;
			if($.trim($(this).val()) == '') {
				$(this).parent().append('<span style="color:red">&nbsp;&nbsp;&nbsp;附件名称不能为空</span>');
				$(this).focus();
				validate = false;
				return false;
				
			}
		});
		
		return validate;
	}
 function 	searchOne(){

	        var isIE = (document.all) ? true : false; 

        var isIE7 = isIE && (navigator.userAgent.indexOf('MSIE 7.0') != -1); 

        var isIE8 = isIE && (navigator.userAgent.indexOf('MSIE 8.0') != -1); 

  

        var file=document.getElementById("kaka"); 

            if(isIE7 || isIE8) 

         { 

            file.select(); 

//alert(document.selection.createRange().text);
            document.getElementById("pa").value=document.selection.createRange().text; 

            document.selection.empty(); 

          } 
	
	
		document.form1.submit();
	
	
	}
			





		
</script>
