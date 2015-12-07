/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carstore;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarstoreManager extends  SqlMapClientDaoSupport  implements ICarstoreManager{ 
	
  
 	/**
	 * 创建 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public Carstore createCarstore(Carstore carstore) throws SQLException{
	
		if(carstore.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carstore.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARSTORE"));
		getSqlMapClientTemplate().insert("createCarstore",carstore);
		return carstore;
	}
	/**
	 * 删除 租车门店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarstore(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarstore", id);
	}
	
	
	/**
	 * 修改 租车门店
	 * @param id
	 * @return updated count 
	 */
	public int updateCarstore(Carstore carstore){
		return getSqlMapClientTemplate().update("updateCarstore",carstore);
	
	}

		
	/**
	 * 修改 租车门店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarstoreIgnoreNull(Carstore carstore){
		Carstore tmp = findCarstore(carstore.getId());
		int flag =0;
		
		
		if(carstore.getStorecode()!=null){
			tmp.setStorecode(carstore.getStorecode());
			
			flag++;
		}
		
		if(carstore.getName()!=null){
			tmp.setName(carstore.getName());
			
			flag++;
		}
		
		if(carstore.getAddress()!=null){
			tmp.setAddress(carstore.getAddress());
			
			flag++;
		}
		
		if(carstore.getFormtime()!=null){
			tmp.setFormtime(carstore.getFormtime());
			
			flag++;
		}
		
		if(carstore.getTotime()!=null){
			tmp.setTotime(carstore.getTotime());
			
			flag++;
		}
		
		if(carstore.getCityid()!=null){
			tmp.setCityid(carstore.getCityid());
			
			flag++;
		}
		
		if(carstore.getProvincecode()!=null){
			tmp.setProvincecode(carstore.getProvincecode());
			
			flag++;
		}
		
		if(carstore.getCreateuserid()!=null){
			tmp.setCreateuserid(carstore.getCreateuserid());
			
			flag++;
		}
		
		if(carstore.getTel()!=null){
			tmp.setTel(carstore.getTel());
			
			flag++;
		}
		
		if(carstore.getDistrict()!=null){
			tmp.setDistrict(carstore.getDistrict());
			
			flag++;
		}
		
		if(carstore.getAbbrname()!=null){
			tmp.setAbbrname(carstore.getAbbrname());
			
			flag++;
		}
		
		if(carstore.getComment()!=null){
			tmp.setComment(carstore.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarstore",tmp);
		}
	}
	
	/**
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarstore",map, offset, limit);
	}
		
	
	/**
	 * 查找 租车门店
	 * @param id
	 * @return
	 */
	public Carstore findCarstore(long id){
		return (Carstore)(getSqlMapClientTemplate().queryForObject("findCarstore",id));
	}
	
	/** 
	 * 查找 租车门店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarstore(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarstoreBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarstore",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找租车门店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarstore(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarstoreBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 租车门店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarstoreBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarstoreBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarstoreBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarstoreBySql",map).toString()));
	}
}

