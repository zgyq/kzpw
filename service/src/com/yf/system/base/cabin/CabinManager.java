/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cabin;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CabinManager extends  SqlMapClientDaoSupport  implements ICabinManager{ 
	
  
 	/**
	 * 创建 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public Cabin createCabin(Cabin cabin) throws SQLException{
	
		if(cabin.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		cabin.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CABIN"));
		getSqlMapClientTemplate().insert("createCabin",cabin);
		if(cabin.getUcode()==null||cabin.getUcode()<1)
		{
			cabin.setUcode(cabin.getId());
			updateCabinIgnoreNull(cabin);
		}
		return cabin;
	}
	/**
	 * 删除 舱位基础信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCabin(long id){
	
		return getSqlMapClientTemplate().delete("deleteCabin", id);
	}
	
	
	/**
	 * 修改 舱位基础信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCabin(Cabin cabin){
		return getSqlMapClientTemplate().update("updateCabin",cabin);
	
	}

		
	/**
	 * 修改 舱位基础信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCabinIgnoreNull(Cabin cabin){
		Cabin tmp = findCabin(cabin.getId());
		int flag =0;
		
		
		if(cabin.getAircompanycode()!=null){
			tmp.setAircompanycode(cabin.getAircompanycode());
			
			flag++;
		}
		
		if(cabin.getCabincode()!=null){
			tmp.setCabincode(cabin.getCabincode());
			
			flag++;
		}
		
		if(cabin.getDiscount()!=null){
			tmp.setDiscount(cabin.getDiscount());
			
			flag++;
		}
		
		if(cabin.getIsenable()!=null){
			tmp.setIsenable(cabin.getIsenable());
			
			flag++;
		}
		
		if(cabin.getStratedate()!=null){
			tmp.setStratedate(cabin.getStratedate());
			
			flag++;
		}
		
		if(cabin.getEnddate()!=null){
			tmp.setEnddate(cabin.getEnddate());
			
			flag++;
		}
		
		if(cabin.getCreateuser()!=null){
			tmp.setCreateuser(cabin.getCreateuser());
			
			flag++;
		}
		
		if(cabin.getCreatetime()!=null){
			tmp.setCreatetime(cabin.getCreatetime());
			
			flag++;
		}
		
		if(cabin.getModifyuser()!=null){
			tmp.setModifyuser(cabin.getModifyuser());
			
			flag++;
		}
		
		if(cabin.getModifytime()!=null){
			tmp.setModifytime(cabin.getModifytime());
			
			flag++;
		}
		
		if(cabin.getCabinrule()!=null){
			tmp.setCabinrule(cabin.getCabinrule());
			
			flag++;
		}
		
		if(cabin.getTypename()!=null){
			tmp.setTypename(cabin.getTypename());
			
			flag++;
		}
		
		if(cabin.getUcode()!=null){
			tmp.setUcode(cabin.getUcode());
			
			flag++;
		}
		
		if(cabin.getLanguage()!=null){
			tmp.setLanguage(cabin.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCabin",tmp);
		}
	}
	
	/**
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabin(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Cabin.COL_language+" = 0 OR "+Cabin.COL_language+" is NULL)";
		}
		else if(where.indexOf(Cabin.COL_language)<0)
		{
			where+=" and ("+Cabin.COL_language+" = 0 OR "+Cabin.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCabin",map, offset, limit);
	}
		
	
	/**
	 * 查找 舱位基础信息表
	 * @param id
	 * @return
	 */
	public Cabin findCabin(long id){
		return (Cabin)(getSqlMapClientTemplate().queryForObject("findCabin",id));
	}
	/**
	 * 查找 舱位基础信息表 by language
	 * @param id
	 * @return
	 */
	public Cabin findCabinbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Cabin.COL_ucode+" = "+id+" and "+Cabin.COL_language+" = "+language;	
		List list=findAllCabin(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Cabin)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 舱位基础信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCabin(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Cabin.COL_language+" = 0";
		}
		else if(where.indexOf(Cabin.COL_language)<0)
		{
			where+=" and "+Cabin.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCabinBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCabin",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找舱位基础信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCabin(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCabinBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 舱位基础信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCabinBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCabinBySql",map).toString()));
	}
}

