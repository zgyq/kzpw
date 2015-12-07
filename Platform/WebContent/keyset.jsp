<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html>
<head>
<title>黑屏</title> 
<!--设置网页的文件编码-->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="黑屏,机票预定,keyword3">
<meta http-equiv="description" content="黑屏">
<script src="js/eterm/prototype.js" type="text/javascript"></script>
<SCRIPT language=javascript src="js/eterm/key.js"></SCRIPT>
<script language=javascript src="js/eterm/eterm.js"></script>
<style> 
.hbh{
color:#00FF00;
}
.cw{color:#5b6161;}
.hc{
	color:#00FF00;
}
 
body {
	font-size: 20px; 
	font-family:宋体; 
	background-color: #000000;
	scroll=no;
	color:#00FF00;
	letter-spacing:1px;
	margin:0;
	
}
p{
	margin-top:0px;
	margin-bottom:0px;}
table{
	color:#00FF00;
	font-size:20px;
	letter-spacing:1px;
}
br{
	margin-top:0px;
	margin-bottom:0px;
}
pre{
	margin-top:0px;
	margin-bottom:0px;
}
td{white-space: nowrap;padding-left:4px; }
</style>
 
<script> 
 
 
function searchZc(command){	//政策弹拼
	var sd="";
	var month="";
	var day="";
	var city=command.substring(0,6).toUpperCase();
	try{
		if(command.length==11 || command.length==13){
			month=command.substring(8,11);
			day=command.substring(6,8);
			var da=new Date();
			year=da.getYear().toString().substring(0,2)+command.substring(11);
			if(year.length==2){
				year=da.getYear()
			}
			sd=year+"-"+enToNumMonth(month)+"-"+day;
		}else if(command.length==10 || command.length==12){
			month=command.substring(7,10);
			day="0"+command.substring(6,7);
			var da=new Date();
			year=da.getYear().toString().substring(0,2)+command.substring(11);
			
			if(year.length==2){
				year=da.getYear();
			}
			sd=year+"-"+enToNumMonth(month)+"-"+day;
		}else{
			sd="";
		}
	}catch(e){
		sd="";
	}
	searchDate=sd;
	var bmlx="";
	if(bmlx==null || bmlx==""){
		bmlx="";
	}
	if(bmlx=="105502"){
		parent.righteterm.location="/eterm/zctp.shtml?sd=" + sd + "&ct=" + city;
		parent.zcrooteterm.location="/eterm/fxzcwj.shtml?sd=" + sd + "&ct=" + city;
	}else{
		parent.righteterm.location="/eterm/zctp.shtml?sd=" + sd + "&ct=" + city;
		parent.zcrooteterm.location="/eterm/htzcwj.shtml?sd=" + sd + "&ct=" + city;
		
	}
}
	
function ajax(a, b, c) {
		var d = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP"], xmlObj;
		try {
			xmlObj = new XMLHttpRequest();
		}
		catch (e) {
			for (var i = 0; i < d.length; i++) {
				try {
					xmlObj = new ActiveXObject(d[i]);
					break;
				}
				catch (e) {
				}
			}
		}
		if (!xmlObj) {
			return;
		}
		xmlObj.open(b ? "POST" : "GET", a || _.location.href, !!c);
		xmlObj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlObj.setRequestHeader("If-Modified-Since", new Date(0));
		if (c) {
			xmlObj.onreadystatechange = function () {
				if (xmlObj.readyState == 4) {
					c(xmlObj.status == 200 ? xmlObj.responseText : null)
				}
			};
		}
		xmlObj.send(b || "");
		return c ? xmlObj : (xmlObj.status == 200 ? xmlObj.responseText : null);
}
	
function release(){
 		var jxo=document.getElementById("jx");
	var cfdateo=document.getElementById("cfdate");
	var hbho=document.getElementById("hbh");
	var hco=document.getElementById("hc");
	var cfsjo=document.getElementById("cfsj");
	var ddsjo=document.getElementById("ddsj");
	var cwo=document.getElementById("cw");
	var zko=document.getElementById("zk");
	var pjo=document.getElementById("pj");
	var jsfo=document.getElementById("jsf");
	var taxo=document.getElementById("tax");
	var tpgdo=document.getElementById("tpgd");
	var qzgdo=document.getElementById("qzgd");
	var scgdo=document.getElementById("scgd");
	var ifgbyjo=document.getElementById("ifgbyj");
	var zcido=document.getElementById("zcid");
	var zwo=document.getElementById("zw");
 		jxo.value="";
 		cfdateo.value="";
 		hbho.value="";
 		hco.value="";
 		cfsjo.value="";
 		cwo.value="";
 		ddsjo.value="";
 		
 		zko.value="";
 		pjo.value="";
 		
 		jsfo.value="";
 		taxo.value="";
 		tpgdo.value="";
 		qzgdo.value="";
 		
 		scgdo.value="";
 		ifgbyjo.value="";
 		zcido.value="";
 		zwo.value="";
 	}
  
function gNKey(){
	if(main.isContentEditable){		//可编辑状态才执行指令
		if(event.keyCode==27){   //Esc  按这个键在光标处插入一个开始字符
			insertChar();
		}
	}
	var vkey="";
	//if(key.length>0){
		vkey=returnkey();
	//}
	if(commandList.length>0){
		if(vkey=='UP'){//ctrl+上建
			commandCount--;
			if(commandCount>=0){
				editStartToCursor(commandList[commandCount]);
				//insertCurrentLine(commandList[commandCount]);
			
			}else{
				commandCount=commandList.length-1;//将下标指向最后一个数组位置
				editStartToCursor(commandList[commandCount]);
				//insertCurrentLine(commandList[commandCount]);
				
			}
		}else if(vkey=='DOWN'){//ctrl+下建
			commandCount++;
			if(commandCount<=(commandList.length-1)){
				//insertCurrentLine(commandList[commandCount]);
				editStartToCursor(commandList[commandCount]);
				
			}else{
				commandCount=0;
				//insertCurrentLine(commandList[commandCount]);
				editStartToCursor(commandList[commandCount]);
			}
		}
	}
	if(vkey=="CTRL+V"){
		var t=window.clipboardData.getData("Text");
		window.clipboardData.setData("Text", strTrim(t));
		return;
	}
	for(var i=0;i<key.length;i++){
		if(key[i][1]=='0'){
			if(main.isContentEditable){		//可编辑状态才执行指令
				if(key[i][0]=='0001' && key[i][2]==vkey){
				
					getCursorPos();
					event.keyCode=0;
					event.returnValue=false;
					break;
				}
			}else{
				if(key[i][0]=='0003' && key[i][2]==vkey){		//f6执行指令
					main.setAttribute("contentEditable",true);
					main.focus();
					event.keyCode=0;
					event.returnValue=false;
					break;
				}else{
					alert("指令还在执行中，请稍后！！");
				}
			}
			if(key[i][0]=='0002' && key[i][2]==vkey){
				createFiles(main.innerText);
				commandList=null;
				commandList=new Array();
				clear();
				insertChar();
				event.keyCode=0;
				event.returnValue=false;
				break;
			}else if(key[i][0]=='0004' && key[i][2]==vkey){
				
					window.open("/eterm/hyToeterm.jsp", "","height=400px,width=880px,toolbar=no,scrollbars=yes,menubar=no, resizable=yes, location=no, status=yes,left=0,top=0");
				
				event.keyCode=0;
				event.returnValue=false;
				break;
			}
		}else{
			if(key[i][2]==vkey){
				insertCurrentLine(key[i][3]);
				if(key[i][4]=='1'){
					excuteCommand(key[i][3]);
				}
				event.keyCode=0;
				event.returnValue=false;
				break;
			}
		}
	}
	//如果没有快捷键
	if(key.length<=0){
		if(main.isContentEditable){		//可编辑状态才执行指令
			//if(event.keyCode==27){   //Esc  按这个键在光标处插入一个开始字符
			//		insertChar();
			//	}
			if(event.keyCode=='123'){		//f12执行指令
				getCursorPos();
				event.keyCode=0;
				event.returnValue=false;
			}
		}else{
			if(event.keyCode=='117'){		//f6执行指令
				main.setAttribute("contentEditable",true);
				main.focus();
				event.keyCode=0;
				event.returnValue=false;
			}else{
				alert("指令还在执行中，请稍后！！");
			}
		}
		if(event.keyCode=='114' || event.keyCode=='115' || event.keyCode=='112' || event.keyCode=='116' 
		 || event.keyCode=='122' || event.keyCode=='119'){
			event.keyCode=0;
			event.returnValue=false;
		}
		if(event.keyCode=='113' ){	//f2
			
			window.open("/eterm/hyToeterm.jsp", "","height=400px,width=880px,toolbar=no,scrollbars=yes,menubar=no, resizable=yes, location=no, status=yes,left=0,top=0");
			
			event.keyCode=0;
			event.returnValue=false;
		}
		if( event.keyCode=='120'){	//f9 执行 PN
			insertCurrentLine("PN");
			excuteCommand("PN");
			
			event.keyCode=0;
			event.returnValue=false;
		}
		if( event.keyCode=='121'){	//f9 执行 PB
			insertCurrentLine("PB");
			excuteCommand("PB");
			event.keyCode=0;
			event.returnValue=false;
		}
		if( event.keyCode=='118'){	//f7
			createFiles(main.innerText);
			commandList=null;
			commandList=new Array();
			clear();
			insertChar();
			event.keyCode=0;
			event.returnValue=false;
		}
	}
}
	
function showFjjx(sid){
     window.open("/eterm/ticket/etermshare/b_comm_plane_info.shtml?action=edit&fjjx="+sid,"","width=450,height=450,toolbar=no,directories=no,status=no,scrollbars=yes,resizable=yes,menubar=no");
}
	
function bookWindow(jx,zw,cfdate,hbh,hc,cfsj,ddsj,cw,zk,pj,jsf,tax,tpgd,qzgd,scgd,ifgbyj,zcid){
	
	var jxo=document.getElementById("jx");
	var cfdateo=document.getElementById("cfdate");
	var hbho=document.getElementById("hbh");
	var hco=document.getElementById("hc");
	var cfsjo=document.getElementById("cfsj");
	var ddsjo=document.getElementById("ddsj");
	var cwo=document.getElementById("cw");
	var zko=document.getElementById("zk");
	var pjo=document.getElementById("pj");
	var jsfo=document.getElementById("jsf");
	var taxo=document.getElementById("tax");
	var tpgdo=document.getElementById("tpgd");
	var qzgdo=document.getElementById("qzgd");
	var scgdo=document.getElementById("scgd");
	var ifgbyjo=document.getElementById("ifgbyj");
	var zcido=document.getElementById("zcid");
	var zwo=document.getElementById("zw");
	if(jxo.value==""){
		jxo.value=jx;
	}else{
		jxo.value=jxo.value+","+jx;
	}
	if(cfdateo.value==""){
		cfdateo.value=cfdate;
	}else{
		cfdateo.value=cfdateo.value+","+cfdate;
	}
	if(hbho.value==""){
		hbho.value=hbh;
	}else{
		hbho.value=hbho.value+","+hbh;
	}
	if(hco.value==""){
		hco.value=hc;
	}else{
		hco.value=hco.value+","+hc;
	}
	if(cwo.value==""){
		cwo.value=cw;
	}else{
		cwo.value=cwo.value+","+cw;
	}
	if(cfsjo.value==""){
		cfsjo.value=cfsj;
	}else{
		cfsjo.value=cfsjo.value+","+cfsj;
	}
	if(ddsjo.value==""){
		ddsjo.value=ddsj;
	}else{
		ddsjo.value=ddsjo.value+","+ddsj;
	}
	if(pjo.value==""){
		pjo.value=pj;
	}else{
		pjo.value=pjo.value+","+pj;
	}
	if(jsfo.value==""){
		jsfo.value=jsf;
	}else{
		jsfo.value=jsfo.value+","+jsf;
	}
	if(taxo.value==""){
		taxo.value=tax;
	}else{
		taxo.value=taxo.value+","+tax;
	}
	if(zwo.value==""){
		zwo.value=zw;
	}else{
		zwo.value=zwo.value+","+zw;
	}
	if(tpgdo.value==""){
		tpgdo.value=tpgd+" ";
	}else{
		tpgdo.value=tpgdo.value+"&"+tpgd;
	}
	if(qzgdo.value==""){
		qzgdo.value=qzgd+" ";
	}else{
		qzgdo.value=qzgdo.value+"&"+qzgd;
	}
	if(scgdo.value==""){
		scgdo.value=scgd+" ";
	}else{
		scgdo.value=scgdo.value+"&"+scgd;
	}
	if(ifgbyjo.value==""){
		ifgbyjo.value=ifgbyj;
	}else{
		ifgbyjo.value=ifgbyjo.value+","+ifgbyj;
	}
	if(zcido.value==""){
		zcido.value=zcid+" ";
	}else{
		zcido.value=zcido.value+","+zcid;
	}
	window.open ("", "newwindow", "height=600, width=850, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=yes");
	document.etermForm.submit();
}
 
function jtdSearch(hbh,time){
window.open("/eterm/etermshare_bs/ff.shtml?iterm=ff&hbh="+hbh+"&time="+time,"","width=200,height=100,toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,menubar=no");
}
</script>
<script type="text/javascript"> 
var key=new Array();
 
document.onkeydown=gNKey;  //功能键
 
 
</script>
 
	</head>
	 <input name="zctptag" type="hidden" id="zctptag" value=""/>
	<form action="/asms/search/pre_book_web.shtml?pre=pre_eterm" method="post" name="etermForm" target="newwindow">
	 <input name="hbh" type="hidden" id="hbh"/>
   	 <input name="hc" type="hidden" id="hc"/>
   	 <input name="cfsj" type="hidden" id="cfsj"/>
   	 <input name="ddsj" type="hidden" id="ddsj"/>
   	 <input name="cw" type="hidden" id="cw"/>
   	 <input name="zk" type="hidden" id="zk"/>
   	 <input name="pj" type="hidden" id="pj"/>
   	 <input name="jsf" type="hidden" id="jsf"/>
   	 <input name="tax" type="hidden" id="tax"/>
   	 <input name="qtfy" type="hidden" id="qtfy"/>
   	 <input name="tpgd" type="hidden" id="tpgd"/>
   	 <input name="qzgd" type="hidden" id="qzgd"/>
   	 <input name="scgd" type="hidden" id="scgd"/>
   	 <input name="hkgs" type="hidden" id="hkgs"/>
   	 <input name="ifgbyj" type="hidden" id="ifgbyj"/>
   	 <input name="jx" type="hidden" id="jx"/>
     <input name="cfdate" type="hidden" id="cfdate"/>
     <input name="zcid" type="hidden" id="zcid"/>
     <input name="zw" type="hidden" id="zw"/>
	</form>
	<input name="amsmAndagent" type="hidden" id="amsmAndagent" value="asms"/>
	<body contenteditable=true id=main onload="insertChar();initFont();">
	</body>
	
<script type="text/javascript"> 
function setHpCode(code){
     try{
   	setCursor();//光标移到最后一行
     }catch(e){
     	return -1;
     }
    insertCurrentLine("\n>"+code); 	//在当前光标插入指令
   	excuteCommand(code);		//执行指令
   	return 1;
}
 
function webExcuteCommand(command,fn){
  		var showResponseweb=function(transport)
		{
			transport=transport.responseText;
			if(transport==null){
				return;
			}
			var result=transport.split("|");
			if(result.length==3){
				transport=result[2];
			}
			if(fn!=null){
				fn(transport);
			}
		}
		
  		var myAjax = new Ajax.Request(
			'/eterm.shtml?randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&command="+encodeURIComponent(command),
			{
				method: 'post',
				requestHeaders:{Accept:'application/html'},
				//parameters: "randamTime="+new Date().getTime()+"&avhFs="+avhFs+"&command="+encodeURIComponent(command),		//转码
				//onComplete: showResponse,
				onSuccess: showResponseweb
			}
		);
  	}
</script>
</html> 
