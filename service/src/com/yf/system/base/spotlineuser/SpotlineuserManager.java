/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineuser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlineuserManager extends  SqlMapClientDaoSupport  implements ISpotlineuserManager{ 
	
  
 	/**
	 * 创建 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineuser createSpotlineuser(Spotlineuser spotlineuser) throws SQLException{
	
		if(spotlineuser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotlineuser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINEUSER"));
		getSqlMapClientTemplate().insert("createSpotlineuser",spotlineuser);
		return spotlineuser;
	}
	/**
	 * 删除 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineuser(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotlineuser", id);
	}
	
	
	/**
	 * 修改 线路游客
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineuser(Spotlineuser spotlineuser){
		return getSqlMapClientTemplate().update("updateSpotlineuser",spotlineuser);
	
	}

		
	/**
	 * 修改 线路游客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineuserIgnoreNull(Spotlineuser spotlineuser){
		Spotlineuser tmp = findSpotlineuser(spotlineuser.getId());
		int flag =0;
		
		
		if(spotlineuser.getOrderid()!=null){
			tmp.setOrderid(spotlineuser.getOrderid());
			
			flag++;
		}
		
		if(spotlineuser.getPtype()!=null){
			tmp.setPtype(spotlineuser.getPtype());
			
			flag++;
		}
		
		if(spotlineuser.getPsex()!=null){
			tmp.setPsex(spotlineuser.getPsex());
			
			flag++;
		}
		
		if(spotlineuser.getName()!=null){
			tmp.setName(spotlineuser.getName());
			
			flag++;
		}
		
		if(spotlineuser.getIdtype()!=null){
			tmp.setIdtype(spotlineuser.getIdtype());
			
			flag++;
		}
		
		if(spotlineuser.getIdno()!=null){
			tmp.setIdno(spotlineuser.getIdno());
			
			flag++;
		}
		
		if(spotlineuser.getTel()!=null){
			tmp.setTel(spotlineuser.getTel());
			
			flag++;
		}
		
		if(spotlineuser.getPrice()!=null){
			tmp.setPrice(spotlineuser.getPrice());
			
			flag++;
		}
		
		if(spotlineuser.getParam1()!=null){
			tmp.setParam1(spotlineuser.getParam1());
			
			flag++;
		}
		
		if(spotlineuser.getParam2()!=null){
			tmp.setParam2(spotlineuser.getParam2());
			
			flag++;
		}
		
		if(spotlineuser.getParam3()!=null){
			tmp.setParam3(spotlineuser.getParam3());
			
			flag++;
		}
		
		if(spotlineuser.getCreatetime()!=null){
			tmp.setCreatetime(spotlineuser.getCreatetime());
			
			flag++;
		}
		
		if(spotlineuser.getState()!=null){
			tmp.setState(spotlineuser.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotlineuser",tmp);
		}
	}
	
	/**
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotlineuser",map, offset, limit);
	}
		
	
	/**
	 * 查找 线路游客
	 * @param id
	 * @return
	 */
	public Spotlineuser findSpotlineuser(long id){
		return (Spotlineuser)(getSqlMapClientTemplate().queryForObject("findSpotlineuser",id));
	}
	
	/** 
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineuserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotlineuser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找线路游客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlineuserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 线路游客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineuserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlineuserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineuserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineuserBySql",map).toString()));
	}
}

