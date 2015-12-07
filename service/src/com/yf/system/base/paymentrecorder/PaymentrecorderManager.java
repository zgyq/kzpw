/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.paymentrecorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PaymentrecorderManager extends  SqlMapClientDaoSupport  implements IPaymentrecorderManager{ 
	
  
 	/**
	 * 创建 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public Paymentrecorder createPaymentrecorder(Paymentrecorder paymentrecorder) throws SQLException{
	
		if(paymentrecorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		paymentrecorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PAYMENTRECORDER"));
		getSqlMapClientTemplate().insert("createPaymentrecorder",paymentrecorder);
		if(paymentrecorder.getUcode()==null||paymentrecorder.getUcode()<1)
		{
			paymentrecorder.setUcode(paymentrecorder.getId());
			updatePaymentrecorderIgnoreNull(paymentrecorder);
		}
		return paymentrecorder;
	}
	/**
	 * 删除 支付记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePaymentrecorder(long id){
	
		return getSqlMapClientTemplate().delete("deletePaymentrecorder", id);
	}
	
	
	/**
	 * 修改 支付记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePaymentrecorder(Paymentrecorder paymentrecorder){
		return getSqlMapClientTemplate().update("updatePaymentrecorder",paymentrecorder);
	
	}

		
	/**
	 * 修改 支付记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePaymentrecorderIgnoreNull(Paymentrecorder paymentrecorder){
		Paymentrecorder tmp = findPaymentrecorder(paymentrecorder.getId());
		int flag =0;
		
		
		if(paymentrecorder.getCreateuser()!=null){
			tmp.setCreateuser(paymentrecorder.getCreateuser());
			
			flag++;
		}
		
		if(paymentrecorder.getCreatetime()!=null){
			tmp.setCreatetime(paymentrecorder.getCreatetime());
			
			flag++;
		}
		
		if(paymentrecorder.getModifyuser()!=null){
			tmp.setModifyuser(paymentrecorder.getModifyuser());
			
			flag++;
		}
		
		if(paymentrecorder.getModifytime()!=null){
			tmp.setModifytime(paymentrecorder.getModifytime());
			
			flag++;
		}
		
		if(paymentrecorder.getOrdercode()!=null){
			tmp.setOrdercode(paymentrecorder.getOrdercode());
			
			flag++;
		}
		
		if(paymentrecorder.getState()!=null){
			tmp.setState(paymentrecorder.getState());
			
			flag++;
		}
		
		if(paymentrecorder.getPaytype()!=null){
			tmp.setPaytype(paymentrecorder.getPaytype());
			
			flag++;
		}
		
		if(paymentrecorder.getAmount()!=null){
			tmp.setAmount(paymentrecorder.getAmount());
			
			flag++;
		}
		
		if(paymentrecorder.getPayname()!=null){
			tmp.setPayname(paymentrecorder.getPayname());
			
			flag++;
		}
		
		if(paymentrecorder.getRetcode()!=null){
			tmp.setRetcode(paymentrecorder.getRetcode());
			
			flag++;
		}
		
		if(paymentrecorder.getReturl()!=null){
			tmp.setReturl(paymentrecorder.getReturl());
			
			flag++;
		}
		
		if(paymentrecorder.getDescription()!=null){
			tmp.setDescription(paymentrecorder.getDescription());
			
			flag++;
		}
		
		if(paymentrecorder.getCode()!=null){
			tmp.setCode(paymentrecorder.getCode());
			
			flag++;
		}
		
		if(paymentrecorder.getProductname()!=null){
			tmp.setProductname(paymentrecorder.getProductname());
			
			flag++;
		}
		
		if(paymentrecorder.getProductesc()!=null){
			tmp.setProductesc(paymentrecorder.getProductesc());
			
			flag++;
		}
		
		if(paymentrecorder.getProducturl()!=null){
			tmp.setProducturl(paymentrecorder.getProducturl());
			
			flag++;
		}
		
		if(paymentrecorder.getUcode()!=null){
			tmp.setUcode(paymentrecorder.getUcode());
			
			flag++;
		}
		
		if(paymentrecorder.getLanguage()!=null){
			tmp.setLanguage(paymentrecorder.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePaymentrecorder",tmp);
		}
	}
	
	/**
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Paymentrecorder.COL_language+" = 0 OR "+Paymentrecorder.COL_language+" is NULL)";
		}
		else if(where.indexOf(Paymentrecorder.COL_language)<0)
		{
			where+=" and ("+Paymentrecorder.COL_language+" = 0 OR "+Paymentrecorder.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPaymentrecorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 支付记录
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorder(long id){
		return (Paymentrecorder)(getSqlMapClientTemplate().queryForObject("findPaymentrecorder",id));
	}
	/**
	 * 查找 支付记录 by language
	 * @param id
	 * @return
	 */
	public Paymentrecorder findPaymentrecorderbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Paymentrecorder.COL_ucode+" = "+id+" and "+Paymentrecorder.COL_language+" = "+language;	
		List list=findAllPaymentrecorder(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Paymentrecorder)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 支付记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPaymentrecorder(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Paymentrecorder.COL_language+" = 0";
		}
		else if(where.indexOf(Paymentrecorder.COL_language)<0)
		{
			where+=" and "+Paymentrecorder.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPaymentrecorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPaymentrecorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找支付记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPaymentrecorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPaymentrecorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 支付记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePaymentrecorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePaymentrecorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPaymentrecorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPaymentrecorderBySql",map).toString()));
	}
}

