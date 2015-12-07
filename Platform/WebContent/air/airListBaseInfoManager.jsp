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
<title><ww:if test="teamapply.id>0">编辑</ww:if><ww:else>新增</ww:else>航班信息管理</title>

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

<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>

<script type="text/javascript">
	function toDelete(_id)
	{
		if(!confirm('确定删除?')) 
			return false;

		window.location.href="airinfomgr!toDelete.action?editId="+_id;
		return true;
	}
</script>

<body>
<table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse; text-align:center; line-height:24px;">
   <tr bgcolor="#d7e9fc">
	<td  bgcolor="#d7e9fc" style="padding: 0" width="120px"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>航班起点</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="150"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>航班终点</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="200"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>基础价格</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="200"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>折扣(%)</b> </div></td>

    <td  bgcolor="#d7e9fc" style="padding: 0" width="150"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>所属航空公司</b></div></td>
	<td  bgcolor="#d7e9fc" style="padding: 0" width="120"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>航班时间</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="100px"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>操作</b></div></td>
</tr>
<ww:iterator id="listIterator" value="listBaseInfo" status="listEntity">
<tr>
	<td><ww:property value="checkNameByCode(startport,true)"/></td>
	<td><ww:property value="checkNameByCode(arrivalport,false)"/></td>
	<td>&yen;<ww:property value="discount"/></td>
	<td><ww:property value="discount"/>%</td>
	<td><ww:property value="id"/></td>
	<td><ww:property value="formatTimestamp(starttime)"/></td>
	<td><a title="编辑相应信息" href="airinfomgr!toEdit.action?editId=<ww:property value='id'/>">编辑</a>|<a title="删除相应信息" href="#" onclick="javascript:toDelete(<ww:property value='id'/>);">删除</a></td>
</tr>
</ww:iterator>
</table>

</body>
</html>