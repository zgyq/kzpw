/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainstation;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class TrainstationManager extends  SqlMapClientDaoSupport  implements ITrainstationManager{ 
	
  
 	/**
	 * 创建 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public Trainstation createTrainstation(Trainstation trainstation) throws SQLException{
	
		if(trainstation.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		trainstation.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_TRAINSTATION"));
		getSqlMapClientTemplate().insert("createTrainstation",trainstation);
		return trainstation;
	}
	/**
	 * 删除 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainstation(long id){
	
		return getSqlMapClientTemplate().delete("deleteTrainstation", id);
	}
	
	
	/**
	 * 修改 火车站信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainstation(Trainstation trainstation){
		return getSqlMapClientTemplate().update("updateTrainstation",trainstation);
	
	}

		
	/**
	 * 修改 火车站信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainstationIgnoreNull(Trainstation trainstation){
		Trainstation tmp = findTrainstation(trainstation.getId());
		int flag =0;
		
		
		if(trainstation.getTrainstation_id()!=null){
			tmp.setTrainstation_id(trainstation.getTrainstation_id());
			
			flag++;
		}
		
		if(trainstation.getCode()!=null){
			tmp.setCode(trainstation.getCode());
			
			flag++;
		}
		
		if(trainstation.getCity()!=null){
			tmp.setCity(trainstation.getCity());
			
			flag++;
		}
		
		if(trainstation.getName_cn()!=null){
			tmp.setName_cn(trainstation.getName_cn());
			
			flag++;
		}
		
		if(trainstation.getName_py()!=null){
			tmp.setName_py(trainstation.getName_py());
			
			flag++;
		}
		
		if(trainstation.getName_en()!=null){
			tmp.setName_en(trainstation.getName_en());
			
			flag++;
		}
		
		if(trainstation.getNameall_cn()!=null){
			tmp.setNameall_cn(trainstation.getNameall_cn());
			
			flag++;
		}
		
		if(trainstation.getNameall_py()!=null){
			tmp.setNameall_py(trainstation.getNameall_py());
			
			flag++;
		}
		
		if(trainstation.getNameall_en()!=null){
			tmp.setNameall_en(trainstation.getNameall_en());
			
			flag++;
		}
		
		if(trainstation.getByname()!=null){
			tmp.setByname(trainstation.getByname());
			
			flag++;
		}
		
		if(trainstation.getStatecode()!=null){
			tmp.setStatecode(trainstation.getStatecode());
			
			flag++;
		}
		
		if(trainstation.getAdmin_id()!=null){
			tmp.setAdmin_id(trainstation.getAdmin_id());
			
			flag++;
		}
		
		if(trainstation.getAdmin_name()!=null){
			tmp.setAdmin_name(trainstation.getAdmin_name());
			
			flag++;
		}
		
		if(trainstation.getAddress()!=null){
			tmp.setAddress(trainstation.getAddress());
			
			flag++;
		}
		
		if(trainstation.getTel()!=null){
			tmp.setTel(trainstation.getTel());
			
			flag++;
		}
		
		if(trainstation.getLon()!=null){
			tmp.setLon(trainstation.getLon());
			
			flag++;
		}
		
		if(trainstation.getLat()!=null){
			tmp.setLat(trainstation.getLat());
			
			flag++;
		}
		
		if(trainstation.getMem()!=null){
			tmp.setMem(trainstation.getMem());
			
			flag++;
		}
		
		if(trainstation.getBack1()!=null){
			tmp.setBack1(trainstation.getBack1());
			
			flag++;
		}
		
		if(trainstation.getBack2()!=null){
			tmp.setBack2(trainstation.getBack2());
			
			flag++;
		}
		
		if(trainstation.getBack3()!=null){
			tmp.setBack3(trainstation.getBack3());
			
			flag++;
		}
		
		if(trainstation.getState()!=null){
			tmp.setState(trainstation.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateTrainstation",tmp);
		}
	}
	
	/**
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllTrainstation",map, offset, limit);
	}
		
	
	/**
	 * 查找 火车站信息
	 * @param id
	 * @return
	 */
	public Trainstation findTrainstation(long id){
		return (Trainstation)(getSqlMapClientTemplate().queryForObject("findTrainstation",id));
	}
	
	/** 
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainstationBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllTrainstation",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找火车站信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllTrainstationBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 火车站信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainstationBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteTrainstationBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainstationBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countTrainstationBySql",map).toString()));
	}
}

