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
<title><ww:if test="liudianrefinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>分公司留点设置</title>
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
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
<script type="text/javascript">
function dispose(message) {
		   Ext.MessageBox.show({
		           msg: message+', 请稍后......',
		           progressText: 'Saving...',
		           width:300,
		           wait:true,
		           waitConfig: {interval:200},
		           icon:'ext-mb-download',
		           animEl: 'mb7'
		       });
		}
		function colsedispose(){
		 Ext.MessageBox.hide();
		}
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
 //验证是否选择留点类型
  var typeid=document.getElementById("typeid").value;
  //alert(typeid);
  // return false;
  if(typeid=='-1'){
  alert("请对下级选择一个留点类型!");

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

function lod(a){
 
	var typeid=$("#typeid").val();
	//alert(a);
	
	if(typeid!='-1'){
	dispose('正在加载该留点设置详细信息');
	
      $.ajax({
	    type:"POST",
	    url:"liudianinfo!AjaxLodLiuDianRecodeByTypeID.action",
	    data:{ajax_typeid:typeid},
	    async:false,         
	    success:function(data){
	    colsedispose();
	     $("#divliudianinfo").html(data);	
	      document.getElementById("submit").disabled="";
	    }            
	    });
	    
    }else{
    	
	    colsedispose();
	    <ww:if test="liudianrefinfo.typeid!=null">
	    alert("请选择一个留点类型!!!");
	    </ww:if>
	     
	    
	   
	     $("#divliudianinfo").html("");	
	     
	     document.getElementById("submit").disabled="disabled";
     
    }
    
}
function nodelete(){

alert("不能删除!!!");
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;设置加盟商留点</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="liudianinfo!<ww:if test="liudianrefinfo.id>0">edit.action?id=<ww:property value="liudianrefinfo.id"/></ww:if><ww:else>add.action</ww:else>"
			name="form1" method="POST" onsubmit="dispose('正在提交数据');">


        <input type="hidden" name="lagentid" value='<ww:property value="lagentid" />' />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						    <tr><td align="center">
						    <table width="100%" border="0" cellspacing="0" cellpadding="0">
						    <tr>
						    <td>
						       <span style="font-size:13px">提示：如果您还没有维护留点类型，请点击此处<a style="color:red;font-weight:bold;text-decoration: underline" href="settlementtype.action?">留点类型维护</a>先维护留点类型！<br /><br /></span>
						      
						      </td>
						      </tr>
						      </table>
						      </td>
						    </tr>
							<tr>
								<td align="center">
								<table width="60%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td align="right" width="20%" class="table_color_r colortrin">加盟商名称：</td>
										<td align="left" width="30%" class="table_color_l"
											style="color: red; font-weight: bold">
											<ww:if test="lagentid!=0">
											<ww:property value="getagentname_b2bback(lagentid)" />
											<input type="hidden" name="agentid" value="<ww:property value="lagentid"/>" />
										</ww:if><ww:else>
											<ww:property value="getagentname_b2bback(#session.loginuser.agentid)" />
											<input type="hidden" name="agentid" value="<ww:property value="#session.loginuser.agentid"/>" />
										</ww:else>
										
										</td>
										<td align="right" width="20%" class="table_color_r colortrin">留点名称：</td>
										<td align="left" width="30%" class="table_color_l">
										<select id="typeid" name="typeid" style="width: 150px" onchange="lod(2);">
											<option value="-1"  <ww:if test="liudianrefinfo.typeid==null">selected</ww:if>>请选择留点类型</option>
										<ww:iterator value="listsettle">
											
											<option value="<ww:property value="id" />"  <ww:if test="id==liudianrefinfo.typeid">selected</ww:if>><ww:property value="typename" /></option>
										</ww:iterator>
										</select></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td height="10px"></td>
							</tr>
						</table>
						</td>
					</tr>
                   <tr>
                   <td align='center' colspan='2'>
			       <div id="divliudianinfo" ></div>
			       </td>
                    </tr>
				
						
							
							
					<tr class="font-blue-xi">
						<td height="20" rowspan="2"></td>
						<td height="46" style="padding-left: 120px">&nbsp;<input
							type="submit" id="submit" onclick="return checkdata();"
							class="button_d font-bai" value="提交" /> 
							&nbsp;&nbsp;
							<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customeragent!tofenxiao.action?agenttype=3';"
							name="Submit2" value=" 返回 " />
							&nbsp;&nbsp;
						   
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
<div>
</div>

</body>
</html>
<script type="text/javascript">
lod(1);
</script>
