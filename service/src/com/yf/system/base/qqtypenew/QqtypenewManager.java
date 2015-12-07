/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqtypenew;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QqtypenewManager extends  SqlMapClientDaoSupport  implements IQqtypenewManager{ 
	
  
 	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtypenew createQqtypenew(Qqtypenew qqtypenew) throws SQLException{
	
		if(qqtypenew.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qqtypenew.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QQTYPENEW"));
		getSqlMapClientTemplate().insert("createQqtypenew",qqtypenew);
		return qqtypenew;
	}
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtypenew(long id){
	
		return getSqlMapClientTemplate().delete("deleteQqtypenew", id);
	}
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtypenew(Qqtypenew qqtypenew){
		return getSqlMapClientTemplate().update("updateQqtypenew",qqtypenew);
	
	}

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypenewIgnoreNull(Qqtypenew qqtypenew){
		Qqtypenew tmp = findQqtypenew(qqtypenew.getId());
		int flag =0;
		
		
		if(qqtypenew.getName()!=null){
			tmp.setName(qqtypenew.getName());
			
			flag++;
		}
		
		if(qqtypenew.getAgentid()!=null){
			tmp.setAgentid(qqtypenew.getAgentid());
			
			flag++;
		}
		
		if(qqtypenew.getUserid()!=null){
			tmp.setUserid(qqtypenew.getUserid());
			
			flag++;
		}
		
		if(qqtypenew.getParam1()!=null){
			tmp.setParam1(qqtypenew.getParam1());
			
			flag++;
		}
		
		if(qqtypenew.getParam2()!=null){
			tmp.setParam2(qqtypenew.getParam2());
			
			flag++;
		}
		
		if(qqtypenew.getParam3()!=null){
			tmp.setParam3(qqtypenew.getParam3());
			
			flag++;
		}
		
		if(qqtypenew.getCreatetime()!=null){
			tmp.setCreatetime(qqtypenew.getCreatetime());
			
			flag++;
		}
		
		if(qqtypenew.getState()!=null){
			tmp.setState(qqtypenew.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQqtypenew",tmp);
		}
	}
	
	/**
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenew(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQqtypenew",map, offset, limit);
	}
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtypenew findQqtypenew(long id){
		return (Qqtypenew)(getSqlMapClientTemplate().queryForObject("findQqtypenew",id));
	}
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtypenew(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqtypenewBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQqtypenew",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找QQ类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenew(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQqtypenewBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypenewBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQqtypenewBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypenewBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqtypenewBySql",map).toString()));
	}
}

