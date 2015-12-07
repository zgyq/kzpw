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
<title>批量锁定酒店价格</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form action="hotelprice!unlock.action" name="form1" method="post">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
  </tr>
  <tr>
  	<td>
    	<p>&nbsp;</p>
    	<table align="center">
   	  <tr>
            	<td>酒店名称:</td>
            	<input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />
            	<input type="hidden" id="success" value="<ww:property value="success"/>" />
                <td><input type="text" id="hotelName" readonly  name="hotelName" value="<ww:property value="gethotelname(hotelprice.hotelid)"/>"/></td>
            </tr>
            <tr>
            	<td>房型:</td>
                <td>
                	<select name="hotelprice.roomid" id="hotelprice.roomid">
                			<ww:iterator value="listRoomtype">
                				<ww:if test="id == hotelprice.roomid">
                					<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
                				</ww:if>
								<ww:else>
									<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
								</ww:else>
							</ww:iterator>
          			</select>
                </td>
            </tr>
            <tr>
            	<td>起始时间:</td>
                <td><INPUT id="b_time" style="WIDTH: 150px" name="b_time" require="true" dataType="Require"   msg="洒店查询时间不能为空"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'})"></td>
            </tr>
            <tr>
            	<td>结束时间:</td>
                <td><INPUT id="e_time" style="WIDTH: 150px" name="e_time" require="true" dataType="Require"   msg="洒店查询时间不能为空"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'})" ></td>
            </tr>
            <tr>
            	<td colspan="2">
                	
               	  <div align="center">
               	    <input type="button" onclick="confirmUnlock();" class="button_d font-white" value="批量启用价格">
               	    <input type="button" onclick="toback();"  class="button_d font-white" value="返回上一级">
       	          </div></td>
          </tr>
        </table>
    </td>
  </tr>
 </table>
</form>
</body>
</html>
<script language="JavaScript">
	function confirmUnlock()
	{
		var be_time = document.getElementById("b_time").value;
 		var en_time = document.getElementById("e_time").value;
 		
 		var startmm = -1;
	 	var endmm = -1;
	 	if(be_time==""){
	 		alert("开始时间不能为空!");
	 		return;
	 	}
	 	if(en_time==""){
	 		alert("结束时间不能为空!");
	 		return;
	 	}
	 	if(be_time.split("-")[0] > en_time.split("-")[0]){
	 		alert("结束年份必须大于开始时间!");
	 		return;
	 	}else if(be_time.split("-")[0] == en_time.split("-")[0]){
	 		
	 		if(be_time.split("-")[1].indexOf("0")==0){
	 			startmm = parseInt(be_time.split("-")[1].substring(1));
	 		}else{
	 			startmm = parseInt(be_time.split("-")[1]);
	 		}
	 		if(en_time.split("-")[1].indexOf("0")==0){
	 			endmm = parseInt(en_time.split("-")[1].substring(1));
	 		}else{
	 			endmm = parseInt(en_time.split("-")[1]);
	 		}
	 		if(startmm>endmm){
	 			alert("结束月份必须大于开始时间!");
	 			return;
	 		}
	 		if(startmm==endmm){
	 			var startday = -1;
	 			var endday = -1;
	 			if(be_time.split("-")[2].indexOf("0")==0){
	 				startday = parseInt(be_time.split("-")[2].substring(1));
	 			}else{
	 				startday = parseInt(be_time.split("-")[2]);
	 			}
	 			if(en_time.split("-")[2].indexOf("0")==0){
	 				endday = parseInt(en_time.split("-")[2].substring(1));
	 			}else{
	 				endday = parseInt(en_time.split("-")[2]);
	 			}
	 			if(startday>endday){
	 				alert("结束天必须大于开始天!");
	 				return;
	 			}
	 		}
	 	}
	 	var hotelid = document.getElementById("hotelprice.hotelid").value;
	 	var roomid = document.getElementById("hotelprice.roomid").value;
	 	var hotelName = document.getElementById("hotelName").value;
	 	hotelprice.priceinureValidate(hotelid,roomid,be_time,en_time,validate);
	 	
	 	//document.form1.submit();
	}
	function validate(str){
		if(str.length>0){
			if(str=="指定的时间没有价格,请重新选择。"){
				alert(str);
				return;
			}else{
				if(confirm("以下时间的价格不存在,\n"+str+"是否继续?继续将自动跳过不存在的价格。")){
				}else{
					return;
				}
			}
		}
		var beg_time = document.getElementById("b_time").value;
 		var end_time = document.getElementById("e_time").value;
	 	var hotelid = document.getElementById("hotelprice.hotelid").value;
	 	var roomid = document.getElementById("hotelprice.roomid").value;
	 	var hotelName = document.getElementById("hotelName").value;
		window.location.href="hotelprice!unlock.action?begintime="+beg_time+"&endtime="+end_time+"&hotelprice.hotelid="+hotelid+"&hotelprice.roomid="+roomid+"&hotelName="+hotelName;
	}
  function toback(){
  	var hotelid = document.getElementById("hotelprice.hotelid").value;
  	var hotelName = document.getElementById("hotelName").value;
  	var id = document.getElementById("hotelprice.roomid").value;
  	window.location.href="hotelprice!toBack.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+id;
  }
</script>
<script type='text/javascript' src='../dwr/interface/hotelprice.js'></script>
  <script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
  