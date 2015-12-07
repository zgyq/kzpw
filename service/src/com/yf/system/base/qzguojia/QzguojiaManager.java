/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzguojia;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QzguojiaManager extends  SqlMapClientDaoSupport  implements IQzguojiaManager{ 
	
  
 	/**
	 * 创建 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public Qzguojia createQzguojia(Qzguojia qzguojia) throws SQLException{
	
		if(qzguojia.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qzguojia.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QZGUOJIA"));
		getSqlMapClientTemplate().insert("createQzguojia",qzguojia);
		return qzguojia;
	}
	/**
	 * 删除 签证国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzguojia(long id){
	
		return getSqlMapClientTemplate().delete("deleteQzguojia", id);
	}
	
	
	/**
	 * 修改 签证国家
	 * @param id
	 * @return updated count 
	 */
	public int updateQzguojia(Qzguojia qzguojia){
		return getSqlMapClientTemplate().update("updateQzguojia",qzguojia);
	
	}

		
	/**
	 * 修改 签证国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzguojiaIgnoreNull(Qzguojia qzguojia){
		Qzguojia tmp = findQzguojia(qzguojia.getId());
		int flag =0;
		
		
		if(qzguojia.getClassid()!=null){
			tmp.setClassid(qzguojia.getClassid());
			
			flag++;
		}
		
		if(qzguojia.getName()!=null){
			tmp.setName(qzguojia.getName());
			
			flag++;
		}
		
		if(qzguojia.getBclassid()!=null){
			tmp.setBclassid(qzguojia.getBclassid());
			
			flag++;
		}
		
		if(qzguojia.getBclassname()!=null){
			tmp.setBclassname(qzguojia.getBclassname());
			
			flag++;
		}
		
		if(qzguojia.getParam1()!=null){
			tmp.setParam1(qzguojia.getParam1());
			
			flag++;
		}
		
		if(qzguojia.getParam2()!=null){
			tmp.setParam2(qzguojia.getParam2());
			
			flag++;
		}
		
		if(qzguojia.getParam3()!=null){
			tmp.setParam3(qzguojia.getParam3());
			
			flag++;
		}
		
		if(qzguojia.getCreatetime()!=null){
			tmp.setCreatetime(qzguojia.getCreatetime());
			
			flag++;
		}
		
		if(qzguojia.getState()!=null){
			tmp.setState(qzguojia.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQzguojia",tmp);
		}
	}
	
	/**
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQzguojia",map, offset, limit);
	}
		
	
	/**
	 * 查找 签证国家
	 * @param id
	 * @return
	 */
	public Qzguojia findQzguojia(long id){
		return (Qzguojia)(getSqlMapClientTemplate().queryForObject("findQzguojia",id));
	}
	
	/** 
	 * 查找 签证国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzguojia(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzguojiaBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQzguojia",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找签证国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzguojia(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQzguojiaBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 签证国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzguojiaBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQzguojiaBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzguojiaBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzguojiaBySql",map).toString()));
	}
}

