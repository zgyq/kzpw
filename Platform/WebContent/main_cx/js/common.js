//字符串转时间
Date.prototype.convertDate = function (date) {
    var flag = true;
    var dateArray = date.split("-");
    if (dateArray.length != 3) {
        dateArray = date.split("/");
        if (dateArray.length != 3) {
            return null;
        }
        //如果是倒过来的日期
        if(parseInt(dateArray[2])>31)
            flag = false;
    }

    var newDate = new Date();

    if (flag) {
        // month从0开始 
        newDate.setFullYear(parseInt(dateArray[0]), parseInt(dateArray[1]) - 1, parseInt(dateArray[2]));
    }
    else {
        newDate.setFullYear(parseInt(dateArray[2]), parseInt(dateArray[1]) - 1, parseInt(dateArray[0]));

    }
    newDate.setHours(0, 0, 0);
    return newDate;
};
// 对Date的扩展，将 Date 转化为指定格式的String   
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function (fmt) { //author: meizz   
    var o = {
        "M+": this.getMonth() + 1,                 //月份   
        "d+": this.getDate(),                    //日   
        "h+": this.getHours(),                   //小时   
        "m+": this.getMinutes(),                 //分   
        "s+": this.getSeconds(),                 //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds()             //毫秒   
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
} 

//链接删除提示
function linkDelOp(url, objmsg) {
    var msg = "删除记录后不可恢复，您确定吗？";
    if (arguments.length == 2) {
        msg = objmsg;
    }
    $.dialog.confirm(msg, function () {
        window.location.href = url;
    });
    return false;
}
//日期差 
function dateDiff(date1, date2) {
    var sDate = date1;
    var eDate = date2;
    var sArr = sDate.split("-");
    var eArr = eDate.split("-");
    var sRDate = new Date(sArr[0], sArr[1], sArr[2]);
    var eRDate = new Date(eArr[0], eArr[1], eArr[2]);
    var result = (eRDate - sRDate) / (24 * 60 * 60 * 1000);
    return result;
}

/*返回*/
function toBack(url) {
    if (url == "")
        history.back(-1);
}

function gourl(url) {
    window.location.href = url;
}


//全选取消按钮函数
function checkAll(chkobj) {
    var ist = false;
    if ($(chkobj).text() == "全选") {
        $("#span_checkall").html("取消");
        //$(".checkall input:enabled").prop("checked", true);
        $("#check_all_ck:enabled").prop("checked", true);
        ist = true;
    } else {
        $(chkobj).children("span").text("全选");
        //$(".checkall input:enabled").prop("checked", false);
        $("#check_all_ck:enabled").prop("checked", false);
    }

    var cklist = $(".checkall input:enabled");
    var len = cklist.length;
    var ct = 5000;
    if (len > 0) {
        if (len > ct)
            len = ct;
        for (var i = 0; i < len; i++) {
            $(cklist[i]).prop("checked", ist);
        }
    }
}
function checkAll1(obj) {
    if (obj.checked == true)
        $("#span_checkall").html("取消");
    else $("#span_checkall").html("全选");

    var cklist = $(".checkall input:enabled");
    var len = cklist.length;
    var ct = 5000;
    if (len > 0) {
        if (len > ct)
            len = ct;
        for (var i = 0; i < len; i++) {
            $(cklist[i]).prop("checked", obj.checked);
        }
    }
}
function checkAll2(obj) {
    //$(".checkall input:enabled").prop("checked", obj.checked);
    var cklist = $(".checkall input:enabled");
    var len = cklist.length;
    var ct = 5000;
    if (len > 0) {
        if (len > ct)
            len = ct;
        for (var i = 0; i < len; i++) {
            $(cklist[i]).prop("checked", obj.checked);
        }
    }
}
//Tab控制函数
function tabs(tabObj) {
    var tabNum = $(tabObj).parent().index("li")
    //设置点击后的切换样式
    $(tabObj).parent().parent().find("li a").removeClass("selected");
    $(tabObj).addClass("selected");
    //根据参数决定显示内容
    $(".tab-content").hide();
    $(".tab-content").eq(tabNum).show();
}

//===========================工具类函数============================
//只允许输入数字
function checkNumber(e) {
    if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {  //FF 
        if (!((e.which >= 48 && e.which <= 57) || (e.which >= 96 && e.which <= 105) || (e.which == 8) || (e.which == 46)))
            return false;
    } else {
        if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105) || (event.keyCode == 8) || (event.keyCode == 46)))
            event.returnValue = false;
    }
}
//检查短信字数
function checktxt(obj, txtId) {
    var txtCount = $(obj).val().length;
    if (txtCount < 1) {
        return false;
    }
    var smsLength = Math.ceil(txtCount / 62);
    $("#" + txtId).html("您已输入<b>" + txtCount + "</b>个字符，将以<b>" + smsLength + "</b>条短信扣取费用。");
}
//四舍五入函数
function ForDight(Dight, How) {
    Dight = Math.round(Dight * Math.pow(10, How)) / Math.pow(10, How);
    return Dight;
}
//写Cookie
function addCookie(objName, objValue, objHours) {
    var str = objName + "=" + escape(objValue);
    if (objHours > 0) {//为0时不设定过期时间，浏览器关闭时cookie自动消失
        var date = new Date();
        var ms = objHours * 3600 * 1000;
        date.setTime(date.getTime() + ms);
        str += "; expires=" + date.toGMTString();
    }
    document.cookie = str;
}

//读Cookie
function getCookie(objName) {//获取指定名称的cookie的值
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if (temp[0] == objName) return unescape(temp[1]);
    }
    return "";
}

//========================基于lhgdialog插件========================
//可以自动关闭的提示，基于lhgdialog插件
function jsprint(msgtitle, url, msgcss, callback) {
    var iconurl = "";
    switch (msgcss) {
        case "Success":
            iconurl = "32X32/succ.png";
            break;
        case "Error":
            iconurl = "32X32/fail.png";
            break;
        default:
            iconurl = "32X32/hits.png";
            break;
    }
    $.dialog.tips(msgtitle, 1, iconurl);
    setTimeout(function () {
        if (url == "back") {
            frames["mainframe"].history.back(-1);
            //history.back(-1);
        } else if (url != "") {
            alert(url);
            //frames["mainframe"].src = url;
            $("#mainframe").src = url;
            //window.location.href = url;
        }
    }, 1000);

    //执行回调函数
    if (arguments.length == 4) {
        callback();
    }
}
//弹出一个Dialog窗口
function jsdialog(msgtitle, msgcontent, url, msgcss, callback) {
    var iconurl = "";
    var argnum = arguments.length;
    switch (msgcss) {
        case "Success":
            iconurl = "success.gif";
            break;
        case "Error":
            iconurl = "error.gif";
            break;
        default:
            iconurl = "alert.gif";
            break;
    }
    var dialog = $.dialog({
        title: msgtitle,
        content: msgcontent,
        fixed: true,
        min: false,
        max: false,
        lock: true,
        icon: iconurl,
        ok: true,
        close: function () {
            if (url == "back") {
                //history.back(-1);
                history.back(-1);
            } else if (url != "") {
                //location.href = url;
                window.location.href = url;
            }
            //执行回调函数
            if (argnum == 5) {
                callback();
            }
        }
    });
}
//打开一个最大化的Dialog
function ShowMaxDialog(tit, url) {
    $.dialog({
        title: tit,
        content: 'url:' + url,
        min: false,
        max: false,
        lock: false
    }).max();
}
//执行回传函数
function ExePostBack(objId, objmsg) {
    if ($(".checkall input:checked").size() < 1) {
        $.dialog.alert('对不起，请选中您要操作的记录！');
        return false;
    }
    var msg = "删除记录后不可恢复，您确定吗？";
    if (arguments.length == 2) {
        msg = objmsg;
    }
    $.dialog.confirm(msg, function () {
        __doPostBack(objId, '');
    });
    return false;
}
//检查是否有选中再决定回传
function CheckPostBack(objId, objmsg) {
    var msg = "对不起，请选中您要操作的记录！";
    if (arguments.length == 2) {
        msg = objmsg;
    }
    if ($(".checkall input:checked").size() < 1) {
        $.dialog.alert(msg);
        return false;
    }
    __doPostBack(objId, '');
    return false;
}
//执行回传无复选框确认函数
function ExeNoCheckPostBack(objId, objmsg) {

    var msg = "删除记录后不可恢复，您确定吗？";
    if (arguments.length == 2) {
        msg = objmsg;
    }
    $.dialog.confirm(msg, function () {
        __doPostBack(objId, '');
    });
    return false;
}
//======================以上基于lhgdialog插件======================

//========================基于Validform插件========================
//初始化验证表单
$.fn.initValidform = function () {
    var checkValidform = function (formObj) {
        $(formObj).Validform({
            tiptype: function (msg, o, cssctl) {
                /*msg：提示信息;
                o:{obj:*,type:*,curform:*}
                obj指向的是当前验证的表单元素（或表单对象）；
                type指示提示的状态，值为1、2、3、4， 1：正在检测/提交数据，2：通过验证，3：验证失败，4：提示ignore状态；
                curform为当前form对象;
                cssctl:内置的提示信息样式控制函数，该函数需传入两个参数：显示提示信息的对象 和 当前提示的状态（既形参o中的type）；*/
                //全部验证通过提交表单时o.obj为该表单对象;
                if (!o.obj.is("form")) {
                    //定位到相应的Tab页面
                    if (o.obj.is(o.curform.find(".Validform_error:first"))) {
                        var tabobj = o.obj.parents(".tab-content"); //显示当前的选项
                        var tabindex = $(".tab-content").index(tabobj); //显示当前选项索引
                        if (!$(".content-tab ul li").eq(tabindex).children("a").hasClass("selected")) {
                            $(".content-tab ul li a").removeClass("selected");
                            $(".content-tab ul li").eq(tabindex).children("a").addClass("selected");
                            $(".tab-content").hide();
                            tabobj.show();
                        }
                    }
                    //页面上不存在提示信息的标签时，自动创建;
                    if (o.obj.parents("td").find(".Validform_checktip").length == 0) {
                        o.obj.parents("td").append("<span class='Validform_checktip' />");
                        o.obj.parents("td").next().find(".Validform_checktip").remove();
                    }
                    var objtip = o.obj.parents("td").find(".Validform_checktip");

                    cssctl(objtip, o.type);
                    objtip.text(msg);
                    $(objtip).css("position", "absolute");
                    var p = o.obj.position(); //获取这个元素的left和top  
                    var x = p.left + o.obj.width(); //获取这个浮动层的left  
                    $(objtip).css("left", x);
                    $(objtip).css("top", p.top);
                }
            },
            showAllError: true
        });
    };
    return $(this).each(function () {
        checkValidform($(this));
    });
}
//======================以上基于Validform插件======================

//智能浮动层函数
$.fn.smartFloat = function () {
    var position = function (element) {
        var top = element.position().top;
        var pos = element.css("position");
        $(window).scroll(function () {
            var scrolls = $(this).scrollTop();
            if (scrolls > top) {
                if (window.XMLHttpRequest) {
                    element.css({
                        position: "fixed",
                        top: 0
                    });
                } else {
                    element.css({
                        top: scrolls
                    });
                }
            } else {
                element.css({
                    position: pos,
                    top: top
                });
            }
        });
    };
    return $(this).each(function () {
        position($(this));
    });
};

//复选框
$.fn.ruleSingleCheckbox = function () {
    var singleCheckbox = function (parentObj) {
        //查找复选框
        var checkObj = parentObj.children('input:checkbox').eq(0);
        parentObj.children().hide();
        //添加元素及样式
        var newObj = $('<a href="javascript:;">'
		+ '<i class="off">否</i>'
		+ '<i class="on">是</i>'
		+ '</a>').prependTo(parentObj);
        parentObj.addClass("single-checkbox");
        //判断是否选中
        if (checkObj.prop("checked") == true) {
            newObj.addClass("selected");
        }
        //检查控件是否启用
        if (checkObj.prop("disabled") == true) {
            newObj.css("cursor", "default");
            return;
        }
        //绑定事件
        $(newObj).click(function () {
            if ($(this).hasClass("selected")) {
                $(this).removeClass("selected");
                //checkObj.prop("checked", false);
            } else {
                $(this).addClass("selected");
                //checkObj.prop("checked", true);
            }
            checkObj.trigger("click"); //触发对应的checkbox的click事件
        });
    };
    return $(this).each(function () {
        singleCheckbox($(this));
    });
};

//多项复选框
$.fn.ruleMultiCheckbox = function () {
    var multiCheckbox = function (parentObj) {
        parentObj.addClass("multi-checkbox"); //添加样式
        parentObj.children().hide(); //隐藏内容
        var divObj = $('<div class="boxwrap"></div>').prependTo(parentObj); //前插入一个DIV
        parentObj.find(":checkbox").each(function () {
            var indexNum = parentObj.find(":checkbox").index(this); //当前索引
            var newObj = $('<a href="javascript:;">' + parentObj.find('label').eq(indexNum).text() + '</a>').appendTo(divObj); //查找对应Label创建选项
            if ($(this).prop("checked") == true) {
                newObj.addClass("selected"); //默认选中
            }
            //检查控件是否启用
            if ($(this).prop("disabled") == true) {
                newObj.css("cursor", "default");
                return;
            }
            //绑定事件
            $(newObj).click(function () {
                if ($(this).hasClass("selected")) {
                    $(this).removeClass("selected");
                    //parentObj.find(':checkbox').eq(indexNum).prop("checked",false);
                } else {
                    $(this).addClass("selected");
                    //parentObj.find(':checkbox').eq(indexNum).prop("checked",true);
                }
                parentObj.find(':checkbox').eq(indexNum).trigger("click"); //触发对应的checkbox的click事件
                //alert(parentObj.find(':checkbox').eq(indexNum).prop("checked"));
            });
        });
    };
    return $(this).each(function () {
        multiCheckbox($(this));
    });
}

//多项选项PROP
$.fn.ruleMultiPorp = function () {
    var multiPorp = function (parentObj) {
        parentObj.addClass("multi-porp"); //添加样式
        parentObj.children().hide(); //隐藏内容
        var divObj = $('<ul></ul>').prependTo(parentObj); //前插入一个DIV
        parentObj.find(":checkbox").each(function () {
            var indexNum = parentObj.find(":checkbox").index(this); //当前索引
            var liObj = $('<li></li>').appendTo(divObj)
            var newObj = $('<a href="javascript:;">' + parentObj.find('label').eq(indexNum).text() + '</a><i></i>').appendTo(liObj); //查找对应Label创建选项
            if ($(this).prop("checked") == true) {
                liObj.addClass("selected"); //默认选中
            }
            //检查控件是否启用
            if ($(this).prop("disabled") == true) {
                newObj.css("cursor", "default");
                return;
            }
            //绑定事件
            $(newObj).click(function () {
                if ($(this).parent().hasClass("selected")) {
                    $(this).parent().removeClass("selected");
                } else {
                    $(this).parent().addClass("selected");
                }
                parentObj.find(':checkbox').eq(indexNum).trigger("click"); //触发对应的checkbox的click事件
                //alert(parentObj.find(':checkbox').eq(indexNum).prop("checked"));
            });
        });
    };
    return $(this).each(function () {
        multiPorp($(this));
    });
}

//多项单选
$.fn.ruleMultiRadio = function () {
    var multiRadio = function (parentObj) {
        parentObj.addClass("multi-radio"); //添加样式
        parentObj.children().hide(); //隐藏内容
        var divObj = $('<div class="boxwrap"></div>').prependTo(parentObj); //前插入一个DIV
        parentObj.find('input[type="radio"]').each(function () {
            var indexNum = parentObj.find('input[type="radio"]').index(this); //当前索引
            var newObj = $('<a href="javascript:;">' + parentObj.find('label').eq(indexNum).text() + '</a>').appendTo(divObj); //查找对应Label创建选项
            if ($(this).prop("checked") == true) {
                newObj.addClass("selected"); //默认选中
            }
            //检查控件是否启用
            if ($(this).prop("disabled") == true) {
                newObj.css("cursor", "default");
                return;
            }
            //绑定事件
            $(newObj).click(function () {
                $(this).siblings().removeClass("selected");
                $(this).addClass("selected");
                parentObj.find('input[type="radio"]').prop("checked", false);
                parentObj.find('input[type="radio"]').eq(indexNum).prop("checked", true);
                parentObj.find('input[type="radio"]').eq(indexNum).trigger("click"); //触发对应的radio的click事件
                //alert(parentObj.find('input[type="radio"]').eq(indexNum).prop("checked"));
            });
        });
    };
    return $(this).each(function () {
        multiRadio($(this));
    });
}

//单选下拉框
$.fn.ruleSingleSelect = function () {
    var singleSelect = function (parentObj) {
        parentObj.addClass("single-select"); //添加样式
        parentObj.children().hide(); //隐藏内容
        var divObj = $('<div class="boxwrap"></div>').prependTo(parentObj); //前插入一个DIV
        //创建元素
        var titObj = $('<a class="select-tit" href="javascript:;"><span></span><i></i></a>').appendTo(divObj);
        var itemObj = $('<div class="select-items"><ul></ul></div>').appendTo(divObj);
        var arrowObj = $('<i class="arrow"></i>').appendTo(divObj);
        var selectObj = parentObj.find("select").eq(0); //取得select对象
        //遍历option选项
        selectObj.find("option").each(function (i) {
            var indexNum = selectObj.find("option").index(this); //当前索引
            var liObj = $('<li>' + $(this).text() + '</li>').appendTo(itemObj.find("ul")); //创建LI
            if ($(this).prop("selected") == true) {
                liObj.addClass("selected");
                titObj.find("span").text($(this).text());
            }
            //检查控件是否启用
            if ($(this).prop("disabled") == true) {
                liObj.css("cursor", "default");
                return;
            }
            //绑定事件
            liObj.click(function () {
                $(this).siblings().removeClass("selected");
                $(this).addClass("selected"); //添加选中样式
                selectObj.find("option").prop("selected", false);
                selectObj.find("option").eq(indexNum).prop("selected", true); //赋值给对应的option
                titObj.find("span").text($(this).text()); //赋值选中值
                arrowObj.hide();
                itemObj.hide(); //隐藏下拉框
                selectObj.trigger("change"); //触发select的onchange事件
                //alert(selectObj.find("option:selected").text());
            });
        });
        //设置样式
        //titObj.css({ "width": titObj.innerWidth(), "overflow": "hidden" });
        //itemObj.children("ul").css({ "max-height": $(document).height() - titObj.offset().top - 62 });

        //检查控件是否启用
        if (selectObj.prop("disabled") == true) {
            titObj.css("cursor", "default");
            return;
        }
        //绑定单击事件
        titObj.click(function (e) {
            e.stopPropagation();
            if (itemObj.is(":hidden")) {
                //隐藏其它的下位框菜单
                $(".single-select .select-items").hide();
                $(".single-select .arrow").hide();
                //位于其它无素的上面
                arrowObj.css("z-index", "1");
                itemObj.css("z-index", "1");
                //显示下拉框
                arrowObj.show();
                itemObj.show();
            } else {
                //位于其它无素的上面
                arrowObj.css("z-index", "");
                itemObj.css("z-index", "");
                //隐藏下拉框
                arrowObj.hide();
                itemObj.hide();
            }
        });
        //绑定页面点击事件
        $(document).click(function (e) {
            selectObj.trigger("blur"); //触发select的onblure事件
            arrowObj.hide();
            itemObj.hide(); //隐藏下拉框
        });
    };
    return $(this).each(function () {
        singleSelect($(this));
    });
}