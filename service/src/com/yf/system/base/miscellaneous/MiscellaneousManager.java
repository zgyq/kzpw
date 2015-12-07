/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.miscellaneous;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class MiscellaneousManager extends  SqlMapClientDaoSupport  implements IMiscellaneousManager{ 
	
  
 	/**
	 * 创建 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public Miscellaneous createMiscellaneous(Miscellaneous miscellaneous) throws SQLException{
	
		if(miscellaneous.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		miscellaneous.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_MISCELLANEOUS"));
		getSqlMapClientTemplate().insert("createMiscellaneous",miscellaneous);
		return miscellaneous;
	}
	/**
	 * 删除 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMiscellaneous(long id){
	
		return getSqlMapClientTemplate().delete("deleteMiscellaneous", id);
	}
	
	
	/**
	 * 修改 客户经理杂项列表
	 * @param id
	 * @return updated count 
	 */
	public int updateMiscellaneous(Miscellaneous miscellaneous){
		return getSqlMapClientTemplate().update("updateMiscellaneous",miscellaneous);
	
	}

		
	/**
	 * 修改 客户经理杂项列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMiscellaneousIgnoreNull(Miscellaneous miscellaneous){
		Miscellaneous tmp = findMiscellaneous(miscellaneous.getId());
		int flag =0;
		
		
		if(miscellaneous.getCreatetime()!=null){
			tmp.setCreatetime(miscellaneous.getCreatetime());
			
			flag++;
		}
		
		if(miscellaneous.getCreateid()!=null){
			tmp.setCreateid(miscellaneous.getCreateid());
			
			flag++;
		}
		
		if(miscellaneous.getRepaytime()!=null){
			tmp.setRepaytime(miscellaneous.getRepaytime());
			flag++;
		}
		
		if(miscellaneous.getState()!=null){
			tmp.setState(miscellaneous.getState());
			
			flag++;
		}
		
		if(miscellaneous.getGroupuserid()!=null){
			tmp.setGroupuserid(miscellaneous.getGroupuserid());
			
			flag++;
		}
		
		if(miscellaneous.getDepartment()!=null){
			tmp.setDepartment(miscellaneous.getDepartment());
			
			flag++;
		}
		
		if(miscellaneous.getCustomerid()!=null){
			tmp.setCustomerid(miscellaneous.getCustomerid());
			flag++;
		}
		
		if(miscellaneous.getName()!=null){
			tmp.setName(miscellaneous.getName());
			
			flag++;
		}
		
		if(miscellaneous.getPrice()!=null){
			tmp.setPrice(miscellaneous.getPrice());
			
			flag++;
		}
		
		if(miscellaneous.getDescription()!=null){
			tmp.setDescription(miscellaneous.getDescription());
			
			flag++;
		}
		
		if(miscellaneous.getSpenddate()!=null){
			tmp.setSpenddate(miscellaneous.getSpenddate());
			
			flag++;
		}
		
		if(miscellaneous.getYihai()!=null){
			tmp.setYihai(miscellaneous.getYihai());
			flag++;
			
		}
		if(miscellaneous.getHaiqian()!=null){
			tmp.setHaiqian(miscellaneous.getHaiqian());
			flag++;
		}
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateMiscellaneous",tmp);
		}
	}
	
	/**
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneous(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllMiscellaneous",map, offset, limit);
	}
		
	
	/**
	 * 查找 客户经理杂项列表
	 * @param id
	 * @return
	 */
	public Miscellaneous findMiscellaneous(long id){
		return (Miscellaneous)(getSqlMapClientTemplate().queryForObject("findMiscellaneous",id));
	}
	
	/** 
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMiscellaneous(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countMiscellaneousBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllMiscellaneous",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找客户经理杂项列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneous(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllMiscellaneousBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 客户经理杂项列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMiscellaneousBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteMiscellaneousBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMiscellaneousBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countMiscellaneousBySql",map).toString()));
	}
}

