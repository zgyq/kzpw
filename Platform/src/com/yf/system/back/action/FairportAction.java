/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fairport.Fairport;
import com.yf.system.base.util.PageInfo;


public class FairportAction extends B2b2cbackAction {
	private List <  Fairport  >  listFairport;
	private Fairport fairport = new Fairport();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票机场
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fairport.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFairportForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFairport = list;
		  if(pageinfo.getTotalrow()>0 &&   listFairport.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFairportForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFairport = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票机场添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票机场修改页面
	 */	
	public String toedit()throws Exception{
	fairport = Server.getInstance().getInterticketService().findFairport(fairport.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票机场审核页面
	 */	
	public String tocheck()throws Exception{
	fairport = Server.getInstance().getInterticketService().findFairport(fairport.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票机场
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFairport(fairport);
		return LIST;
	}

	/**
	 * 审核国际机票机场
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFairportIgnoreNull(fairport);
		return LIST;
	}
	


	/**
	 * 编辑国际机票机场
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFairportIgnoreNull(fairport);
		return LIST;
	}

	/**
	 * 删除国际机票机场
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFairport(fairport.getId());
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
					Server.getInstance().getInterticketService().deleteFairport(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票机场对象
	 */		
	
	public Object getModel() {
		return fairport;
	}
	public List < Fairport >   getListFairport() {
		return listFairport;
	}
	public void setListFairport(List <  Fairport  >  listFairport) {
		this.listFairport = listFairport;
	}
	public Fairport getFairport() {
		return fairport;
	}
	public void setFairport(Fairport fairport) {
		this.fairport = fairport;
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