<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-积分兑换</title>

<ww:head name="point" jsURL="memberpoint" />
<script language="javascript" type="text/javascript"
	src="js/provinceandcity/provinceandcity.js"></script>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>     
<!----------header over---------->
<div id="member">
    <jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
   <div class="right mt10 r">
        <form action="point!toPointSuccess.jspx" method="post" >
        <div class="box">
            <div class="tit">
                   <font class="black low2 f mr15">配送地址</font>
                   <font class="f mr25 c999">您选择的是实物礼品，请填写接收地址。</font>
                   <div class="c"></div>
            </div>
            <div class="data">
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right">选择常用配送地址：</td>
                    <td>
                    <ww:iterator value="listUseraddress" status="ind">
                    <input name="UserAddressID" type="radio" onclick="checkRadio(<ww:property value="id"/>);" value="<ww:property value="id"/>" <ww:if test="#ind.index==0">checked</ww:if>  /><ww:property value="name"/>...
                    </ww:iterator>
                   
                    
                    </td>
                  </tr>
                  <tr>
                    <td align="right" width="25%"><font class="fontxing mlr">*</font>姓名：</td>
                    <td><input type="text" id="col_name" name="col_name" class="text_regsit" value="<ww:property value="listUseraddress.get(0).name"/>" /></td>
                  </tr>
                     <td align="right"> 联系电话：</td>
                     <td><input type="text" id="areacode" name="col_areacode" class="text_regsitd" value="<ww:property value="listUseraddress.get(0).areacode"/>" />—&nbsp;
                     <input type="text" id="tel" name="col_tel" class="text_regsitlatter" value="<ww:property value="listUseraddress.get(0).tel"/>" />例：010-00000000</td>
                   </tr>
                   <tr>
                     <td align="right">手机号：</td>
                     
                     <td><input type="text" id="telephone" name="col_mobile" class="text_regsitlatter" value="<ww:property value="listUseraddress.get(0).mobile"/>" /></td>
                   </tr>
                   <tr>
                     <td align="right">详细地址：</td>
                     <td>
                     <select name="col_province" style="vertical-align: middle;"
			id="selProvince" 
			onchange="getCity(this.options[this.selectedIndex].value)">
			<option value="<ww:property value="listUseraddress.get(0).province" />"><ww:property
					value="listUseraddress.get(0).province" /></option>
			</select>
			<select id="selCity" name="col_city" style="vertical-align: middle;">
			<option value="<ww:property value="listUseraddress.get(0).city" />"><ww:property
					value="listUseraddress.get(0).city" /></option>
			<ww:if test="shi!=null&&shi!=''">
				<option value="<ww:property value="listUseraddress.get(0).city" />"><ww:property
					value="listUseraddress.get(0).city" /></option>
			</ww:if>
		</select>
                     <!--
                     <input class="text_regsitlatt" type="text" value="北京市" />
                     <input class="text_regsitlatt" value="石景山区" type="text" />
                     -->
                     <input class="text_regsit" id="area" name="col_area" type="text"  value="<ww:property value="listUseraddress.get(0).area" />" />
                     </td>
                   </tr>
                   <tr>
                     <td align="right">邮政编码：</td>
                     <td><input type="text" id="postalcode" name="col_postalcode" class="text_regsit" value="<ww:property value="listUseraddress.get(0).postalcode" />" /></td>
                   </tr>
                   <tr style="display: none">
                   <td colspan="2" class="save"><input type="button" value="保存信息" class="bst"  /> </td>
                   </tr>
                 </table>

            </div>
       </div> 
       <div class="box mt7">
        <div class="tit">
               <font class="black low2 f mr15">积分商城</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         
          <input type="hidden" name="UserAddressID" id="UserAddressID" value="<ww:property value="listUseraddress.get(0).id" />" /><!-- 常用配送地址ID -->
          <input type="hidden" name="Giftid" id="Giftid" value="<ww:property value="gift.id" />" /><!-- GiftID -->
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
               <td align="right" width="20%"><img src="images/jifenduihuan.jpg" width="140" height="140" class="m10 ad_box" /></td>              
               <td class="hl24">
               <div class="mf31">
                 <ul>
                 <li><ww:property value="gift.name"/></li>
                 <li>物品编号：<ww:property value="gift.giftcode"/></li>
                 <li>所需积分：<font class="f90c"><ww:property value="gift.useintegral"/>分</font></li>
                 <li>剩余数量：21个</li>
                 <li><input type="submit" class="button_first fff mr25" value="继续兑换" />已有<font class="f90c">4 位</font>${compname}用户兑换该物品</li>
                 </ul>
               </div>  
              </td>
              </tr>
            </table>
            
            <!--listsearch over-->
           
            <div class="nohave">&nbsp;</div>
        </div>
       </div> 
       </form>
   </div>
</div>

<ww:include page="../footer.jsp" />  
</body>
</html>
<script>
function checkRadio(id){
 $("#UserAddressID").val(id);

 $.ajax({
       type:"POST",
      url:"point!GetUserAddressById.jspx?UserAddressID="+id,
       async:false,     
       success:function(data)
       {    
       //alert(data);
        if(data){
        //alert(data);
        var UserAddres=data.split("?");
       // alert(UserAddres.length);
       // alert(UserAddres[0]);
         $("#col_name").val(UserAddres[0]);
         $("#areacode").val(UserAddres[1]);
         $("#tel").val(UserAddres[2]);
         $("#telephone").val(UserAddres[3]);
         $("#selProvince").val(UserAddres[4]);
         $("#selCity").val(UserAddres[5]);
         $("#area").val(UserAddres[6]);
         $("#postalcode").val(UserAddres[7]);
			    
        }else{//查询失败
        
        	
        }
          
       }   
            
  });
}

function qwqwqwq(){

 if($("#membername").val()==""){

	       	$("#membername").poshytip({
				content: "姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#membername").focus();
			     return false;
	}

	if($("#selProvince").val()==""){
	       	$("#selProvince").poshytip({
				content: "省份不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'top',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#selProvince").focus();
			     return false;
}

 if($("#selCity").val()==""){
	       	$("#selCity").poshytip({
				content: "所在市不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#selCity").focus();
			     return false;
}
if($("#area").val()==""){
	       	$("#area").poshytip({
				content: "区域不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#area").focus();
			     return false;
}else if($("#area").val().length>20){
		$("#area").poshytip({
				content: "区域区域长度不能大于20!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#area").focus();
			     return false;
}
if($("#address").val()==""){
	       	$("#address").poshytip({
				content: "地址不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#address").focus();
			     return false;
}	
if($("#areacode").val()==""){
	       	$("#areacode").poshytip({
				content: "区号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}
 if(!IsNumber($("#areacode").val())){
	       	$("#areacode").poshytip({
				content: "区号只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}

if($("#areacode").val().length<3||$("#areacode").val().length>4){
	       	$("#areacode").poshytip({
				content: "区号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}
if($("#tel").val()==""){
	       	$("#tel").poshytip({
				content: "号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tel").focus();
			     return false;
}else{
 if(!IsTelephone($("#tel").val())){
	       	$("#tel").poshytip({
				content: "号码格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tel").focus();
			     return false;
	}
}	

if($("#telephone").val()==""){
	       	$("#telephone").poshytip({
				content: "手机号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
}else{
 if(!IsMobile($("#telephone").val())){
	       	$("#telephone").poshytip({
				content: "号码格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
	}
}	
 if($("#mail").val()==""){
	       	$("#mail").poshytip({
				content: "邮箱不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			  $("#mail").focus();
			     return false;
}
 if(!IsEMail($("#mail").val())){
	       	$("#mail").poshytip({
				content: "邮箱格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			   $("#mail").focus();
			     return false;
}
if($("#postalcode").val()==""){
	       	$("#postalcode").poshytip({
				content: "邮编不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#postalcode").focus();
			     return false;
}	
if($("#postalcode").val()!=''){
 if(!IsPostalCode($("#postalcode").val())){
	       	$("#postalcode").poshytip({
				content: "邮编格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#postalcode").focus();
			     return false;
}
}

 document.form1.submit();	
}
function getAddress(){
		var sheng=$("#selProvince").val();
		var shi=document.getElementById("selCity").value;
		var quyu=document.getElementById("area").value;
		document.getElementById("address").value=sheng+"-"+shi+"-"+quyu;
	}

getSheng();
<ww:if test="sheng==null||sheng==''">

getCity();
</ww:if>
</script>