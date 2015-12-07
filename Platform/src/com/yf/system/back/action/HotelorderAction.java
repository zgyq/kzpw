/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.roomtype.Roomtype;



public abstract class HotelorderAction extends B2b2cbackAction {
	
	/**
	 * 根据日期得到星期
	 */
	public List<String> getWeekHeader(Timestamp comedate) {
		String[] weeks = new String[]{"周日","周一","周二","周三","周四","周五","周六"} ;
		List<String> list = new ArrayList<String>() ;
		int week = 0 ;
		if(comedate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(comedate) ;
			week = cal.get(Calendar.DAY_OF_WEEK) ;
		}
		for(int i=week-1;i<7;i++) {
			list.add(weeks[i]) ;
		}
		for(int i=0;i<week-1;i++) {
			list.add(weeks[i]) ;
		}
		return list ;
	}
	

	
	/**
	 * 拆分价格
	 */
	public String[] getPrices(String price,Timestamp comedate) {
		Calendar comeCal = Calendar.getInstance() ;
		comeCal.setTime(new Date(comedate.getTime())) ;
		int week = comeCal.get(Calendar.DAY_OF_WEEK) ;
		String[] pricesBak = price.split("\\|") ;
		int len = pricesBak.length + week - 1 ;
		String[] allprices = new String[len];
		for(int i=week-1; i<len; i++) {
			allprices[i] = pricesBak[i-(week-1)] ;
		}
		return allprices ;
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
		return allPrice.doubleValue()*prerooms.intValue() ;
	}
	
	/**
	 * 根据ID查询房型
	 */
	public Roomtype getRoomtypeById(Long id) {
		return Server.getInstance().getHotelService().findRoomtype(id) ;
	}
	
	/**
	 * 根据ID查询酒店
	 */
	public Hotel getHotelById(Long id) {
		return Server.getInstance().getHotelService().findHotel(id) ;
	}
	
	/**
	 * 根据订单ID查询所有的入住人
	 */
	public List<Guest> getGuestByOrderId(Long orderId) {
		return Server.getInstance().getHotelService().findAllGuest(" WHERE " + Guest.COL_orderid + "=" + orderId, "", -1 , 0) ;
	}
	
	/**
	 * 得到保留时间
	 */
	public String getBaoliuTime(Timestamp start, Timestamp end) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm") ;
			return (sdf.format(start) + "至" + sdf.format(end));
		} catch (Exception e) {
			return "";
		}
	}
	/**
	 * 得到保留时间
	 */
	public Boolean getBalliuTime(Timestamp start, String str) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm") ;
			return sdf.format(start).equals(str) ;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 预订成功通知用户
	 * @throws Exception 
	 */
	/*public void noticeUser(Hotelorder hotelorder) throws Exception {
		if(hotelorder.getConfirmmethod().intValue() == 1) {
			sendSms(hotelorder) ;
		} else if(hotelorder.getConfirmmethod().intValue() == 2) {
			sendMail(hotelorder) ;
		} else if(hotelorder.getConfirmmethod().intValue() == 3) {
			sendMail(hotelorder) ;
			sendSms(hotelorder) ;
		}
	}*/
	
/*	private void sendMail(Hotelorder hotelorder) throws Exception {
		Mail mail = new Mail() ;
		Hotel hotel = Server.getInstance().getHotelManager().findHotel(hotelorder.getHotelid()) ;
		Map templetekey = new HashMap() ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		templetekey.put("comedate",sdf.format(hotelorder.getComedate())) ;
		templetekey.put("leavedate",sdf.format(hotelorder.getLeavedate())) ;
		templetekey.put("hotelname", hotelorder.getName()) ;
		templetekey.put("preroomnum",hotelorder.getPrerooms().toString()) ;
		templetekey.put("roomtypename",hotelorder.getRoomtypename()) ;
		templetekey.put("hoteladdress",hotel.getAddress()) ;
		templetekey.put("hoteltel",hotel.getTortell()) ;
		templetekey.put("hotelorderid", new Long(hotelorder.getId()).toString()) ;
		Mailtemplete mailtemplete = Server.getInstance().getInterfaceService().findMailtemplete(10) ;
		String content = SimpleTemplate.randText(templetekey, mailtemplete.getContent()) ;
		mail.setTomails(hotelorder.getLinkmail()) ;
		mail.setCreatetime(new Timestamp(new Date().getTime())) ;
		mail.setSendtime(new Timestamp(new Date().getTime())) ;
		mail.setTonames(hotelorder.getMembername()) ;
		mail.setContent(content) ;
		try {
			Server.getInstance().getAtomServiceProject().sendMail(mail) ;
		}catch(Exception e) {
			hotelorder.setResultcode(new Integer(3)) ;
			Server.getInstance().getHotelorderManager().updateHotelorderIgnoreNull(hotelorder) ;
		}
		//SendMailSupport.send(mail) ;
	}
	*/
/*	private void sendSms(Hotelorder hotelorder) throws Exception {
		Hotel hotel = Server.getInstance().getHotelManager().findHotel(hotelorder.getHotelid()) ;
		Map templetekey = new HashMap() ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		templetekey.put("comedate",sdf.format(hotelorder.getComedate())) ;
		templetekey.put("leavedate",sdf.format(hotelorder.getLeavedate())) ;
		templetekey.put("hotelname", hotelorder.getName()) ;
		templetekey.put("preroomnum",hotelorder.getPrerooms().toString()) ;
		templetekey.put("roomtypename",hotelorder.getRoomtypename()) ;
		templetekey.put("hoteladdress",hotel.getAddress()) ;
		templetekey.put("hoteltel",hotel.getTortell()) ;
		templetekey.put("hotelorderid", new Long(hotelorder.getId()).toString()) ;
		IAtomService atomService = Server.getInstance().getAtomServiceProject() ;
		Mailtemplete mailtemplete = Server.getInstance().getInterfaceService().findMailtemplete(10) ;
		String content = SimpleTemplate.randText(templetekey, mailtemplete.getContent()) ;
		try {
			atomService.sendSms(new String[]{hotelorder.getLinkmobile()}, content) ;
		} catch(Exception e) {
			hotelorder.setResultcode(new Integer(3)) ;
			Server.getInstance().getHotelorderManager().updateHotelorderIgnoreNull(hotelorder) ;
		}
	}*/
	
	/**
	 * 判断传真发送后，在20分钟内是否回复
	 */
	public boolean sendFaxTimeLarge20(Timestamp sendTime) {
		if(new Date().getTime() - sendTime.getTime() >= 20*60*1000) {
			return true ;
		}
		return false ;
	}
	
	/**
	 * 添加订单的操作记录
	 * @throws SQLException 
	 */
	public void createHotelorderrc(Hotelorder hotelorder, String handleuser, String content) throws SQLException {
		Hotelorderrc horrc = new Hotelorderrc() ;
		horrc.setOrderid(hotelorder.getId()) ;
		if(handleuser != null && handleuser.trim().length() > 0) {
			horrc.setHandleuser(handleuser) ;
		} else {
			horrc.setHandleuser(this.getLoginUser().getLoginname()) ;
		}
		horrc.setLinktell(this.getLoginUser().getMobile()) ;
		horrc.setState(new Integer(1)) ;
		horrc.setContent(content) ;
		horrc.setDescription(hotelorder.getCheckdesc()) ;
		horrc.setCreatetime(new Timestamp(new Date().getTime())) ;
		Server.getInstance().getHotelService().createHotelorderrc(horrc) ;
	}
	
	/**
	 * url编码
	 * @param str
	 * @return
	 */
	public String getUrlEncode(String str) {
		try {
			return URLEncoder.encode(str, "GBK") ;
		} catch (UnsupportedEncodingException e) {
			
		}
		return str ;
	}
	
	/**
	 * url解码
	 * @param str
	 * @return
	 */
	public String getUrlDecode(String str) {
		try {
			return URLDecoder.decode(str, "GBK") ;
		} catch (UnsupportedEncodingException e) {
			
		}
		return str ;
	}
	
	/**
	 *  查询用户
	 * @param id
	 * @return
	 */
	public Customeruser getSystemUser(long id) {
		
		return Server.getInstance().getMemberService().findCustomeruser(id) ;
	}
	
	/**
	 * 查询用户的公司名称
	 */
	/*public Company getCompany(long memberid) {
		return Server.getInstance().getCompanyManager().findCompany(Server.getInstance().getMemberManager().findMember(memberid).getCompanyid()) ;
	}*/
}