/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenter;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HelpcenterManager extends  SqlMapClientDaoSupport  implements IHelpcenterManager{ 
	
  
 	/**
	 * 创建 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenter createHelpcenter(Helpcenter helpcenter) throws SQLException{
	
		if(helpcenter.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		helpcenter.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HELPCENTER"));
		getSqlMapClientTemplate().insert("createHelpcenter",helpcenter);
		return helpcenter;
	}
	/**
	 * 删除 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenter(long id){
	
		return getSqlMapClientTemplate().delete("deleteHelpcenter", id);
	}
	
	
	/**
	 * 修改 帮助中心
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenter(Helpcenter helpcenter){
		return getSqlMapClientTemplate().update("updateHelpcenter",helpcenter);
	
	}

		
	/**
	 * 修改 帮助中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterIgnoreNull(Helpcenter helpcenter){
		Helpcenter tmp = findHelpcenter(helpcenter.getId());
		int flag =0;
		
		
		if(helpcenter.getName()!=null){
			tmp.setName(helpcenter.getName());
			
			flag++;
		}
		if(helpcenter.getIsweb()!=null){
			tmp.setIsweb(helpcenter.getIsweb());
			
			flag++;
		}
		if(helpcenter.getCreatetime()!=null){
			tmp.setCreatetime(helpcenter.getCreatetime());
			
			flag++;
		}
		
		if(helpcenter.getMemberid()!=null){
			tmp.setMemberid(helpcenter.getMemberid());
			
			flag++;
		}
		
		if(helpcenter.getState()!=null){
			tmp.setState(helpcenter.getState());
			
			flag++;
		}
		
		if(helpcenter.getParentid()!=null){
			tmp.setParentid(helpcenter.getParentid());
			
			flag++;
		}
		
		if(helpcenter.getParentstr()!=null){
			tmp.setParentstr(helpcenter.getParentstr());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHelpcenter",tmp);
		}
	}
	
	/**
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHelpcenter",map, offset, limit);
	}
		
	
	/**
	 * 查找 帮助中心
	 * @param id
	 * @return
	 */
	public Helpcenter findHelpcenter(long id){
		return (Helpcenter)(getSqlMapClientTemplate().queryForObject("findHelpcenter",id));
	}
	
	/** 
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHelpcenterBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHelpcenter",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找帮助中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHelpcenterBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 帮助中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHelpcenterBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHelpcenterBySql",map).toString()));
	}
}

