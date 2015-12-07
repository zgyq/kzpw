/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysmessage;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SysmessageManager extends  SqlMapClientDaoSupport  implements ISysmessageManager{ 
	
  
 	/**
	 * 创建 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public Sysmessage createSysmessage(Sysmessage sysmessage) throws SQLException{
	
		if(sysmessage.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		sysmessage.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SYSMESSAGE"));
		getSqlMapClientTemplate().insert("createSysmessage",sysmessage);
		return sysmessage;
	}
	/**
	 * 删除 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysmessage(long id){
	
		return getSqlMapClientTemplate().delete("deleteSysmessage", id);
	}
	
	
	/**
	 * 修改 消息公告
	 * @param id
	 * @return updated count 
	 */
	public int updateSysmessage(Sysmessage sysmessage){
		return getSqlMapClientTemplate().update("updateSysmessage",sysmessage);
	
	}

		
	/**
	 * 修改 消息公告但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysmessageIgnoreNull(Sysmessage sysmessage){
		Sysmessage tmp = findSysmessage(sysmessage.getId());
		int flag =0;
		
		
		if(sysmessage.getCreateuser()!=null){
			tmp.setCreateuser(sysmessage.getCreateuser());
			
			flag++;
		}
		
		if(sysmessage.getCreatetime()!=null){
			tmp.setCreatetime(sysmessage.getCreatetime());
			
			flag++;
		}
		
		if(sysmessage.getModifyuser()!=null){
			tmp.setModifyuser(sysmessage.getModifyuser());
			
			flag++;
		}
		
		if(sysmessage.getModifytime()!=null){
			tmp.setModifytime(sysmessage.getModifytime());
			
			flag++;
		}
		
		if(sysmessage.getCustomeruserid()!=null){
			tmp.setCustomeruserid(sysmessage.getCustomeruserid());
			
			flag++;
		}
		
		if(sysmessage.getType()!=null){
			tmp.setType(sysmessage.getType());
			
			flag++;
		}
		
		if(sysmessage.getTitle()!=null){
			tmp.setTitle(sysmessage.getTitle());
			
			flag++;
		}
		
		if(sysmessage.getContent()!=null){
			tmp.setContent(sysmessage.getContent());
			
			flag++;
		}
		
		if(sysmessage.getUsers()!=null){
			tmp.setUsers(sysmessage.getUsers());
			
			flag++;
		}
		
		if(sysmessage.getPubtime()!=null){
			tmp.setPubtime(sysmessage.getPubtime());
			
			flag++;
		}
		
		if(sysmessage.getState()!=null){
			tmp.setState(sysmessage.getState());
			
			flag++;
		}
		
		if(sysmessage.getEndtime()!=null){
			tmp.setEndtime(sysmessage.getEndtime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSysmessage",tmp);
		}
	}
	
	/**
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSysmessage",map, offset, limit);
	}
		
	
	/**
	 * 查找 消息公告
	 * @param id
	 * @return
	 */
	public Sysmessage findSysmessage(long id){
		return (Sysmessage)(getSqlMapClientTemplate().queryForObject("findSysmessage",id));
	}
	
	/** 
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysmessageBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSysmessage",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找消息公告
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSysmessageBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 消息公告
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysmessageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSysmessageBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysmessageBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSysmessageBySql",map).toString()));
	}
}

