(function () {
    var r_host = /^\w+:\/\/([^\/]+)/;
    var r_ignore = /\.ctrip\.com|\.sh\.ctriptravel\.com/;
    var r_site = /^([\w-]+\.)?(.+)\.(com|net|org|info|biz|cc|tv|cn|gov\.cn|name|mobi)$/;
    var r_domain = /ctrip\.com\.hk|ctrip\.com\.cn|sh\.ctriptravel\.com/;
    var r_en = /english\.|\.english\./;

    var c_name = "Session";
    var c_expire = "720";
    var c_template = "SmartLinkCode={si}&SmartLinkKeyWord={ke}&SmartLinkQuary={qu}&SmartLinkHost={ho}&SmartLinkLanguage={la}";
    var c_ntsdata = [
		'google|google|q=|UTF-8',
		'baidu|baidu|wd=;word=;kw=|URLEncode',
		'yahoo|yahoo|p=|UTF-8',
		'yahoo|yisou|search:|UTF-8',
		'yahoo|3721|p=|URLEncode',
		'sohu|sogou.com|query=|URLEncode',
		'sohuwz|sohu.com|query=|URLEncode',
		'sinawz|sina.com||',
		'sina|iask.com|k=;_searchkey=;key=|URLEncode',
		'163wz|126.com|q=|URLEncode',
		'163wz|163.com|q=|URLEncode',
		'163wz|188.com|q=|URLEncode',
		'163wz|yeah.net|q=|URLEncode',
		'163|163.com|q=|URLEncode',
		'tom|tom.com|word=;w=|URLEncode',
		'hao123|hao123.com||',
		'265|265.com||',
		'21cn|21cn.com|keyword=|URLEncode',
		'qqwz|qq.com||',
		'qq|soso.com|w=|URLEncode',
		'online|online.sh||',
		'9991|9991.com||',
		'live|msn|q=|UTF-8',
		'yodao|yodao|q=|UTF-8',
		'lycos|lycos|query=|UTF-8',
		'ask|.ask.com|q=|UTF-8',
		'altavista|altavista|q=|UTF-8',
		'search|search.com|q=|UTF-8',
		'netscape|netscape|query=|UTF-8',
		'zhongsou|zhongsou|w=;word=|URLEncode',
		'alice|alice.it|qs=|',
		'teoma|teoma|q=|UTF-8',
		'earthlink|earthlink|q=|UTF-8',
		'cnn|cnn|query=|',
		'looksmart|looksmart|key=|UTF-8',
		'about|about|terms=|',
		'excite|excite|qkw=;q_all=|',
		'mamma|mamma|query=|UTF-8',
		'alltheweb|alltheweb|q=|UTF-8',
		'gigablast|gigablast|q=|UTF-8',
		'aol|aol|query=|UTF-8',
		'shtz1104|www.travelzoo.com||',
        'so.com|so.com||',
        'qunar.com|qunar.com||',
        '360cn|so.360.cn||'
    ];
    //��Ȼ����
    var ss_data = ['www.baidu.com|4897|130026', 'www.google.cn|4899|130678', 'www.google.com.hk|4899|130678', 
    'www.google.com.tw|4899|130678', 'www.soso.com|4900|130701', 'www.sogou.com|4901|130709',
    'www.yahoo.cn|4903|130761', 'search.yahoo.com|4903|130761', 'www.youdao.com|4904|130788',
    'so.360.cn|5376|130860', 'www.so.com|5376|130860', 'www.bing.com|4902|130727',
    'cn.bing.com|4902|130727', 'www.lvping.com|5377|130999'];
    //#C
    var ss_data_c = ['360oneboxf|5376|130862', '360brandz|5376|153507', 'baiduzd|4897|130033', 'baidumap|3052|108412'];
    //����
    var ss_data_other = ['baidu.com|4897|135366', 'google|4899|135371', 'soso.com|4900|135374', 'sogou.com|4901|135376',
     'bing.com|4902|135379', 'yahoo|4903|135383', 'so.com|5376|135390'];


    var ref = document.referrer;
    var host = ref.match(r_host);

    if (host && !r_ignore.test(host = host[1])) {
        var dom = document.domain;
        var slv = r_en.test(dom) ? 'en' : 'zh';
        var loc = location.href;
        var obj = {};
        var arr = [];
        var los;

        if ((obj[c_name] = trackInfo()) || (obj[c_name] = trackInfoEx())) {
            var query = (location.search || "").match(new RegExp("[\\?&]isctrip=([^&]+)", "i"));
            if ((query ? unescape(query[1]) : null) == 'T') { return; }

            obj.expires = new Date((new Date()).getTime() + c_expire * 3600000).toGMTString();
            obj.path = '/';
            obj.domain = dom.match(r_domain) || 'ctrip.com';
            for (var s in obj)
                arr.push(s + '=' + obj[s]);

            var pageurl = window.location.href.toLowerCase();
            if (pageurl.indexOf("sid") >= 0 && pageurl.indexOf("allianceid") >= 0) {
                // document.cookie=arr.join('; ');
            }
            else {
                //		        if(ref.indexOf("265.com")>=0){
                //		           
                //		            var cookiestr;
                //		            cookiestr="Session=smartlinkcode=U1534&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&smartlinklanguage=zh;path=/;domain="+obj.domain+";expires="+obj.expires;
                //				    document.cookie=cookiestr;
                //				    
                //				    cookiestr="Union=AllianceID=1314&SID=1534&OUID=;path=/;domain="+obj.domain+";expires="+new Date((new Date()).getTime()+7*24*3600000).toGMTString();
                //				    document.cookie=cookiestr;
                //		            
                //		        }
                //		        else 
                if (ref.indexOf("qq.com") >= 0) {
                    var cookiestr;
                    cookiestr = "Session=smartlinkcode=U1535&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=;path=/;domain=" + obj.domain + ";expires=" + obj.expires;
                    document.cookie = cookiestr;

                    cookiestr = "Union=AllianceID=1315&SID=1535&OUID=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() + 7 * 24 * 3600000).toGMTString();
                    document.cookie = cookiestr;

                } else if (ref.indexOf("hao123.com") >= 0) {

                    var cookiestr;

                    cookiestr = "Session=smartlinkcode=U1911&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=;path=/;domain=" + obj.domain + ";expires=" + obj.expires;

                    document.cookie = cookiestr;

                    cookiestr = "Union=AllianceID=1630&SID=1911&OUID=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() + 7 * 24 * 3600000).toGMTString();

                    document.cookie = cookiestr;

                }
                else {
                    if (ref.indexOf("123.sogou.com") >= 0) {

                    }
                    else {
                        if (ref.indexOf("www.baidu.com") >= 0 || ref.indexOf("www.google.cn") >= 0 || ref.indexOf("www.google.com.hk") >= 0 || ref.indexOf("www.soso.com") >= 0 || ref.indexOf("www.bing.com") >= 0 || ref.indexOf("www.yahoo.cn") >= 0 || ref.indexOf("www.sogou.com") >= 0 || ref.indexOf("so.360.cn") >= 0 || ref.indexOf("so.com") >= 0) {
                            if (document.cookie.indexOf("Union=") >= 0 || document.URL.indexOf("#c") >= 0) {
                                //ɾ��union cookie
                                document.cookie = "Union=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() - 1 * 24 * 3600000).toGMTString();
                            }
                        }
                        document.cookie = arr.join('; ');
                        var sHostname, sAllianceId, sSID, sHostarray, sIsSetCookie;
                        sIsSetCookie = false;
                        for (var j = 0; j < ss_data_c.length; j++) {
                            sHostarray = ss_data_c[j].split('|');
                            sHostname = sHostarray[0];
                            sAllianceId = sHostarray[1];
                            sSID = sHostarray[2];
                            if (loc.indexOf("#c=" + sHostname) >= 0) {
                                var cookiestr;
                                cookiestr = "Session=smartlinkcode=U" + sSID + "&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=;path=/;domain=" + obj.domain + ";expires=" + obj.expires;

                                document.cookie = cookiestr;

                                cookiestr = "Union=AllianceID=" + sAllianceId + "&SID=" + sSID + "&OUID=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() + 7 * 24 * 3600000).toGMTString();

                                document.cookie = cookiestr;
                                sIsSetCookie = true;
                                break;
                            }
                        }
                        if (!sIsSetCookie) {
                            for (var j = 0; j < ss_data.length; j++) {
                                sHostarray = ss_data[j].split('|');
                                sHostname = sHostarray[0];
                                sAllianceId = sHostarray[1];
                                sSID = sHostarray[2];
                                if (ref.indexOf(sHostname) >= 0) {
                                    var cookiestr;
                                    cookiestr = "Session=smartlinkcode=U" + sSID + "&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=;path=/;domain=" + obj.domain + ";expires=" + obj.expires;

                                    document.cookie = cookiestr;

                                    cookiestr = "Union=AllianceID=" + sAllianceId + "&SID=" + sSID + "&OUID=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() + 7 * 24 * 3600000).toGMTString();

                                    document.cookie = cookiestr;
                                    sIsSetCookie = true;
                                    break;
                                }
                            }
                        }
                        if (!sIsSetCookie) {
                            for (var j = 0; j < ss_data_other.length; j++) {
                                sHostarray = ss_data_other[j].split('|');
                                sHostname = sHostarray[0];
                                sAllianceId = sHostarray[1];
                                sSID = sHostarray[2];
                                if (ref.indexOf(sHostname) >= 0) {
                                    var cookiestr;
                                    cookiestr = "Session=smartlinkcode=U" + sSID + "&smartlinklanguage=zh&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=;path=/;domain=" + obj.domain + ";expires=" + obj.expires;

                                    document.cookie = cookiestr;

                                    cookiestr = "Union=AllianceID=" + sAllianceId + "&SID=" + sSID + "&OUID=;path=/;domain=" + obj.domain + ";expires=" + new Date((new Date()).getTime() + 7 * 24 * 3600000).toGMTString();

                                    document.cookie = cookiestr;
                                    sIsSetCookie = true;
                                    break;
                                }
                            }
                        }
                    }
                    //		            if (document.cookie.indexOf("Union=")>=0){
                    //		                if(ref.indexOf("baidu.com")>=0){
                    //    		            
                    //		                    var cookiestr;
                    //		                    cookiestr="Session=smartlinkcode=U2671&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&smartlinklanguage=zh;path=/;domain="+obj.domain+";expires="+obj.expires;
                    //				            document.cookie=cookiestr;
                    //        				    
                    //				            cookiestr="Union=AllianceID=2254&SID=2671&OUID=;path=/;domain="+obj.domain+";expires="+new Date((new Date()).getTime()+7*24*3600000).toGMTString();
                    //				            document.cookie=cookiestr;
                    //    		            
                    //		                }else if(ref.indexOf("google.cn")>0 || ref.indexOf("google.com.hk")>0){
                    //    		            
                    //		                    var cookiestr;
                    //		                    cookiestr="Session=smartlinkcode=U2672&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&smartlinklanguage=zh;path=/;domain="+obj.domain+";expires="+obj.expires;
                    //				            document.cookie=cookiestr;
                    //        				    
                    //				            cookiestr="Union=AllianceID=2255&SID=2672&OUID=;path=/;domain="+obj.domain+";expires="+new Date((new Date()).getTime()+7*24*3600000).toGMTString();
                    //				            document.cookie=cookiestr;
                    //    		             
                    //		                }else if(ref.indexOf("soso.com")>0){
                    //    		            
                    //		                    var cookiestr;
                    //		                    cookiestr="Session=smartlinkcode=U2673&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&smartlinklanguage=zh;path=/;domain="+obj.domain+";expires="+obj.expires;
                    //				            document.cookie=cookiestr;
                    //        				    
                    //				            cookiestr="Union=AllianceID=2256&SID=2673&OUID=;path=/;domain="+obj.domain+";expires="+new Date((new Date()).getTime()+7*24*3600000).toGMTString();
                    //				            document.cookie=cookiestr;
                    //    		            
                    //		                }else if(ref.indexOf("bing.com")>0){
                    //    		            
                    //		                    var cookiestr;
                    //		                    cookiestr="Session=smartlinkcode=U2674&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&smartlinklanguage=zh;path=/;domain="+obj.domain+";expires="+obj.expires;
                    //				            document.cookie=cookiestr;
                    //        				    
                    //				            cookiestr="Union=AllianceID=2257&SID=2674&OUID=;path=/;domain="+obj.domain+";expires="+new Date((new Date()).getTime()+7*24*3600000).toGMTString();
                    //				            document.cookie=cookiestr;
                    //    		            
                    //		                }else
                    //		                {
                    //		        
                    //		                    document.cookie=arr.join('; ');
                    //		                }
                    //		            }
                    //		            else
                    //		            {
                    //		                document.cookie=arr.join('; ');
                    //		            }
                }
            }

            var delArr = ["src%5Fname", "src%5Fkeyword", "src%5FQuary", "src%5Fhost"];
            for (var i = 0, l = delArr.length; i < l; i++) {
                document.cookie = delArr[i] + "=; domain=" + obj.domain + "; path=/; expires=" + new Date(0).toGMTString();
            }
        }
    }
    function trackInfo() {
        if (los = loc.match(new RegExp('[/?&]c=([^&]+)'))) return 0;
        var cs = loc.match(new RegExp('[/#&]c=([^&]+)'));
        var n = '', k = '', q = '', e = '';
        var o, s, i = 0, x = c_ntsdata.length;
        while (i < x) {
            s = c_ntsdata[i].split('|');
            if (host.indexOf(s[1]) > -1) {
                n = s[0];
                e = s[3];
                for (var j = 0, a = s[2].split(';'), m, y = a.length; j < y; j++) {

                    if (m = ref.match(new RegExp('[/?&]' + a[j] + '([^&]+)'))) {
                        q = m[1];
                        break;
                    }
                    break;
                }

            }
            i++;
        }
        if (!n) {
            n = r_site.test(host) ? host.match(r_site)[2] : '';
            if (!n) return 0;
        }
        if (cs && cs.length > 1) {
            if (loc.indexOf("c=baidumap") >= 0) {
                n = "baidumap";
            } else {
                n = cs[1];
            }
        }
        else if (n == 'google' && /gb2312/i.test(ref) || e == 'URLEncode')
            q = '_URL.' + q;
        else if (e == 'UTF-8')
            q = '_UTF.' + decodeURIComponent(q);
        else
            q = '_UTF.' + q;
        q = escape(q);
        o = { si: n, ke: k, qu: q, ho: host, la: slv };
        return c_template.replace(/\{(\w+)\}/g, function (_, s) { return o[s]; });
    }
    function trackInfoEx() {
        if (!los) return 0;
        var s = los[1], n = '', k = '', q = '', o, a;
        if (s.indexOf('A') > -1) {
            a = s.split('A');
            n = a[0];
            k = a[1];
        }
        if (!n) return 0;
        else
            k = (k == 1) ? '' : k;
        k = escape(k);
        o = { si: n, ke: k, qu: q, ho: host, la: slv };
        return c_template.replace(/\{(\w+)\}/g, function (_, s) { return o[s]; });
    }
})();

(function () {
    try {
        var refQueryString = location.search || "";
    } catch (e) {
        var refQueryString = document.URL.match(/\?[^#]+/) || "";
    }
    function getQuery(name) {
        var query = refQueryString.match(new RegExp("[\\?&]" + name + "=([^&]+)", "i"));
        return query ? unescape(query[1]) : null;
    };
    var arr = [], query;
    var list = ["campaign", "adid"];
    for (var i = 0; i < list.length; i++) {
        query = getQuery(list[i]);
        if (query)
            arr.push(list[i] + "=" + escape(query));
    }
    if (arr.length) {
        var domain = document.domain.match(/ctrip\.com\.hk|ctrip\.com\.cn|sh\.ctriptravel\.com/) || "ctrip.com";
        document.cookie = "traceExt=" + arr.join("&") + "; domain=" + domain + "; path=/; expires=" + new Date((new Date()).getTime() + 31 * 24 * 3600000).toGMTString();
    }

})();


//ubt ��������
(function () {
    var slist=document.getElementsByTagName('script') || [];
    var reg=/_bfa\.min\.js/i;
    for(var i=0;i<slist.length;i++){
        if(reg.test(slist[i].src)){
            return;
        }
    }
    try{
        var url=document.location.href;
    }catch(e){
        var url=document.URL;
    }
    if(window.$_bf || window.$LAB || window.CtripJsLoader || !/^https?:\/\/[^\/]*\bpages\b/i.test(url) ){
        return;
    }
    var d=new Date();
    var v='?v='+d.getFullYear()+d.getMonth()+'_'+d.getDate()+'.js';
    var bf = document.createElement('script');
    bf.type = 'text/javascript';
    bf.charset = 'utf-8';
    bf.async = true;
    try {
        var p = 'https:' == document.location.protocol;
    } catch (e) {
        var p = 'https:' == url.match(/[^:]+/) + ":";
    }
    bf.src=(p?"js/_bfa.min.js"+v:'js/_bfa.min.js'+v);
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(bf, s);
     
})();


//add by pengls 2013-01-18
//modify by pengls 2013-06-03
//360box�ר��Ƶ�ҳ�浯��  begin
(function () {

    var host = window.location.host;
	//��Ʊ���Ƶꡢ�ȼ�
    if ((host == "hotels.ctrip.com" || host == "hotels.testp.sh.ctriptravel.com" || host == "hotels.uat.sh.ctriptravel.com")
		|| (host == "flights.ctrip.com" || host == "flights.testp.sh.ctriptravel.com"|| host == "flights.uat.sh.ctriptravel.com"))
		{
        
		var Request = GetRequest();
        var allianceID = Request["allianceid"];
        var Sid = Request["sid"];
		var loc = window.location.toString().toLocaleLowerCase(); //#c=360oneboxf
		
        //��allianceID =3052 �� Sid= 86710
        if ((allianceID == "3052" && Sid == "86710") || 
			(allianceID == "5376" && Sid == "176275") ||
			(allianceID == "3052" && Sid == "133134") ||
			(loc.indexOf("#c=360oneboxf") >= 0)) {
                var url = "http://www.ctrip.com/home/page_360.asp";
                if (document.all) {
                    open_ad_ie(url);
                }
        }
    }

    //��Ͷ
    function open_ad_ie(url) {
        var width = window.screen.width; //��Ļ�ֱ��ʵĸ�
        var height = window.screen.height; //��Ļ�ֱ��ʵĿ�
        var fullScreenFeatureList = "menubar=yes,titlebar=yes,toolbar=yes,location=yes,directories=yes,status=yes,resizable=yes,scrollbars=yes";
        fullScreenFeatureList += ",width=" + width;
        fullScreenFeatureList += ",height=" + height;
        var page = window.open(url, "newwindow", fullScreenFeatureList);
        if (page) {
            page.blur();
        }
    }
    //��ȡRequest
    function GetRequest() {
        var url = location.search; //��ȡurl��"?"�����ִ�
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1).toLocaleLowerCase();
            var strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }

        }
        return theRequest;
    }
})();
//360box�ר��Ƶ�ҳ�浯��  end