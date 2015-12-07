/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.zrate;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.service.ZrateServer;
import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class ZrateManager extends  SqlMapClientDaoSupport  implements IZrateManager{ 
	
  
 	/**
	 * 创建 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public Zrate createZrate(Zrate zrate) throws SQLException{
	
		/*if(zrate.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		zrate.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), ZrateBean.TABLE));
		 */	
		getSqlMapClientTemplate().insert("createZrate",zrate);
		
		return zrate;
	}
	/**
	 * 删除 普通政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteZrate(long id){
	
		return getSqlMapClientTemplate().delete("deleteZrate", id);
	}
	
	
	/**
	 * 修改 普通政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateZrate(Zrate zrate){
		return getSqlMapClientTemplate().update("updateZrate",zrate);
	
	}

		
	/**
	 * 修改 普通政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateZrateIgnoreNull(Zrate zrate){
		Zrate tmp = findZrateByDB(zrate.getId());
		int flag =0;
		
		
		if(zrate.getDepartureport()!=null){
			tmp.setDepartureport(zrate.getDepartureport());
			
			flag++;
		}
		
		if(zrate.getArrivalport()!=null){
			tmp.setArrivalport(zrate.getArrivalport());
			
			flag++;
		}
		
		if(zrate.getTraveltype()!=null){
			tmp.setTraveltype(zrate.getTraveltype());
			
			flag++;
		}
		if(zrate.getArrivalexclude()!=null){
			tmp.setArrivalexclude(zrate.getArrivalexclude());
			
			flag++;
		}
		if(zrate.getDepartureexclude()!=null){
			tmp.setDepartureexclude(zrate.getDepartureexclude());
			
			flag++;
		}
		
		if(zrate.getOutpattern()!=null){
			tmp.setOutpattern(zrate.getOutpattern());
			
			flag++;
		}
		
		if(zrate.getMoneykeep()!=null){
			tmp.setMoneykeep(zrate.getMoneykeep());
			
			flag++;
		}
		
		if(zrate.getPointkeep()!=null){
			tmp.setPointkeep(zrate.getPointkeep());
			
			flag++;
		}
		
		if(zrate.getFlightnumber()!=null){
			tmp.setFlightnumber(zrate.getFlightnumber());
			
			flag++;
		}
		
		if(zrate.getCabincode()!=null){
			tmp.setCabincode(zrate.getCabincode());
			
			flag++;
		}
		
		if(zrate.getRatevalue()!=null){
			tmp.setRatevalue(zrate.getRatevalue());
			
			flag++;
		}
		
		if(zrate.getCreateuser()!=null){
			tmp.setCreateuser(zrate.getCreateuser());
			
			flag++;
		}
		
		if(zrate.getCreatetime()!=null){
			tmp.setCreatetime(zrate.getCreatetime());
			
			flag++;
		}
		
		if(zrate.getModifyuser()!=null){
			tmp.setModifyuser(zrate.getModifyuser());
			
			flag++;
		}
		
		if(zrate.getAfterworktime()!=null){
			tmp.setAfterworktime(zrate.getAfterworktime());
			
			flag++;
		}
		if(zrate.getWorktime()!=null){
			tmp.setWorktime(zrate.getWorktime());
			
			flag++;
		}
		
		if(zrate.getModifytime()!=null){
			tmp.setModifytime(zrate.getModifytime());
			
			flag++;
		}
		
		if(zrate.getIssuedstartdate()!=null){
			tmp.setIssuedstartdate(zrate.getIssuedstartdate());
			
			flag++;
		}
		
		if(zrate.getIssuedendate()!=null){
			tmp.setIssuedendate(zrate.getIssuedendate());
			
			flag++;
		}
		
		if(zrate.getRemark()!=null){
			tmp.setRemark(zrate.getRemark());
			
			flag++;
		}
		
		if(zrate.getWeeknum()!=null){
			tmp.setWeeknum(zrate.getWeeknum());
			
			flag++;
		}
		
		if(zrate.getIsenable()!=null){
			tmp.setIsenable(zrate.getIsenable());
			
			flag++;
		}
		
		if(zrate.getFlightisuse()!=null){
			tmp.setFlightisuse(zrate.getFlightisuse());
			
			flag++;
		}
		
		if(zrate.getAircompanycode()!=null){
			tmp.setAircompanycode(zrate.getAircompanycode());
			
			flag++;
		}
		
		if(zrate.getAgentid()!=null){
			tmp.setAgentid(zrate.getAgentid());
			
			flag++;
		}
		
		if(zrate.getTickettype()!=null){
			tmp.setTickettype(zrate.getTickettype());
			
			flag++;
		}
		
		if(zrate.getRelationzrateid()!=null){
			tmp.setRelationzrateid(zrate.getRelationzrateid());
			
			flag++;
		}
		
		if(zrate.getAgentcode()!=null){
			tmp.setAgentcode(zrate.getAgentcode());
			
			flag++;
		}
		
		if(zrate.getType()!=null){
			tmp.setType(zrate.getType());
			
			flag++;
		}
		
		if(zrate.getUcode()!=null){
			tmp.setUcode(zrate.getUcode());
			
			flag++;
		}
		
		if(zrate.getLanguage()!=null){
			tmp.setLanguage(zrate.getLanguage());
			
			flag++;
		}
		
		if(zrate.getIsauto()!=null){
			tmp.setIsauto(zrate.getIsauto());
			
			flag++;
		}
		
		if(zrate.getIschange()!=null){
			tmp.setIschange(zrate.getIschange());
			
			flag++;
		}
		
		if(zrate.getLocalzrate()!=null){
			tmp.setLocalzrate(zrate.getLocalzrate());
			
			flag++;
		}
		
		if(zrate.getAddratevalue()!=null){
			tmp.setAddratevalue(zrate.getAddratevalue());
			
			flag++;
		}
		
		if(zrate.getGeneral()!=null){
			tmp.setGeneral(zrate.getGeneral());
			
			flag++;
		}
		
		if(zrate.getZratetype()!=null){
			tmp.setZratetype(zrate.getZratetype());
			
			flag++;
		}
		
		if(zrate.getBegindate()!=null){
			tmp.setBegindate(zrate.getBegindate());
			
			flag++;
		}
		
		if(zrate.getEnddate()!=null){
			tmp.setEnddate(zrate.getEnddate());
			
			flag++;
		}
		
		if(zrate.getIstype()!=null){
			tmp.setIstype(zrate.getIstype());
			
			flag++;
		}
		
		if(zrate.getSpeed()!=null){
			tmp.setSpeed(zrate.getSpeed());
			
			flag++;
		}
		
		if(zrate.getFeetype()!=null){
			tmp.setFeetype(zrate.getFeetype());
			
			flag++;
		}
		if(zrate.getAgentfee()!=null){
			tmp.setAgentfee(zrate.getAgentfee());
			
			flag++;
		}
		if(zrate.getOnetofiveworktime()!=null){
			tmp.setOnetofiveworktime(zrate.getOnetofiveworktime());
			
			flag++;
		}
		if(zrate.getOnetofiveaftertime()!=null){
			tmp.setOnetofiveaftertime(zrate.getOnetofiveaftertime());
			
			flag++;
		}
		if(zrate.getWeekendworktime()!=null){
			tmp.setWeekendworktime(zrate.getWeekendworktime());
			
			flag++;
		}
		if(zrate.getWeekendaftertime()!=null){
			tmp.setWeekendaftertime(zrate.getWeekendaftertime());
			
			flag++;
		}
		if(zrate.getOnetofivewastetime()!=null){
			tmp.setOnetofivewastetime(zrate.getOnetofivewastetime());
			
			flag++;
		}
		if(zrate.getWeekendwastetime()!=null){
			tmp.setWeekendwastetime(zrate.getWeekendwastetime());
			
			flag++;
		}
		if(zrate.getZtype()!=null){
			tmp.setZtype(zrate.getZtype());
			
			flag++;
		}
		if(zrate.getVoyagetype()!=null){
			tmp.setVoyagetype(zrate.getVoyagetype());
			
			flag++;
		}
		if(zrate.getSchedule()!=null){
			tmp.setSchedule(zrate.getSchedule());
			
			flag++;
		}
		if(zrate.getUsertype()!=null){
			tmp.setUsertype(zrate.getUsertype());
			
			flag++;
		}
		if(zrate.getWorkstatus()!=null){
			tmp.setWorkstatus(zrate.getWorkstatus());
			
			flag++;
		}
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateZrate",tmp);
		}
	}
	
	/**
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrate(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllZrate",map, offset, limit);
	}
		
	
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrate(long id){
		///return (Zrate)(getSqlMapClientTemplate().queryForObject("findZrate",id));
		// agentid 为0为所有   key=本地ID$外部id  *为所有
		System.out.println("findZrate:"+id+",KEY:"+id+"$*");
		return ZrateServer.getInstance().findZrate(0l, id+"$*");
	}
	/**
	 * 查找 普通政策表
	 * @param id
	 * @return
	 */
	public Zrate findZrateByDB(long id){
		return (Zrate)(getSqlMapClientTemplate().queryForObject("findZrate",id));
		// agentid 为0为所有   key=本地ID$外部id  *为所有
		//System.out.println("findZrate:"+id+",KEY:"+id+"$*");
		//return ZrateServer.getInstance().findZrate(0l, id+"$*");
	}
	
	/** 
	 * 查找 普通政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllZrate(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countZrateBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllZrate",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
	
	/**
	 * 调用分页存储过程
	 * Created by:sunbin
	 * @param tableName  表名
	 * @param fldName    查询字段名，所有字段输入*
	 * @param fldSort    每页显示的记录个数
	 * @param sort       排序方法，0为升序，1为降序
	 * @param where      查询条件,不需where
	 * @param fldID      主表的主键 
	 * @param pageinfo   分页信息
	 * @return  
	 */
	public List findAllZrateBySP(String tableName,String fldName, String fldSort,int sort,String where,String fldID,PageInfo pageinfo )
	{
		Map<String,Object> param = new HashMap<String,Object>();  
		param.put("tlbname", tableName);  
		param.put("fldname", fldName);  
		param.put("pagesize", pageinfo.getPagerow()); 
		param.put("currentpage", pageinfo.getPagenum());  
		param.put("fldsort", fldSort);  
		param.put("sort", sort);  
		param.put("where", where);  
		param.put("fldid", fldID); 
		param.put("dist", 0);
		
		Iterator<Map.Entry<String, Object>> iterator=param.entrySet().iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<String, Object> item=iterator.next();
			System.out.println(item.getKey()+":"+item.getValue());
		}
		
		List list =getSqlMapClientTemplate().queryForList("sppagination", param); 
		//查询出的总记录数
		pageinfo.setTotalrow(Integer.parseInt(param.get("totalcount").toString()));
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找普通政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllZrate(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllZrateBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 普通政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteZrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteZrateBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countZrateBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countZrateBySql",map).toString()));
	}
}

