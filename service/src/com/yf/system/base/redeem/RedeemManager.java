/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.redeem;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class RedeemManager extends  SqlMapClientDaoSupport  implements IRedeemManager{ 
	
  
 	/**
	 * 创建 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public Redeem createRedeem(Redeem redeem) throws SQLException{
	
		if(redeem.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		redeem.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_REDEEM"));
		getSqlMapClientTemplate().insert("createRedeem",redeem);
		return redeem;
	}
	/**
	 * 删除 积分兑换
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRedeem(long id){
	
		return getSqlMapClientTemplate().delete("deleteRedeem", id);
	}
	
	
	/**
	 * 修改 积分兑换
	 * @param id
	 * @return updated count 
	 */
	public int updateRedeem(Redeem redeem){
		return getSqlMapClientTemplate().update("updateRedeem",redeem);
	
	}

		
	/**
	 * 修改 积分兑换但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRedeemIgnoreNull(Redeem redeem){
		Redeem tmp = findRedeem(redeem.getId());
		int flag =0;
		
		
		if(redeem.getGiftname()!=null){
			tmp.setGiftname(redeem.getGiftname());
			
			flag++;
		}
		
		if(redeem.getGiftid()!=null){
			tmp.setGiftid(redeem.getGiftid());
			
			flag++;
		}
		
		if(redeem.getIntegral()!=null){
			tmp.setIntegral(redeem.getIntegral());
			
			flag++;
		}
		
		if(redeem.getName()!=null){
			tmp.setName(redeem.getName());
			
			flag++;
		}
		
		if(redeem.getProvince()!=null){
			tmp.setProvince(redeem.getProvince());
			
			flag++;
		}
		
		if(redeem.getCity()!=null){
			tmp.setCity(redeem.getCity());
			
			flag++;
		}
		
		if(redeem.getArea()!=null){
			tmp.setArea(redeem.getArea());
			
			flag++;
		}
		
		if(redeem.getAddress()!=null){
			tmp.setAddress(redeem.getAddress());
			
			flag++;
		}
		
		if(redeem.getPostcode()!=null){
			tmp.setPostcode(redeem.getPostcode());
			
			flag++;
		}
		
		if(redeem.getMobile()!=null){
			tmp.setMobile(redeem.getMobile());
			
			flag++;
		}
		
		if(redeem.getCreateuser()!=null){
			tmp.setCreateuser(redeem.getCreateuser());
			
			flag++;
		}
		
		if(redeem.getCreatetime()!=null){
			tmp.setCreatetime(redeem.getCreatetime());
			
			flag++;
		}
		
		if(redeem.getModifyuser()!=null){
			tmp.setModifyuser(redeem.getModifyuser());
			
			flag++;
		}
		
		if(redeem.getModifytime()!=null){
			tmp.setModifytime(redeem.getModifytime());
			
			flag++;
		}
		
		if(redeem.getUserid()!=null){
			tmp.setUserid(redeem.getUserid());
			
			flag++;
		}
		
		if(redeem.getState()!=null){
			tmp.setState(redeem.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateRedeem",tmp);
		}
	}
	
	/**
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllRedeem",map, offset, limit);
	}
		
	
	/**
	 * 查找 积分兑换
	 * @param id
	 * @return
	 */
	public Redeem findRedeem(long id){
		return (Redeem)(getSqlMapClientTemplate().queryForObject("findRedeem",id));
	}
	
	/** 
	 * 查找 积分兑换
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRedeem(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRedeemBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllRedeem",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找积分兑换
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRedeem(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllRedeemBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 积分兑换
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRedeemBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteRedeemBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRedeemBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countRedeemBySql",map).toString()));
	}
}

