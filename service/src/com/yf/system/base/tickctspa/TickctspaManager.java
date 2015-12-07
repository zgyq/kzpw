/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tickctspa;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TickctspaManager extends  SqlMapClientDaoSupport  implements ITickctspaManager{ 
	
  
 	/**
	 * 创建 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public Tickctspa createTickctspa(Tickctspa tickctspa) throws SQLException{
	
		if(tickctspa.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tickctspa.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TICKCTSPA"));
		getSqlMapClientTemplate().insert("createTickctspa",tickctspa);
		if(tickctspa.getUcode()==null||tickctspa.getUcode()<1)
		{
			tickctspa.setUcode(tickctspa.getId());
			updateTickctspaIgnoreNull(tickctspa);
		}
		return tickctspa;
	}
	/**
	 * 删除 票务温泉
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickctspa(long id){
	
		return getSqlMapClientTemplate().delete("deleteTickctspa", id);
	}
	
	
	/**
	 * 修改 票务温泉
	 * @param id
	 * @return updated count 
	 */
	public int updateTickctspa(Tickctspa tickctspa){
		return getSqlMapClientTemplate().update("updateTickctspa",tickctspa);
	
	}

		
	/**
	 * 修改 票务温泉但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickctspaIgnoreNull(Tickctspa tickctspa){
		Tickctspa tmp = findTickctspa(tickctspa.getId());
		int flag =0;
		
		
		if(tickctspa.getName()!=null){
			tmp.setName(tickctspa.getName());
			
			flag++;
		}
		
		if(tickctspa.getPrice()!=null){
			tmp.setPrice(tickctspa.getPrice());
			
			flag++;
		}
		
		if(tickctspa.getPeriod()!=null){
			tmp.setPeriod(tickctspa.getPeriod());
			
			flag++;
		}
		
		if(tickctspa.getDesc()!=null){
			tmp.setDesc(tickctspa.getDesc());
			
			flag++;
		}
		
		if(tickctspa.getCreatetime()!=null){
			tmp.setCreatetime(tickctspa.getCreatetime());
			
			flag++;
		}
		
		if(tickctspa.getCreateuser()!=null){
			tmp.setCreateuser(tickctspa.getCreateuser());
			
			flag++;
		}
		
		if(tickctspa.getModifytime()!=null){
			tmp.setModifytime(tickctspa.getModifytime());
			
			flag++;
		}
		
		if(tickctspa.getModifyuser()!=null){
			tmp.setModifyuser(tickctspa.getModifyuser());
			
			flag++;
		}
		
		if(tickctspa.getUcode()!=null){
			tmp.setUcode(tickctspa.getUcode());
			
			flag++;
		}
		
		if(tickctspa.getLanguage()!=null){
			tmp.setLanguage(tickctspa.getLanguage());
			
			flag++;
		}
		
		if(tickctspa.getHomeprice()!=null){
			tmp.setHomeprice(tickctspa.getHomeprice());
			
			flag++;
		}
		
		if(tickctspa.getPic()!=null){
			tmp.setPic(tickctspa.getPic());
			
			flag++;
		}
		
		if(tickctspa.getPic2()!=null){
			tmp.setPic2(tickctspa.getPic2());
			
			flag++;
		}
		
		if(tickctspa.getPic3()!=null){
			tmp.setPic3(tickctspa.getPic3());
			
			flag++;
		}
		
		if(tickctspa.getDescription()!=null){
			tmp.setDescription(tickctspa.getDescription());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTickctspa",tmp);
		}
	}
	
	/**
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Tickctspa.COL_language+" = 0 OR "+Tickctspa.COL_language+" is NULL)";
		}
		else if(where.indexOf(Tickctspa.COL_language)<0)
		{
			where+=" and ("+Tickctspa.COL_language+" = 0 OR "+Tickctspa.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTickctspa",map, offset, limit);
	}
		
	
	/**
	 * 查找 票务温泉
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspa(long id){
		return (Tickctspa)(getSqlMapClientTemplate().queryForObject("findTickctspa",id));
	}
	/**
	 * 查找 票务温泉 by language
	 * @param id
	 * @return
	 */
	public Tickctspa findTickctspabylanguage(long id,Integer language){
		String where = " where 1=1 and "+Tickctspa.COL_ucode+" = "+id+" and "+Tickctspa.COL_language+" = "+language;	
		List list=findAllTickctspa(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Tickctspa)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 票务温泉
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickctspa(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Tickctspa.COL_language+" = 0";
		}
		else if(where.indexOf(Tickctspa.COL_language)<0)
		{
			where+=" and "+Tickctspa.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTickctspaBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTickctspa",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找票务温泉
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickctspa(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTickctspaBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 票务温泉
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickctspaBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTickctspaBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickctspaBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTickctspaBySql",map).toString()));
	}
}

