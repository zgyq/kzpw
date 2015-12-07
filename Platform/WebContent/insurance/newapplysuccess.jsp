<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="ww" uri="webwork"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单预订成功</title>
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />

</head>
<body >
<div  id="right" >
 <div class="lit">
      <ul>
       <li class="offwu"><a href="#" target="mainFrame">订单管理</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">保单信息</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
       <table width="96%" border="1"  bordercolor="#8ab4d2" cellspacing="0" cellpadding="0" class="font-69f yin" >
          <tr>                                                          
            <td width="10%" class="table_wu" colspan="2"><h1><font class="font16-f90"><ww:if test="insuruser.policyno!=null">恭喜您！保险单创建成功！</ww:if><ww:else>对不起!保险单创建失败!</ww:else></font></h1></td>
          </tr>
          <tr>                                             
            <td class="table_wu">订单号:<ww:property value="insuruser.policyno"/></td>
			<td class="table_wu">订单状态:<ww:if test="insuruser.policyno!=null">创建成功</ww:if><ww:else>创建失败</ww:else></td>
          </tr>
          <tr>                                                          
            <td class="table_wu">单价：20元</td>
			<td class="table_wu">总金额：20元</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>

      </div>
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left"><font class="font16-f90">订单详情</font> </td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th width="45%" scope="col"><div class="thleft">服务公司</div></th>
            <th width="29%" scope="col"><div class="thleft">服务项目</div></th>
            <th width="26%" scope="col"><div class="thleft">有效时间</div></th>
            </tbody>
          <tr>
            <td>都邦保险股份有限公司</td><!-- 国华人寿保险股份有限公司 -->
            <td>短期公共交通工具意外伤害保险</td>
            <td>7天</td>
          </tr>
          </table>
        <div class="h8">&nbsp;</div>

      </div>
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou"  >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_peoplecjr.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">被保人信息</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th width="10%" scope="col"><div class="thleft">被保人姓名</div></th>
            <th width="5%" scope="col"><div class="thleft">性别</div></th>
            <th width="9%" scope="col"><div class="thleft">证件类型</div></th>
            <th width="10%" scope="col"><div class="thleft">证件号</div></th>
            <th width="9%" scope="col"><div class="thleft">手机号码</div></th>
            <th width="10%" scope="col"><div class="thleft">出生日期</div></th>
            <th width="10%" scope="col"><div class="thleft">电子邮箱</div></th>
            <th width="7%" scope="col"><div class="thleft">航班号</div></th>
            <th width="9%" scope="col"><div class="thleft">起飞时间</div></th>
            <th width="8%" scope="col"><div class="thleft">起保日期</div></th>  
            <th scope="col"><div class="thleft">保单号</div></th>                                          
          </tbody>
          <ww:iterator value="inuserlist">
          <tr>
            <td><ww:property value="name"/></td>
            <td><ww:if test="sex==1">男</ww:if><ww:else>女</ww:else></td>
            <td>
            <ww:if test="codetype==1">身份证</ww:if>
            <ww:if test="codetype==3">护照</ww:if>
            <ww:if test="codetype==8">出生证</ww:if>
            <ww:if test="codetype==99">其它</ww:if>
            </td>
            <td><ww:property value="code"/></td>
            <td><ww:property value="mobile"/></td>
            <td><ww:property value="birthday"/></td>
            <td class="line-h18"><ww:property value="email"/></td>
            <td><ww:property value="flyno"/></td>
            <td><ww:property value="begintime"/></td>
            <td><ww:property value="begintime"/></td>
            <td><ww:property value="policyno"/></td>
          </tr>
          </ww:iterator>
          </table>
        <div class="h8">&nbsp;</div>

      </div>
       <div class="h8"><input type="button" class="button_sea mr18" value="返回" onclick="javascript:history.go(-1)"/></div>
    </div>
</div>
</body>
</html>
