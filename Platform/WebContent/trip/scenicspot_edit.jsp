<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK"%>
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
<title><ww:if test="scenicspot.id>0">编辑</ww:if><ww:else>新增</ww:else>景点</title>

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
<script type="text/javascript" src="fck/fckeditor.js"></script>
	
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="scenicspot!toeditlanguage.action";
	document.form1.submit();
}
</script>
<script type="text/javascript">
function form_validate()
{
    if($("#txtname").val()=="")
    {
        alert("旅游景点名称不能为空，请重新填写！");
        return false;
    }
    if($("#price").val()=="")
    {
        alert("旅游景点价格不能为空，请重新填写！");
        return false;
    }
    var osel=document.getElementById("provinceId");
    var provinceid=osel.options[osel.selectedIndex].text
    if(provinceid=="----请选择省份----")
    {
        alert("请选择旅游景点所在省份！");
        return false;
    }
    var rbContent = FCKeditorAPI.GetInstance("description").GetXHTML(true);
     if(rbContent == null || rbContent == "")
     {
        alert("旅游景点描述不能为空，请重新填写！");
       return false;
     }
    
   
}
</script>
<!-- 支持多语言结束 -->
</head>
<body>
<form
	action="scenicspot!<ww:if test="scenicspot.id>0">edit.action?scenicspot.id=<ww:property value="scenicspot.id"/>&<ww:property value="scenicspot.url"/></ww:if><ww:else>add.action?<ww:property value="scenicspot.url"/></ww:else>"
	name="form1" method="post" enctype="multipart/form-data" onsubmit="return form_validate()">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"> <span class="font-blue-cu">&nbsp;&nbsp;&nbsp;
		<ww:if test="scenicspot.id>0">编辑</ww:if> <ww:else>新增</ww:else>旅游景点 </span> <span
			style="display: block; width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="scenicspot.id>0||scenicspot.language>0">
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="scenicspot.ucode"/>,0)"
						<ww:if test="scenicspot.language==0">class="add"</ww:if>><img
						src="<%=request.getContextPath()%>/images/jian.gif" width="27px"
						height="26px;" align="absmiddle" style="margin-right: 15px;">简体</a></td>
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="scenicspot.ucode"/>,1)"
						<ww:if test="scenicspot.language==1">class="add"</ww:if>><img
						src="<%=request.getContextPath()%>/images/fan.gif" width="27px"
						height="26px;" align="absmiddle" style="margin-right: 15px;">繁体</a></td>
					<td width="22%"><a href="#"
						onclick="addlanguage(<ww:property value="scenicspot.ucode"/>,2)"
						<ww:if test="scenicspot.language==2">class="add"</ww:if>><img
						src="<%=request.getContextPath()%>/images/ri.gif" width="27px"
						height="26px;" align="absmiddle" style="margin-right: 15px;">日语</a></td>
					<td><a href="#"
						onclick="addlanguage(<ww:property value="scenicspot.ucode"/>,3)"
						<ww:if test="scenicspot.language==3">class="add"</ww:if>><img
						src="<%=request.getContextPath()%>/images/yin.gif" width="27px"
						height="26px;" align="absmiddle" style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
					<td width="100%" align="right"><a href="#" class="add"><img
						src="images/jian.gif" width="27px" height="26px;"
						align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		</span> </b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">

			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0" border="0"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4" height="18">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" width="13%" align="right"
							class="table_color_r colortrin"><span>景点名称：</span></td>
						<td class="table_color_l" colspan="3"><input type="text" id="txtname"
							name="name" value='<ww:property value="scenicspot.name"/>'
							style="width: 150px" />&nbsp;<span style="color:red">*</span></td>
					</tr>
					<tr>
						<td height="28" width="13%" align="right"
							class="table_color_r colortrin"><span>景点价格：</span></td>
						<td class="table_color_l" colspan="3"><input type="text" id="price"
							name="price" value='<ww:property value="scenicspot.price"/>'
							style="width: 150px" />&nbsp;<span style="color:red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>景点位置：</span></td>
						<td class="table_color_l" style="width: 100px" colspan="3"><select
							id="provinceId" style="width: 120px">
							<option>----请选择省份----</option>
							<ww:iterator value="provinceList">
								<ww:if test="s_provinceId==id">
									<option value="<ww:property value="id"/>" selected="selected"><ww:property
										value="name" /></option>
								</ww:if>
								<ww:else>
									<option value="<ww:property value="id"/>"><ww:property
										value="name" /></option>
								</ww:else>
							</ww:iterator>
						</select> <select onchange="getRegionData(this.value)" name="cityid"
							id="cityid" style="width: 120px">
							<option>----请选择城市----</option>
						</select> <select name="regionid" id="regionid" style="width: 120px">
							<option>----请选择地区----</option>
						</select></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"
							valign="top"><span>景点介绍：</span></td>
						<td class="table_color_l" colspan="3"><FCK:editor
							id="description" basePath="fck/" width="680" height="400">
							<ww:property value="scenicspot.description" />
						</FCK:editor>&nbsp;<span style="color:red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>景点图片：</span></td>
						<td class="table_color_l" colspan="3"><input type="file"
							name="s_image" style="width: 350px" /></td>
					</tr>
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="scenicspot.language>0">
						<input id="language" type="hidden" name="scenicspot.language"
							value="<ww:property value="scenicspot.language"/>" />
					</ww:if>
					<ww:else>
						<input id="language" type="hidden" name="scenicspot.language"
							value="0" />
					</ww:else>
					<input id="ucode" type="hidden" name="scenicspot.ucode"
						value="<ww:property value="scenicspot.ucode"/>" />
					<!-- 支持多语言结束 -->
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style="position: relative; width: 220px;"><input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai"
							onclick="window.location.href='scenicspot.action?<ww:property value="url"/>';"
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
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>
<script type="text/javascript">
	$().ready(function () {
		var $province =$("#provinceId");
		if ($province.val() != "" && $province.val() != "----请选择省份----") {
			getCityData($province.val());
		}
		$province.change(function () {
			var index = this.selectedIndex;
			var provinceId = this.value;
			if (provinceId != 0) {
				getCityData(provinceId);
			}
		});
	});
	
	function getCityData(index) {
		$.post("scenicspot!ajaxGetCityList.action", {s_provinceId:index}, function (data) {
			var $city = $("#cityid");
			$city.attr("options").length = 0;
			if (data) {
				var cityArr = data.split(",");
				for (var i=0; i<cityArr.length; i++) {
					var arr2 = cityArr[i].split("_");
					$city.append("<option value='"+arr2[0]+"'>"+arr2[1]+"</option>");
				}
				getRegionData(cityArr[0].split("_")[0]);
			} else {
				$city.append("<option value='-1'>----请选择城市----</option>");
			}
		});
		
	}
	
	function getRegionData(index) {
		$.post("scenicspot!ajaxGetRegionList.action", {s_cityId:index}, function (data) {
			var $region = $("#regionid");
			$region.attr("options").length = 0;
			if (data) {
				var regionArr = data.split(",");
				for (var i=0; i<regionArr.length; i++) {
					var arr2 = regionArr[i].split("_");
					$region.append("<option value='"+arr2[0]+"'>"+arr2[1]+"</option>");
				}
			} else {
				$region.append("<option value='-1'>----请选择地区----</option>");
			}
		});
	}
		
</script>

