/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class BiguserManager extends  SqlMapClientDaoSupport  implements IBiguserManager{ 
	
  
 	/**
	 * 创建 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public Biguser createBiguser(Biguser biguser) throws SQLException{
	
		if(biguser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		biguser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_BIGUSER"));
		getSqlMapClientTemplate().insert("createBiguser",biguser);
		return biguser;
	}
	/**
	 * 删除 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguser(long id){
	
		return getSqlMapClientTemplate().delete("deleteBiguser", id);
	}
	
	
	/**
	 * 修改 大客户关联金额表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguser(Biguser biguser){
		return getSqlMapClientTemplate().update("updateBiguser",biguser);
	
	}

		
	/**
	 * 修改 大客户关联金额表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserIgnoreNull(Biguser biguser){
		Biguser tmp = findBiguser(biguser.getId());
		int flag =0;
		
		
		if(biguser.getAgentid()!=null){
			tmp.setAgentid(biguser.getAgentid());
			
			flag++;
		}
		
		if(biguser.getCreditprice()!=null){
			tmp.setCreditprice(biguser.getCreditprice());
			
			flag++;
		}
		
		if(biguser.getYyongprice()!=null){
			tmp.setYyongprice(biguser.getYyongprice());
			
			flag++;
		}
		if(biguser.getDebt()!=null){
			tmp.setYyongprice(biguser.getDebt());
			
			flag++;
		}
		
		if(biguser.getKyongprice()!=null){
			tmp.setKyongprice(biguser.getKyongprice());
			
			flag++;
		}
		
		
		if(biguser.getCreatetime()!=null){
			tmp.setCreatetime(biguser.getCreatetime());
			
			flag++;
		}
		
		if(biguser.getCreateuserid()!=null){
			tmp.setCreateuserid(biguser.getCreateuserid());
			
			flag++;
		}
		
		if(biguser.getComment()!=null){
			tmp.setComment(biguser.getComment());
			
			flag++;
		}
		if(biguser.getYeprice()!=null){
			tmp.setYeprice(biguser.getYeprice());
			
			flag++;
		}
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateBiguser",tmp);
		}
	}
	
	/**
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllBiguser",map, offset, limit);
	}
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param id
	 * @return
	 */
	public Biguser findBiguser(long id){
		return (Biguser)(getSqlMapClientTemplate().queryForObject("findBiguser",id));
	}
	
	/** 
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBiguserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllBiguser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找大客户关联金额表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllBiguserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 大客户关联金额表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteBiguserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBiguserBySql",map).toString()));
	}
}

