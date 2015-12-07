/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeraircard;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomeraircardManager extends  SqlMapClientDaoSupport  implements ICustomeraircardManager{ 
	
  
 	/**
	 * 创建 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public Customeraircard createCustomeraircard(Customeraircard customeraircard) throws SQLException{
	
		if(customeraircard.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		customeraircard.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERAIRCARD"));
		getSqlMapClientTemplate().insert("createCustomeraircard",customeraircard);
		return customeraircard;
	}
	/**
	 * 删除 里程卡
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeraircard(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomeraircard", id);
	}
	
	
	/**
	 * 修改 里程卡
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeraircard(Customeraircard customeraircard){
		return getSqlMapClientTemplate().update("updateCustomeraircard",customeraircard);
	
	}

		
	/**
	 * 修改 里程卡但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeraircardIgnoreNull(Customeraircard customeraircard){
		Customeraircard tmp = findCustomeraircard(customeraircard.getId());
		int flag =0;
		
		
		if(customeraircard.getAircardtype()!=null){
			tmp.setAircardtype(customeraircard.getAircardtype());
			
			flag++;
		}
		
		if(customeraircard.getAircardnumber()!=null){
			tmp.setAircardnumber(customeraircard.getAircardnumber());
			
			flag++;
		}
		
		if(customeraircard.getCreateuser()!=null){
			tmp.setCreateuser(customeraircard.getCreateuser());
			
			flag++;
		}
		
		if(customeraircard.getCreatetime()!=null){
			tmp.setCreatetime(customeraircard.getCreatetime());
			
			flag++;
		}
		
		if(customeraircard.getModifyuser()!=null){
			tmp.setModifyuser(customeraircard.getModifyuser());
			
			flag++;
		}
		
		if(customeraircard.getModifytime()!=null){
			tmp.setModifytime(customeraircard.getModifytime());
			
			flag++;
		}
		
		if(customeraircard.getRefid()!=null){
			tmp.setRefid(customeraircard.getRefid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomeraircard",tmp);
		}
	}
	
	/**
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomeraircard",map, offset, limit);
	}
		
	
	/**
	 * 查找 里程卡
	 * @param id
	 * @return
	 */
	public Customeraircard findCustomeraircard(long id){
		return (Customeraircard)(getSqlMapClientTemplate().queryForObject("findCustomeraircard",id));
	}
	
	/** 
	 * 查找 里程卡
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeraircard(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeraircardBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomeraircard",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找里程卡
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeraircard(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomeraircardBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 里程卡
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeraircardBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomeraircardBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeraircardBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeraircardBySql",map).toString()));
	}
}

