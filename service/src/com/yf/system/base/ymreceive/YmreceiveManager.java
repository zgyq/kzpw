/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymreceive;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class YmreceiveManager extends  SqlMapClientDaoSupport  implements IYmreceiveManager{ 
	
  
 	/**
	 * 创建 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public Ymreceive createYmreceive(Ymreceive ymreceive) throws SQLException{
	
		if(ymreceive.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ymreceive.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_YMRECEIVE"));
		getSqlMapClientTemplate().insert("createYmreceive",ymreceive);
		return ymreceive;
	}
	/**
	 * 删除 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmreceive(long id){
	
		return getSqlMapClientTemplate().delete("deleteYmreceive", id);
	}
	
	
	/**
	 * 修改 短信接收表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmreceive(Ymreceive ymreceive){
		return getSqlMapClientTemplate().update("updateYmreceive",ymreceive);
	
	}

		
	/**
	 * 修改 短信接收表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmreceiveIgnoreNull(Ymreceive ymreceive){
		Ymreceive tmp = findYmreceive(ymreceive.getId());
		int flag =0;
		
		
		if(ymreceive.getPhone()!=null){
			tmp.setPhone(ymreceive.getPhone());
			
			flag++;
		}
		
		if(ymreceive.getContent()!=null){
			tmp.setContent(ymreceive.getContent());
			
			flag++;
		}
		
		if(ymreceive.getSendtime()!=null){
			tmp.setSendtime(ymreceive.getSendtime());
			
			flag++;
		}
		
		if(ymreceive.getSystemtime()!=null){
			tmp.setSystemtime(ymreceive.getSystemtime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateYmreceive",tmp);
		}
	}
	
	/**
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllYmreceive",map, offset, limit);
	}
		
	
	/**
	 * 查找 短信接收表
	 * @param id
	 * @return
	 */
	public Ymreceive findYmreceive(long id){
		return (Ymreceive)(getSqlMapClientTemplate().queryForObject("findYmreceive",id));
	}
	
	/** 
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmreceiveBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllYmreceive",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找短信接收表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllYmreceiveBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 短信接收表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmreceiveBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteYmreceiveBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmreceiveBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmreceiveBySql",map).toString()));
	}
}

