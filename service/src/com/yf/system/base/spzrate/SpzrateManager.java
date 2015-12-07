/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spzrate;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpzrateManager extends  SqlMapClientDaoSupport  implements ISpzrateManager{ 
	
  
 	/**
	 * 创建 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public Spzrate createSpzrate(Spzrate spzrate) throws SQLException{
	
		if(spzrate.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spzrate.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPZRATE"));
		getSqlMapClientTemplate().insert("createSpzrate",spzrate);
		if(spzrate.getUcode()==null||spzrate.getUcode()<1)
		{
			spzrate.setUcode(spzrate.getId());
			updateSpzrateIgnoreNull(spzrate);
		}
		return spzrate;
	}
	/**
	 * 删除 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpzrate(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpzrate", id);
	}
	
	
	/**
	 * 修改 特价政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateSpzrate(Spzrate spzrate){
		return getSqlMapClientTemplate().update("updateSpzrate",spzrate);
	
	}

		
	/**
	 * 修改 特价政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpzrateIgnoreNull(Spzrate spzrate){
		Spzrate tmp = findSpzrate(spzrate.getId());
		int flag =0;
		
		
		if(spzrate.getDepartureport()!=null){
			tmp.setDepartureport(spzrate.getDepartureport());
			
			flag++;
		}
		
		if(spzrate.getArrivalport()!=null){
			tmp.setArrivalport(spzrate.getArrivalport());
			
			flag++;
		}
		
		if(spzrate.getTraveltype()!=null){
			tmp.setTraveltype(spzrate.getTraveltype());
			
			flag++;
		}
		
		if(spzrate.getOutpattern()!=null){
			tmp.setOutpattern(spzrate.getOutpattern());
			
			flag++;
		}
		
		if(spzrate.getMoneykeep()!=null){
			tmp.setMoneykeep(spzrate.getMoneykeep());
			
			flag++;
		}
		
		if(spzrate.getPointkeep()!=null){
			tmp.setPointkeep(spzrate.getPointkeep());
			
			flag++;
		}
		
		if(spzrate.getFlightnumber()!=null){
			tmp.setFlightnumber(spzrate.getFlightnumber());
			
			flag++;
		}
		
		if(spzrate.getCabincode()!=null){
			tmp.setCabincode(spzrate.getCabincode());
			
			flag++;
		}
		
		if(spzrate.getRatevalue()!=null){
			tmp.setRatevalue(spzrate.getRatevalue());
			
			flag++;
		}
		
		if(spzrate.getCreateuser()!=null){
			tmp.setCreateuser(spzrate.getCreateuser());
			
			flag++;
		}
		
		if(spzrate.getCreatetime()!=null){
			tmp.setCreatetime(spzrate.getCreatetime());
			
			flag++;
		}
		
		if(spzrate.getModifyuser()!=null){
			tmp.setModifyuser(spzrate.getModifyuser());
			
			flag++;
		}
		
		if(spzrate.getModifytime()!=null){
			tmp.setModifytime(spzrate.getModifytime());
			
			flag++;
		}
		
		if(spzrate.getIssuedstartdate()!=null){
			tmp.setIssuedstartdate(spzrate.getIssuedstartdate());
			
			flag++;
		}
		
		if(spzrate.getIssuedendate()!=null){
			tmp.setIssuedendate(spzrate.getIssuedendate());
			
			flag++;
		}
		
		if(spzrate.getRemark()!=null){
			tmp.setRemark(spzrate.getRemark());
			
			flag++;
		}
		
		if(spzrate.getWeeknum()!=null){
			tmp.setWeeknum(spzrate.getWeeknum());
			
			flag++;
		}
		
		if(spzrate.getIsenable()!=null){
			tmp.setIsenable(spzrate.getIsenable());
			
			flag++;
		}
		
		if(spzrate.getAircompanycode()!=null){
			tmp.setAircompanycode(spzrate.getAircompanycode());
			
			flag++;
		}
		
		if(spzrate.getAgentid()!=null){
			tmp.setAgentid(spzrate.getAgentid());
			
			flag++;
		}
		
		if(spzrate.getTickettype()!=null){
			tmp.setTickettype(spzrate.getTickettype());
			
			flag++;
		}
		
		if(spzrate.getRelationspzrateid()!=null){
			tmp.setRelationspzrateid(spzrate.getRelationspzrateid());
			
			flag++;
		}
		
		if(spzrate.getAgentcode()!=null){
			tmp.setAgentcode(spzrate.getAgentcode());
			
			flag++;
		}
		
		if(spzrate.getType()!=null){
			tmp.setType(spzrate.getType());
			
			flag++;
		}
		
		if(spzrate.getUcode()!=null){
			tmp.setUcode(spzrate.getUcode());
			
			flag++;
		}
		
		if(spzrate.getLanguage()!=null){
			tmp.setLanguage(spzrate.getLanguage());
			
			flag++;
		}
		
		if(spzrate.getIsauto()!=null){
			tmp.setIsauto(spzrate.getIsauto());
			
			flag++;
		}
		
		if(spzrate.getIschange()!=null){
			tmp.setIschange(spzrate.getIschange());
			
			flag++;
		}
		
		if(spzrate.getLocalspzrate()!=null){
			tmp.setLocalspzrate(spzrate.getLocalspzrate());
			
			flag++;
		}
		
		if(spzrate.getAddratevalue()!=null){
			tmp.setAddratevalue(spzrate.getAddratevalue());
			
			flag++;
		}
		
		if(spzrate.getGeneral()!=null){
			tmp.setGeneral(spzrate.getGeneral());
			
			flag++;
		}
		
		if(spzrate.getPoll()!=null){
			tmp.setPoll(spzrate.getPoll());
			
			flag++;
		}
		
		if(spzrate.getZratetype()!=null){
			tmp.setZratetype(spzrate.getZratetype());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpzrate",tmp);
		}
	}
	
	/**
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Spzrate.COL_language+" = 0 OR "+Spzrate.COL_language+" is NULL)";
		}
		else if(where.indexOf(Spzrate.COL_language)<0)
		{
			where+=" and ("+Spzrate.COL_language+" = 0 OR "+Spzrate.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpzrate",map, offset, limit);
	}
		
	
	/**
	 * 查找 特价政策表
	 * @param id
	 * @return
	 */
	public Spzrate findSpzrate(long id){
		return (Spzrate)(getSqlMapClientTemplate().queryForObject("findSpzrate",id));
	}
	/**
	 * 查找 特价政策表 by language
	 * @param id
	 * @return
	 */
	public Spzrate findSpzratebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Spzrate.COL_ucode+" = "+id+" and "+Spzrate.COL_language+" = "+language;	
		List list=findAllSpzrate(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Spzrate)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Spzrate.COL_language+" = 0";
		}
		else if(where.indexOf(Spzrate.COL_language)<0)
		{
			where+=" and "+Spzrate.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpzrateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpzrate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找特价政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpzrateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 特价政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpzrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpzrateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpzrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpzrateBySql",map).toString()));
	}
}

