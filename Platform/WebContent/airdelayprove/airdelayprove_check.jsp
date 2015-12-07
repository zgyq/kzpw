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
<title><ww:if test="airdelayprove
		.id>0">编辑</ww:if><ww:else>新增</ww:else>航班延误证明
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div id="member">
<form enctype="multipart/form-data" action="airdelayprove
		!<ww:if test="airdelayprove
		.id>0">edit.action?id=<ww:property value="airdelayprove
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="airdelayprove
		.id>0">编辑</ww:if><ww:else>新增</ww:else>航班延误证明
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
					航班号
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="airdelayprove.airnum"/>
				</td>
		
		<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					PNR信息
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="airdelayprove.pnr"/>
				</td>
						 
				<!--<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					加盟商ID
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="angentid
						" value='<ww:property value="airdelayprove.angentid
						"/>'" style="width: 300px" />
				</td>
		--></tr>
	

						 
		 <tr>
			
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					起飞时间
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l " align="left">
					<ww:property value="airdelayprove.stime
						"/>
				</td>
				
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					 下载附件:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<ww:if test="airdelayprove.urldesc!=null">
												<a target="_blank" id="lbtnUpLoad" href="AirFile/<ww:property value="airdelayprove.urldesc" escape="false" />">下载附件</a>
												</ww:if><ww:else>
												暂无附件
												</ww:else>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					航班延误信息
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
				
				<ww:property value="airdelayprove.descinfo"/>
					
				</td>
		
	
						 
				
		</tr>
		
		<tr>
		
		<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					 备注
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
				
				<ww:property value="airdelayprove.remark"/>
					
				</td>
				
				
		
		
		</tr>
	
						 
				<!--<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="state
						" value='<ww:property value="airdelayprove.state
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					创建人id
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="memberid
						" value='<ww:property value="airdelayprove.memberid"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				</td>
		</tr>
	
					

		    
			-->
			
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


	