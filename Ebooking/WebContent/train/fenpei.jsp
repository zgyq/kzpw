<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>省份列表</title>
	<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
	<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="js/ext-all.js"></script>
    <link href="css/base.css" rel="stylesheet" />

</head>

<body>

<form name="form1" method="post" action="train!fenpei.action">
<input name="s_userid" value="<ww:property value="s_userid"/>" type="hidden" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;省份列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          
          
        </table></td>
      </tr>
      <tr>
        <td height="306" valign="top"><table   width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="99%"><table id="menutable" width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
               	    <!--   
                  <th>
                  	ID</th>-->
                  <th>
                  	名称</th>
                  <th>
                  	英文全拼</th>
                  <th>
                  	英文简称</th>
                  
                
        
			</tr>

		<ww:iterator value="listProvince">
	      <tr id="<ww:property value="id"/>" align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td><input type="checkbox" name="s_name" value="<ww:property value="name"/>" /></td>
		
	
		<td><ww:property value="name"/></td><td><ww:property value="enname"/></td><td><ww:property value="code"/></td>

		
	</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
          
            <td height="43" align="center"> <input type="button" onclick="sub_();" id="sub" value="提交" /> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	 function sub_(){
	    var length=document.form1.s_name.length;
		 var len=0;
		for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.s_name[i].checked ==true){
								
								len++;					         
					         }
						      
					      }
					     
					      
		if(len==0){
		alert("操作失败,你未选择任何内容!!!");
		return;
		
		}else{
		
		document.form1.submit();
		}			      
			
  	}
  
  
	


</script>





