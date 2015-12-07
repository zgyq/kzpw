/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.adcooperate;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AdcooperateManager extends  SqlMapClientDaoSupport  implements IAdcooperateManager{ 
	
  
 	/**
	 * 创建 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public Adcooperate createAdcooperate(Adcooperate adcooperate) throws SQLException{
	
		if(adcooperate.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		adcooperate.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ADCOOPERATE"));
		getSqlMapClientTemplate().insert("createAdcooperate",adcooperate);
		return adcooperate;
	}
	/**
	 * 删除 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdcooperate(long id){
	
		return getSqlMapClientTemplate().delete("deleteAdcooperate", id);
	}
	
	
	/**
	 * 修改 广告合作表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdcooperate(Adcooperate adcooperate){
		return getSqlMapClientTemplate().update("updateAdcooperate",adcooperate);
	
	}

		
	/**
	 * 修改 广告合作表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdcooperateIgnoreNull(Adcooperate adcooperate){
		Adcooperate tmp = findAdcooperate(adcooperate.getId());
		int flag =0;
		
		
		if(adcooperate.getCopname()!=null){
			tmp.setCopname(adcooperate.getCopname());
			
			flag++;
		}
		
		if(adcooperate.getAddress()!=null){
			tmp.setAddress(adcooperate.getAddress());
			
			flag++;
		}
		
		if(adcooperate.getCreatetime()!=null){
			tmp.setCreatetime(adcooperate.getCreatetime());
			
			flag++;
		}
		
		if(adcooperate.getUsername()!=null){
			tmp.setUsername(adcooperate.getUsername());
			
			flag++;
		}
		
		if(adcooperate.getMobile()!=null){
			tmp.setMobile(adcooperate.getMobile());
			
			flag++;
		}
		
		if(adcooperate.getComment()!=null){
			tmp.setComment(adcooperate.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAdcooperate",tmp);
		}
	}
	
	/**
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAdcooperate",map, offset, limit);
	}
		
	
	/**
	 * 查找 广告合作表
	 * @param id
	 * @return
	 */
	public Adcooperate findAdcooperate(long id){
		return (Adcooperate)(getSqlMapClientTemplate().queryForObject("findAdcooperate",id));
	}
	
	/** 
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAdcooperateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAdcooperate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找广告合作表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAdcooperateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 广告合作表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdcooperateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAdcooperateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdcooperateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAdcooperateBySql",map).toString()));
	}
}

