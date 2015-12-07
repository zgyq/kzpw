/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.eaccount;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class EaccountManager extends  SqlMapClientDaoSupport  implements IEaccountManager{ 
	
  
 	/**
	 * 创建 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public Eaccount createEaccount(Eaccount eaccount) throws SQLException{
	
		if(eaccount.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		eaccount.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_EACCOUNT"));
		getSqlMapClientTemplate().insert("createEaccount",eaccount);
		return eaccount;
	}
	/**
	 * 删除 外部账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEaccount(long id){
	
		return getSqlMapClientTemplate().delete("deleteEaccount", id);
	}
	
	
	/**
	 * 修改 外部账号
	 * @param id
	 * @return updated count 
	 */
	public int updateEaccount(Eaccount eaccount){
		return getSqlMapClientTemplate().update("updateEaccount",eaccount);
	
	}

		
	/**
	 * 修改 外部账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEaccountIgnoreNull(Eaccount eaccount){
		Eaccount tmp = findEaccount(eaccount.getId());
		int flag =0;
		
		
		if(eaccount.getName()!=null){
			tmp.setName(eaccount.getName());
			
			flag++;
		}
		
		if(eaccount.getEdesc()!=null){
			tmp.setEdesc(eaccount.getEdesc());
			
			flag++;
		}
		if(eaccount.getAngentid()!=null){
			tmp.setAngentid(eaccount.getAngentid());
			
			flag++;
		}
		
		if(eaccount.getUrl()!=null){
			tmp.setUrl(eaccount.getUrl());
			
			flag++;
		}
		
		if(eaccount.getNourl()!=null){
			tmp.setNourl(eaccount.getNourl());
			
			flag++;
		}
		
		if(eaccount.getPayurl()!=null){
			tmp.setPayurl(eaccount.getPayurl());
			
			flag++;
		}
		
		if(eaccount.getIspay()!=null){
			tmp.setIspay(eaccount.getIspay());
			
			flag++;
		}
		
		if(eaccount.getUsername()!=null){
			tmp.setUsername(eaccount.getUsername());
			
			flag++;
		}
		
		if(eaccount.getXiausername()!=null){
			tmp.setXiausername(eaccount.getXiausername());
			
			flag++;
		}
		
		if(eaccount.getKey()!=null){
			tmp.setKey(eaccount.getKey());
			
			flag++;
		}
		
		if(eaccount.getPassword()!=null){
			tmp.setPassword(eaccount.getPassword());
			
			flag++;
		}
		
		if(eaccount.getPwd()!=null){
			tmp.setPwd(eaccount.getPwd());
			
			flag++;
		}
		
		if(eaccount.getState()!=null){
			tmp.setState(eaccount.getState());
			
			flag++;
		}
		
		if(eaccount.getCreateuser()!=null){
			tmp.setCreateuser(eaccount.getCreateuser());
			
			flag++;
		}
		
		if(eaccount.getCreatetime()!=null){
			tmp.setCreatetime(eaccount.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateEaccount",tmp);
		}
	}
	
	/**
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllEaccount",map, offset, limit);
	}
		
	
	/**
	 * 查找 外部账号
	 * @param id
	 * @return
	 */
	public Eaccount findEaccount(long id){
		return (Eaccount)(getSqlMapClientTemplate().queryForObject("findEaccount",id));
	}
	
	/** 
	 * 查找 外部账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEaccount(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countEaccountBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllEaccount",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找外部账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEaccount(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllEaccountBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 外部账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEaccountBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteEaccountBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEaccountBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countEaccountBySql",map).toString()));
	}
}

