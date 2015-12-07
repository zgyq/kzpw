/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tripnode;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TripnodeManager extends  SqlMapClientDaoSupport  implements ITripnodeManager{ 
	
  
 	/**
	 * 创建 注意事项
	 * @param id
	 * @return deleted count 
	 */
	public Tripnode createTripnode(Tripnode tripnode) throws SQLException{
	
		if(tripnode.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tripnode.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPNODE"));
		getSqlMapClientTemplate().insert("createTripnode",tripnode);
		if(tripnode.getUcode()==null||tripnode.getUcode()<1)
		{
			tripnode.setUcode(tripnode.getId());
			updateTripnodeIgnoreNull(tripnode);
		}
		return tripnode;
	}
	/**
	 * 删除 注意事项
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTripnode(long id){
	
		return getSqlMapClientTemplate().delete("deleteTripnode", id);
	}
	
	
	/**
	 * 修改 注意事项
	 * @param id
	 * @return updated count 
	 */
	public int updateTripnode(Tripnode tripnode){
		return getSqlMapClientTemplate().update("updateTripnode",tripnode);
	
	}

		
	/**
	 * 修改 注意事项但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTripnodeIgnoreNull(Tripnode tripnode){
		Tripnode tmp = findTripnode(tripnode.getId());
		int flag =0;
		
		
		if(tripnode.getTriplineid()!=null){
			tmp.setTriplineid(tripnode.getTriplineid());
			
			flag++;
		}
		
		if(tripnode.getName()!=null){
			tmp.setName(tripnode.getName());
			
			flag++;
		}
		
		if(tripnode.getCreateuser()!=null){
			tmp.setCreateuser(tripnode.getCreateuser());
			
			flag++;
		}
		
		if(tripnode.getCreatetime()!=null){
			tmp.setCreatetime(tripnode.getCreatetime());
			
			flag++;
		}
		
		if(tripnode.getModifyuser()!=null){
			tmp.setModifyuser(tripnode.getModifyuser());
			
			flag++;
		}
		
		if(tripnode.getModifytime()!=null){
			tmp.setModifytime(tripnode.getModifytime());
			
			flag++;
		}
		
		if(tripnode.getSort()!=null){
			tmp.setSort(tripnode.getSort());
			
			flag++;
		}
		
		if(tripnode.getType()!=null){
			tmp.setType(tripnode.getType());
			
			flag++;
		}
		
		if(tripnode.getContent()!=null){
			tmp.setContent(tripnode.getContent());
			
			flag++;
		}
		
		if(tripnode.getUcode()!=null){
			tmp.setUcode(tripnode.getUcode());
			
			flag++;
		}
		
		if(tripnode.getLanguage()!=null){
			tmp.setLanguage(tripnode.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTripnode",tmp);
		}
	}
	
	/**
	 * 查找 注意事项
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnode(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Tripnode.COL_language+" = 0 OR "+Tripnode.COL_language+" is NULL)";
		}
		else if(where.indexOf(Tripnode.COL_language)<0)
		{
			where+=" and ("+Tripnode.COL_language+" = 0 OR "+Tripnode.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTripnode",map, offset, limit);
	}
		
	
	/**
	 * 查找 注意事项
	 * @param id
	 * @return
	 */
	public Tripnode findTripnode(long id){
		return (Tripnode)(getSqlMapClientTemplate().queryForObject("findTripnode",id));
	}
	/**
	 * 查找 注意事项 by language
	 * @param id
	 * @return
	 */
	public Tripnode findTripnodebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Tripnode.COL_ucode+" = "+id+" and "+Tripnode.COL_language+" = "+language;	
		List list=findAllTripnode(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Tripnode)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 注意事项
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripnode(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Tripnode.COL_language+" = 0";
		}
		else if(where.indexOf(Tripnode.COL_language)<0)
		{
			where+=" and "+Tripnode.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTripnodeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTripnode",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找注意事项
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripnode(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTripnodeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 注意事项
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTripnodeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTripnodeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTripnodeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTripnodeBySql",map).toString()));
	}
}

