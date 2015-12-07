package com.yf.b2b2g.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.base.systemrole.Systemrole;



/**
*
* 开发人：hanmenghui
* 开发日期：2012-01-14
* 功能说明：企业员工
*
*/
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Department department;

	/** ID */
	private long id;
	
	
	/** 中文姓名 */
	private String username;
	
	/** 英文姓名 */
	private String ename;
	
	/** 性别:男女 */
	private String sexval;
	
	/** 性别1：男。0：女 */
	private int sex=-1;
	
	/** 生日*/
	private Timestamp birthday;
	
	/** 电话号码*/
	private String phone;
	
	/** 邮箱*/
	private String emile;
	
	/** 联系电话*/
	private String connecttel;
	
	private long comid;
	
	/** 部门*/
	private long deptid;
	
	/** 职位*/
	private String job;
	
	/** 成本中心*/
	private long costcenterid;
	
	/** 员工编号*/
	private String accountno;
	
	
	/** 登录名*/
	private String loginname;
	
	
	/** 密码*/
	private String password;
	
	/** 角色*/
	private List<Role> roles;
	
	/** 证件*/
	private List<Certificate> certlist;
	
	/** 账户状态：0：冻结。1：正常*/
	private int accountstate=-1;
	
	private String accountstatestr;
	
	/**是否审批。0：否。1：是*/
	private int isapprove=-1;
	
	public String approve;
	
	
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getSexval() {
		if(this.sex==0){
			return "女";
		}
		return "男";
	}



	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public Timestamp getBirthday() {
		return birthday;
	}


	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmile() {
		return emile;
	}


	public void setEmile(String emile) {
		this.emile = emile;
	}


	public String getConnecttel() {
		return connecttel;
	}


	public void setConnecttel(String connecttel) {
		this.connecttel = connecttel;
	}


	public long getDeptid() {
		return deptid;
	}


	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public long getCostcenterid() {
		return costcenterid;
	}


	public void setCostcenterid(long costcenterid) {
		this.costcenterid = costcenterid;
	}


	public String getAccountno() {
		return accountno;
	}


	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}


	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public long getComid() {
		return comid;
	}


	public void setComid(long comid) {
		this.comid = comid;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<Certificate> getCertlist() {
		return certlist;
	}


	public void setCertlist(List<Certificate> certlist) {
		this.certlist = certlist;
		
		
	}


	public int getAccountstate() {
		return accountstate;
	}


	public void setAccountstate(int accountstate) {
		this.accountstate = accountstate;
	}


	public String getAccountstatestr() {
		if(this.accountstate==0){
			return "冻结";
		}
		return "正常";
	}


	public int getIsapprove() {
		return isapprove;
	}


	public void setIsapprove(int isapprove) {
		this.isapprove = isapprove;
	}


	public String getApprove() {
		if(this.isapprove==1){
			return "是";
		}
		return "否";
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	

}
