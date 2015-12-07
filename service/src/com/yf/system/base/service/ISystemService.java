package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.advertisement.Advertisement;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.eaccount.Eaccount;
import com.yf.system.base.eterminfo.Eterminfo;
import com.yf.system.base.gift.Gift;
import com.yf.system.base.giftcatalog.Giftcatalog;
import com.yf.system.base.intermanager.Intermanager;
import com.yf.system.base.optrecord.Optrecord;
import com.yf.system.base.redeem.Redeem;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;

public interface ISystemService {
	
	 //粘贴到Service接口类
 	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException;
	
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id);
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig);

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig);
		
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id);
	
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfigForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfigBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql);
	
	  //粘贴到Service接口类
 	/**
	 * 创建 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public Intermanager createIntermanager(Intermanager intermanager) throws SQLException;
	
	/**
	 * 删除 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntermanager(long id);
	
	
	/**
	 * 修改 接口管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntermanager(Intermanager intermanager);

		
	/**
	 * 修改 接口管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntermanagerIgnoreNull(Intermanager intermanager);
		
	
	/**
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 接口管理
	 * @param id
	 * @return
	 */
	public Intermanager findIntermanager(long id);
	
	
	/** 
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntermanagerForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找接口管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanagerBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 接口管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntermanagerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntermanagerBySql(String sql);	
	
	
	/**
	 * 执行sql返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultBySql(String sql,PageInfo pageinfo);
	/**
	 * 执行sql返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultSortBySql(String sql,String orderby ,PageInfo pageinfo);
	/**
	 * 执行存贮过程返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultByProcedure(String procedure);
	
	public List findMapResultPageByProcedure(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo );
	

	/**
	 * 创建 广告表
	 * @param id
	 * @return deleted count 
	 */
	public Advertisement createAdvertisement(Advertisement advertisement) throws SQLException;
	
	/**
	 * 删除 广告表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdvertisement(long id);
	
	
	/**
	 * 修改 广告表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdvertisement(Advertisement advertisement);

		
	/**
	 * 修改 广告表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdvertisementIgnoreNull(Advertisement advertisement);
		
	
	/**
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 广告表
	 * @param id
	 * @return
	 */
	public Advertisement findAdvertisement(long id);
	
	
	/** 
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdvertisementForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找广告表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisementBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 广告表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdvertisementBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdvertisementBySql(String sql);
	/**
	 * 创建 配置表
	 * @param id
	 * @return deleted count 
	 */
	public Eterminfo createEterminfo(Eterminfo eterminfo) throws SQLException;
	
	/**
	 * 删除 配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEterminfo(long id);
	
	
	/**
	 * 修改 配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateEterminfo(Eterminfo eterminfo);

		
	/**
	 * 修改 配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEterminfoIgnoreNull(Eterminfo eterminfo);
		
	
	/**
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 配置表
	 * @param id
	 * @return
	 */
	public Eterminfo findEterminfo(long id);
	
	
	/** 
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEterminfoForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfoBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEterminfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEterminfoBySql(String sql);
	/**
	 * 创建 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public Optrecord createOptrecord(Optrecord optrecord) throws SQLException;
	
	/**
	 * 删除 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOptrecord(long id);
	
	
	/**
	 * 修改 操作记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateOptrecord(Optrecord optrecord);

		
	/**
	 * 修改 操作记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOptrecordIgnoreNull(Optrecord optrecord);
		
	
	/**
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 操作记录表
	 * @param id
	 * @return
	 */
	public Optrecord findOptrecord(long id);
	
	
	/** 
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOptrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找操作记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecordBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 操作记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOptrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOptrecordBySql(String sql);
	
	
	/**
	 * 创建 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public Giftcatalog createGiftcatalog(Giftcatalog giftcatalog) throws SQLException;
	
	/**
	 * 删除 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGiftcatalog(long id);
	
	
	/**
	 * 修改 礼品目录
	 * @param id
	 * @return updated count 
	 */
	public int updateGiftcatalog(Giftcatalog giftcatalog);

		
	/**
	 * 修改 礼品目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftcatalogIgnoreNull(Giftcatalog giftcatalog);
		
	
	/**
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 礼品目录
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalog(long id);
	
	/**
	 * 查找 礼品目录 by language
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalogbylanguage(long id ,Integer language);
	
	/** 
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftcatalogForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找礼品目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalogBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 礼品目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftcatalogBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftcatalogBySql(String sql);
	
	
	
	
	/**
	 * 创建 礼品
	 * @param id
	 * @return deleted count 
	 */
	public Gift createGift(Gift gift) throws SQLException;
	
	/**
	 * 删除 礼品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGift(long id);
	
	
	/**
	 * 修改 礼品
	 * @param id
	 * @return updated count 
	 */
	public int updateGift(Gift gift);

		
	/**
	 * 修改 礼品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftIgnoreNull(Gift gift);
		
	
	/**
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGift(long id);
	
	/**
	 * 查找 礼品 by language
	 * @param id
	 * @return
	 */
	public Gift findGiftbylanguage(long id ,Integer language);
	
	/** 
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找礼品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 礼品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftBySql(String sql);
	
	
	
	
	/**
	 * 创建 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public Redeem createRedeem(Redeem redeem) throws SQLException;
	
	/**
	 * 删除 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRedeem(long id);
	
	
	/**
	 * 修改 积分兑换
	 * @param id
	 * @return updated count 
	 */
	public int updateRedeem(Redeem redeem);

		
	/**
	 * 修改 积分兑换但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRedeemIgnoreNull(Redeem redeem);
		
	
	/**
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分兑换
	 * @param id
	 * @return
	 */
	public Redeem findRedeem(long id);
	
	
	/** 
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRedeemForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分兑换
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeemBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分兑换
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRedeemBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRedeemBySql(String sql);
	
	
	
	/**
	 * 创建 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public Dnsmaintenance createDnsmaintenance(Dnsmaintenance dnsmaintenance) throws SQLException;
	
	/**
	 * 删除 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDnsmaintenance(long id);
	
	
	/**
	 * 修改 分销商DNSLOGO维护
	 * @param id
	 * @return updated count 
	 */
	public int updateDnsmaintenance(Dnsmaintenance dnsmaintenance);

		
	/**
	 * 修改 分销商DNSLOGO维护但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDnsmaintenanceIgnoreNull(Dnsmaintenance dnsmaintenance);
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param id
	 * @return
	 */
	public Dnsmaintenance findDnsmaintenance(long id);
	
	
	/** 
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDnsmaintenanceForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找分销商DNSLOGO维护
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenanceBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 分销商DNSLOGO维护
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDnsmaintenanceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDnsmaintenanceBySql(String sql);
	
	 //粘贴到Service接口类
 	/**
	 * 创建 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public Eaccount createEaccount(Eaccount eaccount) throws SQLException;
	
	/**
	 * 删除 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEaccount(long id);
	
	
	/**
	 * 修改 外部账号
	 * @param id
	 * @return updated count 
	 */
	public int updateEaccount(Eaccount eaccount);

		
	/**
	 * 修改 外部账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEaccountIgnoreNull(Eaccount eaccount);
		
	
	/**
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 外部账号
	 * @param id
	 * @return
	 */
	public Eaccount findEaccount(long id);
	
	
	/** 
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEaccountForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找外部账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccountBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 外部账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEaccountBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEaccountBySql(String sql);
	
	
	public <T>T getTObject(Class<T> cls,long id,String...clos);
}
