/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotellinkman;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotellinkmanManager extends  SqlMapClientDaoSupport  implements IHotellinkmanManager{ 
	
  
 	/**
	 * 创建 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public Hotellinkman createHotellinkman(Hotellinkman hotellinkman) throws SQLException{
	
		if(hotellinkman.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotellinkman.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELLINKMAN"));
		getSqlMapClientTemplate().insert("createHotellinkman",hotellinkman);
		if(hotellinkman.getUcode()==null||hotellinkman.getUcode()<1)
		{
			hotellinkman.setUcode(hotellinkman.getId());
			updateHotellinkmanIgnoreNull(hotellinkman);
		}
		return hotellinkman;
	}
	/**
	 * 删除 酒店联系人
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotellinkman(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotellinkman", id);
	}
	
	
	/**
	 * 修改 酒店联系人
	 * @param id
	 * @return updated count 
	 */
	public int updateHotellinkman(Hotellinkman hotellinkman){
		return getSqlMapClientTemplate().update("updateHotellinkman",hotellinkman);
	
	}

		
	/**
	 * 修改 酒店联系人但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotellinkmanIgnoreNull(Hotellinkman hotellinkman){
		Hotellinkman tmp = findHotellinkman(hotellinkman.getId());
		int flag =0;
		
		
		if(hotellinkman.getName()!=null){
			tmp.setName(hotellinkman.getName());
			
			flag++;
		}
		
		if(hotellinkman.getSex()!=null){
			tmp.setSex(hotellinkman.getSex());
			
			flag++;
		}
		
		if(hotellinkman.getDuty()!=null){
			tmp.setDuty(hotellinkman.getDuty());
			
			flag++;
		}
		
		if(hotellinkman.getTell()!=null){
			tmp.setTell(hotellinkman.getTell());
			
			flag++;
		}
		
		if(hotellinkman.getMobil()!=null){
			tmp.setMobil(hotellinkman.getMobil());
			
			flag++;
		}
		
		if(hotellinkman.getFax()!=null){
			tmp.setFax(hotellinkman.getFax());
			
			flag++;
		}
		
		if(hotellinkman.getHotelid()!=null){
			tmp.setHotelid(hotellinkman.getHotelid());
			
			flag++;
		}
		
		if(hotellinkman.getCreatetime()!=null){
			tmp.setCreatetime(hotellinkman.getCreatetime());
			
			flag++;
		}
		
		if(hotellinkman.getCreateuser()!=null){
			tmp.setCreateuser(hotellinkman.getCreateuser());
			
			flag++;
		}
		
		if(hotellinkman.getModifyuser()!=null){
			tmp.setModifyuser(hotellinkman.getModifyuser());
			
			flag++;
		}
		
		if(hotellinkman.getModifytime()!=null){
			tmp.setModifytime(hotellinkman.getModifytime());
			
			flag++;
		}
		
		if(hotellinkman.getState()!=null){
			tmp.setState(hotellinkman.getState());
			
			flag++;
		}
		
		if(hotellinkman.getUcode()!=null){
			tmp.setUcode(hotellinkman.getUcode());
			
			flag++;
		}
		
		if(hotellinkman.getLanguage()!=null){
			tmp.setLanguage(hotellinkman.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotellinkman",tmp);
		}
	}
	
	/**
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Hotellinkman.COL_language+" = 0 OR "+Hotellinkman.COL_language+" is NULL)";
		}
		else if(where.indexOf(Hotellinkman.COL_language)<0)
		{
			where+=" and ("+Hotellinkman.COL_language+" = 0 OR "+Hotellinkman.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotellinkman",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店联系人
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkman(long id){
		return (Hotellinkman)(getSqlMapClientTemplate().queryForObject("findHotellinkman",id));
	}
	/**
	 * 查找 酒店联系人 by language
	 * @param id
	 * @return
	 */
	public Hotellinkman findHotellinkmanbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotellinkman.COL_ucode+" = "+id+" and "+Hotellinkman.COL_language+" = "+language;	
		List list=findAllHotellinkman(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotellinkman)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店联系人
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotellinkman(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Hotellinkman.COL_language+" = 0";
		}
		else if(where.indexOf(Hotellinkman.COL_language)<0)
		{
			where+=" and "+Hotellinkman.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotellinkmanBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotellinkman",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店联系人
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotellinkman(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotellinkmanBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店联系人
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotellinkmanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotellinkmanBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotellinkmanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotellinkmanBySql",map).toString()));
	}
}

