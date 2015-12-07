jq = jQuery.noConflict(); 
var currentInput;
var StationJson = "{\"Station\":[{Item:\"北京\"},{Item:\"上海\"},{Item:\"深圳\"},{Item:\"广州\"},{Item:\"西安\"},{Item:\"杭州\"}]}";
var speed = 300;
jq(document).ready(function() {
    jq("#k1").bind("focus", hc_StartFocus);
    jq("#k1").bind("blur", hideDiv);
    //jq("#k1").bind("keyup", hc_StartKeyUp);
    jq("#k2").bind("focus", hc_StartFocus);
    jq("#k2").bind("blur", hideDiv);
    //jq("#k2").bind("keyup", hc_StartKeyUp);
    jq("#zhan").bind("focus", hc_StartFocus);
    jq("#zhan").bind("blur", hideDiv);


    //jq("#zhan").bind("keyup", hc_StartKeyUp);

    jq("#jp_from").bind("focus", jp_StartFocus);
    jq("#jp_to").bind("focus", jp_StartFocus);
    jq("#jp_from").bind("blur", hideDiv);
    jq("#jp_to").bind("blur", hideDiv);
    jq("#jp_from").bind("keyup", jp_StartKeyUp);
    jq("#jp_to").bind("keyup", jp_StartKeyUp);

});  
 

var hc_StartFocus = function(event) {
    currentInput = event.target;
    jq(currentInput).css("color", "#000");
    if (jq(currentInput).val() == "") {
		$a=eval('(' + StationJson + ')').Station;
        initSmartDiv($a);
        ShowSmartSearch(event);
    } else {
        getStationList(jq(currentInput).val(), event);
    }
	 ShowSmartSearch(event);

};

var jp_StartFocus = function(event) {
    currentInput = event.target;
    jq(currentInput).css("color", "#000");
    if (jq(currentInput).val() == "") {
		$a=eval('(' + StationJson + ')').Station;
        initSmartDiv($a);
        ShowSmartSearch(event);
    } else {
        getJichangList(jq(currentInput).val(), event);
    }
	 ShowSmartSearch(event);

};



var jp_StartKeyUp = function(event) {
    var key = window.event ? event.keyCode : event.which;
    //currentInput = event.target;
    if (key != 40 && key != 38) {
        getJichangList(jq(event.target).val(), event);
    } else {
        if (key == 40) {
            Move(1);
        }
        if (key == 38) {
            Move(-1);
        }
    }
};

/*
var hc_StartKeyUp = function(event) {
    var key = window.event ? event.keyCode : event.which;
    //currentInput = event.target;
    if (key != 40 && key != 38) {
        getStationList(jq(event.target).val(), event);
    } else {
        if (key == 40) {
            Move(1);
        }
        if (key == 38) {
            Move(-1);
        }
    }
};
*/

var jp_EndKeyUp = function(event) {
    var key = window.event ? event.keyCode : event.which;
    //currentInput = event.target;
    if (key != 40 && key != 38) {
        getJichangList(jq(event.target).val(), event);
    } else {
        if (key == 40) {
            Move(1);
        }
        if (key == 38) {
            Move(-1);
        }
    }

};


var hideDiv = function() {
//        if (jq("#stationname").val().trim() == "") {
//            jq("#stationname").val("请输入站点名称");
//            jq("#stationname").css("color", "#ccc");
//        }

    jq("#divSmartList").hide();
};

var initSmartDiv = function(json) {
    var title = json.length > 0 ? "<div>用鼠标或↑↓选择</div>" : "<span>没有找到匹配项</span>";
    jq("#divSmartList").html(title);
    for (var i = 1; i <= json.length; i++) {
        var item = jq("<span></span>");
        item.bind("mousedown", { arg: "#item" + i }, ItemSelected);
        item.bind("mouseover", { arg: "#item" + i }, SetColorOver);
        item.bind("mouseout", { arg: "#item" + i }, SetColorOut);
        item.html(json[i - 1].Item);
        item.attr("id", "item" + i);
        item.attr("title", json[i - 1].Item);
        jq("#divSmartList").append(item);
    }
};

var ShowSmartSearch = function(event) {
    var offset = jq(event.target).offset();

    jq("#divSmartList").css({ top: offset.top + 5 + jq(event.target).height() + "px", left: offset.left });
    var smart_width = jq(event.target).width() + 8;
    if(smart_width < 110) smart_width = 110;    
    jq("#divSmartList").css({ width: smart_width + "px"});    
    jq("#divSmartList").show(speed);
    //jq("#divSmartList").css({ "z-index": 9999 });
};

var ItemSelected = function(arg) {
    if (jq(arg.data.arg).html())
        jq(currentInput).val(jq(arg.data.arg).html());
};


var SetColorOver = function(arg) {
    jq("#divSmartList span.current:eq(0)").removeClass();
    jq(arg.data.arg).addClass("current");
};

var SetColorOut = function(arg) {
    jq(arg.data.arg).removeClass();
}

var Move = function(len) {
    if (jq("#divSmartList").find("span").length < 1) return;
    var i = 0;
    var $item = jq("#divSmartList span.current:eq(0)");
    var obj = new Object();
    obj.data = new Object();
    if (jq("#divSmartList span").size() > 0) {
        if ($item.size() > 0) {
            $item.removeClass();
            if (len == 1 && $item.next("span")) {
                obj.data.arg = "#" + $item.next("span").attr("id");
            } else if (len == -1 && $item.prev("span")) {
                obj.data.arg = "#" + $item.prev("span").attr("id");
            }
        } else {
            obj.data.arg = "#" + jq("#divSmartList span:eq(0)").attr("id");
        }
        SetColorOver(obj);
        ItemSelected(obj);
    }
}


var getStationList = function(arg, target) {
    if (jq.trim(arg) != "") {
        jq.getJSON("/ajax.php", { op: "s_station","num":6, key: jq.trim(arg) }, function(json) {
            initSmartDiv(json.Station);
            ShowSmartSearch(target);
        });
    }
};

var getJichangList = function(arg, target) {
    if (jq.trim(arg) != "") {
        jq.getJSON("/ajax.php", { op: "s_jichang","num":6, key: jq.trim(arg) }, function(json) {
            initSmartDiv(json.Station);
            ShowSmartSearch(target);
        });
    }
};


//删除字符串两端的空格
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
//var TrainJson = "{\"Train\":[{Item:\"T1\"},{Item:\"D3\"},{Item:\"Z4\"},{Item:\"D98\"},{Item:\"C2001\"},{Item:\"Y563\"}]}";

function changeType(type){
	if (type==2)
	{
		$('comeBack').style.display='inline';
		date = $('date').value;
		var date = date.replace(new RegExp("-", 'g'), "/");
		var   d   = new Date(date); 
        var   n   =   2; 
        d.setDate(d.getDate()+n);
		if (d.getMonth()+1<10)
		{
			var month = '0'+(d.getMonth()+1);
		}else{
			var month = (d.getMonth()+1);
		}
		if (d.getDate()+1<10)
		{
			var day = '0'+(d.getDate()+1);
		}else{
			var day = (d.getDate()+1);
		}
		$('backdate').value=(d.getFullYear())+"-"+month+"-"+day+"";

	}else{
		$('comeBack').style.display='none'
	}
}

function getposition(obj) {
    var r = new Array();
    r['x'] = obj.offsetLeft;
    r['y'] = obj.offsetTop;
    while(obj = obj.offsetParent) 
    {
        r['x'] += obj.offsetLeft;
        r['y'] += obj.offsetTop;
    }
    return r;
}

function _(_) {
	document.write(_);
}

function hide_city(stype) {
	document.getElementById(stype).style.display = 'none';
}
function tanchu(anchor,id,stype) {
	var position = getposition(document.getElementById(anchor));
	var tc = document.getElementById(stype);
	var as = tc.getElementsByTagName("a");
	/*
	alert(123); 

	jQuery(document).ready(function() {
		jQuery(document).bind("click",function(event){
			if(jQuery(event.target).attr("id")!=anchor && jQuery(event.target).attr("id")!=stype){
				hide_city(stype);
			}
		});
	}); 

	*/

	for(var i=0; i<as.length; i++)
	{
		as[i].onclick = function()
		{
			var a = i;
			return function()
			{
				jQuery.ajax({cache:false});
				document.getElementById(id).value = as[a].innerHTML;
                //document.getElementById(id).value =1;
				if(stype=='tanchuzz')
				{
				if(jQuery("#k1").val()!='' && jQuery("#k2").val()!='')
				  {
jQuery.getJSON("newajaxzz.php",{k1:jQuery("#k1").val(),k2:jQuery("#k2").val()},function(msg)
					{
					   //alert(msg['tn'].totalnum);
					   var str="<a href=http://lieche.huoche.com/zz-"+msg['other'].city1 +"-"+msg['other'].city2+"/ class='a2'>"+msg['tn'].station1+"到"+msg['tn'].station2+"共"+msg['tn'].totalnum+"次列车</a>";
					   jQuery("#ajaxcontent").html(str);
					   var alieche='';
					   if(msg['dc'].di!=0)
					   {
					    alieche+= " <p><strong>D-动车组:</strong> 共"+msg['dc'].di+"次 上午"+msg['dc'].dcs+"次 下午"+msg['dc'].dcx+"次 晚上"+msg['dc'].dcw+"次</p>";
					   }
					   if(msg['tk'].tk!=0)
					   {
					    alieche+=" <p><strong>T-空调特快:</strong> 共"+msg['tk'].tk+"次 上午"+msg['tk'].tks+"次 下午"+msg['tk'].tkx+"次 晚上"+msg['tk'].tkw+"次</p>";
					   }
					   if(msg['ks'].ks!=0)
					   {
					    alieche+=" <p><strong>K-空调快速:</strong> 共"+msg['ks'].ks+"次 上午"+msg['ks'].kss+"次 下午"+msg['ks'].ksx+"次 晚上"+msg['ks'].ksw+"次</p>";
					   }
					   if(msg['zk'].zktid!='')
					   {
					    alieche+=" <p><strong>最快车次:</strong><a href=http://lieche.huoche.com/c"+msg['zk'].zktid+" >"+msg['zk'].tname+"</a> 运行时间"+msg['zk'].tall+"";
					   }
					   if(msg['zp'].zptid!='')
					   {
					    alieche+="<p><strong>最便宜车次:</strong><a href=http://lieche.huoche.com/c"+msg['zp'].zptid+" >"+msg['zp'].trainname+"</a>票价"+msg['zp'].price+"元";
					   }
					   jQuery("#ajaxlieche").html(alieche);
					   var str2='<a href="http://www.huoche.com/dingpiao/chengshi/'+msg['other'].city1+' " target=_blank>'+msg['tn'].station1+'火车票售票点</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=http://www.huoche.com/piao/z'+msg['other'].cid1+'z'+msg['other'].cid2+' target=_blank >转让票信息</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://hotel.huoche.com/list-'+msg['other'].hotelid+' target=_blank>'+msg['tn'].station2+'酒店</a>'
					  jQuery("#ajaxlieche2").html(str2); 
					}
					);
				  }
				}
				else if(stype=='tanchucheci')
				{
				   if(jQuery("#checi").val()!='')
				   {
				jQuery.getJSON("ajaxcheci.php",{k:jQuery("#checi").val()},function(msg)
					{
				var str='<a href="http://lieche.huoche.com/c'+msg.tid+'" class="a2">'+msg.tname+'</a>('+msg.bstation+'-'+msg.estation+')车次信息';
				 jQuery("#ajaxcontent").html(str);
				 var alieche=''; 
				  alieche+= '<p><strong>车型:</strong> '+msg.ttype+' </p>';
				  alieche+='<p><strong>发-到站时间:</strong>'+msg.btime+'-'+msg.etime+'('+msg.atime+') </p>';
				  alieche+=' <p><strong>总站数:</strong> '+msg.totalstation+'站 </p>';
				  alieche+='<p><strong>总里程:</strong>'+msg.distance+'公里</p>';
				  if(msg.price!=null)
				  {
				  alieche+='<p><strong>票价:</strong> 硬座 '+msg.price+'元 </p>';
				  }
				  jQuery("#ajaxlieche").html(alieche);
				  var str2='';
				  jQuery("#ajaxlieche2").html(str2);
					}
					);
				   }
				}
				else if(stype='tanchuzhan')
				{
				  jQuery.getJSON("ajaxzhan.php",{k:jQuery("#zhan").val()},function(msg)
					{
						  var str="<a href=http://lieche.huoche.com/hcz.php?zhan="+msg['city'].station+" class='a2'>"+msg['city'].station+"共"+msg['city'].totalnum+"次列车</a>";
						  jQuery("#ajaxcontent").html(str);
						  var azhan='';
						  /*if(msg['cj'].cj!=0)
						   {
							azhan+= " <p><strong>C-城际高速:</strong> 共"+msg['cj'].cj+"次 上午"+msg['cj'].cjs+"次 下午"+msg['cj'].cjx+"次 晚上"+msg['cj'].cjw+"次</p>";
						   }*/
						  if(msg['di'].di!=0)
						   {
							azhan+= " <p><strong>D-动车组:</strong> 共"+msg['di'].di+"次 上午"+msg['di'].dcs+"次 下午"+msg['di'].dcx+"次 晚上"+msg['di'].dcw+"次</p>";
						   }
						   if(msg['tk'].tk!=0)
						   {
							azhan+=" <p><strong>T-空调特快:</strong> 共"+msg['tk'].tk+"次 上午"+msg['tk'].tks+"次 下午"+msg['tk'].tkx+"次 晚上"+msg['tk'].tkw+"次</p>";
						   }
						   if(msg['ks'].ks!=0)
						   {
							azhan+=" <p><strong>K-空调快速:</strong> 共"+msg['ks'].ks+"次 上午"+msg['ks'].kss+"次 下午"+msg['ks'].ksx+"次 晚上"+msg['ks'].ksw+"次</p>";
						   }
						   if(msg['zd'].zktid!='')
						   {
							azhan+=" <p><strong>K-空调快速:</strong> 共"+msg['zd'].zd+"次 上午"+msg['zd'].zds+"次 下午"+msg['zd'].zdx+"次 晚上"+msg['zd'].zdw+"次</p>";
						   }					   
						   jQuery("#ajaxlieche").html(azhan);
						   var str2='<a href="http://www.huoche.com/dingpiao/chengshi/'+msg['city'].pinyin+' " target=_blank>'+msg['city'].station+'火车票售票点</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=hhttp://www.huoche.com/piao/'+msg['city'].pinyin+'/ target=_blank >转让票信息</a>&nbsp;&nbsp;&nbsp;&nbsp;';
					  jQuery("#ajaxlieche2").html(str2);
					}
					);	
				}
				hide_city(stype);
			}
		}(i);
	}
		tc.style.left = parseInt(position['x'] - 160) + 'px';
		tc.style.top = parseInt(position['y'] + 27) + 'px';	
	    tc.style.display = '';
}

function setTab(m,n){
	var tli=document.getElementById("menu"+m).getElementsByTagName("li");
	var mli=document.getElementById("main"+m).getElementsByTagName("ul");
	for(i=0;i<mli.length;i++){
   		tli[i].className=i==n?"mover":"mout";
  	 	 mli[i].style.display=i==n?"block":"none";
	}
}

function kx_changeAirType(obj){
	if(obj.checked==true){
		$('kx_redate').style.display="block";
		$('kx_redate1').style.display="none";
	}else{
		$('kx_redate').style.display="none";
		$('kx_redate1').style.display="block";
	}
}


//输出主要城市列表
document.write('<div id="tanchuzz" style="display: none;">');
document.write('<div class="tc_content"><h6><span class="close" onClick="hide_city(\'tanchuzz\');"></span>热门城市(可直接输入城市或城市拼音)</h6><ul class="tc_ul"><li><a href="#">北京</a></li><li><a href="#">上海</a></li><li><a href="#">广州</a></li><li><a href="#">深圳</a></li><li><a href="#">成都</a></li><li><a href="#">重庆</a></li><li><a href="#">西安</a></li><li><a href="#">杭州</a></li><li><a href="#">南京</a></li><li><a href="#">沈阳</a></li><li><a href="#">天津</a></li><li><a href="#">武汉</a></li><li><a href="#">大连</a></li><li><a href="#">青岛</a></li><li><a href="#">长沙</a></li><li><a href="#">昆明</a></li><li><a href="#">长春</a></li><li><a href="#">郑州</a></li><li><a href="#">海口</a></li><li><a href="#">合肥</a></li><li><a href="#">济南</a></li><li><a href="#">厦门</a></li><li><a href="#">福州</a></li><li><a href="#">哈尔滨</a></li><li><a href="#">乌鲁木齐</a></li></ul></div></div>');
document.write('<div id="tanchucheci" style="display: none;">');
document.write('<div class="tc_content"><h6><span class="close" onClick="hide_city(\'tanchucheci\');"></span>热门车次</h6><ul class="tc_ul"><li><a href="#">T7</a></li><li><a href="#">T9</a></li><li><a href="#">T17</a></li><li><a href="#">T5</a></li><li><a href="#">D76/D77</a></li><li><a href="#">D1</a></li><li><a href="#">T61</a></li><li><a href="#">K56/K57</a></li></li><li><a href="#">K339</a></li><li><a href="#">T211</a></li></ul></div></div>');
document.write('<div id="tanchuzhan" style="display: none;">');
document.write('<div class="tc_content"><h6><span class="close" onClick="hide_city(\'tanchuzhan\');"></span>热门城市(可直接输入城市或城市拼音)</h6><ul class="tc_ul"><li><a href="#">北京</a></li><li><a href="#">上海</a></li><li><a href="#">广州</a></li><li><a href="#">深圳</a></li><li><a href="#">成都</a></li><li><a href="#">重庆</a></li><li><a href="#">西安</a></li><li><a href="#">杭州</a></li><li><a href="#">南京</a></li><li><a href="#">沈阳</a></li><li><a href="#">天津</a></li><li><a href="#">武汉</a></li><li><a href="#">大连</a></li><li><a href="#">青岛</a></li><li><a href="#">长沙</a></li><li><a href="#">昆明</a></li><li><a href="#">长春</a></li><li><a href="#">郑州</a></li><li><a href="#">海口</a></li><li><a href="#">合肥</a></li><li><a href="#">济南</a></li><li><a href="#">厦门</a></li><li><a href="#">福州</a></li><li><a href="#">哈尔滨</a></li><li><a href="#">乌鲁木齐</a></li></ul></div></div>');


