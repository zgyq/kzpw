/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.kweifabu;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class KweifabuManager extends  SqlMapClientDaoSupport  implements IKweifabuManager{ 
	
  
 	/**
	 * 创建 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public Kweifabu createKweifabu(Kweifabu kweifabu) throws SQLException{
	
		if(kweifabu.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		kweifabu.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_KWEIFABU"));
		getSqlMapClientTemplate().insert("createKweifabu",kweifabu);
		return kweifabu;
	}
	/**
	 * 删除 K位特价发布表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweifabu(long id){
	
		return getSqlMapClientTemplate().delete("deleteKweifabu", id);
	}
	
	
	/**
	 * 修改 K位特价发布表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweifabu(Kweifabu kweifabu){
		return getSqlMapClientTemplate().update("updateKweifabu",kweifabu);
	
	}

		
	/**
	 * 修改 K位特价发布表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweifabuIgnoreNull(Kweifabu kweifabu){
		Kweifabu tmp = findKweifabu(kweifabu.getId());
		int flag =0;
		
		
		if(kweifabu.getAngenid()!=null){
			tmp.setAngenid(kweifabu.getAngenid());
			
			flag++;
		}
		
		if(kweifabu.getFlighttype()!=null){
			tmp.setFlighttype(kweifabu.getFlighttype());
			
			flag++;
		}
		
		if(kweifabu.getCa()!=null){
			tmp.setCa(kweifabu.getCa());
			
			flag++;
		}
		
		if(kweifabu.getStarttime()!=null){
			tmp.setStarttime(kweifabu.getStarttime());
			
			flag++;
		}
		
		if(kweifabu.getStartcity()!=null){
			tmp.setStartcity(kweifabu.getStartcity());
			
			flag++;
		}
		
		if(kweifabu.getEndcity()!=null){
			tmp.setEndcity(kweifabu.getEndcity());
			
			flag++;
		}
		
		if(kweifabu.getFlightnumber()!=null){
			tmp.setFlightnumber(kweifabu.getFlightnumber());
			
			flag++;
		}
		
		if(kweifabu.getCabincode()!=null){
			tmp.setCabincode(kweifabu.getCabincode());
			
			flag++;
		}
		
		if(kweifabu.getCreatetime()!=null){
			tmp.setCreatetime(kweifabu.getCreatetime());
			
			flag++;
		}
		
		if(kweifabu.getNominalprice()!=null){
			tmp.setNominalprice(kweifabu.getNominalprice());
			
			flag++;
		}
		
		if(kweifabu.getDiscount()!=null){
			tmp.setDiscount(kweifabu.getDiscount());
			
			flag++;
		}
		
		if(kweifabu.getTaxrate()!=null){
			tmp.setTaxrate(kweifabu.getTaxrate());
			
			flag++;
		}
		
		if(kweifabu.getComment()!=null){
			tmp.setComment(kweifabu.getComment());
			
			flag++;
		}
		
		if(kweifabu.getSettlementprice()!=null){
			tmp.setSettlementprice(kweifabu.getSettlementprice());
			
			flag++;
		}
		
		if(kweifabu.getPolicy()!=null){
			tmp.setPolicy(kweifabu.getPolicy());
			
			flag++;
		}
		
		if(kweifabu.getUsertype()!=null){
			tmp.setUsertype(kweifabu.getUsertype());
			
			flag++;
		}
		
		if(kweifabu.getCreateuser()!=null){
			tmp.setCreateuser(kweifabu.getCreateuser());
			
			flag++;
		}
		
		if(kweifabu.getStatus()!=null){
			tmp.setStatus(kweifabu.getStatus());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateKweifabu",tmp);
		}
	}
	
	/**
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabu(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllKweifabu",map, offset, limit);
	}
		
	
	/**
	 * 查找 K位特价发布表
	 * @param id
	 * @return
	 */
	public Kweifabu findKweifabu(long id){
		return (Kweifabu)(getSqlMapClientTemplate().queryForObject("findKweifabu",id));
	}
	
	/** 
	 * 查找 K位特价发布表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweifabu(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countKweifabuBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllKweifabu",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找K位特价发布表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweifabu(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllKweifabuBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql K位特价发布表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweifabuBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteKweifabuBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweifabuBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countKweifabuBySql",map).toString()));
	}
}

