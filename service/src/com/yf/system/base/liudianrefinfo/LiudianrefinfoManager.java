/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.liudianrefinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LiudianrefinfoManager extends  SqlMapClientDaoSupport  implements ILiudianrefinfoManager{ 
	
  
 	/**
	 * 创建 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrefinfo createLiudianrefinfo(Liudianrefinfo liudianrefinfo) throws SQLException{
	
		if(liudianrefinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		liudianrefinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LIUDIANREFINFO"));
		getSqlMapClientTemplate().insert("createLiudianrefinfo",liudianrefinfo);
		
		return liudianrefinfo;
	}
	/**
	 * 删除 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrefinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteLiudianrefinfo", id);
	}
	
	
	/**
	 * 修改 留点设置关联表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrefinfo(Liudianrefinfo liudianrefinfo){
		return getSqlMapClientTemplate().update("updateLiudianrefinfo",liudianrefinfo);
	
	}

		
	/**
	 * 修改 留点设置关联表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrefinfoIgnoreNull(Liudianrefinfo liudianrefinfo){
		Liudianrefinfo tmp = findLiudianrefinfo(liudianrefinfo.getId());
		int flag =0;
		
		
		if(liudianrefinfo.getAgentid()!=null){
			tmp.setAgentid(liudianrefinfo.getAgentid());
			
			flag++;
		}
		
		if(liudianrefinfo.getLiudianrecid()!=null){
			tmp.setLiudianrecid(liudianrefinfo.getLiudianrecid());
			
			flag++;
		}
		
		if(liudianrefinfo.getTypeid()!=null){
			tmp.setTypeid(liudianrefinfo.getTypeid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLiudianrefinfo",tmp);
		}
	}
	
	/**
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,int limit,int offset){
		
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLiudianrefinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 留点设置关联表
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfo(long id){
		return (Liudianrefinfo)(getSqlMapClientTemplate().queryForObject("findLiudianrefinfo",id));
	}
	/**
	 * 查找 留点设置关联表 by language
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfobylanguage(long id,Integer language){
		String where = " where 1=1 ";	
		List list=findAllLiudianrefinfo(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Liudianrefinfo)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where 1=1";
		}
	
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLiudianrefinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLiudianrefinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找留点设置关联表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLiudianrefinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 留点设置关联表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrefinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLiudianrefinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrefinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLiudianrefinfoBySql",map).toString()));
	}
}

