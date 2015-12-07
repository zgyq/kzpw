/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.advertisement;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AdvertisementManager extends  SqlMapClientDaoSupport  implements IAdvertisementManager{ 
	
  
 	/**
	 * 创建 广告表
	 * @param id
	 * @return deleted count 
	 */
	public Advertisement createAdvertisement(Advertisement advertisement) throws SQLException{
	
		if(advertisement.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		advertisement.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ADVERTISEMENT"));
		getSqlMapClientTemplate().insert("createAdvertisement",advertisement);
		return advertisement;
	}
	/**
	 * 删除 广告表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdvertisement(long id){
	
		return getSqlMapClientTemplate().delete("deleteAdvertisement", id);
	}
	
	
	/**
	 * 修改 广告表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdvertisement(Advertisement advertisement){
		return getSqlMapClientTemplate().update("updateAdvertisement",advertisement);
	
	}

		
	/**
	 * 修改 广告表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdvertisementIgnoreNull(Advertisement advertisement){
		Advertisement tmp = findAdvertisement(advertisement.getId());
		int flag =0;
		
		
		if(advertisement.getPicsrc()!=null){
			tmp.setPicsrc(advertisement.getPicsrc());
			
			flag++;
		}
		
		if(advertisement.getUrlsrc()!=null){
			tmp.setUrlsrc(advertisement.getUrlsrc());
			
			flag++;
		}
		
		if(advertisement.getSort()!=null){
			tmp.setSort(advertisement.getSort());
			
			flag++;
		}
		
		if(advertisement.getType()!=null){
			tmp.setType(advertisement.getType());
			
			flag++;
		}
		
		if(advertisement.getDescription()!=null){
			tmp.setDescription(advertisement.getDescription());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAdvertisement",tmp);
		}
	}
	
	/**
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAdvertisement",map, offset, limit);
	}
		
	
	/**
	 * 查找 广告表
	 * @param id
	 * @return
	 */
	public Advertisement findAdvertisement(long id){
		return (Advertisement)(getSqlMapClientTemplate().queryForObject("findAdvertisement",id));
	}
	
	/** 
	 * 查找 广告表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdvertisement(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAdvertisementBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAdvertisement",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找广告表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdvertisement(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAdvertisementBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 广告表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdvertisementBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAdvertisementBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdvertisementBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAdvertisementBySql",map).toString()));
	}
}

