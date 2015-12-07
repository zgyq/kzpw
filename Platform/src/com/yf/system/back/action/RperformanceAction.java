/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.department.Department;
import com.yf.system.base.rperformance.Rperformance;
import com.yf.system.base.util.PageInfo;


public class RperformanceAction extends B2b2cbackAction {
	private List <  Rperformance  >  listRperformance;
	private Rperformance rperformance = new Rperformance();
	private List<Department> listDepartment;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String i_date;
	private String treestr="";
	
	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

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
	
	/**
	 * 列表查询绩效合约统计
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Rperformance.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllRperformanceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRperformance = list;
		  if(pageinfo.getTotalrow()>0 &&   listRperformance.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllRperformanceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRperformance = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到绩效合约统计添加页面
	 */	
	public String toadd()throws Exception{
		getString(-1);
		return EDIT;
	}
	/**
	 * 转向到绩效合约统计修改页面
	 */	
	public String toedit()throws Exception{
		getString(-1);
		rperformance = Server.getInstance().getAirService().findRperformance(rperformance.getId());
	i_date=formatTimestampyyyyMM(rperformance.getDatetime());
		return EDIT;
	}
	
	/**
	 * 转向到绩效合约统计审核页面
	 */	
	public String tocheck()throws Exception{
	rperformance = Server.getInstance().getAirService().findRperformance(rperformance.getId());
		return CHECK;
	}
	
	public String getContentitemName(long id){
		return Server.getInstance().getMemberService().findDepartment(id).getName();
	}
	
	/**
	 * 添加绩效合约统计
	 */		
	public String add()throws Exception{
		rperformance.setDatetime(dateToTimestampyyyyMM(i_date));
		String sql=" where "+Rperformance.COL_department+" = "+rperformance.getDepartment()+" and "+Rperformance.COL_datetime+" = '"+rperformance.getDatetime()+"'";
		System.out.println(sql);
		List<Rperformance> list=Server.getInstance().getAirService().findAllRperformance(sql, "", -1, 0);
		if(list!=null&&list.size()>0)
		{
			this.addFieldError("error", "时间已经存在！");
			getString(-1);
			return EDIT;
		}
		Server.getInstance().getAirService().createRperformance(rperformance);
		return LIST;
	}

	/**
	 * 审核绩效合约统计
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateRperformanceIgnoreNull(rperformance);
		return LIST;
	}
	


	/**
	 * 编辑绩效合约统计
	 */		
	public String edit()throws Exception{
		rperformance.setDatetime(dateToTimestampyyyyMM(i_date));
		String sql=" where "+Rperformance.COL_department+" = "+rperformance.getDepartment()+" and "+Rperformance.COL_datetime+" = '"+rperformance.getDatetime()+"'";
		System.out.println(sql);
		List<Rperformance> list=Server.getInstance().getAirService().findAllRperformance(sql, "", -1, 0);
		if(list!=null&&list.size()>0)
		{
			this.addFieldError("error", "时间已经存在！");
			getString(-1);
			return EDIT;
		}
		Server.getInstance().getAirService().updateRperformanceIgnoreNull(rperformance);
		return LIST;
	}

	/**
	 * 删除绩效合约统计
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteRperformance(rperformance.getId());
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
					Server.getInstance().getAirService().deleteRperformance(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回绩效合约统计对象
	 */		
	
	public Object getModel() {
		return rperformance;
	}
	public List < Rperformance >   getListRperformance() {
		return listRperformance;
	}
	public void setListRperformance(List <  Rperformance  >  listRperformance) {
		this.listRperformance = listRperformance;
	}
	public Rperformance getRperformance() {
		return rperformance;
	}
	public void setRperformance(Rperformance rperformance) {
		this.rperformance = rperformance;
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
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	public List<Department> getListDepartment() {
		return listDepartment;
	}
	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	
	
}