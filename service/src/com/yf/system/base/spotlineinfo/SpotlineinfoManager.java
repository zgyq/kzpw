/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlineinfoManager extends  SqlMapClientDaoSupport  implements ISpotlineinfoManager{ 
	
  
 	/**
	 * 创建 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineinfo createSpotlineinfo(Spotlineinfo spotlineinfo) throws SQLException{
	
		if(spotlineinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotlineinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINEINFO"));
		getSqlMapClientTemplate().insert("createSpotlineinfo",spotlineinfo);
		return spotlineinfo;
	}
	/**
	 * 删除 景区线路详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotlineinfo", id);
	}
	
	
	/**
	 * 修改 景区线路详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineinfo(Spotlineinfo spotlineinfo){
		return getSqlMapClientTemplate().update("updateSpotlineinfo",spotlineinfo);
	
	}

		
	/**
	 * 修改 景区线路详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineinfoIgnoreNull(Spotlineinfo spotlineinfo){
		Spotlineinfo tmp = findSpotlineinfo(spotlineinfo.getId());
		int flag =0;
		
		
		if(spotlineinfo.getSpotlineid()!=null){
			tmp.setSpotlineid(spotlineinfo.getSpotlineid());
			
			flag++;
		}
		
		if(spotlineinfo.getDday()!=null){
			tmp.setDday(spotlineinfo.getDday());
			
			flag++;
		}
		
		if(spotlineinfo.getQujian()!=null){
			tmp.setQujian(spotlineinfo.getQujian());
			
			flag++;
		}
		
		if(spotlineinfo.getZhusu()!=null){
			tmp.setZhusu(spotlineinfo.getZhusu());
			
			flag++;
		}
		
		if(spotlineinfo.getCanyin()!=null){
			tmp.setCanyin(spotlineinfo.getCanyin());
			
			flag++;
		}
		
		if(spotlineinfo.getBeizhu()!=null){
			tmp.setBeizhu(spotlineinfo.getBeizhu());
			
			flag++;
		}
		
		if(spotlineinfo.getParam1()!=null){
			tmp.setParam1(spotlineinfo.getParam1());
			
			flag++;
		}
		
		if(spotlineinfo.getParam2()!=null){
			tmp.setParam2(spotlineinfo.getParam2());
			
			flag++;
		}
		
		if(spotlineinfo.getParam3()!=null){
			tmp.setParam3(spotlineinfo.getParam3());
			
			flag++;
		}
		
		if(spotlineinfo.getState()!=null){
			tmp.setState(spotlineinfo.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotlineinfo",tmp);
		}
	}
	
	/**
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotlineinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 景区线路详细信息
	 * @param id
	 * @return
	 */
	public Spotlineinfo findSpotlineinfo(long id){
		return (Spotlineinfo)(getSqlMapClientTemplate().queryForObject("findSpotlineinfo",id));
	}
	
	/** 
	 * 查找 景区线路详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotlineinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景区线路详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlineinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景区线路详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlineinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineinfoBySql",map).toString()));
	}
}

