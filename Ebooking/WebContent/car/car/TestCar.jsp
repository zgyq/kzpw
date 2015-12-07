<%@page import="java.io.Writer"%>
<%@page import="com.opensymphony.webwork.ServletActionContext"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%


String CarType = request.getParameter("CarType");//车类型

CarType=new String(CarType.getBytes("ISO-8859-1"),"UTF-8");

String CarInfo = request.getParameter("CarInfo");//车详细信息
CarInfo=new String(CarInfo.getBytes("ISO-8859-1"),"UTF-8");


String yujinian = request.getParameter("yujinian");//预计购车年
String yujiyue = request.getParameter("yujiyue");//预计购车月
String yujiri = request.getParameter("yujiri");//预计购车日

String yusuan = request.getParameter("yusuan");//购车预算

yusuan=new String(yusuan.getBytes("ISO-8859-1"),"UTF-8");

String NameTxt = request.getParameter("NameTxt");//姓名
NameTxt=new String(NameTxt.getBytes("ISO-8859-1"),"UTF-8");
String PassSex = request.getParameter("PassSex");//性别
String Tel = request.getParameter("Tel");//手机号
String MailTxt = request.getParameter("MailTxt");//邮箱

String HidSen = request.getParameter("HidSen");//省份
HidSen=new String(HidSen.getBytes("ISO-8859-1"),"UTF-8");
String HidCity = request.getParameter("HidCity");//市区
HidCity=new String(HidCity.getBytes("ISO-8859-1"),"UTF-8");


String IsHaveCra = request.getParameter("IsHaveCra");//是否已经拥有车  1拥有  0不拥有
String goumainian = "";//购买年
String goumaiyue = "";//购买月
String goumairi = "";//购买日
String nianyueri="";//购买年月日
if(IsHaveCra.equals("1")){
 goumainian = request.getParameter("goumainian");//购买年
 goumaiyue = request.getParameter("goumaiyue");//购买月
 goumairi = request.getParameter("goumairi");//购买日
  nianyueri=goumainian+"-"+goumaiyue+"-"+goumairi;
}

String datas="";
 

//以下为页面接受到数值
datas="";//初始化
datas+="{";
datas+="\"data-source\":\"dealer-network\",";
datas+="\"data-campaign\":\"qwqw.com.cn\",";
datas+="\"car-type\":\""+CarType+"\",";
datas+="\"car-model\":\""+CarInfo+"\",";
datas+="\"intended-purchase-date\":\""+yujinian+"-"+yujiyue+"-"+yujiri+"\",";
datas+="\"intended-budget\":\""+yusuan+"\",";
datas+="\"intended-dealer-province\":\""+HidSen+"\",";
datas+="\"intended-dealer-city\":\""+HidCity+"\",";
datas+="\"intended-dealer-name\":\"北京得万隆经贸有限公司\",";
datas+="\"customer-name\":\""+NameTxt+"\",";
datas+="\"customer-gender\":\""+PassSex+"\",";
datas+="\"customer-mobile\":\""+Tel+"\",";
datas+="\"customer-email\":\""+MailTxt+"\",";
datas+="\"customer-location-province\":\""+HidSen+"\",";
datas+="\"customer-location-city\":\""+HidCity+"\",";
	    		  					 
datas+="\"possessed-car\":\""+IsHaveCra+"\",";
datas+="\"possessed-car-purchase-date\":\""+nianyueri+"\",";
datas+="\"possessed-car-brand\":\"Aston Martin\",";//品牌
datas+="\"possessed-car-type\":\"DB4\",";//车型
datas+="\"sign-up-for-newsletter\":\"1\",";
datas+="\"sign-up-for-brochure\":\"1\"";
datas+="}";	



	  
		System.out.println(datas);
		String ret="-1";
			try {
				URL u = null;
				HttpURLConnection con = null;
				//构建请求参数
				StringBuffer sb = new StringBuffer();
				sb.append(datas.toString());
				//尝试发送请求
				try {
				u = new URL("http://ja-dev-jdxforms.dmgmedia.com/jdxapi/input/testdrive");
				con = (HttpURLConnection) u.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setDoInput(true);
				con.setUseCaches(false);
				con.setRequestProperty("Content-Type", "text/xml");
				OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
				osw.write(sb.toString());
				osw.flush();
				osw.close();
				} catch (Exception e) {
				e.printStackTrace();
				} finally {
				if (con != null) {
				con.disconnect();
				}
				}
				//读取返回内容
				StringBuffer buffer = new StringBuffer();
				try {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String temp;
				while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				//out.print(new String(buffer.toString().getBytes(),"UTF-8"));
				ret=new String(buffer.toString().getBytes(),"UTF-8");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				response.setContentType("text/plain; charset=utf-8");
				Writer writer = response.getWriter();
				writer.write(ret.toString());
				writer.flush();
				writer.close();
%>
