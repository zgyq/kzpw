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
 *  2009/08/17 创建
 *
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotel.id>0">酒店信息</ww:if></title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
 
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">洒店名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="洒店名称不能为空" name="name" value='<ww:property value="name"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">英文名称：</span></td><td><input type="text" require="true" dataType="Require"   msg="英文名称不能为空" name="enname" value='<ww:property value="enname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">星级：</span></td><td><input type="text" require="true" dataType="Require"   msg="星级不能为空" name="star" value='<ww:property value="star"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">推荐级别：</span></td><td><input type="text" require="true" dataType="Require"   msg="推荐级别不能为空" name="hot" value='<ww:property value="hot"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">装修级别：</span></td><td><input type="text" require="true" dataType="Require"   msg="装修级别不能为空" name="repair" value='<ww:property value="repair"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">国家ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="国家ID不能为空" name="contryid" value='<ww:property value="contryid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">省份ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="省份ID不能为空" name="provinceid" value='<ww:property value="provinceid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">城市ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="城市ID不能为空" name="cityid" value='<ww:property value="cityid"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">行政区ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="行政区ID不能为空" name="regionid1" value='<ww:property value="regionid1"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">商业区ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="商业区ID不能为空" name="regionid2" value='<ww:property value="regionid2"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">酒店地址：</span></td><td><input type="text" require="true" dataType="Require"   msg="酒店地址不能为空" name="address" value='<ww:property value="address"/>'" style="width:350px" /></td>  </tr>
	
				 

			
   
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">酒店描述：</span></td><td><textarea name="description" cols="50" rows="5"><ww:property value="hotel.description"/></textarea> </td>  </tr>
	
			
			
			 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">洒店类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="洒店类型不能为空" name="type" value='<ww:property value="type"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">房间总数：</span></td><td><input type="text" require="true" dataType="Require"   msg="房间总数不能为空" name="rooms" value='<ww:property value="rooms"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">服务设施：</span></td><td><input type="text" require="true" dataType="Require"   msg="服务设施不能为空" name="serviceitem" value='<ww:property value="serviceitem"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">餐饮设施：</span></td><td><input type="text" require="true" dataType="Require"   msg="餐饮设施不能为空" name="footitem" value='<ww:property value="footitem"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">会议设施：</span></td><td><input type="text" require="true" dataType="Require"   msg="会议设施不能为空" name="meetingitem" value='<ww:property value="meetingitem"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">娱乐设施：</span></td><td><input type="text" require="true" dataType="Require"   msg="娱乐设施不能为空" name="playitem" value='<ww:property value="playitem"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">可接受卡类型：</span></td><td><input type="text" require="true" dataType="Require"   msg="可接受卡类型不能为空" name="carttype" value='<ww:property value="carttype"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">装修时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="装修时间不能为空" name="repaildate" value='<ww:property value="repaildate"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">周边酒店：</span></td><td><input type="text" require="true" dataType="Require"   msg="周边酒店不能为空" name="nearhotel" value='<ww:property value="nearhotel"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">邮编：</span></td><td><input type="text" require="true" dataType="Require"   msg="邮编不能为空" name="postcode" value='<ww:property value="postcode"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="state" value='<ww:property value="state"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">全拼：</span></td><td><input type="text" require="true" dataType="Require"   msg="全拼不能为空" name="pyname" value='<ww:property value="pyname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">简拼：</span></td><td><input type="text" require="true" dataType="Require"   msg="简拼不能为空" name="jpname" value='<ww:property value="jpname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">是否主楼：</span></td><td><input type="text" require="true" dataType="Require"   msg="是否主楼不能为空" name="mainfloor" value='<ww:property value="mainfloor"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">主楼高度：</span></td><td><input type="text" require="true" dataType="Require"   msg="主楼高度不能为空" name="mainlevel" value='<ww:property value="mainlevel"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">状态备注：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态备注不能为空" name="statedesc" value='<ww:property value="statedesc"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">酒店卖点：</span></td><td><input type="text" require="true" dataType="Require"   msg="酒店卖点不能为空" name="sellpoint" value='<ww:property value="sellpoint"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">全称：</span></td><td><input type="text" require="true" dataType="Require"   msg="全称不能为空" name="fullname" value='<ww:property value="fullname"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">开户行：</span></td><td><input type="text" require="true" dataType="Require"   msg="开户行不能为空" name="openbank" value='<ww:property value="openbank"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">开户账号：</span></td><td><input type="text" require="true" dataType="Require"   msg="开户账号不能为空" name="bankaccount" value='<ww:property value="bankaccount"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">排序：</span></td><td><input type="text" require="true" dataType="Require"   msg="排序不能为空" name="sort" value='<ww:property value="sort"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">企业ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="企业ID不能为空" name="companyid" value='<ww:property value="companyid"/>'" style="width:350px" /></td>  </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button" value="提交"/> <input type="button" class="button" onclick="window.location.href='hotel.action?<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>


</body>
</html>


