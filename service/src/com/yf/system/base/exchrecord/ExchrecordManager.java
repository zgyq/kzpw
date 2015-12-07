/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.exchrecord;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ExchrecordManager extends  SqlMapClientDaoSupport  implements IExchrecordManager{ 
	
  
 	/**
	 * 创建 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public Exchrecord createExchrecord(Exchrecord exchrecord) throws SQLException{
	
		if(exchrecord.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		exchrecord.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_EXCHRECORD"));
		getSqlMapClientTemplate().insert("createExchrecord",exchrecord);
		return exchrecord;
	}
	/**
	 * 删除 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteExchrecord(long id){
	
		return getSqlMapClientTemplate().delete("deleteExchrecord", id);
	}
	
	
	/**
	 * 修改 积分兑换纪录
	 * @param id
	 * @return updated count 
	 */
	public int updateExchrecord(Exchrecord exchrecord){
		return getSqlMapClientTemplate().update("updateExchrecord",exchrecord);
	
	}

		
	/**
	 * 修改 积分兑换纪录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateExchrecordIgnoreNull(Exchrecord exchrecord){
		Exchrecord tmp = findExchrecord(exchrecord.getId());
		int flag =0;
		
		
		if(exchrecord.getPrizeid()!=null){
			tmp.setPrizeid(exchrecord.getPrizeid());
			
			flag++;
		}
		
		if(exchrecord.getCustomerid()!=null){
			tmp.setCustomerid(exchrecord.getCustomerid());
			
			flag++;
		}
		
		if(exchrecord.getContactname()!=null){
			tmp.setContactname(exchrecord.getContactname());
			
			flag++;
		}
		
		if(exchrecord.getContactmobile()!=null){
			tmp.setContactmobile(exchrecord.getContactmobile());
			
			flag++;
		}
		
		if(exchrecord.getContactadd()!=null){
			tmp.setContactadd(exchrecord.getContactadd());
			
			flag++;
		}
		
		if(exchrecord.getDesc()!=null){
			tmp.setDesc(exchrecord.getDesc());
			
			flag++;
		}
		
		if(exchrecord.getCreateuser()!=null){
			tmp.setCreateuser(exchrecord.getCreateuser());
			
			flag++;
		}
		
		if(exchrecord.getCreatetime()!=null){
			tmp.setCreatetime(exchrecord.getCreatetime());
			
			flag++;
		}
		
		if(exchrecord.getModifyuser()!=null){
			tmp.setModifyuser(exchrecord.getModifyuser());
			
			flag++;
		}
		
		if(exchrecord.getModifytime()!=null){
			tmp.setModifytime(exchrecord.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateExchrecord",tmp);
		}
	}
	
	/**
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllExchrecord",map, offset, limit);
	}
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param id
	 * @return
	 */
	public Exchrecord findExchrecord(long id){
		return (Exchrecord)(getSqlMapClientTemplate().queryForObject("findExchrecord",id));
	}
	
	/** 
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countExchrecordBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllExchrecord",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找积分兑换纪录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllExchrecordBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 积分兑换纪录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteExchrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteExchrecordBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countExchrecordBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countExchrecordBySql",map).toString()));
	}
}

