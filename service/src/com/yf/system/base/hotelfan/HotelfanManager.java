/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelfan;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelfanManager extends  SqlMapClientDaoSupport  implements IHotelfanManager{ 
	
  
 	/**
	 * 创建 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelfan createHotelfan(Hotelfan hotelfan) throws SQLException{
	
		if(hotelfan.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelfan.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELFAN"));
		getSqlMapClientTemplate().insert("createHotelfan",hotelfan);
		return hotelfan;
	}
	/**
	 * 删除 酒店设置返点表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelfan(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelfan", id);
	}
	
	
	/**
	 * 修改 酒店设置返点表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelfan(Hotelfan hotelfan){
		return getSqlMapClientTemplate().update("updateHotelfan",hotelfan);
	
	}

		
	/**
	 * 修改 酒店设置返点表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelfanIgnoreNull(Hotelfan hotelfan){
		Hotelfan tmp = findHotelfan(hotelfan.getId());
		int flag =0;
		
		
		if(hotelfan.getCreatetime()!=null){
			tmp.setCreatetime(hotelfan.getCreatetime());
			
			flag++;
		}
		
		if(hotelfan.getStarttime()!=null){
			tmp.setStarttime(hotelfan.getStarttime());
			
			flag++;
		}
		
		if(hotelfan.getEndtime()!=null){
			tmp.setEndtime(hotelfan.getEndtime());
			
			flag++;
		}
		
		if(hotelfan.getStartprice()!=null){
			tmp.setStartprice(hotelfan.getStartprice());
			
			flag++;
		}
		
		if(hotelfan.getEndprice()!=null){
			tmp.setEndprice(hotelfan.getEndprice());
			
			flag++;
		}
		
		if(hotelfan.getFan()!=null){
			tmp.setFan(hotelfan.getFan());
			
			flag++;
		}
		
		if(hotelfan.getIfvoucher()!=null){
			tmp.setIfvoucher(hotelfan.getIfvoucher());
			
			flag++;
		}
		
		if(hotelfan.getHotelid()!=null){
			tmp.setHotelid(hotelfan.getHotelid());
			
			flag++;
		}
		
		if(hotelfan.getMemberid()!=null){
			tmp.setMemberid(hotelfan.getMemberid());
			
			flag++;
		}
		
		if(hotelfan.getStatus()!=null){
			tmp.setStatus(hotelfan.getStatus());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelfan",tmp);
		}
	}
	
	/**
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelfan",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店设置返点表
	 * @param id
	 * @return
	 */
	public Hotelfan findHotelfan(long id){
		return (Hotelfan)(getSqlMapClientTemplate().queryForObject("findHotelfan",id));
	}
	
	/** 
	 * 查找 酒店设置返点表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelfan(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelfanBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelfan",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店设置返点表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelfan(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelfanBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店设置返点表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelfanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelfanBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelfanBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelfanBySql",map).toString()));
	}
}

