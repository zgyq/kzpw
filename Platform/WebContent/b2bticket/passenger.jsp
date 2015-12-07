<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>常用旅客列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
 <script>
 
 </script>
</head>
<body>
<div id="member">
<table width="78%"  border="0" cellpadding="0" cellspacing="0" align="center" >

  <tr>
    <td  valign="top">
<form name="form1" method="post" action="b2bairsearch!seachpass.action">
<input name="c_index" type="hidden" value="<ww:property value="c_index"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
            
       
           <table width="580" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="120" height="40" align="right">旅客姓名：</td>    <td><span style="HEIGHT: 71px">
                  <input id="s_name"   style="WIDTH: 120px" name="s_name" value="<ww:property value="s_name"/>" />
                </span></td>
                 <td width="120" height="40" align="right">成人类型：</td>    <td><span style="HEIGHT: 71px">
                 <select name="c_type">
                 <option value="0" <ww:if test="c_type==0">selected</ww:if>>所有</option>
                 <option value="1" <ww:if test="c_type==1">selected</ww:if>>成人</option>
                 <option value="2" <ww:if test="c_type==2">selected</ww:if>>儿童</option>
                 <option value="3" <ww:if test="c_type==3">selected</ww:if>>婴儿</option>
                 </select>
                 
                </span></td>
                <td width="10%" rowspan="3"><div align="left">
                  <input type="submit" class="button_d font-white" value="查询"/>
                </div></td>
              </tr>
              
             </table>
     



		</td>
          </tr>
          
         
        </table></td>
      </tr>
      <tr>
        <td height="290" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table id="menutable" width="99%" border="1" align="center" class="table_color">
              <tbody>
                <tr class="tbody_color">
                  
                 
                 
                  <th class="table_color">旅客姓名</th>
                  <th class="table_color">旅客类型</th>
                  <th class="table_color">证件类型</th>
                  <th class="table_color">证件号码</th>
                 
                
        
			</tr>

		<ww:iterator value="listCustPassenger">
	      <tr id="<ww:property value="id"/>" align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';" 
                      onmouseout="this.className='colortrout',this.style.fontWeight='';">
			<td  class="table_color color_b3" style="width:150px"><a href="javascript:parent.grefresh('<ww:property value="c_index"/>','<ww:property value="username"/>','<ww:property value="getnumtypebyid(id)"/>','<ww:property value="getnumbyid(id)"/>');"><ww:property value="username"/></a></td>
			<td  class="table_color color_b3" style="width:180px">
			<ww:if test="type==1">成人</ww:if><ww:if test="type==2">儿童</ww:if><ww:if test="type==3">婴儿</ww:if>
			
			</td>
			<td  class="table_color color_b3" style="width:180px">
			<ww:property value="getTypeToString(getnumtypebyid(id))"/></td>
			<td  class="table_color color_b3" style="width:180px"><ww:property value="getnumbyid(id)"/></td>
			
	</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="getPagination('\"b2bairsearch!seachpass.action?pageinfo.pagenum=\"+pageno+\"\"')"/></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</td>
   </tr>
   </table>
</div>
</body>
</html>
