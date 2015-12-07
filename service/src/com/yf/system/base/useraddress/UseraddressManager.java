/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.useraddress;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class UseraddressManager extends  SqlMapClientDaoSupport  implements IUseraddressManager{ 
	
  
 	/**
	 * 创建 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public Useraddress createUseraddress(Useraddress useraddress) throws SQLException{
	
		if(useraddress.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		useraddress.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_USERADDRESS"));
		getSqlMapClientTemplate().insert("createUseraddress",useraddress);
		return useraddress;
	}
	/**
	 * 删除 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUseraddress(long id){
	
		return getSqlMapClientTemplate().delete("deleteUseraddress", id);
	}
	
	
	/**
	 * 修改 会员常用配送地址
	 * @param id
	 * @return updated count 
	 */
	public int updateUseraddress(Useraddress useraddress){
		return getSqlMapClientTemplate().update("updateUseraddress",useraddress);
	
	}

		
	/**
	 * 修改 会员常用配送地址但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUseraddressIgnoreNull(Useraddress useraddress){
		Useraddress tmp = findUseraddress(useraddress.getId());
		int flag =0;
		
		
		if(useraddress.getName()!=null){
			tmp.setName(useraddress.getName());
			
			flag++;
		}
		
		if(useraddress.getProvince()!=null){
			tmp.setProvince(useraddress.getProvince());
			
			flag++;
		}
		
		if(useraddress.getCity()!=null){
			tmp.setCity(useraddress.getCity());
			
			flag++;
		}
		
		if(useraddress.getArea()!=null){
			tmp.setArea(useraddress.getArea());
			
			flag++;
		}
		
		if(useraddress.getAddress()!=null){
			tmp.setAddress(useraddress.getAddress());
			
			flag++;
		}
		
		if(useraddress.getAreacode()!=null){
			tmp.setAreacode(useraddress.getAreacode());
			
			flag++;
		}
		
		if(useraddress.getTel()!=null){
			tmp.setTel(useraddress.getTel());
			
			flag++;
		}
		
		if(useraddress.getMobile()!=null){
			tmp.setMobile(useraddress.getMobile());
			
			flag++;
		}
		
		if(useraddress.getMail()!=null){
			tmp.setMail(useraddress.getMail());
			
			flag++;
		}
		
		if(useraddress.getPostalcode()!=null){
			tmp.setPostalcode(useraddress.getPostalcode());
			
			flag++;
		}
		
		if(useraddress.getParam1()!=null){
			tmp.setParam1(useraddress.getParam1());
			
			flag++;
		}
		
		if(useraddress.getParam2()!=null){
			tmp.setParam2(useraddress.getParam2());
			
			flag++;
		}
		
		if(useraddress.getParam3()!=null){
			tmp.setParam3(useraddress.getParam3());
			
			flag++;
		}
		
		if(useraddress.getCreatetime()!=null){
			tmp.setCreatetime(useraddress.getCreatetime());
			
			flag++;
		}
		
		if(useraddress.getMemberid()!=null){
			tmp.setMemberid(useraddress.getMemberid());
			
			flag++;
		}
		
		if(useraddress.getState()!=null){
			tmp.setState(useraddress.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateUseraddress",tmp);
		}
	}
	
	/**
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllUseraddress",map, offset, limit);
	}
		
	
	/**
	 * 查找 会员常用配送地址
	 * @param id
	 * @return
	 */
	public Useraddress findUseraddress(long id){
		return (Useraddress)(getSqlMapClientTemplate().queryForObject("findUseraddress",id));
	}
	
	/** 
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countUseraddressBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllUseraddress",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找会员常用配送地址
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllUseraddressBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 会员常用配送地址
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUseraddressBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteUseraddressBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUseraddressBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countUseraddressBySql",map).toString()));
	}
}

