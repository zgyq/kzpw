/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.biguserprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class BiguserpriceManager extends  SqlMapClientDaoSupport  implements IBiguserpriceManager{ 
	
  
 	/**
	 * 创建 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public Biguserprice createBiguserprice(Biguserprice biguserprice) throws SQLException{
	
		if(biguserprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		biguserprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_BIGUSERPRICE"));
		getSqlMapClientTemplate().insert("createBiguserprice",biguserprice);
		return biguserprice;
	}
	/**
	 * 删除 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguserprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteBiguserprice", id);
	}
	
	
	/**
	 * 修改 大客户还款金额记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguserprice(Biguserprice biguserprice){
		return getSqlMapClientTemplate().update("updateBiguserprice",biguserprice);
	
	}

		
	/**
	 * 修改 大客户还款金额记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserpriceIgnoreNull(Biguserprice biguserprice){
		Biguserprice tmp = findBiguserprice(biguserprice.getId());
		int flag =0;
		
		
		if(biguserprice.getAngentid()!=null){
			tmp.setAngentid(biguserprice.getAngentid());
			
			flag++;
		}
		
		if(biguserprice.getHkuanprice()!=null){
			tmp.setHkuanprice(biguserprice.getHkuanprice());
			
			flag++;
		}
		
		if(biguserprice.getCreatetime()!=null){
			tmp.setCreatetime(biguserprice.getCreatetime());
			
			flag++;
		}
		
		if(biguserprice.getCreateuserid()!=null){
			tmp.setCreateuserid(biguserprice.getCreateuserid());
			
			flag++;
		}
		
		if(biguserprice.getDeptid()!=null){
			tmp.setDeptid(biguserprice.getDeptid());
			flag++;
		}
		
		if(biguserprice.getComment()!=null){
			tmp.setComment(biguserprice.getComment());
			
			flag++;
		}
		
		if(biguserprice.getRepaytype()!=null){
			tmp.setRepaytype(biguserprice.getRepaytype());
			flag++;
		}
		
		if(biguserprice.getDebt()!=null){
			tmp.setDebt(biguserprice.getDebt());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateBiguserprice",tmp);
		}
	}
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllBiguserprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param id
	 * @return
	 */
	public Biguserprice findBiguserprice(long id){
		return (Biguserprice)(getSqlMapClientTemplate().queryForObject("findBiguserprice",id));
	}
	
	/** 
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBiguserpriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllBiguserprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找大客户还款金额记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllBiguserpriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 大客户还款金额记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteBiguserpriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBiguserpriceBySql",map).toString()));
	}
}

