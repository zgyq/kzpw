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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//zN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/hotelprice.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店</title>


<style type="text/css">
<!--
.STYLE5 {font-size: 14px}
-->
</style>

</head>
<body>
<form action="hotelprice!addprice.action" method="post" name="form2" id="form2">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"   class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
  </tr>
  <tr>
    <td height="20" valign="bottom">

      <table width="100%" align="center" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td width="8%" height="68px" align="right">酒店名称：</td>
        <input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />
        <input type="hidden" id="success" value="<ww:property value="success"/>" />
      <td width="12%" align="left">
                   	<span style="HEIGHT: 71px">
   		    <input id="startnum2"   style="WIDTH: 150px" name="hotelName" value="<ww:property value="gethotelname(hotelprice.hotelid)"/>"/></span></td>
        <td width="8%" align="right">房型：</td>
        <td width="12%" align="left"><label>
          <select name="hotelprice.roomid" id="hotelprice.roomid" style="width: 150px">
                			<ww:iterator value="listRoomtype">
                				<ww:if test="id==hotelprice.roomid">
                					<option value="<ww:property value="id"/>" selected="selected"><ww:property value="name"/></option>
                				</ww:if>
								<ww:else>
									<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
								</ww:else>
							</ww:iterator>
          </select>
        </label></td>
        <td width="8%" height="68" align="right">开始时间：</td>
		<td width="12%" align="left">
      	 	<span style="HEIGHT: 71px">
    	    <INPUT id="begintime" style="WIDTH: 150px" name="begintime" require="true" dataType="Require" value="<ww:property value="begintime"/>"  msg="洒店开始时间不能为空"  onfocus="WdatePicker({dateFmt:'yyyy-MM',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'})" /></span></td>
        <td width="8%" height="68" align="right" style="padding-left: 1px;">结束时间：</td> 
		<td width="28%" align="left">
         <span style="HEIGHT: 71px">
   		    <INPUT id="endtime" style="WIDTH: 150px" name="endtime" require="true" dataType="Require"  value="<ww:property value="endtime"/>"  msg="洒店结束时间不能为空"  onfocus="WdatePicker({dateFmt:'yyyy-MM',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'})" /></span></td>
  
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="32" valign="bottom">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注意：所有价格均采用人民币（RMB） 输入酒店价格！&nbsp;&nbsp;&nbsp;&nbsp;<strong>门市价:</strong>
    <input type="text" name="hotelprice.deptprice" size="8"  onchange="judge()" onBlur="addValidate1();" id="textfield8"/></td>
  </tr>
  <tr>
    <td height="76" align="center" valign="bottom"><table width="551" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="78" height="26" align="center">周一</td>
        <td width="78" align="center">周二</td>
        <td width="78" align="center">周三</td>
        <td width="79" align="center">周四</td>
        <td width="79" align="center">周五</td>
        <td width="80" align="center">周六</td>
        <td width="79" align="center">周日</td>
      </tr>
      <tr>
        <td height="46" align="center" valign="top"><label>
          <input name="p_day2" type="text" id="textfield1" onBlur="addValidate();" size="10">
        </label></td>
        <td align="center" valign="top"><input name="p_day3" type="text" id="textfield2" onBlur="addValidate();" size="10"></td>
        <td align="center" valign="top"><input name="p_day4" type="text" id="textfield3" onBlur="addValidate();" size="10"></td>
        <td align="center" valign="top"><input name="p_day5" type="text" id="textfield4" onBlur="addValidate();" size="10"></td>
        <td align="center" valign="top"><input name="p_day6" type="text" id="textfield5" onBlur="addValidate();" size="10"></td>
        <td align="center" valign="top"><input name="p_day7" type="text" id="textfield6" onBlur="addValidate();" size="10"></td>
        <td align="center" valign="top"><input name="p_day1" type="text" id="textfield7" onBlur="addValidate();" size="10"></td>
      </tr>
    </table>
      <table width="200" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center" valign="middle">
          <td height="25"><span class="STYLE5"><a href="#" onClick="showOrhidden();">特殊设置</a></span></td>
          <input type="hidden" id="s_userInfo" name="s_userInfo"> 
        </tr>
		<tr class="font-blue-xi" id="userInfo" style="display: none">
				<td>
					<table>
						<tr>
							<td>
								<div align="right">
						            <input type="button" value="删除" class="button_d font-white" onClick="deleterows()">
						            <input type="button" value="增加一行" class="button_d font-white" onClick="addtr()">
	                        	</div>
					            <table id="objTable" border="1" cellpadding="0" cellspacing="0">
			                        <tr>
			                            <td><input type="checkbox" id="selectAll" onClick="selectall(this);"></td>
			                            <td align="center" style="width:150px">开始时间</td>
			                            <td align="center" style="width:150px">结束时间</td>
			                            <td align="center" style="width:150px">特别价格</td>
			                        </tr>
			                        <ww:iterator value="listSpendinfouser">
			                        <tr>
			                            <td><input type="checkbox" onClick="selectTr();" name="deleteBox"></td>			                         
			                            <td><INPUT id="txtOpen" style="WIDTH: 150px" name="u_name" onFocus="nameClick();"></td>
			                            <td><span style="HEIGHT: 71px">
   		    <INPUT id="txtOpen" style="WIDTH: 150px" name="u_mobile" onFocus="nameClick();"></span></td>
			                           <td><span style="HEIGHT: 71px">
   		    <INPUT id="txtOpen" style="WIDTH: 150px" name="u_email"/></span></td>

			                        </tr>
			                        </ww:iterator>
		                        	<tr>
			                            <td><input type="checkbox" onClick="selectTr();" name="deleteBox"></td>
			                            <td><input type="text" name="u_name" onFocus="nameClick();"/></td>
			                            <td><input type="text" name="u_mobile" onFocus="nameClick();"/></td>
			                            <td><input type="text" name="u_email"/></td>
			                        </tr>
					            </table>
						     </td>
						</tr>
					</table>
				</td>
			</tr>
      </table></td>
    </tr>
  <tr>
    <td height="200" align="right" valign="bottom"><table width="333" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="110"><label>
          <textarea name="hotelprice.description" id="hotelprice.description" cols="55" rows="10"></textarea>
        </label></td>
        </tr>
      <tr>
        <td height="30" align="center"><label>
          <input type="button" onClick="addSubmit();" name="button" id="button" class="button_d font-white" value="确认新增">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input type="button" name="button2" id="button2" class="button_d font-white" onClick="toback();" value="返回上一级">
        </label></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="25" valign="bottom">&nbsp;</td>
  </tr>
</table>


</form>
</body>

</html>
<script>

 function judge(){
	var hotelid = <ww:property value="hotelprice.hotelid"/>;
	var roomid = document.getElementById("hotelprice.roomid").value;

	var b_date = document.getElementById("begintime").value;
	var e_date = document.getElementById("endtime").value;
	if(b_date==""){
		alert("请先选择开始时间!");
		document.getElementById("textfield8").value="";
		return;
	}
	if(e_date==""){
		alert("请先选择结束时间!");
		document.getElementById("textfield8").value="";
		return;
	}
	hotelprice.judgeDate(hotelid,roomid,b_date,e_date,warm);
	}
	function warm(data){
		if(data.length>0){
			var price = document.getElementById("textfield8").value;
			var tmp = confirm("以下月份价格已有:\n"+data+"\n是否继续?继续将自动覆盖现有价格。");
			if(tmp){
				document.getElementById("textfield8").value=price;
			}else{
				 document.getElementById("begintime").value="";
				 document.getElementById("endtime").value="";
				 document.getElementById("textfield8").value="";
			}
		}
	}

  String.prototype.trim = function(){return this.replace(/(^\s*)|(\s*$)/g, "");}
  function $(obj){return document.getElementById(obj);}
  
  window.onload = function(){
  		<ww:if test="spendinfo.id>0">
			<ww:if test="spendinfo.right==0">
				$('rigth1').checked = true;
				$('rigth2').checked = false;
				$('userInfo').style.display='none';
			</ww:if>
			<ww:else>
				$('rigth1').checked = false;
				$('rigth2').checked = true;
				$('userInfo').style.display='';
			</ww:else>
		</ww:if>
  }
  function addValidate(){
    	var pattern=/^(\d+(\.\d{2})?)$/; //只能输入数字
  	for(var i=1;i<=8;i++){
  		var val = document.getElementById("textfield"+i).value;
  		if(!pattern.exec(val)){
  		//alert("只能输入数字");
  			document.getElementById("textfield"+i).value="";
  		}
  	}
  }
    function addValidate1(){
  	var pattern=/^(\d+(\.\d{2})?)$/; //只能输入数字

  		var val = document.getElementById("textfield8").value;
  		if(!pattern.exec(val)){
  		alert("门市价只能输入数字");
  			document.getElementById("textfield8").value="";
  		}
  }
  
  //表格中添加一行
  function addtr(){
  	if(!checkEspeciallySet()){
  		return;
  	}
  	if($("objTable").childNodes.length>14){
  		alert("最多指定15个用户");
  		return false;
  	}

  	//创建td节点
   	var td0= document.createElement("td");
   	var td1= document.createElement("td");
   	var td2= document.createElement("td");
   	var td3= document.createElement("td");
   
   //创建控件节点
   var checkBox  = document.createElement("input"); 
   var nameText = document.createElement("input");
   var MobileText     = document.createElement("input");  
   var emailText = document.createElement("input");
   
   //设置checkbox的样式
   checkBox.setAttribute("type","checkbox");
   checkBox.setAttribute("id","deleteBox");
   checkBox.setAttribute("name","deleteBox");
   checkBox.setAttribute("onClick","selectTr()");
   
   nameText.setAttribute("name","u_name");
   nameText.setAttribute("id","u_name");
   nameText.onfocus= nameClick;
   MobileText.setAttribute("name","u_mobile");
   MobileText.setAttribute("id","u_mobile");
   MobileText.onfocus= nameClick;
   emailText.setAttribute("name","u_email");
   emailText.setAttribute("id","u_email");
   // 将控件添加到TD中去
   td0.appendChild(checkBox);
   td1.appendChild(nameText);
   td2.appendChild(MobileText);
   td3.appendChild(emailText);
   
   //创建tr节点,并将TD添加到TR中去
   var trNode = document.createElement("tr");
   trNode.appendChild(td0);
   trNode.appendChild(td1);
   trNode.appendChild(td2);
   trNode.appendChild(td3);
   
   //创建tbody节点，必须使用tbody，不然无法使用dom方式添家行，只能用insertRow
   var trBody = document.createElement("tbody");
   trBody.appendChild(trNode);
   
   //最后将trBody添加到表格中
   $("objTable").appendChild(trBody);
}
  
  //设置checkbox的事件
   function selectTr(event){
   		if(event==null){
 	       event = window.event;
        }
        var eventObj = event.srcElement? event.srcElement : event.target;                           
        var checkBox =  eventObj;
      	var trNode = checkBox.parentNode.parentNode;
      	var textBoxNode1 = checkBox.parentNode.nextSibling.childNodes[0];
      	var textBoxNode2 = checkBox.parentNode.nextSibling.nextSibling.childNodes[0];
      	var textBoxNode3 = checkBox.parentNode.nextSibling.nextSibling.nextSibling.childNodes[0];
      	var checked =checkBox.checked;
      
      	//被选中时的样式
      	if(checked){
        	trNode.style.backgroundColor="#8CC6FF";
            textBoxNode1.style.borderColor="#8CC6FF";
            textBoxNode1.style.backgroundColor="#8CC6FF";
            textBoxNode2.style.borderColor="#8CC6FF";
            textBoxNode2.style.backgroundColor="#8CC6FF";
            textBoxNode3.style.borderColor="#8CC6FF";
            textBoxNode3.style.backgroundColor="#8CC6FF";
        // 取消选择时的样式
        }else{
            trNode.style.backgroundColor="#CCCCCC";
            textBoxNode1.style.backgroundColor="#CCCCCC";
            textBoxNode1.style.borderColor="#CCCCCC";
            textBoxNode2.style.backgroundColor="#CCCCCC";
            textBoxNode2.style.borderColor="#CCCCCC";
            textBoxNode3.style.backgroundColor="#CCCCCC";
            textBoxNode3.style.borderColor="#CCCCCC";
        }
   }
  
  //删除选中的行
  function deleterows(){
	   	var objTable =$("objTable");
	   	var boxList = document.getElementsByName("deleteBox");
	   	var idArray = new Array();
	   	for(i=0;i<boxList.length;i++){
	      if(boxList[i].checked ==true)
	        idArray.push(i);   
	    }
	   var rowIndex;
	   var nextDiff =0;
	   for(j=0;j< idArray.length;j++){
	      rowIndex = idArray[j]+1-nextDiff++
	      objTable.deleteRow(rowIndex);
	    }
  }
  //全选或者全不选
  function selectall(el){      
    var objList = document.getElementsByName("deleteBox");
    for(i=0;i<objList.length;i++){
        var trNode = objList[i].parentNode.parentNode;
        var textBoxNode1 = objList[i].parentNode.nextSibling.childNodes[0];
      	var textBoxNode2 = objList[i].parentNode.nextSibling.nextSibling.childNodes[0];
      	var textBoxNode3 = objList[i].parentNode.nextSibling.nextSibling.nextSibling.childNodes[0];
        objList[i].checked = el.checked; 
      	if(el.checked){
        	trNode.style.backgroundColor="#8CC6FF";
            textBoxNode1.style.borderColor="#8CC6FF";
            textBoxNode1.style.backgroundColor="#8CC6FF";
            textBoxNode2.style.borderColor="#8CC6FF";
            textBoxNode2.style.backgroundColor="#8CC6FF";
            textBoxNode3.style.borderColor="#8CC6FF";
            textBoxNode3.style.backgroundColor="#8CC6FF";
        }else{
            trNode.style.backgroundColor="#CCCCCC";
            textBoxNode1.style.backgroundColor="#CCCCCC";
            textBoxNode1.style.borderColor="#CCCCCC";
            textBoxNode2.style.backgroundColor="#CCCCCC";
            textBoxNode2.style.borderColor="#CCCCCC";
            textBoxNode3.style.backgroundColor="#CCCCCC";
            textBoxNode3.style.borderColor="#CCCCCC";
        }
    }
  }
   
  function showOrhidden(){
 
  	if($('userInfo').style.display == 'none'){
  		 $('userInfo').style.display=''
  	}else {
  		$('userInfo').style.display = 'none'
  	}
  	
  }

  function toback(){
  	var hotelid = document.getElementById("hotelprice.hotelid").value;
  	var hotelName = document.getElementById("hotelName").value;
  	var id = document.getElementById("hotelprice.roomid").value;
  	window.location.href="hotelprice!toBack.action?hotelprice.hotelid="+hotelid+"&hotelName="+hotelName+"&hotelprice.roomid="+id;
  }
   
  function addSubmit(){
  	if(document.getElementById("begintime").value== ""){
  		alert("开始时间不能为空!!");
  		return;
  	}
  	if(document.getElementById("endtime").value== ""){
  		alert("结束时间不能为空!!");
  		return;
  	}
  	if(document.getElementById("textfield8").value== ""){
  		alert("门市价不能为空!!");
  		return;
  	}
  	if(!checkEspeciallySet()){
  		return;
  	}
  	var begintime = document.getElementById("begintime").value;
  	var endtime = document.getElementById("endtime").value;
  	if(parseInt(begintime.split("-")[0])>parseInt(endtime.split("-")[0])){
  		alert("结束年份必须大于开始年份!!");
  		return;
  	}else if(parseInt(begintime.split("-")[0])==parseInt(endtime.split("-")[0])){
  		var startMm = -1;
  		var endMm =-1;
  		if(begintime.split("-")[1].indexOf("0")==0){
  			startMm=parseInt(begintime.split("-")[1].substring(1));
  		}else{
  			startMm=parseInt(begintime.split("-")[1]);
  		}
  		if(endtime.split("-")[1].indexOf("0")==0){
  			endMm=parseInt(endtime.split("-")[1].substring(1));
  		}else{
  			endMm=parseInt(endtime.split("-")[1]);
  		}
  		if(startMm != -1 && endMm != -1){
  			if(endMm<startMm){
  				alert("结束时间选择错误!");
  				return;
  			}
  		}
  	}
  	document.form2.action="hotelprice!addprice.action";
  	document.form2.submit();
  }
  function nameClick(){
  	new WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d'});
  }
  function checkEspeciallySet(){
	  	var nameList = document.getElementsByName("u_name");
	  	var mobileList = document.getElementsByName("u_mobile");
	  	var emailList = document.getElementsByName("u_email");
	  	var pattern=/^[1-9]+0*$/; //只能输入数字
	  	
  		for(var i=0;i<nameList.length;i++){
	  	//	if(nameList[i].value=="" || mobileList[i].value==""){
	  	//		alert("开始或结束时间不能为空。");
	  	//		return false;
	  	//	}
	  	//	if(parseInt(nameList[i].value.split("-")[0])>parseInt(mobileList[i].value.split("-")[0])){
	  	//		alert("结束年份必须大于开始年份!!");
	  	//		return false;
	  	//	}else
	  	 if(parseInt(nameList[i].value.split("-")[0])==parseInt(mobileList[i].value.split("-")[0])){
	  			var startMm = -1;
	  			var endMm =-1;
	  			if(nameList[i].value.split("-")[1].indexOf("0")==0){
	  				startMm=parseInt(nameList[i].value.split("-")[1].substring(1));
	  			}else{
	  				startMm=parseInt(nameList[i].value.split("-")[1]);
	  			}
	  			if(mobileList[i].value.split("-")[1].indexOf("0")==0){
	  				endMm=parseInt(mobileList[i].value.split("-")[1].substring(1));
	  			}else{
	  				endMm=parseInt(mobileList[i].value.split("-")[1]);
	  			}
	  			if(startMm != -1 && endMm != -1){
	  				if(endMm<startMm){
	  					alert("结束时间选择错误!");
	  					return false;
	  				}
	  			}
	  			if(startMm==endMm){
	  				var startday=-1;
	  				var endday=-1;
	  				if(nameList[i].value.split("-")[2].indexOf("0")==0){
	  					startday=parseInt(nameList[i].value.split("-")[2].substring(1));
	  				}else{
	  					startday=parseInt(nameList[i].value.split("-")[2]);
	  				}
	  				if(mobileList[i].value.split("-")[2].indexOf("0")==0){
	  					endday=parseInt(mobileList[i].value.split("-")[2].substring(1));
	  				}else{
	  					endday=parseInt(mobileList[i].value.split("-")[2]);
	  				}
	  				//if(startday != -1 && endday != -1){
	  				//	if(startday>endday){
	  				//		alert("结束天数必须大于开始天数。");
	  				//		return false;
	  				//	}
	  				//}
	  			}
  			}
  		}
  		for(var j=0;j<emailList.length;j++){
	  		var price=emailList[j].value;
	  	//	if(!pattern.exec(price)){
	  	//		alert("请输入别特价格。");
	  	//		emailList[j].value="";
	  	//		return false;
	  	//	}
	  	}
  		return true;
  }
</script>
