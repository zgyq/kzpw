<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-包机服务</title>
<ww:head name="login"/>
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/provinceandcity/provinceandcity.js"></script>
</head>

<script>
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

  function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}
</script>


<body>
<div id="container">
     <ww:include page="../top.jsp?type=baoji"/>
    <!--includ top 直接替换掉整个DIV-->
</div>    
<!----------header over---------->
<div id="regsiter">
<form action="<%=request.getContextPath()%>/index!AddPlanservice.jspx" name="form1" method="post" id="form1">
    <div class="mt7 box">
        <div class="title">
               <font class="black low f mr15">填写包机申请</font>
               <font class="r mr25">欢迎使用${compname}包机服务，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="regsit">
            <ul>
             <li>
                 <font class="spacing3">出发时间</font>：
                 <input type="text" desc="用户名" class=" mlr15 text_regsit" id="planeservice.traveltime" name="s_traveltime" value="" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">选择你出行的时间。</font>
             </li>
             <li>
                 <font class="spacing3">回程时间</font>：
                 <input type="text" desc="密码" id="planeservice.returntime" class=" mlr15 text_regsit" name="s_returntime" value="" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd'})" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">选择你回程的时间。</font>
             </li>
             <li>
                 <font class="spacing3">出发城市</font>：
                 <input type="text" desc="出发城市" class=" mlr15 text_regsit validate[required]" id="planeservice.travelcity" name="planeservice.travelcity" value="" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写你的出发城市。</font>
             </li>
             <li>
                 <font class="spacing3">到达城市</font>：
                 <input type="text" desc="到达城市" id="planeservice.returncity" class=" mlr15 text_regsit validate[required]" name="planeservice.returncity" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写你的到达城市。</font>
             </li>
              <li>
                 <font class="spacing2">机型</font>：
                 <input type="text" desc="机型" id="model" class=" mlr15 text_regsit validate[required]" name="planeservice.model" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写需要的机型。</font>
             </li>
              <li>
                 <font class="spacing3">人数</font>：
                 <input type="text" desc="人数" id="num" class=" mlr15 text_regsit validate[required]" name="planeservice.num" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写这次出行的大致人数。</font>
             </li>
             
              <li>
                 <font class="spacing3">单位名称</font>：
                 <input type="text" desc="单位名称" id="unitname" class=" mlr15 text_regsit validate[required]" name="planeservice.unitname" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写贵单位的名称。</font>
             </li>
              <li>
                 <font class="spacing3">单位地址</font>：
                 <input type="text" desc="单位地址" id="address" class=" mlr15 text_regsit validate[required]" name="planeservice.address" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写单位的地址,以便我们好联系。</font>
             </li>
              <li>
                 <font class="spacing3">邮编</font>：
                 <input type="text" desc="邮编" id="zipcode" class=" mlr15 text_regsit validate[required]" name="planeservice.zipcode" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写邮编,以便我们方便联系。</font>
             </li>
             
              <li>
                 <font class="spacing3">电话</font>：
                 <input type="text" desc="电话" id="tel" class=" mlr15 text_regsit validate[required]" name="planeservice.tel" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写单位的联系电话。</font>
             </li>
              <li>
                 <font class="spacing3">传真</font>：
                 <input type="text" desc="传真" id="fax" class=" mlr15 text_regsit validate[required]" name="planeservice.fax" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">填写单位的联系传真。</font>
             </li>
             <li>
                 <font class="spacing3">联系人姓名</font>：
                 <input type="text" id="name" desc="姓名" class=" mlr15 text_regsit validate[required]" name="planeservice.name" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">请填写您的联系手机号。</font>
             </li>
             <li>
                 <font class="spacing3">联系人手机号</font>：
                 <input type="text" id="mobile" desc="手机号" class=" mlr15 text_regsit validate[required]" name="planeservice.mobile" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">请填写您的联系手机号。</font>
             </li>
             <li>
                 <font class="spacing3">联系人邮箱</font>：
                 <input type="text" id="mailbox" desc="邮箱" class=" mlr15 text_regsit validate[required]" name="planeservice.mailbox" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">请填写你的联系邮箱。</font>
             </li>
             
              <li>
                 <font class="spacing3">其他说明</font>：
                 
                 
                 
                 <input size="" type="text" id="remarks" dclass=" mlr15 text_regsit " name="planeservice.remarks" />
                 <font class="fontxing"></font>&nbsp;<font class="c999">如有其他说明或者要求,请在这填写。</font>
             </li>
             
             
             <li>
                 <font class="spacing3">验证码</font>：
                 <input type="text" class=" mlr15 text_regsit validate[required,custom[onlyNumber]" style="width:70px;" name="validateImg"  id="validateImg" desc="验证码" />
                 <img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" />
                 &nbsp;&nbsp;<font class="c999">如看不清图片，可点击图片刷新验证码。</font>
             </li>
             <li class="bnt" style="height:120px;">
            <span class="f"> 使用条款：<input name="" type="radio" disabled value="" checked />我已看过并同意<a href="#" class="fontun06c">《${compname}服务协议》</a><br/>
             <input type="submit" class="button_login " value="立即提交" /></span>
             <span class="r msger">&nbsp;</span>
             </li>
             
            </ul>                                                   
        </div>
     </div>
   </form>
</div>
<ww:include page="../footer.jsp"/>
</body>
</html>
