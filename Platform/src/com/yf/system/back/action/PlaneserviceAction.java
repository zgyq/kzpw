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
import com.yf.system.base.planeservice.Planeservice;
import com.yf.system.base.util.PageInfo;


public class PlaneserviceAction extends B2b2cbackAction {
	private List <  Planeservice  >  listPlaneservice;
	private Planeservice planeservice = new Planeservice();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询包机服务
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Planeservice.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllPlaneserviceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPlaneservice = list;
		  if(pageinfo.getTotalrow()>0 &&   listPlaneservice.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllPlaneserviceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPlaneservice = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到包机服务添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到包机服务修改页面
	 */	
	public String toedit()throws Exception{
	planeservice = Server.getInstance().getMemberService().findPlaneservice(planeservice.getId());
		return EDIT;
	}
	
	/**
	 * 转向到包机服务审核页面
	 */	
	public String tocheck()throws Exception{
	planeservice = Server.getInstance().getMemberService().findPlaneservice(planeservice.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加包机服务
	 */		
	public String add()throws Exception{
	planeservice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createPlaneservice(planeservice);
		return LIST;
	}

	/**
	 * 审核包机服务
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updatePlaneserviceIgnoreNull(planeservice);
		return LIST;
	}
	


	/**
	 * 编辑包机服务
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updatePlaneserviceIgnoreNull(planeservice);
		return LIST;
	}

	/**
	 * 删除包机服务
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deletePlaneservice(planeservice.getId());
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
					Server.getInstance().getMemberService().deletePlaneservice(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回包机服务对象
	 */		
	
	public Object getModel() {
		return planeservice;
	}
	public List < Planeservice >   getListPlaneservice() {
		return listPlaneservice;
	}
	public void setListPlaneservice(List <  Planeservice  >  listPlaneservice) {
		this.listPlaneservice = listPlaneservice;
	}
	public Planeservice getPlaneservice() {
		return planeservice;
	}
	public void setPlaneservice(Planeservice planeservice) {
		this.planeservice = planeservice;
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