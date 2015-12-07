<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
.wenzi
{
	font-size:12px;
	color:#F00;
	margin-bottom:15px;
	margin-top:15px;
}
.tablez
{
	border:1px #0356a6;
	font-size:12px;
	width:100%;
	background-color:#0356a6;
	margin-top:5px;
}

.tablez td{
	background-color: #ffffff;
	padding: 3px;
	line-height: 20px;
}

.tr_bg{
	
	background-repeat: repeat-x;
}
.TabbedPanels {
	overflow: hidden;
	margin: 0px;
	padding: 0px;
	clear: none;
	width: 100%;
	 /* IE Hack to force proper layout when preceded by a paragraph. (hasLayout Bug)*/
}


.TabbedPanelsTabGroup {
	margin-top:5px;
	margin-left:0px;
	
	padding:0px;
	
	
}


.TabbedPanelsTab {
	
	
	float:left;
	width:60px;
	height:25px;
	font-size:12px;
	list-style-type:none;
	line-height:25px;
	text-align:center;
	cursor: pointer;
	border:0px;
	margin-right:5px;
	margin-bottom:5px;
	
}


.TabbedPanelsTabHover {
	background-color:#0356a6;
	color:#FFF;
}


.TabbedPanelsTabSelected {
	background-color:#0356a6;
	color:#FFF;
	
}


.TabbedPanelsTab a {
	color: black;
	text-decoration: none;
}


.TabbedPanelsContentGroup {
	clear: both;
	
}

@media print {
.TabbedPanels {
	overflow: visible !important;
}
.TabbedPanelsContentGroup {
	display: block !important;
	overflow: visible !important;
	height: auto !important;
}
.TabbedPanelsContent {
	overflow: visible !important;
	display: block !important;
	clear:both !important;
}
.TabbedPanelsTab {
	 overflow: visible !important;
	 display: block !important;
	 clear:both !important;
}
.TabbedPanelsTab1 {	
	
	float:left;
	width:60px;
	height:25px;
	font-size:12px;
	list-style-type:none;
	line-height:25px;
	text-align:center;
	cursor: pointer;
	border:0px;
	margin-right:5px;
	margin-bottom:5px;
}
.TabbedPanelsTab1 {	 overflow: visible !important;
	 display: block !important;
	 clear:both !important;
}

--> 
</style>
<script type="text/javascript">


(function() { // BeginSpryComponent

if (typeof Spry == "undefined") window.Spry = {}; if (!Spry.Widget) Spry.Widget = {};

Spry.Widget.TabbedPanels = function(element, opts)
{
	this.element = this.getElement(element);
	this.defaultTab = 0; // Show the first panel by default.
	this.tabSelectedClass = "TabbedPanelsTabSelected";
	this.tabHoverClass = "TabbedPanelsTabHover";
	this.tabFocusedClass = "TabbedPanelsTabFocused";
	this.panelVisibleClass = "TabbedPanelsContentVisible";
	this.focusElement = null;
	this.hasFocus = false;
	this.currentTabIndex = 0;
	this.enableKeyboardNavigation = true;
	this.nextPanelKeyCode = Spry.Widget.TabbedPanels.KEY_RIGHT;
	this.previousPanelKeyCode = Spry.Widget.TabbedPanels.KEY_LEFT;

	Spry.Widget.TabbedPanels.setOptions(this, opts);

	// If the defaultTab is expressed as a number/index, convert
	// it to an element.

	if (typeof (this.defaultTab) == "number")
	{
		if (this.defaultTab < 0)
			this.defaultTab = 0;
		else
		{
			var count = this.getTabbedPanelCount();
			if (this.defaultTab >= count)
				this.defaultTab = (count > 1) ? (count - 1) : 0;
		}

		this.defaultTab = this.getTabs()[this.defaultTab];
	}

	// The defaultTab property is supposed to be the tab element for the tab content
	// to show by default. The caller is allowed to pass in the element itself or the
	// element's id, so we need to convert the current value to an element if necessary.

	if (this.defaultTab)
		this.defaultTab = this.getElement(this.defaultTab);

	this.attachBehaviors();
};

Spry.Widget.TabbedPanels.prototype.getElement = function(ele)
{
	if (ele && typeof ele == "string")
		return document.getElementById(ele);
	return ele;
};

Spry.Widget.TabbedPanels.prototype.getElementChildren = function(element)
{
	var children = [];
	var child = element.firstChild;
	while (child)
	{
		if (child.nodeType == 1 /* Node.ELEMENT_NODE */)
			children.push(child);
		child = child.nextSibling;
	}
	return children;
};

Spry.Widget.TabbedPanels.prototype.addClassName = function(ele, className)
{
	if (!ele || !className || (ele.className && ele.className.search(new RegExp("\\b" + className + "\\b")) != -1))
		return;
	ele.className += (ele.className ? " " : "") + className;
};

Spry.Widget.TabbedPanels.prototype.removeClassName = function(ele, className)
{
	if (!ele || !className || (ele.className && ele.className.search(new RegExp("\\b" + className + "\\b")) == -1))
		return;
	ele.className = ele.className.replace(new RegExp("\\s*\\b" + className + "\\b", "g"), "");
};

Spry.Widget.TabbedPanels.setOptions = function(obj, optionsObj, ignoreUndefinedProps)
{
	if (!optionsObj)
		return;
	for (var optionName in optionsObj)
	{
		if (ignoreUndefinedProps && optionsObj[optionName] == undefined)
			continue;
		obj[optionName] = optionsObj[optionName];
	}
};

Spry.Widget.TabbedPanels.prototype.getTabGroup = function()
{
	if (this.element)
	{
		var children = this.getElementChildren(this.element);
		if (children.length)
			return children[0];
	}
	return null;
};

Spry.Widget.TabbedPanels.prototype.getTabs = function()
{
	var tabs = [];
	var tg = this.getTabGroup();
	if (tg)
		tabs = this.getElementChildren(tg);
	return tabs;
};

Spry.Widget.TabbedPanels.prototype.getContentPanelGroup = function()
{
	if (this.element)
	{
		var children = this.getElementChildren(this.element);
		if (children.length > 1)
			return children[1];
	}
	return null;
};

Spry.Widget.TabbedPanels.prototype.getContentPanels = function()
{
	var panels = [];
	var pg = this.getContentPanelGroup();
	if (pg)
		panels = this.getElementChildren(pg);
	return panels;
};

Spry.Widget.TabbedPanels.prototype.getIndex = function(ele, arr)
{
	ele = this.getElement(ele);
	if (ele && arr && arr.length)
	{
		for (var i = 0; i < arr.length; i++)
		{
			if (ele == arr[i])
				return i;
		}
	}
	return -1;
};

Spry.Widget.TabbedPanels.prototype.getTabIndex = function(ele)
{
	var i = this.getIndex(ele, this.getTabs());
	if (i < 0)
		i = this.getIndex(ele, this.getContentPanels());
	return i;
};

Spry.Widget.TabbedPanels.prototype.getCurrentTabIndex = function()
{
	return this.currentTabIndex;
};

Spry.Widget.TabbedPanels.prototype.getTabbedPanelCount = function(ele)
{
	return Math.min(this.getTabs().length, this.getContentPanels().length);
};

Spry.Widget.TabbedPanels.addEventListener = function(element, eventType, handler, capture)
{
	try
	{
		if (element.addEventListener)
			element.addEventListener(eventType, handler, capture);
		else if (element.attachEvent)
			element.attachEvent("on" + eventType, handler);
	}
	catch (e) {}
};

Spry.Widget.TabbedPanels.prototype.cancelEvent = function(e)
{
	if (e.preventDefault) e.preventDefault();
	else e.returnValue = false;
	if (e.stopPropagation) e.stopPropagation();
	else e.cancelBubble = true;

	return false;
};

Spry.Widget.TabbedPanels.prototype.onTabClick = function(e, tab)
{
	this.showPanel(tab);
	return this.cancelEvent(e);
};

Spry.Widget.TabbedPanels.prototype.onTabMouseOver = function(e, tab)
{
	this.addClassName(tab, this.tabHoverClass);
	return false;
};

Spry.Widget.TabbedPanels.prototype.onTabMouseOut = function(e, tab)
{
	this.removeClassName(tab, this.tabHoverClass);
	return false;
};

Spry.Widget.TabbedPanels.prototype.onTabFocus = function(e, tab)
{
	this.hasFocus = true;
	this.addClassName(tab, this.tabFocusedClass);
	return false;
};

Spry.Widget.TabbedPanels.prototype.onTabBlur = function(e, tab)
{
	this.hasFocus = false;
	this.removeClassName(tab, this.tabFocusedClass);
	return false;
};

Spry.Widget.TabbedPanels.KEY_UP = 38;
Spry.Widget.TabbedPanels.KEY_DOWN = 40;
Spry.Widget.TabbedPanels.KEY_LEFT = 37;
Spry.Widget.TabbedPanels.KEY_RIGHT = 39;



Spry.Widget.TabbedPanels.prototype.onTabKeyDown = function(e, tab)
{
	var key = e.keyCode;
	if (!this.hasFocus || (key != this.previousPanelKeyCode && key != this.nextPanelKeyCode))
		return true;

	var tabs = this.getTabs();
	for (var i =0; i < tabs.length; i++)
		if (tabs[i] == tab)
		{
			var el = false;
			if (key == this.previousPanelKeyCode && i > 0)
				el = tabs[i-1];
			else if (key == this.nextPanelKeyCode && i < tabs.length-1)
				el = tabs[i+1];

			if (el)
			{
				this.showPanel(el);
				el.focus();
				break;
			}
		}

	return this.cancelEvent(e);
};

Spry.Widget.TabbedPanels.prototype.preorderTraversal = function(root, func)
{
	var stopTraversal = false;
	if (root)
	{
		stopTraversal = func(root);
		if (root.hasChildNodes())
		{
			var child = root.firstChild;
			while (!stopTraversal && child)
			{
				stopTraversal = this.preorderTraversal(child, func);
				try { child = child.nextSibling; } catch (e) { child = null; }
			}
		}
	}
	return stopTraversal;
};

Spry.Widget.TabbedPanels.prototype.addPanelEventListeners = function(tab, panel)
{
	var self = this;
	Spry.Widget.TabbedPanels.addEventListener(tab, "click", function(e) { return self.onTabClick(e, tab); }, false);
	Spry.Widget.TabbedPanels.addEventListener(tab, "mouseover", function(e) { return self.onTabMouseOver(e, tab); }, false);
	Spry.Widget.TabbedPanels.addEventListener(tab, "mouseout", function(e) { return self.onTabMouseOut(e, tab); }, false);

	if (this.enableKeyboardNavigation)
	{
		// XXX: IE doesn't allow the setting of tabindex dynamically. This means we can't
		// rely on adding the tabindex attribute if it is missing to enable keyboard navigation
		// by default.

		// Find the first element within the tab container that has a tabindex or the first
		// anchor tag.
		
		var tabIndexEle = null;
		var tabAnchorEle = null;

		this.preorderTraversal(tab, function(node) {
			if (node.nodeType == 1 /* NODE.ELEMENT_NODE */)
			{
				var tabIndexAttr = tab.attributes.getNamedItem("tabindex");
				if (tabIndexAttr)
				{
					tabIndexEle = node;
					return true;
				}
				if (!tabAnchorEle && node.nodeName.toLowerCase() == "a")
					tabAnchorEle = node;
			}
			return false;
		});

		if (tabIndexEle)
			this.focusElement = tabIndexEle;
		else if (tabAnchorEle)
			this.focusElement = tabAnchorEle;

		if (this.focusElement)
		{
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "focus", function(e) { return self.onTabFocus(e, tab); }, false);
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "blur", function(e) { return self.onTabBlur(e, tab); }, false);
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "keydown", function(e) { return self.onTabKeyDown(e, tab); }, false);
		}
	}
};

Spry.Widget.TabbedPanels.prototype.showPanel = function(elementOrIndex)
{
	var tpIndex = -1;
	
	if (typeof elementOrIndex == "number")
		tpIndex = elementOrIndex;
	else // Must be the element for the tab or content panel.
		tpIndex = this.getTabIndex(elementOrIndex);
	
	if (!tpIndex < 0 || tpIndex >= this.getTabbedPanelCount())
		return;

	var tabs = this.getTabs();
	var panels = this.getContentPanels();

	var numTabbedPanels = Math.max(tabs.length, panels.length);

	for (var i = 0; i < numTabbedPanels; i++)
	{
		if (i != tpIndex)
		{
			if (tabs[i])
				this.removeClassName(tabs[i], this.tabSelectedClass);
			if (panels[i])
			{
				this.removeClassName(panels[i], this.panelVisibleClass);
				panels[i].style.display = "none";
			}
		}
	}

	this.addClassName(tabs[tpIndex], this.tabSelectedClass);
	this.addClassName(panels[tpIndex], this.panelVisibleClass);
	panels[tpIndex].style.display = "block";

	this.currentTabIndex = tpIndex;
};

Spry.Widget.TabbedPanels.prototype.attachBehaviors = function(element)
{
	var tabs = this.getTabs();
	var panels = this.getContentPanels();
	var panelCount = this.getTabbedPanelCount();

	for (var i = 0; i < panelCount; i++)
		this.addPanelEventListeners(tabs[i], panels[i]);

	this.showPanel(this.defaultTab);
};

})(); 
</script>
<title>Insert title here</title>
</head>
<body >

<!--控制整个页面大小的外框 width2 -->
<div id="width2" style="width:85%;  float:left;">
<!--控制中部主体内容的外框 contenta -->
<div id="contenta">

<!--左-->

<!--左 end-->

<!--中间 ocontent-->
<div id="ocontent" >

<!--中间2层框 contentcenter-->
<div id="contentcenter">

<!--中间标题 contentcenterbiaoti-->
<div id="contentcenterbiaoti">
<div id="tongyong03"> 
<li>航空公司退票及变更规定</li>
</div>
</div>
<!--中间标题 contentcenterbiaoti end-->

<!--这里放主体内容 contentcenterneirong-->

<div id="contentcenterneirong" >
<span style="font-size:14px; color:#F00;"><strong>各航空公司退废票规定 （此规定仅供参考，最终以航空公司审核为准。）</strong><br>
</span>
<div id="TabbedPanels1" class="TabbedPanels">

  <ul class="TabbedPanelsTabGroup">
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">中国国航</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">东方航空</li>
     <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">上海航空</li>
      <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">南方航空</li>
      <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">山东航空</li>
        <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">深圳航空</li>
        <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">四川航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">厦门航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">海航集团</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">成都航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">吉祥航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">华夏航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">奥凯航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">河北航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">中联航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">首都航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">幸福航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">西藏航空</li>
    <li class="TabbedPanelsTab" tabindex="0" onfocus="this.blur();">昆明航空</li>
  </ul>

  <div class="TabbedPanelsContentGroup">
<!--中国国航-->  
<div class="TabbedPanelsContent">
<span class="wenzi"> 
中国国航：<br />
<strong >废票规定：</strong>废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。<br />
</span> 

<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
               <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="15%" align="center" rowspan="25"><strong>国航CA</strong><br />
                  2011年8月1日出票起开始执行</td>
                <td width="20%" height="26" rowspan="2" align="center" ><strong>舱位</strong></td>
                <td width="20%" rowspan="2" align="center" ><strong>折扣</strong></td>
                <td width="20%" colspan="2"align="center"><strong>退票手续费</strong></td>
				<td width="20%" colspan="2" align="center" ><strong>变更</strong></td>
              </tr>
            <tr class="tr_bg" style="">
              <td  align="center" >航班起飞前2小时之前取消定座</td>
              <td align="center">航班起飞前2小时之内及航班起飞后取消定座</td>
              <td width="10%" align="center" >航班起飞前2小时之前取消定座</td>
              <td width="10%" align="center" >航班起飞前2小时之内及航班起飞后取消定座</td>
            </tr>
              <tr>
                <td>F</td>
                <td rowspan="2">头等舱</td>
                <td rowspan="7" >免费</td>
                <td rowspan="7" >收取10%退票费</td>
                <td rowspan="14">免费变更</td>
                <td rowspan="7">收取5%变更费</td>
                
              </tr>
              <tr>
                <td height="26">A</td>
              </tr>
              <tr>
                <td height="26">C</td>
                <td rowspan="3">公务舱</td>
                </tr>
              <tr>
                <td height="26">D</td>
                </tr>
              <tr>
                <td height="26">Z</td>
                </tr>
              <tr>
                <td height="26">J</td>
                <td>100%</td>
                </tr>
              <tr>
                <td height="26">Y</td>
                <td>100%</td>
                </tr>
              <tr>
                <td height="26">B</td>
                <td>90%</td>
                <td rowspan="7">收取10%退票费</td>
                <td rowspan="7">收取20%退票费</td>
                <td rowspan="7">收取10%变更费</td>
               </tr>
              <tr>
                <td height="26">M</td>
                <td>88%</td>
                </tr>
              <tr>
                <td height="26">M1</td>
                <td>85%</td>
                </tr>
              <tr>
                <td height="26">H</td>
                <td>80%</td>
                </tr>
              <tr>
                <td height="26">H1</td>
                <td>78%</td>
                </tr>
              <tr>
                <td height="26">K</td>
                <td>75%</td>
                </tr>
              <tr>
                <td height="26">K1</td>
                <td>73%</td>
                </tr>
              <tr>
                <td height="26">L</td>
                <td>70%</td>
                <td rowspan="7">收取30%退票费</td>
                <td rowspan="7">收取40%退票费</td>
                <td rowspan="7">收取20%变更费</td>
                <td rowspan="7">收取30%变更费</td>
              </tr>
              <tr>
                <td height="26">L1</td>
                <td>65%</td>
               </tr>
              <tr>
                <td height="26">Q</td>
                <td>60%</td>
               </tr>
              <tr>
                <td height="26">Q1</td>
                <td>55%</td>
               </tr>
              <tr>
                <td height="26">G</td>
                <td>50%</td>
               </tr>
              <tr>
                <td height="26">V</td>
                <td>45%</td>
               </tr>
              <tr>
                <td height="26">V1</td>
                <td>40%</td>
               </tr>
              <tr>
                <td>E/U</td>
                <td>4折以下舱</td>
                <td colspan="4" style="text-align:center;">只退基建、燃油费.不得签转改期</td>
              </tr>
              <tr>
                <td colspan="6"><p>团队票退票规定：</p>
                <p>团体旅客自愿要求退票,按下列规定收取退票费: <br />
                  1.在航班规定离站时间72小时(含)以前,收取客票价10%的退票费. <br />
                  2.在航班规定离站时间前72小时以内至航班规定离站时间前一日中午12时(含)以前,收取客票价30%的退票费. <br />
                  3.在航班规定离站时间前一日中午12时以后至航班规定离站时间以前,收取客票价50%的退票费. <br />
                  4.在航班规定离站时间以后,客票作废,票款不退. <br />
                  5.持联程\来回程客票的团体旅客要求退票,分别按本条第1.第2或第3款的规定收取各航段的退票费. <br />
                  (二)部分团体旅客自愿退票 <br />
                  部分团体旅客自愿要求退票,除客票附有限制条件者外,按下列规定办理: <br />
                  1.如乘机的旅客人数不少于该票价规定的最低团体人数时,按&quot;团体旅客自愿退票&quot;规定办理. <br />
                2.如乘机的旅客人数少于该票价规定的最低团体人数时,分别按下列规定办理:1)如客票全部未使用,应按团体旅客原折扣票价总金额扣除乘机旅客按正常票价计算的票款总金额后,再扣除&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补;如客票部分未使用,应将团体旅客原付折扣票价总金额扣除该团体已使用航段的票款后,再扣除乘机旅客按正常票价计算的未使用航段票款总金额及&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补. </p></td>
               </tr>
              <tr>
                <td align="center"><strong>客服电话：</strong></td>
                <td colspan="6" align="center"><strong>4008-100-999</strong></td>
              </tr>
          </table>

</div>
<!--东方航空--> 
<div class="TabbedPanelsContent">
<span class="wenzi"> 
东方航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong>升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。<br />
</span> 
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <tr class="tr_bg">
                <td width="20%" height="23" align="center"><strong>航空公司</strong></td>
                <td width="25%" align="center" colspan="2"><strong>舱位折扣</strong></td>
                <td width="25%" align="center" ><strong>退票</strong></td>
                <td width="" align="center" ><strong>变更</strong></td>
				
            </tr>
            <tr>
                <td rowspan="15" align="center"><strong>东航</strong><br />适用于2010年9月20日（含）起销售，2010年10月31日（含）以后开始旅行的客票
</td>
                <td colspan="2">F/C/Y/儿童{正常}</td>
                <td>免收退票费<br />
</td>
                <td rowspan="9">免费改期（B-S舱不得签转）</td>
               
            </tr>
            <tr>
                <td style="width:10%">B</td>
                <td style="width:10%">90%</td>
                <td rowspan="3">按票面5%收取，不低于50元</td>
            </tr>
            <tr>
                <td>E</td>
                <td>85%</td>
            </tr>
            <tr>
                <td>H</td>
                <td>80%</td>
            </tr>
            <tr>
                <td>L</td>
                <td>75%</td>
                <td rowspan="3">按票面价10%收取，不低于50元</td>
            </tr>
            <tr>
                <td>M</td>
                <td>70%</td>
            </tr>
            <tr>
                <td>N</td>
                <td>65%</td>
            </tr>
            <tr>
                <td>R</td>
                <td>60%</td>
                <td rowspan="2">按票面价20%收取，不低于50元</td>
            </tr>
            <tr>
                <td>S</td>
                <td>55%</td>
            </tr>
            <tr>
                <td>V</td>
                <td>50%</td>
                <td rowspan="3">按票面价50%收取，不低于50元</td>
                <td rowspan="3">改期按Y舱价5%的收取，不低于50元 （不得签转）</td>
            </tr>
            <tr>
                <td>T</td>
                <td>45%</td>
            </tr>
            <tr>
                <td>W</td>
                <td>40%</td>
            </tr>
            <tr>
                <td>G</td>
                <td>35%以下</td>
                <td>不得退票</td>
                <td rowspan="2">不得签转/更改</td>
            </tr>
            <tr>
                <td>X</td>
                <td>提前预定特价</td>
                <td>按票面价80%收取</td>
            </tr>
            
            <tr>
                <td>K</td>
                <td>特殊运价</td>
                <td>按相对应舱位退票办理</td>
                <td>变更按y舱5%收取，不得低于50元</td>
            </tr>
            
            <tr>
                <td style="text-align:center;"><strong >东航客服电话</strong></td>
                <td colspan="4" align="center"><strong>021-95530</strong></td>
            </tr>
          </table>
</div>
<!--上海航空--> 
<div class="TabbedPanelsContent">
<span class="wenzi"> 
上海航空：<br />
<strong style="color:#906">废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机<br />
</span> 
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
              <!--DWLayoutTable-->
                <tr class="tr_bg">
                <td width="10%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="20%" align="center" ><strong>舱位</strong></td>
                <td width="10%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
				<td width="20%" align="center" ><strong>变更</strong></td>
			  </tr>
              <tr>
                <td rowspan="15" align="center"><strong>上航</strong><br />适用于2010年9月20日（含）起销售，2010年10月31日（含）以后开始旅行的客票</td>
                <td>F/FCH</td>
                <td>150%</td>
                <td rowspan="3">免收退票费<br /></td>
                <td rowspan="3">免费变更</td>
              
              </tr>
              <tr>
                <td>C/CCH</td>
                <td>130%</td>
              </tr>
              <tr>
                <td>Y/YCH</td>
                <td>100%</td>
              </tr>
              <tr>
                <td height="26">B</td>
                <td>90%</td>
                <td rowspan="3">收取5%的退票费,不低于50元</td>
                <td rowspan="8">免费变更（B-S舱不得签转）</td>
              </tr>
              <tr>
                <td height="26">E</td>
                <td>85%</td>
              </tr>
              <tr>
                <td height="26">H</td>
                <td>80%</td>
              </tr>
              <tr>
                <td height="26">L</td>
                <td>75%</td>
                <td rowspan="3">收取10%的退票费,不低于50元</td>
              </tr>
              <tr>
                <td height="26">M</td>
                <td>70%</td>
              </tr>
              <tr>
                <td height="26">N</td>
                <td>65%</td>
              </tr>
              <tr>
                <td height="26">R</td>
                <td>60%</td>
                <td rowspan="2">收取20%的退票费,不低于50元</td>
              </tr>
              <tr>
                <td height="26">S</td>
                <td>55%</td>
              </tr>
              <tr>
                <td>V</td>
                <td>50%</td>
                <td rowspan="3">收取50%的退票费,不低于50元</td>
                <td rowspan="3">变更按Y舱价5%的收取，不低于50元  （不得签转）</td>

              </tr>
              <tr>
                <td>T</td>
                <td>45%</td>
              </tr>
              
              <tr>
                <td>W</td>
                <td>40%</td>
              </tr>
              <tr>
                <td height="26">X</td>
              <td>预售舱位</td>
                <td>收取80%的退票费,不低于50元</td>
                <td>不得签转变更</td>
              </tr>
              
              <tr>
                <td style="text-align:center;"><strong >上航客服电话</strong></td>
                <td colspan="4" align="center"><strong >10105858</strong></td>
              </tr>
            </table>
</div>
<!--南方航空-->    
<div class="TabbedPanelsContent">
<span class="wenzi"> 
南方航空：<br />
<strong>废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机<br />
</span> 
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
              <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="10%" height="" align="center" ><strong>航空公司</strong></td>
                <td width="5%" align="center" ><strong>舱位</strong></td>
                <td width="5%" align="center" ><strong>折扣</strong></td>
                <td width="10%" align="center" ><strong>退票手续费</strong><br />航班规定离站时间前</td>
                <td width="10%" align="center" ><strong>退票手续费</strong><br />
                航班规定离站时间后</td>
                <td width="10%" align="center" ><strong>变更费</strong><br />航班规定离站时间前</td>
                <td width="10%" align="center" ><strong>变更费</strong><br />航班规定离站时间后</td>
	
			    </tr>
            <tr>
                <td align="center" rowspan="21"><strong >南方航空</strong><BR />本规定自2011年5月1日起销售的客票开始执行</td>
                <td height="26">F</td>
                <td>200</td>
                <td rowspan="2">免费</td>
                <td rowspan="2">免费</td>
                <td rowspan="5">免费</td>
                <td rowspan="5">免费</td>
               </tr>
            <tr>
              <td height="26">A</td>
              <td><!--DWLayoutEmptyCell-->&nbsp;</td>
              </tr>
            <tr>
                <td height="26">P</td>
                <td>150</td>
                <td valign="top">5％</td>
                <td valign="top">5％</td>
                </tr>
            
            <tr>
                <td height="26">C</td>
                <td>150</td>
                <td>免费</td>
                <td>免费</td>
                 </tr>
            <tr>
                <td height="26">D</td>
                <td>130</td>
                <td>5%</td>
                <td>5%</td>
                  </tr>
            <tr>
                <td height="26">W</td>
                <td>100</td>
                <td>5%</td>
                <td>10%</td>
                <td>免费</td>
                <td>5%</td>
                  </tr>
            <tr>
                <td height="26">Z</td>
                <td>高端经济舱优惠舱</td>
                <td colspan="2">按具体文件使用条件</td>
                <td colspan="2">按具体文件使用条件</td>
                </tr>
            <tr>
                <td height="26">Y</td>
                <td>100</td>
                <td rowspan="4">5%</td>
                <td rowspan="4">10%</td>
                <td rowspan="4">免费</td>
                <td rowspan="4">5%</td>
                 </tr>
            <tr>
                <td height="26">T</td>
                <td>90-90</td>
              </tr>
            <tr>
                <td height="26">K</td>
                <td>85-89</td>
              </tr>
            <tr>
                <td height="26">H</td>
                <td>80-84</td>
              </tr>
            <tr>
                <td height="26">M</td>
                <td>75-79</td>
                <td rowspan="4">20%</td>
                <td rowspan="4">20%</td>
                <td rowspan="4">10%</td>
                <td rowspan="4">10%</td>
              </tr>
            <tr>
                <td height="26">G</td>
                <td>70-74</td>
              </tr>
            <tr>
              <td height="26">S</td>
              <td>65-69</td>
              </tr>
            <tr>
              <td height="26">L</td>
              <td>60-64</td>
              </tr>
            <tr>
                <td height="26">Q</td>
                <td>55-59</td>
                <td rowspan="3">50%</td>
                <td rowspan="3">50%</td>
                <td rowspan="3">20%</td>
                <td rowspan="3">20%</td>
              </tr>
            <tr>
              <td height="26">E</td>
              <td>50-54</td>
              </tr>
            <tr>
              <td height="26">V</td>
              <td>45-49</td>
              </tr>
            <tr>
                <td height="26">X</td>
                <td>40-44</td>
                <td colspan="2" rowspan="2">不得退票</td>
                <td colspan="2" rowspan="2">不得变更</td>
              </tr>
            <tr>
              <td height="26">N/R</td>
              <td>40%以下</td>
              </tr>
            
            
            <tr>
              <td height="133">B/O</td>
              <td>其它</td>
              <td colspan="4">按具体文件使用条件</td>
              </tr>
            
            <tr>
              <td align="center"><strong >南航客服电话</strong></td>
                <td colspan="6" style="text-align:center;"><strong >（020）95539 </strong></td>
              </tr>
            <tr>
              <td align="center"><strong>电子商务</strong></td>
              <td colspan="6" style="text-align:center;"><strong > （020）86133399 （020）28295539</strong></td>
            </tr>
         </table>
</div>
<!--山东航空--> 
<div class="TabbedPanelsContent">
<span class="wenzi"> 
山东航空：<br />
<strong>废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong style="color:#906"><strong >升舱规定：</strong></strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机<br />
</span> 
 <TABLE class=tablez border=0 cellSpacing=1 cellPadding=0 width="100%"><!--DWLayoutTable-->
<TBODY>
<TR class=tr_bg>
<TD height=23 width="10%" align=middle><STRONG>航空公司</STRONG></TD>
<TD width="10%" align=middle><STRONG>舱位</STRONG></TD>
<TD width="10%" align=middle><STRONG>折扣</STRONG></TD>
<TD width="20%" align=middle><STRONG>退票手续费</STRONG></TD>
<TD width="20%" align=middle><STRONG>变更</STRONG></TD>
</TR>
<TR>
<TD rowSpan=16 align=middle><SPAN 
class=STYLE1><strong >山东航空</strong></SPAN><BR>本规定适用于首次填开的未经更改的、销售日期和航班日期为2011年8月10日（含）以后的国内客票</TD>
<TD>F</TD>
<TD>150</TD>
<TD rowSpan=2>免收退票费</TD>
<TD rowSpan=6>免费变更</TD>
</TR>
<TR>
<TD>C</TD>
<TD>130</TD></TR>
<TR>
<TD>Y</TD>
<TD>100</TD>
<TD rowSpan=4>收取票面的5%</TD></TR>
<TR>
<TD>B</TD>
<TD>90</TD></TR>
<TR>
<TD>M</TD>
<TD>85</TD></TR>
<TR>
<TD>H</TD>
<TD>80</TD></TR>
<TR>
<TD>K</TD>
<TD>75</TD>
<TD rowSpan=4>收票面的10%</TD>
<TD rowSpan=4>每次按票面的10%收取改期费</TD></TR>
<TR>
<TD>L</TD>
<TD>70</TD></TR>
<TR>
<TD>Q</TD>
<TD>60</TD></TR>
<TR>
<TD>G</TD>
<TD>55</TD></TR>
<TR>
<TD>V</TD>
<TD>50</TD>
<TD rowSpan=3>收取票面的30%</TD>
<TD rowSpan=3>每次更改均按票面的20%收以改期费</TD></TR>
<TR>
<TD>U</TD>
<TD>45</TD></TR>
<TR>
<TD>Z</TD>
<TD>40</TD></TR>
<TR>
<TD>P</TD>
<TD><!--DWLayoutEmptyCell-->&nbsp;</TD>
<TD colSpan=2>按照舱位就低原则，按临近运价舱位处理</TD></TR>
<TR>
<TD>R/W/T/E/J</TD>
<TD>特价舱</TD>
<TD>收取 
40%的退票费，如对应产品上规定不得退票，则不允许退票，仅退还机场建设费和燃油附加费。W/T舱如已经使用一段后，不允许退票，仅退还未使用航段的机场建设费和燃油附加费</TD>
<TD>每次更改收取30%改期费，但如对应产品中规定不得改期，则禁止改期 </TD></TR>
<TR>
<TD align="left">团队票</TD>
<TD  colSpan=3 align="left">
团体旅客自愿要求退票,按下列规定收取退票费: <br>
1、在航班起飞前72小时（含）以前取消订座，收取10%的退票费<br>
2、在航班起飞前72小时以内至起飞时间前一日中午12时(含)以前取消订座,收取客票价30%的退票费； <br>
3、在航班起飞前一日中午12时以后至航班起飞前2小时（含）以前取消订座,收取客票价50%的退票费；<br> 
4、在航班起飞前2小时以内及航班起飞后取消订座,客票作废,票款不退；<br>
5、持联程/来回程客票的团体旅客要求退票，分别按本条第1、第2、第3或第4款的规定收取各行段的退票费。 <br>

</TD>
</TR>

<TR>
<TD align="center" style="TEXT-ALIGN: center"><SPAN class=STYLE1><strong>山东客服</strong></SPAN></TD>
<TD colSpan=4 align="center"><strong >（0531）96777</STRONG></TD>
</TR>
</TBODY></TABLE>
</div>
<!--深圳航空--> 
<div class="TabbedPanelsContent">
<span class="wenzi"> 
深<span class="TabbedPanelsTab1">圳</span>航空：<br />
<strong >废票规定：</strong>废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
 <strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机<br />
</span> 
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
              <!--DWLayoutTable-->
             <tr class="tr_bg">
                <td width="15%" align="center" rowspan="16"><strong >深航ZH</strong><br />（适用于2011年9月1日(含)以后销售,2011年9月1日(含)以后开始旅行的客票）  </td>
                <td width="7%" height="0" rowspan="2" align="center"><strong>舱位</strong></td>
                <td width="7%" rowspan="2" align="center"><strong>折扣</strong></td>
                <td colspan="2" align="center"><strong>退票手续费</strong></td>
                <td colspan="2" align="center"><strong>变更</strong></td>
            </tr>
             <tr class="tr_bg">
               <td align="center">航班起飞前2小时之前</td>
               <td align="center">航班起飞前2小时之内及航班起飞后</td>
               <td align="center">航班起飞前2小时之前</td>
               <td align="center">航班起飞前2小时之内及航班起飞后</td>
             </tr>
            
            <tr>
                <td height="0">F</td>
                <td>销售系统查询为准</td>
                <td width="15%" rowspan="3">免费</td>
                <td width="14%" rowspan="3">收取票面10%的退票费</td>
                <td width="13%" rowspan="7">免费</td>
                <td width="15%" rowspan="3">收取票面5%退票费</td>
            </tr>
            <tr>
                <td height="26">C</td>
                <td>销售系统查询为准</td>
              </tr>
            <tr>
                <td height="26">Y</td>
                <td>100%</td>
              </tr>
            <tr>
                <td height="26">B</td>
                <td>90%</td>
                <td rowspan="4">收取票面10%的退票费</td>
                <td rowspan="4">收取票面20%退票费</td>
                <td width="15%" rowspan="4">收取票面10%退票费</td>
              </tr>
            <tr>
                <td height="26">M</td>
                <td>85%</td>
              </tr>
            <tr>
                <td height="26">H</td>
                <td>80%</td>
              </tr>
            <tr>
                <td height="26">K</td>
                <td>75%</td>
              </tr>
            <tr>
                <td height="26">L</td>
                <td>70%</td>
                <td rowspan="6">收取票面30%的退票费</td>
                <td rowspan="6">收取票面40%退票费</td>
                <td rowspan="6">收取票面20%退票费</td>
                <td rowspan="6">收取票面30%退票费</td>
              </tr>
            <tr>
                <td height="26">P</td>
                <td>65%</td>
              </tr>
            <tr>
                <td height="26">Q</td>
                <td>60%</td>
              </tr>
            <tr>
                <td height="26">G</td>
                <td>50%</td>
              </tr>
            <tr>
                <td height="26">V</td>
                <td>45%</td>
              </tr>
            <tr>
                <td height="26">Z</td>
                <td>40%</td>
              </tr>
			 <tr>
			 <td colspan="2">团体旅客退票规定:</td>
             <td colspan="4"><span style="font-weight:normal">(一) 团体旅客自愿退票<br />
团体旅客自愿要求退票,按下列规定收取退票费：<br />
1、 在航班规定离站时间72小时(含)以前,收取客票价10%的退票费。<br />
2、 在航班规定离站时间前72小时以内至航班规定离站时间前一日中午12时(含)以前,收取客票价30%的退票费。<br />
3、 在航班规定离站时间前一日中午12时以后至航班规定离站时间以前,收取客票价50%的退票费。<br />
4、 在航班规定离站时间以后,客票作废,票款不退。<br />
5、 持联程\来回程客票的团体旅客要求退票,分别按本条第1.第2或第3款的规定收取各航段的退票费。<br />
(二) 部分团体旅客自愿退票<br />
部分团体旅客自愿要求退票,除客票附有限制条件者外,按下列规定办理:<br />
1、如乘机的旅客人数不少于该票价规定的最低团体人数时,按&quot;团体旅客自愿退票&quot;规定办理。<br />
2、如乘机的旅客人数少于该票价规定的最低团体人数时,分别按下列规定办理：<br />
1) 如客票全部未使用,应按团体旅客原折扣票价总金额扣除乘机旅客按正常票价计算的票款总金额后,再扣除&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补;<br />
2) 如客票部分未使用,应将团体旅客原付折扣票价总金额扣除该团体已使用航段的票款后,再扣除乘机旅客按正常票价计算的未使用航段票款总金额及&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补。 </span></td>
             </tr>
			 <tr>
			   <td align="center"><strong >客服电话：</strong></td>
			   <td height="26" colspan="6" align="center"><strong > 400-88-95080</strong></td>
		      </tr>
           </table>
</div>
<!--四川航空--> 
<div class="TabbedPanelsContent">
<span class="wenzi"> 
四川航空：<br />
<strong >废票规定：</strong>废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。<br />
</span> 
<TABLE class=tablez border=0 cellSpacing=1 cellPadding=0 width="100%" style="line-height:25px;">
<TBODY>
<TR class=tr_bg>
<TD height=23 rowSpan=2 width="20%" align=middle><STRONG>航空公司</STRONG></TD>
<TD rowSpan=2 width="10%" align=middle><STRONG>舱位</STRONG></TD>
<TD rowSpan=2 width="10%" align=middle><STRONG>折扣</STRONG></TD>
<TD colSpan=3 align=middle><STRONG>退票手续费</STRONG></TD>
<TD rowSpan=2 width="15%" align=middle><STRONG>变更</STRONG></TD>
</TR>
<TR class=tr_bg>
<TD width=182 align=middle>起飞前24小时</TD>
<TD width=182 align=middle>起飞前24-2小时</TD>
<TD width=182 align=middle>起飞前2小时以内及起飞后</TD></TR>
<TR>
<TD rowSpan=25 align=center><strong >四川航空</strong><BR>本规定自2011年10月14日开始出票、以2011年10月14日旅行起执行</TD>
<TD height=26>F</TD>
<TD>200%-150%</TD>
<TD>免收退票费</TD>
<TD>免收退票费</TD>
<TD>收5%</TD>
<TD rowSpan=7>免费更改<BR><BR></TD>
</TR>
<TR>
<TD>A</TD>
<TD>150%-100%</TD>
<TD>收5%</TD>
<TD>收10%</TD>
<TD>收10%</TD></TR>
<TR>
<TD >C</TD>
<TD>130%-100%</TD>
<TD>免收退票费</TD>
<TD>免收退票费</TD>
<TD>收5%</TD></TR>
<TR>
<TD >J</TD>
<TD>120%-100%</TD>
<TD rowSpan=4>收5%</TD>
<TD rowSpan=4>收10%</TD>
<TD rowSpan=2>收10%</TD></TR>
<TR>
<TD >Y</TD>
<TD>100%-91%</TD></TR>
<TR>
<TD >T</TD>
<TD>90%-81%</TD>
<TD rowSpan=2>收20%</TD></TR>
<TR>
<TD height=26>H</TD>
<TD>80%-76%</TD></TR>
<TR>
<TD>M</TD>
<TD>75%-71%</TD>
<TD rowSpan=4>收10%</TD>
<TD rowSpan=4>收20%</TD>
<TD rowSpan=4>收30%</TD>
<TD rowSpan=4>每次更改收取票面价10%改期费</TD></TR>
<TR>
<TD>G</TD>
<TD>70%-66%</TD></TR>
<TR>
<TD>S</TD>
<TD>65%-61%</TD></TR>
<TR>
<TD>L</TD>
<TD>60%-56%</TD></TR>
<TR>
<TD>Q</TD>
<TD>55%-51%</TD>
<TD rowSpan=4>收30%</TD>
<TD rowSpan=4>收30%</TD>
<TD rowSpan=4>收40%</TD>
<TD rowSpan=4>每次更改收取票面价20%改期费</TD></TR>
<TR>
<TD>E</TD>
<TD>50%-46%</TD></TR>
<TR>
<TD>V</TD>
<TD>45%-41%</TD></TR>
<TR>
<TD>R</TD>
<TD>40%-36%</TD></TR>
<TR>
<TD>K</TD>
<TD>35%-31%</TD>
<TD rowSpan=2 colSpan=3>仅退机建费和燃油费，机票款不退</TD>
<TD rowSpan=2>不得自愿改期 升舱</TD></TR>
<TR>
<TD>I</TD>
<TD>30%</TD></TR>
<TR>
<TD colSpan=2>特价：N/D/Z</TD>
<TD><!--DWLayoutEmptyCell-->&nbsp;</TD>
<TD><!--DWLayoutEmptyCell-->&nbsp;</TD>
<TD>
<P>若3折(含)以上,按照该客票类别所对应的规定执行</P>
<P>若3折以下,实际订座舱位字母代码为YN，YZ，YD时,仅退机建费和燃油</P></TD>
<TD>
<P>若3折(含)以上,按照该客票类别所对应的规定执行</P>
<P>若3折以下,实际订座舱位字母代码为YN，YZ，YD时,不得自愿改期、升舱</P></TD></TR>
<TR>
<TD colSpan=2>W/X/B/U/P</TD>
<TD colSpan=4>客票类别项以下发的业务通告为准。不得自愿签转、自愿改期、自愿变更，但允许自愿退票。自愿退票见川航特殊客票规定。</TD></TR>
<TR>
<TD colSpan=2>J（超级经济舱）</TD>
<TD 
colSpan=4>客票类别项：YJ，票价区间：100%-80%，允许预先订座，不得填开OPEN客票，不得自愿签转，允许免费改期，退票费为票价的5%。</TD></TR>
<TR>
<TD >A（头等舱优免票、常旅客升舱）</TD>
<TD>F+折扣率或F00</TD>
<TD rowSpan=3 colSpan=4>见《四川航空金熊猫里程奖励计划会员手册》规定</TD></TR>
<TR>
<TD >J（公务舱常旅客免票舱)</TD>
<TD>C+折扣率或C00</TD></TR>
<TR>
<TD >O（经济舱常旅客免票舱）</TD>
<TD>Y00</TD></TR>
<TR>
<TD >Z（经济舱签发证优免票）</TD>
<TD>Y00或Y+折扣率</TD>
<TD colSpan=4>凭川航签发证办理，随订随售\允许OPEN\不允许自愿签转\允许改期\免费退票</TD></TR>
<TR>
<TD>团体旅客退票规定:</TD>
<TD vAlign=top 
colSpan=5>1.团队客票全程未使用：在始发航班规定离站时间72小时（含）以前退票，收取客票总价10%的退票费；在始发航班规定离站时间前72小时以内至始发航班规定离站时间前一日中午12时（含）以前退票，收取客票总价30%的退票费；在始发航班规定离站时间前一日中午12时以后至始发航班规定离站时间以前退票，收取客票总价50%的退票费；始发航班规定离站时间 
(含)及之后提出退票，仅退机建费和燃油费，客票款不退。<BR>2.团队客票部分航段使用情况下的退票费：应首先收取已使用航段的Y舱全价，剩余航段再按照团队客票全程未使用规定收取退票费。如没有剩余金额，则仅退机建费和燃油费，客票款不退。 
<BR>3.团体部分旅客自愿要求退票，参照以上团队客票自愿退票规定执行。如果旅客退票后造成剩余旅客不成团，则剩余旅客各航段需全部补齐Y舱全价后方予成行，否则全体团队旅客做自愿退票处理。</TD></TR>
<tr>
                <td align="center"><strong >四川航空</strong></td>
                <td align="center" colspan="6"><strong >028-88888888


</strong></td>
               </tr>
</TBODY></TABLE>
</div>
<!--厦门航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
厦门航空：<br />
<strong >废票规定：</strong>航班起飞当天销售的客票不允许作废。<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。<br />
</span> 
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
             <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="20%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="20%" align="center" ><strong>舱位</strong></td>
                <td width="20%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				  </tr>
            <tr>
              <td align="center" rowspan="18"><strong >厦航</strong><BR />本客规自2010年8月25日起执行（出票日）
</td>
              <td valign="top">P</td>
              <td>200</td>
              <td rowspan="5">收取票面5%的退票费</td>
              <td rowspan="13">同舱位免费变更（B-R舱不得自愿签转</td>
             </tr>
            <tr>
              <td valign="top">F</td>
              <td>180</td>
             </tr>
            <tr>
              <td valign="top">J</td>
              <td>160</td>
             </tr>
            <tr>
              <td valign="top">Y</td>
              <td>100</td>
             </tr>
            <tr>
              <td valign="top">儿童(PCH/FCH/YCH)</td>
              <td>&nbsp;</td>
             </tr>
            <tr>
                <td>B</td>
                <td>90</td>
                <td rowspan="3">取票面10%的退票费</td>
             </tr>
            <tr>
                <td>H</td>
                <td>85</td>
             </tr>
            <tr>
                <td>K</td>
                <td>80</td>
             </tr>
            <tr>
                <td>L</td>
                <td>75</td>
                <td rowspan="5">收取票面20%的退票费</td>
             </tr>
            <tr>
                <td>M</td>
                <td>70</td>
             </tr>
            <tr>
                <td>N</td>
                <td>65</td>
             </tr>
            <tr>
                <td>Q</td>
                <td>60</td>
             </tr>
            <tr>
                <td>T</td>
                <td>55</td>
             </tr>
            <tr>
                <td>V</td>
                <td>50</td>
                <td rowspan="3">收取票面30%的退票费</td>
                <td rowspan="3">每次变更收取票面20%改期费</td>
            </tr>
            <tr>
                <td>X</td>
                <td>45</td>
             </tr>
            <tr>
                <td>R</td>
                <td>40</td>
             </tr>
            
            <tr>
                <td>R舱(不含)以下</td>
                <td></td>
                <td>不得退票</td>
                <td>同等舱位变更，每次收取票面价20%的变更费。升舱时，除收取票面价20%的变更费外，还需补收升舱差额. </td>
            </tr>
            <tr>
                <td>I (往返特价)</td>
                <td></td>
                <td>客票全部未使用:收取20％的退票费，不得退单程航段。已使用部分航段：扣除未使用航段票面价80%后，退还旅客未使用航段票面的20%</td>
                <td>每段允许变更两次，超过两次按自愿退票处理；</td>
            </tr>
            <tr>
                <td align="center"><strong >厦航客服电话</strong></td>
                <td colspan="4" align="center"><strong >8008582666 （0592）95557</strong></td>
            </tr>
          </table>
</div>
<!--海航集团-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
海航集团：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。 

</span> 
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
             <!--DWLayoutTable-->
               <tr class="tr_bg">
                <td width="22%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="15%" align="center" ><strong>舱位</strong></td>
                <td width="15%" align="center" ><strong>折扣</strong></td>
                <td width="25%" align="center" ><strong>退票手续费</strong></td>
                <td width="25%" align="center" ><strong>变更</strong></td>
				 </tr>
               <tr>
                 <td rowspan="22" align="center"><strong >海航集团
{海航，祥鹏，大新华，天津，西部}</strong><br />
                 2011年3月28号出票起执行</td>
                 <td height="26">R</td>
                 <td>钻石头等舱</td>
                 <td rowspan="6">收取票面价5%的退票费</td>
                 <td rowspan="10">免费变更，不限次数</td>
                </tr>
               <tr>
                 <td height="26">F</td>
                 <td>头等舱</td>
               </tr>
               <tr>
                 <td height="26">F1</td>
                 <td>头等舱子舱位</td>
               </tr>
               <tr>
                <td height="26">A</td>
                <td>舒适A舱</td>
               </tr>
               <tr>
                 <td height="26">C</td>
                 <td>公务舱</td>
               </tr>
               <tr>
                <td height="26">Y</td>
                <td>100</td>
               </tr>
               <tr>
                <td height="26">B</td>
                <td>90</td>
                <td rowspan="4">收取票面价10%的退票费</td>
               </tr>
               <tr>
                <td height="26">H</td>
                <td>85</td>
               </tr>
               <tr>
                <td height="26">K</td>
                <td>80</td>
               </tr>
               <tr>
                <td height="26">L</td>
                <td>75</td>
               </tr>
               <tr>
                <td height="26">M</td>
                <td>70</td>
                <td rowspan="5">收取票面价20%的退票费</td>
                <td rowspan="5">每次变更收取票面10%的变更费</td>
               </tr>
               <tr>
                 <td height="26">M1</td>
                 <td>65</td>
               </tr>
               <tr>
                <td height="26">Q</td>
                <td>60</td>
               </tr>
               <tr>
                 <td height="26">Q1</td>
                 <td>55</td>
               </tr>
               <tr>
                <td height="26">X</td>
                <td>50</td>
               </tr>
               <tr>
                <td height="26">U</td>
                <td>45</td>
                <td rowspan="2">收取票面价50%的退票费</td>
                <td rowspan="2">每次变更收取面票20%的变更费</td>
               </tr>
               <tr>
                <td height="26">E</td>
                <td>40</td>
               </tr>
               
               <tr>
                 <td>Z</td>
                 <td>特价舱</td>
                 <td colspan="2" rowspan="4">按产品及特价销售政策执行</td>
               </tr>
               <tr>
                <td>V</td>
                <td>中转联程</td>
               </tr>
               <tr>
                 <td>J</td>
                 <td>优去优回</td>
               </tr>
               <tr>
                <td>I</td>
                <td>提前购票</td>
               </tr>
               <tr>
                 <td><span class="STYLE2">团队票退票：</span></td>
                 <td colspan="3">1、团体旅客自愿退票在航班规定离站时间72小时（含）以前，收取客票价10%的退票费；在航班规定离站时间72小时以内至规定离站时间前一天中午12：00（含）以前，收取客票价30%的退票费；在航班规定离站时间前一天中午12：00点至航班规定截载时间以前，收取客票价50%的退票费；在航班规定截载时间以后，客票作废，票款不退。<br />团体部分成员自愿退票 <br />
2、部分团体旅客自愿退票： <br />
部分团体旅客自愿要求退票，除客票附有限制条件者外，按下列规定办理：<br />
⑴如乘机的旅客人数不少于该票价规定的最低成团人数时，分别按以下规定处理：<br />
1）单程团及全部未使用的来回程、联程、缺口程团队退票按"团体旅客自愿退票"规定办理；<br />
2）需部分使用的来回程、联程、缺口程团队票（即来回程、联程、缺口程退单程的情况），应将团体旅客原付折扣票价总金额扣除该团体已使用（或需使用）航段的单程团票款后，再按"团体旅客自愿退票"规定向需退票的团体旅客收取需退票航段的退票费，差额多退少不补。<br />
⑵如乘机的旅客人数少于该票价规定的最低成团人数时，分别按下列规定办理:<br />
1）如客票全部未使用，应按团体旅客原折扣票价总金额扣除乘机旅客按退票时航班开放的最低散客舱位票价计算的票款总金额后，再扣除"团体旅客自愿退票"规定的退票费，差额多退少不补。 <br />
2）如客票部分未使用，应将团体旅客原付折扣票价总金额扣除该团体已使用（或需使用）航段的单程团票款后，再扣除乘机旅客按退票时航班开放的最低散客舱位票价计算的未使用航段票款总金额及"团体旅客自愿退票"规定的退票费，差额多退少不补。</td>
               </tr>
               <tr>
                <td align="center"><strong >海航客服电话</strong></td>
                <td align="center" colspan="4"><strong >8008768999  950718</strong></td>
               </tr>
               <tr>
                <td align="center"><strong >祥鹏客服电话</strong></td>
                <td align="center" colspan="4"><strong >4008899737</strong></td>
               </tr>
               <tr>
                <td align="center"><strong >大新华客服电话</strong></td>
                <td align="center" colspan="4"><strong >022-24903700</strong></td>
               </tr>
               <tr>
                <td align="center"><strong >西部客服电话</strong></td>
                <td align="center" colspan="4"><strong >95071095   （023)67152108</strong></td>
               </tr>
          </table>
</div>
<!--成都航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
成都航空:<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span> 
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
              <tr class="tr_bg">
                <td width="10%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="10%" align="center" ><strong>舱位</strong></td>
                <td width="10%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="25%" align="center" ><strong>变更</strong></td>
				  </tr>
              <tr>
                <td align="center" rowspan="18"><strong >成都航空</strong><br />
                本客规适用于2010年1月23号出票日起执行</td>
                <td>T</td>
                <td>90</td>
                <td rowspan="2">收票面的5%</td>
                <td rowspan="2">免费改期</td>
               
             </tr>
             <tr>
                <td>H</td>
                <td>80</td>
             </tr>
             <tr>
                <td>M</td>
                <td>75</td>
                <td rowspan="4">收票面的10%</td>
                <td rowspan="4">每次更改收取票面价10%改期费</td>
             </tr>
             <tr>
                <td>G</td>
                <td>70</td>
             </tr>
             <tr>
                <td>S</td>
                <td>65</td>
             </tr>
             <tr>
                <td>L</td>
                <td>60</td>
             </tr>
             <tr>
                <td>Q</td>
                <td>55</td>
                <td rowspan="4">收票面的30%</td>
                <td rowspan="4">每次更改收取票面价20%改期费</td>
             </tr>
             <tr>
                <td>E</td>
                <td>50</td>
             </tr>
             <tr>
                <td>V</td>
                <td>45</td>
             </tr>
             <tr>
                <td>R</td>
                <td>40</td>
             </tr>
             <tr>
                <td>F/C/Y儿童(正常儿童票)</td>
                <td></td>
                <td>免收退票费</td>
                <td>免费改期</td>
             </tr>
             <tr>
                <td>K/I</td>
                <td></td>
                <td>退机建费和燃油费，机票款不退</td>
                <td>不得自愿改期、升舱</td>
             </tr>
             <tr>
                <td>A/J/Y</td>
                <td></td>
                <td>收票面的5%</td>
                <td>免费改期</td>
             </tr>
             <tr>
                <td rowspan="2">特价:N/D/Z </td>
                <td></td>
                <td>若3折(含)以上,按照该客票类别所对应的规定执行</td>
                <td>若3折(含)以上,按照该客票类别所对应的规定执行</td>
             </tr>
             <tr>
                <td></td>
                <td>若3折以下,实际订座舱位字母代码为YN，YZ，YD时,仅退机建费和燃油</td>
                <td>若3折以下,实际订座舱位字母代码为YN，YZ，YD时,不得自愿改期、升舱</td>
             </tr>
             <tr>
                <td>往返W舱</td>
                <td></td>
                <td>
                    限在原出票地办理，不得单退第一航段；也不得在前面航段未使用的情况下、单退后面任意航段。否则按全程自愿退票处理。<br /> 
                    ⑴客票全部未使用：第一航段起飞前退票按实收价的30%计收退票费，第一航段起飞后退票按实收价的50%计收退票费。<br /> 
                    ⑵客票已部分使用：按实收总票价扣减已使用各航段分别的Y舱公布标准运价后，如有余额则按该余额的30%计收退票费,剩余金额退还旅客；如未有余额则不补不退
                </td>
                <td>
                    1、改期：在未使用航段航班对应的相同舱位开放的前提下，可为旅客对航班单独或同时办理自愿改期。<br />
                    ⑴每次改期应按对应开放舱位重新订座，重新计算票价，补齐差额（如新票价低于原价格则差价不退），或按产品实收总价的20%收取改期费。改期费与补差费同时发生时,按较高者收取一项。<br />
                    ⑵改期仅限在川航直属售票处或川航指定代理人处办理，且所变更航班前后的时间间隔皆不得超过72小时。<br />
                    2、变更：不得自愿变更。
                </td>
             </tr>
             <tr>
                <td>1.来回程及多航段客票的退票</td>
                <td></td>
                <td>
                    【1】客票全部未使用时,按照单程的退票规则分别计收各段的退票手续费；若客票已部分使用提出申退,扣除已使用航段的舱位运价后,剩余航段按照单程的退票规则分别计收各段的退票手续费。
                </td>
                <td>
                    【2】. 变更后的客票如旅客要求退票，应按首次购票的客票舱位、票价及退票规定计算退票费，将最后一次客票的舱位价格扣除该退票费后的余额退还旅客，已收取的改期费不退。
                </td>
             </tr>
             <tr>
                <td>2. 团队退票:</td>
                <td></td>
                <td>
                    【1】客票全部未使用情况下,在航班规定离站时间前72小时(不含)之前提出退票收取票面价20%；离站时间前72小时(含)至航班规定离站时间 (不含)以前提出退票,收取票面价50% 的退票费；航班规定离站时间 (含)及之后提出退票,仅退机建费和燃油费,客票款不退。
                    【2】部分使用情况下提出退票,需扣除已使用航段的Y舱全价,剩余未使用航段客票在扣除已使用航段的Y舱全价后如没有剩余金额,则不予退票；如有剩余金额，未使用航段客票退票则参照团队客票全部未使用的规定予以退票。
                    【3】团体部分旅客自愿要求退票,如果旅客退票后造成剩余旅客不成团,则剩余旅客各航段需全部补齐Y舱全价后方予成行,否则全体团队旅客做自愿退票处理。
                </td>
                <td></td>
             </tr>
             <tr>
                <td align="center"><strong >成都航空</strong></td>
                <td align="center" colspan="4"><strong >028-66668888
</strong></td>
               </tr>
          </table> 
</div>
<!--吉祥航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
吉祥航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机</span> 
<TABLE class=tablez border=0 cellSpacing=1 cellPadding=0 width="100%"><!--DWLayoutTable-->
<TBODY>
<TR class=tr_bg>
<TD rowSpan=25 width="15%" align=center><strong >吉祥 
HO</STRONG><BR>自2011年9月16日起执行</TD>
<TD width="10%" align=middle><STRONG>舱位</STRONG></TD>
<TD width="10%" align=middle><STRONG>折扣</STRONG></TD>
<TD width=193 align=middle><STRONG>改签（不得低于50元）</STRONG></TD>
<TD width=193 align=middle><STRONG>退票（不得低于50元）</STRONG></TD>
</TR>
<TR>
<TD width="10%">F</TD>
<TD width="10%">150%</TD>
<TD rowSpan=7>免费变更</TD>
<TD rowSpan=3>收取票面的5%退票手续费</TD>
</TR>
<TR>
<TD>A</TD>
<TD>头等舱子舱位</TD></TR>
<TR>
<TD>Y</TD>
<TD>100%</TD></TR>
<TR>
<TD>F/A/Y的儿童票</TD>
<TD>50%</TD>
<TD rowSpan=2>免收退票手续费</TD></TR>
<TR>
<TD>F/A/Y的婴儿票</TD>
<TD>10%</TD></TR>
<TR>
<TD>B</TD>
<TD>92%</TD>
<TD rowSpan=2>收取票面的10%退票手续费</TD></TR>
<TR>
<TD>L</TD>
<TD>84%</TD></TR>
<TR>
<TD>M</TD>
<TD>80%</TD>
<TD rowSpan=4>免费更改一次，再改收取5%</TD>
<TD rowSpan=5>收取票面的20%退票手续费</TD></TR>
<TR>
<TD>T</TD>
<TD>76%</TD></TR>
<TR>
<TD>E</TD>
<TD>72%</TD></TR>
<TR>
<TD>H</TD>
<TD>68%</TD></TR>
<TR>
<TD>V</TD>
<TD>60%</TD>
<TD rowSpan=3>免费更改一次，再改收取10%</TD></TR>
<TR>
<TD>K</TD>
<TD>56%</TD>
<TD rowSpan=4>收取票面的50%退票手续费</TD></TR>
<TR>
<TD>W</TD>
<TD>50%</TD></TR>
<TR>
<TD>R</TD>
<TD>44%</TD>
<TD rowSpan=2>不得签转更改</TD></TR>
<TR>
<TD width="10%">Q</TD>
<TD width="10%">40%</TD></TR>
<TR>
<TD width="10%">P</TD>
<TD width="10%">30%</TD>
<TD rowSpan=2 colSpan=2>不签不改不退</TD></TR>
<TR>
<TD width="10%">S</TD>
<TD width="10%">20%</TD></TR>
<TR>
<TD>X</TD>
<TD><!--DWLayoutEmptyCell-->&nbsp;</TD>
<TD>不得更改，不得升舱</TD>
<TD>起飞前收50%,起飞后不退</TD></TR>
<TR>
<TD width="10%">N</TD>
<TD width="10%">经济舱免票舱位</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD></TR>
<TR>
<TD width="10%">J</TD>
<TD width="10%">头等舱免票舱位</TD>
<TD>&nbsp;</TD>
<TD>&nbsp;</TD></TR>
<TR>
<TD width="10%">G</TD>
<TD width="10%">联程舱位</TD>
<TD>G舱开放的条件下，可免费更改一次</TD>
<TD>不得退票</TD></TR>
<TR>
<TD>U</TD>
<TD>经济舱自定义舱位</TD>
<TD height=60 colSpan=2>参见销售文件</TD></TR>
<TR>
<TD width="10%">I</TD>
<TD width="10%">团队票</TD>
<TD colSpan=2>参见《吉祥航空团队I舱操作规定》</TD></TR>
 <tr>
                <td align="center"><strong >吉祥航空</strong></td>
                <td align="center" colspan="4"><strong >95520  4007006000

</strong></td>
               </tr>
</TBODY></TABLE>
</div>
<!--华夏航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
华夏航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span>
<TABLE class=tablez border=0 cellSpacing=1 cellPadding=0 width="100%">
  <!--DWLayoutTable-->
  <TBODY>
    <TR class=tr_bg>
      <TD height=23 width="15%" align=middle><STRONG>航空公司</STRONG></TD>
      <TD width="15%" align=middle><STRONG>舱位</STRONG></TD>
      <TD width="15%" align=middle><STRONG>折扣</STRONG></TD>
      <TD width="40%" align=middle><STRONG>退票手续费</STRONG></TD>
      <TD width="20%" align=middle><STRONG>变更</STRONG></TD>
    </TR>
    <TR>
      <TD rowSpan=24 align=center><strong >华夏航空</strong><BR>
        规定从2011年7月5日（出票时间）起执行</TD>
      <TD>Y</TD>
      <TD>100</TD>
      <TD rowSpan=2>按照票面价5％收手续费</TD>
      <TD rowSpan=2>允许免费改签一次，再改做退票处理。<BR>
        <BR>
        允许签转。</TD>
    </TR>
    <TR>
      <TD>儿童（Y）</TD>
      <TD>YCH50</TD>
    </TR>
    <TR>
      <TD>P</TD>
      <TD>96</TD>
      <TD rowSpan=4>按照票面价10％收手续费</TD>
      <TD 
rowSpan=13>不允许自愿变更，可办理升舱变更。二次变更按退票处理，升舱后退票费标准按升舱前舱位对应规定收取。<BR>
        <BR>
        不允许自愿签转。</TD>
    </TR>
    <TR>
      <TD>T</TD>
      <TD>92</TD>
    </TR>
    <TR>
      <TD>K</TD>
      <TD>88</TD>
    </TR>
    <TR>
      <TD>H</TD>
      <TD>84</TD>
    </TR>
    <TR>
      <TD>M</TD>
      <TD>80</TD>
      <TD rowSpan=3>按照票面价20％收手续费</TD>
    </TR>
    <TR>
      <TD>G</TD>
      <TD>76</TD>
    </TR>
    <TR>
      <TD>S</TD>
      <TD>72</TD>
    </TR>
    <TR>
      <TD>L</TD>
      <TD>68</TD>
      <TD rowSpan=3>按照票面价30％收手续费</TD>
    </TR>
    <TR>
      <TD>Q</TD>
      <TD>64</TD>
    </TR>
    <TR>
      <TD>E</TD>
      <TD>60</TD>
    </TR>
    <TR>
      <TD>V</TD>
      <TD>56</TD>
      <TD rowSpan=3>按照票面价50％收手续费</TD>
    </TR>
    <TR>
      <TD>R</TD>
      <TD>50</TD>
    </TR>
    <TR>
      <TD>O</TD>
      <TD>45</TD>
    </TR>
    <TR>
      <TD>U</TD>
      <TD>40</TD>
      <TD rowSpan=3>不得自愿退票</TD>
      <TD rowSpan=3>不允许自愿签转/变更</TD>
    </TR>
    <TR>
      <TD>Z</TD>
      <TD>35</TD>
    </TR>
    <TR>
      <TD>X</TD>
      <TD>30</TD>
    </TR>
    <TR>
      <TD>无人陪伴儿童(R)</TD>
      <TD>YCH50</TD>
      <TD>按照票面价5%计收手续费</TD>
      <TD>允许签转,不允许自愿变更</TD>
    </TR>
    <TR>
      <TD>婴儿(Y)</TD>
      <TD>YIN10</TD>
      <TD>免收退票费</TD>
      <TD>允许签转,免费变更</TD>
    </TR>
    <TR>
      <TD>军残(R)</TD>
      <TD>YGM50</TD>
      <TD rowSpan=2>航班规定离站时间前退票，收取票面价20%作为退票手续费；在航班规定离站时间以后退票，收取票面价50%作为退票手续费。 </TD>
      <TD rowSpan=2>允许签转,不允许自愿变更</TD>
    </TR>
    <TR>
      <TD>警残(R)</TD>
      <TD>YJC50</TD>
    </TR>
    <TR>
      <TD>团队 （不含中转联程团队）明折明扣对应舱位</TD>
      <TD>YGXX(团队折扣)</TD>
      <TD>1．在航班规定离站时间72小时(含)前，收取客票价50%的退票费。 <BR>
        2．在航班规定离站时间72小时内至24小时以前，收取客票价80%的退票费。 <BR>
        3．在航班规定离站时间24小时内，客票作废票款不退。<BR>
        4. 
        联程、来回程客票的团队旅客要求退票，分别按第1、2、3条规定收取各航段的退票费。</TD>
      <TD rowSpan=2>不允许自愿签转/变更</TD>
    </TR>
    <TR>
      <TD>中转联程(W)</TD>
      <TD>中转散客:YW<BR>
        中转团队:YWG</TD>
      <TD>1.如使用了第一航程航段，则不允许旅客自愿退票。<BR>
2.全程未使用退票：航班离站前24小时以外按照票面价20%计收手续费，航班离站前24小时以内按照票面价50%计收手续费，航班离站按照票面价80%计收手续费。 <BR>
        3.如有另行规定，以中转联程运价通告为准。<BR>
        4.中转团队不允许退票。</TD>
    </TR>
    <TR>
      <TD align=center><strong >华夏航空客服</strong></TD>
      <TD colSpan=4 
align=center><strong >（0851）5499660</STRONG></TD>
    </TR>
  </TBODY>
</TABLE>
</div>
<!--奥凯航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
奥凯航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张,废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span> 
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <!--DWLayoutTable-->
               <tr class="tr_bg">
                <td width="20%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="20%" align="center" ><strong>舱位</strong></td>
                <td width="20%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				 </tr>
               <tr>
                 <td rowspan="20" align="center"><strong >奥凯BK</strong><br />本规定适用于出票日期为2010年3月28日（含）以后、乘机日期为2010年3月28日（含）以后的客票</td>
                 <td>F</td>
                 <td>150</td>
                 <td rowspan="3">收取票面价5%的退票费</td>
                 <td rowspan="3">免费签转变更</td>
                 </tr>
               <tr>
                 <td>C</td>
                 <td>130</td>
               </tr>
               <tr>
                <td>Y</td>
                <td>100</td>
               </tr>
               <tr>
                <td>儿童</td>
                <td>50</td>
                <td>收取票面价5%的退票费</td>

                <td>不得签转变更</td>
               </tr>
               <tr>
                <td>B</td>
                <td>90</td>
                <td rowspan="3">收取票面价10%的退票费</td>
                <td rowspan="4">（不得签转）航班起飞前可免费变更2次，再次变更收5%；起飞后每次变更收5%</td>
               </tr>
               <tr>
                <td>H</td>
                <td>85</td>
               </tr>
               <tr>
                <td>K</td>
                <td>80</td>
               </tr>
               <tr>
                <td>M</td>
                <td>75</td>
                <td rowspan="5">收取票面价20%的退票费</td>
               </tr>
               <tr>
                <td>L</td>
                <td>70</td>
                <td rowspan="7">（不得签转）航班起飞前可免费变更一次，再次变更收取5%，起飞后每次变更收取5%</td>
               </tr>
               <tr>
                 <td>N</td>
                 <td>65</td>
               </tr>
               <tr>
                <td>Q</td>
                <td>60</td>
               </tr>
               <tr>
                <td>X</td>
                <td>55</td>
               </tr>
               <tr>
                <td>E</td>
                <td>50</td>
                <td rowspan="3">收取票面价50%的退票费</td>
               </tr>
               <tr>
                <td>U</td>
                <td>45</td>
               </tr>
               <tr>
                 <td>T</td>
                 <td>40</td>
               </tr>
               <tr>
                 <td>O</td>
                 <td>30</td>
                 <td>不得自愿退票</td>
                 <td>不得签转变更</td>
               </tr>
               <tr>
                <td rowspan="2">Z/J/W/D特价/中转北京）</td>
                <td valign="top">4折(含)以上</td>
                <td valign="top">按照相应舱位折扣退票</td>
                <td valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
               </tr>
               <tr>
                 <td>4折以下</td>
                 <td colspan="2" valign="top">不签不改不退</td>
               </tr>
               
               <tr>
                <td>1</td>
                <td>中转联程</td>
                <td>中转联程折扣比例=票面价/旅程各段全价之和，4折含以上按照相应折扣舱位规定退票；4折以下无论何时提出退票只退机建和燃油费</td>
                <td>&nbsp;</td>
               </tr>
               <tr>
                <td height="">团队票：</td>
                <td colspan="3" valign="top">4折（含）以上，按相应舱位客规办理；4折以下不论起飞前后提交都只退基建燃油费</td>
            </tr>
               
               <tr>
                <td align="center"><strong >奥凯客服电话</strong></td>
                <td colspan="4" align="center"><strong >022-24903464  &nbsp;&nbsp;&nbsp;022-23233399</strong></td>
               </tr>
          </table>
</div>
<!--河北航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
河北航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span> 
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="15%" align="center" ><strong>航空公司</strong></td>
                <td width="10%" align="center" ><strong>舱位</strong></td>
                <td width="10%" align="center" ><strong>折扣</strong></td>
                <td width="15%" align="center"><strong>未办理值机退票</strong></td>
                <td width="15%" align="center" ><strong>已办理值机退票</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				 </tr>
            <tr>
                <td align="center" rowspan="21"><strong >河北航空</strong><BR />本规定自2010年08月01日开始出票、以2010年08月01日旅行起执行</td>
                <td>F</td>
                <td>150%</td>
                <td rowspan="3">免收退票费</td>
                <td rowspan="3">收票面的5%</td>
                <td rowspan="6" >免费改期</td>
                </tr>
            <tr>
                <td>A</td>
                <td>130%</td>
            </tr>
            <tr>
                <td>C</td>
                <td>130%</td>
            </tr>
            
            <tr>
                <td>Y</td>
                <td>100%</td>
                <td rowspan="3">收票面的5%</td>
            <td rowspan="3">收取票面的10%</td>
            </tr>
            <tr>
                <td>T</td>
                <td>90%</td>
            </tr>
            <tr>
                <td>H</td>
                <td>80%</td>
            </tr>
            <tr>
                <td>M</td>
                <td>75%</td>
                <td rowspan="4">收取票面的10%</td>
                <td rowspan="4">收取票面的10%</td>
                <td rowspan="4" >每次改期收取票面价10%的改期费</td>
            </tr>
            <tr>
                <td>G</td>
                <td>70%</td>
            </tr>
            <tr>
                <td>S</td>
                <td>65%</td>
            </tr>
            <tr>
                <td>L</td>
                <td>60%</td>
            </tr>
            <tr>
                <td>Q</td>
                <td>55%</td>
                <td rowspan="4">收取票面价的30%</td>
                <td rowspan="4">收取票面价的30%</td>
                <td rowspan="4">每次改期收取票面价20%的改期费</td>
            </tr>
            <tr>
                <td>E</td>
                <td>50%</td>
            </tr>
            <tr>
                <td>V</td>
                <td>45%</td>
            </tr>
            <tr>
                <td>R</td>
                <td>40%</td>
            </tr>
            <tr>
                <td>K</td>
                <td>35%</td>
                <td colspan="2" rowspan="2">仅退基建费和燃油费，机票款不退</td>
                <td rowspan="2">不得自愿改期、升舱</td>
            </tr>
            <tr>
                <td height="59">I</td>
                <td>30%</td>
            </tr>
            
            <tr>
              <td rowspan="2">N /Z /D</td>
            <td>3折以上</td>
              <td colspan="3">按照该客票类别所对应舱位规定执行</td>
            </tr>
            <tr>
              <td>3折以下</td>
              <td colspan="2">仅退机建费和燃油费，机票款不退</td>
              <td>不得自愿改期、升舱</td>
            </tr>
            <tr>
              <td>W</td>
              <td>往返舱</td>
              <td colspan="2">不得单独退某一航段，不得单退去程或回程。在第一航段航班规定停止办理登机手续时间前退票，按实收价的30%计收退票费，在第一航段航班规定停止办理登机手续后退票，按实收价的50%计收退票费。不允许升舱。</td>
              <td>在未使用航段航班对应的相同舱位开放的前提下，可为旅客对航班单独或同时办理自愿改期。任一航程的航班变更需要在航班规定停止办理登机手续时间前提出,并在航班有同等舱位条件下，可以免费改期一次，且所变更航班前后的时间间隔皆不得超过30天。不得再次变更</td>
            </tr>
            <tr>
              <td>B</td>
              <td>中转联程</td>
              <td colspan="2">A、必须全程退票，不得单独退某一航段。<br />
              B、在第一航段航班规定停止办理登机手续时间前退票，按实收价的30%计收退票费，在第一航段航班规定停止办理登机手续后退票，按实收价的50%计收退票费。</td>
              <td>在未使用航段航班对应的相同舱位开放的前提下，可为旅客对航班单独或同时办理自愿改期。任一航程的航班变更需要在航班规定停止办理登机手续时间前提出,并在航班有同等舱位条件下，可以免费改期一次，且所变更航班前后的时间间隔皆不得超过72小时。不得再次变更</td>
            </tr>
            <tr>
              <td>团队票</td>
            <td colspan="4">1. 团队客票全部未使用情况下,在航班规定离站时间72小时（含）以前退票，收取客票价10%的退票费；在航班规定离站时间前72小时以内至航班规定离站时间前一日中午12时（含）以前退票，收取客票价30%的退票费；在航班规定离站时间前一日中午12时以后至航班规定离站时间以前退票，收取客票价50%的退票费；航班规定离站时间 (含)及之后提出退票,仅退机建费和燃油费,客票款不退；四折（含）以上的团队客票须用EI指令注明"不得签转更改/GV+人数"。<br />
              2.团队客票部分使用情况下提出退票,需扣除已使用航段的Y舱全价,剩余未使用航段客票在扣除已使用航段的Y舱全价后如没有剩余金额,则不予退票；如有剩余金额，未使用航段客票退票则参照团队客票全部未使用的规定予以退票。 <br />
              3.团体部分旅客自愿要求退票,参照以上团体旅客退票规定执行。如果旅客退票后造成剩余旅客不成团,则剩余旅客各航段需全部补齐Y舱全价后方予成行,否则全体团队旅客做自愿退票处理。<br />
              4.团体旅客自愿退票仅限四折（含）以上的团队，若团队票价低于四折，则不得签转更改退票。</td>
            </tr>
            <tr>
                <td align="center"><strong >河北航空客服电话</strong></td>
                <td colspan="5" align="center"><strong >024-88298321</strong></td>
            </tr>
          </table>

</div>
<!--中联航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
中联航空：<br />
<strong >废票规定：</strong>航班起飞当天销售的客票不允许作废<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span> 
  <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="15%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="15%" align="center" ><strong>舱位</strong></td>
                <td width="15%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				</tr>
            <tr>
              <td rowspan="21" align="center"><strong >中联航空</strong><br />航班日期2010年08月15日、销售日期2010年08月11日起执行</td>
              <td>F/FCH</td>
              <td>150</td>
              <td rowspan="2">免费退票</td>
              <td rowspan="5">允许变更、签转</td>
              </tr>
            <tr>
              <td>C/CCH</td>
              <td>130</td>
            </tr>
            
            <tr>
              <td>儿童YCH</td>
              <td>50</td>
              <td rowspan="3">免费退票</td>
            </tr>
            <tr>
                <td>婴儿YIN</td>
                <td>10</td>
            </tr>
            <tr>
                <td>Y</td>
                <td>100</td>
            </tr>
            <tr>
                <td>B</td>
                <td>90</td>
                <td rowspan="3">收取票面价5%的退票费，不得低于50元</td>
            <td rowspan="8">在同等级舱位开放的情况下，允许免费变更</td>
            </tr>
            <tr>
                <td>E</td>
                <td>85</td>
            </tr>
            <tr>
                <td>H</td>
                <td>80</td>
            </tr>
            <tr>
                <td>L</td>
                <td>75</td>
                <td rowspan="3">收取票面价10%的退票费，不得低于50元</td>
            </tr>
            <tr>
                <td>M</td>
                <td>70</td>
            </tr>
            <tr>
                <td>N</td>
                <td>65</td>
            </tr>
            <tr>
                <td>R</td>
                <td>60</td>
                <td rowspan="2">收取票面价20%的退票费，不得低于50元</td>
            </tr>
            <tr>
                <td>S</td>
                <td>55</td>
            </tr>
            <tr>
                <td>V</td>
                <td>50</td>
                <td rowspan="3">收取票面价的50%的退票费，不得低于50元</td>
                <td rowspan="3">收取经济舱全票价5%的变更费，变更费不得低于人民币50元整。</td>
            </tr>
            <tr>
                <td>T</td>
                <td>45</td>
            </tr>
            <tr>
                <td>W</td>
                <td><!--DWLayoutEmptyCell-->&nbsp;</td>
            </tr>
            <tr>
              <td>X</td>
              <td><!--DWLayoutEmptyCell-->&nbsp;</td>
              <td>收取票面价的80%的退票费，不得低于50元</td>
              <td>不得改期</td>
            </tr>
            
            <tr>
              <td>Q</td>
              <td>中转联程专用舱</td>
              <td>客票全部未使用：按票面价30%收取退票手续费，余额退还旅客。客票已部队使用不得退票。退票时限以中转联程航班第一航段的始发时间为准</td>
              <td>全部未使用时变更，每次每段收取100元变更费。若变更时运价出现差额请参见业务通告补齐差额，高补低不退。客票已部分使用不得变更。</td>
            </tr>
            <tr>
              <td>E</td>
              <td>往返程专用舱</td>
              <td>客票全部未使用按票面价30%收取退票手续费，客票已部分使用不得退票。</td>
              <td>如需变更，每次每段收取100元变更费。若变更时运价出现差额，请参见业务通告补齐差额或升至B舱（含）以上舱位，高补低不退。</td>
            </tr>
            <tr>
              <td>通用中转、通用往返产品(优惠价格的舱位：B-T)2010年11月1日开始</td>
              <td>90%-45%</td>
              <td>A、客票全部未使用：按票面价30％收取退票手续费，余额退还旅客。退票时限以中转联程航班第一航段的始发时间为准；<br />
                B、客票已部分使用：按票面价减已使用航段订座舱位明折明扣价格，再将此余额扣除退票费后退还旅客。<br />
                C、未按顺序使用乘机联的客票不予以退票；<br />
              D、通用中转产品销售分摊价在45折以下的产品，不得签转，不得变更，不得退票，不得升舱。</td>
              <td>A、旅客提出更改承运人或部分航程，整个产品按自愿退票处理；<br />

                B、旅客提出变更日期在有对应舱位的情况下允许免费更改一次，后续每变更一次均须按原客票全航程票面价收取20%的变更手续费；若无对应舱位按升舱处理；如变更航程按自愿退票办理。<br />
                C、如客票被跳程使用，该客票运输无效，不予接受任何变更请求，按自愿退票处理。</td>
            </tr>
            <tr>
              <td height="" colspan="4" valign="top"><font color="#FF0000">团队票退票：</font><br />
			  凡10人以上的团队旅客购票后自愿退票，按下列规定收取退票费：<br />
    1）在航班规定离站时间72小时以前退票，收取票价10%的退票费。<br />
    2）在航班规定离站时间72小时至规定离站时间前一天中午12点前退票，收取票价30%的退票费。<br />
    3）在航班规定离站时间前一天中午12点以后至航班规定离站时间前退票，收取票价50%的退票费。<br />
    4）在航班规定离站时间以后提出退票，客票作废，票款不退。
			  </td>
            </tr>
            
            <tr>
                <td align="center"><strong >中联航空客服电话</strong></td>
                <td colspan="4" align="center"><strong >400-610-0099    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;800-810-0099</strong></td>
            </tr>
          </table>
</div>
<!--首都航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
首都航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张,编码里有多个人的订单，不能分开提交废票申请，<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>

<strong >升舱规定：</strong>建议补差升舱，如需帮助请联系客服021-62515000转811
分机
</span> 
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="15%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="15%" align="center" ><strong>舱位</strong></td>
                <td width="15%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				  </tr>
            
            
            <tr>
              <td align="center" rowspan="16"><strong >首都航空</strong><br />
           2011年3月28日出票起执行</td>
                <td height="26">Y</td>
                <td>100</td>
                <td rowspan="2">收取票面价5%的退票费</td>
                <td rowspan="6">航班离站前后免费变更</td>
                </tr>
            <tr>
                <td height="26">儿童</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td height="26">B</td>
                <td>90</td>
                <td rowspan="4">收取票面价10%的退票费</td>
            </tr>
            <tr>
                <td height="26">H</td>
                <td>85</td>
            </tr>
            <tr>
                <td height="26">K</td>
                <td>80</td>
            </tr>
            <tr>
                <td height="26">L</td>
                <td>75</td>
            </tr>
            <tr>
                <td height="26">M</td>
                <td>70</td>
                <td rowspan="5">收取票面价20%的退票费</td>
                <td rowspan="5">每次变更收取票面价10%变更费</td>
            </tr>
            <tr>
                <td height="26">M1</td>
                <td>65</td>
            </tr>
            <tr>
                <td height="26">Q</td>
                <td>60</td>
            </tr>
            <tr>
              <td height="26">Q1</td>
              <td>55</td>
            </tr>
            <tr>
                <td height="26">X</td>
                <td>50</td>
            </tr>
            <tr>
              <td height="26">U</td>
              <td>45</td>
              <td rowspan="2">收取票面价50%的退票费</td>
              <td rowspan="2">每次变更收取票面价20%变更费</td>
            </tr>
            <tr>
              <td height="26">E</td>
              <td>40</td>
            </tr>
            
            <tr>
              <td height="26">N/T/Z</td>
            <td>折扣率不定</td>
              <td>按对应折扣收取退票费</td>
              <td>任何时候不允许同舱改期，升舱升至明折明扣（E-Y）且等于或高于原定舱位</td>
            </tr>
            <tr>
              <td height="26">J</td>
            <td>往返无忧专用舱</td>
              <td>1.办理退票时按旅客提出航段票面价的50%收取退票费并退还机场建设费和燃油附加费；<br />
              2.升舱后退票,退还升舱前后的舱位差价后按原付票款收取50%的退票费；降舱后退票按原付票款收取50%的退票费；<br /></td>
              <td>1.离站前后旅客均可以提出任意航段的自愿变更。 <br />
              2.同舱位同价格可免费多次变更，同舱位不同价格变更或无同折扣舱位情况下变更舱位，则根据当时开放舱位对应价格升舱补差</td>
            </tr>
            <tr>
              <td height="26">V/R</td>
            <td>中转专用舱</td>
              <td>1 客票全部未使用：在第一段航班起飞前按整体票面金额的20%收取退票手续费；在第一段航班起飞后按整体票面金额的50%收取退票费；<br />
			  2 客票已部分使用：在未使用客票的第一段航班起飞前，用整体航程的票面价扣除已使用航段的单程销售价(若无中转联程单程销售价时，扣除Y 舱全票价)，并收取剩余票款金额的20%退票手续费后，余款退还旅客；在未使用客票的第一段航班起飞后， 用整体航程的票面价扣除已使用航段的Y 舱全票价，并收取剩余票款金额50%的退票费后，余款退还旅客。（余额为0 或负数则不得退票）</td>
              <td>1. 中转专用舱客票全部未使用时：旅客提出变更，在航班有相同舱位、相同价格的情况下可免费变更,仅有相同舱位但价格不同时，应补齐票款差额，原则为：差额多不退少补；<br />2.中转专用舱客票已部分使用时：旅客提出变更，客票失效部分只算到中转站，有效部分按客票票面列明的订座舱位对应的变更规定办理。</td>
            </tr>
            <tr>
                <td align="center"><strong >首都航空客服电话</strong></td>
                <td colspan="4" align="center"><strong >95071999</strong></td>
            </tr>
          </table>
</div>
<!--幸福航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
幸福航空：<br />
<strong >废票规定：</strong>废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机
</span> 
 <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
            <tr class="tr_bg">
                <td width="10%" height="23" align="center" ><strong>航空公司</strong></td>
                <td width="15%" align="center" ><strong>舱位</strong></td>
                <td width="15%" align="center" ><strong>折扣</strong></td>
                <td width="20%" align="center" ><strong>退票手续费</strong></td>
                <td width="20%" align="center" ><strong>变更</strong></td>
				</tr>
            <tr>
                <td rowspan="11" align="center"><strong >幸福航空</strong><br>
自2009年10月30日15.20起销售的11月1日{含}以后的航班</td>
                <td>Y{YCH}</td>
                <td></td>
                <td>收取票面价5%的退票费</td>
                <td rowspan="5">允许变更</td>
                </tr>
            <tr>
                <td>B</td>
                <td>90</td>
                <td rowspan="4">收取票面价10%的退票费</td>
            </tr>
            <tr>
                <td>H</td>
                <td>80</td>
            </tr>
            <tr>
                <td>L</td>
                <td>75</td>
            </tr>
            <tr>
                <td>M</td>
                <td>70</td>
            </tr>
            <tr>
                <td>N</td>
                <td>65</td>
                <td rowspan="3">收取票面价20%的退票费</td>
                <td rowspan="3">每次改期收取票面价10%的改期费</td>
            </tr>
            <tr>
                <td>R</td>
                <td>60</td>
            </tr>
            <tr>
                <td>S</td>
                <td>55</td>
            </tr>
            <tr>
                <td>V</td>
                <td>50</td>
                <td rowspan="3">收取票面价50%的退票费</td>
                <td rowspan="3">每次改期收取票面价20%的改期费</td>
            </tr>
            <tr>
                <td>T</td>
                <td>45</td>
            </tr>
            <tr>
                <td>W</td>
                <td>40</td>
            </tr>
             <tr>
                <td align="center"><strong >幸福航空</strong></td>
                <td align="center" colspan="4"><strong >4008680000

</strong></td>
               </tr>
         </table>
        </div>
<!--幸福航空-->
<div class="TabbedPanelsContent">
<span class="wenzi"> 
西藏航空：<br />
<strong >废票规定：</strong>废票请在供应商营业时间内，航班起飞前2小时10分钟提交<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。


</span> 
           <table width="100%" border="0" cellpadding="0" cellspacing="1" class="tablez">
               <!--DWLayoutTable-->
            <tr class="tr_bg">
                <td width="10%" align="center" rowspan="20"><strong >西藏航空TV</strong><br>
                2011年8月1日出票起开始执行</td>
                <td width="10%" height="26" rowspan="2" align="center" ><strong>舱位</strong></td>
                <td width="10%" rowspan="2" align="center" ><strong>折扣</strong></td>
              <td colspan="2"align="center" width="20%"><strong>退票手续费</strong></td>
                <td width="20%" colspan="2" align="center" ><strong>变更费（每次）</strong></td>
				
              </tr>
            <tr class="tr_bg">
              <td width="10%" align="center"><font color="#FF0000">航班起飞前2小时之前取消定座</font></td>
              <td width="10%"align="center"><font color="#FF0000">航班起飞前2小时之内及航班起飞后取消定座</font></td>
              <td width="10%" align="center" ><font color="#FF0000">航班起飞前2小时之前取消定座</font></td>
              <td width="10%" align="center" ><font color="#FF0000">航班起飞前2小时之内及航班起飞后取消定座</font></td>
            </tr>
              <tr>
                <td>F</td>
                <td>250%</td>
                <td rowspan="8" >免费</td>
                <td rowspan="8">收取10%退票费</td>
                <td rowspan="12">免费变更</td>
                <td rowspan="8">收取5%变更费</td>
              </tr>
              <tr>
                <td height="26">A</td>
                <td>220%</td>
               </tr>
              <tr>
                <td height="26">P</td>
                <td>150%</td>
               </tr>
              <tr>
                <td height="26">C</td>
                <td>200%</td>
               </tr>
              <tr>
                <td height="26">D</td>
                <td>150%</td>
               </tr>
              <tr>
                <td height="26">Z</td>
                <td>130%</td>
               </tr>
              <tr>
                <td height="26">J</td>
                <td>100%</td>
              </tr>
              <tr>
                <td height="26">Y</td>
                <td>100%</td>
               </tr>
              <tr>
                <td height="26">B</td>
                <td>90%</td>
                <td rowspan="4">收取10%退票费</td>
                <td rowspan="4">收取20%退票费</td>
                <td rowspan="4">收取10%变更费</td>
               </tr>
              <tr>
                <td height="26">M</td>
                <td>88%</td>
               </tr>
              <tr>
                <td height="26">H</td>
                <td>80%</td>
               </tr>
              <tr>
                <td height="26">K</td>
                <td>75%</td>
               </tr>
              <tr>
                <td height="26">L</td>
                <td>70%</td>
                <td rowspan="4">收取30%退票费</td>
                <td rowspan="4">收取40%退票费</td>
                <td rowspan="4">收取20%变更费</td>
                <td rowspan="4">收取30%变更费</td>
              </tr>
              <tr>
                <td height="26">Q</td>
                <td>60%</td>
               </tr>
              <tr>
                <td height="26">G</td>
                <td>50%</td>
               </tr>
              <tr>
                <td height="26">V</td>
                <td>45%</td>
               </tr>
              <tr>
                <td>儿童\婴儿</td>
                <td><!--DWLayoutEmptyCell-->&nbsp;</td>
                <td colspan="4" style="text-align:center;">免费</td>
              </tr>
              <tr>
                <td colspan="6">团队票退票规定：<br>
团体旅客自愿要求退票,按下列规定收取退票费: <br />
                  1.在航班规定离站时间72小时(含)以前,收取客票价10%的退票费. <br />
                  2.在航班规定离站时间前72小时以内至航班规定离站时间前一日中午12时(含)以前,收取客票价30%的退票费. <br />
                  3.在航班规定离站时间前一日中午12时以后至航班规定离站时间以前,收取客票价50%的退票费. <br />
                  4.在航班规定离站时间以后,客票作废,票款不退. <br />
                  5.持联程\来回程客票的团体旅客要求退票,分别按本条第1.第2或第3款的规定收取各航段的退票费. <br />
                  (二)部分团体旅客自愿退票 <br />
                  部分团体旅客自愿要求退票,除客票附有限制条件者外,按下列规定办理: <br />
                  1.如乘机的旅客人数不少于该票价规定的最低团体人数时,按&quot;团体旅客自愿退票&quot;规定办理. <br />
                2.如乘机的旅客人数少于该票价规定的最低团体人数时,分别按下列规定办理:1)如客票全部未使用,应按团体旅客原折扣票价总金额扣除乘机旅客按正常票价计算的票款总金额后,再扣除&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补;如客票部分未使用,应将团体旅客原付折扣票价总金额扣除该团体已使用航段的票款后,再扣除乘机旅客按正常票价计算的未使用航段票款总金额及&quot;团体旅客自愿退票&quot;规定的退票费,差额多退少不补. </td>
               </tr>
               <tr>
               <td colspan="1" align="center"><strong >西藏航空</strong></td>
                <td colspan="6" align="center"><strong >4008089188
</strong></td>
               </tr>
          </table>
        </div>
<div class="TabbedPanelsContent">
<span class="wenzi"> 
昆明航空：<br />
<strong >废票规定：</strong>出票当日可提交废票,废票手续费10元/张
         废票请在供应商营业时间内，航班起飞前2小时10分钟提交。<br>
<strong >升舱规定：</strong>建议直接拨打航空公司服务电话补差升舱，如需帮助请联系客服021-62515000转811分机。


</span> 
           <TABLE class=tablez border=0 cellSpacing=1 cellPadding=0 width="100%"><!--DWLayoutTable-->
<TBODY>
<TR class=tr_bg>
<TD rowSpan=16 width="15%" align=center><strong >昆明航空</strong><BR>（适用于2011年9月1日(含)以后销售,2011年9月1日(含)以后开始旅行的客票）</TD>
<TD height=26 rowSpan=2 width="7%" align=middle><STRONG>舱位</STRONG></TD>
<TD rowSpan=2 width="7%" align=middle><STRONG>折扣</STRONG></TD>
<TD colSpan=2 align=middle><STRONG>退票手续费</STRONG></TD>
<TD colSpan=2 align=middle><STRONG>变更费（每次）</STRONG></TD></TR>
<TR class=tr_bg>
<TD align=middle>航班起飞前2小时之前</TD>
<TD align=middle>航班起飞前2小时之内及航班起飞后</TD>
<TD align=middle>航班起飞前2小时之前</TD>
<TD align=middle>航班起飞前2小时之内及航班起飞后</TD></TR>
<TR>
<TD height=26>F</TD>
<TD>销售系统查询为准</TD>
<TD rowSpan=3 width="15%">免费</TD>
<TD rowSpan=3 width="14%">收取票面10%的退票费</TD>
<TD rowSpan=7 width="13%">免费</TD>
<TD rowSpan=3 width="15%">收取票面5%</TD>
</TR>
<TR>
<TD height=26>C</TD>
<TD>销售系统查询为准</TD></TR>
<TR>
<TD height=26>Y</TD>
<TD>100%</TD></TR>
<TR>
<TD height=26>B</TD>
<TD>90%</TD>
<TD rowSpan=4>收取票面10%的退票费</TD>
<TD rowSpan=4>收取票面20%退票费</TD>
<TD rowSpan=4 width="15%">收取票面10%</TD></TR>
<TR>
<TD height=26>M</TD>
<TD>85%</TD></TR>
<TR>
<TD height=26>H</TD>
<TD>80%</TD></TR>
<TR>
<TD height=26>K</TD>
<TD>75%</TD></TR>
<TR>
<TD height=26>L</TD>
<TD>70%</TD>
<TD rowSpan=6>收取票面30%的退票费</TD>
<TD rowSpan=6>收取票面40%退票费</TD>
<TD rowSpan=6>收取票面20%</TD>
<TD rowSpan=6>收取票面30%</TD></TR>
<TR>
<TD height=26>P</TD>
<TD>65%</TD></TR>
<TR>
<TD height=26>Q</TD>
<TD>60%</TD></TR>
<TR>
<TD height=26>G</TD>
<TD>50%</TD></TR>
<TR>
<TD height=26>V</TD>
<TD>45%</TD></TR>
<TR>
<TD height=26>Z</TD>
<TD>40%</TD></TR>
<TR>
<TD colSpan=2>团体旅客退票规定:</TD>
<TD colSpan=4><SPAN style="FONT-WEIGHT: normal">(一) 
团体旅客自愿退票<BR>团体旅客自愿要求退票,按下列规定收取退票费：<BR>1、 在航班规定离站时间72小时(含)以前,收取客票价10%的退票费。<BR>2、 
在航班规定离站时间前72小时以内至航班规定离站时间前一日中午12时(含)以前,收取客票价30%的退票费。<BR>3、 
在航班规定离站时间前一日中午12时以后至航班规定离站时间以前,收取客票价50%的退票费。<BR>4、 在航班规定离站时间以后,客票作废,票款不退。<BR>5、 
持联程\来回程客票的团体旅客要求退票,分别按本条第1.第2或第3款的规定收取各航段的退票费。<BR>(二) 
部分团体旅客自愿退票<BR>部分团体旅客自愿要求退票,除客票附有限制条件者外,按下列规定办理:<BR>1、如乘机的旅客人数不少于该票价规定的最低团体人数时,按"团体旅客自愿退票"规定办理。<BR>2、如乘机的旅客人数少于该票价规定的最低团体人数时,分别按下列规定办理：<BR>1) 
如客票全部未使用,应按团体旅客原折扣票价总金额扣除乘机旅客按正常票价计算的票款总金额后,再扣除"团体旅客自愿退票"规定的退票费,差额多退少不补;<BR>2) 
如客票部分未使用,应将团体旅客原付折扣票价总金额扣除该团体已使用航段的票款后,再扣除乘机旅客按正常票价计算的未使用航段票款总金额及"团体旅客自愿退票"规定的退票费,差额多退少不补。 
</SPAN></TD></TR>
<TR>
<TD align=center><strong >客服电话</strong></TD>
<TD height=26 colSpan=6 align="center"><strong >400-88-95080</strong></TD></TR></TBODY></TABLE>
        </div>		
  </div>
</div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
<br>
</div>
<!--这里放主体内容 contentcenterneirong end-->


</div>
<!--中间2层框 contentcenter end-->

</div>
<!--中间 ocontent end-->

</div>
<!--控制中部主体内容的外框 contenta  end-->

<!--尾巴 siteInfo.jsp-->


</div>
<!--控制大小的外框 width2  end-->
<!-- 
<div style="clear:both; text-align:left; margin-left:320px; margin-top:5px;">
<script language="javascript" type="text/javascript" src="http://js.users.51.la/1149909.js"></script>
</div>
 -->
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
</body>
</html>