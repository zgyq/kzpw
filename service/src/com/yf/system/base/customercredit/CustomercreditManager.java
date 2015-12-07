/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customercredit;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomercreditManager extends  SqlMapClientDaoSupport  implements ICustomercreditManager{ 
	
  
 	/**
	 * 创建 证件
	 * @param id
	 * @return deleted count 
	 */
	public Customercredit createCustomercredit(Customercredit customercredit) throws SQLException{
	
		if(customercredit.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		customercredit.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERCREDIT"));
		getSqlMapClientTemplate().insert("createCustomercredit",customercredit);
		return customercredit;
	}
	/**
	 * 删除 证件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomercredit(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomercredit", id);
	}
	
	
	/**
	 * 修改 证件
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomercredit(Customercredit customercredit){
		return getSqlMapClientTemplate().update("updateCustomercredit",customercredit);
	
	}

		
	/**
	 * 修改 证件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomercreditIgnoreNull(Customercredit customercredit){
		Customercredit tmp = findCustomercredit(customercredit.getId());
		int flag =0;
		
		
		if(customercredit.getCredittypeid()!=null){
			tmp.setCredittypeid(customercredit.getCredittypeid());
			
			flag++;
		}
		
		if(customercredit.getCreditnumber()!=null){
			tmp.setCreditnumber(customercredit.getCreditnumber());
			
			flag++;
		}
		
		if(customercredit.getCreateuser()!=null){
			tmp.setCreateuser(customercredit.getCreateuser());
			
			flag++;
		}
		if(customercredit.getStaus()!=null){
			tmp.setStaus(customercredit.getStaus());
			
			flag++;
		}
		
		if(customercredit.getCreatetime()!=null){
			tmp.setCreatetime(customercredit.getCreatetime());
			
			flag++;
		}
		
		if(customercredit.getModifyuser()!=null){
			tmp.setModifyuser(customercredit.getModifyuser());
			
			flag++;
		}
		
		if(customercredit.getModifytime()!=null){
			tmp.setModifytime(customercredit.getModifytime());
			
			flag++;
		}
		
		if(customercredit.getType()!=null){
			tmp.setType(customercredit.getType());
			
			flag++;
		}
		
		if(customercredit.getRefid()!=null){
			tmp.setRefid(customercredit.getRefid());
			
			flag++;
		}
		
		if(customercredit.getPassportvalidity()!=null){
			tmp.setPassportvalidity(customercredit.getPassportvalidity());
			
			flag++;
		}
		
		if(customercredit.getNationality()!=null){
			tmp.setNationality(customercredit.getNationality());
			
			flag++;
		}
		
		if(customercredit.getIssuingauthority()!=null){
			tmp.setIssuingauthority(customercredit.getIssuingauthority());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomercredit",tmp);
		}
	}
	
	/**
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomercredit",map, offset, limit);
	}
		
	
	/**
	 * 查找 证件
	 * @param id
	 * @return
	 */
	public Customercredit findCustomercredit(long id){
		return (Customercredit)(getSqlMapClientTemplate().queryForObject("findCustomercredit",id));
	}
	
	/** 
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomercreditBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomercredit",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找证件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomercreditBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 证件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomercreditBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomercreditBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomercreditBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomercreditBySql",map).toString()));
	}
}

