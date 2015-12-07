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
<title>升舱补差价</title>

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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;升舱补差价</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="scang!addprice.action?id=<ww:property value="scang.id"/>" name="form1" method="POST">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>






					<tr>
						<td height="28" align="right"><span>乘客姓名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="关联乘机人表ID不能为空" name="passengerid" 
							value="<ww:property value="getchengjiren(scang.passengerid)"/>"
							style="width: 350px" /></td>
					</tr>




					<tr>
						<td height="28" align="right"><span>升舱前舱位码：</span></td>
						<td><input type="text" require="true" dataType="Require" 
							msg="升舱前舱位码不能为空" name="startcode"
							value='<ww:property value="scang.startcode"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>申请升舱到舱位码：</span></td>
						<td><input type="text" require="true" dataType="Require" 
							msg="申请升舱到舱位码不能为空" name="endcode"
							value='<ww:property value="scang.endcode"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>订单号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="订单号不能为空" name="ordercode"
							value='<ww:property value="orderinfo.ordernumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<!--<tr>
						<td height="28" align="right"><span>订单ID：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="订单ID不能为空" name="orderid"
							value='<ww:property value="scang.orderid"/>'
							" style="width: 350px" /></td>
					</tr>



					-->
					<tr>
						<td height="28" align="right"><span>航班号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="航班号不能为空" name="flight"
							value='<ww:property value="scang.flight"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>升舱编码/PNR：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱编码/PNR不能为空" name="pnr"
							value='<ww:property value="scang.pnr"/>' " style="width: 350px" /></td>
					</tr>
					<!--



					<tr>
						<td height="28" align="right"><span>办理时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="办理时间不能为空" name="transacttime"
							value='<ww:property value="scang.transacttime"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>升舱效率：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱效率不能为空" name="xiaolv"
							value='<ww:property value="scang.xiaolv"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>升舱状态：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱状态不能为空" name="states"
							value='<ww:property value="scang.states"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>状态：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="状态不能为空" name="status"
							value='<ww:property value="scang.status"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>申请人：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="申请人不能为空" name="applyid"
							value='<ww:property value="scang.applyid"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>处理人：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="处理人不能为空" name="updateid"
							value='<ww:property value="scang.updateid"/>'
							" style="width: 350px" /></td>
					</tr>



					-->
					<tr>
						<td height="28" align="right"><span>升舱前价：</span></td>
						<td><input type="text" require="true" dataType="Require" disabled="disabled"
							msg="备注不能为空" name=""
							value='<ww:property value="getprice(scang.passengerid)"/>' " style="width: 350px" /></td>
					</tr>
					
				
				
					<tr class="font-blue-xi">
						<td height="54"></td>
						<td height="46" scrolling="no">
						
			<input type="radio" onclick="sheng(1)" name="Submit2" checked="checked"/>升舱
			<input type="radio" onclick="sheng(2)" name="Submit2" value="" <ww:if test="scang.status==7">checked</ww:if> />换开
			</td>
					</tr>
				
					
					<tr id="s1" style="display: block;;">
						<td height="28" align="right"><span>差价：</span></td>
						<td><input type="text" require="true" dataType="Require" id="price"
							msg="备注不能为空" name="price"
							value='<ww:property value="scang.price"/>' " style="width: 350px" /></td>
					</tr>
					<tr id="s2" style="display: none;">
						<td height="28" align="right"><span>新PNR：</span></td>
						<td><input type="text" require="true" dataType="Require" id="pnr"
							msg="备注不能为空" name="newpnr"
							value='<ww:property value="scang.newpnr"/>'
							" style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="备注不能为空" name="comment"
							value='<ww:property value="scang.comment"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='scang.action?<ww:property value="url"/>';"
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
<script language="JavaScript">
var st = <ww:property value="scang.status"/>;

if(st==7){
document.getElementById("s1").style.display="none";
	document.getElementById("s2").style.display="block";
}else{
	document.getElementById("s1").style.display="block";
	document.getElementById("s2").style.display="none";
}

	function sheng(type){
	if(type==1){
	document.getElementById("s1").style.display="block";
	document.getElementById("s2").style.display="none";
	document.getElementById("pnr").value="";
	}else{
	document.getElementById("s1").style.display="none";
	document.getElementById("s2").style.display="block";
	document.getElementById("price").value="";
	document.form1.action="scang!huankai.action?id=<ww:property value="scang.id"/>";
	}
		
	}
	
</script>
