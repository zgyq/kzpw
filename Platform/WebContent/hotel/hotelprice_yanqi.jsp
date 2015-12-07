<%@ page contentType="text/html; charset=UTF-8"%>
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
<title>酒店价格列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>
<form name="form1" method="post" action="hotelprice!defer.action">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
  </tr>

     <tr>
     <td height="27" align="center"><div align="right">
     </div></td>
   </tr>

  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
       <tr>
            <td><table>
              <tr>
                <td width="60" >酒店名称*</td>
                <td width="118"><input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />
                <input type="text" id="hotelName" readonly  name="hotelName" value="<ww:property value="gethotelname(hotelprice.hotelid)"/>"/></td>
                <td width="36" >房型*</td>
                <td width="66">
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
                <td width="58" height="20" align="right"> 延期至：</td>
                <td width="68"><input type="text" id="defer_date" name="defer_date" require="true" datatype="Require"   msg="延期日期不能为空"  onfocus="WdatePicker({dateFmt:'yyyy-MM',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'})"/></td>
                <td width="230"><input name="button2" type="button" onclick="checkAndsubmit()" class="button_d font-white" value="延期"/>&nbsp;<input name="button2" type="button" class="button_d font-white" onclick="toback();" value="返回上一级"/></td>
              </tr>
              
            </table>
              </td>
          </tr>
          <tr>
            <td><table width="99%" border="0" cellspacing="0" cellpadding="0">
            
              <tr>
                <td height="5" align="center">
                  <div align="left"></div></td></tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
			<ww:iterator value="listHotel">
			<tr>
			<td height="23"><a href="hotelprice!todetails.action?hotel.id=<ww:property value='id' />">
			  <ww:property value="name"/></a></td>
			<td><ww:property value="star"/> </td>
			</tr>
	</ww:iterator>
			</tbody>
			
</table>
</body>
</html>


<script language="JavaScript">
	
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="hotelprice!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         

					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="hotelprice!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="hotelprice!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotelprice!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="hotelprice!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="hotelprice!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="hotelprice!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
 
			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}

  function toback(){
  	var hotelid = document.getElementById("hotelprice.hotelid").value;
  	var hotelName = document.getElementById("hotelName").value;
  	var id = document.getElementById("hotelprice.roomid").value;
  	window.location.href="hotelprice!toBack.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+id;
  }

function checkAndsubmit(){
	 var end_time = document.getElementById("defer_date").value;
	 if(end_time == ""){
	 	alert("请选择延期时间!!");
	 	return;
	 }
	 var hotelid = document.getElementById("hotelprice.hotelid").value;
	 var roomid = document.getElementById("hotelprice.roomid").value;
	 hotelprice.deferValidate(hotelid,roomid,end_time,validate); 
}
function validate(str){
	var hotelid = document.getElementById("hotelprice.hotelid").value;
	var roomid = document.getElementById("hotelprice.roomid").value;
	var endtimes = document.getElementById("defer_date").value;
	var hotelName = document.getElementById("hotelName").value;
	if(str.length>0){
		alert(str);
		return;
	}
	document.location.href="hotelprice!defer.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+roomid+"&endtime="+endtimes;
}
</script>
<script type='text/javascript' src='../dwr/interface/hotelprice.js'></script>
  <script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
  