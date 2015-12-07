function Suggest(div, service, hint, defaultObj){
	this.div = div;
	this.service = service;
	this.hint = hint;
	this.defaultObj = defaultObj;
	
	this.input = null;
	this.currRow = null;
	this.init();
}
Suggest.prototype.addInput = function(input){
	var suggest = this;
	input.data('old', input.val());
	// 初始时，显示灰色提示
	if($.trim(input.val()) == ''){
		input.addClass('gray');
		input.val(this.hint);
	}
	// 失去焦点时：去除当前input，如果未输入内容，仍然显示提示
	input.blur(function(){
		suggest.onBlur();
	});
	// 获得焦点时，向服务器请求内容
	input.focus(function(evt){
		// 设置当前input
		suggest.input = $(this);
		suggest.onFocus();
	});
	// 点击input时，防止事件冒泡
	input.click(function(evt){
		evt.stopPropagation();
	});
	// 键盘处理
	input.keypress(function(evt){
		if(evt.keyCode == 13){
			suggest.pressEnter();
			evt.stopPropagation();
		}
	});
	input.keyup(function(evt){
		if(evt.keyCode == 40){
			suggest.pressDown();
		}
		else if(evt.keyCode == 38){
			suggest.pressUp();
		}
		else if(evt.keyCode == 27){
			suggest.pressEsc();
		}
	});
}
Suggest.prototype.onBlur = function(){
	if($.trim(this.input.val()) == ''){
		this.input.addClass('gray');
		this.input.val(this.hint);
	}
}
Suggest.prototype.onFocus = function(){
	this.input.select();
	if($.trim(this.input.val()) == this.hint){
		this.input.removeClass('gray');
		this.input.val('');
	}
	this.doRequest(this.input.val());
}
Suggest.prototype.init = function(){
	var suggest = this;
	$(document).click(function(){
		suggest.hide();
	});
	setInterval(funcProxy(function(){
		if(this.input == null) return;
		var newValue = this.input.val();
		if(newValue == this.hint){
			newValue = '';
		}
		if(this.input.data('old') != newValue){
			this.onDataChange(newValue);
		}
		this.input.data('old', newValue);
	}, this), 300);
}
Suggest.prototype.onDataChange = function(newValue){
	if(!this.input.selected){
		this.doRequest(newValue);
	}
	this.input.selected = false;
}
Suggest.prototype.show = function(){
	if(this.input == null) return;
	var offset = this.input.offset();
	var x = offset.left + 'px';
	var y = offset.top + this.input.outerHeight() + 'px';
	this.div.width(210);
	showWithMask(this.div, x, y);
}
Suggest.prototype.showDefault = function(input){
	if(typeof input != 'undefined'){
		this.input = input;
	}
	this.setContent(this.defaultObj);
	this.show();
}
Suggest.prototype.toggleDefault = function(input){
	if(this.div.css('display') == 'none'){
		this.showDefault(input);
	}
	else{
		this.hide();
	}
}
Suggest.prototype.hide = function(){
	hideWithMask(this.div);
}
Suggest.prototype.doRequest = function(s){
	var suggest = this;
	if($.trim(s) == ''){
		suggest.showDefault();
	}
	else{
		$.getJSON(this.service, {w: s}, function(obj){
			suggest.setContent(obj);
			suggest.show();
		});
	}
}
Suggest.prototype.setCurrRow = function(row){
	if(this.currRow != null){
		this.currRow.removeClass('selected');
	}
	this.currRow = row;
	this.currRow.addClass('selected');
}
Suggest.prototype.pressEnter = function(){
	if(this.currRow == null) return;
	this.selectRow(this.currRow);
}
Suggest.prototype.pressDown = function(){
	var next = this.currRow == null ? null : this.currRow.next();
	if(next.is('tr')){
		this.setCurrRow(next);
	}
	else{
		var items = this.div.find('table').find('tr');
		if(items.length > 0){
			this.setCurrRow($(items[0]));
		}
	}
}
Suggest.prototype.pressUp = function(){
	var prev = this.currRow == null ? null : this.currRow.prev();
	if(prev.is('tr')){
		this.setCurrRow(prev);
	}
	else{
		var items = this.div.find('table').find('tr');
		if(items.length > 0){
			this.setCurrRow($(items[items.length-1]));
		}
	}
}
Suggest.prototype.pressEsc = function(){
	this.hide();
}
Suggest.prototype.setContent = function(obj){
	if(this.input == null) return;
	if(typeof obj == 'undefined') return;
	if(obj != this.defaultObj){
		if(obj.w != this.input.val()) return;
		if(obj.items.length == 0) return;
	}
	var title = $('<div class="suggestTitle">请输入中文或拼音或英文<a class="close_icon"></a></div>');
	var tbl = $('<table cellpadding="0" cellspacing="0" style="width:100%;"></table>');
	var suggest = this;
	$.each(obj.items, function(inx, item){
		var row = $('<tr><td>' + item.name + ' ('+ item.code +')</td><td align="right">' + item.pinyin + '</td></tr>');
		row.data('o', item);
		row.click(function(evt){
			suggest.selectRow($(this));
		});
		row.mouseover(function(){
			suggest.setCurrRow($(this));
		});
		if(inx == 0){
			suggest.setCurrRow(row);
		}
		tbl.append(row);
	});
	this.div.empty();
	this.div.append(title);
	this.div.append(tbl);
}
Suggest.prototype.selectRow = function(row){
	if(this.input == null) return;
	this.input.selected = true;
	this.input.removeClass('gray');
	var o = row.data('o');
	this.input.val(o.name + '(' + o.code + ')');
	this.hide();
}