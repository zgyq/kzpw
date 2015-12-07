/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.filecabindir;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FilecabindirManager extends  SqlMapClientDaoSupport  implements IFilecabindirManager{ 
	
  
 	/**
	 * 创建 文件柜目录
	 * @param id
	 * @return deleted count 
	 */
	public Filecabindir createFilecabindir(Filecabindir filecabindir) throws SQLException{
	
		if(filecabindir.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		filecabindir.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FILECABINDIR"));
		getSqlMapClientTemplate().insert("createFilecabindir",filecabindir);
		return filecabindir;
	}
	/**
	 * 删除 文件柜目录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFilecabindir(long id){
	
		return getSqlMapClientTemplate().delete("deleteFilecabindir", id);
	}
	
	
	/**
	 * 修改 文件柜目录
	 * @param id
	 * @return updated count 
	 */
	public int updateFilecabindir(Filecabindir filecabindir){
		return getSqlMapClientTemplate().update("updateFilecabindir",filecabindir);
	
	}

		
	/**
	 * 修改 文件柜目录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFilecabindirIgnoreNull(Filecabindir filecabindir){
		Filecabindir tmp = findFilecabindir(filecabindir.getId());
		int flag =0;
		
		
		if(filecabindir.getName()!=null){
			tmp.setName(filecabindir.getName());
			
			flag++;
		}
		
		if(filecabindir.getParentid()!=null){
			tmp.setParentid(filecabindir.getParentid());
			
			flag++;
		}
		
		if(filecabindir.getParentidstr()!=null){
			tmp.setParentidstr(filecabindir.getParentidstr());
			
			flag++;
		}
		
		if(filecabindir.getDescrition()!=null){
			tmp.setDescrition(filecabindir.getDescrition());
			
			flag++;
		}
		
		if(filecabindir.getCreateuser()!=null){
			tmp.setCreateuser(filecabindir.getCreateuser());
			
			flag++;
		}
		
		if(filecabindir.getCreatetime()!=null){
			tmp.setCreatetime(filecabindir.getCreatetime());
			
			flag++;
		}
		
		if(filecabindir.getModifyuser()!=null){
			tmp.setModifyuser(filecabindir.getModifyuser());
			
			flag++;
		}
		
		if(filecabindir.getModifytime()!=null){
			tmp.setModifytime(filecabindir.getModifytime());
			
			flag++;
		}
		
		if(filecabindir.getRight()!=null){
			tmp.setRight(filecabindir.getRight());
			
			flag++;
		}
		
		if(filecabindir.getCreateid()!=null){
			tmp.setCreateid(filecabindir.getCreateid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFilecabindir",tmp);
		}
	}
	
	/**
	 * 查找 文件柜目录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabindir(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFilecabindir",map, offset, limit);
	}
		
	
	/**
	 * 查找 文件柜目录
	 * @param id
	 * @return
	 */
	public Filecabindir findFilecabindir(long id){
		return (Filecabindir)(getSqlMapClientTemplate().queryForObject("findFilecabindir",id));
	}
	
	/** 
	 * 查找 文件柜目录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFilecabindir(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFilecabindirBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFilecabindir",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找文件柜目录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabindir(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFilecabindirBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 文件柜目录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFilecabindirBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFilecabindirBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFilecabindirBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFilecabindirBySql",map).toString()));
	}
}

