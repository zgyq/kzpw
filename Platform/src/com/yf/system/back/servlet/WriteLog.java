package com.yf.system.back.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

public class WriteLog {

	

	public static void write(String fileNameHead,String logString) {

	try {

	String logFilePathName=null;

	Calendar cd = Calendar.getInstance();//

	int year=cd.get(Calendar.YEAR);

	String month=addZero(cd.get(Calendar.MONTH)+1);

	String day=addZero(cd.get(Calendar.DAY_OF_MONTH));

	String hour=addZero(cd.get(Calendar.HOUR_OF_DAY));

	String min=addZero(cd.get(Calendar.MINUTE));

	String sec=addZero(cd.get(Calendar.SECOND));

	 

	 String pathurl="C:/userlog/"+year+"-"+month+"-"+day+"/";

	File fileParentDir=new File(pathurl);//

	if (!fileParentDir.exists()) {

	fileParentDir.mkdir();

	}

	if (fileNameHead==null||fileNameHead.equals("")) {

	logFilePathName="C:/userlog/"+year+month+day+".log";//

	}else {

	logFilePathName=pathurl+fileNameHead+year+month+day+".log";//

	}

	 

	PrintWriter printWriter=new PrintWriter(new FileOutputStream(logFilePathName, true));//

	String time="["+year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec+"] ";

	printWriter.println(time+logString);

	printWriter.flush();

	 

	} catch (FileNotFoundException e) {

	// TODO Auto-generated catch block

	e.getMessage();

	}

	}

	 

	
	public static String addZero(int i) {

	if (i<10) {

	String tmpString="0"+i;

	return tmpString;

	}

	else {

	return String.valueOf(i);

	}  

	}

	public static void main(String[] args) {

	 

	
	write("121212", "4444");

	write("ok", "111");

	}

	}

