// JavaScript Document
//slideimages数组为变换的图
var slideimages=new Array();
slideimages[0]="images/spotticket/ad-01.jpg";
slideimages[1]="images/spotticket/ad-02.jpg";
slideimages[2]="images/spotticket/ad-03.jpg";
slideimages[3]="images/spotticket/ad-04.jpg";
slideimages[4]="images/spotticket/ad-05.jpg";

//slidetext数组为变换的文字
var slidetext=new Array();
slidetext[0]="";
slidetext[1]="";
slidetext[2]="";
slidetext[3]="";
slidetext[4]="";

//slidetext数组为点击大图后跳到的地址
//var slidelinks=new Array();
//slidelinks[0]="";
//slidelinks[1]="";
//slidelinks[2]="";
//slidelinks[3]="";
//slidelinks[4]="";

//焦点图初始内容－－start
var slidespeed=3000

var slidesanjiaoimages=new Array("images/hotelindex/bian2.gif","images/hotelindex/bian1.gif");
var slidesanjiaoimagesname=new Array("xiaosan1","xiaosan2","xiaosan3","xiaosan4","xiaosan5");

var filterArray=new Array();
filterArray[0]="progid:DXImageTransform.Microsoft.Pixelate (enabled=false,duration=2,maxSquare=25 )";
filterArray[1]="progid:DXImageTransform.Microsoft.Stretch (duration=1,stretchStyle=PUSH)";
filterArray[2]="progid:DXImageTransform.Microsoft.Stretch(duration=1)";
filterArray[3]="progid:DXImageTransform.Microsoft.Slide(bands=8, duration=1)";
filterArray[4]="progid:DXImageTransform.Microsoft.Fade ( duration=1,overlap=0.25 )";

var imageholder=new Array()
var ie55=window.createPopup
for (i=0;i<slideimages.length;i++){
imageholder[i]=new Image()
imageholder[i].src=slideimages[i]
}

function tu_ove(){clearTimeout(setID)}
function ou(){slideit()}

				var whichlink=0
				var whichimage=0
				
				function gotoshow(){
						window.open(slidelinks[whichlink]);
				}
				
				function slideit(){
				
				document.images.slide.style.filter=filterArray[whichimage];
				//alert(document.images.slide.style.filter);
				pixeldelay=(ie55)? (document.images.slide.filters[0].duration*1000) : 0
				//alert(pixeldelay);
				if (!document.images) return
				
				if (ie55) {
						document.images.slide.filters[0].apply();
						document.images.slide.filters[0].play();
						
				}
				document.images.slide.src=imageholder[whichimage].src
				
				document.getElementById("textslide").innerText=slidetext[whichimage];
				
				document.getElementById("xiaosan1").src=slidesanjiaoimages[0];
				document.getElementById("xiaosan2").src=slidesanjiaoimages[0];
				document.getElementById("xiaosan3").src=slidesanjiaoimages[0];
				document.getElementById("xiaosan4").src=slidesanjiaoimages[0];
				document.getElementById("xiaosan5").src=slidesanjiaoimages[0];
				
				//document.getElementById(slidesanjiaoimagesname[whichimage]).src=slidesanjiaoimages[1];
				
				
				
				if (ie55) document.images.slide.filters[0].play()
				whichlink=whichimage
				whichimage=(whichimage<slideimages.length-1)? whichimage+1 : 0
				setID=setTimeout("slideit()",slidespeed+pixeldelay)
				}
				slideit()
				function ove(n){
					clearTimeout(setID)
					whichimage=n;
					document.images.slide.src=imageholder[whichimage].src
						
					document.getElementById("textslide").innerText=slidetext[whichimage];
					document.getElementById("xiaosan1").src=slidesanjiaoimages[0];
					document.getElementById("xiaosan2").src=slidesanjiaoimages[0];
					document.getElementById("xiaosan3").src=slidesanjiaoimages[0];
					document.getElementById("xiaosan4").src=slidesanjiaoimages[0];
					document.getElementById("xiaosan5").src=slidesanjiaoimages[0];
					//document.getElementById(slidesanjiaoimagesname[whichimage]).src=slidesanjiaoimages[1];
				}
		
