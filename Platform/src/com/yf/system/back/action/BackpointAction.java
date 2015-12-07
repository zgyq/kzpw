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
import com.yf.system.base.backpoint.Backpoint;


public class BackpointAction extends B2b2cbackAction {
	private List <  Backpoint  >  listBackpoint;
	private Backpoint backpoint = new Backpoint();
	
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询隐扣设置
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Backpoint.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllBackpointForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listBackpoint = list;
		  if(pageinfo.getTotalrow()>0 &&   listBackpoint.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllBackpointForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listBackpoint = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到隐扣设置添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到隐扣设置修改页面
	 */	
	public String toedit()throws Exception{
	backpoint = Server.getInstance().getAirService().findBackpoint(backpoint.getId());
		return EDIT;
	}
	
	/**
	 * 转向到隐扣设置审核页面
	 */	
	public String tocheck()throws Exception{
	backpoint = Server.getInstance().getAirService().findBackpoint(backpoint.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加隐扣设置
	 */		
	public String add()throws Exception{
	backpoint.setCreateuser(getLoginUser().getLoginname());
		backpoint.setCreatetime(new Timestamp(System.currentTimeMillis()));
		backpoint.setModifyuser(getLoginUser().getLoginname());
		backpoint.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createBackpoint(backpoint);
		return LIST;
	}

	/**
	 * 审核隐扣设置
	 */		
	public String check()throws Exception{
	backpoint.setModifyuser(getLoginUser().getLoginname());
		backpoint.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateBackpointIgnoreNull(backpoint);
		return LIST;
	}
	


	/**
	 * 编辑隐扣设置
	 */		
	public String edit()throws Exception{
	backpoint.setModifyuser(getLoginUser().getLoginname());
		backpoint.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateBackpointIgnoreNull(backpoint);
		return LIST;
	}

	/**
	 * 删除隐扣设置
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteBackpoint(backpoint.getId());
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
					Server.getInstance().getAirService().deleteBackpoint(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回隐扣设置对象
	 */		
	
	public Object getModel() {
		return backpoint;
	}
	public List < Backpoint >   getListBackpoint() {
		return listBackpoint;
	}
	public void setListBackpoint(List <  Backpoint  >  listBackpoint) {
		this.listBackpoint = listBackpoint;
	}
	public Backpoint getBackpoint() {
		return backpoint;
	}
	public void setBackpoint(Backpoint backpoint) {
		this.backpoint = backpoint;
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