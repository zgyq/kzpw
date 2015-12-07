<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="settlementtype.id>0">编辑</ww:if><ww:else>新增</ww:else>结算分类表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>

<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<link href="css/autocomplete.css" type="text/css" rel="stylesheet" />

<link rel="stylesheet" href="style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script type="text/javascript">

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


function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}
<ww:if test="listrecord.size!=0">
var idnumber=<ww:property value="listrecord.size" />;
</ww:if><ww:else>

var idnumber=1;
</ww:else>
function addrecord()
{
	ValiDatValue(idnumber);
	ValiDatValueFast(idnumber);
	
	if(ValiDatValue(idnumber)==true&&ValiDatValueFast(idnumber)==true){
	   var strhtml="";
	   idnumber++;
	   strhtml+="<tr id='hidid_"+idnumber+"'>";
	   strhtml+="<td width='20%'>"+idnumber+"<input type='hidden' name='tempid' value='0'   /></td>";
	   strhtml+="<td width='20%'><input type='text' name='fandianstart' desc='大于' id='fandianstart"+idnumber+"' onchange='ValiDatValueFast("+idnumber+");'  style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   strhtml+="<td width='20%'><input type='text' name='fandianend' desc='小于' id='fandianend"+idnumber+"' style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   strhtml+="<td width='20%'><input type='text' name='liudian' desc='暗扣' id='liudian"+idnumber+"' style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   strhtml+="<td width='20%'><a href='#' onclick='addrecord();'><img src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='delrecord("+idnumber+");'><img src='images/del.gif' />删除</a></td>";
	   strhtml+="</tr>";
	   
	  // alert(strhtml);
	   $("#tbrecord").html($("#tbrecord").html()+strhtml);
	   
	   var ty=GetRadioValue("liudiantype");
	   checktype(ty);
   }
}
function delrecord(id)
{
 //验证返点始
  var fandianstartarr=document.getElementById("fandianstart"+id).value;
  

  //验证返点止
  var fandianendarr=document.getElementById("fandianend"+id).value;
  //验证留点
  var liudianarr=document.getElementById("liudian"+id).value;

//alert(fandianstartarr+","+fandianendarr+","+liudianarr);
  if(fandianstartarr!=''||fandianendarr!=''||liudianarr!=''){
  alert("该行不能删除,请清空填写的值在进行删除操作!!!");
  }else{
  
	idnumber--;
   $("#hidid_"+id).remove();
  }
  
	

}
//表单验证
function checkdata()
{
  if($("#typename").val()=="")
  {
      alert("类型名称不能为空，请重新输入！");
        return false;
  }
  //验证返点始
  var fandianstartarr=document.getElementsByName("fandianstart");
  //验证返点止
  var fandianendarr=document.getElementsByName("fandianend");
  //验证留点
  var liudianarr=document.getElementsByName("liudian");
  //id值
  var idarr=document.getElementsByName("tempid");
  
  var strfandianstart="";
  var strfandianend="";
  var strliudian="";
  var strid="";

//var pattern=/^\+?[1-9][0-9]*$/;//只能输入数字
var pattern=/^[0-9]+(\.[0-9]{0,2})?$/;//只能输入数字

  for(var i=0;i<fandianstartarr.length;i++)
  {
     
     if(fandianstartarr[i].value=="")
     {
        alert("返点始为必填项，请重新输入！");
        return false;
     }
     	if(!pattern.exec(fandianstartarr[i].value))
		{
	
        alert("返点始只能为数字，请重新输入！");
        return false;
		}
   
     strfandianstart+=fandianstartarr[i].value+",";
  }
  
  for(var i=0;i<fandianendarr.length;i++)
  {
     if(fandianendarr[i].value=="")
     {
        alert("返点止为必填项，请重新输入！");
        return false;
     }
     	if(!pattern.exec(fandianendarr[i].value))
		{
	
        alert("返点止只能为数字，请重新输入！");
        return false;
		}
      strfandianend+=fandianendarr[i].value+",";
  }
  
  for(var i=0;i<liudianarr.length;i++)
  {
     if(liudianarr[i].value=="")
     {
        alert("留点为必填项，请重新输入！");
        return false;
     }
     	//if(!pattern.exec(liudianarr[i].value))
		//{
       //alert("留点只能为数字，请重新输入！");
      // return false;
		//}
		//alert(liudianarr[i]);
		//alert(fandianstartarr[i]);
		
		
		//2次更新 陈星开始,本次更新内容是  不验证暗扣值
		if(parseFloat(liudianarr[i].value)>parseFloat(fandianendarr[i].value)){
		 alert("暗扣值请输入小于或者等于"+fandianendarr[i].value+"的数字!");
         return false;
		}
		
		
		//验证开始值和截止值
		
		if(parseFloat(fandianstartarr[i].value)>parseFloat(fandianendarr[i].value)){
		 alert("开始值不能大于截止值");
         return false;
		}
		
		
		//2次更新结束
     strliudian+=liudianarr[i].value+",";
  }
  
  for(var i=0;i<idarr.length;i++)
  {
     strid+=idarr[i].value+",";
  }
  
  
  //对隐藏于赋值
  $("#s_fandianstart").val(strfandianstart);
  $("#s_fandianend").val(strfandianend);
  $("#s_liudian").val(strliudian);
  $("#s_id").val(strid);
  
  
  
}
function checktype(type){
//1,按返点 2,按利润
//alert(type);
if(type=='2'){
$("*[name='ty']").html("元"); 
}else{

$("*[name='ty']").html("%"); 
}



}

function  ValiDatValue(index){//验证 起始 截止  暗扣值  规则是,暗扣值不能大于起始值
//	alert("ValiDatValue,index=="+index);
	

  var star=document.getElementById("fandianstart"+index).value;
  var end=document.getElementById("fandianend"+index).value;
  var liu=document.getElementById("liudian"+index).value;
  
  if(star==''||end==''||liu==''){
   alert("请先输入完整后在增加!!!")
 	return false;
	}
  
  //alert("star=="+star+",end=="+end+",liu=="+liu);
  
 // 2次更新 陈星 开始
  if(parseFloat(liu)>parseFloat(star)){
  alert("暗扣值请输入小于或者等于"+star+"的数字!")
  
    return false;
  }
 //2次更新 结束 
  
  return true;
}
function  ValiDatValueFast(index){//验证起始不能大于上个截止值
 	var star=document.getElementById("fandianstart"+index).value;
 	 var end=document.getElementById("fandianend"+index).value;
 	 
 	 //验证开始值和截止值
		//alert(star+","+end);
		if(parseFloat(star)>parseFloat(end)){
		 alert("开始值不能大于截止值");
         return false;
		}
 	 
	if(index=='1'){
	
	       return true;
	
	}else{
	
	
	
		
		
	
		 // alert("ValiDatValueFast,index=="+index);
		  var star=document.getElementById("fandianstart"+index).value;//当前fast值
		  var end=document.getElementById("fandianend"+(parseInt(index)-1)).value;//上个end值
		  
		  
		 // alert("star=="+star+",end=="+end);
		  if(parseFloat(end)>parseFloat(star)){
		  alert("请输入大于或者等于"+end+"的数字!")
		  document.getElementById("fandianstart"+index).value="";
		  document.getElementById("fandianstart"+index).focus();
		    return false;
		  }
		  return true;
	  }
}

</script>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;政策返点设置</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="settlementtype!add.action?id=<ww:property value="id"/>&<ww:property value="url"/>"
			name="form1" id="form1" method="POST">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="256" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>留点类型名称：</span></td>
						<td>
						<ww:if test="settlementtype.id>0">
							<input type="text" require="true" dataType="Require" 
								mId="<ww:property value="settlementtype.typename"/>"
								desc="留点类型名称"
								class="validate[required,ajax[ajaxLiuDianname]]"
								
							    msg="类型名称不能为空" name="typename" id="typename"
								value='<ww:property value="settlementtype.typename"/>'
								" style="width: 350px" />
						</ww:if><ww:else>
							<input type="text" require="true" dataType="Require" 
								desc="留点类型名称"
								class="validate[required,ajax[ajaxLiuDianname]]"
							    msg="类型名称不能为空" name="typename" id="typename"
								value='<ww:property value="settlementtype.typename"/>'
								" style="width: 350px" />
						</ww:else>
						
							
							 
							<span style="color: red">*</span>
							<ww:if test="settlementtype.id==0">
							<input type="hidden" name="agentid" value="<ww:property value="s_agentid" />" />
							</ww:if>
						</td>
					</tr>
					<tr>
						<td height="10" colspan="2" align="center">
						
						<input type="radio" name="liudiantype"  value="1" checked="checked" onclick="checktype(1);" />按返点
						<!--  
						<input type="radio" name="liudiantype"  value="2" <ww:if test="settlementtype.liudianid==2">checked</ww:if>  onclick="checktype(2);" />按利润
						-->
						</td>
					</tr>
					<tr>
						<td height="10" colspan="2" align="center"><span style="color:red;font-weight:bold">暗扣设置</span></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<table width="80%" cellspacing="0" cellpadding="0" border="1"
									class="table_color">
									<tr class="tbody_color" style="font-weight: bold">
										<td width="20%" align="center">序号</td>
										<td width="20%" align="center">大于</td>
										<td width="20%" align="center">小于</td>
										<td width="20%" align="center">暗扣</td>
										<td width="20%" align="center">操作</td>
									</tr>
									<tr>
										<td colspan="5">
										<table id="tbrecord" width="100%" cellspacing="0"
											cellpadding="0" border="0">
											<ww:if test="listrecord.size!=0">
												<ww:iterator value="listrecord" status="recstatus">
													<tr>
														<td width="20%"><ww:property value="#recstatus.index+1" />
														<input type="hidden"
															name="tempid" style="width: 100px"
															value="<ww:property value="id" />" />
														</td>
														
														<td width="20%"><input type="text" id="fandianstart<ww:property value="#recstatus.index+1" />"
															name="fandianstart" style="width: 100px"
															value="<ww:property value="formatMoney(fandianstart)" />" /><span name="ty">%</span></td>
														<td width="20%"><input type="text" name="fandianend" id="fandianend<ww:property value="#recstatus.index+1" />"
															style="width: 100px"
															value="<ww:property value="formatMoney(fandianend)" />" /><span name="ty">%</span></td>
														<td width="20%"><input type="text" name="liudian"  id="liudian<ww:property value="#recstatus.index+1" />"
															style="width: 100px"
															value="<ww:property value="formatMoney(liudian)" />" /><span name="ty">%</span></td>
														<td width="20%"><a href="#" onclick="addrecord();"><img
															src="images/add.gif" />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
															href='#' onclick="alert('此留点设置不能删除!');"><img
															src='images/del.gif' />删除</a></td>
													</tr>
												</ww:iterator>
											</ww:if>
											<ww:else>
												<tr id='hidid_1'>
													<td width="20%">
													<input type="hidden"
															name="tempid" style="width: 100px"
															value="0" />
													</td>
													<td width="20%"><input type="text" name="fandianstart" id="fandianstart1" desc="大于" 
														style="width: 100px" /><span name="ty">%</span></td>
													<td width="20%"><input type="text" name="fandianend" id="fandianend1" desc="小于" 
														style="width: 100px" /><span name="ty">%</span></td>
													<td width="20%"><input type="text" name="liudian" id="liudian1" desc="暗扣"  
														style="width: 100px" /><span name="ty">%</span></td>
													<td width="20%"><a href="#" onclick="addrecord();"><img
														src="images/add.gif" />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
														href='#' onclick='delrecord(1);'><img
														src='images/del.gif' />删除</a></td>
											</ww:else>
										</table>
										</td>
										<input type="hidden" id="s_fandianstart" name="s_fandianstart"
											value="" style="display: block"/>
										<input type="hidden" id="s_fandianend" name="s_fandianend"
											value="" />
										<input type="hidden" id="s_liudian" name="s_liudian" value="" />
										
										<input type="hidden" id="s_id" name="s_id" value="" />
									</tr>
								</table>
						</td>
						
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit" id="submitreg"
							class="button_d font-bai" onclick="return checkdata();" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='settlementtype.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
	<div>
	温馨提示:</br>
	1.暗扣只能到小数点后一位。比如1.5或者1.50</br>
	2.设置规则时候,必须按照从小到大的规则进行设置</br>
	</div>
</div>
</body>
</html>
<script type="text/javascript">

 var type=GetRadioValue("liudiantype");
 
   checktype(type);

</script>