package com.yf.system.back.action;

import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yf.system.back.server.Server;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.flightinfo.FlightInfo;
import com.yf.system.base.flightinfo.FlightSearch;
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.zrate.Zrate;
import com.opensymphony.webwork.ServletActionContext;


public class B2bDemosticTicket extends B2b2cbackAction {
	
	
    //航空公司
	private List<Aircompany> listAirCompany;
	//航班查询参数
	private FlightSearch flightSearch = new FlightSearch();
	// 航班信息List
	private List<FlightInfo> listFlightInfoAll;
	// 航程类型 1单程 2往返 3联程
	public int s_traveltype = 1;
	// 出发城市三字码
	public String s_depcitycode;
	// 出发城市名称
	public String s_depcityname;
	// 到达城市名称
	public String s_arrcityname;
	// 到达城市三字码
	public String s_arrcitycode;
	// 出发时间
	public String s_startdate;
	// 返程时间
	public String s_backdate;
	// 航空公司代码
	public String s_aircompanycode;
	// 第一程标识
	private int s_travelflag=1;
	// 航程信息Jason字符串
	private String s_jasonsegmentinfo;
	private String randno;
	private Integer isBackOrTo;
	private String lowersegmentstr = "";
	private List lowersegment = new ArrayList();
	// 航程信息List
	private List<Segmentinfo> listsegmentinfo=new ArrayList<Segmentinfo>();
	private List<Segmentinfo> lissegtempt=new ArrayList<Segmentinfo>();
	//读取政策变量
	private String s_cabincode;
	private String s_flightnumber;
	private String z_price;
	//
	
	
	

	
	/**
	 * B2B国内机票首页
	 */
	public String execute() throws Exception {
		
		//从缓存中得到航空公司信息
		listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		System.out.println(listAirCompany.size());
		return SUCCESS;
	}
	
	/** 机票查询方法
	 * 
	 * @return 返回到列表页面
	 * @throws Exception
	 * @author 星星
	 * @Date 2011-11-14
	 */
	public String toTicketList() throws Exception {
		System.out.println("执行机票查询方法");
		// 航班查询条件赋值
		FlightSearch searchParam = new FlightSearch();
		// 出发城市三字码
		searchParam.setStartAirportCode(s_depcitycode);
		// 出发城市名称
		searchParam.setStartAirPortName(s_depcityname);
		// 到达城市三字码
		searchParam.setEndAirportCode(s_arrcitycode);
		// 到达城市名称
		searchParam.setEndAirPortName(s_arrcityname);
		// 出发日期
		searchParam.setFromDate(s_startdate);
		// 出发时间
		searchParam.setFromTime("");
		// 返程日期
		searchParam.setBackDate(s_backdate);
		// 航空公司代码
		searchParam.setAirCompanyCode(s_aircompanycode);
		// 航程类型
		searchParam.setTravelType(String.valueOf(s_traveltype));
		if(s_traveltype==2 && s_travelflag==2)
		{
			// 将json字符串转换程Segmentinfo集合
			listsegmentinfo=getSelectedSegment(s_jasonsegmentinfo);
			String strFromCity=searchParam.getStartAirportCode();
			String strToCity=searchParam.getEndAirportCode();
			searchParam.setStartAirportCode(strToCity);
			searchParam.setEndAirportCode(strFromCity);
			searchParam.setFromDate(searchParam.getBackDate());
			searchParam.setAirCompanyCode(listsegmentinfo.get(0).getAircomapnycode());
			
		}
		// 调用查询航班方法
		listFlightInfoAll = AVOpen(searchParam, s_traveltype);

		System.out.println("===========航班查询结束===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		return "tolist";

	}
	
	/**
	 * 调用接口查询航班信息
	 * 
	 * @author 星星
	 * @Date 2011-11-14
	 * @param flightSearch
	 *            航班查询条件
	 * @param intType
	 *            航程类型
	 * @return 航班信息列表
	 */
	public List<FlightInfo> AVOpen(FlightSearch flightSearch, int intType) {
		System.out.println("===========航班查询开始===当前时间："+formatTimestamp(new Timestamp(System.currentTimeMillis())));
		List<FlightInfo> list = Server.getInstance().getTicketSearchService()
				.findAllFlightinfo(flightSearch);
		
		return list;
	}

	/**
	 * 将json字符串转换程Segmentinfo集合
	 * 
	 * @param strJson
	 *            json字符串,选中航程信息
	 * @return Segmentinfo集合
	 * @author 星星
	 * @createtime 2011-11-21
	 */
	public List<Segmentinfo> getSelectedSegment(String strJson)
	{
		String[] ArrSegment={};
		// 字符串转换成Json对象
		ArrSegment=s_jasonsegmentinfo.split("@");
        for(int j=0;j<ArrSegment.length;j++)
        {
			JSONObject jsonSegmentinfo = JSONObject.fromObject(ArrSegment[j].toString());
			JSONArray jsons = jsonSegmentinfo.getJSONArray("segmentinfos");
			System.out.println("Json航程个数:"+jsonSegmentinfo.size());
			// 循环对航程信息类赋值
			for(int i=0;i<jsons.size();i++)
			{
				JSONObject segmentJson = JSONObject.fromObject(jsons.get(i));
				System.out.println("Segment个数:"+segmentJson.getString("flightnumber"));
				// 航程赋值
				Segmentinfo segment=new Segmentinfo();
				// 航空公司代码
				segment.setAircomapnycode(segmentJson.getString("aircomapnycode"));
				// 航班号
				segment.setFlightnumber(segmentJson.getString("flightnumber"));
				// 航空公司名称
				segment.setAircompanyname(segmentJson.getString("airname"));
				// 机建费
				segment.setAirportfee(Float.parseFloat(converNull(segmentJson.getString("airportfee"),0f).toString()));
				// 燃油费
				segment.setFuelfee(Float.parseFloat(converNull(segmentJson.getString("fuelfee"),0f).toString()));
				// 出发时间
				segment.setDeparttime(dateToTimestamp(segmentJson.getString("departtime")));
				// 到达时间
				segment.setArrivaltime(dateToTimestamp(segmentJson.getString("arrivaltime")));
				// 舱位代码
				segment.setCabincode(segmentJson.getString("cabincode"));
				// 折扣
				segment.setDiscount(Float.parseFloat(converNull(segmentJson.getString("discount"),0f).toString()));
				// 出发机场三字代码
				segment.setStartairport(segmentJson.getString("startairport"));
				// 出发机场名称
				segment.setStartairportname(segmentJson.getString("startairportname"));
				// 到达机场三字代码
				segment.setEndairport(segmentJson.getString("endairport"));
				// 到达机场名称
				segment.setEndairportname(segmentJson.getString("endairportname"));
				// 机型
				segment.setFlightmodel(segmentJson.getString("flightmodel"));
				// 机型描述
				segment.setFlightdesc(segmentJson.getString("flightdesc"));
				// 价格
				segment.setPrice(Float.parseFloat(converNull(segmentJson.getString("price"),0f).toString()));
				// 退改签规定
				segment.setRules(segmentJson.getString("rules"));
				// 航程类型
				segment.setTraveltype(Integer.parseInt(segmentJson.getString("traveltype")));
				// 全价价格
				segment.setYprice(Float.parseFloat(converNull(segmentJson.getString("yprice"),0f).toString()));
				lissegtempt.add(segment);
			}
        }
		return lissegtempt;
	}
	
	public void getFlightZrate() {//listOrderPrice
		//政策值
		Float fratevalue=0f;
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat( "HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
	    String strSP="[dbo].[sp_GetZrateByFlight] "+
		"@chufajichang = N'"+s_depcitycode+"',@daodajichang = N'"+s_arrcitycode+"',"+
		"@chufariqi = N'"+s_startdate+"',@dangqianshijian= N'"+mDateTime+"',"+
		"@hangkonggongsi= N'"+s_aircompanycode+"',"+
		"@cangwei= N'"+s_cabincode+"',@hangbanhao= N'"+s_flightnumber+"',@ismulity=0,@isgaofan=1,@agentid=0";
	    System.out.println(strSP);
	    List listzrate=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
	    String isgaofan="1";
	    Zrate zratemodel=new Zrate();
		//获取最高的政策信息
		if(listzrate.size()>0)
		{
			Map listzratemap = (Map) listzrate.get(0);
			fratevalue=Float.parseFloat(listzratemap.get("zratevalue").toString());
			
			zratemodel=Server.getInstance().getAirService().findZrate(Long.parseLong(listzratemap.get("zrateid").toString()));
			isgaofan=zratemodel.getGeneral()+"";
		}
		else
		{
			zratemodel=Server.getInstance().getAirService().findZrate(1l);
			if(zratemodel!=null)
			{
			fratevalue=zratemodel.getRatevalue();
			isgaofan=zratemodel.getGeneral()+"";
			}
		}
		//取得返佣值
	    long lagentid=getLoginUser().getAgentid();
		 String stragentjibie=getLoginUserAgent().getAgentjibie().toString();
		 String strRabateString="0";
		 //返佣金额
		 Float freturnmoney=0f;
		 freturnmoney=(Float.parseFloat(z_price)* dceimalFormat(Getliudianvalue(fratevalue)) / 100);
		 try{//更具留点设置计算返佣
			 strRabateString=getAgentRebatevalue(lagentid,freturnmoney,1,getLoginUserAgent().getAgentjibie());
		 }
		 catch(Exception ex)
		 {
			 strRabateString="0";
		 }
		
		 //计算当前登录代理商的返佣金额
		 Float frabatemoney=0f;
		 String strrabatemoney="0";
		 if(!strRabateString.equals("0"))
		 {
		    frabatemoney=Float.parseFloat(strRabateString);
		    strrabatemoney=formatMoney_B2BBack(frabatemoney.toString());
		 }
		 else
		 {
			 try
			 {
			   frabatemoney=(Float .parseFloat(z_price)* Getliudianvalue(fratevalue) / 100);
			 }
			 catch(Exception ex)
			 {
				 frabatemoney=0f;
			 }
		 }
		
		//对利润值进行进到个位，保留整数
		int intfmoney=frabatemoney.intValue();
		frabatemoney=Float.parseFloat(intfmoney+"");

		StringBuffer str = new StringBuffer();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String strGaofan="";
		if(isgaofan.equals("2"))
		{
			strGaofan="<font class='ml5 font-b3797f1'>特殊</font>";
		}

		if (fratevalue != null&&fratevalue>0) {
			str.append(""+formatZrate(Getliudianvalue(fratevalue))+"%"+strGaofan);
			str.append("|"
					+ ((Float)(Float.parseFloat(z_price) - frabatemoney)));
		    str.append("|"+String.valueOf(intfmoney));
		} else {
			str.append("暂无政策");
			str.append("|"
					+ ((Float)(Float.parseFloat(z_price) - frabatemoney)));
		    str.append("|"+String.valueOf(intfmoney));
		}
			
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(str.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public boolean compareandselectTab(String date1, String date2) {
		boolean intret = false;
		if (date1.equals(date2)) {
			intret = true;
		}
		return intret;
	}
	
	/**
	 * 获取指定时间的后几天
	 * @param time		指定时间
	 * @param intDay	指定时间的后几天天数
	 * @return
	 */
	public String GetDateMMdd(String time, int intDay,int intflag) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfmmdd = new SimpleDateFormat("yyyy-MM-dd");
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
	
	
	public Object getModel() {
		// TODO Auto-generated method stub
		return flightSearch;
	}





	public FlightSearch getFlightSearch() {
		return flightSearch;
	}
	public void setFlightSearch(FlightSearch flightSearch) {
		this.flightSearch = flightSearch;
	}






	public List<Aircompany> getListAirCompany() {
		return listAirCompany;
	}






	public void setListAirCompany(List<Aircompany> listAirCompany) {
		this.listAirCompany = listAirCompany;
	}

	public List<FlightInfo> getListFlightInfoAll() {
		return listFlightInfoAll;
	}

	public void setListFlightInfoAll(List<FlightInfo> listFlightInfoAll) {
		this.listFlightInfoAll = listFlightInfoAll;
	}

	public int getS_traveltype() {
		return s_traveltype;
	}

	public void setS_traveltype(int s_traveltype) {
		this.s_traveltype = s_traveltype;
	}

	public String getS_depcitycode() {
		return s_depcitycode;
	}

	public void setS_depcitycode(String s_depcitycode) {
		this.s_depcitycode = s_depcitycode;
	}

	public String getS_depcityname() {
		return s_depcityname;
	}

	public void setS_depcityname(String s_depcityname) {
		this.s_depcityname = s_depcityname;
	}

	public String getS_arrcityname() {
		return s_arrcityname;
	}

	public void setS_arrcityname(String s_arrcityname) {
		this.s_arrcityname = s_arrcityname;
	}

	public String getS_arrcitycode() {
		return s_arrcitycode;
	}

	public void setS_arrcitycode(String s_arrcitycode) {
		this.s_arrcitycode = s_arrcitycode;
	}

	public String getS_startdate() {
		return s_startdate;
	}

	public void setS_startdate(String s_startdate) {
		this.s_startdate = s_startdate;
	}

	public String getS_backdate() {
		return s_backdate;
	}

	public void setS_backdate(String s_backdate) {
		this.s_backdate = s_backdate;
	}

	public String getS_aircompanycode() {
		return s_aircompanycode;
	}

	public void setS_aircompanycode(String s_aircompanycode) {
		this.s_aircompanycode = s_aircompanycode;
	}

	public int getS_travelflag() {
		return s_travelflag;
	}

	public void setS_travelflag(int s_travelflag) {
		this.s_travelflag = s_travelflag;
	}

	public String getS_jasonsegmentinfo() {
		return s_jasonsegmentinfo;
	}

	public void setS_jasonsegmentinfo(String s_jasonsegmentinfo) {
		this.s_jasonsegmentinfo = s_jasonsegmentinfo;
	}

	public String getRandno() {
		return randno;
	}

	public void setRandno(String randno) {
		this.randno = randno;
	}

	public Integer getIsBackOrTo() {
		return isBackOrTo;
	}

	public void setIsBackOrTo(Integer isBackOrTo) {
		this.isBackOrTo = isBackOrTo;
	}

	public String getLowersegmentstr() {
		return lowersegmentstr;
	}

	public void setLowersegmentstr(String lowersegmentstr) {
		this.lowersegmentstr = lowersegmentstr;
	}

	public List getLowersegment() {
		return lowersegment;
	}

	public void setLowersegment(List lowersegment) {
		this.lowersegment = lowersegment;
	}

	public List<Segmentinfo> getListsegmentinfo() {
		return listsegmentinfo;
	}

	public void setListsegmentinfo(List<Segmentinfo> listsegmentinfo) {
		this.listsegmentinfo = listsegmentinfo;
	}

	public List<Segmentinfo> getLissegtempt() {
		return lissegtempt;
	}

	public void setLissegtempt(List<Segmentinfo> lissegtempt) {
		this.lissegtempt = lissegtempt;
	}

	public String getS_cabincode() {
		return s_cabincode;
	}

	public void setS_cabincode(String s_cabincode) {
		this.s_cabincode = s_cabincode;
	}

	public String getS_flightnumber() {
		return s_flightnumber;
	}

	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}

	public String getZ_price() {
		return z_price;
	}

	public void setZ_price(String z_price) {
		this.z_price = z_price;
	}



}
