/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.policyperiod;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PolicyperiodManager extends  SqlMapClientDaoSupport  implements IPolicyperiodManager{ 
	
  
 	/**
	 * 创建 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public Policyperiod createPolicyperiod(Policyperiod policyperiod) throws SQLException{
	
		if(policyperiod.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		policyperiod.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_POLICYPERIOD"));
		getSqlMapClientTemplate().insert("createPolicyperiod",policyperiod);
		if(policyperiod.getUcode()==null||policyperiod.getUcode()<1)
		{
			policyperiod.setUcode(policyperiod.getId());
			updatePolicyperiodIgnoreNull(policyperiod);
		}
		return policyperiod;
	}
	/**
	 * 删除 政策有效期表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePolicyperiod(long id){
	
		return getSqlMapClientTemplate().delete("deletePolicyperiod", id);
	}
	
	
	/**
	 * 修改 政策有效期表
	 * @param id
	 * @return updated count 
	 */
	public int updatePolicyperiod(Policyperiod policyperiod){
		return getSqlMapClientTemplate().update("updatePolicyperiod",policyperiod);
	
	}

		
	/**
	 * 修改 政策有效期表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePolicyperiodIgnoreNull(Policyperiod policyperiod){
		Policyperiod tmp = findPolicyperiod(policyperiod.getId());
		int flag =0;
		
		
		if(policyperiod.getPolicyguid()!=null){
			tmp.setPolicyguid(policyperiod.getPolicyguid());
			
			flag++;
		}
		
		if(policyperiod.getBegindate()!=null){
			tmp.setBegindate(policyperiod.getBegindate());
			
			flag++;
		}
		
		if(policyperiod.getEnddate()!=null){
			tmp.setEnddate(policyperiod.getEnddate());
			
			flag++;
		}
		
		if(policyperiod.getZrateid()!=null){
			tmp.setZrateid(policyperiod.getZrateid());
			
			flag++;
		}
		
		if(policyperiod.getCreateuser()!=null){
			tmp.setCreateuser(policyperiod.getCreateuser());
			
			flag++;
		}
		
		if(policyperiod.getCreatetime()!=null){
			tmp.setCreatetime(policyperiod.getCreatetime());
			
			flag++;
		}
		
		if(policyperiod.getModifyuser()!=null){
			tmp.setModifyuser(policyperiod.getModifyuser());
			
			flag++;
		}
		
		if(policyperiod.getModifytime()!=null){
			tmp.setModifytime(policyperiod.getModifytime());
			
			flag++;
		}
		
		if(policyperiod.getIsenable()!=null){
			tmp.setIsenable(policyperiod.getIsenable());
			
			flag++;
		}
		
		if(policyperiod.getUcode()!=null){
			tmp.setUcode(policyperiod.getUcode());
			
			flag++;
		}
		
		if(policyperiod.getLanguage()!=null){
			tmp.setLanguage(policyperiod.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePolicyperiod",tmp);
		}
	}
	
	/**
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Policyperiod.COL_language+" = 0 OR "+Policyperiod.COL_language+" is NULL)";
		}
		else if(where.indexOf(Policyperiod.COL_language)<0)
		{
			where+=" and ("+Policyperiod.COL_language+" = 0 OR "+Policyperiod.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPolicyperiod",map, offset, limit);
	}
		
	
	/**
	 * 查找 政策有效期表
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiod(long id){
		return (Policyperiod)(getSqlMapClientTemplate().queryForObject("findPolicyperiod",id));
	}
	/**
	 * 查找 政策有效期表 by language
	 * @param id
	 * @return
	 */
	public Policyperiod findPolicyperiodbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Policyperiod.COL_ucode+" = "+id+" and "+Policyperiod.COL_language+" = "+language;	
		List list=findAllPolicyperiod(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Policyperiod)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 政策有效期表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPolicyperiod(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Policyperiod.COL_language+" = 0";
		}
		else if(where.indexOf(Policyperiod.COL_language)<0)
		{
			where+=" and "+Policyperiod.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPolicyperiodBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPolicyperiod",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找政策有效期表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPolicyperiod(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPolicyperiodBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 政策有效期表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePolicyperiodBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePolicyperiodBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPolicyperiodBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPolicyperiodBySql",map).toString()));
	}
}

