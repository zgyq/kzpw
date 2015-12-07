/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.orderinforc;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class OrderinforcManager extends  SqlMapClientDaoSupport  implements IOrderinforcManager{ 
	
  
 	/**
	 * 创建 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public Orderinforc createOrderinforc(Orderinforc orderinforc) throws SQLException{
	
		if(orderinforc.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		orderinforc.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ORDERINFORC"));
		getSqlMapClientTemplate().insert("createOrderinforc",orderinforc);
		if(orderinforc.getUcode()==null||orderinforc.getUcode()<1)
		{
			orderinforc.setUcode(orderinforc.getId());
			updateOrderinforcIgnoreNull(orderinforc);
		}
		return orderinforc;
	}
	/**
	 * 删除 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOrderinforc(long id){
	
		return getSqlMapClientTemplate().delete("deleteOrderinforc", id);
	}
	
	
	/**
	 * 修改 订单处理记录
	 * @param id
	 * @return updated count 
	 */
	public int updateOrderinforc(Orderinforc orderinforc){
		return getSqlMapClientTemplate().update("updateOrderinforc",orderinforc);
	
	}

		
	/**
	 * 修改 订单处理记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOrderinforcIgnoreNull(Orderinforc orderinforc){
		Orderinforc tmp = findOrderinforc(orderinforc.getId());
		int flag =0;
		
		
		if(orderinforc.getOrderinfoid()!=null){
			tmp.setOrderinfoid(orderinforc.getOrderinfoid());
			
			flag++;
		}
		
		if(orderinforc.getCustomeruserid()!=null){
			tmp.setCustomeruserid(orderinforc.getCustomeruserid());
			
			flag++;
		}
		if(orderinforc.getPassid()!=null){
			tmp.setPassid(orderinforc.getPassid());
			
			flag++;
		}
		
		if(orderinforc.getContent()!=null){
			tmp.setContent(orderinforc.getContent());
			
			flag++;
		}
		
		if(orderinforc.getCreatetime()!=null){
			tmp.setCreatetime(orderinforc.getCreatetime());
			
			flag++;
		}
		
		if(orderinforc.getState()!=null){
			tmp.setState(orderinforc.getState());
			
			flag++;
		}
		
		if(orderinforc.getSuouserid()!=null){
			tmp.setSuouserid(orderinforc.getSuouserid());
			
			flag++;
		}
		
		if(orderinforc.getUcode()!=null){
			tmp.setUcode(orderinforc.getUcode());
			
			flag++;
		}
		
		if(orderinforc.getLanguage()!=null){
			tmp.setLanguage(orderinforc.getLanguage());
			
			flag++;
		}
		if(orderinforc.getPrestate()!=null)
		{
            tmp.setPrestate(orderinforc.getPrestate());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateOrderinforc",tmp);
		}
	}
	
	/**
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Orderinforc.COL_language+" = 0 OR "+Orderinforc.COL_language+" is NULL)";
		}
		else if(where.indexOf(Orderinforc.COL_language)<0)
		{
			where+=" and ("+Orderinforc.COL_language+" = 0 OR "+Orderinforc.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllOrderinforc",map, offset, limit);
	}
		
	
	/**
	 * 查找 订单处理记录
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforc(long id){
		return (Orderinforc)(getSqlMapClientTemplate().queryForObject("findOrderinforc",id));
	}
	/**
	 * 查找 订单处理记录 by language
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforcbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Orderinforc.COL_ucode+" = "+id+" and "+Orderinforc.COL_language+" = "+language;	
		List list=findAllOrderinforc(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Orderinforc)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Orderinforc.COL_language+" = 0";
		}
		else if(where.indexOf(Orderinforc.COL_language)<0)
		{
			where+=" and "+Orderinforc.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countOrderinforcBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllOrderinforc",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找订单处理记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllOrderinforcBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 订单处理记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOrderinforcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteOrderinforcBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOrderinforcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countOrderinforcBySql",map).toString()));
	}
}

