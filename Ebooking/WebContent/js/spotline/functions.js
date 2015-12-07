//common javascript functions
/*Haisong Zheng 20050324
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
*/
//additional define method of String object.

//strip blank characters at the beginning and end.
String.prototype.trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

//测试字符串是否符合正则表达式reg
String.prototype.regCheck = function(reg)
{
	return reg.test(this);
}

//测试字符串是否是数字
String.prototype.isNumber = function()
{
	return /^-?[0-9]+\.?[0-9]*$/.test(this);
}

//测试字符串是否是Email地址
String.prototype.isEmail = function()
{
	return /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9])+$/.test(this);
}

//测试字符串是否是URL
String.prototype.isURL = function()
{
	return /^[hf]t{1,2}p:\/\/(\w+:\w+\@)?(?:[0-9a-z-]+\.)+[a-z]{2,4}(?:(\/?)|(\/.*))$/i.test(this);
}

String.prototype.byteLength = function()
{
	var len = 0;
	for(var i = 0; i < this.length; i ++){
		if(this.charCodeAt(i) >= 0x80) len += 3;
		else len += 1;
	}
	return len;
}

/*
highlight display obj on mouse event eventName,
also accept the third param which is an array has 
three elements. value is RGB or predefined color.
*/
function hightlightOnEvent(obj,eventName, org)
{
	var orgColor = "#FFFFFF";
	var actColor = "#FFFF99";
	var sltColor = "#EDCD78";
	if(arguments.length == 3){
		if(typeof(arguments[2]) == "object"){
			orgColor = arguments[2][0] ? arguments[2][0] : orgColor;
			actColor = arguments[2][1] ? arguments[2][1] : actColor;
			sltColor = arguments[2][2] ? arguments[2][2] : sltColor;
		}
	}
	
	if(eventName == 'OVER'){
	    if(obj.bgColor.toUpperCase() != sltColor) obj.bgColor = actColor;
	}
	if(eventName == 'OUT'){
		if(obj.bgColor.toUpperCase() != sltColor) obj.bgColor = orgColor;
	}
	if(eventName == 'CLICK'){
		if(obj.bgColor.toUpperCase() == sltColor) obj.bgColor = actColor;
		else obj.bgColor = sltColor;
	}
}

//图片替换函数，由Dreamweaver产生
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function buy(id)
{
	if(id == '') return;
	window.location = 'buy.php?id='+id;
}

//就近购买
function vicBuy(id)
{
	alert("Product ID is "+id);
}

//检查是否是合法的日期
function checkdate(month, day, year)
{
	if(!(/^[1-9][0-9]{3,3}$/.test(year))){
		alert("年份错误（年份只能由4个数字组成）。");
		return false;
	}
	if(!(/^[0-9]{1,2}$/.test(month))){
		alert("月份只能1-2个由数字组成。");
		return false;
	}
	if(!(/^[0-9]{1,2}$/.test(day))){
		alert("月的天数只能由1－2个数字组成。");
		return false;
	}
	var imonth = parseInt(month);
	var iday = parseInt(day);
	var iyear = parseInt(year);
	if(iyear < 1000 || iyear > 9999){
		alert("年份必须在1000-9999之间。");
		return false;
	}
	if(imonth < 1 || imonth > 12){
		alert("月份必须在1-12之间。");
		return false;
	}
	var maxDay;
	switch(imonth){
		case 4:
		case 6:
		case 9:
		case 11:
			maxDay = 30;
			break;
		case 2:
			if(year % 4 == 0){
				maxDay = 29;
			}else{
				if(iyear % 100 ==0 && iyear % 400 == 0) maxDay = 29;
				else maxDay = 28;
			}
			break;
		default:
			maxDay = 31;
	}
	if(iday > maxDay){
		alert(year + "-" + month +  "-" + day + "不是合法的日期。");
		return false;
	}
	return true;
}

/*预载图片
添加日期：2005-6-8
在页面装载时调用，调用点在header.tpl的body 的onload
*/
function preLoadImages()
{
	var imagesArray = new Array();
	imagesArray[0] = 'images/menu_1r.gif';
	imagesArray[1] = 'images/menu_2r.gif';
	imagesArray[2] = 'images/menu_3r.gif';
	imagesArray[3] = 'images/menu_4r.gif';
	imagesArray[4] = 'images/menu_5r.gif';
	imagesArray[5] = 'images/menu_6r.gif';
	imagesArray[6] = 'images/menu_7r.gif';
	imagesArray[7] = 'images/menu_8r.gif';
	
	for(var i = 0; i < imagesArray.length; i ++) 	MM_preloadImages(imagesArray[i]);
}

/*检查浏览器类型
 添加日期：2005-6-9, Haisong Zheng
 返回浏览器简称，如果IE类浏览返回 MSIE，
*/
function getBrowser()
{
	var bString = navigator.appName + navigator.appVersion;
	if(/MSIE/i.test(bString)) return 'MSIE';
	if(/FireFox/i.test(bString)) return 'FireFox';
	if(/NetScape/i.test(bString)) return 'NetScape';
	if(/Opera/i.test(bString)) return 'Opera';
	
}

/*--------------------------------------------------------------------------------------
以下是信息模块显示功能函数及初始化参数。
通过收集页面相关信息，在特定的区域显示特定的内容
Haisong Zheng
hszheng@gmail.com
2005-06-15
---------------------------------------------------------------------------------------*/
/*新广告处理页面*/
function ShowAdPic()
{
	var a = ShowAdPic.arguments;
	 
	var params = new Array();
	var keyword = a[0]?a[0]:0;
	var type= a[1]?a[1]:0;
	var ad_width= a[2]?a[2]:'';
	var ad_height= a[3]?a[3]:'';
//	var style = a[4]?a[4]:'';	
	if(ad_arr != undefined && ad_arr.length >0)
	{
		var ad_new_arr = new Array();
		var ad_i_j = 0;
		for(var ad_i=0;ad_i<ad_arr.length;ad_i++)
		{
			if(ad_arr[ad_i][0] == keyword && ad_arr[ad_i][1] == type)
			{
				ad_new_arr[ad_i_j] = ad_arr[ad_i];
				ad_i_j++ ;
			}			
		}
		if(ad_new_arr != undefined && ad_new_arr.length >0)
		{
			var rand_index = Math.floor(Math.random()*100)%ad_new_arr.length;
			var tmp_ad = ad_new_arr[rand_index];
			if(tmp_ad[2] != undefined && tmp_ad[3] != undefined)
			{
				if(tmp_ad[4] != undefined)ad_width = tmp_ad[4];
				if(tmp_ad[5] != undefined)ad_height = tmp_ad[5];
				pic_domain_url = (pic_domain_url != undefined)?pic_domain_url:"";
				var ad_src ="<a href='" + tmp_ad[3] + "' target='_blank'>";
				ad_src +="<img src='" + pic_domain_url + tmp_ad[2] + "' width='" + ad_width + "' "+ " height='" + ad_height + "' border='0'></a>";				
				document.write(ad_src);
			}			
		}		
	}	
}
/*---------------------------------------------------------------------------------------*/
//个性化信息处理脚本地址
var individuationInfoURL = '/individuation.php?';

/*显示内容入口
参数顺序为：width, height, type, keyword, style
width : 内容块的宽，以像素为单位
height:　内容块的高，以像素为单位
type:内容类型
qkey : Query string关键词
style : 为内容块的风格，可以为空。目前有效值如下：
bulletin_default
customer_service_default
provider_customer_service_default
*/
function showIndividuationInfo()
{
	var a = showIndividuationInfo.arguments;
	 
	var params = new Array();
	var keyword = a[0]?a[0]:0;
	var type= a[1]?a[1]:0;
	var width= a[2]?a[2]:'';
	var height= a[3]?a[3]:'';
//	var style = a[4]?a[4]:'';
	params[0] = 'keyword='+keyword;
	params[1] = 'type='+type;
	params[2] = 'width=' + width;
	params[3] = 'height=' + height;
	
	
//	params[4] = 'style='+style;
	var info_src = individuationInfoURL + params.join('&');
	outputIndividuationInfo(width, height, info_src);
}

function showAdPics()
{
	var a = showAdPics.arguments;	 
	var params = new Array();
	var keyword = a[0]?a[0]:0;
	var type= a[1]?a[1]:0;
	var width= a[2]?a[2]:'';
	var height= a[3]?a[3]:'';
	var style = a[4]?a[4]:'';
	params[0] = 'keyword='+keyword;
	params[1] = 'type='+type;
	params[2] = 'width=' + width;
	params[3] = 'height=' + height;	
	params[4] = 'style='+style;
	var info_src = individuationInfoURL + params.join('&');
	outputIndividuationInfo(width, height, info_src);
}
function goto(myurl){
	location.href=myurl;
}
function outputIndividuationInfo(width, height, src)
{
//alert(src);
	document.write( '<iframe' +
				   ' name="individuationInfo"' +
				   ' frameborder="0"' +
				   ' marginwidth="0"' +
				   ' marginheight="0"' +
				   ' vspace="0"' +
				   ' hspace="0"' +
				   ' allowtransparency="true"' +
				   ' scrolling="no"' +
				   ' width=' + quote(width) +
				   ' height=' + quote(height) + 
				   ' src=' + quote(src) +
				   '></iframe>'
				   );
}

/*取得页面信息，文件名
*/
function getKeyword()
{
	var info = this.location.toString();
	var kstr = info.substr(info.lastIndexOf('/') + 1);
	return (encodeURIComponent(kstr));
}
/*将字符串加上引号以便组成HTML
*/
function quote(str) {
  return (str != null) ? '"' + str + '"' : '""';
}

function popWin(url, width, height)
{
	window.open(url, "popWindow", "menubar=no, location=no, resizable=no,scrollbars=no, tollbar=no, status=no, width="+ width +", height="+ height +", left=80, top=80");
}

function showBullToMch(domain,id,width,height)
{
	var burl = 'http://'+domain+'/showBulletin.php?id='+id;
	//popWin(burl,width,height);
	window.open(burl, "popWindow", "menubar=no, location=no, resizable=no,scrollbars=yes, tollbar=no, status=no, width="+ width +", height="+ height +", left=80, top=80");
}
function CloseWin()
{
var ua=navigator.userAgent
var ie=navigator.appName=="Microsoft Internet Explorer"?true:false
if(ie){
var IEversion=parseFloat(ua.substring(ua.indexOf("MSIE ")+5,ua.indexOf(";",ua.indexOf("MSIE "))))
if(IEversion< 5.5){
var str = '<object id=noTipClose classid="clsid:ADB880A6-D8FF-11CF-9377-00AA003B7A11">'
str += '<param name="Command" value="Close"></object>';
document.body.insertAdjacentHTML("beforeEnd", str);
document.all.noTipClose.Click();
}
else{
window.opener =null;
window.close();
}
}
else{
window.close()
}
}

function check_form_search(){
	var vu = $("#city").val();
	if(!vu){
		alert('请输入城市');
		$("#city").focus();		
		return false;
	}
	var vp = $("#dtStart").val();
	if(!(/^[1-9][0-9]{3,3}-[0-9]{1,2}-[0-9]{1,2}$/.test(vp))){
			alert('请输入入住日期，格式：YYYY-MM-DD');
			$("#dtStart").focus();	
			return false;
	}
	var vc = $("#dtEnd").val();
	if(!(/^[1-9][0-9]{3,3}-[0-9]{1,2}-[0-9]{1,2}$/.test(vc))){
		alert('请输入离店日期，格式：YYYY-MM-DD');
		$("#dtEnd").focus();	
		return false;
	}
	var fr = $("input:checked").val();
	if(fr==2){
		$("#form_search2").attr('action','http://www.innutd.cn/hotel_list.php');
		$("#form_search2").submit();
	}
}

function check_form_search_99(){
	var vu = $("#city").val();
	var vp = $("#dtStart").val();
	if(!(/^[1-9][0-9]{3,3}-[0-9]{1,2}-[0-9]{1,2}$/.test(vp))){
			alert('请输入入住日期，格式：YYYY-MM-DD');
			$("#dtStart").focus();	
			return false;
	}
	var vc = $("#dtEnd").val();
	if(!(/^[1-9][0-9]{3,3}-[0-9]{1,2}-[0-9]{1,2}$/.test(vc))){
		alert('请输入离店日期，格式：YYYY-MM-DD');
		$("#dtEnd").focus();	
		return false;
	}
	var fr = $("input:checked").val();
	if(fr==2){
		$("#form_search2").attr('action','http://www.innutd.cn/hotel_list.php');
		$("#form_search2").submit();
	}
}

function select_main_menu(id){
	$("#main_nav_id >li").each(function(){
		$(this).removeClass('here');
	});
	$("#main_nav_id >li").eq(id).addClass('here');
}
function show_me_toggel(id){
}
function select_this(id){
	$("#selul >li").each(function(){
		$(this).removeClass('here');
	});
	$("#selul >li").eq(id).addClass('here');
	$(".div_h").each(function(){
		$(this).hide();
	});	
	$("#tab_"+id).show();
}
var pc_ret;
function params_check(obj,p1){
	var ov = obj.value;
	$.ajax({
			 type: "GET",
			 url: "check.php",
			 data: str='check_type='+p1+'&p1='+ov,
			 dataType:"json",
			 success: function(json){//&& json.data.order_id!=undefine
			 							if(json.code==1){
											$("#div_check_"+p1).html("<img src='images/checked.gif'/>");
								   	}else{
						      	 	$("#div_check_"+p1).html("<img src='images/unchecked.gif'/>"+json.msg);
						      	 //	obj.focus();
							      }
							      pc_ret = json.code;
			 				 } 
		}); 
	
}

function compareDate(date1,date2){	
	var d1 = new Date(date1.replace(/-/g,"/"));
	var d2 = new Date(date2.replace(/-/g,"/"));
	if(Date.parse(d2) - Date.parse(d1) > 0)
	{
		return true;
	}else return false;

	
	

	var a,ass,aD,aS;
	var b,bss,bD,bS;
	
	a=date1; //得到现在时间；
	b=date2;     //得到选择时间；
	
	ass=a.split("-");        //以"-"分割字符串，返回数组；
	aD=new Date(ass[0],ass[1],ass[2]); //格式化为Date对像;
	aS=aD.getTime(); //得到从 1970 年 1 月 1 日开始计算到 Date 对象中的时间之间的毫秒数
	bss=b.split("-");
	
	bD=new Date(bss[0],bss[1],bss[2]);
	bS=bD.getTime();
	alert(aS);
	alert(bS);
	if(bS<aS)return false;
	else return true;
}

function userConfirm(title,mylink){
	if(confirm(title)){
		location.href=mylink;
	}else{
		return;
	}


}