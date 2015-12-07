/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customerpassenger;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomerpassengerManager extends  SqlMapClientDaoSupport  implements ICustomerpassengerManager{ 
	
  
 	/**
	 * 创建 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public Customerpassenger createCustomerpassenger(Customerpassenger customerpassenger) throws SQLException{
	
		if(customerpassenger.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		customerpassenger.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERPASSENGER"));
		getSqlMapClientTemplate().insert("createCustomerpassenger",customerpassenger);
		return customerpassenger;
	}
	/**
	 * 删除 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerpassenger(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomerpassenger", id);
	}
	
	
	/**
	 * 修改 常用旅客
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerpassenger(Customerpassenger customerpassenger){
		return getSqlMapClientTemplate().update("updateCustomerpassenger",customerpassenger);
	
	}

		
	/**
	 * 修改 常用旅客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerpassengerIgnoreNull(Customerpassenger customerpassenger){
		Customerpassenger tmp = findCustomerpassenger(customerpassenger.getId());
		int flag =0;
		
		
		if(customerpassenger.getUsername()!=null){
			tmp.setUsername(customerpassenger.getUsername());
			
			flag++;
		}
		
		if(customerpassenger.getMemberemail()!=null){
			tmp.setMemberemail(customerpassenger.getMemberemail());
			
			flag++;
		}
		
		if(customerpassenger.getMobile()!=null){
			tmp.setMobile(customerpassenger.getMobile());
			
			flag++;
		}
		
		if(customerpassenger.getCreateuser()!=null){
			tmp.setCreateuser(customerpassenger.getCreateuser());
			
			flag++;
		}
		if(customerpassenger.getState()!=null){
			tmp.setState(customerpassenger.getState());
			
			flag++;
		}
		
		if(customerpassenger.getCreatetime()!=null){
			tmp.setCreatetime(customerpassenger.getCreatetime());
			
			flag++;
		}
		
		if(customerpassenger.getModifyuser()!=null){
			tmp.setModifyuser(customerpassenger.getModifyuser());
			
			flag++;
		}
		
		if(customerpassenger.getModifytime()!=null){
			tmp.setModifytime(customerpassenger.getModifytime());
			
			flag++;
		}
		
		if(customerpassenger.getType()!=null){
			tmp.setType(customerpassenger.getType());
			
			flag++;
		}
		
		if(customerpassenger.getCustomeruserid()!=null){
			tmp.setCustomeruserid(customerpassenger.getCustomeruserid());
			
			flag++;
		}
		
		if(customerpassenger.getSortid()!=null){
			tmp.setSortid(customerpassenger.getSortid());
			
			flag++;
		}
		
		if(customerpassenger.getAddress()!=null){
			tmp.setAddress(customerpassenger.getAddress());
			
			flag++;
		}
		
		if(customerpassenger.getEnname()!=null){
			tmp.setEnname(customerpassenger.getEnname());
			
			flag++;
		}
		
		if(customerpassenger.getEntrytime()!=null){
			tmp.setEntrytime(customerpassenger.getEntrytime());
			
			flag++;
		}
		
		if(customerpassenger.getLivingcardtype()!=null){
			tmp.setLivingcardtype(customerpassenger.getLivingcardtype());
			
			flag++;
		}
		
		if(customerpassenger.getLivingcardnum()!=null){
			tmp.setLivingcardnum(customerpassenger.getLivingcardnum());
			
			flag++;
		}
		
		if(customerpassenger.getLivingperiod()!=null){
			tmp.setLivingperiod(customerpassenger.getLivingperiod());
			
			flag++;
		}
		
		if(customerpassenger.getWorknumber()!=null){
			tmp.setWorknumber(customerpassenger.getWorknumber());
			
			flag++;
		}
		
		if(customerpassenger.getWorkperiod()!=null){
			tmp.setWorkperiod(customerpassenger.getWorkperiod());
			
			flag++;
		}
		
		if(customerpassenger.getChinaaddress()!=null){
			tmp.setChinaaddress(customerpassenger.getChinaaddress());
			
			flag++;
		}
		
		if(customerpassenger.getSex()!=null){
			tmp.setSex(customerpassenger.getSex());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomerpassenger",tmp);
		}
	}
	
	/**
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomerpassenger",map, offset, limit);
	}
		
	
	/**
	 * 查找 常用旅客
	 * @param id
	 * @return
	 */
	public Customerpassenger findCustomerpassenger(long id){
		return (Customerpassenger)(getSqlMapClientTemplate().queryForObject("findCustomerpassenger",id));
	}
	
	/** 
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomerpassengerBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomerpassenger",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找常用旅客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomerpassengerBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 常用旅客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerpassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomerpassengerBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerpassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomerpassengerBySql",map).toString()));
	}
}

