/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.insuruser.Insuruser;
import com.yf.system.base.util.PageInfo;


public class InsuruserAction extends B2b2cbackAction {
	private List <  Insuruser  >  listInsuruser;
	private Insuruser insuruser = new Insuruser();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询被保人列表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Insuruser.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInsuruser = list;
		  if(pageinfo.getTotalrow()>0 &&   listInsuruser.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsuruserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInsuruser = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到被保人列表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到被保人列表修改页面
	 */	
	public String toedit()throws Exception{
	insuruser = Server.getInstance().getAirService().findInsuruser(insuruser.getId());
		return EDIT;
	}
	
	/**
	 * 转向到被保人列表审核页面
	 */	
	public String tocheck()throws Exception{
	insuruser = Server.getInstance().getAirService().findInsuruser(insuruser.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加被保人列表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createInsuruser(insuruser);
		return LIST;
	}

	/**
	 * 审核被保人列表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateInsuruserIgnoreNull(insuruser);
		return LIST;
	}
	


	/**
	 * 编辑被保人列表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateInsuruserIgnoreNull(insuruser);
		return LIST;
	}

	/**
	 * 删除被保人列表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteInsuruser(insuruser.getId());
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
					Server.getInstance().getAirService().deleteInsuruser(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回被保人列表对象
	 */		
	
	public Object getModel() {
		return insuruser;
	}
	public List < Insuruser >   getListInsuruser() {
		return listInsuruser;
	}
	public void setListInsuruser(List <  Insuruser  >  listInsuruser) {
		this.listInsuruser = listInsuruser;
	}
	public Insuruser getInsuruser() {
		return insuruser;
	}
	public void setInsuruser(Insuruser insuruser) {
		this.insuruser = insuruser;
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