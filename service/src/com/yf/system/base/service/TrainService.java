package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.train.ITrainComponent;
import com.yf.system.base.train.Train;
import com.yf.system.base.traincity.ITraincityComponent;
import com.yf.system.base.traincity.Traincity;
import com.yf.system.base.trainfare.ITrainfareComponent;
import com.yf.system.base.trainfare.Trainfare;
import com.yf.system.base.traininfo.ITraininfoComponent;
import com.yf.system.base.traininfo.Traininfo;
import com.yf.system.base.trainpassenger.ITrainpassengerComponent;
import com.yf.system.base.trainpassenger.Trainpassenger;
import com.yf.system.base.trainroom.ITrainroomComponent;
import com.yf.system.base.trainroom.Trainroom;
import com.yf.system.base.trainsch.ITrainschComponent;
import com.yf.system.base.trainsch.Trainsch;
import com.yf.system.base.trainseat.ITrainseatComponent;
import com.yf.system.base.trainseat.Trainseat;
import com.yf.system.base.trainstation.ITrainstationComponent;
import com.yf.system.base.trainstation.Trainstation;
import com.yf.system.base.util.PageInfo;

public class TrainService implements ITrainService{
	
private ITrainComponent trainComponent;
	  
 	
 	public ITrainComponent getTrainComponent() {
		return trainComponent;
	}
	public void setTrainComponent(ITrainComponent  trainComponent) {
		this.trainComponent = trainComponent;
	}
	/**
	 * 创建 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public Train createTrain(Train train) throws SQLException{
	
		return trainComponent.createTrain(train);
	}
	/**
	 * 删除 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrain(long id){
	
		return trainComponent.deleteTrain(id);
	}
	
	
	/**
	 * 修改 火车时刻表
	 * @param id
	 * @return updated count 
	 */
	public int updateTrain(Train train){
		return trainComponent.updateTrain(train);
	
	}

		
	/**
	 * 修改 火车时刻表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainIgnoreNull(Train train){
			return trainComponent.updateTrainIgnoreNull(train);
	
	}
	
	/**
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String where, String orderby,int limit,int offset){
		return trainComponent.findAllTrain(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车时刻表
	 * @param id
	 * @return
	 */
	public Train findTrain(long id){
		return trainComponent.findTrain(id);
	}
	
	/** 
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainComponent.findAllTrain(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车时刻表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainBySql(String sql,int limit,int offset){
		return trainComponent.findAllTrain(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车时刻表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainBySql(String sql){
		return trainComponent.excuteTrainBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainBySql(String sql){
		return trainComponent.countTrainBySql(sql);
	}
	
	
	
private ITrainpassengerComponent trainpassengerComponent;
	  
 	
 	public ITrainpassengerComponent getTrainpassengerComponent() {
		return trainpassengerComponent;
	}
	public void setTrainpassengerComponent(ITrainpassengerComponent  trainpassengerComponent) {
		this.trainpassengerComponent = trainpassengerComponent;
	}
	/**
	 * 创建 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public Trainpassenger createTrainpassenger(Trainpassenger trainpassenger) throws SQLException{
	
		return trainpassengerComponent.createTrainpassenger(trainpassenger);
	}
	/**
	 * 删除 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainpassenger(long id){
	
		return trainpassengerComponent.deleteTrainpassenger(id);
	}
	
	
	/**
	 * 修改 火车票乘客
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainpassenger(Trainpassenger trainpassenger){
		return trainpassengerComponent.updateTrainpassenger(trainpassenger);
	
	}

		
	/**
	 * 修改 火车票乘客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainpassengerIgnoreNull(Trainpassenger trainpassenger){
			return trainpassengerComponent.updateTrainpassengerIgnoreNull(trainpassenger);
	
	}
	
	/**
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,int limit,int offset){
		return trainpassengerComponent.findAllTrainpassenger(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车票乘客
	 * @param id
	 * @return
	 */
	public Trainpassenger findTrainpassenger(long id){
		return trainpassengerComponent.findTrainpassenger(id);
	}
	
	/** 
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainpassengerForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainpassengerComponent.findAllTrainpassenger(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车票乘客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassengerBySql(String sql,int limit,int offset){
		return trainpassengerComponent.findAllTrainpassenger(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车票乘客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainpassengerBySql(String sql){
		return trainpassengerComponent.excuteTrainpassengerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainpassengerBySql(String sql){
		return trainpassengerComponent.countTrainpassengerBySql(sql);
	}
	
	
	
private ITrainroomComponent trainroomComponent;
	  
 	
 	public ITrainroomComponent getTrainroomComponent() {
		return trainroomComponent;
	}
	public void setTrainroomComponent(ITrainroomComponent  trainroomComponent) {
		this.trainroomComponent = trainroomComponent;
	}
	/**
	 * 创建 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public Trainroom createTrainroom(Trainroom trainroom) throws SQLException{
	
		return trainroomComponent.createTrainroom(trainroom);
	}
	/**
	 * 删除 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainroom(long id){
	
		return trainroomComponent.deleteTrainroom(id);
	}
	
	
	/**
	 * 修改 火车售票点
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainroom(Trainroom trainroom){
		return trainroomComponent.updateTrainroom(trainroom);
	
	}

		
	/**
	 * 修改 火车售票点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainroomIgnoreNull(Trainroom trainroom){
			return trainroomComponent.updateTrainroomIgnoreNull(trainroom);
	
	}
	
	/**
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,int limit,int offset){
		return trainroomComponent.findAllTrainroom(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车售票点
	 * @param id
	 * @return
	 */
	public Trainroom findTrainroom(long id){
		return trainroomComponent.findTrainroom(id);
	}
	
	/** 
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainroomForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainroomComponent.findAllTrainroom(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车售票点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroomBySql(String sql,int limit,int offset){
		return trainroomComponent.findAllTrainroom(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车售票点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainroomBySql(String sql){
		return trainroomComponent.excuteTrainroomBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainroomBySql(String sql){
		return trainroomComponent.countTrainroomBySql(sql);
	}
	
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITraincityComponent traincityComponent;
	  
 	
 	public ITraincityComponent getTraincityComponent() {
		return traincityComponent;
	}
	public void setTraincityComponent(ITraincityComponent  traincityComponent) {
		this.traincityComponent = traincityComponent;
	}
	/**
	 * 创建 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public Traincity createTraincity(Traincity traincity) throws SQLException{
	
		return traincityComponent.createTraincity(traincity);
	}
	/**
	 * 删除 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraincity(long id){
	
		return traincityComponent.deleteTraincity(id);
	}
	
	
	/**
	 * 修改 火车票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateTraincity(Traincity traincity){
		return traincityComponent.updateTraincity(traincity);
	
	}

		
	/**
	 * 修改 火车票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraincityIgnoreNull(Traincity traincity){
			return traincityComponent.updateTraincityIgnoreNull(traincity);
	
	}
	
	/**
	 * 查找 火车票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraincity(String where, String orderby,int limit,int offset){
		return traincityComponent.findAllTraincity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车票城市
	 * @param id
	 * @return
	 */
	public Traincity findTraincity(long id){
		return traincityComponent.findTraincity(id);
	}
	
	/** 
	 * 查找 火车票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraincityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return traincityComponent.findAllTraincity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraincityBySql(String sql,int limit,int offset){
		return traincityComponent.findAllTraincity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraincityBySql(String sql){
		return traincityComponent.excuteTraincityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraincityBySql(String sql){
		return traincityComponent.countTraincityBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITrainstationComponent trainstationComponent;
	  
 	
 	public ITrainstationComponent getTrainstationComponent() {
		return trainstationComponent;
	}
	public void setTrainstationComponent(ITrainstationComponent  trainstationComponent) {
		this.trainstationComponent = trainstationComponent;
	}
	/**
	 * 创建 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public Trainstation createTrainstation(Trainstation trainstation) throws SQLException{
	
		return trainstationComponent.createTrainstation(trainstation);
	}
	/**
	 * 删除 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainstation(long id){
	
		return trainstationComponent.deleteTrainstation(id);
	}
	
	
	/**
	 * 修改 火车站信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainstation(Trainstation trainstation){
		return trainstationComponent.updateTrainstation(trainstation);
	
	}

		
	/**
	 * 修改 火车站信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainstationIgnoreNull(Trainstation trainstation){
			return trainstationComponent.updateTrainstationIgnoreNull(trainstation);
	
	}
	
	/**
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,int limit,int offset){
		return trainstationComponent.findAllTrainstation(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车站信息
	 * @param id
	 * @return
	 */
	public Trainstation findTrainstation(long id){
		return trainstationComponent.findTrainstation(id);
	}
	
	/** 
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainstationForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainstationComponent.findAllTrainstation(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车站信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstationBySql(String sql,int limit,int offset){
		return trainstationComponent.findAllTrainstation(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车站信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainstationBySql(String sql){
		return trainstationComponent.excuteTrainstationBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainstationBySql(String sql){
		return trainstationComponent.countTrainstationBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITrainseatComponent trainseatComponent;
	  
 	
 	public ITrainseatComponent getTrainseatComponent() {
		return trainseatComponent;
	}
	public void setTrainseatComponent(ITrainseatComponent  trainseatComponent) {
		this.trainseatComponent = trainseatComponent;
	}
	/**
	 * 创建 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public Trainseat createTrainseat(Trainseat trainseat) throws SQLException{
	
		return trainseatComponent.createTrainseat(trainseat);
	}
	/**
	 * 删除 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainseat(long id){
	
		return trainseatComponent.deleteTrainseat(id);
	}
	
	
	/**
	 * 修改 火车席别
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainseat(Trainseat trainseat){
		return trainseatComponent.updateTrainseat(trainseat);
	
	}

		
	/**
	 * 修改 火车席别但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainseatIgnoreNull(Trainseat trainseat){
			return trainseatComponent.updateTrainseatIgnoreNull(trainseat);
	
	}
	
	/**
	 * 查找 火车席别
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainseat(String where, String orderby,int limit,int offset){
		return trainseatComponent.findAllTrainseat(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车席别
	 * @param id
	 * @return
	 */
	public Trainseat findTrainseat(long id){
		return trainseatComponent.findTrainseat(id);
	}
	
	/** 
	 * 查找 火车席别
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainseatForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainseatComponent.findAllTrainseat(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车席别
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainseatBySql(String sql,int limit,int offset){
		return trainseatComponent.findAllTrainseat(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车席别
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainseatBySql(String sql){
		return trainseatComponent.excuteTrainseatBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainseatBySql(String sql){
		return trainseatComponent.countTrainseatBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITrainschComponent trainschComponent;
	  
 	
 	public ITrainschComponent getTrainschComponent() {
		return trainschComponent;
	}
	public void setTrainschComponent(ITrainschComponent  trainschComponent) {
		this.trainschComponent = trainschComponent;
	}
	/**
	 * 创建 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public Trainsch createTrainsch(Trainsch trainsch) throws SQLException{
	
		return trainschComponent.createTrainsch(trainsch);
	}
	/**
	 * 删除 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainsch(long id){
	
		return trainschComponent.deleteTrainsch(id);
	}
	
	
	/**
	 * 修改 列车时刻
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainsch(Trainsch trainsch){
		return trainschComponent.updateTrainsch(trainsch);
	
	}

		
	/**
	 * 修改 列车时刻但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainschIgnoreNull(Trainsch trainsch){
			return trainschComponent.updateTrainschIgnoreNull(trainsch);
	
	}
	
	/**
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainsch(String where, String orderby,int limit,int offset){
		return trainschComponent.findAllTrainsch(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 列车时刻
	 * @param id
	 * @return
	 */
	public Trainsch findTrainsch(long id){
		return trainschComponent.findTrainsch(id);
	}
	
	/** 
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainschForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainschComponent.findAllTrainsch(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找列车时刻
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainschBySql(String sql,int limit,int offset){
		return trainschComponent.findAllTrainsch(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 列车时刻
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainschBySql(String sql){
		return trainschComponent.excuteTrainschBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainschBySql(String sql){
		return trainschComponent.countTrainschBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITraininfoComponent traininfoComponent;
	  
 	
 	public ITraininfoComponent getTraininfoComponent() {
		return traininfoComponent;
	}
	public void setTraininfoComponent(ITraininfoComponent  traininfoComponent) {
		this.traininfoComponent = traininfoComponent;
	}
	/**
	 * 创建 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public Traininfo createTraininfo(Traininfo traininfo) throws SQLException{
	
		return traininfoComponent.createTraininfo(traininfo);
	}
	/**
	 * 删除 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraininfo(long id){
	
		return traininfoComponent.deleteTraininfo(id);
	}
	
	
	/**
	 * 修改 车次信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTraininfo(Traininfo traininfo){
		return traininfoComponent.updateTraininfo(traininfo);
	
	}

		
	/**
	 * 修改 车次信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraininfoIgnoreNull(Traininfo traininfo){
			return traininfoComponent.updateTraininfoIgnoreNull(traininfo);
	
	}
	
	/**
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfo(String where, String orderby,int limit,int offset){
		return traininfoComponent.findAllTraininfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 车次信息
	 * @param id
	 * @return
	 */
	public Traininfo findTraininfo(long id){
		return traininfoComponent.findTraininfo(id);
	}
	
	/** 
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraininfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return traininfoComponent.findAllTraininfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找车次信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfoBySql(String sql,int limit,int offset){
		return traininfoComponent.findAllTraininfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 车次信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraininfoBySql(String sql){
		return traininfoComponent.excuteTraininfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraininfoBySql(String sql){
		return traininfoComponent.countTraininfoBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITrainfareComponent trainfareComponent;
	  
 	
 	public ITrainfareComponent getTrainfareComponent() {
		return trainfareComponent;
	}
	public void setTrainfareComponent(ITrainfareComponent  trainfareComponent) {
		this.trainfareComponent = trainfareComponent;
	}
	/**
	 * 创建 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public Trainfare createTrainfare(Trainfare trainfare) throws SQLException{
	
		return trainfareComponent.createTrainfare(trainfare);
	}
	/**
	 * 删除 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainfare(long id){
	
		return trainfareComponent.deleteTrainfare(id);
	}
	
	
	/**
	 * 修改 火车票价
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainfare(Trainfare trainfare){
		return trainfareComponent.updateTrainfare(trainfare);
	
	}

		
	/**
	 * 修改 火车票价但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainfareIgnoreNull(Trainfare trainfare){
			return trainfareComponent.updateTrainfareIgnoreNull(trainfare);
	
	}
	
	/**
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,int limit,int offset){
		return trainfareComponent.findAllTrainfare(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 火车票价
	 * @param id
	 * @return
	 */
	public Trainfare findTrainfare(long id){
		return trainfareComponent.findTrainfare(id);
	}
	
	/** 
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainfareForPageinfo(String where, String orderby,PageInfo pageinfo){
		return trainfareComponent.findAllTrainfare(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找火车票价
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfareBySql(String sql,int limit,int offset){
		return trainfareComponent.findAllTrainfare(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 火车票价
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainfareBySql(String sql){
		return trainfareComponent.excuteTrainfareBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainfareBySql(String sql){
		return trainfareComponent.countTrainfareBySql(sql);
	}
	
	

	

}
