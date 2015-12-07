// JavaScript Document

  var whichOpen="";
  var whichContinue='';

if(!(document.all)){
	 	HTMLElement.prototype.click = function()
		{
	       var evt = this.ownerDocument.createEvent('MouseEvents');
	       evt.initMouseEvent('click', true, true, this.ownerDocument.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
	       this.dispatchEvent(evt);
		}
 	
 }


function menuShow(obj,maxh,obj2)
{

  
  if( parseInt(obj.style.height) < maxh)
  {
    obj.style.height =(parseInt(obj.style.height) + maxh/26)+'px';
	//obj.filters.alpha.opacity+=5;
	obj2.style.background='url(imagess/bj_add.gif)';
    
	if(parseInt(obj.style.height)== maxh/13)
	{
	  obj.style.display='block';
	}
	myObj=obj;
	myMaxh=maxh;
	myObj2=obj2;
	setTimeout('menuShow(myObj,myMaxh,myObj2)','5');
  }
}



function menuHide(obj,maxh,obj2)
{
  if(parseInt(obj.style.height)>0)
  {
    if(parseInt(obj.style.height)==maxh/26)
	  obj.style.display='none';
    obj.style.height =(parseInt(obj.style.height) -maxh/26)+'px';
	//obj.filters.alpha.opacity-=5;
	obj2.style.background='url(imagess/bj_less.gif)';
	myObj=obj;
	myMaxh=maxh
	myObj2=obj2;
	setTimeout('menuHide(myObj,myMaxh,myObj2)','5');
  }
  else
    if(whichContinue)
	  whichContinue.click();
}

function menuChange(leftid,maxh,topid){
  //alert(obj.style.height + ' maxh ' +maxh + ' ' +  obj2);
  var obj=document.getElementById(leftid)
  var obj2=document.getElementById(topid)
  if(parseInt(obj.style.height)){
    menuHide(obj,maxh,obj2);
	whichOpen='';
	whichcontinue='';
  }else if(whichOpen){
	  whichContinue=obj2;
      whichOpen.click();
	}else{
	  menuShow(obj,maxh,obj2);
	  whichOpen=obj2;
	  whichContinue='';
	}
}
function onloadcss(n)
{
    var index=0;
    $("a[id*='ddd']").each(function(i)
       {
          index=i+1;
          document.getElementById("ddd"+index).className="lib"
       }
    );
	
	document.getElementById("ddd"+n).className="lia";
}
