/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlineorderManager extends  SqlMapClientDaoSupport  implements ISpotlineorderManager{ 
	
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineorder createSpotlineorder(Spotlineorder spotlineorder) throws SQLException{
	
		if(spotlineorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotlineorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINEORDER"));
		getSqlMapClientTemplate().insert("createSpotlineorder",spotlineorder);
		return spotlineorder;
	}
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotlineorder", id);
	}
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineorder(Spotlineorder spotlineorder){
		return getSqlMapClientTemplate().update("updateSpotlineorder",spotlineorder);
	
	}

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineorderIgnoreNull(Spotlineorder spotlineorder){
		Spotlineorder tmp = findSpotlineorder(spotlineorder.getId());
		int flag =0;
		
		
		if(spotlineorder.getOutid()!=null){
			tmp.setOutid(spotlineorder.getOutid());
			
			flag++;
		}
		
		if(spotlineorder.getOrderno()!=null){
			tmp.setOrderno(spotlineorder.getOrderno());
			
			flag++;
		}
		
		if(spotlineorder.getSpotlineid()!=null){
			tmp.setSpotlineid(spotlineorder.getSpotlineid());
			
			flag++;
		}
		
		if(spotlineorder.getName()!=null){
			tmp.setName(spotlineorder.getName());
			
			flag++;
		}
		
		if(spotlineorder.getProvineid()!=null){
			tmp.setProvineid(spotlineorder.getProvineid());
			
			flag++;
		}
		
		if(spotlineorder.getCityid()!=null){
			tmp.setCityid(spotlineorder.getCityid());
			
			flag++;
		}
		
		if(spotlineorder.getAreaid()!=null){
			tmp.setAreaid(spotlineorder.getAreaid());
			
			flag++;
		}
		
		if(spotlineorder.getAddress()!=null){
			tmp.setAddress(spotlineorder.getAddress());
			
			flag++;
		}
		
		if(spotlineorder.getSnum()!=null){
			tmp.setSnum(spotlineorder.getSnum());
			
			flag++;
		}
		
		if(spotlineorder.getLinkname()!=null){
			tmp.setLinkname(spotlineorder.getLinkname());
			
			flag++;
		}
		
		if(spotlineorder.getLinktel()!=null){
			tmp.setLinktel(spotlineorder.getLinktel());
			
			flag++;
		}
		
		if(spotlineorder.getStime()!=null){
			tmp.setStime(spotlineorder.getStime());
			
			flag++;
		}
		
		if(spotlineorder.getLinkemail()!=null){
			tmp.setLinkemail(spotlineorder.getLinkemail());
			
			flag++;
		}
		
		if(spotlineorder.getPrice()!=null){
			tmp.setPrice(spotlineorder.getPrice());
			
			flag++;
		}
		
		if(spotlineorder.getBeizhu()!=null){
			tmp.setBeizhu(spotlineorder.getBeizhu());
			
			flag++;
		}
		
		if(spotlineorder.getParam1()!=null){
			tmp.setParam1(spotlineorder.getParam1());
			
			flag++;
		}
		
		if(spotlineorder.getParam2()!=null){
			tmp.setParam2(spotlineorder.getParam2());
			
			flag++;
		}
		
		if(spotlineorder.getParam3()!=null){
			tmp.setParam3(spotlineorder.getParam3());
			
			flag++;
		}
		
		if(spotlineorder.getCreatetime()!=null){
			tmp.setCreatetime(spotlineorder.getCreatetime());
			
			flag++;
		}
		
		if(spotlineorder.getMemberid()!=null){
			tmp.setMemberid(spotlineorder.getMemberid());
			
			flag++;
		}
		
		if(spotlineorder.getPaystate()!=null){
			tmp.setPaystate(spotlineorder.getPaystate());
			
			flag++;
		}
		
		if(spotlineorder.getStopid()!=null){
			tmp.setStopid(spotlineorder.getStopid());
			
			flag++;
		}
		
		if(spotlineorder.getState()!=null){
			tmp.setState(spotlineorder.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotlineorder",tmp);
		}
	}
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotlineorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Spotlineorder findSpotlineorder(long id){
		return (Spotlineorder)(getSqlMapClientTemplate().queryForObject("findSpotlineorder",id));
	}
	
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotlineorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlineorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlineorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineorderBySql",map).toString()));
	}
}

