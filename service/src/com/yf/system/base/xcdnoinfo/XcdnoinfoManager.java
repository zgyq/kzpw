/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdnoinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class XcdnoinfoManager extends  SqlMapClientDaoSupport  implements IXcdnoinfoManager{ 
	
  
 	/**
	 * 创建 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public Xcdnoinfo createXcdnoinfo(Xcdnoinfo xcdnoinfo) throws SQLException{
	
		if(xcdnoinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		xcdnoinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_XCDNOINFO"));
		getSqlMapClientTemplate().insert("createXcdnoinfo",xcdnoinfo);
		return xcdnoinfo;
	}
	/**
	 * 删除 行程单号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdnoinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteXcdnoinfo", id);
	}
	
	
	/**
	 * 修改 行程单号码
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdnoinfo(Xcdnoinfo xcdnoinfo){
		return getSqlMapClientTemplate().update("updateXcdnoinfo",xcdnoinfo);
	
	}

		
	/**
	 * 修改 行程单号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdnoinfoIgnoreNull(Xcdnoinfo xcdnoinfo){
		Xcdnoinfo tmp = findXcdnoinfo(xcdnoinfo.getId());
		int flag =0;
		
		
		if(xcdnoinfo.getSno()!=null){
			tmp.setSno(xcdnoinfo.getSno());
			
			flag++;
		}
		
		if(xcdnoinfo.getEndno()!=null){
			tmp.setEndno(xcdnoinfo.getEndno());
			
			flag++;
		}
		
		if(xcdnoinfo.getXcdid()!=null){
			tmp.setXcdid(xcdnoinfo.getXcdid());
			
			flag++;
		}
		
		if(xcdnoinfo.getXcdinfo()!=null){
			tmp.setXcdinfo(xcdnoinfo.getXcdinfo());
			
			flag++;
		}
		
		if(xcdnoinfo.getOfficecode()!=null){
			tmp.setOfficecode(xcdnoinfo.getOfficecode());
			
			flag++;
		}
		
		if(xcdnoinfo.getCompanyname()!=null){
			tmp.setCompanyname(xcdnoinfo.getCompanyname());
			
			flag++;
		}
		
		if(xcdnoinfo.getAgentid()!=null){
			tmp.setAgentid(xcdnoinfo.getAgentid());
			
			flag++;
		}
		
		if(xcdnoinfo.getUserid()!=null){
			tmp.setUserid(xcdnoinfo.getUserid());
			
			flag++;
		}
		
		if(xcdnoinfo.getParam1()!=null){
			tmp.setParam1(xcdnoinfo.getParam1());
			
			flag++;
		}
		
		if(xcdnoinfo.getParam2()!=null){
			tmp.setParam2(xcdnoinfo.getParam2());
			
			flag++;
		}
		
		if(xcdnoinfo.getParam3()!=null){
			tmp.setParam3(xcdnoinfo.getParam3());
			
			flag++;
		}
		
		if(xcdnoinfo.getCreatetime()!=null){
			tmp.setCreatetime(xcdnoinfo.getCreatetime());
			
			flag++;
		}
		
		if(xcdnoinfo.getState()!=null){
			tmp.setState(xcdnoinfo.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateXcdnoinfo",tmp);
		}
	}
	
	/**
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllXcdnoinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程单号码
	 * @param id
	 * @return
	 */
	public Xcdnoinfo findXcdnoinfo(long id){
		return (Xcdnoinfo)(getSqlMapClientTemplate().queryForObject("findXcdnoinfo",id));
	}
	
	/** 
	 * 查找 行程单号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdnoinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdnoinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllXcdnoinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程单号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdnoinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllXcdnoinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程单号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdnoinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteXcdnoinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdnoinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdnoinfoBySql",map).toString()));
	}
}

