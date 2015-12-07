/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tuipiao;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TuipiaoManager extends  SqlMapClientDaoSupport  implements ITuipiaoManager{ 
	
  
 	/**
	 * 创建 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public Tuipiao createTuipiao(Tuipiao tuipiao) throws SQLException{
	
		if(tuipiao.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		tuipiao.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TUIPIAO"));
		getSqlMapClientTemplate().insert("createTuipiao",tuipiao);
		return tuipiao;
	}
	/**
	 * 删除 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTuipiao(long id){
	
		return getSqlMapClientTemplate().delete("deleteTuipiao", id);
	}
	
	
	/**
	 * 修改 退票报表
	 * @param id
	 * @return updated count 
	 */
	public int updateTuipiao(Tuipiao tuipiao){
		return getSqlMapClientTemplate().update("updateTuipiao",tuipiao);
	
	}

		
	/**
	 * 修改 退票报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTuipiaoIgnoreNull(Tuipiao tuipiao){
		Tuipiao tmp = findTuipiao(tuipiao.getId());
		int flag =0;
		
		
		if(tuipiao.getRttime()!=null){
			tmp.setRttime(tuipiao.getRttime());
			
			flag++;
		}
		
		if(tuipiao.getOrdercode()!=null){
			tmp.setOrdercode(tuipiao.getOrdercode());
			
			flag++;
		}
		
		if(tuipiao.getPnr()!=null){
			tmp.setPnr(tuipiao.getPnr());
			
			flag++;
		}
		
		if(tuipiao.getNumber()!=null){
			tmp.setNumber(tuipiao.getNumber());
			
			flag++;
		}
		
		if(tuipiao.getRnumber()!=null){
			tmp.setRnumber(tuipiao.getRnumber());
			
			flag++;
		}
		
		if(tuipiao.getApplytime()!=null){
			tmp.setApplytime(tuipiao.getApplytime());
			
			flag++;
		}
		
		if(tuipiao.getState()!=null){
			tmp.setState(tuipiao.getState());
			
			flag++;
		}
		
		if(tuipiao.getOffice()!=null){
			tmp.setOffice(tuipiao.getOffice());
			
			flag++;
		}
		
		if(tuipiao.getTuiprice()!=null){
			tmp.setTuiprice(tuipiao.getTuiprice());
			
			flag++;
		}
		
		if(tuipiao.getTuitime()!=null){
			tmp.setTuitime(tuipiao.getTuitime());
			
			flag++;
		}
		
		if(tuipiao.getTicketno()!=null){
			tmp.setTicketno(tuipiao.getTicketno());
			
			flag++;
		}
		
		if(tuipiao.getPassenger()!=null){
			tmp.setPassenger(tuipiao.getPassenger());
			
			flag++;
		}
		
		if(tuipiao.getPtype()!=null){
			tmp.setPtype(tuipiao.getPtype());
			
			flag++;
		}
		
		if(tuipiao.getStartcity()!=null){
			tmp.setStartcity(tuipiao.getStartcity());
			
			flag++;
		}
		
		if(tuipiao.getEndcity()!=null){
			tmp.setEndcity(tuipiao.getEndcity());
			
			flag++;
		}
		
		if(tuipiao.getSail()!=null){
			tmp.setSail(tuipiao.getSail());
			
			flag++;
		}
		
		if(tuipiao.getAircompany()!=null){
			tmp.setAircompany(tuipiao.getAircompany());
			
			flag++;
		}
		
		if(tuipiao.getFlightnum()!=null){
			tmp.setFlightnum(tuipiao.getFlightnum());
			
			flag++;
		}
		
		if(tuipiao.getFlighttime()!=null){
			tmp.setFlighttime(tuipiao.getFlighttime());
			
			flag++;
		}
		
		if(tuipiao.getCabin()!=null){
			tmp.setCabin(tuipiao.getCabin());
			
			flag++;
		}
		
		if(tuipiao.getPrice()!=null){
			tmp.setPrice(tuipiao.getPrice());
			
			flag++;
		}
		
		if(tuipiao.getJijian()!=null){
			tmp.setJijian(tuipiao.getJijian());
			
			flag++;
		}
		
		if(tuipiao.getRanyou()!=null){
			tmp.setRanyou(tuipiao.getRanyou());
			
			flag++;
		}
		
		if(tuipiao.getTalfee()!=null){
			tmp.setTalfee(tuipiao.getTalfee());
			
			flag++;
		}
		
		if(tuipiao.getJourneytype()!=null){
			tmp.setJourneytype(tuipiao.getJourneytype());
			
			flag++;
		}
		
		if(tuipiao.getFuwufei()!=null){
			tmp.setFuwufei(tuipiao.getFuwufei());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTuipiao",tmp);
		}
	}
	
	/**
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTuipiao",map, offset, limit);
	}
		
	
	/**
	 * 查找 退票报表
	 * @param id
	 * @return
	 */
	public Tuipiao findTuipiao(long id){
		return (Tuipiao)(getSqlMapClientTemplate().queryForObject("findTuipiao",id));
	}
	
	/** 
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTuipiaoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTuipiao",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找退票报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTuipiaoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 退票报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTuipiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTuipiaoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTuipiaoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTuipiaoBySql",map).toString()));
	}
}

