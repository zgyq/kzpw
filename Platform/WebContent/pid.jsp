<%System.out.println(request.getQueryString());
response.setCharacterEncoding("UTF-8");
String cmd = request.getParameter("cmd");
String retStr ="";
System.out.println(cmd);
try {
	String url = "http://113.140.79.13:18888/api.jspx?cmd="+cmd; 
	java.net.URL Url = new java.net.URL(url);
	java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();
	
	conn.setDoInput(true);
	conn.connect();
	
	java.io.InputStream in = conn.getInputStream();
	org.jdom.input.SAXBuilder build = new org.jdom.input.SAXBuilder();
	org.jdom.Document doc = build.build(in);
	org.jdom.Element data = doc.getRootElement();
	org.jdom.Element cmdlist = data.getChild("CMDLIST");
	String status = cmdlist.getChildTextTrim("STATS");
	
	if(status.equals("1")){
		retStr = cmdlist.getChildTextTrim("RESPONSE");
		if(retStr.indexOf(">")>0)
		{
		   retStr=retStr.replace(">","\r\n >");
		}
		
	}else{
		retStr = cmdlist.getChildTextTrim("MESSAGE");
	}
	System.out.println(retStr);
	in.close();
	
	conn.disconnect();
	
	
	
	retStr="<br/><pre>" +retStr.replaceAll(new String(new byte[]{0x20,0x62,0x0D}),new String(new byte[]{0x0D})).replaceAll(new String(new byte[]{0x20,0x0D}),"\r") +"</pre><br/>"; 
	//retStr = "<br/>"+retStr.replaceAll("\r","<br/>").replaceAll("\n","<br/>")+"<br/>";
	//retStr = retStr.replaceAll("\t","&nbsp;&nbsp;&nbsp;&nbsp;");
} catch (Exception e) {
	e.printStackTrace();
}
%><%=retStr%>



