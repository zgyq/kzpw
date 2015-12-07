/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.repay;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RepayManager extends  SqlMapClientDaoSupport  implements IRepayManager{ 
	
  
 	/**
	 * 创建 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public Repay createRepay(Repay repay) throws SQLException{
	
		if(repay.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		repay.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_REPAY"));
		getSqlMapClientTemplate().insert("createRepay",repay);
		return repay;
	}
	/**
	 * 删除 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRepay(long id){
	
		return getSqlMapClientTemplate().delete("deleteRepay", id);
	}
	
	
	/**
	 * 修改 大客户还款记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRepay(Repay repay){
		return getSqlMapClientTemplate().update("updateRepay",repay);
	
	}

		
	/**
	 * 修改 大客户还款记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRepayIgnoreNull(Repay repay){
		Repay tmp = findRepay(repay.getId());
		int flag =0;
		
		
		if(repay.getPassengerid()!=null){
			tmp.setPassengerid(repay.getPassengerid());
			
			flag++;
		}
		
		if(repay.getAgentid()!=null){
			tmp.setAgentid(repay.getAgentid());
			
			flag++;
		}
		if(repay.getPricetype()!=null){
			tmp.setPricetype(repay.getPricetype());
			
			flag++;
		}
		
		if(repay.getHkuanprice()!=null){
			tmp.setHkuanprice(repay.getHkuanprice());
			
			flag++;
		}
		
		if(repay.getOrderid()!=null){
			tmp.setOrderid(repay.getOrderid());
			
			flag++;
		}
		
		if(repay.getCreatetime()!=null){
			tmp.setCreatetime(repay.getCreatetime());
			
			flag++;
		}
		
		if(repay.getUpdateid()!=null){
			tmp.setUpdateid(repay.getUpdateid());
			
			flag++;
		}
		
		if(repay.getComment()!=null){
			tmp.setComment(repay.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRepay",tmp);
		}
	}
	
	/**
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRepay",map, offset, limit);
	}
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param id
	 * @return
	 */
	public Repay findRepay(long id){
		return (Repay)(getSqlMapClientTemplate().queryForObject("findRepay",id));
	}
	
	/** 
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRepay(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRepayBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRepay",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找大客户还款记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRepayBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 大客户还款记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRepayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRepayBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRepayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRepayBySql",map).toString()));
	}
}

