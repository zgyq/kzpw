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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotelprice.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店价格</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
.STYLE1 {font-size: 14px}
.STYLE3 {color: #FF0000}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body>
<form action=hotelprice!add1.action>


<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="100%" height="29" background="../images/jianbianbj.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="hotelprice.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店价格</span></td>
  </tr>
  <tr>
    <td height="100%"><table width="82%" cellpadding="0" cellspacing="0">
      <tr>
        <td height="18" colspan="2"><table width="98%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="19">特殊价格添加</td>
          </tr>
          <tr>
            <td height="175"><form id="form1" name="form1" method="post" action="">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="center"><p><span class="STYLE1">酒店</span>*
                      <input name="textfield" type="text" />
                      房型*
  <select name="select">
    <option>普通间</option>
    <option>豪华间</option>
  </select>
                    </p>
                      <p>起始时间*
                        <input name="textfield3" type="text"  onfocus="calendar()" />
                        结束时间
                        *
  <input name="textfield4" type="text" onfocus="calendar()" value="<>"/>
                      </p>
                      <p>注意：所有价格均采用人民币（rmb），选择酒店后请重新选择房型！</p>
                      <p>添加价格*</p>
                      <div align="center">
                        <table width="65%" height="59" border="1" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                            <td width="13%" height="33">周日
                              <label></label></td>
                            <td width="13%">周
                              <label>一 </label></td>
                            <td width="13%">周二
                              <label> </label>
                                <label></label></td>
                            <td width="13%">周三
                              <label> </label>
                                <label></label></td>
                            <td width="13%">周四
                              <label></label></td>
                            <td width="14%">周五
                              <label></label></td>
                            <td width="21%">周六
                              <label></label></td>
                          </tr>
                          <tr>
                            <td height="24"><div align="center">
                                <input name="textfield2" type="text" value="250" size="10" />
                            </div></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                            <td><input name="" type="text" value="250" size="10" /></td>
                          </tr>
                        </table>
                        <table width="45%" height="69" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td align="center"><p align="right" class="STYLE3">&nbsp;</p>
                              <p align="left">起始时间*：
                                <input name="begintime" type="text" value=""/>
                                结束时间
                                *：
  <input name="endtime" type="text" value=""/>
                              </p>
                              <p align="left">价格*：
                                <input name="textfield5" type="text" value="450" />
</p>
                              <p align="left">特点说明：
                                <textarea name="textarea">国庆期间普通间价格</textarea>
                              </p>
                            <p align="center"></p></td>
                          </tr>
                        </table>
                        <p>&nbsp;</p>
                        <p align="right" class="STYLE3">&nbsp;</p>
                        <p align="left">&nbsp;</p>
                    </div></td>
                  </tr>
                </table>
                <p>&nbsp;</p>
              </form></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        </tr>
	
				 

			
   
	 <tr class="font-blue-xi"><td width="320" height="28" align="right"><span class="STYLE2">描述：</span></td><td width="821"><textarea name="description" cols="50" rows="5"><ww:property value="hotelprice.description"/></textarea> </td>  </tr>
	
			
			
			 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-white" value="提交"/> <input type="button" class="button_d font-white" onclick="window.location.href='hotelprice.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</body>
</html>
