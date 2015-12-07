<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body >
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">反馈信息列表</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
     <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">条件查询</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
        <form action="tousu!showfklist.action" method="post">
        <table width="96%" border="1" height="80" cellpadding="0" cellspacing="0"  bordercolor="#8ab4d2" class="font-69f yin" >
          <tr>                                                          
            <td width="20%" align="center" class="table_yin" height="20">查询范围：</td>
            <td width="80%" class="table_wu"><input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2020-10-01\'}'})" name="begintime"/> - 
            <input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2020-10-01'})" name="endtime"/></td>
          </tr>
		   <tr>                                                          
            <td height="30"  colspan="4" align="center"> <input type="submit" class="button_sea mr18" value="查询"/></td>
          </tr>
        </table>
        </form>
        <div class="h8">&nbsp;</div>
        </div>
      <div class="sea box_hui">
     
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">反馈信息列表</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
         <form action="tousu!showfklist.action" name="form1" method="post">
        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th scope="col" width="12%"><div class="thleft">意见反馈人</div></th>
            <th scope="col" width="12%"><div class="thleft">所属加盟商</div></th>
            <th scope="col" width="68%"><div class="thleft">意见反馈内容</div></th>
            <th scope="col" width="12%"><div class="thleft">意见反馈时间</div></th>
            </tbody>
          <ww:iterator value="fankuilist">
          <tr>
            <td><ww:property value="getfkname(username)"/></td>
            <td><ww:property value="getangname(dainame)"/></td>
            <td><ww:property value="time"/><a href="tousu!searchfk.action?tid=<ww:property value="id"/>"><ww:if test="comment.length()>20"><ww:property value="SubString(comment,10)"/>..........</ww:if>
            <ww:else><ww:property value="comment"/></ww:else></a></td>
            
            <td><ww:property  value="formatTimestamp(createtime)"/></td>
          </tr>
          </ww:iterator>
          <tr><td colspan="4"><ww:property value="getPagination('\"tousu!showfklist.action?pageinfo.pagenum=\"+pageno')"/> </td></tr>
          </table>
          </form>
        <div class="h8">&nbsp;</div>
        </div>
        </div>
        </div>
    
</body>
</html>