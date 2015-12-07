/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.creditcard;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CreditcardManager extends  SqlMapClientDaoSupport  implements ICreditcardManager{ 
	
  
 	/**
	 * 创建 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public Creditcard createCreditcard(Creditcard creditcard) throws SQLException{
	
		if(creditcard.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		creditcard.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CREDITCARD"));
		getSqlMapClientTemplate().insert("createCreditcard",creditcard);
		return creditcard;
	}
	/**
	 * 删除 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCreditcard(long id){
	
		return getSqlMapClientTemplate().delete("deleteCreditcard", id);
	}
	
	
	/**
	 * 修改 信用卡记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateCreditcard(Creditcard creditcard){
		return getSqlMapClientTemplate().update("updateCreditcard",creditcard);
	
	}

		
	/**
	 * 修改 信用卡记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCreditcardIgnoreNull(Creditcard creditcard){
		Creditcard tmp = findCreditcard(creditcard.getId());
		int flag =0;
		
		
		if(creditcard.getId()!=0){
			tmp.setId(creditcard.getId());
			
			flag++;
		}
		
		if(creditcard.getIdtype()!=null){
			tmp.setIdtype(creditcard.getIdtype());
			
			flag++;
		}
		
		if(creditcard.getIdno()!=null){
			tmp.setIdno(creditcard.getIdno());
			
			flag++;
		}
		
		if(creditcard.getCardmonth()>0){
			tmp.setCardmonth(creditcard.getCardmonth());
			
			flag++;
		}
		
		if(creditcard.getCardyear()>0){
			tmp.setCardyear(creditcard.getCardyear());
			
			flag++;
		}
		
		if(creditcard.getCardname()!=null){
			tmp.setCardname(creditcard.getCardname());
			
			flag++;
		}
		
		if(creditcard.getHotelorderid()!=0){
			tmp.setHotelorderid(creditcard.getHotelorderid());
			
			flag++;
		}
		
		if(creditcard.getCustomeruserid()!=0){
			tmp.setCustomeruserid(creditcard.getCustomeruserid());
			
			flag++;
		}
		
		if(creditcard.getCreditbank()!=null){
			tmp.setCreditbank(creditcard.getCreditbank());
			
			flag++;
		}
		
		if(creditcard.getCreditnumber()!=null){
			tmp.setCreditnumber(creditcard.getCreditnumber());
			
			flag++;
		}
		
		if(creditcard.getCreditexpiry()!=null){
			tmp.setCreditexpiry(creditcard.getCreditexpiry());
			
			flag++;
		}
		
		if(creditcard.getCreditcheckcode()!=null){
			tmp.setCreditcheckcode(creditcard.getCreditcheckcode());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCreditcard",tmp);
		}
	}
	
	/**
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCreditcard",map, offset, limit);
	}
		
	
	/**
	 * 查找 信用卡记录表
	 * @param id
	 * @return
	 */
	public Creditcard findCreditcard(long id){
		return (Creditcard)(getSqlMapClientTemplate().queryForObject("findCreditcard",id));
	}
	
	/** 
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCreditcardBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCreditcard",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找信用卡记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCreditcardBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 信用卡记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCreditcardBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCreditcardBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCreditcardBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCreditcardBySql",map).toString()));
	}
}

