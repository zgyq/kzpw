/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starsettlementtype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class StarsettlementtypeManager extends  SqlMapClientDaoSupport  implements IStarsettlementtypeManager{ 
	
  
 	/**
	 * 创建 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public Starsettlementtype createStarsettlementtype(Starsettlementtype starsettlementtype) throws SQLException{
	
		if(starsettlementtype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		starsettlementtype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_STARSETTLEMENTTYPE"));
		getSqlMapClientTemplate().insert("createStarsettlementtype",starsettlementtype);
		return starsettlementtype;
	}
	/**
	 * 删除 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarsettlementtype(long id){
	
		return getSqlMapClientTemplate().delete("deleteStarsettlementtype", id);
	}
	
	
	/**
	 * 修改 星级结算分类
	 * @param id
	 * @return updated count 
	 */
	public int updateStarsettlementtype(Starsettlementtype starsettlementtype){
		return getSqlMapClientTemplate().update("updateStarsettlementtype",starsettlementtype);
	
	}

		
	/**
	 * 修改 星级结算分类但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarsettlementtypeIgnoreNull(Starsettlementtype starsettlementtype){
		Starsettlementtype tmp = findStarsettlementtype(starsettlementtype.getId());
		int flag =0;
		
		
		if(starsettlementtype.getTypename()!=null){
			tmp.setTypename(starsettlementtype.getTypename());
			
			flag++;
		}
		
		if(starsettlementtype.getSliudianid()!=null){
			tmp.setSliudianid(starsettlementtype.getSliudianid());
			
			flag++;
		}
		
		if(starsettlementtype.getCreateuser()!=null){
			tmp.setCreateuser(starsettlementtype.getCreateuser());
			
			flag++;
		}
		
		if(starsettlementtype.getCreatetime()!=null){
			tmp.setCreatetime(starsettlementtype.getCreatetime());
			
			flag++;
		}
		
		if(starsettlementtype.getSagentid()!=null){
			tmp.setSagentid(starsettlementtype.getSagentid());
			
			flag++;
		}
		
		if(starsettlementtype.getParam1()!=null){
			tmp.setParam1(starsettlementtype.getParam1());
			
			flag++;
		}
		
		if(starsettlementtype.getParam2()!=null){
			tmp.setParam2(starsettlementtype.getParam2());
			
			flag++;
		}
		
		if(starsettlementtype.getParam3()!=null){
			tmp.setParam3(starsettlementtype.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateStarsettlementtype",tmp);
		}
	}
	
	/**
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllStarsettlementtype",map, offset, limit);
	}
		
	
	/**
	 * 查找 星级结算分类
	 * @param id
	 * @return
	 */
	public Starsettlementtype findStarsettlementtype(long id){
		return (Starsettlementtype)(getSqlMapClientTemplate().queryForObject("findStarsettlementtype",id));
	}
	
	/** 
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarsettlementtypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllStarsettlementtype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找星级结算分类
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllStarsettlementtypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 星级结算分类
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarsettlementtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteStarsettlementtypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarsettlementtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarsettlementtypeBySql",map).toString()));
	}
}

