<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业列表</title>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
</head>
<body >
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">企业列表</a></li>
       <li><img src="images/jiao.gif" width="8" height="28" /></li>
       <li style="float:right" class="mr11"><img src="../images/houtui.gif" width="59" height="23" class="mr8" /><input type=button value="" class="button_shuaxin" onclick="window.parent['mainFrame'].location.reload()"></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
   
      <div>

<div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(../images/bj_taitou.gif) repeat-x; height:30px; line-height:30px;" >
          <tr>
            <td width="20" ><img src="images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">企业查询</font>&nbsp;&nbsp;<font class="font-666">+点击查看更多查询条件</font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
     <form action="company!companys.action" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font-69f" >
          <tr><td colspan="8" class="h8"></td></tr>
          <tr>                                                  
            <td width="10%" align="right">企业名称</td>
            <td width="14%"><input name="cnamecn" value='<ww:property value="company.cnamecn"/>' type="text" class="text" /></td>
            <td width="10%" align="right">企业代码</td>
            <td width="14%"><input name="comcode" value='<ww:property value="company.comcode"/>' type="text" class="text" /></td>
            <td width="10%" align="right">英文简称</td>
            <td width="14%"><input name="simnameen" value='<ww:property value="company.simnameen"/>'  type="text" class="text" /></td>
          </tr>
          <tr><td colspan="8" class="h8"></td></tr>
          <tr>
          <td class="butt font-666" colspan="8"><input type="submit" class="button_sea mr18" value="查询订单"  /><img src="images/tisp.gif"  width="23" height="34" /> 根据您所知道的内容进行查询，数据量较大可能会查询较慢，请您耐心等待！ </td>
          </tr>
        </table>
        </form>
      </div>
      <div class="list">
      <form action="" name="form1" id="form1">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2" >
          <tr>
            <td width="34"><img src="images/no1.gif" width="34" height="28" /> </td>
            <td align="left"><font class="font16-f90">企业列表</font><br/><font class="font-666">2011-04-05</font></td>
            <td>&nbsp;</td>
           
          </tr>
        </table>
        <table width="100%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao" id="table1">
          <tbody>
            <th scope="col" width="3%"  align="center"><input name="" type="checkbox" value="" class="ml5"  /></th>
            <th scope="col"><div class="thleft">企业名称</div></th>
            <th scope="col"><div class="thleft">英文简称</div></th>
            <th scope="col"><div class="thleft">企业代码</div></th>
            <th scope="col"><div class="thleft">所属地域</div></th>
            <th scope="col"><div class="thleft">公司类型</div></th>
            <th scope="col"><div class="thleft">签约日期</div></th>           
            <th scope="col"><div class="thleft">联系人</div></th>                                         
            <th scope="col"><div class="thleft">联系电话</div></th>                                         
            <th scope="col"><div class="thleft">操作</div></th>                                         
          </tbody>
          <ww:iterator value="companys">
          <tr>
            <td   class="tdpadd0">
            <div class="tdleft"> <input name="" type="checkbox" value=""/></div> </td>
            <td><ww:property value="cnamecn"/></td>
            <td><ww:property value="simnameen"/></td>
            <td><ww:property value="comcode"/></td>
            <td><ww:property value="area"/></td>
            <td><ww:property value="calling"/></td>
            <td><ww:property value="formatTimestampyyyyMMdd(ispacttime)"/></td>
            <td><ww:property value="contactname"/></td>
            <td><ww:property value="contacttel"/></td>
            <td>
            <a href="">编辑</a>
            <a href="">删除</a>
            <a href='company!tograntlimit.action?id=<ww:property value="id"/>'>权限设置</a>
            </td>
          </tr>
          </ww:iterator>
          <tr>
            <td class="tdpadd00" colspan="10" align="left">
            <div class="fenye">
            <!-- 
                <ul>
                <li><img src="../images/fenye.gif" width="20" height="25" align="absmiddle"  /></li>
                <li>共 5071 条记录</li>
                <li>每页显示10条内容</li>
                <li>当前1/254页</li>
                <li>首页  1 2 3 4 5 6 7 8 9 10 下一页</li>
                <li>跳转到&nbsp;&nbsp;<input name="" type="text"  class="text30" />&nbsp;&nbsp;页&nbsp;&nbsp;<a href="#">转到</a></li>
                </ul>
             -->
		<ww:property
			value='getPagetwo(pageinfo,"pageinfo","company!companys.action","form1")' />
             </div>
             </td>
          </tr>
         </table> 
         </form>
         <div class="h8" >&nbsp;</div>
      </div>
      </div>
    </div>
</div>
</body>
</html>
