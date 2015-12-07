/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.buyingimg;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class BuyingimgManager extends  SqlMapClientDaoSupport  implements IBuyingimgManager{ 
	
  
 	/**
	 * 创建 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Buyingimg createBuyingimg(Buyingimg buyingimg) throws SQLException{
	
		if(buyingimg.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		buyingimg.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_BUYINGIMG"));
		getSqlMapClientTemplate().insert("createBuyingimg",buyingimg);
		return buyingimg;
	}
	/**
	 * 删除 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuyingimg(long id){
	
		return getSqlMapClientTemplate().delete("deleteBuyingimg", id);
	}
	
	
	/**
	 * 修改 团购图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuyingimg(Buyingimg buyingimg){
		return getSqlMapClientTemplate().update("updateBuyingimg",buyingimg);
	
	}

		
	/**
	 * 修改 团购图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingimgIgnoreNull(Buyingimg buyingimg){
		Buyingimg tmp = findBuyingimg(buyingimg.getId());
		int flag =0;
		
		
		if(buyingimg.getBuyingid()!=null){
			tmp.setBuyingid(buyingimg.getBuyingid());
			
			flag++;
		}
		
		if(buyingimg.getImgurl()!=null){
			tmp.setImgurl(buyingimg.getImgurl());
			
			flag++;
		}
		
		if(buyingimg.getName()!=null){
			tmp.setName(buyingimg.getName());
			
			flag++;
		}
		
		if(buyingimg.getBeizhu()!=null){
			tmp.setBeizhu(buyingimg.getBeizhu());
			
			flag++;
		}
		
		if(buyingimg.getParam1()!=null){
			tmp.setParam1(buyingimg.getParam1());
			
			flag++;
		}
		
		if(buyingimg.getParam2()!=null){
			tmp.setParam2(buyingimg.getParam2());
			
			flag++;
		}
		
		if(buyingimg.getParam3()!=null){
			tmp.setParam3(buyingimg.getParam3());
			
			flag++;
		}
		
		if(buyingimg.getState()!=null){
			tmp.setState(buyingimg.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateBuyingimg",tmp);
		}
	}
	
	/**
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllBuyingimg",map, offset, limit);
	}
		
	
	/**
	 * 查找 团购图片信息
	 * @param id
	 * @return
	 */
	public Buyingimg findBuyingimg(long id){
		return (Buyingimg)(getSqlMapClientTemplate().queryForObject("findBuyingimg",id));
	}
	
	/** 
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBuyingimgBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllBuyingimg",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找团购图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllBuyingimgBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 团购图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingimgBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteBuyingimgBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingimgBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBuyingimgBySql",map).toString()));
	}
}

