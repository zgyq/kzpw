package com.yf.system.back.action;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.yf.b2b2g.bean.Comlimit;
import com.yf.b2b2g.bean.Company;
import com.yf.b2b2g.bean.Employee;
import com.opensymphony.webwork.ServletActionContext;

@SuppressWarnings("serial")
public class CompanyAction extends B2b2cbackAction{
	private Company company=new Company();
	
	private String sipactbgtime;
	private String sipactendtime;
	
	private Employee employee=new Employee();
	
	private List<Systemright> limits;
	
	
	private List<Systemright> rolelimits;
	
	
	
	private List<Company> companys;
	
	
	public String toadd(){
		return "add";
	}
	public String add(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");	
		company.setIspacttime(super.getCurrentTime());
		try {
			company.setIspactvalidbgtime(new Timestamp(format.parse(sipactbgtime).getTime()));
			company.setIspactvalidendtime(new Timestamp(format.parse(sipactendtime).getTime()));
		} catch (ParseException e1) {
		}
		try {
			employee.setPassword(Util.MD5(employee.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Server.getInstance().getCompanyService().createCompany(company, employee);
		return this.companys();
		
	}
	
	public String companys(){
		List list=Server.getInstance().getCompanyService().findAllComapany(company, pageinfo);
		this.pageinfo=(PageInfo)list.remove(0);
		this.companys=list;
		return "list";
	}
	
	public String tograntlimit(){
		this.company=Server.getInstance().getCompanyService().findCompany(company.getId());
		String where=" WHERE CHARINDEX(',1,',','+C_PARENTSTR+',')>0";
		limits=Server.getInstance().getMemberService().findAllSystemright(where, "ORDER BY C_ORDERID", -1, 0);
		 where=" WHERE ID IN (SELECT C_RIGHTID FROM T_B2GCOMLIMIT WHERE C_COMID="+company.getId()+" )";
		rolelimits=Server.getInstance().getMemberService().findAllSystemright(where, "ORDER BY C_ORDERID", -1, 0);
		
		return "grant";
	}
	
	public String grant(){
		ServletRequest request=ServletActionContext.getRequest();
		String[] limits=request.getParameterValues("limit");
		List<Comlimit> list=new ArrayList<Comlimit>();
		if(limits.length>0){
			for(String str:limits){
				Comlimit cl=new Comlimit();
				cl.setRightid(Long.valueOf(str));
				cl.setComid(company.getId());
				list.add(cl);
			}
		}
		Server.getInstance().getCompanyService().grantComlimit(list,company.getId());
		return this.companys();
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getSipactbgtime() {
		return sipactbgtime;
	}
	public void setSipactbgtime(String sipactbgtime) {
		this.sipactbgtime = sipactbgtime;
	}
	public String getSipactendtime() {
		return sipactendtime;
	}
	public void setSipactendtime(String sipactendtime) {
		this.sipactendtime = sipactendtime;
	}
	public List<Company> getCompanys() {
		return companys;
	}
	public void setCompanys(List<Company> companys) {
		this.companys = companys;
	}
	public List<Systemright> getLimits() {
		return limits;
	}
	public void setLimits(List<Systemright> limits) {
		this.limits = limits;
	}
	public List<Systemright> getRolelimits() {
		return rolelimits;
	}
	public void setRolelimits(List<Systemright> rolelimits) {
		this.rolelimits = rolelimits;
	}

}
