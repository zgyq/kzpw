package com.yf.system.base.company;

import java.util.List;

import com.yf.system.base.util.PageInfo;
import com.yf.b2b2g.bean.Comlimit;
import com.yf.b2b2g.bean.Company;
import com.yf.b2b2g.bean.Department;
import com.yf.b2b2g.bean.Employee;
import com.yf.b2b2g.bean.Role;
import com.yf.b2b2g.bean.Rolelimit;
import com.yf.b2b2g.bean.Userrole;

public interface ICompanyManger {
	/**
	 * 创建企业
	 * @param company
	 * @return
	 */
	public Company createCompany(Company company);
	
	/**
	 * 创建部门
	 * @param dept
	 * @return
	 */
	public Department createDepartment(Department dept);
	
	/**
	 * 创建雇员
	 * @param employee
	 * @return
	 */
	public Employee  createEmployee(Employee employee);
	
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	public Role createRole(Role role);
	
	
	/**
	 * 用户分配角色
	 * @param ur
	 */
	public void createUserrole(Userrole ur);
	
	
	/**
	 * 查询企业
	 * @param company
	 * @param pageinfo
	 * @return
	 */
	public List<Company> findAllcompany(Company company,PageInfo pageinfo);
	
	
	public void grantComlimit(List<Comlimit> comlimits);
	
	
	public int deleteComlimitByComid(long comid);
	
	
	public List<Role> findAllRole(Role role);
	
	public void grantRolelimit(List<Rolelimit> rolelimits);
	
	
	public void deleteRolelimitByRoleid(long roleid);
	
	public void dleteRolelimitByComlimit(List<Comlimit> comlimits,long comid);
	
	public Company findComapany(long id);
}
