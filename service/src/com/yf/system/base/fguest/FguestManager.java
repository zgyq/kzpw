/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fguest;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class FguestManager extends  SqlMapClientDaoSupport  implements IFguestManager{ 
	
  
 	/**
	 * 创建 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Fguest createFguest(Fguest fguest) throws SQLException{
	
		if(fguest.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		fguest.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_FGUEST"));
		getSqlMapClientTemplate().insert("createFguest",fguest);
		return fguest;
	}
	/**
	 * 删除 国际机票乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFguest(long id){
	
		return getSqlMapClientTemplate().delete("deleteFguest", id);
	}
	
	
	/**
	 * 修改 国际机票乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updateFguest(Fguest fguest){
		return getSqlMapClientTemplate().update("updateFguest",fguest);
	
	}

		
	/**
	 * 修改 国际机票乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFguestIgnoreNull(Fguest fguest){
		Fguest tmp = findFguest(fguest.getId());
		int flag =0;
		
		
		if(fguest.getOrderid()!=null){
			tmp.setOrderid(fguest.getOrderid());
			
			flag++;
		}
		
		if(fguest.getGuestname()!=null){
			tmp.setGuestname(fguest.getGuestname());
			
			flag++;
		}
		
		if(fguest.getIsstudent()!=null){
			tmp.setIsstudent(fguest.getIsstudent());
			
			flag++;
		}
		
		if(fguest.getGuestidno()!=null){
			tmp.setGuestidno(fguest.getGuestidno());
			
			flag++;
		}
		
		if(fguest.getCountrycode()!=null){
			tmp.setCountrycode(fguest.getCountrycode());
			
			flag++;
		}
		
		if(fguest.getGuesttype()!=null){
			tmp.setGuesttype(fguest.getGuesttype());
			
			flag++;
		}
		
		if(fguest.getGender()!=null){
			tmp.setGender(fguest.getGender());
			
			flag++;
		}
		
		if(fguest.getBirthday()!=null){
			tmp.setBirthday(fguest.getBirthday());
			
			flag++;
		}
		
		if(fguest.getTargetzipcode()!=null){
			tmp.setTargetzipcode(fguest.getTargetzipcode());
			
			flag++;
		}
		
		if(fguest.getTargetaddress()!=null){
			tmp.setTargetaddress(fguest.getTargetaddress());
			
			flag++;
		}
		
		if(fguest.getLiveaddress()!=null){
			tmp.setLiveaddress(fguest.getLiveaddress());
			
			flag++;
		}
		
		if(fguest.getTicketprice()!=null){
			tmp.setTicketprice(fguest.getTicketprice());
			
			flag++;
		}
		
		if(fguest.getSairportfee()!=null){
			tmp.setSairportfee(fguest.getSairportfee());
			
			flag++;
		}
		
		if(fguest.getEairportfee()!=null){
			tmp.setEairportfee(fguest.getEairportfee());
			
			flag++;
		}
		
		if(fguest.getFuelfee()!=null){
			tmp.setFuelfee(fguest.getFuelfee());
			
			flag++;
		}
		
		if(fguest.getAnjianfee()!=null){
			tmp.setAnjianfee(fguest.getAnjianfee());
			
			flag++;
		}
		
		if(fguest.getTicketnumber()!=null){
			tmp.setTicketnumber(fguest.getTicketnumber());
			
			flag++;
		}
		
		if(fguest.getFetnumber()!=null){
			tmp.setFetnumber(fguest.getFetnumber());
			
			flag++;
		}
		
		if(fguest.getMobile()!=null){
			tmp.setMobile(fguest.getMobile());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateFguest",tmp);
		}
	}
	
	/**
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllFguest",map, offset, limit);
	}
		
	
	/**
	 * 查找 国际机票乘机人表
	 * @param id
	 * @return
	 */
	public Fguest findFguest(long id){
		return (Fguest)(getSqlMapClientTemplate().queryForObject("findFguest",id));
	}
	
	/** 
	 * 查找 国际机票乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFguest(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFguestBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllFguest",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找国际机票乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFguest(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllFguestBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 国际机票乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFguestBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteFguestBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFguestBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countFguestBySql",map).toString()));
	}
}

