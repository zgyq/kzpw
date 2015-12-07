<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %>
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
<title><ww:if test="conferencehotel
		.id>0">编辑</ww:if><ww:else>新增</ww:else>会议酒店
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="conferencehotel!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
</head>

<body>
<div id="member">
<form action="conferencehotel
		!<ww:if test="conferencehotel
		.id>0">edit.action?id=<ww:property value="conferencehotel
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="infotype.id>0">编辑</ww:if><ww:else>新增</ww:else>会议酒店</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="conferencehotel.id>0||conferencehotel.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="conferencehotel.ucode"/>,0)" <ww:if test="conferencehotel.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="conferencehotel.ucode"/>,1)" <ww:if test="conferencehotel.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="conferencehotel.ucode"/>,2)" <ww:if test="conferencehotel.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="conferencehotel.ucode"/>,3)" <ww:if test="conferencehotel.language==3">class="add"</ww:if>><img src="images/yin.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">英语</a></td>
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
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					名称
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="name
						" value='<ww:property value="conferencehotel.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					类型
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<select name="star"  style="width: 300px">
					<option value="1" <ww:if test="conferencehotel.star==1">selected="selected"</ww:if> >商务型酒店</option>
					<option value="2" <ww:if test="conferencehotel.star==2">selected="selected"</ww:if> >度假型酒店</option>
					</select>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					会议厅个数
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="hallnum
						" value='<ww:property value="conferencehotel.hallnum"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					城市
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="city
						" value='<ww:property value="conferencehotel.city
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					地址
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="address
						" value='<ww:property value="conferencehotel.address"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					电话
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="phone
						" value='<ww:property value="conferencehotel.phone
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					介绍
						:<span style="color:red;">*</span>
				</td>
				<td colspan="3" width="10%" height="30" align="left" class="table_color_l">
					<FCK:editor id="desc" basePath="fck/" width="680" height="400" >
					<ww:property value="conferencehotel.desc"/>
					</FCK:editor>
				</td>
		
		</tr>
		<tr>
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" colspan="3" height="30" class="table_color_l" align="left" valign="top" >
					<input type="file" name="files" id="files" style="width: 300px">
					<ww:if test="conferencehotel.pic != null ">
					<img width="100" height="80" src="<ww:property value="conferencehotel.pic"/>"/>
					</ww:if>
				</td>
		</tr>
		    
			<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="conferencehotel.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="conferencehotel.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="conferencehotel.ucode"/>"/>
			
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='conferencehotel.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
							<ww:iterator value="actionMessages">
					<div id="tishi" style=" position: absolute; top:-55px; left:0px; "><img src="images/gg.png" width="149" height="60" /></div>
					<script type="text/javascript">
						setTimeout("showclose()",2000); 
						function showclose()
						{
							document.getElementById("tishi").style.display="none";
						}
					</script>
					</ww:iterator>
					</div>
							</td>
					</tr>
					<!-- 支持多语言结束 -->
		</table>
		</td>
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
</table>
</form>
</div>
</body>
</html>


	