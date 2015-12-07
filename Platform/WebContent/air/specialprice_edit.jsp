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
<title><ww:if test="specialprice.id>0">编辑</ww:if><ww:else>新增</ww:else>特价机票信息（定期更新）</title>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
	<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<script src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/city-control/aircity.js"></script>
<script type="text/javascript" src="js/internal/aircity.js"></script>
<script type="text/javascript" src="js/city-control/j.dimensions.js"></script>
<script type="text/javascript" src="js/city-control/j.suggest.js"></script>

<script type="text/javascript">
	var commonallcity=new Array(); 
    var allcity=new Array();
	  //页面加载
    $(document).ready(function()
	   {
	    commonallcity=commoncitys;
	    allcity= citys;
	    $("#rdoTicketTypeinter").click(function(){
	        commonallcity=intercommoncitys;
	        allcity=intercitys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	     $("#rdoTicketTypelocal").click(function(){
	        commonallcity=commoncitys;
	        allcity=citys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	    //加载城市控件数据
	    $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
	     });
	     
	     function oncheck(){
     var startport=document.getElementById("hidDepCity").value;
     var arrayport=document.getElementById("hidArrCity").value;
     var zhekou=document.getElementById("zhekou").value;
     var price=document.getElementById("price").value;
     var flytime=document.getElementById("flytime").value;
     var updatetime=document.getElementById("updatetime").value;
     var reg=/^-?\d+$/;//判断是否位数字
   if(startport==""){
     alert("请正确选择起飞机场名称");
     return;
   }else if(arrayport==""){
      alert("请争取选择目的地机场名称");
      return;
   }else if(zhekou==""||!reg.test(zhekou)){
      alert("请正确填写折扣价");
      return document.getElementById("zhekou").focus();
   }else if(price==""||!reg.test(price)){
      alert("请正确填写价格");
      return document.getElementById("price").focus();
   }else if(flytime==""){
      alert("请正确选择起飞时间");
      return document.getElementById("flytime").focus();
   }else{
     document.form1.submit();
     return true;
   }
}

</script>
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

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="specialprice.id>0">编辑</ww:if><ww:else>新增</ww:else>特价机票信息（定期更新）</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="specialprice!<ww:if test="specialprice.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" >

		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr><td height="28" align="right"><span>机票类型：</span></td><td>&nbsp;&nbsp;<input type="radio" value="0" checked="checked" name="ticket" id="rdoTicketTypelocal">国内机票&nbsp;&nbsp;&nbsp;<input type="radio" value="1" name="ticket" id="rdoTicketTypeinter">国际机票</td></tr>
					<tr>
						<td height="28" align="right"><span>起飞机场：</span></td>
						<td><input type="text" id="txtDepCity" require="true"
							dataType="Require" msg="起飞机场不能为空" name="startport1"
							value='<ww:property value="specialprice.startport"/>'
							" style="width: 250px"
							onfocus="if(this.value='北京'){this.value='';}"
							onblur="if(this.value=='') {this.value='PFK';}" />
							<div id='suggest' class="ac_results"></div>
								<input type="hidden" id="hidDepCity" value="PEK" name="startport" />
							</td>
					</tr>


					<tr>
						<td height="28" align="right"><span>目的机场：</span></td>
						<td><input type="text" id="txtArrCity" require="true"
							dataType="Require" msg="目的机场不能为空" name="arrivalport1"
							value='<ww:property value="specialprice.arrivalport"/>'
							" style="width: 250px" />
							<div id='suggest2' class="ac_results"></div>
							<input type="hidden" id="hidArrCity" name="arrivalport" />
							</td>
					</tr>


					<tr>
						<td height="28" align="right"><span>折扣：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="折扣不能为空" name="discount" id="zhekou"
							value='<ww:property value="specialprice.discount"/>'
							" style="width: 250px" /><font class="hong_xi" style="color:red">&lowast;</font>&nbsp;<font id="vzhekou" style="color:red">折扣必须输入整数</font></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>价格：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="价格不能为空" name="price" id="price"
							value='<ww:property value="specialprice.price"/>'
							" style="width: 250px"/><font class="hong_xi" style="color:red">&lowast;</font>&nbsp;<font id="vprice" style="color:red">价格必须输入数字</font></td>
					</tr>

					<tr>
						<td height="28" align="right"><span>起飞时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="起飞时间不能为空" name="flytime" id="flytime"
							value='<ww:property value="specialprice.starttime"/>'
							" style="width: 250px" class="Wdate" onfocus="WdatePicker()" /></td>
					</tr>


					<tr>
						<td height="28" align="right"><span>更新时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="更新时间不能为空" name="updatetimes" id="updatetime"
							value='<ww:property value="specialprice.updatetime"/>'
							" style="width: 250px" class="Wdate" onfocus="WdatePicker()" /></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="button"
							class="button_d font-bai" value="提交" onclick="oncheck()"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='specialprice.action?<ww:property value="url"/>';"
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


