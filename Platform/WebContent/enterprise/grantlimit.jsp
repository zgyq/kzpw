<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="w"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业添加</title>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
	
	<script type="text/javascript" src="js/component/dtree/dtree.js"></script>
<link href="js/component/dtree/dtree.css" rel="stylesheet" />

</head>
<body >
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">企业权限</a></li>
       <li><img src="../images/jiao.gif" width="8" height="28" /></li>
       <li style="float:right" class="mr11"><img src="../images/houtui.gif" width="59" height="23" class="mr8" /><input type=button value="" class="button_shuaxin" onclick="window.parent['mainFrame'].location.reload()"></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
   <form action='company!grant.action?id=<w:property value="company.id"/>' method="post">
      <div>
<h2>企业权限分配</h2>
<div class="biaoti">企业权限</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%"  style="margin-top:15px;">
  <tr>
    <td width="80%" align="left" style="padding-left: 100px" >
    
    <div class="dtree">
	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
	<script type="text/javascript">
		d = new dTree('d');
		d.add(1,-1,'权限范围');
		 <w:iterator value="limits" status="statu">
		 d.add(<w:property value="id"/>,<w:property value="parentid"/>,'<input id="<w:property value="id"/>" name="limit" onclick="javascript:d.checknode(<w:property value="#statu.count"/>)" value=<w:property value="id"/> type="checkbox"/><w:property value="name"/>','');
		 </w:iterator>	
		document.write(d);
		d.openAll();
		<w:iterator value="rolelimits">
		  document.getElementById(<w:property value="id"/>).checked=true;
		</w:iterator>
	</script>
 
   </div>
    </td>
  </tr>
  <tr><td height="100px">
  <input type="submit"   name="" value=" 提 交 " class="but" />
<input type="button" onclick="history.go(-1)" name="" value=" 取 消 " class="but" /></td></tr>
  
</table> 
</div>


</form>
</div>
</div>

</body>
</html>
