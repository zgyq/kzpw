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
<title><ww:if test="teamapply.id>0">编辑</ww:if><ww:else>新增</ww:else>团队申请表</title>

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
<link href="style/autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="js/flightcity.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/j.dimensions.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />

<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	add();
	
		 $(function(){
			$("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
		});
		
		
	
			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
 function trim(str){ //删除左右两端的空格 
return str.replace(/(^\s*)|(\s*$)/g, ""); 
} 

	function add() {
	var chengren = "0"
	var ertong = "0";
	var yinger = "0";
	
	var chengren2 = document.getElementById("chengren").value;
	var ertong2 = document.getElementById("ertong").value;
	var yinger2 = document.getElementById("yinger").value;
	
	 
          chengren=parseInt(chengren);
          if(trim(chengren2)!="")
          {
            chengren+=parseInt(chengren2); 
          }
	 	ertong=parseInt(ertong);
          if(trim(ertong2)!="")
          {
            ertong+=parseInt(ertong2); 
          }
           yinger=parseInt(yinger);
          if(trim(yinger2)!="")
          {
            yinger+=parseInt(yinger2); 
          }
	
	
	
	
	document.getElementById("numberpeople").value = parseInt(chengren)+parseInt(ertong)+parseInt(yinger);
	
	document.getElementById("numberpeople2").value = parseInt(chengren)+parseInt(ertong)+parseInt(yinger);			
				}

</script>
<script type="text/javascript" language="javascript">
		
</script>
<body onload="LoadCityData();">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="teamapply.id>0">编辑</ww:if><ww:else>新增</ww:else>团队申请表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1"
			action="teamapply!<ww:if test="teamapply.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"


<div style="width: 90%; margin:0 auto; margin-top: 20px; border: 2px dashed #b3b3b3; padding-left: 20px; background: #f0f0f0; color:#333333">操作指引： 团队票申请  ->  等待供票商报价  ->  等待选择(分销商选择报价) -> 等待创建(分销商创建订单) -> 创建成功 -> 分销商立即支付 ->  供票商出票完成 </div>




		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>

					<!--<tr><td height="28" align="right"><span>所属加盟商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="所属加盟商ID不能为空" name="typeid" value='<ww:property value="teamapply.typeid"/>'" style="width:350px" /></td>  </tr>
 
	 -->
					<tr>
						<td height="28" align="right"><span>航班类型：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="航班类型不能为空" name="flighttype" value='<ww:property value="teamapply.flighttype"/>'" style="width:350px" />
	 --> <ww:if test="teamapply.id>0">
							<input type="radio" name="flighttype" value="1"
								<ww:if test="teamapply.flighttype==1">checked</ww:if> />单程<input
								type="radio" name="flighttype" value="2"
								<ww:if test="teamapply.flighttype==2">checked</ww:if> />往返
	
	 </ww:if><ww:else>
							<input type="radio" name="flighttype" value="1" checked="checked" />单程<input
								type="radio" name="flighttype" value="2" />往返
	
	 </ww:else></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>乘客类型：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="乘客类型不能为空" name="usertype" value='<ww:property value="teamapply.usertype"/>'" style="width:350px" />
	 --> <ww:if test="teamapply.id>0">
							<input type="radio" name="usertype" value="1"
								<ww:if test="teamapply.usertype==1">checked</ww:if> />内宾<input
								type="radio" name="usertype" value="2"
								<ww:if test="teamapply.usertype==2">checked</ww:if> />外宾
	
	 </ww:if><ww:else>
							<input type="radio" name="usertype" value="1" checked="checked" />内宾<input
								type="radio" name="usertype" value="2" />外宾
	
	 </ww:else></td>
					</tr>

					<tr>
						<td height="28" align="right"><span>航空公司：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="航空公司不能为空" name="ca" value='<ww:property value="teamapply.ca"/>'" style="width:350px" />
	 --> <select name="ca">
							<ww:iterator value="listAircompany">
								<option value="<ww:property value="aircomcode"/>"
									<ww:if test="teamapply.ca==aircomcode">selected</ww:if>><ww:property
									value="aircomcnname" /></option>
							</ww:iterator>
						</select></td>
					</tr>


					<tr>
						<td height="28" align="right"><span>出发城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出发城市不能为空" name="" id="arrcity"
							value='<ww:property value="getAirnamebySZM(teamapply.startcity)"/>'
							" style="width: 350px" />
						<div id='suggest' class="ac_results"></div>
						<input type="hidden" id="city_from_hide" name="startcity"
							value="teamapply.startcity" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>到达城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="到达城市不能为空" name="" id="tocity"
							value='<ww:property value="getAirnamebySZM(teamapply.endcity)"/>'
							" style="width: 350px" />
						<div id='suggest2' class="ac_results"></div>
						<input type="hidden" id="city_to_hide" name="endcity"
							value="teamapply.endcity" /></td>
					</tr>





					<tr>
						<td height="28" align="right"><span>成人人数：</span></td>
						<td><input type="text" require="true" dataType="Require" desc="成人人数" class="validate[required],custom[onlyNumber]"
							msg="乘机人数不能为空" name="chengren" id="chengren" onblur="add()"
							value='<ww:property value="teamapply.chengren"/>'
							" style="width: 350px" />如果没有.填写0</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>儿童人数：</span></td>
						<td><input type="text" require="true" dataType="Require" desc="儿童人数" class="validate[required],custom[onlyNumber]"
							msg="乘机人数不能为空" name="ertong" id="ertong" onblur="add()"
							value='<ww:property value="teamapply.ertong"/>'
							" style="width: 350px" />如果没有.填写0</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>婴儿人数：</span></td>
						<td><input type="text" require="true" dataType="Require" desc="婴儿人数" class="validate[required],custom[onlyNumber]"
							msg="乘机人数不能为空" name="yinger" id="yinger" onblur="add()"
							value='<ww:property value="teamapply.yinger"/>'
							" style="width: 350px" />如果没有.填写0</td>
					</tr>


					<tr>
						<td height="28" align="right"><span>乘机人数：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="乘机人数不能为空" name=""  id="numberpeople" disabled="disabled"
							value='<ww:property value="teamapply.numberpeople"/>'
							" style="width: 350px" /></td>
					</tr>
		<input type="hidden" require="true" dataType="Require"
							msg="乘机人数不能为空" name="numberpeople"  id="numberpeople2" style="width: 350px" />


					<tr>
						<td height="28" align="right"><span>航班号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="航班号不能为空" name="flightnumber"
							value='<ww:property value="teamapply.flightnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出发时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出发时间不能为空" name="starttime2"
							value='<ww:property value="formatTimestamp(teamapply.starttime)"/>'
							" style="width: 350px"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="status" value='<ww:property value="teamapply.status"/>'" style="width:350px" /></td>  </tr>
	 -->
					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><textarea rows="6" cols="50" name="comment"><ww:property
							value="teamapply.comment" /></textarea><!--
	 <input type="text" require="true" dataType="Require"   msg="备注不能为空" name="comment" value='<ww:property value="teamapply.comment"/>'" style="width:350px" /></td>  </tr>
	
      -->
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='teamapply.action?<ww:property value="url"/>';"
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


