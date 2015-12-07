/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainsch;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainschManager extends  SqlMapClientDaoSupport  implements ITrainschManager{ 
	
  
 	/**
	 * 创建 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public Trainsch createTrainsch(Trainsch trainsch) throws SQLException{
	
		if(trainsch.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainsch.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINSCH"));
		getSqlMapClientTemplate().insert("createTrainsch",trainsch);
		return trainsch;
	}
	/**
	 * 删除 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainsch(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainsch", id);
	}
	
	
	/**
	 * 修改 列车时刻
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainsch(Trainsch trainsch){
		return getSqlMapClientTemplate().update("updateTrainsch",trainsch);
	
	}

		
	/**
	 * 修改 列车时刻但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainschIgnoreNull(Trainsch trainsch){
		Trainsch tmp = findTrainsch(trainsch.getId());
		int flag =0;
		
		
		if(trainsch.getTrain_id()!=null){
			tmp.setTrain_id(trainsch.getTrain_id());
			
			flag++;
		}
		
		if(trainsch.getTrain_class()!=null){
			tmp.setTrain_class(trainsch.getTrain_class());
			
			flag++;
		}
		
		if(trainsch.getTrainstation_id()!=null){
			tmp.setTrainstation_id(trainsch.getTrainstation_id());
			
			flag++;
		}
		
		if(trainsch.getStation_name()!=null){
			tmp.setStation_name(trainsch.getStation_name());
			
			flag++;
		}
		
		if(trainsch.getArr_time()!=null){
			tmp.setArr_time(trainsch.getArr_time());
			
			flag++;
		}
		
		if(trainsch.getDep_time()!=null){
			tmp.setDep_time(trainsch.getDep_time());
			
			flag++;
		}
		
		if(trainsch.getArr_time24()!=null){
			tmp.setArr_time24(trainsch.getArr_time24());
			
			flag++;
		}
		
		if(trainsch.getDep_time24()!=null){
			tmp.setDep_time24(trainsch.getDep_time24());
			
			flag++;
		}
		
		if(trainsch.getStation_no()!=null){
			tmp.setStation_no(trainsch.getStation_no());
			
			flag++;
		}
		
		if(trainsch.getDay_arr()!=null){
			tmp.setDay_arr(trainsch.getDay_arr());
			
			flag++;
		}
		
		if(trainsch.getMem()!=null){
			tmp.setMem(trainsch.getMem());
			
			flag++;
		}
		
		if(trainsch.getBack1()!=null){
			tmp.setBack1(trainsch.getBack1());
			
			flag++;
		}
		
		if(trainsch.getBack2()!=null){
			tmp.setBack2(trainsch.getBack2());
			
			flag++;
		}
		
		if(trainsch.getBack3()!=null){
			tmp.setBack3(trainsch.getBack3());
			
			flag++;
		}
		
		if(trainsch.getState()!=null){
			tmp.setState(trainsch.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainsch",tmp);
		}
	}
	
	/**
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainsch(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainsch",map, offset, limit);
	}
		
	
	/**
	 * 查找 列车时刻
	 * @param id
	 * @return
	 */
	public Trainsch findTrainsch(long id){
		return (Trainsch)(getSqlMapClientTemplate().queryForObject("findTrainsch",id));
	}
	
	/** 
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainsch(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainschBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainsch",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找列车时刻
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainsch(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainschBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 列车时刻
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainschBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainschBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainschBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainschBySql",map).toString()));
	}
}

