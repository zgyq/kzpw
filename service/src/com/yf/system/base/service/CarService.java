package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.carbrand.Carbrand;
import com.yf.system.base.carbrand.ICarbrandComponent;
import com.yf.system.base.carimages.Carimages;
import com.yf.system.base.carimages.ICarimagesComponent;
import com.yf.system.base.carinfo.Carinfo;
import com.yf.system.base.carinfo.ICarinfoComponent;
import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.carorder.ICarorderComponent;
import com.yf.system.base.cars.Cars;
import com.yf.system.base.cars.ICarsComponent;
import com.yf.system.base.carsregion.Carsregion;
import com.yf.system.base.carsregion.ICarsregionComponent;
import com.yf.system.base.carstore.Carstore;
import com.yf.system.base.carstore.ICarstoreComponent;
import com.yf.system.base.util.PageInfo;

public class CarService implements ICarService {
//粘贴到Service实现类
	
	private ICarsComponent carsComponent;
	  
 	
 	public ICarsComponent getCarsComponent() {
		return carsComponent;
	}
	public void setCarsComponent(ICarsComponent  carsComponent) {
		this.carsComponent = carsComponent;
	}
	/**
	 * 创建 汽车
	 * @param id
	 * @return deleted count 
	 */
	public Cars createCars(Cars cars) throws SQLException{
	
		return carsComponent.createCars(cars);
	}
	/**
	 * 删除 汽车
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCars(long id){
	
		return carsComponent.deleteCars(id);
	}
	
	
	/**
	 * 修改 汽车
	 * @param id
	 * @return updated count 
	 */
	public int updateCars(Cars cars){
		return carsComponent.updateCars(cars);
	
	}

		
	/**
	 * 修改 汽车但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsIgnoreNull(Cars cars){
			return carsComponent.updateCarsIgnoreNull(cars);
	
	}
	
	/**
	 * 查找 汽车
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCars(String where, String orderby,int limit,int offset){
		return carsComponent.findAllCars(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车
	 * @param id
	 * @return
	 */
	public Cars findCars(long id){
		return carsComponent.findCars(id);
	}
	
	/** 
	 * 查找 汽车
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarsForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carsComponent.findAllCars(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsBySql(String sql,int limit,int offset){
		return carsComponent.findAllCars(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsBySql(String sql){
		return carsComponent.excuteCarsBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsBySql(String sql){
		return carsComponent.countCarsBySql(sql);
	}
	
//粘贴到Service实现类
	
	private ICarimagesComponent carimagesComponent;
	  
 	
 	public ICarimagesComponent getCarimagesComponent() {
		return carimagesComponent;
	}
	public void setCarimagesComponent(ICarimagesComponent  carimagesComponent) {
		this.carimagesComponent = carimagesComponent;
	}
	/**
	 * 创建 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public Carimages createCarimages(Carimages carimages) throws SQLException{
	
		return carimagesComponent.createCarimages(carimages);
	}
	/**
	 * 删除 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarimages(long id){
	
		return carimagesComponent.deleteCarimages(id);
	}
	
	
	/**
	 * 修改 汽车图片
	 * @param id
	 * @return updated count 
	 */
	public int updateCarimages(Carimages carimages){
		return carimagesComponent.updateCarimages(carimages);
	
	}

		
	/**
	 * 修改 汽车图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarimagesIgnoreNull(Carimages carimages){
			return carimagesComponent.updateCarimagesIgnoreNull(carimages);
	
	}
	
	/**
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,int limit,int offset){
		return carimagesComponent.findAllCarimages(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车图片
	 * @param id
	 * @return
	 */
	public Carimages findCarimages(long id){
		return carimagesComponent.findCarimages(id);
	}
	
	/** 
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarimagesForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carimagesComponent.findAllCarimages(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimagesBySql(String sql,int limit,int offset){
		return carimagesComponent.findAllCarimages(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarimagesBySql(String sql){
		return carimagesComponent.excuteCarimagesBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarimagesBySql(String sql){
		return carimagesComponent.countCarimagesBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICarorderComponent carorderComponent;
	  
 	
 	public ICarorderComponent getCarorderComponent() {
		return carorderComponent;
	}
	public void setCarorderComponent(ICarorderComponent  carorderComponent) {
		this.carorderComponent = carorderComponent;
	}
	/**
	 * 创建 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public Carorder createCarorder(Carorder carorder) throws SQLException{
	
		return carorderComponent.createCarorder(carorder);
	}
	/**
	 * 删除 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarorder(long id){
	
		return carorderComponent.deleteCarorder(id);
	}
	
	
	/**
	 * 修改 租车订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCarorder(Carorder carorder){
		return carorderComponent.updateCarorder(carorder);
	
	}

		
	/**
	 * 修改 租车订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarorderIgnoreNull(Carorder carorder){
			return carorderComponent.updateCarorderIgnoreNull(carorder);
	
	}
	
	/**
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,int limit,int offset){
		return carorderComponent.findAllCarorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 租车订单
	 * @param id
	 * @return
	 */
	public Carorder findCarorder(long id){
		return carorderComponent.findCarorder(id);
	}
	
	/** 
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carorderComponent.findAllCarorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找租车订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorderBySql(String sql,int limit,int offset){
		return carorderComponent.findAllCarorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 租车订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarorderBySql(String sql){
		return carorderComponent.excuteCarorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarorderBySql(String sql){
		return carorderComponent.countCarorderBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICarstoreComponent carstoreComponent;
	  
 	
 	public ICarstoreComponent getCarstoreComponent() {
		return carstoreComponent;
	}
	public void setCarstoreComponent(ICarstoreComponent  carstoreComponent) {
		this.carstoreComponent = carstoreComponent;
	}
	/**
	 * 创建 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public Carstore createCarstore(Carstore carstore) throws SQLException{
	
		return carstoreComponent.createCarstore(carstore);
	}
	/**
	 * 删除 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarstore(long id){
	
		return carstoreComponent.deleteCarstore(id);
	}
	
	
	/**
	 * 修改 租车门店
	 * @param id
	 * @return updated count 
	 */
	public int updateCarstore(Carstore carstore){
		return carstoreComponent.updateCarstore(carstore);
	
	}

		
	/**
	 * 修改 租车门店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarstoreIgnoreNull(Carstore carstore){
			return carstoreComponent.updateCarstoreIgnoreNull(carstore);
	
	}
	
	/**
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,int limit,int offset){
		return carstoreComponent.findAllCarstore(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 租车门店
	 * @param id
	 * @return
	 */
	public Carstore findCarstore(long id){
		return carstoreComponent.findCarstore(id);
	}
	
	/** 
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarstoreForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carstoreComponent.findAllCarstore(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找租车门店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstoreBySql(String sql,int limit,int offset){
		return carstoreComponent.findAllCarstore(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 租车门店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarstoreBySql(String sql){
		return carstoreComponent.excuteCarstoreBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarstoreBySql(String sql){
		return carstoreComponent.countCarstoreBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICarbrandComponent carbrandComponent;
	  
 	
 	public ICarbrandComponent getCarbrandComponent() {
		return carbrandComponent;
	}
	public void setCarbrandComponent(ICarbrandComponent  carbrandComponent) {
		this.carbrandComponent = carbrandComponent;
	}
	/**
	 * 创建 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public Carbrand createCarbrand(Carbrand carbrand) throws SQLException{
	
		return carbrandComponent.createCarbrand(carbrand);
	}
	/**
	 * 删除 汽车品牌
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarbrand(long id){
	
		return carbrandComponent.deleteCarbrand(id);
	}
	
	
	/**
	 * 修改 汽车品牌
	 * @param id
	 * @return updated count 
	 */
	public int updateCarbrand(Carbrand carbrand){
		return carbrandComponent.updateCarbrand(carbrand);
	
	}

		
	/**
	 * 修改 汽车品牌但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarbrandIgnoreNull(Carbrand carbrand){
			return carbrandComponent.updateCarbrandIgnoreNull(carbrand);
	
	}
	
	/**
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrand(String where, String orderby,int limit,int offset){
		return carbrandComponent.findAllCarbrand(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车品牌
	 * @param id
	 * @return
	 */
	public Carbrand findCarbrand(long id){
		return carbrandComponent.findCarbrand(id);
	}
	
	/** 
	 * 查找 汽车品牌
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarbrandForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carbrandComponent.findAllCarbrand(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车品牌
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarbrandBySql(String sql,int limit,int offset){
		return carbrandComponent.findAllCarbrand(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车品牌
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarbrandBySql(String sql){
		return carbrandComponent.excuteCarbrandBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarbrandBySql(String sql){
		return carbrandComponent.countCarbrandBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICarsregionComponent carsregionComponent;
	  
 	
 	public ICarsregionComponent getCarsregionComponent() {
		return carsregionComponent;
	}
	public void setCarsregionComponent(ICarsregionComponent  carsregionComponent) {
		this.carsregionComponent = carsregionComponent;
	}
	/**
	 * 创建 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public Carsregion createCarsregion(Carsregion carsregion) throws SQLException{
	
		return carsregionComponent.createCarsregion(carsregion);
	}
	/**
	 * 删除 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarsregion(long id){
	
		return carsregionComponent.deleteCarsregion(id);
	}
	
	
	/**
	 * 修改 送车上门区域
	 * @param id
	 * @return updated count 
	 */
	public int updateCarsregion(Carsregion carsregion){
		return carsregionComponent.updateCarsregion(carsregion);
	
	}

		
	/**
	 * 修改 送车上门区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsregionIgnoreNull(Carsregion carsregion){
			return carsregionComponent.updateCarsregionIgnoreNull(carsregion);
	
	}
	
	/**
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,int limit,int offset){
		return carsregionComponent.findAllCarsregion(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 送车上门区域
	 * @param id
	 * @return
	 */
	public Carsregion findCarsregion(long id){
		return carsregionComponent.findCarsregion(id);
	}
	
	/** 
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarsregionForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carsregionComponent.findAllCarsregion(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找送车上门区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregionBySql(String sql,int limit,int offset){
		return carsregionComponent.findAllCarsregion(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 送车上门区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsregionBySql(String sql){
		return carsregionComponent.excuteCarsregionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsregionBySql(String sql){
		return carsregionComponent.countCarsregionBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ICarinfoComponent carinfoComponent;
	  
 	
 	public ICarinfoComponent getCarinfoComponent() {
		return carinfoComponent;
	}
	public void setCarinfoComponent(ICarinfoComponent  carinfoComponent) {
		this.carinfoComponent = carinfoComponent;
	}
	/**
	 * 创建 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public Carinfo createCarinfo(Carinfo carinfo) throws SQLException{
	
		return carinfoComponent.createCarinfo(carinfo);
	}
	/**
	 * 删除 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarinfo(long id){
	
		return carinfoComponent.deleteCarinfo(id);
	}
	
	
	/**
	 * 修改 车型数据
	 * @param id
	 * @return updated count 
	 */
	public int updateCarinfo(Carinfo carinfo){
		return carinfoComponent.updateCarinfo(carinfo);
	
	}

		
	/**
	 * 修改 车型数据但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarinfoIgnoreNull(Carinfo carinfo){
			return carinfoComponent.updateCarinfoIgnoreNull(carinfo);
	
	}
	
	/**
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,int limit,int offset){
		return carinfoComponent.findAllCarinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 车型数据
	 * @param id
	 * @return
	 */
	public Carinfo findCarinfo(long id){
		return carinfoComponent.findCarinfo(id);
	}
	
	/** 
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return carinfoComponent.findAllCarinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找车型数据
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfoBySql(String sql,int limit,int offset){
		return carinfoComponent.findAllCarinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 车型数据
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarinfoBySql(String sql){
		return carinfoComponent.excuteCarinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarinfoBySql(String sql){
		return carinfoComponent.countCarinfoBySql(sql);
	}
	
	








}
