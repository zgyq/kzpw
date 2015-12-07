/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.incity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class IncityManager extends  SqlMapClientDaoSupport  implements IIncityManager{ 
	
  
 	/**
	 * 创建 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public Incity createIncity(Incity incity) throws SQLException{
	
		if(incity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		incity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INCITY"));
		getSqlMapClientTemplate().insert("createIncity",incity);
		return incity;
	}
	/**
	 * 删除 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIncity(long id){
	
		return getSqlMapClientTemplate().delete("deleteIncity", id);
	}
	
	
	/**
	 * 修改 国际城市表
	 * @param id
	 * @return updated count 
	 */
	public int updateIncity(Incity incity){
		return getSqlMapClientTemplate().update("updateIncity",incity);
	
	}

		
	/**
	 * 修改 国际城市表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIncityIgnoreNull(Incity incity){
		Incity tmp = findIncity(incity.getId());
		int flag =0;
		
		
		if(incity.getName()!=null){
			tmp.setName(incity.getName());
			
			flag++;
		}
		if(incity.getZhname()!=null){
			tmp.setZhname(incity.getZhname());
			
			flag++;
		}
		
		if(incity.getDesc()!=null){
			tmp.setDesc(incity.getDesc());
			
			flag++;
		}
		
		if(incity.getMregion()!=null){
			tmp.setMregion(incity.getMregion());
			
			flag++;
		}
		
		if(incity.getNr()!=null){
			tmp.setNr(incity.getNr());
			
			flag++;
		}
		
		if(incity.getPcrange()!=null){
			tmp.setPcrange(incity.getPcrange());
			
			flag++;
		}
		
		if(incity.getLatlong()!=null){
			tmp.setLatlong(incity.getLatlong());
			
			flag++;
		}
		
		if(incity.getCreatetime()!=null){
			tmp.setCreatetime(incity.getCreatetime());
			
			flag++;
		}
		
		if(incity.getType()!=null){
			tmp.setType(incity.getType());
			
			flag++;
		}
		
		if(incity.getCountryid()!=null){
			tmp.setCountryid(incity.getCountryid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateIncity",tmp);
		}
	}
	
	/**
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllIncity",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际城市表
	 * @param id
	 * @return
	 */
	public Incity findIncity(long id){
		return (Incity)(getSqlMapClientTemplate().queryForObject("findIncity",id));
	}
	
	/** 
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIncity(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countIncityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllIncity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际城市表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllIncityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际城市表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIncityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteIncityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIncityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countIncityBySql",map).toString()));
	}
}

