<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
<table width="90%" class="box" style="margin: 0 auto; border:1px dashed #ff9900; background: #ffffee; margin-top: 10px; color:#006699;">
	<tr>
	<td width="7%" align="right">&nbsp;姓名：</td>
	<td width="10%">
	<ww:if test="getorderusername()!=null && !getorderusername().equals('')">
	<ww:property value="getorderusername()"/>
	</ww:if>
	<ww:else>
	无
	</ww:else>
	</td>
	<td width="7%" align="right">电话：</td>
	<td width="10%">
	<ww:if test="getorderusermobile()!=null && !getorderusermobile().equals('')">
	<ww:property value="getorderusermobile()"/>
	</ww:if>
	<ww:else>
	无
	</ww:else>
	</td>
	<td width="7%" align="right">&nbsp;单位:</td>
	<td width="20%">
	<ww:if test="getorderusercompany()!=null && !getorderusercompany().equals('')">
	<ww:property value="getorderusercompany()"/>
	</ww:if>
	<ww:else>
	无
	</ww:else>
	</td>
	<td width="5%" align="right">部门：</td>
	<td>
	<ww:if test="getorderuserdepartment()!=null && !getorderuserdepartment().equals('')">
	<ww:property value="getorderuserdepartment()"/>
	</ww:if>
	<ww:else>
	无
	</ww:else>
	</td>
	<td ></td>
	</tr>
</table>
</body>
</html>
