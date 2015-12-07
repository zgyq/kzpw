<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—商旅平台</title>


<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/easySlider1.5.js"></script>
<script type="text/javascript" src="js/accordian.pack.js"></script>
</head>
<script type="text/javascript">
		
			function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);
 parent.member.location.href=ba;
}
		</script>
<body onload="new Accordian('basic-accordian',5,'header_highlight');">

<div class="main_left" id="LeftBox">
    <div id="left">
      <div id="basic-accordian" >
      <ww:iterator value="listRoot" status="kk">
        <div class="nav">
          <div id="test<ww:property   value="#kk.index"/>-header" class="accordion_headings"><span class="nav_0<ww:property   value="#kk.index+1"/>"></span><ww:property value="name"/></div>
          <div id="test<ww:property   value="#kk.index"/>-content">
            <div class="nav_list">
              <ul>
                <ww:iterator value="getListSub(id)" id="listServiceItems">
                <li>
               <ww:if test="code.indexOf('http:')!=-1">
									<a href="<ww:property value="code.trim()"/>" target="member" >
									<ww:property value="name" /></a>
									</ww:if><ww:else>
									<a href="#"  onclick="tobase('../<ww:property value="code.trim()"/>');">
									<ww:property value="name" /></a>
									</ww:else>
                </li>
                </ww:iterator>
                
              </ul>
              <div class="clear"></div>
            </div>    
          </div>
          <div class="clear"></div>
        </div>
        </ww:iterator>
        
        
        
        
        
        
        <div class="clear"></div>
      </div>
      <div class="clear"></div>
      <div class="pay">
        <div class="pay_header">支付宝信息</div>
        <div class="pay_con">
          <ul>
            <li><a href="https://www.99bill.com/" target="_blank" ><img src="images/pay_01.jpg" /></a></li>
            <li><a href="https://lab.alipay.com/user/reg/index.htm" target="_blank"  ><img src="images/pay_02.jpg" /></a></li>
            <li><a href="http://www.chinapnr.com/" target="_blank"  ><img src="images/pay_03.jpg" /></a></li>
          </ul>
          <div class="clear"></div>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</body>
</html>
