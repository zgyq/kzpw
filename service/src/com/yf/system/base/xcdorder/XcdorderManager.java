/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class XcdorderManager extends  SqlMapClientDaoSupport  implements IXcdorderManager{ 
	
  
 	/**
	 * 创建 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdorder createXcdorder(Xcdorder xcdorder) throws SQLException{
	
		if(xcdorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		xcdorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_XCDORDER"));
		getSqlMapClientTemplate().insert("createXcdorder",xcdorder);
		return xcdorder;
	}
	/**
	 * 删除 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteXcdorder", id);
	}
	
	
	/**
	 * 修改 行程单订单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdorder(Xcdorder xcdorder){
		return getSqlMapClientTemplate().update("updateXcdorder",xcdorder);
	
	}

		
	/**
	 * 修改 行程单订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdorderIgnoreNull(Xcdorder xcdorder){
		Xcdorder tmp = findXcdorder(xcdorder.getId());
		int flag =0;
		
		
		if(xcdorder.getTicketno()!=null){
			tmp.setTicketno(xcdorder.getTicketno());
			
			flag++;
		}
		
		if(xcdorder.getPnr()!=null){
			tmp.setPnr(xcdorder.getPnr());
			
			flag++;
		}
		
		if(xcdorder.getOrderid()!=null){
			tmp.setOrderid(xcdorder.getOrderid());
			
			flag++;
		}
		
		if(xcdorder.getPassid()!=null){
			tmp.setPassid(xcdorder.getPassid());
			
			flag++;
		}
		
		if(xcdorder.getXcdinfoid()!=null){
			tmp.setXcdinfoid(xcdorder.getXcdinfoid());
			
			flag++;
		}
		
		if(xcdorder.getXcdinfo()!=null){
			tmp.setXcdinfo(xcdorder.getXcdinfo());
			
			flag++;
		}
		
		if(xcdorder.getOfficecode()!=null){
			tmp.setOfficecode(xcdorder.getOfficecode());
			
			flag++;
		}
		
		if(xcdorder.getCompanyname()!=null){
			tmp.setCompanyname(xcdorder.getCompanyname());
			
			flag++;
		}
		
		if(xcdorder.getAgentid()!=null){
			tmp.setAgentid(xcdorder.getAgentid());
			
			flag++;
		}
		
		if(xcdorder.getUserid()!=null){
			tmp.setUserid(xcdorder.getUserid());
			
			flag++;
		}
		
		if(xcdorder.getParam1()!=null){
			tmp.setParam1(xcdorder.getParam1());
			
			flag++;
		}
		
		if(xcdorder.getParam2()!=null){
			tmp.setParam2(xcdorder.getParam2());
			
			flag++;
		}
		
		if(xcdorder.getParam3()!=null){
			tmp.setParam3(xcdorder.getParam3());
			
			flag++;
		}
		
		if(xcdorder.getCreatetime()!=null){
			tmp.setCreatetime(xcdorder.getCreatetime());
			
			flag++;
		}
		
		if(xcdorder.getState()!=null){
			tmp.setState(xcdorder.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateXcdorder",tmp);
		}
	}
	
	/**
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllXcdorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 行程单订单
	 * @param id
	 * @return
	 */
	public Xcdorder findXcdorder(long id){
		return (Xcdorder)(getSqlMapClientTemplate().queryForObject("findXcdorder",id));
	}
	
	/** 
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllXcdorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找行程单订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllXcdorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 行程单订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteXcdorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countXcdorderBySql",map).toString()));
	}
}

