/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.chaininfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ChaininfoManager extends  SqlMapClientDaoSupport  implements IChaininfoManager{ 
	
  
 	/**
	 * 创建 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public Chaininfo createChaininfo(Chaininfo chaininfo) throws SQLException{
	
		if(chaininfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		chaininfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CHAININFO"));
		getSqlMapClientTemplate().insert("createChaininfo",chaininfo);
		return chaininfo;
	}
	/**
	 * 删除 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChaininfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteChaininfo", id);
	}
	
	
	/**
	 * 修改 连锁酒店类型
	 * @param id
	 * @return updated count 
	 */
	public int updateChaininfo(Chaininfo chaininfo){
		return getSqlMapClientTemplate().update("updateChaininfo",chaininfo);
	
	}

		
	/**
	 * 修改 连锁酒店类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChaininfoIgnoreNull(Chaininfo chaininfo){
		Chaininfo tmp = findChaininfo(chaininfo.getId());
		int flag =0;
		
		
		if(chaininfo.getName()!=null){
			tmp.setName(chaininfo.getName());
			
			flag++;
		}
		
		if(chaininfo.getDescription()!=null){
			tmp.setDescription(chaininfo.getDescription());
			
			flag++;
		}
		
		if(chaininfo.getImagepic()!=null){
			tmp.setImagepic(chaininfo.getImagepic());
			
			flag++;
		}
		
		if(chaininfo.getTotal()!=null){
			tmp.setTotal(chaininfo.getTotal());
			
			flag++;
		}
		
		if(chaininfo.getSort()!=null){
			tmp.setSort(chaininfo.getSort());
			
			flag++;
		}
		
		if(chaininfo.getCityidstr()!=null){
			tmp.setCityidstr(chaininfo.getCityidstr());
			
			flag++;
		}
		
		if(chaininfo.getImagepic2()!=null){
			tmp.setImagepic2(chaininfo.getImagepic2());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateChaininfo",tmp);
		}
	}
	
	/**
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllChaininfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param id
	 * @return
	 */
	public Chaininfo findChaininfo(long id){
		return (Chaininfo)(getSqlMapClientTemplate().queryForObject("findChaininfo",id));
	}
	
	/** 
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countChaininfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllChaininfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找连锁酒店类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllChaininfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 连锁酒店类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChaininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteChaininfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChaininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countChaininfoBySql",map).toString()));
	}
}

