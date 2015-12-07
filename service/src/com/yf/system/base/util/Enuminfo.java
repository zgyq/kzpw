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
import java.util.EnumSet;  

/**
 * 枚举类
 * 
 * @author 
 * @version 1.00
 */
public class Enuminfo {

	public enum SendTicketEnum
	{   
		PIAODAOFUKUAN("票到付款",1),   
		MENSHIZIQU("门市自取",2),   
		JICHANGQUPIAO("机场取票",3);   
		//枚举类的字段或属性必须定义在枚举常量的后面   
		private String value;   
		private int id;   
		//默认是private型   
		SendTicketEnum(String value,int id)
		{      
			this.value=value;   
			this.id=id;   
		}   
		public String getValue() 
		{   
		   return value;   
		}   
		public int getId() 
		{   
		   return id;   
		}   
	}   
	
		public static void main(String []args)
		{   
	        for(SendTicketEnum sendticket:EnumSet.allOf(SendTicketEnum.class))
	        {   
	            System.out.println("送票方式名称："+sendticket.getValue());   
	            System.out.println("送票方式ID："+sendticket.getId());
	            System.out.println(Enum.valueOf(SendTicketEnum.class, "JICHANGQUPIAO"));
	           
		     }    
		}
}
