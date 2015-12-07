/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.airfee.Airfee;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;

public class AirfeeAction extends B2b2cbackAction {
	private static final long serialVersionUID = -3725902192361226824L;
	private List<Airfee> listAirfee;
	private Airfee airfee = new Airfee();

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;
	private long s_orderid;
	
	//授权
	public void GetPnrZhiLing() throws Exception {
		System.out.println("获取SS指令");
		Orderinfo orderinfopnr = Server.getInstance().getAirService().findOrderinfo(s_orderid);
		String strReturn = "";
		List<Segmentinfo> listsegmenginf=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfopnr.getId(), " ORDER BY ID ", -1, 0);
		List<Passenger> listpassengers=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+orderinfopnr.getId(), " ORDER BY ID ", -1, 0);
		
		String strRetrun="";
		String SS ="";  //航段组
		String NM = "NM:"; //姓名组
	    String SSR = "";   //证件组
	   // String CT = "CT:"+this.officeNumber.substring(0, 3)+"/"+this.username+"\r"; //联系方式
	    String strDDate="";
	    //出票时限
	    //ChangeDateMode
	    
	    String aircomcode="yy";
	    if(listsegmenginf.get(0).getAircomapnycode()!=null){
	    	aircomcode=listsegmenginf.get(0).getAircomapnycode();
	    }
	   String officeNumber="BJS182";
	   String username="13512163072";
	   String strCustomerCode="";//大人编码
	    
	   String osi="OSI:"+aircomcode+" CTCT"+username+"\r";//金天
	   
	  // String osi2="OSI:"+aircomcode+" CTCT13910565480\r";//蓝天伟业
	   
	  // String osi2="OSI:"+aircomcode+" CTCT18618379513\r";//金天
	  // String osi2="OSI:"+aircomcode+" CTCT14797020790\r";//西宁
	  // String osi2="OSI:"+aircomcode+" CTCT15311904995\r";//e通天下
	 //  String osi2="OSI:"+aircomcode+" CTCT18618379513\r";//zhuhai 
	   
	//   String osi="OSI:"+aircomcode+" CTCT18911257029\r";//罗总
	    
	  //  String osi="OSI:"+aircomcode+" CTCT18618379513\r";//金天
	    
	  // String osi="OSI:"+aircomcode+" CTCT13501023658\r";//心程
	    
	   //String osi="OSI:"+aircomcode+" CTCT13391271888\r";//伊彦
	    
	   // String osi="OSI:"+aircomcode+" CTCT13466594575\r";//刘波
	    
	  /* String osi="OSI:"+aircomcode+" CTCT18911257029\r";//小徐
	    if(listpassengers.get(0).getMobile()!=null){
	    osi="OSI:"+aircomcode+" CTCT"+listpassengers.get(0).getMobile().trim()+"\r";//小徐
	    }*/
	    
	    String osi2="OSI:"+aircomcode+" CTCT13585527590\r";//晨轩
	  // String osi2="OSI:"+aircomcode+" CTCT18911257029\r";//罗总
	   
	    
	    String TKTL=""; //出票时限
	    String FK="@I"; //封口
	    String TKTLTime="2000"; //出票时限具体时间，应该为起飞前半个小时
	    String strAirCompany=listsegmenginf.get(0).getAircomapnycode().toString();
		//判断单程还是往返,单程
	    for(int j=1;j<=listsegmenginf.size();j++)
	    {
	    	//出票时限
	    	strDDate=ChangeDateMode(listsegmenginf.get(0).getDeparttime().toString());
		    //取得出票时限具体时间
	    	TKTLTime=formatTimestampPID(dateToTimestamp(GetMintue(listsegmenginf.get(0).getDeparttime().toString(),-00)));
		    System.out.println("出票时限日期:"+strDDate);
		    System.out.println("出票时限时间:"+TKTLTime);
		    if(j==1)
		    {
			  TKTL="TKTL"+TKTLTime+"/"+strDDate+"/"+officeNumber+"\r"; //出票时限
			  System.out.println("出票时限日期字符串:"+TKTL);
		    }
	    	//单程
			if(j==1)
			{
				//航段组
				//子舱位 预订SS:HU7238 M 06MAY XIYPEK 1
				if(listsegmenginf.get(0).getCabincode().length()==2)
				{
					//SS="SS:" + listsegmenginf.get(0).getFlightnumber() + " " + listsegmenginf.get(0).getCabincode().substring(0, 1) + " " + ChangeDateMode(listsegmenginf.get(0).getDeparttime().toString()) + " " + listsegmenginf.get(0).getStartairport()+listsegmenginf.get(0).getEndairport() + " "+listsegmenginf.get(0).getCabincode().substring(1, 2)+"\r";
					SS="SS:" + listsegmenginf.get(0).getFlightnumber() + " " + listsegmenginf.get(0).getCabincode().substring(0, 1) + " " + ChangeDateMode(listsegmenginf.get(0).getDeparttime().toString()) + " " + listsegmenginf.get(0).getStartairport()+listsegmenginf.get(0).getEndairport() + " "+listpassengers.size()+"\r";
				}
				else
				{
					SS="SS:" + listsegmenginf.get(0).getFlightnumber() + "/" + listsegmenginf.get(0).getCabincode() + "/" + ChangeDateMode(listsegmenginf.get(0).getDeparttime().toString()) + "/" + listsegmenginf.get(0).getStartairport()+listsegmenginf.get(0).getEndairport() + "/NN" + listpassengers.size()+"/"+formatTimestampPID(listsegmenginf.get(0).getDeparttime())+" "+formatTimestampPID(listsegmenginf.get(0).getArrivaltime())+"\r";
				}
				
			}
			//往返或联程
			if(j==2)
			{
				//出票时限
			    strDDate=ChangeDateMode(GetDate(listsegmenginf.get(1).getDeparttime().toString(),-1));
				//TKTL="TKTL/2000/"+strDDate+"/"+this.officeNumber+"$"; //出票时限
				SS+="SS:" + listsegmenginf.get(1).getFlightnumber() + "/" + listsegmenginf.get(1).getCabincode() + "/" + ChangeDateMode(listsegmenginf.get(1).getDeparttime().toString()) + "/" + listsegmenginf.get(1).getStartairport()+listsegmenginf.get(1).getEndairport() + "/NN" + listpassengers.size()+"\r";
			}
			
	    }
	    int index=0;
		for(int i=0;i<listpassengers.size();i++)
		{	
			index++;
			String strPassName="";
			strPassName=listpassengers.get(i).getName();
			System.out.println("*****&&&&&&&&**********Name:"+strPassName);
			//如果是儿童
			if(listpassengers.get(i).getPtype()==2)
			{
				String strBirthDay=listpassengers.get(i).getIdnumber().toString();
				if(!strAirCompany.equals("CZ"))
				{
				   strPassName=listpassengers.get(i).getName();//CHD
				}
				else
				{
				   strPassName=listpassengers.get(i).getName();
				}
				
			}
			if(listpassengers.get(i).getPtype()==3)
			{
				strPassName=listpassengers.get(i).getName()+"INF";
			}
			
			//姓名组
			NM+="1" + strPassName;
			//证件组
			
			//else{//现在儿童也要证件号码
				//SSR += "SSR FOID " + listsegmenginf.get(0).getAircomapnycode() + " HK/NI" + listpassengers.get(i).getIdnumber() + "/P" + index + "\r";
				String nn="NI";
				if(listpassengers.get(i).getIdtype()==1){
					nn="NI";
				}
				if(listpassengers.get(i).getIdtype()==3){
					nn="NI";
				}
				
				if(listpassengers.get(0).getPtype()==1){
				SSR += "SSR:FOID " + listsegmenginf.get(0).getAircomapnycode() + " HK/"+nn + listpassengers.get(i).getIdnumber() + "/P" + index + "\r";
				}else{
				SSR += "SSR:FOID YY HK/"+nn + listpassengers.get(i).getIdnumber() + "/P" + index + "\r";
				}
			//}
				
				if(listpassengers.get(0).getPtype()==2)
				{
					String strbirthday="";
					if(listpassengers.get(i).getBirthday()!=null)
					{
						strbirthday=ChangeDateModeYear(listpassengers.get(i).getBirthday());
						//strbirthday=listpassengers.get(i).getBirthday().substring(6, 8)+listpassengers.get(i).getBirthday().substring(4, 6)+listpassengers.get(i).getBirthday().substring(2, 4);
						//strbirthday=listpassengers.get(i).getBirthday().replaceAll("-", "");
						//strbirthday=listpassengers.get(i).getBirthday().replaceAll("-", "");
						//strbirthday=strbirthday.substring(6, 8)+strbirthday.substring(4, 6)+strbirthday.substring(2, 4);
						
					}
					
					if(listpassengers.get(0).getPtype()==1){
						SSR += "SSR:CHLD " + listsegmenginf.get(0).getAircomapnycode() + " HK1/" + strbirthday + "/P" + index + "\r";
						}else{
						SSR += "SSR:CHLD YY HK1/" + strbirthday + "/P" + index + "\r";
						}
					
					//SSR += "SSR:CHLD " + listsegmenginf.get(0).getAircomapnycode() + " HK1/" + strbirthday + "/P" + index + "\r";
					//SSR += "SSR:CHLD YY HK1/" + strbirthday + "/P" + index + "\r";
				}
			
			}
	    NM+="\r";
	    //如果乘机人类型是儿童，则备注成人PNR编码
	    if(listpassengers.get(0).getPtype()==2)
	    {
	    	SSR += "SSR:OTHS "+listsegmenginf.get(0).getAircomapnycode()+" ADULT PNR IS "+strCustomerCode+ "\r";
	    }
	    String CustomerCodestr="";
	    //判断是否是大客户，如果是大客户
	    //取得预订航班的航空公司
	    
//	    if(!strCustomerCode.equals(",") && strCustomerCode.trim().length()>3)
//	    {
//	    	String[] strarr=strCustomerCode.split(",");
//		    if(strAirCompany.equals("MU"))
//		    {
//		    	 if(strarr.length>=1)
//		    	 {
//		    		 if(strarr[0]!=null && !strarr[0].equals(""))
//		    		 {
//			           CustomerCodestr="FP:CASH,CNY/*"+strarr[0]+"\r";
//		    		 }
//		    	 }
//		    }
//		    else if(strAirCompany.equals("CA"))
//		    {
//		    	if(strarr.length>=2)
//		    	{
//		    		if(strarr[1]!=null && !strarr[1].equals(""))
//		    		{
//			           CustomerCodestr="FP CASH,CNY/*"+strCustomerCode+"\rSSR OTHS CA "+strarr[1]+"\r";
//		    		}
//		    	}
//		    }
//		    else if(strAirCompany.equals("CZ"))
//		    {
//		    	if(strarr.length>=4)
//		    	{
//		    		if(strarr[2]!=null && !strarr[2].equals(""))
//		    		{
//			          CustomerCodestr="RMK IC CZ/"+strarr[2]+"\r";
//		    		}
//		    	}
//		    }
//	    }
	    	String strcmd=""+SS+NM+SSR+TKTL+CustomerCodestr+osi+osi2+FK;
	    	System.out.println(strcmd);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(strcmd);
			out.print("<br/><pre>"+sb.toString().replaceAll(new String(new byte[]{0x20,0x62,0x0D}),new String(new byte[]{0x0D})).replaceAll(new String(new byte[]{0x20,0x0D}),"\r")+"</pre><br/>");
	
			out.flush();
			out.close();
		}
	/**
	 * 获取指定时间的前几小时
	 * @param time		指定时间
	 * @param intDay	指定时间的前几小时
	 * @return
	 */
	public String GetMintue(String time, int intMinute) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		String strReturn = "";
		try {
			date = sdf.parse(time);
			Calendar cd = Calendar.getInstance();
			cd.setTime(date);
			cd.add(Calendar.MINUTE, intMinute);// 分钟相加减
			date = cd.getTime();
			strReturn = sdf.format(date).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strReturn;
	}
	//转化时间格式 HH:MM
	public String formatTimestampPID(Timestamp date){
		try {
			return (new SimpleDateFormat("HHmm").format(date));
			
		} catch (Exception e) {
			return "";
		}
		
	}
	public String ChangeDateModeYear(String dateStr)
    {
        //2009-03-19
	     String newmon="";
	     System.out.println(dateStr);
	     String daystr = dateStr.substring(8, 10);
	     String yearstr = dateStr.substring(2, 4);
	     String monstr = dateStr.substring(5, 7);
	     if(monstr.equals("01"))
	     {
	    	 newmon = "JAN";
	     }
	     else if(monstr.equals("02"))
	     {
	    	 newmon = "FEB";
	     }
	     else if(monstr.equals("03"))
	     {
	    	 newmon = "MAR";
	     }
	     else if(monstr.equals("04"))
	     {
	    	 newmon = "APR";
	     }
	     else if(monstr.equals("05"))
	     {
	    	 newmon = "MAY";
	     }
	     else if(monstr.equals("06"))
	     {
	    	 newmon = "JUN";
	     }
	     else if(monstr.equals("07"))
	     {
	    	 newmon = "JUL";
	     }
	     else if(monstr.equals("08"))
	     {
	    	 newmon = "AUG";
	     }
	     else if(monstr.equals("09"))
	     {
	    	 newmon = "SEP";
	     }
	     else if(monstr.equals("10"))
	     {
	    	 newmon = "OCT";
	     }
	     else if(monstr.equals("11"))
	     {
	    	 newmon = "NOV";
	     }
	     else if(monstr.equals("12"))
	     {
	    	 newmon = "DEC";
	     }
        return daystr + newmon+yearstr;
    }
	
	
	/**
	 * 列表查询燃油费机建费表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Airfee.COL_name +" like '%" + s_name.trim()+"%'";
		// }
		
		if (airfee.getAdultairportfee()!= null
				&& airfee.getAdultairportfee() >= 0) {
			where += " and " + Airfee.COL_adultairportfee + "="+ airfee.getAdultairportfee();
		}
		
		if (airfee.getAdultfuelfee()!= null
				&& airfee.getAdultfuelfee() >= 0) {
			where += " and " + Airfee.COL_adultfuelfee + "="+ airfee.getAdultfuelfee();
		}
		
		List list = Server.getInstance().getAirService()
				.findAllAirfeeForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listAirfee = list;
		if (pageinfo.getTotalrow() > 0 && listAirfee.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllAirfeeForPageinfo(where, " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listAirfee = list;
		}
	
		return SUCCESS;
	}

	/**
	 * 转向到燃油费机建费表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}



	
	/**
	 * 转向到燃油费机建费表修改页面
	 */
	public String toedit() throws Exception {
		airfee = Server.getInstance().getAirService()
				.findAirfee(airfee.getId());
		return EDIT;
	}

	/**
	 * 转向到燃油费机建费表审核页面
	 */
	public String tocheck() throws Exception {
		airfee = Server.getInstance().getAirService()
				.findAirfee(airfee.getId());
		return CHECK;
	}

	/**
	 * 添加燃油费机建费表
	 */
	public String add() throws Exception {
		airfee.setCreateuser(getLoginUser().getLoginname());
		airfee.setCreatetime(new Timestamp(System.currentTimeMillis()));
		airfee.setModifyuser(getLoginUser().getLoginname());
		airfee.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().createAirfee(airfee);
		return LIST;
	}

	/**
	 * 审核燃油费机建费表
	 */
	public String check() throws Exception {
		airfee.setModifyuser(getLoginUser().getLoginname());
		airfee.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAirfeeIgnoreNull(airfee);
		return LIST;
	}

	/**
	 * 编辑燃油费机建费表
	 */
	public String edit() throws Exception {
		airfee.setModifyuser(getLoginUser().getLoginname());
		airfee.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAirfeeIgnoreNull(airfee);
		return LIST;
	}

	/**
	 * 删除燃油费机建费表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteAirfee(airfee.getId());
		return LIST;
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getAirService().deleteAirfee(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回燃油费机建费表对象
	 */

	public Object getModel() {
		return airfee;
	}

	public List<Airfee> getListAirfee() {
		return listAirfee;
	}

	public void setListAirfee(List<Airfee> listAirfee) {
		this.listAirfee = listAirfee;
	}

	public Airfee getAirfee() {
		return airfee;
	}

	public void setAirfee(Airfee airfee) {
		this.airfee = airfee;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}

	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}
	public long getS_orderid() {
		return s_orderid;
	}
	public void setS_orderid(long s_orderid) {
		this.s_orderid = s_orderid;
	}

}