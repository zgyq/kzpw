// Java Documen


 


//初始化常用城市
var commoncitysgj,citys;

var commoncitysHotel = new Array();
var citysHotel = new Array();


var commoncitysFlightgj = new Array();
commoncitysFlightgj[0]=new Array('SZX','深圳','Shenzhen','SZ');
commoncitysFlightgj[1]=new Array('PEK','北京','Beijing','BJ');
commoncitysFlightgj[2]=new Array('SHA','上海虹桥','Shanghai','SH');
commoncitysFlightgj[3]=new Array('PVG','上海浦东','Shanghai','SH');
commoncitysFlightgj[4]=new Array('CAN','广州','Guangzhou','GZ');
commoncitysFlightgj[5]=new Array('HGH','杭州','Hangzhou','HZ');
commoncitysFlightgj[6]=new Array('CKG','重庆','Chongqing','CQ');
commoncitysFlightgj[7]=new Array('SIA','西安','Xian','XA');
commoncitysFlightgj[8]=new Array('WUH','武汉','Wuhan','WH');
commoncitysFlightgj[9]=new Array('NKG','南京','Nanjing','NJ');
commoncitysFlightgj[10]=new Array('SYX','三亚','Sanya','SY');

var intercitys=new Array();
intercitys[0]=new Array('HKG','香港','XIANGGANG','xg'); 
intercitys[1]=new Array('TYO','东京','TOKYO','dj');  
intercitys[2]=new Array('TPE','台北','TAIBEI','tb'); 
intercitys[3]=new Array('SEL','首尔','SEOUL','se');  
intercitys[4]=new Array('SIN','新加坡','SINGAPORE','xjp');  
intercitys[5]=new Array('BKK','曼谷','BANGKOK','mg');  
intercitys[6]=new Array('KUL','吉隆坡','jilongpo','jlp'); 
intercitys[7]=new Array('ITM','大阪','OSAKA','db'); 
intercitys[8]=new Array('MFM','澳门','AOMEN','am');  
intercitys[9]=new Array('CGK','雅加达','JAKARTA','yjd'); 
intercitys[10]=new Array('SGN','胡志明市','huzhimingshi','hzm'); 
intercitys[11]=new Array('MNL','马尼拉','manila','mnl'); 
intercitys[12]=new Array('DPS','巴厘岛','BALIDAO','bld'); 
intercitys[13]=new Array('NGO','名古屋','NAGOYA','mgw');
intercitys[14]=new Array('HKT','普吉岛','PUJIDAO','pjd');  
intercitys[15]=new Array('HAN','河内','HANOI','hn');
intercitys[16]=new Array('MLE','马累','Male','ml');
intercitys[17]=new Array('DXB','迪拜','DUBAI','db');
intercitys[18]=new Array('PUS','釜山','PUSAN','fs');    
intercitys[19]=new Array('KTM','加德满都','Kathmandu','jdmd');
intercitys[20]=new Array('KHH','高雄','GAOXIONG','gx'); 
intercitys[21]=new Array('FUK','福冈','FUKUOKA','fg');  
intercitys[22]=new Array('PNH','金边','PHNOM','jb');  
intercitys[23]=new Array('DEL','新德里','DELHI','xld');  
intercitys[24]=new Array('CJU','济州岛','JIZHOUDAO','jzd');  
intercitys[25]=new Array('SPK','札幌','SAPPORO','zh');  
intercitys[26]=new Array('IST','伊斯坦布尔','ISTANBUL','ystbe');  
intercitys[27]=new Array('ULN','乌兰巴托','ULANBATAR','wlbt');  
intercitys[28]=new Array('BOM','孟买','BOMBAY','mm');
intercitys[29]=new Array('LON','伦敦','LONDON','ld');  
intercitys[30]=new Array('ORY','巴黎','PARIS','bl');  
intercitys[31]=new Array('FRA','法兰克福','FRANKFURT','flkf');  
intercitys[32]=new Array('DME','莫斯科','MOSCOW','msk');  
intercitys[33]=new Array('FCO','罗马','ROME','lm');  
intercitys[34]=new Array('AMS','阿姆斯特丹','AMSTERDAM','amstd');  
intercitys[35]=new Array('LIN','米兰','MILAN','ml');  
intercitys[36]=new Array('MUC','慕尼黑','MUNICH','mnh');  
intercitys[37]=new Array('ARN','斯德哥尔摩','STOCKHOLM','sdgem');  
intercitys[38]=new Array('TXL','柏林','BERLIN','bl');
intercitys[39]=new Array('MAN','曼彻斯特','MANCHESTER','mcst');
intercitys[40]=new Array('MAD','马德里','Madrid','mdl');
intercitys[41]=new Array('ZRH','苏黎世','SULISHI','sls');
intercitys[42]=new Array('BRU','布鲁塞尔','BRUSSELS','blse');
intercitys[43]=new Array('CPH','哥本哈根','COPENHAGEN','gbhg');
intercitys[44]=new Array('HEL','赫尔辛基','HELSINKI','hexj');
intercitys[45]=new Array('VIE','维也纳','VIENNA','wyn');
intercitys[46]=new Array('BCN','巴塞罗那','BARCELONA','bsln');
intercitys[47]=new Array('ATH','雅典','ATHENS','yd');
intercitys[48]=new Array('EDI','爱丁堡','EDINBURGH','abd');
intercitys[49]=new Array('BHX','伯明翰(英','BIRMINGHAM','bmh');
intercitys[50]=new Array('NCL','纽卡斯尔','NEWCASTLE','nkse');
intercitys[51]=new Array('GVA','日内瓦','GENEVA','rnw');
intercitys[52]=new Array('LED','圣彼得堡','SHENGBIDEBAO','SBDB');
intercitys[53]=new Array('GLA','格拉斯哥','GLASGOW','glsg');
intercitys[54]=new Array('KBP','基辅','KIEV','jf');
intercitys[55]=new Array('BUD','布达佩斯','BUDAPEST','bdst');
intercitys[56]=new Array('HAM','汉堡','HAMBURG','hb');
intercitys[57]=new Array('PRG','布拉格','PRAGUE','blg');
intercitys[58]=new Array('DUS','杜塞尔多夫','DUSSELDORF','dsedf');
intercitys[59]=new Array('NYC','纽约','NEW YORK','ny');
intercitys[60]=new Array('LAX','洛杉矶','LUOSHANJI','lsj');
intercitys[61]=new Array('SFO','旧金山','JIUJINSHAN','jjs');
intercitys[62]=new Array('YVR','温哥华','VANCOUVER','wgh');
intercitys[63]=new Array('CHI','芝加哥','CHICAGO','zjg');
intercitys[64]=new Array('YTO','多伦多','TORONTO','dld');
intercitys[65]=new Array('SEA','西雅图','SEATTLE','xyt');
intercitys[66]=new Array('IAD','华盛顿','WASHINGTON','hsd');
intercitys[67]=new Array('DTW','底特律','DETROIT','dtl');
intercitys[68]=new Array('ATL','亚特兰大','ATLANTA','ytld');
intercitys[69]=new Array('HOU','休斯顿','HOUSTON','xsd');
intercitys[70]=new Array('SYD','悉尼','SYDNEY','xn');
intercitys[71]=new Array('YUL','蒙特利尔','MONTREAL','mtle');
intercitys[72]=new Array('SPN','塞班','SAIBAN','sb');
intercitys[73]=new Array('DFW','达拉斯','DALLAS','dls');
intercitys[74]=new Array('MSP','明尼阿波利斯','MINGNIABO','mnabls');
intercitys[75]=new Array('GRU','圣保罗','SAN POLO','sbl');
intercitys[76]=new Array('YOW','渥太华','OTTAWA','wth');
intercitys[77]=new Array('MEX','墨西哥城','MOXIGE','mxgc');
intercitys[78]=new Array('LAS','拉斯维加斯','LAS VEGAS','lswjs');
intercitys[79]=new Array('MIA','迈阿密','MIAMI','mam');
intercitys[80]=new Array('DEN','丹佛','DENVER','df');
intercitys[81]=new Array('MCO','奥兰多','ORLANDO','ald');
intercitys[82]=new Array('PDX','波特兰','PORTLAND','btl');
intercitys[83]=new Array('GRU','圣保罗','SAN POLO','sbl');
intercitys[84]=new Array('MAN','曼彻斯特','MANCHESTER','mcst');
intercitys[85]=new Array('BUE','布宜诺斯艾','BUYINUOSIAI','bynsa');
intercitys[86]=new Array('CAI','开罗','CAIRO','kl');
intercitys[87]=new Array('JNB','约翰内斯堡','YUEHANNEISIBAO','yhnsb');
intercitys[88]=new Array('CPT','开普敦','CAPE TOWN','kpd');
intercitys[89]=new Array('NBO','内罗毕','NAIROBI','nlb');
intercitys[90]=new Array('LOS','拉各斯','LAGOS','lgs');
intercitys[91]=new Array('LAD','罗安达','LUANDA','lad');
intercitys[92]=new Array('MRU','毛里求斯','MAURITIUS','mlqs')
intercitys[93]=new Array('ADD','亚的斯亚贝','YADESIYABEI','ydsyb')
intercitys[94]=new Array('TUN','突尼斯','TUNIS','tns')
intercitys[95]=new Array('LUN','卢萨卡','LUSAKA','lsk')
intercitys[96]=new Array('HRE','哈拉雷','HARARE','hll')
intercitys[97]=new Array('YAO','雅温得','YAOUNDE','ywd')
intercitys[98]=new Array('GBE','哈博罗内','GABORONE','hbln')
intercitys[99]=new Array('FIH','金沙萨','KINSHASA','jss')
intercitys[100]=new Array('MPM','马普托','MAPUTO','mpt')
intercitys[101]=new Array('DLA','杜阿拉','DOUALA','dal')
intercitys[102]=new Array('SYD','悉尼','SYDNEY','xn')
intercitys[103]=new Array('MEL','墨尔本','MELBOURNE','meb')
intercitys[104]=new Array('AKL','奥克兰','AUCKLAND','akl')
intercitys[105]=new Array('BNE','布里斯班','BRISBANE','blsb')
intercitys[106]=new Array('ADL','阿德莱德','ADELAIDE','adld')
intercitys[107]=new Array('WLG','惠灵顿','WELLINGTON','hld')
intercitys[108]=new Array('CBR','堪培拉','CANBERRA','kpl')
intercitys[109]=new Array('CNS','凯恩斯','CAIRNS','kes')
intercitys[110]=new Array('CHC','克赖斯特彻','KELAISITECHE','klstc')
intercitys[111]=new Array('NAN','楠迪','NADI','nd');
intercitys[112]=new Array('OOL','黄金海岸','HUANGJINHAIAN','hjha');
intercitys[113]=new Array('DRW','达尔文','DAERWEN','dew');
intercitys[114]=new Array('SHA','上海虹桥','Shanghai','SH');
intercitys[115]=new Array('BJS','北京','BEIJING','BEIJING');
intercitys[116]=new Array('CAN','广州','Guangzhou','GZ');
intercitys[117]=new Array('XMN','厦门','Xiamen','XM');
intercitys[118]=new Array('HGH','杭州','Hangzhou','HZ');
intercitys[119]=new Array('TAO','青岛','Qingdao','QD');
intercitys[120]=new Array('NKG','南京','Nanjing','NJ');
intercitys[121]=new Array('SZX','深圳','Shenzhen','SZ');
intercitys[122]=new Array('FOC','福州','Fuzhou','FZ');
intercitys[123]=new Array('DLC','大连','Dalian','DL');
intercitys[124]=new Array('CTU','成都','Chengdu','CD');
intercitys[125]=new Array('SYX','三亚','Sanya','SY');
intercitys[126]=new Array('SWA','汕头','Shantou','ST');
intercitys[127]=new Array('NGB','宁波','Ningbo','NB');
intercitys[128]=new Array('TSN','天津','Tianjin','TJ');
intercitys[129]=new Array('KMG','昆明','Kunming','KM');
intercitys[130]=new Array('CSX','长沙','Changsha','CS');
intercitys[131]=new Array('JJN','晋江','jinjiang','JJ');
intercitys[132]=new Array('CGQ','长春','changchun','CC');
commoncitysgj = commoncitysFlightgj;
citysgj = intercitys;


//根据三字码查找城市
function getCityByThreeWord(threeWord)
{
	var cityCn = "";
	for(var i = 0,len = citysgj.length;i<len;i++)
	{
		if(threeWord == citysgj[i][0])
		{
			cityCn = citysgj[i][1];
			break;
		}
	}
	return cityCn;
}
//根据城市查找三字码
function getThreeWordByCity(cityName)
{
	var threeWord = "";
	for(var i = 0,len = citysgj.length;i<len;i++)
	{
		if(cityName == citysgj[i][1])
		{
			threeWord = citysgj[i][0];
			break;
		}
	}
	return threeWord;
}
var parentbject;
var city_suggestgj = function(){
	this.Remoreurl = ''; // 远程URL地址
	this.object = '';
	this.id2 = '';
	this.taskid = 0;
	this.delaySec = 100; // 默认延迟多少毫秒出现提示框
	this.lastkeys_val= 0;
	var lastkeys_val= 0;
	this.lastinputstr = '';	
	/**
	* 初始化类库
	*/
	this.init_zhaobussuggest=  function(){
		var objBody = document.getElementById("mainbody");
		var objiFrame = document.createElement("iframe");
		var objplatform = document.createElement("div");
                 
		objiFrame.setAttribute('id','getiframe');
		objiFrame.style.zindex='100';		
		objiFrame.style.position = 'absolute';
		objiFrame.style.display = 'none';
		objplatform.setAttribute('id','getplatform');
		objplatform.setAttribute('align','left');
		objplatform.style.zindex='999999';
		objBody.appendChild(objiFrame);
		objBody.appendChild(objplatform);
		var win=objBody || window
                
		if(!document.all) {
			objBody.addEventListener("click",this.hidden_suggest,false);
			
		}else{
			win.document.attachEvent("onclick",this.hidden_suggest);
			
		}
	}

	/***************************************************fill_div()*********************************************/
	//函数功能：动态填充div的内容，该div显示所有的提示内容
	//函数参数：allplat 一个字符串数组，包含了所有可能的提示内容
	this.fill_div = function(allplat){
		var msgplat = '';
		var all = '';
		var spell = '';
		var chinese = '';
		var platkeys = this.object.value;
        platkeys=this.ltrim(platkeys);
		if(!platkeys){
			msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">输入中文/拼音或&uarr;&darr;选择</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
			for(i=0;i<allplat.length;i++){
			    all=allplat[i].split(",");
				spell=all[0];
				chinese=all[1];
				szm=all[2];
				msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\'' + chinese + '\',\'' + szm + '\')"><td class="tdleft" height="10" align="left">'+ spell +
				       '</td><td class="tdright" align="right">' + chinese + '</td><td style="display:none">' + szm + '</td></tr></table>';
			}
        }
		else {
			if(allplat.length < 1 || !allplat[0]){
				msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">对不起，找不到：'+platkeys+'</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';

			}
			else{
			   msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">'+platkeys+'，按拼音排序</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
			   for(i=0;i<allplat.length;i++){
					all=allplat[i].split(",");
					spell=all[0];
					chinese=all[1];
					szm=all[2];
					msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\'' + chinese + '\',\'' + szm + '\')"><td class="tdleft" height="10" align="left">'+ spell +
				       '</td><td class="tdright" align="right">' + chinese + '</td><td style="display:none">' + szm + '</td></tr></table>';
				}
			}
		}
		document.getElementById("getplatform").innerHTML =  msgplat;
		var nodes = document.getElementById("getplatform").childNodes;
		nodes[0].className = "hint";
		if(allplat.length >= 1 && allplat[0]){
			nodes[2].className = "selected";
		}
		//this.lastkeys_val = 0;
		for(var i=2;i<nodes.length;i++){
			nodes[i].onmouseover = function(){
				this.className = "mover";
				}
			nodes[i].onmouseout = function(){
				if(parentbject.lastkeys_val==(parentIndexOf(this)-2)){this.className = "selected";}
				else{this.className = "mout";}
			}
		}
		document.getElementById("getiframe").style.width = document.getElementById("getplatform").clientWidth+2;
        document.getElementById("getiframe").style.height = document.getElementById("getplatform").clientHeight+2;		
	}

	/***************************************************fix_div_coordinate*********************************************/
	//函数功能：控制提示div的位置，使之刚好出现在文本输入框的下面
	this.fix_div_coordinate = function(){
		var leftpos=0;
		var toppos=0;
		var testtmp=this.object.value;
		var testtmp1=this.object.id;
		aTag = this.object;
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
		//alert("leftpos=["+leftpos+"]--toppos=["+toppos+"]--this.object.offsetTop=["+this.object.offsetTop+"]--this.object.offsetLeft=["+this.object.offsetLeft+"]--this.object.offsetHeight=["+this.object.offsetHeight+"]");
		document.getElementById("getiframe").style.width = this.object.offsetWidth + 'px';
		
		if(document.layers){
			document.getElementById("getiframe").style.left = this.object.offsetLeft	+ parseInt(leftpos) + "px";
			document.getElementById("getiframe").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("getiframe").style.left =this.object.offsetLeft	+ parseInt(leftpos)  +"px";
			document.getElementById("getiframe").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}
		//document.getElementById("getplatform").style.width = this.object.offsetWidth + 'px';
		//document.getElementById("getiframe").style.width= this.object.offsetWidth + 'px';
		if(document.layers){
			document.getElementById("getplatform").style.left = this.object.offsetLeft	+ parseInt(leftpos) + "px";
			document.getElementById("getplatform").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("getplatform").style.left =this.object.offsetLeft	+ parseInt(leftpos)  +"px";
			document.getElementById("getplatform").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}
		//alert("getiframe.left=["+document.getElementById("getiframe").style.left+"]--getiframe.top=["+document.getElementById("getiframe").style.top+"]--getplatform.left=["+document.getElementById("getplatform").style.left+"]--getplatform.top=["+document.getElementById("getplatform").style.top+"]");
	}

    /***************************************************hidden_suggest*********************************************/
	//函数功能：隐藏提示框
	this.hidden_suggest = function (){
		this.lastkeys_val = 0;		 
		document.getElementById("getiframe").style.visibility = "hidden";
		document.getElementById("getplatform").style.visibility = "hidden";
	}

	/***************************************************show_suggest*********************************************/
	//函数功能：显示提示框
	this.show_suggest = function (){
		document.getElementById("getiframe").style.visibility = "visible";
		document.getElementById("getplatform").style.visibility = "visible";
	}
	this.is_showsuggest= function (){
		if(document.getElementById("getplatform").style.visibility == "visible") return true;else return false;
	}

	this.sleep = function(n){
		var start=new Date().getTime(); //for opera only
		while(true) if(new Date().getTime()-start>n) break;
	}
	this.ltrim = function (strtext){
		return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
	}

    /***************************************************add_input_text*********************************************/
	//函数功能：当用户选中时填充相应的城市名字

	this.add_input_text = function (keys,szm){
		 
		keys=this.ltrim(keys)
		this.object.value = keys;
		var id=this.object.id;		
		document.getElementById(this.id2.id).value = szm;
		document.getElementById(id).style.color="#000000";
		document.getElementById(id).value=keys;
		hidden_suggest();
		
		this.lastkeys_val = 0;		 
		document.getElementById("getiframe").style.visibility = "hidden";
		document.getElementById("getplatform").style.visibility = "hidden";
		
		//隐藏
     }

	/***************************************************keys_handleup*********************************************/
	//函数功能：用于处理当用户用向上的方向键选择内容时的事件
	this.keys_handleup = function (){
		if(this.lastkeys_val > 0) this.lastkeys_val--;
		var nodes = document.getElementById("getplatform").childNodes;
		if(this.lastkeys_val < 0) this.lastkeys_val = nodes.length-1;
		var b = 0;
		for(var i=2;i<nodes.length;i++){
			if(b == this.lastkeys_val){
				nodes[i].className = "selected";
				this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}else{
				nodes[i].className = "mout";
			}
			b++;
		}
	}

	/***************************************************keys_handledown*********************************************/
	//函数功能：用于处理当用户用向下的方向键选择内容时的事件
	this.keys_handledown = function (){
		
		this.lastkeys_val++;
		
		var nodes = document.getElementById("getplatform").childNodes;
		
		if(this.lastkeys_val >= nodes.length-2) {
			
			this.lastkeys_val--;
			return;
		}
		
		var b = 0;
		for(var i=2;i<nodes.length;i++){
			
			if(b == this.lastkeys_val){
				
				nodes[i].className = "selected";
				this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}else{
				nodes[i].className = "mout";
			}
			b++;
		}
	}

	this.ajaxac_getkeycode = function (e)
	{
		var code;
		if (!e) var e = window.event;
		if (e.keyCode) code = e.keyCode;
		else if (e.which) code = e.which;
		
		return code;
		
	}

	/***************************************************keys_enter*********************************************/
	//函数功能：用于处理当用户回车键选择内容时的事件
	this.keys_enter = function (){
		  
		var nodes = document.getElementById("getplatform").childNodes;
		for(var i=2;i<nodes.length;i++){
			if(nodes[i].className == "selected"){
				
			  this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}
		}
		this.hidden_suggest();
	}

 
function getEvent()
{
 if(document.all)    return window.event;//如果是ie
 func=getEvent.caller;
        while(func!=null){
            var arg0=func.arguments[0];
            if(arg0){if((arg0.constructor==Event || arg0.constructor ==MouseEvent) || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){return arg0;}            }
            func=func.caller;
        }
       return null;
}

    /***************************************************display*********************************************/
	//函数功能：入口函数，将提示层div显示出来
	//输入参数：object 当前输入所在的对象，如文本框
	//输入参数：e IE事件对象
	this.display = function (object,id2,e){
		this.object = document.getElementById(object);
		this.id2 = document.getElementById(id2);
		if(!document.getElementById("getplatform")) this.init_zhaobussuggest();
		e = e || window.event;
		//var e=getEvent();
		
		e.stopPropagation;
		e.cancelBubble = true;
		if (e.target) targ = e.target;  else if (e.srcElement) targ = e.srcElement;
		if (targ.nodeType == 3)  targ = targ.parentNode;

		var inputkeys = this.ajaxac_getkeycode(e);
		switch(inputkeys){
			case 38: //向上方向键
				this.keys_handleup(this.object.id);
			    return;break;
			case 40: //向下方向键
			  
				if(this.is_showsuggest()) this.keys_handledown(this.object.id); else this.show_suggest();
			    return;break;
			case 39: //向右方向键
				return;break;
			case 37: //向左方向键
				return;break;
			case 13: //对应回车键
			 
			    this.keys_enter();
			    return;break;
			case 18: //对应Alt键
				this.hidden_suggest();
			    return;break;
			case 27: //对应Esc键
				this.hidden_suggest();
			    return;break;
		}

		//object.value = this.ltrim(object.value);
		
		//if(object.value == this.lastinputstr) return;else this.lastinputstr = object.value;
		if(window.opera) this.sleep(100);//延迟0.1秒
		parentbject = this;
		if(this.taskid) window.clearTimeout(this.taskid);
        this.taskid=setTimeout("parentbject.localtext();" , this.delaySec)
		//this.taskid = setTimeout("parentbject.remoteurltext();" , this.delaySec);
		
	}

	//函数功能：从本地js数组中获取要填充到提示层div中的文本内容
	this.localtext = function(){
		var id=this.object.id;
        var suggestions="";
        suggestions=this.getSuggestionByName();
		suggestions=suggestions.substring(0,suggestions.length-1);

		parentbject.show_suggest();
		parentbject.fill_div(suggestions.split(';'));
		parentbject.fix_div_coordinate();
	}

	/***************************************************getSuggestionByName*********************************************/
	//函数功能：从本地js数组中获取要填充到提示层div中的城市名字
	this.getSuggestionByName = function(){
		platkeys = this.object.value;
		var str="";
        platkeys=this.ltrim(platkeys);
		if(!platkeys){
			for(i=0;i<commoncitysgj.length;i++){
				str+=commoncitysgj[i][2]+","+commoncitysgj[i][1]+","+commoncitysgj[i][0]+";";
			}
			return str;
        }
		else{
		   platkeys=platkeys.toUpperCase();
			for(i=0;i<citysgj.length;i++){
			    if(//this.getLeftStr(citys[i][0],platkeys.length).toUpperCase()==platkeys||
				   (citysgj[i][1].toUpperCase().indexOf(platkeys)!=-1)||
				   this.getLeftStr(citysgj[i][2],platkeys.length).toUpperCase()==platkeys||
				   this.getLeftStr(citysgj[i][3],platkeys.length).toUpperCase()==platkeys)
					str+=citysgj[i][2]+","+citysgj[i][1]+","+citysgj[i][0]+";";
			}
			return str;
		}
	}

	/***************************************************getLeftStr************* *************************************/
    //函数功能：得到左边的字符串
    this.getLeftStr = function(str,len){

        if(isNaN(len)||len==null){
            len = str.length;
        }
        else{
            if(parseInt(len)<0||parseInt(len)>str.length){
                len = str.length;
             }
        }
        return str.substr(0,len);
    }

	/***************************************************parentIndexOf************* *************************************/
    //函数功能：得到子结点在父结点的位置
	function parentIndexOf(node){
	  for (var i=0; i<node.parentNode.childNodes.length; i++){
			if(node==node.parentNode.childNodes[i]){return i;}
	  }
   }


}

function showSearchgj(obj,type){
	
	
    if(type==1){
        if(document.getElementById(obj).value==""){
			document.getElementById(obj).style.color="#C1C1C1";
			document.getElementById(obj).value="中文/拼音";
		}
    }else{
        if(document.getElementById(obj).value=="中文/拼音"){
			document.getElementById(obj).style.color="#000000";
            document.getElementById(obj).value="";
		}
    }
}


 

 var suggestgj = new city_suggestgj();
 
function change_iframe(idname,urlcity){
	idname.location.href=urlcity;
}
//改变搜索框文字
function changetext(thisid){
	if(thisid == "search1"){
		commoncitys = commoncitysHotel;
		citys = citysHotel;
		document.getElementById("hCity").value = "中文/拼音";
	}else if(thisid == "search2"){
		commoncitysgj = commoncitysFlightgj;
		citysgj = intercitys;
		document.getElementById("fromcity").value = "中文/拼音";
	}

	for(i=1; i<=3; i++)
	{
		var tdid="search"+i;
		document.getElementById(tdid).className="searchitem_b";
	}
	
	document.getElementById(thisid).className="searchitem_r";
}
<!-- 搜索框更换-->
function closeothers(thisid) {
  if (thisid.style.display=="") { 
	hotel.style.display="none";
	plane.style.display="none";
	pkg.style.display="none";
	
    thisid.style.display="";
  }
  else{
  thisid.style.display="";
  }
}