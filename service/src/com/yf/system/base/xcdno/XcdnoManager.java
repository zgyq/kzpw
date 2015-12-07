/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdno;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class XcdnoManager extends  SqlMapClientDaoSupport  implements IXcdnoManager{ 
	
  
 	/**
	 * 创建 行程单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdno createXcdno(Xcdno xcdno) throws SQLException{
	
		if(xcdno.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		xcdno.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_XCDNO"));
		getSqlMapClientTemplate().insert("createXcdno",xcdno);
		return xcdno;
	}
	/**
	 * 删除 行程单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdno(long id){
	
		return getSqlMapClientTemplate().delete("deleteXcdno", id);
	}
	
	
	/**
	 * 修改 行程单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdno(Xcdno xcdno){
		return getSqlMapClientTemplate().update("updateXcdno",xcdno);
	
	}

		
	/**
	 * 修改 行程单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoIgnoreNull(Xcdno xcdno){
		Xcdno tmp = findXcdno(xcdno.getId());
		int flag =0;
		
		
		if(xcdno.getSno()!=null){
			tmp.setSno(xcdno.getSno());
			
			flag++;
		}
		
		if(xcdno.getEndno()!=null){
			tmp.setEndno(xcdno.getEndno());
			
			flag++;
		}
		
		if(xcdno.getAgentcode()!=null){
			tmp.setAgentcode(xcdno.getAgentcode());
			
			flag++;
		}
		
		if(xcdno.getOfficecode()!=null){
			tmp.setOfficecode(xcdno.getOfficecode());
			
			flag++;
		}
		
		if(xcdno.getCompanyname()!=null){
			tmp.setCompanyname(xcdno.getCompanyname());
			
			flag++;
		}
		
		if(xcdno.getAgentid()!=null){
			tmp.setAgentid(xcdno.getAgentid());
			
			flag++;
		}
		
		if(xcdno.getUserid()!=null){
			tmp.setUserid(xcdno.getUserid());
			
			flag++;
		}
		
		if(xcdno.getParam1()!=null){
			tmp.setParam1(xcdno.getParam1());
			
			flag++;
		}
		
		if(xcdno.getParam2()!=null){
			tmp.setParam2(xcdno.getParam2());
			
			flag++;
		}
		
		if(xcdno.getParam3()!=null){
			tmp.setParam3(xcdno.getParam3());
			
			flag++;
		}
		
		if(xcdno.getCreatetime()!=null){
			tmp.setCreatetime(xcdno.getCreatetime());
			
			flag++;
		}
		
		if(xcdno.getState()!=null){
			tmp.setState(xcdno.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateXcdno",tmp);
		}
	}
	
	/**
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdno(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllXcdno",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程单
	 * @param id
	 * @return
	 */
	public Xcdno findXcdno(long id){
		return (Xcdno)(getSqlMapClientTemplate().queryForObject("findXcdno",id));
	}
	
	/** 
	 * 查找 行程单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdno(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdnoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllXcdno",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdno(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllXcdnoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteXcdnoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdnoBySql",map).toString()));
	}
}

