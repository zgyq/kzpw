/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.userintegral;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class UserintegralManager extends  SqlMapClientDaoSupport  implements IUserintegralManager{ 
	
  
 	/**
	 * 创建 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public Userintegral createUserintegral(Userintegral userintegral) throws SQLException{
	
		if(userintegral.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		userintegral.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_USERINTEGRAL"));
		getSqlMapClientTemplate().insert("createUserintegral",userintegral);
		return userintegral;
	}
	/**
	 * 删除 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUserintegral(long id){
	
		return getSqlMapClientTemplate().delete("deleteUserintegral", id);
	}
	
	
	/**
	 * 修改 会员积分记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateUserintegral(Userintegral userintegral){
		return getSqlMapClientTemplate().update("updateUserintegral",userintegral);
	
	}

		
	/**
	 * 修改 会员积分记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUserintegralIgnoreNull(Userintegral userintegral){
		Userintegral tmp = findUserintegral(userintegral.getId());
		int flag =0;
		
		
		if(userintegral.getUserid()!=null){
			tmp.setUserid(userintegral.getUserid());
			
			flag++;
		}
		
		if(userintegral.getRelatedid()!=null){
			tmp.setRelatedid(userintegral.getRelatedid());
			
			flag++;
		}
		
		if(userintegral.getCreatetime()!=null){
			tmp.setCreatetime(userintegral.getCreatetime());
			
			flag++;
		}
		
		if(userintegral.getBehavior()!=null){
			tmp.setBehavior(userintegral.getBehavior());
			
			flag++;
		}
		
		if(userintegral.getSval()!=null){
			tmp.setSval(userintegral.getSval());
			
			flag++;
		}
		
		if(userintegral.getEval()!=null){
			tmp.setEval(userintegral.getEval());
			
			flag++;
		}
		
		if(userintegral.getVal()!=null){
			tmp.setVal(userintegral.getVal());
			
			flag++;
		}
		
		if(userintegral.getCreateuserid()!=null){
			tmp.setCreateuserid(userintegral.getCreateuserid());
			
			flag++;
		}
		
		if(userintegral.getType()!=null){
			tmp.setType(userintegral.getType());
			
			flag++;
		}
		
		if(userintegral.getComment()!=null){
			tmp.setComment(userintegral.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateUserintegral",tmp);
		}
	}
	
	/**
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegral(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllUserintegral",map, offset, limit);
	}
		
	
	/**
	 * 查找 会员积分记录表
	 * @param id
	 * @return
	 */
	public Userintegral findUserintegral(long id){
		return (Userintegral)(getSqlMapClientTemplate().queryForObject("findUserintegral",id));
	}
	
	/** 
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUserintegral(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countUserintegralBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllUserintegral",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会员积分记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegral(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllUserintegralBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会员积分记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUserintegralBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteUserintegralBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUserintegralBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countUserintegralBySql",map).toString()));
	}
}

