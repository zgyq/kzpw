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
<script>
Ext.onReady(function(){

	 var selectId ="";

	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		    {
                id:"new",
				text: '新建',
				icon:"../images/menu/new.gif",
				handler : function(item){
					window.location.href="hotel!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.form1.action="hotel!toedit.action?id="+selectId;
						document.form1.submit();
				}
            }
           
          //  ,	
          //  '-',
		//	{
        //        id:"check",
		//		text:"审核",
		//		disabled:false,
		//		icon:"../images/menu/check.gif",
		//		handler :function(item){
		//				document.form1.action="hotel!tocheck.action?id="+selectId;
		//				document.form1.submit();
					
		//		}
        //    }
			
			
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});
</script>
</head>

<body onload="load()">
<div id="cx">
<form name="form1" method="post" action="hotel.action">

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店列表</span></td>
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
									value="查&nbsp;&nbsp;询" onclick="searchOne()" />
									
									</td>
							</tr>
							<tr>
								<td align="right">推荐级别：</td>
								<td><select name="h_recommend" style="WIDTH: 120px"
									id="h_recommend">
									<option value="" selected="selected">---请选择---</option>
									<option value="1">图片主推</option>
									<option value="2">文本主推</option>
									<option value="3">首页图片</option>
									<option value="4">首页文本</option>
									<!--<option value="3">暂时主推</option>
									<option value="4">一级主推</option>
									<option value="5">零级主推</option>
									<option value="6">问题酒店</option>
										-->
								</select></td>
								<!--<td align="right">酒店来源：</td>
								<td><select name="h_laiyuan" style="WIDTH: 120px"
									id="h_laiyuan">
									<option value="">---请选择---</option>
									<option value="1" <ww:if test="h_laiyuan==1">selected</ww:if> >芒果</option>
									<option value="2" <ww:if test="h_laiyuan==2">selected</ww:if>>经纪人签约</option>
									
								</select></td>
								--><td align="right">酒店状态：</td>
								<td><select name="h_state" style="WIDTH: 120px"
									id="h_state">
									<option value="">---请选择---</option>
									<option value="3">上网</option>
									<option value="4">下网</option>
									<option value="0">待审核</option>
								</select></td>
								<td>&nbsp;</td>
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
						<td>
											
						<table width="100%" height="40" border="0" cellspacing="0"
							cellpadding="0" class="lj"
							style="font-size: 12px; font-weight: bold; line-height: 25px;">
							<tr>
								<td align="center">&nbsp;</td>
								<td>
								<div align="right" style="margin-right: 5px;"><!--
                <a href="hotel!toadd.action"><input type="button" value="新增" class="button_h font-red"></a>
                 --><a href="#" onclick="add()"><input type="button"
									value="新增" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
									type="button" value="修改" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
									type="button" value="删除" class="button_h font-red"></a>
									
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="hotelzhutui(1)"><input
									type="button" value="图片主推" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="hotelzhutui(2)"><input
									type="button" value="文本主推" class="button_h font-red"></a>
									
									&nbsp;&nbsp;&nbsp;<a href="#" onclick="hotelzhutui(3)"><input
									type="button" value="首页图片" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="hotelzhutui(4)"><input
									type="button" value="首页文本" class="button_h font-red"></a>
									
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="hotelzhutui(0)"><input
									type="button" value="取消主推" class="button_h font-red"></a>
									
										
									<!--
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
									type="button" value="审核" class="button_h font-red">
								&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="checkoutItem()"><input
									type="button" value="下线" class="button_h font-red"></a>
								-->
									</div>
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

									<th>星级</th>
									<th>区域</th>
									<th>推荐类型</th>
									<!--
									<th>装修级别</th>
									
									<th>酒店类型</th>-->
									<th>所在省</th>
									<th>所在市</th>
									<!--<th>酒店来源</th>
									--><th>酒店状态</th>
									<th>操作</th>


								</tr>

								<ww:iterator value="listHotel">
									<tr id='<ww:property value="id"/>'
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<td align="center"><input type="checkbox" name="selectid"
											value="<ww:property value="id"/>" /></td>

										<td align="left"><a
											href="hotel!todetails.action?hotelId=<ww:property value='id'/>">
										<ww:property value="name" /></a></td>
										<td align="center"><ww:if test="star==1">经济型</ww:if> <ww:if
											test="star==2">准二星</ww:if> <ww:if test="star==3">二星级</ww:if>
										<ww:if test="star==4">准三星</ww:if> <ww:if test="star==5">三星级</ww:if>
										<ww:if test="star==6">准四星</ww:if> <ww:if test="star==7">四星级</ww:if>
										<ww:if test="star==8">准五星</ww:if> <ww:if test="star==9">五星级</ww:if></td>
										<td align="center"><ww:property value="getRegionNameByStr(regionid1)" /><ww:property value="getRegionNameByStr(regionid2)" /><ww:property value="getRegionNameByStr(regionid3)" /></td>
										<td align="center">
										<ww:if test="websign==0||websign==null"></ww:if>
										<ww:if test="websign==1">图片主推</ww:if>
										<ww:if test="websign==2">文本主推</ww:if>
										<ww:if test="websign==3">首页图片</ww:if>
										<ww:if test="websign==4">首页文本</ww:if>
										
										</td>
										<!--
										<td align="center"><ww:if test="hot==1">特级主推</ww:if> <ww:if
											test="hot==2">金牌主推</ww:if> <ww:if test="hot==3">暂时主推</ww:if>
										<ww:if test="hot==4">一级主推</ww:if> <ww:if test="hot==5">零级主推</ww:if>
										<ww:if test="hot==6">问题酒店</ww:if></td>
										
										--><!--<td align="center"><ww:if test="repair==1">豪华</ww:if> <ww:if
											test="repair==2">高档</ww:if> <ww:if test="repair==3">舒适</ww:if>
										<ww:if test="repair==4">经济</ww:if></td>
									
										<td align="center"><ww:if test="type==1">公寓式</ww:if> <ww:if
											test="type==2">会议型</ww:if> <ww:if test="type==3">度假型</ww:if>
										<ww:if test="type==4">观光型</ww:if> <ww:if test="type==5">综合型</ww:if>
										<ww:if test="type==6">机场型</ww:if> <ww:if test="type==7">别墅型</ww:if><ww:if
											test="type==8">商务型</ww:if></td>	-->
										<td align="center"><ww:property
											value="getPavNamebycityId(cityid)" /></td>
										<td align="center"><ww:property
											value="getcityNamebyId(cityid)" /></td><!--
										<td align="center">
										<ww:if test="sourcetype==1">芒果</ww:if> 
										<ww:if test="sourcetype==2">经纪人</ww:if>
										
										</td>
										--><td align="center"><ww:if test="state==3">上网</ww:if> <ww:if
											test="state==4">下网</ww:if><ww:if test="state==0">待审核</ww:if></td>
										<td align="center"><ww:if test="state==4">
											<a href="hotel!qiyong.action?id=<ww:property value="id"/>"><font
												color="#FF0000">启用</font></a>
										</ww:if> <ww:if test="state==0">
											<a href="hotel!jinyong.action?id=<ww:property value="id"/>">禁用</a>
										</ww:if> <ww:if test="state==3">
											<a href="hotel!jinyong.action?id=<ww:property value="id"/>">禁用</a>
										</ww:if>
										&nbsp;|&nbsp;
										<a href="hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=1">图片主推</a>&nbsp;|&nbsp;
										<a href="hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=2">文本主推</a>&nbsp;|&nbsp;
										<a href="hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=3">首页图片</a>&nbsp;|&nbsp;
										<a href="hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=4">首页文本</a>&nbsp;|&nbsp;
										<a href="hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=0">取消主推</a>
										</td>
									</tr>
								</ww:iterator>

							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"><ww:property
							value="pagination" /></td>
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
//	alert(<ww:property value="id"/>);
		cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
	</ww:iterator>
//	alert(cities);
function findCityByPro(provinceId) {
//alert(provinceId);
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
	state();
	hot();
	//fitment();
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
	
//酒店状态
	function state(){
		var st = document.getElementById("h_state").options;
		for(var i=0; i<st.length; i++){
			if('<ww:property value="h_state"/>' == st[i].value){
			
				st[i].selected = true;
			}
		}
	}	
//推荐级别
	function hot(){
		var st = document.getElementById("h_recommend").options;
		for(var i=0; i<st.length; i++){
			if('<ww:property value="h_recommend"/>' == st[i].value){
			
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
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="hotel!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="hotel!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  function hotelzhutui(ty){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						if(ty=='1'){
						var temp = confirm('确认图片主推吗？');
						}
						if(ty=='2'){
						var temp = confirm('确认文本主推吗？');
						}
							if(ty=='3'){
								var temp = confirm('确认首页图片主推吗？');
								}
								if(ty=='4'){
								var temp = confirm('确认首页文本主推吗？');
								}
						if(ty=='0'){
						var temp = confirm('确认取消主推吗？');
						}
						
						if(temp==true){
						//hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=1
							document.form1.action="hotel!zhutui.action?id="+document.form1.selectid.value+"&hoteltype="+ty;
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
							    if(ty=='1'){
								var temp = confirm('确认图片主推吗？');
								}
								if(ty=='2'){
								var temp = confirm('确认文本主推吗？');
								}
									if(ty=='3'){
								var temp = confirm('确认首页图片主推吗？');
								}
								if(ty=='4'){
								var temp = confirm('确认首页文本主推吗？');
								}
								if(ty=='0'){
								var temp = confirm('确认取消主推吗？');
								}
					      	//var temp = confirm('确认主推或取消主推吗？');
							if(temp==true){
							//hotel!zhutui.action?id=<ww:property value="id"/>&hoteltype=1
								document.form1.action="hotel!zhutui.action?id="+uvalue+"&hoteltype="+ty;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
							    if(ty=='1'){
								var temp = confirm('确认图片主推吗？');
								}
								if(ty=='2'){
								var temp = confirm('确认文本主推吗？');
								}
								if(ty=='3'){
								var temp = confirm('确认首页图片主推吗？');
								}
								if(ty=='4'){
								var temp = confirm('确认首页文本主推吗？');
								}
								if(ty=='0'){
								var temp = confirm('确认取消主推吗？');
								}
					      //	var temp = confirm('确认主推或取消主推吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!hotelzhutuibatch.action?opt=1&hoteltype="+ty;
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  function checkoutItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认下线吗？');
						if(temp==true){
						
							document.form1.action="hotel!checkout.action?id="+document.form1.selectid.value;
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
					      	var temp = confirm('确认下线吗？');
							if(temp==true){
								document.form1.action="hotel!checkout.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认下线吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batchout.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  function checkIfan(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认设置吗？');
						if(temp==true){
						
							document.form1.action="hotel!toaddfan.action?hotelid="+document.form1.selectid.value;
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
					      	var temp = confirm('确认设置吗？');
							if(temp==true){
								document.form1.action="hotel!toaddfan.action?hotelid="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认设置吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!toaddfan.action?opt=1";
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