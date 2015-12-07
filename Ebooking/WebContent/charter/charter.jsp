<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-团队/包机服务</title>

<link href="skin/blue/css/charter.css" rel="stylesheet" type="text/css" />


<ww:head name="index" jsURL="member" />
<script type="text/javascript">
 var passengerJsonString='[{ ID: "1",Name:"",Type:"1"}]';
 var passengers=eval(passengerJsonString); 
    //页面加载
    $(document).ready(function()
	   {
	    $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	    //返程日期隐藏
	    /**
	    $("#li_returndate").hide();
	    **/
	    //加载城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
//默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  $("#txtstartdate").val(str);
	 });
	 
	 
	 //添加乘机人
	function addpassenger(jsonpassenger)
	{
		
	
	//alert("jsonpassenger=="+jsonpassenger);
	
	  
	   if(jsonpassenger=="")
	   {
	  		//
	  		
	  		 var currentindex=1;
	   $("tr[id*='divinformation_']").each(function(i){
             currentindex++;
       });
        document.getElementById("maxnum").value=currentindex;//增加数字显示
	   var currentpassenger=JSON.stringify(passengers);
	   
	  		//
		   passengerJsonString="[";
		   passengerJsonString+='{ID: '+currentindex+', Name:"",Type:"1"}';
		   passengerJsonString+="]";
		   
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	   }
	   else
	   {
	   
	  // alert("else");
	   		
	   		
	   	   passengerJsonString="[";
		   passengerJsonString+='{ID: '+currentindex+', Name:"",Type:"1"}';
		   passengerJsonString+="]";
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	       
	       
	     	// passengerJsonString=jsonpassenger.replace("currentindex",currentindex);
          // passengers=eval(passengerJsonString); 
	      // $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	    
	   }
	   
	
	   
	}
	
	//删除乘机人
	function delpassenger(id)
	{
	
	   var currentindex=0;
	   $("tr[id*='divinformation_']").each(function(i){
             currentindex++;
       });
       
       
       
      
        document.getElementById("maxnum").value=currentindex-1;//增加数字显示?????
       if(currentindex==1)
       {
       
        $("#dele").poshytip({
				content: "至少填写一个乘机人!",
				showOn: '',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			  
			    
			    
			document.getElementById("maxnum").value=1;
					
		   return;
       }
       else
       {
	     $("#divinformation_"+id).remove();
	   }
	  
	}
function addMember(){


}
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
          <td class="hadow" align="right" width="90">服务类型：</td>
          <td colspan="3">
          <input name="s_server" id="s_server_1" type="radio" value="1" checked onclick="checkSer(1);" /><span class="mr15">团队</span>
          <input name="s_server" id="s_server_2" type="radio" value="2" onclick="checkSer(2);" />包机</td>
          </tr>
          <input name="servicetype" type="hidden" id="hidserver" value="1" />
          
          <tr>
          <td class="hadow" align="right" width="90">航班类型：</td>
          <td colspan="3">
          <input name="s_type" id="s_type_1" type="radio" value="1" checked onclick="checktype(1);" /><span class="mr15">单程</span>
          <input name="s_type" id="s_type_2" type="radio" value="2" onclick="checktype(2);" />往返</td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">旅客类型：</td>
          <td colspan="3">
          <input name="s_usertype" type="radio" value="1" checked /><span class="mr15">内宾</span>
          <input name="s_usertype" type="radio" value="2"  />外宾</td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">出发城市：</td>
          <td width="255">
          <input type="text" class="text_number"  id="txtDepCity"  />
          <div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="s_scity" value="" />
          </td>
          <td class="hadow" align="right" width="90">达到城市：</td>
          <td><input type="text" class="text_number" name="" id="txtArrCity" />
          <div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hidArrCity" name="s_ecity" value="" />
          </td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">出发时间：</td>
          <td><input type="text" name="s_startime" id="txtstartdate" class="text_number" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
          <td class="hadow" align="right" width="90" id="retun1" style="display: none">返程时间：</td>
          <td id="retun2" style="display: none"><input type="text" id="ret_time" name="s_endtime"   class="text_number"  onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">航空公司：</td>
          <td><select name="s_companyname" class="sel_searchor" id="s_companyname">
          <option value="-1">---所有航空公司---</option>
          <ww:iterator value="listAircompany">
          <option value="<ww:property value="aircomcode"/>"><ww:property value="aircomjname"/></option>
          </ww:iterator>
          
          </select></td>
          <td class="hadow" align="right" width="90">航班号：</td>
          <td><input type="text" class="text_number" id="s_flightcode" name="s_flightcode" /></td>
          </tr>
          <tr>
          <td class="hadow" align="right" width="90">时间范围：</td>
          <td><select name="s_stime" class="sel_documents">
          <option value="06:00">06:00</option>
          <option value="07:00">07:00</option>
          <option value="08:00" selected="selected">08:00</option>
          <option value="09:00">09:00</option>
          <option value="10:00">10:00</option>
          <option value="11:00">11:00</option>
          <option value="12:00">12:00</option>
          <option value="13:00">13:00</option>
          <option value="14:00">14:00</option>
          <option value="15:00">15:00</option>
          <option value="16:00">16:00</option>
          <option value="17:00">17:00</option>
          <option value="18:00">18:00</option>
          <option value="19:00">19:00</option>
          <option value="20:00">20:00</option>
          <option value="21:00">21:00</option>
          <option value="22:00">22:00</option>
          <option value="23:00">23:00</option>
          
          </select>&nbsp;至&nbsp;<select name="s_etime" class="sel_documents">
          
          <option value="06:00">06:00</option>
          <option value="07:00">07:00</option>
          <option value="08:00">08:00</option>
          <option value="09:00">09:00</option>
          <option value="10:00">10:00</option>
          <option value="11:00">11:00</option>
          <option value="12:00" selected="selected">12:00</option>
          <option value="13:00">13:00</option>
          <option value="14:00">14:00</option>
          <option value="15:00">15:00</option>
          <option value="16:00">16:00</option>
          <option value="17:00">17:00</option>
          <option value="18:00">18:00</option>
          <option value="19:00">19:00</option>
          <option value="20:00">20:00</option>
          <option value="21:00">21:00</option>
          <option value="22:00">22:00</option>
          <option value="23:00">23:00</option>
          
          </select></td>
          <td class="hadow" align="right" width="90">&nbsp;</td>
          <td>&nbsp;</td>
          </tr>
          <tr>
          <td colspan="4" class="f00">注："航空公司"，"航班号"，"时间范围"不填默认为不限。返程时间不添加的，默认判断是单程</td>
          </tr>
          <tr id="hidtr">
          <td class="hadow" align="right" width="90">乘机人数：</td>
          <td><input type="text" class="text_name" id="maxnum" name="s_maxnum" onchange="lodnum();" value="1" /><font class="f00">人数限制为1-50人</font> </td>
          <td class="hadow" align="right" width="90">乘机人类型：</td>
          <td> <select name="s_passtype" class="sel_documents">
          <option value="1">成人</option>
          <option value="2">儿童</option>
          </select></td>
          </tr>
      </table>
      <div class="nohave"></div>
      <div id="hiddiv">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" id="tbrecord">
       
        		<table id="divpassengers">
                <script id="passengerTemplate" type="text/x-jquery-tmpl"> 
       		 <tr id="divinformation_\${ID}">
			<td class="hadow" align="right" width="90"><font class="fontxing">*</font> 姓  名：</td>
            <td width="100"><input type="text" class="text_name" value="" name='idname' id="idname_\${ID}" /></td>
            <td class="hadow" align="right" width="90"><font class="fontxing">*</font> 证件类型：</td>
            <td width="90"><select class="sel_documents" name='idtype'>
             <option value="3" id="type_1_3">护照</option>
             <option value="1" id="type_1_1">身份证</option>
		     <option value="4" id="type_1_4">港澳通行证</option>
			 <option value="5" id="type_1_5">台湾通行证</option>
		  	 <option value="6" id="type_1_6">台胞证</option>
			 <option value="7" id="type_1_7">回乡证</option>
            </select></td>
            <td width="160"><input type="text" class="text_number" name='idnumber' id="idnumber_\${ID}"  /></td>
            <td class="hadow" ><a href="javascript:addpassenger('');" class="fontun06c mlr15">增加乘客</a><a href="javascript:delpassenger(\${ID});" id="dele"  class="fontun06c">删除乘客</a></td>
         </tr>
         	</script>
           </table>	
				
				
				
				
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
       </div>
       			<input type="hidden" id="c_idname" name="c_idname" value="" />
           		<input type="hidden" id="c_idtype" name="c_idtype" value="" />
				<input type="hidden" id="c_idnumber" name="c_idnumber" value="" />
				<input type="hidden" id="lastnum" name="lastnum" value="1" />
        <div class="nohave"></div>
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
       	<td class="hadow" align="right" width="90"><font class="fontxing">*</font>申请人姓名：</td>
        <td><input type="text"  class="text_number" id="s_username" name="s_username"  /></td>
        <td class="hadow" align="right" width="90" ><font class="fontxing">*</font>申请人电话：</td>
        <td><input type="text"  class="text_number" name="s_tel"  id="s_tel" /></td>
        <td class="hadow" align="right" width="90"><font class="fontxing">*</font>申请人QQ：</td>
        <td><input type="text"  class="text_number"  name="s_qq"  id="s_qq"  /></td>
       </tr>
       <tr>
         <td class="hadow" align="right" width="90" valign="top">备注：</td>
         <td colspan="5"><textarea name="s_remarks" cols="62" rows="2" class="m15 box_ccc"></textarea></td>
       </tr>  
       </table>
     </div>
     <div class="nohave"></div>
     <div class="bnt">
      <input type="button"  class="bnt_booking fff mr25"  value="提交"  onclick="sub();"  />
     <input type="reset" id="cz" class="bnt_booking fff"  value="重置"  />
  
      </div>
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

function checkSer(id){

if(id=='1'){
$("#hiddiv").show();
$("#hidtr").show();

document.getElementById("hidserver").value=1;

}else{
$("#hiddiv").hide();
$("#hidtr").hide();
document.getElementById("hidserver").value=2;
}
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

var service=document.getElementById("hidserver").value;//1团队  2包机
//2011-12-26 gaoliang 添加为空判断  start
if(document.getElementById("txtDepCity").value==''){
   $("#txtDepCity").poshytip({
				content: "出发城市不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 $("#txtDepCity").focus();
		return false;
}
//end
 
if(document.getElementById("hidArrCity").value==''){
   $("#txtArrCity").poshytip({
				content: "到达城市不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 $("#txtArrCity").focus();
		return false;
}
if(document.getElementById("hidArrCity").value==document.getElementById("hidDepCity").value){
   $("#txtArrCity").poshytip({
				content: "到达城市不能和出发城市一样!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 $("#txtArrCity").focus();
		return false;
}

var flightcode=document.getElementById("s_flightcode").value;
	if(flightcode!=''){
				var pattern=/^[a-zA-Z]\w{4,5}$/; //航班号
				if(!pattern.exec(flightcode)){
				$("#s_flightcode").poshytip({
				content: "航班号格式错误.必须已字母开头,位数为5到6位数!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_flightcode").focus();
			return false;
		}		
	}
	
				
if(service=='1'){

				

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
  
	  	if(name[i].value==''){
	  		
		    
		    	$("#idname_"+(i+1)).poshytip({
					content: "姓名不能为空!请填写完!",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
				    
			 	$("#idname_"+(i+1)).focus();
				return false;
		   
		    }
	   		 var regnamecnen=/^[\u4E00-\u9FA5]{1,16}[a-zA-Z]{0,20}[0-9]{0,8}$/; //中文
            var regnameen = /^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/;//英文名
            if(!regnamecnen.exec(name[i].value) && !regnameen.exec(name[i].value))
            {
               $("#idname_"+(i+1)).poshytip({
                className: 'tip-yellowsimple',
				content:"请检查英文乘机人姓名格式！<br/>姓名间必须用'/'符号分隔<br/>姓在前名在后,如'Bill/Gates'请重新输入！",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
			$("#idname_"+(i+1)).focus();
			return false;
			
            }
            
            
	    
  		if(number[i].value!=null&&number[i].value.length>0){
  		
  			var pattern=/^[0-9]*$/; //数字
	
			//	alert(number[i].value);
			if(!pattern.exec(number[i].value)){
									
			$("#idnumber_"+(i+1)).poshytip({
				content: "证件号码只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#idnumber_"+(i+1)).focus();
			return false;
											
				}
				
				
	  	 s_idtype+=idtype[i].value+",";
	  	 s_idnum+=number[i].value+",";
	  	 s_idname+=name[i].value+",";
	    }else{
	   
	    
	    	$("#idnumber_"+(i+1)).poshytip({
				content: "证件号码不能为空!请填写完!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#idnumber_"+(i+1)).focus();
			return false;
	   
	    }
  
  }
 	$("#c_idtype").val(s_idtype);
   $("#c_idnumber").val(s_idnum);
   $("#c_idname").val(s_idname);
   
 } 
 
 
   //验证联系人信息
   
   var username=document.getElementById("s_username").value;
if(username==''){
				
			$("#s_username").poshytip({
				content: "申请人姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_username").focus();
			return false;

}
var tel=document.getElementById("s_tel").value;
if(tel==''){
				
			$("#s_tel").poshytip({
				content: "电话不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_tel").focus();
			return false;

}
			var pattern=/^[0-9]*$/; //数字
		if(!IsTelephone(tel)){
			$("#s_tel").poshytip({
				content: "申请电话格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_tel").focus();
			return false;
		}else{
                   if(!IsMobile(tel))
                   {
                       $('#txtcontactmobile').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查申请电话是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                  $("#s_tel").focus();
	                   return false;
                   }
              }
              
              
var qq=document.getElementById("s_qq").value;
if(qq==''){
	$("#s_qq").poshytip({
				content: "QQ号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_qq").focus();
			return false;
}
			var pattern=/^[0-9]*$/; //数字
	
			
			if(!pattern.exec(qq)){
								 	
					
				$("#s_qq").poshytip({
				content: "QQ号格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    
		 	$("#s_qq").focus();
			return false;
											
				}
 //2011-12-26 高亮 判断往返时间是否添加 没有添加自动选择单程 
if(document.getElementById("s_type_2").checked==true){
if(document.getElementById("ret_time").value==''){
   $("#s_type_1").attr("checked",true);
   $("#s_type_2").attr("checked",false);
}
}  
   var temp = confirm('确认提交?提交后将无法修改,请仔细确认后在提交!!!');
	if(temp==true){

   document.form1.submit();
   }
  
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
			var last=document.getElementById("lastnum").value;
			
			//alert(last);
		
			var num = document.getElementById("maxnum").value;
			var pattern=/^\+?[1-9][0-9]*$/; //验证非零的正整数
				if(!pattern.exec(num)){
								 	
				$("#maxnum").poshytip({
				content: "只能输入正整数!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#maxnum").focus();
			    
			    
			document.getElementById("maxnum").value=1;
					 return false;
											
				}
				

document.getElementById("lastnum").value=num;


		if(parseInt(num)>50){
				$("#maxnum").poshytip({
				content: "不能大于50人!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#maxnum").focus();
	document.getElementById("maxnum").value=1;
	document.getElementById("lastnum").value=1;
	 return false;
	}



   		var ind=0;
	   $("tr[id*='divinformation_']").each(function(i){
             ind++;
       });
       
      // alert(ind);
        for(i=1;i<=parseInt(ind+1);i++){
        $("#divinformation_"+i).remove();
        }


 for(i=1;i<=parseInt(num);i++){
 addpassenger('');
 }

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