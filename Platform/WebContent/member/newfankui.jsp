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
       <li class="offwu"><a href="ddlist.html" target="mainFrame">反馈意见查看</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">反馈意见查看</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
      <table width="96%" height="126" border="1" cellpadding="0" cellspacing="0"  bordercolor="#8ab4d2" class="font-69f yin" >
          <tr>                                                          
            <td width="20%" align="center" class="table_yin" >反馈人：</td>
            <td width="70%" class="table_wu"><ww:property value="getfkname(tousu.username)"/></td>
          </tr>
           <tr>                                                          
            <td width="20%" align="center" class="table_yin" >所属加盟商：</td>
            <td width="70%" class="table_wu"><ww:property value="getangname(tousu.dainame)"/></td>
          </tr>
          <tr>                                                          
            <td  align="center" class="table_yin">反馈内容：</td>
            <td  class="table_wu"><ww:property value="tousu.comment" /></td>
          </tr>
          <tr>                                                          
            <td  align="center" class="table_yin">反馈时间</td>
            <td  class="table_wu" ><ww:property value="formatTimestamp(tousu.createtime)" /></td>
          </tr>
		   <tr>                                                          
            <td  height="40"  colspan="2" align="center"><input type="reset" class="button_sea mr18" value="返回" onclick="window.location.href='tousu!showfklist.action';"/></td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
       </div>
       </div>
       </div>
    
</body>
</html>