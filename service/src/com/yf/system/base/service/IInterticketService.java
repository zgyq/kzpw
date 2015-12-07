package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.fairway.Fairway;
import com.yf.system.base.fcity.Fcity;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.fdeliverassign.Fdeliverassign;
import com.yf.system.base.fflight.Fflight;
import com.yf.system.base.fguest.Fguest;
import com.yf.system.base.forderdelrec.Forderdelrec;
import com.yf.system.base.forderinfo.Forderinfo;
import com.yf.system.base.fsendticketcity.Fsendticketcity;
import com.yf.system.base.util.PageInfo;


public interface IInterticketService {
	
	
	public boolean isCache() ;
	//绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ链哄満
	 * @param id
	 * @return deleted count 
	 */
	public Fairport createFairport(Fairport fairport) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ链哄満
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairport(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ链哄満
	 * @param id
	 * @return updated count 
	 */
	public int updateFairport(Fairport fairport);

		
	/**
	 * 淇敼 锲介台链虹エ链哄満浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFairportIgnoreNull(Fairport fairport);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param id
	 * @return
	 */
	public Fairport findFairport(long id);
	
	/**
	 * 镆ユ垒 锲介台链虹エ链哄満 by language
	 * @param id
	 * @return
	 */
	public Fairport findFairportbylanguage(long id ,Integer language);
	
	/** 
	 * 镆ユ垒 锲介台链虹エ链哄満
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairportForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ链哄満
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairportBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ链哄満
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairportBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairportBySql(String sql);
	
	  //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return deleted count 
	 */
	public Fairway createFairway(Fairway fairway) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairway(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return updated count 
	 */
	public int updateFairway(Fairway fairway);

		
	/**
	 * 淇敼 锲介台链虹エ鑸┖鍏徃浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFairwayIgnoreNull(Fairway fairway);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param id
	 * @return
	 */
	public Fairway findFairway(long id);
	
	/**
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃 by language
	 * @param id
	 * @return
	 */
	public Fairway findFairwaybylanguage(long id ,Integer language);
	
	/** 
	 * 镆ユ垒 锲介台链虹エ鑸┖鍏徃
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairwayForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ鑸┖鍏徃
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairwayBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ鑸┖鍏徃
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairwayBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairwayBySql(String sql);
	
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public Fcity createFcity(Fcity fcity) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcity(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return updated count 
	 */
	public int updateFcity(Fcity fcity);

		
	/**
	 * 淇敼 锲介台链虹エ鍩庡竞浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFcityIgnoreNull(Fcity fcity);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fcity findFcity(long id);
	
	/**
	 * 镆ユ垒 锲介台链虹エ鍩庡竞 by language
	 * @param id
	 * @return
	 */
	public Fcity findFcitybylanguage(long id ,Integer language);
	
	/** 
	 * 镆ユ垒 锲介台链虹エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcityForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ鍩庡竞
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcityBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ鍩庡竞
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcityBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcityBySql(String sql);
	
	//绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ锲藉
	 * @param id
	 * @return deleted count 
	 */
	public Fcountry createFcountry(Fcountry fcountry) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ锲藉
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcountry(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ锲藉
	 * @param id
	 * @return updated count 
	 */
	public int updateFcountry(Fcountry fcountry);

		
	/**
	 * 淇敼 锲介台链虹エ锲藉浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFcountryIgnoreNull(Fcountry fcountry);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param id
	 * @return
	 */
	public Fcountry findFcountry(long id);
	
	/**
	 * 镆ユ垒 锲介台链虹エ锲藉 by language
	 * @param id
	 * @return
	 */
	public Fcountry findFcountrybylanguage(long id ,Integer language);
	
	/** 
	 * 镆ユ垒 锲介台链虹エ锲藉
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcountryForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ锲藉
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountryBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ锲藉
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcountryBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcountryBySql(String sql);
	
	
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return deleted count 
	 */
	public Fdeliverassign createFdeliverassign(Fdeliverassign fdeliverassign) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFdeliverassign(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return updated count 
	 */
	public int updateFdeliverassign(Fdeliverassign fdeliverassign);

		
	/**
	 * 淇敼 锲介台链虹エ閰嶉€佷俊鎭絾蹇界暐绌哄€?
	 * @param id
	 * @return 
	 */
	public int updateFdeliverassignIgnoreNull(Fdeliverassign fdeliverassign);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param id
	 * @return
	 */
	public Fdeliverassign findFdeliverassign(long id);
	
	
	/** 
	 * 镆ユ垒 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFdeliverassignForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ閰嶉€佷俊鎭?
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassignBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ閰嶉€佷俊鎭?
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFdeliverassignBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFdeliverassignBySql(String sql);
		
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ琛岀▼
	 * @param id
	 * @return deleted count 
	 */
	public Fflight createFflight(Fflight fflight) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ琛岀▼
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFflight(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ琛岀▼
	 * @param id
	 * @return updated count 
	 */
	public int updateFflight(Fflight fflight);

		
	/**
	 * 淇敼 锲介台链虹エ琛岀▼浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFflightIgnoreNull(Fflight fflight);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param id
	 * @return
	 */
	public Fflight findFflight(long id);
	
	
	/** 
	 * 镆ユ垒 锲介台链虹エ琛岀▼
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFflightForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ琛岀▼
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflightBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ琛岀▼
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFflightBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFflightBySql(String sql);
	
	
	
	//绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return deleted count 
	 */
	public Fguest createFguest(Fguest fguest) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFguest(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return updated count 
	 */
	public int updateFguest(Fguest fguest);

		
	/**
	 * 淇敼 锲介台链虹エ涔樻満浜鸿〃浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFguestIgnoreNull(Fguest fguest);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param id
	 * @return
	 */
	public Fguest findFguest(long id);
	
	
	/** 
	 * 镆ユ垒 锲介台链虹エ涔樻満浜鸿〃
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFguestForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ涔樻満浜鸿〃
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguestBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ涔樻満浜鸿〃
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFguestBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFguestBySql(String sql);
	
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return deleted count 
	 */
	public Forderdelrec createForderdelrec(Forderdelrec forderdelrec) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderdelrec(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return updated count 
	 */
	public int updateForderdelrec(Forderdelrec forderdelrec);

		
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟鎿崭綔璁板綍浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateForderdelrecIgnoreNull(Forderdelrec forderdelrec);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param id
	 * @return
	 */
	public Forderdelrec findForderdelrec(long id);
	
	
	/** 
	 * 镆ユ垒 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderdelrecForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrecBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ璁㈠崟鎿崭綔璁板綍
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderdelrecBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderdelrecBySql(String sql);
	
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return deleted count 
	 */
	public Forderinfo createForderinfo(Forderinfo forderinfo) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderinfo(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return updated count 
	 */
	public int updateForderinfo(Forderinfo forderinfo);

		
	/**
	 * 淇敼 锲介台链虹エ璁㈠崟琛ㄤ絾蹇界暐绌哄€?
	 * @param id
	 * @return 
	 */
	public int updateForderinfoIgnoreNull(Forderinfo forderinfo);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param id
	 * @return
	 */
	public Forderinfo findForderinfo(long id);
	
	
	/** 
	 * 镆ユ垒 锲介台链虹エ璁㈠崟琛?
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ璁㈠崟琛?
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfoBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ璁㈠崟琛?
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderinfoBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderinfoBySql(String sql);
	
	 //绮樿创鍒癝ervice鎺ュ彛绫?
 	/**
	 * 鍒涘缓 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public Fsendticketcity createFsendticketcity(Fsendticketcity fsendticketcity) throws SQLException;
	
	/**
	 * 鍒犻櫎 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFsendticketcity(long id);
	
	
	/**
	 * 淇敼 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return updated count 
	 */
	public int updateFsendticketcity(Fsendticketcity fsendticketcity);

		
	/**
	 * 淇敼 锲介台链虹エ阃佺エ鍩庡竞浣嗗拷鐣ョ┖链?
	 * @param id
	 * @return 
	 */
	public int updateFsendticketcityIgnoreNull(Fsendticketcity fsendticketcity);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcity(long id);
	
	/**
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞 by language
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcitybylanguage(long id ,Integer language);
	
	/** 
	 * 镆ユ垒 锲介台链虹エ阃佺エ鍩庡竞
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFsendticketcityForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 镙规嵁Sql镆ユ垒锲介台链虹エ阃佺エ鍩庡竞
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcityBySql(String sql,int limit,int offset);
	
	
	/**
	 * 镓цSql 锲介台链虹エ阃佺エ鍩庡竞
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFsendticketcityBySql(String sql);
	
	/**
	 * 镓цSql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFsendticketcityBySql(String sql);
}
