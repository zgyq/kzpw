/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.segmentinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SegmentinfoManager extends  SqlMapClientDaoSupport  implements ISegmentinfoManager{ 
	
  
 	/**
	 * 创建 行程表
	 * @param id
	 * @return deleted count 
	 */
	public Segmentinfo createSegmentinfo(Segmentinfo segmentinfo) throws SQLException{
	
		if(segmentinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		segmentinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SEGMENTINFO"));
		getSqlMapClientTemplate().insert("createSegmentinfo",segmentinfo);
		if(segmentinfo.getUcode()==null||segmentinfo.getUcode()<1)
		{
			segmentinfo.setUcode(segmentinfo.getId());
			updateSegmentinfoIgnoreNull(segmentinfo);
		}
		return segmentinfo;
	}
	/**
	 * 删除 行程表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSegmentinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteSegmentinfo", id);
	}
	
	
	/**
	 * 修改 行程表
	 * @param id
	 * @return updated count 
	 */
	public int updateSegmentinfo(Segmentinfo segmentinfo){
		return getSqlMapClientTemplate().update("updateSegmentinfo",segmentinfo);
	
	}

		
	/**
	 * 修改 行程表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSegmentinfoIgnoreNull(Segmentinfo segmentinfo){
		Segmentinfo tmp = findSegmentinfo(segmentinfo.getId());
		int flag =0;
		
		
		if(segmentinfo.getOrderid()!=null){
			tmp.setOrderid(segmentinfo.getOrderid());
			
			flag++;
		}
		
		if(segmentinfo.getFlightnumber()!=null){
			tmp.setFlightnumber(segmentinfo.getFlightnumber());
			
			flag++;
		}
		
		if(segmentinfo.getAircomapnycode()!=null){
			tmp.setAircomapnycode(segmentinfo.getAircomapnycode());
			
			flag++;
		}
		
		if(segmentinfo.getAirportfee()!=null){
			tmp.setAirportfee(segmentinfo.getAirportfee());
			
			flag++;
		}
		
		if(segmentinfo.getFuelfee()!=null){
			tmp.setFuelfee(segmentinfo.getFuelfee());
			
			flag++;
		}
		
		if(segmentinfo.getDeparttime()!=null){
			tmp.setDeparttime(segmentinfo.getDeparttime());
			
			flag++;
		}
		
		if(segmentinfo.getArrivaltime()!=null){
			tmp.setArrivaltime(segmentinfo.getArrivaltime());
			
			flag++;
		}
		
		if(segmentinfo.getCabincode()!=null){
			tmp.setCabincode(segmentinfo.getCabincode());
			
			flag++;
		}
		
		if(segmentinfo.getPrice()!=null){
			tmp.setPrice(segmentinfo.getPrice());
			
			flag++;
		}
		
		if(segmentinfo.getDiscount()!=null){
			tmp.setDiscount(segmentinfo.getDiscount());
			
			flag++;
		}
		
		if(segmentinfo.getYprice()!=null){
			tmp.setYprice(segmentinfo.getYprice());
			
			flag++;
		}
		
		if(segmentinfo.getTraveltype()!=null){
			tmp.setTraveltype(segmentinfo.getTraveltype());
			
			flag++;
		}
		
		if(segmentinfo.getIsspecial()!=null){
			tmp.setIsspecial(segmentinfo.getIsspecial());
			
			flag++;
		}
		
		if(segmentinfo.getStartairport()!=null){
			tmp.setStartairport(segmentinfo.getStartairport());
			
			flag++;
		}
		
		if(segmentinfo.getEndairport()!=null){
			tmp.setEndairport(segmentinfo.getEndairport());
			
			flag++;
		}
		
		if(segmentinfo.getRules()!=null){
			tmp.setRules(segmentinfo.getRules());
			
			flag++;
		}
		
		if(segmentinfo.getRatevalue()!=null){
			tmp.setRatevalue(segmentinfo.getRatevalue());
			
			flag++;
		}
		
		if(segmentinfo.getUcode()!=null){
			tmp.setUcode(segmentinfo.getUcode());
			
			flag++;
		}
		
		if(segmentinfo.getLanguage()!=null){
			tmp.setLanguage(segmentinfo.getLanguage());
			
			flag++;
		}
		
		if(segmentinfo.getBorderpointat()!=null){
			tmp.setBorderpointat(segmentinfo.getBorderpointat());
			
			flag++;
		}
		
		if(segmentinfo.getOffpointat()!=null){
			tmp.setOffpointat(segmentinfo.getOffpointat());
			
			flag++;
		}
		
		if(segmentinfo.getParvalue()!=null){
			tmp.setParvalue(segmentinfo.getParvalue());
			
			flag++;
		}
		
		if(segmentinfo.getAgentid()!=null){
			tmp.setAgentid(segmentinfo.getAgentid());
			
			flag++;
		}
		
		if(segmentinfo.getZrateid()!=null){
			tmp.setZrateid(segmentinfo.getZrateid());
			
			flag++;
		}
		
		if(segmentinfo.getFlightmodel()!=null){
			tmp.setFlightmodel(segmentinfo.getFlightmodel());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSegmentinfo",tmp);
		}
	}
	
	/**
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfo(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Segmentinfo.COL_language+" = 0 OR "+Segmentinfo.COL_language+" is NULL)";
		}
		else if(where.indexOf(Segmentinfo.COL_language)<0)
		{
			where+=" and ("+Segmentinfo.COL_language+" = 0 OR "+Segmentinfo.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSegmentinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程表
	 * @param id
	 * @return
	 */
	public Segmentinfo findSegmentinfo(long id){
		return (Segmentinfo)(getSqlMapClientTemplate().queryForObject("findSegmentinfo",id));
	}
	/**
	 * 查找 行程表 by language
	 * @param id
	 * @return
	 */
	public Segmentinfo findSegmentinfobylanguage(long id,Integer language){
		String where = " where 1=1 and "+Segmentinfo.COL_ucode+" = "+id+" and "+Segmentinfo.COL_language+" = "+language;	
		List list=findAllSegmentinfo(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Segmentinfo)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 行程表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSegmentinfo(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Segmentinfo.COL_language+" = 0";
		}
		else if(where.indexOf(Segmentinfo.COL_language)<0)
		{
			where+=" and "+Segmentinfo.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSegmentinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSegmentinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSegmentinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSegmentinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSegmentinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSegmentinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSegmentinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSegmentinfoBySql",map).toString()));
	}
}

