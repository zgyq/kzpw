<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>晨轩商旅网</title>
<link href="main_cx/css/global.css" rel="stylesheet" type="text/css">

<link href="main_cx/css/main.css" rel="stylesheet" type="text/css">
</head>

<style>
body{background:url('');margin:0px;padding:0px}
input{margin:5px;padding:0px;border:1px solid #000;}
</style>
<script type="text/javascript">
var MyWin = new Win();
var imgfile = "http://www.poluoluo.com/example/css/1/img/"; //设置图片路径,相对或绝对都行
var imgname=new Array();
var img = new Array();
imgname[0] = imgfile+"c.gif";  
imgname[1] = imgfile+"b1.png";
imgname[2] = imgfile+"l1.png";  
imgname[3] = imgfile+"l2.png";  
imgname[4] = imgfile+"r1.png";  
imgname[5] = imgfile+"r2.png";  
imgname[6] = imgfile+"t1.png";  
imgname[7] = imgfile+"t2.png";  
imgname[8] = imgfile+"t3.png";  
//预读图片
for (i=0;i<=imgname.length-1;i++)
{
   img[i] = new Image();
   img[i].src = imgname[i];
}
var zIndex = 0;
var Winid  = 0;
var Ie = /msie/i.test(navigator.userAgent);
function $(Id){return(document.getElementById(Id))}
function Win()
{
 this.Create = function(mask,title, wbody, w, h, l, t)
 {
  Winid++;
  mask = mask;
  title = title || "新窗口 - 加载中...";
  wbody = wbody || " <p align='center'>正在载入…</p>";
  w = w || 350;
  h = h || 150;
  cw = document.documentElement.clientWidth;
  ch = document.documentElement.clientHeight;
  sw = document.documentElement.scrollWidth;
  sh = document.documentElement.scrollHeight;
        st = (document.documentElement.scrollTop || document.body.scrollTop);
  if (w > cw)
  ww = 0;
  else
  ww = (cw - w)/2;
  if (h > ch)
  hh = 0;
  else
  hh = (st + (ch - h)/2);
  l = l || ww;
  t = t || hh;
  
        if (mask != "no"){
    var ndiv = document.createElement("DIV");
    ndiv.setAttribute("id", "ndiv"+ Winid);
    ndiv.style.cssText = "width:"+ sw +"px;height:"+ sh +"px;left:0px;top:0px;position:absolute;overflow:hidden;background:#fff;filter:alpha(opacity=20); opacity:0.2;-moz-opacity:0.2;";
    document.body.appendChild(ndiv);
  
    if (Ie)
    {
    var niframe = document.createElement("iframe");
    niframe.style.width = sw;
    niframe.style.height = sh;    
          niframe.style.top = "0px";    
          niframe.style.left = "0px";  
          niframe.style.visibility = "inherit";    
          niframe.style.filter = "alpha(opacity=0)";    
          niframe.style.position = "absolute";    
          niframe.style.zIndex = -1;   
    ndiv.insertAdjacentElement("afterBegin",niframe);
    }
        }
  var mywin = document.createElement("DIV");
  mywin.setAttribute("id", "win"+ Winid);
  mywin.style.cssText = "width:"+ w +"px;height:"+ h +"px;left:0px;top:0px;position:absolute;overflow:hidden;padding:0px;font-family:Arial, 宋体";
  mywin.style.zIndex = ++zIndex;
  document.body.appendChild(mywin);
  
  var mytie = document.createElement("DIV");
  var myboy = document.createElement("DIV");
  var mybom = document.createElement("DIV");
  
  mytie.style.cssText = "overflow:hidden;height:30px;font-weight:bold;font-size:14px;width:100%";
  myboy.style.cssText = "overflow:hidden;width:100%";
  mybom.style.cssText = "overflow:hidden;height:30px;width:100%";
  
  mywin.appendChild(mytie);
  mywin.appendChild(myboy);
  mywin.appendChild(mybom);
  var wintag = [[mytie, 30, 15, "t1"], [mytie, 30, w-30, "t2"], [mytie, 30, 15, "t3"], [myboy, h-45, 15, "l1"], [myboy, h-47, w-32], [myboy, h-45, 15, "r1"], [mybom, 15, 15, "l2"], [mybom, 15, w-30, "b1"], [mybom, 15, 15, "r2"]];
  for (var i = 0; i < 9; i++)
  {
   var temp = document.createElement("DIV");
   temp.setAttribute("Fid", "win"+ Winid);
   wintag[i][0].appendChild(temp);
      if (wintag[i][3])
   {
    temp.style.cssText = "float:left;height:"+ wintag[i][1] +"px;width:"+ wintag[i][2] +"px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+imgfile+""+ wintag[i][3] +".png', sizingMethod='scale');background:url('"+imgfile+""+ wintag[i][3] +".png') !important;background:;";
   }
   else
   {
    temp.style.cssText = "float:left;filter:alpha(Opacity=95,style=0);opacity:0.95;height:"+ wintag[i][1] +"px;width:"+ wintag[i][2] +"px;background:#f7f7f7;border:1px solid #666;overflow:hidden;padding:0px";
   }
  }
  mytie.childNodes[1].innerHTML = "<div style=\"position:absolute;overflow:hidden;height:15px;top:12px;padding-left:4px;padding-right:4px;\"></div><div style=\"position:absolute;background:url('"+imgfile+"c.gif');overflow:hidden;width:43px;height:17px;top:7px !important;right:15px\" title=\"关闭窗口\" onclick=\"MyWin.Close('win"+ Winid +"',10); MyWin.ndiv('ndiv"+ Winid +"',10);\"></div>";
  this.Title("win"+ Winid, title);
  this.Body("win"+ Winid, wbody);
  this.Move_e("win"+ Winid, l, t, 0, 0);
  return(mywin);
 }
 this.Title = function(Id, title)
 {
     if (Id == null) return;
     var o = $(Id);
     if (!o) return;
     o.childNodes[0].childNodes[1].childNodes[0].innerHTML = title;
 }
 this.Body = function(Id, wbody)
 {
     if (Id == null) return;
     var o = $(Id);
        if (!o) return;
        if (wbody.slice(0, 4) == "[pg]")
            o.childNodes[1].childNodes[1].innerHTML = "<iframe onfocus=\"MyWin.Show('"+ Id +"',this)\" src='"+ wbody.slice(4) +"' frameBorder='0' marginHeight='0' marginWidth='0' scrolling='no' width='100%' height='100%'></iframe>";
        else
            o.childNodes[1].childNodes[1].innerHTML = wbody;
 }
 this.Show = function(Id)
    {     
     if (Id == null) return;
     var o = $(Id);
        if (!o) return;
     o.style.zIndex = ++zIndex;
    }
    this.Move_e = function(Id, l , t, ll, tt)
    {
     if (typeof(window["ct"+ Id]) != "undefined") clearTimeout(window["ct"+ Id]);
     var o = $(Id);
     if (!o) return;
      o.style.left = l +"px";
      o.style.top = t +"px";
     window["ct"+ Id] = window.setTimeout("MyWin.Move_e('"+ Id +"', "+ l +" , "+ t +", "+ ll +", "+ tt +")", 1);
    }
    this.Close = function(Id, Opacity)
    {
     if (typeof(window["et"+ Id]) != "undefined") clearTimeout(window["et"+ Id]);
     var o = $(Id);
     if (!o) return;
     if (Opacity == 10) o.childNodes[0].childNodes[1].innerHTML = "";
     if (Ie)
     {
      o.style.filter = "alpha(opacity="+ Opacity +",style=0)";
     }
     else
     {
      o.style.opacity = Opacity / 10;
     }
     if (Opacity > 20)
      Opacity -= 10;
     else
      Opacity--;
     if (Opacity <= 0)
     {
         if (o.getElementsByTagName("IFRAME").length != 0)
         {
             o.getElementsByTagName("IFRAME").src = "about:blank";
         }
         o.innerHTML = "";
      document.body.removeChild(o);
      return;
     }
     window["et"+ Id] = window.setTimeout("MyWin.Close('"+ Id +"', "+ Opacity +")", 1);
    }
    this.ndiv = function(Id, Opacity)
    {
     var o = $(Id);
     if (!o) return;
     o.innerHTML = "";
  document.body.removeChild(o);
  return;
    }
}
</script>

<body>
<form name="form1" method="post" action="welcome.htm" id="form1">
<div><input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
	value="/wEPDwUKMTM4MDM2MTcwMw9kFgICAw9kFgJmDxYCHgtfIUl0ZW1Db3VudAIBFgJmD2QWAmYPFQQEVmlldwExLeWFs+S6juilv+mDqOiIquepuuWkquWOn+i/m+WHuua4r+iIquePrei9rOiHsy3lhbPkuo7opb/pg6joiKrnqbrlpKrljp/ov5vlh7rmuK/oiKrnj63ovazoh7NkZLjATm28IaFuK88yEVK5M6zsGfbCs+qHDkCIKZ0BffSf"></div>


<div class="g-mn" style="margin-top: 10px;">
<div class="m-mn">
<div class="info">
<p class="log"><span>上次登陆IP:<i><ww:property value="shangciloginip" /></i></span> <span>上次登陆时间:<i><ww:property value="shangcilogintime" /></i></span></p>
<div class="user f-cb">
<div class="name">公司名称:<span>${dns.address}</span></div>
<div class="m1" style="display: none;">信用额度:<i>10000.35</i>元</div>
<div class="m1">剩余短信条数:<i>0</i>条</div>
<div class="m1">账户余额:<i><ww:property value="getAgentMoney_B2B(#session.loginuser.agentid)" /></i>元</div>
<div class="m2"></div>
</div>
<div class="panel" style="display: block;">
<div class="btn" ><a class="pay"
	href="ymuser!torecharge.action"
	target="member">短信充值</a>
	
	<a class="pay"
	href="rebaterecord.action"
	target="member">虚拟充值</a>
	
	</div>
<div class="detail" style="margin-left: 10px">
<a
	href="rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="#session.loginuser.agentid" />"
	target="member">账户明细(保护充值和消费)</a>
	
<a
	href="rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="#session.loginuser.agentid" />&rebaterecord.rebatetype=3"
	target="member">充值明细</a>
	
	<a
	href="rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="#session.loginuser.agentid" />&rebaterecord.rebatetype=2"
	target="member">交易明细</a>
	
	
	
	<a
	href="login!toeditpaypwd.action"
	target="member">修改支付密码</a>
	
	
	</div>
	
</div>
<!-- rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=54 -->
</div>
<div class="order" style="background:url('main_cx/img/order-bg.jpg');">
<div class="gn" style="cursor: pointer"
	onclick="GoUrl('b2bairticket!toTicket.action')"></div>
<div class="gnpnr" style="cursor: pointer"
	onclick="GoUrl('b2bairticket!toRtPnr.action')"></div>
<div class="gj" onclick="GoUrl('login!getMemberByOrder.action?s_membertype=3&importtype=1&puser&ywtype=2')" style="cursor: pointer"></div>
<div class="gjrt" style="cursor: pointer"></div>
</div>
<div class="center f-cb">
<div class="c1"><i></i><a
	href="b2bairticket!toRtPnr.action" target="member">PNR导单</a></div>
	
	
	<div class="c1"><i></i><a
	href="b2bairticket!toTicket.action" target="member">国内机票</a></div>
	
	<div class="c1">
	<img src="images/airComlogo/9C.gif" width="35px;" height="35px;" style="margin-top: -18px;margin-left: -18px;" />
	
	<a
	href="b2b9cairticket!toTicket.action" target="member">春秋机票</a></div>
	
	<div class="c1"><i></i><a
	href="b2bairticket!toGroupTicket.action" target="member">团队申请</a></div>
	
	
<div class="c1"><i></i><a
	href="http://php.weather.sina.com.cn/flight/" target="member">航班动态</a></div>
<div class="c2"><i></i><a
	href="main_cx/AirTuiGaiQian.jsp" target="member">退改签规定</a></div>
	
<div class="c2"><i></i><a
	href="main_cx/AirTuiGaiQian_9c.jsp" target="member">春秋退改签</a></div>
	
	
<div class="c3"><i></i><a
	href="#">软件下载</a></div>
<div class="c5"><i></i><a
	href="main_cx/AirTel.jsp"
	target="member">航空公司电话</a></div>

</div>
<div class="notice">
<h3 class="head"><i></i>网站公告</h3>
<ul class="f-cb">
<ww:iterator value="sysmessageList">
	<li style="width: 650px;">&gt;&gt; [<span>最新公告</span>]<a
		href="#" onclick="ShowMes(<ww:property  value="id" />);return false;"
		title="<ww:property value="title"   />"><ww:property  value="title" /></a></li>
</ww:iterator>

 
 
</ul>
</div>
<style>
.LinkUl { float:left;width: 20%}
</style>


<div class="notice" id="footer" style="height: 1400px;" >
<h3 class="head"><i></i>春秋航线</h3>
<ul class="f-cb LinkUl" >
<li ><span>上海虹桥-常德</span></li>
<li ><span>上海虹桥-长沙</span></li>
<li ><span>上海虹桥-成都</span></li>
<li ><span>上海虹桥-广州</span></li>
<li ><span>上海虹桥-贵阳</span></li>
<li ><span>上海虹桥-怀化</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海虹桥-昆明</span></li>
<li ><span>上海虹桥-兰州</span></li>
<li ><span>上海虹桥-南宁</span></li>
<li ><span>上海虹桥-黔江</span></li>
<li ><span>上海虹桥-青岛</span></li>
<li ><span>上海虹桥-庆阳</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海虹桥-泉州</span></li>
<li ><span>上海虹桥-汕头</span></li>
<li ><span>上海虹桥-深圳</span></li>
<li ><span>上海虹桥-石家庄</span></li>
<li ><span>上海虹桥-西安</span></li>
<li ><span>上海虹桥-厦门</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海虹桥-银川</span></li>
<li ><span>上海虹桥-重庆</span></li>
<li ><span>上海虹桥-珠海</span></li>
<li ><span>上海虹桥-遵义</span></li>
<li ><span>上海浦东-北海</span></li>
<li ><span>上海浦东-长春</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海浦东-大连</span></li>
<li ><span>上海浦东-大连</span></li>
<li ><span>上海浦东-贵阳</span></li>
<li ><span>上海浦东-哈尔滨</span></li>
<li ><span>上海浦东-海口</span></li>
<li ><span>上海浦东-昆明</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海浦东-兰州</span></li>
<li ><span>上海浦东-绵阳</span></li>
<li ><span>上海浦东-沈阳</span></li>
<li ><span>上海浦东-厦门</span></li>
<li ><span>上海浦东-湛江</span></li>
<li ><span>上海浦东-重庆</span></li>

</ul>
<ul class="f-cb LinkUl" >
<li ><span>上海浦东-珠海</span></li>
<li ><span>北海-上海浦东</span></li>
<li ><span>常德-昆明</span></li>
<li ><span>常德-上海虹桥</span></li>
<li ><span>长春-上海浦东</span></li>
<li ><span>长春-通辽</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>长沙-上海虹桥</span></li>
<li ><span>成都-上海虹桥</span></li>
<li ><span>成都-石家庄</span></li>
<li ><span>大连-上海浦东</span></li>
<li ><span>福州-石家庄</span></li>
<li ><span>广州-上海虹桥</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>广州-石家庄</span></li>
<li ><span>贵阳-上海虹桥</span></li>
<li ><span>贵阳-上海浦东</span></li>
<li ><span>哈尔滨-淮安</span></li>
<li ><span>哈尔滨-上海浦东</span></li>
<li ><span>海口-杭州</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>海口-上海浦东</span></li>
<li ><span>杭州-海口</span></li>
<li ><span>杭州-深圳</span></li>
<li ><span>杭州-沈阳</span></li>
<li ><span>杭州-石家庄</span></li>
<li ><span>杭州-西安</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>怀化-昆明</span></li>
<li ><span>怀化-上海虹桥</span></li>
<li ><span>淮安-哈尔滨</span></li>
<li ><span>淮安-深圳</span></li>
<li ><span>昆明-常德</span></li>
<li ><span>昆明-怀化</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>昆明-绵阳</span></li>
<li ><span>昆明-黔江</span></li>
<li ><span>昆明-上海虹桥</span></li>
<li ><span>昆明-石家庄</span></li>
<li ><span>昆明-遵义</span></li>
<li ><span>兰州-上海浦东</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>洛阳-沈阳</span></li>
<li ><span>洛阳-重庆</span></li>
<li ><span>绵阳-昆明</span></li>
<li ><span>绵阳-上海虹桥</span></li>
<li ><span>绵阳-沈阳</span></li>
<li ><span>南宁-上海浦东</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>黔江-昆明</span></li>
<li ><span>黔江-上海虹桥</span></li>
<li ><span>青岛-上海虹桥</span></li>
<li ><span>庆阳-银川</span></li>
<li ><span>泉州-上海虹桥</span></li>
<li ><span>汕头-上海虹桥</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>深圳-杭州</span></li>
<li ><span>深圳-淮安</span></li>
<li ><span>深圳-上海虹桥</span></li>
<li ><span>深圳-石家庄</span></li>
<li ><span>深圳-通辽</span></li>
<li ><span>深圳-盐城</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>深圳-张家口</span></li>
<li ><span>沈阳-杭州</span></li>
<li ><span>沈阳-洛阳</span></li>
<li ><span>沈阳-绵阳</span></li>
<li ><span>沈阳-上海浦东</span></li>
<li ><span>沈阳-石家庄</span></li>
</ul>

<ul class="f-cb LinkUl" >
<li ><span>沈阳-西安</span></li>
<li ><span>沈阳-张家口</span></li>
<li ><span>石家庄-成都</span></li>
<li ><span>石家庄-福州</span></li>
<li ><span>石家庄-广州</span></li>
<li ><span>石家庄-杭州</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>石家庄-昆明</span></li>
<li ><span>石家庄-上海虹桥</span></li>
<li ><span>石家庄-上海浦东</span></li>
<li ><span>石家庄-深圳</span></li>
<li ><span>石家庄-沈阳</span></li>
<li ><span>石家庄-厦门</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>石家庄-重庆</span></li>
<li ><span>天津-盐城</span></li>
<li ><span>通辽-长春</span></li>
<li ><span>通辽-深圳</span></li>
<li ><span>乌鲁木齐-西安</span></li>
<li ><span>西安-杭州</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>西安-上海虹桥</span></li>
<li ><span>西安-沈阳</span></li>
<li ><span>西安-乌鲁木齐</span></li>
<li ><span>厦门-上海虹桥</span></li>
<li ><span>厦门-上海浦东</span></li>
<li ><span>厦门-石家庄</span></li>
</ul>

<ul class="f-cb LinkUl" >
<li ><span>盐城-深圳</span></li>
<li ><span>盐城-天津</span></li>
<li ><span>银川-庆阳</span></li>
<li ><span>银川-上海虹桥</span></li>
<li ><span>湛江-上海浦东</span></li>
<li ><span>张家口-深圳</span></li>
<li ><span>张家口-沈阳</span></li>
</ul>
<ul class="f-cb LinkUl" >
<li ><span>重庆-洛阳</span></li>
<li ><span>重庆-上海虹桥</span></li>
<li ><span>重庆-上海浦东</span></li>
<li ><span>重庆-石家庄</span></li>
<li ><span>珠海-上海虹桥</span></li>
<li ><span>遵义-昆明</span></li>
<li ><span>遵义-上海虹桥</span></li>
</ul>



</div>
</div>
</div>

</form>


</body>
</html>
 <script>
 
         
        function GoUrl(ur){
		 window.location.href=ur;
}

<ww:if test="sysmessage!=null&&sysmessage.id>0">
MyWin.Create("","<span style='color: red;font-size: 14px;'><ww:property value='sysmessage.title' /></span>","[pg]login!toshowsysmessage.action?sysid=<ww:property value='sysmessage.id' />","800","500");

//MyWin.Create("","<span style='color: red;font-size: 14px;'><ww:property value='sysmessage.title' /></span>","[pg]login!toshowsysmessage.action?sysid=<ww:property value='sysmessage.id' />","800","500");
	//MyWin.Create("","<span style='color: red;font-size: 14px;'><ww:property value='sysmessage.title' /></span>","<span style='color: red;font-size: 16px;'><ww:property value='sysmessage.content' /></span>","600","400");
</ww:if>
	
   function  ShowMes(id){
   
   window.open('login!toshowsysmessage.action?sysid='+id,    '_blank',    'scrollbars=Vertical,resizable=0,height=660,width=1160,top=150,left=200');
   
   }
   
 </script>