/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.informationinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InformationinfoManager extends  SqlMapClientDaoSupport  implements IInformationinfoManager{ 
	
  
 	/**
	 * 创建 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Informationinfo createInformationinfo(Informationinfo informationinfo) throws SQLException{
	
		if(informationinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		informationinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INFORMATIONINFO"));
		getSqlMapClientTemplate().insert("createInformationinfo",informationinfo);
		return informationinfo;
	}
	/**
	 * 删除 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformationinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteInformationinfo", id);
	}
	
	
	/**
	 * 修改 资讯中心详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInformationinfo(Informationinfo informationinfo){
		return getSqlMapClientTemplate().update("updateInformationinfo",informationinfo);
	
	}

		
	/**
	 * 修改 资讯中心详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationinfoIgnoreNull(Informationinfo informationinfo){
		Informationinfo tmp = findInformationinfo(informationinfo.getId());
		int flag =0;
		
		
		if(informationinfo.getName()!=null){
			tmp.setName(informationinfo.getName());
			
			flag++;
		}
		
		if(informationinfo.getInfo()!=null){
			tmp.setInfo(informationinfo.getInfo());
			
			flag++;
		}
		
		if(informationinfo.getTypeid()!=null){
			tmp.setTypeid(informationinfo.getTypeid());
			
			flag++;
		}
		if(informationinfo.getIsanswer()!=null){
			tmp.setIsanswer(informationinfo.getIsanswer());
			
			flag++;
		}
		if(informationinfo.getIsweb()!=null){
			tmp.setIsweb(informationinfo.getIsweb());
			
			flag++;
		}
		if(informationinfo.getCreatetime()!=null){
			tmp.setCreatetime(informationinfo.getCreatetime());
			
			flag++;
		}
		
		if(informationinfo.getMemberid()!=null){
			tmp.setMemberid(informationinfo.getMemberid());
			
			flag++;
		}
		
		if(informationinfo.getState()!=null){
			tmp.setState(informationinfo.getState());
			
			flag++;
		}
		
		if(informationinfo.getImage()!=null){
			tmp.setImage(informationinfo.getImage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInformationinfo",tmp);
		}
	}
	
	/**
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInformationinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 资讯中心详细信息
	 * @param id
	 * @return
	 */
	public Informationinfo findInformationinfo(long id){
		return (Informationinfo)(getSqlMapClientTemplate().queryForObject("findInformationinfo",id));
	}
	
	/** 
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformationinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInformationinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInformationinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找资讯中心详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInformationinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 资讯中心详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInformationinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInformationinfoBySql",map).toString()));
	}
}

