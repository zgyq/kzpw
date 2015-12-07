/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fdeliverassign;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FdeliverassignManager extends  SqlMapClientDaoSupport  implements IFdeliverassignManager{ 
	
  
 	/**
	 * 创建 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public Fdeliverassign createFdeliverassign(Fdeliverassign fdeliverassign) throws SQLException{
	
		if(fdeliverassign.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fdeliverassign.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FDELIVERASSIGN"));
		getSqlMapClientTemplate().insert("createFdeliverassign",fdeliverassign);
		return fdeliverassign;
	}
	/**
	 * 删除 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFdeliverassign(long id){
	
		return getSqlMapClientTemplate().delete("deleteFdeliverassign", id);
	}
	
	
	/**
	 * 修改 国际机票配送信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFdeliverassign(Fdeliverassign fdeliverassign){
		return getSqlMapClientTemplate().update("updateFdeliverassign",fdeliverassign);
	
	}

		
	/**
	 * 修改 国际机票配送信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFdeliverassignIgnoreNull(Fdeliverassign fdeliverassign){
		Fdeliverassign tmp = findFdeliverassign(fdeliverassign.getId());
		int flag =0;
		
		
		if(fdeliverassign.getOrderid()!=null){
			tmp.setOrderid(fdeliverassign.getOrderid());
			
			flag++;
		}
		
		if(fdeliverassign.getAssigntype()!=null){
			tmp.setAssigntype(fdeliverassign.getAssigntype());
			
			flag++;
		}
		
		if(fdeliverassign.getPostname()!=null){
			tmp.setPostname(fdeliverassign.getPostname());
			
			flag++;
		}
		
		if(fdeliverassign.getPostphone()!=null){
			tmp.setPostphone(fdeliverassign.getPostphone());
			
			flag++;
		}
		
		if(fdeliverassign.getPostcode()!=null){
			tmp.setPostcode(fdeliverassign.getPostcode());
			
			flag++;
		}
		
		if(fdeliverassign.getPostaddress()!=null){
			tmp.setPostaddress(fdeliverassign.getPostaddress());
			
			flag++;
		}
		
		if(fdeliverassign.getDelivercity()!=null){
			tmp.setDelivercity(fdeliverassign.getDelivercity());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFdeliverassign",tmp);
		}
	}
	
	/**
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFdeliverassign",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票配送信息
	 * @param id
	 * @return
	 */
	public Fdeliverassign findFdeliverassign(long id){
		return (Fdeliverassign)(getSqlMapClientTemplate().queryForObject("findFdeliverassign",id));
	}
	
	/** 
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFdeliverassignBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFdeliverassign",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票配送信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFdeliverassignBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票配送信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFdeliverassignBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFdeliverassignBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFdeliverassignBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFdeliverassignBySql",map).toString()));
	}
}

