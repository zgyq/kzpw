;(function($){
	var cls = {
		name: 'sideBar',
		version: '2.0',
		init: function(){},
		uninit: function(){},
		module: sideBar
	};

	var doc = document, win = window, delay_ms = 100;

	var defaultConf = {
		HTML: '<div class="side_fixed" id="sidebar">\
					<a class="to_top" title="${backTop}" href="javascript:;" id="gotop2">&nbsp;</a>\
					<a target="_blank" class="c_sidebar" href="${feedBackURL}" title="${feedBack}">${feedBack}</a>\
					<a target="_blank" class="c_sidebar" href="${liveChatURL}" title="${liveChat}">${liveChat}</a>\
				</div>',
		CSS: '.side_fixed{position:fixed;right:20px;bottom:50px;z-index:9999;width:35px;}\
			.to_top,.c_sidebar{background-image:url(${src});_background-image:url(${srcIE6});background-repeat:no-repeat;}\
			.to_top{position:relative;float:left;clear:both;width:35px;height:0;margin-bottom:2px;padding-top:35px;overflow:hidden;cursor:pointer;z-index:2;visibility:hidden;background-position:0 0;}\
			.to_top:hover{background-position:-79px 0;}\
			.c_sidebar{display:inline-block;width:35px;height:32px;padding-top:3px;margin-bottom:2px;overflow:hidden;vertical-align:top;font-size:12px;color:#fff;background-position:0 -37px;text-align:center;text-decoration:none;line-height:14px;}\
			.c_sidebar:hover{background-position:-79px -37px;}\
			.c_sidebar_hl{background-position:-40px -37px;}',
		extraCSS: '',

		url: {
			//feedBackURL: 'http://accounts.ctrip.com/MyCtrip/Community/CommunityAdvice.aspx',
			//liveChatURL: 'http://livechat.ctrip.com/livechat/Login.aspx?GroupCode=CustomerService&AsFrom=1'
		},

		bgSrc: {
			src: 'http://pic.c-ctrip.com/common/un_sidebar.png',
			srcIE6: 'http://pic.c-ctrip.com/common/un_sidebar_8.png'
		},

		title: {
			backTop: '回到顶端',
			feedBack: '建议反馈',
			liveChat: '在线客服'
		},

		backTop: '#gotop2',

		threshold_px: 500,
		bottom_px: 50,
		right_px: 5
	};

	function sideBar(node, conf) {
		 this.init(conf);
	}

	sideBar.prototype = {
		init: function (conf) {
			this.conf = this.setConf(conf);
			this._preprocess();
			this._createHTML();
			this._initSideBar();

			$(win).trigger('scroll');
		},

		setConf: function (conf) {
			return $.extend(true, {}, defaultConf, conf || {});
		},

		_preprocess: function () {
			this.html = this._convertHTML();
			this.css = this._convertCSS();
		},

		_convertHTML: function () {
			var conf = this.conf, html = conf.HTML,
				tmplData = {};

			tmplData = $.extend({}, conf.url, conf.title);

			html = $.tmpl.render(html, tmplData);

			return html;
		},

		_convertCSS: function () {
			var conf = this.conf, css = conf.CSS;

			css = css + conf.extraCSS;

			css = $.tmpl.render(css, conf.bgSrc);

			return css;
		},

		_createHTML: function () {
			var sideBarDiv, sideBarCSS;

			this.sideBarDiv = sideBarDiv = doc.createElement('div');
			this.uid = sideBarDiv.id = $(sideBarDiv).uid();

			sideBarCSS = this._createCSS();

			sideBarDiv.innerHTML = sideBarCSS + this.html;

			$('body').append(sideBarDiv);
		},

		_createCSS: function () {
			var css = this.css;

			css = this._uniqueCSS(css);
			css = '<style>' + css + '</style>';

			css = $.browser.isIE ? this._fixIECSS(css) : css;

			return css;
		},

		_uniqueCSS: function (css) {
			var uid = this.uid, retCSS;

			retCSS = css.replace(/(\s*)([^\{\}]+)\{/g, function(a, b, c){
						return b + c.replace(/([^,]+)/g, '#'+ uid +' $1') + '{';
					});

			return retCSS;
		},

		_fixIECSS: function (css) {
			return '<pre style="display:none;">fixIE</pre>' + css;
		},

		_initSideBar: function () {
			var conf = this.conf, id = conf.id, sideBar;
			this.sideBar = sideBar = $(this.sideBarDiv.lastChild);
			this.backTop = $(conf.backTop);
			this.threshold = conf.threshold_px;
			this.bottom = conf.bottom_px;
			this.right = conf.right_px;

			this.sideBarWidth = this._getSideBarWH('width');
			this.sideBarHeight = this._getSideBarWH('height');

			sideBar.css({
				bottom: this.bottom + 'px',
				right: this.right + 'px'
			});

			this._bindEvent();
		},

		_bindEvent: function () {
			var browser = $.browser;
			$(win).bind(['scroll', 'resize'], this.toggleBackTopWithThrottle.bind(this));

			this.backTop.bind('click', this._backToTop.bind(this));

			if (browser.isIE6 || browser.isIPad) {
				this._bindEventWithAbs();
			}
		},

		_bindEventWithAbs: function () {
			this.sideBar.css('position', 'absolute');

			$(win).bind(['scroll', 'resize'], this.goToBottomWithThrottle.bind(this));
		},

		_backToTop: function () {
			var x = this._getScroll('Left');

			win.scrollTo(x, 0);
		},

		_getScroll: function(LeftTop) {
			var ret = 0, docEl = doc.documentElement, scrollLeftTop = 'scroll' + LeftTop;

			if (docEl && docEl[scrollLeftTop]) {
				ret = docEl[scrollLeftTop];
			} else if (doc.body) {
				ret = doc.body[scrollLeftTop];
			}

			return ret;
		},

		_getSideBarWH: function(tag) {
			var offsetWH = (tag === 'width' ? 'offsetWidth' : 'offsetHeight');

			return parseInt(this.sideBar[0][offsetWH], 10);
		},

		_throttle: function(fn, delay, context) {
			var self = this;

			clearTimeout(fn.timerID);

			fn.timerID = setTimeout(function() {
				fn.call(context || self);
			}, delay);
		},

		// _animate: function(elem, css, duration, callback) {
		// 	clearInterval(elem._timer);

		// 	function tween(x) {
		// 		return (x /= 0.5) < 1 ? (0.5 * Math.pow(x, 2)) : (-0.5 * ((x -= 2) * x - 2));
		// 	}

		// 	function ontween(pos) {
		// 		var obj, val, form, to, name, unit, i = 0,
		// 			len = css.length;

		// 		for (; i < len; i++) {
		// 			obj = css[i];
		// 			from = obj[0];
		// 			to = obj[1];
		// 			name = obj[2];
		// 			unit = obj[3];
		// 			val = from + (to - from) * tween(pos);

		// 			if (name == "opacity") {
		// 				elem.style[name] = val;
		// 				elem.style.filter = 'alpha(opacity=' + (val * 100) + ')';
		// 			} else {
		// 				elem.style[name] = (val + unit);
		// 			}
		// 		}
		// 	}

		// 	function onend(pos) {
		// 		ontween(pos);

		// 		callback && callback.call(elem);
		// 	}

		// 	function fx(ontween, onend, duration) {
		// 		var pos, runTime, startTime = +new Date;
		// 		elem._timer = setInterval(function() {
		// 			runTime = +new Date - startTime;
		// 			pos = runTime / duration;
		// 			if (pos >= 1) {
		// 				clearInterval(elem._timer);
		// 				onend(pos);
		// 			} else {
		// 				ontween(pos);
		// 			};
		// 		}, 13);
		// 	}

		// 	fx(ontween, onend, duration);
		// },

		_show: function () {
			this.backTop.css('visibility', 'visible');
		},

		_hide: function() {
			this.backTop.css('visibility', 'hidden');
		},

		_toggleBcakTop: function() {
			var scrollY = this._getScroll('Top');

			if (scrollY > this.threshold) {
				this._show();
			} else {
				this._hide();
			}
		},

		_goToBottom: function() {
			// var originalTop = parseInt(this.sideBar.offset().top, 10);
			var top = this._calculateTop(),
				left = this._calculateLeft();

			// this._animate(this.sideBar[0], [
			// 	[originalTop, top, 'top', 'px']
			// ], 300);
			this.sideBar.css({
				top: top + 'px',
				left: left + 'px'
			});
		},

		_calculateTop: function() {
			var scrollY = this._getScroll('Top'),
				viewHeight = this._getViewWH('Height');

			return scrollY + viewHeight - this.bottom - this.sideBarHeight;
		},

		_calculateLeft: function() {
			var scrollX = this._getScroll('Left'),
				viewWidth = this._getViewWH('Width');

			return scrollX + viewWidth - this.right - this.sideBarWidth;
		},

		_getViewWH: function(WH) {
			var ret = 0;

			ret = doc.documentElement['inner' + WH] || this._getViewWHForIE(WH);

			return ret;
		},

		_getViewWHForIE: function(WH) {
			var client = doc.compatMode == 'BackCompat' ? doc.body : doc.documentElement;

			return client['client' + WH];
		},

		toggleBackTopWithThrottle: function() {
			this._throttle(this._toggleBcakTop, delay_ms);
		},

		goToBottomWithThrottle: function() {
			this._throttle(this._goToBottom, delay_ms);
		}
	};

	$.mod.reg(cls);
})(cQuery);