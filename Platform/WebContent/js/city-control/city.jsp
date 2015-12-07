<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<body>
						<div id="city">
									<div class="city-top" ><font class="fff">热门城市</font>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="#" onclick="colsediv();">关闭</a></div>
									<div class="city-box"> 
									<ul id="mt5" class="">
								    <li class="f city-navon" id="sub1"><a href="#" onclick="sub('1');">热门</a></li>
								    <li class="f city-nav" id="sub2"><a href="#" onclick="sub('2');">A-F</a></li>
								   	<li class="f city-nav" id="sub3"><a href="#" onclick="sub('3');">G-J</a></li>
								   	<li class="f city-nav" id="sub4"><a href="#" onclick="sub('4');">K-N</a></li>
								    <li class="f city-nav" id="sub5"><a href="#" onclick="sub('5');">P-W</a></li>
								    <li class="f city-nav" id="sub6"><a href="#" onclick="sub('6');">X-Z</a></li>
								  	<li class="f city-nav-right"><a href="javascript:void(0);">&nbsp;</a></li>
								    <div class="c"></div></ul>
								    
								    
								    
								    <!-- 热门 -->
								    <div class="mt5 c" id="city1" >
								    <ul class="mt5">
								  	<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('北京','PEK');">北京</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('三亚','SYX');">三亚</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('上海','SHA');">上海</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('广州','CAN');">广州</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('深圳','SZX');">深圳</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('成都','CTU');">成都</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('杭州','HGH');">杭州</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('武汉','WUH');">武汉</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('西安','XIY');">西安</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('重庆','CKG');">重庆</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('青岛','TAO');">青岛</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('长沙','CSX');">长沙</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南京','NKG');">南京</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('厦门','XMN');">厦门</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('昆明','KMG');">昆明</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('大连','DLC');">大连</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('天津','TSN');">天津</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('郑州','CGO');">郑州</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('三亚','SYX');">三亚</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('济南','TNA');">济南</a></li>
									<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('福州','FOC');">福州</a></li>
								    
								    
								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								    <!-- A-F -->
								    <div class="mt5 c" id="city2" style="display: none" >
								    <ul class="mt5">
								  	 <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('阿勒泰','AAT');">阿勒泰</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('安康','AKA');">安康</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('阿克苏','AKU');">阿克苏</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('鞍山','AOG');">鞍山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('安庆','AQG');">安庆</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('包头','BAV');">包头</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('蚌埠','BFU');">蚌埠</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('北海','BHY');">北海</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('保山','BSD');">保山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('常德','CGD');">常德</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('长春','CGQ');">长春</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('朝阳','CHG');">朝阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('赤峰','CIF');">赤峰</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('长治','CIH');">长治</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('重庆','CKG');">重庆</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('长沙','CSX');">长沙</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('成都','CTU');">成都</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('常州','CZX');">常州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('大同','DAT');">大同</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('达县','DAX');">达县</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('丹东','DDG');">丹东</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('大连','DLC');">大连</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('大理','DLU');">大理</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('敦煌','DNH');">敦煌</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('鄂尔多斯','DSN');">鄂尔多斯</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('恩施','ENH');">恩施</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('福州','FOC');">福州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('阜阳','FUG');">阜阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('佛山','FUO');">佛山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('富蕴','FYN');">富蕴</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('北京','PEK');">北京</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('东营','DOY');">东营</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('迪庆','DIG');">迪庆</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('长海','CNI');">长海</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('安阳','AYN');">安阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('鞍山','IOB');">鞍山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('安顺','AVA');">安顺</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('澳门','MFM');">澳门</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('大庆','DPA');">大庆</a></li>
								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								    <!-- g-j -->
								    <div class="mt5 c" id="city3" style="display: none" >
								    <ul class="mt5">
								  	 <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('广州','CAN');">广州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('酒泉','CHW');">酒泉</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('广汉','GHN');">广汉</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('格尔木','GOQ');">格尔木</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('海口','HAK');">海口</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('黑河','HEK');">黑河</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('呼和浩特','HET');">呼和浩特</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('合肥','HFE');">合肥</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('杭州','HGH');">杭州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('海拉尔','HLD');">海拉尔</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('哈密','HMI');">哈密</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('哈尔滨','HRB');">哈尔滨</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('和田','HTN');">和田</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('黄岩','HYN');">黄岩</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('汉中','HZG');">汉中</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('景德镇','JDZ');">景德镇</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('嘉峪关','JGN');">嘉峪关</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('吉林','JIL');">吉林</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('晋江','JJN');">晋江</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('佳木斯','JMU');">佳木斯</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('锦州','JNZ');">锦州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('赣州','KOW');">赣州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('贵阳','KWE');">贵阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('桂林','KWL');">桂林</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('济南','TNA');">济南</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('黄山','TXN');">黄山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('九寨沟','JZH');">九寨沟</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('邯郸','HDG');">邯郸</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('井冈山','JGS');">井冈山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('九江','JIU');">九江</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('广元','GYS');">广元</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('衡阳','HNY');">衡阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('惠州','HUZ');">惠州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('济宁','JNG');">济宁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('淮安','HIA');">淮安</a></li>
								    

								    
								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								    <!-- K-N -->
								    <div class="mt5 c" id="city4" style="display: none" >
								    <ul class="mt5">
								  	<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('库车','KCA');">库车</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('喀什','KHG');">喀什</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南昌','KHN');">南昌</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('昆明','KMG');">昆明</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('库尔勒','KRL');">库尔勒</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('克拉玛依','KRY');">克拉玛依</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('兰州','LHW');">兰州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('丽江','LJG');">丽江</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('芒市','LUM');">芒市</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('庐山','LUZ');">庐山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('拉萨','LXA');">拉萨</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('洛阳','LYA');">洛阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('连云港','LYG');">连云港</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('临沂','LYI');">临沂</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('柳州','LZH');">柳州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('泸州','LZO');">泸州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('牡丹江','MDG');">牡丹江</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('梅县','MXZ');">梅县</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南充','NAO');">南充</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('北京南苑','NAY');">北京南苑</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('宁波','NGB');">宁波</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南京','NKG');">南京</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南宁','NNG');">南宁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南阳','NNY');">南阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('南通','NTG');">南通</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('绵阳','MIG');">绵阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('临沧','LNJ');">临沧</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('满州里','NZH');">满州里</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('连城','LCX');">连城</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('漠河','OHE');">漠河</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('黎平','HZH');">黎平</a></li>
								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								    
								     <!-- P-W -->
								    <div class="mt5 c" id="city5" style="display: none" >
								    <ul class="mt5">
								  	<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('乌兰浩特','HLH');">乌兰浩特</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('且末','IQM');">且末</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('庆阳','IQN');">庆阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('齐齐哈尔','NDG');">齐齐哈尔</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('上海浦东','PVG');">上海浦东</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('上海虹桥','SHA');">上海虹桥</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('沈阳','SHE');">沈阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('秦皇岛','SHP');">秦皇岛</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('沙市','SHS');">沙市</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('石家庄','SJW');">石家庄</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('汕头','SWA');">汕头</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('思茅','SYM');">思茅</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('三亚','SYX');">三亚</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('苏州','SZV');">苏州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('深圳','SZX');">深圳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('青岛','TAO');">青岛</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('塔城','TCG');">塔城</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('铜仁','TEN');">铜仁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('通辽','TGO');">通辽</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('天津','TSN');">天津</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('太原','TYN');">太原</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('乌鲁木齐','URC');">乌鲁木齐</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('潍坊','WEF');">潍坊</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('威海','WEH');">威海</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('温州','WNZ');">温州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('武汉','WUH');">武汉</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('武夷山','WUS');">武夷山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('梧州','WUZ');">梧州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('万县','WXN');">万县</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('乌海','WUA');">乌海</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('无锡','WUX');">无锡</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('攀枝花','PZI');">攀枝花</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('衢州','JUZ');">衢州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('山海关','SHF');">山海关</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('腾冲','TCZ');">腾冲</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('唐山','TVS');">唐山</a></li>
								    

								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								     <!-- X-Z -->
								    <div class="mt5 c" id="city6" style="display: none" >
								    <ul class="mt5">
								  	<li class="f cityon" rel="1"><a href="#" onclick="lodvalue('郑州','CGO');">郑州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('张家界','DYG');">张家界</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('延安','ENY');">延安</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('银川','INC');">银川</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('西双版纳','JHG');">西双版纳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('榆林','UYN');">榆林</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('兴城','XEN');">兴城</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('襄樊','XFN');">襄樊</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('西昌','XIC');">西昌</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('锡林浩特','XIL');">锡林浩特</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('兴宁','XIN');">兴宁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('西安咸阳','XIY');">西安咸阳</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('厦门','XMN');">厦门</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('西宁','XNN');">西宁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('徐州','XUZ');">徐州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('宜宾','YBP');">宜宾</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('宜昌','YIH');">宜昌</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('伊宁','YIN');">伊宁</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('义乌','YIW');">义乌</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('延吉','YNJ');">延吉</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('烟台','YNT');">烟台</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('昭通','ZAT');">昭通</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('湛江','ZHA');">湛江</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('珠海','ZUH');">珠海</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('遵义','ZYI');">遵义</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('运城','YCU');">运城</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('盐城','YNZ');">盐城</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('舟山','HSN');">舟山</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('怀化','HJJ');">怀化</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('兴义','ACX');">兴义</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('永州','LLF');">永州</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('依兰','YLN');">依兰</a></li>
								    
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('香港','HKG');">香港</a></li>
								    
								   
 
								    <li class="c nohave">&nbsp;</li>
								    </ul>
								    </div>
								    
								    
								    </div>
								   </div>
</body>
</html>

<script type="text/javascript" language="javascript">
function sub(ty){

for(i=1;i<=6;i++){

$("#city"+i).hide();
document.getElementById("sub"+i).className="f city-nav";
}
$("#city"+ty).show();
document.getElementById("sub"+ty).className="f city-navon";    
}
	 
function lodvalue(name,code){
  
var citycode=document.getElementById('hidcitycode').value;  
var cityname=document.getElementById('hidcityname').value; 
$("#"+citycode).val(code);
$("#"+cityname).val(name); 

$("#hid_scity").hide();
 $("#hid_ecity").hide();    
         
} 
	 

</script>
<script type="text/javascript" language="javascript">
  function showdiv(ty)
        {
        	//$("#citytype").val('hid_ecity')
        	if(ty=='1'){
        	$("#hid_scity").show();
        	$("#hid_ecity").hide();
        	
        	$("#hidcitycode").val('city_from_hide');
        	$("#hidcityname").val('arrcity');
        	}else{
        	
        	$("#hid_scity").hide();
        	$("#hid_ecity").show();
        	$("#hidcitycode").val('city_to_hide');
        	$("#hidcityname").val('tocity');
        	
        	
        	}
            
            
            
        }
        
        function colsediv(){
        $("#hid_scity").hide();
        $("#hid_ecity").hide();
        }

</script>					

