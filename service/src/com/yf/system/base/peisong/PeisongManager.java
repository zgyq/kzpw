/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.peisong;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PeisongManager extends  SqlMapClientDaoSupport  implements IPeisongManager{ 
	
  
 	/**
	 * 创建 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public Peisong createPeisong(Peisong peisong) throws SQLException{
	
		if(peisong.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		peisong.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PEISONG"));
		getSqlMapClientTemplate().insert("createPeisong",peisong);
		return peisong;
	}
	/**
	 * 删除 行程单配送记录
	 * @param id
	 * @return deleted count 
	 */
	public int deletePeisong(long id){
	
		return getSqlMapClientTemplate().delete("deletePeisong", id);
	}
	
	
	/**
	 * 修改 行程单配送记录
	 * @param id
	 * @return updated count 
	 */
	public int updatePeisong(Peisong peisong){
		return getSqlMapClientTemplate().update("updatePeisong",peisong);
	
	}

		
	/**
	 * 修改 行程单配送记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePeisongIgnoreNull(Peisong peisong){
		Peisong tmp = findPeisong(peisong.getId());
		int flag =0;
		
		
		if(peisong.getOrderid()!=null){
			tmp.setOrderid(peisong.getOrderid());
			
			flag++;
		}
		
		if(peisong.getLinkname()!=null){
			tmp.setLinkname(peisong.getLinkname());
			
			flag++;
		}
		
		if(peisong.getAddcode()!=null){
			tmp.setAddcode(peisong.getAddcode());
			
			flag++;
		}
		
		if(peisong.getLinktel()!=null){
			tmp.setLinktel(peisong.getLinktel());
			
			flag++;
		}
		
		if(peisong.getDizhi()!=null){
			tmp.setDizhi(peisong.getDizhi());
			
			flag++;
		}
		
		if(peisong.getAgentid()!=null){
			tmp.setAgentid(peisong.getAgentid());
			
			flag++;
		}
		
		if(peisong.getUserid()!=null){
			tmp.setUserid(peisong.getUserid());
			
			flag++;
		}
		
		if(peisong.getParam1()!=null){
			tmp.setParam1(peisong.getParam1());
			
			flag++;
		}
		
		if(peisong.getParam2()!=null){
			tmp.setParam2(peisong.getParam2());
			
			flag++;
		}
		
		if(peisong.getParam3()!=null){
			tmp.setParam3(peisong.getParam3());
			
			flag++;
		}
		
		if(peisong.getCreatetime()!=null){
			tmp.setCreatetime(peisong.getCreatetime());
			
			flag++;
		}
		
		if(peisong.getState()!=null){
			tmp.setState(peisong.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePeisong",tmp);
		}
	}
	
	/**
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPeisong",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程单配送记录
	 * @param id
	 * @return
	 */
	public Peisong findPeisong(long id){
		return (Peisong)(getSqlMapClientTemplate().queryForObject("findPeisong",id));
	}
	
	/** 
	 * 查找 行程单配送记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPeisong(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPeisongBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPeisong",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程单配送记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPeisong(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPeisongBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程单配送记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePeisongBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePeisongBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPeisongBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPeisongBySql",map).toString()));
	}
}

