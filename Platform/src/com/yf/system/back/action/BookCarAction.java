package com.yf.system.back.action;



import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.carbrand.Carbrand;
import com.yf.system.base.carimages.Carimages;
import com.yf.system.base.carinfo.Carinfo;
import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.cars.Cars;
import com.yf.system.base.carstore.Carstore;
import com.yf.system.base.city.City;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.region.Region;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class BookCarAction extends B2b2cbackAction {

	private List lowersegment = new ArrayList();
	private String fromcity;
	private String lowersegmentstr = "";

	private Sysconfig sysconfiggngj;
	private Sysconfig sysconfig;
	// 汽车列表
	private List<Cars> carlList;
	
	//汽车品牌
	private List<Carbrand> ListCarbrand;
	
	//租车帮助信息
	//private List<Infocontent> Listinfocontent;
	private Cars cars=new Cars();
	private Carorder carorder=new Carorder();
	private Carorder SerachCarPriceOrder=new Carorder();
	
	 private String strCityId;
	 private String strRegionId;
	 private String strType;//类型..S为取车 E还车
	 
	 private List<Cars> listCarsBJ;
	 private List<Cars> listCarsSH;
	 private List<Cars> listCarsByCity;
	 private List<Infocontent> listInfocontent=new ArrayList<Infocontent>();
	 //联系人相关信息
	 private String linkname;
	 private String linkmobile;
	 private String linkmail;
	 private String nuber;
	 private String jtime;
	 private String sex;
	 //
	//seach
	 private String Carbrand;//品牌
	 private String Car_Xiang;//厢数
	 private String Car_Dang;//档位
	 
	 private String strName;//搜索区域用
	 //跳转
	 private String forword;	
	 //错误信息提示
	 private String messsge;
	 
	 private String Scity;
	 private String Endcity;
	 private String startDate;
	 private String Tday;
	 private String endDate;
	 private String startDate_HH;//小时
	 private String endDate_HH;//小时
	 private String S_Name;//关键字
	 
	 private String Stime;//取车时间组合
	 private String Etime;//还车时间组合
	 
	 private String Scarstore_s;//取车门店ID
	 private String Scarstore_e;//还车门店ID
	//
	 private long ty;//类型
	 
	 private long s_num;//天数
	 private long carid;//
	 private long carOrderid;//订单ID
	 
	 private int HH;
	 public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public String getMesssge() {
		return messsge;
	}

	public void setMesssge(String messsge) {
		this.messsge = messsge;
	}

	public long getCarOrderid() {
		return carOrderid;
	}

	public void setCarOrderid(long carOrderid) {
		this.carOrderid = carOrderid;
	}

	public String getInfocontentToCar() throws Exception {
		 
		 listInfocontent=Server.getInstance().getMemberService().findAllInfocontent(" where 1=1 and "+Infocontent.COL_typeid+" =7", "", 6, 0);
		 return "";
	 }
	//获取中国的城市
	public String getCityAirPortDataToCar() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere="WHERE 1=1 and "+City.COL_countryid+" =168";
	
			
			strwhere+=" and "+City.COL_type+" =2 ";
		
		
		List<City> listAirport = Server.getInstance().getHotelService()
				.findAllCity(strwhere, "ORDER BY C_SORT", -1, 0);
		for (City airPort : listAirport) {
			sb.append(airPort.getName() + "#" + airPort.getEnname() + "%"
					+ airPort.getSname() + "&" + airPort.getId()
					+ ",");
		}
		// return strRetData;
		System.out.println("SB=="+sb);
		out.print(sb);
		out.flush();
		out.close();
		return SUCCESS;
	}
	public String execute() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		
			
			startDate = sdf.format(calendar.getTime());
		
	
			calendar.add(Calendar.DATE , 1);
			endDate = sdf.format(calendar.getTime());
			
			System.out.println("当前时间=="+formatTimestampHHmm(new Timestamp(System.currentTimeMillis())));
		
			String htime=formatTimestampHHmm(new Timestamp(System.currentTimeMillis())).split(":")[0];
			HH=Integer.parseInt(htime)+2;
	System.out.println("HH="+HH);
		return SUCCESS;
	}
	public String bookcar() throws Exception {
		jtime=jtime+" 12:20:00";
		getInfocontentToCar();
		//System.out.println("==="+SerachCarPriceOrder);
		 cars = Server.getInstance().getCarService().findCars(carid);
		 System.out.println("car=="+cars);
			
		startDate=Stime.split(" ")[0];
		startDate_HH=Stime.split(" ")[1];
		
		endDate=Etime.split(" ")[0];
		endDate_HH=Etime.split(" ")[1];
		Scity=cars.getCityid()+"";
		s_num = dateDiff(endDate.trim(), startDate.trim());
		//开始调用接口.
		City sc=Server.getInstance().getHotelService().findCity(cars.getCityid());
		String Sprovince =Server.getInstance().getHotelService().findProvince(sc.getProvinceid()).getCode();
		City ec=Server.getInstance().getHotelService().findCity(Long.parseLong(Endcity));
		String Eprovince =Server.getInstance().getHotelService().findProvince(ec.getProvinceid()).getCode();
		String Scarstorecode="";
		Carstore Scarstore=Server.getInstance().getCarService().findCarstore(Long.parseLong(Scarstore_s));
		Scarstorecode=Scarstore.getStorecode();
		String Ecarstorecode="";
		Carstore Ecarstore=Server.getInstance().getCarService().findCarstore(Long.parseLong(Scarstore_e));
		Ecarstorecode=Ecarstore.getStorecode();
		
		String gps="N";//Y：需要，N：不需要
	
		
		Carorder creatcarorder=Server.getInstance().getYiHaiCarService().CreateCarOrder(Stime, Etime, sc.getName()+"", ec.getName(), Sprovince, Eprovince, Scarstorecode, Ecarstorecode, cars.getCode(), gps,nuber);	
		//Carorder creatcarorder=new Carorder();
		
		//creatcarorder.setPredesc("OK");
		//creatcarorder.setWaicode("test");
		if(creatcarorder.getPredesc().equals("NNE")){//预订失败   NNE为用户名不存在..调用注册接口
			//预订失败..去掉session残留值
			//ActionContext.getContext().getSession().remove("carorder");
			
				String AddUserCode=Server.getInstance().getYiHaiCarService().adduserYiHai(  linkmobile, linkmobile, linkname, sex, linkmail, nuber, jtime);
					//EMD,邮箱地址已存在..CPD,手机号码已存在...IDD,身份证号码已存在..ERR,其它错误
				if(AddUserCode.equals("OK")){//添加用户成功..
					
				Carorder corder=Server.getInstance().getYiHaiCarService().CreateCarOrder(Stime, Etime, sc.getName()+"", ec.getName(), Sprovince, Eprovince, Scarstorecode, Ecarstorecode, cars.getCode(), gps,nuber);	
				
					if(corder.getPredesc().equals("OK")){
						carorder = (Carorder) ActionContext.getContext().getSession().get("carorder");
						carorder.setSdate(startDate+" "+startDate_HH);
						carorder.setEnddate(endDate+" "+endDate_HH);
						carorder.setScityid(sc.getId());
						carorder.setEndcityid(ec.getId());
						carorder.setPretime(new Timestamp(System.currentTimeMillis()));
						carorder.setManyday(Integer.parseInt(s_num+""));
						carorder.setMembername(getOrderUserLogin().getMembername());
						carorder.setMembermobile(getOrderUserLogin().getMobile());
						carorder.setState(1);
						Double orderfee=Double.parseDouble(carorder.getJprice())*0.08;
						carorder.setOrderfee(orderfee+"");
						
						carorder.setBookuserid(getLoginUser().getId());
						carorder.setScarstoreid(Scarstore.getId());
						carorder.setEcarstoreid(Ecarstore.getId());
						
						carorder.setCarid(carid);
						carorder.setLinkmail(linkmail);
						carorder.setLinkmobile(linkmobile);
						carorder.setLinkname(linkname);
						carorder.setNuber(nuber);
						carorder.setWaicode(corder.getWaicode());
						
						carorder.setProperty("1");//1为后台订单.2为前台订单
						carorder.setMemberid(getOrderUserLogin().getId());
						carorder=Server.getInstance().getCarService().createCarorder(carorder);
						carorder.setCode(Server.getInstance().getServiceCenter()
								.getCarOrderCode(carorder));
						Server.getInstance().getCarService().updateCarorderIgnoreNull(carorder);
						
						forword ="bookcar!took.action?carOrderid="+carorder.getId();

						
						ActionContext.getContext().getSession().remove("carorder");
						
						HttpServletResponse response = ServletActionContext.getResponse();
						
						response.sendRedirect(forword);
						
					}else{//第2次预订失败..
						
						messsge="未知错误";
						return "bookearr";
					}
					
				
				
				}else if (AddUserCode.equals("IDD")) {//
					
					messsge="身份证号码已存在";
					return "bookearr";
				}else if (AddUserCode.equals("EMD")) {
					messsge="邮箱地址已存在";
					return "bookearr";
				}else if (AddUserCode.equals("CPD")) {
					messsge="手机号码已存在";
					return "bookearr";
				}else{
					
					messsge="未知错误";
					return "bookearr";
					
				}
		
		
			
		}else if(creatcarorder.getPredesc().equals("OK")){//预订成功
			carorder = (Carorder) ActionContext.getContext().getSession().get("carorder");
			carorder.setSdate(startDate+" "+startDate_HH);
			carorder.setEnddate(endDate+" "+endDate_HH);
			carorder.setScityid(sc.getId());
			carorder.setEndcityid(ec.getId());
			carorder.setPretime(new Timestamp(System.currentTimeMillis()));
			carorder.setManyday(Integer.parseInt(s_num+""));
			carorder.setMembername(getOrderUserLogin().getMembername());
			carorder.setMembermobile(getOrderUserLogin().getMobile());
			carorder.setState(1);
			Double orderfee=Double.parseDouble(carorder.getJprice())*0.08;
			carorder.setOrderfee(orderfee+"");
			
			carorder.setBookuserid(getLoginUser().getId());
			carorder.setScarstoreid(Scarstore.getId());
			carorder.setEcarstoreid(Ecarstore.getId());
			
			carorder.setCarid(carid);
			carorder.setLinkmail(linkmail);
			carorder.setLinkmobile(linkmobile);
			carorder.setLinkname(linkname);
			carorder.setNuber(nuber);
			carorder.setWaicode(creatcarorder.getWaicode());
			carorder.setProperty("1");//1为后台订单.2为前台订单
			carorder.setMemberid(getOrderUserLogin().getId());
			carorder=Server.getInstance().getCarService().createCarorder(carorder);
			carorder.setCode(Server.getInstance().getServiceCenter()
					.getCarOrderCode(carorder));
			Server.getInstance().getCarService().updateCarorderIgnoreNull(carorder);
			
			forword ="bookcar!took.action?carOrderid="+carorder.getId();

			
			ActionContext.getContext().getSession().remove("carorder");
			
			HttpServletResponse response = ServletActionContext.getResponse();
			
			response.sendRedirect(forword);
			
			return "bookfword";
		}else if(creatcarorder.getPredesc().equals("NRT")){//要提前一小时预订
			//forword ="bookcar!seach.action?Scity="+Scity+"&Scarstore_s="+Scarstore.getId()+"&Endcity="+Endcity+"&Scarstore_e="+Ecarstore.getId()+"&startDate="+startDate+"&startDate_HH="+startDate_HH+"&endDate="+endDate+"&endDate_HH="+endDate_HH+"&ty=1";
			ActionContext.getContext().getSession().remove("carorder");
			
			//HttpServletResponse response = ServletActionContext.getResponse();
			
			//response.sendRedirect(forword);
			
			messsge="预订提车需要至少提前一小时";
			return "bookearr";
		}else if(creatcarorder.getPredesc().equals("NOC")){//没有库存
			
			
			

			//forword ="bookcar!seach.action?Scity="+Scity+"&Scarstore_s="+Scarstore.getId()+"&Endcity="+Endcity+"&Scarstore_e="+Ecarstore.getId()+"&startDate="+startDate+"&startDate_HH="+startDate_HH+"&endDate="+endDate+"&endDate_HH="+endDate_HH+"&ty=1";
			ActionContext.getContext().getSession().remove("carorder");
			
			//HttpServletResponse response = ServletActionContext.getResponse();
			
			//response.sendRedirect(forword);
			messsge="车辆没有库存";
			return "bookearr";
		}else if(creatcarorder.getPredesc().equals("NCO")){//该时间段已存在订单
			
			messsge="该时间段已存在订单";
			return "bookearr";
		}else{//预订失败..未知原因
			ActionContext.getContext().getSession().remove("carorder");
			
			//forword ="bookcar!seach.action?Scity="+Scity+"&Scarstore_s="+Scarstore.getId()+"&Endcity="+Endcity+"&Scarstore_e="+Ecarstore.getId()+"&startDate="+startDate+"&startDate_HH="+startDate_HH+"&endDate="+endDate+"&endDate_HH="+endDate_HH+"&ty=1";
			//ActionContext.getContext().getSession().remove("carorder");
			
			//HttpServletResponse response = ServletActionContext.getResponse();
			
			//response.sendRedirect(forword);
			
			messsge="未知错误";
			return "bookearr";
			
		}
		
		
		return "";
	}
	public String took() throws Exception{
		
		carorder=Server.getInstance().getCarService().findCarorder(carOrderid);
		if(carorder!=null){
			
		/*	if(carorder.getMemberid()==getLogin().getId()){
				getInfocontentToCar();
				return "bookok";
			}else{
				
				return "error";
			}*/
			return "bookok";
		}else{
			
			
			return "error";
		}
		
		
	}
	
public String toindex() throws Exception{
		
	
			return "toindex";
		
		
}

	/**
	 * 获取两个日期相减剩余天数
	 * @param d1 
	 * @param d2
	 * @return  天数
	 * @throws ParseException 
	 */
	public long dateDiff(String d1,String d2) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 =  df.parse(d1);
		Date date2 =  df.parse(d2);
		return (date1.getTime() - date2.getTime())/86400000; 
	}
	public String seach() throws Exception {
		/*if(S_Name!=null&&S_Name.length()>0){
    		String expr = new String(S_Name.getBytes("ISO-8859-1"),"UTF-8");
    		System.out.println("expr=="+expr);
    		S_Name=expr;
    		
    	}*/
		
		
		getInfocontentToCar();
		Stime=startDate+" "+startDate_HH;
		Etime=endDate+" "+endDate_HH;
		s_num = dateDiff(endDate.trim(), startDate.trim());
		String where =" where 1=1 ";
		if(Scity!=null&&Scity.length()>0){
			where+=" and "+Cars.COL_cityid+" ='"+Scity+"'";
		}
		if(S_Name!=null&&S_Name.length()>0){
			
			where+=" and "+Cars.COL_name+" like '%"+S_Name+"%'";
		}
		if(Carbrand!=null&&Carbrand.length()>0){
			
			where+=" and "+Cars.COL_ppai+" ='"+Carbrand+"'";
		}
	
		if(Scarstore_s!=null&&Scarstore_s.length()>0){
			where+=" and "+Cars.COL_carstoreid+" ='"+Scarstore_s+"'";
		}
		if(Car_Xiang!=null&&Car_Xiang.length()>0){
			
			where+=" and "+Cars.COL_code+" in ( select "+Carinfo.COL_code+" from "+Carinfo.TABLE+" where "+Carinfo.COL_carriage+" ='"+Car_Xiang+"')";
		}
		if(Car_Dang!=null&&Car_Dang.length()>0){
			
			where+=" and "+Cars.COL_code+" in ( select "+Carinfo.COL_code+" from "+Carinfo.TABLE+" where "+Carinfo.COL_gear+" ='"+Car_Dang+"')";
		}
		
		System.out.println("where=="+where);
		pageinfo.setPagerow(10);
		List list=Server.getInstance().getCarService().findAllCarsForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		carlList = list;
		
		if(pageinfo.getTotalrow()>0 &&   carlList.size()==0){
			pageinfo.setPagenum(1);
			list=Server.getInstance().getCarService().findAllCarsForPageinfo(where, " ORDER BY ID ", pageinfo);
			
			pageinfo = (PageInfo)list.remove(0);
			carlList = list;
		}
		ListCarbrand=Server.getInstance().getCarService().findAllCarbrand(" where 1=1 ", "", -1, 0);
		return "carlist";
	}
	public String getcarstorebyRegion_s() throws Exception {
		String where =" where 1=1 and "+Carstore.COL_district+" ='"+strRegionId+"'";
		List<Carstore>listcarstore=Server.getInstance().getCarService().findAllCarstore(where, "", -1, 0);
		String CarstoreHTML="";
		
		
		
		if(listcarstore.size()>0){
			CarstoreHTML+="<table width='100%' border='0' cellspacing='0' cellpadding='0' style='text-align:left; width:160px; background: #fefefe;'>";
			CarstoreHTML+="<tr>";
			CarstoreHTML+="<td  style='background:#FFFBDB; color:#873C00'>";
			CarstoreHTML+="<div><font class='f'>所有门店</font><font class='r'><img src='images/xxh.gif' onclick='colsediv(\""+strType+"\");' /></font><b class='c`'></b></div>";
			CarstoreHTML+="</td>";
			CarstoreHTML+="</tr>";
			
			
			for(int a=0;a<listcarstore.size();a++){
				//CarstoreHTML+="<tr title="+listcarstore.get(a).getName()+">";	
				if(strType.equals("e")){//还车
				CarstoreHTML+="<a><tr title="+listcarstore.get(a).getName()+"  style='cursor: pointer;' onclick='checkcarstore(\""+listcarstore.get(a).getId()+","+listcarstore.get(a).getAbbrname()+",e\");'>";	
						
				}else{
				CarstoreHTML+="<tr title="+listcarstore.get(a).getName()+"  style='cursor: pointer;' onclick='checkcarstore(\""+listcarstore.get(a).getId()+","+listcarstore.get(a).getAbbrname()+",s\");'>";	
				}
				CarstoreHTML+="<td style='border-top:1px dashed #D2E6EE' onmouseover=\"currentcolor=this.style.backgroundColor;this.style.backgroundColor='#FF9900',this.style.color='#fff',this.style.fontWeight='';\" onmouseout=\"this.style.backgroundColor=currentcolor,this.style.color='#666',this.style.fontWeight='';\" >";
				CarstoreHTML+=""+listcarstore.get(a).getAbbrname()+"";
				
				CarstoreHTML+="</td>";	
				CarstoreHTML+="</tr></a>";	
				
			}
			CarstoreHTML+="</table>";
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(CarstoreHTML);
			out.print(sb);
			out.flush();
		    out.close();
		}
		
		return "";
	}
	public String getregionbycity_s() throws Exception {
		String where =" where 1=1 and "+Region.COL_cityid+" ='"+strCityId+"' and "+Region.COL_id+" in ( SELECT "+Carstore.COL_district+" FROM "+Carstore.TABLE +" where "+Carstore.COL_cityid+" ='"+strCityId+"')";
		
		if(strName!=null&&strName.length()>0){
		String expr = new String(strName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("expr=="+expr);
		strName=expr;
		
	}
		
		
		
		/*if(strName!=null&&strName.length()>0){
			
			where+=" and "+Region.COL_name+" like '%" + strName.trim()+"%'";	
		}*/
		
		
		List<Region>listregion=Server.getInstance().getHotelService().findAllRegion(where, "", -1, 0);
		String RegionHTML="";
		if(listregion.size()>0){
			RegionHTML+="<table width='100%' border='0' cellspacing='0' cellpadding='0' style='position: absolute; left:0px;top:24px;text-align:left; border: 1px solid #0066CC; width:80px; background: #EAF2F8; '>";
			
			RegionHTML+="<tr>"; 
			RegionHTML+="<td style='background:#B5D4EF; border-bottom:1px solid #003366'>";
			RegionHTML+="<div style='color:#3366FF '><b class='f'>所有区域</b><font class='r'><img src='images/xxl.gif' onclick='colsediv(\""+strType+"\");' /></font><b class='c`'></b></div>";
			RegionHTML+="</td>";
			RegionHTML+="</tr>"; 
			
			
			/*RegionHTML+="<tr>"; 
			RegionHTML+="<td style='background:#B5D4EF; border-bottom:1px solid #003366'>";
			if(strType.equals("e")){//还车
			RegionHTML+="<div style='color:#3366FF '><input type='txt' value='' id='seachregion_e' onpropertychange='ceachreg(\"e\");' /></div>";
			}else{
			RegionHTML+="<div style='color:#3366FF '><input type='txt' value='' id='seachregion_s' onpropertychange='ceachreg(\"s\");' /></div>";
			}
			RegionHTML+="</td>";
			RegionHTML+="</tr>"; */
			
			
				for(int a=0;a<listregion.size();a++){
					
					RegionHTML+="<a><tr onmouseover=\"currentcolor=this.style.backgroundColor;this.style.backgroundColor='#77ABE0',this.style.color='#fff',this.style.fontWeight='';\" onmouseout=\"this.style.backgroundColor=currentcolor,this.style.color='#666',this.style.fontWeight='';\">";
					if(strType.equals("e")){//还车
						
						RegionHTML+="<td style='cursor: pointer; border-top:1px solid #D1D1D1' onmouseover='lodcarstore_s(\""+listregion.get(a).getId()+","+"e\");'>";
					}else{
						
						RegionHTML+="<td style='cursor: pointer;border-top:1px solid #D1D1D1' onmouseover='lodcarstore_s(\""+listregion.get(a).getId()+","+"s\");'>";
					}
					
					//RegionHTML+="<td onclick='lodcarstore_s(00);' >";
					RegionHTML+=""+listregion.get(a).getName()+"";
					RegionHTML+="</td>";
					RegionHTML+="</tr></a>";
					
					
				}
			RegionHTML+="</table>";
			if(strType.equals("e")){//还车
			RegionHTML+="<div style='position: absolute;left:83px;width:161px; top:24px; border: 1px solid #f48000;' id='Carstorediv_e' class='ac_results f'></div>";
			RegionHTML+="";
			}else{
			RegionHTML+="<div style='position: absolute;left:83px;width:161px;top:24px; border: 1px solid #f48000;' id='Carstorediv_s' class='ac_results f'></div>";
			RegionHTML+="";
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(RegionHTML);
			out.print(sb);
			out.flush();
		    out.close();
		}else{
			
			
		/*	RegionHTML+="<table width='100%' border='0' cellspacing='0' cellpadding='0' style='position: absolute; left:150px;top:0px;text-align:left; border: 1px solid #0066CC; width:80px; background: #EAF2F8; '>";
			
			RegionHTML+="<tr>"; 
			RegionHTML+="<td style='background:#B5D4EF; border-bottom:1px solid #003366'>";
			RegionHTML+="<div style='color:#3366FF '><b class='f'>所有区域</b><font class='r'><img src='images/xxl.gif' onclick='colsediv(\""+strType+"\");' /></font><b class='c`'></b></div>";
			RegionHTML+="</td>";
			RegionHTML+="</tr>"; 
			
			RegionHTML+="<tr>"; 
			RegionHTML+="<td style='background:#B5D4EF; border-bottom:1px solid #003366'>";
			if(strType.equals("e")){//还车
			RegionHTML+="<div style='color:#3366FF '><input type='txt' value='' id='seachregion_e' onpropertychange='ceachreg(\"e\");' /></div>";
			}else{
			RegionHTML+="<div style='color:#3366FF '><input type='txt' value='' id='seachregion_s' onpropertychange='ceachreg(\"s\");' /></div>";
			}
			RegionHTML+="</td>";
			RegionHTML+="</tr>"; 
			
			RegionHTML+="<tr>";
			RegionHTML+="<td>暂无信息"; 
			RegionHTML+="</td>";
			RegionHTML+="</tr>"; 
			RegionHTML+="</table>";
			if(strType.equals("e")){//还车
			RegionHTML+="<div style='position: absolute;left:230px;width:161px; top:0px; border: 1px solid #f48000;' id='Carstorediv_e' class='ac_results f'></div>";
			RegionHTML+="";
			}else{
			RegionHTML+="<div style='position: absolute;left:230px;width:161px;top:0px; border: 1px solid #f48000;' id='Carstorediv_s' class='ac_results f'></div>";
			RegionHTML+="";
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append(RegionHTML);
			out.print(sb);
			out.flush();
		    out.close();*/
			
		}
		
		
		
		return "";
	}
	public String getImage(long Cid) {
		
		String where=" WHERE " + Carimages.COL_carid +" ="+Cid;
		List<Carimages> listImages = Server.getInstance().getCarService().findAllCarimages(where, "", -1, 0);
		if(listImages.size() > 0) {
			return listImages.get(0).getCarurl();
		}
		return "" ;
	}
	public String getregionname(long CarStoreid) {
		
		String where=" WHERE " + Carstore.COL_id +" ="+CarStoreid;
		Carstore carstore =Server.getInstance().getCarService().findCarstore(CarStoreid);
		if(carstore!=null&&carstore.getDistrict()!=null) {
			
			Region region =Server.getInstance().getHotelService().findRegion(Long.parseLong(carstore.getDistrict()));
			return region.getName();
		}
		return "" ;
	}
	
	public String getcarsbycity() throws Exception{
		String where =" where 1=1 and "+Cars.COL_cityid+" ='"+strCityId+"'";
		listCarsByCity =Server.getInstance().getCarService().findAllCars(where, "", 3, 0);
		
		String CarsHtml="";
		if(listCarsByCity.size()>0){
			for(int a=0;a<listCarsByCity.size();a++){
				
					CarsHtml+="<div style='width:48%;";
					if((a+1)/2==0){
						
						CarsHtml+="float:left; margin-left:10px; display:inline '>";
					}else{
						CarsHtml+="margin-left:10px; '>";
					}
					CarsHtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0' style='text-align:left'>";
					CarsHtml+="<tr>";
					CarsHtml+="<td rowspan='6' height='110' width='142'>";
					CarsHtml+="<div class='box_img' style=' padding:1px; width:142px;'>";
					String carurl=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppathtocar'","",-1,0).get(0)).getValue()+getImage(listCarsByCity.get(0).getId());
					CarsHtml+="<img src='"+carurl+"' width='142' height='94' /></div></td>";
			        CarsHtml+="<td class='he5'>&nbsp;</td>";
			        CarsHtml+=" </tr>";
			        CarsHtml+=" <tr>";
			        CarsHtml+="<td ><strong class=' hui999_14'>"+listCarsByCity.get(a).getName()+"</strong></td>";
			        CarsHtml+="</tr>";
			        String regionname=getregionname(listCarsByCity.get(a).getCarstoreid());
			        
			        CarsHtml+="<td style=' line-height:14px;'>["+regionname+"]</td>";
				    CarsHtml+=" </tr>";
				    CarsHtml+=" <tr>";
				    List<Carinfo> list=Server.getInstance().getCarService().findAllCarinfo(" where 1=1 and "+Carinfo.COL_code+" ='"+listCarsByCity.get(a).getCode()+"'", "", -1, 0);
				    String xiang =list.get(0).getCarriage();
				    String dangwei =list.get(0).getGear();
				    CarsHtml+="  <td >人数："+listCarsByCity.get(a).getMaxpassenger()+"人&nbsp;&nbsp;厢数："+xiang+"</td>";
				    CarsHtml+="  </tr>";
				    CarsHtml+="  <tr>";
				    CarsHtml+=" <td >排挡："+dangwei+"</td>";
				    CarsHtml+=" </tr>";
				    CarsHtml+="<tr>";
				    CarsHtml+="<td >";
				    CarsHtml+="<font class='f'>优惠价格：<font class='huang_jia'>&yen;"+listCarsByCity.get(a).getWeekdayprice().substring(0, listCarsByCity.get(a).getWeekdayprice().lastIndexOf("."))+"</font></font>" +
				    		"<span class='r'><input type='button' class='button_xy' value='预订'  /></span>";
				    CarsHtml+="</td>";
				    CarsHtml+=" </tr>";
				    CarsHtml+="</table>";
				    CarsHtml+="</div>";
				
			
			}
			
		}else{//没有数据
			for(int a=0;a<4;a++){
			CarsHtml+="<div style='width:48%; float:left; margin-left:12px;'>";
			CarsHtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0' style='text-align:left'>";
			CarsHtml+="<tr>";
			CarsHtml+="<td rowspan='6' height='110' width='142'>";
			 CarsHtml+="暂无数据";
		    CarsHtml+="</td>";
		    CarsHtml+=" </tr>";
		    CarsHtml+="</table>";
		    CarsHtml+="</div>";

			}
			
		}
		
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(CarsHtml);
		out.print(sb);
		out.flush();
	    out.close();
		
		
		return "";
	}
	public String tocarinfo()throws Exception{
		 cars = Server.getInstance().getCarService().findCars(carid);
		System.out.println("car=="+cars);
		
		Customeruser  customeruser =getLoginUser();
		if (customeruser == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			String currentUrl = "bookcar!tocarinfo.action?";
		
			currentUrl += "carid=" + carid;
			currentUrl += "&Stime=" + Stime;
			currentUrl += "&Etime=" + Etime;
			currentUrl += "&S_Name=" + S_Name;
			currentUrl += "&Endcity=" + Endcity;
			currentUrl += "&Scarstore_e=" + Scarstore_e;
			currentUrl += "&Scarstore_s=" + Scarstore_s;
			ActionContext.getContext().getSession().put("orderUrl", currentUrl);
				
			return "tologin";
		} else {
			if (ActionContext.getContext().getSession().get("orderUrl") != null) {
				ActionContext.getContext().getSession().remove("orderUrl");
			}
		}
		
		getInfocontentToCar();
		
		//今天日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
				Calendar calendar = Calendar.getInstance();
				Tday = sdf.format(calendar.getTime());
			
			
		
		if(S_Name!=null&&S_Name.length()>0){
			String expr = new String(S_Name.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("expr=="+expr);
			S_Name=expr;
			
			}
	
		startDate=Stime.split(" ")[0];
		startDate_HH=Stime.split(" ")[1];
		
		endDate=Etime.split(" ")[0];
		endDate_HH=Etime.split(" ")[1];
		Scity=cars.getCityid()+"";
		s_num = dateDiff(endDate.trim(), startDate.trim());
		//开始调用接口.查询订单价格
		City sc=Server.getInstance().getHotelService().findCity(cars.getCityid());
		String Sprovince =Server.getInstance().getHotelService().findProvince(sc.getProvinceid()).getCode();
		City ec=Server.getInstance().getHotelService().findCity(Long.parseLong(Endcity));
		String Eprovince =Server.getInstance().getHotelService().findProvince(ec.getProvinceid()).getCode();
		String Scarstorecode="";
		Scarstorecode=Server.getInstance().getCarService().findCarstore(Long.parseLong(Scarstore_s)).getStorecode();
		String Ecarstorecode="";
		Ecarstorecode=Server.getInstance().getCarService().findCarstore(Long.parseLong(Scarstore_e)).getStorecode();
		String gps="N";//Y：需要，N：不需要
		SerachCarPriceOrder=Server.getInstance().getYiHaiCarService().seachprice(Stime, Etime, sc.getName()+"", ec.getName(), Sprovince, Eprovince, Scarstorecode, Ecarstorecode, cars.getCode(), gps);
		//去掉session里以前值
		ActionContext.getContext().getSession().remove("carorder");
		
		if(SerachCarPriceOrder.getPredesc().equals("NO")){//预订失败
			
			System.out.println("失败原因=="+SerachCarPriceOrder.getSpecreq());
			
			
		}
		//把订单信息放到sesiion
		ActionContext.getContext().getSession().put("carorder", SerachCarPriceOrder);
		
		return "carinfo";
	}
	

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sysconfig getSysconfig() {
		return sysconfig;
	}

	public void setSysconfig(Sysconfig sysconfig) {
		this.sysconfig = sysconfig;
	}

	public Sysconfig getSysconfiggngj() {
		return sysconfiggngj;
	}

	public void setSysconfiggngj(Sysconfig sysconfiggngj) {
		this.sysconfiggngj = sysconfiggngj;
	}

	public String getLowersegmentstr() {
		return lowersegmentstr;
	}

	public void setLowersegmentstr(String lowersegmentstr) {
		this.lowersegmentstr = lowersegmentstr;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Infocontent> getListInfocontent() {
		return listInfocontent;
	}

	public void setListInfocontent(List<Infocontent> listInfocontent) {
		this.listInfocontent = listInfocontent;
	}



	public List<Cars> getListCarsBJ() {
		return listCarsBJ;
	}



	public void setListCarsBJ(List<Cars> listCarsBJ) {
		this.listCarsBJ = listCarsBJ;
	}



	public List<Cars> getListCarsSH() {
		return listCarsSH;
	}



	public void setListCarsSH(List<Cars> listCarsSH) {
		this.listCarsSH = listCarsSH;
	}
	public List<Cars> getListCarsByCity() {
		return listCarsByCity;
	}
	public void setListCarsByCity(List<Cars> listCarsByCity) {
		this.listCarsByCity = listCarsByCity;
	}
	public String getStrCityId() {
		return strCityId;
	}
	public void setStrCityId(String strCityId) {
		this.strCityId = strCityId;
	}
	public String getScity() {
		return Scity;
	}
	public void setScity(String scity) {
		Scity = scity;
	}
	public String getEndcity() {
		return Endcity;
	}
	public void setEndcity(String endcity) {
		Endcity = endcity;
	}
	public String getStartDate_HH() {
		return startDate_HH;
	}
	public void setStartDate_HH(String startDate_HH) {
		this.startDate_HH = startDate_HH;
	}
	public String getEndDate_HH() {
		return endDate_HH;
	}
	public void setEndDate_HH(String endDate_HH) {
		this.endDate_HH = endDate_HH;
	}

	public String getS_Name() {
		return S_Name;
	}
	public void setS_Name(String name) {
		S_Name = name;
	}
	public List<Cars> getCarlList() {
		return carlList;
	}
	public void setCarlList(List<Cars> carlList) {
		this.carlList = carlList;
	}
	public String getStime() {
		return Stime;
	}
	public void setStime(String stime) {
		Stime = stime;
	}
	public String getEtime() {
		return Etime;
	}
	public void setEtime(String etime) {
		Etime = etime;
	}
	public long getS_num() {
		return s_num;
	}
	public void setS_num(long s_num) {
		this.s_num = s_num;
	}
	public Cars getCars() {
		return cars;
	}
	public void setCars(Cars cars) {
		this.cars = cars;
	}
	public long getCarid() {
		return carid;
	}
	public void setCarid(long carid) {
		this.carid = carid;
	}
	public String getStrRegionId() {
		return strRegionId;
	}
	public void setStrRegionId(String strRegionId) {
		this.strRegionId = strRegionId;
	}
	public String getStrType() {
		return strType;
	}
	public void setStrType(String strType) {
		this.strType = strType;
	}
	public String getScarstore_s() {
		return Scarstore_s;
	}
	public void setScarstore_s(String scarstore_s) {
		Scarstore_s = scarstore_s;
	}
	public String getScarstore_e() {
		return Scarstore_e;
	}
	public void setScarstore_e(String scarstore_e) {
		Scarstore_e = scarstore_e;
	}
	public Carorder getSerachCarPriceOrder() {
		return SerachCarPriceOrder;
	}
	public void setSerachCarPriceOrder(Carorder serachCarPriceOrder) {
		SerachCarPriceOrder = serachCarPriceOrder;
	}
	public List<Carbrand> getListCarbrand() {
		return ListCarbrand;
	}
	public void setListCarbrand(List<Carbrand> listCarbrand) {
		ListCarbrand = listCarbrand;
	}
	public Carorder getCarorder() {
		return carorder;
	}
	public void setCarorder(Carorder carorder) {
		this.carorder = carorder;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinkmobile() {
		return linkmobile;
	}
	public void setLinkmobile(String linkmobile) {
		this.linkmobile = linkmobile;
	}
	public String getLinkmail() {
		return linkmail;
	}
	public void setLinkmail(String linkmail) {
		this.linkmail = linkmail;
	}
	public String getNuber() {
		return nuber;
	}
	public void setNuber(String nuber) {
		this.nuber = nuber;
	}



	public String getCarbrand() {
		return Carbrand;
	}

	public void setCarbrand(String carbrand) {
		Carbrand = carbrand;
	}

	public String getCar_Xiang() {
		return Car_Xiang;
	}
	public void setCar_Xiang(String car_Xiang) {
		Car_Xiang = car_Xiang;
	}
	public String getCar_Dang() {
		return Car_Dang;
	}
	public void setCar_Dang(String car_Dang) {
		Car_Dang = car_Dang;
	}

	public String getJtime() {
		return jtime;
	}

	public void setJtime(String jtime) {
		this.jtime = jtime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getTy() {
		return ty;
	}

	public void setTy(long ty) {
		this.ty = ty;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getTday() {
		return Tday;
	}

	public void setTday(String tday) {
		Tday = tday;
	}

	public int getHH() {
		return HH;
	}

	public void setHH(int hh) {
		HH = hh;
	}


}
