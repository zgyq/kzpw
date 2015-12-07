/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.backpoint;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class BackpointManager extends  SqlMapClientDaoSupport  implements IBackpointManager{ 
	
  
 	/**
	 * 创建 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public Backpoint createBackpoint(Backpoint backpoint) throws SQLException{
	
		if(backpoint.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		backpoint.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_BACKPOINT"));
		getSqlMapClientTemplate().insert("createBackpoint",backpoint);
		return backpoint;
	}
	/**
	 * 删除 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBackpoint(long id){
	
		return getSqlMapClientTemplate().delete("deleteBackpoint", id);
	}
	
	
	/**
	 * 修改 隐扣设置
	 * @param id
	 * @return updated count 
	 */
	public int updateBackpoint(Backpoint backpoint){
		return getSqlMapClientTemplate().update("updateBackpoint",backpoint);
	
	}

		
	/**
	 * 修改 隐扣设置但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBackpointIgnoreNull(Backpoint backpoint){
		Backpoint tmp = findBackpoint(backpoint.getId());
		int flag =0;
		
		
		if(backpoint.getStartdate()!=null){
			tmp.setStartdate(backpoint.getStartdate());
			
			flag++;
		}
		
		if(backpoint.getIsenables()!=null){
			tmp.setIsenables(backpoint.getIsenables());
			
			flag++;
		}
		
		if(backpoint.getBackpoint()!=null){
			tmp.setBackpoint(backpoint.getBackpoint());
			
			flag++;
		}
		
		if(backpoint.getPolicyrange()!=null){
			tmp.setPolicyrange(backpoint.getPolicyrange());
			
			flag++;
		}
		
		if(backpoint.getCreateuser()!=null){
			tmp.setCreateuser(backpoint.getCreateuser());
			
			flag++;
		}
		
		if(backpoint.getCreatetime()!=null){
			tmp.setCreatetime(backpoint.getCreatetime());
			
			flag++;
		}
		
		if(backpoint.getModifyuser()!=null){
			tmp.setModifyuser(backpoint.getModifyuser());
			
			flag++;
		}
		
		if(backpoint.getModifytime()!=null){
			tmp.setModifytime(backpoint.getModifytime());
			
			flag++;
		}
		
		if(backpoint.getCustomeragentid()!=null){
			tmp.setCustomeragentid(backpoint.getCustomeragentid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateBackpoint",tmp);
		}
	}
	
	/**
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpoint(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllBackpoint",map, offset, limit);
	}
		
	
	/**
	 * 查找 隐扣设置
	 * @param id
	 * @return
	 */
	public Backpoint findBackpoint(long id){
		return (Backpoint)(getSqlMapClientTemplate().queryForObject("findBackpoint",id));
	}
	
	/** 
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBackpoint(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBackpointBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllBackpoint",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找隐扣设置
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpoint(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllBackpointBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 隐扣设置
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBackpointBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteBackpointBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBackpointBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBackpointBySql",map).toString()));
	}
}

