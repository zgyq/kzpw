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
<title>查看团队申请单</title>

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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;查看团队申请单</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="supteam!addsup.action"
			name="form1" method="POST"
			>



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>

					<tr><td height="28" align="right"><span>所属加盟商ID：</span></td><td><ww:property value="getAgentname22(teamapply.typeid)"/></td>  </tr>
 
	
					<tr>
						<td height="28" align="right"><span>航班类型：</span></td>
						<td> 
							
								<ww:if test="teamapply.flighttype==1">单程</ww:if> 
								
								<ww:if test="teamapply.flighttype==2">往返</ww:if> 
	
	 </td>
					</tr>



					<tr>
						<td height="28" align="right"><span>乘客类型：</span></td>
						<td>
						
								<ww:if test="teamapply.usertype==1">内宾</ww:if> 
							
								<ww:if test="teamapply.usertype==2">外宾</ww:if> 
	
						</td>
					</tr>

					<tr>
						<td height="28" align="right"><span>航空公司：</span></td>
						<td>
		<ww:property value="getAircomapnycodeByEZM(teamapply.ca)"/>
	</td>
					</tr>


					<tr>
						<td height="28" align="right"><span>出发城市：</span></td>
						<td><ww:property value="getAirnamebySZM(teamapply.startcity)"/>
						
						
							</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>到达城市：</span></td>
						<td><ww:property value="getAirnamebySZM(teamapply.endcity)"/>
						
						
								
							</td>
					</tr>

	
					<tr>
						<td height="28" align="right"><span>成人人数：</span></td>
						<td><ww:property value="teamapply.chengren"/>
						</td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>儿童人数：</span></td>
						<td><ww:property value="teamapply.ertong"/>
						</td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>婴儿人数：</span></td>
						<td><ww:property value="teamapply.yinger"/>
						</td>
					</tr>

					<tr>
						<td height="28" align="right"><span>乘机人数：</span></td>
						<td><ww:property value="teamapply.numberpeople"/>
						</td>
					</tr>







					<tr>
						<td height="28" align="right"><span>航班号：</span></td>
						<td><ww:property value="teamapply.flightnumber"/>
						</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>出发时间：</span></td>
						<td><ww:property value="formatTimestamp(teamapply.starttime)"/>
							
							</td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="status" value='<ww:property value="teamapply.status"/>'" style="width:350px" /></td>  </tr>
	 -->
					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><ww:property
							value="teamapply.comment" />
							
						</td></tr>
						
				<tr>
				<td height="28" align="right"><span>报价：</span></td>
				<td>
						<input type="text" name="offer" id="offer" value="<ww:property value="getbaojia(teamapply.id)" />" />
						<input type="hidden" name="teamid" id="teamid" value="<ww:property value="teamapply.id" />" />
						<input type="hidden" name="distributorid" id="distributorid" value="<ww:property value="teamapply.typeid" />" />
						
							</td>
				</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="history.back()"
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


