/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customerintegralrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomerintegralrecordManager extends  SqlMapClientDaoSupport  implements ICustomerintegralrecordManager{ 
	
  
 	/**
	 * 创建 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public Customerintegralrecord createCustomerintegralrecord(Customerintegralrecord customerintegralrecord) throws SQLException{
	
		if(customerintegralrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		customerintegralrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERINTEGRALRECORD"));
		getSqlMapClientTemplate().insert("createCustomerintegralrecord",customerintegralrecord);
		return customerintegralrecord;
	}
	/**
	 * 删除 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerintegralrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomerintegralrecord", id);
	}
	
	
	/**
	 * 修改 会员积分记录
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerintegralrecord(Customerintegralrecord customerintegralrecord){
		return getSqlMapClientTemplate().update("updateCustomerintegralrecord",customerintegralrecord);
	
	}

		
	/**
	 * 修改 会员积分记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerintegralrecordIgnoreNull(Customerintegralrecord customerintegralrecord){
		Customerintegralrecord tmp = findCustomerintegralrecord(customerintegralrecord.getId());
		int flag =0;
		
		
		if(customerintegralrecord.getRefuid()>0){
			tmp.setRefuid(customerintegralrecord.getRefuid());
			
			flag++;
		}
		
		if(customerintegralrecord.getScore()!=null){
			tmp.setScore(customerintegralrecord.getScore());
			
			flag++;
		}
		
		if(customerintegralrecord.getCreatetime()!=null){
			tmp.setCreatetime(customerintegralrecord.getCreatetime());
			
			flag++;
		}
		
		if(customerintegralrecord.getScorememo()!=null){
			tmp.setScorememo(customerintegralrecord.getScorememo());
			
			flag++;
		}
		
		if(customerintegralrecord.getRefordernumber()!=null){
			tmp.setRefordernumber(customerintegralrecord.getRefordernumber());
			
			flag++;
		}
		if(customerintegralrecord.getScoresource()!=null){
			tmp.setScoresource(customerintegralrecord.getScoresource());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomerintegralrecord",tmp);
		}
	}
	
	/**
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomerintegralrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 会员积分记录
	 * @param id
	 * @return
	 */
	public Customerintegralrecord findCustomerintegralrecord(long id){
		return (Customerintegralrecord)(getSqlMapClientTemplate().queryForObject("findCustomerintegralrecord",id));
	}
	
	/** 
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomerintegralrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomerintegralrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会员积分记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomerintegralrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会员积分记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerintegralrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomerintegralrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerintegralrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomerintegralrecordBySql",map).toString()));
	}
}

