package com.yf.system.base.company;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.PageInfo;
import com.yf.b2b2g.bean.Comlimit;
import com.yf.b2b2g.bean.Company;
import com.yf.b2b2g.bean.Department;
import com.yf.b2b2g.bean.Employee;
import com.yf.b2b2g.bean.Role;
import com.yf.b2b2g.bean.Rolelimit;
import com.yf.b2b2g.bean.Userrole;
import com.ibatis.sqlmap.client.SqlMapExecutor;

public class CompanyManger extends SqlMapClientDaoSupport implements ICompanyManger{

	@Override
	public Company createCompany(Company company) {
		this.getSqlMapClientTemplate().insert("createCompany",company);
		return company;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		this.getSqlMapClientTemplate().insert("createEmployee",employee);
		return employee;
	}

	@Override
	public Department createDepartment(Department dept) {
		this.getSqlMapClientTemplate().insert("createDepartment",dept);
		return dept;
	}

	@Override
	public List<Company> findAllcompany(Company company, PageInfo pageinfo) {
		
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCompany").toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCompany",company, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}

	@Override
	public Role createRole(Role role) {
		this.getSqlMapClientTemplate().insert("createRole", role);
		return role;
	}

	@Override
	public void createUserrole(Userrole ur) {
		this.getSqlMapClientTemplate().insert("createUserrole", ur);
		
	}

	@Override
	public void grantComlimit(final List<Comlimit> comlimits) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback(){

			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				for(Comlimit cl:comlimits){
					executor.insert("createComlimit",cl);
				}
				executor.executeBatch();
				return null;
			}
			
			
		});
		
	}
	
	

	@Override
	public int deleteComlimitByComid(long comid) {
		
		return this.getSqlMapClientTemplate().delete("deleteComlimitByComid", comid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRole(Role role) {
	
		return (List<Role>)this.getSqlMapClientTemplate().queryForList("findAllRole",role);
	}

	@Override
	public void grantRolelimit(final List<Rolelimit> rolelimits) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback(){

			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				for(Rolelimit cl:rolelimits){
					executor.insert("createRolelimit",cl);
				}
				executor.executeBatch();
				return null;
			}
			
			
		});
		
		
	}

	@Override
	public void deleteRolelimitByRoleid(long roleid) {
		this.getSqlMapClientTemplate().delete("deleteRolelimitByRoleid",roleid);
		
	}
	
	public void dleteRolelimitByComlimit(List<Comlimit> comlimits,long comid){
		StringBuilder str=new StringBuilder(comlimits.size());
		for(int i=0;i<comlimits.size();i++){
			Comlimit comlimit=comlimits.get(i);
			if(i>0){
				str.append(","+comlimit.getRightid());
			}else{
				str.append(comlimit.getRightid());
			}
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("comid", comid);
		map.put("limistr", str);
		this.getSqlMapClientTemplate().delete("deleteRolelimitByComlimit",map);
	}

	@Override
	public Company findComapany(long id) {
		return (Company)this.getSqlMapClientTemplate().queryForObject("findCompany",id);
	}
	
	

}
