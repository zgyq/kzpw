/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passenger;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PassengerManager extends  SqlMapClientDaoSupport  implements IPassengerManager{ 
	
  
 	/**
	 * 创建 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Passenger createPassenger(Passenger passenger) throws SQLException{
	
		if(passenger.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
	    ////将不再使用 此种 获取ID 方法。by：小陈
		//passenger.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PASSENGER"));
		getSqlMapClientTemplate().insert("createPassenger",passenger);
		if(passenger.getUcode()==null||passenger.getUcode()<1)
		{
			passenger.setUcode(passenger.getId());
			updatePassengerIgnoreNull(passenger);
		}
		return passenger;
	}
	/**
	 * 删除 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassenger(long id){
	
		return getSqlMapClientTemplate().delete("deletePassenger", id);
	}
	
	
	/**
	 * 修改 乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updatePassenger(Passenger passenger){
		return getSqlMapClientTemplate().update("updatePassenger",passenger);
	
	}

		
	/**
	 * 修改 乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerIgnoreNull(Passenger passenger){
		Passenger tmp = findPassenger(passenger.getId());
		int flag =0;
		
		
		if(passenger.getOrderid()!=null){
			tmp.setOrderid(passenger.getOrderid());
			
			flag++;
		}
		
		if(passenger.getName()!=null){
			tmp.setName(passenger.getName());
			
			flag++;
		}
		
		if(passenger.getPtype()!=null){
			tmp.setPtype(passenger.getPtype());
			
			flag++;
		}
		
		if(passenger.getMsgtype()!=null){
			tmp.setMsgtype(passenger.getMsgtype());
			flag++;
		}
		
		if(passenger.getRepaytime()!=null){
			tmp.setRepaytime(passenger.getRepaytime());
			flag++;
		}
		if(passenger.getTickettypeid()!=null){
			tmp.setTickettypeid(passenger.getTickettypeid());
			flag++;
		}
		
		if(passenger.getIdtype()!=null){
			tmp.setIdtype(passenger.getIdtype());
			
			flag++;
		}
		
		if(passenger.getIdnumber()!=null){
			tmp.setIdnumber(passenger.getIdnumber());
			
			flag++;
		}
		
		if(passenger.getPrice()!=null){
			tmp.setPrice(passenger.getPrice());
			
			flag++;
		}
		
		if(passenger.getFuelprice()!=null){
			tmp.setFuelprice(passenger.getFuelprice());
			
			flag++;
		}
		
		if(passenger.getAirportfee()!=null){
			tmp.setAirportfee(passenger.getAirportfee());
			
			flag++;
		}
		
		if(passenger.getDiscount()!=null){
			tmp.setDiscount(passenger.getDiscount());
			
			flag++;
		}
		
		if(passenger.getTicketnum()!=null){
			tmp.setTicketnum(passenger.getTicketnum());
			
			flag++;
		}
		
		if(passenger.getFet()!=null){
			tmp.setFet(passenger.getFet());
			
			flag++;
		}
		
		if(passenger.getEi()!=null){
			tmp.setEi(passenger.getEi());
			
			flag++;
		}
		
		if(passenger.getState()!=null){
			tmp.setState(passenger.getState());
			
			flag++;
		}
		
		if(passenger.getTuifee()!=null){
			tmp.setTuifee(passenger.getTuifee());
			
			flag++;
		}
		
		if(passenger.getUcode()!=null){
			tmp.setUcode(passenger.getUcode());
			
			flag++;
		}
		
		if(passenger.getLanguage()!=null){
			tmp.setLanguage(passenger.getLanguage());
			
			flag++;
		}
		
	
		
		if(passenger.getRttime()!=null){
			tmp.setRttime(passenger.getRttime());
			
			flag++;
		}
		
		if(passenger.getTuitime()!=null){
			tmp.setTuitime(passenger.getTuitime());
			
			flag++;
		}
		
		if(passenger.getTuipiaoshouxufe()!=null){
			tmp.setTuipiaoshouxufe(passenger.getTuipiaoshouxufe());
			
			flag++;
		}
		
		if(passenger.getHkstate()!=null){
			tmp.setHkstate(passenger.getHkstate());
			
			flag++;
		}
		
		if(passenger.getYihai()!=null){
			tmp.setYihai(passenger.getYihai());
			
			flag++;
		}
		
		if(passenger.getHaiqian()!=null){
			tmp.setHaiqian(passenger.getHaiqian());
			
			flag++;
		}
		
		if(passenger.getTuifeiyuanyi()!=null){
			tmp.setTuifeiyuanyi(passenger.getTuifeiyuanyi());
			
			flag++;
		}
		
		if(passenger.getIscabinsite()!=null){
			tmp.setIscabinsite(passenger.getIscabinsite());
			
			flag++;
		}
		
		if(passenger.getTuifeidesc()!=null){
			tmp.setTuifeidesc(passenger.getTuifeidesc());
			
			flag++;
		}
		
		if(passenger.getBeizhu()!=null){
			tmp.setBeizhu(passenger.getBeizhu());
			
			flag++;
		}
		
		if(passenger.getTuifeitime()!=null){
			tmp.setTuifeitime(passenger.getTuifeitime());
			
			flag++;
		}
		
		if(passenger.getNotuidesc()!=null){
			tmp.setNotuidesc(passenger.getNotuidesc());
			
			flag++;
		}
		
		if(passenger.getTuiorfei()!=null){
			tmp.setTuiorfei(passenger.getTuiorfei());
			
			flag++;
		}
		
		if(passenger.getChangedate()!=null){
			tmp.setChangedate(passenger.getChangedate());
			
			flag++;
		}
		
		if(passenger.getChangeflight()!=null){
			tmp.setChangeflight(passenger.getChangeflight());
			
			flag++;
		}
		
		if(passenger.getChangecabin()!=null){
			tmp.setChangecabin(passenger.getChangecabin());
			
			flag++;
		}
		
		if(passenger.getChangepnr()!=null){
			tmp.setChangepnr(passenger.getChangepnr());
			
			flag++;
		}
		
		if(passenger.getMobile()!=null){
			tmp.setMobile(passenger.getMobile());
			
			flag++;
		}
		
		if(passenger.getTuipiaobili()!=null){
			tmp.setTuipiaobili(passenger.getTuipiaobili());
			
			flag++;
		}
		
		if(passenger.getAnjianfee()!=null){
			tmp.setAnjianfee(passenger.getAnjianfee());
			
			flag++;
		}
		
		if(passenger.getOtherfee()!=null){
			tmp.setOtherfee(passenger.getOtherfee());
			
			flag++;
		}
		
		if(passenger.getYuanprice()!=null){
			tmp.setYuanprice(passenger.getYuanprice());
			
			flag++;
		}
		
		if(passenger.getIsstudent()!=null){
			tmp.setIsstudent(passenger.getIsstudent());
			
			flag++;
		}
		
		if(passenger.getCardvaliddate()!=null){
			tmp.setCardvaliddate(passenger.getCardvaliddate());
			
			flag++;
		}
		
		
		if(passenger.getCountry()!=null){
			tmp.setCountry(passenger.getCountry());
			
			flag++;
		}
		
		if(passenger.getBirthday()!=null){
			tmp.setBirthday(passenger.getBirthday());
			
			flag++;
		}
		
		if(passenger.getDestzipcode()!=null){
			tmp.setDestzipcode(passenger.getDestzipcode());
			
			flag++;
		}
		
		if(passenger.getDestadress()!=null){
			tmp.setDestadress(passenger.getDestadress());
			
			flag++;
		}
		
		if(passenger.getLiveaddress()!=null){
			tmp.setLiveaddress(passenger.getLiveaddress());
			
			flag++;
		}
		if(passenger.getInsurprice()!=null){
			tmp.setInsurprice(passenger.getInsurprice());
				flag++;
		}
		if(passenger.getLirun()!=null){
			tmp.setLirun(passenger.getLirun());
			
			flag++;
		}
		
		
		
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePassenger",tmp);
		}
	}
	
	/**
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Passenger.COL_language+" = 0 OR "+Passenger.COL_language+" is NULL)";
		}
		else if(where.indexOf(Passenger.COL_language)<0)
		{
			where+=" and ("+Passenger.COL_language+" = 0 OR "+Passenger.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPassenger",map, offset, limit);
	}
		
	
	/**
	 * 查找 乘机人表
	 * @param id
	 * @return
	 */
	public Passenger findPassenger(long id){
		return (Passenger)(getSqlMapClientTemplate().queryForObject("findPassenger",id));
	}
	/**
	 * 查找 乘机人表 by language
	 * @param id
	 * @return
	 */
	public Passenger findPassengerbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Passenger.COL_ucode+" = "+id+" and "+Passenger.COL_language+" = "+language;	
		List list=findAllPassenger(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Passenger)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Passenger.COL_language+" = 0";
		}
		else if(where.indexOf(Passenger.COL_language)<0)
		{
			where+=" and "+Passenger.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPassengerBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPassenger",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPassengerBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePassengerBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPassengerBySql",map).toString()));
	}
}

