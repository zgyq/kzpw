<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-首页</title>
<link href="<%=request.getContextPath()%>/theme/pshl/skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/theme/pshl/skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/theme/pshl/skin/blue/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/style/tip-yellowsimple.css" rel="stylesheet" type="text/css" title="no title" charset="utf-8" />
<link href="<%=request.getContextPath()%>/skin/blue/css/citycontrol.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/tip/tip.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery/jquery.poshytip.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/jquery.blockUI.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/PublicJs.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/aircity.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/j.dimensions.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/j.suggest.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/query.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/interaircity.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/citycontrol/index.js" type="text/javascript"></script>
<script type="text/javascript">
    var commonallcity=new Array(); 
    var allcity=new Array(); 
function lodimage(index){

	for(i=1;i<=4;i++){
	
		 //$("#sp"+i).removeClass('nuber_on fff');
		 //$("#sp"+i).removeClass('nuber_out');
		document.getElementById("sp"+i).className="f nuber_out";
		 $("#image"+i).hide();
	}
	document.getElementById("sp"+index).className="f nuber_on fff";
	 //	$("#sp"+index).addClass('f nuber_on fff');
 		$("#image"+index).show();
}

<!--
    //页面加载
    $(document).ready(function()
	   {
	    commonallcity=commoncitys;
	    allcity= citys;
	    $("#rdoTicketTypeinter").click(function(){
	        commonallcity=intercommoncitys;
	        allcity=intercitys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	     $("#rdoTicketTypelocal").click(function(){
	        commonallcity=commoncitys;
	        allcity=citys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	    //加载城市控件数据
	    $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
	    
	    
	     
       //默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  $("#txtstartdate").val(str);
	  
	  
	 });
	 //返程显示隐藏
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#li_returndate").hide();
	    }
	    else if(index==2)
	    {
	       $("#li_returndate").show();
	    }
	 }
	
-->


</script>
</head>

<body>
<div id="index">
  <div class="center"><iframe src="<%=request.getContextPath()%>/theme/pshl/top.html" scrolling="no" hspace="0" frameborder="0" width="1004" height="106"></iframe></div>
  <div id="middle">
     <div class="middle"> 
     <div class="left f">
     <form action="<%=request.getContextPath()%>/login!Login.jspx" name="form2" method="post" id="form2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="40" width="50">用户名：</td>
            <td><input type="text" class="input" id="uname" title="用户名不能为空!" name="loginname" value="<ww:property value="customeruser.loginname"/>"  /></td>
          </tr>
          <tr>
            <td height="40">密&nbsp;&nbsp;&nbsp;码：</td>
            <td><input type="password" title="密码不能为空!" class="input"  id="logpassword" name="logpassword" value="<ww:property value="customeruser.logpassword"/>" /></td>
          </tr>
          <tr>
            <td height="40">验证码：</td>
            <td><input type="text"  title="验证码不能为空!" id="validateImg" name="validateImg" class="input70"  /><img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></td>
          </tr>
        </table>
        </form>
        <div><input type="button" id="btnlogin" onclick="return sub();" style="margin-left:-15px; margin-top:15px;" class="bnt" value="登录" /><input type="button" class="bnt" value="注册" onclick="javascript:window.location.href='<%=request.getContextPath()%>/login!toRegsit.jspx'" style="margin-left:5px; margin-top:15px;" /></div>
     </div>
     <div class="right f">
        <div class="nav">
          <ul>
          <li class="f navon"><a href="#" class="fff14">国内机票</a></li>
          <li class="f navout"><a href="#" class="fff14">国际机票</a></li>
          <li class="f navout"><a href="http://travel.elong.com/hotel/?campaign_id=4054457" class="fff14">酒店预定</a></li>
          </ul>
        </div>
        <form name="form1" id="form1" method="post">
        <input style="display:none" name="TicketType" id="rdoTicketTypelocal" name="tickettype"
			type="radio" value="0" checked="checked"/> 
        <input name="TicketType" style="display:none" id="rdoTicketTypeinter"
			type="radio" value="1" name="tickettype"/>
			<input name="s_traveltype" id="rdoOneWay" style="display:none"
		type="radio" value="1" onclick="bindFlightType(1);" /> 
		 <input style="display:none"
		name="s_traveltype" id="rdoRoundWay" type="radio" value="2"
		checked="checked" onclick="bindFlightType(2);" />
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="lh30 mt20">
          <tr>
            <td width="61">出发城市：</td>
            <td width="80"><input
			type="text" id="txtDepCity" name="s_depcityname" class="input_city"
			value="" title="请选择出发城市" />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="s_depcitycode" value="" /></td>
            <td width="23"><img src="<%=request.getContextPath()%>/theme/pshl/skin/blue/images/to.gif" width="20" height="20" /></td>
            <td width="61">到达城市：</td>
            <td><input
			type="text" id="txtArrCity" name="s_arrcityname" class="input_city"
			value="" title="请选择到达城市" />
			<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hidArrCity" name="s_arrcitycode" value="" /></td>
          </tr>
          <tr>
            <td>出发时间：</td>
            <td><input
			type="text" id="txtstartdate" name="s_startdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="input_time" value="" title="请选择出发时间" /></td>
            <td><img src="<%=request.getContextPath()%>/theme/pshl/skin/blue/images/to.gif" width="20" height="20" /></td>
            <td>返程时间：</td>
            <td><input
			type="text" id="txtbackdate" name="s_backdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="input_time" value="" /></td>
          </tr>
          <tr>
            <td>航空公司：</td>
            <td colspan="4">
            <select name="" class="sele">
			<option value="">---所有航空公司---</option>
			<ww:iterator value="listAirCompany">
				<option value="<ww:property value='aircomcode' />"><ww:property
					value="aircomcode" /><ww:property value="aircomcnname" /></option>
			</ww:iterator>
		</select>
            </td>
          </tr>
          <tr>
            <td colspan="5" class="pbnt"><input type="button" class="bnt_sea" value="立即查询" onclick="search();"  /><font class=" mlr15">如需帮助，请拨打咨询热线010-68176575！</font> </td>
          </tr>
        </table>
       </form>
     </div>
     <div class="c"></div>
  </div>
  <div id="po">
  <a href="index!toindex.jspx"><img src="<%=request.getContextPath()%>/theme/pshl/skin/blue/images/airpo.gif" width="262" height="130" style="margin-left:212px;" /></a>
  <a href="http://travel.elong.com/hotel/?campaign_id=4054457"><img src="<%=request.getContextPath()%>/theme/pshl/skin/blue/images/hotelpo.gif" width="262" height="130" style="margin-left:82px;" /></a></div>
  </div>
    <div class="center"><iframe src="<%=request.getContextPath()%>/theme/pshl/bottom.html" scrolling="no" hspace="0" frameborder="0" width="1004" height="42"></iframe></div>
</div> 
</body>
</html>

<script>
  function freshvalidate()
{

	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
		
}
function sub(){
 if($("#uname").val()==""){  
	 //验证提示
	 $('#uname').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
			
			
			
	 // $('#uname').poshytip({
	//			content: "此乘机人已经存在，请重新选择!",
	//			showOn: 'focus',
	//			alignTo: 'target',
	//			alignX: 'right',
	//			alignY: 'center',
	//			offsetX: 5
	//		    });
			    
	$("#uname").focus();
	 return false; 
	 }
	 
	 
			    
			    
	 
	 
 if($("#logpassword").val()==""){  
	 //验证提示
	 $('#logpassword').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#logpassword").focus();
	 return false; 
	 }
	 
	  if($("#validateImg").val()==""){  
	 //验证提示
	 $('#validateImg').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			});
	$("#validateImg").focus();
	 return false; 
	 }
	 
	  document.form2.submit();
}

</script>
