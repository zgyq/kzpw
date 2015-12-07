/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.optrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class OptrecordManager extends  SqlMapClientDaoSupport  implements IOptrecordManager{ 
	
  
 	/**
	 * 创建 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public Optrecord createOptrecord(Optrecord optrecord) throws SQLException{
	
		if(optrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		optrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_OPTRECORD"));
		getSqlMapClientTemplate().insert("createOptrecord",optrecord);
		return optrecord;
	}
	/**
	 * 删除 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOptrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteOptrecord", id);
	}
	
	
	/**
	 * 修改 操作记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateOptrecord(Optrecord optrecord){
		return getSqlMapClientTemplate().update("updateOptrecord",optrecord);
	
	}

		
	/**
	 * 修改 操作记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOptrecordIgnoreNull(Optrecord optrecord){
		Optrecord tmp = findOptrecord(optrecord.getId());
		int flag =0;
		
		
		if(optrecord.getTablename()!=null){
			tmp.setTablename(optrecord.getTablename());
			
			flag++;
		}
		
		if(optrecord.getColumn()!=null){
			tmp.setColumn(optrecord.getColumn());
			
			flag++;
		}
		
		if(optrecord.getOldvalue()!=null){
			tmp.setOldvalue(optrecord.getOldvalue());
			
			flag++;
		}
		
		if(optrecord.getNewvalue()!=null){
			tmp.setNewvalue(optrecord.getNewvalue());
			
			flag++;
		}
		
		if(optrecord.getDescription()!=null){
			tmp.setDescription(optrecord.getDescription());
			
			flag++;
		}
		
		if(optrecord.getCreateuser()!=null){
			tmp.setCreateuser(optrecord.getCreateuser());
			
			flag++;
		}
		
		if(optrecord.getCreatetime()!=null){
			tmp.setCreatetime(optrecord.getCreatetime());
			
			flag++;
		}
		
		if(optrecord.getOptid()!=null){
			tmp.setOptid(optrecord.getOptid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateOptrecord",tmp);
		}
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
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllOptrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 操作记录表
	 * @param id
	 * @return
	 */
	public Optrecord findOptrecord(long id){
		return (Optrecord)(getSqlMapClientTemplate().queryForObject("findOptrecord",id));
	}
	
	/** 
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countOptrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllOptrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找操作记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllOptrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 操作记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOptrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteOptrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOptrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countOptrecordBySql",map).toString()));
	}
}

