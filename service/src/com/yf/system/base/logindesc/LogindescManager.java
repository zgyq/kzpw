/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.logindesc;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LogindescManager extends  SqlMapClientDaoSupport  implements ILogindescManager{ 
	
  
 	/**
	 * 创建 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public Logindesc createLogindesc(Logindesc logindesc) throws SQLException{
	
		if(logindesc.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		logindesc.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LOGINDESC"));
		getSqlMapClientTemplate().insert("createLogindesc",logindesc);
		return logindesc;
	}
	/**
	 * 删除 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLogindesc(long id){
	
		return getSqlMapClientTemplate().delete("deleteLogindesc", id);
	}
	
	
	/**
	 * 修改 登录信息
	 * @param id
	 * @return updated count 
	 */
	public int updateLogindesc(Logindesc logindesc){
		return getSqlMapClientTemplate().update("updateLogindesc",logindesc);
	
	}

		
	/**
	 * 修改 登录信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLogindescIgnoreNull(Logindesc logindesc){
		Logindesc tmp = findLogindesc(logindesc.getId());
		int flag =0;
		
		
		if(logindesc.getLoginname()!=null){
			tmp.setLoginname(logindesc.getLoginname());
			
			flag++;
		}
		
		if(logindesc.getUserid()!=null){
			tmp.setUserid(logindesc.getUserid());
			
			flag++;
		}
		
		if(logindesc.getLoginip()!=null){
			tmp.setLoginip(logindesc.getLoginip());
			
			flag++;
		}
		
		if(logindesc.getAgentid()!=null){
			tmp.setAgentid(logindesc.getAgentid());
			
			flag++;
		}
		
		if(logindesc.getDescinfo()!=null){
			tmp.setDescinfo(logindesc.getDescinfo());
			
			flag++;
		}
		
		if(logindesc.getCreateuser()!=null){
			tmp.setCreateuser(logindesc.getCreateuser());
			
			flag++;
		}
		
		if(logindesc.getCreatetime()!=null){
			tmp.setCreatetime(logindesc.getCreatetime());
			
			flag++;
		}
		
		if(logindesc.getModifyuser()!=null){
			tmp.setModifyuser(logindesc.getModifyuser());
			
			flag++;
		}
		
		if(logindesc.getModifytime()!=null){
			tmp.setModifytime(logindesc.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLogindesc",tmp);
		}
	}
	
	/**
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLogindesc",map, offset, limit);
	}
		
	
	/**
	 * 查找 登录信息
	 * @param id
	 * @return
	 */
	public Logindesc findLogindesc(long id){
		return (Logindesc)(getSqlMapClientTemplate().queryForObject("findLogindesc",id));
	}
	
	/** 
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLogindescBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLogindesc",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找登录信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLogindescBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 登录信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLogindescBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLogindescBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLogindescBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLogindescBySql",map).toString()));
	}
}

