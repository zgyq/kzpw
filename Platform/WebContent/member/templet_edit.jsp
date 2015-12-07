
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
<title><ww:if test="templet
		.id>0">编辑</ww:if><ww:else>新增</ww:else>模板
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<script src="js/PublicJs.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jqueryUI/jquery-1.4.2.js"></script>
<link type="text/css" href="js/jqueryUI/jquery.ui.all.css"
	rel="stylesheet" />
<link type="text/css" href="js/jqueryUI/widget.css" rel="stylesheet" />
<script type="text/javascript" src="js/jqueryUI/jquery.ui.core.js"></script>
<script type="text/javascript" src="js/jqueryUI/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/jqueryUI/jquery.ui.tabs.js"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
 var staus="-1";
 $(function(){
  		// Tabs
		$("#tabs").tabs();
   });
	function btnSubmit() {        
        var templetname = $("#templetname").val();
        var templetmess = $("#templetmess").val();
        templetname = $.trim(templetname);
        templetmess = $.trim(templetmess);
 		 if (templetname.length < 1) {
            alert("模板名称不能为空!");
            $('#templetname').select();
            return false;
        } else if (templetname.length > 50) {
            alert("模板名称输入长度不能大于50");
            $('#templetname').select();
            return false;
        }else {
        ajax_templetname();
        <ww:if test="templet.id==0">
        if(staus=='-1'){
       	 	alert("模板名称已经存在");
        	return false;
        }
        </ww:if>
        } 
        
 
        if (templetmess.length == 1 || templetmess.length<1) {
            alert("模板内容不能为空!");
            $('#templetmess').select();
            return false;
        } else if (templetmess.length > 400) {
            alert("模板内容输入长度不能大于400");
            $('#templetmess').select();
            return false;
        } 
    }
    
  	function checkdancheng(){
  		var d_qidi=document.getElementById("d_qidi");
  		var d_hangban=document.getElementById("d_hangban");
  		var d_chengshi=document.getElementById("d_chengshi");
  		var d_piaohao=document.getElementById("d_piaohao");
  		if(d_qidi.checked){
  		var moban=document.getElementById("templetmess").value;
  			  document.getElementById("templetmess").value=moban+"[起抵时间]";
  		}
  		if(d_hangban.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[航班号]";
  		}
  		if(d_chengshi.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[起抵城市]";
  		}
  		if(d_piaohao.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[票号]";
  		}
  	}
  	function checkwangfan(){
  		var w_qidi=document.getElementById("w_qidi");
  		var w_hangban=document.getElementById("w_hangban");
  		var w_chengshi=document.getElementById("w_chengshi");
  		var w_piaohao=document.getElementById("w_piaohao");
  		var w_qidif=document.getElementById("w_qidif");
  		var w_hangbanf=document.getElementById("w_hangbanf");
  		var w_chengshif=document.getElementById("w_chengshif");
  		if(w_qidi.checked){
  		var moban=document.getElementById("templetmess").value;
  			  document.getElementById("templetmess").value=moban+"[起抵时间]";
  		}
  		if(w_hangban.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[航班号]";
  		}
  		if(w_chengshi.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[起抵城市]";
  		}
  		if(w_qidif.checked){
  		var moban=document.getElementById("templetmess").value;
  			  document.getElementById("templetmess").value=moban+"[起抵时间(回程)]";
  		}
  		if(w_hangbanf.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[航班号(回程)]";
  		}
  		if(w_chengshif.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[起抵城市(回程)]";
  		}
  		if(w_piaohao.checked){
  			var moban=document.getElementById("templetmess").value;
  			document.getElementById("templetmess").value=moban+"[票号]";
  		}
  	}
	
  function ajax_templetname(){
  var templetname=$("#templetname").val();
 	$.ajax({
       type:"POST",
       url:"templet!validatetempletname.action?validateValue="+templetname,
       async:false,     
       success:function(data)
       { 
        if(data=='false'){
      		 staus="-1";
			    // return "-1";
        }else{
      		 staus="1";
        	//return "1";
        }
        	
       }          
 		 }
 		  
 		 )
      
}
</script>
<body>
<div id="member">
<form
	action="templet
		!<ww:if test="templet
		.id>0">edit.action?id=<ww:property value="templet
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onsubmit="return btnSubmit()">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="templet
		.id>0">编辑</ww:if><ww:else>新增</ww:else>模板 </span></b></td>
	</tr>
	<tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<div>&nbsp;</div>
			<table width="98%" cellpadding="0" cellspacing="0" style="margin: 0 auto; ">
				<tr>
					<td  height="30" style="text-align: right;"
						class="table_color colortrin">模板名称 :<span style="color: red;">*</span>
					</td>
					<td  height="30" align="left" class="table_color_l">
					<ww:if test="templet.id>0">
						<ww:if test='templet.templettype.equals("标准模板")'>
							<input type="text" name="templetname
						" id="templetname"
								value="<ww:property value="templet.templetname"/>"
								style="width: 300px" disabled="disabled" />
						</ww:if>
						<ww:elseif test='templet.templettype.equals("自定义模板")'>
							<input type="text" name="templetname
						" id="templetname"
								value="<ww:property value="templet.templetname"/>"
								style="width: 300px" />
						</ww:elseif>
					</ww:if> <ww:else>
						<input type="text" name="templetname
						" id="templetname"
							value="<ww:property value="templet.templetname"/>"
							style="width: 300px" />
					</ww:else></td>
					<td colspan="2" rowspan="3">
					<table width="100%">
						<div class="widget">

						<div id="tabs">
						<ul>
							<li><a href="#tabs-1">单程</a></li>
							<li><a href="#tabs-2">往返</a></li>
							<li><a href="#tabs-3">模板示例</a></li>
						</ul>
						<div id="tabs-1">
						<p align="left"><input type="checkbox" name="d_qidi"
							id="d_qidi" />起抵时间<br>
						<input type="checkbox" name="d_hangban" id="d_hangban" />航班号<br>
						<input type="checkbox" name="d_chengshi" id="d_chengshi" />起抵城市<br>
						<input type="checkbox" name="d_piaohao" id="d_piaohao" />票号<br>
						<input type="button" value="添加" class="button_h" onclick="checkdancheng()" /></p>
						</div>
						<div id="tabs-2">
						<p align="left"><input type="checkbox" name="w_qidi"
							id="w_qidi" />起抵时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="checkbox" name="w_qidif" id="w_qidif" />起抵时间(回程)<br>
						<input type="checkbox" name="w_hangban" id=w_hangban />航班号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="checkbox" name="w_hangbanf" id="w_hangbanf" />航班号(回程)<br>
						<input type="checkbox" name="w_chengshi" id="w_chengshi" />起抵城市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="checkbox" name="c_chengshif" id="w_chengshif" />起抵城市(回程)<br>
						<input type="checkbox" name="w_piaohao" id="w_piaohao" />票号<br>
						<input type="button" value="添加" onclick="checkwangfan()" /></p>
						</div>
						<div id="tabs-3">
						<p>短信模板： 尊敬的客户您好，您购买的[起抵城市] [起抵时间]
						[航班号]已出票，票号为[票号]，请于航班起飞前90分钟到机场办理值机手续。祝您旅途愉快! 显示内容：
						尊敬的客户您好，您购买的北京-昆明 2010-09-29 11:55-13:10
						MU5702已出票，票号为7812355523812，请于航班起飞前90分钟到机场办理值机手续。祝您旅途愉快!</p>
						</div>
						</div>

						</div>
						<!-- End demo -->
					</table>

					</td>
				<tr />
				<tr>

					<td height="30" style="text-align: right;"
						class="table_color colortrin">模板内容 :<span style="color: red;">*</span>
					</td>
					<td  height="30" class="table_color_l" align="left">
					<!--  <input type="text"  name="templetmess
						" value='<ww:property value="templet.templetmess
						"/>'" style="width: 300px" />--> <textarea maxlength="200"
						name="templetmess" id="templetmess" rows="8" cols="50"><ww:property
						value="templet.templetmess" /></textarea></td>
					<td colspan="2"></td>
				</tr>



				<tr>
					<td  height="30" style="text-align: right;"
						class="table_color colortrin">模板所属业务 :<span
						style="color: red;">*</span></td>
					<td height="30" class="table_color_l" align="left">
					<!--  <input type="text"  name="templetyewu
						" value='<ww:property value="templet.templetyewu
						"/>'" style="width: 300px" /> <input type="radio"
					  	name="templetyewu" id="templetyewu1" value="1" checked="checked" />酒店
					<input type="radio" name="templetyewu" id="templetyewu2" value="2" />机票-->
					<select name="templetyewu">
						<ww:if test="templet.id>0">
							<option value="<ww:property value="templet.templetyewu"/>"><ww:property
								value="templet.templetyewu" /></option>
						</ww:if>
						<ww:iterator value="listbussiness">
							<option value="<ww:property value="name"/>"><ww:property
								value="name" /></option>
						</ww:iterator>
					</select></td>
					<td  height="30" style="text-align: right;"
						class="table_color colortrin">模板类型 :<span style="color: red;">*</span>
					</td>
					<td  height="30" align="left" class="table_color_l">
					<!--  <input type="text"  name="templettype
						" value='<ww:property value="templet.templettype"/>'" style="width: 300px" />-->
					<ww:if test="templet.id>0">
						<ww:if test='templet.templettype.equals("标准模板")'>
							<input type="radio" name="templettype" id="templettype"
								value="标准模板" checked="checked" />标准模板 <input type="radio"
								name="templettype" id="templettype" value="自定义模板"
								disabled="disabled" />自定义模板</td>
					</ww:if>
					<ww:else>
						<input type="radio" name="templettype" id="templettype" disabled="disabled"
							value="标准模板" />标准模板 <input type="radio" name="templettype"
							id="templettype" value="自定义模板" checked="checked" />自定义模板</td>
					</ww:else>
					</ww:if>
					<ww:else>
						<input type="radio" name="templettype" id="templettype" disabled="disabled"
							value="标准模板" />标准模板 <input type="radio" name="templettype"
							id="templettype" value="自定义模板" checked="checked" />自定义模板</td>
					</ww:else>
				</tr>

				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='templet.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
		</tr>	
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	</td>
	</tr>
	</table>
	</form>
	</div>
</body>
</html>


