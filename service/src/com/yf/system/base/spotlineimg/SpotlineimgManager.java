/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineimg;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlineimgManager extends  SqlMapClientDaoSupport  implements ISpotlineimgManager{ 
	
  
 	/**
	 * 创建 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineimg createSpotlineimg(Spotlineimg spotlineimg) throws SQLException{
	
		if(spotlineimg.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotlineimg.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINEIMG"));
		getSqlMapClientTemplate().insert("createSpotlineimg",spotlineimg);
		return spotlineimg;
	}
	/**
	 * 删除 景区线路图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineimg(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotlineimg", id);
	}
	
	
	/**
	 * 修改 景区线路图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineimg(Spotlineimg spotlineimg){
		return getSqlMapClientTemplate().update("updateSpotlineimg",spotlineimg);
	
	}

		
	/**
	 * 修改 景区线路图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineimgIgnoreNull(Spotlineimg spotlineimg){
		Spotlineimg tmp = findSpotlineimg(spotlineimg.getId());
		int flag =0;
		
		
		if(spotlineimg.getSpotlineid()!=null){
			tmp.setSpotlineid(spotlineimg.getSpotlineid());
			
			flag++;
		}
		
		if(spotlineimg.getImgurl()!=null){
			tmp.setImgurl(spotlineimg.getImgurl());
			
			flag++;
		}
		
		if(spotlineimg.getName()!=null){
			tmp.setName(spotlineimg.getName());
			
			flag++;
		}
		
		if(spotlineimg.getBeizhu()!=null){
			tmp.setBeizhu(spotlineimg.getBeizhu());
			
			flag++;
		}
		
		if(spotlineimg.getParam1()!=null){
			tmp.setParam1(spotlineimg.getParam1());
			
			flag++;
		}
		
		if(spotlineimg.getParam2()!=null){
			tmp.setParam2(spotlineimg.getParam2());
			
			flag++;
		}
		
		if(spotlineimg.getParam3()!=null){
			tmp.setParam3(spotlineimg.getParam3());
			
			flag++;
		}
		
		if(spotlineimg.getState()!=null){
			tmp.setState(spotlineimg.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotlineimg",tmp);
		}
	}
	
	/**
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotlineimg",map, offset, limit);
	}
		
	
	/**
	 * 查找 景区线路图片信息
	 * @param id
	 * @return
	 */
	public Spotlineimg findSpotlineimg(long id){
		return (Spotlineimg)(getSqlMapClientTemplate().queryForObject("findSpotlineimg",id));
	}
	
	/** 
	 * 查找 景区线路图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineimg(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineimgBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotlineimg",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景区线路图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineimg(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlineimgBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景区线路图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineimgBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlineimgBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineimgBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineimgBySql",map).toString()));
	}
}

