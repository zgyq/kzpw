package com.yf.system.base.servicecenter;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.train.Train;
import com.yf.system.base.triporder.Triporder;
import com.sun.jmx.snmp.Timestamp;



public class ServicecenterManager extends  SqlMapClientDaoSupport implements IServicecenterManager{
	
	private  Random random ;
	
	public ServicecenterManager() {
		random = new Random(System.currentTimeMillis());
	}
	
	//礼品定单流水序列
	private final String GIFTORDERSEQ = "giftcodeseq";
	
	//礼品任务单流水序列
	private final String GIFTTASKORDERSEQ="gifttaskorderseq";

	
	
	/**
	 * 取数字随机码
	 * @return
	 */
	public String getRandString(int len){
		
		
		int num = random.nextInt((int)Math.pow(10,len));
		
		StringBuffer code =  new StringBuffer(len);
		for(int i=0;i<len ;i++){
			code.append('0');
		}
		String snum = (""+num);
		int slen = snum.length();
		if(slen>len){
			snum = snum.substring(0,len);
		}
		code.replace(len-snum.length(),len,snum);
		
		return code.toString();
		
	}
	
	/**
	 * 数字转成字符串
	 * @param num
	 * @param len
	 * @return
	 */
	public String getNumString(long num,int len){
		StringBuffer code =  new StringBuffer(len);
		for(int i=0;i<len ;i++){
			code.append('0');
		}
		String snum = (""+num);
		int slen = snum.length();
		if(slen>len){
			snum = snum.substring(0,len);
		}
		code.replace(len-snum.length(),len,snum);
		
		return code.toString();
	}
	
	
	/*
	 * 当前年月日
	 * @return
	 */
	private String getDateString(){
		try {
			return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
			
		} catch (Exception e) {
			return "000000";
		}
		
	}
	
	/*
	 * 当前年月日时
	 * @return
	 */
	private String getDateHourString(){
		try {
			return (new SimpleDateFormat("yyyyMMddHH").format(new Date()));
			
		} catch (Exception e) {
			return "000000";
		}
		
	}	
	
	
	
	
	
	
	
	
	public String getString2I(String str){
		if(str!=null){
			try {
				return new String(str.getBytes("GBK"),"ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return str;
			}
		}
		return str;
	}
	
	public String getStringI2(String str){
		if(str!=null){
			try {
				return new String(str.getBytes("ISO8859-1"),"GBK");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return str;
			}
		}
		return str;
	}
	/**
	 * 取得汉字拼音
	 */
	public  String getPYString(String str) {
		StringBuffer tempStr = new StringBuffer();
		int len = str.length();
		char c;
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if ((int) c >= 32 && (int) c <= 126) {// 字母和符号原样保留
				if((int) c >= 97 && (int) c <= 122||(int) c >= 65 && (int) c <= 90)
				{
					tempStr.append(c);
				}
			}
			else {
				tempStr.append(getPYChar(c));
			}
		}
		return tempStr.toString().toLowerCase();

	}

	private  String getPYChar(char c) {
		byte[] array = new byte[2];
		array = String.valueOf(c).getBytes();
		int i = (short) (array[0] + 256) * 256 + ((short) (array[1]) + 256);
		if (i < 0xB0A1)
			return "";
		if (i < 0xB0C5)
			return "a";
		if (i < 0xB2C1)
			return "b";
		if (i < 0xB4EE)
			return "c";
		if (i < 0xB6EA)
			return "d";
		if (i < 0xB7A2)
			return "e";
		if (i < 0xB8C1)
			return "f";
		if (i < 0xB9FE)
			return "g";
		if (i < 0xBBF7)
			return "h";
		if (i < 0xBFA6)
			return "j";
		if (i < 0xC0AC)
			return "k";
		if (i < 0xC2E8)
			return "l";
		if (i < 0xC4C3)
			return "m";
		if (i < 0xC5B6)
			return "n";
		if (i < 0xC5BE)
			return "o";
		if (i < 0xC6DA)
			return "p";
		if (i < 0xC8BB)
			return "q";
		if (i < 0xC8F6)
			return "r";
		if (i < 0xCBFA)
			return "s";
		if (i < 0xCDDA)
			return "t";
		if (i < 0xCEF4)
			return "w";
		if (i < 0xD1B9)
			return "x";
		if (i < 0xD4D1)
			return "y";
		if (i < 0xD7FA)
			return "z";
		/*return "_";*/
		return "";
	}

	/**
	 * 获取机票订单编号
	 */
	public String getOrderinfoCode(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+orderinfo.getId()).length(),6,(""+orderinfo.getId()));
//		code.insert(0,this.getDateString());
		
		return "A"+(orderinfo.getId()+10000);
	}
	/**
	 * 获取充值订单编号P
	 */
	public String getRechargeCode(Recharge recharge) {
		// TODO Auto-generated method stub
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+orderinfo.getId()).length(),6,(""+orderinfo.getId()));
//		code.insert(0,this.getDateString());
		
		return "P"+(recharge.getId()+10000);
	}
	/**
	 * 国际机票订单代码 
	 * @param triporder
	 * @return
	 */
	public String getInterTicketCode(Forderinfo forderinfo) {
		// TODO Auto-generated method stub
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+forderinfo.getId()).length(),6,(""+forderinfo.getId()));
//		code.insert(0,this.getDateString());
		
		return "F"+(forderinfo.getId()+10000);
	}
	
	/**
	 * 酒店订单代码 
	 * @param hotelorder
	 * @return
	 */
	public String getHotelorderCode(Hotelorder hotelorder){
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+hotelorder.getId()).length(),6,(""+hotelorder.getId()));
//		code.insert(0,this.getDateString());
		
		return getDateString()+(getNumString(hotelorder.getId(),7))+"W";
	}
	
	/**
	 * 旅游订单代码 
	 * @param triporder
	 * @return
	 */
	public String getTriporderCode(Triporder triporder){
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+triporder.getId()).length(),6,(""+triporder.getId()));
//		code.insert(0,this.getDateString());
		return "T"+(triporder.getId());
	}
	

	/**
	 * 租车订单代码 
	 * @param triporder
	 * @return
	 */
	public String getCarorderCode(Carorder carorder){
//		StringBuffer code = new StringBuffer("000000");
//		code.replace(6-(""+triporder.getId()).length(),6,(""+triporder.getId()));
//		code.insert(0,this.getDateString());
		return "C"+(carorder.getId()+10000);
	}

	@Override
	public String getQmoneyRechargeCode(Qmoneyrecharge qrecharge) {
	
		return "Q"+(qrecharge.getId()+10000);
	}

	@Override
	public String getTrainCode(Train Train) {
		DateFormat dformat=new SimpleDateFormat("yyyyMMdd");
		String time=dformat.format(new Date());
		
		return time+"-"+(Train.getId()+10000);
	}
	
	
}
