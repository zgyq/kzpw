/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ymuser;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class YmuserManager extends  SqlMapClientDaoSupport  implements IYmuserManager{ 
	
  
 	/**
	 * 创建 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public Ymuser createYmuser(Ymuser ymuser) throws SQLException{
	
		if(ymuser.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		ymuser.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_YMUSER"));
		getSqlMapClientTemplate().insert("createYmuser",ymuser);
		return ymuser;
	}
	/**
	 * 删除 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmuser(long id){
	
		return getSqlMapClientTemplate().delete("deleteYmuser", id);
	}
	
	
	/**
	 * 修改 短信用户账号
	 * @param id
	 * @return updated count 
	 */
	public int updateYmuser(Ymuser ymuser){
		return getSqlMapClientTemplate().update("updateYmuser",ymuser);
	
	}

		
	/**
	 * 修改 短信用户账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmuserIgnoreNull(Ymuser ymuser){
		Ymuser tmp = findYmuser(ymuser.getId());
		int flag =0;
		
		
		if(ymuser.getUsername()!=null){
			tmp.setUsername(ymuser.getUsername());
			
			flag++;
		}
		
		if(ymuser.getPwd()!=null){
			tmp.setPwd(ymuser.getPwd());
			
			flag++;
		}
		
		if(ymuser.getKey()!=null){
			tmp.setKey(ymuser.getKey());
			
			flag++;
		}
		
		if(ymuser.getAgentid()!=null){
			tmp.setAgentid(ymuser.getAgentid());
			
			flag++;
		}
		
		if(ymuser.getOnline()!=null){
			tmp.setOnline(ymuser.getOnline());
			
			flag++;
		}
		
		if(ymuser.getCreateuser()!=null){
			tmp.setCreateuser(ymuser.getCreateuser());
			
			flag++;
		}
		
		if(ymuser.getCreatetime()!=null){
			tmp.setCreatetime(ymuser.getCreatetime());
			
			flag++;
		}
		
		if(ymuser.getMemnum()!=null){
			tmp.setMemnum(ymuser.getMemnum());
			
			flag++;
		}
		
		if(ymuser.getBack1()!=null){
			tmp.setBack1(ymuser.getBack1());
			
			flag++;
		}
		
		if(ymuser.getBack2()!=null){
			tmp.setBack2(ymuser.getBack2());
			
			flag++;
		}
		
		if(ymuser.getBack3()!=null){
			tmp.setBack3(ymuser.getBack3());
			
			flag++;
		}
		
		if(ymuser.getBack4()!=null){
			tmp.setBack4(ymuser.getBack4());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateYmuser",tmp);
		}
	}
	
	/**
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllYmuser",map, offset, limit);
	}
		
	
	/**
	 * 查找 短信用户账号
	 * @param id
	 * @return
	 */
	public Ymuser findYmuser(long id){
		return (Ymuser)(getSqlMapClientTemplate().queryForObject("findYmuser",id));
	}
	
	/** 
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmuserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllYmuser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找短信用户账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllYmuserBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 短信用户账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmuserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteYmuserBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmuserBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countYmuserBySql",map).toString()));
	}
}

