/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ympay;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class YmpayManager extends  SqlMapClientDaoSupport  implements IYmpayManager{ 
	
  
 	/**
	 * 创建 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Ympay createYmpay(Ympay ympay) throws SQLException{
	
		if(ympay.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ympay.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_YMPAY"));
		getSqlMapClientTemplate().insert("createYmpay",ympay);
		return ympay;
	}
	/**
	 * 删除 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmpay(long id){
	
		return getSqlMapClientTemplate().delete("deleteYmpay", id);
	}
	
	
	/**
	 * 修改 短信充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateYmpay(Ympay ympay){
		return getSqlMapClientTemplate().update("updateYmpay",ympay);
	
	}

		
	/**
	 * 修改 短信充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmpayIgnoreNull(Ympay ympay){
		Ympay tmp = findYmpay(ympay.getId());
		int flag =0;
		
		
		if(ympay.getYmuserid()!=null){
			tmp.setYmuserid(ympay.getYmuserid());
			
			flag++;
		}
		
		if(ympay.getPwd()!=null){
			tmp.setPwd(ympay.getPwd());
			
			flag++;
		}
		
		if(ympay.getPrice()!=null){
			tmp.setPrice(ympay.getPrice());
			
			flag++;
		}
		
		if(ympay.getAgentid()!=null){
			tmp.setAgentid(ympay.getAgentid());
			
			flag++;
		}
		
		if(ympay.getState()!=null){
			tmp.setState(ympay.getState());
			
			flag++;
		}
		
		if(ympay.getCreateuser()!=null){
			tmp.setCreateuser(ympay.getCreateuser());
			
			flag++;
		}
		
		if(ympay.getCreatetime()!=null){
			tmp.setCreatetime(ympay.getCreatetime());
			
			flag++;
		}
		
		if(ympay.getMemnum()!=null){
			tmp.setMemnum(ympay.getMemnum());
			
			flag++;
		}
		
		if(ympay.getBack1()!=null){
			tmp.setBack1(ympay.getBack1());
			
			flag++;
		}
		
		if(ympay.getBack2()!=null){
			tmp.setBack2(ympay.getBack2());
			
			flag++;
		}
		
		if(ympay.getBack3()!=null){
			tmp.setBack3(ympay.getBack3());
			
			flag++;
		}
		
		if(ympay.getBack4()!=null){
			tmp.setBack4(ympay.getBack4());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateYmpay",tmp);
		}
	}
	
	/**
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllYmpay",map, offset, limit);
	}
		
	
	/**
	 * 查找 短信充值记录
	 * @param id
	 * @return
	 */
	public Ympay findYmpay(long id){
		return (Ympay)(getSqlMapClientTemplate().queryForObject("findYmpay",id));
	}
	
	/** 
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmpayBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllYmpay",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找短信充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllYmpayBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 短信充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmpayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteYmpayBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmpayBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmpayBySql",map).toString()));
	}
}

