/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainseat;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainseatManager extends  SqlMapClientDaoSupport  implements ITrainseatManager{ 
	
  
 	/**
	 * 创建 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public Trainseat createTrainseat(Trainseat trainseat) throws SQLException{
	
		if(trainseat.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainseat.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINSEAT"));
		getSqlMapClientTemplate().insert("createTrainseat",trainseat);
		return trainseat;
	}
	/**
	 * 删除 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainseat(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainseat", id);
	}
	
	
	/**
	 * 修改 火车席别
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainseat(Trainseat trainseat){
		return getSqlMapClientTemplate().update("updateTrainseat",trainseat);
	
	}

		
	/**
	 * 修改 火车席别但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainseatIgnoreNull(Trainseat trainseat){
		Trainseat tmp = findTrainseat(trainseat.getId());
		int flag =0;
		
		
		if(trainseat.getSeat_code()!=null){
			tmp.setSeat_code(trainseat.getSeat_code());
			
			flag++;
		}
		
		if(trainseat.getSeat_name()!=null){
			tmp.setSeat_name(trainseat.getSeat_name());
			
			flag++;
		}
		
		if(trainseat.getCode_12306()!=null){
			tmp.setCode_12306(trainseat.getCode_12306());
			
			flag++;
		}
		
		if(trainseat.getMem()!=null){
			tmp.setMem(trainseat.getMem());
			
			flag++;
		}
		
		if(trainseat.getBack1()!=null){
			tmp.setBack1(trainseat.getBack1());
			
			flag++;
		}
		
		if(trainseat.getBack2()!=null){
			tmp.setBack2(trainseat.getBack2());
			
			flag++;
		}
		
		if(trainseat.getBack3()!=null){
			tmp.setBack3(trainseat.getBack3());
			
			flag++;
		}
		
		if(trainseat.getState()!=null){
			tmp.setState(trainseat.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainseat",tmp);
		}
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
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainseat",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车席别
	 * @param id
	 * @return
	 */
	public Trainseat findTrainseat(long id){
		return (Trainseat)(getSqlMapClientTemplate().queryForObject("findTrainseat",id));
	}
	
	/** 
	 * 查找 火车席别
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainseat(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainseatBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainseat",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车席别
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainseat(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainseatBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车席别
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainseatBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainseatBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainseatBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainseatBySql",map).toString()));
	}
}

