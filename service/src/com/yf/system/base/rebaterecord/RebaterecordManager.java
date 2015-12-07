/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RebaterecordManager extends  SqlMapClientDaoSupport  implements IRebaterecordManager{ 
	
  
 	/**
	 * 创建 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterecord createRebaterecord(Rebaterecord rebaterecord) throws SQLException{
	
		if(rebaterecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		rebaterecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_REBATERECORD"));
		getSqlMapClientTemplate().insert("createRebaterecord",rebaterecord);
		return rebaterecord;
	}
	/**
	 * 删除 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteRebaterecord", id);
	}
	
	
	/**
	 * 修改 返佣记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterecord(Rebaterecord rebaterecord){
		return getSqlMapClientTemplate().update("updateRebaterecord",rebaterecord);
	
	}

		
	/**
	 * 修改 返佣记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebaterecordIgnoreNull(Rebaterecord rebaterecord){
		Rebaterecord tmp = findRebaterecord(rebaterecord.getId());
		int flag =0;
		
		tmp.setPaystate(rebaterecord.getPaystate());
		if(rebaterecord.getYewutype()!=0){
			tmp.setYewutype(rebaterecord.getYewutype());
			
			flag++;
		}
		
		if(rebaterecord.getOrdernumber()!=null){
			tmp.setOrdernumber(rebaterecord.getOrdernumber());
			
			flag++;
		}
		if(rebaterecord.getRebateagentjibie()!=null){
			tmp.setRebateagentjibie(rebaterecord.getRebateagentjibie());
			
			flag++;
			
		}
		if(rebaterecord.getRebateagentid()!=0){
			tmp.setRebateagentid(rebaterecord.getRebateagentid());
			
			flag++;
		}
		
		if(rebaterecord.getChildagentid()!=0){
			tmp.setChildagentid(rebaterecord.getChildagentid());
			
			flag++;
		}
		
		if(rebaterecord.getRebateagentidstr()!=null){
			tmp.setRebateagentidstr(rebaterecord.getRebateagentidstr());
			
			flag++;
		}
		
		if(rebaterecord.getRebatemoney()>-1){
			tmp.setRebatemoney(rebaterecord.getRebatemoney());
			
			flag++;
		}
		if(rebaterecord.getRebatetime()!=null){
			tmp.setRebatetime(rebaterecord.getRebatetime());
			
			flag++;
		}
		
		if(rebaterecord.getRebatememo()!=null){
			tmp.setRebatememo(rebaterecord.getRebatememo());
			
			flag++;
		}
		
		if(rebaterecord.getCustomerid()!=0){
			tmp.setCustomerid(rebaterecord.getCustomerid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRebaterecord",tmp);
		}
	}
	
	/**
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRebaterecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 返佣记录表
	 * @param id
	 * @return
	 */
	public Rebaterecord findRebaterecord(long id){
		return (Rebaterecord)(getSqlMapClientTemplate().queryForObject("findRebaterecord",id));
	}
	
	/** 
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,PageInfo pageinfo,String ...sql){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		if(sql!=null&&sql.length>0){
			System.out.println(sql[0]);
			map.put("selfsql", sql[0]);
		}
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRebaterecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRebaterecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找返佣记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRebaterecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 返佣记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebaterecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRebaterecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebaterecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRebaterecordBySql",map).toString()));
	}
}

