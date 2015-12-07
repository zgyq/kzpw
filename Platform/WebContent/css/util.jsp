<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String webPath = request.getContextPath()+"/";
%>
<link href="<%=webPath %>js/ui/base/ui.custom.css" rel="stylesheet" type="text/css" />
<!--<script type="text/javascript" src="<%=webPath %>js/ui/custom.min.js"></script>-->
<script type="text/javascript" src="<%=webPath %>js/ui/ui.core.js"></script>
<script type="text/javascript" src="<%=webPath %>js/ui/ui.draggable.js"></script>
<script type="text/javascript" src="<%=webPath %>js/ui/ui.resizable.js"></script>
<script type="text/javascript" src="<%=webPath %>js/ui/ui.dialog.js"></script>
<script type="text/javascript" src="<%=webPath %>js/ui/jquery.bgiframe.js"></script>
<script type="text/javascript">
$(function() {
	$("#alert_dialog").dialog({
		bgiframe: true,
		autoOpen: false,
		resizable: false,
		draggable:false,
		modal: true,
		title: "温馨提示",
		height: 200,
		buttons: {
			'确定': function() {
				$(this).dialog('close');
			}
		}
		
	});
});
var _alert = alert;
window.alert = function(s) {		
	//_alert(s);
	$('#alert_dialog').text(s);
	$('#alert_dialog').dialog('open');
}
</script>
<div id="alert_dialog" title=""></div>


