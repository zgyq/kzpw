<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *document.form1.searchCount.value=1;
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
<title>价格维护</title>
<link href="../css/base.css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
</head>

<body>

<form name="form1" method="post" action="hotelprice!priceQuery.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
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
     
           <table width="715" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
   	 <td width="66" height="20" align="left">酒店名称：</td>
                   <td width="314">
                   	<span style="HEIGHT: 71px">
                  		<input id="hotel.name"   style="WIDTH: 150px" name="hotel.name" readonly="readonly" value="<ww:property value="hotel.name"/>"/></span></td>
                  		<input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />
                  		<input type="hidden" id="success" value="<ww:property value="success"/>" />
                <td width="64" height="20" align="left">酒店房型:</td>    
                <td width="271"><span style="HEIGHT: 71px">
                  <!--  <input id="startnum2"   style="WIDTH: 181px" name="s_cmpname" type=""value="<ww:property value="s_cmpname"/>" />-->
                  	<select name="hotelprice.roomid" id="hotelprice.roomid" disabled="disabled" onchange="getlist(this.value);">
                			<ww:iterator value="listRoomtype">
                			   <ww:if test="id == hotelprice.roomid">
                			   		<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
                			   </ww:if>
                			   <ww:else>
                			   		<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
                			   </ww:else>
								
							</ww:iterator>
               		 </select>
                </span></td>
              <tr>
                <td width="66" height="20" align="left">查询时间:</td>
                
                <TD align=left>
                <select name="hotelprice.datenumber" id="hotelprice.datenumber" disabled="disabled">
                	<ww:iterator value="listHotelprice">
                					<ww:if test="datenumber == hotelprice.datenumber">
                						<option value="<ww:property value="datenumber"/>" selected="selected"><ww:property value="datenumber"/></option>
                					</ww:if>
                	
                					
							</ww:iterator>
          		</select>
                </TD>
               
                <td height="20" align="left">&nbsp;</td>
                <!--  <td width="271" rowspan="3">
               
                <div align="left">
                  <input type="button" onclick="confirmStart();" class="button" value="查询"/>
                </div></td> -->
              </table>
		   <p>注意：所有价格均采用人民币（rmb），红色显示的价格为禁用价格！</p>
		   <p>&nbsp;</p></td>
          </tr>
    		<tr>
    			<td>
    			
 	 			<tr>
 	 				<td align="center">
 	 					<table width="439" height="47" align="center">
						<tr>
							  <td width="60" align="center">周日</td>
			            	  <td width="53" align="center">周一</td>
			   				  <td width="53" align="center">周二</td>
			   				  <td width="59" align="center">周三</td>
			   				  <td width="57" align="center">周四</td>
			   				  <td width="58" align="center">周五</td>
			   				  <td width="62" align="center">周六</td>
           			 	</tr>
           			 	<tr>
           			 	<ww:iterator value="showPrices" status="showPricesStatus">
           			 		<ww:if test="#showPricesStatus.index % 7 == 0">
           			 			</tr>
           			 			<tr>
           			 		</ww:if>
           			 		<td><ww:if test="showPrices[#showPricesStatus.index]==null">
           			 			</ww:if>
           			 			<ww:else>
           			 				<ww:if test="islock(getDate())==1">
           			 					<font color="red"><ww:property /></font>
           			 				</ww:if>
           			 				<ww:else>
           			 					<ww:property />
           			 				</ww:else>
           			 			</ww:else>           			 		</td>
           			 	</ww:iterator>
           			 	</tr>
           			 	<tr>           			 	</tr>
            		</table>  
 	 				</td>
 	 			</tr>
 	 			<tr>
 	 				<td></td>
 	 				<td align="center"><ww:property value="roomtype.name"/></td>
 	 				<td align="center"><table>
 	 						<tr>
 	 							<ww:iterator value="">
 	 								<td width="40"><ww:property/></td>
 	 							</ww:iterator>
 	 						</tr>
 	 						<tr>
 	 					
 	 						<ww:iterator value="getPrices(hotelorder.price)" status="">
 	 						
 	 							<ww:if test="#priceStatus.index % 7 == 0">
 	 								</tr>
 	 								<tr>
 	 							</ww:if>
 	 								<td><ww:property /><ww:property value=""/></td>
 	 						</ww:iterator>
 	 						</tr>
 	 					</table>
 	 				</td>
 	 				<td align="center"><strong><font size="15"><ww:property value=""/></font></strong></td>
 	 				<td></td>
 	 			</tr>
 	 		</table>
    			
    			</td>
    		</tr>
		<tr>
			<td align="center"><input type="button" onclick="toback();" class="button_d font-white" value="返回上一级" /></td>
		</tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>

</html>


<script language="JavaScript">
	
	 function toupdateItem(){
			var hotelName = document.getElementById("hotelName").value;
			var roomtype = document.getElementById("roomtype.id").value;
			var hotelid = document.getElementById("roomtype.hotelid").value;
			window.location.href="hotelprice!edit.action?hotelName="+hotelName+" & roomtype.id="+roomtype+" & roomtype.hotelid="+hotelid;
  	}

	function toadd(){
		var hotelName = document.getElementById("hotelName").value;
		var roomtype = document.getElementById("roomtype.id").value;
		var hotelid = document.getElementById("roomtype.hotelid").value;
		window.location.href="hotelprice!toadd.action?hotelName="+hotelName+" & roomtype.id="+roomtype+" & roomtype.hotelid="+hotelid;
	}
	
	function tolock(){
		var hotelName = document.getElementById("hotelName").value;
		var roomtype = document.getElementById("roomtype.id").value;
		var hotelid = document.getElementById("roomtype.hotelid").value;
		window.location.href="hotelprice!tobatchlock.action?hotelName="+hotelName+" & roomtype.id="+roomtype+" & roomtype.hotelid="+hotelid;
	}
	
	function toqiyong(){
		var hotelName = document.getElementById("hotelName").value;
		var roomtype = document.getElementById("roomtype.id").value;
		var hotelid = document.getElementById("roomtype.hotelid").value;
		window.location.href="hotelprice!toqiyong.action?hotelName="+hotelName+" & roomtype.id="+roomtype+" & roomtype.hotelid="+hotelid;
	}
	
	function todefer(){
		var hotelName = document.getElementById("hotelName").value;
		var roomtype = document.getElementById("roomtype.id").value;
		var hotelid = document.getElementById("roomtype.hotelid").value;
		window.location.href="hotelprice!toyanqi.action?hotelName="+hotelName+" & roomtype.id="+roomtype+" & roomtype.hotelid="+hotelid;
	}

	function confirmStart(){
		var date = document.getElementById("hotelprice.datenumber").value;
		if(date==""){
			alert("该房型没有价格!");
			return;
		}
		var hotelid = document.getElementById("hotelprice.hotelid").value;
	    var hotelName = document.getElementById("hotelName").value;
	    var roomid = document.getElementById("hotelprice.roomid").value;
		window.location.href="hotelprice!showtab.action?hotelprice.hotelid="+hotelid+" & hotelName="+hotelName+" & hotelprice.roomid="+roomid+" & hotelprice.datenumber="+date+"&flag=backShow";
	}
	function toback(){
  	var hotelid = document.getElementById("hotelprice.hotelid").value;
  	var hotelName = document.getElementById("hotel.name").value;
  	var id = document.getElementById("hotelprice.roomid").value;
  	window.location.href="hotel!toBack.action?hotelprice.hotelid="+hotelid+"&hotel.name="+hotelName+"&hotelprice.roomid="+id+"&hotelId="+hotelid;
  }
  
  
    function getlist(rid){
  	var hid  = document.getElementById("hotelprice.hotelid").value;
	//alert(document.getElementById("hotelprice.hotelid").value);
  	//alert(hid);
  //	alert(rid);
  	hotelprice.findPriceByHotelidRoomid(hid,rid,setList);
  }
  function setList(data){
  	DWRUtil.removeAllOptions("hotelprice.datenumber");
  	DWRUtil.addOptions("hotelprice.datenumber", data, "datenumber", "datenumber"); 
  }
  
</script>
<script type="text/javascript" src="../js/validator.js"></script>
<script type='text/javascript' src='../dwr/interface/hotelprice.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>