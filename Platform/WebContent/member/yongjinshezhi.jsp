<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="Common.css" rel="stylesheet" type="text/css" />
<link href="AccountOpen.css" rel="stylesheet" type="text/css" />
<link href="../style/base.css" rel="stylesheet" type="text/css" />
<link href="../style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;设置佣金信息</b></td>
  </tr>
  <tr>
    <td  valign="top">


    <div >
        <div class="mnue">
            &nbsp;&nbsp;国内机票佣金</div>
        <div class="mnue_nr">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <!--DWLayoutTable-->
                <tr>
                    <td width="15%" align="right">本公司分级留点方式：                    </td>
                    <td width="35%"><input name="txtStaffName2" type="text" id="txtStaffName2" size="14" onkeyup="StaffNameAndLinkName();" onbeforepaste="StaffNameAndLinkName();" />
                      <span  class="font-red-xi"> （注：请输入百分数如0.50% ）</span></td>
                    <td width="15%" align="right">
                        <span class="font-red-xi">*</span>异地分级留点方式：                    </td>
                    <td width="35%">
                        <input name="txtStaffID" type="text" id="txtStaffID" size="14" />
                       <span class="font-red-xi"> （注：请输入百分数如0.50% ）</span>                    </td>
                </tr>
            </table>
        </div>
        
        <div class="mnue">
            &nbsp;&nbsp;国际机票佣金</div>
         <div class="mnue_nr">
               <table width="100%" border="0" cellpadding="0" cellspacing="0">
               		<tr>
                    <td width="15%" align="right">本公司分级加点方式：                    </td>
                    <td width="35%"><input name="txtStaffName2" type="text" id="txtStaffName2" size="14" onkeyup="StaffNameAndLinkName();" onbeforepaste="StaffNameAndLinkName();" />
                      <span class="STYLE1"> （注：请输入百分数如0.50% ）</span></td>
                    <td width="15%" align="right">
                        <span style="color: #ff0000">*</span>异地分级加点方式：                    </td>
                    <td width="35%">
                        <input name="txtStaffID" type="text" id="txtStaffID" size="14" />
                       <span class="STYLE1"> （注：请输入百分数如0.50% ）</span>                    </td>
                </tr>
                
                <tr>
                                  <td align="right">选择分销商：</td>
                                  <td><select><option>分销商1</option><option>分销商2</option><option>分销商3</option><option>分销商4</option><option>分销商5</option></select></td>
                                  <td align="right"><!--DWLayoutEmptyCell-->&nbsp;</td>
                                  <td><!--DWLayoutEmptyCell-->&nbsp;</td>
               </tr>
             </table>  
        </div>
    </div>
    
    <div  style="height:40px; margin-top: 10px;" align="center">
        <input type="button" class="button_d font-white" value="确 认" onclick="searchOne()" />
                                                
        
        <input type="button" class="button_d font-white" value="返 回" onclick="searchOne()" />
                                                
        <input name="txtdeptId" type="hidden" id="txtdeptId" />
        <input name="HidCity" type="hidden" id="HidCity" />
    </div>

    
      </td>
   </tr>
   </table>
</div>  
    <div >
        <strong><span class="font-red">注意事项:</span></strong>
        <br />
        <ul style="padding-left:30px;">
            <li>默认为全部选择 即该帐户拥有所有权限</li>
            <li>点击模块选择框 该下属选择框 默认为相同状态</li>
            <li>没有选择的功能 将被视为该帐户禁止使用的功能 </li>
        </ul>
   </div> 
    
</body>
</html>
