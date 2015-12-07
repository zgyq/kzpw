	(function($) {
		$.suggest = function(input, options) {
	
			var $input = $(input).attr("autocomplete", "off");
			var $results;

			var timeout = false;		// hold timeout ID for suggestion results to appear	
			var prevLength = 0;			// last recorded length of $input.val()
			var cache = [];				// cache MRU list
			var cacheSize = 0;			// size of cache in chars (bytes?)
			
			if($.trim($input.val())=='' || $.trim($input.val())=='中文/拼音') $input.val('中文/拼音').css('color','#aaa');
			if( ! options.attachObject )
				options.attachObject = $(document.createElement("ul")).appendTo('body');

			$results = $(options.attachObject);
			$results.addClass(options.resultsClass);
			
			resetPosition();
			$(window)
				.load(resetPosition)		// just in case user is changing size of page while loading
				.resize(resetPosition);

			$input.blur(function(e) {
			   setTimeout(function() { $results.hide() }, 200);

			});
			
			
			$input.focus(function(){
			    
				if($.trim($(this).val())=='中文/拼音'){
					$(this).val('').css('color','#000');
				}
				if($.trim($(this).val())==''){
					displayItems('');//显示热门城市列表
				}
			});
			$input.click(function(){
				var q=$.trim($(this).val());
				displayItems(q);
				$(this).select();
			});
						
			// help IE users if possible
			try {
				$results.bgiframe();
			} catch(e) { }

			$input.keyup(processKey);//
			
			function resetPosition() {
				// requires jquery.dimension plugin
				var offset = $input.offset();
				$results.css({
					top: (offset.top + input.offsetHeight) + 'px',
					left: offset.left + 'px'
				});
			}
			
			
			function processKey(e) {
				// handling up/down/escape requires results to be visible
				// handling enter/tab requires that AND a result to be selected
				if ((/27$|38$|40$/.test(e.keyCode) && $results.is(':visible')) ||
					(/^13$|^9$/.test(e.keyCode) && getCurrentResult())) {
		            if (e.preventDefault)
		                e.preventDefault();
					if (e.stopPropagation)
		                e.stopPropagation();

	                e.cancelBubble = true;
	                e.returnValue = false;
					switch(e.keyCode) {
	
						case 38: // up
							prevResult();
							break;
				
						case 40: // down
							nextResult();
							break;
						case 13: // return
							selectCurrentResult();
							break;
							
						case 27: //	escape
							$results.hide();
							break;
	
					}
				} else if ($input.val().length != prevLength) {

					if (timeout) 
						clearTimeout(timeout);
					timeout = setTimeout(suggest, options.delay);
					prevLength = $input.val().length;
					
				}			
			}
			
			function suggest() {
				var q = $.trim($input.val());
				displayItems(q);
			}	
			
			function displayItems(items) {
				var html = '';
				if (items=='') {//热门城市遍历
					//html='<div class="gray ac_result_tip">请输入中文/拼音或者↑↓选择</div><ul>'+html+'</ul>';
					html='<div id="city"><div class="city-top" ><font class="fff">热门城市（可输入城市或城市拼音）</font></div>';
				    html+='<div class="city-box"> <ul id="mt5" class="mt5">';
				    html+='<li class="f city-navon"><a href="#">热门</a></li>';
				    html+='<li class="f city-nav"><a href="#">A-F</a></li>';
				    html+='<li class="f city-nav"><a href="#">G-J</a></li>';
				    html+='<li class="f city-nav"><a href="#">K-N</a></li>';
				    html+='<li class="f city-nav"><a href="#">P-W</a></li>';
				    html+='<li class="f city-nav"><a href="#">X-Z</a></li>';
				    html+='<li class="f city-nav-right"><a href="javascript:void(0);">&nbsp;</a></li>';
				    html+='<div class="c"></div></ul><div class="mt5 c" >';
				    html+='<ul class="ulcommoncity">';
				    for(h in options.hot_list){
					//html+='<li rel="'+options.hot_list[h][0]+'"><a href="#'+h+'"><span>'+options.hot_list[h][2]+'</span>'+options.hot_list[h][1]+'</a></li>';
				    html+='<li class="f cityon" rel="'+options.hot_list[h][0]+'"><a href="#'+h+'">'+options.hot_list[h][1]+'</a></li>';
				    }
				    html+='<li class="c nohave">&nbsp;</li>';
				    html+='</ul>';
				    html+='</div>';
				    html+='</div>';
				    html+='</div>';
				    
				}
				else {
					/*if (!items)
					return;
					if (!items.length) {
						$results.hide();
						return;
					}*/
					for (var i = 0; i < options.source.length; i++) {//国内城市匹配
						var reg = new RegExp('^' + items + '.*$', 'im');
						if (reg.test(options.source[i][0]) || reg.test(options.source[i][1]) || reg.test(options.source[i][2]) || reg.test(options.source[i][3])) {
							html += '<li rel="' + options.source[i][0] + '"><a href="#' + i + '"><span>' + options.source[i][2] + '</span>' + options.source[i][1] + '</a></li>';
						}
					}
					if (html == '') {
						suggest_tip = '<div class="gray ac_result_tip">对不起，找不到：' + items + '</div>';
					}
					else {
						suggest_tip = '<div class="gray ac_result_tip">' + items + '，按拼音排序</div>';
					}
					html = suggest_tip + '<ul class="ulcommoncity">' + html + '</ul>';
				}
				$results.html(html).show();
				$results.children('ul').children('li:first-child').addClass(options.selectClass);
				$results.children('ul')
					.children('li')
					.mouseover(function() {
						$results.children('ul').children('li').removeClass(options.selectClass);
						$results.children('ul').children('li').removeClass("selected");
						$(this).addClass(options.selectClass);
						$(this).addClass("selected");
					})
					.click(function(e) {
						e.preventDefault(); 
						e.stopPropagation();
						selectCurrentResult();
					});
				//热门城市选中
				$results.find('.ulcommoncity').children('li')
				.click(function() {
				        $results.children('ul').children('li').removeClass("selected");
						$(this).addClass("selected");
					})
				.click(function(e) {
						e.preventDefault(); 
						e.stopPropagation();
						selectCurrentResult();
				});
				//热门城市TAB选中
				$results.find('.mt5').children('li')
				.mouseover(function() {
				    
				        $results.children('ul').children('li').removeClass("clicked");
						$(this).addClass("clicked");
						
					})
				.mouseover(function(e) {
				
						
						selectCurrentTabResult();
						$input.focus();
						displayItems('');
				});
				
			}
			/***热门城市选中 陈星*****************************************/
			//取得选中的a标签
			function getCurrentTabResult() {
				if (!$results.is(':visible'))
					return false;	
			    //热门城市选中
			    var $currenttabResult=$results.find('.mt5').children('li.clicked');
				if (!$currenttabResult.length)
					$currenttabResult = false;
				return $currenttabResult;
			}
			function selectCurrentTabResult() {
				$currenttabResult = getCurrentTabResult();
				if ($currenttabResult) {
					//显示热门城市
					$results.show();
					//alert($currenttabResult.children('a').html());
					
				}
			}
			/***热门城市选中 陈星*****************************************/
			
						
			function getCurrentResult() {
				if (!$results.is(':visible'))
					return false;	
			    //热门城市选中
			    var $currentResult=$results.find('.ulcommoncity').children('li.selected');
				//var $currentResult = $results.children('ul').children('li.' + options.selectClass);
				if (!$currentResult.length)
					$currentResult = false;
				return $currentResult;
			}
			
			function selectCurrentResult() {
				$currentResult = getCurrentResult();
				if ($currentResult) {
					$input.val($currentResult.children('a').html().replace(/<span>.+?<\/span>/i,''));
					$results.hide();
					if( $(options.dataContainer) ) {
					    
						$(options.dataContainer).val($currentResult.attr('rel'));
					}
					if (options.onSelect) {
						options.onSelect.apply($input[0]);
					}
				}
			}
			
			function nextResult() {
			
				$currentResult = getCurrentResult();
			
				if ($currentResult)
					$currentResult
						.removeClass(options.selectClass)
						.next()
							.addClass(options.selectClass);
				else
					$results.children('ul').children('li:first-child').addClass(options.selectClass);
			
			}
			
			function prevResult() {
			
				$currentResult = getCurrentResult();
			
				if ($currentResult)
					$currentResult
						.removeClass(options.selectClass)
						.prev()
							.addClass(options.selectClass);
				else
					$results.children('ul').children('li:last-child').addClass(options.selectClass);
			
			}
	
		}
		
		$.fn.suggest = function(source, options) {
		
			if (!source)
				return;
		
			options = options || {};
			options.source = source;
			options.hot_list=options.hot_list || [];
			options.delay = options.delay || 0;
			options.resultsClass = options.resultsClass || 'ac_results';
			options.selectClass = options.selectClass || 'ac_over';
			options.matchClass = options.matchClass || 'ac_match';
			options.minchars = options.minchars || 1;
			options.delimiter = options.delimiter || '\n';
			options.onSelect = options.onSelect || false;
			options.dataDelimiter = options.dataDelimiter || '\t';
			options.dataContainer = options.dataContainer || '#SuggestResult';
			options.attachObject = options.attachObject || null;
	
			this.each(function() {
				new $.suggest(this, options);
			});
	
			return this;
			
		};
		
	})(jQuery);