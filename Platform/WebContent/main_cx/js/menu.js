//页面尺寸改变时

$(window).resize(function () {
   // navresize();
});
function loadTopMenuTree(_islink) {
    var islink = false;
    if (arguments.length == 1 && _islink) {
        islink = true;
    }
    $("#topmenu").find(".dropmenu").remove();
    $.ajax({
        type: "post",
        url: "httphandler/dashboard.ashx?action=get_topmenu_list&time=" + Math.random(),
        dataType: "html",
        success: function (data, textStatus) {
            if (data != "") {
                var json = $.parseJSON(data);
                if (json.length > 0) {
                    var substr = "";
                    var ht = "";
                    for (var i = 0; i < json.length; i++) {
                        var subht = "<li>";
                        if (json[i].submenu.length > 0) {
                            subht += "<i class='f-a'></i>";
                            substr += "<div class=\"dropmenu\" id=\"dropmenu_" + json[i].id + "\">";
                            substr += "<div class=\"f-w f-cb\"><div>";
                            for (var j = 0; j < json[i].submenu.length; j++) {
                                substr += "<a pid=\"" + json[i].id + "\" id=\"sub_" + json[i].submenu[j].id + "\" ";
                                if (json[i].submenu[j].link_url != "")
                                    substr += "href=\"" + json[i].submenu[j].link_url + "\" target=\"mainframe\" ";
                                else substr += "href=\"#\"";
                                substr += ">" + json[i].submenu[j].sub_title + "</a>";
                            }
                            substr += "</div>"
                            substr += "</div></div>";
                        }
                        subht += "<a href=";
                        if (json[i].link_url != "") {
                            subht += "\"" + json[i].link_url + "\" target=\"mainframe\"";
                        } else subht += "\"#\" onclick=\"loadMenuTree(true," + json[i].id + ")\" ";
                        if (json[i].submenu.length > 0) {
                            subht += " alt=\"" + json[i].id + "\"";
                        }
                        subht += ">";
                        subht += "" + json[i].sub_title + "</a></li>";
                        ht += subht;
                    }
                    $("#f-nav").html(ht);
                    $("#topmenu").append(substr);
                    
                    var alist = $(".dropmenu").find("a");
                    $(alist).click(function () {
                        var sid = $(this).attr("id");
                        var pid = $(this).attr("pid");
                        var i_id = sid.substring(sid.indexOf("sub_") + 4);
                        loadMenuTree(true, pid, i_id);
                    });
                }
            }
        }
    });
}
function writeTree(jsonObj) {
    var str = "";
    for (var i = 0; i < jsonObj.length; i++) {
        var menus = jsonObj[i];
        var ultext = "<ul class=\"f-cb-nav\"><li>";
        var a = "<a ";
        if (menus.link_url != "")
            a += " href=\"" + menus.link_url + "\" target=\"mainframe\">";
        else a += "href=\"#\">";
        a += menus.sub_title + "</a>";
        if (menus.class_layer == "2") {
            var css = "gn";
            if (menus.nav_css != "")
                css = menus.nav_css;
            var s_f = "<span class=\"f-com "+css+"\"></span><h3 id=\"h3_" + menus.id + "\">" + a + "<span class=\"f-side\"></span></h3>";
            str += s_f;
        }
        if (menus.submenu.length > 0) {
            for (var j = 0; j < menus.submenu.length; j++) {
                if (j == 0) {
                    str += ultext;
                }
                var a2 = "<a  ";
                if (menus.submenu[j].link_url != "")
                    a2 += " href=\"" + menus.submenu[j].link_url + "\" target=\"mainframe\">";
                else a2 += "href=\"#\">";
                a2 += menus.submenu[j].sub_title + "</a>";
                str += a2;
                if (menus.submenu[j].submenu.length > 0) {
                    str += writeTree(menus.submenu[j].submenu);
                }
                if (j == menus.submenu.length - 1)
                    str += "<li></ul>";
            }
        }
    }
    return str;
}
//加载管理首页左边导航菜单
function loadMenuTree(_islink, pid, i_id) {

    //判断是否跳转链接
    var islink = _islink;
    if (arguments.length == 1 && _islink) {
        islink = true;
    }
    //发送AJAX请求
    
    $.ajax({
        type: "post",
        url: "httphandler/dashboard.ashx?action=get_navigation_list&pid=" + pid + "&time=" + Math.random(),
        dataType: "html",
        success: function (data, textStatus) {
            var rtn = "";
            if (data != "") {
                var json = $.parseJSON(data);
                rtn = writeTree(json);
            }
            //初始化导航菜单
            $(".m-sd").html(rtn);

            // 左侧 标题
            $(".m-sd").find('h3').click(function () {
                var c = $(this).hasClass('bg');
                if (c) {
                    $(this).removeClass('bg').next('ul').find('li').slideUp(200);
                    $(this).find('span').addClass("f-side").removeClass("side-d");
                } else {
                    $(".m-sd").find('h3').not($(this)).removeClass("bg").next('ul').find('li').slideUp(200);
                    $(".m-sd").find('h3').not($(this)).find('span').addClass("f-side").removeClass("side-d");
                    $(this).addClass("bg");
                    $(this).next("ul").find('li').addClass("open").slideDown(200);
                    $(this).find('span').addClass("side-d").removeClass("f-side");
                }
                $(this).next("ul").find("a:first").click();
            });
            $(".m-sd").click(function (event) {
                var tag = e(event);
                if (tag) {
                    var n = tag.nodeName; //.toLocaleLowerCase();
                    if (n) {
                        n = n.toLocaleLowerCase();
                    }
                    if (n == "a") {
                        var span = document.createElement("span");
                        var a = $(this).find(n);
                        var s = $(this).find(n).find('span');
                        s.remove();
                        for (var i = 0; i < a.length; i++) { a[i].className = ""; }
                        tag.appendChild(span);
                        tag.className = "checkin";
                    }
                }
            });
            if (i_id > 0) {

                $("#h3_" + i_id).click();
                var firsta = $("#h3_" + i_id).next().find("a:first").attr("href");
                if (firsta != "") {
                    $("#h3_" + i_id).next().find("a:first").attr("class", "checkin");
                    if (islink) {
                        $("#mainframe").attr("src", firsta);
                    }
                    else $("#mainframe").attr("src", "welcome.aspx");
                }
            }
            
            else {
                $(".m-sd").find("h3:first").click();
                var firsta = $(".m-sd").find("h3:first").next().find("a:first").attr("href");
                if (firsta != "") {
                    $(".m-sd").find("h3:first").next().find("a:first").attr("class", "checkin");
                    if (islink) {
                        $("#mainframe").attr("src", firsta);
                    }
                    else $("#mainframe").attr("src", "welcome.aspx");
                }
            }
        }
    });
    
}

