/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airlien;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirlienManager extends  SqlMapClientDaoSupport  implements IAirlienManager{ 
	
  
 	/**
	 * 创建 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public Airlien createAirlien(Airlien airlien) throws SQLException{
	
		if(airlien.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airlien.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRLIEN"));
		getSqlMapClientTemplate().insert("createAirlien",airlien);
		return airlien;
	}
	/**
	 * 删除 航线信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirlien(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirlien", id);
	}
	
	
	/**
	 * 修改 航线信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirlien(Airlien airlien){
		return getSqlMapClientTemplate().update("updateAirlien",airlien);
	
	}

		
	/**
	 * 修改 航线信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirlienIgnoreNull(Airlien airlien){
		Airlien tmp = findAirlien(airlien.getId());
		int flag =0;
		
		
		if(airlien.getScode()!=null){
			tmp.setScode(airlien.getScode());
			
			flag++;
		}
		
		if(airlien.getEcode()!=null){
			tmp.setEcode(airlien.getEcode());
			
			flag++;
		}
		
		if(airlien.getScityname()!=null){
			tmp.setScityname(airlien.getScityname());
			
			flag++;
		}
		
		if(airlien.getEcityname()!=null){
			tmp.setEcityname(airlien.getEcityname());
			
			flag++;
		}
		
		if(airlien.getShzl()!=null){
			tmp.setShzl(airlien.getShzl());
			
			flag++;
		}
		
		if(airlien.getEhzl()!=null){
			tmp.setEhzl(airlien.getEhzl());
			
			flag++;
		}
		
		if(airlien.getDistance()!=null){
			tmp.setDistance(airlien.getDistance());
			
			flag++;
		}
		
		if(airlien.getFtime()!=null){
			tmp.setFtime(airlien.getFtime());
			
			flag++;
		}
		
		if(airlien.getAircode()!=null){
			tmp.setAircode(airlien.getAircode());
			
			flag++;
		}
		
		if(airlien.getAirno()!=null){
			tmp.setAirno(airlien.getAirno());
			
			flag++;
		}
		
		if(airlien.getAirname()!=null){
			tmp.setAirname(airlien.getAirname());
			
			flag++;
		}
		
		if(airlien.getAirportfee()!=null){
			tmp.setAirportfee(airlien.getAirportfee());
			
			flag++;
		}
		
		if(airlien.getFuelfee()!=null){
			tmp.setFuelfee(airlien.getFuelfee());
			
			flag++;
		}
		
		if(airlien.getStopnum()!=null){
			tmp.setStopnum(airlien.getStopnum());
			
			flag++;
		}
		
		if(airlien.getStopinfo()!=null){
			tmp.setStopinfo(airlien.getStopinfo());
			
			flag++;
		}
		
		if(airlien.getMeal()!=null){
			tmp.setMeal(airlien.getMeal());
			
			flag++;
		}
		
		if(airlien.getDeparttime()!=null){
			tmp.setDeparttime(airlien.getDeparttime());
			
			flag++;
		}
		
		if(airlien.getArrivetime()!=null){
			tmp.setArrivetime(airlien.getArrivetime());
			
			flag++;
		}
		
		if(airlien.getSharenum()!=null){
			tmp.setSharenum(airlien.getSharenum());
			
			flag++;
		}
		
		if(airlien.getBanqi()!=null){
			tmp.setBanqi(airlien.getBanqi());
			
			flag++;
		}
		
		if(airlien.getAirtype()!=null){
			tmp.setAirtype(airlien.getAirtype());
			
			flag++;
		}
		
		if(airlien.getYprice()!=null){
			tmp.setYprice(airlien.getYprice());
			
			flag++;
		}
		
		if(airlien.getParam1()!=null){
			tmp.setParam1(airlien.getParam1());
			
			flag++;
		}
		
		if(airlien.getParam2()!=null){
			tmp.setParam2(airlien.getParam2());
			
			flag++;
		}
		
		if(airlien.getParam3()!=null){
			tmp.setParam3(airlien.getParam3());
			
			flag++;
		}
		
		if(airlien.getCreatetime()!=null){
			tmp.setCreatetime(airlien.getCreatetime());
			
			flag++;
		}
		
		if(airlien.getState()!=null){
			tmp.setState(airlien.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirlien",tmp);
		}
	}
	
	/**
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlien(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirlien",map, offset, limit);
	}
		
	
	/**
	 * 查找 航线信息
	 * @param id
	 * @return
	 */
	public Airlien findAirlien(long id){
		return (Airlien)(getSqlMapClientTemplate().queryForObject("findAirlien",id));
	}
	
	/** 
	 * 查找 航线信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirlien(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirlienBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirlien",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航线信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirlien(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirlienBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航线信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirlienBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirlienBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirlienBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirlienBySql",map).toString()));
	}
}

