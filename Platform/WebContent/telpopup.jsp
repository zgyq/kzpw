<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="pragma" content="no-cache" />

<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全-V2.0</title>
<style type="text/css">
.passtable{
border-collapse:collapse;
border:none;
}
.passtd{
border:solid #99CCFF 1px;
}
</style>
<script src="js/jquery1.3.2.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<script>
//divorderinfo
function vpass(id){
var strval=$("#pass"+id).val();
      if(strval==""){
      if(id==1)
      $("#vpass1").html("请输入原始密码！");
      if(id==2)
       $("#vpass2").html("请输入新密码！");
      if(id==3){
       if($("#pass2").val()!="")
       $("#vpass3").html("请再次输入新密码！");
       }     
      return false;
      }else {
      $("#vpass"+id).html("");
      if(id==1){
         jQuery.post("customeruser!ajaxIsRrigthPassword.action",{clientpwd:strval},function(data){
            if(data!="true"){
             $("#vpass1").html("原始密码输入不正确！");
             return false;
            }
         });      
       }
      if(id==2){
        if(strval.length<6){
         $("#vpass2").html("密码长度不能低于6位！");
         return false;
        }      
      }
      if(id==3){
        if($("#pass2").val()!=strval){
         $("#vpass3").html("两次密码输入不一致！");
         return false;
        }
       }
     }
     return true;
}
function passclose(){
$("#divPass").dialog("close");
}
function vupdatePass(){
vpass(1);vpass(2);vpass(3);
  if(vpass(1)&&vpass(2)&&vpass(3)){
  var strval=$("#pass2").val();
    jQuery.post("customeruser!ajaxUpdatepassword.action",{newpassword:strval},function(){
             alert("密码修改成功！");   
             $("#divPass").dialog("close");
                     
         });      
  }
 
}
function getorderinfo()
{
  if(typeof(document.getElementById("txtid"))=="undefined" || $("#txtid").val()=="" || $("#txtid").val()=="null")
  {
     $("#btnupdate").hide();
  }
  $.ajax({
            type:"POST",
            url:"orderinfo!getCustomerOrderlist.action",
            beforeSend:function(){$("#divorderinfo").html("正在加载最近订单信息！");},             
            success:function(data){
            $("#divorderinfo").html(data);           
            }            
            });
}
     function updatePass(){
       $("#divPass").dialog(
        {title:'修改密码',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 450,
                height: 240      
       });
       $("#divPass").dialog("open");
       var strHtml='<form action="customeruser!" method="post"><table class="passtable" width="100%" cellpadding="0" cellspacing="0">';
       strHtml+='<tr><td colspan="2" height="20px">&nbsp;</td></tr><tr><td class="passtd" width="120px" align="right" style="padding-right:10px">旧密码：</td>';
        strHtml+='<td class="passtd" align="left" style="padding-left:10px"><input type="password" id="pass1" onblur="vpass(1)"></input>&nbsp;<span id="vpass1" style="color:red"></span></td></tr><tr><td class="passtd" align="right" style="padding-right:10px">新密码：</td>';
        strHtml+='<td class="passtd" align="left" style="padding-left:10px"><input type="password" id="pass2"onblur="vpass(2)"></input>&nbsp;<span id="vpass2" style="color:red"></span></td></tr><tr><td class="passtd" align="right" style="padding-right:10px">重复新密码：</td>';
        strHtml+='<td class="passtd" align="left" style="padding-left:10px"><input type="password" id="pass3"onblur="vpass(3)" />&nbsp;<span id="vpass3" style="color:red"></td></span></tr>';
        strHtml+='<tr><td colspan=2 class="passtd" height="40px"><input class="button108"  type="button" onclick="javascript:vupdatePass()" value="  提   交  ">&nbsp;&nbsp;<input onclick="passclose()" class="button108" type="button" value=" 取 消 "></td></tr>';
        strHtml+='</table></form>';
       $("#divPass").html(strHtml);
      }
    
//显示Q信箱
    function showqemailbox()
    {
        $("#divIframe").dialog({
                title:'Q信箱处理--您的Q信箱有航班变更信息，请查看',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 780,
                height: 520
          });
         $("#hidqright").val()=="1"
         {
           $("#divIframe").dialog("open");
            document.getElementById("divIframe").innerHTML="<iframe style='width:100%; height:100%;' frameborder='0' scrolling='auto' src='qmessage.action'></iframe>";
         } 
    }
    function showqsinfo(querytype)
    {
       $("#divqsinfo").show();
       $("#span_btn").show();
        $("#span_tishi").show();
       
       $.ajax({
            type:"POST",
            url:"orderinfo!getQMailSC.action",
            data:{strQueryType:querytype},
            beforeSend:function(){$("#divqsinfo").html("正在加载Q信箱信息...");},             
            success:function(data){
            $("#divqsinfo").html(data);       
            }            
            });
    }
    
    function showqn()
    {
       $.ajax({
            type:"POST",
            url:"orderinfo!getQMailQN.action",
            beforeSend:function(){$("#divqsinfo").html("正在加载下一个Q信箱信息...");},             
            success:function(data){
            $("#divqsinfo").html(data);       
            }            
            });
    }
    function showqne()
    {
       $.ajax({
            type:"POST",
            url:"orderinfo!getQMailQNE.action",
            beforeSend:function(){$("#divqsinfo").html("正在加载释放Q信箱信息...");},             
            success:function(data){
            $("#divqsinfo").html("释放完毕!");       
            }            
            });
    }
</script>
<style type="text/css">
 html,body { margin:0;padding:0; height:100%;overflow-y:hidden!important;*overflow-y:scroll;}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.ordercountcss
 {
   font-size:12px;
   color: #66A366;
   font-weight: bold;
 }
 
 .ordercountdiscss
 {
   font-size:12px;
   color: #ccc;
   font-weight: bold;
 }
 .hellocss
 {
   font-size:12px;
   color: red;
 }

#ChildMenus
{
	font-size:12px;
	padding-top:2px;
}
#ChildMenus a
{
	color:#666666;
	text-decoration: none;	
}
#ChildMenus a:hover
{
	color:#ff0000;
	text-decoration: none;	
}

.mainpart {
	font-size: 12px;
	//**background-color: #b0c8f1;**/
	margin: 0px;
	padding: 0px;
	clear: both;
	height: 100%;
	width: 650px;
}
.phonehead
{

	padding: 1px;
	clear: both;
	height: auto;
	
	margin: 1px;
}
.messtitle
{
	background-image: url(images/openwinphone/mess.png);
	background-repeat: no-repeat;
	background-position: center;
	float: left;
	height: 22px;
	width: 32px;	
}
.bntcheck
{
	background-color: #FBF4EF;
	margin: 1px;
	padding: 0px;
	clear: both;
	height: 100%;
	border: 1px solid #FF8325;
	border-top: none;
	
}
.bnthead
{
	line-height: 24px;
	background-image: url(images/openwinphone/pubhead.png);
	background-repeat: repeat-x;
	background-position: left center;
	clear: both;
	height: 24px;
	font-weight: bold;
	color: #AC5D16;
}
.controlli {
	line-height: 22px;
	padding: 1px;
	float: left;
	height: auto;
}
.textbox
{
	background-color: #FFFFFF;
	height: 16px;

	margin-right: 1px;
	margin-left: 2px;
}
.memberinfo
{
	clear:both;
	height: 100%;
	text-align:left;
	background-color: #FFFFFF;
	padding: 1px;
	margin-right: 5px;
	margin-bottom: 5px;
	margin-left: 5px;

}
.menuhead
{
	line-height: 22px;
	background-image: url(images/openwinphone/cline.png);
	background-repeat: repeat-x;
	background-position: bottom;
	padding: 0px;
	clear: both;
	height: 22px;
	margin-top: 5px;
	margin-right: 5px;
	margin-bottom: 0px;
	margin-left: 5px;
}
.lline
{
	line-height: 22px;
	background-image: url(images/openwinphone/lline.png);
	background-repeat: no-repeat;
	background-position: left bottom;
	margin: 0px;
	padding: 0px;
	float: left;
	height: 22px;
	width: 6px;	
}
.rline
{
	line-height: 22px;
	background-image: url(images/openwinphone/rline.png);
	background-repeat: no-repeat;
	background-position: right bottom;
	margin: 0px;
	padding: 0px;
	float: right;
	height: 22px;
	width: 6px;	
}
.windkuang
{
	background-color: #FFAD6F;
	padding: 4px;
	clear: both;
	border: 1px solid #F16800;
	border-top:none;
	text-align: center;
	line-height: 100%;
	margin-right: 5px;
}
.windowmain
{
	width:686px;
	height:auto;
	padding-right: 8px;
	background-image: url(images/openwinphone/wincen.png);
	background-repeat: repeat-y;
	text-align: center;
}
.winheads
{
	line-height: 24px;
	background-image: url(images/openwinphone/wintop.png);
	clear: both;
	height: 24px;
}
.winheadtitle
{
	background-image: url(images/openwinphone/winhead.png);
	background-repeat: no-repeat;
	background-position: left center;
	float: left;
	height: 20px;
	margin-left: 2px;
	width:123px;
	margin-top: 2px;
}
.winheadtitle1
{
	background-image: url(images/openwinphone/uppwd.png);
	background-repeat: no-repeat;
	background-position: left center;
	float: left;
	height: 20px;
	margin-left: 2px;
	width:123px;
	margin-top: 2px;
}

.wintools
{
	line-height: 17px;
	background-repeat: no-repeat;
	background-position: center top;
	float: right;
	width: 71px;
	margin-right: 24px;
	padding-top: 3px;
}
.winmax
{
	background-image: url(images/openwinphone/winmax.png);
	background-repeat: no-repeat;
	background-position: center top;
	float: left;
	height: 17px;
	width: 17px;
	margin-right: 4px;
	margin-left: 2px;
	cursor:pointer;
}
.winmin
{
background-image: url(images/openwinphone/winmin.png);
	background-repeat: no-repeat;
	background-position: center top;
	float: left;
	height: 17px;
	width: 17px;
	margin-right: 5px;
	margin-left: 5px;
	cursor:pointer;
}
.winclose
{
background-image: url(images/openwinphone/winclose.png);
	background-repeat: no-repeat;
	background-position: center top;
	float: left;
	height: 17px;
	width: 17px;
	margin-right: 1px;
	margin-left: 1px;
	cursor:pointer;
}
#winheadioc
{
	line-height: 20px;
	background-image: url(images/openwinphone/winheadioc.png);
	background-repeat: no-repeat;
	background-position: center;
	padding: 1px;
	clear: both;
	height: 22px;
	width: 22px;
	cursor:pointer;
	position:absolute;
}
</style>
    <link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
     <!-- GC -->
    <!-- LIBS -->
    <script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
    <!-- ENDLIBS -->
    <script type="text/javascript" src="js/ext-all.js"></script>

    
    <script type="text/javascript">
		    var win;
		    Ext.onReady(function(){	
		    	
			    
			        win = new Ext.Window({
			    	id:'win',
			    	title:"<font color=red>黑屏</font>",
			    	width:800,
			    	height:600,
			    	
			    	closeAction:'hide',
			    	items:new Ext.form.TextArea({
			    		id:'textarea',
			    		width:'100%',
			    		height:'600px',
			    		enableKeyEvents:true,
			    		style: {
				            color:'#00Ff00',
				            background:'black',
				            height:'200px'
				        },
						value:'>',
						autoScroll:true
			    		
			    	})
		
			    });
			    
			    
			    			
				//<ww:if test="checkright('moniheiping')">	
				//new Ext.Button( 
	 	         //{ 
		         	
		         	//text: '模拟黑屏',
			        //handler: function(){
			          //win.show();
			        //}
			        
	       		 //}).render(document.body, 'button');
	  			//</ww:if>
  				
  	  			
  				Ext.getCmp('textarea').on('keyup',function(a,e){
  				 		
  				 		if(e.getCharCode()==13){
							var value = Ext.getCmp('textarea').getValue().trim();
  				 			
  				 			Ext.getCmp('textarea').setValue(value);
  				 			Ext.getCmp('textarea').getEl().scrollTo('top',100000);
  				 			
  				 			var cmd = value.substring(value.lastIndexOf('>')+1);
  				 			
  				 			Ext.Ajax.request({
								   url: 'pid.jsp',
								   method:'GET',
								   success: function(response, opts) {
								   
								   	value+="\r\n"+response.responseText;
  				 					
								  	Ext.getCmp('textarea').setValue(value+"\r\n>");
  				 					catheindex = value.length;
  				 					
									Ext.getCmp('textarea').getEl().scrollTo('top',100000);
								   
								   },
								   params: { cmd:cmd }
								});
				 		}
  				});
  								
					
		    });
		    
	function moniheiping()
	  {
	     win.show();
	  }
	</script>
	<script type="text/javascript">
    window.onresize = function(){
		    var gBodyHeight = document.documentElement.offsetHeight;
		    var h;
		    if(gBodyHeight!=null)
		    {
		       h = gBodyHeight - 130;
		    }
		    else
		    {
		        h =130;
		    }
		    
		    if(document.getElementById("menus") != null) document.getElementById("menus").style.height=h+"px";
		    if(document.getElementById("contents")!=null) document.getElementById("contents").style.height=h+"px";
		}
		function lbodyheigth()
		{
		var gBodyHeight = document.documentElement.offsetHeight;
		 var h;
	    if(gBodyHeight!=null)
	    {
	       h = gBodyHeight - 130;
	    }
	    else
	    {
	        h =130;
	    }
		if(document.getElementById("menus") != null) document.getElementById("menus").style.height=h+"px";
		if(document.getElementById("contents")!=null)  document.getElementById("contents").style.height=h+"px";
		}
        function showHide(obj){
	        var oStyle = document.getElementById(obj).style;
	        oStyle.display == "none" ? oStyle.display = "block" : oStyle.display = "none";
        }
        function changecss(obj)
        {
           obj.parentElement.parentElement.className="selectmenu";
        }
        function getparmByUrl(parmName)
        {
            var url = window.location.toString();
            var index=url.indexOf("?");
            if(index!=-1)
            { 
                var arr = url.split("?");
                var parms = arr[1];
                var parmList = parms.split("&");
                var parmTemp;
                for(var i=0;i<parmList.length;i++)
                {
                parmTemp = parmList[i].split("=");
                if(parmTemp[0] == parmName)
                alert(parmTemp[1]);
                return parmTemp[1];
                }
                return ""
            }
        }
        
        <!--
    function changediv(tableName1,tableName2,tableName3,tableName4)
    {
        document.getElementById(tableName1).style.display="block";
        document.getElementById(tableName2).style.display="none";
        document.getElementById(tableName3).style.display="none";
        document.getElementById(tableName4).style.display="none";
    }
	function ShowWin(i)
	{
		var windmainkuang = document.getElementById("windmainkuang");
		var windowsmain = document.getElementById("windowsmain");
//		var winheadioc = document.getElementById("winheadioc");
		if(i==0)
		{
			windmainkuang.style.display="block";
		}
		if(i==1)
		{
			windmainkuang.style.display="none";
		}
		if(i==2)
		{
			windowsmain.style.display="none";
//			winheadioc.style.display="block";
		}
		if(i==3)
		{
			windowsmain.style.display="block";
//			winheadioc.style.display="none";
		}
	}
	function ShowDiv()
	{
	    if(document.getElementById("windowsmain").style.display=="none")
	        document.getElementById("windowsmain").style.display="block"
	    else
	        document.getElementById("windowsmain").style.display="none"
	}
	
	
	function Showdetail(){
	   $("#detail").toggle();
	}
	function moveStart (event, _sId){
      var oObj = document.getElementById(_sId);
      oObj.onmousemove = mousemove;
      oObj.onmouseup = mouseup;
      oObj.setCapture ? oObj.setCapture() : function(){};
      oEvent = window.event ? window.event : event;
      var dragData = {x : oEvent.clientX, y : oEvent.clientY};
      var backData = {x : parseInt(oObj.style.top), y : parseInt(oObj.style.right)};
      function mousemove(){
       var oEvent = window.event ? window.event : event;

       var iLeft = dragData["x"]-oEvent.clientX + parseInt(oObj.style.right);
       var iTop = oEvent.clientY - dragData["y"] + parseInt(oObj.style.top);
       oObj.style.right = iLeft;
       oObj.style.top = iTop;
       dragData = {x: oEvent.clientX, y: oEvent.clientY};   
      }
      function mouseup(){
       var oEvent = window.event ? window.event : event;
       oObj.onmousemove = null;
       oObj.onmouseup = null;
       if(oEvent.clientX < 1 || oEvent.clientY < 1 || oEvent.clientX > document.body.clientWidth || oEvent.clientY > document.body.clientHeight){
        oObj.style.left = backData.y;
        oObj.style.top = backData.x;
       }
       oObj.releaseCapture ? oObj.releaseCapture() : function(){};
      }
    } 
    function SetUrl()
    {
        document.getElementById("windowsmain").style.display="none"
        document.getElementById("linkTicket").href="airsearch.action";
       // document.getElementById("linkHotel").href="hotel/hotelsubscribe.action";
       document.getElementById("linkHotel").href="subscribehotel.action";
        document.getElementById("linktrip").href="triplinebook.action";
        
        
    }
    function GetUrl()
    {
     document.getElementById("windowsmain").style.display="none"
    }
    
    function ShowUpDiv(divName)
    {
        document.getElementById(divName).style.display="block";
    }
    function HidUpDiv(divName)
    {
        document.getElementById(divName).style.display="none";
    }
    function CloseUpDiv(divName)
    {
        document.getElementById(divName).style.display="none";
    }
    

</script>

<style>
.tbody_color{background: #FAC89F; border-left:1px solid #fff;border-top:1px solid #fff; border-bottom: 1px solid #E96E10; border-right: 1px solid #E96E10;}

</style>
</head>
<body scroll="no" style="position: relative;">



    <div id="divIframe" title=""  style="text-align:center;display:none; background-color:#fff;left:0px;">正在加载Q信箱信息...
   </div>
   <div id="divPass"  style="text-align:center;display:none; background-color:#fff;left:0px;"></div>
    <iframe  src="main.jsp" style="width:100%; height:100%; border:0" scrolling="auto" id="iFrame1" name="iFrame1" onload="this.height=iFrame1.document.body.scrollHeight"></iframe>
</div>
<div id="txtQTinfo"></div>
<div id="txtQSinfo"></div>
</body>
</html>
