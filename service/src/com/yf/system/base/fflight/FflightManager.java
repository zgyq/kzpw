/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fflight;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FflightManager extends  SqlMapClientDaoSupport  implements IFflightManager{ 
	
  
 	/**
	 * 创建 国际机票行程
	 * @param id
	 * @return deleted count 
	 */
	public Fflight createFflight(Fflight fflight) throws SQLException{
	
		if(fflight.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fflight.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FFLIGHT"));
		getSqlMapClientTemplate().insert("createFflight",fflight);
		return fflight;
	}
	/**
	 * 删除 国际机票行程
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFflight(long id){
	
		return getSqlMapClientTemplate().delete("deleteFflight", id);
	}
	
	
	/**
	 * 修改 国际机票行程
	 * @param id
	 * @return updated count 
	 */
	public int updateFflight(Fflight fflight){
		return getSqlMapClientTemplate().update("updateFflight",fflight);
	
	}

		
	/**
	 * 修改 国际机票行程但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFflightIgnoreNull(Fflight fflight){
		Fflight tmp = findFflight(fflight.getId());
		int flag =0;
		
		
		if(fflight.getOrderid()!=null){
			tmp.setOrderid(fflight.getOrderid());
			
			flag++;
		}
		
		if(fflight.getTotalfare()!=null){
			tmp.setTotalfare(fflight.getTotalfare());
			
			flag++;
		}
		
		if(fflight.getTotaltax()!=null){
			tmp.setTotaltax(fflight.getTotaltax());
			
			flag++;
		}
		
		if(fflight.getPolicymark()!=null){
			tmp.setPolicymark(fflight.getPolicymark());
			
			flag++;
		}
		
		if(fflight.getAircom()!=null){
			tmp.setAircom(fflight.getAircom());
			
			flag++;
		}
		
		if(fflight.getCw()!=null){
			tmp.setCw(fflight.getCw());
			
			flag++;
		}
		
		if(fflight.getFromairport()!=null){
			tmp.setFromairport(fflight.getFromairport());
			
			flag++;
		}
		
		if(fflight.getToairport()!=null){
			tmp.setToairport(fflight.getToairport());
			
			flag++;
		}
		
		if(fflight.getFromdate()!=null){
			tmp.setFromdate(fflight.getFromdate());
			
			flag++;
		}
		
		if(fflight.getFlightnumber()!=null){
			tmp.setFlightnumber(fflight.getFlightnumber());
			
			flag++;
		}
		
		if(fflight.getTodate()!=null){
			tmp.setTodate(fflight.getTodate());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFflight",tmp);
		}
	}
	
	/**
	 * 查找 国际机票行程
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFflight",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票行程
	 * @param id
	 * @return
	 */
	public Fflight findFflight(long id){
		return (Fflight)(getSqlMapClientTemplate().queryForObject("findFflight",id));
	}
	
	/** 
	 * 查找 国际机票行程
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFflight(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFflightBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFflight",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票行程
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFflightBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票行程
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFflightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFflightBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFflightBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFflightBySql",map).toString()));
	}
}

