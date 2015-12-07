/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotmes;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotmesManager extends  SqlMapClientDaoSupport  implements ISpotmesManager{ 
	
  
 	/**
	 * 创建 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotmes createSpotmes(Spotmes spotmes) throws SQLException{
	
		if(spotmes.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotmes.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTMES"));
		getSqlMapClientTemplate().insert("createSpotmes",spotmes);
		return spotmes;
	}
	/**
	 * 删除 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotmes(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotmes", id);
	}
	
	
	/**
	 * 修改 景点信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotmes(Spotmes spotmes){
		return getSqlMapClientTemplate().update("updateSpotmes",spotmes);
	
	}

		
	/**
	 * 修改 景点信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotmesIgnoreNull(Spotmes spotmes){
		Spotmes tmp = findSpotmes(spotmes.getId());
		int flag =0;
		
		
		if(spotmes.getOutid()!=null){
			tmp.setOutid(spotmes.getOutid());
			
			flag++;
		}
		
		if(spotmes.getSid()!=null){
			tmp.setSid(spotmes.getSid());
			
			flag++;
		}
		
		if(spotmes.getUid()!=null){
			tmp.setUid(spotmes.getUid());
			
			flag++;
		}
		
		if(spotmes.getName()!=null){
			tmp.setName(spotmes.getName());
			
			flag++;
		}
		
		if(spotmes.getProvineid()!=null){
			tmp.setProvineid(spotmes.getProvineid());
			
			flag++;
		}
		
		if(spotmes.getCityid()!=null){
			tmp.setCityid(spotmes.getCityid());
			
			flag++;
		}
		
		if(spotmes.getAreaid()!=null){
			tmp.setAreaid(spotmes.getAreaid());
			
			flag++;
		}
		
		if(spotmes.getAddress()!=null){
			tmp.setAddress(spotmes.getAddress());
			
			flag++;
		}
		
		if(spotmes.getInfo()!=null){
			tmp.setInfo(spotmes.getInfo());
			
			flag++;
		}
		
		if(spotmes.getTraffic()!=null){
			tmp.setTraffic(spotmes.getTraffic());
			
			flag++;
		}
		
		if(spotmes.getNotice()!=null){
			tmp.setNotice(spotmes.getNotice());
			
			flag++;
		}
		
		if(spotmes.getPics()!=null){
			tmp.setPics(spotmes.getPics());
			
			flag++;
		}
		
		if(spotmes.getMinipics()!=null){
			tmp.setMinipics(spotmes.getMinipics());
			
			flag++;
		}
		
		if(spotmes.getTicketnotic()!=null){
			tmp.setTicketnotic(spotmes.getTicketnotic());
			
			flag++;
		}
		
		if(spotmes.getGuidelines()!=null){
			tmp.setGuidelines(spotmes.getGuidelines());
			
			flag++;
		}
		
		if(spotmes.getParam1()!=null){
			tmp.setParam1(spotmes.getParam1());
			
			flag++;
		}
		
		if(spotmes.getParam2()!=null){
			tmp.setParam2(spotmes.getParam2());
			
			flag++;
		}
		
		if(spotmes.getParam3()!=null){
			tmp.setParam3(spotmes.getParam3());
			
			flag++;
		}
		
		if(spotmes.getCreatetime()!=null){
			tmp.setCreatetime(spotmes.getCreatetime());
			
			flag++;
		}
		
		if(spotmes.getMemberid()!=null){
			tmp.setMemberid(spotmes.getMemberid());
			
			flag++;
		}
		
		if(spotmes.getState()!=null){
			tmp.setState(spotmes.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotmes",tmp);
		}
	}
	
	/**
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotmes",map, offset, limit);
	}
		
	
	/**
	 * 查找 景点信息
	 * @param id
	 * @return
	 */
	public Spotmes findSpotmes(long id){
		return (Spotmes)(getSqlMapClientTemplate().queryForObject("findSpotmes",id));
	}
	
	/** 
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotmesBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotmes",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景点信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotmesBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景点信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotmesBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotmesBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotmesBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotmesBySql",map).toString()));
	}
}

