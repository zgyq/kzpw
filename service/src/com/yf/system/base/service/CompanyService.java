package com.yf.system.base.service;

import java.util.ArrayList;
import java.util.List;

import com.yf.system.base.company.ICompanyManger;
import com.yf.system.base.util.PageInfo;
import com.yf.b2b2g.bean.Comlimit;
import com.yf.b2b2g.bean.Company;
import com.yf.b2b2g.bean.Department;
import com.yf.b2b2g.bean.Employee;
import com.yf.b2b2g.bean.Role;
import com.yf.b2b2g.bean.Rolelimit;
import com.yf.b2b2g.bean.Userrole;

public class CompanyService implements ICompanyService {

	private ICompanyManger companymanger;

	@Override
	public void createCompany(Company company, Employee employee) {
		Company com = this.companymanger.createCompany(company);
		employee.setComid(com.getId());
		Department dept = new Department();
		dept.setComid(com.getId());
		dept.setDeptid("");
		dept.setParentid(0);
		dept.setParentstr("0");
		String name = com.getSimnamecn();
		if (name == null || name.length() == 0) {
			name = com.getCnamecn();
		}
		dept.setDeptname(name);
		Role role = new Role();
		role.setComid(com.getId());
		role.setName("管理员");
		role.setType(1);
		role.setMemo("");
		Role cr = this.companymanger.createRole(role);
		Department cdept = this.companymanger.createDepartment(dept);
		employee.setDeptid(cdept.getId());
		Employee ce = this.companymanger.createEmployee(employee);
		Userrole ur = new Userrole();
		ur.setEmpid(ce.getId());
		ur.setRoleid(cr.getId());
		this.companymanger.createUserrole(ur);
	}

	public void setCompanymanger(ICompanyManger companymanger) {
		this.companymanger = companymanger;
	}

	public ICompanyManger getCompanymanger() {
		return companymanger;
	}

	@Override
	public List<Company> findAllComapany(Company company, PageInfo pageinfo) {
		return this.companymanger.findAllcompany(company, pageinfo);
	}



	@Override
	public void grantComlimit(List<Comlimit> comlimits, long comid) {
		
		if (comlimits.size() > 0) {
			this.companymanger.deleteComlimitByComid(comid);
			this.companymanger.grantComlimit(comlimits);
			Role role = new Role();
			role.setType(1);
			role.setComid(comid);
			List<Role> roles = this.companymanger.findAllRole(role);
			if (roles.size() == 0) {
				role.setName("管理员");
				role.setMemo("");
				role = this.companymanger.createRole(role);
			} else {
				role = roles.get(0);
			}
			List<Rolelimit> listrole = new ArrayList<Rolelimit>();
			for (Comlimit comli : comlimits) {
				Rolelimit rolelimit = new Rolelimit();
				rolelimit.setLimitid(comli.getRightid());
				rolelimit.setRoleid(role.getId());
				listrole.add(rolelimit);
			}
			this.companymanger.deleteRolelimitByRoleid(role.getId());
			this.companymanger.grantRolelimit(listrole);
			this.companymanger.dleteRolelimitByComlimit(comlimits, comid);

		} else {
			this.companymanger.deleteComlimitByComid(comid);
		}
	}

	@Override
	public Company findCompany(long id) {
		return this.companymanger.findComapany(id);
	}

}
