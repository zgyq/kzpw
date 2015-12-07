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
 *
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="landmark.id>0">编辑</ww:if><ww:else>新增</ww:else>地标</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
	<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
	<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="../js/ext-all.js"></script>
    <link href="../css/base.css" rel="stylesheet" />

</head>
<link href="../css/base.css" rel="stylesheet" />
	<script type="text/javascript" src="../js/validator.js"></script>
  	<script type='text/javascript' src='../dwr/interface/dwrservice.js'></script>
  	<script type='text/javascript' src='../dwr/engine.js'></script>
  	<script type='text/javascript' src='../dwr/util.js'></script>
  	
  	<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="landmark!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
  	
<body>
<form action="landmark!<ww:if test="landmark.id>0">edit.action?id=<ww:property value="landmark.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table  width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
 <!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="landmark.id>0">编辑</ww:if><ww:else>新增</ww:else>地级市</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="landmark.id>0||landmark.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="landmark.ucode"/>,0)" <ww:if test="landmark.language==0">class="add"</ww:if>><img
					src="../images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="20%"><a href="#" onclick="addlanguage(<ww:property value="landmark.ucode"/>,1)" <ww:if test="landmark.language==1">class="add"</ww:if>><img src="../images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="landmark.ucode"/>,2)" <ww:if test="landmark.language==2">class="add"</ww:if>><img src="../images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="landmark.ucode"/>,3)" <ww:if test="landmark.language==3">class="add"</ww:if>><img src="../images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">EINGLISH</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="../images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="名称不能为空" name="name" value='<ww:property value="landmark.name"/>'" style="width:350px" /></td>  </tr>
	
	 <tr class="font-blue-xi">
              <td height="28" align="right"><span class="STYLE2">省份：</span></td>
              <td width="76">
              	 <SELECT ID="provinceid" NAME="provinceid" style="width:350px" onchange="findCityByPro(this.value),changeRegion()">
			        <ww:iterator value="findAllPro()">
							<OPTION VALUE="<ww:property value="id"/>" <ww:if test="id == city.provinceid || id == pc.id">SELECTED</ww:if>><ww:property value="name"/>
					</ww:iterator>
              		 <html:optionsCollection name="" label="name" value="id" />
				</SELECT>

              </td>
      </tr>		 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">城市：</span></td><td>
	 <!-- 
	 <input type="text" require="true" dataType="Require"   msg="城市ID不能为空" name="cityid" value='<ww:property value="landmark.cityid"/>'" style="width:350px" />
	  -->
	 <SELECT ID="cityid" NAME="cityid" style="width:350px" onchange="changeRegion();">
	 <ww:if test="landmark.id>0">
	 	<OPTION VALUE="<ww:property value="city.id"/>" SELECTED><ww:property value="city.name"/>
	 </ww:if>
		<ww:iterator value="listCity">
			<ww:if test="city.id!=id">
				<OPTION VALUE="<ww:property value="id"/>"><ww:property value="name"/>
			</ww:if>
		</ww:iterator>
	</SELECT>
	 
	 </td>  </tr>
		 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">区域类型：</span></td><td>

	 <SELECT ID="type" NAME="type" style="width:350px"  onchange="changeRegion();">
		<OPTION VALUE="行政区" <ww:if test="landmark.region.type=='行政区'">selected</ww:if> >行政区
		<OPTION VALUE="商业区" <ww:if test="landmark.region.type=='商业区'">selected</ww:if> >商业区
		<OPTION VALUE="景区" <ww:if test="landmark.region.type=='景区'">selected</ww:if> >景区
	 </SELECT>
	 
	 </td>  </tr>
	<tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">区域：</span></td><td>
	 <!-- 
	 <input type="text" require="true" dataType="Require"   msg="城市ID不能为空" name="cityid" value='<ww:property value="landmark.cityid"/>'" style="width:350px" />
	  -->
	 <SELECT ID="regionid" NAME="regionid" style="width:350px">
	 <ww:if test="landmark.id>0">
	 	<ww:if test="region != null">
	 		<OPTION VALUE="<ww:property value="region.id"/>" SELECTED><ww:property value="region.name"/>
	 		<ww:iterator value="defaultregion">
					<ww:if test="region.id!=id">
						<OPTION VALUE="<ww:property value="id"/>"><ww:property value="name"/>
					</ww:if>
			</ww:iterator>
		</ww:if>
		<ww:else>
			<ww:iterator value="defaultregion">
				<OPTION VALUE="<ww:property value="id"/>"><ww:property value="name"/>
			</ww:iterator>
		</ww:else>
	 </ww:if>
 	<ww:else>
		<ww:iterator value="defaultregion">
			<OPTION VALUE="<ww:property value="id"/>"><ww:property value="name"/>
		</ww:iterator>
	</ww:else>
	</SELECT>
	 
	 </td>  </tr>		 
 	 <!-- 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">类型：</span></td><td>
	 
	 <input type="text" require="true" dataType="Require"   msg="类型不能为空" name="type" value='<ww:property value="landmark.type"/>'" style="width:350px" />
	  

	 </td>  </tr>
	 -->
				<!-- 支持多语言开始 替换对应的类名-->
			<ww:if test="landmark.language>0">
			<input id="language" type="hidden" name="language" value="<ww:property value="landmark.language"/>"/>
			</ww:if>
			<ww:else>
			<input id="language" type="hidden" name="language" value="0"/>
			</ww:else>
			<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="landmark.ucode"/>"/>
			<!-- 支持多语言结束 --> 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no">
        
        <div style=" position: relative;">
        <input type="submit" class="button_h font-red" value="提交"/> <input type="button" class="button_h font-red" onclick="window.location.href='landmark.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> 
        		<ww:iterator value="actionMessages">
					<div id="tishi" style=" position: absolute; top:-55px; left:0px; "><img src="../images/gg.png" width="149" height="60" /></div>
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
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</body>
</html>
<script language="javascript">
	var cities = new Array(); 
		<ww:iterator value="allCity">
			cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
		</ww:iterator>
	function findCityByPro(provinceId) {
		var cityid = document.getElementById('cityid');
		for(var op in cityid.options) {
			cityid.remove(op);
		}
		for(var cityIndex in cities) {
			var city = cities[cityIndex] ;
			if(city.provinceId == provinceId) {
				var oOption = document.createElement("OPTION");
				oOption.innerHTML = city.name;
				oOption.value = city.id ;
				cityid.appendChild(oOption) ;
			}
		}
	}
	function changeRegion()
	{
		var id = document.getElementById('cityid').value;
		var type = document.getElementById('type').value;
		dwrservice.findRegByCityandtype(id,type,callBackReg);
	}
	function callBackReg(data)
	{
	 	<%-- 删除原有的数据 --%>
		DWRUtil.removeAllOptions("regionid");
		if(data=="")				
		{
			var reg = document.getElementById('regionid');
			var rOption= document.createElement("OPTION");
			rOption.value='-1';
			rOption.innerHTML='未划分区域';
			reg.appendChild(rOption) ;
		}
		<%-- 添加新的数据 --%>
		DWRUtil.addOptions("regionid", data, "id", "name"); 
		var arr = document.getElementById("regionid").options;
		for(var i=0;i<arr.length;i++){
			if(arr[i].value == "<ww:property value='landmark.region.id'/>"){
				arr[i].setAttribute("selected","selected");
			}
		}
	 }
</script>
