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
<title><ww:if test="tickctspa
		.id>0">编辑</ww:if><ww:else>新增</ww:else>票务温泉
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="tickctspa!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
</head>

<body>
<div id="member">
<form action="tickctspa
		!<ww:if test="tickctspa
		.id>0">edit.action?id=<ww:property value="tickctspa
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="tickctspa.id>0">编辑</ww:if><ww:else>新增</ww:else>票务温泉</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="tickctspa.id>0||tickctspa.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="tickctspa.ucode"/>,0)" <ww:if test="tickctspa.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="tickctspa.ucode"/>,1)" <ww:if test="tickctspa.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="tickctspa.ucode"/>,2)" <ww:if test="tickctspa.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="tickctspa.ucode"/>,3)" <ww:if test="tickctspa.language==3">class="add"</ww:if>><img src="images/yin.gif"
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
						" value='<ww:property value="tickctspa.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					价格
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="price
						" value='<ww:property value="tickctspa.price
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					有效期
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="period
						" value='<ww:property value="tickctspa.period"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备注
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="desc
						" value='<ww:property value="tickctspa.desc
						"/>'" style="width: 300px" />
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					门市价
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="homeprice" value='<ww:property value="tickctspa.homeprice"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					描述:<span style="color:red;">*</span>
				</td>
				<td width="10%" colspan="3" height="30" align="left" class="table_color_l">
					
				<FCK:editor id="description" basePath="fck/" width="680" height="400" >
					<ww:property value="tickctspa.description"/>
					</FCK:editor>
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					主图片:<span style="color:red;">*</span>
				</td>
				<td width="10%" colspan="3" height="30" align="left" class="table_color_l">
					<input type="file" name="files" id="files" style="width: 300px">
					<ww:if test="tickctspa.pic != null ">
					<img width="100" height="80" src="<%=request.getContextPath()%><ww:property value="tickctspa.pic"/>"/>
					</ww:if>
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片2:<span style="color:red;">*</span>
					
				</td>
				<td width="10%" colspan="3" height="30" align="left" class="table_color_l">
					<input type="file" name="files2" id="files" style="width: 300px">
					<ww:if test="tickctspa.pic2 != null ">
					<img width="100" height="80" src="<%=request.getContextPath()%><ww:property value="tickctspa.pic2"/>"/>
					</ww:if>
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片3:<span style="color:red;">*</span>
					
				</td>
				<td width="10%" colspan="3" height="30" align="left" class="table_color_l">
					<input type="file" name="files3" id="files" style="width: 300px">
					<ww:if test="tickctspa.pic3 != null ">
					<img width="100" height="80" src="<%=request.getContextPath()%><ww:property value="tickctspa.pic3"/>"/>
					</ww:if>
				</td>
		</tr>
	

		    
				<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="tickctspa.language>0">
					<input id="language" type="hidden" name="language" value="<ww:property value="tickctspa.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="tickctspa.ucode"/>"/>
			
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='tickctspa.action?<ww:property value="url"/>';"
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


	