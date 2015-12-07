/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qmoneyrecharge;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QmoneyrechargeManager extends  SqlMapClientDaoSupport  implements IQmoneyrechargeManager{ 
	
  
 	/**
	 * 创建 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public Qmoneyrecharge createQmoneyrecharge(Qmoneyrecharge qmoneyrecharge) throws SQLException{
	
		if(qmoneyrecharge.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qmoneyrecharge.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QMONEYRECHARGE"));
		getSqlMapClientTemplate().insert("createQmoneyrecharge",qmoneyrecharge);
		return qmoneyrecharge;
	}
	
	
	/**
	 * 删除 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmoneyrecharge(long id){
	
		return getSqlMapClientTemplate().delete("deleteQmoneyrecharge", id);
	}
	
	
	/**
	 * 修改 Q币充值表
	 * @param id
	 * @return updated count 
	 */
	public int updateQmoneyrecharge(Qmoneyrecharge qmoneyrecharge){
		return getSqlMapClientTemplate().update("updateQmoneyrecharge",qmoneyrecharge);
	
	}

		
	/**
	 * 修改 Q币充值表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmoneyrechargeIgnoreNull(Qmoneyrecharge qmoneyrecharge){
		Qmoneyrecharge tmp = findQmoneyrecharge(qmoneyrecharge.getId());
		int flag =0;
		
		
		if(qmoneyrecharge.getOrdernumber()!=null){
			tmp.setOrdernumber(qmoneyrecharge.getOrdernumber());
			
			flag++;
		}
		
		if(qmoneyrecharge.getPaystate()>-1){
			tmp.setPaystate(qmoneyrecharge.getPaystate());
			flag++;
		}
		if(qmoneyrecharge.getCardid()!=null){
			tmp.setCardid(qmoneyrecharge.getCardid());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRefordernumber()!=null){
			tmp.setRefordernumber(qmoneyrecharge.getRefordernumber());
			flag++;
		}
		if(qmoneyrecharge.getPaymethod()>0){
			tmp.setPaymethod(qmoneyrecharge.getPaymethod());
			flag++;
		}
		if(qmoneyrecharge.getBuynum()>0){
			tmp.setBuynum(qmoneyrecharge.getBuynum());
			
			flag++;
		}
		
		if(qmoneyrecharge.getQqnumber()!=null){
			tmp.setQqnumber(qmoneyrecharge.getQqnumber());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRechmoney()!=null){
			tmp.setRechmoney(qmoneyrecharge.getRechmoney());
			
			flag++;
		}
		if(qmoneyrecharge.getInprice()!=null){
			tmp.setInprice(qmoneyrecharge.getInprice());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRechtime()!=null){
			tmp.setRechtime(qmoneyrecharge.getRechtime());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRechuid()!=0){
			tmp.setRechuid(qmoneyrecharge.getRechuid());
			
			flag++;
		}
		if(qmoneyrecharge.getRechagentid()!=0){
			tmp.setRechagentid(qmoneyrecharge.getRechagentid());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRechtouid()!=0){
			tmp.setRechtouid(qmoneyrecharge.getRechtouid());
			
			flag++;
		}
		
		if(qmoneyrecharge.getRechstate()!=-1){
			tmp.setRechstate(qmoneyrecharge.getRechstate());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQmoneyrecharge",tmp);
		}
	}
	
	/**
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrecharge(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQmoneyrecharge",map, offset, limit);
	}
		
	
	/**
	 * 查找 Q币充值表
	 * @param id
	 * @return
	 */
	public Qmoneyrecharge findQmoneyrecharge(long id){
		return (Qmoneyrecharge)(getSqlMapClientTemplate().queryForObject("findQmoneyrecharge",id));
	}
	
	/** 
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmoneyrecharge(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQmoneyrechargeBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQmoneyrecharge",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找Q币充值表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrecharge(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQmoneyrechargeBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql Q币充值表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmoneyrechargeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQmoneyrechargeBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmoneyrechargeBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQmoneyrechargeBySql",map).toString()));
	}
}

