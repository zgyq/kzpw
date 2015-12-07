
<link href="skin/black/css/qq.css" rel="stylesheet" type="text/css" />

<div class="qqbox" id="divQQbox">
  <div class="qqlv" id="meumid" onmouseover="show()"><img src="images/aqq.gif"></div>
  <div class="qqkf" style="display:none;" id="contentid" onmouseout="hideMsgBox(event)">
    <div class="qqkfbt" onmouseout="showandhide('qq-','qqkfbt','qqkfbt','K',5,1);" id="qq-1" onfocus="this.blur();">客 服 中 心</div>
    <div id="K1">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a></div>
      <div class="qqkfhm bgdh">手机：131111111111</div>
    </div>
    <div class="qqkfbt" onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,2);" id="qq-2" onfocus="this.blur();">财 务 充 值</div>
    <div id="K2" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a></div>
      <div class="qqkfhm bgdh">手机：13955432222</div>
    </div>
    <div class="qqkfbt"  onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,3);" id="qq-3" onfocus="this.blur();">机 房 值 班</div>
    <div id="K3" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a></div>
      <div class="qqkfhm bgdh">手机：13222235523</div>
    </div>
    <div class="qqkfbt"  onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,4);" id="qq-4" onfocus="this.blur();">渠 道 咨 询</div>
    <div id="K4" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a></div>
      <div class="qqkfhm bgdh">手机：13222225523</div>
    </div>
    <div class="qqkfbt" onClick="showandhide('qq-','qqkfbt','qqkfbt','K',5,5);" id="qq-5" onfocus="this.blur();">投 诉 建 议</div>
    <div id="K5" style="display:none">
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a><br/></div>
      <div class="qqkfhm bgdh"> <a href="tencent://message/?uin=1193367"><img src="http://wpa.qq.com/pa?p=1:1193367:4" border="0">在线客服</a></div>
      <div class="qqkfhm bgdh">手机：15011401852</div>
    </div>
  </div>
</div>
<script language="javascript">
function showandhide(h_id,hon_class,hout_class,c_id,totalnumber,activeno) {
    var h_id,hon_id,hout_id,c_id,totalnumber,activeno;
    for (var i=1;i<=totalnumber;i++) {
        document.getElementById(c_id+i).style.display='none';
        document.getElementById(h_id+i).className=hout_class;
    }
    document.getElementById(c_id+activeno).style.display='block';
    document.getElementById(h_id+activeno).className=hon_class;
}
var tips; 
var theTop = 100;
var old = theTop;
function initFloatTips() 
{ 
	tips = document.getElementById('divQQbox');
	moveTips();
}
function moveTips()
{
	 	  var tt=50; 
		  if (window.innerHeight) 
		  {
		pos = window.pageYOffset  
		  }else if (document.documentElement && document.documentElement.scrollTop) {
		pos = document.documentElement.scrollTop  
		  }else if (document.body) {
		    pos = document.body.scrollTop;  
		  }
		  //http:
		  pos=pos-tips.offsetTop+theTop; 
		  pos=tips.offsetTop+pos/10; 
		  if (pos < theTop){
			 pos = theTop;
		  }
		  if (pos != old) { 
			 tips.style.top = pos+"px";
			 tt=10;//alert(tips.style.top);  
		  }
		  old = pos;
		  setTimeout(moveTips,tt);
}
initFloatTips();
//	if(typeof(HTMLElement)!="undefined")//给firefox定义contains()方法，ie下不起作用
//		{  
//		  HTMLElement.prototype.contains=function (obj)  
//		  {  
//			  while(obj!=null&&typeof(obj.tagName)!="undefind"){//
//	   　　 　if(obj==this) return true;  
//	   　　　	　obj=obj.parentNode;
//	   　　	  }  
//			  return false;  
//		  }
//	}
function show()
{
	document.getElementById("meumid").style.display="none"
	document.getElementById("contentid").style.display="block"
}
	function hideMsgBox(theEvent){
	  if (theEvent){
		var browser=navigator.userAgent;
		if (browser.indexOf("Firefox")>0){//Firefox
		    if (document.getElementById("contentid").contains(theEvent.relatedTarget)) {
				return
			}
		}
		if (browser.indexOf("MSIE")>0 || browser.indexOf("Presto")>=0){
	        if (document.getElementById('contentid').contains(event.toElement)) {
			    return;//结束函式
		    }
		}
	  }
	  document.getElementById("meumid").style.display = "block";
	  document.getElementById("contentid").style.display = "none";
 	}
</script>
