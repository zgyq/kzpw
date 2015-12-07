/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymsend;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class YmsendManager extends  SqlMapClientDaoSupport  implements IYmsendManager{ 
	
  
 	/**
	 * 创建 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public Ymsend createYmsend(Ymsend ymsend) throws SQLException{
	
		if(ymsend.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ymsend.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_YMSEND"));
		getSqlMapClientTemplate().insert("createYmsend",ymsend);
		return ymsend;
	}
	/**
	 * 删除 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmsend(long id){
	
		return getSqlMapClientTemplate().delete("deleteYmsend", id);
	}
	
	
	/**
	 * 修改 短信发送表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmsend(Ymsend ymsend){
		return getSqlMapClientTemplate().update("updateYmsend",ymsend);
	
	}

		
	/**
	 * 修改 短信发送表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmsendIgnoreNull(Ymsend ymsend){
		Ymsend tmp = findYmsend(ymsend.getId());
		int flag =0;
		
		
		if(ymsend.getPhone()!=null){
			tmp.setPhone(ymsend.getPhone());
			
			flag++;
		}
		
		if(ymsend.getContent()!=null){
			tmp.setContent(ymsend.getContent());
			
			flag++;
		}
		
		if(ymsend.getType()!=null){
			tmp.setType(ymsend.getType());
			flag++;
		}
		
		if(ymsend.getState()!=null){
			tmp.setState(ymsend.getState());
			
			flag++;
		}
		
		if(ymsend.getCreatetime()!=null){
			tmp.setCreatetime(ymsend.getCreatetime());
			
			flag++;
		}
		
		if(ymsend.getDescription()!=null){
			tmp.setDescription(ymsend.getDescription());
			
			flag++;
		}
		
		if(ymsend.getOrdercode()!=null){
			tmp.setOrdercode(ymsend.getOrdercode());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateYmsend",tmp);
		}
	}
	
	/**
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllYmsend",map, offset, limit);
	}
		
	
	/**
	 * 查找 短信发送表
	 * @param id
	 * @return
	 */
	public Ymsend findYmsend(long id){
		return (Ymsend)(getSqlMapClientTemplate().queryForObject("findYmsend",id));
	}
	
	/** 
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmsendBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllYmsend",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找短信发送表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllYmsendBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 短信发送表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmsendBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteYmsendBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmsendBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmsendBySql",map).toString()));
	}
}

