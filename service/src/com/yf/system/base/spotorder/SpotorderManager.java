/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotorderManager extends  SqlMapClientDaoSupport  implements ISpotorderManager{ 
	
  
 	/**
	 * 创建 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotorder createSpotorder(Spotorder spotorder) throws SQLException{
	
		if(spotorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTORDER"));
		getSqlMapClientTemplate().insert("createSpotorder",spotorder);
		return spotorder;
	}
	/**
	 * 删除 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotorder", id);
	}
	
	
	/**
	 * 修改 门票订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotorder(Spotorder spotorder){
		return getSqlMapClientTemplate().update("updateSpotorder",spotorder);
	
	}

		
	/**
	 * 修改 门票订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotorderIgnoreNull(Spotorder spotorder){
		Spotorder tmp = findSpotorder(spotorder.getId());
		int flag =0;
		
		
		if(spotorder.getOutid()!=null){
			tmp.setOutid(spotorder.getOutid());
			
			flag++;
		}
		
		if(spotorder.getspotorderid()!=null){
			tmp.setspotorderid(spotorder.getspotorderid());
			
			flag++;
		}
		
		if(spotorder.getSpotticketid()!=null){
			tmp.setSpotticketid(spotorder.getSpotticketid());
			
			flag++;
		}
		
		if(spotorder.getName()!=null){
			tmp.setName(spotorder.getName());
			
			flag++;
		}
		
		if(spotorder.getProvineid()!=null){
			tmp.setProvineid(spotorder.getProvineid());
			
			flag++;
		}
		
		if(spotorder.getCityid()!=null){
			tmp.setCityid(spotorder.getCityid());
			
			flag++;
		}
		
		if(spotorder.getAreaid()!=null){
			tmp.setAreaid(spotorder.getAreaid());
			
			flag++;
		}
		
		if(spotorder.getAddress()!=null){
			tmp.setAddress(spotorder.getAddress());
			
			flag++;
		}
		
		if(spotorder.getSunm()!=null){
			tmp.setSunm(spotorder.getSunm());
			
			flag++;
		}
		
		if(spotorder.getSfz()!=null){
			tmp.setSfz(spotorder.getSfz());
			
			flag++;
		}
		
		if(spotorder.getTel()!=null){
			tmp.setTel(spotorder.getTel());
			
			flag++;
		}
		
		if(spotorder.getStime()!=null){
			tmp.setStime(spotorder.getStime());
			
			flag++;
		}
		
		if(spotorder.getMinipics()!=null){
			tmp.setMinipics(spotorder.getMinipics());
			
			flag++;
		}
		
		if(spotorder.getPrice()!=null){
			tmp.setPrice(spotorder.getPrice());
			
			flag++;
		}
		
		if(spotorder.getGuidelines()!=null){
			tmp.setGuidelines(spotorder.getGuidelines());
			
			flag++;
		}
		
		if(spotorder.getParam1()!=null){
			tmp.setParam1(spotorder.getParam1());
			
			flag++;
		}
		
		if(spotorder.getParam2()!=null){
			tmp.setParam2(spotorder.getParam2());
			
			flag++;
		}
		
		if(spotorder.getParam3()!=null){
			tmp.setParam3(spotorder.getParam3());
			
			flag++;
		}
		
		if(spotorder.getCreatetime()!=null){
			tmp.setCreatetime(spotorder.getCreatetime());
			
			flag++;
		}
		
		if(spotorder.getMemberid()!=null){
			tmp.setMemberid(spotorder.getMemberid());
			
			flag++;
		}
		
		if(spotorder.getState()!=null){
			tmp.setState(spotorder.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotorder",tmp);
		}
	}
	
	/**
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 门票订单
	 * @param id
	 * @return
	 */
	public Spotorder findSpotorder(long id){
		return (Spotorder)(getSqlMapClientTemplate().queryForObject("findSpotorder",id));
	}
	
	/** 
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找门票订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 门票订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotorderBySql",map).toString()));
	}
}

