/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rgroupcustomers;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RgroupcustomersManager extends  SqlMapClientDaoSupport  implements IRgroupcustomersManager{ 
	
  
 	/**
	 * 创建 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public Rgroupcustomers createRgroupcustomers(Rgroupcustomers rgroupcustomers) throws SQLException{
	
		if(rgroupcustomers.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rgroupcustomers.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RGROUPCUSTOMERS"));
		getSqlMapClientTemplate().insert("createRgroupcustomers",rgroupcustomers);
		return rgroupcustomers;
	}
	/**
	 * 删除 集团客户环比统计表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRgroupcustomers(long id){
	
		return getSqlMapClientTemplate().delete("deleteRgroupcustomers", id);
	}
	
	
	/**
	 * 修改 集团客户环比统计表
	 * @param id
	 * @return updated count 
	 */
	public int updateRgroupcustomers(Rgroupcustomers rgroupcustomers){
		return getSqlMapClientTemplate().update("updateRgroupcustomers",rgroupcustomers);
	
	}

		
	/**
	 * 修改 集团客户环比统计表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRgroupcustomersIgnoreNull(Rgroupcustomers rgroupcustomers){
		Rgroupcustomers tmp = findRgroupcustomers(rgroupcustomers.getId());
		int flag =0;
		
		
		if(rgroupcustomers.getGroupcusid()!=null){
			tmp.setGroupcusid(rgroupcustomers.getGroupcusid());
			
			flag++;
		}
		
		if(rgroupcustomers.getGroupname()!=null){
			tmp.setGroupname(rgroupcustomers.getGroupname());
			
			flag++;
		}
		
		if(rgroupcustomers.getMoney()!=null){
			tmp.setMoney(rgroupcustomers.getMoney());
			
			flag++;
		}
		
		if(rgroupcustomers.getDatetime()!=null){
			tmp.setDatetime(rgroupcustomers.getDatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRgroupcustomers",tmp);
		}
	}
	
	/**
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomers(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRgroupcustomers",map, offset, limit);
	}
		
	
	/**
	 * 查找 集团客户环比统计表
	 * @param id
	 * @return
	 */
	public Rgroupcustomers findRgroupcustomers(long id){
		return (Rgroupcustomers)(getSqlMapClientTemplate().queryForObject("findRgroupcustomers",id));
	}
	
	/** 
	 * 查找 集团客户环比统计表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRgroupcustomers(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRgroupcustomersBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRgroupcustomers",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找集团客户环比统计表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRgroupcustomers(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRgroupcustomersBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 集团客户环比统计表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRgroupcustomersBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRgroupcustomersBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRgroupcustomersBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRgroupcustomersBySql",map).toString()));
	}
}

