<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-常用乘机人</title>

<ww:head name="login" jsURL="citycontrol" />

<!--
<ww:head name="login"/>
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
-->
<script>

<ww:if test="passengerid==0">
 var passengerJsonString='[{ ID: "1",Name:"",Type:"1"}]';
 var passengers=eval(passengerJsonString); 

$(document).ready(function() {
//加载第一个
 $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	
	

});
</ww:if>
  function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}

 //添加乘机人
	function addpassenger(jsonpassenger)
	{
		//验证开始
		
		 //证件类型
 var idtype=document.getElementsByName("idtype");
 //证件号码 
 var number=document.getElementsByName("idnumber");
 
		  for(var i=0;i<idtype.length;i++){
    
    if(idtype[i].value!=null&&idtype[i].value>0){
	  	
	    }else{
	 		 $("#type_"+(i+1)).poshytip({
				content: "证件类型不可为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#type_"+(i+1)+"_0").focus();
			    return false;
	    }
	    
	    if(number[i].value!=null&&number[i].value.length>0){
	    
	    	var pattern=/^[0-9]*$/; //数字
	
			//	alert(number[i].value);
			if(!pattern.exec(number[i].value)){
								 	
					//alert("证件号码只能为数字!");
				 $("#idnumber_"+(i+1)).poshytip({
				content: "证件号码只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#idnumber_"+(i+1)).focus();
			    return false;
											
				}
	  	
	  	 
	    }else{
	   	 $("#idnumber_"+(i+1)).poshytip({
				content: "证件号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#idnumber_"+(i+1)).focus();
			    return false;
	    }
   }
		
		
		//结束
	
	
	
	   var currentindex=1;
	   $("tr[id*='divinformation_']").each(function(i){
             currentindex++;
       });
     
	   var currentpassenger=JSON.stringify(passengers);
	   if(jsonpassenger=="")
	   {
	  		
		   passengerJsonString="[";
		   passengerJsonString+='{ID: '+currentindex+', Name:"",Type:"1"}';
		   passengerJsonString+="]";
		   
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	   }
	   else
	   {
	   		
	      passengerJsonString=jsonpassenger.replace("currentindex",currentindex);
	     
           passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	        //判断已有乘机人中是否有姓名为空的，如果有则删除
		    //  $("div[id*='divinformation_']").each(function(i){
		  //       var strid=$(this).attr("id");
          //       var id=strid.replace("divinformation_","");
	      //       if($("#txt_name_"+id).val()=="")
	       //      {
	       //           delpassenger(id);
	       //      }
	      //    });
	   }
	   
	
	   
	}
	
	//删除乘机人
	function delpassenger(id)
	{
	//alert(id);
	   var currentindex=0;
	   $("tr[id*='divinformation_']").each(function(i){
             currentindex++;
       });
       if(currentindex==1)
       {
          alert("必须填写一个");
		   return;
       }
       else
       {
	     $("#divinformation_"+id).remove();
	   }
	  
	}
	
	function sub(){
	
	
	
	
	
	}
</script>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?type=ticket" />
		<div style=" position:absolute; top:73px; left:150px;">当前位置 ： 首页 > 我的个人中心</div>
	</div>  
<!----------header over---------->
<div id="member">
      <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
      
  <form action="<%=request.getContextPath()%>/login!AddPassenger.jspx" name="form1" method="post" id="form1">
   <div class="right mt10 r">
       <!-- <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f"><b>注册时间</b></font><span class="f mr25">会员注册时间为：2011年10月11日</span>      <font class="f90 f">普通会员</font> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div> -->
       <div class="box">
            <div class="tit">
                   <font class="black low2 f mr15">乘机人信息</font>
                   <font class="f mr25 c999">&nbsp;</font>
                   <div class="c"></div>
            </div>
            <div class="data">
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" width="15%"><font class="fontxing mlr">*</font>姓名：</td>
                    <td width="25%"><input type="text" title="姓名不能为空!" desc="姓名" class="text_regsitlatter " id="c_passname" name="c_passname" value="<ww:property value="customerpassenger.username" />" /></td>
                    
                      <td align="right" width="15%">乘客类型：</td>
                    <td> 
                    <select class="text_regsitd" name="c_passtype">
                    <option value="1" <ww:if test="customerpassenger.type==1">selected</ww:if> >成人</option>
                    <option value="2" <ww:if test="customerpassenger.type==2">selected</ww:if>>儿童</option>
                    <option value="3" <ww:if test="customerpassenger.type==3">selected</ww:if>>婴儿</option>
                    </select>
                    </td>
                  </tr>
                 <input type="hidden" name="passengerid" value="<ww:property value="customerpassenger.id" />" />
                
                   
                   <tr>
                     <td align="right"><font class="fontxing mlr">*</font>手机号：</td>
                     <td><input type="text" title="手机号不能为空!" desc="手机号" class="text_regsitlatter " id="c_mobile"  name="c_mobile" value="<ww:property value="customerpassenger.mobile" />" /></td>
                     
                       <td align="right">状态：</td>
                     <td>
                     <select class="text_regsitd" name="c_staus">
                     <ww:if test="customerpassenger.id>0">
                      <option value="1" <ww:if test="customerpassenger.state==1">selected</ww:if> >启用</option>
                     <option value="0" <ww:if test="customerpassenger.state==0">selected</ww:if> >禁用</option>
                     </ww:if><ww:else>
                      <option value="1">启用</option>
                     <option value="0">禁用</option>
                     </ww:else>
                    
                     </select></td>
                   </tr>
                   
                 
                 </table>

            </div>
            
             <div class="tit">
                   <font class="black low2 f mr15">证件信息</font>(证件类型一经填写不可修改,只可修改相应类型的号码!如有新的证件请增加!)
                   <font class="f mr25 c999">&nbsp;</font>
                   <div class="c"></div>
            </div>
            <div class="data">
                 <table width="96%" border="0" cellspacing="0" cellpadding="0" class="centerall">
                 <ww:if test="ListCustomercredit!=null">
                 
	                 <table id="tbrecord">
		                 <ww:iterator value="ListCustomercredit" status="ind">
		                	<tr id="hidid_<ww:property value="#ind.index+1" />">
		                     <td class="box_botm_xu" align="right" width="8%" height="40"><font class="fontxing">*</font> 类型：</td>
		                     <td width="9%" class="box_botm_xu"><select class="text_regsitlatt " name='idtype' id="type_<ww:property value="#ind.index+1" />" disabled="disabled" onchange="changeType('<ww:property value="#ind.index+1" />');">
					              <option value="0" id="type_<ww:property value="#ind.index" />_0" <ww:if test="credittypeid==0">selected</ww:if>>请选择</option>
					              <option value="1" id="type_<ww:property value="#ind.index+1" />_1" <ww:if test="credittypeid==1">selected</ww:if>>身份证</option>
								  <option value="3" id="type_<ww:property value="#ind.index+1" />_3" <ww:if test="credittypeid==3">selected</ww:if>>护照</option>
							      <option value="4" id="type_<ww:property value="#ind.index+1" />_4" <ww:if test="credittypeid==4">selected</ww:if>>港澳通行证</option>
							      <option value="5" id="type_<ww:property value="#ind.index+1" />_5" <ww:if test="credittypeid==5">selected</ww:if>>台湾通行证</option>
							      <option value="6" id="type_<ww:property value="#ind.index+1" />_6" <ww:if test="credittypeid==6">selected</ww:if>>台胞证</option>
							      <option value="7" id="type_<ww:property value="#ind.index+1" />_7" <ww:if test="credittypeid==7">selected</ww:if>>回乡证</option>
		                     </select></td>
		                     <td align="right" class="box_botm_xu" width="12%"><font class="fontxing">*</font> 号码：</td>
		                     <td width="13%" class="box_botm_xu"><input type="text" id="idnumber1" class="text_regsitlang" name='idnumber' value="<ww:property value="creditnumber" />" /></td>
		                     <td align="right" class="box_botm_xu" width="9%"> 状态：</td>
		                     <td  class="box_botm_xu">
		                     <input type="radio" value="1"  name='idstaus<ww:property value="#ind.index+1" />' <ww:if test="staus==1">checked</ww:if>  />启用
		                     <input type="radio" value="0"  name='idstaus<ww:property value="#ind.index+1" />' <ww:if test="staus==0">checked</ww:if> />禁用
		                     </td>
		                    
		                     <td class="box_botm_xu"><input class="bnt_modify fff mr15" type="button" value="增加" onclick="addpass('1');" /><input class="bnt_booking fff mr25" type="button" <ww:if test="#ind.index==0">disabled</ww:if>  value="删除" onclick="editdelpass('<ww:property value="#ind.index+1" />');" /> </td>
		                   </tr>
		                   
		                   </ww:iterator>
	                  </table>
                 
                 </ww:if><ww:else>
                 
                 
                 <table id="divpassengers">
                <script id="passengerTemplate" type="text/x-jquery-tmpl"> 
                	<tr id="divinformation_\${ID}">
                     <td class="box_botm_xu" align="right" width="8%" height="40"><font class="fontxing">*</font> 类型：</td>
                     <td width="9%" class="box_botm_xu"><select class="text_regsitlatt" name='idtype' id="type_\${ID}" onchange="changeType(\${ID});">
                      <option value="0" id="type_\${ID}_0">请选择</option>
                      <option value="1" id="type_\${ID}_1">身份证</option>
					  <option value="3" id="type_\${ID}_3">护照</option>
				      <option value="4" id="type_\${ID}_4">港澳通行证</option>
				      <option value="5" id="type_\${ID}_5">台湾通行证</option>
				      <option value="6" id="type_\${ID}_6">台胞证</option>
				      <option value="7" id="type_\${ID}_7">回乡证</option>
                     </select></td>
                     <td align="right" class="box_botm_xu" width="12%"><font class="fontxing">*</font> 号码：</td>
                     <td width="13%" class="box_botm_xu"><input type="text" id="idnumber_\${ID}" class="text_regsitlang" name='idnumber' /></td>
                     
                      <td align="right" class="box_botm_xu" width="9%"> 状态：</td>
                     <td  class="box_botm_xu">
                     <input type="radio" value="1"   name='idstaus\${ID}' checked="checked" />启用
                     <input type="radio" value="0"   name='idstaus\${ID}' />禁用
                     </td>
                     
                     <td class="box_botm_xu"><input class="bnt_modify fff mr15" type="button" value="增加" onclick="addpassenger('');" /><input class="bnt_booking fff mr25" type="button" value="删除" onclick="delpassenger(\${ID});" /> </td>
                   </tr>
 					</script>
                  </table>
                  
                 </ww:else>
                <input type="hidden" id="c_idtype" name="s_idtype" value="" />
				<input type="hidden" id="c_idnumber" name="s_idnumber" value="" />
				<input type="hidden" id="c_idstaus" name="s_staus" value="" />
                  
                
                   
                   
                   
                  <table>
	                   <tr>
	                   <td colspan="2" class="save"><input type="button" value="保存信息" class="bst" onclick="subform();"  /> </td>
	                   </tr>
                  </table>
                   
                   
                   
                 </table>
            </div>
            
            	
       </div> 
   </div>
   </form>
</div>

<ww:include page="../footer.jsp"/>  
</body>
</html>
<script type="text/javascript">
var idnumber;
<ww:if test="ListCustomercredit!=null">
 idnumber=<ww:property value="ListCustomercredit.size" />;
</ww:if><ww:else>

 idnumber=1;
</ww:else>

function addpass(id){

 var number=document.getElementsByName("idnumber");
 var idtype=document.getElementsByName("idtype");
    for(var i=0;i<number.length;i++){
    
    	if(idtype[i].value!=null&&idtype[i].value>0){
	  	
	    }else{
	    alert("证件类型不能为空!请选择完在添加!");
	    return;
	    }
	    
	    
	    if(number[i].value!=null&&number[i].value.length>0){
	  	
	    }else{
	    alert("证件号码不能为空!请填写完在添加!");
	    return;
	    }
   }
   
   

var indextype=$("#type_"+number).val();
//alert(indextype);


//alert("idnumber=="+idnumber);
	    idnumber++;
	    
	   // alert("idnumber=="+idnumber);
 		var strhtml="";
       // strhtml+="<table>";
 	    strhtml+="<tr id='hidid_"+idnumber+"'>";
        strhtml+="<td class='box_botm_xu' align='right' width='8%' height='40'><font class='fontxing'>*</font> 类型：</td>";
        strhtml+="<td width='9%' class='box_botm_xu'><select class='text_regsitlatt' name='idtype' id='type_"+idnumber+"' onchange='changeType("+idnumber+");'>";
        strhtml+="<option value='0' id='type_"+idnumber+"_0'>请选择</option>";
        strhtml+="<option value='1' id='type_"+idnumber+"_1'>身份证</option>";
        strhtml+="<option value='3' id='type_"+idnumber+"_3'>护照</option>";
        strhtml+="<option value='4' id='type_"+idnumber+"_4'>港澳通行证</option>";
        strhtml+="<option value='5' id='type_"+idnumber+"_5'>台湾通行证</option>";
        strhtml+="<option value='6' id='type_"+idnumber+"_6'>台胞证</option>";
        strhtml+="<option value='7' id='type_"+idnumber+"_7'>回乡证</option>";
        strhtml+="</select></td>";
        strhtml+="<td align='right' class='box_botm_xu' width='12%'><font class='fontxing'>*</font> 号码：</td>";
        strhtml+="<td width='13%' class='box_botm_xu'><input id='idnumber+"+idnumber+"' name='idnumber' type='text' class='text_regsitlang' /></td>";
        strhtml+="<td align='right' class='box_botm_xu' width='9%'> 状态：</td>";
        strhtml+="<td  class='box_botm_xu'>";
        strhtml+="<input type='radio'  value='1'   name='idstaus"+idnumber+"' checked='checked' />启用";
        strhtml+="<input type='radio'  value='0'   name='idstaus"+idnumber+"' />禁用";
        strhtml+="</td>";
        strhtml+="<td class='box_botm_xu'><input class='bnt_modify fff mr15' type='button' value='增加' onclick='addpass();' />";
        strhtml+="<input class='bnt_booking fff mr25' type='button' value='删除' onclick='delpass("+idnumber+");' /> </td>";
        strhtml+="</tr>";
       // strhtml+="</table>";
       // alert($("#tbrecord").html());
         $("#tbrecord").html($("#tbrecord").html()+strhtml);

}

function changeType(index){
var s_idtype="";
var idtype=document.getElementsByName("idtype");

var indextype=document.getElementById("type_"+index).value;

	for(var i=0;i<idtype.length-1;i++){
	    if(idtype[i].value!=null&&idtype[i].value.length>0){
	  	 s_idtype+=idtype[i].value+",";
	  	 
	    }
   }

if(s_idtype.indexOf(indextype)!=-1){

	 			$("#type_"+index).poshytip({
				content: "不可以添加相同的证件类型!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#type_"+index+"_0").focus();
 		
document.getElementById("type_"+index+"_0").selected="selected";
return false;
}



}
function delpass2(id){
alert("证件类型和证件号必须填写一项!");
}
function delpass(id){
idnumber--;
 $("#hidid_"+id).remove();
 vadate();
}
function editdelpass(id){
	var temp = confirm('确认删除!删除后将无法恢复,若不用请选择禁用!!!');
	if(temp==true){
						
	idnumber--;
 	$("#hidid_"+id).remove();
 	 vadate();
	}
						

}
function subform(){

 if($("#c_passname").val()==""){  
	 //验证提示
	 $('#c_passname').poshytip({
				//className: 'tip-yellowsimple',
				content: "姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#c_passname").focus();
	 return false; 
	 }


 if($("#c_mobile").val()==""){  
	 //验证提示
	 $('#c_mobile').poshytip({
				//className: 'tip-yellowsimple',
				content: "手机号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#c_mobile").focus();
	 return false; 
	 }
	 
var mobile= $("#c_mobile").val(); 
	if(!IsMobile(mobile)){
	 		 $("#c_mobile").poshytip({
				content: "手机号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#c_mobile").focus();
 		return false;
}
	

var s_idtype="";
var s_idnum="";
var s_instaus="";
 //证件类型
 var idtype=document.getElementsByName("idtype");
 //证件号码 
 var number=document.getElementsByName("idnumber");
 
var staus= $("input[name^='idstaus']");
 
	for( i=0; i<staus.length; i++)
	{
		if(staus[i].checked)
		{
		s_instaus+=staus[i].value+","
		}
		
	
	}
   
   
    for(var i=0;i<idtype.length;i++){
    
    if(idtype[i].value!=null&&idtype[i].value>0){
	  	
	    }else{
	 		 $("#type_"+(i+1)).poshytip({
				content: "证件类型不可为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#type_"+(i+1)+"_0").focus();
			    return false;
	    }
	    
	    if(number[i].value!=null&&number[i].value.length>0){
	    
	    	var pattern=/^[0-9]*$/; //数字
	
			//	alert(number[i].value);
			if(!pattern.exec(number[i].value)){
								 	
					//alert("证件号码只能为数字!");
				 $("#idnumber_"+(i+1)).poshytip({
				content: "证件号码只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#idnumber_"+(i+1)).focus();
			    return false;
											
				}
	  	 s_idtype+=idtype[i].value+",";
	  	 s_idnum+=number[i].value+",";
	  	 
	    }else{
	   	 $("#idnumber_"+(i+1)).poshytip({
				content: "证件号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#idnumber_"+(i+1)).focus();
			    return false;
	    }
   }



   $("#c_idtype").val(s_idtype);
   $("#c_idnumber").val(s_idnum);
   $("#c_idstaus").val(s_instaus);
   
     var temp = confirm('确认提交?');
	if(temp==true){

   document.form1.submit();
   }
  
	

    
}

function vadate(){
var s_idtype="";
var s_idnum="";
var s_instaus="";
 //证件类型
 var idtype=document.getElementsByName("idtype");
 //证件号码 
 var number=document.getElementsByName("idnumber");
 
var staus= $("input[name^='idstaus']");
 
	for( i=0; i<staus.length; i++)
	{
		if(staus[i].checked)
		{
		s_instaus+=staus[i].value+","
		}
		
	
	}
	
 
    for(var i=0;i<idtype.length;i++){
    
    
    	if(idtype[i].value!=null&&idtype[i].value>0){
	  	
	    }else{
	    alert("证件类型不能为空!请选择完在添加!");
	    return;
	    }
	    
	    
	    if(number[i].value!=null&&number[i].value.length>0){
	    	
	    	var pattern=/^[0-9]*$/; //数字
	
		
			if(!pattern.exec(number[i].value)){
								 	
					alert("证件号码只能为数字!");
					 return;
											
				}
		
		
	    	
	  	 s_idtype+=idtype[i].value+",";
	  	 s_idnum+=number[i].value+",";
	  	 
	    }else{
	    alert("证件号码不能为空!请填写完在添加!");
	    
	    return;
	    }
   }
   $("#c_idtype").val(s_idtype);
   $("#c_idnumber").val(s_idnum);
   $("#c_idstaus").val(s_instaus);
   
   

}


</script>

