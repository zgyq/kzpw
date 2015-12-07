<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<LINK rel=stylesheet type=text/css href="style/text.css">  
  
<LINK rel=stylesheet type=text/css href="css/train.css">  

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<style>
.button1{background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;cursor:pointer;}
.val{color: red;}
</style>
<script type="text/javascript">
function updRoom(rid){
 window.location.href='customeragent!agentrequestinfo.action?id='+rid;
}
 //删除申请加盟商详细信息
function delAgent(rid){
 Ext.MessageBox.confirm("提示","确定删除本条记录？",function(obj){
 if(obj=='yes'){
 window.location.href='customeragent!delete.action?id='+rid;
 } 
 });
}
 //查看申请加盟商详细信息
 function showAgentInfo(id)
 {
    window.location.href='customeragent!toeditgent.action?compnayid='+id;
 }
</script>
</head>
<body>
<form action="#" id="form1" name="form1" method="post">
<div id="member" style="width: 100%">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;加盟商申请列表</b></td>
	</tr>
	<td>

	<table border='1' width="85%" style="text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px; line-height:28px;" cellpadding="0" cellspacing="0">
	<thead style="background: #f0f0f0">
	<th>公司名称</th>
	<th>申请类型</th>
	<th>申请时间</th>
	<th>联系人</th>
	<th>联系电话</th>
	<!--
	<th>地址</th>
	-->
	<!--<th>申请来源</th>
	--><th>操作</th>
	</thead>
	<tbody>
	<ww:iterator value="listCustomeragent">
	<tr>
	<td><ww:property value="agentcompanyname"/></td>
	<td><ww:property value="agenttype==2?'供应商':'采购商'"/></td>
	<td><ww:property value="formatTimestamp2(createtime)"/></td>
	<td><ww:property value="agentcontactname"/></td>
	<td><ww:property value="agentphone"/></td>
	<!--<td><ww:property value="agentaddress"/></td>
	<td>
	<ww:if test="parentname==null">
	 网络申请
	</ww:if>
	<ww:else>
	<ww:property value="parentname"/>
	</ww:else>
	</td>
	--><td valign="middle">
	<a  href="#" onclick="showAgentInfo(<ww:property value="id"/>);"><img src="images/sd.gif" style="cursor: pointer;"   title="审核"  align="absmiddle" />审核</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='delAgent(<ww:property value="id"/>)' href="javascript:void(0)"><img src="images/xxh.gif" style="cursor: pointer;"  title="删除"  />删除</a>
	</td>
	</tr>
	</ww:iterator>
	</tbody>
	</table>
	</td>
	</tr>
</table>

<div style="text-align: center; width: 100%; padding-top: 10px;">
		  <ww:property value="getPagination('\"customeragent!agentrequestlist.action?pageinfo.pagenum=\"+pageno')"/>
		</div>
</form>
</body>

</html>






