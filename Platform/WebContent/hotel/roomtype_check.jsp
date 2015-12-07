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
<title>酒店房型列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="hotelroomtype" method="post" action="roomtype.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店房型列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	          <td>&nbsp;</td>
	           <!--  <td><ww:property value="hotel.name"/></td> -->
	          </tr>
	        </table>
        </td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="99%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                
				 <th>
                  	房型名称</th>
                 <th>
                  	楼层</th>
                  <th>
                  	面积</th>
                  <th>
                  	描述</th>
                  <th>
                  	床型</th>
                  <th>
                  	早餐</th>
                  <th>
                  	宽带</th>
                  <th>
                  	房间设施</th>
                  <th>
                  	房型状态</th>              
       
        
			</tr>

		<ww:iterator value="listRoomtype">
	      <tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

		   <td style="width: 8%"><ww:property value="name"/></td>
		   <td style="width: 8%"><ww:property value="layer"/></td>
		   <td style="width: 8%"><ww:property value="areadesc"/></td>
		   <td style="width: 22%"><ww:property value="roomdesc"/></td>
		   <td style="width: 5%">		  
		   <ww:if test="bed==1">单人床</ww:if>
		   <ww:if test="bed==2">大床</ww:if>
		   <ww:if test="bed==3">双床</ww:if>
		   <ww:if test="bed==4">大或双</ww:if>
		   <ww:if test="bed==5">其他</ww:if>
		  </td>
		  <td style="width: 5%">		  
		   <ww:if test="breakfast==1">无早</ww:if>
		   <ww:if test="breakfast==2">单早</ww:if>
		   <ww:if test="breakfast==3">双早</ww:if>
		  </td>
		  <td style="width: 5%">		  
		   <ww:if test="breakfast==0">无</ww:if>
		   <ww:if test="breakfast==1">免费</ww:if>
		   <ww:if test="breakfast==2">收费</ww:if>
		  </td>			   
		   <td style="width: 22%"><ww:property value="roomset"/></td>	
		   <td style="width: 5%"><ww:if test="state==0">禁用</ww:if>
		  	<ww:else>正常</ww:else></td>
		</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="pagination" /> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>




