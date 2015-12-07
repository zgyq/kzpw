/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfonew;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QqinfonewManager extends  SqlMapClientDaoSupport  implements IQqinfonewManager{ 
	
  
 	/**
	 * 创建 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfonew createQqinfonew(Qqinfonew qqinfonew) throws SQLException{
	
		if(qqinfonew.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qqinfonew.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QQINFONEW"));
		getSqlMapClientTemplate().insert("createQqinfonew",qqinfonew);
		return qqinfonew;
	}
	/**
	 * 删除 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfonew(long id){
	
		return getSqlMapClientTemplate().delete("deleteQqinfonew", id);
	}
	
	
	/**
	 * 修改 QQ号码
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfonew(Qqinfonew qqinfonew){
		return getSqlMapClientTemplate().update("updateQqinfonew",qqinfonew);
	
	}

		
	/**
	 * 修改 QQ号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfonewIgnoreNull(Qqinfonew qqinfonew){
		Qqinfonew tmp = findQqinfonew(qqinfonew.getId());
		int flag =0;
		
		
		if(qqinfonew.getQqno()!=null){
			tmp.setQqno(qqinfonew.getQqno());
			
			flag++;
		}
		
		if(qqinfonew.getTypeid()!=null){
			tmp.setTypeid(qqinfonew.getTypeid());
			
			flag++;
		}
		
		if(qqinfonew.getUserid()!=null){
			tmp.setUserid(qqinfonew.getUserid());
			
			flag++;
		}
		
		if(qqinfonew.getParam1()!=null){
			tmp.setParam1(qqinfonew.getParam1());
			
			flag++;
		}
		
		if(qqinfonew.getParam2()!=null){
			tmp.setParam2(qqinfonew.getParam2());
			
			flag++;
		}
		
		if(qqinfonew.getParam3()!=null){
			tmp.setParam3(qqinfonew.getParam3());
			
			flag++;
		}
		
		if(qqinfonew.getCreatetime()!=null){
			tmp.setCreatetime(qqinfonew.getCreatetime());
			
			flag++;
		}
		
		if(qqinfonew.getState()!=null){
			tmp.setState(qqinfonew.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQqinfonew",tmp);
		}
	}
	
	/**
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQqinfonew",map, offset, limit);
	}
		
	
	/**
	 * 查找 QQ号码
	 * @param id
	 * @return
	 */
	public Qqinfonew findQqinfonew(long id){
		return (Qqinfonew)(getSqlMapClientTemplate().queryForObject("findQqinfonew",id));
	}
	
	/** 
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqinfonewBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQqinfonew",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找QQ号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQqinfonewBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql QQ号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfonewBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQqinfonewBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfonewBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqinfonewBySql",map).toString()));
	}
}

