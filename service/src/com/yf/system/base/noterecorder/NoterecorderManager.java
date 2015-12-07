/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.noterecorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class NoterecorderManager extends  SqlMapClientDaoSupport  implements INoterecorderManager{ 
	
  
 	/**
	 * 创建 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public Noterecorder createNoterecorder(Noterecorder noterecorder) throws SQLException{
	
		if(noterecorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		noterecorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_NOTERECORDER"));
		getSqlMapClientTemplate().insert("createNoterecorder",noterecorder);
		if(noterecorder.getUcode()==null||noterecorder.getUcode()<1)
		{
			noterecorder.setUcode(noterecorder.getId());
			updateNoterecorderIgnoreNull(noterecorder);
		}
		return noterecorder;
	}
	/**
	 * 删除 通知记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteNoterecorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteNoterecorder", id);
	}
	
	
	/**
	 * 修改 通知记录
	 * @param id
	 * @return updated count 
	 */
	public int updateNoterecorder(Noterecorder noterecorder){
		return getSqlMapClientTemplate().update("updateNoterecorder",noterecorder);
	
	}

		
	/**
	 * 修改 通知记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateNoterecorderIgnoreNull(Noterecorder noterecorder){
		Noterecorder tmp = findNoterecorder(noterecorder.getId());
		int flag =0;
		
		
		if(noterecorder.getCreateuser()!=null){
			tmp.setCreateuser(noterecorder.getCreateuser());
			
			flag++;
		}
		
		if(noterecorder.getCreatetime()!=null){
			tmp.setCreatetime(noterecorder.getCreatetime());
			
			flag++;
		}
		
		if(noterecorder.getModifyuser()!=null){
			tmp.setModifyuser(noterecorder.getModifyuser());
			
			flag++;
		}
		
		if(noterecorder.getModifytime()!=null){
			tmp.setModifytime(noterecorder.getModifytime());
			
			flag++;
		}
		
		if(noterecorder.getSender()!=null){
			tmp.setSender(noterecorder.getSender());
			
			flag++;
		}
		
		if(noterecorder.getReciver()!=null){
			tmp.setReciver(noterecorder.getReciver());
			
			flag++;
		}
		
		if(noterecorder.getType()!=null){
			tmp.setType(noterecorder.getType());
			
			flag++;
		}
		
		if(noterecorder.getState()!=null){
			tmp.setState(noterecorder.getState());
			
			flag++;
		}
		
		if(noterecorder.getContent()!=null){
			tmp.setContent(noterecorder.getContent());
			
			flag++;
		}
		
		if(noterecorder.getTitle()!=null){
			tmp.setTitle(noterecorder.getTitle());
			
			flag++;
		}
		
		if(noterecorder.getTemplateid()!=null){
			tmp.setTemplateid(noterecorder.getTemplateid());
			
			flag++;
		}
		
		if(noterecorder.getUcode()!=null){
			tmp.setUcode(noterecorder.getUcode());
			
			flag++;
		}
		
		if(noterecorder.getLanguage()!=null){
			tmp.setLanguage(noterecorder.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateNoterecorder",tmp);
		}
	}
	
	/**
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorder(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Noterecorder.COL_language+" = 0 OR "+Noterecorder.COL_language+" is NULL)";
		}
		else if(where.indexOf(Noterecorder.COL_language)<0)
		{
			where+=" and ("+Noterecorder.COL_language+" = 0 OR "+Noterecorder.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllNoterecorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 通知记录
	 * @param id
	 * @return
	 */
	public Noterecorder findNoterecorder(long id){
		return (Noterecorder)(getSqlMapClientTemplate().queryForObject("findNoterecorder",id));
	}
	/**
	 * 查找 通知记录 by language
	 * @param id
	 * @return
	 */
	public Noterecorder findNoterecorderbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Noterecorder.COL_ucode+" = "+id+" and "+Noterecorder.COL_language+" = "+language;	
		List list=findAllNoterecorder(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Noterecorder)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 通知记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllNoterecorder(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Noterecorder.COL_language+" = 0";
		}
		else if(where.indexOf(Noterecorder.COL_language)<0)
		{
			where+=" and "+Noterecorder.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countNoterecorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllNoterecorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找通知记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllNoterecorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllNoterecorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 通知记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteNoterecorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteNoterecorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countNoterecorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countNoterecorderBySql",map).toString()));
	}
}

