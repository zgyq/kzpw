<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>机票B2B分销，酒店B2B分销，景点门票预订平台</title>
<link href="<%=request.getContextPath()%>/main_cx/css/global.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/jquery-1.4.1.min.js"></script>
<script
	src="<%=request.getContextPath()%>/main_cx/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/sideleft.js"></script>
<script src="<%=request.getContextPath()%>/main_cx/js/menu.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/lhgdialog.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/layout.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/main_cx/js/popup_layer.js"></script>
<script type="text/javascript">
        $(function () {
            //检测IE
            if ('undefined' == typeof (document.body.style.maxHeight)) {
                alert("您的浏览器版本太低了，请升级您的浏览器版本！");
                return false;
            }
            loadTopMenuTree(true);
            loadMenuTree(false, 24);
            new PopupLayer({ trigger: "#ele1", popupBlk: "#blk1", closeBtn: "#close1" });
            //弹窗公告
            showdialog();
        });
        function showdialog() {

            var content = "<div style='padding:5px'><br/><br/>" + $("#divNoticeContent").html()+"</div>";
            $.dialog({
                title: '消息公告',
                lock: true,
                content: content,
                button: [
                    {
                        name: '关闭窗口'
                    }
                ],
                width: '630px',
                height: 400,
                padding: '0px 0px',
                max: false,
                min: false
            });
        }
        
        function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);
 parent.member.location.href=../ba;
}
    </script>

</head>

<body>
<div class="g-doc f-cb" >

<div class="g-bd f-main f-cb" style="top: -10px;" id="f-nav">

<div class="g-sd" style="width: 218px;">
<div class="m-sd"><span class="f-com b5"></span>

<ww:iterator value="listRoot" status="kk">
<h3 id="h3_<ww:property value="#kk.index+1"/>"><a href="#" class=""><ww:property value="name"/></a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style="">
	<ww:iterator value="getListSub(id)" id="listServiceItems">
	<ww:if test="code.indexOf('http:')!=-1">
	<a href="#" onclick="tobase('../<ww:property value="code.trim()"/>');" class=""><ww:property value="name" /></a>
	</ww:if><ww:else>
	<a href="../<ww:property value="code.trim()"/>" target="member" class=""><ww:property value="name" /></a>
	</ww:else>
	
	</ww:iterator>
	</li>
	<li style=""></li>
</ul>
 <ww:if test="!#kk.last">
 	<ww:if test="#kk.index<7">
 	<span class="f-com b<ww:property value="#kk.index+1"/>"></span>
 	</ww:if><ww:else>
 	<span class="f-com b<ww:property value="#kk.index-1"/>"></span>
 	</ww:else>
 </ww:if>

</ww:iterator>


<!--
<h3 id="h3_20"><a href="#" class="">企业客户管理</a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style=""><a
		href="http://cx.soku5.net:8085/agents/Agent_list.aspx?bt=2"
		target="mainframe" class="">企业客户列表</a><a
		href="http://cx.soku5.net:8085/agents/Agent_edit.aspx?bt=2"
		target="mainframe" class="">添加企业客户</a></li>
	<li style=""></li>
</ul>
<span class="f-com b5"></span>
<h3 id="h3_9" class=""><a href="#" class="">加盟商管理</a><span
	class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li class="open" style="display: none;"><a
		href="http://cx.soku5.net:8085/agents/Agent_list.aspx?bt=3"
		target="mainframe" class="">省代理列表</a><a
		href="http://cx.soku5.net:8085/agents/Agent_edit.aspx?bt=3"
		target="mainframe" class="">添加省代理</a><a
		href="http://cx.soku5.net:8085/agents/Agent_list.aspx?bt=4"
		target="mainframe" class="">市代理列表</a><a
		href="http://cx.soku5.net:8085/agents/Agent_edit.aspx?bt=4"
		target="mainframe" class="">添加市代理</a><a
		href="http://cx.soku5.net:8085/agents/Agent_list.aspx?bt=1"
		target="mainframe" class="">分销商列表</a><a
		href="http://cx.soku5.net:8085/agents/Agent_edit.aspx?bt=1"
		target="mainframe" class="">添加分销商</a></li>
	<li class="open" style="display: none;"></li>
</ul>
<span class="f-com b2"></span>
<h3 id="h3_52" class="bg"><a href="#" class="">OEM账户管理</a><span
	class="side-d"></span></h3>
<ul class="f-cb-nav">
	<li style="display: list-item;" class="open"><a href="#"
		target="mainframe" class="checkin">OEM账户列表<span></span></a></li>
	<li style="display: list-item;" class="open"></li>
</ul>
<span class="f-com b7"></span>
<h3 id="h3_14"><a href="#" class="">供应商管理</a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style=""><a
		href="http://cx.soku5.net:8085/agents/supplier_list.aspx"
		target="mainframe" class="">供应商列表</a><a
		href="http://cx.soku5.net:8085/agents/supplier_add.aspx"
		target="mainframe" class="">添加供应商</a></li>
	<li style=""></li>
</ul>
<span class="f-com b3"></span>
<h3 id="h3_4"><a href="#" class="">员工管理</a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style=""><a
		href="http://cx.soku5.net:8085/employees/employee_list.aspx"
		target="mainframe" class="">员工列表</a><a
		href="http://cx.soku5.net:8085/employees/employees_edit.aspx?action=Add"
		target="mainframe" class="">员工开户</a><a
		href="http://cx.soku5.net:8085/employees/role_list.aspx"
		target="mainframe" class="">员工权限管理</a></li>
	<li style=""></li>
</ul>
<span class="f-com sc"></span>
<h3 id="h3_49"><a href="#" class="">QQ客服管理</a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style=""><a
		href="http://cx.soku5.net:8085/agents/qqtype_list.aspx"
		target="mainframe" class="">QQ客服类型管理</a><a
		href="http://cx.soku5.net:8085/agents/qq_list.aspx" target="mainframe"
		class="">QQ客服列表</a></li>
	<li style=""></li>
</ul>
-->
<span class="f-com sc"></span>
<h3 id="h3_49"><a href="#" class="">在线签约</a><span class="f-side"></span></h3>
<ul class="f-cb-nav">
	<li style=""><a href="../../interface/Alipayqian" target="_blank">支付宝签约</a></li>
	<li style=""></li>
</ul>
</div>
</div>
</div>



</div>

</body>
</html>
