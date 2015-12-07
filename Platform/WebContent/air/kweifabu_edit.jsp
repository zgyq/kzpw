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
<title><ww:if test="kweifabu.id>0">编辑</ww:if><ww:else>新增</ww:else>K位特价发布表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<link href="style/autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="js/flightcity.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/j.dimensions.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" language="javascript">
		 $(function(){
			$("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',attachObject:"#suggest2"});
		});
</script>	
<body onload="LoadCityData();">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="kweifabu.id>0">编辑</ww:if><ww:else>新增</ww:else>K位特价发布表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="kweifabu!<ww:if test="kweifabu.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>供应商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="供应商ID不能为空" name="angenid" value='<ww:property value="kweifabu.angenid"/>'" style="width:350px" /></td>  </tr>
	 -->
					<tr>
						<td height="28" align="right"><span>航班类型：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="航班类型不能为空" name="flighttype" value='<ww:property value="teamapply.flighttype"/>'" style="width:350px" />
	 --> <ww:if test="kweifabu.id>0">
							<input type="radio" name="flighttype" value="1"
								<ww:if test="kweifabu.flighttype==1">checked</ww:if> />单程<input
								type="radio" name="flighttype" value="2"
								<ww:if test="kweifabu.flighttype==2">checked</ww:if> />往返
	
	 </ww:if><ww:else>
							<input type="radio" name="flighttype" value="1" checked="checked" />单程<input
								type="radio" name="flighttype" value="2" />往返
	
	 </ww:else></td>
					</tr>




					<tr>
						<td height="28" align="right"><span>航空公司：</span></td>
						<td><select name="ca">
							<ww:iterator value="listAircompany">
								<option value="<ww:property value="aircomcode"/>"
									<ww:if test="kweifabu.ca==aircomcode">selected</ww:if>><ww:property
									value="aircomcnname" /></option>
							</ww:iterator>
						</select></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出发时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出发时间不能为空" name="starttime2"
							value='<ww:property value="formatTimestamp(kweifabu.starttime)"/>'
							" style="width: 350px" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出发城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="出发城市不能为空" name="" id="arrcity"
							value='<ww:property value="getAirnamebySZM(kweifabu.startcity)"/>'
							" style="width: 350px" />
						<div id='suggest' class="ac_results"></div>
								<input type="hidden" id="city_from_hide" name="startcity" value="kweifabu.startcity"/>	
							
							</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>到达城市：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="到达城市不能为空" name=""  id="tocity"
							value='<ww:property value="getAirnamebySZM(kweifabu.endcity)"/>'
							" style="width: 350px" />
							<div id='suggest2' class="ac_results"></div>
								<input type="hidden" id="city_to_hide" name="endcity" value="teamapply.endcity"/>
							</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>航班号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="航班号不能为空" name="flightnumber"
							value='<ww:property value="kweifabu.flightnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>舱位码：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="舱位码不能为空" name="cabincode"
							value='<ww:property value="kweifabu.cabincode"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>票面价：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="票面价不能为空" name="nominalprice"
							value='<ww:property value="kweifabu.nominalprice"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>折扣：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="折扣不能为空" name="discount"
							value='<ww:property value="kweifabu.discount"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>税率：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="税率不能为空" name="taxrate"
							value='<ww:property value="kweifabu.taxrate"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="备注不能为空" name="comment"
							value='<ww:property value="kweifabu.comment"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>结算价：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="结算价不能为空" name="settlementprice"
							value='<ww:property value="kweifabu.settlementprice"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>政策：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="政策不能为空" name="policy"
							value='<ww:property value="kweifabu.policy"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>乘客类型：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="乘客类型不能为空" name="usertype" value='<ww:property value="teamapply.usertype"/>'" style="width:350px" />
	 --> <ww:if test="kweifabu.id>0">
							<input type="radio" name="usertype" value="1"
								<ww:if test="kweifabu.usertype==1">checked</ww:if> />内宾<input
								type="radio" name="usertype" value="2"
								<ww:if test="kweifabu.usertype==2">checked</ww:if> />外宾
	
	 </ww:if><ww:else>
							<input type="radio" name="usertype" value="1" checked="checked" />内宾<input
								type="radio" name="usertype" value="2" />外宾
	
	 </ww:else></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>状态：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="状态不能为空" name="status"
							value='<ww:property value="kweifabu.status"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="javascript:history.go(-1);"
							name="Submit2" value=" 返 回 " /></td>
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


