/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.zhefan;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ZhefanManager extends  SqlMapClientDaoSupport  implements IZhefanManager{ 
	
  
 	/**
	 * 创建 折返
	 * @param id
	 * @return deleted count 
	 */
	public Zhefan createZhefan(Zhefan zhefan) throws SQLException{
	
		if(zhefan.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		zhefan.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_ZHEFAN"));
		getSqlMapClientTemplate().insert("createZhefan",zhefan);
		return zhefan;
	}
	/**
	 * 删除 折返
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZhefan(long id){
	
		return getSqlMapClientTemplate().delete("deleteZhefan", id);
	}
	
	
	/**
	 * 修改 折返
	 * @param id
	 * @return updated count 
	 */
	public int updateZhefan(Zhefan zhefan){
		return getSqlMapClientTemplate().update("updateZhefan",zhefan);
	
	}

		
	/**
	 * 修改 折返但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZhefanIgnoreNull(Zhefan zhefan){
		Zhefan tmp = findZhefan(zhefan.getId());
		int flag =0;
		
		
		if(zhefan.getSzhe()!=null){
			tmp.setSzhe(zhefan.getSzhe());
			
			flag++;
		}
		
		if(zhefan.getEndzhe()!=null){
			tmp.setEndzhe(zhefan.getEndzhe());
			
			flag++;
		}
		
		if(zhefan.getZhefan()!=null){
			tmp.setZhefan(zhefan.getZhefan());
			
			flag++;
		}
		
		if(zhefan.getMiaoshu()!=null){
			tmp.setMiaoshu(zhefan.getMiaoshu());
			
			flag++;
		}
		
		if(zhefan.getUserid()!=null){
			tmp.setUserid(zhefan.getUserid());
			
			flag++;
		}
		
		if(zhefan.getParam1()!=null){
			tmp.setParam1(zhefan.getParam1());
			
			flag++;
		}
		
		if(zhefan.getParam2()!=null){
			tmp.setParam2(zhefan.getParam2());
			
			flag++;
		}
		
		if(zhefan.getParam3()!=null){
			tmp.setParam3(zhefan.getParam3());
			
			flag++;
		}
		
		if(zhefan.getCreatetime()!=null){
			tmp.setCreatetime(zhefan.getCreatetime());
			
			flag++;
		}
		
		if(zhefan.getState()!=null){
			tmp.setState(zhefan.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateZhefan",tmp);
		}
	}
	
	/**
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefan(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllZhefan",map, offset, limit);
	}
		
	
	/**
	 * 查找 折返
	 * @param id
	 * @return
	 */
	public Zhefan findZhefan(long id){
		return (Zhefan)(getSqlMapClientTemplate().queryForObject("findZhefan",id));
	}
	
	/** 
	 * 查找 折返
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZhefan(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countZhefanBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllZhefan",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找折返
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZhefan(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllZhefanBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 折返
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZhefanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteZhefanBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZhefanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countZhefanBySql",map).toString()));
	}
}

