/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passengerrepayrc;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PassengerrepayrcManager extends  SqlMapClientDaoSupport  implements IPassengerrepayrcManager{ 
	
  
 	/**
	 * 创建 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public Passengerrepayrc createPassengerrepayrc(Passengerrepayrc passengerrepayrc) throws SQLException{
	
		if(passengerrepayrc.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		passengerrepayrc.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PASSENGERREPAYRC"));
		getSqlMapClientTemplate().insert("createPassengerrepayrc",passengerrepayrc);
		return passengerrepayrc;
	}
	/**
	 * 删除 机票还款记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassengerrepayrc(long id){
	
		return getSqlMapClientTemplate().delete("deletePassengerrepayrc", id);
	}
	
	
	/**
	 * 修改 机票还款记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePassengerrepayrc(Passengerrepayrc passengerrepayrc){
		return getSqlMapClientTemplate().update("updatePassengerrepayrc",passengerrepayrc);
	
	}

		
	/**
	 * 修改 机票还款记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerrepayrcIgnoreNull(Passengerrepayrc passengerrepayrc){
		Passengerrepayrc tmp = findPassengerrepayrc(passengerrepayrc.getId());
		int flag =0;
		
		
		if(passengerrepayrc.getHkuserid()!=0){
			tmp.setHkuserid(passengerrepayrc.getHkuserid());
			
			flag++;
		}
		
		if(passengerrepayrc.getHkmoney()!=null){
			tmp.setHkmoney(passengerrepayrc.getHkmoney());
			
			flag++;
		}
		
		if(passengerrepayrc.getHkdatetime()!=null){
			tmp.setHkdatetime(passengerrepayrc.getHkdatetime());
			
			flag++;
		}
		
		if(passengerrepayrc.getPassenger()!=0){
			tmp.setPassenger(passengerrepayrc.getPassenger());
			
			flag++;
		}
		if(passengerrepayrc.getBigpriceid()!=0){
			tmp.setBigpriceid(passengerrepayrc.getBigpriceid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePassengerrepayrc",tmp);
		}
	}
	
	/**
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPassengerrepayrc",map, offset, limit);
	}
		
	
	/**
	 * 查找 机票还款记录
	 * @param id
	 * @return
	 */
	public Passengerrepayrc findPassengerrepayrc(long id){
		return (Passengerrepayrc)(getSqlMapClientTemplate().queryForObject("findPassengerrepayrc",id));
	}
	
	/** 
	 * 查找 机票还款记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassengerrepayrc(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPassengerrepayrcBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPassengerrepayrc",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机票还款记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassengerrepayrc(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPassengerrepayrcBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机票还款记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerrepayrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePassengerrepayrcBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerrepayrcBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPassengerrepayrcBySql",map).toString()));
	}
}

