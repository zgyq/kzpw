/*from tccdn minify at 2013-12-11 10:04:57,file：/cn/c/s/2013/searchPhone.0.0.4.js?v=2013102401*/
(function(){fish.one("#searchPhoneNum").on("focus",function(){fish.one("#inPhoneErr").addClass("none");if(this.value=="请输入您的手机号码"){this.value="";fish.one(this).css("color: #333333")}});fish.one("#searchPhoneNum").on("blur",function(){if(fish.trim(this.value).length==0){this.value="请输入您的手机号码";fish.one(this).css("color: #999999")}fish.one("#inPhoneErr").addClass("none")});fish.one("#scheckNum").on("focus",function(){fish.one(this).css("color: #333333");fish.one("#CodeImgErr").addClass("none")});function a(){var f=fish.dom("#searchPhoneNum").value;if(fish.trim(f).length==0||fish.trim(f)=="请输入您的手机号码"){fish.one("#inPhoneErr").removeClass("none");fish.one("#inPhoneErr .phoneErr").html("手机号码不能为空");return false}else{if(!fish.valida.phone(f)){fish.one("#inPhoneErr").removeClass("none");fish.one("#inPhoneErr .phoneErr").html("请检查手机号码是否正确");return false}}fish.one("#inPhoneErr").addClass("none");return true}function b(){var f=fish.dom("#scheckNum").value;if(fish.trim(f).length==0||!/\w{4}/.test(f)){fish.one("#CodeImgErr").removeClass("none");fish.one("#CodeImgErr").html("验证码错误");return false}fish.one("#CodeImgErr").addClass("none");return true}var c=fish.dom("#showCodeImg").src;fish.one("#showCodeImg").on("click",function(){e(this)});function e(f){fish.dom(f).src=c+"&"+Math.random()}fish.all("#searchClint").on("click",function(){var g=fish.trim(fish.one("#searchPhoneNum").val()),f=fish.trim(fish.one("#scheckNum").val());if(a()&&b()){fish.ajax({url:"http://www.17u.cn/zhuanti/ajaxHandler/SendSMSHandler.ashx?action=client&mobile="+g+"&usercodekey="+f,type:"json",fn:function(h){e("#showCodeImg");if(h&&h.state=="200"){fish.one("#inPhoneErr").removeClass("none");fish.one("#inPhoneErr .phoneErr").html("发送成功");d()}else{if(h&&h.state=="054"){fish.one("#inPhoneErr").removeClass("none");fish.one("#inPhoneErr .phoneErr").html("发送次数达到上限")}else{if(h&&h.state=="057"){fish.one("#CodeImgErr").removeClass("none");fish.one("#CodeImgErr").html("验证码错误")}else{fish.one("#inPhoneErr").removeClass("none");fish.one("#inPhoneErr .phoneErr").html("发送失败")}}}}})}});function d(){var f=60,g;g=setInterval(function(){document.getElementById("searchClint").setAttribute("disabled","disabled");fish.one("#searchClint").val(--f+"秒后重发");if(f==0){clearInterval(g);document.getElementById("searchClint").removeAttribute("disabled");fish.one("#searchClint").val("免费发送下载地址到手机")}},1000)}})();