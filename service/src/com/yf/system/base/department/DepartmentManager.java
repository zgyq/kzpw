/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.department;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class DepartmentManager extends  SqlMapClientDaoSupport  implements IDepartmentManager{ 
	
  
 	/**
	 * 创建 部门
	 * @param id
	 * @return deleted count 
	 */
	public Department createDepartment(Department department) throws SQLException{
	
		if(department.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		department.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_DEPARTMENT"));
		getSqlMapClientTemplate().insert("createDept",department);
		return department;
	}
	/**
	 * 删除 部门
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDepartment(long id){
	
		return getSqlMapClientTemplate().delete("deleteDept", id);
	}
	
	
	/**
	 * 修改 部门
	 * @param id
	 * @return updated count 
	 */
	public int updateDepartment(Department department){
		return getSqlMapClientTemplate().update("updateDept",department);
	
	}

		
	/**
	 * 修改 部门但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDepartmentIgnoreNull(Department department){
		Department tmp = findDepartment(department.getId());
		int flag =0;
		
		
		if(department.getName()!=null){
			tmp.setName(department.getName());
			
			flag++;
		}
		
		if(department.getParentid()!=null){
			tmp.setParentid(department.getParentid());
			
			flag++;
		}
		if(department.getType()!=null){
			tmp.setType(department.getType());
			
			flag++;
		}
		if(department.getDeptmemo()!=null){
			tmp.setDeptmemo(department.getDeptmemo());
			
			flag++;
		}
	
		
		if(department.getAgentid()!=null){
			tmp.setAgentid(department.getAgentid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateDept",tmp);
		}
	}
	
	/**
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllDept",map, offset, limit);
	}
		
	
	/**
	 * 查找 部门
	 * @param id
	 * @return
	 */
	public Department findDepartment(long id){
		return (Department)(getSqlMapClientTemplate().queryForObject("findDept",id));
	}
	
	/** 
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDeptBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllDept",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找部门
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllDeptBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 部门
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDepartmentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteDeptBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDepartmentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDeptBySql",map).toString()));
	}
}

