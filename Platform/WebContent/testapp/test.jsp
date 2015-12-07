<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
public int load(String path){
 BufferedReader buf;
 int temp=0;
 try{
 File f=new File(path);
 buf=new BufferedReader(new InputStreamReader(new FileInputStream(f)));
 String str=buf.readLine();
 temp=Integer.parseInt(str);
 buf.close();
 }catch(Exception e){
  e.fillInStackTrace();
  
 }
 return temp;
}

public synchronized void save(int c,String path){
File f=new File(path);
try{
PrintStream ps=new PrintStream(new FileOutputStream(f));
ps.print(c);
ps.close();
}catch(Exception e){
 e.fillInStackTrace();
}
}
%>
<%String path=getServletContext().getRealPath("/")+"content.txt";
int count=load(path);
%>
<%
if(session.isNew()){
 save(++count,path);
 
}

%>


</body>
</html>