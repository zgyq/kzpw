/*
  * 全站首页海外酒店搜索框
  * ctrip search box
  * date: 2013-05-02
  * by: junyizhang
*/
;(function($) {
    var MAX_STAY = 28 * 24 * 3600 * 1000;
    var cityObj = {id: '', py: ''};
    var releaseNo = $('#_releaseNo_').value();

    // 从公共服务提供的隐藏域中获取如下信息来判断跳转的域名：
    // <input type="hidden" id="solution" value="PRO|GB"/>
    // PRO: 生产, UAT: UAT, TEST: 测试
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
    var ENV = 'http://hotels.ctrip.com';
    var solution = document.getElementById('solution');
    var arrEnv = solution && solution.value && solution.value.toUpperCase().split('|');
    if (arrEnv && arrEnv.length) {
        ENV = envObj[arrEnv[0]][arrEnv[1]];
    }

    $.mod.multiLoad({
			adFrame: "1.0",
			address: "1.0",
			allyes: "1.0",
			calendar: "3.0",
			jmp: "1.0",
			notice: "1.0",
			validate: "1.1"
    }, function() {
    });

	var CITYENTER = true;
	
    var InteHotel = {
        //表单节点
        form: $('#inteHotelForm'),

        formValidate: $('#inteHotelForm').regMod("validate", "1.1"),

        // 表单提交按钮节点元素
        submitBtn: $('#HI_Btn'),

        // 需要验证的函数数组
        v_methods: [],
        regValidateMethod: function(func) {
            this.v_methods.push(func);
        },

        /*
        * 简单的验证提示显示
        * @param    {Dom} obj               需要显示提示的节点
        * @param    {String} message        需要显示提示的文字
        */
        validateShow: function(obj, msg) {
            this.formValidate.method("show", {
                $obj: obj,
                data: config.tip.inteHotel[msg].replace('{$today}', config.today),
                removeErrorClass: true,
                hideEvent: "blur",
                isFocus: true,
                isScroll: false
            });
        },

        // 绑定提交按钮事件，并设置post值以及表单action
        bindSubmit: function() {
            var that = this;
            this.submitBtn.bind("click", function() {
				setTimeout(function(){
					for (var i = 0, len = that.v_methods.length; i < len; i++) {
						if (!that.v_methods[i]()) {
							return false;
						}
					}
					that.setCookie();
					that.setAction();
					that.setStorage();
					that.form[0].submit();
				},500);
            });
        },

        /*
        * 简单的Notice模块注册
        * @param    {Dom} obj               需要注册Notice模块的节点
        * @param    {String} name           给对应Notice模块设置名称
        * @param    {String} tips           Notice模块的文字
        */
        setNotice: function(obj, name, tips) {
            return obj.regMod('notice', '1.0', {
                name: name,
                tips: tips,
                selClass: "inputSel"
            });
        },

        // 简单的注册日期模块
        regDateMod: function(obj) {
            return obj.regMod("calendar", "3.0", {
                options: {
                    showWeek: true,
                    minDate: config.today
                }
            });
        },

        regStayCity: function() {
            var that = this;
            var filterTemp = '\
						{{if hasResult}}\
							<div class="city_suggestion_pop">\
								<p class="title"><a class="close" href="javascript:;" onmousedown="$(\'#inteCityName\').trigger(\'blur\')">×</a>{{if hasResult}}{{tmpl message.filterResult}}{{/if}}</p>\
								<div class="sug_item">\
									{{each (i,item) list}}\
										{{if cQuery.type(item)=="string"}}\
											<a>${item}</a>\
										{{else}}\
											<a href="javascript:void(0);" data="${data}" title="${right}(${left})">\
												<span class="num">{{tmpl (all=data.split("|"))[all.length-1]}}</span>\
												<span class="city">\
													<span class="cn">{{tmpl HighLightAddressResult(right, val)}}</span>\
													<span class="en">({{tmpl HighLightAddressResult(left, val)}})</span>\
												</span>\
											</a>\
										{{/if}}\
									{{/each}}\
								</div>\
							</div>\
						{{/if}}\
					';
			var filterTempIpad = '\
						{{if hasResult}}\
							<div class="city_suggestion_pop">\
								<p class="title"><a class="close" id="mini_c_address_close">×</a>{{if hasResult}}{{tmpl message.filterResult}}{{/if}}</p>\
								<div class="sug_item">\
									{{each (i,item) list}}\
										{{if cQuery.type(item)=="string"}}\
											<a>${item}</a>\
										{{else}}\
											<a href="javascript:void(0);" data="${data}" title="${right}(${left})">\
												<span class="num">{{tmpl (all=data.split("|"))[all.length-1]}}</span>\
												<span class="city">\
													<span class="cn">{{tmpl HighLightAddressResult(right, val)}}</span>\
													<span class="en">({{tmpl HighLightAddressResult(left, val)}})</span>\
												</span>\
											</a>\
										{{/if}}\
									{{/each}}\
								</div>\
							</div>\
						{{/if}}\
					';
            var filterStyle = ' .city_suggestion_pop { width:446px; border:1px solid #ccc; background-color:#fff; } .city_suggestion_pop .title { height:26px; margin:0 10px 4px; padding:0 2px; border-bottom:1px dotted #ccc; line-height:26px; color:#999; } .city_suggestion_pop .close { float:right; width:26px; height:26px; font:bold 14px/26px Simsun; color:#666; text-align:center; } .city_suggestion_pop .text_input { float:left; max-width:210px; _width:210px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; } .city_suggestion_pop .close:hover { text-decoration:none; color:#FFA800; } .city_suggestion_pop .sug_item a { display:block; padding:0 10px; color:#000; font-family:Tahoma; line-height:28px; cursor:pointer; } .city_suggestion_pop .sug_item .num { float:right; color:#999; } .city_suggestion_pop .sug_item .city { display:block; width:350px; max-height:56px; _height:28px; padding-right:4px; overflow:hidden; } .city_suggestion_pop .sug_item .en { color:#999; } .city_suggestion_pop .sug_item b { font-weight:bold; color:#06c; } .city_suggestion_pop .sug_item a:hover,  .city_suggestion_pop .sug_item .hover { background-color:#06c; color:#fff; text-decoration:none; } .city_suggestion_pop .sug_item a:hover span,  .city_suggestion_pop .sug_item .hover span,  .city_suggestion_pop .sug_item a:hover b,  .city_suggestion_pop .sug_item .hover b { color:#fff; }';
			var filterStyleIpad = '.city_suggestion_pop { width:446px; border:1px solid #ccc; background-color:#fff; } .city_suggestion_pop .title { height:26px; margin:0 10px 4px; padding:0 2px; border-bottom:1px dotted #ccc; line-height:26px; color:#999; } .city_suggestion_pop .close { float:right; width:26px; height:26px; font:bold 14px/26px Simsun; color:#666; text-align:center; } .city_suggestion_pop .text_input { float:left; max-width:210px; _width:210px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis; } .city_suggestion_pop .close:hover { text-decoration:none; color:#FFA800; } .city_suggestion_pop .sug_item a { display:block; padding:0 10px; color:#000; font-family:Tahoma; line-height:28px; cursor:pointer; } .city_suggestion_pop .sug_item .num { float:right; color:#999; } .city_suggestion_pop .sug_item .city { display:block; width:350px; max-height:56px; _height:28px; padding-right:4px; overflow:hidden; } .city_suggestion_pop .sug_item .en { color:#999; } .city_suggestion_pop .sug_item b { font-weight:bold; color:#06c; } .city_suggestion_pop .sug_item a:hover,  .city_suggestion_pop .sug_item .hover { background-color:#06c; color:#fff; text-decoration:none; } .city_suggestion_pop .sug_item a:hover span,  .city_suggestion_pop .sug_item .hover span,  .city_suggestion_pop .sug_item a:hover b,  .city_suggestion_pop .sug_item .hover b { color:#fff; }';

            this.modStayCity = $('#inteCityName').regMod('address', '1.0', {
                name: 'inteCityName',
                jsonpSource: 'js/AjaxHotCitys.aspx',
                offset: 5,
                relate: {
                    2: $("#inteCityId"),
                    3: $("#inteCityPy")
                },
				message: {
					suggestion: '支持中文/英文/拼音输入',
					filterResult: '<span class="text_input">${val},</span>若需缩小范围，请输入更多条件。',
					noFilterResult: ''
				},
                template: {
                    suggestion: '\
							<div class="city_select_lhsl ">\
								<a class="close" href="javascript:;" onmousedown="$(\'#inteCityName\').trigger(\'blur\')">×</a>\
								<p class="title">${message.suggestion}</p>\
								<ul class="tab_box">\
									{{enum(key) data}}\
										<li><b></b><span>${key}</span></li>\
									{{/enum}}\
								</ul>\
								{{enum(key,arr) data}}\
									<div class="city_item">\
										{{each arr}}\
											<a data="${data}" href="javascript:void(0);" title="${display}" onmouseup="$(\'#inteCityName\').trigger(\'blur\')" >${display}</a>\
										{{/each}}\
									</div>\
								{{/enum}}\
                            </div>\
                    ',
					suggestionIpad: '\
						<div class="city_select_lhsl city_select_pad">\
							<a href="javascript:void(0)" class="close" id="mini_c_address_close">X</a>\
							<p class="title">${message.suggestion}</p>\
							<ul class="tab_box">\
								{{enum(key) data}}\
									<li><b></b><span>${key}</span></li>\
								{{/enum}}\
							</ul>\
							{{enum(key,arr) data}}\
								<div class="city_item">\
									{{each arr}}\
										<a data="${data}" href="javascript:void(0);">${display}</a>\
									{{/each}}\
								</div>\
							{{/enum}}\
							<a href="javascript:void(0)" class="ico_key" id="mini_c_address_keyboard"></a>\
						</div>\
					',
                    suggestionStyle: ' .city_select_lhsl { position:relative; width:378px; padding:10px; border:1px solid #999; background-color:#fff; } .city_select_lhsl .close { float:right; width:20px; height:20px; color:#666; text-align:center; font:bold 16px/20px Simsun; } .city_select_lhsl .close:hover { text-decoration:none; color:#FFA800; } .city_select_lhsl .ico_key, .city_select_lhsl .ico_unkey { display:none; } .city_select_lhsl .title { color:#999; } .city_select_lhsl .tab_box { width:100%; height:22px; margin-bottom:6px; border-bottom:2px solid #ccc; }  .city_select_lhsl .tab_box li { position:relative; float:left; display:inline; margin-right:10px; line-height:22px; color:#06c; cursor:pointer; } .city_select_lhsl .tab_box li b { display:none; } .city_select_lhsl .tab_box li span { padding:0 3px; } .city_select_lhsl .tab_box .selected { border-bottom:2px solid #06c; margin-bottom:-2px; font-weight:bold; color:#333; } .city_select_lhsl .tab_box .selected b { position:absolute; top:23px; left:50%; display:block; width:0; height:0; margin-left:-5px; overflow:hidden; font-size:0; line-height:0; border-color:#06c transparent transparent transparent; border-style: solid dashed dashed dashed; border-width:5px; } .city_select_lhsl .city_item { display:inline-block; } .city_select_lhsl .city_item {display:block;overflow:hidden;} .city_select_lhsl .city_item a { float:left; width:55px; height:22px; padding-left:5px; border:1px solid #fff; overflow:hidden; text-overflow:ellipsis; line-height:22px; } .city_select_lhsl .city_item a:hover { border:1px solid #ACCCEF; background-color:#E8F4FF; text-decoration:none; } .city_select_pad { padding-top:5px; } .city_select_pad .title { margin:0 0 0 30px; } .city_select_pad .ico_key, .city_select_pad .ico_unkey { position:absolute; top:1px; left:1px; display:block; width:39px; height:25px; background:url(http://pic.c-ctrip.com/ctripOnPad/un_key.png) no-repeat; -webkit-transform:scale(.7); } .city_select_pad .ico_unkey { background-position:0 -28px; } .city_select_pad .close, .city_select_pad .close:hover { font-family:helvetica,Simsun; color:#666; } ',
					suggestionStyleIpad: '.city_select_lhsl { position:relative; width:378px; padding:10px; border:1px solid #999; background-color:#fff; } .city_select_lhsl .close { float:right; width:20px; height:20px; color:#666; text-align:center; font:bold 16px/20px Simsun; } .city_select_lhsl .close:hover { text-decoration:none; color:#FFA800; } .city_select_lhsl .ico_key, .city_select_lhsl .ico_unkey { display:none; } .city_select_lhsl .title { color:#999; } .city_select_lhsl .tab_box { width:100%; height:22px; margin-bottom:6px; border-bottom:2px solid #ccc; }  .city_select_lhsl .tab_box li { position:relative; float:left; display:inline; margin-right:10px; line-height:22px; color:#06c; cursor:pointer; } .city_select_lhsl .tab_box li b { display:none; } .city_select_lhsl .tab_box li span { padding:0 3px; } .city_select_lhsl .tab_box .selected { border-bottom:2px solid #06c; margin-bottom:-2px; font-weight:bold; color:#333; } .city_select_lhsl .tab_box .selected b { position:absolute; top:23px; left:50%; display:block; width:0; height:0; margin-left:-5px; overflow:hidden; font-size:0; line-height:0; border-color:#06c transparent transparent transparent; border-style: solid dashed dashed dashed; border-width:5px; } .city_select_lhsl .city_item { display:inline-block; } .city_select_lhsl .city_item {display:block;overflow:hidden;} .city_select_lhsl .city_item a { float:left; width:55px; height:22px; padding-left:5px; border:1px solid #fff; overflow:hidden; text-overflow:ellipsis; line-height:22px; } .city_select_lhsl .city_item a:hover { border:1px solid #ACCCEF; background-color:#E8F4FF; text-decoration:none; } .city_select_pad { padding-top:5px; } .city_select_pad .title { margin:0 0 0 30px; } .city_select_pad .ico_key, .city_select_pad .ico_unkey { position:absolute; top:1px; left:1px; display:block; width:39px; height:25px; background:url(http://pic.c-ctrip.com/ctripOnPad/un_key.png) no-repeat; -webkit-transform:scale(.7); } .city_select_pad .ico_unkey { background-position:0 -28px; } .city_select_pad .close, .city_select_pad .close:hover { font-family:helvetica,Simsun; color:#666; } ',
                    filterPageSize: -1,
                    filter: filterTemp,
                    filterIpad: filterTempIpad,
                    filterStyle: filterStyle,
                    filterStyleIpad: filterStyleIpad,
					suggestionInit: function (obj) {
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
                },
                // jsonpFilter: config.url.inteCityNameJsonp,
                jsonpFilter: ENV + '/international/Tool/AjaxIndexCity.aspx?isCtrip=true&IsUseNewStyle=T&keyword=${key}',
                isFocusNext: false,
                isAutoCorrect: false,
				delay: 200,
                offset: 5
            });

			//输入内容高亮
			window.HighLightAddressResult = function (result, value) {
				var reg = new RegExp(filterSpicalCharForRegx(value), 'gi');
				if (reg.test(result)) {
					var v = result.match(reg);
					var html = '';
					for (var i = 0; i < v.length; i++) {
						html = result.replace(v[i], '<b>' + v[i] + '</b>');
					}
					return html;
				}
				else {
					return result;
				}
			}

            this.modStayCity.method('bind', 'change', function(mod, data) {
                if (data.items && data.items[2]) {
                    cityObj.id = data.items[2];
                    cityObj.py = data.items[3];
					$('#inteCityId').attr('_lastvalue', this.value);
                } else {
                    cityObj.id = '';
                    cityObj.py = '';
                }
				CITYENTER = false;
				if (this.value != this.getAttribute('_lastvalue')) {
					this.setAttribute('_lastvalue', this.value);
					}
                // when hotelName is not fouced， reset value
                if (that.n_hotelName && $('#inteHotelName').attr('fouced') == 'false') {
                    that.n_hotelName.method('resetValue');
                }
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
			
			this.modStayCity.method('bind', 'userinput', function (mod, data) {
				var queryCityId = '';

				if (this.value == $('#inteCityId').attr('_lastvalue'))
					queryCityId = $('#inteCityId').value();

				var url = ENV + '/international/Tool/AjaxIndexCity.aspx?IsUseNewStyle=T&isCtrip=true&keyword=' + encodeURIComponent(escape($('#inteCityName').value())) + '&cityId=' + queryCityId;

				$.jsonp(url, {
					onload: function (result) {
						var data = result.data;
						var cityList = data.match(/[^@]+\|/g);
						if (cityList && cityList.length > 0) {
							var cityData = cityList[0].split('|');
							if (cityData.length > 1) {
								$('#inteCityName').value(cityData[1] ? cityData[1] : '');
								$('#inteCityName').attr('_lastvalue', this.value);
								$('#inteCityId').value(cityData[2] ? cityData[2] : '');
								$('#inteCityId').attr('_lastvalue', this.value);
							}
						}
						else {
							$('#inteCityName').value('');
							$('#inteCityName').attr('_lastvalue', '');
							$('#inteCityId').value('');
							$('#inteCityId').attr('_lastvalue', '');
						}
						window.$_bf.tracklog("ihtlcity", makeTrackLogVals(result.key, $('#inteCityName').value(), null));
					},
					onerror: function(result){
							$('#inteCityName').value('');
							$('#inteCityName').attr('_lastvalue', '');
							$('#inteCityId').value('');
							$('#inteCityId').attr('_lastvalue', '');
					}
				});
			});

			
			$('#inteCityName').bind('focus', function(){
				CITYENTER = true;
			}).bind('keydown', function(e){
				if(e.keyCode == 13)
				{
					if (!CITYENTER) {
						e.preventDefault ? e.stopPropagation() : e.cancelBubble = true;
						e.preventDefault ? e.preventDefault() : e.returnValue = false;
					} 
					document.getElementById('inteCityName').blur();
					setTimeout(function () {
						if(CITYENTER)
							document.getElementById('HI_Btn').click();
					}, 500);
				}
				if($(this).value() != $(this).attr('_lastvalue'))
				{
					$('#inteCityId').value('');
					$('#inteCityId').attr('_lastvalue', '');
				}
			});
        },

        regCalendar: function() {
            var that = this;
            var start = $("#inteCheckIn");
            var end = $("#inteCheckOut");

            this.modStartDate = start.regMod("calendar", "3.0", {
                options: {
                    showWeek: true,
                    minDate: config.today
                }
            });

            this.modBackDate = end.regMod("calendar", "3.0", {
                options: {
                    showWeek: true,
                    reference: '#' + start[0].id,
                    minDate: start.value().toDate() ? start.value().toDate().addDays(1).toStdDateString() : new Date().addDays(1).toStdDateString()
                }
            });

            start.bind('change', function(e) {
                e = e || window.event;
                var target = e.target || e.srcElement;
                var startDate = target.value.toDate();
                if (startDate) {
                    var nextDate = startDate.addDays(1);
                    end.data('minDate', nextDate.toStdDateString());
                    nextDate = nextDate.addDays(1);
                    var endDate = end.value().toDate();
                    if (!endDate || endDate <= startDate) {
                        end.value(nextDate.toFormatString('yyyy-MM-dd'));
                        endDate = nextDate;
                        end.getMod("notice", "1.0").method("checkValue");
                        end.getMod("calendar", "3.0").method("setWeek", "#" + end[0].id);
                    }
                    if (endDate && endDate - startDate > MAX_STAY) {
                        that.validateShow(end, 7);
                    }
                } else {
                    end.removeData('minDate');
                }
            }.bind(this)).bind('focus', function() {
                if (this.timer) {
                    clearTimeout(this.timer);
                }
            }.bind(this));

            end.bind('focus', function(e) {
                e = e || window.event;
                var target = e.target || e.srcElement;
                var startDate = start.value().toDate();
                var endDate = target.value.toDate();
                if (startDate && endDate && endDate - startDate > MAX_STAY) {
                    that.validateShow(end, 7);
                }
            }.bind(this)).bind('blur', function() {
                this.timer = setTimeout(function() {
                    var startDate = start.value().toDate();
                    var endDate = end.value().toDate();
                    if (startDate && endDate && endDate > startDate) {
                        if (endDate - startDate > MAX_STAY) {
                            that.validateShow(end, 7);
                        }
                    }
                }.bind(this), 100);
            }.bind(this));
        },

        regNotice: function() {
            this.n_cityName = this.setNotice($('#inteCityName'), 'inteCityName', config.notice[5]);
            this.n_checkIn = this.setNotice($('#inteCheckIn'), 'inteCheckIn', 'yyyy-mm-dd');
            this.n_checkOut = this.setNotice($('#inteCheckOut'), 'inteCheckOut', 'yyyy-mm-dd');

            var inteHotelName = $('#inteHotelName');
            this.n_hotelName = this.setNotice(inteHotelName, 'inteHotelName', config.notice[6]);
            // 修正CityName filter 更改后notice失焦失效的问题
            inteHotelName.bind('focus', function () { $(this).attr('fouced', 'true'); });
            inteHotelName.bind('blur', function () { $(this).attr('fouced', 'false'); });
        },

        regHotelName: function() {
            var that = this,
                currentBound = -1,
                beingInput = false,
                sInter;
            var V = {
                'request': function() {
                    var url = ENV + '/international/Tool/AjaxHotelKeyWords.aspx?isjsonp=true&suggest=true&cityId=' + $("#inteCityId").value().trim() + '&keyword=' + escape($('#inteHotelName').value().trim());
                    cQuery.loader.js(url, {
                        type: 'text/javascript',
                        async: true,
                        onload: function() {
                            if (!window._INTL_HOTEL_NAME_) {
                                $('#hotelNameChoice').html('');
                                $('#hotelNameChoice').css('display', 'none');
                                return;
                            }
                            V.render(_INTL_HOTEL_NAME_);
                            _INTL_HOTEL_NAME_ = '';
                        }
                    });
                },
                'replaceWith': function(str, obj) {
                    return str.replace(/\{\$(\w+)\}/g, function(s, k) {
                        if (k in obj) {
                            return obj[k];
                        } else {
                            return s;
                        }
                    });
                },
                'render': function(str) {
                    var temp = '<a href="javascript:;" v="{$hotelNameV}">{$hotelName}</a>',
                    html = [],
                    hotels = str.split('^$^');
                    if (str.trim() === '') {
                        $('#hotelNameChoice').html('');
                        $('#hotelNameChoice').css('display', 'none');
                        return;
                    }
                    for (var i = 0, len = hotels.length; i < len; i++) {
                        html[html.length] = V.replaceWith(temp, {
                            'hotelName': hotels[i],
                            'hotelNameV': hotels[i]
                        });
                    }
                    $('#hotelNameChoice').html(html.join(''));
                    $('#hotelNameChoice').css('display', 'block');
                    V.setGreen();
                },
                'setRequest': function() {
                    var v = $('#inteHotelName').value().trim();
                    if (v === '') {
                        $('#inteHotelName')[0].setAttribute('lv', '');
                        $('#hotelNameChoice').css('display', 'none');
                        return;
                    }
                    if ($('#inteHotelName')[0].getAttribute('lv') !== $('#inteHotelName').value().trim()) {
                        $('#inteHotelName')[0].setAttribute('lv', $('#inteHotelName').value().trim());
                        V.request();
                    }
                },
                'setGreen': function() {
                    var as = $('#hotelNameChoice>a');
                    for (var i = 0, len = as.length; i < len; i++) {
                        var keyword = $('#inteHotelName').value();
                        var html = as[i].innerHTML.replace(keyword, '<b style="color:green">' + keyword + '</b>');
                        as[i].innerHTML = html;
                    }
                },
                'keyUp': function() {
                    var len = $('#hotelNameChoice>a').length;
                    if (currentBound === -1 || currentBound === 0) {
                        currentBound = len - 1;
                    } else {
                        currentBound--;
                    }
                    var as = $('#hotelNameChoice>a');
                    for (var i = 0, len = as.length; i < len; i++) {
                        as[i].className = '';
                    }
                    $('#hotelNameChoice>a')[currentBound].className = 'checked';
                },
                'keyDown': function() {
                    var len = $('#hotelNameChoice>a').length;
                    if (currentBound === (len - 1)) {
                        currentBound = 0;
                    } else {
                        currentBound++;
                    }
                    var as = $('#hotelNameChoice>a');
                    for (var i = 0, len = as.length; i < len; i++) {
                        as[i].className = '';
                    }
                    $('#hotelNameChoice>a')[currentBound].className = 'checked';
                },
                'keyEnter': function() {
                    var checked = $('#hotelNameChoice>a[class=checked]');
                    if (checked.length > 0) {
                        $('#inteHotelName').value(checked[0].getAttribute('v'));
                    }
                    $('#inteHotelName')[0].blur();
                    $('#inteHotelName')[0].setAttribute('lv', $('#inteHotelName').value().trim());
                    currentBound = -1;
                },
                'init': function() {
                    $('#inteHotelName').bind('focus', function() {
                        beingInput = true,
                        sInter = setInterval(V.setRequest, 200);
                        var left = $('#inteHotelName').offset().left,
                        top = $('#inteHotelName').offset().top + $('#inteHotelName')[0].offsetHeight;

                        // var hotelNameList = document.createElement('div');
                            // hotelNameList.className = 'choice';

                        $('#hotelNameChoice').css('left', left + 'px').css('top', top + 'px');

                    }).bind('blur', function() {
                        beingInput = false;
                        clearInterval(sInter);
                        $('#hotelNameChoice').css('display', 'none');
                    }).bind('keydown', function(e) {
                        var e = e || window.event, key = e.which || e.keyCode;
                        switch (key) {
                            case 40:
                                V.keyDown();
                                break;
                            case 38:
                                V.keyUp();
                                break;
                            case 13:
                                V.keyEnter();
                                e.returnValue = false;
                                break;
                            default:
                                break;
                        }
                    });
                    $('#hotelNameChoice').bind('mousedown', function(event) {
                        if (!beingInput) return;

                        event = event ? event : window.event;
                        var target = event.target || event.srcElement;

                        if (target.nodeName === 'A') {
                            $('#inteHotelName').value(target.getAttribute('v'));
                        }
                        $('#inteHotelName')[0].blur();
                        $('#inteHotelName')[0].setAttribute('lv', $('#inteHotelName').value().trim());
                    });
                    V.setRequest();
                }
            };
            that.addHotelNameStyle();
            V.init();
        },

        addHotelNameStyle: function() {
            var cssText = '.choice{position:absolute;width:375px;margin:0px;padding:4px;border:1px solid #7F9DB9;background:#FFF;text-align:left;z-index:120;}' +
                '.choice a{padding:1px 5px 0px 5px;border-top:1px solid #FFF;border-bottom:1px solid #FFF;line-height:20px;color:#05a;display:block;text-decoration:none;min-height:20px}' +
                '* html .choice a{height:20px}' +
                '.choice a:hover, .choice .checked{background-color:#E7F1FD;border-top:1px solid #7F9DB9;border-bottom:1px solid #7F9DB9;text-decoration:none;}' +
                '.choice .close{display:none;}';
            var styles;
            if (document.all) {
                styles = document.createStyleSheet();
                styles.cssText = cssText;
            } else {
                styles = document.createElement("style");
                styles.type = "text/css";
                styles.textContent = cssText;
            }
            try {
                document.getElementsByTagName("head")[0].appendChild(styles);
            } catch (e) {
            }
        },

        autoSetDate: function() {
            var that = this;
            $('#inteCheckIn').bind("change", function() {
                sSetDateValue();
            }, {priority: 10});

            $('#inteCheckOut').bind("change", function() {
                dSetDateValue();
            }, {priority: 10});

            function sSetDateValue() {
                if ($('#inteCheckIn').value().isDate()) {
                    var nextD = $('#inteCheckIn').value().toDate().addDays(1).toStdDateString();
                    $("#inteCheckOut").data('minDate', nextD);
                    if ($("#inteCheckOut").value().trim() === '' || $("#inteCheckOut").value().toDate() <= $('#inteCheckIn').value().toDate()) {
                        var next2D = toDateString($('#inteCheckIn').value().toDate().addDays(2));
                        $("#inteCheckOut").value(next2D);
                        that.n_checkOut.method("checkValue");
                        that.modBackDate.method("setWeek", "#inteCheckOut")
                    }
                }
            }
            function dSetDateValue() {
                if ($('#inteCheckOut').value().isDate()) {
                    if ($("#inteCheckIn").value().trim() === '' || $("#inteCheckOut").value().toDate() <= $('#inteCheckIn').value().toDate()) {
                        var preD = toDateString($('#inteCheckOut').value().toDate().addDays(-2));
                        $("#inteCheckIn").value(preD);
                        that.n_checkIn.method("checkValue");
                        that.modStartDate.method("setWeek", "#inteCheckIn")
                    }
                }
            }
            function toDateString(date) {
                var year = date.getFullYear(),
                    month = date.getMonth() + 1,
                    day = date.getDate();

                month = month < 10 ? ('0' + month) : month;
                day = day < 10 ? ('0' + day) : day;

                return year + '-' + month + '-' + day;
            }
        },

        regValidate: function() {
            var that = this;
            var notNull = function() {
                // 请选择酒店所在城市
                if (that.n_cityName.method("isEmpty")) {
                    that.validateShow($('#inteCityName'), 2);
                    return false;
                }
                // 请输入入住时间
                if (that.n_checkIn.method("isEmpty")) {
                    that.validateShow($('#inteCheckIn'), 3);
                    return false;
                }
                // 请输入离店时间
                if (that.n_checkOut.method("isEmpty")) {
                    that.validateShow($('#inteCheckOut'), 5);
                    return false;
                }
                return true;
            };
            var format = function() {
                // 入住日期格式不正确
                if (!$('#inteCheckIn').value().isDate()) {
                    that.validateShow($('#inteCheckIn'), 0);
                    return false;
                }
                // 退房日期格式不正确
                if (!$('#inteCheckOut').value().isDate()) {
                    that.validateShow($('#inteCheckOut'), 1);
                    return false;
                }
                return true;
            };
            var checkDate = function() {
                var today = config.today;
                // 入住时间不能早于{$today}(当前日期)
                if ($('#inteCheckIn').value().toDate() < today.toDate()) {
                    // var tip = config.tip.inteHotel[4].replaceWith({
                        // today: today
                    // });
                    that.validateShow($('#inteCheckIn'), 4);
                    return false;
                }
                // 退房日期需要大于入住日期
                if ($('#inteCheckOut').value().toDate() <= $('#inteCheckIn').value().toDate()) {
                    that.validateShow($('#inteCheckOut'), 6);
                    return false;
                }
                // 您入住酒店时间超过28天，请分订单提交预订
                if ($('#inteCheckOut').value().toDate() - $('#inteCheckIn').value().toDate() > 28 * 24 * 60 * 60 * 1000) {
                    that.validateShow($('#inteCheckOut'), 7);
                    return false;
                }
                return true;
            };
            this.regValidateMethod(notNull);
            this.regValidateMethod(format);
            this.regValidateMethod(checkDate);
        },

        setAction: function() {
            var arr = cityObj.py.split(',');
            if (arr.length > 1) {
                cityObj.py = arr[0];
                cityObj.py = cityObj.py.toLowerCase().replace(/[\,\'\/\-\s]+|\(.*\)/gi, '');
            }

            var link = '';
            if (cityObj.id == '58') {
                link = '/hotel/hong kong58';
            } else if (cityObj.id == '59') {
                link = '/hotel/macau59';
            } else {
                link = '/international/' + (/[^a-zA-Z]/.test(cityObj.py) ? '' : cityObj.py) + cityObj.id;
            }

            var inteHotelName = document.getElementById('inteHotelName');
            if (inteHotelName.value == config.notice[6]) {
                inteHotelName.value = '';
            } else if (inteHotelName.value != '') {
                link += '/k2' + inteHotelName.value;
            }

            // this.form[0].action = config.url.inteHotelAction + link;
            this.form[0].action = ENV + link;
        },

        setCookie: function() {
            var arr = [];

            arr.push($('#inteCityId').value() || cityObj.id);
            arr.push($('#inteCityName').value());
            arr.push($('#inteCityPy').value() || cityObj.py);
            arr.push($('#inteCheckIn').value());
            arr.push($('#inteCheckOut').value());

            cQuery.cookie.set(location.host.match(/big5\./) ? 'BIntHotelCityID' : 'IntHotelCityID', null, arr.join('split'), {expires: 365, domain: document.location.hostname.replace(/www\.|big5\./, ''), path: '/'});
        },

        // convert yyyy-mm-dd to millisecond, cuz some browser(as safari, ie7 etc.) not support new Date('yyyy-mm-dd')
        getMsec: function(str) {
            if (!str) return;
            var arr = str.split('-');
            return new Date(arr[0], arr[1], arr[2]).getTime();
        },

        getCookie: function() {
            var checkIn, checkOut,
                cityStr = cQuery.cookie.get(location.host.match(/big5\./) ? 'BIntHotelCityID' : 'IntHotelCityID');

            if (cityStr) {
                var arr = cityStr.split('split');

                cityObj.id = arr[0];
                cityObj.py = arr[2];

                $('#inteCityId').value(cityObj.id);
                $('#inteCityName').value(arr[1]);
                $('#inteCityPy').value(cityObj.py);

                this.n_cityName.method("checkValue");

                checkIn = arr[3];
                checkOut = arr[4];
            }

            if (checkIn && (this.getMsec(checkIn) > this.getMsec(config.today))) {
                $('#inteCheckIn').value(checkIn);
            } else {
                // 海外酒店日期默认是 14住
                $('#inteCheckIn').value(config.today.toDate().addDays(14).toStdDateString());
            }
            if (checkOut && (this.getMsec(checkOut) > this.getMsec(config.tomorrow))) {
                $('#inteCheckOut').value(checkOut);
            } else {
                // 海外酒店日期默认是 15离
                $('#inteCheckOut').value(config.tomorrow.toDate().addDays(14).toStdDateString());
            }

            this.n_checkIn.method("checkValue");
            this.n_checkOut.method("checkValue");
        },

        setStorage: function() {
            var storage = {
                "inteCityName": $("#inteCityName").value(),
                "inteCheckIn": $("#inteCheckIn").value(),
                "inteCheckOut": $("#inteCheckOut").value()
            }
            $.pageStorage.set("inteHotelValue", storage);
        },

        getStorage: function() {
            if (typeof $.pageStorage.get("inteHotelValue") !== 'undefined') {
                var storage = $.pageStorage.get("inteHotelValue");
                for (var dom in storage) {
                    $("#" + dom).value(storage[dom]);
                }
            }
            this.n_cityName.method("checkValue");
            this.n_checkIn.method("checkValue");
            this.n_checkOut.method("checkValue");
        },

        setMonitor: function() {
            // 海外酒店输入监控
            this.modStayCity.method('bind', 'userinput', function(mod, data) {
                if (data && window.$_bf && window.$_bf.tracklog) {
                    if (data.value) {
                        window.$_bf.tracklog("ihtlcity", data.value);
                    }
                    if (data.autoCorrectValue) {
                        window.$_bf.tracklog("ihtlcity", data.autoCorrectValue);
                    }
                }
            })
        },

        init: function() {
            this.regStayCity();
            this.regCalendar();
            this.regNotice();
            this.regHotelName();
            this.autoSetDate();
            this.regValidate();
            this.bindSubmit();
            this.getStorage();
            this.getCookie();
            this.setMonitor();
        }
    };

    InteHotel.init();
})(cQuery);

//正则表达式的特殊字符处理
function filterSpicalCharForRegx(value) {
	var spicalChar = ['\\', '^', '$', '.', '*', '+', '=', ':', '|', '/', '(', ')', '[', ']', '{', '}'];
	for (var i = 0; i < spicalChar.length; i++) {
		value = value.replace(spicalChar[i], '\\' + spicalChar[i]);
	}
	return value;
}/*****env:4,update:2013-9-3 14:06:03*****/