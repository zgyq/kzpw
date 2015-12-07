/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.back.server.Server;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.city.City;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.hotelprice.Hotelprice;

public class HotelNoConfirmOrderAction extends HotelorderAction {
	private List  listHotelorder;
	private List <City> listCities ;
	private List <Hotelorderrc> listHotelorderrc ;
	private List <Roomtype> listRoomtype ;
	private List<Guest> listGuest  ;
	private Hotelorder hotelorder = new Hotelorder();
	private Hotel hotel = new Hotel() ;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private int h_ordertype=-1;
	//search
	//private String s_name;
	
	//酒店城市
	private Integer h_hotelCityId ; 
	
	//订单号
	private String h_orderId ;
	
	//联系人姓名
	private String h_linkname ;
	
	//联系人手机
	private String h_linkmobile ;
	
	//入住日期
	private String h_comedate ;
	
	//离店日期
	private String h_leavedate ;
	
	//预订的开始时间
	private String h_prestarttime ;
	
	//预订的结束时间
	private String h_preendtime ;
	
	//是否是酒店的英文名
	private Integer h_isEnglishName ;
	
	//酒店名称
	private String h_hotelName ;
	
	//房型的id
	private Long h_roomid ;

	//要跳转的页面
	private String forwardall ;
	
	//重定向的页面
	private String forward ;
	
	private String h_type ;
	
	/**
	 * 列表查询酒店订单
	 */	
	public String execute()throws Exception{
		long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
		if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		//if(this.getLoginRole().getId() != confighotelid)
		/*if(confighotelid == 0 )
		{
			if(h_prestarttime == null) {
				h_prestarttime = sdf.format(new Date()) ;
			}
			if(h_preendtime == null) {
				h_preendtime = sdf.format(new Date()) ;
			}
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0");
		where.append(" AND " + Hotelorder.COL_state + "=3 ") ;
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
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
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
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
		//if(this.getLoginRole().getId() == confighotelid) 
	/*	if(confighotelid == 0 ) 
		{
			where.append(" AND " + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId()) ;
		}*/
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" , pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by  ID EDSC" , pageinfo);	
		}
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return SUCCESS;
	}
	
	/**
	 * 转向到酒店订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店订单修改页面
	 */	
	public String toedit()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE " + Roomtype.COL_hotelid 
				+ "=" + hotelorder.getHotelid(), "", -1, 0) ;
		listGuest = Server.getInstance().getHotelService().findAllGuest(" WHERE " + Guest.COL_orderid + "=" + 
				hotelorder.getId(), "", -1, 0) ;
		return EDIT;
	}
	
	/**
	 * 转向到酒店订单审核页面
	 */	
	public String tocheck() throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
				" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		return CHECK;
	}
	
	
	/**
	 * 添加酒店订单
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createHotelorder(hotelorder);
		return LIST;
	}

	/**
	 * 确认酒店订单
	 */		
	public String check()throws Exception {
		
		//确认
		if(hotelorder.getState().intValue() != 13) {
			if(hotelorder.getState().intValue() == 10) {
				//取消订单
				if(hotelorder.getCanclereason().intValue() == 1) {
					//客人取消订单
					//System.out.println("发送取消订单的传真--------------------------------------------------");
					hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId()) ;
					hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
					Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder) ;
					try {
						//Server.getInstance().getAtomServiceProject().sendCannelOrderFax(hotelorder, hotel) ;
					} catch(Exception e) {
						hotelorder.setResultcode(new Integer(1)) ;
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder) ;
					}
				} else if(hotelorder.getCanclereason() == 2) {
					//酒店取消订单
					//System.out.println("发送取消订单的传真--------------------------------------------------");
				}
			} else {
				Hotelorder hotelorderBak = Server.getInstance().getHotelService().executeCimfirm(hotelorder, this.getLoginUser().getLoginname(), 
						this.getLoginUser().getMobile()) ;
				//如果是预留房确认不在给用户确认
				if(hotelorderBak.getState() == 4) {
					//noticeUser(hotelorderBak) ;
				}
			}
		} else {
		//变更订单
			return toedit() ;
		}
		if(forwardall != null && "whole".equals(forwardall.trim())) {
			forward = "hotelwholeorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
			"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
			"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
			this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		} else {
			forward = "hotelnoconfirmorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
				"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
				"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
				this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		}
		return LIST;
	}
	
	
	/**
	 * 发送传真
	 */
	public String sendFax() throws Exception {
		hotelorder.setState(null) ;
		hotelorder.setCheckdesc(null) ;
		hotelorder.setFaxsendtime(new Timestamp(new Date().getTime())) ;
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder) ;
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId()) ;
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		try {
			if(hotelorder.getVersion().intValue() > 1) {
				//Server.getInstance().getAtomServiceProject().sendModifyOrderFax(hotelorder, hotel) ;
			} else {
				//Server.getInstance().getAtomServiceProject().sendCreateOrderFax(hotelorder, hotel) ;
			}
		} catch(Exception e) {
			hotelorder.setResultcode(new Integer(1)) ;
			Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder) ;
		}
//		System.out.println("发送传真确认----------------------------------------") ;
		if(forwardall != null && "whole".equals(forwardall.trim())) {
			forward = "hotelwholeorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
			"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
			"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
			this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		} else {
			forward = "hotelnoconfirmorder.action?h_hotelCityId=" + h_hotelCityId + "&h_orderId=" + h_orderId +
				"&h_linkname=" + this.getUrlEncode(this.getUrlEncode(h_linkname)) + "&h_linkmobile=" + h_linkmobile +
				"&h_prestarttime=" + h_prestarttime + "&h_preendtime=" + h_preendtime + "&h_hotelName=" + 
				this.getUrlEncode(this.getUrlEncode(h_hotelName)) + "&h_isEnglishName=" + h_isEnglishName + "&h_type=ce&" + getUrl();
		}
		return LIST ;
	}


	/**
	 * 编辑酒店订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		return LIST;
	}

	/**
	 * 删除酒店订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelorder(hotelorder.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getHotelService().deleteHotelorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	/**
	 * 根据房型 入住日期 和离店日期得到价格
	 * @return
	 */
	public String getEditPrices() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar comeCal = Calendar.getInstance() ;
		comeCal.setTime(sdf.parse(h_comedate)) ;
		Calendar leaveCal = Calendar.getInstance() ;
		leaveCal.setTime(sdf.parse(h_leavedate)) ;
		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
			"=" + hotelorder.getRoomid() ;
		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
		StringBuffer buf = new StringBuffer("") ;
		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
				Hotelprice price = iterator.next() ;
				if(price.getDatenumber().equals(comeStr)) {
					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
					buf.append(method.invoke(price, new Object[]{}) + "|") ;
					break ;
				}
			}
			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		}
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listRoomtype = Server.getInstance().getHotelService().findAllRoomtype(" WHERE " + Roomtype.COL_hotelid 
				+ "=" + hotelorder.getHotelid(), "", -1, 0) ;
		if(buf.length() > 0) {
			hotelorder.setPrice(buf.substring(0, buf.length()-1)) ;
		}
		hotelorder.setComedate(new Timestamp(sdf.parse(h_comedate).getTime())) ;
		hotelorder.setLeavedate(new Timestamp(leaveCal.getTimeInMillis())) ;
		return EDIT ;
	}


	/**
	 *  返回酒店订单对象
	 */		
	
	public Object getModel() {
		return hotelorder;
	}
	public List < Hotelorder >   getListHotelorder() {
		return listHotelorder;
	}
	public void setListHotelorder(List <  Hotelorder  >  listHotelorder) {
		this.listHotelorder = listHotelorder;
	}
	public Hotelorder getHotelorder() {
		return hotelorder;
	}
	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
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

	public String getH_comedate() {
		return h_comedate;
	}

	public void setH_comedate(String h_comedate) {
		this.h_comedate = h_comedate;
	}

	public Integer getH_isEnglishName() {
		return h_isEnglishName;
	}

	public void setH_isEnglishName(Integer englishName) {
		h_isEnglishName = englishName;
	}

	public Integer getH_hotelCityId() {
		return h_hotelCityId;
	}

	public void setH_hotelCityId(Integer cityId) {
		h_hotelCityId = cityId;
	}

	public String getH_hotelName() {
		return h_hotelName;
	}

	public void setH_hotelName(String name) {
		h_hotelName = name;
	}

	public String getH_leavedate() {
		return h_leavedate;
	}

	public void setH_leavedate(String h_leavedate) {
		this.h_leavedate = h_leavedate;
	}

	public String getH_linkmobile() {
		return h_linkmobile;
	}

	public void setH_linkmobile(String h_linkmobile) {
		this.h_linkmobile = h_linkmobile;
	}

	public String getH_linkname() {
		return h_linkname;
	}

	public void setH_linkname(String h_linkname) {
		this.h_linkname = h_linkname;
	}

	public String getH_orderId() {
		return h_orderId;
	}

	public void setH_orderId(String id) {
		h_orderId = id;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getForwardall() {
		return forwardall;
	}

	public void setForwardall(String forwardall) {
		this.forwardall = forwardall;
	}

	public String getH_preendtime() {
		return h_preendtime;
	}

	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}

	public String getH_prestarttime() {
		return h_prestarttime;
	}

	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}

	public List<Hotelorderrc> getListHotelorderrc() {
		return listHotelorderrc;
	}

	public void setListHotelorderrc(List<Hotelorderrc> listHotelorderrc) {
		this.listHotelorderrc = listHotelorderrc;
	}

	public List<Roomtype> getListRoomtype() {
		return listRoomtype;
	}

	public void setListRoomtype(List<Roomtype> listRoomtype) {
		this.listRoomtype = listRoomtype;
	}

	public Long getH_roomid() {
		return h_roomid;
	}

	public void setH_roomid(Long h_roomid) {
		this.h_roomid = h_roomid;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getH_type() {
		return h_type;
	}

	public void setH_type(String h_type) {
		this.h_type = h_type;
	}

	public List<Guest> getListGuest() {
		return listGuest;
	}

	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}

	public int getH_ordertype() {
		return h_ordertype;
	}

	public void setH_ordertype(int h_ordertype) {
		this.h_ordertype = h_ordertype;
	}

}