/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.txuserinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TxuserinfoManager extends  SqlMapClientDaoSupport  implements ITxuserinfoManager{ 
	
  
 	/**
	 * 创建 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public Txuserinfo createTxuserinfo(Txuserinfo txuserinfo) throws SQLException{
	
		if(txuserinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		txuserinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TXUSERINFO"));
		getSqlMapClientTemplate().insert("createTxuserinfo",txuserinfo);
		return txuserinfo;
	}
	/**
	 * 删除 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxuserinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteTxuserinfo", id);
	}
	
	
	/**
	 * 修改 用户信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTxuserinfo(Txuserinfo txuserinfo){
		return getSqlMapClientTemplate().update("updateTxuserinfo",txuserinfo);
	
	}

		
	/**
	 * 修改 用户信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxuserinfoIgnoreNull(Txuserinfo txuserinfo){
		Txuserinfo tmp = findTxuserinfo(txuserinfo.getId());
		int flag =0;
		
		
		if(txuserinfo.getLoginname()!=null){
			tmp.setLoginname(txuserinfo.getLoginname());
			
			flag++;
		}
		
		if(txuserinfo.getLoginpwd()!=null){
			tmp.setLoginpwd(txuserinfo.getLoginpwd());
			
			flag++;
		}
		
		if(txuserinfo.getPid()!=null){
			tmp.setPid(txuserinfo.getPid());
			
			flag++;
		}
		
		if(txuserinfo.getPidstr()!=null){
			tmp.setPidstr(txuserinfo.getPidstr());
			
			flag++;
		}
		
		if(txuserinfo.getFeilv()!=null){
			tmp.setFeilv(txuserinfo.getFeilv());
			
			flag++;
		}
		
		if(txuserinfo.getName()!=null){
			tmp.setName(txuserinfo.getName());
			
			flag++;
		}
		
		if(txuserinfo.getAlipayname()!=null){
			tmp.setAlipayname(txuserinfo.getAlipayname());
			
			flag++;
		}
		
		if(txuserinfo.getBeizhu()!=null){
			tmp.setBeizhu(txuserinfo.getBeizhu());
			
			flag++;
		}
		
		if(txuserinfo.getAddress()!=null){
			tmp.setAddress(txuserinfo.getAddress());
			
			flag++;
		}
		
		if(txuserinfo.getParam1()!=null){
			tmp.setParam1(txuserinfo.getParam1());
			
			flag++;
		}
		
		if(txuserinfo.getParam2()!=null){
			tmp.setParam2(txuserinfo.getParam2());
			
			flag++;
		}
		
		if(txuserinfo.getParam3()!=null){
			tmp.setParam3(txuserinfo.getParam3());
			
			flag++;
		}
		
		if(txuserinfo.getCreatetime()!=null){
			tmp.setCreatetime(txuserinfo.getCreatetime());
			
			flag++;
		}
		
		if(txuserinfo.getMemberid()!=null){
			tmp.setMemberid(txuserinfo.getMemberid());
			
			flag++;
		}
		
		if(txuserinfo.getType()!=null){
			tmp.setType(txuserinfo.getType());
			
			flag++;
		}
		
		if(txuserinfo.getState()!=null){
			tmp.setState(txuserinfo.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTxuserinfo",tmp);
		}
	}
	
	/**
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTxuserinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 用户信息
	 * @param id
	 * @return
	 */
	public Txuserinfo findTxuserinfo(long id){
		return (Txuserinfo)(getSqlMapClientTemplate().queryForObject("findTxuserinfo",id));
	}
	
	/** 
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxuserinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTxuserinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTxuserinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找用户信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTxuserinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 用户信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxuserinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTxuserinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxuserinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTxuserinfoBySql",map).toString()));
	}
}

