/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainfare;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainfareManager extends  SqlMapClientDaoSupport  implements ITrainfareManager{ 
	
  
 	/**
	 * 创建 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public Trainfare createTrainfare(Trainfare trainfare) throws SQLException{
	
		if(trainfare.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainfare.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINFARE"));
		getSqlMapClientTemplate().insert("createTrainfare",trainfare);
		return trainfare;
	}
	/**
	 * 删除 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainfare(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainfare", id);
	}
	
	
	/**
	 * 修改 火车票价
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainfare(Trainfare trainfare){
		return getSqlMapClientTemplate().update("updateTrainfare",trainfare);
	
	}

		
	/**
	 * 修改 火车票价但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainfareIgnoreNull(Trainfare trainfare){
		Trainfare tmp = findTrainfare(trainfare.getId());
		int flag =0;
		
		
		if(trainfare.getTrain_no()!=null){
			tmp.setTrain_no(trainfare.getTrain_no());
			
			flag++;
		}
		
		if(trainfare.getStart_station_name()!=null){
			tmp.setStart_station_name(trainfare.getStart_station_name());
			
			flag++;
		}
		
		if(trainfare.getStop_station_name()!=null){
			tmp.setStop_station_name(trainfare.getStop_station_name());
			
			flag++;
		}
		
		if(trainfare.getSeat_type()!=null){
			tmp.setSeat_type(trainfare.getSeat_type());
			
			flag++;
		}
		
		if(trainfare.getSeat_name()!=null){
			tmp.setSeat_name(trainfare.getSeat_name());
			
			flag++;
		}
		
		if(trainfare.getBed_level()!=null){
			tmp.setBed_level(trainfare.getBed_level());
			
			flag++;
		}
		
		if(trainfare.getPrice()!=null){
			tmp.setPrice(trainfare.getPrice());
			
			flag++;
		}
		
		if(trainfare.getMem()!=null){
			tmp.setMem(trainfare.getMem());
			
			flag++;
		}
		
		if(trainfare.getBack1()!=null){
			tmp.setBack1(trainfare.getBack1());
			
			flag++;
		}
		
		if(trainfare.getBack2()!=null){
			tmp.setBack2(trainfare.getBack2());
			
			flag++;
		}
		
		if(trainfare.getBack3()!=null){
			tmp.setBack3(trainfare.getBack3());
			
			flag++;
		}
		
		if(trainfare.getState()!=null){
			tmp.setState(trainfare.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainfare",tmp);
		}
	}
	
	/**
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainfare",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车票价
	 * @param id
	 * @return
	 */
	public Trainfare findTrainfare(long id){
		return (Trainfare)(getSqlMapClientTemplate().queryForObject("findTrainfare",id));
	}
	
	/** 
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainfareBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainfare",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车票价
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainfareBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车票价
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainfareBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainfareBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainfareBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainfareBySql",map).toString()));
	}
}

