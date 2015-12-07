/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.wanlixing;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class WanlixingManager extends  SqlMapClientDaoSupport  implements IWanlixingManager{ 
	
  
 	/**
	 * 创建 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public Wanlixing createWanlixing(Wanlixing wanlixing) throws SQLException{
	
		if(wanlixing.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		wanlixing.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_WANLIXING"));
		getSqlMapClientTemplate().insert("createWanlixing",wanlixing);
		return wanlixing;
	}
	/**
	 * 删除 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWanlixing(long id){
	
		return getSqlMapClientTemplate().delete("deleteWanlixing", id);
	}
	
	
	/**
	 * 修改 万里行申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateWanlixing(Wanlixing wanlixing){
		return getSqlMapClientTemplate().update("updateWanlixing",wanlixing);
	
	}

		
	/**
	 * 修改 万里行申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWanlixingIgnoreNull(Wanlixing wanlixing){
		Wanlixing tmp = findWanlixing(wanlixing.getId());
		int flag =0;
		
		
		if(wanlixing.getSex()!=null){
			tmp.setSex(wanlixing.getSex());
			
			flag++;
		}
		
		if(wanlixing.getChenghu()!=null){
			tmp.setChenghu(wanlixing.getChenghu());
			
			flag++;
		}
		
		if(wanlixing.getZxing()!=null){
			tmp.setZxing(wanlixing.getZxing());
			
			flag++;
		}
		
		if(wanlixing.getZming()!=null){
			tmp.setZming(wanlixing.getZming());
			
			flag++;
		}
		
		if(wanlixing.getYxing()!=null){
			tmp.setYxing(wanlixing.getYxing());
			
			flag++;
		}
		
		if(wanlixing.getYming()!=null){
			tmp.setYming(wanlixing.getYming());
			
			flag++;
		}
		
		if(wanlixing.getNumber()!=null){
			tmp.setNumber(wanlixing.getNumber());
			
			flag++;
		}
		
		if(wanlixing.getHuzhao()!=null){
			tmp.setHuzhao(wanlixing.getHuzhao());
			
			flag++;
		}
		
		if(wanlixing.getJun()!=null){
			tmp.setJun(wanlixing.getJun());
			
			flag++;
		}
		
		if(wanlixing.getHui()!=null){
			tmp.setHui(wanlixing.getHui());
			
			flag++;
		}
		
		if(wanlixing.getQita()!=null){
			tmp.setQita(wanlixing.getQita());
			
			flag++;
		}
		
		if(wanlixing.getGuoji()!=null){
			tmp.setGuoji(wanlixing.getGuoji());
			
			flag++;
		}
		
		if(wanlixing.getChusheng()!=null){
			tmp.setChusheng(wanlixing.getChusheng());
			
			flag++;
		}
		
		if(wanlixing.getYuyan()!=null){
			tmp.setYuyan(wanlixing.getYuyan());
			
			flag++;
		}
		
		if(wanlixing.getPassword()!=null){
			tmp.setPassword(wanlixing.getPassword());
			
			flag++;
		}
		
		if(wanlixing.getWenti()!=null){
			tmp.setWenti(wanlixing.getWenti());
			
			flag++;
		}
		
		if(wanlixing.getDaan()!=null){
			tmp.setDaan(wanlixing.getDaan());
			
			flag++;
		}
		
		if(wanlixing.getPostbox()!=null){
			tmp.setPostbox(wanlixing.getPostbox());
			
			flag++;
		}
		
		if(wanlixing.getYoutype()!=null){
			tmp.setYoutype(wanlixing.getYoutype());
			
			flag++;
		}
		
		if(wanlixing.getYoujiguo()!=null){
			tmp.setYoujiguo(wanlixing.getYoujiguo());
			
			flag++;
		}
		
		if(wanlixing.getYoujisheng()!=null){
			tmp.setYoujisheng(wanlixing.getYoujisheng());
			
			flag++;
		}
		
		if(wanlixing.getYoubian()!=null){
			tmp.setYoubian(wanlixing.getYoubian());
			
			flag++;
		}
		
		if(wanlixing.getShi()!=null){
			tmp.setShi(wanlixing.getShi());
			
			flag++;
		}
		
		if(wanlixing.getAddress()!=null){
			tmp.setAddress(wanlixing.getAddress());
			
			flag++;
		}
		
		if(wanlixing.getDianhua()!=null){
			tmp.setDianhua(wanlixing.getDianhua());
			
			flag++;
		}
		
		if(wanlixing.getFax()!=null){
			tmp.setFax(wanlixing.getFax());
			
			flag++;
		}
		
		if(wanlixing.getDuizhangtype()!=null){
			tmp.setDuizhangtype(wanlixing.getDuizhangtype());
			
			flag++;
		}
		
		if(wanlixing.getMobile()!=null){
			tmp.setMobile(wanlixing.getMobile());
			
			flag++;
		}
		
		if(wanlixing.getCopname()!=null){
			tmp.setCopname(wanlixing.getCopname());
			
			flag++;
		}
		
		if(wanlixing.getJibie()!=null){
			tmp.setJibie(wanlixing.getJibie());
			
			flag++;
		}
		
		if(wanlixing.getXingzhi()!=null){
			tmp.setXingzhi(wanlixing.getXingzhi());
			
			flag++;
		}
		
		if(wanlixing.getCreatetime()!=null){
			tmp.setCreatetime(wanlixing.getCreatetime());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateWanlixing",tmp);
		}
	}
	
	/**
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllWanlixing",map, offset, limit);
	}
		
	
	/**
	 * 查找 万里行申请表
	 * @param id
	 * @return
	 */
	public Wanlixing findWanlixing(long id){
		return (Wanlixing)(getSqlMapClientTemplate().queryForObject("findWanlixing",id));
	}
	
	/** 
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countWanlixingBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllWanlixing",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找万里行申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllWanlixingBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 万里行申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWanlixingBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteWanlixingBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWanlixingBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countWanlixingBySql",map).toString()));
	}
}

