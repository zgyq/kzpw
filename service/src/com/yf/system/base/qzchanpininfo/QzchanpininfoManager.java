/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.qzchanpininfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class QzchanpininfoManager extends  SqlMapClientDaoSupport  implements IQzchanpininfoManager{ 
	
  
 	/**
	 * 创建 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Qzchanpininfo createQzchanpininfo(Qzchanpininfo qzchanpininfo) throws SQLException{
	
		if(qzchanpininfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		qzchanpininfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_QZCHANPININFO"));
		getSqlMapClientTemplate().insert("createQzchanpininfo",qzchanpininfo);
		return qzchanpininfo;
	}
	/**
	 * 删除 签证产品详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQzchanpininfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteQzchanpininfo", id);
	}
	
	
	/**
	 * 修改 签证产品详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateQzchanpininfo(Qzchanpininfo qzchanpininfo){
		return getSqlMapClientTemplate().update("updateQzchanpininfo",qzchanpininfo);
	
	}

		
	/**
	 * 修改 签证产品详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQzchanpininfoIgnoreNull(Qzchanpininfo qzchanpininfo){
		Qzchanpininfo tmp = findQzchanpininfo(qzchanpininfo.getId());
		int flag =0;
		
		
		if(qzchanpininfo.getOutid()!=null){
			tmp.setOutid(qzchanpininfo.getOutid());
			
			flag++;
		}
		
		if(qzchanpininfo.getTitle()!=null){
			tmp.setTitle(qzchanpininfo.getTitle());
			
			flag++;
		}
		
		if(qzchanpininfo.getTitleurl()!=null){
			tmp.setTitleurl(qzchanpininfo.getTitleurl());
			
			flag++;
		}
		
		if(qzchanpininfo.getCountry()!=null){
			tmp.setCountry(qzchanpininfo.getCountry());
			
			flag++;
		}
		
		if(qzchanpininfo.getCategory()!=null){
			tmp.setCategory(qzchanpininfo.getCategory());
			
			flag++;
		}
		
		if(qzchanpininfo.getPrice()!=null){
			tmp.setPrice(qzchanpininfo.getPrice());
			
			flag++;
		}
		
		if(qzchanpininfo.getSprice()!=null){
			tmp.setSprice(qzchanpininfo.getSprice());
			
			flag++;
		}
		
		if(qzchanpininfo.getQprice()!=null){
			tmp.setQprice(qzchanpininfo.getQprice());
			
			flag++;
		}
		
		if(qzchanpininfo.getDealcity()!=null){
			tmp.setDealcity(qzchanpininfo.getDealcity());
			
			flag++;
		}
		
		if(qzchanpininfo.getArea()!=null){
			tmp.setArea(qzchanpininfo.getArea());
			
			flag++;
		}
		
		if(qzchanpininfo.getConfine()!=null){
			tmp.setConfine(qzchanpininfo.getConfine());
			
			flag++;
		}
		
		if(qzchanpininfo.getFeeinfo()!=null){
			tmp.setFeeinfo(qzchanpininfo.getFeeinfo());
			
			flag++;
		}
		
		if(qzchanpininfo.getValiditydate()!=null){
			tmp.setValiditydate(qzchanpininfo.getValiditydate());
			
			flag++;
		}
		
		if(qzchanpininfo.getSettleday()!=null){
			tmp.setSettleday(qzchanpininfo.getSettleday());
			
			flag++;
		}
		
		if(qzchanpininfo.getIntendingday()!=null){
			tmp.setIntendingday(qzchanpininfo.getIntendingday());
			
			flag++;
		}
		
		if(qzchanpininfo.getNumberofentries()!=null){
			tmp.setNumberofentries(qzchanpininfo.getNumberofentries());
			
			flag++;
		}
		
		if(qzchanpininfo.getIsexam()!=null){
			tmp.setIsexam(qzchanpininfo.getIsexam());
			
			flag++;
		}
		
		if(qzchanpininfo.getSmalltext()!=null){
			tmp.setSmalltext(qzchanpininfo.getSmalltext());
			
			flag++;
		}
		
		if(qzchanpininfo.getParam1()!=null){
			tmp.setParam1(qzchanpininfo.getParam1());
			
			flag++;
		}
		
		if(qzchanpininfo.getParam2()!=null){
			tmp.setParam2(qzchanpininfo.getParam2());
			
			flag++;
		}
		
		if(qzchanpininfo.getParam3()!=null){
			tmp.setParam3(qzchanpininfo.getParam3());
			
			flag++;
		}
		
		if(qzchanpininfo.getCreatetime()!=null){
			tmp.setCreatetime(qzchanpininfo.getCreatetime());
			
			flag++;
		}
		
		if(qzchanpininfo.getState()!=null){
			tmp.setState(qzchanpininfo.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateQzchanpininfo",tmp);
		}
	}
	
	/**
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllQzchanpininfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 签证产品详细信息
	 * @param id
	 * @return
	 */
	public Qzchanpininfo findQzchanpininfo(long id){
		return (Qzchanpininfo)(getSqlMapClientTemplate().queryForObject("findQzchanpininfo",id));
	}
	
	/** 
	 * 查找 签证产品详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQzchanpininfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzchanpininfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllQzchanpininfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找签证产品详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQzchanpininfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllQzchanpininfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 签证产品详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQzchanpininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteQzchanpininfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQzchanpininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countQzchanpininfoBySql",map).toString()));
	}
}

