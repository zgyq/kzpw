/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelagent;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelagentManager extends  SqlMapClientDaoSupport  implements IHotelagentManager{ 
	
  
 	/**
	 * 创建 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelagent createHotelagent(Hotelagent hotelagent) throws SQLException{
	
		if(hotelagent.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelagent.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELAGENT"));
		getSqlMapClientTemplate().insert("createHotelagent",hotelagent);
		return hotelagent;
	}
	/**
	 * 删除 加盟商返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelagent(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelagent", id);
	}
	
	
	/**
	 * 修改 加盟商返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelagent(Hotelagent hotelagent){
		return getSqlMapClientTemplate().update("updateHotelagent",hotelagent);
	
	}

		
	/**
	 * 修改 加盟商返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelagentIgnoreNull(Hotelagent hotelagent){
		Hotelagent tmp = findHotelagent(hotelagent.getId());
		int flag =0;
		
		
		if(hotelagent.getCreatetime()!=null){
			tmp.setCreatetime(hotelagent.getCreatetime());
			
			flag++;
		}
		
		if(hotelagent.getStarttime()!=null){
			tmp.setStarttime(hotelagent.getStarttime());
			
			flag++;
		}
		
		if(hotelagent.getEndtime()!=null){
			tmp.setEndtime(hotelagent.getEndtime());
			
			flag++;
		}
		
		if(hotelagent.getState()!=null){
			tmp.setState(hotelagent.getState());
			
			flag++;
		}
		
		if(hotelagent.getCustomeragentid()!=null){
			tmp.setCustomeragentid(hotelagent.getCustomeragentid());
			
			flag++;
		}
		
		if(hotelagent.getMemberid()!=null){
			tmp.setMemberid(hotelagent.getMemberid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelagent",tmp);
		}
	}
	
	/**
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelagent",map, offset, limit);
	}
		
	
	/**
	 * 查找 加盟商返点表
	 * @param id
	 * @return
	 */
	public Hotelagent findHotelagent(long id){
		return (Hotelagent)(getSqlMapClientTemplate().queryForObject("findHotelagent",id));
	}
	
	/** 
	 * 查找 加盟商返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelagent(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelagentBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelagent",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找加盟商返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelagent(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelagentBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 加盟商返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelagentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelagentBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelagentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelagentBySql",map).toString()));
	}
}

