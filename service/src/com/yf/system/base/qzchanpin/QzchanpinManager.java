/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzchanpin;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QzchanpinManager extends  SqlMapClientDaoSupport  implements IQzchanpinManager{ 
	
  
 	/**
	 * 创建 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpin createQzchanpin(Qzchanpin qzchanpin) throws SQLException{
	
		if(qzchanpin.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qzchanpin.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QZCHANPIN"));
		getSqlMapClientTemplate().insert("createQzchanpin",qzchanpin);
		return qzchanpin;
	}
	/**
	 * 删除 签证产品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpin(long id){
	
		return getSqlMapClientTemplate().delete("deleteQzchanpin", id);
	}
	
	
	/**
	 * 修改 签证产品
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpin(Qzchanpin qzchanpin){
		return getSqlMapClientTemplate().update("updateQzchanpin",qzchanpin);
	
	}

		
	/**
	 * 修改 签证产品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpinIgnoreNull(Qzchanpin qzchanpin){
		Qzchanpin tmp = findQzchanpin(qzchanpin.getId());
		int flag =0;
		
		
		if(qzchanpin.getOutid()!=null){
			tmp.setOutid(qzchanpin.getOutid());
			
			flag++;
		}
		
		if(qzchanpin.getTitle()!=null){
			tmp.setTitle(qzchanpin.getTitle());
			
			flag++;
		}
		
		if(qzchanpin.getTitleurl()!=null){
			tmp.setTitleurl(qzchanpin.getTitleurl());
			
			flag++;
		}
		
		if(qzchanpin.getCategory()!=null){
			tmp.setCategory(qzchanpin.getCategory());
			
			flag++;
		}
		
		if(qzchanpin.getPrice()!=null){
			tmp.setPrice(qzchanpin.getPrice());
			
			flag++;
		}
		
		if(qzchanpin.getSprice()!=null){
			tmp.setSprice(qzchanpin.getSprice());
			
			flag++;
		}
		
		if(qzchanpin.getQprice()!=null){
			tmp.setQprice(qzchanpin.getQprice());
			
			flag++;
		}
		
		if(qzchanpin.getDealcity()!=null){
			tmp.setDealcity(qzchanpin.getDealcity());
			
			flag++;
		}
		
		if(qzchanpin.getArea()!=null){
			tmp.setArea(qzchanpin.getArea());
			
			flag++;
		}
		
		if(qzchanpin.getConfine()!=null){
			tmp.setConfine(qzchanpin.getConfine());
			
			flag++;
		}
		
		if(qzchanpin.getFeeinfo()!=null){
			tmp.setFeeinfo(qzchanpin.getFeeinfo());
			
			flag++;
		}
		
		if(qzchanpin.getParam1()!=null){
			tmp.setParam1(qzchanpin.getParam1());
			
			flag++;
		}
		
		if(qzchanpin.getParam2()!=null){
			tmp.setParam2(qzchanpin.getParam2());
			
			flag++;
		}
		
		if(qzchanpin.getParam3()!=null){
			tmp.setParam3(qzchanpin.getParam3());
			
			flag++;
		}
		
		if(qzchanpin.getCreatetime()!=null){
			tmp.setCreatetime(qzchanpin.getCreatetime());
			
			flag++;
		}
		
		if(qzchanpin.getState()!=null){
			tmp.setState(qzchanpin.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQzchanpin",tmp);
		}
	}
	
	/**
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpin(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQzchanpin",map, offset, limit);
	}
		
	
	/**
	 * 查找 签证产品
	 * @param id
	 * @return
	 */
	public Qzchanpin findQzchanpin(long id){
		return (Qzchanpin)(getSqlMapClientTemplate().queryForObject("findQzchanpin",id));
	}
	
	/** 
	 * 查找 签证产品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpin(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzchanpinBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQzchanpin",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找签证产品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpin(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQzchanpinBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 签证产品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQzchanpinBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzchanpinBySql",map).toString()));
	}
}

