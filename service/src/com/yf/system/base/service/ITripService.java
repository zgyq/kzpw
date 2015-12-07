package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.buying.Buying;
import com.yf.system.base.buyingimg.Buyingimg;
import com.yf.system.base.conferencehall.Conferencehall;
import com.yf.system.base.conferencehotel.Conferencehotel;
import com.yf.system.base.qzchanpin.Qzchanpin;
import com.yf.system.base.qzchanpininfo.Qzchanpininfo;
import com.yf.system.base.qzguojia.Qzguojia;
import com.yf.system.base.scenicspot.Scenicspot;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineimg.Spotlineimg;
import com.yf.system.base.spotlineinfo.Spotlineinfo;
import com.yf.system.base.spotlineorder.Spotlineorder;
import com.yf.system.base.spotlineprice.Spotlineprice;
import com.yf.system.base.spotlineuser.Spotlineuser;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotorder.Spotorder;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.system.base.spotticketcity.Spotticketcity;
import com.yf.system.base.tickctspa.Tickctspa;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triplinesource.Triplinesource;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.tripnode.Tripnode;
import com.yf.system.base.triporder.Triporder;
import com.yf.system.base.triporderrc.Triporderrc;
import com.yf.system.base.triprange.Triprange;
import com.yf.system.base.triprangescenicspot.Triprangescenicspot;
import com.yf.system.base.util.PageInfo;

public interface ITripService {
	/**
	 * 创建 旅行线路
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Tripline createTripline(Tripline tripline) throws SQLException;

	/**
	 * 删除 旅行线路
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTripline(long id);

	/**
	 * 修改 旅行线路
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTripline(Tripline tripline);

	/**
	 * 修改 旅行线路但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriplineIgnoreNull(Tripline tripline);

	/**
	 * 查找 旅行线路
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 旅行线路
	 * 
	 * @param id
	 * @return
	 */
	public Tripline findTripline(long id);

	/**
	 * 查找 旅行线路
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplineForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 旅行线路 by language
	 * 
	 * @param id
	 * @return
	 */
	public Tripline findTriplinebylanguage(long id, Integer language);

	/**
	 * 根据Sql查找旅行线路
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplineBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 旅行线路
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriplineBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriplineBySql(String sql);

	/**
	 * 创建 注意事项
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Tripnode createTripnode(Tripnode tripnode) throws SQLException;

	/**
	 * 删除 注意事项
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTripnode(long id);

	/**
	 * 修改 注意事项
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTripnode(Tripnode tripnode);

	/**
	 * 修改 注意事项但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTripnodeIgnoreNull(Tripnode tripnode);

	/**
	 * 查找 注意事项
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnode(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 注意事项
	 * 
	 * @param id
	 * @return
	 */
	public Tripnode findTripnode(long id);

	/**
	 * 查找 注意事项
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripnodeForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 注意事项 by language
	 * 
	 * @param id
	 * @return
	 */
	public Tripnode findTripnodebylanguage(long id, Integer language);

	/**
	 * 根据Sql查找注意事项
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnodeBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 注意事项
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTripnodeBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTripnodeBySql(String sql);

	/**
	 * 创建 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triporder createTriporder(Triporder triporder) throws SQLException;

	/**
	 * 删除 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriporder(long id);

	/**
	 * 修改 线路订单
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriporder(Triporder triporder);

	/**
	 * 修改 线路订单但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriporderIgnoreNull(Triporder triporder);

	/**
	 * 查找 线路订单
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 线路订单
	 * 
	 * @param id
	 * @return
	 */
	public Triporder findTriporder(long id);

	/**
	 * 查找 线路订单
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 线路订单 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triporder findTriporderbylanguage(long id, Integer language);

	/**
	 * 根据Sql查找线路订单
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 线路订单
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriporderBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriporderBySql(String sql);

	/**
	 * 创建 旅行订单记录
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triporderrc createTriporderrc(Triporderrc triporderrc)
			throws SQLException;

	/**
	 * 删除 旅行订单记录
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriporderrc(long id);

	/**
	 * 修改 旅行订单记录
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriporderrc(Triporderrc triporderrc);

	/**
	 * 修改 旅行订单记录但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriporderrcIgnoreNull(Triporderrc triporderrc);

	/**
	 * 查找 旅行订单记录
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrc(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 旅行订单记录
	 * 
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrc(long id);

	/**
	 * 查找 旅行订单记录
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderrcForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 旅行订单记录 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrcbylanguage(long id, Integer language);

	/**
	 * 根据Sql查找旅行订单记录
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrcBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 旅行订单记录
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriporderrcBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriporderrcBySql(String sql);

	/**
	 * 创建 行程
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triprange createTriprange(Triprange triprange) throws SQLException;

	/**
	 * 删除 行程
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriprange(long id);

	/**
	 * 修改 行程
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriprange(Triprange triprange);

	/**
	 * 修改 行程但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriprangeIgnoreNull(Triprange triprange);

	/**
	 * 查找 行程
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 行程
	 * 
	 * @param id
	 * @return
	 */
	public Triprange findTriprange(long id);

	/**
	 * 查找 行程
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangeForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 行程 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triprange findTriprangebylanguage(long id, Integer language);

	/**
	 * 根据Sql查找行程
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangeBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 行程
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriprangeBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriprangeBySql(String sql);

	/**
	 * 创建 行程景点关联
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triprangescenicspot createTriprangescenicspot(
			Triprangescenicspot triprangescenicspot) throws SQLException;

	/**
	 * 删除 行程景点关联
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriprangescenicspot(long id);

	/**
	 * 修改 行程景点关联
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriprangescenicspot(Triprangescenicspot triprangescenicspot);

	/**
	 * 修改 行程景点关联但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriprangescenicspotIgnoreNull(
			Triprangescenicspot triprangescenicspot);

	/**
	 * 查找 行程景点关联
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspot(String where, String orderby,
			int limit, int offset);

	/**
	 * 查找 行程景点关联
	 * 
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspot(long id);

	/**
	 * 查找 行程景点关联
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangescenicspotForPageinfo(String where,
			String orderby, PageInfo pageinfo);

	/**
	 * 查找 行程景点关联 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspotbylanguage(long id,
			Integer language);

	/**
	 * 根据Sql查找行程景点关联
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspotBySql(String sql, int limit,
			int offset);

	/**
	 * 执行Sql 行程景点关联
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriprangescenicspotBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriprangescenicspotBySql(String sql);

	/**
	 * 创建 景点
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Scenicspot createScenicspot(Scenicspot scenicspot)
			throws SQLException;

	/**
	 * 删除 景点
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteScenicspot(long id);

	/**
	 * 修改 景点
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateScenicspot(Scenicspot scenicspot);

	/**
	 * 修改 景点但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateScenicspotIgnoreNull(Scenicspot scenicspot);

	/**
	 * 查找 景点
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景点
	 * 
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspot(long id);

	/**
	 * 查找 景点
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScenicspotForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 查找 景点 by language
	 * 
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspotbylanguage(long id, Integer language);

	/**
	 * 根据Sql查找景点
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspotBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景点
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteScenicspotBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countScenicspotBySql(String sql);

	/**
	 * 创建 旅游线路类型表
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triplinetype createTriplinetype(Triplinetype triplinetype)
			throws SQLException;

	/**
	 * 删除 旅游线路类型表
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriplinetype(long id);

	/**
	 * 修改 旅游线路类型表
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriplinetype(Triplinetype triplinetype);

	/**
	 * 修改 旅游线路类型表但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriplinetypeIgnoreNull(Triplinetype triplinetype);

	/**
	 * 查找 旅游线路类型表
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 旅游线路类型表
	 * 
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetype(long id);

	/**
	 * 查找 旅游线路类型表 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetypebylanguage(long id, Integer language);

	/**
	 * 查找 旅游线路类型表
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinetypeForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找旅游线路类型表
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetypeBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 旅游线路类型表
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriplinetypeBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriplinetypeBySql(String sql);

	/**
	 * 创建 旅游线路来源
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triplinesource createTriplinesource(Triplinesource triplinesource)
			throws SQLException;

	/**
	 * 删除 旅游线路来源
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriplinesource(long id);

	/**
	 * 修改 旅游线路来源
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriplinesource(Triplinesource triplinesource);

	/**
	 * 修改 旅游线路来源但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriplinesourceIgnoreNull(Triplinesource triplinesource);

	/**
	 * 查找 旅游线路来源
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 旅游线路来源
	 * 
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesource(long id);

	/**
	 * 查找 旅游线路来源 by language
	 * 
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesourcebylanguage(long id, Integer language);

	/**
	 * 查找 旅游线路来源
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinesourceForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找旅游线路来源
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesourceBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 旅游线路来源
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriplinesourceBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriplinesourceBySql(String sql);

	/**
	 * 创建 票务温泉
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Tickctspa createTickctspa(Tickctspa tickctspa) throws SQLException;

	/**
	 * 删除 票务温泉
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTickctspa(long id);

	/**
	 * 修改 票务温泉
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTickctspa(Tickctspa tickctspa);

	/**
	 * 修改 票务温泉但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTickctspaIgnoreNull(Tickctspa tickctspa);

	/**
	 * 查找 票务温泉
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 票务温泉
	 * 
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspa(long id);

	/**
	 * 查找 票务温泉 by language
	 * 
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspabylanguage(long id, Integer language);

	/**
	 * 查找 票务温泉
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickctspaForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找票务温泉
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspaBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 票务温泉
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTickctspaBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTickctspaBySql(String sql);

	/**
	 * 创建 会议厅
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Conferencehall createConferencehall(Conferencehall conferencehall)
			throws SQLException;

	/**
	 * 删除 会议厅
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteConferencehall(long id);

	/**
	 * 修改 会议厅
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateConferencehall(Conferencehall conferencehall);

	/**
	 * 修改 会议厅但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateConferencehallIgnoreNull(Conferencehall conferencehall);

	/**
	 * 查找 会议厅
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 会议厅
	 * 
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehall(long id);

	/**
	 * 查找 会议厅 by language
	 * 
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehallbylanguage(long id, Integer language);

	/**
	 * 查找 会议厅
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehallForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找会议厅
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehallBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 会议厅
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteConferencehallBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countConferencehallBySql(String sql);

	/**
	 * 创建 会议酒店
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Conferencehotel createConferencehotel(Conferencehotel conferencehotel)
			throws SQLException;

	/**
	 * 删除 会议酒店
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteConferencehotel(long id);

	/**
	 * 修改 会议酒店
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateConferencehotel(Conferencehotel conferencehotel);

	/**
	 * 修改 会议酒店但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateConferencehotelIgnoreNull(Conferencehotel conferencehotel);

	/**
	 * 查找 会议酒店
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 会议酒店
	 * 
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotel(long id);

	/**
	 * 查找 会议酒店 by language
	 * 
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotelbylanguage(long id,
			Integer language);

	/**
	 * 查找 会议酒店
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehotelForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找会议酒店
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotelBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 会议酒店
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteConferencehotelBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countConferencehotelBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景点门票
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotticket createSpotticket(Spotticket spotticket)
			throws SQLException;

	/**
	 * 删除 景点门票
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotticket(long id);

	/**
	 * 修改 景点门票
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotticket(Spotticket spotticket);

	/**
	 * 修改 景点门票但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotticketIgnoreNull(Spotticket spotticket);

	/**
	 * 查找 景点门票
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景点门票
	 * 
	 * @param id
	 * @return
	 */
	public Spotticket findSpotticket(long id);

	/**
	 * 查找 景点门票
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticketForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景点门票
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景点门票
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotticketBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotticketBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景点信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotmes createSpotmes(Spotmes spotmes) throws SQLException;

	/**
	 * 删除 景点信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotmes(long id);

	/**
	 * 修改 景点信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotmes(Spotmes spotmes);

	/**
	 * 修改 景点信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotmesIgnoreNull(Spotmes spotmes);

	/**
	 * 查找 景点信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景点信息
	 * 
	 * @param id
	 * @return
	 */
	public Spotmes findSpotmes(long id);

	/**
	 * 查找 景点信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotmesForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景点信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmesBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景点信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotmesBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotmesBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景区城市
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotcity createSpotcity(Spotcity spotcity) throws SQLException;

	/**
	 * 删除 景区城市
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotcity(long id);

	/**
	 * 修改 景区城市
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotcity(Spotcity spotcity);

	/**
	 * 修改 景区城市但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotcityIgnoreNull(Spotcity spotcity);

	/**
	 * 查找 景区城市
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景区城市
	 * 
	 * @param id
	 * @return
	 */
	public Spotcity findSpotcity(long id);

	/**
	 * 查找 景区城市
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotcityForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景区城市
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcityBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景区城市
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotcityBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotcityBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 门票订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotorder createSpotorder(Spotorder spotorder) throws SQLException;

	/**
	 * 删除 门票订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotorder(long id);

	/**
	 * 修改 门票订单
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotorder(Spotorder spotorder);

	/**
	 * 修改 门票订单但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotorderIgnoreNull(Spotorder spotorder);

	/**
	 * 查找 门票订单
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 门票订单
	 * 
	 * @param id
	 * @return
	 */
	public Spotorder findSpotorder(long id);

	/**
	 * 查找 门票订单
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotorderForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找门票订单
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorderBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 门票订单
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotorderBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotorderBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景区线路详细信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotlineinfo createSpotlineinfo(Spotlineinfo spotlineinfo)
			throws SQLException;

	/**
	 * 删除 景区线路详细信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotlineinfo(long id);

	/**
	 * 修改 景区线路详细信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotlineinfo(Spotlineinfo spotlineinfo);

	/**
	 * 修改 景区线路详细信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlineinfoIgnoreNull(Spotlineinfo spotlineinfo);

	/**
	 * 查找 景区线路详细信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景区线路详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Spotlineinfo findSpotlineinfo(long id);

	/**
	 * 查找 景区线路详细信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineinfoForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景区线路详细信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfoBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景区线路详细信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlineinfoBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlineinfoBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景区线路图片信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotlineimg createSpotlineimg(Spotlineimg spotlineimg)
			throws SQLException;

	/**
	 * 删除 景区线路图片信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotlineimg(long id);

	/**
	 * 修改 景区线路图片信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotlineimg(Spotlineimg spotlineimg);

	/**
	 * 修改 景区线路图片信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlineimgIgnoreNull(Spotlineimg spotlineimg);

	/**
	 * 查找 景区线路图片信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景区线路图片信息
	 * 
	 * @param id
	 * @return
	 */
	public Spotlineimg findSpotlineimg(long id);

	/**
	 * 查找 景区线路图片信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineimgForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景区线路图片信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimgBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景区线路图片信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlineimgBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlineimgBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景区线路信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotline createSpotline(Spotline spotline) throws SQLException;

	/**
	 * 删除 景区线路信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotline(long id);

	/**
	 * 修改 景区线路信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotline(Spotline spotline);

	/**
	 * 修改 景区线路信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlineIgnoreNull(Spotline spotline);

	/**
	 * 查找 景区线路信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景区线路信息
	 * 
	 * @param id
	 * @return
	 */
	public Spotline findSpotline(long id);

	/**
	 * 查找 景区线路信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景区线路信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景区线路信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlineBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlineBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 景区线路价格信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotlineprice createSpotlineprice(Spotlineprice spotlineprice)
			throws SQLException;

	/**
	 * 删除 景区线路价格信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotlineprice(long id);

	/**
	 * 修改 景区线路价格信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotlineprice(Spotlineprice spotlineprice);

	/**
	 * 修改 景区线路价格信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlinepriceIgnoreNull(Spotlineprice spotlineprice);

	/**
	 * 查找 景区线路价格信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 景区线路价格信息
	 * 
	 * @param id
	 * @return
	 */
	public Spotlineprice findSpotlineprice(long id);

	/**
	 * 查找 景区线路价格信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlinepriceForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找景区线路价格信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlinepriceBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 景区线路价格信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlinepriceBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlinepriceBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotlineorder createSpotlineorder(Spotlineorder spotlineorder)
			throws SQLException;

	/**
	 * 删除 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotlineorder(long id);

	/**
	 * 修改 线路订单
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotlineorder(Spotlineorder spotlineorder);

	/**
	 * 修改 线路订单但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlineorderIgnoreNull(Spotlineorder spotlineorder);

	/**
	 * 查找 线路订单
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 线路订单
	 * 
	 * @param id
	 * @return
	 */
	public Spotlineorder findSpotlineorder(long id);

	/**
	 * 查找 线路订单
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineorderForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找线路订单
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorderBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 线路订单
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlineorderBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlineorderBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 线路游客
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Spotlineuser createSpotlineuser(Spotlineuser spotlineuser)
			throws SQLException;

	/**
	 * 删除 线路游客
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteSpotlineuser(long id);

	/**
	 * 修改 线路游客
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateSpotlineuser(Spotlineuser spotlineuser);

	/**
	 * 修改 线路游客但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateSpotlineuserIgnoreNull(Spotlineuser spotlineuser);

	/**
	 * 查找 线路游客
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 线路游客
	 * 
	 * @param id
	 * @return
	 */
	public Spotlineuser findSpotlineuser(long id);

	/**
	 * 查找 线路游客
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineuserForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找线路游客
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuserBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 线路游客
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteSpotlineuserBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countSpotlineuserBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 团购信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Buying createBuying(Buying buying) throws SQLException;

	/**
	 * 删除 团购信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteBuying(long id);

	/**
	 * 修改 团购信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateBuying(Buying buying);

	/**
	 * 修改 团购信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateBuyingIgnoreNull(Buying buying);

	/**
	 * 查找 团购信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 团购信息
	 * 
	 * @param id
	 * @return
	 */
	public Buying findBuying(long id);

	/**
	 * 查找 团购信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找团购信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 团购信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteBuyingBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countBuyingBySql(String sql);

	// 粘贴到Service接口类
	/**
	 * 创建 团购图片信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Buyingimg createBuyingimg(Buyingimg buyingimg) throws SQLException;

	/**
	 * 删除 团购图片信息
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteBuyingimg(long id);

	/**
	 * 修改 团购图片信息
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateBuyingimg(Buyingimg buyingimg);

	/**
	 * 修改 团购图片信息但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateBuyingimgIgnoreNull(Buyingimg buyingimg);

	/**
	 * 查找 团购图片信息
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby, int limit,
			int offset);

	/**
	 * 查找 团购图片信息
	 * 
	 * @param id
	 * @return
	 */
	public Buyingimg findBuyingimg(long id);

	/**
	 * 查找 团购图片信息
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingimgForPageinfo(String where, String orderby,
			PageInfo pageinfo);

	/**
	 * 根据Sql查找团购图片信息
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimgBySql(String sql, int limit, int offset);

	/**
	 * 执行Sql 团购图片信息
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteBuyingimgBySql(String sql);

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countBuyingimgBySql(String sql);
	
	
	  
	  
	   //粘贴到Service接口类
	 	/**
		 * 创建 签证国家
		 * @param id
		 * @return deleted count 
		 */
		public Qzguojia createQzguojia(Qzguojia qzguojia) throws SQLException;
		
		/**
		 * 删除 签证国家
		 * @param id
		 * @return deleted count 
		 */
		public int deleteQzguojia(long id);
		
		
		/**
		 * 修改 签证国家
		 * @param id
		 * @return updated count 
		 */
		public int updateQzguojia(Qzguojia qzguojia);

			
		/**
		 * 修改 签证国家但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateQzguojiaIgnoreNull(Qzguojia qzguojia);
			
		
		/**
		 * 查找 签证国家
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQzguojia(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 签证国家
		 * @param id
		 * @return
		 */
		public Qzguojia findQzguojia(long id);
		
		
		/** 
		 * 查找 签证国家
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllQzguojiaForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找签证国家
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQzguojiaBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 签证国家
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteQzguojiaBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countQzguojiaBySql(String sql);
		
		
		  
		  
		   //粘贴到Service接口类
		 	/**
			 * 创建 签证产品
			 * @param id
			 * @return deleted count 
			 */
			public Qzchanpin createQzchanpin(Qzchanpin qzchanpin) throws SQLException;
			
			/**
			 * 删除 签证产品
			 * @param id
			 * @return deleted count 
			 */
			public int deleteQzchanpin(long id);
			
			
			/**
			 * 修改 签证产品
			 * @param id
			 * @return updated count 
			 */
			public int updateQzchanpin(Qzchanpin qzchanpin);

				
			/**
			 * 修改 签证产品但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateQzchanpinIgnoreNull(Qzchanpin qzchanpin);
				
			
			/**
			 * 查找 签证产品
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllQzchanpin(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 签证产品
			 * @param id
			 * @return
			 */
			public Qzchanpin findQzchanpin(long id);
			
			
			/** 
			 * 查找 签证产品
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllQzchanpinForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找签证产品
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllQzchanpinBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 签证产品
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteQzchanpinBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countQzchanpinBySql(String sql);
			
			
			  
			  
			   //粘贴到Service接口类
			 	/**
				 * 创建 签证产品详细信息
				 * @param id
				 * @return deleted count 
				 */
				public Qzchanpininfo createQzchanpininfo(Qzchanpininfo qzchanpininfo) throws SQLException;
				
				/**
				 * 删除 签证产品详细信息
				 * @param id
				 * @return deleted count 
				 */
				public int deleteQzchanpininfo(long id);
				
				
				/**
				 * 修改 签证产品详细信息
				 * @param id
				 * @return updated count 
				 */
				public int updateQzchanpininfo(Qzchanpininfo qzchanpininfo);

					
				/**
				 * 修改 签证产品详细信息但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateQzchanpininfoIgnoreNull(Qzchanpininfo qzchanpininfo);
					
				
				/**
				 * 查找 签证产品详细信息
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllQzchanpininfo(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 签证产品详细信息
				 * @param id
				 * @return
				 */
				public Qzchanpininfo findQzchanpininfo(long id);
				
				
				/** 
				 * 查找 签证产品详细信息
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllQzchanpininfoForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找签证产品详细信息
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllQzchanpininfoBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 签证产品详细信息
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteQzchanpininfoBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countQzchanpininfoBySql(String sql);
				
				
				  
				  
				   //粘贴到Service接口类
				 	/**
					 * 创建 门票城市
					 * @param id
					 * @return deleted count 
					 */
					public Spotticketcity createSpotticketcity(Spotticketcity spotticketcity) throws SQLException;
					
					/**
					 * 删除 门票城市
					 * @param id
					 * @return deleted count 
					 */
					public int deleteSpotticketcity(long id);
					
					
					/**
					 * 修改 门票城市
					 * @param id
					 * @return updated count 
					 */
					public int updateSpotticketcity(Spotticketcity spotticketcity);

						
					/**
					 * 修改 门票城市但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateSpotticketcityIgnoreNull(Spotticketcity spotticketcity);
						
					
					/**
					 * 查找 门票城市
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllSpotticketcity(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 门票城市
					 * @param id
					 * @return
					 */
					public Spotticketcity findSpotticketcity(long id);
					
					
					/** 
					 * 查找 门票城市
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllSpotticketcityForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找门票城市
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllSpotticketcityBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 门票城市
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteSpotticketcityBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countSpotticketcityBySql(String sql);
					

}
