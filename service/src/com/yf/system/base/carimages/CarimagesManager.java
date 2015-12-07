/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carimages;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarimagesManager extends  SqlMapClientDaoSupport  implements ICarimagesManager{ 
	
  
 	/**
	 * 创建 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public Carimages createCarimages(Carimages carimages) throws SQLException{
	
		if(carimages.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carimages.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARIMAGES"));
		getSqlMapClientTemplate().insert("createCarimages",carimages);
		return carimages;
	}
	/**
	 * 删除 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarimages(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarimages", id);
	}
	
	
	/**
	 * 修改 汽车图片
	 * @param id
	 * @return updated count 
	 */
	public int updateCarimages(Carimages carimages){
		return getSqlMapClientTemplate().update("updateCarimages",carimages);
	
	}

		
	/**
	 * 修改 汽车图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarimagesIgnoreNull(Carimages carimages){
		Carimages tmp = findCarimages(carimages.getId());
		int flag =0;
		
		
		if(carimages.getName()!=null){
			tmp.setName(carimages.getName());
			
			flag++;
		}
		
		if(carimages.getCarurl()!=null){
			tmp.setCarurl(carimages.getCarurl());
			
			flag++;
		}
		
		if(carimages.getCardesc()!=null){
			tmp.setCardesc(carimages.getCardesc());
			
			flag++;
		}
		
		if(carimages.getCarid()!=null){
			tmp.setCarid(carimages.getCarid());
			
			flag++;
		}
		
		if(carimages.getCreateuser()!=null){
			tmp.setCreateuser(carimages.getCreateuser());
			
			flag++;
		}
		
		if(carimages.getCreatetime()!=null){
			tmp.setCreatetime(carimages.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarimages",tmp);
		}
	}
	
	/**
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarimages",map, offset, limit);
	}
		
	
	/**
	 * 查找 汽车图片
	 * @param id
	 * @return
	 */
	public Carimages findCarimages(long id){
		return (Carimages)(getSqlMapClientTemplate().queryForObject("findCarimages",id));
	}
	
	/** 
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarimagesBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarimages",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找汽车图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarimagesBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 汽车图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarimagesBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarimagesBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarimagesBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarimagesBySql",map).toString()));
	}
}

