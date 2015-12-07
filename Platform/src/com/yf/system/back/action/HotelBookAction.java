package com.yf.system.back.action;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.roomtype.Roomtype;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;


public class HotelBookAction extends B2b2cbackAction{
	
	private Hotel hotel  ;
	private Roomtype roomtype = new Roomtype() ;
	private Hotelorder hotelorder = new Hotelorder() ;
	private City city ;
	private List<Hotel> listHotel ;
	private List<Guest> guestes ;
	//private List<Genuser> genusers ;
	private String memberName = "刘新峰";
	private Customeruser member = new Customeruser();
	//酒店的ID
	private Long h_hotelid ;
	
	private Long temporderuserid;
	
	//酒店的名称
	private String h_hotelname ;

	//房型的ID
	private Long h_roomtypeid ;
	
	//房型的名称
	private String h_roomtypename ;
	
	//入住日期
	private String h_comedate ;
	
	//离店日期
	private String h_leavedate ;
	
	//保留开始时间
	private String h_savestarttime ;
	
	//保留的结束时间
	private String h_saveendtime ;
	
	//常用入住人
	private String[] h_guest ;
	
	//1间房的总价格
	private Double priceSum = new Double(0f);
	
	//每个房型在入住日期和离店日期之间的所有价格
	private String h_perprices  ;
	
	//预订成功的重定向
	private String forward ;

	//酒店的查询
	private String s_city ; 
	
	private String startDate ;
	
	private String endDate ;
	private List<Customerpassenger> listcustomerpassenger;
	
	/**
	 * 转向酒店的预订页面
	 */
	public String execute() throws Exception {
		//检测是否有预订的用户
		Customeruser user = getOrderUserLogin();
		if (user == null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			String currentUrl = "hotelbook.action";
			currentUrl+="?hotelorder.roomid="+hotelorder.getRoomid();
			currentUrl+="&startDate="+startDate;
			currentUrl+="&endDate="+endDate;
			ActionContext.getContext().getSession().put("orderUrl", currentUrl);
			return "orderuserlogin";
		} else {
			if (ActionContext.getContext().getSession().get("orderUrl") != null) {
				ActionContext.getContext().getSession().remove("orderUrl");
			}
			listcustomerpassenger = Server.getInstance().getMemberService().findAllCustomerpassenger("where 1=1 and "+Customerpassenger.COL_customeruserid+" ="+user.getId(), "", -1, 0);
		}
		//设置默认的房间数量
		if(hotelorder.getPrerooms() == null || hotelorder.getPrerooms().intValue() == 0) {
			hotelorder.setPrerooms(new Integer(1)) ;
			h_guest = new String[1] ;
		}
		//房型
		roomtype = Server.getInstance().getHotelService().findRoomtype(hotelorder.getRoomid()) ;
		//酒店
		hotel = Server.getInstance().getHotelService().findHotel(roomtype.getHotelid()) ;
		
		List<Customeruser> memberList = Server.getInstance().getMemberService().findAllCustomeruser(" where " + Customeruser.COL_membername + " like '" + memberName + "'", "ORDER BY ID", -1, 0);
		if(memberList != null && memberList.size()>0) {
			member = memberList.get(0);
		}
		
		//String genuserwhere = " WHERE " + Genuser.COL_type + "=1" + " AND " + Genuser.COL_member + "=" + member.getId() ;
	//	genusers = Server.getInstance().getGenuserManager().findAllGenuser(genuserwhere, " order by " + Genuser.COL_state + " desc, " + Genuser.COL_createtime + " desc", 10, 0) ;
		//查询价格
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar comeCal = Calendar.getInstance() ;
		comeCal.setTime(sdf.parse(startDate)) ;
		Calendar leaveCal = Calendar.getInstance() ;
		leaveCal.setTime(sdf.parse(endDate)) ;
		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
			"=" + roomtype.getId() ;
		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
	
		StringBuffer buf = new StringBuffer("") ;
		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
			//是否设置值
			Double priceValue = 0d ;
			//是否被禁用
			boolean isbid = false ;
			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
				Hotelprice price = iterator.next() ;
				if(price.getDatenumber().equals(comeStr)) {
					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
					priceValue = (Double)method.invoke(price, new Object[]{}) ;
					//判断该日期的价格是否被禁用
					if(price.getIsvalid().charAt(day-1) == '1') {
						isbid = true ;
					}
					break ;
				}
			}
			if(isbid) {
				this.addActionError("在"+h_comedate + "到" + h_leavedate + "之间的价格不存在或者被禁用") ;
				buf = new StringBuffer("") ;
				priceSum = 0d ;
				break ;
			}
			priceSum += priceValue ;
			buf.append(priceValue + "|") ;
			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		}
		if(buf.length() > 0) {
			h_perprices = buf.substring(0, buf.length() - 1) ;
		}
		
		if(hotelorder.getLinkname() == null || hotelorder.getLinkname().trim().length() == 0) {
			hotelorder.setLinkname(member.getMembername()) ;
			hotelorder.setLinkmobile(member.getMobile()) ;
			hotelorder.setLinkmail(member.getMemberemail()) ;
			hotelorder.setLinktell(member.getMembermobile());
			hotelorder.setMemberid(member.getId());
		}
		
		return "success" ;
	}
	
	
	/**
	 * 转向到酒店的预订核对的页面
	 */
	public String tobrowse() throws Exception {
		//查询价格
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar comeCal = Calendar.getInstance() ;
		comeCal.setTime(sdf.parse(startDate)) ;
		Calendar leaveCal = Calendar.getInstance() ;
		leaveCal.setTime(sdf.parse(endDate)) ;
		String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
				"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
				"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
		String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
			comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
			"=" + roomtype.getId() ;
		List<Hotelprice> prices = Server.getInstance().getHotelService().findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
	
		StringBuffer buf = new StringBuffer("") ;
		while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
			int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
			//是否设置值
			Double priceValue = 0d ;
			//是否被禁用
			boolean isbid = false ;
			for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
				Hotelprice price = iterator.next() ;
				if(price.getDatenumber().equals(comeStr)) {
					Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
					priceValue = (Double)method.invoke(price, new Object[]{}) ;
					//判断该日期的价格是否被禁用
					if(price.getIsvalid().charAt(day-1) == '1') {
						isbid = true ;
					}
					break ;
				}
			}
			if(isbid) {
				this.addActionError("在"+h_comedate + "到" + h_leavedate + "之间的价格不存在或者被禁用") ;
				buf = new StringBuffer("") ;
				priceSum = 0d ;
				break ;
			}
			priceSum += priceValue ;
			buf.append(priceValue + "|") ;
			comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
			comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
		}
		if(buf.length() > 0) {
			h_perprices = buf.substring(0, buf.length() - 1) ;
		}
		hotel = Server.getInstance().getHotelService().findHotel(h_hotelid);
		//房型
		roomtype = Server.getInstance().getHotelService().findRoomtype(roomtype.getId()) ;
		hotelorder.setHotelid(hotel.getId());
		hotelorder.setRoomid(roomtype.getId());
		hotelorder.setRoomtypename(roomtype.getName());
		return "tobrowse" ;
	}
	
	/**
	 * 添加酒店预订并且转向到成功的页面
	 */
	public String dobook() throws Exception {
		//设置入住日期和离店日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		hotelorder.setComedate(new Timestamp(sdf.parse(startDate).getTime())) ;
		hotelorder.setLeavedate(new Timestamp(sdf.parse(endDate).getTime())) ;
		
		Customeruser user = getOrderUserLogin();
		if(user.getAgentid()==getagentId()){
			
			hotelorder.setType(1);
			
		}else{
			hotelorder.setType(3);
			
		}
		
		//设置价格
		hotelorder.setPrice(h_perprices) ;
		//设置预订的时间
		Calendar cal = Calendar.getInstance() ;
		cal.set(Calendar.MILLISECOND, 0) ;
		hotelorder.setPretime(new Timestamp(cal.getTimeInMillis())) ;
		//设置保留时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
		hotelorder.setReservstart(h_savestarttime) ;
		hotelorder.setReservend(h_saveendtime) ;
		//设置会员信息
		//member = Server.getInstance().getMemberService().findCustomeruser(hotelorder.getMemberid());
		member = getLoginUser();
		hotelorder.setMembername(member.getMembername()) ;
		//hotelorder.setType(1);
		hotelorder.setMembermobile(member.getMembermobile()) ;
		//设置入住人
		List<Guest> guests = new ArrayList<Guest>() ;
		if(h_guest != null) {
			for(String guest : h_guest) {
				Guest gbak = new Guest() ;
				gbak.setName(guest) ;
				guests.add(gbak) ;
			}
		}
		hotelorder.setGuests(guests) ;
		hotelorder = Server.getInstance().getHotelService().createHotelorder(hotelorder) ;
		temporderuserid=getOrderUserLogin().getId();
		ActionContext.getContext().getSession().remove("orderuserlogin");
		forward = "hotelbook!booksuccess.action?id=" + hotelorder.getId()+"&temporderuserid = "+temporderuserid ;
		return "booksuccess" ;
	}
	
	
	/**
	 * 收藏酒店
	 */
	/*public String  collection() throws Exception {
		String result = "" ;
		List<collection> listCollection = Server.getInstance().getCollectionManager().findAllCollection(" WHERE " + 
				Collection.COL_type + "=1" + " AND " + Collection.COL_objid + "=" + hotelorder.getHotelid() + " AND " 
				+ Collection.COL_memberid + "=" + this.getLoginUserId(), "", -1, 0) ;
		if(listCollection.size()  > 0) {
			result = "success" ;
		} else {
			Hotel hotelbak = Server.getInstance().getHotelManager().findHotel(hotelorder.getHotelid()) ;
			Collection collection = new Collection() ;
			collection.setType(new Integer(1)) ;
			collection.setObjid(hotelbak.getId()) ;
			collection.setCreatetime(new Timestamp(new Date().getTime())) ;
			collection.setMemberid(this.getLoginUserId()) ;
			collection.setTitle(hotelbak.getName()) ;
			Server.getInstance().getCollectionManager().createCollection(collection) ;
			result = "success" ;
		}
		HttpServletResponse response = ServletActionContext.getResponse() ;
		PrintWriter out = response.getWriter() ;
		out.print(result) ;
		out.flush() ;
		out.close() ;
		return "" ;
	}*/
	
	/**
	 * 得到预订的天数
	 */
	public String getBookDay(String comedate, String leavedate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		try {
			Date come = sdf.parse(comedate) ;
			Date leave = sdf.parse(leavedate) ;
			return new Long((leave.getTime() - come.getTime()) / (24*60*60*1000)).toString() ;
		} catch (ParseException e) {
		}
		return "" ;
	}
	
	/**
	 * 得到订单的总价格
	 */
	public Double getAllPrice(String price, Integer prerooms) {
		String[] prices = price.split("\\|") ;
		Double allPrice = new Double(0) ;
		for(String pri : prices) {
			allPrice += Double.parseDouble(pri) ;
		}
		return allPrice * prerooms.intValue() ;
	}
	
	/**
	 * 得到订单的每天的平均价格
	 */
	public Double getAveragePrice(String price) {
		String[] prices = price.split("\\|") ;
		Double allPrice = new Double(0) ;
		for(String pri : prices) {
			allPrice += Double.parseDouble(pri) ;
		}
		return allPrice / prices.length ;
	}
	
	public String getInterceptDesc(String desc) {
		if(desc != null) {
			if(desc.length() > 60) {
				return desc.substring(0, 60) ;
			} else {
				return desc ;
			}
		}
		return "" ;
	}
	
	public Object getModel() {
		return hotelorder;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Hotelorder getHotelorder() {
		return hotelorder;
	}

	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
	}

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}
	public Double getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(Double priceSum) {
		this.priceSum = priceSum;
	}

	public String getH_comedate() {
		return h_comedate;
	}

	public void setH_comedate(String h_comedate) {
		this.h_comedate = h_comedate;
	}

	public Long getH_hotelid() {
		return h_hotelid;
	}

	public void setH_hotelid(Long h_hotelid) {
		this.h_hotelid = h_hotelid;
	}

	public String getH_leavedate() {
		return h_leavedate;
	}

	public void setH_leavedate(String h_leavedate) {
		this.h_leavedate = h_leavedate;
	}

	public Long getH_roomtypeid() {
		return h_roomtypeid;
	}

	public void setH_roomtypeid(Long h_roomtypeid) {
		this.h_roomtypeid = h_roomtypeid;
	}

	public String getH_saveendtime() {
		return h_saveendtime;
	}

	public void setH_saveendtime(String h_saveendtime) {
		this.h_saveendtime = h_saveendtime;
	}

	public String getH_savestarttime() {
		return h_savestarttime;
	}

	public void setH_savestarttime(String h_savestarttime) {
		this.h_savestarttime = h_savestarttime;
	}

	public String getH_perprices() {
		return h_perprices;
	}

	public void setH_perprices(String h_perprices) {
		this.h_perprices = h_perprices;
	}

	public List<Guest> getGuestes() {
		return guestes;
	}

	public void setGuestes(List<Guest> guestes) {
		this.guestes = guestes;
	}

	public String[] getH_guest() {
		return h_guest;
	}

	public void setH_guest(String[] h_guest) {
		this.h_guest = h_guest;
	}

	public String getH_hotelname() {
		return h_hotelname;
	}

	public void setH_hotelname(String h_hotelname) {
		this.h_hotelname = h_hotelname;
	}

	public String getH_roomtypename() {
		return h_roomtypename;
	}

	public void setH_roomtypename(String h_roomtypename) {
		this.h_roomtypename = h_roomtypename;
	}


	public String getForward() {
		return forward;
	}


	public void setForward(String forward) {
		this.forward = forward;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public List<Hotel> getListHotel() {
		return listHotel;
	}


	public void setListHotel(List<Hotel> listHotel) {
		this.listHotel = listHotel;
	}


	public String getS_city() {
		return s_city;
	}


	public void setS_city(String s_city) {
		this.s_city = s_city;
	}

	/*public List<Genuser> getGenusers() {
		return genusers;
	}


	public void setGenusers(List<Genuser> genusers) {
		this.genusers = genusers;
	}*/


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


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public Customeruser getMember() {
		return member;
	}


	public void setMember(Customeruser member) {
		this.member = member;
	}


	public Long getTemporderuserid() {
		return temporderuserid;
	}


	public void setTemporderuserid(Long temporderuserid) {
		this.temporderuserid = temporderuserid;
	}


	public List<Customerpassenger> getListcustomerpassenger() {
		return listcustomerpassenger;
	}


	public void setListcustomerpassenger(
			List<Customerpassenger> listcustomerpassenger) {
		this.listcustomerpassenger = listcustomerpassenger;
	}




}
