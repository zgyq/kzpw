/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.integral;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class IntegralManager extends  SqlMapClientDaoSupport  implements IIntegralManager{ 
	
  
 	/**
	 * 创建 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public Integral createIntegral(Integral integral) throws SQLException{
	
		if(integral.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		integral.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INTEGRAL"));
		getSqlMapClientTemplate().insert("createIntegral",integral);
		return integral;
	}
	/**
	 * 删除 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntegral(long id){
	
		return getSqlMapClientTemplate().delete("deleteIntegral", id);
	}
	
	
	/**
	 * 修改 积分管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntegral(Integral integral){
		return getSqlMapClientTemplate().update("updateIntegral",integral);
	
	}

		
	/**
	 * 修改 积分管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntegralIgnoreNull(Integral integral){
		Integral tmp = findIntegral(integral.getId());
		int flag =0;
		
		
		if(integral.getAgenttype()>0){
			tmp.setAgenttype(integral.getAgenttype());
			
			flag++;
		}
		
		if(integral.getAircoeft()!=null){
			tmp.setAircoeft(integral.getAircoeft());
			
			flag++;
		}
		
		if(integral.getHotelcoeft()!=null){
			tmp.setHotelcoeft(integral.getHotelcoeft());
			
			flag++;
		}
		
		if(integral.getTravelcoeft()!=null){
			tmp.setTravelcoeft(integral.getTravelcoeft());
			
			flag++;
		}
		
		if(integral.getCarrentalcoeft()!=null){
			tmp.setCarrentalcoeft(integral.getCarrentalcoeft());
			
			flag++;
		}
		
		if(integral.getRechargecoeft()!=null){
			tmp.setRechargecoeft(integral.getRechargecoeft());
			
			flag++;
		}
		
		if(integral.getRegisterscore()!=null){
			tmp.setRegisterscore(integral.getRegisterscore());
			
			flag++;
		}
		
		if(integral.getPunishscore()!=null){
			tmp.setPunishscore(integral.getPunishscore());
			
			flag++;
		}
		
		if(integral.getBackorderscore()!=null){
			tmp.setBackorderscore(integral.getBackorderscore());
			
			flag++;
		}
		
		if(integral.getWeborderscore()!=null){
			tmp.setWeborderscore(integral.getWeborderscore());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateIntegral",tmp);
		}
	}
	
	/**
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegral(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllIntegral",map, offset, limit);
	}
		
	
	/**
	 * 查找 积分管理
	 * @param id
	 * @return
	 */
	public Integral findIntegral(long id){
		return (Integral)(getSqlMapClientTemplate().queryForObject("findIntegral",id));
	}
	
	/** 
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntegral(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countIntegralBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllIntegral",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找积分管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegral(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllIntegralBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 积分管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntegralBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteIntegralBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntegralBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countIntegralBySql",map).toString()));
	}
}

