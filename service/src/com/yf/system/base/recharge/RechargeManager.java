/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.recharge;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RechargeManager extends  SqlMapClientDaoSupport  implements IRechargeManager{ 
	
  
 	/**
	 * 创建 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public Recharge createRecharge(Recharge recharge) throws SQLException{
	
		if(recharge.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		recharge.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RECHARGE"));
		getSqlMapClientTemplate().insert("createRecharge",recharge);
		return recharge;
	}
	/**
	 * 删除 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRecharge(long id){
	
		return getSqlMapClientTemplate().delete("deleteRecharge", id);
	}
	
	
	/**
	 * 修改 手机充值
	 * @param id
	 * @return updated count 
	 */
	public int updateRecharge(Recharge recharge){
		return getSqlMapClientTemplate().update("updateRecharge",recharge);
	
	}

		
	/**
	 * 修改 手机充值但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRechargeIgnoreNull(Recharge recharge){
		Recharge tmp = findRecharge(recharge.getId());
		int flag =0;
		
		
		if(recharge.getOrdernumber()!=null){
			tmp.setOrdernumber(recharge.getOrdernumber());			
			flag++;
		}
		
		if(recharge.getPaystate()>-1){
			tmp.setPaystate(recharge.getPaystate());
			flag++;
		}
		if(recharge.getRefordernumber()!=null){
			tmp.setRefordernumber(recharge.getRefordernumber());
			
			flag++;
		}
		
		if(recharge.getPaymethod()>0){
			tmp.setPaymethod(recharge.getPaymethod());
			flag++;
		}
		
		if(recharge.getCardnum()!=null){
			tmp.setCardnum(recharge.getCardnum());
			
			flag++;
		}
		
		if(recharge.getPhonetype()>0){
			tmp.setPhonetype(recharge.getPhonetype());
			flag++;
			
		}
		if(recharge.getRechagentid()>0){
			tmp.setRechagentid(recharge.getRechagentid());
			flag++;
			
		}
		if(recharge.getRechtouid()>0){
			tmp.setRechtouid(recharge.getRechtouid());
			flag++;
			
		}
		
		if(recharge.getPhonenumber()!=null){
			tmp.setPhonenumber(recharge.getPhonenumber());
			
			flag++;
		}
		
		if(recharge.getRechmoney()!=null){
			tmp.setRechmoney(recharge.getRechmoney());
			
			flag++;
		}
		if(recharge.getInprice()!=null){
			tmp.setInprice(recharge.getInprice());
			
			flag++;
		}
		
		if(recharge.getRechtime()!=null){
			tmp.setRechtime(recharge.getRechtime());
			
			flag++;
		}
		
		if(recharge.getRechuid()!=-1){
			tmp.setRechuid(recharge.getRechuid());
			
			flag++;
		}
		
		if(recharge.getState()!=-1){
			tmp.setState(recharge.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRecharge",tmp);
		}
	}
	
	/**
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRecharge(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRecharge",map, offset, limit);
	}
		
	
	/**
	 * 查找 手机充值
	 * @param id
	 * @return
	 */
	public Recharge findRecharge(long id){
		return (Recharge)(getSqlMapClientTemplate().queryForObject("findRecharge",id));
	}
	
	/** 
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRecharge(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRechargeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRecharge",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找手机充值
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRecharge(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRechargeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 手机充值
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRechargeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRechargeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRechargeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRechargeBySql",map).toString()));
	}
}

