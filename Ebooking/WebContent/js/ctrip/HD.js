//部署于大首页，用于国内酒店业务区块
(function ($) {
    /******* BASE PART *******/

    var MOD = {}, // namespace for mods
        BASE_URL = document.domain.replace(/www/i, 'http://hotels');

    MOD.globalForm = {
        form: document.getElementById('chinaHotelForm'),
        submit: function (url, target) {
            var fm = this.form;

            fm.action = url;
            fm.target = target || "_self";
            //.net webform 自带的
            if (fm.__VIEWSTATE) fm.__VIEWSTATE.name = "NOVIEWSTATE";
            fm.submit();
        }
    };
    /******* BASE PART *******/


    /*国内酒店搜索框配置BEGIN*/
    window.__uidc_init = new Date * 1;
    window.parseRawData = function () { };
    var fm = document.getElementById('chinaHotelForm');
    var MAX_STAY = 28 * 24 * 3600 * 1000;
    //备用config(简体)
    var addressMessageConfig = {
        cityname: {
            suggestionB: '支持中文/拼音/简拼输入',
            suggestion: "<strong>热门城市</strong>（可直接选择城市或输入城市全拼/简拼）"
        },
        searchHistory: '搜索历史',
        addressTab: "省市",
        hotelPos: {
            suggestion: "可直接选择地理位置或输入位置关键词",
            titles: {
                "zone": "商业区",
                "location": "行政区",
                "metro": "地铁线"
            },
            showAMap: false,
            AMapTitle: '查看商业区地图',
            all: '全部',
            subCity: '下辖市/县：'
        },
        suggestTitle: ["名称", "机场火车站", "位置"],
        defaultValue: ['上海', '2', 'shanghai']
    };
    var validateMessageConfig = {
        hotel: {
            city: '请选择酒店所在城市',
            checkIn: '请选择入住日期',
            checkOut: '请选择离店日期',
            dateErr: '日期格式为yyyy-mm-dd',
            too_early_in: '入住日期不能早于今天',
            too_early_out: '您选择的离店日期早于/等于入住日期，请重新选择',
            too_long: '您入住酒店时间超过28天，请分订单提交预订',
            no_room: '您选择的日期没有房间可供预订!',
            room_num: '请选择预订房间数'
        }
    };
    var noticeMessageConfig = ['中文/拼音'];
    //HD_HOTEL_CONFIG为页面config，使用页面config覆写当前config
    if (window.HD_HOTEL_CONFIG) {
        if (HD_HOTEL_CONFIG.addressMessageConfig) {
            addressMessageConfig = HD_HOTEL_CONFIG.addressMessageConfig;
        }
        if (HD_HOTEL_CONFIG.validateMessageConfig) {
            validateMessageConfig = HD_HOTEL_CONFIG.validateMessageConfig;
        }
        if (HD_HOTEL_CONFIG.noticeMessageConfig) {
            HD_HOTEL_CONFIG = HD_HOTEL_CONFIG.noticeMessageConfig;
        }
    }

    /*国内酒店搜索框配置END*/
    // 从公共服务提供的隐藏域中获取如下信息来判断跳转的域名：
    // <input type="hidden" id="solution" value="PRO|GB"/>
    // PRO: 生产, UAT UAT, TEST: 测试
    // GB: 简体版, BIG5: 繁体版, HK: 香港版
    var envObj = {
        'PRO': {
            'GB': 'http://hotels.ctrip.com',
            'HK': 'http://hotels.ctrip.com.hk',
            'BIG5': 'http://hotels.big5.ctrip.com'
        },
        'UAT': {
            'GB': 'http://hotels.uat.sh.ctriptravel.com',
            'HK': 'http://hotels.big5.uat.sh.ctriptravel.com',
            'BIG5': 'http://hotels.big5.uat.sh.ctriptravel.com'
        },
        'TEST': {
            'GB': 'http://hotels.testp.sh.ctriptravel.com',
            'HK': 'http://hotels.big5.testp.sh.ctriptravel.com',
            'BIG5': 'http://hotels.big5.testp.sh.ctriptravel.com'
        }
    };
    var HD_cookieName = {
        'GB': 'HotelCityID',
        'HK': 'BHotelCityID',
        'BIG5': 'BHotelCityID'
    };
    var ENV = 'http://hotels.ctrip.com';
    var solution = document.getElementById('solution');
    var arrEnv = solution && solution.value && solution.value.toUpperCase().split('|');
    if (arrEnv && arrEnv.length) {
        ENV = envObj[arrEnv[0]][arrEnv[1]];
    }

    /**
    * set positionArea and positionId
    */
    function setLocationHiddens(dataUrl) {
        var positionArea = $('#positionArea'),
            positionId = $('#positionId'),
            regxp = /(zone|location|l|s|sl)(\d+)\w*/i,
            urls = dataUrl.replace('http\:\/\/', '').split('/');

        var data = regxp.exec(urls[urls.length - 1]) || {};
        positionArea.value(data[1] || '');
        positionId.value(data[2] || '');
    }
    window.JSONP_POS_RESPONSE = ''; //searchImprove
    /*
    * send ajax with keyword
    *@require {String} JSONP_POS_RESPONSE 依赖全局变量 JSONP_POS_RESPONSE
    *@param {Object} ops.KEYWORD_INPIT 关键词搜索框
    *@param {Object} ops.URL ajax提交地址
    *@param {Object} ops.CITYID_HIDDEN_INPUT etc. 各种input隐藏域value
    */
    var sendAjaxWithKeyword = function (ops) {
        ops = ops || {};
        var parseJsonpPosCallback = function (ret) {
            var returnObj = {};
            if (!ret) {
                return returnObj;
            }
            var tempArr = ret.split(/@/);
            for (var i = 0; i < tempArr.length; i++) {
                var tempArrI = tempArr[i].split('|');
                var hotelName = tempArrI[1];
                returnObj[hotelName] = {
                    pinyin: tempArrI[0],
                    keywordClick: tempArrI[2],
                    type: tempArrI[3]
                };
            }
            return returnObj;
        }
        var imgGet = function (url) {
            var imgTemp = new Image();
            imgTemp.src = url;
            imgTemp = null;
        }
        var returnObj = {};
        var options = $.extend({
            KEYWORD_INPIT: 'HD_TxtKeyword',
            URL: 'http://hotels.ctrip.com/Domestic/Tool/AjaxImpressionLog.aspx',
            CITYID_HIDDEN_INPUT: 'HD_CityId',
            STAR_HIDDEN_INPUT: 'searchHotelLevelSelect',
            KEYWORD_HIDDEN_INPUT: 'hotelAreaName'
        }, ops);
        var paramPool = parseJsonpPosCallback(JSONP_POS_RESPONSE);
        var context = {};
        var val = document.getElementById(options.KEYWORD_INPIT) ? document.getElementById(options.KEYWORD_INPIT).value : '';
        var param = paramPool[val];
        var tempArr = [];
        var tarUrl = options.URL;
        if (!param) {
            return returnObj;
        }
        context.type = param.type || '';
        context.keywordclick = param.keywordClick || '';
        if (!context.type) {
            return false;
        }
        context.url = encodeURIComponent(window.location.href);
        context.city = document.getElementById(options.CITYID_HIDDEN_INPUT) ? document.getElementById(options.CITYID_HIDDEN_INPUT).value : '';
        context.star = document.getElementById(options.STAR_HIDDEN_INPUT) ? document.getElementById(options.STAR_HIDDEN_INPUT).value : '';
        context.keyword = escape(document.getElementById(options.KEYWORD_HIDDEN_INPUT) ? document.getElementById(options.KEYWORD_HIDDEN_INPUT).value : '');
        context.version = '1.0';
        if (!$.isEmptyObject(context)) {
            for (k in context) {
                tempArr.push(k + '=' + context[k]);
            }
            tarUrl += '?' + tempArr.join('&');
        }
        imgGet(tarUrl);
    }

    $.getJsonp = (function () {
        var _i = 0;
        return function (url, callback) {
            var cb = '_json' + _i++;
            var head = document.getElementsByTagName('head')[0];
            var script = document.createElement('script');
            script.charset = 'utf-8';
            script.src = url + '?callback=' + cb;
            head.appendChild(script);

            window[cb] = function (json) {
                callback(json);
                head.removeChild(script);
                window[cb] = null;
            };
        };
    })();
    var HOTEL_POSITION = {
        dataCash: {
            idFrom1To10: false,
            idFrom11To200: false,
            idFrom201ToMax: false,
            error: true
        }
    };
    var CITYENTER = true;
    MOD.defaultSuggestionInit = function (obj) {
        /**
        *  代码拷自addresss组件，实现tab切换，
        *  因为address组件只要用户配置了suggestionInit,  就不触发组件自己的suggestionInit，失去了tab切换功能
        */
        //must be opti
        var spans = obj.find('.tab_box li');
        var uls = obj.find('div.city_item');
        if (!spans.length) {
            return;
        }

        function switchTab() {
            var _this = this;
            spans.each(function (span, i) {
                if (span[0] == _this) {
                    span.addClass('selected');
                    uls[i].style.display = '';
                } else {
                    span.removeClass('selected');
                    uls[i].style.display = 'none';
                }
            });
        }

        var w = 30;
        for (var i = 0, n = spans.length; i < n; i++) {
            w += spans[i].offsetWidth;
        }

        var t = obj.find('div').first();
        if (t[0]) {
            if (w > 278) {
                t.css('width', '378px');
            }
        }

        spans.bind('mousedown', switchTab);
        switchTab.apply(spans[0]);
    }
    MOD.hotelNamePreHtml = ''; // prepare for close button on pad

    function checkExist(pid, key) {
        if (typeof HOTEL_POSITION[pid] == "undefined") { HOTEL_POSITION[pid] = {}; HOTEL_POSITION[pid][key] = (key === "zone" ? {} : []); HOTEL_POSITION[pid]['all'] = []; }
        if (typeof HOTEL_POSITION[pid][key] == "undefined") { HOTEL_POSITION[pid][key] = []; }
        return true;
    }
    /**
    * highlight keyword
    * {String} str
    * {string} words, words need to be highlight
    */
    cQuery.highlightKeyword = function (str, words) {
        if (!words) return str;
        words = words.split(/\s+/);
        words.each(function (word) {
            //highlight only chinese
            /[a-zA-Z]/.test(word) || (str = str.replace(new RegExp('(' + word + ')', 'gi'), "<span class='b'>$1</span>"))
        });
        return str;
    }

    ; (function (WIN, $) {
        var isIE = $.browser.isIE,
            positionId = $('#positionId'),
            positionArea = $('#positionArea'),
            searchKeyword = $('#hotelAreaName'),

        /**
        * 数据层地标分7种类型, 界面显示分3大组，查询时拼URL又分5种类型
        * typeMap存储7类对应5类的关系

        */

            markerTypeMap = {
                //名称
                //酒店，
                hotel: {
                    search: '',
                    view: 'name'
                },
                //酒店集团
                hotelgroup: {
                    search: '',
                    view: 'name'
                },
                //酒店品牌
                hotelbrand: {
                    search: '',
                    view: 'name'
                },

                //位置：
                // 地标 landmardId
                markland: {
                    search: 'sl',
                    view: 'position'
                },
                // 地铁站
                metrostation: {
                    search: 's',
                    view: 'position'
                },
                // 商业区
                zone: {
                    search: 'zone',
                    view: 'position'
                },
                //行政区
                location: {
                    search: 'location',
                    view: 'position'
                },
                //地铁线
                metro: {
                    search: 'l',
                    view: 'position'
                },

                // 机场火车站：
                airport: {
                    search: 'sl',
                    view: 'station'
                }, // 机场
                railwaystation: {
                    search: 'sl',
                    view: 'station'
                }
            };
        WIN.markerTypeMap = markerTypeMap; //be global temporary
        var RegMod = function (options) {
            this.init(options);
            this.startLoadMods();
            this.initNotice();
            this.initAddress();
            if (this.ops.startDate.length && this.ops.endDate.length) {
                this.initCalendar(this.ops.startDate, this.ops.endDate);
            }
            if (this.ops.checkInDate.length && this.ops.checkOutDate.length) {
                this.initCalendar(this.ops.checkInDate, this.ops.checkOutDate);
            }
            this.initValidate();
        }

        /**
        * set jsonpFilter and jsonpSource dynamicly
        * @param {String|int} id, city id
        * @param {Address} keyword, instance of Address
        */
        function setKeywordJsonpUrl(keyword, id) {
            var rCityId = /\$\{cityId\}/g;

            keyword.set('jsonpFilter', id ? cQuery.keywordJsonpFilterTpl.replace(rCityId, id || '') : undefined);
            keyword.set('jsonpSource', id ? cQuery.keywordJsonpSourceTpl.replace(rCityId, id || '') : undefined);
        };

        WIN.setKeywordJsonpUrl = setKeywordJsonpUrl; //must be global
        /**
        * add style element for iframe
        * be used when city selector appearing, to improve performance in IEs
        * @param {cDOM} a, wrap element
        */
        function addIframeStyle(a) {
            var doc = a[0].ownerDocument,
            stylesheet = doc.createElement('link');

            stylesheet.type = "text/css";
            stylesheet.rel = 'stylesheet';
            stylesheet.href = 'http://webresource.c-ctrip.com/styles/common/c_address.css';
            doc.getElementsByTagName('head')[0].appendChild(stylesheet);
        }
        /**
        * @param {Address} mod
        * @param {Object} data
        */
        function keywordItemChangeHandler(mod, data) {
            var dataArr = data.data.split('|'),
            EMPTY = '',
            category;

            //set positionArea, positionId
            positionId.value(dataArr[2] || EMPTY);

            searchKeyword.value(data.value);
            positionArea.value(dataArr[3] || EMPTY);
        }
        /**
        * select markers, according to bussiness rule
        * privilege rank: name -> position -> station
        * total number: 15
        * @param {Object} data, origin data
        * returns {Object}, filtered data
        */
        function fitMarkerDataToDisplay(data) {

            return filterData(data, 15, 5);
        }
        function filterData(data, total, standard) {
            var i,
            offset = 0,
            item,
            filtered = {};

            for (i in data) {
                item = data[i];
                offset += Math.max(standard - item.length, 0);
            }

            for (i in data) {
                item = data[i];
                a = item.length;
                item = filtered[i] = item.slice(0, offset ? Math.max(standard + offset, standard) : standard);
                offset && (offset = Math.max(offset - (Math.max(item.length - standard, 0)), 0));
            }
            return filtered;
        }
        function groupMarkerData(data) {
            var rs = {
                name: [],
                station: [],
                position: []
            },
        map = markerTypeMap,
        SPLIT_STR = '|';
            data.each(function (item) {
                var arrItem = item.data.split(SPLIT_STR),
                type = arrItem[3].toLowerCase(),
                types = map[type];

                rs[types.view].push(item);
            });
            //console.log(rs);
            return fitMarkerDataToDisplay(rs);
        }
        //groupMarkerData must be global accessable, cuz it is used in 'tmpl'
        cQuery.groupMarkerData = groupMarkerData;
        $.extend(RegMod.prototype, {
            init: function (options) {
                this.ops = {
                    city: [],
                    startDate: [],
                    endDate: [],
                    keyword: [],
                    // hotelPos: [],
                    // hotelName: [],
                    checkInDate: [],
                    checkOutDate: [],
                    offsetPos: 5
                };
                this.ops = $.extend(this.ops, options);
            },
            startLoadMods: function () {
                var modConfig = {
                    adFrame: "1.0",
                    address: "1.0",
                    allyes: "1.0",
                    calendar: "3.0",
                    notice: "1.0",
                    tab: "1.2",
                    toggle: "1.0",
                    validate: "1.1"
                };
                $.mod.multiLoad(modConfig, function () { });
            },
            initValidate: function () {
                MOD.formValidator = positionId.regMod("validate", "1.1");
            },
            //init keyword input and selection panel
            initKeyword: function () {
                var keyword = this.ops.keyword,
                cityId = $('#HD_CityId').value(),
                charset = cQuery.config("charset");
                var filterTemp = '' +
            '<div class="keyword_prompting_lhsl">' +
            '   {{if (newlist = cQuery.groupMarkerData(list))}}{{/if}}' +
            '   {{if ((names = newlist.name).length)}}' +
            '   <div class="keyword_block">' +
            '      <span class="title">' + addressMessageConfig.suggestTitle[0] + '</span>' +
            '      {{each (i,item) names}}' +
            '      <a href="javascript:;" data="${data}">{{if (txt=cQuery.highlightKeyword(right, cQuery.keywordFilterHighlights[val])) }}${txt}{{/if}}</a>' +
            '      {{/each}}' +
            '   </div>' +
            '   {{/if}}' +

            '   {{if ((stations = newlist.station).length)}}' +
            '   <div class="keyword_block">' +
            '      <span class="title">' + addressMessageConfig.suggestTitle[1] + '</span>' +
            '       {{each (i,item) stations}}' +
            '       <a href="javascript:;" data="${data}">{{if (txt=cQuery.highlightKeyword(right, cQuery.keywordFilterHighlights[val])) }}${txt}{{/if}}</a>' +
            '       {{/each}}' +
            '   </div>' +
            '   {{/if}}' +
            '   {{if ((positions = newlist.position).length)}}' +
            '   <div class="keyword_block">' +
            '       <span class="title">' + addressMessageConfig.suggestTitle[2] + '</span>' +

            '       {{each (i,item) positions}}' +
            '       <a href="javascript:;" data="${data}">{{if (txt=cQuery.highlightKeyword(right, cQuery.keywordFilterHighlights[val])) }}${txt}{{/if}}</a>' +
            '       {{/each}}' +
            '   </div>' +
            '   {{/if}}' +
            '</div>';
                var suggestionStyle = '' +
            '.key_word_lhsl { width:498px; padding:8px 10px; border:1px solid #999; background-color:#fff; }' +
            '.key_word_key{height:30px;} ' +
            '.ico_key,.ico_unkey{ width:39px; height:25px; background:url(http://pic.c-ctrip.com/ctripOnPad/un_key.png) no-repeat; -webkit-transform:scale(.7);margin-left:-5px;cursor:pointer;} ' +
            '.ico_unkey{background-position:0 -28px;}' +
            '.key_word_lhsl .close { float:right; width:20px; height:20px; color:#666; text-align:center; font:bold 16px/20px Simsun; }' +
            '.key_word_lhsl .close:hover { text-decoration:none; color:#FFA800; }' +
            '.key_word_lhsl .key_word_list { margin-bottom:6px; }' +
            '.key_word_lhsl .key_word_list dt { font-weight:bold; }' +
            '.key_word_lhsl .key_word_list dd { display:inline-block; }' +
            '.key_word_lhsl .key_word_list dd {display:block;overflow:hidden;}' +
            '.key_word_lhsl .key_word_list a { float:left; height:22px; padding:0 15px 0 5px; border:1px solid #fff; line-height:22px; white-space:nowrap; }' +
            '.key_word_lhsl .key_word_list a:hover { border:1px solid #ACCCEF; background-color:#E8F4FF; text-decoration:none; }' +
            '.key_word_lhsl .keyword_sub_city { margin:0 -10px -8px; padding:5px 10px; border-top:1px solid #CCC; background-color:#F3F3F3; color:#333; } .key_word_lhsl .keyword_sub_city a { margin-right:10px; color:#4D4D4D; }';
                var suggestionStyleIPad = suggestionStyle + '#union li{float:none;height:14px;width:auto;} .key_word_lhsl .keyword_sub_city a { margin-right:10px; color:#4D4D4D; } .key_word_lhsl_pad .key_word_key { display:block; }';
                suggestionStyle += '#union li{float:none;height:14px;width:auto;} .key_word_lhsl .keyword_sub_city a { margin-right:10px; color:#4D4D4D; } .key_word_lhsl_pad .key_word_key { display:block; }';
                var filterStyle = '' +
            '.keyword_prompting_lhsl { width:358px; border:1px solid #999; background-color:#fff; }' +
            '.keyword_prompting_lhsl .keyword_block { margin-top:-1px; padding:4px 0; border-top:1px solid #ccc; }' +
            '.keyword_prompting_lhsl .keyword_block .title { float:right; margin-right:10px; color:#666; }' +
            '.keyword_prompting_lhsl .keyword_block a { display:block; width:310px; height:24px; padding-left:10px; font-size:14px; line-height:24px; font-family:"Microsoft YaHei"; color:#555; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; }' +
            '.keyword_prompting_lhsl .keyword_block a:hover, .keyword_prompting_lhsl .keyword_block .hover { background-color:#E8F4FF; text-decoration:none; }' +
            '.keyword_prompting_lhsl .keyword_block .b { color:#06c; }';
                cQuery.keywordFilterHighlights = {};
                /**
                * jsonp callback for keyword search
                * @param {String} ret, search result
                */
                cQuery.jsonpPosCallback = function (ret) {
                    var result = ret.result,
                    keywordVal = keyword.value();

                    //words need to be highlighted
                    cQuery.keywordFilterHighlights[keywordVal] = ret.tokens;
                    cQuery.jsonpResponse = { key: keywordVal, data: '@' + ret.result + '@' };
                    JSONP_POS_RESPONSE = result; //searchImprove
                };
                $.keywordJsonpFilterTpl = ENV + '/Domestic/Tool/AjaxFindKeyword.aspx?failedCallback=cQuery.jsonpPosFailedCallback&query=cityId:${cityId} AND keyword:"${key}" AND sourceType:DomesticHotel &return=pinyin,word,ID,type&section=1-30&noTotal=true&responseFormat=json&needTokens=true&resultFormat=text&lineSep=@&fieldSep=|&charset=' + charset + '&callback=cQuery.jsonpPosCallback';
                $.keywordJsonpSourceTpl = ENV + '/Domestic/Tool/AjaxGetHotKeyword.aspx?cityid=${cityId}';

                //init placeholder for keyword
                MOD.n_keyword = keyword.regMod("notice", "1.0", {
                    name: "keyword",
                    tips: keyword[0].getAttribute('_cqnotice'),
                    selClass: "inputSel"
                });

                MOD.a_keyword = keyword.regMod('address', '1.0', {
                    name: "keyword",
                    source: '@@',
                    isFocusNext: !1,
                    isIframe: isIE,
                    delay: 500,
                    isFilterSelect: false,
                    isAutoCorrect: false,
                    template: {
                        //filterPageSize:-1,
                        filterPageSize: 20,
                        suggestion: '{{if (data)}}<div class="c_address_box key_word_lhsl">' +
                                    '<a href="javascript:;" class="close">×</a>' +
                                    ' {{enum(key, item) data}}' +
                                    ' {{if key==="subCity"}}' +
                                    ' <div class="keyword_sub_city">' +
			                            ' ${item.cnname}：{{if (item.data)}}{{each item.data}}<a href="' + BASE_URL + '/hotel/${ename}${id}" class="subCity" data-dopost="T">${name}</a>{{/each}}{{/if}}' +
		                            ' </div>' +
                                    ' {{else}}' +
                                    ' <dl class="key_word_list">' +
                                    ' <dt>${item.cnname}</dt>' +
                                    ' <dd>{{if (item.data)}}{{each item.data}}<a href="javascript:void(0);" data="|${name}|${id}|${type}|" data-category="${key}">${name}</a>{{/each}}{{/if}}</dd>' +
                                    ' </dl>' +
                                    ' {{/if}}' +
                                    ' {{/enum}}' +
                                    '</div>{{/if}}',

                        suggestionIpad: '{{if (data)}}<div class="c_address_box key_word_lhsl">' +
                                    '<a href="javascript:;" class="close" id="mini_c_address_close">×</a>' +
                                    '<div class="key_word_key"> ' +
                                    '   <div class="ico_key" id="pad_mini_keyboard"></div> ' +
                                    '</div> ' +
                                    ' {{enum(key, item) data}}' +
                                    ' {{if key==="subCity"}}' +
                                    ' <div class="keyword_sub_city">' +
			                            ' ${item.cnname}：{{if (item.data)}}{{each item.data}}<a href="' + BASE_URL + '/hotel/${ename}${id}" class="subCity" data-dopost="T">${name}</a>{{/each}}{{/if}}' +
		                            ' </div>' +
                                    ' {{else}}' +
                                    ' <dl class="key_word_list">' +
                                    ' <dt>${item.cnname}</dt>' +
                                    ' <dd>{{if (item.data)}}{{each item.data}}<a href="javascript:void(0);" data="|${name}|${id}|${type}|" data-category="${key}">${name}</a>{{/each}}{{/if}}</dd>' +
                                    ' </dl>' +
                                    ' {{/if}}' +
                                    ' {{/enum}}' +
                                    '</div>{{/if}}',
                        suggestionStyle: suggestionStyle,
                        suggestionStyleIpad: suggestionStyleIPad,
                        filter: filterTemp,
                        filterIpad: filterTemp,
                        filterStyle: filterStyle,
                        filterStyleIpad: filterStyle,
                        //list:{left:'1',right:'2',data:'3'},
                        /**
                        * suggestionInit for keyword
                        * @param {DOM} a, dropdown panel
                        */
                        suggestionInit: function (a) {
                            MOD.defaultSuggestionInit(a);
                            //add css for suggest
                            isIE && addIframeStyle(a);
                            a.find('.close').bind('mousedown', function () {
                                keyword[0].blur();
                            })
                            a.find('#pad_mini_keyboard').bind('click', function () {
                                var target = keyword[0];
                                var isShowKB = keyword[0].getAttribute('readonly') != 'readonly';

                                if (isShowKB) {
                                    target.setAttribute("readonly", "readonly");
                                    this.className = 'ico_key';

                                } else {
                                    target.removeAttribute('readonly');
                                    this.className = 'ico_unkey';
                                }
                                target.blur();
                                target.select();
                                target.focus();
                            });
                            //下辖市等链接点击跳转到列表页
                            a.find('a[data-dopost="T"]').bind('mousedown', function (e) {
                                var target = this;
                                setTimeout(function () {
                                    MOD.globalForm.submit(target.getAttribute('href'), target.getAttribute('target'));
                                }, 0);

                            });
                        } .bind(this)
                    }
                });
                MOD.a_keyword.method('bind', 'change', keywordItemChangeHandler);

                cityId && setKeywordJsonpUrl(MOD.a_keyword, cityId); //set url of jsonp request for keyword filter
                //MOD.n_keyword.method("checkValue");

                keyword.bind('blur', function () {
                    if (!this.value || this.value != searchKeyword.value()) {
                        searchKeyword.value(this.value);
                        positionId.value("");
                        positionArea.value("");
                    }
                });
                //support enter key submit;
                keyword.bind('focus', function () {
                    CITYENTER = true;
                }).bind('keyup', function (e) {
                    e.stop();
                    if (e.keyCode == 13) {
                        keyword[0].blur();
                        setTimeout(function () {
                            $('#HD_Btn').trigger('click');
                        }, 500);

                    }
                })
            },
            initAddress: function () {
                var suggestionStyle = '\
					.city_select_pad .ico_key, .city_select_pad .ico_unkey {position: absolute; top: 7px; left: 3px; display: block; width: 39px; height: 25px; background: url(http://pic.c-ctrip.com/ctripOnPad/un_key.png) no-repeat; -webkit-transform: scale(.7); }\
                    .city_select_pad .title {margin: 0 0 0 30px; }\
					.city_select_lhsl { width:378px; padding:10px; border:1px solid #999; background-color:#fff; }\
					.city_select_lhsl .close { float:right; width:20px; height:20px; color:#666; text-align:center; font:bold 16px/20px Simsun; }\
					.city_select_lhsl .close:hover { text-decoration:none; color:#FFA800; }\
					.city_select_lhsl .title { margin-bottom:10px; color:#999; }\
					.city_select_lhsl .tab_box { width:100%; height:22px; margin-bottom:6px; border-bottom:2px solid #ccc; } \
					.city_select_lhsl .tab_box li { position:relative; float:left; display:inline; margin-right:2px; line-height:22px; cursor:pointer; }\
					.city_select_lhsl .tab_box li span { padding:0 8px; }\
					.city_select_lhsl .tab_box .selected { border-bottom:2px solid #06c; margin-bottom:-2px; font-weight:bold; color:#06c; }\
					.city_select_lhsl .city_item { display:inline-block; }\
					.city_select_lhsl .city_item { display:block; overflow:hidden; }\
					.city_select_lhsl .city_item a { float:left; display:inline; width:52px; height:22px; margin:0 2px 2px 0; padding-left:8px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; line-height:22px; color:#333; }\
					.city_select_lhsl .city_item a:hover { background-color:#2577E3; text-decoration:none; color:#fff; }\
					.city_select_lhsl .sarch_history_title { margin-bottom:2px; font-weight:bold; color:#06c; }\
					.city_select_lhsl .search_history_box { display: block; overflow: hidden; margin-bottom:10px; }\
					.city_select_lhsl .search_history_box a { float:left; display:inline; width:52px; height:22px; margin:0 2px 2px 0; padding-left:8px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; line-height:22px; color:#333; }\
					.city_select_lhsl .search_history_box a:hover { background-color:#2577E3; text-decoration:none; color:#fff; }'

                if (this.ops.city.length) {
                    var city = this.ops.city;
                    var checkin = this.ops.startDate;
                    var checkout = this.ops.endDate;
                    var searchHistoryList = '';
                    var timer = setTimeout(function () {
                        initCity();
                    }, 2000);
                    function initCity() {
                        MOD.a_city = city.regMod("address", "1.0", {
                            name: "cityname",
                            jsonpSource: "http://webresource.c-ctrip.com/code/cquery/resource/address/hotel/online/city_20130427_" + cQuery.config("charset") + ".js?v=" + $('#_releaseNo_').value(), //city_20130427_gb2312.js带酒店数量的数据源
                            isFocusNext: !1,
                            isAutoCorrect: !0,
                            isIframe: isIE,
                            relate: {
                                id: $("#HD_CityId"),
                                name_py: $("#HD_CityPy")
                            },
                            sort: ['^0$', '^1$', '0+'],
                            sortFunction: function (a, b) {
                                return b.data.split('|')[8] - a.data.split('|')[8]
                            },
                            template: {
                                suggestion: '<div class="city_select_lhsl">' +
                                            '<a class="close" href="javascript:;">×</a>' +
                                            '<p class="title">' + addressMessageConfig.cityname.suggestionB + '</p>' + searchHistoryList +
                                            '<ul class="tab_box">{{enum(key) data}}<li><span>${key}</span></li>{{/enum}}</ul>' +
                                            '{{enum(key,arr) data}}' +
                                            '<div class="city_item">' +
                                                '{{each arr}}<a href="javascript:void(0);" data="${data}">${display}</a>{{/each}}' +
                                            '</div>' +
                                            '{{/enum}}' +
                                        '</div>',
                                suggestionIpad: '<div class="city_select_lhsl city_select_pad">' +
                                            '<a class="close" href="javascript:;" id="mini_c_address_close">×</a>' +
                                            '<p class="title">' + addressMessageConfig.cityname.suggestion + '</p>' + searchHistoryList +
                                            '<ul class="tab_box">{{enum(key) data}}<li><span>${key}</span></li>{{/enum}}</ul>' +
                                            '{{enum(key,arr) data}}' +
                                            '<div class="city_item">' +
                                                '{{each arr}}<a href="javascript:void(0);" data="${data}">${display}</a>{{/each}}' +
                                            '</div>' +
                                            '{{/enum}}' +
                                            '<a href="javascript:void(0)" class="ico_key" id="mini_c_address_keyboard"></a>' +
                                        '</div>',
                                filter: '<div class="city_prompting_lhsl">' +
                                        '{{if !hasResult}}<p class="not_found">{{tmpl message.noFilterResult}}</p>{{/if}}' +
                                        '<div class="city_list" style="">' +
                                            '{{each (i,item) list}}' +
                                                '{{if cQuery.type(item)=="string"}}' +
                                                    '<label>${item}</label>' +
                                                '{{else}}' +
                                                    '<a class="city_item" href="javascript:;" data="${data}">' +
                                                        '<span class="num">${data.split("|")[8]}家酒店</span>' +
                                                        '<p class="city">${right.replace(val, "<span class=\'b\'>"+val+"</span>")}</p>' +
                                                       ' <p class="province">${right}，${data.split("|")[9]}</p>' +
                                                    '</a>' +
                                                '{{/if}}' +

                                        '{{/each}}' +
                                    '</div>' +
                                    '{{if page.max>1}}' +
                                        '<div class="c_page_mini" style="display: block;">' +
                                            '{{if page.current>0}}' +
                                                '<a href="javascript:void(0);" page="${page.current-1}">&lt;-</a>' +
                                            '{{/if}}' +
                                            '{{if page.current<2}}' +
                                                '{{loop(index) Math.min(5,page.max+1)}}' +
                                                    '<a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>' +
                                                '{{/loop}}' +
                                            '{{else page.current>page.max-2}}' +
                                                '{{loop(index) Math.max(0,page.max-4),page.max+1}}' +
                                                    '<a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>' +
                                                '{{/loop}}' +
                                            '{{else}}' +
                                                '{{loop(index) Math.max(0,page.current-2),Math.min(page.current+3,page.max+1)}}' +
                                                    '<a href="javascript:void(0);"{{if page.current==index}} class="address_current"{{/if}} page="${index}">${index+1}</a>' +
                                                '{{/loop}}' +
                                            '{{/if}}' +
                                           '{{if page.current<page.max}}' +
                                                '<a href="javascript:void(0);" page="${page.current+1}">-&gt;</a>' +
                                            '{{/if}}' +
                                       ' </div>' +
                                    '{{/if}}' +
                                '</div>',

                                filterStyle: '' +
                                    '.city_prompting_lhsl { width:230px; border:1px solid #999; background-color:#fff; } ' +
                                    '.city_prompting_lhsl .not_found { height:28px; margin-bottom:4px; padding-left:4px; color:#C01111; line-height:28px; overflow:hidden; white-space:nowrap; } ' +
                                    '.city_prompting_lhsl .city_item { display:block; padding:4px; border-bottom:1px dashed #E4E4E4; } ' +
                                    '.city_prompting_lhsl .city_item:hover, .city_prompting_lhsl  .hover { background-color:#E8F4FF; text-decoration:none; } ' +
                                    '.city_prompting_lhsl .city_item .num { float:right; color:#666; } ' +
                                    '.city_prompting_lhsl .city_item .city { font-size:14px; font-weight:bold; color:#555; } ' +
                                    '.city_prompting_lhsl .city_item .province { color:#555; } ' +
                                    '.city_prompting_lhsl .city_item .b { color:#06c; } ' +
                                    '.city_prompting_lhsl .c_page_mini { margin:6px 0; } ' +
                                    '.c_page_mini { font: 12px/1.5 arial; margin: 0; padding: 0; text-align: center; }' +
                                    '.c_page_mini a {display: inline-block; margin: 0;color: #0055AA;padding: 0 6px;font:14px/1.5 Arial, Simsun, sans-serif;text-decoration: underline;}' +
                                    '.c_page_mini .c_page_mini_current{ color: #666;text-decoration: none;cursor: default;}',

                                suggestionStyle: suggestionStyle,
                                suggestionStyleIpad: suggestionStyle,
                                filterPageSize: 10,
                                suggestionInit: function (a) {
                                    var historyWrap = a.find('.search_history_box');

                                    MOD.defaultSuggestionInit(a);
                                    historyWrap.bind('mousedown', function (e) {
                                        var target = e.target;
                                        
                                        if (target.tagName === 'A') {
                                            var item = $.parseJSON(target.getAttribute('data-history'));
                                            city.removeClass('inputSel').value(unescape(item.cityname));
                                            $('#HD_CityId').value(item.id);
                                            $('#HD_CityPy').value(item.pingying);

                                            if (item.isoutdate === 'false') {
                                                checkin.value(item.checkin);
                                                checkout.value(item.checkout);
                                                checkin[0].style.backgroundImage = '';
                                                checkout[0].style.backgroundImage = '';
                                            };
                                            city[0].blur();
                                            //fix bug in ie, 'a' still keep hovering status. 
                                            isIE && historyWrap.html(historyWrap.html());
                                        }
                                    });

                                    //add css for suggest START
                                    isIE && addIframeStyle(a);
                                    //bind close event to close btn
                                    a.find('.close').bind('mousedown', function () {
                                        city[0].blur();
                                    })

                                    a.find('#mini_c_address_keyboard').bind('mousedown', function () {
                                        city[0].blur();
                                        city[0].focus();
                                    });
                                } .bind(this)
                            }
                        });

                        MOD.a_city.method('bind', 'change', function (mod, data) {
                            var items = data.items || {};
                            cityChangeEvent(items.id, items.name);
                        });
                        /**
                        * BI需求，拼成固定字符串
                        * @param {String} 当前input值
                        * @param {String} 传给tracklog的值

                        */
                        function makeTrackLogVals(value, autoCorrect, evtType) {

                            var v = '',
                            isMatch = 0;

                            if (autoCorrect) { //if autoCorrected, isMatch set to true
                                isMatch = 1;
                                v = autoCorrect;
                            } else {
                                isMatch = 0;
                                v = value;
                            };
                            return 'key=' + v + '&isMatch=' + isMatch;
                        };


                        MOD.a_city.method('bind', 'userinput', function (mod, data) {
                            if (data && window.$_bf && window.$_bf.tracklog) {

                                if (data.value) {
                                    window.$_bf.tracklog("nhtlcity", makeTrackLogVals(data.value, data.autoCorrectValue, data.eventType));
                                }
                            }


                        });

                        city.bind('focus', function () {
                            CITYENTER = true;
                        }).bind('keyup', function (e) {
                            e = e || window.event;
                            if (e.keyCode == 13) {
                                if (!CITYENTER) {
                                    CITYENTER = true;
                                } else {
                                    MOD.a_city.method("validate");
                                    if (HotelSearch.submit()) {
                                        fm.submit();
                                    }
                                }
                                e.preventDefault ? e.stopPropagation() : e.cancelBubble = true;
                                e.preventDefault ? e.preventDefault() : e.returnValue = false;
                            }
                        })
                    }
                    // 显示搜索历史
                    function showSearchHistoy(json) {
                        var DATE_FORMATOR = 'yyyy-mm-dd';

                        if (!json) return;
                        var box = $('#HD_SearchHistory');
                        var city = $('#HD_CityName');
                        if (!box.length) return;

                        box[0].style.display = '';
                        city.parentNode().removeClass('w100').addClass('w05');
                        city.removeClass('w01').addClass('w06');

                        var arr = [], len = Math.min(3, json.length);
                        for (var i = 0; i < len; i++) {
                            var item = json[i];
                            var cls = item.isoutdate === 'true' ? ' item_past' : '';
                            //TODO: 不应该出现这种代码，mvc!!!
                            arr.push('<a href="javascript:;" class="history_item' + cls + '" data=\'' + $.stringifyJSON(item).replace(/'/g, "") + '\'><span class="city">' + unescape(item.cityname) + '</span><span class="date">' + item.checkin + ' 至 ' + item.checkout + '</span></a>');
                        }
                        box.find('.history_list').html(arr.join(''));

                        btn = box.find('.s_history_btn');
                        list = box.find('.history_list')[0];
                        btn.bind('click', function (e) {
                            e.stop();
                            //use 'hasClass'.  'xxxs_history_btn_hover'.indexOf('s_history_btn_hover')
                            if (this.className.indexOf('s_history_btn_hover') != -1) {
                                this.className = 's_history_btn';
                                list.style.display = 'none';
                            } else {
                                this.className = 's_history_btn s_history_btn_hover';
                                list.style.display = 'block';
                            }
                        });

                        function setCity(item) {
                            city.removeClass('inputSel');
                            document.getElementById('HD_CityName').value = unescape(item.cityname);
                            document.getElementById('HD_CityId').value = item.id;
                            document.getElementById('HD_CityPy').value = item.pingying;
                            if (item.isoutdate === 'false') { // use boolean
                                var checkin = $('#HD_CheckIn');
                                var checkout = $('#HD_CheckOut');

                                checkin.value(item.checkin);
                                checkout.value(item.checkout);
                                checkin[0].style.backgroundImage = '';
                                checkout[0].style.backgroundImage = '';
                            }
                            cityChangeEvent(item.id, item.cityname);
                        }
                        // setCity(json[0]);

                        box.find('.history_item').bind('click', function () {
                            var obj = $.parseJSON(this.getAttribute('data'));
                            setCity(obj);
                        });

                        $(document).bind('click', function () {
                            btn[0].className = 's_history_btn';
                            list.style.display = 'none';
                        });
                    }
                    $.getJsonp(ENV + '/Domestic/Tool/AjaxGetUserSearchBehavior.aspx', function (json) {
                        if (json) {
                            var len = Math.min(6, json.length);
                            var anchors = [];
                            for (var i = 0; i < len; i++) {
                                var text = unescape(json[i].cityname).replace(/\(.*\)/, '');
                                text = text.length > 4 ? text.substr(0, 4) : text;
                                anchors.push('<a href="javascript:;" title="' + unescape(json[i].cityname) + '" data-history=\'' + $.stringifyJSON(json[i]).replace(/'/g, "") + '\'>' + text + '</a>');
                            }
                            searchHistoryList = '<p class="sarch_history_title">' + addressMessageConfig.searchHistory + '</p>' + '<div class="search_history_box">' + anchors.join('') + '</div>';

                            showSearchHistoy(json);
                        }
                        if (!MOD.a_city) {
                            clearTimeout(timer);
                            initCity();
                        }
                    });
                }

                window.cityChangeEvent = function (id, name) {
                    //set url of jsonp request for position filter
                    var a_keyword = MOD.a_keyword,
                        cityId = $('#HD_CityName').value();

                    a_keyword && id && setKeywordJsonpUrl(a_keyword, id);

                    CITYENTER = false;
                    var cityElem = city[0];
                    if (cityElem.value != cityElem.getAttribute('_lastValue')) {
                        cityElem.setAttribute('_lastValue', cityElem.value);

                        if (MOD.n_keyword) {
                            //change city, reset keyword
                            MOD.n_keyword.method("resetValue");
                            //change city, reset relative hidden field
                            $("#positionArea, #positionId, #hotelAreaName").value("");
                            //if no city selected clear source of a_keyword
                            if (!cityId) {
                                a_keyword.set("source", {
                                    suggestion: null,
                                    data: "@@"
                                });
                            }

                            if (id) {
                                window.getOtherDataByCity(id, name);
                            } else {
                                checkHotelPosition();
                            }

                        }
                    }
                }

                window.getOtherDataByCity = function (city, name, callback, undefined) {
                    if (city === undefined) {
                        return
                    }
                    var jsID = 'error',
                    jsName = '';
                    if (city >= 1 && city <= 10) {
                        jsID = 'idFrom1To10';
                        jsName = '1_10';
                    } else if (city >= 11 && city <= 200) {
                        jsID = 'idFrom11To200';
                        jsName = '11_200';
                    } else if (city >= 201) {
                        jsID = 'idFrom201ToMax';
                        jsName = '201_99999';
                    } else if (/D\d+_\d+/.test(city)) {
                        if (typeof HOTEL_POSITION[city] == "undefined") { HOTEL_POSITION[city] = {}; }
                    }
                    if (!HOTEL_POSITION['dataCash'][jsID]) {
                        var param = {
                            type: 'text/javascript',
                            async: true,
                            onload: function () {
                                // 商业区
                                CHINA_HOTEL_ZONE_RAW_DATA = CHINA_HOTEL_ZONE_RAW_DATA.replace(/@(\d+)\|([1-9]\d*)\|\s*([^\|]+)\|\s*([^\|]*)\|\s*([^\|]*)\|\s*([A-Z])/g, function (_, id, pid, name, pingYing, PY, letter) {
                                    checkExist(pid, "zone");
                                    // 数目>15时按字母区分显示，<=15时不区分显示
                                    var A2Z = ['ABCDE', 'FGHJK', 'LMNOP', 'QRSTW', 'XYZ'];
                                    A2Z.each(function (str, idx) {
                                        if (str.indexOf(letter) != -1) {
                                            !HOTEL_POSITION[pid]["zone"][str] && (HOTEL_POSITION[pid]["zone"][str] = []);
                                            HOTEL_POSITION[pid]["zone"][str].push({ "display": name, "data": [pingYing, name, id, PY, "zoneId"].join("|") });

                                            // ALl：用于模版里逻辑判断；不区分时，显示全部
                                            !HOTEL_POSITION[pid]["zone"]["ALL"] && (HOTEL_POSITION[pid]["zone"]["ALL"] = []);
                                            HOTEL_POSITION[pid]["zone"]["ALL"].push({ "display": name, "data": [pingYing, name, id, PY, "zoneId"].join("|") });
                                        }
                                    })
                                    HOTEL_POSITION[pid]["all"].push([pingYing, name, id, PY, "zoneId"].join("|"));
                                    return '';
                                });
                                // 行政区
                                CHINA_HOTEL_LOCATION_RAW_DATA = CHINA_HOTEL_LOCATION_RAW_DATA.replace(/@(\d+)\|([1-9]\d*)\|\s*([^\|]+)\|\s*([^\|]*)\|\s*([^@]*)/g, function (_, id, pid, name, pingYing, PY) {
                                    checkExist(pid, "location");
                                    HOTEL_POSITION[pid]["location"].push({ "display": name, "data": [pingYing, name, id, PY, "locationId"].join("|") });
                                    HOTEL_POSITION[pid]["all"].push([pingYing, name, id, PY, "locationId"].join("|"));
                                    return '';
                                });
                                // 地铁线
                                CHINA_HOTEL_METRO_RAW_DATA = CHINA_HOTEL_METRO_RAW_DATA.replace(/@(\d+)\|([1-9]\d*)\|\s*([^\|]+)\|\s*([^\|]*)\|\s*([^\|]*)\|\s*([^@]*)/g, function (_, id, pid, name, pingYing, PY) {
                                    checkExist(pid, "metro");
                                    HOTEL_POSITION[pid]["metro"].push({ "display": name, "data": [pingYing, name, id, PY, "metroId"].join("|") });
                                    HOTEL_POSITION[pid]["all"].push([pingYing, name, id, PY, "metroId"].join("|"));
                                    return '';
                                });
                                // 地铁站
                                CHINA_HOTEL_SPOT_RAW_DATA = CHINA_HOTEL_SPOT_RAW_DATA.replace(/@(\w\d+)\|([1-9]\d*)\|\s*([^\|]+)\|\s*([^\|]*)\|\s*([^@]*)/g, function (_, id, pid, name, pingYing, PY) {
                                    checkExist(pid, "spot");
                                    HOTEL_POSITION[pid]["spot"].push({ "display": name, "data": [pingYing, name, id, PY, "landMarkId"].join("|") });
                                    HOTEL_POSITION[pid]["all"].push([pingYing, name, id, PY, "landMarkId"].join("|"));
                                    return '';
                                });
                                HOTEL_POSITION['dataCash'][jsID] = true;

                                checkHotelPosition(city, name);
                                callback && callback();
                            }
                        }
                        cQuery.loader.js('http://webresource.c-ctrip.com/code/js/resource/address_tuna/hotel_domes_zone_130416_' + jsName + '_' + cQuery.config("charset") + '.js?v=' + $('#_releaseNo_').value(), param);
                    } else {
                        checkHotelPosition(city, name);
                        callback && callback();
                    }
                }

                //初始化关键词suggest等
                if (this.ops.keyword.length) {
                    this.initKeyword();
                }


                function checkHotelPosition(cityId, cityName) {

                }

            },
            initNotice: function () {
                this.ops.city.length && (MOD.n_city = this.ops.city.regMod("notice", "1.0", {
                    name: "city",
                    tips: noticeMessageConfig[0],
                    selClass: "inputSel"
                }));
                this.ops.startDate.length && (MOD.n_startDate = this.ops.startDate.regMod("notice", "1.0", {
                    name: "startDate",
                    tips: "yyyy-mm-dd",
                    selClass: "inputSel"
                }));
                this.ops.endDate.length && (MOD.n_endDate = this.ops.endDate.regMod("notice", "1.0", {
                    name: "endDate",
                    tips: "yyyy-mm-dd",
                    selClass: "inputSel"
                }));
                this.ops.checkInDate.length && (MOD.n_checkInDate = this.ops.checkInDate.regMod("notice", "1.0", {
                    name: "checkInDate",
                    tips: "yyyy-mm-dd",
                    selClass: "inputSel"
                }));
                this.ops.checkOutDate.length && (MOD.n_checkOutDate = this.ops.checkOutDate.regMod("notice", "1.0", {
                    name: "checkOutDate",
                    tips: "yyyy-mm-dd",
                    selClass: "inputSel"
                }));
            },
            initCalendar: function (start, end) {
                start.regMod("calendar", "3.0", {
                    options: {
                        showWeek: !0,
                        container: cQuery.container
                    }
                });
                end.regMod("calendar", "3.0", {
                    options: {
                        showWeek: !0,
                        reference: '#' + start[0].id,
                        minDate: start.value().toDate() ? start.value().toDate().addDays(1).toStdDateString() : new Date().addDays(1).toStdDateString()
                    }
                });
                start.bind('change', function (e) {
                    e = e || window.event;
                    var target = e.target || e.srcElement;
                    if (!target) return;
                    var startDate = target.value.toDate();
                    if (startDate) {
                        var nextDate = startDate.addDays(1);
                        end.data('minDate', nextDate.toStdDateString());
                        var endDate = end.value().toDate();
                        if (!endDate || endDate <= startDate) {
                            end.value(nextDate.toFormatString('yyyy-MM-dd'));
                            end.getMod("notice", "1.0").method("checkValue");
                            end.getMod("calendar", "3.0").method("setWeek", "#" + end[0].id);
                        } if (endDate && endDate - startDate > MAX_STAY) {
                            setTimeout(function () {
                                MOD.formValidator.method("show", {
                                    $obj: end,
                                    data: validateMessageConfig['hotel']['too_long'],
                                    removeErrorClass: !0,
                                    isScroll: false
                                })
                            } .bind(this), 0);
                        }
                    } else {
                        end.data('minDate', new Date().addDays(1).toStdDateString());
                    }
                } .bind(this)).bind('focus', function () {
                    if (this.timer) {
                        clearTimeout(this.timer);
                    }
                } .bind(this));
                end.bind('focus', function (e) {
                    e = e || window.event;
                    var target = e.target || e.srcElement;
                    var startDate = start.value().toDate();
                    var endDate = target.value.toDate();
                    if (startDate && endDate && endDate - startDate > MAX_STAY) {
                        setTimeout(function () {
                            MOD.formValidator.method("show", {
                                $obj: end,
                                data: validateMessageConfig['hotel']['too_long'],
                                removeErrorClass: !0,
                                isScroll: false
                            })
                        } .bind(this), 0);
                    }
                } .bind(this)).bind('blur', function () {
                    this.timer = setTimeout(function () {
                        var startDate = start.value().toDate();
                        var endDate = end.value().toDate();
                        if (startDate && endDate && endDate > startDate) {
                            if (endDate - startDate > MAX_STAY) {
                                MOD.formValidator.method("show", {
                                    $obj: end,
                                    data: validateMessageConfig['hotel']['too_long'],
                                    removeErrorClass: !0,
                                    isScroll: false
                                })
                            }
                        }
                    } .bind(this), 100);
                } .bind(this));
            }
        })
        WIN.RegMod = RegMod;
    })(window, cQuery);
    $.extend(cQuery, {
        replace: function (template, obj) {
            return template.replace(/\$\{([\w\.?]+)\}/g, function (s, k) {
                var keys = k.split('.'), l = keys.length;
                var key = keys[0];
                if (l > 1) {
                    var o = obj;
                    for (var i = 0; i < l; i++) {
                        if (key in o) {
                            o = o[key];
                            key = keys[i + 1];
                        } else return s;
                    }
                    return o;
                }
                return key in obj ? obj[key] : s;
            });
        },
        format: function (template) {
            var args = arguments, l = args.length;
            if (l > 1) {
                return template.replace(/\$(\d)/g, function (s, k) {
                    return args[k] == undefined ? '' : args[k];
                });
            } else return template;
        },
        create: function (tag, attrs) {
            var el = document.createElement(tag);
            for (var p in attrs) {
                if (attrs.hasOwnProperty(p)) {
                    if (p == 'cssText') {
                        el.style[p] = attrs[p];
                    } else {
                        el[p] = attrs[p];
                    }
                }
            }
            return el;
        }
    });
    var MadCat = function (fn, cfg) {
        this.events = {};
        fn && fn.call(this, cfg);
    };
    $.extend(MadCat.prototype, {
        set: function () { },
        get: function () { return null },
        evt: function (key, fn) { this.events[key] = fn },
        init: function () { }
    });
    var HotelSearch = new MadCat(function () {
        var HD_CheckIn, HD_CheckOut,
            HD_CityName, HD_TxtKeyword;
        var hidCityId, hidCityPY;
        var me = this;
        var submitConfig = {
            isAuto: false,
            isMap: false
        }

        this.init = function () {
            HD_CheckIn = document.getElementById('HD_CheckIn');
            HD_CheckOut = document.getElementById('HD_CheckOut');
            HD_CityName = document.getElementById('HD_CityName');
            HD_TxtKeyword = document.getElementById('HD_TxtKeyword');
            hidCityId = document.getElementById('HD_CityId');
            hidCityPY = document.getElementById('HD_CityPy');
            var Enter = $('#searchForm');
            Enter.bind('keydown', function (e) {
                e = e || window.event;
                if (e.keyCode == 13) {
                    if (HotelSearch.submit()) {
                        fm.submit();
                    }
                }
            });

        };
        this.set = function () { };
        this.checkDate = function (date, v0) {
            v0 = v0 ? v0.toDate() : new Date().toStdDateString().toDate();
            var dt1 = date[0], dt2 = date[1],
                v1 = dt1.value.toDate() || 0, v2 = dt2.value.toDate() || 0;
            return !$(dt1).value() ? showTips(dt1, 'checkIn') :
                !v1 ? showTips(dt1, 'dateErr') :
                    v1 < v0 ? showTips(dt1, 'too_early_in') :
                        !$(dt2).value() ? showTips(dt2, 'checkOut') :
                            !v2 ? showTips(dt2, 'dateErr') :
                                v1 >= v2 ? showTips(dt2, 'too_early_out') :
                                    v2 - v1 > MAX_STAY ? showTips(dt2, 'too_long') : 1;
        };
        this.checkDateByAuto = function (date, v0) {
            v0 = v0 ? v0.toDate() : new Date().toStdDateString().toDate();
            var dt1 = date[0], dt2 = date[1],
                v1 = dt1.value.toDate() || 0, v2 = dt2.value.toDate() || 0;
            return !$(dt1).value() ? 0 :
                !v1 ? 0 :
                    v1 < v0 ? 0 :
                        !$(dt2).value() ? 0 :
                            !v2 ? 0 :
                                v1 >= v2 ? 0 :
                                    v2 - v1 > MAX_STAY ? 0 : 1;
        };
        this.setSubmit = function (isAuto, isMap) {
            submitConfig.isAuto = !!isAuto;
            submitConfig.isMap = !!isMap;
        };
        this.submit = function (isAuto, isMap) {
            isAuto = isAuto || submitConfig.isAuto;
            isMap = isMap || submitConfig.isMap;
            if (!$(HD_CityName).value()) {
                if (isAuto) {
                    var param = { cityId: '', cityName: '', cityPY: '' };
                    if (param.cityId && param.cityName && param.cityPY) {
                        HD_CityName.value = param.cityName;
                        hidCityId.value = param.cityId;
                        hidCityPY.value = param.cityPY;
                    } else {
                        HD_CityName.value = addressMessageConfig['defaultValue'][0];
                        hidCityId.value = addressMessageConfig['defaultValue'][1];
                        hidCityPY.value = addressMessageConfig['defaultValue'][2];
                    }
                } else {
                    return showTips(HD_CityName, 'city');
                }
            }
            if (isAuto) {
                if (!this.checkDateByAuto([HD_CheckIn, HD_CheckOut])) {
                    HD_CheckIn.value = HD_CheckIn.defaultValue;
                    HD_CheckOut.value = HD_CheckOut.defaultValue;
                }
            } else if (!this.checkDate([HD_CheckIn, HD_CheckOut])) {
                return false;
            }
            var other = [];
            var pos = '';

            /* 拼接URL */

            var urlType,
                isHotelName,
                positionArea = $('#positionArea')[0],
                positionId = $('#positionId')[0],
                searchKeyword = $('#hotelAreaName')[0],
                keyword = $(HD_TxtKeyword).value();

            ; (function () { //keep variables be local
                if (keyword) {
                    var id = positionId.value,
                        areaTypeVal = positionArea.value;

                    isHotelName = areaTypeVal.toLowerCase() === 'hotel';
                    urlType = markerTypeMap[areaTypeVal.toLowerCase()];
                    urlType = urlType && urlType.search;
                    if (urlType) {
                        (urlType === 's') && (id = id.replace(/^[SL]/, '')); //新地标处理统一，方便查询服务器查询
                        pos += urlType + id;
                    } else {
                        positionArea.value = '';
                        positionId.value = '';
                        searchKeyword.value = keyword;
                    }
                } else {
                    positionArea.value = '';
                    positionId.value = '';
                    searchKeyword.value = '';
                }
            })();


            var searchHotelLevelSelect = document.getElementById('searchHotelLevelSelect');
            if (searchHotelLevelSelect && searchHotelLevelSelect.value != '0') {
                pos += 'star' + searchHotelLevelSelect.value;
            }
            if (pos) {
                other.push(pos);
            }
            if ($(HD_TxtKeyword).value() && !urlType) {
                other.push((isHotelName ? 'k2' : 'k1') + encodeURIComponent(searchKeyword.value.replace(/\+/g, "＋")));
            }

            var url = '/hotel/${city}${map}${other}';
            var link = $.replace(url, {
                city: hidCityPY.value.toLowerCase() + '' + hidCityId.value,
                map: isMap ? '/map' : '',
                other: (other.length ? '/' + other.join('/') : '')
            })
            $('#HD_CheckIn').value(HD_CheckIn.value);
            $('#HD_CheckOut').value(HD_CheckOut.value);

            fm.action = ENV + link;
            if (fm.__VIEWSTATE) fm.__VIEWSTATE.name = "NOVIEWSTATE";
            fm.target = '_self';
            saveInfoWhenSubmit && saveInfoWhenSubmit();
            return true;
        };

        this.setCity = function (cityId, cityName, cityPY) {
            if (!cityId || !cityName || !cityPY) return;
            MOD.n_city.method("checkValue");
            //MOD.n_hotelPos.method("checkValue");
            //MOD.n_hotelName.method("checkValue");
        };

        function showTips(obj, msg) {
            obj.focus();
            setTimeout(function () {
                MOD.formValidator.method("show", {
                    $obj: $(obj),
                    data: validateMessageConfig.hotel[msg],
                    removeErrorClass: !0,
                    hideEvent: "blur",
                    //isFocus: !0,
                    isScroll: false
                });
            }, 50)
            return false;
        }
    });

    var HD_COOKIE_NAME;
    if (arrEnv[1]) {
        HD_COOKIE_NAME = HD_cookieName[arrEnv[1]];
    } else {
        HD_COOKIE_NAME = 'HotelCityID';
    }
    var FIELDS_WITH_BACKWARD_STATUS = {
        cityName: 'HD_CityName',
        cityId: 'HD_CityId',
        cityPY: 'HD_CityPy',
        checkIn: 'HD_CheckIn',
        checkOut: 'HD_CheckOut',
        hotellevel: 'searchHotelLevelSelect'
    };
    var HD_COOKIE_KEY = {
        cityId: 'cityId',
        cityName: 'cityName',
        cityPY: 'cityPY',
        checkIn: 'checkIn',
        checkOut: 'checkOut',
        hotellevel: 'hotellevel'
    }
    function saveInfoWhenSubmit() {
        saveHotelStatus(FIELDS_WITH_BACKWARD_STATUS, HD_COOKIE_NAME);
    }
    function saveHotelStatus(fields, cookieName) {
        if (cQuery.isEmptyObject(fields)) {
            return false;
        }
        setCookie(cookieName, {
            "cityId": document.getElementById(fields.cityId).value,
            "cityName": document.getElementById(fields.cityName).value,
            "cityPY": document.getElementById(fields.cityPY).value,
            "checkIn": document.getElementById(fields.checkIn).value,
            "checkOut": document.getElementById(fields.checkOut).value,
            "hotelLevel": document.getElementById(fields.hotellevel).value
        });
    }
    function restoreHotelStatus(fields, param) {









        document.getElementById(fields.cityId).value = param['cityId'];
        document.getElementById(fields.cityName).value = param['cityName'];
        document.getElementById(fields.cityPY).value = param['cityPY'];

        // 入住日期和退房日期默认是今住明离
        document.getElementById(fields.checkIn).value = (param['checkIn'] === '' ? todayDateStr() : (isOutDate(param['checkIn']) ? todayDateStr() : param['checkIn']));
        document.getElementById(fields.checkOut).value = (param['checkOut'] === '' ? tomorrowDateStr() : (isOutDate(param['checkOut']) ? tomorrowDateStr() : param['checkOut']));

        // 大于0，说明选择了酒店级别
        param['hotellevel'] > 0 && (document.getElementById(fields.hotellevel).value = param['hotellevel']);
    }
    function todayDateStr() {
        var obj = new Date();
        return obj.getFullYear() + '-' + (obj.getMonth() + 1) + '-' + obj.getDate();
    }
    function tomorrowDateStr() {
        return todayDateStr().toDate().addDays(1).toFormatString('yyyy-MM-dd');
    }
    function isOutDate(dateStr) {
        var date = new Date(dateStr.replace(/\-/g, '/')).getTime();
        var now = new Date(todayDateStr().replace(/\-/g, '/')).getTime();
        return date <= now;
    }
    function getCookie(mainKey, fields) {
        var keyMap = {};
        var m = cQuery.cookie.get(mainKey);
        m = (m ? m : "").split("split");
        for (var i = 0, l = m.length; i < l; i++) {
            if (i == 0)
                keyMap[fields.cityId] = unescape(m[i]);
            else if (i == 1)
                keyMap[fields.cityName] = unescape(m[i]);
            else if (i == 2)
                keyMap[fields.cityPY] = unescape(m[i]);
            else if (i == 3)
                keyMap[fields.checkIn] = unescape(m[i]);
            else if (i == 4)
                keyMap[fields.checkOut] = unescape(m[i]);
            else if (i == 5)
                keyMap[fields.hotellevel] = unescape(m[i]);
        }
        return keyMap;
    }
    function setCookie(mainKey, keyMap) {
        var cookiedomain = window.location.host.replace(/www\./, '');
        cQuery.cookie.set(HD_COOKIE_NAME, null, keyMap['cityId'] + 'split' + keyMap['cityName'] + 'split' + keyMap['cityPY'] + 'split' + keyMap['checkIn'] + 'split' + keyMap['checkOut'] + 'split' + keyMap['hotelLevel'], { expires: 30, domain: cookiedomain, path: '/' });
    }

    var PageLoad = (function () {
        var releaseNo = $('#_releaseNo_').value();
        var param = getCookie(HD_COOKIE_NAME, HD_COOKIE_KEY);
        param = cQuery.extend({
            cityName: '',
            cityId: '',
            cityPY: '',
            checkIn: '',
            checkOut: '',
            hotellevel: ''
        }, param);
        restoreHotelStatus(FIELDS_WITH_BACKWARD_STATUS, param);

        // 修复点击浏览器回退，关键词有残留
        document.getElementById('HD_TxtKeyword').value = '';
        document.getElementById('hotelAreaName').value = '';

        var initMod = function () {
            var hotelSearchMod = new RegMod({
                city: $('#HD_CityName'),
                startDate: $('#HD_CheckIn'),
                endDate: $('#HD_CheckOut'),
                keyword: $('#HD_TxtKeyword')
            });
        };

        var initHotelSearch = function () {
            HotelSearch.init();
            HotelSearch.setCity(param.cityId, param.cityName, param.cityPY);
            setKeywordJsonpUrl(MOD.a_keyword, param.cityId); //set url of jsonp request for keyword filter
            $('#HD_Btn').bind('click', function (e) {
                if (HotelSearch.submit()) {
                    sendAjaxWithKeyword();
                    fm.submit();
                }
                e.stop();
            });
            $('#HD_MapBtn').bind('click', function (e) {
                if (HotelSearch.submit(false, true)) {
                    sendAjaxWithKeyword();
                    fm.submit();
                }
                e.stop();
            });
        };

        var initPage = function () {
            initMod();
            initHotelSearch();
        };

        return {
            init: initPage
        }
    })()
    PageLoad.init();

})(cQuery);/*****env:4,update:2013-9-3 14:06:03*****/