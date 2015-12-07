/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainroom;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainroomManager extends  SqlMapClientDaoSupport  implements ITrainroomManager{ 
	
  
 	/**
	 * 创建 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public Trainroom createTrainroom(Trainroom trainroom) throws SQLException{
	
		if(trainroom.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainroom.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINROOM"));
		getSqlMapClientTemplate().insert("createTrainroom",trainroom);
		return trainroom;
	}
	/**
	 * 删除 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainroom(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainroom", id);
	}
	
	
	/**
	 * 修改 火车售票点
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainroom(Trainroom trainroom){
		return getSqlMapClientTemplate().update("updateTrainroom",trainroom);
	
	}

		
	/**
	 * 修改 火车售票点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainroomIgnoreNull(Trainroom trainroom){
		Trainroom tmp = findTrainroom(trainroom.getId());
		int flag =0;
		
		
		if(trainroom.getName()!=null){
			tmp.setName(trainroom.getName());
			
			flag++;
		}
		
		if(trainroom.getAddress()!=null){
			tmp.setAddress(trainroom.getAddress());
			
			flag++;
		}
		
		if(trainroom.getTel()!=null){
			tmp.setTel(trainroom.getTel());
			
			flag++;
		}
		
		if(trainroom.getOpentime()!=null){
			tmp.setOpentime(trainroom.getOpentime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainroom",tmp);
		}
	}
	
	/**
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainroom",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车售票点
	 * @param id
	 * @return
	 */
	public Trainroom findTrainroom(long id){
		return (Trainroom)(getSqlMapClientTemplate().queryForObject("findTrainroom",id));
	}
	
	/** 
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainroomBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainroom",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车售票点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainroomBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车售票点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainroomBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainroomBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainroomBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainroomBySql",map).toString()));
	}
}

