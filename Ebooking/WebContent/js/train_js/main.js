var HC = window.HC || {};
HC.AC = HC.AC || {};



HC.AC.mychannels = [//{{{
{
    "name":"JipiaoStart", 
    "channel":"JipiaoGN",
    "input":"k1",
    "container":"container1",
    "resultCount":100,
    "resultsJsonTag":["sKey", "sJianpin"]
},
{
    "name":"JipiaoEnd",
    "channel":"JipiaoGN",
    "input":"k2",
    "container":"container2",
    "resultCount":100,
    "resultsJsonTag":["sKey", "sJianpin"]
},
{
    "name":"SearchChezhan",
    "channel":"JipiaoGN",
    "input":"zhan",
    "container":"container3",
    "resultCount":100,
    "resultsJsonTag":["sKey", "sJianpin"]
}
];


$().ready(//{{{
	function(){
		HC.AC.init(HC.AC.mychannels);
	}
);

//$("body").mousedown(function(){$('#switchsearchselect').hide();});

HC.AC.init = function(configs) {//{{{
    var nChannels = configs.length;
    for(var i=0; i<nChannels; i++){
        var item = configs[i];
        if(!item.name || !item.channel || !item.input ||!item.container||!item.resultsJsonTag){
            continue;
        }
        if(!item.count){
            item.count = 0;
        }
        HC.AC[item["name"]] = new function(item){
            this.oACDS = new YAHOO.widget.DS_ScriptNode("http://www.huoche.com.cn/js/complete/s.php?count="+item.count+"&ch="+item.channel, ["ResultSet.Result"].concat(item.resultsJsonTag));
            this.oACDS.scriptQueryParam = "q";
            this.oACDS.maxCacheEntries = 0;

            // Instantiate AutoComplete
            this.oAutoComp = new YAHOO.widget.AutoComplete(item.input, item.container, this.oACDS);
            this.oAutoComp.queryDelay = 0;
            // this.oAutoComp.animVert = false;
            this.oAutoComp.useShadow = true;
            this.oAutoComp.useIFrame = true;
            if(item.containerWidth){
                this.oAutoComp.containerWidth = item.containerWidth;
            }
            if(item['autoHighlight'] === false){
                this.oAutoComp.autoHighlight = false;
            }
            this.oAutoComp.maxResultsDisplayed = 30;
            this.oAutoComp.prehighlightClassName = "yui-ac-prehighlight";
            this.oAutoComp.setHeader("输入中文/拼音或↑↓选择.")
            this.oAutoComp.formatResult = function(oResultItem, sQuery) {
                var nResultLen = oResultItem.length;
                var oResultItemObject = {};
                for(var i=0; i<nResultLen; i++){
                    oResultItemObject[item.resultsJsonTag[i]] = oResultItem[i];
                }
                var sKey = oResultItemObject["sKey"].slice(0,12);
                    var aMarkup = [];
                    aMarkup.push("<div class='sample-result'>");
                    aMarkup = aMarkup.concat(["",
                        sKey]);
                    if(oResultItemObject.sJianpin){
                        aMarkup = aMarkup.concat(["(",
                            oResultItemObject.sJianpin.toUpperCase(),
                            ")"]);
                    }
                    aMarkup.push("</div>");
                return (aMarkup.join(""));
            };
            if(item["channel"] == "JipiaoGN" || item["channel"] == "JipiaoGJ"){
                this.oAutoComp.textboxFocusEvent.subscribe(function(){
                    var inString ='汉字、拼音或首字母';
                    if(this._elTextbox.value == inString){
                        this._elTextbox.value = "";
                    }
                    this._populateList('', HC.AC[item.channel+"PrePopulateListData"], this);
                });
                this.oAutoComp.itemSelectEvent.subscribe(function(type, args){
                    var result = args[2];
                    if(item["channel"] == "JipiaoGJ"){ 
                        if(item['name'] == "JipiaoStartGJ"){
                                document.sjipiaogj.From.value = result[2].toUpperCase();
                            }
                            if(item['name'] == "JipiaoEndGJ"){
                                document.sjipiaogj.to.value = result[2].toUpperCase();
                            }
                    }
                    if(item["channel"] == "JipiaoGN"){
                        if(item['name'] == "JipiaoStart"){
                                document.sjipiao.From.value = result[2].toUpperCase();
                            }
                            if(item['name'] == "JipiaoEnd"){
                                document.sjipiao.to.value = result[2].toUpperCase();
                            }
                    }

                });
            }
        }(item);
    }
}//}}}


HC.AC.JipiaoGNPrePopulateListData = [
    ["北京","bj"], 
    ["上海", "sh"],
    ["广州", "gz"],
    ["深圳", "sz"],
    ["成都", "cd"],
    ["重庆", "cq"],
    ["西安", "xa"],
    ["杭州", "hz"],
    ["武汉", "wh"],
    ["昆明", "km"]
];

/*
HC.AC.JipiaoStart.oAutoComp.textboxFocusEvent.subscribe(function(){
            var inString ='汉字、拼音或首字母';
            //console.log("in gn:"+this._elTextbox.value)
            if(this._elTextbox.value == inString){
                this._elTextbox.value = "";
            }
            this._populateList('', HC.AC.JipiaoGNPrePopulateListData, this);
        });
*/