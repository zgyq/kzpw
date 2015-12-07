package com.yf.website.web.action;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.website.web.server.Server;
import com.opensymphony.xwork.ModelDriven;

/**
 * 机票需要用到的所有公共方法,继承B2b2cbackAction
 * @Date 2011-11-14
 * @author 陈星
 *
 */
public abstract class TicketCommonAction extends B2b2cbackAction implements ModelDriven
   {
		/**
		 * 将价格格式化成不带有小数的价格
		 * @param money
		 * @return
		 */
		public String formatMoneyToInt( Float money ){
			DecimalFormat format = null;
			format = (DecimalFormat) NumberFormat.getInstance();
			format.applyPattern( "###0" );
			try{
				String result = format.format( money );
				return result;
			}catch ( Exception e ){
				return Float.toString( money );
			}
		}
		/**
		 * 根据航空公司代码取得航空公司名称
		 * @param code
		 * @return
		 */
		public String getAirCompanyNameByCode(String code)
		{
			String AirCompanyName=code;
			//从缓存中得到航空公司信息
			List<Aircompany> listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
			for(Aircompany aircompany:listAirCompany)
			{
				if(aircompany.getAircomcode().equals(code))
				{
					AirCompanyName=aircompany.getAircomjname();
				}
			}
			return AirCompanyName;
		}
		
		public String getFlightModel(String model)
		{
			String strReturn="(大)";
			//从缓存中得到航空公司信息
			List<Flightmodel> listFlightModel=Server.getInstance().getTicketSearchService().getFlightModelCache();
			for(Flightmodel flightmodel:listFlightModel)
			{
			     	if(flightmodel.getModelnum().equals(model))
			     	{
			     		if(flightmodel.getIsbig()==1)
			     		{
			     			strReturn="(大)";
			     		}
			     		else if(flightmodel.getIsbig()==0)
			     		{
			     			strReturn="(小)";
			     		}
			     	}
			}
			return strReturn;
		}
		
		/**
		 * 获取指定时间的后几天
		 * @param time		指定时间
		 * @param intDay	指定时间的后几天天数
		 * @return
		 */
		public String GetDateMMdd(String time, int intDay,int intflag) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfmmdd = new SimpleDateFormat("MM-dd");
			Date date;
			String strReturn = "";
			String strRetvalue="";
			int dayOfWeek=0;
			int nowDayOfWeek=0;
			String strWeekName="";
			try {
				date = sdf.parse(time);
				Calendar cd = Calendar.getInstance();
				cd.setTime(date);
				cd.add(Calendar.DATE, intDay);// 增加一天
				date = cd.getTime();
				//取得星期
				dayOfWeek = Calendar.DAY_OF_WEEK;
				nowDayOfWeek = cd.get(dayOfWeek);
				switch(nowDayOfWeek)
				{
				   case 1:
					   strWeekName="星期日";
					   break;
				   case 2:
					   strWeekName="星期一";
					   
					   break;
				   case 3:
					   strWeekName="星期二";
					   break;
				   case 4:
					   strWeekName="星期三";
					   break;
				   case 5:
					   strWeekName="星期四";
					   break;
				   case 6:
					   strWeekName="星期五";
					   break;
				   case 7:
					   strWeekName="星期六";
					   break;
				}
				
				strReturn = sdfmmdd.format(date).toString();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(intflag==0)
			{
				strRetvalue=strReturn;
			}
			else if(intflag==1)
			{
				strRetvalue=strWeekName;
			}
			return strRetvalue;
			
		}
		
		public boolean compareandselectTab(String date1, String date2) {
			boolean intret = false;
			if (date1.equals(date2)) {
				intret = true;
			}
			return intret;
		}
		
		/**
		 * 根据类型，sql 查询 或取所需信息
		 * 
		 * @param <T>
		 * @param cls
		 * @param sql
		 * @return
		 */
		public <T> T findBySql(Class<T> cls, String sql) {
			List list = Server.getInstance().getSystemService().findMapResultBySql(
					sql, null);
			if (list.size() > 0) {
				Map m = (Map) list.get(0);
				try {
					return (T) this.setFiledfrommap(cls, m);
				} catch (Exception e) {
					System.out.println("B2b2backAction:findBySql ERROR:");
					e.printStackTrace();
					return null;
				}
			}
			return null;

		}
		
		
		/**
		 * 从map转换为对象
		 * 
		 * @param <T>
		 * @param t
		 * @param map
		 * @return
		 * @throws SecurityException
		 * @throws NoSuchMethodException
		 * @throws IllegalArgumentException
		 * @throws IllegalAccessException
		 * @throws InvocationTargetException
		 * @throws InstantiationException
		 * @throws NoSuchFieldException
		 */
		public <T> T setFiledfrommap(Class t, Map map) throws SecurityException,
				NoSuchMethodException, IllegalArgumentException,
				IllegalAccessException, InvocationTargetException,
				InstantiationException, NoSuchFieldException {
			Iterator<Map.Entry<String, String>> iterator = map.entrySet()
					.iterator();
			T tt = (T) t.newInstance();
			System.out.println(map.size());
			for (Map.Entry<String, String> entry = null; iterator.hasNext();) {
				entry = iterator.next();
				String paraname = entry.getKey();
				Object val = entry.getValue();
				paraname = paraname.substring(0, 1).toUpperCase()
						+ paraname.substring(1);
				Method getm = t.getMethod("get" + paraname, null);
				String type = getm.getReturnType().getSimpleName();
				if (type.equals("Integer") || type.equals("int")) {
					val = Integer.valueOf(val.toString());
				}
				if (type.equals("long") || type.equals("Long")) {
					val = Long.valueOf(converNull(val, '0').toString());
				}
				if (type.equals("float") || type.equals("Float")) {
					val = Float.valueOf(val.toString());
				}
				Method method = t.getMethod("set" + paraname, getm.getReturnType());

				method.invoke(tt, val);
			}
			return tt;
		}

		
	
   }
