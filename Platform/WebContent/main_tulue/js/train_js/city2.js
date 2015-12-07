

/* *
 * 全局空间 Vcity
 * */
var Vcity = {};
/* *
 * 静态方法集
 * @name _m
 * */
 
Vcity._m = {
    /* 选择元素 */
    $:function (arg, context) {
    	//alert("?");
        var tagAll, n, eles = [], i, sub = arg.substring(1);
        context = context || document;
        if (typeof arg == 'string') {
            switch (arg.charAt(0)) {
                case '#':
                    return document.getElementById(sub);
                    break;
                case '.':
                    if (context.getElementsByClassName) return context.getElementsByClassName(sub);
                    tagAll = Vcity._m.$('*', context);
                    n = tagAll.length;
                    for (i = 0; i < n; i++) {
                        if (tagAll[i].className.indexOf(sub) > -1) eles.push(tagAll[i]);
                    }
                    return eles;
                    break;
                default:
                    return context.getElementsByTagName(arg);
                    break;
            }
        }
    },
    

    /* 绑定事件 */
    on:function (node, type, handler) {
        node.addEventListener ? node.addEventListener(type, handler, false) : node.attachEvent('on' + type, handler);
    },

    /* 获取事件 */
    getEvent:function(event){
        return event || window.event;
    },

    /* 获取事件目标 */
    getTarget:function(event){
        return event.target || event.srcElement;
    },

    /* 获取元素位置 */
    getPos:function (node) {
        var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
        var pos = node.getBoundingClientRect();
        return {top:pos.top + scrollt, right:pos.right + scrollx, bottom:pos.bottom + scrollt, left:pos.left + scrollx }
    },

    /* 添加样式名 */
    addClass:function (c, node) {
        if(!node)return;
        node.className = Vcity._m.hasClass(c,node) ? node.className : node.className + ' ' + c ;
    },

    /* 移除样式名 */
    removeClass:function (c, node) {
        var reg = new RegExp("(^|\\s+)" + c + "(\\s+|$)", "g");
        if(!Vcity._m.hasClass(c,node))return;
        node.className = reg.test(node.className) ? node.className.replace(reg, '') : node.className;
    },

    /* 是否含有CLASS */
    hasClass:function (c, node) {
        if(!node || !node.className)return false;
        return node.className.indexOf(c)>-1;
    },

    /* 阻止冒泡 */
    stopPropagation:function (event) {
        event = event || window.event;
        event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
    },
    /* 去除两端空格 */
    trim:function (str) {
        return str.replace(/^\s+|\s+$/g,'');
    }
};


/* 所有城市数据,可以按照格式自行添加（北京|beijing|bj），前16条为热门城市 */

Vcity.allCity = [
'北京|beijing|bj','上海|shanghai|sh', '重庆|chongqing|cq',  '深圳|shenzhen|sz', '广州|guangzhou|gz', '杭州|hangzhou|hz',
'南京|nanjing|nj', '苏州|shuzhou|sz', '天津|tianjin|tj', '成都|chengdu|cd', '南昌|nanchang|nc', '三亚|sanya|sy','青岛|qingdao|qd',
'厦门|xiamen|xm', '西安|xian|xa','长沙|changsha|cs',
'阿城|acheng|ac','阿尔山|aershan|aes','阿贵图|aguitu|agt','阿金|ajin|aj','阿克苏|akesu|aks','阿克陶|aketao|akt',
'阿拉山口|alashankou|alsk','阿里河|alihe|alh','阿龙山|alongshan|als','阿木尔|aermu|aem','阿南庄|ananzhuang|anz',
'阿图什|atushi|ats','阿乌尼|awuni|awn','阿寨|azhai|az','埃岱|aidai|ad','艾不盖|aibugai|abg',
'艾河|aihe|ah','艾家村|aijiacun|ajc','爱河|aihe|ah','安达|anda|ad','安德|ande|ad',
'安定|anding|ad','安多|anduo|ad','安富镇|anfuzhen|afz','安广|anguang|ag','安化|anhua|ah',
'安家|anjia|aj','安康|ankang|ak','安口窑|ankouyao|aky','安龙|anlong|al','安陆|anlu|al',
'安平|anping|ap','安庆|anqing|aq','安庆沟|anqinggou|aqg','安庆西|anqingxi|aqx','安仁|anren|ar',
'安顺|anshun|as','安塘|antang|at','安亭北|antingbei|atb','安图|antu|at','安溪|anxi|ax',
'安阳|anyang|ay','安阳东|anyangdong|ayd','鞍山|anshan|as','鞍山西|anshanxi|asx','昂昂溪|angangxi|aax',
'敖汉|aohan|ah','敖来|aolai|al','敖力布告|aolibugao|albg','敖头|aotou|at','鳌江|aojiang|aj',
'八村|bacun|bc','八达岭|badaling|bdl','八都|badu|bd','八方|bafang|bf','八虎力|bahuli|bhl',
'八家子|bajiazi|bjz','八角台|bajiaotai|bjt','八面城|bamiancheng|bmc','八面通|bamiantong|bmt','八苏木|basumu|bsm',
'八仙筒|baxiantong|bxt','巴楚|bachu|bc','巴东|badong|bd','巴林|balin|bl','巴山|bashan|bs',
'巴彦高勒|bayangaole|bygl','巴彦郭勒|bayanguole|bygl','巴中|bazhong|bz','坝梁|baliang|bl','鲅鱼圈|bayuquan|byq',
'霸州|bazhou|bz','白壁关|baibiguan|bbg','白城|baicheng|bc','白果|baiguo|bg','白合|baihe|bh',
'白河|baihe|bh','白河东|baihedong|bhd','白河县|baihexian|bhx','白桦排|baihuapai|bhp','白芨沟|baijigou|bjg',
'白鸡坡|baijipo|bjp','白涧|baijian|bj','白奎堡|baikuibao|bkb','白狼|bailang|bl','白马|baima|bm',
'白旗|baiqi|bq','白泉|baiquan|bq','白沙|baisha|bs','白沙坡|baishapo|bsp','白沙沱|baishatuo|bst',
'白山市|baishanshi|bss','白山乡|baishanxiang|bsx','白石山|baishishan|bss','白石岩|baishiyan|bsy','白水江|baishuijiang|bsj',
'白水镇|baishuizhen|bsz','白涛|baitao|bt','白彦花|baiyanhua|byh','白音察干|baiyinchagan|bycg','白音胡硕|baiyinhushuo|byhs',
'白音他拉|baiyintala|bytl','白音特拉|baiyintela|bytl','白银哈尔|baiyinhaer|byhe','白银市|baiyinshi|bys','白银西|baiyinxi|byx',
'白云鄂博|baiyunebo|byeb','百里峡|bailixia|blx','百色|baise|bs','柏村|baicun|bc','柏果|baiguo|bg',
'柏林|bolin|bl','班猫箐|banmaoqing|bmq','坂尾|banwei|bw','板城|bancheng|bc','板石河|banshihe|bsh',
'半截河|banjiehe|bjh','蚌埠|bengbu|bb','蚌埠南|bengbunan|bbn','包头|baotou|bt','包头北|baotoubei|btb',
'包头东|baotoudong|btd','包头西|baotouxi|btx','宝坻|baodi|bd','宝华山|baohuashan|bhs','宝鸡|baoji|bj',
'宝鸡南|baojinan|bjn','宝拉格|baolage|blg','宝老山|baolaoshan|bls','宝林|baolin|bl','宝龙山|baolongshan|bls',
'宝木吐|baomutu|bmt','宝泉岭|baoquanling|bql','保定|baoding|bd','保定东|baodingdong|bdd','保家楼|baojialou|bjl',
'保健|baojian|bj','保康|baokang|bk','堡子湾|baoziwan|bzw','北安|beian|ba','北板桥|beibanqiao|bbq',
'北碚|beibei|bb','北戴河|beidaihe|bdh','北磴|beideng|bd','北岗|beigang|bg','北海|beihai|bh',
'北滘|beijiao|bj','北京|beijing|bj','北京北|beijingbei|bjb','北京南|beijingnan|bjn','北京西|beijingxi|bjx',
'北林|beilin|bl','北流|beiliu|bl','北马圈子|beimaquanzi|bmqz','北票南|beipiaonan|bpn','北台子|beitaizi|btz',
'北屯|beitun|bt','北屯市|beitunshi|bts','北兴安|beixingan|bxa','北宅|beizhai|bz','背荫河|beiyinhe|byh',
'贲红|benhong|bh','本溪|benxi|bx','笔架山|bijiashan|bjs','碧鸡关|bijiguan|bjg','碧江|bijiang|bj',
'碧水|bishui|bs','碧州|bizhou|bz','边沟|biangou|bg','彬江|binjiang|bj','滨海|binhai|bh',
'滨海北|binhaibei|bhb','滨江|binjiang|bj','栟茶|bencha|bc','丙谷|binggu|bg','播明|boming|bm',
'泊头|botou|bt','勃利|boli|bl','亳州|bozhou|bz','博鳌|boao|ba','博克图|boketu|bkt',
'博乐|bole|bl','博兴|boxing|bx','布敦化|budunhua|bdh','布海|buhai|bh','布列开|buliekai|blk',
'蔡家沟|caijiagou|cjg','蔡家坡|caijiapo|cjp','蔡山|caishan|cs','沧州|cangzhou|cz','沧州西|cangzhouxi|czx',
'苍南|cangnan|cn','苍坪|cangping|cp','苍石|cangshi|cs','曹家营子|caojiayingzi|cjyz','曹县|caoxian|cx',
'曹子里|caozili|czl','草海|caohai|ch','草河口|caohekou|chk','草市|caoshi|cs','册亨|ceheng|ch',
'岑溪|cenxi|cx','查布嘎|chabuga|cbg','查干哈达|chaganhada|cghd','查干芒和|chaganmanghe|cgmh','查干特格|chagantege|cgtg',
'茶陵|chaling|cl','茶陵南|chalingnan|cln','茶条沟|chatiaogou|ctg','茶镇|chazhen|cz','察尔汗|chaerhan|ceh',
'察素齐|chasuqi|csq','岔河|chahe|ch','岔江|chajiang|cj','柴岗|chaigang|cg','柴沟堡|chaigoubao|cgb',
'柴河|chaihe|ch','昌乐|changle|cl','昌黎|changli|cl','昌平|changping|cp','昌平北|changpingbei|cpb',
'昌图|changtu|ct','昌图西|changtuxi|ctx','长城|changcheng|cc','长冲|changchong|cc','长春|changchun|cc',
'长春南|changchunnan|ccn','长春西|changchunxi|ccx','长甸|changdian|cd','长发屯|changfatun|cft','长葛|changge|cg',
'长河坝|changheba|chb','长河碥|changhebian|chb','长虹|changhong|ch','长农|changnong|cn','长坡岭|changpoling|cpl',
'长沙|changsha|cs','长沙南|changshanan|csn','长山屯|changshantun|cst','长寿|changshou|cs','长寿北|changshoubei|csb',
'长潭沟|changtangou|ctg','长汀|changting|ct','长汀镇|changtingzhen|ctz','长兴|changxing|cx','长兴南|changxingnan|cxn',
'长阳|changyang|cy','长垣|changyuan|cy','长征|changzheng|cz','长治|changzhi|cz','长治北|changzhibei|czb',
'长子|changzi|cz','常德|changde|cd','常平|changping|cp','常州|changzhou|cz','常州北|changzhoubei|czb',
'常庄|changzhuang|cz','超梁沟|chaolianggou|clg','巢湖|chaohu|ch','朝格温多尔|chaogewenduoer|cgwde','朝天|chaotian|ct',
'朝阳|chaoyang|cy','朝阳川|chaoyangchuan|cyc','朝阳村|chaoyangcun|cyc','朝阳地|chaoyangdi|cyd','朝阳镇|chaoyangzhen|cyz',
'朝中|chaozhong|cz','潮汕|chaoshan|cs','潮阳|chaoyang|cy','潮州|chaozhou|cz','车墩|chedun|cd',
'车转湾|chezhuanwan|czw','郴州|chenzhou|cz','郴州西|chenzhouxi|czx','辰溪|chenxi|cx','陈官营|chenguanying|cgy',
'陈相屯|chenxiangtun|cxt','晨明|chenming|cm','成都|chengdu|cd','成都东|chengdudong|cdd','成高子|chenggaozi|cgz',
'成吉思汗|chengjisihan|cjsh','承德|chengde|cd','承德东|chengdedong|cdd','城固|chenggu|cg','城阳|chengyang|cy',
'城子坦|chengzitan|czt','池州|chizhou|cz','赤壁|chibi|cb','赤壁北|chibibei|cbb','赤峰|chifeng|cf',
'赤峰西|chifengxi|cfx','崇左|chongzuo|cz','滁州|chuzhou|cz','滁州北|chuzhoubei|czb','楚鲁图|chulutu|clt',
'楚山|chushan|cs','楚雄|chuxiong|cx','褚家湾|zhejiawan|zjw','串子沟|chuanzigou|czg','创业村|chuangyecun|cyc',
'春申|chunshen|cs','春亭阁|chuntingge|ctg','春阳|chunyang|cy','茨坝|ciba|cb','茨冲|cichong|cc',
'慈利|cili|cl','磁县|cixian|cx','磁窑|ciyao|cy','崔黄口|cuihuangkou|chk','翠峰|cuifeng|cf',
'翠岗|cuigang|cg','嵯岗|cigang|cg','达家沟|dajiagou|djg','达拉滨|dalabin|dlb','达拉特西|dalatexi|dltx',
'达日其嘎|dariqiga|drqg','达州|dazhou|dz','打柴沟|dachaigou|dcg','打羊|dayang|dy','大安北|daanbei|dab',
'大巴|daba|db','大坝|daba|db','大板|daban|db','大堡|dabao|db','大成|dacheng|dc',
'大磴沟|dadenggou|ddg','大东|dadong|dd','大关|daguan|dg','大观岭|daguanling|dgl','大官屯|daguantun|dgt',
'大罕|dahan|dh','大河坝|daheba|dhb','大红旗|dahongqi|dhq','大虎山|dahushan|dhs','大灰厂|dahuichang|dhc',
'大涧|dajian|dj','大苴|dazu|dz','大口钦|dakouqin|dkq','大口屯|dakoutun|dkt','大理|dali|dl',
'大荔|dali|dl','大连|dalian|dl','大连北|dalianbei|dlb','大林|dalin|dl','大陆号|daluhao|dlh',
'大民屯|damintun|dmt','大盘石|dapanshi|dps','大平房|dapingfang|dpf','大埔|dapu|dp','大其拉哈|daqilaha|dqlh',
'大青沟|daqinggou|dqg','大庆|daqing|dq','大庆西|daqingxi|dqx','大山铺|dashanpu|dsp','大深|dashen|ds',
'大石桥|dashiqiao|dsq','大石头|dashitou|dst','大石寨|dashizhai|dsz','大滩|datan|dt','大田边|datianbian|dtb',
'大同|datong|dt','大屯|datun|dt','大湾子|dawanzi|dwz','大乌苏|dawusu|dws','大武口|dawukou|dwk',
'大西|daxi|dx','大辛庄|daxinzhuang|dxz','大兴|daxing|dx','大兴沟|daxinggou|dxg','大徐屯|daxutun|dxt',
'大雅河|dayahe|dyh','大雁|dayan|dy','大扬气|dayangqi|dyq','大杨树|dayangshu|dys','大杨树东|dayangshudong|dysd',
'大洋洲|dayangzhou|dyz','大冶北|dayebei|dyb','大英东|dayingdong|dyd','大营|daying|dy','大营镇|dayingzhen|dyz',
'大战场|dazhanchang|dzc','大杖子|dazhangzi|dzz','大郑|dazheng|dz','大竹园|dazhuyuan|dzy','大足|dazu|dz',
'代马沟|daimagou|dmg','代湾|daiwan|dw','代县|daixian|dx','岱岳|daiyue|dy','带岭|dailing|dl',
'待王|daiwang|dw','丹东|dandong|dd','丹凤|danfeng|df','丹徒|dantu|dt','丹阳|danyang|dy',
'丹阳北|danyangbei|dyb','当雄|dangxiong|dx','当阳|dangyang|dy','砀山|dangshan|ds','刀尔登|daoerdeng|ded',
'到保|daobao|db','道德|daode|dd','道仑郭勒|daolunguole|dlgl','道清|daoqing|dq','道州|daozhou|dz',
'得耳布尔|deerbuer|debe','德安|dean|da','德伯斯|debosi|dbs','德昌|dechang|dc','德惠|dehui|dh',
'德惠西|dehuixi|dhx','德令哈|delingha|dlh','德清|deqing|dq','德清西|deqingxi|dqx','德日斯图|derisitu|drst',
'德阳|deyang|dy','德州|dezhou|dz','德州东|dezhoudong|dzd','灯塔|dengta|dt','登沙河|dengshahe|dsh',
'邓家湾|dengjiawan|djw','邓州|dengzhou|dz','低窝铺|diwopu|dwp','低庄|dizhuang|dz','滴道|didao|dd',
'甸心|dianxin|dx','刁家段|diaojiaduan|djd','定边|dingbian|db','定南|dingnan|dn','定陶|dingtao|dt',
'定西|dingxi|dx','定襄|dingxiang|dx','定远|dingyuan|dy','定州|dingzhou|dz','定州东|dingzhoudong|dzd',
'东安东|dongandong|dad','东边井|dongbianjing|dbj','东大坝|dongdaba|ddb','东戴河|dongdaihe|ddh','东二道河|dongerdaohe|dedh',
'东方红|dongfanghong|dfh','东丰|dongfeng|df','东富|dongfu|df','东沟门|donggoumen|dgm','东光|dongguang|dg',
'东海|donghai|dh','东海县|donghaixian|dhx','东津|dongjin|dj','东京城|dongjingcheng|djc','东来|donglai|dl',
'东明村|dongmingcun|dmc','东明县|dongmingxian|dmx','东坡|dongpo|dp','东升|dongsheng|ds','东升坝|dongshengba|dsb',
'东胜西|dongshengxi|dsx','东台|dongtai|dt','东田良|dongtianliang|dtl','东通化|dongtonghua|dth','东湾|dongwan|dw',
'东莞|dongguan|dg','东莞东|dongguandong|dgd','东乡|dongxiang|dx','东辛庄|dongxinzhuang|dxz','东兴|dongxing|dx',
'东营|dongying|dy','东营子|dongyingzi|dyz','东淤地|dongyudi|dyd','东元庆|dongyuanqing|dyq','东镇|dongzhen|dz',
'东至|dongzhi|dz','东庄|dongzhuang|dz','氡泉|dongquan|dq','洞庙河|dongmiaohe|dmh','都格|duge|dg',
'都江堰|dujiangyan|djy','都匀|duyun|dy','斗沟子|dougouzi|dgz','豆罗|douluo|dl','豆沙关|doushaguan|dsg',
'豆张庄|douzhangzhuang|dzz','独立屯|dulitun|dlt','独山|dushan|ds','杜家|dujia|dj','渡市|dushi|ds',
'对青山|duiqingshan|dqs','兑镇|duizhen|dz','敦化|dunhua|dh','敦煌|dunhuang|dh','峨边|ebian|eb',
'峨眉|emei|em','额济纳|ejina|ejn','鄂州|ezhou|ez','鄂州东|ezhoudong|ezd','恩施|enshi|es',
'尔赛河|ersaihe|esh','二岔|ercha|ec','二道沟|erdaogou|edg','二道沟门|erdaogoumen|edgm','二道桥|erdaoqiao|edq',
'二道湾|erdaowan|edw','二道岩|erdaoyan|edy','二连|erlian|el','二龙|erlong|el','二密河|ermihe|emh',
'二营|erying|ey','发耳|faer|fe','繁峙|fanshi|fs','范家屯|fanjiatun|fjt','范镇|fanzhen|fz',
'防城港北|fangchenggangbei|fcgb','肥东|feidong|fd','费县|feixian|fx','分宜|fenyi|fy','汾阳|fenyang|fy',
'丰城|fengcheng|fc','丰城南|fengchengnan|fcn','丰都|fengdu|fd','丰广|fengguang|fg','丰乐镇|fenglezhen|flz',
'丰水村|fengshuicun|fsc','丰顺|fengshun|fs','丰镇|fengzhen|fz','风陵渡|fenglingdu|fld','风水沟|fengshuigou|fsg',
'封丘|fengqiu|fq','峰洞|fengdong|fd','峰高铺|fenggaopu|fgp','冯家山|fengjiashan|fjs','冯屯|fengtun|ft',
'凤凰城|fenghuangcheng|fhc','凤县|fengxian|fx','凤翔|fengxiang|fx','凤阳|fengyang|fy','凤州|fengzhou|fz',
'奉化|fenghua|fh','佛岭|foling|fl','佛山|foshan|fs','扶绥|fusui|fs','扶余|fuyu|fy',
'扶余北|fuyubei|fyb','浮图峪|futuyu|fty','涪陵|fuling|fl','涪陵北|fulingbei|flb','福安|fuan|fa',
'福德|fude|fd','福鼎|fuding|fd','福海|fuhai|fh','福巨|fuju|fj','福利屯|fulitun|flt',
'福临堡|fulinbao|flb','福清|fuqing|fq','福泉|fuquan|fq','福山口|fushankou|fsk','福生庄|fushengzhuang|fsz',
'福兴地|fuxingdi|fxd','福州|fuzhou|fz','福州南|fuzhounan|fzn','抚宁|funing|fn','抚顺|fushun|fs',
'抚顺北|fushunbei|fsb','抚远|fuyuan|fy','抚州|fuzhou|fz','阜南|funan|fn','阜宁|funing|fn',
'阜新|fuxin|fx','阜阳|fuyang|fy','富川|fuchuan|fc','富海|fuhai|fh','富锦|fujin|fj',
'富拉尔基|fulaerji|flej','富县|fuxian|fx','富县东|fuxiandong|fxd','富裕|fuyu|fy','富源|fuyuan|fy',
'嘎拉德斯汰|galadesitai|gldst','嘎什甸子|gashendianzi|gsdz','盖州|gaizhou|gz','盖州西|gaizhouxi|gzx','干沟|gangou|gg',
'干塘|gantang|gt','干溪沟|ganxigou|gxg','甘草店|gancaodian|gcd','甘谷|gangu|gg','甘河|ganhe|gh',
'甘洛|ganluo|gl','甘旗卡|ganqika|gqk','甘泉北|ganquanbei|gqb','甘棠|gantang|gt','泔溪|ganxi|gx',
'赶水|ganshui|gs','感德|gande|gd','赣县|ganxian|gx','赣州|ganzhou|gz','赣州东|ganzhoudong|gzd',
'刚察|gangcha|gc','皋兰|gaolan|gl','高碑店|gaobeidian|gbd','高碑店东|gaobeidiandong|gbdd','高村|gaocun|gc',
'高峰|gaofeng|gf','高各庄|gaogezhuang|ggz','高谷|gaogu|gg','高家|gaojia|gj','高家村|gaojiacun|gjc',
'高梁铺|gaoliangpu|glp','高林屯|gaolintun|glt','高炉子|gaoluzi|glz','高密|gaomi|gm','高平|gaoping|gp',
'高桥镇|gaoqiaozhen|gqz','高山子|gaoshanzi|gsz','高台|gaotai|gt','高台子|gaotaizi|gtz','高滩|gaotan|gt',
'高潭子|gaotanzi|gtz','高头|gaotou|gt','高兴镇|gaoxingzhen|gxz','高阳镇|gaoyangzhen|gyz','高邑|gaoyi|gy',
'高邑西|gaoyixi|gyx','高州|gaozhou|gz','藁城|gaocheng|gc','鸽子洞|gezidong|gzd','革居|geju|gj',
'格尔木|geermu|gem','葛店南|gediannan|gdn','葛根庙|gegenmiao|ggm','蛤蟆塘|hamatang|hmt','根河|genhe|gh',
'工农湖|gongnonghu|gnh','公积坂|gongjiban|gjb','公庙子|gongmiaozi|gmz','公兴|gongxing|gx','公营子|gongyingzi|gyz',
'公主埂|gongzhugeng|gzg','公主岭|gongzhuling|gzl','公主岭南|gongzhulingnan|gzln','巩义|gongyi|gy','巩义南|gongyinan|gyn',
'共和|gonghe|gh','共青城|gongqingcheng|gqc','沟帮子|goubangzi|gbz','沟口|goukou|gk','姑家堡|gujiabao|gjb',
'孤家子|gujiazi|gjz','孤山|gushan|gs','孤山口|gushankou|gsk','孤山子|gushanzi|gsz','菇园|guyuan|gy',
'古城|gucheng|gc','古城镇|guchengzhen|gcz','古城子|guchengzi|gcz','古东|gudong|gd','古家沱|gujiatuo|gjt',
'古交|gujiao|gj','古浪|gulang|gl','古莲|gulian|gl','古鲁满汗|gulumanhan|glmh','古田|gutian|gt',
'古源|guyuan|gy','古镇|guzhen|gz','谷城|gucheng|gc','固始|gushi|gs','固原|guyuan|gy',
'固镇|guzhen|gz','瓜州|guazhou|gz','关村坝|guancunba|gcb','关林|guanlin|gl','关寨|guanzhai|gz',
'官高|guangao|gg','官厅|guanting|gt','官字井|guanzijing|gzj','冠朝|guanchao|gc','冠豸山|guanzhishan|gzs',
'灌水|guanshui|gs','光明|guangming|gm','光明城|guangmingcheng|gmc','光泽|guangze|gz','广安|guangan|ga',
'广德|guangde|gd','广德号|guangdehao|gdh','广汉|guanghan|gh','广南卫|guangnanwei|gnw','广宁寺|guangningsi|gns',
'广水|guangshui|gs','广顺场|guangshunchang|gsc','广通北|guangtongbei|gtb','广元|guangyuan|gy','广州|guangzhou|gz',
'广州北|guangzhoubei|gzb','广州东|guangzhoudong|gzd','广州南|guangzhounan|gzn','归流河|guiliuhe|glh','贵定|guiding|gd',
'贵定南|guidingnan|gdn','贵港|guigang|gg','贵溪|guixi|gx','贵阳|guiyang|gy','桂林|guilin|gl',
'桂平|guiping|gp','郭尔奔敖包|guoerbenaobao|gebab','郭家店|guojiadian|gjd','郭家屯|guojiatun|gjt','果松|guosong|gs',
'哈川|hachuan|hc','哈达|hada|hd','哈达阳|hadayang|hdy','哈尔巴岭|haerbaling|hebl','哈尔滨|haerbin|heb',
'哈尔滨东|haerbindong|hebd','哈尔滨西|haerbinxi|hebx','哈尔盖|haergai|heg','哈克|hake|hk','哈拉海|halahai|hlh',
'哈拉苏|halasu|hls','哈力图|halitu|hlt','哈密南|haminan|hmn','哈日努拉|harinula|hrnl','哈业胡同|hayehutong|hyht',
'海安县|haianxian|hax','海北|haibei|hb','海城|haicheng|hc','海城西|haichengxi|hcx','海口|haikou|hk',
'海口东|haikoudong|hkd','海拉尔|hailaer|hle','海浪|hailang|hl','海林|hailin|hl','海龙|hailong|hl',
'海伦|hailun|hl','海宁|haining|hn','海宁西|hainingxi|hnx','海石湾|haishiwan|hsw','海坨子|haituozi|htz',
'海湾|haiwan|hw','海晏|haiyan|hy','海阳|haiyang|hy','邯郸|handan|hd','邯郸东|handandong|hdd',
'涵江|hanjiang|hj','寒葱沟|hanconggou|hcg','寒岭|hanling|hl','韩城|hancheng|hc','韩府湾|hanfuwan|hfw',
'韩麻营|hanmaying|hmy','汉川|hanchuan|hc','汉口|hankou|hk','汉阴|hanyin|hy','汉源|hanyuan|hy',
'汉中|hanzhong|hz','汗苏鲁|hansulu|hsl','杭锦旗|hangjinqi|hjq','杭州|hangzhou|hz','杭州东|hangzhoudong|hzd',
'好鲁库|haoluku|hlk','浩良河|haolianghe|hlh','合川|hechuan|hc','合肥|hefei|hf','合肥北城|hefeibeicheng|hfbc',
'合浦|hepu|hp','合阳|heyang|hy','何三家|hesanjia|hsj','和静|hejing|hj','和龙|helong|hl',
'和平|heping|hp','和什托洛盖|heshentuoluogai|hstlg','和田|hetian|ht','河边|hebian|hb','河唇|hechun|hc',
'河津|hejin|hj','河口南|hekounan|hkn','河洛营|heluoying|hly','河源|heyuan|hy','核桃园|hetaoyuan|hty',
'菏泽|heze|hz','贺家店|hejiadian|hjd','贺日斯台|herisitai|hrst','贺胜桥东|heshengqiaodong|hsqd','贺州|hezhou|hz',
'赫尔洪得|heerhongde|hehd','鹤北|hebei|hb','鹤壁|hebi|hb','鹤壁东|hebidong|hbd','鹤岗|hegang|hg',
'鹤立|heli|hl','鹤庆|heqing|hq','鹤山|heshan|hs','黑冲滩|heichongtan|hct','黑岗|heigang|hg',
'黑河|heihe|hh','黑井|heijing|hj','黑水|heishui|hs','黑台|heitai|ht','黑旺|heiwang|hw',
'恒地营|hengdiying|hdy','横道河子|hengdaohezi|hdhz','横峰|hengfeng|hf','横岗|henggang|hg','横沟桥东|henggouqiaodong|hgqd',
'横江|hengjiang|hj','横现河|hengxianhe|hxh','衡山|hengshan|hs','衡山西|hengshanxi|hsx','衡水|hengshui|hs',
'衡阳|hengyang|hy','衡阳东|hengyangdong|hyd','红安西|honganxi|hax','红房子|hongfangzi|hfz','红峰|hongfeng|hf',
'红光镇|hongguangzhen|hgz','红果|hongguo|hg','红花沟|honghuagou|hhg','红花园|honghuayuan|hhy','红江|hongjiang|hj',
'红柳河|hongliuhe|hlh','红旗营|hongqiying|hqy','红砂坝|hongshaba|hsb','红砂岘|hongshaxian|hsx','红山|hongshan|hs',
'红寺堡|hongsibao|hsb','红卫坝|hongweiba|hwb','红岘台|hongxiantai|hxt','红兴隆|hongxinglong|hxl','红星|hongxing|hx',
'红彦|hongyan|hy','宏庆|hongqing|hq','宏图|hongtu|ht','洪洞|tongdong|td','洪洞西|tongdongxi|tdx',
'洪河|honghe|hh','侯马|houma|hm','侯马西|houmaxi|hmx','猴山|houshan|hs','后寨|houzhai|hz',
'鲘门|houmen|hm','呼和浩特|huhehaote|hhht','呼和浩特东|huhehaotedong|hhhtd','呼兰|hulan|hl','呼鲁斯太|hulusitai|hlst',
'呼源|huyuan|hy','呼中|huzhong|hz','湖潮|huchao|hc','湖口|hukou|hk','湖头|hutou|ht',
'湖州|huzhou|hz','葫芦岛|huludao|hld','葫芦岛北|huludaobei|hldb','虎尔虎拉|huerhula|hehl','虎峰|hufeng|hf',
'虎林|hulin|hl','虎门|humen|hm','虎山|hushan|hs','互助|huzhu|hz','花湖|huahu|hh',
'花家庄|huajiazhuang|hjz','花棚子|huapengzi|hpz','花桥|huaqiao|hq','花山南|huashannan|hsn','花土坡|huatupo|htp',
'花园|huayuan|hy','华城|huacheng|hc','华容|huarong|hr','华容东|huarongdong|hrd','华容南|huarongnan|hrn',
'华山|huashan|hs','华山北|huashanbei|hsb','华蓥|huaying|hy','滑县南|huaxiannan|hxn','化处|huachu|hc',
'化德|huade|hd','化州|huazhou|hz','画桥|huaqiao|hq','桦林|hualin|hl','桦南|huanan|hn',
'桦皮厂|huapichang|hpc','怀化|huaihua|hh','怀仁|huairen|hr','怀仁东|huairendong|hrd','怀柔|huairou|hr',
'怀柔北|huairoubei|hrb','淮安|huaian|ha','淮北|huaibei|hb','淮滨|huaibin|hb','淮南|huainan|hn',
'淮南东|huainandong|hnd','桓龙湖|huanlonghu|hlh','换新天|huanxintian|hxt','荒沟西|huanggouxi|hgx','黄柏|huangbai|hb',
'黄村|huangcun|hc','黄冈|huanggang|hg','黄冈东|huanggangdong|hgd','黄冈西|huanggangxi|hgx','黄瓜园|huangguayuan|hgy',
'黄花筒|huanghuatong|hht','黄家坝|huangjiaba|hjb','黄家店|huangjiadian|hjd','黄甲屯|huangjiatun|hjt','黄口|huangkou|hk',
'黄联关|huanglianguan|hlg','黄磏|huanglian|hl','黄陵|huangling|hl','黄梅|huangmei|hm','黄泥河|huangnihe|hnh',
'黄泥崴子|huangniweizi|hnwz','黄平|huangping|hp','黄山|huangshan|hs','黄石|huangshi|hs','黄石北|huangshibei|hsb',
'黄水塘|huangshuitang|hst','黄松甸|huangsongdian|hsd','黄桶|huangtong|ht','黄羊滩|huangyangtan|hyt','黄羊湾|huangyangwan|hyw',
'黄羊镇|huangyangzhen|hyz','黄州|huangzhou|hz','湟源|huangyuan|hy','潢川|huangchuan|hc','徽县|huixian|hx',
'汇流河|huiliuhe|hlh','汇塘河|huitanghe|hth','会同|huitong|ht','惠东|huidong|hd','惠农|huinong|hn',
'惠山|huishan|hs','惠州|huizhou|hz','惠州南|huizhounan|hzn','惠州西|huizhouxi|hzx','火炬沟|huojugou|hjg',
'火烧寨|huoshaozhai|hsz','获嘉|huojia|hj','霍尔果斯|huoerguosi|hegs','霍林郭勒|huolinguole|hlgl','霍邱|huoqiu|hq',
'霍州|huozhou|hz','霍州东|huozhoudong|hzd','芨岭|jiling|jl','鸡东|jidong|jd','鸡冠山|jiguanshan|jgs',
'鸡西|jixi|jx','绩溪县|jixixian|jxx','吉安|jian|ja','吉安南|jiannan|jan','吉林|jilin|jl',
'吉首|jishou|js','吉舒|jishu|js','吉水|jishui|js','吉文|jiwen|jw','吉新河|jixinhe|jxh',
'集安|jian|ja','集宁南|jiningnan|jnn','纪家沟|jijiagou|jjg','济南|jinan|jn','济南东|jinandong|jnd',
'济南西|jinanxi|jnx','济宁|jining|jn','济源|jiyuan|jy','蓟县|jixian|jx','稷山|jishan|js',
'加格达奇|jiagedaqi|jgdq','加劳|jialao|jl','加南|jianan|jn','夹心子|jiaxinzi|jxz','佳木斯|jiamusi|jms',
'嘉峰|jiafeng|jf','嘉善|jiashan|js','嘉善南|jiashannan|jsn','嘉祥|jiaxiang|jx','嘉兴|jiaxing|jx',
'嘉兴南|jiaxingnan|jxn','嘉峪关|jiayuguan|jyg','甲山|jiashan|js','简阳|jianyang|jy','碱柜|jianju|jj',
'建昌|jianchang|jc','建湖|jianhu|jh','建宁县北|jianningxianbei|jnxb','建瓯|jianou|jo','建三江|jiansanjiang|jsj',
'建设|jianshe|js','建始|jianshi|js','建水|jianshui|js','建阳|jianyang|jy','涧池铺|jianchipu|jcp',
'江都|jiangdu|jd','江华|jianghua|jh','江津|jiangjin|jj','江门|jiangmen|jm','江密峰|jiangmifeng|jmf',
'江宁|jiangning|jn','江桥|jiangqiao|jq','江山|jiangshan|js','江所田|jiangsuotian|jst','江西村|jiangxicun|jxc',
'江永|jiangyong|jy','江油|jiangyou|jy','江源|jiangyuan|jy','姜家|jiangjia|jj','姜堰|jiangyan|jy',
'将乐|jiangle|jl','交城|jiaocheng|jc','胶州|jiaozhou|jz','胶州北|jiaozhoubei|jzb','焦作|jiaozuo|jz',
'蛟河|jiaohe|jh','蕉溪|jiaoxi|jx','角美|jiaomei|jm','揭阳|jieyang|jy','介休|jiexiu|jx',
'介休东|jiexiudong|jxd','界山|jieshan|js','界首市|jieshoushi|jss','金宝屯|jinbaotun|jbt','金昌|jinchang|jc',
'金场堡|jinchangbao|jcb','金城江|jinchengjiang|jcj','金刚沱|jingangtuo|jgt','金沟屯|jingoutun|jgt','金河|jinhe|jh',
'金华西|jinhuaxi|jhx','金鸡村|jinjicun|jjc','金家店|jinjiadian|jjd','金坑|jinkeng|jk','金口河|jinkouhe|jkh',
'金马村|jinmacun|jmc','金山北|jinshanbei|jsb','金山屯|jinshantun|jst','金山湾|jinshanwan|jsw','金山卫|jinshanwei|jsw',
'金山园区|jinshanyuanqu|jsyq','金银川|jinyinchuan|jyc','金寨|jinzhai|jz','金杖子|jinzhangzi|jzz','金钟|jinzhong|jz',
'金州|jinzhou|jz','锦和|jinhe|jh','锦州|jinzhou|jz','锦州南|jinzhounan|jzn','劲松|jingsong|js',
'进贤|jinxian|jx','晋城|jincheng|jc','晋城北|jinchengbei|jcb','晋江|jinjiang|jj','晋中|jinzhong|jz',
'晋州|jinzhou|jz','缙云|jinyun|jy','京山|jingshan|js','经棚|jingpeng|jp','荆门|jingmen|jm',
'荆州|jingzhou|jz','精河|jinghe|jh','精河南|jinghenan|jhn','井冈山|jinggangshan|jgs','井南|jingnan|jn',
'井陉|jingxing|jx','景德镇|jingdezhen|jdz','景泰|jingtai|jt','敬梓场|jingzichang|jzc','靖边|jingbian|jb',
'靖远|jingyuan|jy','靖远西|jingyuanxi|jyx','靖州|jingzhou|jz','静海|jinghai|jh','镜铁山|jingtieshan|jts',
'九江|jiujiang|jj','九里|jiuli|jl','九龙|jiulong|jl','九龙塘|jiulongtang|jlt','九三|jiusan|js',
'九台|jiutai|jt','九台南|jiutainan|jtn','九营|jiuying|jy','酒泉|jiuquan|jq','旧庄窝|jiuzhuangwo|jzw',
'莒南|junan|jn','莒县|juxian|jx','句容西|jurongxi|jrx','巨宝|jubao|jb','巨亭|juting|jt',
'巨野|juye|jy','鄄城|juancheng|jc','军粮城北|junliangchengbei|jlcb','峻德|junde|jd','喀喇其|kalaqi|klq',
'喀什|kashen|ks','卡路屯|kalutun|klt','卡伦|kalun|kl','开安|kaian|ka','开道|kaidao|kd',
'开封|kaifeng|kf','开江|kaijiang|kj','开鲁|kailu|kl','开通|kaitong|kt','开原|kaiyuan|ky',
'开原西|kaiyuanxi|kyx','凯北|kaibei|kb','凯里|kaili|kl','康金井|kangjinjing|kjj','康庄|kangzhuang|kz',
'柯柯|keke|kk','柯坪|keping|kp','岢岚|kelan|kl','克东|kedong|kd','克拉玛依|kelamayi|klmy',
'克山|keshan|ks','克一河|keyihe|kyh','孔家沟|kongjiagou|kjg','孔垄|konglong|kl','孔滩|kongtan|kt',
'孔庄|kongzhuang|kz','口前|kouqian|kq','库车|kuche|kc','库都尔|kuduer|kde','库尔勒|kuerle|kel',
'库伦|kulun|kl','宽甸|kuandian|kd','宽沟|kuangou|kg','奎山|kuishan|ks','奎屯|kuitun|kt',
'葵潭|kuitan|kt','昆都庙|kundumiao|kdm','昆独仑召|kundulunzhao|kdlz','昆明|kunming|km','昆明西|kunmingxi|kmx',
'昆山|kunshan|ks','昆山南|kunshannan|ksn','昆阳|kunyang|ky','拉白|labai|lb','拉古|lagu|lg',
'拉哈|laha|lh','拉林|lalin|ll','拉萨|lasa|ls','拉鲊|lazha|lz','砬子河|lazihe|lzh',
'喇嘛甸|lamadian|lmd','喇嘛山|lamashan|lms','来宾|laibin|lb','来宾北|laibinbei|lbb','来舟|laizhou|lz',
'涞源|laiyuan|ly','莱芜东|laiwudong|lwd','莱芜西|laiwuxi|lwx','莱西|laixi|lx','濑湍|laituan|lt',
'兰岗|langang|lg','兰家屯|lanjiatun|ljt','兰考|lankao|lk','兰棱|lanleng|ll','兰岭|lanling|ll',
'兰溪|lanxi|lx','兰州|lanzhou|lz','兰州东|lanzhoudong|lzd','栏杆滩|langantan|lgt','蓝村|lancun|lc',
'滥坝|lanba|lb','狼尾山|langweishan|lws','廊坊|langfang|lf','廊坊北|langfangbei|lfb','朗乡|langxiang|lx',
'劳动屯|laodongtun|ldt','醪桥|laoqiao|lq','老边|laobian|lb','老府|laofu|lf','老锅厂|laoguochang|lgc',
'老莱|laolai|ll','老岭|laoling|ll','老羊壕|laoyanghao|lyh','老爷岭|laoyeling|lyl','老营|laoying|ly',
'乐昌|lechang|lc','乐都|ledu|ld','乐平市|lepingshi|lps','乐清|leqing|lq','乐山|leshan|ls',
'乐善村|leshancun|lsc','乐素河|lesuhe|lsh','乐武|lewu|lw','乐跃|leyue|ly','雷州|leizhou|lz',
'耒阳|leiyang|ly','耒阳西|leiyangxi|lyx','冷水江东|lengshuijiangdong|lsjd','梨树镇|lishuzhen|lsz','离堆公园|liduigongyuan|ldgy',
'黎塘|litang|lt','李家|lijia|lj','李家河|lijiahe|ljh','李家坪|lijiaping|ljp','李家湾|lijiawan|ljw',
'李石寨|lishizhai|lsz','李市镇|lishizhen|lsz','李旺|liwang|lw','李子沟|lizigou|lzg','里木店|limudian|lmd',
'理家坪|lijiaping|ljp','澧县|lixian|lx','醴陵|liling|ll','立志|lizhi|lz','丽江|lijiang|lj',
'丽水|lishui|ls','利川|lichuan|lc','励家|lijia|lj','溧水|lishui|ls','溧阳|liyang|ly',
'连江|lianjiang|lj','连山关|lianshanguan|lsg','连云港|lianyungang|lyg','连云港东|lianyungangdong|lygd','连珠山|lianzhushan|lzs',
'涟源|lianyuan|ly','莲东|liandong|ld','莲花山|lianhuashan|lhs','莲江口|lianjiangkou|ljk','莲塘|liantang|lt',
'联合乡|lianhexiang|lhx','廉江|lianjiang|lj','良各庄|lianggezhuang|lgz','凉红|lianghong|lh','凉水井|liangshuijing|lsj',
'梁底下|liangdixia|ldx','梁平|liangping|lp','梁山|liangshan|ls','两当|liangdang|ld','两家|liangjia|lj',
'亮甲店|liangjiadian|ljd','辽阳|liaoyang|ly','辽源|liaoyuan|ly','辽中|liaozhong|lz','聊城|liaocheng|lc',
'了墩|ledun|ld','林东|lindong|ld','林海|linhai|lh','林家台|linjiatai|ljt','林口|linkou|lk',
'林盛堡|linshengbao|lsb','林西|linxi|lx','林源|linyuan|ly','林子头|linzitou|lzt','临巴溪|linbaxi|lbx',
'临汾|linfen|lf','临汾西|linfenxi|lfx','临海|linhai|lh','临河|linhe|lh','临江|linjiang|lj',
'临江场|linjiangchang|ljc','临江溪|linjiangxi|ljx','临清|linqing|lq','临西|linxi|lx','临湘|linxiang|lx',
'临沂|linyi|ly','临沂北|linyibei|lyb','临颍|linying|ly','临泽|linze|lz','蔺家楼|linjialou|ljl',
'灵宝|lingbao|lb','灵宝西|lingbaoxi|lbx','灵丘|lingqiu|lq','灵山|lingshan|ls','灵石|lingshi|ls',
'灵石东|lingshidong|lsd','灵武|lingwu|lw','岭北|lingbei|lb','岭南|lingnan|ln','凌海|linghai|lh',
'凌源|lingyuan|ly','凌源东|lingyuandong|lyd','陵水|lingshui|ls','零陵|lingling|ll','刘沟|liugou|lg',
'刘家店|liujiadian|ljd','刘家河|liujiahe|ljh','流水沟|liushuigou|lsg','留庄|liuzhuang|lz','柳河|liuhe|lh',
'柳家庄|liujiazhuang|ljz','柳林河|liulinhe|llh','柳林南|liulinnan|lln','柳毛|liumao|lm','柳毛沟|liumaogou|lmg',
'柳树|liushu|ls','柳树泉|liushuquan|lsq','柳树屯|liushutun|lst','柳园|liuyuan|ly','柳州|liuzhou|lz',
'六安|luan|la','六道河|liudaohe|ldh','六道河子|liudaohezi|ldhz','六地沟|liudigou|ldg','六个鸡|liugeji|lgj',
'六合镇|luhezhen|lhz','六盘山|liupanshan|lps','六盘水|liupanshui|lps','六枝|liuzhi|lz','龙伯屯|longbotun|lbt',
'龙池|longchi|lc','龙川|longchuan|lc','龙船|longchuan|lc','龙沟|longgou|lg','龙骨甸|longgudian|lgd',
'龙华|longhua|lh','龙嘉|longjia|lj','龙江|longjiang|lj','龙井|longjing|lj','龙口|longkou|lk',
'龙里|longli|ll','龙南|longnan|ln','龙泉寺|longquansi|lqs','龙山镇|longshanzhen|lsz','龙市|longshi|ls',
'龙塘坝|longtangba|ltb','龙岩|longyan|ly','龙游|longyou|ly','龙爪沟|longzhuagou|lzg','隆昌|longchang|lc',
'隆化|longhua|lh','陇西|longxi|lx','陇县|longxian|lx','娄底|loudi|ld','娄山关|loushanguan|lsg',
'露水河|lushuihe|lsh','卢龙|lulong|ll','庐江|lujiang|lj','庐山|lushan|ls','芦潮港|luchaogang|lcg',
'芦沟|lugou|lg','芦家村|lujiacun|ljc','芦家庄|lujiazhuang|ljz','芦台|lutai|lt','芦溪|luxi|lx',
'胪滨|lubin|lb','鲁番|lufan|lf','鲁河|luhe|lh','鲁山|lushan|ls','陆川|luchuan|lc',
'陆丰|lufeng|lf','陆良|luliang|ll','鹿道|ludao|ld','鹿寨|luzhai|lz','禄丰南|lufengnan|lfn',
'路口铺|lukoupu|lkp','吕梁|lvliang|ll','绿化|lvhua|lh','绿潭|lvtan|lt','滦河|luanhe|lh',
'滦河沿|luanheyan|lhy','滦平|luanping|lp','滦县|luanxian|lx','略阳|lveyang|ly','罗江|luojiang|lj',
'罗平|luoping|lp','罗山|luoshan|ls','罗源|luoyuan|ly','洛门|luomen|lm','洛阳|luoyang|ly',
'洛阳东|luoyangdong|lyd','洛阳龙门|luoyanglongmen|lylm','骆驼巷|luotuoxiang|ltx','珞璜|luohuang|lh','落垡|luofa|lf',
'落坡岭|luopoling|lpl','漯河|luohe|lh','漯河西|luohexi|lhx','麻城|macheng|mc','麻城北|machengbei|mcb',
'麻江|majiang|mj','麻栗|mali|ml','麻柳|maliu|ml','麻山|mashan|ms','麻旺|mawang|mw',
'麻尾|mawei|mw','麻阳|mayang|my','马鞍山|maanshan|mas','马场|machang|mc','马村|macun|mc',
'马盖图|magaitu|mgt','马架子|majiazi|mjz','马莲河|malianhe|mlh','马林|malin|ml','马龙|malong|ml',
'马桥河|maqiaohe|mqh','马三家|masanjia|msj','马蹄湾|matiwan|mtw','玛纳斯|manasi|mns','满归|mangui|mg',
'满洲里|manzhouli|mzl','毛坝|maoba|mb','毛坝关|maobaguan|mbg','毛告吐|maogaotu|mgt','茅草坪|maocaoping|mcp',
'茂林|maolin|ml','茂名|maoming|mm','茂名东|maomingdong|mmd','茂舍祖|maoshezu|msz','帽儿山|maoershan|mes',
'眉山|meishan|ms','梅河口|meihekou|mhk','梅花山|meihuashan|mhs','梅江|meijiang|mj','梅州|meizhou|mz',
'煤田|meitian|mt','美岱召|meidaizhao|mdz','美兰|meilan|ml','美溪|meixi|mx','门达|menda|md',
'猛洞河|mengdonghe|mdh','猛鹫山|mengjiushan|mjs','蒙渡|mengdu|md','蒙自北|mengzibei|mzb','孟家岗|mengjiagang|mjg',
'孟津|mengjin|mj','弥渡|midu|md','米沙子|mishazi|msz','米易|miyi|my','米脂|mizhi|mz',
'汨罗|miluo|ml','汨罗东|miluodong|mld','密山|mishan|ms','密山西|mishanxi|msx','密云|miyun|my',
'绵阳|mianyang|my','免渡河|mianduhe|mdh','勉县|mianxian|mx','冕宁|mianning|mn','冕山|mianshan|ms',
'庙城|miaocheng|mc','庙宫|miaogong|mg','庙岭|miaoling|ml','庙山|miaoshan|ms','庙阳|miaoyang|my',
'庙庄|miaozhuang|mz','民福寺|minfusi|mfs','民权|minquan|mq','民族|minzu|mz','闽清|minqing|mq',
'明安|mingan|ma','明城|mingcheng|mc','明港|minggang|mg','明港东|minggangdong|mgd','明光|mingguang|mg',
'明水河|mingshuihe|msh','明阳|mingyang|my','明珠|mingzhu|mz','磨刀石|modaoshi|mds','磨滩|motan|mt',
'磨溪|moxi|mx','莫尔道嘎|moerdaoga|medg','漠河|mohe|mh','墨玉|moyu|my','牡丹江|mudanjiang|mdj',
'木里图|mulitu|mlt','木竹河|muzhuhe|mzh','沐滂|mupang|mp','牧原|muyuan|my','穆棱|muling|ml',
'内江|neijiang|nj','内江南|neijiangnan|njn','内乡|neixiang|nx','那曲|neiqu|nq','乃林|nailin|nl',
'奈曼|naiman|nm','南安|nanan|na','南博山|nanboshan|nbs','南岔|nancha|nc','南昌|nanchang|nc',
'南昌西|nanchangxi|ncx','南陈铺|nanchenpu|ncp','南城|nancheng|nc','南城司|nanchengsi|ncs','南充|nanchong|nc',
'南仇|nanchou|nc','南大庙|nandamiao|ndm','南丹|nandan|nd','南尔岗|nanergang|neg','南芬|nanfen|nf',
'南丰|nanfeng|nf','南宫东|nangongdong|ngd','南关岭|nanguanling|ngl','南观村|nanguancun|ngc','南河川|nanhechuan|nhc',
'南湖东|nanhudong|nhd','南华|nanhua|nh','南京|nanjing|nj','南京南|nanjingnan|njn','南靖|nanjing|nj',
'南口|nankou|nk','南口前|nankouqian|nkq','南朗|nanlang|nl','南木|nanmu|nm','南宁|nanning|nn',
'南票|nanpiao|np','南平|nanping|np','南平南|nanpingnan|npn','南桥|nanqiao|nq','南汤|nantang|nt',
'南塘镇|nantangzhen|ntz','南通|nantong|nt','南头|nantou|nt','南洼|nanwa|nw','南湾子|nanwanzi|nwz',
'南翔北|nanxiangbei|nxb','南兴安|nanxingan|nxa','南阳|nanyang|ny','南峪|nanyu|ny','南杂木|nanzamu|nzm',
'南召|nanzhao|nz','闹海营|naohaiying|nhy','讷尔克气|neerkeqi|nekq','讷河|nehe|nh','嫩江|nenjiang|nj',
'能家|nengjia|nj','尼波|nibo|nb','尼勒克|nileke|nlk','尼日|niri|nr','泥河子|nihezi|nhz',
'鲇鱼山|nianyushan|nys','碾子山|nianzishan|nzs','娘娘庙|niangniangmiao|nnm','娘子关|niangziguan|nzg','捏掌|niezhang|nz',
'聂河|niehe|nh','宁安|ningan|na','宁波|ningbo|nb','宁德|ningde|nd','宁国|ningguo|ng',
'宁海|ninghai|nh','宁家|ningjia|nj','宁陵县|ninglingxian|nlx','宁明|ningming|nm','宁武|ningwu|nw',
'牛耳河|niuerhe|neh','牛汾台|niufentai|nft','牛家|niujia|nj','牛家营子|niujiayingzi|njyz','牛坪子|niupingzi|npz',
'牛心台|niuxintai|nxt','牛庄|niuzhuang|nz','农安|nongan|na','女儿河|nverhe|neh','暖泉|nuanquan|nq',
'欧里|ouli|ol','攀枝花|panzhihua|pzh','盘古|pangu|pg','盘古寺|pangusi|pgs','盘关|panguan|pg',
'盘锦|panjin|pj','盘锦北|panjinbei|pjb','磐安镇|pananzhen|paz','磐石|panshi|ps','泡子|paozi|pz',
'裴德|peide|pd','彭山|pengshan|ps','彭水|pengshui|ps','彭阳|pengyang|py','彭泽|pengze|pz',
'彭州|pengzhou|pz','蓬溪|pengxi|px','邳州|pizhou|pz','皮口|pikou|pk','皮山|pishan|ps',
'郫县|pixian|px','郫县西|pixianxi|pxx','椑木镇|beimuzhen|bmz','偏岭|pianling|pl','瓢儿屯|piaoertun|pet',
'平安|pingan|pa','平安驿|pinganyi|pay','平等|pingdeng|pd','平顶庙|pingdingmiao|pdm','平顶山|pingdingshan|pds',
'平顶山西|pingdingshanxi|pdsx','平房|pingfang|pf','平关|pingguan|pg','平果|pingguo|pg','平河口|pinghekou|phk',
'平凉|pingliang|pl','平凉南|pingliangnan|pln','平罗|pingluo|pl','平南南|pingnannan|pnn','平泉|pingquan|pq',
'平山|pingshan|ps','平社|pingshe|ps','平台|pingtai|pt','平田|pingtian|pt','平旺|pingwang|pw',
'平型关|pingxingguan|pxg','平洋|pingyang|py','平遥|pingyao|py','平遥古城|pingyaogucheng|pygc','平邑|pingyi|py',
'平峪|pingyu|py','平原|pingyuan|py','平原堡|pingyuanbao|pyb','平庄|pingzhuang|pz','平庄南|pingzhuangnan|pzn',
'凭祥|pingxiang|px','坪石|pingshi|ps','萍乡|pingxiang|px','坡底村|podicun|pdc','坡底下|podixia|pdx',
'莆田|putian|pt','葡萄菁|putaojing|ptj','蒲坝|puba|pb','蒲城|pucheng|pc','蒲城东|puchengdong|pcd',
'普安|puan|pa','普定|puding|pd','普洱渡|puerdu|ped','普兰店|pulandian|pld','普宁|puning|pn',
'普湾|puwan|pw','普雄|puxiong|px','七甸|qidian|qd','七里河|qilihe|qlh','七龙星|qilongxing|qlx',
'七泉湖|qiquanhu|qqh','七苏木|qisumu|qsm','七台河|qitaihe|qth','七营|qiying|qy','戚墅堰|qishuyan|qsy',
'祁东|qidong|qd','祁东北|qidongbei|qdb','祁家堡|qijiabao|qjb','祁门|qimen|qm','祁县|qixian|qx',
'祁县东|qixiandong|qxd','祁阳|qiyang|qy','齐哈日格图|qiharigetu|qhrgt','齐齐哈尔|qiqihaer|qqhe','岐山|qishan|qs',
'奇峰塔|qifengta|qft','棋盘|qipan|qp','旗下营|qixiaying|qxy','綦江|qijiang|qj','蕲春|qichun|qc',
'千河|qianhe|qh','千阳|qianyang|qy','迁安|qianan|qa','前锋|qianfeng|qf','前进镇|qianjinzhen|qjz',
'前磨头|qianmotou|qmt','前山|qianshan|qs','前苇塘|qianweitang|qwt','前窑|qianyao|qy','钱家店|qianjiadian|qjd',
'乾安|qianan|qa','潜江|qianjiang|qj','黔江|qianjiang|qj','桥北|qiaobei|qb','桥头|qiaotou|qt',
'桥西|qiaoxi|qx','茄子溪|qiezixi|qzx','钦州|qinzhou|qz','钦州东|qinzhoudong|qzd','秦皇岛|qinhuangdao|qhd',
'秦家|qinjia|qj','秦家庄|qinjiazhuang|qjz','秦岭|qinling|ql','沁河北|qinhebei|qhb','沁县|qinxian|qx',
'沁阳|qinyang|qy','青城山|qingchengshan|qcs','青岛|qingdao|qd','青岛北|qingdaobei|qdb','青沟子|qinggouzi|qgz',
'青花|qinghua|qh','青岭子|qinglingzi|qlz','青龙|qinglong|ql','青龙场|qinglongchang|qlc','青龙山|qinglongshan|qls',
'青山|qingshan|qs','青水山|qingshuishan|qss','青田|qingtian|qt','青铜峡|qingtongxia|qtx','青溪|qingxi|qx',
'青县|qingxian|qx','青州市|qingzhoushi|qzs','清河|qinghe|qh','清河城|qinghecheng|qhc','清河门|qinghemen|qhm',
'清华园|qinghuayuan|qhy','清涧县|qingjianxian|qjx','清水|qingshui|qs','清水沟|qingshuigou|qsg','清徐|qingxu|qx',
'清原|qingyuan|qy','清远|qingyuan|qy','庆安|qingan|qa','庆丰|qingfeng|qf','庆盛|qingsheng|qs',
'庆阳山|qingyangshan|qys','琼海|qionghai|qh','秋木庄|qiumuzhuang|qmz','曲阜|qufu|qf','曲阜东|qufudong|qfd',
'曲家店|qujiadian|qjd','曲靖|qujing|qj','渠旧|qujiu|qj','渠黎|quli|ql','渠县|quxian|qx',
'衢州|quzhou|qz','全椒|quanjiao|qj','全州南|quanzhounan|qzn','泉沟|quangou|qg','泉江|quanjiang|qj',
'泉水|quanshui|qs','泉阳|quanyang|qy','泉州|quanzhou|qz','泉州东|quanzhoudong|qzd','确山|queshan|qs',
'群力|qunli|ql','冉家河|ranjiahe|rjh','饶平|raoping|rp','饶阳|raoyang|ry','绕阳河|raoyanghe|ryh',
'热水|reshui|rs','任家店|renjiadian|rjd','任丘|renqiu|rq','日照|rizhao|rz','荣昌|rongchang|rc',
'容桂|ronggui|rg','容县|rongxian|rx','融安|rongan|ra','融水|rongshui|rs','如东|rudong|rd',
'如皋|rugao|rg','汝箕沟|rujigou|rjg','汝州|ruzhou|rz','乳山|rushan|rs','瑞安|ruian|ra',
'瑞昌|ruichang|rc','瑞金|ruijin|rj','萨拉齐|salaqi|slq','赛汗塔拉|saihantala|shtl','赛乌苏|saiwusu|sws',
'三把火|sanbahuo|sbh','三道营|sandaoying|sdy','三堆子|sanduizi|sdz','三关口|sanguankou|sgk','三合庄|sanhezhuang|shz',
'三河县|sanhexian|shx','三花石|sanhuashi|shs','三汇镇|sanhuizhen|shz','三家店|sanjiadian|sjd','三家寨|sanjiazhai|sjz',
'三间房|sanjianfang|sjf','三江|sanjiang|sj','三江口|sanjiangkou|sjk','三江县|sanjiangxian|sjx','三介海子|sanjiehaizi|sjhz',
'三门峡|sanmenxia|smx','三门峡南|sanmenxianan|smxn','三门峡西|sanmenxiaxi|smxx','三门县|sanmenxian|smx','三明|sanming|sm',
'三明北|sanmingbei|smb','三十家|sanshijia|ssj','三十里堡|sanshilibao|sslb','三水|sanshui|ss','三堂集|santangji|stj',
'三亚|sanya|sy','三阳川|sanyangchuan|syc','三义井|sanyijing|syj','三营|sanying|sy','三营图|sanyingtu|syt',
'三元坝|sanyuanba|syb','三原|sanyuan|sy','三源浦|sanyuanpu|syp','桑根达来|sanggendalai|sgdl','桑园子|sangyuanzi|syz',
'沙坝|shaba|sb','沙城|shacheng|sc','沙村|shacun|sc','沙海|shahai|sh','沙河|shahe|sh',
'沙河口|shahekou|shk','沙河市|shaheshi|shs','沙岭子|shalingzi|slz','沙马拉达|shamalada|smld','沙坡头|shapotou|spt',
'沙日乃|sharinai|srn','沙沙坡|shashapo|ssp','沙坨子|shatuozi|stz','沙沱|shatuo|st','沙湾|shawan|sw',
'沙湾县|shawanxian|swx','沙园|shayuan|sy','莎车|shache|sc','山城镇|shanchengzhen|scz','山丹|shandan|sd',
'山海关|shanhaiguan|shg','山河屯|shanhetun|sht','山口|shankou|sk','山坡东|shanpodong|spd','山市|shanshi|ss',
'山湾子|shanwanzi|swz','山阴|shanyin|sy','汕头|shantou|st','汕尾|shanwei|sw','鄯善|shanshan|ss',
'商城|shangcheng|sc','商都|shangdu|sd','商洛|shangluo|sl','商南|shangnan|sn','商丘|shangqiu|sq',
'商丘南|shangqiunan|sqn','上板城|shangbancheng|sbc','上板城南|shangbanchengnan|sbcn','上仓|shangcang|sc','上店|shangdian|sd',
'上高镇|shanggaozhen|sgz','上谷|shanggu|sg','上海|shanghai|sh','上海虹桥|shanghaihongqiao|shhq','上海南|shanghainan|shn',
'上海西|shanghaixi|shx','上杭|shanghang|sh','上普雄|shangpuxiong|spx','上饶|shangrao|sr','上万|shangwan|sw',
'上西铺|shangxipu|sxp','上腰墩|shangyaodun|syd','上虞|shangyu|sy','上虞北|shangyubei|syb','上园|shangyuan|sy',
'尚家|shangjia|sj','尚志|shangzhi|sz','韶关|shaoguan|sg','韶关东|shaoguandong|sgd','韶山|shaoshan|ss',
'邵东|shaodong|sd','邵家堂|shaojiatang|sjt','邵武|shaowu|sw','邵阳|shaoyang|sy','绍兴|shaoxing|sx',
'绍兴北|shaoxingbei|sxb','舍伯吐|shebotu|sbt','舍力虎|shelihu|slh','申家店|shenjiadian|sjd','绅坊|shenfang|sf',
'深井子|shenjingzi|sjz','深圳|shenzhen|sz','深圳北|shenzhenbei|szb','深圳东|shenzhendong|szd','深圳坪山|shenzhenpingshan|szps',
'深圳西|shenzhenxi|szx','深州|shenzhou|sz','神池|shenchi|sc','神木|shenmu|sm','神树|shenshu|ss',
'神头|shentou|st','神峪河|shenyuhe|syh','神州|shenzhou|sz','沈家|shenjia|sj','沈家河|shenjiahe|sjh',
'沈丘|shenqiu|sq','沈阳|shenyang|sy','沈阳北|shenyangbei|syb','沈阳西|shenyangxi|syx','升昌|shengchang|sc',
'渑池|mianchi|mc','渑池南|mianchinan|mcn','圣浪|shenglang|sl','师庄|shizhuang|sz','师宗|shizong|sz',
'施秉|shibing|sb','施家嘴|shijiazui|sjz','狮子营|shiziying|szy','十八台|shibatai|sbt','十渡|shidu|sd',
'十家子|shijiazi|sjz','十里坪|shiliping|slp','十堰|shiyan|sy','石坝|shiba|sb','石板哨|shibanshao|sbs',
'石长|shichang|sc','石场|shichang|sc','石城|shicheng|sc','石河子|shihezi|shz','石湖|shihu|sh',
'石家庄|shijiazhuang|sjz','石家庄北|shijiazhuangbei|sjzb','石林|shilin|sl','石林南|shilinnan|sln','石磷|shilin|sl',
'石岭|shiling|sl','石门村|shimencun|smc','石门坎|shimenkan|smk','石门县北|shimenxianbei|smxb','石门子|shimenzi|smz',
'石脑|shinao|sn','石桥子|shiqiaozi|sqz','石泉县|shiquanxian|sqx','石人|shiren|sr','石人城|shirencheng|src',
'石头|shitou|st','石峡子|shixiazi|sxz','石丫口|shiyakou|syk','石柱槽|shizhucao|szc','石柱县|shizhuxian|szx',
'石子坝|shiziba|szb','石嘴山|shizuishan|szs','史家铺|shijiapu|sjp','寿阳|shouyang|sy','疏勒|shule|sl',
'疏勒河|shulehe|slh','舒城|shucheng|sc','舒兰|shulan|sl','沭阳|shuyang|sy','双城堡|shuangchengbao|scb',
'双城北|shuangchengbei|scb','双丰|shuangfeng|sf','双凤驿|shuangfengyi|sfy','双福|shuangfu|sf','双河镇|shuanghezhen|shz',
'双辽|shuangliao|sl','双流|shuangliu|sl','双龙山|shuanglongshan|sls','双牌|shuangpai|sp','双泡子|shuangpaozi|spz',
'双石桥|shuangshiqiao|ssq','双鸭山|shuangyashan|sys','双子河|shuangzihe|szh','水地|shuidi|sd','水洞|shuidong|sd',
'水富|shuifu|sf','水沟|shuigou|sg','水花|shuihua|sh','水家湖|shuijiahu|sjh','水泉|shuiquan|sq',
'水源|shuiyuan|sy','顺昌|shunchang|sc','顺德|shunde|sd','顺德学院|shundexueyuan|sdxy','顺义|shunyi|sy',
'朔州|shuozhou|sz','司家岭|sijialing|sjl','思濛|simeng|sm','四道湾|sidaowan|sdw','四方台|sifangtai|sft',
'四分地|sifendi|sfd','四分滩|sifentan|sft','四合|sihe|sh','四合永|siheyong|shy','四家子|sijiazi|sjz',
'四马架|simajia|smj','四平|siping|sp','四平东|sipingdong|spd','泗水|sishui|ss','松坝|songba|sb',
'松河|songhe|sh','松江|songjiang|sj','松江河|songjianghe|sjh','松江南|songjiangnan|sjn','松江镇|songjiangzhen|sjz',
'松坎|songkan|sk','松岭|songling|sl','松青|songqing|sq','松树|songshu|ss','松树林|songshulin|ssl',
'松树台|songshutai|sst','松树镇|songshuzhen|ssz','松桃|songtao|st','松原|songyuan|sy','松滋|songzi|sz',
'宋|song|s','苏坂|suban|sb','苏北|subei|sb','苏集|suji|sj','苏家屯|sujiatun|sjt',
'苏雄|suxiong|sx','苏州|suzhou|sz','苏州北|suzhoubei|szb','苏州新区|suzhouxinqu|szxq','苏州园区|suzhouyuanqu|szyq',
'肃宁|suning|sn','宿松|susong|ss','宿州|suzhou|sz','宿州东|suzhoudong|szd','算王庄|suanwangzhuang|swz',
'绥德|suide|sd','绥芬河|suifenhe|sfh','绥化|suihua|sh','绥棱|suileng|sl','绥西|suixi|sx',
'绥阳|suiyang|sy','绥中|suizhong|sz','绥中北|suizhongbei|szb','随州|suizhou|sz','遂宁|suining|sn',
'遂平|suiping|sp','遂溪|suixi|sx','孙家|sunjia|sj','孙镇|sunzhen|sz','索伦|suolun|sl',
'索图罕|suotuhan|sth','塔尔根|taergen|teg','塔尔气|taerqi|teq','塔哈|taha|th','塔河|tahe|th',
'塔前|taqian|tq','塔崖驿|tayayi|tyy','塔源|tayuan|ty','台安|taian|ta','台前|taiqian|tq',
'台州|taizhou|tz','苔青|taiqing|tq','太白|taibai|tb','太谷|taigu|tg','太谷西|taiguxi|tgx',
'太和|taihe|th','太湖|taihu|th','太姥山|tailaoshan|tls','太岭|tailing|tl','太平川|taipingchuan|tpc',
'太平镇|taipingzhen|tpz','太平庄|taipingzhuang|tpz','太阳沟|taiyanggou|tyg','太阳山|taiyangshan|tys','太阳升|taiyangsheng|tys',
'太原|taiyuan|ty','太原北|taiyuanbei|tyb','太原东|taiyuandong|tyd','太原南|taiyuannan|tyn','泰安|taian|ta',
'泰和|taihe|th','泰康|taikang|tk','泰来|tailai|tl','泰宁|taining|tn','泰山|taishan|ts',
'泰州|taizhou|tz','滩头|tantou|tt','郯城|tancheng|tc','谭家井|tanjiajing|tjj','汤池|tangchi|tc',
'汤山城|tangshancheng|tsc','汤头沟|tangtougou|ttg','汤旺河|tangwanghe|twh','汤逊湖|tangxunhu|txh','汤阴|tangyin|ty',
'汤原|tangyuan|ty','唐河|tanghe|th','唐家湾|tangjiawan|tjw','唐山|tangshan|ts','唐山北|tangshanbei|tsb',
'塘豹|tangbao|tb','塘沽|tanggu|tg','洮南|taonan|tn','桃村|taocun|tc','桃山|taoshan|ts',
'桃映|taoying|ty','桃园|taoyuan|ty','陶卜齐|taobuqi|tbq','陶家屯|taojiatun|tjt','陶赖昭|taolaizhao|tlz',
'陶思浩|taosihao|tsh','滕州|tengzhou|tz','滕州东|tengzhoudong|tzd','藤县|tengxian|tx','天岗|tiangang|tg',
'天津|tianjin|tj','天津南|tianjinnan|tjn','天津西|tianjinxi|tjx','天峻|tianjun|tj','天门|tianmen|tm',
'天门南|tianmennan|tmn','天桥|tianqiao|tq','天桥沟|tianqiaogou|tqg','天桥岭|tianqiaoling|tql','天水|tianshui|ts',
'天西|tianxi|tx','天义|tianyi|ty','天镇|tianzhen|tz','天柱山|tianzhushan|tzs','天祝|tianzhu|tz',
'田东|tiandong|td','田家沟|tianjiagou|tjg','田梁子|tianliangzi|tlz','田林|tianlin|tl','田师府|tianshifu|tsf',
'田阳|tianyang|ty','铁厂|tiechang|tc','铁佛寺|tiefosi|tfs','铁口|tiekou|tk','铁力|tieli|tl',
'铁岭|tieling|tl','铁岭西|tielingxi|tlx','铁西|tiexi|tx','亭亮|tingliang|tl','亭林|tinglin|tl',
'通安驿|tonganyi|tay','通北|tongbei|tb','通道|tongdao|td','通沟|tonggou|tg','通海|tonghai|th',
'通化|tonghua|th','通辽|tongliao|tl','通天屯|tongtiantun|ttt','通远堡|tongyuanbao|tyb','通州西|tongzhouxi|tzx',
'同心|tongxin|tx','佟家|tongjia|tj','桐柏|tongbai|tb','桐城|tongcheng|tc','桐木寨|tongmuzhai|tmz',
'桐乡|tongxiang|tx','桐子林|tongzilin|tzl','桐梓|tongzi|tz','铜鼓溪|tongguxi|tgx','铜罐驿|tongguanyi|tgy',
'铜陵|tongling|tl','铜仁|tongren|tr','潼关|tongguan|tg','潼南|tongnan|tn','统军庄|tongjunzhuang|tjz',
'头道桥|toudaoqiao|tdq','图里河|tulihe|tlh','图们|tumen|tm','图强|tuqiang|tq','土地堂东|tuditangdong|tdtd',
'土贵乌拉|tuguiwula|tgwl','土坎|tukan|tk','土门子|tumenzi|tmz','土们岭|tumenling|tml','土牧尔台|tumuertai|tmet',
'土桥子|tuqiaozi|tqz','土溪|tuxi|tx','吐列毛杜|tuliemaodu|tlmd','吐鲁番|tulufan|tlf','团结|tuanjie|tj',
'驼腰岭|tuoyaoling|tyl','瓦房|wafang|wf','瓦房店|wafangdian|wfd','瓦房店西|wafangdianxi|wfdx','瓦拉干|walagan|wlg',
'瓦屋山|wawushan|wws','瓦窑坝|wayaoba|wyb','瓦窑田|wayaotian|wyt','瓦祖|wazu|wz','歪头山|waitoushan|wts',
'弯道|wandao|wd','弯坵|wanqiu|wq','湾沟|wangou|wg','完工|wangong|wg','万发屯|wanfatun|wft',
'万乐|wanle|wl','万年|wannian|wn','万宁|wanning|wn','万源|wanyuan|wy','万州|wanzhou|wz',
'汪清|wangqing|wq','王安镇|wanganzhen|waz','王场|wangchang|wc','王府|wangfu|wf','王岗|wanggang|wg',
'王家营西|wangjiayingxi|wjyx','王团庄|wangtuanzhuang|wtz','王杨|wangyang|wy','王兆屯|wangzhaotun|wzt','王庄|wangzhuang|wz',
'旺苍|wangcang|wc','望江|wangjiang|wj','威海|weihai|wh','威岭|weiling|wl','威宁|weining|wn',
'威箐|weiqing|wq','威舍|weishe|ws','韦庄|weizhuang|wz','潍坊|weifang|wf','苇河|weihe|wh',
'苇子沟|weizigou|wzg','卫辉|weihui|wh','卫星|weixing|wx','渭津|weijin|wj','渭南|weinan|wn',
'渭南北|weinanbei|wnb','渭南南|weinannan|wnn','渭南镇|weinanzhen|wnz','魏善庄|weishanzhuang|wsz','魏杖子|weizhangzi|wzz',
'温春|wenchun|wc','温都和硕|wenduheshuo|wdhs','温岭|wenling|wl','温泉寺|wenquansi|wqs','温州|wenzhou|wz',
'温州南|wenzhounan|wzn','文昌|wenchang|wc','文登|wendeng|wd','文地|wendi|wd','文水|wenshui|ws',
'文庄村|wenzhuangcun|wzc','闻喜|wenxi|wx','闻喜西|wenxixi|wxx','倭肯|woken|wk','涡阳|woyang|wy',
'沃皮|wopi|wp','卧里屯|wolitun|wlt','卧牛河|woniuhe|wnh','乌尔旗汗|wuerqihan|weqh','乌固诺尔|wugunuoer|wgne',
'乌海|wuhai|wh','乌海北|wuhaibei|whb','乌海西|wuhaixi|whx','乌拉山|wulashan|wls','乌拉特前旗|wulateqianqi|wltqq',
'乌兰|wulan|wl','乌兰哈达|wulanhada|wlhd','乌兰浩特|wulanhaote|wlht','乌兰胡同|wulanhutong|wlht','乌兰花|wulanhua|wlh',
'乌龙泉南|wulongquannan|wlqn','乌鲁布铁|wulubutie|wlbt','乌鲁木齐|wulumuqi|wlmq','乌奴耳|wunuer|wne','乌斯土|wusitu|wst',
'乌西|wuxi|wx','乌伊岭|wuyiling|wyl','无锡|wuxi|wx','无锡东|wuxidong|wxd','无锡新区|wuxixinqu|wxxq',
'吴堡|wubao|wb','吴场|wuchang|wc','吴官田|wuguantian|wgt','吴家川|wujiachuan|wjc','吴家屯|wujiatun|wjt',
'吴桥|wuqiao|wq','芜湖|wuhu|wh','梧州|wuzhou|wz','梧州南|wuzhounan|wzn','五叉沟|wuchagou|wcg',
'五常|wuchang|wc','五道沟|wudaogou|wdg','五道河|wudaohe|wdh','五家|wujia|wj','五棵树|wukeshu|wks',
'五莲|wulian|wl','五林|wulin|wl','五龙背|wulongbei|wlb','五女山|wunvshan|wns','五十家子|wushijiazi|wsjz',
'五台山|wutaishan|wts','五五|wuwu|ww','五营|wuying|wy','五原|wuyuan|wy','五寨|wuzhai|wz',
'武昌|wuchang|wc','武当山|wudangshan|wds','武功|wugong|wg','武汉|wuhan|wh','武隆|wulong|wl',
'武清|wuqing|wq','武山|wushan|ws','武威|wuwei|ww','武威南|wuweinan|wwn','武乡|wuxiang|wx',
'武穴|wuxue|wx','武夷山|wuyishan|wys','武义|wuyi|wy','汐子|xizi|xz','西安|xian|xa',
'西安北|xianbei|xab','西安南|xiannan|xan','西昌|xichang|xc','西昌南|xichangnan|xcn','西大庙|xidamiao|xdm',
'西斗铺|xidoupu|xdp','西丰|xifeng|xf','西固城|xigucheng|xgc','西胡尔清|xihuerqing|xheq','西江|xijiang|xj',
'西街口|xijiekou|xjk','西里|xili|xl','西林|xilin|xl','西岭口|xilingkou|xlk','西柳|xiliu|xl',
'西六方|xiliufang|xlf','西麻山|ximashan|xms','西宁西|xiningxi|xnx','西平|xiping|xp','西武匠|xiwujiang|xwj',
'西峡|xixia|xx','西乡|xixiang|xx','西小召|xixiaozhao|xxz','西阳岔|xiyangcha|xyc','西阳村|xiyangcun|xyc',
'西张|xizhang|xz','西哲里木|xizhelimu|xzlm','息烽|xifeng|xf','浠水|xishui|xs','犀浦|xipu|xp',
'犀浦东|xipudong|xpd','锡林浩特|xilinhaote|xlht','锡林呼都嘎|xilinhuduga|xlhdg','锡铁山|xitieshan|xts','歙县|shexian|sx',
'喜德|xide|xd','峡江|xiajiang|xj','霞浦|xiapu|xp','下板城|xiabancheng|xbc','下仓|xiacang|xc',
'下城子|xiachengzi|xcz','下花园|xiahuayuan|xhy','下坑子|xiakengzi|xkz','下马塘|xiamatang|xmt','下普雄|xiapuxiong|xpx',
'下社|xiashe|xs','下台子|xiataizi|xtz','夏坝|xiaba|xb','夏官营|xiaguanying|xgy','夏拉哈马|xialahama|xlhm',
'夏石|xiashi|xs','夏邑县|xiayixian|xyx','厦门北|xiamenbei|xmb','厦门高崎|xiamengaoqi|xmgq','仙林|xianlin|xl',
'仙人桥|xianrenqiao|xrq','仙水|xianshui|xs','仙桃西|xiantaoxi|xtx','鲜滩|xiantan|xt','咸宁|xianning|xn',
'咸宁北|xianningbei|xnb','咸宁东|xianningdong|xnd','咸宁南|xianningnan|xnn','咸阳|xianyang|xy','咸阳秦都|xianyangqindu|xyqd',
'香坊|xiangfang|xf','香兰|xianglan|xl','湘潭|xiangtan|xt','湘乡|xiangxiang|xx','襄汾|xiangfen|xf',
'襄汾西|xiangfenxi|xfx','襄阳|xiangyang|xy','襄阳东|xiangyangdong|xyd','襄垣|xiangyuan|xy','祥云|xiangyun|xy',
'向塘|xiangtang|xt','向阳|xiangyang|xy','向阳川|xiangyangchuan|xyc','向阳村|xiangyangcun|xyc','项城|xiangcheng|xc',
'小白|xiaobai|xb','小池口|xiaochikou|xck','小村|xiaocun|xc','小得江|xiaodejiang|xdj','小儿坪|xiaoerping|xep',
'小高|xiaogao|xg','小姑家|xiaogujia|xgj','小关溪|xiaoguanxi|xgx','小河沿|xiaoheyan|xhy','小河镇|xiaohezhen|xhz',
'小黑山|xiaoheishan|xhs','小榄|xiaolan|xl','小岭|xiaoling|xl','小南海|xiaonanhai|xnh','小南垭|xiaonanya|xny',
'小山|xiaoshan|xs','小哨|xiaoshao|xs','小市|xiaoshi|xs','小寺沟|xiaosigou|xsg','小宋|xiaosong|xs',
'小西庄|xiaoxizhuang|xxz','小新街|xiaoxinjie|xxj','小扬气|xiaoyangqi|xyq','小榆树|xiaoyushu|xys','小雨谷|xiaoyugu|xyg',
'小月旧|xiaoyuejiu|xyj','孝感|xiaogan|xg','孝感北|xiaoganbei|xgb','孝南|xiaonan|xn','孝西|xiaoxi|xx',
'斜河涧|xiehejian|xhj','谢家|xiejia|xj','谢家镇|xiejiazhen|xjz','忻州|xinzhou|xz','辛集|xinji|xj',
'新安|xinan|xa','新安县|xinanxian|xax','新安庄|xinanzhuang|xaz','新场|xinchang|xc','新绰源|xinchuoyuan|xcy',
'新干|xingan|xg','新高峰|xingaofeng|xgf','新寒岭|xinhanling|xhl','新和|xinhe|xh','新华|xinhua|xh',
'新华屯|xinhuatun|xht','新化|xinhua|xh','新晃|xinhuang|xh','新会|xinhui|xh','新江|xinjiang|xj',
'新绛|xinjiang|xj','新开|xinkai|xk','新李|xinli|xl','新立屯|xinlitun|xlt','新立镇|xinlizhen|xlz',
'新凉|xinliang|xl','新林|xinlin|xl','新民|xinmin|xm','新平坝|xinpingba|xpb','新坪田|xinpingtian|xpt',
'新桥|xinqiao|xq','新青|xinqing|xq','新邱|xinqiu|xq','新松浦|xinsongpu|xsp','新天|xintian|xt',
'新铁村|xintiecun|xtc','新窝铺|xinwopu|xwp','新县|xinxian|xx','新乡|xinxiang|xx','新乡东|xinxiangdong|xxd',
'新香坊|xinxiangfang|xxf','新彦|xinyan|xy','新阳镇|xinyangzhen|xyz','新沂|xinyi|xy','新友谊|xinyouyi|xyy',
'新余|xinyu|xy','新帐房|xinzhangfang|xzf','新杖子|xinzhangzi|xzz','新肇|xinzhao|xz','信丰|xinfeng|xf',
'信阳|xinyang|xy','信阳东|xinyangdong|xyd','信宜|xinyi|xy','兴安北|xinganbei|xab','兴安岭|xinganling|xal',
'兴城|xingcheng|xc','兴福|xingfu|xf','兴国|xingguo|xg','兴和|xinghe|xh','兴和西|xinghexi|xhx',
'兴凯|xingkai|xk','兴莲|xinglian|xl','兴隆店|xinglongdian|xld','兴隆县|xinglongxian|xlx','兴隆镇|xinglongzhen|xlz',
'兴宁|xingning|xn','兴平|xingping|xp','兴泉堡|xingquanbao|xqb','兴无|xingwu|xw','兴业|xingye|xy',
'兴义|xingyi|xy','星朗|xinglang|xl','星耀|xingyao|xy','邢台|xingtai|xt','邢台东|xingtaidong|xtd',
'杏树|xingshu|xs','杏树屯|xingshutun|xst','熊岳城|xiongyuecheng|xyc','修武|xiuwu|xw','秀山|xiushan|xs',
'绣峰|xiufeng|xf','徐家|xujia|xj','徐家坪|xujiaping|xjp','徐闻|xuwen|xw','徐州|xuzhou|xz',
'徐州东|xuzhoudong|xzd','许昌|xuchang|xc','许昌东|xuchangdong|xcd','许家台|xujiatai|xjt','许家屯|xujiatun|xjt',
'许三湾|xusanwan|xsw','溆浦|xupu|xp','轩岗|xuangang|xg','宣城|xuancheng|xc','宣汉|xuanhan|xh',
'宣和|xuanhe|xh','宣化|xuanhua|xh','宣家沟|xuanjiagou|xjg','宣威|xuanwei|xw','学庄|xuezhuang|xz',
'旬阳|xunyang|xy','旬阳北|xunyangbei|xyb','鸭园|yayuan|yy','牙克石|yakeshi|yks','牙拉盖图|yalagaitu|ylgt',
'牙屯堡|yatunbao|ytb','衙门庙|yamenmiao|ymm','雅河|yahe|yh','雅鲁|yalu|yl','亚布力|yabuli|ybl',
'亚复|yafu|yf','亚沟|yagou|yg','亚河|yahe|yh','亚龙湾|yalongwan|ylw','烟台|yantai|yt',
'烟筒山|yantongshan|yts','烟筒屯|yantongtun|ytt','焉耆|yanqi|yq','延安|yanan|ya','延吉|yanji|yj',
'延津|yanjin|yj','延庆|yanqing|yq','岩会|yanhui|yh','岩山|yanshan|ys','沿河城|yanhecheng|yhc',
'炎陵|yanling|yl','盐城|yancheng|yc','盐池|yanchi|yc','盐津|yanjin|yj','盐津北|yanjinbei|yjb',
'阎家|yanjia|yj','阎良|yanliang|yl','兖州|yanzhou|yz','偃师|yanshi|ys','砚川|yanchuan|yc',
'晏家坝|yanjiaba|yjb','雁翅|yanchi|yc','雁荡山|yandangshan|yds','雁石|yanshi|ys','燕岗|yangang|yg',
'燕家庄|yanjiazhuang|yjz','燕郊|yanjiao|yj','燕山|yanshan|ys','燕子砭|yanzibian|yzb','秧草地|yangcaodi|ycd',
'扬州|yangzhou|yz','羊堡|yangbao|yb','羊草|yangcao|yc','羊场|yangchang|yc','羊臼河|yangjiuhe|yjh',
'羊坪|yangping|yp','羊圈子|yangquanzi|yqz','羊尾哨|yangweishao|yws','羊者窝|yangzhewo|yzw','阳岔|yangcha|yc',
'阳城|yangcheng|yc','阳澄湖|yangchenghu|ych','阳春|yangchun|yc','阳高|yanggao|yg','阳谷|yanggu|yg',
'阳明堡|yangmingbao|ymb','阳平关|yangpingguan|ypg','阳曲|yangqu|yq','阳泉|yangquan|yq','阳泉北|yangquanbei|yqb',
'阳泉曲|yangquanqu|yqq','阳新|yangxin|yx','杨村|yangcun|yc','杨岗|yanggang|yg','杨家店|yangjiadian|yjd',
'杨家营|yangjiaying|yjy','杨林|yanglin|yl','杨陵|yangling|yl','杨陵南|yanglingnan|yln','杨柳青|yangliuqing|ylq',
'杨木|yangmu|ym','杨树岭|yangshuling|ysl','杨树湾|yangshuwan|ysw','杨漩|yangxuan|yx','杨杖子|yangzhangzi|yzz',
'腰栈|yaozhan|yz','姚安|yaoan|ya','姚家|yaojia|yj','姚千户屯|yaoqianhutun|yqht','窑上|yaoshang|ys',
'野三坡|yesanpo|ysp','叶柏寿|yebaishou|ybs','叶城|yecheng|yc','叶集|yeji|yj','叶榭|yexie|yx',
'一步滩|yibutan|ybt','一间堡|yijianbao|yjb','一面坡|yimianpo|ymp','一面山|yimianshan|yms','伊春|yichun|yc',
'伊和恩格拉|yiheengela|yhegl','伊拉哈|yilaha|ylh','伊林|yilin|yl','伊宁|yining|yn','伊宁东|yiningdong|ynd',
'伊图里河|yitulihe|ytlh','依安|yian|ya','沂南|yinan|yn','沂水|yishui|ys','宜宾|yibin|yb',
'宜宾南|yibinnan|ybn','宜昌东|yichangdong|ycd','宜城|yicheng|yc','宜春西|yichunxi|ycx','宜良北|yiliangbei|ylb',
'宜耐|yinai|yn','宜兴|yixing|yx','宜州|yizhou|yz','迤那|yinei|yn','迤资|yizi|yz',
'彝良|yiliang|yl','彝良南|yiliangnan|yln','义马|yima|ym','义乌|yiwu|yw','义县|yixian|yx',
'弋阳|yiyang|yy','益阳|yiyang|yy','银川|yinchuan|yc','银浪|yinlang|yl','银镇|yinzhen|yz',
'尹地|yindi|yd','饮马峡|yinmaxia|ymx','应城|yingcheng|yc','应县|yingxian|yx','英德|yingde|yd',
'英德西|yingdexi|ydx','英吉沙|yingjisha|yjs','鹰手营子|yingshouyingzi|ysyz','鹰潭|yingtan|yt','迎宾路|yingbinlu|ybl',
'迎春|yingchun|yc','迎祥街|yingxiangjie|yxj','营北|yingbei|yb','营城|yingcheng|yc','营街|yingjie|yj',
'营口|yingkou|yk','营口东|yingkoudong|ykd','营盘上|yingpanshang|yps','营盘水|yingpanshui|yps','营盘湾|yingpanwan|ypw',
'营山|yingshan|ys','影壁山|yingbishan|ybs','硬石岭|yingshiling|ysl','永安|yongan|ya','永安乡|yonganxiang|yax',
'永川|yongchuan|yc','永登|yongdeng|yd','永甸|yongdian|yd','永定|yongding|yd','永丰营|yongfengying|yfy',
'永福南|yongfunan|yfn','永和|yonghe|yh','永济|yongji|yj','永济北|yongjibei|yjb','永嘉|yongjia|yj',
'永康|yongkang|yk','永郎|yonglang|yl','永乐店|yongledian|yld','永胜|yongsheng|ys','永泰|yongtai|yt',
'永修|yongxiu|yx','永州|yongzhou|yz','攸县|youxian|yx','尤溪|youxi|yx','油溪|youxi|yx',
'友好|youhao|yh','酉阳|youyang|yy','于都|yudu|yd','余杭|yuhang|yh','余江|yujiang|yj',
'余粮堡|yuliangbao|ylb','余姚|yuyao|yy','余姚北|yuyaobei|yyb','鱼儿沟|yuergou|yeg','鱼泉|yuquan|yq',
'俞冲|yuchong|yc','榆次|yuci|yc','榆林|yulin|yl','榆社|yushe|ys','榆树|yushu|ys',
'榆树川|yushuchuan|ysc','榆树沟|yushugou|ysg','榆树台|yushutai|yst','榆树屯|yushutun|yst','虞城县|yuchengxian|ycx',
'宇宙地|yuzhoudi|yzd','雨格|yuge|yg','禹城|yucheng|yc','玉林|yulin|yl','玉门|yumen|ym',
'玉屏|yuping|yp','玉泉|yuquan|yq','玉山|yushan|ys','玉舍|yushe|ys','玉石|yushi|ys',
'玉田县|yutianxian|ytx','玉溪|yuxi|yx','郁山|yushan|ys','鸳鸯镇|yuanyangzhen|yyz','元宝山|yuanbaoshan|ybs',
'元龙|yuanlong|yl','元谋|yuanmou|ym','元氏|yuanshi|ys','元田坝|yuantianba|ytb','园墩|yuandun|yd',
'原林|yuanlin|yl','原平|yuanping|yp','源迁|yuanqian|yq','源潭|yuantan|yt','月华|yuehua|yh',
'月亮田|yueliangtian|ylt','月山|yueshan|ys','岳家井|yuejiajing|yjj','岳阳|yueyang|yy','岳阳东|yueyangdong|yyd',
'越西|yuexi|yx','云彩岭|yuncailing|ycl','云居寺|yunjusi|yjs','云梦|yunmeng|ym','云霄|yunxiao|yx',
'运城|yuncheng|yc','运城北|yunchengbei|ycb','郓城|yuncheng|yc','枣林|zaolin|zl','枣强|zaoqiang|zq',
'枣阳|zaoyang|zy','枣庄|zaozhuang|zz','枣庄西|zaozhuangxi|zzx','枣子林|zaozilin|zzl','泽普|zepu|zp',
'曾家坪子|cengjiapingzi|cjpz','缯溪河|zengxihe|zxh','咋子|zazi|zz','扎赉诺尔|zhalainuoer|zlne','扎赉诺尔西|zhalainuoerxi|zlnex',
'扎兰屯|zhalantun|zlt','扎鲁特|zhalute|zlt','扎罗木得|zhaluomude|zlmd','扎音河|zhayinhe|zyh','湛江|zhanjiang|zj',
'湛江西|zhanjiangxi|zjx','张百湾|zhangbaiwan|zbw','张家界|zhangjiajie|zjj','张家口南|zhangjiakounan|zjkn','张兰|zhanglan|zl',
'张桥|zhangqiao|zq','张三营|zhangsanying|zsy','张台子|zhangtaizi|ztz','张维屯|zhangweitun|zwt','张巷|zhangxiang|zx',
'张辛|zhangxin|zx','张掖|zhangye|zy','章党|zhangdang|zd','章古台|zhanggutai|zgt','章丘|zhangqiu|zq',
'彰武|zhangwu|zw','漳平|zhangping|zp','漳浦|zhangpu|zp','漳州|zhangzhou|zz','漳州东|zhangzhoudong|zzd',
'樟木头|zhangmutou|zmt','樟树|zhangshu|zs','樟树东|zhangshudong|zsd','招柏|zhaobai|zb','昭通|zhaotong|zt',
'昭通北|zhaotongbei|ztb','昭通南|zhaotongnan|ztn','诏安|zhaoan|za','赵城|zhaocheng|zc','赵光|zhaoguang|zg',
'赵庄|zhaozhuang|zz','照福铺|zhaofupu|zfp','肇东|zhaodong|zd','肇庆|zhaoqing|zq','哲里木|zhelimu|zlm',
'枕头峰|zhentoufeng|ztf','轸溪|zhenxi|zx','镇安|zhenan|za','镇城底|zhenchengdi|zcd','镇江|zhenjiang|zj',
'镇江南|zhenjiangnan|zjn','镇赉|zhenlai|zl','镇平|zhenping|zp','镇远|zhenyuan|zy','镇紫街|zhenzijie|zzj',
'正定机场|zhengdingjichang|zdjc','正镶白旗|zhengxiangbaiqi|zxbq','郑家堡|zhengjiabao|zjb','郑州|zhengzhou|zz','郑州东|zhengzhoudong|zzd',
'枝城|zhicheng|zc','枝江北|zhijiangbei|zjb','织金|zhijin|zj','纸坊东|zhifangdong|zfd','轵城|zhicheng|zc',
'治安|zhian|za','治山|zhishan|zs','中和|zhonghe|zh','中华门|zhonghuamen|zhm','中宁|zhongning|zn',
'中宁东|zhongningdong|znd','中宁南|zhongningnan|znn','中山|zhongshan|zs','中山北|zhongshanbei|zsb','中台子|zhongtaizi|ztz',
'中卫|zhongwei|zw','中兴|zhongxing|zx','中寨|zhongzhai|zz','中嘴|zhongzui|zz','钟家村|zhongjiacun|zjc',
'钟祥|zhongxiang|zx','重庆|chongqing|cq','重庆北|chongqingbei|cqb','重庆南|chongqingnan|cqn','周家|zhoujia|zj',
'周家屯|zhoujiatun|zjt','周口|zhoukou|zk','周水子|zhoushuizi|zsz','朱嘎|zhuga|zg','朱家沟|zhujiagou|zjg',
'朱家窑|zhujiayao|zjy','朱日和|zhurihe|zrh','朱石寨|zhushizhai|zsz','朱杨溪|zhuyangxi|zyx','株洲|zhuzhou|zz',
'株洲西|zhuzhouxi|zzx','珠海|zhuhai|zh','珠海北|zhuhaibei|zhb','珠斯花|zhusihua|zsh','珠窝|zhuwo|zw',
'诸城|zhucheng|zc','诸暨|zhuji|zj','竹园坝|zhuyuanba|zyb','驻马店|zhumadian|zmd','驻马店西|zhumadianxi|zmdx',
'庄河|zhuanghe|zh','庄桥|zhuangqiao|zq','壮志|zhuangzhi|zz','准沙日乌苏|zhunshariwusu|zsrws','卓资东|zhuozidong|zzd',
'卓资山|zhuozishan|zzs','涿州|zhuozhou|zz','涿州东|zhuozhoudong|zzd','资溪|zixi|zx','资阳|ziyang|zy',
'资中|zizhong|zz','淄博|zhibo|zb','子长|zichang|zc','子洲|zizhou|zz','紫荆关|zijingguan|zjg',
'紫阳|ziyang|zy','自贡|zigong|zg','邹城|zoucheng|zc','遵义|zunyi|zy','左家|zuojia|zj',
'左岭|zuoling|zl','柞水|zuoshui|zs'];

/* 正则表达式 筛选中文城市名、拼音、首字母 */

Vcity.regEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i;
Vcity.regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/;

/* *
 * 格式化城市数组为对象oCity，按照a-h,i-p,q-z,hot热门城市分组：
 * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{i:[1.2.3],j:[1,2,3]},QRSTUVWXYZ:{}}
 * */

(function () {
    var citys = Vcity.allCity, match, letter,
            regEx = Vcity.regEx,
            reg2 = /^[a-h]$/i, reg3 = /^[i-p]$/i, reg4 = /^[q-z]$/i;
    if (!Vcity.oCity) {
        Vcity.oCity = {hot:{},ABCDEFGH:{}, IJKLMNOP:{}, QRSTUVWXYZ:{}};
        //console.log(citys.length);
        for (var i = 0, n = citys.length; i < n; i++) {
            match = regEx.exec(citys[i]);
            letter = match[3].toUpperCase();
            if (reg2.test(letter)) {
                if (!Vcity.oCity.ABCDEFGH[letter]) Vcity.oCity.ABCDEFGH[letter] = [];
                Vcity.oCity.ABCDEFGH[letter].push(match[1]);
            } else if (reg3.test(letter)) {
                if (!Vcity.oCity.IJKLMNOP[letter]) Vcity.oCity.IJKLMNOP[letter] = [];
                Vcity.oCity.IJKLMNOP[letter].push(match[1]);
            } else if (reg4.test(letter)) {
                if (!Vcity.oCity.QRSTUVWXYZ[letter]) Vcity.oCity.QRSTUVWXYZ[letter] = [];
                Vcity.oCity.QRSTUVWXYZ[letter].push(match[1]);
            }
            /* 热门城市 前16条 */
            if(i<16){
                if(!Vcity.oCity.hot['hot']) Vcity.oCity.hot['hot'] = [];
                Vcity.oCity.hot['hot'].push(match[1]);
            }
        }
    }
})();
/* 城市HTML模板 */
Vcity._template = [
    '<p class="tip">热门城市(支持汉字/拼音)</p>',
    '<ul>',
    '<li class="on">热门城市</li>',
    '<li>ABCDEFGH</li>',
    '<li>IJKLMNOP</li>',
    '<li>QRSTUVWXYZ</li>',
    '</ul>'
];

/* *
 * 城市控件构造函数
 * @CitySelector
 * */

Vcity.CitySelector = function () {
    this.initialize.apply(this, arguments);
};

Vcity.CitySelector.prototype = {

    constructor:Vcity.CitySelector,

    /* 初始化 */

    initialize :function (options) {
        var input = options.input;
        this.input = Vcity._m.$('#'+ input);
        this.inputEvent();
    },

    /* *
     * @createWarp
     * 创建城市BOX HTML 框架
     * */

    createWarp:function(){
        var inputPos = Vcity._m.getPos(this.input);
        var div = this.rootDiv = document.createElement('div');
        var that = this;

        // 设置DIV阻止冒泡
        Vcity._m.on(this.rootDiv,'click',function(event){
            Vcity._m.stopPropagation(event);
        });

        // 设置点击文档隐藏弹出的城市选择框
        Vcity._m.on(document, 'click', function (event) {
            event = Vcity._m.getEvent(event);
            var target = Vcity._m.getTarget(event);
            if(target == that.input) return false;
            //console.log(target.className);
            if (that.cityBox)Vcity._m.addClass('hide', that.cityBox);
            if (that.ul)Vcity._m.addClass('hide', that.ul);
            if(that.myIframe)Vcity._m.addClass('hide',that.myIframe);
        });
        div.className = 'citySelector';
        div.style.position = 'absolute';
        div.style.left = inputPos.left + 'px';
        div.style.top = inputPos.bottom + 'px';
        div.style.zIndex = 999999;

        // 判断是否IE6，如果是IE6需要添加iframe才能遮住SELECT框
        var isIe = (document.all) ? true : false;
        var isIE6 = this.isIE6 = isIe && !window.XMLHttpRequest;
        if(isIE6){
            var myIframe = this.myIframe =  document.createElement('iframe');
            myIframe.frameborder = '0';
            myIframe.src = 'about:blank';
            myIframe.style.position = 'absolute';
            myIframe.style.zIndex = '-1';
            this.rootDiv.appendChild(this.myIframe);
        }

        var childdiv = this.cityBox = document.createElement('div');
        childdiv.className = 'cityBox';
        childdiv.id = 'cityBox';
        childdiv.innerHTML = Vcity._template.join('');
        var hotCity = this.hotCity =  document.createElement('div');
        hotCity.className = 'hotCity';
        childdiv.appendChild(hotCity);
        div.appendChild(childdiv);
        this.createHotCity();
    },

    /* *
     * @createHotCity
     * TAB下面DIV：hot,a-h,i-p,q-z 分类HTML生成，DOM操作
     * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{},QRSTUVWXYZ:{}}
     **/

    createHotCity:function(){
        var odiv,odl,odt,odd,odda=[],str,key,ckey,sortKey,regEx = Vcity.regEx,
                oCity = Vcity.oCity;
        for(key in oCity){
            odiv = this[key] = document.createElement('div');
            // 先设置全部隐藏hide
            odiv.className = key + ' ' + 'cityTab hide';
            sortKey=[];
            for(ckey in oCity[key]){
                sortKey.push(ckey);
                // ckey按照ABCDEDG顺序排序
                sortKey.sort();
            }
            for(var j=0,k = sortKey.length;j<k;j++){
                odl = document.createElement('dl');
                odt = document.createElement('dt');
                odd = document.createElement('dd');
                odt.innerHTML = sortKey[j] == 'hot'?'&nbsp;':sortKey[j];
                odda = [];
                for(var i=0,n=oCity[key][sortKey[j]].length;i<n;i++){
                    str = '<a href="#">' + oCity[key][sortKey[j]][i] + '</a>';
                    odda.push(str);
                }
                odd.innerHTML = odda.join('');
                odl.appendChild(odt);
                odl.appendChild(odd);
                odiv.appendChild(odl);
            }

            // 移除热门城市的隐藏CSS
            Vcity._m.removeClass('hide',this.hot);
            this.hotCity.appendChild(odiv);
        }
        document.body.appendChild(this.rootDiv);
        /* IE6 */
        this.changeIframe();

        this.tabChange();
        this.linkEvent();
    },

    /* *
     *  tab按字母顺序切换
     *  @ tabChange
     * */

    tabChange:function(){
        var lis = Vcity._m.$('li',this.cityBox);
        var divs = Vcity._m.$('div',this.hotCity);
        var that = this;
        for(var i=0,n=lis.length;i<n;i++){
            lis[i].index = i;
            lis[i].onclick = function(){
                for(var j=0;j<n;j++){
                    Vcity._m.removeClass('on',lis[j]);
                    Vcity._m.addClass('hide',divs[j]);
                }
                Vcity._m.addClass('on',this);
                Vcity._m.removeClass('hide',divs[this.index]);
                /* IE6 改变TAB的时候 改变Iframe 大小*/
                that.changeIframe();
            };
        }
    },

    /* *
     * 城市LINK事件
     *  @linkEvent
     * */

    linkEvent:function(){
        var links = Vcity._m.$('a',this.hotCity);
        var that = this;
        for(var i=0,n=links.length;i<n;i++){
            links[i].onclick = function(){
                that.input.value = this.innerHTML;
                Vcity._m.addClass('hide',that.cityBox);
                /* 点击城市名的时候隐藏myIframe */
                Vcity._m.addClass('hide',that.myIframe);
            }
        }
    },

    /* *
     * INPUT城市输入框事件
     * @inputEvent
     * */

    inputEvent:function(){
        var that = this;
        Vcity._m.on(this.input,'click',function(event){
            event = event || window.event;
            if(!that.cityBox){
                that.createWarp();
            }else if(!!that.cityBox && Vcity._m.hasClass('hide',that.cityBox)){
                // slideul 不存在或者 slideul存在但是是隐藏的时候 两者不能共存
                if(!that.ul || (that.ul && Vcity._m.hasClass('hide',that.ul))){
                    Vcity._m.removeClass('hide',that.cityBox);

                    /* IE6 移除iframe 的hide 样式 */
                    //alert('click');
                    Vcity._m.removeClass('hide',that.myIframe);
                    that.changeIframe();
                }
            }
        });
        Vcity._m.on(this.input,'focus',function(){
            that.input.select();
            if(that.input.value == '城市名') that.input.value = '';
        });
        Vcity._m.on(this.input,'blur',function(){
            if(that.input.value == '') that.input.value = '城市名';
        });
        Vcity._m.on(this.input,'keyup',function(event){
            event = event || window.event;
            var keycode = event.keyCode;
            Vcity._m.addClass('hide',that.cityBox);
            that.createUl();

            /* 移除iframe 的hide 样式 */
            Vcity._m.removeClass('hide',that.myIframe);

            // 下拉菜单显示的时候捕捉按键事件
            if(that.ul && !Vcity._m.hasClass('hide',that.ul) && !that.isEmpty){
                that.KeyboardEvent(event,keycode);
            }
        });
    },

    /* *
     * 生成下拉选择列表
     * @ createUl
     * */

    createUl:function () {
        //console.log('createUL');
        var str;
        var value = Vcity._m.trim(this.input.value);
        // 当value不等于空的时候执行
        if (value !== '') {
            var reg = new RegExp("^" + value + "|\\|" + value, 'gi');
            // 此处需设置中文输入法也可用onpropertychange
            var searchResult = [];
            for (var i = 0, n = Vcity.allCity.length; i < n; i++) {
                if (reg.test(Vcity.allCity[i])) {
                    var match = Vcity.regEx.exec(Vcity.allCity[i]);
                    if (searchResult.length !== 0) {
                        str = '<li><b class="cityname">' + match[1] + '</b><b class="cityspell">' + match[2] + '</b></li>';
                    } else {
                        str = '<li class="on"><b class="cityname">' + match[1] + '</b><b class="cityspell">' + match[2] + '</b></li>';
                    }
                    searchResult.push(str);
                }
            }
            this.isEmpty = false;
            // 如果搜索数据为空
            if (searchResult.length == 0) {
                this.isEmpty = true;
                str = '<li class="empty">对不起，没有找到数据 "<em>' + value + '</em>"</li>';
                searchResult.push(str);
            }
            // 如果slideul不存在则添加ul
            if (!this.ul) {
                var ul = this.ul = document.createElement('ul');
                ul.className = 'cityslide';
                this.rootDiv && this.rootDiv.appendChild(ul);
                // 记录按键次数，方向键
                this.count = 0;
            } else if (this.ul && Vcity._m.hasClass('hide', this.ul)) {
                this.count = 0;
                Vcity._m.removeClass('hide', this.ul);
            }
            this.ul.innerHTML = searchResult.join('');

            /* IE6 */
            this.changeIframe();

            // 绑定Li事件
            this.liEvent();
        }else{
            Vcity._m.addClass('hide',this.ul);
            Vcity._m.removeClass('hide',this.cityBox);

            Vcity._m.removeClass('hide',this.myIframe);

            this.changeIframe();
        }
    },

    /* IE6的改变遮罩SELECT 的 IFRAME尺寸大小 */
    changeIframe:function(){
        if(!this.isIE6)return;
        this.myIframe.style.width = this.rootDiv.offsetWidth + 'px';
        this.myIframe.style.height = this.rootDiv.offsetHeight + 'px';
    },

    /* *
     * 特定键盘事件，上、下、Enter键
     * @ KeyboardEvent
     * */

    KeyboardEvent:function(event,keycode){
        var lis = Vcity._m.$('li',this.ul);
        var len = lis.length;
        switch(keycode){
            case 40: //向下箭头↓
                this.count++;
                if(this.count > len-1) this.count = 0;
                for(var i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 38: //向上箭头↑
                this.count--;
                if(this.count<0) this.count = len-1;
                for(i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 13: // enter键
                this.input.value = Vcity.regExChiese.exec(lis[this.count].innerHTML)[0];
                Vcity._m.addClass('hide',this.ul);
                Vcity._m.addClass('hide',this.ul);
                /* IE6 */
                Vcity._m.addClass('hide',this.myIframe);
                break;
            default:
                break;
        }
    },

    /* *
     * 下拉列表的li事件
     * @ liEvent
     * */

    liEvent:function(){
        var that = this;
        var lis = Vcity._m.$('li',this.ul);
        for(var i = 0,n = lis.length;i < n;i++){
            Vcity._m.on(lis[i],'click',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                that.input.value = Vcity.regExChiese.exec(target.innerHTML)[0];
                Vcity._m.addClass('hide',that.ul);
                /* IE6 下拉菜单点击事件 */
                Vcity._m.addClass('hide',that.myIframe);
            });
            Vcity._m.on(lis[i],'mouseover',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.addClass('on',target);
            });
            Vcity._m.on(lis[i],'mouseout',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.removeClass('on',target);
            })
        }
    }
};
    