
package com.yf.system.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class Util {
	private final static String volichar ="1234567890_-#()[]abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static Map mimeTypeMap=new HashMap();
    static {
    	mimeTypeMap.put("abs", "audio/x-mpeg");    
    	mimeTypeMap.put("ai", "application/postscript");    
    	mimeTypeMap.put("aif", "audio/x-aiff");    
    	mimeTypeMap.put("aifc", "audio/x-aiff");    
    	mimeTypeMap.put("aiff", "audio/x-aiff");    
    	mimeTypeMap.put("aim", "application/x-aim");    
    	mimeTypeMap.put("art", "image/x-jg");    
    	mimeTypeMap.put("asf", "video/x-ms-asf");    
    	mimeTypeMap.put("asx", "video/x-ms-asf");    
    	mimeTypeMap.put("au", "audio/basic");    
    	mimeTypeMap.put("avi", "video/x-msvideo");    
    	mimeTypeMap.put("avx", "video/x-rad-screenplay");    
    	mimeTypeMap.put("bcpio", "application/x-bcpio");    
    	mimeTypeMap.put("bin", "application/octet-stream");    
    	mimeTypeMap.put("bmp", "image/bmp");    
    	mimeTypeMap.put("body", "text/html");    
    	mimeTypeMap.put("cdf", "application/x-cdf");    
    	mimeTypeMap.put("cer", "application/x-x509-ca-cert");    
    	mimeTypeMap.put("class", "application/java");    
    	mimeTypeMap.put("cpio", "application/x-cpio");    
    	mimeTypeMap.put("csh", "application/x-csh");    
    	mimeTypeMap.put("css", "text/css");    
    	mimeTypeMap.put("dib", "image/bmp");    
    	mimeTypeMap.put("doc", "application/msword");    
    	mimeTypeMap.put("dtd", "text/plain");    
    	mimeTypeMap.put("dv", "video/x-dv");    
    	mimeTypeMap.put("dvi", "application/x-dvi");    
    	mimeTypeMap.put("eps", "application/postscript");    
    	mimeTypeMap.put("etx", "text/x-setext");    
    	mimeTypeMap.put("exe", "application/octet-stream");    
    	mimeTypeMap.put("gif", "image/gif");    
    	mimeTypeMap.put("gtar", "application/x-gtar");    
    	mimeTypeMap.put("gz", "application/x-gzip");    
    	mimeTypeMap.put("hdf", "application/x-hdf");    
    	mimeTypeMap.put("hqx", "application/mac-binhex40");    
    	mimeTypeMap.put("htc", "text/x-component");    
    	mimeTypeMap.put("htm", "text/html");    
    	mimeTypeMap.put("html", "text/html");    
    	mimeTypeMap.put("hqx", "application/mac-binhex40");    
    	mimeTypeMap.put("ief", "image/ief");    
    	mimeTypeMap.put("jad", "text/vnd.sun.j2me.app-descriptor");    
    	mimeTypeMap.put("jar", "application/java-archive");    
    	mimeTypeMap.put("java", "text/plain");    
    	mimeTypeMap.put("jnlp", "application/x-java-jnlp-file");    
    	mimeTypeMap.put("jpe", "image/jpeg");    
    	mimeTypeMap.put("jpeg", "image/jpeg");    
    	mimeTypeMap.put("jpg", "image/jpeg");    
    	mimeTypeMap.put("js", "text/javascript");    
    	mimeTypeMap.put("jsf", "text/plain");    
    	mimeTypeMap.put("jspf", "text/plain");    
    	mimeTypeMap.put("kar", "audio/x-midi");    
    	mimeTypeMap.put("latex", "application/x-latex");    
    	mimeTypeMap.put("m3u", "audio/x-mpegurl");    
    	mimeTypeMap.put("mac", "image/x-macpaint");    
    	mimeTypeMap.put("man", "application/x-troff-man");    
    	mimeTypeMap.put("me", "application/x-troff-me");    
    	mimeTypeMap.put("mid", "audio/x-midi");    
    	mimeTypeMap.put("midi", "audio/x-midi");    
    	mimeTypeMap.put("mif", "application/x-mif");    
    	mimeTypeMap.put("mov", "video/quicktime");    
    	mimeTypeMap.put("movie", "video/x-sgi-movie");    
    	mimeTypeMap.put("mp1", "audio/x-mpeg");    
    	mimeTypeMap.put("mp2", "audio/x-mpeg");    
    	mimeTypeMap.put("mp3", "audio/mp3");    
    	mimeTypeMap.put("mpa", "audio/x-mpeg");    
    	mimeTypeMap.put("mpe", "video/mpeg");    
    	mimeTypeMap.put("mpeg", "video/mpeg");    
    	mimeTypeMap.put("mpega", "audio/x-mpeg");    
    	mimeTypeMap.put("mpg", "video/mpeg");    
    	mimeTypeMap.put("mpv2", "video/mpeg2");    
    	mimeTypeMap.put("ms", "application/x-wais-source");    
    	mimeTypeMap.put("nc", "application/x-netcdf");    
    	mimeTypeMap.put("oda", "application/oda");    
    	mimeTypeMap.put("pbm", "image/x-portable-bitmap");    
    	mimeTypeMap.put("pct", "image/pict");    
    	mimeTypeMap.put("pdf", "application/pdf");    
    	mimeTypeMap.put("pgm", "image/x-portable-graymap");    
    	mimeTypeMap.put("pic", "image/pict");    
    	mimeTypeMap.put("pict", "image/pict");    
    	mimeTypeMap.put("pls", "audio/x-scpls");    
    	mimeTypeMap.put("png", "image/png");    
    	mimeTypeMap.put("pnm", "image/x-portable-anymap");    
    	mimeTypeMap.put("pnt", "image/x-macpaint");    
    	mimeTypeMap.put("ppm", "image/x-portable-pixmap");    
    	mimeTypeMap.put("ps", "application/postscript");    
    	mimeTypeMap.put("psd", "image/x-photoshop");    
    	mimeTypeMap.put("qt", "video/quicktime");    
    	mimeTypeMap.put("qti", "image/x-quicktime");    
    	mimeTypeMap.put("qtif", "image/x-quicktime");    
    	mimeTypeMap.put("ras", "image/x-cmu-raster");    
    	mimeTypeMap.put("rgb", "image/x-rgb");    
    	mimeTypeMap.put("rm", "application/vnd.rn-realmedia");    
    	mimeTypeMap.put("roff", "application/x-troff");    
    	mimeTypeMap.put("rtf", "application/rtf");    
    	mimeTypeMap.put("rtx", "text/richtext");    
    	mimeTypeMap.put("sh", "application/x-sh");    
    	mimeTypeMap.put("shar", "application/x-shar");    
    	mimeTypeMap.put("smf", "audio/x-midi");    
    	mimeTypeMap.put("sit", "application/x-stuffit");    
    	mimeTypeMap.put("snd", "audio/basic");    
    	mimeTypeMap.put("src", "application/x-wais-source");    
    	mimeTypeMap.put("sv4cpio", "application/x-sv4cpio");    
    	mimeTypeMap.put("sv4crc", "application/x-sv4crc");    
    	mimeTypeMap.put("swf", "application/x-shockwave-flash");    
    	mimeTypeMap.put("t", "application/x-troff");    
    	mimeTypeMap.put("tar", "application/x-tar");    
    	mimeTypeMap.put("tcl", "application/x-tcl");    
    	mimeTypeMap.put("tex", "application/x-tex");    
    	mimeTypeMap.put("texi", "application/x-texinfo");    
    	mimeTypeMap.put("texinfo", "application/x-texinfo");    
    	mimeTypeMap.put("tif", "image/tiff");    
    	mimeTypeMap.put("tiff", "image/tiff");    	    	    
    	mimeTypeMap.put("tr", "application/x-troff");    	    	    
    	mimeTypeMap.put("tsv", "text/tab-separated-values");    	    	    
    	mimeTypeMap.put("txt", "text/plain");    	    	    
    	mimeTypeMap.put("ulw", "audio/basic");    	    	    
    	mimeTypeMap.put("ustar", "application/x-ustar");        	    
    	mimeTypeMap.put("xbm", "image/x-xbitmap");        	    
    	mimeTypeMap.put("xml", "text/xml");    	    	    
    	mimeTypeMap.put("xpm", "image/x-xpixmap");    	    	    
    	mimeTypeMap.put("xsl", "text/xml");        	    
    	mimeTypeMap.put("xwd", "image/x-xwindowdump");        	    
    	mimeTypeMap.put("wav", "audio/x-wav");    
    	mimeTypeMap.put("wmv", "video/x-ms-wmv");        	 
    	mimeTypeMap.put("svg", "image/svg+xml");    	    	    
    	mimeTypeMap.put("svgz", "image/svg+xml");    	    	    
    	mimeTypeMap.put("wbmp", "image/vnd.wap.wbmp");    	    	    
    	mimeTypeMap.put("wml", "text/vnd.wap.wml");    	    	    
    	mimeTypeMap.put("wmlc", "application/vnd.wap.wmlc");        	    
    	mimeTypeMap.put("wmls", "text/vnd.wap.wmlscript");    	    	    
    	mimeTypeMap.put("wmlscriptc", "application/vnd.wap.wmlscriptc");        	    
    	mimeTypeMap.put("wrl", "x-world/x-vrml");    	    	    
    	mimeTypeMap.put("Z", "application/x-compress");    	    	    
    	mimeTypeMap.put("z", "application/x-compress");    	    	    
    	mimeTypeMap.put("zip", "application/zip");
    	mimeTypeMap.put("3gp", "video/3gpp");
    	mimeTypeMap.put("sis", "application/vnd.symbian.install");
    	mimeTypeMap.put("csl", "application/octet-stream");
     	
    }	

   /**
    * 取得文件扩展名
    * @param fileName
    * @return
    */ 
   
    public static String getExtension(String fileName) {
    	
		int newEnd = fileName.length();
		int i = fileName.lastIndexOf('.', newEnd);
		if (i != -1) {
			return fileName.substring(i + 1, newEnd);
		} else {
			return null;
		}
	}
    
    /**
     * 去掉文件扩展名
     * @param fileName
     * @return
     */ 
    
     public static String getNoExtension(String fileName) {
 		int newEnd = fileName.length();

 		int i = fileName.lastIndexOf('.', newEnd);
 		if (i != -1) {
 			return fileName.substring(0, i);
 		} else {
 			return fileName;
 		}
 	}
     
	/**
	 * 通过文件扩展名获得MimeType
	 * 
	 * @param fileExt
	 * @return
	 */
	public static String getMimeTypeByFileExtName(String fileExt){
		return (String)mimeTypeMap.get(fileExt.toLowerCase().trim());
	}

	/**
	 * 通过文件名获得MimeType
	 * @param filename
	 * @return
	 */
	public static String getMimeTypeByFileName(String filename){
		String fileExt = getExtension(filename);
		if(fileExt==null)return null;
		String re = (String)mimeTypeMap.get(fileExt.toLowerCase().trim());
		if(re==null){
			re = HttpURLConnection.guessContentTypeFromName(fileExt.toLowerCase().trim());
		}
		return re;
	}

	
	/**
	 * 拷贝文件
	 * @param filesrc  源文件
	 * @param filedesc 目标文件
	 * @return 拷贝的字节数
	 */
	public static int copyfile(File filesrc, File filedesc) {
		int len = 0;

		InputStream in=null;
		OutputStream out=null;
		try {
			in = new FileInputStream(filesrc);
			out = new FileOutputStream(filedesc);
			byte[] t = new byte[1024];
			int ii=0;
			while((ii=in.read(t))>0){
				out.write(t,0,ii);
				len+=ii;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(out!=null){
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		return len;
	}
	
	public static String getFilename(String filename){
		
		String ext = getExtension(filename);
		String name = getNoExtension(filename);
		int len= name.length();
		for(int i=0; i< len; i++){
			if((volichar.indexOf(name.charAt(i)))<0){
				name="";
				break;
			}
		}
		long re = -1;
		try {
//			re = DBTools.getID("cindafilename");
		} catch (Exception e) {
			re = System.currentTimeMillis()+(long)(1/Math.random());
		}
		if(re<=0){
			re = System.currentTimeMillis()+(long)(1/Math.random());
		}
		if(ext==null||ext.length()==0){
			return name+"_"+re;
		}else{
			return name+"_"+re+"."+ext;
		}
	}
	
	
	public static String getNewFilename(String filename){
		
		String ext = getExtension(filename);
		
		long re = -1;
		try {
//			re = DBTools.getID("cindafilename");
		} catch (Exception e) {
			re = System.currentTimeMillis()+(long)(1/Math.random());
		}
		if(re<=0){
			re = System.currentTimeMillis()+(long)(1/Math.random());
		}
		if(ext==null||ext.length()==0){
			return ""+re;
		}else{
			return re+"."+ext;
		}
	}
	/**
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	
	public static String MD5(String input) throws NoSuchAlgorithmException{
		if(input==null || input.length()==0)
			return "";
		
		String out="";
		byte[] output;
		MessageDigest m = MessageDigest.getInstance("MD5");
		output = m.digest(input.getBytes());
		int len = output.length;

		for(int i=0; i< len; i++){
			
			String t =Integer.toHexString(output[i]& 0x00FF);
		
			out+= (t.length()==1)?("0"+t):t ;
		
		}
		
		return out;
	}
	/**
	 * 
	 * @param srcpasswd  未加密
	 * @param datapasswd 加密后
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static boolean isEquel(String srcpasswd,String datapasswd) throws NoSuchAlgorithmException{
		String tmp = MD5(srcpasswd);
		return tmp.equalsIgnoreCase(datapasswd);
	}
	/**
	 * 验证文件正确性
	 * @param file
	 * @param exts
	 * @throws Exception
	 */
	public static void valadatefile(File file,String[] exts)throws Exception{
		
		if(file!=null){
			String ext = Util.getExtension(file.getName());
			if(ext==null){
				throw new Exception("无法识别的文件类型:"+file.getName());
			}
			if(exts!=null && exts.length>0){
				boolean flag=false;
				for (int i = 0; i < exts.length; i++) {
					
					if(ext.equalsIgnoreCase(exts[i])){
						flag=true;
						break;
					}
				}
				
				if(!flag){
					throw new Exception("你上传了错误的文件类型:"+file.getName());
				}
			}
			
		}
	
	}
	/**
	 * 将文件内容转成字符串
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String filetoString(String filename) throws IOException{
		InputStream in=null;
		try {
			in = new FileInputStream(filename);
			byte[] b = new byte[in.available()];
			in.read(b);
			in.close();
			return new String(b);
		} catch (IOException e) {
			throw e;
		}finally{
			if(in!=null){
				in.close();
			}
		}
		
	}
	

	

}
