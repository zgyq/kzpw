 var flag = "left";
                            function DY_scroll(wraper, prev, next, img, speed, or) {
                                var wraper = $(wraper);
                                var prev = $(prev);
                                var next = $(next);
                                var img = $(img).find('ul');
                                var w = img.find('li').outerWidth(true);
                                var s = speed;
                                next.click(function () {
                                    img.animate({ 'margin-left': -w}/*,1500,'easeOutBounce'*/, function () {
                                        img.find('li').eq(0).appendTo(img);
                                        img.css({ 'margin-left': 0 });
                                    });
                                    flag = "left";
                                });
                                prev.click(function () {
                                    img.find('li:last').prependTo(img);
                                    img.css({ 'margin-left': -w });
                                    img.animate({ 'margin-left': 0}/*,1500,'easeOutBounce'*/);
                                    flag = "right";
                                });
                                if (or == true) {
                                    ad = setInterval(function () { flag == "left" ? next.click() : prev.click() }, s * 1000);
                                    wraper.hover(function () { clearInterval(ad); }, function () { ad = setInterval(function () { flag == "left" ? next.click() : prev.click() }, s * 1000); });
                                }
                            }
                            DY_scroll('.hl_main5_content', '.hl_scrool_leftbtn', '.hl_scrool_rightbtn', '.hl_main5_content1', 2, true); // true为自动播放，不加此参数或false就默认不自动 