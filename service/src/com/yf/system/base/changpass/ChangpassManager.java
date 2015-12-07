/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.changpass;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ChangpassManager extends  SqlMapClientDaoSupport  implements IChangpassManager{ 
	
  
 	/**
	 * 创建 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public Changpass createChangpass(Changpass changpass) throws SQLException{
	
		if(changpass.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		changpass.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CHANGPASS"));
		getSqlMapClientTemplate().insert("createChangpass",changpass);
		return changpass;
	}
	/**
	 * 删除 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChangpass(long id){
	
		return getSqlMapClientTemplate().delete("deleteChangpass", id);
	}
	
	
	/**
	 * 修改 变更记录
	 * @param id
	 * @return updated count 
	 */
	public int updateChangpass(Changpass changpass){
		return getSqlMapClientTemplate().update("updateChangpass",changpass);
	
	}

		
	/**
	 * 修改 变更记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChangpassIgnoreNull(Changpass changpass){
		Changpass tmp = findChangpass(changpass.getId());
		int flag =0;
		
		
		if(changpass.getOrderid()!=null){
			tmp.setOrderid(changpass.getOrderid());
			
			flag++;
		}
		
		if(changpass.getUserid()!=null){
			tmp.setUserid(changpass.getUserid());
			
			flag++;
		}
		
		if(changpass.getPassids()!=null){
			tmp.setPassids(changpass.getPassids());
			
			flag++;
		}
		
		if(changpass.getAgentid()!=null){
			tmp.setAgentid(changpass.getAgentid());
			
			flag++;
		}
		
		if(changpass.getDescinfo()!=null){
			tmp.setDescinfo(changpass.getDescinfo());
			
			flag++;
		}
		
		if(changpass.getCreateuser()!=null){
			tmp.setCreateuser(changpass.getCreateuser());
			
			flag++;
		}
		
		if(changpass.getCreatetime()!=null){
			tmp.setCreatetime(changpass.getCreatetime());
			
			flag++;
		}
		
		if(changpass.getModifyuser()!=null){
			tmp.setModifyuser(changpass.getModifyuser());
			
			flag++;
		}
		
		if(changpass.getModifytime()!=null){
			tmp.setModifytime(changpass.getModifytime());
			
			flag++;
		}
		
		if(changpass.getStatus()!=null){
			tmp.setStatus(changpass.getStatus());
			
			flag++;
		}
		
		if(changpass.getType()!=null){
			tmp.setType(changpass.getType());
			
			flag++;
		}
		
		if(changpass.getOrdernum()!=null){
			tmp.setOrdernum(changpass.getOrdernum());
			
			flag++;
		}
		
		if(changpass.getPayurl()!=null){
			tmp.setPayurl(changpass.getPayurl());
			
			flag++;
		}
		
		if(changpass.getRettype()!=null){
			tmp.setRettype(changpass.getRettype());
			
			flag++;
		}
		
		if(changpass.getName()!=null){
			tmp.setName(changpass.getName());
			
			flag++;
		}
		
		if(changpass.getIdnum()!=null){
			tmp.setIdnum(changpass.getIdnum());
			
			flag++;
		}
		
		if(changpass.getIdtype()!=null){
			tmp.setIdtype(changpass.getIdtype());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateChangpass",tmp);
		}
	}
	
	/**
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllChangpass",map, offset, limit);
	}
		
	
	/**
	 * 查找 变更记录
	 * @param id
	 * @return
	 */
	public Changpass findChangpass(long id){
		return (Changpass)(getSqlMapClientTemplate().queryForObject("findChangpass",id));
	}
	
	/** 
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countChangpassBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllChangpass",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找变更记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllChangpassBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 变更记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChangpassBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteChangpassBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChangpassBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countChangpassBySql",map).toString()));
	}
}

