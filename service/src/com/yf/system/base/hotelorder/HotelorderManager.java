/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
 
package com.yf.system.base.hotelorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;


public class HotelorderManager extends  SqlMapClientDaoSupport  implements IHotelorderManager{ 
	
  
 	/**
	 * 创建 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public Hotelorder createHotelorder(Hotelorder hotelorder) throws SQLException{
	
		if(hotelorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELORDER"));
		getSqlMapClientTemplate().insert("createHotelorder",hotelorder);
		return hotelorder;
	}
	/**
	 * 删除 酒店订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelorder", id);
	}
	
	
	/**
	 * 修改 酒店订单
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelorder(Hotelorder hotelorder){
		return getSqlMapClientTemplate().update("updateHotelorder",hotelorder);
	
	}

		
	/**
	 * 修改 酒店订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelorderIgnoreNull(Hotelorder hotelorder){
		Hotelorder tmp = findHotelorder(hotelorder.getId());
		int flag =0;
		
		
		if(hotelorder.getName()!=null){
			tmp.setName(hotelorder.getName());
			
			flag++;
		}
		
		if(hotelorder.getHotelid()!=null){
			tmp.setHotelid(hotelorder.getHotelid());
			
			flag++;
		}
		if(hotelorder.getProfits()!=null){
			tmp.setProfits(hotelorder.getProfits());
			flag++;
		}
		if(hotelorder.getPricecurrency()!=null){
			tmp.setPricecurrency(hotelorder.getPricecurrency());
			flag++;
		}
		
		if(hotelorder.getPricecodeid()!=null){
			tmp.setPricecodeid(hotelorder.getPricecodeid());
			flag++;
		}
		
		if(hotelorder.getPricecodename()!=null){
			tmp.setPricecodename(hotelorder.getPricecodename());
			flag++;
		}
		
		if(hotelorder.getFanprice()!=null){
			tmp.setFanprice(hotelorder.getFanprice());
			
			flag++;
		}
		if(hotelorder.getCreateuserid()!=null){
			tmp.setCreateuserid(hotelorder.getCreateuserid());
			
			flag++;
		}
		if(hotelorder.getYufuprice()!=null){
			tmp.setYufuprice(hotelorder.getYufuprice());
			
			flag++;
		}
		if(hotelorder.getXianfuprice()!=null){
			tmp.setXianfuprice(hotelorder.getXianfuprice());
			
			flag++;
		}
		if(hotelorder.getYestate()!=null){
			tmp.setYestate(hotelorder.getYestate());
			
			flag++;
		}
		
		if(hotelorder.getOrderid()!=null){
			tmp.setOrderid(hotelorder.getOrderid());
			
			flag++;
		}
		
		if(hotelorder.getProperty()!=null){
			tmp.setProperty(hotelorder.getProperty());
			
			flag++;
		}
		
		if(hotelorder.getRoomtypename()!=null){
			tmp.setRoomtypename(hotelorder.getRoomtypename());
			
			flag++;
		}
		
		if(hotelorder.getRoomid()!=null){
			tmp.setRoomid(hotelorder.getRoomid());
			
			flag++;
		}
		if(hotelorder.getBaoliutime()!=null){
			tmp.setBaoliutime(hotelorder.getBaoliutime());
			
			flag++;
		}
		if(hotelorder.getShijitime()!=null){
			tmp.setShijitime(hotelorder.getShijitime());
			
			flag++;
		}
		
		if(hotelorder.getComedate()!=null){
			tmp.setComedate(hotelorder.getComedate());
			
			flag++;
		}
		
		if(hotelorder.getLeavedate()!=null){
			tmp.setLeavedate(hotelorder.getLeavedate());
			
			flag++;
		}
		
		if(hotelorder.getOrderpeaple()!=null){
			tmp.setOrderpeaple(hotelorder.getOrderpeaple());
			
			flag++;
		}
		
		if(hotelorder.getManyday()!=null){
			tmp.setManyday(hotelorder.getManyday());
			
			flag++;
		}
		
		if(hotelorder.getPrice()!=null){
			tmp.setPrice(hotelorder.getPrice());
			
			flag++;
		}
		
		if(hotelorder.getPredesc()!=null){
			tmp.setPredesc(hotelorder.getPredesc());
			
			flag++;
		}
		
		if(hotelorder.getPretime()!=null){
			tmp.setPretime(hotelorder.getPretime());
			
			flag++;
		}
		
		if(hotelorder.getMembername()!=null){
			tmp.setMembername(hotelorder.getMembername());
			
			flag++;
		}
		
		if(hotelorder.getMembermobile()!=null){
			tmp.setMembermobile(hotelorder.getMembermobile());
			
			flag++;
		}
		
		if(hotelorder.getMemberid()!=null){
			tmp.setMemberid(hotelorder.getMemberid());
			
			flag++;
		}
		
		if(hotelorder.getVersion()!=null){
			tmp.setVersion(hotelorder.getVersion());
			
			flag++;
		}
		
		if(hotelorder.getCanclereason()!=null){
			tmp.setCanclereason(hotelorder.getCanclereason());
			
			flag++;
		}
		
		if(hotelorder.getState()!=null){
			tmp.setState(hotelorder.getState());
			
			flag++;
		}
		
		if(hotelorder.getLinkname()!=null){
			tmp.setLinkname(hotelorder.getLinkname());
			
			flag++;
		}
		
		if(hotelorder.getLinkmobile()!=null){
			tmp.setLinkmobile(hotelorder.getLinkmobile());
			
			flag++;
		}
		
		if(hotelorder.getLinkmail()!=null){
			tmp.setLinkmail(hotelorder.getLinkmail());
			
			flag++;
		}
		
		if(hotelorder.getLinktell()!=null){
			tmp.setLinktell(hotelorder.getLinktell());
			
			flag++;
		}
		
		if(hotelorder.getConfirmmethod()!=null){
			tmp.setConfirmmethod(hotelorder.getConfirmmethod());
			
			flag++;
		}
		
		if(hotelorder.getReservstart()!=null){
			tmp.setReservstart(hotelorder.getReservstart());
			
			flag++;
		}
		
		if(hotelorder.getReservend()!=null){
			tmp.setReservend(hotelorder.getReservend());
			
			flag++;
		}
		
		if(hotelorder.getSpecreq()!=null){
			tmp.setSpecreq(hotelorder.getSpecreq());
			
			flag++;
		}
		
		if(hotelorder.getPrerooms()!=null){
			tmp.setPrerooms(hotelorder.getPrerooms());
			
			flag++;
		}
		
		if(hotelorder.getCheckdesc()!=null){
			tmp.setCheckdesc(hotelorder.getCheckdesc());
			
			flag++;
		}
		
		if(hotelorder.getFaxsendtime()!=null){
			tmp.setFaxsendtime(hotelorder.getFaxsendtime());
			
			flag++;
		}
		
		if(hotelorder.getCode()!=null){
			tmp.setCode(hotelorder.getCode());
			
			flag++;
		}
		
		if(hotelorder.getResultvalue()!=null){
			tmp.setResultvalue(hotelorder.getResultvalue());
			
			flag++;
		}
		
		if(hotelorder.getResultcode()!=null){
			tmp.setResultcode(hotelorder.getResultcode());
			
			flag++;
		}
		
		if(hotelorder.getSystemuserid()!=null){
			tmp.setSystemuserid(hotelorder.getSystemuserid());
			
			flag++;
		}
		
		if(hotelorder.getType()!=null){
			tmp.setType(hotelorder.getType());
			
			flag++;
		}
		if(hotelorder.getPaytype()!=null){
			tmp.setPaytype(hotelorder.getPaytype());
			
			flag++;
		}
		
		if(hotelorder.getChecktype()!=null){
			tmp.setChecktype(hotelorder.getChecktype());
			
			flag++;
		}
		
		if(hotelorder.getDayprice()!=null){
			tmp.setDayprice(hotelorder.getDayprice());
			
			flag++;
		}
		
		if(hotelorder.getIshotelpay()!=null){
			tmp.setIshotelpay(hotelorder.getIshotelpay());
			
			flag++;
		}

		
		if(hotelorder.getPaystate()!=null){
			tmp.setPaystate(hotelorder.getPaystate());
			
			flag++;
		}
		
		if(hotelorder.getPayment()!=null){
			tmp.setPayment(hotelorder.getPayment());
			
			flag++;
		}
		
		if(hotelorder.getActualmount()!=null){
			tmp.setActualmount(hotelorder.getActualmount());
			
			flag++;
		}
		if(hotelorder.getWaicode()!=null){
			tmp.setWaicode(hotelorder.getWaicode());
			
			flag++;
		}
		if(hotelorder.getNumber()!=null){
			tmp.setNumber(hotelorder.getNumber());
			
			flag++;
		}
		if(hotelorder.getSex()!=null){
			tmp.setSex(hotelorder.getSex());
			
			flag++;
		}
		if(hotelorder.getDanbao()!=null){
			tmp.setDanbao(hotelorder.getDanbao());
			
			flag++;
		}
		if(hotelorder.getCouponamount()!=null){
			tmp.setCouponamount(hotelorder.getCouponamount());
			
			flag++;
		}
		
		if(hotelorder.getOrdersource()!=null){
			tmp.setOrdersource(hotelorder.getOrdersource());
			
			flag++;
		}
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelorder",tmp);
		}
	}
	
	/**
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店订单
	 * @param id
	 * @return
	 */
	public Hotelorder findHotelorder(long id){
		return (Hotelorder)(getSqlMapClientTemplate().queryForObject("findHotelorder",id));
	}
	
	/** 
	 * 查找 酒店订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelorderBySql",map).toString()));
	}
}

