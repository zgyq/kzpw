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
<style type="text/css">
.tda{
border:solid 1px #a0cfee;
background:#e2f4fe;
}
.tdb{
border:solid 1px #a0cfee;
text-align:left;
padding-left:10px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="insuranceinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>保险</title>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script>

$(document).ready(function() {
			$("#insurform").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable				
				document.insurform.submit();
				}
			}) 
});

 function datacheck()
 {
    var reg=/^[1-9][0-9]*$/;
 
    if($("#companyname").val()=="")
    {
       alert("保险公司名称不能为空!");
       $("#companyname").focus();
       return false;
    }
    if($("#insurancename").val()=="")
    {
       alert("保险名称不能为空!");
        $("#insurancename").focus();
       return false;
    }
    if($("#insurancefee").val()=="")
    {
       alert("保险费不能为空!");
        $("#insurancefee").focus();
       return false;
    }
    else
    {
       if(!reg.exec($("#insurancefee").val()))
       {
          alert("保险费必须为数字，请重试!");
           $("#insurancefee").focus();
           return false;
       }
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="insuranceinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>保险</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="insurform" id="insurform" method="post" action="insuranceinfo!<ww:if test="insuranceinfo!=null&&insuranceinfo.id>0">edit.action</ww:if><ww:else>add.action</ww:else>">
		<table width="100%" border="0"  cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
		<tr><td height="5px" colspan="100">&nbsp;</td></tr>		
		<tr>
			  <td align="right" style="width: 100px;">乘机人：</td>
			  <ww:iterator value="insurancelist" status="pstatu">
			  <td style="text-align:left;width: 100px">
			 
			  <input value="<ww:property value="id"/>" name="passengerid" onclick='showInsur("<ww:property value="id"/>",this.checked)' checked="checked" type="checkbox"/>&nbsp;<ww:property value="beibaoren"/></td>
			 
			  </ww:iterator>
			</tr>
		</table>
		<table width="100%" border="0"  cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
			<tr><td height="30px">&nbsp;
			
			</td></tr>
			<ww:iterator value="insurancelist" status="statu">			
			<tr>			
				<td height="100%" align="center" colspan="100">
				<input type="hidden" name="temppid<ww:property value="id"/>" value='<ww:property value="insurancemoney"/>'/>
				<div class="insurdiv" id="div<ww:property value="id"/>">
				<table id="twotable<ww:property value="id"/>" width="95%" border="" cellpadding="0" cellspacing="0">
					<tr>
						<td  height="28" align="right" class="tda"><span>保险公司名称：</span></td>
						<td class="tdb">
						<select name="companyname<ww:property value="id"/>" style="width: 200px">
						<option value="中保人寿" <ww:if test='companyname.equals("中保人寿")'>selected="selected"</ww:if>>中保人寿</option>
						<option value="太平洋保险" <ww:if test='companyname.equals("太平洋保险")'>selected="selected"</ww:if>>太平洋保险</option>
						</select>
						&nbsp;&nbsp;
						<span style="color:red">*</span></td>
					    <td height="28" align="right" class="tda"><span>产品：</span></td>
						<td class="tdb">
						<select type="text" id="insurancename<ww:property value="id"/>"  desc="产品"   name="insurancename<ww:property value="id"/>"
					        style="width:200px"> 
					        <option <ww:if test='insurancename.equals("中保人寿航空意外险")'>selected="selected"</ww:if>>中保人寿航空意外险</option>
					        <option <ww:if test='insurancename.equals("太平洋保险航空意外险")'>selected="selected"</ww:if>>太平洋保险航空意外险</option>
					        </select>
					        &nbsp;&nbsp;<span style="color:red">*</span>
					</tr>

					<tr>
						<td height="28" align="right" class="tda" ><span>保单号：</span></td>
						<td class="tdb"><input id="ordernumber<ww:property value="id"/>"  name="ordernumber<ww:property value="id"/>"
							value='<ww:property value="ordernumber"/>'
							 style="width: 200px" /> &nbsp;&nbsp;</td>
						<td height="28" align="right" class="tda"><span>单证号：</span></td>
						<td class="tdb"><input id="danzhenghao<ww:property value="id"/>"  name="danzhenghao<ww:property value="id"/>"
							value='<ww:property value="danzhenghao"/>'
							style="width: 200px" /></td>
					</tr>
					
					<!-- 日期控件： onfocus="WdatePicker()" -->
					<tr>
						<td height="28" align="right" class="tda"><span>起保日期：</td>
						<td class="tdb"><input readonly="readonly" id="createtime<ww:property value="id"/>" desc="起保日期"
						 name="createtime<ww:property value="id"/>" value='<ww:property value="formatTimestamp2(createtime)"/> 00:00:00'
							 style="width: 200px" />&nbsp;&nbsp;<span style="color:red">*</span></td>
					<td height="28" align="right" class="tda"><span>生效日期：</span></td>
						<td class="tdb"><input  readonly="readonly" type="text" require="true" dataType="Require"
							 name="validdate<ww:property value="id"/>"
							 id="validdate<ww:property value="id"/>" desc="生效日期"
							value='<ww:property value="formatTimestamp2(createtime)"/> 00:00:00'
							style="width: 200px" />&nbsp;&nbsp;<span style="color:red">*</span></td>
					</tr>
					<tr>
						<td height="28" align="right" class="tda"><span>终止日期：</span></td>
						<td class="tdb">
						<input type="text" readonly="readonly"  name="zhongzhidate<ww:property value="id"/>"
							value='<ww:property value="formatTimestamp2(enddate)"/> 23:59:59'
							id="zhongzhidate<ww:property value="id"/>" desc="终止日期"
							style="width: 200px" />&nbsp;&nbsp;<span style="color:red">*</span></td>
						<td height="28" align="right" class="tda"><span>受益人指定方式：</span></td>
						<td class="tdb">法定 </td>
					</tr>
					<tr>
						<td height="28" align="right" class="tda"><span>投保人：</span></td>
						<td class="tdb"><input  id="danbao<ww:property value="id"/>"
							desc="投保人"  name="toubaoren<ww:property value="id"/>"
							value='<ww:property value="toubaoren"/>'
							 style="width: 200px" />&nbsp;&nbsp;<span style="color:red">*</span></td>
							<td class="tda" height="28" align="right"><span>被保人：</span></td>
						<td class="tdb"><input  id="beibao<ww:property value="id"/>"
							desc="被保人" name="beibaoren<ww:property value="id"/>"
							value='<ww:property value="beibaoren"/>'
							" style="width: 200px" />&nbsp;&nbsp;<span style="color:red">*</span> </td>
					</tr>

					<tr>
					<td class="tda" align="right">保险份数：</td>
					<td style="text-align: left;padding-left: 7px" class="tdb"><input style="width: 30px" name="insurancenum<ww:property value="id"/>" id="insurancenum<ww:property value="id"/>"  value="<ww:property value="insurancenum"/>"/>份</td>
						<td height="28" align="right" class="tda"><span>总保费：</span></td>
						<td class="tdb"><input type="text" desc="总保费"  id="insurancefee<ww:property value="id"/>" name="insurancefee<ww:property value="id"/>"
							value='<ww:property value="insurancefee"/>'
							 style="width: 200px" /> &nbsp;&nbsp;<span style="color:red">*</span></td>
							
					</tr>


					<tr>
						<td height="28" align="right" class="tda"><span>备注说明：</span></td>
						<td class="tdb">
						   <textarea name="description<ww:property value="id"/>" rows="5" cols="30">
						     <ww:property value="insuranceinfo.description"/>
						   </textarea>
						
						</td>
					</tr>
					
				</table>
			</div>
				</td>
				
			</tr>
				</ww:iterator><!-- 循环节结束 -->
		<tr class="font-blue-xi">
			<td height="46" scrolling="no" style="padding-left: 30px">
			<input type="submit"class="button_d font-bai" value="提交" /> 
			<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='insuranceinfo.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
		</table>
		
		</form>
		</td>
	</tr>
</table>
</div>
<script type="text/javascript">
function showInsur(id,check){
if(check==true){//onlyNumber 
Ext.fly("twotable"+id).select("input").addClass("validate[required]");
$("#ordernumber"+id).removeClass("validate[required]");
$("#danzhenghao"+id).removeClass("validate[required]");


Ext.getDom(Ext.fly("insurancefee"+id)).setAttribute("class","validate[required,custom[onlyNumber]]");
Ext.getDom(Ext.fly("insurancenum"+id)).setAttribute("class","validate[required,custom[onlyNumber]]");
$("#div"+id).show();
}else{
Ext.fly("twotable"+id).select("input").removeClass("validate[required]");
$("#insurancefee"+id).removeClass("validate[required]");
$("#beibao"+id).removeClass("validate[required]");
$("#danbao"+id).removeClass("validate[required]");
$("#zhongzhidate"+id).removeClass("validate[required]");
$("#validdate"+id).removeClass("validate[required]");
$("#createtime"+id).removeClass("validate[required]");
$("#insurancename"+id).removeClass("validate[required]");

$("#insurancenum"+id).removeClass("validate[required]");
$("#div"+id).hide();
}
$("#insurform").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.insurform.submit();
				}
				
			}) ;

}
			
</script>
</body>
</html>


