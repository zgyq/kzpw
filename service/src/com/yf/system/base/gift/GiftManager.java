/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gift;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class GiftManager extends  SqlMapClientDaoSupport  implements IGiftManager{ 
	
  
 	/**
	 * 创建 礼品
	 * @param id
	 * @return deleted count 
	 */
	public Gift createGift(Gift gift) throws SQLException{
	
		if(gift.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		gift.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_GIFT"));
		getSqlMapClientTemplate().insert("createGift",gift);
		if(gift.getUcode()==null||gift.getUcode()<1)
		{
			gift.setUcode(gift.getId());
			updateGiftIgnoreNull(gift);
		}
		return gift;
	}
	/**
	 * 删除 礼品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGift(long id){
	
		return getSqlMapClientTemplate().delete("deleteGift", id);
	}
	
	
	/**
	 * 修改 礼品
	 * @param id
	 * @return updated count 
	 */
	public int updateGift(Gift gift){
		return getSqlMapClientTemplate().update("updateGift",gift);
	
	}

		
	/**
	 * 修改 礼品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftIgnoreNull(Gift gift){
		Gift tmp = findGift(gift.getId());
		int flag =0;
		
		
		if(gift.getName()!=null){
			tmp.setName(gift.getName());
			
			flag++;
		}
		
		if(gift.getGiftcode()!=null){
			tmp.setGiftcode(gift.getGiftcode());
			
			flag++;
		}
		
		if(gift.getGiftdesc()!=null){
			tmp.setGiftdesc(gift.getGiftdesc());
			
			flag++;
		}
		
		if(gift.getBrand()!=null){
			tmp.setBrand(gift.getBrand());
			
			flag++;
		}
		
		if(gift.getOldintegral()!=null){
			tmp.setOldintegral(gift.getOldintegral());
			
			flag++;
		}
		
		if(gift.getUseintegral()!=null){
			tmp.setUseintegral(gift.getUseintegral());
			
			flag++;
		}
		
		if(gift.getPicsrc()!=null){
			tmp.setPicsrc(gift.getPicsrc());
			
			flag++;
		}
		
		if(gift.getOnline()!=null){
			tmp.setOnline(gift.getOnline());
			
			flag++;
		}
		
		if(gift.getCreateuser()!=null){
			tmp.setCreateuser(gift.getCreateuser());
			
			flag++;
		}
		
		if(gift.getCreatetime()!=null){
			tmp.setCreatetime(gift.getCreatetime());
			
			flag++;
		}
		
		if(gift.getModifyuser()!=null){
			tmp.setModifyuser(gift.getModifyuser());
			
			flag++;
		}
		
		if(gift.getModifytime()!=null){
			tmp.setModifytime(gift.getModifytime());
			
			flag++;
		}
		
		if(gift.getGiftcatalogid()!=null){
			tmp.setGiftcatalogid(gift.getGiftcatalogid());
			
			flag++;
		}
		
		if(gift.getUcode()!=null){
			tmp.setUcode(gift.getUcode());
			
			flag++;
		}
		
		if(gift.getLanguage()!=null){
			tmp.setLanguage(gift.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateGift",tmp);
		}
	}
	
	/**
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Gift.COL_language+" = 0 OR "+Gift.COL_language+" is NULL)";
		}
		else if(where.indexOf(Gift.COL_language)<0)
		{
			where+=" and ("+Gift.COL_language+" = 0 OR "+Gift.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllGift",map, offset, limit);
	}
		
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGift(long id){
		return (Gift)(getSqlMapClientTemplate().queryForObject("findGift",id));
	}
	/**
	 * 查找 礼品 by language
	 * @param id
	 * @return
	 */
	public Gift findGiftbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Gift.COL_ucode+" = "+id+" and "+Gift.COL_language+" = "+language;	
		List list=findAllGift(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Gift)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGift(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Gift.COL_language+" = 0";
		}
		else if(where.indexOf(Gift.COL_language)<0)
		{
			where+=" and "+Gift.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGiftBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllGift",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找礼品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllGiftBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 礼品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteGiftBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGiftBySql",map).toString()));
	}
}

