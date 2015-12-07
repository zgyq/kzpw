/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.planeservice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PlaneserviceManager extends  SqlMapClientDaoSupport  implements IPlaneserviceManager{ 
	
  
 	/**
	 * 创建 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public Planeservice createPlaneservice(Planeservice planeservice) throws SQLException{
	
		if(planeservice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		planeservice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PLANESERVICE"));
		getSqlMapClientTemplate().insert("createPlaneservice",planeservice);
		return planeservice;
	}
	/**
	 * 删除 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public int deletePlaneservice(long id){
	
		return getSqlMapClientTemplate().delete("deletePlaneservice", id);
	}
	
	
	/**
	 * 修改 包机服务
	 * @param id
	 * @return updated count 
	 */
	public int updatePlaneservice(Planeservice planeservice){
		return getSqlMapClientTemplate().update("updatePlaneservice",planeservice);
	
	}

		
	/**
	 * 修改 包机服务但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePlaneserviceIgnoreNull(Planeservice planeservice){
		Planeservice tmp = findPlaneservice(planeservice.getId());
		int flag =0;
		
		
		if(planeservice.getTraveltime()!=null){
			tmp.setTraveltime(planeservice.getTraveltime());
			
			flag++;
		}
		
		if(planeservice.getReturntime()!=null){
			tmp.setReturntime(planeservice.getReturntime());
			
			flag++;
		}
		
		if(planeservice.getTravelcity()!=null){
			tmp.setTravelcity(planeservice.getTravelcity());
			
			flag++;
		}
		
		if(planeservice.getReturncity()!=null){
			tmp.setReturncity(planeservice.getReturncity());
			
			flag++;
		}
		
		if(planeservice.getNum()!=null){
			tmp.setNum(planeservice.getNum());
			
			flag++;
		}
		
		if(planeservice.getName()!=null){
			tmp.setName(planeservice.getName());
			
			flag++;
		}
		
		if(planeservice.getMobile()!=null){
			tmp.setMobile(planeservice.getMobile());
			
			flag++;
		}
		
		if(planeservice.getUnitname()!=null){
			tmp.setUnitname(planeservice.getUnitname());
			
			flag++;
		}
		
		if(planeservice.getAddress()!=null){
			tmp.setAddress(planeservice.getAddress());
			
			flag++;
		}
		
		if(planeservice.getZipcode()!=null){
			tmp.setZipcode(planeservice.getZipcode());
			
			flag++;
		}
		
		if(planeservice.getTel()!=null){
			tmp.setTel(planeservice.getTel());
			
			flag++;
		}
		
		if(planeservice.getFax()!=null){
			tmp.setFax(planeservice.getFax());
			
			flag++;
		}
		
		if(planeservice.getMailbox()!=null){
			tmp.setMailbox(planeservice.getMailbox());
			
			flag++;
		}
		
		if(planeservice.getModel()!=null){
			tmp.setModel(planeservice.getModel());
			
			flag++;
		}
		
		if(planeservice.getRemarks()!=null){
			tmp.setRemarks(planeservice.getRemarks());
			
			flag++;
		}
		
		if(planeservice.getCreatetime()!=null){
			tmp.setCreatetime(planeservice.getCreatetime());
			
			flag++;
		}
		
		if(planeservice.getMemberid()!=null){
			tmp.setMemberid(planeservice.getMemberid());
			
			flag++;
		}
		
		if(planeservice.getState()!=null){
			tmp.setState(planeservice.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePlaneservice",tmp);
		}
	}
	
	/**
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneservice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPlaneservice",map, offset, limit);
	}
		
	
	/**
	 * 查找 包机服务
	 * @param id
	 * @return
	 */
	public Planeservice findPlaneservice(long id){
		return (Planeservice)(getSqlMapClientTemplate().queryForObject("findPlaneservice",id));
	}
	
	/** 
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPlaneservice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPlaneserviceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPlaneservice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找包机服务
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneservice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPlaneserviceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 包机服务
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePlaneserviceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePlaneserviceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPlaneserviceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPlaneserviceBySql",map).toString()));
	}
}

