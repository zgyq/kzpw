;(function($) {
	var cls = {
		name: 'jmp',
		version: '1.0',
		init: function() {},
		uninit: function() {},
		module: jmp	
	};
	//绑定window的onresize事件
	var _onresize = window.onresize;
	window.onresize = function() {
		if(_onresize)_onresize();
		for (var n in jmp.queue) {
			var o = jmp.queue[n];
			if (o.active && o.opt.options.adjust.resize) {
				o._update();
			}
		}
	}
	//绑定window的onscroll事件
	var _onscroll = window.onscroll;
	window.onscroll = function() {
		if(_onscroll)_onscroll();
		for (var n in jmp.queue) {
			var o = jmp.queue[n];
			if (o.active && o.opt.options.adjust.scroll) {
				o._update();
			}
		}
	}
	/**
	 *控件实例
	 * @param {Object} obj 用绑定控件的元素
	 * @param {Object} opt 参数对象
	 * @hide
	 */	
	jmp["float"] = function (obj, opt) {
		// 判断是否绑定控件。每个绑定控件的元素都有一个jmp。jmp为当前控件的实例
		if (obj.jmp)  
			return obj.jmp;  
		// 如果没有绑定控件，则开始实例化控件
		if ( jmp == this ) 
			return new jmp["float"](obj, opt);  
		this._init(obj, opt);
	}
	
	$.extend(jmp["float"].prototype, {
			/**
			*构造函数
			* @hide			
			* @constructor
			* @param {HTMLElement} 	obj  		作用的HTML元素
			* @param {Object} 		opt  		配置项
			*/			
			_init:function (obj, opt) {
				this._setOptions(obj, opt);
				this._render();
				this._bindEvent();
				jmp.queue[$(obj).uid()] = this;	
				jmp.creatStyle(this.opt.options);
			},
			/**
			*设置参数
			* @hide			
			* @param {HTMLElement} 	obj  		作用的HTML元素
			* @param {Object} 		opt  		配置项
			*/				
			_setOptions:function (obj, opt) {
				this.elem = obj;
				//将控件的实例化绑定给对象
				this.elem.jmp = this;
				var params = this._getAttrOptions();
				var defaults = $.copy(jmp.defaults);
				if(defaults.unsimple)defaults.options.version = null;
				var defaults = $.extend(true,defaults,params);
				this.opt = $.extend(true,defaults,opt);
				
				this.active = false;
				this.disabled = false;
			},	
			/**
			*获取元素属性上传入的参数
			* @hide
			* @return {Object} 		params  		属性上的参数对象
			*/				
			_getAttrOptions:function () {
				var attrParamsName =jmp.ATTR_PARAM_NAME;
				var params = this.elem.getAttribute(attrParamsName);
				if(params) {
					params = eval("("+params+")");
				} else {
					params = {};
				}
				return params;
			},
			/**
			*渲染浮出层的页面内容
			* @hide
			*/				
			_render:function () {
				this._getTip();
				this._getIframe();
			},
			/**
			*生成浮出层
			* @hide
			*/	
			_getTip:function () {
				var options = this.opt.options;
				var classNames = options.classNames;
				var css = options.css;
				var group = options.group;
				var uid = $(this.elem).uid();	
				//var tip = $("#jmp-tip-"+uid)[0];
				var div = document.createElement("div");
				
				div.innerHTML = $.tmpl.render(options.templs.tipTempl, {
					id:"jmp-tip-"+uid,
					group:group,
					tip:classNames.tip,
					box:classNames.box,
					boxType:classNames.boxType,
					boxArrow:classNames.boxArrow,
					arrow:classNames.arrow,
					loading:classNames.loading,
					loadingImg:"loading...",
					maxWidth:css.maxWidth,
					minWidth:css.minWidth,
					content:classNames.tipContent//$.tmpl.render(this.temp, this.data)
				});
				document.body.appendChild(div.firstChild);
				this.tip = $("#jmp-tip-"+uid)[0];
				this.box = $("."+classNames.box, this.tip)[0];
				this.arrow = $("."+classNames.arrow, this.tip)[0];
				this.loading = $("."+classNames.loading, this.tip)[0];
				this.content = $("."+classNames.tipContent, this.tip)[0];
			},
			/**
			*获取浮出层对应的iframe
			* @hide
			*/			
			_getIframe:function () {
				var group = this.opt.options.group;
				
				var iframe = jmp.iframe(group);
				
				this.iframe = iframe;
			},
			/**
			*给当前target对象绑定事件
			* @hide
			*/				
			_bindEvent:function () {
				var self = this;
				var options = this.opt.options;
				var allowTipHover = options.allowTipHover;
				var hideTip = options.hideTip;
				var eventType = options.eventType;
				var events = options.events;
				var eventArr = events[eventType].split(",");
				
				var shows = eventArr[0].split("|");
				
				var hides = eventArr[1].split("|");
				
				this.shows = shows;
				this.hides = hides;
				this.shows.each(function (_o,i,obj) {
					$(self.elem).bind(_o,function () {
						
						self._readyShow.call(self,arguments);
					});
				});
				
				hides.each(function (_o,i,obj) {
					$(self.elem).bind(_o,function () {
						self._readyHide.call(self,arguments);
					});
				});
				$(this.elem).bind('mousemove',self._mousemove.bind(self));
				if (allowTipHover) {
					$(this.tip).bind('mouseover',self._clearTimeouts.bind(self));
					if (hideTip) {
						$(this.tip).bind('mouseout',self._mouseout.bind(self));
					}
				}
			},
			/**
			*浮动层显示函数
			* @hide
			* @param {event} e event事件源
			*/				
			_readyShow:function () {
				var self = this;
				var e = arguments[0][0]
				var opt = arguments[0][1]
				if(!opt && !jmp.fixedMouse(e,self.elem))return;
				self._clearTimeouts();
				self.showTimeout = 
				setTimeout(function () {
					self._show.call(self,e);
				}, self.opt.options.showTimeout);					
			},
			/**
			*浮动层隐藏函数
			* @hide
			* @param {event} e event事件源
			*/
			_readyHide:function () {
				var self = this;
				var e = arguments[0][0]
				var opt = arguments[0][1]
				if(!opt && !jmp.fixedMouse(e,self.elem))return;
				this._clearTimeouts();
				this.hideTimeout = setTimeout(this._hide.bind(this),this.opt.options.hideTimeout);					
			},
			/**
			*target的mouseover事件
			* @hide
			* @param {event} e event事件源
			*/
			_mouseover:function (e) {
				var self = this;
				self._clearTimeouts();
				self.showTimeout = 
				setTimeout(function () {
					self._show(e);
				}, self.opt.options.showTimeout);			
			},
			/**
			*target的mouseout事件
			* @hide
			* @param {event} e event事件源
			*/			
			_mouseout:function () {
				this._clearTimeouts();
				this.hideTimeout = setTimeout(this._hide.bind(this),this.opt.options.hideTimeout);			
			},
			/**
			*target的mousemove事件
			* @hide
			* @param {event} e event事件源
			*/				
			_mousemove:function (e) {
				//document.title = e.clientX;
				var self = this;
				this.e = jmp.fixE(e);
				var followCursor = this.opt.options.followCursor;
				
				if (!followCursor) return;
				if (this.disabled || !this.active)return;	
				setTimeout(function () {
					self._getPos("mousemove");
					var showDot = self.position["showDot"];
					if (!showDot.length) return; 
					self._moveBoundary.call(self,self._setPos.bind(self));
				},16);		
				
			},
			/**
			*判断鼠标移动时，是否越界
			* @param {function} callback 回调函数
			* @hide
			*/			
			_moveBoundary:function (callback) {
				var self = this;
				var showDot = self.position["showDot"];
				var arrow = showDot.arrow;
				var arrow = arrow.split("|");
				var alignTo = self.opt.options.alignTo;
				var ret = false;
				var prevShowArrow = this.prevShowArrow.split("-");
				if (alignTo!= "cursor") {
					if (arrow[0]=="t" || arrow[0]=="b") {
						if (prevShowArrow[0] == 'bottomRight' || 
							prevShowArrow[0] == 'topRight' || 
							prevShowArrow[0] == 'rightBottom' || 
							prevShowArrow[0] == 'rightTop') {
							if (self.e.pageX >=self.showEventPos.x) {
								ret=true;
							}
						}
						if (prevShowArrow[0] == 'bottomLeft' ||
							prevShowArrow[0] == 'topLeft' ||
							prevShowArrow[0] == 'leftBottom' ||
							prevShowArrow[0] == 'leftTop') {
							if (self.e.pageX <=self.showEventPos.x) {
								ret=true;
							}
						}
						if (prevShowArrow[0] == 'topMiddle' || 
							prevShowArrow[0] == 'bottomMiddle' ) {
							var t_width = self.position["target_width"];
							var sub = self.e.pageX -self.showEventPos.x;
							sub = Math.abs(sub)
							if (sub>=t_width/2) {
								ret=true;
							}
						}
					}
					if (arrow[0]=="l" || arrow[0]=="r") {
						if (prevShowArrow[0] == 'rightTop' ||
							prevShowArrow[0] == 'topRight' || 
							prevShowArrow[0] == 'leftTop' || 
							prevShowArrow[0] == 'topLeft') {
							if (self.e.pageY <=self.showEventPos.y) {
								ret=true;
							}
						}
						if (prevShowArrow[0] == 'rightBottom' || 
							prevShowArrow[0] == 'leftBottom'|| 
							prevShowArrow[0] == 'bottomRight'|| 
							prevShowArrow[0] == 'bottomLeft'
							) {
							if (self.e.pageY >=self.showEventPos.y) {
								ret=true;
							}
						}
						if (prevShowArrow[0] == 'rightMiddle' || 
							prevShowArrow[0] == 'leftMiddle' ) {
							var t_height = this.position["target_height"];
							var sub = self.e.pageY -self.showEventPos.y;
							sub = Math.abs(sub)
							
							if (sub>=t_height/2) {
								ret=true;
							}
						}
					}
				}
				
				if (!ret) {
					callback.call(self);
				}
			},
			/**
			*清除掉所有的timeout
			* @hide
			*/				
			_clearTimeouts:function () {
				if (this.showTimeout) {
					clearTimeout(this.showTimeout);
					this.showTimeout = 0;
				}
				if (this.hideTimeout) {
					clearTimeout(this.hideTimeout);
					this.hideTimeout = 0;
				}
				if (this.animateTiemout) {
					clearTimeout(this.animateTiemout);
					this.animateTiemout = 0;
				}
			},
			/**
			*浮动层显示函数
			* @hide
			* @param {event} e event事件源
			*/				
			_show:function (e) {
				var self = this;
				if (this.disabled)return;
				
				// 如果timeOnScreen有值，当处于显示状态，鼠标再次移上去时，
				// 添加隐藏浮动层函数
				
				if (this.active) {
					var timeOnScreen = self.opt.options.timeOnScreen;
					if (timeOnScreen) {
						self.hideTimeout = setTimeout(self._hide.bind(self),timeOnScreen);
					} else {
						return;
					}
				}
				self._update();
				self._updateContent();
			},
			/**
			* @hide
			*/				
			_update:function () {
				var self = this;
				self._hideGroup();
				// 获取位置
				self._getPos();
				// 记录显示时的鼠标位置
				self.showEventPos = self.position["eventPos"];
				var showDot = self.position["showDot"];
				
				if (!showDot.length) return;
				
				// 校正位置
				self._setPos();
				
				var api = self.opt.options.api;
				api.onBeforeShow.call(self,self.tip);
				jmp.setIndex(self.iframe);
				jmp.setIndex(self.tip);
				$(self.tip).css({
					visibility: "visible"
				});	
				$(self.iframe).css({
					"display": ""
				})
				
				
				
				// $(self.loading).css({display:"block"});
				// $(self.content).css({display:"none"});
				
				self.active = true;
				api.onShow.call(self,self.tip);
				
				var timeOnScreen = self.opt.options.timeOnScreen;
				if (timeOnScreen) {
					self.hideTimeout = setTimeout(self._hide.bind(self),timeOnScreen);
				}
			},
			/**
			*将同一组内的浮出层都隐藏掉
			* @hide			
			*/				
			_hideGroup:function () {
				var group = this.opt.options.group;
				$("[group="+group+"]").css({
					visibility: "hidden",
					left: "-9999px",
					top: "-9999px"
				});
				$("[group="+group+"]").each(function (_this,i,obj) {
					var id = $(_this).attr("id").replace('jmp-tip-','')
					var oJmp = jmp.queue[id] || null;
					if(oJmp)oJmp.active =false;
				});
			},
			/**
			*获取位置坐标
			* @hide
			*/			
			_getPos:function (type) {
				this.position = {};
				this._getWinPos();
				this._getTargetPos();
				this._getEventPos();
				this._getTipPos();
				this._getSubPos();
				this._getCoordinatesDot();
				this._getAllDot();
				this._getFilterDot();
				this._enableDot();
				this._getShowDot(type);
			},
			/**
			*获取window对象位置坐标
			* @hide
			*/			
			_getWinPos:function () {
				this.position["win_width"] = jmp.getViewWidth();
				this.position["win_height"] = jmp.getViewHeight ();
				this.position["win_scrollTop"] = jmp.getViewScrollTop();
				this.position["win_scrollLeft"] = jmp.getViewScrollLeft();
			},
			/**
			*获取target对象位置坐标
			* @hide
			*/				
			_getTargetPos:function () {
				var target = $(this.elem).offset();
				this.position["target_left"] = target.left;
				this.position["target_top"] = target.top;
				this.position["target_width"] = target.width;
				this.position["target_height"] = target.height;
			},
			/**
			*获取鼠标的位置坐标
			* @hide
			*/				
			_getEventPos:function () {
				var eventPos = {
					top:0,
					left:0,
					right:0,
					bottom:0,
					x:0,
					y:0
				};
				try {
					eventPos["top"] = 
					this.e.pageY - this.position["target_top"];
					eventPos["left"] = 
					this.e.pageX - this.position["target_left"];
					eventPos["right"] = 
					this.position["target_width"] - eventPos["left"];
					eventPos["bottom"] =
					this.position["target_height"] - eventPos["top"];
					eventPos["x"] = this.e.pageX;
					eventPos["y"] = this.e.pageY;
				} catch (e) {
					
				} 
				
				this.position["eventPos"] = eventPos;
			},
			/**
			*获取浮出层各种位置对应的坐标
			* @hide
			*/			
			_getTipPos:function () {
				var tipPos = {};
				var self = this;
				var originalClass = this.arrow.className;
				function pos(k) {
					self.box.className = 
					self.box.className.replace(/[trblc]$/, k);
					if (self.opt.options.showArrow) {
						if ( k == "c") {
							self.arrow.style.display ="none";
						} else {
							self.arrow.style.display ="block";
							self.arrow.className = 
							self.arrow.className.replace(/[trblc]$/, k);
						}
					} else {
						self.arrow.style.display ="none";
					}
					tipPos[k] = {
						width:parseInt(self.tip.offsetWidth, 10),
						height:parseInt(self.tip.offsetHeight, 10)
					};
				}
				var arr = ["t","b","l","r","c"];
				arr.each(function (_this,i,obj) {
					pos(_this);
				});
				tipPos.length = arr.length;
				this.position["tipPos"] = tipPos;
				pos(originalClass.charAt(originalClass.length-1))
				
			},
			/**
			*获取target对象上下左右对应的空间
			* @hide
			*/				
			_getSubPos : function () {
				this.position["sub_left"] = 
				this.position["target_left"]-
				this.position["win_scrollLeft"];
				
				this.position["sub_right"] = 
				this.position["win_width"]+
				this.position["win_scrollLeft"]-
				this.position["target_left"]-
				this.position["target_width"];
				
				this.position["sub_top"] = 
				this.position["target_top"]-
				this.position["win_scrollTop"];
				
				this.position["sub_bottom"] = 
				this.position["win_height"]+
				this.position["win_scrollTop"]-
				
				this.position["target_top"]-
				this.position["target_height"];
			},
			/**
			*获取圆点对应各种位置的坐标
			* @hide
			*/				
			_getCoordinatesDot:function () {
				var t_left = this.position["target_left"];
				var t_top = this.position["target_top"];
				
				var tipPos = this.position["tipPos"];
				if(this.opt.options.version == "simple"){
					var coordDot = {
						topLeft: {
							left: t_left,
							top: t_top,
							arrow: "t|l",
							padding: "l",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:0,//-8,
							offsetY:0
						},
						topMiddle: {
							left: t_left - tipPos["t"].width / 2,
							top: t_top,
							arrow: "t|m",
							padding: "none",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:0,
							offsetY:0
							
						},
						topRight: {
							left: t_left - tipPos["t"].width,
							top: t_top,
							arrow: "t|r",
							padding: "t",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:0,
							offsetY:0
						},
						bottomLeft: {
							left: t_left,
							top: t_top - tipPos["b"].height,
							arrow: "b|l",
							padding: "l",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:0,
							offsetY:0
						},
						bottomMiddle: {
							left: t_left - tipPos["b"].width / 2,
							top: t_top - tipPos["b"].height,
							arrow: "b|m",
							padding: "none",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:0,
							offsetY:0
						},
						bottomRight: {
							left: t_left - tipPos["b"].width,
							top: t_top - tipPos["b"].height,
							arrow: "b|r",
							padding: "r",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:0,
							offsetY:0
						},
						leftTop: {
							left: t_left,
							top: t_top,
							arrow: "l|t",
							padding: "l",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:0
						},
						leftMiddle: {
							left: t_left,
							top: t_top - tipPos["l"].height / 2,
							arrow: "l|m",
							padding: "none",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:0
						},
						leftBottom: {
							left: t_left,
							top: t_top - tipPos["l"].height,
							arrow: "l|b",
							padding: "l",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:0
						},
						rightTop: {
							left: t_left - tipPos["r"].width,
							top: t_top,
							arrow: "r|t",
							padding: "t",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:0
						},
						rightMiddle: {
							left: t_left - tipPos["r"].width ,
							top: t_top - tipPos["r"].height / 2,
							arrow: "r|m",
							padding: "none",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:0
						},
						rightBottom: {
							left: t_left - tipPos["r"].width,
							top: t_top - tipPos["r"].height,
							arrow: "r|b",
							padding: "b",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:0
						},
						center: {
							left: t_left - tipPos["c"].width / 2,
							top: t_top - tipPos["c"].height / 2,
							arrow: "none",
							padding: "none",
							width:tipPos["c"].width,
							height:tipPos["c"].height,
							offsetX:0,
							offsetY:0
						}
					}
				}else {
					var coordDot = {
						topLeft: {
							left: t_left,
							top: t_top,
							arrow: "t|l",
							padding: "l",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:-8,
							offsetY:0
						},
						topMiddle: {
							left: t_left - tipPos["t"].width / 2,
							top: t_top,
							arrow: "t|m",
							padding: "none",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:0,
							offsetY:0
							
						},
						topRight: {
							left: t_left - tipPos["t"].width,
							top: t_top,
							arrow: "t|r",
							padding: "t",
							width:tipPos["t"].width,
							height:tipPos["t"].height,
							offsetX:8,
							offsetY:0
						},
						bottomLeft: {
							left: t_left,
							top: t_top - tipPos["b"].height,
							arrow: "b|l",
							padding: "l",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:-5,
							offsetY:0
						},
						bottomMiddle: {
							left: t_left - tipPos["b"].width / 2,
							top: t_top - tipPos["b"].height,
							arrow: "b|m",
							padding: "none",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:0,
							offsetY:0
						},
						bottomRight: {
							left: t_left - tipPos["b"].width,
							top: t_top - tipPos["b"].height,
							arrow: "b|r",
							padding: "r",
							width:tipPos["b"].width,
							height:tipPos["b"].height,
							offsetX:4,
							offsetY:0
						},
						leftTop: {
							left: t_left,
							top: t_top,
							arrow: "l|t",
							padding: "l",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:-8
						},
						leftMiddle: {
							left: t_left,
							top: t_top - tipPos["l"].height / 2,
							arrow: "l|m",
							padding: "none",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:0
						},
						leftBottom: {
							left: t_left,
							top: t_top - tipPos["l"].height,
							arrow: "l|b",
							padding: "l",
							width:tipPos["l"].width,
							height:tipPos["l"].height,
							offsetX:0,
							offsetY:4
						},
						rightTop: {
							left: t_left - tipPos["r"].width,
							top: t_top,
							arrow: "r|t",
							padding: "t",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:-8
						},
						rightMiddle: {
							left: t_left - tipPos["r"].width ,
							top: t_top - tipPos["r"].height / 2,
							arrow: "r|m",
							padding: "none",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:0
						},
						rightBottom: {
							left: t_left - tipPos["r"].width,
							top: t_top - tipPos["r"].height,
							arrow: "r|b",
							padding: "b",
							width:tipPos["r"].width,
							height:tipPos["r"].height,
							offsetX:0,
							offsetY:4
						},
						center: {
							left: t_left - tipPos["c"].width / 2,
							top: t_top - tipPos["c"].height / 2,
							arrow: "none",
							padding: "none",
							width:tipPos["c"].width,
							height:tipPos["c"].height,
							offsetX:-4,
							offsetY:0
						}
					}
				}
				this.position["coordDot"] = coordDot;
			},
			/**
			*获取所有点对应各种位置的坐标
			* @hide
			*/				
			_getAllDot:function () {
				var coordDot = this.position["coordDot"];

				var allDot = {};
				var no = 0;
				var eventPos = this.position["eventPos"];
				
				var t_width = this.position["target_width"];
				var t_height = this.position["target_height"];
				var temp = [
					["bottomLeft", 0, t_height, "bottom", "Left"],
					["bottomMiddle",t_width/2,t_height,"bottom","Middle"], 
					["bottomRight", t_width, t_height, "bottom", "Right"],
					["topLeft", 0, 0, "top", "Left"], 
					["topMiddle", t_width / 2, 0, "top", "Middle"],
					["topRight", t_width, 0, "top", "Right"], 
					["leftTop", 0, 0, "left", "Top"], 
					["leftMiddle", 0, t_height / 2, "left", "Middle"],
					["leftBottom", 0, t_height, "left", "Bottom"],
					["rightTop", t_width, 0, "right", "Top"],
					["rightMiddle",t_width, t_height/2,"right","Middle"], 
					["rightBottom", t_width, t_height, "right", "Bottom"], 
					["center", t_width / 2,t_height/2,"center","center"]
				];
				
				var active = this.active;
				var cursor = this.opt.options.alignTo;
				var followCursor = this.opt.options.followCursor;
				var eventPos = this.position["eventPos"];
				var ePos = {
					top:0,
					left:0,
					right:0,
					bottom:0,
					x:0,
					y:0
				};
				var showEventPos = this.showEventPos;
				if (cursor != 'cursor') {
					if (followCursor) {
						if (active) {
							ePos = {
								top:eventPos.top-showEventPos.top,
								left:eventPos.left-showEventPos.left,
								right:eventPos.right-showEventPos.right,
								bottom:eventPos.bottom-showEventPos.bottom,
								x:eventPos.x-showEventPos.x,
								y:eventPos.y-showEventPos.y
							};
						}
					} 
				} else {
					ePos = eventPos;
					// if (followCursor) {
						// ePos = eventPos;
					// } else {
						// if (!active){
							// ePos = eventPos;
						// }
					// }
				}
				
				
				for (var i = 0,len = temp.length; i < len; i++) {
					var name = temp[i][0];
					var l = temp[i][1];
					var t = temp[i][2];
					var prev = temp[i][3];
					var next = temp[i][4];
					for (var m in coordDot) {
						var left = coordDot[m].left + l;
						var top = coordDot[m].top + t;
						
						var width = coordDot[m].width;
						var height = coordDot[m].height;
						var arrow = coordDot[m].arrow;
						var padding = coordDot[m].padding;
						var offsetX = coordDot[m].offsetX;
						var offsetY = coordDot[m].offsetY;
						var p = arrow.split("|")[0];
						if (p == "t" || p == "b" ) {
							if (left + offsetX > ePos.x) {
								left = left - ePos.right;
							} else {
								left = left + ePos.left;
							}
						} else if (p == "l" || p == "r" ) {
							if (top + offsetY > ePos.y) {
								top = top - ePos.bottom;
							} else {
								top = top + ePos.top;
							}
						} else {
							// left = eventPos.x;
							// top = eventPos.y;
						}
						
						var boundary = 
						this._overBoundary(
							left, top,width,height,offsetX,offsetY
						);
						
						var adjustLeft = left;
						var adjustTop = top;
						var adjustBoundary = boundary;
						if (boundary) {
							var o = this._adjustPos(left, top);
							var adjustLeft = o.left;
							var adjustTop = o.top;
							var adjustBoundary = o.boundary;
						}
						if (!allDot[name+"-"+m]){
							allDot[name+"-"+m] = {
								left: left,
								top: top,
								arrow: arrow,
								padding: padding,
								boundary: boundary,
								adjustLeft:adjustLeft,
								adjustTop:adjustTop,
								adjustBoundary:adjustBoundary,
								width:width,
								height:height,
								offsetX:offsetX,
								offsetY:offsetY
							};
							no++;
						}
						
					}
				}
				allDot["length"] = no;
				this.position["allDot"] = allDot;
			},
			/**
			*筛选所需要的位置函数
			* @hide
			*/				
			_getFilterDot:function () {
				if(this.opt.options.version == "simple"){
					var htmlA = [];
					htmlA.push("topLeft-bottomLeft");
					htmlA.push("topRight-bottomRight");
					htmlA.push("bottomLeft-topLeft");
					htmlA.push("bottomRight-topRight");
					htmlA.push("leftTop-rightTop");
					htmlA.push("leftBottom-rightBottom");
					htmlA.push("rightTop-leftTop");
					htmlA.push("rightBottom-leftBottom");
				}else {
					var arr = [
						["top","Left"],
						["top","Middle"],
						["top","Right"],
						["bottom","Left"],
						["bottom","Middle"],
						["bottom","Right"],
						["left","Top"],
						["left","Middle"],
						["left","Bottom"],
						["right","Top"],
						["right","Middle"],
						["right","Bottom"]
					]

					var arr1 = ["Left", "Middle", "Right"]
					var arr2 = ["Top", "Middle", "Bottom"]
					// rightBottom-topLeft
					var htmlA = [];
					for (var i=0; i <arr.length;i++) {
						var prev = arr[i][0]
						var next = arr[i][1]
						if (prev == "top") {
							for (var k = 0; k < arr1.length; k++) {
								htmlA.push("topLeft-bottom" + arr1[k])
								htmlA.push("topMiddle-bottom" + arr1[k])
								htmlA.push("topRight-bottom" + arr1[k])
							}
						} else if (prev == "bottom") {
							for (var k = 0; k < arr1.length; k++) {
								htmlA.push("bottomLeft-top" + arr1[k])
								htmlA.push("bottomMiddle-top" + arr1[k])
								htmlA.push("bottomRight-top" + arr1[k])
							}
						} else if (prev == "left") {
							for (var k = 0; k < arr1.length; k++) {
								htmlA.push("leftTop-right" + arr2[k])
								htmlA.push("leftMiddle-right" + arr2[k])
								htmlA.push("leftBottom-right" + arr2[k])
							}
						} else if (prev == "right") {
							for (var k = 0; k < arr1.length; k++) {
								htmlA.push("rightTop-left" + arr2[k])
								htmlA.push("rightMiddle-left" + arr2[k])
								htmlA.push("rightBottom-left" + arr2[k])
							}
						}
						
						if (next == "Top") {
							for (var k = 0; k < arr2.length; k++) {
								htmlA.push("leftTop-bottom" + arr1[k])
								htmlA.push("rightTop-bottom" + arr1[k])
							}
						} else if (next == "Bottom") {
							for (var k = 0; k < arr2.length; k++) {
								htmlA.push("leftBottom-top" + arr1[k])
								htmlA.push("rightBottom-top" + arr1[k])
								
							}
						} else if (next == "Left") {
							for (var k = 0; k < arr2.length; k++) {
								htmlA.push("topLeft-right" + arr2[k])
								htmlA.push("bottomLeft-right" + arr2[k])
							}
						} else if (next == "Right") {
							for (var k = 0; k < arr2.length; k++) {
								htmlA.push("topRight-left" + arr2[k])
								htmlA.push("bottomRight-left" + arr2[k])
							}
						}		
					}
				}
				
				var dot = {};
				var allDot = this.position["allDot"];
				var no=0;
				for (var i=0;i<htmlA.length;i++) {
					var n = htmlA[i];
					if (allDot[n]) {
						 dot[n]=allDot[n];
						 no++;
					}
				}
				dot["length"] = no;
				this.position["allDot"] = dot;
			},
			/**
			*获取所有可用的位置的坐标
			* @hide
			*/				
			_enableDot:function () { 
				var enableDot = {};
				var allDot = this.position["allDot"]; 
				var i = 0;
				var str = ""
				for (var n in allDot) {	
					if(n=="length") continue;
					
					var o = allDot[n];
					str +=n+"/"+o.left+"/"+o.top+"/"+o.width+"/"+o.height+"/"+o.offsetX+"/"+o.offsetY+"/"+o.boundary+"\n"
					
					if (!o.boundary) {
						enableDot[n] = o;
						i++
					}
				}
				
				enableDot["length"] = i;
				this.position["enableDot"] = enableDot;
			},
			/**
			*判断位置越界的函数
			* @hide
			* @param {num} left  	左坐标
			* @param {num} top  	上坐标
			* @param {num} f_width  浮动层的宽度
			* @param {num} f_height 浮动层的高度
			* @param {num} offsetX  x轴偏移
			* @param {num} offsetY  y轴偏移
			* @return {boolean} ret 是否越界
			*/				
			_overBoundary:function (left,top,f_width,f_height,offsetX,offsetY) {
				var self = this;
				var ret = false;
				var w_width = this.position["win_width"] ;
				var w_height = this.position["win_height"] ;
				var w_scrollTop = this.position["win_scrollTop"];
				var w_scrollLeft = this.position["win_scrollLeft"];
				// 如果隐藏箭头则偏移为0
				if(!self.opt.options.showArrow) {
					offsetX = 0;
					offsetY = 0;
				}
				if (left+offsetX < 0 || top+offsetY < 0) {
					return true
				}
				if ((left+offsetX + f_width > w_width+w_scrollLeft) ||
					(top + f_height+offsetY > w_height+w_scrollTop)) {
						ret = true
				}
				return ret
			},
			/**
			*调整位置 --该功能暂未实现
			* @hide
			* @param {num} left  	左坐标
			* @param {num} top  	上坐标
			* @return {object} ret 调整后的坐标
			*/			
			_adjustPos:function (left,top) {
				var ret = {
					left:left,
					top:top,
					boundary:true
				}
				return ret;
			},
			/**
			*得到当前要显示的位置
			* @hide
			* @param {string} type   判断是否为mousemove事件时的调用
			*/				
			_getShowDot:function (type) {	
				var position = this.opt.options.position;
				var boundaryShow = this.opt.options.boundaryShow;
				var allDot = this.position["allDot"]; 
				var enableDot = this.position["enableDot"]; 
				var showDot = {}
				var i = 0;	
				
				if (type == "mousemove") {
					if (enableDot[this.prevShowArrow]) {
						showDot = enableDot[this.prevShowArrow];
						i++;
					}
					// 处理浮动层已经越界，但是依然要显示的情况
					if(!i){
						if (boundaryShow) {
							if(allDot[this.prevShowArrow]) {
								showDot = allDot[this.prevShowArrow] ;
								i++;
							}
						}
					}
					
				} else {

					if (enableDot[position]) {
						showDot = enableDot[position];
						i++;
					}
					
					if(!i){
						if (boundaryShow) {
							if(allDot[position]) {
								showDot = allDot[position] ;
								i++;
							}
						} else {
							
							for (var n in enableDot) {
								if(n=="length")continue;
								showDot = enableDot[n] ;//也可从allDot中取
								this.prevShowArrow = n;
								i++;
								break;
							}
							if (!i) {
								if(allDot[position]) {
									showDot = allDot[position] ;
									i++;
								}
							}
							
						}
					} else {
						this.prevShowArrow = position;
					}
				}	
				showDot["length"] = i;
				this.position["showDot"] = showDot;
				if (i) {
					this._adjustClass();
					this._calculateArrow();
				}
				
			},
			/**
			*调整浮动层的类
			* @hide
			*/				
			_adjustClass:function () {
				var arrow = this.position["showDot"].arrow;
				var k = arrow.split("|")[0];
				var ret = this.opt.options.position.indexOf("-center");
				
				if (this.opt.options.showArrow && (ret ==-1) ) {
					this.box.className = 
					this.box.className.replace(/[trblc]$/, k);
					this.arrow.style.display ="";
					this.arrow.className = 
					this.arrow.className.replace(/[trblc]$/, k);
					
				} else {
					this.box.className = 
					this.box.className.replace(/[trblc]$/, "c");
					this.arrow.style.display ="none";
					
				}
			},
			/**
			*调整浮动层对应的箭头的类
			* @hide
			*/				
			_calculateArrow:function (showDot) {
				var self = this;
				var arrow = this.position["showDot"].arrow;
				var k = arrow.split("|");

				function getRadiu(opt) {
					return
					
				}
				$(this.arrow).css({
					left: "",
					right: "",
					bottom: "",
					top: "",
					marginTop:""
				});/**/
				var target_width = this.position["target_width"];
				var target_height = this.position["target_height"] ;
				var p = this.position["tipPos"][k[0]];
				var w = p.width;
				var h = p.height;
				if(this.opt.options.version == "simple"){
					 if (k[0] == "t") {
						this.arrow.style["marginTop"] ="-7px";
						if (k[1] == "l") {
							this.arrow.style.left = target_width/2+"px";
							getRadiu({
								leftTop:0
							})
							
						} else if (k[1] == "m") {
							//this.arrow.style.left = (w/2-8)+"px";
							getRadiu();
						} else if (k[1] == "r") {
							this.arrow.style.left = (w-(target_width/2>16?target_width/2:16)-8)+"px";
							getRadiu({
								rightTop:0,
								x:-10
							})
						}
					} else if (k[0] == "r") {
						this.arrow.style.right = "-7px";
						if (k[1] == "t") {
							this.arrow.style["marginTop"] =(target_height/2-8)<0?0:(target_height/2-8)+"px";
							getRadiu({
								rightTop:0,
								x:-10
							})
						} else if (k[1] == "m") {
							//this.arrow.style["marginTop"] =(h/2-8)+"px";
							getRadiu({
								x:-10
							})
							
						} else if (k[1] == "b") {
							this.arrow.style["marginTop"] =(h-(target_height/2>16?target_height/2:16))+"px";
							getRadiu({
								rightBottom:0,
								x:-10,
								y:-10
							})
						}
					} else if (k[0] == "b") {
						if (k[1] == "l") {
							this.arrow.style.right = (w-(target_width/2>16?target_width/2:16)-8)+"px";
							getRadiu({
								leftBottom:0,
								y:-10
							})
							
						} else if (k[1] == "m") {
							//this.arrow.style.right = (w/2-8)+"px";
							getRadiu({
								y:-10
								
							})
							
						} else if (k[1] == "r") {
							this.arrow.style.right = target_width/2-8+"px";
							getRadiu({
								rightBottom:0,
								x:-10,
								y:-10
							})
						}
					} else if (k[0] == "l") {
					   this.arrow.style.left = "2px";
						if (k[1] == "t") {
							this.arrow.style["marginTop"] =target_height/2-8+"px";
							getRadiu({
								leftTop:0
							})
						} else if (k[1] == "m") {
						   // this.arrow.style["marginTop"] =(h/2-8)+"px";
							getRadiu()
						} else if (k[1] == "b") {
							this.arrow.style["marginTop"] =(h-(target_height/2>16?target_height/2:16))+"px";
							getRadiu({
								leftBottom:0,
								y:-10
							})
						}
					}
				}else {
					if (k[0] == "t") {
						this.arrow.style["marginTop"] ="-7px";
						if (k[1] == "l") {
							this.arrow.style.left = "0";
							getRadiu({
								leftTop:0
							})
							
						} else if (k[1] == "m") {
							this.arrow.style.left = (w/2-8)+"px";
							getRadiu();
						} else if (k[1] == "r") {
							this.arrow.style.left = (w-16)+"px";
							getRadiu({
								rightTop:0,
								x:-10
							})
						}
					} else if (k[0] == "r") {
						this.arrow.style.right = "-7px";
						if (k[1] == "t") {
							this.arrow.style["marginTop"] ="0px";
							getRadiu({
								rightTop:0,
								x:-10
							})
						} else if (k[1] == "m") {
							this.arrow.style["marginTop"] =(h/2-8)+"px";
							getRadiu({
								x:-10
							})
							
						} else if (k[1] == "b") {
							this.arrow.style["marginTop"] =(h-16)+"px";
							getRadiu({
								rightBottom:0,
								x:-10,
								y:-10
							})
						}
					} else if (k[0] == "b") {
						if (k[1] == "l") {
							this.arrow.style.right = (w-16)+"px";
							getRadiu({
								leftBottom:0,
								y:-10
							})
							
						} else if (k[1] == "m") {
							this.arrow.style.right = (w/2-8)+"px";
							getRadiu({
								y:-10
								
							})
							
						} else if (k[1] == "r") {
							this.arrow.style.right = "0px";
							getRadiu({
								rightBottom:0,
								x:-10,
								y:-10
							})
						}
					} else if (k[0] == "l") {
					   this.arrow.style.left = "2px";
						if (k[1] == "t") {
							this.arrow.style["marginTop"] ="0px";
							getRadiu({
								leftTop:0
							})
						} else if (k[1] == "m") {
							this.arrow.style["marginTop"] =(h/2-8)+"px";
							getRadiu()
						} else if (k[1] == "b") {
							this.arrow.style["marginTop"] =(h-16)+"px";
							getRadiu({
								leftBottom:0,
								y:-10
							})
						}
					}
				}
			   
			},
			/**
			*浮动层显示前设置坐标的函数
			* @hide
			*/				
			_setPos:function () {
			
				var self = this;
				var showDot = this.position["showDot"]; 
				var width = showDot.width;
				var height = showDot.height;
				if(self.opt.options.showArrow) {
					var top = showDot.top+showDot.offsetY;
					var left = showDot.left+showDot.offsetX;;
				} else {
					var top = showDot.top;
					var left = showDot.left;
				}
				width = Math.floor(width);
				height = Math.floor(height);
				
				top = Math.floor(top);//+this.position["win_scrollTop"]
				left = Math.floor(left);//+this.position["win_scrollLeft"]
				
				
				$(self.tip).css({
					left: left + "px",
					top: top + "px"
				});	
				$(self.iframe).css({
					"width": width + "px",
					"height": height + "px",
					"top": top + "px",
					"left": left + "px"
				})
				
				
			},
			/**
			*刷新浮出层的内容
			* @hide					
			*/
			_updateContent:function () {
				var self = this;
				self.loadFlag={
					template:false,
					content:false,
					error:""
				};
				
				self._setTemplate(loaded);
				self._setContent(loaded);
				
				
				function loaded (name,error) {
					this.loadFlag[name] = true;
					if(error)this.loadFlag["error"] +=error;
					if(this.loadFlag["template"] && this.loadFlag["content"] ){
						onComplete ()
					}
				}
				function onComplete () {
					if(self.loadFlag.error){
						var html = self.loadFlag.error;
					} else {
						var data = {}
						var format = self.opt.options.format
						if(format){
							if($.type(format)=='function'){
								data.txt = format(self.data.txt);
							}else {
								data.txt = jmp.hotelBreakfast(self.data.txt);
							}
						}else { 
							data = self.data;
						}
						var html = $.tmpl.render(self.temp,data);
					}
					$(self.loading).css({display:"none"});
					$(self.content).html(html);
					
					$(self.content).css({
						display: "block",
						// ie6不设置宽度透明度无效
						width: "100%"
					});
					$(self.tip)[0].style.width = $(self.tip)[0].offsetWidth+"px";
					if(self.opt.options.isAnimate) {
						jmp.fade(self.tip,0);
						jmp.animate(self.tip, [
								[0,1, 'opacity', '']
							], 680, function () {}
						);
					}
					self._calcPos();
				}
			},
			/**
			*设置浮出层的模板
			* @hide
			*/			
			_setTemplate:function (callback) {
				var self  = this;
				var template = this.opt.options.template;
				var templateUrl = this.opt.options.templateUrl;
				if (template.charAt(0) === '#') {
					self.temp = $(template).html();
					callback.call(self,"template");
				}else if(template.charAt(0) === '$'){
					self.temp = this.opt.options.templs[this.opt.options.type];
					callback.call(self,"template");
				} else {
					var url = templateUrl +template;
					if (jmp.jmpTemps[url]) {
						self.temp = jmp.jmpTemps[url]
						callback.call(self,"template");
					} else {
						var opts = {
							"url":url,
							"onsuccess":function(xhr, ret) {
								self.temp = ret;
								jmp.jmpTemps[url] = ret;
								callback.call(self,"template");
							},
							"onerror":function (xhr) {
								var ret = "";
								if(xhr.responseXML) ret = xhr.responseXML;
								else ret = xhr.responseText;
								callback.call(self,"content",ret);
							}
						}
						jmp.load(opts)
					}
				}
			},
			/**
			*设置浮出层的内容
			* @hide
			*/				
			_setContent:function (callback) {
				var self = this;
				var options = this.opt.options
				var dataUrl = options.dataUrl;
				var url = options.url;
				var content = options.content;
				if (url) {
					var url = dataUrl + url;
					if (jmp.jmpDatas[url]) {
						self.data = jmp.jmpDatas[url]
						callback.call(self,"content");
					} else {
						var opts = {
							"url":url,
							"onsuccess":function(xhr, ret) {
								var data = {};
								/*
								*处理ajax返回值为字符串的情况
								*/
								try{
									data = eval("("+ret+")");
								}catch(e){
									data = {data:ret}
								}
								self.data = data;
								jmp.jmpDatas[url] = self.data
								callback.call(self,"content");
							},
							"onerror":function (xhr) {
								var ret = "";
								if(xhr.responseXML) ret = xhr.responseXML;
								else ret = xhr.responseText;
								callback.call(self,"content",ret);
							}
						}
						
						jmp.load(opts)
					}
				} else {
					self.data = content || {};
					callback.call(self,"content");
				}
				
			},
			/**
			*内容显示后校正位置
			* @hide
			*/
			_calcPos:function () {
				
				var self = this;
				//this._getEventPos();
				this._getTipPos();
				// this._getSubPos();
				this._getCoordinatesDot();
				this._getAllDot();
				this._getFilterDot();
				this._enableDot();
				this._getShowDot();
				// 记录显示时的鼠标位置
				self.showEventPos = self.position["eventPos"];
				var showDot = self.position["showDot"];
				
				if (!showDot.length) return;
				// 校正位置
				self._setPos();
			},
			/**
			*隐藏浮出层
			* @hide			
			*/				
			_hide:function () {
				if (this.disabled || !this.active) return;
				var self = this;
				var api = self.opt.options.api;
				api.onBeforeHide.call(self);
				if(self.opt.options.isAnimate) {
					jmp.animate(self.tip, [
							[1,0, 'opacity', '']
						], 680, function () {
							onComplete.call(self);
						}
					);
				} else {
					onComplete.call(self);
				}
				
				function onComplete() {
					$(this.tip).css({
						visibility: "hidden",
						left: "-9999px",
						top: "-9999px"//,
						//width:"auto"
					});
					$(this.iframe).css("display","none");
					this.active = !this.active;
					api.onHide.call(this);
				}
				
				
			},
			// 绑定后立即执行显示函数
			execute:function () {
				
				var self = this;
				var showOn = this.shows.join("");
				if (showOn.indexOf('mouseover')>-1) {
					$(this.elem).trigger("mouseover",{arguments:[true]});//mouseover第一次设置arguments

				}
			},
			/**
			*执行该元素绑定的所有显示函数
			*/				
			show:function () {
								
				var self = this;
				this.shows.each(function (_o,i,obj) {
					//避免第一次显示时fixedMouse判断错误，特添加参数
					if(_o.indexOf('mouseover')!=-1){
						$(self.elem).trigger(_o,{arguments:[true]});
					} else {
						$(self.elem).trigger(_o);
					}
					
				});
			},
			/**
			*执行该元素绑定的所有隐藏函数
			*/				
			hide:function () {
				var self = this;
				this.hides.each(function (_o,i,obj) {
					$(self.elem).trigger(_o);
				});
			},
			/**
			*设置控件不可用
			*/	
			disable:function () {
				this.disabled = true;
			},
			/**
			*设置控件绑定
			*/				
			enable:function () {
				this.disabled = false;
			},
			/**
			*修改参数
			* @param {Object} opt 参数对象
			*/			
			refresh:function (opt) {
				
				this._destroy();
				this._setOptions(this.elem, opt);
				this._render();
				this._bindEvent();
				jmp.queue[$(this.elem).uid()] = this;		
			},
			/**
			*销毁对象绑定的控件
			* @hide
			*/			
			_destroy:function () {
				this._clearTimeouts();
				jmp.queue[$(this.elem).uid()] = null;
				var div = this.tip.parentNode;
				div.parentNode.removeChild(div);
			}
			
	});
	// target元素存储参数的属性
	jmp.ATTR_PARAM_NAME = "data-params";
	// 获取可视区域对象
	jmp.client = (function () {
		var doc = document,
		client = doc.compatMode == 'BackCompat' ? doc.body : doc.documentElement;
		return client;
	})();
	// 修正事件对象
	jmp.fixE = function (e) {
		e = window.event || e;
		if (!e.target) {
			e.target = e.srcElement || document;
		}
		if (e.target.nodeType === 3) {
			e.target = e.target.parentNode
		}
		if ( !e.relatedTarget && e.fromElement ) {
			e.relatedTarget = e.fromElement === e.target ? e.toElement : e.fromElement;
		}
		var ___ = document.documentElement;
		if ( e.pageX == null && e.clientX != null ) {
			var body = document.body;
			e.pageX = e.clientX + (___ && ___.scrollLeft || body && body.scrollLeft || 0) -
				(___ && ___.clientLeft || body && body.clientLeft || 0);
			e.pageY = e.clientY + (___ && ___.scrollTop  || body && body.scrollTop  || 0) -
				(___ && ___.clientTop  || body && body.clientTop  || 0);
		}		
		return e
	}	
	//存储不同组的控件实例
	jmp.groupeQueue = {};
	//控件默认的配置
	jmp.defaults = {
		options : {
			version:null,
			/**分组*/
			group:"group",
			/**浮动层初始位置的针对对象*/
			alignTo:"target",//cursor
			/**是否跟随鼠标滚动*/
			followCursor:false,
			/**浮动层是否允许鼠标放上去*/
			allowTipHover:true,
			/**显示时的延时*/
			showTimeout:300,
			/**隐藏时的延时*/
			hideTimeout:100,
			/**在屏幕上可持续的事件，0表示无限期*/
			timeOnScreen:0,
			/**鼠标离开浮动层时是否隐藏浮动层*/
			hideTip:true,
			/**是否显示箭头*/
			showArrow:true,
			/**指定位置越界后是否依旧显示*/
			boundaryShow:false,
			/**位置*/
			position:"bottomLeft-topLeft",
			/**是否强制性修改样式*/
			updateCss:false,
			/**是否执行动画*/
			isAnimate:false,
			/**样式*/
			styles:".tuna_jmpinfo form,h1,h2,h3,h4,ul,ol,li,dl,dd,dt,p,hr,input{margin: 0;padding: 0}.tuna_jmpinfo {margin: 20px;color: #333;font: 12px/2 Arial,Tahoma,simsun;-webkit-text-size-adjust: none;}.tuna_jmpinfo ul,li{list-style: none;}.tuna_jmpinfo a{color: #00c;cursor: pointer;text-decoration: none;}.tuna_jmpinfo a: hover{color: #f00;text-decoration: underline;}.tuna_jmpinfo .font16{font-size: 16px;}.tuna_jmpinfo .jmp_hd{height:30px; padding-left:10px; background:url(http://pic.c-ctrip.com/common/un_base_btn.png) repeat-x 0 -390px; font-size:12px; line-height:30px; color:#333;} .tuna_jmpinfo .jmp_hd h3{font-size: 12px;} .tuna_jmpinfo .jmp_bd{padding: 8px 10px;} .tuna_jmpinfo .jmp_title, .jmp_table{border: 1px solid #67a1e2; background: #fff;} .tuna_jmpinfo .jmp_alert{border: 1px solid #ffb533; background: #fff5d1;} .tuna_jmpinfo .jmp_text{border: 1px solid #67a1e2; background: #e8f4ff;} .tuna_jmpinfo .base_jmp b{position: absolute; width: 16px; height: 16px; background-image: url(http://pic.c-ctrip.com/common/un_jmp_tri.png); background-repeat: no-repeat; overflow: hidden;} .tuna_jmpinfo .base_jmp_t{margin-top: 8px;} .tuna_jmpinfo .base_jmp_r{margin-right: 8px;} .tuna_jmpinfo .base_jmp_b{margin-bottom: 7px;} .tuna_jmpinfo .base_jmp_l{margin-left: 8px;} .tuna_jmpinfo .base_jmp_t b{margin-top: -7px;} .tuna_jmpinfo .base_jmp_r b{margin-top: 10px; right: 0;} .tuna_jmpinfo .base_jmp_b b{bottom: -8px;} .tuna_jmpinfo .base_jmp_l b{margin-top: 10px; left: 9px;}  .tuna_jmpinfo .jmp_title .tri_t, .tuna_jmpinfo .jmp_text .tri_t{background-position: 0 0;} .tuna_jmpinfo .jmp_title .tri_r, .jmp_text .tri_r{background-position: 0 -16px;} .tuna_jmpinfo .jmp_title .tri_b{background-position: -32px -32px;} .tuna_jmpinfo .jmp_title .tri_l, .jmp_text .tri_l{background-position: 0 -48px;} .tuna_jmpinfo .jmp_text .tri_b{background-position: 0 -32px;} .tuna_jmpinfo .jmp_alert .tri_t{background-position: -16px 0;} .tuna_jmpinfo .jmp_alert .tri_r{background-position: -16px -16px;} .tuna_jmpinfo .jmp_alert .tri_b{background-position: -16px -32px;} .tuna_jmpinfo .jmp_alert .tri_l{background-position: -16px -48px;} .tuna_jmpinfo .jmp_table .tri_t{background-position: -32px 0;} .tuna_jmpinfo .jmp_table .tri_r{background-position: -32px -16px;} .tuna_jmpinfo .jmp_table .tri_b{background-position: -32px -32px;} .tuna_jmpinfo .jmp_table .tri_l{background-position: -32px -48px;} .tuna_jmpinfo .jmp_tab_list{position:relative; padding:10px 10px 0; overflow:hidden; z-index:99; zoom:1;} .tuna_jmpinfo .jmp_tab_list li{float:left;} .tuna_jmpinfo .jmp_tab_list li.current{border:1px solid #67A1E2; border-bottom:1px solid #E8F4FF;} .tuna_jmpinfo .jmp_tab_list li a{display:inline-block; padding:4px 10px 3px;} .tuna_jmpinfo .jmp_tab_list li.current a{border-top:1px solid #fff; color:#333; font-weight:bold;} .tuna_jmpinfo .jmp_tab_bd{ margin:-1px 10px 10px; padding-top:10px; border-top:1px solid #67A1E2; background:#E8F4FF;zoom:1;} .data_form{width: 100%; border-collapse: collapse; border: 2px solid #fff; *border-width: 1px; font:normal 12px Verdana, Simsun;} .data_form th{padding: 5px 10px; border: 1px solid #ccc; text-align: left;} .data_form td{padding: 5px 10px; border: 1px solid #ccc;}.tuna_jmpinfo .active{display:block;}.hotel_everyday_list th { background:#F1F1F1; white-space: nowrap; height:25px; text-align:center; font-weight:normal; }.hotel_everyday_list td { width:60px; margin:0; padding:0; text-align:center; vertical-align: top; line-height:20px; background:url(http://pic.c-ctrip.com/mystery_hotels/bg_hotel_breakfast.gif) repeat-x 0 39px; }.hotel_everyday_price { color:#E56700; display:block; }.hotel_everyday_list .hotel_everyday_price em { color:green; font-style:normal; }.hotel_everyday_list span em { color:gray; font-style:normal; }.hotel_everyday_nobreakfast { color:#b4b4b4; }",
			loadingImg:'<img src="images/loading75.gif"/>',
			css:{
				/**最大宽度*/
				maxWidth:"260",
				/**最小宽度*/
				minWidth:"50"
			},
			/**浮动层的类型*/
			type: "jmp_alert",
			/**浮动层的模板*/
			template:"#jmp_alert",
			/**浮动层的模板服务器地址*/
			templateUrl:"template/",
			/**浮动层的数据服务器地址*/
			dataUrl:"data/",
			/**默认的事件类型*/
			eventType:"def",
			// 触发事件类型
			events: {
			  def:"mouseover,mouseout",    
			  // default show/hide events for an element
			  input:   "focus,blur",
			  // for all input elements
			  widget:  "focus|mouseover,blur|mouseout"
			  // select, checkbox, radio, button
			},
			/**默认的内容*/
			content: {
				"txt":"今天是2010年上半年最后一个交易日，沪深股市在昨日暴跌阴影下继续下探，最终跌破2400点整数关口。统计数据显示，上证综指与深证成指今年来分别下跌26.82%和31.48%。"
			},
			//浮动层显示前后和隐藏前后的函数
			api: {
				/**显示前的函数，参数为当前浮动层元素*/
				onBeforeShow: function(obj){},
				/**显示后的函数，参数为当前浮动层元素*/
				onBeforeHide: function(obj){},
				/**隐藏前的函数，参数为当前浮动层元素*/
				onShow: function(obj){},
				/**隐藏后的函数，参数为当前浮动层元素*/
				onHide: function(obj){}
			},
			
			adjust: {
				/**判断是否支持屏幕滚动*/
				scroll: false,
				/**判断是否支持屏幕缩放*/
				resize: false
			},
			classNames:{
				/**浮动层最外层的类*/
				tip:'tuna_jmpinfo',
				/**浮动层的类*/
				box:'base_jmp',
				/**浮动层类型的类*/
				boxType:'jmp_alert',
				boxArrow:'base_jmp_t',
				/**浮动层箭头的类*/
				arrow:'tri_t',
				/**浮动层加载时的类*/
				loading:'jmp_loading',
				/**浮动层内容的类*/
				tipContent:'jmp_content'
			},
			templs:{
				/**浮动层的模板*///overflow:hidden;
				"tipTempl":'<div id=${id} class=${tip}  group=${group} style="visibility:hidden;display:block;z-index:99;margin:0;left:-9999px;top:-9999px;position:absolute;max-width:${maxWidth}px;min-width:${minWidth}px;_width:expression((this.offsetWidth>${maxWidth})?\'${maxWidth}px\':true);"><div class="${box} ${boxType} ${boxArrow}"><b class="${arrow}"></b><div class="${loading}">${loadingImg}</div><div class=${content}></div></div></div>',
				"jmp_table":'${txt}',
				"jmp_title":'<div class="jmp_hd"> <h3>${title}</h3> </div><div class="jmp_bd">${txt}</div>',
				"jmp_alert":'<div class="jmp_bd">${txt}</div>',
				"jmp_text":'<div class="jmp_bd">${txt}</div>',
				"jmp_tab_list":'${txt}'
			}
		}, 
		'methods' : {
		},
		'listeners': {
		}                
	};
	//存储所有的控件实例
	jmp.queue = {};
	//存储请求过的模板地址
	jmp.jmpTemps = [];
	//存储请求过的数据地址		
	jmp.jmpDatas = [];
	//判断是否为控件对象
	jmp.isJmp =function (el) {
		function isMod(elem, key) {
			var attr = elem.getAttribute("data-role") || null;
			if (!attr) return false;
			if (!key) return false;
			if (attr !== key) {
				return false
			} else {
				return true
			}
		}
		while (!isMod(el, "jmp") && document.documentElement != el) {
			el = el.parentNode
		}
		return el == document.documentElement? null: el;
	}
	//给控件添加样式
	jmp.creatStyle = function (opt) {
		var updateCss = opt.updateCss;
		var styles = opt.styles;
		if(updateCss || !jmp.isFirstRegister){
			if (!jmp.isFirstRegister)jmp.isFirstRegister = true;
			if ($.browser.isIE) {
				sty = document.createStyleSheet();
				sty.cssText = styles
			} else {
				sty = document.createElement('style');
				sty.type = "text/css";
				sty.textContent = styles;
				document.getElementsByTagName('head')[0].appendChild(sty)
			}
		}
		
		
	}
	//创建iframe,同一组只创建一次
	jmp.iframe = function (type) {
		var iframe = $('#jmp-iframe-type-'+type)[0];
		if (!iframe) {
			iframe = document.createElement('iframe');
			iframe.setAttribute('frameborder', '0', 0);
			iframe.setAttribute('id','jmp-iframe-type-'+type);
			iframe.style.cssText = "position:absolute;filter:alpha(opacity=0);display:none;";
			document.body.insertBefore(iframe, document.body.childNodes[0]);
		}
		return iframe;		
	};
	//ajax加载数据
	jmp.load = function(opts) {
		var defaults = {
			url:"",
			"onsuccess":function () {},
			"onerror":function () {}
		}
		var opts = $.extend(defaults,opts);
		$.ajax(opts.url, {
			"onsuccess": function(xhr, ret) {
				opts.onsuccess(xhr, ret)
			},
			"onerror":function (xhr) {
				opts.onerror(xhr)
			}
		})
	}
	/**
	*添加动画
	* @param {HtmlElement} elem 要执行动画的元素
	* @param {Object} css css参数
	* @param {Number} duration 动画持续时间
	* @param {Function} callback 执行完的回调函数
	* @hide
	*/
	jmp.animate = function (elem, css, duration, callback) {
		clearInterval(elem._timer)
		
		var tween = function(x) {
			return (x /= 0.5) < 1 ? (0.5 * Math.pow(x, 2)) : (-0.5 * ((x -= 2) * x - 2))
		};
		function ontween (pos) {
			var obj, val, form, to, name, unit,
				i = 0, len = css.length;

			for (; i < len; i++) {
				obj = css[i];
				from = obj[0];
				to = obj[1];
				name = obj[2];
				unit = obj[3];
				val = from + (to - from) * tween(pos);
				
				if(name == "opacity") {
					elem.style[name] = val;
					elem.style.filter='alpha(opacity='+(val*100)+')';
				} else {
					elem.style[name] = val + unit;
				}
			};
		};

		function onend (pos) {
			ontween(pos);
			callback.call(elem);
		};
		var fx = function (ontween, onend, duration) {
			var pos, runTime, startTime = + new Date;
			elem._timer = setInterval(function () {
					runTime = + new Date - startTime;
					pos = runTime / duration;
					if (pos >= 1) {
							clearInterval(elem._timer);
							onend(pos);
					} else {
							ontween(pos);
					};
			}, 13);
		};
		fx(ontween, onend, duration);        
	};
	//设置透明度
	jmp.fade = function (el, i){
		el.style.opacity = i;
		el.style.filter='alpha(opacity='+(i*100)+')';
	},
	// 设置iframe和div的zIndex	
	jmp.zIndex = 999;
	jmp.setIndex = function (obj) {
		$(obj).css({"zIndex":jmp.zIndex+1});
		jmp.zIndex++;
	}
	// 判断控件是否已经注册过
	jmp.isFirstRegister = false;
	// 获取可视区域的高度
	jmp.getViewHeight  = function (){
		var ret = 0;
		if (self.innerHeight) { // all except Explorer
			ret = self.innerHeight;
		} else {
			ret = jmp.client.clientHeight;
		}
		return ret;
	}
	// 获取可视区域的宽度
	jmp.getViewWidth = function (){
		var ret = 0;
		if (self.innerHeight) { 
			ret = self.innerWidth;
		} else {
			ret = jmp.client.clientWidth;
		}
		return ret;
	} 
	// 获取可视区域的滚动条的top
	jmp.getViewScrollTop = function () {
		var t = document.body.scrollTop||document.documentElement.scrollTop;
		return t;
	}
	// /获取可视区域的滚动条的left
	jmp.getViewScrollLeft = function () {
		var l = document.body.scrollLeft||document.documentElement.scrollLeft;
		return l;
	}
	//mouseover和mouseout只执行一次
	jmp.fixedMouse = function (e,target){  
		function contains(p,c){  
			return p.contains ? p != c && p.contains(c) : !!(p.compareDocumentPosition(c) & 16);  
		}
		var related,
			type=e.type.toLowerCase();//这里获取事件名字
			
			
		if(type=='mouseover'){
			related=e.relatedTarget||e.fromElement
			
		}else if(type=='mouseout'){
			related=e.relatedTarget||e.toElement
			
		}else {
			 return true;
		}
		
		return related && related.prefix!='xul' && !contains(target,related) && related!==target;
	}
	jmp.hotelBreakfast = function(str){
		var srr = str.split('|'),
			t_s = '<table cellspacing="0" cellpadding="0" style="margin:6px;" class="hotel_everyday_list">\
		<colgroup>\
			<col width="45" span="7" />\
		</colgroup>\
		<tbody>\
		<tr>\
			<th> </th>\
			<th>'+srr[0]+'</th>\
			<th>'+srr[1]+'</th>\
			<th>'+srr[2]+'</th>\
			<th>'+srr[3]+'</th>\
			<th>'+srr[4]+'</th>\
			<th>'+srr[5]+'</th>\
			<th>'+srr[6]+'</th>';
		var l = srr.length,
			lstr = '';
		var o = 0;
		for(var i = 7;i < l; i++){
			if((i-7)%15 == 0){
				lstr += '</tr><tr><td>'+srr[i]+'</td>';
				o++;
			}else{
				i++;
				lstr+='<td><span class="hotel_everyday_price">'+srr[i-1]+'</span> <span>'+srr[i]+'</span></td>';
			}
		}
		
		var q = (o*15 - (l-7))/2;
		
		for(var x = 0;x < q;x++){
			lstr+='<td><span class="hotel_everyday_price"></span><span></span></td>';
		}
		
		var t_d = '</tr></tbody></table>';
		
		return t_s + lstr + t_d;
	};
	function jmp(obj, opt) {
		this.init(obj, opt)
	}
	$.extend(jmp.prototype, {
		/**
		 *构造函数
		 * @hide
		 * @constructor
		 * @param {HTMLElement} 	obj  		作用的HTML元素
		 * @param {Object} 			opts  		配置项
		 * @returns {Object}   					类实例
		*/
		init: function(obj, opt) {
			//处理document注册
			if (obj == document) {
				$(obj).bind("mouseover",function (e) {
					var cursor = jmp.fixE(e).target;
					var o = jmp.isJmp(cursor);
					if (o) {
						jmp["float"](o,opt)
						//处理显示方式为mouseover方式的元素
						.execute();
					}
				});
			}
			//处理单个元素注册
			else {
					 jmp["float"](obj, opt);
			}
		},
		/**
		*获取页面元素对应的控件实例
		* @param {Object} obj cQuery对象
		* @return {Object|null}  oJmp cQuery对象对应的jmp控件的实例
		*/		
		getTip : function (obj) {
			var oJmp = jmp.queue[$(obj).uid()] || null;
			return oJmp;	
		}
	});
	$.mod.reg(cls)
})(cQuery);