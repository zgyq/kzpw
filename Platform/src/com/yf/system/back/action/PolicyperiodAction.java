/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.policyperiod.Policyperiod;


public class PolicyperiodAction extends B2b2cbackAction {
	private List <  Policyperiod  >  listPolicyperiod;
	private Policyperiod policyperiod = new Policyperiod();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询政策有效期表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Policyperiod.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllPolicyperiodForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPolicyperiod = list;
		  if(pageinfo.getTotalrow()>0 &&   listPolicyperiod.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllPolicyperiodForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPolicyperiod = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到政策有效期表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到政策有效期表修改页面
	 */	
	public String toedit()throws Exception{
	policyperiod = Server.getInstance().getAirService().findPolicyperiod(policyperiod.getId());
		return EDIT;
	}
	
	/**
	 * 转向到政策有效期表审核页面
	 */	
	public String tocheck()throws Exception{
	policyperiod = Server.getInstance().getAirService().findPolicyperiod(policyperiod.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加政策有效期表
	 */		
	public String add()throws Exception{
	policyperiod.setCreateuser(getLoginUser().getLoginname());
		policyperiod.setCreatetime(new Timestamp(System.currentTimeMillis()));
		policyperiod.setModifyuser(getLoginUser().getLoginname());
		policyperiod.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createPolicyperiod(policyperiod);
		return LIST;
	}

	/**
	 * 审核政策有效期表
	 */		
	public String check()throws Exception{
	policyperiod.setModifyuser(getLoginUser().getLoginname());
		policyperiod.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updatePolicyperiodIgnoreNull(policyperiod);
		return LIST;
	}
	


	/**
	 * 编辑政策有效期表
	 */		
	public String edit()throws Exception{
	policyperiod.setModifyuser(getLoginUser().getLoginname());
		policyperiod.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updatePolicyperiodIgnoreNull(policyperiod);
		return LIST;
	}

	/**
	 * 删除政策有效期表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deletePolicyperiod(policyperiod.getId());
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
					Server.getInstance().getAirService().deletePolicyperiod(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回政策有效期表对象
	 */		
	
	public Object getModel() {
		return policyperiod;
	}
	public List < Policyperiod >   getListPolicyperiod() {
		return listPolicyperiod;
	}
	public void setListPolicyperiod(List <  Policyperiod  >  listPolicyperiod) {
		this.listPolicyperiod = listPolicyperiod;
	}
	public Policyperiod getPolicyperiod() {
		return policyperiod;
	}
	public void setPolicyperiod(Policyperiod policyperiod) {
		this.policyperiod = policyperiod;
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