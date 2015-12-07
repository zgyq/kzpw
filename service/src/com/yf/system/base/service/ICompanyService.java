package com.yf.system.base.service;

import java.util.List;

import com.yf.system.base.util.PageInfo;
import com.yf.b2b2g.bean.Comlimit;
import com.yf.b2b2g.bean.Company;
import com.yf.b2b2g.bean.Employee;


public interface ICompanyService  {
	
	/**
	 * 添加企业与管理员
	 * @param company
	 * @param employee
	 * @return
	 */
	public void createCompany(Company company,Employee employee);
	
	
	public List<Company> findAllComapany(Company company,PageInfo pageinfo);
	
	
	public void grantComlimit(List<Comlimit> comlimits,long comid);
	
	
	public Company findCompany(long id);
			
}
