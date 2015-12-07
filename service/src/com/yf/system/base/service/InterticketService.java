package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.fairport.IFairportComponent;
import com.yf.system.base.fairway.Fairway;
import com.yf.system.base.fairway.IFairwayComponent;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.fcity.IFcityComponent;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.fcountry.IFcountryComponent;
import com.yf.system.base.fdeliverassign.Fdeliverassign;
import com.yf.system.base.fdeliverassign.IFdeliverassignComponent;
import com.yf.system.base.fflight.Fflight;
import com.yf.system.base.fflight.IFflightComponent;
import com.yf.system.base.fguest.Fguest;
import com.yf.system.base.fguest.IFguestComponent;
import com.yf.system.base.forderdelrec.Forderdelrec;
import com.yf.system.base.forderdelrec.IForderdelrecComponent;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.forderinfo.IForderinfoComponent;
import com.yf.system.base.fsendticketcity.Fsendticketcity;
import com.yf.system.base.fsendticketcity.IFsendticketcityComponent;
import com.yf.system.base.util.PageInfo;



public class InterticketService implements IInterticketService{
	
	private Map<String,Object> map;
	private boolean cache;
	
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
		
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFairportComponent fairportComponent;
	  
 	
 	public IFairportComponent getFairportComponent() {
		return fairportComponent;
	}
	public void setFairportComponent(IFairportComponent  fairportComponent) {
		this.fairportComponent = fairportComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ链哄満
	 * @param id
	 * @return deleted count 
	 */
	public Fairport createFairport(Fairport fairport) throws SQLException{
	
		return fairportComponent.createFairport(fairport);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ链哄満
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairport(long id){
	
		return fairportComponent.deleteFairport(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ链哄満
	 * @param id
	 * @return updated count 
	 */
	public int updateFairport(Fairport fairport){
		return fairportComponent.updateFairport(fairport);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ链哄満浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFairportIgnoreNull(Fairport fairport){
			return fairportComponent.updateFairportIgnoreNull(fairport);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String where, String orderby,int limit,int offset){
		return fairportComponent.findAllFairport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param id
	 * @return
	 */
	public Fairport findFairport(long id){
		return fairportComponent.findFairport(id);
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param id
	 * @return
	 */
	public Fairport findFairportbylanguage(long id,Integer language){
		return fairportComponent.findFairportbylanguage(id,language);
	}
	/** 
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairportForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fairportComponent.findAllFairport(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ链哄満
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairportBySql(String sql,int limit,int offset){
		return fairportComponent.findAllFairport(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ链哄満
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairportBySql(String sql){
		return fairportComponent.excuteFairportBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairportBySql(String sql){
		return fairportComponent.countFairportBySql(sql);
	}
	
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFairwayComponent fairwayComponent;
	  
 	
 	public IFairwayComponent getFairwayComponent() {
		return fairwayComponent;
	}
	public void setFairwayComponent(IFairwayComponent  fairwayComponent) {
		this.fairwayComponent = fairwayComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return deleted count 
	 */
	public Fairway createFairway(Fairway fairway) throws SQLException{
	
		return fairwayComponent.createFairway(fairway);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairway(long id){
	
		return fairwayComponent.deleteFairway(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return updated count 
	 */
	public int updateFairway(Fairway fairway){
		return fairwayComponent.updateFairway(fairway);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ鑸┖鍏徃浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFairwayIgnoreNull(Fairway fairway){
			return fairwayComponent.updateFairwayIgnoreNull(fairway);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String where, String orderby,int limit,int offset){
		return fairwayComponent.findAllFairway(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return
	 */
	public Fairway findFairway(long id){
		return fairwayComponent.findFairway(id);
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return
	 */
	public Fairway findFairwaybylanguage(long id,Integer language){
		return fairwayComponent.findFairwaybylanguage(id,language);
	}
	/** 
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairwayForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fairwayComponent.findAllFairway(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ鑸┖鍏徃
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairwayBySql(String sql,int limit,int offset){
		return fairwayComponent.findAllFairway(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ鑸┖鍏徃
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairwayBySql(String sql){
		return fairwayComponent.excuteFairwayBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairwayBySql(String sql){
		return fairwayComponent.countFairwayBySql(sql);
	}
	
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFcityComponent fcityComponent;
	  
 	
 	public IFcityComponent getFcityComponent() {
		return fcityComponent;
	}
	public void setFcityComponent(IFcityComponent  fcityComponent) {
		this.fcityComponent = fcityComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public Fcity createFcity(Fcity fcity) throws SQLException{
	
		return fcityComponent.createFcity(fcity);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcity(long id){
	
		return fcityComponent.deleteFcity(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return updated count 
	 */
	public int updateFcity(Fcity fcity){
		return fcityComponent.updateFcity(fcity);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ鍩庡竞浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFcityIgnoreNull(Fcity fcity){
			return fcityComponent.updateFcityIgnoreNull(fcity);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String where, String orderby,int limit,int offset){
		return fcityComponent.findAllFcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fcity findFcity(long id){
		return fcityComponent.findFcity(id);
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fcity findFcitybylanguage(long id,Integer language){
		return fcityComponent.findFcitybylanguage(id,language);
	}
	/** 
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fcityComponent.findAllFcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ鍩庡竞
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcityBySql(String sql,int limit,int offset){
		return fcityComponent.findAllFcity(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ鍩庡竞
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcityBySql(String sql){
		return fcityComponent.excuteFcityBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcityBySql(String sql){
		return fcityComponent.countFcityBySql(sql);
	}
	
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFcountryComponent fcountryComponent;
	  
 	
 	public IFcountryComponent getFcountryComponent() {
		return fcountryComponent;
	}
	public void setFcountryComponent(IFcountryComponent  fcountryComponent) {
		this.fcountryComponent = fcountryComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ锲藉
	 * @param id
	 * @return deleted count 
	 */
	public Fcountry createFcountry(Fcountry fcountry) throws SQLException{
	
		return fcountryComponent.createFcountry(fcountry);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ锲藉
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcountry(long id){
	
		return fcountryComponent.deleteFcountry(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ锲藉
	 * @param id
	 * @return updated count 
	 */
	public int updateFcountry(Fcountry fcountry){
		return fcountryComponent.updateFcountry(fcountry);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ锲藉浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFcountryIgnoreNull(Fcountry fcountry){
			return fcountryComponent.updateFcountryIgnoreNull(fcountry);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ锲藉
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
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param id
	 * @return
	 */
	public Fcountry findFcountry(long id){
		return fcountryComponent.findFcountry(id);
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param id
	 * @return
	 */
	public Fcountry findFcountrybylanguage(long id,Integer language){
		return fcountryComponent.findFcountrybylanguage(id,language);
	}
	/** 
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcountryForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fcountryComponent.findAllFcountry(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ锲藉
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountryBySql(String sql,int limit,int offset){
		return fcountryComponent.findAllFcountry(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ锲藉
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcountryBySql(String sql){
		return fcountryComponent.excuteFcountryBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcountryBySql(String sql){
		return fcountryComponent.countFcountryBySql(sql);
	}
	
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFdeliverassignComponent fdeliverassignComponent;
	  
 	
 	public IFdeliverassignComponent getFdeliverassignComponent() {
		return fdeliverassignComponent;
	}
	public void setFdeliverassignComponent(IFdeliverassignComponent  fdeliverassignComponent) {
		this.fdeliverassignComponent = fdeliverassignComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return deleted count 
	 */
	public Fdeliverassign createFdeliverassign(Fdeliverassign fdeliverassign) throws SQLException{
	
		return fdeliverassignComponent.createFdeliverassign(fdeliverassign);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFdeliverassign(long id){
	
		return fdeliverassignComponent.deleteFdeliverassign(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return updated count 
	 */
	public int updateFdeliverassign(Fdeliverassign fdeliverassign){
		return fdeliverassignComponent.updateFdeliverassign(fdeliverassign);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ閰嶉€佷俊鎭絾蹇界暐绌哄€?
	 * @param id
	 * @return 
	 */
	public int updateFdeliverassignIgnoreNull(Fdeliverassign fdeliverassign){
			return fdeliverassignComponent.updateFdeliverassignIgnoreNull(fdeliverassign);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,int limit,int offset){
		return fdeliverassignComponent.findAllFdeliverassign(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return
	 */
	public Fdeliverassign findFdeliverassign(long id){
		return fdeliverassignComponent.findFdeliverassign(id);
	}
	
	/** 
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFdeliverassignForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fdeliverassignComponent.findAllFdeliverassign(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ閰嶉€佷俊鎭?
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassignBySql(String sql,int limit,int offset){
		return fdeliverassignComponent.findAllFdeliverassign(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFdeliverassignBySql(String sql){
		return fdeliverassignComponent.excuteFdeliverassignBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFdeliverassignBySql(String sql){
		return fdeliverassignComponent.countFdeliverassignBySql(sql);
	}
	
	//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFflightComponent fflightComponent;
	  
 	
 	public IFflightComponent getFflightComponent() {
		return fflightComponent;
	}
	public void setFflightComponent(IFflightComponent  fflightComponent) {
		this.fflightComponent = fflightComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ琛岀▼
	 * @param id
	 * @return deleted count 
	 */
	public Fflight createFflight(Fflight fflight) throws SQLException{
	
		return fflightComponent.createFflight(fflight);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ琛岀▼
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFflight(long id){
	
		return fflightComponent.deleteFflight(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ琛岀▼
	 * @param id
	 * @return updated count 
	 */
	public int updateFflight(Fflight fflight){
		return fflightComponent.updateFflight(fflight);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ琛岀▼浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFflightIgnoreNull(Fflight fflight){
			return fflightComponent.updateFflightIgnoreNull(fflight);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String where, String orderby,int limit,int offset){
		return fflightComponent.findAllFflight(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param id
	 * @return
	 */
	public Fflight findFflight(long id){
		return fflightComponent.findFflight(id);
	}
	
	/** 
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFflightForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fflightComponent.findAllFflight(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ琛岀▼
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflightBySql(String sql,int limit,int offset){
		return fflightComponent.findAllFflight(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ琛岀▼
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFflightBySql(String sql){
		return fflightComponent.excuteFflightBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFflightBySql(String sql){
		return fflightComponent.countFflightBySql(sql);
	}
	
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFguestComponent fguestComponent;
	  
 	
 	public IFguestComponent getFguestComponent() {
		return fguestComponent;
	}
	public void setFguestComponent(IFguestComponent  fguestComponent) {
		this.fguestComponent = fguestComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return deleted count 
	 */
	public Fguest createFguest(Fguest fguest) throws SQLException{
	
		return fguestComponent.createFguest(fguest);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFguest(long id){
	
		return fguestComponent.deleteFguest(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return updated count 
	 */
	public int updateFguest(Fguest fguest){
		return fguestComponent.updateFguest(fguest);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ涔樻満浜鸿〃浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFguestIgnoreNull(Fguest fguest){
			return fguestComponent.updateFguestIgnoreNull(fguest);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String where, String orderby,int limit,int offset){
		return fguestComponent.findAllFguest(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return
	 */
	public Fguest findFguest(long id){
		return fguestComponent.findFguest(id);
	}
	
	/** 
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFguestForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fguestComponent.findAllFguest(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ涔樻満浜鸿〃
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguestBySql(String sql,int limit,int offset){
		return fguestComponent.findAllFguest(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ涔樻満浜鸿〃
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFguestBySql(String sql){
		return fguestComponent.excuteFguestBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFguestBySql(String sql){
		return fguestComponent.countFguestBySql(sql);
	}
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IForderdelrecComponent forderdelrecComponent;
	  
 	
 	public IForderdelrecComponent getForderdelrecComponent() {
		return forderdelrecComponent;
	}
	public void setForderdelrecComponent(IForderdelrecComponent  forderdelrecComponent) {
		this.forderdelrecComponent = forderdelrecComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return deleted count 
	 */
	public Forderdelrec createForderdelrec(Forderdelrec forderdelrec) throws SQLException{
	
		return forderdelrecComponent.createForderdelrec(forderdelrec);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderdelrec(long id){
	
		return forderdelrecComponent.deleteForderdelrec(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return updated count 
	 */
	public int updateForderdelrec(Forderdelrec forderdelrec){
		return forderdelrecComponent.updateForderdelrec(forderdelrec);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟鎿崭綔璁板綍浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateForderdelrecIgnoreNull(Forderdelrec forderdelrec){
			return forderdelrecComponent.updateForderdelrecIgnoreNull(forderdelrec);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,int limit,int offset){
		return forderdelrecComponent.findAllForderdelrec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return
	 */
	public Forderdelrec findForderdelrec(long id){
		return forderdelrecComponent.findForderdelrec(id);
	}
	
	/** 
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderdelrecForPageinfo(String where, String orderby,PageInfo pageinfo){
		return forderdelrecComponent.findAllForderdelrec(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrecBySql(String sql,int limit,int offset){
		return forderdelrecComponent.findAllForderdelrec(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderdelrecBySql(String sql){
		return forderdelrecComponent.excuteForderdelrecBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderdelrecBySql(String sql){
		return forderdelrecComponent.countForderdelrecBySql(sql);
	}
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IForderinfoComponent forderinfoComponent;
	  
 	
 	public IForderinfoComponent getForderinfoComponent() {
		return forderinfoComponent;
	}
	public void setForderinfoComponent(IForderinfoComponent  forderinfoComponent) {
		this.forderinfoComponent = forderinfoComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return deleted count 
	 */
	public Forderinfo createForderinfo(Forderinfo forderinfo) throws SQLException{
	
		return forderinfoComponent.createForderinfo(forderinfo);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderinfo(long id){
	
		return forderinfoComponent.deleteForderinfo(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return updated count 
	 */
	public int updateForderinfo(Forderinfo forderinfo){
		return forderinfoComponent.updateForderinfo(forderinfo);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟琛ㄤ絾蹇界暐绌哄€?
	 * @param id
	 * @return 
	 */
	public int updateForderinfoIgnoreNull(Forderinfo forderinfo){
			return forderinfoComponent.updateForderinfoIgnoreNull(forderinfo);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,int limit,int offset){
		return forderinfoComponent.findAllForderinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return
	 */
	public Forderinfo findForderinfo(long id){
		return forderinfoComponent.findForderinfo(id);
	}
	
	/** 
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return forderinfoComponent.findAllForderinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ璁㈠崟琛?
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfoBySql(String sql,int limit,int offset){
		return forderinfoComponent.findAllForderinfo(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ璁㈠崟琛?
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderinfoBySql(String sql){
		return forderinfoComponent.excuteForderinfoBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderinfoBySql(String sql){
		return forderinfoComponent.countForderinfoBySql(sql);
	}
//绮樿创鍒癝ervice瀹炵幇绫?
	
	private IFsendticketcityComponent fsendticketcityComponent;
	  
 	
 	public IFsendticketcityComponent getFsendticketcityComponent() {
		return fsendticketcityComponent;
	}
	public void setFsendticketcityComponent(IFsendticketcityComponent  fsendticketcityComponent) {
		this.fsendticketcityComponent = fsendticketcityComponent;
	}
	/**
	 * 鍒涘缓 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public Fsendticketcity createFsendticketcity(Fsendticketcity fsendticketcity) throws SQLException{
	
		return fsendticketcityComponent.createFsendticketcity(fsendticketcity);
	}
	/**
	 * 鍒犻櫎 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFsendticketcity(long id){
	
		return fsendticketcityComponent.deleteFsendticketcity(id);
	}
	
	
	/**
	 * 淇敼 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return updated count 
	 */
	public int updateFsendticketcity(Fsendticketcity fsendticketcity){
		return fsendticketcityComponent.updateFsendticketcity(fsendticketcity);
	
	}

		
	/**
	 * 淇敼 锲介台链虹エ阃佺エ鍩庡竞浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFsendticketcityIgnoreNull(Fsendticketcity fsendticketcity){
			return fsendticketcityComponent.updateFsendticketcityIgnoreNull(fsendticketcity);
	
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,int limit,int offset){
		return fsendticketcityComponent.findAllFsendticketcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcity(long id){
		return fsendticketcityComponent.findFsendticketcity(id);
	}
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcitybylanguage(long id,Integer language){
		return fsendticketcityComponent.findFsendticketcitybylanguage(id,language);
	}
	/** 
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFsendticketcityForPageinfo(String where, String orderby,PageInfo pageinfo){
		return fsendticketcityComponent.findAllFsendticketcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ阃佺エ鍩庡竞
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcityBySql(String sql,int limit,int offset){
		return fsendticketcityComponent.findAllFsendticketcity(sql,limit,offset);
	}
	
	
	/**
	 * 镓цSql 锲介台链虹エ阃佺エ鍩庡竞
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFsendticketcityBySql(String sql){
		return fsendticketcityComponent.excuteFsendticketcityBySql(sql);
	}
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFsendticketcityBySql(String sql){
		return fsendticketcityComponent.countFsendticketcityBySql(sql);
	}
	
}
