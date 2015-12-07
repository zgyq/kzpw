/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotticket;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotticketManager extends  SqlMapClientDaoSupport  implements ISpotticketManager{ 
	
  
 	/**
	 * 创建 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public Spotticket createSpotticket(Spotticket spotticket) throws SQLException{
	
		if(spotticket.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotticket.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTTICKET"));
		getSqlMapClientTemplate().insert("createSpotticket",spotticket);
		return spotticket;
	}
	/**
	 * 删除 景点门票
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticket(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotticket", id);
	}
	
	
	/**
	 * 修改 景点门票
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticket(Spotticket spotticket){
		return getSqlMapClientTemplate().update("updateSpotticket",spotticket);
	
	}

		
	/**
	 * 修改 景点门票但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketIgnoreNull(Spotticket spotticket){
		Spotticket tmp = findSpotticket(spotticket.getId());
		int flag =0;
		
		
		if(spotticket.getOutid()!=null){
			tmp.setOutid(spotticket.getOutid());
			
			flag++;
		}
		
		if(spotticket.getSid()!=null){
			tmp.setSid(spotticket.getSid());
			
			flag++;
		}
		
		if(spotticket.getGoodsid()!=null){
			tmp.setGoodsid(spotticket.getGoodsid());
			
			flag++;
		}
		
		if(spotticket.getName()!=null){
			tmp.setName(spotticket.getName());
			
			flag++;
		}
		
		if(spotticket.getMarketprice()!=null){
			tmp.setMarketprice(spotticket.getMarketprice());
			
			flag++;
		}
		
		if(spotticket.getShopprice()!=null){
			tmp.setShopprice(spotticket.getShopprice());
			
			flag++;
		}
		
		if(spotticket.getBitopt()!=null){
			tmp.setBitopt(spotticket.getBitopt());
			
			flag++;
		}
		
		if(spotticket.getLimitnumber()!=null){
			tmp.setLimitnumber(spotticket.getLimitnumber());
			
			flag++;
		}
		
		if(spotticket.getSellendtime()!=null){
			tmp.setSellendtime(spotticket.getSellendtime());
			
			flag++;
		}
		
		if(spotticket.getLimitarea()!=null){
			tmp.setLimitarea(spotticket.getLimitarea());
			
			flag++;
		}
		
		if(spotticket.getAccessarea()!=null){
			tmp.setAccessarea(spotticket.getAccessarea());
			
			flag++;
		}
		
		if(spotticket.getLimitsfznumber()!=null){
			tmp.setLimitsfznumber(spotticket.getLimitsfznumber());
			
			flag++;
		}
		
		if(spotticket.getMinnumber()!=null){
			tmp.setMinnumber(spotticket.getMinnumber());
			
			flag++;
		}
		
		if(spotticket.getTejia()!=null){
			tmp.setTejia(spotticket.getTejia());
			
			flag++;
		}
		
		if(spotticket.getTitle1()!=null){
			tmp.setTitle1(spotticket.getTitle1());
			
			flag++;
		}
		
		if(spotticket.getPic1()!=null){
			tmp.setPic1(spotticket.getPic1());
			
			flag++;
		}
		
		if(spotticket.getPic2()!=null){
			tmp.setPic2(spotticket.getPic2());
			
			flag++;
		}
		
		if(spotticket.getText1()!=null){
			tmp.setText1(spotticket.getText1());
			
			flag++;
		}
		
		if(spotticket.getText2()!=null){
			tmp.setText2(spotticket.getText2());
			
			flag++;
		}
		
		if(spotticket.getText3()!=null){
			tmp.setText3(spotticket.getText3());
			
			flag++;
		}
		
		if(spotticket.getParam1()!=null){
			tmp.setParam1(spotticket.getParam1());
			
			flag++;
		}
		
		if(spotticket.getParam2()!=null){
			tmp.setParam2(spotticket.getParam2());
			
			flag++;
		}
		
		if(spotticket.getParam3()!=null){
			tmp.setParam3(spotticket.getParam3());
			
			flag++;
		}
		
		if(spotticket.getCreatetime()!=null){
			tmp.setCreatetime(spotticket.getCreatetime());
			
			flag++;
		}
		
		if(spotticket.getMemberid()!=null){
			tmp.setMemberid(spotticket.getMemberid());
			
			flag++;
		}
		
		if(spotticket.getState()!=null){
			tmp.setState(spotticket.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotticket",tmp);
		}
	}
	
	/**
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotticket",map, offset, limit);
	}
		
	
	/**
	 * 查找 景点门票
	 * @param id
	 * @return
	 */
	public Spotticket findSpotticket(long id){
		return (Spotticket)(getSqlMapClientTemplate().queryForObject("findSpotticket",id));
	}
	
	/** 
	 * 查找 景点门票
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticket(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotticketBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotticket",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景点门票
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticket(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotticketBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景点门票
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotticketBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotticketBySql",map).toString()));
	}
}

