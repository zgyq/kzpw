//登陆后下拉菜单
$(document).ready(function() {
    $("#ask_tags").tagsInput({
        //'autocomplete_url': '/e/ask/askGetTags.html', //自动完成插件的文件地址，demo里有说明
        //'autocomplete': { option: value, option: value}, //自动完成插件的参数，demo有说明。（提供个jquery.autocomplete的：http://bassistance.de/jquery-plugins/jquery-plugin-autocomplete/）
        interactive:true,
        //是否允许添加标签，false为阻止
        defaultText:"添加标签",
        //默认文字
        //'onAddTag':onAddTag //增加标签的回调函数
        //'onRemoveTag':onRemoveTag, //删除标签的回调函数
        //'onChange' : onChangeTag, //改变一个标签时的回调函数
        //'removeWithBackspace' : true, //是否允许使用退格键删除前面的标签，false为阻止
        //'minChars' : 0 //每个标签的小最字符
        //'maxChars' : 0 //每个标签的最大字符，如果不设置或者为0，就是无限大
        width:"440px",
        height:"aoto"
    });
    //设置字数参数
    var addTitle = {
        maxCharacterSize:50,
        originalStyle:"originalTextareaInfo",
        warningStyle:"warningTextareaInfo",
        warningNumber:10,
        displayFormat:"#left / #max 字"
    };
    var addBuchong = {
        maxCharacterSize:1e3,
        originalStyle:"originalTextareaInfo",
        warningStyle:"warningTextareaInfo",
        warningNumber:40,
        displayFormat:"#left / #max 字"
    };
    //执行字数检测
    $("#ask_title").textareaCount(addTitle);
    $("#ask_buchong").textareaCount(addBuchong);
    $("#addask_form textarea,#replytext").elastic();
    //返回头部
    $("#toTop").scrollToTop();
    //标签提示
    $(".tip").miniTip();
    $(".list_box").hover(function() {
        $(this).addClass("t3");
    }, function() {
        $(this).removeClass("t3");
    });
    //复制模板下载链接到右侧
    cloneDownfile();
});

//标签切换
$("#list_tab a,#content_tab a").click(function() {
    $(this).parent().addClass("selected").siblings().removeClass();
    var vid = $(this).attr("href");
    $(vid).show().siblings().hide();
    //复制模板下载链接到右侧
    cloneDownfile();
    return false;
});

//显示提问
function visa_addAsk() {
    //判断关键词是否存在
    var tags = $("#visa_keyword").text();
    if (!$("#ask_tags").tagExist(tags)) {
        $("#ask_tags").addTag(tags);
    }
    //判断问题标题是否为空
    var askTitle = $("#ask_title").text();
    if (askTitle == "") {
        var visaTitle = $("#visa_title h1").text() + "，";
        $("#ask_title").text(visaTitle);
    }
    $.dialog({
        id:"V72K23I",
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
                            var keyword = encodeURIComponent($("#visa_keyword").text());
                            $.get("/e/visa/index.php/?enews=getvisaask&keyword=" + keyword, function(data) {
                                $("#show_ask").html(data);
                            });
                            $.dialog.list["V72K23I"].close();
                            $.dialog({
                                id:"addAskTips",
                                title:false,
                                content:'<div style="padding: 0;">' + info[2] + "</div>",
                                cancel:false,
                                background:"#FFF",
                                opacity:.6,
                                lock:true,
                                fixed:true,
                                time:2
                            });
                        } else {
                            $.dialog.tips('<span style="color: red;">' + info[2] + "</span>", 2.5);
                        }
                    },
                    cache:false
                });
                return false;
            },
            focus:true
        },
        {
            name:"取消"
        }]
    });
}

//查看样本图片
function showSample(id,subid) {
    $.ajax({
        type:"GET",
        data:"enews=showsample&subid=" + subid,
        url:"/e/visa/index.php/",
        dataType:"json",
        success:function(json) {
            $.fancybox(json, {
                openEffect:"fade",
                closeEffect:"fade",
                prevEffect:"none",
                nextEffect:"none",
                helpers:{
                    title:{
                        type:"inside"
                    }
                },
                afterLoad:function() {
                    this.title = "Image " + (this.index + 1) + " of " + this.group.length + (this.title ? " - " + this.title :"");
                }
            });
        }
    });
}

//复制下载链接集合到右侧
function cloneDownfile() {
    var downfile = $(".downfile a:visible").clone();
    var listbox = $("#downfile_list");
    if (downfile.length) {
        listbox.html('');
        
        downfile.each(function(){
            var libg = $('<li></li>');
            libg.append($(this).addClass("ellipsis"));
            listbox.append(libg);
        });
        listbox.parent().show();
    } else {
        listbox.parent().hide();
    }
}

$(function() {
    //多行应用
    var _wrap = $("#mulitline");
    //定义滚动区域
    var _interval = 3e3;
    //定义滚动间隙时间
    var _moving;
    //需要清除的动画
    _wrap.hover(function() {
        clearInterval(_moving);
    }, function() {
        _moving = setInterval(function() {
            var _field = _wrap.find("li:first");
            //此变量不可放置于函数起始处,li:first取值是变化的
            var _h = _field.height();
            //取得每次滚动高度
            _field.animate({
                marginTop:-_h + "px"
            }, 600, function() {
                //通过取负margin值,隐藏第一行
                _field.css("marginTop", 0).appendTo(_wrap);
            });
        }, _interval);
    }).trigger("mouseleave");
});