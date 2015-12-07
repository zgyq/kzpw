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
<title>K位特价申请详细信息</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
.hh{}
.hh td{padding-left: 4px;}
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;K位特价申请详细信息</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="kweisq!<ww:if test="kweisq.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" class="hh" cellpadding="0" cellspacing="0" border="1" bordercolor="#a0cfee" style="border-collapse: collapse; width:98%; margin: 0 auto; margin-top: 20px;">

					<tr>
						<td height="28" align="right" class="tbody_color"><span>航班类型：</span></td>
						<td width="30%"><!--
	 <input type="text" require="true" dataType="Require"   msg="航班类型不能为空" name="flighttype" value='<ww:property value="teamapply.flighttype"/>'" style="width:350px" />
	 --> <input type="radio" name="flighttype" value="1"
							<ww:if test="kweifabu.flighttype==1">checked</ww:if> />&nbsp;&nbsp;单程&nbsp;&nbsp;<input
							type="radio" name="flighttype" value="2"
							<ww:if test="kweifabu.flighttype==2">checked</ww:if> />&nbsp;&nbsp;往返&nbsp;&nbsp;</td>
					
						<td height="28" align="right" class="tbody_color"><span>乘客类型：</span></td>
						<td><!--
	 <input type="text" require="true" dataType="Require"   msg="乘客类型不能为空" name="usertype" value='<ww:property value="teamapply.usertype"/>'" style="width:350px" />
	 --> <input type="radio" name="usertype" value="1"
							<ww:if test="kweifabu.usertype==1">checked</ww:if> />&nbsp;&nbsp;内宾&nbsp;&nbsp;<input
							type="radio" name="usertype" value="2"
							<ww:if test="kweifabu.usertype==2">checked</ww:if> />&nbsp;&nbsp;外宾&nbsp;&nbsp;</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>航空公司：</span></td>
						<td><select name="ca" disabled="disabled">
							<ww:iterator value="listAircompany">
								<option value="<ww:property value="aircomcode"/>"
									<ww:if test="kweifabu.ca==aircomcode">selected</ww:if>><ww:property
									value="aircomcnname" /></option>
							</ww:iterator>
						</select></td>
					
						<td height="28" align="right" class="tbody_color"><span>出发时间：</span></td>
						<td><ww:property value="formatTimestamp(kweifabu.starttime)"/>
							</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>出发城市：</span></td>
						<td><ww:property value="getAirnamebySZM(kweifabu.startcity)"/>
							</td>
					
						<td height="28" align="right" class="tbody_color"><span>到达城市：</span></td>
						<td><ww:property value="getAirnamebySZM(kweifabu.endcity)"/>
							
					</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>航班号：</span></td>
						<td><ww:property value="kweifabu.flightnumber"/>
							</td>
					
						<td height="28" align="right" class="tbody_color"><span>舱位码：</span></td>
						<td><ww:property value="kweifabu.cabincode"/>
							</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>票面价：</span></td>
						<td><ww:property value="kweifabu.nominalprice"/>
							</td>
					
						<td height="28" align="right" class="tbody_color"><span>折扣：</span></td>
						<td><ww:property value="kweifabu.discount"/>
							</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>税率：</span></td>
						<td><ww:property value="kweifabu.taxrate"/>
					</td>
					
						<td height="28" align="right" class="tbody_color"><span>备注：</span></td>
						<td><ww:property value="kweifabu.comment"/>
						</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>结算价：</span></td>
						<td><ww:property value="kweifabu.settlementprice"/>
							</td>
					
						<td height="28" align="right" class="tbody_color"><span>政策：</span></td>
						<td><ww:property value="kweifabu.policy"/>
							</td>
					</tr>







					<tr>
						<td height="28" align="right" class="tbody_color"><span>状态：</span></td>
						<td>
						
											<ww:if test="kweifabu.status==1">待审核</ww:if>
												<ww:if test="kweifabu.status==2">审核通过</ww:if>
												<ww:if test="kweifabu.status==3">审核不通过</ww:if>
							</td>
					

					<!--
	 <tr><td height="28" align="right"><span>供应商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="供应商ID不能为空" name="angenid" value='<ww:property value="kweisq.angenid"/>'" style="width:350px" /></td>  </tr>
	 <tr><td height="28" align="right"><span>分销商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="分销商ID不能为空" name="distributorid" value='<ww:property value="kweisq.distributorid"/>'" style="width:350px" /></td>  </tr>
	 -->
					
						<td height="28" align="right" class="tbody_color"><span>乘机人数：</span></td>
						<td><ww:property value="kweisq.peoplenumber"/>
						</td>
					</tr>

					<tr>
						<td height="28" align="right" class="tbody_color"><span>成人人数：</span></td>
						<td><ww:property value="kweisq.chengren"/>
						</td>
					
						<td height="28" align="right" class="tbody_color"><span>儿童人数：</span></td>
						<td><ww:property value="kweisq.ertong"/>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" class="tbody_color"><span>婴儿人数：</span></td>
						<td><ww:property value="kweisq.yinger"/>
						</td>
					
						<td height="28" align="right" class="tbody_color"><span>联系人姓名：</span></td>
						<td><ww:property value="kweisq.username"/>
							</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>联系人手机：</span></td>
						<td><ww:property value="kweisq.mobile"/>
							</td>
					
						<td height="28" align="right" class="tbody_color"><span>联系人邮箱：</span></td>
						<td><ww:property value="kweisq.postbox"/>
						</td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>备注：</span></td>
						<td><ww:property value="kweisq.comment"/>
							</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="status" value='<ww:property value="kweisq.status"/>'" style="width:350px" /></td>  </tr>
	 -->

					<input type="hidden" require="true" dataType="Require"
						msg="K位信息ID不能为空" name="kid" value='<ww:property value="kid"/>'
						" style="width: 350px" />


					<!--<tr><td height="28" align="right"><span>修改时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="修改时间不能为空" name="updatetime" value='<ww:property value="kweisq.updatetime"/>'" style="width:350px" /></td>  </tr>
	 <tr><td height="28" align="right"><span>修改者：</span></td><td><input type="text" require="true" dataType="Require"   msg="修改者不能为空" name="updateuser" value='<ww:property value="kweisq.updateuser"/>'" style="width:350px" /></td>  </tr>
      -->
					<tr class="font-blue-xi">
						
						<td height="46" scrolling="no" colspan="4" align="center">
						
						 <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='kweisq!togoumai.action?kid=<ww:property value="kweifabu.id" />&ksid=<ww:property value="kweisq.id" />';"
							name="Submit3" value=" 购买 " />
						 
						 
						
						<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='javascript:history.back(-1)';"
							name="Submit2" value=" 返回 " /></td>
							
					</tr>
				
				</table>
				<div style="height:20px;">&nbsp;</div>
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


