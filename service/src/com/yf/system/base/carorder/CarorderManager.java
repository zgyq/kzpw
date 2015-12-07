/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarorderManager extends  SqlMapClientDaoSupport  implements ICarorderManager{ 
	
  
 	/**
	 * 创建 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public Carorder createCarorder(Carorder carorder) throws SQLException{
	
		if(carorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARORDER"));
		getSqlMapClientTemplate().insert("createCarorder",carorder);
		return carorder;
	}
	/**
	 * 删除 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarorder", id);
	}
	
	
	/**
	 * 修改 租车订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCarorder(Carorder carorder){
		return getSqlMapClientTemplate().update("updateCarorder",carorder);
	
	}

		
	/**
	 * 修改 租车订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarorderIgnoreNull(Carorder carorder){
		Carorder tmp = findCarorder(carorder.getId());
		int flag =0;
		
		
		if(carorder.getCarid()!=null){
			tmp.setCarid(carorder.getCarid());
			
			flag++;
		}
		
		if(carorder.getProperty()!=null){
			tmp.setProperty(carorder.getProperty());
			
			flag++;
		}
		if(carorder.getBookuserid()!=null){
			tmp.setBookuserid(carorder.getBookuserid());
			
			flag++;
		}
		if(carorder.getScarstoreid()!=null){
			tmp.setScarstoreid(carorder.getScarstoreid());
			
			flag++;
		}
		if(carorder.getEcarstoreid()!=null){
			tmp.setEcarstoreid(carorder.getEcarstoreid());
			
			flag++;
		}
		
		if(carorder.getCarname()!=null){
			tmp.setCarname(carorder.getCarname());
			
			flag++;
		}
		
		if(carorder.getSdate()!=null){
			tmp.setSdate(carorder.getSdate());
			
			flag++;
		}
		
		if(carorder.getEnddate()!=null){
			tmp.setEnddate(carorder.getEnddate());
			
			flag++;
		}
		
		if(carorder.getScityid()!=null){
			tmp.setScityid(carorder.getScityid());
			
			flag++;
		}
		
		if(carorder.getEndcityid()!=null){
			tmp.setEndcityid(carorder.getEndcityid());
			
			flag++;
		}
		
		if(carorder.getPrice()!=null){
			tmp.setPrice(carorder.getPrice());
			
			flag++;
		}
		
		if(carorder.getPretime()!=null){
			tmp.setPretime(carorder.getPretime());
			
			flag++;
		}
		
		if(carorder.getManyday()!=null){
			tmp.setManyday(carorder.getManyday());
			
			flag++;
		}
		
		if(carorder.getPredesc()!=null){
			tmp.setPredesc(carorder.getPredesc());
			
			flag++;
		}
		
		if(carorder.getMembername()!=null){
			tmp.setMembername(carorder.getMembername());
			
			flag++;
		}
		
		if(carorder.getMembermobile()!=null){
			tmp.setMembermobile(carorder.getMembermobile());
			
			flag++;
		}
		
		if(carorder.getMemberid()!=null){
			tmp.setMemberid(carorder.getMemberid());
			
			flag++;
		}
		
		if(carorder.getCanclereason()!=null){
			tmp.setCanclereason(carorder.getCanclereason());
			
			flag++;
		}
		
		if(carorder.getState()!=null){
			tmp.setState(carorder.getState());
			
			flag++;
		}
		
		if(carorder.getLinkname()!=null){
			tmp.setLinkname(carorder.getLinkname());
			
			flag++;
		}
		
		if(carorder.getLinkmobile()!=null){
			tmp.setLinkmobile(carorder.getLinkmobile());
			
			flag++;
		}
		
		if(carorder.getLinkmail()!=null){
			tmp.setLinkmail(carorder.getLinkmail());
			
			flag++;
		}
		
		if(carorder.getLinktell()!=null){
			tmp.setLinktell(carorder.getLinktell());
			
			flag++;
		}
		
		if(carorder.getConfirmmethod()!=null){
			tmp.setConfirmmethod(carorder.getConfirmmethod());
			
			flag++;
		}
		
		if(carorder.getSpecreq()!=null){
			tmp.setSpecreq(carorder.getSpecreq());
			
			flag++;
		}
		
		if(carorder.getCode()!=null){
			tmp.setCode(carorder.getCode());
			
			flag++;
		}
		
		if(carorder.getJprice()!=null){
			tmp.setJprice(carorder.getJprice());
			
			flag++;
		}
		
		if(carorder.getGps()!=null){
			tmp.setGps(carorder.getGps());
			
			flag++;
		}
		
		if(carorder.getInsurancefee()!=null){
			tmp.setInsurancefee(carorder.getInsurancefee());
			
			flag++;
		}
		
		if(carorder.getServicefee()!=null){
			tmp.setServicefee(carorder.getServicefee());
			
			flag++;
		}
		
		if(carorder.getPreauthfee()!=null){
			tmp.setPreauthfee(carorder.getPreauthfee());
			
			flag++;
		}
		
		if(carorder.getGpsfee()!=null){
			tmp.setGpsfee(carorder.getGpsfee());
			
			flag++;
		}
		
		if(carorder.getMile()!=null){
			tmp.setMile(carorder.getMile());
			
			flag++;
		}
		
		if(carorder.getPickupservicefee()!=null){
			tmp.setPickupservicefee(carorder.getPickupservicefee());
			
			flag++;
		}
		
		if(carorder.getDropoffservicefee()!=null){
			tmp.setDropoffservicefee(carorder.getDropoffservicefee());
			
			flag++;
		}
		
		if(carorder.getTicketfee()!=null){
			tmp.setTicketfee(carorder.getTicketfee());
			
			flag++;
		}
		
		if(carorder.getCarcode()!=null){
			tmp.setCarcode(carorder.getCarcode());
			
			flag++;
		}
		
		if(carorder.getOrderfee()!=null){
			tmp.setOrderfee(carorder.getOrderfee());
			
			flag++;
		}
		
		if(carorder.getWaicode()!=null){
			tmp.setWaicode(carorder.getWaicode());
			
			flag++;
		}
		
		if(carorder.getNuber()!=null){
			tmp.setNuber(carorder.getNuber());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarorder",tmp);
		}
	}
	
	/**
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 租车订单
	 * @param id
	 * @return
	 */
	public Carorder findCarorder(long id){
		return (Carorder)(getSqlMapClientTemplate().queryForObject("findCarorder",id));
	}
	
	/** 
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找租车订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 租车订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarorderBySql",map).toString()));
	}
}

