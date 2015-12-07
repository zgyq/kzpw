package com.yf.system.back.services;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;


public interface CustomeragentService {
	
	
	/**
	 * 添加加盟商
	 * @return
	 */
	public void  add(Customeragent agent);
	public void  add(Customeragent agent,Customeruser user,String[] bussiness,long createagentid);
	public void  editAgent(Customeragent agent,Customeruser user,String[] bussiness,long createagentid);
	public float getTotalVmoney(long id);
	public float addAgentvmoney(long id,float money);
	

}
