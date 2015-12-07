/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.importmureport;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ImportmureportManager extends  SqlMapClientDaoSupport  implements IImportmureportManager{ 
	
  
 	/**
	 * 创建 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public Importmureport createImportmureport(Importmureport importmureport) throws SQLException{
	
		if(importmureport.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		importmureport.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_IMPORTMUREPORT"));
		getSqlMapClientTemplate().insert("createImportmureport",importmureport);
		return importmureport;
	}
	/**
	 * 删除 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteImportmureport(long id){
	
		return getSqlMapClientTemplate().delete("deleteImportmureport", id);
	}
	
	
	/**
	 * 修改 东航销售明细导入
	 * @param id
	 * @return updated count 
	 */
	public int updateImportmureport(Importmureport importmureport){
		return getSqlMapClientTemplate().update("updateImportmureport",importmureport);
	
	}

		
	/**
	 * 修改 东航销售明细导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateImportmureportIgnoreNull(Importmureport importmureport){
		Importmureport tmp = findImportmureport(importmureport.getId());
		int flag =0;
		
		
		if(importmureport.getTicketnumber()!=null){
			tmp.setTicketnumber(importmureport.getTicketnumber());
			
			flag++;
		}
		
		if(importmureport.getPayall()!=null){
			tmp.setPayall(importmureport.getPayall());
			
			flag++;
		}
		
		if(importmureport.getPnr()!=null){
			tmp.setPnr(importmureport.getPnr());
			
			flag++;
		}
		
		if(importmureport.getNumber()!=null){
			tmp.setNumber(importmureport.getNumber());
			
			flag++;
		}
		
		if(importmureport.getChengren()!=null){
			tmp.setChengren(importmureport.getChengren());
			
			flag++;
		}
		
		if(importmureport.getErtong()!=null){
			tmp.setErtong(importmureport.getErtong());
			
			flag++;
		}
		
		if(importmureport.getVoyage()!=null){
			tmp.setVoyage(importmureport.getVoyage());
			
			flag++;
		}
		
		if(importmureport.getCabin()!=null){
			tmp.setCabin(importmureport.getCabin());
			
			flag++;
		}
		
		if(importmureport.getTicketprice()!=null){
			tmp.setTicketprice(importmureport.getTicketprice());
			
			flag++;
		}
		
		if(importmureport.getFee()!=null){
			tmp.setFee(importmureport.getFee());
			
			flag++;
		}
		
		if(importmureport.getPayprice()!=null){
			tmp.setPayprice(importmureport.getPayprice());
			
			flag++;
		}
		
		if(importmureport.getDaiprice()!=null){
			tmp.setDaiprice(importmureport.getDaiprice());
			
			flag++;
		}
		
		if(importmureport.getPaybank()!=null){
			tmp.setPaybank(importmureport.getPaybank());
			
			flag++;
		}
		
		if(importmureport.getBanknumber()!=null){
			tmp.setBanknumber(importmureport.getBanknumber());
			
			flag++;
		}
		
		if(importmureport.getTime()!=null){
			tmp.setTime(importmureport.getTime());
			
			flag++;
		}
		
		if(importmureport.getStorageid()!=null){
			tmp.setStorageid(importmureport.getStorageid());
			
			flag++;
		}
		
		if(importmureport.getChupiaoid()!=null){
			tmp.setChupiaoid(importmureport.getChupiaoid());
			
			flag++;
		}
		
		if(importmureport.getCompstate()!=null){
			tmp.setCompstate(importmureport.getCompstate());
			
			flag++;
		}
		
		if(importmureport.getTicketstate()!=null){
			tmp.setTicketstate(importmureport.getTicketstate());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateImportmureport",tmp);
		}
	}
	
	/**
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllImportmureport",map, offset, limit);
	}
		
	
	/**
	 * 查找 东航销售明细导入
	 * @param id
	 * @return
	 */
	public Importmureport findImportmureport(long id){
		return (Importmureport)(getSqlMapClientTemplate().queryForObject("findImportmureport",id));
	}
	
	/** 
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countImportmureportBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllImportmureport",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找东航销售明细导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllImportmureportBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 东航销售明细导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteImportmureportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteImportmureportBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countImportmureportBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countImportmureportBySql",map).toString()));
	}
}

