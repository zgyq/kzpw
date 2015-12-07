/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insurcomputer;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InsurcomputerManager extends  SqlMapClientDaoSupport  implements IInsurcomputerManager{ 
	
  
 	/**
	 * 创建 保险服务公司信息
	 * @param id
	 * @return deleted count 
	 */
	public Insurcomputer createInsurcomputer(Insurcomputer insurcomputer) throws SQLException{
	
		if(insurcomputer.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		insurcomputer.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INSURCOMPUTER"));
		getSqlMapClientTemplate().insert("createInsurcomputer",insurcomputer);
		return insurcomputer;
	}
	/**
	 * 删除 保险服务公司信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsurcomputer(long id){
	
		return getSqlMapClientTemplate().delete("deleteInsurcomputer", id);
	}
	
	
	/**
	 * 修改 保险服务公司信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInsurcomputer(Insurcomputer insurcomputer){
		return getSqlMapClientTemplate().update("updateInsurcomputer",insurcomputer);
	
	}

		
	/**
	 * 修改 保险服务公司信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsurcomputerIgnoreNull(Insurcomputer insurcomputer){
		Insurcomputer tmp = findInsurcomputer(insurcomputer.getId());
		int flag =0;
		
		
		if(insurcomputer.getComputerid()!=null){
			tmp.setComputerid(insurcomputer.getComputerid());
			
			flag++;
		}
		
		if(insurcomputer.getComputername()!=null){
			tmp.setComputername(insurcomputer.getComputername());
			
			flag++;
		}
		
		if(insurcomputer.getInsuranttype()!=null){
			tmp.setInsuranttype(insurcomputer.getInsuranttype());
			
			flag++;
		}
		
		if(insurcomputer.getInsurantno()!=null){
			tmp.setInsurantno(insurcomputer.getInsurantno());
			
			flag++;
		}
		
		if(insurcomputer.getInsurantcontent()!=null){
			tmp.setInsurantcontent(insurcomputer.getInsurantcontent());
			
			flag++;
		}
		
		if(insurcomputer.getInsurtime()!=null){
			tmp.setInsurtime(insurcomputer.getInsurtime());
			
			flag++;
		}
		
		if(insurcomputer.getInsurmoney()!=null){
			tmp.setInsurmoney(insurcomputer.getInsurmoney());
			
			flag++;
		}
		
		if(insurcomputer.getScmoney()!=null){
			tmp.setScmoney(insurcomputer.getScmoney());
			
			flag++;
		}
		
		if(insurcomputer.getStatus()!=null){
			tmp.setStatus(insurcomputer.getStatus());
			
			flag++;
		}
		
		if(insurcomputer.getCreateid()!=null){
			tmp.setCreateid(insurcomputer.getCreateid());
			
			flag++;
		}
		
		if(insurcomputer.getCreatetime()!=null){
			tmp.setCreatetime(insurcomputer.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInsurcomputer",tmp);
		}
	}
	
	/**
	 * 查找 保险服务公司信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputer(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInsurcomputer",map, offset, limit);
	}
		
	
	/**
	 * 查找 保险服务公司信息
	 * @param id
	 * @return
	 */
	public Insurcomputer findInsurcomputer(long id){
		return (Insurcomputer)(getSqlMapClientTemplate().queryForObject("findInsurcomputer",id));
	}
	
	/** 
	 * 查找 保险服务公司信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsurcomputer(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsurcomputerBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInsurcomputer",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找保险服务公司信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsurcomputer(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInsurcomputerBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 保险服务公司信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsurcomputerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInsurcomputerBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsurcomputerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsurcomputerBySql",map).toString()));
	}
}

