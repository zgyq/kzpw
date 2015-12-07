/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.dcampaign;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class DcampaignManager extends  SqlMapClientDaoSupport  implements IDcampaignManager{ 
	
  
 	/**
	 * 创建 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public Dcampaign createDcampaign(Dcampaign dcampaign) throws SQLException{
	
		if(dcampaign.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		dcampaign.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_DCAMPAIGN"));
		getSqlMapClientTemplate().insert("createDcampaign",dcampaign);
		return dcampaign;
	}
	/**
	 * 删除 电子优惠卷活动
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDcampaign(long id){
	
		return getSqlMapClientTemplate().delete("deleteDcampaign", id);
	}
	
	
	/**
	 * 修改 电子优惠卷活动
	 * @param id
	 * @return updated count 
	 */
	public int updateDcampaign(Dcampaign dcampaign){
		return getSqlMapClientTemplate().update("updateDcampaign",dcampaign);
	
	}

		
	/**
	 * 修改 电子优惠卷活动但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDcampaignIgnoreNull(Dcampaign dcampaign){
		Dcampaign tmp = findDcampaign(dcampaign.getId());
		int flag =0;
		
		
		if(dcampaign.getName()!=null){
			tmp.setName(dcampaign.getName());
			
			flag++;
		}
		
		if(dcampaign.getCode()!=null){
			tmp.setCode(dcampaign.getCode());
			
			flag++;
		}
		if(dcampaign.getChaininfoid()!=null){
			tmp.setChaininfoid(dcampaign.getChaininfoid());
			
			flag++;
		}
		
		if(dcampaign.getDescription()!=null){
			tmp.setDescription(dcampaign.getDescription());
			
			flag++;
		}
		
		if(dcampaign.getPicsrc()!=null){
			tmp.setPicsrc(dcampaign.getPicsrc());
			
			flag++;
		}
		
		if(dcampaign.getBpicsrc()!=null){
			tmp.setBpicsrc(dcampaign.getBpicsrc());
			
			flag++;
		}
		
		if(dcampaign.getOnline()!=null){
			tmp.setOnline(dcampaign.getOnline());
			
			flag++;
		}
		
		if(dcampaign.getCreateuser()!=null){
			tmp.setCreateuser(dcampaign.getCreateuser());
			
			flag++;
		}
		
		if(dcampaign.getCreatetime()!=null){
			tmp.setCreatetime(dcampaign.getCreatetime());
			
			flag++;
		}
		
		if(dcampaign.getSttime()!=null){
			tmp.setSttime(dcampaign.getSttime());
			
			flag++;
		}
		
		if(dcampaign.getEndtime()!=null){
			tmp.setEndtime(dcampaign.getEndtime());
			
			flag++;
		}
		
		if(dcampaign.getSum()!=null){
			tmp.setSum(dcampaign.getSum());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateDcampaign",tmp);
		}
	}
	
	/**
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllDcampaign",map, offset, limit);
	}
		
	
	/**
	 * 查找 电子优惠卷活动
	 * @param id
	 * @return
	 */
	public Dcampaign findDcampaign(long id){
		return (Dcampaign)(getSqlMapClientTemplate().queryForObject("findDcampaign",id));
	}
	
	/** 
	 * 查找 电子优惠卷活动
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDcampaign(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDcampaignBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllDcampaign",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找电子优惠卷活动
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDcampaign(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllDcampaignBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 电子优惠卷活动
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDcampaignBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteDcampaignBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDcampaignBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countDcampaignBySql",map).toString()));
	}
}

