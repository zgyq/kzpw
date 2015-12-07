/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.vmoneyrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class VmoneyrecordManager extends  SqlMapClientDaoSupport  implements IVmoneyrecordManager{ 
	
  
 	/**
	 * 创建 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Vmoneyrecord createVmoneyrecord(Vmoneyrecord vmoneyrecord) throws SQLException{
	
		if(vmoneyrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		vmoneyrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_VMONEYRECORD"));
		getSqlMapClientTemplate().insert("createVmoneyrecord",vmoneyrecord);
		return vmoneyrecord;
	}
	/**
	 * 删除 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteVmoneyrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteVmoneyrecord", id);
	}
	
	
	/**
	 * 修改 虚拟账户充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateVmoneyrecord(Vmoneyrecord vmoneyrecord){
		return getSqlMapClientTemplate().update("updateVmoneyrecord",vmoneyrecord);
	
	}

		
	/**
	 * 修改 虚拟账户充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateVmoneyrecordIgnoreNull(Vmoneyrecord vmoneyrecord){
		Vmoneyrecord tmp = findVmoneyrecord(vmoneyrecord.getId());
		int flag =0;
		
		
		if(vmoneyrecord.getAgentid()>0){
			tmp.setAgentid(vmoneyrecord.getAgentid());
			
			flag++;
		}
		
		if(vmoneyrecord.getCreateuserid()>0){
			tmp.setCreateuserid(vmoneyrecord.getCreateuserid());
			
			flag++;
		}
		
		if(vmoneyrecord.getCreatetime()!=null){
			tmp.setCreatetime(vmoneyrecord.getCreatetime());
			
			flag++;
		}
		
		if(vmoneyrecord.getMemo()!=null){
			tmp.setMemo(vmoneyrecord.getMemo());
			
			flag++;
		}
		
		if(vmoneyrecord.getOrdernumber()!=null){
			tmp.setOrdernumber(vmoneyrecord.getOrdernumber());
			
			flag++;
		}
		
		if(vmoneyrecord.getType()!=null){
			tmp.setType(vmoneyrecord.getType());
			
			flag++;
		}
		
		if(vmoneyrecord.getCustomeruserid()!=null){
			tmp.setCustomeruserid(vmoneyrecord.getCustomeruserid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateVmoneyrecord",tmp);
		}
	}
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllVmoneyrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param id
	 * @return
	 */
	public Vmoneyrecord findVmoneyrecord(long id){
		return (Vmoneyrecord)(getSqlMapClientTemplate().queryForObject("findVmoneyrecord",id));
	}
	
	/** 
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllVmoneyrecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countVmoneyrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllVmoneyrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找虚拟账户充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllVmoneyrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 虚拟账户充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteVmoneyrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteVmoneyrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countVmoneyrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countVmoneyrecordBySql",map).toString()));
	}
}

