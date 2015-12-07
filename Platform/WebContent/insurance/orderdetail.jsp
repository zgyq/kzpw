<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="ww" uri="webwork" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
</head>

<body >
<div  id="right" >
   <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">订单详细</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left"><font class="font16-f90">服务信息</font> </td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tr>
            <td width="18%">服务公司：</td>
            <td width="82%"><span id="lblCompanyName">中美联泰大都会人寿保险有限公司</td>
          </tr>
		  <tr>
		    <td>服务项目：</td>
			<td><span id="lblInsureName">慧择宝短期公共交通工具意外伤害保险</span></td>
		  </tr>
		    <tr>
		    <td>有效期：</td>
			<td><span id="lblExpirereMark">10天</span></td>
		  </tr>
		    <tr>
		    <td>注意事项：</td>
			<td><span id="lblServiceContent">1.被保人应为身体健康、能正常工作或正常生活的自然人，投保年龄限制出生18天-70周岁；   2.统一保险责任期间每人限投保5份； 3.本保险生效后，不办理撤保、退保、加保及被保险人更换。</span> </td>
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
<form action="" name="myform" method="post">
        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th  scope="col"><div class="thleft">姓名</div></th>
            <th  scope="col"><div class="thleft">性别</div></th>
            <th scope="col"><div class="thleft">证件类型 </div></th>
            <th  scope="col"><div class="thleft">证件号</div></th>
            <th  scope="col"><div class="thleft">手机号码 </div></th>
            <th  scope="col"><div class="thleft">出生日期 </div></th>
            <th  scope="col"><div class="thleft">电子邮箱 </div></th>
            <th  scope="col"><div class="thleft">航班号 </div></th>
            <th  scope="col"><div class="thleft">起飞时间</div></th>
            <th  scope="col"><div class="thleft">起保日期</div></th> 
			<th scope="col"><div class="thleft">保单号</div></th>
			</tbody>
		 <ww:iterator value="inuserlist">
           <tr>
            <td height="30"><ww:property value="name"/></td>
            <td>
             <ww:if test="sex==0">男</ww:if> 
             <ww:if test="sex==1">女</ww:if>         
           </td>
            <td>
             <ww:if test="codetype==1">身份证</ww:if>
             <ww:if test="codetype==3">护照</ww:if>
             <ww:if test="codetype==8">出生证</ww:if>
             <ww:if test="codetype==99">其它</ww:if>
            </td>
            <td><ww:property value="code"/></td>
            <td><ww:property value="mobile"/> </td>
            <td><ww:property value="birthday"/></td>
            <td ><ww:property value="email"/></td>
            <td><ww:property value="flyno"/></td>
            <td><ww:property value="begintime"/></td>
            <td> <ww:property value="begintime"/></td>
			<td><ww:property value="policyno"/></td>
          </tr>
          </ww:iterator>
          </table>
		 </form>
        <div class="h8">&nbsp;</div>
      </div>
	  <div class="h8"><center><input type="button" class="button_sea mr18" value="返回" onclick="javascript:history.go(-1)"/></center></div>
	  <div class="h8">&nbsp;</div>
	  <div class="h8">&nbsp;</div>
      
       
	
</div>
</div>
</body>
</html>
