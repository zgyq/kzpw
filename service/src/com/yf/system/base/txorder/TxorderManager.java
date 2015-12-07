/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.txorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TxorderManager extends  SqlMapClientDaoSupport  implements ITxorderManager{ 
	
  
 	/**
	 * 创建 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public Txorder createTxorder(Txorder txorder) throws SQLException{
	
		if(txorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		txorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TXORDER"));
		getSqlMapClientTemplate().insert("createTxorder",txorder);
		return txorder;
	}
	/**
	 * 删除 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteTxorder", id);
	}
	
	
	/**
	 * 修改 TX订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTxorder(Txorder txorder){
		return getSqlMapClientTemplate().update("updateTxorder",txorder);
	
	}

		
	/**
	 * 修改 TX订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxorderIgnoreNull(Txorder txorder){
		Txorder tmp = findTxorder(txorder.getId());
		int flag =0;
		
		
		if(txorder.getOrderno()!=null){
			tmp.setOrderno(txorder.getOrderno());
			
			flag++;
		}
		
		if(txorder.getPrice()!=null){
			tmp.setPrice(txorder.getPrice());
			
			flag++;
		}
		
		if(txorder.getFeilv()!=null){
			tmp.setFeilv(txorder.getFeilv());
			
			flag++;
		}
		
		if(txorder.getFeilvstr()!=null){
			tmp.setFeilvstr(txorder.getFeilvstr());
			
			flag++;
		}
		
		if(txorder.getFenrunstr()!=null){
			tmp.setFenrunstr(txorder.getFenrunstr());
			
			flag++;
		}
		
		if(txorder.getSjprice()!=null){
			tmp.setSjprice(txorder.getSjprice());
			
			flag++;
		}
		
		if(txorder.getAlipayname()!=null){
			tmp.setAlipayname(txorder.getAlipayname());
			
			flag++;
		}
		
		if(txorder.getBeizhu()!=null){
			tmp.setBeizhu(txorder.getBeizhu());
			
			flag++;
		}
		
		if(txorder.getParam1()!=null){
			tmp.setParam1(txorder.getParam1());
			
			flag++;
		}
		
		if(txorder.getParam2()!=null){
			tmp.setParam2(txorder.getParam2());
			
			flag++;
		}
		
		if(txorder.getParam3()!=null){
			tmp.setParam3(txorder.getParam3());
			
			flag++;
		}
		
		if(txorder.getCreatetime()!=null){
			tmp.setCreatetime(txorder.getCreatetime());
			
			flag++;
		}
		
		if(txorder.getMemberid()!=null){
			tmp.setMemberid(txorder.getMemberid());
			
			flag++;
		}
		
		if(txorder.getType()!=null){
			tmp.setType(txorder.getType());
			
			flag++;
		}
		
		if(txorder.getState()!=null){
			tmp.setState(txorder.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTxorder",tmp);
		}
	}
	
	/**
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTxorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 TX订单
	 * @param id
	 * @return
	 */
	public Txorder findTxorder(long id){
		return (Txorder)(getSqlMapClientTemplate().queryForObject("findTxorder",id));
	}
	
	/** 
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTxorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTxorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找TX订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTxorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql TX订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTxorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTxorderBySql",map).toString()));
	}
}

