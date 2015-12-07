package com.yf.system.back.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.xwork.ActionContext;

/**
 * 
 *订单查询Action
 */
public class HotelOrderSearchAction extends HotelorderAction {
	// 酒店订单
	private Hotelorder hotelorder = new Hotelorder();
	// 酒店订单列表
	private List hotelorderList = new ArrayList();
	// 所有城市
	private List<City> cityList = new ArrayList<City>();
	// 酒店
	private Hotel hotel = new Hotel();
	// 酒店订单操作日志
	private List <Hotelorderrc> listHotelorderrc ;
	// 预订的开始时间
	private String h_prestarttime ;
	// 预订的结束时间
	private String h_preendtime ;
	// 酒店名称
	private String h_hotelName;
	// 酒店所在城市ID
	private Long h_hotelCityId;
	private int h_ordertype=-1;
	
	
	// 酒店英文名称
	private Integer h_isEnglishName;
//报表所用的字段
	private Long cityId;
	private String hotelname;
	private String statetime;
	private String endtime;
	private String hoteltype;//推荐级别
	private String hotelorderstate;//订单状态
	private List <Hotelorder> listHotelorder;
	private List <Guest> listGuest;
	//
	private int jianye;
	private double zongjia;


	
	/**
	 * 获取酒店订单列表，跳转至订单查询页面
	 */
	public String execute() throws Exception {
		
		// 查询所有的城市
		cityList = (List<City>)ActionContext.getContext().getSession().get("cityList");
		if(cityList == null || cityList.size() ==0) {
			cityList = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
			ActionContext.getContext().getSession().put("cityList", cityList);
		}
		// 查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0");
		if(hotelorder.getOrderid() != null && hotelorder.getOrderid().trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + hotelorder.getOrderid().trim() + "'") ;
		}
		if(hotelorder.getLinkname() != null && hotelorder.getLinkname().trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(hotelorder.getLinkname().trim()).append("'") ;
		}
		if(hotelorder.getLinkmobile() != null && hotelorder.getLinkmobile().trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(hotelorder.getLinkmobile().trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					// 按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					// 按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
		
			
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
		if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
		if(1==1) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}
		hotelorderList = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"ORDER BY ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && hotelorderList.size()==0){
			pageinfo.setPagenum(1);
			hotelorderList = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," ORDER BY ID DESC ",pageinfo);	
		}
		pageinfo = (PageInfo) hotelorderList.get(0) ;
		hotelorderList.remove(0) ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar c = Calendar.getInstance();
		if(h_prestarttime == null) {
			// c.add(Calendar.DAY_OF_MONTH, -1);
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转至酒店订单详细页面
	 * @return
	 * @throws Exception
	 */
	public String todetail() throws Exception {
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		/*listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
				" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;*/
		return "detail";
	}
	/**
	 * 跳转至酒店订单报表
	 * @return
	 * @throws Exception
	 */
	public String bordereaux() throws Exception {
		// 查询酒店订单报表
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 ");
		
		

		if (hotelname != null && hotelname.trim().length() != 0) {

			where.append(" and ").append(Hotelorder.COL_name).append(" like '%").append(hotelname.trim()).append("%'");
		}
		if(statetime != null && statetime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + statetime + " 00:00:00')") ;
		}
		if(endtime != null && endtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + endtime + " 23:59:59')") ;
		}
		if (hoteltype != null && hoteltype.length()!=0) {

			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_hot).append("=").append(hoteltype) ;
			where.append(")") ;
			
		}
		if(hotelorderstate!=null && hotelorderstate.length()!=0){
			
			where.append(" and "+Hotelorder.COL_state +" = "+hotelorderstate);
			
		}
		if(cityId != null && cityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
			.append(Hotel.COL_id).append(" FROM ")
				.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_cityid).append("=").append(cityId) ;
			where.append(")") ;
		}
		
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorder(where.toString(), "", -1, 0)	;
		
	if(listHotelorder.size()>0){	
		for (Hotelorder order : listHotelorder) {

			// 循环查询出当前用户的角色ID
			if(order.getManyday()!=null){
			int jian = order.getManyday();
			jianye +=jian;
			}
			double	jia=Double.parseDouble(order.getPrice()); 
		
		
			
			zongjia +=jia;
			
		}
		
	}
		
		return "hotelbordereaux";
	}
	public Hotelorder getHotelorder() {
		return hotelorder;
	}

	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}

	public Object getModel() {
		return null;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public String getH_prestarttime() {
		return h_prestarttime;
	}

	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}

	public String getH_preendtime() {
		return h_preendtime;
	}

	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}
	
	public String getH_hotelName() {
		return h_hotelName;
	}

	public void setH_hotelName(String name) {
		h_hotelName = name;
	}

	public Long getH_hotelCityId() {
		return h_hotelCityId;
	}

	public void setH_hotelCityId(Long cityId) {
		h_hotelCityId = cityId;
	}

	public Integer getH_isEnglishName() {
		return h_isEnglishName;
	}

	public void setH_isEnglishName(Integer englishName) {
		h_isEnglishName = englishName;
	}

	public List getHotelorderList() {
		return hotelorderList;
	}

	public void setHotelorderList(List hotelorderList) {
		this.hotelorderList = hotelorderList;
	}

	public List<Hotelorderrc> getListHotelorderrc() {
		return listHotelorderrc;
	}

	public void setListHotelorderrc(List<Hotelorderrc> listHotelorderrc) {
		this.listHotelorderrc = listHotelorderrc;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getStatetime() {
		return statetime;
	}

	public void setStatetime(String statetime) {
		this.statetime = statetime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getHoteltype() {
		return hoteltype;
	}

	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}

	public String getHotelorderstate() {
		return hotelorderstate;
	}

	public void setHotelorderstate(String hotelorderstate) {
		this.hotelorderstate = hotelorderstate;
	}

	public List<Hotelorder> getListHotelorder() {
		return listHotelorder;
	}

	public void setListHotelorder(List<Hotelorder> listHotelorder) {
		this.listHotelorder = listHotelorder;
	}

	public List<Guest> getListGuest() {
		return listGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}

	public int getJianye() {
		return jianye;
	}

	public void setJianye(int jianye) {
		this.jianye = jianye;
	}

	public double getZongjia() {
		return zongjia;
	}

	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}

	public int getH_ordertype() {
		return h_ordertype;
	}

	public void setH_ordertype(int h_ordertype) {
		this.h_ordertype = h_ordertype;
	}


}
