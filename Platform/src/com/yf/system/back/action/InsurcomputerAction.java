/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.insurcomputer.Insurcomputer;
import com.yf.system.base.util.PageInfo;


public class InsurcomputerAction extends B2b2cbackAction {
	private List <  Insurcomputer  >  listInsurcomputer;
	private Insurcomputer insurcomputer = new Insurcomputer();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询保险服务公司信息表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Insurcomputer.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllInsurcomputerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInsurcomputer = list;
		  if(pageinfo.getTotalrow()>0 &&   listInsurcomputer.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsurcomputerForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInsurcomputer = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到保险服务公司信息表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到保险服务公司信息表修改页面
	 */	
	public String toedit()throws Exception{
	insurcomputer = Server.getInstance().getAirService().findInsurcomputer(insurcomputer.getId());
		return EDIT;
	}
	
	/**
	 * 转向到保险服务公司信息表审核页面
	 */	
	public String tocheck()throws Exception{
	insurcomputer = Server.getInstance().getAirService().findInsurcomputer(insurcomputer.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加保险服务公司信息表
	 */		
	public String add()throws Exception{
	insurcomputer.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createInsurcomputer(insurcomputer);
		return LIST;
	}

	/**
	 * 审核保险服务公司信息表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateInsurcomputerIgnoreNull(insurcomputer);
		return LIST;
	}
	


	/**
	 * 编辑保险服务公司信息表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateInsurcomputerIgnoreNull(insurcomputer);
		return LIST;
	}

	/**
	 * 删除保险服务公司信息表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteInsurcomputer(insurcomputer.getId());
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
					Server.getInstance().getAirService().deleteInsurcomputer(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回保险服务公司信息表对象
	 */		
	
	public Object getModel() {
		return insurcomputer;
	}
	public List < Insurcomputer >   getListInsurcomputer() {
		return listInsurcomputer;
	}
	public void setListInsurcomputer(List <  Insurcomputer  >  listInsurcomputer) {
		this.listInsurcomputer = listInsurcomputer;
	}
	public Insurcomputer getInsurcomputer() {
		return insurcomputer;
	}
	public void setInsurcomputer(Insurcomputer insurcomputer) {
		this.insurcomputer = insurcomputer;
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
	
	
}