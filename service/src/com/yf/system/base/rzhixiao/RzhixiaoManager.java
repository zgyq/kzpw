/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rzhixiao;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RzhixiaoManager extends  SqlMapClientDaoSupport  implements IRzhixiaoManager{ 
	
  
 	/**
	 * 创建 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rzhixiao createRzhixiao(Rzhixiao rzhixiao) throws SQLException{
	
		if(rzhixiao.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rzhixiao.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RZHIXIAO"));
		getSqlMapClientTemplate().insert("createRzhixiao",rzhixiao);
		return rzhixiao;
	}
	/**
	 * 删除 直销汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRzhixiao(long id){
	
		return getSqlMapClientTemplate().delete("deleteRzhixiao", id);
	}
	
	
	/**
	 * 修改 直销汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRzhixiao(Rzhixiao rzhixiao){
		return getSqlMapClientTemplate().update("updateRzhixiao",rzhixiao);
	
	}

		
	/**
	 * 修改 直销汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRzhixiaoIgnoreNull(Rzhixiao rzhixiao){
		Rzhixiao tmp = findRzhixiao(rzhixiao.getId());
		int flag =0;
		
		
		if(rzhixiao.getNumber()!=null){
			tmp.setNumber(rzhixiao.getNumber());
			
			flag++;
		}
		
		if(rzhixiao.getPrice()!=null){
			tmp.setPrice(rzhixiao.getPrice());
			
			flag++;
		}
		
		if(rzhixiao.getMaoriprice()!=null){
			tmp.setMaoriprice(rzhixiao.getMaoriprice());
			
			flag++;
		}
		
		if(rzhixiao.getType()!=null){
			tmp.setType(rzhixiao.getType());
			
			flag++;
		}
		
		if(rzhixiao.getDepartment()!=null){
			tmp.setDepartment(rzhixiao.getDepartment());
			
			flag++;
		}
		
		if(rzhixiao.getDatetime()!=null){
			tmp.setDatetime(rzhixiao.getDatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRzhixiao",tmp);
		}
	}
	
	/**
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRzhixiao",map, offset, limit);
	}
		
	
	/**
	 * 查找 直销汇总表
	 * @param id
	 * @return
	 */
	public Rzhixiao findRzhixiao(long id){
		return (Rzhixiao)(getSqlMapClientTemplate().queryForObject("findRzhixiao",id));
	}
	
	/** 
	 * 查找 直销汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRzhixiao(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRzhixiaoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRzhixiao",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找直销汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRzhixiao(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRzhixiaoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 直销汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRzhixiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRzhixiaoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRzhixiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRzhixiaoBySql",map).toString()));
	}
}

