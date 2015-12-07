/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dnsmaintenance;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class DnsmaintenanceManager extends  SqlMapClientDaoSupport  implements IDnsmaintenanceManager{ 
	
  
 	/**
	 * 创建 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public Dnsmaintenance createDnsmaintenance(Dnsmaintenance dnsmaintenance) throws SQLException{
	
		if(dnsmaintenance.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		////将不再使用 此种 获取ID 方法。by：小陈
		//dnsmaintenance.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_DNSMAINTENANCE"));
		getSqlMapClientTemplate().insert("createDnsmaintenance",dnsmaintenance);
		return dnsmaintenance;
	}
	/**
	 * 删除 分销商DNSLOGO维护
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDnsmaintenance(long id){
	
		return getSqlMapClientTemplate().delete("deleteDnsmaintenance", id);
	}
	
	
	/**
	 * 修改 分销商DNSLOGO维护
	 * @param id
	 * @return updated count 
	 */
	public int updateDnsmaintenance(Dnsmaintenance dnsmaintenance){
		return getSqlMapClientTemplate().update("updateDnsmaintenance",dnsmaintenance);
	
	}

		
	/**
	 * 修改 分销商DNSLOGO维护但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDnsmaintenanceIgnoreNull(Dnsmaintenance dnsmaintenance){
		Dnsmaintenance tmp = findDnsmaintenance(dnsmaintenance.getId());
		int flag =0;
		
		
		if(dnsmaintenance.getDnsname()!=null){
			tmp.setDnsname(dnsmaintenance.getDnsname());
			
			flag++;
		}
		
		if(dnsmaintenance.getLogologinsrc()!=null){
			tmp.setLogologinsrc(dnsmaintenance.getLogologinsrc());
			flag++;
		}
		if(dnsmaintenance.getLoginpage()!=null){
			tmp.setLoginpage(dnsmaintenance.getLoginpage());
			flag++;
		}
		
		
		if(dnsmaintenance.getLogosrc()!=null){
			tmp.setLogosrc(dnsmaintenance.getLogosrc());
			
			flag++;
		}
		if(dnsmaintenance.getAddress()!=null){
			tmp.setAddress(dnsmaintenance.getAddress());
			
			flag++;
		}
		
		if(dnsmaintenance.getServiceline()!=null){
			tmp.setServiceline(dnsmaintenance.getServiceline());
			
			flag++;
		}
		
		if(dnsmaintenance.getIcpnum()!=null){
			tmp.setIcpnum(dnsmaintenance.getIcpnum());
			
			flag++;
		}
		if(dnsmaintenance.getDizhi()!=null){
			tmp.setDizhi(dnsmaintenance.getDizhi());
			
			flag++;
		}
		if(dnsmaintenance.getBack1()!=null){
			tmp.setBack1(dnsmaintenance.getBack1());
			flag++;
		}
		if(dnsmaintenance.getBack2()!=null){
			tmp.setBack2(dnsmaintenance.getBack2());
			flag++;
		}
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateDnsmaintenance",tmp);
		}
	}
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllDnsmaintenance",map, offset, limit);
	}
		
	
	/**
	 * 查找 分销商DNSLOGO维护
	 * @param id
	 * @return
	 */
	public Dnsmaintenance findDnsmaintenance(long id){
		return (Dnsmaintenance)(getSqlMapClientTemplate().queryForObject("findDnsmaintenance",id));
	}
	
	/** 
	 * 查找 分销商DNSLOGO维护
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDnsmaintenance(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDnsmaintenanceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllDnsmaintenance",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找分销商DNSLOGO维护
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDnsmaintenance(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllDnsmaintenanceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 分销商DNSLOGO维护
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDnsmaintenanceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteDnsmaintenanceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDnsmaintenanceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDnsmaintenanceBySql",map).toString()));
	}
}

