/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.train;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainManager extends  SqlMapClientDaoSupport  implements ITrainManager{ 
	
  
 	/**
	 * 创建 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public Train createTrain(Train train) throws SQLException{
	
		if(train.getId()>0){
			throw new SQLException("ID must <= 0");
		}
		if(train.getTotalprice()==-1){
			train.setTotalprice(0);
		}
		////将不再使用 此种 获取ID 方法。by：小陈
		//train.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAIN"));
		getSqlMapClientTemplate().insert("createTrain",train);
		return train;
	}
	/**
	 * 删除 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrain(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrain", id);
	}
	
	
	/**
	 * 修改 火车时刻表
	 * @param id
	 * @return updated count 
	 */
	public int updateTrain(Train train){
		return getSqlMapClientTemplate().update("updateTrain",train);
		
	
	}

		
	/**
	 * 修改 火车时刻表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainIgnoreNull(Train train){
		Train tmp = findTrain(train.getId());
		int flag =0;	
		if(train.getOrdernumber()!=null){
			tmp.setOrdernumber(train.getOrdernumber());			
			flag++;
		}
		if(train.getMemo()!=null){
			tmp.setMemo(train.getMemo());			
			flag++;
		}
		if(train.getOrderstatus()>0){
			tmp.setOrderstatus(train.getOrderstatus());			
			flag++;
		}
		if(train.getPsprice()>0){
			tmp.setPsprice(train.getPsprice());			
			flag++;
		}
		if(train.getQptype()>0){
			tmp.setQptype(train.getQptype());			
			flag++;
		}
		if(train.getAgentid()>0){
			tmp.setAgentid(train.getAgentid());			
			flag++;
		}
		if(train.getCpxx()!=null){
			tmp.setCpxx(train.getCpxx());			
			flag++;
		}
		if(train.getCreateuid()>0){
			tmp.setCreateuid(train.getCreateuid());			
			flag++;
		}
		if(train.getMemberid()>0){
			tmp.setMemberid(train.getMemberid());			
			flag++;
		}
		if(train.getUserid()!=null){
			tmp.setUserid(train.getUserid());			
			flag++;
		}
		if(train.getKdcode()!=null){
			tmp.setKdcode(train.getKdcode());			
			flag++;
		}
		if(train.getKdcomname()!=null){
			tmp.setKdcomname(train.getKdcomname());			
			flag++;
		}
		if(train.getKddesc()!=null){
			tmp.setKddesc(train.getKddesc());			
			flag++;
		}
		if(train.getAcceptseat()!=null){
			tmp.setAcceptseat(train.getAcceptseat());
			flag++;
		}
		if(train.getCreatetime()!=null){
			tmp.setCreatetime(train.getCreatetime());			
			flag++;
		}
		if(train.getSuotime()!=null){
			tmp.setSuotime(train.getSuotime());			
			flag++;
		}
		if(train.getTraincode()!=null){
			tmp.setTraincode(train.getTraincode());			
			flag++;
		}
		if(train.getSeattype()>0){
			tmp.setSeattype(train.getSeattype());			
			flag++;
		}
		if(train.getStartdate()!=null){
			tmp.setStartdate(train.getStartdate());			
			flag++;
		}
		if(train.getStarttime()!=null){
			tmp.setStarttime(train.getStarttime());			
			flag++;
		}
		if(train.getStartcity()!=null){
			tmp.setStartcity(train.getStartcity());			
			flag++;
		}
		if(train.getEndcity()!=null){
			tmp.setEndcity(train.getEndcity());			
			flag++;
		}
		if(train.getCount()>0){
			tmp.setCount(train.getCount());			
			flag++;
		}
		if(train.getBooktype()>0){
			tmp.setBooktype(train.getBooktype());			
			flag++;
		}
		if(train.getTotalprice()>0){
			tmp.setTotalprice(train.getTotalprice());			
			flag++;
		}
		if(train.getContactname()!=null){
			tmp.setContactname(train.getContactname());			
			flag++;
		}
		if(train.getContactmobile()!=null){
			tmp.setContactmobile(train.getContactmobile());			
			flag++;
		}
		if(train.getDeliveryadd()!=null){
			tmp.setDeliveryadd(train.getDeliveryadd());			
			flag++;
		}
		if(train.getDeliverytype()>0){
			tmp.setDeliverytype(train.getDeliverytype());			
			flag++;
		}
		if(train.getDeliverytypeval()!=null){
			tmp.setDeliverytypeval(train.getDeliverytypeval());			
			flag++;
		}
		if(train.getPost()!=null){
			tmp.setPost(train.getPost());			
			flag++;
		}
		if(train.getPaymethod()>0){
			tmp.setPaymethod(train.getPaymethod());			
			flag++;
		}
		if(train.getPaystatus()>0){
			tmp.setPaystatus(train.getPaystatus());			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrain",tmp);
		}
	}
	
	/**
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrain",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车时刻表
	 * @param id
	 * @return
	 */
	public Train findTrain(long id){
		return (Train)(getSqlMapClientTemplate().queryForObject("findTrain",id));
	}
	
	/** 
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrain(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrain",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车时刻表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车时刻表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainBySql",map).toString()));
	}
}

