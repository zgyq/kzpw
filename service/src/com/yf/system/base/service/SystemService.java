package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.advertisement.Advertisement;
import com.yf.system.base.advertisement.IAdvertisementComponent;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.dnsmaintenance.IDnsmaintenanceComponent;
import com.yf.system.base.eaccount.Eaccount;
import com.yf.system.base.eaccount.IEaccountComponent;
import com.yf.system.base.eterminfo.Eterminfo;
import com.yf.system.base.eterminfo.IEterminfoComponent;
import com.yf.system.base.gift.Gift;
import com.yf.system.base.gift.IGiftComponent;
import com.yf.system.base.giftcatalog.Giftcatalog;
import com.yf.system.base.giftcatalog.IGiftcatalogComponent;
import com.yf.system.base.intermanager.IIntermanagerComponent;
import com.yf.system.base.intermanager.Intermanager;
import com.yf.system.base.optrecord.IOptrecordComponent;
import com.yf.system.base.optrecord.Optrecord;
import com.yf.system.base.redeem.IRedeemComponent;
import com.yf.system.base.redeem.Redeem;
import com.yf.system.base.sysconfig.ISysconfigComponent;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;


public class SystemService implements ISystemService{
//粘贴到Service实现类
	
	private ISysconfigComponent sysconfigComponent;
	  
 	
 	public ISysconfigComponent getSysconfigComponent() {
		return sysconfigComponent;
	}
	public void setSysconfigComponent(ISysconfigComponent  sysconfigComponent) {
		this.sysconfigComponent = sysconfigComponent;
	}
	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException{
	
		return sysconfigComponent.createSysconfig(sysconfig);
	}
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id){
	
		return sysconfigComponent.deleteSysconfig(id);
	}
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig){
		return sysconfigComponent.updateSysconfig(sysconfig);
	
	}

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig){
			return sysconfigComponent.updateSysconfigIgnoreNull(sysconfig);
	
	}
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset){
		return sysconfigComponent.findAllSysconfig(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id){
		return sysconfigComponent.findSysconfig(id);
	}
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfigForPageinfo(String where, String orderby,PageInfo pageinfo){
		return sysconfigComponent.findAllSysconfig(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfigBySql(String sql,int limit,int offset){
		return sysconfigComponent.findAllSysconfig(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql){
		return sysconfigComponent.excuteSysconfigBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql){
		return sysconfigComponent.countSysconfigBySql(sql);
	}
	
	private IIntermanagerComponent intermanagerComponent;
	  
 	
 	public IIntermanagerComponent getIntermanagerComponent() {
		return intermanagerComponent;
	}
	public void setIntermanagerComponent(IIntermanagerComponent  intermanagerComponent) {
		this.intermanagerComponent = intermanagerComponent;
	}
	/**
	 * 创建 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public Intermanager createIntermanager(Intermanager intermanager) throws SQLException{
	
		return intermanagerComponent.createIntermanager(intermanager);
	}
	/**
	 * 删除 接口管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntermanager(long id){
	
		return intermanagerComponent.deleteIntermanager(id);
	}
	
	
	/**
	 * 修改 接口管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntermanager(Intermanager intermanager){
		return intermanagerComponent.updateIntermanager(intermanager);
	
	}

		
	/**
	 * 修改 接口管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntermanagerIgnoreNull(Intermanager intermanager){
			return intermanagerComponent.updateIntermanagerIgnoreNull(intermanager);
	
	}
	
	/**
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,int limit,int offset){
		return intermanagerComponent.findAllIntermanager(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 接口管理
	 * @param id
	 * @return
	 */
	public Intermanager findIntermanager(long id){
		return intermanagerComponent.findIntermanager(id);
	}
	
	/** 
	 * 查找 接口管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntermanagerForPageinfo(String where, String orderby,PageInfo pageinfo){
		return intermanagerComponent.findAllIntermanager(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找接口管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanagerBySql(String sql,int limit,int offset){
		return intermanagerComponent.findAllIntermanager(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 接口管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntermanagerBySql(String sql){
		return intermanagerComponent.excuteIntermanagerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntermanagerBySql(String sql){
		return intermanagerComponent.countIntermanagerBySql(sql);
	}
	
	
	/**
	 * 执行sql返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultBySql(String sql,PageInfo pageinfo){
		return intermanagerComponent.findMapResultBySql(sql,pageinfo);
	}
	
	/**
	 * 执行存贮过程返回动态结果集
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultByProcedure(String procedure){
			return intermanagerComponent.findMapResultByProcedure(procedure);
	}
private IAdvertisementComponent advertisementComponent;
	  
 	
 	public IAdvertisementComponent getAdvertisementComponent() {
		return advertisementComponent;
	}
	public void setAdvertisementComponent(IAdvertisementComponent  advertisementComponent) {
		this.advertisementComponent = advertisementComponent;
	}
	/**
	 * 创建 广告表
	 * @param id
	 * @return deleted count 
	 */
	public Advertisement createAdvertisement(Advertisement advertisement) throws SQLException{
	
		return advertisementComponent.createAdvertisement(advertisement);
	}
	/**
	 * 删除 广告表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdvertisement(long id){
	
		return advertisementComponent.deleteAdvertisement(id);
	}
	
	
	/**
	 * 修改 广告表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdvertisement(Advertisement advertisement){
		return advertisementComponent.updateAdvertisement(advertisement);
	
	}

		
	/**
	 * 修改 广告表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdvertisementIgnoreNull(Advertisement advertisement){
			return advertisementComponent.updateAdvertisementIgnoreNull(advertisement);
	
	}
	
	/**
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,int limit,int offset){
		return advertisementComponent.findAllAdvertisement(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 广告表
	 * @param id
	 * @return
	 */
	public Advertisement findAdvertisement(long id){
		return advertisementComponent.findAdvertisement(id);
	}
	
	/** 
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdvertisementForPageinfo(String where, String orderby,PageInfo pageinfo){
		return advertisementComponent.findAllAdvertisement(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找广告表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisementBySql(String sql,int limit,int offset){
		return advertisementComponent.findAllAdvertisement(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 广告表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdvertisementBySql(String sql){
		return advertisementComponent.excuteAdvertisementBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdvertisementBySql(String sql){
		return advertisementComponent.countAdvertisementBySql(sql);
	}
	private IEterminfoComponent eterminfoComponent;
	  
 	
 	public IEterminfoComponent getEterminfoComponent() {
		return eterminfoComponent;
	}
	public void setEterminfoComponent(IEterminfoComponent  eterminfoComponent) {
		this.eterminfoComponent = eterminfoComponent;
	}
	/**
	 * 创建 配置表
	 * @param id
	 * @return deleted count 
	 */
	public Eterminfo createEterminfo(Eterminfo eterminfo) throws SQLException{
	
		return eterminfoComponent.createEterminfo(eterminfo);
	}
	/**
	 * 删除 配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEterminfo(long id){
	
		return eterminfoComponent.deleteEterminfo(id);
	}
	
	
	/**
	 * 修改 配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateEterminfo(Eterminfo eterminfo){
		return eterminfoComponent.updateEterminfo(eterminfo);
	
	}

		
	/**
	 * 修改 配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEterminfoIgnoreNull(Eterminfo eterminfo){
			return eterminfoComponent.updateEterminfoIgnoreNull(eterminfo);
	
	}
	
	/**
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,int limit,int offset){
		return eterminfoComponent.findAllEterminfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 配置表
	 * @param id
	 * @return
	 */
	public Eterminfo findEterminfo(long id){
		return eterminfoComponent.findEterminfo(id);
	}
	
	/** 
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEterminfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return eterminfoComponent.findAllEterminfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfoBySql(String sql,int limit,int offset){
		return eterminfoComponent.findAllEterminfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEterminfoBySql(String sql){
		return eterminfoComponent.excuteEterminfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEterminfoBySql(String sql){
		return eterminfoComponent.countEterminfoBySql(sql);
	}
	
	private IOptrecordComponent optrecordComponent;
	  
 	
 	public IOptrecordComponent getOptrecordComponent() {
		return optrecordComponent;
	}
	public void setOptrecordComponent(IOptrecordComponent  optrecordComponent) {
		this.optrecordComponent = optrecordComponent;
	}
	/**
	 * 创建 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public Optrecord createOptrecord(Optrecord optrecord) throws SQLException{
	
		return optrecordComponent.createOptrecord(optrecord);
	}
	/**
	 * 删除 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOptrecord(long id){
	
		return optrecordComponent.deleteOptrecord(id);
	}
	
	
	/**
	 * 修改 操作记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateOptrecord(Optrecord optrecord){
		return optrecordComponent.updateOptrecord(optrecord);
	
	}

		
	/**
	 * 修改 操作记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOptrecordIgnoreNull(Optrecord optrecord){
			return optrecordComponent.updateOptrecordIgnoreNull(optrecord);
	
	}
	
	/**
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,int limit,int offset){
		return optrecordComponent.findAllOptrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 操作记录表
	 * @param id
	 * @return
	 */
	public Optrecord findOptrecord(long id){
		return optrecordComponent.findOptrecord(id);
	}
	
	/** 
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOptrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return optrecordComponent.findAllOptrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找操作记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecordBySql(String sql,int limit,int offset){
		return optrecordComponent.findAllOptrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 操作记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOptrecordBySql(String sql){
		return optrecordComponent.excuteOptrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOptrecordBySql(String sql){
		return optrecordComponent.countOptrecordBySql(sql);
	}
	@Override
	public List findMapResultSortBySql(String sql, String orderby, PageInfo pageinfo) {
		return intermanagerComponent.findMapResultSortBySql(sql,orderby,pageinfo);
	}
	
	
	
	private IGiftcatalogComponent giftcatalogComponent;
	  
 	
 	public IGiftcatalogComponent getGiftcatalogComponent() {
		return giftcatalogComponent;
	}
	public void setGiftcatalogComponent(IGiftcatalogComponent  giftcatalogComponent) {
		this.giftcatalogComponent = giftcatalogComponent;
	}
	/**
	 * 创建 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public Giftcatalog createGiftcatalog(Giftcatalog giftcatalog) throws SQLException{
	
		return giftcatalogComponent.createGiftcatalog(giftcatalog);
	}
	/**
	 * 删除 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGiftcatalog(long id){
	
		return giftcatalogComponent.deleteGiftcatalog(id);
	}
	
	
	/**
	 * 修改 礼品目录
	 * @param id
	 * @return updated count 
	 */
	public int updateGiftcatalog(Giftcatalog giftcatalog){
		return giftcatalogComponent.updateGiftcatalog(giftcatalog);
	
	}

		
	/**
	 * 修改 礼品目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftcatalogIgnoreNull(Giftcatalog giftcatalog){
			return giftcatalogComponent.updateGiftcatalogIgnoreNull(giftcatalog);
	
	}
	
	/**
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,int limit,int offset){
		return giftcatalogComponent.findAllGiftcatalog(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 礼品目录
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalog(long id){
		return giftcatalogComponent.findGiftcatalog(id);
	}
	
	/**
	 * 查找 礼品目录
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalogbylanguage(long id,Integer language){
		return giftcatalogComponent.findGiftcatalogbylanguage(id,language);
	}
	/** 
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftcatalogForPageinfo(String where, String orderby,PageInfo pageinfo){
		return giftcatalogComponent.findAllGiftcatalog(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找礼品目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalogBySql(String sql,int limit,int offset){
		return giftcatalogComponent.findAllGiftcatalog(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 礼品目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftcatalogBySql(String sql){
		return giftcatalogComponent.excuteGiftcatalogBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftcatalogBySql(String sql){
		return giftcatalogComponent.countGiftcatalogBySql(sql);
	}
	
	private IGiftComponent giftComponent;
	  
 	
 	public IGiftComponent getGiftComponent() {
		return giftComponent;
	}
	public void setGiftComponent(IGiftComponent  giftComponent) {
		this.giftComponent = giftComponent;
	}
	/**
	 * 创建 礼品
	 * @param id
	 * @return deleted count 
	 */
	public Gift createGift(Gift gift) throws SQLException{
	
		return giftComponent.createGift(gift);
	}
	/**
	 * 删除 礼品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGift(long id){
	
		return giftComponent.deleteGift(id);
	}
	
	
	/**
	 * 修改 礼品
	 * @param id
	 * @return updated count 
	 */
	public int updateGift(Gift gift){
		return giftComponent.updateGift(gift);
	
	}

		
	/**
	 * 修改 礼品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftIgnoreNull(Gift gift){
			return giftComponent.updateGiftIgnoreNull(gift);
	
	}
	
	/**
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String where, String orderby,int limit,int offset){
		return giftComponent.findAllGift(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGift(long id){
		return giftComponent.findGift(id);
	}
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGiftbylanguage(long id,Integer language){
		return giftComponent.findGiftbylanguage(id,language);
	}
	/** 
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftForPageinfo(String where, String orderby,PageInfo pageinfo){
		return giftComponent.findAllGift(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找礼品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftBySql(String sql,int limit,int offset){
		return giftComponent.findAllGift(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 礼品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftBySql(String sql){
		return giftComponent.excuteGiftBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftBySql(String sql){
		return giftComponent.countGiftBySql(sql);
	}
	
	
private IRedeemComponent redeemComponent;
	  
 	
 	public IRedeemComponent getRedeemComponent() {
		return redeemComponent;
	}
	public void setRedeemComponent(IRedeemComponent  redeemComponent) {
		this.redeemComponent = redeemComponent;
	}
	/**
	 * 创建 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public Redeem createRedeem(Redeem redeem) throws SQLException{
	
		return redeemComponent.createRedeem(redeem);
	}
	/**
	 * 删除 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRedeem(long id){
	
		return redeemComponent.deleteRedeem(id);
	}
	
	
	/**
	 * 修改 积分兑换
	 * @param id
	 * @return updated count 
	 */
	public int updateRedeem(Redeem redeem){
		return redeemComponent.updateRedeem(redeem);
	
	}

		
	/**
	 * 修改 积分兑换但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRedeemIgnoreNull(Redeem redeem){
			return redeemComponent.updateRedeemIgnoreNull(redeem);
	
	}
	
	/**
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,int limit,int offset){
		return redeemComponent.findAllRedeem(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分兑换
	 * @param id
	 * @return
	 */
	public Redeem findRedeem(long id){
		return redeemComponent.findRedeem(id);
	}
	
	/** 
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRedeemForPageinfo(String where, String orderby,PageInfo pageinfo){
		return redeemComponent.findAllRedeem(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分兑换
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeemBySql(String sql,int limit,int offset){
		return redeemComponent.findAllRedeem(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分兑换
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRedeemBySql(String sql){
		return redeemComponent.excuteRedeemBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRedeemBySql(String sql){
		return redeemComponent.countRedeemBySql(sql);
	}
	
	
	
private IDnsmaintenanceComponent dnsmaintenanceComponent;
	  
 	
 	public IDnsmaintenanceComponent getDnsmaintenanceComponent() {
		return dnsmaintenanceComponent;
	}
	public void setDnsmaintenanceComponent(IDnsmaintenanceComponent  dnsmaintenanceComponent) {
		this.dnsmaintenanceComponent = dnsmaintenanceComponent;
	}
	/**
	 * 创建 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public Dnsmaintenance createDnsmaintenance(Dnsmaintenance dnsmaintenance) throws SQLException{
	
		return dnsmaintenanceComponent.createDnsmaintenance(dnsmaintenance);
	}
	/**
	 * 删除 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDnsmaintenance(long id){
	
		return dnsmaintenanceComponent.deleteDnsmaintenance(id);
	}
	
	
	/**
	 * 修改 分销商DNSLOGO维护
	 * @param id
	 * @return updated count 
	 */
	public int updateDnsmaintenance(Dnsmaintenance dnsmaintenance){
		return dnsmaintenanceComponent.updateDnsmaintenance(dnsmaintenance);
	
	}

		
	/**
	 * 修改 分销商DNSLOGO维护但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDnsmaintenanceIgnoreNull(Dnsmaintenance dnsmaintenance){
			return dnsmaintenanceComponent.updateDnsmaintenanceIgnoreNull(dnsmaintenance);
	
	}
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,int limit,int offset){
		return dnsmaintenanceComponent.findAllDnsmaintenance(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param id
	 * @return
	 */
	public Dnsmaintenance findDnsmaintenance(long id){
		return dnsmaintenanceComponent.findDnsmaintenance(id);
	}
	
	/** 
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDnsmaintenanceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return dnsmaintenanceComponent.findAllDnsmaintenance(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找分销商DNSLOGO维护
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenanceBySql(String sql,int limit,int offset){
		return dnsmaintenanceComponent.findAllDnsmaintenance(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 分销商DNSLOGO维护
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDnsmaintenanceBySql(String sql){
		return dnsmaintenanceComponent.excuteDnsmaintenanceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDnsmaintenanceBySql(String sql){
		return dnsmaintenanceComponent.countDnsmaintenanceBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IEaccountComponent eaccountComponent;
	  
 	
 	public IEaccountComponent getEaccountComponent() {
		return eaccountComponent;
	}
	public void setEaccountComponent(IEaccountComponent  eaccountComponent) {
		this.eaccountComponent = eaccountComponent;
	}
	/**
	 * 创建 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public Eaccount createEaccount(Eaccount eaccount) throws SQLException{
	
		return eaccountComponent.createEaccount(eaccount);
	}
	/**
	 * 删除 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEaccount(long id){
	
		return eaccountComponent.deleteEaccount(id);
	}
	
	
	/**
	 * 修改 外部账号
	 * @param id
	 * @return updated count 
	 */
	public int updateEaccount(Eaccount eaccount){
		return eaccountComponent.updateEaccount(eaccount);
	
	}

		
	/**
	 * 修改 外部账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEaccountIgnoreNull(Eaccount eaccount){
			return eaccountComponent.updateEaccountIgnoreNull(eaccount);
	
	}
	
	/**
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,int limit,int offset){
		return eaccountComponent.findAllEaccount(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 外部账号
	 * @param id
	 * @return
	 */
	public Eaccount findEaccount(long id){
		return eaccountComponent.findEaccount(id);
	}
	
	/** 
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEaccountForPageinfo(String where, String orderby,PageInfo pageinfo){
		return eaccountComponent.findAllEaccount(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找外部账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccountBySql(String sql,int limit,int offset){
		return eaccountComponent.findAllEaccount(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 外部账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEaccountBySql(String sql){
		return eaccountComponent.excuteEaccountBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEaccountBySql(String sql){
		return eaccountComponent.countEaccountBySql(sql);
	}
	@Override
	public <T> T getTObject(Class<T> cls, long id, String... clos) {
		return this.intermanagerComponent.getTObject(cls,id, clos);
	}
	@Override
	public List findMapResultPageByProcedure(String tableName, String fldName,
			String fldSort, int sort, String where, String fldID,
			PageInfo pageinfo) {
		return intermanagerComponent.findMapResultPageByProcedure(tableName, fldName, fldSort, sort, where, fldID, pageinfo);
	}
	
	



	
}
