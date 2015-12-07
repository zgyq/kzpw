/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.filecabinfile;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FilecabinfileManager extends  SqlMapClientDaoSupport  implements IFilecabinfileManager{ 
	
  
 	/**
	 * 创建 文件
	 * @param id
	 * @return deleted count 
	 */
	public Filecabinfile createFilecabinfile(Filecabinfile filecabinfile) throws SQLException{
	
		if(filecabinfile.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		filecabinfile.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "C_FILECABINFILE"));
		getSqlMapClientTemplate().insert("createFilecabinfile",filecabinfile);
		return filecabinfile;
	}
	/**
	 * 删除 文件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFilecabinfile(long id){
	
		return getSqlMapClientTemplate().delete("deleteFilecabinfile", id);
	}
	
	
	/**
	 * 修改 文件
	 * @param id
	 * @return updated count 
	 */
	public int updateFilecabinfile(Filecabinfile filecabinfile){
		return getSqlMapClientTemplate().update("updateFilecabinfile",filecabinfile);
	
	}

		
	/**
	 * 修改 文件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFilecabinfileIgnoreNull(Filecabinfile filecabinfile){
		Filecabinfile tmp = findFilecabinfile(filecabinfile.getId());
		int flag =0;
		
		
		if(filecabinfile.getName()!=null){
			tmp.setName(filecabinfile.getName());
			
			flag++;
		}
		
		if(filecabinfile.getFilecabindir()!=null){
			tmp.setFilecabindir(filecabinfile.getFilecabindir());
			
			flag++;
		}
		
		if(filecabinfile.getDescrition()!=null){
			tmp.setDescrition(filecabinfile.getDescrition());
			
			flag++;
		}
		
		if(filecabinfile.getCreateuser()!=null){
			tmp.setCreateuser(filecabinfile.getCreateuser());
			
			flag++;
		}
		
		if(filecabinfile.getCreatetime()!=null){
			tmp.setCreatetime(filecabinfile.getCreatetime());
			
			flag++;
		}
		
		if(filecabinfile.getModifyuser()!=null){
			tmp.setModifyuser(filecabinfile.getModifyuser());
			
			flag++;
		}
		
		if(filecabinfile.getModifytime()!=null){
			tmp.setModifytime(filecabinfile.getModifytime());
			
			flag++;
		}
		
		if(filecabinfile.getRight()!=null){
			tmp.setRight(filecabinfile.getRight());
			
			flag++;
		}
		
		if(filecabinfile.getFilepath()!=null){
			tmp.setFilepath(filecabinfile.getFilepath());
			
			flag++;
		}
		
		if(filecabinfile.getFilesize()!=null){
			tmp.setFilesize(filecabinfile.getFilesize());
			
			flag++;
		}
		
		if(filecabinfile.getCreateid()!=null){
			tmp.setCreateid(filecabinfile.getCreateid());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFilecabinfile",tmp);
		}
	}
	
	/**
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFilecabinfile",map, offset, limit);
	}
		
	
	/**
	 * 查找 文件
	 * @param id
	 * @return
	 */
	public Filecabinfile findFilecabinfile(long id){
		return (Filecabinfile)(getSqlMapClientTemplate().queryForObject("findFilecabinfile",id));
	}
	
	/** 
	 * 查找 文件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFilecabinfile(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFilecabinfileBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFilecabinfile",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找文件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFilecabinfile(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFilecabinfileBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 文件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFilecabinfileBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFilecabinfileBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFilecabinfileBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFilecabinfileBySql",map).toString()));
	}
}

