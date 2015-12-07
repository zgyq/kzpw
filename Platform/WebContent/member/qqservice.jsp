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
<title><ww:if test="sysconfig.id>0">编辑</ww:if><ww:else>新增</ww:else>客服QQ</title>
<script type="text/javascript">
  function checkdata()
  {
       for(var i=1;i<=12;i++)
       {
          if(document.getElementById("txtqq_"+i).value=="")
          {
              document.getElementById("txtqq_"+i).focus();
              alert("客服QQ号码必须全部填写，请重试！");
              return false;
          }
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;编辑客服QQ</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="sysconfig!editqqservice.action?id=<ww:property value="sysconfig.id"/>&<ww:property value="url"/>"
			name="form1" method="POST" onsubmit="return checkdata();">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="left">
						<table border=1 cellspacing=0 bordercolorlight=#a0cfee
							bordercolordark=white cellpadding=0 width=80% align=center>
							<tbody>
								<tr>
									<td style="height: 36px; font-weight: bold" class=maintitle02
										colspan=4 align=middle>网站在线客服QQ号码维护</td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国内机票客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_1" name="strQQ1"  maxlength=10 type=text
										value="<ww:property value="strQQ1"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国内机票客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_2" name="strQQ2" maxlength=10 type=text
										value="<ww:property value="strQQ2"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国际机票客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_3" name="strQQ3" maxlength=10 type=text
										value="<ww:property value="strQQ3"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国际机票客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_4" name="strQQ4" maxlength=10 type=text
										value="<ww:property value="strQQ4"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国内旅游客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_5" name="strQQ5" maxlength=10 type=text
										value="<ww:property value="strQQ5"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国内旅游客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_6" name="strQQ6" maxlength=10 type=text
										value="<ww:property value="strQQ6"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国际旅游客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_7" name="strQQ7" maxlength=10 type=text
										value="<ww:property value="strQQ7"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">国际旅游客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_8" name="strQQ8" maxlength=10 type=text
										value="<ww:property value="strQQ8"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">车队业务客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_9" name="strQQ9" maxlength=10 type=text
										value="<ww:property value="strQQ9"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">车队业务客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_10" name="strQQ10" maxlength=10 type=text
										value="<ww:property value="strQQ10"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">投诉建议客服1：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_11" name="strQQ11" maxlength=10 type=text
										value="<ww:property value="strQQ11"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
									<td style="background-color: #d7e9fc; width: 20%; height: 38px"
										align="right" class=" tbody_color">投诉建议客服2：</td>
									<td style="text-align: left; width: 30%">&nbsp;&nbsp;<input
										id="txtqq_12" name="strQQ12" maxlength=10 type=text
										value="<ww:property value="strQQ12"/>" name="txtpnrcode">
									<span style="display: none;" id=requiredfieldvalidator1></span></td>
								</tr>
								<tr><td colspan="4" height="10px"></td></tr>
								<tr>
									<td colspan="4" align="center"><input type="submit"
										class="button_d font-bai" value="提交" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										 <input type="button"
										class="button_d font-bai"
										onclick="window.location.href='sysconfig.action?<ww:property value="url"/>';"
										name="Submit2" value=" 返回 " /></td>
								</tr>

							</tbody>
						</table>
						</td>

					</tr>


					<tr class="font-blue-xi">
						<td width="100">&nbsp;</td>
						<td height="46" scrolling="no"></td>
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


