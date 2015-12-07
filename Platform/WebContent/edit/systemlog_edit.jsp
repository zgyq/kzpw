<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ww" uri="/struts-tags" %>
<%
/**
 * 版权所有，thunder
 * Author: thunder
 * copyright: 2011
 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><ww:if test="systemlog.id>0">编辑</ww:if><ww:else>新增</ww:else>操作日志</title>
		<link href="../css/default.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="../css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
		<script src="../js/validate/jquery-1.4.min.js" type="text/javascript"></script>
		<script src="../js/validate/jquery.validationEngine-cn.js" type="text/javascript"></script>
		<script src="../js/validate/jquery.validationEngine.js" type="text/javascript"></script>
	
		
		<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine()
		
		});
	</script>	



</head>


<body>

<form action="systemlog!<ww:if test="systemlog.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" id="form1" method="POST" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top" background="../images/titleL3_bg.gif"> <table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="../images/titleL3_point.gif" width="33" height="19"><span class="txt_title3">
        
       <ww:if test="systemlog.id>0">编辑</ww:if><ww:else>新增</ww:else>操作日志</span>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="bottom">
					<table border="0" cellpadding="0" cellspacing="0">
                    	<tr>    <td width=42 nowrap>&nbsp;</td>
							<td  nowrap>
                               &nbsp;
							</td>
                      </tr>
                  </table>
                
				</td>
              </tr>
          </table></td></tr>
    </table></td>
  </tr>
</table>

<table border="0" width="100%"  align="center">


 
	

 
	<tr class="tr2"><td align="right">操作代码：</td><td><input type="text"    id="code" class="validate[required]" name="code" value='<ww:property value="systemlog.code"/>' /> </td></tr>
	
				 
 
	<tr class="tr1"><td align="right">操作ip：</td><td><input type="text"    id="address" class="validate[required]" name="address" value='<ww:property value="systemlog.address"/>' /> </td></tr>
	
				 
 
	<tr class="tr2"><td align="right">操作名称：</td><td><input type="text"    id="name" class="validate[required]" name="name" value='<ww:property value="systemlog.name"/>' /> </td></tr>
	
				 
 
	<tr class="tr1"><td align="right">操作用户：</td><td><input type="text"    id="systemuser" class="validate[required]" name="systemuser" value='<ww:property value="systemlog.systemuser"/>' /> </td></tr>
	
				 
 
	<tr class="tr1"><td align="right">用户id：</td><td><input type="text"    id="userid" class="validate[required]" name="userid" value='<ww:property value="systemlog.userid"/>' /> </td></tr>
	
				 
      
   	    
      



<tr class="tr0" ><td height="30" colspan="2" align="center"><input class="a" type="submit" value=" 提 交 "/> <input type="button" onclick="reset();"  name="Submit2" value=" 重 置 " /> </td></tr> 

</table> 



</form>
</body>
</html>



