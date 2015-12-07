/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traincity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TraincityManager extends  SqlMapClientDaoSupport  implements ITraincityManager{ 
	
  
 	/**
	 * 创建 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public Traincity createTraincity(Traincity traincity) throws SQLException{
	
		if(traincity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		traincity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINCITY"));
		getSqlMapClientTemplate().insert("createTraincity",traincity);
		return traincity;
	}
	/**
	 * 删除 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraincity(long id){
	
		return getSqlMapClientTemplate().delete("deleteTraincity", id);
	}
	
	
	/**
	 * 修改 火车票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateTraincity(Traincity traincity){
		return getSqlMapClientTemplate().update("updateTraincity",traincity);
	
	}

		
	/**
	 * 修改 火车票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraincityIgnoreNull(Traincity traincity){
		Traincity tmp = findTraincity(traincity.getId());
		int flag =0;
		
		
		if(traincity.getName()!=null){
			tmp.setName(traincity.getName());
			
			flag++;
		}
		
		if(traincity.getEnname()!=null){
			tmp.setEnname(traincity.getEnname());
			
			flag++;
		}
		
		if(traincity.getBack1()!=null){
			tmp.setBack1(traincity.getBack1());
			
			flag++;
		}
		
		if(traincity.getBack2()!=null){
			tmp.setBack2(traincity.getBack2());
			
			flag++;
		}
		
		if(traincity.getBack3()!=null){
			tmp.setBack3(traincity.getBack3());
			
			flag++;
		}
		
		if(traincity.getState()!=null){
			tmp.setState(traincity.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTraincity",tmp);
		}
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
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTraincity",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车票城市
	 * @param id
	 * @return
	 */
	public Traincity findTraincity(long id){
		return (Traincity)(getSqlMapClientTemplate().queryForObject("findTraincity",id));
	}
	
	/** 
	 * 查找 火车票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraincity(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraincityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTraincity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraincity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTraincityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraincityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTraincityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraincityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraincityBySql",map).toString()));
	}
}

