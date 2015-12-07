package com.yf.b2b2g.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


import com.yf.b2b2g.dao.CustomeruserDao;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.util.PageInfo;


public class CustomeruserDaoImpl extends  SqlMapClientDaoSupport implements CustomeruserDao {

	@Override
	public Customeruser findCustomeruser(long id) {
		return (Customeruser)this.getSqlMapClientTemplate().queryForObject("findCustomeruser",id);
	}

	@Override
	public List<Customeruser> findCustomeruser(String where,String orderby,PageInfo pageinfo) {
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCustomeruserBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCustomeruser",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
		
	}

}
