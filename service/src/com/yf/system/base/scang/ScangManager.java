/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.scang;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ScangManager extends  SqlMapClientDaoSupport  implements IScangManager{ 
	
  
 	/**
	 * 创建 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public Scang createScang(Scang scang) throws SQLException{
	
		if(scang.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		scang.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SCANG"));
		getSqlMapClientTemplate().insert("createScang",scang);
		return scang;
	}
	/**
	 * 删除 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScang(long id){
	
		return getSqlMapClientTemplate().delete("deleteScang", id);
	}
	
	
	/**
	 * 修改 订单升舱表
	 * @param id
	 * @return updated count 
	 */
	public int updateScang(Scang scang){
		return getSqlMapClientTemplate().update("updateScang",scang);
	
	}

		
	/**
	 * 修改 订单升舱表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScangIgnoreNull(Scang scang){
		Scang tmp = findScang(scang.getId());
		int flag =0;
		
		
		if(scang.getPassengerid()!=null){
			tmp.setPassengerid(scang.getPassengerid());
			
			flag++;
		}
		
		if(scang.getStartcode()!=null){
			tmp.setStartcode(scang.getStartcode());
			
			flag++;
		}
		
		if(scang.getEndcode()!=null){
			tmp.setEndcode(scang.getEndcode());
			
			flag++;
		}
		
		if(scang.getOrdercode()!=null){
			tmp.setOrdercode(scang.getOrdercode());
			
			flag++;
		}
		
		if(scang.getOrderid()!=null){
			tmp.setOrderid(scang.getOrderid());
			
			flag++;
		}
		
		if(scang.getFlight()!=null){
			tmp.setFlight(scang.getFlight());
			
			flag++;
		}
		
		if(scang.getPnr()!=null){
			tmp.setPnr(scang.getPnr());
			
			flag++;
		}
		
		if(scang.getCreatetime()!=null){
			tmp.setCreatetime(scang.getCreatetime());
			
			flag++;
		}
		
		if(scang.getTransacttime()!=null){
			tmp.setTransacttime(scang.getTransacttime());
			
			flag++;
		}
		
		if(scang.getXiaolv()!=null){
			tmp.setXiaolv(scang.getXiaolv());
			
			flag++;
		}
		
		if(scang.getStates()!=null){
			tmp.setStates(scang.getStates());
			
			flag++;
		}
		
		if(scang.getStatus()!=null){
			tmp.setStatus(scang.getStatus());
			
			flag++;
		}
		
		if(scang.getApplyid()!=null){
			tmp.setApplyid(scang.getApplyid());
			
			flag++;
		}
		
		if(scang.getUpdateid()!=null){
			tmp.setUpdateid(scang.getUpdateid());
			
			flag++;
		}
		
		if(scang.getComment()!=null){
			tmp.setComment(scang.getComment());
			
			flag++;
		}
		
		if(scang.getPrice()!=null){
			tmp.setPrice(scang.getPrice());
			
			flag++;
		}
		
		if(scang.getNewpnr()!=null){
			tmp.setNewpnr(scang.getNewpnr());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateScang",tmp);
		}
	}
	
	/**
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllScang",map, offset, limit);
	}
		
	
	/**
	 * 查找 订单升舱表
	 * @param id
	 * @return
	 */
	public Scang findScang(long id){
		return (Scang)(getSqlMapClientTemplate().queryForObject("findScang",id));
	}
	
	/** 
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScang(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countScangBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllScang",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找订单升舱表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllScangBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 订单升舱表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScangBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteScangBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScangBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countScangBySql",map).toString()));
	}
}

