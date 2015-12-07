<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<ww:head name="black"/>
</head>

<body>
<div id="container">
    <div class="center">
    <ww:include page="themetop.jsp"></ww:include>
    </div>
    <!--includ top 直接替换掉整个DIV-->
    <div id="main">
      <form>
        <div id="search" class="f">
          <ul>
          <li class="seatchtop">
          <input name="" type="radio" value="" checked="checked" /><span class="mr15">国内机票</span>
          <input name="" type="radio" value="" />国际机票
          </li>
          <li class="choose">
          <input name="" type="radio" value="" checked /><span class="mr15">单程</span><input name="" type="radio" value=""/>往返
          </li>
          <li class="ulli">出发城市：<input type="text" class="text_search" value="" /></li>
          <li class="ulli">到达城市：<input type="text" class="text_search" value="" /></li>
          <li class="ulli">出发时间：<input type="text" class="text_search" value="" /></li>
          <li class="ulli">航空公司：<input type="text" class="text_search" value="" /></li>  
          <li class="but">
          <span class="guild f">搜索最优的机票，<br/> 就上国祥商旅网。</span>
          <span><input type="button" class="button_search" value="立即查询"  /></span></li>        
          </ul>
        </div>
        <!--search over-->
        <div id="ad" class="f">
          <h2 class="new fff">最新咨询</h2>
          <div class="hot">
          <h5 class="fff"><span class="ico">&nbsp;</span>商旅订制业务全新上线！ </h5>
          <p class="dcff58 f">中小企业想对公司差旅活动进行差旅管理， 试试 国祥·中小企业商旅通，国祥商旅网 为您订制最适合您的方案</p>
          <span class="more r">&nbsp;</span>
          <h5 class="fff"><span class="ico">&nbsp;</span>商旅订制业务全新上线！ </h5>
          <p class="dcff58 f">中小企业想对公司差旅活动进行差旅管理， 试试 国祥·中小企业商旅通，国祥商旅网 为您订制最适合您的方案</p>
          <span class="more r">&nbsp;</span>
          </div>
        </div>
        <div class="c"></div>
        </form>
    </div>
</div>
<ww:include page="footer.jsp"></ww:include>
</body>
</html>
