package com.yf.website.web.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.caucho.services.server.ServiceContext;
import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.atom.component.WriteLog;

public class IpUtil {
	public String GetIpByAdders(){
		
		String RemoteAddrIP="";
		//RemoteAddrIP=ServiceContext.getContextRequest().getRemoteAddr();
		
		if (ServletActionContext.getRequest().getHeader("x-forwarded-for") == null) {  
			RemoteAddrIP= ServletActionContext.getRequest().getRemoteAddr();  
	    }
		//System.out.println();
		return RemoteAddrIP;
	}
	
	public String GetAddersByIP(String ip){
		
		String urltemp="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=115.156.238.114";
		
		URL url;
		System.out.println("urltemp=="+urltemp);
		WriteLog.write("解析IP地址", urltemp);
		String sTotalString="";  
		try {
			url = new URL(urltemp);
			URLConnection connection = url.openConnection();  
			connection.setDoOutput(true);  
		    String sCurrentLine;  
		    
		    sCurrentLine = "";  
		    sTotalString = "";  
		    InputStream l_urlStream;  
		    l_urlStream = connection.getInputStream();  
		    BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream,"utf-8"));  
		    while ((sCurrentLine = l_reader.readLine()) != null) {  
		    sTotalString += sCurrentLine;  
		    }
		    WriteLog.write("解析IP地址返回", sTotalString);
		    if(sTotalString!=null&&sTotalString.trim().length()>0){
				
					System.out.println(sTotalString);
				
					sTotalString=sTotalString.replace("var remote_ip_info =", "");
					//System.out.println("["+sTotalString+"]");
					JSONArray jsonObject = new JSONArray("["+sTotalString+"]");
					JSONObject josnobj = (JSONObject) jsonObject.get(0);
					String ret="-1";
					ret=josnobj.getString("ret");//
					if(!ret.equals("-1")){
						String start=josnobj.getString("start");//开始号段
						String end=josnobj.getString("end");//结束号段
						String country=josnobj.getString("country");//国家
						String province=josnobj.getString("province");//省份
						String city=josnobj.getString("city");//城市
						String isp=josnobj.getString("isp");//isp
						String type=josnobj.getString("type");//type
						String desc=josnobj.getString("desc");//desc
						System.out.println(start+","+end);
						System.out.println(country+","+province+","+city);
						System.out.println(isp+","+type+","+desc);
						
						WriteLog.write("解析IP地址后完整参数", "IP:"+ip+",国家:"+country+",省份:"+province+",城市:"+city+",详细信息:"+desc);
					}else{
						System.out.println("IP错误,解析失败");
						WriteLog.write("解析IP地址错误","URL:"+urltemp+",返回:"+sTotalString);
						
					}
					
					
					
			}
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return "";
	}
	
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IpUtil ipUtil=new IpUtil();
		//ipUtil.GetIpByAdders();
		
		ipUtil.GetAddersByIP("");
		
		
		
	}

}
