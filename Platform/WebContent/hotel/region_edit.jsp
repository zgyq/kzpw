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
<title><ww:if test="region.id>0">编辑</ww:if><ww:else>新增</ww:else>区域</title>

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

  	
  	
<body>
<form action="region!<ww:if test="region.id>0">edit.action?id=<ww:property value="region.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table  width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">

  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="名称不能为空" name="name" value='<ww:property value="region.name"/>'" style="width:350px" /></td>  </tr>
	
	<tr class="font-blue-xi">
              <td height="28" align="right"><span class="STYLE2">省份：</span></td>
              <td width="76">
              	 <SELECT ID="provinceid" NAME="provinceid" style="width:350px" onchange="findCityByPro(this.value),changeRegion()">
              	 	<ww:iterator value="findAllPro()">
							<OPTION VALUE="<ww:property value="id"/>" <ww:if test="id == city1.provinceid || id == pc.id">SELECTED</ww:if>><ww:property value="name"/>
					</ww:iterator>
              		 <html:optionsCollection name="" label="name" value="id" />
				</SELECT>

              </td>
      </tr>				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">城市：</span></td><td>
	 <!-- 
	 <input type="text" require="true" dataType="Require"   msg="城市id不能为空" name="cityid" value='<ww:property value="region.cityid"/>'" style="width:350px" />
	  -->
	 <SELECT ID="cityid" NAME="cityid" style="width:350px" onchange="changeRegion();">
	 <ww:if test="city1.id>0">
	 	<OPTION VALUE="<ww:property value="city1.id"/>" SELECTED><ww:property value="city1.name"/>
	 </ww:if>
		<ww:iterator value="listCity">
			<ww:if test="city1.id!=id">
				<OPTION VALUE="<ww:property value="id"/>"><ww:property value="name"/>
			</ww:if> 
		</ww:iterator>
	</SELECT>
	 </td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">区域类型：</span></td><td>
	 <!-- 
	 <input type="text" require="true" dataType="Require"   msg="区县类型不能为空" name="type" value='<ww:property value="region.type"/>'" style="width:350px" />
	  -->
	 <SELECT ID="type" NAME="type" style="width:350px" onchange="changeRegion();">
		<OPTION VALUE="行政区" <ww:if test="region.type=='行政区'">selected</ww:if> >行政区
		<OPTION VALUE="商业区" <ww:if test="region.type=='商业区'">selected</ww:if> >商业区
		<OPTION VALUE="景区" <ww:if test="region.type=='景区'">selected</ww:if> >景区
	 </SELECT>
	 
	 </td>  </tr>
	
				 
     <tr class="font-blue-xi">
              <td height="28" align="right"><span class="STYLE2">所属行政区：</span></td>
              <td width="76">
              	 <SELECT ID="regionid" NAME="regionid" style="width:350px" <ww:if test="region.type=='行政区' || region.type==null ">disabled="disabled"</ww:if>>
              	 <ww:if test="region.type=='行政区' || region.type==null "><OPTION VALUE="-1" >--行政区不需选择所属行政区--</ww:if>
              	 <ww:else>
              	 	<ww:iterator value="listRegbytype">
							<OPTION VALUE="<ww:property value="id"/>" <ww:if test="id == region.regionid">SELECTED</ww:if>><ww:property value="name"/>
					</ww:iterator>
              	 </ww:else>
				</SELECT>

              </td>
      </tr>	
   	   
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no">
         <div style=" position: relative;">
        <input type="submit" class="button_h font-red" value="提交"/> <input type="button" class="button_h font-red" onclick="window.location.href='region.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> 
       
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
		var cid = document.getElementById("cityid").value;
		var rid = document.getElementById("type").value;
		if(rid == '行政区')
		{
			DWRUtil.removeAllOptions("regionid");
			var region = document.getElementById('regionid');
			var rOption= document.createElement("OPTION");
			rOption.value='-1';
			rOption.innerHTML='--行政区不需选择所属行政区--';
			region.appendChild(rOption);
			document.getElementById("regionid").disabled = 'disabled';
		}else{
			document.getElementById("regionid").disabled = '';
			dwrservice.findRegionByCity(cid,callBackXRegion);
		}
		
		
	}
	function callBackXRegion(data)
	{
		<%-- 删除原有的数据 --%>
		DWRUtil.removeAllOptions("regionid");
		<%-- 添加新的数据 --%>
		if(data.length<1 || data == null)
		{
			var region = document.getElementById('regionid');
			var rOption= document.createElement("OPTION");
			rOption.value='-1';
			rOption.innerHTML='--暂无行政区信息--';
			region.appendChild(rOption);
		}
		document.getElementById("regionid").disabled = '';
		DWRUtil.addOptions("regionid", data, "id", "name"); 
		var arr = document.getElementById("regionid").options;
		for(var i=0;i<arr.length;i++){
			if(arr[i].value == "<ww:property value='region.regionid'/>"){
				arr[i].setAttribute("selected","selected");
			}
		}
	}
</script>