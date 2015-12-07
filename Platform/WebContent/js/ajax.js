/**
 * 基于Jquery的AJAX实现
 * 实现了JAVA中的Map,Map中Entry和List 
 * 目前Entry中的值只支持为String类型
 * 封装了Ajax,对Ajax的超时错误进行了处理
 * @author KEJUN
 * @version 1.00
 * @date 2008/11/13
 */

var Class = {
  create: function() {
    function klass() {
      this.initialize.apply(this, arguments);
    }
    return klass;
  }
};

/**
* 全局变量
*/
var DEFAULT_ATTRIBUTE_NAME = "id";
var DEFAULT_ATTRIBUTE_VALUE = "value";

var DEFAULT_CLASS_ENTRY = "entry";
var DEFAULT_CLASS_MAP = "map";
var DEFAULT_CLASS_LIST = "list";
var DEFAULT_VALUE = "value";

/**
* Prototype 类定义
*/
var EntryClass = Class.create();
var MapClass = Class.create();
var ListClass = Class.create();

/**
* Field 类实现
*/
EntryClass.prototype = {

	/**
	* Field对应的XML DOM对象
	*
	* @type object
	*/
	xmlDOM: null,

	/**
	* Field的ID
	*
	* @type string
	*/
	entryName: null,
    
  	/**
	* Field的value
	*
	* @type string
	*/
	entryValue: null,  
	
  
	/**
	* 构造函数
	*
	* @param xmlNode {object} 一个XML DOM对象
	*/  
	initialize: function(xmlNode) {
		this.xmlDOM = xmlNode;
		this.entryName = xmlNode.getAttribute(DEFAULT_ATTRIBUTE_NAME);
		
		var allNodes = this.xmlDOM.childNodes;
		var nodesLength = allNodes.length;
		for ( var i=0; i < nodesLength ; i++ ){
			var node = allNodes[i];
			if ( node.nodeName == DEFAULT_CLASS_MAP ){
				var map = new MapClass(node);
				this.entryValue = map; 
				return;
			}else if ( node.nodeName == DEFAULT_CLASS_LIST ){
				var list = new ListClass(node);
				this.entryValue = list; 
				return;
			}else{
				if(navigator.appName.indexOf("Explorer") > -1){
					this.entryValue = node.text;
				} else{ 
					this.entryValue = node.textContent;
				} 
			}
		}
	},
	
	/**
	* 取得Entry的ID
	*
	* @return {string} 
	*/ 
	getName: function() {
		return this.entryName;
	},

	/**
	* 取得Entry的value
	*
	* @return {string} 
	*/
	getValue: function() {
		return this.entryValue;
	}
};

/**
* Map 类实现
*/
MapClass.prototype = {

	/**
	* Map对应的XML DOM对象
	*
	* @type object
	*/
	xmlDOM: null,
	
  	/**
	* Map中存放数据的HashTable
	*
	* @type object
	*/
	hashTable: null,  
	
	/**
	* 构造函数
	*
	* @param xmlNode {object} 一个XML DOM对象
	*/  
	initialize: function(xmlNode) {
		this.hashTable = new Object();
		if(xmlNode==null){
			this.xmlDOM='';
			return;
		}
		this.xmlDOM = xmlNode;
		var allNodes = xmlNode.childNodes;
		var nodesLength = allNodes.length;
		for ( var i=0; i < nodesLength ; i++ )
		{
			var node = allNodes[i];
			if ( node.nodeName == DEFAULT_CLASS_ENTRY )
			{
				// EntryClass
				var entry = new EntryClass(node);
				this.addEntry(entry.getName(),entry);
//				this.addEntry(node.getAttribute(DEFAULT_ATTRIBUTE_NAME),node.getAttribute(DEFAULT_ATTRIBUTE_VALUE));
			}
		}
	},

	
	/**
	* 向Map中添加一个Entry
	* @param {string} key
	* @param {string} value(目前支持String)
	*
	* @return {boolean} true | false
	*/
	addEntry: function(key,value){
		if( typeof(key)!="undefined" )
		{
			if( this.containsKey(key)==false ){
				this.hashTable[key]=typeof(value)=="undefined"?null:value;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},

	
	/**
	* 从Map中删除指定key对应的Value
	* @param {string} key
	*/
	remove: function(key){
		delete this.hashTable[key];
	},

	/**
	* 检查Map中是否含有指定key对应的Value
	* @param {string} key
	*
	* @return {boolean} true | false
	*/	
	containsKey: function(key){
		return typeof(this.hashTable[key])!="undefined";
	},

	/**
	* 取得Map中指定key对应的值
	* @param {string} key
	*
	* @return {string} 
	*/
	getValue: function(key) {
		if ( this.containsKey(key)==true )
		{
			// EntryClass
			return this.hashTable[key].getValue();
//			return this.hashTable[key];
		}else{
			return null;
		}
	},
	
	/**
	* 设置Map中指定key对应的值
	* @param {string} key
	*
	* @return {string} 
	*/
	setValue: function(key,value) {
		if ( this.containsKey(key)==true )
		{
			return this.hashTable[key]=value;
		}else{
			return this.addEntry(key,value);
		}
	},
	
	
	/**
	* 取得List的长度
	*
	* @return {int} 
	*/
	size: function() {
		return this.hashTable.length;
	},
	
	
	/**
	* toString
	*
	* @return {string} 
	*/
	toString: function() {
		
		for(var i=0; i<this.hashTable.length;i++){
			//alert(hashTable[i]);
		}
		
	}
	
	
	
};

/**
* List 类实现
*/
ListClass.prototype = {

	/**
	* List对应的XML DOM对象
	*
	* @type object
	*/
	xmlDOM: null,
	
  	/**
	* List中存放数据的Array
	*
	* @type Array
	*/
	listArray: null,  
		
	/**
	* 构造函数
	*
	* @param xmlNode {object} 一个XML DOM对象
	*/  
	initialize: function(xmlNode) {
		
		this.listArray = new Array();
		this.xmlDOM = xmlNode;
		var allNodes = xmlNode.childNodes;
		var nodesLength = allNodes.length;
		for ( var i=0; i < nodesLength ; i++ )
		{
			var node = allNodes[i];
			if ( node.nodeName == DEFAULT_CLASS_MAP )
			{
				this.addMap(node);
			}else if( node.nodeName == DEFAULT_VALUE ){
				if(navigator.appName.indexOf("Explorer") > -1){
					this.addValue(node.text);
				} else{ 
					this.addValue(node.textContent);
				} 
			}
		}
	},

	/**
	* 向List中添加一个Map
	* @param {object} xmlNode
	*/
	addMap: function(xmlNode){
		var map = new MapClass(xmlNode);
		this.listArray[this.listArray.length] = map;
	},
	
	/**
	* 向List中添加一个value
	* @param {object} xmlNode
	*/
	addValue: function(value){
		this.listArray[this.listArray.length] = value;
	},

	/**
	* 取得List的长度
	*
	* @return {int} 
	*/
	size: function() {
		return this.listArray.length;
	},

	/**
	* 取得list中指定位置的值
	* @param {int} pos
	*
	* @return {map} 
	*/
	get: function(pos) {
		return this.listArray[pos];
	}
};

/**
* 发起Ajax请求
* @param {string} 请求地址
* @param {string} 请求参数，例：'name=11&text=22'
* @param {string} 填入数据的回调函数。回调函数有唯一的输入参数contextData，为处理后的List类型
* @param {string} 是否从浏览器中请求缓存数据
*/
function ajax(url, params, callbackFunction,isCache) {
	if(isCache == null){
		isCache = true;
	}
	$.ajax({
			type:"post",
			url:url,
			data:params,
			complete:processResponse,
			error:showError,
			cache:isCache
	});
	function processResponse(response)
	{
		if ( response.responseText.indexOf('<?xml') < 0 )
		{
			callbackFunction(response.responseText);
			return;
		}
		var contextDataPos = response.responseXML.childNodes.length-1;
		var name = response.responseXML.childNodes[contextDataPos].nodeName;
		var contextData;
		if(name == DEFAULT_CLASS_MAP ){
			contextData = new MapClass(response.responseXML.childNodes[contextDataPos]);
		}else if(name == DEFAULT_CLASS_LIST ){
			contextData = new ListClass(response.responseXML.childNodes[contextDataPos]);
		}else{
			contextData = new EntryClass(response.responseXML.childNodes[contextDataPos]);
		}
		callbackFunction(contextData);
	}
}

/**
* 通讯失败处理
*/
function showError()
{
	alert('通讯失败，请重试');
	return false;
}