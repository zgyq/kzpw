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
var shcs = new Array("北京|PEK|B","上海|SHA|S","广州|CAN|G","深圳|SZX|S","成都|CTU|C","杭州|HGH|H","武汉|WUH|W","西安|XIY|X","重庆|CKG|C","青岛|TAO|Q","长沙|CSX|C","南京|NKG|N","厦门|XMN|X","昆明|KMG|K","大连|DLC|D","天津|TSN|T","郑州|CGO|Z","三亚|SYX|S","济南|TNA|J","福州|FOC|F","池州|JUH|F");
var qtcs = new Array("阿勒泰|AAT|A","百色|AEB|B","安康|AKA|A","阿克苏|AKU|A","鞍山|AOG|A","安庆|AQG|A","安顺|AVA|A","包头|BAV|B","北海|BHY|B","博乐|BPL|B","昌都|BPX|C","保山|BSD|B","常德|CGD|C","长春|CGQ|C","朝阳|CHG|C","赤峰|CIF|C","长治|CIH|C","重庆|CKG|C","长沙|CSX|C","成都|CTU|C","常州|CZX|C","大同|DAT|D","达县|DAX|D","丹东|DDG|D","迪庆|DIG|D","大连|DLC|D","大理|DLU|D","敦煌|DNH|D","东营|DOY|D","大庆|DQA|D","鄂尔多斯|DSN|E","恩施|ENH|E","二连浩特|ERL|E","福州|FOC|F","阜阳|FUG|F","佛山|FUO|F","德宏|LUM|D","北京|PEK|B","长白山|NBS|C","阿里|NGQ|A","巴彦淖尔|RLK|B","阿尔山|YIE|A","北京(南苑)|NAY|B","广州|CAN|G","广汉|GHN|G","格尔木|GOQ|G","广元|GYS|G","固原|GYU|G","海口|HAK|H","邯郸|HDG|H","黑河|HEK|H","呼和浩特|HET|H","合肥|HFE|H","杭州|HGH|H","淮安|HIA|H","怀化|HJJ|H","海拉尔|HLD|H","哈密|HMI|H","哈尔滨|HRB|H","和田|HTN|H","汉中|HZG|H","景德镇|JDZ|J","嘉峪关|JGN|J","井冈山|JGS|J","金昌|JIC|J","吉林|JIL|J","九江|JIU|J","晋江|JJN|J","佳木斯|JMU|J","济宁|JNG|J","锦州|JNZ|J","鸡西|JXA|J","九寨沟|JZH|J","赣州|KOW|G","贵阳|KWE|G","桂林|KWL|G","光化|LHK|G","揭阳|SWA|J","济南|TNA|J","黄山|TXN|H","黄岩|HYN|H","惠阳|AHE|H","吉安|KNC|J","荆州|SHS|J","黎平|HZH|L","库车|KCA|K","康定|KGT|K","喀什|KHG|K","南昌|KHN|N","昆明|KMG|K","库尔勒|KRL|K","克拉玛依|KRY|K","龙岩|LCX|L","兰州|LHW|L","梁平|LIA|L","丽江|LJG|L","临沧|LNJ|L","拉萨|LXA|L","林西|LXI|L","洛阳|LYA|L","连云港|LYG|L","临沂|LYI|L","柳州|LZH|L","泸州|LZO|L","林芝|LZY|L","牡丹江|MDG|M","绵阳|MIG|M","梅县|MXZ|M","南充|NAO|N","宁波|NGB|N","南京|NKG|N","那拉提|NLT|N","南宁|NNG|N","南阳|NNY|N","南通|NTG|N","满州里|NZH|M","漠河|OHE|M","昆明|KMG|K","喀纳斯|KJI|K","乌兰浩特|HLH|S","台州|HYN|T","且末|IQM|Q","庆阳|IQN|Q","黔江|JIQ|S","衢州|JUZ|Q","齐齐哈尔|NDG|Q","上海|SHA|S","攀枝花|PZI|P","日喀则|RKZ|R","沈阳|SHE|S","秦皇岛|SHP|Q","沙市|SHS|S","石家庄|SJW|S","普洱(思茅)|SYM|S","三亚|SYX|S","深圳|SZX|S","青岛|TAO|Q","塔城|TCG|T","铜仁|TEN|T","通辽|TGO|T","天水|THQ|T","天津|TSN|T","唐山|TVS|T","太原|TYN|T","乌鲁木齐|URC|W","潍坊|WEF|W","威海|WEH|W","文山|WNH|W","温州|WNZ|W","乌海|WUA|W","武汉|WUH|W","武夷山|WUS|W","无锡|WUX|W","梧州|WUZ|W","万州|WXN|W","上海(虹桥)|SHA|S","上海(浦东)|PVG|S","泉州晋江|JJN|Q","汕头|SWA|S","鄯善|SXJ|S","韶关|SHG|S","兴义|ACX|X","郑州|CGO|Z","张家界|DYG|Z","延安|ENY|Y","舟山|HSN|Z","银川|INC|Y","西双版纳|JHG|X","伊春|LDS|Y","永州|LLF|Y","榆林|UYN|Y","襄樊|XFN|X","西昌|XIC|X","锡林浩特|XIL|X","西安|XIY|X","厦门|XMN|X","西宁|XNN|X","徐州|XUZ|X","宜宾|YBP|Y","运城|YCU|Y","宜昌|YIH|Y","伊宁|YIN|Y","义乌|YIW|Y","延吉|YNJ|Y","烟台|YNT|Y","盐城|YNZ|Y","张掖|YZY|Z","昭通|ZAT|Z","中山|ZSW|Z","中卫|ZHY|Z","湛江|ZHA|Z","珠海|ZUH|Z","遵义|ZYI|Z","香格里拉|DIG|X");
//城市名
var csms = new Array;
csms[0]=["北京|PEK|B","上海|SHA|S","广州|CAN|G","深圳|SZX|S","成都|CTU|C","杭州|HGH|H","武汉|WUH|W","西安|XIY|X","重庆|CKG|C","青岛|TAO|Q","长沙|CSX|C","南京|NKG|N","厦门|XMN|X","昆明|KMG|K","大连|DLC|D","天津|TSN|T","郑州|CGO|Z","三亚|SYX|S","济南|TNA|J","福州|FOC|F","池州|JUH|F"];
csms[1]=["阿勒泰|AAT|A","百色|AEB|B","安康|AKA|A","阿克苏|AKU|A","鞍山|AOG|A","安庆|AQG|A","安顺|AVA|A","包头|BAV|B","北海|BHY|B","博乐|BPL|B","昌都|BPX|C","保山|BSD|B","常德|CGD|C","长春|CGQ|C","朝阳|CHG|C","赤峰|CIF|C","长治|CIH|C","重庆|CKG|C","长沙|CSX|C","成都|CTU|C","常州|CZX|C","大同|DAT|D","达县|DAX|D","丹东|DDG|D","迪庆|DIG|D","大连|DLC|D","大理|DLU|D","敦煌|DNH|D","东营|DOY|D","大庆|DQA|D","鄂尔多斯|DSN|E","恩施|ENH|E","二连浩特|ERL|E","福州|FOC|F","阜阳|FUG|F","佛山|FUO|F","德宏|LUM|D","北京|PEK|B","长白山|NBS|C","阿里|NGQ|A","巴彦淖尔|RLK|B","阿尔山|YIE|A","北京(南苑)|NAY|B"];
csms[2]=["广州|CAN|G","广汉|GHN|G","格尔木|GOQ|G","广元|GYS|G","固原|GYU|G","海口|HAK|H","邯郸|HDG|H","黑河|HEK|H","呼和浩特|HET|H","合肥|HFE|H","杭州|HGH|H","淮安|HIA|H","怀化|HJJ|H","海拉尔|HLD|H","哈密|HMI|H","哈尔滨|HRB|H","和田|HTN|H","汉中|HZG|H","景德镇|JDZ|J","嘉峪关|JGN|J","井冈山|JGS|J","金昌|JIC|J","吉林|JIL|J","九江|JIU|J","晋江|JJN|J","佳木斯|JMU|J","济宁|JNG|J","锦州|JNZ|J","鸡西|JXA|J","九寨沟|JZH|J","赣州|KOW|G","贵阳|KWE|G","桂林|KWL|G","光化|LHK|G","揭阳|SWA|J","济南|TNA|J","黄山|TXN|H","黄岩|HYN|H","惠阳|AHE|H","吉安|KNC|J","荆州|SHS|J"];
csms[3]=["黎平|HZH|L","库车|KCA|K","康定|KGT|K","喀什|KHG|K","南昌|KHN|N","昆明|KMG|K","库尔勒|KRL|K","克拉玛依|KRY|K","龙岩|LCX|L","兰州|LHW|L","梁平|LIA|L","丽江|LJG|L","临沧|LNJ|L","拉萨|LXA|L","林西|LXI|L","洛阳|LYA|L","连云港|LYG|L","临沂|LYI|L","柳州|LZH|L","泸州|LZO|L","林芝|LZY|L","牡丹江|MDG|M","绵阳|MIG|M","梅县|MXZ|M","南充|NAO|N","宁波|NGB|N","南京|NKG|N","那拉提|NLT|N","南宁|NNG|N","南阳|NNY|N","南通|NTG|N","满州里|NZH|M","漠河|OHE|M","昆明|KMG|K","喀纳斯|KJI|K"];
csms[4]=["乌兰浩特|HLH|S","台州|HYN|T","且末|IQM|Q","庆阳|IQN|Q","黔江|JIQ|S","衢州|JUZ|Q","齐齐哈尔|NDG|Q","上海|SHA|S","攀枝花|PZI|P","日喀则|RKZ|R","沈阳|SHE|S","秦皇岛|SHP|Q","沙市|SHS|S","石家庄|SJW|S","普洱(思茅)|SYM|S","三亚|SYX|S","深圳|SZX|S","青岛|TAO|Q","塔城|TCG|T","铜仁|TEN|T","通辽|TGO|T","天水|THQ|T","天津|TSN|T","唐山|TVS|T","太原|TYN|T","乌鲁木齐|URC|W","潍坊|WEF|W","威海|WEH|W","文山|WNH|W","温州|WNZ|W","乌海|WUA|W","武汉|WUH|W","武夷山|WUS|W","无锡|WUX|W","梧州|WUZ|W","万州|WXN|W","上海(虹桥)|SHA|S","上海(浦东)|PVG|S","泉州晋江|JJN|Q","汕头|SWA|S","鄯善|SXJ|S","韶关|SHG|S"];
csms[5]=["兴义|ACX|X","郑州|CGO|Z","张家界|DYG|Z","延安|ENY|Y","舟山|HSN|Z","银川|INC|Y","西双版纳|JHG|X","伊春|LDS|Y","永州|LLF|Y","榆林|UYN|Y","襄樊|XFN|X","西昌|XIC|X","锡林浩特|XIL|X","西安|XIY|X","厦门|XMN|X","西宁|XNN|X","徐州|XUZ|X","宜宾|YBP|Y","运城|YCU|Y","宜昌|YIH|Y","伊宁|YIN|Y","义乌|YIW|Y","延吉|YNJ|Y","烟台|YNT|Y","扬州|YTY|Y","盐城|YNZ|Y","张掖|YZY|Z","昭通|ZAT|Z","中山|ZSW|Z","中卫|ZHY|Z","湛江|ZHA|Z","珠海|ZUH|Z","遵义|ZYI|Z","香格里拉|DIG|X"];
var ywzm_en = new Array("rm","A-F","G-J","K-N","P-W","X-Z"); 
var ywzm = new Array("热门","ABCDEF","GHIJ","KLMN","PQRSTW","XYZ"); 
var ywzm_d=new Array("drm","da","dg","dk","dp","dx");
var ywzm_d_cs=new Array("drm","da","dg","dk","dp","dx");
var popup_gd=25;  //数据显示高度
var popup_i; 
var popup_int0=0;
var popup_int1=0;
var popup_int2=0;
var popup_int3=0;

function Split(popup_str, popup_n, popup_s) { // 字符串,取第几个数据,分割字符
	var popup_split = popup_str.split(popup_s);
	return popup_split[popup_n];
}

var objPopup;// 城市展示容器层

function popUp(abc, code) {
	if (typeof (abc) == 'string') {
		kongj = document.getElementById(abc);
		kongj_code = document.getElementById(code);
	} else {
		kongj = abc;
		kongj_code = code;
	}
	var objBody = document.getElementById("mainbody");
	if (!document.getElementById("city_popup")) {
		objPopup = document.createElement("div");
	} else {
		kongj.value = "";
		fix_div_coordinate(kongj);
		objPopup.style.visibility = "visible";
		document.getElementById("city").style.display = "";
		return;
	}

	objPopup.style.visibility = "hidden";

	kongj.value = "";

	popup_int0 = 0;
	popup_int1 = 0;
	popup_int2 = 0;
	popup_int3 = 0;
	var tab;
	tab = '<div id="city" style="z-index:9999;width:350px;">';
	tab += '<div class="city-top"><font class="fff">热门城市(可输入城市或城市拼音)</font></div>';
	tab += '<div id="city-box" class="city-box f">';
	tab += '<ul  style="padding:5px 0 5px 0;">';
	for (var ywzm_i = 0; ywzm_i < 6; ywzm_i++) {
		if (!ywzm[ywzm_i])
			break;
		tab += '<li id="syy_' + ywzm_en[ywzm_i]
				+ '" class="f city-nav" onclick="f1(id,' + "'" + ywzm_d[ywzm_i]
				+ "'" + ')"><span style="cursor: pointer;" href="#">'
				+ ywzm[ywzm_i] + '</span></li>';
	}
	tab += '<li class="f city-nav-right">&nbsp;</li>';
	tab += '<div class="c"></div>';
	tab += '</ul>';
	for (var cs = 0; cs < 6; cs++) {
		tab += '<div id="' + ywzm_d_cs[cs]
				+ '" class="mt5 c" style="display: none">';
		tab += '<ul id="gnu' + cs + '">';
		if (cs == 0) {
			for (var csm = 0; csm < csms[cs].length; csm++) {
				var tem = csms[cs][csm];
				var id1 = Split(tem, 1, "|");
				var value1 = Split(tem, 0, "|");
				tab += '<li  class="f cityon"><a  id=' + id1
						+ ' href="javascript:void(0);">' + value1 + '</a></li>';
			}
		}
		tab += '</ul><iframe style="border:none;position:absolute; visibility:inherit; top:0px; left:0px; width:100%; z-index:-1; filter: Alpha(Opacity=0);"></iframe>';
		tab += '</div>';
	}

	objPopup.innerHTML = tab;
	objPopup.onclick = Htc_OnClick;
	objPopup.onmousemove = Htc_onmousemove;
	objPopup.setAttribute('id', 'city_popup');
	objBody.appendChild(objPopup);
	document.getElementById("drm").style.display = "inline";
	document.getElementById("syy_rm").className = "f city-navon";
	fix_div_coordinate(kongj);
	objPopup.style.visibility = "visible";
	objPopup.style.position = "absolute";
}

function fix_div_coordinate(obj) {
	var leftpos = 0;
	var toppos = 0;
	aTag = obj;
	do {
		if (aTag.offsetParent) {
			aTag = aTag.offsetParent;
		} else {
			leftpos += aTag.style.left;
			toppos += aTag.style.top;
			break;
		}
		leftpos += aTag.offsetLeft;
		toppos += aTag.offsetTop;
	} while (aTag.id != "mainbody");
	// alert("leftpos=["+leftpos+"]--toppos=["+toppos+"]--obj.offsetTop=["+obj.offsetTop+"]--obj.offsetLeft=["+obj.offsetLeft+"]--obj.offsetHeight=["+obj.offsetHeight+"]");
	if (document.layers) {
		document.getElementById("city_popup").style.left = obj.offsetLeft
				+ parseInt(leftpos) + "px";
		document.getElementById("city_popup").style.top = obj.offsetTop
				+ parseInt(toppos) + obj.offsetHeight + 2 + "px";
	} else {
		document.getElementById("city_popup").style.left = obj.offsetLeft
				+ parseInt(leftpos) + "px";
		document.getElementById("city_popup").style.top = obj.offsetTop
				+ parseInt(toppos) + obj.offsetHeight + 2 + "px";
	}
	// alert("left=["+document.getElementById("city_popup").style.left+"]
	// top=["+document.getElementById("city_popup").style.top+"]");
}

function popup_hide() {
	if (objPopup.style.visibility == "visible")
		objPopup.style.visibility = "hidden";
}

function Htc_OnClick() { // 鼠标点击事件
	var Htc_str;
	var obj = document.parentWindow || document.defaultView;
	var e = obj.GetEvent().srcElement || obj.GetEvent().target;
	clicObj = e;

	if (e.tagName == "SPAN") {
		if (e.id != "") {
			yc_dt(e.id);
		}
	}
	if (e.tagName == "A") {
		objPopup.style.visibility = "hidden";
		f_z(document.getElementById(e.id).innerHTML);
		MYopoupmovOut();

	}

	if (e.tagName == "UL") {// H_
		if (e.id != "") {
			yc_dt(Split(e.id, 1, "_"));
		}
	}
	if (e.tagName == "DIV") {
		if (e.innerHTML != "")
			yc_dt(e.innerHTML);
	}
}

// 获取event对象的一个方法，兼容IE、FF
function GetEvent(obj) {
	if (document.all) // IE
	{
		return window.event;
	}

	func = GetEvent.caller; // 返回调用本函数的函数
	while (func != null) {
		// Firefox 中一个隐含的对象 arguments，第一个参数为 event 对象
		var arg0 = func.arguments[0];
		// alert('参数长度：' + func.arguments.length);
		if (arg0) {
			if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
					|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
				return arg0;
			}
		}
		func = func.caller;
	}
	return null;
}

var ll = "popup_td_cszm_0";
function Htc_onmousemove() { // 鼠标移动事件
	var obj = document.parentWindow || document.defaultView;
	var e = obj.GetEvent().srcElement || obj.GetEvent().target;
	if (e.tagName == "TD" && e.id.split("_")[0] != "H") {
		if (e.id != "") {
			turnrowcolor(e.id, ll);
			MYopoupmovOut();
		}
	}
	if (e.tagName == "NOBR") {
		if (e.id != "") {
			turnrowcolor("popup_td_cszm_" + Split(e.id, 4, "_"), ll);
			MYopoupmovOut();
		}
	}
	if (e.tagName == "LABEL") {
		// MYopoupmov(e.id);
	}
}

function turnrowcolor(ss, ls) { // 鼠标移动TD背景颜色
	var bc = "#e7f1fd";
	if (document.getElementById(ls))
		document.getElementById(ls).style.backgroundColor = "";
	if (document.getElementById(ss))
		document.getElementById(ss).style.backgroundColor = bc;
	if (document.getElementById(ss))
		document.getElementById(ss).style.cursor = "hand";
	ll = ss;
}

var yc_dt_cs = "SH";
function yc_dt(int) {
	if (int != yc_dt_cs) {
		if (int.length = 3)
			int = int.replace(/"/g, "");
		if (document.getElementById("syy_" + int))
			document.getElementById("syy_" + int).style.color = "#21407D";
		if (document.getElementById("syy_" + yc_dt_cs))
			document.getElementById("syy_" + yc_dt_cs).style.color = "#21407D";
		yc_dt_cs = int;
		if (int == "SH" || int == "热门城市") {
			Popup_tab(int, 1);
		} else {
			Popup_tab(int, 0);
		}
	}
}

function Popup_tab(str, lx) { // 生成数据
	var Popup_dat_i = 0;
	var Popup_dat_n;
	var Popup_dat_tab = "";
	var Popup_dat = new Array();

	for (var cs = 0; cs < 6; cs++) {
		Popup_dat_tab += '<div id="' + ywzm_d_cs[cs] + '" class="mt5 c">';
		Popup_dat_tab += '<ul id="u' + cs + '">';
		for (var csm = 0; csm < csms[cs].size; csm++) {
			alert('0');
			Popup_dat_tab += '<li id=Split(' + csms[cs][csm]
					+ ',1,|) class="f cityon"><a href="#">Split('
					+ csms[cs][csm] + ',0,|)</a></li>';
		}
		Popup_dat_tab += '<div style="clear:both">'
		Popup_dat_tab += '</div>'
		Popup_dat_tab += '</ul>';
		Popup_dat_tab += '</div>';
	}
	/*
	 * if( Split(str,0,'_')=="syy" )str=Split(str,1,'_');
	 * 
	 * if(lx==0){ for(Popup_dat_n=0;Popup_dat_n<qtcs.length;Popup_dat_n++){
	 * if(Split(qtcs[Popup_dat_n],2,"|")==str){
	 * Popup_dat[Popup_dat_i++]=qtcs[Popup_dat_n]; } } }else{ Popup_dat=shcs; }
	 * popup_int0=0;
	 * 
	 * Popup_dat_tab+= '<table width="100%" border="0" cellspacing="1"
	 * cellpadding="0" style="font-size: 9pt;color: #21407D">';
	 * for(Popup_dat_n=0;Popup_dat_n<36;Popup_dat_n++){ if(Popup_dat_n==0 ||
	 * Popup_dat_n % 6 ==0){ Popup_dat_tab+= '
	 * <tr align="center" style="background-color:' +tr01_03+ ';">'; }
	 * if(Popup_dat[Popup_dat_n]){
	 * 
	 * Popup_dat_tab+= '
	 * <td height="'+popup_gd+'" width="14.3%" ID="popup_td_cszm_'+popup_int0+'" title="'+Split(Popup_dat[Popup_dat_n],0,"|")+'" style="font-size: 9pt;color: #21407D"><NOBR
	 * '+style3+'
	 * ID="popup_NOBR_cszm_'+Split(Popup_dat[Popup_dat_n],1,"|")+'_'+popup_int0+'">'+Split(Popup_dat[Popup_dat_n],0,"|")+'</NOBR></td>';
	 * popup_int0++; }else{ Popup_dat_tab+= '
	 * <td height="'+popup_gd+'" width="14.3%">&nbsp;</td>'; } popup_int3 =
	 * Popup_dat_n+1; if(popup_int3 % 6 ==0){ Popup_dat_tab+= ' </tr>'; } }
	 * Popup_dat_tab+= ' </table>';
	 * 
	 * document.getElementById("city-box").innerHTML=Popup_dat_tab;
	 */
}

function f_z(temp) { // 赋值给控件
	kongj.value = temp;
	setCodevalue(temp);
	kongj.style.color = "#000000";
}
function setCodevalue(temp) {
	var length = qtcs.length;

	for (i = 0; i < length; i++) {
		var tempArray = qtcs[i].split("|");
		if (tempArray[0] == temp) {
			// kongj.codevalue=tempArray[1];
			kongj_code.value = tempArray[1];
			break;
		}
	}
}

function MYopoupmov(obj) {
	var _div = document.getElementById("_div_tmp");
	obj = document.getElementById(obj);

	var leftpos = 0;
	var toppos = 0;
	aTag = obj;
	do {
		if (aTag.offsetParent) {
			aTag = aTag.offsetParent;
		} else {
			leftpos += aTag.style.left;
			toppos += aTag.style.top;
			break;
		}
		leftpos += aTag.offsetLeft;
		toppos += aTag.offsetTop;
	} while (aTag.id != "mainbody");
	if (document.layers) {
		CitySelectnewX = obj.offsetLeft + parseInt(leftpos) - 7 + "px";
		CitySelectnewY = obj.offsetTop + parseInt(toppos) + obj.offsetHeight
				- 16 + "px";
	} else {
		CitySelectnewX = obj.offsetLeft + parseInt(leftpos) - 7 + "px";
		CitySelectnewY = obj.offsetTop + parseInt(toppos) + obj.offsetHeight
				- 16 + "px";
	}

	var CitySelectneww = obj.offsetWidth + 14;

	_div.style.left = CitySelectnewX;
	_div.style.top = CitySelectnewY;
	_div.style.width = CitySelectneww + "px";
	_div.innerHTML = obj.innerHTML;
	_div.style.display = "";
}

function MYopoupmovOut() {
	if (document.getElementById("city").style.display == "")
		document.getElementById("city").style.display = "none";
}

var posLib = {
	getClientLeft : function(el) {
		var r = el.getBoundingClientRect();
		return r.left - this.getBorderLeftWidth(this.getCanvasElement(el));
	},

	getClientTop : function(el) {
		var r = el.getBoundingClientRect();
		return r.top - this.getBorderTopWidth(this.getCanvasElement(el));
	},

	getLeft : function(el) {
		return this.getClientLeft(el) + this.getCanvasElement(el).scrollLeft;
	},

	getTop : function(el) {
		return this.getClientTop(el) + this.getCanvasElement(el).scrollTop;
	},

	getInnerLeft : function(el) {
		return this.getLeft(el) + this.getBorderLeftWidth(el);
	},

	getInnerTop : function(el) {
		return this.getTop(el) + this.getBorderTopWidth(el);
	},

	getWidth : function(el) {
		return el.offsetWidth;
	},

	getHeight : function(el) {
		return el.offsetHeight;
	},

	getCanvasElement : function(el) {
		var doc = el.ownerDocument || el.document; // IE55 bug
		if (doc.compatMode == "CSS1Compat")
			return doc.documentElement;
		else
			return doc.body;
	},

	getBorderLeftWidth : function(el) {
		return el.clientLeft;
	},

	getBorderTopWidth : function(el) {
		return el.clientTop;
	},

	getScreenLeft : function(el) {
		var doc = el.ownerDocument || el.document; // IE55 bug
		var w = doc.parentWindow;
		return w.screenLeft
				+ this.getBorderLeftWidth(this.getCanvasElement(el))
				+ this.getClientLeft(el);
	},

	getScreenTop : function(el) {
		var doc = el.ownerDocument || el.document; // IE55 bug
		var w = doc.parentWindow;
		return w.screenTop + this.getClientTop(el);// +
													// this.getBorderTopWidth(this.getCanvasElement(el))
	}
}

document.onclick = function(e2) {
	e2 = window.event || e2;
	var srcElement = e2.srcElement || e2.target;
	/** ********时间选择窗口操作********* */
	/** ********时间选择窗口操作********* */
	if (document.getElementById("city_popup")) {
		if ((objPopup.style.display == "" || objPopup.style.visibility == "visible")
				&& srcElement != kongj
				&& srcElement != objPopup
				&& srcElement != clicObj) {
			if (objPopup.style)
				objPopup.style.visibility = "hidden";
		}
	}
}

function f1(id, did) {
	document.getElementById("drm").style.display = "none";
	document.getElementById("da").style.display = "none";
	document.getElementById("dg").style.display = "none";
	document.getElementById("dk").style.display = "none";
	document.getElementById("dp").style.display = "none";
	document.getElementById("dx").style.display = "none";
	document.getElementById(did).style.display = "inline";
	var tab1 = "";
	var index;
	// var ywzm_d=new Array("drm","da","dg","dk","dp","dx");
	if (did == 'da') {
		for (var csm = 0; csm < csms[1].length; csm++) {
			var tem = csms[1][csm];
			var id1 = Split(tem, 1, "|");
			var value1 = Split(tem, 0, "|");
			tab1 += '<li  class="f cityon"><a  id=' + id1
					+ ' href="javascript:void(0);">' + value1 + '</a></li>';
		}
		document.getElementById('gnu1').innerHTML = tab1;
	}
	if (did == 'dg') {
		for (var csm = 0; csm < csms[2].length; csm++) {
			var tem = csms[2][csm];
			var id1 = Split(tem, 1, "|");
			var value1 = Split(tem, 0, "|");
			tab1 += '<li  class="f cityon"><a  id=' + id1
					+ ' href="javascript:void(0);">' + value1 + '</a></li>';
		}
		document.getElementById('gnu2').innerHTML = tab1;
	}
	if (did == 'dk') {
		for (var csm = 0; csm < csms[3].length; csm++) {
			var tem = csms[3][csm];
			var id1 = Split(tem, 1, "|");
			var value1 = Split(tem, 0, "|");
			tab1 += '<li  class="f cityon"><a  id=' + id1
					+ ' href="javascript:void(0);">' + value1 + '</a></li>';
		}
		document.getElementById('gnu3').innerHTML = tab1;
	}
	if (did == 'dp') {
		for (var csm = 0; csm < csms[4].length; csm++) {
			var tem = csms[4][csm];
			var id1 = Split(tem, 1, "|");
			var value1 = Split(tem, 0, "|");
			tab1 += '<li  class="f cityon"><a  id=' + id1
					+ ' href="javascript:void(0);">' + value1 + '</a></li>';
		}
		document.getElementById('gnu4').innerHTML = tab1;
	}
	if (did == 'dx') {
		for (var csm = 0; csm < csms[5].length; csm++) {
			var tem = csms[5][csm];
			var id1 = Split(tem, 1, "|");
			var value1 = Split(tem, 0, "|");
			tab1 += '<li  class="f cityon"><a  id=' + id1
					+ ' href="javascript:void(0);">' + value1 + '</a></li>';
		}
		document.getElementById('gnu5').innerHTML = tab1;
	}

	document.getElementById('syy_rm').className = 'f city-nav';
	document.getElementById('syy_A-F').className = 'f city-nav';
	document.getElementById('syy_G-J').className = 'f city-nav';
	document.getElementById('syy_K-N').className = 'f city-nav';
	document.getElementById('syy_P-W').className = 'f city-nav';
	document.getElementById('syy_X-Z').className = 'f city-nav';
	document.getElementById(id).className = 'f city-navon';
}