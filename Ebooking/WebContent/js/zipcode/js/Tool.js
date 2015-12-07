
$(document).ready(function() {
    $("#txtZip").keyup(function(e) {
        var obj = $("#txtZip");
        var offset = obj.offset();
        var topvalue = offset.top + obj.height() + 5;
        var leftvalue = offset.left;
        $("#show").css({ left: leftvalue, top: topvalue });
        keysearch(e)
    });

    $("#btnZip").bind("click", function() {
        $("#Zipresult").val("");
        var keyvalue = $("#txtZip").val();
        if ($.trim(keyvalue) == '') {
            alert("地区不能为空!");
            $("#Zipresult").val("");
            return;
        }
        $.ajax({
            url: 'http://localhost:8080/gx_website/js/zipcode/js/zip.xml', datatype: 'xml',
            success: function(xml) {
                $(xml).find("Zips>Citycode").each(function() {
                    var temp = $(this).attr("city");
                    if (temp == keyvalue) {
                        $("#Zipresult").val($(this).attr("zip"));
                    }
                })
            },
            beforeSend: function() {
            },
            complete: function() {
            }
        })
    })
})

function keysearch(e) {
    if (e.keyCode == 38 || e.keyCode == 40 || e.keyCode == 13 || e.keyCode == 27 || e.keyCode == 9) {
        //键盘事件
        //向下按键
        if (e.keyCode == 40) {
            if ($("#show li.select").next().text() != "") {
                $("#show li.select").removeClass("select").addClass("unselect").next().removeClass("unselect").addClass("select");
            }
            else {
                $("#show li.select").removeClass("select").addClass("unselect");
                $("#show li:first").removeClass("unselect").addClass("select");
            }
        }
        //向上按键
        if (e.keyCode == 38) {
            if ($("#show li.select").prev().text() != "") {
                $("#show li.select").removeClass("select").addClass("unselect").prev().removeClass("unselect").addClass("select");
            } else {
                $("#show li.select").removeClass("select").addClass("unselect");
                $("#show li:last").removeClass("unselect").addClass("select");
            }
        }
        //回车按键
        if (e.keyCode == 13) {
            var value = $("#show li.select").text();
            if (value.length > 1)
                $("#txtZip").val(value);
            hide();
        }
    }
    else {
        var keyvalue = $("#txtZip").val();
        if (keyvalue.length > 0) {
            bindData(keyvalue);
        }
        else {
            hide()
        }
    }
}
function hide() {
    $("#show").hide();
}
function bindData(key) {
    var result = "[";
    $.ajax({ url: 'http://localhost:8080/gx_website/js/zipcode/js/zip.xml', datatype: 'xml',
        success: function(xml) {
            $(xml).find("Zips>Citycode").each(function() {
                var temp = $(this).attr("city");
                if (temp.indexOf(key) > 0 || temp.indexOf(key) == 0) {
                    result = result + "{\"city\":\"" + temp + "\"},";
                }
            })
            if (result != '[') {
                result = result.substring(0, result.length - 1);
                result = result + "]";
            }
            else
                return;

            var json = eval(result);
            if (json != null) {
                var content = "";
                $.each(json, function(i) {
                    if (i < 11)
                        content += '<li class="unselect">' + json[i].city + '</li>';
                })
                //content += "</ul>";
                $("#show").html(content);
                $("#show").show();
                $("#show li").mouseover(function() {
                    $("#show li.select").removeClass("select").addClass("unselct");
                    $(this).removeClass("unselect").addClass("select");
                }).mouseout(function() {
                    $(this).removeClass("select").addClass("unselect");
                }).click(function() {
                    var value = $("#show li.select").text();
                    if (value.length > 1)
                        $("#txtZip").val(value);
                    hide();
                })
            }

        }
    })
}