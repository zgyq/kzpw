var tr01_01 = "#ff0000"; //第一行背景颜色
var tr01_02 = "#cccccc"; //第二行背景颜色
var tr01_03 = "#FFFFFF";
//var tab01 = "#656565";  //边框颜色
var tab01 = "#2F7495";  //边框颜色
var kongj;
var kongj_code;
var clicObj;

//tile
var style1 = 'style="color: #656565;BACKGROUND-COLOR:#e7f1fd;font-size: 9pt;"';

//title:城市拼音首字母
var style2 = 'style="BACKGROUND-COLOR: #c8e3fc; color: #656565;background-repeat:repeat-x; background-position:bottom; font-size: 9pt;"';

var style3 = 'style="position: relative; left: 0px; top: 0px; width: 100%;overflow:hidden; text-overflow:ellipsis;"';

//北京|PEK|B  城市|三字代码|拼音首字母
var shcs = new Array("上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C");
var qtcs = new Array("上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C","北京|BJS|B","纽约|NYC|N","泗水|SUB|S","三宝垄|SRG|S","万隆|BDO|B","棉兰|MES|M","巴东|PDG|P","玛琅|MLG|M","帝力|DIL|D","河内|HAN|H","万象|VTE|V","金边|PNH|P","曼谷|BKK|B","普吉|HKT|H","仰光|RGN|R","廷布|QJC|Q","加德满都|KTM|K","达卡|DAC|D","科伦坡|CMB|C","马累|MLE|M","香港|HKG|H","东京|NRT|A","台北|TPE|A","首尔|ICN|A","新加坡|SIN|A","曼谷|BKK|B","吉隆坡|KUL|B","大阪|ITM|B","澳门|MFM|B","雅加达|CGK|C","胡志明市|SGN|C","马尼拉|MNL|C","巴厘岛|BPN|C","名古屋|NGO|C","普吉岛|HKT|C","河内|HAN|C","马累|MLE|C","迪拜|DXB|C","釜山|PUS|C","加德满都|KTM|D","高雄|KHH|D","福冈|FUK|D","金边|PNH|D","新德里|DEL|D","济州岛|CJU|D","札幌|CTS|D","伊斯坦布尔|IST|D","乌兰巴托|ULN|E","孟买|BOM|E","伦敦|LCY|G","巴黎|ORY|G","法兰克福|FRA|G","莫斯科|DME|G","罗马|GHN|G","阿姆斯特丹|AMS|G","米兰|KWE|G","慕尼黑|MUC|H","斯德哥尔摩|ARN|H","柏林|TXL|H","曼彻斯特|MHT|H","马德里|MAD|H","苏黎世|ZRH|H","布鲁塞尔|BRU|H","哥本哈根|CPH|H","赫尔辛基|HEL|H","维也纳|VIE|H","巴塞罗那|BCN|H","雅典|ATH|H","爱丁堡|EDI|H","伯明翰(英|BHX|H","纽卡斯尔|NCL|H","日内瓦|GVA|H","圣彼得堡|LED|J","格拉斯哥|GLA|J","基辅|KBP|J","布达佩斯|BUD|J","汉堡|HAM|J","布拉格|PRG|J","杜塞尔多夫|DUS|J","纽约|NYC|K","洛杉矶|LAX|K","旧金山|SFO|K","温哥华|YVR|K","芝加哥|CHI|K","多伦多|YYZ|K","西雅图|SEA|L","华盛顿|IAD|L","底特律|DTW|L","亚特兰大|ATL|L","休斯顿|IAH|L","悉尼|SYD|L","蒙特利尔|YUL|L","塞班|SPN|M","达拉斯|DFW|M","明尼阿波利|MSP|M","圣保罗|GRU|N","渥太华|YOW|N","墨西哥城|MEX|N","拉斯维加斯|LAS|N","迈阿密|MIA|N","丹佛|DEN|N","奥兰多|MCO|N","波特兰|PWM|N","圣保罗|GRU|N","曼彻斯特|MHT|N","布宜诺斯艾|BUE|N","开罗|CAI|P","约翰内斯堡|JNB|Q","开普敦|CPT|Q","内罗毕|NBO|Q","拉各斯|LOS|Q","罗安达|LAD|Q","毛里求斯|MRU|Q","亚的斯亚贝|ADD|S","突尼斯|TUN|S","卢萨卡|LUN|S","哈拉雷|HRE|S","雅温得|YAO|S","哈博罗内|GBE|S","金沙萨|FIH|S","马普托|MPM|S","杜阿拉|DLA|S","悉尼|SYD|X","墨尔本|MEL|X","奥克兰|AKL|X","布里斯班|BNE|X","阿德莱德|ADL|X","珀斯|PER|X","惠灵顿|WLG|X","堪培拉|CBR|X","凯恩斯|CNS|X","克赖斯特彻|CHC|X","楠迪|NAN|Y","黄金海岸|OOL|Y","达尔文|DRW|Y","霍巴特|HBA|Y");
//城市名
var csms = new Array;
csms[0]=["上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C"];
csms[1]=["北京|BJS|B","纽约|NYC|N","泗水|SUB|S","三宝垄|SRG|S","万隆|BDO|B","棉兰|MES|M","巴东|PDG|P","玛琅|MLG|M","帝力|DIL|D","河内|HAN|H","万象|VTE|V","金边|PNH|P","曼谷|BKK|B","普吉|HKT|H","仰光|RGN|R","廷布|QJC|Q","加德满都|KTM|K","达卡|DAC|D","科伦坡|CMB|C","马累|MLE|M"];
csms[2]=["香港|HKG|H","东京|NRT|A","台北|TPE|A","首尔|ICN|A","新加坡|SIN|A","曼谷|BKK|B","吉隆坡|KUL|B","大阪|ITM|B","澳门|MFM|B","雅加达|CGK|C","胡志明市|SGN|C","马尼拉|MNL|C","巴厘岛|BPN|C","名古屋|NGO|C","普吉岛|HKT|C","河内|HAN|C","马累|MLE|C","迪拜|DXB|C","釜山|PUS|C","加德满都|KTM|D","高雄|KHH|D","福冈|FUK|D","金边|PNH|D","新德里|DEL|D","济州岛|CJU|D","札幌|CTS|D","伊斯坦布尔|IST|D","乌兰巴托|ULN|E","孟买|BOM|E"];
csms[3]=["伦敦|LCY|G","巴黎|ORY|G","法兰克福|FRA|G","莫斯科|DME|G","罗马|GHN|G","阿姆斯特丹|AMS|G","米兰|KWE|G","慕尼黑|MUC|H","斯德哥尔摩|ARN|H","柏林|TXL|H","曼彻斯特|MHT|H","马德里|MAD|H","苏黎世|ZRH|H","布鲁塞尔|BRU|H","哥本哈根|CPH|H","赫尔辛基|HEL|H","维也纳|VIE|H","巴塞罗那|BCN|H","雅典|ATH|H","爱丁堡|EDI|H","伯明翰(英|BHX|H","纽卡斯尔|NCL|H","日内瓦|GVA|H","圣彼得堡|LED|J","格拉斯哥|GLA|J","基辅|KBP|J","布达佩斯|BUD|J","汉堡|HAM|J","布拉格|PRG|J","杜塞尔多夫|DUS|J"];
csms[4]=["纽约|JKF|K","洛杉矶|LAX|K","旧金山|SFO|K","温哥华|YVR|K","芝加哥|CHI|K","多伦多|YYZ|K","西雅图|SEA|L","华盛顿|IAD|L","底特律|DTW|L","亚特兰大|ATL|L","休斯顿|IAH|L","悉尼|SYD|L","蒙特利尔|YUL|L","塞班|SPN|M","达拉斯|DFW|M","明尼阿波利|MSP|M","圣保罗|GRU|N","渥太华|YOW|N","墨西哥城|MEX|N","拉斯维加斯|LAS|N","迈阿密|MIA|N","丹佛|DEN|N","奥兰多|MCO|N","波特兰|PWM|N","圣保罗|GRU|N","曼彻斯特|MHT|N","布宜诺斯艾|BUE|N"];
csms[5]=["开罗|CAI|P","约翰内斯堡|JNB|Q","开普敦|CPT|Q","内罗毕|NBO|Q","拉各斯|LOS|Q","罗安达|LAD|Q","毛里求斯|MRU|Q","亚的斯亚贝|ADD|S","突尼斯|TUN|S","卢萨卡|LUN|S","哈拉雷|HRE|S","雅温得|YAO|S","哈博罗内|GBE|S","金沙萨|FIH|S","马普托|MPM|S","杜阿拉|DLA|S"];
csms[6]=["悉尼|SYD|X","墨尔本|MEL|X","奥克兰|AKL|X","布里斯班|BNE|X","阿德莱德|ADL|X","珀斯|PER|X","惠灵顿|WLG|X","堪培拉|CBR|X","凯恩斯|CNS|X","克赖斯特彻|CHC|X","楠迪|NAN|Y","黄金海岸|OOL|Y","霍巴特|HBA|Y","达尔文|DRW|Y"];
var ywzm_en = new Array("gnrm","gjrm","yz","oz","mz","fz","dyz"); 
var ywzm = new Array("国内热门","国际热门","亚洲","欧洲","美洲","非洲","大洋洲"); 
var ywzm_d=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var ywzm_d_cs=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var popup_gd=25;  //数据显示高度
var popup_i; 
var popup_int0=0;
var popup_int1=0;
var popup_int2=0;
var popup_int3=0;





function Split(popup_str,popup_n,popup_s){ //字符串,取第几个数据,分割字符
	var popup_split=popup_str.split(popup_s);
	return popup_split[popup_n];
}

var objPopup;//城市展示容器层

function popUp(abc,code){
	
    if(typeof(abc)=='string')
    {
    	kongj=document.getElementById(abc);
    	kongj_code=document.getElementById(code);
    }
    else
    {
    	kongj=abc;
    	kongj_code=code;
    }
    
	var objBody = document.getElementById("mainbody");
	if( !document.getElementById("city_popup") )
	{
	    objPopup = document.createElement("div");
	}else{
		kongj.value="";
		fix_div_coordinate(kongj);
		objPopup.style.visibility="visible"; 
		document.getElementById("city").style.display=""; 
		return;
	}
	
	objPopup.style.visibility="hidden";
	
    
    kongj.value="";
    
    popup_int0=0;
    popup_int1=0;
    popup_int2=0;
    popup_int3=0;
    var tab;
    tab = '<div id="city" style="width:430px;">';
    tab+= '<div class="city-top"><font class="fff">热门城市</font></div>';
    tab+= '<div id="city-box" class="city-box f" style="background:#fff">';
    tab+= '<ul  style="padding:5px 0 5px 0;">';
    for(var ywzm_i=0;ywzm_i<7;ywzm_i++){
    	if(!ywzm[ywzm_i])break;
    	tab+= '<li style="width:55px;" id="syy_'+ywzm_en[ywzm_i]+'" class="f city-nav" onclick="f1(id,'+"'"+ywzm_d[ywzm_i]+"'"+')"><span style="cursor: pointer;" href="#">'+ywzm[ywzm_i]+'</span></li>';
    }
	 tab+= '<li class="f city-nav-right">&nbsp;</li>';
	 tab+= '<div class="c"></div>';
	 tab+= '</ul>';
	 for(var cs=0;cs<7;cs++){
		 tab+= '<div id="'+ywzm_d_cs[cs]+'" class="mt5 c" style="display: none">';
		 tab+= '<ul id="u'+cs+'">';
		 if(cs==0){
		 for(var csm=0;csm<csms[cs].length;csm++ ){
			 var tem = csms[cs][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 }
		}	 
		tab+= '</ul>';
		tab+= '</div>';
		}
	
	objPopup.innerHTML = tab;
    objPopup.onclick = Htc_OnClick;
    objPopup.onmousemove = Htc_onmousemove;
   
	objPopup.setAttribute('id','city_popup');
	objBody.appendChild(objPopup);
	document.getElementById("dgnrm").style.display="inline";
	document.getElementById("syy_gnrm").className="f city-navon";

	fix_div_coordinate(kongj);
	objPopup.style.visibility="visible"; 
	
	objPopup.style.position="absolute"; 
	
}

function fix_div_coordinate(obj)
{
		var leftpos=0;
		var toppos=0;
        aTag = obj;
		do {
			if( aTag.offsetParent )
			{
			    aTag = aTag.offsetParent;
			}
			else
			{
			    leftpos += aTag.style.left;
			    toppos += aTag.style.top;
			    break;
			}
			leftpos	+= aTag.offsetLeft;
			toppos += aTag.offsetTop;
		}while(aTag.id!="mainbody");
        //alert("leftpos=["+leftpos+"]--toppos=["+toppos+"]--obj.offsetTop=["+obj.offsetTop+"]--obj.offsetLeft=["+obj.offsetLeft+"]--obj.offsetHeight=["+obj.offsetHeight+"]");
		if(document.layers){
			document.getElementById("city_popup").style.left = obj.offsetLeft	+ parseInt(leftpos) + "px";
			document.getElementById("city_popup").style.top = obj.offsetTop +	parseInt(toppos) + obj.offsetHeight + 2 + "px";
		}else{
			document.getElementById("city_popup").style.left =obj.offsetLeft	+ parseInt(leftpos)  +"px";
			document.getElementById("city_popup").style.top = obj.offsetTop +	parseInt(toppos) + obj.offsetHeight + 2 + "px";
		}
		//alert("left=["+document.getElementById("city_popup").style.left+"] top=["+document.getElementById("city_popup").style.top+"]");
}

function popup_hide()
{
    if( objPopup.style.visibility == "visible" )objPopup.style.visibility="hidden";
}

function Htc_OnClick(){  //鼠标点击事件
  var Htc_str;
  var obj=document.parentWindow||document.defaultView;
  var e =obj.GetEvent().srcElement||obj.GetEvent().target;
  clicObj= e;
  
  if (e.tagName == "SPAN")  {
	  if(e.id!=""){
		  yc_dt(e.id);
	  }
  }
  if (e.tagName == "A")  {
	  objPopup.style.visibility="hidden"; 
	  f_z(document.getElementById(e.id).innerHTML);
	  
	 
  }
  
  if (e.tagName == "UL"){//H_
	  if(e.id!=""){
		  yc_dt(Split(e.id,1,"_"));
	  }
  }
  if (e.tagName == "DIV") {
	  if(e.innerHTML != "") yc_dt(e.innerHTML);
  }
}

//  获取event对象的一个方法，兼容IE、FF
function GetEvent(obj)
{
   if(document.all) // IE
   {
       return window.event;
   }

   func = GetEvent.caller; // 返回调用本函数的函数
   while(func != null)
   {
       // Firefox 中一个隐含的对象 arguments，第一个参数为 event 对象 
       var arg0 = func.arguments[0];
       //alert('参数长度：' + func.arguments.length);
       if(arg0)
       {
           if((arg0.constructor == Event || arg0.constructor == MouseEvent)
               ||(typeof(arg0) == "object" && arg0.preventDefault && arg0.stopPropagation))
           {
               return arg0;
           }
       }
       func = func.caller;
   }
   return null;
}

var ll="popup_td_cszm_0";
function Htc_onmousemove(){   //鼠标移动事件
  var obj=document.parentWindow||document.defaultView;
  var e =obj.GetEvent().srcElement||obj.GetEvent().target;
  if (e.tagName == "TD" && e.id.split("_")[0]!="H")  {
	  if(e.id!=""){turnrowcolor(e.id,ll);MYopoupmovOut();}
  }
  if (e.tagName == "NOBR")  {
	  if(e.id!=""){turnrowcolor("popup_td_cszm_"+Split(e.id,4,"_"),ll);MYopoupmovOut();}
  }
  if (e.tagName == "LABEL") {
	  //MYopoupmov(e.id);
  }
}

function turnrowcolor(ss,ls){   //鼠标移动TD背景颜色
  var bc="#e7f1fd";
  if(document.getElementById(ls))document.getElementById(ls).style.backgroundColor="";
  if(document.getElementById(ss))document.getElementById(ss).style.backgroundColor=bc;
  if(document.getElementById(ss))document.getElementById(ss).style.cursor="hand";
  ll=ss;	
}

var yc_dt_cs="SH";
function yc_dt(int){ 
	if(int!=yc_dt_cs){
		if(int.length=3)int = int.replace(/"/g,"");
		if(document.getElementById("syy_" + int))document.getElementById("syy_" + int).style.color="#21407D";
		if(document.getElementById("syy_" + yc_dt_cs))document.getElementById("syy_" + yc_dt_cs).style.color="#21407D";
		yc_dt_cs=int;
		if(int=="SH" || int=="热门城市"){
			Popup_tab(int,1);
		}else{
			Popup_tab(int,0);
		}
	}
}

function Popup_tab(str,lx){ //生成数据
	var Popup_dat_i=0;
	var Popup_dat_n;
	var Popup_dat_tab="";
	var Popup_dat =new Array();

		for(var cs=0;cs<7;cs++){
		 Popup_dat_tab+= '<div id="'+ywzm_d_cs[cs]+'" class="mt5 c">';
		 Popup_dat_tab+= '<ul id="u'+cs+'">';
		 for(var csm=0;csm<csms[cs].size;csm++ ){
			alert('0');	
			 Popup_dat_tab+= '<li id=Split('+csms[cs][csm]+',1,|) class="f cityon"><a href="#">Split('+csms[cs][csm]+',0,|)</a></li>';	
			 }
		Popup_dat_tab+= '<div style="clear:both">'	 
		Popup_dat_tab+= '</div>'	
		Popup_dat_tab+= '</ul>';
		Popup_dat_tab+= '</div>';
		}
	/*
	if( Split(str,0,'_')=="syy" )str=Split(str,1,'_');

	if(lx==0){
		for(Popup_dat_n=0;Popup_dat_n<qtcs.length;Popup_dat_n++){
			if(Split(qtcs[Popup_dat_n],2,"|")==str){
				Popup_dat[Popup_dat_i++]=qtcs[Popup_dat_n];
			}
		}
	}else{
		Popup_dat=shcs;
	}
	popup_int0=0;
	
	Popup_dat_tab+= '<table width="100%" border="0" cellspacing="1" cellpadding="0" style="font-size: 9pt;color: #21407D">';
	for(Popup_dat_n=0;Popup_dat_n<36;Popup_dat_n++){
		if(Popup_dat_n==0 || Popup_dat_n % 6 ==0){
			Popup_dat_tab+= '  <tr align="center" style="background-color:' +tr01_03+ ';">';
		}
		if(Popup_dat[Popup_dat_n]){
			
			Popup_dat_tab+= '    <td height="'+popup_gd+'" width="14.3%" ID="popup_td_cszm_'+popup_int0+'" title="'+Split(Popup_dat[Popup_dat_n],0,"|")+'" style="font-size: 9pt;color: #21407D"><NOBR '+style3+' ID="popup_NOBR_cszm_'+Split(Popup_dat[Popup_dat_n],1,"|")+'_'+popup_int0+'">'+Split(Popup_dat[Popup_dat_n],0,"|")+'</NOBR></td>';
			popup_int0++;
		}else{
			Popup_dat_tab+= '    <td height="'+popup_gd+'" width="14.3%">&nbsp;</td>';
		}
		popup_int3 = Popup_dat_n+1;
		if(popup_int3 % 6 ==0){
			Popup_dat_tab+= '  </tr>';
		}
	}
	Popup_dat_tab+= '    </table>';
	
	document.getElementById("city-box").innerHTML=Popup_dat_tab;
	*/
}

function f_z(temp){   //赋值给控件
  kongj.value=temp;
  setCodevalue(temp);
  kongj.style.color="#000000";
}
function setCodevalue(temp){
	var length=qtcs.length;
	
	for(i=0;i<length;i++){
		var tempArray=qtcs[i].split("|");
		if(tempArray[0]==temp){
			//kongj.codevalue=tempArray[1];
			kongj_code.value=tempArray[1];
			break;
		}
	}
}

function MYopoupmov(obj){
	var _div = document.getElementById("_div_tmp");
	obj = document.getElementById(obj);

	var leftpos=0;
	var toppos=0;
    aTag = obj;
	do {
		if( aTag.offsetParent )
		{
		    aTag = aTag.offsetParent;
		}
		else
		{
		    leftpos += aTag.style.left;
		    toppos += aTag.style.top;
		    break;
		}
		leftpos	+= aTag.offsetLeft;
		toppos += aTag.offsetTop;
	}while(aTag.id!="mainbody");
	if(document.layers){
		CitySelectnewX = obj.offsetLeft	+ parseInt(leftpos) - 7 + "px";
		CitySelectnewY = obj.offsetTop +	parseInt(toppos) + obj.offsetHeight - 16 + "px";
	}else{
		CitySelectnewX =obj.offsetLeft	+ parseInt(leftpos) - 7 +"px";
		CitySelectnewY = obj.offsetTop +	parseInt(toppos) + obj.offsetHeight - 16 + "px";
	}

	var CitySelectneww = obj.offsetWidth + 14;

	_div.style.left  = CitySelectnewX;
	_div.style.top   = CitySelectnewY;
	_div.style.width = CitySelectneww + "px";
	_div.innerHTML = obj.innerHTML;
	_div.style.display = "";
}

function MYopoupmovOut(){
	if(document.getElementById("_div_tmp").style.display=="")document.getElementById("_div_tmp").style.display = "none";
}

var posLib = {
    getClientLeft:function (el) {
      var r = el.getBoundingClientRect();
      return r.left - this.getBorderLeftWidth(this.getCanvasElement(el));
    },

    getClientTop:    function (el) {
      var r = el.getBoundingClientRect();
      return r.top - this.getBorderTopWidth(this.getCanvasElement(el));
    },

    getLeft:    function (el) {
      return this.getClientLeft(el) + this.getCanvasElement(el).scrollLeft;
    },

    getTop:    function (el) {
      return this.getClientTop(el) + this.getCanvasElement(el).scrollTop;
    },

    getInnerLeft:    function (el) {
      return this.getLeft(el) + this.getBorderLeftWidth(el);
    },

    getInnerTop:    function (el) {
      return this.getTop(el) + this.getBorderTopWidth(el);
    },

    getWidth:    function (el) {
      return el.offsetWidth;
    },

    getHeight:    function (el) {
      return el.offsetHeight;
    },

    getCanvasElement:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      if (doc.compatMode == "CSS1Compat")
        return doc.documentElement;
      else
        return doc.body;
    },

    getBorderLeftWidth:    function (el) {
      return el.clientLeft;
    },

    getBorderTopWidth:    function (el) {
      return el.clientTop;
    },

    getScreenLeft:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      var w = doc.parentWindow;
      return w.screenLeft + this.getBorderLeftWidth(this.getCanvasElement(el)) + this.getClientLeft(el);
    },

    getScreenTop:    function (el) {
      var doc = el.ownerDocument || el.document;    // IE55 bug
      var w = doc.parentWindow;
      return w.screenTop  + this.getClientTop(el);//+ this.getBorderTopWidth(this.getCanvasElement(el))
    }
  }
  
document.onclick=function(e)
{
    e = window.event || e;
    var srcElement = e.srcElement || e.target;
    /**********时间选择窗口操作**********/
    /**********时间选择窗口操作**********/
    if( document.getElementById("city_popup") )
    {
        if((objPopup.style.display=="" || objPopup.style.visibility=="visible") && srcElement!=kongj && srcElement!=objPopup && srcElement!=clicObj){
            if( objPopup.style )objPopup.style.visibility="hidden";
        }
    }
}

var ywzm_en = new Array("gnrm","gjrm","yz","oz","mz","fz","dyz"); 
var ywzm = new Array("国内热门","国际热门","亚洲","欧洲","美洲","非洲","大洋洲"); 
var ywzm_d=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var ywzm_d_cs=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
function f1(id,did){
	document.getElementById("dgnrm").style.display="none";
	document.getElementById("dgjrm").style.display="none";
	document.getElementById("dyz").style.display="none";
	document.getElementById("doz").style.display="none";
	document.getElementById("dmz").style.display="none";
	document.getElementById("dfz").style.display="none";
	document.getElementById("ddyz").style.display="none";
	document.getElementById(did).style.display="inline";
	var tab1="";
	var index;
	//var ywzm_d=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
	if(did=='dgjrm'){
		 for(var csm=0;csm<csms[1].length;csm++ ){
			 var tem = csms[1][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u1').innerHTML=tab1;	 
	}
	if(did=='dyz'){
		 for(var csm=0;csm<csms[2].length;csm++ ){
			 var tem = csms[2][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u2').innerHTML=tab1;	 
	}
	if(did=='doz'){
		 for(var csm=0;csm<csms[3].length;csm++ ){
			 var tem = csms[3][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u3').innerHTML=tab1;	 
	}
	if(did=='dmz'){
		 for(var csm=0;csm<csms[4].length;csm++ ){
			 var tem = csms[4][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u4').innerHTML=tab1;	 
	}
	if(did=='dfz'){
		 for(var csm=0;csm<csms[5].length;csm++ ){
			 var tem = csms[5][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u5').innerHTML=tab1;	 
	}
	if(did=='ddyz'){
		 for(var csm=0;csm<csms[6].length;csm++ ){
			 var tem = csms[6][csm];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 }
		document.getElementById('u6').innerHTML=tab1;	 
	}	
	document.getElementById('syy_gnrm').className='f city-nav';
	document.getElementById('syy_gjrm').className='f city-nav';
	document.getElementById('syy_yz').className='f city-nav';
	document.getElementById('syy_oz').className='f city-nav';
	document.getElementById('syy_mz').className='f city-nav';
	document.getElementById('syy_fz').className='f city-nav';
	document.getElementById('syy_dyz').className='f city-nav';
	document.getElementById(id).className='f city-navon';
}