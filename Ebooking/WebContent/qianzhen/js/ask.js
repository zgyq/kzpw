//登陆后下拉菜单
$(document).ready(function() {
    //设置字数参数
    var addTitle = {
		'maxCharacterSize': 50,
		'originalStyle': 'originalTextareaInfo',
		'warningStyle': 'warningTextareaInfo',
		'warningNumber': 10,
		'displayFormat': '#left / #max 字'
	};
    var addBuchong = {
		'maxCharacterSize': 1000,
		'originalStyle': 'originalTextareaInfo',
		'warningStyle': 'warningTextareaInfo',
		'warningNumber': 40,
		'displayFormat': '#left / #max 字'
	}; 
	//执行字数检测
    $('#title').textareaCount(addTitle);
    $('#buchong').textareaCount(addBuchong);
    $('#replytext').textareaCount(addBuchong);
    $("#addask_form textarea,#replytext").elastic();
    //返回头部
    $("#toTop").scrollToTop();
    //搜索查询按钮
    $("#search_button").hover(function() {
        $(this).addClass("search_but_hover");
    }, function() {
        $(this).removeClass("search_but_hover");
    });
    //标签提示
    $(".tip").miniTip({position:"right"});
    
    //执行键盘监控
    keyboard();
    //添加标签
    $('#add_tags').tagsInput({
    //'autocomplete_url': '/e/ask/askGetTags.html', //自动完成插件的文件地址，demo里有说明
   //'autocomplete': { option: value, option: value}, //自动完成插件的参数，demo有说明。（提供个jquery.autocomplete的：http://bassistance.de/jquery-plugins/jquery-plugin-autocomplete/）
   'interactive':true, //是否允许添加标签，false为阻止
   'defaultText':'添加标签', //默认文字
   //'onAddTag':onAddTag //增加标签的回调函数
   //'onRemoveTag':onRemoveTag, //删除标签的回调函数
   //'onChange' : onChangeTag, //改变一个标签时的回调函数
   //'removeWithBackspace' : true, //是否允许使用退格键删除前面的标签，false为阻止
   //'minChars' : 0 //每个标签的小最字符
   //'maxChars' : 0 //每个标签的最大字符，如果不设置或者为0，就是无限大
   'width' : '440px',
   'height' : 'aoto'
   //'placeholderColor' : '#666666' //设置defaultText的颜色
   });   
});

//键盘按键监控
function keyboard() {
    var input = $("#keyboard");
    input.keyup(function(evn) {
        if (evn.keyCode == 38) {
            var liSize = $("#liSize").val();
            //datagrid中tr的数量
            var prevLiIndex = parseInt($("#prevLiIndex").val());
            if (prevLiIndex == -1 || prevLiIndex == 0) {
                clickLi(liSize - 1);
            } else if (prevLiIndex > 0) {
                clickLi(prevLiIndex - 1);
            }
            return false;
        } else if (evn.keyCode == 40) {
            var liSize = $("#liSize").val();
            //datagrid中tr的数量
            var prevLiIndex = parseInt($("#prevLiIndex").val());
            if (prevLiIndex == -1 || prevLiIndex == liSize - 1) {
                clickLi(0);
            } else if (prevLiIndex < liSize - 1) {
                clickLi(prevLiIndex + 1);
            }
            return false;
        }
        input.focus();
    });
}

$("#keyboard").keyup(function() {
    //在按键释放时触发
    search_up();
});

$("#keyboard").focusin(function() {
    //获得焦点
    search_up();
});

$("#keyboard").focusout(function() {
    //失去焦点        
    $("#search_menu").fadeOut(200);
});

//执行函数
function clickLi(currLiIndex) {
    var prevLiIndex = $("#prevLiIndex").val();
    if (currLiIndex > -1) {
        $("#li_" + currLiIndex).addClass("t3");
    }
    $("#li_" + prevLiIndex).removeClass("t3");
    $("#li_" + prevLiIndex + " a").removeClass("t3");
    $("#prevLiIndex").val(currLiIndex);
}

function search_up() {
    //提交查询
    var key = $("#keyboard");
    var setkey = $("#setkey");
    var keyboard = $.trim(key.val());
    if (keyboard && keyboard != setkey.val()) {
        //判断关键词不为空且不重复提交
        var str = $("#searchform").serialize();
        var setkey = $("#keyboard").val();
        $("#setkey").val(setkey);
        //储存搜索的关键词
        $.ajax({
            type:"GET",
            url:"/e/ask/class/search.php",
            data:str,
            dataType:"html",
            success:function(msg) {
                $("#search_menu").html(msg);
                $("#search_menu").find("li").each(function(i) {
                    //初始化 id 和 index 属性
                    $(this).attr("id", "li_" + i).attr("index", i);
                });
                var tSize = $(".search_list li").size();
                $("#liSize").val(tSize);
                //统计LI的行数         
                $("#prevLiIndex").val("-1");
                //触发高亮
                $('.search_list li').hover(function(){
                    $(this).addClass("t3");
                    clickLi($(this).attr("index"));
                },function(){
                    $(this).removeClass("t3");
                });
            },
            cache:false
        });
    } else {
        //判断关键词是否为空
        if (key.val() == "") {
            $("#search_menu").html('<div class="search_list"><ul><li>请输入要查询的关键词</li></ul></div>');            
        }
    }
    $("#search_menu").show();
}

/**
 * 短暂提示
 * @param	{String}	提示内容
 * @param	{Number}	显示时间 (默认1.5秒)
 */
artDialog.diggTips = function(content, time) {
    return artDialog({
        id:"diggTips",
        title:false,
        cancel:false,
        background:"#FFF",
        opacity:.6,
        lock:true,
        fixed:true
    }).content('<div style="padding: 0;">' + content + "</div>").time(time || 1.5);
};

//问答回答digg
function userDigg(dotop, classid, id) {
    var str = "classid=" + classid + "&id=" + id + "&dotop=" + dotop + "&doajax=1&ajaxarea=diggnum";
    $.ajax({
        type:"GET",
        url:"/e/public/digg/",
        data:str,
        dataType:"html",
        success:function(data) {
            var info = data.split("|");
            if (info[0] && dotop) {
                $("#diggnum" + id).text(info[0]);
            }
            $.dialog.diggTips(info[2], 1.5);
        },
        cache:false
    });
}

//显示提问
function addAsk() {
    $.dialog({
        id:"A72K23I",
        title:"签证问答提问",
        content:document.getElementById("addask_form"),
        background:"#FFF",
        opacity:.6,
        lock:true,
        resize:false,
        button:[{
            name:"我要提问",
            callback:function() {
                var str = $("#addask_form").children("form").serialize();
                var str = "enews=addAsk&classid=106&toclassid=106&mid=12&gotoinfourl=1&" + str;
                $.ajax({
                    type:"POST",
                    url:"/e/ask/askAddInfo.php/",
                    data:str,
                    dataType:"html",
                    success:function(data) {
                        //判断提交成功
                        var info = data.split("|");
                        if (info[1] == "success") {
                            $.dialog.list['A72K23I'].close();
                            $.dialog({
                                id: "addAskTips",
                                title: false,
                                content: '<div style="padding: 0;">' + info[2] + '</div>',
                                cancel: false,
                                background: "#FFF",
                                opacity: .6,
                                lock: true,
                                fixed: true,
                                time: 2,
                                close: function () {
                                    //提交后跳转到新页面
                                    window.location = info[0];
                                }
                            });
                        } else {
                            $.dialog.diggTips(info[2], 2.5);
                        }
                    },
                    cache:false
                });
                return false                            
            },
            focus:true
        },
        {
            name:"取消"
        }]
    });
}

//显示生成回复窗口
function showTalk(askid, rpid, tkid) {
    var $all = $(".reply").find(".talk_form");
    //组合id
    if (rpid && tkid) {
        var formid = "talk_form_" + rpid + "_" + tkid;
        var formbid = "talk_" + tkid;
        var talktext = "回复 @" + $("#talker_" + tkid).text() + "：";
        var addTalkSet = askid + "," + rpid + "," + tkid;
    } else {
        var formid = "reply_" + rpid;
        var formbid = "reply_" + rpid;
        var talktext = "";
        var addTalkSet = askid + "," + rpid;
    }
    //预插入代码
    var tpl = '<div class="talk_form" id="' + formid + '">' + '<div class="talk_form_text"><textarea name="talktext">' + talktext + "</textarea></div>" + '<div class="talk_form_btn fix"><a class="submit" href="javascript:addTalk('+addTalkSet+');">　</a></div>' + "</div>";
    //插入位置和显示
    if (!$all.is("#" + formid)) {
        $("#" + formbid).append(tpl);
    }
    //遍历隐藏或显示当前 其他全隐藏  
    $all.each(function(i) {
        if ($(this).attr("id") == formid) {
            $(this).toggle();
        } else {
            $(this).hide();
        }
    });
}

//添加答案
function addReply(askid) {
    //rp.getPlainTxt();    
    var str = $("#sub_keywd").children("form").add($("#replytext")).serialize();
    var str = "enews=addReply&classid=107&toclassid=107&mid=13&" + str;
    $.ajax({
        type:"POST",
        url:"/e/ask/askAddInfo.php/",
        data:str,
        dataType:"html",
        success:function(data) {
            //判断提交成功
            var info = data.split("|");
            if (info[1] == "success") {
                $.ajax({
                    type:"GET",
                    url:"/e/ask/askGetInfo.php?enews=getreply&askid=" + askid,
                    dataType:"json",
                    success:function(data) {
                        $("#reply_list").html(data.reply_list);
                        //加载digg提示
                        $(".tip").miniTip({position:"right"});
                    },
                    cache:false
                });
                //清空编辑器内容
                $("#replytext").height(100).val('');
                $("#replytext").elastic();
            }
            $.dialog.diggTips(info[2], 2.5);
        },
        cache:false
    });
}

//添加讨论回复
function addTalk(askid, rpid, tkid) {
    //ue.getPlainTxt();
    //组合id
    if (rpid && tkid) {
        var formid = "talk_form_" + rpid + "_" + tkid;
    } else {
        var formid = "reply_" + rpid;
    }
    var str = $("#sub_keywd").children("form").add($("#" + formid).find("textarea")).serialize();
    var str = "enews=addTalk&classid=108&toclassid=108&replyid=" + rpid + "&mid=14&" + str;
    $.ajax({
        type:"POST",
        url:"/e/ask/askAddInfo.php/",
        data:str,
        dataType:"html",
        success:function(data) {
            //判断提交成功
            var info = data.split("|");
            if (info[1] == "success") {
                $("#" + formid).remove();
                $.ajax({
                    type:"GET",
                    url:"/e/ask/askGetInfo.php?enews=getreply&askid=" + askid,
                    dataType:"json",
                    success:function(data) {
                        $("#reply_list").html(data.reply_list);
                        //加载digg提示
                        $(".tip").miniTip({position:"right"});
                    },
                    cache:false
                });
            }
            $.dialog.diggTips(info[2], 2.5);
        },
        cache:false
    });
}
