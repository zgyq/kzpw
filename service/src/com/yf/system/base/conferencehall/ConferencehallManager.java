/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.conferencehall;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ConferencehallManager extends  SqlMapClientDaoSupport  implements IConferencehallManager{ 
	
  
 	/**
	 * 创建 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehall createConferencehall(Conferencehall conferencehall) throws SQLException{
	
		if(conferencehall.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		conferencehall.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CONFERENCEHALL"));
		getSqlMapClientTemplate().insert("createConferencehall",conferencehall);
		if(conferencehall.getUcode()==null||conferencehall.getUcode()<1)
		{
			conferencehall.setUcode(conferencehall.getId());
			updateConferencehallIgnoreNull(conferencehall);
		}
		return conferencehall;
	}
	/**
	 * 删除 会议厅
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehall(long id){
	
		return getSqlMapClientTemplate().delete("deleteConferencehall", id);
	}
	
	
	/**
	 * 修改 会议厅
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehall(Conferencehall conferencehall){
		return getSqlMapClientTemplate().update("updateConferencehall",conferencehall);
	
	}

		
	/**
	 * 修改 会议厅但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehallIgnoreNull(Conferencehall conferencehall){
		Conferencehall tmp = findConferencehall(conferencehall.getId());
		int flag =0;
		
		
		if(conferencehall.getType()!=null){
			tmp.setType(conferencehall.getType());
			
			flag++;
		}
		
		if(conferencehall.getArea()!=null){
			tmp.setArea(conferencehall.getArea());
			
			flag++;
		}
		
		if(conferencehall.getPepnum()!=null){
			tmp.setPepnum(conferencehall.getPepnum());
			
			flag++;
		}
		
		if(conferencehall.getUseof()!=null){
			tmp.setUseof(conferencehall.getUseof());
			
			flag++;
		}
		
		if(conferencehall.getDesc()!=null){
			tmp.setDesc(conferencehall.getDesc());
			
			flag++;
		}
		
		if(conferencehall.getHotelid()!=null){
			tmp.setHotelid(conferencehall.getHotelid());
			
			flag++;
		}
		
		if(conferencehall.getCreatetime()!=null){
			tmp.setCreatetime(conferencehall.getCreatetime());
			
			flag++;
		}
		
		if(conferencehall.getCreateuser()!=null){
			tmp.setCreateuser(conferencehall.getCreateuser());
			
			flag++;
		}
		
		if(conferencehall.getModifytime()!=null){
			tmp.setModifytime(conferencehall.getModifytime());
			
			flag++;
		}
		
		if(conferencehall.getModifyuser()!=null){
			tmp.setModifyuser(conferencehall.getModifyuser());
			
			flag++;
		}
		
		if(conferencehall.getUcode()!=null){
			tmp.setUcode(conferencehall.getUcode());
			
			flag++;
		}
		
		if(conferencehall.getLanguage()!=null){
			tmp.setLanguage(conferencehall.getLanguage());
			
			flag++;
		}
		
		if(conferencehall.getPic()!=null){
			tmp.setPic(conferencehall.getPic());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateConferencehall",tmp);
		}
	}
	
	/**
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Conferencehall.COL_language+" = 0 OR "+Conferencehall.COL_language+" is NULL)";
		}
		else if(where.indexOf(Conferencehall.COL_language)<0)
		{
			where+=" and ("+Conferencehall.COL_language+" = 0 OR "+Conferencehall.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllConferencehall",map, offset, limit);
	}
		
	
	/**
	 * 查找 会议厅
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehall(long id){
		return (Conferencehall)(getSqlMapClientTemplate().queryForObject("findConferencehall",id));
	}
	/**
	 * 查找 会议厅 by language
	 * @param id
	 * @return
	 */
	public Conferencehall findConferencehallbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Conferencehall.COL_ucode+" = "+id+" and "+Conferencehall.COL_language+" = "+language;	
		List list=findAllConferencehall(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Conferencehall)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 会议厅
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehall(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Conferencehall.COL_language+" = 0";
		}
		else if(where.indexOf(Conferencehall.COL_language)<0)
		{
			where+=" and "+Conferencehall.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countConferencehallBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllConferencehall",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会议厅
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehall(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllConferencehallBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会议厅
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehallBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteConferencehallBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehallBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countConferencehallBySql",map).toString()));
	}
}

