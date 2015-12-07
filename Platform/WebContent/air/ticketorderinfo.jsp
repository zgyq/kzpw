<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预订成功</title>
<script type="text/javascript">
  function goBook()
  {
     window.location.href="airsearch.action";
  }
  function goView()
  {
     window.location.href="orderinfo.action";
  }
</script>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;预订成功</b></td>
	</tr>
	<tr>
		<td valign="top">

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="25" colspan="2" class="Notice">
				<div align="center"><strong> <span><img src="images/ordersuc.gif" border="0">订单生成成功</span></strong>&nbsp;</div>
				</td>
			</tr>
			<tr>
				<td height="30" colspan="2">
				<div align="center" id="lblinfo"><b>订单号：<ww:property value="orderinfo.ordernumber" /></b></div>
				</td>
			</tr>
			<tr>
				<td height="30" colspan="2">
				<div align="center"><b>PNR编码：<ww:property value="orderinfo.pnr" /></b></div>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="20"></td>
			</tr>
			<tr>
				<td colspan="2" height="30">
				<table border="0" cellpadding="0" cellspacing="0"
					style="width: 100%">
					<tr>
						<td style="width: 38%"></td>
						<td style="width: 30%">
						<input type="button" style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;" id="btnGoBook" onclick="goBook();" value="继续预订" />
						<input type="button" style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;" id="btnGoView" onclick="goView();" value="订单列表" />
						</td>
						<td style="width: 40%"></td>
					</tr>
					<tr>
				<td colspan="2" height="20"></td>
			</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>
