/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.templet;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TempletManager extends  SqlMapClientDaoSupport  implements ITempletManager{ 
	
  
 	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Templet createTemplet(Templet templet) throws SQLException{
	
		if(templet.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		templet.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TEMPLET"));
		getSqlMapClientTemplate().insert("createTemplet",templet);
		return templet;
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplet(long id){
	
		return getSqlMapClientTemplate().delete("deleteTemplet", id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplet(Templet templet){
		return getSqlMapClientTemplate().update("updateTemplet",templet);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTempletIgnoreNull(Templet templet){
		Templet tmp = findTemplet(templet.getId());
		int flag =0;
		
		
		if(templet.getTempletname()!=null){
			tmp.setTempletname(templet.getTempletname());
			
			flag++;
		}
		
		if(templet.getTempletmess()!=null){
			tmp.setTempletmess(templet.getTempletmess());
			
			flag++;
		}
		
		if(templet.getTemplettype()!=null){
			tmp.setTemplettype(templet.getTemplettype());
			
			flag++;
		}
		
		if(templet.getTempletyewu()!=null){
			tmp.setTempletyewu(templet.getTempletyewu());
			
			flag++;
		}
		
		if(templet.getCreatetime()!=null){
			tmp.setCreatetime(templet.getCreatetime());
			
			flag++;
		}
		
		if(templet.getCreateuserid()!=null){
			tmp.setCreateuserid(templet.getCreateuserid());
			
			flag++;
		}
		
		if(templet.getParam1()!=null){
			tmp.setParam1(templet.getParam1());
			
			flag++;
		}
		
		if(templet.getParam2()!=null){
			tmp.setParam2(templet.getParam2());
			
			flag++;
		}
		
		if(templet.getParam3()!=null){
			tmp.setParam3(templet.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTemplet",tmp);
		}
	}
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplet(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTemplet",map, offset, limit);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Templet findTemplet(long id){
		return (Templet)(getSqlMapClientTemplate().queryForObject("findTemplet",id));
	}
	
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTemplet(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTempletBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTemplet",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplet(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTempletBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTempletBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTempletBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTempletBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTempletBySql",map).toString()));
	}
}

