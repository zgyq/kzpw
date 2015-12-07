/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqtype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QqtypeManager extends  SqlMapClientDaoSupport  implements IQqtypeManager{ 
	
  
 	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtype createQqtype(Qqtype qqtype) throws SQLException{
	
		if(qqtype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qqtype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QQTYPE"));
		getSqlMapClientTemplate().insert("createQqtype",qqtype);
		return qqtype;
	}
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtype(long id){
	
		return getSqlMapClientTemplate().delete("deleteQqtype", id);
	}
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtype(Qqtype qqtype){
		return getSqlMapClientTemplate().update("updateQqtype",qqtype);
	
	}

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypeIgnoreNull(Qqtype qqtype){
		Qqtype tmp = findQqtype(qqtype.getId());
		int flag =0;
		
		
		if(qqtype.getTypename()!=null){
			tmp.setTypename(qqtype.getTypename());
			
			flag++;
		}
		
		if(qqtype.getIndex()!=null){
			tmp.setIndex(qqtype.getIndex());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQqtype",tmp);
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
	public List findAllQqtype(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQqtype",map, offset, limit);
	}
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtype findQqtype(long id){
		return (Qqtype)(getSqlMapClientTemplate().queryForObject("findQqtype",id));
	}
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtype(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqtypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQqtype",map, offset, limit);
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
	public List findAllQqtype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQqtypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQqtypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqtypeBySql",map).toString()));
	}
}

