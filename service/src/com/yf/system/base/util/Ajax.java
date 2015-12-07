package com.yf.system.base.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应AJAX请求
 * 
 * @author KEJUN
 * @version 1.00
 */
public class Ajax {

	
	/**
	 * 根据List中所拥有的对象不同而进行转换
	 * @param list
	 * @return
	 * @throws Exception 
	 * @throws IdealException
	 */
	@SuppressWarnings("unchecked")
	public static String listToXML(List<?> list) throws Exception  {
		if(null==list || list.isEmpty())
			return "";
		Object o = list.get(0);
		if (o instanceof Map) {
			return listToMap((List<Map<?, ?>>)list);
		} else if (o instanceof List) {
			return listToList((List<List<?>>)list);
		} else if (o instanceof String) {
			return listToString((List<String>)list,"");
		} else {
			return listToBean(list);
		}
	}
	
	/**
	 * List<String>转换成XML
	 * @param list
	 * @return
	 * @
	 */
	public static String listToString(List<String> list ,String id)  {
		StringBuffer buf = new StringBuffer();
		if(null != id && !"".equals(id)){
			buf.append("<list id="+id+">\n");
		}else{
			buf.append("<list>\n");
		}
		for (String s : list) {
			buf.append(" <value>");
			buf.append(formatXML(s));
			buf.append("</value>\n");
		}
		buf.append("</list>\n");
		return buf.toString();
	}
	
	
	/**
	 * List中JAVABEAN转换成XML
	 * @param list
	 * @return
	 * @throws Exception 
	 * @
	 */
	public static String listToBean(List<?> list) throws Exception  {
		
		List<Map<String,String>> li = new ArrayList<Map<String,String>>();
		for (Object o : list) {
			li.add(poToMap(o));
		}
		String s = listToXML(li);
		return s;
	}
	
	/**
	 * List中MAP转换成XML
	 * @param list
	 * @return
	 * @throws Exception 
	 * @
	 */
	public static String listToMap(List<Map<?, ?>> list) throws Exception  {
		StringBuffer buf = new StringBuffer();
		buf.append("<list>\n");
		
		for (Map<?, ?> map : list) {
			buf.append(mapToXML(map));
			buf.append("\n");
		}
		buf.append("</list>");
		return buf.toString();
		
	}
	
	/**
	 * List中MAP转换成XML
	 * @param list
	 * @return
	 * @throws Exception 
	 * @
	 */
	public static String listToList(List<List<?>> list) throws Exception  {
		StringBuffer buf = new StringBuffer();
		buf.append("<list>\n");
		
		for (List<?> li : list) {
			buf.append(listToXML(li));
		}
		buf.append("</list>");
		return buf.toString();
		
	}
	
	
	
	/**
	 * 将LIST中JAVABEAN转换成List<Map<String,String>> 
	 * @param list
	 * @return
	 * @throws Exception 
	 * @
	 */
	public static List<Map<String,String>> listToPo(List<?> list) throws Exception {
		
		List<Map<String,String>> li = new ArrayList<Map<String,String>>();
		for (Object o : list) {
			li.add(poToMap(o));
		}
		return li;
	}
	

	
	
	
	/**
	 * 根据map中所拥有的对象不同而进行转换
	 * @param map
	 * @return
	 * @throws Exception 
	 * @
	 */
	@SuppressWarnings("unchecked")
	public static String mapToXML(Map<?,?> map) throws Exception  {

		StringBuffer buf = new StringBuffer();
		buf.append("<map>\n");

		for (Iterator i = map.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry) i.next();

			buf.append(entryToXML(entry));
			buf.append("\n");
		}

		buf.append("</map>");
		return buf.toString();
	}
	
	
	public static String entryToXML(Map.Entry entry) throws Exception  {
		
		StringBuffer buf = new StringBuffer();
		String id = (String) entry.getKey();
		buf.append("<entry id=\"");
		buf.append(id);
		buf.append("\">\n");
		
		Object o = entry.getValue();
		if(o == null) o = "null";
		
		if (o instanceof Map<?, ?>) {
			buf.append(mapToXML((Map<?, ?>)o));
		} else if (o instanceof List) {
			buf.append(listToXML((List<?>)o));
		}else if (o instanceof String) {
			buf.append(formatXML(o.toString()));
		}else {
			buf.append(mapToXML(poToMap(o)));
		}
		buf.append("\n</entry>");
		return buf.toString();
	}
	
	/**
	 * 将JAVABEAN转为Map 
	 * @param o
	 * @return
	 * @throws Exception 
	 */
	public static Map<String,String> poToMap(Object o) throws Exception  {
		
		Map<String,String> m = new HashMap<String, String>();
		BeanInfo info = Introspector.getBeanInfo(o.getClass());
		PropertyDescriptor descs[]=info.getPropertyDescriptors();
		for (int i=0; i<descs.length; i++){
		  String k  = descs[i].getName();
		  String v ="";
		  Object t = descs[i].getReadMethod().invoke(o);
		  if(t==null){
			  v = null;
		  }else if(t instanceof Number){
			  v = String.valueOf(t);
		  }else{
			  v = t.toString();
		  }
		  m.put(k, v);
		}
		return m;
	}

	/**
	 * 格式化
	 * 
	 * @param str
	 * @return
	 */
	private static String formatXML(String str) {
		if (str == null || str.length() == 0){
			return str;
		} else {
			String result = str;
			result = result.replaceAll("\\&", "&amp;");
			result = result.replaceAll("\\<", "&lt;");
			result = result.replaceAll("\\>", "&gt;");
			return result;
		}
	}

	/**
	 * AJAX响应
	 * 
	 * @param list
	 *            将要返回的数据
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public static void ajaxResponse(HttpServletResponse response, List<?> list) throws Exception {
		String xml = listToXML(list);
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xml);
		out.flush();
		out.close();
		
	}
	
	
	/**
	 * AJAX响应
	 * 
	 * @param list
	 *            将要返回的数据
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public static void ajaxResponse(HttpServletResponse response, Map<?,?> map) throws Exception {
		String xml = mapToXML(map);
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + xml);
		out.flush();
		out.close();
	}
	
	/**
	 * AJAX响应
	 * 
	 * @param list
	 *            将要返回的数据
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public static void ajaxResponse(HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}
	
	/**
	 * AJAX响应
	 * 
	 * @param list
	 *            将要返回的数据
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public static void ajaxResponse(HttpServletResponse response,String s)throws Exception {
		PrintWriter out = response.getWriter();
		out.write(s);
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		
	}

}
