function nTabs(thisObj,Num){
if(thisObj.className == "active")return;
var tabObj = thisObj.parentNode.id;
var tabList = document.getElementById(tabObj).getElementsByTagName("li");
for(i=0; i <tabList.length; i++)
{
   if (i == Num)
   {
    thisObj.className = "active3"; 
       document.getElementById(tabObj+"_Content"+i).style.display = "block";
   }else{
    tabList[i].className = "normal3"; 
    document.getElementById(tabObj+"_Content"+i).style.display = "none";
   }
} 
}
function setValue(id,value){
jQuery("#"+id).val(value);
}
function getTrainDate(year,month,date,parm){  
  var currendate=new Date();
  currendate.setYear(year);
  currendate.setMonth(month);
  currendate.setDate(date);
  currendate.setDate(currendate.getDate()+parm);
  return currendate;
}

function setDate(cdate){
  
 var currendatestr=cdate;
  var y=currendatestr.substring(0,4);
  var m=currendatestr.substring(5,7);
  var d=currendatestr.substring(8,10);
  var cdate=getTrainDate(y,m,d,0);
  var y1=getTrainDate(y,m,d,-3);
  var y2=getTrainDate(y,m,d,-2);
  var y3=getTrainDate(y,m,d,-1);
  var t5=getTrainDate(y,m,d,1);
  var t6=getTrainDate(y,m,d,2);
  var t7=getTrainDate(y,m,d,3);
  var datearray=new Array(y1,y2,y3,cdate,t5,t6,t7);
  jQuery("#uldate").children().each(function(i){
  var thedate=datearray[i];
  
  var datestr=formatMD(thedate.getMonth())+'-'+formatMD(thedate.getDate())+''+getWeekByDate(thedate);
  var datevalue=thedate.getYear()+'-'+formatMD(thedate.getMonth())+'-'+formatMD(thedate.getDate());
    jQuery(this).attr("date",""+datevalue+"");
    jQuery(this).html(datestr);
  });
  

}

function getWeekstr(day){

var week="";
if(day==0)   week="周日";
if(day==1)   week="周一";
if(day==2)   week="周二";
if(day==3)   week="周三";
if(day==4)   week="周四";
if(day==5)   week="周五";
if(day==6)   week="周六";
return week;

}
function getWeekByDate(date){
 var year=date.getYear();
 var month=date.getMonth();
 var date=date.getDate();
 return getWeek(year,month,date);
}

function getWeek(y, m, d) {
	var _int = parseInt,
		c = _int(y/100);
	y = y.toString().substring(2, 4);
	y = _int(y, 10);
	if(m === 1) {
		m = 13;
		y--;
	} else if(m === 2) {
		m = 14;
		y--;
	};
 
	var w = y + _int(y/4) + _int(c/4) - 2*c + _int(26*(m+1)/10) + d - 1;
	w = w%7;
 
	var day= w >= 0 ? w : w+7;
	return getWeekstr(day);
}



function showInfo(traincode,index){  
  jQuery(".tinfo").slideUp(1000);  
  var startdate=jQuery("#startdate").val();
   jQuery("#divinfo"+index).show();
  jQuery.ajax({
            type:"POST",
            url:"train!ajaxGetTrainInfo.action",
            data:{traincode:traincode,startdate:startdate},
            beforeSend:function(){ jQuery("#divinfo"+index).html("<img src='images/loading.gif' />");},                      
            success:function(data){
              var htm= eval(data);
              jQuery("#divinfo"+index).hide();
              jQuery("#divinfo"+index).html(htm);
              jQuery("#divinfo"+index).parent().show();
              jQuery("#divinfo"+index).slideDown(1500);
            }            
		 });
  
}
function showTrainInfo(listtrian){
 var html="";
html+='<div class="left_piaojia_luduantitle" style="width: 670px;line-height:28px; height:28px;">';
        html+='<ul>';
        html+='<li class="luduan_zhanci">站次</li>';
          html+='<li class="luduan_zhanming">站名</li>';
          html+='<li class="luduan_daoda_kaiche">到达时间</li>';
          html+='<li class="luduan_daoda_kaiche">开车时间</li>';
          html+='<li class="luduan_tingliu">停留</li>';
          html+='<li class="luduan_yunxing">运行时间</li>';
          html+='<li class="luduan_licheng">里程</li>';
          html+='<li class="luduan_yingzuo">硬座</li>';
          html+='<li class="luduan_yingwo" style="width: 120px">硬卧（上/中/下）</li>';
          html+='<li class="luduan_yingwo" style="width: 50px"></li>';
        html+='</ul>';
      html+='</div>';
      for(var i=0;i<listtrian.length;i++){
       var train=listtrian[i];
      html+='<div class="left_piaojia_text ';
      if(i!=listtrian.length){
      html+='c';
      }
      html+='"  style="width: 670px;">';
        html+='<ul>';
          html+='<li class="luduan_zhanci">'+train.sno+'</li>';
          html+='<li class="luduan_zhanming"><a href="/z46/">'+train.sname+'</a></li>';
          html+='<li class="luduan_daoda_kaiche">'+train.arrtime+'</li>';
          html+='<li class="luduan_daoda_kaiche">'+train.gotime+'</li>';
          html+='<li class="luduan_tingliu">分</li>';
          html+='<li class="luduan_yunxing">'+train.costtime+'</li>';
          html+='<li class="luduan_licheng">'+train.distance+'</li>';
          html+='<li class="luduan_yingzuo">'+train.yz+'</li>';
          html+='<li class="luduan_yingwo" style="width: 120px">'+train.yws+'/'+train.ywz+'/'+train.ywx+'</li>';
          html+='<li class="luduan_yingwo" style="width: 50px"><a onclick=csearchYP("'+train.sname+'","'+train.traincode+'") href="javascript:void(0)">买票</a></li>';
        html+='</ul>';
      html+='</div>';
      }
      return html;
     
}

function fclick(objname)
{

  if(objname==1)
  {
   jQuery("#search_zz").show();
   jQuery("#search_checi").hide();
   jQuery("#search_cz").hide();
  }
  else if(objname==2)
  {
   jQuery("#search_zz").hide();
   jQuery("#search_checi").show();
   jQuery("#search_cz").hide();
  }
  else if(objname==3)
  {
   jQuery("#search_zz").hide();
   jQuery("#search_checi").hide();
   jQuery("#search_cz").show();
  }
  else if(objname=='trans')
  {
   jQuery("#ticket_zr").show();
   jQuery("#ticket_qg").hide();
  }
  else if(objname=='buy')
  {
  jQuery("#ticket_zr").hide();
   jQuery("#ticket_qg").show();
  }
  
}
function iclick(objvalue)
{
  if(objvalue==1)
  {
    jQuery("#liecheimg").attr("src","image/serchm1_1.jpg");
	jQuery("#ticketimg").attr("src","image/serchm2_2.jpg");
	jQuery("#dianimg").attr("src","image/serchm3_2.jpg");
	jQuery("#search_lieche").show();
	jQuery("#search_ticket").hide();
	jQuery("#search_dian").hide();
	return false;
  }
  else if(objvalue==2)
  {
    jQuery("#liecheimg").attr("src","image/serchm1_2.jpg");
	jQuery("#ticketimg").attr("src","image/serchm2_1.jpg");
	jQuery("#dianimg").attr("src","image/serchm3_2.jpg");
	jQuery("#search_lieche").hide();
	jQuery("#search_ticket").show();
	jQuery("#search_dian").hide();
	return false;
  }
  else if(objvalue==3)
  {
    jQuery("#liecheimg").attr("src","image/serchm1_2.jpg");
	jQuery("#ticketimg").attr("src","image/serchm2_2.jpg");
	jQuery("#dianimg").attr("src","image/serchm3_1.jpg");
	jQuery("#search_lieche").hide();
	jQuery("#search_ticket").hide();
	jQuery("#search_dian").show();
	return false;
  }
}
function ajaxsearchzz()
{
  if(jQuery("#k1").val()!='' && jQuery("#k2").val()!='' )
  {
    jQuery.get("newajaxzz.php",{k1:jQuery('k1').val(),k2:jQuery('k2').val()},
	function(msg)
	{
	   jQuery("#search_right").val(msg);
	}
	);
  }
}
function fsubmit(fid)
{
  jQuery("#"+fid).submit();
}
//中途余票查询
function csearchYP(cityname,traincode){
jQuery("#twoendcity").val(cityname);
jQuery("#twotraincode").val(traincode);
ajaxsearchyp();

}

function formatMD(md){
if(md<10){
  return "0"+md;
 }else{
 return md;
 }
}