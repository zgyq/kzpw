/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.infocontent;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InfocontentManager extends  SqlMapClientDaoSupport  implements IInfocontentManager{ 
	
  
 	/**
	 * 创建 信息
	 * @param id
	 * @return deleted count 
	 */
	public Infocontent createInfocontent(Infocontent infocontent) throws SQLException{
	
		if(infocontent.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		infocontent.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INFOCONTENT"));
		getSqlMapClientTemplate().insert("createInfocontent",infocontent);
		return infocontent;
	}
	/**
	 * 删除 信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfocontent(long id){
	
		return getSqlMapClientTemplate().delete("deleteInfocontent", id);
	}
	
	
	/**
	 * 修改 信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInfocontent(Infocontent infocontent){
		return getSqlMapClientTemplate().update("updateInfocontent",infocontent);
	
	}

		
	/**
	 * 修改 信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfocontentIgnoreNull(Infocontent infocontent){
		Infocontent tmp = findInfocontent(infocontent.getId());
		int flag =0;
		
		
		if(infocontent.getTitle()!=null){
			tmp.setTitle(infocontent.getTitle());
			
			flag++;
		}
		
		if(infocontent.getContent()!=null){
			tmp.setContent(infocontent.getContent());
			
			flag++;
		}
		
		if(infocontent.getTypeid()!=null){
			tmp.setTypeid(infocontent.getTypeid());
			
			flag++;
		}
		
		if(infocontent.getCreateuser()!=null){
			tmp.setCreateuser(infocontent.getCreateuser());
			
			flag++;
		}
		
		if(infocontent.getCreatetime()!=null){
			tmp.setCreatetime(infocontent.getCreatetime());
			
			flag++;
		}
		
		if(infocontent.getModifyuser()!=null){
			tmp.setModifyuser(infocontent.getModifyuser());
			
			flag++;
		}
		
		if(infocontent.getModifytime()!=null){
			tmp.setModifytime(infocontent.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInfocontent",tmp);
		}
	}
	
	/**
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInfocontent",map, offset, limit);
	}
		
	
	/**
	 * 查找 信息
	 * @param id
	 * @return
	 */
	public Infocontent findInfocontent(long id){
		return (Infocontent)(getSqlMapClientTemplate().queryForObject("findInfocontent",id));
	}
	
	/** 
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInfocontentBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInfocontent",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInfocontentBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfocontentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInfocontentBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfocontentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInfocontentBySql",map).toString()));
	}
}

