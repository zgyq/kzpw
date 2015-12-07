/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.specialprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpecialpriceManager extends  SqlMapClientDaoSupport  implements ISpecialpriceManager{ 
	
  
 	/**
	 * 创建 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public Specialprice createSpecialprice(Specialprice specialprice) throws SQLException{
	
		if(specialprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		specialprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPECIALPRICE"));
		getSqlMapClientTemplate().insert("createSpecialprice",specialprice);
		return specialprice;
	}
	/**
	 * 删除 特价机票信息（定期更新）
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpecialprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpecialprice", id);
	}
	
	
	/**
	 * 修改 特价机票信息（定期更新）
	 * @param id
	 * @return updated count 
	 */
	public int updateSpecialprice(Specialprice specialprice){
		return getSqlMapClientTemplate().update("updateSpecialprice",specialprice);
	
	}

		
	/**
	 * 修改 特价机票信息（定期更新）但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpecialpriceIgnoreNull(Specialprice specialprice){
		Specialprice tmp = findSpecialprice(specialprice.getId());
		int flag =0;
		
		
		if(specialprice.getStartport()!=null){
			tmp.setStartport(specialprice.getStartport());
			
			flag++;
		}
		
		if(specialprice.getArrivalport()!=null){
			tmp.setArrivalport(specialprice.getArrivalport());
			
			flag++;
		}
		
		if(specialprice.getStarttime()!=null){
			tmp.setStarttime(specialprice.getStarttime());
			
			flag++;
		}
		
		if(specialprice.getDiscount()!=null){
			tmp.setDiscount(specialprice.getDiscount());
			
			flag++;
		}
		
		if(specialprice.getPrice()!=null){
			tmp.setPrice(specialprice.getPrice());
			
			flag++;
		}
		
		if(specialprice.getUpdatetime()!=null){
			tmp.setUpdatetime(specialprice.getUpdatetime());
			
			flag++;
		}
		
		if(specialprice.getCreateuser()!=null){
			tmp.setCreateuser(specialprice.getCreateuser());
			
			flag++;
		}
		
		if(specialprice.getCreatetime()!=null){
			tmp.setCreatetime(specialprice.getCreatetime());
			
			flag++;
		}
		
		if(specialprice.getModifyuser()!=null){
			tmp.setModifyuser(specialprice.getModifyuser());
			
			flag++;
		}
		
		if(specialprice.getModifytime()!=null){
			tmp.setModifytime(specialprice.getModifytime());
			
			flag++;
		}
		
		if(specialprice.getIsinternal()!=0){
			tmp.setIsinternal(specialprice.getIsinternal());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpecialprice",tmp);
		}
	}
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpecialprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 特价机票信息（定期更新）
	 * @param id
	 * @return
	 */
	public Specialprice findSpecialprice(long id){
		return (Specialprice)(getSqlMapClientTemplate().queryForObject("findSpecialprice",id));
	}
	
	/** 
	 * 查找 特价机票信息（定期更新）
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpecialprice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpecialpriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpecialprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找特价机票信息（定期更新）
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpecialprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpecialpriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 特价机票信息（定期更新）
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpecialpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpecialpriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpecialpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpecialpriceBySql",map).toString()));
	}
}

