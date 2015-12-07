/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.supteam;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SupteamManager extends  SqlMapClientDaoSupport  implements ISupteamManager{ 
	
  
 	/**
	 * 创建 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public Supteam createSupteam(Supteam supteam) throws SQLException{
	
		if(supteam.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		supteam.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SUPTEAM"));
		getSqlMapClientTemplate().insert("createSupteam",supteam);
		return supteam;
	}
	/**
	 * 删除 团队申请报价表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSupteam(long id){
	
		return getSqlMapClientTemplate().delete("deleteSupteam", id);
	}
	
	
	/**
	 * 修改 团队申请报价表
	 * @param id
	 * @return updated count 
	 */
	public int updateSupteam(Supteam supteam){
		return getSqlMapClientTemplate().update("updateSupteam",supteam);
	
	}

		
	/**
	 * 修改 团队申请报价表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSupteamIgnoreNull(Supteam supteam){
		Supteam tmp = findSupteam(supteam.getId());
		int flag =0;
		
		
		if(supteam.getTeamid()!=null){
			tmp.setTeamid(supteam.getTeamid());
			
			flag++;
		}
		
		if(supteam.getSupplierid()!=null){
			tmp.setSupplierid(supteam.getSupplierid());
			
			flag++;
		}
		
		if(supteam.getDistributorid()!=null){
			tmp.setDistributorid(supteam.getDistributorid());
			
			flag++;
		}
		
		if(supteam.getOffer()!=null){
			tmp.setOffer(supteam.getOffer());
			
			flag++;
		}
		
		if(supteam.getStatus()!=null){
			tmp.setStatus(supteam.getStatus());
			
			flag++;
		}
		if(supteam.getCreatetime()!=null){
			tmp.setCreatetime(supteam.getCreatetime());
			
			flag++;
		}
		if(supteam.getComment()!=null){
			tmp.setComment(supteam.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSupteam",tmp);
		}
	}
	
	/**
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSupteam",map, offset, limit);
	}
		
	
	/**
	 * 查找 团队申请报价表
	 * @param id
	 * @return
	 */
	public Supteam findSupteam(long id){
		return (Supteam)(getSqlMapClientTemplate().queryForObject("findSupteam",id));
	}
	
	/** 
	 * 查找 团队申请报价表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSupteamBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSupteam",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找团队申请报价表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSupteamBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 团队申请报价表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSupteamBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSupteamBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSupteamBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSupteamBySql",map).toString()));
	}
}

