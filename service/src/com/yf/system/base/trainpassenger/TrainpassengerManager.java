/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainpassenger;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainpassengerManager extends  SqlMapClientDaoSupport  implements ITrainpassengerManager{ 
	
  
 	/**
	 * 创建 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public Trainpassenger createTrainpassenger(Trainpassenger trainpassenger) throws SQLException{
	
		if(trainpassenger.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainpassenger.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINPASSENGER"));
		getSqlMapClientTemplate().insert("createTrainpassenger",trainpassenger);
		return trainpassenger;
	}
	/**
	 * 删除 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainpassenger(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainpassenger", id);
	}
	
	
	/**
	 * 修改 火车票乘客
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainpassenger(Trainpassenger trainpassenger){
		return getSqlMapClientTemplate().update("updateTrainpassenger",trainpassenger);
	
	}

		
	/**
	 * 修改 火车票乘客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainpassengerIgnoreNull(Trainpassenger trainpassenger){
		Trainpassenger tmp = findTrainpassenger(trainpassenger.getId());
		int flag =0;
		
		
		if(trainpassenger.getOrderid()>0){
			tmp.setOrderid(trainpassenger.getOrderid());
			
			flag++;
		}
		
		if(trainpassenger.getName()!=null){
			tmp.setName(trainpassenger.getName());
			
			flag++;
		}
		
		if(trainpassenger.getIdtype()>0){
			tmp.setIdtype(trainpassenger.getIdtype());
			
			flag++;
		}
		if(trainpassenger.getChupiaoprice()!=null){
			tmp.setChupiaoprice(trainpassenger.getChupiaoprice());
			
			flag++;
		}
		if(trainpassenger.getChupiaotype()!=null){
			tmp.setChupiaotype(trainpassenger.getChupiaotype());
			
			flag++;
		}
		if(trainpassenger.getYudingtype()!=null){
			tmp.setYudingtype(trainpassenger.getYudingtype());
			
			flag++;
		}
		if(trainpassenger.getBxprice()>0){
			tmp.setBxprice(trainpassenger.getBxprice());
			
			flag++;
		}
		if(trainpassenger.getPrice()>0){
			tmp.setPrice(trainpassenger.getPrice());
			
			flag++;
		}
		if(trainpassenger.getState()>0){
			tmp.setState(trainpassenger.getState());
			
			flag++;
		}
		if(trainpassenger.getIdnumber()!=null){
			tmp.setIdnumber(trainpassenger.getIdnumber());
			
			flag++;
		}
		
		if(trainpassenger.getCreatetime()!=null){
			tmp.setCreatetime(trainpassenger.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainpassenger",tmp);
		}
	}
	
	/**
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainpassenger",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车票乘客
	 * @param id
	 * @return
	 */
	public Trainpassenger findTrainpassenger(long id){
		return (Trainpassenger)(getSqlMapClientTemplate().queryForObject("findTrainpassenger",id));
	}
	
	/** 
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainpassengerBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainpassenger",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车票乘客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainpassengerBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车票乘客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainpassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainpassengerBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainpassengerBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainpassengerBySql",map).toString()));
	}
}

