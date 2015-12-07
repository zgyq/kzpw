/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.charterorder;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CharterorderManager extends  SqlMapClientDaoSupport  implements ICharterorderManager{ 
	
  
 	/**
	 * 创建 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public Charterorder createCharterorder(Charterorder charterorder) throws SQLException{
	
		if(charterorder.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		charterorder.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CHARTERORDER"));
		getSqlMapClientTemplate().insert("createCharterorder",charterorder);
		return charterorder;
	}
	/**
	 * 删除 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCharterorder(long id){
	
		return getSqlMapClientTemplate().delete("deleteCharterorder", id);
	}
	
	
	/**
	 * 修改 包机订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCharterorder(Charterorder charterorder){
		return getSqlMapClientTemplate().update("updateCharterorder",charterorder);
	
	}

		
	/**
	 * 修改 包机订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCharterorderIgnoreNull(Charterorder charterorder){
		Charterorder tmp = findCharterorder(charterorder.getId());
		int flag =0;
		
		
		if(charterorder.getNum()!=null){
			tmp.setNum(charterorder.getNum());
			
			flag++;
		}
		
		if(charterorder.getMaxnum()!=null){
			tmp.setMaxnum(charterorder.getMaxnum());
			
			flag++;
		}
		if(charterorder.getServicetype()!=null){
			tmp.setServicetype(charterorder.getServicetype());
			
			flag++;
		}
		if(charterorder.getOrdercode()!=null){
			tmp.setOrdercode(charterorder.getOrdercode());
			
			flag++;
		}
		if(charterorder.getName()!=null){
			tmp.setName(charterorder.getName());
			
			flag++;
		}
		
		if(charterorder.getMobile()!=null){
			tmp.setMobile(charterorder.getMobile());
			
			flag++;
		}
		
		if(charterorder.getUnitname()!=null){
			tmp.setUnitname(charterorder.getUnitname());
			
			flag++;
		}
		
		if(charterorder.getAddress()!=null){
			tmp.setAddress(charterorder.getAddress());
			
			flag++;
		}
		
		if(charterorder.getZipcode()!=null){
			tmp.setZipcode(charterorder.getZipcode());
			
			flag++;
		}
		
		if(charterorder.getTel()!=null){
			tmp.setTel(charterorder.getTel());
			
			flag++;
		}
		
		if(charterorder.getQq()!=null){
			tmp.setQq(charterorder.getQq());
			
			flag++;
		}
		
		if(charterorder.getFax()!=null){
			tmp.setFax(charterorder.getFax());
			
			flag++;
		}
		
		if(charterorder.getMailbox()!=null){
			tmp.setMailbox(charterorder.getMailbox());
			
			flag++;
		}
		
		if(charterorder.getRemarks()!=null){
			tmp.setRemarks(charterorder.getRemarks());
			
			flag++;
		}
		
		if(charterorder.getPrice()!=null){
			tmp.setPrice(charterorder.getPrice());
			
			flag++;
		}
		
		if(charterorder.getCreatetime()!=null){
			tmp.setCreatetime(charterorder.getCreatetime());
			
			flag++;
		}
		
		if(charterorder.getMemberid()!=null){
			tmp.setMemberid(charterorder.getMemberid());
			
			flag++;
		}
		
		if(charterorder.getType()!=null){
			tmp.setType(charterorder.getType());
			
			flag++;
		}
		
		if(charterorder.getUsertype()!=null){
			tmp.setUsertype(charterorder.getUsertype());
			
			flag++;
		}
		
		if(charterorder.getStime()!=null){
			tmp.setStime(charterorder.getStime());
			
			flag++;
		}
		
		if(charterorder.getEtime()!=null){
			tmp.setEtime(charterorder.getEtime());
			
			flag++;
		}
		
		if(charterorder.getState()!=null){
			tmp.setState(charterorder.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCharterorder",tmp);
		}
	}
	
	/**
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorder(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCharterorder",map, offset, limit);
	}
		
	
	/**
	 * 查找 包机订单
	 * @param id
	 * @return
	 */
	public Charterorder findCharterorder(long id){
		return (Charterorder)(getSqlMapClientTemplate().queryForObject("findCharterorder",id));
	}
	
	/** 
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCharterorder(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCharterorderBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCharterorder",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找包机订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorder(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCharterorderBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 包机订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCharterorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCharterorderBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCharterorderBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCharterorderBySql",map).toString()));
	}
}

