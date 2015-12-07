/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.infotype;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InfotypeManager extends  SqlMapClientDaoSupport  implements IInfotypeManager{ 
	
  
 	/**
	 * 创建 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public Infotype createInfotype(Infotype infotype) throws SQLException{
	
		if(infotype.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		infotype.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INFOTYPE"));
		getSqlMapClientTemplate().insert("createInfotype",infotype);
		return infotype;
	}
	/**
	 * 删除 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfotype(long id){
	
		return getSqlMapClientTemplate().delete("deleteInfotype", id);
	}
	
	
	/**
	 * 修改 信息类型
	 * @param id
	 * @return updated count 
	 */
	public int updateInfotype(Infotype infotype){
		return getSqlMapClientTemplate().update("updateInfotype",infotype);
	
	}

		
	/**
	 * 修改 信息类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfotypeIgnoreNull(Infotype infotype){
		Infotype tmp = findInfotype(infotype.getId());
		int flag =0;
		
		
		if(infotype.getTypename()!=null){
			tmp.setTypename(infotype.getTypename());
			
			flag++;
		}
		
		if(infotype.getIndex()!=null){
			tmp.setIndex(infotype.getIndex());
			
			flag++;
		}
		
		if(infotype.getCreateuser()!=null){
			tmp.setCreateuser(infotype.getCreateuser());
			
			flag++;
		}
		
		if(infotype.getCreatetime()!=null){
			tmp.setCreatetime(infotype.getCreatetime());
			
			flag++;
		}
		
		if(infotype.getModifyuser()!=null){
			tmp.setModifyuser(infotype.getModifyuser());
			
			flag++;
		}
		
		if(infotype.getModifytime()!=null){
			tmp.setModifytime(infotype.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInfotype",tmp);
		}
	}
	
	/**
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInfotype",map, offset, limit);
	}
		
	
	/**
	 * 查找 信息类型
	 * @param id
	 * @return
	 */
	public Infotype findInfotype(long id){
		return (Infotype)(getSqlMapClientTemplate().queryForObject("findInfotype",id));
	}
	
	/** 
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInfotypeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInfotype",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找信息类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInfotypeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 信息类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfotypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInfotypeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfotypeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInfotypeBySql",map).toString()));
	}
}

