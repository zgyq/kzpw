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
<title>上传logo图片</title>

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



<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-all.js"></script>


<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;上传图片</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeruser!uplogo.action"
			name="form1" method="POST" enctype="multipart/form-data">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>logo：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="logo" style="width: 350px" />
					<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />
					
					<ww:if test="logopath!=null">
					<img src="<ww:property value="logopath" />">
					</ww:if>
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页01：</span></td>
						<td height="28" align="right">连接<input type="text" name="url"
							value='<ww:property value="tripline.proprice"/>'
							style="width: 150px" /></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="index01" style="width: 350px" />
						<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
				<ww:if test="index01path!=null">	<img src="<ww:property value="index01path" />"></ww:if>
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页02：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="index02" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />			
					<ww:if test="index02path!=null"> <img src="<ww:property value="index02path" />">	</ww:if>
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页03：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="index03" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />			
				<ww:if test="index03path!=null"> 	<img src="<ww:property value="index03path" />">		</ww:if>
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页04：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="index04" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />			
				<ww:if test="index04path!=null"> 	<img src="<ww:property value="index04path" />">		</ww:if>
							</td>
					</tr>
						<tr>
						<td height="28" align="right"><span>首页05：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="index05" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />			
				<ww:if test="index05path!=null"> 	<img src="<ww:property value="index05path" />">		</ww:if>
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页ad1：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="indexad01" style="width: 350px" />
			<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="indexad01path!=null"> 	<img src="<ww:property value="indexad01path" />">		</ww:if>			
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页ad2：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="indexad02" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />
				<ww:if test="indexad02path!=null"> 	<img src="<ww:property value="indexad02path" />">		</ww:if>			
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>首页ad3：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="indexad03" style="width: 350px" />
				<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />		
				<ww:if test="indexad03path!=null"> 	<img src="<ww:property value="indexad03path" />">		</ww:if>	
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>酒店：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="hotel" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
		<ww:if test="hotelpath!=null"> 	<img src="<ww:property value="hotelpath" />">		</ww:if>				
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国内机票1：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="air01" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />		
		<ww:if test="air01path!=null"> 	<img src="<ww:property value="air01path" />">		</ww:if>			
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国内机票2：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="air02" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="air02path!=null"> 	<img src="<ww:property value="air02path" />">		</ww:if>					
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国内机票3：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="air03" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="air03path!=null"> 	<img src="<ww:property value="air03path" />">		</ww:if>					
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国际机票1：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="inair01" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="inair01path!=null"> 	<img src="<ww:property value="inair01path" />">		</ww:if>					
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国际机票2：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="inair02" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="inair02path!=null"> 	<img src="<ww:property value="inair02path" />">		</ww:if>					
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>国际机票3：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="inair03" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />					
		<ww:if test="inair03path!=null"> 	<img src="<ww:property value="inair03path" />">		</ww:if>	
							</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>旅游：</span></td>
						<td><input type="file" require="true" dataType="Require"
							msg="名称不能为空" name="travel" style="width: 350px" />
		<input type="button" value="上传" style="width: 50px"  onclick="shangchuan();" />	
			<ww:if test="travelpath!=null"> 	<img src="<ww:property value="travelpath" />">		</ww:if>					
							</td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='filecabinfile.action?<ww:property value="url"/>';"
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
<script language="javascript">

	
function shangchuan(){

	document.form1.submit();
	}
</script>

