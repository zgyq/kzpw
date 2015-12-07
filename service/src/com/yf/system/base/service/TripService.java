package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.buying.Buying;
import com.yf.system.base.buying.IBuyingComponent;
import com.yf.system.base.buyingimg.Buyingimg;
import com.yf.system.base.buyingimg.IBuyingimgComponent;
import com.yf.system.base.conferencehall.Conferencehall;
import com.yf.system.base.conferencehall.IConferencehallComponent;
import com.yf.system.base.conferencehotel.Conferencehotel;
import com.yf.system.base.conferencehotel.IConferencehotelComponent;
import com.yf.system.base.qzchanpin.IQzchanpinComponent;
import com.yf.system.base.qzchanpin.Qzchanpin;
import com.yf.system.base.qzchanpininfo.IQzchanpininfoComponent;
import com.yf.system.base.qzchanpininfo.Qzchanpininfo;
import com.yf.system.base.qzguojia.IQzguojiaComponent;
import com.yf.system.base.qzguojia.Qzguojia;
import com.yf.system.base.scenicspot.IScenicspotComponent;
import com.yf.system.base.scenicspot.Scenicspot;
import com.yf.system.base.spotcity.ISpotcityComponent;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotline.ISpotlineComponent;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineimg.ISpotlineimgComponent;
import com.yf.system.base.spotlineimg.Spotlineimg;
import com.yf.system.base.spotlineinfo.ISpotlineinfoComponent;
import com.yf.system.base.spotlineinfo.Spotlineinfo;
import com.yf.system.base.spotlineorder.ISpotlineorderComponent;
import com.yf.system.base.spotlineorder.Spotlineorder;
import com.yf.system.base.spotlineprice.ISpotlinepriceComponent;
import com.yf.system.base.spotlineprice.Spotlineprice;
import com.yf.system.base.spotlineuser.ISpotlineuserComponent;
import com.yf.system.base.spotlineuser.Spotlineuser;
import com.yf.system.base.spotmes.ISpotmesComponent;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotorder.ISpotorderComponent;
import com.yf.system.base.spotorder.Spotorder;
import com.yf.system.base.spotticket.ISpotticketComponent;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.system.base.spotticketcity.ISpotticketcityComponent;
import com.yf.system.base.spotticketcity.Spotticketcity;
import com.yf.system.base.tickctspa.ITickctspaComponent;
import com.yf.system.base.tickctspa.Tickctspa;
import com.yf.system.base.tripline.ITriplineComponent;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triplinesource.ITriplinesourceComponent;
import com.yf.system.base.triplinesource.Triplinesource;
import com.yf.system.base.triplinetype.ITriplinetypeComponent;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.tripnode.ITripnodeComponent;
import com.yf.system.base.tripnode.Tripnode;
import com.yf.system.base.triporder.ITriporderComponent;
import com.yf.system.base.triporder.Triporder;
import com.yf.system.base.triporderrc.ITriporderrcComponent;
import com.yf.system.base.triporderrc.Triporderrc;
import com.yf.system.base.triprange.ITriprangeComponent;
import com.yf.system.base.triprange.Triprange;
import com.yf.system.base.triprangescenicspot.ITriprangescenicspotComponent;
import com.yf.system.base.triprangescenicspot.Triprangescenicspot;
import com.yf.system.base.util.PageInfo;

public class TripService implements ITripService {

	private ITriplineComponent triplineComponent;
	private ITripnodeComponent tripnodeComponent;
	private ITriporderComponent triporderComponent;
	private ITriporderrcComponent triporderrcComponent;
	private ITriprangeComponent triprangeComponent;
	private ITriprangescenicspotComponent triprangescenicspotComponent;
	private IScenicspotComponent scenicspotComponent;
	
	public ITriplineComponent getTriplineComponent() {
		return triplineComponent;
	}

	public void setTriplineComponent(ITriplineComponent triplineComponent) {
		this.triplineComponent = triplineComponent;
	}

	/**
	 * 创建 旅行线路
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Tripline createTripline(Tripline tripline) throws SQLException {

		return triplineComponent.createTripline(tripline);
	}

	/**
	 * 删除 旅行线路
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTripline(long id) {

		return triplineComponent.deleteTripline(id);
	}

	/**
	 * 修改 旅行线路
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTripline(Tripline tripline) {
		return triplineComponent.updateTripline(tripline);

	}

	/**
	 * 修改 旅行线路但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriplineIgnoreNull(Tripline tripline) {
		return triplineComponent.updateTriplineIgnoreNull(tripline);

	}

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
			int offset) {
		return triplineComponent.findAllTripline(where, orderby, limit, offset);
	}

	/**
	 * 查找 旅行线路
	 * 
	 * @param id
	 * @return
	 */
	public Tripline findTripline(long id) {
		return triplineComponent.findTripline(id);
	}

	/**
	 * 查找 旅行线路
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplineForPageinfo(String where, String orderby,
			PageInfo pageinfo) {
		return triplineComponent.findAllTripline(where, orderby, pageinfo);
	}
	
	/**
	 * 查找 旅行线路
	 * @param id
	 * @return
	 */
	public Tripline findTriplinebylanguage(long id,Integer language){
		return triplineComponent.findTriplinebylanguage(id,language);
	}

	/**
	 * 根据Sql查找旅行线路
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplineBySql(String sql, int limit, int offset) {
		return triplineComponent.findAllTripline(sql, limit, offset);
	}

	/**
	 * 执行Sql 旅行线路
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriplineBySql(String sql) {
		return triplineComponent.excuteTriplineBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriplineBySql(String sql) {
		return triplineComponent.countTriplineBySql(sql);
	}

	public ITripnodeComponent getTripnodeComponent() {
		return tripnodeComponent;
	}

	public void setTripnodeComponent(ITripnodeComponent tripnodeComponent) {
		this.tripnodeComponent = tripnodeComponent;
	}

	/**
	 * 创建 注意事项
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Tripnode createTripnode(Tripnode tripnode) throws SQLException {

		return tripnodeComponent.createTripnode(tripnode);
	}

	/**
	 * 删除 注意事项
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTripnode(long id) {

		return tripnodeComponent.deleteTripnode(id);
	}

	/**
	 * 修改 注意事项
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTripnode(Tripnode tripnode) {
		return tripnodeComponent.updateTripnode(tripnode);

	}

	/**
	 * 修改 注意事项但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTripnodeIgnoreNull(Tripnode tripnode) {
		return tripnodeComponent.updateTripnodeIgnoreNull(tripnode);

	}

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
			int offset) {
		return tripnodeComponent.findAllTripnode(where, orderby, limit, offset);
	}

	/**
	 * 查找 注意事项
	 * 
	 * @param id
	 * @return
	 */
	public Tripnode findTripnode(long id) {
		return tripnodeComponent.findTripnode(id);
	}

	/**
	 * 查找 注意事项
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripnodeForPageinfo(String where, String orderby,
			PageInfo pageinfo) {
		return tripnodeComponent.findAllTripnode(where, orderby, pageinfo);
	}
	
	/**
	 * 查找 注意事项
	 * @param id
	 * @return
	 */
	public Tripnode findTripnodebylanguage(long id,Integer language){
		return tripnodeComponent.findTripnodebylanguage(id,language);
	}

	/**
	 * 根据Sql查找注意事项
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnodeBySql(String sql, int limit, int offset) {
		return tripnodeComponent.findAllTripnode(sql, limit, offset);
	}

	/**
	 * 执行Sql 注意事项
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTripnodeBySql(String sql) {
		return tripnodeComponent.excuteTripnodeBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTripnodeBySql(String sql) {
		return tripnodeComponent.countTripnodeBySql(sql);
	}

	public ITriporderComponent getTriporderComponent() {
		return triporderComponent;
	}

	public void setTriporderComponent(ITriporderComponent triporderComponent) {
		this.triporderComponent = triporderComponent;
	}

	/**
	 * 创建 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triporder createTriporder(Triporder triporder) throws SQLException {

		return triporderComponent.createTriporder(triporder);
	}

	/**
	 * 删除 线路订单
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriporder(long id) {

		return triporderComponent.deleteTriporder(id);
	}

	/**
	 * 修改 线路订单
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriporder(Triporder triporder) {
		return triporderComponent.updateTriporder(triporder);

	}

	/**
	 * 修改 线路订单但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriporderIgnoreNull(Triporder triporder) {
		return triporderComponent.updateTriporderIgnoreNull(triporder);

	}

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
			int offset) {
		return triporderComponent.findAllTriporder(where, orderby, limit,
				offset);
	}

	/**
	 * 查找 线路订单
	 * 
	 * @param id
	 * @return
	 */
	public Triporder findTriporder(long id) {
		return triporderComponent.findTriporder(id);
	}

	/**
	 * 查找 线路订单
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderForPageinfo(String where, String orderby,
			PageInfo pageinfo) {
		return triporderComponent.findAllTriporder(where, orderby, pageinfo);
	}
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Triporder findTriporderbylanguage(long id,Integer language){
		return triporderComponent.findTriporderbylanguage(id,language);
	}

	/**
	 * 根据Sql查找线路订单
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderBySql(String sql, int limit, int offset) {
		return triporderComponent.findAllTriporder(sql, limit, offset);
	}

	/**
	 * 执行Sql 线路订单
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriporderBySql(String sql) {
		return triporderComponent.excuteTriporderBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriporderBySql(String sql) {
		return triporderComponent.countTriporderBySql(sql);
	}

	public ITriporderrcComponent getTriporderrcComponent() {
		return triporderrcComponent;
	}

	public void setTriporderrcComponent(
			ITriporderrcComponent triporderrcComponent) {
		this.triporderrcComponent = triporderrcComponent;
	}

	/**
	 * 创建 旅行订单记录
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triporderrc createTriporderrc(Triporderrc triporderrc)
			throws SQLException {

		return triporderrcComponent.createTriporderrc(triporderrc);
	}

	/**
	 * 删除 旅行订单记录
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriporderrc(long id) {

		return triporderrcComponent.deleteTriporderrc(id);
	}

	/**
	 * 修改 旅行订单记录
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriporderrc(Triporderrc triporderrc) {
		return triporderrcComponent.updateTriporderrc(triporderrc);

	}

	/**
	 * 修改 旅行订单记录但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriporderrcIgnoreNull(Triporderrc triporderrc) {
		return triporderrcComponent.updateTriporderrcIgnoreNull(triporderrc);

	}

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
			int offset) {
		return triporderrcComponent.findAllTriporderrc(where, orderby, limit,
				offset);
	}

	/**
	 * 查找 旅行订单记录
	 * 
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrc(long id) {
		return triporderrcComponent.findTriporderrc(id);
	}

	/**
	 * 查找 旅行订单记录
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderrcForPageinfo(String where, String orderby,
			PageInfo pageinfo) {
		return triporderrcComponent
				.findAllTriporderrc(where, orderby, pageinfo);
	}
	
	/**
	 * 查找 旅行订单记录
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrcbylanguage(long id,Integer language){
		return triporderrcComponent.findTriporderrcbylanguage(id,language);
	}

	/**
	 * 根据Sql查找旅行订单记录
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrcBySql(String sql, int limit, int offset) {
		return triporderrcComponent.findAllTriporderrc(sql, limit, offset);
	}

	/**
	 * 执行Sql 旅行订单记录
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriporderrcBySql(String sql) {
		return triporderrcComponent.excuteTriporderrcBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriporderrcBySql(String sql) {
		return triporderrcComponent.countTriporderrcBySql(sql);
	}

	public ITriprangeComponent getTriprangeComponent() {
		return triprangeComponent;
	}

	public void setTriprangeComponent(ITriprangeComponent triprangeComponent) {
		this.triprangeComponent = triprangeComponent;
	}

	/**
	 * 创建 行程
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triprange createTriprange(Triprange triprange) throws SQLException {

		return triprangeComponent.createTriprange(triprange);
	}

	/**
	 * 删除 行程
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriprange(long id) {

		return triprangeComponent.deleteTriprange(id);
	}

	/**
	 * 修改 行程
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriprange(Triprange triprange) {
		return triprangeComponent.updateTriprange(triprange);

	}

	/**
	 * 修改 行程但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriprangeIgnoreNull(Triprange triprange) {
		return triprangeComponent.updateTriprangeIgnoreNull(triprange);

	}

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
			int offset) {
		return triprangeComponent.findAllTriprange(where, orderby, limit,
				offset);
	}

	/**
	 * 查找 行程
	 * 
	 * @param id
	 * @return
	 */
	public Triprange findTriprange(long id) {
		return triprangeComponent.findTriprange(id);
	}

	/**
	 * 查找 行程
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangeForPageinfo(String where, String orderby,
			PageInfo pageinfo) {
		return triprangeComponent.findAllTriprange(where, orderby, pageinfo);
	}
	
	/**
	 * 查找 行程
	 * @param id
	 * @return
	 */
	public Triprange findTriprangebylanguage(long id,Integer language){
		return triprangeComponent.findTriprangebylanguage(id,language);
	}

	/**
	 * 根据Sql查找行程
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangeBySql(String sql, int limit, int offset) {
		return triprangeComponent.findAllTriprange(sql, limit, offset);
	}

	/**
	 * 执行Sql 行程
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriprangeBySql(String sql) {
		return triprangeComponent.excuteTriprangeBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriprangeBySql(String sql) {
		return triprangeComponent.countTriprangeBySql(sql);
	}

	public ITriprangescenicspotComponent getTriprangescenicspotComponent() {
		return triprangescenicspotComponent;
	}

	public void setTriprangescenicspotComponent(
			ITriprangescenicspotComponent triprangescenicspotComponent) {
		this.triprangescenicspotComponent = triprangescenicspotComponent;
	}

	/**
	 * 创建 行程景点关联
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Triprangescenicspot createTriprangescenicspot(
			Triprangescenicspot triprangescenicspot) throws SQLException {

		return triprangescenicspotComponent
				.createTriprangescenicspot(triprangescenicspot);
	}

	/**
	 * 删除 行程景点关联
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteTriprangescenicspot(long id) {

		return triprangescenicspotComponent.deleteTriprangescenicspot(id);
	}

	/**
	 * 修改 行程景点关联
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateTriprangescenicspot(Triprangescenicspot triprangescenicspot) {
		return triprangescenicspotComponent
				.updateTriprangescenicspot(triprangescenicspot);

	}

	/**
	 * 修改 行程景点关联但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateTriprangescenicspotIgnoreNull(
			Triprangescenicspot triprangescenicspot) {
		return triprangescenicspotComponent
				.updateTriprangescenicspotIgnoreNull(triprangescenicspot);

	}

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
			int limit, int offset) {
		return triprangescenicspotComponent.findAllTriprangescenicspot(where,
				orderby, limit, offset);
	}

	/**
	 * 查找 行程景点关联
	 * 
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspot(long id) {
		return triprangescenicspotComponent.findTriprangescenicspot(id);
	}

	/**
	 * 查找 行程景点关联
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangescenicspotForPageinfo(String where,
			String orderby, PageInfo pageinfo) {
		return triprangescenicspotComponent.findAllTriprangescenicspot(where,
				orderby, pageinfo);
	}
	
	/**
	 * 查找 行程景点关联
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspotbylanguage(long id,Integer language){
		return triprangescenicspotComponent.findTriprangescenicspotbylanguage(id,language);
	}

	/**
	 * 根据Sql查找行程景点关联
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspotBySql(String sql, int limit,
			int offset) {
		return triprangescenicspotComponent.findAllTriprangescenicspot(sql,
				limit, offset);
	}

	/**
	 * 执行Sql 行程景点关联
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteTriprangescenicspotBySql(String sql) {
		return triprangescenicspotComponent.excuteTriprangescenicspotBySql(sql);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countTriprangescenicspotBySql(String sql) {
		return triprangescenicspotComponent.countTriprangescenicspotBySql(sql);
	}
	
 	public IScenicspotComponent getScenicspotComponent() {
		return scenicspotComponent;
	}
	public void setScenicspotComponent(IScenicspotComponent  scenicspotComponent) {
		this.scenicspotComponent = scenicspotComponent;
	}
	/**
	 * 创建 景点
	 * @param id
	 * @return deleted count 
	 */
	public Scenicspot createScenicspot(Scenicspot scenicspot) throws SQLException{
	
		return scenicspotComponent.createScenicspot(scenicspot);
	}
	/**
	 * 删除 景点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScenicspot(long id){
	
		return scenicspotComponent.deleteScenicspot(id);
	}
	
	
	/**
	 * 修改 景点
	 * @param id
	 * @return updated count 
	 */
	public int updateScenicspot(Scenicspot scenicspot){
		return scenicspotComponent.updateScenicspot(scenicspot);
	
	}

		
	/**
	 * 修改 景点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScenicspotIgnoreNull(Scenicspot scenicspot){
			return scenicspotComponent.updateScenicspotIgnoreNull(scenicspot);
	
	}
	
	/**
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby,int limit,int offset){
		return scenicspotComponent.findAllScenicspot(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景点
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspot(long id){
		return scenicspotComponent.findScenicspot(id);
	}
	
	/** 
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScenicspotForPageinfo(String where, String orderby,PageInfo pageinfo){
		return scenicspotComponent.findAllScenicspot(where, orderby,pageinfo);
	}
	
	/**
	 * 查找 景点
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspotbylanguage(long id,Integer language){
		return scenicspotComponent.findScenicspotbylanguage(id,language);
	}
		
	/** 
	 * 根据Sql查找景点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspotBySql(String sql,int limit,int offset){
		return scenicspotComponent.findAllScenicspot(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScenicspotBySql(String sql){
		return scenicspotComponent.excuteScenicspotBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScenicspotBySql(String sql){
		return scenicspotComponent.countScenicspotBySql(sql);
	}
	
private ITriplinetypeComponent triplinetypeComponent;
	  
 	
 	public ITriplinetypeComponent getTriplinetypeComponent() {
		return triplinetypeComponent;
	}
	public void setTriplinetypeComponent(ITriplinetypeComponent  triplinetypeComponent) {
		this.triplinetypeComponent = triplinetypeComponent;
	}
	/**
	 * 创建 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public Triplinetype createTriplinetype(Triplinetype triplinetype) throws SQLException{
	
		return triplinetypeComponent.createTriplinetype(triplinetype);
	}
	/**
	 * 删除 旅游线路类型表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinetype(long id){
	
		return triplinetypeComponent.deleteTriplinetype(id);
	}
	
	
	/**
	 * 修改 旅游线路类型表
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinetype(Triplinetype triplinetype){
		return triplinetypeComponent.updateTriplinetype(triplinetype);
	
	}

		
	/**
	 * 修改 旅游线路类型表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinetypeIgnoreNull(Triplinetype triplinetype){
			return triplinetypeComponent.updateTriplinetypeIgnoreNull(triplinetype);
	
	}
	
	/**
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetype(String where, String orderby,int limit,int offset){
		return triplinetypeComponent.findAllTriplinetype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅游线路类型表
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetype(long id){
		return triplinetypeComponent.findTriplinetype(id);
	}
	
	/**
	 * 查找 旅游线路类型表
	 * @param id
	 * @return
	 */
	public Triplinetype findTriplinetypebylanguage(long id,Integer language){
		return triplinetypeComponent.findTriplinetypebylanguage(id,language);
	}
	/** 
	 * 查找 旅游线路类型表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinetypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return triplinetypeComponent.findAllTriplinetype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅游线路类型表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinetypeBySql(String sql,int limit,int offset){
		return triplinetypeComponent.findAllTriplinetype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅游线路类型表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinetypeBySql(String sql){
		return triplinetypeComponent.excuteTriplinetypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinetypeBySql(String sql){
		return triplinetypeComponent.countTriplinetypeBySql(sql);
	}
	
private ITriplinesourceComponent triplinesourceComponent;
	  
 	
 	public ITriplinesourceComponent getTriplinesourceComponent() {
		return triplinesourceComponent;
	}
	public void setTriplinesourceComponent(ITriplinesourceComponent  triplinesourceComponent) {
		this.triplinesourceComponent = triplinesourceComponent;
	}
	/**
	 * 创建 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public Triplinesource createTriplinesource(Triplinesource triplinesource) throws SQLException{
	
		return triplinesourceComponent.createTriplinesource(triplinesource);
	}
	/**
	 * 删除 旅游线路来源
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriplinesource(long id){
	
		return triplinesourceComponent.deleteTriplinesource(id);
	}
	
	
	/**
	 * 修改 旅游线路来源
	 * @param id
	 * @return updated count 
	 */
	public int updateTriplinesource(Triplinesource triplinesource){
		return triplinesourceComponent.updateTriplinesource(triplinesource);
	
	}

		
	/**
	 * 修改 旅游线路来源但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplinesourceIgnoreNull(Triplinesource triplinesource){
			return triplinesourceComponent.updateTriplinesourceIgnoreNull(triplinesource);
	
	}
	
	/**
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesource(String where, String orderby,int limit,int offset){
		return triplinesourceComponent.findAllTriplinesource(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅游线路来源
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesource(long id){
		return triplinesourceComponent.findTriplinesource(id);
	}
	
	/**
	 * 查找 旅游线路来源
	 * @param id
	 * @return
	 */
	public Triplinesource findTriplinesourcebylanguage(long id,Integer language){
		return triplinesourceComponent.findTriplinesourcebylanguage(id,language);
	}
	/** 
	 * 查找 旅游线路来源
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriplinesourceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return triplinesourceComponent.findAllTriplinesource(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅游线路来源
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriplinesourceBySql(String sql,int limit,int offset){
		return triplinesourceComponent.findAllTriplinesource(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅游线路来源
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplinesourceBySql(String sql){
		return triplinesourceComponent.excuteTriplinesourceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplinesourceBySql(String sql){
		return triplinesourceComponent.countTriplinesourceBySql(sql);
	}
private ITickctspaComponent tickctspaComponent;
	  
 	
 	public ITickctspaComponent getTickctspaComponent() {
		return tickctspaComponent;
	}
	public void setTickctspaComponent(ITickctspaComponent  tickctspaComponent) {
		this.tickctspaComponent = tickctspaComponent;
	}
	/**
	 * 创建 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public Tickctspa createTickctspa(Tickctspa tickctspa) throws SQLException{
	
		return tickctspaComponent.createTickctspa(tickctspa);
	}
	/**
	 * 删除 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickctspa(long id){
	
		return tickctspaComponent.deleteTickctspa(id);
	}
	
	
	/**
	 * 修改 票务温泉
	 * @param id
	 * @return updated count 
	 */
	public int updateTickctspa(Tickctspa tickctspa){
		return tickctspaComponent.updateTickctspa(tickctspa);
	
	}

		
	/**
	 * 修改 票务温泉但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickctspaIgnoreNull(Tickctspa tickctspa){
			return tickctspaComponent.updateTickctspaIgnoreNull(tickctspa);
	
	}
	
	/**
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby,int limit,int offset){
		return tickctspaComponent.findAllTickctspa(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 票务温泉
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspa(long id){
		return tickctspaComponent.findTickctspa(id);
	}
	
	/**
	 * 查找 票务温泉
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspabylanguage(long id,Integer language){
		return tickctspaComponent.findTickctspabylanguage(id,language);
	}
	/** 
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickctspaForPageinfo(String where, String orderby,PageInfo pageinfo){
		return tickctspaComponent.findAllTickctspa(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找票务温泉
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspaBySql(String sql,int limit,int offset){
		return tickctspaComponent.findAllTickctspa(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 票务温泉
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickctspaBySql(String sql){
		return tickctspaComponent.excuteTickctspaBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickctspaBySql(String sql){
		return tickctspaComponent.countTickctspaBySql(sql);
	}
	
private IConferencehallComponent conferencehallComponent;
	  
 	
 	public IConferencehallComponent getConferencehallComponent() {
		return conferencehallComponent;
	}
	public void setConferencehallComponent(IConferencehallComponent  conferencehallComponent) {
		this.conferencehallComponent = conferencehallComponent;
	}
	/**
	 * 创建 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehall createConferencehall(Conferencehall conferencehall) throws SQLException{
	
		return conferencehallComponent.createConferencehall(conferencehall);
	}
	/**
	 * 删除 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehall(long id){
	
		return conferencehallComponent.deleteConferencehall(id);
	}
	
	
	/**
	 * 修改 会议厅
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehall(Conferencehall conferencehall){
		return conferencehallComponent.updateConferencehall(conferencehall);
	
	}

		
	/**
	 * 修改 会议厅但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehallIgnoreNull(Conferencehall conferencehall){
			return conferencehallComponent.updateConferencehallIgnoreNull(conferencehall);
	
	}
	
	/**
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,int limit,int offset){
		return conferencehallComponent.findAllConferencehall(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会议厅
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehall(long id){
		return conferencehallComponent.findConferencehall(id);
	}
	
	/**
	 * 查找 会议厅
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehallbylanguage(long id,Integer language){
		return conferencehallComponent.findConferencehallbylanguage(id,language);
	}
	/** 
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehallForPageinfo(String where, String orderby,PageInfo pageinfo){
		return conferencehallComponent.findAllConferencehall(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会议厅
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehallBySql(String sql,int limit,int offset){
		return conferencehallComponent.findAllConferencehall(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会议厅
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehallBySql(String sql){
		return conferencehallComponent.excuteConferencehallBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehallBySql(String sql){
		return conferencehallComponent.countConferencehallBySql(sql);
	}
	
	private IConferencehotelComponent conferencehotelComponent;
	  
 	
 	public IConferencehotelComponent getConferencehotelComponent() {
		return conferencehotelComponent;
	}
	public void setConferencehotelComponent(IConferencehotelComponent  conferencehotelComponent) {
		this.conferencehotelComponent = conferencehotelComponent;
	}
	/**
	 * 创建 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehotel createConferencehotel(Conferencehotel conferencehotel) throws SQLException{
	
		return conferencehotelComponent.createConferencehotel(conferencehotel);
	}
	/**
	 * 删除 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehotel(long id){
	
		return conferencehotelComponent.deleteConferencehotel(id);
	}
	
	
	/**
	 * 修改 会议酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehotel(Conferencehotel conferencehotel){
		return conferencehotelComponent.updateConferencehotel(conferencehotel);
	
	}

		
	/**
	 * 修改 会议酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehotelIgnoreNull(Conferencehotel conferencehotel){
			return conferencehotelComponent.updateConferencehotelIgnoreNull(conferencehotel);
	
	}
	
	/**
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby,int limit,int offset){
		return conferencehotelComponent.findAllConferencehotel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会议酒店
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotel(long id){
		return conferencehotelComponent.findConferencehotel(id);
	}
	
	/**
	 * 查找 会议酒店
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotelbylanguage(long id,Integer language){
		return conferencehotelComponent.findConferencehotelbylanguage(id,language);
	}
	/** 
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehotelForPageinfo(String where, String orderby,PageInfo pageinfo){
		return conferencehotelComponent.findAllConferencehotel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会议酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotelBySql(String sql,int limit,int offset){
		return conferencehotelComponent.findAllConferencehotel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会议酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehotelBySql(String sql){
		return conferencehotelComponent.excuteConferencehotelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehotelBySql(String sql){
		return conferencehotelComponent.countConferencehotelBySql(sql);
	}
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotticketComponent spotticketComponent;
	  
 	
 	public ISpotticketComponent getSpotticketComponent() {
		return spotticketComponent;
	}
	public void setSpotticketComponent(ISpotticketComponent  spotticketComponent) {
		this.spotticketComponent = spotticketComponent;
	}
	/**
	 * 创建 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public Spotticket createSpotticket(Spotticket spotticket) throws SQLException{
	
		return spotticketComponent.createSpotticket(spotticket);
	}
	/**
	 * 删除 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticket(long id){
	
		return spotticketComponent.deleteSpotticket(id);
	}
	
	
	/**
	 * 修改 景点门票
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticket(Spotticket spotticket){
		return spotticketComponent.updateSpotticket(spotticket);
	
	}

		
	/**
	 * 修改 景点门票但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketIgnoreNull(Spotticket spotticket){
			return spotticketComponent.updateSpotticketIgnoreNull(spotticket);
	
	}
	
	/**
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby,int limit,int offset){
		return spotticketComponent.findAllSpotticket(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景点门票
	 * @param id
	 * @return
	 */
	public Spotticket findSpotticket(long id){
		return spotticketComponent.findSpotticket(id);
	}
	
	/** 
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticketForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotticketComponent.findAllSpotticket(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景点门票
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketBySql(String sql,int limit,int offset){
		return spotticketComponent.findAllSpotticket(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景点门票
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketBySql(String sql){
		return spotticketComponent.excuteSpotticketBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketBySql(String sql){
		return spotticketComponent.countSpotticketBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotmesComponent spotmesComponent;
	  
 	
 	public ISpotmesComponent getSpotmesComponent() {
		return spotmesComponent;
	}
	public void setSpotmesComponent(ISpotmesComponent  spotmesComponent) {
		this.spotmesComponent = spotmesComponent;
	}
	/**
	 * 创建 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotmes createSpotmes(Spotmes spotmes) throws SQLException{
	
		return spotmesComponent.createSpotmes(spotmes);
	}
	/**
	 * 删除 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotmes(long id){
	
		return spotmesComponent.deleteSpotmes(id);
	}
	
	
	/**
	 * 修改 景点信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotmes(Spotmes spotmes){
		return spotmesComponent.updateSpotmes(spotmes);
	
	}

		
	/**
	 * 修改 景点信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotmesIgnoreNull(Spotmes spotmes){
			return spotmesComponent.updateSpotmesIgnoreNull(spotmes);
	
	}
	
	/**
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby,int limit,int offset){
		return spotmesComponent.findAllSpotmes(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景点信息
	 * @param id
	 * @return
	 */
	public Spotmes findSpotmes(long id){
		return spotmesComponent.findSpotmes(id);
	}
	
	/** 
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotmesForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotmesComponent.findAllSpotmes(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景点信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmesBySql(String sql,int limit,int offset){
		return spotmesComponent.findAllSpotmes(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景点信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotmesBySql(String sql){
		return spotmesComponent.excuteSpotmesBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotmesBySql(String sql){
		return spotmesComponent.countSpotmesBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotcityComponent spotcityComponent;
	  
 	
 	public ISpotcityComponent getSpotcityComponent() {
		return spotcityComponent;
	}
	public void setSpotcityComponent(ISpotcityComponent  spotcityComponent) {
		this.spotcityComponent = spotcityComponent;
	}
	/**
	 * 创建 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotcity createSpotcity(Spotcity spotcity) throws SQLException{
	
		return spotcityComponent.createSpotcity(spotcity);
	}
	/**
	 * 删除 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotcity(long id){
	
		return spotcityComponent.deleteSpotcity(id);
	}
	
	
	/**
	 * 修改 景区城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotcity(Spotcity spotcity){
		return spotcityComponent.updateSpotcity(spotcity);
	
	}

		
	/**
	 * 修改 景区城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotcityIgnoreNull(Spotcity spotcity){
			return spotcityComponent.updateSpotcityIgnoreNull(spotcity);
	
	}
	
	/**
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,int limit,int offset){
		return spotcityComponent.findAllSpotcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区城市
	 * @param id
	 * @return
	 */
	public Spotcity findSpotcity(long id){
		return spotcityComponent.findSpotcity(id);
	}
	
	/** 
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotcityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotcityComponent.findAllSpotcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcityBySql(String sql,int limit,int offset){
		return spotcityComponent.findAllSpotcity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotcityBySql(String sql){
		return spotcityComponent.excuteSpotcityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotcityBySql(String sql){
		return spotcityComponent.countSpotcityBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotorderComponent spotorderComponent;
	  
 	
 	public ISpotorderComponent getSpotorderComponent() {
		return spotorderComponent;
	}
	public void setSpotorderComponent(ISpotorderComponent  spotorderComponent) {
		this.spotorderComponent = spotorderComponent;
	}
	/**
	 * 创建 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotorder createSpotorder(Spotorder spotorder) throws SQLException{
	
		return spotorderComponent.createSpotorder(spotorder);
	}
	/**
	 * 删除 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotorder(long id){
	
		return spotorderComponent.deleteSpotorder(id);
	}
	
	
	/**
	 * 修改 门票订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotorder(Spotorder spotorder){
		return spotorderComponent.updateSpotorder(spotorder);
	
	}

		
	/**
	 * 修改 门票订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotorderIgnoreNull(Spotorder spotorder){
			return spotorderComponent.updateSpotorderIgnoreNull(spotorder);
	
	}
	
	/**
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby,int limit,int offset){
		return spotorderComponent.findAllSpotorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 门票订单
	 * @param id
	 * @return
	 */
	public Spotorder findSpotorder(long id){
		return spotorderComponent.findSpotorder(id);
	}
	
	/** 
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotorderComponent.findAllSpotorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找门票订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorderBySql(String sql,int limit,int offset){
		return spotorderComponent.findAllSpotorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 门票订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotorderBySql(String sql){
		return spotorderComponent.excuteSpotorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotorderBySql(String sql){
		return spotorderComponent.countSpotorderBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlineinfoComponent spotlineinfoComponent;
	  
 	
 	public ISpotlineinfoComponent getSpotlineinfoComponent() {
		return spotlineinfoComponent;
	}
	public void setSpotlineinfoComponent(ISpotlineinfoComponent  spotlineinfoComponent) {
		this.spotlineinfoComponent = spotlineinfoComponent;
	}
	/**
	 * 创建 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineinfo createSpotlineinfo(Spotlineinfo spotlineinfo) throws SQLException{
	
		return spotlineinfoComponent.createSpotlineinfo(spotlineinfo);
	}
	/**
	 * 删除 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineinfo(long id){
	
		return spotlineinfoComponent.deleteSpotlineinfo(id);
	}
	
	
	/**
	 * 修改 景区线路详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineinfo(Spotlineinfo spotlineinfo){
		return spotlineinfoComponent.updateSpotlineinfo(spotlineinfo);
	
	}

		
	/**
	 * 修改 景区线路详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineinfoIgnoreNull(Spotlineinfo spotlineinfo){
			return spotlineinfoComponent.updateSpotlineinfoIgnoreNull(spotlineinfo);
	
	}
	
	/**
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby,int limit,int offset){
		return spotlineinfoComponent.findAllSpotlineinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路详细信息
	 * @param id
	 * @return
	 */
	public Spotlineinfo findSpotlineinfo(long id){
		return spotlineinfoComponent.findSpotlineinfo(id);
	}
	
	/** 
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlineinfoComponent.findAllSpotlineinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfoBySql(String sql,int limit,int offset){
		return spotlineinfoComponent.findAllSpotlineinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineinfoBySql(String sql){
		return spotlineinfoComponent.excuteSpotlineinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineinfoBySql(String sql){
		return spotlineinfoComponent.countSpotlineinfoBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlineimgComponent spotlineimgComponent;
	  
 	
 	public ISpotlineimgComponent getSpotlineimgComponent() {
		return spotlineimgComponent;
	}
	public void setSpotlineimgComponent(ISpotlineimgComponent  spotlineimgComponent) {
		this.spotlineimgComponent = spotlineimgComponent;
	}
	/**
	 * 创建 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineimg createSpotlineimg(Spotlineimg spotlineimg) throws SQLException{
	
		return spotlineimgComponent.createSpotlineimg(spotlineimg);
	}
	/**
	 * 删除 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineimg(long id){
	
		return spotlineimgComponent.deleteSpotlineimg(id);
	}
	
	
	/**
	 * 修改 景区线路图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineimg(Spotlineimg spotlineimg){
		return spotlineimgComponent.updateSpotlineimg(spotlineimg);
	
	}

		
	/**
	 * 修改 景区线路图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineimgIgnoreNull(Spotlineimg spotlineimg){
			return spotlineimgComponent.updateSpotlineimgIgnoreNull(spotlineimg);
	
	}
	
	/**
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby,int limit,int offset){
		return spotlineimgComponent.findAllSpotlineimg(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路图片信息
	 * @param id
	 * @return
	 */
	public Spotlineimg findSpotlineimg(long id){
		return spotlineimgComponent.findSpotlineimg(id);
	}
	
	/** 
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineimgForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlineimgComponent.findAllSpotlineimg(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimgBySql(String sql,int limit,int offset){
		return spotlineimgComponent.findAllSpotlineimg(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineimgBySql(String sql){
		return spotlineimgComponent.excuteSpotlineimgBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineimgBySql(String sql){
		return spotlineimgComponent.countSpotlineimgBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlineComponent spotlineComponent;
	  
 	
 	public ISpotlineComponent getSpotlineComponent() {
		return spotlineComponent;
	}
	public void setSpotlineComponent(ISpotlineComponent  spotlineComponent) {
		this.spotlineComponent = spotlineComponent;
	}
	/**
	 * 创建 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotline createSpotline(Spotline spotline) throws SQLException{
	
		return spotlineComponent.createSpotline(spotline);
	}
	/**
	 * 删除 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotline(long id){
	
		return spotlineComponent.deleteSpotline(id);
	}
	
	
	/**
	 * 修改 景区线路信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotline(Spotline spotline){
		return spotlineComponent.updateSpotline(spotline);
	
	}

		
	/**
	 * 修改 景区线路信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineIgnoreNull(Spotline spotline){
			return spotlineComponent.updateSpotlineIgnoreNull(spotline);
	
	}
	
	/**
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,int limit,int offset){
		return spotlineComponent.findAllSpotline(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路信息
	 * @param id
	 * @return
	 */
	public Spotline findSpotline(long id){
		return spotlineComponent.findSpotline(id);
	}
	
	/** 
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlineComponent.findAllSpotline(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineBySql(String sql,int limit,int offset){
		return spotlineComponent.findAllSpotline(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineBySql(String sql){
		return spotlineComponent.excuteSpotlineBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineBySql(String sql){
		return spotlineComponent.countSpotlineBySql(sql);
	}
	
	



	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlinepriceComponent spotlinepriceComponent;
	  
 	
 	public ISpotlinepriceComponent getSpotlinepriceComponent() {
		return spotlinepriceComponent;
	}
	public void setSpotlinepriceComponent(ISpotlinepriceComponent  spotlinepriceComponent) {
		this.spotlinepriceComponent = spotlinepriceComponent;
	}
	/**
	 * 创建 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineprice createSpotlineprice(Spotlineprice spotlineprice) throws SQLException{
	
		return spotlinepriceComponent.createSpotlineprice(spotlineprice);
	}
	/**
	 * 删除 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineprice(long id){
	
		return spotlinepriceComponent.deleteSpotlineprice(id);
	}
	
	
	/**
	 * 修改 景区线路价格信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineprice(Spotlineprice spotlineprice){
		return spotlinepriceComponent.updateSpotlineprice(spotlineprice);
	
	}

		
	/**
	 * 修改 景区线路价格信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlinepriceIgnoreNull(Spotlineprice spotlineprice){
			return spotlinepriceComponent.updateSpotlinepriceIgnoreNull(spotlineprice);
	
	}
	
	/**
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,int limit,int offset){
		return spotlinepriceComponent.findAllSpotlineprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路价格信息
	 * @param id
	 * @return
	 */
	public Spotlineprice findSpotlineprice(long id){
		return spotlinepriceComponent.findSpotlineprice(id);
	}
	
	/** 
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlinepriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlinepriceComponent.findAllSpotlineprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路价格信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlinepriceBySql(String sql,int limit,int offset){
		return spotlinepriceComponent.findAllSpotlineprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路价格信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlinepriceBySql(String sql){
		return spotlinepriceComponent.excuteSpotlinepriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlinepriceBySql(String sql){
		return spotlinepriceComponent.countSpotlinepriceBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlineorderComponent spotlineorderComponent;
	  
 	
 	public ISpotlineorderComponent getSpotlineorderComponent() {
		return spotlineorderComponent;
	}
	public void setSpotlineorderComponent(ISpotlineorderComponent  spotlineorderComponent) {
		this.spotlineorderComponent = spotlineorderComponent;
	}
	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineorder createSpotlineorder(Spotlineorder spotlineorder) throws SQLException{
	
		return spotlineorderComponent.createSpotlineorder(spotlineorder);
	}
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineorder(long id){
	
		return spotlineorderComponent.deleteSpotlineorder(id);
	}
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineorder(Spotlineorder spotlineorder){
		return spotlineorderComponent.updateSpotlineorder(spotlineorder);
	
	}

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineorderIgnoreNull(Spotlineorder spotlineorder){
			return spotlineorderComponent.updateSpotlineorderIgnoreNull(spotlineorder);
	
	}
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,int limit,int offset){
		return spotlineorderComponent.findAllSpotlineorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Spotlineorder findSpotlineorder(long id){
		return spotlineorderComponent.findSpotlineorder(id);
	}
	
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlineorderComponent.findAllSpotlineorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorderBySql(String sql,int limit,int offset){
		return spotlineorderComponent.findAllSpotlineorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineorderBySql(String sql){
		return spotlineorderComponent.excuteSpotlineorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineorderBySql(String sql){
		return spotlineorderComponent.countSpotlineorderBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotlineuserComponent spotlineuserComponent;
	  
 	
 	public ISpotlineuserComponent getSpotlineuserComponent() {
		return spotlineuserComponent;
	}
	public void setSpotlineuserComponent(ISpotlineuserComponent  spotlineuserComponent) {
		this.spotlineuserComponent = spotlineuserComponent;
	}
	/**
	 * 创建 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineuser createSpotlineuser(Spotlineuser spotlineuser) throws SQLException{
	
		return spotlineuserComponent.createSpotlineuser(spotlineuser);
	}
	/**
	 * 删除 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineuser(long id){
	
		return spotlineuserComponent.deleteSpotlineuser(id);
	}
	
	
	/**
	 * 修改 线路游客
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineuser(Spotlineuser spotlineuser){
		return spotlineuserComponent.updateSpotlineuser(spotlineuser);
	
	}

		
	/**
	 * 修改 线路游客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineuserIgnoreNull(Spotlineuser spotlineuser){
			return spotlineuserComponent.updateSpotlineuserIgnoreNull(spotlineuser);
	
	}
	
	/**
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby,int limit,int offset){
		return spotlineuserComponent.findAllSpotlineuser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 线路游客
	 * @param id
	 * @return
	 */
	public Spotlineuser findSpotlineuser(long id){
		return spotlineuserComponent.findSpotlineuser(id);
	}
	
	/** 
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineuserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotlineuserComponent.findAllSpotlineuser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找线路游客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuserBySql(String sql,int limit,int offset){
		return spotlineuserComponent.findAllSpotlineuser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 线路游客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineuserBySql(String sql){
		return spotlineuserComponent.excuteSpotlineuserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineuserBySql(String sql){
		return spotlineuserComponent.countSpotlineuserBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IBuyingComponent buyingComponent;
	  
 	
 	public IBuyingComponent getBuyingComponent() {
		return buyingComponent;
	}
	public void setBuyingComponent(IBuyingComponent  buyingComponent) {
		this.buyingComponent = buyingComponent;
	}
	/**
	 * 创建 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public Buying createBuying(Buying buying) throws SQLException{
	
		return buyingComponent.createBuying(buying);
	}
	/**
	 * 删除 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuying(long id){
	
		return buyingComponent.deleteBuying(id);
	}
	
	
	/**
	 * 修改 团购信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuying(Buying buying){
		return buyingComponent.updateBuying(buying);
	
	}

		
	/**
	 * 修改 团购信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingIgnoreNull(Buying buying){
			return buyingComponent.updateBuyingIgnoreNull(buying);
	
	}
	
	/**
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String where, String orderby,int limit,int offset){
		return buyingComponent.findAllBuying(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团购信息
	 * @param id
	 * @return
	 */
	public Buying findBuying(long id){
		return buyingComponent.findBuying(id);
	}
	
	/** 
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingForPageinfo(String where, String orderby,PageInfo pageinfo){
		return buyingComponent.findAllBuying(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团购信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingBySql(String sql,int limit,int offset){
		return buyingComponent.findAllBuying(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团购信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingBySql(String sql){
		return buyingComponent.excuteBuyingBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingBySql(String sql){
		return buyingComponent.countBuyingBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IBuyingimgComponent buyingimgComponent;
	  
 	
 	public IBuyingimgComponent getBuyingimgComponent() {
		return buyingimgComponent;
	}
	public void setBuyingimgComponent(IBuyingimgComponent  buyingimgComponent) {
		this.buyingimgComponent = buyingimgComponent;
	}
	/**
	 * 创建 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Buyingimg createBuyingimg(Buyingimg buyingimg) throws SQLException{
	
		return buyingimgComponent.createBuyingimg(buyingimg);
	}
	/**
	 * 删除 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuyingimg(long id){
	
		return buyingimgComponent.deleteBuyingimg(id);
	}
	
	
	/**
	 * 修改 团购图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuyingimg(Buyingimg buyingimg){
		return buyingimgComponent.updateBuyingimg(buyingimg);
	
	}

		
	/**
	 * 修改 团购图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingimgIgnoreNull(Buyingimg buyingimg){
			return buyingimgComponent.updateBuyingimgIgnoreNull(buyingimg);
	
	}
	
	/**
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby,int limit,int offset){
		return buyingimgComponent.findAllBuyingimg(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团购图片信息
	 * @param id
	 * @return
	 */
	public Buyingimg findBuyingimg(long id){
		return buyingimgComponent.findBuyingimg(id);
	}
	
	/** 
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingimgForPageinfo(String where, String orderby,PageInfo pageinfo){
		return buyingimgComponent.findAllBuyingimg(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团购图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimgBySql(String sql,int limit,int offset){
		return buyingimgComponent.findAllBuyingimg(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团购图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingimgBySql(String sql){
		return buyingimgComponent.excuteBuyingimgBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingimgBySql(String sql){
		return buyingimgComponent.countBuyingimgBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IQzguojiaComponent qzguojiaComponent;
	  
 	
 	public IQzguojiaComponent getQzguojiaComponent() {
		return qzguojiaComponent;
	}
	public void setQzguojiaComponent(IQzguojiaComponent  qzguojiaComponent) {
		this.qzguojiaComponent = qzguojiaComponent;
	}
	/**
	 * 创建 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public Qzguojia createQzguojia(Qzguojia qzguojia) throws SQLException{
	
		return qzguojiaComponent.createQzguojia(qzguojia);
	}
	/**
	 * 删除 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzguojia(long id){
	
		return qzguojiaComponent.deleteQzguojia(id);
	}
	
	
	/**
	 * 修改 签证国家
	 * @param id
	 * @return updated count 
	 */
	public int updateQzguojia(Qzguojia qzguojia){
		return qzguojiaComponent.updateQzguojia(qzguojia);
	
	}

		
	/**
	 * 修改 签证国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzguojiaIgnoreNull(Qzguojia qzguojia){
			return qzguojiaComponent.updateQzguojiaIgnoreNull(qzguojia);
	
	}
	
	/**
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,int limit,int offset){
		return qzguojiaComponent.findAllQzguojia(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 签证国家
	 * @param id
	 * @return
	 */
	public Qzguojia findQzguojia(long id){
		return qzguojiaComponent.findQzguojia(id);
	}
	
	/** 
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzguojiaForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qzguojiaComponent.findAllQzguojia(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找签证国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojiaBySql(String sql,int limit,int offset){
		return qzguojiaComponent.findAllQzguojia(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 签证国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzguojiaBySql(String sql){
		return qzguojiaComponent.excuteQzguojiaBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzguojiaBySql(String sql){
		return qzguojiaComponent.countQzguojiaBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IQzchanpinComponent qzchanpinComponent;
	  
 	
 	public IQzchanpinComponent getQzchanpinComponent() {
		return qzchanpinComponent;
	}
	public void setQzchanpinComponent(IQzchanpinComponent  qzchanpinComponent) {
		this.qzchanpinComponent = qzchanpinComponent;
	}
	/**
	 * 创建 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpin createQzchanpin(Qzchanpin qzchanpin) throws SQLException{
	
		return qzchanpinComponent.createQzchanpin(qzchanpin);
	}
	/**
	 * 删除 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpin(long id){
	
		return qzchanpinComponent.deleteQzchanpin(id);
	}
	
	
	/**
	 * 修改 签证产品
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpin(Qzchanpin qzchanpin){
		return qzchanpinComponent.updateQzchanpin(qzchanpin);
	
	}

		
	/**
	 * 修改 签证产品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpinIgnoreNull(Qzchanpin qzchanpin){
			return qzchanpinComponent.updateQzchanpinIgnoreNull(qzchanpin);
	
	}
	
	/**
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpin(String where, String orderby,int limit,int offset){
		return qzchanpinComponent.findAllQzchanpin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 签证产品
	 * @param id
	 * @return
	 */
	public Qzchanpin findQzchanpin(long id){
		return qzchanpinComponent.findQzchanpin(id);
	}
	
	/** 
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpinForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qzchanpinComponent.findAllQzchanpin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找签证产品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpinBySql(String sql,int limit,int offset){
		return qzchanpinComponent.findAllQzchanpin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 签证产品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpinBySql(String sql){
		return qzchanpinComponent.excuteQzchanpinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpinBySql(String sql){
		return qzchanpinComponent.countQzchanpinBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IQzchanpininfoComponent qzchanpininfoComponent;
	  
 	
 	public IQzchanpininfoComponent getQzchanpininfoComponent() {
		return qzchanpininfoComponent;
	}
	public void setQzchanpininfoComponent(IQzchanpininfoComponent  qzchanpininfoComponent) {
		this.qzchanpininfoComponent = qzchanpininfoComponent;
	}
	/**
	 * 创建 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpininfo createQzchanpininfo(Qzchanpininfo qzchanpininfo) throws SQLException{
	
		return qzchanpininfoComponent.createQzchanpininfo(qzchanpininfo);
	}
	/**
	 * 删除 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpininfo(long id){
	
		return qzchanpininfoComponent.deleteQzchanpininfo(id);
	}
	
	
	/**
	 * 修改 签证产品详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpininfo(Qzchanpininfo qzchanpininfo){
		return qzchanpininfoComponent.updateQzchanpininfo(qzchanpininfo);
	
	}

		
	/**
	 * 修改 签证产品详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpininfoIgnoreNull(Qzchanpininfo qzchanpininfo){
			return qzchanpininfoComponent.updateQzchanpininfoIgnoreNull(qzchanpininfo);
	
	}
	
	/**
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfo(String where, String orderby,int limit,int offset){
		return qzchanpininfoComponent.findAllQzchanpininfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 签证产品详细信息
	 * @param id
	 * @return
	 */
	public Qzchanpininfo findQzchanpininfo(long id){
		return qzchanpininfoComponent.findQzchanpininfo(id);
	}
	
	/** 
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpininfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qzchanpininfoComponent.findAllQzchanpininfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找签证产品详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfoBySql(String sql,int limit,int offset){
		return qzchanpininfoComponent.findAllQzchanpininfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 签证产品详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpininfoBySql(String sql){
		return qzchanpininfoComponent.excuteQzchanpininfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpininfoBySql(String sql){
		return qzchanpininfoComponent.countQzchanpininfoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ISpotticketcityComponent spotticketcityComponent;
	  
 	
 	public ISpotticketcityComponent getSpotticketcityComponent() {
		return spotticketcityComponent;
	}
	public void setSpotticketcityComponent(ISpotticketcityComponent  spotticketcityComponent) {
		this.spotticketcityComponent = spotticketcityComponent;
	}
	/**
	 * 创建 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotticketcity createSpotticketcity(Spotticketcity spotticketcity) throws SQLException{
	
		return spotticketcityComponent.createSpotticketcity(spotticketcity);
	}
	/**
	 * 删除 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticketcity(long id){
	
		return spotticketcityComponent.deleteSpotticketcity(id);
	}
	
	
	/**
	 * 修改 门票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticketcity(Spotticketcity spotticketcity){
		return spotticketcityComponent.updateSpotticketcity(spotticketcity);
	
	}

		
	/**
	 * 修改 门票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketcityIgnoreNull(Spotticketcity spotticketcity){
			return spotticketcityComponent.updateSpotticketcityIgnoreNull(spotticketcity);
	
	}
	
	/**
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcity(String where, String orderby,int limit,int offset){
		return spotticketcityComponent.findAllSpotticketcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 门票城市
	 * @param id
	 * @return
	 */
	public Spotticketcity findSpotticketcity(long id){
		return spotticketcityComponent.findSpotticketcity(id);
	}
	
	/** 
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticketcityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spotticketcityComponent.findAllSpotticketcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找门票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcityBySql(String sql,int limit,int offset){
		return spotticketcityComponent.findAllSpotticketcity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 门票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketcityBySql(String sql){
		return spotticketcityComponent.excuteSpotticketcityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketcityBySql(String sql){
		return spotticketcityComponent.countSpotticketcityBySql(sql);
	}
	
	




}
