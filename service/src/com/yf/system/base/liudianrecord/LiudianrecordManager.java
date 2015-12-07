/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.liudianrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LiudianrecordManager extends  SqlMapClientDaoSupport  implements ILiudianrecordManager{ 
	
  
 	/**
	 * 创建 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrecord createLiudianrecord(Liudianrecord liudianrecord) throws SQLException{
	
		if(liudianrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		liudianrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LIUDIANRECORD"));
		getSqlMapClientTemplate().insert("createLiudianrecord",liudianrecord);
		
		return liudianrecord;
	}
	/**
	 * 删除 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteLiudianrecord", id);
	}
	
	
	/**
	 * 修改 留点记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrecord(Liudianrecord liudianrecord){
		return getSqlMapClientTemplate().update("updateLiudianrecord",liudianrecord);
	
	}

		
	/**
	 * 修改 留点记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrecordIgnoreNull(Liudianrecord liudianrecord){
		Liudianrecord tmp = findLiudianrecord(liudianrecord.getId());
		int flag =0;
		
		
		if(liudianrecord.getFandianstart()!=null){
			tmp.setFandianstart(liudianrecord.getFandianstart());
			
			flag++;
		}
		
		if(liudianrecord.getFandianend()!=null){
			tmp.setFandianend(liudianrecord.getFandianend());
			
			flag++;
		}
		
		if(liudianrecord.getLiudian()!=null){
			tmp.setLiudian(liudianrecord.getLiudian());
			
			flag++;
		}
		
		if(liudianrecord.getAgentid()!=null){
			tmp.setAgentid(liudianrecord.getAgentid());
			
			flag++;
		}
		
		if(liudianrecord.getTypeid()!=null){
			tmp.setTypeid(liudianrecord.getTypeid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLiudianrecord",tmp);
		}
	}
	
	/**
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecord(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where 1=1";
		}
		
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLiudianrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 留点记录表
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecord(long id){
		return (Liudianrecord)(getSqlMapClientTemplate().queryForObject("findLiudianrecord",id));
	}
	/**
	 * 查找 留点记录表 by language
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecordbylanguage(long id,Integer language){
		String where = " where 1=1 ";
		List list=findAllLiudianrecord(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Liudianrecord)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrecord(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where 1=1";
		}
		
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLiudianrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLiudianrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找留点记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLiudianrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 留点记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLiudianrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLiudianrecordBySql",map).toString()));
	}
}

