/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizeinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class PrizeinfoManager extends  SqlMapClientDaoSupport  implements IPrizeinfoManager{ 
	
  
 	/**
	 * 创建 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public Prizeinfo createPrizeinfo(Prizeinfo prizeinfo) throws SQLException{
	
		if(prizeinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		prizeinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_PRIZEINFO"));
		getSqlMapClientTemplate().insert("createPrizeinfo",prizeinfo);
		return prizeinfo;
	}
	/**
	 * 删除 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizeinfo(long id){
	
		return getSqlMapClientTemplate().delete("deletePrizeinfo", id);
	}
	
	
	/**
	 * 修改 积分礼品信息
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizeinfo(Prizeinfo prizeinfo){
		return getSqlMapClientTemplate().update("updatePrizeinfo",prizeinfo);
	
	}

		
	/**
	 * 修改 积分礼品信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizeinfoIgnoreNull(Prizeinfo prizeinfo){
		Prizeinfo tmp = findPrizeinfo(prizeinfo.getId());
		int flag =0;
		
		
		if(prizeinfo.getTypeid()!=null){
			tmp.setTypeid(prizeinfo.getTypeid());
			
			flag++;
		}
		
		if(prizeinfo.getName()!=null){
			tmp.setName(prizeinfo.getName());
			
			flag++;
		}
		
		if(prizeinfo.getImgurl()!=null){
			tmp.setImgurl(prizeinfo.getImgurl());
			
			flag++;
		}
		
		if(prizeinfo.getDesc()!=null){
			tmp.setDesc(prizeinfo.getDesc());
			
			flag++;
		}
		
		if(prizeinfo.getScores()!=null){
			tmp.setScores(prizeinfo.getScores());
			
			flag++;
		}
		
		if(prizeinfo.getIndex()!=null){
			tmp.setIndex(prizeinfo.getIndex());
			
			flag++;
		}
		
		if(prizeinfo.getIsenable()!=null){
			tmp.setIsenable(prizeinfo.getIsenable());
			
			flag++;
		}
		
		if(prizeinfo.getCreateuser()!=null){
			tmp.setCreateuser(prizeinfo.getCreateuser());
			
			flag++;
		}
		
		if(prizeinfo.getCreatetime()!=null){
			tmp.setCreatetime(prizeinfo.getCreatetime());
			
			flag++;
		}
		
		if(prizeinfo.getModifyuser()!=null){
			tmp.setModifyuser(prizeinfo.getModifyuser());
			
			flag++;
		}
		
		if(prizeinfo.getModifytime()!=null){
			tmp.setModifytime(prizeinfo.getModifytime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updatePrizeinfo",tmp);
		}
	}
	
	/**
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllPrizeinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 积分礼品信息
	 * @param id
	 * @return
	 */
	public Prizeinfo findPrizeinfo(long id){
		return (Prizeinfo)(getSqlMapClientTemplate().queryForObject("findPrizeinfo",id));
	}
	
	/** 
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPrizeinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllPrizeinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找积分礼品信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllPrizeinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 积分礼品信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizeinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excutePrizeinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizeinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countPrizeinfoBySql",map).toString()));
	}
}

