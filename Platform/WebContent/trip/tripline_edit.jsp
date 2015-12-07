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
<title><ww:if test="tripline.id>0">编辑</ww:if><ww:else>新增</ww:else>旅行线路</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/jquery1.3.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="tripline!toeditlanguage.action";
	document.form1.submit();
}
function form_validate()
{  
     if($("#name").val()=="")
     {
         alert("旅游线路短名称不能为空，请重新填写！");
         return false;
     }
     if($("#longname").val()=="")
     {
         alert("旅游线路长名称不能为空，请重新填写！");
         return false;
     }
     if($("#price").val()=="")
     {
         alert("旅游线路价格不能为空，请重新填写！");
         return false;
     }
     else if($("#price").val()=="0")
     {
         alert("旅游线路价格不能为0，请重新填写！");
         return false;
     }
     if($("#startdate").val()=="")
     {
         alert("出发日期不能为空，请重新填写！");
         return false;
     }
     if($("#description").val()=="")
     {
         alert("旅游线路简介不能为空，请重新填写！");
         return false;
     }
     
     
}
</script>
<!-- 支持多语言结束 -->
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display: block;">&nbsp;&nbsp;&nbsp;<ww:if
			test="tripline.id>0">编辑</ww:if><ww:else>新增</ww:else>旅行线路</span> <span
			style="display: block; width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="tripline.id>0||tripline.language>0">
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="tripline.ucode"/>,0)"
						<ww:if test="tripline.language==0">class="add"</ww:if>><img
						src="images/jian.gif" width="27px" height="26px;"
						align="absmiddle" style="margin-right: 15px;">简体</a></td>
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="tripline.ucode"/>,1)"
						<ww:if test="tripline.language==1">class="add"</ww:if>><img
						src="images/fan.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">繁体</a></td>
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="tripline.ucode"/>,2)"
						<ww:if test="tripline.language==2">class="add"</ww:if>><img
						src="images/ri.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">日语</a></td>
					<td><a href="#"
						onclick="addlanguage(<ww:property value="tripline.ucode"/>,3)"
						<ww:if test="tripline.language==3">class="add"</ww:if>><img
						src="images/yin.gif" width="27px" height="26px;" align="absmiddle"
						style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
					<td width="100%" align="right"><a href="#" class="add"><img
						src="images/jian.gif" width="27px" height="26px;"
						align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="tripline!<ww:if test="tripline.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post" enctype="multipart/form-data" onsubmit="return form_validate()">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4" height="18">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" width="15%" class="table_color_r colortrin"><span>旅游线路短名称：</span></td>
						<td class="table_color_l" width="35%"><input type="text"
							id="name" name="name" value='<ww:property value="tripline.name"/>'
							style="width: 150px" />&nbsp;<span style="color: red">*
						(此名称显示在首页，旅游推荐位置)</span></td>
						<td height="28" width="15%" class="table_color_r colortrin"><span>旅游线路长名称：</span></td>
						<td class="table_color_l" width="35%"><input type="text"
							id="longname" name="longname" value='<ww:property value="tripline.longname"/>'
							style="width: 150px" /> &nbsp;<span style="color: red">*
						(此名称显示在旅游线路列表位置)</span></td>
					</tr>
					<tr>
						<td height="28" width="15%" class="table_color_r colortrin"><span>价格：</span></td>
						<td class="table_color_l"><input type="text" id="price" name="price"
							value='<ww:property value="tripline.price"/>'
							style="width: 150px" />&nbsp;<span style="color: red">*</span></td>
						<td class="table_color_r colortrin">是否设为本月推荐：</td>
						<td class="table_color_l"><input type="checkbox"
							name="startprice"
							value='<ww:property value="tripline.startprice"/>' />&nbsp;选中设为推荐</td>
					</tr>
					<tr style="display: none">
						<td height="28" align="right" class="table_color_r colortrin"><span>起价：</span></td>
						<td class="table_color_l"></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>优惠价：</span></td>
						<td class="table_color_l"><input type="text" name="proprice"
							value='<ww:property value="tripline.proprice"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>出发城市：</span></td>
						<td class="table_color_l"><select name="cityid"
							style="width: 150px">
							<ww:iterator value="cityList">
							<option value="<ww:property value="id"/>"
								<ww:if test="tripline.cityid==id">selected="selected"</ww:if>><ww:property value="name"/></option>
							</ww:iterator>
						</select> &nbsp;<span style="color: red">*</span><!-- <input type="text" name="cityid" value='<ww:property value="tripline.cityid"/>' style="width: 150px" /> --></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>目的地城市：</span></td>
						<td class="table_color_l"><select name="endcityid"
							style="width: 150px">
							<ww:iterator value="cityList">
							<option value="<ww:property value="id"/>"
								<ww:if test="tripline.endcityid==id">selected="selected"</ww:if>><ww:property value="name"/></option>
							</ww:iterator>
						</select> &nbsp;<span style="color: red">*</span><!-- <input type="text" name="endcityid"
							value='<ww:property value="tripline.endcityid"/>'
							style="width: 150px" /> --></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>出发日期：</span></td>
						<td class="table_color_l"><input type="text"
							onfocus="WdatePicker()" name="startdate" id="startdate"
							value='<ww:property value="tripline.startdate"/>'
							style="width: 150px" />&nbsp;<span style="color: red">*</span></td>

						<td height="28" align="right" class="table_color_r colortrin"><span>旅游线路图片：</span></td>
						<td class="table_color_l"><input type="file" name="t_image"
							style="width: 300px" /></td>


					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>线路来源：</span></td>
						<td class="table_color_l"><select name="customeragentid">
							<ww:iterator value="listtripsource">
								<option value="<ww:property value="id" />"><ww:property
									value="name" /></option>
							</ww:iterator>
						</select></td>

						<td height="28" align="right" class="table_color_r colortrin"><span>线路类型：</span></td>
						<td class="table_color_l"><select name="typeid">
							<ww:iterator value="listtriplinetype">
								<option value="<ww:property value="id" />"><ww:property
									value="name" /></option>
							</ww:iterator>
						</select></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>出发班期：</span></td>
						<td colspan="3" class="table_color_l">
						
						<textarea rows="4"
							cols="80" name="startrange"><ww:property value="tripline.startrange"/></textarea>
						</td>

					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>报名要求：</span></td>
						<td colspan="3" class="table_color_l"><textarea rows="4"
							cols="80" name="predesc"><ww:property
							value="tripline.predesc" /></textarea></td>

					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>旅游线路简介：</span></td>
						<td colspan="3" class="table_color_l"><textarea
							name="description" id="description" cols="80" rows="10"><ww:property
							value="tripline.description" /></textarea>&nbsp;<span style="color: red">*</span></td>
					</tr>

					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="tripline.language>0">
						<input id="language" type="hidden" name="tripline.language"
							value="<ww:property value="tripline.language"/>" />
					</ww:if>
					<ww:else>
						<input id="language" type="hidden" name="tripline.language"
							value="0" />
					</ww:else>
					<input id="ucode" type="hidden" name="tripline.ucode"
						value="<ww:property value="tripline.ucode"/>" />
					<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style="position: relative; width: 220px;"><input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai"
							onclick="window.location.href='tripline.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /> <ww:iterator
							value="actionMessages">
							<div id="tishi"
								style="position: absolute; top: -55px; left: 0px;"><img
								src="images/gg.png" width="149" height="60" /></div>
							<script type="text/javascript">
						setTimeout("showclose()",2000); 
						function showclose()
						{
							document.getElementById("tishi").style.display="none";
						}
					</script>
						</ww:iterator></div>
						</td>
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

