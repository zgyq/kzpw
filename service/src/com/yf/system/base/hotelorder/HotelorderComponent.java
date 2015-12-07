/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
 
package com.yf.system.base.hotelorder;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import com.yf.system.base.guest.Guest;
import com.yf.system.base.guest.IGuestManager;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotel.IHotelManager;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.hotelorderrc.IHotelorderrcManager;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.hotelprice.IHotelpriceManager;
import com.yf.system.base.roomstate.IRoomstateManager;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomstateback.IRoomstatebackManager;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.IRoomtypeManager;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.servicecenter.IServicecenterComponent;
import com.yf.system.base.util.PageInfo;



public class HotelorderComponent implements IHotelorderComponent{ 
	
	private IHotelManager hotelManager ;
	
	private IRoomtypeManager roomtypeManager ;
	
	private IRoomstateManager roomstateManager ;
	
	private IRoomstatebackManager roomstatebackManager ;
	
	private IHotelpriceManager hotelpriceManager ;
	
	private IGuestManager guessManager ;
	
	//private IGenuserManager genuserManager ;
	
	private IHotelorderManager hotelorderManager;
	
	private IHotelorderrcManager hotelorderrrManager ;
	
	private IServicecenterComponent servicecenterComponent ;
	
	private Map<Long, Long> cache = new HashMap<Long, Long>() ;
   
	public synchronized void update(Long id, Long num) {
		if(cache.containsKey(id)) {
			cache.put(id, cache.get(id) + num) ;
		} else {
			String where = " WHERE C_HOTELID=" + id + " AND C_VERSION>0 AND C_STATE=3" ;
			int count = this.hotelorderManager.countHotelorderBySql("select count(*) FROM " + Hotelorder.TABLE  + where) ;
			cache.put(id, count + num) ;
		}
	}
	
	public Long findHotelCinfirmOrderNum(Long id) {
		if(cache.get(id) == null) {
			String where = " WHERE C_HOTELID=" + id + " AND C_VERSION>0 AND C_STATE=3" ;
			int count = this.hotelorderManager.countHotelorderBySql("select count(*) FROM " + Hotelorder.TABLE  + where) ;
			cache.put(id, new Long(count)) ;
		}
		return cache.get(id) ;
	}
	
 	/**
	 * 创建 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorder createHotelorder(Hotelorder hotelorder) throws SQLException{
		//设置酒店的名称
		//Hotel hotel = this.hotelManager.findHotel(hotelorder.getHotelid()) ;
		//hotelorder.setName(hotel.getName()) ;
		//设置房型的名称
		
			//Roomtype roomtype = this.roomtypeManager.findRoomtype(hotelorder.getRoomid()) ;
			//hotelorder.setRoomtypename(roomtype.getName()) ;
		
	
		//默认的版本号
		hotelorder.setVersion(new Integer(1)) ;
		//设置订单的状态为待审核
		hotelorder.setState(new Integer(1)) ;
		//设置预订的时间
		Calendar cal = Calendar.getInstance() ;
		cal.set(Calendar.MILLISECOND, 0) ;
		hotelorder.setPretime(new Timestamp(cal.getTimeInMillis())) ;
		this.hotelorderManager.createHotelorder(hotelorder) ;
		String hotelordernumber = this.servicecenterComponent.getHotelorderCode(hotelorder) ;
		hotelorder.setOrderid(hotelordernumber) ;
		this.hotelorderManager.updateHotelorderIgnoreNull(hotelorder) ;
		//设置入住人
		if(hotelorder.getGuests() != null) {
			for(Guest guest : hotelorder.getGuests()) {
				guest.setOrderid(hotelorder.getId()) ;
				this.guessManager.createGuest(guest) ;
			}
		}
		//保存入住人到常用入住人中
//		if(hotelorder.getGuests() != null) {
//			for(Guest guest : hotelorder.getGuests()) {
//				String where = " WHERE " + Genuser.COL_name + "='" 
//					+ guest.getName().trim() + "' AND " + Genuser.COL_type + "=1" + " AND " 
//					+ Genuser.COL_member + "=" + hotelorder.getMemberid() ;
//				List<Genuser> genusers = this.genuserManager.findAllGenuser(where, "", -1, 0) ;
//				if(genusers.size() == 0) {
//					Genuser genuser = new Genuser() ;
//					genuser.setMember(hotelorder.getMemberid()) ;
//					genuser.setName(guest.getName()) ;
//					genuser.setType(new Integer(1)) ;
//					genuser.setState(new Integer(1)) ;
//					genuser.setCreatetime(new Timestamp(new Date().getTime())) ;
//					this.genuserManager.createGenuser(genuser) ;
//				}
//			}
//		}
		return hotelorder ;
	}
	
	public Hotelorder executeAuditing(Hotelorder hotelorder, String username, String mobile) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
		Hotelorder hotelorderBak = this.hotelorderManager.findHotelorder(hotelorder.getId()) ; 
		//订单审核
		if(hotelorderBak.getState().intValue() == 1) {
			if(hotelorder.getState().intValue() == 2) {
				//添加操作订单的记录
				Hotelorderrc hotelorderrc = new Hotelorderrc() ;
				hotelorderrc.setContent("审核订单未通过") ;
				hotelorderrc.setHandleuser(username) ;
				hotelorderrc.setLinktell(mobile) ;
				hotelorderrc.setOrderid(hotelorder.getId()) ;
				hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
				hotelorderrc.setState(new Integer(1)) ;
				hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
				this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
			} else if(hotelorder.getState().intValue() == 3) {
			//订单审核通过
				//添加操作订单的记录
				Hotelorderrc hotelorderrc = new Hotelorderrc() ;
				hotelorderrc.setContent("审核订单已通过") ;
				hotelorderrc.setHandleuser(username) ;
				hotelorderrc.setLinktell(mobile) ;
				hotelorderrc.setOrderid(hotelorder.getId()) ;
				hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
				hotelorderrc.setState(new Integer(1)) ;
				hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
				this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
				//验证该酒店的房型是否是满房(1代表预留房, 2代表满房)
				String where = " WHERE " + Roomstate.COL_roomtypeid + "=" + hotelorderBak.getRoomid() ;
					where += " AND " + Roomstate.COL_state + "=2 " + " AND (" 
					+ "(" + Roomstate.COL_startdate + ">=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getComedate().getTime())) + "')" + " AND " 
					+ Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getLeavedate().getTime())) + "'))"
					+ " OR (" + Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getComedate().getTime()))  + "')" + " AND " 
					+ Roomstate.COL_enddate + "<=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getLeavedate().getTime()))  + "'))"
					+ " OR (" + Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getComedate().getTime())) + "')" + " AND " 
					+ Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getLeavedate().getTime()))  + "'))"
					+ ")" ;
				List<Roomstate> listRoomstates = this.roomstateManager.findAllRoomstate(where,"", -1, 0) ;
				//查询到结果判断为满房
				if(listRoomstates != null && listRoomstates.size() > 0) {
					//添加操作订单的记录
					Hotelorderrc hotelorderrc1 = new Hotelorderrc() ;
					hotelorderrc1.setContent("自动确认订单已满房") ;
					hotelorderrc1.setHandleuser("系统") ;
					hotelorderrc1.setLinktell(null) ;
					hotelorderrc1.setOrderid(hotelorder.getId()) ;
					hotelorderrc1.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc1.setState(new Integer(1)) ;
					hotelorderrc1.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc1) ;
					hotelorder.setState(new Integer(5)) ; //设置订单为满房状态
				} else {
				//验证该酒店的房型是否存在预留房(如果存在预留房直接确认)
					//根据入住日期和离店日期查询预订房的状态
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM") ;
					Calendar leaveCalBak = Calendar.getInstance() ;
					leaveCalBak.setTime(hotelorderBak.getLeavedate()) ;
					leaveCalBak.add(Calendar.DAY_OF_MONTH, -1) ;
					where = " WHERE " + Roomstateback.COL_hotelid + "=" + hotelorderBak.getHotelid() + " AND " +
					Roomstateback.COL_roomid + "=" + hotelorderBak.getRoomid() + " AND " + 
					Roomstateback.COL_datenumber + ">='" + sdf.format(hotelorderBak.getComedate()) + "' AND " +
					Roomstateback.COL_datenumber + "<='" + sdf.format(leaveCalBak.getTime()) + "'" ;
					List<Roomstateback> listRoomstateback = this.roomstatebackManager.findAllRoomstateback(where ,
							" ORDER BY " + Roomstateback.COL_datenumber, -1 , 0)	;
					Calendar comeCal = Calendar.getInstance();
					comeCal.setTime(hotelorderBak.getComedate()) ;
					Calendar leaveCal = Calendar.getInstance() ;
					leaveCal.setTime(hotelorderBak.getLeavedate()) ;
					//判断是否存在预留房
					if(listRoomstateback.size() > 0) {
						//判断第一天是新增还是累计
						where = " WHERE " + Roomstate.COL_roomtypeid + "=" + hotelorderBak.getRoomid() ;
						where += " AND " + Roomstate.COL_state + "=1 " + " AND " + Roomstate.COL_startdate + "<=" + 
							"CONVERT(date, '" + format.format(new Date(hotelorderBak.getComedate().getTime())) + "')" + " AND " 
							+ Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + format.format(new Date(hotelorderBak.getComedate().getTime())) 
							+ "')";
						listRoomstates = this.roomstateManager.findAllRoomstate(where," ORDER BY " + 
								Roomstate.COL_createtime , -1, 0) ;
						//判断是否存在预留房
						if(listRoomstates.size() > 0) {
							Roomstate roomstate = listRoomstates.get(0) ;
							//新增
							if(roomstate.getType().intValue() == 2) {
								for(Iterator<Roomstateback> iterback = listRoomstateback.iterator(); iterback.hasNext();) {
									Roomstateback roomstateback = iterback.next() ;
									if(sdf.format(hotelorderBak.getComedate()).equals(roomstateback.getDatenumber())) {
										int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
										Method getNoMethod = roomstateback.getClass().getMethod("getNo" + day) ;
										Method getBackMethod = roomstateback.getClass().getMethod("getBack" + day) ;
										Integer no = (Integer)getNoMethod.invoke(roomstateback, new Object[]{}) ;
										Integer back = (Integer)getBackMethod.invoke(roomstateback, new Object[]{}) ;
										//判断预订房是否足够
										if(no != null) {
											Method setBackMethod = roomstateback.getClass().getMethod("setBack" + day, Integer.class) ;
											if(back == null) {
												back = new Integer(0) ;
											}
											if(no.intValue() >= (back.intValue() + hotelorderBak.getPrerooms().intValue())) {
												setBackMethod.invoke(roomstateback, new Object[]{new Integer(back.intValue() + 
														hotelorderBak.getPrerooms().intValue())}) ;
												if(roomstate.getConfirmmethod().intValue() == 0) {
													//添加操作订单的记录
													Hotelorderrc hotelorderrc1 = new Hotelorderrc() ;
													hotelorderrc1.setContent("自动操作订单已确认") ;
													hotelorderrc1.setHandleuser("系统") ;
													hotelorderrc1.setLinktell(null) ;
													hotelorderrc1.setOrderid(hotelorder.getId()) ;
													hotelorderrc1.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
													hotelorderrc1.setState(new Integer(1)) ;
													hotelorderrc1.setDescription(hotelorder.getCheckdesc()) ;
													this.hotelorderrrManager.createHotelorderrc(hotelorderrc1) ;
													hotelorder.setState(new Integer(12)) ;
												}
											} else {
												setBackMethod.invoke(roomstateback, new Object[]{no}) ;
											}
											this.roomstatebackManager.updateRoomstatebackIgnoreNull(roomstateback) ;
										}
										break ;
									}
								}
							} else if(roomstate.getType().intValue() == 1) {
							//累计	
								boolean isAll = true ;
								while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
									int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
									String datenumber = sdf.format(comeCal.getTime()) ;
									boolean isPart = false ;
									for(Iterator<Roomstateback> iterback = listRoomstateback.iterator(); iterback.hasNext();) {
										Roomstateback roomstateback = iterback.next() ;
										if(datenumber.equals(roomstateback.getDatenumber())) {
											Method getNoMethod = roomstateback.getClass().getMethod("getNo" + day) ;
											Method getBackMethod = roomstateback.getClass().getMethod("getBack" + day) ;
											Integer no = (Integer)getNoMethod.invoke(roomstateback, new Object[]{}) ;
											Integer back = (Integer)getBackMethod.invoke(roomstateback, new Object[]{}) ;
											//判断预订房是否足够
											if(no != null) {
												Method setBackMethod = roomstateback.getClass().getMethod("setBack" + day, Integer.class) ;
												if(back == null) {
													back = new Integer(0) ;
												}
												if(no.intValue() >= (back.intValue() + hotelorderBak.getPrerooms().intValue())) {
													setBackMethod.invoke(roomstateback, new Object[]{new Integer(back.intValue() + 
															hotelorderBak.getPrerooms().intValue())}) ;
													isPart = true ;
												} else {
													setBackMethod.invoke(roomstateback, new Object[]{no}) ;
												}
												this.roomstatebackManager.updateRoomstatebackIgnoreNull(roomstateback) ;
											}
										} 
									}
									if(!isPart) {
										isAll = false ;
									}
									comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
								} //comeCal.getTimeInMillis() <= leaveCal.getTimeInMillis()
								if(isAll) {
									if(roomstate.getConfirmmethod().intValue() == 0) {
										//添加操作订单的记录
										Hotelorderrc hotelorderrc1 = new Hotelorderrc() ;
										hotelorderrc1.setContent("自动操作订单已确认") ;
										hotelorderrc1.setHandleuser("系统") ;
										hotelorderrc1.setLinktell(null) ;
										hotelorderrc1.setOrderid(hotelorder.getId()) ;
										hotelorderrc1.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
										hotelorderrc1.setState(new Integer(1)) ;
										hotelorderrc1.setDescription(hotelorder.getCheckdesc()) ;
										this.hotelorderrrManager.createHotelorderrc(hotelorderrc1) ;
										hotelorder.setState(new Integer(12)) ;
									}
								}
							}
						}
					}
				}
			} else if(hotelorder.getState().intValue() == 9) {
				//取消订单
				if(hotelorder.getCanclereason().intValue() == 1) {
				//客人取消订单
					Hotelorderrc hotelorderrc1 = new Hotelorderrc() ;
					hotelorderrc1.setContent("操作订单已被客户取消") ;
					hotelorderrc1.setHandleuser(username) ;
					hotelorderrc1.setLinktell(mobile) ;
					hotelorderrc1.setOrderid(hotelorder.getId()) ;
					hotelorderrc1.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc1.setState(new Integer(1)) ;
					hotelorderrc1.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc1) ;
				} else if(hotelorder.getCanclereason() == 2) {
				//酒店取消订单
					Hotelorderrc hotelorderrc1 = new Hotelorderrc() ;
					hotelorderrc1.setContent("操作订单已被客户取消") ;
					hotelorderrc1.setHandleuser(username) ;
					hotelorderrc1.setLinktell(mobile) ;
					hotelorderrc1.setOrderid(hotelorder.getId()) ;
					hotelorderrc1.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc1.setState(new Integer(1)) ;
					hotelorderrc1.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc1) ;
				}
			}
		}
		hotelorder.setFaxsendtime(new Timestamp(System.currentTimeMillis())) ;
		this.hotelorderManager.updateHotelorderIgnoreNull(hotelorder) ;
		this.update(hotelorderBak.getHotelid(), new Long(1)) ;
		return hotelorder ;
	}
	
	/**
	 * 确认 酒店订单
	 */
	public Hotelorder executeCimfirm(Hotelorder hotelorder, String username, String mobile) throws Exception {
		Hotelorder hotelorderBak = this.hotelorderManager.findHotelorder(hotelorder.getId()) ;
		//确认
		if(hotelorderBak.getState().intValue() == 3) {
			//确认
			if(hotelorder.getState().intValue() == 4) {
				if(hotelorder.getGuests() != null) {
					for(Guest guest : hotelorder.getGuests()) {
						this.guessManager.updateGuestIgnoreNull(guest) ;
					}
				}
				Hotelorderrc hotelorderrc = new Hotelorderrc() ;
				hotelorderrc.setContent("操作订单已确认") ;
				hotelorderrc.setHandleuser(username) ;
				hotelorderrc.setLinktell(mobile) ;
				hotelorderrc.setOrderid(hotelorder.getId()) ;
				hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
				hotelorderrc.setState(new Integer(1)) ;
				hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
				this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
			} else if(hotelorder.getState().intValue() == 10) {
			//取消订单
				if(hotelorder.getCanclereason().intValue() == 1) {
				//客人取消订单
					Hotelorderrc hotelorderrc = new Hotelorderrc() ;
					hotelorderrc.setContent("操作订单已被客户取消") ;
					hotelorderrc.setHandleuser(username) ;
					hotelorderrc.setLinktell(mobile) ;
					hotelorderrc.setOrderid(hotelorder.getId()) ;
					hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc.setState(new Integer(1)) ;
					hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
				} else if(hotelorder.getCanclereason() == 2) {
				//酒店取消订单
					Hotelorderrc hotelorderrc = new Hotelorderrc() ;
					hotelorderrc.setContent("操作订单已被酒店取消") ;
					hotelorderrc.setHandleuser(username) ;
					hotelorderrc.setLinktell(mobile) ;
					hotelorderrc.setOrderid(hotelorder.getId()) ;
					hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc.setState(new Integer(1)) ;
					hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
				}
			} else if(hotelorder.getState().intValue() == 5) {
			//满房
				Hotelorderrc hotelorderrc = new Hotelorderrc() ;
				hotelorderrc.setContent("确认订单已满房") ;
				hotelorderrc.setHandleuser(username) ;
				hotelorderrc.setLinktell(mobile) ;
				hotelorderrc.setOrderid(hotelorder.getId()) ;
				hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
				hotelorderrc.setState(new Integer(1)) ;
				hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
				this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
			} 
			this.hotelorderManager.updateHotelorderIgnoreNull(hotelorder) ;
			this.update(hotelorderBak.getHotelid(), new Long(-1)) ;
		}
		hotelorderBak.setState(hotelorder.getState()) ;
		return hotelorderBak ;
	}
	
	/**
	 * 确认入住 酒店订单
	 */
	public Hotelorder executePutoff(Hotelorder hotelorder, String username, String mobile) throws Exception {
		Hotelorder hotelorderBak = this.hotelorderManager.findHotelorder(hotelorder.getId()) ;
		if(hotelorderBak.getState().intValue() == 4) {
			if(hotelorder.getState().intValue() == 8) {
				Hotelorderrc hotelorderrc = new Hotelorderrc() ;
				hotelorderrc.setContent("确认入住已No Show") ;
				hotelorderrc.setHandleuser(username) ;
				hotelorderrc.setLinktell(mobile) ;
				hotelorderrc.setOrderid(hotelorder.getId()) ;
				hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
				hotelorderrc.setState(new Integer(1)) ;
				hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
				this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
			} else if(hotelorder.getState().intValue() == 11) {
			//取消订单
				if(hotelorder.getCanclereason().intValue() == 1) {
				//客人取消订单
					Hotelorderrc hotelorderrc = new Hotelorderrc() ;
					hotelorderrc.setContent("操作订单已被客户取消") ;
					hotelorderrc.setHandleuser(username) ;
					hotelorderrc.setLinktell(mobile) ;
					hotelorderrc.setOrderid(hotelorder.getId()) ;
					hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc.setState(new Integer(1)) ;
					hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
				} else if(hotelorder.getCanclereason() == 2) {
				//酒店取消订单
					Hotelorderrc hotelorderrc = new Hotelorderrc() ;
					hotelorderrc.setContent("操作订单已被酒店取消") ;
					hotelorderrc.setHandleuser(username) ;
					hotelorderrc.setLinktell(mobile) ;
					hotelorderrc.setOrderid(hotelorder.getId()) ;
					hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis())) ;
					hotelorderrc.setState(new Integer(1)) ;
					hotelorderrc.setDescription(hotelorder.getCheckdesc()) ;
					this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
				}
			} 
		}
		this.hotelorderManager.updateHotelorderIgnoreNull(hotelorder) ;
		return hotelorder ;
	}
	
	/**
	 * 删除 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorder(long id){
	
		return hotelorderManager.deleteHotelorder(id);
	}
	
	
	/**
	 * 修改 酒店订单
	 * @param id
	 * @return updated count 
	 * @throws  
	 * @throws Exception 
	 */
	public int updateHotelorder(Hotelorder hotelorder) throws Exception {
		Hotelorder hotelorderBak = this.hotelorderManager.findHotelorder(hotelorder.getId()) ;
		if(hotelorderBak.getState().intValue() == 3) {
			this.update(hotelorderBak.getHotelid(), new Long(-1)) ;
		}
		if((hotelorder.getRoomid() != null && hotelorder.getComedate() != null && hotelorder.getLeavedate() != null) && 
				(!hotelorderBak.getRoomid().equals(hotelorder.getRoomid())
				|| !hotelorderBak.getComedate().equals(hotelorder.getComedate()) || 
				!hotelorderBak.getLeavedate().equals(hotelorder.getLeavedate()))) {
			//设置房型的名称
			Roomtype roomtype = this.roomtypeManager.findRoomtype(hotelorder.getRoomid()) ;
			hotelorderBak.setRoomtypename(roomtype.getName()) ;
			hotelorderBak.setRoomid(hotelorder.getRoomid()) ;
			//设置入住日期和离店日期
			hotelorderBak.setComedate(hotelorder.getComedate()) ;
			hotelorderBak.setLeavedate(hotelorder.getLeavedate()) ;
			//设置价格
			Calendar comeCal = Calendar.getInstance() ;
			comeCal.setTime(hotelorder.getComedate()) ;
			Calendar leaveCal = Calendar.getInstance() ;
			leaveCal.setTime(hotelorder.getLeavedate()) ;
			String comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
					"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
			String leaveStr = leaveCal.get(Calendar.YEAR) + "-" + (leaveCal.get(Calendar.MONTH) > 8 ? 
					"" + (leaveCal.get(Calendar.MONTH) + 1) : "0" + (leaveCal.get(Calendar.MONTH)+1)) ;
			String where = " WHERE " + Hotelprice.COL_datenumber + ">='" + 
				comeStr + "' AND " + Hotelprice.COL_datenumber + "<='" +leaveStr + "' AND " + Hotelprice.COL_roomid +
				"=" + hotelorderBak.getRoomid() ;
			List<Hotelprice> prices = this.hotelpriceManager.findAllHotelprice(where, " ORDER BY " + Hotelprice.COL_datenumber, -1, 0) ;
			StringBuffer buf = new StringBuffer("") ;
			while(comeCal.getTimeInMillis() < leaveCal.getTimeInMillis()) {
				int day = comeCal.get(Calendar.DAY_OF_MONTH) ;
				//是否设置值
				Float priceValue = 0f ;
				//是否被禁用
				boolean isbid = false ;
				for(Iterator<Hotelprice> iterator = prices.iterator(); iterator.hasNext(); ) {
					Hotelprice price = iterator.next() ;
					if(price.getDatenumber().equals(comeStr)) {
						Method method = price.getClass().getMethod("getNo" + day, new Class[]{}) ;
						priceValue = (Float)method.invoke(price, new Object[]{}) ;
						//判断该日期的价格是否被禁用
						if(price.getIsvalid().charAt(day-1) == '1') {
							isbid = true ;
						}
						break ;
					}
				}
				if(isbid) {
					buf = new StringBuffer("") ;
					break ;
				}
				buf.append(priceValue + "|") ;
				comeCal.add(Calendar.DAY_OF_MONTH, 1) ;
				comeStr = comeCal.get(Calendar.YEAR) + "-" + (comeCal.get(Calendar.MONTH) > 8 ? 
						"" + (comeCal.get(Calendar.MONTH) + 1) : "0" + (comeCal.get(Calendar.MONTH)+1)) ;
			}
			if(buf.length() > 0) {
				hotelorderBak.setPrice(buf.substring(0, buf.length() - 1)) ;
			}
		}
		//默认的版本号
		hotelorderBak.setVersion(new Integer(2)) ;
		//设置订单的状态为待审核
		hotelorderBak.setState(new Integer(1)) ;
		//设置预订的时间
		Calendar cal = Calendar.getInstance() ;
		cal.set(Calendar.MILLISECOND, 0) ;
		hotelorderBak.setPretime(new Timestamp(cal.getTimeInMillis())) ;
		//设置保留时间
		hotelorderBak.setReservstart(hotelorder.getReservstart()) ;
		hotelorderBak.setReservend(hotelorder.getReservend()) ;
		//联系人
		hotelorderBak.setLinkname(hotelorder.getLinkname()) ;
		hotelorderBak.setLinkmobile(hotelorder.getLinkmobile()) ;
		hotelorderBak.setLinkmail(hotelorder.getLinkmail()) ;
		hotelorderBak.setLinktell(hotelorder.getLinktell()) ;
		hotelorderBak.setConfirmmethod(hotelorder.getConfirmmethod()) ;
		hotelorderBak.setFaxsendtime(null) ;
		hotelorderBak.setCanclereason(null) ;
		hotelorderBak.setManyday(null) ;
		hotelorderBak.setSpecreq(hotelorder.getSpecreq()) ;
		hotelorderBak.setPredesc(hotelorder.getPredesc()) ;
		hotelorderBak.setCheckdesc(null) ;
		hotelorderBak.setPrerooms(hotelorder.getPrerooms()) ;
		hotelorderBak.setId(0) ;
		this.hotelorderManager.createHotelorder(hotelorderBak) ;
		//设置入住人
		if(hotelorder.getGuests() != null) {
			for(Guest guest : hotelorder.getGuests()) {
				guest.setOrderid(hotelorderBak.getId()) ;
				this.guessManager.createGuest(guest) ;
			}
		}
		//变更原来的版面号
		Hotelorder ho = new Hotelorder();
		ho.setId(hotelorder.getId()) ;
		ho.setVersion(new Integer(0)) ;
		this.hotelorderManager.updateHotelorderIgnoreNull(ho) ;
		Hotelorderrc hotelorderrc = new Hotelorderrc() ;
		hotelorderrc.setCreatetime(new Timestamp(new Date().getTime())) ;
		hotelorderrc.setOrderid(hotelorder.getId()) ;
		hotelorderrc.setContent("变更订单") ;
		hotelorderrc.setHandleuser(hotelorder.getOpsername()) ;
		hotelorderrc.setLinktell(hotelorder.getOpmobile()) ;
		this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
		return 1 ;
	}

	/**
	 * 取消订单
	 * @param hotelorder
	 * @return
	 * @throws Exception
	 */
	public Hotelorder executeCannel(Hotelorder hotelorder) throws Exception {
		Hotelorder hotelorderbak = this.hotelorderManager.findHotelorder(hotelorder.getId()) ;
		boolean isCannel = false ;
		if(hotelorderbak.getState().intValue() == 1) {
			//待审核
			hotelorder.setState(new Integer(9)) ;
			isCannel = true ;
		} else if(hotelorderbak.getState().intValue() == 3) {
			//待确认
			hotelorder.setState(new Integer(10)) ;
			isCannel = true ;
		} else if(hotelorderbak.getState().intValue() == 4 || hotelorderbak.getState().intValue() == 12) {
			//待入住确认
			hotelorder.setState(new Integer(11)) ;
			isCannel = true ;
		}
		//添加订单操作记录
		if(isCannel) {
			Hotelorderrc hotelorderrc = new Hotelorderrc() ;
			hotelorderrc.setCreatetime(new Timestamp(new Date().getTime())) ;
			hotelorderrc.setOrderid(hotelorder.getId()) ;
			hotelorderrc.setContent("取消订单") ;
			hotelorderrc.setHandleuser(hotelorder.getOpsername()) ;
			hotelorderrc.setLinktell(hotelorder.getOpmobile()) ;
			this.hotelorderrrManager.createHotelorderrc(hotelorderrc) ;
			this.hotelorderManager.updateHotelorderIgnoreNull(hotelorder) ;
		}
		if(hotelorder.getState() == 10) {
			this.update(hotelorderbak.getHotelid(), new Long(-1)) ;
		}
		return hotelorderbak ;
	}
	
	/**
	 * 修改 酒店订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderIgnoreNull(Hotelorder hotelorder){
			return hotelorderManager.updateHotelorderIgnoreNull(hotelorder);
	
	}
	
	/**
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,int limit,int offset){
		return hotelorderManager.findAllHotelorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店订单
	 * @param id
	 * @return
	 */
	public Hotelorder findHotelorder(long id){
		return hotelorderManager.findHotelorder(id);
	}
	
	/** 
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,PageInfo pageinfo){
		return hotelorderManager.findAllHotelorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String sql,int limit,int offset){
		return hotelorderManager.findAllHotelorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderBySql(String sql){
		return hotelorderManager.excuteHotelorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderBySql(String sql){
		return hotelorderManager.countHotelorderBySql(sql);
	}
	
	public IHotelManager getHotelManager() {
		return hotelManager;
	}
	public void setHotelManager(IHotelManager hotelManager) {
		this.hotelManager = hotelManager;
	}
	public IRoomtypeManager getRoomtypeManager() {
		return roomtypeManager;
	}
	public void setRoomtypeManager(IRoomtypeManager roomtypeManager) {
		this.roomtypeManager = roomtypeManager;
	}
	public IGuestManager getGuessManager() {
		return guessManager;
	}
	public void setGuessManager(IGuestManager guessManager) {
		this.guessManager = guessManager;
	}
//	public IGenuserManager getGenuserManager() {
//		return genuserManager;
//	}
//	public void setGenuserManager(IGenuserManager genuserManager) {
//		this.genuserManager = genuserManager;
//	}
	public IHotelorderManager getHotelorderManager() {
		return hotelorderManager;
	}
	public void setHotelorderManager(IHotelorderManager hotelorderManager) {
		this.hotelorderManager = hotelorderManager;
	}

	public IRoomstateManager getRoomstateManager() {
		return roomstateManager;
	}

	public void setRoomstateManager(IRoomstateManager roomstateManager) {
		this.roomstateManager = roomstateManager;
	}

	public IRoomstatebackManager getRoomstatebackManager() {
		return roomstatebackManager;
	}

	public void setRoomstatebackManager(IRoomstatebackManager roomstatebackManager) {
		this.roomstatebackManager = roomstatebackManager;
	}

	public IHotelorderrcManager getHotelorderrrManager() {
		return hotelorderrrManager;
	}

	public void setHotelorderrrManager(IHotelorderrcManager hotelorderrrManager) {
		this.hotelorderrrManager = hotelorderrrManager;
	}

	public IHotelpriceManager getHotelpriceManager() {
		return hotelpriceManager;
	}

	public void setHotelpriceManager(IHotelpriceManager hotelpriceManager) {
		this.hotelpriceManager = hotelpriceManager;
	}

	public IServicecenterComponent getServicecenterComponent() {
		return servicecenterComponent;
	}

	public void setServicecenterComponent(
			IServicecenterComponent servicecenterComponent) {
		this.servicecenterComponent = servicecenterComponent;
	}
	
}

