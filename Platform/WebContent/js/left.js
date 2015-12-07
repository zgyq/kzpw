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
    obj.style.height =(parseInt(obj.style.height) + maxh/20)+'px';
	//obj.filters.alpha.opacity+=5;
	obj2.style.background='url(images/button.gif) -200px -30px';
    
	if(parseInt(obj.style.height)== maxh/10)
	{
	  obj.style.display='block';
	}
	myObj=obj;
	myMaxh=maxh;
	myObj2=obj2;
	setTimeout('menuShow(myObj,myMaxh,myObj2)','5');
  }
}

//Edited by sun
function onloadcss(n)
{
	  $("span[id*='ddd']").each(function(i)
              {
                 $(this).css("color","#999999");
              });
      $("#ddd" + n).css("color","#F48000");
}


function menuHide(obj,maxh,obj2)
{
  if(parseInt(obj.style.height)>0)
  {
    if(parseInt(obj.style.height)==maxh/20)
	  obj.style.display='none';
    obj.style.height =(parseInt(obj.style.height) -maxh/20)+'px';
	//obj.filters.alpha.opacity-=5;
	obj2.style.background='url(images/button.gif) 0px -30px';
	myObj=obj;
	myMaxh=maxh
	myObj2=obj2;
	setTimeout('menuHide(myObj,myMaxh,myObj2)','5');
  }
  else
    if(whichContinue)
	  whichContinue.click();
}

function menuChange(obj,maxh,obj2){
  if(parseInt(obj.style.height))
  {
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
