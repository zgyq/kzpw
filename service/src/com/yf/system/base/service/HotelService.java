package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.chaininfo.Chaininfo;
import com.yf.system.base.chaininfo.IChaininfoComponent;
import com.yf.system.base.city.City;
import com.yf.system.base.city.ICityComponent;
import com.yf.system.base.dataprovide.Dataprovide;
import com.yf.system.base.dataprovide.IDataprovideComponent;
import com.yf.system.base.dcampaign.Dcampaign;
import com.yf.system.base.dcampaign.IDcampaignComponent;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.guest.IGuestComponent;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotel.IHotelComponent;
import com.yf.system.base.hotelagent.Hotelagent;
import com.yf.system.base.hotelagent.IHotelagentComponent;
import com.yf.system.base.hotelcontract.Hotelcontract;
import com.yf.system.base.hotelcontract.IHotelcontractComponent;
import com.yf.system.base.hotelfan.Hotelfan;
import com.yf.system.base.hotelfan.IHotelfanComponent;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotelimage.IHotelimageComponent;
import com.yf.system.base.hotellandmark.Hotellandmark;
import com.yf.system.base.hotellandmark.IHotellandmarkComponent;
import com.yf.system.base.hotellinkman.Hotellinkman;
import com.yf.system.base.hotellinkman.IHotellinkmanComponent;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorder.IHotelorderComponent;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.hotelorderrc.IHotelorderrcComponent;
import com.yf.system.base.hotelpass.Hotelpass;
import com.yf.system.base.hotelpass.IHotelpassComponent;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.hotelprice.IHotelpriceComponent;
import com.yf.system.base.hotelspec.Hotelspec;
import com.yf.system.base.hotelspec.IHotelspecComponent;
import com.yf.system.base.hotelstar.Hotelstar;
import com.yf.system.base.hotelstar.IHotelstarComponent;
import com.yf.system.base.hotelstart.Hotelstart;
import com.yf.system.base.hotelstart.IHotelstartComponent;
import com.yf.system.base.landmark.ILandmarkComponent;
import com.yf.system.base.landmark.Landmark;
import com.yf.system.base.paymentrecorder.IPaymentrecorderComponent;
import com.yf.system.base.paymentrecorder.Paymentrecorder;
import com.yf.system.base.province.IProvinceComponent;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.IRegionComponent;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstate.IRoomstateComponent;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomstateback.IRoomstatebackComponent;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.IRoomtypeComponent;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.starrecord.IStarrecordComponent;
import com.yf.system.base.starrecord.Starrecord;
import com.yf.system.base.starreinfo.IStarreinfoComponent;
import com.yf.system.base.starreinfo.Starreinfo;
import com.yf.system.base.starsettlementtype.IStarsettlementtypeComponent;
import com.yf.system.base.starsettlementtype.Starsettlementtype;
import com.yf.system.base.sysmessage.ISysmessageComponent;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.util.PageInfo;


public class HotelService implements IHotelService {

private IHotelComponent hotelComponent;
private IHotelcontractComponent hotelcontractComponent;	  
private IHotelspecComponent hotelspecComponent;
private IHotelimageComponent hotelimageComponent;
private IHotellinkmanComponent hotellinkmanComponent;
private IHotellandmarkComponent hotellandmarkComponent;
private IRoomstateComponent roomstateComponent;
private IRoomtypeComponent roomtypeComponent;
private IRoomstatebackComponent roomstatebackComponent;
 	public IHotelComponent getHotelComponent() {
		return hotelComponent;
	}
	public void setHotelComponent(IHotelComponent  hotelComponent) {
		this.hotelComponent = hotelComponent;
	}
	/**
	 * 创建 酒店
	 * @param id
	 * @return deleted count 
	 */
	public Hotel createHotel(Hotel hotel) throws SQLException{
	
		return hotelComponent.createHotel(hotel);
	}
	/**
	 * 删除 酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotel(long id){
	
		return hotelComponent.deleteHotel(id);
	}
	
	
	/**
	 * 修改 酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateHotel(Hotel hotel){
		return hotelComponent.updateHotel(hotel);
	
	}

		
	/**
	 * 修改 酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelIgnoreNull(Hotel hotel){
			return hotelComponent.updateHotelIgnoreNull(hotel);
	
	}
	
	/**
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String where, String orderby,int limit,int offset){
		return hotelComponent.findAllHotel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotel(long id){
		return hotelComponent.findHotel(id);
	}
	
	/** 
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelComponent.findAllHotel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelBySql(String sql,int limit,int offset){
		return hotelComponent.findAllHotel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelBySql(String sql){
		return hotelComponent.excuteHotelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelBySql(String sql){
		return hotelComponent.countHotelBySql(sql);
	}

	//酒店合同
	

 	public IHotelcontractComponent getHotelcontractComponent() {
		return hotelcontractComponent;
	}
	public void setHotelcontractComponent(IHotelcontractComponent  hotelcontractComponent) {
		this.hotelcontractComponent = hotelcontractComponent;
	}
	/**
	 * 创建 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public Hotelcontract createHotelcontract(Hotelcontract hotelcontract) throws SQLException{
	
		return hotelcontractComponent.createHotelcontract(hotelcontract);
	}
	/**
	 * 删除 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelcontract(long id){
	
		return hotelcontractComponent.deleteHotelcontract(id);
	}
	
	
	/**
	 * 修改 酒店合同
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelcontract(Hotelcontract hotelcontract){
		return hotelcontractComponent.updateHotelcontract(hotelcontract);
	
	}

		
	/**
	 * 修改 酒店合同但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelcontractIgnoreNull(Hotelcontract hotelcontract){
			return hotelcontractComponent.updateHotelcontractIgnoreNull(hotelcontract);
	
	}
	
	/**
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,int limit,int offset){
		return hotelcontractComponent.findAllHotelcontract(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontract(long id){
		return hotelcontractComponent.findHotelcontract(id);
	}
	
	/** 
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelcontractForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelcontractComponent.findAllHotelcontract(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店合同
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontractBySql(String sql,int limit,int offset){
		return hotelcontractComponent.findAllHotelcontract(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店合同
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelcontractBySql(String sql){
		return hotelcontractComponent.excuteHotelcontractBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelcontractBySql(String sql){
		return hotelcontractComponent.countHotelcontractBySql(sql);
	}
	
	//注意事项
	public IHotelspecComponent getHotelspecComponent() {
		return hotelspecComponent;
	}
	public void setHotelspecComponent(IHotelspecComponent  hotelspecComponent) {
		this.hotelspecComponent = hotelspecComponent;
	}
	/**
	 * 创建 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Hotelspec createHotelspec(Hotelspec hotelspec) throws SQLException{
	
		return hotelspecComponent.createHotelspec(hotelspec);
	}
	/**
	 * 删除 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelspec(long id){
	
		return hotelspecComponent.deleteHotelspec(id);
	}
	
	
	/**
	 * 修改 酒店注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelspec(Hotelspec hotelspec){
		return hotelspecComponent.updateHotelspec(hotelspec);
	
	}

		
	/**
	 * 修改 酒店注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelspecIgnoreNull(Hotelspec hotelspec){
			return hotelspecComponent.updateHotelspecIgnoreNull(hotelspec);
	
	}
	
	/**
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,int limit,int offset){
		return hotelspecComponent.findAllHotelspec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店注意事项
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspec(long id){
		return hotelspecComponent.findHotelspec(id);
	}
	
	/** 
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelspecForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelspecComponent.findAllHotelspec(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspecBySql(String sql,int limit,int offset){
		return hotelspecComponent.findAllHotelspec(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelspecBySql(String sql){
		return hotelspecComponent.excuteHotelspecBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelspecBySql(String sql){
		return hotelspecComponent.countHotelspecBySql(sql);
	}
	
	//图片
	public IHotelimageComponent getHotelimageComponent() {
		return hotelimageComponent;
	}
	public void setHotelimageComponent(IHotelimageComponent  hotelimageComponent) {
		this.hotelimageComponent = hotelimageComponent;
	}
	/**
	 * 创建 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public Hotelimage createHotelimage(Hotelimage hotelimage) throws SQLException{
	
		return hotelimageComponent.createHotelimage(hotelimage);
	}
	/**
	 * 删除 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelimage(long id){
	
		return hotelimageComponent.deleteHotelimage(id);
	}
	
	
	/**
	 * 修改 酒店图片
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelimage(Hotelimage hotelimage){
		return hotelimageComponent.updateHotelimage(hotelimage);
	
	}

		
	/**
	 * 修改 酒店图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelimageIgnoreNull(Hotelimage hotelimage){
			return hotelimageComponent.updateHotelimageIgnoreNull(hotelimage);
	
	}
	
	/**
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,int limit,int offset){
		return hotelimageComponent.findAllHotelimage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店图片
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimage(long id){
		return hotelimageComponent.findHotelimage(id);
	}
	
	/** 
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelimageForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelimageComponent.findAllHotelimage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimageBySql(String sql,int limit,int offset){
		return hotelimageComponent.findAllHotelimage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelimageBySql(String sql){
		return hotelimageComponent.excuteHotelimageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelimageBySql(String sql){
		return hotelimageComponent.countHotelimageBySql(sql);
	}
//联系人
	
	public IHotellinkmanComponent getHotellinkmanComponent() {
		return hotellinkmanComponent;
	}
	public void setHotellinkmanComponent(IHotellinkmanComponent  hotellinkmanComponent) {
		this.hotellinkmanComponent = hotellinkmanComponent;
	}
	/**
	 * 创建 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public Hotellinkman createHotellinkman(Hotellinkman hotellinkman) throws SQLException{
	
		return hotellinkmanComponent.createHotellinkman(hotellinkman);
	}
	/**
	 * 删除 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellinkman(long id){
	
		return hotellinkmanComponent.deleteHotellinkman(id);
	}
	
	
	/**
	 * 修改 酒店联系人
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellinkman(Hotellinkman hotellinkman){
		return hotellinkmanComponent.updateHotellinkman(hotellinkman);
	
	}

		
	/**
	 * 修改 酒店联系人但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellinkmanIgnoreNull(Hotellinkman hotellinkman){
			return hotellinkmanComponent.updateHotellinkmanIgnoreNull(hotellinkman);
	
	}
	
	/**
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,int limit,int offset){
		return hotellinkmanComponent.findAllHotellinkman(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店联系人
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkman(long id){
		return hotellinkmanComponent.findHotellinkman(id);
	}
	
	/** 
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellinkmanForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotellinkmanComponent.findAllHotellinkman(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店联系人
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkmanBySql(String sql,int limit,int offset){
		return hotellinkmanComponent.findAllHotellinkman(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店联系人
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellinkmanBySql(String sql){
		return hotellinkmanComponent.excuteHotellinkmanBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellinkmanBySql(String sql){
		return hotellinkmanComponent.countHotellinkmanBySql(sql);
	}

	//地标
	public IHotellandmarkComponent getHotellandmarkComponent() {
		return hotellandmarkComponent;
	}
	public void setHotellandmarkComponent(IHotellandmarkComponent  hotellandmarkComponent) {
		this.hotellandmarkComponent = hotellandmarkComponent;
	}
	/**
	 * 创建 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public Hotellandmark createHotellandmark(Hotellandmark hotellandmark) throws SQLException{
	
		return hotellandmarkComponent.createHotellandmark(hotellandmark);
	}
	/**
	 * 删除 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellandmark(long id){
	
		return hotellandmarkComponent.deleteHotellandmark(id);
	}
	
	
	/**
	 * 修改 酒店地标
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellandmark(Hotellandmark hotellandmark){
		return hotellandmarkComponent.updateHotellandmark(hotellandmark);
	
	}

		
	/**
	 * 修改 酒店地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellandmarkIgnoreNull(Hotellandmark hotellandmark){
			return hotellandmarkComponent.updateHotellandmarkIgnoreNull(hotellandmark);
	
	}
	
	/**
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,int limit,int offset){
		return hotellandmarkComponent.findAllHotellandmark(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmark(long id){
		return hotellandmarkComponent.findHotellandmark(id);
	}
	
	/** 
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellandmarkForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotellandmarkComponent.findAllHotellandmark(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmarkBySql(String sql,int limit,int offset){
		return hotellandmarkComponent.findAllHotellandmark(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellandmarkBySql(String sql){
		return hotellandmarkComponent.excuteHotellandmarkBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellandmarkBySql(String sql){
		return hotellandmarkComponent.countHotellandmarkBySql(sql);
	}
	
	
 	public IRoomstateComponent getRoomstateComponent() {
		return roomstateComponent;
	}
	public void setRoomstateComponent(IRoomstateComponent  roomstateComponent) {
		this.roomstateComponent = roomstateComponent;
	}
	/**
	 * 创建 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public Roomstate createRoomstate(Roomstate roomstate) throws SQLException{
	
		return roomstateComponent.createRoomstate(roomstate);
	}
	/**
	 * 删除 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstate(long id){
	
		return roomstateComponent.deleteRoomstate(id);
	}
	
	
	/**
	 * 修改 酒店房态
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstate(Roomstate roomstate){
		return roomstateComponent.updateRoomstate(roomstate);
	
	}

		
	/**
	 * 修改 酒店房态但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstateIgnoreNull(Roomstate roomstate){
			return roomstateComponent.updateRoomstateIgnoreNull(roomstate);
	
	}
	
	/**
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,int limit,int offset){
		return roomstateComponent.findAllRoomstate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstate(long id){
		return roomstateComponent.findRoomstate(id);
	}
	
	/** 
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return roomstateComponent.findAllRoomstate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房态
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateBySql(String sql,int limit,int offset){
		return roomstateComponent.findAllRoomstate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房态
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstateBySql(String sql){
		return roomstateComponent.excuteRoomstateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstateBySql(String sql){
		return roomstateComponent.countRoomstateBySql(sql);
	}
	
	//房型
	public IRoomtypeComponent getRoomtypeComponent() {
		return roomtypeComponent;
	}
	public void setRoomtypeComponent(IRoomtypeComponent  roomtypeComponent) {
		this.roomtypeComponent = roomtypeComponent;
	}
	/**
	 * 创建 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public Roomtype createRoomtype(Roomtype roomtype) throws SQLException{
	
		return roomtypeComponent.createRoomtype(roomtype);
	}
	/**
	 * 删除 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomtype(long id){
	
		return roomtypeComponent.deleteRoomtype(id);
	}
	
	
	/**
	 * 修改 酒店房型
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomtype(Roomtype roomtype){
		return roomtypeComponent.updateRoomtype(roomtype);
	
	}

		
	/**
	 * 修改 酒店房型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomtypeIgnoreNull(Roomtype roomtype){
			return roomtypeComponent.updateRoomtypeIgnoreNull(roomtype);
	
	}
	
	/**
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,int limit,int offset){
		return roomtypeComponent.findAllRoomtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtype(long id){
		return roomtypeComponent.findRoomtype(id);
	}
	
	/** 
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomtypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return roomtypeComponent.findAllRoomtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtypeBySql(String sql,int limit,int offset){
		return roomtypeComponent.findAllRoomtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomtypeBySql(String sql){
		return roomtypeComponent.excuteRoomtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomtypeBySql(String sql){
		return roomtypeComponent.countRoomtypeBySql(sql);
	}
	
	private IHotelpriceComponent hotelpriceComponent;
	  
 	
 	public IHotelpriceComponent getHotelpriceComponent() {
		return hotelpriceComponent;
	}
	public void setHotelpriceComponent(IHotelpriceComponent  hotelpriceComponent) {
		this.hotelpriceComponent = hotelpriceComponent;
	}
	/**
	 * 创建 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public Hotelprice createHotelprice(Hotelprice hotelprice) throws SQLException{
	
		return hotelpriceComponent.createHotelprice(hotelprice);
	}
	/**
	 * 删除 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelprice(long id){
	
		return hotelpriceComponent.deleteHotelprice(id);
	}
	
	
	/**
	 * 修改 酒店价格
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelprice(Hotelprice hotelprice){
		return hotelpriceComponent.updateHotelprice(hotelprice);
	
	}

		
	/**
	 * 修改 酒店价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpriceIgnoreNull(Hotelprice hotelprice){
			return hotelpriceComponent.updateHotelpriceIgnoreNull(hotelprice);
	
	}
	
	/**
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,int limit,int offset){
		return hotelpriceComponent.findAllHotelprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店价格
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelprice(long id){
		return hotelpriceComponent.findHotelprice(id);
	}
	
	/** 
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelpriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelpriceComponent.findAllHotelprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpriceBySql(String sql,int limit,int offset){
		return hotelpriceComponent.findAllHotelprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpriceBySql(String sql){
		return hotelpriceComponent.excuteHotelpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpriceBySql(String sql){
		return hotelpriceComponent.countHotelpriceBySql(sql);
	}
//roomstateback

	  
 	
 	public IRoomstatebackComponent getRoomstatebackComponent() {
		return roomstatebackComponent;
	}
	public void setRoomstatebackComponent(IRoomstatebackComponent  roomstatebackComponent) {
		this.roomstatebackComponent = roomstatebackComponent;
	}
	/**
	 * 创建 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public Roomstateback createRoomstateback(Roomstateback roomstateback) throws SQLException{
	
		return roomstatebackComponent.createRoomstateback(roomstateback);
	}
	/**
	 * 删除 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstateback(long id){
	
		return roomstatebackComponent.deleteRoomstateback(id);
	}
	
	
	/**
	 * 修改 酒店房态表
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstateback(Roomstateback roomstateback){
		return roomstatebackComponent.updateRoomstateback(roomstateback);
	
	}

		
	/**
	 * 修改 酒店房态表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstatebackIgnoreNull(Roomstateback roomstateback){
			return roomstatebackComponent.updateRoomstatebackIgnoreNull(roomstateback);
	
	}
	
	/**
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,int limit,int offset){
		return roomstatebackComponent.findAllRoomstateback(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstateback(long id){
		return roomstatebackComponent.findRoomstateback(id);
	}
	
	/** 
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstatebackForPageinfo(String where, String orderby,PageInfo pageinfo){
		return roomstatebackComponent.findAllRoomstateback(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房态表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstatebackBySql(String sql,int limit,int offset){
		return roomstatebackComponent.findAllRoomstateback(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房态表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstatebackBySql(String sql){
		return roomstatebackComponent.excuteRoomstatebackBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstatebackBySql(String sql){
		return roomstatebackComponent.countRoomstatebackBySql(sql);
	}
	
//	private ICollectionComponent collectionComponent;
//	  
// 	
// 	public ICollectionComponent getCollectionComponent() {
//		return collectionComponent;
//	}
//	public void setCollectionComponent(ICollectionComponent  collectionComponent) {
//		this.collectionComponent = collectionComponent;
//	}
//	/**
//	 * 创建 收藏表
//	 * @param id
//	 * @return deleted count 
//	 */
//	public Collection createCollection(Collection collection) throws SQLException{
//	
//		return collectionComponent.createCollection(collection);
//	}
//	/**
//	 * 删除 收藏表
//	 * @param id
//	 * @return deleted count 
//	 */
//	public int deleteCollection(long id){
//	
//		return collectionComponent.deleteCollection(id);
//	}
//	
//	
//	/**
//	 * 修改 收藏表
//	 * @param id
//	 * @return updated count 
//	 */
//	public int updateCollection(Collection collection){
//		return collectionComponent.updateCollection(collection);
//	
//	}
//
//		
//	/**
//	 * 修改 收藏表但忽略空值 
//	 * @param id
//	 * @return 
//	 */
//	public int updateCollectionIgnoreNull(Collection collection){
//			return collectionComponent.updateCollectionIgnoreNull(collection);
//	
//	}
//	
//	/**
//	 * 查找 收藏表
//	 * @param where
//	 * @param orderby
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllCollection(String where, String orderby,int limit,int offset){
//		return collectionComponent.findAllCollection(where, orderby,limit,offset);
//	}
//		
//	
//	/**
//	 * 查找 收藏表
//	 * @param id
//	 * @return
//	 */
//	public Collection findCollection(long id){
//		return collectionComponent.findCollection(id);
//	}
//	
//	/** 
//	 * 查找 收藏表
//	 * @param where
//	 * @param orderby
//	 * @param pageinfo
//	 * @return
//	 */
//	public List findAllCollectionForPageinfo(String where, String orderby,PageInfo pageinfo){
//		return collectionComponent.findAllCollection(where, orderby,pageinfo);
//	}
//		
//	/** 
//	 * 根据Sql查找收藏表
//	 * @param sql
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllCollectionBySql(String sql,int limit,int offset){
//		return collectionComponent.findAllCollection(sql,limit,offset);
//	}
//	
//	
//	/**
//	 * 执行Sql 收藏表
//	 * @param sql 
//	 * @return updated count 
//	 */
//	public int excuteCollectionBySql(String sql){
//		return collectionComponent.excuteCollectionBySql(sql);
//	}
//	
//	/**
//	 * 执行Sql 
//	 * @param sql 
//	 * @return  count 
//	 */
//	public int countCollectionBySql(String sql){
//		return collectionComponent.countCollectionBySql(sql);
//	}
	private IHotelorderComponent hotelorderComponent;
	  
	private IHotelorderrcComponent hotelorderrcComponent;
	
 	public IHotelorderComponent getHotelorderComponent() {
		return hotelorderComponent;
	}
	public void setHotelorderComponent(IHotelorderComponent  hotelorderComponent) {
		this.hotelorderComponent = hotelorderComponent;
	}
	
	/**
	 * 创建 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorder createHotelorder(Hotelorder hotelorder) throws SQLException{
		return hotelorderComponent.createHotelorder(hotelorder);
	}
	
	/**
	 * 审核酒店
	 * @param hotelorder
	 * @param systemuser
	 * @return
	 * @throws Exception
	 */
	public Hotelorder executeAuditing(Hotelorder hotelorder,  String username , String mobile) throws Exception {
		return hotelorderComponent.executeAuditing(hotelorder, username, mobile) ;
	}
	
	/**
	 * 确认 酒店订单
	 */
	public Hotelorder executeCimfirm(Hotelorder hotelorder, String username, String mobile) throws Exception {
		return hotelorderComponent.executeCimfirm(hotelorder, username, mobile) ;
	}
	
	/**
	 * 确认入住 酒店订单
	 */
	public Hotelorder executePutoff(Hotelorder hotelorder, String username, String mobile) throws Exception {
		return hotelorderComponent.executePutoff(hotelorder, username, mobile) ;
	}
	
	/**
	 * 删除 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorder(long id){
	
		return hotelorderComponent.deleteHotelorder(id);
	}
	
	
	/**
	 * 修改 酒店订单
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorder(Hotelorder hotelorder) throws Exception {
		return hotelorderComponent.updateHotelorder(hotelorder);
	
	}

	/**
	 * 取消订单
	 * @param hotelorder
	 * @return
	 * @throws Exception
	 */
	public Hotelorder executeCannel(Hotelorder hotelorder) throws Exception {
		return hotelorderComponent.executeCannel(hotelorder) ;
	}
		
	public Long findHotelCinfirmOrderNum(Long id) {
		return hotelorderComponent.findHotelCinfirmOrderNum(id) ;
	}
	
	/**
	 * 修改 酒店订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderIgnoreNull(Hotelorder hotelorder){
			return hotelorderComponent.updateHotelorderIgnoreNull(hotelorder);
	
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
		return hotelorderComponent.findAllHotelorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店订单
	 * @param id
	 * @return
	 */
	public Hotelorder findHotelorder(long id){
		return hotelorderComponent.findHotelorder(id);
	}
	
	/** 
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelorderComponent.findAllHotelorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderBySql(String sql,int limit,int offset){
		return hotelorderComponent.findAllHotelorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderBySql(String sql){
		return hotelorderComponent.excuteHotelorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderBySql(String sql){
		return hotelorderComponent.countHotelorderBySql(sql);
	}
	
	
 	public IHotelorderrcComponent getHotelorderrcComponent() {
		return hotelorderrcComponent;
	}
 	
	public void setHotelorderrcComponent(IHotelorderrcComponent  hotelorderrcComponent) {
		this.hotelorderrcComponent = hotelorderrcComponent;
	}
	/**
	 * 创建 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorderrc createHotelorderrc(Hotelorderrc hotelorderrc) throws SQLException{
	
		return hotelorderrcComponent.createHotelorderrc(hotelorderrc);
	}
	/**
	 * 删除 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorderrc(long id){
	
		return hotelorderrcComponent.deleteHotelorderrc(id);
	}
	
	
	/**
	 * 修改 酒店订单状态日志
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorderrc(Hotelorderrc hotelorderrc){
		return hotelorderrcComponent.updateHotelorderrc(hotelorderrc);
	
	}

		
	/**
	 * 修改 酒店订单状态日志但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderrcIgnoreNull(Hotelorderrc hotelorderrc){
			return hotelorderrcComponent.updateHotelorderrcIgnoreNull(hotelorderrc);
	
	}
	
	/**
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,int limit,int offset){
		return hotelorderrcComponent.findAllHotelorderrc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrc(long id){
		return hotelorderrcComponent.findHotelorderrc(id);
	}
	
	/** 
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderrcForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelorderrcComponent.findAllHotelorderrc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店订单状态日志
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrcBySql(String sql,int limit,int offset){
		return hotelorderrcComponent.findAllHotelorderrc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店订单状态日志
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderrcBySql(String sql){
		return hotelorderrcComponent.excuteHotelorderrcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderrcBySql(String sql){
		return hotelorderrcComponent.countHotelorderrcBySql(sql);
	}
	
	private IGuestComponent guestComponent;
	  
 	
 	public IGuestComponent getGuestComponent() {
		return guestComponent;
	}
	public void setGuestComponent(IGuestComponent  guestComponent) {
		this.guestComponent = guestComponent;
	}
	/**
	 * 创建 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public Guest createGuest(Guest guest) throws SQLException{
	
		return guestComponent.createGuest(guest);
	}
	/**
	 * 删除 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGuest(long id){
	
		return guestComponent.deleteGuest(id);
	}
	
	
	/**
	 * 修改 客人信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateGuest(Guest guest){
		return guestComponent.updateGuest(guest);
	
	}

		
	/**
	 * 修改 客人信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGuestIgnoreNull(Guest guest){
			return guestComponent.updateGuestIgnoreNull(guest);
	
	}
	
	/**
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String where, String orderby,int limit,int offset){
		return guestComponent.findAllGuest(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 客人信息表
	 * @param id
	 * @return
	 */
	public Guest findGuest(long id){
		return guestComponent.findGuest(id);
	}
	
	/** 
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGuestForPageinfo(String where, String orderby,PageInfo pageinfo){
		return guestComponent.findAllGuest(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找客人信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuestBySql(String sql,int limit,int offset){
		return guestComponent.findAllGuest(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 客人信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGuestBySql(String sql){
		return guestComponent.excuteGuestBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGuestBySql(String sql){
		return guestComponent.countGuestBySql(sql);
	}
	
//	private IGenuserComponent genuserComponent;
//	  
// 	
// 	public IGenuserComponent getGenuserComponent() {
//		return genuserComponent;
//	}
//	public void setGenuserComponent(IGenuserComponent  genuserComponent) {
//		this.genuserComponent = genuserComponent;
//	}
//	/**
//	 * 创建 常用旅客
//	 * @param id
//	 * @return deleted count 
//	 */
//	public Genuser createGenuser(Genuser genuser) throws SQLException{
//	
//		return genuserComponent.createGenuser(genuser);
//	}
//	/**
//	 * 删除 常用旅客
//	 * @param id
//	 * @return deleted count 
//	 */
//	public int deleteGenuser(long id){
//	
//		return genuserComponent.deleteGenuser(id);
//	}
//	
//	
//	/**
//	 * 修改 常用旅客
//	 * @param id
//	 * @return updated count 
//	 */
//	public int updateGenuser(Genuser genuser){
//		return genuserComponent.updateGenuser(genuser);
//	
//	}
//
//		
//	/**
//	 * 修改 常用旅客但忽略空值 
//	 * @param id
//	 * @return 
//	 */
//	public int updateGenuserIgnoreNull(Genuser genuser){
//			return genuserComponent.updateGenuserIgnoreNull(genuser);
//	
//	}
//	
//	/**
//	 * 查找 常用旅客
//	 * @param where
//	 * @param orderby
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllGenuser(String where, String orderby,int limit,int offset){
//		return genuserComponent.findAllGenuser(where, orderby,limit,offset);
//	}
//		
//	
//	/**
//	 * 查找 常用旅客
//	 * @param id
//	 * @return
//	 */
//	public Genuser findGenuser(long id){
//		return genuserComponent.findGenuser(id);
//	}
//	
//	/** 
//	 * 查找 常用旅客
//	 * @param where
//	 * @param orderby
//	 * @param pageinfo
//	 * @return
//	 */
//	public List findAllGenuserForPageinfo(String where, String orderby,PageInfo pageinfo){
//		return genuserComponent.findAllGenuser(where, orderby,pageinfo);
//	}
//		
//	/** 
//	 * 根据Sql查找常用旅客
//	 * @param sql
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllGenuserBySql(String sql,int limit,int offset){
//		return genuserComponent.findAllGenuser(sql,limit,offset);
//	}
//	
//	
//	/**
//	 * 执行Sql 常用旅客
//	 * @param sql 
//	 * @return updated count 
//	 */
//	public int excuteGenuserBySql(String sql){
//		return genuserComponent.excuteGenuserBySql(sql);
//	}
//	
//	/**
//	 * 执行Sql 
//	 * @param sql 
//	 * @return  count 
//	 */
//	public int countGenuserBySql(String sql){
//		return genuserComponent.countGenuserBySql(sql);
//	}
private IProvinceComponent provinceComponent;
	  
 	
 	public IProvinceComponent getProvinceComponent() {
		return provinceComponent;
	}
	public void setProvinceComponent(IProvinceComponent  provinceComponent) {
		this.provinceComponent = provinceComponent;
	}
	/**
	 * 创建 省份
	 * @param id
	 * @return deleted count 
	 */
	public Province createProvince(Province province) throws SQLException{
	
		return provinceComponent.createProvince(province);
	}
	/**
	 * 删除 省份
	 * @param id
	 * @return deleted count 
	 */
	public int deleteProvince(long id){
	
		return provinceComponent.deleteProvince(id);
	}
	
	
	/**
	 * 修改 省份
	 * @param id
	 * @return updated count 
	 */
	public int updateProvince(Province province){
		return provinceComponent.updateProvince(province);
	
	}

		
	/**
	 * 修改 省份但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateProvinceIgnoreNull(Province province){
			return provinceComponent.updateProvinceIgnoreNull(province);
	
	}
	
	/**
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String where, String orderby,int limit,int offset){
		return provinceComponent.findAllProvince(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 省份
	 * @param id
	 * @return
	 */
	public Province findProvince(long id){
		return provinceComponent.findProvince(id);
	}
	/**
	 * 查找 省份 by language
	 * @param id
	 * @return
	 */
	public Province findProvincebylanguage(long id,Integer language){
		return provinceComponent.findProvincebylanguage(id,language);
	}
	/** 
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllProvinceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return provinceComponent.findAllProvince(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找省份
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvinceBySql(String sql,int limit,int offset){
		return provinceComponent.findAllProvince(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 省份
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteProvinceBySql(String sql){
		return provinceComponent.excuteProvinceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countProvinceBySql(String sql){
		return provinceComponent.countProvinceBySql(sql);
	}

	
	private ICityComponent cityComponent;
	  
 	
 	public ICityComponent getCityComponent() {
		return cityComponent;
	}
	public void setCityComponent(ICityComponent  cityComponent) {
		this.cityComponent = cityComponent;
	}
	/**
	 * 创建 地级市
	 * @param id
	 * @return deleted count 
	 */
	public City createCity(City city) throws SQLException{
	
		return cityComponent.createCity(city);
	}
	/**
	 * 删除 地级市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCity(long id){
	
		return cityComponent.deleteCity(id);
	}
	
	
	/**
	 * 修改 地级市
	 * @param id
	 * @return updated count 
	 */
	public int updateCity(City city){
		return cityComponent.updateCity(city);
	
	}

		
	/**
	 * 修改 地级市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityIgnoreNull(City city){
			return cityComponent.updateCityIgnoreNull(city);
	
	}
	
	/**
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String where, String orderby,int limit,int offset){
		return cityComponent.findAllCity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCity(long id){
		return cityComponent.findCity(id);
	}
	
	/** 
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return cityComponent.findAllCity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找地级市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityBySql(String sql,int limit,int offset){
		return cityComponent.findAllCity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 地级市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityBySql(String sql){
		return cityComponent.excuteCityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityBySql(String sql){
		return cityComponent.countCityBySql(sql);
	}
	
	

	private ILandmarkComponent landmarkComponent;
	  
 	
 	public ILandmarkComponent getLandmarkComponent() {
		return landmarkComponent;
	}
	public void setLandmarkComponent(ILandmarkComponent  landmarkComponent) {
		this.landmarkComponent = landmarkComponent;
	}
	/**
	 * 创建 地标
	 * @param id
	 * @return deleted count 
	 */
	public Landmark createLandmark(Landmark landmark) throws SQLException{
	
		return landmarkComponent.createLandmark(landmark);
	}
	/**
	 * 删除 地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLandmark(long id){
	
		return landmarkComponent.deleteLandmark(id);
	}
	
	
	/**
	 * 修改 地标
	 * @param id
	 * @return updated count 
	 */
	public int updateLandmark(Landmark landmark){
		return landmarkComponent.updateLandmark(landmark);
	
	}

		
	/**
	 * 修改 地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLandmarkIgnoreNull(Landmark landmark){
			return landmarkComponent.updateLandmarkIgnoreNull(landmark);
	
	}
	
	/**
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,int limit,int offset){
		return landmarkComponent.findAllLandmark(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmark(long id){
		return landmarkComponent.findLandmark(id);
	}
	
	/** 
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLandmarkForPageinfo(String where, String orderby,PageInfo pageinfo){
		return landmarkComponent.findAllLandmark(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmarkBySql(String sql,int limit,int offset){
		return landmarkComponent.findAllLandmark(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLandmarkBySql(String sql){
		return landmarkComponent.excuteLandmarkBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLandmarkBySql(String sql){
		return landmarkComponent.countLandmarkBySql(sql);
	}
	
	
	private IRegionComponent regionComponent;
	  
 	
 	public IRegionComponent getRegionComponent() {
		return regionComponent;
	}
	public void setRegionComponent(IRegionComponent  regionComponent) {
		this.regionComponent = regionComponent;
	}
	/**
	 * 创建 区域
	 * @param id
	 * @return deleted count 
	 */
	public Region createRegion(Region region) throws SQLException{
	
		return regionComponent.createRegion(region);
	}
	/**
	 * 删除 区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRegion(long id){
	
		return regionComponent.deleteRegion(id);
	}
	
	
	/**
	 * 修改 区域
	 * @param id
	 * @return updated count 
	 */
	public int updateRegion(Region region){
		return regionComponent.updateRegion(region);
	
	}

		
	/**
	 * 修改 区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRegionIgnoreNull(Region region){
			return regionComponent.updateRegionIgnoreNull(region);
	
	}
	
	/**
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String where, String orderby,int limit,int offset){
		return regionComponent.findAllRegion(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 区域
	 * @param id
	 * @return
	 */
	public Region findRegion(long id){
		return regionComponent.findRegion(id);
	}
	
	/** 
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRegionForPageinfo(String where, String orderby,PageInfo pageinfo){
		return regionComponent.findAllRegion(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegionBySql(String sql,int limit,int offset){
		return regionComponent.findAllRegion(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRegionBySql(String sql){
		return regionComponent.excuteRegionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRegionBySql(String sql){
		return regionComponent.countRegionBySql(sql);
	}
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCitybylanguage(long id,Integer language){
		return cityComponent.findCitybylanguage(id,language);
	}

	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmarkbylanguage(long id,Integer language){
		return landmarkComponent.findLandmarkbylanguage(id,language);
	}
	/**
	 * 查找 区域
	 * @param id
	 * @return
	 */
	public Region findRegionbylanguage(long id,Integer language){
		return regionComponent.findRegionbylanguage(id,language);
	}

	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotelbylanguage(long id,Integer language){
		return hotelComponent.findHotelbylanguage(id,language);
	}

	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontractbylanguage(long id,Integer language){
		return hotelcontractComponent.findHotelcontractbylanguage(id,language);
	}
	/**
	 * 查找 酒店图片
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimagebylanguage(long id,Integer language){
		return hotelimageComponent.findHotelimagebylanguage(id,language);
	}
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmarkbylanguage(long id,Integer language){
		return hotellandmarkComponent.findHotellandmarkbylanguage(id,language);
	}
	/**
	 * 查找 酒店联系人
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkmanbylanguage(long id,Integer language){
		return hotellinkmanComponent.findHotellinkmanbylanguage(id,language);
	}
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrcbylanguage(long id,Integer language){
		return hotelorderrcComponent.findHotelorderrcbylanguage(id,language);
	}
	/**
	 * 查找 酒店价格
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelpricebylanguage(long id,Integer language){
		return hotelpriceComponent.findHotelpricebylanguage(id,language);
	}
	/**
	 * 查找 酒店注意事项
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspecbylanguage(long id,Integer language){
		return hotelspecComponent.findHotelspecbylanguage(id,language);
	}
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstatebylanguage(long id,Integer language){
		return roomstateComponent.findRoomstatebylanguage(id,language);
	}

	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstatebackbylanguage(long id,Integer language){
		return roomstatebackComponent.findRoomstatebackbylanguage(id,language);
	}

	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtypebylanguage(long id,Integer language){
		return roomtypeComponent.findRoomtypebylanguage(id,language);
	}
	/////////////////////
	private IChaininfoComponent chaininfoComponent;
	  
 	
 	public IChaininfoComponent getChaininfoComponent() {
		return chaininfoComponent;
	}
	public void setChaininfoComponent(IChaininfoComponent  chaininfoComponent) {
		this.chaininfoComponent = chaininfoComponent;
	}
	/**
	 * 创建 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public Chaininfo createChaininfo(Chaininfo chaininfo) throws SQLException{
	
		return chaininfoComponent.createChaininfo(chaininfo);
	}
	/**
	 * 删除 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChaininfo(long id){
	
		return chaininfoComponent.deleteChaininfo(id);
	}
	
	
	/**
	 * 修改 连锁酒店类型
	 * @param id
	 * @return updated count 
	 */
	public int updateChaininfo(Chaininfo chaininfo){
		return chaininfoComponent.updateChaininfo(chaininfo);
	
	}

		
	/**
	 * 修改 连锁酒店类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChaininfoIgnoreNull(Chaininfo chaininfo){
			return chaininfoComponent.updateChaininfoIgnoreNull(chaininfo);
	
	}
	
	/**
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,int limit,int offset){
		return chaininfoComponent.findAllChaininfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param id
	 * @return
	 */
	public Chaininfo findChaininfo(long id){
		return chaininfoComponent.findChaininfo(id);
	}
	
	/** 
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChaininfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return chaininfoComponent.findAllChaininfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找连锁酒店类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfoBySql(String sql,int limit,int offset){
		return chaininfoComponent.findAllChaininfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 连锁酒店类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChaininfoBySql(String sql){
		return chaininfoComponent.excuteChaininfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChaininfoBySql(String sql){
		return chaininfoComponent.countChaininfoBySql(sql);
	}
	
	//
//粘贴到Service实现类
	
	private IHotelfanComponent hotelfanComponent;
	  
 	
 	public IHotelfanComponent getHotelfanComponent() {
		return hotelfanComponent;
	}
	public void setHotelfanComponent(IHotelfanComponent  hotelfanComponent) {
		this.hotelfanComponent = hotelfanComponent;
	}
	/**
	 * 创建 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelfan createHotelfan(Hotelfan hotelfan) throws SQLException{
	
		return hotelfanComponent.createHotelfan(hotelfan);
	}
	/**
	 * 删除 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelfan(long id){
	
		return hotelfanComponent.deleteHotelfan(id);
	}
	
	
	/**
	 * 修改 酒店设置返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelfan(Hotelfan hotelfan){
		return hotelfanComponent.updateHotelfan(hotelfan);
	
	}

		
	/**
	 * 修改 酒店设置返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelfanIgnoreNull(Hotelfan hotelfan){
			return hotelfanComponent.updateHotelfanIgnoreNull(hotelfan);
	
	}
	
	/**
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,int limit,int offset){
		return hotelfanComponent.findAllHotelfan(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param id
	 * @return
	 */
	public Hotelfan findHotelfan(long id){
		return hotelfanComponent.findHotelfan(id);
	}
	
	/** 
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelfanForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelfanComponent.findAllHotelfan(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店设置返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfanBySql(String sql,int limit,int offset){
		return hotelfanComponent.findAllHotelfan(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店设置返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelfanBySql(String sql){
		return hotelfanComponent.excuteHotelfanBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelfanBySql(String sql){
		return hotelfanComponent.countHotelfanBySql(sql);
	}
	
	//
//粘贴到Service实现类
	
	private ISysmessageComponent sysmessageComponent;
	  
 	
 	public ISysmessageComponent getSysmessageComponent() {
		return sysmessageComponent;
	}
	public void setSysmessageComponent(ISysmessageComponent  sysmessageComponent) {
		this.sysmessageComponent = sysmessageComponent;
	}
	/**
	 * 创建 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public Sysmessage createSysmessage(Sysmessage sysmessage) throws SQLException{
	
		return sysmessageComponent.createSysmessage(sysmessage);
	}
	/**
	 * 删除 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysmessage(long id){
	
		return sysmessageComponent.deleteSysmessage(id);
	}
	
	
	/**
	 * 修改 消息公告
	 * @param id
	 * @return updated count 
	 */
	public int updateSysmessage(Sysmessage sysmessage){
		return sysmessageComponent.updateSysmessage(sysmessage);
	
	}

		
	/**
	 * 修改 消息公告但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysmessageIgnoreNull(Sysmessage sysmessage){
			return sysmessageComponent.updateSysmessageIgnoreNull(sysmessage);
	
	}
	
	/**
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,int limit,int offset){
		return sysmessageComponent.findAllSysmessage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 消息公告
	 * @param id
	 * @return
	 */
	public Sysmessage findSysmessage(long id){
		return sysmessageComponent.findSysmessage(id);
	}
	
	/** 
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysmessageForPageinfo(String where, String orderby,PageInfo pageinfo){
		return sysmessageComponent.findAllSysmessage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找消息公告
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessageBySql(String sql,int limit,int offset){
		return sysmessageComponent.findAllSysmessage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 消息公告
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysmessageBySql(String sql){
		return sysmessageComponent.excuteSysmessageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysmessageBySql(String sql){
		return sysmessageComponent.countSysmessageBySql(sql);
	}
	
	//
//粘贴到Service实现类
	
	private IPaymentrecorderComponent paymentrecorderComponent;
	  
 	
 	public IPaymentrecorderComponent getPaymentrecorderComponent() {
		return paymentrecorderComponent;
	}
	public void setPaymentrecorderComponent(IPaymentrecorderComponent  paymentrecorderComponent) {
		this.paymentrecorderComponent = paymentrecorderComponent;
	}
	/**
	 * 创建 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public Paymentrecorder createPaymentrecorder(Paymentrecorder paymentrecorder) throws SQLException{
	
		return paymentrecorderComponent.createPaymentrecorder(paymentrecorder);
	}
	/**
	 * 删除 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePaymentrecorder(long id){
	
		return paymentrecorderComponent.deletePaymentrecorder(id);
	}
	
	
	/**
	 * 修改 支付记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePaymentrecorder(Paymentrecorder paymentrecorder){
		return paymentrecorderComponent.updatePaymentrecorder(paymentrecorder);
	
	}

		
	/**
	 * 修改 支付记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePaymentrecorderIgnoreNull(Paymentrecorder paymentrecorder){
			return paymentrecorderComponent.updatePaymentrecorderIgnoreNull(paymentrecorder);
	
	}
	
	/**
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,int limit,int offset){
		return paymentrecorderComponent.findAllPaymentrecorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 支付记录
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorder(long id){
		return paymentrecorderComponent.findPaymentrecorder(id);
	}
	
	/**
	 * 查找 支付记录
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorderbylanguage(long id,Integer language){
		return paymentrecorderComponent.findPaymentrecorderbylanguage(id,language);
	}
	/** 
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPaymentrecorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return paymentrecorderComponent.findAllPaymentrecorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找支付记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorderBySql(String sql,int limit,int offset){
		return paymentrecorderComponent.findAllPaymentrecorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 支付记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePaymentrecorderBySql(String sql){
		return paymentrecorderComponent.excutePaymentrecorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPaymentrecorderBySql(String sql){
		return paymentrecorderComponent.countPaymentrecorderBySql(sql);
	}
	
	//
private IDcampaignComponent dcampaignComponent;
	  
 	
 	public IDcampaignComponent getDcampaignComponent() {
		return dcampaignComponent;
	}
	public void setDcampaignComponent(IDcampaignComponent  dcampaignComponent) {
		this.dcampaignComponent = dcampaignComponent;
	}
	/**
	 * 创建 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public Dcampaign createDcampaign(Dcampaign dcampaign) throws SQLException{
	
		return dcampaignComponent.createDcampaign(dcampaign);
	}
	/**
	 * 删除 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDcampaign(long id){
	
		return dcampaignComponent.deleteDcampaign(id);
	}
	
	
	/**
	 * 修改 电子优惠卷活动
	 * @param id
	 * @return updated count 
	 */
	public int updateDcampaign(Dcampaign dcampaign){
		return dcampaignComponent.updateDcampaign(dcampaign);
	
	}

		
	/**
	 * 修改 电子优惠卷活动但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDcampaignIgnoreNull(Dcampaign dcampaign){
			return dcampaignComponent.updateDcampaignIgnoreNull(dcampaign);
	
	}
	
	/**
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,int limit,int offset){
		return dcampaignComponent.findAllDcampaign(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 电子优惠卷活动
	 * @param id
	 * @return
	 */
	public Dcampaign findDcampaign(long id){
		return dcampaignComponent.findDcampaign(id);
	}
	
	/** 
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDcampaignForPageinfo(String where, String orderby,PageInfo pageinfo){
		return dcampaignComponent.findAllDcampaign(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找电子优惠卷活动
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaignBySql(String sql,int limit,int offset){
		return dcampaignComponent.findAllDcampaign(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 电子优惠卷活动
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDcampaignBySql(String sql){
		return dcampaignComponent.excuteDcampaignBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDcampaignBySql(String sql){
		return dcampaignComponent.countDcampaignBySql(sql);
	}
	
	//
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHotelagentComponent hotelagentComponent;
	  
 	
 	public IHotelagentComponent getHotelagentComponent() {
		return hotelagentComponent;
	}
	public void setHotelagentComponent(IHotelagentComponent  hotelagentComponent) {
		this.hotelagentComponent = hotelagentComponent;
	}
	/**
	 * 创建 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelagent createHotelagent(Hotelagent hotelagent) throws SQLException{
	
		return hotelagentComponent.createHotelagent(hotelagent);
	}
	/**
	 * 删除 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelagent(long id){
	
		return hotelagentComponent.deleteHotelagent(id);
	}
	
	
	/**
	 * 修改 加盟商返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelagent(Hotelagent hotelagent){
		return hotelagentComponent.updateHotelagent(hotelagent);
	
	}

		
	/**
	 * 修改 加盟商返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelagentIgnoreNull(Hotelagent hotelagent){
			return hotelagentComponent.updateHotelagentIgnoreNull(hotelagent);
	
	}
	
	/**
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,int limit,int offset){
		return hotelagentComponent.findAllHotelagent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商返点表
	 * @param id
	 * @return
	 */
	public Hotelagent findHotelagent(long id){
		return hotelagentComponent.findHotelagent(id);
	}
	
	/** 
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelagentForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelagentComponent.findAllHotelagent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagentBySql(String sql,int limit,int offset){
		return hotelagentComponent.findAllHotelagent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelagentBySql(String sql){
		return hotelagentComponent.excuteHotelagentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelagentBySql(String sql){
		return hotelagentComponent.countHotelagentBySql(sql);
	}
	
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHotelstarComponent hotelstarComponent;
	  
 	
 	public IHotelstarComponent getHotelstarComponent() {
		return hotelstarComponent;
	}
	public void setHotelstarComponent(IHotelstarComponent  hotelstarComponent) {
		this.hotelstarComponent = hotelstarComponent;
	}
	/**
	 * 创建 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstar createHotelstar(Hotelstar hotelstar) throws SQLException{
	
		return hotelstarComponent.createHotelstar(hotelstar);
	}
	/**
	 * 删除 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstar(long id){
	
		return hotelstarComponent.deleteHotelstar(id);
	}
	
	
	/**
	 * 修改 酒店星级返点对应表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstar(Hotelstar hotelstar){
		return hotelstarComponent.updateHotelstar(hotelstar);
	
	}

		
	/**
	 * 修改 酒店星级返点对应表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstarIgnoreNull(Hotelstar hotelstar){
			return hotelstarComponent.updateHotelstarIgnoreNull(hotelstar);
	
	}
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstar(String where, String orderby,int limit,int offset){
		return hotelstarComponent.findAllHotelstar(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param id
	 * @return
	 */
	public Hotelstar findHotelstar(long id){
		return hotelstarComponent.findHotelstar(id);
	}
	
	/** 
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstarForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelstarComponent.findAllHotelstar(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店星级返点对应表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstarBySql(String sql,int limit,int offset){
		return hotelstarComponent.findAllHotelstar(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店星级返点对应表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstarBySql(String sql){
		return hotelstarComponent.excuteHotelstarBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstarBySql(String sql){
		return hotelstarComponent.countHotelstarBySql(sql);
	}




	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHotelpassComponent hotelpassComponent;
	  
 	
 	public IHotelpassComponent getHotelpassComponent() {
		return hotelpassComponent;
	}
	public void setHotelpassComponent(IHotelpassComponent  hotelpassComponent) {
		this.hotelpassComponent = hotelpassComponent;
	}
	/**
	 * 创建 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelpass createHotelpass(Hotelpass hotelpass) throws SQLException{
	
		return hotelpassComponent.createHotelpass(hotelpass);
	}
	/**
	 * 删除 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelpass(long id){
	
		return hotelpassComponent.deleteHotelpass(id);
	}
	
	
	/**
	 * 修改 酒店常用入住人表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelpass(Hotelpass hotelpass){
		return hotelpassComponent.updateHotelpass(hotelpass);
	
	}

		
	/**
	 * 修改 酒店常用入住人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpassIgnoreNull(Hotelpass hotelpass){
			return hotelpassComponent.updateHotelpassIgnoreNull(hotelpass);
	
	}
	
	/**
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpass(String where, String orderby,int limit,int offset){
		return hotelpassComponent.findAllHotelpass(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店常用入住人表
	 * @param id
	 * @return
	 */
	public Hotelpass findHotelpass(long id){
		return hotelpassComponent.findHotelpass(id);
	}
	
	/** 
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelpassForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelpassComponent.findAllHotelpass(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店常用入住人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpassBySql(String sql,int limit,int offset){
		return hotelpassComponent.findAllHotelpass(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店常用入住人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpassBySql(String sql){
		return hotelpassComponent.excuteHotelpassBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpassBySql(String sql){
		return hotelpassComponent.countHotelpassBySql(sql);
	}

private IDataprovideComponent dataprovideComponent;
	  
 	
 	public IDataprovideComponent getDataprovideComponent() {
		return dataprovideComponent;
	}
	public void setDataprovideComponent(IDataprovideComponent  dataprovideComponent) {
		this.dataprovideComponent = dataprovideComponent;
	}
	/**
	 * 创建 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public Dataprovide createDataprovide(Dataprovide dataprovide) throws SQLException{
	
		return dataprovideComponent.createDataprovide(dataprovide);
	}
	/**
	 * 删除 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDataprovide(long id){
	
		return dataprovideComponent.deleteDataprovide(id);
	}
	
	
	/**
	 * 修改 酒店数据提供商
	 * @param id
	 * @return updated count 
	 */
	public int updateDataprovide(Dataprovide dataprovide){
		return dataprovideComponent.updateDataprovide(dataprovide);
	
	}

		
	/**
	 * 修改 酒店数据提供商但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDataprovideIgnoreNull(Dataprovide dataprovide){
			return dataprovideComponent.updateDataprovideIgnoreNull(dataprovide);
	
	}
	
	/**
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovide(String where, String orderby,int limit,int offset){
		return dataprovideComponent.findAllDataprovide(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店数据提供商
	 * @param id
	 * @return
	 */
	public Dataprovide findDataprovide(long id){
		return dataprovideComponent.findDataprovide(id);
	}
	
	/** 
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDataprovideForPageinfo(String where, String orderby,PageInfo pageinfo){
		return dataprovideComponent.findAllDataprovide(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店数据提供商
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovideBySql(String sql,int limit,int offset){
		return dataprovideComponent.findAllDataprovide(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店数据提供商
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDataprovideBySql(String sql){
		return dataprovideComponent.excuteDataprovideBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDataprovideBySql(String sql){
		return dataprovideComponent.countDataprovideBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHotelstartComponent hotelstartComponent;
	  
 	
 	public IHotelstartComponent getHotelstartComponent() {
		return hotelstartComponent;
	}
	public void setHotelstartComponent(IHotelstartComponent  hotelstartComponent) {
		this.hotelstartComponent = hotelstartComponent;
	}
	/**
	 * 创建 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstart createHotelstart(Hotelstart hotelstart) throws SQLException{
	
		return hotelstartComponent.createHotelstart(hotelstart);
	}
	/**
	 * 删除 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstart(long id){
	
		return hotelstartComponent.deleteHotelstart(id);
	}
	
	
	/**
	 * 修改 酒店星级返利
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstart(Hotelstart hotelstart){
		return hotelstartComponent.updateHotelstart(hotelstart);
	
	}

		
	/**
	 * 修改 酒店星级返利但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstartIgnoreNull(Hotelstart hotelstart){
			return hotelstartComponent.updateHotelstartIgnoreNull(hotelstart);
	
	}
	
	/**
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,int limit,int offset){
		return hotelstartComponent.findAllHotelstart(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店星级返利
	 * @param id
	 * @return
	 */
	public Hotelstart findHotelstart(long id){
		return hotelstartComponent.findHotelstart(id);
	}
	
	/** 
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstartForPageinfo(String where, String orderby,PageInfo pageinfo){
		return hotelstartComponent.findAllHotelstart(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店星级返利
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstartBySql(String sql,int limit,int offset){
		return hotelstartComponent.findAllHotelstart(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店星级返利
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstartBySql(String sql){
		return hotelstartComponent.excuteHotelstartBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstartBySql(String sql){
		return hotelstartComponent.countHotelstartBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IStarrecordComponent starrecordComponent;
	  
 	
 	public IStarrecordComponent getStarrecordComponent() {
		return starrecordComponent;
	}
	public void setStarrecordComponent(IStarrecordComponent  starrecordComponent) {
		this.starrecordComponent = starrecordComponent;
	}
	/**
	 * 创建 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public Starrecord createStarrecord(Starrecord starrecord) throws SQLException{
	
		return starrecordComponent.createStarrecord(starrecord);
	}
	/**
	 * 删除 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarrecord(long id){
	
		return starrecordComponent.deleteStarrecord(id);
	}
	
	
	/**
	 * 修改 星级留点记录
	 * @param id
	 * @return updated count 
	 */
	public int updateStarrecord(Starrecord starrecord){
		return starrecordComponent.updateStarrecord(starrecord);
	
	}

		
	/**
	 * 修改 星级留点记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarrecordIgnoreNull(Starrecord starrecord){
			return starrecordComponent.updateStarrecordIgnoreNull(starrecord);
	
	}
	
	/**
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,int limit,int offset){
		return starrecordComponent.findAllStarrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级留点记录
	 * @param id
	 * @return
	 */
	public Starrecord findStarrecord(long id){
		return starrecordComponent.findStarrecord(id);
	}
	
	/** 
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return starrecordComponent.findAllStarrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级留点记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecordBySql(String sql,int limit,int offset){
		return starrecordComponent.findAllStarrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级留点记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarrecordBySql(String sql){
		return starrecordComponent.excuteStarrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarrecordBySql(String sql){
		return starrecordComponent.countStarrecordBySql(sql);
	}


	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IStarreinfoComponent starreinfoComponent;
	  
 	
 	public IStarreinfoComponent getStarreinfoComponent() {
		return starreinfoComponent;
	}
	public void setStarreinfoComponent(IStarreinfoComponent  starreinfoComponent) {
		this.starreinfoComponent = starreinfoComponent;
	}
	/**
	 * 创建 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public Starreinfo createStarreinfo(Starreinfo starreinfo) throws SQLException{
	
		return starreinfoComponent.createStarreinfo(starreinfo);
	}
	/**
	 * 删除 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarreinfo(long id){
	
		return starreinfoComponent.deleteStarreinfo(id);
	}
	
	
	/**
	 * 修改 星级返点设置关联
	 * @param id
	 * @return updated count 
	 */
	public int updateStarreinfo(Starreinfo starreinfo){
		return starreinfoComponent.updateStarreinfo(starreinfo);
	
	}

		
	/**
	 * 修改 星级返点设置关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarreinfoIgnoreNull(Starreinfo starreinfo){
			return starreinfoComponent.updateStarreinfoIgnoreNull(starreinfo);
	
	}
	
	/**
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,int limit,int offset){
		return starreinfoComponent.findAllStarreinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级返点设置关联
	 * @param id
	 * @return
	 */
	public Starreinfo findStarreinfo(long id){
		return starreinfoComponent.findStarreinfo(id);
	}
	
	/** 
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarreinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return starreinfoComponent.findAllStarreinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级返点设置关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfoBySql(String sql,int limit,int offset){
		return starreinfoComponent.findAllStarreinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级返点设置关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarreinfoBySql(String sql){
		return starreinfoComponent.excuteStarreinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarreinfoBySql(String sql){
		return starreinfoComponent.countStarreinfoBySql(sql);
	}
	
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IStarsettlementtypeComponent starsettlementtypeComponent;
	  
 	
 	public IStarsettlementtypeComponent getStarsettlementtypeComponent() {
		return starsettlementtypeComponent;
	}
	public void setStarsettlementtypeComponent(IStarsettlementtypeComponent  starsettlementtypeComponent) {
		this.starsettlementtypeComponent = starsettlementtypeComponent;
	}
	/**
	 * 创建 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public Starsettlementtype createStarsettlementtype(Starsettlementtype starsettlementtype) throws SQLException{
	
		return starsettlementtypeComponent.createStarsettlementtype(starsettlementtype);
	}
	/**
	 * 删除 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarsettlementtype(long id){
	
		return starsettlementtypeComponent.deleteStarsettlementtype(id);
	}
	
	
	/**
	 * 修改 星级结算分类
	 * @param id
	 * @return updated count 
	 */
	public int updateStarsettlementtype(Starsettlementtype starsettlementtype){
		return starsettlementtypeComponent.updateStarsettlementtype(starsettlementtype);
	
	}

		
	/**
	 * 修改 星级结算分类但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarsettlementtypeIgnoreNull(Starsettlementtype starsettlementtype){
			return starsettlementtypeComponent.updateStarsettlementtypeIgnoreNull(starsettlementtype);
	
	}
	
	/**
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,int limit,int offset){
		return starsettlementtypeComponent.findAllStarsettlementtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 星级结算分类
	 * @param id
	 * @return
	 */
	public Starsettlementtype findStarsettlementtype(long id){
		return starsettlementtypeComponent.findStarsettlementtype(id);
	}
	
	/** 
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarsettlementtypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return starsettlementtypeComponent.findAllStarsettlementtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找星级结算分类
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtypeBySql(String sql,int limit,int offset){
		return starsettlementtypeComponent.findAllStarsettlementtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 星级结算分类
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarsettlementtypeBySql(String sql){
		return starsettlementtypeComponent.excuteStarsettlementtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarsettlementtypeBySql(String sql){
		return starsettlementtypeComponent.countStarsettlementtypeBySql(sql);
	}


}
