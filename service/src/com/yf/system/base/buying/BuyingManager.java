/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.buying;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class BuyingManager extends  SqlMapClientDaoSupport  implements IBuyingManager{ 
	
  
 	/**
	 * 创建 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public Buying createBuying(Buying buying) throws SQLException{
	
		if(buying.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		buying.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_BUYING"));
		getSqlMapClientTemplate().insert("createBuying",buying);
		return buying;
	}
	/**
	 * 删除 团购信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuying(long id){
	
		return getSqlMapClientTemplate().delete("deleteBuying", id);
	}
	
	
	/**
	 * 修改 团购信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuying(Buying buying){
		return getSqlMapClientTemplate().update("updateBuying",buying);
	
	}

		
	/**
	 * 修改 团购信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingIgnoreNull(Buying buying){
		Buying tmp = findBuying(buying.getId());
		int flag =0;
		
		
		if(buying.getOutid()!=null){
			tmp.setOutid(buying.getOutid());
			
			flag++;
		}
		
		if(buying.getAgentid()!=null){
			tmp.setAgentid(buying.getAgentid());
			
			flag++;
		}
		
		if(buying.getPid()!=null){
			tmp.setPid(buying.getPid());
			
			flag++;
		}
		
		if(buying.getCityid()!=null){
			tmp.setCityid(buying.getCityid());
			
			flag++;
		}
		
		if(buying.getRegionid()!=null){
			tmp.setRegionid(buying.getRegionid());
			
			flag++;
		}
		
		if(buying.getName()!=null){
			tmp.setName(buying.getName());
			
			flag++;
		}
		
		if(buying.getMarketprice()!=null){
			tmp.setMarketprice(buying.getMarketprice());
			
			flag++;
		}
		
		if(buying.getShopprice()!=null){
			tmp.setShopprice(buying.getShopprice());
			
			flag++;
		}
		
		if(buying.getDescinfo()!=null){
			tmp.setDescinfo(buying.getDescinfo());
			
			flag++;
		}
		
		if(buying.getBeizhu()!=null){
			tmp.setBeizhu(buying.getBeizhu());
			
			flag++;
		}
		
		if(buying.getTiqiandays()!=null){
			tmp.setTiqiandays(buying.getTiqiandays());
			
			flag++;
		}
		
		if(buying.getAddress()!=null){
			tmp.setAddress(buying.getAddress());
			
			flag++;
		}
		
		if(buying.getStime()!=null){
			tmp.setStime(buying.getStime());
			
			flag++;
		}
		
		if(buying.getEndtime()!=null){
			tmp.setEndtime(buying.getEndtime());
			
			flag++;
		}
		
		if(buying.getStimeetime()!=null){
			tmp.setStimeetime(buying.getStimeetime());
			
			flag++;
		}
		
		if(buying.getGuize()!=null){
			tmp.setGuize(buying.getGuize());
			
			flag++;
		}
		
		if(buying.getMinnumber()!=null){
			tmp.setMinnumber(buying.getMinnumber());
			
			flag++;
		}
		
		if(buying.getTejia()!=null){
			tmp.setTejia(buying.getTejia());
			
			flag++;
		}
		
		if(buying.getTitle1()!=null){
			tmp.setTitle1(buying.getTitle1());
			
			flag++;
		}
		
		if(buying.getPic1()!=null){
			tmp.setPic1(buying.getPic1());
			
			flag++;
		}
		
		if(buying.getPic2()!=null){
			tmp.setPic2(buying.getPic2());
			
			flag++;
		}
		
		if(buying.getText1()!=null){
			tmp.setText1(buying.getText1());
			
			flag++;
		}
		
		if(buying.getText2()!=null){
			tmp.setText2(buying.getText2());
			
			flag++;
		}
		
		if(buying.getText3()!=null){
			tmp.setText3(buying.getText3());
			
			flag++;
		}
		
		if(buying.getParam1()!=null){
			tmp.setParam1(buying.getParam1());
			
			flag++;
		}
		
		if(buying.getParam2()!=null){
			tmp.setParam2(buying.getParam2());
			
			flag++;
		}
		
		if(buying.getParam3()!=null){
			tmp.setParam3(buying.getParam3());
			
			flag++;
		}
		
		if(buying.getCreatetime()!=null){
			tmp.setCreatetime(buying.getCreatetime());
			
			flag++;
		}
		
		if(buying.getMemberid()!=null){
			tmp.setMemberid(buying.getMemberid());
			
			flag++;
		}
		
		if(buying.getType()!=null){
			tmp.setType(buying.getType());
			
			flag++;
		}
		
		if(buying.getState()!=null){
			tmp.setState(buying.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateBuying",tmp);
		}
	}
	
	/**
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllBuying",map, offset, limit);
	}
		
	
	/**
	 * 查找 团购信息
	 * @param id
	 * @return
	 */
	public Buying findBuying(long id){
		return (Buying)(getSqlMapClientTemplate().queryForObject("findBuying",id));
	}
	
	/** 
	 * 查找 团购信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuying(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBuyingBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllBuying",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找团购信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuying(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllBuyingBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 团购信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteBuyingBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countBuyingBySql",map).toString()));
	}
}

