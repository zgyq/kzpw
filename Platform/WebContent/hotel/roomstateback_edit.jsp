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
<title><ww:if test="roomstateback.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房态表</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body>
<form action="roomstateback!<ww:if test="roomstateback.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="100%" height="29" background="../images/jianbianbj.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="roomstateback.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房态表</span></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">月份：</span></td><td><input type="text" require="true" dataType="Require"   msg="月份不能为空" name="datenumber" value='<ww:property value="roomstateback.datenumber"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">酒店ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="酒店ID不能为空" name="hotelid" value='<ww:property value="roomstateback.hotelid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">房型ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="房型ID不能为空" name="roomid" value='<ww:property value="roomstateback.roomid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">是否禁用：</span></td><td><input type="text" require="true" dataType="Require"   msg="是否禁用不能为空" name="isvalid" value='<ww:property value="roomstateback.isvalid"/>'" style="width:350px" /></td>  </tr>
	
				 

			
   
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">描述：</span></td><td><textarea name="description" cols="50" rows="5"><ww:property value="roomstateback.description"/></textarea> </td>  </tr>
	
			
			
			 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="roomstateback.state"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">是否确认：</span></td><td><input type="text" require="true" dataType="Require"   msg="是否确认不能为空" name="confirm" value='<ww:property value="roomstateback.confirm"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">计算类别：</span></td><td><input type="text" require="true" dataType="Require"   msg="计算类别不能为空" name="type" value='<ww:property value="roomstateback.type"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态31：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态31不能为空" name="no31" value='<ww:property value="roomstateback.no31"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态30：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态30不能为空" name="no30" value='<ww:property value="roomstateback.no30"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态29：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态29不能为空" name="no29" value='<ww:property value="roomstateback.no29"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态28：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态28不能为空" name="no28" value='<ww:property value="roomstateback.no28"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态27：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态27不能为空" name="no27" value='<ww:property value="roomstateback.no27"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态26：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态26不能为空" name="no26" value='<ww:property value="roomstateback.no26"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态25：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态25不能为空" name="no25" value='<ww:property value="roomstateback.no25"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态24：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态24不能为空" name="no24" value='<ww:property value="roomstateback.no24"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态23：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态23不能为空" name="no23" value='<ww:property value="roomstateback.no23"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态22：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态22不能为空" name="no22" value='<ww:property value="roomstateback.no22"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态21：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态21不能为空" name="no21" value='<ww:property value="roomstateback.no21"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态20：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态20不能为空" name="no20" value='<ww:property value="roomstateback.no20"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态19：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态19不能为空" name="no19" value='<ww:property value="roomstateback.no19"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态18：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态18不能为空" name="no18" value='<ww:property value="roomstateback.no18"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态17：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态17不能为空" name="no17" value='<ww:property value="roomstateback.no17"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态16：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态16不能为空" name="no16" value='<ww:property value="roomstateback.no16"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态15：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态15不能为空" name="no15" value='<ww:property value="roomstateback.no15"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态14：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态14不能为空" name="no14" value='<ww:property value="roomstateback.no14"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态13：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态13不能为空" name="no13" value='<ww:property value="roomstateback.no13"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态12：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态12不能为空" name="no12" value='<ww:property value="roomstateback.no12"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态11：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态11不能为空" name="no11" value='<ww:property value="roomstateback.no11"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态10：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态10不能为空" name="no10" value='<ww:property value="roomstateback.no10"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态9：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态9不能为空" name="no9" value='<ww:property value="roomstateback.no9"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态8：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态8不能为空" name="no8" value='<ww:property value="roomstateback.no8"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态7：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态7不能为空" name="no7" value='<ww:property value="roomstateback.no7"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态6：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态6不能为空" name="no6" value='<ww:property value="roomstateback.no6"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态5：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态5不能为空" name="no5" value='<ww:property value="roomstateback.no5"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态4：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态4不能为空" name="no4" value='<ww:property value="roomstateback.no4"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态3：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态3不能为空" name="no3" value='<ww:property value="roomstateback.no3"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态2：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态2不能为空" name="no2" value='<ww:property value="roomstateback.no2"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日房态1：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日房态1不能为空" name="no1" value='<ww:property value="roomstateback.no1"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩31：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩31不能为空" name="back31" value='<ww:property value="roomstateback.back31"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩30：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩30不能为空" name="back30" value='<ww:property value="roomstateback.back30"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩29：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩29不能为空" name="back29" value='<ww:property value="roomstateback.back29"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩28：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩28不能为空" name="back28" value='<ww:property value="roomstateback.back28"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩27：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩27不能为空" name="back27" value='<ww:property value="roomstateback.back27"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩26：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩26不能为空" name="back26" value='<ww:property value="roomstateback.back26"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩25：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩25不能为空" name="back25" value='<ww:property value="roomstateback.back25"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩24：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩24不能为空" name="back24" value='<ww:property value="roomstateback.back24"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩23：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩23不能为空" name="back23" value='<ww:property value="roomstateback.back23"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩22：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩22不能为空" name="back22" value='<ww:property value="roomstateback.back22"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩21：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩21不能为空" name="back21" value='<ww:property value="roomstateback.back21"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩20：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩20不能为空" name="back20" value='<ww:property value="roomstateback.back20"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩19：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩19不能为空" name="back19" value='<ww:property value="roomstateback.back19"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩18：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩18不能为空" name="back18" value='<ww:property value="roomstateback.back18"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩17：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩17不能为空" name="back17" value='<ww:property value="roomstateback.back17"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩16：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩16不能为空" name="back16" value='<ww:property value="roomstateback.back16"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩15：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩15不能为空" name="back15" value='<ww:property value="roomstateback.back15"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩14：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩14不能为空" name="back14" value='<ww:property value="roomstateback.back14"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩13：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩13不能为空" name="back13" value='<ww:property value="roomstateback.back13"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩12：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩12不能为空" name="back12" value='<ww:property value="roomstateback.back12"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩11：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩11不能为空" name="back11" value='<ww:property value="roomstateback.back11"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩10：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩10不能为空" name="back10" value='<ww:property value="roomstateback.back10"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩9：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩9不能为空" name="back9" value='<ww:property value="roomstateback.back9"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩8：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩8不能为空" name="back8" value='<ww:property value="roomstateback.back8"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩7：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩7不能为空" name="back7" value='<ww:property value="roomstateback.back7"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩6：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩6不能为空" name="back6" value='<ww:property value="roomstateback.back6"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩5：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩5不能为空" name="back5" value='<ww:property value="roomstateback.back5"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩4：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩4不能为空" name="back4" value='<ww:property value="roomstateback.back4"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩3：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩3不能为空" name="back3" value='<ww:property value="roomstateback.back3"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩2：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩2不能为空" name="back2" value='<ww:property value="roomstateback.back2"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">单日剩1：</span></td><td><input type="text" require="true" dataType="Require"   msg="单日剩1不能为空" name="back1" value='<ww:property value="roomstateback.back1"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button" value="提交"/> <input type="button" class="button" onclick="window.location.href='roomstateback.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
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


