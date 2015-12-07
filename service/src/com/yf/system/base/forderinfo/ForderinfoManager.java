/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.forderinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ForderinfoManager extends  SqlMapClientDaoSupport  implements IForderinfoManager{ 
	
  
 	/**
	 * 创建 国际机票订单表
	 * @param id
	 * @return deleted count 
	 */
	public Forderinfo createForderinfo(Forderinfo forderinfo) throws SQLException{
	
		if(forderinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		forderinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FORDERINFO"));
		getSqlMapClientTemplate().insert("createForderinfo",forderinfo);
		return forderinfo;
	}
	/**
	 * 删除 国际机票订单表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteForderinfo", id);
	}
	
	
	/**
	 * 修改 国际机票订单表
	 * @param id
	 * @return updated count 
	 */
	public int updateForderinfo(Forderinfo forderinfo){
		return getSqlMapClientTemplate().update("updateForderinfo",forderinfo);
	
	}

		
	/**
	 * 修改 国际机票订单表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateForderinfoIgnoreNull(Forderinfo forderinfo){
		Forderinfo tmp = findForderinfo(forderinfo.getId());
		int flag =0;
		
		
		if(forderinfo.getOrdernumber()!=null){
			tmp.setOrdernumber(forderinfo.getOrdernumber());
			
			flag++;
		}
		
		if(forderinfo.getContactname()!=null){
			tmp.setContactname(forderinfo.getContactname());
			
			flag++;
		}
		
		if(forderinfo.getContactmobile()!=null){
			tmp.setContactmobile(forderinfo.getContactmobile());
			
			flag++;
		}
		
		if(forderinfo.getContactphone()!=null){
			tmp.setContactphone(forderinfo.getContactphone());
			
			flag++;
		}
		
		if(forderinfo.getContactemail()!=null){
			tmp.setContactemail(forderinfo.getContactemail());
			
			flag++;
		}
		
		if(forderinfo.getContactmark()!=null){
			tmp.setContactmark(forderinfo.getContactmark());
			
			flag++;
		}
		
		if(forderinfo.getOrderstatus()!=null){
			tmp.setOrderstatus(forderinfo.getOrderstatus());
			
			flag++;
		}
		
		if(forderinfo.getCustomerid()!=null){
			tmp.setCustomerid(forderinfo.getCustomerid());
			
			flag++;
		}
		
		if(forderinfo.getEmployeeid()!=null){
			tmp.setEmployeeid(forderinfo.getEmployeeid());
			
			flag++;
		}
		
		if(forderinfo.getCreatetime()!=null){
			tmp.setCreatetime(forderinfo.getCreatetime());
			
			flag++;
		}
		
		if(forderinfo.getPrncode()!=null){
			tmp.setPrncode(forderinfo.getPrncode());
			
			flag++;
		}
		
		if(forderinfo.getActioncode()!=null){
			tmp.setActioncode(forderinfo.getActioncode());
			
			flag++;
		}
		
		if(forderinfo.getTotalticketfare()!=null){
			tmp.setTotalticketfare(forderinfo.getTotalticketfare());
			
			flag++;
		}
		
		if(forderinfo.getTotalfax()!=null){
			tmp.setTotalfax(forderinfo.getTotalfax());
			
			flag++;
		}
		
		if(forderinfo.getRefundstatus()!=null){
			tmp.setRefundstatus(forderinfo.getRefundstatus());
			
			flag++;
		}
		
		if(forderinfo.getDeliverstatus()!=null){
			tmp.setDeliverstatus(forderinfo.getDeliverstatus());
			
			flag++;
		}
		
		if(forderinfo.getPaystatus()!=null){
			tmp.setPaystatus(forderinfo.getPaystatus());
			
			flag++;
		}
		
		if(forderinfo.getOrdertype()!=null){
			tmp.setOrdertype(forderinfo.getOrdertype());
			
			flag++;
		}
		
		if(forderinfo.getPaytype()!=null){
			tmp.setPaytype(forderinfo.getPaytype());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateForderinfo",tmp);
		}
	}
	
	/**
	 * 查找 国际机票订单表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllForderinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票订单表
	 * @param id
	 * @return
	 */
	public Forderinfo findForderinfo(long id){
		return (Forderinfo)(getSqlMapClientTemplate().queryForObject("findForderinfo",id));
	}
	
	/** 
	 * 查找 国际机票订单表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countForderinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllForderinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票订单表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllForderinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票订单表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteForderinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countForderinfoBySql",map).toString()));
	}
}

