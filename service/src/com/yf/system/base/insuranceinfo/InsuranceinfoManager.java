/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.insuranceinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class InsuranceinfoManager extends  SqlMapClientDaoSupport  implements IInsuranceinfoManager{ 
	
  
 	/**
	 * 创建 保险
	 * @param id
	 * @return deleted count 
	 */
	public Insuranceinfo createInsuranceinfo(Insuranceinfo insuranceinfo) throws SQLException{
	
		if(insuranceinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		insuranceinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_INSURANCEINFO"));
		getSqlMapClientTemplate().insert("createInsuranceinfo",insuranceinfo);
		return insuranceinfo;
	}
	/**
	 * 删除 保险
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuranceinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteInsuranceinfo", id);
	}
	
	
	/**
	 * 修改 保险
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuranceinfo(Insuranceinfo insuranceinfo){
		return getSqlMapClientTemplate().update("updateInsuranceinfo",insuranceinfo);
	
	}

		
	/**
	 * 修改 保险但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuranceinfoIgnoreNull(Insuranceinfo insuranceinfo){
		Insuranceinfo tmp = findInsuranceinfo(insuranceinfo.getId());
		int flag =0;
		
		
		if(insuranceinfo.getCompanyname()!=null){
			tmp.setCompanyname(insuranceinfo.getCompanyname());
			
			flag++;
		}
		
		if(insuranceinfo.getInsurancename()!=null){
			tmp.setInsurancename(insuranceinfo.getInsurancename());
			
			flag++;
		}
		
//		if(insuranceinfo.getValiddate()!=null){
//			tmp.setValiddate(insuranceinfo.getValiddate());
//			
//			flag++;
//		}
		
		if(insuranceinfo.getInsurancenum()!=null){
			tmp.setInsurancenum(insuranceinfo.getInsurancenum());
			flag++;
		}
		
		if(insuranceinfo.getInsurancestate()!=null){
			tmp.setInsurancestate(insuranceinfo.getInsurancestate());
			flag++;
		}
		
		if(insuranceinfo.getInsurancemoney()!=null){
			tmp.setInsurancemoney(insuranceinfo.getInsurancemoney());
			
			flag++;
		}
		
		if(insuranceinfo.getInsurancefee()!=null){
			tmp.setInsurancefee(insuranceinfo.getInsurancefee());
			
			flag++;
		}
		
		if(insuranceinfo.getOrdernumber()!=null){
			tmp.setOrdernumber(insuranceinfo.getOrdernumber());
			
			flag++;
		}
		
		if(insuranceinfo.getDescription()!=null){
			tmp.setDescription(insuranceinfo.getDescription());
			
			flag++;
		}
		
		if(insuranceinfo.getEmployeeid()>0){
			tmp.setEmployeeid(insuranceinfo.getEmployeeid());
			
			flag++;
		}
		
		if(insuranceinfo.getCreatetime()!=null){
			tmp.setCreatetime(insuranceinfo.getCreatetime());
			
			flag++;
		}
		
		if(insuranceinfo.getDanzhenghao()!=null){
			tmp.setDanzhenghao(insuranceinfo.getDanzhenghao());
			
			flag++;
		}
		
		if(insuranceinfo.getEnddate()!=null){
			tmp.setEnddate(insuranceinfo.getEnddate());
			flag++;
		}
		
		if(insuranceinfo.getToubaoren()!=null){
			tmp.setToubaoren(insuranceinfo.getToubaoren());
			
			flag++;
		}
		
		if(insuranceinfo.getWorktime()!=null){
			tmp.setWorktime(insuranceinfo.getWorktime());
			flag++;
		}
		
		if(insuranceinfo.getBeibaoren()!=null){
			tmp.setToubaoren(insuranceinfo.getBeibaoren());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateInsuranceinfo",tmp);
		}
	}
	
	/**
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllInsuranceinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 保险
	 * @param id
	 * @return
	 */
	public Insuranceinfo findInsuranceinfo(long id){
		return (Insuranceinfo)(getSqlMapClientTemplate().queryForObject("findInsuranceinfo",id));
	}
	
	/** 
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuranceinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsuranceinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllInsuranceinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找保险
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllInsuranceinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 保险
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuranceinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteInsuranceinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuranceinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countInsuranceinfoBySql",map).toString()));
	}
}

