var commandList=new Array();
var commandCount=-1;//数组当前位置,默认不在-1
var avhFs="1";	//默认是1是表示价格提醒，0是直通
var commandset=">";
var searchDate="";		//avh（所有查询）的时候，我要通过解析获得，当前时间，然后给这个变量,用来点航班号，查舱位（分销商用返点）

var excutenum=1;
/**
替换字符串
**/
String.prototype.replaceAll = function (AFindText,ARepText){
                raRegExp = new RegExp(AFindText,"g");
                return this.replace(raRegExp,ARepText);
}
function toHtml(s) {
	s=s.replaceAll("&amp;", "&");
	s = s.replaceAll("&lt;","<");
	s = s.replaceAll("&gt;",">" );
	s = s.replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;","\t");
	s = s.replaceAll("\n","\r\n");
	// s = Replace(s,"\"","'");
	s = s.replaceAll("<br>","\n" );
	s = s.replaceAll("&nbsp;&nbsp;","  " );
	// s = Replace(s,"'","");
	s = s.replaceAll("&#39;","'" );
	s = s.replaceAll("&#92;","\\");
	return s;
}
function enToNumMonth(m){//英文转数字月
	var mu=m.toUpperCase();
	var num="";
	if(mu=="JAN"){
		num="01";
	}else if(mu=="FEB"){
		num="02";
	}else if(mu=="MAR"){
		num="03";
	}else if(mu=="APR"){
		num="04";
	}else if(mu=="MAY"){
		num="05";
	}else if(mu=="JUN"){
		num="06";
	}else if(mu=="JUL"){
		num="07";
	}else if(mu=="AUG"){
		num="08";
	}else if(mu=="SEP"){
		num="09";
	}else if(mu=="OCT"){
		num="10";
	}else if(mu=="NOV"){
		num="11";
	}else if(mu=="DEC"){
		num="12";
	}
	return num;
}
function parseAv(command){
	 //指令格式
    //1.avh/xiypek/10nov
    //2.av h xiypek/10nov
    //3.av:xiypek/10nov
    //4.av xiypek/10nov
    command=command.replace(/\s{1,}/g,"");//去掉空格,包括多个空格
    var pos=command.indexOf("(");
    var sj=command.substring(0,pos);
    pos=command.indexOf(")");
    var hc=command.substring(pos+1,pos+1+6);
    searchZc(hc+sj);
}
function insertCurrentLine(v){
	main.focus();
	document.selection.createRange().text=v;
}
function insertChar(){
	main.focus();
	document.selection.createRange().text=commandset;
}
function pingbi(){
	if(event.keyCode!=38 && event.keyCode!=40 && event.keyCode!=39 && event.keyCode!=37){
		event.returnValue=false;
	}		
}
function callreBookvalidat(transport){
	main.insertAdjacentHTML("beforeEnd",transport+"<br/>"+commandset);
	document.body.scrollTop=document.body.scrollHeight; //返回数据时让滚动条在最后
	setCursor();
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
		//'/eterm.shtml?iterm=av&randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&command="+encodeURIComponent(command),
	
		'pid.jsp?iterm=av&randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&cmd="+encodeURIComponent(command),
	
		{
			method: 'post',
			requestHeaders:{Accept:'application/html'},
			//parameters: "randamTime="+new Date().getTime()+"&avhFs="+avhFs+"&command="+encodeURIComponent(command),		//转码
			//onComplete: showResponse,
			onSuccess: showResponseweb
		}
	);
}
function extendsComand(command){
	var tmpcommand=command.toUpperCase();
	if(tmpcommand=="CP"){
		createFiles(main.innerText);
		commandList=null;
		commandList=new Array();
		clear();
		insertChar();
		return true;
	}
	/*
	if(tmpcommand.indexOf("DXQ")==0){
		tmpcommand=tmpcommand.replaceAll(" ","");
		if(tmpcommand.length==8){
			tmpcommand=tmpcommand.substring(3,8);
			window.open("/asms/ticket/etermpnrtoddx.shtml?to=ddx&pnrno="+tmpcommand, "","height=600,width=810,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes");
		}else{
			setCursor();
			insertCurrentLine("\n编码格式错误,请检查！\n"+commandset);
		}
		return true;
		
	}else if(tmpcommand.indexOf("DD")==0 &&  tmpcommand.indexOf("DDI")<=-1){
		tmpcommand=tmpcommand.replaceAll(" ","");
		if(tmpcommand.length==7){
			tmpcommand=tmpcommand.substring(2,7);
			window.open("/asms/ticket/etermpnrtoddx.shtml?to=dd&pnrno="+tmpcommand, "","height=450,width=600,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes");
		}else{
			setCursor();
			insertCurrentLine("\n编码格式错误,请检查！\n"+commandset);
		}
		return true;
		
	}else if(tmpcommand.indexOf("VEPAY")==0){
		tmpcommand=tmpcommand.replaceAll(" ","");
		if(tmpcommand.length==10){
			tmpcommand=tmpcommand.substring(5,10);
			window.open("/asms/ticket/etermpnrtoddx.shtml?to=pay&pnrno="+tmpcommand, "","height=570,width=640,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes");
		}else{
			setCursor();
			insertCurrentLine("\n编码格式错误,请检查！\n"+commandset);
		}
		return true;
	}*/
	return false;
}
//执行命令
function excuteCommand(command,fn){
	//先检查是不是扩展指令
	if(extendsComand(command)){
		return;
	}
	if(strTrim(command)=='i' || strTrim(command)=='I'){
		release();
	}
	var kstime=new Date().getTime();
	main.setAttribute("contentEditable",false);
	var showFail=function(transport){
		main.setAttribute("contentEditable",true);
		if(transport.readyState==3 || transport.readyState==4){
			alert("请检查本地网络是否正常,请重新尝试."+transport.status+" "+transport.readyState+" "+transport.statusText);
		}
	}
	var showException=function(transport){
		main.setAttribute("contentEditable",true);
		alert("showException系统错误!原因如下：\n1.应用服务器重启\n2.网络异常\n3.详细错误："+transport.responseText);
	}
	var showResponse=function(transport)
	{
		transport=transport.responseText;
		commandList.push(command);
		commandCount=commandList.length;//将下标移到当前指令执行在数组中的位置
		if(transport==null){
			main.setAttribute("contentEditable",true);
			main.insertAdjacentHTML("beforeEnd","系统检查到网络不稳定，重新发送指令，请稍等...</br>"+commandset);
		 	document.body.scrollTop=document.body.scrollHeight; //返回数据时让滚动条在最后
		 	setCursor();
		 	if(excutenum<=3){
			 	 //如果发现返回的是null，重新执行一次指令
			 	excuteCommand(command);
			 	excutenum=excutenum+1;
			}else{
				//如果执行了3次以上就不要执行了，将次数付为1
				excutenum=1;
			}
			return;
		}
		var result=transport.split("|");
		if(result.length==3){
			transport=result[2];
			if(result[0]!="" && result[1]!=""){
				if(strTrim(result[0])=='CREATEPNR'){
					ajax('/eterm/search/reBook_web.shtml?iterm=reBookValidate&randamTime='+new Date().getTime()+"&pnrno="+result[1],'POST',callreBookvalidat);
				}
			}
			
		}
		main.setAttribute("contentEditable",true);
		if(transport.indexOf("zt:1")>-1){		//政策弹拼状态位
		 	var pos=transport.indexOf("]");
		 	main.insertAdjacentHTML("beforeEnd",transport.substring(pos+1)+"<br/>"+commandset);
		 		document.body.scrollTop=document.body.scrollHeight; //返回数据时让滚动条在最后
		 		 setCursor();
		 	if(document.getElementById('zctptag').value!='1'){
		 		parseAv(transport.substring(5,pos));
		 	}
		}else{
		 	main.insertAdjacentHTML("beforeEnd",transport+"<br/>"+commandset);
		 	document.body.scrollTop=document.body.scrollHeight; //返回数据时让滚动条在最后
		 	setCursor();
		}
        if(fn!=null){
        	fn();
        }
        excutenum=1;
	}
	
	//alert('/eterm.shtml?randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&avhFs="+avhFs+"&command="+encodeURIComponent(command));
		
	var myAjax = new Ajax.Request(
		//command为执行的指令 
		//avhFs默认是1是表示价格提醒，0是直通
		//amsmAndagent 来源 是asms或者agent
		//'/eterm.shtml?randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&avhFs="+avhFs+"&command="+encodeURIComponent(command),
			'pid.jsp?iterm=av&randamTime='+new Date().getTime()+"&amsmAndagent="+document.getElementById("amsmAndagent").value+"&cmd="+encodeURIComponent(command),
		
		
		{
			method: 'post',
			requestHeaders:{Accept:'application/html'},
			//parameters: "randamTime="+new Date().getTime()+"&avhFs="+avhFs+"&command="+encodeURIComponent(command),		//转码
			//onComplete: showResponse,
			onFailure: showFail,
			onException: showException,
			onSuccess: showResponse
		}
	);
}
//获得>的位置和，光标的位置
	function getcommandsetPos(){
		var   pos=-1;
       var   sText=document.selection.createRange();   
       var   tempText=main.document.body.createTextRange(); 
       sText.select();  
       main.focus();   
       tempText.setEndPoint("EndToStart",sText); //从光标到文本的起始
       //var s=tempText.text.replace(/<[^>]+>/g,"");//去掉所有html标签
       //tempText.text.lastIndexOf(">")获得得到的文本的'>'最后一个的位置
	   pos=tempText.text.replaceAll("\r","").lastIndexOf(commandset);//设置起始位置，+1是lastIndexOf 0开始，
	   var pos1=tempText.text.replaceAll("\r","").length;  
	   var posAr=new Array();
	   posAr.push(pos+1);
	    posAr.push(pos1);
	   return posAr;
	}
	//编辑>到光标的位置
	function editStartToCursor(v){
		setCursor();
		var pos=getcommandsetPos();
		var rng = document.selection.createRange();
　 		rng.moveStart("character",-(pos[1]-pos[0]));
　 		rng.moveEnd("character",0);
　 		rng.select();
		rng.text=v;
		setCursor();
		//main.focus();
		//alert(pos[0]+" "+pos[1]);
        //clipboardData.setData('text',v); 
        //document.execCommand('paste');  
       //var s=tempText.text.replace(/<[^>]+>/g,"");//去掉所有html标签
       //tempText.text.lastIndexOf(">")获得得到的文本的'>'最后一个的位置
	  // pos=tempText.text.lastIndexOf(commandset);//设置起始位置，+1是lastIndexOf 0开始，
	  // var s=tempText.text.substring(pos);//获得指令
	}
	
//截取命令
function  getCursorPos(){   
       var   pos=-1;   
       var   sText=document.selection.createRange();   
       var   tempText=main.document.body.createTextRange(); 
       sText.select();  
       tempText.setEndPoint("EndToStart",sText); //从光标到文本的起始
       //var s=tempText.text.replace(/<[^>]+>/g,"");//去掉所有html标签
       //tempText.text.lastIndexOf(">")获得得到的文本的'>'最后一个的位置
       //commandset为全局定义变量“>”，所以这里是的到从“>”到光标里面所有指令
	   pos=tempText.text.lastIndexOf(commandset);//设置起始位置，+1是lastIndexOf 0开始，
	   var s=tempText.text.substring(pos);//获得指令
	   if(pos>-1){
	    //  tempText.moveStart('character',pos );
	    //  tempText.setEndPoint("EndToStart",sText); //在获得文本
	    //  alert(tempText.text);
	    var commands=s.replace(commandset,"");
	  //  parseAv(commands);
	  	//全角转半角的
	    commands=toDBC(commands);
	    commands=strTrim(commands);
	    excuteCommand(commands);
      //  alert("执行的指令是："+commands);
	      
        }else{//如果没有>执行所有内容
        	var commands=commands=toDBC(tempText.text);
	        commands=strTrim(commands);
	        //alert(commands);
	        excuteCommand(commands);
            //alert("请插入>符号");
        }
}  
//光标移到最后一行
function setCursor(){
	 range=document.body.createTextRange(); 
	 range.collapse(true); 
	 range.moveStart('character',-1+main.innerHTML.length); 
	 range.select();
}
function clear(){
	main.innerHTML='';
}
function searchCw(hbh,cw,hc,jx){
		parent.rooteterm.location="/eterm/cwcx.shtml?hkgs="+hbh+"&cws="+cw+"&hc="+hc+"&jx="+jx;
	}
	function hideDiv(){
		document.getElementById('hideDiv').style.display='none';
	}
	
	function showDiv(v){
		var obj = document.getElementById("hideDiv");
		obj.innerHTML=v;
		obj.style.left=event.clientX;
		obj.style.top=event.clientY;
		obj.style.font="12px/1.6em 宋体";
		obj.style.lineHeight ="120%";
		obj.style.display="";
	}
	function initFont(){
		var time_initFont=null;
	//	if(parent.topFrame.success_flag==1){
		//	clearTimeout(time_initFont);
			//setTimeout("parent.topFrame.init()",2000);
		//}else{
			time_initFont=setTimeout("initFont()",3000);
		//}
	}
	//全角转半角的
function toDBC(Str) {
 var DBCStr = "";    
 for(var i=0; i<Str.length; i++){
  var c = Str.charCodeAt(i);
  if(c == 12288) {
      DBCStr += String.fromCharCode(32);
   continue;
  }
  if (c > 65280 && c < 65375) {
   DBCStr += String.fromCharCode(c - 65248);
   continue;
  }
  DBCStr += String.fromCharCode(c);
 }
 return DBCStr;
}
//去掉前后空格
function strTrim(str){
 return str.replace(/(^\s*)|(\s*$)/g, "");
}
function return_weather(transport){
	var json = eval("("+transport+")");
	var row = json.rows;
	var s="";
	for(var i=0;i<json.total;i++){
	s=s+"<a>"+row[i].SZM+","+row[i].SDATE+":"+row[i].CONTENT+"</a>";
	}
	parent.righteterm.document.getElementById('infobar').innerHTML=s;
	parent.righteterm.showClassList();
}
function weather(city,p_time){
	ajax('/weather.shtml?iterm=weather&city='+city+"&time="+p_time,'POST',return_weather);
	window.open("/eterm/city.shtml?city="+city,"","width=450,height=450,toolbar=no,directories=no,status=no,scrollbars=yes,resizable=yes,menubar=no");
}
var log="d:";

function createFiles(texts){
	try{
		var newDateObj = new Date();
		var filename=newDateObj.getYear()+"-"+(newDateObj.getMonth()+1)+"-"+newDateObj.getDate();
		var fso=new ActiveXObject("Scripting.FileSystemObject");
		var f1=fso.OpenTextFile(log+"//"+filename+".txt",8,true); 
		f1.WriteLine(texts); 
	 	f1.Close(); 
	}catch(e){
	}
}
function nextAvh(avhCommand){
	setCursor();
	insertCurrentLine(avhCommand);
	excuteCommand(avhCommand);
	
}
function showFjjx(sid){
     window.open("/eterm/ticket/etermshare/b_comm_plane_info.shtml?action=edit&fjjx="+sid,"","width=450,height=450,toolbar=no,directories=no,status=no,scrollbars=yes,resizable=yes,menubar=no");
}
function jtdSearch(hbh,time){
	window.open("/eterm/etermshare_bs/ff.shtml?iterm=ff&hbh="+hbh+"&time="+time,"","width=200,height=100,toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,menubar=no");

}