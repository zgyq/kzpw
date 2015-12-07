package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.chaininfo.Chaininfo;
import com.yf.system.base.city.City;
import com.yf.system.base.dataprovide.Dataprovide;
import com.yf.system.base.dcampaign.Dcampaign;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelagent.Hotelagent;
import com.yf.system.base.hotelcontract.Hotelcontract;
import com.yf.system.base.hotelfan.Hotelfan;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.hotellandmark.Hotellandmark;
import com.yf.system.base.hotellinkman.Hotellinkman;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.hotelpass.Hotelpass;
import com.yf.system.base.hotelprice.Hotelprice;
import com.yf.system.base.hotelspec.Hotelspec;
import com.yf.system.base.hotelstar.Hotelstar;
import com.yf.system.base.hotelstart.Hotelstart;
import com.yf.system.base.landmark.Landmark;
import com.yf.system.base.paymentrecorder.Paymentrecorder;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.roomstate.Roomstate;
import com.yf.system.base.roomstateback.Roomstateback;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.starrecord.Starrecord;
import com.yf.system.base.starreinfo.Starreinfo;
import com.yf.system.base.starsettlementtype.Starsettlementtype;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.util.PageInfo;


public interface IHotelService {
	
	/**
	 * 创建 酒店
	 * @param id
	 * @return deleted count 
	 */
	public Hotel createHotel(Hotel hotel) throws SQLException;
	
	/**
	 * 删除 酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotel(long id);
	
	
	/**
	 * 修改 酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateHotel(Hotel hotel);

		
	/**
	 * 修改 酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelIgnoreNull(Hotel hotel);
		
	
	/**
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotel(long id);
	
	
	/** 
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelBySql(String sql);
	
	//-----------------------------------------------------酒店合同
	/**
	 * 创建 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public Hotelcontract createHotelcontract(Hotelcontract hotelcontract) throws SQLException;
	
	/**
	 * 删除 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelcontract(long id);
	
	
	/**
	 * 修改 酒店合同
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelcontract(Hotelcontract hotelcontract);

		
	/**
	 * 修改 酒店合同但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelcontractIgnoreNull(Hotelcontract hotelcontract);
		
	
	/**
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontract(long id);
	
	
	/** 
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelcontractForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店合同
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontractBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店合同
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelcontractBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelcontractBySql(String sql);
	
	//-----------------------------------------------------酒店注意事项
	/**
	 * 创建 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Hotelspec createHotelspec(Hotelspec hotelspec) throws SQLException;
	
	/**
	 * 删除 酒店注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelspec(long id);
	
	
	/**
	 * 修改 酒店注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelspec(Hotelspec hotelspec);

		
	/**
	 * 修改 酒店注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelspecIgnoreNull(Hotelspec hotelspec);
		
	
	/**
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspec(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店注意事项
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspec(long id);
	
	
	/** 
	 * 查找 酒店注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelspecForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelspecBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelspecBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelspecBySql(String sql);
	
	
	//图片
	
	/**
	 * 创建 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public Hotelimage createHotelimage(Hotelimage hotelimage) throws SQLException;
	
	/**
	 * 删除 酒店图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelimage(long id);
	
	
	/**
	 * 修改 酒店图片
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelimage(Hotelimage hotelimage);

		
	/**
	 * 修改 酒店图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelimageIgnoreNull(Hotelimage hotelimage);
		
	
	/**
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimage(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店图片
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimage(long id);
	
	
	/** 
	 * 查找 酒店图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelimageForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelimageBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelimageBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelimageBySql(String sql);
	
	//联系人
	/**
	 * 创建 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public Hotellinkman createHotellinkman(Hotellinkman hotellinkman) throws SQLException;
	
	/**
	 * 删除 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellinkman(long id);
	
	
	/**
	 * 修改 酒店联系人
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellinkman(Hotellinkman hotellinkman);

		
	/**
	 * 修改 酒店联系人但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellinkmanIgnoreNull(Hotellinkman hotellinkman);
		
	
	/**
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店联系人
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkman(long id);
	
	
	/** 
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellinkmanForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店联系人
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkmanBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店联系人
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellinkmanBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellinkmanBySql(String sql);
	
	//地标
	/**
	 * 创建 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public Hotellandmark createHotellandmark(Hotellandmark hotellandmark) throws SQLException;
	
	/**
	 * 删除 酒店地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellandmark(long id);
	
	
	/**
	 * 修改 酒店地标
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellandmark(Hotellandmark hotellandmark);

		
	/**
	 * 修改 酒店地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellandmarkIgnoreNull(Hotellandmark hotellandmark);
		
	
	/**
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmark(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店地标
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmark(long id);
	
	
	/** 
	 * 查找 酒店地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellandmarkForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellandmarkBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellandmarkBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellandmarkBySql(String sql);
	
	//房态
	/**
	 * 创建 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public Roomstate createRoomstate(Roomstate roomstate) throws SQLException;
	
	/**
	 * 删除 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstate(long id);
	
	
	/**
	 * 修改 酒店房态
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstate(Roomstate roomstate);

		
	/**
	 * 修改 酒店房态但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstateIgnoreNull(Roomstate roomstate);
		
	
	/**
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstate(long id);
	
	
	/** 
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstateForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房态
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房态
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstateBySql(String sql);
	
	//房型
	/**
	 * 创建 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public Roomtype createRoomtype(Roomtype roomtype) throws SQLException;
	
	/**
	 * 删除 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomtype(long id);
	
	
	/**
	 * 修改 酒店房型
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomtype(Roomtype roomtype);

		
	/**
	 * 修改 酒店房型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomtypeIgnoreNull(Roomtype roomtype);
		
	
	/**
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtype(long id);
	
	
	/** 
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomtypeForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtypeBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomtypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomtypeBySql(String sql);
	
	/**
	 * 创建 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public Hotelprice createHotelprice(Hotelprice hotelprice) throws SQLException;
	
	/**
	 * 删除 酒店价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelprice(long id);
	
	
	/**
	 * 修改 酒店价格
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelprice(Hotelprice hotelprice);

		
	/**
	 * 修改 酒店价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpriceIgnoreNull(Hotelprice hotelprice);
		
	
	/**
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店价格
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelprice(long id);
	
	
	/** 
	 * 查找 酒店价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelpriceForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpriceBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpriceBySql(String sql);
	
//roomstateback
	/**
	 * 创建 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public Roomstateback createRoomstateback(Roomstateback roomstateback) throws SQLException;
	
	/**
	 * 删除 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstateback(long id);
	
	
	/**
	 * 修改 酒店房态表
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstateback(Roomstateback roomstateback);

		
	/**
	 * 修改 酒店房态表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstatebackIgnoreNull(Roomstateback roomstateback);
		
	
	/**
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstateback(long id);
	
	
	/** 
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstatebackForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房态表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstatebackBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房态表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstatebackBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstatebackBySql(String sql);
	
//	/**
//	 * 创建 收藏表
//	 * @param id
//	 * @return deleted count 
//	 */
//	public Collection createCollection(Collection collection) throws SQLException;
//	
//	/**
//	 * 删除 收藏表
//	 * @param id
//	 * @return deleted count 
//	 */
//	public int deleteCollection(long id);
//	
//	
//	/**
//	 * 修改 收藏表
//	 * @param id
//	 * @return updated count 
//	 */
//	public int updateCollection(Collection collection);
//
//		
//	/**
//	 * 修改 收藏表但忽略空值 
//	 * @param id
//	 * @return 
//	 */
//	public int updateCollectionIgnoreNull(Collection collection);
//		
//	
//	/**
//	 * 查找 收藏表
//	 * @param where
//	 * @param orderby
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllCollection(String where, String orderby,int limit,int offset);
//		
//	
//	/**
//	 * 查找 收藏表
//	 * @param id
//	 * @return
//	 */
//	public Collection findCollection(long id);
//	
//	
//	/** 
//	 * 查找 收藏表
//	 * @param where
//	 * @param orderby
//	 * @param pageinfo
//	 * @return
//	 */
//	public List findAllCollectionForPageinfo(String where, String orderby,PageInfo pageinfo);
//		
//	/** 
//	 * 根据Sql查找收藏表
//	 * @param sql
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllCollectionBySql(String sql,int limit,int offset);
//	
//	
//	/**
//	 * 执行Sql 收藏表
//	 * @param sql 
//	 * @return updated count 
//	 */
//	public int excuteCollectionBySql(String sql);
//	
//	/**
//	 * 执行Sql 
//	 * @param sql 
//	 * @return  count 
//	 */
//	public int countCollectionBySql(String sql);
	/**
	 * 创建 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorder createHotelorder(Hotelorder hotelorder) throws SQLException;
	
	/**
	 * 审核酒店
	 * @param hotelorder
	 * @param systemuser
	 * @return
	 * @throws Exception
	 */
	public Hotelorder executeAuditing(Hotelorder hotelorder, String username , String mobile) throws Exception ;
	
	/**
	 * 确认 酒店订单
	 */
	public Hotelorder executeCimfirm(Hotelorder hotelorder, String username, String mobile) throws Exception ;
	
	/**
	 * 确认入住 酒店订单
	 */
	public Hotelorder executePutoff(Hotelorder hotelorder, String username, String mobile) throws Exception ;
	
	/**
	 * 删除 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorder(long id);
	
	
	/**
	 * 修改 酒店订单
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorder(Hotelorder hotelorder) throws Exception ;

	/**
	 * 取消订单
	 * @param hotelorder
	 * @return
	 * @throws Exception
	 */
	public Hotelorder executeCannel(Hotelorder hotelorder) throws Exception  ;
	
	public Long findHotelCinfirmOrderNum(Long id) ;
	
	/**
	 * 修改 酒店订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderIgnoreNull(Hotelorder hotelorder);
	
	/**
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店订单
	 * @param id
	 * @return
	 */
	public Hotelorder findHotelorder(long id);
	
	
	/** 
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderBySql(String sql);
	
	/**
	 * 创建 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorderrc createHotelorderrc(Hotelorderrc hotelorderrc) throws SQLException;
	
	/**
	 * 删除 酒店订单状态日志
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorderrc(long id);
	
	
	/**
	 * 修改 酒店订单状态日志
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorderrc(Hotelorderrc hotelorderrc);

		
	/**
	 * 修改 酒店订单状态日志但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderrcIgnoreNull(Hotelorderrc hotelorderrc);
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrc(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店订单状态日志
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrc(long id);
	
	
	/** 
	 * 查找 酒店订单状态日志
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorderrcForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店订单状态日志
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorderrcBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店订单状态日志
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderrcBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderrcBySql(String sql);
	
	/**
	 * 创建 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public Guest createGuest(Guest guest) throws SQLException;
	
	/**
	 * 删除 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGuest(long id);
	
	
	/**
	 * 修改 客人信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateGuest(Guest guest);

		
	/**
	 * 修改 客人信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGuestIgnoreNull(Guest guest);
		
	
	/**
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 客人信息表
	 * @param id
	 * @return
	 */
	public Guest findGuest(long id);
	
	
	/** 
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGuestForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找客人信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuestBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 客人信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGuestBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGuestBySql(String sql);

//	/**
//	 * 创建 常用旅客
//	 * @param id
//	 * @return deleted count 
//	 */
//	public Genuser createGenuser(Genuser genuser) throws SQLException;
//
//	/**
//	 * 删除 常用旅客
//	 * @param id
//	 * @return deleted count 
//	 */
//	public int deleteGenuser(long id);
//	
//	
//	/**
//	 * 修改 常用旅客
//	 * @param id
//	 * @return updated count 
//	 */
//	public int updateGenuser(Genuser genuser);
//
//		
//	/**
//	 * 修改 常用旅客但忽略空值 
//	 * @param id
//	 * @return 
//	 */
//	public int updateGenuserIgnoreNull(Genuser genuser);
//		
//	
//	/**
//	 * 查找 常用旅客
//	 * @param where
//	 * @param orderby
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllGenuser(String where, String orderby,int limit,int offset);
//		
//	
//	/**
//	 * 查找 常用旅客
//	 * @param id
//	 * @return
//	 */
//	public Genuser findGenuser(long id);
//	
//	
//	/** 
//	 * 查找 常用旅客
//	 * @param where
//	 * @param orderby
//	 * @param pageinfo
//	 * @return
//	 */
//	public List findAllGenuserForPageinfo(String where, String orderby,PageInfo pageinfo);
//		
//	/** 
//	 * 根据Sql查找常用旅客
//	 * @param sql
//	 * @param limit
//	 * @param offset
//	 * @return
//	 */
//	public List findAllGenuserBySql(String sql,int limit,int offset);
//	
//	
//	/**
//	 * 执行Sql 常用旅客
//	 * @param sql 
//	 * @return updated count 
//	 */
//	public int excuteGenuserBySql(String sql);
//	
//	/**
//	 * 执行Sql 
//	 * @param sql 
//	 * @return  count 
//	 */
//	public int countGenuserBySql(String sql);

 	/**
	 * 创建 省份
	 * @param id
	 * @return deleted count 
	 */
	public Province createProvince(Province province) throws SQLException;
	
	/**
	 * 删除 省份
	 * @param id
	 * @return deleted count 
	 */
	public int deleteProvince(long id);
	
	
	/**
	 * 修改 省份
	 * @param id
	 * @return updated count 
	 */
	public int updateProvince(Province province);

		
	/**
	 * 修改 省份但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateProvinceIgnoreNull(Province province);
		
	
	/**
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvince(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 省份
	 * @param id
	 * @return
	 */
	public Province findProvince(long id);
	
	/**
	 * 查找 省份 by language
	 * @param id
	 * @return
	 */
	public Province findProvincebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 省份
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllProvinceForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找省份
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllProvinceBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 省份
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteProvinceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countProvinceBySql(String sql);
	
	
	
 	/**
	 * 创建 地级市
	 * @param id
	 * @return deleted count 
	 */
	public City createCity(City city) throws SQLException;
	
	/**
	 * 删除 地级市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCity(long id);
	
	
	/**
	 * 修改 地级市
	 * @param id
	 * @return updated count 
	 */
	public int updateCity(City city);

		
	/**
	 * 修改 地级市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityIgnoreNull(City city);
		
	
	/**
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCity(long id);
	
	/**
	 * 查找 地级市 by language
	 * @param id
	 * @return
	 */
	public City findCitybylanguage(long id ,Integer language);
	
	
	/** 
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCityForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找地级市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 地级市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityBySql(String sql);
	
	
	
 	/**
	 * 创建 地标
	 * @param id
	 * @return deleted count 
	 */
	public Landmark createLandmark(Landmark landmark) throws SQLException;
	
	/**
	 * 删除 地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLandmark(long id);
	
	
	/**
	 * 修改 地标
	 * @param id
	 * @return updated count 
	 */
	public int updateLandmark(Landmark landmark);

		
	/**
	 * 修改 地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLandmarkIgnoreNull(Landmark landmark);
		
	
	/**
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmark(long id);
	
	
	/** 
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLandmarkForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmarkBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLandmarkBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLandmarkBySql(String sql);
	
	
	
 	/**
	 * 创建 区域
	 * @param id
	 * @return deleted count 
	 */
	public Region createRegion(Region region) throws SQLException;
	
	/**
	 * 删除 区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRegion(long id);
	
	
	/**
	 * 修改 区域
	 * @param id
	 * @return updated count 
	 */
	public int updateRegion(Region region);

		
	/**
	 * 修改 区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRegionIgnoreNull(Region region);
		
	
	/**
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 区域
	 * @param id
	 * @return
	 */
	public Region findRegion(long id);
	
	
	/** 
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRegionForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegionBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRegionBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRegionBySql(String sql);
	
	/**
	 * 查找 地标 by language
	 * @param id
	 * @return
	 */
	public Landmark findLandmarkbylanguage(long id ,Integer language);
	
	
	
	/**
	 * 查找 区域 by language
	 * @param id
	 * @return
	 */
	public Region findRegionbylanguage(long id ,Integer language);
	
	
	
	/**
	 * 查找 酒店 by language
	 * @param id
	 * @return
	 */
	public Hotel findHotelbylanguage(long id ,Integer language);
	
	/**
	 * 查找 酒店合同 by language
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontractbylanguage(long id ,Integer language);
	/**
	 * 查找 酒店图片 by language
	 * @param id
	 * @return
	 */
	public Hotelimage findHotelimagebylanguage(long id ,Integer language);
	
	
	/**
	 * 查找 酒店地标 by language
	 * @param id
	 * @return
	 */
	public Hotellandmark findHotellandmarkbylanguage(long id ,Integer language);
	
	
	/**
	 * 查找 酒店联系人 by language
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkmanbylanguage(long id ,Integer language);
	/**
	 * 查找 酒店订单状态日志 by language
	 * @param id
	 * @return
	 */
	public Hotelorderrc findHotelorderrcbylanguage(long id ,Integer language);
	/**
	 * 查找 酒店价格 by language
	 * @param id
	 * @return
	 */
	public Hotelprice findHotelpricebylanguage(long id ,Integer language);
	/**
	 * 查找 酒店注意事项 by language
	 * @param id
	 * @return
	 */
	public Hotelspec findHotelspecbylanguage(long id ,Integer language);
	/**
	 * 查找 酒店房态 by language
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstatebylanguage(long id ,Integer language);
	/**
	 * 查找 酒店房态表 by language
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstatebackbylanguage(long id ,Integer language);
	/**
	 * 查找 酒店房型 by language
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtypebylanguage(long id ,Integer language);
	
	/**
	 * 创建 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public Chaininfo createChaininfo(Chaininfo chaininfo) throws SQLException;
	
	/**
	 * 删除 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChaininfo(long id);
	
	
	/**
	 * 修改 连锁酒店类型
	 * @param id
	 * @return updated count 
	 */
	public int updateChaininfo(Chaininfo chaininfo);

		
	/**
	 * 修改 连锁酒店类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChaininfoIgnoreNull(Chaininfo chaininfo);
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param id
	 * @return
	 */
	public Chaininfo findChaininfo(long id);
	
	
	/** 
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChaininfoForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找连锁酒店类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfoBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 连锁酒店类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChaininfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChaininfoBySql(String sql);
	//
	//粘贴到Service接口类
 	/**
	 * 创建 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelfan createHotelfan(Hotelfan hotelfan) throws SQLException;
	
	/**
	 * 删除 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelfan(long id);
	
	
	/**
	 * 修改 酒店设置返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelfan(Hotelfan hotelfan);

		
	/**
	 * 修改 酒店设置返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelfanIgnoreNull(Hotelfan hotelfan);
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param id
	 * @return
	 */
	public Hotelfan findHotelfan(long id);
	
	
	/** 
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelfanForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店设置返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfanBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店设置返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelfanBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelfanBySql(String sql);
	//

	   //粘贴到Service接口类
	 	/**
		 * 创建 消息公告
		 * @param id
		 * @return deleted count 
		 */
		public Sysmessage createSysmessage(Sysmessage sysmessage) throws SQLException;
		
		/**
		 * 删除 消息公告
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSysmessage(long id);
		
		
		/**
		 * 修改 消息公告
		 * @param id
		 * @return updated count 
		 */
		public int updateSysmessage(Sysmessage sysmessage);

			
		/**
		 * 修改 消息公告但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSysmessageIgnoreNull(Sysmessage sysmessage);
			
		
		/**
		 * 查找 消息公告
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSysmessage(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 消息公告
		 * @param id
		 * @return
		 */
		public Sysmessage findSysmessage(long id);
		
		
		/** 
		 * 查找 消息公告
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSysmessageForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找消息公告
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSysmessageBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 消息公告
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSysmessageBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSysmessageBySql(String sql);
		
	//

		   //粘贴到Service接口类
		 	/**
			 * 创建 支付记录
			 * @param id
			 * @return deleted count 
			 */
			public Paymentrecorder createPaymentrecorder(Paymentrecorder paymentrecorder) throws SQLException;
			
			/**
			 * 删除 支付记录
			 * @param id
			 * @return deleted count 
			 */
			public int deletePaymentrecorder(long id);
			
			
			/**
			 * 修改 支付记录
			 * @param id
			 * @return updated count 
			 */
			public int updatePaymentrecorder(Paymentrecorder paymentrecorder);

				
			/**
			 * 修改 支付记录但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updatePaymentrecorderIgnoreNull(Paymentrecorder paymentrecorder);
				
			
			/**
			 * 查找 支付记录
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllPaymentrecorder(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 支付记录
			 * @param id
			 * @return
			 */
			public Paymentrecorder findPaymentrecorder(long id);
			
			/**
			 * 查找 支付记录 by language
			 * @param id
			 * @return
			 */
			public Paymentrecorder findPaymentrecorderbylanguage(long id ,Integer language);
			
			/** 
			 * 查找 支付记录
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllPaymentrecorderForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找支付记录
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllPaymentrecorderBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 支付记录
			 * @param sql 
			 * @return updated count 
			 */
			public int excutePaymentrecorderBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countPaymentrecorderBySql(String sql);
			//
			/**
			 * 创建 电子优惠卷活动
			 * @param id
			 * @return deleted count 
			 */
			public Dcampaign createDcampaign(Dcampaign dcampaign) throws SQLException;
			
			/**
			 * 删除 电子优惠卷活动
			 * @param id
			 * @return deleted count 
			 */
			public int deleteDcampaign(long id);
			
			
			/**
			 * 修改 电子优惠卷活动
			 * @param id
			 * @return updated count 
			 */
			public int updateDcampaign(Dcampaign dcampaign);

				
			/**
			 * 修改 电子优惠卷活动但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateDcampaignIgnoreNull(Dcampaign dcampaign);
				
			
			/**
			 * 查找 电子优惠卷活动
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllDcampaign(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 电子优惠卷活动
			 * @param id
			 * @return
			 */
			public Dcampaign findDcampaign(long id);
			
			
			/** 
			 * 查找 电子优惠卷活动
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllDcampaignForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找电子优惠卷活动
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllDcampaignBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 电子优惠卷活动
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteDcampaignBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countDcampaignBySql(String sql);
			//
			//粘贴到Service接口类
		 	/**
			 * 创建 加盟商返点表
			 * @param id
			 * @return deleted count 
			 */
			public Hotelagent createHotelagent(Hotelagent hotelagent) throws SQLException;
			
			/**
			 * 删除 加盟商返点表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteHotelagent(long id);
			
			
			/**
			 * 修改 加盟商返点表
			 * @param id
			 * @return updated count 
			 */
			public int updateHotelagent(Hotelagent hotelagent);

				
			/**
			 * 修改 加盟商返点表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateHotelagentIgnoreNull(Hotelagent hotelagent);
				
			
			/**
			 * 查找 加盟商返点表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllHotelagent(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 加盟商返点表
			 * @param id
			 * @return
			 */
			public Hotelagent findHotelagent(long id);
			
			
			/** 
			 * 查找 加盟商返点表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllHotelagentForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找加盟商返点表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllHotelagentBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 加盟商返点表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteHotelagentBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countHotelagentBySql(String sql);
			
			 //粘贴到Service接口类
		 	/**
			 * 创建 酒店星级返点对应表
			 * @param id
			 * @return deleted count 
			 */
			public Hotelstar createHotelstar(Hotelstar hotelstar) throws SQLException;
			
			/**
			 * 删除 酒店星级返点对应表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteHotelstar(long id);
			
			
			/**
			 * 修改 酒店星级返点对应表
			 * @param id
			 * @return updated count 
			 */
			public int updateHotelstar(Hotelstar hotelstar);

				
			/**
			 * 修改 酒店星级返点对应表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateHotelstarIgnoreNull(Hotelstar hotelstar);
				
			
			/**
			 * 查找 酒店星级返点对应表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllHotelstar(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 酒店星级返点对应表
			 * @param id
			 * @return
			 */
			public Hotelstar findHotelstar(long id);
			
			
			/** 
			 * 查找 酒店星级返点对应表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllHotelstarForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找酒店星级返点对应表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllHotelstarBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 酒店星级返点对应表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteHotelstarBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countHotelstarBySql(String sql);

				
	

				   //粘贴到Service接口类
				 	/**
					 * 创建 酒店常用入住人表
					 * @param id
					 * @return deleted count 
					 */
					public Hotelpass createHotelpass(Hotelpass hotelpass) throws SQLException;
					
					/**
					 * 删除 酒店常用入住人表
					 * @param id
					 * @return deleted count 
					 */
					public int deleteHotelpass(long id);
					
					
					/**
					 * 修改 酒店常用入住人表
					 * @param id
					 * @return updated count 
					 */
					public int updateHotelpass(Hotelpass hotelpass);

						
					/**
					 * 修改 酒店常用入住人表但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateHotelpassIgnoreNull(Hotelpass hotelpass);
						
					
					/**
					 * 查找 酒店常用入住人表
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllHotelpass(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 酒店常用入住人表
					 * @param id
					 * @return
					 */
					public Hotelpass findHotelpass(long id);
					
					
					/** 
					 * 查找 酒店常用入住人表
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllHotelpassForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找酒店常用入住人表
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllHotelpassBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 酒店常用入住人表
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteHotelpassBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countHotelpassBySql(String sql);
					
					
					
					;
					
					/**
					 * 创建 酒店数据提供商
					 * @param id
					 * @return deleted count 
					 */
					public Dataprovide createDataprovide(Dataprovide dataprovide) throws SQLException;
					
					/**
					 * 删除 酒店数据提供商
					 * @param id
					 * @return deleted count 
					 */
					public int deleteDataprovide(long id);
					
					
					/**
					 * 修改 酒店数据提供商
					 * @param id
					 * @return updated count 
					 */
					public int updateDataprovide(Dataprovide dataprovide);

						
					/**
					 * 修改 酒店数据提供商但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateDataprovideIgnoreNull(Dataprovide dataprovide);
						
					
					/**
					 * 查找 酒店数据提供商
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllDataprovide(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 酒店数据提供商
					 * @param id
					 * @return
					 */
					public Dataprovide findDataprovide(long id);
					
					
					/** 
					 * 查找 酒店数据提供商
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllDataprovideForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找酒店数据提供商
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllDataprovideBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 酒店数据提供商
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteDataprovideBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countDataprovideBySql(String sql);
					

					//粘贴到Service接口类
				 	/**
					 * 创建 酒店星级返利
					 * @param id
					 * @return deleted count 
					 */
					public Hotelstart createHotelstart(Hotelstart hotelstart) throws SQLException;
					
					/**
					 * 删除 酒店星级返利
					 * @param id
					 * @return deleted count 
					 */
					public int deleteHotelstart(long id);
					
					
					/**
					 * 修改 酒店星级返利
					 * @param id
					 * @return updated count 
					 */
					public int updateHotelstart(Hotelstart hotelstart);

						
					/**
					 * 修改 酒店星级返利但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateHotelstartIgnoreNull(Hotelstart hotelstart);
						
					
					/**
					 * 查找 酒店星级返利
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllHotelstart(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 酒店星级返利
					 * @param id
					 * @return
					 */
					public Hotelstart findHotelstart(long id);
					
					
					/** 
					 * 查找 酒店星级返利
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllHotelstartForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找酒店星级返利
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllHotelstartBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 酒店星级返利
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteHotelstartBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countHotelstartBySql(String sql);
					
					
					 //粘贴到Service接口类
				 	/**
					 * 创建 星级留点记录
					 * @param id
					 * @return deleted count 
					 */
					public Starrecord createStarrecord(Starrecord starrecord) throws SQLException;
					
					/**
					 * 删除 星级留点记录
					 * @param id
					 * @return deleted count 
					 */
					public int deleteStarrecord(long id);
					
					
					/**
					 * 修改 星级留点记录
					 * @param id
					 * @return updated count 
					 */
					public int updateStarrecord(Starrecord starrecord);

						
					/**
					 * 修改 星级留点记录但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateStarrecordIgnoreNull(Starrecord starrecord);
						
					
					/**
					 * 查找 星级留点记录
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarrecord(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 星级留点记录
					 * @param id
					 * @return
					 */
					public Starrecord findStarrecord(long id);
					
					
					/** 
					 * 查找 星级留点记录
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllStarrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找星级留点记录
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarrecordBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 星级留点记录
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteStarrecordBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countStarrecordBySql(String sql);
					
					
					
					 //粘贴到Service接口类
				 	/**
					 * 创建 星级返点设置关联
					 * @param id
					 * @return deleted count 
					 */
					public Starreinfo createStarreinfo(Starreinfo starreinfo) throws SQLException;
					
					/**
					 * 删除 星级返点设置关联
					 * @param id
					 * @return deleted count 
					 */
					public int deleteStarreinfo(long id);
					
					
					/**
					 * 修改 星级返点设置关联
					 * @param id
					 * @return updated count 
					 */
					public int updateStarreinfo(Starreinfo starreinfo);

						
					/**
					 * 修改 星级返点设置关联但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateStarreinfoIgnoreNull(Starreinfo starreinfo);
						
					
					/**
					 * 查找 星级返点设置关联
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarreinfo(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 星级返点设置关联
					 * @param id
					 * @return
					 */
					public Starreinfo findStarreinfo(long id);
					
					
					/** 
					 * 查找 星级返点设置关联
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllStarreinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找星级返点设置关联
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarreinfoBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 星级返点设置关联
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteStarreinfoBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countStarreinfoBySql(String sql);
					
					  //粘贴到Service接口类
				 	/**
					 * 创建 星级结算分类
					 * @param id
					 * @return deleted count 
					 */
					public Starsettlementtype createStarsettlementtype(Starsettlementtype starsettlementtype) throws SQLException;
					
					/**
					 * 删除 星级结算分类
					 * @param id
					 * @return deleted count 
					 */
					public int deleteStarsettlementtype(long id);
					
					
					/**
					 * 修改 星级结算分类
					 * @param id
					 * @return updated count 
					 */
					public int updateStarsettlementtype(Starsettlementtype starsettlementtype);

						
					/**
					 * 修改 星级结算分类但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateStarsettlementtypeIgnoreNull(Starsettlementtype starsettlementtype);
						
					
					/**
					 * 查找 星级结算分类
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarsettlementtype(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 星级结算分类
					 * @param id
					 * @return
					 */
					public Starsettlementtype findStarsettlementtype(long id);
					
					
					/** 
					 * 查找 星级结算分类
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllStarsettlementtypeForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找星级结算分类
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllStarsettlementtypeBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 星级结算分类
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteStarsettlementtypeBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countStarsettlementtypeBySql(String sql);
					
					
					  
					  
}





