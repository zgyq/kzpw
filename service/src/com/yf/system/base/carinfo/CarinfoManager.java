/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarinfoManager extends  SqlMapClientDaoSupport  implements ICarinfoManager{ 
	
  
 	/**
	 * 创建 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public Carinfo createCarinfo(Carinfo carinfo) throws SQLException{
	
		if(carinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARINFO"));
		getSqlMapClientTemplate().insert("createCarinfo",carinfo);
		return carinfo;
	}
	/**
	 * 删除 车型数据
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarinfo", id);
	}
	
	
	/**
	 * 修改 车型数据
	 * @param id
	 * @return updated count 
	 */
	public int updateCarinfo(Carinfo carinfo){
		return getSqlMapClientTemplate().update("updateCarinfo",carinfo);
	
	}

		
	/**
	 * 修改 车型数据但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarinfoIgnoreNull(Carinfo carinfo){
		Carinfo tmp = findCarinfo(carinfo.getId());
		int flag =0;
		
		
		if(carinfo.getName()!=null){
			tmp.setName(carinfo.getName());
			
			flag++;
		}
		
		if(carinfo.getCode()!=null){
			tmp.setCode(carinfo.getCode());
			
			flag++;
		}
		
		if(carinfo.getBrandcode()!=null){
			tmp.setBrandcode(carinfo.getBrandcode());
			
			flag++;
		}
		
		if(carinfo.getCarriage()!=null){
			tmp.setCarriage(carinfo.getCarriage());
			
			flag++;
		}
		
		if(carinfo.getDeliverycapacity()!=null){
			tmp.setDeliverycapacity(carinfo.getDeliverycapacity());
			
			flag++;
		}
		
		if(carinfo.getOilvolume()!=null){
			tmp.setOilvolume(carinfo.getOilvolume());
			
			flag++;
		}
		
		if(carinfo.getSeatingcount()!=null){
			tmp.setSeatingcount(carinfo.getSeatingcount());
			
			flag++;
		}
		
		if(carinfo.getGear()!=null){
			tmp.setGear(carinfo.getGear());
			
			flag++;
		}
		
		if(carinfo.getImageurl()!=null){
			tmp.setImageurl(carinfo.getImageurl());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarinfo",tmp);
		}
	}
	
	/**
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 车型数据
	 * @param id
	 * @return
	 */
	public Carinfo findCarinfo(long id){
		return (Carinfo)(getSqlMapClientTemplate().queryForObject("findCarinfo",id));
	}
	
	/** 
	 * 查找 车型数据
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找车型数据
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 车型数据
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarinfoBySql",map).toString()));
	}
}

