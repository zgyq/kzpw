/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traderecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TraderecordManager extends  SqlMapClientDaoSupport  implements ITraderecordManager{ 
	
  
 	/**
	 * 创建 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public Traderecord createTraderecord(Traderecord traderecord) throws SQLException{
	
		if(traderecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		traderecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRADERECORD"));
		getSqlMapClientTemplate().insert("createTraderecord",traderecord);
		return traderecord;
	}
	/**
	 * 删除 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraderecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteTraderecord", id);
	}
	
	
	/**
	 * 修改 交易记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTraderecord(Traderecord traderecord){
		return getSqlMapClientTemplate().update("updateTraderecord",traderecord);
	
	}

		
	/**
	 * 修改 交易记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraderecordIgnoreNull(Traderecord traderecord){
		Traderecord tmp = findTraderecord(traderecord.getId());
		int flag =0;
		
		
		if(traderecord.getCreateuser()!=null){
			tmp.setCreateuser(traderecord.getCreateuser());
			
			flag++;
		}
		
		if(traderecord.getCreatetime()!=null){
			tmp.setCreatetime(traderecord.getCreatetime());
			
			flag++;
		}
		
		if(traderecord.getModifyuser()!=null){
			tmp.setModifyuser(traderecord.getModifyuser());
			
			flag++;
		}
		
		if(traderecord.getModifytime()!=null){
			tmp.setModifytime(traderecord.getModifytime());
			
			flag++;
		}
		
		if(traderecord.getOrdercode()!=null){
			tmp.setOrdercode(traderecord.getOrdercode());
			
			flag++;
		}
		
		if(traderecord.getState()!=null){
			tmp.setState(traderecord.getState());
			
			flag++;
		}
		
		
		if(traderecord.getPaytype()!=null){
			tmp.setPaytype(traderecord.getPaytype());
			
			flag++;
		}
		
		if(traderecord.getPayname()!=null){
			tmp.setPayname(traderecord.getPayname());
			
			flag++;
		}
		
		if(traderecord.getRetcode()!=null){
			tmp.setRetcode(traderecord.getRetcode());
			
			flag++;
		}
		
		if(traderecord.getDescription()!=null){
			tmp.setDescription(traderecord.getDescription());
			
			flag++;
		}
		
		if(traderecord.getCode()!=null){
			tmp.setCode(traderecord.getCode());
			
			flag++;
		}
		
		if(traderecord.getGoodsname()!=null){
			tmp.setGoodsname(traderecord.getGoodsname());
			
			flag++;
		}
		
		if(traderecord.getGoodsdesc()!=null){
			tmp.setGoodsdesc(traderecord.getGoodsdesc());
			
			flag++;
		}
		
		if(traderecord.getType()!=null){
			tmp.setType(traderecord.getType());
			
			flag++;
		}
		
		if(traderecord.getBankcode()!=null){
			tmp.setBankcode(traderecord.getBankcode());
			
			flag++;
		}
		
		if(traderecord.getPaymothed()!=null){
			tmp.setPaymothed(traderecord.getPaymothed());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTraderecord",tmp);
		}
	}
	
	/**
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTraderecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 交易记录
	 * @param id
	 * @return
	 */
	public Traderecord findTraderecord(long id){
		return (Traderecord)(getSqlMapClientTemplate().queryForObject("findTraderecord",id));
	}
	
	/** 
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraderecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTraderecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找交易记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTraderecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 交易记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraderecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTraderecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraderecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraderecordBySql",map).toString()));
	}
}

