package com.yf.website.web.date;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.website.web.server.Server;




public class WebSite {

	private WebSite() {
		throw new UnsupportedOperationException("UnsupportedOperation");
	}

	public static String SubString(String in, int len) {
		if (in != null && in.length() > len) {
			return in.substring(0, len);
		}
		return in;
	}

	/**
	 * 判断用户是否登录
	 * 
	 * @param request
	 * @return
	 */

/*	public static boolean isLogin(HttpServletRequest request) {
		Member meber = (Member) request.getSession().getAttribute("user");
		if (meber != null) {
			return true;
		}
		return false;
	}*/

	/**
	 * 取得Session中的用户
	 * 
	 * @return
	 */
/*	public static Member getLoginUser(HttpServletRequest request) {

		Member meber = (Member) request.getSession().getAttribute("user");

		return meber;
	}
*/
	/**
	 * 取径伟度
	 */
	// var url
	// ='http://www.sina.com.cn/?maps/geo?q='+hotelname+'&output=csv&key=ABQIAAAAXDq__hWKi9eMCwnn7LrMCxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxSnSVp_Xlsd4Ph5iyMua7PE5E0x_';
	public static String getTude(String hotelname) {
		String tude = "";

		String // url="http://maps.google.com/maps/geo?q="+hotelname+"&output=csv&key=ABQIAAAAXDq__hWKi9eMCwnn7LrMCxT2yXp_ZAY8_ufC3CFXhHIE1NvwkxSnSVp_Xlsd4Ph5iyMua7PE5E0x_A";
		url = "http://maps.google.com/maps/geo?q="
				+ hotelname
				+ "&output=csv&oe=utf8&sensor=true_or_false&key="
				+ ((Sysconfig) Server.getInstance().getSystemService()
						.findAllSysconfig("where c_name='googlemapskey'", "",
								-1, 0).get(0)).getValue();
		InputStream in = null;
		try {
			URL Url = new URL(url);
			URLConnection connection = (URLConnection) Url.openConnection();
			in = connection.getInputStream();
			int len = connection.getContentLength();
			if (len < 0) {
				len = 20480;
			}
			byte[] bs = new byte[len];
			byte[] buf = new byte[2048];
			int rlen = 0;
			int alen = 0;
			while ((rlen = in.read(buf)) > 0) {
				System.arraycopy(buf, 0, bs, alen, rlen);
				alen += rlen;
			}

			tude = new String(bs, 0, alen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return tude;
	}

	public static String getLoginString() {

		String re="<div id='login_dialog' class='mydiv' style='display:none;'>" +
		"<div class='menu01'>" +
"<a href='#' onmousedown='menu01(1)'><img src='images/bokmark01.gif' height='28'  border='0' id='m01_1' /></a>" +
"<a href='#' onmousedown='menu01(2)'><img src='images/bokmark02b.gif' height='28'  border='0' id='m01_2' /></a><a href='javascript:closeDiv()'  color:#FFFFFF;'><img src='images/xxx.gif' style='margin-left: 70px; margin-top:-7px;border:0;'/></a></div>" +
"<div class='menu0_more'>" +
"<div class='menu02and3 left'>" +
"<div class='menu02'>" +
"<div id='menu02_1'>" +
"<form name='f2' action='membercompany!login.action' method='post'>" +
"<div style='margin-top: 20px;'>用户名：<input id='username' name='member.username' type='text' style='width: 100px;'  /></div>" +
"<div style='margin-top: 14px;'>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input id='password' name='member.password' type='password' style='width: 100px;'  /></div>" +
"<div>验证码：<input id='validateImg' name='validateImg' type='text' size='6' align='bottom' /> <img vertical-align='middle' src='validate' height='20' style='padding-top: 5px;' alt='' id='checkvalidate1' onclick='javascript:document.getElementById(\"checkvalidate1\").src=\"validate?timetramp=\" + new Date().getTime()'/></div>" +
"<span id='confirm' class='hong12'>&nbsp;</span>" +
"<div style='margin-top: 10px; text-align: center;'>" +
"<input name='submit' type='button' class='butt55' style='margin-left:70px;' value='' onclick='login()' style='cursor: pointer;' />" +
"<input name='submit' type='button' class='butt155' value='' onclick='zhuce()' style='cursor: pointer;' /></div>" +
"</form>" +
"</div>" +
"<div id='menu02_2' style='display: none; margin:0; padding:0; width:100%' >" +
"<div style='margin-top: 60px;'>选择CA证书：<select name='s_title2' class=''>" +
"<option value='2' selected='selected'> </option>" +
"<option value='1' ></option>" +
"</select>" +
"</div>" +
"<div style='margin-top: 14px;'>证书密码：<input   type='password' style='width: 100px;' />" +
"</div>" +

"<div style='margin-top: 30px; width:100%; text-align: center;'>" +
"<input name='submit' type='button' class='butt55' style='margin-left:80px; padding:0;' value=''  style='cursor: pointer;' />" +
"</div>" +
"</div></div></div></div></div></div>" +
"<div id='bg' class='bg' style='display:none;overflow-y:hidden; height:100%; '><iframe style='width:100%; height:100%;z-index:3;'></iframe></div>";
		return re;
	}

	public static String getWeatherString(String cityname) {
		/*
		String weath = "";
		String url = "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="
				+ cityname + "&theUserID=";

		InputStream in = null;
		try {
			URL Url = new URL(url);
			URLConnection connection = (URLConnection) Url.openConnection();
			in = connection.getInputStream();
			int len = connection.getContentLength();
			if (len < 0) {
				len = 20480;
			}
			byte[] bs = new byte[len];
			byte[] buf = new byte[2048];
			int rlen = 0;
			int alen = 0;
			while ((rlen = in.read(buf)) > 0) {
				System.arraycopy(buf, 0, bs, alen, rlen);
				alen += rlen;
			}

			String str = new String(bs, 0, alen, "UTF-8");

			if (str != null && str.length() > 0) {
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();

				DocumentBuilder builder = factory.newDocumentBuilder();
				org.w3c.dom.Document document = builder
						.parse(new ByteArrayInputStream(str.getBytes("UTF-8")));
				NodeList nodelist = document.getElementsByTagName("string");


				//				
				//	
				if (nodelist.getLength() > 12) {
					Node child = nodelist.item(10);

					weath += "<div class='f fangshi_3'><img src='images/weather/"
							+ child.getFirstChild().getNodeValue()
							+ "' width='30' height='22' /></div>\r\n";
					child = nodelist.item(8);

					weath += "<div class='f huang12'> "
							+ child.getFirstChild().getNodeValue() + " ";
					child = nodelist.item(7);
					weath += child.getFirstChild().getNodeValue();
					child = nodelist.item(9);
					weath += " " + child.getFirstChild().getNodeValue()
							+ "</div>\r\n";

				} else {

					weath = "<div class='f fangshi_3'></div>"
							+ "<div class='f huang12'></div>";
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
		return "<div class='f fangshi_3'></div>"
		+ "<div class='f huang12'></div>";

	}

	public static void main(String[] args) {

		System.out.println(WebSite.getTude("杭州华侨城洲际酒店"));

	}
}
