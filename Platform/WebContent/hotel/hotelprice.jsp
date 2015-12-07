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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../js/autocomplete/jquery.autocomplete.css" rel="stylesheet" />

<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<link href="../css/base.css" rel="stylesheet" />
<title>酒店价格列表</title>
</head>



<ww:if test="checkrad==1">
	<body  onload="checkcity(1);">
	</ww:if>
	<ww:if test="checkrad==2">
	<body onload="checkcity(2);">
	</ww:if>

<form name="form1" method="post" action="hotelprice!tosearch.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
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
						<table width="100%" border="0" align="center">
						<tr>
								<td colspan="6" height="15px" style="padding-left: 40px;display:none">
								<input type="radio" name="checkrad" value="1"  checked="checked" <ww:if test="checkrad==1">checked</ww:if> onclick="checkcity(1)"/>国内
			                 	<input type="radio" name="checkrad" value="2" <ww:if test="checkrad==2">checked</ww:if> onclick="checkcity(2)"/>国际
								</td>
							</tr>
							<tr>
								<td width="77" align="left" style="display:none">语言：</td>
								<td width="45" style="display:none"><select name="lan">
										<option value="0" <ww:if test="lan==0">selected</ww:if> >中文</option>
										<option value="1" <ww:if test="lan==1">selected</ww:if> >繁体</option>
										<option value="2" <ww:if test="lan==2">selected</ww:if> >日语</option>
										<option value="3" <ww:if test="lan==3">selected</ww:if> >英语</option>
								</select>
								</td>
			
								<td width="278" align="right" id="guonei1" style="display: block;">省份：</td>
								<td width="122" align="left" style="padding-left: 3px" id="guonei11" style="display: block;"><select id="provinceId"
									style="WIDTH: 120px" name="h_provinceId">
									<option>---请选择---</option>
									<ww:iterator value="listProvinces">
										<option value="<ww:property value="id"/>"
											<ww:if test="id==h_provinceId">selected</ww:if>><ww:property
											value="name" /></option>
									</ww:iterator>
								</select></td>
								
								<td width="80" align="right" id="guonei111" style="display: block;">地级市：</td>
								<td width="191" style="padding-left: 3px;" id="guonei1111" style="display: block;"><select
									onchange="getRegionData(this.value)" id="cityid"
									style="WIDTH: 120px" name="h_cityId">
									<option value="-1">---请选择---</option>
								</select></td>
							
								<td id="guoji222" style="display: none;">&nbsp;</td>
								<td id="guoji2222" style="display: none;">&nbsp;</td>
								<td width="80" align="right" id="guoji2" style="display: none;">国际城市：</td>
								<td width="191" style="padding-left: 3px;display: none;" id="guoji22" >
								<select id="cityid2" style="WIDTH: 120px" name="h_cityId2">
								<ww:iterator value="listCities">
									<option value="<ww:property value="id"/>" <ww:if test="id==h_cityId2">selected</ww:if>><ww:property value="name"/></option>
									</ww:iterator>
								</select></td>
				
			
								<td width="77" align="right">酒店名称：</td>
								<td width="457"><input id="startnum4" style="WIDTH: 130px"
									name="hotelName" value="<ww:property value="hotelName"/>"/></td>
							</tr>
							<tr>
								<td colspan="6" align="right" height="15px"></td>
							</tr>
							<tr>
								<td colspan="6" align="center"><input name="button1"
									type="button" class="button_d font-white" value="查询"
									onclick="searchOne();" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									name="button2" type="button" class="button_d font-white"
									onclick="viewOverdue();" value="即将过期酒店" /></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td>
						<table width="99%" border="0" cellspacing="0" cellpadding="0">

							<tr>
								<td height="27" align="center"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="99%">
						<table width="99%" border="1" align="center" bordercolor="#a0cfee"
							style="border-collapse: collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">
									<th width="334" height="25">酒店名称</th>
									<th width="458">酒店房型</th>
									<th width="458">查&nbsp;&nbsp;看</th>
								</tr>
								<ww:iterator value="listHotel">
									<tr
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
										<td>&nbsp;&nbsp;&nbsp;&nbsp;<span
											id="hotelName<ww:property value="id"/>"><ww:property
											value="name" /></span></td>
										<td align="center"><input type="hidden"
											id="hotelid<ww:property value="id"/>"
											name="hotelid<ww:property value="id"/>"
											value="<ww:property value="id"/>" /> <select
											id="roomtypeid<ww:property value="id"/>" style="WIDTH: 120px">
											<option value="-1" selected="selected">--房型--</option>
											<ww:iterator value="getAllRoomType(id)">
												<option value="<ww:property value="id"/>"><ww:property
													value="name" /></option>
											</ww:iterator>
										</select></td>
										<td align="center"><a
											href="javascript:toprice(<ww:property value="id"/>);">维护价格</a></td>
									</tr>
								</ww:iterator>
							</tbody>
							<tr>
								<td colspan="3" align="center"><ww:property
									value="pagination" /></td>
							</tr>
						</table>
	
</body>
</html>
<script language="JavaScript">
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
	function checkcity(a){
	//alert(a);
	    	if(a==1){
	    	//document.getElementById("provinceId").value="";
	  //document.getElementById("cityid2").value="";
	document.getElementById("guoji2").style.display="none";
	document.getElementById("guoji22").style.display="none";
	document.getElementById("guoji2222").style.display="none";
	document.getElementById("guoji222").style.display="none";

   document.getElementById("guonei1").style.display="block";
   document.getElementById("guonei11").style.display="block";
   document.getElementById("guonei111").style.display="block";
   document.getElementById("guonei1111").style.display="block";
	    	}
		if(a==2){
			//document.getElementById("provinceId").value="";
	    	//document.getElementById("cityid").value="";
	document.getElementById("guonei1").style.display="none";
	document.getElementById("guonei11").style.display="none";
	document.getElementById("guonei111").style.display="none";
	document.getElementById("guonei1111").style.display="none";
   document.getElementById("guoji2").style.display="block";
   document.getElementById("guoji22").style.display="block";
   document.getElementById("guoji222").style.display="block";
   document.getElementById("guoji2222").style.display="block";
	    	}
	    	
	    	}
	
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
				
			} else {
				$city.append("<option value='-1' >----请选择城市----</option>");
			}
		});
		
	}
	
	
	
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="hotelprice!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="hotelprice!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="hotelprice!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotelprice!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="hotelprice!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotelprice!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="hotelprice!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
 
			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}
 function searchOne()
 {
 	
 	document.form1.submit();
 }

 function toprice(id)
 {
 	var roomtypeid = document.getElementById("roomtypeid"+id).value;
 	var hotelid = document.getElementById("hotelid" + id).value;
 	var hotelName = document.getElementById("hotelName"+id).innerHTML;
 
	window.location.href="hotelprice!toPriceVindicate.action?roomtype.hotelid=" +hotelid +"& hotelprice.roomid ="+roomtypeid+"& hotelName="+hotelName;
	
	
 }

function viewOverdue(){
	var provinceid = document.getElementById("provinceId").value;
	//alert(provinceid);
	var citiesid = document.getElementById("cityid").value;
	if(provinceid==""){
	alert("请选择省份!");
	return;
	}
	if(citiesid==""){
	alert("请选择城市!");
	return;
	}
	document.form1.action="hotelprice!overdue.action";
	document.form1.submit();
	//window.location.href="hotelprice!overdue.action?h_provinceId="+provinceid+"& h_cityId="+citiesid;
}
	<!--加载省份信息-->
		function findAllPro()
		{
				 dwrservice.findAllProvince(callBackPro); 
		}
		function callBackPro(data)
		{
		 	<%-- 删除原有的数据 --%>
			DWRUtil.removeAllOptions("h_provinceId");
			<%-- 添加新的数据 --%>
			DWRUtil.addOptions("h_provinceId", data, "id", "name"); 
			<%-- 加载页面后如果城市为空，显示城市--%>
			var id = document.getElementById('h_provinceId').value;
			dwrservice.findCityByProid(id,callBackCity);
		 }
		 <!--根据省份id加载城市信息-->
		 function findCityByProid(id)
		{
				dwrservice.findCityByProid(id,callBackCity);			 
		}
		function callBackCity(data)
		{
		 	<%-- 删除原有的数据 --%>
			DWRUtil.removeAllOptions("h_cityId");
			<%-- 添加新的数据 --%>
			DWRUtil.addOptions("h_cityId", data, "id", "name"); 
		 }
		 <%-- 加载页面后如果城市为空，显示城市 
		 function fullCity(id)
		{
			var id = document.getElementById('provinceid').value;
			findCityByProid(id);
		}
		--%>

</script>
<!--<script type="text/javascript">
function onchangeprovince()
{
	
	
   $.post("hotelprice!getcity.action",{'h_provinceId':document.getElementById("h_provinceId").value,"h_cityId":<ww:property value="h_cityId"/>},function(response){
      document.getElementById("show").innerHTML=response;
	   }
	); 
}
</script>-->