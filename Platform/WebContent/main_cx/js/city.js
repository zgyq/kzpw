// Java Documen

//酒店根据城市查找三字码 
function getThreeWordByCitysFlight(cityName) {
    var threeWord = "";
    for (var i = 0, len = citysFlight.length; i < len; i++) {
        if (cityName == citysFlight[i][1]) {
            threeWord = citysFlight[i][0];
            break;
        }
    }
    return threeWord;
}

// 初始化常用城市
var commoncitys, citys;

var commoncitysHotel = new Array();
var citysHotel = new Array();

var commoncitysFlight = new Array();
commoncitysFlight[0] = new Array('SZX', '深圳', 'Shenzhen', 'SZ');
commoncitysFlight[1] = new Array('PEK', '北京', 'Beijing', 'BJ');
commoncitysFlight[2] = new Array('SHA', '上海', 'Shanghai', 'SH');
commoncitysFlight[3] = new Array('PVG', '上海浦东', 'Shanghai', 'SH');
commoncitysFlight[4] = new Array('CAN', '广州', 'Guangzhou', 'GZ');
commoncitysFlight[5] = new Array('HGH', '杭州', 'Hangzhou', 'HZ');
commoncitysFlight[6] = new Array('CKG', '重庆', 'Chongqing', 'CQ');
commoncitysFlight[7] = new Array('XIY', '西安', 'Xian', 'XA');
commoncitysFlight[8] = new Array('WUH', '武汉', 'Wuhan', 'WH');
commoncitysFlight[9] = new Array('NKG', '南京', 'Nanjing', 'NJ');
commoncitysFlight[10] = new Array('SYX', '三亚', 'Sanya', 'SY');

// 初始化各个城市
var citysFlight = new Array();
// A
citysFlight[1] = new Array('AAT', '阿勒泰', 'ALETAI', 'ALT');
citysFlight[2] = new Array('AKA', '安康', 'ANKANG', 'AK');
citysFlight[3] = new Array('AKU', '阿克苏', 'AKESU', 'AKS');
citysFlight[4] = new Array('AOG', '鞍山', 'ANSHAN', 'AS');
citysFlight[5] = new Array('AQG', '安庆', 'ANQING', 'AQ');
citysFlight[6] = new Array('BAV', '包头', 'BAOTOU', 'BT');
citysFlight[7] = new Array('BFU', '蚌埠', 'BENGBU', 'BB');
citysFlight[8] = new Array('BHY', '北海', 'BEIHAI', 'BH');
citysFlight[9] = new Array('BSD', '保山', 'BAOSHAN', 'BS');
citysFlight[10] = new Array('CAN', '广州', 'GUANGZHOU', 'GZ');
citysFlight[11] = new Array('CGD', '常德', 'CHANGDE', 'CD');
citysFlight[12] = new Array('CGO', '郑州', 'ZHENGZHOU', 'ZZ');
citysFlight[13] = new Array('CGQ', '长春', 'CHANGCHUN', 'CC');
citysFlight[14] = new Array('CHG', '朝阳', 'CHAOYANG', 'CY');
citysFlight[15] = new Array('CHW', '酒泉', 'JIUQUAN', 'JQ');
citysFlight[16] = new Array('CIF', '赤峰', 'CHIFENG', 'CF');
citysFlight[17] = new Array('CIH', '长治', 'CHANGZHI', 'CZ');
citysFlight[18] = new Array('CKG', '重庆', 'CHONGQING', 'CQ');
citysFlight[19] = new Array('CSX', '长沙', 'CHANGSHA', 'CS');
citysFlight[20] = new Array('CTU', '成都', 'CHENGDU', 'CD');
citysFlight[21] = new Array('CZX', '常州', 'CHANGZHOU', 'CZ');
citysFlight[22] = new Array('DAT', '大同', 'DATONG', 'DT');
citysFlight[23] = new Array('DAX', '达县', 'DAXIAN', 'DX');
citysFlight[24] = new Array('DDG', '丹东', 'DANDONG', 'DD');
citysFlight[25] = new Array('DLC', '大连', 'DALIAN', 'DL');
citysFlight[26] = new Array('DLU', '大理', 'DALI', 'DL');
citysFlight[27] = new Array('DNH', '敦煌', 'DUNHUANG', 'DH');
citysFlight[28] = new Array('DSN', '鄂尔多斯', 'EERDUOSI', 'EEDS');
citysFlight[29] = new Array('DYG', '张家界', 'ZHANGJIAJIE', 'ZJJ');
citysFlight[30] = new Array('ENH', '恩施', 'ENSHI', 'ENH');
citysFlight[31] = new Array('ENY', '延安', 'YANAN', 'YA');
citysFlight[32] = new Array('FOC', '福州', 'FUZHOU', 'FZ');
citysFlight[33] = new Array('FUG', '阜阳', 'FUYANG', 'FY');
citysFlight[34] = new Array('ZQZ', '张家口', 'ZHANGJIAKOU', 'ZJK');
citysFlight[35] = new Array('FYN', '富蕴', 'FUYUN', 'FY');
citysFlight[36] = new Array('GHN', '广汉', 'GUANGHAN', 'GH');
citysFlight[37] = new Array('GOQ', '格尔木', 'GEERMU', 'GEM');
citysFlight[38] = new Array('HAK', '海口', 'HAIKOU', 'HK');
citysFlight[39] = new Array('HEK', '黑河', 'HEIHE', 'HH');
citysFlight[40] = new Array('HET', '呼和浩特', 'HUHEHAOTE', 'HHHT');
citysFlight[41] = new Array('HFE', '合肥', 'HEFEI', 'HF');
citysFlight[42] = new Array('HGH', '杭州', 'HANGZHOU', 'HZ');
citysFlight[43] = new Array('HLD', '海拉尔', 'HAILAER', 'HLR');
citysFlight[44] = new Array('HLH', '乌兰浩特', 'WULANHAOTE', 'WLHT');
citysFlight[45] = new Array('HMI', '哈密', 'HAMI', 'HM');
citysFlight[46] = new Array('HRB', '哈尔滨', 'HA/ERBIN', 'HRB');
citysFlight[47] = new Array('HTN', '和田', 'HETIAN', 'HT');
citysFlight[48] = new Array('HYN', '黄岩', 'HUANGYAN', 'HY');
citysFlight[49] = new Array('HZG', '汉中', 'HANZHONG', 'HZ');
citysFlight[50] = new Array('INC', '银川', 'YINCHUAN', 'YC');
citysFlight[51] = new Array('IQM', '且末', 'QIEMO', 'QM');
citysFlight[52] = new Array('IQN', '庆阳', 'QINGYANG', 'QY');
citysFlight[53] = new Array('JDZ', '景德镇', 'JINGDEZHEN', 'JDZ');
citysFlight[54] = new Array('JGN', '嘉峪关', 'JIAYUGUAN', 'JYG');
citysFlight[55] = new Array('JHG', '西双版纳', 'XISHUANGBANNA', 'XSBN');
citysFlight[56] = new Array('JIL', '吉林', 'JILIN', 'JL');
citysFlight[57] = new Array('JJN', '晋江', 'JINJIANG', 'JJ');
citysFlight[58] = new Array('JMU', '佳木斯', 'JIAMUSI', 'JMS');
citysFlight[59] = new Array('JNZ', '锦州', 'JIZHOU', 'JZ');
citysFlight[60] = new Array('KCA', '库车', 'KUCHE', 'KC');
citysFlight[61] = new Array('KHG', '喀什', 'KASHI', 'KS');
citysFlight[62] = new Array('KHN', '南昌', 'NANCHANG', 'NC');
citysFlight[63] = new Array('KMG', '昆明', 'KUNMING', 'KM');
citysFlight[64] = new Array('KOW', '赣州', 'GANZHOU', 'GZ');
citysFlight[65] = new Array('KRL', '库尔勒', 'KUERLE', 'KRL');
citysFlight[66] = new Array('KRY', '克拉玛依', 'KELAMAYI', 'KLMY');
citysFlight[67] = new Array('KWE', '贵阳', 'GUIYANG', 'GY');
citysFlight[68] = new Array('KWL', '桂林', 'GUILIN', 'GL');
citysFlight[69] = new Array('LHW', '兰州', 'LANZHOU', 'LZ');
citysFlight[70] = new Array('LJG', '丽江', 'LIJIANG', 'LJ');
citysFlight[71] = new Array('LUM', '芒市', 'MANGSHI', 'MS');
citysFlight[72] = new Array('LUZ', '庐山', 'LUSHAN', 'LS');
citysFlight[73] = new Array('LXA', '拉萨', 'LASA', 'LS');
citysFlight[74] = new Array('LYA', '洛阳', 'LUOYANG', 'LY');
citysFlight[75] = new Array('LYG', '连云港', 'LIANYUNGANG', 'LYG');
citysFlight[76] = new Array('LYI', '临沂', 'LINYI', 'LY');
citysFlight[77] = new Array('LZH', '柳州', 'LIUZHOU', 'LZ');
citysFlight[78] = new Array('LZO', '泸州', 'LUZHOU', 'LZ');
citysFlight[79] = new Array('MDG', '牡丹江', 'MUDANJIANG', 'MDJ');
citysFlight[80] = new Array('MXZ', '梅县', 'MEIXIAN', 'MX');
citysFlight[81] = new Array('NAO', '南充', 'NANCHONG', 'NC');
citysFlight[82] = new Array('NAY', '北京南苑', 'NANYUAN', 'BJ');
citysFlight[83] = new Array('NDG', '齐齐哈尔', 'QIQIHAER', 'QQHE');
citysFlight[84] = new Array('NGB', '宁波', 'NINGBO', 'NB');
citysFlight[85] = new Array('NKG', '南京', 'NANJING', 'NJ');
citysFlight[86] = new Array('NNG', '南宁', 'NANNING', 'NN');
citysFlight[87] = new Array('NNY', '南阳', 'NANYANG', 'NY');
citysFlight[88] = new Array('NTG', '南通', 'NANTONG', 'NT');
citysFlight[89] = new Array('PEK', '北京', 'BEIJING', 'BJ');
citysFlight[90] = new Array('PVG', '上海浦东', 'SHANGHAIPUDONG', 'SHPD');
citysFlight[91] = new Array('SHA', '上海虹桥', 'SHANGHAIHONGQIAO', 'SHHQ');
citysFlight[92] = new Array('SHE', '沈阳', 'SHENYANG', 'SY');
citysFlight[93] = new Array('SHP', '秦皇岛', 'QINHUANGDAO', 'QHD');
citysFlight[94] = new Array('SHS', '沙市', 'SHASHI', 'SS');
citysFlight[95] = new Array('SJW', '石家庄', 'SHIJIAZHUANG', 'SJZ');
citysFlight[96] = new Array('SWA', '汕头', 'SHANTOU', 'ST');
citysFlight[97] = new Array('SYM', '思茅', 'SIMAO', 'SM');
citysFlight[98] = new Array('SYX', '三亚', 'SANYAN', 'SY');
citysFlight[99] = new Array('SZV', '苏州', 'SUZHOU ', 'SZ');
citysFlight[100] = new Array('SZX', '深圳', 'SHENZHEN', 'SZ');
citysFlight[101] = new Array('TAO', '青岛', 'QINGDAO', 'QD');
citysFlight[102] = new Array('TCG', '塔城', 'TACHENG', 'TC');
citysFlight[103] = new Array('TEN', '铜仁', 'TONGREN', 'TR');
citysFlight[104] = new Array('TGO', '通辽', 'TONGLIAO', 'TL');
citysFlight[105] = new Array('TNA', '济南', 'JINAN', 'JN');
citysFlight[106] = new Array('TSN', '天津', 'TIANJIN', 'TJ');
citysFlight[107] = new Array('TXN', '黄山', 'HUANGSHAN', 'HS');
citysFlight[108] = new Array('TYN', '太原', 'TAIYUAN', 'TY');
citysFlight[109] = new Array('URC', '乌鲁木齐', 'WULUMUQI', 'WLMQ');
citysFlight[110] = new Array('UYN', '榆林', 'YULIN', 'YL');
citysFlight[111] = new Array('WEF', '潍坊', 'WEIFANG', 'WF');
citysFlight[112] = new Array('WEH', '威海', 'WEIHAI', 'WH');
citysFlight[113] = new Array('WNZ', '温州', 'WENZHOU', 'WZ');
citysFlight[114] = new Array('WUH', '武汉', 'WUHAN', 'WH');
citysFlight[115] = new Array('WUS', '武夷山', 'WUYISHAN', 'WYS');
citysFlight[116] = new Array('WUZ', '梧州', 'WUZHOU', 'WZ');
citysFlight[117] = new Array('WXN', '万县', 'WANXIAN', 'WX');
citysFlight[118] = new Array('XEN', '兴城', 'XINGCHENG', 'XC');
citysFlight[119] = new Array('XFN', '襄樊', 'XIANGFAN', 'XF');
citysFlight[120] = new Array('XIC', '西昌', 'XICHANG', 'XC');
citysFlight[121] = new Array('XIL', '锡林浩特', 'XILINHAOTE', 'XLHT');
citysFlight[122] = new Array('XIN', '兴宁', 'XINGNING', 'XN');
citysFlight[123] = new Array('XIY', '西安咸阳', 'XIAN', 'XA');
citysFlight[124] = new Array('XMN', '厦门', 'XIAMEN', 'XM');
citysFlight[125] = new Array('XNN', '西宁', 'XINING', 'XN');
citysFlight[126] = new Array('XUZ', '徐州', 'XUZHOU', 'XZ');
citysFlight[127] = new Array('YBP', '宜宾', 'YIBIN', 'YB');
citysFlight[128] = new Array('YIH', '宜昌', 'YICHANG', 'YC');
citysFlight[129] = new Array('YIN', '伊宁', 'YINING', 'YN');
citysFlight[130] = new Array('YIW', '义乌', 'YIWU', 'YW');
citysFlight[131] = new Array('YNJ', '延吉', 'YANJI', 'YJ');
citysFlight[132] = new Array('YNT', '烟台', 'YANTAI', 'YT');
citysFlight[133] = new Array('ZAT', '昭通', 'ZHAOTONG', 'ZT');
citysFlight[134] = new Array('ZHA', '湛江', 'ZHANJIANG', 'ZJ');
citysFlight[135] = new Array('ZUH', '珠海', 'ZHUHAI', 'ZH');
citysFlight[136] = new Array('ZYI', '遵义', 'ZUNYI', 'ZY');
citysFlight[137] = new Array('MIG', '绵阳', 'MIANYANG', 'MY');
citysFlight[138] = new Array('DOY', '东营', 'DONGYING', 'DY');
citysFlight[139] = new Array('YCU', '运城', 'YUNCHENG', 'YC');
citysFlight[140] = new Array('WUA', '乌海', 'WUHAI', 'WH');
citysFlight[141] = new Array('JZH', '九寨沟', 'JIUZHAIGOU', 'JZG');
citysFlight[142] = new Array('WUX', '无锡', 'WUXI', 'WX');
citysFlight[143] = new Array('YNZ', '盐城', 'YANCHENG', 'YC');
citysFlight[144] = new Array('DIG', '香格里拉', 'xianggelila', 'XGLL');
citysFlight[145] = new Array('PZI', '攀枝花', 'PANZHIHUA', 'PZH');
citysFlight[146] = new Array('LNJ', '临沧', 'LINCANG', 'LC');
citysFlight[147] = new Array('NZH', '满洲里', 'MANZHOULI', 'MZL');
citysFlight[148] = new Array('HSN', '舟山', 'ZHOUSHAN', 'ZS');
citysFlight[149] = new Array('JUZ', '衢州', 'QUZHOU', 'QZ');
citysFlight[150] = new Array('HDG', '邯郸', 'HANDAN', 'HD');
citysFlight[151] = new Array('JGS', '井冈山', 'JINGGANGSHAN', 'JGS');
citysFlight[152] = new Array('HJJ', '怀化', 'HUAIHUA', 'ZJ');
citysFlight[153] = new Array('ACX', '兴义', 'XINGYI', 'XY');
citysFlight[154] = new Array('CNI', '长海', 'CHANGHAI', 'CH');
citysFlight[155] = new Array('JIU', '九江', 'JIUJIANG', 'JJ');
citysFlight[156] = new Array('GYS', '广元', 'GUANGYUAN', 'GY');
citysFlight[157] = new Array('LCX', '连城', 'LIANCHENG', 'LC');
citysFlight[158] = new Array('AYN', '安阳', 'ANYANG', 'AY');
citysFlight[159] = new Array('SHF', '山海关', 'SHANHAIGUAN', 'SHG');
citysFlight[160] = new Array('LLF', '永州', 'YONGZHOU', 'YZ');
citysFlight[161] = new Array('HNY', '衡阳', 'HENGYANG', 'HY');
citysFlight[162] = new Array('HUZ', '惠州', 'HUIZHOU', 'HZ');
citysFlight[163] = new Array('JNG', '济宁', 'JINING', 'JN');
citysFlight[164] = new Array('OHE', '漠河', 'MOHE', 'MH');
citysFlight[165] = new Array('YLN', '依兰', 'YILAN', 'YL');
citysFlight[166] = new Array('AVA', '安顺', 'ANSHUAN', 'AS');
citysFlight[167] = new Array('HZH', '黎平', 'LIPING ', 'LP');
citysFlight[168] = new Array('TCZ', '腾冲', 'TENGCHONG', 'TC');
citysFlight[169] = new Array('JXA', '鸡西', 'JIXI', 'JX');
citysFlight[170] = new Array('YUS', '玉树', 'YUSHU', 'YS');
citysFlight[171] = new Array('RLK', '巴彦淖尔', 'bayannaoer', 'BYNE');
citysFlight[172] = new Array('YIE', '阿尔山', 'ARXAN', 'AES');
citysFlight[173] = new Array('CYI', '嘉义', 'CHIAYI', 'JY');
citysFlight[174] = new Array('YTY', '扬州', 'yangzhou', 'YZ');
citysFlight[175] = new Array('DQA', '大庆', 'DAQING', 'DQ');
citysFlight[176] = new Array('JGD', '加格达奇', 'JIAGEDAQI', 'JGDQ');
citysFlight[177] = new Array('ZHY', '中卫', 'ZHONGWEI', 'ZW');
citysFlight[178] = new Array('JIC', '金昌', 'JINCHENG', 'JC');
citysFlight[179] = new Array('NLT', '那拉提', 'nalati', 'NLT');
citysFlight[180] = new Array('LZY', '林芝', 'LINZHI', 'LZ');
citysFlight[181] = new Array('NBS', '长白山', 'CHANGBAISHAN', 'CBS');
citysFlight[182] = new Array('BPL', '博乐', 'BOLE', 'BL');
citysFlight[183] = new Array('LDS', '伊春', 'YICHUN', 'YC');
citysFlight[184] = new Array('HIA', '淮安', 'HUAIAN', 'HA');
citysFlight[185] = new Array('NGQ', '阿里', 'ALI', 'AL');
citysFlight[186] = new Array('AEB', '百色', 'BAISE', 'BS');
citysFlight[187] = new Array('BPX', '昌都', 'BANGDA', 'CD');
citysFlight[188] = new Array('JIQ', '黔江', 'QIANJIANG', 'QJ');
citysFlight[189] = new Array('FUO', '佛山', 'FOSHAN', 'FS');
citysFlight[190] = new Array('KGT', '甘孜', 'GANZI', 'GANZ');
citysFlight[191] = new Array('GYU', '固原', 'GUYUAN', 'GY');
citysFlight[192] = new Array('KJI', '喀纳斯', 'KANASI', 'KNS');
citysFlight[193] = new Array('LLB', '荔波', 'LIBO', 'LB');
citysFlight[194] = new Array('RKZ', '日喀则', 'RIKAZE', 'RKZ');
citysFlight[195] = new Array('THQ', '天水', 'TIANSHUI', 'TS');
citysFlight[196] = new Array('TLQ', '吐鲁番', 'TLF', 'TLF');
citysFlight[197] = new Array('TVS', '唐山', 'TANGSHAN', 'TS');
citysFlight[198] = new Array('TNH', '通化', 'TONGHUA', 'TH');
citysFlight[199] = new Array('XNT', '邢台', 'XINGTAI', 'XT');
citysFlight[200] = new Array('YZY', '张掖', 'ZHANGYE', 'ZY');
citysFlight[201] = new Array('CCC', '潮州', 'CHAOZHOU', 'CZ');
citysFlight[202] = new Array('PNJ', '蓬莱', 'PENGLAI', 'PL');
citysFlight[203] = new Array('DZU', '大足', 'DAZU', 'DZ');
citysFlight[204] = new Array('KNC', '吉安', 'JIAN', 'JA');
citysFlight[205] = new Array('KWJ', '光州', 'KWANGJU', 'GZ');
citysFlight[206] = new Array('LHN', '梨山', 'LISHAN', 'LS');
citysFlight[207] = new Array('LIA', '梁平', 'LIANGPING', 'LP');
citysFlight[208] = new Array('LXI', '林西', 'LINXI', 'LX');
citysFlight[0] = new Array('WHU', '芜湖', 'WUHU', 'WH');
citysFlight[209] = new Array('WXN', '万州', 'WANZHOU', 'WZ');
citysFlight[210] = new Array('ERL', '二连浩特', 'ERLIANHAOTE', 'ELHT');
citysFlight[211] = new Array('BFJ', '毕节', 'BIJIE', 'BJ');
citysFlight[212] = new Array('AXF', '阿拉善左旗', 'ALASHANZUOQI', 'ALSZQ');
citysFlight[213] = new Array('RHT', '阿拉善右旗', 'ALASHANYOUQI', 'ALSYQ');
citysFlight[214] = new Array('JUH', '池州', 'CHIZHOU', 'CZ');
citysFlight[215] = new Array('YIC', '宜春', 'YICHUN', 'YC');
citysFlight[216] = new Array('LLV', '吕梁', 'LVLIANG', 'LL');
citysFlight[217] = new Array('SWA', '揭阳', 'JIEYANG', 'JY');
citysFlight[218] = new Array('WNH', '文山', 'WENSHAN', 'WS');
citysFlight[219] = new Array('DCY', '稻城亚丁', 'DAOCHENGYADING', 'DCYD');
citysFlight[220] = new Array('HXD', '海西', 'HAIXI', 'HX');
citysFlight[221] = new Array('HXD', '德令哈', 'DEILINGHA', 'DLH');
citysFlight[222] = new Array('FYJ', '抚远', 'FUYUAN', 'FY');
citysFlight[223] = new Array('LPF', '六盘水', 'LIUPANSHUI', 'LPS');
commoncitys = commoncitysFlight;
citys = citysFlight;

// 根据三字码查找城市
function getCityByThreeWord(threeWord) {
    var cityCn = "";
    for (var i = 0, len = citys.length; i < len; i++) {
        if (threeWord == citys[i][0]) {
            cityCn = citys[i][1];
            break;
        }
    }
    return cityCn;
}
// 根据城市查找三字码
function getThreeWordByCity(cityName) {
    var threeWord = "";
    for (var i = 0, len = citys.length; i < len; i++) {
        if (cityName == citys[i][1]) {
            threeWord = citys[i][0];
            break;
        }
    }
    return threeWord;
}
var parentbject;
var city_suggest = function () {
    this.Remoreurl = ''; // 远程URL地址
    this.object = '';
    this.id2 = '';
    this.taskid = 0;
    this.delaySec = 100; // 默认延迟多少毫秒出现提示框
    this.lastkeys_val = 0;
    var lastkeys_val = 0;
    this.lastinputstr = '';
    /**
    * 初始化类库
    */
    this.init_zhaobussuggest = function () {
        var objBody = document.getElementById("mainbody");
        var objiFrame = document.createElement("iframe");
        var objplatform = document.createElement("div");

        objiFrame.setAttribute('id', 'getiframe');
        objiFrame.style.zindex = '100';
        objiFrame.style.position = 'absolute';
        objiFrame.style.display = 'none';
        objplatform.setAttribute('id', 'getplatform');
        objplatform.setAttribute('align', 'left');
        objplatform.style.zindex = '10000';
        objBody.appendChild(objiFrame);
        objBody.appendChild(objplatform);
        var win = objBody || window

        if (!document.all) {
            objBody.addEventListener("click", this.hidden_suggest, false);

        } else {
            win.document.attachEvent("onclick", this.hidden_suggest);

        }
    }

    /** *************************************************fill_div()******************************************** */
    // 函数功能：动态填充div的内容，该div显示所有的提示内容
    // 函数参数：allplat 一个字符串数组，包含了所有可能的提示内容
    this.fill_div = function (allplat) {
        var msgplat = '';
        var all = '';
        var spell = '';
        var chinese = '';
        var platkeys = this.object.value;
        platkeys = this.ltrim(platkeys);
        if (!platkeys) {
            msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">输入中文/拼音或&uarr;&darr;选择</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
            for (i = 0; i < allplat.length; i++) {
                all = allplat[i].split(",");
                spell = all[0];
                chinese = all[1];
                szm = all[2];
                msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\''
						+ chinese
						+ '\',\''
						+ szm
						+ '\')"><td class="tdleft" height="10" align="left">'
						+ spell
						+ '</td><td class="tdright" align="right">'
						+ chinese
						+ '</td><td style="display:none">'
						+ szm
						+ '</td></tr></table>';
            }
        } else {
            if (allplat.length < 1 || !allplat[0]) {
                msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">对不起，找不到：'
						+ platkeys
						+ '</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';

            } else {
                msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">'
						+ platkeys
						+ '，按拼音排序</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
                for (i = 0; i < allplat.length; i++) {
                    all = allplat[i].split(",");
                    spell = all[0];
                    chinese = all[1];
                    szm = all[2];
                    msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\''
							+ chinese
							+ '\',\''
							+ szm
							+ '\')"><td class="tdleft" height="10" align="left">'
							+ spell
							+ '</td><td class="tdright" align="right">'
							+ chinese
							+ '</td><td style="display:none">'
							+ szm
							+ '</td></tr></table>';
                }
            }
        }
        document.getElementById("getplatform").innerHTML = msgplat;
        var nodes = document.getElementById("getplatform").childNodes;
        nodes[0].className = "hint";
        if (allplat.length >= 1 && allplat[0]) {
            nodes[2].className = "selected";
        }
        // this.lastkeys_val = 0;
        for (var i = 2; i < nodes.length; i++) {
            nodes[i].onmouseover = function () {
                this.className = "mover";
            }
            nodes[i].onmouseout = function () {
                if (parentbject.lastkeys_val == (parentIndexOf(this) - 2)) {
                    this.className = "selected";
                } else {
                    this.className = "mout";
                }
            }
        }
        document.getElementById("getiframe").style.width = document
				.getElementById("getplatform").clientWidth + 2;
        document.getElementById("getiframe").style.height = document
				.getElementById("getplatform").clientHeight + 2;
    }

    /** *************************************************fix_div_coordinate******************************************** */
    // 函数功能：控制提示div的位置，使之刚好出现在文本输入框的下面
    this.fix_div_coordinate = function () {
        var leftpos = 0;
        var toppos = 0;
        var testtmp = this.object.value;
        var testtmp1 = this.object.id;
        aTag = this.object;
        do {
            if (aTag.offsetParent) {
                aTag = aTag.offsetParent;
            } else {
                leftpos += aTag.style.left;
                toppos += aTag.style.top;
                break;
            }
            leftpos += aTag.offsetLeft;
            toppos += aTag.offsetTop;
        } while (aTag.id != "mainbody");
        // alert("leftpos=["+leftpos+"]--toppos=["+toppos+"]--this.object.offsetTop=["+this.object.offsetTop+"]--this.object.offsetLeft=["+this.object.offsetLeft+"]--this.object.offsetHeight=["+this.object.offsetHeight+"]");
        document.getElementById("getiframe").style.width = this.object.offsetWidth
				+ 'px';

        if (document.layers) {
            document.getElementById("getiframe").style.left = this.object.offsetLeft
					+ parseInt(leftpos) + "px";
            document.getElementById("getiframe").style.top = this.object.offsetTop
					+ parseInt(toppos) + this.object.offsetHeight + 2 + "px";
        } else {
            document.getElementById("getiframe").style.left = this.object.offsetLeft
					+ parseInt(leftpos) + "px";
            document.getElementById("getiframe").style.top = this.object.offsetTop
					+ parseInt(toppos) + this.object.offsetHeight + 2 + "px";
        }
        // document.getElementById("getplatform").style.width =
        // this.object.offsetWidth + 'px';
        // document.getElementById("getiframe").style.width=
        // this.object.offsetWidth + 'px';
        if (document.layers) {
            document.getElementById("getplatform").style.left = this.object.offsetLeft
					+ parseInt(leftpos) + "px";
            document.getElementById("getplatform").style.top = this.object.offsetTop
					+ parseInt(toppos) + this.object.offsetHeight + 2 + "px";
        } else {
            document.getElementById("getplatform").style.left = this.object.offsetLeft
					+ parseInt(leftpos) + "px";
            document.getElementById("getplatform").style.top = this.object.offsetTop
					+ parseInt(toppos) + this.object.offsetHeight + 2 + "px";
        }
        // alert("getiframe.left=["+document.getElementById("getiframe").style.left+"]--getiframe.top=["+document.getElementById("getiframe").style.top+"]--getplatform.left=["+document.getElementById("getplatform").style.left+"]--getplatform.top=["+document.getElementById("getplatform").style.top+"]");
    }

    /** *************************************************hidden_suggest******************************************** */
    // 函数功能：隐藏提示框
    this.hidden_suggest = function () {
        this.lastkeys_val = 0;
        document.getElementById("getiframe").style.visibility = "hidden";
        document.getElementById("getplatform").style.visibility = "hidden";
    }

    /** *************************************************show_suggest******************************************** */
    // 函数功能：显示提示框
    this.show_suggest = function () {
        document.getElementById("getiframe").style.visibility = "visible";
        document.getElementById("getplatform").style.visibility = "visible";
    }
    this.is_showsuggest = function () {
        if (document.getElementById("getplatform").style.visibility == "visible")
            return true;
        else
            return false;
    }

    this.sleep = function (n) {
        var start = new Date().getTime(); // for opera only
        while (true)
            if (new Date().getTime() - start > n)
                break;
    }
    this.ltrim = function (strtext) {
        return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
    }

    /** *************************************************add_input_text******************************************** */
    // 函数功能：当用户选中时填充相应的城市名字
    this.add_input_text = function (keys, szm) {

        keys = this.ltrim(keys)
        this.object.value = keys;
        var id = this.object.id;
        document.getElementById(this.id2.id).value = szm;
        document.getElementById(id).style.color = "#000000";
        document.getElementById(id).value = keys;
    }

    /** *************************************************keys_handleup******************************************** */
    // 函数功能：用于处理当用户用向上的方向键选择内容时的事件
    this.keys_handleup = function () {
        if (this.lastkeys_val > 0)
            this.lastkeys_val--;
        var nodes = document.getElementById("getplatform").childNodes;
        if (this.lastkeys_val < 0)
            this.lastkeys_val = nodes.length - 1;
        var b = 0;
        for (var i = 2; i < nodes.length; i++) {
            if (b == this.lastkeys_val) {
                nodes[i].className = "selected";
                this
						.add_input_text(
								nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,
								nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
            } else {
                nodes[i].className = "mout";
            }
            b++;
        }
    }

    /** *************************************************keys_handledown******************************************** */
    // 函数功能：用于处理当用户用向下的方向键选择内容时的事件
    this.keys_handledown = function () {

        this.lastkeys_val++;

        var nodes = document.getElementById("getplatform").childNodes;

        if (this.lastkeys_val >= nodes.length - 2) {

            this.lastkeys_val--;
            return;
        }

        var b = 0;
        for (var i = 2; i < nodes.length; i++) {

            if (b == this.lastkeys_val) {

                nodes[i].className = "selected";
                this
						.add_input_text(
								nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,
								nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
            } else {
                nodes[i].className = "mout";
            }
            b++;
        }
    }

    this.ajaxac_getkeycode = function (e) {
        var code;
        if (!e)
            var e = window.event;
        if (e.keyCode)
            code = e.keyCode;
        else if (e.which)
            code = e.which;

        return code;

    }

    /** *************************************************keys_enter******************************************** */
    // 函数功能：用于处理当用户回车键选择内容时的事件
    this.keys_enter = function () {

        var nodes = document.getElementById("getplatform").childNodes;
        for (var i = 2; i < nodes.length; i++) {
            if (nodes[i].className == "selected") {

                this
						.add_input_text(
								nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,
								nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
            }
        }
        this.hidden_suggest();
    }

    function getEvent() {
        if (document.all)
            return window.event; // 如果是ie
        func = getEvent.caller;
        while (func != null) {
            var arg0 = func.arguments[0];
            if (arg0) {
                if ((arg0.constructor == Event || arg0.constructor == MouseEvent)
						|| (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
                    return arg0;
                }
            }
            func = func.caller;
        }
        return null;
    }

    /** *************************************************display******************************************** */
    // 函数功能：入口函数，将提示层div显示出来
    // 输入参数：object 当前输入所在的对象，如文本框
    // 输入参数：e IE事件对象
    this.display = function (object, id2, e) {
        this.object = document.getElementById(object);
        this.id2 = document.getElementById(id2);
        if (!document.getElementById("getplatform"))
            this.init_zhaobussuggest();
        e = e || window.event;
        // var e=getEvent();

        e.stopPropagation;
        e.cancelBubble = true;
        if (e.target)
            targ = e.target;
        else if (e.srcElement)
            targ = e.srcElement;
        if (targ.nodeType == 3)
            targ = targ.parentNode;

        var inputkeys = this.ajaxac_getkeycode(e);
        switch (inputkeys) {
            case 38: // 向上方向键
                this.keys_handleup(this.object.id);
                return;
                break;
            case 40: // 向下方向键

                if (this.is_showsuggest())
                    this.keys_handledown(this.object.id);
                else
                    this.show_suggest();
                return;
                break;
            case 39: // 向右方向键
                return;
                break;
            case 37: // 向左方向键
                return;
                break;
            case 13: // 对应回车键

                this.keys_enter();
                return;
                break;
            case 18: // 对应Alt键
                this.hidden_suggest();
                return;
                break;
            case 27: // 对应Esc键
                this.hidden_suggest();
                return;
                break;
        }

        // object.value = this.ltrim(object.value);

        // if(object.value == this.lastinputstr) return;else this.lastinputstr =
        // object.value;
        if (window.opera)
            this.sleep(100); // 延迟0.1秒
        parentbject = this;
        if (this.taskid)
            window.clearTimeout(this.taskid);
        this.taskid = setTimeout("parentbject.localtext();", this.delaySec)
        // this.taskid = setTimeout("parentbject.remoteurltext();" ,
        // this.delaySec);

    }

    // 函数功能：从本地js数组中获取要填充到提示层div中的文本内容
    this.localtext = function () {
        var id = this.object.id;
        var suggestions = "";
        suggestions = this.getSuggestionByName();
        suggestions = suggestions.substring(0, suggestions.length - 1);

        parentbject.show_suggest();
        parentbject.fill_div(suggestions.split(';'));
        parentbject.fix_div_coordinate();
    }

    /** *************************************************getSuggestionByName******************************************** */
    // 函数功能：从本地js数组中获取要填充到提示层div中的城市名字
    this.getSuggestionByName = function () {
        platkeys = this.object.value;
        var str = "";
        platkeys = this.ltrim(platkeys);
        if (!platkeys) {
            for (i = 0; i < commoncitys.length; i++) {
                str += commoncitys[i][2] + "," + commoncitys[i][1] + ","
						+ commoncitys[i][0] + ";";
            }
            return str;
        } else {
            platkeys = platkeys.toUpperCase();
            for (i = 0; i < citys.length; i++) {
                if (this.getLeftStr(citys[i][0], platkeys.length).toUpperCase() == platkeys
						|| (citys[i][1].toUpperCase().indexOf(platkeys) != -1)
						|| this.getLeftStr(citys[i][2], platkeys.length)
								.toUpperCase() == platkeys
						|| this.getLeftStr(citys[i][3], platkeys.length)
								.toUpperCase() == platkeys)
                    str += citys[i][2] + "," + citys[i][1] + "," + citys[i][0]
							+ ";";
            }
            return str;
        }
    }

    /**
    * *************************************************getLeftStr*************
    * ************************************
    */
    // 函数功能：得到左边的字符串
    this.getLeftStr = function (str, len) {

        if (isNaN(len) || len == null) {
            len = str.length;
        } else {
            if (parseInt(len) < 0 || parseInt(len) > str.length) {
                len = str.length;
            }
        }
        return str.substr(0, len);
    }

    /**
    * *************************************************parentIndexOf*************
    * ************************************
    */
    // 函数功能：得到子结点在父结点的位置
    function parentIndexOf(node) {
        for (var i = 0; i < node.parentNode.childNodes.length; i++) {
            if (node == node.parentNode.childNodes[i]) {
                return i;
            }
        }
    }

}

function showSearch(obj, obj2) {
    if (document.getElementById(obj).value == "") {
        document.getElementById(obj).style.color = "#C1C1C1";
        document.getElementById(obj).value = "中文/拼音";
    } else {
        var Tcitycode = getThreeWordByCity(document.getElementById(obj).value);
        if (Tcitycode != null) {
            document.getElementById(obj2).value = Tcitycode;
        } else {
            document.getElementById(obj2).value = "";
        }
    }
}

var suggest = new city_suggest();

function change_iframe(idname, urlcity) {
    idname.location.href = urlcity;
}
// 改变搜索框文字
function changetext(thisid) {
    if (thisid == "search1") {
        commoncitys = commoncitysHotel;
        citys = citysHotel;
        document.getElementById("hCity").value = "中文/拼音";
    } else if (thisid == "search2") {
        commoncitys = commoncitysFlight;
        citys = citysFlight;
        document.getElementById("fromcity").value = "中文/拼音";
    }

    for (i = 1; i <= 3; i++) {
        var tdid = "search" + i;
        document.getElementById(tdid).className = "searchitem_b";
    }

    document.getElementById(thisid).className = "searchitem_r";
}
// 搜索框更换
function closeothers(thisid) {
    if (thisid.style.display == "") {
        hotel.style.display = "none";
        plane.style.display = "none";
        pkg.style.display = "none";

        thisid.style.display = "";
    } else {
        thisid.style.display = "";
    }
}