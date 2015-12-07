/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */

package com.yf.system.base.intermanager;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class IntermanagerManager extends SqlMapClientDaoSupport implements
		IIntermanagerManager {

	/**
	 * 创建 接口管理
	 * 
	 * @param id
	 * @return deleted count
	 */
	public Intermanager createIntermanager(Intermanager intermanager)
			throws SQLException {

		if (intermanager.getId() > 0) {
			throw new SQLException("ID must <= 0.");
		}
		intermanager.setId(DBTools.getID(getSqlMapClientTemplate()
				.getDataSource().getConnection(), "T_INTERMANAGER"));
		getSqlMapClientTemplate().insert("createIntermanager", intermanager);
		return intermanager;
	}

	/**
	 * 删除 接口管理
	 * 
	 * @param id
	 * @return deleted count
	 */
	public int deleteIntermanager(long id) {

		return getSqlMapClientTemplate().delete("deleteIntermanager", id);
	}

	/**
	 * 修改 接口管理
	 * 
	 * @param id
	 * @return updated count
	 */
	public int updateIntermanager(Intermanager intermanager) {
		return getSqlMapClientTemplate().update("updateIntermanager",
				intermanager);

	}

	/**
	 * 修改 接口管理但忽略空值
	 * 
	 * @param id
	 * @return
	 */
	public int updateIntermanagerIgnoreNull(Intermanager intermanager) {
		Intermanager tmp = findIntermanager(intermanager.getId());
		int flag = 0;

		if (intermanager.getInterurl() != null) {
			tmp.setInterurl(intermanager.getInterurl());

			flag++;
		}

		if (intermanager.getResourceip() != null) {
			tmp.setResourceip(intermanager.getResourceip());

			flag++;
		}

		if (intermanager.getLimittype() != null) {
			tmp.setLimittype(intermanager.getLimittype());

			flag++;
		}

		if (intermanager.getLimittimes() != null) {
			tmp.setLimittimes(intermanager.getLimittimes());

			flag++;
		}

		if (intermanager.getEffecttimes() != null) {
			tmp.setEffecttimes(intermanager.getEffecttimes());

			flag++;
		}

		if (intermanager.getStarttime() != null) {
			tmp.setStarttime(intermanager.getStarttime());

			flag++;
		}

		if (intermanager.getEndtime() != null) {
			tmp.setEndtime(intermanager.getEndtime());

			flag++;
		}

		if (intermanager.getCurtime() != null) {
			tmp.setCurtime(intermanager.getCurtime());

			flag++;
		}

		if (intermanager.getState() != null) {
			tmp.setState(intermanager.getState());

			flag++;
		}

		if (flag == 0) {
			return 0;
		} else {
			return getSqlMapClientTemplate().update("updateIntermanager", tmp);
		}
	}

	/**
	 * 查找 接口管理
	 * 
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby, int limit,
			int offset) {
		Map map = new HashMap();
		if (limit < 0) {
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllIntermanager",
				map, offset, limit);
	}

	/**
	 * 查找 接口管理
	 * 
	 * @param id
	 * @return
	 */
	public Intermanager findIntermanager(long id) {
		return (Intermanager) (getSqlMapClientTemplate().queryForObject(
				"findIntermanager", id));
	}

	/**
	 * 查找 接口管理
	 * 
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntermanager(String where, String orderby,
			PageInfo pageinfo) {
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate()
				.queryForObject("countIntermanagerBySql", map).toString()));
		int offset = pageinfo.getOffset();
		int limit = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList(
				"findAllIntermanager", map, offset, limit);
		if (list != null) {
			list.add(0, pageinfo);
		}
		return list;
	}

	/**
	 * 根据Sql查找接口管理
	 * 
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntermanager(String sql, int limit, int offset) {
		Map map = new HashMap();
		map.put("sql", sql);
		if (limit < 0) {
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList(
				"findAllIntermanagerBySql", map, offset, limit);
	}

	/**
	 * 执行Sql 接口管理
	 * 
	 * @param sql
	 * @return updated count
	 */
	public int excuteIntermanagerBySql(String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteIntermanagerBySql", map);
	}

	/**
	 * 执行Sql
	 * 
	 * @param sql
	 * @return count
	 */
	public int countIntermanagerBySql(String sql) {
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject(
				"countIntermanagerBySql", map).toString()));
	}

	/**
	 * 执行sql返回动态结果集
	 * 
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultBySql(String sql, PageInfo pageinfo) {
		Map map = new HashMap();
		map.put("sql", sql);
		if (pageinfo == null) {
			return getSqlMapClientTemplate().queryForList("findMapResultBySql",
					map);
		}
		Map m = new HashMap();
		m.put("sql", "SELECT COUNT(*) FROM (" + sql + ") AS T");

		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate()
				.queryForObject("countIntermanagerBySql", m).toString()));
		int offset = pageinfo.getOffset();
		int limit = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList(
				"findMapResultBySql", map, offset, limit);

		if (list != null) {
			list.add(0, pageinfo);
		}
		return list;
	}

	/**
	 * 执行存贮过程返回动态结果集
	 * 
	 * @param sql
	 * @param pageinfo
	 * @return
	 */
	public List findMapResultByProcedure(String procedure) {
		Map map = new HashMap();
		map.put("procedure", procedure);
		return getSqlMapClientTemplate().queryForList(
				"findMapResultByProcedure", map);
	}

	@Override
	public List findMapResultSortBySql(String sql, String orderby,
			PageInfo pageinfo) {
		Map map = new HashMap();
		map.put("sql", sql + " " + orderby);
		if (pageinfo == null) {
			return getSqlMapClientTemplate().queryForList("findMapResultBySql",
					map);
		}
		Map m = new HashMap();
		m.put("sql", "SELECT COUNT(*) FROM (" + sql + ") AS T");

		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate()
				.queryForObject("countIntermanagerBySql", m).toString()));
		int offset = pageinfo.getOffset();
		int limit = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList(
				"findMapResultBySql", map, offset, limit);

		if (list != null) {
			list.add(0, pageinfo);
		}
		return list;
	}

	@Override
	public <T> T getTObject(Class<T> cls, long id, String... clos) {
		String objname = cls.getSimpleName();
		if (clos != null && clos.length > 0) {
			StringBuilder sql = new StringBuilder("SELECT ");
			for(int i=0;i<clos.length;i++){
				String clu=clos[i];
				sql.append(clu );
				if(i!=clos.length-1){
					sql.append(",");
				}
			}
			sql.append(" FROM T_"+objname.toUpperCase()+" WHERE ID="+id);
			Map map = new HashMap();
			map.put("sql", sql);
			System.out.println(sql.toString());
			T agent=(T)getSqlMapClientTemplate().queryForObject(
					"find"+objname+"BySql", map);
			return agent;
		}
		return (T) (getSqlMapClientTemplate().queryForObject("find" + objname,
				id));

	}

	@Override
	public List findMapResultPageByProcedure(String tableName, String fldName,
			String fldSort, int sort, String where, String fldID,
			PageInfo pageinfo) {
		Map<String,Object> param = new HashMap<String,Object>();  
		param.put("tblname", tableName);  
		param.put("strgetfields", fldName);  
		param.put("pagesize", pageinfo.getPagerow()); 
		param.put("pageindex", pageinfo.getPagenum());  
		param.put("fldname", fldSort);  
		param.put("strwhere", where);  
		param.put("ordertype", sort);  
		
		Iterator<Map.Entry<String, Object>> iterator=param.entrySet().iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<String, Object> item=iterator.next();
			System.out.println(item.getKey()+":"+item.getValue());
		}
		
		List list =getSqlMapClientTemplate().queryForList("sp_mypagenation", param); 
		//查询出的总记录数
		pageinfo.setTotalrow(Integer.parseInt(param.get("total").toString()));
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}

}
