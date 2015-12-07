/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.giftcatalog;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class GiftcatalogManager extends  SqlMapClientDaoSupport  implements IGiftcatalogManager{ 
	
  
 	/**
	 * 创建 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public Giftcatalog createGiftcatalog(Giftcatalog giftcatalog) throws SQLException{
	
		if(giftcatalog.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		giftcatalog.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_GIFTCATALOG"));
		getSqlMapClientTemplate().insert("createGiftcatalog",giftcatalog);
		if(giftcatalog.getUcode()==null||giftcatalog.getUcode()<1)
		{
			giftcatalog.setUcode(giftcatalog.getId());
			updateGiftcatalogIgnoreNull(giftcatalog);
		}
		return giftcatalog;
	}
	/**
	 * 删除 礼品目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGiftcatalog(long id){
	
		return getSqlMapClientTemplate().delete("deleteGiftcatalog", id);
	}
	
	
	/**
	 * 修改 礼品目录
	 * @param id
	 * @return updated count 
	 */
	public int updateGiftcatalog(Giftcatalog giftcatalog){
		return getSqlMapClientTemplate().update("updateGiftcatalog",giftcatalog);
	
	}

		
	/**
	 * 修改 礼品目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftcatalogIgnoreNull(Giftcatalog giftcatalog){
		Giftcatalog tmp = findGiftcatalog(giftcatalog.getId());
		int flag =0;
		
		
		if(giftcatalog.getName()!=null){
			tmp.setName(giftcatalog.getName());
			
			flag++;
		}
		
		if(giftcatalog.getCode()!=null){
			tmp.setCode(giftcatalog.getCode());
			
			flag++;
		}
		
		if(giftcatalog.getParentid()!=null){
			tmp.setParentid(giftcatalog.getParentid());
			
			flag++;
		}
		
		if(giftcatalog.getParentidstr()!=null){
			tmp.setParentidstr(giftcatalog.getParentidstr());
			
			flag++;
		}
		
		if(giftcatalog.getDescription()!=null){
			tmp.setDescription(giftcatalog.getDescription());
			
			flag++;
		}
		
		if(giftcatalog.getCreateuser()!=null){
			tmp.setCreateuser(giftcatalog.getCreateuser());
			
			flag++;
		}
		
		if(giftcatalog.getCreatetime()!=null){
			tmp.setCreatetime(giftcatalog.getCreatetime());
			
			flag++;
		}
		
		if(giftcatalog.getModifyuser()!=null){
			tmp.setModifyuser(giftcatalog.getModifyuser());
			
			flag++;
		}
		
		if(giftcatalog.getModifytime()!=null){
			tmp.setModifytime(giftcatalog.getModifytime());
			
			flag++;
		}
		
		if(giftcatalog.getState()!=null){
			tmp.setState(giftcatalog.getState());
			
			flag++;
		}
		
		if(giftcatalog.getUcode()!=null){
			tmp.setUcode(giftcatalog.getUcode());
			
			flag++;
		}
		
		if(giftcatalog.getLanguage()!=null){
			tmp.setLanguage(giftcatalog.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateGiftcatalog",tmp);
		}
	}
	
	/**
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Giftcatalog.COL_language+" = 0 OR "+Giftcatalog.COL_language+" is NULL)";
		}
		else if(where.indexOf(Giftcatalog.COL_language)<0)
		{
			where+=" and ("+Giftcatalog.COL_language+" = 0 OR "+Giftcatalog.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllGiftcatalog",map, offset, limit);
	}
		
	
	/**
	 * 查找 礼品目录
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalog(long id){
		return (Giftcatalog)(getSqlMapClientTemplate().queryForObject("findGiftcatalog",id));
	}
	/**
	 * 查找 礼品目录 by language
	 * @param id
	 * @return
	 */
	public Giftcatalog findGiftcatalogbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Giftcatalog.COL_ucode+" = "+id+" and "+Giftcatalog.COL_language+" = "+language;	
		List list=findAllGiftcatalog(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Giftcatalog)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 礼品目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGiftcatalog(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Giftcatalog.COL_language+" = 0";
		}
		else if(where.indexOf(Giftcatalog.COL_language)<0)
		{
			where+=" and "+Giftcatalog.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGiftcatalogBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllGiftcatalog",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找礼品目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGiftcatalog(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllGiftcatalogBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 礼品目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftcatalogBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteGiftcatalogBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftcatalogBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGiftcatalogBySql",map).toString()));
	}
}

