/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insurorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InsurorderManager extends  SqlMapClientDaoSupport  implements IInsurorderManager{ 
	
  
 	/**
	 * 创建 订单表
	 * @param id
	 * @return deleted count 
	 */
	public Insurorder createInsurorder(Insurorder insurorder) throws SQLException{
	
		if(insurorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		insurorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INSURORDER"));
		getSqlMapClientTemplate().insert("createInsurorder",insurorder);
		return insurorder;
	}
	/**
	 * 删除 订单表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteInsurorder", id);
	}
	
	
	/**
	 * 修改 订单表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurorder(Insurorder insurorder){
		return getSqlMapClientTemplate().update("updateInsurorder",insurorder);
	
	}

		
	/**
	 * 修改 订单表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurorderIgnoreNull(Insurorder insurorder){
		Insurorder tmp = findInsurorder(insurorder.getId());
		int flag =0;
		
		
		if(insurorder.getLiushuino()!=null){
			tmp.setLiushuino(insurorder.getLiushuino());
			
			flag++;
		}
		
		if(insurorder.getOrderno()!=null){
			tmp.setOrderno(insurorder.getOrderno());
			
			flag++;
		}
		
		if(insurorder.getInsuranttype()!=0){
			tmp.setInsuranttype(insurorder.getInsuranttype());
			
			flag++;
		}
		
		if(insurorder.getInsurantcount()!=0){
			tmp.setInsurantcount(insurorder.getInsurantcount());
			
			flag++;
		}
		
		if(insurorder.getStatus()!=null){
			tmp.setStatus(insurorder.getStatus());
			
			flag++;
		}
		
		if(insurorder.getComputerid()!=0){
			tmp.setComputerid(insurorder.getComputerid());
			
			flag++;
		}
		
		if(insurorder.getUserid()!=0){
			tmp.setUserid(insurorder.getUserid());
			
			flag++;
		}
		
		if(insurorder.getInsuruserid()!=null){
			tmp.setInsuruserid(insurorder.getInsuruserid());
			
			flag++;
		}
		
		if(insurorder.getAgentid()!=0){
			tmp.setAgentid(insurorder.getAgentid());
			
			flag++;
		}
		
		if(insurorder.getTime()!=null){
			tmp.setTime(insurorder.getTime());
			
			flag++;
		}
		
		if(insurorder.getBegintime()!=null){
			tmp.setBegintime(insurorder.getBegintime());
			
			flag++;
		}
		
		if(insurorder.getInsurmoney()!=null){
			tmp.setInsurmoney(insurorder.getInsurmoney());
			
			flag++;
		}
		
		if(insurorder.getTotalmoney()!=null){
			tmp.setTotalmoney(insurorder.getTotalmoney());
			
			flag++;
		}
		
		if(insurorder.getEndtime()!=null){
			tmp.setEndtime(insurorder.getEndtime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInsurorder",tmp);
		}
	}
	
	/**
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInsurorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 订单表
	 * @param id
	 * @return
	 */
	public Insurorder findInsurorder(long id){
		return (Insurorder)(getSqlMapClientTemplate().queryForObject("findInsurorder",id));
	}
	
	/** 
	 * 查找 订单表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsurorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInsurorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找订单表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInsurorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 订单表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInsurorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsurorderBySql",map).toString()));
	}
}

