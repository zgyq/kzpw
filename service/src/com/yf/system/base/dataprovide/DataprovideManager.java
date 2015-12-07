/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dataprovide;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class DataprovideManager extends  SqlMapClientDaoSupport  implements IDataprovideManager{ 
	
  
 	/**
	 * 创建 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public Dataprovide createDataprovide(Dataprovide dataprovide) throws SQLException{
	
		if(dataprovide.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		dataprovide.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_DATAPROVIDE"));
		getSqlMapClientTemplate().insert("createDataprovide",dataprovide);
		return dataprovide;
	}
	/**
	 * 删除 酒店数据提供商
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDataprovide(long id){
	
		return getSqlMapClientTemplate().delete("deleteDataprovide", id);
	}
	
	
	/**
	 * 修改 酒店数据提供商
	 * @param id
	 * @return updated count 
	 */
	public int updateDataprovide(Dataprovide dataprovide){
		return getSqlMapClientTemplate().update("updateDataprovide",dataprovide);
	
	}

		
	/**
	 * 修改 酒店数据提供商但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDataprovideIgnoreNull(Dataprovide dataprovide){
		Dataprovide tmp = findDataprovide(dataprovide.getId());
		int flag =0;
		
		
		if(dataprovide.getDataprovidecode()!=null){
			tmp.setDataprovidecode(dataprovide.getDataprovidecode());
			
			flag++;
		}
		
		if(dataprovide.getDataprovidename()!=null){
			tmp.setDataprovidename(dataprovide.getDataprovidename());
			
			flag++;
		}
		
		if(dataprovide.getDataproviceename()!=null){
			tmp.setDataproviceename(dataprovide.getDataproviceename());
			
			flag++;
		}
		
		if(dataprovide.getDataprovicecname()!=null){
			tmp.setDataprovicecname(dataprovide.getDataprovicecname());
			
			flag++;
		}
		
		if(dataprovide.getLinkmanname()!=null){
			tmp.setLinkmanname(dataprovide.getLinkmanname());
			
			flag++;
		}
		
		if(dataprovide.getLinkmanphone()!=null){
			tmp.setLinkmanphone(dataprovide.getLinkmanphone());
			
			flag++;
		}
		
		if(dataprovide.getUsername()!=null){
			tmp.setUsername(dataprovide.getUsername());
			
			flag++;
		}
		
		if(dataprovide.getPassword()!=null){
			tmp.setPassword(dataprovide.getPassword());
			
			flag++;
		}
		
		if(dataprovide.getCreatetime()!=null){
			tmp.setCreatetime(dataprovide.getCreatetime());
			
			flag++;
		}
		
		if(dataprovide.getCreatemanid()!=null){
			tmp.setCreatemanid(dataprovide.getCreatemanid());
			
			flag++;
		}
		
		if(dataprovide.getState()!=null){
			tmp.setState(dataprovide.getState());
			
			flag++;
		}
		
		if(dataprovide.getRemark()!=null){
			tmp.setRemark(dataprovide.getRemark());
			
			flag++;
		}
		
		if(dataprovide.getParam1()!=null){
			tmp.setParam1(dataprovide.getParam1());
			
			flag++;
		}
		
		if(dataprovide.getParam2()!=null){
			tmp.setParam2(dataprovide.getParam2());
			
			flag++;
		}
		
		if(dataprovide.getParam3()!=null){
			tmp.setParam3(dataprovide.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateDataprovide",tmp);
		}
	}
	
	/**
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovide(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllDataprovide",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店数据提供商
	 * @param id
	 * @return
	 */
	public Dataprovide findDataprovide(long id){
		return (Dataprovide)(getSqlMapClientTemplate().queryForObject("findDataprovide",id));
	}
	
	/** 
	 * 查找 酒店数据提供商
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDataprovide(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDataprovideBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllDataprovide",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店数据提供商
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDataprovide(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllDataprovideBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店数据提供商
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDataprovideBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteDataprovideBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDataprovideBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDataprovideBySql",map).toString()));
	}
}

