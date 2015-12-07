/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.jinribaobiao;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class JinribaobiaoManager extends  SqlMapClientDaoSupport  implements IJinribaobiaoManager{ 
	
  
 	/**
	 * 创建 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public Jinribaobiao createJinribaobiao(Jinribaobiao jinribaobiao) throws SQLException{
	
		if(jinribaobiao.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		jinribaobiao.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_JINRIBAOBIAO"));
		getSqlMapClientTemplate().insert("createJinribaobiao",jinribaobiao);
		return jinribaobiao;
	}
	/**
	 * 删除 今日报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteJinribaobiao(long id){
	
		return getSqlMapClientTemplate().delete("deleteJinribaobiao", id);
	}
	
	
	/**
	 * 修改 今日报表
	 * @param id
	 * @return updated count 
	 */
	public int updateJinribaobiao(Jinribaobiao jinribaobiao){
		return getSqlMapClientTemplate().update("updateJinribaobiao",jinribaobiao);
	
	}

		
	/**
	 * 修改 今日报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateJinribaobiaoIgnoreNull(Jinribaobiao jinribaobiao){
		Jinribaobiao tmp = findJinribaobiao(jinribaobiao.getId());
		int flag =0;
		
		
		if(jinribaobiao.getOrdertime()!=null){
			tmp.setOrdertime(jinribaobiao.getOrdertime());
			
			flag++;
		}
		
		if(jinribaobiao.getPnr()!=null){
			tmp.setPnr(jinribaobiao.getPnr());
			
			flag++;
		}
		
		if(jinribaobiao.getTicketcode()!=null){
			tmp.setTicketcode(jinribaobiao.getTicketcode());
			
			flag++;
		}
		
		if(jinribaobiao.getOrdercode()!=null){
			tmp.setOrdercode(jinribaobiao.getOrdercode());
			
			flag++;
		}
		
		if(jinribaobiao.getUsername()!=null){
			tmp.setUsername(jinribaobiao.getUsername());
			
			flag++;
		}
		
		if(jinribaobiao.getStartcity()!=null){
			tmp.setStartcity(jinribaobiao.getStartcity());
			
			flag++;
		}
		
		if(jinribaobiao.getEndcity()!=null){
			tmp.setEndcity(jinribaobiao.getEndcity());
			
			flag++;
		}
		
		if(jinribaobiao.getStartcityszm()!=null){
			tmp.setStartcityszm(jinribaobiao.getStartcityszm());
			
			flag++;
		}
		
		if(jinribaobiao.getEndcityszm()!=null){
			tmp.setEndcityszm(jinribaobiao.getEndcityszm());
			
			flag++;
		}
		
		if(jinribaobiao.getFlightnumber()!=null){
			tmp.setFlightnumber(jinribaobiao.getFlightnumber());
			
			flag++;
		}
		
		if(jinribaobiao.getCabincode()!=null){
			tmp.setCabincode(jinribaobiao.getCabincode());
			
			flag++;
		}
		
		if(jinribaobiao.getFlightdate()!=null){
			tmp.setFlightdate(jinribaobiao.getFlightdate());
			
			flag++;
		}
		
		if(jinribaobiao.getPrice()!=null){
			tmp.setPrice(jinribaobiao.getPrice());
			
			flag++;
		}
		
		if(jinribaobiao.getFandian()!=null){
			tmp.setFandian(jinribaobiao.getFandian());
			
			flag++;
		}
		
		if(jinribaobiao.getJijianranyou()!=null){
			tmp.setJijianranyou(jinribaobiao.getJijianranyou());
			
			flag++;
		}
		
		if(jinribaobiao.getNumber()!=null){
			tmp.setNumber(jinribaobiao.getNumber());
			
			flag++;
		}
		
		if(jinribaobiao.getSubmoney()!=null){
			tmp.setSubmoney(jinribaobiao.getSubmoney());
			
			flag++;
		}
		
		if(jinribaobiao.getShouxufei()!=null){
			tmp.setShouxufei(jinribaobiao.getShouxufei());
			
			flag++;
		}
		
		if(jinribaobiao.getTuikuan()!=null){
			tmp.setTuikuan(jinribaobiao.getTuikuan());
			
			flag++;
		}
		
		if(jinribaobiao.getYingshou()!=null){
			tmp.setYingshou(jinribaobiao.getYingshou());
			
			flag++;
		}
		
		if(jinribaobiao.getLirun()!=null){
			tmp.setLirun(jinribaobiao.getLirun());
			
			flag++;
		}
		
		if(jinribaobiao.getPaymethod()!=null){
			tmp.setPaymethod(jinribaobiao.getPaymethod());
			
			flag++;
		}
		
		if(jinribaobiao.getPaytime()!=null){
			tmp.setPaytime(jinribaobiao.getPaytime());
			
			flag++;
		}
		
		if(jinribaobiao.getFeitime()!=null){
			tmp.setFeitime(jinribaobiao.getFeitime());
			
			flag++;
		}
		
		if(jinribaobiao.getRttime()!=null){
			tmp.setRttime(jinribaobiao.getRttime());
			
			flag++;
		}
		
		if(jinribaobiao.getState()!=null){
			tmp.setState(jinribaobiao.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateJinribaobiao",tmp);
		}
	}
	
	/**
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiao(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllJinribaobiao",map, offset, limit);
	}
		
	
	/**
	 * 查找 今日报表
	 * @param id
	 * @return
	 */
	public Jinribaobiao findJinribaobiao(long id){
		return (Jinribaobiao)(getSqlMapClientTemplate().queryForObject("findJinribaobiao",id));
	}
	
	/** 
	 * 查找 今日报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllJinribaobiao(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countJinribaobiaoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllJinribaobiao",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找今日报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllJinribaobiao(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllJinribaobiaoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 今日报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteJinribaobiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteJinribaobiaoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countJinribaobiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countJinribaobiaoBySql",map).toString()));
	}
}

