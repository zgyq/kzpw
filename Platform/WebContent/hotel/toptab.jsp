<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html" />

<title>无标题文档</title>
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<link href="css/base.css" rel="stylesheet" />
<style type="text/css">

.lj a{ text-decoration:none; color:#993300;}

.daoh{width:99%; margin-left:5px; height:30px;}
.daoh ul{ list-style-type:none; margin:0; padding:0;}
.daoh ul li{ float:left; background:url(../images/dda.gif) repeat-x;margin-right:5px;width:80px; line-height:27px;text-align:center; margin-top:3px;}
.daoh ul li a{ text-decoration:none; color:#069;}
.daoh ul li a:hover{ text-decoration:none; color:#fff; background:url(../images/dd.gif) repeat-x;  width:80px;  float:left; }
</style>

<script>
	
	function a(el,url)
	{
		var ls =	document.getElementsByTagName("li");
		var  i=0;
		for(i=0; i<ls.length; i++)
		{			
			ls[i].style.background="url(../images/dda.gif) repeat-x";
			ls[i].firstChild.style.color="#069";
			ls[i].firstChild.onmouseover = function(){this.style.color ='#fff';}
			ls[i].firstChild.onmouseout = function(){this.style.color ='#069';}
			
		}
		
		el.parentNode.style.background="url(../images/dd.gif) repeat-x"; 
		el.style.color="#FFF";
		
		el.onmouseout = function(){this.style.color ='#fff';}
		parent.bottom.location.href=url;
	}
 
 
 

</script>

</head>

<body style="font-size:12px; padding:0; margin:0;">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style=" background:url(../images/jb.gif);border:1px solid #99CBED">
 <tr>
   <td>    <div class="daoh">
<ul><!--
	<li style="background:url(../images/dd.gif) repeat-x; "><a
		href="javascript:" onclick="a(this,'hotelwholeorder.action');" style="color:#FFF;">订单查询</a></li>
	-->
	
	<!--<li><a href="javascript:" onclick="a(this,'hotelnoconfirmorder.action');" >等待处理</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelnoputupconfirmorder.action');" >已处理</a></li>
	
	<li><a href="javascript:" onclick="a(this,'hotelnoconfirmorder.action');" >已发确认单</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelnoputupconfirmorder.action');" ><span>待酒店回传确认单</span></a></li>
	<li><a href="javascript:" onclick="a(this,'hotelnoputupconfirmorder.action');" ><span>预订完成</span></a></li>
	<li><a href="javascript:" onclick="a(this,'hotelnoauditingorder.action');" >待审核</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelnoauditingorder.action');" >已入住</a></li>
	--><!--<li><a href="javascript:" onclick="a(this,'hotelquestionorder.action');" ><span>问题订单</span></a></li>

-->
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=1');" >等待处理</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=2');" >已处理</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=3');" >已发确认单</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=4');" ><span>确认已回传</span></a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=5');" ><span>预订完成</span></a></li>
	<!--<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=5');" >待审核</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=9');" >已入住</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=6');" >已取消</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=10');" >NS</a></li>
	<li><a href="javascript:" onclick="a(this,'hotelwholeorder.action?h_state=8');" >变更</a></li>

--></ul>
</div></td>
 </tr>
</table>
</body>
</html>
