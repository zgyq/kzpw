/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rdepartment;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RdepartmentManager extends  SqlMapClientDaoSupport  implements IRdepartmentManager{ 
	
  
 	/**
	 * 创建 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rdepartment createRdepartment(Rdepartment rdepartment) throws SQLException{
	
		if(rdepartment.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rdepartment.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_RDEPARTMENT"));
		getSqlMapClientTemplate().insert("createRdepartment",rdepartment);
		return rdepartment;
	}
	/**
	 * 删除 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRdepartment(long id){
	
		return getSqlMapClientTemplate().delete("deleteRdepartment", id);
	}
	
	
	/**
	 * 修改 部门销售汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRdepartment(Rdepartment rdepartment){
		return getSqlMapClientTemplate().update("updateRdepartment",rdepartment);
	
	}

		
	/**
	 * 修改 部门销售汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRdepartmentIgnoreNull(Rdepartment rdepartment){
		Rdepartment tmp = findRdepartment(rdepartment.getId());
		int flag =0;
		
		
		if(rdepartment.getTicketnumber()!=null){
			tmp.setTicketnumber(rdepartment.getTicketnumber());
			
			flag++;
		}
		
		if(rdepartment.getTicketmoney()!=null){
			tmp.setTicketmoney(rdepartment.getTicketmoney());
			
			flag++;
		}
		
		if(rdepartment.getProfitmoney()!=null){
			tmp.setProfitmoney(rdepartment.getProfitmoney());
			
			flag++;
		}
		
		if(rdepartment.getPurchase()!=null){
			tmp.setPurchase(rdepartment.getPurchase());
			
			flag++;
		}
		
		if(rdepartment.getSupply()!=null){
			tmp.setSupply(rdepartment.getSupply());
			
			flag++;
		}
		
		if(rdepartment.getDepartment()!=null){
			tmp.setDepartment(rdepartment.getDepartment());
			
			flag++;
		}
		
		if(rdepartment.getDatetime()!=null){
			tmp.setDatetime(rdepartment.getDatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRdepartment",tmp);
		}
	}
	
	/**
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRdepartment",map, offset, limit);
	}
		
	
	/**
	 * 查找 部门销售汇总表
	 * @param id
	 * @return
	 */
	public Rdepartment findRdepartment(long id){
		return (Rdepartment)(getSqlMapClientTemplate().queryForObject("findRdepartment",id));
	}
	
	/** 
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRdepartmentBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRdepartment",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找部门销售汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRdepartmentBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 部门销售汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRdepartmentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRdepartmentBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRdepartmentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRdepartmentBySql",map).toString()));
	}
}

