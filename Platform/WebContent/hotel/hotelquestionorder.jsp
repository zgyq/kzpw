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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店订单列表</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/util.js"></script>
<script type="text/javascript" src="../js/validator.js"></script>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="form1" method="post" action="hotelquestionorder.action"  >

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店订单列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
            

           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
           	  <tr>
                <td width="120" height="20" align="right">酒店城市：</td>    <td><span style="HEIGHT: 71px">
                  <select id="h_hotelCityId" name="h_hotelCityId" style="WIDTH: 187px">
                  	<option value="">所有的城市</option>
                  	<ww:iterator value="listCities">
                  		<ww:if test="h_hotelCityId == id">
                  			<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
                  		</ww:if>
                  		<ww:if test="h_hotelCityId != id">
                  			<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
                  		</ww:if>
                  	</ww:iterator>
                  </select>
                </span></td>
                
                <td width="120" height="20" align="right">订单号：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_orderId"   style="WIDTH: 181px" name="h_orderId" value="<ww:property value="h_orderId"/>"/>
                </span></td>
              </tr>
              <tr>
                <td width="120" height="20" align="right">联系人姓名：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_linkname"   style="WIDTH: 181px" name="h_linkname" value="<ww:property value="h_linkname"/>" />
                </span></td>
                
                <td width="120" height="20" align="right">联系人电话：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_linkmobile"   style="WIDTH: 181px" name="h_linkmobile" value="<ww:property value="h_linkmobile"/>" />
                </span></td>
              </tr>
              <tr>
                <td width="120" height="20" align="right">预订开始日期：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_prestarttime"   style="WIDTH: 181px" name="h_prestarttime" value="<ww:property value="h_prestarttime"/>" onfocus="WdatePicker({skin:'whyGreen'})"/>
                </span></td>
                
                <td width="120" height="20" align="right">预订结束日期：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_preendtime"   dataType="Compare" operator="LessThanDate" to="h_prestarttime" msg="离店日期不能小于入住日期"  style="WIDTH: 181px" name="h_preendtime" value="<ww:property value="h_preendtime"/>" onfocus="this.value=getDateDiff($('#h_prestarttime').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'h_prestarttime\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"/>
                </span></td>
              </tr>
              <tr>
                <td width="120" height="20" align="right">酒店名称：</td>    <td ><span style="HEIGHT: 71px">
                  <input id="h_hotelName"   style="WIDTH: 181px" name="h_hotelName" value="<ww:property value="h_hotelName"/>" /><!--
                  &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" <ww:if test="h_isEnglishName == 1">checked="checked"</ww:if>  name="h_isEnglishName" value="1"/>按酒店的英文名称查询
                --></span></td>
                 <td width="120" height="20" align="right">订单类型：</td>  
                <td > <select id="h_ho" name="h_ordertype" >
                		<option value="-1" <ww:if test="h_ordertype==-1">selected</ww:if> >所有</option>
                  		<option value="0" <ww:if test="h_ordertype==0">selected</ww:if> >前台订单</option>
                  		<option value="1" <ww:if test="h_ordertype==1">selected</ww:if> >后台订单</option>
                  		<option value="3" <ww:if test="h_ordertype==3">selected</ww:if> >同行订单</option>
                  	
                  </select>
                  </td> 
                
              </tr>
              <tr>
                <td colspan="4" height="20" align="right">
                <div align="center">
                  <input type="submit" class="button_d font-white" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" class="button_d font-white" value="重置"/>
                </div></td>
              </tr>
              
             </table>
  



		</td>
          </tr>
          <tr>
            <td><table width="99%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" align="center"></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr  >
            <td width="100%"><table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc"  height="25">
                  <th>订单号</th>
                  <th>酒店名称</th>
                  <th>房型名称</th>
                  <th>预订间数</th>
                  <th>入住日期</th>
                  <th>离店日期</th>
                  <th>联系人姓名</th>
                  <th>联系人公司</th>
                  <th>联系人电话</th>
                  <th>订单状态</th>
                  <th>问题</th>
                  <th>订单类型</th>
			  </tr>

		<ww:iterator value="listHotelorder">
	      <tr align="center"  height="20" 
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

           <td><a onclick="hotel_show_info('<ww:property value="id"/>');return false;" href="#"><ww:property value="orderid"/></a></td>
           <td><ww:property value="name"/></td>
           <td><ww:property value="roomtypename"/></td>
           <td><ww:property value="prerooms"/></td>
           <td><ww:property value="formatDate(comedate)"/></td>
           <td><ww:property value="formatDate(leavedate)"/></td>
           <td><ww:property value="linkname"/></td>
           <td><ww:property value="getCompany(memberid).cmpname"/></td>
           <td><ww:property value="linkmobile"/></td>
           <td><ww:property value="getHotelorderState(state)"/></td>
		   <td><ww:if test="resultcode == 1">发送传真错误</ww:if><ww:elseif test="resultcode == 2">接受传真错误</ww:elseif><ww:elseif test="resultcode == 3">通知用户错误</ww:elseif></td>
		   <td><ww:if test="type==0">前台订单</ww:if>
           	<ww:if test="type==1">后台订单</ww:if>
            <ww:if test="type==3">同行订单</ww:if></td>	
	</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="pagination" /> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	
	function hotel_show_info(id) {
		document.forms.form1.action="hotelquestionorder!tocheck.action?id=" + id + "&" + '<ww:property value="url"/>' ;
		document.forms.form1.submit() ;
	}
	

</script>





