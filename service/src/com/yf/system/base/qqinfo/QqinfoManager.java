/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qqinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QqinfoManager extends  SqlMapClientDaoSupport  implements IQqinfoManager{ 
	
  
 	/**
	 * 创建 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfo createQqinfo(Qqinfo qqinfo) throws SQLException{
	
		if(qqinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qqinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QQINFO"));
		getSqlMapClientTemplate().insert("createQqinfo",qqinfo);
		return qqinfo;
	}
	/**
	 * 删除 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteQqinfo", id);
	}
	
	
	/**
	 * 修改 QQ信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfo(Qqinfo qqinfo){
		return getSqlMapClientTemplate().update("updateQqinfo",qqinfo);
	
	}

		
	/**
	 * 修改 QQ信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfoIgnoreNull(Qqinfo qqinfo){
		Qqinfo tmp = findQqinfo(qqinfo.getId());
		int flag =0;
		
		
		if(qqinfo.getQqnumber()!=null){
			tmp.setQqnumber(qqinfo.getQqnumber());
			
			flag++;
		}
		
		if(qqinfo.getQqtype()!=null){
			tmp.setQqtype(qqinfo.getQqtype());
			
			flag++;
		}
		
		if(qqinfo.getQqnumberindex()!=null){
			tmp.setQqnumberindex(qqinfo.getQqnumberindex());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQqinfo",tmp);
		}
	}
	
	/**
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQqinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 QQ信息表
	 * @param id
	 * @return
	 */
	public Qqinfo findQqinfo(long id){
		return (Qqinfo)(getSqlMapClientTemplate().queryForObject("findQqinfo",id));
	}
	
	/** 
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQqinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找QQ信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQqinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql QQ信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQqinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQqinfoBySql",map).toString()));
	}
}

