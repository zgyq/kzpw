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

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.back.server.Server;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class RoomstateAction extends B2b2cbackAction {
	private List listRoomstate;

	private Roomstate roomstate = new Roomstate();

	private List<Roomtype> listroomtypes;

	private Roomtype roomtype;

	private Hotel hotel;

	private Long hotelId; //酒店id

	private String hotelName; //酒店名称

	private String roomtypeName; //房型名称

	private String begintimeStr; //开始日期

	private String endtimeStr; //结束日期
	
	private String forward; 

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	public String getBegintimeStr() {
		return begintimeStr;
	}

	public void setBegintimeStr(String begintimeStr) {
		this.begintimeStr = begintimeStr;
	}

	public String getEndtimeStr() {
		return endtimeStr;
	}

	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * 列表查询酒店房态
	 */
	public String execute() throws Exception {

		String where = " where 1=1 and C_ROOMTYPEID in (select ID from "+Roomtype.TABLE+" where C_HOTELID="
				+ hotelId + ")";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Roomstate.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		List list = Server.getInstance().getHotelService().findAllRoomstateForPageinfo(where,"order by " + Roomstate.COL_roomtypeid +","+Roomstate.COL_startdate, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listRoomstate = list;
		if (pageinfo.getTotalrow() > 0 && listRoomstate.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllRoomstateForPageinfo(where," order by " + Roomstate.COL_roomtypeid, pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listRoomstate = list;
		}

		return SUCCESS;
	}
public String toeditlanguage()throws Exception{
		
		Integer lan=roomstate.getLanguage();
		Long uco=roomstate.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		roomstate = Server.getInstance().getHotelService().findRoomstatebylanguage(roomstate.getUcode(),roomstate.getLanguage());
		if(roomstate==null)
		{
			roomstate=new Roomstate();
			roomstate.setLanguage(lan);
			roomstate.setUcode(uco);
			//以下是toadd参考方法
			String where = "where 1=1 ";
			where += " AND " + Roomtype.COL_hotelid + "=" + hotelId.longValue();
			System.out.println("where:"+where);
			listroomtypes = Server.getInstance().getHotelService().findAllRoomtype(where, " ORDER BY " + Roomtype.COL_id, -1, 0);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			String where = "where 1=1 ";
			where += " AND " + Roomtype.COL_hotelid + "=" + hotelId;
			listroomtypes = Server.getInstance().getHotelService()
					.findAllRoomtype(where, " ORDER BY " + Roomtype.COL_id, -1, 0);
			roomstate = Server.getInstance().getHotelService().findRoomstate(
					roomstate.getId());
			begintimeStr = formatDate(roomstate.getStartdate());
			endtimeStr = formatDate(roomstate.getEnddate());
			roomstate.setModifytime(new Timestamp(System.currentTimeMillis()));
			roomstate.setModifyuser(getLoginUser().getLoginname());
		}
		return EDIT;
	}
	/**
	 * 转向到酒店房态添加页面
	 */
	public String toadd() throws Exception {
		String where = "where 1=1 ";
		where += " AND " + Roomtype.COL_hotelid + "=" + hotelId.longValue();
		System.out.println("where:"+where);
		listroomtypes = Server.getInstance().getHotelService().findAllRoomtype(where, " ORDER BY " + Roomtype.COL_id, -1, 0);
		return EDIT;
	}

	/**
	 * 转向到酒店房态修改页面
	 */
	public String toedit() throws Exception {
		String where = "where 1=1 ";
		where += " AND " + Roomtype.COL_hotelid + "=" + hotelId;
		listroomtypes = Server.getInstance().getHotelService()
				.findAllRoomtype(where, " ORDER BY " + Roomtype.COL_id, -1, 0);
		roomstate = Server.getInstance().getHotelService().findRoomstate(
				roomstate.getId());
		begintimeStr = formatDate(roomstate.getStartdate());
		endtimeStr = formatDate(roomstate.getEnddate());
		roomstate.setModifytime(new Timestamp(System.currentTimeMillis()));
		roomstate.setModifyuser(getLoginUser().getLoginname());
		return EDIT;
	}

	/**
	 * 转向到酒店房态审核页面
	 */
	public String tocheck() throws Exception {
		String where = " where 1=1 and C_ROOMTYPEID in (select ID from "+Roomtype.TABLE+" where C_HOTELID="
				+ hotelId + ")";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Roomstate.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		List list = Server.getInstance().getHotelService().findAllRoomstateForPageinfo(where, "ORDER BY ID", pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRoomstate = list;
		// System.out.println(roomtypeName);
		if (pageinfo.getTotalrow() > 0 && listRoomstate.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllRoomstateForPageinfo(where, " ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRoomstate = list;
		}

		return CHECK;
	}

	/**
	 * 转向到tabs
	 */
	public String tabs() throws Exception {
		return "tabs";
	}

	/**
	 * 转向酒店房态查看页面
	 */
	public String tolook() throws Exception {
		String where = " where 1=1 and C_ROOMTYPEID in (select ID from "+Roomtype.TABLE+" where C_HOTELID="
				+ hotelId + ")";
		 List list = Server.getInstance().getHotelService().findAllRoomstateForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo =(PageInfo)list.remove(0);
		listRoomstate = list;

		if (pageinfo.getTotalrow() > 0 && listRoomstate.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService()
					.findAllRoomstateForPageinfo(where, " ORDER BY ID ", pageinfo);
			pageinfo =(PageInfo)list.remove(0);
			listRoomstate = list;
		}

		return "look";
	}

	/**
	 * 添加酒店房态
	 */
	public String add() throws Exception {
		roomstate.setRoomtypeid(roomstate.getRoomtypeid());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date begindate = dateFormat.parse(begintimeStr);
		Date enddate = dateFormat.parse(endtimeStr);
		roomstate.setStartdate(new Timestamp(begindate.getTime()));
		roomstate.setEnddate(new Timestamp(enddate.getTime()));
		roomstate.setCreateuser(getLoginUser().getLoginname());
		roomstate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		roomstate.setLanguage(0);
		if (roomstate.getState() == 2) {
			roomstate.setConfirmmethod(3);
			roomstate.setNum(0);
			roomstate.setType(3);
		}
		roomstate=Server.getInstance().getHotelService().createRoomstate(roomstate);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		if (roomstate.getState() == 1) {
			editBack(roomstate);
		}
	
		forward="roomstate!tabs.action?remotetabs=4&hotelId="+hotelId;
		return "forward";

	}

	/**
	 * 审核酒店房态
	 */
	public String check() throws Exception {
		String where = " where 1=1 and C_ROOMTYPEID in (select ID from "+Roomtype.TABLE+" where C_HOTELID="
				+ hotelId + ")";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Roomstate.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		listRoomstate = Server.getInstance().getHotelService()
				.findAllRoomstateForPageinfo(where, "ORDER BY ID", pageinfo);
		// System.out.println(roomtypeName);
		if (pageinfo.getTotalrow() > 0 && listRoomstate.size() == 0) {
			pageinfo.setPagenum(1);
			listRoomstate = Server.getInstance().getHotelService()
					.findAllRoomstateForPageinfo(where, " ORDER BY ID ", pageinfo);
		}
		return LIST;
	}

	/**
	 * 编辑酒店房态
	 */
	public String edit() throws Exception {
		roomstate.setModifyuser(getLoginUser().getLoginname());
		roomstate.setModifytime(new Timestamp(System.currentTimeMillis()));
		roomstate.setLanguage(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date begindate = dateFormat.parse(begintimeStr);
		Date enddate = (Date) dateFormat.parse(endtimeStr);
		roomstate.setStartdate(new Timestamp(begindate.getTime()));
		roomstate.setEnddate(new Timestamp(enddate.getTime()));
		System.out.println(roomstate.getRoomtypeid() + "------");
		if (roomstate.getState() == 2) {
			roomstate.setConfirmmethod(3);
			roomstate.setNum(0);
			roomstate.setType(3);
		}

		if (roomstate.getState() == 1) {
			editBack(roomstate);
		}
		Server.getInstance().getHotelService().updateRoomstateIgnoreNull(
				roomstate);
		this.addActionMessage("您的操作已成功！");
		//return EDIT;
		forward="roomstate!tabs.action?remotetabs=4&hotelId="+hotelId;
		return "forward2";
	}

	/**
	 * 取消满房
	 */
	public String cancel() throws Exception {
		// 取消满房 房态赋值为3
		// roomstate.setState(3);
		Server.getInstance().getHotelService().deleteRoomstate(roomstate.getId());
		// Server.getInstance().getHotelService().updateRoomstateIgnoreNull(roomstate);
		return LIST;
	}

	/**
	 * 返回到列表页面
	 */
	public String goback() throws Exception {
		return SUCCESS;
	}

	/**
	 * 删除酒店房态
	 */
	public String delete() throws Exception {
		roomstate.setNum(0);
		// begintimeStr=roomstate.getStartdate().toLocaleString();
		// endtimeStr=roomstate.getEnddate().toLocaleString();
		// insertBack(roomstate);
		Server.getInstance().getHotelService().deleteRoomstate(
				roomstate.getId());
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
					Server.getInstance().getHotelService().deleteRoomstate(
							i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 判断开始时间结束时间是否存在
	 * 
	 * @throws IOException
	 */
	public String checkTime() throws IOException{
		System.out.println(this.begintimeStr+"checkTime()---------");
		System.out.println(this.endtimeStr);
	
		String message="";
	 	String where =" where 1=1 and C_ROOMTYPEID = "+roomstate.getRoomtypeid()+" and ID !="+roomstate.getId();
		where += " AND (" 
			+ "(" + Roomstate.COL_startdate + ">=" + "CONVERT(date, '" + this.begintimeStr + "')" + " AND " 
			+ Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + this.endtimeStr + "'))"
			+ " OR (" + Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + begintimeStr + "')" + " AND " 
			+ Roomstate.COL_enddate + "<=" + "CONVERT(date, '" + endtimeStr + "'))"
			+ " OR (" + Roomstate.COL_startdate + "<=" + "CONVERT(date, '" + begintimeStr + "')" + " AND " 
			+ Roomstate.COL_enddate + ">=" + "CONVERT(date, '" + endtimeStr + "'))"
			+ ")" ;
		if(Server.getInstance().getHotelService().findAllRoomstate(where,"",-1,0).isEmpty()){
			message="可以操作";
		}else{
			message="f";
		}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/plain; charset=GB2312");
			PrintWriter out = response.getWriter();
			
			out.print(message) ;
			out.flush();
			out.close();
			
			return null;
	}
	/**
	 * 获取这个月最大天数传入yyyy-M
	 * 
	 * @param beginTime
	 * @return
	 * @throws ParseException
	 */
	public int getMaxDate(String beginTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(sdf.parse(beginTime));
		int maxDate = beginCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDate;
	}

	/**
	 * 插入数据库修改
	 * 
	 * @param beginTime
	 * @param beginday
	 * @param endday
	 * @param roomTypeid
	 * @throws Exception
	 */
	private void editState(String beginTime, int beginday, int endday,
			long roomid) throws Exception {
		// 创建RoomStateback对象
		Roomstateback roomstateback = new Roomstateback();
		// 循环为RoomStarteback赋值
		for (int i = beginday; i <= endday; i++) {
			try {
				Method method = Roomstateback.class.getMethod("setNo" + i,
						Integer.class);
				method.invoke(roomstateback, roomstate.getNum());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 格式化时间
		if (beginTime.split("-")[1].length() < 2) {
			beginTime = beginTime.split("-")[0] + "-" + "0"
					+ beginTime.split("-")[1];
		}
		// 为roomstateback赋值
		roomstateback.setHotelid(hotelId);
		roomstateback.setDatenumber(beginTime);
		roomstateback.setConfirmmethod(roomstate.getConfirmmethod());
		roomstateback.setRoomid(roomstate.getRoomtypeid());
		roomstateback.setType(roomstate.getType());
		roomstateback.setState(roomstate.getState());
		// 查询数据库中有这个月 if 有 更新 else 添加
		String where = " where " + Roomstateback.COL_datenumber + "='"
				+ beginTime + "' and " + Roomstateback.COL_roomid + "="
				+ roomid;
		System.out.println(where);
		List<Roomstateback> list = Server.getInstance()
				.getHotelService().findAllRoomstateback(where, "", -1,
						0);
		;
		if (list != null && list.size() > 0) {
			roomstateback.setId(list.get(0).getId());
			// 更新0000000000000000000
			/*
			 * String isNoid=roomstateback.getIsvalid(); String
			 * be=isNoid.substring(0,beginday-1); for(int i=0;i<endday;i++) {
			 * be+="1"; }
			 * be+=isNoid.substring(endday,(this.getMaxDate(beginTime))-1);
			 * roomstateback.setIsvalid(be);
			 */
			Server.getInstance().getHotelService()
					.updateRoomstatebackIgnoreNull(roomstateback);
		} else {
			// 设置00000000000000000000000000
			/*
			 * String isNoid=""; for(int i=1;i<beginday;i++) { isNoid+="0"; }
			 * for(int i=beginday;i<=endday;i++) { isNoid+="1"; } for(int
			 * i=endday;endday<this.getMaxDate(beginTime);i++) { isNoid+="0"; }
			 * roomstateback.setIsvalid(isNoid);
			 */
			Server.getInstance().getHotelService().createRoomstateback(
					roomstateback);
		}
	}

	/**
	 * 添加修改
	 * 
	 * @param roomstate
	 * @throws Exception
	 */
	public void editBack(Roomstate roomstate) throws Exception {
		// 截取时间 获取开始时间和结束时间的年、月、日
		String[] begintimeArr = this.begintimeStr.split("-");

		String[] endtimeArr = this.endtimeStr.split("-");

		int beginyyyy = Integer.parseInt(this.begintimeStr.split("-")[0]);

		int endyyyy = Integer.parseInt(this.endtimeStr.split("-")[0]);

		int beginMm = Integer.parseInt(this.begintimeStr.split("-")[1]);

		int endMm = Integer.parseInt(this.endtimeStr.split("-")[1]);

		int beginday = Integer.parseInt(this.begintimeStr.split("-")[2]);

		int endday = Integer.parseInt(this.endtimeStr.split("-")[2]);

		// 如果开始时间的年份和结束的时间的年份相等 执行以下
		if (beginyyyy == endyyyy) {
			// 如果开始时间和结束时间相对说明在同一年 获取月份差
			int count = endMm - beginMm;
			// 从零开始 如果count=0 执行一次 count如果等于5执行6次
			for (int i = 0; i <= count; i++) {
				// count=0说明插入时时间在同一年并且在同一月 把开始日期和结束日期传入
				if (count == 0) {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					this.editState(tempBegintime, beginday, endday, roomstate
							.getRoomtypeid());
				}
				// 执行时开始开始时间和这个月最大天数传进去 在for循环中仅执行一次
				else if (i == 0) {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					System.out.println(tempBegintime + "------------");
					this.editState(tempBegintime, beginday,
							getMaxDate(tempBegintime), roomstate
									.getRoomtypeid());
				}
				// 执行时把1和结束时间传入，在for循环仅执行一次
				else if (i == count) {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					this.editState(tempBegintime, 1, endday, roomstate
							.getRoomtypeid());
				}
				// 执行时传入1和这个月最大天数，在for循环中执行次数由count决定
				else {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					this.editState(tempBegintime, 1, getMaxDate(tempBegintime),
							roomstate.getRoomtypeid());
				}
			}
		}
		// 开始时间和结束时间年份相等执行完毕 以下是执行开始时间和结束时间不相等
		else {
			// 先获取这年剩余的月数
			int count = 12 - beginMm;
			// 循环把这一年添加完
			for (int i = 0; i <= count; i++) {
				// 执行时把开始时间和这个月最大天数传入 执行仅一次
				if (i == 0) {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					this.editState(tempBegintime, beginday,
							getMaxDate(tempBegintime), roomstate
									.getRoomtypeid());
				}
				// 把1和月的最大天数传入 循环次数由count决定
				else {
					String tempBegintime = beginyyyy + "-" + (beginMm + i);
					this.editState(tempBegintime, 1, getMaxDate(tempBegintime),
							roomstate.getRoomtypeid());
				}
			}
			// 获取年数差，（在页面设置限定 最长不能超过1年）以下代码没有限制时间
			int yyyy = endyyyy - beginyyyy;
			// 循环添加 有年数决定
			for (int i = 1; i <= yyyy; i++) {
				// 如果是i==年数差 即执行到结束时间的年份 执行以下代码
				if (i == yyyy) {
					// 循环结束时间的月份数添加
					for (int j = 1; j <= endMm; j++) {
						// 当执行到结束时间的月份时 把1和结束时间传入
						if (j == endMm) {
							String tempBegintime = endyyyy + "-" + j;
							this.editState(tempBegintime, 1, endday, roomstate
									.getRoomtypeid());
						}
						// 由是几月份决定执行的次数
						else {
							String tempBegintime = endyyyy + "-" + j;
							this.editState(tempBegintime, 1,
									getMaxDate(tempBegintime), roomstate
											.getRoomtypeid());
						}
					}
				}
				// 如果不是结束时间的年份 for循环 从1月添加到12月
				else {
					for (int j = 1; j <= 12; j++) {
						String tempBegintime = beginyyyy + i + "-" + j;
						this.editState(tempBegintime, 1,
								getMaxDate(tempBegintime), roomstate
										.getRoomtypeid());
					}
				}
			}
		}
		// 开始时间和结束时间不相等执行完毕
	}

	/**
	 * 返回酒店房态对象
	 */
	public String getStateByID(Integer id) {
		switch (id) {
		case 2:
			return "满房";
		case 1:
			return "预留房";
		case 3:
			return "取消满房";
		default:
			return "未知状态";
		}
	}

	/**
	 * 判断确认类型
	 */
	public String getConfirmById(Integer id) {
		// switch(id){
		// case 0:
		// return "不需确认";
		// case 1:
		// return "需要确认";
		// default:
		// return "无";
		// }

		if (id == 0) {
			return "不需确认";
		} else if (id == 1) {
			return "需要确认";
		}
		return "无";
	}

	/**
	 * 判断计算类型
	 */
	public String getAccById(Integer id) {
		switch (id) {
		case 1:
			return "累计";
		case 2:
			return "新增";
		default:
			return "无";
		}
	}

	/**
	 * 根据房型的id获得房型的名称
	 */
	public String getNameById(Integer id) {
		roomtypeName = Server.getInstance().getHotelService().findRoomtype(
				id).getName();

		return roomtypeName;
	}
	/**
	 * 根据房型id查出此酒店与此房型相关的所有房态
	 */
	public List<Roomstate> getAllStateById(Integer id){
		String where = " where 1=1 and C_ROOMTYPEID = (select ID from "+Roomtype.TABLE+" where C_HOTELID="
			+ hotelId +")";
		List list = Server.getInstance().getHotelService().findAllRoomstate(where," order by C_ROOMTYPEID ",-1,0);
		return list;
	}
	
	/**
	 * 根据酒店的id获得酒店的名称
	 */
	public String getHotelNameById(Integer id) {
		hotelName = Server.getInstance().getHotelService().findHotel(id)
				.getName();
		return hotelName;

	}

	public Object getModel() {
		return roomstate;
	}

	public List<Roomstate> getListRoomstate() {
		return listRoomstate;
	}

	public void setListRoomstate(List<Roomstate> listRoomstate) {
		this.listRoomstate = listRoomstate;
	}

	public Roomstate getRoomstate() {
		return roomstate;
	}

	public void setRoomstate(Roomstate roomstate) {
		this.roomstate = roomstate;
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

	public List<Roomtype> getRoomtypes() {
		return listroomtypes;
	}

	public void setRoomtypes(List<Roomtype> listroomtypes) {
		this.listroomtypes = listroomtypes;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Roomtype getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
	}

	public List<Roomtype> getListroomtypes() {
		return listroomtypes;
	}

	public void setListroomtypes(List<Roomtype> listroomtypes) {
		this.listroomtypes = listroomtypes;
	}

	public String getRoomtypeName() {
		return roomtypeName;
	}

	public void setRoomtypeName(String roomtypeName) {
		this.roomtypeName = roomtypeName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

}