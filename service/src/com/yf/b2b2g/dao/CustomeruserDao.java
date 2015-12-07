package com.yf.b2b2g.dao;

import java.util.List;

import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.util.PageInfo;

public interface CustomeruserDao {
	
	public Customeruser findCustomeruser(long id);
	
	public List<Customeruser> findCustomeruser(String where,String orderby,PageInfo pageInfo);
	
}
