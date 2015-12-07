/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.nfdprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class NfdpriceManager extends  SqlMapClientDaoSupport  implements INfdpriceManager{ 
	
  
 	/**
	 * 创建 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public Nfdprice createNfdprice(Nfdprice nfdprice) throws SQLException{
	
		if(nfdprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		nfdprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_NFDPRICE"));
		getSqlMapClientTemplate().insert("createNfdprice",nfdprice);
		return nfdprice;
	}
	/**
	 * 删除 NFD价格
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNfdprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteNfdprice", id);
	}
	
	
	/**
	 * 修改 NFD价格
	 * @param id
	 * @return updated count 
	 */
	public int updateNfdprice(Nfdprice nfdprice){
		return getSqlMapClientTemplate().update("updateNfdprice",nfdprice);
	
	}

		
	/**
	 * 修改 NFD价格但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNfdpriceIgnoreNull(Nfdprice nfdprice){
		Nfdprice tmp = findNfdprice(nfdprice.getId());
		int flag =0;
		
		
		if(nfdprice.getScity()!=null){
			tmp.setScity(nfdprice.getScity());
			
			flag++;
		}
		
		if(nfdprice.getEcity()!=null){
			tmp.setEcity(nfdprice.getEcity());
			
			flag++;
		}
		
		if(nfdprice.getAircode()!=null){
			tmp.setAircode(nfdprice.getAircode());
			
			flag++;
		}
		
		if(nfdprice.getPrice()!=null){
			tmp.setPrice(nfdprice.getPrice());
			
			flag++;
		}
		
		if(nfdprice.getRtPrice()!=null){
			tmp.setRtPrice(nfdprice.getRtPrice());
			
			flag++;
		}
		
		if(nfdprice.getPriceleve()!=null){
			tmp.setPriceleve(nfdprice.getPriceleve());
			
			flag++;
		}
		
		if(nfdprice.getStime()!=null){
			tmp.setStime(nfdprice.getStime());
			
			flag++;
		}
		
		if(nfdprice.getEtime()!=null){
			tmp.setEtime(nfdprice.getEtime());
			
			flag++;
		}
		
		if(nfdprice.getSmday()!=null){
			tmp.setSmday(nfdprice.getSmday());
			
			flag++;
		}
		
		if(nfdprice.getBigday()!=null){
			tmp.setBigday(nfdprice.getBigday());
			
			flag++;
		}
		
		if(nfdprice.getParam1()!=null){
			tmp.setParam1(nfdprice.getParam1());
			
			flag++;
		}
		
		if(nfdprice.getParam2()!=null){
			tmp.setParam2(nfdprice.getParam2());
			
			flag++;
		}
		
		if(nfdprice.getParam3()!=null){
			tmp.setParam3(nfdprice.getParam3());
			
			flag++;
		}
		
		if(nfdprice.getCreatetime()!=null){
			tmp.setCreatetime(nfdprice.getCreatetime());
			
			flag++;
		}
		
		if(nfdprice.getState()!=null){
			tmp.setState(nfdprice.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateNfdprice",tmp);
		}
	}
	
	/**
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdprice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllNfdprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 NFD价格
	 * @param id
	 * @return
	 */
	public Nfdprice findNfdprice(long id){
		return (Nfdprice)(getSqlMapClientTemplate().queryForObject("findNfdprice",id));
	}
	
	/** 
	 * 查找 NFD价格
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNfdprice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countNfdpriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllNfdprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找NFD价格
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNfdprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllNfdpriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql NFD价格
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNfdpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteNfdpriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNfdpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countNfdpriceBySql",map).toString()));
	}
}

