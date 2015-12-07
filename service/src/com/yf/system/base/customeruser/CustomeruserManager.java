/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeruser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CustomeruserManager extends  SqlMapClientDaoSupport  implements ICustomeruserManager{ 
	
  
 	/**
	 * 创建 会员
	 * @param id
	 * @return deleted count 
	 */
	public Customeruser createCustomeruser(Customeruser customeruser) throws SQLException{
	
		if(customeruser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		if(customeruser.getMembername()!=null&&customeruser.getMembername().indexOf("$")>0){
			customeruser.getMembername().replace("$", "\\$");
		}
		customeruser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CUSTOMERUSER"));
		getSqlMapClientTemplate().insert("createCustomeruser",customeruser);
		return customeruser;
	}
	/**
	 * 删除 会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeruser(long id){
	
		return getSqlMapClientTemplate().delete("deleteCustomeruser", id);
	}
	
	
	/**
	 * 修改 会员
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeruser(Customeruser customeruser){
		return getSqlMapClientTemplate().update("updateCustomeruser",customeruser);
	
	}

		
	/**
	 * 修改 会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeruserIgnoreNull(Customeruser customeruser){
		Customeruser tmp = findCustomeruser(customeruser.getId());
		int flag =0;
		
		
//		if(customeruser.getCardnumber()!=null){
//			tmp.setCardnumber(customeruser.getCardnumber());
//			
//			flag++;
//		}
		if(customeruser.getPostalcode()!=null){
			tmp.setPostalcode(customeruser.getPostalcode());
			
			flag++;
		}
//		if(customeruser.getCardpassword()!=null){
//			tmp.setCardpassword(customeruser.getCardpassword());
//			
//			flag++;
//		}
		if(customeruser.getProfits()!=null){
			tmp.setProfits(customeruser.getProfits());
			
			flag++;
		}
		
		if(customeruser.getLoginname()!=null){
			tmp.setLoginname(customeruser.getLoginname());
			
			flag++;
		}
		
		if(customeruser.getLogpassword()!=null){
			tmp.setLogpassword(customeruser.getLogpassword());
			
			flag++;
		}
		
		if(customeruser.getMembername()!=null){
			tmp.setMembername(customeruser.getMembername());
			
			flag++;
		}
		
		if(customeruser.getMembersex()!=null){
			tmp.setMembersex(customeruser.getMembersex());
			
			flag++;
		}
		
		if(customeruser.getTotalscore()!=null){
			tmp.setTotalscore(customeruser.getTotalscore());
			
			flag++;
		}
		
		if(customeruser.getMemberemail()!=null){
			tmp.setMemberemail(customeruser.getMemberemail());
			
			flag++;
		}
		
		if(customeruser.getMobile()!=null){
			tmp.setMobile(customeruser.getMobile());
			
			flag++;
		}
		
		if(customeruser.getState()!=null){
			tmp.setState(customeruser.getState());
			
			flag++;
		}
		
		if(customeruser.getType()!=null){
			tmp.setType(customeruser.getType());
			
			flag++;
		}
		
		if(customeruser.getIsadmin()!=null){
			tmp.setIsadmin(customeruser.getIsadmin());
			
			flag++;
		}
		
		if(customeruser.getBirthday()!=null){
			tmp.setBirthday(customeruser.getBirthday());
			
			flag++;
		}
		
//		if(customeruser.getLocalcity()!=null){
//			tmp.setLocalcity(customeruser.getLocalcity());
//			
//			flag++;
//		}
		
		if(customeruser.getMemberfax()!=null){
			tmp.setMemberfax(customeruser.getMemberfax());
			
			flag++;
		}
//		
//		if(customeruser.getMemberdesc()!=null){
//			tmp.setMemberdesc(customeruser.getMemberdesc());
//			
//			flag++;
//		}
//		
		if(customeruser.getIsweb()!=null){
			tmp.setIsweb(customeruser.getIsweb());
			
			flag++;
		}
		
		if(customeruser.getMembermobile()!=null){
			tmp.setMembermobile(customeruser.getMembermobile());
			
			flag++;
		}
		
		if(customeruser.getIsenable()!=null){
			tmp.setIsenable(customeruser.getIsenable());
			
			flag++;
		}
		
		if(customeruser.getMembertype()!=null){
			tmp.setMembertype(customeruser.getMembertype());
			
			flag++;
		}
		
		if(customeruser.getAgentid()!=null){
			tmp.setAgentid(customeruser.getAgentid());
			
			flag++;
		}
		
		if(customeruser.getModifytime()!=null){
			tmp.setModifytime(customeruser.getModifytime());
			
			flag++;
		}
		
		if(customeruser.getModifyuser()!=null){
			tmp.setModifyuser(customeruser.getModifyuser());
			
			flag++;
		}
		
		if(customeruser.getCreatetime()!=null){
			tmp.setCreatetime(customeruser.getCreatetime());
			
			flag++;
		}
		
		if(customeruser.getCreateuser()!=null){
			tmp.setCreateuser(customeruser.getCreateuser());
			
			flag++;
		}
		
		if(customeruser.getDeptid()!=null){
			tmp.setDeptid(customeruser.getDeptid());
			
			flag++;
		}
//		
//		if(customeruser.getIsmanager()!=null){
//			tmp.setIsmanager(customeruser.getIsmanager());
//			
//			flag++;
//		}
		
		if(customeruser.getCardtype()!=null){
			tmp.setCardtype(customeruser.getCardtype());
			
			flag++;
		}
		
		if(customeruser.getCardnunber()!=null){
			tmp.setCardnunber(customeruser.getCardnunber());
			
			flag++;
		}
		
		if(customeruser.getWorkphone()!=null){
			tmp.setWorkphone(customeruser.getWorkphone());
			
			flag++;
		}
		
//		if(customeruser.getLinkother()!=null){
//			tmp.setLinkother(customeruser.getLinkother());
//			
//			flag++;
//		}
		
		if(customeruser.getDescription()!=null){
			tmp.setDescription(customeruser.getDescription());
			
			flag++;
		}
		if(customeruser.getEnname()!=null){
			tmp.setEnname(customeruser.getEnname());
			
			flag++;
		}
		
//		if(customeruser.getEntrytime()!=null){
//			tmp.setEntrytime(customeruser.getEntrytime());
//			
//			flag++;
//		}
//		
//		if(customeruser.getLivingcardtype()!=null){
//			tmp.setLivingcardtype(customeruser.getLivingcardtype());
//			
//			flag++;
//		}
//		
//		if(customeruser.getLivingcardnum()!=null){
//			tmp.setLivingcardnum(customeruser.getLivingcardnum());
//			
//			flag++;
//		}
//		
//		if(customeruser.getLivingperiod()!=null){
//			tmp.setLivingperiod(customeruser.getLivingperiod());
//			
//			flag++;
//		}
//		
		if(customeruser.getWorknumber()!=null){
			tmp.setWorknumber(customeruser.getWorknumber());
			
			flag++;
		}
//		
//		if(customeruser.getWorkperiod()!=null){
//			tmp.setWorkperiod(customeruser.getWorkperiod());
//			
//			flag++;
//		}
//		
		if(customeruser.getChinaaddress()!=null){
			tmp.setChinaaddress(customeruser.getChinaaddress());
			
			flag++;
		}
//		if(customeruser.getNationality()!=null){
//			tmp.setChinaaddress(customeruser.getNationality());			
//			flag++;
//		}
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCustomeruser",tmp);
		}
	}
	
	/**
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCustomeruser",map, offset, limit);
	}
		
	
	/**
	 * 查找 会员
	 * @param id
	 * @return
	 */
	public Customeruser findCustomeruser(long id){
		return (Customeruser)(getSqlMapClientTemplate().queryForObject("findCustomeruser",id));
	}
	
	/** 
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeruserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomeruser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCustomeruserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeruserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCustomeruserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeruserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeruserBySql",map).toString()));
	}
}

