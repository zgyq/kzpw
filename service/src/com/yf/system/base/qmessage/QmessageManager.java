/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qmessage;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QmessageManager extends  SqlMapClientDaoSupport  implements IQmessageManager{ 
	
  
 	/**
	 * 创建 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public Qmessage createQmessage(Qmessage qmessage) throws SQLException{
	
		if(qmessage.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qmessage.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QMESSAGE"));
		getSqlMapClientTemplate().insert("createQmessage",qmessage);
		return qmessage;
	}
	/**
	 * 删除 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmessage(long id){
	
		return getSqlMapClientTemplate().delete("deleteQmessage", id);
	}
	
	
	/**
	 * 修改 Q信箱
	 * @param id
	 * @return updated count 
	 */
	public int updateQmessage(Qmessage qmessage){
		return getSqlMapClientTemplate().update("updateQmessage",qmessage);
	
	}

		
	/**
	 * 修改 Q信箱但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmessageIgnoreNull(Qmessage qmessage){
		Qmessage tmp = findQmessage(qmessage.getId());
		int flag =0;
		
		
		if(qmessage.getId()!=0){
			tmp.setId(qmessage.getId());
			
			flag++;
		}
		
		if(qmessage.getMessage()!=null){
			tmp.setMessage(qmessage.getMessage());
			
			flag++;
		}
		
		if(qmessage.getCreatetime()!=null){
			tmp.setCreatetime(qmessage.getCreatetime());
			
			flag++;
		}
		
		if(qmessage.getStatus()!=null){
			tmp.setStatus(qmessage.getStatus());
			
			flag++;
		}
		
		if(qmessage.getCreateuser()!=null){
			tmp.setCreateuser(qmessage.getCreateuser());
			
			flag++;
		}
		
		if(qmessage.getDealtime()!=null){
			tmp.setDealtime(qmessage.getDealtime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQmessage",tmp);
		}
	}
	
	/**
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessage(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQmessage",map, offset, limit);
	}
		
	
	/**
	 * 查找 Q信箱
	 * @param id
	 * @return
	 */
	public Qmessage findQmessage(long id){
		return (Qmessage)(getSqlMapClientTemplate().queryForObject("findQmessage",id));
	}
	
	/** 
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmessage(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQmessageBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQmessage",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找Q信箱
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessage(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQmessageBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql Q信箱
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmessageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQmessageBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmessageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQmessageBySql",map).toString()));
	}
}

