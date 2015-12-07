/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airdelayprove;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirdelayproveManager extends  SqlMapClientDaoSupport  implements IAirdelayproveManager{ 
	
  
 	/**
	 * 创建 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public Airdelayprove createAirdelayprove(Airdelayprove airdelayprove) throws SQLException{
	
		if(airdelayprove.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airdelayprove.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRDELAYPROVE"));
		getSqlMapClientTemplate().insert("createAirdelayprove",airdelayprove);
		return airdelayprove;
	}
	/**
	 * 删除 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirdelayprove(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirdelayprove", id);
	}
	
	
	/**
	 * 修改 航班延误证明
	 * @param id
	 * @return updated count 
	 */
	public int updateAirdelayprove(Airdelayprove airdelayprove){
		return getSqlMapClientTemplate().update("updateAirdelayprove",airdelayprove);
	
	}

		
	/**
	 * 修改 航班延误证明但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirdelayproveIgnoreNull(Airdelayprove airdelayprove){
		Airdelayprove tmp = findAirdelayprove(airdelayprove.getId());
		int flag =0;
		
		
		if(airdelayprove.getAirnum()!=null){
			tmp.setAirnum(airdelayprove.getAirnum());
			
			flag++;
		}
		
		if(airdelayprove.getAngentid()!=null){
			tmp.setAngentid(airdelayprove.getAngentid());
			
			flag++;
		}
		
		if(airdelayprove.getPnr()!=null){
			tmp.setPnr(airdelayprove.getPnr());
			
			flag++;
		}
		
		if(airdelayprove.getStime()!=null){
			tmp.setStime(airdelayprove.getStime());
			
			flag++;
		}
		
		if(airdelayprove.getDescinfo()!=null){
			tmp.setDescinfo(airdelayprove.getDescinfo());
			
			flag++;
		}
		
		if(airdelayprove.getRemark()!=null){
			tmp.setRemark(airdelayprove.getRemark());
			
			flag++;
		}
		
		if(airdelayprove.getCreatetime()!=null){
			tmp.setCreatetime(airdelayprove.getCreatetime());
			
			flag++;
		}
		
		if(airdelayprove.getState()!=null){
			tmp.setState(airdelayprove.getState());
			
			flag++;
		}
		
		if(airdelayprove.getMemberid()!=null){
			tmp.setMemberid(airdelayprove.getMemberid());
			
			flag++;
		}
		
		if(airdelayprove.getUrldesc()!=null){
			tmp.setUrldesc(airdelayprove.getUrldesc());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirdelayprove",tmp);
		}
	}
	
	/**
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayprove(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirdelayprove",map, offset, limit);
	}
		
	
	/**
	 * 查找 航班延误证明
	 * @param id
	 * @return
	 */
	public Airdelayprove findAirdelayprove(long id){
		return (Airdelayprove)(getSqlMapClientTemplate().queryForObject("findAirdelayprove",id));
	}
	
	/** 
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirdelayprove(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirdelayproveBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirdelayprove",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航班延误证明
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayprove(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirdelayproveBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航班延误证明
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirdelayproveBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirdelayproveBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirdelayproveBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirdelayproveBySql",map).toString()));
	}
}

