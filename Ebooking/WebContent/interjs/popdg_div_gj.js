var gjtr01_01 = "#ff0000"; //第一行背景颜色
var gjtr01_02 = "#cccccc"; //第二行背景颜色
var gjtr01_03 = "#FFFFFF";
//var gjtab01 = "#656565";  //边框颜色
var gjtab01 = "#2F7495";  //边框颜色
var kongjgj;
var kongj_codegj;
var clicObjgj;

//tile
var gjstyle1 = 'style="color: #656565;BACKGROUND-COLOR:#e7f1fd;font-size: 9pt;"';

//title:城市拼音首字母
var gjstyle2 = 'style="BACKGROUND-COLOR: #c8e3fc; color: #656565;background-repeat:repeat-x; background-position:bottom; font-size: 9pt;"';

var gjstyle3 = 'style="position: relative; left: 0px; top: 0px; width: 100%;overflow:hidden; text-overflow:ellipsis;"';


//北京|PEK|B  城市|三字代码|拼音首字母
var gjshcsgj = new Array("上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C");
var gjqtcsgj = new Array("上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C","北京|BJS|B","纽约|NYC|N","泗水|SUB|S","三宝垄|SRG|S","万隆|BDO|B","棉兰|MES|M","巴东|PDG|P","玛琅|MLG|M","帝力|DIL|D","河内|HAN|H","万象|VTE|V","金边|PNH|P","曼谷|BKK|B","普吉|HKT|H","仰光|RGN|R","廷布|QJC|Q","加德满都|KTM|K","达卡|DAC|D","科伦坡|CMB|C","马累|MLE|M","香港|HKG|H","东京|NRT|A","台北|TPE|A","首尔|ICN|A","新加坡|SIN|A","曼谷|BKK|B","吉隆坡|KUL|B","大阪|ITM|B","澳门|MFM|B","雅加达|CGK|C","胡志明市|SGN|C","马尼拉|MNL|C","巴厘岛|BPN|C","名古屋|NGO|C","普吉岛|HKT|C","河内|HAN|C","马累|MLE|C","迪拜|DXB|C","釜山|PUS|C","加德满都|KTM|D","高雄|KHH|D","福冈|FUK|D","金边|PNH|D","新德里|DEL|D","济州岛|CJU|D","札幌|CTS|D","伊斯坦布尔|IST|D","乌兰巴托|ULN|E","孟买|BOM|E","伦敦|LCY|G","巴黎|ORY|G","法兰克福|FRA|G","莫斯科|DME|G","罗马|GHN|G","阿姆斯特丹|AMS|G","米兰|KWE|G","慕尼黑|MUC|H","斯德哥尔摩|ARN|H","柏林|TXL|H","曼彻斯特|MHT|H","马德里|MAD|H","苏黎世|ZRH|H","布鲁塞尔|BRU|H","哥本哈根|CPH|H","赫尔辛基|HEL|H","维也纳|VIE|H","巴塞罗那|BCN|H","雅典|ATH|H","爱丁堡|EDI|H","伯明翰(英|BHX|H","纽卡斯尔|NCL|H","日内瓦|GVA|H","圣彼得堡|LED|J","格拉斯哥|GLA|J","基辅|KBP|J","布达佩斯|BUD|J","汉堡|HAM|J","布拉格|PRG|J","杜塞尔多夫|DUS|J","纽约|NYC|K","洛杉矶|LAX|K","旧金山|SFO|K","温哥华|YVR|K","芝加哥|CHI|K","多伦多|YYZ|K","西雅图|SEA|L","华盛顿|IAD|L","底特律|DTW|L","亚特兰大|ATL|L","休斯顿|IAH|L","悉尼|SYD|L","蒙特利尔|YUL|L","塞班|SPN|M","达拉斯|DFW|M","明尼阿波利|MSP|M","圣保罗|GRU|N","渥太华|YOW|N","墨西哥城|MEX|N","拉斯维加斯|LAS|N","迈阿密|MIA|N","丹佛|DEN|N","奥兰多|MCO|N","波特兰|PWM|N","圣保罗|GRU|N","曼彻斯特|MHT|N","布宜诺斯艾|BUE|N","开罗|CAI|P","约翰内斯堡|JNB|Q","开普敦|CPT|Q","内罗毕|NBO|Q","拉各斯|LOS|Q","罗安达|LAD|Q","毛里求斯|MRU|Q","亚的斯亚贝|ADD|S","突尼斯|TUN|S","卢萨卡|LUN|S","哈拉雷|HRE|S","雅温得|YAO|S","哈博罗内|GBE|S","金沙萨|FIH|S","马普托|MPM|S","杜阿拉|DLA|S","悉尼|SYD|X","墨尔本|MEL|X","奥克兰|AKL|X","布里斯班|BNE|X","阿德莱德|ADL|X","珀斯|PER|X","惠灵顿|WLG|X","堪培拉|CBR|X","凯恩斯|CNS|X","克赖斯特彻|CHC|X","楠迪|NAN|Y","黄金海岸|OOL|Y","达尔文|DRW|Y","霍巴特|HBA|Y");
//城市名
var csmsgj = new Array;
csmsgj[0]=["上海|SHA|S","香港|HKG|H","北京|BJS|B","广州|CAN|G","厦门|XMN|X","杭州|HGH|H","青岛|TAO|Q","南京|NKG|N","深圳|SZX|S","福州|FOC|F","大连|DLC|D","成都|CTU|C","澳门|MFM|B","三亚|SYX|S","汕头|SWA|S","晋江|JJN|J","宁波|NGB|N","天津|TSN|T","昆明|KMG|K","长沙|CSX|C"];
csmsgj[1]=["北京|BJS|B","纽约|NYC|N","泗水|SUB|S","三宝垄|SRG|S","万隆|BDO|B","棉兰|MES|M","巴东|PDG|P","玛琅|MLG|M","帝力|DIL|D","河内|HAN|H","万象|VTE|V","金边|PNH|P","曼谷|BKK|B","普吉|HKT|H","仰光|RGN|R","廷布|QJC|Q","加德满都|KTM|K","达卡|DAC|D","科伦坡|CMB|C","马累|MLE|M"];
csmsgj[2]=["香港|HKG|H","东京|NRT|A","台北|TPE|A","首尔|ICN|A","新加坡|SIN|A","曼谷|BKK|B","吉隆坡|KUL|B","大阪|ITM|B","澳门|MFM|B","雅加达|CGK|C","胡志明市|SGN|C","马尼拉|MNL|C","巴厘岛|BPN|C","名古屋|NGO|C","普吉岛|HKT|C","河内|HAN|C","马累|MLE|C","迪拜|DXB|C","釜山|PUS|C","加德满都|KTM|D","高雄|KHH|D","福冈|FUK|D","金边|PNH|D","新德里|DEL|D","济州岛|CJU|D","札幌|CTS|D","伊斯坦布尔|IST|D","乌兰巴托|ULN|E","孟买|BOM|E"];
csmsgj[3]=["伦敦|LCY|G","巴黎|ORY|G","法兰克福|FRA|G","莫斯科|DME|G","罗马|GHN|G","阿姆斯特丹|AMS|G","米兰|KWE|G","慕尼黑|MUC|H","斯德哥尔摩|ARN|H","柏林|TXL|H","曼彻斯特|MHT|H","马德里|MAD|H","苏黎世|ZRH|H","布鲁塞尔|BRU|H","哥本哈根|CPH|H","赫尔辛基|HEL|H","维也纳|VIE|H","巴塞罗那|BCN|H","雅典|ATH|H","爱丁堡|EDI|H","伯明翰(英|BHX|H","纽卡斯尔|NCL|H","日内瓦|GVA|H","圣彼得堡|LED|J","格拉斯哥|GLA|J","基辅|KBP|J","布达佩斯|BUD|J","汉堡|HAM|J","布拉格|PRG|J","杜塞尔多夫|DUS|J"];
csmsgj[4]=["纽约|JKF|K","洛杉矶|LAX|K","旧金山|SFO|K","温哥华|YVR|K","芝加哥|CHI|K","多伦多|YYZ|K","西雅图|SEA|L","华盛顿|IAD|L","底特律|DTW|L","亚特兰大|ATL|L","休斯顿|IAH|L","悉尼|SYD|L","蒙特利尔|YUL|L","塞班|SPN|M","达拉斯|DFW|M","明尼阿波利|MSP|M","圣保罗|GRU|N","渥太华|YOW|N","墨西哥城|MEX|N","拉斯维加斯|LAS|N","迈阿密|MIA|N","丹佛|DEN|N","奥兰多|MCO|N","波特兰|PWM|N","圣保罗|GRU|N","曼彻斯特|MHT|N","布宜诺斯艾|BUE|N"];
csmsgj[5]=["开罗|CAI|P","约翰内斯堡|JNB|Q","开普敦|CPT|Q","内罗毕|NBO|Q","拉各斯|LOS|Q","罗安达|LAD|Q","毛里求斯|MRU|Q","亚的斯亚贝|ADD|S","突尼斯|TUN|S","卢萨卡|LUN|S","哈拉雷|HRE|S","雅温得|YAO|S","哈博罗内|GBE|S","金沙萨|FIH|S","马普托|MPM|S","杜阿拉|DLA|S"];
csmsgj[6]=["悉尼|SYD|X","墨尔本|MEL|X","奥克兰|AKL|X","布里斯班|BNE|X","阿德莱德|ADL|X","珀斯|PER|X","惠灵顿|WLG|X","堪培拉|CBR|X","凯恩斯|CNS|X","克赖斯特彻|CHC|X","楠迪|NAN|Y","黄金海岸|OOL|Y","霍巴特|HBA|Y","达尔文|DRW|Y"];
var ywzmgj_en = new Array("gnrm","gjrm","yz","oz","mz","fz","dyz"); 
var wudazhou = new Array("国内热门","国际热门","亚洲","欧洲","美洲","非洲","大洋洲"); 
var ywzmgj_d=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var ywzmgj_d_cs=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var gjpopup_gd=25;  //数据显示高度
var gjpopup_i; 
var gjpopup_int0=0;
var gjpopup_int1=0;
var gjpopup_int2=0;
var gjpopup_int3=0;





function Splitgj(popup_str,popup_n,popup_s){ //字符串,取第几个数据,分割字符
	var gjpopup_split=popup_str.split(popup_s);
	return gjpopup_split[popup_n];
}

var gjobjPopup;//城市展示容器层

function popUpgj(abc,code){

    if(typeof(abc)=='string')
    {
    	kongjgj=document.getElementById(abc);
    	kongj_codegj=document.getElementById(code);
    }
    else
    {
    	kongjgj=abc;
    	kongj_codegj=code;
    }
    
	var gjobjBody = document.getElementById("mainbody");
	if( !document.getElementById("city_popupgj") )
	{
	    gjobjPopup = document.createElement("div");
	}
	
	gjobjPopup.style.visibility="hidden";
	
    
    kongjgj.value="";
    
    gjpopup_int0=0;
    gjpopup_int1=0;
    gjpopup_int2=0;
    gjpopup_int3=0;
    var gjtab;
    gjtab = '<div id="city" style="width:430px;z-index: 999">';
    gjtab+= '<div class="city-top"><font class="fff">热门城市（可输入城市或城市拼音）</font></div>';
    gjtab+= '<div id="city-box" class="city-box f" style="background:#fff">';
    gjtab+= '<ul  style="padding:5px 0 5px 0;">';
    for(var ywzmgj_i=0;ywzmgj_i<7;ywzmgj_i++){
    	if(!wudazhou[ywzmgj_i])break;
    	gjtab+= '<li style="width:55px;" id="syy_'+ywzmgj_en[ywzmgj_i]+'" class="f city-nav" onclick="f2(id,'+"'"+ywzmgj_d[ywzmgj_i]+"'"+')"><span style="cursor: pointer;" href="#">'+wudazhou[ywzmgj_i]+'</span></li>';
    }
	 gjtab+= '<li class="f city-nav-right">&nbsp;</li>';
	 gjtab+= '<div class="c"></div>';
	 gjtab+= '</ul>';
	 for(var gjcs=0;gjcs<7;gjcs++){
		 gjtab+= '<div id="'+ywzmgj_d_cs[gjcs]+'" class="mt5 c" style="display: none">';
		 gjtab+= '<ul id="u'+gjcs+'">';
		 if(gjcs==0){
		 for(var gjcsm=0;gjcsm<csmsgj[gjcs].length;gjcsm++ ){
			 var gjtem = csmsgj[gjcs][gjcsm];
			 var gjid1=Splitgj(gjtem,1,"|");
			 var gjvalue1=Splitgj(gjtem,0,"|");
			 gjtab+= '<li  class="f cityon"><a style="width:70px;" id='+gjid1+' href="javascript:void(0);">'+gjvalue1+'</a></li>';	
			 }
		}	 
		gjtab+= '</ul>';
		gjtab+= '</div>';
		}
	
	gjobjPopup.innerHTML = gjtab;
    gjobjPopup.onclick = Htc_OnClickgj;
    gjobjPopup.onmousemove = Htc_onmousemovegj;
   
	gjobjPopup.setAttribute('id','city_popupgj');
	gjobjBody.appendChild(gjobjPopup);
	document.getElementById("dgnrm").style.display="inline";
	document.getElementById("syy_gnrm").className="f city-navon";

	fix_div_coordinategj(kongjgj);
	gjobjPopup.style.visibility="visible"; 
	
	gjobjPopup.style.position="absolute"; 
	
}

function fix_div_coordinategj(obj)
{
		var gjleftpos=0;
		var gjtoppos=0;
        aTaggj = obj;
		do {
			if( aTaggj.offsetParent )
			{
			    aTaggj = aTaggj.offsetParent;
			}
			else
			{
			    gjleftpos += aTaggj.style.left;
			    gjtoppos += aTaggj.style.top;
			    break;
			}
			gjleftpos	+= aTaggj.offsetLeft;
			gjtoppos += aTaggj.offsetTop;
		}while(aTaggj.id!="mainbody");
        //alert("gjleftpos=["+gjleftpos+"]--gjtoppos=["+gjtoppos+"]--obj.offsetTop=["+obj.offsetTop+"]--obj.offsetLeft=["+obj.offsetLeft+"]--obj.offsetHeight=["+obj.offsetHeight+"]");
		if(document.layers){
			document.getElementById("city_popupgj").style.left = obj.offsetLeft	+ parseInt(gjleftpos) + "px";
			document.getElementById("city_popupgj").style.top = obj.offsetTop +	parseInt(gjtoppos) + obj.offsetHeight + 2 + "px";
		}else{
			document.getElementById("city_popupgj").style.left =obj.offsetLeft	+ parseInt(gjleftpos)  +"px";
			document.getElementById("city_popupgj").style.top = obj.offsetTop +	parseInt(gjtoppos) + obj.offsetHeight + 2 + "px";
		}
		//alert("left=["+document.getElementById("city_popupgj").style.left+"] top=["+document.getElementById("city_popupgj").style.top+"]");
}

function popup_hidegj()
{
    if( gjobjPopup.style.visibility == "visible" )gjobjPopup.style.visibility="hidden";
}

function Htc_OnClickgj(){  //鼠标点击事件
  var gjHtc_str;
  var gjobj=document.parentWindow||document.defaultView;
  var gje =gjobj.GetEventgj().srcElement||gjobj.GetEventgj().target;
  clicObjgj= gje;
  
  if (gje.tagName == "SPAN")  {
	  if(gje.id!=""){
		  yc_dt(gje.id);
	  }
  }
  if (gje.tagName == "A")  {
	  gjobjPopup.style.visibility="hidden"; 
	  f_zgj(document.getElementById(gje.id).innerHTML);
  }
  if (gje.tagName == "UL"){//H_
	  if(gje.id!=""){
		  yc_dt(Splitgj(gje.id,1,"_"));
	  }
  }
  if (gje.tagName == "DIV") {
	  if(gje.innerHTML != "") yc_dt(gje.innerHTML);
  }
}

//  获取event对象的一个方法，兼容IE、FF
function GetEventgj(obj)
{
   if(document.all) // IE
   {
       return window.event;
   }

   funcgj = GetEventgj.caller; // 返回调用本函数的函数
   while(funcgj != null)
   {
       // Firefox 中一个隐含的对象 arguments，第一个参数为 event 对象 
       var gjarg0 = funcgj.arguments[0];
       //alert('参数长度：' + funcgj.arguments.length);
       if(gjarg0)
       {
           if((gjarg0.constructor == Event || gjarg0.constructor == MouseEvent)
               ||(typeof(gjarg0) == "object" && gjarg0.preventDefault && gjarg0.stopPropagation))
           {
               return gjarg0;
           }
       }
       funcgj = funcgj.caller;
   }
   return null;
}

var gjll="gjpopup_td_cszm_0";
function Htc_onmousemovegj(){   //鼠标移动事件
  var gjobj=document.parentWindow||document.defaultView;
  var gje =gjobj.GetEventgj().srcElement||gjobj.GetEventgj().target;
  if (gje.tagName == "TD" && gje.id.split("_")[0]!="H")  {
	  if(gje.id!=""){turnrowcolor(gje.id,gjll);MYopoupmovOutgj();}
  }
  if (gje.tagName == "NOBR")  {
	  if(e.id!=""){turnrowcolor("gjpopup_td_cszm_"+Splitgj(e.id,4,"_"),gjll);MYopoupmovOutgj();}
  }
  if (gje.tagName == "LABEL") {
	  //MYopoupmov(e.id);
  }
}

function turnrowcolorgj(ss,ls){   //鼠标移动TD背景颜色
  var gjbc="#e7f1fd";
  if(document.getElementById(ls))document.getElementById(ls).style.backgroundColor="";
  if(document.getElementById(ss))document.getElementById(ss).style.backgroundColor=gjbc;
  if(document.getElementById(ss))document.getElementById(ss).style.cursor="hand";
  gjll=ss;	
}

var gjyc_dt_cs="SH";
function yc_dtgj(int){ 
	if(int!=gjyc_dt_cs){
		if(int.length=3)int = int.replace(/"/g,"");
		if(document.getElementById("syy_" + int))document.getElementById("syy_" + int).style.color="#21407D";
		if(document.getElementById("syy_" + gjyc_dt_cs))document.getElementById("syy_" + gjyc_dt_cs).style.color="#21407D";
		gjyc_dt_cs=int;
		if(int=="SH" || int=="热门城市"){
			Popup_tabgj(int,1);
		}else{
			Popup_tabgj(int,0);
		}
	}
}

function Popup_tabgj(str,lx){ //生成数据


	var gjPopup_dat_i=0;
	var gjPopup_dat_n;
	var gjPopup_dat_tab="";
	var gjPopup_dat =new Array();

		for(var gjcs=0;gjcs<6;gjcs++){
		 gjPopup_dat_tab+= '<div id="'+ywzmgj_d_cs[gjcs]+'" class="mt5 c">';
		 gjPopup_dat_tab+= '<ul id="u'+gjcs+'">';
		 for(var gjcsm=0;gjcsm<csmsgj[gjcs].size;gjcsm++ ){
			alert('0');	
			 gjPopup_dat_tab+= '<li id=Splitgj('+csmsgj[gjcs][gjcsm]+',1,|) class="f cityon"><a href="#">Splitgj('+csmsgj[gjcs][gjcsm]+',0,|)</a></li>';	
			 }
		gjPopup_dat_tab+= '<div style="clear:both">'	 
		gjPopup_dat_tab+= '</div>'	
		gjPopup_dat_tab+= '</ul>';
		gjPopup_dat_tab+= '</div>';
		}
	/*
	if( Splitgj(str,0,'_')=="syy" )str=Splitgj(str,1,'_');

	if(lx==0){
		for(Popup_dat_n=0;Popup_dat_n<qtcsgj.length;Popup_dat_n++){
			if(Splitgj(qtcsgj[Popup_dat_n],2,"|")==str){
				Popup_dat[Popup_dat_i++]=qtcsgj[Popup_dat_n];
			}
		}
	}else{
		Popup_dat=shcsgj;
	}
	popup_int0=0;
	
	Popup_dat_tab+= '<table width="100%" border="0" cellspacing="1" cellpadding="0" style="font-size: 9pt;color: #21407D">';
	for(Popup_dat_n=0;Popup_dat_n<36;Popup_dat_n++){
		if(Popup_dat_n==0 || Popup_dat_n % 6 ==0){
			Popup_dat_tab+= '  <tr align="center" style="background-color:' +tr01_03+ ';">';
		}
		if(Popup_dat[Popup_dat_n]){
			
			Popup_dat_tab+= '    <td height="'+popup_gd+'" width="14.3%" ID="popup_td_cszm_'+popup_int0+'" title="'+Splitgj(Popup_dat[Popup_dat_n],0,"|")+'" style="font-size: 9pt;color: #21407D"><NOBR '+style3+' ID="popup_NOBR_cszm_'+Splitgj(Popup_dat[Popup_dat_n],1,"|")+'_'+popup_int0+'">'+Splitgj(Popup_dat[Popup_dat_n],0,"|")+'</NOBR></td>';
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

function f_zgj(temp){   //赋值给控件
  kongjgj.value=temp;
  setCodevaluegj(temp);
  kongjgj.style.color="#000000";
}
function setCodevaluegj(temp){
	var gjlength=gjqtcsgj.length;
	
	for(i=0;i<gjlength;i++){
		var gjtempArray=gjqtcsgj[i].split("|");
		if(gjtempArray[0]==temp){
			//kongjgj.codevalue=tempArray[1];
			kongj_codegj.value=gjtempArray[1];
			break;
		}
	}
}

function MYopoupmovgj(obj){
	var gj_div = document.getElementById("_div_tmp");
	obj = document.getElementById(obj);

	var gjleftpos=0;
	var gjtoppos=0;
    aTaggj = obj;
	do {
		if( aTaggj.offsetParent )
		{
		    aTaggj = aTaggj.offsetParent;
		}
		else
		{
		    gjleftpos += aTaggj.style.left;
		    gjtoppos += aTaggj.style.top;
		    break;
		}
		gjleftpos	+= aTaggj.offsetLeft;
		gjtoppos += aTaggj.offsetTop;
	}while(aTaggj.id!="mainbody");
	if(document.layers){
		CitySelectnewX = obj.offsetLeft	+ parseInt(gjleftpos) - 7 + "px";
		CitySelectnewY = obj.offsetTop +	parseInt(gjtoppos) + obj.offsetHeight - 16 + "px";
	}else{
		CitySelectnewX =obj.offsetLeft	+ parseInt(gjleftpos) - 7 +"px";
		CitySelectnewY = obj.offsetTop +	parseInt(gjtoppos) + obj.offsetHeight - 16 + "px";
	}

	var gjCitySelectneww = obj.offsetWidth + 14;

	gj_div.style.left  = CitySelectnewX;
	gj_div.style.top   = CitySelectnewY;
	gj_div.style.width = gjCitySelectneww + "px";
	gj_div.innerHTML = obj.innerHTML;
	gj_div.style.display = "";
}

function MYopoupmovOutgj(){
	if(document.getElementById("_div_tmp").style.display=="")document.getElementById("_div_tmp").style.display = "none";
}

var gjposLib = {
    getClientLeft:function (el) {
      var gjr = el.getBoundingClientRect();
      return gjr.left - this.getBorderLeftWidth(this.getCanvasElement(el));
    },

    getClientTop:    function (el) {
      var gjr = el.getBoundingClientRect();
      return gjr.top - this.getBorderTopWidth(this.getCanvasElement(el));
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
      var gjdoc = el.ownerDocument || el.document;    // IE55 bug
      if (gjdoc.compatMode == "CSS1Compat")
        return gjdoc.documentElement;
      else
        return gjdoc.body;
    },

    getBorderLeftWidth:    function (el) {
      return el.clientLeft;
    },

    getBorderTopWidth:    function (el) {
      return el.clientTop;
    },

    getScreenLeft:    function (el) {
      var gjdoc = el.ownerDocument || el.document;    // IE55 bug
      var gjw = gjdoc.parentWindow;
      return w.screenLeft + this.getBorderLeftWidth(this.getCanvasElement(el)) + this.getClientLeft(el);
    },

    getScreenTop:    function (el) {
      var gjdoc = el.ownerDocument || el.document;    // IE55 bug
      var gjw = gjdoc.parentWindow;
      return w.screenTop  + this.getClientTop(el);//+ this.getBorderTopWidth(this.getCanvasElement(el))
    }
  }
  
document.onclick=function(e1)
{	
    e1 = window.event || e1;
    var gjsrcElement = e1.srcElement || e1.target;
    /**********时间选择窗口操作**********/
    /**********时间选择窗口操作**********/
    if( document.getElementById("city_popupgj") )
    {
        if((gjobjPopup.style.display=="" || gjobjPopup.style.visibility=="visible") && gjsrcElement!=kongjgj && gjsrcElement!=gjobjPopup && gjsrcElement!=clicObjgj){
            if( gjobjPopup.style )gjobjPopup.style.visibility="hidden";
        }
    }
    if(document.getElementById("city_popup") )
    {
    	var srcElement = e1.srcElement || e1.target;
        if((document.getElementById("city_popup").style.display=="" || document.getElementById("city_popup").style.visibility=="visible") && srcElement!=kongj && srcElement!=objPopup && srcElement!=clicObj){
            if( document.getElementById("city_popup").style )document.getElementById("city_popup").style.visibility="hidden";
        }
    }
}

var ywzmgj_en = new Array("gnrm","gjrm","yz","oz","mz","fz","dyz"); 
var wudazhou = new Array("国内热门","国际热门","亚洲","欧洲","美洲","非洲","大洋洲"); 
var ywzmgj_d=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
var ywzmgj_d_cs=new Array("dgnrm","dgjrm","dyz","doz","dmz","dfz","ddyz");
function f2(id,did){
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
		 for(var csmgj=0;csmgj<csmsgj[1].length;csmgj++ ){
			 var tem = csmsgj[1][csmgj];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u1').innerHTML=tab1;	 
	}
	if(did=='dyz'){
		 for(var csmgj=0;csmgj<csmsgj[2].length;csmgj++ ){
			 var tem = csmsgj[2][csmgj];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u2').innerHTML=tab1;	 
	}
	if(did=='doz'){
		 for(var csmgj=0;csmgj<csmsgj[3].length;csmgj++ ){
			 var tem = csmsgj[3][csmgj];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u3').innerHTML=tab1;	 
	}
	if(did=='dmz'){
		 for(var csmgj=0;csmgj<csmsgj[4].length;csmgj++ ){
			 var tem = csmsgj[4][csmgj];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u4').innerHTML=tab1;	 
	}
	if(did=='dfz'){
		 for(var csmgj=0;csmgj<csmsgj[5].length;csmgj++ ){
			 var tem = csmsgj[5][csmgj];
			 var id1=Split(tem,1,"|");
			 var value1=Split(tem,0,"|");
			 tab1+= '<li  class="f cityon"><a style="width:70px;"  id='+id1+' href="javascript:void(0);">'+value1+'</a></li>';	
			 
			 }
		document.getElementById('u5').innerHTML=tab1;	 
	}
	if(did=='ddyz'){
		 for(var csmgj=0;csmgj<csmsgj[6].length;csmgj++ ){
			 var tem = csmsgj[6][csmgj];
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
