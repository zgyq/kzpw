$(document).ready(function(){
	$("#teltips").mouseover(function(){
		$("#tips").show();
	});
	$("#teltips").mouseout(function(){
		$("#tips").hide();
	});		
	
});

$(function(){//alert();
		$("#easyslider").easySlider(
		{
		auto:true,
		prevId:"prevpic",
		nextId:"nextpic",
		continuous:true,
		controlsShow: false,  //是否显示左右按钮
		quantity:1 //图片个数
		}
		);
	
	});
	
var temp=0;
function show_menuC(){
		if (temp==0){
		 document.getElementById('LeftBox').style.display='none';
	  	 document.getElementById('RightBox').style.marginLeft='0';
		 document.getElementById('Mobile').style.background='url(images/right.jpg)';

		 temp=1;
		}else{
		document.getElementById('RightBox').style.marginLeft='0px';
	   	document.getElementById('LeftBox').style.display='block';
		document.getElementById('Mobile').style.background='url(images/left.jpg)';

	   temp=0;
			}
	 }
	 
function query(thisObj,Num){
if(thisObj.className == "queryA")return;
var tabObj = thisObj.parentNode.id;
var tabList = document.getElementById(tabObj).getElementsByTagName("li");
for(i=0; i <tabList.length; i++)
{
if (i == Num)
{
   thisObj.className = "queryA"; 
   document.getElementById("a0"+Num).style.display = "block";
}else{
   tabList[i].className = "queryB"; 
   document.getElementById("a0"+i).style.display = "none";
}
} 
}