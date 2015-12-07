//var varAddress="@beijing|北京@shanghai|上海@guangzhou|广州@shenzhen|深圳@nanjing|南京@chengdu|成都@wuhan|武汉@changsha|长沙@nanchang|南昌@xian|西安@tianjin|天津@haerbin|哈尔滨@changchun|长春@shenyang|沈阳@huhehaote|呼和浩特@lanzhou|兰州@jinan|济南@qingdao|青岛@wuxi|无锡@hefei|合肥@fuzhou|福州@guiyang|贵阳@chongqing|重庆@kunming|昆明@nanning|南宁@dongguan|东莞@foshan|佛山@zhuhai|珠海@haikou|海口@ningbo|宁波@changzhou|常州@suzhou|苏州@hangzhou|杭州@xiamen|厦门@zhengzhou|郑州@shijiazhuang|石家庄@linyi|临沂@jinzhou|锦州@xining|西宁@xiangfan|襄樊@dalian|大连@daqing|大庆@xuzhou|徐州@jiangmen|江门@weihai|威海@yangzhou|扬州@zunyi|遵义@dandong|丹东@zibo|淄博@heze|菏泽@yinchuan|银川@tai'an|泰安@guilin|桂林@huai'an|淮安@qinhuangdao|秦皇岛@wuhu|芜湖@jining|济宁@zhenjiang|镇江@shantou|汕头@taiyuan|太原@panjin|盘锦@jieyang|揭阳@wuyishan|武夷山@anqing|安庆@huaibei|淮北@maanshan|马鞍山@zhongshan|中山@guilin|桂林@tangshan|唐山@zhangjiakou|张家口@langfang|廊坊@puyang|濮阳@luoyang|洛阳@loudi|娄底@yanji|延吉@jilin|吉林 @changshu|常熟@jiangdu|江都@jiangsu|江苏@lianyungang|连云港@nantong|南通@suqian|宿迁@taizhou|泰州@yancheng|盐城@dafeng|大丰@jiujiang|九江@shangrao|上饶@baotou|包头@hancheng|韩城@dezhou|德州@laiwu|莱芜@weifang|潍坊@rizhao|日照@haiyang|海阳@binzhou|滨州@yantai|烟台@wulumuqi|乌鲁木齐@jinhua|金华@wenzhou|温州@zhuji|诸暨@";

//得到酒店城市数据
var varAddress="";
function loadCityData()
{

 $.ajax({
       type:"POST",
       url:"hotel!getHotelCity.jspx",
       async:false,     
       success:function(data)
       {    
         varAddress=data;
       }            
  });
 // alert(varAddress);
}