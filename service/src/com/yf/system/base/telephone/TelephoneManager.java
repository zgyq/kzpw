/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.telephone;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TelephoneManager extends  SqlMapClientDaoSupport  implements ITelephoneManager{ 
	
  
 	/**
	 * 创建 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public Telephone createTelephone(Telephone telephone) throws SQLException{
	
		if(telephone.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		telephone.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TELEPHONE"));
		getSqlMapClientTemplate().insert("createTelephone",telephone);
		return telephone;
	}
	/**
	 * 删除 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTelephone(long id){
	
		return getSqlMapClientTemplate().delete("deleteTelephone", id);
	}
	
	
	/**
	 * 修改 其他电话
	 * @param id
	 * @return updated count 
	 */
	public int updateTelephone(Telephone telephone){
		return getSqlMapClientTemplate().update("updateTelephone",telephone);
	
	}

		
	/**
	 * 修改 其他电话但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTelephoneIgnoreNull(Telephone telephone){
		Telephone tmp = findTelephone(telephone.getId());
		int flag =0;
		
		
		if(telephone.getCustomeruserid()!=null){
			tmp.setCustomeruserid(telephone.getCustomeruserid());
			
			flag++;
		}
		
		if(telephone.getTelnumber()!=null){
			tmp.setTelnumber(telephone.getTelnumber());
			
			flag++;
		}
		
		if(telephone.getTeltype()!=null){
			tmp.setTeltype(telephone.getTeltype());
			
			flag++;
		}
		
		if(telephone.getCreateuser()!=null){
			tmp.setCreateuser(telephone.getCreateuser());
			
			flag++;
		}
		
		if(telephone.getCreatetime()!=null){
			tmp.setCreatetime(telephone.getCreatetime());
			
			flag++;
		}
		
		if(telephone.getModifyuser()!=null){
			tmp.setModifyuser(telephone.getModifyuser());
			
			flag++;
		}
		
		if(telephone.getModifytime()!=null){
			tmp.setModifytime(telephone.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTelephone",tmp);
		}
	}
	
	/**
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTelephone",map, offset, limit);
	}
		
	
	/**
	 * 查找 其他电话
	 * @param id
	 * @return
	 */
	public Telephone findTelephone(long id){
		return (Telephone)(getSqlMapClientTemplate().queryForObject("findTelephone",id));
	}
	
	/** 
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTelephoneBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTelephone",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找其他电话
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTelephoneBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 其他电话
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTelephoneBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTelephoneBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTelephoneBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTelephoneBySql",map).toString()));
	}
}

