/*from tccdn minify at 2013-12-23 14:01:52,file：/cn/c/s/2013/searchFlight.0.0.4.js?v=2013112806*/
fish.admin.config({mLogin:{v:0.5,css:1,g:13092401}});fish.ready(function(){fish.require("flightSearch",function(){flightSearchBox=fish.flightSearch({leaveCityElem:"#leaveCityDiv",arriveCityElem:"#arriveCityDiv",transitCityElem:"#transitCityDiv",leaveTimeElem:"#leaveTimeDiv",transitTimeElem:"#transitTimeDiv",backTimeElem:"#backTimeDiv",changCity:"#changeFlightSearchCity",submitElem:"#airplaneSubmit",searchElem:"#searchExclusive",contentElem:"#tab_top_airplane",searchSubmitUrl:fish.one("#tab_top_airplane").attr("data-submit-url"),searchDataUrl:fish.one("#tab_top_airplane").attr("data-citydata-url"),historyElem:"#tab_top_airplane .historyBox",oneWayElem:"#airplaneRadio1",returnWayElem:"#airplaneRadio2",connectWayElem:"#airplaneRadio3"})})});(function(){var u,b,E,w,G,d,q,t,a,D,v,F,c,f,B,A,j,C,g,y,z,i,e=false,r=4,k="fSearchHis",l="AIRPLANECITYNAME",h=1,m="";var o={searchType:1,ontypechange:function(H){},onsubmitsuccess:function(H){}};function x(H){var Q=[],J=null,I=fish.all("input, select",H);for(var K=0,M=I.length;K<M;K++){J=I[K];if(J.name===""){continue}switch(J.type){case"select-multiple":for(var L=0,O=J.options.length;L<O;L++){var N=J.options[L];if(N.selected){var P="";if(N.hasAttribute){P=(N.hasAttribute("value")?N.value:N.text)}else{P=(N.attributes.value.specified?N.value:N.text)}Q.push(encodeURIComponent(J.name)+"="+encodeURIComponent(P))}}break;case"radio":if(J.checked){Q.push(encodeURIComponent(J.name)+"="+encodeURIComponent(J.value))}break;case"button":break;case"checkbox":if(J.checked){Q.push(encodeURIComponent(J.name)+"="+encodeURIComponent(J.value))}break;default:Q.push(encodeURIComponent(J.name)+"="+encodeURIComponent(J.value))}}return Q.join("&")}function p(K){var I=document.createElement("div"),H=[];fish.all(I).html(K);for(var J=0;J<I.childNodes.length;J++){if(I.childNodes[J].nodeType===1){H.push(I.childNodes[J])}}I=null;return fish.all(H)}function n(K){var H=fish.all(K.elem);if(!H[0]){return}var I={template:'<div class="hotel-warn none" style="position:absolute"><span class="arrow"></span><span class="info">{{=it.tips}}</span></div>',related:"",holder:fish.all("input",H).attr("holder"),nullTips:fish.all("input",H).attr("nulltips"),elem:null};var J=fish.lang.proto(searchInputFn);fish.lang.extend(I,K);fish.lang.extend(J,I);J.__input=fish.all("input",fish.dom(J.elem));J.__elem=H;J.__input.hover(function(){},function(){if(J.__input.attr("focusnow")!=="true"){}});J.__input.on("focus",function(){this.setAttribute("focusnow","true");J.hideWarn();fish.one(this).css("color:#333")}).on("blur",function(){this.setAttribute("focusnow","false");this.value=fish.trim(this.value);if(this.value===""){this.value=J.holder;fish.one(this).css("color:#999")}else{if(this.value.length>0&&this.value!==J.holder){fish.one(this).css("color:#333")}}}).on("click",function(){this.value=fish.trim(this.value);this.select()}).on("keyup",function(M){var L=fish.getEvent(M);if(L.keyCode){code=L.keyCode}else{if(L.which){code=L.which}}if(code==13){fish.preventDefault(L)}fish.one(this).css("color:#333")});fish.one("body").on("resize",function(){J.resetPosition()});return J}searchInputFn={getInputTopLeft:function(){return this.__input.offset()},getInputWidth:function(){return this.__input.width()},getInputHeight:function(){return this.__input.height()},getInputValue:function(){return this.__input.val()},setInputValue:function(H){this.__input.val(H)},hide:function(){this.__elem.css("display:none")},show:function(){this.__elem.css("display:block")},warn:function(H){if(!this.warnElem){this.warnElem=p(fish.template(this.template,{tips:H}));fish.one("body").html("top",this.warnElem);this.warnElem.effect({elem:fish.all(this.related),interShow:false})}else{fish.one(".info",this.warnElem).html(H)}this.warnElem.css("display:block");this.resetPosition()},hideWarn:function(){this.warnElem&&this.warnElem.css("display:none")},checkNull:function(){var H=this.getInputValue();H=fish.trim(H);this.setInputValue(H);if(H===""||H===this.holder){this.warn(this.nullTips);return false}else{this.hideWarn();return true}},resetPosition:function(){if(this.warnElem){var I=this.getInputTopLeft(),L=this.getInputWidth(),H=this.getInputHeight(),J=I.left+L+5,K=I.top+parseInt(H/2,10)-13;this.warnElem.css("left:"+J+"px;top:"+K+"px")}}};function s(){var M=fish.one(f);M.on("click",function(){var aD=t.getInputValue(),aC=a.getInputValue();t.setInputValue(aC);a.setInputValue(aD)}).hover(function(){fish.one(this).addClass("changeHover")},function(){fish.one(this).removeClass("changeHover")});function aw(){M.css("display:block")}function ab(){M.css("display:none")}var K=fish.all((y?y:"")+(z?","+z:"")+(i?","+i:"")).on("click",function(){at();e=true});o.changeSearchType=function(aE,aC){var aD;if(aE=="1"){aD=fish.dom(y)}else{if(aE=="2"){aD=fish.dom(z)}else{if(aE=="3"){aD=fish.dom(i)}}}if(aD){aD.checked="checked"}at();aC&&aC()};function at(){var aC=1;if(y?fish.dom(y).checked:""){aC=1;D&&D.hide();F&&F.hide();c&&c.hide();aw();if(fish.one("#tab_top_airplane .historyBox").html().length>0){fish.one("#tab_top_airplane .historyBox").removeClass("none")}}else{if(z?fish.dom(z).checked:""){aC=2;D&&D.hide();F&&F.hide();c&&c.show();if(c){c.cal=c.__input.mCal({startTime:fish.parseTime(v.__input.val())})}aw();if(fish.one("#tab_top_airplane .historyBox").html().length>0){fish.one("#tab_top_airplane .historyBox").removeClass("none")}}else{if(i?fish.dom(i).checked:""){aC=3;D&&D.show();F&&F.show();c&&c.hide();if(F){F.cal=F.__input.mCal({startTime:fish.parseTime(v.__input.val()),fn:function(aD){fish.one("#airTransWeek").html(getWeekCommon(aD))}})}ab();fish.one("#txtAirplaneTime3").val(fish.parseTime(fish.one("#txtAirplaneTime1").val(),{days:1}));fish.one("#airTransWeek").html(getWeekCommon(fish.one("#txtAirplaneTime3").val()));fish.one("#tab_top_airplane .historyBox").addClass("none")}}}o.searchType=aC;return aC}var L=location.hostname.indexOf(".17u.cn")>-1?".17u.cn":location.hostname;o.getSearchHistory=function(aC){var aE,aF,aD;if(aC){aD=aC}else{aE=fish.cookie.get(k);aF=fish.cookie.get(l);aE=aE?aE:"";aE=aE==="undefined"?"":aE;aF=aF?aF:"";aF=aF==="undefined"?"":aF;aD=aF?(aF+","+aE):aE}var aI=aD.split(","),aJ,aH=[];for(var aG=0;aG<aI.length;aG++){if(aI[aG]){aJ=aI[aG].split("$");aH.push({leaveCity:aJ[0],arriveCity:aJ[1],transitCity:aJ[2],type:aJ[3],leaveTime:aJ[4],backTime:aJ[5],transitTime:aJ[6]})}}return aH};function aj(aD){var aE=[];for(var aC=0;aC<aD.length;aC++){aE[aC]=[aD[aC].leaveCity,aD[aC].arriveCity,aD[aC].transitCity,aD[aC].type,aD[aC].leaveTime,aD[aC].backTime,aD[aC].transitTime].join("$")}return aE.join(",")}function aB(aC){aC=fish.trim(aC);if(aC==="时间/日期"||aC==="城市名"){aC=""}return aC}function V(){W(t.getInputValue(),a.getInputValue(),D.getInputValue(),o.searchType,v.getInputValue(),c.getInputValue(),F.getInputValue())}function W(aI,aC,aP,aR,aJ,aD,aQ){var aE=[aB(aI),aB(aC),aB(aP),aR,aB(aJ),aB(aD),aB(aQ)].join("$");var aG=fish.cookie.get(k),aH=fish.cookie.get(l),aF,aM,aN,aK,aL,aO;aG=aG?aG:"";aG=aG==="undefined"?"":aG;aH=aH?aH:"";aH=aH==="undefined"?"":aH;if(!aH.split("$")[0]){aH=""}aF=aH?aH+","+aG:aG;if(aF.indexOf(aE)!==0||aF===""){aF=aE+","+aF;aO=o.getSearchHistory(aF);if(aO.length>r){aO.pop()}aL=aO.shift();fish.cookie.set({name:l,value:encodeURIComponent(aj([aL])),days:7,path:"/",domain:L});fish.cookie.set({name:k,value:encodeURIComponent(aj(aO)),days:7,path:"/",domain:L})}}var ac=fish.one(q),ad=ac.attr("historynum")?ac.attr("historynum"):3;historyTemplate='<div class="historyText clearfix">{{?it.type == 1}}单程：{{??it.type == 2}}往返：{{??it.type == 3}}联程：{{?}}<a class="historyA" h_leave="{{=it.leaveCity}}" h_arrive="{{=it.arriveCity}}" h_transit="{{=it.transitCity}}" h_leavetime="{{=it.leaveTime}}" h_backtime="{{=it.backTime}}" h_transittime="{{=it.transitTime}}"  h_type="{{=it.type}}" title="{{=it.leaveCity}}到{{=it.arriveCity}} {{=it.leaveTime}} 出发" href="javascript:;">{{=it.leaveCity}}{{?it.type == 2}}<span class="arrowBoth">&nbsp;&nbsp;&nbsp;</span>{{??}}→{{?}}{{?it.type == 3}}{{=it.transitCity}}→{{?}}{{=it.arriveCity}}</a></div>';function au(){var aE=o.getSearchHistory(),aH,aF,aG,aJ=fish.parseTime(),aC="";aH=aE.shift();aF=aE;if(aH){aH.leaveCity&&t&&t.setInputValue(aH.leaveCity);aH.arriveCity&&a&&a.setInputValue(aH.arriveCity);aH.transitCity&&D&&D.setInputValue(aH.transitCity);(aH.leaveTime=aH.leaveTime<aJ?aJ:aH.leaveTime)&&v&&v.setInputValue(aH.leaveTime);(aH.backTime=aH.backTime<aJ?aJ:aH.backTime)&&c&&c.setInputValue(aH.backTime);(aH.transitTime=aH.transitTime<aJ?aJ:aH.transitTime)&&F&&F.setInputValue(aH.transitTime);if(!e){o.changeSearchType(aH.type)}}if(aF&&aF.length&&fish.dom(ac)){var aD=ad?ad:aF.length;for(var aI=0;aI<aD;aI++){aG=aF[aI];if(aG){aC+=fish.template(historyTemplate,aG)}}ac.html(aC);fish.all(".historyA",ac).on("click",function(){var aK=fish.one(this),aN=aK.attr("h_leave"),aL=aK.attr("h_arrive"),aQ=aK.attr("h_transit"),aO=aK.attr("h_leavetime"),aM=aK.attr("h_backtime"),aP=aK.attr("h_tarnsittime"),aR=aK.attr("h_type");aO=aO<aJ?aJ:aO;aM=aM<aJ?aJ:aM;aP=aP<aJ?aJ:aP;t.setInputValue(aN);a.setInputValue(aL);D.setInputValue(aQ);v.setInputValue(aO);c.setInputValue(aM);F.setInputValue(aP);o.changeSearchType(aR,function(){o.submit()})}).hover(function(){fish.all(".arrowBoth",this).addClass("arrowBothHover")},function(){fish.all(".arrowBoth",this).removeClass("arrowBothHover")});fish.all(ac).removeClass("none")}}function ay(){var aI=true;switch(o.searchType){case 1:var aE=t.getInputValue(),aC=a.getInputValue(),aF=v.getInputValue();if(!t.checkNull()){t.notice&&t.notice.show();aI=false}else{if(!a.checkNull()){a.notice&&a.notice.show();aI=false}else{if(!v.checkNull()){v.cal&&v.cal.show();aI=false}}}if(aI&&(aE===aC)){t.warn("出发城市不能和到达城市相同");aI=false}if(aI&&N(aE)!==true){t.warn(N(aE));t.notice&&t.notice.show();aI=false}else{if(aI&&N(aC)!==true){a.warn(N(aC));a.notice&&a.notice.show();aI=false}}if(aI&&h==1){J();V()}else{if(aI&&h==2){if(loginState&&loginState.state==100){J(true)}else{ak.show=true;ak.onLogin=function(){var aJ=fish.cookie.get("searchSteps");fish.cookie.set({name:"searchSteps",value:"3",domain:".17u.cn",path:"/"});fish.cookie.set({name:"FlightVIP",value:"2",domain:".17u.cn",path:"/"});J(true)};ak.showSearch=true;ak.onSearch=function(){var aJ=fish.cookie.get("searchSteps");fish.cookie.set({name:"searchSteps",value:"4",domain:".17u.cn",path:"/"});setTimeout(function(){J()},0)};ak.open()}}}break;case 2:var aE=t.getInputValue(),aC=a.getInputValue(),aF=v.getInputValue(),aD=c.getInputValue();if(!t.checkNull()){t.notice&&t.notice.show();aI=false}else{if(!a.checkNull()){a.notice&&a.notice.show();aI=false}else{if(!v.checkNull()){v.cal&&v.cal.show();aI=false}else{if(!c.checkNull()){c.cal&&c.cal.show();aI=false}}}}if(aI&&(aE===aC)){t.warn("出发城市不能和到达城市相同");aI=false}if(aI&&N(aE)!==true){t.warn(N(aE));t.notice&&t.notice.show();aI=false}else{if(aI&&N(aC)!==true){a.warn(N(aC));a.notice&&a.notice.show();aI=false}}if(aI&&aD<aF){c.warn("返回日期不能早于出发日期");aI=false}if(aI&&h==1){J();V()}else{if(aI&&h==2){if(loginState&&loginState.state==100){J(true)}else{ak.show=true;ak.onLogin=function(){fish.cookie.set({name:"searchSteps",value:"3",domain:".17u.cn",path:"/"});fish.cookie.set({name:"FlightVIP",value:"2",domain:".17u.cn",path:"/"});J(true)};ak.showSearch=true;ak.onSearch=function(){fish.cookie.set({name:"searchSteps",value:"4",domain:".17u.cn",path:"/"});setTimeout(function(){J()},0)};ak.onClose=function(){fish.one("#flightMarketFlash").removeClass("none")};ak.open()}}}break;case 3:var aE=t.getInputValue(),aC=a.getInputValue(),aG=D.getInputValue(),aF=v.getInputValue(),aH=F.getInputValue();if(!t.checkNull()){t.notice&&t.notice.show();aI=false}else{if(!a.checkNull()){a.notice&&a.notice.show();aI=false}else{if(!D.checkNull()){D.notice&&D.notice.show();aI=false}else{if(!v.checkNull()){v.cal&&v.cal.show();aI=false}else{if(!F.checkNull()){F.cal&&F.cal.show();aI=false}}}}}if(aI&&(aE===aG)){t.warn("出发城市不能和中转城市相同");aI=false}if(aI&&(aG===aC)){D.warn("中转城市不能和到达城市相同");aI=false}if(aI&&N(aE)!==true){t.warn(N(aE));t.notice&&t.notice.show();aI=false}else{if(aI&&N(aC)!==true){a.warn(N(aC));a.notice&&a.notice.show();aI=false}else{if(aI&&N(aG)!==true){D.warn(N(aG));D.notice&&D.notice.show();aI=false}}}if(aI&&aH<aF){F.warn("中转日期不能早于出发日期");aI=false}if(aI&&h==1){J()}else{if(aI&&h==2){if(loginState&&loginState.state==100){J(true)}else{ak.show=true;ak.onLogin=function(){fish.cookie.set({name:"searchSteps",value:"3",domain:".17u.cn",path:"/"});fish.cookie.set({name:"FlightVIP",value:"2",domain:".17u.cn",path:"/"});J(true)};ak.showSearch=true;ak.onSearch=function(){fish.cookie.set({name:"searchSteps",value:"4",domain:".17u.cn",path:"/"});setTimeout(function(){J()},0)};ak.open()}}}break}}var aA;function J(aC){if(aA){try{aA.abort()}catch(aD){}}var aE=(aC?"&userId="+fish.cookie.get("cnUser","userid"):"");aA=fish.ajax({url:C,data:x(fish.dom(j))+aE,type:"jsonp",fn:H});V()}function H(aC){aA=null;if(aC&&aC.state===100){if(o.onsubmitsuccess(aC)!==false){window.location.href=aC.href}}}var ak;fish.mLogin({title:"会员专属产品搜索",showParter:true,showSignup:true},function(aC){ak=aC});function N(aC){if(I){if(!al[aC]){return'找不到"'+aC+'"相关信息'}else{if(al[aC]&&!al[aC].code){return"该城市无机场信息"}else{return true}}}else{return true}}var Q=[];var O;function Y(){fish.ajax({url:g,type:"jsonp",fn:P})}function P(aC){if(aC){I=aC;al=X(aC).citys;ae=Z(aC);ar=aa(aC);am={tab:["热门","ABCDEF","GHJKL","MNPQRS","TWXYZ"],data:{"热门":ae}};fish.lang.extend(am.data,ar);var aD=Q.length;while(aD--){Q[aD]&&Q[aD](I,al,am)}}}function R(aC){if(aC){if(I){aC(I,al,am)}else{Q.push(aC)}}}function U(aE){var aC=[],aD;for(aD in aE){aE[aD].name=aD;aC[aC.length]=aE[aD]}fish.lang.extend(aC,aE);return aC}function T(aE){var aC=[],aD;for(aD in aE){aC[aC.length]=aD}fish.lang.extend(aC,aE);return aC}var I,al,ae,ar,am;function X(aD){var aC,aE;aD.citys=U(aD.citys);aC=aD.citys;aE=aC.length;while(aE--){aC[aE].match=T(aC[aE].match);aC[aE].match.push(aC[aE].name);aC[aE].match[aC[aE].name]=255}return aD}function Z(aE){var aC=[],aG=[],aD=aE.citys,aF=aD.length;while(aF--){if(aD[aF].hot>1){aC[aC.length]={name:aD[aF].name,hot:aD[aF].hot}}}aC.sort(function(aH,aI){return aI.hot-aH.hot});if(aC.length){for(var aF=0;aF<25;aF++){aG.push(aC[aF].name)}}ae=aG;return aG}function aa(aE){var aI={},aC="ABCDEFGHIJKLMNOPQRSTUVWXYZ",aH={},aD=aE.citys,aG,aF;aC.split("").forEach(function(aJ){aH[aJ]=[];aI[aJ]=[]});aG=aD.length;while(aG--){if(aD[aG].hot>1){aF=aD[aG].quanpin.charAt(0).toUpperCase();aH[aF].push(aD[aG])}}for(aF in aH){aH[aF].sort(function(aJ,aK){return aK.hot-aJ.hot})}for(aF in aH){aH[aF].forEach(function(aJ){aI[aF].push(aJ.name)})}return aI}u&&(t=n({elem:u,related:(B+","+A)}));E&&(D=n({elem:E,related:(B+","+A)}));b&&(a=n({elem:b,related:(B+","+A)}));w&&(v=n({elem:w,related:(B+","+A)}));d&&(c=n({elem:d,related:(B+","+A)}));G&&(F=n({elem:G,related:(B+","+A)}));function an(aD,aR){var aF=[],aQ=[],aP=aD.tab,aE=aD.data[aD.tab[0]],aC=aD.data,aH,aL,aK,aO,aG,aI,aJ,aN,aM;aI=0;while(aH=aP[aI++]){aQ.push('<li class="mNotice-mTab-item '+(aI===1?"current":"")+'">'+aH+"</li>")}aR=aR.replace("{tab}",aQ.join(""));aG=0;aF.push('<div class="mNotice-mTab-content clearfix">');while(aH=aE[aG++]){aF.push('<span class="mNotice-normal mNotice-fixWidth" title="'+aH+'">'+aH+"</span>")}aF.push("</div>");aJ=1;while(aH=aP[aJ++]){aK=aH.split("");aF.push('<div class="mNotice-mTab-content none">');aN=0;while(aO=aK[aN++]){aF.push('<dl class="clearfix mNotice-block"><dt class="mNotice-title">'+aO+'</dt><dd class="mNotice-def">');aM=0;while(aL=aC[aO][aM++]){aF.push('<span class="mNotice-normal mNotice-fixWidth" title="'+aL+'">'+aL+"</span>")}aF.push("</dd></dl>")}aF.push("</div>")}return aR.replace("{contents}",aF.join(""))}var ao='<div class="mNotice-mTab"><h4 class="mNotice-mTab-head">热门城市<span class="mNotice-mTab-head-remark">（可直接选择城市或输入城市中文/拼音）</span><span class="mNotice-close white"></span></h4><div class="mNotice-mTab-wrap"><ul class="mNotice-mTab-tab-tray clearfix">{tab}</ul>{contents}</div></div>';function aq(aF,aK){var aH=aF.length,aI,aJ,aC,aD,aE;while(aH--){if(aF[aH]){if(!aF[aH].code&&(aJ=aF[aH].near)){for(aI in aJ){if(this.localData[aI]){aF.splice(aH+1,0,{name:aI,distance:aJ[aI]})}}}if(aD=aF[aH].ReverseGuide){for(var aG=0;aG<aD.length;aG++){aC=this.localData[aD[aG]];if(aC){aE=aD[aG];aF.forEach(function(aM,aL){if(aM&&(aM.name===aE)){aF[aL]=null}});aF.splice(aH+1,0,{name:aC.name,quanpin:aC.quanpin,reverse:true})}}aF.splice(aH+1,0,{tips:aK})}}}aH=aF.length;while(aH--){if(!aF[aH]){aF.splice(aH,1)}}}function ap(aC,aD,aE){aC._keyPriority=aC.match[aD];aC._matchPriority=aE;if(aC.code){aC._typePriority=3}else{if(aC.near){aC._typePriority=2}else{aC._typePriority=1}}}function ax(aC,aD){if((aC._typePriority>aD._typePriority)||(aC._typePriority===aD._typePriority&&aC._matchPriority<aD._matchPriority)||(aC._typePriority===aD._typePriority&&aC._matchPriority===aD._matchPriority&&aC.priority>aD.priority)||(aC._typePriority===aD._typePriority&&aC.priority===aD.priority&&aC._matchPriority===aD._matchPriority&&aC._keyPriority>aD._keyPriority)){return -1}else{return 1}}function ai(aC){return aC.name}function ah(aC){var aD;if(aC.reverse){aD="<div class='match_div match_gray_bg'><span class='match_right'>"+aC.quanpin+"</span><span class='match_icon match_left'>"+aC.name+"</span></div>"}else{if(aC.distance){aD="<div class='match_div match_gray_bg'><span class='match_icon'>邻近机场："+aC.name+"-"+aC.distance+"公里</span></div>"}else{if(aC.tips){aD="<div class='match_div match_gray_bg'><span class='match_tips match_gray'>"+aC.tips+"</span></div>"}else{if(!!aC.code){aD="<div class='match_div'><span class='match_right'>"+aC.quanpin+"</span><span class='match_left'>"+aC.name+"</span></div>"}else{if(!aC.code&&aC.near){aD="<div class='match_div match_gray_bg'><span class='match_right gray'>"+aC.quanpin+"</span><span class='match_left match_gray '>"+aC.name+" - 无机场</span></div>"}}}}}return aD}function af(aC){return aC.code||aC.distance||aC.reverse}function ag(aC){return aC.code&&!aC._reverse}fish.require("mNotice mCal autoComplete mTab",function(){R(function(aC,aD,aE){t&&(t.notice=t.__input.mNotice({localData:aE,isClick:true,isHover:true,template:ao,mode:"mTab",display:an,clickCallback:function(){t.__input.css("color:#333")}}));D&&(D.notice=D.__input.mNotice({localData:aE,isClick:true,isHover:true,template:ao,mode:"mTab",display:an,clickCallback:function(){D.__input.css("color:#333")}}));a&&(a.notice=a.__input.mNotice({localData:aE,isClick:true,isHover:true,template:ao,mode:"mTab",display:an,clickCallback:function(){a.__input.css("color:#333")}}));t&&(t.autoComplete=t.__input.autoComplete({title:"输入中文/拼音/↑↓键选择",placeholder:"城市名",localData:aD,highlight:true,keepListOnNoResult:true,width:220,max:10,processPrintDataFn:function(aF){aq.call(this,aF,"更精确出发地")},preSortFn:ap,sortFn:ax,itemValueFn:ai,itemPrintFn:ah,itemHighlightFn:ag,itemEnableFn:af}));D&&(D.autoComplete=D.__input.autoComplete({title:"输入中文/拼音/↑↓键选择",placeholder:"城市名",localData:aD,highlight:true,keepListOnNoResult:true,width:220,max:10,processPrintDataFn:function(aF){aq.call(this,aF,"更精确中转地")},preSortFn:ap,sortFn:ax,itemValueFn:ai,itemPrintFn:ah,itemEnableFn:af}));a&&(a.autoComplete=a.__input.autoComplete({title:"输入中文/拼音/↑↓键选择",placeholder:"城市名",localData:aD,highlight:true,keepListOnNoResult:true,width:220,max:10,processPrintDataFn:function(aF){aq.call(this,aF,"更精确到达地")},preSortFn:ap,sortFn:ax,itemValueFn:ai,itemPrintFn:ah,itemEnableFn:af}))});if(v){v.cal=v.__input.mCal({fn:function(aC){if(o.searchType=="2"){fish.dom("#txtAirplaneTime2").style.color="#333";c.__input.val(fish.parseTime(aC,{days:1}));c.cal&&(c.cal.startTime=aC);c.cal&&c.cal.show();c.cal.setNow(fish.parseTime(fish.one(c.__input).val()));c.cal.show(false,false)}else{if(o.searchType=="3"){fish.dom("#txtAirplaneTime3").style.color="#333";F.__input.val(fish.parseTime(aC,{days:1}));F.cal&&(F.cal.startTime=aC);F.cal&&F.cal.show();F.cal.setNow(fish.parseTime(fish.one(F.__input).val()));F.cal.show(false,false);fish.one("#airTransWeek").html(getWeekCommon(fish.one(F.__input).val()))}}}})}});m=fish.cookie.get("FlightVIP");var S=fish.cookie.get("cnUser","userid"),av=fish.one(A),az=fish.one(B);if((S&&parseInt(S,10)>0)){av[0]&&av.css("display:inline-Block");az.css("display:none");fish.one(av[0].parentNode).addClass("at");if(!fish.cookie.get("searchSteps")){fish.cookie.set({name:"FlightVIP",value:"2",domain:".17u.cn",path:"/"})}else{if(m=="2"){}}}else{av[0]&&av.css("display:inline-Block");az.css("display:inline-Block");fish.one(av[0].parentNode).removeClass("at")}fish.one(B).on("click",function(){var aC=fish.cookie.get("searchSteps");fish.cookie.set({name:"searchSteps",value:"2",domain:".17u.cn",path:"/"});h=1;ay()}).on("mouseover",function(){fish.one(this).removeClass("search_submit").addClass("search_submit_hover")}).on("mouseout",function(){fish.one(this).removeClass("search_submit_hover").addClass("search_submit")});fish.one(A).on("click",function(){var aC=fish.cookie.get("searchSteps");fish.cookie.set({name:"searchSteps",value:"1",domain:".17u.cn",path:"/"});if((S&&parseInt(S,10)>0)){fish.cookie.set({name:"FlightVIP",value:"2",domain:".17u.cn",path:"/"})}h=2;ay()}).on("mouseover",function(){fish.one(this).removeClass("search_special").addClass("search_special_hover")}).on("mouseout",function(){fish.one(this).removeClass("search_special_hover").addClass("search_special")});fish.all("#soso_top_title a").hover(function(){fish.one(this).addClass("focus")},function(){fish.one(this).removeClass("focus")});fish.ready(function(){au();Y()});fish.loaded(function(){at()});o.oncitydataready=R;o.submit=ay;return o}fish.extend({flightSearch:function(H){u=H.leaveCityElem;b=H.arriveCityElem;E=H.transitCityElem?H.transitCityElem:"";w=H.leaveTimeElem;G=H.transitTimeElem;d=H.backTimeElem;q=H.historyElem;f=H.changCity;B=H.submitElem;A=H.searchElem;j=H.contentElem;C=H.searchSubmitUrl;g=H.searchDataUrl;y=H.oneWayElem?H.oneWayElem:"";z=H.returnWayElem?H.returnWayElem:"";i=H.connectWayElem?H.connectWayElem:"";return s()}})})();