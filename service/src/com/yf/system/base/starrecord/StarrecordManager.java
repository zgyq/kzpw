/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class StarrecordManager extends  SqlMapClientDaoSupport  implements IStarrecordManager{ 
	
  
 	/**
	 * 创建 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public Starrecord createStarrecord(Starrecord starrecord) throws SQLException{
	
		if(starrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		starrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_STARRECORD"));
		getSqlMapClientTemplate().insert("createStarrecord",starrecord);
		return starrecord;
	}
	/**
	 * 删除 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteStarrecord", id);
	}
	
	
	/**
	 * 修改 星级留点记录
	 * @param id
	 * @return updated count 
	 */
	public int updateStarrecord(Starrecord starrecord){
		return getSqlMapClientTemplate().update("updateStarrecord",starrecord);
	
	}

		
	/**
	 * 修改 星级留点记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarrecordIgnoreNull(Starrecord starrecord){
		Starrecord tmp = findStarrecord(starrecord.getId());
		int flag =0;
		
		
		if(starrecord.getSfandianstart()!=null){
			tmp.setSfandianstart(starrecord.getSfandianstart());
			
			flag++;
		}
		
		if(starrecord.getSfandianend()!=null){
			tmp.setSfandianend(starrecord.getSfandianend());
			
			flag++;
		}
		
		if(starrecord.getSliudian()!=null){
			tmp.setSliudian(starrecord.getSliudian());
			
			flag++;
		}
		
		if(starrecord.getSagentid()!=null){
			tmp.setSagentid(starrecord.getSagentid());
			
			flag++;
		}
		
		if(starrecord.getTypeid()!=null){
			tmp.setTypeid(starrecord.getTypeid());
			
			flag++;
		}
		
		if(starrecord.getParam1()!=null){
			tmp.setParam1(starrecord.getParam1());
			
			flag++;
		}
		
		if(starrecord.getParam2()!=null){
			tmp.setParam2(starrecord.getParam2());
			
			flag++;
		}
		
		if(starrecord.getParam3()!=null){
			tmp.setParam3(starrecord.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateStarrecord",tmp);
		}
	}
	
	/**
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllStarrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 星级留点记录
	 * @param id
	 * @return
	 */
	public Starrecord findStarrecord(long id){
		return (Starrecord)(getSqlMapClientTemplate().queryForObject("findStarrecord",id));
	}
	
	/** 
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllStarrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找星级留点记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllStarrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 星级留点记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteStarrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarrecordBySql",map).toString()));
	}
}

