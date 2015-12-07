/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gerenguazhanfrec;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class GerenguazhanfrecManager extends  SqlMapClientDaoSupport  implements IGerenguazhanfrecManager{ 
	
  
 	/**
	 * 创建 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public Gerenguazhanfrec createGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec) throws SQLException{
	
		if(gerenguazhanfrec.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		gerenguazhanfrec.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_GERENGUAZHANFREC"));
		getSqlMapClientTemplate().insert("createGerenguazhanfrec",gerenguazhanfrec);
		return gerenguazhanfrec;
	}
	/**
	 * 删除 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGerenguazhanfrec(long id){
	
		return getSqlMapClientTemplate().delete("deleteGerenguazhanfrec", id);
	}
	
	
	/**
	 * 修改 个人挂账记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec){
		return getSqlMapClientTemplate().update("updateGerenguazhanfrec",gerenguazhanfrec);
	
	}

		
	/**
	 * 修改 个人挂账记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGerenguazhanfrecIgnoreNull(Gerenguazhanfrec gerenguazhanfrec){
		Gerenguazhanfrec tmp = findGerenguazhanfrec(gerenguazhanfrec.getId());
		int flag =0;
		
		
		if(gerenguazhanfrec.getOrderid()!=null){
			tmp.setOrderid(gerenguazhanfrec.getOrderid());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getEmployeeid()!=null){
			tmp.setEmployeeid(gerenguazhanfrec.getEmployeeid());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getState()!=null){
			tmp.setState(gerenguazhanfrec.getState());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getCreateuser()!=null){
			tmp.setCreateuser(gerenguazhanfrec.getCreateuser());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getCreatetime()!=null){
			tmp.setCreatetime(gerenguazhanfrec.getCreatetime());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getMidifyuser()!=null){
			tmp.setMidifyuser(gerenguazhanfrec.getMidifyuser());
			
			flag++;
		}
		
		if(gerenguazhanfrec.getMidifytime()!=null){
			tmp.setMidifytime(gerenguazhanfrec.getMidifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateGerenguazhanfrec",tmp);
		}
	}
	
	/**
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllGerenguazhanfrec",map, offset, limit);
	}
		
	
	/**
	 * 查找 个人挂账记录表
	 * @param id
	 * @return
	 */
	public Gerenguazhanfrec findGerenguazhanfrec(long id){
		return (Gerenguazhanfrec)(getSqlMapClientTemplate().queryForObject("findGerenguazhanfrec",id));
	}
	
	/** 
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGerenguazhanfrecBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllGerenguazhanfrec",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找个人挂账记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllGerenguazhanfrecBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 个人挂账记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGerenguazhanfrecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteGerenguazhanfrecBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGerenguazhanfrecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGerenguazhanfrecBySql",map).toString()));
	}
}

