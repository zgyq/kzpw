/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cpzrate;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CpzrateManager extends  SqlMapClientDaoSupport  implements ICpzrateManager{ 
	
  
 	/**
	 * 创建 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public Cpzrate createCpzrate(Cpzrate cpzrate) throws SQLException{
	
		if(cpzrate.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		cpzrate.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CPZRATE"));
		getSqlMapClientTemplate().insert("createCpzrate",cpzrate);
		return cpzrate;
	}
	/**
	 * 删除 包机政策
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCpzrate(long id){
	
		return getSqlMapClientTemplate().delete("deleteCpzrate", id);
	}
	
	
	/**
	 * 修改 包机政策
	 * @param id
	 * @return updated count 
	 */
	public int updateCpzrate(Cpzrate cpzrate){
		return getSqlMapClientTemplate().update("updateCpzrate",cpzrate);
	
	}

		
	/**
	 * 修改 包机政策但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCpzrateIgnoreNull(Cpzrate cpzrate){
		Cpzrate tmp = findCpzrate(cpzrate.getId());
		int flag =0;
		
		
		if(cpzrate.getAircompany()!=null){
			tmp.setAircompany(cpzrate.getAircompany());
			
			flag++;
		}
		
		if(cpzrate.getBegindate()!=null){
			tmp.setBegindate(cpzrate.getBegindate());
			
			flag++;
		}
		
		if(cpzrate.getEnddate()!=null){
			tmp.setEnddate(cpzrate.getEnddate());
			
			flag++;
		}
		
		if(cpzrate.getStartcity()!=null){
			tmp.setStartcity(cpzrate.getStartcity());
			
			flag++;
		}
		
		if(cpzrate.getEndcity()!=null){
			tmp.setEndcity(cpzrate.getEndcity());
			
			flag++;
		}
		
		if(cpzrate.getAirline()!=null){
			tmp.setAirline(cpzrate.getAirline());
			
			flag++;
		}
		
		if(cpzrate.getAircode()!=null){
			tmp.setAircode(cpzrate.getAircode());
			
			flag++;
		}
		
		if(cpzrate.getPrice()!=null){
			tmp.setPrice(cpzrate.getPrice());
			
			flag++;
		}
		
		if(cpzrate.getDiscount()!=null){
			tmp.setDiscount(cpzrate.getDiscount());
			
			flag++;
		}
		
		if(cpzrate.getRebate()!=null){
			tmp.setRebate(cpzrate.getRebate());
			
			flag++;
		}
		
		if(cpzrate.getSprice()!=null){
			tmp.setSprice(cpzrate.getSprice());
			
			flag++;
		}
		
		if(cpzrate.getCreateuser()!=null){
			tmp.setCreateuser(cpzrate.getCreateuser());
			
			flag++;
		}
		
		if(cpzrate.getCreatetime()!=null){
			tmp.setCreatetime(cpzrate.getCreatetime());
			
			flag++;
		}
		
		if(cpzrate.getModifyuser()!=null){
			tmp.setModifyuser(cpzrate.getModifyuser());
			
			flag++;
		}
		
		if(cpzrate.getModifytime()!=null){
			tmp.setModifytime(cpzrate.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCpzrate",tmp);
		}
	}
	
	/**
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrate(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCpzrate",map, offset, limit);
	}
		
	
	/**
	 * 查找 包机政策
	 * @param id
	 * @return
	 */
	public Cpzrate findCpzrate(long id){
		return (Cpzrate)(getSqlMapClientTemplate().queryForObject("findCpzrate",id));
	}
	
	/** 
	 * 查找 包机政策
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCpzrate(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCpzrateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCpzrate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找包机政策
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCpzrate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCpzrateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 包机政策
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCpzrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCpzrateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCpzrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCpzrateBySql",map).toString()));
	}
}

