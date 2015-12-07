// Java Documen


 


//初始化常用城市
var commoncitysgj,citys;

var commoncitysHotel = new Array();
var citysHotel = new Array();


var commoncitysFlightgj = new Array();

commoncitysFlightgj[0]=new Array('SZX','深圳','Shenzhen','SZ');
commoncitysFlightgj[1]=new Array('PEK','北京','Beijing','BJ');
commoncitysFlightgj[2]=new Array('SHA','上海虹桥','Shanghai','SH');
commoncitysFlightgj[3]=new Array('PVG','上海浦东','Shanghai','SH');
commoncitysFlightgj[4]=new Array('CAN','广州','Guangzhou','GZ');
commoncitysFlightgj[5]=new Array('HGH','杭州','Hangzhou','HZ');
commoncitysFlightgj[6]=new Array('CKG','重庆','Chongqing','CQ');
commoncitysFlightgj[7]=new Array('SIA','西安','Xian','XA');
commoncitysFlightgj[8]=new Array('WUH','武汉','Wuhan','WH');
commoncitysFlightgj[9]=new Array('NKG','南京','Nanjing','NJ');
commoncitysFlightgj[10]=new Array('SYX','三亚','Sanya','SY');

var intercitys=new Array();
intercitys[0]=new Array('AAN','艾因','AIYIN','AY');
intercitys[1]=new Array('AAT','阿勒泰','ALETAI','ALT');
intercitys[2]=new Array('ABT','阿尔巴哈','AEBAHA','AEBH');
intercitys[3]=new Array('AGR','阿格拉','AGELA','AGL');
intercitys[4]=new Array('AHB','艾卜哈','AIBUHA','ABH');
intercitys[5]=new Array('AKA','安康','ANKANG','AK');
intercitys[6]=new Array('AKJ','旭川','XUCHUAN','XC');
intercitys[7]=new Array('AKU','阿克苏','AKESU','AKS');
intercitys[8]=new Array('AKX','阿克纠宾斯克','AKEJIUBINSIKE','AKJBSK');
intercitys[9]=new Array('ALA','阿拉木图','ALAMUTU','ALMT');
intercitys[10]=new Array('ALP','阿勒颇','ALEPO','ALP');
intercitys[11]=new Array('AMD','艾哈迈达巴德','AIHAMAIDABADE','AHMDBD');
intercitys[12]=new Array('AMI','马塔兰','MATALAN','MTL');
intercitys[13]=new Array('AOG','鞍山','ANSHAN','AS');
intercitys[14]=new Array('AOJ','青森','QINGSEN','QS');
intercitys[15]=new Array('AOR','亚罗士打','YALUOSHIDA','YLSD');
intercitys[16]=new Array('AQG','安庆','ANQING','AQ');
intercitys[17]=new Array('ASB','阿什贾巴特','ASHIJIABATE','ASJBT');
intercitys[18]=new Array('ASJ','奄美大岛','YANMEIDADAO','YMDD');
intercitys[19]=new Array('ASR','开塞利','KAISAILI','KKL');
intercitys[20]=new Array('ATQ','阿姆利则','AMULIZE','AMLZ');
intercitys[21]=new Array('AXT','秋田','QIUTIAN','QT');
intercitys[22]=new Array('AYN','安阳','ANYANG','AY');
intercitys[23]=new Array('AYT','安塔利亚','ATALIYA','ATLY');
intercitys[24]=new Array('BAH','巴林','BALIN','BL');
intercitys[25]=new Array('BAK','巴库','BAKU','BK');
intercitys[26]=new Array('BAL','白特曼','BAITEMAN','BTM');
intercitys[27]=new Array('BAV','包头','BAOTOU','BT');
intercitys[28]=new Array('BBI','布巴内斯瓦尔','BUBANEISIWAER','BBNSWE');
intercitys[29]=new Array('BCD','巴科洛德','BAKELUODE','BKLD');
intercitys[30]=new Array('BDO','万隆','WANLONG','WL');
intercitys[31]=new Array('BDQ','瓦多达拉','WADUODALA','WDDL');
intercitys[32]=new Array('BEJ','贝劳','BEILAO','BL');
intercitys[33]=new Array('BEY','贝鲁特','BEILUTE','BLT');
intercitys[34]=new Array('BFU','蚌埠','BENGBU','BB');
intercitys[35]=new Array('BHH','比沙','BISHA','BS');
intercitys[36]=new Array('BHJ','普杰','PUJIE','PJ');
intercitys[37]=new Array('BHK','布哈拉','BUHALA','BHL');
intercitys[38]=new Array('BHO','博帕尔','BOPAER','BPE');
intercitys[39]=new Array('BHU','包纳加尔','BAONAJIAER','BNJE');
intercitys[40]=new Array('BHV','巴哈瓦尔布尔','BAHAWASHIBUER','BHWEBE');
intercitys[41]=new Array('BHY','北海','BEIHAI','BH');
intercitys[42]=new Array('BIK','毕阿克','BIAKE','BAK');
intercitys[43]=new Array('BKI','哥打京那巴鲁','GEDAJINGNABALU','GDJNBL');
intercitys[44]=new Array('BKK','曼谷','MANGU','MG');
intercitys[45]=new Array('BKS','朋库卢','PENGKULU','PKL');
intercitys[46]=new Array('BLR','班加罗尔','JIABANLUOER','BJLE');
intercitys[47]=new Array('BMU','比马','BIMA','BM');
intercitys[48]=new Array('BOM','孟买','MENGMAI','MM');
intercitys[49]=new Array('BPN','巴厘巴班','BALIBABAN','BLBB');
intercitys[50]=new Array('BSD','保山','BAOSHAN','BS');
intercitys[51]=new Array('BSO','巴示戈','BASHIGE','BSG');
intercitys[52]=new Array('BSR','巴什拉','BASHILA','BSL');
intercitys[53]=new Array('BTC','拜蒂克洛','BAIDIKELUO','BDKL');
intercitys[54]=new Array('BTH','巴淡岛','BADANDAO','BDD');
intercitys[55]=new Array('BTJ','班达亚齐','BANDAYAQI','BDYQ');
intercitys[56]=new Array('BTU','民都鲁','MINDULU','MDL');
intercitys[57]=new Array('BUW','巴务巴务','BAWUBAWU','BWBW');
intercitys[58]=new Array('BXU','武端','WUDUAN','WD');
intercitys[59]=new Array('BZL','巴里萨尔','BALISAER','BLSE');
intercitys[60]=new Array('CAN','广州','GUANGZHOU','GZ');
intercitys[61]=new Array('CBO','科塔巴托','KETABATUO','KTBT');
intercitys[62]=new Array('CCJ','科泽科德','KEZEKEDE','KZKD');
intercitys[63]=new Array('CCU','加尔各答','JIAERGEDA','JEGD');
intercitys[64]=new Array('CEB','宿务','SUWU','SW');
intercitys[65]=new Array('CEI','清莱','QINGLAI','QL');
intercitys[66]=new Array('CGD','常德','CHANGDE','CD');
intercitys[67]=new Array('CGO','郑州','ZHENGZHOU','ZZ');
intercitys[68]=new Array('CGP','吉大港','JIDAGANG','JDG');
intercitys[69]=new Array('CGQ','长春','CHANGCHUN','CC');
intercitys[70]=new Array('CGY','卡加延德奥罗','KAJIAYANDEAOLUO','KJYDAL');
intercitys[71]=new Array('CHG','朝阳','CHAOYANG','CY');
intercitys[72]=new Array('CHW','酒泉','JIUQUAN','JQ');
intercitys[73]=new Array('CIF','赤峰','CHIFENG','CF');
intercitys[74]=new Array('CIH','长治','CHANGZHI','CZ');
intercitys[75]=new Array('CIT','奇穆肯特','QIMUKENTE','QMKT');
intercitys[76]=new Array('CJB','科印拜陀','KAYINBAITUO','KYBT');
intercitys[77]=new Array('CJL','奇德拉尔','QIDELAER','QDLE');
intercitys[78]=new Array('CKG','重庆','CHONGQING','CQ');
intercitys[79]=new Array('CNI','长海','CHANGHAI','CH');
intercitys[80]=new Array('CNX','清迈','QINGMAI','QM');
intercitys[81]=new Array('COK','科奇','KEQI','KQ');
intercitys[82]=new Array('CRM','卡塔曼','KATAMAN','KTM');
intercitys[83]=new Array('CSX','长沙','CHANGSHA','CS');
intercitys[84]=new Array('CTU','成都','CHENGDU','CT');
intercitys[85]=new Array('CXB','科克斯巴扎尔','KEKESIBAZHAER','KKSBZE');
intercitys[86]=new Array('CYI','嘉义','JIAYI','JY');
intercitys[87]=new Array('CYP','甲描育','JIAMIAOYU','JMY');
intercitys[88]=new Array('CYZ','卡瓦延','KAWAYAN','KWY');
intercitys[89]=new Array('CZX','常州','CHANGZHOU','CZ');
intercitys[90]=new Array('DAC','达卡','DAKA','DK');
intercitys[91]=new Array('DAD','岘港','JIANGANG','JG');
intercitys[92]=new Array('DAM','大马士革','DAMASHIGE','DMSG');
intercitys[93]=new Array('DAT','大同','DATONG','DT');
intercitys[94]=new Array('DAX','达县','DAXIAN','DX');
intercitys[95]=new Array('DBA','达尔本丁','DAERBENDING','DEBD');
intercitys[96]=new Array('DDG','丹东','DANDONG','DD');
intercitys[97]=new Array('DED','台拉登','TAILADENG','TLD');
intercitys[98]=new Array('DEL','德里','DELI','DL');
intercitys[99]=new Array('DEZ','德尔佐尔','DEERZUOER','DEZE');
intercitys[100]=new Array('DGT','杜马格特','DUMAGETE','DMGT');
intercitys[101]=new Array('DIB','迪布鲁格尔','DIBULUGEER','DBLGE');
intercitys[102]=new Array('DIG','迪庆','DIQING','DQ');
intercitys[103]=new Array('DIY','迪亚巴克尔','DIYABAKEER','DYBKE');
intercitys[104]=new Array('DJB','占碑','ZHANBEI','ZB');
intercitys[105]=new Array('DJJ','查亚普拉','CHAYAPULA','CYPL');
intercitys[106]=new Array('DLC','大连','DALIAN','DL');
intercitys[107]=new Array('DLI','大叻','DALE','DL');
intercitys[108]=new Array('DLM','达拉曼','DALAMAN','DLM');
intercitys[109]=new Array('DLU','大理','DALI','DL');
intercitys[110]=new Array('DNH','敦煌','DUNHUANG','DH');
intercitys[111]=new Array('DOH','多哈','DUOHA','DH');
intercitys[112]=new Array('DPL','迪波洛格','DIBOLUOGE','DBLG');
intercitys[113]=new Array('DPS','巴厘岛','BALIDAO','BLD');
intercitys[114]=new Array('DSK','德拉伊斯维尔汗','DELAYISIWEIERHAN','DLYSWEH');
intercitys[115]=new Array('DSN','鄂尔多斯','EERDUOSI','EEDS');
intercitys[116]=new Array('DVO','达沃','DIAO','DW');
intercitys[117]=new Array('DXB','迪拜','DIBAI','DB');
intercitys[118]=new Array('DYG','张家界','ZHANGJIAJIE','ZJJ');
intercitys[119]=new Array('DYU','杜尚别','DUSHANGBIE','DSB');
intercitys[120]=new Array('EAM','内基兰','NEIJILAN','NJL');
intercitys[121]=new Array('ECN','坎阿坎','KANAKAN','KAK');
intercitys[122]=new Array('EJH','韦吉','WEIJI','WJ');
intercitys[123]=new Array('ELQ','加希姆','JIAXIMU','JXM');
intercitys[124]=new Array('ENE','英德','YINGDE','YD');
intercitys[125]=new Array('ENH','恩施','ENSHI','ES');
intercitys[126]=new Array('ENY','延安','YANAN','YA');
intercitys[127]=new Array('ERZ','俄祖汝穆','EZURUMU','EZRM');
intercitys[128]=new Array('EZS','埃拉齐格','AILAQIGE','ALQG');
intercitys[129]=new Array('FEG','费尔干纳','FEIERGANNA','FEGN');
intercitys[130]=new Array('FKQ','法克法克','FAKEFAKE','FKFK');
intercitys[131]=new Array('FKS','福岛','FUDAO','FD');
intercitys[132]=new Array('FNJ','平壤','PINGRANG','PR');
intercitys[133]=new Array('FOC','福州','FUZHOU','FZ');
intercitys[134]=new Array('FRU','比什凯克','BISHIKAIKE','BSKK');
intercitys[135]=new Array('FUG','阜阳','FUZHANG','FY');
intercitys[136]=new Array('FUK','福冈','FUGANG','FG');
intercitys[137]=new Array('FUO','佛山','FOSHAN','FS');
intercitys[138]=new Array('FYN','富蕴','FUYUN','FY');
intercitys[139]=new Array('GAJ','山形','SHANXING','SX');
intercitys[140]=new Array('GAU','古瓦哈蒂','GUWAHADI','GWHD');
intercitys[141]=new Array('GAY','伽耶','QIEYE','QY');
intercitys[142]=new Array('GES','桑拖斯将军城','SATUOSIJIANGJUNCHENGNG','STSJJC');
intercitys[143]=new Array('GHN','广汉','GUANGHAN','GH');
intercitys[144]=new Array('GIZ','贾赞','JIAZAN','JZ');
intercitys[145]=new Array('GOQ','格尔木','GEERMU','GEM');
intercitys[146]=new Array('GUW','阿特劳','ATELAO','ATL');
intercitys[147]=new Array('GWD','瓜德尔','GUADEER','GDE');
intercitys[148]=new Array('GYS','广元','GUANGYUAN','GY');
intercitys[149]=new Array('GZT','加济安特普','JIAJIANTEPU','JJATP');
intercitys[150]=new Array('HAK','海口','HAIKOU','HK');
intercitys[151]=new Array('HAN','河内','HENEI','HN');
intercitys[152]=new Array('HAS','哈伊勒','HAYILE','HYL');
intercitys[153]=new Array('HDY','合艾','HEAI','HA');
intercitys[154]=new Array('HEK','黑河','HEIHE','HH');
intercitys[155]=new Array('HET','呼和浩特','HUHEHAOTE','HHHT');
intercitys[156]=new Array('HFE','合肥','HEFEI','HF');
intercitys[157]=new Array('HGH','杭州','HANGZHOU','HF');
intercitys[158]=new Array('HIN','晋州','JINZHOU','JZ');
intercitys[159]=new Array('HJR','克久拉霍','KEJIULAHUO','KJLH');
intercitys[160]=new Array('HKD','函馆','HANGUAN','HG');
intercitys[161]=new Array('HKT','普吉岛','PUJIDAO','PJD');
intercitys[162]=new Array('HLD','海拉尔','HAILAER','HLE');
intercitys[163]=new Array('HLH','乌兰浩特','WULANHAOTE','WLHT');
intercitys[164]=new Array('HMI','哈密','HAMI','HM');
intercitys[165]=new Array('HNY','衡阳','HENGYANG','HY');
intercitys[166]=new Array('HOF','阿拉萨','ALASA','ALS');
intercitys[167]=new Array('HPH','海防','HAIFANG','HF');
intercitys[168]=new Array('HRB','哈尔滨','HAERBIN','HEB');
intercitys[169]=new Array('HSC','韶关','SHAOGUAN','SG');
intercitys[170]=new Array('HSN','舟山','ZHOUSHAN','ZS');
intercitys[171]=new Array('HTN','和田','HETIAN','HT');
intercitys[172]=new Array('HUN','花莲','HUALIAN','HL');
intercitys[173]=new Array('HYD','海德拉巴','HAIDELABA','HDLB');
intercitys[174]=new Array('HYN','黄岩','HUANGYAN','HY');
intercitys[175]=new Array('HZG','汉中','HANZHONG','HZ');
intercitys[176]=new Array('IDR','印多尔','YINDUOER','YDE');
intercitys[177]=new Array('IKI','壹岐','YIQI','YQ');
intercitys[178]=new Array('ILO','伊洛伊洛','YILUOYILUO','YLYL');
intercitys[179]=new Array('IMF','英帕尔','YINGPAER','YPE');
intercitys[180]=new Array('INC','银川','YINCHUAN','YC');
intercitys[181]=new Array('IQM','且末','JIEMO','QM');
intercitys[182]=new Array('IQN','庆阳','ANYANG','QY');
intercitys[183]=new Array('ISB','伊斯兰堡','YISILANBAO','YSTB');
intercitys[184]=new Array('ISG','右垣','YOUYUAN','YY');
intercitys[185]=new Array('IST','伊斯坦布尔','YISITANBUER','YSTBE');
intercitys[186]=new Array('IXA','阿加尔塔拉','AJIAERTALA','AJETL');
intercitys[187]=new Array('IXB','巴格多格拉','BAGEDUOGELA','BGDGL');
intercitys[188]=new Array('IXC','昌迪加尔','CHANGDIJIAER','CDJE');
intercitys[189]=new Array('IXD','阿拉哈巴德','ALAHABADE','ALHBD');
intercitys[190]=new Array('IXE','门格洛尔','MENGELUOER','MGLE');
intercitys[191]=new Array('IXG','贝尔高姆','BEIERGAOMU','BEGM');
intercitys[192]=new Array('IXJ','查谟','CHAMO','CM');
intercitys[193]=new Array('IXL','列城','LIECHENG','LC');
intercitys[194]=new Array('IXM','马杜赖','MADULAI','MDL');
intercitys[195]=new Array('IXR','兰契','LANQI','LQ');
intercitys[196]=new Array('IXU','奥兰加巴德','AOLANJIABADE','ALJBD');
intercitys[197]=new Array('IXZ','布莱尔港','BULAIERGANG','BLEG');
intercitys[198]=new Array('IZO','出云','CHUYUN','CY');
intercitys[199]=new Array('JAI','斋普尔','ZHAIPUER','ZPE');
intercitys[200]=new Array('JDH','焦特布尔','JIAOTEBUER','JTBE');
intercitys[201]=new Array('JDZ','景德镇','JINGDEZHEN','JDZ');
intercitys[202]=new Array('JED','吉达','JIDA','JD');
intercitys[203]=new Array('JGA','贾姆纳加尔','JIAMUNAJIAER','JMNJE');
intercitys[204]=new Array('JGN','嘉峪关','JIAYUGUAN','JYG');
intercitys[205]=new Array('JHB','新山','XINSHAN','XS');
intercitys[206]=new Array('JHG','西双版纳','XISHUANGBANNA','XSBN');
intercitys[207]=new Array('JIL','吉林','JILIN','JL');
intercitys[208]=new Array('JIU','九江','JIUJIANG','JJ');
intercitys[209]=new Array('JJN','晋江','JINJIANG','JJ');
intercitys[210]=new Array('JLR','贾巴尔普尔','JIABAERPUER','JBEPE');
intercitys[211]=new Array('JMU','佳木斯','JIAMUSI','JMS');
intercitys[212]=new Array('JNG','济宁','JINING','JN');
intercitys[213]=new Array('JNZ','锦州','JINZHOU','JZ');
intercitys[214]=new Array('JOG','日惹','RIRE','RR');
intercitys[215]=new Array('JOL','霍洛','HUOLUO','HL');
intercitys[216]=new Array('JRH','乔哈特','QIAOHATE','QHT');
intercitys[217]=new Array('JSR','杰索尔','JIESUOER','JSE');
intercitys[218]=new Array('JUZ','衢州','QUZHOU','QZ');
intercitys[219]=new Array('KAZ','卡乌','KAWU','KW');
intercitys[220]=new Array('KBL','咯布尔','KABUER','KBE');
intercitys[221]=new Array('KBR','哥达巴鲁','GEDABALU','GABL');
intercitys[222]=new Array('KCA','库车','KUCHE','KC');
intercitys[223]=new Array('KCH','吉晋','JIJIN','JJ');
intercitys[224]=new Array('KCZ','高知','GAOZHI','GZ');
intercitys[225]=new Array('KDI','肯达里','KENDALI','KDL');
intercitys[226]=new Array('KDU','斯卡都','SIKADU','SKD');
intercitys[227]=new Array('KGF','卡拉干达','KALAGANDA','KLKD');
intercitys[228]=new Array('KHG','喀什','KASHI','KS');
intercitys[229]=new Array('KHH','高雄','GAOXIONG','GX');
intercitys[230]=new Array('KHI','卡拉奇','KALAQI','KLQ');
intercitys[231]=new Array('KHN','南昌','NANCHANG','NC');
intercitys[232]=new Array('KIJ','新泻','XINXIE','XX');
intercitys[233]=new Array('KKC','孔敬','KONGJING','KJ');
intercitys[234]=new Array('KKJ','北九洲岛','BEIJIUZHOUDAO','BJZD');
intercitys[235]=new Array('KLO','卡利博','KALIBO','KLB');
intercitys[236]=new Array('KMG','昆明','KUNMING','KM');
intercitys[237]=new Array('KMI','宫崎','GONGQI','GQ');
intercitys[238]=new Array('KMJ','熊本','XIONGBEN','XB');
intercitys[239]=new Array('KMQ','小松','XIAOSONG','XS');
intercitys[240]=new Array('KNG','凯马纳','KAIMANA','KMN');
intercitys[241]=new Array('KNH','金门','JINMEN','JM');
intercitys[242]=new Array('KNU','坎普尔','KANPUER','KPE');
intercitys[243]=new Array('KOE','古邦','GUBANG','GB');
intercitys[244]=new Array('KOJ','鹿儿岛','LUERDAO','LED');
intercitys[245]=new Array('KOW','赣州','GNZHOU','GZ');
intercitys[246]=new Array('KPO','浦项','PUXIANG','PX');
intercitys[247]=new Array('KRL','库尔勒','KUERLE','KEL');
intercitys[248]=new Array('KRY','克拉玛依','KELAMAYI','KLMY');
intercitys[249]=new Array('KSQ','卡尔希','KAERXI','KEX');
intercitys[250]=new Array('KTE','居茶','JUCHA','JC');
intercitys[251]=new Array('KTM','加德满都','JIADEMANDU','JDMD');
intercitys[252]=new Array('KUA','关丹','GUANDAN','GD');
intercitys[253]=new Array('KUH','钏路','CHUANLU','CL');
intercitys[254]=new Array('KUL','吉隆坡','JILONGPO','JLP');
intercitys[255]=new Array('KWE','贵阳','GUIYANG','GY');
intercitys[256]=new Array('KWI','科威特','KEWEITE','KWT');
intercitys[257]=new Array('KWJ','光州','GUANGZHOU','GZ');
intercitys[258]=new Array('KWL','桂林','GUILIN','GL');
intercitys[259]=new Array('KYA','科尼亚','KENIYA','KNY');
intercitys[260]=new Array('LAH','拉布哈','LABUHA','LBH');
intercitys[261]=new Array('LAO','拉瓦格','LAWAGE','LWG');
intercitys[262]=new Array('LBJ','下拉布安','XIALABUAN','XLBA');
intercitys[263]=new Array('LBU','拉布安','LABUAN','LBA');
intercitys[264]=new Array('LCA','拉纳卡','LANAKA','LNK');
intercitys[265]=new Array('LDU','拉哈达图','LAHADATU','LHDT');
intercitys[266]=new Array('LGK','兰卡威','LANKAWEI','LKW');
intercitys[267]=new Array('LGP','莱加斯皮','LAIJIASIPI','LJSP');
intercitys[268]=new Array('LHE','拉合尔','LAHAER','LHE');
intercitys[269]=new Array('LHK','光化','GUANGHUA','GH');
intercitys[270]=new Array('LHW','兰州','LANZHOU','LZ');
intercitys[271]=new Array('LJG','丽江','LIJIANG','LJ');
intercitys[272]=new Array('LKO','勒克瑙','LEKENAO','LKN');
intercitys[273]=new Array('LPQ','朗勃拉邦','LANGBOLABANG','LBLB');
intercitys[274]=new Array('LSW','司马威','SIMAWEI','SMW');
intercitys[275]=new Array('LTK','拉塔基亚','LATAJIYA','LTJY');
intercitys[276]=new Array('LUM','芒市','MANGSHI','MS');
intercitys[277]=new Array('LUW','卢武克','LUWUKE','LWK');
intercitys[278]=new Array('LUZ','庐山','LUSHAN','LS');
intercitys[279]=new Array('LXA','拉萨','LASA','LS');
intercitys[280]=new Array('LYA','洛阳','LUOYANG','LY');
intercitys[281]=new Array('LYG','连云港','LIANYUNGUANG','LYG');
intercitys[282]=new Array('LYI','临沂','LINYI','LY');
intercitys[283]=new Array('LYP','费萨拉巴德','FEISALABADE','FSLBD');
intercitys[284]=new Array('LZH','柳州','LIUZHOU','LZ');
intercitys[285]=new Array('LZO','泸州','LUZHOU','LZ');
intercitys[286]=new Array('MAA','金奈','JINNAI','JN');
intercitys[287]=new Array('MBE','纹别','WENBIE','WB');
intercitys[288]=new Array('MBT','马斯巴特','MASIBATE','MSBT');
intercitys[289]=new Array('MCT','马斯咯特','MASIKATE','MSKT');
intercitys[290]=new Array('MDC','万鸦老','WANYALAO','WYL');
intercitys[291]=new Array('MDG','牡丹江','MUDANJIANG','MDJ');
intercitys[292]=new Array('MHD','马什哈德','MASHIHADE','MSHD');
intercitys[293]=new Array('MIG','绵阳','MIANYANG','MY');
intercitys[294]=new Array('MJD','摩亨朱达罗','MOHENGZHUDALUO','MHZDL');
intercitys[295]=new Array('MJU','马穆朱','MAMUZHU','MMZ');
intercitys[296]=new Array('MKQ','马老奇','MAOLAOQI','MLQ');
intercitys[297]=new Array('MKW','马诺夸里','MANUOKUAILI','MNKL');
intercitys[298]=new Array('MKZ','马六甲','MALIUJIA','MLJ');
intercitys[299]=new Array('MLE','马尔代夫','MAERDAIFU','MEDF');
intercitys[300]=new Array('MLG','玛琅','MALANG','ML');
intercitys[301]=new Array('MLX','马拉提亚','MALATIYA','MLTY');
intercitys[302]=new Array('MMB','女满别','NVMANBIE','NMB');
intercitys[303]=new Array('MNA','梅兰瓜内','MEILANGUANEI','MLGN');
intercitys[304]=new Array('MOF','毛梅里','MAOMEILI','MML');
intercitys[305]=new Array('MSJ','三泽','SANZE','SZ');
intercitys[306]=new Array('MUX','木尔坦','MUERTAN','MET');
intercitys[307]=new Array('MXZ','梅州','MEIZHOU','MZ');
intercitys[308]=new Array('MYJ','松山','SONGSHAN','SS');
intercitys[309]=new Array('MYQ','迈索尔','MAISUOER','MSE');
intercitys[310]=new Array('MYY','米里','MILI','ML');
intercitys[311]=new Array('MZG','马公','MAGONG','MG');
intercitys[312]=new Array('MZH','梅尔济丰','MEIERJIFENG','MEJF');
intercitys[313]=new Array('NAG','那格普尔','NAGEPUER','NGPE');
intercitys[314]=new Array('NAH','那霸','NABA','NB');
intercitys[315]=new Array('NAO','南充','NANCHONG','NC');
intercitys[316]=new Array('NAW','那拉提瓦','NALATIWA','NLTW');
intercitys[317]=new Array('NBX','纳比雷','NABILEI','NBL');
intercitys[318]=new Array('NDG','齐齐哈尔','QIQIHAER','QQHE');
intercitys[319]=new Array('NGB','宁波','NINGBO','NB');
intercitys[320]=new Array('NGO','名古屋','MINGGUWU','MGW');
intercitys[321]=new Array('NGS','长崎','CHANGQI','CQ');
intercitys[322]=new Array('NHA','芽庄','YAZHUANG','YZ');
intercitys[323]=new Array('NKG','南京','NANJING','NJ');
intercitys[324]=new Array('NNG','南宁','NANNING','NN');
intercitys[325]=new Array('NNY','南阳','NANYANG','NY');
intercitys[326]=new Array('NTG','南通','NANTONG','NT');
intercitys[327]=new Array('ODY','乌多姆塞','WUDUOMUSAI','WDMS');
intercitys[328]=new Array('OKJ','冈山','GANGSHAN','GS');
intercitys[329]=new Array('OSS','奥什','AOSHI','AS');
intercitys[330]=new Array('PAG','帕加迪安','PAJIADIAN','PJDA');
intercitys[331]=new Array('PAT','巴特那','BATENA','BTN');
intercitys[332]=new Array('PBD','波尔本德尔','POERBENDEER','BEBDE');
intercitys[333]=new Array('PBH','帕罗','PALUO','PL');
intercitys[334]=new Array('PDG','巴东','BADONG','BD');
intercitys[335]=new Array('PEN','槟城','BINCHENG','BC');
intercitys[336]=new Array('PEW','白沙瓦','BAISHAWA','BSW');
intercitys[337]=new Array('PFO','帕福斯','PAFUSI','PFS');
intercitys[338]=new Array('PGK','槟榔','BINGLANG','BL');
intercitys[339]=new Array('PJG','本杰古尔','BENJIEGUER','BJGE');
intercitys[340]=new Array('PKR','博克拉','BOKELA','BKL');
intercitys[341]=new Array('PKU','北干巴鲁','BEIGANBALU','BGBL');
intercitys[342]=new Array('PKZ','巴色','BASE','BS');
intercitys[343]=new Array('PLM','巨港','JUGANG','JG');
intercitys[344]=new Array('PLW','帕卢','PALU','PL');
intercitys[345]=new Array('PNH','金边','JINBIAN','JB');
intercitys[346]=new Array('PNQ','浦那','PUNA','PN');
intercitys[347]=new Array('PPS','普林塞萨港','PULINSAISAGANG','PLSSG');
intercitys[348]=new Array('PSJ','波索','BOSUO','BS');
intercitys[349]=new Array('PUM','波马拉','BOMALA','BML');
intercitys[350]=new Array('PUS','釜山','FUSHAN','FS');
intercitys[351]=new Array('PZH','兹霍布','ZIHUOBU','ZHB');
intercitys[352]=new Array('RAH','拉夫哈','LAFUHA','LFH');
intercitys[353]=new Array('RAJ','拉杰果德','LAJIEGUODE','LJGD');
intercitys[354]=new Array('REP','吴哥窟','WUGEKU','WGK');
intercitys[355]=new Array('RGN','仰光','YANGGUANG','YG');
intercitys[356]=new Array('RJA','拉贾蒙德里','LAJIAMENGDELI','LJMDL');
intercitys[357]=new Array('RJH','拉杰沙希','LAJIESHAXI','LJSX');
intercitys[358]=new Array('RKT','哈伊马角','HAYIMAJIAO','HYMJ');
intercitys[359]=new Array('RPR','赖布尔','LAIBUER','LBE');
intercitys[360]=new Array('RSU','丽水','LISHUI','LS');
intercitys[361]=new Array('RUH','利雅得','LIYADE','LYD');
intercitys[362]=new Array('RXS','罗克塞斯城','LUOKESAISICHENG','LKSSC');
intercitys[363]=new Array('RYK','拉西姆亚尔克罕','LAXIMUYAERKEHAN','LXMYEKH');
intercitys[364]=new Array('SAH','萨那','SANA','SN');
intercitys[365]=new Array('SBW','泗务','SIWU','SW');
intercitys[366]=new Array('SDJ','仙台','XIIANT','XT');
intercitys[367]=new Array('SDK','山打根','SHANDAGEN','SDG');
intercitys[368]=new Array('SGN','胡志明市','HUZHIMINGSHI','HZMS');
intercitys[369]=new Array('SHE','沈阳','SHENYANG','SY');
intercitys[370]=new Array('SHF','山海关','SHANHAIGUAN','SHG');
intercitys[371]=new Array('SHJ','沙迦','SHAJIA','SJ');
intercitys[372]=new Array('SHM','南纪白浜','NANJIBAIBANG','NJBB');
intercitys[373]=new Array('SHP','秦皇岛','QINHUANGDAO','QHD');
intercitys[374]=new Array('SHW','沙鲁拉','SHALULA','SLL');
intercitys[375]=new Array('XIY','西安','XIAN','XA');
intercitys[376]=new Array('SJI','菲律宾圣何塞','FEILVBINSHENGHESAI','FLBSHS');
intercitys[377]=new Array('SJW','石家庄','SHIJIAZHUANG','SJZ');
intercitys[378]=new Array('SKD','撒马尔干','SAMAERGAN','SMEG');
intercitys[379]=new Array('SLL','塞拉莱','SAILALAI','SLL');
intercitys[380]=new Array('SNW','丹兑','DANDUI','DD');
intercitys[381]=new Array('SOC','梭罗','SUOLUO','SL');
intercitys[382]=new Array('SPK','北海道','BAIHAIDAO','BHD');
intercitys[383]=new Array('SRG','三宝拢','SANBAOLONG','SBL');
intercitys[384]=new Array('SSX','萨姆松','SAMUSONG','SMS');
intercitys[385]=new Array('STV','苏拉特古加拉特','SULATEGUJIALATE','SLTGJLT');
intercitys[386]=new Array('SUB','泗水','SISHUI','SS');
intercitys[387]=new Array('SWA','汕头','SHANTOU','ST');
intercitys[388]=new Array('SXR','斯利那加','SILINAJIA','SLNJ');
intercitys[389]=new Array('SYM','思茅','SIMAO','SM');
intercitys[390]=new Array('SYX','三亚','SAYAN','SY');
intercitys[391]=new Array('SYZ','设拉子','SHELAZI','SLZ');
intercitys[392]=new Array('SZV','苏州','SUZHOU','SZ');
intercitys[393]=new Array('SZX','深圳','SHENZHEN','SZ');
intercitys[394]=new Array('TAE','大邱','DAQIU','DQ');
intercitys[395]=new Array('TAK','高松','GAOSONG','GS');
intercitys[396]=new Array('TAO','青岛','QINGDAO','QD');
intercitys[397]=new Array('TAS','塔什干','TASHIGAN','TSG');
intercitys[398]=new Array('TBZ','大布里士','DABULISHI','DBLS');
intercitys[399]=new Array('TCG','塔城','TACHENG','TC');
intercitys[400]=new Array('TEN','铜仁','TONGREN','TR');
intercitys[401]=new Array('TGG','瓜拉丁加奴','GUALADINGJIANU','GLDJN');
intercitys[402]=new Array('TGO','通辽','TONGLIAO','TL');
intercitys[403]=new Array('THR','德黑兰','DEHEILAN','DHL');
intercitys[404]=new Array('TIR','提鲁帕提','TILUPATI','TLPT');
intercitys[405]=new Array('TJQ','丹戎彭登','DANRONGPENGDENG','DRPD');
intercitys[406]=new Array('TKG','南榜市','NANBANGSHI','NBS');
intercitys[407]=new Array('TKS','德岛','DEDAO','DD');
intercitys[408]=new Array('TNA','济南','JINAN','JN');
intercitys[409]=new Array('TNH','通化','TONGHUA','TH');
intercitys[410]=new Array('TNJ','丹戎槟榔','DANRONGBINLANG','DRBL');
intercitys[411]=new Array('TOY','富山','FUSHAN','FS');
intercitys[412]=new Array('TRK','打拉根','DALAGEN','DLG');
intercitys[413]=new Array('TRZ','蒂鲁吉拉柏利','DILUJILABOLI','DLJLBL');
intercitys[414]=new Array('TSE','阿斯塔纳','ASITANA','ASTN');
intercitys[415]=new Array('TSN','天津','TIANJIN','TJ');
intercitys[416]=new Array('TST','董里河','DONGLIHE','DLH');
intercitys[417]=new Array('TUK','图尔伯德','TUERBODE','TEBD');
intercitys[418]=new Array('TWU','斗湖','DOUHU','DH');
intercitys[419]=new Array('TXN','黄山','HUANGSHAN','HS');
intercitys[420]=new Array('TYN','太原','TAIYUAN','TY');
intercitys[421]=new Array('UET','奎达','KUIDA','KD');
intercitys[422]=new Array('UIH','归仁','GUIREN','GR');
intercitys[423]=new Array('ULN','乌兰巴托','WULANBATUO','WLBT');
intercitys[424]=new Array('URC','乌鲁木齐','WULUMUQI','WLMQ');
intercitys[425]=new Array('URY','古拉亚特','GULAYATE','GLYE');
intercitys[426]=new Array('UYN','榆林','YULIN','YL');
intercitys[427]=new Array('VAN','凡城','FANCHENG','FC');
intercitys[428]=new Array('VRC','比拉克','BILAKE','BLK');
intercitys[429]=new Array('VTE','万象','WANXIANG','WX');
intercitys[430]=new Array('WEF','潍坊','WEIFANG','WF');
intercitys[431]=new Array('WEH','威海','WEIHAI','WH');
intercitys[432]=new Array('WHU','芜湖','WUHU','WH');
intercitys[433]=new Array('WNP','那牙','NAYA','NY');
intercitys[434]=new Array('WNZ','温州','WENZHOU','WZ');
intercitys[435]=new Array('WUH','武汉','WUHAN','WH');
intercitys[436]=new Array('WUS','武夷山','WUYISHAN','WYS');
intercitys[437]=new Array('WUX','无锡','WUXI','WX');
intercitys[438]=new Array('WUZ','梧州','WUZHOU','WZ');
intercitys[439]=new Array('WXN','万县','WANXIAN','WX');
intercitys[440]=new Array('XFN','襄樊','XIANGFAN','XF');
intercitys[441]=new Array('XIC','西昌','XICHANG','XC');
intercitys[442]=new Array('XIL','锡林浩特','XILINHAOTE','XLHT');
intercitys[443]=new Array('XMN','厦门','XIAMEN','XM');
intercitys[444]=new Array('XNN','西宁','XINING','XN');
intercitys[445]=new Array('XUZ','徐州','XUZHOU','XZ');
intercitys[446]=new Array('YBP','宜宾','YIBIN','YB');
intercitys[447]=new Array('YGJ','米子','MIZI','MZ');
intercitys[448]=new Array('YIH','宜昌','YICHANG','YC');
intercitys[449]=new Array('YIN','伊宁','YINING','YN');
intercitys[450]=new Array('YIW','义乌','YIWU','YW');
intercitys[451]=new Array('YNJ','延吉','YANJI','YJ');
intercitys[452]=new Array('YNT','烟台','YANTAI','YT');
intercitys[453]=new Array('YNZ','盐城','YANCHENG','YC');
intercitys[454]=new Array('ZAT','昭通','SHAOTONG','ST');
intercitys[455]=new Array('ZHA','湛江','ZHANJIANG','ZJ');
intercitys[456]=new Array('ZUH','珠海','ZHUHAI','ZH');
intercitys[457]=new Array('ZYI','遵义','ZUNYI','ZY');
intercitys[458]=new Array('ADA','阿达那','ADANA','ADN');
intercitys[459]=new Array('AMM','安曼','ANMAN','AM');
intercitys[460]=new Array('ANK','安卡拉','AKALA','AKL');
intercitys[461]=new Array('AUH','阿布扎比','ABU','ABZB');
intercitys[462]=new Array('NAY','北京南苑机场','BEIJINGNANYUANJICHANG','BJNYJC');
intercitys[463]=new Array('PEK','北京首都国际机场','BEIJINGSHOUDUGUOJIJICHANG','BJSDGJJC');
intercitys[464]=new Array('BJS','北京','BEIJING','BJ');
intercitys[465]=new Array('CMB','科伦坡','KELUNPO','KLP');
intercitys[466]=new Array('HIJ','广岛','GUANGDAO','GD');
intercitys[467]=new Array('HKG','香港','XIANGGANG','XG');
intercitys[468]=new Array('IZM','伊兹密尔','YIZIMIER','YZME');
intercitys[469]=new Array('JKT','雅加达','YAJIADA','YJD');
intercitys[470]=new Array('CGK','雅加达机场','YAJIADAJICHANG','YJDJC');
intercitys[471]=new Array('MFM','澳门','AOMEN','AM');
intercitys[472]=new Array('MNL','马尼拉','MANILA','MNL');
intercitys[473]=new Array('OKA','冲绳','CHONGSHENG','CS');
intercitys[474]=new Array('OSA','大阪','DABAN','DB');
intercitys[475]=new Array('ITM','大阪伊丹机场','DABANYIDANJICHANG','DBYDJC');
intercitys[476]=new Array('KIX','大阪关西国际机场','DABANGUANXIGUOJIJICHANG','DBGXGJJC');
intercitys[477]=new Array('SEL','首尔','SHOUER','SE');
intercitys[478]=new Array('GMP','首尔金浦','SHOUERJINPU','SEJP');
intercitys[479]=new Array('ICN','首尔仁川','SHOUERRENCHUAN','SERC');
intercitys[480]=new Array('SHA','上海','SHANGHAI','SH');
intercitys[481]=new Array('PVG','上海浦东','SHANGHAIPUDONG','SHPD');
intercitys[482]=new Array('SIN','新加坡','XINJIAPO','XJP');
intercitys[483]=new Array('TPE','台北桃园机场','TAIBEITAOYUANJICHANG','TBTYJC');
intercitys[484]=new Array('TSA','台北松山机场','TAIBEISONGSHANJICHANG','TBSSJC');
intercitys[485]=new Array('TYO','东京','DONGJING','DJ');
intercitys[486]=new Array('HND','东京羽田','DONGJINGYUTIAN','DJYT');
intercitys[487]=new Array('NRT','东京成田','DONGJINGCHENGTIAN','DJCT');
intercitys[488]=new Array('BGW','巴格达','BAGEDA','BGD');
intercitys[489]=new Array('JZH','九寨沟','JIUZHAIGOU','JZG');
intercitys[490]=new Array('DQA','大庆','DAQING','DQ');
intercitys[491]=new Array('JXA','鸡西','JIXI','JX');
intercitys[492]=new Array('HIA','淮安','HUAIAN','HA');
intercitys[493]=new Array('YUS','玉树','YUSHU','YS');
intercitys[494]=new Array('ACX','兴义','XINGYI','XY');
intercitys[495]=new Array('AAL','奥尔堡','AOERBAO','AEB');
intercitys[496]=new Array('AAQ','阿那帕','ANAPA','ANP');
intercitys[497]=new Array('AAR','奥胡斯','AOHUSI','AHS');
intercitys[498]=new Array('ABZ','英国阿伯丁','YINGGUOABODING','YGABD');
intercitys[499]=new Array('ACE','兰萨罗特','LANSALUOTE','LSLT');
intercitys[500]=new Array('ACH','阿尔滕莱茵','AERTENGLAIYIN','AETLY');
intercitys[501]=new Array('AER','阿德列尔','ADELIEER','ADLE');
intercitys[502]=new Array('AES','奥勒松','AOLESONG','ALS');
intercitys[503]=new Array('AGH','赫尔辛堡','HEERXINBAO','HEXB');
intercitys[504]=new Array('AGP','马拉加','MALAJIA','MLJ');
intercitys[505]=new Array('AHO','阿尔盖罗','AERGAILUO','AEGL');
intercitys[506]=new Array('AJA','阿雅克肖','AYAKEXIAO','AYKX');
intercitys[507]=new Array('AJR','阿尔维斯克尔','AERWEISIKEER','AEWSKE');
intercitys[508]=new Array('ALC','阿利坎特','ALIKANTE','ALKT');
intercitys[509]=new Array('ALF','阿尔塔','AERTA','AET');
intercitys[510]=new Array('ANE','昂热','ANGRE','AR');
intercitys[511]=new Array('ANX','安德内斯','ADENEISI','ADNS');
intercitys[512]=new Array('AOI','安科纳','ANKENA','AKN');
intercitys[513]=new Array('AOK','卡尔帕索斯','KAERPASUOSI','KEPSS');
intercitys[514]=new Array('ASF','阿斯特拉罕','SAITELAHAN','ASTLH');
intercitys[515]=new Array('ASM','阿斯马拉','ASIMALA','ASML');
intercitys[516]=new Array('ATH','雅典','YADIAN','YD');
intercitys[517]=new Array('AVN','亚维侬','YAWEINONG','YWN');
intercitys[518]=new Array('BAX','巴瑙尔','BANAOER','BNE');
intercitys[519]=new Array('BCN','巴塞罗那','NASAILUONA','BSLN');
intercitys[520]=new Array('BDS','布尔迪西','BUERDIXI','BEDX');
intercitys[521]=new Array('BDU','巴尔杜福斯','BAERDUFUSI','BEDFS');
intercitys[522]=new Array('BEB','本布库拉','BENBUKULA','BBKL');
intercitys[523]=new Array('BES','布雷斯特','BULEISITE','BLST');
intercitys[524]=new Array('BGO','卑尔根','BEIERGEN','BEG');
intercitys[525]=new Array('BHX','英国伯明翰','YINGGUOBOMINGHAN','YGBMH');
intercitys[526]=new Array('BIA','巴斯蒂亚','BASIDIYA','BSDY');
intercitys[527]=new Array('BIO','毕尔巴鄂','BIERBAE','BEBE');
intercitys[528]=new Array('BIQ','比亚里茨','BIYALICI','BYLC');
intercitys[529]=new Array('BLK','布莱克普尔','BULAIKEPUER','BLKPE');
intercitys[530]=new Array('BLL','比隆','BILONG','BL');
intercitys[531]=new Array('BLQ','博洛尼亚','BOLUONIYA','BLNY');
intercitys[532]=new Array('BOD','波尔多','BOERDUO','BED');
intercitys[533]=new Array('BOJ','布加斯','BUJIASI','BJS');
intercitys[534]=new Array('BOO','博德','BODE','BD');
intercitys[535]=new Array('BQS','布拉格维申斯科','BULAGEWEISHENSIKE','BLGWSSK');
intercitys[536]=new Array('BRE','不来梅','BULAIMEI','BLM');
intercitys[537]=new Array('BRR','巴拉','BALA','BL');
intercitys[538]=new Array('BRS','布里斯托尔','BULISITUOER','BLSTE');
intercitys[539]=new Array('BRU','布鲁塞尔','BULUSAIER','BLSE');
intercitys[540]=new Array('BTK','布拉茨克','BULACIKE','BLCK');
intercitys[541]=new Array('BUD','布达佩斯','BUDAPEISI','BDPS');
intercitys[542]=new Array('BZG','比得哥什','BIDEGESHI','BDGS');
intercitys[543]=new Array('CAG','卡利亚里','KALIYALI','KLYL');
intercitys[544]=new Array('CAL','坎贝尔镇','KANBEIERZHEN','KBEZ');
intercitys[545]=new Array('CBB','科恰班巴','KEQIANBANBA','KQBB');
intercitys[546]=new Array('CBG','剑桥','JIANQIAO','JQ');
intercitys[547]=new Array('CEK','车里雅宾斯克','CHELIYABINSIKE','CLYBSK');
intercitys[548]=new Array('CFE','克莱蒙费朗','KELAIMENGFEILANG','KLMFL');
intercitys[549]=new Array('CFN','多尼戈尔','DUONIGEER','DNGE');
intercitys[550]=new Array('CFR','卡昂','KAANG','KA');
intercitys[551]=new Array('CFU','克基拉','KAJILA','KJL');
intercitys[552]=new Array('CHQ','干尼亚','GANNIYA','GNY');
intercitys[553]=new Array('CLJ','克卢日','KELURI','KLR');
intercitys[554]=new Array('CLY','卡尔维','KAERWEI','KEW');
intercitys[555]=new Array('CMF','尚贝里','SHANGBEILI','SBL');
intercitys[556]=new Array('CND','康斯坦察','KANGSITANCHA','KSTC');
intercitys[557]=new Array('CRV','克罗托内','KELUOTUONEI','KLTN');
intercitys[558]=new Array('CTA','卡塔尼亚','KATANIYA','KTNY');
intercitys[559]=new Array('CWL','加帝夫','JIADIFU','JDF');
intercitys[560]=new Array('DBV','杜布罗夫尼克','DUBULUOFUNIKE','DBLFNK');
intercitys[561]=new Array('DNK','第摄伯罗彼得罗夫斯克','DISHEBOLUOBIDELUOFUSIKE','DSBLBDLFSK');
intercitys[562]=new Array('DOK','多内茨克','DUONEICIKE','DNCK');
intercitys[563]=new Array('DRS','德雷斯顿','DELEISIDUN','DLSD');
intercitys[564]=new Array('DTM','多特蒙特','DUOTEMENGTE','DTMT');
intercitys[565]=new Array('DUB','都柏林','DBL','DBL');
intercitys[566]=new Array('DYR','阿纳德尔','ANADEER','ANDE');
intercitys[567]=new Array('EAS','圣塞瓦斯蒂安','SHENGSAIWASIDIAN','SSWSDA');
intercitys[568]=new Array('EBA','厄尔巴岛','EERBADAO','EEBD');
intercitys[569]=new Array('EBU','圣艾蒂安','SHENGAIDIAN','SADA');
intercitys[570]=new Array('EDI','爱丁堡','AIDINGBAO','ADB');
intercitys[571]=new Array('EGC','贝尔热拉克','BEIERRELAKE','BERLK');
intercitys[572]=new Array('EIN','爱因霍温','AIYINHUOWEN','AYHW');
intercitys[573]=new Array('ERF','爱尔福特','AIERFUTE','AEFT');
intercitys[574]=new Array('ETZ','梅兹南溪','MEICINANXI','MCNX');
intercitys[575]=new Array('EVE','埃沃内斯','AIWONEISI','AWNS');
intercitys[576]=new Array('EXT','埃克塞特','AIKESAITE','AKST');
intercitys[577]=new Array('FAE','法恩伯勒','FAENBOLE','FEBL');
intercitys[578]=new Array('FAO','法鲁','FALU','FL');
intercitys[579]=new Array('FDH','诽特烈斯港','FEITELIESIGANG','FTLSG');
intercitys[580]=new Array('FLR','佛罗伦萨','FOLUOLUNSA','FLLS');
intercitys[581]=new Array('FLW','佛洛雷斯岛','FOLUOLEISIDAO','FLLSD');
intercitys[582]=new Array('FMO','蒙斯特','MENGSITE','MST');
intercitys[583]=new Array('FNC','丰沙尔','FENGSHAER','FSE');
intercitys[584]=new Array('FSC','菲加里','FEIJIALI','FJL');
intercitys[585]=new Array('FUE','富埃特文图拉岛','LEIAITEWENTULADAO','FATWTLD');
intercitys[586]=new Array('GCI','根西岛','GENXIDAO','GXD');
intercitys[587]=new Array('GDN','格但斯克','GEDANSIKE','GDSK');
intercitys[588]=new Array('GDX','马加丹','MAJIADAN','MJD');
intercitys[589]=new Array('GEV','耶利瓦勒','YELIWALE','YLWL');
intercitys[590]=new Array('GLA','格拉斯哥','GELASIGE','GLSG');
intercitys[591]=new Array('GNB','格勒诺布尔','GELENUOBUER','GLNBE');
intercitys[592]=new Array('GOA','热那亚','RENAYA','RNY');
intercitys[593]=new Array('GOJ','下诺夫哥罗德','XIANUOFUGELUODE','XNFGLD');
intercitys[594]=new Array('GOT','哥德堡','GEDEBAO','GDB');
intercitys[595]=new Array('GPA','帕特雷','PATELEI','PTL');
intercitys[596]=new Array('GRO','赫罗纳','HELUONA','HLN');
intercitys[597]=new Array('GRQ','格罗宁根','GELUONINGGEN','GLNG');
intercitys[598]=new Array('GRW','格拉西奥萨','GELAXIAOSA','GLXAS');
intercitys[599]=new Array('GRX','格拉纳达','GELANADA','GLND');
intercitys[600]=new Array('GRZ','格拉茨','GELACI','GLC');
intercitys[601]=new Array('GVA','日内瓦','RINEIWA','RNW');
intercitys[602]=new Array('GWT','韦斯特兰','WEISITELAN','WSTL');
intercitys[603]=new Array('HAD','哈尔姆斯塔德','HAERMUSITADE','HEMSTD');
intercitys[604]=new Array('HAJ','汉诺威','HANNUOWEI','HNW');
intercitys[605]=new Array('HAU','海于格生德','HAIYUGESHENGDE','HYGSD');
intercitys[606]=new Array('HDF','赫林斯多夫','HELINSIDUOFU','HLSDF');
intercitys[607]=new Array('HER','赫拉克利翁','HELAKELIWENG','HLKLW');
intercitys[608]=new Array('HOQ','霍夫','HUOFU','HF');
intercitys[609]=new Array('HOR','奥尔塔','AOERTA','AET');
intercitys[610]=new Array('HRK','哈尔科夫','HAERKEFU','HEKF');
intercitys[611]=new Array('HTA','赤塔','CHITA','CT');
intercitys[612]=new Array('HUY','汉伯塞','HANBOSAI','HBS');
intercitys[613]=new Array('IAS','雅西','YAXI','YX');
intercitys[614]=new Array('IBZ','伊比萨','YIBISA','YBS');
intercitys[615]=new Array('IKT','伊尔库茨克','YIERKUCIKE','YEKCK');
intercitys[616]=new Array('ILY','艾菜','AILAI','AL');
intercitys[617]=new Array('INN','因斯布鲁克','YINSIBULUKE','YSBLK');
intercitys[618]=new Array('INV','因佛内斯','YINFONEISI','YFNS');
intercitys[619]=new Array('IOM','马恩岛','MAENDAO','MED');
intercitys[620]=new Array('IVL','伊伐洛','YIFALUO','YFL');
intercitys[621]=new Array('JER','泽西','ZEXI','ZX');
intercitys[622]=new Array('JKG','荣砌平','RONGQIPING','RQP');
intercitys[623]=new Array('JKH','希俄斯','XIESI','XES');
intercitys[624]=new Array('JMK','米克诺斯','MIKENUOSI','MKNS');
intercitys[625]=new Array('JOE','约恩苏','YUEENSU','YES');
intercitys[626]=new Array('JSI','斯基亚索斯','SIJIYASUOSI','SJYSS');
intercitys[627]=new Array('JTR','锡拉','XILA','XL');
intercitys[628]=new Array('JYV','于伐斯居拉','YUFASIJULA','YFSJL');
intercitys[629]=new Array('KAJ','卡亚尼','KAYANI','KYN');
intercitys[630]=new Array('KAO','库萨莫','KUSAMO','KSM');
intercitys[631]=new Array('KEJ','克麦罗沃','KEMAILUOWO','KMLA');
intercitys[632]=new Array('KEL','基尔','JIER','JE');
intercitys[633]=new Array('KEM','托尼奥','TUONIAO','TNA');
intercitys[634]=new Array('KGD','加里宁格勒','JIALININGGELE','JLNGL');
intercitys[635]=new Array('KGS','科斯','KESI','KS');
intercitys[636]=new Array('KHV','哈巴罗夫斯克','HABALUOFUSIKE','HBLFSK');
intercitys[637]=new Array('KIR','凯里郡','KAILIJUN','KLJ');
intercitys[638]=new Array('KIT','基西拉','JIXILA','JXL');
intercitys[639]=new Array('KJA','克拉斯诺雅尔斯克','KELASINUOYAERSIKE','KLSNYESK');
intercitys[640]=new Array('KKN','希尔克内斯','XIERKENEISI','XEKNS');
intercitys[641]=new Array('KLR','卡尔马','KAERMA','KEM');
intercitys[642]=new Array('KLU','克拉根福特','KELAGENFUTE','KLGFT');
intercitys[643]=new Array('KLX','卡拉马塔','KALAMATA','KLMT');
intercitys[644]=new Array('KOI','柯克沃尔','KEKEWOER','KKWE');
intercitys[645]=new Array('KOK','科科拉','KEKELA','KKL');
intercitys[646]=new Array('KRF','科拉姆福什','KELAMUFUSHI','KLMFS');
intercitys[647]=new Array('KRK','克拉特夫','KELATEFU','KLTF');
intercitys[648]=new Array('KRN','基律纳','JILVNA','JLN');
intercitys[649]=new Array('KRP','卡鲁普','KALUPU','KLP');
intercitys[650]=new Array('KRR','科拉斯诺达尔','KELASINUODEER','KLSNDE');
intercitys[651]=new Array('KRS','克里斯蒂安桑','KELISIDIANSANG','KLSDAS');
intercitys[652]=new Array('KSC','科希策','KEXICE','KXC');
intercitys[653]=new Array('KSD','卡尔斯塔德','KAERSITADE','KESDAS');
intercitys[654]=new Array('KSU','克里斯蒂安松','KELISIDIANSONG','KLSDAS');
intercitys[655]=new Array('KTT','基蒂拉','JIDILA','JDL');
intercitys[656]=new Array('KTW','卡托维茨','KATUOWEICI','KTWC');
intercitys[657]=new Array('KUF','萨马拉','SAMALA','SML');
intercitys[658]=new Array('KUO','库奥皮欧','KUAOPIOU','KAPO');
intercitys[659]=new Array('KVA','卡瓦拉','KAWALA','KWL');
intercitys[660]=new Array('KZN','喀山','KASHAN','KS');
intercitys[661]=new Array('LAI','拉尼永','LANIYONG','LNY');
intercitys[662]=new Array('LCG','拉科鲁利亚','LAKELULIYA','LKLLY');
intercitys[663]=new Array('LDE','卢尔德','LUERDE','LED');
intercitys[664]=new Array('LED','圣彼得堡','SHENGBIDEBAO','SBDB');
intercitys[665]=new Array('LEH','勒阿弗尔','LEAFOER','LAFE');
intercitys[666]=new Array('LEI','阿尔梅里亚','AERMEILIYA','AEMLY');
intercitys[667]=new Array('LEJ','莱比锡','LAIBIXI','LBY');
intercitys[668]=new Array('LGG','列日','LIERI','LR');
intercitys[669]=new Array('LIG','利摩日','LINORI','LMR');
intercitys[670]=new Array('LIL','里尔','LIER','LE');
intercitys[671]=new Array('LIS','里斯本','LISIBEN','LSB');
intercitys[672]=new Array('LKL','拉克塞尔夫','LAKESAIERFU','LKSEF');
intercitys[673]=new Array('LLA','吕勒奥','LVLEAO','LLA');
intercitys[674]=new Array('LME','勒芒','LEMANG','LM');
intercitys[675]=new Array('LMP','兰佩杜萨','LANPEIDUSA','LPDS');
intercitys[676]=new Array('LNZ','林茨','LINCI','LC');
intercitys[677]=new Array('LPA','拉斯帕尔马斯','LASIPAERMASI','LSPEMS');
intercitys[678]=new Array('LPB','玻利维亚 拉巴斯','BOLIWEIYALABASI','BLWYLBS');
intercitys[679]=new Array('LPI','林雪平','LINXIEPING','LXP');
intercitys[680]=new Array('LPL','利物浦','LIWUPU','LWP');
intercitys[681]=new Array('LRH','拉罗歇尔','LALUOXIEER','LLXE');
intercitys[682]=new Array('LRT','洛里昂','LUOLIANG','LLA');
intercitys[683]=new Array('LUG','卢加诺','LUJIANUO','LJN');
intercitys[684]=new Array('LUX','卢森堡','LUSENBAO','LSB');
intercitys[685]=new Array('LWO','里沃夫','LIWOFU','LWF');
intercitys[686]=new Array('LXS','利姆诺斯岛','LIMUNUOSIDAO','LMNSD');
intercitys[687]=new Array('LYC','吕克瑟勒','LVKESELE','LKSL');
intercitys[688]=new Array('LYR','朗伊尔城','LANGYIERCHENG','LYEL');
intercitys[689]=new Array('MAH','梅诺卡','MEINUOKA','MNK');
intercitys[690]=new Array('MAV','蒙特卡洛','MENGTEKALUO','MTKL');
intercitys[691]=new Array('MHQ','玛丽港','MALIGANG','MLG');
intercitys[692]=new Array('MJV','穆尔西亚','MUERXIYA','MEXY');
intercitys[693]=new Array('MME','达勒姆提斯瓦雷','DALEMUTISIWALEI','DLMTSWL');
intercitys[694]=new Array('MMK','莫尔曼斯科','MOERMANSIKE','MEMSK');
intercitys[695]=new Array('MOL','莫尔德','MOERDE','MED');
intercitys[696]=new Array('MPL','蒙彼利埃','MENGBILIAI','MBLA');
intercitys[697]=new Array('MRS','马赛','MASAI','MS');
intercitys[698]=new Array('MRV','米拉尔耶沃德','MILAERYEWODE','MLEYWD');
intercitys[699]=new Array('MSQ','明斯克','MINGSIKE','MSK');
intercitys[700]=new Array('MST','马斯垂克','MASICHUIKE','MSKG');
intercitys[701]=new Array('NAP','那不勒斯','NABULESI','NBLS');
intercitys[702]=new Array('NBC','卡马河畔切尔尼','KAMAHEPANQIEFUNI','KMHPQEN');
intercitys[703]=new Array('NCE','尼斯','NISI','NS');
intercitys[704]=new Array('NCL','英国纽卡斯尔','YINGGUONIUKASIKA','YGNKSE');
intercitys[705]=new Array('NCY','安奈斯','ANAISI','ANS');
intercitys[706]=new Array('NRK','诺尔雪平','NUOERXUEPING','NEXP');
intercitys[707]=new Array('NTE','南特','NANTE','NT');
intercitys[708]=new Array('NUE','纽伦堡','NIULUNBAO','NLB');
intercitys[709]=new Array('NVK','纳尔维克','NAERWEIKE','NEWK');
intercitys[710]=new Array('NWI','诺维奇','NUOWEIQI','NWQ');
intercitys[711]=new Array('ODE','欧登塞','OUDENGSAI','ODS');
intercitys[712]=new Array('ODS','奥德萨','AODESA','ADS');
intercitys[713]=new Array('OER','恩舍尔兹维克','ENSHEERCIWEIKE','ESECWK');
intercitys[714]=new Array('OLB','奥尔比亚','AOERBIYA','AEBY');
intercitys[715]=new Array('OMO','莫斯塔尔','MOSITAER','MSTE');
intercitys[716]=new Array('OMS','鄂木斯克','EMUSIKE','EMSK');
intercitys[717]=new Array('OPO','波尔图','BOERTU','BET');
intercitys[718]=new Array('ORK','科克','KEKE','KK');
intercitys[719]=new Array('OSD','厄斯特松德','ESITESONGDE','ESTSD');
intercitys[720]=new Array('OSR','俄斯特拉伐','ESITELAFA','ESTLF');
intercitys[721]=new Array('OST','奥斯坦德','AOSITANDE','ASTD');
intercitys[722]=new Array('OUL','奥卢','AOLU','AL');
intercitys[723]=new Array('OVB','新西伯利亚','XINXIBOLIYA','XXBLY');
intercitys[724]=new Array('OVD','阿斯图里亚斯','ASITULIYASI','ASTLYS');
intercitys[725]=new Array('PAD','帕特泊恩','PATEBOEN','PTBE');
intercitys[726]=new Array('PDL','蓬塔德尔加达','PENGTADEERJIADA','PTDEJD');
intercitys[727]=new Array('PEE','彼尔姆','BIERMU','BEM');
intercitys[728]=new Array('PEZ','奔萨','BENSA','BS');
intercitys[729]=new Array('PGF','佩皮尼扬','PEIPINIYANG','PPNY');
intercitys[730]=new Array('PIS','普瓦杰','PUWAJIE','PWJ');
intercitys[731]=new Array('PIX','皮克岛','PIKEDAO','PKD');
intercitys[732]=new Array('PKC','勘察加','KANCHAJIA','KCJ');
intercitys[733]=new Array('PLQ','克莱柏特','KELAIBOTE','KLBT');
intercitys[734]=new Array('PMF','米兰帕尔马','MILANPAERMA','MLPEM');
intercitys[735]=new Array('PMI','帕尔马','MAERMA','PEM');
intercitys[736]=new Array('PMO','巴勒莫','BALEMO','BLM');
intercitys[737]=new Array('PNA','潘普洛纳','PANPULUONA','PPLN');
intercitys[738]=new Array('PNL','潘泰莱里亚','PANTAILAILIYA','PTLLY');
intercitys[739]=new Array('POR','波里','BOLI','BL');
intercitys[740]=new Array('POZ','波兹南','BOCINAN','BCN');
intercitys[741]=new Array('PPT','大溪地','DAXIDI','DXD');
intercitys[742]=new Array('PRG','布拉格','BULAGE','BLG');
intercitys[743]=new Array('PRN','普里什蒂纳','PULISHIDINA','PLSDN');
intercitys[744]=new Array('PSR','佩斯卡拉','PEISIKALA','PSKL');
intercitys[745]=new Array('PUF','波城','BOCHENG','BC');
intercitys[746]=new Array('PUY','普拉','PULA','PL');
intercitys[747]=new Array('PVK','普雷韦扎','PULEIWEIZHA','PLWZ');
intercitys[748]=new Array('PXO','圣港','SHENGGANG','SG');
intercitys[749]=new Array('RBQ','鲁雷纳瓦克','LULEINAWAKE','LLNWK');
intercitys[750]=new Array('RDZ','罗德兹','LUODECI','LDC');
intercitys[751]=new Array('REG','雷谯卡拉布里亚','LEIQIAOKALABULIMA','LQKLBLY');
intercitys[752]=new Array('REU','雷乌斯','LEIWUSI','LWS');
intercitys[753]=new Array('RJK','里耶卡','LIYEKA','LYK');
intercitys[754]=new Array('RMI','里米尼','LIMINI','LMN');
intercitys[755]=new Array('RNB','隆内比','LONGNEIBI','LNB');
intercitys[756]=new Array('RNS','雷恩','LEIEN','LE');
intercitys[757]=new Array('ROM','罗马','LUOMA','LM');
intercitys[758]=new Array('ROV','罗斯托夫','LUOSITUOFU','LSTF');
intercitys[759]=new Array('RTM','鹿特丹','LUTEDAN','LTD');
intercitys[760]=new Array('RVN','罗瓦涅米','LUOWANIEMI','LWNM');
intercitys[761]=new Array('RZE','热舒夫','RUSHUFU','RSF');
intercitys[762]=new Array('SCN','萨尔布吕肯','SAERBULVKEN','SEBLK');
intercitys[763]=new Array('SCQ','圣地亚哥德','SHENGDIYEGEDE','SDYGD');
intercitys[764]=new Array('SGC','苏尔古特','SUERGUTE','SEGT');
intercitys[765]=new Array('SGD','森讷堡','SENNABAO','SNB');
intercitys[766]=new Array('SIP','辛菲罗波尔','XINFEILUOBOER','XFLBE');
intercitys[767]=new Array('SJJ','萨拉热窝','SALAREWO','SLRW');
intercitys[768]=new Array('SKG','塞萨洛尼基','SAISALUONIJI','SSLNJ');
intercitys[769]=new Array('SMA','圣塔玛利亚','SHENGTAMALIYA','STMLY');
intercitys[770]=new Array('SMI','萨莫斯','SAMOSI','SMS');
intercitys[771]=new Array('SOF','索非亚','SUOFEIYA','SFY');
intercitys[772]=new Array('SOU','南安普敦','NANANPUDUN','NAPD');
intercitys[773]=new Array('SPU','斯普利特','SIPULITE','SPLT');
intercitys[774]=new Array('SRE','苏克雷','SUKELEI','SKL');
intercitys[775]=new Array('SUF','拉默齐亚','LAMOQIYA','LMQY');
intercitys[776]=new Array('SVG','斯塔万格','SITAWANGE','STWG');
intercitys[777]=new Array('SVL','萨翁林纳','SAWENGLINNA','SWLN');
intercitys[778]=new Array('SVQ','塞维利亚','SAIWEILIYA','SWLY');
intercitys[779]=new Array('SVX','叶卡捷琳堡','YEKAJIELINBAO','YKJLB');
intercitys[780]=new Array('SXB','斯特拉斯堡','SITELASIBAO','STLSB');
intercitys[781]=new Array('SZG','萨尔茨堡','SAKACIBAO','SKCB');
intercitys[782]=new Array('SZZ','什切青','SHIQIEQING','SQQ');
intercitys[783]=new Array('TAY','塔尔图','TAERTU','TET');
intercitys[784]=new Array('TIA','提拉纳','TILANA','TLN');
intercitys[785]=new Array('TIV','蒂瓦特','DIWATE','DWT');
intercitys[786]=new Array('TJM','秋明','QIUMING','QM');
intercitys[787]=new Array('TRN','都灵','DULING','DL');
intercitys[788]=new Array('TSR','蒂米什瓦拉','DIMISHIWALA','DMSWL');
intercitys[789]=new Array('UIP','坎佩尔','KAPEIER','KPE');
intercitys[790]=new Array('UUS','南萨哈林思克','NANSAHALINSIKE','NSHLSK');
intercitys[791]=new Array('VOG','伏尔加格勒','FUERJIAGELE','FEJGL');
intercitys[792]=new Array('VVO','符拉迪沃斯托克','FULADIWOSITUOKE','FLDWSTK');
intercitys[793]=new Array('WAW','华沙','HUASHA','HS');
intercitys[794]=new Array('WRO','弗罗次瓦夫','FOLUOCIWAFU','FLCWF');
intercitys[795]=new Array('XRY','赫雷斯','HELEISI','HLS');
intercitys[796]=new Array('ZRH','苏黎世','SULISHI','SLS');
intercitys[797]=new Array('AMS','阿姆斯特丹','AMUSITEDAN','AMSTD');
intercitys[798]=new Array('ANR','安特卫普','ATEWEIPU','ATWP');
intercitys[799]=new Array('APW','阿皮亚','APIYA','APY');
intercitys[800]=new Array('BEG','贝尔格莱德','BEIERGELAIDE','BEGLD');
intercitys[801]=new Array('BER','柏林','BILIN','BL');
intercitys[802]=new Array('SXF','柏林肖尔内菲尔德机场','BILINXIAOERNEIFEIERDEJICHANG','BLXENFEDJC');
intercitys[803]=new Array('TXL','柏林泰格尔机场','BILINTAIGEERJICHANG','BLTGEJC');
intercitys[804]=new Array('BFS','贝尔法斯特','BEIERFASITE','BEFST');
intercitys[805]=new Array('BRN','伯尔尼','BOERNI','BEN');
intercitys[806]=new Array('BTS','布拉迪斯拉发','BULADISILAFA','BLDSLF');
intercitys[807]=new Array('BUH','布加勒斯特','JIABULESITE','JBLST');
intercitys[808]=new Array('OTP','布加勒斯特 奥托佩尼机场','JIABULESITEAOTUOPEINIJICHANG','JBLSTATPNJC');
intercitys[809]=new Array('BNJ','波恩','BOEN','BE');
intercitys[810]=new Array('CPH','哥本哈根','GEBENHAGEN','GBHG');
intercitys[811]=new Array('DUS','杜塞尔多夫','DUSAIERDUOFU','DSEDF');
intercitys[812]=new Array('FRA','法兰克福','FALANKEFU','FLKF');
intercitys[813]=new Array('HAM','汗堡','HANBAO','HB');
intercitys[814]=new Array('HEL','赫尔辛基','HEXINJI','HEXJ');
intercitys[815]=new Array('IEV','基辅','JIFU','JF');
intercitys[816]=new Array('KBP','基辅 鲍里斯波尔机场','JIFUBAOLISIBOERJICHANG','JFBLSPEJC');
intercitys[817]=new Array('LBA','利兹','LIZI','LZ');
intercitys[818]=new Array('LON','伦敦','LUNDUN','LD');
intercitys[819]=new Array('LCY','伦敦城机场','LUNDUNCHENGJICHANG','LDCJC');
intercitys[820]=new Array('LGW','伦敦盖特维克机场','LUNDUNGAITEWEIKEJICHANG','LDGTWKJC');
intercitys[821]=new Array('LHR','伦敦希思罗机场','LUNDUNXISILUOJICHANG','LDXSLJC');
intercitys[822]=new Array('LTN','伦敦卢登机场','LUNDUNLUDENGJICHANG','LDLDJC');
intercitys[823]=new Array('LYS','里昂','LIANG','LA');
intercitys[824]=new Array('MAD','马德里','MADELI','MDL');
intercitys[825]=new Array('MAN','英国曼彻斯特','YINGGUOMANCHESITE','YGMCST');
intercitys[826]=new Array('MIL','米兰','MILAN','LM');
intercitys[827]=new Array('MXP','米兰马尔彭萨机场','MILANMAERPENGSAJICHANG','LMMEPSJC');
intercitys[828]=new Array('BGY','米兰贝加莫机场','MILANBEIJIAMOJICHANG','LMBJMJC');
intercitys[829]=new Array('MMA','马尔默','MAERMO','MEM');
intercitys[830]=new Array('MMX','马尔默 斯图鲁普机场','MAERMOSITULUPUJICHANG','MEMSTLPJC');
intercitys[831]=new Array('MOW','莫斯科','MOSIKE','MSK');
intercitys[832]=new Array('DME','莫斯科 德莫杰多沃国际机场','MOSIKEDEMOJIEDUOWOGUOJIJICHANG','MSKDMJDWGJJC');
intercitys[833]=new Array('SVO','莫斯科 谢列蔑契娃机场','MOSIKEXIELIEMIEQIEWAJICHANG','MSKXLMQWJC');
intercitys[834]=new Array('VKO','莫斯科 伏努科沃机场','MOSIKEFUNUKEWOJICHANG','MSKFNKWJC');
intercitys[835]=new Array('MUC','奥格斯堡','AOGESIBAO','AGSB');
intercitys[836]=new Array('AGB','慕尼黑','MUNIHEI','MNH');
intercitys[837]=new Array('OSL','奥斯陆','AOSILU','ASL');
intercitys[838]=new Array('PAR','巴黎','BALI','BL');
intercitys[839]=new Array('CDG','巴黎 戴高乐机场','BALIDAIGAOLEJICHANG','BLDGLJC');
intercitys[840]=new Array('ORY','巴黎 奥利机场','BALIAOLIJICHANG','BLALJC');
intercitys[841]=new Array('REK','雷克雅未克','LEIKEYAWEIKE','LKYWK');
intercitys[842]=new Array('KEF','雷克雅未克 凯夫拉维克国际机场','LEIKEYAWEIKEKAILAKEWEIKEGUOJIJICHANG','LKYWKKLKWKGJJC');
intercitys[843]=new Array('STO','斯德哥尔摩','SIDEGEERMO','SDGEM');
intercitys[844]=new Array('ARN','斯德哥尔摩 阿兰达机场','SIDEGEERMOALANDAJICHANG','SDGEMALDJC');
intercitys[845]=new Array('BMA','斯德哥尔摩 布罗马机场','SIDEGEERMOBULUOMAJICHANG','SDGEMBLMJC');
intercitys[846]=new Array('AAE','安纳巴','ANNABA','ANB');
intercitys[847]=new Array('ABV','阿布贾','ABUJIA','ABJ');
intercitys[848]=new Array('ACC','阿克拉','AKELA','AKL');
intercitys[849]=new Array('ADD','亚的斯亚贝巴','YADISIYABEIBA','YDSYBB');
intercitys[850]=new Array('AGA','阿加迪尔','AJIADIER','AJDE');
intercitys[851]=new Array('ALG','阿尔及尔','AERJIER','AEJE');
intercitys[852]=new Array('ALY','亚历山大','YALISHANDA','YLSD');
intercitys[853]=new Array('ATZ','阿西乌特','AXIWUTE','AXWT');
intercitys[854]=new Array('AXU','阿克苏姆','ASKESUMU','AKSM');
intercitys[855]=new Array('BEN','班加西','BANJIAXI','BJX');
intercitys[856]=new Array('BFN','布隆方舟','BULONGFANGZHOU','BLFZ');
intercitys[857]=new Array('BGF','班吉','BANJI','BJ');
intercitys[858]=new Array('BJL','班珠尔','BANZHUER','BZE');
intercitys[859]=new Array('BJM','布琼布拉','BUQIONGBULA','BQBL');
intercitys[860]=new Array('BJR','巴赫达尔','BAHEDAER','BHDE');
intercitys[861]=new Array('BKO','巴马科','BAMAKE','BMK');
intercitys[862]=new Array('BLZ','布兰太尔','BULANTAIER','BLTE');
intercitys[863]=new Array('BNI','贝宁城','BEININGCHENG','BNC');
intercitys[864]=new Array('BUQ','布拉瓦约','BULAWAYUE','BLWY');
intercitys[865]=new Array('BVC','博阿 维斯塔 拉比尔机场','BOAWEISITALABIERJICHANG','BAWSTLBEJC');
intercitys[866]=new Array('CAI','开罗','KAILUO','KL');
intercitys[867]=new Array('CBQ','卡拉巴尔','KALABAER','KLBE');
intercitys[868]=new Array('CKY','科纳克里','KENAKELI','KNKL');
intercitys[869]=new Array('CZL','君士坦丁','JUNSHITANDING','JSTD');
intercitys[870]=new Array('DAR','达累斯萨拉姆','DALEISISALAMU','DLSSLM');
intercitys[871]=new Array('DIR','德雷达瓦','DELEIDAWA','DLDW');
intercitys[872]=new Array('DLA','杜阿拉','DUSLA','DAL');
intercitys[873]=new Array('DSE','德西','DEXI','DX');
intercitys[874]=new Array('DUR','德班','DEBAN','DB');
intercitys[875]=new Array('ELS','东伦顿','DONGLUNDUN','DLD');
intercitys[876]=new Array('ENU','埃努古','AINUGU','ANG');
intercitys[877]=new Array('EUN','欧云','OUYUN','OY');
intercitys[878]=new Array('FEZ','非斯','FEISI','FS');
intercitys[879]=new Array('GBE','哈博罗内','HABOLUONEI','HBLN');
intercitys[880]=new Array('GDQ','贡达尔','GONGDAER','GDE');
intercitys[881]=new Array('GRJ','南非乔治敦','NANFEIQIAOZHIDUN','NFQZD');
intercitys[882]=new Array('HGA','哈尔格萨','HAERGESA','HEGS');
intercitys[883]=new Array('HRE','哈拉雷','HALALEI','HLL');
intercitys[884]=new Array('HRG','赫尔格达','HEERGEDA','HEGD');
intercitys[885]=new Array('HUE','胡梅拉','HUMEILA','HML');
intercitys[886]=new Array('IBA','伊巴丹','YIBADAN','YBD');
intercitys[887]=new Array('ILR','伊洛林','YILUOLIN','YLL');
intercitys[888]=new Array('JIB','吉布提','JIBUTI','JBT');
intercitys[889]=new Array('JIM','季马','JIMA','JM');
intercitys[890]=new Array('JOS','乔斯','QIAOSI','QS');
intercitys[891]=new Array('JRO','乞力马','QILIMA','QLM');
intercitys[892]=new Array('JUB','朱巴','ZHUBA','ZB');
intercitys[893]=new Array('KAD','卡杜纳','KADUNA','KDN');
intercitys[894]=new Array('KAN','卡诺','KANUO','KN');
intercitys[895]=new Array('KGL','基加利','JIJIALI','JJL');
intercitys[896]=new Array('KIS','基苏木','JISUMU','JSM');
intercitys[897]=new Array('KRT','咯土穆','GETUMU','GSM');
intercitys[898]=new Array('LAD','罗安达','LUOANDA','LAD');
intercitys[899]=new Array('LAQ','拜达','BAIDA','BD');
intercitys[900]=new Array('LAU','拉穆','LAMU','LM');
intercitys[901]=new Array('LBV','利伯维尔','LIBOWEIER','LBWE');
intercitys[902]=new Array('LFW','洛美','LUOMEI','LM');
intercitys[903]=new Array('LLI','拉里贝拉','LALIBEILA','LLBL');
intercitys[904]=new Array('LLW','利隆圭','LILONGGUI','LLG');
intercitys[905]=new Array('LOK','洛德瓦尔','LUODEWAER','LDWE');
intercitys[906]=new Array('LOS','拉各斯','LAGESI','LGS');
intercitys[907]=new Array('LUN','卢萨卡','LUSAKA','LSK');
intercitys[908]=new Array('LVI','利文斯通','LIWENSITONG','LWST');
intercitys[909]=new Array('LXR','卢克索','LUKESUO','LKS');
intercitys[910]=new Array('MBA','蒙巴萨','MENGBASA','MBS');
intercitys[911]=new Array('MGQ','摩加迪沙','MOJIADISHA','MJDS');
intercitys[912]=new Array('MPM','马普托','MAPUTUO','MPT');
intercitys[913]=new Array('MQX','默克莱','MOKELAI','MKL');
intercitys[914]=new Array('MRU','毛里求斯','MAOLIQIUSI','MLQS');
intercitys[915]=new Array('MSU','马塞卢','MASAILU','MSL');
intercitys[916]=new Array('MWZ','姆万扎','MUWANZHA','MWZ');
intercitys[917]=new Array('MYD','马林迪','MALINDI','MLD');
intercitys[918]=new Array('NDJ','恩甲美那','ENJIAMEINA','EJMN');
intercitys[919]=new Array('NIM','尼亚美','NIYAMEI','NYM');
intercitys[920]=new Array('NKC','努瓦科肖特','NVWAKEXIAOTE','EDL');
intercitys[921]=new Array('NLA','恩多拉','ENDUOLA','EDL');
intercitys[922]=new Array('ORN','奥兰','AOLAN','AL');
intercitys[923]=new Array('OUA','瓦加杜古','WAJIADUGU','WJDG');
intercitys[924]=new Array('OUD','乌杰达','WUJIEDA','WJD');
intercitys[925]=new Array('PHC','哈科特港','HAKETEGANG','HKTG');
intercitys[926]=new Array('PLZ','伊丽莎白港','YILISHABAIGANG','YLSBG');
intercitys[927]=new Array('POL','彭巴','PENGBA','PB');
intercitys[928]=new Array('PZB','彼得马里茨堡','BIDEMALICIBAO','BDMLCB');
intercitys[929]=new Array('PZU','苏丹港','SUDANGANG','SDG');
intercitys[930]=new Array('RAI','普拉亚','PULAYA','PLY');
intercitys[931]=new Array('RAK','马拉喀什','MALAKASHI','MLKS');
intercitys[932]=new Array('RBA','拉巴特','LABATE','LBT');
intercitys[933]=new Array('RCB','里查兹贝','LICHACIBEI','LCCB');
intercitys[934]=new Array('SID','撒尔','SAER','SE');
intercitys[935]=new Array('SKO','索科托','SUOKETUO','SKT');
intercitys[936]=new Array('SSG','马拉博','MALABO','MLB');
intercitys[937]=new Array('SSH','沙姆沙伊赫湾','SHAMUSHAYIHEWAN','SMSYHW');
intercitys[938]=new Array('TNR','塔拿那利佛','TANANALIFO','TNNLF');
intercitys[939]=new Array('UTN','阿平顿','APINGDUN','APD');
intercitys[940]=new Array('ZNZ','桑给巴尔','SANGGEIBAER','SGBE');
intercitys[941]=new Array('CAS','卡萨布兰卡','KASABULANKA','KSBLK');
intercitys[942]=new Array('CMN','卡萨布兰卡穆罕默德机场','KASABULANKAMUHANMODEJICHANG','KSBLKMHMDJC');
intercitys[943]=new Array('CPT','开普敦','KAIPUDUN','KPD');
intercitys[944]=new Array('EBB','恩德培','ENDEPEI','EDP');
intercitys[945]=new Array('FNA','弗里敦','FOLIDUN','FLD');
intercitys[946]=new Array('JNB','约翰内斯堡','YUEHANNEISIBAO','YHNSB');
intercitys[947]=new Array('MLW','蒙罗维亚','MENGLUOWEIYA','MLWY');
intercitys[948]=new Array('ROB','蒙罗维亚罗伯茨国际机场','MENGLUOWEIYALUOBOCIGUOJIJICHANG','MLWYLBCGJJC');
intercitys[949]=new Array('NBO','内罗毕','NEIHUABI','NLB');
intercitys[950]=new Array('TET','太特','TAITE','TT');
intercitys[951]=new Array('YVA','莫罗尼','MOLUONI','MLN');
intercitys[952]=new Array('HAH','莫罗尼国际机场','MOLUONIGUOJIJICHANG','MLNGJJC');
intercitys[953]=new Array('ABX','奥尔伯里','AOERBOLI','AELD');
intercitys[954]=new Array('ADL','阿得莱德','ADELAIDE','ADLD');
intercitys[955]=new Array('ALH','澳大利亚奥尔巴尼','AODALIYAAOERBANI','ADLYAEBN');
intercitys[956]=new Array('ARM','阿米代尔','AMIDAIER','MADE');
intercitys[957]=new Array('ASP','艾利斯斯普林斯','AILISISIPULINSI','ALSSPLS');
intercitys[958]=new Array('AVV','墨尔本阿瓦伦机场','MOERBENAWALUNJICHANG','MEBAWLJC');
intercitys[959]=new Array('AYQ','艾尔斯岩','AIERSIYAN','AESY');
intercitys[960]=new Array('BDB','邦达伯格','BANGDABOGE','BDBG');
intercitys[961]=new Array('BHE','布连海姆','BULIANHAIMU','BLHM');
intercitys[962]=new Array('BME','布鲁姆','BULUMU','BLM');
intercitys[963]=new Array('BNE','布里斯班','BULISIBAN','BLSB');
intercitys[964]=new Array('BNK','巴利那','BALINA','BLN');
intercitys[965]=new Array('CBR','堪培拉','KANPEILA','KPL');
intercitys[966]=new Array('CFS','科夫斯港','KEFUSIGANG','KFSG');
intercitys[967]=new Array('CNJ','克朗克里','KELANGKELI','KLKL');
intercitys[968]=new Array('CNS','凯恩斯','KAIENSI','KES');
intercitys[969]=new Array('CTL','查理维尔','CHALIWEIER','CLWE');
intercitys[970]=new Array('DBO','达博','DABO','DB');
intercitys[971]=new Array('DPO','德文波特','DEWENBOTE','DWBT');
intercitys[972]=new Array('DRW','达尔文','DAERWEN','DEW');
intercitys[973]=new Array('DUD','达尼丁','DANIDING','DND');
intercitys[974]=new Array('EMD','埃默拉尔德','AIMOLAERDE','AMLED');
intercitys[975]=new Array('GIS','吉斯伯恩','JISIBOEN','JSBE');
intercitys[976]=new Array('HBA','霍巴特','HUOBATE','HBT');
intercitys[977]=new Array('HIS','海曼岛','HAIMANDAO','HMD');
intercitys[978]=new Array('HKK','霍基蒂卡','HUOJIDIKA','HJDK');
intercitys[979]=new Array('HLZ','汉米尔顿','HANMIERDUN','HMED');
intercitys[980]=new Array('HTI','哈密尔顿岛','HAMIERDUNDAO','HMEDD');
intercitys[981]=new Array('HVB','赫维湾','HEWEIWAN','HWW');
intercitys[982]=new Array('ISA','芒特艾萨','MANGTEAISA','MTAS');
intercitys[983]=new Array('IVC','因佛卡吉尔','YINFOKAJIER','YFKJE');
intercitys[984]=new Array('KAT','凯塔依亚','KAITAYIYA','KTYY');
intercitys[985]=new Array('KFG','卡尔库龙','KAERKULON','KEKL');
intercitys[986]=new Array('KGI','卡尔古利','KAERGULI','KEGL');
intercitys[987]=new Array('KKE','凯里凯里','KAILIKAILI','KLKL');
intercitys[988]=new Array('KNX','库努纳拉','KUNUNALA','KNNL');
intercitys[989]=new Array('KTA','卡拉特哈','KALATEHA','KLTH');
intercitys[990]=new Array('LEA','利尔蒙斯','LIERMENGSI','LEMS');
intercitys[991]=new Array('MCY','马鲁奇多','MALUQIDUO','MLQD');
intercitys[992]=new Array('MKR','米卡萨拉','MAKASALA','MKSL');
intercitys[993]=new Array('MKY','麦凯','MAIKAI','MK');
intercitys[994]=new Array('MOV','穆兰巴赫','MULANBAHE','MLBH');
intercitys[995]=new Array('MQL','米尔迪拉','MIERDILA','MEDL');
intercitys[996]=new Array('MRO','马斯特顿','MASITEDUN','MSTD');
intercitys[997]=new Array('NAN','楠迪','NANDI','ND');
intercitys[998]=new Array('NLF','达恩利岛','DAENLIDAO','DELD');
intercitys[999]=new Array('NPE','纳皮尔','NAPIER','NPE');
intercitys[1000]=new Array('NPL','新普里茅茨','XINPULIMAOCI','XPLMC');
intercitys[1001]=new Array('NTL','澳大利亚纽卡斯尔','AODALIYANIUKASIER','ADLYNKSE');
intercitys[1002]=new Array('OOL','黄金海岸','HUANGJINHAIAN','HJHA');
intercitys[1003]=new Array('PBO','帕拉布尔杜','PALABUERDU','PLBUERDU');
intercitys[1004]=new Array('PER','珀斯','POSI','PS');
intercitys[1005]=new Array('PMR','北帕默斯顿','BEIPAMOSIDUN','BPMSD');
intercitys[1006]=new Array('PNP','波蓬德塔','BOPENGDETA','BPDT');
intercitys[1007]=new Array('POM','泊特莫尔斯比港','BOTEMOERSIBIGANG','BTMESBG');
intercitys[1008]=new Array('PPP','普罗瑟派恩','PULUOSEPAIEN','PLSPE');
intercitys[1009]=new Array('PQQ','麦夸里港','MAIKUALIGANG','KKLG');
intercitys[1010]=new Array('ROK','罗克汉普顿','LUOKEHANPUDUN','LKHPD');
intercitys[1011]=new Array('ROT','罗托鲁瓦','LUOTUOLUWA','LTLW');
intercitys[1012]=new Array('TIU','蒂马鲁','DIMALU','DIMALU');
intercitys[1013]=new Array('WLG','惠灵顿','HUILINGDUN','HLD');
intercitys[1014]=new Array('ZQN','昆斯敦','KUNSIDUN','KSD');
intercitys[1015]=new Array('AKL','奥克兰','AOKELAN','AKL');
intercitys[1016]=new Array('MEL','墨尔本','MOERBEN','MEB');
intercitys[1017]=new Array('SYD','悉尼','XINI','XN');
intercitys[1018]=new Array('ABE','阿伦敦','ALUNDUN','ALD');
intercitys[1019]=new Array('ABQ','阿尔伯克基','AERBOKEJI','AEBKJ');
intercitys[1020]=new Array('ABR','美国阿伯丁','MEIGUOABIDING','MGALB');
intercitys[1021]=new Array('ACA','阿卡普尔科','AKAPUERKE','AKPEK');
intercitys[1022]=new Array('ACK','南塔基特岛','NANTAJITEDAO','NTJTD');
intercitys[1023]=new Array('AGU','阿瓜斯卡连特斯','AGUASIKALIANTESI','AGSKLTS');
intercitys[1024]=new Array('AIA','阿莱恩斯','ALAIENSI','ALES');
intercitys[1025]=new Array('AKN','金萨蒙','JINSAMENG','JSM');
intercitys[1026]=new Array('ALB','美国奥尔巴尼','MEIGUOAOERBANI','MGAEBN');
intercitys[1027]=new Array('ALO','滑铁卢','HUATIELU','HTL');
intercitys[1028]=new Array('ALS','阿拉莫萨','ALAMOSA','ALMS');
intercitys[1029]=new Array('ALW','瓦拉瓦','WALAWA','WLW');
intercitys[1030]=new Array('ANI','阿尼亚克','ANIYAKE','ANYK');
intercitys[1031]=new Array('AOO','阿尔托纳','AERTUONA','AETN');
intercitys[1032]=new Array('ART','沃特敦','WOTEDUN','WTD');
intercitys[1033]=new Array('ASE','阿斯彭','ASIPENG','ASP');
intercitys[1034]=new Array('ATW','阿普尔顿','APUDEDUN','APSD');
intercitys[1035]=new Array('AVL','阿什维尔','ASHIWEIER','ASWE');
intercitys[1036]=new Array('AZO','卡拉马祖','KALAMAZU','KLMZ');
intercitys[1037]=new Array('BFF','斯科茨布拉夫','SIKECIBULAFU','SKCBLF');
intercitys[1038]=new Array('BFL','贝克斯菲尔德','BEIKESIFEIERDE','BKSFED');
intercitys[1039]=new Array('BGM','比尼古尼','BINIGUNI','BNGN');
intercitys[1040]=new Array('BGR','班戈','BANGE','BG');
intercitys[1041]=new Array('BHB','巴港','BAGANG','BG');
intercitys[1042]=new Array('BHM','美国伯明翰','MEIGUOBOMINGHAN','MGBMH');
intercitys[1043]=new Array('BIL','比灵斯','BILINGSI','BLS');
intercitys[1044]=new Array('BIS','俾斯麦','BISIMAI','BSM');
intercitys[1045]=new Array('BJX','莱昂','LAIANG','LA');
intercitys[1046]=new Array('BLI','贝灵厄姆','BEILINGEMU','BLEM');
intercitys[1047]=new Array('BMI','布卢明顿诺马尔','BULUMINGDUNNUOMAER','BLMDNME');
intercitys[1048]=new Array('BNA','纳什维尔','NASHIWEIER','NSWE');
intercitys[1049]=new Array('BOI','博伊西','BOYIXI','BYX');
intercitys[1050]=new Array('BQN','阿瓜迪亚','AGUADIYA','AGDY');
intercitys[1051]=new Array('BRO','布朗斯维尔','BULANGSIWEIER','BLSWE');
intercitys[1052]=new Array('BTM','比尤特','BIYOUTE','BYT');
intercitys[1053]=new Array('BTR','巴吞鲁日','BATUNLURI','BTLR');
intercitys[1054]=new Array('BTV','伯灵顿','BOLINGDUN','BLD');
intercitys[1055]=new Array('BUF','布法罗','BUFALUO','BFL');
intercitys[1056]=new Array('BUR','伯班克','BOBANKE','BBK');
intercitys[1057]=new Array('BWI','巴尔的摩','BAERDIMO','BEDM');
intercitys[1058]=new Array('BZN','博兹曼','BOCIMAN','BCM');
intercitys[1059]=new Array('CAY','卡宴','KAYAN','KY');
intercitys[1060]=new Array('CDB','科尔德湾','KEERDEWAN','KEDW');
intercitys[1061]=new Array('CDC','锡达城','XIDACHENG','XDC');
intercitys[1062]=new Array('CDR','沙德伦','SHADELUN','SDL');
intercitys[1063]=new Array('CEN','欧布雷贡城','OUBULEIGONGCHENG','OBLGC');
intercitys[1064]=new Array('CEZ','科特斯','KETESI','KTS');
intercitys[1065]=new Array('CHA','查塔努加','CHATANUJIA','CTNJ');
intercitys[1066]=new Array('CHO','夏洛茨维尔','WANGLUOCIWEIER','XLCWE');
intercitys[1067]=new Array('CIC','奇科','QIKE','QK');
intercitys[1068]=new Array('CID','锡达拉皮兹','XIDALAPICI','XDLPC');
intercitys[1069]=new Array('CIL','康瑟尔','KANGSEER','KSE');
intercitys[1070]=new Array('CJS','华雷斯城','HUALEISICHENG','HLSC');
intercitys[1071]=new Array('CKB','克拉克斯堡','KELAKESIBAO','KLKSB');
intercitys[1072]=new Array('CLD','圣迭戈','SHENGDIEGE','SDG');
intercitys[1073]=new Array('CLL','克利奇站','KELIQIZHAN','KLQZ');
intercitys[1074]=new Array('CLQ','科利马','KELIMA','KLM');
intercitys[1075]=new Array('CLT','夏洛特','XIALUOTE','XLT');
intercitys[1076]=new Array('CMI','尚佩恩','SHANGPEIEN','SPE');
intercitys[1077]=new Array('CMX','汉考克','HANKAOKE','HKK');
intercitys[1078]=new Array('CNY','莫阿布','MOABU','MAB');
intercitys[1079]=new Array('COU','密苏里州哥伦比亚','MISULIZHOUGELUNBIYA','MSLZGLBY');
intercitys[1080]=new Array('CPE','坎佩切','KANPEIQIE','KPQ');
intercitys[1081]=new Array('CPR','卡斯珀','KASIPO','KSP');
intercitys[1082]=new Array('CUL','库利阿坎','KULIAKAN','KLAK');
intercitys[1083]=new Array('CUN','砍昆','KANKUN','KK');
intercitys[1084]=new Array('CUU','奇瓦瓦','QIWAWA','QWW');
intercitys[1085]=new Array('CVG','辛辛那提','XINXINNATI','XXNT');
intercitys[1086]=new Array('CZM','科苏梅尔','KESUMEIER','KSME');
intercitys[1087]=new Array('DAB','代托纳比奇','DAITUONABIQI','DTNBQ');
intercitys[1088]=new Array('DBQ','迪比克','DIBIKE','DBK');
intercitys[1089]=new Array('DDC','道奇城','DAOQICHENG','DQC');
intercitys[1090]=new Array('DFW','达拉斯','DALASI','DLS');
intercitys[1091]=new Array('DGO','墨西哥杜兰戈','MOXIGEDULANGE','MXGDLG');
intercitys[1092]=new Array('DHN','多森','DUOSEN','DS');
intercitys[1093]=new Array('DSM','得梅因','DEMEIYIN','DMY');
intercitys[1094]=new Array('DUJ','杜波依斯','DUBOYISI','DBYS');
intercitys[1095]=new Array('EAR','卡尼','KANI','KN');
intercitys[1096]=new Array('EAT','文纳奇','WENNAQI','WNQ');
intercitys[1097]=new Array('EAU','欧克莱尔','OUKELAIER','OKLE');
intercitys[1098]=new Array('ELD','埃尔多拉多','AIERDUOLADUO','AEDLD');
intercitys[1099]=new Array('ELM','埃尔迈拉','AIERMAILA','AEML');
intercitys[1100]=new Array('ERI','伊利','YILI','YL');
intercitys[1101]=new Array('EUG','尤金','YOUJIN','YJ');
intercitys[1102]=new Array('EVV','埃文斯维尔','AIWENSIWEIER','AWSWE');
intercitys[1103]=new Array('EWB','新贝德福德','XINBEIDEFUDE','XBDFD');
intercitys[1104]=new Array('EWN','纽伯尔尼','NIUBOERNI','NBEN');
intercitys[1105]=new Array('FAR','法戈','FAGE','FG');
intercitys[1106]=new Array('FCA','卡利斯佩尔','KALISIPEIER','KLSPE');
intercitys[1107]=new Array('FMN','法明顿','FAMINGDUN','FMD');
intercitys[1108]=new Array('FNT','弗林特','FULINTE','FLT');
intercitys[1109]=new Array('FPO','弗里波特','FULIBOTE','FLBT');
intercitys[1110]=new Array('FSD','苏福尔斯','SUFUERSI','SFES');
intercitys[1111]=new Array('FSM','史密斯堡','SHIMISIBAO','SMSB');
intercitys[1112]=new Array('FYV','费耶特维尔 卡肯色州','FEIYETEWEIERAKENSEZHOU','FYTWEAKSZ');
intercitys[1113]=new Array('GBD','大本德','DABENDE','DBD');
intercitys[1114]=new Array('GCC','吉勒台','JILIETAI','JLT');
intercitys[1115]=new Array('GFK','大福克斯','DAFUKESI','DFKS');
intercitys[1116]=new Array('GJT','大章克申','DAZHANGKESHEN','DZKS');
intercitys[1117]=new Array('GNV','盖恩斯维尔','GAIENSIWEIER','GESWE');
intercitys[1118]=new Array('GRB','格林贝','GELINBEI','GLB');
intercitys[1119]=new Array('GRI','格兰德岛','GELANDEDAO','GLDD');
intercitys[1120]=new Array('GRR','大急流域','DAJILIUYU','DJLY');
intercitys[1121]=new Array('GSO','格林斯伯勒','GELINSIBOLE','GLSBL');
intercitys[1122]=new Array('GSP','格林威尔','GELINWEIER','GLWE');
intercitys[1123]=new Array('GTR','哥伦布金三角机场','GELUNBUJINSANJIAOJICHANG','GLBJSJJC');
intercitys[1124]=new Array('GUA','危地马拉城','WEIDIMALACHENG','WDMLC');
intercitys[1125]=new Array('HAV','哈瓦那','HAWANA','HWN');
intercitys[1126]=new Array('HFD','哈特福德','HATEFUDE','HTFD');
intercitys[1127]=new Array('HGR','黑格斯敦','HEIGESIDUN','HGSD');
intercitys[1128]=new Array('HHH','希尔顿黑德','XIERDUNHEIDE','XEDHD');
intercitys[1129]=new Array('HMO','埃莫西约','AIMOXIYUE','AMXY');
intercitys[1130]=new Array('HNH','胡纳','HUNA','HN');
intercitys[1131]=new Array('HNS','哈伊尼斯','HAYINISI','AYNS');
intercitys[1132]=new Array('HOG','奥尔金','AOERJIN','AEJ');
intercitys[1133]=new Array('HOM','荷马','HEMA','HM');
intercitys[1134]=new Array('HON','休伦','XIULUN','XL');
intercitys[1135]=new Array('HOT','温泉','WENQUAN','WQ');
intercitys[1136]=new Array('HPN','维斯特切斯特郡','WEISITEQIESITEJUN','WSTQSTJ');
intercitys[1137]=new Array('HRL','哈灵根','HALINGGEN','HLG');
intercitys[1138]=new Array('HRO','哈里森','HALISEN','HLS');
intercitys[1139]=new Array('HSV','汉斯威尔','HANSIWEIER','HSWE');
intercitys[1140]=new Array('HTS','亨廷顿','HENGTINGDUN','HTD');
intercitys[1141]=new Array('HUX','圣克鲁斯华图考','SHENGKELUSIHUATUKAO','SKLSHTK');
intercitys[1142]=new Array('HVN','纽黑文','NUIHEIWEN','NHW');
intercitys[1143]=new Array('HYA','海恩尼斯','HAIENNISI','HENS');
intercitys[1144]=new Array('HYS','海斯','HAISI','HS');
intercitys[1145]=new Array('IAG','尼亚加拉瀑布','NIYAJIALAPUBU','NYJLPB');
intercitys[1146]=new Array('IDA','爱达荷福尔斯','AIDEHEFUERSI','ADHFES');
intercitys[1147]=new Array('IGM','金曼','JINMAN','JM');
intercitys[1148]=new Array('ILG','威尔明顿特拉华州','WEIWEMINGDUNTELAHUAZHOU','WEMDTLHZ');
intercitys[1149]=new Array('ILM','威尔明顿北卡罗莱纳州','WEIWEMINGDUNBEIKALUOLAINAZHOU','WEMDBKLLNZ');
intercitys[1150]=new Array('IPL','因皮里尔','YINPILIER','YPLE');
intercitys[1151]=new Array('IPT','威廉斯波特','WEILIANSIBOTE','WLSBT');
intercitys[1152]=new Array('ISN','威利斯顿','WEILISIDUN','WLSD');
intercitys[1153]=new Array('ISP','艾斯利普','AISILIPU','ASLP');
intercitys[1154]=new Array('ITH','伊萨卡','YISAKA','YSK');
intercitys[1155]=new Array('ITO','希洛','XILUO','XL');
intercitys[1156]=new Array('JAC','杰克逊 怀俄明州','JIEKEXUNHUAIEMINGZHOU','JKXHEMZ');
intercitys[1157]=new Array('JLN','乔普林','QIAOPULIN','QPL');
intercitys[1158]=new Array('JPD','帕萨迪纳','PASADINA','PSDN');
intercitys[1159]=new Array('JST','约翰斯顿','YUEHANSIDUN','YHSD');
intercitys[1160]=new Array('KOA','科纳','KENA','KN');
intercitys[1161]=new Array('LAN','兰辛','LANXIN','LX');
intercitys[1162]=new Array('LAP','墨西哥拉巴斯','MOXIGELABASI','MXGBLS');
intercitys[1163]=new Array('LBE','拉特罗布','LATELUOBU','LTLB');
intercitys[1164]=new Array('LBF','北普拉特','BEIPULATE','BPLT');
intercitys[1165]=new Array('LCH','莱克查尔斯','LAIKECHAERSI','LKCES');
intercitys[1166]=new Array('LEB','莱巴嫩','LAIBANEN','LBN');
intercitys[1167]=new Array('LEX','莱克星顿','LAIKEXINGDUN','LKXD');
intercitys[1168]=new Array('LFT','拉菲特','LAFEITE','LFT');
intercitys[1169]=new Array('LIH','考爱岛','KAOAIDAO','KAD');
intercitys[1170]=new Array('LMM','洛斯莫奇斯','LUOSIMOQISI','LSMQS');
intercitys[1171]=new Array('LMT','克拉马斯福尔斯','KELAMASIFUERSI','KLMSFES');
intercitys[1172]=new Array('LNK','林肯','LINKEN','LK');
intercitys[1173]=new Array('LNY','拉奈','LANAI','LN');
intercitys[1174]=new Array('LRM','拉罗马纳','LALUOMANA','LLMN');
intercitys[1175]=new Array('LSE','拉克鲁斯','LAKELUSI','LKLS');
intercitys[1176]=new Array('LWB','刘易斯堡','LIUYISIBAO','LYSB');
intercitys[1177]=new Array('LWS','刘易斯顿','LIUYISIDUN','LYSD');
intercitys[1178]=new Array('LYH','林奇堡','LINQIBAO','LQB');
intercitys[1179]=new Array('MAF','米德兰','MIDELAN','MDL');
intercitys[1180]=new Array('MAM','马塔莫罗斯','MATAMOLUOSI','MTMLS');
intercitys[1181]=new Array('MAZ','马亚奎兹','MAYAKUICI','MYKZ');
intercitys[1182]=new Array('MBJ','蒙特哥贝','MENGTEGEBEI','MTGB');
intercitys[1183]=new Array('MCG','麦格拉斯','MAIGELASI','MGLS');
intercitys[1184]=new Array('MCK','麦库克','MAIKUKE','MKK');
intercitys[1185]=new Array('MEM','孟菲斯','MENGFEISI','MFS');
intercitys[1186]=new Array('MFE','迈克艾伦','MAIKEAILUN','MKAL');
intercitys[1187]=new Array('MFR','梅德福','MEIDEFU','MDF');
intercitys[1188]=new Array('MGW','摩根敦','MOGENDUN','MGD');
intercitys[1189]=new Array('MHK','曼哈顿','MANHADUN','MHD');
intercitys[1190]=new Array('MHT','美国曼彻斯特','MEIGUOMANCHESITE','MGMCST');
intercitys[1191]=new Array('MID','梅里达','MEILIDA','MLD');
intercitys[1192]=new Array('MKG','马斯基根','MASIJIGEN','MSJG');
intercitys[1193]=new Array('MKK','霍奥莱胡阿','HUOAOLAIHUA','HALHA');
intercitys[1194]=new Array('MKL','杰克逊 田纳西州','JIEKEXUNTIANNAXIZHOU','JKXHNXZ');
intercitys[1195]=new Array('MLB','美国墨尔本','MEIGUOMOERBEN','MGMEB');
intercitys[1196]=new Array('MMH','马默思莱克斯','MAMOSILAIKESI','MAMSLKS');
intercitys[1197]=new Array('MQT','马凯特','MAKAITE','MKT');
intercitys[1198]=new Array('MRY','蒙特雷','MENGTELEI','MTL');
intercitys[1199]=new Array('MSL','马斯尔肖尔斯','MASIERXIAOERSI','MSEXES');
intercitys[1200]=new Array('MSN','麦迪逊','MAIDIXUN','MDX');
intercitys[1201]=new Array('MSO','米苏拉','MISULA','MSL');
intercitys[1202]=new Array('MSP','明尼阿波利斯','MINGNIABOLISI','MNABLS');
intercitys[1203]=new Array('MSS','马塞纳','MASAINA','MSN');
intercitys[1204]=new Array('MTJ','蒙特罗斯','MENGTELUOSI','MTLS');
intercitys[1205]=new Array('MTT','米纳蒂特兰','MINADITELAN','MNDTL');
intercitys[1206]=new Array('MVY','马萨葡萄园','MASAPUTAOYUAN','MSPTY');
intercitys[1207]=new Array('MYR','默特尔比奇','MOTEERBIQI','MTEBQ');
intercitys[1208]=new Array('MZT','马萨特蓝','MASATELAN','MSTL');
intercitys[1209]=new Array('OAJ','杰克逊维尔 北卡罗莱纳州','JIEKEXUNWEIER BEIKALUOLAINAZHOU','JKXWEBKLLNZ');
intercitys[1210]=new Array('OAX','瓦哈卡','WAHAKA','WHK');
intercitys[1211]=new Array('OGG','卡胡卢伊','KAHULUYI','KHLY');
intercitys[1212]=new Array('OGS','奥格登斯堡','AOGEDENGSIBAO','AGDSB');
intercitys[1213]=new Array('OME','诺姆','NUOMU','NM');
intercitys[1214]=new Array('ORH','伍斯特','WUSITE','WST');
intercitys[1215]=new Array('OTH','北本德','BEIBENDE','BBD');
intercitys[1216]=new Array('OTZ','科策布','KECEBU','KCB');
intercitys[1217]=new Array('OWB','欧文斯伯勒','OUWENSIBOLE','OWSBL');
intercitys[1218]=new Array('PAH','帕迪尤卡','PADIYOUKA','PDYK');
intercitys[1219]=new Array('PAP','太子港','TAIZIGANG','TZG');
intercitys[1220]=new Array('PAZ','波萨里卡德伊达尔戈','BOSALIKADEYIDAERGE','BSLKDYDEG');
intercitys[1221]=new Array('PBC','普埃布拉','PUAIBULA','PABL');
intercitys[1222]=new Array('PDT','彭德尔顿','PENGDEERDUN','PDED');
intercitys[1223]=new Array('PGA','佩奇','PEIQI','PQ');
intercitys[1224]=new Array('PGD','蓬塔戈尔达','PENGTAGEERDA','PTGED');
intercitys[1225]=new Array('PGV','格林维尔','GELINWEIER','GLWE');
intercitys[1226]=new Array('PHF','汗普顿','HANPUDUN','HPD');
intercitys[1227]=new Array('PIA','皮奥里亚','PIAOLIYA','PALY');
intercitys[1228]=new Array('PIH','波卡特洛','BOKATELUO','BKTL');
intercitys[1229]=new Array('PIR','皮尔','PIER','PE');
intercitys[1230]=new Array('POP','普拉塔港','PULATAGANG','PLTG');
intercitys[1231]=new Array('PQM','帕伦克','PALUNKE','PLK');
intercitys[1232]=new Array('PRC','普雷斯科特','PULEISIKETE','PLSKT');
intercitys[1233]=new Array('PSC','帕斯科','PASIKE','PSK');
intercitys[1234]=new Array('PSE','蓬塞','PENGSAI','PS');
intercitys[1235]=new Array('PSG','彼得斯堡','BIDESIBAO','BDSB');
intercitys[1236]=new Array('PSM','普茨茅斯','PUCIMAOSI','PCMS');
intercitys[1237]=new Array('PUB','普韦布洛','PUWEIBULUO','PWBL');
intercitys[1238]=new Array('PUJ','蓬塔卡纳','PENGTAKANA','PTKN');
intercitys[1239]=new Array('PUW','普尔曼','PUERMAN','PEM');
intercitys[1240]=new Array('PVC','普罗温斯敦','PULUOWENSIDUN','PLWSD');
intercitys[1241]=new Array('PVD','普罗维登斯','PULUOWEIDENGSI','PLWDS');
intercitys[1242]=new Array('PVR','巴亚尔塔港','BAYAERTAGANG','BYRTG');
intercitys[1243]=new Array('PVU','普罗沃','PULUOWO','PLW');
intercitys[1244]=new Array('PWM','波特兰','BOTELAN','BTL');
intercitys[1245]=new Array('RDD','雷丁','LEIDING','LD');
intercitys[1246]=new Array('RDM','雷德蒙德','LEIDEMENGDE','LDMD');
intercitys[1247]=new Array('RDU','罗利','LUOLI','LL');
intercitys[1248]=new Array('REX','雷诺萨','LEINUOSA','LNS');
intercitys[1249]=new Array('RIW','里弗顿','LIFEIDUN','LFD');
intercitys[1250]=new Array('RKD','罗克兰','LUOKELAN','LKL');
intercitys[1251]=new Array('RNO','里诺','LINUO','LN');
intercitys[1252]=new Array('ROA','罗阿诺克','LUOANUOKE','LANK');
intercitys[1253]=new Array('ROC','罗切斯特','LUOQIESITE','LQST');
intercitys[1254]=new Array('RUT','拉特兰','LATELAN','LTL');
intercitys[1255]=new Array('SAL','圣萨尔瓦多','SHENGSAERWADUO','SSEWD');
intercitys[1256]=new Array('SAP','圣佩德罗苏拉','SHENGPEIDELUOSULA','SPDLSL');
intercitys[1257]=new Array('SBN','南本德','NANBENDE','NBD');
intercitys[1258]=new Array('SCE','斯泰特科利奇','SITAITEKELIQI','STTKLQ');
intercitys[1259]=new Array('SDQ','圣多明戈','SHENGDUOMINGGE','SDMG');
intercitys[1260]=new Array('SGF','斯普林菲尔德 密苏里州','SIPULINFEIERDEMISULIZHOU','SPLFEDMSLZ');
intercitys[1261]=new Array('SHR','谢里丹','XIELIDAN','XLD');
intercitys[1262]=new Array('SJC','美国圣何塞','MEIGUOSHENGHESAI','MGSHS');
intercitys[1263]=new Array('SLC','盐湖城','YANHUCHENG','YHC');
intercitys[1264]=new Array('SLK','萨拉纳克莱克','SALANAKELAIKE','SLNKLK');
intercitys[1265]=new Array('SLP','圣路易斯波托西','SHENGLUYISIBOTUOXI','SLYSBTX');
intercitys[1266]=new Array('SLW','萨尔蒂洛','SAERDILUO','SEDL');
intercitys[1267]=new Array('SMX','美国圣马丽亚','MEIGUOSHENGMALIYA','MGSMLY');
intercitys[1268]=new Array('SPI','斯普林菲尔德 伊利诺伊州','SIPULINFEIERDE YILINUOYIZHOU','SPLFEDYLNYZ');
intercitys[1269]=new Array('STI','多米尼加 圣地亚哥','DUOMINIJIASHENGDIYAGE','DMNJSDYG');
intercitys[1270]=new Array('STP','巴西圣保罗','BAXISHENGBAOLUO','BXSBL');
intercitys[1271]=new Array('STS','圣罗莎','SHENGLUOSHA','SLS');
intercitys[1272]=new Array('SYR','锡拉丘兹','XILAQIUZI','XLQC');
intercitys[1273]=new Array('TAM','坦皮科','TANPIKE','TPK');
intercitys[1274]=new Array('TAP','塔帕丘拉','TAPAQIULA','TPQL');
intercitys[1275]=new Array('TIJ','蒂华纳','DIHUANA','DHN');
intercitys[1276]=new Array('TTN','特伦顿','TELUNDUN','TLD');
intercitys[1277]=new Array('TUP','吐丕洛','TUPEILUO','TPL');
intercitys[1278]=new Array('TYS','诺克斯威尔','NUOKESIWEIER','NKSWE');
intercitys[1279]=new Array('VIS','维塞利亚','WEISAILIYA','WSLY');
intercitys[1280]=new Array('VRA','瓦拉德','WALADE','WLD');
intercitys[1281]=new Array('VSA','比亚埃尔莫萨','BIYAAIERMOSA','BYAEMS');
intercitys[1282]=new Array('YBR','布兰顿','BULANDUN','BLD');
intercitys[1283]=new Array('YDF','鹿湖','LUHU','LH');
intercitys[1284]=new Array('YFC','弗雷德里克顿','FEILEIDELIKEDUN','FLDLKD');
intercitys[1285]=new Array('YGK','金斯顿','JINSIDUN','JSD');
intercitys[1286]=new Array('YKA','坎卢普斯','KANLUPUSI','KLPS');
intercitys[1287]=new Array('YMM','福麦木瑞','FUMAIMURUI','FMMR');
intercitys[1288]=new Array('YNG','扬斯敦','YANGSIDUN','YSD');
intercitys[1289]=new Array('YQR','里贾纳','LIJIANA','LJN');
intercitys[1290]=new Array('YQU','大草原城','DACAOYUANCHENG','DCYC');
intercitys[1291]=new Array('YXE','萨斯卡通','SASIKATONG','SSKT');
intercitys[1292]=new Array('YXH','梅迪辛哈特','MEIDIXINHATE','MDXHT');
intercitys[1293]=new Array('YYC','卡尔加里','KAERJIALI','KEJL');
intercitys[1294]=new Array('YYG','夏洛特敦','XIALUOTEDUN','XLTD');
intercitys[1295]=new Array('ZLO','曼萨尼略','MANSANILUE','MSNL');
intercitys[1296]=new Array('ABI','阿比林','ABILIN','ABL');
intercitys[1297]=new Array('ACT','韦科','WEIKE','WK');
intercitys[1298]=new Array('ADQ','科迪亚克','KEDIYAKE','KDYK');
intercitys[1299]=new Array('AUG','奥古斯塔','AOGUSITA','AGST');
intercitys[1300]=new Array('AIY','大西洋城','DAXIYANGCHENG','DXYC');
intercitys[1301]=new Array('ACY','大西洋城国际机场','DAXIYANGCHENGGUOJIJICHANG','DXYCGJJC');
intercitys[1302]=new Array('AMA','阿马里洛','AMALILUO','AMLL');
intercitys[1303]=new Array('ANC','安克雷奇','ANKELEIQI','AKLQ');
intercitys[1304]=new Array('ATL','亚特兰大','YATELANDA','YTLD');
intercitys[1305]=new Array('AUS','奥斯汀','AOSITING','AST');
intercitys[1306]=new Array('AVP','威尔克斯巴里','WEIERKESIBALI','WEKSBL');
intercitys[1307]=new Array('BPT','博蒙特','BOMENGTE','BMT');
intercitys[1308]=new Array('CAE','南卡罗来纳州 哥伦比亚','NANKALUOLAINAZHOUGELUNBIYA','NKLLNZGLBY');
intercitys[1309]=new Array('CHI','芝加哥','ZHIJIAGE','ZJG');
intercitys[1310]=new Array('CHS','南卡罗来纳州 查尔斯顿','NANKALUOLAINAZHOUCHAERSIDUN','NKLLNZCESD');
intercitys[1311]=new Array('CRW','西弗吉尼亚州查尔斯顿','XIFUJINIYAZHOUCHAERSIDUN','XFJNYZCESD');
intercitys[1312]=new Array('CLE','克利夫兰','KELIFULAN','KLFL');
intercitys[1313]=new Array('CMH','哥伦布','GELUNBU','GLB');
intercitys[1314]=new Array('COS','科罗拉多斯普林斯','KELUOLADUOSIPULINSI','KLLDSPLS');
intercitys[1315]=new Array('CRP','科珀斯科里斯蒂','KEPOSIKELISIDI','KPSKLSD');
intercitys[1316]=new Array('CSL','圣路易斯奥比斯波','SHENGLUYISIAOBISIBO','SLYSABSB');
intercitys[1317]=new Array('SBP','圣路易斯奥比斯波 圣刘易斯机场','SHENGLUYISIAOBISIBOSHENGLIUYISIJICHANG','SLYSABSBSLYSJC');
intercitys[1318]=new Array('CVN','克洛维斯','KELUOWEISI','KLWS');
intercitys[1319]=new Array('CYS','夏延','XIAYAN','YXY');
intercitys[1320]=new Array('DAY','代顿','DAIDUN','DD');
intercitys[1321]=new Array('DEN','丹佛','DANFO','DF');
intercitys[1322]=new Array('DOM','多米尼加岛','DUOMINIJIADAO','DMNJD');
intercitys[1323]=new Array('DRO','美国杜兰戈','MEIGUODULANGE','MGDLG');
intercitys[1324]=new Array('DRT','德里奥','DELIAO','DLA');
intercitys[1325]=new Array('DTT','底特律','DITELV','DTL');
intercitys[1326]=new Array('DET','底特律市机场','DITELVSHIJICHANG','DTLSJC');
intercitys[1327]=new Array('DTW','底特律机场','DITELVJICHANG','DTLJC');
intercitys[1328]=new Array('ELP','埃尔帕索','AIERPASUO','AEPS');
intercitys[1329]=new Array('EYW','基韦斯特','JIWEISITE','JWST');
intercitys[1330]=new Array('FAI','费尔班克斯','FEIERBANKESI','FEBKS');
intercitys[1331]=new Array('FAT','弗雷斯诺','FEILEISINUO','FLSN');
intercitys[1332]=new Array('FAY','费耶特维尔 北卡罗莱纳州','FEIYETEWEIERBEIKALUOLAINAZHOU','FYTWEBKLLNZ');
intercitys[1333]=new Array('FLL','劳德代尔','LAODEDAIER','LDDE');
intercitys[1334]=new Array('FMY','迈尔斯堡佩吉机场','MAIERSIBAOPEIJIJICHANG','MESBPJJC');
intercitys[1335]=new Array('RSW','迈尔斯堡','MAIERSIBAO','MESB');
intercitys[1336]=new Array('FWA','韦恩堡','WEIENBAO','WEB');
intercitys[1337]=new Array('GEG','斯波坎','SIBOKAN','SBK');
intercitys[1338]=new Array('GTF','格雷特瀑布','KELEITEPUBU','GLTPB');
intercitys[1339]=new Array('HAR','哈里斯堡','HALISIBAO','HLSB');
intercitys[1340]=new Array('MDT','哈里斯堡国际机场','HALISIBAOGUOJIJICHANG','HLSBGJJC');
intercitys[1341]=new Array('HNL','夏威夷','XIAWEIYI','XWY');
intercitys[1342]=new Array('HOU','休斯敦','XIUSIDUN','XSD');
intercitys[1343]=new Array('ICT','威奇托','WEIQITUO','WQT');
intercitys[1344]=new Array('ILE','基林','JILIN','JL');
intercitys[1345]=new Array('GRK','基林格雷军用机场','JILINGELEIJUNYONGJICHANG','JLGLJYJC');
intercitys[1346]=new Array('IND','印地安那波利斯','YINDIANNABOLISI','YDANBLS');
intercitys[1347]=new Array('JAN','杰克逊','JIEKEXUN','JKX');
intercitys[1348]=new Array('JAX','杰克逊维尔 佛罗里达州','JIEKEXUNWEIER FOLUOLIDAZHOU','JKXWE FLLDZ');
intercitys[1349]=new Array('JNU','朱诺','ZHUNUO','ZN');
intercitys[1350]=new Array('SNA','圣塔安那','SHENGTAANNA','STAN');
intercitys[1351]=new Array('KIN','金斯敦','JINSIDUN','JSD');
intercitys[1352]=new Array('KTN','凯奇坎','KAIQIKAN','KQK');
intercitys[1353]=new Array('LAS','拉斯维加斯','LASIWEIJIASI','LSWJS');
intercitys[1354]=new Array('LAX','洛杉矶','LUOSHANJI','LSJ');
intercitys[1355]=new Array('LBB','拉伯克','LABOKE','LBK');
intercitys[1356]=new Array('LGB','长滩','CHANGTAN','CS');
intercitys[1357]=new Array('LIT','小石城','XIAOSHICHENG','XSC');
intercitys[1358]=new Array('AHL','艾沙尔顿','AISHAERDUN','ASED');
intercitys[1359]=new Array('AJU','阿拉卡茄','ALAKAQIE','ALKQ');
intercitys[1360]=new Array('ANF','安托法加斯塔','ANTUOFAJIASITA','ATDJST');
intercitys[1361]=new Array('AQA','阿拉拉夸拉','ALALAKUALA','ALLKL');
intercitys[1362]=new Array('AQP','阿雷基帕','ALEIJIPA','ALJP');
intercitys[1363]=new Array('ARU','阿拉萨图巴','ALASATUBA','ALSTB');
intercitys[1364]=new Array('ASU','亚松森','YASONGSEN','YSS');
intercitys[1365]=new Array('ATM','阿尔塔米拉','AERTAMILA','AETML');
intercitys[1366]=new Array('AUA','阿鲁巴','ALUBA','ALB');
intercitys[1367]=new Array('AUX','阿拉瓜依纳','ALAGUAYINA','ALGYN');
intercitys[1368]=new Array('AXM','阿尔梅尼亚','AERMEINIYA','AEMNY');
intercitys[1369]=new Array('BAQ','巴兰基亚','BALANJIYA','BLJY');
intercitys[1370]=new Array('BAU','包鲁','BAOLU','BL');
intercitys[1371]=new Array('BAZ','巴贝罗斯','BABEILUOSI','BBLS');
intercitys[1372]=new Array('BEL','贝伦','BEILUN','BL');
intercitys[1373]=new Array('BOG','波哥大','BAGEDA','BGD');
intercitys[1374]=new Array('BPS','塞古鲁港','SAIGULUGANG','SGLG');
intercitys[1375]=new Array('BRA','巴雷拉斯','BALEILASI','BLLS');
intercitys[1376]=new Array('BSB','巴西利亚','BAXILIYA','BXLY');
intercitys[1377]=new Array('BVB','博阿维斯塔','BOAWEISITA','BAWST');
intercitys[1378]=new Array('BVH','维列纳','WEILIENA','WYN');
intercitys[1379]=new Array('CAC','卡斯卡韦尔','KASIKAWEIER','KSKWE');
intercitys[1380]=new Array('CAW','坎普斯','KANPUSI','KPS');
intercitys[1381]=new Array('CCM','克雷西阿马','KELEIXIAMA','KLXAM');
intercitys[1382]=new Array('CCS','加拉加斯','JIALAJIASI','JLSJ');
intercitys[1383]=new Array('CGB','库亚巴','KUYABA','KYB');
intercitys[1384]=new Array('CKS','加拉杰斯','JIALAJIESI','JLJS');
intercitys[1385]=new Array('CLO','卡利','KALI','KL');
intercitys[1386]=new Array('CLV','新卡尔达斯','XINKAERDASI','XKEDS');
intercitys[1387]=new Array('CMG','科龙巴','KELONGBA','KLB');
intercitys[1388]=new Array('CPV','坎皮纳格拉德','KANPINAGELADE','KPNGLD');
intercitys[1389]=new Array('CUZ','库斯科','KUSIKE','KSK');
intercitys[1390]=new Array('CWB','库里蒂巴','KULIDIBA','KLDB');
intercitys[1391]=new Array('CXJ','南卡希亚斯','NANKAXIYASI','NKXYS');
intercitys[1392]=new Array('DOU','多拉杜斯','DUOLADUSI','DLDS');
intercitys[1393]=new Array('FEN','费努罗尼亚','FEINULUONIYA','FNLNY');
intercitys[1394]=new Array('FLN','弗卢里亚诺卢波','FEILULIYANUOLUBO','FLLYNLB');
intercitys[1395]=new Array('FOR','福特莱萨','FUTELAISA','FTLS');
intercitys[1396]=new Array('GEO','圭亚那乔治敦','FUIYANAQIAOZHIDUN','GYNQZD');
intercitys[1397]=new Array('GVR','瓦拉达里斯州长','WALADALISIZHOUZHANG','WLDLSZZ');
intercitys[1398]=new Array('GYE','瓜亚基尔','GUAYAJIER','WYJE');
intercitys[1399]=new Array('GYN','戈亚尼亚','GEYANIYA','GYNY');
intercitys[1400]=new Array('IGU','伊瓜苏福尔斯','YIGUASUFUERSI','YGSFES');
intercitys[1401]=new Array('IMP','因佩拉特里斯','YINPEILATELISI','YPLTLS');
intercitys[1402]=new Array('IOS','伊利乌斯','YILIWUSI','YLWS');
intercitys[1403]=new Array('IPN','衣潘廷加','YIPANTINGJIA','YPTJ');
intercitys[1404]=new Array('ITB','伊泰图巴','YITAITUBA','YTTB');
intercitys[1405]=new Array('JDO','北茹阿泽鲁','BEIRUAZELU','BRAZL');
intercitys[1406]=new Array('JOI','儒万维尔','RUWANWEIER','RWWE');
intercitys[1407]=new Array('JPA','若昂佩索阿','RUOANGPEISUOA','RAPSA');
intercitys[1408]=new Array('JPR','吉巴拉那','JIBALANA','JBLN');
intercitys[1409]=new Array('LDB','隆德里纳','LONGDELINA','LDLN');
intercitys[1410]=new Array('LIM','利马','LIMA','LM');
intercitys[1411]=new Array('LIR','利韦里亚','LIWEILIYA','LWLY');
intercitys[1412]=new Array('MAO','马瑙斯','MANAOSI','MNS');
intercitys[1413]=new Array('MCP','马卡帕','MAKAPA','MKP');
intercitys[1414]=new Array('MCZ','马塞约','MASAIYUE','MSY');
intercitys[1415]=new Array('MEA','马卡埃','MAKAAI','MKA');
intercitys[1416]=new Array('MGA','马那瓜','MANAGUA','MNG');
intercitys[1417]=new Array('MGF','马林加','MALINJIA','MLJ');
intercitys[1418]=new Array('MII','马里利亚','MALILIYA','MLLY');
intercitys[1419]=new Array('MOC','蒙特斯','MENGTESI','MTS');
intercitys[1420]=new Array('MVD','蒙的维的亚','MENGDIWEIDIYA','MDWDY');
intercitys[1421]=new Array('NAR','纳雷','NALEI','NL');
intercitys[1422]=new Array('NAT','纳塔尔','NATAER','NTE');
intercitys[1423]=new Array('NQN','内乌肯','NEIWUKEN','NWK');
intercitys[1424]=new Array('NVT','纳韦甘蒂斯','NAWEIGANDISI','NWGDS');
intercitys[1425]=new Array('PAV','保罗阿方索','BAOLUOAFANGSUO','BLAFS');
intercitys[1426]=new Array('PCL','普卡尔帕','PUKAERPA','PKEP');
intercitys[1427]=new Array('PET','佩洛塔斯','PEILUOTASI','PLTS');
intercitys[1428]=new Array('PFB','帕苏丰杜','PASUFENGDU','PSFS');
intercitys[1429]=new Array('PHB','巴纳伊巴','BANAYIBA','BNYB');
intercitys[1430]=new Array('PIN','帕林廷斯','PALINTINGSI','PLTS');
intercitys[1431]=new Array('PIU','皮乌拉','PIWULA','PWL');
intercitys[1432]=new Array('PNZ','彼德罗利纳','BIDELUOLINA','BDLLN');
intercitys[1433]=new Array('POA','阿雷格里港','ALEIGELIGANG','ALGLG');
intercitys[1434]=new Array('PPB','普鲁登特总统城','PULUDENGTEZONGTONGCHENG','PLDTZTC');
intercitys[1435]=new Array('PUE','奥瓦尔迪亚港','AOWAERDIYAGANG','AWEDYG');
intercitys[1436]=new Array('PVH','维利乌港','WEILIWUGANG','WLWG');
intercitys[1437]=new Array('RAO','里贝朗普雷图','LIBEILANGPULEITU','LBLPLT');
intercitys[1438]=new Array('RBR','里阿布朗库','LIABULANGKU','LABLK');
intercitys[1439]=new Array('REC','累西腓','LEIXIFEI','LXF');
intercitys[1440]=new Array('RIA','巴西圣马丽亚','BAXISHENGMALIYA','BXSMLY');
intercitys[1441]=new Array('ROO','龙多诺波利斯','LONGDUONUOBOLISI','LDNBLS');
intercitys[1442]=new Array('SCL','智利圣地亚哥','ZHILISHENGDIYAGE','ZLSDYG');
intercitys[1443]=new Array('SJO','哥斯达黎加 圣何塞','GESIDALIJIASHENGHESAI','GSDLJSHS');
intercitys[1444]=new Array('SLZ','圣路易斯','SHENGLUYISI','SLYS');
intercitys[1445]=new Array('SSA','萨尔瓦多','SAERWADUO','SEWD');
intercitys[1446]=new Array('STM','圣塔伦','SHENGTALUN','STL');
intercitys[1447]=new Array('UIO','基多','JIDUO','JD');
intercitys[1448]=new Array('WCH','查伊顿','CHAYIDUN','CYD');
intercitys[1449]=new Array('ZOS','奥索尔诺','AOSUOERNUO','ASEN');
intercitys[1450]=new Array('BHZ','贝洛奥里藏特','BEILUOAOLIZANGTE','BLALZT');
intercitys[1451]=new Array('BUE','布宜诺斯艾利斯','BUYINUOSIAILISI','BYNSALS');
intercitys[1452]=new Array('MDE','麦德林','MAIDELIN','MDL');
intercitys[1453]=new Array('PTY','巴拿马城','BANAMACHENG','BNMC');
intercitys[1454]=new Array('RIO','里约热内卢','LIYUERENEILU','LYRNL');
intercitys[1455]=new Array('GIG','里约热内卢机场','LIYUERENEILUJICHANG','LYRNLJC');
intercitys[1456]=new Array('SAO','美国圣保罗','MEIGUOSHENGBAOLUO','MGSBL');


commoncitysgj = commoncitysFlightgj;
citysgj = intercitys;



//根据三字码查找城市
function getCityByThreeWord(threeWord)
{
	var cityCn = "";
	for(var i = 0,len = citysgj.length;i<len;i++)
	{
		if(threeWord == citysgj[i][0])
		{
			cityCn = citysgj[i][1];
			break;
		}
	}
	return cityCn;
}
//根据城市查找三字码
function getThreeWordByCity(cityName)
{
	var threeWord = "";
	for(var i = 0,len = citysgj.length;i<len;i++)
	{
		if(cityName == citysgj[i][1])
		{
			threeWord = citysgj[i][0];
			break;
		}
	}
	return threeWord;
}
var parentbject;
var city_suggestgj = function(){
	this.Remoreurl = ''; // 远程URL地址
	this.object = '';
	this.id2 = '';
	this.taskid = 0;
	this.delaySec = 100; // 默认延迟多少毫秒出现提示框
	this.lastkeys_val= 0;
	var lastkeys_val= 0;
	this.lastinputstr = '';	
	/**
	* 初始化类库
	*/
	this.init_zhaobussuggest=  function(){
		var objBody = document.getElementById("mainbody");
		var objiFrame = document.createElement("iframe");
		var objplatform = document.createElement("div");
                 
		objiFrame.setAttribute('id','getiframe');
		objiFrame.style.zindex='100';		
		objiFrame.style.position = 'absolute';
		objiFrame.style.display = 'none';
		objplatform.setAttribute('id','getplatform');
		objplatform.setAttribute('align','left');
		objplatform.style.zindex='999999';
		objBody.appendChild(objiFrame);
		objBody.appendChild(objplatform);
		var win=objBody || window
                
		if(!document.all) {
			objBody.addEventListener("click",this.hidden_suggest,false);
			
		}else{
			win.document.attachEvent("onclick",this.hidden_suggest);
			
		}
	}

	/***************************************************fill_div()*********************************************/
	//函数功能：动态填充div的内容，该div显示所有的提示内容
	//函数参数：allplat 一个字符串数组，包含了所有可能的提示内容
	this.fill_div = function(allplat){
		var msgplat = '';
		var all = '';
		var spell = '';
		var chinese = '';
		var platkeys = this.object.value;
        platkeys=this.ltrim(platkeys);
		if(!platkeys){
			msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">输入中文/拼音或&uarr;&darr;选择</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
			for(i=0;i<allplat.length;i++){
			    all=allplat[i].split(",");
				spell=all[0];
				chinese=all[1];
				szm=all[2];
				msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\'' + chinese + '\',\'' + szm + '\')"><td class="tdleft" height="10" align="left">'+ spell +
				       '</td><td class="tdright" align="right">' + chinese + '</td><td style="display:none">' + szm + '</td></tr></table>';
			}
        }
		else {
			if(allplat.length < 1 || !allplat[0]){
				msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">对不起，找不到：'+platkeys+'</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';

			}
			else{
			   msgplat += '<table class="hint" width="190"><tr align="left"><td class="tdleft" height="10" align="left">'+platkeys+'，按拼音排序</td></tr></table><table width="190" class="mout" height="2"><tr><td></td></tr></table>';
			   for(i=0;i<allplat.length;i++){
					all=allplat[i].split(",");
					spell=all[0];
					chinese=all[1];
					szm=all[2];
					msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\'' + chinese + '\',\'' + szm + '\')"><td class="tdright" align="left">' + chinese + '</td><td style="display:none">' + szm + '</td></tr></table>';
				
					//msgplat += '<table class="mout" width="190"><tr onclick="parentbject.add_input_text(\'' + chinese + '\',\'' + szm + '\')"><td class="tdleft" height="10" align="left">'+ spell +'</td><td class="tdright" align="right">' + chinese + '</td><td style="display:none">' + szm + '</td></tr></table>';
				}
			}
		}
		
		document.getElementById("getplatform").innerHTML =  msgplat;
		var nodes = document.getElementById("getplatform").childNodes;
		nodes[0].className = "hint";
		if(allplat.length >= 1 && allplat[0]){
			nodes[2].className = "selected";
		}
		//this.lastkeys_val = 0;
		for(var i=2;i<nodes.length;i++){
			nodes[i].onmouseover = function(){
				this.className = "mover";
				}
			nodes[i].onmouseout = function(){
				if(parentbject.lastkeys_val==(parentIndexOf(this)-2)){this.className = "selected";}
				else{this.className = "mout";}
			}
		}
		document.getElementById("getiframe").style.width = document.getElementById("getplatform").clientWidth+2;
        document.getElementById("getiframe").style.height = document.getElementById("getplatform").clientHeight+2;		
	}

	/***************************************************fix_div_coordinate*********************************************/
	//函数功能：控制提示div的位置，使之刚好出现在文本输入框的下面
	this.fix_div_coordinate = function(){
		var leftpos=0;
		var toppos=0;
		var testtmp=this.object.value;
		var testtmp1=this.object.id;
		aTag = this.object;
		do {
			if( aTag.offsetParent )
			{
			    aTag = aTag.offsetParent;
			}
			else
			{
			    leftpos += aTag.style.left;
			    toppos += aTag.style.top;
			    break;
			}
			leftpos	+= aTag.offsetLeft;
			toppos += aTag.offsetTop;
		}while(aTag.id!="mainbody");
		//alert("leftpos=["+leftpos+"]--toppos=["+toppos+"]--this.object.offsetTop=["+this.object.offsetTop+"]--this.object.offsetLeft=["+this.object.offsetLeft+"]--this.object.offsetHeight=["+this.object.offsetHeight+"]");
		document.getElementById("getiframe").style.width = this.object.offsetWidth + 'px';
		
		if(document.layers){
			document.getElementById("getiframe").style.left = this.object.offsetLeft	+ parseInt(leftpos) + "px";
			document.getElementById("getiframe").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("getiframe").style.left =this.object.offsetLeft	+ parseInt(leftpos)  +"px";
			document.getElementById("getiframe").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}
		//document.getElementById("getplatform").style.width = this.object.offsetWidth + 'px';
		//document.getElementById("getiframe").style.width= this.object.offsetWidth + 'px';
		if(document.layers){
			document.getElementById("getplatform").style.left = this.object.offsetLeft	+ parseInt(leftpos) + "px";
			document.getElementById("getplatform").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}else{
			document.getElementById("getplatform").style.left =this.object.offsetLeft	+ parseInt(leftpos)  +"px";
			document.getElementById("getplatform").style.top = this.object.offsetTop +	parseInt(toppos) + this.object.offsetHeight + 2 + "px";
		}
		//alert("getiframe.left=["+document.getElementById("getiframe").style.left+"]--getiframe.top=["+document.getElementById("getiframe").style.top+"]--getplatform.left=["+document.getElementById("getplatform").style.left+"]--getplatform.top=["+document.getElementById("getplatform").style.top+"]");
	}

    /***************************************************hidden_suggest*********************************************/
	//函数功能：隐藏提示框
	this.hidden_suggest = function (){
		this.lastkeys_val = 0;		 
		document.getElementById("getiframe").style.visibility = "hidden";
		document.getElementById("getplatform").style.visibility = "hidden";
	}

	/***************************************************show_suggest*********************************************/
	//函数功能：显示提示框
	this.show_suggest = function (){
		document.getElementById("getiframe").style.visibility = "visible";
		document.getElementById("getplatform").style.visibility = "visible";
	}
	this.is_showsuggest= function (){
		if(document.getElementById("getplatform").style.visibility == "visible") return true;else return false;
	}

	this.sleep = function(n){
		var start=new Date().getTime(); //for opera only
		while(true) if(new Date().getTime()-start>n) break;
	}
	this.ltrim = function (strtext){
		return strtext.replace(/[\$&\|\^*%#@! ]+/, '');
	}

    /***************************************************add_input_text*********************************************/
	//函数功能：当用户选中时填充相应的城市名字

	this.add_input_text = function (keys,szm){
		 
		keys=this.ltrim(keys)
		this.object.value = keys;
		var id=this.object.id;		
		document.getElementById(this.id2.id).value = szm;
		document.getElementById(id).style.color="#000000";
		document.getElementById(id).value=keys;
     }

	/***************************************************keys_handleup*********************************************/
	//函数功能：用于处理当用户用向上的方向键选择内容时的事件
	this.keys_handleup = function (){
		if(this.lastkeys_val > 0) this.lastkeys_val--;
		var nodes = document.getElementById("getplatform").childNodes;
		if(this.lastkeys_val < 0) this.lastkeys_val = nodes.length-1;
		var b = 0;
		for(var i=2;i<nodes.length;i++){
			if(b == this.lastkeys_val){
				nodes[i].className = "selected";
				this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}else{
				nodes[i].className = "mout";
			}
			b++;
		}
	}

	/***************************************************keys_handledown*********************************************/
	//函数功能：用于处理当用户用向下的方向键选择内容时的事件
	this.keys_handledown = function (){
		
		this.lastkeys_val++;
		
		var nodes = document.getElementById("getplatform").childNodes;
		
		if(this.lastkeys_val >= nodes.length-2) {
			
			this.lastkeys_val--;
			return;
		}
		
		var b = 0;
		for(var i=2;i<nodes.length;i++){
			
			if(b == this.lastkeys_val){
				
				nodes[i].className = "selected";
				this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}else{
				nodes[i].className = "mout";
			}
			b++;
		}
	}

	this.ajaxac_getkeycode = function (e)
	{
		var code;
		if (!e) var e = window.event;
		if (e.keyCode) code = e.keyCode;
		else if (e.which) code = e.which;
		
		return code;
		
	}

	/***************************************************keys_enter*********************************************/
	//函数功能：用于处理当用户回车键选择内容时的事件
	this.keys_enter = function (){
		  
		var nodes = document.getElementById("getplatform").childNodes;
		for(var i=2;i<nodes.length;i++){
			if(nodes[i].className == "selected"){
				
			  this.add_input_text(nodes[i].childNodes[0].childNodes[0].childNodes[1].innerHTML,nodes[i].childNodes[0].childNodes[0].childNodes[2].innerHTML);
			}
		}
		this.hidden_suggest();
	}

 
function getEvent()
{
 if(document.all)    return window.event;//如果是ie
 func=getEvent.caller;
        while(func!=null){
            var arg0=func.arguments[0];
            if(arg0){if((arg0.constructor==Event || arg0.constructor ==MouseEvent) || (typeof(arg0)=="object" && arg0.preventDefault && arg0.stopPropagation)){return arg0;}            }
            func=func.caller;
        }
       return null;
}

    /***************************************************display*********************************************/
	//函数功能：入口函数，将提示层div显示出来
	//输入参数：object 当前输入所在的对象，如文本框
	//输入参数：e IE事件对象
	this.display = function (object,id2,e){
		this.object = document.getElementById(object);
		this.id2 = document.getElementById(id2);
		if(!document.getElementById("getplatform")) this.init_zhaobussuggest();
		e = e || window.event;
		//var e=getEvent();
		
		e.stopPropagation;
		e.cancelBubble = true;
		if (e.target) targ = e.target;  else if (e.srcElement) targ = e.srcElement;
		if (targ.nodeType == 3)  targ = targ.parentNode;

		var inputkeys = this.ajaxac_getkeycode(e);
		switch(inputkeys){
			case 38: //向上方向键
				this.keys_handleup(this.object.id);
			    return;break;
			case 40: //向下方向键
			  
				if(this.is_showsuggest()) this.keys_handledown(this.object.id); else this.show_suggest();
			    return;break;
			case 39: //向右方向键
				return;break;
			case 37: //向左方向键
				return;break;
			case 13: //对应回车键
			 
			    this.keys_enter();
			    return;break;
			case 18: //对应Alt键
				this.hidden_suggest();
			    return;break;
			case 27: //对应Esc键
				this.hidden_suggest();
			    return;break;
		}

		//object.value = this.ltrim(object.value);
		
		//if(object.value == this.lastinputstr) return;else this.lastinputstr = object.value;
		if(window.opera) this.sleep(100);//延迟0.1秒
		parentbject = this;
		if(this.taskid) window.clearTimeout(this.taskid);
        this.taskid=setTimeout("parentbject.localtext();" , this.delaySec)
		//this.taskid = setTimeout("parentbject.remoteurltext();" , this.delaySec);
		
	}

	//函数功能：从本地js数组中获取要填充到提示层div中的文本内容
	this.localtext = function(){
		var id=this.object.id;
        var suggestions="";
        suggestions=this.getSuggestionByName();
		suggestions=suggestions.substring(0,suggestions.length-1);

		parentbject.show_suggest();
		parentbject.fill_div(suggestions.split(';'));
		parentbject.fix_div_coordinate();
	}

	/***************************************************getSuggestionByName*********************************************/
	//函数功能：从本地js数组中获取要填充到提示层div中的城市名字
	this.getSuggestionByName = function(){
		platkeys = this.object.value;
		var str="";
        platkeys=this.ltrim(platkeys);
		if(!platkeys){
			for(i=0;i<commoncitysgj.length;i++){
				str+=commoncitysgj[i][2]+","+commoncitysgj[i][1]+","+commoncitysgj[i][0]+";";
			}
			return str;
        }
		else{
		   platkeys=platkeys.toUpperCase();
			for(i=0;i<citysgj.length;i++){
			    if(//this.getLeftStr(citys[i][0],platkeys.length).toUpperCase()==platkeys||
				   (citysgj[i][1].toUpperCase().indexOf(platkeys)!=-1)||
				   this.getLeftStr(citysgj[i][2],platkeys.length).toUpperCase()==platkeys||
				   this.getLeftStr(citysgj[i][3],platkeys.length).toUpperCase()==platkeys)
					str+=citysgj[i][2]+","+citysgj[i][1]+","+citysgj[i][0]+";";
			}
			return str;
		}
	}

	/***************************************************getLeftStr************* *************************************/
    //函数功能：得到左边的字符串
    this.getLeftStr = function(str,len){

        if(isNaN(len)||len==null){
            len = str.length;
        }
        else{
            if(parseInt(len)<0||parseInt(len)>str.length){
                len = str.length;
             }
        }
        return str.substr(0,len);
    }

	/***************************************************parentIndexOf************* *************************************/
    //函数功能：得到子结点在父结点的位置
	function parentIndexOf(node){
	  for (var i=0; i<node.parentNode.childNodes.length; i++){
			if(node==node.parentNode.childNodes[i]){return i;}
	  }
   }


}

function showSearchgj(obj,type){
	
	
    if(type==1){
        if(document.getElementById(obj).value==""){
			document.getElementById(obj).style.color="#C1C1C1";
			document.getElementById(obj).value="中文/拼音";
		}
    }else{
        if(document.getElementById(obj).value=="中文/拼音"){
			document.getElementById(obj).style.color="#000000";
            document.getElementById(obj).value="";
		}
    }
}


 

 var suggestgj = new city_suggestgj();
 
function change_iframe(idname,urlcity){
	idname.location.href=urlcity;
}
//改变搜索框文字
function changetext(thisid){
	if(thisid == "search1"){
		commoncitys = commoncitysHotel;
		citys = citysHotel;
		document.getElementById("hCity").value = "中文/拼音";
	}else if(thisid == "search2"){
		commoncitysgj = commoncitysFlightgj;
		citysgj = intercitys;
		document.getElementById("fromcity").value = "中文/拼音";
	}

	for(i=1; i<=3; i++)
	{
		var tdid="search"+i;
		document.getElementById(tdid).className="searchitem_b";
	}
	
	document.getElementById(thisid).className="searchitem_r";
}
<!-- 搜索框更换-->
function closeothers(thisid) {
  if (thisid.style.display=="") { 
	hotel.style.display="none";
	plane.style.display="none";
	pkg.style.display="none";
	
    thisid.style.display="";
  }
  else{
  thisid.style.display="";
  }
}