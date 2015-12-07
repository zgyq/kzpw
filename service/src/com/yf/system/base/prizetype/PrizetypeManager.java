/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizetype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PrizetypeManager extends  SqlMapClientDaoSupport  implements IPrizetypeManager{ 
	
  
 	/**
	 * 创建 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public Prizetype createPrizetype(Prizetype prizetype) throws SQLException{
	
		if(prizetype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		prizetype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PRIZETYPE"));
		getSqlMapClientTemplate().insert("createPrizetype",prizetype);
		return prizetype;
	}
	/**
	 * 删除 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizetype(long id){
	
		return getSqlMapClientTemplate().delete("deletePrizetype", id);
	}
	
	
	/**
	 * 修改 积分礼品类型
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizetype(Prizetype prizetype){
		return getSqlMapClientTemplate().update("updatePrizetype",prizetype);
	
	}

		
	/**
	 * 修改 积分礼品类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizetypeIgnoreNull(Prizetype prizetype){
		Prizetype tmp = findPrizetype(prizetype.getId());
		int flag =0;
		
		
		if(prizetype.getTypename()!=null){
			tmp.setTypename(prizetype.getTypename());
			
			flag++;
		}
		
		if(prizetype.getIndex()!=null){
			tmp.setIndex(prizetype.getIndex());
			
			flag++;
		}
		
		if(prizetype.getCreateuser()!=null){
			tmp.setCreateuser(prizetype.getCreateuser());
			
			flag++;
		}
		
		if(prizetype.getCreatetime()!=null){
			tmp.setCreatetime(prizetype.getCreatetime());
			
			flag++;
		}
		
		if(prizetype.getModifyuser()!=null){
			tmp.setModifyuser(prizetype.getModifyuser());
			
			flag++;
		}
		
		if(prizetype.getModifytime()!=null){
			tmp.setModifytime(prizetype.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePrizetype",tmp);
		}
	}
	
	/**
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPrizetype",map, offset, limit);
	}
		
	
	/**
	 * 查找 积分礼品类型
	 * @param id
	 * @return
	 */
	public Prizetype findPrizetype(long id){
		return (Prizetype)(getSqlMapClientTemplate().queryForObject("findPrizetype",id));
	}
	
	/** 
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPrizetypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPrizetype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找积分礼品类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPrizetypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 积分礼品类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizetypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePrizetypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizetypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPrizetypeBySql",map).toString()));
	}
}

