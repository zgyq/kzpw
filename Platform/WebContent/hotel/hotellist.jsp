<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
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
<link rel="stylesheet" type="text/css"
	href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../js/ext-all.js"></script>
<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<script language="javascript" type="text/javascript"
	src="../My97DatePicker/WdatePicker.js"></script>
<link href="js/autocomplete/jquery.autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
<script type="text/javascript"
	src="../js/autocomplete/jquery.autocomplete.js"></script>
<title>酒店列表</title>
</head>

<body onload="load()">
<div id="cx">
<form name="form1" method="post" action="hotel!tozhutui.action">

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;主推酒店列表</span></td>
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
								<td width="15%" align="right">酒店名称：</td>
								<td width="14%" align="left"><input size="16"
									name="h_hotelname" type="text"
									value="<ww:property value="h_hotelname"/>" id="h_hotelname" /></td>
								<td width="10%" align="right">英文名称：</td>
								<td width="14%" align="left"><input size="16"
									name="h_enname" type="text"
									value="<ww:property value="h_enname"/>" id="h_enname" /></td>
								<td width="10%" align="right">酒店类型：</td>
								<td width="15%" align="left"><select name="h_type"
									style="WIDTH: 120px" id="h_type">
									<option value="0">全部</option>
									<option value="1">公寓式</option>
									<option value="2">会议型</option>
									<option value="3">度假型</option>
									<option value="4">观光型</option>
									<option value="5">综合型</option>
									<option value="6">机场型</option>
									<option value="7">别墅型</option>
									<option value="8">商务型</option>
								</select></td>
								<td width="22%" align="left">&nbsp;</td>
							</tr>
							<tr>
								<td align="right">所在省：</td>
								<td align="left"><select id="h_provinceId"
									onchange="findCityByPro(this.value)" name="h_provinceId"
									style="WIDTH: 120px">
									<option value="-1">--请选择省份--</option>
									<ww:iterator value="listProvinces">
										<option value="<ww:property value="id"/>"
											<ww:if test="id==h_provinceId">selected</ww:if>><ww:property
											value="name" /></option>
									</ww:iterator>
								</select></td>
								<td align="right">所在市：</td>
								<td>
								<div id="show"><select id="h_cityId" name="h_cityId"
									style="WIDTH: 120px">
									<ww:if test="h_provinceId < 0 || h_provinceId==null">
										<option value="-1">--请选择城市--</option>
									</ww:if>
									<ww:else>
										<ww:iterator value="citybypro()">
											<option value="<ww:property value="id"/>"
												<ww:if test="id==h_cityId">selected</ww:if>><ww:property
												value="name" /></option>
										</ww:iterator>
									</ww:else>
								</select></div>

								</td>
								<td align="right">酒店星级：</td>
								<td><select name="h_star" style="WIDTH: 120px" id="h_star">
									<option value="" selected="selected">---请选择---</option>
									<option value="1">经济型</option>
									<option value="2">准二星</option>
									<option value="3">二星级</option>
									<option value="4">准三星</option>
									<option value="5">三星级</option>
									<option value="6">准四星</option>
									<option value="7">四星级</option>
									<option value="8">准五星</option>
									<option value="9">五星级</option>
								</select></td>
								<td><input type="button" class="button_d font-white"
									value="查&nbsp;&nbsp;询" onclick="searchOne()" /></td>
							</tr>
							<tr>

								<td align="right">装修级别：</td>
								<td><select name="h_repair" style="WIDTH: 120px"
									id="h_repair">
									<option value="">---请选择---</option>
									<option value="1">豪华</option>
									<option value="2">高档</option>
									<option value="3">舒适</option>
									<option value="4">经济</option>
								</select></td>

								<td colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="chbIszhutui" name="iszhutui"
									<ww:if test="iszhutui!=null">checked="checked"</ww:if> />&nbsp;<font
									color="red">选中查询未设为首页主推的酒店列表</font></td>
							</tr>
							<tr>
								<td align="right" colspan="8">
								<div align="right" style="margin-right: 5px;"><a href="#"
									onclick="zhutuiImage()"><input type="button" value="图片主推"
									class="button_h font-red"></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
									href="#" onclick="zhutuiText()"><input type="button"
									value="文本主推" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="deleteItem()"><input
									type="button" value="撤销主推" class="button_h font-red"></a></div>
								</td>
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
						<td width="100%">
						<table id="menutable" width="99%" border="1" align="center"
							bordercolor="#a0cfee" style="border-collapse: collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">

									<th width="54" height="25">选择</th>

									<th width="25%">酒店名称</th>
									<th>所在省</th>
									<th>所在市</th>
									<th>星级</th>
									<th>推荐级别</th>
									<th>排序</th>
								</tr>

								<ww:iterator value="listHotel">
									<tr id='<ww:property value="id"/>'
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<td align="center"><input type="checkbox" name="selectid"
											value="<ww:property value="id"/>" /></td>

										<td align="left"><a
											href="hotel!toinfo.action?hotelId=<ww:property value='id'/>">
										<ww:property value="name" /></a></td>
										<td align="center"><ww:property
											value="getprovinceNamebyId(provinceid)" /></td>
										<td align="center"><ww:property
											value="getcityNamebyId(cityid)" /></td>
										<td align="center"><ww:if test="star==1">经济型</ww:if> <ww:if
											test="star==2">准二星</ww:if> <ww:if test="star==3">二星级</ww:if>
										<ww:if test="star==4">准三星</ww:if> <ww:if test="star==5">三星级</ww:if>
										<ww:if test="star==6">准四星</ww:if> <ww:if test="star==7">四星级</ww:if>
										<ww:if test="star==8">准五星</ww:if> <ww:if test="star==9">五星级</ww:if></td>
										<td align="center"><ww:if test="hot==1">特级主推(已<font
												color="red">图片</font>形式显示在首页)</ww:if> <ww:if test="hot==2">金牌主推(已<font
												color="red">文本</font>形式显示在首页) </ww:if>
										<ww:if test="hot==3">暂时主推</ww:if> <ww:if test="hot==4">一级主推</ww:if>
										<ww:if test="hot==5">零级主推</ww:if> <ww:if test="hot==6">问题酒店</ww:if>
										</td>
										<td align="center"><ww:property value="sort" /></td>
									</tr>
								</ww:iterator>

							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"><ww:property value="getPagination('\"hotel!tozhutui.action?pageinfo.pagenum=\"+pageno+\"\"')"/></td>
					</tr>
					<tr>
						<td style="color: red; margin-left: 20px" align="left">&nbsp;&nbsp;&nbsp;&nbsp;备注说明：<br />
						&nbsp;&nbsp;&nbsp;&nbsp;1.如果酒店设置为图片主推，则图片将会在首页上按照如图显示.<img
							src="../images/ImageDesc.jpg" border="0" /><br /><hr size="2px" width="100%" style="color:#ccc">
						&nbsp;&nbsp;&nbsp;&nbsp;2.如果酒店设置为文本主推，则图片将会在首页上按照如图显示.<img
							src="../images/TextDesc.jpg" border="0" />
						<br /><hr size="2px" width="100%" style="color:#ccc">
							&nbsp;&nbsp;&nbsp;&nbsp;3.主推酒店按照排序字段值在首页显示，排序值小的显示在前面。
						</td>
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
var cities = new Array(); 
	<ww:iterator value="listCities">
		cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
	</ww:iterator>
function findCityByPro(provinceId) {
	var cityid = document.getElementById('h_cityId');
	for(var op in cityid.options) {
		cityid.remove(op);
	}
	if(document.getElementById('h_provinceId').value == '-1'){
		var cOption = document.createElement("OPTION");
		cOption.innerHTML = '--请选择城市--';
		cOption.value = '-1' ;
		cityid.appendChild(cOption) ;
	}else{
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
}
function load()	{
	select();
	star();

	fitment();
	}
//酒店类型	
function select(){
		var arr = document.getElementById("h_type").options;
		for(var i=0;i<arr.length;i++){
			if('<ww:property value="h_type" />' == arr[i].value){
				arr[i].selected = true;
			}
		}
	}
	
//酒店星级
	function star(){
		var st = document.getElementById("h_star").options;
		for(var i=0; i<st.length; i++){
			if('<ww:property value="h_star"/>' == st[i].value){
			
				st[i].selected = true;
			}
		}
	}	
	

	
//装修级别
  function fitment(){
  		var st = document.getElementById("h_repair").options;
		for(var i=0; i<st.length; i++){
			if('<ww:property value="h_repair"/>' == st[i].value){
			
				st[i].selected = true;
			}
		}
	
  	
  }
		function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认撤销主推吗？');
						if(temp==true){
						
							document.form1.action="hotel!deletezhutui.action?id="+document.form1.selectid.value;
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
					      	var temp = confirm('确认撤销主推吗？');
							if(temp==true){
								document.form1.action="hotel!deletezhutui.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认撤销主推吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batchzhutui.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  function zhutuiImage(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认设置为图片主推吗？');
						if(temp==true){
						
							document.form1.action="hotel!zhutuiimage.action?id="+document.form1.selectid.value;
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
					      	var temp = confirm('确认设置为图片主推吗？');
							if(temp==true){
								document.form1.action="hotel!zhutuiimage.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认设置为图片主推吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batchzhutuiimage.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  function zhutuiText(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认设置为文本主推吗？');
						if(temp==true){
						
							document.form1.action="hotel!zhutuitext.action?id="+document.form1.selectid.value;
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
					      	var temp = confirm('确认设置为文本主推吗？');
							if(temp==true){
								document.form1.action="hotel!zhutuitext.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认设置为文本主推吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batchzhutuitext.action?opt=1";
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
			if(length==undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotel!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="hotel!toedit.action?id="+uvalue;
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
			if(length==undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotel!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="hotel!tocheck.action?id="+uvalue;
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
  function 	add(){
	
	
	window.location.href="hotel!toadd.action";
	
	
	
	
	}
		
 function 	searchOne(){
	
	
	
	
		document.form1.submit();
	
	
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


	<%--加载省份信息
		function findAllPro()
		{
				 dwrservice.findAllProvince(callBackPro); 
		}
		function callBackPro(data)
		{
		 	 删除原有的数据 
			DWRUtil.removeAllOptions("h_provinceId");
			 添加新的数据
			DWRUtil.addOptions("h_provinceId", data, "id", "name"); 
			加载页面后如果城市为空，显示城市
			var id = document.getElementById('h_provinceId').value;
			dwrservice.findCityByProid(id,callBackCity);
		 }
		 根据省份id加载城市信息
		 function findCityByProid(id)
		{
				dwrservice.findCityByProid(id,callBackCity);			 
		}
		function callBackCity(data)
		{
		 	 删除原有的数据
			DWRUtil.removeAllOptions("h_cityId");
			 添加新的数据 
			DWRUtil.addOptions("h_cityId", data, "id", "name"); 
		 }-->
		 <%-- 加载页面后如果城市为空，显示城市 
		 function fullCity(id)
		{
			var id = document.getElementById('provinceid').value;
			findCityByProid(id);
		}
		--%>
		
</script>
