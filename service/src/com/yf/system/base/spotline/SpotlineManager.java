/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotline;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotlineManager extends  SqlMapClientDaoSupport  implements ISpotlineManager{ 
	
  
 	/**
	 * 创建 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotline createSpotline(Spotline spotline) throws SQLException{
	
		if(spotline.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotline.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTLINE"));
		getSqlMapClientTemplate().insert("createSpotline",spotline);
		return spotline;
	}
	/**
	 * 删除 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotline(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotline", id);
	}
	
	
	/**
	 * 修改 景区线路信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotline(Spotline spotline){
		return getSqlMapClientTemplate().update("updateSpotline",spotline);
	
	}

		
	/**
	 * 修改 景区线路信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineIgnoreNull(Spotline spotline){
		Spotline tmp = findSpotline(spotline.getId());
		int flag =0;
		
		
		if(spotline.getOutid()!=null){
			tmp.setOutid(spotline.getOutid());
			
			flag++;
		}
		
		if(spotline.getSid()!=null){
			tmp.setSid(spotline.getSid());
			
			flag++;
		}
		
		if(spotline.getAgentid()!=null){
			tmp.setAgentid(spotline.getAgentid());
			
			flag++;
		}
		
		if(spotline.getName()!=null){
			tmp.setName(spotline.getName());
			
			flag++;
		}
		
		if(spotline.getProvineid()!=null){
			tmp.setProvineid(spotline.getProvineid());
			
			flag++;
		}
		
		if(spotline.getCityid()!=null){
			tmp.setCityid(spotline.getCityid());
			
			flag++;
		}
		
		if(spotline.getAreaid()!=null){
			tmp.setAreaid(spotline.getAreaid());
			
			flag++;
		}
		
		if(spotline.getAddress()!=null){
			tmp.setAddress(spotline.getAddress());
			
			flag++;
		}
		
		if(spotline.getInfo()!=null){
			tmp.setInfo(spotline.getInfo());
			
			flag++;
		}
		
		if(spotline.getTraffic()!=null){
			tmp.setTraffic(spotline.getTraffic());
			
			flag++;
		}
		
		if(spotline.getNotice()!=null){
			tmp.setNotice(spotline.getNotice());
			
			flag++;
		}
		
		if(spotline.getPics()!=null){
			tmp.setPics(spotline.getPics());
			
			flag++;
		}
		
		if(spotline.getMinipics()!=null){
			tmp.setMinipics(spotline.getMinipics());
			
			flag++;
		}
		
		if(spotline.getTicketnotic()!=null){
			tmp.setTicketnotic(spotline.getTicketnotic());
			
			flag++;
		}
		
		if(spotline.getGuidelines()!=null){
			tmp.setGuidelines(spotline.getGuidelines());
			
			flag++;
		}
		
		if(spotline.getStime()!=null){
			tmp.setStime(spotline.getStime());
			
			flag++;
		}
		
		if(spotline.getDays()!=null){
			tmp.setDays(spotline.getDays());
			
			flag++;
		}
		
		if(spotline.getSnums()!=null){
			tmp.setSnums(spotline.getSnums());
			
			flag++;
		}
		
		if(spotline.getParam1()!=null){
			tmp.setParam1(spotline.getParam1());
			
			flag++;
		}
		
		if(spotline.getParam2()!=null){
			tmp.setParam2(spotline.getParam2());
			
			flag++;
		}
		
		if(spotline.getParam3()!=null){
			tmp.setParam3(spotline.getParam3());
			
			flag++;
		}
		
		if(spotline.getCreatetime()!=null){
			tmp.setCreatetime(spotline.getCreatetime());
			
			flag++;
		}
		
		if(spotline.getMemberid()!=null){
			tmp.setMemberid(spotline.getMemberid());
			
			flag++;
		}
		
		if(spotline.getStype()!=null){
			tmp.setStype(spotline.getStype());
			
			flag++;
		}
		
		if(spotline.getDjsname()!=null){
			tmp.setDjsname(spotline.getDjsname());
			
			flag++;
		}
		
		if(spotline.getDjstel()!=null){
			tmp.setDjstel(spotline.getDjstel());
			
			flag++;
		}
		
		if(spotline.getDjslinkname()!=null){
			tmp.setDjslinkname(spotline.getDjslinkname());
			
			flag++;
		}
		
		if(spotline.getDjsaddress()!=null){
			tmp.setDjsaddress(spotline.getDjsaddress());
			
			flag++;
		}
		
		if(spotline.getFwbz()!=null){
			tmp.setFwbz(spotline.getFwbz());
			
			flag++;
		}
		
		if(spotline.getBaohan()!=null){
			tmp.setBaohan(spotline.getBaohan());
			
			flag++;
		}
		
		if(spotline.getBubaohan()!=null){
			tmp.setBubaohan(spotline.getBubaohan());
			
			flag++;
		}
		
		if(spotline.getMenshibeizhu()!=null){
			tmp.setMenshibeizhu(spotline.getMenshibeizhu());
			
			flag++;
		}
		
		if(spotline.getState()!=null){
			tmp.setState(spotline.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotline",tmp);
		}
	}
	
	/**
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotline",map, offset, limit);
	}
		
	
	/**
	 * 查找 景区线路信息
	 * @param id
	 * @return
	 */
	public Spotline findSpotline(long id){
		return (Spotline)(getSqlMapClientTemplate().queryForObject("findSpotline",id));
	}
	
	/** 
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotline",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景区线路信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotlineBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景区线路信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotlineBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotlineBySql",map).toString()));
	}
}

