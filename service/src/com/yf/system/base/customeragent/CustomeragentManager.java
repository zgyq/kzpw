/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeragent;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.bussiness.Bussiness;
import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomeragentManager extends  SqlMapClientDaoSupport  implements ICustomeragentManager{ 
	
  
 	/**
	 * 创建 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public Customeragent createCustomeragent(Customeragent customeragent) throws SQLException{
	
		if(customeragent.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		//customeragent.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERAGENT"));
		customeragent.setVmoney(0f);
		getSqlMapClientTemplate().insert("createCustomeragent",customeragent);
		return customeragent;
	}
	/**
	 * 删除 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeragent(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomeragent", id);
	}
	
	
	/**
	 * 修改 加盟商信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeragent(Customeragent customeragent){
		return getSqlMapClientTemplate().update("updateCustomeragent",customeragent);
	
	}

		
	/**
	 * 修改 加盟商信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeragentIgnoreNull(Customeragent customeragent){
		Customeragent tmp = findCustomeragent(customeragent.getId());
		int flag =0;
		
		if(customeragent.getVmoney()>-1){
			tmp.setVmoney(customeragent.getVmoney());
			flag++;
		}
		if(customeragent.getSearchnum()!=null&&customeragent.getSearchnum()>-1){
			tmp.setSearchnum(customeragent.getSearchnum());
			flag++;
		}
		if(customeragent.getSearchtoall()!=null&&customeragent.getSearchtoall()>-1){
			tmp.setSearchtoall(customeragent.getSearchtoall());
			flag++;
		}
		if(customeragent.getBeizhu()!=null){
			tmp.setBeizhu(customeragent.getBeizhu());
			
			flag++;
		}
		if(customeragent.getAllowlevelcount()>-2){
			tmp.setAllowlevelcount(customeragent.getAllowlevelcount());
			flag++;
		}
		
		if(customeragent.getAllowproxycount()>-2){
			tmp.setAllowproxycount(customeragent.getAllowproxycount());
			flag++;
		}		

		if(customeragent.getWorktimeend()!=null){
			tmp.setWorktimeend(customeragent.getWorktimeend());
			
			flag++;
		}
		
		if(customeragent.getAgentvsdate()!=null){
			tmp.setAgentvsdate(customeragent.getAgentvsdate());
			
			flag++;
		}
		if(customeragent.getType()!=null){
			tmp.setType(customeragent.getType());
			
			flag++;
		}
		if(customeragent.getFixedvalue()!=null){
			tmp.setFixedvalue(customeragent.getFixedvalue());
			
			flag++;
		}
		
		if(customeragent.getAgentvedate()!=null){
			tmp.setAgentvedate(customeragent.getAgentvedate());
			
			flag++;
		}
		if(customeragent.getRuntype()!=null){
			tmp.setRuntype(customeragent.getRuntype());
			
			flag++;
		}
		
		if(customeragent.getRunvalue()!=null){
			tmp.setRunvalue(customeragent.getRunvalue());
			
			flag++;
		}
		
		if(customeragent.getAgentcompanyname()!=null){
			tmp.setAgentcompanyname(customeragent.getAgentcompanyname());
			
			flag++;
		}
		
		if(customeragent.getAgentshortname()!=null){
			tmp.setAgentshortname(customeragent.getAgentshortname());
			
			flag++;
		}
		
		if(customeragent.getAgentcityid()!=null){
			tmp.setAgentcityid(customeragent.getAgentcityid());
			
			flag++;
		}
		if(customeragent.getCzcode()!=null){
			tmp.setCzcode(customeragent.getCzcode());
			
			flag++;
		}
		if(customeragent.getCacode()!=null){
			tmp.setCacode(customeragent.getCacode());
			
			flag++;
		}
		if(customeragent.getMucode()!=null){
			tmp.setMucode(customeragent.getMucode());
			
			flag++;
		}
		if(customeragent.getUserid()!=null){
			tmp.setUserid(customeragent.getUserid());
			
			flag++;
		}
		
		if(customeragent.getAgenttel()!=null){
			tmp.setAgenttel(customeragent.getAgenttel());
			
			flag++;
		}
		
		if(customeragent.getAgentaddress()!=null){
			tmp.setAgentaddress(customeragent.getAgentaddress());
			
			flag++;
		}
		
		if(customeragent.getAgentpostcode()!=null){
			tmp.setAgentpostcode(customeragent.getAgentpostcode());
			
			flag++;
		}
		
		if(customeragent.getAgentcontactname()!=null){
			tmp.setAgentcontactname(customeragent.getAgentcontactname());
			
			flag++;
		}
		
		if(customeragent.getAgentemail()!=null){
			tmp.setAgentemail(customeragent.getAgentemail());
			
			flag++;
		}
		
		if(customeragent.getAgentcheckstatus()!=null){
			tmp.setAgentcheckstatus(customeragent.getAgentcheckstatus());
			
			flag++;
		}
		
		if(customeragent.getAgentisenable()!=null){
			tmp.setAgentisenable(customeragent.getAgentisenable());
			
			flag++;
		}
		
		if(customeragent.getModifytime()!=null){
			tmp.setModifytime(customeragent.getModifytime());
			
			flag++;
		}
		
		if(customeragent.getIsallowmonthpay()!=null){
			tmp.setIsallowmonthpay(customeragent.getIsallowmonthpay());
			
			flag++;
		}
		
		if(customeragent.getModifyuser()!=null){
			tmp.setModifyuser(customeragent.getModifyuser());
			
			flag++;
		}
		
		if(customeragent.getCreatetime()!=null){
			tmp.setCreatetime(customeragent.getCreatetime());
			
			flag++;
		}
		
		if(customeragent.getCreateuser()!=null){
			tmp.setCreateuser(customeragent.getCreateuser());
			
			flag++;
		}
		
		if(customeragent.getParentid()!=null){
			tmp.setParentid(customeragent.getParentid());
			
			flag++;
		}
		
		if(customeragent.getParentstr()!=null){
			tmp.setParentstr(customeragent.getParentstr());
			
			flag++;
		}
		
		if(customeragent.getBrokenum()!=null){
			tmp.setBrokenum(customeragent.getBrokenum());
			
			flag++;
		}
		
		if(customeragent.getChildbrokenum()!=null){
			tmp.setChildbrokenum(customeragent.getChildbrokenum());
			
			flag++;
		}
		
		if(customeragent.getAlipayaccount()!=null){
			tmp.setAlipayaccount(customeragent.getAlipayaccount());
			
			flag++;
		}
		
		if(customeragent.getTenpayaccount()!=null){
			tmp.setTenpayaccount(customeragent.getTenpayaccount());
			
			flag++;
		}
		
		if(customeragent.getkuaibillaccount()!=null){
			tmp.setkuaibillaccount(customeragent.getkuaibillaccount());
			
			flag++;
		}
		
		if(customeragent.getMsnqq()!=null){
			tmp.setMsnqq(customeragent.getMsnqq());
			
			flag++;
		}
		if(customeragent.getBigtype()!=null){
			tmp.setBigtype(customeragent.getBigtype());
			
			flag++;
		}
		
		if(customeragent.getWebsite()!=null){
			tmp.setWebsite(customeragent.getWebsite());
			
			flag++;
		}

		if(customeragent.getAgentphone()!=null){
			tmp.setAgentphone(customeragent.getAgentphone());
			
			flag++;
		}
		
		if(customeragent.getAgenrfax()!=null){
			tmp.setAgenrfax(customeragent.getAgenrfax());
			
			flag++;
		}
		
		if(customeragent.getAgentmobile()!=null){
			tmp.setAgentmobile(customeragent.getAgentmobile());
			
			flag++;
		}
		
		if(customeragent.getAgentother()!=null){
			tmp.setAgentother(customeragent.getAgentother());
			
			flag++;
		}
		
		if(customeragent.getIndustry()!=null){
			tmp.setIndustry(customeragent.getIndustry());
			
			flag++;
		}
		
		if(customeragent.getFinancename()!=null){
			tmp.setFinancename(customeragent.getFinancename());
			
			flag++;
		}
		
		if(customeragent.getFinancephone()!=null){
			tmp.setFinancephone(customeragent.getFinancephone());
			
			flag++;
		}
		
		if(customeragent.getFinancefax()!=null){
			tmp.setFinancefax(customeragent.getFinancefax());
			
			flag++;
		}
		
		if(customeragent.getFinancemobile()!=null){
			tmp.setFinancemobile(customeragent.getFinancemobile());
			
			flag++;
		}
		
		if(customeragent.getFinanceemail()!=null){
			tmp.setFinanceemail(customeragent.getFinanceemail());
			
			flag++;
		}
		
		
		
		if(customeragent.getAirportcode()!=null){
			tmp.setAirportcode(customeragent.getAirportcode());
			
			flag++;
		}
		
		if(customeragent.getIsmodifyret()!=null){
			tmp.setIsmodifyret(customeragent.getIsmodifyret());
			
			flag++;
		}
		
		if(customeragent.getWorktimebegin()!=null){
			tmp.setWorktimebegin(customeragent.getWorktimebegin());
			
			flag++;
		}
		
		if(customeragent.getSmsmoney()!=null){
			tmp.setSmsmoney(customeragent.getSmsmoney());
			
			flag++;
		}
		

		if(customeragent.getAgentjibie()!=null){
			tmp.setAgentjibie(customeragent.getAgentjibie());
			
			flag++;
		}
		
		if(customeragent.getCityid()!=null){
			tmp.setCityid(customeragent.getCityid());
			
			flag++;
		}
		
		if(customeragent.getVmoney()>-1){
			tmp.setVmoney(customeragent.getVmoney());
			
			flag++;
		}
		
		if(customeragent.getOutticketmantel()!=null){
			tmp.setOutticketmantel(customeragent.getOutticketmantel());
			flag++;
		}
		
		if(customeragent.getOutticketmanmsnqq()!=null){
			tmp.setOutticketmanmsnqq(customeragent.getOutticketmanmsnqq());
			flag++;
		}
		if(customeragent.getBackticketmantel()!=null){
			tmp.setBackticketmantel(customeragent.getBackticketmantel());
			flag++;
		}
		
		if(customeragent.getBackticketmanmsnqq()!=null){
			tmp.setBackticketmanmsnqq(customeragent.getBackticketmanmsnqq());
			flag++;
		}
		
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomeragent",tmp);
		}
	}
	
	/**
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomeragent",map, offset, limit);
	}
		
	
	/**
	 * 查找 加盟商信息表
	 * @param id
	 * @return
	 */
	public Customeragent findCustomeragent(long id){
		//System.out.println("ooooooooooooooo");
		Customeragent customeragent=	(Customeragent)(getSqlMapClientTemplate().queryForObject("findCustomeragent",id));
	
		return customeragent;
	}
	
	/** 
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeragentBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomeragent",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找加盟商信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomeragentBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 加盟商信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeragentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomeragentBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeragentBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeragentBySql",map).toString()));
	}
}

