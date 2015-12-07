<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
 
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
 
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script src="js/city-control/jquery.bgiframe.min.js"
	type="text/javascript"></script>
<link href="js/jqueryUI/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script> 
   //子页面操作父页面的菜单按钮，并切换导航
   function getParent()
    {            
     var oDoc = top.document; 
     //document.write(oDoc.body.innerHTML);  
     oDoc.documentElement.innerHTML;
     //获得父业面的菜单按钮
     var oTxt = oDoc.getElementById("txtParent");  
     }
     
     function chang(url,id){
     window.parent.topFrame.aaa(""+id+"");//头部导航选择
     //window.parent.frames.location.href="customeruser!foo.action?rightid="+id;//
     parent.left.location.href='customeruser!leftmenu.action?rightid='+id+'&forward=left.jsp';
     parent.member.location.href=url;
     //window.location.href=url;
     //window.parent.member=url;
     //
     
     }
</script>
<style type="text/css"> 
body{font-size:12px;font-family:"宋体";color:#000000;}
*{margin:0;padding:0;}
a{color:#0066CC;}
 
a:hover{color:#FF6600;}
.tit ul li{list-style:none;background:url(images/w.png);width:93px;height:33px;line-height:33px;float:left;text-align:center;color:#FFFFFF;}
.tit ul li a{text-decoration:none;display:block;width:93px;height:33px;text-align:center;line-height:33px;color:#FFFFFF;font-weight:bold;float:left;}
.tit{margin-top:90px;margin-left:193px;}
.back{width:100%;height:100%;background:url(images/b.png);margin:0 auto;border:1px solid #fff;background-color: #fff;}
 
.xf{position:relative;left:420px;bottom:5px;}
.xf ul li{list-style:none;float:left;margin-right:10px;}
.xf ul li a{text-decoration:none;text-align:center;line-height:33px;font-weight:bold;}
 
 
 h2	{font:normal 1.1em/1.5em arial;margin:14px 0 0 0;padding:4px 0;}
    div, p {font: normal 1em/1.3em arial;}
    textarea.terms {
    width:540px;
    height:280px;
 
    margin-left:10px;
    font:normal 11px/15px arial;
    padding:6px;
    color:#333;
    }
    div.terms {
     width:540px;
    height:240px;
 
     margin-left:10px;
  
    padding:6px;
    overflow:auto;
    }
.layer{width:565px;height:310px;background:url(images/2.jpg);margin-left:160px;margin-top:30px;position:relative;top:30px;left:-70px;!important ;_position:relative;top:30px;left:-150px;}
</style>
</head>
<body>
<div id="right" style="height: 99.7%;">
<div class="lit">

<ul>
	<li class="offwu"><a href="login!towelcome.action?first=true">公告信息</a></li>
   <li class="offwu"><a href="login!towelcome2.action?first=true">客服中心</a></li>
   
   
   
   
	<li><img src="imagess/jiao.gif" width="8" height="28" /></li>
	<li style="float: right;display: none" class="mr11"><img src="images/ptxz.png" style="cursor:pointer"
		onclick="showMsg()" width="59" height="23" class="mr8" /></li>
 
</ul>
</div>
<div class="back">
      <div class="tit" style="margin-left:100x;">
	     <ul>
		     <li>系统公告</li>
		 </ul>
	  </div>
     <div class="layer" style="margin-left:322px;">
	       <div class="terms" id="messdetail" style="margin-top:20px;">
				<div class='alertmsg'>
				<ww:iterator value="sysmessageList" status="ind">
				<p style="text-indent:2em;line-height:15px;"><a href="javascript:void(0)" onclick="messagedetail(0,'<ww:property value="id" />')"><ww:property value="#ind.index+1" />.&nbsp;&nbsp;<ww:property value="title" /></a></p>
				
				</ww:iterator>
				<br/>
				</div>
			
	 	 </div>
	 <div id="messtem" class="xf" style="display: none;">
	 
	      <ul>
	      <!--
		       <li><a href="javascript:void(0)" onclick="upMessagesystem();">上一条</a></li>
			   <li><a href="javascript:void(0)" onclick="nextMessagesystem();">下一条</a></li>
			   -->
			   <li><a href="login!towelcome.action">返回</a></li>
		  </ul>
	  </div>
	 
</div>
</div>
 
 
 
<script type="text/javascript"> 
	
	var messtem = new Array();
	var messarrays = new Array();
	var indextem;
	var index;
	
	//长度
	var msgcount=$(".alertmsg").length;
 
	$(document).ready(function(){
	
	return;
		
		//异步请求获取公告
			$.ajax({
				type:'POST',
				url:'login!ajaxsysmessage.action',
				success:function(data){
					messarrays = $.parseJSON(data);
					if(messarrays.length>0){
						index = messarrays.length-1;
						$("#contentshow").show();
						nextMessage();
					}
				}
			});
		
		
		
				messtem[0]=10087
		
		
	});
	
	//上一条
	function upMessage(){
		index--;
		if(index<0){
			index = messarrays.length-1;
		}
		var messarray =  messarrays[index];
		$("#title").html(messarray.title);
		$("#content").html(messarray.content);
	}
	
	//下一条
	function nextMessage(){
		index++;
		if(index==messarrays.length){
			index=0;
		}
		var messarray =  messarrays[index];
		$("#title").html(messarray.title);
		$("#content").html(messarray.content);
	}
	
	//关闭
	function colseMessage(){
		$("#contentshow").hide();
	}
	
	function nextMessagesystem(){
	   indextem++;
	   if(indextem==msgcount){
	   		indextem=0;
	   }
	   var id=messtem[indextem];
	   messagedetail(indextem,id);
	}
	
	
	function upMessagesystem(){
		indextem--;
		if(indextem<0){
			indextem=msgcount-1;
		}
	   var id=messtem[indextem];
	   messagedetail(indextem,id);
	}
	
	//显示详细公告信息
	function messagedetail(index,id){
		indextem=index;
		//获取公告的详细信息
		$.ajax({
			type:'POST',
			url:'login!ajaxsysmessageShow.action?sysmessage.id='+id,
			success:function(data){
				$("#messtem").show();
				//var json = eval("("+data+")");
				var systel=data.split('@')[0];
				var syscon=data.split('@')[1];
				var showmess = "";
				showmess+="<b><font color='red'>"+systel+"</font></b><br/><br/>";
				showmess+=syscon;
				$("#messdetail").html(showmess);
			}
		});
		
	}
	
	
	
	//点击平台须知
	function showMsg(){
		//异步请求获取公告
			$.ajax({
				type:'POST',
				url:'login!ajaxsysmessage.action',
				success:function(data){
					messarrays = $.parseJSON(data);
					if(messarrays.length>0){
						index = messarrays.length-1;
						$("#contentshow").show();
						nextMessage();
					}
				}
			});
	}
</script>
</body>
</html>

