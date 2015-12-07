/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.messgroup;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class MessgroupManager extends  SqlMapClientDaoSupport  implements IMessgroupManager{ 
	
  
 	/**
	 * 创建 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public Messgroup createMessgroup(Messgroup messgroup) throws SQLException{
	
		if(messgroup.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		messgroup.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_MESSGROUP"));
		getSqlMapClientTemplate().insert("createMessgroup",messgroup);
		return messgroup;
	}
	/**
	 * 删除 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMessgroup(long id){
	
		return getSqlMapClientTemplate().delete("deleteMessgroup", id);
	}
	
	
	/**
	 * 修改 短信用户组
	 * @param id
	 * @return updated count 
	 */
	public int updateMessgroup(Messgroup messgroup){
		return getSqlMapClientTemplate().update("updateMessgroup",messgroup);
	
	}

		
	/**
	 * 修改 短信用户组但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMessgroupIgnoreNull(Messgroup messgroup){
		Messgroup tmp = findMessgroup(messgroup.getId());
		int flag =0;
		
		
		if(messgroup.getMessname()!=null){
			tmp.setMessname(messgroup.getMessname());
			
			flag++;
		}
		
		if(messgroup.getMessnums()!=null){
			tmp.setMessnums(messgroup.getMessnums());
			
			flag++;
		}
		
		if(messgroup.getCreatetime()!=null){
			tmp.setCreatetime(messgroup.getCreatetime());
			
			flag++;
		}
		
		if(messgroup.getCreateuserid()!=null){
			tmp.setCreateuserid(messgroup.getCreateuserid());
			
			flag++;
		}
		
		if(messgroup.getParam1()!=null){
			tmp.setParam1(messgroup.getParam1());
			
			flag++;
		}
		
		if(messgroup.getParam2()!=null){
			tmp.setParam2(messgroup.getParam2());
			
			flag++;
		}
		
		if(messgroup.getParam3()!=null){
			tmp.setParam3(messgroup.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateMessgroup",tmp);
		}
	}
	
	/**
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllMessgroup",map, offset, limit);
	}
		
	
	/**
	 * 查找 短信用户组
	 * @param id
	 * @return
	 */
	public Messgroup findMessgroup(long id){
		return (Messgroup)(getSqlMapClientTemplate().queryForObject("findMessgroup",id));
	}
	
	/** 
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countMessgroupBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllMessgroup",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找短信用户组
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllMessgroupBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 短信用户组
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMessgroupBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteMessgroupBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMessgroupBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countMessgroupBySql",map).toString()));
	}
}

