/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triporder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TriporderManager extends  SqlMapClientDaoSupport  implements ITriporderManager{ 
	
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Triporder createTriporder(Triporder triporder) throws SQLException{
	
		if(triporder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		triporder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRIPORDER"));
		getSqlMapClientTemplate().insert("createTriporder",triporder);
		if(triporder.getUcode()==null||triporder.getUcode()<1)
		{
			triporder.setUcode(triporder.getId());
			updateTriporderIgnoreNull(triporder);
		}
		return triporder;
	}
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriporder(long id){
	
		return getSqlMapClientTemplate().delete("deleteTriporder", id);
	}
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTriporder(Triporder triporder){
		return getSqlMapClientTemplate().update("updateTriporder",triporder);
	
	}

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriporderIgnoreNull(Triporder triporder){
		Triporder tmp = findTriporder(triporder.getId());
		int flag =0;
		
		
		if(triporder.getCreateuser()!=null){
			tmp.setCreateuser(triporder.getCreateuser());
			
			flag++;
		}
		
		if(triporder.getCreatetime()!=null){
			tmp.setCreatetime(triporder.getCreatetime());
			
			flag++;
		}
		
		if(triporder.getModifyuser()!=null){
			tmp.setModifyuser(triporder.getModifyuser());
			
			flag++;
		}
		if(triporder.getFanprice()!=null){
			tmp.setFanprice(triporder.getFanprice());
			
			flag++;
		}
		
		if(triporder.getModifytime()!=null){
			tmp.setModifytime(triporder.getModifytime());
			
			flag++;
		}
		
		if(triporder.getTriplineid()!=null){
			tmp.setTriplineid(triporder.getTriplineid());
			
			flag++;
		}
		
		if(triporder.getPnum()!=null){
			tmp.setPnum(triporder.getPnum());
			
			flag++;
		}
		
		if(triporder.getSump()!=null){
			tmp.setSump(triporder.getSump());
			
			flag++;
		}
		
		if(triporder.getCode()!=null){
			tmp.setCode(triporder.getCode());
			
			flag++;
		}
		
		if(triporder.getState()!=null){
			tmp.setState(triporder.getState());
			
			flag++;
		}
		
		if(triporder.getLinkname()!=null){
			tmp.setLinkname(triporder.getLinkname());
			
			flag++;
		}
		
		if(triporder.getLinkmobile()!=null){
			tmp.setLinkmobile(triporder.getLinkmobile());
			
			flag++;
		}
		
		if(triporder.getLinkmail()!=null){
			tmp.setLinkmail(triporder.getLinkmail());
			
			flag++;
		}
		
		if(triporder.getLinktell()!=null){
			tmp.setLinktell(triporder.getLinktell());
			
			flag++;
		}
		
		if(triporder.getSpecreq()!=null){
			tmp.setSpecreq(triporder.getSpecreq());
			
			flag++;
		}
		
		if(triporder.getStatetime()!=null){
			tmp.setStatetime(triporder.getStatetime());
			
			flag++;
		}
		
		if(triporder.getUcode()!=null){
			tmp.setUcode(triporder.getUcode());
			
			flag++;
		}
		
		if(triporder.getLanguage()!=null){
			tmp.setLanguage(triporder.getLanguage());
			
			flag++;
		}
		
		if(triporder.getMemberid()!=null){
			tmp.setMemberid(triporder.getMemberid());
			
			flag++;
		}
		
		if(triporder.getLockuser()!=null){
			tmp.setLockuser(triporder.getLockuser());
			
			flag++;
		}
		
		if(triporder.getLockstate()!=null){
			tmp.setLockstate(triporder.getLockstate());
			
			flag++;
		}
		
		if(triporder.getLocktime()!=null){
			tmp.setLocktime(triporder.getLocktime());
			
			flag++;
		}
		
		if(triporder.getBuyagentid()!=null)
		{
			tmp.setBuyagentid(triporder.getBuyagentid());
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTriporder",tmp);
		}
	}
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,int limit,int offset){
		/*if(where==null||where.trim().length()==0)
		{
			where=" where ("+Triporder.COL_language+" = 0 OR "+Triporder.COL_language+" is NULL)";
		}
		else if(where.indexOf(Triporder.COL_language)<0)
		{
			where+=" and ("+Triporder.COL_language+" = 0 OR "+Triporder.COL_language+" is NULL)";
		}*/
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTriporder",map, offset, limit);
	}
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Triporder findTriporder(long id){
		return (Triporder)(getSqlMapClientTemplate().queryForObject("findTriporder",id));
	}
	/**
	 * 查找 线路订单 by language
	 * @param id
	 * @return
	 */
	public Triporder findTriporderbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Triporder.COL_ucode+" = "+id+" and "+Triporder.COL_language+" = "+language;	
		List list=findAllTriporder(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Triporder)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,PageInfo pageinfo){
		/*if(where==null||where.trim().length()==0)
		{
			where=" where "+Triporder.COL_language+" = 0";
		}
		else if(where.indexOf(Triporder.COL_language)<0)
		{
			where+=" and "+Triporder.COL_language+" = 0";
		}*/
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriporderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTriporder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTriporderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriporderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTriporderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriporderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTriporderBySql",map).toString()));
	}
}

