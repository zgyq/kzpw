<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link id="cssfile" href="Common.css" type="text/css" rel="Stylesheet" />
<link href="../css/base.css" rel="stylesheet" type="text/css" />
<link href="../style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;用户管理-酒店常用旅客</b></td>
  </tr>
  <tr>
    <td height="455" valign="top">


<table width="100%">
<!--<tr>
                <td width="100%" height="29" colspan="6" background="../images/jb.gif" style="border-bottom: 1px solid #99CBED">
                    <span class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;用户管理-酒店常用旅客</span></td>
            </tr>
            --><tr>
                <td style="width: 100%;" valign="bottom">
                    <table class="table2" width="100%">
                        <tr>
                            <td width="61" align="right" class="tdx1">
                                姓名&nbsp;</td>
                            <td class="tdx2" style="height: 23px">
                                <input name="txtPassenger" type="text" id="txtPassenger" class="zc" style="width: 100px" />
                            </td>
                            <td align="right" class="tdx1" style="width: 11%;">
                                手机号码&nbsp;</td>
                            <td colspan="5" class="tdx2">
                                    <input name="txtPhone" type="text" id="txtPhone" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" class="zc" style="width: 100px" />
                            </td>
                            <td class="tdx3">
                               <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="查&nbsp;&nbsp;询" onclick="searchOne()" />
                            </td>
                            <td class="tdx3">
                              <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="添加" onclick="javascript:window.location.href('PassengerDetail.html')" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="10">
                    <table class="table3" width="100%">
                        <tr>
                            <td style="width: 100%">
                                <table class="TD_BG01" cellspacing="0" cellpadding="3" rules="rows" border="0" id="SDGNetInfo" style="border-width:0px;border-style:None;font-size:Small;width:100%;border-collapse:collapse;">
	<tr class="hjtr1" style="font-style:normal;text-decoration:none;">
		<td width="12%"><a href="javascript:__doPostBack('SDGNetInfo$ctl02$ctl00','')">姓名</a></td><td width="1%">&nbsp;</td>
		<td width="17%"><a href="javascript:__doPostBack('SDGNetInfo$ctl02$ctl02','')">证件类型</a></td>
		<td width="21%"><a href="javascript:__doPostBack('SDGNetInfo$ctl02$ctl03','')">证件号码</a></td>
		<td width="10%"><a href="javascript:__doPostBack('SDGNetInfo$ctl02$ctl04','')">手机号码</a></td>
		<td width="17%"><a href="javascript:__doPostBack('SDGNetInfo$ctl02$ctl05','')">添加日期</a></td>
		<td width="22%">操 作</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>fy/gyk</td><td>&nbsp;</td><td>身份证</td><td>g486773</td><td>&nbsp;</td><td>2009年11月27日</td><td>
&nbsp; <a id="SDGNetInfo_ctl03_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl03$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl03_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl03$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr3" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>fgj/ftyk</td><td>&nbsp;</td><td>身份证</td><td>g48678888</td><td>&nbsp;</td><td>2009年11月27日</td><td>
&nbsp; <a id="SDGNetInfo_ctl04_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl04$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl04_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl04$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>esye/fjt</td><td>&nbsp;</td><td>身份证</td><td>g48637</td><td>&nbsp;</td><td>2009年11月27日</td><td>
&nbsp; <a id="SDGNetInfo_ctl05_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl05$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl05_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl05$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr3" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>drj/fgjtyj</td><td>&nbsp;</td><td>身份证</td><td>g527828</td><td>&nbsp;</td><td>2009年11月27日</td><td>
&nbsp; <a id="SDGNetInfo_ctl06_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl06$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl06_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl06$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>segh/shh</td><td>&nbsp;</td><td>身份证</td><td>g581199</td><td>&nbsp;</td><td>2009年11月20日</td><td>
&nbsp; <a id="SDGNetInfo_ctl07_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl07$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl07_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl07$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr3" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>肖露</td><td>&nbsp;</td><td>身份证</td><td>350102198711191531</td><td>&nbsp;</td><td>2009年11月19日</td><td>
&nbsp; <a id="SDGNetInfo_ctl08_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl08$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl08_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl08$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>王玲</td><td>&nbsp;</td><td>身份证</td><td>350102198502176423</td><td>&nbsp;</td><td>2009年11月19日</td><td>
&nbsp; <a id="SDGNetInfo_ctl09_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl09$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl09_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl09$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr3" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>林小辉</td><td>&nbsp;</td><td>身份证</td><td>350102198709111512</td><td>&nbsp;</td><td>2009年11月19日</td><td>
&nbsp; <a id="SDGNetInfo_ctl10_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl10$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl10_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl10$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>李玲</td><td>&nbsp;</td><td>身份证</td><td>350102199006083222</td><td>&nbsp;</td><td>2009年11月19日</td><td>
&nbsp; <a id="SDGNetInfo_ctl11_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl11$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl11_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl11$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr class="hjtr3" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>dh/euse</td><td>&nbsp;</td><td>身份证</td><td>g8748456</td><td>&nbsp;</td><td>2009年11月18日</td><td>
&nbsp; <a id="SDGNetInfo_ctl12_lbtnUpdate" href="javascript:__doPostBack('SDGNetInfo$ctl12$lbtnUpdate','')" style="display:inline-block;width:62px;">修改</a> <a onclick="return confirm(&quot;确认删除？&quot;);" id="SDGNetInfo_ctl12_lbtnDelet" href="javascript:__doPostBack('SDGNetInfo$ctl12$lbtnDelet','')" style="display:inline-block;width:62px;">删除</a> 
</td>
	</tr><tr align="center">
		<td align="right" valign="bottom" colspan="7" style="border-width:1px;border-style:solid;"><span>每页10条 </span><span>共119条&nbsp;&nbsp;&nbsp;&nbsp;</span><span> 前 页 </span><span> </span><a id="SDGNetInfo_ctl14_lbtnNext" href="javascript:__doPostBack('SDGNetInfo$ctl14$lbtnNext','')">后 页</a>&nbsp;&nbsp;&nbsp;&nbsp;<span id="SDGNetInfo_ctl14_lbl">  第1</span><span>页/</span><span>共12页&nbsp;&nbsp;&nbsp;&nbsp;</span><input name="SDGNetInfo$ctl14$txtPage" type="text" value="1" maxlength="5" id="SDGNetInfo_ctl14_txtPage" onkeyup="JavaScript:this.value = isNaN(Number(this.value))? 1:this.value;" style="width:30px;" /><input type="submit" name="SDGNetInfo$ctl14$btnGo" value="go" id="SDGNetInfo_ctl14_btnGo" /></td>
	</tr>
</table><script language="javascript">var color1=null,color2=null;function SelectOneRow(chkB){var xState=chkB.checked;if(xState){if(chkB.parentElement.parentElement.style.backgroundColor!='lightcoral'){if(color1==null){color1 = chkB.parentElement.parentElement.style.backgroundColor;}else if(color1!=chkB.parentElement.parentElement.style.backgroundColor && color2==null){color2=chkB.parentElement.parentElement.style.backgroundColor;}}chkB.parentElement.parentElement.style.backgroundColor='lightcoral';}else{var elm = chkB.form.elements;var j;j=GetNum(elm,chkB.id);if(j%2==0){chkB.parentElement.parentElement.style.backgroundColor=color1;}else{chkB.parentElement.parentElement.style.backgroundColor=color2;}chkB.parentElement.parentElement.style.color='black';}}function GetNum(elm,id){var j=0;for(i=0;i<elm.length;i++)if(elm[i].type=='checkbox'){j++;if(elm[i].id==id){return j;}}}function SelectAllCheckboxes(spanChk){var xState=spanChk.checked;var theBox=spanChk;elm=theBox.form.elements;for(i=0;i<elm.length;i++)if(elm[i].type=="checkbox" && elm[i].id!=theBox.id){if(elm[i].checked!=xState)elm[i].click();}}var act_bgc='#BEC5DE';var act_fc='black';function outIt(){var the_obj = event.srcElement;var i=0;if(the_obj.tagName.toLowerCase() != 'table'){var the_td	= get_Element(the_obj,'td');if(the_td==null) return;var the_tr	= the_td.parentElement;var the_table= get_Element(the_td,'table');if(the_tr.rowIndex>=1){for(i=0;i<the_tr.cells.length-1;i++){with(the_tr.cells[i]){runtimeStyle.backgroundColor='';runtimeStyle.color='';}}}}}function overIt(){var the_obj = event.srcElement;var i = 0;if(the_obj.tagName.toLowerCase() != 'table'){var the_td	= get_Element(the_obj,'td');if(the_td==null) return;var the_tr	= the_td.parentElement;var the_table	= get_Element(the_td,'table');if(the_tr.rowIndex>=1){for(i=0;i<the_tr.cells.length-1;i++){	with(the_tr.cells[i]){runtimeStyle.backgroundColor=act_bgc;runtimeStyle.color=act_fc;}}}}}function get_Element(the_ele,the_tag){the_tag = the_tag.toLowerCase();if(the_ele.tagName.toLowerCase()==the_tag)return the_ele;while(the_ele=the_ele.offsetParent){if(the_ele.tagName.toLowerCase()==the_tag)return the_ele;}return(null);}</script>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <strong><span style="color: Red">注意事项:</span></strong></td>
            </tr>
            <tr>
                <td>
                    <ul>
                        <li>"姓名"模糊查找，可以是中文，也可以是英文。</li>
                    </ul>
                </td>
            </tr>
        </table>
        
              </td>
   </tr>
   </table>
</div>  
</body>
</html>
