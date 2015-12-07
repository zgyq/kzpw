function combox(_inpuObjName,_controlSelectName) 
{ 
this.inpuObjName=_inpuObjName;//生成的输入框对象名称 
this.inputbox=null;//生成的输入框对象 
this.controlSelect=document.getElementById(_controlSelectName);//原来的下拉框对象 

//初始化对象 
//_comboxObj:combox对象，须指向自己 
this.init=function(_comboxObj) 
{ 
this.inputbox=document.createElement("input"); 
this.inputbox.id=this.inpuObjName; 
this.inputbox.comboxObj=_comboxObj; 
this.inputbox.onchange=function() 
{ 
this.comboxObj.find(); 
} 
with(this.inputbox.style) 
{ 
width=this.controlSelect.offsetWidth-16; 
height=this.controlSelect.offsetHeight; 
} 
this.controlSelect.insertAdjacentElement("beforeBegin",this.inputbox); 
_span=document.createElement("span"); 
_span.style.width=18; 
this.controlSelect.insertAdjacentElement("beforeBegin",_span); 
_span.appendChild(this.controlSelect); 
_container=document.createElement("span"); 
this.inputbox.insertAdjacentElement("beforeBegin",_container); 
_container.appendChild(this.inputbox); 
_container.appendChild(_span); 
_container.style.width=this.inputbox.offsetWidth+18; 
_width=this.controlSelect.offsetWidth-18; 
with (this.controlSelect.style) 
{ 
margin="0 0 0 -"+_width; 
} 
this.controlSelect.comboxObj=_comboxObj; 
this.controlSelect.onchange=function() 
{ 
this.comboxObj.change(); 
} 
this.change(); 
} 
//当搜索到输入框的值时,下拉框自动定位/ 
this.find=function() 
{ 
with (this.controlSelect) 
{ 
for(i=0;i<options.length;i++) 
if(options[i].text.indexOf(this.inputbox.value)==0) 
{ 
selectedIndex=i; 
this.change(); 
break; 
} 
} 
} 
//定义下拉框的onchange事件 
this.change=function() 
{ 
this.inputbox.value=this.controlSelect.options[this.controlSelect.selectedIndex].text; 
with (this.inputbox) 
{ 
select(); 
focus(); 
} 
} 
} 
/** 
* 定位函数，获取控件绝对坐标 
*/ 
function getLeftPos(e) 
{ 
var left=e.offsetLeft; 
while (e=e.offsetParent) 
{ 
left+=e.offsetLeft; 
} 
return left; 
} 
function getTopPos(e) 
{ 
var top=e.offsetTop; 
while (e=e.offsetParent) 
{ 
top+=e.offsetTop; 
} 
return top; 
}　　 