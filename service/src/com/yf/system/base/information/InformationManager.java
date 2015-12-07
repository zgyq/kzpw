/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.information;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InformationManager extends  SqlMapClientDaoSupport  implements IInformationManager{ 
	
  
 	/**
	 * 创建 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public Information createInformation(Information information) throws SQLException{
	
		if(information.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		information.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INFORMATION"));
		getSqlMapClientTemplate().insert("createInformation",information);
		return information;
	}
	/**
	 * 删除 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformation(long id){
	
		return getSqlMapClientTemplate().delete("deleteInformation", id);
	}
	
	
	/**
	 * 修改 资讯中心
	 * @param id
	 * @return updated count 
	 */
	public int updateInformation(Information information){
		return getSqlMapClientTemplate().update("updateInformation",information);
	
	}

		
	/**
	 * 修改 资讯中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationIgnoreNull(Information information){
		Information tmp = findInformation(information.getId());
		int flag =0;
		
		
		if(information.getName()!=null){
			tmp.setName(information.getName());
			
			flag++;
		}
		
		if(information.getIsweb()!=null){
			tmp.setIsweb(information.getIsweb());
			
			flag++;
		}
		
		if(information.getCreatetime()!=null){
			tmp.setCreatetime(information.getCreatetime());
			
			flag++;
		}
		
		if(information.getMemberid()!=null){
			tmp.setMemberid(information.getMemberid());
			
			flag++;
		}
		
		if(information.getState()!=null){
			tmp.setState(information.getState());
			
			flag++;
		}
		
		if(information.getParentid()!=null){
			tmp.setParentid(information.getParentid());
			
			flag++;
		}
		
		if(information.getParentstr()!=null){
			tmp.setParentstr(information.getParentstr());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInformation",tmp);
		}
	}
	
	/**
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInformation",map, offset, limit);
	}
		
	
	/**
	 * 查找 资讯中心
	 * @param id
	 * @return
	 */
	public Information findInformation(long id){
		return (Information)(getSqlMapClientTemplate().queryForObject("findInformation",id));
	}
	
	/** 
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformation(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInformationBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInformation",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找资讯中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInformationBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 资讯中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInformationBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInformationBySql",map).toString()));
	}
}

