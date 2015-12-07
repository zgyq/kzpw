/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traininfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TraininfoManager extends  SqlMapClientDaoSupport  implements ITraininfoManager{ 
	
  
 	/**
	 * 创建 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public Traininfo createTraininfo(Traininfo traininfo) throws SQLException{
	
		if(traininfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		traininfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAININFO"));
		getSqlMapClientTemplate().insert("createTraininfo",traininfo);
		return traininfo;
	}
	/**
	 * 删除 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraininfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteTraininfo", id);
	}
	
	
	/**
	 * 修改 车次信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTraininfo(Traininfo traininfo){
		return getSqlMapClientTemplate().update("updateTraininfo",traininfo);
	
	}

		
	/**
	 * 修改 车次信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraininfoIgnoreNull(Traininfo traininfo){
		Traininfo tmp = findTraininfo(traininfo.getId());
		int flag =0;
		
		
		if(traininfo.getTrain_no()!=null){
			tmp.setTrain_no(traininfo.getTrain_no());
			
			flag++;
		}
		
		if(traininfo.getFrom_id()!=null){
			tmp.setFrom_id(traininfo.getFrom_id());
			
			flag++;
		}
		
		if(traininfo.getFrom_name()!=null){
			tmp.setFrom_name(traininfo.getFrom_name());
			
			flag++;
		}
		
		if(traininfo.getFrom_time()!=null){
			tmp.setFrom_time(traininfo.getFrom_time());
			
			flag++;
		}
		
		if(traininfo.getTo_id()!=null){
			tmp.setTo_id(traininfo.getTo_id());
			
			flag++;
		}
		
		if(traininfo.getTo_name()!=null){
			tmp.setTo_name(traininfo.getTo_name());
			
			flag++;
		}
		
		if(traininfo.getTo_time()!=null){
			tmp.setTo_time(traininfo.getTo_time());
			
			flag++;
		}
		
		if(traininfo.getRun_time()!=null){
			tmp.setRun_time(traininfo.getRun_time());
			
			flag++;
		}
		
		if(traininfo.getRun_day()!=null){
			tmp.setRun_day(traininfo.getRun_day());
			
			flag++;
		}
		
		if(traininfo.getStart_data()!=null){
			tmp.setStart_data(traininfo.getStart_data());
			
			flag++;
		}
		
		if(traininfo.getEnd_data()!=null){
			tmp.setEnd_data(traininfo.getEnd_data());
			
			flag++;
		}
		
		if(traininfo.getMem()!=null){
			tmp.setMem(traininfo.getMem());
			
			flag++;
		}
		
		if(traininfo.getBack1()!=null){
			tmp.setBack1(traininfo.getBack1());
			
			flag++;
		}
		
		if(traininfo.getBack2()!=null){
			tmp.setBack2(traininfo.getBack2());
			
			flag++;
		}
		
		if(traininfo.getBack3()!=null){
			tmp.setBack3(traininfo.getBack3());
			
			flag++;
		}
		
		if(traininfo.getBack4()!=null){
			tmp.setBack4(traininfo.getBack4());
			
			flag++;
		}
		
		if(traininfo.getBack5()!=null){
			tmp.setBack5(traininfo.getBack5());
			
			flag++;
		}
		
		if(traininfo.getBack6()!=null){
			tmp.setBack6(traininfo.getBack6());
			
			flag++;
		}
		
		if(traininfo.getBack7()!=null){
			tmp.setBack7(traininfo.getBack7());
			
			flag++;
		}
		
		if(traininfo.getState()!=null){
			tmp.setState(traininfo.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTraininfo",tmp);
		}
	}
	
	/**
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTraininfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 车次信息
	 * @param id
	 * @return
	 */
	public Traininfo findTraininfo(long id){
		return (Traininfo)(getSqlMapClientTemplate().queryForObject("findTraininfo",id));
	}
	
	/** 
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraininfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraininfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTraininfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找车次信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTraininfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 车次信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTraininfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraininfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTraininfoBySql",map).toString()));
	}
}

