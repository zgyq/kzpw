/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insuruser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InsuruserManager extends  SqlMapClientDaoSupport  implements IInsuruserManager{ 
	
  
 	/**
	 * 创建 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public Insuruser createInsuruser(Insuruser insuruser) throws SQLException{
	
		if(insuruser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		insuruser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INSURUSER"));
		getSqlMapClientTemplate().insert("createInsuruser",insuruser);
		return insuruser;
	}
	/**
	 * 删除 被保人列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuruser(long id){
	
		return getSqlMapClientTemplate().delete("deleteInsuruser", id);
	}
	
	
	/**
	 * 修改 被保人列表
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuruser(Insuruser insuruser){
		return getSqlMapClientTemplate().update("updateInsuruser",insuruser);
	
	}

		
	/**
	 * 修改 被保人列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuruserIgnoreNull(Insuruser insuruser){
		Insuruser tmp = findInsuruser(insuruser.getId());
		int flag =0;
		
		
		if(insuruser.getOrderid()!=null){
			tmp.setOrderid(insuruser.getOrderid());
			
			flag++;
		}
		
		if(insuruser.getPolicyno()!=null){
			tmp.setPolicyno(insuruser.getPolicyno());
			
			flag++;
		}
		
		if(insuruser.getName()!=null){
			tmp.setName(insuruser.getName());
			
			flag++;
		}
		
		if(insuruser.getSex()!=null){
			tmp.setSex(insuruser.getSex());
			
			flag++;
		}
		
		if(insuruser.getCodetype()!=null){
			tmp.setCodetype(insuruser.getCodetype());
			
			flag++;
		}
		
		if(insuruser.getCode()!=null){
			tmp.setCode(insuruser.getCode());
			
			flag++;
		}
		
		if(insuruser.getMobile()!=null){
			tmp.setMobile(insuruser.getMobile());
			
			flag++;
		}
		
		if(insuruser.getBirthday()!=null){
			tmp.setBirthday(insuruser.getBirthday());
			
			flag++;
		}
		
		if(insuruser.getEmail()!=null){
			tmp.setEmail(insuruser.getEmail());
			
			flag++;
		}
		
		if(insuruser.getFlyno()!=null){
			tmp.setFlyno(insuruser.getFlyno());
			
			flag++;
		}
		
		if(insuruser.getCity()!=null){
			tmp.setCity(insuruser.getCity());
			
			flag++;
		}
		
		if(insuruser.getFlytime()!=null){
			tmp.setFlytime(insuruser.getFlytime());
			
			flag++;
		}
		
		if(insuruser.getBegintime()!=null){
			tmp.setBegintime(insuruser.getBegintime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInsuruser",tmp);
		}
	}
	
	/**
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInsuruser",map, offset, limit);
	}
		
	
	/**
	 * 查找 被保人列表
	 * @param id
	 * @return
	 */
	public Insuruser findInsuruser(long id){
		return (Insuruser)(getSqlMapClientTemplate().queryForObject("findInsuruser",id));
	}
	
	/** 
	 * 查找 被保人列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuruser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsuruserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInsuruser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找被保人列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuruser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInsuruserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 被保人列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuruserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInsuruserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuruserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsuruserBySql",map).toString()));
	}
}

