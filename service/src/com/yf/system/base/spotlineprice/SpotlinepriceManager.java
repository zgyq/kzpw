/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlinepriceManager extends  SqlMapClientDaoSupport  implements ISpotlinepriceManager{ 
	
  
 	/**
	 * 创建 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineprice createSpotlineprice(Spotlineprice spotlineprice) throws SQLException{
	
		if(spotlineprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotlineprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINEPRICE"));
		getSqlMapClientTemplate().insert("createSpotlineprice",spotlineprice);
		return spotlineprice;
	}
	/**
	 * 删除 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotlineprice", id);
	}
	
	
	/**
	 * 修改 景区线路价格信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineprice(Spotlineprice spotlineprice){
		return getSqlMapClientTemplate().update("updateSpotlineprice",spotlineprice);
	
	}

		
	/**
	 * 修改 景区线路价格信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlinepriceIgnoreNull(Spotlineprice spotlineprice){
		Spotlineprice tmp = findSpotlineprice(spotlineprice.getId());
		int flag =0;
		
		
		if(spotlineprice.getSpotlineid()!=null){
			tmp.setSpotlineid(spotlineprice.getSpotlineid());
			
			flag++;
		}
		
		if(spotlineprice.getPtype()!=null){
			tmp.setPtype(spotlineprice.getPtype());
			
			flag++;
		}
		
		if(spotlineprice.getLsprice()!=null){
			tmp.setLsprice(spotlineprice.getLsprice());
			
			flag++;
		}
		
		if(spotlineprice.getPrice()!=null){
			tmp.setPrice(spotlineprice.getPrice());
			
			flag++;
		}
		
		if(spotlineprice.getParam1()!=null){
			tmp.setParam1(spotlineprice.getParam1());
			
			flag++;
		}
		
		if(spotlineprice.getParam2()!=null){
			tmp.setParam2(spotlineprice.getParam2());
			
			flag++;
		}
		
		if(spotlineprice.getParam3()!=null){
			tmp.setParam3(spotlineprice.getParam3());
			
			flag++;
		}
		
		if(spotlineprice.getState()!=null){
			tmp.setState(spotlineprice.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotlineprice",tmp);
		}
	}
	
	/**
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotlineprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 景区线路价格信息
	 * @param id
	 * @return
	 */
	public Spotlineprice findSpotlineprice(long id){
		return (Spotlineprice)(getSqlMapClientTemplate().queryForObject("findSpotlineprice",id));
	}
	
	/** 
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlinepriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotlineprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景区线路价格信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlinepriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景区线路价格信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlinepriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlinepriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlinepriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlinepriceBySql",map).toString()));
	}
}

