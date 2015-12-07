		<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="xcdno
		.id>0">编辑</ww:if><ww:else>新增</ww:else>行程单
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>

</head>
<script>	
	
		
		
		function checknum(id){
		
		
		if(document.getElementById(id).value==''){
		alert("起始或者终止号不能为空");
		return;
		}
		
		var starnum=document.getElementById("starnum").value;	
			var endnum=document.getElementById("endnum").value;		
			
			if(parseInt(starnum)>=parseInt(endnum)){
				alert("输入值错误,起始值大于等于终止值!");
				document.getElementById("sub").disabled="disabled";
				return;
			}else if(parseInt(endnum)-parseInt(starnum)>1000){
				alert("输入值错误,终止值比起始值大于1000!");
				document.getElementById("sub").disabled="disabled";
				return;
				
			}else{
				document.getElementById("sub").disabled=false;
			}
			
		
		var numinfo=document.getElementById(id).value;
		
			  $.ajax({
			      type:"POST",
			      async:false,
			      url:"xcdno!SearchNumInfo.action",
			      data:{s_numinfo:numinfo},
			      success:function(data){
			     
			      	if(data=='ok'){
			     
			      		//alert("该单号可以使用");
			      		document.getElementById("sub").disabled=false;
			      	}else{
			      	
			      	alert("该单号已经存在,请从新输入");
			      	document.getElementById("sub").disabled="disabled";
			      	return;
			      	}
			      }            
			      });
		
		
		}
		
		function checkNUMinfo(id){
			var starnum=document.getElementById("starnum").value;	
			var endnum=document.getElementById("endnum").value;		
			
			if(parseInt(starnum)>=parseInt(endnum)){
				alert("输入值错误,起始值大于等于终止值!");
				document.getElementById("sub").disabled="disabled";
				return;
			}else if(parseInt(endnum)-parseInt(starnum)>1000){
				alert("输入值错误,终止值比起始值大于1000!");
				document.getElementById("sub").disabled="disabled";
				return;
				
			}else{
			
				//document.getElementById("num").value=parseInt(endnum)-parseInt(starnum);
				document.getElementById("sub").disabled=false;
			}
		
		}
		
	</script>
<body>
<div id="member">
<form action="xcdno
		!<ww:if test="xcdno
		.id>0">edit.action?id=<ww:property value="xcdno
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" id="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="xcdno
		.id>0">编辑</ww:if><ww:else>新增</ww:else>行程单
		</span></b></td>
	</tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					开始号码
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="sno
						" value='<ww:property value="xcdno.sno"/>'" id="starnum" style="width: 300px"  maxlength="10" onchange="checknum('starnum');" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					结束号码
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="endno
						" value='<ww:property value="xcdno.endno
						"/>'" style="width: 300px" id="endnum"  maxlength="10" onchange="checkNUMinfo('endnum');" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					代理编号
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="agentcode
						" value='<ww:property value="xcdno.agentcode"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					OFFICE
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="officecode
						" value='<ww:property value="xcdno.officecode
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					填开单位
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="companyname
						" value='<ww:property value="xcdno.companyname"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					领单单位
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<select name="agentid">
				<ww:if test="getLoginsessionagent().agenttype==1">
				<option value="46" <ww:if test="xcdno.agentid==46">selected</ww:if>>北京发展宏图</option>
				</ww:if>
				<ww:iterator value="listCustomeragent">
				<option value="<ww:property value="id"/>" <ww:if test="id==xcdno.agentid">selected</ww:if>><ww:property value="agentcompanyname"/></option>
				</ww:iterator>
				</select>
					
				</td>
		</tr>
	

						 
		 <!--<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					创建人
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="userid
						" value='<ww:property value="xcdno.userid"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段1
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="param1
						" value='<ww:property value="xcdno.param1
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段2
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="param2
						" value='<ww:property value="xcdno.param2"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段3
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="param3
						" value='<ww:property value="xcdno.param3
						"/>'" style="width: 300px" />
				</td>
		</tr>
	
						 
				-->
				<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<select name="state">
				<option value="1" <ww:if test="xcdno.state==1">selected</ww:if> >启用</option>
				<option value="0" <ww:if test="xcdno.state==0">selected</ww:if>>停用</option>
				</select>
				</td>
			</tr>
	

		    
			<tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				<input type="submit"
							class="button_d font-bai" disabled="disabled" id="sub" value="提交"
							/ style="margin-right: 55px;"> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='xcdno.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
			</tr>
		</table>
		</td>
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
</table>
</form>
</div>
</body>
</html>



	