package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.airbaseprice.Airbaseprice;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.airfee.Airfee;
import com.yf.system.base.airflight.Airflight;
import com.yf.system.base.airlien.Airlien;
import com.yf.system.base.airliencabin.Airliencabin;
import com.yf.system.base.backpoint.Backpoint;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.changpass.Changpass;
import com.yf.system.base.charterorder.Charterorder;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.cpzrate.Cpzrate;
import com.yf.system.base.customeraircard.Customeraircard;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.system.base.flightstop.Flightstop;
import com.yf.system.base.insurcomputer.Insurcomputer;
import com.yf.system.base.insurorder.Insurorder;
import com.yf.system.base.insuruser.Insuruser;
import com.yf.system.base.jinribaobiao.Jinribaobiao;
import com.yf.system.base.kweifabu.Kweifabu;
import com.yf.system.base.kweisq.Kweisq;
import com.yf.system.base.limitcabin.Limitcabin;
import com.yf.system.base.lowestprice.Lowestprice;
import com.yf.system.base.nfdprice.Nfdprice;
import com.yf.system.base.noterecorder.Noterecorder;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.passengerrepayrc.Passengerrepayrc;
import com.yf.system.base.paymentrecorder.Paymentrecorder;
import com.yf.system.base.peisong.Peisong;
import com.yf.system.base.perworkload.Perworkload;
import com.yf.system.base.policyperiod.Policyperiod;
import com.yf.system.base.rdepartment.Rdepartment;
import com.yf.system.base.rgroupcustomers.Rgroupcustomers;
import com.yf.system.base.rperformance.Rperformance;
import com.yf.system.base.rsector.Rsector;
import com.yf.system.base.rzhixiao.Rzhixiao;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.sellreport.Sellreport;
import com.yf.system.base.specialprice.Specialprice;
import com.yf.system.base.spzrate.Spzrate;
import com.yf.system.base.supteam.Supteam;
import com.yf.system.base.sysmessage.Sysmessage;
import com.yf.system.base.teamapply.Teamapply;
import com.yf.system.base.template.Template;
import com.yf.system.base.ticketapp.Ticketapp;
import com.yf.system.base.tuipiao.Tuipiao;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.xcdno.Xcdno;
import com.yf.system.base.xcdnoinfo.Xcdnoinfo;
import com.yf.system.base.xcdorder.Xcdorder;
import com.yf.system.base.zhefan.Zhefan;
import com.yf.system.base.zrate.Zrate;

public interface IAirService  {
	
	
	public boolean isCache() ;
	
	public void setCache(boolean cache) ;
	/**
	 * 添加 
	 * @param key
	 * @param value
	 */
	public void setToCache(String key,Object value);
	
	/**
	 * 获取
	 * @param key
	 */
	public Object getFromCache(String key);
	
	/**
	 * 移除
	 * @param key
	 */
	public void removeFromCache(String key);
	  
	 	/**
		 * 创建 机场城市
		 * @param id
		 * @return deleted count 
		 */
		public Cityairport createCityairport(Cityairport cityairport) throws SQLException;
		
		/**
		 * 删除 机场城市
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCityairport(long id);
		
		
		/**
		 * 修改 机场城市
		 * @param id
		 * @return updated count 
		 */
		public int updateCityairport(Cityairport cityairport);

			
		/**
		 * 修改 机场城市但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCityairportIgnoreNull(Cityairport cityairport);
			
		
		/**
		 * 查找 机场城市
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCityairport(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 机场城市
		 * @param id
		 * @return
		 */
		public Cityairport findCityairport(long id);
		
		
		/** 
		 * 查找 机场城市
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCityairportForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找机场城市
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCityairportBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 机场城市
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCityairportBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCityairportBySql(String sql);
		///////////////////////
		/**
		 * 创建 模板
		 * @param id
		 * @return deleted count 
		 */
		public Template createTemplate(Template template) throws SQLException;
		
		/**
		 * 删除 模板
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTemplate(long id);
		
		
		/**
		 * 修改 模板
		 * @param id
		 * @return updated count 
		 */
		public int updateTemplate(Template template);

			
		/**
		 * 修改 模板但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTemplateIgnoreNull(Template template);
			
		
		/**
		 * 查找 模板
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTemplate(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 模板
		 * @param id
		 * @return
		 */
		public Template findTemplate(long id);
		
		
		/** 
		 * 查找 模板
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTemplateForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找模板
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTemplateBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 模板
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTemplateBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTemplateBySql(String sql);
		///////////////////
		/**
		 * 创建 普通政策表
		 * @param id
		 * @return deleted count 
		 */
		public Zrate createZrate(Zrate zrate) throws SQLException;
		
		/**
		 * 删除 普通政策表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteZrate(long id);
		
		
		/**
		 * 修改 普通政策表
		 * @param id
		 * @return updated count 
		 */
		public int updateZrate(Zrate zrate);

			
		/**
		 * 修改 普通政策表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateZrateIgnoreNull(Zrate zrate);
			
		
		/**
		 * 查找 普通政策表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllZrate(String where, String orderby,int limit,int offset);
		
		public List findAllZrateBySP(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo );
			
		
		/**
		 * 查找 普通政策表
		 * @param id
		 * @return
		 */
		public Zrate findZrate(long id);
		
		/**
		 * 查找 普通政策表-数据库
		 * @param id
		 * @return
		 */
		public Zrate findZrateByDB(long id);
		/** 
		 * 查找 普通政策表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllZrateForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找普通政策表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllZrateBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 普通政策表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteZrateBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countZrateBySql(String sql);
		/////////////////////////////
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
		///////////////////
		/**
		 * 创建 特价政策表
		 * @param id
		 * @return deleted count 
		 */
		public Spzrate createSpzrate(Spzrate spzrate) throws SQLException;
		
		/**
		 * 删除 特价政策表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSpzrate(long id);
		
		
		/**
		 * 修改 特价政策表
		 * @param id
		 * @return updated count 
		 */
		public int updateSpzrate(Spzrate spzrate);

			
		/**
		 * 修改 特价政策表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSpzrateIgnoreNull(Spzrate spzrate);
			
		
		/**
		 * 查找 特价政策表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSpzrate(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 特价政策表
		 * @param id
		 * @return
		 */
		public Spzrate findSpzrate(long id);
		
		
		/** 
		 * 查找 特价政策表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSpzrateForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找特价政策表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSpzrateBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 特价政策表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSpzrateBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSpzrateBySql(String sql);
		////////////////////
		/**
		 * 创建 行程表
		 * @param id
		 * @return deleted count 
		 */
		public Segmentinfo createSegmentinfo(Segmentinfo segmentinfo) throws SQLException;
		
		/**
		 * 删除 行程表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSegmentinfo(long id);
		
		
		/**
		 * 修改 行程表
		 * @param id
		 * @return updated count 
		 */
		public int updateSegmentinfo(Segmentinfo segmentinfo);

			
		/**
		 * 修改 行程表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSegmentinfoIgnoreNull(Segmentinfo segmentinfo);
			
		
		/**
		 * 查找 行程表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSegmentinfo(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 行程表
		 * @param id
		 * @return
		 */
		public Segmentinfo findSegmentinfo(long id);
		
		
		/** 
		 * 查找 行程表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSegmentinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找行程表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSegmentinfoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 行程表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSegmentinfoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSegmentinfoBySql(String sql);
		/////////////////////////////
		/**
		 * 创建 政策有效期表
		 * @param id
		 * @return deleted count 
		 */
		public Policyperiod createPolicyperiod(Policyperiod policyperiod) throws SQLException;
		
		/**
		 * 删除 政策有效期表
		 * @param id
		 * @return deleted count 
		 */
		public int deletePolicyperiod(long id);
		
		
		/**
		 * 修改 政策有效期表
		 * @param id
		 * @return updated count 
		 */
		public int updatePolicyperiod(Policyperiod policyperiod);

			
		/**
		 * 修改 政策有效期表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updatePolicyperiodIgnoreNull(Policyperiod policyperiod);
			
		
		/**
		 * 查找 政策有效期表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPolicyperiod(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 政策有效期表
		 * @param id
		 * @return
		 */
		public Policyperiod findPolicyperiod(long id);
		
		
		/** 
		 * 查找 政策有效期表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllPolicyperiodForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找政策有效期表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPolicyperiodBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 政策有效期表
		 * @param sql 
		 * @return updated count 
		 */
		public int excutePolicyperiodBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countPolicyperiodBySql(String sql);
		//////////////////////////
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
		/////////////////////////
		/**
		 * 创建 乘机人表
		 * @param id
		 * @return deleted count 
		 */
		public Passenger createPassenger(Passenger passenger) throws SQLException;
		
		/**
		 * 删除 乘机人表
		 * @param id
		 * @return deleted count 
		 */
		public int deletePassenger(long id);
		
		
		/**
		 * 修改 乘机人表
		 * @param id
		 * @return updated count 
		 */
		public int updatePassenger(Passenger passenger);

			
		/**
		 * 修改 乘机人表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updatePassengerIgnoreNull(Passenger passenger);
			
		
		/**
		 * 查找 乘机人表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPassenger(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 乘机人表
		 * @param id
		 * @return
		 */
		public Passenger findPassenger(long id);
		
		
		/** 
		 * 查找 乘机人表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllPassengerForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找乘机人表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPassengerBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 乘机人表
		 * @param sql 
		 * @return updated count 
		 */
		public int excutePassengerBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countPassengerBySql(String sql);
		////////////////
		/**
		 * 创建 订单处理记录
		 * @param id
		 * @return deleted count 
		 */
		public Orderinforc createOrderinforc(Orderinforc orderinforc) throws SQLException;
		
		/**
		 * 删除 订单处理记录
		 * @param id
		 * @return deleted count 
		 */
		public int deleteOrderinforc(long id);
		
		
		/**
		 * 修改 订单处理记录
		 * @param id
		 * @return updated count 
		 */
		public int updateOrderinforc(Orderinforc orderinforc);

			
		/**
		 * 修改 订单处理记录但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateOrderinforcIgnoreNull(Orderinforc orderinforc);
			
		
		/**
		 * 查找 订单处理记录
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllOrderinforc(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 订单处理记录
		 * @param id
		 * @return
		 */
		public Orderinforc findOrderinforc(long id);
		
		
		/** 
		 * 查找 订单处理记录
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllOrderinforcForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找订单处理记录
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllOrderinforcBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 订单处理记录
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteOrderinforcBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countOrderinforcBySql(String sql);
		/////////////
		/**
		 * 创建 订单信息表
		 * @param id
		 * @return deleted count 
		 */
		public Orderinfo createOrderinfo(Orderinfo orderinfo) throws SQLException;
		
		/**
		 * 删除 订单信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteOrderinfo(long id);
		
		
		/**
		 * 修改 订单信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateOrderinfo(Orderinfo orderinfo);

			
		/**
		 * 修改 订单信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateOrderinfoIgnoreNull(Orderinfo orderinfo);
			
		
		/**
		 * 查找 订单信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllOrderinfo(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 订单信息表
		 * @param id
		 * @return
		 */
		public Orderinfo findOrderinfo(long id);
		
		
		/** 
		 * 查找 订单信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllOrderinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找订单信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllOrderinfoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 订单信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteOrderinfoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countOrderinfoBySql(String sql);
		///////////////
		/**
		 * 创建 通知记录
		 * @param id
		 * @return deleted count 
		 */
		public Noterecorder createNoterecorder(Noterecorder noterecorder) throws SQLException;
		
		/**
		 * 删除 通知记录
		 * @param id
		 * @return deleted count 
		 */
		public int deleteNoterecorder(long id);
		
		
		/**
		 * 修改 通知记录
		 * @param id
		 * @return updated count 
		 */
		public int updateNoterecorder(Noterecorder noterecorder);

			
		/**
		 * 修改 通知记录但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateNoterecorderIgnoreNull(Noterecorder noterecorder);
			
		
		/**
		 * 查找 通知记录
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllNoterecorder(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 通知记录
		 * @param id
		 * @return
		 */
		public Noterecorder findNoterecorder(long id);
		
		
		/** 
		 * 查找 通知记录
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllNoterecorderForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找通知记录
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllNoterecorderBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 通知记录
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteNoterecorderBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countNoterecorderBySql(String sql);
		//////////////////////
		/**
		 * 创建 航班经停信息
		 * @param id
		 * @return deleted count 
		 */
		public Flightstop createFlightstop(Flightstop flightstop) throws SQLException;
		
		/**
		 * 删除 航班经停信息
		 * @param id
		 * @return deleted count 
		 */
		public int deleteFlightstop(long id);
		
		
		/**
		 * 修改 航班经停信息
		 * @param id
		 * @return updated count 
		 */
		public int updateFlightstop(Flightstop flightstop);

			
		/**
		 * 修改 航班经停信息但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateFlightstopIgnoreNull(Flightstop flightstop);
			
		
		/**
		 * 查找 航班经停信息
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllFlightstop(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 航班经停信息
		 * @param id
		 * @return
		 */
		public Flightstop findFlightstop(long id);
		
		
		/** 
		 * 查找 航班经停信息
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllFlightstopForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找航班经停信息
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllFlightstopBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 航班经停信息
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteFlightstopBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countFlightstopBySql(String sql);
		//////////////////
		/**
		 * 创建 机型信息表
		 * @param id
		 * @return deleted count 
		 */
		public Flightmodel createFlightmodel(Flightmodel flightmodel) throws SQLException;
		
		/**
		 * 删除 机型信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteFlightmodel(long id);
		
		
		/**
		 * 修改 机型信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateFlightmodel(Flightmodel flightmodel);

			
		/**
		 * 修改 机型信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateFlightmodelIgnoreNull(Flightmodel flightmodel);
			
		
		/**
		 * 查找 机型信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllFlightmodel(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 机型信息表
		 * @param id
		 * @return
		 */
		public Flightmodel findFlightmodel(long id);
		
		
		/** 
		 * 查找 机型信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllFlightmodelForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找机型信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllFlightmodelBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 机型信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteFlightmodelBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countFlightmodelBySql(String sql);
		///////////////////////
		/**
		 * 创建 里程卡
		 * @param id
		 * @return deleted count 
		 */
		public Customeraircard createCustomeraircard(Customeraircard customeraircard) throws SQLException;
		
		/**
		 * 删除 里程卡
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCustomeraircard(long id);
		
		
		/**
		 * 修改 里程卡
		 * @param id
		 * @return updated count 
		 */
		public int updateCustomeraircard(Customeraircard customeraircard);

			
		/**
		 * 修改 里程卡但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCustomeraircardIgnoreNull(Customeraircard customeraircard);
			
		
		/**
		 * 查找 里程卡
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCustomeraircard(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 里程卡
		 * @param id
		 * @return
		 */
		public Customeraircard findCustomeraircard(long id);
		
		
		/** 
		 * 查找 里程卡
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCustomeraircardForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找里程卡
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCustomeraircardBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 里程卡
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCustomeraircardBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCustomeraircardBySql(String sql);
		//////////////////
		/**
		 * 创建 舱位基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public Cabin createCabin(Cabin cabin) throws SQLException;
		
		/**
		 * 删除 舱位基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCabin(long id);
		
		
		/**
		 * 修改 舱位基础信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateCabin(Cabin cabin);

			
		/**
		 * 修改 舱位基础信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCabinIgnoreNull(Cabin cabin);
			
		
		/**
		 * 查找 舱位基础信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCabin(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 舱位基础信息表
		 * @param id
		 * @return
		 */
		public Cabin findCabin(long id);
		
		
		/** 
		 * 查找 舱位基础信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCabinForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找舱位基础信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCabinBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 舱位基础信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCabinBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCabinBySql(String sql);
		//////////////////
		/**
		 * 创建 隐扣设置
		 * @param id
		 * @return deleted count 
		 */
		public Backpoint createBackpoint(Backpoint backpoint) throws SQLException;
		
		/**
		 * 删除 隐扣设置
		 * @param id
		 * @return deleted count 
		 */
		public int deleteBackpoint(long id);
		
		
		/**
		 * 修改 隐扣设置
		 * @param id
		 * @return updated count 
		 */
		public int updateBackpoint(Backpoint backpoint);

			
		/**
		 * 修改 隐扣设置但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateBackpointIgnoreNull(Backpoint backpoint);
			
		
		/**
		 * 查找 隐扣设置
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllBackpoint(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 隐扣设置
		 * @param id
		 * @return
		 */
		public Backpoint findBackpoint(long id);
		
		
		/** 
		 * 查找 隐扣设置
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllBackpointForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找隐扣设置
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllBackpointBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 隐扣设置
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteBackpointBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countBackpointBySql(String sql);
		//////////////////////
		/**
		 * 创建 航班基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public Airflight createAirflight(Airflight airflight) throws SQLException;
		
		/**
		 * 删除 航班基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteAirflight(long id);
		
		
		/**
		 * 修改 航班基础信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateAirflight(Airflight airflight);

			
		/**
		 * 修改 航班基础信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateAirflightIgnoreNull(Airflight airflight);
			
		
		/**
		 * 查找 航班基础信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirflight(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 航班基础信息表
		 * @param id
		 * @return
		 */
		public Airflight findAirflight(long id);
		
		
		/** 
		 * 查找 航班基础信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllAirflightForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找航班基础信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirflightBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 航班基础信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteAirflightBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countAirflightBySql(String sql);
		////////////////
		/**
		 * 创建 燃油费机建费表
		 * @param id
		 * @return deleted count 
		 */
		public Airfee createAirfee(Airfee airfee) throws SQLException;
		
		/**
		 * 删除 燃油费机建费表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteAirfee(long id);
		
		
		/**
		 * 修改 燃油费机建费表
		 * @param id
		 * @return updated count 
		 */
		public int updateAirfee(Airfee airfee);

			
		/**
		 * 修改 燃油费机建费表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateAirfeeIgnoreNull(Airfee airfee);
			
		
		/**
		 * 查找 燃油费机建费表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirfee(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 燃油费机建费表
		 * @param id
		 * @return
		 */
		public Airfee findAirfee(long id);
		
		
		/** 
		 * 查找 燃油费机建费表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllAirfeeForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找燃油费机建费表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirfeeBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 燃油费机建费表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteAirfeeBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countAirfeeBySql(String sql);
		//////////////////
		/**
		 * 创建 航空公司基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public Aircompany createAircompany(Aircompany aircompany) throws SQLException;
		
		/**
		 * 删除 航空公司基础信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteAircompany(long id);
		
		
		/**
		 * 修改 航空公司基础信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateAircompany(Aircompany aircompany);

			
		/**
		 * 修改 航空公司基础信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateAircompanyIgnoreNull(Aircompany aircompany);
			
		
		/**
		 * 查找 航空公司基础信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAircompany(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 航空公司基础信息表
		 * @param id
		 * @return
		 */
		public Aircompany findAircompany(long id);
		
		
		/** 
		 * 查找 航空公司基础信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllAircompanyForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找航空公司基础信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAircompanyBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 航空公司基础信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteAircompanyBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countAircompanyBySql(String sql);
		////////////////
		/**
		 * 创建 机票基础价格表
		 * @param id
		 * @return deleted count 
		 */
		public Airbaseprice createAirbaseprice(Airbaseprice airbaseprice) throws SQLException;
		
		/**
		 * 删除 机票基础价格表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteAirbaseprice(long id);
		
		
		/**
		 * 修改 机票基础价格表
		 * @param id
		 * @return updated count 
		 */
		public int updateAirbaseprice(Airbaseprice airbaseprice);

			
		/**
		 * 修改 机票基础价格表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateAirbasepriceIgnoreNull(Airbaseprice airbaseprice);
			
		
		/**
		 * 查找 机票基础价格表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirbaseprice(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 机票基础价格表
		 * @param id
		 * @return
		 */
		public Airbaseprice findAirbaseprice(long id);
		
		
		/** 
		 * 查找 机票基础价格表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllAirbasepriceForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找机票基础价格表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAirbasepriceBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 机票基础价格表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteAirbasepriceBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countAirbasepriceBySql(String sql);
		/////////////////	
		/**
		 * 创建 特价机票信息（定期更新）
		 * @param id
		 * @return deleted count 
		 */
		public Specialprice createSpecialprice(Specialprice specialprice) throws SQLException;
		
		/**
		 * 删除 特价机票信息（定期更新）
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSpecialprice(long id);
		
		
		/**
		 * 修改 特价机票信息（定期更新）
		 * @param id
		 * @return updated count 
		 */
		public int updateSpecialprice(Specialprice specialprice);

			
		/**
		 * 修改 特价机票信息（定期更新）但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSpecialpriceIgnoreNull(Specialprice specialprice);
			
		
		/**
		 * 查找 特价机票信息（定期更新）
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSpecialprice(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 特价机票信息（定期更新）
		 * @param id
		 * @return
		 */
		public Specialprice findSpecialprice(long id);
		
		
		/** 
		 * 查找 特价机票信息（定期更新）
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSpecialpriceForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找特价机票信息（定期更新）
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSpecialpriceBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 特价机票信息（定期更新）
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSpecialpriceBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSpecialpriceBySql(String sql);
		/**
		 * 查找 航空公司基础信息表 by language
		 * @param id
		 * @return
		 */
		public Aircompany findAircompanybylanguage(long id ,Integer language);
		
		/**
		 * 查找 舱位基础信息表 by language
		 * @param id
		 * @return
		 */
		public Cabin findCabinbylanguage(long id ,Integer language);
		
		/**
		 * 查找 航班经停信息 by language
		 * @param id
		 * @return
		 */
		public Flightstop findFlightstopbylanguage(long id ,Integer language);
		
		/**
		 * 查找 机场城市 by language
		 * @param id
		 * @return
		 */
		public Cityairport findCityairportbylanguage(long id ,Integer language);
		/**
		 * 查找 机型信息表 by language
		 * @param id
		 * @return
		 */
		public Flightmodel findFlightmodelbylanguage(long id ,Integer language);
		public Cpzrate createCpzrate(Cpzrate cpzrate) throws SQLException;
		
		/**
		 * 删除 包机政策
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCpzrate(long id);
		
		
		/**
		 * 修改 包机政策
		 * @param id
		 * @return updated count 
		 */
		public int updateCpzrate(Cpzrate cpzrate);

			
		/**
		 * 修改 包机政策但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCpzrateIgnoreNull(Cpzrate cpzrate);
			
		
		/**
		 * 查找 包机政策
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCpzrate(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 包机政策
		 * @param id
		 * @return
		 */
		public Cpzrate findCpzrate(long id);
		
		
		/** 
		 * 查找 包机政策
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCpzrateForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找包机政策
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCpzrateBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 包机政策
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCpzrateBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCpzrateBySql(String sql);
		///
		/**
		 * 创建 团队申请表
		 * @param id
		 * @return deleted count 
		 */
		public Teamapply createTeamapply(Teamapply teamapply) throws SQLException;
		
		/**
		 * 删除 团队申请表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTeamapply(long id);
		
		
		/**
		 * 修改 团队申请表
		 * @param id
		 * @return updated count 
		 */
		public int updateTeamapply(Teamapply teamapply);

			
		/**
		 * 修改 团队申请表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTeamapplyIgnoreNull(Teamapply teamapply);
			
		
		/**
		 * 查找 团队申请表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTeamapply(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 团队申请表
		 * @param id
		 * @return
		 */
		public Teamapply findTeamapply(long id);
		
		
		/** 
		 * 查找 团队申请表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTeamapplyForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找团队申请表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTeamapplyBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 团队申请表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTeamapplyBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTeamapplyBySql(String sql);
		//
		/**
		 * 创建 团队申请报价表
		 * @param id
		 * @return deleted count 
		 */
		public Supteam createSupteam(Supteam supteam) throws SQLException;
		
		/**
		 * 删除 团队申请报价表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSupteam(long id);
		
		
		/**
		 * 修改 团队申请报价表
		 * @param id
		 * @return updated count 
		 */
		public int updateSupteam(Supteam supteam);

			
		/**
		 * 修改 团队申请报价表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSupteamIgnoreNull(Supteam supteam);
			
		
		/**
		 * 查找 团队申请报价表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSupteam(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 团队申请报价表
		 * @param id
		 * @return
		 */
		public Supteam findSupteam(long id);
		
		
		/** 
		 * 查找 团队申请报价表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSupteamForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找团队申请报价表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSupteamBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 团队申请报价表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSupteamBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSupteamBySql(String sql);
		/////
		/**
		 * 创建 K位特价申请表
		 * @param id
		 * @return deleted count 
		 */
		public Kweisq createKweisq(Kweisq kweisq) throws SQLException;
		
		/**
		 * 删除 K位特价申请表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteKweisq(long id);
		
		
		/**
		 * 修改 K位特价申请表
		 * @param id
		 * @return updated count 
		 */
		public int updateKweisq(Kweisq kweisq);

			
		/**
		 * 修改 K位特价申请表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateKweisqIgnoreNull(Kweisq kweisq);
			
		
		/**
		 * 查找 K位特价申请表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllKweisq(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 K位特价申请表
		 * @param id
		 * @return
		 */
		public Kweisq findKweisq(long id);
		
		
		/** 
		 * 查找 K位特价申请表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllKweisqForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找K位特价申请表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllKweisqBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql K位特价申请表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteKweisqBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countKweisqBySql(String sql);
		//
		/**
		 * 创建 K位特价发布表
		 * @param id
		 * @return deleted count 
		 */
		public Kweifabu createKweifabu(Kweifabu kweifabu) throws SQLException;
		
		/**
		 * 删除 K位特价发布表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteKweifabu(long id);
		
		
		/**
		 * 修改 K位特价发布表
		 * @param id
		 * @return updated count 
		 */
		public int updateKweifabu(Kweifabu kweifabu);

			
		/**
		 * 修改 K位特价发布表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateKweifabuIgnoreNull(Kweifabu kweifabu);
			
		
		/**
		 * 查找 K位特价发布表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllKweifabu(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 K位特价发布表
		 * @param id
		 * @return
		 */
		public Kweifabu findKweifabu(long id);
		
		
		/** 
		 * 查找 K位特价发布表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllKweifabuForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找K位特价发布表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllKweifabuBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql K位特价发布表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteKweifabuBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countKweifabuBySql(String sql);
		//
		/**
		 * 创建 今日报表
		 * @param id
		 * @return deleted count 
		 */
		public Jinribaobiao createJinribaobiao(Jinribaobiao jinribaobiao) throws SQLException;
		
		/**
		 * 删除 今日报表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteJinribaobiao(long id);
		
		
		/**
		 * 修改 今日报表
		 * @param id
		 * @return updated count 
		 */
		public int updateJinribaobiao(Jinribaobiao jinribaobiao);

			
		/**
		 * 修改 今日报表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateJinribaobiaoIgnoreNull(Jinribaobiao jinribaobiao);
			
		
		/**
		 * 查找 今日报表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllJinribaobiao(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 今日报表
		 * @param id
		 * @return
		 */
		public Jinribaobiao findJinribaobiao(long id);
		
		
		/** 
		 * 查找 今日报表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllJinribaobiaoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找今日报表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllJinribaobiaoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 今日报表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteJinribaobiaoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countJinribaobiaoBySql(String sql);
		//
		/**
		 * 创建 退票报表
		 * @param id
		 * @return deleted count 
		 */
		public Tuipiao createTuipiao(Tuipiao tuipiao) throws SQLException;
		
		/**
		 * 删除 退票报表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTuipiao(long id);
		
		
		/**
		 * 修改 退票报表
		 * @param id
		 * @return updated count 
		 */
		public int updateTuipiao(Tuipiao tuipiao);

			
		/**
		 * 修改 退票报表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTuipiaoIgnoreNull(Tuipiao tuipiao);
			
		
		/**
		 * 查找 退票报表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTuipiao(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 退票报表
		 * @param id
		 * @return
		 */
		public Tuipiao findTuipiao(long id);
		
		
		/** 
		 * 查找 退票报表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTuipiaoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找退票报表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTuipiaoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 退票报表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTuipiaoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTuipiaoBySql(String sql);
		
		//
		/**
		 * 创建 销售报表
		 * @param id
		 * @return deleted count 
		 */
		public Sellreport createSellreport(Sellreport sellreport) throws SQLException;
		
		
		/**
		 * 删除 销售报表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSellreport(long id);
		
		
		/**
		 * 修改 销售报表
		 * @param id
		 * @return updated count 
		 */
		public int updateSellreport(Sellreport sellreport);

			
		/**
		 * 修改 销售报表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSellreportIgnoreNull(Sellreport sellreport);
			
		
		/**
		 * 查找 销售报表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSellreport(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 销售报表
		 * @param id
		 * @return
		 */
		public Sellreport findSellreport(long id);
		
		
		/** 
		 * 查找 销售报表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSellreportForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找销售报表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSellreportBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 销售报表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSellreportBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSellreportBySql(String sql);
		//
		/**
		 * 创建 订单升舱表
		 * @param id
		 * @return deleted count 
		 */
		public Scang createScang(Scang scang) throws SQLException;
		
		/**
		 * 删除 订单升舱表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteScang(long id);
		
		
		/**
		 * 修改 订单升舱表
		 * @param id
		 * @return updated count 
		 */
		public int updateScang(Scang scang);

			
		/**
		 * 修改 订单升舱表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateScangIgnoreNull(Scang scang);
			
		
		/**
		 * 查找 订单升舱表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllScang(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 订单升舱表
		 * @param id
		 * @return
		 */
		public Scang findScang(long id);
		
		
		/** 
		 * 查找 订单升舱表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllScangForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找订单升舱表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllScangBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 订单升舱表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteScangBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countScangBySql(String sql);
		/**
		 * 创建 部门绩效表
		 * @param id
		 * @return deleted count 
		 */
		public Rsector createRsector(Rsector rsector) throws SQLException;
		
		/**
		 * 删除 部门绩效表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRsector(long id);
		
		
		/**
		 * 修改 部门绩效表
		 * @param id
		 * @return updated count 
		 */
		public int updateRsector(Rsector rsector);

			
		/**
		 * 修改 部门绩效表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRsectorIgnoreNull(Rsector rsector);
			
		
		/**
		 * 查找 部门绩效表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRsector(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 部门绩效表
		 * @param id
		 * @return
		 */
		public Rsector findRsector(long id);
		
		
		/** 
		 * 查找 部门绩效表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRsectorForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找部门绩效表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRsectorBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 部门绩效表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRsectorBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRsectorBySql(String sql);
		/**
		 * 创建 绩效合约统计
		 * @param id
		 * @return deleted count 
		 */
		public Rperformance createRperformance(Rperformance rperformance) throws SQLException;
		
		/**
		 * 删除 绩效合约统计
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRperformance(long id);
		
		
		/**
		 * 修改 绩效合约统计
		 * @param id
		 * @return updated count 
		 */
		public int updateRperformance(Rperformance rperformance);

			
		/**
		 * 修改 绩效合约统计但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRperformanceIgnoreNull(Rperformance rperformance);
			
		
		/**
		 * 查找 绩效合约统计
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRperformance(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 绩效合约统计
		 * @param id
		 * @return
		 */
		public Rperformance findRperformance(long id);
		
		
		/** 
		 * 查找 绩效合约统计
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRperformanceForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找绩效合约统计
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRperformanceBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 绩效合约统计
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRperformanceBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRperformanceBySql(String sql);
		/**
		 * 创建 人均工作量统计
		 * @param id
		 * @return deleted count 
		 */
		public Perworkload createPerworkload(Perworkload perworkload) throws SQLException;
		
		/**
		 * 删除 人均工作量统计
		 * @param id
		 * @return deleted count 
		 */
		public int deletePerworkload(long id);
		
		
		/**
		 * 修改 人均工作量统计
		 * @param id
		 * @return updated count 
		 */
		public int updatePerworkload(Perworkload perworkload);

			
		/**
		 * 修改 人均工作量统计但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updatePerworkloadIgnoreNull(Perworkload perworkload);
			
		
		/**
		 * 查找 人均工作量统计
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPerworkload(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 人均工作量统计
		 * @param id
		 * @return
		 */
		public Perworkload findPerworkload(long id);
		
		
		/** 
		 * 查找 人均工作量统计
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllPerworkloadForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找人均工作量统计
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllPerworkloadBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 人均工作量统计
		 * @param sql 
		 * @return updated count 
		 */
		public int excutePerworkloadBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countPerworkloadBySql(String sql);
		/**
		 * 创建 部门销售汇总表
		 * @param id
		 * @return deleted count 
		 */
		public Rdepartment createRdepartment(Rdepartment rdepartment) throws SQLException;
		
		/**
		 * 删除 部门销售汇总表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRdepartment(long id);
		
		
		/**
		 * 修改 部门销售汇总表
		 * @param id
		 * @return updated count 
		 */
		public int updateRdepartment(Rdepartment rdepartment);

			
		/**
		 * 修改 部门销售汇总表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRdepartmentIgnoreNull(Rdepartment rdepartment);
			
		
		/**
		 * 查找 部门销售汇总表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRdepartment(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 部门销售汇总表
		 * @param id
		 * @return
		 */
		public Rdepartment findRdepartment(long id);
		
		
		/** 
		 * 查找 部门销售汇总表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRdepartmentForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找部门销售汇总表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRdepartmentBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 部门销售汇总表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRdepartmentBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRdepartmentBySql(String sql);
		/**
		 * 创建 直销汇总表
		 * @param id
		 * @return deleted count 
		 */
		public Rzhixiao createRzhixiao(Rzhixiao rzhixiao) throws SQLException;
		
		/**
		 * 删除 直销汇总表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRzhixiao(long id);
		
		
		/**
		 * 修改 直销汇总表
		 * @param id
		 * @return updated count 
		 */
		public int updateRzhixiao(Rzhixiao rzhixiao);

			
		/**
		 * 修改 直销汇总表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRzhixiaoIgnoreNull(Rzhixiao rzhixiao);
			
		
		/**
		 * 查找 直销汇总表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRzhixiao(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 直销汇总表
		 * @param id
		 * @return
		 */
		public Rzhixiao findRzhixiao(long id);
		
		
		/** 
		 * 查找 直销汇总表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRzhixiaoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找直销汇总表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRzhixiaoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 直销汇总表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRzhixiaoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRzhixiaoBySql(String sql);
		/**
		 * 创建 集团客户环比统计表
		 * @param id
		 * @return deleted count 
		 */
		public Rgroupcustomers createRgroupcustomers(Rgroupcustomers rgroupcustomers) throws SQLException;
		
		/**
		 * 删除 集团客户环比统计表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRgroupcustomers(long id);
		
		
		/**
		 * 修改 集团客户环比统计表
		 * @param id
		 * @return updated count 
		 */
		public int updateRgroupcustomers(Rgroupcustomers rgroupcustomers);

			
		/**
		 * 修改 集团客户环比统计表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRgroupcustomersIgnoreNull(Rgroupcustomers rgroupcustomers);
			
		
		/**
		 * 查找 集团客户环比统计表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRgroupcustomers(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 集团客户环比统计表
		 * @param id
		 * @return
		 */
		public Rgroupcustomers findRgroupcustomers(long id);
		
		
		/** 
		 * 查找 集团客户环比统计表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRgroupcustomersForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找集团客户环比统计表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRgroupcustomersBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 集团客户环比统计表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRgroupcustomersBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRgroupcustomersBySql(String sql);
		//

		   //粘贴到Service接口类
		 	/**
			 * 创建 国际机票国家
			 * @param id
			 * @return deleted count 
			 */
			public Fcountry createFcountry(Fcountry fcountry) throws SQLException;
			
			/**
			 * 删除 国际机票国家
			 * @param id
			 * @return deleted count 
			 */
			public int deleteFcountry(long id);
			
			
			/**
			 * 修改 国际机票国家
			 * @param id
			 * @return updated count 
			 */
			public int updateFcountry(Fcountry fcountry);

				
			/**
			 * 修改 国际机票国家但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateFcountryIgnoreNull(Fcountry fcountry);
				
			
			/**
			 * 查找 国际机票国家
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllFcountry(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 国际机票国家
			 * @param id
			 * @return
			 */
			public Fcountry findFcountry(long id);
			
			/**
			 * 查找 国际机票国家 by language
			 * @param id
			 * @return
			 */
			public Fcountry findFcountrybylanguage(long id ,Integer language);
			
			/** 
			 * 查找 国际机票国家
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllFcountryForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找国际机票国家
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllFcountryBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 国际机票国家
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteFcountryBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countFcountryBySql(String sql);
			
			/**
			 * 创建 机票还款记录
			 * @param id
			 * @return deleted count 
			 */
			public Passengerrepayrc createPassengerrepayrc(Passengerrepayrc passengerrepayrc) throws SQLException;
			
			/**
			 * 删除 机票还款记录
			 * @param id
			 * @return deleted count 
			 */
			public int deletePassengerrepayrc(long id);
			
			
			/**
			 * 修改 机票还款记录
			 * @param id
			 * @return updated count 
			 */
			public int updatePassengerrepayrc(Passengerrepayrc passengerrepayrc);

				
			/**
			 * 修改 机票还款记录但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updatePassengerrepayrcIgnoreNull(Passengerrepayrc passengerrepayrc);
				
			
			/**
			 * 查找 机票还款记录
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllPassengerrepayrc(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 机票还款记录
			 * @param id
			 * @return
			 */
			public Passengerrepayrc findPassengerrepayrc(long id);
			
			
			/** 
			 * 查找 机票还款记录
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllPassengerrepayrcForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找机票还款记录
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllPassengerrepayrcBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 机票还款记录
			 * @param sql 
			 * @return updated count 
			 */
			public int excutePassengerrepayrcBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countPassengerrepayrcBySql(String sql);
			
			/**
			 * 创建 机票低价数据表
			 * @param id
			 * @return deleted count 
			 */
			public Lowestprice createLowestprice(Lowestprice lowestprice) throws SQLException;
			
			/**
			 * 删除 机票低价数据表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteLowestprice(long id);
			
			
			/**
			 * 修改 机票低价数据表
			 * @param id
			 * @return updated count 
			 */
			public int updateLowestprice(Lowestprice lowestprice);

				
			/**
			 * 修改 机票低价数据表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateLowestpriceIgnoreNull(Lowestprice lowestprice);
				
			
			/**
			 * 查找 机票低价数据表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllLowestprice(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 机票低价数据表
			 * @param id
			 * @return
			 */
			public Lowestprice findLowestprice(long id);
			
			
			/** 
			 * 查找 机票低价数据表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllLowestpriceForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找机票低价数据表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllLowestpriceBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 机票低价数据表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteLowestpriceBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countLowestpriceBySql(String sql);
			 //粘贴到Service接口类
		 	/**
			 * 创建 特价申请表
			 * @param id
			 * @return deleted count 
			 */
			public Ticketapp createTicketapp(Ticketapp ticketapp) throws SQLException;
			
			/**
			 * 删除 特价申请表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteTicketapp(long id);
			
			
			/**
			 * 修改 特价申请表
			 * @param id
			 * @return updated count 
			 */
			public int updateTicketapp(Ticketapp ticketapp);

				
			/**
			 * 修改 特价申请表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateTicketappIgnoreNull(Ticketapp ticketapp);
				
			
			/**
			 * 查找 特价申请表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllTicketapp(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 特价申请表
			 * @param id
			 * @return
			 */
			public Ticketapp findTicketapp(long id);
			
			
			/** 
			 * 查找 特价申请表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllTicketappForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找特价申请表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllTicketappBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 特价申请表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteTicketappBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countTicketappBySql(String sql);
			 //粘贴到Service接口类
		 	/**
			 * 创建 包机订单
			 * @param id
			 * @return deleted count 
			 */
			public Charterorder createCharterorder(Charterorder charterorder) throws SQLException;
			
			/**
			 * 删除 包机订单
			 * @param id
			 * @return deleted count 
			 */
			public int deleteCharterorder(long id);
			
			
			/**
			 * 修改 包机订单
			 * @param id
			 * @return updated count 
			 */
			public int updateCharterorder(Charterorder charterorder);

				
			/**
			 * 修改 包机订单但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateCharterorderIgnoreNull(Charterorder charterorder);
				
			
			/**
			 * 查找 包机订单
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCharterorder(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 包机订单
			 * @param id
			 * @return
			 */
			public Charterorder findCharterorder(long id);
			
			
			/** 
			 * 查找 包机订单
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllCharterorderForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找包机订单
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCharterorderBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 包机订单
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteCharterorderBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countCharterorderBySql(String sql);
			

			
			
//////////////////////////////////////////////////////////////
//保险公司表
			/**
			 * 创建 保险服务公司信息表
			 * @param id
			 * @return deleted count 
			 */
			public Insurcomputer createInsurcomputer(Insurcomputer insurcomputer) throws SQLException;
			
			/**
			 * 删除 保险服务公司信息表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteInsurcomputer(long id);
			
			
			/**
			 * 修改 保险服务公司信息表
			 * @param id
			 * @return updated count 
			 */
			public int updateInsurcomputer(Insurcomputer insurcomputer);

				
			/**
			 * 修改 保险服务公司信息表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateInsurcomputerIgnoreNull(Insurcomputer insurcomputer);
				
			
			/**
			 * 查找 保险服务公司信息表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsurcomputer(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 保险服务公司信息表
			 * @param id
			 * @return
			 */
			public Insurcomputer findInsurcomputer(long id);
			
			
			/** 
			 * 查找 保险服务公司信息表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllInsurcomputerForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找保险服务公司信息表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsurcomputerBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 保险服务公司信息表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteInsurcomputerBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countInsurcomputerBySql(String sql);
			
///////////////////////////////////////////////////////////////////
	//保险订单
			/**
			 * 创建 订单表
			 * @param id
			 * @return deleted count 
			 */
			public Insurorder createInsurorder(Insurorder insurorder) throws SQLException;
			
			/**
			 * 删除 订单表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteInsurorder(long id);
			
			
			/**
			 * 修改 订单表
			 * @param id
			 * @return updated count 
			 */
			public int updateInsurorder(Insurorder insurorder);

				
			/**
			 * 修改 订单表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateInsurorderIgnoreNull(Insurorder insurorder);
				
			
			/**
			 * 查找 订单表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsurorder(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 订单表
			 * @param id
			 * @return
			 */
			public Insurorder findInsurorder(long id);
			
			
			/** 
			 * 查找 订单表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllInsurorderForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找订单表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsurorderBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 订单表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteInsurorderBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countInsurorderBySql(String sql);
			
			
///////////////////////////////////////////////////////////////////////
	//被保人信息
			/**
			 * 创建 被保人列表
			 * @param id
			 * @return deleted count 
			 */
			public Insuruser createInsuruser(Insuruser insuruser) throws SQLException;
			
			/**
			 * 删除 被保人列表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteInsuruser(long id);
			
			
			/**
			 * 修改 被保人列表
			 * @param id
			 * @return updated count 
			 */
			public int updateInsuruser(Insuruser insuruser);

				
			/**
			 * 修改 被保人列表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateInsuruserIgnoreNull(Insuruser insuruser);
				
			
			/**
			 * 查找 被保人列表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsuruser(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 被保人列表
			 * @param id
			 * @return
			 */
			public Insuruser findInsuruser(long id);
			
			
			/** 
			 * 查找 被保人列表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllInsuruserForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找被保人列表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllInsuruserBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 被保人列表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteInsuruserBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countInsuruserBySql(String sql);
			//
			 //粘贴到Service接口类
		 	/**
			 * 创建 限制仓位
			 * @param id
			 * @return deleted count 
			 */
			public Limitcabin createLimitcabin(Limitcabin limitcabin) throws SQLException;
			
			/**
			 * 删除 限制仓位
			 * @param id
			 * @return deleted count 
			 */
			public int deleteLimitcabin(long id);
			
			
			/**
			 * 修改 限制仓位
			 * @param id
			 * @return updated count 
			 */
			public int updateLimitcabin(Limitcabin limitcabin);

				
			/**
			 * 修改 限制仓位但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateLimitcabinIgnoreNull(Limitcabin limitcabin);
				
			
			/**
			 * 查找 限制仓位
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllLimitcabin(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 限制仓位
			 * @param id
			 * @return
			 */
			public Limitcabin findLimitcabin(long id);
			
			
			/** 
			 * 查找 限制仓位
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllLimitcabinForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找限制仓位
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllLimitcabinBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 限制仓位
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteLimitcabinBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countLimitcabinBySql(String sql);
			


			   //粘贴到Service接口类
			 	/**
				 * 创建 变更记录
				 * @param id
				 * @return deleted count 
				 */
				public Changpass createChangpass(Changpass changpass) throws SQLException;
				
				/**
				 * 删除 变更记录
				 * @param id
				 * @return deleted count 
				 */
				public int deleteChangpass(long id);
				
				
				/**
				 * 修改 变更记录
				 * @param id
				 * @return updated count 
				 */
				public int updateChangpass(Changpass changpass);

					
				/**
				 * 修改 变更记录但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateChangpassIgnoreNull(Changpass changpass);
					
				
				/**
				 * 查找 变更记录
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllChangpass(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 变更记录
				 * @param id
				 * @return
				 */
				public Changpass findChangpass(long id);
				
				
				/** 
				 * 查找 变更记录
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllChangpassForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找变更记录
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllChangpassBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 变更记录
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteChangpassBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countChangpassBySql(String sql);
				
				
				
				  
				  
				   //粘贴到Service接口类
				 	/**
					 * 创建 行程单订单
					 * @param id
					 * @return deleted count 
					 */
					public Xcdorder createXcdorder(Xcdorder xcdorder) throws SQLException;
					
					/**
					 * 删除 行程单订单
					 * @param id
					 * @return deleted count 
					 */
					public int deleteXcdorder(long id);
					
					
					/**
					 * 修改 行程单订单
					 * @param id
					 * @return updated count 
					 */
					public int updateXcdorder(Xcdorder xcdorder);

						
					/**
					 * 修改 行程单订单但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateXcdorderIgnoreNull(Xcdorder xcdorder);
						
					
					/**
					 * 查找 行程单订单
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllXcdorder(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 行程单订单
					 * @param id
					 * @return
					 */
					public Xcdorder findXcdorder(long id);
					
					
					/** 
					 * 查找 行程单订单
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllXcdorderForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找行程单订单
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllXcdorderBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 行程单订单
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteXcdorderBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countXcdorderBySql(String sql);
					
					
					  
					  
					   //粘贴到Service接口类
					 	/**
						 * 创建 行程单号码
						 * @param id
						 * @return deleted count 
						 */
						public Xcdnoinfo createXcdnoinfo(Xcdnoinfo xcdnoinfo) throws SQLException;
						
						/**
						 * 删除 行程单号码
						 * @param id
						 * @return deleted count 
						 */
						public int deleteXcdnoinfo(long id);
						
						
						/**
						 * 修改 行程单号码
						 * @param id
						 * @return updated count 
						 */
						public int updateXcdnoinfo(Xcdnoinfo xcdnoinfo);

							
						/**
						 * 修改 行程单号码但忽略空值 
						 * @param id
						 * @return 
						 */
						public int updateXcdnoinfoIgnoreNull(Xcdnoinfo xcdnoinfo);
							
						
						/**
						 * 查找 行程单号码
						 * @param where
						 * @param orderby
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllXcdnoinfo(String where, String orderby,int limit,int offset);
							
						
						/**
						 * 查找 行程单号码
						 * @param id
						 * @return
						 */
						public Xcdnoinfo findXcdnoinfo(long id);
						
						
						/** 
						 * 查找 行程单号码
						 * @param where
						 * @param orderby
						 * @param pageinfo
						 * @return
						 */
						public List findAllXcdnoinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
							
						/** 
						 * 根据Sql查找行程单号码
						 * @param sql
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllXcdnoinfoBySql(String sql,int limit,int offset);
						
						
						/**
						 * 执行Sql 行程单号码
						 * @param sql 
						 * @return updated count 
						 */
						public int excuteXcdnoinfoBySql(String sql);
						
						/**
						 * 执行Sql 
						 * @param sql 
						 * @return  count 
						 */
						public int countXcdnoinfoBySql(String sql);
						
						
						  
						  
						   //粘贴到Service接口类
						 	/**
							 * 创建 行程单
							 * @param id
							 * @return deleted count 
							 */
							public Xcdno createXcdno(Xcdno xcdno) throws SQLException;
							
							/**
							 * 删除 行程单
							 * @param id
							 * @return deleted count 
							 */
							public int deleteXcdno(long id);
							
							
							/**
							 * 修改 行程单
							 * @param id
							 * @return updated count 
							 */
							public int updateXcdno(Xcdno xcdno);

								
							/**
							 * 修改 行程单但忽略空值 
							 * @param id
							 * @return 
							 */
							public int updateXcdnoIgnoreNull(Xcdno xcdno);
								
							
							/**
							 * 查找 行程单
							 * @param where
							 * @param orderby
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllXcdno(String where, String orderby,int limit,int offset);
								
							
							/**
							 * 查找 行程单
							 * @param id
							 * @return
							 */
							public Xcdno findXcdno(long id);
							
							
							/** 
							 * 查找 行程单
							 * @param where
							 * @param orderby
							 * @param pageinfo
							 * @return
							 */
							public List findAllXcdnoForPageinfo(String where, String orderby,PageInfo pageinfo);
								
							/** 
							 * 根据Sql查找行程单
							 * @param sql
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllXcdnoBySql(String sql,int limit,int offset);
							
							
							/**
							 * 执行Sql 行程单
							 * @param sql 
							 * @return updated count 
							 */
							public int excuteXcdnoBySql(String sql);
							
							/**
							 * 执行Sql 
							 * @param sql 
							 * @return  count 
							 */
							public int countXcdnoBySql(String sql);
							
							
							
							  
							  
							   //粘贴到Service接口类
							 	/**
								 * 创建 行程单配送记录
								 * @param id
								 * @return deleted count 
								 */
								public Peisong createPeisong(Peisong peisong) throws SQLException;
								
								/**
								 * 删除 行程单配送记录
								 * @param id
								 * @return deleted count 
								 */
								public int deletePeisong(long id);
								
								
								/**
								 * 修改 行程单配送记录
								 * @param id
								 * @return updated count 
								 */
								public int updatePeisong(Peisong peisong);

									
								/**
								 * 修改 行程单配送记录但忽略空值 
								 * @param id
								 * @return 
								 */
								public int updatePeisongIgnoreNull(Peisong peisong);
									
								
								/**
								 * 查找 行程单配送记录
								 * @param where
								 * @param orderby
								 * @param limit
								 * @param offset
								 * @return
								 */
								public List findAllPeisong(String where, String orderby,int limit,int offset);
									
								
								/**
								 * 查找 行程单配送记录
								 * @param id
								 * @return
								 */
								public Peisong findPeisong(long id);
								
								
								/** 
								 * 查找 行程单配送记录
								 * @param where
								 * @param orderby
								 * @param pageinfo
								 * @return
								 */
								public List findAllPeisongForPageinfo(String where, String orderby,PageInfo pageinfo);
									
								/** 
								 * 根据Sql查找行程单配送记录
								 * @param sql
								 * @param limit
								 * @param offset
								 * @return
								 */
								public List findAllPeisongBySql(String sql,int limit,int offset);
								
								
								/**
								 * 执行Sql 行程单配送记录
								 * @param sql 
								 * @return updated count 
								 */
								public int excutePeisongBySql(String sql);
								
								/**
								 * 执行Sql 
								 * @param sql 
								 * @return  count 
								 */
								public int countPeisongBySql(String sql);
								
							
								
								  
								  
								   //粘贴到Service接口类
								 	/**
									 * 创建 折返
									 * @param id
									 * @return deleted count 
									 */
									public Zhefan createZhefan(Zhefan zhefan) throws SQLException;
									
									/**
									 * 删除 折返
									 * @param id
									 * @return deleted count 
									 */
									public int deleteZhefan(long id);
									
									
									/**
									 * 修改 折返
									 * @param id
									 * @return updated count 
									 */
									public int updateZhefan(Zhefan zhefan);

										
									/**
									 * 修改 折返但忽略空值 
									 * @param id
									 * @return 
									 */
									public int updateZhefanIgnoreNull(Zhefan zhefan);
										
									
									/**
									 * 查找 折返
									 * @param where
									 * @param orderby
									 * @param limit
									 * @param offset
									 * @return
									 */
									public List findAllZhefan(String where, String orderby,int limit,int offset);
										
									
									/**
									 * 查找 折返
									 * @param id
									 * @return
									 */
									public Zhefan findZhefan(long id);
									
									
									/** 
									 * 查找 折返
									 * @param where
									 * @param orderby
									 * @param pageinfo
									 * @return
									 */
									public List findAllZhefanForPageinfo(String where, String orderby,PageInfo pageinfo);
										
									/** 
									 * 根据Sql查找折返
									 * @param sql
									 * @param limit
									 * @param offset
									 * @return
									 */
									public List findAllZhefanBySql(String sql,int limit,int offset);
									
									
									/**
									 * 执行Sql 折返
									 * @param sql 
									 * @return updated count 
									 */
									public int excuteZhefanBySql(String sql);
									
									/**
									 * 执行Sql 
									 * @param sql 
									 * @return  count 
									 */
									public int countZhefanBySql(String sql);
									
									
									  
									  
									   //粘贴到Service接口类
									 	/**
										 * 创建 NFD价格
										 * @param id
										 * @return deleted count 
										 */
										public Nfdprice createNfdprice(Nfdprice nfdprice) throws SQLException;
										
										/**
										 * 删除 NFD价格
										 * @param id
										 * @return deleted count 
										 */
										public int deleteNfdprice(long id);
										
										
										/**
										 * 修改 NFD价格
										 * @param id
										 * @return updated count 
										 */
										public int updateNfdprice(Nfdprice nfdprice);

											
										/**
										 * 修改 NFD价格但忽略空值 
										 * @param id
										 * @return 
										 */
										public int updateNfdpriceIgnoreNull(Nfdprice nfdprice);
											
										
										/**
										 * 查找 NFD价格
										 * @param where
										 * @param orderby
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllNfdprice(String where, String orderby,int limit,int offset);
											
										
										/**
										 * 查找 NFD价格
										 * @param id
										 * @return
										 */
										public Nfdprice findNfdprice(long id);
										
										
										/** 
										 * 查找 NFD价格
										 * @param where
										 * @param orderby
										 * @param pageinfo
										 * @return
										 */
										public List findAllNfdpriceForPageinfo(String where, String orderby,PageInfo pageinfo);
											
										/** 
										 * 根据Sql查找NFD价格
										 * @param sql
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllNfdpriceBySql(String sql,int limit,int offset);
										
										
										/**
										 * 执行Sql NFD价格
										 * @param sql 
										 * @return updated count 
										 */
										public int excuteNfdpriceBySql(String sql);
										
										/**
										 * 执行Sql 
										 * @param sql 
										 * @return  count 
										 */
										public int countNfdpriceBySql(String sql);
										
										
										
										
										  
										  
										   //粘贴到Service接口类
										 	/**
											 * 创建 航线信息
											 * @param id
											 * @return deleted count 
											 */
											public Airlien createAirlien(Airlien airlien) throws SQLException;
											
											/**
											 * 删除 航线信息
											 * @param id
											 * @return deleted count 
											 */
											public int deleteAirlien(long id);
											
											
											/**
											 * 修改 航线信息
											 * @param id
											 * @return updated count 
											 */
											public int updateAirlien(Airlien airlien);

												
											/**
											 * 修改 航线信息但忽略空值 
											 * @param id
											 * @return 
											 */
											public int updateAirlienIgnoreNull(Airlien airlien);
												
											
											/**
											 * 查找 航线信息
											 * @param where
											 * @param orderby
											 * @param limit
											 * @param offset
											 * @return
											 */
											public List findAllAirlien(String where, String orderby,int limit,int offset);
												
											
											/**
											 * 查找 航线信息
											 * @param id
											 * @return
											 */
											public Airlien findAirlien(long id);
											
											
											/** 
											 * 查找 航线信息
											 * @param where
											 * @param orderby
											 * @param pageinfo
											 * @return
											 */
											public List findAllAirlienForPageinfo(String where, String orderby,PageInfo pageinfo);
												
											/** 
											 * 根据Sql查找航线信息
											 * @param sql
											 * @param limit
											 * @param offset
											 * @return
											 */
											public List findAllAirlienBySql(String sql,int limit,int offset);
											
											
											/**
											 * 执行Sql 航线信息
											 * @param sql 
											 * @return updated count 
											 */
											public int excuteAirlienBySql(String sql);
											
											/**
											 * 执行Sql 
											 * @param sql 
											 * @return  count 
											 */
											public int countAirlienBySql(String sql);
											
											
											  
											  
											   //粘贴到Service接口类
											 	/**
												 * 创建 航线仓位信息
												 * @param id
												 * @return deleted count 
												 */
												public Airliencabin createAirliencabin(Airliencabin airliencabin) throws SQLException;
												
												/**
												 * 删除 航线仓位信息
												 * @param id
												 * @return deleted count 
												 */
												public int deleteAirliencabin(long id);
												
												
												/**
												 * 修改 航线仓位信息
												 * @param id
												 * @return updated count 
												 */
												public int updateAirliencabin(Airliencabin airliencabin);

													
												/**
												 * 修改 航线仓位信息但忽略空值 
												 * @param id
												 * @return 
												 */
												public int updateAirliencabinIgnoreNull(Airliencabin airliencabin);
													
												
												/**
												 * 查找 航线仓位信息
												 * @param where
												 * @param orderby
												 * @param limit
												 * @param offset
												 * @return
												 */
												public List findAllAirliencabin(String where, String orderby,int limit,int offset);
													
												
												/**
												 * 查找 航线仓位信息
												 * @param id
												 * @return
												 */
												public Airliencabin findAirliencabin(long id);
												
												
												/** 
												 * 查找 航线仓位信息
												 * @param where
												 * @param orderby
												 * @param pageinfo
												 * @return
												 */
												public List findAllAirliencabinForPageinfo(String where, String orderby,PageInfo pageinfo);
													
												/** 
												 * 根据Sql查找航线仓位信息
												 * @param sql
												 * @param limit
												 * @param offset
												 * @return
												 */
												public List findAllAirliencabinBySql(String sql,int limit,int offset);
												
												
												/**
												 * 执行Sql 航线仓位信息
												 * @param sql 
												 * @return updated count 
												 */
												public int excuteAirliencabinBySql(String sql);
												
												/**
												 * 执行Sql 
												 * @param sql 
												 * @return  count 
												 */
												public int countAirliencabinBySql(String sql);
												
														
}
