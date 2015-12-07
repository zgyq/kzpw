﻿var city_list =new Array("上海","东莞","临沂","佛山","兰州","北京","南京","南宁","南昌","厦门","合肥","呼和浩特","哈尔滨","大庆","大连","天津","威海","宁波","常州","广州","徐州","成都","无锡","昆明","杭州","武汉","江门","沈阳","泰安","济南","济宁","海口","淄博","深圳","珠海","石家庄","福州","苏州","菏泽","西宁","西安","贵阳","遵义","郑州","重庆","银川","锦州","长春","长沙","青岛","武夷山","安庆","淮北","马鞍山","中山","桂林","唐山","张家口","廊坊","濮阳","洛阳","娄底","延吉","吉林","常熟","淮安","江都","江苏","连云港","南通","宿迁","泰州","大丰","盐城","扬州","镇江","九江","上饶","包头","韩城","德州","莱芜","潍坊","日照","海阳","滨州","烟台","太原","乌鲁木齐","金华","温州","诸暨");var zone_list = new Array();zone_list[0] = new Array("徐汇区","闸北区","浦东新区","静安区","杨浦区","普陀区","闵行区","虹口区","松江区","黄浦区","长宁区","宝山区","奉贤区","嘉定区","金山区","卢湾区");zone_list[1] = new Array("南城区","东城区");zone_list[2] = new Array("兰山区");zone_list[3] = new Array("禅城区");zone_list[4] = new Array("城关区");zone_list[5] = new Array("朝阳区","崇文区","宣武区","西城区","丰台区","海淀区","东城区","石景山区","大兴区");zone_list[6] = new Array("白下区","沿江工业开发区","玄武区","下关区","鼓楼区","秦淮区","江宁区","雨花台区","栖霞区");zone_list[7] = new Array("青秀区");zone_list[8] = new Array("青山湖区","东湖区","西湖区");zone_list[9] = new Array("思明区");zone_list[10] = new Array("庐阳区","包河区" ,"蜀山区","高新区");zone_list[11] = new Array("新城区","回民区","赛汗区");zone_list[12] = new Array("道里区","道外区","南岗区");zone_list[13] = new Array("萨尔图区");zone_list[14] = new Array("中山区","甘井子区");zone_list[15] = new Array("河西区","河北区","南开区","河东区","和平区","武清开发区","经济开发区","东丽区");zone_list[16] = new Array("环翠区");zone_list[17] = new Array("江东区","海曙区","鄞州区");zone_list[18] = new Array("天宁区","新北区","钟楼区");zone_list[19] = new Array("越秀区","荔湾区","天河区","海珠区","白云区","番禺区");zone_list[20] = new Array("云龙区");zone_list[21] = new Array("青羊区","堰市区","成华区","锦江区","武侯区","金牛区");zone_list[22] = new Array("滨湖区","崇安区","北塘区","锡山区","蠡园开发区","南长区","新区");zone_list[23] = new Array("官渡区","五华区");zone_list[24] = new Array("上城区","江干区","下城区");zone_list[25] = new Array("江汉区","江岸区","桥口区","洪山区","汉口区","武昌区","汉阳区");zone_list[26] = new Array("蓬江区");zone_list[27] = new Array("沈河区","和平区","铁西区");zone_list[28] = new Array("泰山区");zone_list[29] = new Array("历下区","历城区","天桥区","槐荫区");zone_list[30] = new Array("市中区");zone_list[31] = new Array("美兰区");zone_list[32] = new Array("张店区","博山区");zone_list[33] = new Array("南山区","宝安区","福田区","罗湖区","龙岗区");zone_list[34] = new Array("香洲区","拱北区");zone_list[35] = new Array("长安区","新华区");zone_list[36] = new Array("台江区","鼓楼区");zone_list[37] = new Array("平江区","经济开发","新区","金阊区","高新区","吴中区","沧浪区");zone_list[38] = new Array("牡丹区");zone_list[39] = new Array("城中区");zone_list[40] = new Array("碑林区","莲湖区","莲湖区 ","新城区","雁塔区","高新区技术产业开发区");zone_list[41] = new Array("云岩区","南明区");zone_list[42] = new Array("红花岗");zone_list[43] = new Array("金水区","中原区","管城区","二七区");zone_list[44] = new Array("江北区","南岸区","渝中区","高新区","九龙坡","沙坪坝区");zone_list[45] = new Array("兴庆区");zone_list[46] = new Array("延安路二段与人民街交汇处");zone_list[47] = new Array("南关区");zone_list[48] = new Array("芙蓉区","雨花区","天心区","开福区","岳麓区");zone_list[49] = new Array("市南区","市北区");zone_list[50] = new Array("三姑度假区");zone_list[51] = new Array("迎江区");zone_list[52] = new Array("相山区");zone_list[53] = new Array();zone_list[54] = new Array("南朗镇环镇路");zone_list[55] = new Array();zone_list[56] = new Array("路南区","路北区");zone_list[57] = new Array();zone_list[58] = new Array();zone_list[59] = new Array("华龙区");zone_list[60] = new Array("涧西区");zone_list[61] = new Array("娄星区");zone_list[62] = new Array();zone_list[63] = new Array("昌邑区");zone_list[64] = new Array();zone_list[65] = new Array("清河区","楚州区");zone_list[66] = new Array();zone_list[67] = new Array("清浦区","武进区","经济技术开发区","鼓楼区","新区");zone_list[68] = new Array("新浦区");zone_list[69] = new Array("港闸区","崇川区","通州区");zone_list[70] = new Array();zone_list[71] = new Array("新区","海陵区");zone_list[72] = new Array();zone_list[73] = new Array();zone_list[74] = new Array("广陵区","邗江区");zone_list[75] = new Array("润州区");zone_list[76] = new Array("庐山区");zone_list[77] = new Array();zone_list[78] = new Array();zone_list[79] = new Array("盘河路");zone_list[80] = new Array("德城区");zone_list[81] = new Array("莱城区","钢城区");zone_list[82] = new Array("潍城区");zone_list[83] = new Array();zone_list[84] = new Array();zone_list[85] = new Array();zone_list[86] = new Array("芝罘区");zone_list[87] = new Array("草坪区","杏花岭区");zone_list[88] = new Array("市天山区");zone_list[89] = new Array("婺城区");zone_list[90] = new Array("鹿城区");zone_list[91] = new Array();