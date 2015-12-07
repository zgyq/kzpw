package com.yf.b2b2g.base.service;

import com.yf.system.base.customeruser.Customeruser;

public interface CustomeruserService {
	
	public Customeruser findUser(long id);
	
	public Customeruser findUserbyInfo(String name,String password);

}
