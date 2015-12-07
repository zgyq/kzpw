<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅系统-系统公告</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="wel_yplm/css/b2b_gongao.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">
					
		</div>
		<div class="b2b_gonggaozhongxin">
			<div class="c_Left">
				<div class="c_HoDh">
					<div class="c_HoDh_guide">
						公告中心
					</div>
				</div>
				<div class="c_HotCont">
					<div class="c_HotContList add_c_HotContList">
						<div>
							最新公告
							<a   class="c_LeftArrow">
							</a>
						</div>
						<ul>
						<ww:iterator value="sysmessageList" status="ind">
							<li>
								<a href="login!togonggaoinfo.action?sysid=<ww:property value="id" />">
									<ww:property value="title" />
								</a>
							</li>
							</ww:iterator>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="c_Right">
				<div class="c_SearchRTitle">
					公告标题
				</div>
				<div class="c_SearchRCont">
					<ul class="c_SearchRContul">
						<li class="c_SearchRContli">
							<a class="c_SearchGuiz">
								<ww:property value="sysmessage.title" />
							</a>
							<p class="c_SearchPcont">			
								<ww:property value="sysmessage.content" />

							</p>
						</li>

					</ul>
				</div>
			</div>
		</div>
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">			
		</div>
	</body>
</html>