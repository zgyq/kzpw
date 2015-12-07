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
<title>酒店价格修改</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />

<body>
<form action="hotelprice!update.action" method="post">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
  </tr>
  <tr>
  	<td height="126">
<table width="100%" height="138" border="0" align="center">
<tr>
            	<td height="30" align="right">酒店名称*</td>
   	    <input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />
            	<input type="hidden" id="hotelprice.id" name="hotelprice.id" value="<ww:property value="hotelprice.id"/>" />
            	<input type="hidden" id="hotelprice.isvalid" name="hotelprice.isvalid" value="<ww:property value="hotelprice.isvalid"/>" />
            	<input type="hidden" id="hotelprice.deptprice" name="hotelprice.deptprice" value="<ww:property value="hotelprice.deptprice"/>" />
            	<input type="hidden" id="hotelprice.description" name="hotelprice.description" value="<ww:property value="hotelprice.description"/>" />
              <td><input type="text" readonly id="hotelName" name="hotelName" value="<ww:property value="gethotelname(hotelprice.hotelid)"/>" size="12" /></td>
          </tr>
            <tr>
            	<td height="25" align="right">房型*</td>
<td>
						<select name="hotelprice.roomid" id="hotelprice.roomid" onchange="getlist(this.value);">
                			<ww:iterator value="listRoomtype">
                				<ww:if test="id == hotelprice.roomid">
                					<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
                				</ww:if>
								<ww:else>
									<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
								</ww:else>
							</ww:iterator>
          		 </select></td>
            </tr>
            <tr>
            	<td height="31" align="right">年月*</td>
<td>  <select name="hotelprice.datenumber" id="hotelprice.datenumber">
                			<ww:iterator value="listHotelprice">
                					<ww:if test="datenumber == hotelprice.datenumber">
                						<option value="<ww:property value="datenumber"/>" selected="selected"><ww:property value="datenumber"/></option>
                					</ww:if>
                					<ww:else>
                						<option value="<ww:property value="datenumber"/>"><ww:property value="datenumber"/></option>
                					</ww:else>
                					
							</ww:iterator>
          		 </select>
               	<input type="button" value="查询" class="button_d font-white" onclick="toQuery()"></td>
               	 	
           
            </tr>
            <tr>
            	<td height="14" align="center">&nbsp;</td>
              <td>&nbsp;              </td>
            </tr>
            <tr>
           	  <td height="26" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注意：所有价格均采用人民币（RMB）,修改价格请直接点击要修改价格的星期！</td>
            
          </tr>
          
      </table>  
  	<ww:if test="showPrices.length>0">    
  门市价:	 	<input type="text" name="hotelpr" value="<ww:property value="hotelprice.deptprice"/>" />
  </ww:if>
       </td>
  </tr>
  
  <tr>
  	<td height="64" align="center">
    	<table width="445" align="center" cellspacing="0">
<tr>
            	<td width="437">
            	
            		<div style="display:none" id="showPrice"><table width="439" height="47" align="left">
            			<ww:if test="showPrices.length>0">
            				<script language="javascript">
            					document.getElementById("showPrice").style.display='';
            				</script>
            			</ww:if>
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
           			 					<INPUT type="text" size="8" name="hotelprice.no<ww:property value="getNo()"/>" value="<ww:property />" style="color:red" readonly="readonly"/>
           			 				</ww:if>
           			 				<ww:else>
           			 					<INPUT type="text" size="8" name="hotelprice.no<ww:property value="getNo()"/>" value="<ww:property />"/>
           			 				</ww:else>
           			 			</ww:else>           			 		</td>
           			 	</ww:iterator>
           			 	</tr>
           			 	<tr>           			 	</tr>
            		</table></div>       	    </td>
          </tr>
        </table>    </td>
  </tr>
  <tr>
    <td height="64" align="center"><label>
      <input type="submit" name="button" id="button" class="button_d font-white" value="确认修改">&nbsp;&nbsp;&nbsp;
      <input type="button" name="button" onClick="toback();" id="button1" class="button_d font-white" value="返回上一级">
    </label></td>
  </tr>
</table>


</form>
</body>

</html>

<script language="JavaScript">
	function toQuery(){
	
	    var hotelid = document.getElementById("hotelprice.hotelid").value;
	  
	    var hotelName = document.getElementById("hotelName").value;
	   
	    var roomid = document.getElementById("hotelprice.roomid").value;
	    
	    var datenumber = document.getElementById("hotelprice.datenumber").value;
	  
	    
	    if(datenumber==""){
	    	alert("查询的房型没有价格!");
	    	return;
	    }
	    window.location.href="hotelprice!updatetab.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+roomid+"&hotelprice.datenumber="+datenumber+"&flag=toedit";
	}
	
  	function toback(){
  	var hotelid = document.getElementById("hotelprice.hotelid").value;
  	var hotelName = document.getElementById("hotelName").value;
  	var id = document.getElementById("hotelprice.roomid").value;
  	window.location.href="hotelprice!toBack.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+id;
  }
  
  function getlist(rid){
  	var hid  = document.getElementById("hotelprice.hotelid").value;
	//alert(document.getElementById("hotelprice.hotelid").value);
  	//alert(hid);
  //	alert(rid);
 
  	hotelprice.findPriceByHotelidRoomid(hid,rid,setList);
  	
  }
  function setList(data){
 // alert(data);
  DWRUtil.removeAllOptions("hotelprice.datenumber");
  DWRUtil.addOptions("hotelprice.datenumber", data, "datenumber", "datenumber"); 
  
  }
  
</script>
<script type="text/javascript" src="../js/validator.js"></script>
<script type='text/javascript' src='../dwr/interface/hotelprice.js'></script>
  <script type='text/javascript' src='../dwr/engine.js'></script>

 <script type='text/javascript' src='../dwr/util.js'></script>