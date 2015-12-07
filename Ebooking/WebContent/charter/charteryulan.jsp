<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国内机票查询列表</title>

<link href="skin/blue/css/charter.css" rel="stylesheet" type="text/css" />


<ww:head name="index" jsURL="citycontrol" />
<script type="text/javascript">


</script>
</head>

<body>
<div id="container">
  <div class="center"><ww:include page="../top.jsp?type=baoji"/></div>
 <!--includ top 直接替换掉整个DIV-->
</div>  

<!--top over-->
<div id="main">
<form action="index!addCharter.jspx" id="form1" name="form1" method="post">
  <div id="left" class="f box">
     <div class=" title"> <font class="black low f mr15">包机/团队票申请</font></div>
       <div class="nohave"></div>
     <div class="information">
     <table width="100%" border="1" cellspacing="0" cellpadding="0" >
          <tr>
          <td class="hadow" align="right" width="90">航班类型：</td>
          <td colspan="3">
          <ww:if test="charterorder.type==1"></ww:if>单程<ww:else>往返</ww:else>
          
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">旅客类型：</td>
          <td colspan="3">
           <ww:if test="charterorder.usertype==1"></ww:if>内宾<ww:else>外宾</ww:else>
         
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">出发城市：</td>
          <td width="255">
         <ww:property value="segmentinfo.startairport"/>
       
          </td>
          <td class="hadow" align="right" width="90">达到城市：</td>
          <td><ww:property value="segmentinfo.endairport"/>
         
          </td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">出发时间：</td>
          <td><ww:property value="segmentinfo.departtime"/></td>
          <td class="hadow" align="right" width="90" id="retun1" style="display: none">返程时间：</td>
          <td id="retun2" style="display: none"><ww:property value="segmentinfo2.endairport"/></td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">航空公司：</td>
          <td><ww:property value="segmentinfo.aircompanyname"/></td>
          <td class="hadow" align="right" width="90">航班号：</td>
          <td><ww:property value="segmentinfo.flightnumber"/></td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">时间范围：</td>
          <td><ww:property value="charterorder.stime"/>&nbsp;至&nbsp;<ww:property value="charterorder.etime"/></td>
          <td class="hadow" align="right" width="90">&nbsp;</td>
          <td>&nbsp;</td>
          </tr>
          <tr>
          <td colspan="4" class="f00">注："航班号"，"范围时间"不填默认为不限，航班号输入不加航空公司二字码，如 HU1234 只输入1234 </td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">乘机人数：</td>
          <td><ww:property value="charterorder.maxnum"/><font class="f00">人数限制为1-50人</font> </td>
          <td class="hadow" align="right" width="90">乘机人类型：</td>
          <td>  <ww:if test="charterorder.usertype==1"></ww:if>成人<ww:else>儿童</ww:else></td>
          </tr>
      </table>
      <div class="nohave"></div>
       <table width="100%" border="0" cellspacing="0" cellpadding="0" id="tbrecord">
        <tr id="hidid_1">
			<td class="hadow" align="right" width="90"><font class="fontxing">*</font> 姓  名：</td>
            <td width="100"><input type="text" class="text_name" value="" name='idname' /></td>
            <td class="hadow" align="right" width="90"><font class="fontxing">*</font> 证件类型：</td>
            <td width="90"><select class="sel_documents" name='idtype'>
            
             <option value="1" id="type_1_1">身份证</option>
			 <option value="3" id="type_1_3">护照</option>
		     <option value="4" id="type_1_4">港澳通行证</option>
			 <option value="5" id="type_1_5">台湾通行证</option>
		  	 <option value="6" id="type_1_6">台胞证</option>
			 <option value="7" id="type_1_7">回乡证</option>
            </select></td>
            <td width="160"><input type="text" class="text_number" name='idnumber'  /></td>
            <td class="hadow" ><a href="javascript:addpass();" class="fontun06c mlr15">增加乘客</a></td>
         </tr>
         		<input type="hidden" id="c_idname" name="c_idname" value="" />
           		<input type="hidden" id="c_idtype" name="c_idtype" value="" />
				<input type="hidden" id="c_idnumber" name="c_idnumber" value="" />
				
				
				
         <!--
         <tr>
			<td class="hadow" align="right" ><font class="fontxing">*</font> 姓  名：</td>
            <td><input type="text" class="text_name" value="" /></td>
            <td class="hadow" align="right"><font class="fontxing">*</font> 证件类型：</td>
            <td ><select class="sel_documents"><option>身份证</option><option>护照</option><option>港澳通行证</option></select></td>
            <td ><input type="text" class="text_number"  /></td>
            <td class="hadow" ><a href="#" class="fontun06c mlr15">增加乘客</a><a href="#" class="fontun06c">删除乘客</a></td>
         </tr>
         
       -->
       </table>
        <div class="nohave"></div>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
       	<td class="hadow" align="right" width="90"><font class="fontxing">*</font>申请人姓名：</td>
        <td><input type="text"  class="text_number" name="s_username"  /></td>
        <td class="hadow" align="right" width="90" ><font class="fontxing">*</font>申请人电话：</td>
        <td><input type="text"  class="text_number" name="s_tel"  /></td>
        <td class="hadow" align="right" width="90"><font class="fontxing">*</font>申请人QQ：</td>
        <td><input type="text"  class="text_number"  name="s_qq"  /></td>
       </tr>
       <tr>
         <td class="hadow" align="right" width="90" valign="top">备注：</td>
         <td colspan="5"><textarea name="s_remarks" cols="62" rows="2" class="m15 box_ccc"></textarea></td>
       </tr>  
       </table>
     </div>
     <div class="nohave"></div>
     <div class="bnt">
     <input type="button" id="yulan" class="bnt_booking fff mr25"  value="预览" onclick="yul();"  />
     <input type="button" id="syb" style="display: none;" class="bnt_booking fff"  value="上一步"  /> 
     <input type="button" style="display: none;" id="sub" class="bnt_booking fff mr25"  value="提交"  onclick="sub();"  />
     <input type="reset" id="cz" class="bnt_booking fff"  value="重置"  /> </div>
  </div>
  </form>
  <!--left over-->
  <div id="charter" class="r">
      <div class="search"><font class="black">包机服务</font></div>
      <div class="box_sea searchlist">
        <ul>
          <li><a href="index!toplanserver.jspx" class="ff7f05">包机/团队票申请</a></li>
          <li><a href="login!tocharterlist.jspx">申请单管理</a></li>
        </ul>
      </div>
      <div class="searchbot"></div>
      <div class="ad mt7"><img src="images/ad_sea.jpg" width="260" height="100" /></div>
      <div class="mt7 box">
        <div class=" title"> <font class="black low f mr15">包机服务</font></div>
        <div class="charterlist">
          <ul>
          <li><font class="dd2626">飞行范围：</font>提供全球各大城市点对点航程，多点往返航程。 </li>
          <li><font class="dd2626">24小时飞行：</font>每天24小时、每周7天为您的出行提供安全、舒适和私...</li>
          <li><font class="dd2626">运力保障：</font>在全球各地有长期合作伙伴，丰富的公务飞机资源，能... </li>
          <li><font class="dd2626">安全保证：</font>无论自有运力亦或其它出租运力，无论是大的步骤还是细小...</li>
          <li><font class="dd2626">专业服务团队：</font>我们致力于提供优质、完善和个性化的高端公务航空服... </li>
          </ul> 
          </div>
      </div>
  </div>
  <!--right over-->
</div> 
<!--container over-->
<ww:include page="../footer.jsp"/> 
</body>
</html>
<script type="text/javascript">
var idnumber=1;

function addpass(id){

//if(valuedate()=='0'){

//return;
//}


var maxnum=document.getElementById("maxnum").value;

if(parseInt(idnumber)>=50){
alert("已经超过了最大乘机人数,最多50");
 return;
}

	   idnumber++;
	  var strhtml="";
	
	 strhtml+="<tr id='hidid_"+idnumber+"'>";
	 strhtml+="<td class='hadow' align='right' ><font class='fontxing'>*</font> 姓  名：</td>";
     strhtml+="<td><input type='text' class='text_name' value='' name='idname' /></td>";
     strhtml+="<td class='hadow' align='right'><font class='fontxing'>*</font> 证件类型：</td>";
     strhtml+="<td ><select class='sel_documents' name='idtype'>";
    // strhtml+="<option value='0' id='type_"+idnumber+"_0'>请选择</option>";
     strhtml+="<option value='1' id='type_"+idnumber+"_1'>身份证</option>";
     strhtml+="<option value='3' id='type_"+idnumber+"_3'>护照</option>";
     strhtml+="<option value='4' id='type_"+idnumber+"_4'>港澳通行证</option>";
     strhtml+="<option value='5' id='type_"+idnumber+"_5'>台湾通行证</option>";
     strhtml+="<option value='6' id='type_"+idnumber+"_6'>台胞证</option>";
     strhtml+="<option value='7' id='type_"+idnumber+"_7'>回乡证</option>";
     strhtml+="</select></td>";
     strhtml+="<td ><input type='text' class='text_number' name='idnumber'  /></td>";
     strhtml+="<td class='hadow' ><a href='javascript:addpass();' class='fontun06c mlr15'>增加乘客</a><a href='javascript:delpass("+idnumber+");' class='fontun06c'>删除乘客</a></td>";
     strhtml+="</tr>";
	 $("#tbrecord").html($("#tbrecord").html()+strhtml);
	
document.getElementById("maxnum").value=idnumber;//增加数字显示
}
function delpass(id){
if(document.getElementById("maxnum").value=='1'){
alert("乘机人必须最少填写一个!");
return;
}
idnumber--;
 $("#hidid_"+id).remove();
document.getElementById("maxnum").value=idnumber;
}

function checktype(id){

if(id=='2'){
$("#retun1").show();
$("#retun2").show();
}else{
$("#retun1").hide();
$("#retun2").hide();
document.getElementById("ret_time").value="";


}

}

function sub(){

if(valuedate()=='0'){

return;
}

if(document.getElementById("hidArrCity").value==''){
alert("到达城市不能为空!");
return;
}

var s_idtype="";
var s_idnum="";
var s_idname="";
 //证件类型
 var idtype=document.getElementsByName("idtype");
 //证件号码 
 var number=document.getElementsByName("idnumber");
 //姓名
 var name=document.getElementsByName("idname");
 
  for(var i=0;i<idtype.length;i++){
  		if(number[i].value!=null&&number[i].value.length>0){
	  	 s_idtype+=idtype[i].value+",";
	  	 s_idnum+=number[i].value+",";
	  	 s_idname+=name[i].value+",";
	    }else{
	    alert("证件号码不能为空!请填写完!");
	    return;
	    }
  
  }
 	$("#c_idtype").val(s_idtype);
   $("#c_idnumber").val(s_idnum);
   $("#c_idname").val(s_idname);
   

   document.form1.submit();
   
  
}
function valuedate(){
 //证件类型
 var idtype=document.getElementsByName("idtype");
 //证件号码 
 var number=document.getElementsByName("idnumber");
 //姓名
 var name=document.getElementsByName("idname");
 
   for(var i=0;i<name.length;i++){
  		if(name[i].value!=null&&name[i].value.length>0){
	  	 
	    }else{
	    alert("姓名不能为空!请填写完!");
	    return '0';
	    }
  
  }
  
   for(var i=0;i<number.length;i++){
  		if(number[i].value!=null&&number[i].value.length>0){
	  	 
	    }else{
	    alert("证件号码不能为空!请填写完!");
	   return '0';
	    }
  
  }
  
 
}

function lodnum(){
var num = document.getElementById("maxnum").value;
	if(parseInt(num)>50){
	alert("不能超过50人!");
	return;
	}
idnumber=0;

 var strhtml="";
 
 
	 for(i=0;i<parseInt(num);i++){
	 		
 		 idnumber++;
	 
	
	 strhtml+="<tr id='hidid_"+idnumber+"'>";
	 strhtml+="<td class='hadow' align='right' ><font class='fontxing'>*</font> 姓  名：</td>";
     strhtml+="<td><input type='text' class='text_name' value='' name='idname' /></td>";
     strhtml+="<td class='hadow' align='right'><font class='fontxing'>*</font> 证件类型：</td>";
     strhtml+="<td ><select class='sel_documents' name='idtype'>";
    // strhtml+="<option value='0' id='type_"+idnumber+"_0'>请选择</option>";
     strhtml+="<option value='1' id='type_"+idnumber+"_1'>身份证</option>";
     strhtml+="<option value='3' id='type_"+idnumber+"_3'>护照</option>";
     strhtml+="<option value='4' id='type_"+idnumber+"_4'>港澳通行证</option>";
     strhtml+="<option value='5' id='type_"+idnumber+"_5'>台湾通行证</option>";
     strhtml+="<option value='6' id='type_"+idnumber+"_6'>台胞证</option>";
     strhtml+="<option value='7' id='type_"+idnumber+"_7'>回乡证</option>";
     strhtml+="</select></td>";
     strhtml+="<td ><input type='text' class='text_number' name='idnumber'  /></td>";
     strhtml+="<td class='hadow' ><a href='javascript:addpass();' class='fontun06c mlr15'>增加乘客</a><a href='javascript:delpass("+idnumber+");' class='fontun06c'>删除乘客</a></td>";
     strhtml+="</tr>";
	
	
	
 
 }
  $("#tbrecord").html(strhtml);
document.getElementById("maxnum").value=idnumber;//增加数字显示

}

function yul(){

$("#yulan").hide();
$("#cz").hide();
$("#sub").show();
$("#syb").show();
document.getElementById("s_type_1").disabled=true;
document.getElementById("s_type_2").disabled=true;
document.getElementsByName("s_usertype").disabled=true;
}

</script>