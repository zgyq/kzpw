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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="settlementtype.id>0">查看</ww:if><ww:else>新增</ww:else>结算分类表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript">
var idnumber=1;
function addrecord()
{
   var strhtml="";
   idnumber++;
   strhtml+="<tr id='hidid_"+idnumber+"'>";
   strhtml+="<td width='20%'>"+idnumber+"<input type='hidden' name='tempid' value='0' /></td>";
   strhtml+="<td width='20%'><input type='text' name='fandianstart' style='width:100px' value='' />%</td>";
   strhtml+="<td width='20%'><input type='text' name='fandianend' style='width:100px' value='' />%</td>";
   strhtml+="<td width='20%'><input type='text' name='liudian' style='width:100px' value='' /></td>";
   strhtml+="<td width='20%'><a href='#' onclick='addrecord();'><img src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='delrecord("+idnumber+");'><img src='images/del.gif' />删除</a></td>";
   strhtml+="</tr>";
   $("#tbrecord").html($("#tbrecord").html()+strhtml);
   
}
function delrecord(id)
{
   $("#hidid_"+id).remove();
}
//表单验证
function checkdata()
{
  if($("#typename").val()=="")
  {
      alert("类型名称不能为空，请重新输入！");
        return false;
  }
  //验证返点始
  var fandianstartarr=document.getElementsByName("fandianstart");
  //验证返点止
  var fandianendarr=document.getElementsByName("fandianend");
  //验证留点
  var liudianarr=document.getElementsByName("liudian");
  //id值
  var idarr=document.getElementsByName("tempid");
  
  var strfandianstart="";
  var strfandianend="";
  var strliudian="";
  var strid="";
  for(var i=0;i<fandianstartarr.length;i++)
  {
     
     if(fandianstartarr[i].value=="")
     {
        alert("返点始为必填项，请重新输入！");
        return false;
     }
     strfandianstart+=fandianstartarr[i].value+",";
  }
  
  for(var i=0;i<fandianendarr.length;i++)
  {
     if(fandianendarr[i].value=="")
     {
        alert("返点止为必填项，请重新输入！");
        return false;
     }
      strfandianend+=fandianendarr[i].value+",";
  }
  
  for(var i=0;i<liudianarr.length;i++)
  {
     if(liudianarr[i].value=="")
     {
        alert("留点为必填项，请重新输入！");
        return false;
     }
     strliudian+=liudianarr[i].value+",";
  }
  
  for(var i=0;i<idarr.length;i++)
  {
     strid+=idarr[i].value+",";
  }
  
  
  //对隐藏于赋值
  $("#s_fandianstart").val(strfandianstart);
  $("#s_fandianend").val(strfandianend);
  $("#s_liudian").val(strliudian);
  $("#s_id").val(strid);
  
  
  
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
			test="settlementtype.id>0">查看</ww:if><ww:else>新增</ww:else>结算分类表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="settlementtype!add.action?id=<ww:property value="id"/>&<ww:property value="url"/>"
			name="form1" method="POST">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="256" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>结算分类名称：</span></td>
						<td><ww:property value="settlementtype.typename"/></td>
					</tr>
					<tr>
						<td height="10" colspan="2" align="center"><span style="color:red;font-weight:bold">留点设置</span></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
						<table width="60%" cellspacing="0" cellpadding="0" border="1"
									class="table_color">
									<tr class="tbody_color" style="font-weight: bold">
										<td width="20%" align="center">序号</td>
										<td width="20%" align="center">返点始</td>
										<td width="20%" align="center">返点止</td>
										<td width="20%" align="center">留点</td>
									
									</tr>
									<tr>
										<td colspan="4">
										<table id="tbrecord" width="100%" cellspacing="0"
											cellpadding="0" border="0">
											<ww:if test="listrecord.size!=0">
												<ww:iterator value="listrecord" status="recstatus">
													<tr>
														<td width="20%"><ww:property
															value="#recstatus.index+1" />
														
														</td>
														<td width="20%"><ww:property value="formatMoney(fandianstart)" />%</td>
														<td width="20%"><ww:property value="formatMoney(fandianend)" />%</td>
														<td width="20%"><ww:property value="formatMoney(liudian)" /></td>
														
													</tr>
												</ww:iterator>
											</ww:if>
											<ww:else>
												<tr id='hidid_1'>
													<td width="20%" colspan="4">暂无留点信息
													</td>
											</ww:else>
										</table>
										</td>
										<input type="hidden" id="s_fandianstart" name="s_fandianstart"
											value="" />
										<input type="hidden" id="s_fandianend" name="s_fandianend"
											value="" />
										<input type="hidden" id="s_liudian" name="s_liudian" value="" />
										
										<input type="hidden" id="s_id" name="s_id" value="" />
									</tr>
								</table>
						</td>
						
					</tr>
					
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


