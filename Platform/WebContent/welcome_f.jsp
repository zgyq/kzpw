<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<style type="text/css">
<!--
.STYLE1 {
	font-weight: bold
}

-->
.bor {
	background: #FFE;
	border: #F90 1px dotted;
	margin: 5px;
	padding: 5px;
	overflow: hidden;
}
</style>
<link href="<%=request.getContextPath() %>/style/Layout.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/base.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" media="all"
	href="css/globalframe.css">
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div  id="right" style=" height: 99.7%; " >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="right.jsp" >欢迎到来</a></li>
       <li class="offd"><a href="<%=request.getContextPath()%>/<ww:if test='#session.ListAgid!=10033 && #session.ListAgid!=10032'>login!towelcome.action</ww:if><ww:else>attendrecord.action</ww:else>" >快速导航</a></li>
       <li class="on"><a href="#">查看返利</a></li>
       <li><img src="imagess/jiao_f.gif" width="8" height="28" /></li>
       <li style="float:right" class="mr11"><img src="imagess/houtui.gif" width="59" height="23" class="mr8" /><input type=button value="" class="button_shuaxin" onclick="window.parent['mainFrame'].location.reload()"></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box" style="margin-right:7px;"> 
      <div class="sea box_hui" >
<div id="member">
<table width="99%" border="0" cellpadding="0" cellspacing="0"
	align="center"  height="100%">

	<tr>

		<td width="100%" height="10" ></td>
	</tr>
	<tr>
		<td valign="top">
		<table border="0">
			<tbody>
			
            <tr><td colspan="3" height="10px">
            </td>
            </tr>
				<tr>
					<td align="left" valign="top">
					<div>
					<div id="div_4dae41bccd34d">
					<table width="430" class="listing" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td class="tableheader" colspan="8">统计概览</td>
							</tr>
							<tr>
							  <td class="theader" align="right">&nbsp;</td>
							  <td></td>
							  <td align="left">&nbsp;</td>
							  <td></td>
							  <td class="theader" align="right">&nbsp;</td>
							  <td></td>
							  <td align="left">&nbsp;</td>
							  <td>&nbsp;</td>
						  </tr>
							<tr>
								<td class="theader" align="right">省代理：</td>
								<td width="2"></td>
								<td align="left">100000</td>
								<td width="30"></td>
								<td class="theader" align="right">&nbsp;市代理：</td>
								<td width="2"></td>
								<td align="left">3000</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="7"></td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;区域代理：</td>
								<td width="2"></td>
								<td align="left">7000</td>
								<td width="30"></td>
								<td class="theader" align="right">经纪人：</td>
								<td width="2"></td>
								<td align="left">8000</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
							  <td class="theader" align="right">&nbsp;</td>
							  <td></td>
							  <td align="left">&nbsp;</td>
							  <td></td>
							  <td class="theader" align="right">&nbsp;</td>
							  <td></td>
							  <td align="left">&nbsp;</td>
							  <td>&nbsp;</td>
						  </tr>
						</tbody>
					</table>
					</div>
					</div>

					<div>
					<div id="div_4dae41bccd35d">

					<table class="listing mt10" width="430" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td class="tableheader" >佣金统计</td>
							</tr>
							
							<tr>
								<td align="center">
						<table width="99%" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							
							<tr>
							  <td align="right" class="theader">&nbsp;</td>
							  <td align="left">&nbsp;</td>
							  <td></td>
							  <td align="right" class="theader">&nbsp;</td>
							  <td align="left">&nbsp;</td>
						    </tr>
							<tr>
								<td width="127" align="right" class="theader">机票订单：</td>
							  <td width="73" align="left">234个</td>
							  <td width="5"></td>
								<td width="112" align="right" class="theader">&nbsp;机票返佣：</td>
								<td width="68" align="left">500元</td>
							</tr>
							<tr align="right">
								<td colspan="5"></td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;酒店订单：</td>
							  <td align="left">25个</td>
								<td width="5"></td>
							  <td class="theader" align="right">酒店返佣：</td>
							  <td align="left">250元</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;旅游订单：</td>
							  <td align="left">105个</td>
								<td width="5"></td>
							  <td class="theader" align="right">旅游返佣：</td>
							  <td align="left">2050元</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;租车订单：</td>
							  <td align="left">1个</td>
								<td width="5"></td>
							  <td class="theader" align="right">租车返佣：</td>
							  <td align="left">20元</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;手机充值：</td>
							  <td align="left">360个</td>
								<td width="5"></td>
							  <td class="theader" align="right">手机充值：</td>
							  <td align="left">1800元</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td class="theader" align="right">&nbsp;QQ充值：</td>
							  <td align="left">4个</td>
								<td width="5"></td>
							  <td class="theader" align="right">QQ充值：</td>
							  <td align="left">4元</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
							  <td colspan="6" align="center" class="theader"><b>总计返佣金额：3500元</b></td>
						    </tr>
						</tbody>
					</table>
								<div class="mt10"></div>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- Affiliate Statistics End --> <!-- pzone article -->
					<table class="tblist mt10" width="100%" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td  colspan="2"><b>业务客服</b></td>
							</tr>
							<ww:property value="s_qqlistinfo" />

						</tbody>
					</table>
					</div>
					</div>
					</td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td align="left" valign="top">

					<table class="tblist" width="240" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td class="tableheader2" colspan="3"><b>返佣规则</b></td>
							</tr>
							<tr onmouseout="this.className=&#39;listresult&#39;;"
								onmouseover="this.className=&#39;listresultMouseOver&#39;"
								class="listresult">
								<td width="40%">代理商类型</td>
								<td width="35%">业务类型</td>
								<td width="25%">返佣比例</td>
							</tr>
							<ww:property value="strrebatehtml" />
							
						</tbody>
					</table>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="height:15px; line-height:15px;"></div>
		</div>
		</form>
		<div style="height:10px; line-height:10px;"></div>
</div>

</div>
</body>
</html>
