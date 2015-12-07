/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tousu;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TousuManager extends  SqlMapClientDaoSupport  implements ITousuManager{ 
	
  
 	/**
	 * 创建 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public Tousu createTousu(Tousu tousu) throws SQLException{
	
		if(tousu.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tousu.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TOUSU"));
		getSqlMapClientTemplate().insert("createTousu",tousu);
		return tousu;
	}
	/**
	 * 删除 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTousu(long id){
	
		return getSqlMapClientTemplate().delete("deleteTousu", id);
	}
	
	
	/**
	 * 修改 投诉建议表
	 * @param id
	 * @return updated count 
	 */
	public int updateTousu(Tousu tousu){
		return getSqlMapClientTemplate().update("updateTousu",tousu);
	
	}

		
	/**
	 * 修改 投诉建议表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTousuIgnoreNull(Tousu tousu){
		Tousu tmp = findTousu(tousu.getId());
		int flag =0;
		
		
		if(tousu.getStarttime()!=null){
			tmp.setStarttime(tousu.getStarttime());
			
			flag++;
		}
		
		if(tousu.getHour()!=null){
			tmp.setHour(tousu.getHour());
			
			flag++;
		}
		
		if(tousu.getMinute()!=null){
			tmp.setMinute(tousu.getMinute());
			
			flag++;
		}
		
		if(tousu.getStartcity()!=null){
			tmp.setStartcity(tousu.getStartcity());
			
			flag++;
		}
		
		if(tousu.getEndcity()!=null){
			tmp.setEndcity(tousu.getEndcity());
			
			flag++;
		}
		
		if(tousu.getFlightnumber()!=null){
			tmp.setFlightnumber(tousu.getFlightnumber());
			
			flag++;
		}
		
		if(tousu.getHappentime()!=null){
			tmp.setHappentime(tousu.getHappentime());
			
			flag++;
		}
		
		if(tousu.getUsername()!=null){
			tmp.setUsername(tousu.getUsername());
			
			flag++;
		}
		
		if(tousu.getSex()!=null){
			tmp.setSex(tousu.getSex());
			
			flag++;
		}
		
		if(tousu.getDainame()!=null){
			tmp.setDainame(tousu.getDainame());
			
			flag++;
		}
		
		if(tousu.getDaimobile()!=null){
			tmp.setDaimobile(tousu.getDaimobile());
			
			flag++;
		}
		
		if(tousu.getType()!=null){
			tmp.setType(tousu.getType());
			
			flag++;
		}
		
		if(tousu.getNumber()!=null){
			tmp.setNumber(tousu.getNumber());
			
			flag++;
		}
		
		if(tousu.getKahao()!=null){
			tmp.setKahao(tousu.getKahao());
			
			flag++;
		}
		
		if(tousu.getMobile()!=null){
			tmp.setMobile(tousu.getMobile());
			
			flag++;
		}
		
		if(tousu.getQitamobile()!=null){
			tmp.setQitamobile(tousu.getQitamobile());
			
			flag++;
		}
		
		if(tousu.getYoubian()!=null){
			tmp.setYoubian(tousu.getYoubian());
			
			flag++;
		}
		
		if(tousu.getAddress()!=null){
			tmp.setAddress(tousu.getAddress());
			
			flag++;
		}
		
		if(tousu.getFax()!=null){
			tmp.setFax(tousu.getFax());
			
			flag++;
		}
		
		if(tousu.getPostbox()!=null){
			tmp.setPostbox(tousu.getPostbox());
			
			flag++;
		}
		
		if(tousu.getUnits()!=null){
			tmp.setUnits(tousu.getUnits());
			
			flag++;
		}
		
		if(tousu.getIftype()!=null){
			tmp.setIftype(tousu.getIftype());
			
			flag++;
		}
		
		if(tousu.getComment()!=null){
			tmp.setComment(tousu.getComment());
			
			flag++;
		}
		
		if(tousu.getYaoqiu()!=null){
			tmp.setYaoqiu(tousu.getYaoqiu());
			
			flag++;
		}
		
		if(tousu.getCreatetime()!=null){
			tmp.setCreatetime(tousu.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTousu",tmp);
		}
	}
	
	/**
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTousu",map, offset, limit);
	}
		
	
	/**
	 * 查找 投诉建议表
	 * @param id
	 * @return
	 */
	public Tousu findTousu(long id){
		return (Tousu)(getSqlMapClientTemplate().queryForObject("findTousu",id));
	}
	
	/** 
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTousu(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTousuBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTousu",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找投诉建议表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTousuBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 投诉建议表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTousuBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTousuBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTousuBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTousuBySql",map).toString()));
	}
}

