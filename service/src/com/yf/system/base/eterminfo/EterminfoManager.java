/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.eterminfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class EterminfoManager extends  SqlMapClientDaoSupport  implements IEterminfoManager{ 
	
  
 	/**
	 * 创建 配置表
	 * @param id
	 * @return deleted count 
	 */
	public Eterminfo createEterminfo(Eterminfo eterminfo) throws SQLException{
	
		if(eterminfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		eterminfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ETERMINFO"));
		getSqlMapClientTemplate().insert("createEterminfo",eterminfo);
		return eterminfo;
	}
	/**
	 * 删除 配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteEterminfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteEterminfo", id);
	}
	
	
	/**
	 * 修改 配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateEterminfo(Eterminfo eterminfo){
		return getSqlMapClientTemplate().update("updateEterminfo",eterminfo);
	
	}

		
	/**
	 * 修改 配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateEterminfoIgnoreNull(Eterminfo eterminfo){
		Eterminfo tmp = findEterminfo(eterminfo.getId());
		int flag =0;
		
		
		if(eterminfo.getEtermtype()!=null){
			tmp.setEtermtype(eterminfo.getEtermtype());
			
			flag++;
		}
		
		if(eterminfo.getEtermaccount()!=null){
			tmp.setEtermaccount(eterminfo.getEtermaccount());
			
			flag++;
		}
		
		if(eterminfo.getPassword()!=null){
			tmp.setPassword(eterminfo.getPassword());
			
			flag++;
		}
		
		if(eterminfo.getServerip()!=null){
			tmp.setServerip(eterminfo.getServerip());
			
			flag++;
		}
		
		if(eterminfo.getPortnum()!=null){
			tmp.setPortnum(eterminfo.getPortnum());
			
			flag++;
		}
		
		if(eterminfo.getSinum()!=null){
			tmp.setSinum(eterminfo.getSinum());
			
			flag++;
		}
		
		if(eterminfo.getPrintnum()!=null){
			tmp.setPrintnum(eterminfo.getPrintnum());
			
			flag++;
		}
		
		if(eterminfo.getAgentid()!=null){
			tmp.setAgentid(eterminfo.getAgentid());
			
			flag++;
		}
		
		if(eterminfo.getStatus()!=null){
			tmp.setStatus(eterminfo.getStatus());
			
			flag++;
		}
		
		if(eterminfo.getCreateuser()!=null){
			tmp.setCreateuser(eterminfo.getCreateuser());
			
			flag++;
		}
		
		if(eterminfo.getCreatetime()!=null){
			tmp.setCreatetime(eterminfo.getCreatetime());
			
			flag++;
		}
		
		if(eterminfo.getModifyuser()!=null){
			tmp.setModifyuser(eterminfo.getModifyuser());
			
			flag++;
		}
		
		if(eterminfo.getModifytime()!=null){
			tmp.setModifytime(eterminfo.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateEterminfo",tmp);
		}
	}
	
	/**
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllEterminfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 配置表
	 * @param id
	 * @return
	 */
	public Eterminfo findEterminfo(long id){
		return (Eterminfo)(getSqlMapClientTemplate().queryForObject("findEterminfo",id));
	}
	
	/** 
	 * 查找 配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllEterminfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countEterminfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllEterminfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllEterminfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllEterminfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteEterminfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteEterminfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countEterminfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countEterminfoBySql",map).toString()));
	}
}

