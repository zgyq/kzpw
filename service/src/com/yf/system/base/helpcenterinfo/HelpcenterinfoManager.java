/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenterinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HelpcenterinfoManager extends  SqlMapClientDaoSupport  implements IHelpcenterinfoManager{ 
	
  
 	/**
	 * 创建 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenterinfo createHelpcenterinfo(Helpcenterinfo helpcenterinfo) throws SQLException{
	
		if(helpcenterinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		helpcenterinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HELPCENTERINFO"));
		getSqlMapClientTemplate().insert("createHelpcenterinfo",helpcenterinfo);
		return helpcenterinfo;
	}
	/**
	 * 删除 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenterinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteHelpcenterinfo", id);
	}
	
	
	/**
	 * 修改 帮助中心信息
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenterinfo(Helpcenterinfo helpcenterinfo){
		return getSqlMapClientTemplate().update("updateHelpcenterinfo",helpcenterinfo);
	
	}

		
	/**
	 * 修改 帮助中心信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterinfoIgnoreNull(Helpcenterinfo helpcenterinfo){
		Helpcenterinfo tmp = findHelpcenterinfo(helpcenterinfo.getId());
		int flag =0;
		
		
		if(helpcenterinfo.getName()!=null){
			tmp.setName(helpcenterinfo.getName());
			
			flag++;
		}
		
		if(helpcenterinfo.getInfo()!=null){
			tmp.setInfo(helpcenterinfo.getInfo());
			
			flag++;
		}
		
		if(helpcenterinfo.getTypeid()!=null){
			tmp.setTypeid(helpcenterinfo.getTypeid());
			
			flag++;
		}
		if(helpcenterinfo.getIsanswer()!=null){
			tmp.setIsanswer(helpcenterinfo.getIsanswer());
			
			flag++;
		}
		if(helpcenterinfo.getIsweb()!=null){
			tmp.setIsweb(helpcenterinfo.getIsweb());
			
			flag++;
		}
		
		if(helpcenterinfo.getCreatetime()!=null){
			tmp.setCreatetime(helpcenterinfo.getCreatetime());
			
			flag++;
		}
		
		if(helpcenterinfo.getMemberid()!=null){
			tmp.setMemberid(helpcenterinfo.getMemberid());
			
			flag++;
		}
		
		if(helpcenterinfo.getState()!=null){
			tmp.setState(helpcenterinfo.getState());
			
			flag++;
		}
		
		if(helpcenterinfo.getImage()!=null){
			tmp.setImage(helpcenterinfo.getImage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHelpcenterinfo",tmp);
		}
	}
	
	/**
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHelpcenterinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 帮助中心信息
	 * @param id
	 * @return
	 */
	public Helpcenterinfo findHelpcenterinfo(long id){
		return (Helpcenterinfo)(getSqlMapClientTemplate().queryForObject("findHelpcenterinfo",id));
	}
	
	/** 
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHelpcenterinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHelpcenterinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找帮助中心信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHelpcenterinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 帮助中心信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHelpcenterinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHelpcenterinfoBySql",map).toString()));
	}
}

