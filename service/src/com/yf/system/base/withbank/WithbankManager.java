/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.withbank;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class WithbankManager extends  SqlMapClientDaoSupport  implements IWithbankManager{ 
	
  
 	/**
	 * 创建 提现
	 * @param id
	 * @return deleted count 
	 */
	public Withbank createWithbank(Withbank withbank) throws SQLException{
	
		if(withbank.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		withbank.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_WITHBANK"));
		getSqlMapClientTemplate().insert("createWithbank",withbank);
		return withbank;
	}
	/**
	 * 删除 提现
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWithbank(long id){
	
		return getSqlMapClientTemplate().delete("deleteWithbank", id);
	}
	
	
	/**
	 * 修改 提现
	 * @param id
	 * @return updated count 
	 */
	public int updateWithbank(Withbank withbank){
		return getSqlMapClientTemplate().update("updateWithbank",withbank);
	
	}

		
	/**
	 * 修改 提现但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWithbankIgnoreNull(Withbank withbank){
		Withbank tmp = findWithbank(withbank.getId());
		int flag =0;
		
		
		if(withbank.getPrice()!=null){
			tmp.setPrice(withbank.getPrice());
			
			flag++;
		}
		
		if(withbank.getBankname()!=null){
			tmp.setBankname(withbank.getBankname());
			
			flag++;
		}
		
		if(withbank.getUsername()!=null){
			tmp.setUsername(withbank.getUsername());
			
			flag++;
		}
		
		if(withbank.getBankno()!=null){
			tmp.setBankno(withbank.getBankno());
			
			flag++;
		}
		
		if(withbank.getUserid()!=null){
			tmp.setUserid(withbank.getUserid());
			
			flag++;
		}
		
		if(withbank.getParam1()!=null){
			tmp.setParam1(withbank.getParam1());
			
			flag++;
		}
		
		if(withbank.getParam2()!=null){
			tmp.setParam2(withbank.getParam2());
			
			flag++;
		}
		
		if(withbank.getParam3()!=null){
			tmp.setParam3(withbank.getParam3());
			
			flag++;
		}
		
		if(withbank.getCreatetime()!=null){
			tmp.setCreatetime(withbank.getCreatetime());
			
			flag++;
		}
		
		if(withbank.getUpdatetime()!=null){
			tmp.setUpdatetime(withbank.getUpdatetime());
			
			flag++;
		}
		
		if(withbank.getState()!=null){
			tmp.setState(withbank.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateWithbank",tmp);
		}
	}
	
	/**
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllWithbank",map, offset, limit);
	}
		
	
	/**
	 * 查找 提现
	 * @param id
	 * @return
	 */
	public Withbank findWithbank(long id){
		return (Withbank)(getSqlMapClientTemplate().queryForObject("findWithbank",id));
	}
	
	/** 
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countWithbankBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllWithbank",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找提现
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllWithbankBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 提现
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWithbankBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteWithbankBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWithbankBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countWithbankBySql",map).toString()));
	}
}

