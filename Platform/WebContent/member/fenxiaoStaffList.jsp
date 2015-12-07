<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="Stylesheet" href="Common.css" />
	<link href="../css/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;员工管理</b></td>
  </tr>
  <tr>
    <td height="455" valign="top">


  <table width="100%" class="hj">
  <!--<tr>
                <td width="100%" height="29" colspan="8" background="../images/jb.gif" style="border-bottom: 1px solid #99CBED">
                    <span class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;员工管理</span></td>
            </tr>
            --><tr>
                <td>
                    <table class="table2">
                        <tr>
                            <td class="tdx1" colspan="2">
                                帐号                            </td>
                            <td class="tdx2" colspan="2">
                                <input name="txtID" type="text" id="txtID" />                            </td>
                            <td class="tdx1" colspan="2">
                                姓名                            </td>
                            <td class="tdx2" colspan="2" rowspan="">
                                <input name="txtLinkMan" type="text" id="txtLinkMan" />                            </td>
                            <td class="tdx1" colspan="2">
                                联系电话                            </td>
                            <td class="tdx2" colspan="2">
                                <input name="txtPhone" type="text" id="txtPhone" />                            </td>
                            <td class="tdx1">
                                所属角色                            </td>
                            <td class="tdx2">
                                <select name="dropPowerType" id="dropPowerType">
	<option selected="selected" value=""></option>
	<option value="综合部">综合部</option>
	<option value="员工管理">员工管理</option>
	<option value="政策">政策</option>
	<option value="B2C管理员">B2C管理员</option>
	<option value="出票员">出票员</option>
	<option value="业务员">业务员</option>
	<option value="采购员">采购员</option>
	<option value="政策负责人">政策负责人</option>
	<option value="预存款操作员">预存款操作员</option>
	<option value="综合管理">综合管理</option>
	<option value="订单查询">订单查询</option>
	<option value="投诉受理员">投诉受理员</option>
	<option value="退款">退款</option>
	<option value="财务">财务</option>
	<option value="系统最小权限">系统最小权限</option>
	<option value="结算">结算</option>
	<option value="建议表扬受理员">建议表扬受理员</option>
	<option value="预存款管理员">预存款管理员</option>
	<option value="系统管理员">系统管理员</option>
	<option value="开户">开户</option>
	<option value="财务结算员">财务结算员</option>
	<option value="疑难问题受理员">疑难问题受理员</option>
</select>                            </td>
                            <td class="tdx3" colspan="3">                            </td>
                        </tr>
                        <tr>
                          <td class="tdx1" colspan="2">所属单位：</td>
                          <td class="tdx2" colspan="2"><select name="dropPowerType2" id="dropPowerType2">
                            <option selected="selected" value=""></option>
                            <option value="综合部">单位1</option>
                            <option value="员工管理">单位2</option>
                            <option value="政策">单位3</option>
                            <option value="B2C管理员">单位4</option>
                            <option value="出票员">单位5</option>
                            <option value="业务员">单位6</option>
                            <option value="采购员">单位7</option>
                            <option value="政策负责人">单位8</option>
                            <option value="预存款操作员">单位9</option>
                            <option value="综合管理">单位10</option>
                          </select></td>
                          <td class="tdx1" colspan="2">&nbsp;</td>
                          <td class="tdx2" colspan="2">&nbsp;</td>
                          <td class="tdx1" colspan="2">&nbsp;</td>
                          <td class="tdx2" colspan="2">&nbsp;</td>
                          <td class="tdx1">&nbsp;</td>
                          <td class="tdx2">&nbsp;</td>
                          <td class="tdx3" colspan="3"></td>
                        </tr>
                        <tr>
                            <td colspan="19" align="center">
                                <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="查&nbsp;&nbsp;询" onclick="searchOne()" />
                                <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="添加新员工" onclick="javascript:window.location.href('../member/StaffDetail.html')" />
                               <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="启用/禁用选中项" onclick="searchOne()" />
                                <input type="button" style="background: url(../images/hout3.gif); width: 98px; height: 31px;
                                                border: none; color: #FFF; font-weight: bold;" value="清除条件" onclick="searchOne()" /></td>
                        </tr>
                    </table>
              </td>
            </tr>
            <tr>
                <td>
                    <table border="0" cellpadding="0" cellspacing="0" class="hj" bordercolor="#a0cfee" style="border-collapse: collapse">
                        <tr class="hjtrx">
                            <td valign="bottom">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr style="height: 20px">
                                        <td class="hj2" style="width: 3%; height: 20px;">&nbsp;
                                            </td>
                                        <td id="TD1" class="hj3" style="width: 15%; height: 20px;">
                                            <a id="lbtnUsed" class="font3" href="javascript:__doPostBack('lbtnUsed','')" style="display:inline-block;text-decoration:none;width:100%;">启用</a></td>

                                        <td class="hj2" style="width: 3%; height: 20px;">&nbsp;
                                            </td>
                                        <td id="TD2" class="hj1" style="width: 15%; height: 20px;">
                                            <a id="lbtnDisUsed" class="font1" href="javascript:__doPostBack('lbtnDisUsed','')" style="display:inline-block;text-decoration:none;width:100%;">禁用</a></td>

                                        <td class="hj2" style="width: 3%; height: 20px;">&nbsp;
                                            </td>
                                        <td id="TD3" class="hj1" style="width: 15%; height: 20px;">
                                            <a id="lbtnAll" class="font1" href="javascript:__doPostBack('lbtnAll','')" style="display:inline-block;text-decoration:none;width:100%;">全部</a></td>

                                        <td class="hj2" style="width:46%; height: 20px;">&nbsp;
                                            </td>
                                    </tr>
                                    <tr>
                                        <td colspan="7">
                                            <table class="TD_BG01" cellspacing="0" border="0" id="sdgSoffInfo" style="color:#333333;width:100%;border-collapse:collapse;">
	<tr style="background-color:#d7e9fc">
		<td>&nbsp;</td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl00','')" style="color:#333333;">帐号</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl01','')" style="color:#333333;">姓名</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl02','')" style="color:#333333;">办公电话</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl03','')" style="color:#333333;">移动电话</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl04','')" style="color:#333333;">启用状态</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl05','')" style="color:#333333;">添加人</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl06','')" style="color:#333333;">开户时间</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl07','')" style="color:#333333;">所属角色</a></td>
		<td>类型</td>
		<td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl08','')" style="color:#333333;">上次登录时间</a></td><td><a href="javascript:__doPostBack('sdgSoffInfo$ctl02$ctl09','')" style="color:#333333;">总登录次数</a></td><td>操作</td>
	</tr><tr class="hjtr2" align="center" onmouseout="runtimeStyle.backgroundColor=''" onmouseover="runtimeStyle.backgroundColor='AliceBlue'">
		<td>
<input id="sdgSoffInfo_ctl03_CheckBox1" type="checkbox" name="sdgSoffInfo$ctl03$CheckBox1" /></td><td>huitaojp001</td><td>吕小姐</td><td>&nbsp;</td><td>13799382200</td><td>启用</td><td>俞良财</td><td>2009-5-13 12:35:14</td><td>出票员,政策负责人</td>
<td><font color="#FF0000">分销商</font></td>
<td>2009-11-28 12:48:34</td><td>14</td><td>
                                            <table style="text-align:center;">
                                                <tr>
                                                    <td nowrap="nowrap" style="height:20px;">
                                                        <a id="sdgSoffInfo_ctl03_Edit" href="javascript:__doPostBack('sdgSoffInfo$ctl03$Edit','')">[修    改]</a>                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td nowrap="nowrap" style="height:20px;">
                                                        <a onclick="return confirm('是否确认修改状态？');" id="sdgSoffInfo_ctl03_ChangeAuditFlag" href="javascript:__doPostBack('sdgSoffInfo$ctl03$ChangeAuditFlag','')">[禁    用]</a>                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td nowrap="nowrap" style="height:20px;">
                                                        <a id="sdgSoffInfo_ctl03_Del" href="javascript:__doPostBack('sdgSoffInfo$ctl03$Del','')">[授    权]</a>                                                    </td>
                                                </tr>
                                                <tr id="sdgSoffInfo_ctl03_trInitial">
			<td nowrap="nowrap" style="height:20px;">
                                                        <a onclick="ShowDialog('../Accounts/ReSetPWD.aspx?id=60703','初始化密码',350,300,'no');" id="sdgSoffInfo_ctl03_lbtnInitialization" href="javascript:__doPostBack('sdgSoffInfo$ctl03$lbtnInitialization','')">[初始化密码]</a>                                                    </td>
		</tr>
                                            </table>
                                            </td>
	</tr><tr align="center">
		<td align="right" valign="bottom" colspan="13" style="border-width:1px;border-style:solid;"><span>每页10条 </span><span>共1条&nbsp;&nbsp;&nbsp;&nbsp;</span><span> 前 页 </span><span> </span><span id="sdgSoffInfo_ctl05_lblNextPageTile"> 后 页&nbsp;&nbsp;&nbsp;&nbsp;</span><span id="sdgSoffInfo_ctl05_lbl">  第1</span><span>页/</span><span>共1页&nbsp;&nbsp;&nbsp;&nbsp;</span><input name="sdgSoffInfo$ctl05$txtPage" type="text" value="1" maxlength="5" id="sdgSoffInfo_ctl05_txtPage" onkeyup="JavaScript:this.value = isNaN(Number(this.value))? 1:this.value;" style="width:30px;" /><input type="submit" name="sdgSoffInfo$ctl05$btnGo" value="go" id="sdgSoffInfo_ctl05_btnGo" /></td>
	</tr>
</table>
                                          <script language="javascript">var color1=null,color2=null;function SelectOneRow(chkB){var xState=chkB.checked;if(xState){if(chkB.parentElement.parentElement.style.backgroundColor!='lightcoral'){if(color1==null){color1 = chkB.parentElement.parentElement.style.backgroundColor;}else if(color1!=chkB.parentElement.parentElement.style.backgroundColor && color2==null){color2=chkB.parentElement.parentElement.style.backgroundColor;}}chkB.parentElement.parentElement.style.backgroundColor='lightcoral';}else{var elm = chkB.form.elements;var j;j=GetNum(elm,chkB.id);if(j%2==0){chkB.parentElement.parentElement.style.backgroundColor=color1;}else{chkB.parentElement.parentElement.style.backgroundColor=color2;}chkB.parentElement.parentElement.style.color='black';}}function GetNum(elm,id){var j=0;for(i=0;i<elm.length;i++)if(elm[i].type=='checkbox'){j++;if(elm[i].id==id){return j;}}}function SelectAllCheckboxes(spanChk){var xState=spanChk.checked;var theBox=spanChk;elm=theBox.form.elements;for(i=0;i<elm.length;i++)if(elm[i].type=="checkbox" && elm[i].id!=theBox.id){if(elm[i].checked!=xState)elm[i].click();}}var act_bgc='#BEC5DE';var act_fc='black';function outIt(){var the_obj = event.srcElement;var i=0;if(the_obj.tagName.toLowerCase() != 'table'){var the_td	= get_Element(the_obj,'td');if(the_td==null) return;var the_tr	= the_td.parentElement;var the_table= get_Element(the_td,'table');if(the_tr.rowIndex>=1){for(i=0;i<the_tr.cells.length-1;i++){with(the_tr.cells[i]){runtimeStyle.backgroundColor='';runtimeStyle.color='';}}}}}function overIt(){var the_obj = event.srcElement;var i = 0;if(the_obj.tagName.toLowerCase() != 'table'){var the_td	= get_Element(the_obj,'td');if(the_td==null) return;var the_tr	= the_td.parentElement;var the_table	= get_Element(the_td,'table');if(the_tr.rowIndex>=1){for(i=0;i<the_tr.cells.length-1;i++){	with(the_tr.cells[i]){runtimeStyle.backgroundColor=act_bgc;runtimeStyle.color=act_fc;}}}}}function get_Element(the_ele,the_tag){the_tag = the_tag.toLowerCase();if(the_ele.tagName.toLowerCase()==the_tag)return the_ele;while(the_ele=the_ele.offsetParent){if(the_ele.tagName.toLowerCase()==the_tag)return the_ele;}return(null);}</script>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <strong><span style="color: Red">注意事项:</span></strong>
                </td>
            </tr>
            <tr>
                <td>
                    <ul>
                        <li>联系电话可为办公电话 也可为移动电话</li><li>启用/禁用选择:启用 该帐户可以登录系统</li>
                        <li>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 禁用 该帐户不可以登录系统</li>
                        <li><span style="color: #ff0000">授权选择:可进入权限选择页面</span></li></ul>
                </td>
            </tr>
        </table>
        
        	</td>
   </tr>
   </table>
</div>
        
</body>
</html>
