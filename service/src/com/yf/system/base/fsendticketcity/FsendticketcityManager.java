/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fsendticketcity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FsendticketcityManager extends  SqlMapClientDaoSupport  implements IFsendticketcityManager{ 
	
  
 	/**
	 * 创建 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public Fsendticketcity createFsendticketcity(Fsendticketcity fsendticketcity) throws SQLException{
	
		if(fsendticketcity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fsendticketcity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FSENDTICKETCITY"));
		getSqlMapClientTemplate().insert("createFsendticketcity",fsendticketcity);
		if(fsendticketcity.getUcode()==null||fsendticketcity.getUcode()<1)
		{
			fsendticketcity.setUcode(fsendticketcity.getId());
			updateFsendticketcityIgnoreNull(fsendticketcity);
		}
		return fsendticketcity;
	}
	/**
	 * 删除 国际机票送票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFsendticketcity(long id){
	
		return getSqlMapClientTemplate().delete("deleteFsendticketcity", id);
	}
	
	
	/**
	 * 修改 国际机票送票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateFsendticketcity(Fsendticketcity fsendticketcity){
		return getSqlMapClientTemplate().update("updateFsendticketcity",fsendticketcity);
	
	}

		
	/**
	 * 修改 国际机票送票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFsendticketcityIgnoreNull(Fsendticketcity fsendticketcity){
		Fsendticketcity tmp = findFsendticketcity(fsendticketcity.getId());
		int flag =0;
		
		
		if(fsendticketcity.getStcitycode()!=null){
			tmp.setStcitycode(fsendticketcity.getStcitycode());
			
			flag++;
		}
		
		if(fsendticketcity.getStcityname()!=null){
			tmp.setStcityname(fsendticketcity.getStcityname());
			
			flag++;
		}
		
		if(fsendticketcity.getStcitynameen()!=null){
			tmp.setStcitynameen(fsendticketcity.getStcitynameen());
			
			flag++;
		}
		
		if(fsendticketcity.getUcode()!=null){
			tmp.setUcode(fsendticketcity.getUcode());
			
			flag++;
		}
		
		if(fsendticketcity.getLanguage()!=null){
			tmp.setLanguage(fsendticketcity.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFsendticketcity",tmp);
		}
	}
	
	/**
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Fsendticketcity.COL_language+" = 0 OR "+Fsendticketcity.COL_language+" is NULL)";
		}
		else if(where.indexOf(Fsendticketcity.COL_language)<0)
		{
			where+=" and ("+Fsendticketcity.COL_language+" = 0 OR "+Fsendticketcity.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFsendticketcity",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票送票城市
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcity(long id){
		return (Fsendticketcity)(getSqlMapClientTemplate().queryForObject("findFsendticketcity",id));
	}
	/**
	 * 查找 国际机票送票城市 by language
	 * @param id
	 * @return
	 */
	public Fsendticketcity findFsendticketcitybylanguage(long id,Integer language){
		String where = " where 1=1 and "+Fsendticketcity.COL_ucode+" = "+id+" and "+Fsendticketcity.COL_language+" = "+language;	
		List list=findAllFsendticketcity(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Fsendticketcity)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 国际机票送票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFsendticketcity(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Fsendticketcity.COL_language+" = 0";
		}
		else if(where.indexOf(Fsendticketcity.COL_language)<0)
		{
			where+=" and "+Fsendticketcity.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFsendticketcityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFsendticketcity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票送票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFsendticketcity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFsendticketcityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票送票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFsendticketcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFsendticketcityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFsendticketcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFsendticketcityBySql",map).toString()));
	}
}

