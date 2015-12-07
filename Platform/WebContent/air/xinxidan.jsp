<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>票据打印信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
body,td{font-size: 15px;color: #000000;}
body{margin-left: -50px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;}
.input2{
	background-color: #FFFFFF;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 0px;
	border-top-style: none;
	border-right-style: inset;
	border-bottom-style: inset;
	border-left-style: none;
	border-top-color: #FFFFFF;
	border-right-color: #FFFFFF;
	border-bottom-color: #FFFFFF;
	border-left-color: #FFFFFF;
	font-size: 15px;
}
.Noprint{display:none;} 
</style>



</head>

<body>
<!--startprint-->		
	<table width="1105">
	  <tr>
		<td width="1105" height="29">
			<table>
			  <tr>
			  <td width="92" height="21" align="left"></td>
				<td width="112" height="21" align="left"><input name="PersonName" type="text"  size="14" maxlength="14" class="input2"  value=" <ww:property value="passenger.name" />"></td>
				<td width="190" align="center"><input name="IdCard" type="text" size="20" maxlength="20" class="input2" value="<ww:property value="passenger.idnumber" />" ></td>
				<td width="268"><input name="Company1" type="text" size="30" maxlength="30" class="input2" value="不得签转,变更退票收费" ></td>
			  </tr>
		  </table>	
		</td>
	  </tr>
	  <tr>
		<td>
			<table align="left">
			  <tr>
			  <td width="93" height="21" align="left"></td>
				<td width="211" height="20" align="left"><input name="PNR" type="text" size="10" maxlength="10" class="input2" value="<ww:property value="orderinfo.pnr" />" ></td>
				<td width="323" colspan="10"></td>
			  </tr>
		  </table>
		</td>
	  </tr>
	  <tr>
		<td height="131">
			<table width="979" align="left">
			
			  <tr>
			 	<td width="62" height="37" align="left">&nbsp;</td>
				<td width="115" height="37" align="left"><input name="City1" size="10" maxlength="12" type="text" class="input2" value="<ww:property value="getAirnamebySZM(segmentinfo.startairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.startairport" />" >  </td>
				<td width="31" align="center" valign="middle">
            	<input name="Company1" type="text"  size="4" maxlength="4" class="input2" value="<ww:property value="getAircomapnycodeByEZM(segmentinfo.aircomapnycode)" />" /></td>
				<td width="34" align="center"><input name="hbno1" type="text" size="4" maxlength="6" class="input2"  value=" <ww:property value="segmentinfo.flightnumber" />" /></td>
				<td width="17" align="center">
           		 <input name="CWCode1" type="text" size="1" maxlength="1" class="input2" value="<ww:property value="segmentinfo.cabincode" />" /></td>
				<td width="40" align="center">
           		 <input name="FromDate" type="text" size="8" maxlength="5" class="input2" value="<ww:property value="formatDate(segmentinfo.departtime)" />" /></td>
				<td width="32" align="center">
            	<input name="FromTime" type="text"   size="4" maxlength="4" class="input2" value="<ww:property value="formatTimestamp3(segmentinfo.departtime)" />" /></td>
				<td colspan="2" align="center"><input name="CWCode1" type="text"   size="6" maxlength="6" class="input2" value="<ww:property value="segmentinfo.cabincode" />"></td>
				<td width="36" align="center"></td>
				<td width="31" align="center"></td>
				<td width="58" align="left"><input name="KG" type="text"  size="5" class="input2" value="20KG" /></td>
			  </tr>
			  
			   <!--
			   <tr >
			 	<td colspan="11"><input name="KG" type="text" style="width: 100%"  class="input2" value="20KG" /></td>
			  </tr>
			  -->
			  <tr>
			  <td width="52" height="21" align="left"></td>
				<td height="21" align="left">
				<input name="City2" type="text" size="10" maxlength="12" class="input2" value="<ww:property value="getAirnamebySZM(segmentinfo.endairport)" />&nbsp;&nbsp;<ww:property value="segmentinfo.endairport" />" > </td>
				<td align="center">&nbsp;</td>
				<td align="center">&nbsp;</td>
				<td align="center">&nbsp;</td>
				<td align="center"><input name="KG" type="text"  size="5" class="input2" value="" /></td>
				<td align="center"></td>
				<td colspan="2" align="center">&nbsp;</td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="right"></td>
			  </tr>
			  <tr>
			  <td width="52" height="21" align="left"></td>
				<td height="20" align="left"></td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td colspan="2" align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="left"></td>
			  </tr>
			  <tr>
			  <td width="52" height="21" align="left"></td>
				<td height="20" align="left"></td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td colspan="2" align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="left"></td>
			  </tr>
			  <tr>
			  <td width="52" height="18" align="left"></td>
				<td height="18" align="left">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td width="160" align="center"></td>
				<td width="81" align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="left"></td>
			  </tr>
			   <tr>
			  <td width="52" height="22" align="left"></td>
				<td height="18" align="left">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td align="center">				</td>
				<td width="160" align="center"></td>
				<td width="81" align="center"></td>
				<td align="center"></td>
				<td align="center"></td>
				<td align="left"></td>
			  </tr>
			  <tr>
			  <td width="52" height="37" align="left"></td>
				<td height="37" align="left"></td>
				<td colspan="2" align="center" valign="middle">
				<ww:if test="passenger.ptype==1">
				<input name="fare1" type="text" size="11" maxlength="11" class="input2" value="CNY <ww:property value="segmentinfo.parvalue" />" />
				</ww:if><ww:else>
				<input name="fare1" type="text" size="11" maxlength="11" class="input2" value="CNY <ww:property value="passenger.price" />" />
				</ww:else>
                </td>
				<td colspan="2" align="center" valign="middle">
                <input name="fare2" type="text" size="7" maxlength="7" class="input2" value="CN <ww:property value="passenger.airportfee" />" ></td>
				<td colspan="2" align="center" valign="middle">
                <input name="fare32" type="text"  size="7" maxlength="7" class="input2" value="YQ <ww:property value="passenger.fuelprice" />"></td>
				<td align="center"><input name="fare32" type="text"  size="7" maxlength="7" class="input2" value=""></td><!-- 其他 -->
				<td colspan="3" align="left" valign="middle">
				
			  <input name="fare3" type="text" size="11" maxlength="11" class="input2" value="CNY <ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+segmentinfo.parvalue+converNull(passenger.insurprice,0))" />" >
				
			    
			    
			    </td>
			  </tr>
		  </table>
		</td>
	  </tr>
	  <tr>
	  
		<td>
			<table width="979" align="left">
			  <tr>
			  
			  	<td width="16" height="20" align="left">&nbsp;</td>
				<td width="183" height="20" align="right"><input name="PiaoHao" type="text"  size="20" maxlength="20" class="input2" value="<ww:property value="passenger.ticketnum" />"></td>
				<td width="112"  align="center"><input name="YZM" type="text" size="12" maxlength="12" class="input2" value="<ww:property value="username.substring(username.length()-4, username.length())" />" ></td>
				<td width="269" align="center"></td>
				<td width="135" align="left"><div align="right">
				<ww:if test="passenger.insurprice!=null&&passenger.insurprice>0">
				<input name="BaoXian" type="text" class="input2" size="6" maxlength="6"  value="<ww:property value="passenger.insurprice" />">
				</ww:if><ww:else>
				<input name="BaoXian" type="text" class="input2" size="6" maxlength="6"  value="">
				
				</ww:else>
			    </div></td>
			  </tr>
			  <tr>
			  <td width="36" height="19" align="left"></td>
				<td height="19" align="center">URC220</td>
				<td colspan="2" rowspan="2" align="center"><input name="hbno2" type="text"  size="30" class="input2" value="北京华展宏图航空服务有限公司"></td>
				<td rowspan="2" align="left"><div align="right"><input name="Date" type="text"  size="12" maxlength="12" class="input2" value=" <ww:property value=" startDate" />"></div></td>
			  </tr>
			  <tr>
			  <td width="36" height="19" align="left"></td>
			    <td height="19" align="center">400-648-6998</td>
		      </tr>
		  </table>
		</td>
	  </tr>
</table>
<!--endprint-->
	<div align="center">
      <!--<input type="submit" name="Submit" value="打印" onClick="print();" class="noprint">-->
	  <input type="submit" name="Submit" value="打印" onClick="HentPrint('<ww:property value="pid" />','<ww:property value="username" />');" class="noprint">
	</div>
<script src="js/jquery1.3.2.js"></script>
<script language="javascript">

function HentPrint(pid,username)
{ 

 //isvalue(pid,username);
bdhtml=window.document.body.innerHTML; 
sprnstr="<!--startprint-->"; 
eprnstr="<!--endprint-->"; 
prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
window.document.body.innerHTML=prnhtml; /* 可以prnhtml前加上 <style><!-- p{font-size:12px;} --></style> */
window.print(); 
}


function isvalue(pid,username){

	$.ajax({
	   url:"passenger!ajaxgetpassenger.action",
	   type:"POST",
	   async:false,
	   data:{passid:pid,username:username},
	   success:function (data){
	      
	  }	
  });

}

</script>

</body>
</html>
