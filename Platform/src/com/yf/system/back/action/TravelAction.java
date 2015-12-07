package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.scenicspot.Scenicspot;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triplinesource.Triplinesource;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.tripnode.Tripnode;
import com.yf.system.base.triporder.Triporder;
import com.yf.system.base.triprange.Triprange;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class TravelAction extends B2b2cbackAction {
	private static final long serialVersionUID = -1711178620523020984L;
	// 旅游线路
	private Tripline tripline = new Tripline();
	// 旅游线路列表
	private List<Tripline> listTripline;
	// 行程列表
	private List<Triprange> listTriprange;
	// 城市名称
	private String t_cityname;
	// 目的地城市名称
	private String s_endcityid;
	private String s_endcityname;
	private int s_linetype=-1;
	// 本月热卖
	private Tripline hotLine;
	//重要提示
	private List<Tripnode> tripnodeNotice;
	//目的地说明
	private List<Tripnode> tripnodeArrival;
	//预定人数
	private String s_personnum;
	private String hidtripid;
	//预订成功的重定向
	private String forward ;
	//线路单价
	private String hidprice;
	//总价钱
	private double totalprice;
	//订单信息
	private String tripline_id;
	private long orderid;
	private String s_date;
	private String tripnum;
	private String triptprice;
	private String contactname;
	private String mobile;
	private String tel;
	private String email;
	private String desc;
	private String lineid;
	
	private Triporder ordertrip=new Triporder();
	private List<Hotel> hotelList_tebie;
	
	private Long temporderuserid;
	
	private Long usertype=1l;
	//酒店导航
	private List<Hotel> hotelList_daohang;
	//价格范围
	private String s_price;
	//景区信息
	private List<Scenicspot> listScenic;
	//景区ID
	private String sid;
	private Scenicspot scenicspot;
	
	//出发地城市id
	private String s_startcityid;
	//出发日期
	private String s_t_startdate;
	private String s_t_enddate;
	private String travelfromcity;
	private String traveltocity;
	private List<Triplinetype> listtriplinetype;
	
	public Object getModel() {
		return tripline;
	}

	/**
	 * 列表查询旅行线路
	 */
	public String execute() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		s_t_startdate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE , 1);
		s_t_enddate = sdf.format(calendar.getTime());
		//线路类型
		String strwheretype="";
		if(ActionContext.getContext().getSession().get("language")!=null)
		{
			strwheretype=" where "+Triplinetype.COL_language+"="+ActionContext.getContext().getSession().get("language");
		}
		else
		{
			strwheretype=" where "+Triplinetype.COL_language+"=0";
		}
		listtriplinetype=Server.getInstance().getTripService().findAllTriplinetype(strwheretype, "Order by ID desc", -1, 0);

		//北京出发的旅游线路
		String where = " where 1=1 and " + Tripline.COL_cityid + "=53";
		listTripline = Server.getInstance().getTripService().findAllTripline(where, " ORDER BY ID ", 6,0);
		if(listTripline!=null && listTripline.size()>0)
		{
		  hotLine = listTripline.get(listTripline.size() - 1);
		}
		return SUCCESS;
	}
	
	/**
	 * 转向至旅行线路列表页面
	 * @return
	 * @throws Exception
	 */
	public String toTriplineList() throws Exception {
		
		String where = " where 1=1 ";
		//出发城市
		if(s_startcityid!=null && !s_startcityid.equals(""))
		{
			where +=" and "+Tripline.COL_cityid+"="+s_startcityid;
		}
		//到达城市
		if( s_endcityid!=null && !s_endcityid.equals(""))
		{
			where +=" and "+Tripline.COL_endcityid+"="+s_endcityid;
		}
		//出发时间
		if(s_t_startdate!=null && !s_t_startdate.equals(""))
		{
			where +=" and "+Tripline.COL_startdate+">='"+s_t_startdate+"'";
		}
		//线路类型
		if(s_linetype!=-1)
		{
			where +=" and "+Tripline.COL_typeid+"="+s_linetype;
		}
		//关键字
		if(s_endcityname!=null && !s_endcityname.equals(""))
		{
			where +=" and  "+Tripline.COL_name+" like '%"+s_endcityname+"%'";
		}
		
		List list = Server.getInstance().getTripService()
				.findAllTriplineForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listTripline = list;
		if (pageinfo.getTotalrow() > 0 && listTripline.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService()
					.findAllTriplineForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listTripline = list;
		}
		return "triplinelist";
	}
	
	/**
	 * 转向至旅行线路列表页面Ajax
	 * @return
	 * @throws Exception
	 */
	public String toTriplineListAjax() throws Exception {
		if (tripline.getCityid() == null || tripline.getCityid() == 0) {
			// 默认出发城市为北京
			String citywhere = " where 1=1 ";
			
			if (t_cityname != null && !"".equals(t_cityname)) {
				citywhere += " and " + City.COL_name + " like '" + t_cityname + "'"; 
			} else {
				citywhere += " and " + City.COL_name + " like '北京'";
			}
			List<City> list = Server.getInstance().getHotelService()
					.findAllCity(citywhere, "ORDER BY ID", -1, 0);
			if (list != null && list.size() > 0) {
				City bjcity = list.get(0);
				tripline.setCityid(bjcity.getId());
			}
		}
		
		// 目的地城市
		String endcitywhere = " where 1=1 ";
		if (s_endcityname != null && !"".equals(s_endcityname)) {
			endcitywhere += " and " + City.COL_name + " like '" + s_endcityname + "'"; 
			List<City> list = Server.getInstance().getHotelService().findAllCity(endcitywhere, "ORDER BY ID", -1, 0);
			if (list != null && list.size() > 0) {
				City bjcity = list.get(0);
				tripline.setEndcityid(bjcity.getId());
			}
		} 
		
		String where = " where 1=1 ";
		//如果有价格范围
		if(s_price!=null)
		{
			where+=" and " + Tripline.COL_price +"<='"+s_price+"'" ;
		}
		if (tripline.getCityid() != null && tripline.getCityid() > 0) {
			where += " and " + Tripline.COL_cityid + "=" + tripline.getCityid();
		}
		 
		if (tripline.getEndcityid() != null && tripline.getEndcityid() > 0) {
			where += " and " + Tripline.COL_endcityid + "=" + tripline.getEndcityid();
		}
		
		List list = Server.getInstance().getTripService()
				.findAllTriplineForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listTripline = list;
		if (pageinfo.getTotalrow() > 0 && listTripline.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService()
					.findAllTriplineForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listTripline = list;
		}
		String strHtml="";
		if(listTripline.size()>0)
		{
			
				strHtml="<tr>";
				strHtml+="<td  style='padding:10px 0 10px 0'>";
				strHtml+="<table width='735' border='0' cellspacing='0' cellpadding='0'>";
				for(int i=0;i<listTripline.size();i++)
				{
				strHtml+="<tr>";
				strHtml+="<td class='box_bottom_xu' style='padding:10px 0 10px 0'>";
				strHtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
				strHtml+="<tr>";
				strHtml+="<td width='90' rowspan='2' align='center'>";
				if(usertype==2){
					strHtml+="<img onclick='window.location.href=\"triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"&usertype=2\"' src='"+getimgPath()+listTripline.get(i).getImage()+"' width='79' height='79' style='cursor:hand' />";	
				}else{
				strHtml+="<img onclick='window.location.href=\"triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"\"' src='"+getimgPath()+listTripline.get(i).getImage()+"' width='79' height='79' style='cursor:hand' />";
				}
				strHtml+="</td>";
				strHtml+="<td width='85' rowspan='2' align='center' valign='middle'>"+listTripline.get(i).getStartdate()+"<br />"+getAgentTName(listTripline.get(i).getCustomeragentid())+"</td>";
				if(usertype==2){
					strHtml+="<td><a href='javascript:void(0)' onclick='window.location.href=\"triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"&usertype=2\"' style='font-size:14px; font-weight:bold'>"+listTripline.get(i).getName()+"</a></td>";	
				}else{
				strHtml+="<td><a href='javascript:void(0)' onclick='window.location.href=\"triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"\"' style='font-size:14px; font-weight:bold'>"+listTripline.get(i).getName()+"</a></td>";
				}
				strHtml+="<td width='118' rowspan='2' valign='top' style='padding-left:10px;'>参考价<font class='red_cu'>"+listTripline.get(i).getPrice().toString()+"元</font>起<br />"; 
				if(usertype==2){
					strHtml+="<font class='red_cu'> 返"+gettravefan(listTripline.get(i).getPrice().toString())+"元</font>";
					strHtml+="<br /><input class='button61' type='button' value='预定' onclick=\"window.location.href='triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"&usertype=2'\" /></td>";
					
				}else{
					strHtml+="<br /><input class='button61' type='button' value='预定' onclick=\"window.location.href='triplinebook!toTravelDetail.action?lineid="+listTripline.get(i).getId()+"'\" /></td>";
					
				}
					strHtml+="</tr>";
				strHtml+="<tr>";
				String strDesc="";
				if(listTripline.get(i).getDescription().length()>50)
				{
					strDesc=listTripline.get(i).getDescription().substring(0, 49)+"...";
				}
				else
				{
					strDesc=listTripline.get(i).getDescription();
				}
				strHtml+="<td align='left' style='padding:5px; color:#999999;'>"+listTripline.get(i).getDescription()+"</td>";
				strHtml+="</tr>";
				strHtml+="</table>";
				strHtml+="</td>";
				strHtml+="</tr>";
				}
				strHtml+="</table>";
				strHtml+="</td>";
				strHtml+="</tr>";

		}
		else
		{
			strHtml="<tr>";
			strHtml+="<td  style='padding:10px 0 10px 0'>";
			strHtml+="<table width='735' border='0' cellspacing='0' cellpadding='0'>";
			strHtml+="<tr>";
			strHtml+="<td class='box_bottom_xu' style='padding:10px 0 10px 0'>";
			strHtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
			strHtml+="<tr>";
			strHtml+="<td width='90' rowspan='2' align='center'></td>";
			strHtml+="<td width='85' rowspan='2' align='center' valign='middle'></td>";
			strHtml+="<td></td>";
			strHtml+="<td width='118' rowspan='2' valign='top' style='padding-left:10px;'>暂无旅行线路，请选择其他线路！</td>";
			strHtml+="</tr>";
			strHtml+="<tr>";
			strHtml+="<td align='left' style='padding:5px; color:#999999;'></td>";
			strHtml+="</tr>";
			strHtml+="</table>";
			strHtml+="</td>";
			strHtml+="</tr>";
			strHtml+="</table>";
			strHtml+="</td>";
			strHtml+="</tr>";
		}
		
		System.out.println("strHtml"+strHtml);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strHtml);
		out.print(sb);
		out.flush();
		out.close();
		return "triplinelist";
	}
	public String getimgPath()
	{
		return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue()+"/";
	}
	/**
	 * 转向至旅行线路详细信息页面
	 * @return
	 * @throws Exception
	 */
	public String toTravelDetail() throws Exception {
		long llineid=Long.parseLong(lineid);
		tripline = Server.getInstance().getTripService().findTripline(llineid);
		String where = " where " + Triprange.COL_triplineid + "=" + tripline.getId();
		listTriprange = Server.getInstance().getTripService().findAllTriprange(where, "ORDER BY ID", -1, 0);
		//目的地信息
		String strwherea=" WHERE "+Tripnode.COL_triplineid+ "=" + tripline.getId() +" AND "+Tripnode.COL_type+"=1";
		tripnodeArrival=Server.getInstance().getTripService().findAllTripnode(strwherea, "ORDER BY ID", -1, 0);
		//重要提示
		String strwheren=" WHERE "+Tripnode.COL_triplineid+ "=" + tripline.getId() +" AND "+Tripnode.COL_type+"=2";
		tripnodeNotice=Server.getInstance().getTripService().findAllTripnode(strwheren, "ORDER BY ID", -1, 0);
		//景区信息
		String strwheresce=" WHERE "+Scenicspot.COL_cityid+" = "+tripline.getEndcityid();
		listScenic=Server.getInstance().getTripService().findAllScenicspot(strwheresce, "ORDER BY ID DESC", 3, 0);
		return "triplinedetail";
	}
	
	public String toScenicDetail() throws Exception{
		long llineid=Long.parseLong(sid);
		tripline = Server.getInstance().getTripService().findTripline(tripline.getId());
		long lid=Long.parseLong(sid);
		scenicspot=Server.getInstance().getTripService().findScenicspot(lid);
		return "scenicdetail";
	}
	
	public String toBook() throws Exception
	{
		if(usertype!=2){
		//检测是否有预订的用户
			Customeruser user = getOrderUserLogin();
			if (user == null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				String currentUrl = "triplinebook!toBook.action";
				currentUrl+="?hidtripid="+hidtripid;
				currentUrl+="&hidprice="+hidprice;
				currentUrl+="&s_personnum="+s_personnum;
				ActionContext.getContext().getSession().put("orderUrl", currentUrl);
				return "orderuserlogin";
			} else {
				if (ActionContext.getContext().getSession().get("orderUrl") != null) {
					ActionContext.getContext().getSession().remove("orderUrl");
				}
			}
		}
		long tid=Long.parseLong(hidtripid); 
		tripline = Server.getInstance().getTripService().findTripline(tid);
		double dprice=Double.parseDouble(hidprice);
		int intnum=Integer.parseInt(s_personnum);
		totalprice=dprice*intnum;
		//特别推广的酒店
		hotelList_tebie = Server.getInstance().getHotelService().findAllHotel("where 1=1 and "+Hotel.COL_cityid+" =53 and "+Hotel.COL_hot+" =1", " ORDER BY ID DESC", 2, 0);
		return "tripbook";
	}
	public String tocreateOrder() throws Exception
	{
		ordertrip.setCreatetime(new Timestamp(System.currentTimeMillis()));
		ordertrip.setCreateuser("管理员");
		ordertrip.setLanguage(0);
		ordertrip.setLinkmail(email);
		ordertrip.setLinkmobile(mobile);
		ordertrip.setLinkname(contactname);
		ordertrip.setLinktell(tel);
		ordertrip.setPnum(Integer.parseInt(tripnum));
		ordertrip.setSpecreq(desc);
		ordertrip.setState(1); //待确认
		ordertrip.setBuyagentid(getLoginUserAgent().getId());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
		ordertrip.setStatetime(new Timestamp(sdf1.parse(s_date).getTime()));
		float totalprice=Float.parseFloat(triptprice);
		ordertrip.setSump(totalprice);
		if(usertype==2){
			ordertrip.setMemberid(getLoginUser().getId());
			ordertrip.setLanguage(1);//Language.原用于语言类型.现用于判断订单类型,1为B2B订单  2为B2C订单;
			ordertrip.setFanprice(Float.parseFloat(gettravefan(totalprice+"")+""));
			}else{
			ordertrip.setLanguage(2);//Language.原用于语言类型.现用于判断订单类型,1为B2B订单  2为B2C订单;
			ordertrip.setMemberid(getOrderUserLogin().getId());
			}
		
		long lineid=Long.parseLong(tripline_id);
		ordertrip.setTriplineid(lineid);
        //生成订单
		ordertrip=Server.getInstance().getTripService().createTriporder(ordertrip);
		ordertrip.setCode(Server.getInstance().getServiceCenter().getTripOrderCode(ordertrip));
		
		Server.getInstance().getTripService().updateTriporderIgnoreNull(ordertrip);
		if(usertype==2){
			
			temporderuserid=getLoginUser().getId();
		}else{
		temporderuserid=getOrderUserLogin().getId();
		}
		ActionContext.getContext().getSession().remove("orderuserlogin");
		forward = "triplinebook!booksuccess.action?orderid=" + ordertrip.getId()+"&temporderuserid="+temporderuserid ;
		//发送短信
		String[] strMobile={mobile};
		tripline = Server.getInstance().getTripService().findTripline(lineid);
		String strContent=getSMSTemple("TOrderInform").replace("@tripdate@", s_date).replace("@tripname@", tripline.getName());
		smsSend(strMobile,strContent,ordertrip.getCode()+"","");
		//发送短信完毕
		return "forwardnew" ;
	}
	
	public String booksuccess() throws Exception
	{
		ordertrip=Server.getInstance().getTripService().findTriporder(orderid);
		
	
			return "booksuccess"; //应该为空，添加完会员id后就将此代码改成空
		
		
	}
	
	
	/**
	 * 根据线路ID获取线路名称
	 */
	public String getTriplineName(long idnumber)
	{
		Tripline tripline=Server.getInstance().getTripService().findTripline(idnumber);
		return tripline != null && !"".equals(tripline.getName()) ? tripline.getName() : "";
	}
	
	/**
	 * 
	 */
	public String getAgentTName(long idnumber)
	{
		 Triplinesource tripsource =Server.getInstance().getTripService().findTriplinesource(idnumber);
		return tripsource != null && !"".equals(tripsource.getName()) ? tripsource.getName() : "";
	}
	/**
	 * 根据线路ID获取目的地ID
	 */
	public long getToCityid(long triplineid)
	{
		Tripline tripline=Server.getInstance().getTripService().findTripline(triplineid);
		return tripline != null && !"".equals(tripline.getEndcityid()) ? tripline.getEndcityid() : 0;
	}
	/**
	 * 根据城市名称获取城市Id
	 * @param cityName
	 * @return
	 */
	public long getCityid(String cityName) {
		String citywhere = " where 1=1 ";
		if (cityName != null && !"".equals(cityName)) {
			citywhere += " and " + City.COL_name + " like '" + cityName + "'"; 
		}
		List<City> list = Server.getInstance().getHotelService().findAllCity(citywhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			City bjcity = list.get(0);
			return bjcity.getId();
		}
		return 0;
	}
	
	/**
	 * 根据城市ID获取城市名称
	 * @param cityId
	 * @return
	 */
	public String getCityName(long cityId) {
		String strLanguage="";
		if(ActionContext.getContext().getSession().get("language")!=null)
		{
			strLanguage=ActionContext.getContext().getSession().get("language").toString();
		}
		else
		{
			strLanguage="0";
		}
		City city = Server.getInstance().getHotelService().findCitybylanguage(cityId, Integer.parseInt(strLanguage));
		return city != null && !"".equals(city.getName()) ? city.getName() : "";
	}
	
	
	/**
	 * 截取字符串
	 * @param desc	要截取的字符串
	 * @param size	截取长度
	 * @return
	 */
	public String substringDescription(String desc, int size) {
		if (desc.length() <= size) {
			return desc;
		}
		return desc.substring(0, size);
	}

	public Tripline getTripline() {
		return tripline;
	}

	public void setTripline(Tripline tripline) {
		this.tripline = tripline;
	}

	public List<Tripline> getListTripline() {
		return listTripline;
	}

	public void setListTripline(List<Tripline> listTripline) {
		this.listTripline = listTripline;
	}

	public String getT_cityname() {
		return t_cityname;
	}

	public void setT_cityname(String t_cityname) {
		this.t_cityname = t_cityname;
	}

	public Tripline getHotLine() {
		return hotLine;
	}

	public void setHotLine(Tripline hotLine) {
		this.hotLine = hotLine;
	}

	public String getS_endcityname() {
		return s_endcityname;
	}

	public void setS_endcityname(String s_endcityname) {
		this.s_endcityname = s_endcityname;
	}

	public List<Triprange> getListTriprange() {
		return listTriprange;
	}

	public void setListTriprange(List<Triprange> listTriprange) {
		this.listTriprange = listTriprange;
	}

	public void setTripnodeNotice(List<Tripnode> tripnodeNotice) {
		this.tripnodeNotice = tripnodeNotice;
	}

	public void setTripnodeArrival(List<Tripnode> tripnodeArrival) {
		this.tripnodeArrival = tripnodeArrival;
	}

	public List<Tripnode> getTripnodeNotice() {
		return tripnodeNotice;
	}

	public List<Tripnode> getTripnodeArrival() {
		return tripnodeArrival;
	}

	public String getS_personnum() {
		return s_personnum;
	}

	public void setS_personnum(String s_personnum) {
		this.s_personnum = s_personnum;
	}

	public String getHidtripid() {
		return hidtripid;
	}

	public void setHidtripid(String hidtripid) {
		this.hidtripid = hidtripid;
	}

	public String getHidprice() {
		return hidprice;
	}

	public void setHidprice(String hidprice) {
		this.hidprice = hidprice;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getTripnum() {
		return tripnum;
	}

	public void setTripnum(String tripnum) {
		this.tripnum = tripnum;
	}

	public String getTriptprice() {
		return triptprice;
	}

	public void setTriptprice(String triptprice) {
		this.triptprice = triptprice;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTripline_id() {
		return tripline_id;
	}

	public void setTripline_id(String tripline_id) {
		this.tripline_id = tripline_id;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Triporder getOrdertrip() {
		return ordertrip;
	}

	public void setOrdertrip(Triporder ordertrip) {
		this.ordertrip = ordertrip;
	}

	public List<Hotel> getHotelList_tebie() {
		return hotelList_tebie;
	}

	public void setHotelList_tebie(List<Hotel> hotelList_tebie) {
		this.hotelList_tebie = hotelList_tebie;
	}

	public List<Hotel> getHotelList_daohang() {
		return hotelList_daohang;
	}

	public void setHotelList_daohang(List<Hotel> hotelList_daohang) {
		this.hotelList_daohang = hotelList_daohang;
	}

	public String getS_price() {
		return s_price;
	}

	public void setS_price(String s_price) {
		this.s_price = s_price;
	}

	public List<Scenicspot> getListScenic() {
		return listScenic;
	}

	public void setListScenic(List<Scenicspot> listScenic) {
		this.listScenic = listScenic;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Scenicspot getScenicspot() {
		return scenicspot;
	}

	public void setScenicspot(Scenicspot scenicspot) {
		this.scenicspot = scenicspot;
	}

	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public String getS_endcityid() {
		return s_endcityid;
	}

	public void setS_endcityid(String s_endcityid) {
		this.s_endcityid = s_endcityid;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public Long getTemporderuserid() {
		return temporderuserid;
	}

	public void setTemporderuserid(Long temporderuserid) {
		this.temporderuserid = temporderuserid;
	}

	public Long getUsertype() {
		return usertype;
	}

	public void setUsertype(Long usertype) {
		this.usertype = usertype;
	}

	public String getS_startcityid() {
		return s_startcityid;
	}

	public void setS_startcityid(String s_startcityid) {
		this.s_startcityid = s_startcityid;
	}

	public String getS_t_startdate() {
		return s_t_startdate;
	}

	public void setS_t_startdate(String s_t_startdate) {
		this.s_t_startdate = s_t_startdate;
	}

	public String getS_t_enddate() {
		return s_t_enddate;
	}

	public void setS_t_enddate(String s_t_enddate) {
		this.s_t_enddate = s_t_enddate;
	}

	public String getTravelfromcity() {
		return travelfromcity;
	}

	public void setTravelfromcity(String travelfromcity) {
		this.travelfromcity = travelfromcity;
	}

	public String getTraveltocity() {
		return traveltocity;
	}

	public void setTraveltocity(String traveltocity) {
		this.traveltocity = traveltocity;
	}

	public List<Triplinetype> getListtriplinetype() {
		return listtriplinetype;
	}

	public void setListtriplinetype(List<Triplinetype> listtriplinetype) {
		this.listtriplinetype = listtriplinetype;
	}

	public int getS_linetype() {
		return s_linetype;
	}

	public void setS_linetype(int s_linetype) {
		this.s_linetype = s_linetype;
	}

}
