package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yf.system.base.airbaseprice.Airbaseprice;
import com.yf.system.base.airbaseprice.IAirbasepriceComponent;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.aircompany.IAircompanyComponent;
import com.yf.system.base.airfee.Airfee;
import com.yf.system.base.airfee.IAirfeeComponent;
import com.yf.system.base.airflight.Airflight;
import com.yf.system.base.airflight.IAirflightComponent;
import com.yf.system.base.airlien.Airlien;
import com.yf.system.base.airlien.IAirlienComponent;
import com.yf.system.base.airliencabin.Airliencabin;
import com.yf.system.base.airliencabin.IAirliencabinComponent;
import com.yf.system.base.backpoint.Backpoint;
import com.yf.system.base.backpoint.IBackpointComponent;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.cabin.ICabinComponent;
import com.yf.system.base.changpass.Changpass;
import com.yf.system.base.changpass.IChangpassComponent;
import com.yf.system.base.charterorder.Charterorder;
import com.yf.system.base.charterorder.ICharterorderComponent;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.cityairport.ICityairportComponent;
import com.yf.system.base.cpzrate.Cpzrate;
import com.yf.system.base.cpzrate.ICpzrateComponent;
import com.yf.system.base.customeraircard.Customeraircard;
import com.yf.system.base.customeraircard.ICustomeraircardComponent;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.fcountry.IFcountryComponent;
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.system.base.flightmodel.IFlightmodelComponent;
import com.yf.system.base.flightstop.Flightstop;
import com.yf.system.base.flightstop.IFlightstopComponent;
import com.yf.system.base.insurcomputer.IInsurcomputerComponent;
import com.yf.system.base.insurcomputer.Insurcomputer;
import com.yf.system.base.insurorder.IInsurorderComponent;
import com.yf.system.base.insurorder.Insurorder;
import com.yf.system.base.insuruser.IInsuruserComponent;
import com.yf.system.base.insuruser.Insuruser;
import com.yf.system.base.jinribaobiao.IJinribaobiaoComponent;
import com.yf.system.base.jinribaobiao.Jinribaobiao;
import com.yf.system.base.kweifabu.IKweifabuComponent;
import com.yf.system.base.kweifabu.Kweifabu;
import com.yf.system.base.kweisq.IKweisqComponent;
import com.yf.system.base.kweisq.Kweisq;
import com.yf.system.base.limitcabin.ILimitcabinComponent;
import com.yf.system.base.limitcabin.Limitcabin;
import com.yf.system.base.lowestprice.ILowestpriceComponent;
import com.yf.system.base.lowestprice.Lowestprice;
import com.yf.system.base.nfdprice.INfdpriceComponent;
import com.yf.system.base.nfdprice.Nfdprice;
import com.yf.system.base.noterecorder.INoterecorderComponent;
import com.yf.system.base.noterecorder.Noterecorder;
import com.yf.system.base.orderinfo.IOrderinfoComponent;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.IOrderinforcComponent;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.IPassengerComponent;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.passengerrepayrc.IPassengerrepayrcComponent;
import com.yf.system.base.passengerrepayrc.Passengerrepayrc;
import com.yf.system.base.paymentrecorder.IPaymentrecorderComponent;
import com.yf.system.base.paymentrecorder.Paymentrecorder;
import com.yf.system.base.peisong.IPeisongComponent;
import com.yf.system.base.peisong.Peisong;
import com.yf.system.base.perworkload.IPerworkloadComponent;
import com.yf.system.base.perworkload.Perworkload;
import com.yf.system.base.policyperiod.IPolicyperiodComponent;
import com.yf.system.base.policyperiod.Policyperiod;
import com.yf.system.base.rdepartment.IRdepartmentComponent;
import com.yf.system.base.rdepartment.Rdepartment;
import com.yf.system.base.rgroupcustomers.IRgroupcustomersComponent;
import com.yf.system.base.rgroupcustomers.Rgroupcustomers;
import com.yf.system.base.rperformance.IRperformanceComponent;
import com.yf.system.base.rperformance.Rperformance;
import com.yf.system.base.rsector.IRsectorComponent;
import com.yf.system.base.rsector.Rsector;
import com.yf.system.base.rzhixiao.IRzhixiaoComponent;
import com.yf.system.base.rzhixiao.Rzhixiao;
import com.yf.system.base.scang.IScangComponent;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.ISegmentinfoComponent;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.sellreport.ISellreportComponent;
import com.yf.system.base.sellreport.Sellreport;
import com.yf.system.base.specialprice.ISpecialpriceComponent;
import com.yf.system.base.specialprice.Specialprice;
import com.yf.system.base.spzrate.ISpzrateComponent;
import com.yf.system.base.spzrate.Spzrate;
import com.yf.system.base.supteam.ISupteamComponent;
import com.yf.system.base.supteam.Supteam;
import com.yf.system.base.sysmessage.ISysmessageComponent;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.teamapply.ITeamapplyComponent;
import com.yf.system.base.teamapply.Teamapply;
import com.yf.system.base.template.ITemplateComponent;
import com.yf.system.base.template.Template;
import com.yf.system.base.ticketapp.ITicketappComponent;
import com.yf.system.base.ticketapp.Ticketapp;
import com.yf.system.base.tuipiao.ITuipiaoComponent;
import com.yf.system.base.tuipiao.Tuipiao;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.xcdno.IXcdnoComponent;
import com.yf.system.base.xcdno.Xcdno;
import com.yf.system.base.xcdnoinfo.IXcdnoinfoComponent;
import com.yf.system.base.xcdnoinfo.Xcdnoinfo;
import com.yf.system.base.xcdorder.IXcdorderComponent;
import com.yf.system.base.xcdorder.Xcdorder;
import com.yf.system.base.zhefan.IZhefanComponent;
import com.yf.system.base.zhefan.Zhefan;
import com.yf.system.base.zrate.IZrateComponent;
import com.yf.system.base.zrate.Zrate;

public class AirService implements IAirService{
	
	private Map<String,Object> map;
	private boolean cache;
	
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
		
	/**
	 * 添加 
	 * @param key
	 * @param value
	 */
	public void setToCache(String key,Object value){
		if(cache){
			if(map==null){
				map = new HashMap<String,Object>();
			}
			map.put(key, value);
		}
	}
	
	
	/**
	 * 获取
	 * @param key
	 */
	public Object getFromCache(String key){
		if(cache){
			if(map!=null){
				return map.get(key);
			}
		}
		return null;
	}
	
	/**
	 * 移除
	 * @param key
	 */
	public void removeFromCache(String key){
		if(cache){
			if(map!=null){
				map.remove(key);
			}	
		}	
	}
	

	private ICityairportComponent cityairportComponent;
	  
 	
 	public ICityairportComponent getCityairportComponent() {
		return cityairportComponent;
	}
	public void setCityairportComponent(ICityairportComponent  cityairportComponent) {
		this.cityairportComponent = cityairportComponent;
	}
	/**
	 * 创建 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public Cityairport createCityairport(Cityairport cityairport) throws SQLException{
	
		return cityairportComponent.createCityairport(cityairport);
	}
	/**
	 * 删除 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCityairport(long id){
	
		return cityairportComponent.deleteCityairport(id);
	}
	
	
	/**
	 * 修改 机场城市
	 * @param id
	 * @return updated count 
	 */
	public int updateCityairport(Cityairport cityairport){
		return cityairportComponent.updateCityairport(cityairport);
	
	}

		
	/**
	 * 修改 机场城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityairportIgnoreNull(Cityairport cityairport){
			return cityairportComponent.updateCityairportIgnoreNull(cityairport);
	
	}
	
	/**
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairport(String where, String orderby,int limit,int offset){
		return cityairportComponent.findAllCityairport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机场城市
	 * @param id
	 * @return
	 */
	public Cityairport findCityairport(long id){
		return cityairportComponent.findCityairport(id);
	}
	
	/** 
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCityairportForPageinfo(String where, String orderby,PageInfo pageinfo){
		return cityairportComponent.findAllCityairport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机场城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairportBySql(String sql,int limit,int offset){
		return cityairportComponent.findAllCityairport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机场城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityairportBySql(String sql){
		return cityairportComponent.excuteCityairportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityairportBySql(String sql){
		return cityairportComponent.countCityairportBySql(sql);
	}
	///////////////////////
private ITemplateComponent templateComponent;
	  
 	
 	public ITemplateComponent getTemplateComponent() {
		return templateComponent;
	}
	public void setTemplateComponent(ITemplateComponent  templateComponent) {
		this.templateComponent = templateComponent;
	}
	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Template createTemplate(Template template) throws SQLException{
	
		return templateComponent.createTemplate(template);
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplate(long id){
	
		return templateComponent.deleteTemplate(id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplate(Template template){
		return templateComponent.updateTemplate(template);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTemplateIgnoreNull(Template template){
			return templateComponent.updateTemplateIgnoreNull(template);
	
	}
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplate(String where, String orderby,int limit,int offset){
		return templateComponent.findAllTemplate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Template findTemplate(long id){
		return templateComponent.findTemplate(id);
	}
	
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return templateComponent.findAllTemplate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplateBySql(String sql,int limit,int offset){
		return templateComponent.findAllTemplate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTemplateBySql(String sql){
		return templateComponent.excuteTemplateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTemplateBySql(String sql){
		return templateComponent.countTemplateBySql(sql);
	}
	////////////////////
private IZrateComponent zrateComponent;
	  
 	
 	public IZrateComponent getZrateComponent() {
		return zrateComponent;
	}
	public void setZrateComponent(IZrateComponent  zrateComponent) {
		this.zrateComponent = zrateComponent;
	}
	/**
	 * 创建 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public Zrate createZrate(Zrate zrate) throws SQLException{
	
		return zrateComponent.createZrate(zrate);
	}
	/**
	 * 删除 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZrate(long id){
	
		return zrateComponent.deleteZrate(id);
	}
	
	
	/**
	 * 修改 普通政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateZrate(Zrate zrate){
		return zrateComponent.updateZrate(zrate);
	
	}

		
	/**
	 * 修改 普通政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZrateIgnoreNull(Zrate zrate){
			return zrateComponent.updateZrateIgnoreNull(zrate);
	
	}
	
	/**
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrate(String where, String orderby,int limit,int offset){
		return zrateComponent.findAllZrate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrate(long id){
		return zrateComponent.findZrate(id);
	}
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrateByDB(long id){
		return zrateComponent.findZrateByDB(id);
	}
	
	/** 
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZrateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return zrateComponent.findAllZrate(where, orderby,pageinfo);
	}
	
	public List findAllZrateBySP(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo )
	{
		return zrateComponent.findAllZrateBySP(tableName, fldName, fldSort, sort, where, fldID, pageinfo);
	}
		
	/** 
	 * 根据Sql查找普通政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrateBySql(String sql,int limit,int offset){
		return zrateComponent.findAllZrate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 普通政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZrateBySql(String sql){
		return zrateComponent.excuteZrateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZrateBySql(String sql){
		return zrateComponent.countZrateBySql(sql);
	}
	///////////////////////////
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
	
	////////////////////
private ISpzrateComponent spzrateComponent;
	  
 	
 	public ISpzrateComponent getSpzrateComponent() {
		return spzrateComponent;
	}
	public void setSpzrateComponent(ISpzrateComponent  spzrateComponent) {
		this.spzrateComponent = spzrateComponent;
	}
	/**
	 * 创建 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public Spzrate createSpzrate(Spzrate spzrate) throws SQLException{
	
		return spzrateComponent.createSpzrate(spzrate);
	}
	/**
	 * 删除 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpzrate(long id){
	
		return spzrateComponent.deleteSpzrate(id);
	}
	
	
	/**
	 * 修改 特价政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateSpzrate(Spzrate spzrate){
		return spzrateComponent.updateSpzrate(spzrate);
	
	}

		
	/**
	 * 修改 特价政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpzrateIgnoreNull(Spzrate spzrate){
			return spzrateComponent.updateSpzrateIgnoreNull(spzrate);
	
	}
	
	/**
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,int limit,int offset){
		return spzrateComponent.findAllSpzrate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价政策表
	 * @param id
	 * @return
	 */
	public Spzrate findSpzrate(long id){
		return spzrateComponent.findSpzrate(id);
	}
	
	/** 
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpzrateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return spzrateComponent.findAllSpzrate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrateBySql(String sql,int limit,int offset){
		return spzrateComponent.findAllSpzrate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpzrateBySql(String sql){
		return spzrateComponent.excuteSpzrateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpzrateBySql(String sql){
		return spzrateComponent.countSpzrateBySql(sql);
	}
	
	
////////////////////
private ISegmentinfoComponent segmentinfoComponent;
	  
 	
 	public ISegmentinfoComponent getSegmentinfoComponent() {
		return segmentinfoComponent;
	}
	public void setSegmentinfoComponent(ISegmentinfoComponent  segmentinfoComponent) {
		this.segmentinfoComponent = segmentinfoComponent;
	}
	/**
	 * 创建 行程表
	 * @param id
	 * @return deleted count 
	 */
	public Segmentinfo createSegmentinfo(Segmentinfo segmentinfo) throws SQLException{
	
		return segmentinfoComponent.createSegmentinfo(segmentinfo);
	}
	/**
	 * 删除 行程表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSegmentinfo(long id){
	
		return segmentinfoComponent.deleteSegmentinfo(id);
	}
	
	
	/**
	 * 修改 行程表
	 * @param id
	 * @return updated count 
	 */
	public int updateSegmentinfo(Segmentinfo segmentinfo){
		return segmentinfoComponent.updateSegmentinfo(segmentinfo);
	
	}

		
	/**
	 * 修改 行程表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSegmentinfoIgnoreNull(Segmentinfo segmentinfo){
			return segmentinfoComponent.updateSegmentinfoIgnoreNull(segmentinfo);
	
	}
	
	/**
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfo(String where, String orderby,int limit,int offset){
		return segmentinfoComponent.findAllSegmentinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程表
	 * @param id
	 * @return
	 */
	public Segmentinfo findSegmentinfo(long id){
		return segmentinfoComponent.findSegmentinfo(id);
	}
	
	/** 
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSegmentinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return segmentinfoComponent.findAllSegmentinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfoBySql(String sql,int limit,int offset){
		return segmentinfoComponent.findAllSegmentinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSegmentinfoBySql(String sql){
		return segmentinfoComponent.excuteSegmentinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSegmentinfoBySql(String sql){
		return segmentinfoComponent.countSegmentinfoBySql(sql);
	}
	/////////////////////
private IPolicyperiodComponent policyperiodComponent;
	  
 	
 	public IPolicyperiodComponent getPolicyperiodComponent() {
		return policyperiodComponent;
	}
	public void setPolicyperiodComponent(IPolicyperiodComponent  policyperiodComponent) {
		this.policyperiodComponent = policyperiodComponent;
	}
	/**
	 * 创建 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public Policyperiod createPolicyperiod(Policyperiod policyperiod) throws SQLException{
	
		return policyperiodComponent.createPolicyperiod(policyperiod);
	}
	/**
	 * 删除 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePolicyperiod(long id){
	
		return policyperiodComponent.deletePolicyperiod(id);
	}
	
	
	/**
	 * 修改 政策有效期表
	 * @param id
	 * @return updated count 
	 */
	public int updatePolicyperiod(Policyperiod policyperiod){
		return policyperiodComponent.updatePolicyperiod(policyperiod);
	
	}

		
	/**
	 * 修改 政策有效期表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePolicyperiodIgnoreNull(Policyperiod policyperiod){
			return policyperiodComponent.updatePolicyperiodIgnoreNull(policyperiod);
	
	}
	
	/**
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,int limit,int offset){
		return policyperiodComponent.findAllPolicyperiod(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 政策有效期表
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiod(long id){
		return policyperiodComponent.findPolicyperiod(id);
	}
	
	/** 
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPolicyperiodForPageinfo(String where, String orderby,PageInfo pageinfo){
		return policyperiodComponent.findAllPolicyperiod(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找政策有效期表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiodBySql(String sql,int limit,int offset){
		return policyperiodComponent.findAllPolicyperiod(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 政策有效期表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePolicyperiodBySql(String sql){
		return policyperiodComponent.excutePolicyperiodBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPolicyperiodBySql(String sql){
		return policyperiodComponent.countPolicyperiodBySql(sql);
	}
	/////////////////////////

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
	///////////
private IPassengerComponent passengerComponent;
	  
 	
 	public IPassengerComponent getPassengerComponent() {
		return passengerComponent;
	}
	public void setPassengerComponent(IPassengerComponent  passengerComponent) {
		this.passengerComponent = passengerComponent;
	}
	/**
	 * 创建 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Passenger createPassenger(Passenger passenger) throws SQLException{
	
		return passengerComponent.createPassenger(passenger);
	}
	/**
	 * 删除 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassenger(long id){
	
		return passengerComponent.deletePassenger(id);
	}
	
	
	/**
	 * 修改 乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updatePassenger(Passenger passenger){
		return passengerComponent.updatePassenger(passenger);
	
	}

		
	/**
	 * 修改 乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerIgnoreNull(Passenger passenger){
			return passengerComponent.updatePassengerIgnoreNull(passenger);
	
	}
	
	/**
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,int limit,int offset){
		return passengerComponent.findAllPassenger(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 乘机人表
	 * @param id
	 * @return
	 */
	public Passenger findPassenger(long id){
		return passengerComponent.findPassenger(id);
	}
	
	/** 
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassengerForPageinfo(String where, String orderby,PageInfo pageinfo){
		return passengerComponent.findAllPassenger(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerBySql(String sql,int limit,int offset){
		return passengerComponent.findAllPassenger(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerBySql(String sql){
		return passengerComponent.excutePassengerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerBySql(String sql){
		return passengerComponent.countPassengerBySql(sql);
	}
	//////////////////////////////
private IOrderinforcComponent orderinforcComponent;
	  
 	
 	public IOrderinforcComponent getOrderinforcComponent() {
		return orderinforcComponent;
	}
	public void setOrderinforcComponent(IOrderinforcComponent  orderinforcComponent) {
		this.orderinforcComponent = orderinforcComponent;
	}
	/**
	 * 创建 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public Orderinforc createOrderinforc(Orderinforc orderinforc) throws SQLException{
	
		return orderinforcComponent.createOrderinforc(orderinforc);
	}
	/**
	 * 删除 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOrderinforc(long id){
	
		return orderinforcComponent.deleteOrderinforc(id);
	}
	
	
	/**
	 * 修改 订单处理记录
	 * @param id
	 * @return updated count 
	 */
	public int updateOrderinforc(Orderinforc orderinforc){
		return orderinforcComponent.updateOrderinforc(orderinforc);
	
	}

		
	/**
	 * 修改 订单处理记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOrderinforcIgnoreNull(Orderinforc orderinforc){
			return orderinforcComponent.updateOrderinforcIgnoreNull(orderinforc);
	
	}
	
	/**
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,int limit,int offset){
		return orderinforcComponent.findAllOrderinforc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单处理记录
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforc(long id){
		return orderinforcComponent.findOrderinforc(id);
	}
	
	/** 
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinforcForPageinfo(String where, String orderby,PageInfo pageinfo){
		return orderinforcComponent.findAllOrderinforc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单处理记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforcBySql(String sql,int limit,int offset){
		return orderinforcComponent.findAllOrderinforc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单处理记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOrderinforcBySql(String sql){
		return orderinforcComponent.excuteOrderinforcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOrderinforcBySql(String sql){
		return orderinforcComponent.countOrderinforcBySql(sql);
	}
	///////////////////
private IOrderinfoComponent orderinfoComponent;
	  
 	
 	public IOrderinfoComponent getOrderinfoComponent() {
		return orderinfoComponent;
	}
	public void setOrderinfoComponent(IOrderinfoComponent  orderinfoComponent) {
		this.orderinfoComponent = orderinfoComponent;
	}
	/**
	 * 创建 订单信息表
	 * @param id
	 * @return deleted count 
	 */
	public Orderinfo createOrderinfo(Orderinfo orderinfo) throws SQLException{
	
		return orderinfoComponent.createOrderinfo(orderinfo);
	}
	/**
	 * 删除 订单信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOrderinfo(long id){
	
		return orderinfoComponent.deleteOrderinfo(id);
	}
	
	
	/**
	 * 修改 订单信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateOrderinfo(Orderinfo orderinfo){
		return orderinfoComponent.updateOrderinfo(orderinfo);
	
	}

		
	/**
	 * 修改 订单信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOrderinfoIgnoreNull(Orderinfo orderinfo){
			return orderinfoComponent.updateOrderinfoIgnoreNull(orderinfo);
	
	}
	
	/**
	 * 查找 订单信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinfo(String where, String orderby,int limit,int offset){
		return orderinfoComponent.findAllOrderinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单信息表
	 * @param id
	 * @return
	 */
	public Orderinfo findOrderinfo(long id){
		return orderinfoComponent.findOrderinfo(id);
	}
	
	/** 
	 * 查找 订单信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return orderinfoComponent.findAllOrderinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinfoBySql(String sql,int limit,int offset){
		return orderinfoComponent.findAllOrderinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOrderinfoBySql(String sql){
		return orderinfoComponent.excuteOrderinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOrderinfoBySql(String sql){
		return orderinfoComponent.countOrderinfoBySql(sql);
	}
	
	/////////////////////////

	private INoterecorderComponent noterecorderComponent;
	  
 	
 	public INoterecorderComponent getNoterecorderComponent() {
		return noterecorderComponent;
	}
	public void setNoterecorderComponent(INoterecorderComponent  noterecorderComponent) {
		this.noterecorderComponent = noterecorderComponent;
	}
	/**
	 * 创建 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public Noterecorder createNoterecorder(Noterecorder noterecorder) throws SQLException{
	
		return noterecorderComponent.createNoterecorder(noterecorder);
	}
	/**
	 * 删除 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNoterecorder(long id){
	
		return noterecorderComponent.deleteNoterecorder(id);
	}
	
	
	/**
	 * 修改 通知记录
	 * @param id
	 * @return updated count 
	 */
	public int updateNoterecorder(Noterecorder noterecorder){
		return noterecorderComponent.updateNoterecorder(noterecorder);
	
	}

		
	/**
	 * 修改 通知记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNoterecorderIgnoreNull(Noterecorder noterecorder){
			return noterecorderComponent.updateNoterecorderIgnoreNull(noterecorder);
	
	}
	
	/**
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorder(String where, String orderby,int limit,int offset){
		return noterecorderComponent.findAllNoterecorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 通知记录
	 * @param id
	 * @return
	 */
	public Noterecorder findNoterecorder(long id){
		return noterecorderComponent.findNoterecorder(id);
	}
	
	/** 
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNoterecorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return noterecorderComponent.findAllNoterecorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找通知记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorderBySql(String sql,int limit,int offset){
		return noterecorderComponent.findAllNoterecorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 通知记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNoterecorderBySql(String sql){
		return noterecorderComponent.excuteNoterecorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNoterecorderBySql(String sql){
		return noterecorderComponent.countNoterecorderBySql(sql);
	}
	
	
////////////////////////////
private IFlightstopComponent flightstopComponent;
	  
 	
 	public IFlightstopComponent getFlightstopComponent() {
		return flightstopComponent;
	}
	public void setFlightstopComponent(IFlightstopComponent  flightstopComponent) {
		this.flightstopComponent = flightstopComponent;
	}
	/**
	 * 创建 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public Flightstop createFlightstop(Flightstop flightstop) throws SQLException{
	
		return flightstopComponent.createFlightstop(flightstop);
	}
	/**
	 * 删除 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightstop(long id){
	
		return flightstopComponent.deleteFlightstop(id);
	}
	
	
	/**
	 * 修改 航班经停信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightstop(Flightstop flightstop){
		return flightstopComponent.updateFlightstop(flightstop);
	
	}

		
	/**
	 * 修改 航班经停信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightstopIgnoreNull(Flightstop flightstop){
			return flightstopComponent.updateFlightstopIgnoreNull(flightstop);
	
	}
	
	/**
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstop(String where, String orderby,int limit,int offset){
		return flightstopComponent.findAllFlightstop(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航班经停信息
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstop(long id){
		return flightstopComponent.findFlightstop(id);
	}
	
	/** 
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightstopForPageinfo(String where, String orderby,PageInfo pageinfo){
		return flightstopComponent.findAllFlightstop(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航班经停信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstopBySql(String sql,int limit,int offset){
		return flightstopComponent.findAllFlightstop(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航班经停信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightstopBySql(String sql){
		return flightstopComponent.excuteFlightstopBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightstopBySql(String sql){
		return flightstopComponent.countFlightstopBySql(sql);
	}
	
	///////////////////////
private IFlightmodelComponent flightmodelComponent;
	  
 	
 	public IFlightmodelComponent getFlightmodelComponent() {
		return flightmodelComponent;
	}
	public void setFlightmodelComponent(IFlightmodelComponent  flightmodelComponent) {
		this.flightmodelComponent = flightmodelComponent;
	}
	/**
	 * 创建 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public Flightmodel createFlightmodel(Flightmodel flightmodel) throws SQLException{
	
		return flightmodelComponent.createFlightmodel(flightmodel);
	}
	/**
	 * 删除 机型信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightmodel(long id){
	
		return flightmodelComponent.deleteFlightmodel(id);
	}
	
	
	/**
	 * 修改 机型信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightmodel(Flightmodel flightmodel){
		return flightmodelComponent.updateFlightmodel(flightmodel);
	
	}

		
	/**
	 * 修改 机型信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightmodelIgnoreNull(Flightmodel flightmodel){
			return flightmodelComponent.updateFlightmodelIgnoreNull(flightmodel);
	
	}
	
	/**
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodel(String where, String orderby,int limit,int offset){
		return flightmodelComponent.findAllFlightmodel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机型信息表
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodel(long id){
		return flightmodelComponent.findFlightmodel(id);
	}
	
	/** 
	 * 查找 机型信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightmodelForPageinfo(String where, String orderby,PageInfo pageinfo){
		return flightmodelComponent.findAllFlightmodel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机型信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightmodelBySql(String sql,int limit,int offset){
		return flightmodelComponent.findAllFlightmodel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机型信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightmodelBySql(String sql){
		return flightmodelComponent.excuteFlightmodelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightmodelBySql(String sql){
		return flightmodelComponent.countFlightmodelBySql(sql);
	}
	//////////////////////
private ICustomeraircardComponent customeraircardComponent;
	  
 	
 	public ICustomeraircardComponent getCustomeraircardComponent() {
		return customeraircardComponent;
	}
	public void setCustomeraircardComponent(ICustomeraircardComponent  customeraircardComponent) {
		this.customeraircardComponent = customeraircardComponent;
	}
	/**
	 * 创建 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public Customeraircard createCustomeraircard(Customeraircard customeraircard) throws SQLException{
	
		return customeraircardComponent.createCustomeraircard(customeraircard);
	}
	/**
	 * 删除 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeraircard(long id){
	
		return customeraircardComponent.deleteCustomeraircard(id);
	}
	
	
	/**
	 * 修改 里程卡
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeraircard(Customeraircard customeraircard){
		return customeraircardComponent.updateCustomeraircard(customeraircard);
	
	}

		
	/**
	 * 修改 里程卡但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeraircardIgnoreNull(Customeraircard customeraircard){
			return customeraircardComponent.updateCustomeraircardIgnoreNull(customeraircard);
	
	}
	
	/**
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,int limit,int offset){
		return customeraircardComponent.findAllCustomeraircard(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 里程卡
	 * @param id
	 * @return
	 */
	public Customeraircard findCustomeraircard(long id){
		return customeraircardComponent.findCustomeraircard(id);
	}
	
	/** 
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeraircardForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customeraircardComponent.findAllCustomeraircard(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找里程卡
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircardBySql(String sql,int limit,int offset){
		return customeraircardComponent.findAllCustomeraircard(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 里程卡
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeraircardBySql(String sql){
		return customeraircardComponent.excuteCustomeraircardBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeraircardBySql(String sql){
		return customeraircardComponent.countCustomeraircardBySql(sql);
	}
	////////////////////
private ICabinComponent cabinComponent;
	  
 	
 	public ICabinComponent getCabinComponent() {
		return cabinComponent;
	}
	public void setCabinComponent(ICabinComponent  cabinComponent) {
		this.cabinComponent = cabinComponent;
	}
	/**
	 * 创建 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Cabin createCabin(Cabin cabin) throws SQLException{
	
		return cabinComponent.createCabin(cabin);
	}
	/**
	 * 删除 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCabin(long id){
	
		return cabinComponent.deleteCabin(id);
	}
	
	
	/**
	 * 修改 舱位基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCabin(Cabin cabin){
		return cabinComponent.updateCabin(cabin);
	
	}

		
	/**
	 * 修改 舱位基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCabinIgnoreNull(Cabin cabin){
			return cabinComponent.updateCabinIgnoreNull(cabin);
	
	}
	
	/**
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabin(String where, String orderby,int limit,int offset){
		return cabinComponent.findAllCabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 舱位基础信息表
	 * @param id
	 * @return
	 */
	public Cabin findCabin(long id){
		return cabinComponent.findCabin(id);
	}
	
	/** 
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCabinForPageinfo(String where, String orderby,PageInfo pageinfo){
		return cabinComponent.findAllCabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找舱位基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabinBySql(String sql,int limit,int offset){
		return cabinComponent.findAllCabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 舱位基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCabinBySql(String sql){
		return cabinComponent.excuteCabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCabinBySql(String sql){
		return cabinComponent.countCabinBySql(sql);
	}
	////////////////////////////
private IBackpointComponent backpointComponent;
	  
 	
 	public IBackpointComponent getBackpointComponent() {
		return backpointComponent;
	}
	public void setBackpointComponent(IBackpointComponent  backpointComponent) {
		this.backpointComponent = backpointComponent;
	}
	/**
	 * 创建 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public Backpoint createBackpoint(Backpoint backpoint) throws SQLException{
	
		return backpointComponent.createBackpoint(backpoint);
	}
	/**
	 * 删除 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBackpoint(long id){
	
		return backpointComponent.deleteBackpoint(id);
	}
	
	
	/**
	 * 修改 隐扣设置
	 * @param id
	 * @return updated count 
	 */
	public int updateBackpoint(Backpoint backpoint){
		return backpointComponent.updateBackpoint(backpoint);
	
	}

		
	/**
	 * 修改 隐扣设置但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBackpointIgnoreNull(Backpoint backpoint){
			return backpointComponent.updateBackpointIgnoreNull(backpoint);
	
	}
	
	/**
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpoint(String where, String orderby,int limit,int offset){
		return backpointComponent.findAllBackpoint(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 隐扣设置
	 * @param id
	 * @return
	 */
	public Backpoint findBackpoint(long id){
		return backpointComponent.findBackpoint(id);
	}
	
	/** 
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBackpointForPageinfo(String where, String orderby,PageInfo pageinfo){
		return backpointComponent.findAllBackpoint(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找隐扣设置
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpointBySql(String sql,int limit,int offset){
		return backpointComponent.findAllBackpoint(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 隐扣设置
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBackpointBySql(String sql){
		return backpointComponent.excuteBackpointBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBackpointBySql(String sql){
		return backpointComponent.countBackpointBySql(sql);
	}
	///////////////////////////
private IAirflightComponent airflightComponent;
	  
 	
 	public IAirflightComponent getAirflightComponent() {
		return airflightComponent;
	}
	public void setAirflightComponent(IAirflightComponent  airflightComponent) {
		this.airflightComponent = airflightComponent;
	}
	/**
	 * 创建 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Airflight createAirflight(Airflight airflight) throws SQLException{
	
		return airflightComponent.createAirflight(airflight);
	}
	/**
	 * 删除 航班基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirflight(long id){
	
		return airflightComponent.deleteAirflight(id);
	}
	
	
	/**
	 * 修改 航班基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirflight(Airflight airflight){
		return airflightComponent.updateAirflight(airflight);
	
	}

		
	/**
	 * 修改 航班基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirflightIgnoreNull(Airflight airflight){
			return airflightComponent.updateAirflightIgnoreNull(airflight);
	
	}
	
	/**
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflight(String where, String orderby,int limit,int offset){
		return airflightComponent.findAllAirflight(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航班基础信息表
	 * @param id
	 * @return
	 */
	public Airflight findAirflight(long id){
		return airflightComponent.findAirflight(id);
	}
	
	/** 
	 * 查找 航班基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirflightForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airflightComponent.findAllAirflight(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航班基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirflightBySql(String sql,int limit,int offset){
		return airflightComponent.findAllAirflight(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航班基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirflightBySql(String sql){
		return airflightComponent.excuteAirflightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirflightBySql(String sql){
		return airflightComponent.countAirflightBySql(sql);
	}
	
	/////////////
private IAirfeeComponent airfeeComponent;
	  
 	
 	public IAirfeeComponent getAirfeeComponent() {
		return airfeeComponent;
	}
	public void setAirfeeComponent(IAirfeeComponent  airfeeComponent) {
		this.airfeeComponent = airfeeComponent;
	}
	/**
	 * 创建 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public Airfee createAirfee(Airfee airfee) throws SQLException{
	
		return airfeeComponent.createAirfee(airfee);
	}
	/**
	 * 删除 燃油费机建费表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirfee(long id){
	
		return airfeeComponent.deleteAirfee(id);
	}
	
	
	/**
	 * 修改 燃油费机建费表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirfee(Airfee airfee){
		return airfeeComponent.updateAirfee(airfee);
	
	}

		
	/**
	 * 修改 燃油费机建费表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirfeeIgnoreNull(Airfee airfee){
			return airfeeComponent.updateAirfeeIgnoreNull(airfee);
	
	}
	
	/**
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfee(String where, String orderby,int limit,int offset){
		return airfeeComponent.findAllAirfee(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 燃油费机建费表
	 * @param id
	 * @return
	 */
	public Airfee findAirfee(long id){
		return airfeeComponent.findAirfee(id);
	}
	
	/** 
	 * 查找 燃油费机建费表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirfeeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airfeeComponent.findAllAirfee(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找燃油费机建费表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirfeeBySql(String sql,int limit,int offset){
		return airfeeComponent.findAllAirfee(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 燃油费机建费表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirfeeBySql(String sql){
		return airfeeComponent.excuteAirfeeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirfeeBySql(String sql){
		return airfeeComponent.countAirfeeBySql(sql);
	}
//////////////////	
private IAircompanyComponent aircompanyComponent;
	  
 	
 	public IAircompanyComponent getAircompanyComponent() {
		return aircompanyComponent;
	}
	public void setAircompanyComponent(IAircompanyComponent  aircompanyComponent) {
		this.aircompanyComponent = aircompanyComponent;
	}
	/**
	 * 创建 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Aircompany createAircompany(Aircompany aircompany) throws SQLException{
	
		return aircompanyComponent.createAircompany(aircompany);
	}
	/**
	 * 删除 航空公司基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAircompany(long id){
	
		return aircompanyComponent.deleteAircompany(id);
	}
	
	
	/**
	 * 修改 航空公司基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateAircompany(Aircompany aircompany){
		return aircompanyComponent.updateAircompany(aircompany);
	
	}

		
	/**
	 * 修改 航空公司基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAircompanyIgnoreNull(Aircompany aircompany){
			return aircompanyComponent.updateAircompanyIgnoreNull(aircompany);
	
	}
	
	/**
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompany(String where, String orderby,int limit,int offset){
		return aircompanyComponent.findAllAircompany(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航空公司基础信息表
	 * @param id
	 * @return
	 */
	public Aircompany findAircompany(long id){
		return aircompanyComponent.findAircompany(id);
	}
	
	/** 
	 * 查找 航空公司基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAircompanyForPageinfo(String where, String orderby,PageInfo pageinfo){
		return aircompanyComponent.findAllAircompany(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航空公司基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAircompanyBySql(String sql,int limit,int offset){
		return aircompanyComponent.findAllAircompany(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航空公司基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAircompanyBySql(String sql){
		return aircompanyComponent.excuteAircompanyBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAircompanyBySql(String sql){
		return aircompanyComponent.countAircompanyBySql(sql);
	}
	///////////////////////
private IAirbasepriceComponent airbasepriceComponent;
	  
 	
 	public IAirbasepriceComponent getAirbasepriceComponent() {
		return airbasepriceComponent;
	}
	public void setAirbasepriceComponent(IAirbasepriceComponent  airbasepriceComponent) {
		this.airbasepriceComponent = airbasepriceComponent;
	}
	/**
	 * 创建 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public Airbaseprice createAirbaseprice(Airbaseprice airbaseprice) throws SQLException{
	
		return airbasepriceComponent.createAirbaseprice(airbaseprice);
	}
	/**
	 * 删除 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirbaseprice(long id){
	
		return airbasepriceComponent.deleteAirbaseprice(id);
	}
	
	
	/**
	 * 修改 机票基础价格表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirbaseprice(Airbaseprice airbaseprice){
		return airbasepriceComponent.updateAirbaseprice(airbaseprice);
	
	}

		
	/**
	 * 修改 机票基础价格表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirbasepriceIgnoreNull(Airbaseprice airbaseprice){
			return airbasepriceComponent.updateAirbasepriceIgnoreNull(airbaseprice);
	
	}
	
	/**
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,int limit,int offset){
		return airbasepriceComponent.findAllAirbaseprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票基础价格表
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbaseprice(long id){
		return airbasepriceComponent.findAirbaseprice(id);
	}
	
	/** 
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirbasepriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airbasepriceComponent.findAllAirbaseprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票基础价格表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbasepriceBySql(String sql,int limit,int offset){
		return airbasepriceComponent.findAllAirbaseprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票基础价格表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirbasepriceBySql(String sql){
		return airbasepriceComponent.excuteAirbasepriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirbasepriceBySql(String sql){
		return airbasepriceComponent.countAirbasepriceBySql(sql);
	}
	
	////////////////////////
private ISpecialpriceComponent specialpriceComponent;
	  
 	
 	public ISpecialpriceComponent getSpecialpriceComponent() {
		return specialpriceComponent;
	}
	public void setSpecialpriceComponent(ISpecialpriceComponent  specialpriceComponent) {
		this.specialpriceComponent = specialpriceComponent;
	}
	/**
	 * 创建 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public Specialprice createSpecialprice(Specialprice specialprice) throws SQLException{
	
		return specialpriceComponent.createSpecialprice(specialprice);
	}
	/**
	 * 删除 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpecialprice(long id){
	
		return specialpriceComponent.deleteSpecialprice(id);
	}
	
	
	/**
	 * 修改 特价机票信息（定期更新）
	 * @param id
	 * @return updated count 
	 */
	public int updateSpecialprice(Specialprice specialprice){
		return specialpriceComponent.updateSpecialprice(specialprice);
	
	}

		
	/**
	 * 修改 特价机票信息（定期更新）但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpecialpriceIgnoreNull(Specialprice specialprice){
			return specialpriceComponent.updateSpecialpriceIgnoreNull(specialprice);
	
	}
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,int limit,int offset){
		return specialpriceComponent.findAllSpecialprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param id
	 * @return
	 */
	public Specialprice findSpecialprice(long id){
		return specialpriceComponent.findSpecialprice(id);
	}
	
	/** 
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpecialpriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return specialpriceComponent.findAllSpecialprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价机票信息（定期更新）
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialpriceBySql(String sql,int limit,int offset){
		return specialpriceComponent.findAllSpecialprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价机票信息（定期更新）
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpecialpriceBySql(String sql){
		return specialpriceComponent.excuteSpecialpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpecialpriceBySql(String sql){
		return specialpriceComponent.countSpecialpriceBySql(sql);
	}
	/**
	 * 查找 航空公司基础信息表
	 * @param id
	 * @return
	 */
	public Aircompany findAircompanybylanguage(long id,Integer language){
		return aircompanyComponent.findAircompanybylanguage(id,language);
	}
	
	/**
	 * 查找 舱位基础信息表
	 * @param id
	 * @return
	 */
	public Cabin findCabinbylanguage(long id,Integer language){
		return cabinComponent.findCabinbylanguage(id,language);
	}
	/**
	 * 查找 航班经停信息
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstopbylanguage(long id,Integer language){
		return flightstopComponent.findFlightstopbylanguage(id,language);
	}
	
	/**
	 * 查找 机场城市
	 * @param id
	 * @return
	 */
	public Cityairport findCityairportbylanguage(long id,Integer language){
		return cityairportComponent.findCityairportbylanguage(id,language);
	}
	
	/**
	 * 查找 机型信息表
	 * @param id
	 * @return
	 */
	public Flightmodel findFlightmodelbylanguage(long id,Integer language){
		return flightmodelComponent.findFlightmodelbylanguage(id,language);
	}
	private ICpzrateComponent cpzrateComponent;
	  
 	
 	public ICpzrateComponent getCpzrateComponent() {
		return cpzrateComponent;
	}
	public void setCpzrateComponent(ICpzrateComponent  cpzrateComponent) {
		this.cpzrateComponent = cpzrateComponent;
	}
	/**
	 * 创建 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public Cpzrate createCpzrate(Cpzrate cpzrate) throws SQLException{
	
		return cpzrateComponent.createCpzrate(cpzrate);
	}
	/**
	 * 删除 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCpzrate(long id){
	
		return cpzrateComponent.deleteCpzrate(id);
	}
	
	
	/**
	 * 修改 包机政策
	 * @param id
	 * @return updated count 
	 */
	public int updateCpzrate(Cpzrate cpzrate){
		return cpzrateComponent.updateCpzrate(cpzrate);
	
	}

		
	/**
	 * 修改 包机政策但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCpzrateIgnoreNull(Cpzrate cpzrate){
			return cpzrateComponent.updateCpzrateIgnoreNull(cpzrate);
	
	}
	
	/**
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrate(String where, String orderby,int limit,int offset){
		return cpzrateComponent.findAllCpzrate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 包机政策
	 * @param id
	 * @return
	 */
	public Cpzrate findCpzrate(long id){
		return cpzrateComponent.findCpzrate(id);
	}
	
	/** 
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCpzrateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return cpzrateComponent.findAllCpzrate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找包机政策
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrateBySql(String sql,int limit,int offset){
		return cpzrateComponent.findAllCpzrate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 包机政策
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCpzrateBySql(String sql){
		return cpzrateComponent.excuteCpzrateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCpzrateBySql(String sql){
		return cpzrateComponent.countCpzrateBySql(sql);
	}
	//
private ITeamapplyComponent teamapplyComponent;
	  
 	
 	public ITeamapplyComponent getTeamapplyComponent() {
		return teamapplyComponent;
	}
	public void setTeamapplyComponent(ITeamapplyComponent  teamapplyComponent) {
		this.teamapplyComponent = teamapplyComponent;
	}
	/**
	 * 创建 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public Teamapply createTeamapply(Teamapply teamapply) throws SQLException{
	
		return teamapplyComponent.createTeamapply(teamapply);
	}
	/**
	 * 删除 团队申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTeamapply(long id){
	
		return teamapplyComponent.deleteTeamapply(id);
	}
	
	
	/**
	 * 修改 团队申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTeamapply(Teamapply teamapply){
		return teamapplyComponent.updateTeamapply(teamapply);
	
	}

		
	/**
	 * 修改 团队申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTeamapplyIgnoreNull(Teamapply teamapply){
			return teamapplyComponent.updateTeamapplyIgnoreNull(teamapply);
	
	}
	
	/**
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapply(String where, String orderby,int limit,int offset){
		return teamapplyComponent.findAllTeamapply(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团队申请表
	 * @param id
	 * @return
	 */
	public Teamapply findTeamapply(long id){
		return teamapplyComponent.findTeamapply(id);
	}
	
	/** 
	 * 查找 团队申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTeamapplyForPageinfo(String where, String orderby,PageInfo pageinfo){
		return teamapplyComponent.findAllTeamapply(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团队申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTeamapplyBySql(String sql,int limit,int offset){
		return teamapplyComponent.findAllTeamapply(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团队申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTeamapplyBySql(String sql){
		return teamapplyComponent.excuteTeamapplyBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTeamapplyBySql(String sql){
		return teamapplyComponent.countTeamapplyBySql(sql);
	}
	////
private ISupteamComponent supteamComponent;
	  
 	
 	public ISupteamComponent getSupteamComponent() {
		return supteamComponent;
	}
	public void setSupteamComponent(ISupteamComponent  supteamComponent) {
		this.supteamComponent = supteamComponent;
	}
	/**
	 * 创建 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public Supteam createSupteam(Supteam supteam) throws SQLException{
	
		return supteamComponent.createSupteam(supteam);
	}
	/**
	 * 删除 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSupteam(long id){
	
		return supteamComponent.deleteSupteam(id);
	}
	
	
	/**
	 * 修改 团队申请报价表
	 * @param id
	 * @return updated count 
	 */
	public int updateSupteam(Supteam supteam){
		return supteamComponent.updateSupteam(supteam);
	
	}

		
	/**
	 * 修改 团队申请报价表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSupteamIgnoreNull(Supteam supteam){
			return supteamComponent.updateSupteamIgnoreNull(supteam);
	
	}
	
	/**
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,int limit,int offset){
		return supteamComponent.findAllSupteam(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团队申请报价表
	 * @param id
	 * @return
	 */
	public Supteam findSupteam(long id){
		return supteamComponent.findSupteam(id);
	}
	
	/** 
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSupteamForPageinfo(String where, String orderby,PageInfo pageinfo){
		return supteamComponent.findAllSupteam(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团队申请报价表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteamBySql(String sql,int limit,int offset){
		return supteamComponent.findAllSupteam(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团队申请报价表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSupteamBySql(String sql){
		return supteamComponent.excuteSupteamBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSupteamBySql(String sql){
		return supteamComponent.countSupteamBySql(sql);
	}
	
	////
//粘贴到Service实现类
	
	private IKweisqComponent kweisqComponent;
	  
 	
 	public IKweisqComponent getKweisqComponent() {
		return kweisqComponent;
	}
	public void setKweisqComponent(IKweisqComponent  kweisqComponent) {
		this.kweisqComponent = kweisqComponent;
	}
	/**
	 * 创建 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Kweisq createKweisq(Kweisq kweisq) throws SQLException{
	
		return kweisqComponent.createKweisq(kweisq);
	}
	/**
	 * 删除 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweisq(long id){
	
		return kweisqComponent.deleteKweisq(id);
	}
	
	
	/**
	 * 修改 K位特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweisq(Kweisq kweisq){
		return kweisqComponent.updateKweisq(kweisq);
	
	}

		
	/**
	 * 修改 K位特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweisqIgnoreNull(Kweisq kweisq){
			return kweisqComponent.updateKweisqIgnoreNull(kweisq);
	
	}
	
	/**
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisq(String where, String orderby,int limit,int offset){
		return kweisqComponent.findAllKweisq(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 K位特价申请表
	 * @param id
	 * @return
	 */
	public Kweisq findKweisq(long id){
		return kweisqComponent.findKweisq(id);
	}
	
	/** 
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweisqForPageinfo(String where, String orderby,PageInfo pageinfo){
		return kweisqComponent.findAllKweisq(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找K位特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisqBySql(String sql,int limit,int offset){
		return kweisqComponent.findAllKweisq(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql K位特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweisqBySql(String sql){
		return kweisqComponent.excuteKweisqBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweisqBySql(String sql){
		return kweisqComponent.countKweisqBySql(sql);
	}
	
	///
//粘贴到Service实现类
	
	private IKweifabuComponent kweifabuComponent;
	  
 	
 	public IKweifabuComponent getKweifabuComponent() {
		return kweifabuComponent;
	}
	public void setKweifabuComponent(IKweifabuComponent  kweifabuComponent) {
		this.kweifabuComponent = kweifabuComponent;
	}
	/**
	 * 创建 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public Kweifabu createKweifabu(Kweifabu kweifabu) throws SQLException{
	
		return kweifabuComponent.createKweifabu(kweifabu);
	}
	/**
	 * 删除 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweifabu(long id){
	
		return kweifabuComponent.deleteKweifabu(id);
	}
	
	
	/**
	 * 修改 K位特价发布表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweifabu(Kweifabu kweifabu){
		return kweifabuComponent.updateKweifabu(kweifabu);
	
	}

		
	/**
	 * 修改 K位特价发布表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweifabuIgnoreNull(Kweifabu kweifabu){
			return kweifabuComponent.updateKweifabuIgnoreNull(kweifabu);
	
	}
	
	/**
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabu(String where, String orderby,int limit,int offset){
		return kweifabuComponent.findAllKweifabu(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 K位特价发布表
	 * @param id
	 * @return
	 */
	public Kweifabu findKweifabu(long id){
		return kweifabuComponent.findKweifabu(id);
	}
	
	/** 
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweifabuForPageinfo(String where, String orderby,PageInfo pageinfo){
		return kweifabuComponent.findAllKweifabu(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找K位特价发布表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabuBySql(String sql,int limit,int offset){
		return kweifabuComponent.findAllKweifabu(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql K位特价发布表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweifabuBySql(String sql){
		return kweifabuComponent.excuteKweifabuBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweifabuBySql(String sql){
		return kweifabuComponent.countKweifabuBySql(sql);
	}
	
	//
private IJinribaobiaoComponent jinribaobiaoComponent;
	  
 	
 	public IJinribaobiaoComponent getJinribaobiaoComponent() {
		return jinribaobiaoComponent;
	}
	public void setJinribaobiaoComponent(IJinribaobiaoComponent  jinribaobiaoComponent) {
		this.jinribaobiaoComponent = jinribaobiaoComponent;
	}
	/**
	 * 创建 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public Jinribaobiao createJinribaobiao(Jinribaobiao jinribaobiao) throws SQLException{
	
		return jinribaobiaoComponent.createJinribaobiao(jinribaobiao);
	}
	/**
	 * 删除 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteJinribaobiao(long id){
	
		return jinribaobiaoComponent.deleteJinribaobiao(id);
	}
	
	
	/**
	 * 修改 今日报表
	 * @param id
	 * @return updated count 
	 */
	public int updateJinribaobiao(Jinribaobiao jinribaobiao){
		return jinribaobiaoComponent.updateJinribaobiao(jinribaobiao);
	
	}

		
	/**
	 * 修改 今日报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateJinribaobiaoIgnoreNull(Jinribaobiao jinribaobiao){
			return jinribaobiaoComponent.updateJinribaobiaoIgnoreNull(jinribaobiao);
	
	}
	
	/**
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiao(String where, String orderby,int limit,int offset){
		return jinribaobiaoComponent.findAllJinribaobiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 今日报表
	 * @param id
	 * @return
	 */
	public Jinribaobiao findJinribaobiao(long id){
		return jinribaobiaoComponent.findJinribaobiao(id);
	}
	
	/** 
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllJinribaobiaoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return jinribaobiaoComponent.findAllJinribaobiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找今日报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiaoBySql(String sql,int limit,int offset){
		return jinribaobiaoComponent.findAllJinribaobiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 今日报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteJinribaobiaoBySql(String sql){
		return jinribaobiaoComponent.excuteJinribaobiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countJinribaobiaoBySql(String sql){
		return jinribaobiaoComponent.countJinribaobiaoBySql(sql);
	}
	
	//
private ITuipiaoComponent tuipiaoComponent;
	  
 	
 	public ITuipiaoComponent getTuipiaoComponent() {
		return tuipiaoComponent;
	}
	public void setTuipiaoComponent(ITuipiaoComponent  tuipiaoComponent) {
		this.tuipiaoComponent = tuipiaoComponent;
	}
	/**
	 * 创建 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public Tuipiao createTuipiao(Tuipiao tuipiao) throws SQLException{
	
		return tuipiaoComponent.createTuipiao(tuipiao);
	}
	/**
	 * 删除 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTuipiao(long id){
	
		return tuipiaoComponent.deleteTuipiao(id);
	}
	
	
	/**
	 * 修改 退票报表
	 * @param id
	 * @return updated count 
	 */
	public int updateTuipiao(Tuipiao tuipiao){
		return tuipiaoComponent.updateTuipiao(tuipiao);
	
	}

		
	/**
	 * 修改 退票报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTuipiaoIgnoreNull(Tuipiao tuipiao){
			return tuipiaoComponent.updateTuipiaoIgnoreNull(tuipiao);
	
	}
	
	/**
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,int limit,int offset){
		return tuipiaoComponent.findAllTuipiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 退票报表
	 * @param id
	 * @return
	 */
	public Tuipiao findTuipiao(long id){
		return tuipiaoComponent.findTuipiao(id);
	}
	
	/** 
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTuipiaoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return tuipiaoComponent.findAllTuipiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找退票报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiaoBySql(String sql,int limit,int offset){
		return tuipiaoComponent.findAllTuipiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 退票报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTuipiaoBySql(String sql){
		return tuipiaoComponent.excuteTuipiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTuipiaoBySql(String sql){
		return tuipiaoComponent.countTuipiaoBySql(sql);
	}
	
	//
private ISellreportComponent sellreportComponent;
	  
 	
 	public ISellreportComponent getSellreportComponent() {
		return sellreportComponent;
	}
	public void setSellreportComponent(ISellreportComponent  sellreportComponent) {
		this.sellreportComponent = sellreportComponent;
	}
	/**
	 * 创建 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public Sellreport createSellreport(Sellreport sellreport) throws SQLException{
	
		return sellreportComponent.createSellreport(sellreport);
	}
	
	/**
	 * 删除 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSellreport(long id){
	
		return sellreportComponent.deleteSellreport(id);
	}
	
	
	/**
	 * 修改 销售报表
	 * @param id
	 * @return updated count 
	 */
	public int updateSellreport(Sellreport sellreport){
		return sellreportComponent.updateSellreport(sellreport);
	
	}

		
	/**
	 * 修改 销售报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSellreportIgnoreNull(Sellreport sellreport){
			return sellreportComponent.updateSellreportIgnoreNull(sellreport);
	
	}
	
	/**
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreport(String where, String orderby,int limit,int offset){
		return sellreportComponent.findAllSellreport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 销售报表
	 * @param id
	 * @return
	 */
	public Sellreport findSellreport(long id){
		return sellreportComponent.findSellreport(id);
	}
	
	/** 
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSellreportForPageinfo(String where, String orderby,PageInfo pageinfo){
		return sellreportComponent.findAllSellreport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找销售报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreportBySql(String sql,int limit,int offset){
		return sellreportComponent.findAllSellreport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 销售报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSellreportBySql(String sql){
		return sellreportComponent.excuteSellreportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSellreportBySql(String sql){
		return sellreportComponent.countSellreportBySql(sql);
	}
	
	
	private IScangComponent scangComponent;
	  
 	
 	public IScangComponent getScangComponent() {
		return scangComponent;
	}
	public void setScangComponent(IScangComponent  scangComponent) {
		this.scangComponent = scangComponent;
	}
	/**
	 * 创建 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public Scang createScang(Scang scang) throws SQLException{
	
		return scangComponent.createScang(scang);
	}
	/**
	 * 删除 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScang(long id){
	
		return scangComponent.deleteScang(id);
	}
	
	
	/**
	 * 修改 订单升舱表
	 * @param id
	 * @return updated count 
	 */
	public int updateScang(Scang scang){
		return scangComponent.updateScang(scang);
	
	}

		
	/**
	 * 修改 订单升舱表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScangIgnoreNull(Scang scang){
			return scangComponent.updateScangIgnoreNull(scang);
	
	}
	
	/**
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String where, String orderby,int limit,int offset){
		return scangComponent.findAllScang(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单升舱表
	 * @param id
	 * @return
	 */
	public Scang findScang(long id){
		return scangComponent.findScang(id);
	}
	
	/** 
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScangForPageinfo(String where, String orderby,PageInfo pageinfo){
		return scangComponent.findAllScang(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单升舱表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScangBySql(String sql,int limit,int offset){
		return scangComponent.findAllScang(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单升舱表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScangBySql(String sql){
		return scangComponent.excuteScangBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScangBySql(String sql){
		return scangComponent.countScangBySql(sql);
	}
private IRsectorComponent rsectorComponent;
	  
 	
 	public IRsectorComponent getRsectorComponent() {
		return rsectorComponent;
	}
	public void setRsectorComponent(IRsectorComponent  rsectorComponent) {
		this.rsectorComponent = rsectorComponent;
	}
	/**
	 * 创建 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public Rsector createRsector(Rsector rsector) throws SQLException{
	
		return rsectorComponent.createRsector(rsector);
	}
	/**
	 * 删除 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRsector(long id){
	
		return rsectorComponent.deleteRsector(id);
	}
	
	
	/**
	 * 修改 部门绩效表
	 * @param id
	 * @return updated count 
	 */
	public int updateRsector(Rsector rsector){
		return rsectorComponent.updateRsector(rsector);
	
	}

		
	/**
	 * 修改 部门绩效表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRsectorIgnoreNull(Rsector rsector){
			return rsectorComponent.updateRsectorIgnoreNull(rsector);
	
	}
	
	/**
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsector(String where, String orderby,int limit,int offset){
		return rsectorComponent.findAllRsector(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门绩效表
	 * @param id
	 * @return
	 */
	public Rsector findRsector(long id){
		return rsectorComponent.findRsector(id);
	}
	
	/** 
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRsectorForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rsectorComponent.findAllRsector(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门绩效表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsectorBySql(String sql,int limit,int offset){
		return rsectorComponent.findAllRsector(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门绩效表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRsectorBySql(String sql){
		return rsectorComponent.excuteRsectorBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRsectorBySql(String sql){
		return rsectorComponent.countRsectorBySql(sql);
	}
	
private IRperformanceComponent rperformanceComponent;
	  
 	
 	public IRperformanceComponent getRperformanceComponent() {
		return rperformanceComponent;
	}
	public void setRperformanceComponent(IRperformanceComponent  rperformanceComponent) {
		this.rperformanceComponent = rperformanceComponent;
	}
	/**
	 * 创建 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public Rperformance createRperformance(Rperformance rperformance) throws SQLException{
	
		return rperformanceComponent.createRperformance(rperformance);
	}
	/**
	 * 删除 绩效合约统计
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRperformance(long id){
	
		return rperformanceComponent.deleteRperformance(id);
	}
	
	
	/**
	 * 修改 绩效合约统计
	 * @param id
	 * @return updated count 
	 */
	public int updateRperformance(Rperformance rperformance){
		return rperformanceComponent.updateRperformance(rperformance);
	
	}

		
	/**
	 * 修改 绩效合约统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRperformanceIgnoreNull(Rperformance rperformance){
			return rperformanceComponent.updateRperformanceIgnoreNull(rperformance);
	
	}
	
	/**
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformance(String where, String orderby,int limit,int offset){
		return rperformanceComponent.findAllRperformance(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 绩效合约统计
	 * @param id
	 * @return
	 */
	public Rperformance findRperformance(long id){
		return rperformanceComponent.findRperformance(id);
	}
	
	/** 
	 * 查找 绩效合约统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRperformanceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rperformanceComponent.findAllRperformance(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找绩效合约统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRperformanceBySql(String sql,int limit,int offset){
		return rperformanceComponent.findAllRperformance(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 绩效合约统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRperformanceBySql(String sql){
		return rperformanceComponent.excuteRperformanceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRperformanceBySql(String sql){
		return rperformanceComponent.countRperformanceBySql(sql);
	}
private IPerworkloadComponent perworkloadComponent;
	  
 	
 	public IPerworkloadComponent getPerworkloadComponent() {
		return perworkloadComponent;
	}
	public void setPerworkloadComponent(IPerworkloadComponent  perworkloadComponent) {
		this.perworkloadComponent = perworkloadComponent;
	}
	/**
	 * 创建 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public Perworkload createPerworkload(Perworkload perworkload) throws SQLException{
	
		return perworkloadComponent.createPerworkload(perworkload);
	}
	/**
	 * 删除 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public int deletePerworkload(long id){
	
		return perworkloadComponent.deletePerworkload(id);
	}
	
	
	/**
	 * 修改 人均工作量统计
	 * @param id
	 * @return updated count 
	 */
	public int updatePerworkload(Perworkload perworkload){
		return perworkloadComponent.updatePerworkload(perworkload);
	
	}

		
	/**
	 * 修改 人均工作量统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePerworkloadIgnoreNull(Perworkload perworkload){
			return perworkloadComponent.updatePerworkloadIgnoreNull(perworkload);
	
	}
	
	/**
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkload(String where, String orderby,int limit,int offset){
		return perworkloadComponent.findAllPerworkload(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 人均工作量统计
	 * @param id
	 * @return
	 */
	public Perworkload findPerworkload(long id){
		return perworkloadComponent.findPerworkload(id);
	}
	
	/** 
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPerworkloadForPageinfo(String where, String orderby,PageInfo pageinfo){
		return perworkloadComponent.findAllPerworkload(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找人均工作量统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkloadBySql(String sql,int limit,int offset){
		return perworkloadComponent.findAllPerworkload(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 人均工作量统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePerworkloadBySql(String sql){
		return perworkloadComponent.excutePerworkloadBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPerworkloadBySql(String sql){
		return perworkloadComponent.countPerworkloadBySql(sql);
	}

	private IRdepartmentComponent rdepartmentComponent;
	  
 	
 	public IRdepartmentComponent getRdepartmentComponent() {
		return rdepartmentComponent;
	}
	public void setRdepartmentComponent(IRdepartmentComponent  rdepartmentComponent) {
		this.rdepartmentComponent = rdepartmentComponent;
	}
	/**
	 * 创建 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rdepartment createRdepartment(Rdepartment rdepartment) throws SQLException{
	
		return rdepartmentComponent.createRdepartment(rdepartment);
	}
	/**
	 * 删除 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRdepartment(long id){
	
		return rdepartmentComponent.deleteRdepartment(id);
	}
	
	
	/**
	 * 修改 部门销售汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRdepartment(Rdepartment rdepartment){
		return rdepartmentComponent.updateRdepartment(rdepartment);
	
	}

		
	/**
	 * 修改 部门销售汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRdepartmentIgnoreNull(Rdepartment rdepartment){
			return rdepartmentComponent.updateRdepartmentIgnoreNull(rdepartment);
	
	}
	
	/**
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,int limit,int offset){
		return rdepartmentComponent.findAllRdepartment(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门销售汇总表
	 * @param id
	 * @return
	 */
	public Rdepartment findRdepartment(long id){
		return rdepartmentComponent.findRdepartment(id);
	}
	
	/** 
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRdepartmentForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rdepartmentComponent.findAllRdepartment(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门销售汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartmentBySql(String sql,int limit,int offset){
		return rdepartmentComponent.findAllRdepartment(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门销售汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRdepartmentBySql(String sql){
		return rdepartmentComponent.excuteRdepartmentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRdepartmentBySql(String sql){
		return rdepartmentComponent.countRdepartmentBySql(sql);
	}
private IRzhixiaoComponent rzhixiaoComponent;
	  
 	
 	public IRzhixiaoComponent getRzhixiaoComponent() {
		return rzhixiaoComponent;
	}
	public void setRzhixiaoComponent(IRzhixiaoComponent  rzhixiaoComponent) {
		this.rzhixiaoComponent = rzhixiaoComponent;
	}
	/**
	 * 创建 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rzhixiao createRzhixiao(Rzhixiao rzhixiao) throws SQLException{
	
		return rzhixiaoComponent.createRzhixiao(rzhixiao);
	}
	/**
	 * 删除 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRzhixiao(long id){
	
		return rzhixiaoComponent.deleteRzhixiao(id);
	}
	
	
	/**
	 * 修改 直销汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRzhixiao(Rzhixiao rzhixiao){
		return rzhixiaoComponent.updateRzhixiao(rzhixiao);
	
	}

		
	/**
	 * 修改 直销汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRzhixiaoIgnoreNull(Rzhixiao rzhixiao){
			return rzhixiaoComponent.updateRzhixiaoIgnoreNull(rzhixiao);
	
	}
	
	/**
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,int limit,int offset){
		return rzhixiaoComponent.findAllRzhixiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 直销汇总表
	 * @param id
	 * @return
	 */
	public Rzhixiao findRzhixiao(long id){
		return rzhixiaoComponent.findRzhixiao(id);
	}
	
	/** 
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRzhixiaoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rzhixiaoComponent.findAllRzhixiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找直销汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiaoBySql(String sql,int limit,int offset){
		return rzhixiaoComponent.findAllRzhixiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 直销汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRzhixiaoBySql(String sql){
		return rzhixiaoComponent.excuteRzhixiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRzhixiaoBySql(String sql){
		return rzhixiaoComponent.countRzhixiaoBySql(sql);
	}
private IRgroupcustomersComponent rgroupcustomersComponent;
	  
 	
 	public IRgroupcustomersComponent getRgroupcustomersComponent() {
		return rgroupcustomersComponent;
	}
	public void setRgroupcustomersComponent(IRgroupcustomersComponent  rgroupcustomersComponent) {
		this.rgroupcustomersComponent = rgroupcustomersComponent;
	}
	/**
	 * 创建 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public Rgroupcustomers createRgroupcustomers(Rgroupcustomers rgroupcustomers) throws SQLException{
	
		return rgroupcustomersComponent.createRgroupcustomers(rgroupcustomers);
	}
	/**
	 * 删除 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRgroupcustomers(long id){
	
		return rgroupcustomersComponent.deleteRgroupcustomers(id);
	}
	
	
	/**
	 * 修改 集团客户环比统计表
	 * @param id
	 * @return updated count 
	 */
	public int updateRgroupcustomers(Rgroupcustomers rgroupcustomers){
		return rgroupcustomersComponent.updateRgroupcustomers(rgroupcustomers);
	
	}

		
	/**
	 * 修改 集团客户环比统计表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRgroupcustomersIgnoreNull(Rgroupcustomers rgroupcustomers){
			return rgroupcustomersComponent.updateRgroupcustomersIgnoreNull(rgroupcustomers);
	
	}
	
	/**
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomers(String where, String orderby,int limit,int offset){
		return rgroupcustomersComponent.findAllRgroupcustomers(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 集团客户环比统计表
	 * @param id
	 * @return
	 */
	public Rgroupcustomers findRgroupcustomers(long id){
		return rgroupcustomersComponent.findRgroupcustomers(id);
	}
	
	/** 
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRgroupcustomersForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rgroupcustomersComponent.findAllRgroupcustomers(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找集团客户环比统计表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomersBySql(String sql,int limit,int offset){
		return rgroupcustomersComponent.findAllRgroupcustomers(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 集团客户环比统计表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRgroupcustomersBySql(String sql){
		return rgroupcustomersComponent.excuteRgroupcustomersBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRgroupcustomersBySql(String sql){
		return rgroupcustomersComponent.countRgroupcustomersBySql(sql);
	}
	
//
//粘贴到Service实现类
	
	private IFcountryComponent fcountryComponent;
	  
 	
 	public IFcountryComponent getFcountryComponent() {
		return fcountryComponent;
	}
	public void setFcountryComponent(IFcountryComponent  fcountryComponent) {
		this.fcountryComponent = fcountryComponent;
	}
	/**
	 * 创建 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public Fcountry createFcountry(Fcountry fcountry) throws SQLException{
	
		return fcountryComponent.createFcountry(fcountry);
	}
	/**
	 * 删除 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcountry(long id){
	
		return fcountryComponent.deleteFcountry(id);
	}
	
	
	/**
	 * 修改 国际机票国家
	 * @param id
	 * @return updated count 
	 */
	public int updateFcountry(Fcountry fcountry){
		return fcountryComponent.updateFcountry(fcountry);
	
	}

		
	/**
	 * 修改 国际机票国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFcountryIgnoreNull(Fcountry fcountry){
			return fcountryComponent.updateFcountryIgnoreNull(fcountry);
	
	}
	
	/**
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,int limit,int offset){
		return fcountryComponent.findAllFcountry(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票国家
	 * @param id
	 * @return
	 */
	public Fcountry findFcountry(long id){
		return fcountryComponent.findFcountry(id);
	}
	
	/**
	 * 查找 国际机票国家
	 * @param id
	 * @return
	 */
	public Fcountry findFcountrybylanguage(long id,Integer language){
		return fcountryComponent.findFcountrybylanguage(id,language);
	}
	/** 
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcountryForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fcountryComponent.findAllFcountry(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountryBySql(String sql,int limit,int offset){
		return fcountryComponent.findAllFcountry(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcountryBySql(String sql){
		return fcountryComponent.excuteFcountryBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcountryBySql(String sql){
		return fcountryComponent.countFcountryBySql(sql);
	}
	
	

	private IPassengerrepayrcComponent passengerrepayrcComponent;
	  
 	
 	public IPassengerrepayrcComponent getPassengerrepayrcComponent() {
		return passengerrepayrcComponent;
	}
	public void setPassengerrepayrcComponent(IPassengerrepayrcComponent  passengerrepayrcComponent) {
		this.passengerrepayrcComponent = passengerrepayrcComponent;
	}
	/**
	 * 创建 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public Passengerrepayrc createPassengerrepayrc(Passengerrepayrc passengerrepayrc) throws SQLException{
	
		return passengerrepayrcComponent.createPassengerrepayrc(passengerrepayrc);
	}
	/**
	 * 删除 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassengerrepayrc(long id){
	
		return passengerrepayrcComponent.deletePassengerrepayrc(id);
	}
	
	
	/**
	 * 修改 机票还款记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePassengerrepayrc(Passengerrepayrc passengerrepayrc){
		return passengerrepayrcComponent.updatePassengerrepayrc(passengerrepayrc);
	
	}

		
	/**
	 * 修改 机票还款记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerrepayrcIgnoreNull(Passengerrepayrc passengerrepayrc){
			return passengerrepayrcComponent.updatePassengerrepayrcIgnoreNull(passengerrepayrc);
	
	}
	
	/**
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,int limit,int offset){
		return passengerrepayrcComponent.findAllPassengerrepayrc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票还款记录
	 * @param id
	 * @return
	 */
	public Passengerrepayrc findPassengerrepayrc(long id){
		return passengerrepayrcComponent.findPassengerrepayrc(id);
	}
	
	/** 
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassengerrepayrcForPageinfo(String where, String orderby,PageInfo pageinfo){
		return passengerrepayrcComponent.findAllPassengerrepayrc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票还款记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrcBySql(String sql,int limit,int offset){
		return passengerrepayrcComponent.findAllPassengerrepayrc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票还款记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerrepayrcBySql(String sql){
		return passengerrepayrcComponent.excutePassengerrepayrcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerrepayrcBySql(String sql){
		return passengerrepayrcComponent.countPassengerrepayrcBySql(sql);
	}
	
	

	private ILowestpriceComponent lowestpriceComponent;
	  
 	
 	public ILowestpriceComponent getLowestpriceComponent() {
		return lowestpriceComponent;
	}
	public void setLowestpriceComponent(ILowestpriceComponent  lowestpriceComponent) {
		this.lowestpriceComponent = lowestpriceComponent;
	}
	/**
	 * 创建 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public Lowestprice createLowestprice(Lowestprice lowestprice) throws SQLException{
	
		return lowestpriceComponent.createLowestprice(lowestprice);
	}
	/**
	 * 删除 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLowestprice(long id){
	
		return lowestpriceComponent.deleteLowestprice(id);
	}
	
	
	/**
	 * 修改 机票低价数据表
	 * @param id
	 * @return updated count 
	 */
	public int updateLowestprice(Lowestprice lowestprice){
		return lowestpriceComponent.updateLowestprice(lowestprice);
	
	}

		
	/**
	 * 修改 机票低价数据表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLowestpriceIgnoreNull(Lowestprice lowestprice){
			return lowestpriceComponent.updateLowestpriceIgnoreNull(lowestprice);
	
	}
	
	/**
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestprice(String where, String orderby,int limit,int offset){
		return lowestpriceComponent.findAllLowestprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票低价数据表
	 * @param id
	 * @return
	 */
	public Lowestprice findLowestprice(long id){
		return lowestpriceComponent.findLowestprice(id);
	}
	
	/** 
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLowestpriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return lowestpriceComponent.findAllLowestprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票低价数据表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestpriceBySql(String sql,int limit,int offset){
		return lowestpriceComponent.findAllLowestprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票低价数据表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLowestpriceBySql(String sql){
		return lowestpriceComponent.excuteLowestpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLowestpriceBySql(String sql){
		return lowestpriceComponent.countLowestpriceBySql(sql);
	}
	
	


//
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITicketappComponent ticketappComponent;
	  
 	
 	public ITicketappComponent getTicketappComponent() {
		return ticketappComponent;
	}
	public void setTicketappComponent(ITicketappComponent  ticketappComponent) {
		this.ticketappComponent = ticketappComponent;
	}
	/**
	 * 创建 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Ticketapp createTicketapp(Ticketapp ticketapp) throws SQLException{
	
		return ticketappComponent.createTicketapp(ticketapp);
	}
	/**
	 * 删除 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketapp(long id){
	
		return ticketappComponent.deleteTicketapp(id);
	}
	
	
	/**
	 * 修改 特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketapp(Ticketapp ticketapp){
		return ticketappComponent.updateTicketapp(ticketapp);
	
	}

		
	/**
	 * 修改 特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketappIgnoreNull(Ticketapp ticketapp){
			return ticketappComponent.updateTicketappIgnoreNull(ticketapp);
	
	}
	
	/**
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,int limit,int offset){
		return ticketappComponent.findAllTicketapp(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价申请表
	 * @param id
	 * @return
	 */
	public Ticketapp findTicketapp(long id){
		return ticketappComponent.findTicketapp(id);
	}
	
	/** 
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketappForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ticketappComponent.findAllTicketapp(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketappBySql(String sql,int limit,int offset){
		return ticketappComponent.findAllTicketapp(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketappBySql(String sql){
		return ticketappComponent.excuteTicketappBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketappBySql(String sql){
		return ticketappComponent.countTicketappBySql(sql);
	}
	
	




	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICharterorderComponent charterorderComponent;
	  
 	
 	public ICharterorderComponent getCharterorderComponent() {
		return charterorderComponent;
	}
	public void setCharterorderComponent(ICharterorderComponent  charterorderComponent) {
		this.charterorderComponent = charterorderComponent;
	}
	/**
	 * 创建 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public Charterorder createCharterorder(Charterorder charterorder) throws SQLException{
	
		return charterorderComponent.createCharterorder(charterorder);
	}
	/**
	 * 删除 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCharterorder(long id){
	
		return charterorderComponent.deleteCharterorder(id);
	}
	
	
	/**
	 * 修改 包机订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCharterorder(Charterorder charterorder){
		return charterorderComponent.updateCharterorder(charterorder);
	
	}

		
	/**
	 * 修改 包机订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCharterorderIgnoreNull(Charterorder charterorder){
			return charterorderComponent.updateCharterorderIgnoreNull(charterorder);
	
	}
	
	/**
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorder(String where, String orderby,int limit,int offset){
		return charterorderComponent.findAllCharterorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 包机订单
	 * @param id
	 * @return
	 */
	public Charterorder findCharterorder(long id){
		return charterorderComponent.findCharterorder(id);
	}
	
	/** 
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCharterorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return charterorderComponent.findAllCharterorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找包机订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorderBySql(String sql,int limit,int offset){
		return charterorderComponent.findAllCharterorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 包机订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCharterorderBySql(String sql){
		return charterorderComponent.excuteCharterorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCharterorderBySql(String sql){
		return charterorderComponent.countCharterorderBySql(sql);
	}
	
	

	
///////////////////////////////////////////////
	//保险公司表实现方法--------赵晓晓
private IInsurcomputerComponent insurcomputerComponent;
	  
 	
 	public IInsurcomputerComponent getInsurcomputerComponent() {
		return insurcomputerComponent;
	}
	public void setInsurcomputerComponent(IInsurcomputerComponent  insurcomputerComponent) {
		this.insurcomputerComponent = insurcomputerComponent;
	}
	/**
	 * 创建 保险服务公司信息表
	 * @param id
	 * @return deleted count 
	 */
	public Insurcomputer createInsurcomputer(Insurcomputer insurcomputer) throws SQLException{
	
		return insurcomputerComponent.createInsurcomputer(insurcomputer);
	}
	/**
	 * 删除 保险服务公司信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurcomputer(long id){
	
		return insurcomputerComponent.deleteInsurcomputer(id);
	}
	
	
	/**
	 * 修改 保险服务公司信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurcomputer(Insurcomputer insurcomputer){
		return insurcomputerComponent.updateInsurcomputer(insurcomputer);
	
	}

		
	/**
	 * 修改 保险服务公司信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurcomputerIgnoreNull(Insurcomputer insurcomputer){
			return insurcomputerComponent.updateInsurcomputerIgnoreNull(insurcomputer);
	
	}
	
	/**
	 * 查找 保险服务公司信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputer(String where, String orderby,int limit,int offset){
		return insurcomputerComponent.findAllInsurcomputer(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 保险服务公司信息表
	 * @param id
	 * @return
	 */
	public Insurcomputer findInsurcomputer(long id){
		return insurcomputerComponent.findInsurcomputer(id);
	}
	
	/** 
	 * 查找 保险服务公司信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurcomputerForPageinfo(String where, String orderby,PageInfo pageinfo){
		return insurcomputerComponent.findAllInsurcomputer(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找保险服务公司信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputerBySql(String sql,int limit,int offset){
		return insurcomputerComponent.findAllInsurcomputer(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 保险服务公司信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurcomputerBySql(String sql){
		return insurcomputerComponent.excuteInsurcomputerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurcomputerBySql(String sql){
		return insurcomputerComponent.countInsurcomputerBySql(sql);
	}
	
////////////////////////////////////////////////////////////
	//保险订单
private IInsurorderComponent insurorderComponent;
	  
 	
 	public IInsurorderComponent getInsurorderComponent() {
		return insurorderComponent;
	}
	public void setInsurorderComponent(IInsurorderComponent  insurorderComponent) {
		this.insurorderComponent = insurorderComponent;
	}
	/**
	 * 创建 订单表
	 * @param id
	 * @return deleted count 
	 */
	public Insurorder createInsurorder(Insurorder insurorder) throws SQLException{
	
		return insurorderComponent.createInsurorder(insurorder);
	}
	/**
	 * 删除 订单表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurorder(long id){
	
		return insurorderComponent.deleteInsurorder(id);
	}
	
	
	/**
	 * 修改 订单表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurorder(Insurorder insurorder){
		return insurorderComponent.updateInsurorder(insurorder);
	
	}

		
	/**
	 * 修改 订单表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurorderIgnoreNull(Insurorder insurorder){
			return insurorderComponent.updateInsurorderIgnoreNull(insurorder);
	
	}
	
	/**
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorder(String where, String orderby,int limit,int offset){
		return insurorderComponent.findAllInsurorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 订单表
	 * @param id
	 * @return
	 */
	public Insurorder findInsurorder(long id){
		return insurorderComponent.findInsurorder(id);
	}
	
	/** 
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return insurorderComponent.findAllInsurorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找订单表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorderBySql(String sql,int limit,int offset){
		return insurorderComponent.findAllInsurorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 订单表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurorderBySql(String sql){
		return insurorderComponent.excuteInsurorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurorderBySql(String sql){
		return insurorderComponent.countInsurorderBySql(sql);
	}
	
	

	
	//////////////////////////////////////////////////////////
	//被保人接口实现类
private IInsuruserComponent insuruserComponent;
	  
 	
 	public IInsuruserComponent getInsuruserComponent() {
		return insuruserComponent;
	}
	public void setInsuruserComponent(IInsuruserComponent  insuruserComponent) {
		this.insuruserComponent = insuruserComponent;
	}
	/**
	 * 创建 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public Insuruser createInsuruser(Insuruser insuruser) throws SQLException{
	
		return insuruserComponent.createInsuruser(insuruser);
	}
	/**
	 * 删除 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuruser(long id){
	
		return insuruserComponent.deleteInsuruser(id);
	}
	
	
	/**
	 * 修改 被保人列表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuruser(Insuruser insuruser){
		return insuruserComponent.updateInsuruser(insuruser);
	
	}

		
	/**
	 * 修改 被保人列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuruserIgnoreNull(Insuruser insuruser){
			return insuruserComponent.updateInsuruserIgnoreNull(insuruser);
	
	}
	
	/**
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruser(String where, String orderby,int limit,int offset){
		return insuruserComponent.findAllInsuruser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 被保人列表
	 * @param id
	 * @return
	 */
	public Insuruser findInsuruser(long id){
		return insuruserComponent.findInsuruser(id);
	}
	
	/** 
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuruserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return insuruserComponent.findAllInsuruser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找被保人列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruserBySql(String sql,int limit,int offset){
		return insuruserComponent.findAllInsuruser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 被保人列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuruserBySql(String sql){
		return insuruserComponent.excuteInsuruserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuruserBySql(String sql){
		return insuruserComponent.countInsuruserBySql(sql);
	}

//
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ILimitcabinComponent limitcabinComponent;
	  
 	
 	public ILimitcabinComponent getLimitcabinComponent() {
		return limitcabinComponent;
	}
	public void setLimitcabinComponent(ILimitcabinComponent  limitcabinComponent) {
		this.limitcabinComponent = limitcabinComponent;
	}
	/**
	 * 创建 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public Limitcabin createLimitcabin(Limitcabin limitcabin) throws SQLException{
	
		return limitcabinComponent.createLimitcabin(limitcabin);
	}
	/**
	 * 删除 限制仓位
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLimitcabin(long id){
	
		return limitcabinComponent.deleteLimitcabin(id);
	}
	
	
	/**
	 * 修改 限制仓位
	 * @param id
	 * @return updated count 
	 */
	public int updateLimitcabin(Limitcabin limitcabin){
		return limitcabinComponent.updateLimitcabin(limitcabin);
	
	}

		
	/**
	 * 修改 限制仓位但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLimitcabinIgnoreNull(Limitcabin limitcabin){
			return limitcabinComponent.updateLimitcabinIgnoreNull(limitcabin);
	
	}
	
	/**
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabin(String where, String orderby,int limit,int offset){
		return limitcabinComponent.findAllLimitcabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 限制仓位
	 * @param id
	 * @return
	 */
	public Limitcabin findLimitcabin(long id){
		return limitcabinComponent.findLimitcabin(id);
	}
	
	/** 
	 * 查找 限制仓位
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLimitcabinForPageinfo(String where, String orderby,PageInfo pageinfo){
		return limitcabinComponent.findAllLimitcabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找限制仓位
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLimitcabinBySql(String sql,int limit,int offset){
		return limitcabinComponent.findAllLimitcabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 限制仓位
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLimitcabinBySql(String sql){
		return limitcabinComponent.excuteLimitcabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLimitcabinBySql(String sql){
		return limitcabinComponent.countLimitcabinBySql(sql);
	}
	

	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IChangpassComponent changpassComponent;
	  
 	
 	public IChangpassComponent getChangpassComponent() {
		return changpassComponent;
	}
	public void setChangpassComponent(IChangpassComponent  changpassComponent) {
		this.changpassComponent = changpassComponent;
	}
	/**
	 * 创建 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public Changpass createChangpass(Changpass changpass) throws SQLException{
	
		return changpassComponent.createChangpass(changpass);
	}
	/**
	 * 删除 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChangpass(long id){
	
		return changpassComponent.deleteChangpass(id);
	}
	
	
	/**
	 * 修改 变更记录
	 * @param id
	 * @return updated count 
	 */
	public int updateChangpass(Changpass changpass){
		return changpassComponent.updateChangpass(changpass);
	
	}

		
	/**
	 * 修改 变更记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChangpassIgnoreNull(Changpass changpass){
			return changpassComponent.updateChangpassIgnoreNull(changpass);
	
	}
	
	/**
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,int limit,int offset){
		return changpassComponent.findAllChangpass(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 变更记录
	 * @param id
	 * @return
	 */
	public Changpass findChangpass(long id){
		return changpassComponent.findChangpass(id);
	}
	
	/** 
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChangpassForPageinfo(String where, String orderby,PageInfo pageinfo){
		return changpassComponent.findAllChangpass(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找变更记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpassBySql(String sql,int limit,int offset){
		return changpassComponent.findAllChangpass(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 变更记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChangpassBySql(String sql){
		return changpassComponent.excuteChangpassBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChangpassBySql(String sql){
		return changpassComponent.countChangpassBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IXcdorderComponent xcdorderComponent;
	  
 	
 	public IXcdorderComponent getXcdorderComponent() {
		return xcdorderComponent;
	}
	public void setXcdorderComponent(IXcdorderComponent  xcdorderComponent) {
		this.xcdorderComponent = xcdorderComponent;
	}
	/**
	 * 创建 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdorder createXcdorder(Xcdorder xcdorder) throws SQLException{
	
		return xcdorderComponent.createXcdorder(xcdorder);
	}
	/**
	 * 删除 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdorder(long id){
	
		return xcdorderComponent.deleteXcdorder(id);
	}
	
	
	/**
	 * 修改 行程单订单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdorder(Xcdorder xcdorder){
		return xcdorderComponent.updateXcdorder(xcdorder);
	
	}

		
	/**
	 * 修改 行程单订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdorderIgnoreNull(Xcdorder xcdorder){
			return xcdorderComponent.updateXcdorderIgnoreNull(xcdorder);
	
	}
	
	/**
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,int limit,int offset){
		return xcdorderComponent.findAllXcdorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单订单
	 * @param id
	 * @return
	 */
	public Xcdorder findXcdorder(long id){
		return xcdorderComponent.findXcdorder(id);
	}
	
	/** 
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return xcdorderComponent.findAllXcdorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorderBySql(String sql,int limit,int offset){
		return xcdorderComponent.findAllXcdorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdorderBySql(String sql){
		return xcdorderComponent.excuteXcdorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdorderBySql(String sql){
		return xcdorderComponent.countXcdorderBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IXcdnoinfoComponent xcdnoinfoComponent;
	  
 	
 	public IXcdnoinfoComponent getXcdnoinfoComponent() {
		return xcdnoinfoComponent;
	}
	public void setXcdnoinfoComponent(IXcdnoinfoComponent  xcdnoinfoComponent) {
		this.xcdnoinfoComponent = xcdnoinfoComponent;
	}
	/**
	 * 创建 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public Xcdnoinfo createXcdnoinfo(Xcdnoinfo xcdnoinfo) throws SQLException{
	
		return xcdnoinfoComponent.createXcdnoinfo(xcdnoinfo);
	}
	/**
	 * 删除 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdnoinfo(long id){
	
		return xcdnoinfoComponent.deleteXcdnoinfo(id);
	}
	
	
	/**
	 * 修改 行程单号码
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdnoinfo(Xcdnoinfo xcdnoinfo){
		return xcdnoinfoComponent.updateXcdnoinfo(xcdnoinfo);
	
	}

		
	/**
	 * 修改 行程单号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoinfoIgnoreNull(Xcdnoinfo xcdnoinfo){
			return xcdnoinfoComponent.updateXcdnoinfoIgnoreNull(xcdnoinfo);
	
	}
	
	/**
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfo(String where, String orderby,int limit,int offset){
		return xcdnoinfoComponent.findAllXcdnoinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单号码
	 * @param id
	 * @return
	 */
	public Xcdnoinfo findXcdnoinfo(long id){
		return xcdnoinfoComponent.findXcdnoinfo(id);
	}
	
	/** 
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdnoinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return xcdnoinfoComponent.findAllXcdnoinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfoBySql(String sql,int limit,int offset){
		return xcdnoinfoComponent.findAllXcdnoinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoinfoBySql(String sql){
		return xcdnoinfoComponent.excuteXcdnoinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoinfoBySql(String sql){
		return xcdnoinfoComponent.countXcdnoinfoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IXcdnoComponent xcdnoComponent;
	  
 	
 	public IXcdnoComponent getXcdnoComponent() {
		return xcdnoComponent;
	}
	public void setXcdnoComponent(IXcdnoComponent  xcdnoComponent) {
		this.xcdnoComponent = xcdnoComponent;
	}
	/**
	 * 创建 行程单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdno createXcdno(Xcdno xcdno) throws SQLException{
	
		return xcdnoComponent.createXcdno(xcdno);
	}
	/**
	 * 删除 行程单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdno(long id){
	
		return xcdnoComponent.deleteXcdno(id);
	}
	
	
	/**
	 * 修改 行程单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdno(Xcdno xcdno){
		return xcdnoComponent.updateXcdno(xcdno);
	
	}

		
	/**
	 * 修改 行程单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoIgnoreNull(Xcdno xcdno){
			return xcdnoComponent.updateXcdnoIgnoreNull(xcdno);
	
	}
	
	/**
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdno(String where, String orderby,int limit,int offset){
		return xcdnoComponent.findAllXcdno(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单
	 * @param id
	 * @return
	 */
	public Xcdno findXcdno(long id){
		return xcdnoComponent.findXcdno(id);
	}
	
	/** 
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdnoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return xcdnoComponent.findAllXcdno(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoBySql(String sql,int limit,int offset){
		return xcdnoComponent.findAllXcdno(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoBySql(String sql){
		return xcdnoComponent.excuteXcdnoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoBySql(String sql){
		return xcdnoComponent.countXcdnoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IPeisongComponent peisongComponent;
	  
 	
 	public IPeisongComponent getPeisongComponent() {
		return peisongComponent;
	}
	public void setPeisongComponent(IPeisongComponent  peisongComponent) {
		this.peisongComponent = peisongComponent;
	}
	/**
	 * 创建 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public Peisong createPeisong(Peisong peisong) throws SQLException{
	
		return peisongComponent.createPeisong(peisong);
	}
	/**
	 * 删除 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePeisong(long id){
	
		return peisongComponent.deletePeisong(id);
	}
	
	
	/**
	 * 修改 行程单配送记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePeisong(Peisong peisong){
		return peisongComponent.updatePeisong(peisong);
	
	}

		
	/**
	 * 修改 行程单配送记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePeisongIgnoreNull(Peisong peisong){
			return peisongComponent.updatePeisongIgnoreNull(peisong);
	
	}
	
	/**
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,int limit,int offset){
		return peisongComponent.findAllPeisong(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程单配送记录
	 * @param id
	 * @return
	 */
	public Peisong findPeisong(long id){
		return peisongComponent.findPeisong(id);
	}
	
	/** 
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPeisongForPageinfo(String where, String orderby,PageInfo pageinfo){
		return peisongComponent.findAllPeisong(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程单配送记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisongBySql(String sql,int limit,int offset){
		return peisongComponent.findAllPeisong(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程单配送记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePeisongBySql(String sql){
		return peisongComponent.excutePeisongBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPeisongBySql(String sql){
		return peisongComponent.countPeisongBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IZhefanComponent zhefanComponent;
	  
 	
 	public IZhefanComponent getZhefanComponent() {
		return zhefanComponent;
	}
	public void setZhefanComponent(IZhefanComponent  zhefanComponent) {
		this.zhefanComponent = zhefanComponent;
	}
	/**
	 * 创建 折返
	 * @param id
	 * @return deleted count 
	 */
	public Zhefan createZhefan(Zhefan zhefan) throws SQLException{
	
		return zhefanComponent.createZhefan(zhefan);
	}
	/**
	 * 删除 折返
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZhefan(long id){
	
		return zhefanComponent.deleteZhefan(id);
	}
	
	
	/**
	 * 修改 折返
	 * @param id
	 * @return updated count 
	 */
	public int updateZhefan(Zhefan zhefan){
		return zhefanComponent.updateZhefan(zhefan);
	
	}

		
	/**
	 * 修改 折返但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZhefanIgnoreNull(Zhefan zhefan){
			return zhefanComponent.updateZhefanIgnoreNull(zhefan);
	
	}
	
	/**
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefan(String where, String orderby,int limit,int offset){
		return zhefanComponent.findAllZhefan(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 折返
	 * @param id
	 * @return
	 */
	public Zhefan findZhefan(long id){
		return zhefanComponent.findZhefan(id);
	}
	
	/** 
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZhefanForPageinfo(String where, String orderby,PageInfo pageinfo){
		return zhefanComponent.findAllZhefan(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找折返
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefanBySql(String sql,int limit,int offset){
		return zhefanComponent.findAllZhefan(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 折返
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZhefanBySql(String sql){
		return zhefanComponent.excuteZhefanBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZhefanBySql(String sql){
		return zhefanComponent.countZhefanBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private INfdpriceComponent nfdpriceComponent;
	  
 	
 	public INfdpriceComponent getNfdpriceComponent() {
		return nfdpriceComponent;
	}
	public void setNfdpriceComponent(INfdpriceComponent  nfdpriceComponent) {
		this.nfdpriceComponent = nfdpriceComponent;
	}
	/**
	 * 创建 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public Nfdprice createNfdprice(Nfdprice nfdprice) throws SQLException{
	
		return nfdpriceComponent.createNfdprice(nfdprice);
	}
	/**
	 * 删除 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNfdprice(long id){
	
		return nfdpriceComponent.deleteNfdprice(id);
	}
	
	
	/**
	 * 修改 NFD价格
	 * @param id
	 * @return updated count 
	 */
	public int updateNfdprice(Nfdprice nfdprice){
		return nfdpriceComponent.updateNfdprice(nfdprice);
	
	}

		
	/**
	 * 修改 NFD价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNfdpriceIgnoreNull(Nfdprice nfdprice){
			return nfdpriceComponent.updateNfdpriceIgnoreNull(nfdprice);
	
	}
	
	/**
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdprice(String where, String orderby,int limit,int offset){
		return nfdpriceComponent.findAllNfdprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 NFD价格
	 * @param id
	 * @return
	 */
	public Nfdprice findNfdprice(long id){
		return nfdpriceComponent.findNfdprice(id);
	}
	
	/** 
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNfdpriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return nfdpriceComponent.findAllNfdprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找NFD价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdpriceBySql(String sql,int limit,int offset){
		return nfdpriceComponent.findAllNfdprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql NFD价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNfdpriceBySql(String sql){
		return nfdpriceComponent.excuteNfdpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNfdpriceBySql(String sql){
		return nfdpriceComponent.countNfdpriceBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IAirlienComponent airlienComponent;
	  
 	
 	public IAirlienComponent getAirlienComponent() {
		return airlienComponent;
	}
	public void setAirlienComponent(IAirlienComponent  airlienComponent) {
		this.airlienComponent = airlienComponent;
	}
	/**
	 * 创建 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public Airlien createAirlien(Airlien airlien) throws SQLException{
	
		return airlienComponent.createAirlien(airlien);
	}
	/**
	 * 删除 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirlien(long id){
	
		return airlienComponent.deleteAirlien(id);
	}
	
	
	/**
	 * 修改 航线信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirlien(Airlien airlien){
		return airlienComponent.updateAirlien(airlien);
	
	}

		
	/**
	 * 修改 航线信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirlienIgnoreNull(Airlien airlien){
			return airlienComponent.updateAirlienIgnoreNull(airlien);
	
	}
	
	/**
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlien(String where, String orderby,int limit,int offset){
		return airlienComponent.findAllAirlien(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航线信息
	 * @param id
	 * @return
	 */
	public Airlien findAirlien(long id){
		return airlienComponent.findAirlien(id);
	}
	
	/** 
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirlienForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airlienComponent.findAllAirlien(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航线信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlienBySql(String sql,int limit,int offset){
		return airlienComponent.findAllAirlien(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航线信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirlienBySql(String sql){
		return airlienComponent.excuteAirlienBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirlienBySql(String sql){
		return airlienComponent.countAirlienBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IAirliencabinComponent airliencabinComponent;
	  
 	
 	public IAirliencabinComponent getAirliencabinComponent() {
		return airliencabinComponent;
	}
	public void setAirliencabinComponent(IAirliencabinComponent  airliencabinComponent) {
		this.airliencabinComponent = airliencabinComponent;
	}
	/**
	 * 创建 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public Airliencabin createAirliencabin(Airliencabin airliencabin) throws SQLException{
	
		return airliencabinComponent.createAirliencabin(airliencabin);
	}
	/**
	 * 删除 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirliencabin(long id){
	
		return airliencabinComponent.deleteAirliencabin(id);
	}
	
	
	/**
	 * 修改 航线仓位信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirliencabin(Airliencabin airliencabin){
		return airliencabinComponent.updateAirliencabin(airliencabin);
	
	}

		
	/**
	 * 修改 航线仓位信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirliencabinIgnoreNull(Airliencabin airliencabin){
			return airliencabinComponent.updateAirliencabinIgnoreNull(airliencabin);
	
	}
	
	/**
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,int limit,int offset){
		return airliencabinComponent.findAllAirliencabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航线仓位信息
	 * @param id
	 * @return
	 */
	public Airliencabin findAirliencabin(long id){
		return airliencabinComponent.findAirliencabin(id);
	}
	
	/** 
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirliencabinForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airliencabinComponent.findAllAirliencabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航线仓位信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabinBySql(String sql,int limit,int offset){
		return airliencabinComponent.findAllAirliencabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航线仓位信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirliencabinBySql(String sql){
		return airliencabinComponent.excuteAirliencabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirliencabinBySql(String sql){
		return airliencabinComponent.countAirliencabinBySql(sql);
	}
	
	



}
