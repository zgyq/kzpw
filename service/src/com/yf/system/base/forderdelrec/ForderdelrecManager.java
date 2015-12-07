/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.forderdelrec;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ForderdelrecManager extends  SqlMapClientDaoSupport  implements IForderdelrecManager{ 
	
  
 	/**
	 * 创建 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public Forderdelrec createForderdelrec(Forderdelrec forderdelrec) throws SQLException{
	
		if(forderdelrec.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		forderdelrec.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FORDERDELREC"));
		getSqlMapClientTemplate().insert("createForderdelrec",forderdelrec);
		return forderdelrec;
	}
	/**
	 * 删除 国际机票订单操作记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderdelrec(long id){
	
		return getSqlMapClientTemplate().delete("deleteForderdelrec", id);
	}
	
	
	/**
	 * 修改 国际机票订单操作记录
	 * @param id
	 * @return updated count 
	 */
	public int updateForderdelrec(Forderdelrec forderdelrec){
		return getSqlMapClientTemplate().update("updateForderdelrec",forderdelrec);
	
	}

		
	/**
	 * 修改 国际机票订单操作记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateForderdelrecIgnoreNull(Forderdelrec forderdelrec){
		Forderdelrec tmp = findForderdelrec(forderdelrec.getId());
		int flag =0;
		
		
		if(forderdelrec.getOrderid()!=null){
			tmp.setOrderid(forderdelrec.getOrderid());
			
			flag++;
		}
		
		if(forderdelrec.getOperateperson()!=null){
			tmp.setOperateperson(forderdelrec.getOperateperson());
			
			flag++;
		}
		
		if(forderdelrec.getOperatetime()!=null){
			tmp.setOperatetime(forderdelrec.getOperatetime());
			
			flag++;
		}
		
		if(forderdelrec.getOperatedesc()!=null){
			tmp.setOperatedesc(forderdelrec.getOperatedesc());
			
			flag++;
		}
		
		if(forderdelrec.getOperatestatus()!=null){
			tmp.setOperatestatus(forderdelrec.getOperatestatus());
			
			flag++;
		}
		
		if(forderdelrec.getNextstatus()!=null){
			tmp.setNextstatus(forderdelrec.getNextstatus());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateForderdelrec",tmp);
		}
	}
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllForderdelrec",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票订单操作记录
	 * @param id
	 * @return
	 */
	public Forderdelrec findForderdelrec(long id){
		return (Forderdelrec)(getSqlMapClientTemplate().queryForObject("findForderdelrec",id));
	}
	
	/** 
	 * 查找 国际机票订单操作记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderdelrec(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countForderdelrecBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllForderdelrec",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票订单操作记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderdelrec(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllForderdelrecBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票订单操作记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderdelrecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteForderdelrecBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderdelrecBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countForderdelrecBySql",map).toString()));
	}
}

