/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.util.PageInfo;


public class DepartmentAction extends B2b2cbackAction {
	private List <Department>  listDepartment;
	private Department department = new Department();
	private List<Customeragent> listCustomeragent;
	
	//批量操作ID数组
	
	private int[]selectid;
	private String treestr="";
	//批量操作选项
	private int opt;
	private long agid;
	public String getContentitemName(long id){
		return Server.getInstance().getMemberService().findDepartment(id).getName();
	}
	
	//search
	//private String s_name;
	private String departmentname;
	
	private void getString(long id){
		List<  Department  > list = Server.getInstance().getMemberService().findAllDepartment("where "+Department.COL_parentid+" ="+id+" and "+Department.COL_agentid+" ="+getLoginUser().getAgentid() ,"ORDER BY ID",-1,0);
		if(!list.isEmpty()){
		
			for(Department m :list){
				if(id==-1){
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ m.getName() +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ m.getName() +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
				
				}
				getString(m.getId());
			}
		}
	}
	private void biggetString(long id){//大客户部门
		List<  Department  > list = Server.getInstance().getMemberService().findAllDepartment("where "+Department.COL_parentid+" ="+id+" and "+Department.COL_agentid+" ="+agid ,"ORDER BY ID",-1,0);
		if(!list.isEmpty()){
		
			for(Department m :list){
				if(id==-1){
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ m.getName() +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ m.getName() +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
				
				}
				biggetString(m.getId());
			}
		}
	}
	private void getString2(long id,long did){
		List<  Department  > list = Server.getInstance().getMemberService().findAllDepartment("where "+Department.COL_id+" !="+did+" and "+Department.COL_parentid+ " = "+ id+" and "+Department.COL_agentid+" ="+getLoginUser().getAgentid() ,"ORDER BY ID",-1,0);
		if(!list.isEmpty()){
			
			for(Department m :list){
				if(id==-1){
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ m.getName() +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					
					
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ m.getName() +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
					
				
				}
				getString2(m.getId(),did);
			}
		}
	}
	/**
	 * 列表查询部门
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 and "+Department.COL_agentid+" ="+getLoginUser().getAgentid();
		
		if (departmentname!=null && departmentname.trim().length()!=0) {
			
			where += " and " + Department.COL_name +" like '%" + departmentname.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getMemberService().findAllDepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listDepartment = list;
		  if(pageinfo.getTotalrow()>0 &&   listDepartment.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllDepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listDepartment = list;
		}
		Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
		if(customeragent.getUserid()!=null){
		Customeruser customeruser = Server.getInstance().getMemberService().findCustomeruser(customeragent.getUserid());
		}
		return SUCCESS;
	}
	public String tobiglist()throws Exception{
		String where = " where 1=1 and "+Department.COL_agentid+" ="+agid;
		
		if (departmentname!=null && departmentname.trim().length()!=0) {
			
			where += " and " + Department.COL_name +" like '%" + departmentname.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getMemberService().findAllDepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listDepartment = list;
		  if(pageinfo.getTotalrow()>0 &&   listDepartment.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllDepartmentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listDepartment = list;
		}
		
		return "biglist";
	}
	/**
	 * 转向到部门添加页面
	 */	
	public String toadd()throws Exception{
		getString(-1l);
		return EDIT;
	}
	public String toaddbig()throws Exception{
		biggetString(-1l);
		return "bigedit";
	}
	public String tobig()throws Exception{
		Customeragent customeragent = Server.getInstance().getMemberService().findCustomeragent(getLoginUser().getAgentid());
		if(customeragent.getUserid()!=null){
		Customeruser customeruser = Server.getInstance().getMemberService().findCustomeruser(customeragent.getUserid());
		}
		//listCustomeragent = Server.getInstance().getMemberService().findAllCustomeragent(" where 1=1 and "+Customeragent.COL_bigtype+" =1 and "+Customeragent.COL_userid+" ="+getLoginUserId(), "", -1, 0);
		
		//更改内容:可以添加其他大客户的部门
		//更改人:sunbin
		String where=" where 1=1 and "+Customeragent.COL_bigtype+" =1 and "+Customeragent.COL_id+" <>46";
	//han 修改
		if(!isAdmin()&&this.getLoginUser().getType()!=1){
			where +=" and "+Customeragent.COL_id+" = "+this.getLoginUser().getAgentid();
		}
		listCustomeragent = Server.getInstance().getMemberService().findAllCustomeragent(where, "", -1, 0);
		return "tobig";
	}
	/**
	 * 转向到部门修改页面
	 */	
	public String toedit()throws Exception{
		//getString(-1l);
	department = Server.getInstance().getMemberService().findDepartment(department.getId());
	getString2(-1l,department.getId());
		return EDIT;
	}
	public String toeditbig()throws Exception{
		//getString(-1l);
	department = Server.getInstance().getMemberService().findDepartment(department.getId());
	biggetString(-1l);
		return "bigedit";
	}
	
	/**
	 * 转向到部门审核页面
	 */	
	public String tocheck()throws Exception{
	department = Server.getInstance().getMemberService().findDepartment(department.getId());
		return CHECK;
	}
	public String getDeptName(Long id) throws Exception
	{
		String strName="";
		department = Server.getInstance().getMemberService().findDepartment(id);
		if(department!=null)
		{
			strName=department.getName();
		}
		else if(id==-1)
		{
			strName="无";
		}
		return strName;
	}
	
	/**
	 * 添加部门
	 */		
	public String add()throws Exception{
		department.setAgentid(getLoginUser().getAgentid());
		if(department.getParentid()==null){
			department.setParentid(-1l);
			
			
		}
		Server.getInstance().getMemberService().createDepartment(department);
		return LIST;
	}
	public String addbig()throws Exception{
		department.setAgentid(agid);
		if(department.getParentid()==null){
			department.setParentid(-1l);
			
			
		}
		Server.getInstance().getMemberService().createDepartment(department);
		return "addbig";
	}
	/**
	 * 审核部门
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateDepartmentIgnoreNull(department);
		return LIST;
	}
	


	/**
	 * 编辑部门
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateDepartmentIgnoreNull(department);
		return LIST;
	}
	/**
	 * 编辑大客户部门
	 */		
	public String editbig()throws Exception{
	
		Server.getInstance().getMemberService().updateDepartmentIgnoreNull(department);
		return "addbig";
	}

	/**
	 * 删除部门
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteDepartment(department.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getMemberService().deleteDepartment(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回部门对象
	 */		
	
	public Object getModel() {
		return department;
	}
	public List < Department >   getListDepartment() {
		return listDepartment;
	}
	public void setListDepartment(List <  Department  >  listDepartment) {
		this.listDepartment = listDepartment;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}
	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}
	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}
	public long getAgid() {
		return agid;
	}
	public void setAgid(long agid) {
		this.agid = agid;
	}

	
	
}