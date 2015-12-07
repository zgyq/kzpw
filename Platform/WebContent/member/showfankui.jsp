<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>反馈信息列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;反馈信息列表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
<tr></tr>
<tr></tr>
  <tr>
    <td valign="top">
    <form action="tousu!showfklist.action" method="post">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

    
      <tr>
           <td width="30%" align="right">具体时间范围查询：</td><td width="50%"><center>
            <input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})" name="begintime"/> - 
            <input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})" name="endtime"/>
           </center></td><td width="20%"> <input type="submit"  class="button_d font-white" value="查询"/></td>
          <tr>
          <tr></tr>
          <tr></tr>
        </table>
 </form>       
        </td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table id="menutable" width="99%" border="1" align="center" class="table_color">
              <tbody>
                <tr class="tbody_color">
				<th class="table_color" width="10%">意见反馈人</th>
                  <th class="table_color" width="80%">意见反馈内容</th>
                  <th class="table_color" width="10%">意见反馈时间</th>
                 </tr>
		<ww:iterator value="fankuilist">
	      <tr id="<ww:property value="id"/>" align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';" 
                      onmouseout="this.className='colortrout',this.style.fontWeight='';">
		
<td  class="table_color">
<ww:property value="getfkname(username)"/>
</td>
<td  class="table_color">
<a href="tousu!searchfk.action?tid=<ww:property value="id"/>">
<ww:if test="comment.length()>20"><ww:property value="SubString(comment,10)"/>..........</ww:if>
     <ww:else><ww:property value="comment"/></ww:else>
</a>
</td>
<td><ww:property value="createtime"/></td>
</tr>
	</ww:iterator>
           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="getPagination('\"infocontent!helplist.action?pageinfo.pagenum=\"+pageno')"/> </td>
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