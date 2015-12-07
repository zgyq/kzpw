<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="ww" uri="webwork" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保险创建</title>
<link href="js/city-control/base.css" rel="stylesheet" />
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.tmpl.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath() %>/js/json2.js" type="text/javascript"></script> 
<script type="<%=request.getContextPath() %>/js/query.js" type="text/javascript"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript">
    function sub(id){
       var fname=document.getElementById("myname_"+id).value;
       var card=document.getElementById("cardnumber_"+id).value;
       var mobile1=$("#mobile1_"+id).val();
       var birthday=$("#birthday_"+id).val();
       var myemail=$("#email_"+id).val();
       var flyno=$("#flyno_"+id).val(); 
       var codetype=$("#cardtype_"+id).val(); 
       var reg=/^1[3,5,6,7,8,9,4]{1}[0-9]{1}[0-9]{8}$/;//验证电话号码
       var reg1=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/;//测试出生日期
       var reg2=/^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/;//验证电子邮箱
       //var reg2="/^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$/;         
       if(fname==""){
          alert("请填写被保人姓名！");
          return document.getElementById("myname_"+id).focus();
          return false;
       }
       //获得选择的证件类型
       else if(card==""){
          alert("请填写被保人证件号！");
          return $("#cardnumber_"+id).focus();
          return false;
       }
       else if(mobile1==""||!reg.exec(mobile1)){
          alert("请正确填写被保人手机号码！");
          return $("#mobile1_"+id).focus();   
            return false;
       }
       else if(birthday==""||!reg1.test(birthday)){
          alert("请正确填写被保人出生日期！");
          return $("#birthday_"+id).focus();
            return false;
       }
       else if(myemail==""||!reg2.exec(myemail)){
          alert("请正确填写被保人电子邮箱！");
          return $("#email_"+id).focus();
          return false;
       }
       else if(flyno==""){
          alert("请正确填写被保人航班号！");
          return $("#flyno_"+id).focus();
          return false;
       }else{
         return true;
       }
    }
    function mysubmit(){
    var reg=/^1[3,5,6,7,8,9,4]{1}[0-9]{1}[0-9]{8}$/;//验证电话号码
    var reg1=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/;//测试出生日期
    var reg2=/^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/;//验证电子邮箱
    var reg3=/^\d{15}|\d{18}$/;//验证省份证号
    var valresultname=true;
    var id=0;
     $("input[id*='myname_']").each(function(i){
        if($(this).val()==""){
          id=$(this).attr("id").replace("myname_","");
          valresultname=false;
        }
     });
     if(valresultname==false)
     {
       alert("请填写第"+id+"位被保人姓名!");
       $("#myname_"+id).focus();
       return false;
     }
     var valcardnumber=true;
     $("input[id*='cardnumber_']").each(function(i){
        if($(this).val()==""){
        id=$(this).attr("id").replace("cardnumber_","");
        valcardnumber=false;
        }
     });
     if(valcardnumber==false){
          alert("请填写第"+id+"位被保人证件号");
          $("#cardnumber_"+id).focus();
          return false;
     }
     var valmobile=true;
     $("input[id*='mobile1_']").each(function(i){
       if($(this).val()==""||!reg.exec($(this).val())){
       id=$(this).attr("id").replace("mobile1_","");
       valmobile=false;
       }
     });
     if(valmobile==false){
          alert("请正确填写第"+id+"位被保人手机号码");
          $("#mobile1_"+id).focus();
          return false;
     }
     var valbirthday=true;
     $("input[id*='birthday_']").each(function(i){
       if($(this).val()==""||!reg1.exec($(this).val())){
          id=$(this).attr("id").replace("birthday_","");
          valbirthday=false;
       }
     });
     if(valbirthday==false){
         alert("请正确填写第"+id+"位被保人的出生日期");
         $("#birthday_"+id).focus();
         return false;
     }
     var valmemberemail=true;
     $("input[id*='email_']").each(function(i){
       if($(this).val()==""||!reg2.exec($(this).val())){
          id=$(this).attr("id").replace("email_","");
          valmemberemail=false;
       }
     });
     if(valmemberemail==false){
         alert("请正确填写第"+id+"位被保人的电子邮箱");
         $("#email_"+id).focus();
         return false;
     }
     var valflyno=true;
      $("input[id*='flyno_']").each(function(i){
       if($(this).val()==""){
          id=$(this).attr("id").replace("flyno_","");
          valflyno=false;
       }
     });
     if(valflyno==false){
         alert("请正确填写第"+id+"位被保人的航班号");
         $("#flyno_"+id).focus();
         return false;
     }
     var codetype=$("#cardtype_"+id).val(); //或者证件类型的值
     var type=true;
     $("select[id*='cardtype_']").each(function(i){
     if($(this).val()==1){
       if(!reg3.exec($(this).val())){
          id=$(this).attr("id").replace("cardtype_","");
          type=false;
       }
       }
     });
     if(type==false){
         alert("请正确填写第"+id+"位被保人的身份证号");
         $("#cardtype_"+id).focus();
         return false;
     }
     
     if(valresultname&&valcardnumber&&valmobile&&valbirthday&&valmemberemail&&valflyno&&type){
      loading("<font size='5px'>正在提交订单</font>");
      document.myform.submit();
     }
  } 
  function loadingtext(context)
	 {
	   //遮罩效果  
        $.blockUI({ message: '<img src="images/loadding.gif" />' });
	 }
</script>
<script type="text/javascript">
var passengerJsonString='[{tid:"1",myname: "", sex: "男",cards:"0",cardnumber:"",city:"北京",mobile1:"",birthday:"", email:"",flyno:"",time1:"",begintime:""}]';

var users=eval(passengerJsonString); 


//页面加载
$(function () { 

//加载订单中乘机人信息
<ww:if test="passengerlist.size()>0">
var passengerJsonString="[";
<ww:iterator value="passengerlist" status="index">
//获得订单编号
var orderid=<ww:property value="orderid" />
passengerJsonString+='{tid:\"<ww:property value="#index.index+1" />\",myname: \"<ww:property value="name" />\", sex: \"<ww:property value="" />\",cards:\"<ww:property value="idtype" />\",cardnumber:\"<ww:property value="idnumber"/>\",mobile1:\"<ww:property value="mobile"/>\",birthday:\"<ww:property value="birthday"/>\", email:"",flyno:\"<ww:property value="getFlyNoById(orderid)" />\",time1:\"<ww:property value='getDepaittime(orderid)'/>\" ,begintime:\"<ww:property value='getDepaittime(orderid)'/>\"},';
</ww:iterator>
passengerJsonString+="]";
users=eval(passengerJsonString);
</ww:if>

$('#myTemplate').tmpl(users).appendTo('#rows'); 

}); 
//添加被保人
function addpassenger(id)
{
   if(sub(id)==true){
   var currentpassenger=JSON.stringify(users);
   //获得当前的数量
   var currentindex=parseInt(users.length)+1;
   var count=1;
   $("tr[id*=tr_]").each(function(i){
       count++;
   });
   if(count>=10){
      return;
   }else{
   passengerJsonString="[";
   passengerJsonString+='{tid:"'+count+'",myname: "", sex: "男",cards:"0",cardnumber:"",mobile1:"",birthday:"", email:" ",flyno:" ",time1:"",begintime:""}';
   passengerJsonString+="]";
   users=eval(passengerJsonString); 
   $('#myTemplate').tmpl(users).appendTo('#rows'); 
   }
   }
   showpassengercount();
   
}
//删除被保人
function delpassenger(id)
{
   var count=0;
   $("tr[id*=tr_]").each(function(i){
       count++;
   });
    if(count==1)
       {
          //$('#delete').poshytip('enable');
          //$('#delete').poshytip('show');
		   return;
       }
       else
       {
	     $("#tr_"+id).remove();
	   }
   showpassengercount();
}
function showpassengercount()
{
   var count=0;
   $("tr[id*=tr_]").each(function(i){
       count++;
   });
   $("#span_count").html(count);
   
}
</script>
</head>
<body >
<div  id="right" >
 <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">购买电子保险</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
<div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">订单查询</font>&nbsp;&nbsp;<font class="font-666">(根据机票订单加载乘机人)</font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
       <form action="insurance!getPassenger.action" method="post">
      <table width="96%"  border="1" cellpadding="0" cellspacing="0"  bordercolor="#8ab4d2" class="font-69f yin" >
          <tr>                                                          
            <td align="center" class="table_yin">机票订单号：</td>
            <td class="table_wu"><input type="text" name="flyorderid"/></td>
          </tr>
          <tr>
            <td align="center" class="table_yin">保险详情：</td>
            <td class="table_wu">慧择宝短期公共交通工具意外伤害保险，面额20元，结算价6元</td>
          </tr>
		   <tr>                                                          
            <td  colspan="2" align="center"> <input type="submit" class="button_sea mr18" value="查询乘机人" /> <input type="reset" class="button_sea mr18" value="重置"/></td>
          </tr>
        </table>
        </form>
          <div class="h8">&nbsp;</div>
        <div class="h8">&nbsp;</div>
        </div>
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou"  >
          <tr>
            <td width="20"><img src="skin/blue/images/ico_peoplecjr.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">被保人信息</font>&nbsp;&nbsp;<font class="font-666">当前被保人数<span id="span_count"></span></font><font class="font-666">最多能投保9人</font></td>
            <td >&nbsp;</td>
          </tr>
      </table>
      <form action="insurance!OrderApply.action" name="myform" method="post">
      
        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center"id="rows"> 
           
		  <script id="myTemplate" type="text/x-jquery-tmpl"> 
            <tr id="tr_\${tid}">
             <td colspan="10">
               <table width="98%" border="0" cellspacing="0" cellpadding="0"  >
                  <tr>
                       <td class="table_yin" width="11%">姓名：</td><td width="10%"><input type="hidden" value="\${tid}" id="tid"><input  type="text" desc="姓名" class="validate[required]" value="\${myname}" size="9" name="membername" id="myname_\${tid}"/></td>
                        <td class="table_yin" width="11%">证件类型：</td><td width="10%"><select name="cardtype" id="cardtype_\${tid}" value="\${cards}">
	                        <option  value="1">身份证</option>
	                        <option selected="selected" value="3">护照</option>
	                        <option value="8">出生证</option>
	                         <option value="99">其他</option>
                               </select></td>
             <td class="table_yin" width="11%">证件号:</td><td ><input width="10%" type="text" size="10" name="cardnunber" desc="证件号" calss="validate[required]" id="cardnumber_\${tid}" value="\${cardnumber}"/>  </td>
           <td class="table_yin"  width="11%">性别：</td><td width="10%"><select name="membersex" id="select" value=""> <option selected="selected" value="1">男</option>
                          <option value="0">女</option>
            </select></td>              
            
            <td><a href="#" onclick="delpassenger(\${tid})" id="delete">删除</a></td>
            </tr>
            <tr>
           <td class="table_yin" >所在城市：</td><td ><select name="city" id="city_\${tid}" value="">
                 <option selected="selected" value="110000">北京</option>
                 <option value="500000">重庆</option>
                 <option value="210000">辽宁</option>
                 <option value="310000">上海</option>
                 <option value="320000">江苏</option>
                 <option value="330000">浙江</option>
                 <option value="510000">四川</option>
                 <option value="420000">湖北</option>
                 <option value="440000">广东</option>
            </select></td>
            <td class="table_yin" >手机号码:</td><td ><input  type="text" size="10" name="mobile" desc="手机号码" class="validate[required,ajax[ajaxMobile]]" id="mobile1_\${tid}" value="\${mobile1}"/>   </td>
            <td class="table_yin"  width="">出生日期：</td><td><input  type="text" size="10" name="birthday" desc="出生日期" class="validate[required]" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" id="birthday_\${tid}" /></td>
            <td class="table_yin"  width="">电子邮箱：</td><td><input  type="text" size="10" name="memberemail" desc="电子邮箱" class="validate[required]" id="email_\${tid}" /></td>
            <td><a href="#" onclick="addpassenger(\${tid})">添加</a></td>
            </tr>
            <tr>
            <td class="table_yin"  width="">航班号：</td><td><input  type="text" size="10" name="flyno" desc="航班号" class="validate[required]" id="flyno_\${tid}" value="\${flyno}"/></td>
            <td class="table_yin"  width="">起飞日期：</td><td><input  type="text" size="10" name="flytime" onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d+1'})" id="time1_\${tid}" value="\${time1}"/></td>
            <td class="table_yin"  width="">起保时间</td><td><input  type="text" size="10" name="begintime" onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d+1'})" id="begintime" value="\${begintime}"/> </td>
			<td></td> 
                  </tr>
               </table>
              </td>
          </tr>
         </script>    
          </table>
		 </form>
        <div class="h8">&nbsp;</div>
      </div>
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left"><font class="font16-f90">温馨提示</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
        
         <tr>
            <td align="left">注：请仔细核对所填写信息并保证信息真实有效 <span style="color:red">(以上内容都为必填项)</span></td>                                            
          </tr>
           <tr>
            <td align="left">注：被保人年龄是在18-70周岁 </td>                                            
          </tr>
          <tr>
            <td align="left">注：出生日期格式：2008-08-08</td>
          </tr>
          </table>
        <div class="h8">&nbsp;</div>
      <center>
       <input type="button" class="button_sea mr18" value="提交" onclick="mysubmit()"/>
       <input type="button" class="button_sea mr18" value="返回" onclick=""/>
      </center>
    </div>
</div>
</body>
</html>
