/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sellreport;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SellreportManager extends  SqlMapClientDaoSupport  implements ISellreportManager{ 
	
  
 	/**
	 * 创建 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public Sellreport createSellreport(Sellreport sellreport) throws SQLException{
	
		if(sellreport.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		sellreport.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SELLREPORT"));
		getSqlMapClientTemplate().insert("createSellreport",sellreport);
		return sellreport;
	}
	/**
	 * 删除 销售报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSellreport(long id){
	
		return getSqlMapClientTemplate().delete("deleteSellreport", id);
	}
	
	
	/**
	 * 修改 销售报表
	 * @param id
	 * @return updated count 
	 */
	public int updateSellreport(Sellreport sellreport){
		return getSqlMapClientTemplate().update("updateSellreport",sellreport);
	
	}

		
	/**
	 * 修改 销售报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSellreportIgnoreNull(Sellreport sellreport){
		Sellreport tmp = findSellreport(sellreport.getId());
		int flag =0;
		
		
		if(sellreport.getRttime()!=null){
			tmp.setRttime(sellreport.getRttime());
			
			flag++;
		}
		
		if(sellreport.getOrdercode()!=null){
			tmp.setOrdercode(sellreport.getOrdercode());
			
			flag++;
		}
		
		if(sellreport.getXiaolv()!=null){
			tmp.setXiaolv(sellreport.getXiaolv());
			
			flag++;
		}
		
		if(sellreport.getUsername()!=null){
			tmp.setUsername(sellreport.getUsername());
			
			flag++;
		}
		
		if(sellreport.getPnr()!=null){
			tmp.setPnr(sellreport.getPnr());
			
			flag++;
		}
		
		if(sellreport.getNumber()!=null){
			tmp.setNumber(sellreport.getNumber());
			
			flag++;
		}
		
		if(sellreport.getRecognizance()!=null){
			tmp.setRecognizance(sellreport.getRecognizance());
			
			flag++;
		}
		
		if(sellreport.getSubprice()!=null){
			tmp.setSubprice(sellreport.getSubprice());
			
			flag++;
		}
		
		if(sellreport.getJingjia()!=null){
			tmp.setJingjia(sellreport.getJingjia());
			
			flag++;
		}
		
		if(sellreport.getJijianranyou()!=null){
			tmp.setJijianranyou(sellreport.getJijianranyou());
			
			flag++;
		}
		
		if(sellreport.getPoundage()!=null){
			tmp.setPoundage(sellreport.getPoundage());
			
			flag++;
		}
		
		if(sellreport.getPactprice()!=null){
			tmp.setPactprice(sellreport.getPactprice());
			
			flag++;
		}
		
		if(sellreport.getPaytype()!=null){
			tmp.setPaytype(sellreport.getPaytype());
			
			flag++;
		}
		
		if(sellreport.getOrdertype()!=null){
			tmp.setOrdertype(sellreport.getOrdertype());
			
			flag++;
		}
		
		if(sellreport.getTickettype()!=null){
			tmp.setTickettype(sellreport.getTickettype());
			
			flag++;
		}
		
		if(sellreport.getJourneytype()!=null){
			tmp.setJourneytype(sellreport.getJourneytype());
			
			flag++;
		}
		
		if(sellreport.getChupiaotype()!=null){
			tmp.setChupiaotype(sellreport.getChupiaotype());
			
			flag++;
		}
		
		if(sellreport.getOffice()!=null){
			tmp.setOffice(sellreport.getOffice());
			
			flag++;
		}
		
		if(sellreport.getPassenger()!=null){
			tmp.setPassenger(sellreport.getPassenger());
			
			flag++;
		}
		
		if(sellreport.getUsertype()!=null){
			tmp.setUsertype(sellreport.getUsertype());
			
			flag++;
		}
		
		if(sellreport.getStartcity()!=null){
			tmp.setStartcity(sellreport.getStartcity());
			
			flag++;
		}
		
		if(sellreport.getEndcity()!=null){
			tmp.setEndcity(sellreport.getEndcity());
			
			flag++;
		}
		
		if(sellreport.getSail()!=null){
			tmp.setSail(sellreport.getSail());
			
			flag++;
		}
		
		if(sellreport.getAircompany()!=null){
			tmp.setAircompany(sellreport.getAircompany());
			
			flag++;
		}
		
		if(sellreport.getFlightnumber()!=null){
			tmp.setFlightnumber(sellreport.getFlightnumber());
			
			flag++;
		}
		
		if(sellreport.getFlighttime()!=null){
			tmp.setFlighttime(sellreport.getFlighttime());
			
			flag++;
		}
		
		if(sellreport.getCabin()!=null){
			tmp.setCabin(sellreport.getCabin());
			
			flag++;
		}
		
		if(sellreport.getPolicy()!=null){
			tmp.setPolicy(sellreport.getPolicy());
			
			flag++;
		}
		
		if(sellreport.getPrice()!=null){
			tmp.setPrice(sellreport.getPrice());
			
			flag++;
		}
		
		if(sellreport.getLeafletsnet()!=null){
			tmp.setLeafletsnet(sellreport.getLeafletsnet());
			
			flag++;
		}
		
		if(sellreport.getJijian()!=null){
			tmp.setJijian(sellreport.getJijian());
			
			flag++;
		}
		
		if(sellreport.getRanyou()!=null){
			tmp.setRanyou(sellreport.getRanyou());
			
			flag++;
		}
		
		if(sellreport.getJiesuanprice()!=null){
			tmp.setJiesuanprice(sellreport.getJiesuanprice());
			
			flag++;
		}
		
		if(sellreport.getPayaircompany()!=null){
			tmp.setPayaircompany(sellreport.getPayaircompany());
			
			flag++;
		}
		
		if(sellreport.getZhifuleixing()!=null){
			tmp.setZhifuleixing(sellreport.getZhifuleixing());
			
			flag++;
		}
		
		if(sellreport.getLaiyuan()!=null){
			tmp.setLaiyuan(sellreport.getLaiyuan());
			
			flag++;
		}
		
		if(sellreport.getHoufan()!=null){
			tmp.setHoufan(sellreport.getHoufan());
			
			flag++;
		}
		
		if(sellreport.getShijilirun()!=null){
			tmp.setShijilirun(sellreport.getShijilirun());
			
			flag++;
		}
		
		if(sellreport.getFuwufei()!=null){
			tmp.setFuwufei(sellreport.getFuwufei());
			
			flag++;
		}
		
		if(sellreport.getRemark()!=null){
			tmp.setRemark(sellreport.getRemark());
			
			flag++;
		}
		
		if(sellreport.getPiaohao()!=null){
			tmp.setPiaohao(sellreport.getPiaohao());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSellreport",tmp);
		}
	}
	
	/**
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreport(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSellreport",map, offset, limit);
	}
		
	
	/**
	 * 查找 销售报表
	 * @param id
	 * @return
	 */
	public Sellreport findSellreport(long id){
		return (Sellreport)(getSqlMapClientTemplate().queryForObject("findSellreport",id));
	}
	
	/** 
	 * 查找 销售报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSellreport(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSellreportBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSellreport",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找销售报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSellreport(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSellreportBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 销售报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSellreportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSellreportBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSellreportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSellreportBySql",map).toString()));
	}
}

