/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.perworkload;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PerworkloadManager extends  SqlMapClientDaoSupport  implements IPerworkloadManager{ 
	
  
 	/**
	 * 创建 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public Perworkload createPerworkload(Perworkload perworkload) throws SQLException{
	
		if(perworkload.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		perworkload.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PERWORKLOAD"));
		getSqlMapClientTemplate().insert("createPerworkload",perworkload);
		return perworkload;
	}
	/**
	 * 删除 人均工作量统计
	 * @param id
	 * @return deleted count 
	 */
	public int deletePerworkload(long id){
	
		return getSqlMapClientTemplate().delete("deletePerworkload", id);
	}
	
	
	/**
	 * 修改 人均工作量统计
	 * @param id
	 * @return updated count 
	 */
	public int updatePerworkload(Perworkload perworkload){
		return getSqlMapClientTemplate().update("updatePerworkload",perworkload);
	
	}

		
	/**
	 * 修改 人均工作量统计但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePerworkloadIgnoreNull(Perworkload perworkload){
		Perworkload tmp = findPerworkload(perworkload.getId());
		int flag =0;
		
		
		if(perworkload.getUsernumber()!=null){
			tmp.setUsernumber(perworkload.getUsernumber());
			
			flag++;
		}
		
		if(perworkload.getName()!=null){
			tmp.setName(perworkload.getName());
			
			flag++;
		}
		
		if(perworkload.getTicketnumber()!=null){
			tmp.setTicketnumber(perworkload.getTicketnumber());
			
			flag++;
		}
		
		if(perworkload.getTicketmoney()!=null){
			tmp.setTicketmoney(perworkload.getTicketmoney());
			
			flag++;
		}
		
		if(perworkload.getTuinumber()!=null){
			tmp.setTuinumber(perworkload.getTuinumber());
			
			flag++;
		}
		
		if(perworkload.getTuimoney()!=null){
			tmp.setTuimoney(perworkload.getTuimoney());
			
			flag++;
		}
		
		if(perworkload.getDepartment()!=null){
			tmp.setDepartment(perworkload.getDepartment());
			
			flag++;
		}
		
		if(perworkload.getDatetime()!=null){
			tmp.setDatetime(perworkload.getDatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePerworkload",tmp);
		}
	}
	
	/**
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkload(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPerworkload",map, offset, limit);
	}
		
	
	/**
	 * 查找 人均工作量统计
	 * @param id
	 * @return
	 */
	public Perworkload findPerworkload(long id){
		return (Perworkload)(getSqlMapClientTemplate().queryForObject("findPerworkload",id));
	}
	
	/** 
	 * 查找 人均工作量统计
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPerworkload(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPerworkloadBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPerworkload",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找人均工作量统计
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPerworkload(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPerworkloadBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 人均工作量统计
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePerworkloadBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePerworkloadBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPerworkloadBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPerworkloadBySql",map).toString()));
	}
}

