/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.kweisq;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class KweisqManager extends  SqlMapClientDaoSupport  implements IKweisqManager{ 
	
  
 	/**
	 * 创建 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Kweisq createKweisq(Kweisq kweisq) throws SQLException{
	
		if(kweisq.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		kweisq.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_KWEISQ"));
		getSqlMapClientTemplate().insert("createKweisq",kweisq);
		return kweisq;
	}
	/**
	 * 删除 K位特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteKweisq(long id){
	
		return getSqlMapClientTemplate().delete("deleteKweisq", id);
	}
	
	
	/**
	 * 修改 K位特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateKweisq(Kweisq kweisq){
		return getSqlMapClientTemplate().update("updateKweisq",kweisq);
	
	}

		
	/**
	 * 修改 K位特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateKweisqIgnoreNull(Kweisq kweisq){
		Kweisq tmp = findKweisq(kweisq.getId());
		int flag =0;
		
		
		if(kweisq.getAngenid()!=null){
			tmp.setAngenid(kweisq.getAngenid());
			
			flag++;
		}
		
		if(kweisq.getDistributorid()!=null){
			tmp.setDistributorid(kweisq.getDistributorid());
			
			flag++;
		}
		
		if(kweisq.getPeoplenumber()!=null){
			tmp.setPeoplenumber(kweisq.getPeoplenumber());
			
			flag++;
		}
		
		if(kweisq.getCreatetime()!=null){
			tmp.setCreatetime(kweisq.getCreatetime());
			
			flag++;
		}
		
		if(kweisq.getCreateuser()!=null){
			tmp.setCreateuser(kweisq.getCreateuser());
			
			flag++;
		}
		
		if(kweisq.getUsername()!=null){
			tmp.setUsername(kweisq.getUsername());
			
			flag++;
		}
		
		if(kweisq.getMobile()!=null){
			tmp.setMobile(kweisq.getMobile());
			
			flag++;
		}
		
		if(kweisq.getPostbox()!=null){
			tmp.setPostbox(kweisq.getPostbox());
			
			flag++;
		}
		
		if(kweisq.getComment()!=null){
			tmp.setComment(kweisq.getComment());
			
			flag++;
		}
		
		if(kweisq.getStatus()!=null){
			tmp.setStatus(kweisq.getStatus());
			
			flag++;
		}
		
		if(kweisq.getKweiid()!=null){
			tmp.setKweiid(kweisq.getKweiid());
			
			flag++;
		}
		
		if(kweisq.getUpdatetime()!=null){
			tmp.setUpdatetime(kweisq.getUpdatetime());
			
			flag++;
		}
		
		if(kweisq.getUpdateuser()!=null){
			tmp.setUpdateuser(kweisq.getUpdateuser());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateKweisq",tmp);
		}
	}
	
	/**
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisq(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllKweisq",map, offset, limit);
	}
		
	
	/**
	 * 查找 K位特价申请表
	 * @param id
	 * @return
	 */
	public Kweisq findKweisq(long id){
		return (Kweisq)(getSqlMapClientTemplate().queryForObject("findKweisq",id));
	}
	
	/** 
	 * 查找 K位特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllKweisq(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countKweisqBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllKweisq",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找K位特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllKweisq(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllKweisqBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql K位特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteKweisqBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteKweisqBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countKweisqBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countKweisqBySql",map).toString()));
	}
}

