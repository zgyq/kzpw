/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotel;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelManager extends  SqlMapClientDaoSupport  implements IHotelManager{ 
	
  
 	/**
	 * 创建 酒店
	 * @param id
	 * @return deleted count 
	 */
	public Hotel createHotel(Hotel hotel) throws SQLException{
	
		if(hotel.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotel.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTEL"));
		getSqlMapClientTemplate().insert("createHotel",hotel);
		if(hotel.getUcode()==null||hotel.getUcode()<1)
		{
			hotel.setUcode(hotel.getId());
			updateHotelIgnoreNull(hotel);
		}
		return hotel;
	}
	/**
	 * 删除 酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotel(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotel", id);
	}
	
	
	/**
	 * 修改 酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateHotel(Hotel hotel){
		return getSqlMapClientTemplate().update("updateHotel",hotel);
	
	}

		
	/**
	 * 修改 酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelIgnoreNull(Hotel hotel){
		Hotel tmp = findHotel(hotel.getId());
		int flag =0;
		
		
		if(hotel.getName()!=null){
			tmp.setName(hotel.getName());
			
			flag++;
		}
		
		if(hotel.getEnname()!=null){
			tmp.setEnname(hotel.getEnname());
			
			flag++;
		}
		if(hotel.getPricetype()!=null){
			tmp.setPricetype(hotel.getPricetype());
			
			flag++;
			
		}
		
		if(hotel.getStar()!=null){
			tmp.setStar(hotel.getStar());
			
			flag++;
		}
		
		if(hotel.getHot()!=null){
			tmp.setHot(hotel.getHot());
			
			flag++;
		}
		
		if(hotel.getRepair()!=null){
			tmp.setRepair(hotel.getRepair());
			
			flag++;
		}
		
		if(hotel.getContryid()!=null){
			tmp.setContryid(hotel.getContryid());
			
			flag++;
		}
		
		if(hotel.getProvinceid()!=null){
			tmp.setProvinceid(hotel.getProvinceid());
			
			flag++;
		}
		
		if(hotel.getCityid()!=null){
			tmp.setCityid(hotel.getCityid());
			
			flag++;
		}
		
		if(hotel.getRegionid1()!=null){
			tmp.setRegionid1(hotel.getRegionid1());
			
			flag++;
		}
		
		if(hotel.getRegionid2()!=null){
			tmp.setRegionid2(hotel.getRegionid2());
			
			flag++;
		}
		
		if(hotel.getRegionid3()!=null){
			tmp.setRegionid3(hotel.getRegionid3());
			
			flag++;
		}
		
		if(hotel.getAddress()!=null){
			tmp.setAddress(hotel.getAddress());
			
			flag++;
		}
		
		if(hotel.getDescription()!=null){
			tmp.setDescription(hotel.getDescription());
			
			flag++;
		}
		
		if(hotel.getType()!=null){
			tmp.setType(hotel.getType());
			
			flag++;
		}
		
		if(hotel.getRooms()!=null){
			tmp.setRooms(hotel.getRooms());
			
			flag++;
		}
		
		if(hotel.getFootitem()!=null){
			tmp.setFootitem(hotel.getFootitem());
			
			flag++;
		}
		
		if(hotel.getServiceitem()!=null){
			tmp.setServiceitem(hotel.getServiceitem());
			
			flag++;
		}
		
		if(hotel.getMeetingitem()!=null){
			tmp.setMeetingitem(hotel.getMeetingitem());
			
			flag++;
		}
		
		if(hotel.getPlayitem()!=null){
			tmp.setPlayitem(hotel.getPlayitem());
			
			flag++;
		}
		
		if(hotel.getCarttype()!=null){
			tmp.setCarttype(hotel.getCarttype());
			
			flag++;
		}
		
		if(hotel.getRepaildate()!=null){
			tmp.setRepaildate(hotel.getRepaildate());
			
			flag++;
		}
		
		if(hotel.getNearhotel()!=null){
			tmp.setNearhotel(hotel.getNearhotel());
			
			flag++;
		}
		
		if(hotel.getPostcode()!=null){
			tmp.setPostcode(hotel.getPostcode());
			
			flag++;
		}
		
		if(hotel.getState()!=null){
			tmp.setState(hotel.getState());
			
			flag++;
		}
		
		if(hotel.getPyname()!=null){
			tmp.setPyname(hotel.getPyname());
			
			flag++;
		}
		
		if(hotel.getJpname()!=null){
			tmp.setJpname(hotel.getJpname());
			
			flag++;
		}
		
		if(hotel.getMainfloor()!=null){
			tmp.setMainfloor(hotel.getMainfloor());
			
			flag++;
		}
		
		if(hotel.getWebsign()!=null){
			tmp.setWebsign(hotel.getWebsign());
			
			flag++;
		}
		
		if(hotel.getOpendate()!=null){
			tmp.setOpendate(hotel.getOpendate());
			
			flag++;
		}
		
		if(hotel.getFaxdesc()!=null){
			tmp.setFaxdesc(hotel.getFaxdesc());
			
			flag++;
		}
		
		if(hotel.getMarkettell()!=null){
			tmp.setMarkettell(hotel.getMarkettell());
			
			flag++;
		}
		
		if(hotel.getTortell()!=null){
			tmp.setTortell(hotel.getTortell());
			
			flag++;
		}
		
		if(hotel.getPrespec()!=null){
			tmp.setPrespec(hotel.getPrespec());
			
			flag++;
		}
		
		if(hotel.getAppendlever()!=null){
			tmp.setAppendlever(hotel.getAppendlever());
			
			flag++;
		}
		
		if(hotel.getMainlevel()!=null){
			tmp.setMainlevel(hotel.getMainlevel());
			
			flag++;
		}
		
		if(hotel.getStatedesc()!=null){
			tmp.setStatedesc(hotel.getStatedesc());
			
			flag++;
		}
		
		if(hotel.getSellpoint()!=null){
			tmp.setSellpoint(hotel.getSellpoint());
			
			flag++;
		}
		
		if(hotel.getFullname()!=null){
			tmp.setFullname(hotel.getFullname());
			
			flag++;
		}
		
		if(hotel.getOpenbank()!=null){
			tmp.setOpenbank(hotel.getOpenbank());
			
			flag++;
		}
		
		if(hotel.getBankaccount()!=null){
			tmp.setBankaccount(hotel.getBankaccount());
			
			flag++;
		}
		
		if(hotel.getSort()!=null){
			tmp.setSort(hotel.getSort());
			
			flag++;
		}
		
		if(hotel.getCompanyid()!=null){
			tmp.setCompanyid(hotel.getCompanyid());
			
			flag++;
		}
		
		if(hotel.getCheckdesc()!=null){
			tmp.setCheckdesc(hotel.getCheckdesc());
			
			flag++;
		}
		
		if(hotel.getFax2()!=null){
			tmp.setFax2(hotel.getFax2());
			
			flag++;
		}
		
		if(hotel.getFax1()!=null){
			tmp.setFax1(hotel.getFax1());
			
			flag++;
		}
		
		if(hotel.getStartprice()!=null){
			tmp.setStartprice(hotel.getStartprice());
			
			flag++;
		}
		
		if(hotel.getLng()!=null){
			tmp.setLng(hotel.getLng());
			
			flag++;
		}
		
		if(hotel.getLat()!=null){
			tmp.setLat(hotel.getLat());
			
			flag++;
		}
		
		if(hotel.getUcode()!=null){
			tmp.setUcode(hotel.getUcode());
			
			flag++;
		}
		
		if(hotel.getLanguage()!=null){
			tmp.setLanguage(hotel.getLanguage());
			
			flag++;
		}
		
		if(hotel.getCountryid()!=null){
			tmp.setCountryid(hotel.getCountryid());
			
			flag++;
		}
		
		if(hotel.getSourcetype()!=null){
			tmp.setSourcetype(hotel.getSourcetype());
			
			flag++;
		}
		
		if(hotel.getHotelcode()!=null){
			tmp.setHotelcode(hotel.getHotelcode());
			
			flag++;
		}
		
		if(hotel.getAirportservice()!=null){
			tmp.setAirportservice(hotel.getAirportservice());
			
			flag++;
		}
		
		if(hotel.getTrafficinfo()!=null){
			tmp.setTrafficinfo(hotel.getTrafficinfo());
			
			flag++;
		}
		
		if(hotel.getPaytype()!=null){
			tmp.setPaytype(hotel.getPaytype());
			
			flag++;
		}
		
		if(hotel.getChecktype()!=null){
			tmp.setChecktype(hotel.getChecktype());
			
			flag++;
		}

		if(hotel.getRebateway()!=null){
			tmp.setRebateway(hotel.getRebateway());
			
			flag++;
		}
		
		if(hotel.getRulesback()!=null){
			tmp.setRulesback(hotel.getRulesback());
			
			flag++;
		}
		
		if(hotel.getPayment()!=null){
			tmp.setPayment(hotel.getPayment());
			
			flag++;
		}
		
		if(hotel.getChaininfoid()!=null){
			tmp.setChaininfoid(hotel.getChaininfoid());
			
			flag++;
		}
		
		if(hotel.getMeneyback()!=null){
			tmp.setMeneyback(hotel.getMeneyback());
			
			flag++;
		}
		
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotel",tmp);
		}
	}
	
	/**
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String where, String orderby,int limit,int offset){
	
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotel",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店
	 * @param id
	 * @return
	 */
	public Hotel findHotel(long id){
		return (Hotel)(getSqlMapClientTemplate().queryForObject("findHotel",id));
	}
	/**
	 * 查找 酒店 by language
	 * @param id
	 * @return
	 */
	public Hotel findHotelbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Hotel.COL_ucode+" = "+id+" and "+Hotel.COL_language+" = "+language;	
		List list=findAllHotel(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Hotel)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotel(String where, String orderby,PageInfo pageinfo){
		
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotel",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotel(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelBySql",map).toString()));
	}
}

