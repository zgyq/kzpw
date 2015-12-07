(function($){

    if (typeof (online) == 'undefined') {
       var online={};
    }
    if (typeof(window.$c)!='undefined') {
       return false;
    }
    window.$c=function(clazzName,options){
        return new online.clazz[clazzName](options);
    };
    online.extend = function(){
        var item = null,
            it = null,
            arg = arguments,
            obj = arg.length == 1 ? online : arg[0],
            list = arg.length > 1 ? arg[1] : arg[0];

        switch(typeof obj){
            case 'object':
                if(obj instanceof Array){
                    if(typeof(list) == 'string'){
                        obj.push(list);
                    }else if(typeof(list) == 'object'){
                        for(item in list){
                            obj.push(list[item]);
                        }
                    }else{
                        obj.concat(list);
                    }
                }else{
                    for(item in list){
                        it = list[item];
                        if(!obj.hasOwnProperty(it)){
                            obj[item] = it;
                        }
                    }
                }
                break;
            case 'function':
                for(item in list){
                    it = list[item];
                    if(!obj.hasOwnProperty(it)){
                        obj.prototype[item] = it;
                    }
                }
                break;
            case 'string':
            case 'number':
            default:
                obj = obj;
        }
        return obj;
    };
    function matchNode(element, direction, start) {
        for (var node = element[start]; node; node = node[direction]) {
            if (node.nodeType == 1) return node;
        }
        return null;
    }

    var jsonMsg = $('#fl_intlMessage').html();
    online.msg= $.parseJSON(jsonMsg.replace(/\n|\r|\t/g, ''));
    /*online.msg = {
       ERROR_FLIGHT: [
            'è¯·éæ©ç¬¬{number}ç¨çåºååå¸', //0
            'è¯·éæ©ç¬¬{number}ç¨çå°è¾¾åå¸', //1
            'æ¨éæ©çç¬¬{number}ç¨çå°è¾¾åå¸ååºååå¸ç¸åï¼è¯·éæ°éæ©', //2
            'è¯·éæ©ç¬¬{number}ç¨çåºåæ¥æ', //3
            'æ¥ææ ¼å¼æè¯¯ï¼è¯·æ£æ¥', //4
            'å¯¹ä¸èµ·ï¼ç¬¬{number}ç¨çåºåæ¥æä¸è½å¨ä»å¤©ä¹å', //5
            'å¯¹ä¸èµ·ï¼åªè½æ¥è¯¢ä¸å¹´åèªç­', //6
            'å¯¹ä¸èµ·ï¼ç¬¬{number}ç¨æ¥æä¸è½æ©äºç¬¬{second}ç¨æ¥æ', //7
            'èªç¨ä¸­å¿é¡»æä¸ç¨ä¸ºå½éèªç¨ï¼è¯·æ£æ¥æ¨çåºåå°è¾¾åå¸', //8
            'è¯·éæ©åºååå¸', //9
            'è¯·éæ©åºåæ¥æ', //10
            'è¯·éæ©ç®çåå¸', //11
            'æ¨éæ©çç®çåå¸ååºååå¸ç¸åï¼è¯·éæ°éæ©', //12
            'å¯¹ä¸èµ·ï¼è¿åæ¥æä¸è½æ©äºåºåæ¥æ', //13
            'å½åæ¥æä¸è½å°äºä»å¤©'//14
        ],
        TIPS_MESSAGER: 'ç³»ç»è¿äºç¹å¿,è¯·æ¨èå¿ç­å¾çå»ä¹ååæ¥è¯¢,è°¢è°¢!',
        numberList: ['ä¸', 'äº', 'ä¸', 'å', 'äº', 'å­', 'ä¸'],
        ZHUANG:'è½¬',
        ADDRESS_SEARCHTIPS:'è¾å¥ä¸­è±æ|ä»£ç æç´¢æââéæ©.',
        NO_FILTER_RESULT:' å¯¹ä¸èµ·ï¼æ å¹éï¼è¯·éæ°è¾å¥ã ',
        FILTER_RESULT:'${val}ï¼æå­ç¬¦é¡ºåºæåº',
        GJM:"\"${val}\" å½å®¶åï¼ç¸å³åå¸",
        MULTIPASS:{
            'big5':{
                startCity:'åºååå¸',
                endCity:'å°è¾¾åå¸',
                startDate:'åºåæ¥æ'
            },
            'gb2312':{
                startCity:'åºååå¸',
                endCity:'å°è¾¾åå¸',
                startDate:'åºåæ¥æ'
            }
        }
    };*/
    $.extend($.fn, {
        hide: function () {
            for (var i = this.length; i--; ) {
                this[i].style.display = 'none';
            }
            return this;
        },
        show: function () {
            for (var i = this.length; i--; ) {
                this[i].style.display = '';
            }
            return this;
        },
        parents: function (str) {
            try {
                var tempNode = this[0].parentNode;
                while (tempNode && tempNode.tagName != arguments[0].toUpperCase()) {
                    tempNode = tempNode.parentNode;
                }
                return [tempNode];
            } catch (err) {
                return [];
            }
        }
    });
    online.extend({
        inits: {},
        clazz:{},
        form:$('#fl_box_search'),
         /**
         *é»è®¤ç¼ç æ¹å¼
         *
        */
        'charset': /*'gb2312',*/cQuery.config("charset").toLowerCase(),
        domain:(function(){
            var mc=location.host.match(/testp|test|uat/),hk=/.hk/.test(location.host)?'.hk':'';
            return mc!=null?'ctriptravel.com'+hk:'ctrip.com'+hk;
        })(),
        getSiteName:function(t){
            var charset=cQuery.config("charset").toLowerCase();
            var mc=location.host.match(/testp|test|uat/),hosts='http://',hk=/.hk/.test(location.host) && charset=='big5'&&t ?'.hk':'';
            t=t&&hk==''?(charset=='big5'?'big5.':''):'';
            return (mc!=null?hosts+'flights.'+t+mc[0]+'.sh.ctriptravel.com'+hk+'/':hosts+'flights.'+t+'ctrip.com'+hk+'/');
        },
        siteName:'',
        jsBaseUrl:'http://webresource.c-ctrip.com/uires/flightintl/online/',
        /**æµè§å¨çæ¬*/
        version:function(){
            return navigator.userAgent.toLowerCase().match(/msie (\d+)/)[1];
            //return (navigator.userAgent.toLowerCase().match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [0, '0'])[1];
        },
        /**æå­ç¬¦ä¸²è½¬æ¢æjsonæ°æ®*/
        toJson: function () {
            return new Function('return (' + arguments[0] + ')')();
        },
        next: function () {
            return matchNode(arguments[0], 'nextSibling', 'nextSibling');
        },
        prev: function () {
            return matchNode(arguments[0], 'previousSibling', 'previousSibling');
        },
        first: function () {
            return matchNode(arguments[0], 'nextSibling', 'firstChild');
        },
        last: function () {
            return matchNode(arguments[0], 'previousSibling', 'lastChild');
        },
        parent:function(){
            return matchNode(arguments[0],'parentNode','parentNode');
        },
        children: function (element) {
            for (var children = [], tmpEl = element.firstChild; tmpEl; tmpEl = tmpEl.nextSibling) {
                if (tmpEl.nodeType == 1) children.push(tmpEl);
            }
            return children;
        },
        hasClass: function () {
            return arguments[0].className.match(new RegExp('(\\s|^)' + arguments[1] + '(\\s|$)'));
        },
        addClass: function () {
            if (!online.hasClass(arguments[0], arguments[1])) {
                arguments[0].className = (arguments[0].className + " " + arguments[1]).replace(/\s{2,}/g, " ");
            }
        },
        removeClass: function () {
            if (online.hasClass(arguments[0], arguments[1])) {
                var reg = new RegExp('(\\s|^)' + arguments[1] + '(\\s|$)');
                arguments[0].className = arguments[0].className.replace(reg, ' ').split(" ").join(" ");
            }
        },
        create: function () {
            var arg = arguments,
                f = function () {
                    this.initialize.apply(this, arguments);
                };

            for (var i = 0, item, len = arg.length; i < len; i++) {
                item = arg[i];
                if (item == null) {
                    continue;
                }
                online.extend(f, item);
            }
            return f;
        },
        insertHtml: function (where, el, html) {
            where = where.toLowerCase();
            if (el.insertAdjacentHTML) {
                switch (where) {
                    case "beforebegin":
                        el.insertAdjacentHTML('BeforeBegin', html);
                        return el.previousSibling;
                    case "afterbegin":
                        el.insertAdjacentHTML('AfterBegin', html);
                        return el.firstChild;
                    case "beforeend":
                        el.insertAdjacentHTML('BeforeEnd', html);
                        return el.lastChild;
                    case "afterend":
                        el.insertAdjacentHTML('AfterEnd', html);
                        return el.nextSibling;
                }
            } else {
                var range = el.ownerDocument.createRange();
                var frag;
                switch (where) {
                    case "beforebegin":
                        range.setStartBefore(el);
                        frag = range.createContextualFragment(html);
                        el.parentNode.insertBefore(frag, el);
                        return el.previousSibling;
                    case "afterbegin":
                        if (el.firstChild) {
                            range.setStartBefore(el.firstChild);
                            frag = range.createContextualFragment(html);
                            el.insertBefore(frag, el.firstChild);
                            return el.firstChild;
                        } else {
                            el.innerHTML = html;
                            return el.firstChild;
                        }
                    case "beforeend":
                        if (el.lastChild) {
                            range.setStartAfter(el.lastChild);
                            frag = range.createContextualFragment(html);
                            el.appendChild(frag);
                            return el.lastChild;
                        } else {
                            el.innerHTML = html;
                            return el.lastChild;
                        }
                    case "afterend":
                        range.setStartAfter(el);
                        frag = range.createContextualFragment(html);
                        el.parentNode.insertBefore(frag, el.nextSibling);
                        return el.nextSibling;
                }
            }
        },
        trigger: function () {
            if (document.createEvent) {
                var evt = document.createEvent("MouseEvents");
                evt.initEvent(arguments[1], true, true);
                arguments[0].dispatchEvent(evt);
            } else {
                arguments[0].fireEvent('on' + arguments[1]);
            }
        },
        /**
         *éªè¯è¡¨ååç´ æ¯å¦ä¸ºç©º
         @return Boolean
        */
        isNull: function (element) {
            return element.value.trim() == '' || element.getAttribute('mod_notice_tip') == element.value;
        },
        /**
         *dateç±»åè½¬æ¢ædateç±»å
         *@return Date
        */
        dateValue: function (date) {
            return new Date(date.getFullYear(), date.getMonth(), date.getDate());
        },
        clearNotice:function(f){
            f = f&&f.length>0?f:$('form input[mod]');
            f.each(function(item){
                if(item.attr('mod').match('notice')!=null &&online.isNull(item[0]) ){
                    item.value('');
                }
            });
        },
        tw:function(t, b, c, d) {
            return -c * ((t = t / d - 1) * t * t * t - 1) + b;
        },
        animate:function(H,W){
            var CH, CW, E, Htimer, TH, TW, Wtimer;
            E = 10;
            var O = $('#searchBox'),ooo=$('#searchBoxUl');
            var OO = $(online.parent(online.form[0]) );
            if (H != null) {//é«åº¦
              TH = 0;
              CH = parseInt(O.css('height'));
              if (H > CH) {//ä»å°åå¤§
                H -= CH;
              } else {//ä»å¤§å°å
                H = -(CH - H);
              }
              if (H !== 0) {
                Htimer = setInterval(function() {
                  var HH;

                  if (TH === E) {
                    return clearInterval(Htimer);
                  }
                  HH = Math.round(online.tw(TH++, CH, H, E));
                  O.css('height', HH + 'px');
                  ooo.css('height', HH + 'px');
                  OO.css('height', (HH - 25) + 'px');//divä¸searchBoxçé«åº¦ç¸å·®25,æä»¥ä¸ç¨åå»è®¡ç®äºç´æ¥å¨ä¸é¢çå¼ä¸ å25
                }, 13);
              }
            }
            if (W != null) {//å®½åº¦
                O = $('#searchBox');
                TW = 0;
                CW = parseInt(O.css('width'));
                if (W > CW) {
                    W -= CW;
                } else {
                    W = -(CW - W);
                }
                if (W !== 0) {
                    Wtimer = setInterval(function() {
                      var WW;

                      if (TW === E) {
                        return clearInterval(Wtimer);
                      }
                      WW = Math.round(online.tw(TW++, CW, W, E));
                      O.css('width', WW + 'px');
                      OO.css('width', (WW - 15 - 100) + 'px');//divä¸searchBoxçå®½åº¦ç¸å·®15,æä»¥ä¸ç¨åå»è®¡ç®äºç´æ¥å¨ä¸é¢çå¼ä¸ å15
                    }, 13);
                }
            }
        }
    });

    online.siteName=online.getSiteName(true);
    /**
     *cQueryæ¨¡åæ³¨å
    */
    online.clazz.RegisterMod=online.create({
        _setOptions:function(options){
            var _this=this;
            var opt={
                version:{
                    address: '1.0',
                    notice: '1.0',
                    validate: '1.1',
                    jmpInfo: '1.0',
                    jmp:'1.0',
                    calendar: '3.0',
                    mask: '1.0',
                    adFrame: '1.0',
                    allyes: '1.0',
                    tab: '1.2'
                },
                elements:$('[mod]'),
                charset:online.charset || cQuery.config("charset"),
                inits: {},
                resource:[
                    'http://webresource.c-ctrip.com/code/cquery/resource/address/flightintl/'
                ],
                jmpInfoTpl:{
                    'jmp_title': '<div class="jmp_hd"><h3 id="para1">${txt0}</h3></div><div id="para2" class="jmp_bd">${txt1}</div>',
                    '#transit': '<div class="jmp_hd"><h3 id="txt0">${txt0}</h3></div><div class="jmp_bd"><div><span id="txt1" class="pubFlights_${txt3} airline">&nbsp;${txt1}</span> </div><div class="prindex_turn">'+online.msg.ZHUANG+'<span></span></div><div><span id="txt2" class="pubFlights_${txt4} airline">&nbsp;${txt2}</span></div></div>'
                },
                releaseNo:$('#releaseno').length > 0 ? $('#releaseno')[0].value : '',
                addressTpl:{
                    airline: function () {
                        var opt = {
                            template: {
                                suggestionInit: function (obj) {
                                    var as = obj.find('a[data]');
                                    as.bind('mouseover', function () {
                                        $(this).addClass('hover');
                                    }).bind('mouseout', function () {
                                        $(this).removeClass('hover');
                                    });
                                    $(_this.modElement).bind('blur', function () {
                                        obj.hide();
                                    }).bind('focus', function () {
                                        obj.show();
                                    }).bind('keyup', function (event) {
                                        var target = event.target, btnSearchFlight = online.$get("btnSearchFlight"),
                                         key = !isNaN(event.keyCode) ? event.keyCode : event.charCode;
                                        key == 13 && target.id == 'txtAirline' && (btnSearchFlight.focus());
                                    });
                                },
                                suggestionIpad: '<a href="javascript:void(0)" class="ico_key" id="mini_c_address_keyboard">Keyboard</a><a href="javascript:void(0)" class="address_close" id="mini_c_address_close">close</a>',
                                suggestion: '<div class="c_address_select"><div class="c_address_wrap">{ipad}<div class="c_address_hd">' + online.msg.ADDRESS_SEARCHTIPS + '</div><div style="" class="c_address_list">{{enum(key,arr) data}}{{each arr}}<a href="javascript:;" title="${display}" data="${data}"><span>${rightDisplay}</span>${display}</a>{{/each}}{{/enum}}</div></div></div>',
                                suggestionStyle: '\
                                    .c_address_hd { height: 24px; border-color: #2C7ECF; border-style: solid; border-width: 1px 1px 0; background-color: #67A1E2; color: #fff; line-height: 24px; text-align:center }\
                                    .c_address_bd { border-color: #999999; border-style: solid; border-width: 0 1px 1px; overflow: hidden; padding:10px; }\
                                    .c_address_select { width:222px; height:355px; font-family: Arial, Simsun; font-size: 12px; }\
                                    .c_address_wrap { width: 220px; height:349px; min-height: 305px; margin: 0; padding: 0 0 4px; border: 1px solid #969696; background:#fff; text-align: left; }\
                                    .c_address_hd { margin:-1px; }\
                                    .c_address_list { margin: 0; padding: 0; height:300px; }\
                                    .c_address_list span { float: right; font: 10px/22px verdana; margin: 0; overflow: hidden; padding: 0; text-align: right; white-space: nowrap; width: 110px; }\
                                    .c_address_list a { border-bottom: 1px solid #FFFFFF; border-top: 1px solid #FFFFFF; color: #0055AA; cursor: pointer; display: block; height: 22px; line-height: 22px; min-height: 22px; overflow: hidden; padding: 1px 9px 0; text-align: left; text-decoration: none; }\
                                    .c_address_list a.hover,.c_address_list a:hover { background: none repeat scroll 0 0 #E8F4FF; border-bottom: 1px solid #7F9DB9; border-top: 1px solid #7F9DB9; }\
                                    .address_selected { background: none repeat scroll 0 0 #FFE6A6; color: #FFFFFF; height: 22px; }\
                                    .c_address_pagebreak { line-height: 25px; margin: 0; padding: 0; text-align: center; }\
                                    .c_address_pagebreak a { color: #0055AA; display: inline-block; font-family: Arial, Simsun, sans-serif; font-size: 14px; margin: 0; padding: 0 4px; text-align: center; text-decoration: underline; width: 15px; }\
                                    a.address_current { color: #000; text-decoration: none; }\
                                    .c_address_select .ico_key, .c_address_select .ico_unkey{position: absolute;top: 1px;left: 1px;width: 34px;height: 24px;overflow: hidden;line-height: 999em;font-size: 0;content: "";background: url(http://pic.ctrip.com/ctripOnPad/ico_key.png) no-repeat 0 0;-webkit-transform: scale(.7);}\
                                    .c_address_select .address_close {position: absolute;top: 3px;right: 4px;width: 18px;height: 19px;overflow: hidden;line-height: 999em;font-size: 0;content: "";text-indent: 99em;background: url(http://pic.ctrip.com/ctripOnPad/pad_address_icon.png) no-repeat -32px 0;-webkit-transform: scale(0.5);}\
                                    .c_address_select .ico_unkey {background: url(http://pic.ctrip.com/ctripOnPad/ico_unkey.png) no-repeat 0 0;}\
                                '
                            }
                        };
                        online.extend(opt.template,{
                            suggestionInitIpad:opt.template.suggestionInit,
                            suggestionIpad:opt.template.suggestion.replace('{ipad}',opt.template.suggestionIpad),
                            suggestionStyleIpad:opt.template.suggestionStyle,
                            suggestion:opt.template.suggestion.replace('{ipad}','')
                        });
                        return opt;
                    },
                    address: function () {
                        var opt = {
                            message:{
                                filterResult:online.msg.FILTER_RESULT,
                                noFilterResult:online.msg.NO_FILTER_RESULT
                            },
                            template: {
                                filterPageSize: 10,
                                suggestionStyle:'\
                                    .c_address_box { background-color: #fff; font-size: 12px; width: 435px !important; }\
                                    .c_address_box a { text-decoration: none; }\
                                    .c_address_hd { height: 24px; border-color: #2C7ECF; border-style: solid; border-width: 1px 1px 0; background-color: #67A1E2; color:#CEE3FC; line-height: 24px; padding-left: 10px; }\
                                    .c_address_hd strong{color:#fff;}\
                                    .c_address_bd { border-color: #999999; border-style: solid; border-width: 0 1px 1px; overflow: hidden; padding:10px; }\
                                    .c_address_ol { margin:0; padding:0 0 20px; border-bottom: 1px solid #5DA9E2; }\
                                    .c_address_ol li { color: #005DAA; cursor: pointer; float: left; height: 20px; line-height: 20px; list-style-type: none; text-align: center; }\
                                    .c_address_ol li span { padding:0 8px; white-space:nowrap; display:block; }\
                                    .c_address_ol li .hot_selected { display:block; padding:0 7px; background-color: #FFFFFF; border-color: #5DA9E2; border-style: solid; border-width: 1px 1px 0; color: #000000; font-weight: bold; }\
                                    .c_address_ul { width: 100%; margin:0; padding: 4px 0 0; }\
                                    .c_address_ul li { float: left; height: 24px; overflow: hidden; width: 103px; }\
                                    .c_address_ul li a { display: block; height: 22px;  border: 1px solid #FFFFFF; color: #1148A8; line-height: 22px; padding-left: 5px; }\
                                    .c_address_ul li a:hover { background-color: #E8F4FF; border: 1px solid #ACCCEF; text-decoration: none; }\
                                ',
                                suggestionStyleIpad:'\
                                    .c_address_box {position:relative;width:435px !important;background-color:#FFFFFF;font-size:12px;}\
                                    .c_address_box a {text-decoration:none;}\
                                    .c_address_hd {padding-left:10px;padding-right:24px;height:24px;text-indent:32px;text-align:center;border-color:#2C7ECF;border-style:solid;border-width:1px 1px 0;background-color:#67A1E2;color:#CEE3FC;line-height:24px;}\
                                    .c_address_hd strong {color:#FFFFFF;}\
                                    .c_address_bd {overflow:hidden;padding:10px;border-color:#999999;border-style:solid;border-width:0 1px 1px;}\
                                    .c_address_ol {margin:0;padding:0 0 20px;border-bottom:1px solid #5DA9E2;}\
                                    .c_address_ol li {float:left;height:20px;color:#005DAA;list-style-type:none;text-align:center;line-height:20px;cursor:pointer;}\
                                    .c_address_ol li span {display:block;padding:0 8px;white-space:nowrap;}\
                                    .c_address_ol li .hot_selected {display:block;padding:0 7px;border-color:#5DA9E2;border-style:solid;border-width:1px 1px 0;background-color:#FFFFFF;color:#000000;font-weight:bold;}\
                                    .c_address_ul {margin:0;padding:4px 0 0;width:100%;}\
                                    .c_address_ul li {float:left;overflow:hidden;width:103px;height:24px;}\
                                    .c_address_ul li a {display:block;padding-left:5px;height:22px;border:1px solid #FFFFFF;color:#1148A8;line-height:22px;}\
                                    .c_address_ul li a:hover {border:1px solid #ACCCEF;background-color:#E8F4FF;text-decoration:none;}\
                                    .c_address_box .ico_key,\
                                    .c_address_box .ico_unkey {position:absolute;top:1px;left:1px;width:34px;height:24px;overflow:hidden;line-height:999em;font-size:0;content:"";background:url(http://pic.ctrip.com/ctripOnPad/ico_key.png) no-repeat 0 0;-webkit-transform:scale(.7);}\
                                    .c_address_box .ico_unkey {background:url(http://pic.ctrip.com/ctripOnPad/ico_unkey.png) no-repeat 0 0;}\
                                    .c_address_box .address_close  {position:absolute;top:3px;right:4px;width:18px;height:19px;overflow:hidden;line-height:999em;font-size:0;content:"";text-indent:99em;background:url(http://pic.ctrip.com/ctripOnPad/pad_address_icon.png) no-repeat -32px 0;-webkit-transform:scale(0.5);}\
                                ',
                                filter: '\
                                    <div class="c_address_select">\
                                        <div class="c_address_wrap">\
                                            <div class="{{if !hasResult}}c_address_hd_error{{else}}c_address_hd{{/if}}">{{if hasResult}}{{tmpl message.filterResult}}{{else}}{{tmpl message.noFilterResult}}{{/if}}</div>\
                                            {{if hasResult}}\
                                                <div class="c_address_list">\
                                                    {{each (i,item) list}}\
                                                        {{if cQuery.type(item)=="string"}}\
                                                            <label>${item}</label>\
                                                        {{else}}\
                                                            <a href="javascript:void(0);" data="${data}" style="display: block;">{{tmpl data.split("|")[3] }}<span>${left}</span></a>\
                                                        {{/if}}\
                                                    {{/each}}\
                                                </div>\
                                                {{if page.max>0}}\
                                                    <div class="c_address_pagebreak">\
                                                        {{if page.current>0}}\
                                                            <a href="javascript:void(0);" page="${page.current-1}">&lt;-</a>\
                                                        {{/if}}\
                                                        {{if page.current<2}}\
                                                            {{loop(index) Math.min(5,page.max+1)}}\
                                                                <a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>\
                                                            {{/loop}}\
                                                        {{else page.current>page.max-2}}\
                                                            {{loop(index) Math.max(0,page.max-4),page.max+1}}\
                                                                <a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>\
                                                            {{/loop}}\
                                                        {{else}}\
                                                            {{loop(index) Math.max(0,page.current-2),Math.min(page.current+3,page.max+1)}}\
                                                                <a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>\
                                                            {{/loop}}\
                                                        {{/if}}\
                                                        {{if page.current<page.max}}\
                                                            <a href="javascript:void(0);" page="${page.current+1}">-&gt;</a>\
                                                        {{/if}}\
                                                    </div>\
                                                {{/if}}\
                                            {{/if}}\
                                        </div>\
                                    </div>\
                                ',
                                filterStyle: '\
                                    .c_address_hd,.c_address_hd_error{ height: 24px; border-color: #2C7ECF; border-style: solid; border-width: 1px 1px 0; background-color: #67A1E2; color: #fff; line-height: 24px; padding-left: 10px; }\
                                    .c_address_bd { border-color: #999999; border-style: solid; border-width: 0 1px 1px; overflow: hidden; padding:10px; }\
                                    .c_address_select { width:302px; font-family: Verdana, Arial; font-size: 12px; }\
                                    .c_address_wrap { width:300px; margin:0; padding:0 0 4px; border:1px solid #969696; background:#fff; text-align:left; }\
                                    .c_address_hd { margin:-1px; }\
                                    .c_address_hd_error { margin:-1px -1px -4px; }\
                                    .c_address_list { margin: 0; padding: 0; _height:370px; }\
                                    .c_address_list label { display: block; height:30px; padding:7px 9px 0; text-align: center; }\
                                    .c_address_list span { display:block; font: 10px/12px verdana; margin: 0; overflow: hidden; padding: 0; white-space: nowrap; color:#999; -webkit-text-size-adjust:none; }\
                                    .c_address_list a { border-bottom: 1px solid #FFFFFF; border-top: 1px solid #FFFFFF; color: #0055AA; cursor: pointer; display: block; height: 30px; line-height: 14px; min-height: 22px; overflow: hidden; padding:5px 9px 0; text-align: left; text-decoration: none; }\
                                    .c_address_list a.hover { background: none repeat scroll 0 0 #E8F4FF; border-bottom: 1px solid #7F9DB9; border-top: 1px solid #7F9DB9; }\
                                    .c_address_list b { color:#03459d; }\
                                    .address_selected { background: none repeat scroll 0 0 #FFE6A6; color: #FFFFFF; height: 22px; }\
                                    .c_address_pagebreak { line-height: 25px; margin: 0; padding: 0; text-align: center; }\
                                    .c_address_pagebreak a { color: #0055AA; display: inline-block; font-family: Arial, Simsun, sans-serif; font-size: 14px; margin: 0; padding: 0 4px; text-align: center; text-decoration: underline; width: 15px; }\
                                    a.address_current { color: #000; text-decoration: none; }\
                                '
                            },
                            jsonpFilter: (typeof(jsonpAddressUrl)!='undefined'?jsonpAddressUrl:online.siteName+'international/tools/GetCities.ashx')+'?s=${key}&a=' + (_this.modElement[0].getAttribute('mod_address_source') == 'flightintl_start' ? '0' : '1') + '&t=' + (online.charset == 'big5' ? '1' : '0'),
                            delay: 50
                        };
                        online.extend(opt.template,{
                            filterIpad:opt.template.filter,
                            filterStyleIpad:opt.template.filterStyle
                        });
                        return opt;
                    }
                }
            };

            online.extend(opt,options);
            online.extend(this,opt);
            //this.validateObj =this.getValidate();
        },
        initialize:function(options){
            this._setOptions(options);
            for(var item in this.version){
                this.inits[item]={};
            }
            //æç´¢æ¡ä»¶
            //this.searchBoxVals=$.storage.get('flightintl_searchBoxVals')||{};
            this.saveStorage='flightintl_searchBoxVals_'+online.charset;
            var flightintl_searchBoxVals=$.cookie.get(this.saveStorage)||false;
            this.searchBoxVals = flightintl_searchBoxVals ? $.parseJSON(flightintl_searchBoxVals):($.storage.get(this.saveStorage)||{});
            //this.searchBoxVals=$.parseJSON($.cookie.get('flightintl_searchBoxVals')||'{}');
            this.modElement=null;
            this.isRegisterJmp=false;
        },
        //å¤æ­æ¯å¦æå¼ï¼æå¼å°±å æç°æçæ ·å¼
        clearNotice:function(element){
            !online.isNull(element) &&(online.removeClass(element,'inputSel') );
        },
        getFirstCityNameByIp:function(firstCity){
            if(firstCity.length<=0 ||firstCity.value().trim()!=''){
                return false;
            }
            var firstCityName=this.searchBoxVals.flightintl_startcity_single||arguments[1],_this=this;
            if(!firstCityName||firstCityName==''||typeof(firstCityName)=='undefined' ){
                //http://flights.ctrip.com/
                $.loader.jsonp(online.siteName+'international/tools/GetUserPosition.ashx?t='+(online.charset=='big5'?'1':'0'),{
                    charset:online.charset,
                    onload:(function(data){
                        if(data!='' && data.indexOf('|')!=-1&&data.length<150 ){
                            //.attr('mod_save_id') searchBoxVals[saveId]
                            var saveId=firstCity.attr('mod_save_id');
                            if(saveId){
                                _this.searchBoxVals[saveId]=data;
                            }
                            data=data.split('|');
                            firstCity.value(data[0]);
                            $('#'+firstCity.attr('mod_address_reference') ).value(data[1]);
                            _this.clearNotice(firstCity[0]);
                        }
                    }).bind(this)
                });
            }
        },
        saveSearchBoxVals:function(){
            $.cookie.set(this.saveStorage,null,$.stringifyJSON(this.searchBoxVals),{
                domain:online.domain.trim(),
                path:'/',
                expires:365
            });
            $.storage.set(this.saveStorage,this.searchBoxVals);
        },
        clearSearchBoxVals:function(key){
            key &&(this.searchBoxVals[key]=null );
        },
        getMod:function(inputName,modName){
            return $(inputName).getMod(modName,this.version[modName]);
        },
        //åå¸éæ©å¨æ°æ§å¼å³
        _switchAddress:function(){
            try{
                return ($('#hdn_enableCitySelectAjaxCall').length>0 && ($('#hdn_enableCitySelectAjaxCall').value()+'')=='1' )?true : false;
            }catch(ex){
                return false;
            }
        },
         /**
         *æ³¨åå°åéæ©å¨
         *@return null
        */
        register_address: function (element) {
            var focusLoader = element[0].getAttribute('focus_loader'),_this=this,version=this.version['address'],is=this._switchAddress(),isAddress='';
            this.modElement = element;

            var get = function (element) {
                var fileName = element[0].getAttribute('mod_address_source'), id = element[0].getAttribute('id') ||element.attr('name'), relate = $('#' + element[0].getAttribute('mod_address_reference')),
                saveId=element.attr('mod_save_id'),
                isFocusNext=element[0].getAttribute('mod_address_focusnext'),
                isSaveVal=element.attr('mod_save_value');
                isSaveVal = (isSaveVal && isSaveVal.toLowerCase()=='true') ?true:false;
                    //template = {};

                var tt = element[0].getAttribute('mod_address_tpl') ? _this.addressTpl[(isAddress = element[0].getAttribute('mod_address_tpl')) ]() : {};

                (isAddress=='address' && is) &&(fileName+='_new');

                var options = {
                    name: id,
                    jsonpSource: 'http://webresource.c-ctrip.com/code/cquery/resource/address/flightintl/' + fileName + '_' + online.charset + '.js',
                    isFocusNext: ( isFocusNext&& isFocusNext =='true')?true:(isFocusNext=='false'?false:$('#'+isFocusNext) ),
                    isAutoCorrect: true,
                    relate: {
                        2: relate
                    },
                    offset: element[0].getAttribute('mod_address_position') ? element[0].getAttribute('mod_address_position') * 1 : 5,
                   // template: template,
                    sort: ['^0$', '^1$', '^3$', '^0', '^1', '^3', '0', '1', '3', '^4+$'],
                    message: {
                        // '^0$','^1$','^3+$','^0','^1','^3+','0','1','3+'
                        sort: ["", "", "", "", "", "", "", "", "", online.msg.GJM]
                    }
                },setNextValue=function(el){
                    var next = el.attr('mod_next_value')?$('#'+el.attr('mod_next_value') ):[],
                        val = val=el.value()+'|'+$('#'+el.attr('mod_address_reference')).value();

                    el.attr('mod_change_value',val),
                    (next && next.length>0 && !online.isNull(el[0]) &&(online.isNull(next[0])|| next.value().match(/\([a-zA-Z]+\)/)==null ) ) &&(
                        next.attr('mod_change_id',el.attr('id'))
                    );
                };
                if(isAddress=='address' && is){
                    $.extend(options, tt);
                }else if(isAddress!='address'){
                    $.extend(options, tt);
                }
                //$.extend(options, tt);
                $.mod.load("address", version, function () {
                    _this.inits.address[id]=element.regMod('address', version, options);
                    _this.inits.address[id].method('bind','change',function(m,data){
                        var items = data.items;
                        if(saveId){
                            items &&(_this.searchBoxVals[saveId]=items['1']+'|'+items['2'] );
                        }
                        setNextValue($(this));
                    });

                    element.bind('focus',function(){
                        var id = this.getAttribute('mod_change_id'),prevVal=$('#'+id).attr('mod_change_value');
                        if(online.isNull(this) &&prevVal){
                            prevVal = prevVal.split('|');
                            $(this).value(prevVal[0]);
                            var ref = $('#'+$(this).attr('mod_address_reference') );
                            ref.length>0 &&(ref.value(prevVal[1]) );

                        }

                    });
                });

                if(isSaveVal && saveId){
                    var getValue=_this.searchBoxVals[saveId];
                    if(getValue){
                        var items=getValue.split('|');
                        element.value(items[0]);
                        relate.value(items[1]);
                    }
                }
                _this.clearNotice(element[0]);
                setNextValue(element);
                element[0].setAttribute('init_mod', 'T');
            }.bind(this);
            if (focusLoader) {
                element.bind('focus', get.bind(this, element));
            } else {
                get(element);
            }

        },
         /**
         *è·åéªè¯æ¨¡å
         *@return Object
        */
        getValidate: function () {
            /*try{
                var mod = $(document).getMod("validate", this.version['validate'] );
                return mod?mod:$(document).regMod("validate", this.version['validate'] );
            }catch(ex){
                return $(document).regMod("validate", this.version['validate'] );
            }*/
            return online.form.regMod("validate", this.version['validate'] );
        },
        validate:function(element,msg){
            this.validateObj.method("show", {
                $obj: $(element),
                data: msg,
                removeErrorClass: !0,
                hideEvent: "blur",
                isFocus: true
            });
        },
         /**
         *åå§åæ³¨åé¡µé¢ä¸­ææçæ¨¡å
         *@return null
        */
        registerAll: function (modList) {
            !this.validateObj&&(this.validateObj =this.getValidate() );
            var els = modList ? modList:this['elements'], sp = [];
            for (var i = 0, len = els.length; i < len; i++) {
                var element = els[i], mod = element.getAttribute('mod');
                if (!mod) {
                    continue;
                }
                sp = mod.indexOf('|') != -1 ? mod.split('|') : mod;
                if (typeof (sp) == 'string' && this['register_' + sp]) {
                    this['register_' + sp]($(element));
                    continue;
                }
                for (var j = 0, l = sp.length; j < l; j++) {
                    if (this['register_' + sp[j]]) {
                        this['register_' + sp[j]]($(element));
                    }
                }
            }
            //å¤æ­æ¯å¦æ³¨åè¿jmpinfo
            if(!this.isRegisterJmp){
                this.docRegisterJmpInfo();
                this.isRegisterJmp=true;
            }
        },
        docRegisterJmpInfo:function(){
            var version=this.version['jmp'];
            $.mod.load("jmp",version, function () {
                $(document).regMod('jmp',version, {});
            });

        },
         /**
         *æ³¨åinputé»è®¤æç¤º
         *@return null
        */
        register_notice: function (element) {
            var id = element[0].getAttribute('id')||element.attr('name'), notice = element[0].getAttribute('mod_notice_tip') || '',version = this.version['notice'],_this=this;
            $.mod.load("notice", version, function () {
                //ä¸ºäºå¼å®¹èçï¼æä»¥è¿æ ·å
                _this.inits[id+'_notice'] =_this.inits.notice[id] = element.regMod("notice", version, {
                    name: id,
                    tips: notice,
                    selClass: "inputSel"
                });
                _this.clearNotice(element[0]);
                element[0].setAttribute('init_mod', 'T');
            });
        },
        /**
         *æ³¨åæ¥å
         *@return null
        */
        register_calendar: function (element,option) {
            var version = this.version['calendar'],_this=this,
                isSaveVal=element.attr('mod_save_value'),
                saveId=element.attr('mod_save_id'),
                id=element[0].id || '';
            isSaveVal = (isSaveVal && isSaveVal.toLowerCase()=='true') ?true:false;

            $.mod.load('calendar', version, function () {
                var options = {
                    autoShow: !1,
                    showWeek: !0,
                    maxDate: (function () {
                        var date = new Date().addYears(1);
                        return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
                    })()
                    //reference:reference
                    //maxDate : [MF.other.todays[0] + 1, MF.other.todays[1], MF.other.todays[2]].join("-")
                },
                listeners={
                    onChange: function (a, b) {
                        saveId &&(_this.searchBoxVals[saveId]=b );
                        //saveId &&($.storage.set(saveId,b) );
                        var next = $(a).attr('mod_calendar_focusnext'), obj = null, index = 0;
                        if (!next || typeof (next) == 'undefined') return;
                        if (next.indexOf('~') != -1) {
                            next = next.split('~');
                            index = next.length;
                            obj = document.getElementById(next[0]);
                        } else {
                            next && (obj = document.getElementById(next));
                        }
                        obj && ($(obj).data('minDate', b));

                        if(index > 1){
                            obj = next[1]!='1' ? document.getElementById(next[1] ):obj;
                            if(obj.offsetHeight>0){
                                obj.focus();
                            }
                        }
                        //(obj && index > 1 && $(obj).parents('li').length > 0 && $($(obj).parents('li')[0]).css('display') != 'none') && (obj.focus());
                    }
                };
                if (element[0].getAttribute('mod_calendar_reference')) {
                    options.reference = '#' + element[0].getAttribute('mod_calendar_reference');
                }
                online.extend(options,option||{});

                online.extend(listeners,option?option.listeners:{});
                _this.inits.calendar[id]=element.regMod("calendar",version, {
                    options: options,
                    listeners: listeners
                });

                if(isSaveVal && saveId){
                    //$.storage.get(saveId);flightintl_startdate_single
                    var getValue=_this.searchBoxVals[saveId],
                        startDate = _this.searchBoxVals['flightintl_startdate_single']||_this.searchBoxVals['flightintl_startdate_single1'];
                    if(getValue && startDate && (+startDate.toDate()>=+new Date().toDate() ) ){
                        element.value(getValue);
                        //element.getMod("calendar", version).method("setWeek", "#" + element[0].id);
                        //options.reference &&(element.data('minDate', $(options.reference).value() ) );
                    }
                }
                options.reference && $(options.reference).value().trim().isDate() &&(element.data('minDate', $(options.reference).value() ) );
                _this.clearNotice(element[0]);
                element[0].setAttribute('init_mod', 'T');
            });
            //clearNotice

        }
    });


    //æ¹åå¤ç¨å±ç¤ºææ
    online.clazz.Multipass=online.create({
        setOptions:function(options){
            var defaultOpt={
                template:'\
                    <div class="s_item_cont" online_multipass_index="${index-1}">\
                        <div class="s_item_voyage online_number">${index}</div>\
                        <div class="s_item online_label">${i18n.startCity}\<input name="txtBeginAddress${index}" type="text" id="fl_txtBeginAddress${index}" mod_change_id="fl_txtEndAddress${index-1}" {{if index ==1}} mod_save_id="flightintl_startcity_single" mod_save_value="true"{{/if}} mod_address_source="flightintl_start" class="input_text" mod_address_focusnext="true" mod_notice_tip="${i18n.notice}" mod_address_reference="fl_txtBeginCityCode${index}" mod="address|notice" mod_address_tpl="address" autocomplete="off" />\
                        </div>\
                        <div class="s_item2 online_label">${i18n.startDate}<input name="txtDatePeriod${index}" type="text" id="fl_txtDatePeriod${index}" class="input_text" mod="calendar|notice"  {{if index ==1}}mod_save_value="true" mod_save_id="flightintl_startdate_single"{{/if}} mod_notice_tip="yyyy-mm-dd" mod_calendar_reference="fl_txtDatePeriod${index-1}" mod_calendar_focusnext="fl_txtDatePeriod${index+1}~fl_txtEndAddress${index}" autocomplete="off" />\
                        </div>\
                        <div class="s_item2 online_label">${i18n.endCity}<input name="txtEndAddress${index}" mod_address_focusnext="false" type="text" id="fl_txtEndAddress${index}" class="input_text" {{if index ==1}} mod_save_value="true" mod_save_id="flightintl_arrivalcity_single"{{/if}} mod_notice_tip="${i18n.notice}" mod_address_source="flightintl_dest" mod_address_reference="fl_txtEndCityCode${index}" mod="address|notice" mod_address_tpl="address" mod_next_value="fl_txtBeginAddress${index+1}" autocomplete="off" />\
                        </div>\
                        <a class="s_item_del del_line" href="javascript:;" style="{{if index<=2}}display:none{{/if}}"></a>\
                        <input name="txtBeginCityCode${index}" type="hidden" id="fl_txtBeginCityCode${index}" value="">\
                        <input name="txtEndCityCode${index}" type="hidden" id="fl_txtEndCityCode${index}" value="">\
                    </div>\
                ',
                'i18n':{
                    'big5':{
                        startCity:'åºç¼åå¸',
                        endCity:'å°éåå¸',
                        startDate:'åºç¼æ¥æ',
                        notice:'ä¸­æ/è±æ/æ¼é³'
                    },
                    'gb2312':{
                        startCity:'åºååå¸',
                        endCity:'å°è¾¾åå¸',
                        startDate:'åºåæ¥æ',
                        notice:'ä¸­æ/è±æ/æ¼é³'
                    }
                },
                target:$('#fl_flight_multiple'),
                container:$('#fl_multiple_div'),
                addTarget:$('#fl_add_new_line'),
                vals:online.registerMod.searchBoxVals,
                //æå¤§ç¨
                max:6,
                //æå°ç¨
                min:3,
                //é»è®¤æ¾ç¤ºå¼
                defaultValue:{},
                removeCallback:function(){},
                addCallback:function(){}
            };
            online.extend(defaultOpt,options);
            online.extend(this,defaultOpt);
        },
        initialize:function(opt){
            this.setOptions(opt);
            if(!this.target || this.target.length<=0){
                return;
            }
            this.i18n = this.i18n[online.charset];
            this.currentIndex = 0;

            online.extend(this.vals,this.defaultValue);

            //åå§åå¤ç¨æ¾ç¤º
            var l = online.children(this.target[0]).length;
            this.index = l;
            //this.min = this.vals.moreflightMin&&this.vals.moreflightMin>this.min?this.vals.moreflightMin:this.min;
            //æ¯å¦å°äºæå°èªç¨
            if(l<this.min){
                var min = this.min -l,str='';
                for(var i=0;i<min;i++){
                    //this.add();
                    str+=this.render()
                    //arr.push(this.render());
                }
                online.insertHtml('beforeend',this.target[0], str);
                online.registerMod.registerAll(this.target.find('[mod]') );
                //online.insertHtml('beforeend',this.target[0],arr.join('') );
            }
            this.index >= this.max&&(this.addTarget[0].style.display='none' );
            this.vals.moreflightMin = this.index ;
            this.bindEvent();
        },
        opacity:{
            set:function(element,value){
                var style = element.style;
                if($.browser.isIE){
                    style.filter = (style.filter || '').replace(/alpha\([^\)]*\)/gi,'') + (value == 1 ? '' : 'alpha(opacity='+value * 100 + ')');
                    style.zoom=1;
                }else{
                    $.type(value)=='number' ? style.opacity = value : style.opacity = 0;
                }
            },
            get:function(element){
                var style = Css.getComputedStyle(element),value = 1;
                if($.browser.isIE){
                    var filter = style['filter'];
                    value = filter && filter.indexOf('opacity=') >=0 ?(parseFloat(filter.match(/opacity=([^)]*)/)[1]) /100 ) : 1;
                }else{
                    value = style['opacity'];
                }
                value*=1;
                return value;
            }
        },
        render:function(){
            var t={
                index:++this.index,
                i18n:this.i18n
            };
            //å¦æå¤§äºæå¤§èªç¨ï¼åéèæ·»å æé®ï¼è¿å
            this.index >= this.max&&(this.addTarget[0].style.display='none' );
            return $.tmpl.render(this.template,t);
        },
        add:function(){
            online.insertHtml('beforeend',this.target[0],this.render() );
            var last = online.last(this.target[0]),_this=this;
            if (last) {
                var begin = 0;
                last.style.background = '#E8F4FF';
                last.style.display = '';
                this.opacity.set(last,begin);
                (function () {
                    begin = begin + 0.1;
                    if (begin < 1) {
                        _this.opacity.set(last,begin);
                        setTimeout(arguments.callee, 20);
                    } else {
                        last.style.background = 'none';
                        online.registerMod.registerAll($(last).find('[mod]') );
                        _this.vals['moreflightMin']=_this.index;
                    }
                })();

                _this.addCallback.call(this,$(last));
            }
        },
        remove:function(target){
            //åå¦æå æçæ¯ä¸­é´æä¸ç¨èªæ®µï¼é£ä¹éè¦æ´æ°åé¢çèªæ®µidåæ¥æid
            var elLi=online.parent(target),_this=this;
            elLi.style.background = '#E8F4FF';
            var begin = 1;
            this.currentIndex = elLi.getAttribute('online_multipass_index')|0;

            this.removeCallback.call(this,$(elLi));

            (function () {
                begin = begin - 0.1;
                if (begin > 0.1) {
                    _this.opacity.set(elLi,begin);
                    setTimeout(arguments.callee, 10);
                } else {
                    var reference='';
                    $(elLi).find('input').each(function(item){
                        reference=item.attr('mod_save_id');
                        reference &&(online.registerMod.clearSearchBoxVals(reference) );
                    });

                    $(elLi).remove();
                    _this.update();
                }
            })();
        },
        update:function(){
            --this.index;
            this.vals['moreflightMin']=this.index;
            this.index <= this.max&&(this.addTarget.show() );
            //æ´æ°id
            var c = online.children(this.target[0]),reference='',v='',_this=this,saveId='';
            for(var i=this.currentIndex,len=c.length;i<len;i++){
                $(c[i]).find('.line_num em:eq(0)').html(i+1);
                //online_number
                $(c[i]).find('.online_number:eq(0)').html(i+1);
                $(c[i]).attr('online_multipass_index',i);

                $(c[i]).find('input').each(function(item){

                    item[0].id = item[0].id.replace(/\d+$/,i+1);
                    item[0].name = item[0].name.replace(/\d+$/,i+1);

                    reference=item.attr('mod_address_reference');
                    reference &&(item.attr('mod_address_reference',reference.replace(/\d+$/,i+1)) );

                    //æ´æ°calendar
                    reference=item.attr('mod_calendar_reference');
                    reference &&(item.attr('mod_calendar_reference',reference.replace(/\d+$/,i)) );

                    //æ´æ°Date
                    if(item.attr('mod') &&item.attr('mod').match('calendar')!=null ){
                        reference &&(
                            v=$('#'+item.attr('mod_calendar_reference') ).value().trim(),
                            v.isDate()&&( item.data('minDate',v ) )
                        );
                        //mod_calendar_focusnext
                        reference=item.attr('mod_calendar_focusnext');
                        if(reference){
                            reference =reference.split('~');
                            reference[0]=reference[0].replace(/\d+$/,i+2);
                            if(reference.length>1 && reference[1]!='1'){
                                reference[1]=reference[1].replace(/\d+$/,i+1);
                            }
                            item.attr('mod_calendar_focusnext',reference.join('~'));
                        }
                        //reference &&(item.attr('mod_calendar_focusnext',reference.replace(/\d+$/,i+2)) );
                    }

                    reference=item.attr('mod_next_value');
                    reference &&(item.attr('mod_next_value',reference.replace(/\d+$/,i+2) )  );
                    //mod_change_id
                    reference=item.attr('mod_change_id');
                    reference &&(item.attr('mod_change_id',reference.replace(/\d+$/,i) )  );

                    reference=item.attr('mod_save_id');
                    if(reference){
                        //è·åå°åæ¥ä¿å­çå¼
                        saveId=_this.vals[reference];
                        online.registerMod.clearSearchBoxVals(reference);
                        reference=reference.replace(/\d+$/,i+1);
                        _this.vals[reference]=saveId;
                        item.attr('mod_save_id',reference);
                        //å æåæ¥ä¿å­çå¼
                    }
                });
            }
        },
        bindEvent:function(){
            var _this = this;
            this.target.bind('mousedown',function(e){
                var target =e.target;
                if($(target).hasClass('del_line') ){
                    _this.remove(target);
                }
            });

            this.addTarget.bind('click',_this.add.bind(this));
        }
    });


    var msg = online.msg,
        //å¨ç«é¦é¡µå·¦è¾¹æç´¢æ¡id
        searchBox = $('#searchBox'),
        mltHeight=0,
        highHeight=70,
        //æºç¥¨å¯¹åºçtabä¸­çpanel
        boxpanel = $(online.parent(online.form[0]) ),
        heightMap={
            d:[
                {
                    width:566,
                    height:286,
                    mltHeight:418
                },
                {
                    width:451,
                    height:261,
                    mltHeight:393
                }
            ],
            m:[
                {
                    width:870,
                    height:326,
                    mltHeight:406
                },
                {
                    width:755,
                    height:301,
                    mltHeight:381
                }
            ]
        },
        //å¨ç«é¦é¡µå·¦è¾¹æç´¢æ¡å·¦è¾¹ä¸ªé¢éçcontainer
        searchBoxNav=$(online.first(searchBox[0]) );


    function get() {
        return document.getElementById('fl_' + arguments[0]);
    }
    online.extend({
        heightMap:heightMap,
        $get:get,
        drpFlightWay: $("#fl_search_type input").length>0?$("#fl_search_type input:radio[name='FlightWay']"):null,
        removeCookie: function (name, path, domain) {
            document.cookie = name + '=' + (path ? '; path=' + path : '') + (domain ? '; domain=' + domain : '') + '; expires=' + new Date(0);
        },
        voyageType: function () {
            var multiple=online.registerMod.searchBoxVals.multipleRound,changeMore=false,

                validateRadio = function () {
                    document.getElementById('fl_childTips').style.display = get('selUserType').selectedIndex == 1 ? '' : 'none';
                };
            $('#fl_flight_way_d')[0].checked=true;
            get('selUserType').onchange = validateRadio;
            (multiple && multiple!='M') &&($('#fl_flight_way_'+multiple.toLowerCase() )[0].checked=true,multiple='' );
            return function () {
                if(online.drpFlightWay ==null){return;}
                var v = online.drpFlightWay.filter(':checked')[0].value.toLowerCase(),
                    fl_options_flt_in = $('#fl_options_flt_in');

				//s_disable
                //è¿ä¸ªæ¯å¾è¿çæ¥ææ¾ç¤º,ç°å¨æ¹æä¸ç´æ¾ç¤ºä½æ¯åç¨çæåµä¸åæç°è²
				//$("#fl_return_li").css('display', v == 's' ? 'none' : 'block');    //&&$("#fl_return_li input:eq(0)").value().trim()==''
                $('#fl_online_single')[0].style.display=v=='m'?'none':'';
                //searchbox_animate
                //searchBox[v =='m'?'addClass':'removeClass']('searchbox_flt_out_connect');

                $('#fl_airline').css('display',v != 'm' ? 'block' : 'none');
                //ä¹å®¢ç±»åçæ§å¶
                var fl_Type = v != 'm' ? 's_item' : 's_item2';
                $('#fl_isType')[0].className = fl_Type;
                //æ´æ°å®¹å¨é«åº¦
                //online.resetindexSearchHeight();
                online.resetindexSearchHeight();
                if(v=='m'){
                    if(!changeMore){
                        //online.resetindexSearchHeight();
                        if( fl_options_flt_in[0].style.display!='none' ){
                            //searchBox.addClass('searchbox_flt_out_connect');
                        }
                        //var height = mltHeight;
                        setTimeout(function(){
                            /*if(mltHeight>0){
                                searchBox.css('height',(parseInt(searchBox.css('height'),10)+height)+'px' );
                                if($(boxpanel).hasClass('s_content') ){
                                    $(boxpanel).css('height',(parseInt($(boxpanel).css('height'),10)+height)+'px' );
                                    searchBoxNav.css('height',(parseInt(searchBox.find('.s_tab:eq(0)').css('height'),10 )+height)+'px' );
                                }
                            }*/
                            $('#fl_online_more')[0].style.display='';
                            searchBox.addClass('searchbox_flt_out_default');
                        },270);

                        changeMore=true;
                    }
                }else if(v!='m'){

                    searchBox.removeClass('searchbox_flt_out_default').removeClass('searchbox_flt_out_connect');
                    searchBox[fl_options_flt_in[0].style.display!='none'?'addClass':'removeClass']('searchbox_flt_out');
                    $('#fl_online_more')[0].style.display='none';
                    changeMore=false;
                }
                //æ¯å¦ä¸ºç©º
				$("#fl_return_li")[v == 's'?'addClass':'removeClass']('s_disable');
				(function(ip){
					if(v == 's'){
						ip[0].online_val=ip.value()==''&&ip[0].online_val&&ip[0].online_val!=''?ip[0].online_val:ip.value();
						ip.value('');
						ip.css('backgroundImage','');
					}else if(v=='d'){
						ip[0].online_val &&ip[0].online_val!='' &&( ip.value(ip[0].online_val),ip.trigger('focus').trigger('change').trigger('blur') );
					}
					var mod = online.registerMod.inits.notice[ip.attr('id')];
					mod && (mod.method('checkValue') );
				})($("#fl_return_li input:eq(0)") );
				
                v!='m' &&(online.registerMod.searchBoxVals.multipleRound=v.toUpperCase() );
                validateRadio();
            };
        },
        submitValidate: function () {
            //formValidator = $(document).regMod("validate", "1.1")
            var submitBtn = online.$get("btnSearchFlight") || $("#fl_btnSearch")[0], scheduleBtn = $("#fl_btnFlightSchedule")[0];
            submitBtn && (submitBtn.disabled = false, submitBtn.style.display = "");
            scheduleBtn && (scheduleBtn.disabled = false, scheduleBtn.style.display = "");

            var NSTime = $("#fl_NSTime"), nowTime = NSTime.length > 0 ? new Date(NSTime.value) : new Date(),
                validateDomesticCity = [],
                nextYearTime = new Date(nowTime.getFullYear() + 1, nowTime.getMonth(), nowTime.getDate());

            var single = {
                txtDCity: get('txtDCity'),
                dest_city_1: get('dest_city_1'),
                txtDDatePeriod1: get('txtDDatePeriod1'),
                txtADatePeriod1: get('txtADatePeriod1')
            };
            //è·åå½ååå¸
            function isDomesticCity(name) {
                var re = new RegExp('\\|' + name.replace(/\(.+$/g, '') + '\\(');
                return re.test(flightintl_dest_cn);
            }

            function addDomesticCity(name) {
                !isDomesticCity(name) && (validateDomesticCity.push('T'));
            }

            var type = online.drpFlightWay!=null ? online.drpFlightWay.filter(':checked').value().toLowerCase() : 's',
                ddate = null,
                dcity = null,
                acity = null,
            //v = online.getValidate(),
                errorObj = null,
                errorNumber = 0,
                index = 0,
                second = 0,
                ddValue = '',
            //å¤ç¨åºåæ¥æãåºååå¸ãå°è¾¾åå¸
                m = ['#fl_txtDatePeriod', '#fl_txtBeginAddress', '#fl_txtEndAddress'];

            function validateSingle(type) {
                errorObj = null;

                dcity = single.txtDCity;
                if (online.isNull(dcity)) {
                    errorNumber = 9; errorObj = dcity; return false;
                }

                //ç®çå°åå¸
                acity = single.dest_city_1;
                ddValue = acity.value;
                if (online.isNull(acity)) {
                    errorNumber = 11; errorObj = acity; return false;
                }
                if (ddValue == dcity.value) {
                    errorNumber = 12; errorObj = acity; return false;
                }

                ddate = single.txtDDatePeriod1;
                if (online.isNull(ddate)) {
                    errorNumber = 10; errorObj = ddate; return false;
                }

                if (!ddate.value.isDate()) {
                    errorNumber = 4; errorObj = ddate; return false;
                } else {
                    ddValue = ddate.value.toDate();
                }
                if (ddValue < online.dateValue(nowTime)) {
                    errorNumber = 14; errorObj = ddate; return false;
                }
                if (ddValue > online.dateValue(nextYearTime)) {
                    errorNumber = 6; errorObj = ddate; return false;
                }
                //è¿åæ¥æ
                ddate = single.txtADatePeriod1;
                if (type == 'd') {
                    if (online.isNull(ddate)) {
                        online.drpFlightWay !=null &&(online.drpFlightWay[0].checked=true );
                    } else {
                        if (!ddate.value.isDate()) {
                            errorNumber = 4; errorObj = ddate; return false;
                        } else {
                            ddValue = ddate.value.toDate();
                        }
                        if (ddValue < single.txtDDatePeriod1.value.toDate()) {
                            errorNumber = 13; errorObj = ddate; return false;
                        }
                        if (ddValue > online.dateValue(nextYearTime)) {
                            errorNumber = 6; errorObj = ddate; return false;
                        }
                    }
                }
            }

            function validateMore() {
                var success = false, prevDateVal = null,moreflightMin=online.children($('#fl_flight_multiple')[0]).length;
                validateDomesticCity.length = 0;
                errorObj = null;
                for (var i = 1; i <= moreflightMin; i++) {
                    ddate = $(m[0] + i)[0];
                    dcity = $(m[1] + i)[0];
                    acity = $(m[2] + i)[0];
                    index = i;

                    //åºååå¸
                    ddValue = dcity.value;

                    //å¤æ­ç¬¬ä¸ç¨åçæ¯å¦éè¦éªè¯
                    if (i > 2 && (online.isNull(dcity) ) ) {
                        online.registerMod.searchBoxVals.moreflightMin=i-1;
                        break;
                    }

                    if (online.isNull(dcity)) {
                        errorNumber = 0; errorObj = dcity; break;
                    }
                    addDomesticCity(ddValue);

                    //å°è¾¾åå¸
                    ddValue = acity.value; //.replace(/\(.+$/g, '');

                    if (online.isNull(acity)) {
                        errorNumber = 1; errorObj = acity; break;
                    }
                    if (ddValue == dcity.value) {
                        errorNumber = 2; errorObj = acity; break;
                    }
                    addDomesticCity(ddValue);

                    //æ¥æéªè¯
                    if (online.isNull(ddate)) {
                        errorNumber = 3; errorObj = ddate; break;
                    }
                    if (!ddate.value.isDate()) {
                        errorNumber = 4; errorObj = ddate; break;
                    } else {
                        ddValue = ddate.value.toDate();
                    }
                    if (i == 1 && ddValue < online.dateValue(nowTime)) {
                        errorNumber = 5; errorObj = ddate; break;
                    }
                    if (prevDateVal && ddValue < prevDateVal) {
                        errorNumber = 7; errorObj = ddate; second = i - 1;
                        break;
                    }

                    if (ddValue > online.dateValue(nextYearTime)) {
                        errorNumber = 6; errorObj = ddate; break;
                    }
                    prevDateVal = ddValue;
                    errorObj = null;
                }
                //å¤æ­æ¯å¦æå½éèªç¨
                !errorObj && validateDomesticCity.length == 0 && (errorNumber = 8, errorObj = $(m[2] + 1)[0] );
                if (!errorObj) {
                    success = true;
                }
                return success;
            }

            return function () {
                var type = online.drpFlightWay !=null?online.drpFlightWay.filter(':checked').value().toLowerCase() : 's';

                if (!(type == 'm' ? validateMore() : validateSingle(type)) && errorObj) {
                    setTimeout(function(){
                        online.registerMod.validate($(errorObj),msg['ERROR_FLIGHT'][errorNumber].replace(/{number}/, msg.numberList[index - 1]).replace(/{second}/, msg.numberList[second - 1]));
                    },1);
                    return false;
                } else {
                    if (scheduleBtn) {
                        setTimeout(function () {
                            scheduleBtn.disabled = true;
                        }, 1);
                    }
                    $(window).bind("beforeunload", function () {
                        if (submitBtn) {
                            submitBtn.disabled = false;
                        }
                        if (scheduleBtn) {
                            scheduleBtn.disabled = true;
                        }
                    });
                    var el = $('#fl_txtAirline');
                    if (online.isNull(el[0])) $('#fl_Airline').value('All');
                    //end
                    online.searchWait.afterClick();
                    online.registerMod.saveSearchBoxVals();
                    online.clearNotice($("#fl_box_search input[mod]"));
                    //pageShowWindow();
                    return true;
                }
            };
        },
        SearchWait: function () {
            var WAIT_TIME = 10,
                TIPS_MESSAGER = msg['TIPS_MESSAGER'],
                WAIT_STATUS = 'waitStatus';

            this.timerStatus = null,
            this.waitStatus = $.cookie.get(WAIT_STATUS);
            this.beforeClick = function () {
                if (this.waitStatus != null) {
                    var startTime = this.waitStatus * 1,
                        endTime = new Date().getTime(),
                        waitTime = (endTime - startTime) / 1000;
                    if (waitTime < WAIT_TIME) {
                        alert(TIPS_MESSAGER);
                        return false;
                    }
                }
            };
            this.afterClick = function () {
                //ä¿å­ç¶æ
                $.cookie.set(WAIT_STATUS, null, new Date().getTime());
            };
        },
        //åç¨å¾è¿åå¸äºæ¢
        exchangeCity:function(first,last){
            var firstName = first[0].value.trim(),firstCodeObj=$('#'+first.attr('mod_address_reference') ),lastCodeObj=$('#'+last.attr('mod_address_reference') ),
                firstCode = firstCodeObj.value();

            first.value( last[0].value );
            firstCodeObj.value(lastCodeObj.value() );

            last.value(firstName);
            lastCodeObj.value(firstCode);
            //æ¿æ¢
            firstName = first.attr('mod_save_id');
            lastCodeObj = last.attr('mod_save_id');
            if(firstName && lastCodeObj){
                firstCode = online.registerMod.searchBoxVals[firstName];
                online.registerMod.searchBoxVals[firstName] = online.registerMod.searchBoxVals[lastCodeObj];
                online.registerMod.searchBoxVals[lastCodeObj] = firstCode;
            }

            first.value().trim()!='' &&(online.registerMod.clearNotice(first[0]) );
            last.value().trim()!='' &&(online.registerMod.clearNotice(last[0]) );
            online.registerMod.inits.notice[first.attr('id')].method('checkValue');
            online.registerMod.inits.notice[last.attr('id')].method('checkValue');
        },
        //éç½®å®¹å¨é«åº¦å®½åº¦
        resetindexSearchHeight:function(){
            var flt=$('#fl_options_flt_in'),mlh=flt[0].offsetHeight>0?'mltHeight':'height';
            //searchBox.attr('style','');boxpanel.attr('style','');searchBoxNav.attr('style','');
            if(online.drpFlightWay.filter(':checked').value()!='M'){
                online.animate(heightMap.d[0][mlh],heightMap.d[0].width);
                //searchBox.css('height',heightMap.d[0][mlh]+'px' );//.css('width',heightMap.d[0].width+'px');
                //searchBoxNav.css('height',heightMap.d[0][mlh]+'px');
                //boxpanel.css('height',heightMap.d[1][mlh]+'px');//.css('width',heightMap.d[1].width+'px');
            }else{
                //heightMap
                mltHeight = mltHeight<=0?0:mltHeight;

                online.animate(heightMap.m[0][mlh]+ mltHeight,heightMap.m[0].width);

                //searchBox.css('height',(heightMap.m[0][mlh] + mltHeight)+'px' );//.css('width',heightMap.m[0].width+'px');
                //searchBoxNav.css('height',(heightMap.m[0][mlh] + mltHeight)+'px');
                //boxpanel.css('height',(heightMap.m[1][mlh] + mltHeight)+'px');//.css('width',heightMap.m[1].width+'px');
            }
        },
        //æç´¢æ´å¤æ¡ä»¶ä¸æå±ç¤ºææ
        showMoreCondition:function(target,defaultHeight){

            $('#fl_advancedSearch').bind('click',function(){
                var fl_options_flt_in = $('#fl_options_flt_in'),type=online.drpFlightWay.filter(':checked').value(),height = mltHeight;
                //online.resetindexSearchHeight();
                //searchBox[type != 'M'?'removeClass':'addClass']('searchbox_flt_out_connect');
                //$(this).parents('div')[0].style.bottom='25px';
                //height = type!='M'?height+40:height;
                if($(this).hasClass('s_high_level_hover')){
                    fl_options_flt_in.hide();
                    online.resetindexSearchHeight();
                    $(this).removeClass('s_high_level_hover');
                    if(type == 'M'){
                        //searchBox.removeClass('searchbox_flt_out_connect');
                        /*if(mltHeight>0){
                            searchBox.css('height',(parseInt(searchBox.css('height'),10)-height)+'px' );
                            if($(boxpanel).hasClass('s_content') ){
                                $(boxpanel).css('height',(parseInt($(boxpanel).css('height'),10)-height)+'px' );
                                searchBoxNav.css('height',(parseInt(searchBox.find('.s_tab:eq(0)').css('height'),10 )-height)+'px' );
                            }
                        }*/

                        //online.oldHeight-=height;
                    }else{
                        //searchBox.removeClass('searchbox_flt_out');
                    }
                }else{
                    $(this).addClass('s_high_level_hover');
                    fl_options_flt_in[0].style.display='block';
                    online.resetindexSearchHeight();
                    //searchBox[type=='M'?'removeClass':'addClass']('searchbox_flt_out');
                    if(type == 'M'){
                        //searchBox.addClass('searchbox_flt_out_connect');
                        /*if(mltHeight>0){
                            searchBox.css('height',(parseInt(searchBox.css('height'),10)+height)+'px' );
                            if($(boxpanel).hasClass('s_content') ){
                                $(boxpanel).css('height',(parseInt($(boxpanel).css('height'),10)+height)+'px' );
                                searchBoxNav.css('height',(parseInt(searchBox.find('.s_tab:eq(0)').css('height'),10 )+height)+'px' );
                            }
                        }*/

                        //online.oldHeight+=height;
                    }else{
                        //searchBox.addClass('searchbox_flt_out');
                    }
                }
                online.resetindexSearchHeight();
            });
        }

    });

    $.ready(function(){

        var registerMod=$c('RegisterMod');
        online.registerMod=registerMod;


        //http://flights.big5.ctrip.com/
        //æ´æ°formè¡¨ååç´ 
        online.form[0].action=online.siteName+'international/SearchIndex.aspx';
        //è¿æ®µä»£ç æµè¯ç¨
        //$.mod.load("validate",registerMod.version['validate']);

        registerMod.registerAll($("#fl_box_search [mod]") );

        window.validateQuery = online.submitValidate();
        online.searchWait = new online.SearchWait();

        var voyageType = online.voyageType();
        voyageType();
        online.drpFlightWay.bind('click', voyageType.bind(this));

        //æ ¹æ®ipè·ååºååå¸
        online.registerMod.getFirstCityNameByIp($('#fl_txtDCity'));

        //æµè¯ä»£ç  moreCondition   ä¸æææ
        online.showMoreCondition();
        var keydownByCityInput = function(event){
            var target = event.target, btnSearchFlight = online.$get("btnSearchFlight"),
                key = !isNaN(event.keyCode) ? event.keyCode : event.charCode;

            if (key == '13') {
                event.preventDefault ? event.preventDefault() : event.returnValue = false;
                if (target.nodeName == 'INPUT' && target.getAttribute('type').toLowerCase() == 'radio') {
                    $('#' + (target.value != 'M' ? 'fl_txtDCity' : 'fl_txtBeginAddress1'))[0].focus();
                    return false;
                }
                if(target.nodeName.toLowerCase() == 'input' && target.getAttribute('type')=='submit'){
                    btnSearchFlight.click();
                    return false;
                }
                if (target.nodeName.toLowerCase() == 'input') {
                    //mod_address_focusnext
                    var nextElement = $(target).attr('mod_address_focusnext') || $(target).attr('mod_calendar_focusnext');
                    if(nextElement){
                        var next = '';
                        if(nextElement!='true'&&nextElement!='false' ){
                            next = nextElement.match('~')!=null?$('#'+nextElement.split('~')[1])[0]:$('#'+nextElement)[0];
                        }else{
                            next = online.next(online.parent(target) );
                            if(online.hasClass(next,'online_label')){
                                next = $(next).find('input:eq(0)')[0];
                            }else{
                                var tmp = online.next(online.parent(online.parent(target)));
                                next = tmp?$(tmp ).find('.online_label:eq(0) input:eq(0)')[0]:null;
                            }
                        }

                        if(next && next.offsetHeight>0){
                            setTimeout(function () {
                                next.focus();
                                next.select();
                                target.blur();
                            },1);

                            return false;
                        }else{
                            setTimeout(function () {
                                target.blur();
                                btnSearchFlight.focus();
                                btnSearchFlight.click();
                            },1);
                        }

                    }else{
                        setTimeout(function () {
                            target.blur();
                            btnSearchFlight.focus();
                            btnSearchFlight.click();
                        },1);
                    }
                } else {
                    btnSearchFlight.focus();
                }
            }
        };

        $c('Multipass',{
            addCallback:function(addChild){
                addChild.find('input').bind('keydown',keydownByCityInput.bind(this),{ priority: 13 });
                var height=42;
                if(this.index>3){
                    mltHeight = mltHeight<=0?0:mltHeight;
                    var flt=$('#fl_options_flt_in'),mlh=flt[0].offsetHeight>0?'mltHeight':'height';
                    /*searchBox.css('height',(heightMap.m[0][mlh] + mltHeight+height)+'px' ).css('width',heightMap.m[0].width+'px');
                    searchBoxNav.css('height',(heightMap.m[0][mlh] + mltHeight+height)+'px');
                    boxpanel.css('height',(heightMap.m[1][mlh] + mltHeight+height)+'px').css('width',heightMap.m[1].width+'px');*/
                    online.animate(heightMap.m[0][mlh] + mltHeight+height,heightMap.m[0].width);
                    mltHeight+=height;
                }
            },
            removeCallback:function(){
                var height=42;
                if(this.index>3){
                    mltHeight = mltHeight<=0?0:mltHeight;
                    var flt=$('#fl_options_flt_in'),mlh=flt[0].offsetHeight>0?'mltHeight':'height';
                    /*searchBox.css('height',(heightMap.m[0][mlh] + mltHeight-height)+'px' ).css('width',heightMap.m[0].width+'px');
                    searchBoxNav.css('height',(heightMap.m[0][mlh] + mltHeight-height)+'px');
                    boxpanel.css('height',(heightMap.m[1][mlh] + mltHeight-height)+'px').css('width',heightMap.m[1].width+'px');*/
                    online.animate(heightMap.m[0][mlh] + mltHeight-height,heightMap.m[0].width);
                    mltHeight-=height;
                }
            },
            'i18n':online.msg.MULTIPASS
        });
        /**åè½¦ææ*/
        $("#fl_box_search input:not([id='fl_txtAirline']),#fl_box_search select").bind('keydown',keydownByCityInput.bind(this), { priority: 13 });
        //åå¸äºæ¢åè½
        $('#fl_exchangeCity').bind('click',online.exchangeCity.bind(this,$('#fl_txtDCity'),$('#fl_dest_city_1') ));
		$('#fl_txtADatePeriod1').bind('change',function(){
			if($(this).value().trim()!=''){
				online.drpFlightWay.filter("[value='D']")[0].checked=true;
				$(online.parent(this)).removeClass('s_disable');
			}else if(online.drpFlightWay.filter(':checked')[0].value.toLowerCase()=='s' &&$(this).value().trim()=='' ){
				$(online.parent(this)).addClass('s_disable');
			}
		});
    });
    window.online=online;
})(cQuery);/*****env:3,update:2013-5-23 19:55:59*****//*****env:4,update:2013-6-10 3:30:10*****//*****env:4,update:2013-9-3 14:06:03*****/