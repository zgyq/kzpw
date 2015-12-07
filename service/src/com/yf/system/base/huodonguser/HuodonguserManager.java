/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.huodonguser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HuodonguserManager extends  SqlMapClientDaoSupport  implements IHuodonguserManager{ 
	
  
 	/**
	 * 创建 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public Huodonguser createHuodonguser(Huodonguser huodonguser) throws SQLException{
	
		if(huodonguser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		huodonguser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HUODONGUSER"));
		getSqlMapClientTemplate().insert("createHuodonguser",huodonguser);
		return huodonguser;
	}
	/**
	 * 删除 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHuodonguser(long id){
	
		return getSqlMapClientTemplate().delete("deleteHuodonguser", id);
	}
	
	
	/**
	 * 修改 活动会员
	 * @param id
	 * @return updated count 
	 */
	public int updateHuodonguser(Huodonguser huodonguser){
		return getSqlMapClientTemplate().update("updateHuodonguser",huodonguser);
	
	}

		
	/**
	 * 修改 活动会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHuodonguserIgnoreNull(Huodonguser huodonguser){
		Huodonguser tmp = findHuodonguser(huodonguser.getId());
		int flag =0;
		
		
		if(huodonguser.getName()!=null){
			tmp.setName(huodonguser.getName());
			
			flag++;
		}
		
		if(huodonguser.getLoginname()!=null){
			tmp.setLoginname(huodonguser.getLoginname());
			
			flag++;
		}
		
		if(huodonguser.getLoginpwd()!=null){
			tmp.setLoginpwd(huodonguser.getLoginpwd());
			
			flag++;
		}
		
		if(huodonguser.getIdtype()!=null){
			tmp.setIdtype(huodonguser.getIdtype());
			
			flag++;
		}
		
		if(huodonguser.getIdnumber()!=null){
			tmp.setIdnumber(huodonguser.getIdnumber());
			
			flag++;
		}
		
		if(huodonguser.getAreacode()!=null){
			tmp.setAreacode(huodonguser.getAreacode());
			
			flag++;
		}
		
		if(huodonguser.getTel()!=null){
			tmp.setTel(huodonguser.getTel());
			
			flag++;
		}
		
		if(huodonguser.getMobile()!=null){
			tmp.setMobile(huodonguser.getMobile());
			
			flag++;
		}
		
		if(huodonguser.getMail()!=null){
			tmp.setMail(huodonguser.getMail());
			
			flag++;
		}
		
		if(huodonguser.getPostalcode()!=null){
			tmp.setPostalcode(huodonguser.getPostalcode());
			
			flag++;
		}
		
		if(huodonguser.getParam1()!=null){
			tmp.setParam1(huodonguser.getParam1());
			
			flag++;
		}
		
		if(huodonguser.getParam2()!=null){
			tmp.setParam2(huodonguser.getParam2());
			
			flag++;
		}
		
		if(huodonguser.getParam3()!=null){
			tmp.setParam3(huodonguser.getParam3());
			
			flag++;
		}
		
		if(huodonguser.getCreatetime()!=null){
			tmp.setCreatetime(huodonguser.getCreatetime());
			
			flag++;
		}
		
		if(huodonguser.getMemberid()!=null){
			tmp.setMemberid(huodonguser.getMemberid());
			
			flag++;
		}
		
		if(huodonguser.getState()!=null){
			tmp.setState(huodonguser.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHuodonguser",tmp);
		}
	}
	
	/**
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHuodonguser",map, offset, limit);
	}
		
	
	/**
	 * 查找 活动会员
	 * @param id
	 * @return
	 */
	public Huodonguser findHuodonguser(long id){
		return (Huodonguser)(getSqlMapClientTemplate().queryForObject("findHuodonguser",id));
	}
	
	/** 
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHuodonguserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHuodonguser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找活动会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHuodonguserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 活动会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHuodonguserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHuodonguserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHuodonguserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHuodonguserBySql",map).toString()));
	}
}

