/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cars;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarsManager extends  SqlMapClientDaoSupport  implements ICarsManager{ 
	
  
 	/**
	 * 创建 汽车列表
	 * @param id
	 * @return deleted count 
	 */
	public Cars createCars(Cars cars) throws SQLException{
	
		if(cars.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		cars.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARS"));
		getSqlMapClientTemplate().insert("createCars",cars);
		return cars;
	}
	/**
	 * 删除 汽车列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCars(long id){
	
		return getSqlMapClientTemplate().delete("deleteCars", id);
	}
	
	
	/**
	 * 修改 汽车列表
	 * @param id
	 * @return updated count 
	 */
	public int updateCars(Cars cars){
		return getSqlMapClientTemplate().update("updateCars",cars);
	
	}

		
	/**
	 * 修改 汽车列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsIgnoreNull(Cars cars){
		Cars tmp = findCars(cars.getId());
		int flag =0;
		
		
		if(cars.getName()!=null){
			tmp.setName(cars.getName());
			
			flag++;
		}
		
		if(cars.getCode()!=null){
			tmp.setCode(cars.getCode());
			
			flag++;
		}
		
		if(cars.getDescription()!=null){
			tmp.setDescription(cars.getDescription());
			
			flag++;
		}
		
		if(cars.getWeekdayprice()!=null){
			tmp.setWeekdayprice(cars.getWeekdayprice());
			
			flag++;
		}
		
		if(cars.getWeekendprice()!=null){
			tmp.setWeekendprice(cars.getWeekendprice());
			
			flag++;
		}
		
		if(cars.getHolidayprice()!=null){
			tmp.setHolidayprice(cars.getHolidayprice());
			
			flag++;
		}
		
		if(cars.getHolidayname()!=null){
			tmp.setHolidayname(cars.getHolidayname());
			
			flag++;
		}
		
		if(cars.getInsurancefee()!=null){
			tmp.setInsurancefee(cars.getInsurancefee());
			
			flag++;
		}
		
		if(cars.getServicefee()!=null){
			tmp.setServicefee(cars.getServicefee());
			
			flag++;
		}
		
		if(cars.getPreauthfee()!=null){
			tmp.setPreauthfee(cars.getPreauthfee());
			
			flag++;
		}
		
		if(cars.getExtimefee()!=null){
			tmp.setExtimefee(cars.getExtimefee());
			
			flag++;
		}
		
		if(cars.getExmilefee()!=null){
			tmp.setExmilefee(cars.getExmilefee());
			
			flag++;
		}
		
		if(cars.getMile()!=null){
			tmp.setMile(cars.getMile());
			
			flag++;
		}
		
		if(cars.getAvailable()!=null){
			tmp.setAvailable(cars.getAvailable());
			
			flag++;
		}
		
		if(cars.getImgurl()!=null){
			tmp.setImgurl(cars.getImgurl());
			
			flag++;
		}
		
		if(cars.getMaxpassenger()!=null){
			tmp.setMaxpassenger(cars.getMaxpassenger());
			
			flag++;
		}
		
		if(cars.getPpai()!=null){
			tmp.setPpai(cars.getPpai());
			
			flag++;
		}
		
		if(cars.getCityid()!=null){
			tmp.setCityid(cars.getCityid());
			
			flag++;
		}
		
		if(cars.getCarstoreid()!=null){
			tmp.setCarstoreid(cars.getCarstoreid());
			
			flag++;
		}
		
		if(cars.getSort()!=null){
			tmp.setSort(cars.getSort());
			
			flag++;
		}
		
		if(cars.getCreatetime()!=null){
			tmp.setCreatetime(cars.getCreatetime());
			
			flag++;
		}
		
		if(cars.getCreateuser()!=null){
			tmp.setCreateuser(cars.getCreateuser());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCars",tmp);
		}
	}
	
	/**
	 * 查找 汽车列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCars(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCars",map, offset, limit);
	}
		
	
	/**
	 * 查找 汽车列表
	 * @param id
	 * @return
	 */
	public Cars findCars(long id){
		return (Cars)(getSqlMapClientTemplate().queryForObject("findCars",id));
	}
	
	/** 
	 * 查找 汽车列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCars(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarsBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCars",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找汽车列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCars(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarsBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 汽车列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarsBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarsBySql",map).toString()));
	}
}

