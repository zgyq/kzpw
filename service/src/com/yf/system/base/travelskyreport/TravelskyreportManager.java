/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.travelskyreport;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TravelskyreportManager extends  SqlMapClientDaoSupport  implements ITravelskyreportManager{ 
	
  
 	/**
	 * 创建 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public Travelskyreport createTravelskyreport(Travelskyreport travelskyreport) throws SQLException{
	
		if(travelskyreport.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		travelskyreport.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAVELSKYREPORT"));
		getSqlMapClientTemplate().insert("createTravelskyreport",travelskyreport);
		return travelskyreport;
	}
	/**
	 * 删除 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTravelskyreport(long id){
	
		return getSqlMapClientTemplate().delete("deleteTravelskyreport", id);
	}
	
	
	/**
	 * 修改 航空公司报表导入
	 * @param id
	 * @return updated count 
	 */
	public int updateTravelskyreport(Travelskyreport travelskyreport){
		return getSqlMapClientTemplate().update("updateTravelskyreport",travelskyreport);
	
	}

		
	/**
	 * 修改 航空公司报表导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTravelskyreportIgnoreNull(Travelskyreport travelskyreport){
		Travelskyreport tmp = findTravelskyreport(travelskyreport.getId());
		int flag =0;
		
		
		if(travelskyreport.getTktnumber()!=null){
			tmp.setTktnumber(travelskyreport.getTktnumber());
			
			flag++;
		}
		
		if(travelskyreport.getOrigsest()!=null){
			tmp.setOrigsest(travelskyreport.getOrigsest());
			
			flag++;
		}
		
		if(travelskyreport.getTicketprice()!=null){
			tmp.setTicketprice(travelskyreport.getTicketprice());
			
			flag++;
		}
		
		if(travelskyreport.getTaxs()!=null){
			tmp.setTaxs(travelskyreport.getTaxs());
			
			flag++;
		}
		
		if(travelskyreport.getComm()!=null){
			tmp.setComm(travelskyreport.getComm());
			
			flag++;
		}
		
		if(travelskyreport.getPnr()!=null){
			tmp.setPnr(travelskyreport.getPnr());
			
			flag++;
		}
		
		if(travelskyreport.getAgent()!=null){
			tmp.setAgent(travelskyreport.getAgent());
			
			flag++;
		}
		
		if(travelskyreport.getStatus()!=null){
			tmp.setStatus(travelskyreport.getStatus());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTravelskyreport",tmp);
		}
	}
	
	/**
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreport(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTravelskyreport",map, offset, limit);
	}
		
	
	/**
	 * 查找 航空公司报表导入
	 * @param id
	 * @return
	 */
	public Travelskyreport findTravelskyreport(long id){
		return (Travelskyreport)(getSqlMapClientTemplate().queryForObject("findTravelskyreport",id));
	}
	
	/** 
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTravelskyreport(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTravelskyreportBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTravelskyreport",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航空公司报表导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreport(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTravelskyreportBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航空公司报表导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTravelskyreportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTravelskyreportBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTravelskyreportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTravelskyreportBySql",map).toString()));
	}
}

